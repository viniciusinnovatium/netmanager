//*****************************************************************************
//** TASC - ALPHALINC - MAC COMQuickSearch
//** Innovatium Systems - Code Converter - v1.28
//** 2014-05-26 21:13:04
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
//<< #include INConst
import include.INConst;
//<< #include WWWConst
import include.WWWConst;
//<< #include COMConst
import include.COMConst;

//<< COMQuickSearch
public class COMQuickSearch extends mClass {

  //<< 
  //<< #define IndexStrip  "*PC"
  public static Object $$$IndexStrip(mContext m$) {
    return ("*PC");
  }

  public void main() {
    _COMQuickSearch();
  }

  public void _COMQuickSearch() {
  }

  //<< 
  //<< CheckIfUsingQuickSearch(pidClass,&pblnUseQuickSearch,&pblnUseStartsWith)
  public Object CheckIfUsingQuickSearch(Object ... _p) {
    mVar pidClass = m$.newVarRef("pidClass",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pblnUseQuickSearch = m$.newVarRef("pblnUseQuickSearch",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pblnUseStartsWith = m$.newVarRef("pblnUseStartsWith",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Looks at the Quick Search Setup for this class and determines how the quick search
    //<< ; is to be used
    //<< ;
    //<< ; Params:
    //<< ; pidClass          : The class to check
    //<< ; pblnUseQuickSearch: Whether this class uses quick search
    //<< ; pblnUseStartsWith : Whether this class uses starts with search
    //<< ;
    //<< ; ByRefs:
    //<< ; pblnUseQuickSearch
    //<< ; pblnUseStartsWith
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 07-Jul-2006   RPW     SR12522: Created
    //<< ;-------------------------------------------------------------------------------
    //<< 
    //<< new objSetup
    mVar objSetup = m$.var("objSetup");
    m$.newVar(objSetup);
    //<< 
    //<< set objSetup=$get(^COMQuickSearchSetup(YM,pidClass,1))
    objSetup.set(m$.Fnc.$get(m$.var("^COMQuickSearchSetup",m$.var("YM").get(),pidClass.get(),1)));
    //<< 
    //<< set pblnUseStartsWith=+$$$COMQuickSearchSetupUseStartsWithSearch(objSetup)
    pblnUseStartsWith.set(mOp.Positive(include.COMConst.$$$COMQuickSearchSetupUseStartsWithSearch(m$,objSetup)));
    //<< set pblnUseQuickSearch=+$$$COMQuickSearchSetupUseQuickSearch(objSetup)
    pblnUseQuickSearch.set(mOp.Positive(include.COMConst.$$$COMQuickSearchSetupUseQuickSearch(m$,objSetup)));
    //<< 
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< PopulateIndex(pidClass,pidObject)
  public Object PopulateIndex(Object ... _p) {
    mVar pidClass = m$.newVarRef("pidClass",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pidObject = m$.newVarRef("pidObject",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Populate a single index for a given class
    //<< ;
    //<< ; Params:
    //<< ; pidClass : The class to be indexed
    //<< ; pidObject: The 1st primary key of the class
    //<< ;
    //<< ; ByRefs:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 19-Oct-2006   JW      SR15134: Return status
    //<< ; 07-Jul-2006   RPW     SR12522: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new blnUseQuickSearchStartsWith,blnUseQuickSearch,idxObject,idIndex,strStatus
    mVar blnUseQuickSearchStartsWith = m$.var("blnUseQuickSearchStartsWith");
    mVar blnUseQuickSearch = m$.var("blnUseQuickSearch");
    mVar idxObject = m$.var("idxObject");
    mVar idIndex = m$.var("idIndex");
    mVar strStatus = m$.var("strStatus");
    m$.newVar(blnUseQuickSearchStartsWith,blnUseQuickSearch,idxObject,idIndex,strStatus);
    //<< 
    //<< set strStatus = $$$OK
    strStatus.set(include.COMSYS.$$$OK(m$));
    //<< 
    //<< do CheckIfUsingQuickSearch(pidClass,.blnUseQuickSearch,.blnUseQuickSearchStartsWith)
    m$.Cmd.Do("CheckIfUsingQuickSearch",pidClass.get(),blnUseQuickSearch,blnUseQuickSearchStartsWith);
    //<< 
    //<< if blnUseQuickSearchStartsWith || blnUseQuickSearch {
    if (mOp.Logical(blnUseQuickSearchStartsWith.get()) || mOp.Logical(blnUseQuickSearch.get())) {
      //<< if '$data(^COMQuickSearchs(YM,1,$$$Index(pidObject),pidClass)) {
      if (mOp.Not(m$.Fnc.$data(m$.var("^COMQuickSearchs",m$.var("YM").get(),1,include.MEDConst.$$$Index(m$,pidObject),pidClass.get())))) {
        //<< set idxObject=$zstrip(pidObject,$$$IndexStrip)
        idxObject.set(m$.Fnc.$zstrip(pidObject.get(),$$$IndexStrip(m$)));
        //<< 
        //<< if '$data(^COMQuickSearch(YM,pidClass,idxObject)) {
        if (mOp.Not(m$.Fnc.$data(m$.var("^COMQuickSearch",m$.var("YM").get(),pidClass.get(),idxObject.get())))) {
          //<< set idIndex=1
          idIndex.set(1);
        }
        //<< 
        //<< } else {
        else {
          //<< set idIndex=$order(^COMQuickSearch(YM,pidClass,idxObject,""),-1)+1
          idIndex.set(mOp.Add(m$.Fnc.$order(m$.var("^COMQuickSearch",m$.var("YM").get(),pidClass.get(),idxObject.get(),""),mOp.Negative(1)),1));
        }
        //<< }
        //<< set strStatus=$$$Save("COMQuickSearch",pidClass_$$$COMMA_idxObject_$$$COMMA_idIndex,pidObject,$$$YES)
        strStatus.set(include.COMSYS.$$$Save(m$,"COMQuickSearch",mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(pidClass.get(),include.COMSYSString.$$$COMMA(m$)),idxObject.get()),include.COMSYSString.$$$COMMA(m$)),idIndex.get()),pidObject,include.COMSYS.$$$YES(m$)));
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
  //<< DeleteIndex(pidClass,pidObject)
  public Object DeleteIndex(Object ... _p) {
    mVar pidClass = m$.newVarRef("pidClass",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pidObject = m$.newVarRef("pidObject",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Remove a single index from the Quick Search Index
    //<< ;
    //<< ; Params:
    //<< ; pidClass : The class to be removed from the index
    //<< ; pidObject: The 1st primary key of the class
    //<< ;
    //<< ; ByRefs:
    //<< ;
    //<< ; Returns:  status
    //<< ;
    //<< ; History:
    //<< ; 18-Oct-2006   JW      SR15134: Look at kill status. Return status
    //<< ; 05-Jul-2006   RPW     SR12522: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new idIndex,idxRealObject,idxObject,strStatus
    mVar idIndex = m$.var("idIndex");
    mVar idxRealObject = m$.var("idxRealObject");
    mVar idxObject = m$.var("idxObject");
    mVar strStatus = m$.var("strStatus");
    m$.newVar(idIndex,idxRealObject,idxObject,strStatus);
    //<< 
    //<< set strStatus = $$$OK
    strStatus.set(include.COMSYS.$$$OK(m$));
    //<< 
    //<< set idxRealObject=$$$Index(pidObject)
    idxRealObject.set(include.MEDConst.$$$Index(m$,pidObject));
    //<< if $data(^COMQuickSearchs(YM,1,idxRealObject,pidClass)) {
    if (mOp.Logical(m$.Fnc.$data(m$.var("^COMQuickSearchs",m$.var("YM").get(),1,idxRealObject.get(),pidClass.get())))) {
      //<< set idxObject=$order(^COMQuickSearchs(YM,1,idxRealObject,pidClass,""))
      idxObject.set(m$.Fnc.$order(m$.var("^COMQuickSearchs",m$.var("YM").get(),1,idxRealObject.get(),pidClass.get(),"")));
      //<< if idxObject'="" {
      if (mOp.NotEqual(idxObject.get(),"")) {
        //<< set idIndex=$order(^COMQuickSearchs(YM,1,idxRealObject,pidClass,idxObject,""))
        idIndex.set(m$.Fnc.$order(m$.var("^COMQuickSearchs",m$.var("YM").get(),1,idxRealObject.get(),pidClass.get(),idxObject.get(),"")));
        //<< if idIndex'="" {
        if (mOp.NotEqual(idIndex.get(),"")) {
          //<< set strStatus = $$$Kill("COMQuickSearch",pidClass_$$$COMMA_idxObject_$$$COMMA_idIndex)      //SR15134
          strStatus.set(include.COMSYS.$$$Kill(m$,"COMQuickSearch",mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(pidClass.get(),include.COMSYSString.$$$COMMA(m$)),idxObject.get()),include.COMSYSString.$$$COMMA(m$)),idIndex.get())));
        }
      }
    }
    //<< }
    //<< }
    //<< }
    //<< 
    //<< quit strStatus
    return strStatus.get();
  }

  //<< 
  //<< 
  //<< PerformQuickSearch(pidClass,pidObject)
  public Object PerformQuickSearch(Object ... _p) {
    mVar pidClass = m$.newVarRef("pidClass",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pidObject = m$.newVarRef("pidObject",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; This method actually performs the Quick Search
    //<< ;
    //<< ; Step 1:
    //<< ; Check for an exact match in the class for this primary key. Return this if found
    //<< ;
    //<< ; Step 2:
    //<< ; If Quick Search, Check for an exact match in the COMQuickSearch class. Return this if found
    //<< ;
    //<< ; Step 3:
    //<< ; If Starts With, Check for a Starts With match in the class for this primary key. Return this if found
    //<< ;
    //<< ; Step 4:
    //<< ; If Starts With and Quick Search, Check for a Starts With match in the COMQuickSearch class. Return this if found
    //<< ;
    //<< ; Step 5:
    //<< ; If nothing is found, strip the the input to alphanumerics and try again
    //<< ;
    //<< ; Step 6:
    //<< ; If still nothing is found, return the original value
    //<< ;
    //<< ; Params:
    //<< ; pidClass : The class to be search for
    //<< ; pidObject: The 1st primary key of the class
    //<< ;
    //<< ; ByRefs:
    //<< ;
    //<< ; Returns:
    //<< ; idAccount: The GL Account from either the FINGLAccount or the FINGLAccountIndex
    //<< ;
    //<< ; History:
    //<< ; 06-May-2009   PPP     SR16521:Barcode Scanning to identify Item
    //<< ;                       1. if Relation class = Quick Search Class ($$GetId) check for matches
    //<< ; 15-Nov-2006   PO      SR15134: New idxKey
    //<< ; 05-Jul-2006   RPW     SR12522: Created
    //<< ;-------------------------------------------------------------------------------
    //<< 
    //<< new idAccount,idIndex,SQLCODE,idObject,strFullClass,blnUseQuickSearchStartsWith,blnUseQuickSearch
    mVar idAccount = m$.var("idAccount");
    mVar idIndex = m$.var("idIndex");
    mVar SQLCODE = m$.var("SQLCODE");
    mVar idObject = m$.var("idObject");
    mVar strFullClass = m$.var("strFullClass");
    mVar blnUseQuickSearchStartsWith = m$.var("blnUseQuickSearchStartsWith");
    mVar blnUseQuickSearch = m$.var("blnUseQuickSearch");
    m$.newVar(idAccount,idIndex,SQLCODE,idObject,strFullClass,blnUseQuickSearchStartsWith,blnUseQuickSearch);
    //<< new idKey,objResultSet,strQuery,idStripped,idxKey
    mVar idKey = m$.var("idKey");
    mVar objResultSet = m$.var("objResultSet");
    mVar strQuery = m$.var("strQuery");
    mVar idStripped = m$.var("idStripped");
    mVar idxKey = m$.var("idxKey");
    m$.newVar(idKey,objResultSet,strQuery,idStripped,idxKey);
    //<< 
    //<< quit:pidObject="" pidObject                                                     //EARLY EXIT
    if (mOp.Equal(pidObject.get(),"")) {
      return pidObject.get();
    }
    //<< 
    //<< set idObject = pidObject
    idObject.set(pidObject.get());
    //<< 
    //<< //SR16521
    //<< if $$GetId(pidClass,,.pidObject) quit:(pidObject'=idObject) pidObject           //EARLY EXIT
    if (mOp.Logical(m$.fnc$("GetId",pidClass.get(),null,pidObject))) {
      if ((mOp.NotEqual(pidObject.get(),idObject.get()))) {
        return pidObject.get();
      }
    }
    //<< 
    //<< set SQLCODE=0
    SQLCODE.set(0);
    //<< set idIndex=""
    idIndex.set("");
    //<< 
    //<< do CheckIfUsingQuickSearch(pidClass,.blnUseQuickSearch,.blnUseQuickSearchStartsWith)
    m$.Cmd.Do("CheckIfUsingQuickSearch",pidClass.get(),blnUseQuickSearch,blnUseQuickSearchStartsWith);
    //<< 
    //<< if blnUseQuickSearch || blnUseQuickSearchStartsWith {
    if (mOp.Logical(blnUseQuickSearch.get()) || mOp.Logical(blnUseQuickSearchStartsWith.get())) {
      //<< set strFullClass="^"_pidClass
      strFullClass.set(mOp.Concat("^",pidClass.get()));
      //<< if '$data(@strFullClass@(YM,pidObject)) {
      if (mOp.Not(m$.Fnc.$data(m$.indirectVar(strFullClass.get()).var(m$.var("YM").get(),pidObject.get())))) {
        //<< if blnUseQuickSearch {
        if (mOp.Logical(blnUseQuickSearch.get())) {
          //<< set idIndex=$order(^COMQuickSearch(YM,pidClass,pidObject,""))
          idIndex.set(m$.Fnc.$order(m$.var("^COMQuickSearch",m$.var("YM").get(),pidClass.get(),pidObject.get(),"")));
          //<< if idIndex'="" {
          if (mOp.NotEqual(idIndex.get(),"")) {
            //<< set idObject=$get(^COMQuickSearch(YM,pidClass,pidObject,idIndex,1))
            idObject.set(m$.Fnc.$get(m$.var("^COMQuickSearch",m$.var("YM").get(),pidClass.get(),pidObject.get(),idIndex.get(),1)));
          }
        }
        //<< }
        //<< }
        //<< 
        //<< if (idIndex="")||(idObject="") {
        if ((mOp.Equal(idIndex.get(),"")) || (mOp.Equal(idObject.get(),""))) {
          //<< set idObject=""
          idObject.set("");
          //<< if blnUseQuickSearchStartsWith {
          if (mOp.Logical(blnUseQuickSearchStartsWith.get())) {
            //<< // This query finds the first matching entry via startswith if one exists.
            //<< // Code Check issues at the moment. Will address later.
            //<< 
            //<< set idKey=$$$WWW002PropertyName($get(^WWW002(0,pidClass,1,1)))
            idKey.set(include.WWWConst.$$$WWW002PropertyName(m$,m$.Fnc.$get(m$.var("^WWW002",0,pidClass.get(),1,1))));
            //<< 
            //<< set objResultSet=##class(%Library.ResultSet).%New()
            objResultSet.set(m$.fnc$("$Library.ResultSet.$New"));
            //<< set idxKey=$$$Index(idKey)
            idxKey.set(include.MEDConst.$$$Index(m$,idKey));
            //<< //set idxObject=$$$Index(pidObject)
            //<< set strQuery="select top 1 "_idKey_" As PrimaryKey from "_$$getTableName^REPViewCreateSQL(pidClass)_" where %upper("_idKey_") %startswith %upper('"_pidObject_"')"
            strQuery.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("select top 1 ",idKey.get())," As PrimaryKey from "),m$.fnc$("REPViewCreateSQL.getTableName",pidClass.get()))," where %upper("),idKey.get()),") %startswith %upper('"),pidObject.get()),"')"));
            //<< if $$$ISOK(objResultSet.Prepare(strQuery)) {
            if (mOp.Logical(include.COMSYS.$$$ISOK(m$,m$.fnc$(objResultSet.getORef(),"Prepare",strQuery.get())))) {
              //<< if $$$ISOK(objResultSet.Execute()) {
              if (mOp.Logical(include.COMSYS.$$$ISOK(m$,m$.fnc$(objResultSet.getORef(),"Execute")))) {
                //<< if objResultSet.Next() {
                if (mOp.Logical(m$.fnc$(objResultSet.getORef(),"Next"))) {
                  //<< set idObject=$get(objResultSet.Data("PrimaryKey"))
                  idObject.set(m$.Fnc.$get(m$.fnc$(objResultSet.getORef(),"Data","PrimaryKey")));
                }
              }
            }
            //<< }
            //<< }
            //<< }
            //<< 
            //<< if idObject="" {
            if (mOp.Equal(idObject.get(),"")) {
              //<< //set idxClass=$$$Index(pidClass)
              //<< &sql(select top 1 ItemData into :idObject from SQLUser.COMQuickSearch where %upper(ItemIndex) %startswith %upper(:pidObject) and %upper(ClassName) = %upper(:pidClass))
              m$.Cmd.SQL();
            }
            //<< }
            //<< 
            //<< if SQLCODE'=0 {
            if (mOp.NotEqual(SQLCODE.get(),0)) {
              //<< set idObject=""
              idObject.set("");
            }
          }
        }
      }
      //<< }
      //<< }
      //<< }
      //<< }
      //<< 
      //<< if idObject="" {
      if (mOp.Equal(idObject.get(),"")) {
        //<< set idStripped=$zstrip(pidObject,$$$IndexStrip)
        idStripped.set(m$.Fnc.$zstrip(pidObject.get(),$$$IndexStrip(m$)));
        //<< if idStripped'=pidObject {
        if (mOp.NotEqual(idStripped.get(),pidObject.get())) {
          //<< set idObject=$$PerformQuickSearch(pidClass,idStripped)
          idObject.set(m$.fnc$("PerformQuickSearch",pidClass.get(),idStripped.get()));
        }
        //<< } else {
        else {
          //<< set idObject=pidObject
          idObject.set(pidObject.get());
        }
      }
    }
    //<< }
    //<< }
    //<< }
    //<< quit idObject
    return idObject.get();
  }

  //<< 
  //<< 
  //<< UpdateIndexForClass(pidClass,pblnPopulate=$$$YES,pblnReloadForm=$$$NO)
  public Object UpdateIndexForClass(Object ... _p) {
    mVar pidClass = m$.newVarRef("pidClass",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pblnPopulate = m$.newVarRef("pblnPopulate",(((_p!=null)&&(_p.length>=2))?_p[1]:null),include.COMSYS.$$$YES(m$));
    mVar pblnReloadForm = m$.newVarRef("pblnReloadForm",(((_p!=null)&&(_p.length>=3))?_p[2]:null),include.COMSYS.$$$NO(m$));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Create/Delete the data for the Quick Search index.
    //<< ;
    //<< ; If we are populating, remove the original entry, even if it does not exist, then
    //<< ; add the new entry.
    //<< ; If we are removing, just remove the entry.
    //<< ;
    //<< ; Params:
    //<< ; pidClass      : The class to be populated
    //<< ; pblnPopulate  : Is this populate or delete
    //<< ; pblnReloadForm: Should the form be reloaded, this allows the form to be run from
    //<< ;                 the command line
    //<< ;
    //<< ; ByRefs:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 18-Oct-2006   JW      SR15134: Look at kill status. Return status
    //<< ; 07-Jul-2006   RPW     SR12522: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new strFullClass,idKey,strStatus
    mVar strFullClass = m$.var("strFullClass");
    mVar idKey = m$.var("idKey");
    mVar strStatus = m$.var("strStatus");
    m$.newVar(strFullClass,idKey,strStatus);
    //<< 
    //<< quit:$$^WWWRELOAD()=1
    if (mOp.Equal(m$.fnc$("WWWRELOAD.main"),1)) {
      return null;
    }
    //<< 
    //<< set strFullClass="^"_pidClass
    strFullClass.set(mOp.Concat("^",pidClass.get()));
    //<< 
    //<< set idKey=""
    idKey.set("");
    //<< 
    //<< for {
    for (;true;) {
      //<< set idKey=$order(@strFullClass@(YM,idKey))
      idKey.set(m$.Fnc.$order(m$.indirectVar(strFullClass.get()).var(m$.var("YM").get(),idKey.get())));
      //<< quit:idKey=""
      if (mOp.Equal(idKey.get(),"")) {
        break;
      }
      //<< 
      //<< set strStatus = $$DeleteIndex(pidClass,idKey)       //SR15134
      strStatus.set(m$.fnc$("DeleteIndex",pidClass.get(),idKey.get()));
      //<< if pblnPopulate && $$$ISOK(strStatus) {
      if (mOp.Logical(pblnPopulate.get()) && mOp.Logical(include.COMSYS.$$$ISOK(m$,strStatus))) {
        //<< set strStatus = $$PopulateIndex(pidClass,idKey)     //SR15134
        strStatus.set(m$.fnc$("PopulateIndex",pidClass.get(),idKey.get()));
      }
      //<< }
      //<< quit:$$$ISERR(strStatus)
      if (mOp.Logical(include.COMSYS.$$$ISERR(m$,strStatus))) {
        break;
      }
    }
    //<< }
    //<< 
    //<< if pblnReloadForm {
    if (mOp.Logical(pblnReloadForm.get())) {
      //<< if $$$ISOK(strStatus) {
      if (mOp.Logical(include.COMSYS.$$$ISOK(m$,strStatus))) {
        //<< do ReloadForm^COMUtilForm()
        m$.Cmd.Do("COMUtilForm.ReloadForm");
      }
      //<< } else {
      else {
        //<< do ReturnError^COMUtilError(strStatus)      //SR15134
        m$.Cmd.Do("COMUtilError.ReturnError",strStatus.get());
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
  //<< OnAfterDelete(pidKey)
  public Object OnAfterDelete(Object ... _p) {
    mVar pidKey = m$.newVarRef("pidKey",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; When a quick search is deleted, remove the data for the class.
    //<< ;
    //<< ; Params:
    //<< ; pidKey: The key to the Quick Search entry.
    //<< ;
    //<< ; ByRefs:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 19-Oct-2006   JW      SR15134: Look at kill status
    //<< ; 07-Jul-2006   RPW     SR12522: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new strStatus
    mVar strStatus = m$.var("strStatus");
    m$.newVar(strStatus);
    //<< 
    //<< set strStatus = $$UpdateIndexForClass(pidKey,$$$NO)
    strStatus.set(m$.fnc$("UpdateIndexForClass",pidKey.get(),include.COMSYS.$$$NO(m$)));
    //<< if $$$ISERR(strStatus) {
    if (mOp.Logical(include.COMSYS.$$$ISERR(m$,strStatus))) {
      //<< set Q = $$$QDontDelete      //SR15134
      mVar Q = m$.var("Q");
      Q.set(include.COMSYSWWW.$$$QDontDelete(m$));
    }
    //<< }
    //<< 
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< 
  //<< /**********************************************************************************/
  //<< /*********************** INTERFACE METHODS FOR QUICK SEARCH ***********************/
  //<< /**********************************************************************************/
  //<< 
  //<< IsSearchClass(pidClass="",pidRelClass="")
  public Object IsSearchClass(Object ... _p) {
    mVar pidClass = m$.newVarRef("pidClass",(((_p!=null)&&(_p.length>=1))?_p[0]:null),"");
    mVar pidRelClass = m$.newVarRef("pidRelClass",(((_p!=null)&&(_p.length>=2))?_p[1]:null),"");
    //<< ;-------------------------------------------------------------------------------
    //<< ; When a quick search is called, check if the input class needs to be
    //<< ; has the Search Facilty Enabled
    //<< ;
    //<< ; Params:
    //<< ; pidClass: The Class to the Quick Search
    //<< ;
    //<< ; ByRefs:
    //<< ;
    //<< ; Returns: Boolean
    //<< ;
    //<< ; History:
    //<< ; 06-May-2009   PPP     SR16521:Barcode Scanning to identify Item
    //<< ;-------------------------------------------------------------------------------
    //<< new blnOK
    mVar blnOK = m$.var("blnOK");
    m$.newVar(blnOK);
    //<< 
    //<< set blnOK = $$$NO
    blnOK.set(include.COMSYS.$$$NO(m$));
    //<< 
    //<< if ($get(pidClass) = "INART")          ||
    //<< ($get(pidRelClass) = "INART")       ||
    //<< ($get(pidClass) = "alINV.dItem")    ||
    //<< ($get(pidRelClass) = "alINV.dItem")    {
    if ((mOp.Equal(m$.Fnc.$get(pidClass),"INART")) || (mOp.Equal(m$.Fnc.$get(pidRelClass),"INART")) || (mOp.Equal(m$.Fnc.$get(pidClass),"alINV.dItem")) || (mOp.Equal(m$.Fnc.$get(pidRelClass),"alINV.dItem"))) {
      //<< 
      //<< set blnOK = $$$YES
      blnOK.set(include.COMSYS.$$$YES(m$));
    }
    //<< }
    //<< 
    //<< quit blnOK
    return blnOK.get();
  }

  //<< 
  //<< 
  //<< GetId(pidClass="",pidRelClass="",&pstrCode,pidFieldType="")
  public Object GetId(Object ... _p) {
    mVar pidClass = m$.newVarRef("pidClass",(((_p!=null)&&(_p.length>=1))?_p[0]:null),"");
    mVar pidRelClass = m$.newVarRef("pidRelClass",(((_p!=null)&&(_p.length>=2))?_p[1]:null),"");
    mVar pstrCode = m$.newVarRef("pstrCode",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    mVar pidFieldType = m$.newVarRef("pidFieldType",(((_p!=null)&&(_p.length>=4))?_p[3]:null),"");
    //<< ;-------------------------------------------------------------------------------
    //<< ; When a quick search is called, get the Original ID of the code entered
    //<< ;
    //<< ;
    //<< ; Params:
    //<< ; pidClass      The Class to the Quick Search
    //<< ; pidRelClass   Relation Class
    //<< ; pstrCode          String to be checked
    //<< ;
    //<< ; ByRef:
    //<< ; pstrCode
    //<< ;
    //<< ; Returns: Boolean
    //<< ;
    //<< ; History:
    //<< ; 14-May-2009   PPP     SR16521:If main class is INART and not Primary key
    //<< ;                       no Conversion
    //<< ; 06-May-2009   PPP     SR16521:Barcode Scanning to identify Item
    //<< ;-------------------------------------------------------------------------------
    //<< new blnOK
    mVar blnOK = m$.var("blnOK");
    m$.newVar(blnOK);
    //<< 
    //<< set blnOK = $$$NO
    blnOK.set(include.COMSYS.$$$NO(m$));
    //<< 
    //<< // Item Master  - Checks for Barcodes/UPC
    //<< if ($get(pidClass) = "INART")          ||
    //<< ($get(pidRelClass) = "INART")       ||
    //<< ($get(pidClass) = "alINV.dItem")    ||
    //<< ($get(pidRelClass) = "alINV.dItem")    {
    if ((mOp.Equal(m$.Fnc.$get(pidClass),"INART")) || (mOp.Equal(m$.Fnc.$get(pidRelClass),"INART")) || (mOp.Equal(m$.Fnc.$get(pidClass),"alINV.dItem")) || (mOp.Equal(m$.Fnc.$get(pidRelClass),"alINV.dItem"))) {
      //<< 
      //<< //Main Class is INART and the field is a Primary Key no conversion
      //<< if '((pidClass = "INART") && (pidFieldType = "D")) {
      if (mOp.Not(((mOp.Equal(pidClass.get(),"INART")) && (mOp.Equal(pidFieldType.get(),"D"))))) {
        //<< set blnOK = $$$YES
        blnOK.set(include.COMSYS.$$$YES(m$));
        //<< // At the moment hardcoded, but will update with a Table Definition for Barcodes
        //<< set pstrCode=$$GetCode^INARTCode(pstrCode)
        pstrCode.set(m$.fnc$("INARTCode.GetCode",pstrCode.get()));
      }
    }
    //<< }
    //<< }
    //<< 
    //<< quit blnOK
    return blnOK.get();
  }

//<< 
//<< 
//<< 
//<< 
}
