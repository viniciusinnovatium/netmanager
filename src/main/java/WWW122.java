//*****************************************************************************
//** TASC - ALPHALINC - MAC WWW122
//** Innovatium Systems - Code Converter - v1.27
//** 2014-05-22 00:15:32
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
//<< #include WWWConst
import include.WWWConst;
//<< #include COMConst
import include.COMConst;
//<< #include INConst
import include.INConst;

//<< WWW122
public class WWW122 extends mClass {

  public void main() {
    _WWW122();
  }

  public void _WWW122() {
    //<< 
    //<< ;-------------------------------------------------------------------------------
    //<< ; Description of Function :
    //<< ;       PRUEFEN DATENFELDER
    //<< ;
    //<< ; Inputs :
    //<< ;
    //<< ;
    //<< ; ByRef :
    //<< ;
    //<< ;
    //<< ; Returns :
    //<< ;
    //<< ;
    //<< ; History :
    //<< ; 06-Jun-2008   GRF     SR15668: new idField, move strType to FixField
    //<< ; 03-Apr-2007   RPW     SRBR014368: Rewrote and killed incorrect WWW127 entries.
    //<< ; 02.01.1998    DT
    //<< ;-------------------------------------------------------------------------------
    //<< new YY,YKEY1,idField,idSeq,objWWW003,strCaption
    mVar YY = m$.var("YY");
    mVar YKEY1 = m$.var("YKEY1");
    mVar idField = m$.var("idField");
    mVar idSeq = m$.var("idSeq");
    mVar objWWW003 = m$.var("objWWW003");
    mVar strCaption = m$.var("strCaption");
    m$.newVar(YY,YKEY1,idField,idSeq,objWWW003,strCaption);
    //<< 
    //<< quit:$get(YKEY)=""
    if (mOp.Equal(m$.Fnc.$get(m$.var("YKEY")),"")) {
      return;
    }
    //<< set YKEY1 = $$$KEY1(YKEY)
    YKEY1.set(include.COMSYSWWW.$$$KEY1(m$,m$.var("YKEY")));
    //<< quit:YKEY1=""
    if (mOp.Equal(YKEY1.get(),"")) {
      return;
    }
    //<< 
    //<< set YY = $piece($get(^WWW120(0,YKEY1,1)),Y,11)  ; $$$WWW120ClassUsedInForm()
    YY.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW120",0,YKEY1.get(),1)),m$.var("Y").get(),11));
    //<< 
    //<< set idField = ""
    idField.set("");
    //<< for {
    for (;true;) {
      //<< set idField = $order(^WWW122(0,YKEY1,idField))
      idField.set(m$.Fnc.$order(m$.var("^WWW122",0,YKEY1.get(),idField.get())));
      //<< quit:idField=""
      if (mOp.Equal(idField.get(),"")) {
        break;
      }
      //<< 
      //<< do FixField(YKEY1,idField)
      m$.Cmd.Do("FixField",YKEY1.get(),idField.get());
    }
    //<< }
    //<< quit
    return;
  }

  //<< 
  //<< 
  //<< OnAfterButtonLine(pYKEY,pYFELD)
  public Object OnAfterButtonLine(Object ... _p) {
    mVar pYKEY = m$.newVarRef("pYKEY",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pYFELD = m$.newVarRef("pYFELD",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Display a message if the field has no help text.
    //<< ;
    //<< ; Params:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 09-Sep-2008   shobby  BR014980: COMHelp* is temporary data now.
    //<< ; 09-Jan-2008   shobby  SRAdhoc: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new idField,idForm
    mVar idField = m$.var("idField");
    mVar idForm = m$.var("idForm");
    m$.newVar(idField,idForm);
    //<< 
    //<< if $$$DEVMODE {
    if (mOp.Logical(include.COMSYS.$$$DEVMODE(m$))) {
      //<< set idForm  = $$$KEY1(pYKEY)
      idForm.set(include.COMSYSWWW.$$$KEY1(m$,pYKEY));
      //<< set idField = $$$WWW122SequenceNumber(pYFELD)
      idField.set(include.WWWConst.$$$WWW122SequenceNumber(m$,pYFELD));
      //<< if (idForm'="") && (idField'="") && ($get(SPRACHE)'="") {
      if ((mOp.NotEqual(idForm.get(),"")) && (mOp.NotEqual(idField.get(),"")) && (mOp.NotEqual(m$.Fnc.$get(m$.var("SPRACHE")),""))) {
        //<< if $$$WWW127HelpText($get(^WWW127(0,idForm,"D",idField,SPRACHE,1)))="" {
        if (mOp.Equal(include.WWWConst.$$$WWW127HelpText(m$,m$.Fnc.$get(m$.var("^WWW127",0,idForm.get(),"D",idField.get(),m$.var("SPRACHE").get(),1))),"")) {
          //<< write "<B><FONT color=red>"_$$$Text("WWW00082")_"</FONT></B>"
          m$.Cmd.Write(mOp.Concat(mOp.Concat("<B><FONT color=red>",include.COMSYS.$$$Text(m$,"WWW00082")),"</FONT></B>"));
        }
      }
    }
    //<< }  ; "Warning: This field has no help text."
    //<< }
    //<< }
    //<< quit
    return null;
  }

  //<< 
  //<< FlatControls(pYKEY)
  public Object FlatControls(Object ... _p) {
    mVar pYKEY = m$.newVarRef("pYKEY",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; This routine determines what the 'Inherited' value of the 'Flat Controls' checkbox
    //<< ; will be when viewed from the Form Field screen.
    //<< ;
    //<< ; Inputs:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 08-Oct-2013   shobby  CORE-281: Some rework to include WWW120D
    //<< ; 12-Oct-2010   shobby  CORE-281: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new idForm,objWWW120,blnFlatControls,objWWW120D
    mVar idForm = m$.var("idForm");
    mVar objWWW120 = m$.var("objWWW120");
    mVar blnFlatControls = m$.var("blnFlatControls");
    mVar objWWW120D = m$.var("objWWW120D");
    m$.newVar(idForm,objWWW120,blnFlatControls,objWWW120D);
    //<< 
    //<< 
    //<< set blnFlatControls=""
    blnFlatControls.set("");
    //<< set idForm=$$$KEY1(pYKEY)
    idForm.set(include.COMSYSWWW.$$$KEY1(m$,pYKEY));
    //<< if idForm'="" {
    if (mOp.NotEqual(idForm.get(),"")) {
      //<< set objWWW120D=$get(^WWW120D(YM,idForm,YM,1))
      objWWW120D.set(m$.Fnc.$get(m$.var("^WWW120D",m$.var("YM").get(),idForm.get(),m$.var("YM").get(),1)));
      //<< set blnFlatControls = $$$WWW120DFlatControls(objWWW120D)
      blnFlatControls.set(include.WWWConst.$$$WWW120DFlatControls(m$,objWWW120D));
      //<< if blnFlatControls="" set blnFlatControls=$$FlatControls^WWW120D(idForm)
      if (mOp.Equal(blnFlatControls.get(),"")) {
        blnFlatControls.set(m$.fnc$("WWW120D.FlatControls",idForm.get()));
      }
    }
    //<< }
    //<< quit blnFlatControls
    return blnFlatControls.get();
  }

  //<< 
  //<< RelationWithSearchFunction(pYKEY)
  public Object RelationWithSearchFunction(Object ... _p) {
    mVar pYKEY = m$.newVarRef("pYKEY",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; This routine determines what the 'Inherited' value of the 'Relation With Search
    //<< ;   Function' checkbox will be when viewed from the Form Field screen.
    //<< ;
    //<< ; Called By: RelationWithSearchFunction^WWW122D, Form WWW122 F76 - Inherited From
    //<< ;
    //<< ; Inputs:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 12-Oct-2010   shobby  SRBR014837: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new idClass,idClassField,idField,idForm,intValue,objWWW003,objWWW120,objWWW122
    mVar idClass = m$.var("idClass");
    mVar idClassField = m$.var("idClassField");
    mVar idField = m$.var("idField");
    mVar idForm = m$.var("idForm");
    mVar intValue = m$.var("intValue");
    mVar objWWW003 = m$.var("objWWW003");
    mVar objWWW120 = m$.var("objWWW120");
    mVar objWWW122 = m$.var("objWWW122");
    m$.newVar(idClass,idClassField,idField,idForm,intValue,objWWW003,objWWW120,objWWW122);
    //<< 
    //<< set idForm   = $$$KEY1(pYKEY)
    idForm.set(include.COMSYSWWW.$$$KEY1(m$,pYKEY));
    //<< set idField  = $$$KEY2(pYKEY)
    idField.set(include.COMSYSWWW.$$$KEY2(m$,pYKEY));
    //<< set intValue = 0
    intValue.set(0);
    //<< 
    //<< if (idForm'="") && (idField'="") {
    if ((mOp.NotEqual(idForm.get(),"")) && (mOp.NotEqual(idField.get(),""))) {
      //<< set objWWW120 = $get(^WWW120(0,idForm,1))
      objWWW120.set(m$.Fnc.$get(m$.var("^WWW120",0,idForm.get(),1)));
      //<< set idClass   = $$$WWW120ClassUsedInForm(objWWW120)
      idClass.set(include.WWWConst.$$$WWW120ClassUsedInForm(m$,objWWW120));
      //<< if idClass'="" {
      if (mOp.NotEqual(idClass.get(),"")) {
        //<< set objWWW122    = $get(^WWW122(0,idForm,idField,1))
        objWWW122.set(m$.Fnc.$get(m$.var("^WWW122",0,idForm.get(),idField.get(),1)));
        //<< set idClassField = $$$WWW122SequenceNumber(objWWW122)
        idClassField.set(include.WWWConst.$$$WWW122SequenceNumber(m$,objWWW122));
        //<< if idClassField'="" {
        if (mOp.NotEqual(idClassField.get(),"")) {
          //<< set objWWW003 = $get(^WWW003(0,idClass,idClassField,1))
          objWWW003.set(m$.Fnc.$get(m$.var("^WWW003",0,idClass.get(),idClassField.get(),1)));
          //<< set intValue  = +$$$WWW003ShowRelationinSearchfunct(objWWW003)
          intValue.set(mOp.Positive(include.WWWConst.$$$WWW003ShowRelationinSearchfunct(m$,objWWW003)));
        }
      }
    }
    //<< }
    //<< }
    //<< }
    //<< quit intValue
    return intValue.get();
  }

  //<< 
  //<< 
  //<< Get(pidForm="",pidField="")
  public Object Get(Object ... _p) {
    mVar pidForm = m$.newVarRef("pidForm",(((_p!=null)&&(_p.length>=1))?_p[0]:null),"");
    mVar pidField = m$.newVarRef("pidField",(((_p!=null)&&(_p.length>=2))?_p[1]:null),"");
    //<< ;-------------------------------------------------------------------------------
    //<< ; Replacement for $get(^WWW122(0,<form name>,<field>,1))
    //<< ; This routine should be the only point of access when getting the properties of a
    //<< ; form as it will consider all customisations.
    //<< ; TODO language texts as well.
    //<< ; First implementation will be just to support COMGridEdit
    //<< ;
    //<< ; Params:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 08-Oct-2013   shobby  CORE-281: Some rework to include WWW120D
    //<< ; 14-May-2013   shobby  CORE-79.3: ListWidth changed to MaxListWidth
    //<< ; 04-Dec-2012   shobby  HEVA-679: CalcRelationalDataField
    //<< ; 23-Apr-2011   shobby  SR18000: FlatControls
    //<< ; 09-MAy-2011   GRF     SR17250: Dec Places for Inventory Costs
    //<< ; 29-Apr-2011   shobby  SR17714: Pass in YFORM to OnBeforeDisplay.
    //<< ; 11-Apr-2011   shobby  SR17701: Reinstated mask functionality
    //<< ; 11-Nov-2010   shobby  SR17612: $$$INHERIT
    //<< ; 12-Oct-2010   shobby  SRBR014837: The 'Relation With Search Function' field now
    //<< ;                           uses an 'Inherited Checkbox' control.
    //<< ; 06-Nov-2009   shobby  SR16981: If RelationDataField is empty default to first field.
    //<< ; 22-Oct-2009   shobby  SR16969: FixAnswerLengthInPixel
    //<< ; 29-Jun-2009   PPP     SR16663: Add the Calculated Relation Display Fields
    //<< ; 24-Mar-2009   shobby  SR16436: Check the class definition as to whether the
    //<< ;                           field should be mandatory.
    //<< ; 20-Oct-2008   GRF     SR12505: "Don't Allow Characters" over-ride
    //<< ; 04-Jul-2008   GRF     $$$YES boolean macro
    //<< ; 26-Jun-2008   GM      SRBR014802: Incl new field "PermanentButton" in WWW122/D
    //<< ; 28-Apr-2008   GM      SRBR014867: Incl new field "HyperlinktoForm" in WWW122/D
    //<< ; 09-Apr-2008   FIS     SR15668: Field "Relational Display Items" added for
    //<< ;                           default setting
    //<< ; 28-Feb-2008   shobby  SRBR014894: DoNotShowPrimaryKey
    //<< ; 08-Jan-2008   heber   SRBR014794: Mask fields removed from class WWW122D
    //<< ; 04-Jan-2008   shobby  SRAdHoc   : NoRelationValidation defaults from class.
    //<< ; 29-Nov-2007   GM      SRBR014805: New field "HideRelationClassIDs" in WWW122/D
    //<< ; 16-Nov-2007   shobby  - : Relation with search function defaults from class
    //<< ; 13-Nov-2007   shobby  SRBR014513: MemoFieldsWithFormatButtons
    //<< ; 12-Nov-2007   shobby  SRBR014786: Get relationships from the class as default.
    //<< ; 31-Oct-2007   shobby  SRBR014752: New property for 'Hyperlink to related class
    //<< ;                           for ReadOnly Field in grids'
    //<< ; 23-Oct-2007   shobby  SRBR014742: Got some relation information from the class
    //<< ;                           if it isn't specified in the form.
    //<< ; 18-Oct-2007   shobby  SRBR014566: ButtonBehindInputField
    //<< ; 12-Oct-2007   shobby  SRBR014625: New customisation field 'Modified Field Length'
    //<< ; 10-Oct-2007   shobby  SRBR014516: Included DataInputType
    //<< ; 10-Oct-2007   GRF     SR15563: Macro change
    //<< ; 03-Oct-2007   shobby  SRBR014592: Included RelationWithSearchFuncti
    //<< ; 27-Sep-2007   GRF     SR15603: Macro change
    //<< ; 05-Sep-2007   shobby  SRBR014638: Field is mandatory if UniqueKey is set on the class.
    //<< ; 04-Aug-2007   shobby  SRBR014614: Completed mapping of all customisations
    //<< ; 11-Aug-2007   shobby  SRBR014668: Make sure fields are hidden if either the
    //<< ;                       InputType or DataInputType mark them as hidden.
    //<< ; 12-Jul-2007   RPW     SRBR014553: set the objWWW122 so we don't get an
    //<< ;                       undefined if we do not get in here.
    //<< ; 10-Jul-2007   shobby  SRBR014553: Added some properties removed call to 'Copy'
    //<< ;                       subroutine.  (This way is faster)
    //<< ; 05-Jul-2007   shobby  SRBR014553: Created
    //<< ;-------------------------------------------------------------------------------
    //<< ; Decimal Place Rules :\
    //<< ;   1.  Number of decimal places is specified on the form.
    //<< ;   2.  If Form Decimal Places is not set, use Class Decimal Places.
    //<< ;   3.  If Custom Decimal Places is set, override with that.
    //<< ;   4a. If the field is an Inventory Cost and there is an INVORG setting then override with that.
    //<< ;   4b. If a quantity field has an association to a unit or item then use unit-based decimal places. [EXTERNAL SETTING]
    //<< ;-------------------------------------------------------------------------------
    //<< new blnInventCost,idClassField,idClassUsedInForm,intDP
    mVar blnInventCost = m$.var("blnInventCost");
    mVar idClassField = m$.var("idClassField");
    mVar idClassUsedInForm = m$.var("idClassUsedInForm");
    mVar intDP = m$.var("intDP");
    m$.newVar(blnInventCost,idClassField,idClassUsedInForm,intDP);
    //<< new objWWW003,objWWW120,objWWW122,objWWW122D,objWWW120D ;SR18000
    mVar objWWW003 = m$.var("objWWW003");
    mVar objWWW120 = m$.var("objWWW120");
    mVar objWWW122 = m$.var("objWWW122");
    mVar objWWW122D = m$.var("objWWW122D");
    mVar objWWW120D = m$.var("objWWW120D");
    m$.newVar(objWWW003,objWWW120,objWWW122,objWWW122D,objWWW120D);
    //<< 
    //<< set objWWW122 = ""
    objWWW122.set("");
    //<< 
    //<< if (pidForm'="") && (pidField'="") {
    if ((mOp.NotEqual(pidForm.get(),"")) && (mOp.NotEqual(pidField.get(),""))) {
      //<< set intDP         = ""                                  ; SR17250
      intDP.set("");
      //<< set blnInventCost = $$$NO                               ; SR17250
      blnInventCost.set(include.COMSYS.$$$NO(m$));
      //<< set objWWW122     = $get(^WWW122(0,pidForm,pidField,1))
      objWWW122.set(m$.Fnc.$get(m$.var("^WWW122",0,pidForm.get(),pidField.get(),1)));
      //<< 
      //<< ; Get the input type
      //<< set idClassField = $$$GetClassField(pidForm,pidField)
      idClassField.set(include.COMSYSWWW.$$$GetClassField(m$,pidForm,pidField));
      //<< 
      //<< set objWWW120         = $get(^WWW120(0,pidForm,1))
      objWWW120.set(m$.Fnc.$get(m$.var("^WWW120",0,pidForm.get(),1)));
      //<< set objWWW120D        = $get(^WWW120D(0,pidForm,YM,1)) ;SR18000
      objWWW120D.set(m$.Fnc.$get(m$.var("^WWW120D",0,pidForm.get(),m$.var("YM").get(),1)));
      //<< if idClassField'="" {
      if (mOp.NotEqual(idClassField.get(),"")) {
        //<< set idClassUsedInForm = $$$WWW120ClassUsedInForm(objWWW120)
        idClassUsedInForm.set(include.WWWConst.$$$WWW120ClassUsedInForm(m$,objWWW120));
        //<< if idClassUsedInForm'="" {
        if (mOp.NotEqual(idClassUsedInForm.get(),"")) {
          //<< set objWWW003 = $get(^WWW003(0,idClassUsedInForm,idClassField,1))
          objWWW003.set(m$.Fnc.$get(m$.var("^WWW003",0,idClassUsedInForm.get(),idClassField.get(),1)));
          //<< if objWWW003'="" { ; FIXME : $$$WWW003UniqueKey() [D22] is deprecated - canot be set on form and code run to clear any earlier settings <GRF>
          if (mOp.NotEqual(objWWW003.get(),"")) {
            //<< if '$$$WWW122MandatoryInputItem(objWWW122) set $$$WWW122MandatoryInputItem(objWWW122) = $$$WWW003UniqueKey(objWWW003)  ;BR014638
            if (mOp.Not(include.WWWConst.$$$WWW122MandatoryInputItem(m$,objWWW122))) {
              include.WWWConst.$$$WWW122MandatoryInputItemSet(m$,objWWW122,include.WWWConst.$$$WWW003UniqueKey(m$,objWWW003));
            }
            //<< if '$$$WWW122MandatoryInputItem(objWWW122) set $$$WWW122MandatoryInputItem(objWWW122) = $$$WWW003MandatoryField(objWWW003)  ;SR16436
            if (mOp.Not(include.WWWConst.$$$WWW122MandatoryInputItem(m$,objWWW122))) {
              include.WWWConst.$$$WWW122MandatoryInputItemSet(m$,objWWW122,include.WWWConst.$$$WWW003MandatoryField(m$,objWWW003));
            }
            //<< if $$$WWW122InputType(objWWW122)="" {
            if (mOp.Equal(include.WWWConst.$$$WWW122InputType(m$,objWWW122),"")) {
              //<< set $$$WWW122InputType(objWWW122) = $$$WWW003InputType(objWWW003)
              include.WWWConst.$$$WWW122InputTypeSet(m$,objWWW122,include.WWWConst.$$$WWW003InputType(m$,objWWW003));
            }
            //<< }
            //<< if $$$WWW122RelationDisplayOptions(objWWW122)= "" set $$$WWW122RelationDisplayOptions(objWWW122)= $$$WWW003RelationDisplayOptions(objWWW003)    ;SRBR014742
            if (mOp.Equal(include.WWWConst.$$$WWW122RelationDisplayOptions(m$,objWWW122),"")) {
              include.WWWConst.$$$WWW122RelationDisplayOptionsSet(m$,objWWW122,include.WWWConst.$$$WWW003RelationDisplayOptions(m$,objWWW003));
            }
            //<< if $$$WWW122RelationalPrimaryKey(objWWW122)  = "" set $$$WWW122RelationalPrimaryKey(objWWW122)  = $$$WWW003RelationalPrimaryKeys(objWWW003)     ;SRBR014742
            if (mOp.Equal(include.WWWConst.$$$WWW122RelationalPrimaryKey(m$,objWWW122),"")) {
              include.WWWConst.$$$WWW122RelationalPrimaryKeySet(m$,objWWW122,include.WWWConst.$$$WWW003RelationalPrimaryKeys(m$,objWWW003));
            }
            //<< if $$$WWW122DisplayIfSortCodes(objWWW122)    = "" set $$$WWW122DisplayIfSortCodes(objWWW122)    = $$$WWW003DisplayIfSortKeyEqual(objWWW003)     ;SRBR014742
            if (mOp.Equal(include.WWWConst.$$$WWW122DisplayIfSortCodes(m$,objWWW122),"")) {
              include.WWWConst.$$$WWW122DisplayIfSortCodesSet(m$,objWWW122,include.WWWConst.$$$WWW003DisplayIfSortKeyEqual(m$,objWWW003));
            }
            //<< if $$$WWW122RelationClass(objWWW122)         = "" set $$$WWW122RelationClass(objWWW122)         = $$$WWW003RelationDatabase(objWWW003)          ;SRBR014742
            if (mOp.Equal(include.WWWConst.$$$WWW122RelationClass(m$,objWWW122),"")) {
              include.WWWConst.$$$WWW122RelationClassSet(m$,objWWW122,include.WWWConst.$$$WWW003RelationDatabase(m$,objWWW003));
            }
            //<< if $$$WWW122RelationalDataField(objWWW122)   = "" set $$$WWW122RelationalDataField(objWWW122)   = $$$WWW003RelationalDisplayItems(objWWW003)    ;SR15668
            if (mOp.Equal(include.WWWConst.$$$WWW122RelationalDataField(m$,objWWW122),"")) {
              include.WWWConst.$$$WWW122RelationalDataFieldSet(m$,objWWW122,include.WWWConst.$$$WWW003RelationalDisplayItems(m$,objWWW003));
            }
            //<< 
            //<< if $$$WWW122CalcRelationalDataField(objWWW122)   = "" set $$$WWW122CalcRelationalDataField(objWWW122)   = $$$WWW003CalcRelationalDisplayItems(objWWW003)    ;SR16663
            if (mOp.Equal(include.WWWConst.$$$WWW122CalcRelationalDataField(m$,objWWW122),"")) {
              include.WWWConst.$$$WWW122CalcRelationalDataFieldSet(m$,objWWW122,include.WWWConst.$$$WWW003CalcRelationalDisplayItems(m$,objWWW003));
            }
            //<< 
            //<< if $$OnBeforeDisplay($$$WWW122RelationClass(objWWW122),pidForm) {   ; SR17714
            if (mOp.Logical(m$.fnc$("OnBeforeDisplay",include.WWWConst.$$$WWW122RelationClass(m$,objWWW122),pidForm.get()))) {
              //<< set $$$WWW122CalcRelationalDataField(objWWW122)=1               ; SR17714
              include.WWWConst.$$$WWW122CalcRelationalDataFieldSet(m$,objWWW122,1);
            }
            //<< }                                                                   ; SR17714
            //<< set blnInventCost = ''$$$WWW003InventoryCost(objWWW003)             ; SR17250
            blnInventCost.set(mOp.Not(mOp.Not(include.WWWConst.$$$WWW003InventoryCost(m$,objWWW003))));
            //<< if $$$WWW122Decimals(objWWW122)                  = "" set $$$WWW122Decimals(objWWW122)                 = $$$WWW003NoOfDecimals(objWWW003) ; SR17250
            if (mOp.Equal(include.WWWConst.$$$WWW122Decimals(m$,objWWW122),"")) {
              include.WWWConst.$$$WWW122DecimalsSet(m$,objWWW122,include.WWWConst.$$$WWW003NoOfDecimals(m$,objWWW003));
            }
            //<< if $$$WWW122SortTheRelation(objWWW122)           = "" set $$$WWW122SortTheRelation(objWWW122)          = $$$WWW003SortTheRelation(objWWW003)           ;SRBR014786
            if (mOp.Equal(include.WWWConst.$$$WWW122SortTheRelation(m$,objWWW122),"")) {
              include.WWWConst.$$$WWW122SortTheRelationSet(m$,objWWW122,include.WWWConst.$$$WWW003SortTheRelation(m$,objWWW003));
            }
            //<< if $$$WWW122RelationalDataField(objWWW122)       = "" set $$$WWW122RelationalDataField(objWWW122)      = $$$WWW003RelationalDisplayItems(objWWW003)    ;SRBR014786
            if (mOp.Equal(include.WWWConst.$$$WWW122RelationalDataField(m$,objWWW122),"")) {
              include.WWWConst.$$$WWW122RelationalDataFieldSet(m$,objWWW122,include.WWWConst.$$$WWW003RelationalDisplayItems(m$,objWWW003));
            }
            //<< if $$$WWW122DisplayRelationsDownwards(objWWW122) = "" set $$$WWW122DisplayRelationsDownwards(objWWW122)= $$$WWW003DisplayRelationsDownwards(objWWW003) ;SRBR014786
            if (mOp.Equal(include.WWWConst.$$$WWW122DisplayRelationsDownwards(m$,objWWW122),"")) {
              include.WWWConst.$$$WWW122DisplayRelationsDownwardsSet(m$,objWWW122,include.WWWConst.$$$WWW003DisplayRelationsDownwards(m$,objWWW003));
            }
            //<< if $$$WWW122NoRelationValidation(objWWW122)      = "" set $$$WWW122NoRelationValidation(objWWW122)     = $$$WWW003NoRelationValidation(objWWW003)
            if (mOp.Equal(include.WWWConst.$$$WWW122NoRelationValidation(m$,objWWW122),"")) {
              include.WWWConst.$$$WWW122NoRelationValidationSet(m$,objWWW122,include.WWWConst.$$$WWW003NoRelationValidation(m$,objWWW003));
            }
            //<< if $$$WWW122RelationWithSearchFuncti(objWWW122)  = $$$INHERIT  set $$$WWW122RelationWithSearchFuncti(objWWW122) = +$$$WWW003ShowRelationinSearchfunct(objWWW003) ;SRBR014837 ;SR17612
            if (mOp.Equal(include.WWWConst.$$$WWW122RelationWithSearchFuncti(m$,objWWW122),include.COMSYS.$$$INHERIT(m$))) {
              include.WWWConst.$$$WWW122RelationWithSearchFunctiSet(m$,objWWW122,mOp.Positive(include.WWWConst.$$$WWW003ShowRelationinSearchfunct(m$,objWWW003)));
            }
          }
        }
      }
      //<< }
      //<< }
      //<< }
      //<< if $data(^WWW122D(0,pidForm,pidField,0,1)) {
      if (mOp.Logical(m$.Fnc.$data(m$.var("^WWW122D",0,pidForm.get(),pidField.get(),0,1)))) {
        //<< set objWWW122D = $get(^WWW122D(0,pidForm,pidField,0,1))
        objWWW122D.set(m$.Fnc.$get(m$.var("^WWW122D",0,pidForm.get(),pidField.get(),0,1)));
        //<< 
        //<< if $$$WWW122DDefaultVariableInput(objWWW122D)     '="" set $$$WWW122DefaultVariableInput(objWWW122)      = $$$WWW122DDefaultVariableInput(objWWW122D)
        if (mOp.NotEqual(include.WWWConst.$$$WWW122DDefaultVariableInput(m$,objWWW122D),"")) {
          include.WWWConst.$$$WWW122DefaultVariableInputSet(m$,objWWW122,include.WWWConst.$$$WWW122DDefaultVariableInput(m$,objWWW122D));
        }
        //<< if '$$$WWW122MandatoryInputItem(objWWW122) {  ; Things can not be made 'not mandatory' with customisation  ; BR014638
        if (mOp.Not(include.WWWConst.$$$WWW122MandatoryInputItem(m$,objWWW122))) {
          //<< if $$$WWW122DMandatoryField(objWWW122D)       '="" set $$$WWW122MandatoryInputItem(objWWW122)        = $$$WWW122DMandatoryField(objWWW122D)
          if (mOp.NotEqual(include.WWWConst.$$$WWW122DMandatoryField(m$,objWWW122D),"")) {
            include.WWWConst.$$$WWW122MandatoryInputItemSet(m$,objWWW122,include.WWWConst.$$$WWW122DMandatoryField(m$,objWWW122D));
          }
        }
        //<< }
        //<< if $$$WWW122DFieldLength(objWWW122D)              '="" set $$$WWW122FieldSize(objWWW122)                 = $$$WWW122DFieldLength(objWWW122D)
        if (mOp.NotEqual(include.WWWConst.$$$WWW122DFieldLength(m$,objWWW122D),"")) {
          include.WWWConst.$$$WWW122FieldSizeSet(m$,objWWW122,include.WWWConst.$$$WWW122DFieldLength(m$,objWWW122D));
        }
        //<< if $$$WWW122DModule1(objWWW122D)                  '="" set $$$WWW122Module1(objWWW122)                   = $$$WWW122DModule1(objWWW122D)
        if (mOp.NotEqual(include.WWWConst.$$$WWW122DModule1(m$,objWWW122D),"")) {
          include.WWWConst.$$$WWW122Module1Set(m$,objWWW122,include.WWWConst.$$$WWW122DModule1(m$,objWWW122D));
        }
        //<< 
        //<< ; FIXME : Doesn't consider WWW122D1 and possible WWW1221 as language over-rides <GRF>
        //<< 
        //<< if $$$WWW122DFieldDescription(objWWW122D)         '="" set $$$WWW122ManualCaption(objWWW122)             = $$$WWW122DFieldDescription(objWWW122D)
        if (mOp.NotEqual(include.WWWConst.$$$WWW122DFieldDescription(m$,objWWW122D),"")) {
          include.WWWConst.$$$WWW122ManualCaptionSet(m$,objWWW122,include.WWWConst.$$$WWW122DFieldDescription(m$,objWWW122D));
        }
        //<< 
        //<< ;Input Type (order is important, hidden must be last)
        //<< if $$$WWW122DInputType(objWWW122D)                '="" set $$$WWW122InputType(objWWW122)                 = $$$WWW122DInputType(objWWW122D)
        if (mOp.NotEqual(include.WWWConst.$$$WWW122DInputType(m$,objWWW122D),"")) {
          include.WWWConst.$$$WWW122InputTypeSet(m$,objWWW122,include.WWWConst.$$$WWW122DInputType(m$,objWWW122D));
        }
        //<< if $$$WWW122DComboBox(objWWW122D)                 '="" set $$$WWW122InputType(objWWW122)                 = 4
        if (mOp.NotEqual(include.WWWConst.$$$WWW122DComboBox(m$,objWWW122D),"")) {
          include.WWWConst.$$$WWW122InputTypeSet(m$,objWWW122,4);
        }
        //<< if $$$WWW122DHiddenField(objWWW122D)          = $$$YES set $$$WWW122InputType(objWWW122)                 = 0
        if (mOp.Equal(include.WWWConst.$$$WWW122DHiddenField(m$,objWWW122D),include.COMSYS.$$$YES(m$))) {
          include.WWWConst.$$$WWW122InputTypeSet(m$,objWWW122,0);
        }
        //<< 
        //<< if $$$WWW122DDontAllowCharacters(objWWW122D)      '="" set $$$WWW122DontAllowChars(objWWW122)            = $$$WWW122DDontAllowCharacters(objWWW122D)   ; SR12505
        if (mOp.NotEqual(include.WWWConst.$$$WWW122DDontAllowCharacters(m$,objWWW122D),"")) {
          include.WWWConst.$$$WWW122DontAllowCharsSet(m$,objWWW122,include.WWWConst.$$$WWW122DDontAllowCharacters(m$,objWWW122D));
        }
        //<< if $$$WWW122DPatternMatch(objWWW122D)             '="" set $$$WWW122PatternMatch(objWWW122)              = $$$WWW122DPatternMatch(objWWW122D)
        if (mOp.NotEqual(include.WWWConst.$$$WWW122DPatternMatch(m$,objWWW122D),"")) {
          include.WWWConst.$$$WWW122PatternMatchSet(m$,objWWW122,include.WWWConst.$$$WWW122DPatternMatch(m$,objWWW122D));
        }
        //<< if $$$WWW122DRelationClass(objWWW122D)            '="" set $$$WWW122RelationClass(objWWW122)             = $$$WWW122DRelationClass(objWWW122D)
        if (mOp.NotEqual(include.WWWConst.$$$WWW122DRelationClass(m$,objWWW122D),"")) {
          include.WWWConst.$$$WWW122RelationClassSet(m$,objWWW122,include.WWWConst.$$$WWW122DRelationClass(m$,objWWW122D));
        }
        //<< if $$$WWW122DRelationalPrimaryKey(objWWW122D)     '="" set $$$WWW122RelationalPrimaryKey(objWWW122)      = $$$WWW122DRelationalPrimaryKey(objWWW122D)
        if (mOp.NotEqual(include.WWWConst.$$$WWW122DRelationalPrimaryKey(m$,objWWW122D),"")) {
          include.WWWConst.$$$WWW122RelationalPrimaryKeySet(m$,objWWW122,include.WWWConst.$$$WWW122DRelationalPrimaryKey(m$,objWWW122D));
        }
        //<< 
        //<< if $$$WWW122DRelationalDataField(objWWW122D)      '="" set $$$WWW122RelationalDataField(objWWW122)       = $$$WWW122DRelationalDataField(objWWW122D)
        if (mOp.NotEqual(include.WWWConst.$$$WWW122DRelationalDataField(m$,objWWW122D),"")) {
          include.WWWConst.$$$WWW122RelationalDataFieldSet(m$,objWWW122,include.WWWConst.$$$WWW122DRelationalDataField(m$,objWWW122D));
        }
        //<< if ($$$WWW122RelationalDataField(objWWW122)="") && ($$$WWW122RelationClass(objWWW122)'="") {
        if ((mOp.Equal(include.WWWConst.$$$WWW122RelationalDataField(m$,objWWW122),"")) && (mOp.NotEqual(include.WWWConst.$$$WWW122RelationClass(m$,objWWW122),""))) {
          //<< set $$$WWW122RelationalDataField(objWWW122) = $order(^WWW003(0,$$$WWW122RelationClass(objWWW122),""))
          include.WWWConst.$$$WWW122RelationalDataFieldSet(m$,objWWW122,m$.Fnc.$order(m$.var("^WWW003",0,include.WWWConst.$$$WWW122RelationClass(m$,objWWW122),"")));
        }
        //<< }
        //<< 
        //<< if $$$WWW122DRelationDisplayOptions(objWWW122D)   '="" set $$$WWW122RelationDisplayOptions(objWWW122)    = $$$WWW122DRelationDisplayOptions(objWWW122D)
        if (mOp.NotEqual(include.WWWConst.$$$WWW122DRelationDisplayOptions(m$,objWWW122D),"")) {
          include.WWWConst.$$$WWW122RelationDisplayOptionsSet(m$,objWWW122,include.WWWConst.$$$WWW122DRelationDisplayOptions(m$,objWWW122D));
        }
        //<< if $$$WWW122DNewGroup(objWWW122D)                 '="" set $$$WWW122NewGroup(objWWW122)                  = $$$WWW122DNewGroup(objWWW122D)
        if (mOp.NotEqual(include.WWWConst.$$$WWW122DNewGroup(m$,objWWW122D),"")) {
          include.WWWConst.$$$WWW122NewGroupSet(m$,objWWW122,include.WWWConst.$$$WWW122DNewGroup(m$,objWWW122D));
        }
        //<< if $$$WWW122DGroupName(objWWW122D)                '="" set $$$WWW122GroupName(objWWW122)                 = $$$WWW122DGroupName(objWWW122D)
        if (mOp.NotEqual(include.WWWConst.$$$WWW122DGroupName(m$,objWWW122D),"")) {
          include.WWWConst.$$$WWW122GroupNameSet(m$,objWWW122,include.WWWConst.$$$WWW122DGroupName(m$,objWWW122D));
        }
        //<< if $$$WWW122DUsersAccess(objWWW122D)              '="" set $$$WWW122UserAccess(objWWW122)                = $$$WWW122DUsersAccess(objWWW122D)
        if (mOp.NotEqual(include.WWWConst.$$$WWW122DUsersAccess(m$,objWWW122D),"")) {
          include.WWWConst.$$$WWW122UserAccessSet(m$,objWWW122,include.WWWConst.$$$WWW122DUsersAccess(m$,objWWW122D));
        }
        //<< if $$$WWW122DDisplayOnPage(objWWW122D)            '="" set $$$WWW122DisplayOnPageNumber(objWWW122)       = $$$WWW122DDisplayOnPage(objWWW122D)
        if (mOp.NotEqual(include.WWWConst.$$$WWW122DDisplayOnPage(m$,objWWW122D),"")) {
          include.WWWConst.$$$WWW122DisplayOnPageNumberSet(m$,objWWW122,include.WWWConst.$$$WWW122DDisplayOnPage(m$,objWWW122D));
        }
        //<< if $$$WWW122DLinePosition(objWWW122D)             '="" set $$$WWW122RowPosition(objWWW122)               = $$$WWW122DLinePosition(objWWW122D)
        if (mOp.NotEqual(include.WWWConst.$$$WWW122DLinePosition(m$,objWWW122D),"")) {
          include.WWWConst.$$$WWW122RowPositionSet(m$,objWWW122,include.WWWConst.$$$WWW122DLinePosition(m$,objWWW122D));
        }
        //<< if $$$WWW122DTabulatorPosition(objWWW122D)        '="" set $$$WWW122ColumnPosition(objWWW122)            = $$$WWW122DTabulatorPosition(objWWW122D)
        if (mOp.NotEqual(include.WWWConst.$$$WWW122DTabulatorPosition(m$,objWWW122D),"")) {
          include.WWWConst.$$$WWW122ColumnPositionSet(m$,objWWW122,include.WWWConst.$$$WWW122DTabulatorPosition(m$,objWWW122D));
        }
        //<< if $$$WWW122DModifyOnlyRelationFields(objWWW122D) '="" set $$$WWW122RelationFieldSequence(objWWW122)     = $$$WWW122DModifyOnlyRelationFields(objWWW122D)       ; SR15563
        if (mOp.NotEqual(include.WWWConst.$$$WWW122DModifyOnlyRelationFields(m$,objWWW122D),"")) {
          include.WWWConst.$$$WWW122RelationFieldSequenceSet(m$,objWWW122,include.WWWConst.$$$WWW122DModifyOnlyRelationFields(m$,objWWW122D));
        }
        //<< if $$$WWW122DAddNoOfSpaces(objWWW122D)            '="" set $$$WWW122AddNoOfSpaces(objWWW122)             = $$$WWW122DAddNoOfSpaces(objWWW122D)
        if (mOp.NotEqual(include.WWWConst.$$$WWW122DAddNoOfSpaces(m$,objWWW122D),"")) {
          include.WWWConst.$$$WWW122AddNoOfSpacesSet(m$,objWWW122,include.WWWConst.$$$WWW122DAddNoOfSpaces(m$,objWWW122D));
        }
        //<< if $$$WWW122DMemoFieldWithFormatButton(objWWW122D)'="" set $$$WWW122MemoFieldWithFormatButton(objWWW122) = $$$WWW122DMemoFieldWithFormatButton(objWWW122D) ;BR014513
        if (mOp.NotEqual(include.WWWConst.$$$WWW122DMemoFieldWithFormatButton(m$,objWWW122D),"")) {
          include.WWWConst.$$$WWW122MemoFieldWithFormatButtonSet(m$,objWWW122,include.WWWConst.$$$WWW122DMemoFieldWithFormatButton(m$,objWWW122D));
        }
        //<< ;---------------------------------------
        //<< ; FIXME : <GRF> This may not be a problem but we have possibly compulsory functionality
        //<< ;               being replaced by customised functionality that may not perform ALL the
        //<< ;               REQUIRED operations.
        //<< ;               If the *** EXECUTE *** hooks examine each entry separately, this particular
        //<< ;               code may not matter.
        //<< ;               We need clear guidelines of how they are supposed to interact.
        //<< ;               (WWWFORMD also overwrites these fields in a similar block of code.)
        //<< ;---------------------------------------
        //<< if $$$WWW122DExecuteBeforeDataField(objWWW122D)   '="" set $$$WWW122ExecuteBeforeDataField(objWWW122)   = $$$WWW122DExecuteBeforeDataField(objWWW122D)   ; SR15603
        if (mOp.NotEqual(include.WWWConst.$$$WWW122DExecuteBeforeDataField(m$,objWWW122D),"")) {
          include.WWWConst.$$$WWW122ExecuteBeforeDataFieldSet(m$,objWWW122,include.WWWConst.$$$WWW122DExecuteBeforeDataField(m$,objWWW122D));
        }
        //<< if $$$WWW122DExecuteAfterDataField(objWWW122D)    '="" set $$$WWW122ExecuteAfterDataField(objWWW122)    = $$$WWW122DExecuteAfterDataField(objWWW122D)    ; SR15603
        if (mOp.NotEqual(include.WWWConst.$$$WWW122DExecuteAfterDataField(m$,objWWW122D),"")) {
          include.WWWConst.$$$WWW122ExecuteAfterDataFieldSet(m$,objWWW122,include.WWWConst.$$$WWW122DExecuteAfterDataField(m$,objWWW122D));
        }
        //<< if $$$WWW122DExecuteWithinDataField(objWWW122D)   '="" set $$$WWW122ExecuteWithinDataField(objWWW122)   = $$$WWW122DExecuteWithinDataField(objWWW122D)   ; SR15603
        if (mOp.NotEqual(include.WWWConst.$$$WWW122DExecuteWithinDataField(m$,objWWW122D),"")) {
          include.WWWConst.$$$WWW122ExecuteWithinDataFieldSet(m$,objWWW122,include.WWWConst.$$$WWW122DExecuteWithinDataField(m$,objWWW122D));
        }
        //<< if $$$WWW122DComboBox(objWWW122D)                 '="" set $$$WWW122ComboboxFunction(objWWW122)         = $$$WWW122DComboBox(objWWW122D)
        if (mOp.NotEqual(include.WWWConst.$$$WWW122DComboBox(m$,objWWW122D),"")) {
          include.WWWConst.$$$WWW122ComboboxFunctionSet(m$,objWWW122,include.WWWConst.$$$WWW122DComboBox(m$,objWWW122D));
        }
        //<< if $$$WWW122DRelationTestOnEdit(objWWW122D)       '="" set $$$WWW122NoRelationValidation(objWWW122)     = $$$WWW122DRelationTestOnEdit(objWWW122D)
        if (mOp.NotEqual(include.WWWConst.$$$WWW122DRelationTestOnEdit(m$,objWWW122D),"")) {
          include.WWWConst.$$$WWW122NoRelationValidationSet(m$,objWWW122,include.WWWConst.$$$WWW122DRelationTestOnEdit(m$,objWWW122D));
        }
        //<< if $$$WWW122DMask(objWWW122D)                     '="" set $$$WWW122Mask(objWWW122)                     = $$$WWW122DMask(objWWW122D)                    ; SRBR014794 ;SR17701
        if (mOp.NotEqual(include.WWWConst.$$$WWW122DMask(m$,objWWW122D),"")) {
          include.WWWConst.$$$WWW122MaskSet(m$,objWWW122,include.WWWConst.$$$WWW122DMask(m$,objWWW122D));
        }
        //<< ;SR17701 ;if $$$WWW122DApplyMaskIfDataField(objWWW122D)    '="" set $$$WWW122ApplyMaskIfDataField(objWWW122)     = $$$WWW122DApplyMaskIfDataField(objWWW122D)   ; SRBR014794
        //<< ;SR17701 ;if $$$WWW122DContains(objWWW122D)                '="" set $$$WWW122Contains(objWWW122)                 = $$$WWW122DContains(objWWW122D)               ; SRBR014794
        //<< ;SR17701 ;if $$$WWW122DMask2(objWWW122D)                   '="" set $$$WWW122Mask2(objWWW122)                    = $$$WWW122DMask2(objWWW122D)                  ; SRBR014794
        //<< 
        //<< if $$$WWW122DRelationWithSearchFuncti(objWWW122D) '=$$$INHERIT  set $$$WWW122RelationWithSearchFuncti(objWWW122) = $$$WWW122DRelationWithSearchFuncti(objWWW122D) ;BR014592 ;BR014837 ;SR17612
        if (mOp.NotEqual(include.WWWConst.$$$WWW122DRelationWithSearchFuncti(m$,objWWW122D),include.COMSYS.$$$INHERIT(m$))) {
          include.WWWConst.$$$WWW122RelationWithSearchFunctiSet(m$,objWWW122,include.WWWConst.$$$WWW122DRelationWithSearchFuncti(m$,objWWW122D));
        }
        //<< if $$$WWW122DDataInputType(objWWW122D)            '="" set $$$WWW122DataInputType(objWWW122)            = $$$WWW122DDataInputType(objWWW122D) ;BR014516
        if (mOp.NotEqual(include.WWWConst.$$$WWW122DDataInputType(m$,objWWW122D),"")) {
          include.WWWConst.$$$WWW122DataInputTypeSet(m$,objWWW122,include.WWWConst.$$$WWW122DDataInputType(m$,objWWW122D));
        }
        //<< if $$$WWW122DModifiedFieldLength(objWWW122D)      '="" set $$$WWW122ModifiedFieldLength(objWWW122)      = $$$WWW122DModifiedFieldLength(objWWW122D) ;BR014265
        if (mOp.NotEqual(include.WWWConst.$$$WWW122DModifiedFieldLength(m$,objWWW122D),"")) {
          include.WWWConst.$$$WWW122ModifiedFieldLengthSet(m$,objWWW122,include.WWWConst.$$$WWW122DModifiedFieldLength(m$,objWWW122D));
        }
        //<< if $$$WWW122DButtonBehindInputField(objWWW122D)   '="" set $$$WWW122ButtonBehindInputField(objWWW122)   = $$$WWW122ButtonBehindInputField(objWWW122)_";***CUSTOM***;"_$$$WWW122DButtonBehindInputField(objWWW122D)
        if (mOp.NotEqual(include.WWWConst.$$$WWW122DButtonBehindInputField(m$,objWWW122D),"")) {
          include.WWWConst.$$$WWW122ButtonBehindInputFieldSet(m$,objWWW122,mOp.Concat(mOp.Concat(include.WWWConst.$$$WWW122ButtonBehindInputField(m$,objWWW122),";***CUSTOM***;"),include.WWWConst.$$$WWW122DButtonBehindInputField(m$,objWWW122D)));
        }
        //<< if $$$WWW122DHyperlinkToRelatedClass(objWWW122D)  '="" set $$$WWW122HyperlinkToRelatedClass(objWWW122)  = $$$WWW122DHyperlinkToRelatedClass(objWWW122D)  ;SRBR014752
        if (mOp.NotEqual(include.WWWConst.$$$WWW122DHyperlinkToRelatedClass(m$,objWWW122D),"")) {
          include.WWWConst.$$$WWW122HyperlinkToRelatedClassSet(m$,objWWW122,include.WWWConst.$$$WWW122DHyperlinkToRelatedClass(m$,objWWW122D));
        }
        //<< if $$$WWW122DHideRelationClassIDs(objWWW122D)     '="" set $$$WWW122HideRelationClassIDs(objWWW122)     = $$$WWW122DHideRelationClassIDs(objWWW122D)  ;SRBR014805
        if (mOp.NotEqual(include.WWWConst.$$$WWW122DHideRelationClassIDs(m$,objWWW122D),"")) {
          include.WWWConst.$$$WWW122HideRelationClassIDsSet(m$,objWWW122,include.WWWConst.$$$WWW122DHideRelationClassIDs(m$,objWWW122D));
        }
        //<< if $$$WWW122DDoNotShowPrimaryKey(objWWW122D)      '="" set $$$WWW122DoNotShowPrimaryKey(objWWW122)      = $$$WWW122DDoNotShowPrimaryKey(objWWW122D)  ;SRBR014894
        if (mOp.NotEqual(include.WWWConst.$$$WWW122DDoNotShowPrimaryKey(m$,objWWW122D),"")) {
          include.WWWConst.$$$WWW122DoNotShowPrimaryKeySet(m$,objWWW122,include.WWWConst.$$$WWW122DDoNotShowPrimaryKey(m$,objWWW122D));
        }
        //<< if $$$WWW122DHyperlinktoForm(objWWW122D)          '="" set $$$WWW122HyperlinktoForm(objWWW122)          = $$$WWW122DHyperlinktoForm(objWWW122D)  ;SRBR014867
        if (mOp.NotEqual(include.WWWConst.$$$WWW122DHyperlinktoForm(m$,objWWW122D),"")) {
          include.WWWConst.$$$WWW122HyperlinktoFormSet(m$,objWWW122,include.WWWConst.$$$WWW122DHyperlinktoForm(m$,objWWW122D));
        }
        //<< if $$$WWW122DPermanentButton(objWWW122D)          '="" set $$$WWW122PermanentButton(objWWW122)          = $$$WWW122DPermanentButton(objWWW122D)  ;SRBR014802
        if (mOp.NotEqual(include.WWWConst.$$$WWW122DPermanentButton(m$,objWWW122D),"")) {
          include.WWWConst.$$$WWW122PermanentButtonSet(m$,objWWW122,include.WWWConst.$$$WWW122DPermanentButton(m$,objWWW122D));
        }
        //<< if $$$WWW122DFixAnswerLengthInPixel(objWWW122D)   '="" set $$$WWW122FixAnswerLengthInPixel(objWWW122)   = $$$WWW122DFixAnswerLengthInPixel(objWWW122D)  ;SR16969
        if (mOp.NotEqual(include.WWWConst.$$$WWW122DFixAnswerLengthInPixel(m$,objWWW122D),"")) {
          include.WWWConst.$$$WWW122FixAnswerLengthInPixelSet(m$,objWWW122,include.WWWConst.$$$WWW122DFixAnswerLengthInPixel(m$,objWWW122D));
        }
        //<< 
        //<< ;   if $$$WWW122DManualCaption(objWWW122D)            '="" set $$$WWW122ManualCaption(objWWW122)          =$$$WWW122DManualCaption(objWWW122D)
        //<< ;      $$$FldWWW122SequenceNumber    - ignore not in customisation
        //<< 
        //<< if $$$WWW122DDecimals(objWWW122D)     '="" set $$$WWW122Decimals(objWWW122)     = $$$WWW122DDecimals(objWWW122D) ; SR17250
        if (mOp.NotEqual(include.WWWConst.$$$WWW122DDecimals(m$,objWWW122D),"")) {
          include.WWWConst.$$$WWW122DecimalsSet(m$,objWWW122,include.WWWConst.$$$WWW122DDecimals(m$,objWWW122D));
        }
        //<< if $$$WWW122DMaxListWidth(objWWW122D) '="" set $$$WWW122MaxListWidth(objWWW122) = $$$WWW122DMaxListWidth(objWWW122D)  ;SR17725 ;CORE-79.3
        if (mOp.NotEqual(include.WWWConst.$$$WWW122DMaxListWidth(m$,objWWW122D),"")) {
          include.WWWConst.$$$WWW122MaxListWidthSet(m$,objWWW122,include.WWWConst.$$$WWW122DMaxListWidth(m$,objWWW122D));
        }
        //<< set $$$WWW122FlatControls(objWWW122)     = $$$WWW122DFlatControls(objWWW122D)   ;SR18000 ;CORE-281
        include.WWWConst.$$$WWW122FlatControlsSet(m$,objWWW122,include.WWWConst.$$$WWW122DFlatControls(m$,objWWW122D));
        //<< if $$$WWW122DCalcRelationalDataField(objWWW122D) '="" set $$$WWW122CalcRelationalDataField(objWWW122)  = $$$WWW122DCalcRelationalDataField(objWWW122D) ;HEVA-679
        if (mOp.NotEqual(include.WWWConst.$$$WWW122DCalcRelationalDataField(m$,objWWW122D),"")) {
          include.WWWConst.$$$WWW122CalcRelationalDataFieldSet(m$,objWWW122,include.WWWConst.$$$WWW122DCalcRelationalDataField(m$,objWWW122D));
        }
      }
      //<< }
      //<< if $$$WWW122FlatControls(objWWW122) = "" set $$$WWW122FlatControls(objWWW122)=$$FlatControls^WWW122D(pidForm_","_pidField) ;CORE-281
      if (mOp.Equal(include.WWWConst.$$$WWW122FlatControls(m$,objWWW122),"")) {
        include.WWWConst.$$$WWW122FlatControlsSet(m$,objWWW122,m$.fnc$("WWW122D.FlatControls",mOp.Concat(mOp.Concat(pidForm.get(),","),pidField.get())));
      }
      //<< 
      //<< if $$$WWW122InputType(objWWW122)=0      set $$$WWW122DataInputType(objWWW122) = 15   ;BR014668
      if (mOp.Equal(include.WWWConst.$$$WWW122InputType(m$,objWWW122),0)) {
        include.WWWConst.$$$WWW122DataInputTypeSet(m$,objWWW122,15);
      }
      //<< if $$$WWW122DataInputType(objWWW122)=15 set $$$WWW122InputType(objWWW122)     = 0    ;BR014668
      if (mOp.Equal(include.WWWConst.$$$WWW122DataInputType(m$,objWWW122),15)) {
        include.WWWConst.$$$WWW122InputTypeSet(m$,objWWW122,0);
      }
      //<< if blnInventCost {        ; SR17250 vvv
      if (mOp.Logical(blnInventCost.get())) {
        //<< set intDP = $$$INVORGDecimalpointsforinventory($get(^INVORG(0,0,1)))
        intDP.set(include.INConst.$$$INVORGDecimalpointsforinventory(m$,m$.Fnc.$get(m$.var("^INVORG",0,0,1))));
        //<< if intDP'=""  set $$$WWW122Decimals(objWWW122) = intDP
        if (mOp.NotEqual(intDP.get(),"")) {
          include.WWWConst.$$$WWW122DecimalsSet(m$,objWWW122,intDP.get());
        }
      }
    }
    //<< }
    //<< 
    //<< }
    //<< quit objWWW122
    return objWWW122.get();
  }

  //<< 
  //<< OnBeforeDisplay(pidClass,YFORM="")
  public Object OnBeforeDisplay(Object ... _p) {
    mVar pidClass = m$.newVarRef("pidClass",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar YFORM = m$.newVarRef("YFORM",(((_p!=null)&&(_p.length>=2))?_p[1]:null),"");
    //<< ;-------------------------------------------------------------------------------
    //<< ; Determines if this has a special format for display in grids.
    //<< ;
    //<< ; Inputs:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 19-Jul-2011   shobby      SR17791: Test YFORM
    //<< ; 29-Apr-2011   shobby      SR17714: 2nd Parameter YFORM
    //<< ; 27-Apr-2011   shobby      SR17714: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new blnResult,objWWW120
    mVar blnResult = m$.var("blnResult");
    mVar objWWW120 = m$.var("objWWW120");
    m$.newVar(blnResult,objWWW120);
    //<< 
    //<< set blnResult=$$$NO
    blnResult.set(include.COMSYS.$$$NO(m$));
    //<< if YFORM'="" {          ;SR17791
    if (mOp.NotEqual(YFORM.get(),"")) {
      //<< set objWWW120=$get(^WWW120(0,YFORM,1))
      objWWW120.set(m$.Fnc.$get(m$.var("^WWW120",0,YFORM.get(),1)));
      //<< if $$$WWW120FormType(objWWW120)=12 {    ;Grid Edit Only
      if (mOp.Equal(include.WWWConst.$$$WWW120FormType(m$,objWWW120),12)) {
        //<< if pidClass'="" {
        if (mOp.NotEqual(pidClass.get(),"")) {
          //<< set blnResult=($data(^WWW001Hook(YM,pidClass,10)))||($data(^WWW001VARHooks(YM,pidClass,10)))
          blnResult.set(mOp.Logical((m$.Fnc.$data(m$.var("^WWW001Hook",m$.var("YM").get(),pidClass.get(),10)))) || mOp.Logical((m$.Fnc.$data(m$.var("^WWW001VARHooks",m$.var("YM").get(),pidClass.get(),10)))));
        }
      }
    }
    //<< }
    //<< }
    //<< }
    //<< quit blnResult
    return blnResult.get();
  }

  //<< 
  //<< HasOnBeforeDisplay(YKEY="",YFELD="")
  public Object HasOnBeforeDisplay(Object ... _p) {
    mVar YKEY = m$.newVarRef("YKEY",(((_p!=null)&&(_p.length>=1))?_p[0]:null),"");
    mVar YFELD = m$.newVarRef("YFELD",(((_p!=null)&&(_p.length>=2))?_p[1]:null),"");
    //<< ;-------------------------------------------------------------------------------
    //<< ; Determines whether to lock some formatting fields because a class hook is
    //<< ; already taking care of it..
    //<< ;
    //<< ; Inputs:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 29-Apr-2011   shobby      SR17714: Pass in YFORM as 2nd parameter.
    //<< ; 27-Apr-2011   shobby      SR17714: Created
    //<< ;-------------------------------------------------------------------------------
    //<< quit $$OnBeforeDisplay($$$WWW122RelationClass(YFELD),$$$KEY1(YKEY))
    return m$.fnc$("OnBeforeDisplay",include.WWWConst.$$$WWW122RelationClass(m$,YFELD),include.COMSYSWWW.$$$KEY1(m$,YKEY));
  }

  //<< 
  //<< 
  //<< FixField(pidForm="",pidField="")
  public Object FixField(Object ... _p) {
    mVar pidForm = m$.newVarRef("pidForm",(((_p!=null)&&(_p.length>=1))?_p[0]:null),"");
    mVar pidField = m$.newVarRef("pidField",(((_p!=null)&&(_p.length>=2))?_p[1]:null),"");
    //<< ;-------------------------------------------------------------------------------
    //<< ; Update the help fields and the captions.
    //<< ;
    //<< ; Inputs:
    //<< ;
    //<< ; ByRef:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 23-Nov-2009   shobby  SR17053: Only remove help texts on Manual Fields.  Help Texts
    //<< ;                           created against Regular Form fields may still belong to another
    //<< ;                           Regular Form Field, or may want to recreate a form field
    //<< ;                           that points to the class field without losing this help text.
    //<< ; 06-Jun-2008   GRF     SR15668: new strType
    //<< ; 11-Apr-2007   RPW     SRBR014368: Created
    //<< ;-------------------------------------------------------------------------------
    //<< quit:$get(YKEY)=""
    if (mOp.Equal(m$.Fnc.$get(m$.var("YKEY")),"")) {
      return null;
    }
    //<< 
    //<< new YY,YKEY1,idField,idSeq,objWWW003,strCaption,strType
    mVar YY = m$.var("YY");
    mVar YKEY1 = m$.var("YKEY1");
    mVar idField = m$.var("idField");
    mVar idSeq = m$.var("idSeq");
    mVar objWWW003 = m$.var("objWWW003");
    mVar strCaption = m$.var("strCaption");
    mVar strType = m$.var("strType");
    m$.newVar(YY,YKEY1,idField,idSeq,objWWW003,strCaption,strType);
    //<< 
    //<< if pidForm="" {
    if (mOp.Equal(pidForm.get(),"")) {
      //<< set YKEY1   = $$$KEY1(YKEY)    quit:YKEY1=""            ; *** EARLY EXIT ***
      YKEY1.set(include.COMSYSWWW.$$$KEY1(m$,m$.var("YKEY")));
      if (mOp.Equal(YKEY1.get(),"")) {
        return null;
      }
      //<< set idField = $$$KEY2(YKEY)
      idField.set(include.COMSYSWWW.$$$KEY2(m$,m$.var("YKEY")));
    }
    //<< } else {
    else {
      //<< set YKEY1   = pidForm          quit:YKEY1=""            ; *** EARLY EXIT ***
      YKEY1.set(pidForm.get());
      if (mOp.Equal(YKEY1.get(),"")) {
        return null;
      }
      //<< set idField = pidField
      idField.set(pidField.get());
    }
    //<< }
    //<< 
    //<< set YY = $piece($get(^WWW120(0,YKEY1,1)),Y,11)  ;DATEINAME ;file name
    YY.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW120",0,YKEY1.get(),1)),m$.var("Y").get(),11));
    //<< ;S DATEI=YY
    //<< 
    //<< set idSeq = $$$WWW122SequenceNumber($get(^WWW122(0,YKEY1,idField,1)))
    idSeq.set(include.WWWConst.$$$WWW122SequenceNumber(m$,m$.Fnc.$get(m$.var("^WWW122",0,YKEY1.get(),idField.get(),1))));
    //<< if idSeq="" { // Manual Field now
    if (mOp.Equal(idSeq.get(),"")) {
      //<< ; Field May have been deleted.
      //<< if ($get(^WWW122(0,YKEY1,idField,1))'="") && '$data(^WWW127(0,YKEY1,"M",idField,SPRACHE,1)) set ^WWW127(0,YKEY1,"M",idField,SPRACHE,1)="" ;17053
      if ((mOp.NotEqual(m$.Fnc.$get(m$.var("^WWW122",0,YKEY1.get(),idField.get(),1)),"")) && mOp.Not(m$.Fnc.$data(m$.var("^WWW127",0,YKEY1.get(),"M",idField.get(),m$.var("SPRACHE").get(),1)))) {
        m$.var("^WWW127",0,YKEY1.get(),"M",idField.get(),m$.var("SPRACHE").get(),1).set("");
      }
    }
    //<< ; SR17053 vvvv  Don't remove data field help text.  It may belong to another form field or may want to assign
    //<< ; a new form field in the future without losing the help text.
    //<< ;if $data(^WWW127(0,YKEY1,"D",idField)) {
    //<< ;       do KillChildren^COMUtils("WWW127",YKEY1_",D,"_idField)
    //<< ;}
    //<< ; SR17053 ^^^^
    //<< } else {
    else {
      //<< if '$data(^WWW127(0,YKEY1,"D",idField,SPRACHE,1)) set ^WWW127(0,YKEY1,"D",idField,SPRACHE,1) = ""
      if (mOp.Not(m$.Fnc.$data(m$.var("^WWW127",0,YKEY1.get(),"D",idField.get(),m$.var("SPRACHE").get(),1)))) {
        m$.var("^WWW127",0,YKEY1.get(),"D",idField.get(),m$.var("SPRACHE").get(),1).set("");
      }
      //<< if $data(^WWW127(0,YKEY1,"M",idField)) {
      if (mOp.Logical(m$.Fnc.$data(m$.var("^WWW127",0,YKEY1.get(),"M",idField.get())))) {
        //<< do KillChildren^COMUtils("WWW127",YKEY1_",M,"_idField)
        m$.Cmd.Do("COMUtils.KillChildren","WWW127",mOp.Concat(mOp.Concat(YKEY1.get(),",M,"),idField.get()));
      }
      //<< }
      //<< 
      //<< if YY'="" {
      if (mOp.NotEqual(YY.get(),"")) {
        //<< if '$data(^WWW003(0,YY,idSeq)) {
        if (mOp.Not(m$.Fnc.$data(m$.var("^WWW003",0,YY.get(),idSeq.get())))) {
          //<< set $piece(^WWW122(0,YKEY1,idField,1),Y,1) = ""
          m$.pieceVar(m$.var("^WWW122",0,YKEY1.get(),idField.get(),1),m$.var("Y").get(),1).set("");
        }
        //<< } else {
        else {
          //<< set objWWW003 = $get(^WWW003(0,YY,idSeq,1))
          objWWW003.set(m$.Fnc.$get(m$.var("^WWW003",0,YY.get(),idSeq.get(),1)));
          //<< if objWWW003'="" {
          if (mOp.NotEqual(objWWW003.get(),"")) {
            //<< set strCaption = $$$WWW003CaptionInForms(objWWW003)
            strCaption.set(include.WWWConst.$$$WWW003CaptionInForms(m$,objWWW003));
            //<< if $find($$$WWW003PropertyName(objWWW003),".") set strCaption = $$$WWW003PropertyName(objWWW003)
            if (mOp.Logical(m$.Fnc.$find(include.WWWConst.$$$WWW003PropertyName(m$,objWWW003),"."))) {
              strCaption.set(include.WWWConst.$$$WWW003PropertyName(m$,objWWW003));
            }
            //<< set $piece(^WWW122(0,YKEY1,idField,1),Y,12) = strCaption  ; $$$WWW122ManualCaption
            m$.pieceVar(m$.var("^WWW122",0,YKEY1.get(),idField.get(),1),m$.var("Y").get(),12).set(strCaption.get());
          }
          //<< 
          //<< } elseif $$$WWW003InputType(objWWW003)=0 {           ; enumDataHidden
          else if (mOp.Equal(include.WWWConst.$$$WWW003InputType(m$,objWWW003),0)) {
            //<< set $piece(^WWW122(0,YKEY1,idField,1),Y,2) = 15  ; $$$WWW122DataInputType = enumFormHidden
            m$.pieceVar(m$.var("^WWW122",0,YKEY1.get(),idField.get(),1),m$.var("Y").get(),2).set(15);
          }
        }
      }
      //<< }
      //<< }
      //<< } else {
      else {
        //<< set $piece(^WWW122(0,YKEY1,idField,1),Y,1) = ""          ; $$$WWW122SequenceNumber (manual field)  ;LÖSCHEN, WENN KEINE DATEI
        m$.pieceVar(m$.var("^WWW122",0,YKEY1.get(),idField.get(),1),m$.var("Y").get(),1).set("");
      }
    }
    //<< }
    //<< }
    //<< 
    //<< ; SR17053 vvvv  Don't remove data field help text.  It may belong to another form field or may want to assign
    //<< ; a new form field in the future without losing the help text.
    //<< ;for strType="M","D" {
    //<< ;   if $data(^WWW127(0,YKEY1,strType,idField)) {
    //<< ;       set idSeq = $$$WWW122SequenceNumber($get(^WWW122(0,YKEY1,idField,1)))
    //<< ;       if ((strType="D") && (idSeq="")) || ((strType="M") && (idSeq'="")) {
    //<< ;           do KillChildren^COMUtils("WWW127",YKEY1_","_strType_","_idField)
    //<< ;       }
    //<< ;   }
    //<< ;}
    //<< 
    //<< if $data(^WWW127(0,YKEY1,"M",idField)) {
    if (mOp.Logical(m$.Fnc.$data(m$.var("^WWW127",0,YKEY1.get(),"M",idField.get())))) {
      //<< set idSeq = $$$WWW122SequenceNumber($get(^WWW122(0,YKEY1,idField,1)))
      idSeq.set(include.WWWConst.$$$WWW122SequenceNumber(m$,m$.Fnc.$get(m$.var("^WWW122",0,YKEY1.get(),idField.get(),1))));
      //<< if (idSeq'="")||($get(^WWW122(0,YKEY1,idField,1))="") {
      if ((mOp.NotEqual(idSeq.get(),"")) || (mOp.Equal(m$.Fnc.$get(m$.var("^WWW122",0,YKEY1.get(),idField.get(),1)),""))) {
        //<< do KillChildren^COMUtils("WWW127",YKEY1_",M,"_idField)
        m$.Cmd.Do("COMUtils.KillChildren","WWW127",mOp.Concat(mOp.Concat(YKEY1.get(),",M,"),idField.get()));
      }
    }
    //<< }
    //<< }
    //<< ; SR17053 ^^^^^
    //<< 
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< OnAfterDelete(pYKEY,pYFELD)
  public Object OnAfterDelete(Object ... _p) {
    mVar pYKEY = m$.newVarRef("pYKEY",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pYFELD = m$.newVarRef("pYFELD",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Routine to run after deleting a form field
    //<< ;
    //<< ; Params: pYKEY     : The YKEY
    //<< ;         pYFELD    : The YFELD
    //<< ;
    //<< ; ByRefs:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 10-Sep-2008   shobby  BR014980    COMHelp* no longer necessary (Temp data now)
    //<< ; 03-Apr-2007   RPW     SRBR014368: Rebuild the HelpText for the form due to
    //<< ;                           bad data structures
    //<< ; 08-Nov-2006   SteveS  SR14915: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new idForm,idField
    mVar idForm = m$.var("idForm");
    mVar idField = m$.var("idField");
    m$.newVar(idForm,idField);
    //<< 
    //<< do FixField($$$KEY1(pYKEY),$$$KEY2(pYKEY))
    m$.Cmd.Do("FixField",include.COMSYSWWW.$$$KEY1(m$,pYKEY),include.COMSYSWWW.$$$KEY2(m$,pYKEY));
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< OnAfterSave(pYKEY)
  public Object OnAfterSave(Object ... _p) {
    mVar pYKEY = m$.newVarRef("pYKEY",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Routine to run after saving a data field
    //<< ;
    //<< ; Params: pYKEY     : The YKEY
    //<< ;
    //<< ; ByRefs:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 10-Sep-2008   shobby  BR014980    COMHelp* no longer necessary. (Temporary data now)
    //<< ; 03-Apr-2007   RPW     SRBR014368: Rebuild the help text for the form due to
    //<< ;                           bad data structure
    //<< ; 08-Nov-2006   SteveS  SR14915: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new idForm,idField,strStatus
    mVar idForm = m$.var("idForm");
    mVar idField = m$.var("idField");
    mVar strStatus = m$.var("strStatus");
    m$.newVar(idForm,idField,strStatus);
    //<< 
    //<< set strStatus = $$$OK
    strStatus.set(include.COMSYS.$$$OK(m$));
    //<< do FixField($$$KEY1(pYKEY),$$$KEY2(pYKEY))
    m$.Cmd.Do("FixField",include.COMSYSWWW.$$$KEY1(m$,pYKEY),include.COMSYSWWW.$$$KEY2(m$,pYKEY));
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< FixAllHelpText()
  public Object FixAllHelpText(Object ... _p) {
    //<< ;-------------------------------------------------------------------------------
    //<< ; Remove WWW127 entries that should not exist.
    //<< ;
    //<< ; This should be used manually to removed extra entries.
    //<< ;
    //<< ; Params:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 23-Nov-2009   shobby  SR17053:    Include Spanish
    //<< ; 10-Sep-2008   shobby  BR014980    COMHelp* no longer necessary. (Temporary data now)
    //<< ; 03-May-2007   RPW     SRBR014368: Convert Class Field # to Form Field #
    //<< ; 03-Apr-2007   RPW     SRBR014368: Created
    //<< ;-------------------------------------------------------------------------------
    //<< ;   ^WWW127(0,"WWW123","D",22,"EN",1)="..."
    //<< ;   ^COMHelpField(0,"WWW123","EN",19,1)="...~D22"
    //<< ;   ^WWW122(0,"WWW123",17,1)="22~~..."
    //<< ;   ^WWW122s(0,4,22,"WWW123",17)=""
    //<< ;
    //<< ;   ^WWW122(0,"INWEFREI",7,1)="~~..."   Manual Fields
    //<< ;-------------------------------------------------------------------------------
    //<< new idField,idForm,idFormField,SPRACHE,YKEY
    mVar idField = m$.var("idField");
    mVar idForm = m$.var("idForm");
    mVar idFormField = m$.var("idFormField");
    mVar SPRACHE = m$.var("SPRACHE");
    mVar YKEY = m$.var("YKEY");
    m$.newVar(idField,idForm,idFormField,SPRACHE,YKEY);
    //<< 
    //<< set idForm = ""
    idForm.set("");
    //<< for {
    for (;true;) {
      //<< set idForm = $order(^WWW120(0,idForm))
      idForm.set(m$.Fnc.$order(m$.var("^WWW120",0,idForm.get())));
      //<< quit:idForm=""
      if (mOp.Equal(idForm.get(),"")) {
        break;
      }
      //<< 
      //<< write !,"Fixing form : "_idForm
      m$.Cmd.Write("\n",mOp.Concat("Fixing form : ",idForm.get()));
      //<< 
      //<< set idField = ""
      idField.set("");
      //<< for {
      for (;true;) {
        //<< set idField = $order(^WWW122(0,idForm,idField))
        idField.set(m$.Fnc.$order(m$.var("^WWW122",0,idForm.get(),idField.get())));
        //<< quit:idField=""
        if (mOp.Equal(idField.get(),"")) {
          break;
        }
        //<< 
        //<< for SPRACHE="EN","PT","DE","ES" {
        for (Object _SPRACHE: new Object[] {"EN","PT","DE","ES"}) {
          SPRACHE.set(_SPRACHE);
          //<< set YKEY=idForm_$$$COMMA_idField
          YKEY.set(mOp.Concat(mOp.Concat(idForm.get(),include.COMSYSString.$$$COMMA(m$)),idField.get()));
          //<< do FixField()
          m$.Cmd.Do("FixField");
        }
      }
      //<< }
      //<< }
      //<< set idField = ""
      idField.set("");
      //<< for {
      for (;true;) {
        //<< set idField = $order(^WWW127(0,idForm,"D",idField))
        idField.set(m$.Fnc.$order(m$.var("^WWW127",0,idForm.get(),"D",idField.get())));
        //<< quit:idField=""
        if (mOp.Equal(idField.get(),"")) {
          break;
        }
        //<< 
        //<< set idFormField = $order(^WWW122s(0,4,idField,idForm,""))
        idFormField.set(m$.Fnc.$order(m$.var("^WWW122s",0,4,idField.get(),idForm.get(),"")));
        //<< for SPRACHE="EN","PT","DE","ES" {
        for (Object _SPRACHE: new Object[] {"EN","PT","DE","ES"}) {
          SPRACHE.set(_SPRACHE);
          //<< set YKEY=idForm_$$$COMMA_idFormField
          YKEY.set(mOp.Concat(mOp.Concat(idForm.get(),include.COMSYSString.$$$COMMA(m$)),idFormField.get()));
          //<< do FixField()
          m$.Cmd.Do("FixField");
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
  //<< OnBeforeSave(pidWWW122,pobjWWW122)
  public Object OnBeforeSave(Object ... _p) {
    mVar pidWWW122 = m$.newVarRef("pidWWW122",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pobjWWW122 = m$.newVarRef("pobjWWW122",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Verify whether entered masks are valid
    //<< ;
    //<< ; Params:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 15-Apr-2011   shobby  SR17701:    Only one mask to check.
    //<< ; 04-Jan-2008   heber   SRBR014794: Changed VerifyMask parameters.
    //<< ; 28-Aug-2007   Karine  SR15592:    Created a mask validation for WWW122D.
    //<< ; 27-Jul-2007   HeberB  SRBR014502: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new strStatus
    mVar strStatus = m$.var("strStatus");
    m$.newVar(strStatus);
    //<< 
    //<< set Q = $$$QSave
    mVar Q = m$.var("Q");
    Q.set(include.COMSYSWWW.$$$QSave(m$));
    //<< ;SR17701 set strStatus = $$VerifyMask^WWWFORM7($$$WWW122Mask(pobjWWW122),$$$WWW122Mask2(pobjWWW122))
    //<< set strStatus = $$VerifyMask^WWWFORM7($$$WWW122Mask(pobjWWW122)) ;SR17701
    strStatus.set(m$.fnc$("WWWFORM7.VerifyMask",include.WWWConst.$$$WWW122Mask(m$,pobjWWW122)));
    //<< if $$$ISERR(strStatus) {
    if (mOp.Logical(include.COMSYS.$$$ISERR(m$,strStatus))) {
      //<< $$$Alert(strStatus)
      include.COMSYS.$$$Alert(m$,strStatus);
      //<< set Q = $$$QDontSave
      Q.set(include.COMSYSWWW.$$$QDontSave(m$));
    }
    //<< }
    //<< quit
    return null;
  }

  //<< 
  //<< Renumber(YFORM,pintPage)
  public Object Renumber(Object ... _p) {
    mVar YFORM = m$.newVarRef("YFORM",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pintPage = m$.newVarRef("pintPage",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Tool to renumber the fields on a form to make it possible to put a new field
    //<< ; in to 2nd or subsequent column without having to rearrange the entire form
    //<< ; because many fields have the same row number.
    //<< ;
    //<< ; Inputs:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 13-Jun-2012   shobby      SR18037: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new idField,arrFields,intCounter,objWWW122,intRow,intCol,strStatus
    mVar idField = m$.var("idField");
    mVar arrFields = m$.var("arrFields");
    mVar intCounter = m$.var("intCounter");
    mVar objWWW122 = m$.var("objWWW122");
    mVar intRow = m$.var("intRow");
    mVar intCol = m$.var("intCol");
    mVar strStatus = m$.var("strStatus");
    m$.newVar(idField,arrFields,intCounter,objWWW122,intRow,intCol,strStatus);
    //<< 
    //<< kill arrFields
    arrFields.kill();
    //<< $$$VAR
    include.COMSYS.$$$VAR(m$);
    //<< tstart
    //<< set intCounter=0
    intCounter.set(0);
    //<< 
    //<< set idField="" for { set idField=$order(^WWW122(0,YFORM,idField)) quit:idField=""
    idField.set("");
    for (;true;) {
      idField.set(m$.Fnc.$order(m$.var("^WWW122",0,YFORM.get(),idField.get())));
      if (mOp.Equal(idField.get(),"")) {
        break;
      }
      //<< set objWWW122=$get(^WWW122(0,YFORM,idField,1))
      objWWW122.set(m$.Fnc.$get(m$.var("^WWW122",0,YFORM.get(),idField.get(),1)));
      //<< if $$$WWW122DisplayOnPageNumber(objWWW122)=pintPage {
      if (mOp.Equal(include.WWWConst.$$$WWW122DisplayOnPageNumber(m$,objWWW122),pintPage.get())) {
        //<< set intRow=$$$WWW122RowPosition(objWWW122)
        intRow.set(include.WWWConst.$$$WWW122RowPosition(m$,objWWW122));
        //<< set intCol=$$$WWW122ColumnPosition(objWWW122)
        intCol.set(include.WWWConst.$$$WWW122ColumnPosition(m$,objWWW122));
        //<< set arrFields(intRow,intCol,idField)=""
        arrFields.var(intRow.get(),intCol.get(),idField.get()).set("");
        //<< if $$$WWW122ColumnPosition(objWWW122)=1 {
        if (mOp.Equal(include.WWWConst.$$$WWW122ColumnPosition(m$,objWWW122),1)) {
          //<< set intCounter=intCounter+1
          intCounter.set(mOp.Add(intCounter.get(),1));
        }
      }
    }
    //<< }
    //<< }
    //<< }
    //<< write !,intCounter
    m$.Cmd.Write("\n",intCounter.get());
    //<< set intRow="" for { set intRow=$order(arrFields(intRow),-1) quit:intRow=""
    intRow.set("");
    for (;true;) {
      intRow.set(m$.Fnc.$order(arrFields.var(intRow.get()),mOp.Negative(1)));
      if (mOp.Equal(intRow.get(),"")) {
        break;
      }
      //<< set intCol="" for { set intCol=$order(arrFields(intRow,intCol),-1) quit:intCol=""
      intCol.set("");
      for (;true;) {
        intCol.set(m$.Fnc.$order(arrFields.var(intRow.get(),intCol.get()),mOp.Negative(1)));
        if (mOp.Equal(intCol.get(),"")) {
          break;
        }
        //<< set idField="" for { set idField=$order(arrFields(intRow,intCol,idField),-1) quit:idField=""
        idField.set("");
        for (;true;) {
          idField.set(m$.Fnc.$order(arrFields.var(intRow.get(),intCol.get(),idField.get()),mOp.Negative(1)));
          if (mOp.Equal(idField.get(),"")) {
            break;
          }
          //<< set arrFields(intRow,intCol,idField)=intCounter
          arrFields.var(intRow.get(),intCol.get(),idField.get()).set(intCounter.get());
          //<< set objWWW122=$get(^WWW122(0,YFORM,idField,1))
          objWWW122.set(m$.Fnc.$get(m$.var("^WWW122",0,YFORM.get(),idField.get(),1)));
          //<< set $$$WWW122RowPosition(objWWW122)=intCounter
          include.WWWConst.$$$WWW122RowPositionSet(m$,objWWW122,intCounter.get());
          //<< set strStatus=$$Save^COMUtils("WWW122",YFORM_","_idField,objWWW122,1)
          strStatus.set(m$.fnc$("COMUtils.Save","WWW122",mOp.Concat(mOp.Concat(YFORM.get(),","),idField.get()),objWWW122.get(),1));
          //<< break '$$$ISOK(strStatus)
          //<< if intCol=1 set intCounter=intCounter-1
          if (mOp.Equal(intCol.get(),1)) {
            intCounter.set(mOp.Subtract(intCounter.get(),1));
          }
        }
      }
    }
    //<< 
    //<< }
    //<< }
    //<< }
    //<< zw arrFields
    //<< quit
    return null;
  }

//<< 
}
