//*****************************************************************************
//** TASC - ALPHALINC - MAC WWW120DynTable
//** Innovatium Systems - Code Converter - v1.27
//** 2014-05-22 00:15:14
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

//<< WWW120DynTable
public class WWW120DynTable extends mClass {

  //<< 
  //<< #define Alignment   1
  public static Object $$$Alignment(mContext m$) {
    return (1);
  }

  //<< #define Type        2
  public static Object $$$Type(mContext m$) {
    return (2);
  }

  //<< #define Color       3
  public static Object $$$Color(mContext m$) {
    return (3);
  }

  //<< #define DELIM       "^"
  public static Object $$$DELIM(mContext m$) {
    return ("^");
  }

  public void main() {
    _WWW120DynTable();
  }

  public void _WWW120DynTable() {
  }

  //<< 
  //<< OnBeforeSave(YKEY,YFELD)
  public Object OnBeforeSave(Object ... _p) {
    mVar YKEY = m$.newVarRef("YKEY",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar YFELD = m$.newVarRef("YFELD",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Called when saving form         (Page equates to tab)
    //<< ;
    //<< ; History:
    //<< ; 20-Apr-2011   GRF     SR17715: Partial bug fix to avoid subscript error. New
    //<< ;                           SR created to clarift rules and adjust code if it is
    //<< ;                           now possible to have multiple tables on same tab.
    //<< ;-------------------------------------------------------------------------------
    //<< new idDynTab,idForm,intPage,strStatus
    mVar idDynTab = m$.var("idDynTab");
    mVar idForm = m$.var("idForm");
    mVar intPage = m$.var("intPage");
    mVar strStatus = m$.var("strStatus");
    m$.newVar(idDynTab,idForm,intPage,strStatus);
    //<< 
    //<< set idForm    = $$$KEY1(YKEY)
    idForm.set(include.COMSYSWWW.$$$KEY1(m$,YKEY));
    //<< set idDynTab  = $$$KEY2(YKEY)                  ; SR17715
    idDynTab.set(include.COMSYSWWW.$$$KEY2(m$,YKEY));
    //<< set strStatus = $$$OK
    strStatus.set(include.COMSYS.$$$OK(m$));
    //<< set intPage   = $$$WWW120DynTablePages1(YFELD)
    intPage.set(include.WWWConst.$$$WWW120DynTablePages1(m$,YFELD));
    //<< 
    //<< ; FIXME : This rule may no longer apply - see SR17739
    //<< 
    //<< ;if $order(^WWW120DynTables(0,2,$$$Index(idForm),intPage,idForm,intPage))'="" {  ; SR17715
    //<< if $order(^WWW120DynTables(0,2,$$$Index(idForm),$$$Index(intPage),idForm,idDynTab))'="" {
    if (mOp.NotEqual(m$.Fnc.$order(m$.var("^WWW120DynTables",0,2,include.MEDConst.$$$Index(m$,idForm),include.MEDConst.$$$Index(m$,intPage),idForm.get(),idDynTab.get())),"")) {
      //<< set strStatus = $$$MakeStatus("WWW00059")
      strStatus.set(include.COMSYS.$$$MakeStatus(m$,"WWW00059"));
    }
    //<< 
    //<< ;} elseif $order(^WWW120DynTables(0,2,$$$Index(idForm),intPage,idForm,intPage),-1)'="" {  ; SR17715
    //<< } elseif $order(^WWW120DynTables(0,2,$$$Index(idForm),$$$Index(intPage),idForm,idDynTab),-1)'="" {
    else if (mOp.NotEqual(m$.Fnc.$order(m$.var("^WWW120DynTables",0,2,include.MEDConst.$$$Index(m$,idForm),include.MEDConst.$$$Index(m$,intPage),idForm.get(),idDynTab.get()),mOp.Negative(1)),"")) {
      //<< set strStatus = $$$MakeStatus("WWW00059")
      strStatus.set(include.COMSYS.$$$MakeStatus(m$,"WWW00059"));
    }
    //<< } ; "Currently there can only be one Dynamic Table per page of a form."
    //<< set YRETVAL = strStatus
    mVar YRETVAL = m$.var("YRETVAL");
    YRETVAL.set(strStatus.get());
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< OnBeforeFormat(pstrYFieldName,pstrText,pobjLine)
  public Object OnBeforeFormat(Object ... _p) {
    mVar pstrYFieldName = m$.newVarRef("pstrYFieldName",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pstrText = m$.newVarRef("pstrText",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pobjLine = m$.newVarRef("pobjLine",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Set the formatting of Edit Grid fields
    //<< ;
    //<< ; Params:
    //<< ; pstrYFieldName - Edit Grid Field Name
    //<< ; pstrText - Current fields value
    //<< ; pobjLine - Record
    //<< ;
    //<< ; ByRefs: This is not really needed as we use & for ByRef parameters now.
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 17-Sep-2010   GRF     SR16346: General code cleanup
    //<< ; 08-Jan-2010   shobby  SR15753: blnError not used.
    //<< ; 08-Jan-2010   shobby  SR15753: No need to set YBACKGROUNDCOLOR
    //<< ; 18-Dec-2006   PO      SR15351: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new enumBasis,idCol,idField,idRow,objForm
    mVar enumBasis = m$.var("enumBasis");
    mVar idCol = m$.var("idCol");
    mVar idField = m$.var("idField");
    mVar idRow = m$.var("idRow");
    mVar objForm = m$.var("objForm");
    m$.newVar(enumBasis,idCol,idField,idRow,objForm);
    //<< 
    //<< $$$GRIDSplitKey(pstrYFieldName,idRow,idCol)
    include.COMGridEdit31Interface.$$$GRIDSplitKey(m$,pstrYFieldName,idRow,idCol);
    //<< 
    //<< set idField   = $$$GetClassField(YFORM,idCol)
    idField.set(include.COMSYSWWW.$$$GetClassField(m$,m$.var("YFORM"),idCol));
    //<< set enumBasis = $$$WWW120DynTableBasis(pobjLine)
    enumBasis.set(include.WWWConst.$$$WWW120DynTableBasis(m$,pobjLine));
    //<< 
    //<< if (idField = $$$FldWWW120DynTableClassOrForm) || (idField = $$$FldWWW120DynTableHyperLink) {
    if ((mOp.Equal(idField.get(),include.WWWConst.$$$FldWWW120DynTableClassOrForm(m$))) || (mOp.Equal(idField.get(),include.WWWConst.$$$FldWWW120DynTableHyperLink(m$)))) {
      //<< if (enumBasis = "") || (enumBasis = $$$EnumWWWBASEDONCustom) {
      if ((mOp.Equal(enumBasis.get(),"")) || (mOp.Equal(enumBasis.get(),include.WWWConst.$$$EnumWWWBASEDONCustom(m$)))) {
        //<< set YENABLED = $$$NO
        mVar YENABLED = m$.var("YENABLED");
        YENABLED.set(include.COMSYS.$$$NO(m$));
      }
    }
    //<< }
    //<< 
    //<< } elseif idField = $$$FldWWW120DynTableCustomCode {
    else if (mOp.Equal(idField.get(),include.WWWConst.$$$FldWWW120DynTableCustomCode(m$))) {
      //<< if (enumBasis = "") || (enumBasis = $$$EnumWWWBASEDONClass) || (enumBasis = $$$EnumWWWBASEDONForm) {
      if ((mOp.Equal(enumBasis.get(),"")) || (mOp.Equal(enumBasis.get(),include.WWWConst.$$$EnumWWWBASEDONClass(m$))) || (mOp.Equal(enumBasis.get(),include.WWWConst.$$$EnumWWWBASEDONForm(m$)))) {
        //<< set YENABLED = $$$NO
        mVar YENABLED = m$.var("YENABLED");
        YENABLED.set(include.COMSYS.$$$NO(m$));
      }
    }
    //<< }
    //<< }
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< ;SR17245 ValidateLines(pidForm,pobjForm)
  //<< ;SR17245 ;-------------------------------------------------------------------------------
  //<< ;SR17245 ; Check whether data is in a saveable state
  //<< ;SR17245 ;
  //<< ;SR17245 ; Params:
  //<< ;SR17245 ; pidForm - Form Id
  //<< ;SR17245 ; pobjForm - Form Record
  //<< ;SR17245 ;
  //<< ;SR17245 ; ByRefs: This is not really needed as we use & for ByRef parameters now.
  //<< ;SR17245 ;
  //<< ;SR17245 ; Returns: strStatus - $$$OK if valid, else error message
  //<< ;SR17245 ;
  //<< ;SR17245 ; History:
  //<< ;SR17245 ; 23-Mar-2010  shobby  Redundant.  Core Rules.
  //<< ;SR17245 ; 21-Aug-2009  GRF     Replace Order macro
  //<< ;SR17245 ; 19-Dec-2006  PO      SR15351: Created
  //<< ;SR17245 ;-------------------------------------------------------------------------------
  //<< ;SR17245 new objDynamicTable,objLine,idLine,penumBasis,strStatus
  //<< 
  //<< ;SR17245 set strStatus = $$$OK
  //<< 
  //<< ;SR17245 $$$GRIDGetContents(.arrDynTable)
  //<< 
  //<< ;SR17245 set idLine = ""
  //<< ;SR17245 for {
  //<< ;SR17245    set idLine = $order(arrDynTable(pidForm,idLine))
  //<< ;SR17245    quit:idLine=""
  //<< 
  //<< ;SR17245    set objLine = $get(arrDynTable(pidForm,idLine))
  //<< ;SR17245    if ($$$WWW120DynTableBasis(objLine) = $$$EnumWWWBASEDONClass) ||
  //<< ;SR17245       ($$$WWW120DynTableBasis(objLine) = $$$EnumWWWBASEDONForm)     {
  //<< ;SR17245        if $$$WWW120DynTableClassOrForm(objLine) = "" {
  //<< ;SR17245            set strStatus = $listbuild("WWW00057",idLine)
  //<< ;SR17245        }  ; "The field Class / Form must be filled out on line %1."
  //<< 
  //<< ;SR17245    } elseif $$$WWW120DynTableBasis(objLine) = $$$EnumWWWBASEDONCustom {
  //<< ;SR17245        if $$$WWW120DynTableCustomCode(objLine) = "" {
  //<< ;SR17245            set strStatus = $listbuild("WWW00058",idLine)
  //<< ;SR17245        }  ; "The field Custom Code must be filled out on line %1."
  //<< ;SR17245    }
  //<< ;SR17245    quit:$$$ISERR(strStatus)
  //<< ;SR17245 }
  //<< ;SR17245 quit strStatus
  //<< 
  //<< OnBeforeFormConstruction(pidField,pobjLine)
  public Object OnBeforeFormConstruction(Object ... _p) {
    mVar pidField = m$.newVarRef("pidField",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pobjLine = m$.newVarRef("pobjLine",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Generate the relation text before field is displayed
    //<< ;
    //<< ; Params:
    //<< ; pidField - Field Id
    //<< ; pobjLine - Record
    //<< ;
    //<< ; Returns: Nothing
    //<< ;
    //<< ; History:
    //<< ; 19-Dec-2006   PO      SR15351: Created
    //<< ;-------------------------------------------------------------------------------
    //<< do CreateRelationText(pidField,pobjLine)
    m$.Cmd.Do("CreateRelationText",pidField.get(),pobjLine.get());
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< OnBlur(pidField,&pobjLine)
  public Object OnBlur(Object ... _p) {
    mVar pidField = m$.newVarRef("pidField",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pobjLine = m$.newVarRef("pobjLine",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Switch editable state of fields based on data entered, also create relation text
    //<< ;
    //<< ; Params:
    //<< ;   pidField - Field Id
    //<< ;   pobjLine - Record  (ByRef)
    //<< ;
    //<< ; Returns: Nothing
    //<< ;
    //<< ; History:
    //<< ; 08-Jan-2010   shobby  SR15753: A lot of code not required.
    //<< ; 19-Dec-2006   PO      SR15351: Created
    //<< ;-------------------------------------------------------------------------------
    //<< do CreateRelationText(pidField,pobjLine)
    m$.Cmd.Do("CreateRelationText",pidField.get(),pobjLine.get());
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< CreateRelationText(pidField,pobjLine)
  public Object CreateRelationText(Object ... _p) {
    mVar pidField = m$.newVarRef("pidField",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pobjLine = m$.newVarRef("pobjLine",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Create relation text for a particular field
    //<< ;
    //<< ; Params:
    //<< ; pidField - Field Id
    //<< ; pobjLine - Record
    //<< ;
    //<< ; Returns: Nothing
    //<< ;
    //<< ; History:
    //<< ; 19-Dec-2006   PO      SR15351: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new idClassOrForm,objRecord,strDescription
    mVar idClassOrForm = m$.var("idClassOrForm");
    mVar objRecord = m$.var("objRecord");
    mVar strDescription = m$.var("strDescription");
    m$.newVar(idClassOrForm,objRecord,strDescription);
    //<< 
    //<< if pidField = $$$FldWWW120DynTableClassOrForm {
    if (mOp.Equal(pidField.get(),include.WWWConst.$$$FldWWW120DynTableClassOrForm(m$))) {
      //<< set idClassOrForm = $$$WWW120DynTableClassOrForm(pobjLine)
      idClassOrForm.set(include.WWWConst.$$$WWW120DynTableClassOrForm(m$,pobjLine));
      //<< if idClassOrForm '= "" {
      if (mOp.NotEqual(idClassOrForm.get(),"")) {
        //<< set strDescription = ""
        strDescription.set("");
        //<< if $$$WWW120DynTableBasis(pobjLine) = $$$EnumWWWBASEDONClass {
        if (mOp.Equal(include.WWWConst.$$$WWW120DynTableBasis(m$,pobjLine),include.WWWConst.$$$EnumWWWBASEDONClass(m$))) {
          //<< set strDescription = $$GetClassName^COMConst(idClassOrForm)
          strDescription.set(m$.fnc$("COMConst.GetClassName",idClassOrForm.get()));
        }
        //<< 
        //<< } elseif $$$WWW120DynTableBasis(pobjLine) = $$$EnumWWWBASEDONForm {
        else if (mOp.Equal(include.WWWConst.$$$WWW120DynTableBasis(m$,pobjLine),include.WWWConst.$$$EnumWWWBASEDONForm(m$))) {
          //<< set strDescription = $$^WWWFORMNAME(idClassOrForm)
          strDescription.set(m$.fnc$("WWWFORMNAME.main",idClassOrForm.get()));
        }
        //<< }
        //<< set ^COMTempList(YM,YUSER,"ClassOrForm",idClassOrForm,1) = strDescription
        m$.var("^COMTempList",m$.var("YM").get(),m$.var("YUSER").get(),"ClassOrForm",idClassOrForm.get(),1).set(strDescription.get());
      }
    }
    //<< }
    //<< }
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< ClassOrForm(pstrField)
  public Object ClassOrForm(Object ... _p) {
    mVar pstrField = m$.newVarRef("pstrField",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Start COMView searching the appropriate data structure based on what the dynamic table is based on.
    //<< ;
    //<< ; Params:
    //<< ; pstrField - Edit Grid Field reference
    //<< ;
    //<< ; Returns: Nothing
    //<< ;
    //<< ; History:
    //<< ; 21-Dec-2006   PO      SR15351: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new idLine,objDynTable
    mVar idLine = m$.var("idLine");
    mVar objDynTable = m$.var("objDynTable");
    m$.newVar(idLine,objDynTable);
    //<< 
    //<< set idLine      = $piece($piece(pstrField,"Y",2),"_",1)
    idLine.set(m$.Fnc.$piece(m$.Fnc.$piece(pstrField.get(),"Y",2),"_",1));
    //<< set objDynTable = $$$GRIDGetYFELD($$$GRIDGetCurrentYKEY)
    objDynTable.set(include.COMGridEdit31Interface.$$$GRIDGetYFELD(m$,include.COMGridEdit31Interface.$$$GRIDGetCurrentYKEY(m$)));
    //<< 
    //<< if $$$WWW120DynTableBasis(objDynTable) = $$$EnumWWWBASEDONClass {
    if (mOp.Equal(include.WWWConst.$$$WWW120DynTableBasis(m$,objDynTable),include.WWWConst.$$$EnumWWWBASEDONClass(m$))) {
      //<< do Initialise^COMViewCustom("WWW001")
      m$.Cmd.Do("COMViewCustom.Initialise","WWW001");
    }
    //<< 
    //<< } elseif $$$WWW120DynTableBasis(objDynTable) = $$$EnumWWWBASEDONForm {
    else if (mOp.Equal(include.WWWConst.$$$WWW120DynTableBasis(m$,objDynTable),include.WWWConst.$$$EnumWWWBASEDONForm(m$))) {
      //<< do Initialise^COMViewCustom("WWW120")
      m$.Cmd.Do("COMViewCustom.Initialise","WWW120");
    }
    //<< }
    //<< 
    //<< do Start^COMViewCustom("WWW2.Y"_idLine_"_"_$piece($piece($piece(pstrField,"Y",2),"_",2),".",1))
    m$.Cmd.Do("COMViewCustom.Start",mOp.Concat(mOp.Concat(mOp.Concat("WWW2.Y",idLine.get()),"_"),m$.Fnc.$piece(m$.Fnc.$piece(m$.Fnc.$piece(pstrField.get(),"Y",2),"_",2),".",1)));
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< ForGrid(pstrField)
  public Object ForGrid(Object ... _p) {
    mVar pstrField = m$.newVarRef("pstrField",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Start COMView searching for Edit Grid form
    //<< ;
    //<< ; Params:
    //<< ; pstrField - Edit Grid Field reference
    //<< ;
    //<< ; Returns: Nothing
    //<< ;
    //<< ; History:
    //<< ; 22-Dec-2006   PO      SR15351: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new idLine,objDynTable
    mVar idLine = m$.var("idLine");
    mVar objDynTable = m$.var("objDynTable");
    m$.newVar(idLine,objDynTable);
    //<< 
    //<< set idLine      = $piece($piece(pstrField,"Y",2),"_",1)
    idLine.set(m$.Fnc.$piece(m$.Fnc.$piece(pstrField.get(),"Y",2),"_",1));
    //<< set objDynTable = $$$GRIDGetYFELD($$$GRIDGetCurrentYKEY)
    objDynTable.set(include.COMGridEdit31Interface.$$$GRIDGetYFELD(m$,include.COMGridEdit31Interface.$$$GRIDGetCurrentYKEY(m$)));
    //<< 
    //<< do Initialise^COMViewCustom("WWW120")
    m$.Cmd.Do("COMViewCustom.Initialise","WWW120");
    //<< do Start^COMViewCustom("WWW2.Y"_idLine_"_"_$piece($piece($piece(pstrField,"Y",2),"_",2),".",1))
    m$.Cmd.Do("COMViewCustom.Start",mOp.Concat(mOp.Concat(mOp.Concat("WWW2.Y",idLine.get()),"_"),m$.Fnc.$piece(m$.Fnc.$piece(m$.Fnc.$piece(pstrField.get(),"Y",2),"_",2),".",1)));
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< CreateDynTableCall(pidForm,pidGrid="",pintPage="",&parrTables)
  public Object CreateDynTableCall(Object ... _p) {
    mVar pidForm = m$.newVarRef("pidForm",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pidGrid = m$.newVarRef("pidGrid",(((_p!=null)&&(_p.length>=2))?_p[1]:null),"");
    mVar pintPage = m$.newVarRef("pintPage",(((_p!=null)&&(_p.length>=3))?_p[2]:null),"");
    mVar parrTables = m$.newVarRef("parrTables",(((_p!=null)&&(_p.length>=4))?_p[3]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Create javascript functions that can be called when particular events occur.
    //<< ;
    //<< ; Params:
    //<< ; pidForm - Form Id
    //<< ; pidGrid - Edit Grid From Id
    //<< ;
    //<< ; Returns: Nothing
    //<< ;
    //<< ; History:
    //<< ; 14-Dec-2009   PPP     SR17077: DIV for Multiple DynaGrids, Remove all children
    //<< ;                           on Grid Focus
    //<< ; 21-Aug-2009   GRF     Replace Order macro
    //<< ; 29-Mar-2007   GRF     SR15426: intPages => strPages
    //<< ; 15-Feb-2007   PO      SR15426: Remove table if nothing to display
    //<< ; 11-Jan-2007   PO      SR15339: Table heading
    //<< ; 02-Jan-2007   PO      SR15351: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new idLine,objDynamicTable,idxForm,idxOrder,strPages
    mVar idLine = m$.var("idLine");
    mVar objDynamicTable = m$.var("objDynamicTable");
    mVar idxForm = m$.var("idxForm");
    mVar idxOrder = m$.var("idxOrder");
    mVar strPages = m$.var("strPages");
    m$.newVar(idLine,objDynamicTable,idxForm,idxOrder,strPages);
    //<< 
    //<< set idxForm = $$$Index(pidForm)
    idxForm.set(include.MEDConst.$$$Index(m$,pidForm));
    //<< 
    //<< $$$StartScript()
    include.COMSYS.$$$StartScript(m$);
    //<< 
    //<< set idxOrder = ""
    idxOrder.set("");
    //<< for {
    for (;true;) {
      //<< set idxOrder = $order(^WWW120DynTables(0,1,idxForm,idxOrder))
      idxOrder.set(m$.Fnc.$order(m$.var("^WWW120DynTables",0,1,idxForm.get(),idxOrder.get())));
      //<< quit:idxOrder=""
      if (mOp.Equal(idxOrder.get(),"")) {
        break;
      }
      //<< 
      //<< set idLine = ""
      idLine.set("");
      //<< for {
      for (;true;) {
        //<< set idLine = $order(^WWW120DynTables(0,1,idxForm,idxOrder,pidForm,idLine))
        idLine.set(m$.Fnc.$order(m$.var("^WWW120DynTables",0,1,idxForm.get(),idxOrder.get(),pidForm.get(),idLine.get())));
        //<< quit:idLine=""
        if (mOp.Equal(idLine.get(),"")) {
          break;
        }
        //<< 
        //<< set objDynamicTable = $get(^WWW120DynTable(0,pidForm,idLine,1))
        objDynamicTable.set(m$.Fnc.$get(m$.var("^WWW120DynTable",0,pidForm.get(),idLine.get(),1)));
        //<< set strPages = $$$WWW120DynTablePages1(objDynamicTable)
        strPages.set(include.WWWConst.$$$WWW120DynTablePages1(m$,objDynamicTable));
        //<< if pidGrid '= "" continue:$$$WWW120DynTableForGrid(objDynamicTable)'=pidGrid
        if (mOp.NotEqual(pidGrid.get(),"")) {
          if (mOp.NotEqual(include.WWWConst.$$$WWW120DynTableForGrid(m$,objDynamicTable),pidGrid.get())) {
            continue;
          }
        }
        //<< if (pintPage '= "") && (strPages '= "") continue:($$$COMMA_strPages_$$$COMMA)'[($$$COMMA_pintPage_$$$COMMA)
        if ((mOp.NotEqual(pintPage.get(),"")) && (mOp.NotEqual(strPages.get(),""))) {
          if (mOp.NotContains((mOp.Concat(mOp.Concat(include.COMSYSString.$$$COMMA(m$),strPages.get()),include.COMSYSString.$$$COMMA(m$))),(mOp.Concat(mOp.Concat(include.COMSYSString.$$$COMMA(m$),pintPage.get()),include.COMSYSString.$$$COMMA(m$))))) {
            continue;
          }
        }
        //<< 
        //<< if $$$WWW120DynTableFiringEvent(objDynamicTable) = $$$EnumWWWDYNTABLEGridLineFocus {
        if (mOp.Equal(include.WWWConst.$$$WWW120DynTableFiringEvent(m$,objDynamicTable),include.WWWConst.$$$EnumWWWDYNTABLEGridLineFocus(m$))) {
          //<< // Function name will need to include order no. when multiple grids are allowed per form.
          //<< write "function DrawDynTable_GridFieldFocus(pRow) {"
          m$.Cmd.Write("function DrawDynTable_GridFieldFocus(pRow) {");
          //<< write "if (pRow == '') { RemoveChildren(document.getElementById('DYNAMIC_div'),true); } else {"
          m$.Cmd.Write("if (pRow == '') { RemoveChildren(document.getElementById('DYNAMIC_div'),true); } else {");
          //<< write "var UnitSep = unescape('%1f');"
          m$.Cmd.Write("var UnitSep = unescape('%1f');");
          //<< write "RemoveChildren(document.getElementById('DYNAMIC_div'),false);"
          m$.Cmd.Write("RemoveChildren(document.getElementById('DYNAMIC_div'),false);");
          //<< write "CallBack('"_$$$WWW120DynTableCustomCode(objDynamicTable)_"','"_$$$EnumWWWDYNTABLEGridLineFocus_"','"_pidForm_"'+UnitSep+'"_$$$GRIDName_"'+UnitSep+'"_idLine_"'+UnitSep+pRow);"
          m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("CallBack('",include.WWWConst.$$$WWW120DynTableCustomCode(m$,objDynamicTable)),"','"),include.WWWConst.$$$EnumWWWDYNTABLEGridLineFocus(m$)),"','"),pidForm.get()),"'+UnitSep+'"),include.COMGridEdit31Interface.$$$GRIDName(m$)),"'+UnitSep+'"),idLine.get()),"'+UnitSep+pRow);"));
          //<< write "} }"
          m$.Cmd.Write("} }");
          //<< set parrTables(idLine)=objDynamicTable
          parrTables.var(idLine.get()).set(objDynamicTable.get());
        }
        //<< 
        //<< } elseif $$$WWW120DynTableFiringEvent(objDynamicTable) = $$$EnumWWWDYNTABLEAfterDataFields {
        else if (mOp.Equal(include.WWWConst.$$$WWW120DynTableFiringEvent(m$,objDynamicTable),include.WWWConst.$$$EnumWWWDYNTABLEAfterDataFields(m$))) {
          //<< // Function name will need to include order no. when multiple grids are allowed per form.
          //<< write "function DrawDynTable_AfterDataFields(pRow) {"
          m$.Cmd.Write("function DrawDynTable_AfterDataFields(pRow) {");
          //<< write "var UnitSep = unescape('%1f');"
          m$.Cmd.Write("var UnitSep = unescape('%1f');");
          //<< write "CallBack('"_$$$WWW120DynTableCustomCode(objDynamicTable)_"','"_$$$EnumWWWDYNTABLEAfterDataFields_"','"_pidForm_"'+UnitSep+'"_idLine_"'+UnitSep+'"_YKEY_"');"
          m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("CallBack('",include.WWWConst.$$$WWW120DynTableCustomCode(m$,objDynamicTable)),"','"),include.WWWConst.$$$EnumWWWDYNTABLEAfterDataFields(m$)),"','"),pidForm.get()),"'+UnitSep+'"),idLine.get()),"'+UnitSep+'"),m$.var("YKEY").get()),"');"));
          //<< write "}"
          m$.Cmd.Write("}");
          //<< set parrTables(idLine)=objDynamicTable
          parrTables.var(idLine.get()).set(objDynamicTable.get());
        }
      }
    }
    //<< }
    //<< }
    //<< }
    //<< 
    //<< $$$EndScript()
    include.COMSYS.$$$EndScript(m$);
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< DrawTable(plstHeaders,pidTableData,plstColTypes,pidParameters,pstrFunction,pidEvent,pstrExecute="",pstrTableHeading="",pblnAutoSelect=$$$NO)
  public Object DrawTable(Object ... _p) {
    mVar plstHeaders = m$.newVarRef("plstHeaders",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pidTableData = m$.newVarRef("pidTableData",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar plstColTypes = m$.newVarRef("plstColTypes",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    mVar pidParameters = m$.newVarRef("pidParameters",(((_p!=null)&&(_p.length>=4))?_p[3]:null));
    mVar pstrFunction = m$.newVarRef("pstrFunction",(((_p!=null)&&(_p.length>=5))?_p[4]:null));
    mVar pidEvent = m$.newVarRef("pidEvent",(((_p!=null)&&(_p.length>=6))?_p[5]:null));
    mVar pstrExecute = m$.newVarRef("pstrExecute",(((_p!=null)&&(_p.length>=7))?_p[6]:null),"");
    mVar pstrTableHeading = m$.newVarRef("pstrTableHeading",(((_p!=null)&&(_p.length>=8))?_p[7]:null),"");
    mVar pblnAutoSelect = m$.newVarRef("pblnAutoSelect",(((_p!=null)&&(_p.length>=9))?_p[8]:null),include.COMSYS.$$$NO(m$));
    //<< ;---------------------------------------------------------------------------------------------------------------------------------------
    //<< ; Draw Dynamic Table
    //<< ;
    //<< ; Data:
    //<< ; ^CacheTempDynamicTable(YUCI,YUSER,pidTableData,seq)         =  display data, tilde delimited
    //<< ; ^CacheTempDynamicTable(YUCI,YUSER,pidTableData,seq,"data")  =  link key
    //<< ;
    //<< ; Formatting:
    //<< ; plstColTypes = $listbuild($listbuild({Alignment},{Type}), ...)
    //<< ;                   {Alignment}: center, left, right
    //<< ;                   {Type}:      display (data without hyperlink), link (includes hyperlink)
    //<< ;
    //<< ; Params:
    //<< ;   plstHeaders     The headers for the table                            [$lb()]
    //<< ;   pidTableData    ^CacheTempDynamicTable id - can uniquely identify
    //<< ;                       multiple dynamic tables presented together
    //<< ;   plstColTypes    List of lists detailing each column                  [$lb($lb(),$lb(),...)]
    //<< ;   pidParameters   Parameters passed when event fired                   [$c(31) delimited]  [idForm*idGrid*idKey*intRow]
    //<< ;   pstrFunction    javascript function to call onclick of line
    //<< ;                       e.g. "FillLine" if link or "" if empty grid or error message
    //<< ;   pidEvent        Event that has caused dynamic table to be drawn
    //<< ;                       1   $$$EnumWWWDYNTABLEGridLineFocus     Dynamic Table based on Grid Line with focus
    //<< ;                       3   $$$EnumWWWDYNTABLEAfterDataFields   Dynamic Table simply presented After Data displayed (check)
    //<< ;   pstrExecute     Call onclick
    //<< ;   pstrTableHeading    Use this parameter to Set the Header, overwrites the one on ^WWW120DynTable #11
    //<< ;   pblnAutoSelect  if set to YES, auto select the record if there is only one record
    //<< ;
    //<< ; Returns: Nothing
    //<< ;
    //<< ; History:
    //<< ; 08-Nov-2012   SCR     SR18193: Corrected Heading
    //<< ; 07-Sep-2010   PPP     SR17494: 1. New parameter - pblnAutoSelect
    //<< ;                           2. if set to YES, auto select the record if there is
    //<< ;                           only one record
    //<< ; 03-Aug-2010   PPP     SR17484: If no focusfield - stop the JS error
    //<< ; 25-Feb-2010   GRF     new objColData
    //<< ; 14-Dec-2009   PPP     SR17077:1. Added id to the DynaGrid to enable Mutiple DynaGrids
    //<< ;                           2. Added new parameter for Header ,pstrHeader
    //<< ;                           3. Create a DIV for the multiple Tables
    //<< ;                           4. Added Color to the cells
    //<< ;                              4.1 To set a Column for every row
    //<< ;                                  set lstColTypes = $listbuild($listbuild("left","link","red"),
    //<< ;                              4.2 To set an individual row/col
    //<< ;                                  set ^CacheTempDynamicTable(YUCI,YUSER,pidTable,idLine,"col") = "red"_Y_Y_Y_Y_Y_Y_"red"_Y_Y_Y
    //<< ; 01-Jun-2009   PPP     SR16599: 1. Add background colors to the DynaGrid
    //<< ;                           Changes also made to commonfunctions.js
    //<< ;                             a. function DynTable_CreateHeader
    //<< ;                             b. function DynTable_CreateRow
    //<< ;                           2. Added Functions (to enable row selection)
    //<< ;                             a. function DynTable_SelectRow
    //<< ;                             b. function DynTable_RowMouseOut
    //<< ;                             c. function DynTable_RowClick
    //<< ;                           3. Save the key to the Row and retrieve it onclick
    //<< ;                           4. Added Row highlight & click functionality
    //<< ;
    //<< ; 09-Feb-2009   GRF     SR16328: doco
    //<< ; 03-Apr-2008   shobby  SRBR014916: If there is no table heading defined for
    //<< ;                           a dynamic table attached to a grid, browser will
    //<< ;                           lockup.  Append a &nbsp; to the Table heading.
    //<< ; 11-Jan-2007   PO      SR15339: Table heading
    //<< ; 03-Jan-2007   PO      SR15351: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new idDyn,idLine,idKey,idRow,intLen,loop
    mVar idDyn = m$.var("idDyn");
    mVar idLine = m$.var("idLine");
    mVar idKey = m$.var("idKey");
    mVar idRow = m$.var("idRow");
    mVar intLen = m$.var("intLen");
    mVar loop = m$.var("loop");
    m$.newVar(idDyn,idLine,idKey,idRow,intLen,loop);
    //<< new objColData,objDynTable,objLine,objLinkData
    mVar objColData = m$.var("objColData");
    mVar objDynTable = m$.var("objDynTable");
    mVar objLine = m$.var("objLine");
    mVar objLinkData = m$.var("objLinkData");
    m$.newVar(objColData,objDynTable,objLine,objLinkData);
    //<< new strAlign,strColHdrCol,strColor,strMessage,strType
    mVar strAlign = m$.var("strAlign");
    mVar strColHdrCol = m$.var("strColHdrCol");
    mVar strColor = m$.var("strColor");
    mVar strMessage = m$.var("strMessage");
    mVar strType = m$.var("strType");
    m$.newVar(strAlign,strColHdrCol,strColor,strMessage,strType);
    //<< 
    //<< $$$StartScript()
    include.COMSYS.$$$StartScript(m$);
    //<< 
    //<< set idDyn  = pidTableData
    idDyn.set(pidTableData.get());
    //<< set intLen = $listlength(plstHeaders)
    intLen.set(m$.Fnc.$listlength(plstHeaders.get()));
    //<< quit:((intLen>0) && (intLen'=$listlength(plstColTypes)))
    if (mOp.Logical(((mOp.Greater(intLen.get(),0)) && (mOp.NotEqual(intLen.get(),m$.Fnc.$listlength(plstColTypes.get())))))) {
      return null;
    }
    //<< 
    //<< if pidEvent = $$$EnumWWWDYNTABLEGridLineFocus {
    if (mOp.Equal(pidEvent.get(),include.WWWConst.$$$EnumWWWDYNTABLEGridLineFocus(m$))) {
      //<< ;SR17306 write "var row = document.getElementById('focusfield').value.split('tdY')[1].split('_')[0];" // Use getRowNum(getFocusField())
      //<< write "var r1 = document.getElementById('focusfield');"     //SR17484
      m$.Cmd.Write("var r1 = document.getElementById('focusfield');");
      //<< write "if (r1 != null) {"
      m$.Cmd.Write("if (r1 != null) {");
      //<< write "var row=getRowNum(r1.value);" ;SR17306
      m$.Cmd.Write("var row=getRowNum(r1.value);");
      //<< //write "var row=getRowNum(document.getElementById('focusfield').value);" ;SR17306
      //<< set idRow = $$$DYNTABLEGridLineFocusRow(pidParameters)
      idRow.set(include.COMSYSWWW.$$$DYNTABLEGridLineFocusRow(m$,pidParameters));
      //<< set idKey = $$ReferenceKey^COMGridEdit31Interface($$$DYNTABLEGridLineFocusGrid(pidParameters),idRow)
      idKey.set(m$.fnc$("COMGridEdit31Interface.ReferenceKey",include.COMSYSWWW.$$$DYNTABLEGridLineFocusGrid(m$,pidParameters),idRow.get()));
      //<< set idKey = $$$KEYMAX(idKey) // SR15339 ^^^
      idKey.set(include.COMSYSWWW.$$$KEYMAX(m$,idKey));
      //<< 
      //<< write "if (row != '"_idRow_"') {"
      m$.Cmd.Write(mOp.Concat(mOp.Concat("if (row != '",idRow.get()),"') {"));
      //<< write "DrawDynTable_GridFieldFocus(row);"
      m$.Cmd.Write("DrawDynTable_GridFieldFocus(row);");
      //<< write "} else {"               // ###START### ... MATCHING BRACE AT ###END###
      m$.Cmd.Write("} else {");
    }
    //<< 
    //<< } elseif pidEvent = $$$EnumWWWDYNTABLEAfterDataFields {
    else if (mOp.Equal(pidEvent.get(),include.WWWConst.$$$EnumWWWDYNTABLEAfterDataFields(m$))) {
      //<< set idKey = $$$DYNTABLEAfterDataFieldsKey(pidParameters)
      idKey.set(include.COMSYSWWW.$$$DYNTABLEAfterDataFieldsKey(m$,pidParameters));
    }
    //<< }
    //<< 
    //<< // Auto correction ^^^
    //<< 
    //<< // Creation of the DIV
    //<< write "if (document.getElementById('DYNAMIC_div') != null) {"
    m$.Cmd.Write("if (document.getElementById('DYNAMIC_div') != null) {");
    //<< write "DYNAMIC_div = document.getElementById('DYNAMIC_div');"
    m$.Cmd.Write("DYNAMIC_div = document.getElementById('DYNAMIC_div');");
    //<< write "} else {"
    m$.Cmd.Write("} else {");
    //<< write "var DYNAMIC_div = document.createElement('div');"
    m$.Cmd.Write("var DYNAMIC_div = document.createElement('div');");
    //<< write "DYNAMIC_div.id = 'DYNAMIC_div';"
    m$.Cmd.Write("DYNAMIC_div.id = 'DYNAMIC_div';");
    //<< write "}"
    m$.Cmd.Write("}");
    //<< 
    //<< write "if (document.getElementById('DYNAMIC_table"_idDyn_"') != null) {"
    m$.Cmd.Write(mOp.Concat(mOp.Concat("if (document.getElementById('DYNAMIC_table",idDyn.get()),"') != null) {"));
    //<< //No need to remove children separately
    //<< write "document.getElementById('DYNAMIC_table"_idDyn_"').removeChild(document.getElementById('DYNAMIC_tbody"_idDyn_"'));"
    m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("document.getElementById('DYNAMIC_table",idDyn.get()),"').removeChild(document.getElementById('DYNAMIC_tbody"),idDyn.get()),"'));"));
    //<< write "document.getElementById('DYNAMIC_table"_idDyn_"').removeChild(document.getElementById('DYNAMIC_caption"_idDyn_"'));"
    m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("document.getElementById('DYNAMIC_table",idDyn.get()),"').removeChild(document.getElementById('DYNAMIC_caption"),idDyn.get()),"'));"));
    //<< write "DYNAMIC_table = document.getElementById('DYNAMIC_table"_idDyn_"');"
    m$.Cmd.Write(mOp.Concat(mOp.Concat("DYNAMIC_table = document.getElementById('DYNAMIC_table",idDyn.get()),"');"));
    //<< write "} else {"
    m$.Cmd.Write("} else {");
    //<< write "var DYNAMIC_table = document.createElement('table');"
    m$.Cmd.Write("var DYNAMIC_table = document.createElement('table');");
    //<< write "DYNAMIC_table.id = 'DYNAMIC_table"_idDyn_"';"
    m$.Cmd.Write(mOp.Concat(mOp.Concat("DYNAMIC_table.id = 'DYNAMIC_table",idDyn.get()),"';"));
    //<< write "DYNAMIC_table.className = 'gDIVsh';"
    m$.Cmd.Write("DYNAMIC_table.className = 'gDIVsh';");
    //<< write "DYNAMIC_table.width = '100%';"
    m$.Cmd.Write("DYNAMIC_table.width = '100%';");
    //<< write "}"
    m$.Cmd.Write("}");
    //<< 
    //<< write "DYNAMIC_div.appendChild(DYNAMIC_table);"
    m$.Cmd.Write("DYNAMIC_div.appendChild(DYNAMIC_table);");
    //<< 
    //<< ; FIXME : Following code is common to both Grid Line Focus and After Data Field tables.
    //<< ;         ^WWW120DynTable(0,param1,param3,1) is based on Grid Line Focus parameter
    //<< ;         structure - should make both consistent <GRF> (SR16346 raised)
    //<< 
    //<< if $get(pstrTableHeading)'="" {
    if (mOp.NotEqual(m$.Fnc.$get(pstrTableHeading),"")) {
      //<< write "var DYNAMIC_caption1 = document.createElement('caption');"
      m$.Cmd.Write("var DYNAMIC_caption1 = document.createElement('caption');");
      //<< write "DYNAMIC_caption1.id = 'DYNAMIC_caption1"_idDyn_"';"
      m$.Cmd.Write(mOp.Concat(mOp.Concat("DYNAMIC_caption1.id = 'DYNAMIC_caption1",idDyn.get()),"';"));
      //<< write "DYNAMIC_caption1.innerHTML = '&nbsp;';"
      m$.Cmd.Write("DYNAMIC_caption1.innerHTML = '&nbsp;';");
      //<< write "DYNAMIC_table.appendChild(DYNAMIC_caption1);"
      m$.Cmd.Write("DYNAMIC_table.appendChild(DYNAMIC_caption1);");
      //<< write "DYNAMIC_caption1.style.fontSize = '6pt';"
      m$.Cmd.Write("DYNAMIC_caption1.style.fontSize = '6pt';");
    }
    //<< }
    //<< 
    //<< write "var DYNAMIC_caption = document.createElement('caption');"
    m$.Cmd.Write("var DYNAMIC_caption = document.createElement('caption');");
    //<< write "DYNAMIC_caption.id = 'DYNAMIC_caption"_idDyn_"';"
    m$.Cmd.Write(mOp.Concat(mOp.Concat("DYNAMIC_caption.id = 'DYNAMIC_caption",idDyn.get()),"';"));
    //<< if $data(^CacheTempDynamicTable(YUCI,YUSER,pidTableData)) {
    if (mOp.Logical(m$.Fnc.$data(m$.var("^CacheTempDynamicTable",m$.var("YUCI").get(),m$.var("YUSER").get(),pidTableData.get())))) {
      //<< if $get(pstrTableHeading)="" {
      if (mOp.Equal(m$.Fnc.$get(pstrTableHeading),"")) {
        //<< set objDynTable = $get(^WWW120DynTable(0,$$$DYNTABLEGridLineFocusForm(pidParameters),$$$DYNTABLEGridLineFocusDynTable(pidParameters),1))
        objDynTable.set(m$.Fnc.$get(m$.var("^WWW120DynTable",0,include.COMSYSWWW.$$$DYNTABLEGridLineFocusForm(m$,pidParameters),include.COMSYSWWW.$$$DYNTABLEGridLineFocusDynTable(m$,pidParameters),1)));
        //<< set pstrTableHeading = $$$WWW120DynTableTableHeading(objDynTable)
        pstrTableHeading.set(include.WWWConst.$$$WWW120DynTableTableHeading(m$,objDynTable));
      }
      //<< }
      //<< set strMessage = $$$Text(pstrTableHeading)
      strMessage.set(include.COMSYS.$$$Text(m$,pstrTableHeading));
      //<< 
      //<< ;set strMessage = $$^WWWTEXT(pstrTableHeading)
      //<< ;if strMessage [ "%1" set strMessage = $$$Text($listbuild(pstrTableHeading,idKey))
      //<< 
      //<< write "DYNAMIC_caption.innerHTML = '"_$$$JSText(strMessage)_"&nbsp;';"
      m$.Cmd.Write(mOp.Concat(mOp.Concat("DYNAMIC_caption.innerHTML = '",include.COMSYSString.$$$JSText(m$,strMessage)),"&nbsp;';"));
      //<< write "DYNAMIC_caption.style.textAlign = 'left';"
      m$.Cmd.Write("DYNAMIC_caption.style.textAlign = 'left';");
      //<< write "DYNAMIC_caption.style.fontSize = '10pt';"
      m$.Cmd.Write("DYNAMIC_caption.style.fontSize = '10pt';");
      //<< write "DYNAMIC_caption.style.fontWeight = 'bold';"
      m$.Cmd.Write("DYNAMIC_caption.style.fontWeight = 'bold';");
    }
    //<< }
    //<< write "DYNAMIC_table.appendChild(DYNAMIC_caption);"
    m$.Cmd.Write("DYNAMIC_table.appendChild(DYNAMIC_caption);");
    //<< 
    //<< write "var DYNAMIC_tbody = document.createElement('tbody');"
    m$.Cmd.Write("var DYNAMIC_tbody = document.createElement('tbody');");
    //<< write "DYNAMIC_tbody.id = 'DYNAMIC_tbody"_idDyn_"';"
    m$.Cmd.Write(mOp.Concat(mOp.Concat("DYNAMIC_tbody.id = 'DYNAMIC_tbody",idDyn.get()),"';"));
    //<< write "DYNAMIC_table.appendChild(DYNAMIC_tbody);"
    m$.Cmd.Write("DYNAMIC_table.appendChild(DYNAMIC_tbody);");
    //<< 
    //<< write "var row=new Object();"
    m$.Cmd.Write("var row=new Object();");
    //<< write "row.cells = new Array();"
    m$.Cmd.Write("row.cells = new Array();");
    //<< 
    //<< set strColHdrCol = $$$Colour($$$WWW012ColourTableHeading($get(^WWW012(0,0,1))))
    strColHdrCol.set(include.COMSYS.$$$Colour(m$,include.WWWConst.$$$WWW012ColourTableHeading(m$,m$.Fnc.$get(m$.var("^WWW012",0,0,1)))));
    //<< for loop=1:1:$listlength(plstHeaders) {
    for (loop.set(1);(mOp.LessOrEqual(loop.get(),m$.Fnc.$listlength(plstHeaders.get())));loop.set(mOp.Add(loop.get(),1))) {
      //<< write "DynTable_AddHeaderCell(row, '"_$listget($listget(plstColTypes,loop),$$$Alignment)_"', '"_$listget(plstHeaders,loop)_"', '"_$get(strColHdrCol)_"');"
      m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("DynTable_AddHeaderCell(row, '",m$.Fnc.$listget(m$.Fnc.$listget(plstColTypes.get(),loop.get()),$$$Alignment(m$))),"', '"),m$.Fnc.$listget(plstHeaders.get(),loop.get())),"', '"),m$.Fnc.$get(strColHdrCol)),"');"));
    }
    //<< }
    //<< 
    //<< write "DynTable_CreateHeader(DYNAMIC_tbody, row);"
    m$.Cmd.Write("DynTable_CreateHeader(DYNAMIC_tbody, row);");
    //<< 
    //<< set idLine = ""
    idLine.set("");
    //<< for {
    for (;true;) {
      //<< set idLine = $order(^CacheTempDynamicTable(YUCI,YUSER,pidTableData,idLine))
      idLine.set(m$.Fnc.$order(m$.var("^CacheTempDynamicTable",m$.var("YUCI").get(),m$.var("YUSER").get(),pidTableData.get(),idLine.get())));
      //<< quit:idLine=""
      if (mOp.Equal(idLine.get(),"")) {
        break;
      }
      //<< 
      //<< set objLine     = $get(^CacheTempDynamicTable(YUCI,YUSER,pidTableData,idLine))
      objLine.set(m$.Fnc.$get(m$.var("^CacheTempDynamicTable",m$.var("YUCI").get(),m$.var("YUSER").get(),pidTableData.get(),idLine.get())));
      //<< set objLinkData = $get(^CacheTempDynamicTable(YUCI,YUSER,pidTableData,idLine,"data"))
      objLinkData.set(m$.Fnc.$get(m$.var("^CacheTempDynamicTable",m$.var("YUCI").get(),m$.var("YUSER").get(),pidTableData.get(),idLine.get(),"data")));
      //<< set objColData  = $get(^CacheTempDynamicTable(YUCI,YUSER,pidTableData,idLine,"col"))
      objColData.set(m$.Fnc.$get(m$.var("^CacheTempDynamicTable",m$.var("YUCI").get(),m$.var("YUSER").get(),pidTableData.get(),idLine.get(),"col")));
      //<< 
      //<< if objLinkData '= "" {
      if (mOp.NotEqual(objLinkData.get(),"")) {
        //<< write "var data=new Array();"
        m$.Cmd.Write("var data=new Array();");
        //<< write "var i=-1;"
        m$.Cmd.Write("var i=-1;");
        //<< for loop=1:1:$length(objLinkData,Y) {
        for (loop.set(1);(mOp.LessOrEqual(loop.get(),m$.Fnc.$length(objLinkData.get(),m$.var("Y").get())));loop.set(mOp.Add(loop.get(),1))) {
          //<< write "data[++i]='"_$$$JSText($piece(objLinkData,Y,loop))_"';"
          m$.Cmd.Write(mOp.Concat(mOp.Concat("data[++i]='",include.COMSYSString.$$$JSText(m$,m$.Fnc.$piece(objLinkData.get(),m$.var("Y").get(),loop.get()))),"';"));
        }
      }
      //<< }
      //<< }
      //<< 
      //<< write "var row=new Object();"
      m$.Cmd.Write("var row=new Object();");
      //<< write "row.cells=new Array();"
      m$.Cmd.Write("row.cells=new Array();");
      //<< for loop=1:1:$listlength(plstColTypes) {
      for (loop.set(1);(mOp.LessOrEqual(loop.get(),m$.Fnc.$listlength(plstColTypes.get())));loop.set(mOp.Add(loop.get(),1))) {
        //<< set strAlign = $$$LOWER($listget($listget(plstColTypes,loop),$$$Alignment))
        strAlign.set(include.COMSYSString.$$$LOWER(m$,m$.Fnc.$listget(m$.Fnc.$listget(plstColTypes.get(),loop.get()),$$$Alignment(m$))));
        //<< set strType  = $$$LOWER($listget($listget(plstColTypes,loop),$$$Type))
        strType.set(include.COMSYSString.$$$LOWER(m$,m$.Fnc.$listget(m$.Fnc.$listget(plstColTypes.get(),loop.get()),$$$Type(m$))));
        //<< 
        //<< //For a Row and Column (data record)
        //<< set strColor = $piece(objColData,Y,loop)
        strColor.set(m$.Fnc.$piece(objColData.get(),m$.var("Y").get(),loop.get()));
        //<< //Column for all Rows
        //<< if strColor = "" {
        if (mOp.Equal(strColor.get(),"")) {
          //<< set strColor = $$$LOWER($listget($listget(plstColTypes,loop),$$$Color))
          strColor.set(include.COMSYSString.$$$LOWER(m$,m$.Fnc.$listget(m$.Fnc.$listget(plstColTypes.get(),loop.get()),$$$Color(m$))));
        }
        //<< }
        //<< 
        //<< if strType = "display" {
        if (mOp.Equal(strType.get(),"display")) {
          //<< write "DynTable_AddDataCell(row, '"_strAlign_"', '"_$$$JSText($piece(objLine,Y,loop))_"', '"_$get(strColor)_"');"
          m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("DynTable_AddDataCell(row, '",strAlign.get()),"', '"),include.COMSYSString.$$$JSText(m$,m$.Fnc.$piece(objLine.get(),m$.var("Y").get(),loop.get()))),"', '"),m$.Fnc.$get(strColor)),"');"));
        }
        //<< 
        //<< } elseif strType = "link" {
        else if (mOp.Equal(strType.get(),"link")) {
          //<< write "DynTable_AddDataCellWithLink(row, data, '"_strAlign_"', '#', "_pstrFunction_", '"_$$$JSText($piece(objLine,Y,loop))_"', '"_$get(strColor)_"');"
          m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("DynTable_AddDataCellWithLink(row, data, '",strAlign.get()),"', '#', "),pstrFunction.get()),", '"),include.COMSYSString.$$$JSText(m$,m$.Fnc.$piece(objLine.get(),m$.var("Y").get(),loop.get()))),"', '"),m$.Fnc.$get(strColor)),"');"));
        }
      }
      //<< }
      //<< }
      //<< write "var idrow="_idLine_";"
      m$.Cmd.Write(mOp.Concat(mOp.Concat("var idrow=",idLine.get()),";"));
      //<< write "var Key="""_$translate(objLinkData,Y,$$$DELIM)_""";"
      m$.Cmd.Write(mOp.Concat(mOp.Concat("var Key=\"",m$.Fnc.$translate(objLinkData.get(),m$.var("Y").get(),$$$DELIM(m$))),"\";"));
      //<< 
      //<< write "var exec=null;"
      m$.Cmd.Write("var exec=null;");
      //<< //the reason for this is that the onclick event will not be setup for the Row if pstrExecute is not defined.
      //<< if pstrExecute'="" {
      if (mOp.NotEqual(pstrExecute.get(),"")) {
        //<< write "exec="""_pstrExecute_""";"
        m$.Cmd.Write(mOp.Concat(mOp.Concat("exec=\"",pstrExecute.get()),"\";"));
      }
      //<< }
      //<< 
      //<< write "DynTable_CreateRow(DYNAMIC_tbody,row,idrow,exec,Key);"
      m$.Cmd.Write("DynTable_CreateRow(DYNAMIC_tbody,row,idrow,exec,Key);");
    }
    //<< }
    //<< 
    //<< ; Append the DIV to the Dynamic Area
    //<< write "document.getElementById('DynamicArea').appendChild(DYNAMIC_div);"
    m$.Cmd.Write("document.getElementById('DynamicArea').appendChild(DYNAMIC_div);");
    //<< 
    //<< if pidEvent = $$$EnumWWWDYNTABLEGridLineFocus {
    if (mOp.Equal(pidEvent.get(),include.WWWConst.$$$EnumWWWDYNTABLEGridLineFocus(m$))) {
      //<< write "}"                      // ###END### ... MATCHING BRACE AT ###START###
      m$.Cmd.Write("}");
      //<< write "}"     //SR17484
      m$.Cmd.Write("}");
    }
    //<< }
    //<< 
    //<< 
    //<< //SR17494 - Only one line select the line if AutoSelect = YES
    //<< if pblnAutoSelect = $$$YES {
    if (mOp.Equal(pblnAutoSelect.get(),include.COMSYS.$$$YES(m$))) {
      //<< if $get(pstrExecute)'="" {
      if (mOp.NotEqual(m$.Fnc.$get(pstrExecute),"")) {
        //<< set idLine = +$order(^CacheTempDynamicTable(YUCI,YUSER,pidTableData,""))
        idLine.set(mOp.Positive(m$.Fnc.$order(m$.var("^CacheTempDynamicTable",m$.var("YUCI").get(),m$.var("YUSER").get(),pidTableData.get(),""))));
        //<< if idLine && (idLine=$order(^CacheTempDynamicTable(YUCI,YUSER,pidTableData,""),-1)) {
        if (mOp.Logical(idLine.get()) && (mOp.Equal(idLine.get(),m$.Fnc.$order(m$.var("^CacheTempDynamicTable",m$.var("YUCI").get(),m$.var("YUSER").get(),pidTableData.get(),""),mOp.Negative(1))))) {
          //<< //Row ID = "Dynbdy"_idRow; hence Dynbdy1 as there is only 1 Row
          //<< write "var input = document.getElementById ('Dynbdy"_idLine_"');"
          m$.Cmd.Write(mOp.Concat(mOp.Concat("var input = document.getElementById ('Dynbdy",idLine.get()),"');"));
          //<< write "input.focus();"
          m$.Cmd.Write("input.focus();");
          //<< write "DynTable_RowClick('',input.Key,input.exec);"
          m$.Cmd.Write("DynTable_RowClick('',input.Key,input.exec);");
        }
      }
    }
    //<< }
    //<< }
    //<< }
    //<< 
    //<< $$$EndScript()
    include.COMSYS.$$$EndScript(m$);
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< DisplayFields()
  public Object DisplayFields(Object ... _p) {
    //<< ;-------------------------------------------------------------------------------
    //<< ; Check whether current Dynamic Table is custom and if so show message otherwise
    //<< ; open dynamic table field entry form
    //<< ;
    //<< ; Params: None
    //<< ;
    //<< ; Returns: Nothing
    //<< ;
    //<< ; History:
    //<< ; 04-Jan-2007   PO      SR15351: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new objLine
    mVar objLine = m$.var("objLine");
    m$.newVar(objLine);
    //<< 
    //<< set objLine = $$$GRIDGetYFELD($$$GRIDGetCurrentYKEY)
    objLine.set(include.COMGridEdit31Interface.$$$GRIDGetYFELD(m$,include.COMGridEdit31Interface.$$$GRIDGetCurrentYKEY(m$)));
    //<< 
    //<< // Check would be best on draw but could not see how to quickly implement
    //<< if $$$WWW120DynTableBasis(objLine) = $$$EnumWWWBASEDONCustom {
    if (mOp.Equal(include.WWWConst.$$$WWW120DynTableBasis(m$,objLine),include.WWWConst.$$$EnumWWWBASEDONCustom(m$))) {
      //<< $$$Alert("WWW00060")  ; "Custom Dynamic Tables can not have fields entered against them."
      include.COMSYS.$$$Alert(m$,"WWW00060");
      //<< do GoToForm^COMGridEdit31G("WWW120")
      m$.Cmd.Do("COMGridEdit31G.GoToForm","WWW120");
    }
    //<< 
    //<< } else {
    else {
      //<< do GoToForm^COMGridEdit31G("WWW120DynTableDisp")
      m$.Cmd.Do("COMGridEdit31G.GoToForm","WWW120DynTableDisp");
    }
    //<< }
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< RowClick(pstrCallBack,pidRow,pidKey="")
  public Object RowClick(Object ... _p) {
    mVar pstrCallBack = m$.newVarRef("pstrCallBack",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pidRow = m$.newVarRef("pidRow",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pidKey = m$.newVarRef("pidKey",(((_p!=null)&&(_p.length>=3))?_p[2]:null),"");
    //<< ;-------------------------------------------------------------------------------
    //<< ; Get Link for Form & Key then open form.
    //<< ;
    //<< ; Parameters:
    //<< ;   pidRow  -   Row Id
    //<< ;   pidKey  -   Parameters for the Row, separated by '^'
    //<< ;
    //<< ; Returns: 1
    //<< ;
    //<< ; Assumes:YUCI,YUSER
    //<< ;
    //<< ; History:
    //<< ; 01-Jun-2009   PPP     SR16599: Added Rowclick functionality to DynaGrid
    //<< ;-------------------------------------------------------------------------------
    //<< new intCnt,strCallBack,strParam
    mVar intCnt = m$.var("intCnt");
    mVar strCallBack = m$.var("strCallBack");
    mVar strParam = m$.var("strParam");
    m$.newVar(intCnt,strCallBack,strParam);
    //<< 
    //<< if pidKey'="" {
    if (mOp.NotEqual(pidKey.get(),"")) {
      //<< set strParam = ""
      strParam.set("");
      //<< for intCnt=1:1:$length(pidKey,$$$DELIM) {
      for (intCnt.set(1);(mOp.LessOrEqual(intCnt.get(),m$.Fnc.$length(pidKey.get(),$$$DELIM(m$))));intCnt.set(mOp.Add(intCnt.get(),1))) {
        //<< set strParam=strParam_""""_$piece(pidKey,$$$DELIM,intCnt)
        strParam.set(mOp.Concat(mOp.Concat(strParam.get(),"\""),m$.Fnc.$piece(pidKey.get(),$$$DELIM(m$),intCnt.get())));
        //<< if intCnt '= $length(pidKey,$$$DELIM) {
        if (mOp.NotEqual(intCnt.get(),m$.Fnc.$length(pidKey.get(),$$$DELIM(m$)))) {
          //<< set strParam = strParam_""","
          strParam.set(mOp.Concat(strParam.get(),"\","));
        }
        //<< } else {
        else {
          //<< set strParam = strParam_""""
          strParam.set(mOp.Concat(strParam.get(),"\""));
        }
      }
      //<< }
      //<< }
      //<< 
      //<< if pstrCallBack'="" {
      if (mOp.NotEqual(pstrCallBack.get(),"")) {
        //<< if pstrCallBack'["(" {
        if (mOp.NotContains(pstrCallBack.get(),"(")) {
          //<< set pstrCallBack = pstrCallBack_"("""_pidRow_""","_strParam_")"
          pstrCallBack.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(pstrCallBack.get(),"(\""),pidRow.get()),"\","),strParam.get()),")"));
        }
        //<< }
        //<< xecute "do "_pstrCallBack
        m$.Cmd.Xecute(mOp.Concat("do ",pstrCallBack.get()));
      }
    }
    //<< }
    //<< }
    //<< quit 1
    return 1;
  }

//<< 
//<< 
}
