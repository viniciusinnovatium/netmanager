//*****************************************************************************
//** TASC - ALPHALINC - MAC COMConst
//** Innovatium Systems - Code Converter - v1.30
//** 2014-06-05 20:54:34
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
//<< #include COMConst
//<< #include WWWConst
import include.WWWConst;
//import COMSYS;

//<< COMConst
public class COMConst extends mClass {

  public void main() {
    _COMConst();
  }

  public void _COMConst() {
  }

  //<< 
  //<< AlertInScript(str)
  public Object AlertInScript(Object ... _p) {
    mVar str = m$.newVarRef("str",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Display a message box in script tags..
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 29-Jun-2005   RobertW SR12230: Put type parameter in.
    //<< ; 26-May-2005   shobby  Moved from FINSYS (SR12279)
    //<< ; 22-Feb-2005   JW      SR11405: Created
    //<< ;-------------------------------------------------------------------------------
    //<< set str = ##class(%CSP.Page).QuoteJS($get(str))
    str.set(mLibrary.mPage.QuoteJS(m$.Fnc.$get(str)));
    //<< ;write "<script type='text/javascript'>alert("_str_");</script>"
    //<< $$$StartScript()
    include.COMSYS.$$$StartScript(m$);
    //<< write "alert("_str_");"
    m$.Cmd.Write(mOp.Concat(mOp.Concat("alert(",str.get()),");"));
    //<< $$$EndScript()
    include.COMSYS.$$$EndScript(m$);
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< Alert(str)
  public Object Alert(Object ... _p) {
    mVar str = m$.newVarRef("str",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Display a message box
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 26-May-2005   shobby  Moved from FINSYS (SR12279)
    //<< ; 02-Mar-2004   shobby  Created (Stole from Sale)
    //<< ;-------------------------------------------------------------------------------
    //<< set str = ##class(%CSP.Page).QuoteJS(str)
    str.set(mLibrary.mPage.QuoteJS(str.get()));
    //<< $$$StartScript()
    include.COMSYS.$$$StartScript(m$);
    //<< write "alert("_str_");"
    m$.Cmd.Write(mOp.Concat(mOp.Concat("alert(",str.get()),");"));
    //<< $$$EndScript()
    include.COMSYS.$$$EndScript(m$);
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< VBConfirm(str,type,heading)
  public Object VBConfirm(Object ... _p) {
    mVar str = m$.newVarRef("str",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar type = m$.newVarRef("type",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar heading = m$.newVarRef("heading",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    //<< ; Not used yet
    //<< set str     = ##class(%CSP.Page).QuoteJS(str)
    str.set(mLibrary.mPage.QuoteJS(str.get()));
    //<< set heading = ##class(%CSP.Page).QuoteJS(heading)
    heading.set(mLibrary.mPage.QuoteJS(heading.get()));
    //<< &js<var x=VBConfirm(#(str)#,#(type)#,#(heading)#);>
    m$.Cmd.WriteJS(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("var x=VBConfirm(",(str.get())),","),(type.get())),","),(heading.get())),");"));
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< ShowPrompt(pstrPrompt,pstrCallback,pstrParam)
  public Object ShowPrompt(Object ... _p) {
    mVar pstrPrompt = m$.newVarRef("pstrPrompt",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pstrCallback = m$.newVarRef("pstrCallback",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pstrParam = m$.newVarRef("pstrParam",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Prompts the user for input
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 13-Mar-2007   shobby  SRBR014399
    //<< ;-------------------------------------------------------------------------------
    //<< ;
    //<< set pstrPrompt = $$$JSText(pstrPrompt)
    pstrPrompt.set(include.COMSYSString.$$$JSText(m$,pstrPrompt));
    //<< set pstrParam  = $$$JSText(pstrParam)
    pstrParam.set(include.COMSYSString.$$$JSText(m$,pstrParam));
    //<< &js<var strResult=prompt('#(pstrPrompt)#',#(pstrParam)#,'');
    //<< if (strResult!='') CallBackNow('#(pstrCallback)#',strResult);
    //<< >
    m$.Cmd.WriteJS(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("var strResult=prompt('",(pstrPrompt.get())),"',"),(pstrParam.get())),",'');"),"\n");
    m$.Cmd.WriteJS(mOp.Concat(mOp.Concat("    if (strResult!='') CallBackNow('",(pstrCallback.get())),"',strResult);"),"\n");
    m$.Cmd.WriteJS("    ");
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< Data(pintPos,FieldName,%obj,%value)
  public Object Data(Object ... _p) {
    mVar pintPos = m$.newVarRef("pintPos",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar FieldName = m$.newVarRef("FieldName",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar p$obj = m$.newVarRef("p$obj",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    mVar p$value = m$.newVarRef("p$value",(((_p!=null)&&(_p.length>=4))?_p[3]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; See new macro definitions in *Const.inc files for faster set/get processing
    //<< ; This routine takes approximately 3.5 times longer to perform those actions.
    //<< ;-------------------------------------------------------------------------------
    //<< if $data(%value) {
    if (mOp.Logical(m$.Fnc.$data(p$value))) {
      //<< set $piece(%obj,Y,pintPos) = %value
      m$.pieceVar(p$obj,m$.var("Y").get(),pintPos.get()).set(p$value.get());
      //<< quit %obj
      return p$obj.get();
    }
    //<< 
    //<< } elseif $data(%obj) {
    else if (mOp.Logical(m$.Fnc.$data(p$obj))) {
      //<< quit $piece(%obj,Y,pintPos)
      return m$.Fnc.$piece(p$obj.get(),m$.var("Y").get(),pintPos.get());
    }
    //<< 
    //<< } else {
    else {
      //<< quit FieldName
      return FieldName.get();
    }
  }

  //<< 
  //<< GetPropertyName(pidClass,pintField="",pintKey="",pintCalcField="")
  public Object GetPropertyName(Object ... _p) {
    mVar pidClass = m$.newVarRef("pidClass",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pintField = m$.newVarRef("pintField",(((_p!=null)&&(_p.length>=2))?_p[1]:null),"");
    mVar pintKey = m$.newVarRef("pintKey",(((_p!=null)&&(_p.length>=3))?_p[2]:null),"");
    mVar pintCalcField = m$.newVarRef("pintCalcField",(((_p!=null)&&(_p.length>=4))?_p[3]:null),"");
    //<< ;-------------------------------------------------------------------------------
    //<< ; Used by macros with "Str" prefix to get property names.
    //<< ; Can return either primary keys or data fields.
    //<< ;
    //<< ; Returns:String
    //<< ;
    //<< ; History:
    //<< ; 08-Feb-2006   Steve S SR13474: Support Calculated fields
    //<< ; 17-Aug-2005   JW&SS   Actually get a piece.
    //<< ; 15-Jul-2005   shobby  SR12754:Replaced LANGUAGE global (not always reliable)
    //<< ; 09-Dec-2004   Paul K  Added ^LanguageTest global for debug purposes (SR11196)
    //<< ; 04-May-2004   Paul K  Created
    //<< ;-------------------------------------------------------------------------------
    //<< new strName
    mVar strName = m$.var("strName");
    m$.newVar(strName);
    //<< 
    //<< ; FIXME: This routine is incorrect. This should be just be calling WWWFELDNAME to take into
    //<< ;        account customisations.
    //<< 
    //<< if $get(SPRACHE)="" do ^WWWVAR
    if (mOp.Equal(m$.Fnc.$get(m$.var("SPRACHE")),"")) {
      m$.Cmd.Do("WWWVAR.main");
    }
    //<< set strName = ""
    strName.set("");
    //<< if pidClass'="" {
    if (mOp.NotEqual(pidClass.get(),"")) {
      //<< if pintField'="" {
      if (mOp.NotEqual(pintField.get(),"")) {
        //<< set strName = $$$WWW0031PropertyDescription($get(^WWW0031(0,pidClass,pintField,SPRACHE,1)))
        strName.set(include.WWWConst.$$$WWW0031PropertyDescription(m$,m$.Fnc.$get(m$.var("^WWW0031",0,pidClass.get(),pintField.get(),m$.var("SPRACHE").get(),1))));
        //<< if strName="" set strName = $$$WWW002TextInForms($get(^WWW003(0,pidClass,pintField,1)))
        if (mOp.Equal(strName.get(),"")) {
          strName.set(include.WWWConst.$$$WWW002TextInForms(m$,m$.Fnc.$get(m$.var("^WWW003",0,pidClass.get(),pintField.get(),1))));
        }
      }
      //<< 
      //<< } elseif pintKey'="" {
      else if (mOp.NotEqual(pintKey.get(),"")) {
        //<< set strName = $$$WWW0021PropertyDescription($get(^WWW0021(0,pidClass,pintKey,SPRACHE,1)))
        strName.set(include.WWWConst.$$$WWW0021PropertyDescription(m$,m$.Fnc.$get(m$.var("^WWW0021",0,pidClass.get(),pintKey.get(),m$.var("SPRACHE").get(),1))));
        //<< if strName="" set strName = $$$WWW002TextInForms($get(^WWW002(0,pidClass,pintKey,1)))
        if (mOp.Equal(strName.get(),"")) {
          strName.set(include.WWWConst.$$$WWW002TextInForms(m$,m$.Fnc.$get(m$.var("^WWW002",0,pidClass.get(),pintKey.get(),1))));
        }
      }
      //<< 
      //<< } elseif pintCalcField'="" { ;SR13474
      else if (mOp.NotEqual(pintCalcField.get(),"")) {
        //<< set strName = $$$WWW003CalcLangDescription($get(^WWW003CalcLang(0,pidClass,pintCalcField,SPRACHE,1)))
        strName.set(include.WWWConst.$$$WWW003CalcLangDescription(m$,m$.Fnc.$get(m$.var("^WWW003CalcLang",0,pidClass.get(),pintCalcField.get(),m$.var("SPRACHE").get(),1))));
        //<< if strName="" set strName = $$$WWW003CalcCaption($get(^WWW003Calc(0,pidClass,pintCalcField,1)))
        if (mOp.Equal(strName.get(),"")) {
          strName.set(include.WWWConst.$$$WWW003CalcCaption(m$,m$.Fnc.$get(m$.var("^WWW003Calc",0,pidClass.get(),pintCalcField.get(),1))));
        }
      }
    }
    //<< }
    //<< }
    //<< 
    //<< if $get(^LanguageTest)=1 {
    if (mOp.Equal(m$.Fnc.$get(m$.var("^LanguageTest")),1)) {
      //<< set strName="<span title='Class: "_pidClass_" Field: "_pintField_" Key: "_pintKey_"' style='color:green'>"_strName_"</span>"
      strName.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<span title='Class: ",pidClass.get())," Field: "),pintField.get())," Key: "),pintKey.get()),"' style='color:green'>"),strName.get()),"</span>"));
    }
    //<< }
    //<< 
    //<< quit strName
    return strName.get();
  }

  //<< 
  //<< 
  //<< GetClassName(pidClass="")
  public Object GetClassName(Object ... _p) {
    mVar pidClass = m$.newVarRef("pidClass",(((_p!=null)&&(_p.length>=1))?_p[0]:null),"");
    //<< ;-------------------------------------------------------------------------------
    //<< ; Return class name (internationalised)
    //<< ;
    //<< ; Returns:String
    //<< ;
    //<< ; History:
    //<< ; 17-Aug-2005   JW&SS   SR13272: Created (copied from GetPropertyName)
    //<< ;-------------------------------------------------------------------------------
    //<< new strName
    mVar strName = m$.var("strName");
    m$.newVar(strName);
    //<< 
    //<< if $get(SPRACHE)="" do ^WWWVAR
    if (mOp.Equal(m$.Fnc.$get(m$.var("SPRACHE")),"")) {
      m$.Cmd.Do("WWWVAR.main");
    }
    //<< set strName = ""
    strName.set("");
    //<< if pidClass'="" {
    if (mOp.NotEqual(pidClass.get(),"")) {
      //<< set strName = $$$WWW0011ClassDescription($get(^WWW0011(0,pidClass,SPRACHE,1)))
      strName.set(include.WWWConst.$$$WWW0011ClassDescription(m$,m$.Fnc.$get(m$.var("^WWW0011",0,pidClass.get(),m$.var("SPRACHE").get(),1))));
      //<< if strName="" set strName = $$$WWW001ClassDescription($get(^WWW001(0,pidClass,1)))
      if (mOp.Equal(strName.get(),"")) {
        strName.set(include.WWWConst.$$$WWW001ClassDescription(m$,m$.Fnc.$get(m$.var("^WWW001",0,pidClass.get(),1))));
      }
    }
    //<< }
    //<< if $get(^LanguageTest)=1 {
    if (mOp.Equal(m$.Fnc.$get(m$.var("^LanguageTest")),1)) {
      //<< set strName = "<span title='Class: "_pidClass_"' style='color:green'>"_strName_"</span>"
      strName.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<span title='Class: ",pidClass.get()),"' style='color:green'>"),strName.get()),"</span>"));
    }
    //<< }
    //<< quit strName
    return strName.get();
  }

  //<< 
  //<< 
  //<< Generate(pidModule="")
  public Object Generate(Object ... _p) {
    mVar pidModule = m$.newVarRef("pidModule",(((_p!=null)&&(_p.length>=1))?_p[0]:null),"");
    //<< ;-------------------------------------------------------------------------------
    //<< ; When changes are made to the class structures in @NetManager the macros
    //<< ; in the *Const.inc files are updated with the appropriate values.
    //<< ;
    //<< ; History:
    //<< ; 19-Mar-2011   shobby  SR17682: Include COMSYS in all WWWConst, INConst, etc. so we
    //<< ;                           don't need 1500 unnecessary lines of code.
    //<< ; 16-Nov-2009   GRF     Skip one routine level for $$$Index
    //<< ; 15-Jun-2009   SCR     SR16546: Compile INC
    //<< ; 19-Jan-2007   RPW     SR15121: Create macros for COMParameters
    //<< ; 07-Apr-2006   SC      SR14196: Modified to allow COMConst to remove Ampersand character.
    //<< ; 05-Jan-2004   GRF     SR11415: Remove repeated translation; Single quote
    //<< ;                       already in translation string; macro used
    //<< ; 20-Dec-2004   GRF     Force WWWVAR if not set up when run from command line
    //<< ; 28-Oct-2004   GRF     SR10478: Add Class prefix "CST"
    //<< ; 05-Oct-2004   SCR     Added "'" to strip list for Enums (SR10522)
    //<< ; 29-Sep-2004   Paul K  Added param to speed up Constant creation
    //<< ; 05-May-2004   GRF     Remove "Sale" from idClasses; Use $increment
    //<< ; 12-Apr-2003   Paul K  Added INAUFLAYBY
    //<< ; 05-Apr-2004   lw      Added WF
    //<< ; 05-apr-2004   lw      Added VAR
    //<< ; 20-jan-2004   lwaugh  Added AEP
    //<< ; 11-Aug-2003   Paul K  Added "/" to strip list for Enums
    //<< ; 04-Jul-2003   Paul K  Pass YM into SaveGlobal
    //<< ; 01-Jul-2003   Paul K  Added Save^SALUtils
    //<< ; 29-May-2003   paul k  Added Quotes around Enums
    //<< ; 23-May-2003   shobby  stripped out () and simplified code
    //<< ; 23-May-2003   shobby  Included REP
    //<< ;-------------------------------------------------------------------------------
    //<< new arrModules,idClass,idModule,idParam,intLength,intParamNum,gINC,lang
    mVar arrModules = m$.var("arrModules");
    mVar idClass = m$.var("idClass");
    mVar idModule = m$.var("idModule");
    mVar idParam = m$.var("idParam");
    mVar intLength = m$.var("intLength");
    mVar intParamNum = m$.var("intParamNum");
    mVar gINC = m$.var("gINC");
    mVar lang = m$.var("lang");
    m$.newVar(arrModules,idClass,idModule,idParam,intLength,intParamNum,gINC,lang);
    //<< new strClass,strParam,strParamKey,strQuery
    mVar strClass = m$.var("strClass");
    mVar strParam = m$.var("strParam");
    mVar strParamKey = m$.var("strParamKey");
    mVar strQuery = m$.var("strQuery");
    m$.newVar(strClass,strParam,strParamKey,strQuery);
    //<< 
    //<< if $get(Y)="" do ^WWWVAR
    if (mOp.Equal(m$.Fnc.$get(m$.var("Y")),"")) {
      m$.Cmd.Do("WWWVAR.main");
    }
    //<< 
    //<< do GetClassesForModule(pidModule,.arrModules)
    m$.Cmd.Do("GetClassesForModule",pidModule.get(),arrModules);
    //<< 
    //<< if pidModule="" {
    if (mOp.Equal(pidModule.get(),"")) {
      //<< kill ^rINC("Const",0)
      m$.var("^rINC","Const",0).kill();
      //<< set ^rINC("Const",0) = $horolog
      m$.var("^rINC","Const",0).set(m$.Fnc.$horolog());
      //<< set ^rINC("Const",0,$increment(^rINC("Const",0,0))) = " ; All Include Files"
      m$.var("^rINC","Const",0,m$.Fnc.$increment(m$.var("^rINC","Const",0,0))).set(" ; All Include Files");
    }
    //<< }
    //<< set idModule = ""
    idModule.set("");
    //<< for {
    for (;true;) {
      //<< set idModule = $order(arrModules(idModule))
      idModule.set(m$.Fnc.$order(arrModules.var(idModule.get())));
      //<< quit:idModule=""
      if (mOp.Equal(idModule.get(),"")) {
        break;
      }
      //<< 
      //<< set intLength = $length(idModule) // SR15121
      intLength.set(m$.Fnc.$length(idModule.get()));
      //<< 
      //<< set lang = "EN"
      lang.set("EN");
      //<< if pidModule="" {
      if (mOp.Equal(pidModule.get(),"")) {
        //<< set ^rINC("Const",0,$increment(^rINC("Const",0,0))) = "#include "_idModule_"Const"
        m$.var("^rINC","Const",0,m$.Fnc.$increment(m$.var("^rINC","Const",0,0))).set(mOp.Concat(mOp.Concat("#include ",idModule.get()),"Const"));
      }
      //<< }
      //<< set gINC = "^rINC("""_idModule_"Const"",0)"
      gINC.set(mOp.Concat(mOp.Concat("^rINC(\"",idModule.get()),"Const\",0)"));
      //<< kill @gINC
      m$.indirectVar(gINC.get()).kill();
      //<< set @gINC = $horolog
      m$.indirectVar(gINC.get()).set(m$.Fnc.$horolog());
      //<< set @gINC@($increment(@gINC@(0))) = " ; Enumerated values for Cache Datatypes"
      m$.indirectVar(gINC.get()).var(m$.Fnc.$increment(m$.indirectVar(gINC.get()).var(0))).set(" ; Enumerated values for Cache Datatypes");
      //<< //set @gINC@($increment(@gINC@(0))) = " ; Generated on "_$zdate($horolog,2)_" at "_$ztime($piece($horolog,",",2))
      //<< set @gINC@($increment(@gINC@(0))) = " ;"
      m$.indirectVar(gINC.get()).var(m$.Fnc.$increment(m$.indirectVar(gINC.get()).var(0))).set(" ;");
      //<< set @gINC@($increment(@gINC@(0))) = "#include COMSYS" ;SR17682
      m$.indirectVar(gINC.get()).var(m$.Fnc.$increment(m$.indirectVar(gINC.get()).var(0))).set("#include COMSYS");
      //<< set @gINC@($increment(@gINC@(0))) = "#def1arg SaveGlobal(%obj) $$Save^SALUtils(YM,%obj)"
      m$.indirectVar(gINC.get()).var(m$.Fnc.$increment(m$.indirectVar(gINC.get()).var(0))).set("#def1arg SaveGlobal(%obj) $$Save^SALUtils(YM,%obj)");
      //<< ;   set @gINC@($increment(@gINC@(0))) = "#define Index(%obj) $$Index^COMUtils(%obj)"     ; 16-Nov-2009
      //<< set @gINC@($increment(@gINC@(0))) = "#define Index(%obj) $$Index^COMUtilIndex(%obj)"
      m$.indirectVar(gINC.get()).var(m$.Fnc.$increment(m$.indirectVar(gINC.get()).var(0))).set("#define Index(%obj) $$Index^COMUtilIndex(%obj)");
      //<< 
      //<< set idClass = ""
      idClass.set("");
      //<< for {
      for (;true;) {
        //<< set idClass = $order(arrModules(idModule,idClass))
        idClass.set(m$.Fnc.$order(arrModules.var(idModule.get(),idClass.get())));
        //<< quit:idClass=""
        if (mOp.Equal(idClass.get(),"")) {
          break;
        }
        //<< 
        //<< do GenerateForClass(gINC,idClass)
        m$.Cmd.Do("GenerateForClass",gINC.get(),idClass.get());
      }
      //<< }
      //<< set idParam = idModule
      idParam.set(idModule.get());
      //<< for {
      for (;true;) {
        //<< set idParam = $order(^WWW101(0,idParam))
        idParam.set(m$.Fnc.$order(m$.var("^WWW101",0,idParam.get())));
        //<< quit:$extract(idParam,1,intLength)'=idModule // SR15121
        if (mOp.NotEqual(m$.Fnc.$extract(idParam.get(),1,intLength.get()),idModule.get())) {
          break;
        }
        //<< 
        //<< set intParamNum = ""
        intParamNum.set("");
        //<< for {
        for (;true;) {
          //<< set intParamNum = $order(^WWW101(0,idParam,lang,intParamNum))
          intParamNum.set(m$.Fnc.$order(m$.var("^WWW101",0,idParam.get(),lang.get(),intParamNum.get())));
          //<< quit:intParamNum=""
          if (mOp.Equal(intParamNum.get(),"")) {
            break;
          }
          //<< 
          //<< set strParam = $piece($get(^WWW101(0,idParam,lang,intParamNum,1)),"~",1) //SR14196
          strParam.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW101",0,idParam.get(),lang.get(),intParamNum.get(),1)),"~",1));
          //<< set strParam = $translate(strParam,"³_+@-.[],()/'´ &") //SR14196
          strParam.set(m$.Fnc.$translate(strParam.get(),"³_+@-.[],()/'´ &"));
          //<< set strClass = $translate(idParam,"³_+@-.[],()/")
          strClass.set(m$.Fnc.$translate(idParam.get(),"³_+@-.[],()/"));
          //<< 
          //<< set @gINC@($increment(@gINC@(0))) = "#define Enum"_strClass_strParam_" """_intParamNum_""""
          m$.indirectVar(gINC.get()).var(m$.Fnc.$increment(m$.indirectVar(gINC.get()).var(0))).set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("#define Enum",strClass.get()),strParam.get())," \""),intParamNum.get()),"\""));
        }
      }
      //<< }
      //<< }
      //<< 
      //<< // SR15121
      //<< set strQuery = "^COMParameter(0,"""_idModule_""")"
      strQuery.set(mOp.Concat(mOp.Concat("^COMParameter(0,\"",idModule.get()),"\")"));
      //<< for {
      for (;true;) {
        //<< set strQuery = $query(@strQuery)
        strQuery.set(m$.Fnc.$query(m$.indirectVar(strQuery.get())));
        //<< quit:strQuery=""
        if (mOp.Equal(strQuery.get(),"")) {
          break;
        }
        //<< 
        //<< set idParam     = $qsubscript(strQuery,2)
        idParam.set(m$.Fnc.$qsubscript(strQuery,2));
        //<< set strParamKey = $qsubscript(strQuery,3)
        strParamKey.set(m$.Fnc.$qsubscript(strQuery,3));
        //<< quit:$extract(idParam,1,intLength)'=idModule
        if (mOp.NotEqual(m$.Fnc.$extract(idParam.get(),1,intLength.get()),idModule.get())) {
          break;
        }
        //<< 
        //<< set strParam = $piece($get(^COMParameter(0,idParam,strParamKey,1)),"~",1) //SR14196
        strParam.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^COMParameter",0,idParam.get(),strParamKey.get(),1)),"~",1));
        //<< set strParam = $translate(strParam,"³_+@-.[],()/'´ &")                    //SR14196
        strParam.set(m$.Fnc.$translate(strParam.get(),"³_+@-.[],()/'´ &"));
        //<< set strClass = $translate(idParam,"³_+@-.[],()/")
        strClass.set(m$.Fnc.$translate(idParam.get(),"³_+@-.[],()/"));
        //<< 
        //<< set @gINC@($increment(@gINC@(0))) = "#define CPEnum"_strClass_strParam_" """_strParamKey_"""" // Use CP so that we can have same names as Application Parameters
        m$.indirectVar(gINC.get()).var(m$.Fnc.$increment(m$.indirectVar(gINC.get()).var(0))).set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("#define CPEnum",strClass.get()),strParam.get())," \""),strParamKey.get()),"\""));
      }
      //<< }
      //<< 
      //<< // Export the related Cache include to the file system
      //<< do ##class(SourceControl.data.SourceBase).ExportAsCleanXML(idModule_"Const.INC")
      m$.Cmd.Do("SourceControl.data.SourceBase.ExportAsCleanXML",mOp.Concat(idModule.get(),"Const.INC"));
    }
    //<< }
    //<< do ROUTINE^%R(idModule_"Const.INC",,,"LCS")  ; SR16546
    m$.Cmd.Do("$R.ROUTINE",mOp.Concat(idModule.get(),"Const.INC"),null,null,"LCS");
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< GenerateForClass(gINC,pidClass)
  public Object GenerateForClass(Object ... _p) {
    mVar gINC = m$.newVarRef("gINC",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pidClass = m$.newVarRef("pidClass",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ;
    //<< ;-------------------------------------------------------------------------------
    //<< new FieldName,FormName,intField
    mVar FieldName = m$.var("FieldName");
    mVar FormName = m$.var("FormName");
    mVar intField = m$.var("intField");
    m$.newVar(FieldName,FormName,intField);
    //<< 
    //<< if pidClass'="" {
    if (mOp.NotEqual(pidClass.get(),"")) {
      //<< set intField = ""
      intField.set("");
      //<< for {
      for (;true;) {
        //<< set intField = $order(^WWW003(0,pidClass,intField))
        intField.set(m$.Fnc.$order(m$.var("^WWW003",0,pidClass.get(),intField.get())));
        //<< quit:intField=""
        if (mOp.Equal(intField.get(),"")) {
          break;
        }
        //<< 
        //<< set FieldName = $piece($get(^WWW003(0,pidClass,intField,1)),"~",25)  ; Property Name
        FieldName.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW003",0,pidClass.get(),intField.get(),1)),"~",25));
        //<< set FormName  = $piece($get(^WWW003(0,pidClass,intField,1)),"~",2)   ; Caption in Forms
        FormName.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW003",0,pidClass.get(),intField.get(),1)),"~",2));
        //<< do DefineConst(gINC,intField,pidClass,FieldName,FormName,1)
        m$.Cmd.Do("DefineConst",gINC.get(),intField.get(),pidClass.get(),FieldName.get(),FormName.get(),1);
      }
      //<< }
      //<< 
      //<< set intField = ""
      intField.set("");
      //<< for {
      for (;true;) {
        //<< set intField = $order(^WWW002(0,pidClass,intField))
        intField.set(m$.Fnc.$order(m$.var("^WWW002",0,pidClass.get(),intField.get())));
        //<< quit:intField=""
        if (mOp.Equal(intField.get(),"")) {
          break;
        }
        //<< 
        //<< set FieldName = $piece($get(^WWW002(0,pidClass,intField,1)),"~",25)  ; Property Name
        FieldName.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW002",0,pidClass.get(),intField.get(),1)),"~",25));
        //<< set FormName  = $piece($get(^WWW002(0,pidClass,intField,1)),"~",2)   ; Caption in Forms
        FormName.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW002",0,pidClass.get(),intField.get(),1)),"~",2));
        //<< do DefineConst(gINC,intField,pidClass,FieldName,FormName)
        m$.Cmd.Do("DefineConst",gINC.get(),intField.get(),pidClass.get(),FieldName.get(),FormName.get());
      }
      //<< }
      //<< set @gINC@($increment(@gINC@(0))) = ""
      m$.indirectVar(gINC.get()).var(m$.Fnc.$increment(m$.indirectVar(gINC.get()).var(0))).set("");
    }
    //<< }
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< DefineConst(gINC,intField,idClass,FieldName,FormName,pblnField=0)
  public Object DefineConst(Object ... _p) {
    mVar gINC = m$.newVarRef("gINC",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar intField = m$.newVarRef("intField",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar idClass = m$.newVarRef("idClass",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    mVar FieldName = m$.newVarRef("FieldName",(((_p!=null)&&(_p.length>=4))?_p[3]:null));
    mVar FormName = m$.newVarRef("FormName",(((_p!=null)&&(_p.length>=5))?_p[4]:null));
    mVar pblnField = m$.newVarRef("pblnField",(((_p!=null)&&(_p.length>=6))?_p[5]:null),0);
    //<< ;-------------------------------------------------------------------------------
    //<< ; Accommodates both old and new methods setting records.
    //<< ;
    //<< ; History:
    //<< ; 29-Dec-2004   Paul K  Added 'Fld' definitions for primary keys.
    //<< ; 01-Dec-2004   shobby  Include INLIEF (SR10061)
    //<< ; 11-Oct-2004   SCR     Handle ´_´ in Field Name (SR10581)
    //<< ; 05-May-2004   GRF     Use $increment
    //<< ; 04-May-2004   Paul K  Created
    //<< ;-------------------------------------------------------------------------------
    //<< set idClass   = $translate(idClass,".","")
    idClass.set(m$.Fnc.$translate(idClass.get(),".",""));
    //<< set FieldName = $translate(FieldName,"_","")
    FieldName.set(m$.Fnc.$translate(FieldName.get(),"_",""));
    //<< 
    //<< ;if ($extract(idClass,1,3)'="INA") &&
    //<< ;   ($extract(idClass,1,3)'="INW") &&
    //<< ;   ($extract(idClass,1,3)'="INE") &&
    //<< ;   ($extract(idClass,1,3)'="INL")    {
    //<< ;
    //<< ;   set @gINC@($increment(@gINC@(0))) = "#def1arg Dt"_idClass_FieldName_"(%obj) $$Data^COMConst("_intField_","""_FormName_""",%obj)"
    //<< ;}
    //<< 
    //<< if pblnField {
    if (mOp.Logical(pblnField.get())) {
      //<< set @gINC@($increment(@gINC@(0))) = "#define "_idClass_FieldName_"(%obj) $piece(%obj,"""_Y_""","_intField_")"
      m$.indirectVar(gINC.get()).var(m$.Fnc.$increment(m$.indirectVar(gINC.get()).var(0))).set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("#define ",idClass.get()),FieldName.get()),"(%obj) $piece(%obj,\""),m$.var("Y").get()),"\","),intField.get()),")"));
      //<< set @gINC@($increment(@gINC@(0))) = "#define Fld"_idClass_FieldName_" "_intField
      m$.indirectVar(gINC.get()).var(m$.Fnc.$increment(m$.indirectVar(gINC.get()).var(0))).set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("#define Fld",idClass.get()),FieldName.get())," "),intField.get()));
      //<< set @gINC@($increment(@gINC@(0))) = "#define Str"_idClass_FieldName_" $$GetPropertyName^COMConst("""_idClass_""","_intField_")"
      m$.indirectVar(gINC.get()).var(m$.Fnc.$increment(m$.indirectVar(gINC.get()).var(0))).set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("#define Str",idClass.get()),FieldName.get())," $$GetPropertyName^COMConst(\""),idClass.get()),"\","),intField.get()),")"));
    }
    //<< 
    //<< } else {
    else {
      //<< set @gINC@($increment(@gINC@(0))) = "#define Fld"_idClass_FieldName_" "_intField
      m$.indirectVar(gINC.get()).var(m$.Fnc.$increment(m$.indirectVar(gINC.get()).var(0))).set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("#define Fld",idClass.get()),FieldName.get())," "),intField.get()));
      //<< set @gINC@($increment(@gINC@(0))) = "#define Str"_idClass_FieldName_" $$GetPropertyName^COMConst("""_idClass_""",,"_intField_")"
      m$.indirectVar(gINC.get()).var(m$.Fnc.$increment(m$.indirectVar(gINC.get()).var(0))).set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("#define Str",idClass.get()),FieldName.get())," $$GetPropertyName^COMConst(\""),idClass.get()),"\",,"),intField.get()),")"));
    }
    //<< }
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< SetAutoGenerate()
  public Object SetAutoGenerate() {
    //<< ;-------------------------------------------------------------------------------
    //<< ; Turns on the auto generation of the SALConst.INC, COMConst.INC
    //<< ; and FINConst.INC.
    //<< ;
    //<< ; History:
    //<< ; 13-Jan-2004   Paul K  Added Setting of WWW101 after save.
    //<< ; 22-Sep-2003   ms-sh   Added call to GenerateSaleLineTypes
    //<< ;-------------------------------------------------------------------------------
    //<< set $piece(^WWW120(0,"WWW003",1),"~",16)="do ^WWW003 do Generate^COMConst(YKEY)"
    m$.pieceVar(m$.var("^WWW120",0,"WWW003",1),"~",16).set("do ^WWW003 do Generate^COMConst(YKEY)");
    //<< set $piece(^WWW120(0,"WWW101",1),"~",16)="do Generate^COMConst(YKEY)"
    m$.pieceVar(m$.var("^WWW120",0,"WWW101",1),"~",16).set("do Generate^COMConst(YKEY)");
    //<< quit 1
    return 1;
  }

  //<< 
  //<< GetClassesForModule(pstrModule,parrModules)
  public Object GetClassesForModule(Object ... _p) {
    mVar pstrModule = m$.newVarRef("pstrModule",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar parrModules = m$.newVarRef("parrModules",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< /*-------------------------------------------------------------------------------
    //<< ;
    //<< ; Params:
    //<< ;
    //<< ; ByRefs:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 19-Jan-2007   RPW     SR15121: Use Module call as it's doing the same thing.
    //<< ; 10-Apr-2006   shobby  SR014007: Include Module TS
    //<< ;-------------------------------------------------------------------------------*/
    //<< ;
    //<< new idConst,lstClasses,idClass,objConst
    mVar idConst = m$.var("idConst");
    mVar lstClasses = m$.var("lstClasses");
    mVar idClass = m$.var("idClass");
    mVar objConst = m$.var("objConst");
    m$.newVar(idConst,lstClasses,idClass,objConst);
    //<< 
    //<< set lstClasses=""
    lstClasses.set("");
    //<< 
    //<< set pstrModule=$$Module(pstrModule) // SR15121
    pstrModule.set(m$.fnc$("Module",pstrModule.get()));
    //<< 
    //<< if pstrModule="" {
    if (mOp.Equal(pstrModule.get(),"")) {
      //<< set idConst=""
      idConst.set("");
    }
    //<< } else {
    else {
      //<< set idConst=$order(^COMConst(0,pstrModule),-1)
      idConst.set(m$.Fnc.$order(m$.var("^COMConst",0,pstrModule.get()),mOp.Negative(1)));
    }
    //<< }
    //<< for {
    for (;true;) {
      //<< set idConst=$order(^COMConst(0,idConst))
      idConst.set(m$.Fnc.$order(m$.var("^COMConst",0,idConst.get())));
      //<< quit:$extract(idConst,1,$length(pstrModule))'=pstrModule
      if (mOp.NotEqual(m$.Fnc.$extract(idConst.get(),1,m$.Fnc.$length(pstrModule.get())),pstrModule.get())) {
        break;
      }
      //<< quit:idConst=""
      if (mOp.Equal(idConst.get(),"")) {
        break;
      }
      //<< 
      //<< set objConst=$get(^COMConst(0,idConst,1))
      objConst.set(m$.Fnc.$get(m$.var("^COMConst",0,idConst.get(),1)));
      //<< if $$$COMConstGenerate(objConst) {
      if (mOp.Logical(include.COMConst.$$$COMConstGenerate(m$,objConst))) {
        //<< if $$$COMConstSubClasses(objConst) {
        if (mOp.Logical(include.COMConst.$$$COMConstSubClasses(m$,objConst))) {
          //<< set idClass=$order(^WWW002(0,idConst),-1)
          idClass.set(m$.Fnc.$order(m$.var("^WWW002",0,idConst.get()),mOp.Negative(1)));
          //<< for {
          for (;true;) {
            //<< set idClass=$order(^WWW002(0,idClass))
            idClass.set(m$.Fnc.$order(m$.var("^WWW002",0,idClass.get())));
            //<< quit:$extract(idClass,1,$length(idConst))'=idConst
            if (mOp.NotEqual(m$.Fnc.$extract(idClass.get(),1,m$.Fnc.$length(idConst.get())),idConst.get())) {
              break;
            }
            //<< 
            //<< set parrModules($$Module(idClass),idClass)=""
            parrModules.var(m$.fnc$("Module",idClass.get()),idClass.get()).set("");
          }
        }
        //<< }
        //<< } else {
        else {
          //<< set parrModules($$Module(idConst),idConst)=""
          parrModules.var(m$.fnc$("Module",idConst.get()),idConst.get()).set("");
        }
      }
    }
    //<< }
    //<< }
    //<< 
    //<< }
    //<< quit lstClasses
    return lstClasses.get();
  }

  //<< 
  //<< 
  //<< Module(pidClass)
  public Object Module(Object ... _p) {
    mVar pidClass = m$.newVarRef("pidClass",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< /*-------------------------------------------------------------------------------
    //<< ;
    //<< ; Params:
    //<< ;
    //<< ; ByRefs:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 10-Apr-2006   shobby  SR014007: Include Module TS
    //<< ;-------------------------------------------------------------------------------*/
    //<< ;
    //<< if $extract(pidClass,1,2)="IN" {
    if (mOp.Equal(m$.Fnc.$extract(pidClass.get(),1,2),"IN")) {
      //<< set pidClass = "IN"
      pidClass.set("IN");
    }
    //<< 
    //<< } elseif $extract(pidClass,1,2)="TS" {
    else if (mOp.Equal(m$.Fnc.$extract(pidClass.get(),1,2),"TS")) {
      //<< set pidClass = "TS"
      pidClass.set("TS");
    }
    //<< 
    //<< } elseif $extract(pidClass,1,2)="WF" {
    else if (mOp.Equal(m$.Fnc.$extract(pidClass.get(),1,2),"WF")) {
      //<< set pidClass = "WF"
      pidClass.set("WF");
    }
    //<< 
    //<< } else {
    else {
      //<< set pidClass = $extract(pidClass,1,3)
      pidClass.set(m$.Fnc.$extract(pidClass.get(),1,3));
    }
    //<< }
    //<< quit pidClass
    return pidClass.get();
  }

//<< 
//<< 
}
