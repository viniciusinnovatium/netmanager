//*****************************************************************************
//** TASC - ALPHALINC - MAC COMViewUtils
//** Innovatium Systems - Code Converter - v1.30
//** 2014-06-13 16:35:52
//*****************************************************************************

import mLibrary.*;

//<< 
//<< #include WWWConst
import include.WWWConst;
import include.COMSYS;
//<< #include COMConst
import include.COMConst;
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

//<< COMViewUtils
public class COMViewUtils extends mClass {

  public void main() {
    _COMViewUtils();
  }

  public void _COMViewUtils() {
  }

  //<< 
  //<< ;-------------------------------------------------------------------------------
  //<< ;  Routines to make sure that COMView runs smoothly.
  //<< ;-------------------------------------------------------------------------------
  //<< 
  //<< CallBack(pstrRoutine,pstrParams)
  public Object CallBack(Object ... _p) {
    mVar pstrRoutine = m$.newVarRef("pstrRoutine",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pstrParams = m$.newVarRef("pstrParams",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Call Cache Code that have been requested to be run via hyper events
    //<< ;
    //<< ; Params:
    //<< ; pstrRoutine - Extrinsic Cache Code
    //<< ; pstrParams - Parameters to Cache Code
    //<< ;
    //<< ; Returns: $$$OK
    //<< ;
    //<< ; History:
    //<< ; 05-Sep-2012   shobby  SR18082: if YBED is missing try and get it from %request
    //<< ; 21-Jun-2011   shobby  SRAdhoc: Display the event if in Debug2 mode.
    //<< ; 14-Nov-2007   GRF     SR15612: Relocate debug to simplify CallBack
    //<< ; 01-Jun-2007   RGB     SRBR014493: Customization relations weren't being checked
    //<< ;                           under "GetRelation". Fixed.
    //<< ; 21-Mar-2007   PO      SR15483: Check whether code is allowed to be executed
    //<< ;-------------------------------------------------------------------------------
    //<< new ParamLoop,strExecute,strParam
    mVar ParamLoop = m$.var("ParamLoop");
    mVar strExecute = m$.var("strExecute");
    mVar strParam = m$.var("strParam");
    m$.newVar(ParamLoop,strExecute,strParam);
    //<< 
    //<< if $$AllowExecution^WWWEVENTUtils(pstrRoutine,pstrParams) { // Check whether this is allowed to be run
    if (mOp.Logical(m$.fnc$("WWWEVENTUtils.AllowExecution",pstrRoutine.get(),pstrParams.get()))) {
      //<< // Cache call back code
      //<< set strExecute = "do "_pstrRoutine_"("
      strExecute.set(mOp.Concat(mOp.Concat("do ",pstrRoutine.get()),"("));
      //<< 
      //<< if pstrParams'="#NoParam#" {
      if (mOp.NotEqual(pstrParams.get(),"#NoParam#")) {
        //<< for ParamLoop=1:1:$length(pstrParams,"~") {
        for (ParamLoop.set(1);(mOp.LessOrEqual(ParamLoop.get(),m$.Fnc.$length(pstrParams.get(),"~")));ParamLoop.set(mOp.Add(ParamLoop.get(),1))) {
          //<< if ParamLoop'=1 set strExecute=strExecute_","
          if (mOp.NotEqual(ParamLoop.get(),1)) {
            strExecute.set(mOp.Concat(strExecute.get(),","));
          }
          //<< set strParam   = $$DoubleQuotes^COMUtilStr($piece(pstrParams,"~",ParamLoop))
          strParam.set(m$.fnc$("COMUtilStr.DoubleQuotes",m$.Fnc.$piece(pstrParams.get(),"~",ParamLoop.get())));
          //<< set strExecute = strExecute_$$QuoteString(strParam)
          strExecute.set(mOp.Concat(strExecute.get(),m$.fnc$("QuoteString",strParam.get())));
        }
      }
      //<< }
      //<< }
      //<< set strExecute = strExecute_")"
      strExecute.set(mOp.Concat(strExecute.get(),")"));
      //<< 
      //<< if $get(^Debug1) {
      if (mOp.Logical(m$.Fnc.$get(m$.var("^Debug1")))) {
        //<< do Log(strExecute)                  ; SR15612
        m$.Cmd.Do("Log",strExecute.get());
      }
      //<< } else {
      else {
        //<< ;SR18082 if $get(^Debug2(YBED)) $$$Alert(strExecute)
        //<< if $get(YBED)="" {                                                              ;SR18082
        if (mOp.Equal(m$.Fnc.$get(m$.var("YBED")),"")) {
          //<< new YBED        ; Avoid any side effects                                    ;SR18082
          mVar YBED = m$.var("YBED");
          m$.newVar(YBED);
          //<< set YBED = $get(%request.Data("YBED",1))                                    ;SR18082
          YBED.set(m$.Fnc.$get(m$.getRequest().varData("YBED",1)));
        }
        //<< }
        //<< if (($get(YBED) '= "") && ($get(^Debug2(YBED)))) $$$Alert(strExecute)           ;SR18082
        if (mOp.Logical(((mOp.NotEqual(m$.Fnc.$get(m$.var("YBED")),"")) && mOp.Logical((m$.Fnc.$get(m$.var("^Debug2",m$.var("YBED").get()))))))) {
          include.COMSYS.$$$Alert(m$,strExecute);
        }
        //<< xecute strExecute        // FIXME : Use instead ? do ExecuteCode^COMUtils(strExecute)
        m$.Cmd.Xecute(strExecute.get());
      }
    }
    //<< }
    //<< }
    //<< 
    //<< quit $$$OK
    return include.COMSYS.$$$OK(m$);
  }

  //<< 
  //<< // <MAXNUMBER> on values with more than 310 digits
  //<< QuoteString(pstrParam)
  public Object QuoteString(Object ... _p) {
    mVar pstrParam = m$.newVarRef("pstrParam",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< new strValue
    mVar strValue = m$.var("strValue");
    m$.newVar(strValue);
    //<< 
    //<< set $ztrap = "exceptionQuoteString"
    mVar $ztrap = m$.var("$ztrap");
    $ztrap.set("exceptionQuoteString");
    //<< set strValue = $$$Add(pstrParam)
    strValue.set(include.COMSYS.$$$Add(m$,pstrParam));
    //<< set $ztrap = ""
    $ztrap.set("");
    //<< goto finallyQuoteString   
    return m$.Cmd.Goto("finallyQuoteString");// TODO REVISAR RETORNO DO GOTO ESPERADO E ESTAVA RETORNANDO NULL
  }

  //<< 
  //<< exceptionQuoteString
  public void exceptionQuoteString() {
    //<< set $ztrap = ""
    mVar $ztrap = m$.var("$ztrap");
    $ztrap.set("");
    //<< set strValue = """"_pstrParam_""""
    mVar strValue = m$.var("strValue");
    strValue.set(mOp.Concat(mOp.Concat("\"",m$.var("pstrParam").get()),"\""));
    finallyQuoteString();
  }

  //<< 
  //<< finallyQuoteString
  public Object finallyQuoteString() {
    //<< quit strValue
    return m$.var("strValue").get();
  }

  //<< 
  //<< Log(strExecute) private
  public Object Log(Object ... _p) {
    mVar strExecute = m$.newVarRef("strExecute",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; History:
    //<< ; 14-Nov-2007   GRF     SR15612: Relocate debug to simplify CallBack
    //<< ;-------------------------------------------------------------------------------
    //<< new io,ipio,Line,LineCount
    mVar io = m$.var("io");
    mVar ipio = m$.var("ipio");
    mVar Line = m$.var("Line");
    mVar LineCount = m$.var("LineCount");
    m$.newVar(io,ipio,Line,LineCount);
    //<< 
    //<< set ipio = $io
    ipio.set(m$.Fnc.$io());
    //<< set io   = "COMView"_YUSER_".txt"
    io.set(mOp.Concat(mOp.Concat("COMView",m$.var("YUSER").get()),".txt"));
    //<< open io:"wns":0
    m$.Cmd.Open(io.get(),"wns",0);
    //<< use io
    m$.Cmd.Use(io.get());
    //<< xecute strExecute              // FIXME : Use instead ? do ExecuteCode^COMUtils(strExecute)
    m$.Cmd.Xecute(strExecute.get());
    //<< close io
    m$.Cmd.Close(io.get());
    //<< open io:"rs":0 //else  use ipio
    m$.Cmd.Open(io.get(),"rs",0);
    //<< do $ZUTIL(68,40,1)
    m$.Fnc.$zutil(68,40,1);
    //<< write !,"var t=new Date();"
    m$.Cmd.Write("\n","var t=new Date();");
    //<< set LineCount=0
    LineCount.set(0);
    //<< for {
    for (;true;) {
      //<< use io
      m$.Cmd.Use(io.get());
      //<< quit:$zeof=-1
      if (mOp.Equal(m$.Fnc.$zeof(),mOp.Negative(1))) {
        break;
      }
      //<< 
      //<< read Line
      m$.Cmd.Read(Line);
      //<< use ipio
      m$.Cmd.Use(ipio.get());
      //<< write !,Line
      m$.Cmd.Write("\n",Line.get());
      //<< write !,"var n=new Date();"
      m$.Cmd.Write("\n","var n=new Date();");
      //<< write !,"CallBackTime[CallBackTime.Current].Line["_LineCount_"]='"_$zcvt(Line,"o","JS")_"';"
      m$.Cmd.Write("\n",mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("CallBackTime[CallBackTime.Current].Line[",LineCount.get()),"]='"),m$.Fnc.$zconvert(Line.get(),"o","JS")),"';"));
      //<< write !,"CallBackTime[CallBackTime.Current].LineTime["_LineCount_"]=((n-t)/1000);"
      m$.Cmd.Write("\n",mOp.Concat(mOp.Concat("CallBackTime[CallBackTime.Current].LineTime[",LineCount.get()),"]=((n-t)/1000);"));
      //<< write !,"t=n;"
      m$.Cmd.Write("\n","t=n;");
      //<< set LineCount = LineCount+1
      LineCount.set(mOp.Add(LineCount.get(),1));
    }
    //<< }
    //<< use ipio
    m$.Cmd.Use(ipio.get());
    //<< close io
    m$.Cmd.Close(io.get());
    //<< do $ZUTIL(140,5,io) ; Remove File
    m$.Fnc.$zutil(140,5,io.get());
    //<< 
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< CompileTest(pblnForce=0)
  public Object CompileTest(Object ... _p) {
    mVar pblnForce = m$.newVarRef("pblnForce",(((_p!=null)&&(_p.length>=1))?_p[0]:null),0);
    //<< ;-------------------------------------------------------------------------------
    //<< ; Check to make sure that all @net classes are compiled correctly.
    //<< ;
    //<< ; History:
    //<< ; 17-Feb-2005   Paul K  Added code to compile not up-to-date classes.
    //<< ; 07-Dec-2004   Paul K  Created  (SR#11081)
    //<< ;-------------------------------------------------------------------------------
    //<< new idClass,strError
    mVar idClass = m$.var("idClass");
    mVar strError = m$.var("strError");
    m$.newVar(idClass,strError);
    //<< 
    //<< set idClass = ""
    idClass.set("");
    //<< for {
    for (;true;) {
      //<< set idClass = $order(^WWW001(0,idClass))
      idClass.set(m$.Fnc.$order(m$.var("^WWW001",0,idClass.get())));
      //<< quit:idClass=""
      if (mOp.Equal(idClass.get(),"")) {
        break;
      }
      //<< 
      //<< if $extract(idClass,1,3)'="OBS" {
      if (mOp.NotEqual(m$.Fnc.$extract(idClass.get(),1,3),"OBS")) {
        //<< if ('##Class(%Dictionary.CompiledClass).%ExistsId("User."_idClass))||(pblnForce) {
        if ((mOp.Not(m$.fnc$("$Dictionary.CompiledClass.$ExistsId",mOp.Concat("User.",idClass.get())))) || mOp.Logical((pblnForce.get()))) {
          //<< do CompileAtNet(idClass)
          m$.Cmd.Do("CompileAtNet",idClass.get());
        }
        //<< }
        //<< kill strError
        strError.kill();
        //<< set strError=""
        strError.set("");
        //<< if '##Class(%Dictionary.CompiledClass).%ExistsId("User."_idClass) {
        if (mOp.Not(m$.fnc$("$Dictionary.CompiledClass.$ExistsId",mOp.Concat("User.",idClass.get())))) {
          //<< write !,idClass_" not compiled by @net correctly"
          m$.Cmd.Write("\n",mOp.Concat(idClass.get()," not compiled by @net correctly"));
        }
        //<< } elseif '$$Compile(idClass,.strError) {
        else if (mOp.Not(m$.fnc$("Compile",idClass.get(),strError))) {
          //<< write !,idClass_" not compiled by cache. Reason:"_strError(1)
          m$.Cmd.Write("\n",mOp.Concat(mOp.Concat(idClass.get()," not compiled by cache. Reason:"),strError.var(1).get()));
        }
        //<< } else {
        else {
          //<< write !,idClass_" OK."
          m$.Cmd.Write("\n",mOp.Concat(idClass.get()," OK."));
        }
      }
    }
    //<< }
    //<< }
    //<< }
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< Compile(pidClass,pstrError)
  public Object Compile(Object ... _p) {
    mVar pidClass = m$.newVarRef("pidClass",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pstrError = m$.newVarRef("pstrError",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Just a wrapper for the compiler so it doesn't spit out HTML to the screen.
    //<< ;
    //<< ; History:
    //<< ; 01-Dec-2004   Paul K  Created
    //<< ;-------------------------------------------------------------------------------
    //<< new ipio,io,blnSuccess
    mVar ipio = m$.var("ipio");
    mVar io = m$.var("io");
    mVar blnSuccess = m$.var("blnSuccess");
    m$.newVar(ipio,io,blnSuccess);
    //<< 
    //<< set ipio = $io
    ipio.set(m$.Fnc.$io());
    //<< set io   = "Dummy.txt"
    io.set("Dummy.txt");
    //<< open io:"wns":0 //else  write "failed"
    m$.Cmd.Open(io.get(),"wns",0);
    //<< set %ZCS("USE_PORT")="U """_io_""""
    m$.var("%ZCS","USE_PORT").set(mOp.Concat(mOp.Concat("U \"",io.get()),"\""));
    //<< use io
    m$.Cmd.Use(io.get());
    //<< set blnSuccess = $$Compile^%apiOBJ("User."_pidClass,"u",.pstrError)
    blnSuccess.set(m$.fnc$("$apiOBJ.Compile",mOp.Concat("User.",pidClass.get()),"u",pstrError));
    //<< close io
    m$.Cmd.Close(io.get());
    //<< use ipio
    m$.Cmd.Use(ipio.get());
    //<< set %ZCS("USE_PORT")="U """_ipio_""""
    m$.var("%ZCS","USE_PORT").set(mOp.Concat(mOp.Concat("U \"",ipio.get()),"\""));
    //<< 
    //<< do $ZUTIL(68,40,1)
    m$.Fnc.$zutil(68,40,1);
    //<< do $ZUTIL(140,5,io) ; Remove File
    m$.Fnc.$zutil(140,5,io.get());
    //<< 
    //<< quit blnSuccess
    return blnSuccess.get();
  }

  //<< 
  //<< 
  //<< CompileAtNet(pidClass)
  public Object CompileAtNet(Object ... _p) {
    mVar pidClass = m$.newVarRef("pidClass",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Just a wrapper for the compiler so it doesn't spit out HTML to the screen.
    //<< ;
    //<< ; History:
    //<< ; 21-Jul-2009   PPP     SR16757:Compile without display
    //<< ; 01-Dec-2004   Paul K  Created
    //<< ;-------------------------------------------------------------------------------
    //<< new ipio,io
    mVar ipio = m$.var("ipio");
    mVar io = m$.var("io");
    m$.newVar(ipio,io);
    //<< 
    //<< set ipio = $io
    ipio.set(m$.Fnc.$io());
    //<< set io   = "Dummy.txt"
    io.set("Dummy.txt");
    //<< open io:"wns":0 //else  write "failed"
    m$.Cmd.Open(io.get(),"wns",0);
    //<< set %ZCS("USE_PORT")="U """_io_""""
    m$.var("%ZCS","USE_PORT").set(mOp.Concat(mOp.Concat("U \"",io.get()),"\""));
    //<< use io
    m$.Cmd.Use(io.get());
    //<< do COMPILE^WWW001OO(pidClass,$$$YES)
    m$.Cmd.Do("WWW001OO.COMPILE",pidClass.get(),include.COMSYS.$$$YES(m$));
    //<< close io
    m$.Cmd.Close(io.get());
    //<< use ipio
    m$.Cmd.Use(ipio.get());
    //<< set %ZCS("USE_PORT")="U """_ipio_""""
    m$.var("%ZCS","USE_PORT").set(mOp.Concat(mOp.Concat("U \"",ipio.get()),"\""));
    //<< do $ZUTIL(68,40,1)
    m$.Fnc.$zutil(68,40,1);
    //<< do $ZUTIL(140,5,io) ; Remove File
    m$.Fnc.$zutil(140,5,io.get());
    //<< 
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< SuperUser()
  public Object SuperUser() {
    //<< ;-------------------------------------------------------------------------------
    //<< ; Check if the current user is a Super User
    //<< ;
    //<< ;
    //<< ; History:
    //<< ; 22-Jul-2013   shobby  CORE-188: System Administrator should be a SuperUser regardless
    //<< ;                                 of any other type selected as SuperUser
    //<< ; 10-Sep-2012   SCR     SR18112: Super User Clas user definable
    //<< ;-------------------------------------------------------------------------------
    //<< 
    //<< new blnSuper
    mVar blnSuper = m$.var("blnSuper");
    m$.newVar(blnSuper);
    //<< ; SR18112 vvvvvv
    //<< ;set blnSuper = $$$NO
    //<< 
    //<< ;if $find(";"_$$$WWW013UserAccess($get(^WWW013(0,YBED,1)))_";",";1;") {
    //<< ;   set blnSuper = $$$YES
    //<< ;}
    //<< ;for i=1:1:100 h 1
    //<< set objCOMViewConfig     = $get(^COMViewConfig(0,YM,1))
    mVar objCOMViewConfig = m$.var("objCOMViewConfig");
    objCOMViewConfig.set(m$.Fnc.$get(m$.var("^COMViewConfig",0,m$.var("YM").get(),1)));
    //<< set strSuperUserClass    = $$$COMViewConfigSuperUser(objCOMViewConfig)
    mVar strSuperUserClass = m$.var("strSuperUserClass");
    strSuperUserClass.set(include.COMConst.$$$COMViewConfigSuperUser(m$,objCOMViewConfig));
    //<< ;CORE-188 set:strSuperUserClass="" strSuperUserClass=1
    //<< if strSuperUserClass="" {                               ;CORE-188
    if (mOp.Equal(strSuperUserClass.get(),"")) {
      //<< set strSuperUserClass=1                             ;CORE-188
      strSuperUserClass.set(1);
    }
    //<< } else {                                                ;CORE-188
    else {
      //<< set strSuperUserClass=strSuperUserClass_";1"        ;CORE-188
      strSuperUserClass.set(mOp.Concat(strSuperUserClass.get(),";1"));
    }
    //<< }                                                       ;CORE-188
    //<< set blnSuper = $$UserHasAccess^COMUtils(YBED,strSuperUserClass,,$$$NO)
    blnSuper.set(m$.fnc$("COMUtils.UserHasAccess",m$.var("YBED").get(),strSuperUserClass.get(),null,include.COMSYS.$$$NO(m$)));
    //<< ; SR18112 ^^^^^^
    //<< 
    //<< quit blnSuper
    return blnSuper.get();
  }

  //<< 
  //<< 
  //<< GetRelation(&pidClass,&pstrField,&pidForm="",pstrKeyCode="",pblnDisplayModeOnly=$$$NO)
  public Object GetRelation(Object ... _p) {
    mVar pidClass = m$.newVarRef("pidClass",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pstrField = m$.newVarRef("pstrField",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pidForm = m$.newVarRef("pidForm",(((_p!=null)&&(_p.length>=3))?_p[2]:null),"");
    mVar pstrKeyCode = m$.newVarRef("pstrKeyCode",(((_p!=null)&&(_p.length>=4))?_p[3]:null),"");
    mVar pblnDisplayModeOnly = m$.newVarRef("pblnDisplayModeOnly",(((_p!=null)&&(_p.length>=5))?_p[4]:null),include.COMSYS.$$$NO(m$));
    //<< ;-------------------------------------------------------------------------------
    //<< ; fields are stored like "P1" and "D8" where P means primary key and "D" means data field
    //<< ;
    //<< ; Note:The class definition of WWW002 and WWW003 are currently the same, and
    //<< ; are used interchangably in this code.
    //<< ;
    //<< ; Inputs:   pidClass,
    //<< ;           pstrField,
    //<< ;           pidForm,
    //<< ;           pstrKeyCode,
    //<< ;           pblnDisplayModeOnly - If $$$YES, will skip processing not needed for display calls.
    //<< ;
    //<< ; Note. "M" fields are translated from the form definition.
    //<< ;
    //<< ; Returns:@Net object (WWW002/WWW003)
    //<< ;
    //<< ; History:
    //<< ; 02-Jul-2009   PPP     SR16663: Add the Calculated Relation Display Fields
    //<< ; 23-Feb-2009   shobby  SR16386:    Support Currency in calculated fields.
    //<< ; 19-Feb-2008   shobby  SRBR014900: If Piece2 of pstrField starts with a C get the pidForm from pidClass
    //<< ; 14-Feb-2008   shobby  SRBR014895: Removed previous change.  Prevented displaying of search form.
    //<< ;                                   Only been 3 days but I don't remember why I thought it was needed.
    //<< ;                                   Should it have been 'AssociatedWithField'
    //<< ; 11-Feb-2008   shobby  SRBR014895: If a relation class is used to populate the data field with
    //<< ;                                   a field of the relation class and not the primary key then
    //<< ;                                   we want to ignore the reference.
    //<< ; 08-Jan-2008   GRF     SRBR014855: Don't call PopulateFileListing when a File
    //<< ;                           Type field already has a relation defined.
    //<< ; 19-Nov-2007   shobby  SRBR014751: More detailed information about the relation
    //<< ;                           can be obtained when the form is known (customisation)
    //<< ; 23-Nov-2007   GRF     BR014790: Show &params based on .params when called.
    //<< ; 21-Nov-2007   GRF     BR014790: Causing problems - reverted with some changes
    //<< ;                           incorporated - 20-Nov code retained as comment.
    //<< ;                           Use index 4 rather than 5 for efficiency.
    //<< ;                           idFormField already used elsewhere - used for "D"
    //<< ;                           processing as clearer why idField is changed.
    //<< ;                           ChangeInputAs line not restored as this was a bug.
    //<< ; 20-Nov-2007   shobby  BR014790: idField pass to $Get routine needs to be
    //<< ;                           translated from the class field to the form field.
    //<< ; 19-Nov-2007   shobby  BR014790: Use standard routine to get WWW122 information.
    //<< ; 03-Aug-2006   SC      SR14871: Speedup - Skip processing not used by display calls.
    //<< ; 23-Sep-2005   shobby  SR13213: Special code to handle sort by for Calculated fields.
    //<< ; 20-Sep-2005   JW      SR13536: Also check form data input type.
    //<< ;  5-Sep-2005   JW      SR13411: Moved call inside if statement.
    //<< ; 24-Aug-2005   JW      SR12876: File fields
    //<< ; 18-May-2005   Paul K  Ensured KeyCode was either "D" or "P", not "C"
    //<< ; 11-May-2005   Paul K  Return KeyCode as parameter SR:12199
    //<< ; 10-May-2005   Paul K  Added support for change input as
    //<< ; 07-Feb-2005   PO      SR10965 Adding support for related classes.
    //<< ; 30-Nov-2004   Paul K  Created
    //<< ;-------------------------------------------------------------------------------
    //<< new objRelation,objForm,idField,KeyCode,idClass,idNextFields,strPiece2,strPiece3,FieldType,idForm
    mVar objRelation = m$.var("objRelation");
    mVar objForm = m$.var("objForm");
    mVar idField = m$.var("idField");
    mVar KeyCode = m$.var("KeyCode");
    mVar idClass = m$.var("idClass");
    mVar idNextFields = m$.var("idNextFields");
    mVar strPiece2 = m$.var("strPiece2");
    mVar strPiece3 = m$.var("strPiece3");
    mVar FieldType = m$.var("FieldType");
    mVar idForm = m$.var("idForm");
    m$.newVar(objRelation,objForm,idField,KeyCode,idClass,idNextFields,strPiece2,strPiece3,FieldType,idForm);
    //<< new idFormField,objCalculated,idxClass
    mVar idFormField = m$.var("idFormField");
    mVar objCalculated = m$.var("objCalculated");
    mVar idxClass = m$.var("idxClass");
    m$.newVar(idFormField,objCalculated,idxClass);
    //<< 
    //<< set objRelation=""
    objRelation.set("");
    //<< 
    //<< ; FIXME : <GRF> see BR014790 pidForm may be set to the first form associated with pidclass
    //<< ;               e.g. Class INLP is associated with forms INFIBLP and INLP
    //<< ;                    pidForm gets set to "INFIBLP"
    //<< ;               This may or may not have implications below.
    //<< 
    //<< if pidForm="" set pidForm = $get(^CacheTempView(YUSER,"Form"))  ;BR014790
    if (mOp.Equal(pidForm.get(),"")) {
      pidForm.set(m$.Fnc.$get(m$.var("^CacheTempView",m$.var("YUSER").get(),"Form")));
    }
    //<< 
    //<< if pstrField'="Custom" {
    if (mOp.NotEqual(pstrField.get(),"Custom")) {
      //<< if $extract($piece(pstrField,".",2))="C" {
      if (mOp.Equal(m$.Fnc.$extract(m$.Fnc.$piece(pstrField.get(),".",2)),"C")) {
        //<< set idNextFields =""
        idNextFields.set("");
        //<< set strPiece2    = $piece(pstrField,".",2)
        strPiece2.set(m$.Fnc.$piece(pstrField.get(),".",2));
        //<< set strPiece3    = $piece(pstrField,".",3)
        strPiece3.set(m$.Fnc.$piece(pstrField.get(),".",3));
        //<< set pstrKeyCode  = $extract(strPiece3,1)
        pstrKeyCode.set(m$.Fnc.$extract(strPiece3.get(),1));
        //<< set idClass      = $extract(strPiece2,2,99)
        idClass.set(m$.Fnc.$extract(strPiece2.get(),2,99));
        //<< set FieldType    = $extract(strPiece3)
        FieldType.set(m$.Fnc.$extract(strPiece3.get()));
        //<< set idField      = $extract(strPiece3,2,99)
        idField.set(m$.Fnc.$extract(strPiece3.get(),2,99));
        //<< set pidForm      = idClass
        pidForm.set(idClass.get());
      }
      //<< 
      //<< } else {
      else {
        //<< set idNextFields = $piece(pstrField,".",2,99)
        idNextFields.set(m$.Fnc.$piece(pstrField.get(),".",2,99));
        //<< set pstrField    = $piece(pstrField,".",1)
        pstrField.set(m$.Fnc.$piece(pstrField.get(),".",1));
        //<< set pstrKeyCode  = $extract(pstrField,1)
        pstrKeyCode.set(m$.Fnc.$extract(pstrField.get(),1));
        //<< set idField      = $extract(pstrField,2,99)
        idField.set(m$.Fnc.$extract(pstrField.get(),2,99));
        //<< set idClass      = pidClass
        idClass.set(pidClass.get());
      }
      //<< }
      //<< 
      //<< if idField'="" {
      if (mOp.NotEqual(idField.get(),"")) {
        //<< if pstrKeyCode="C" {
        if (mOp.Equal(pstrKeyCode.get(),"C")) {
          //<< set objRelation   = ""
          objRelation.set("");
          //<< set objCalculated = $get(^WWW003Calc(0,idClass,idField,1))
          objCalculated.set(m$.Fnc.$get(m$.var("^WWW003Calc",0,idClass.get(),idField.get(),1)));
          //<< set $$$WWW002InputType(objRelation) = 6
          include.WWWConst.$$$WWW002InputTypeSet(m$,objRelation,6);
          //<< if $$$WWW003CalcDataType(objCalculated)="%Boolean"  set $$$WWW002InputType(objRelation) = 2
          if (mOp.Equal(include.WWWConst.$$$WWW003CalcDataType(m$,objCalculated),"%Boolean")) {
            include.WWWConst.$$$WWW002InputTypeSet(m$,objRelation,2);
          }
          //<< if $$$WWW003CalcDataType(objCalculated)="%Float"    set $$$WWW002InputType(objRelation) = 12
          if (mOp.Equal(include.WWWConst.$$$WWW003CalcDataType(m$,objCalculated),"%Float")) {
            include.WWWConst.$$$WWW002InputTypeSet(m$,objRelation,12);
          }
          //<< if $$$WWW003CalcDataType(objCalculated)="%Currency" set $$$WWW002InputType(objRelation) = 8
          if (mOp.Equal(include.WWWConst.$$$WWW003CalcDataType(m$,objCalculated),"%Currency")) {
            include.WWWConst.$$$WWW002InputTypeSet(m$,objRelation,8);
          }
          //<< ;More data types required here eventually
          //<< if $$$WWW002PropertyName(objRelation)="" set $$$WWW002PropertyName(objRelation) = $$$WWW003CalcFieldName(objCalculated)
          if (mOp.Equal(include.WWWConst.$$$WWW002PropertyName(m$,objRelation),"")) {
            include.WWWConst.$$$WWW002PropertyNameSet(m$,objRelation,include.WWWConst.$$$WWW003CalcFieldName(m$,objCalculated));
          }
          //<< if (+$$$WWWClientParamCoreChangesALL($get(^WWWClientParam(YM,YM,1)))) {
          if (mOp.Logical((mOp.Positive(include.WWWConst.$$$WWWClientParamCoreChangesALL(m$,m$.Fnc.$get(m$.var("^WWWClientParam",m$.var("YM").get(),m$.var("YM").get(),1))))))) {
            //<< if $LENGTH($$$WWW003CalcRelationClass(objCalculated)) > 0 set $$$WWW002RelationClass(objRelation) = $$$WWW003CalcRelationClass(objCalculated)
            if (mOp.Greater(m$.Fnc.$length(include.WWWConst.$$$WWW003CalcRelationClass(m$,objCalculated)),0)) {
              include.WWWConst.$$$WWW002RelationClassSet(m$,objRelation,include.WWWConst.$$$WWW003CalcRelationClass(m$,objCalculated));
            }
          }
        }
        //<< }
        //<< 
        //<< } else {
        else {
          //<< if idClass'="" {
          if (mOp.NotEqual(idClass.get(),"")) {
            //<< if pstrKeyCode="P" set objRelation = $get(^WWW002(0,idClass,idField,1))
            if (mOp.Equal(pstrKeyCode.get(),"P")) {
              objRelation.set(m$.Fnc.$get(m$.var("^WWW002",0,idClass.get(),idField.get(),1)));
            }
            //<< if pstrKeyCode="D" set objRelation = $get(^WWW003(0,idClass,idField,1))
            if (mOp.Equal(pstrKeyCode.get(),"D")) {
              objRelation.set(m$.Fnc.$get(m$.var("^WWW003",0,idClass.get(),idField.get(),1)));
            }
          }
          //<< }
          //<< 
          //<< if pidForm'="" {
          if (mOp.NotEqual(pidForm.get(),"")) {
            //<< if pstrKeyCode="M" {
            if (mOp.Equal(pstrKeyCode.get(),"M")) {
              //<< ;       1. pstrField is passed in as P#, D#, or M#
              //<< ;          *ONLY* D# needs to be converted from a class field number to a form field number
              //<< ;          "P" fields are the same in Class and Form and not applicable here.
              //<< ;          "M" fields do not have a Sequence Number (WWW122 D1)
              //<< ;
              //<< ;       2. Sequence Number (WWW122 D1) is indexed as 4 and 5.2 (5.1 being P1)
              //<< ;          Index 4 has the format ^WWW122s(0,4,ClassField,pidForm,FormField)
              //<< ;          Index 5 has the format ^WWW122s(0,5,$$$Index(pidForm),ClassField,pidForm,FormField)
              //<< ;          Index 4 should be faster - fixed here and 5 changed to 4 below
              //<< set objForm = $$Get^WWW122(pidForm,idField)
              objForm.set(m$.fnc$("WWW122.Get",pidForm.get(),idField.get()));
              //<< set $$$WWW002InputType(objRelation)              = $$$WWW122InputType(objForm)
              include.WWWConst.$$$WWW002InputTypeSet(m$,objRelation,include.WWWConst.$$$WWW122InputType(m$,objForm));
              //<< set $$$WWW002RelationClass(objRelation)          = $$$WWW122RelationClass(objForm)
              include.WWWConst.$$$WWW002RelationClassSet(m$,objRelation,include.WWWConst.$$$WWW122RelationClass(m$,objForm));
              //<< set $$$WWW002RelationalPrimaryKeys(objRelation)  = $$$WWW122RelationalPrimaryKey(objForm)
              include.WWWConst.$$$WWW002RelationalPrimaryKeysSet(m$,objRelation,include.WWWConst.$$$WWW122RelationalPrimaryKey(m$,objForm));
              //<< set $$$WWW002RelationalDisplayItems(objRelation) = $$$WWW122RelationalDataField(objForm)
              include.WWWConst.$$$WWW002RelationalDisplayItemsSet(m$,objRelation,include.WWWConst.$$$WWW122RelationalDataField(m$,objForm));
              //<< set $$$WWW002CalcRelationalDisplayItems(objRelation) = $$$WWW122CalcRelationalDataField(objForm)    //SR16663
              include.WWWConst.$$$WWW002CalcRelationalDisplayItemsSet(m$,objRelation,include.WWWConst.$$$WWW122CalcRelationalDataField(m$,objForm));
              //<< set $$$WWW002DisplayIfSortKeyEqual(objRelation)  = $$$WWW122DisplayIfSortCodes(objForm)
              include.WWWConst.$$$WWW002DisplayIfSortKeyEqualSet(m$,objRelation,include.WWWConst.$$$WWW122DisplayIfSortCodes(m$,objForm));
            }
            //<< 
            //<< } elseif pstrKeyCode="D" {
            else if (mOp.Equal(pstrKeyCode.get(),"D")) {
              //<< ; convert class field number to form field number
              //<< set idFormField = $order(^WWW122s(0,4,idField,pidForm,""))
              idFormField.set(m$.Fnc.$order(m$.var("^WWW122s",0,4,idField.get(),pidForm.get(),"")));
              //<< if idFormField'="" {
              if (mOp.NotEqual(idFormField.get(),"")) {
                //<< set objForm = $$Get^WWW122(pidForm,idFormField)
                objForm.set(m$.fnc$("WWW122.Get",pidForm.get(),idFormField.get()));
                //<< if $$$WWW122InputType(objForm)'=""               set $$$WWW002InputType(objRelation)              = $$$WWW122InputType(objForm)
                if (mOp.NotEqual(include.WWWConst.$$$WWW122InputType(m$,objForm),"")) {
                  include.WWWConst.$$$WWW002InputTypeSet(m$,objRelation,include.WWWConst.$$$WWW122InputType(m$,objForm));
                }
                //<< if $$$WWW122DisplayIfSortCodes(objForm)'=""      set $$$WWW002DisplayIfSortKeyEqual(objRelation)  = $$$WWW122DisplayIfSortCodes(objForm)
                if (mOp.NotEqual(include.WWWConst.$$$WWW122DisplayIfSortCodes(m$,objForm),"")) {
                  include.WWWConst.$$$WWW002DisplayIfSortKeyEqualSet(m$,objRelation,include.WWWConst.$$$WWW122DisplayIfSortCodes(m$,objForm));
                }
                //<< if $$$WWW122RelationClass(objForm)'=""           set $$$WWW002RelationClass(objRelation)          = $$$WWW122RelationClass(objForm)
                if (mOp.NotEqual(include.WWWConst.$$$WWW122RelationClass(m$,objForm),"")) {
                  include.WWWConst.$$$WWW002RelationClassSet(m$,objRelation,include.WWWConst.$$$WWW122RelationClass(m$,objForm));
                }
                //<< if $$$WWW122RelationalPrimaryKey(objForm)'=""    set $$$WWW002RelationalPrimaryKeys(objRelation)  = $$$WWW122RelationalPrimaryKey(objForm)
                if (mOp.NotEqual(include.WWWConst.$$$WWW122RelationalPrimaryKey(m$,objForm),"")) {
                  include.WWWConst.$$$WWW002RelationalPrimaryKeysSet(m$,objRelation,include.WWWConst.$$$WWW122RelationalPrimaryKey(m$,objForm));
                }
                //<< if $$$WWW122RelationalDataField(objForm)'=""     set $$$WWW002RelationalDisplayItems(objRelation) = $$$WWW122RelationalDataField(objForm)
                if (mOp.NotEqual(include.WWWConst.$$$WWW122RelationalDataField(m$,objForm),"")) {
                  include.WWWConst.$$$WWW002RelationalDisplayItemsSet(m$,objRelation,include.WWWConst.$$$WWW122RelationalDataField(m$,objForm));
                }
                //<< if $$$WWW122CalcRelationalDataField(objForm)'="" set $$$WWW002CalcRelationalDisplayItems(objRelation) = $$$WWW122RelationalDataField(objForm)   //SR16663
                if (mOp.NotEqual(include.WWWConst.$$$WWW122CalcRelationalDataField(m$,objForm),"")) {
                  include.WWWConst.$$$WWW002CalcRelationalDisplayItemsSet(m$,objRelation,include.WWWConst.$$$WWW122RelationalDataField(m$,objForm));
                }
              }
            }
            //<< }
            //<< }
            //<< 
            //<< ; FIXME : <GRF> (noted on BR014790 but appears not due to that Service Request)
            //<< ;    if any field as a column on the COMViewSearch being used is set to
            //<< ;    "File Name" it will build ^CacheTempView(YUSER,"AppendValue") which will
            //<< ;    subsequently be prepended to the result of the search.
            //<< ;    This option is apparently intended to provide a means of performing a file
            //<< ;    directory listing rather than reacting as it does.
            //<< 
            //<< ;if $$$WWW002InputType(objRelation)=10 { //SR12876: Show file listing   // SR13411
            //<< 
            //<< ;---------------------------------------
            //<< ; FIXME : <GRF> The PopulateFileListing process is called for EVERY line in a
            //<< ;               COMView table.  It kills and re-creates ^COMDirectoryListing
            //<< ;               for the source directory as a means of validating filenames
            //<< ;               but this validation is not needed during COMView display of
            //<< ;               records based on other data which merely includes data of file
            //<< ;               type (class 10 or form 9).
            //<< ;
            //<< ;               NOTE : Class D2 applies to both WWW002 and WWW003 but Form D2
            //<< ;                      is WWW122 (it is D104 in WWW121).
            //<< ;
            //<< ;               It also replaces the Relation type, losing any connection to the
            //<< ;               original relation which may be a parameter list containing the
            //<< ;               file names as data.
            //<< ;
            //<< ;               This type of validation should be used to build a list of valid
            //<< ;               filename entries for selection where the field being searched is
            //<< ;               itself the file type data.
            //<< ;
            //<< ;               If used, the ^COMDirectoryListing global should only be
            //<< ;               refreshed at the beginning of a validation cycle.
            //<< ;               i.e.
            //<< ;                  1.    Start Validation of File type data
            //<< ;                  2.    Kill ^COMDirectoryListing for path
            //<< ;                  3.    Build ^COMDirectoryListing for path
            //<< ;                  4.    Apply possible filtering to COMDirectoryListing
            //<< ;                  5.    Use "COMDirectoryListing" as relation for
            //<< ;                    a)  Initial list of files
            //<< ;               or   b)  Validating entered filenames - possibly over multiple
            //<< ;                        records.
            //<< ;
            //<< ;               NOTE : PopulateFileListing updates objRelation to show the
            //<< ;                      relation based on the created ^COMDirectoryListing.
            //<< ;
            //<< ;               NOTE : The call to $$GetDirectory^WWWUploadDirectory will return
            //<< ;                      the standard FTP directory by default if there is no
            //<< ;                      entry in ^WWWUploadDirectory for the form or module.
            //<< ;                      This does not consider where a relation may already exist
            //<< ;                      such as INLP D1 "Graphic Allocation" which is based on
            //<< ;                      the image files already stored in ^WWW101(0,"BELEGUNG").
            //<< ;                      In those cases we should NOT be calling
            //<< ;                      PopulateFileListing.
            //<< ;---------------------------------------
            //<< 
            //<< if ($$$WWW002InputType(objRelation)=10) || ($$$WWW122DataInputType($get(objForm))=9) {
            if ((mOp.Equal(include.WWWConst.$$$WWW002InputType(m$,objRelation),10)) || (mOp.Equal(include.WWWConst.$$$WWW122DataInputType(m$,m$.Fnc.$get(objForm)),9))) {
              //<< if $$$WWW002RelationClass(objRelation) = "" {
              if (mOp.Equal(include.WWWConst.$$$WWW002RelationClass(m$,objRelation),"")) {
                //<< do PopulateFileListing(pidForm,.objRelation)
                m$.Cmd.Do("PopulateFileListing",pidForm.get(),objRelation);
              }
            }
          }
          //<< }
          //<< }
          //<< 
          //<< } else {                                       ; when pidForm=""
          else {
            //<< if 'pblnDisplayModeOnly {
            if (mOp.Not(pblnDisplayModeOnly.get())) {
              //<< set idxClass = $$$Index(idClass)
              idxClass.set(include.MEDConst.$$$Index(m$,idClass));
              //<< set idForm   = ""
              idForm.set("");
              //<< for {
              for (;true;) {
                //<< set idForm = $order(^WWW120s(0,1,idxClass,idForm))
                idForm.set(m$.Fnc.$order(m$.var("^WWW120s",0,1,idxClass.get(),idForm.get())));
                //<< quit:idForm=""
                if (mOp.Equal(idForm.get(),"")) {
                  break;
                }
                //<< 
                //<< if pstrKeyCode="D" {
                if (mOp.Equal(pstrKeyCode.get(),"D")) {
                  //<< set idFormField = $order(^WWW122s(0,4,idField,idForm,""))
                  idFormField.set(m$.Fnc.$order(m$.var("^WWW122s",0,4,idField.get(),idForm.get(),"")));
                  //<< if idFormField'="" {
                  if (mOp.NotEqual(idFormField.get(),"")) {
                    //<< set objForm = $get(^WWW122(0,idForm,idField,1))
                    objForm.set(m$.Fnc.$get(m$.var("^WWW122",0,idForm.get(),idField.get(),1)));
                    //<< if $$$WWW122ChangeInputAs(objForm)'="" set $$$WWW122ChangeInputAs(objRelation) = $$$WWW122ChangeInputAs(objForm)
                    if (mOp.NotEqual(include.WWWConst.$$$WWW122ChangeInputAs(m$,objForm),"")) {
                      include.WWWConst.$$$WWW122ChangeInputAsSet(m$,objRelation,include.WWWConst.$$$WWW122ChangeInputAs(m$,objForm));
                    }
                  }
                }
                //<< }
                //<< } elseif pstrKeyCode="P" {
                else if (mOp.Equal(pstrKeyCode.get(),"P")) {
                  //<< set objForm = $get(^WWW121(0,idForm,idField,1))
                  objForm.set(m$.Fnc.$get(m$.var("^WWW121",0,idForm.get(),idField.get(),1)));
                  //<< if $$$WWW122ChangeInputAs(objForm)'=""     set $$$WWW122ChangeInputAs(objRelation) = $$$WWW122ChangeInputAs(objForm)
                  if (mOp.NotEqual(include.WWWConst.$$$WWW122ChangeInputAs(m$,objForm),"")) {
                    include.WWWConst.$$$WWW122ChangeInputAsSet(m$,objRelation,include.WWWConst.$$$WWW122ChangeInputAs(m$,objForm));
                  }
                }
                //<< }
                //<< quit:$$$WWW122ChangeInputAs(objRelation)'=""
                if (mOp.NotEqual(include.WWWConst.$$$WWW122ChangeInputAs(m$,objRelation),"")) {
                  break;
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
      //<< if ($extract($piece(pstrField,".",2))'="C") &&
      //<< (idNextFields'="")                       &&
      //<< ($$$WWW002RelationClass(objRelation)'="")   {
      if ((mOp.NotEqual(m$.Fnc.$extract(m$.Fnc.$piece(pstrField.get(),".",2)),"C")) && (mOp.NotEqual(idNextFields.get(),"")) && (mOp.NotEqual(include.WWWConst.$$$WWW002RelationClass(m$,objRelation),""))) {
        //<< set pidClass    = $$$WWW002RelationClass(objRelation)
        pidClass.set(include.WWWConst.$$$WWW002RelationClass(m$,objRelation));
        //<< set pidForm     = pidClass  ; If drilling down further always assume the form and class are the same.   FIXME : is this valid?
        pidForm.set(pidClass.get());
        //<< set pstrField   = idNextFields
        pstrField.set(idNextFields.get());
        //<< set objRelation = $$GetRelation(.pidClass,.pstrField,.pidForm,.pstrKeyCode)
        objRelation.set(m$.fnc$("GetRelation",pidClass,pstrField,pidForm,pstrKeyCode));
      }
      //<< 
      //<< } elseif $extract($piece(pstrField,".",2))="C" {
      else if (mOp.Equal(m$.Fnc.$extract(m$.Fnc.$piece(pstrField.get(),".",2)),"C")) {
        //<< set pidClass  = idClass
        pidClass.set(idClass.get());
        //<< set pstrField = strPiece3
        pstrField.set(strPiece3.get());
      }
    }
    //<< }
    //<< }
    //<< quit objRelation
    return objRelation.get();
  }

  //<< 
  //<< 
  //<< FindRelation(pidClass,pstrRelation,pidKey)
  public Object FindRelation(Object ... _p) {
    mVar pidClass = m$.newVarRef("pidClass",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pstrRelation = m$.newVarRef("pstrRelation",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pidKey = m$.newVarRef("pidKey",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Used to find unknown relational primary keys.
    //<< ;
    //<< ; History:
    //<< ; 21-Apr-2008   shobby  SR16485: Do more intensive search to find relations by
    //<< ;                           looking at all forms related to a class and include
    //<< ;                           this class as well.
    //<< ; 09-Dec-2004   Paul K  Created
    //<< ;-------------------------------------------------------------------------------
    //<< new blnFound,intNumKeys,KeyLoop,objKey,idForm,idFormKey,strGlobal
    mVar blnFound = m$.var("blnFound");
    mVar intNumKeys = m$.var("intNumKeys");
    mVar KeyLoop = m$.var("KeyLoop");
    mVar objKey = m$.var("objKey");
    mVar idForm = m$.var("idForm");
    mVar idFormKey = m$.var("idFormKey");
    mVar strGlobal = m$.var("strGlobal");
    m$.newVar(blnFound,intNumKeys,KeyLoop,objKey,idForm,idFormKey,strGlobal);
    //<< new idFormField,objField,Loop,idClass,intCompany,idClassRel
    mVar idFormField = m$.var("idFormField");
    mVar objField = m$.var("objField");
    mVar Loop = m$.var("Loop");
    mVar idClass = m$.var("idClass");
    mVar intCompany = m$.var("intCompany");
    mVar idClassRel = m$.var("idClassRel");
    m$.newVar(idFormField,objField,Loop,idClass,intCompany,idClassRel);
    //<< 
    //<< set blnFound = $$$NO
    blnFound.set(include.COMSYS.$$$NO(m$));
    //<< 
    //<< if (pidClass'="") && (pidKey'="") {
    if ((mOp.NotEqual(pidClass.get(),"")) && (mOp.NotEqual(pidKey.get(),""))) {
      //<< set intNumKeys = $order(^WWW002(0,pidClass,""),-1)
      intNumKeys.set(m$.Fnc.$order(m$.var("^WWW002",0,pidClass.get(),""),mOp.Negative(1)));
      //<< for KeyLoop=intNumKeys:-1:1 {
      for (KeyLoop.set(intNumKeys.get());(mOp.GreaterOrEqual(KeyLoop.get(),1));KeyLoop.set(mOp.Add(KeyLoop.get(),-1))) {
        //<< quit:blnFound
        if (mOp.Logical(blnFound.get())) {
          break;
        }
        //<< 
        //<< set objKey = $get(^WWW002(0,pidClass,KeyLoop,1))
        objKey.set(m$.Fnc.$get(m$.var("^WWW002",0,pidClass.get(),KeyLoop.get(),1)));
        //<< if $$$WWW002RelationClass(objKey)'="" {
        if (mOp.NotEqual(include.WWWConst.$$$WWW002RelationClass(m$,objKey),"")) {
          //<< set idClassRel = $$$WWW002RelationClass(objKey)
          idClassRel.set(include.WWWConst.$$$WWW002RelationClass(m$,objKey));
          //<< for idClass = idClassRel,pidClass {
          for (Object _idClass: new Object[] {idClassRel.get(),pidClass.get()}) {
            idClass.set(_idClass);
            //<< quit:blnFound
            if (mOp.Logical(blnFound.get())) {
              break;
            }
            //<< 
            //<< set idForm = ""
            idForm.set("");
            //<< for {
            for (;true;) {
              //<< set idForm = $order(^WWW120s(0,1,$$$Index(idClass),idForm)) ;SR16485
              idForm.set(m$.Fnc.$order(m$.var("^WWW120s",0,1,include.MEDConst.$$$Index(m$,_idClass),idForm.get())));
              //<< quit:blnFound
              if (mOp.Logical(blnFound.get())) {
                break;
              }
              //<< quit:idForm=""
              if (mOp.Equal(idForm.get(),"")) {
                break;
              }
              //<< 
              //<< set idFormKey = ""
              idFormKey.set("");
              //<< for {
              for (;true;) {
                //<< set idFormKey = $order(^WWW121(0,idForm,idFormKey))
                idFormKey.set(m$.Fnc.$order(m$.var("^WWW121",0,idForm.get(),idFormKey.get())));
                //<< quit:idFormKey=""
                if (mOp.Equal(idFormKey.get(),"")) {
                  break;
                }
                //<< quit:blnFound
                if (mOp.Logical(blnFound.get())) {
                  break;
                }
                //<< 
                //<< if pstrRelation=$$$WWW122InputInVariable($get(^WWW121(0,idForm,idFormKey,1))) {
                if (mOp.Equal(pstrRelation.get(),include.WWWConst.$$$WWW122InputInVariable(m$,m$.Fnc.$get(m$.var("^WWW121",0,idForm.get(),idFormKey.get(),1))))) {
                  //<< set @pstrRelation = $piece(pidKey,",",idFormKey)
                  m$.indirectVar(pstrRelation.get()).set(m$.Fnc.$piece(pidKey.get(),",",idFormKey.get()));
                  //<< set blnFound      = $$$YES
                  blnFound.set(include.COMSYS.$$$YES(m$));
                }
              }
              //<< }
              //<< }
              //<< set idFormField = ""
              idFormField.set("");
              //<< for {
              for (;true;) {
                //<< set idFormField = $order(^WWW122(0,idForm,idFormField))
                idFormField.set(m$.Fnc.$order(m$.var("^WWW122",0,idForm.get(),idFormField.get())));
                //<< quit:idFormField=""
                if (mOp.Equal(idFormField.get(),"")) {
                  break;
                }
                //<< quit:blnFound
                if (mOp.Logical(blnFound.get())) {
                  break;
                }
                //<< 
                //<< set objField = $get(^WWW122(0,idForm,idFormField,1))
                objField.set(m$.Fnc.$get(m$.var("^WWW122",0,idForm.get(),idFormField.get(),1)));
                //<< if pstrRelation=$$$WWW122InputInVariable(objField) {
                if (mOp.Equal(pstrRelation.get(),include.WWWConst.$$$WWW122InputInVariable(m$,objField))) {
                  //<< set blnFound   = $$$YES
                  blnFound.set(include.COMSYS.$$$YES(m$));
                  //<< set intCompany = $select($$$WWW001SharedFile($get(^WWW001(0,idClass,1))):0,1:YM)  ; FIXME : YM Deprecated
                  intCompany.set(m$.Fnc.$select(include.WWWConst.$$$WWW001SharedFile(m$,m$.Fnc.$get(m$.var("^WWW001",0,_idClass,1))),0,1,m$.var("YM").get()));
                  //<< set strGlobal  = "^"_idClass_"("_$$$Add(intCompany)
                  strGlobal.set(mOp.Concat(mOp.Concat(mOp.Concat("^",_idClass),"("),include.COMSYS.$$$Add(m$,intCompany)));
                  //<< for Loop=1:1:KeyLoop {
                  for (Loop.set(1);(mOp.LessOrEqual(Loop.get(),KeyLoop.get()));Loop.set(mOp.Add(Loop.get(),1))) {
                    //<< set strGlobal = strGlobal_","_$$$Add($piece(pidKey,",",Loop))
                    strGlobal.set(mOp.Concat(mOp.Concat(strGlobal.get(),","),include.COMSYS.$$$Add(m$,m$.Fnc.$piece(pidKey.get(),",",Loop.get()))));
                  }
                  //<< }
                  //<< set strGlobal     = strGlobal_",1)"
                  strGlobal.set(mOp.Concat(strGlobal.get(),",1)"));
                  //<< set @pstrRelation = $piece($get(@strGlobal),Y,$$$WWW122SequenceNumber(objField))
                  m$.indirectVar(pstrRelation.get()).set(m$.Fnc.$piece(m$.Fnc.$get(m$.indirectVar(strGlobal.get())),m$.var("Y").get(),include.WWWConst.$$$WWW122SequenceNumber(m$,objField)));
                }
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
    //<< }
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< GetGlobal(pidClass,pidKey)
  public Object GetGlobal(Object ... _p) {
    mVar pidClass = m$.newVarRef("pidClass",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pidKey = m$.newVarRef("pidKey",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Returns a global pointer for a given class and SQL ID.
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 10-Jan-2005   Paul K  Created
    //<< ;-------------------------------------------------------------------------------
    //<< new strRef,KeyLoop,idKey
    mVar strRef = m$.var("strRef");
    mVar KeyLoop = m$.var("KeyLoop");
    mVar idKey = m$.var("idKey");
    m$.newVar(strRef,KeyLoop,idKey);
    //<< 
    //<< set idKey  = ""
    idKey.set("");
    //<< set strRef = "^"_pidClass_"("
    strRef.set(mOp.Concat(mOp.Concat("^",pidClass.get()),"("));
    //<< 
    //<< for KeyLoop=1:1:$length(pidKey,"||") {
    for (KeyLoop.set(1);(mOp.LessOrEqual(KeyLoop.get(),m$.Fnc.$length(pidKey.get(),"||")));KeyLoop.set(mOp.Add(KeyLoop.get(),1))) {
      //<< set strRef = strRef_""""_$piece(pidKey,"||",KeyLoop)_""","
      strRef.set(mOp.Concat(mOp.Concat(mOp.Concat(strRef.get(),"\""),m$.Fnc.$piece(pidKey.get(),"||",KeyLoop.get())),"\","));
      //<< if KeyLoop'=1 {
      if (mOp.NotEqual(KeyLoop.get(),1)) {
        //<< if idKey'="" set idKey = idKey_","
        if (mOp.NotEqual(idKey.get(),"")) {
          idKey.set(mOp.Concat(idKey.get(),","));
        }
        //<< set idKey = idKey_$translate($piece(pidKey,"||",KeyLoop),",","|")
        idKey.set(mOp.Concat(idKey.get(),m$.Fnc.$translate(m$.Fnc.$piece(pidKey.get(),"||",KeyLoop.get()),",","|")));
      }
    }
    //<< }
    //<< }
    //<< set pidKey = idKey
    pidKey.set(idKey.get());
    //<< set strRef = strRef_"1)"
    strRef.set(mOp.Concat(strRef.get(),"1)"));
    //<< 
    //<< quit strRef
    return strRef.get();
  }

  //<< 
  //<< 
  //<< PopulateFileListing(pidForm="",&pobjRelation)
  public Object PopulateFileListing(Object ... _p) {
    mVar pidForm = m$.newVarRef("pidForm",(((_p!=null)&&(_p.length>=1))?_p[0]:null),"");
    mVar pobjRelation = m$.newVarRef("pobjRelation",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Ensures that PopulateFileListingCode is not run for every line on a COMView.
    //<< ; It will now only run once when COMView is loading.  (The assumption being that
    //<< ; the contents of the directory in question rarely ever change and that, if they
    //<< ; have, then the background process will have time to complete before the
    //<< ; results are required.  i.e. COMView item has been selected.)
    //<< ;
    //<< ; Params:   pidForm      - The form
    //<< ;           pobjRelation - byRef relation for field
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 09-Jan-2008   GRF     SRBR014855: Restored line to set dteLastRun; set LastRun
    //<< ;                           timestamp on commencement (as well as at end) to
    //<< ;                           stop mutiple jobs being generated before the first
    //<< ;                           has gotten to write the LastRun timestamp.
    //<< ; 08-Jan-2008   shobby  SRBR014855: Moved some things back and forward with
    //<< ;                           PopulateFileListingCode to allow 'job' to remain.
    //<< ; 08-Jan-2008   GRF     SRBR014855: show "&" for byRef argument, add "." for
    //<< ;                           byref argument in called routine - needs to revert
    //<< ;                           to "do" since cannot return desired byRef through job
    //<< ; 07-Jan-2008   shobby  SRBR014855: created
    //<< ;-------------------------------------------------------------------------------
    //<< new dteLastRun,strDirectory
    mVar dteLastRun = m$.var("dteLastRun");
    mVar strDirectory = m$.var("strDirectory");
    m$.newVar(dteLastRun,strDirectory);
    //<< 
    //<< set strDirectory = $$GetDirectory^WWWUploadDirectory(pidForm)
    strDirectory.set(m$.fnc$("WWWUploadDirectory.GetDirectory",pidForm.get()));
    //<< if strDirectory'="" {
    if (mOp.NotEqual(strDirectory.get(),"")) {
      //<< set ^CacheTempView(YUSER,"AppendValue") = strDirectory
      m$.var("^CacheTempView",m$.var("YUSER").get(),"AppendValue").set(strDirectory.get());
      //<< set dteLastRun=$get(^COMDirectoryListingLastRun(YM,strDirectory,"Timestamp"))
      dteLastRun.set(m$.Fnc.$get(m$.var("^COMDirectoryListingLastRun",m$.var("YM").get(),strDirectory.get(),"Timestamp")));
      //<< 
      //<< ;   refresh if not created in last 5 seconds
      //<< if $$DateDiff^COMUtilDate(dteLastRun,$horolog)>5 {
      if (mOp.Greater(m$.fnc$("COMUtilDate.DateDiff",dteLastRun.get(),m$.Fnc.$horolog()),5)) {
        //<< //job PopulateFileListingCode(pidForm,strDirectory,YM):(:1::)
        //<< job PopulateFileListingCode(pidForm,strDirectory,YM)
        m$.Cmd.Job("PopulateFileListingCode",pidForm.get(),strDirectory.get(),m$.var("YM").get());
        //<< set ^COMDirectoryListingLastRun(YM,strDirectory,"Timestamp") = $horolog
        m$.var("^COMDirectoryListingLastRun",m$.var("YM").get(),strDirectory.get(),"Timestamp").set(m$.Fnc.$horolog());
        //<< set $$$WWW002RelationClass(pobjRelation)         = "COMDirectoryListing"
        include.WWWConst.$$$WWW002RelationClassSet(m$,pobjRelation,"COMDirectoryListing");
        //<< set $$$WWW002RelationalPrimaryKeys(pobjRelation) = $$$DBLQUOTE_strDirectory_$$$DBLQUOTE
        include.WWWConst.$$$WWW002RelationalPrimaryKeysSet(m$,pobjRelation,mOp.Concat(mOp.Concat(include.COMSYSString.$$$DBLQUOTE(m$),strDirectory.get()),include.COMSYSString.$$$DBLQUOTE(m$)));
      }
    }
    //<< }
    //<< }
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< PopulateFileListingCode(pidForm="",pstrDirectory,pYM)
  public Object PopulateFileListingCode(Object ... _p) {
    mVar pidForm = m$.newVarRef("pidForm",(((_p!=null)&&(_p.length>=1))?_p[0]:null),"");
    mVar pstrDirectory = m$.newVarRef("pstrDirectory",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pYM = m$.newVarRef("pYM",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Populate COMDirectory with directory contents (only files)
    //<< ;
    //<< ; Params: pobjRelation - byRef relation for field
    //<< ;         pYM          - Pass this as a parameter because it will not be defined
    //<< ;                        when this routine is called by 'job'
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 08-Jan-2008   shobby  SRBR014855: Moved the pobjRelation code to PopulateFileListing.
    //<< ; 08-Jan-2008   shobby  SRBR014855: Moved the 'timestamp' update from PopulateFileListing.
    //<< ; 08-Jan-2008   GRF     SRBR014855: show "&" for byRef argument
    //<< ; 07-Jan-2007   shobby  SRBR014855: Create a temporary structure then move the
    //<< ;                           results at the end.  99.99% of the time the new and
    //<< ;                           old results are not going to differ.
    //<< ; 22-Aug-2005   JW      SR12876: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new objFile,resultSet
    mVar objFile = m$.var("objFile");
    mVar resultSet = m$.var("resultSet");
    m$.newVar(objFile,resultSet);
    //<< 
    //<< if pstrDirectory'="" {
    if (mOp.NotEqual(pstrDirectory.get(),"")) {
      //<< kill ^CacheTempCOMDirectoryListing(pYM,pstrDirectory)  ;BR014855
      m$.var("^CacheTempCOMDirectoryListing",pYM.get(),pstrDirectory.get()).kill();
      //<< 
      //<< set resultSet = ##class(%ResultSet).%New("%File:FileSet")
      resultSet.set(m$.fnc$("$ResultSet.$New","%File:FileSet"));
      //<< if resultSet'="" {
      if (mOp.NotEqual(resultSet.get(),"")) {
        //<< if $$$ISOK(resultSet.Execute(pstrDirectory,"*")) {
        if (mOp.Logical(include.COMSYS.$$$ISOK(m$,m$.fnc$(resultSet.getORef(),"Execute",pstrDirectory.get(),"*")))) {
          //<< for {
          for (;true;) {
            //<< quit:'resultSet.Next()
            if (mOp.Not(m$.fnc$(resultSet.getORef(),"Next"))) {
              break;
            }
            //<< 
            //<< if resultSet.Data("Type")="F" {
            if (mOp.Equal(m$.fnc$(resultSet.getORef(),"Data","Type"),"F")) {
              //<< set $$$COMDirectoryListingSize1(objFile)    = resultSet.Data("Size")
              include.COMConst.$$$COMDirectoryListingSize1Set(m$,objFile,m$.fnc$(resultSet.getORef(),"Data","Size"));
              //<< set $$$COMDirectoryListingCreated(objFile)  = $zdth(resultSet.Data("DateCreated"),3)
              include.COMConst.$$$COMDirectoryListingCreatedSet(m$,objFile,m$.Fnc.$zdatetimeh(m$.fnc$(resultSet.getORef(),"Data","DateCreated"),3));
              //<< set $$$COMDirectoryListingModified(objFile) = $zdth(resultSet.Data("DateModified"),3)
              include.COMConst.$$$COMDirectoryListingModifiedSet(m$,objFile,m$.Fnc.$zdatetimeh(m$.fnc$(resultSet.getORef(),"Data","DateModified"),3));
              //<< set ^CacheTempCOMDirectoryListing(pYM,pstrDirectory,resultSet.Data("ItemName"),1) = objFile
              m$.var("^CacheTempCOMDirectoryListing",pYM.get(),pstrDirectory.get(),m$.fnc$(resultSet.getORef(),"Data","ItemName"),1).set(objFile.get());
            }
          }
        }
      }
      //<< }
      //<< }
      //<< }
      //<< }
      //<< kill ^COMDirectoryListing(pYM,pstrDirectory)
      m$.var("^COMDirectoryListing",pYM.get(),pstrDirectory.get()).kill();
      //<< merge ^COMDirectoryListing(pYM,pstrDirectory)=^CacheTempCOMDirectoryListing(pYM,pstrDirectory)
      m$.Cmd.Merge(m$.var("^COMDirectoryListing",pYM.get(),pstrDirectory.get()),m$.var("^CacheTempCOMDirectoryListing",pYM.get(),pstrDirectory.get()));
      //<< kill ^CacheTempCOMDirectoryListing(pYM,pstrDirectory)
      m$.var("^CacheTempCOMDirectoryListing",pYM.get(),pstrDirectory.get()).kill();
      //<< set ^COMDirectoryListingLastRun(YM,pstrDirectory,"Timestamp") = $horolog
      m$.var("^COMDirectoryListingLastRun",m$.var("YM").get(),pstrDirectory.get(),"Timestamp").set(m$.Fnc.$horolog());
    }
    //<< }
    //<< quit
    return null;
  }

//<< 
//<< 
}
