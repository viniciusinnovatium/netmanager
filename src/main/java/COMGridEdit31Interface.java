//*****************************************************************************
//** TASC - ALPHALINC - MAC COMGridEdit31Interface
//** Innovatium Systems - Code Converter - v1.28
//** 2014-05-26 21:14:09
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
import include.COMTab;
import include.COMEditor;
import include.COMSYSJS;
import include.$occInclude;

//<< COMGridEdit31Interface
public class COMGridEdit31Interface extends mClass {

  //<< 
  //<< #def1arg WWWDATEN(%args)    ^WWWDATEN(YM,+$horolog,YUSER,$get(^CacheTemp(YUSER,"Grid","Name")," "),"V",%args)
  public static Object $$$WWWDATEN(mContext m$, Object ... _p) {
    mVar p$args = m$.varRef("p$args",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.var("^WWWDATEN",m$.var("YM").get(),mOp.Positive(m$.Fnc.$horolog()),m$.var("YUSER").get(),m$.Fnc.$get(m$.var("^CacheTemp",m$.var("YUSER").get(),"Grid","Name")," "),"V",p$args.get()).get());
  }

  public static mVar $$$WWWDATENVar(mContext m$, Object ... _p) {
    mVar p$args = m$.varRef("p$args",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.var("^WWWDATEN",m$.var("YM").get(),mOp.Positive(m$.Fnc.$horolog()),m$.var("YUSER").get(),m$.Fnc.$get(m$.var("^CacheTemp",m$.var("YUSER").get(),"Grid","Name")," "),"V",p$args.get()));
  }

  public void main() {
    _COMGridEdit31Interface();
  }

  public void _COMGridEdit31Interface() {
  }

  //<< 
  //<< ;-------------------------------------------------------------------------------
  //<< ; All calls to COMGridEdit31* Routines from routines that are not COMGridEdit31*
  //<< ; Routine MUST use these ones.
  //<< ;
  //<< ; That way we can update calls without changing them everywhere.
  //<< ;
  //<< ; History:
  //<< ; 03-Oct-2008   GRF     SR15810: Show & for ByRef parameters and use bln macros
  //<< ; 25-Jan-2005   RPW     SR10061: Created
  //<< ;-------------------------------------------------------------------------------
  //<< 
  //<< 
  //<< UpdateStyle(pidObject,pobjParameters)
  public Object UpdateStyle(Object ... _p) {
    mVar pidObject = m$.newVarRef("pidObject",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pobjParameters = m$.newVarRef("pobjParameters",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< write " cgeUpdateStyle('"_pidObject_"','"_pobjParameters_"'); "
    m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(" cgeUpdateStyle('",pidObject.get()),"','"),pobjParameters.get()),"'); "));
    //<< quit
    return null;
  }

  //<< 
  //<< Update(pstrFormLine,pYKEY,YFELD)
  public Object Update(Object ... _p) {
    mVar pstrFormLine = m$.newVarRef("pstrFormLine",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pYKEY = m$.newVarRef("pYKEY",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar YFELD = m$.newVarRef("YFELD",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Update all lines on the grid.  Can be used if a field on the header form affects
    //<< ; the contents of grid lines as a result of core/customisation rules.
    //<< ;
    //<< ; Inputs:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 27-Nov-2009   shobby  SR17034: All columns should be updated in the grid.
    //<< ; 12-Aug-2009   shobby  SR16511: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new arrGrid,idLine,objLine,YKEY
    mVar arrGrid = m$.var("arrGrid");
    mVar idLine = m$.var("idLine");
    mVar objLine = m$.var("objLine");
    mVar YKEY = m$.var("YKEY");
    m$.newVar(arrGrid,idLine,objLine,YKEY);
    //<< 
    //<< $$$GRIDGetContents(.arrGrid)
    include.COMGridEdit31Interface.$$$GRIDGetContents(m$,arrGrid);
    //<< set idLine = ""
    idLine.set("");
    //<< for {
    for (;true;) {
      //<< set idLine = $order(arrGrid(pYKEY,idLine))
      idLine.set(m$.Fnc.$order(arrGrid.var(pYKEY.get(),idLine.get())));
      //<< quit:idLine=""
      if (mOp.Equal(idLine.get(),"")) {
        break;
      }
      //<< 
      //<< set objLine = arrGrid(pYKEY,idLine)
      objLine.set(arrGrid.var(pYKEY.get(),idLine.get()).get());
      //<< set YKEY    = pYKEY_","_idLine
      YKEY.set(mOp.Concat(mOp.Concat(pYKEY.get(),","),idLine.get()));
      //<< do CheckRules^WWWEVENT(pstrFormLine,.objLine,1)
      m$.Cmd.Do("WWWEVENT.CheckRules",pstrFormLine.get(),objLine,1);
      //<< set arrGrid(pYKEY,idLine) = objLine
      arrGrid.var(pYKEY.get(),idLine.get()).set(objLine.get());
    }
    //<< }
    //<< set ^WWWDATEN(0,+$horolog,YUSER,pstrFormLine,"V","REFERENCELIST") = ","_$$GetColumnOrder^COMGridEdit31Body(pstrFormLine)_"," ;SR17034
    m$.var("^WWWDATEN",0,mOp.Positive(m$.Fnc.$horolog()),m$.var("YUSER").get(),pstrFormLine.get(),"V","REFERENCELIST").set(mOp.Concat(mOp.Concat(",",m$.fnc$("COMGridEdit31Body.GetColumnOrder",pstrFormLine.get())),","));
    //<< $$$GRIDSetContents(.arrGrid,$$$YES,,$$$YES)         ; SR17034
    include.COMGridEdit31Interface.$$$GRIDSetContents(m$,arrGrid,include.COMSYS.$$$YES(m$),null,include.COMSYS.$$$YES(m$));
    //<< 
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< GetYFORMFromLine(pYFORM="",pintLine="")
  public Object GetYFORMFromLine(Object ... _p) {
    mVar pYFORM = m$.newVarRef("pYFORM",(((_p!=null)&&(_p.length>=1))?_p[0]:null),"");
    mVar pintLine = m$.newVarRef("pintLine",(((_p!=null)&&(_p.length>=2))?_p[1]:null),"");
    //<< ;-------------------------------------------------------------------------------
    //<< ; Determine the type of form that is on this line of the grid
    //<< ;
    //<< ; Params:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 08-Nov-2005   shobby  SR13804:Created
    //<< ;-------------------------------------------------------------------------------
    //<< new strYFORM
    mVar strYFORM = m$.var("strYFORM");
    m$.newVar(strYFORM);
    //<< 
    //<< set strYFORM = ""
    strYFORM.set("");
    //<< if (pYFORM'="") && (pintLine'="") {
    if ((mOp.NotEqual(pYFORM.get(),"")) && (mOp.NotEqual(pintLine.get(),""))) {
      //<< if $data(^WWWDATEN(0,+$horolog,YUSER,pYFORM,"V","REFERENCEKEY",pintLine,1)) {
      if (mOp.Logical(m$.Fnc.$data(m$.var("^WWWDATEN",0,mOp.Positive(m$.Fnc.$horolog()),m$.var("YUSER").get(),pYFORM.get(),"V","REFERENCEKEY",pintLine.get(),1)))) {
        //<< set strYFORM = pYFORM
        strYFORM.set(pYFORM.get());
      }
      //<< } else {
      else {
        //<< set strYFORM = $get(^WWWDATEN(0,+$horolog,YUSER,pYFORM,"V","LINKS"))
        strYFORM.set(m$.Fnc.$get(m$.var("^WWWDATEN",0,mOp.Positive(m$.Fnc.$horolog()),m$.var("YUSER").get(),pYFORM.get(),"V","LINKS")));
      }
    }
    //<< }
    //<< }
    //<< quit strYFORM
    return strYFORM.get();
  }

  //<< 
  //<< 
  //<< ;======================== COMGRIDEDIT31G ========================
  //<< 
  //<< GetLineId(YKEY,pYFORM="")
  public Object GetLineId(Object ... _p) {
    mVar YKEY = m$.newVarRef("YKEY",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pYFORM = m$.newVarRef("pYFORM",(((_p!=null)&&(_p.length>=2))?_p[1]:null),"");
    //<< quit $$GetLineId^COMGridEdit31G(YKEY,pYFORM)
    return m$.fnc$("COMGridEdit31G.GetLineId",YKEY.get(),pYFORM.get());
  }

  //<< 
  //<< 
  //<< IsSavedLine(pidForm,pidKey="")
  public Object IsSavedLine(Object ... _p) {
    mVar pidForm = m$.newVarRef("pidForm",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pidKey = m$.newVarRef("pidKey",(((_p!=null)&&(_p.length>=2))?_p[1]:null),"");
    //<< quit $$IsSavedLine^COMGridEdit31G(pidForm,pidKey="")
    return m$.fnc$("COMGridEdit31G.IsSavedLine",pidForm.get(),mOp.Equal(pidKey.get(),""));
  }

  //<< 
  //<< 
  //<< GetObject(&parrGrid,pblnGetGrid=$$$YES,pstrYFORM="")
  public Object GetObject(Object ... _p) {
    mVar parrGrid = m$.newVarRef("parrGrid",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pblnGetGrid = m$.newVarRef("pblnGetGrid",(((_p!=null)&&(_p.length>=2))?_p[1]:null),include.COMSYS.$$$YES(m$));
    mVar pstrYFORM = m$.newVarRef("pstrYFORM",(((_p!=null)&&(_p.length>=3))?_p[2]:null),"");
    //<< ;-------------------------------------------------------------------------------
    //<< ; Gets ***BOTH*** the header and line contents of what is currently on the screen
    //<< ;
    //<< ; Returns:nothing (but pobjGrid should be passed by reference and have the
    //<< ;   following structure):
    //<< ;       set pobjData="Header~Data~Fields~Here"
    //<< ;       set pobjData("Header and RowNumber")="Grid Data fields here"
    //<< ;
    //<< ; History:
    //<< ; 10-Apr-2010   GRF     SR17177: parrGrid rather than pobjData
    //<< ; 10-Mar-2005   PaulK   Created
    //<< ;-------------------------------------------------------------------------------
    //<< if pblnGetGrid $$$GRIDGetContents(.parrGrid,pstrYFORM)
    if (mOp.Logical(pblnGetGrid.get())) {
      include.COMGridEdit31Interface.$$$GRIDGetContents(m$,parrGrid,pstrYFORM);
    }
    //<< set parrGrid = $$GetYFELDContainer()
    parrGrid.set(m$.fnc$("GetYFELDContainer"));
    //<< quit
    return null;
  }

  //<< 
  //<< GetGridContents(&parrGrid,YFORM="",pblnIncludeKilled=$$$NO)
  public Object GetGridContents(Object ... _p) {
    mVar parrGrid = m$.newVarRef("parrGrid",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar YFORM = m$.newVarRef("YFORM",(((_p!=null)&&(_p.length>=2))?_p[1]:null),"");
    mVar pblnIncludeKilled = m$.newVarRef("pblnIncludeKilled",(((_p!=null)&&(_p.length>=3))?_p[2]:null),include.COMSYS.$$$NO(m$));
    //<< ; use $$$GRIDGetContents(%args) instead of calling here
    //<< do GetGridContents^COMGridEdit31G(.parrGrid,YFORM,pblnIncludeKilled)
    m$.Cmd.Do("COMGridEdit31G.GetGridContents",parrGrid,YFORM.get(),pblnIncludeKilled.get());
    //<< quit
    return null;
  }

  //<< 
  //<< SetGridContents(&parrGrid,pblnUpdateScreen=$$$YES,pstrYFORM="",pblnAllLines=$$$NO)
  public Object SetGridContents(Object ... _p) {
    mVar parrGrid = m$.newVarRef("parrGrid",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pblnUpdateScreen = m$.newVarRef("pblnUpdateScreen",(((_p!=null)&&(_p.length>=2))?_p[1]:null),include.COMSYS.$$$YES(m$));
    mVar pstrYFORM = m$.newVarRef("pstrYFORM",(((_p!=null)&&(_p.length>=3))?_p[2]:null),"");
    mVar pblnAllLines = m$.newVarRef("pblnAllLines",(((_p!=null)&&(_p.length>=4))?_p[3]:null),include.COMSYS.$$$NO(m$));
    //<< ; use $$$GRIDSetContents(%args) instead of calling here
    //<< do SetGridContents^COMGridEdit31G(.parrGrid,pblnUpdateScreen,pstrYFORM,pblnAllLines)
    m$.Cmd.Do("COMGridEdit31G.SetGridContents",parrGrid,pblnUpdateScreen.get(),pstrYFORM.get(),pblnAllLines.get());
    //<< quit
    return null;
  }

  //<< 
  //<< GetYKEYContainer()   ; use $$$GRIDYKEYContainer instead of calling here
  public Object GetYKEYContainer(Object ... _p) {
    //<< quit $get($$$WWWDATEN("REFERENCEKEY"))
    return m$.Fnc.$get($$$WWWDATENVar(m$,"REFERENCEKEY"));
  }

  //<< 
  //<< GetYFELDContainer()   ; use $$$GRIDYFELDContainer instead of calling here
  public Object GetYFELDContainer(Object ... _p) {
    //<< quit $$GetYFELDContainer^COMGridEdit31G()
    return m$.fnc$("COMGridEdit31G.GetYFELDContainer");
  }

  //<< 
  //<< GetYMFELDContainer(pidType)
  public Object GetYMFELDContainer(Object ... _p) {
    mVar pidType = m$.newVarRef("pidType",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ; use $$$GRIDYMFELDContainer or $$$GRIDPREVYMFELDContainer instead of calling here
    //<< quit $$GetYMFELDContainer^COMGridEdit31G($get(pidType))
    return m$.fnc$("COMGridEdit31G.GetYMFELDContainer",m$.Fnc.$get(pidType));
  }

  //<< 
  //<< GridExists()
  public Object GridExists(Object ... _p) {
    //<< quit $$GridExists^COMGridEdit31G()
    return m$.fnc$("COMGridEdit31G.GridExists");
  }

  //<< 
  //<< UpdateHeaderField(pstrField,pstrValue,pFieldType="")
  public Object UpdateHeaderField(Object ... _p) {
    mVar pstrField = m$.newVarRef("pstrField",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pstrValue = m$.newVarRef("pstrValue",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pFieldType = m$.newVarRef("pFieldType",(((_p!=null)&&(_p.length>=3))?_p[2]:null),"");
    //<< do UpdateHeaderField^COMGridEdit31G(pstrField,pstrValue,pFieldType)
    m$.Cmd.Do("COMGridEdit31G.UpdateHeaderField",pstrField.get(),pstrValue.get(),pFieldType.get());
    //<< quit
    return null;
  }

  //<< 
  //<< Enabled(YVOR,YTXT,YHID,pYYKEY="",pYTYP="")
  public Object Enabled(Object ... _p) {
    mVar YVOR = m$.newVarRef("YVOR",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar YTXT = m$.newVarRef("YTXT",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar YHID = m$.newVarRef("YHID",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    mVar pYYKEY = m$.newVarRef("pYYKEY",(((_p!=null)&&(_p.length>=4))?_p[3]:null),"");
    mVar pYTYP = m$.newVarRef("pYTYP",(((_p!=null)&&(_p.length>=5))?_p[4]:null),"");
    //<< quit $$Enabled^COMGridEdit31G(YVOR,YTXT,YHID,pYYKEY,pYTYP)
    return m$.fnc$("COMGridEdit31G.Enabled",YVOR.get(),YTXT.get(),YHID.get(),pYYKEY.get(),pYTYP.get());
  }

  //<< 
  //<< GetYKEY(pintRow)
  public Object GetYKEY(Object ... _p) {
    mVar pintRow = m$.newVarRef("pintRow",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; History:
    //<< ; 04-Aug-2005   JW      SR13186: Remove quotes for callbacks to the grid
    //<< ;-------------------------------------------------------------------------------
    //<< quit $translate($$GetYKEY^COMGridEdit31G($get(pintRow)),$$$DBLQUOTE)
    return m$.Fnc.$translate(m$.fnc$("COMGridEdit31G.GetYKEY",m$.Fnc.$get(pintRow)),include.COMSYSString.$$$DBLQUOTE(m$));
  }

  //<< 
  //<< GetYFELDEX(YFORM,pYKEY)
  public Object GetYFELDEX(Object ... _p) {
    mVar YFORM = m$.newVarRef("YFORM",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pYKEY = m$.newVarRef("pYKEY",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< ; use $$$GRIDGetYFELD(%key) instead of calling here if NOT specifying YFORM
    //<< quit $$GetYFELDEX^COMGridEdit31G($get(YFORM),$get(pYKEY))
    return m$.fnc$("COMGridEdit31G.GetYFELDEX",m$.Fnc.$get(YFORM),m$.Fnc.$get(pYKEY));
  }

  //<< 
  //<< UpdateContainer(pidField="")
  public Object UpdateContainer(Object ... _p) {
    mVar pidField = m$.newVarRef("pidField",(((_p!=null)&&(_p.length>=1))?_p[0]:null),"");
    //<< do UpdateContainer^COMGridEdit31G(pidField)
    m$.Cmd.Do("COMGridEdit31G.UpdateContainer",pidField.get());
    //<< quit
    return null;
  }

  //<< 
  //<< GoToForm(newForm="",pKey="",pblnPopUp=$$$NO,pPage="",pParam="")
  public Object GoToForm(Object ... _p) {
    mVar newForm = m$.newVarRef("newForm",(((_p!=null)&&(_p.length>=1))?_p[0]:null),"");
    mVar pKey = m$.newVarRef("pKey",(((_p!=null)&&(_p.length>=2))?_p[1]:null),"");
    mVar pblnPopUp = m$.newVarRef("pblnPopUp",(((_p!=null)&&(_p.length>=3))?_p[2]:null),include.COMSYS.$$$NO(m$));
    mVar pPage = m$.newVarRef("pPage",(((_p!=null)&&(_p.length>=4))?_p[3]:null),"");
    mVar pParam = m$.newVarRef("pParam",(((_p!=null)&&(_p.length>=5))?_p[4]:null),"");
    //<< ;-------------------------------------------------------------------------------
    //<< ; 14-Aug-2006   JW  SR14730: Added pblnPopUp
    //<< ;-------------------------------------------------------------------------------
    //<< do GoToForm^COMGridEdit31G(newForm,pKey,pblnPopUp,pPage,pParam)
    m$.Cmd.Do("COMGridEdit31G.GoToForm",newForm.get(),pKey.get(),pblnPopUp.get(),pPage.get(),pParam.get());
    //<< quit
    return null;
  }

  //<< 
  //<< ;======================== COMGRIDEDIT31R ========================
  //<< 
  //<< DELETE()
  public Object DELETE(Object ... _p) {
    //<< do DELETE^COMGridEdit31R()
    m$.Cmd.Do("COMGridEdit31R.DELETE");
    //<< quit
    return null;
  }

  //<< 
  //<< ;======================== COMGRIDEDIT31S ========================
  //<< 
  //<< ClassTranslate(pstrValue,pintClassCol,pstrClassName)
  public Object ClassTranslate(Object ... _p) {
    mVar pstrValue = m$.newVarRef("pstrValue",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pintClassCol = m$.newVarRef("pintClassCol",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pstrClassName = m$.newVarRef("pstrClassName",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    //<< quit $$ClassTranslate^COMGridEdit31F(pstrValue,pintClassCol,pstrClassName)
    return m$.fnc$("COMGridEdit31F.ClassTranslate",pstrValue.get(),pintClassCol.get(),pstrClassName.get());
  }

  //<< 
  //<< 
  //<< AddReference(pstrField,pstrType="D",pstrForm="")
  public Object AddReference(Object ... _p) {
    mVar pstrField = m$.newVarRef("pstrField",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pstrType = m$.newVarRef("pstrType",(((_p!=null)&&(_p.length>=2))?_p[1]:null),"D");
    mVar pstrForm = m$.newVarRef("pstrForm",(((_p!=null)&&(_p.length>=3))?_p[2]:null),"");
    //<< ;-------------------------------------------------------------------------------
    //<< ; Add a reference to a field that may have changed and requires recalculation for display on screen.
    //<< ;
    //<< ; History:
    //<< ; 20-Jun-2005   PaulK   Passed in pstrForm SR:12496
    //<< ;-------------------------------------------------------------------------------
    //<< do AddReference^COMGridEdit31Events(pstrField,pstrType,pstrForm)
    m$.Cmd.Do("COMGridEdit31Events.AddReference",pstrField.get(),pstrType.get(),pstrForm.get());
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< UpdateManualField(pROW="",pCOL="",pVALUE="")
  public Object UpdateManualField(Object ... _p) {
    mVar pROW = m$.newVarRef("pROW",(((_p!=null)&&(_p.length>=1))?_p[0]:null),"");
    mVar pCOL = m$.newVarRef("pCOL",(((_p!=null)&&(_p.length>=2))?_p[1]:null),"");
    mVar pVALUE = m$.newVarRef("pVALUE",(((_p!=null)&&(_p.length>=3))?_p[2]:null),"");
    //<< do UpdateManualField^COMGridEdit31G(pROW,pCOL,pVALUE)       ; see $$$GRIDUpdateManualField
    m$.Cmd.Do("COMGridEdit31G.UpdateManualField",pROW.get(),pCOL.get(),pVALUE.get());
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< ReferenceRow(pidForm,idDataLine)
  public Object ReferenceRow(Object ... _p) {
    mVar pidForm = m$.newVarRef("pidForm",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar idDataLine = m$.newVarRef("idDataLine",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Return the reference row for this row/form
    //<< ;
    //<< ; NOTE :
    //<< ;    GetLineId^COMGridEdit31G returns same but passes "HeaderKeyList,idDataLine"
    //<< ;    instead of idDataLine.
    //<< ;
    //<< ; Params:
    //<< ; pidForm       : The form for the grid
    //<< ; idDataLine    : The row in the grid
    //<< ;
    //<< ; Returns: idGridRow (e.g. 2x01 or 3)
    //<< ;
    //<< ; History:
    //<< ; 06-Aug-2009   GRF     Clarify parameters
    //<< ; 16-Aug-2005   RPW     SR11983: Created
    //<< ;-------------------------------------------------------------------------------
    //<< ; Handle error conditions.
    //<< quit:$get(idDataLine)="" ""
    if (mOp.Equal(m$.Fnc.$get(idDataLine),"")) {
      return "";
    }
    //<< 
    //<< if $get(pidForm)="" set pidForm = $get(^CacheTemp(YUSER,"Grid","Name"))
    if (mOp.Equal(m$.Fnc.$get(pidForm),"")) {
      pidForm.set(m$.Fnc.$get(m$.var("^CacheTemp",m$.var("YUSER").get(),"Grid","Name")));
    }
    //<< 
    //<< quit $get(^WWWDATEN(0,+$horolog,YUSER,pidForm,"V","REFERENCEROW",idDataLine,1))
    return m$.Fnc.$get(m$.var("^WWWDATEN",0,mOp.Positive(m$.Fnc.$horolog()),m$.var("YUSER").get(),pidForm.get(),"V","REFERENCEROW",idDataLine.get(),1));
  }

  //<< ;           (...,"REFERENCEROW",idDataLine,1) = idGridRow
  //<< 
  //<< /*
  //<< ;vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv DISABLED BLOCK START
  //<< new idGridRow,idLastKey,YFORM
  //<< 
  //<< set idGridRow = ""
  //<< if $get(pidForm)="" {   ; FIXME : WWWDATEN Macro uses ^CacheTemp(YUSER,"Grid","Name") not YFORM - pYFORM & this block not effective <GRF>
  //<< set YFORM = $get(^CacheTemp(YUSER,"Grid","Name"))
  //<< } else {
  //<< set YFORM = pidForm
  //<< }
  //<< set idLastKey = $$$KEYMAX(YKEY)    // SR11573
  //<< if idLastKey'="" {
  //<< set idGridRow = $get($$$WWWDATEN("REFERENCEROW",idLastKey,1))    ; Macro override : based on ^CacheTemp rather than YFORM
  //<< }
  //<< quit idGridRow
  //<< ;^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
  //<< */
  //<< 
  //<< ReferenceKey(pidForm,idGridRow)
  public Object ReferenceKey(Object ... _p) {
    mVar pidForm = m$.newVarRef("pidForm",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar idGridRow = m$.newVarRef("idGridRow",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Return the reference key for this row/form
    //<< ;
    //<< ; Compare to GetYKEY^COMGridEdit31G
    //<< ;
    //<< ; Params:
    //<< ;   pstrFormName  : The form for the grid
    //<< ;   idGridRow     : The row in the grid
    //<< ;
    //<< ; Returns:  Cache keys structure ("HeaderKeyList,idDataLine") e.g. "REC01234,2"
    //<< ;
    //<< ; History:
    //<< ; 06-Aug-2009   GRF     Clarify parameters
    //<< ; 10-Feb-2006   RPW     SR14135: Created
    //<< ;-------------------------------------------------------------------------------
    //<< quit:$get(idGridRow)="" ""
    if (mOp.Equal(m$.Fnc.$get(idGridRow),"")) {
      return "";
    }
    //<< 
    //<< if $get(pidForm)="" set pidForm = $get(^CacheTemp(YUSER,"Grid","Name"))
    if (mOp.Equal(m$.Fnc.$get(pidForm),"")) {
      pidForm.set(m$.Fnc.$get(m$.var("^CacheTemp",m$.var("YUSER").get(),"Grid","Name")));
    }
    //<< 
    //<< quit $translate($get(^WWWDATEN(0,+$horolog,YUSER,pidForm,"V","REFERENCEKEY",idGridRow,1)),$$$DBLQUOTE)
    return m$.Fnc.$translate(m$.Fnc.$get(m$.var("^WWWDATEN",0,mOp.Positive(m$.Fnc.$horolog()),m$.var("YUSER").get(),pidForm.get(),"V","REFERENCEKEY",idGridRow.get(),1)),include.COMSYSString.$$$DBLQUOTE(m$));
  }

  //<< 
  //<< 
  //<< SAVE(pYKEY="",pYFORM="") ; Use $$$GRIDSave directly
  public Object SAVE(Object ... _p) {
    mVar pYKEY = m$.newVarRef("pYKEY",(((_p!=null)&&(_p.length>=1))?_p[0]:null),"");
    mVar pYFORM = m$.newVarRef("pYFORM",(((_p!=null)&&(_p.length>=2))?_p[1]:null),"");
    //<< quit $$$GRIDSave(pYKEY,pYFORM)
    return include.COMGridEdit31Interface.$$$GRIDSave(m$,pYKEY,pYFORM);
  }

//<< 
//<< 
}
