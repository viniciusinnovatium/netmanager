//*****************************************************************************
//** TASC - ALPHALINC - MAC COMView
//** Innovatium Systems - Code Converter - v1.30
//** 2014-06-13 20:14:22
//*****************************************************************************

import mLibrary.*;

//<< ;-------------------------------------------------------------------------------
//<< ; routines showing favourites(views) tabs and other related routines.
//<< ;
//<< ; History:
//<< ; 15-May-2009   GRF     SR16474: replace Order macros; clear out some old
//<< ;                           commented lines
//<< ; 09-Jun-2008   shobby  SRBR014953 Class/Form changed (Do Not remove comment)
//<< ; 15-Mar-2005   GRF     Boolean Macros
//<< ;-------------------------------------------------------------------------------
//<< 
//<< #include COMView
import include.COMSYS;
//<< #include COMConst
import include.COMConst;
//<< #include WWWConst
import include.WWWConst;

//<< COMView
public class COMView extends mClass {

  public void main() {
    _COMView();
  }

  public void _COMView() {
  }

  //<< 
  //<< OnBeforeDelete(YKEY)
  public Object OnBeforeDelete(Object ... _p) {
    mVar YKEY = m$.newVarRef("YKEY",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Get the id of the view last used by this user for this class.
    //<< ;
    //<< ; Returns:ID (Favourite)
    //<< ;
    //<< ; History:
    //<< ; 07-Apr-2009   shobby  SR16474: created
    //<< ;-------------------------------------------------------------------------------
    //<< new idClass,idFavourite,idFilter,idKey,idLang,strStatus
    mVar idClass = m$.var("idClass");
    mVar idFavourite = m$.var("idFavourite");
    mVar idFilter = m$.var("idFilter");
    mVar idKey = m$.var("idKey");
    mVar idLang = m$.var("idLang");
    mVar strStatus = m$.var("strStatus");
    m$.newVar(idClass,idFavourite,idFilter,idKey,idLang,strStatus);
    //<< 
    //<< set strStatus = $$$OK
    strStatus.set(include.COMSYS.$$$OK(m$));
    //<< 
    //<< set idClass     = $$$KEY1(YKEY)
    idClass.set(include.COMSYSWWW.$$$KEY1(m$,YKEY));
    //<< set idFavourite = $$$KEY2(YKEY)
    idFavourite.set(include.COMSYSWWW.$$$KEY2(m$,YKEY));
    //<< 
    //<< set idLang = ""
    idLang.set("");
    //<< for {
    for (;true;) {
      //<< set idLang = $order(^COMViewLang(0,idClass,idLang))
      idLang.set(m$.Fnc.$order(m$.var("^COMViewLang",0,idClass.get(),idLang.get())));
      //<< quit:idLang=""
      if (mOp.Equal(idLang.get(),"")) {
        break;
      }
      //<< quit:'$$$ISOK(strStatus)
      if (mOp.Not(include.COMSYS.$$$ISOK(m$,strStatus))) {
        break;
      }
      //<< 
      //<< set idKey = idClass_","_idLang_","_idFavourite
      idKey.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(idClass.get(),","),idLang.get()),","),idFavourite.get()));
      //<< set strStatus = $$$Kill("COMViewLang",idKey)
      strStatus.set(include.COMSYS.$$$Kill(m$,"COMViewLang",idKey));
    }
    //<< }
    //<< 
    //<< if $$$ISOK(strStatus) {
    if (mOp.Logical(include.COMSYS.$$$ISOK(m$,strStatus))) {
      //<< set idFilter = ""
      idFilter.set("");
      //<< for {
      for (;true;) {
        //<< set idFilter = $order(^COMViewFilter(0,idClass,idFavourite,idFilter))
        idFilter.set(m$.Fnc.$order(m$.var("^COMViewFilter",0,idClass.get(),idFavourite.get(),idFilter.get())));
        //<< quit:idFilter=""
        if (mOp.Equal(idFilter.get(),"")) {
          break;
        }
        //<< quit:'$$$ISOK(strStatus)
        if (mOp.Not(include.COMSYS.$$$ISOK(m$,strStatus))) {
          break;
        }
        //<< 
        //<< set idKey = idClass_","_idFavourite_","_idFilter
        idKey.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(idClass.get(),","),idFavourite.get()),","),idFilter.get()));
        //<< set strStatus = $$$Kill("COMViewFilter",idKey)
        strStatus.set(include.COMSYS.$$$Kill(m$,"COMViewFilter",idKey));
      }
    }
    //<< }
    //<< }
    //<< if $$$ISOK(strStatus) {
    if (mOp.Logical(include.COMSYS.$$$ISOK(m$,strStatus))) {
      //<< kill ^COMViewColumn(0,idClass,idFavourite)
      m$.var("^COMViewColumn",0,idClass.get(),idFavourite.get()).kill();
      //<< kill ^COMViewColumnUser(0,idClass,idFavourite)
      m$.var("^COMViewColumnUser",0,idClass.get(),idFavourite.get()).kill();
    }
    //<< }
    //<< quit strStatus
    return strStatus.get();
  }

  //<< 
  //<< 
  //<< GetCurrentView(pidClass)
  public Object GetCurrentView(Object ... _p) {
    mVar pidClass = m$.newVarRef("pidClass",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Get the id of the view last used by this user for this class.
    //<< ;
    //<< ; Returns:ID (Favourite)
    //<< ;
    //<< ; History:
    //<< ; 15-Feb-2007   Steve S SR15431: Save properly
    //<< ; 21-Jul-2005   RPW     This routine can get passed a missing pidClass.
    //<< ; 12-Apr-2005   Paul K  Commented
    //<< ;-------------------------------------------------------------------------------
    //<< new idView,objView,strStatus
    mVar idView = m$.var("idView");
    mVar objView = m$.var("objView");
    mVar strStatus = m$.var("strStatus");
    m$.newVar(idView,objView,strStatus);
    //<< 
    //<< quit:($get(pidClass)="") "" ; This is a quick fix!
    if ((mOp.Equal(m$.Fnc.$get(pidClass),""))) {
      return "";
    }
    //<< 
    //<< set idView = $$$COMViewUserLastView($get(^COMViewUser(0,pidClass,YBED,1)))
    idView.set(include.COMConst.$$$COMViewUserLastView(m$,m$.Fnc.$get(m$.var("^COMViewUser",0,pidClass.get(),m$.var("YBED").get(),1))));
    //<< if (idView="") || '$data(^COMView(0,pidClass,idView,1)) {
    if ((mOp.Equal(idView.get(),"")) || mOp.Not(m$.Fnc.$data(m$.var("^COMView",0,pidClass.get(),idView.get(),1)))) {
      //<< set idView = 0
      idView.set(0);
      //<< if '$data(^COMView(0,pidClass,idView,1)) {
      if (mOp.Not(m$.Fnc.$data(m$.var("^COMView",0,pidClass.get(),idView.get(),1)))) {
        //<< set objView=""
        objView.set("");
        //<< set $$$COMViewDescription(objView)=$$$Text("Com00119")   ; "Default"
        include.COMConst.$$$COMViewDescriptionSet(m$,objView,include.COMSYS.$$$Text(m$,"Com00119"));
        //<< set strStatus = $$$Save("COMView",pidClass_","_idView,objView,$$$YES)
        strStatus.set(include.COMSYS.$$$Save(m$,"COMView",mOp.Concat(mOp.Concat(pidClass.get(),","),idView.get()),objView,include.COMSYS.$$$YES(m$)));
      }
    }
    //<< }
    //<< }
    //<< quit idView
    return idView.get();
  }

  //<< 
  //<< 
  //<< Setup(pidClass)
  public Object Setup(Object ... _p) {
    mVar pidClass = m$.newVarRef("pidClass",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Sets up screen for favourites
    //<< ;
    //<< ; History:
    //<< ; 23-Apr-2007   RPW     SR15440: Reset the COMViewUser entry to point to the
    //<< ;                           current view as the last view.
    //<< ; 20-Feb-2007   Steve S SR15440: Get available view
    //<< ; 20-Feb-2006   PO      SR14250: Source security settings from form related to
    //<< ;                           data and not COMViewSearch
    //<< ; 31-Jan-2006   PO      SR14250: Hide field chooser if user not permitted to use it.
    //<< ; 31-Jan-2006   PO      SR14249: Hide disabled buttons
    //<< ; 12-Apr-2005   Paul K  Commented
    //<< ;-------------------------------------------------------------------------------
    //<< new idClass,idForm,idView,objViewUser,strStatus
    mVar idClass = m$.var("idClass");
    mVar idForm = m$.var("idForm");
    mVar idView = m$.var("idView");
    mVar objViewUser = m$.var("objViewUser");
    mVar strStatus = m$.var("strStatus");
    m$.newVar(idClass,idForm,idView,objViewUser,strStatus);
    //<< 
    //<< set idForm = $get(^CacheTempView(YUSER,"Form"))
    idForm.set(m$.Fnc.$get(m$.var("^CacheTempView",m$.var("YUSER").get(),"Form")));
    //<< set idView = $$GetAvailableView^COMViewFavourite(pidClass)
    idView.set(m$.fnc$("COMViewFavourite.GetAvailableView",pidClass.get()));
    //<< 
    //<< set idClass     = $get(^CacheTempView(YUSER,"Class"))
    idClass.set(m$.Fnc.$get(m$.var("^CacheTempView",m$.var("YUSER").get(),"Class")));
    //<< set objViewUser = $get(^COMViewUser(0,idClass,YBED,1))
    objViewUser.set(m$.Fnc.$get(m$.var("^COMViewUser",0,idClass.get(),m$.var("YBED").get(),1)));
    //<< set $$$COMViewUserLastView(objViewUser) = idView
    include.COMConst.$$$COMViewUserLastViewSet(m$,objViewUser,idView.get());
    //<< set strStatus   = $$$Save("COMViewUser",idClass_$$$COMMA_YBED,objViewUser,$$$YES)
    strStatus.set(include.COMSYS.$$$Save(m$,"COMViewUser",mOp.Concat(mOp.Concat(idClass.get(),include.COMSYSString.$$$COMMA(m$)),m$.var("YBED").get()),objViewUser,include.COMSYS.$$$YES(m$)));
    //<< 
    //<< do DisplayView(pidClass,idView)
    m$.Cmd.Do("DisplayView",pidClass.get(),idView.get());
    //<< do SetFiltersForView(pidClass,idView)
    m$.Cmd.Do("SetFiltersForView",pidClass.get(),idView.get());
    //<< do SetColumnsForView^COMViewColumn(pidClass,idView)
    m$.Cmd.Do("COMViewColumn.SetColumnsForView",pidClass.get(),idView.get());
    //<< do HideDisabledButtons(pidClass,idView)
    m$.Cmd.Do("HideDisabledButtons",pidClass.get(),idView.get());
    //<< 
    //<< if '$$HasViewAccess(YBED,idForm,YM) write "document.getElementById('fldChooseBar').style.display = 'none';"
    if (mOp.Not(m$.fnc$("HasViewAccess",m$.var("YBED").get(),idForm.get(),m$.var("YM").get()))) {
      m$.Cmd.Write("document.getElementById('fldChooseBar').style.display = 'none';");
    }
    //<< 
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< DisplayView(pidClass="",pidView="")
  public Object DisplayView(Object ... _p) {
    mVar pidClass = m$.newVarRef("pidClass",(((_p!=null)&&(_p.length>=1))?_p[0]:null),"");
    mVar pidView = m$.newVarRef("pidView",(((_p!=null)&&(_p.length>=2))?_p[1]:null),"");
    //<< ;-------------------------------------------------------------------------------
    //<< ; Populates the favourite radio buttons on the screen.
    //<< ;
    //<< ; History:
    //<< ; 06-Apr-2009   shobby  SR16443: Different colours are now used to highlight
    //<< ;                           whether a COMView favourite is core (distribute)
    //<< ;                           or user defined.
    //<< ; 22-May-2007   RPW     SR15524: Allow for "no views" to work correctly.
    //<< ; 24-Apr-2007   FrankF  SRBR014441: Translation for favourites.
    //<< ; 19-Feb-2007   Steve S SR15440: 'If' test no longer needed
    //<< ; 15-Feb-2007   Steve S SR15431: Use an array / order macro
    //<< ; 09-Feb-2007   RPW     SR15426: If we are in form only show locked favourites
    //<< ; 01-Feb-2006   PO      SR14257: Support non numeric favourite ids
    //<< ; 12-Apr-2005   Paul K  Commented
    //<< ;-------------------------------------------------------------------------------
    //<< new arrViews,blnActive,idView,objView,strDesc
    mVar arrViews = m$.var("arrViews");
    mVar blnActive = m$.var("blnActive");
    mVar idView = m$.var("idView");
    mVar objView = m$.var("objView");
    mVar strDesc = m$.var("strDesc");
    m$.newVar(arrViews,blnActive,idView,objView,strDesc);
    //<< 
    //<< write "RemoveViews();"
    m$.Cmd.Write("RemoveViews();");
    //<< 
    //<< do GetViews^COMViewFavourite(pidClass,YLOCATION,YBED,.arrViews)
    m$.Cmd.Do("COMViewFavourite.GetViews",pidClass.get(),m$.var("YLOCATION").get(),m$.var("YBED").get(),arrViews);
    //<< 
    //<< if '$data(arrViews)&&(pidView=0) {
    if (mOp.Not(m$.Fnc.$data(arrViews)) && (mOp.Equal(pidView.get(),0))) {
      //<< set arrViews(0)=""
      arrViews.var(0).set("");
    }
    //<< }
    //<< 
    //<< set idView=""
    idView.set("");
    //<< for {
    for (;true;) {
      //<< set idView=$order(arrViews(idView))
      idView.set(m$.Fnc.$order(arrViews.var(idView.get())));
      //<< quit:idView=""
      if (mOp.Equal(idView.get(),"")) {
        break;
      }
      //<< 
      //<< set objView = $get(^COMView(0,pidClass,idView,1))
      objView.set(m$.Fnc.$get(m$.var("^COMView",0,pidClass.get(),idView.get(),1)));
      //<< 
      //<< // only relevant views are now returned
      //<< 
      //<< // Translation for favourites.
      //<< set strDesc = $$GetTextForFavourite(pidClass, idView, objView)
      strDesc.set(m$.fnc$("GetTextForFavourite",pidClass.get(),idView.get(),objView.get()));
      //<< set blnActive = (pidView=idView)
      blnActive.set((mOp.Equal(pidView.get(),idView.get())));
      //<< 
      //<< write "AddView('"_idView_"','"_strDesc_"',"_blnActive_","_+$$$COMViewDistribute(objView)_");"
      m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("AddView('",idView.get()),"','"),strDesc.get()),"',"),blnActive.get()),","),mOp.Positive(include.COMConst.$$$COMViewDistribute(m$,objView))),");"));
    }
    //<< }
    //<< write "ViewChanged('','"_pidView_"');" // SR14257
    m$.Cmd.Write(mOp.Concat(mOp.Concat("ViewChanged('','",pidView.get()),"');"));
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< AllowedToCreateViews(strCompany,strUser)
  public Object AllowedToCreateViews(Object ... _p) {
    mVar strCompany = m$.newVarRef("strCompany",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar strUser = m$.newVarRef("strUser",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Determine whether a particular user is permitted to create a new view
    //<< ;
    //<< ; Params: Company - YM, strUser - YBED
    //<< ;
    //<< ; Returns: $$$YES if user is permitted to create new views
    //<< ;
    //<< ; History:
    //<< ; 15-Sep-2005   JW      SR13502: Check access correctly.
    //<< ; 28-Jul-2005   PO      SR12608: Correctly check whether user priviledges exist
    //<< ;                           in required priviledges.
    //<< ; 13-Jul-2005   PO      SR12608: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new objCOMViewConfig,strRequiredPriviledge,strStatus
    mVar objCOMViewConfig = m$.var("objCOMViewConfig");
    mVar strRequiredPriviledge = m$.var("strRequiredPriviledge");
    mVar strStatus = m$.var("strStatus");
    m$.newVar(objCOMViewConfig,strRequiredPriviledge,strStatus);
    //<< 
    //<< set objCOMViewConfig = $get(^COMViewConfig(0,strCompany,1))
    objCOMViewConfig.set(m$.Fnc.$get(m$.var("^COMViewConfig",0,strCompany.get(),1)));
    //<< set strRequiredPriviledge = $$$COMViewConfigAbletocreateviews(objCOMViewConfig)
    strRequiredPriviledge.set(include.COMConst.$$$COMViewConfigAbletocreateviews(m$,objCOMViewConfig));
    //<< 
    //<< set strStatus=$$$OK
    strStatus.set(include.COMSYS.$$$OK(m$));
    //<< if '$$UserHasAccess^COMUtils(strUser,strRequiredPriviledge) {
    if (mOp.Not(m$.fnc$("COMUtils.UserHasAccess",strUser.get(),strRequiredPriviledge.get()))) {
      //<< set strStatus = $listbuild("Com00210",strUser)
      strStatus.set(m$.Fnc.$listbuild("Com00210",strUser.get()));
    }
    //<< } ; "User %1 is not allowed to create new views."
    //<< quit strStatus
    return strStatus.get();
  }

  //<< 
  //<< 
  //<< HasViewAccess(pidUser,pidForm,pidCompany)
  public Object HasViewAccess(Object ... _p) {
    mVar pidUser = m$.newVarRef("pidUser",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pidForm = m$.newVarRef("pidForm",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pidCompany = m$.newVarRef("pidCompany",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Determine whether user is allowed to change view. Note: reference to view is not
    //<< ; referring to favourite, but instead things like filters, search results, field chooser.
    //<< ;
    //<< ; Params: pidUser, pidForm, pidCompany
    //<< ;
    //<< ; ByRefs: None
    //<< ;
    //<< ; Returns: boolean - if user permitted to change view otherwise $$$NO
    //<< ;
    //<< ; History:
    //<< ; 10-Feb-2006   JW&SC   SR14250: Customisation overrides default. Use boolean.
    //<< ;                       Add pidForm null check
    //<< ; 31-Jan-2006   PO      SR14250: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new blnAccess,objWWW120,objWWW120D,strRequiredPriviledge
    mVar blnAccess = m$.var("blnAccess");
    mVar objWWW120 = m$.var("objWWW120");
    mVar objWWW120D = m$.var("objWWW120D");
    mVar strRequiredPriviledge = m$.var("strRequiredPriviledge");
    m$.newVar(blnAccess,objWWW120,objWWW120D,strRequiredPriviledge);
    //<< 
    //<< if pidForm="" {
    if (mOp.Equal(pidForm.get(),"")) {
      //<< set blnAccess = $$$YES
      blnAccess.set(include.COMSYS.$$$YES(m$));
    }
    //<< } else {
    else {
      //<< set objWWW120  = $get(^WWW120(0,pidForm,1))
      objWWW120.set(m$.Fnc.$get(m$.var("^WWW120",0,pidForm.get(),1)));
      //<< set objWWW120D = $get(^WWW120D(0,pidForm,pidCompany,1))
      objWWW120D.set(m$.Fnc.$get(m$.var("^WWW120D",0,pidForm.get(),pidCompany.get(),1)));
      //<< 
      //<< set strRequiredPriviledge = $$$WWW120ViewAccess(objWWW120)
      strRequiredPriviledge.set(include.WWWConst.$$$WWW120ViewAccess(m$,objWWW120));
      //<< if $$$WWW120DViewAccess(objWWW120D)'="" {
      if (mOp.NotEqual(include.WWWConst.$$$WWW120DViewAccess(m$,objWWW120D),"")) {
        //<< set strRequiredPriviledge = $$$WWW120DViewAccess(objWWW120D)
        strRequiredPriviledge.set(include.WWWConst.$$$WWW120DViewAccess(m$,objWWW120D));
      }
      //<< }
      //<< set blnAccess = $$UserHasAccess^COMUtils(pidUser,strRequiredPriviledge)
      blnAccess.set(m$.fnc$("COMUtils.UserHasAccess",pidUser.get(),strRequiredPriviledge.get()));
    }
    //<< }
    //<< quit blnAccess
    return blnAccess.get();
  }

  //<< 
  //<< 
  //<< NewView(pstrName)
  public Object NewView(Object ... _p) {
    mVar pstrName = m$.newVarRef("pstrName",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Call back from screen when new favourite name selected
    //<< ;
    //<< ; History:
    //<< ; 22-May-2007   RPW     SR15524: Use Save macro to save comview classes
    //<< ; 14-May-2007   GRF     Use DEVMODE macro
    //<< ; 09-Feb-2007   RPW     SR15426: Store the Lock value if we are in form.
    //<< ; 02-Nov-2006   JW      SR15170: Pad VAR/USR numbers with zeroes
    //<< ; 01-Feb-2006   PO      SR14257: Favourite ids created by Disc are simply numeric,
    //<< ;                       prefixed with VAR is for client customisation and USR is
    //<< ;                       for a particular user.
    //<< ; 31-Jan-2006   PO      SR14249: Hide disabled buttons
    //<< ; 13-Jul-2005   PO      SR12608: Check whether user is permitted to create views
    //<< ; 01-Jul-2005   RPW     $$$Alert already does a $$$Text, we do not need to do it again
    //<< ; 12-Apr-2005   Paul K  Commented
    //<< ;-------------------------------------------------------------------------------
    //<< new blnIsSuper,idClass,idCurrentView,idView,objView,objViewUser,strStatus
    mVar blnIsSuper = m$.var("blnIsSuper");
    mVar idClass = m$.var("idClass");
    mVar idCurrentView = m$.var("idCurrentView");
    mVar idView = m$.var("idView");
    mVar objView = m$.var("objView");
    mVar objViewUser = m$.var("objViewUser");
    mVar strStatus = m$.var("strStatus");
    m$.newVar(blnIsSuper,idClass,idCurrentView,idView,objView,objViewUser,strStatus);
    //<< 
    //<< set strStatus = $$AllowedToCreateViews(YM,YBED)
    strStatus.set(m$.fnc$("AllowedToCreateViews",m$.var("YM").get(),m$.var("YBED").get()));
    //<< if $$$ISOK(strStatus) {
    if (mOp.Logical(include.COMSYS.$$$ISOK(m$,strStatus))) {
      //<< set idClass       = $get(^CacheTempView(YUSER,"Class"))
      idClass.set(m$.Fnc.$get(m$.var("^CacheTempView",m$.var("YUSER").get(),"Class")));
      //<< set idCurrentView = $$GetCurrentView(idClass)
      idCurrentView.set(m$.fnc$("GetCurrentView",idClass.get()));
      //<< if pstrName="" set strStatus = "Com00112"  ; "Favourite Name required."    ; FIXME : $$$MakeStatus? <GRF>
      if (mOp.Equal(pstrName.get(),"")) {
        strStatus.set("Com00112");
      }
    }
    //<< }
    //<< 
    //<< if $$$ISOK(strStatus) {
    if (mOp.Logical(include.COMSYS.$$$ISOK(m$,strStatus))) {
      //<< set blnIsSuper = $$SuperUser^COMViewUtils()
      blnIsSuper.set(m$.fnc$("COMViewUtils.SuperUser"));
      //<< if blnIsSuper {
      if (mOp.Logical(blnIsSuper.get())) {
        //<< 
        //<< if $$$DEVMODE {
        if (mOp.Logical(include.COMSYS.$$$DEVMODE(m$))) {
          //<< set idView = $order(^COMView(0,idClass,"A"),-1)+1 // Last/greatest numeric favourite id
          idView.set(mOp.Add(m$.Fnc.$order(m$.var("^COMView",0,idClass.get(),"A"),mOp.Negative(1)),1));
        }
        //<< 
        //<< } else {    // VAR Super views - add 1 to last 2 digit number
        else {
          //<< set idView = $order(^COMView(0,idClass,"W"),-1)
          idView.set(m$.Fnc.$order(m$.var("^COMView",0,idClass.get(),"W"),mOp.Negative(1)));
          //<< if $extract(idView,1,3) '= "VAR" {
          if (mOp.NotEqual(m$.Fnc.$extract(idView.get(),1,3),"VAR")) {
            //<< set idView = "VAR00"
            idView.set("VAR00");
          }
          //<< } else {
          else {
            //<< set $extract(idView,1,3) = ""
            mVar $extract = m$.var("$extract");
            $extract.var(idView.get(),1,3).set("");
            //<< set idView = "VAR"_$translate($justify(idView+1,2)," ",0)   // pad with zeroes
            idView.set(mOp.Concat("VAR",m$.Fnc.$translate(m$.Fnc.$justify(mOp.Add(idView.get(),1),2)," ",0)));
          }
        }
      }
      //<< }
      //<< }
      //<< } else {        // User views - add 1 to last 5 digit number
      else {
        //<< set idView = $order(^COMView(0,idClass,"V"),-1)
        idView.set(m$.Fnc.$order(m$.var("^COMView",0,idClass.get(),"V"),mOp.Negative(1)));
        //<< if $extract(idView,1,3) '= "USR" {
        if (mOp.NotEqual(m$.Fnc.$extract(idView.get(),1,3),"USR")) {
          //<< set idView = "USR00000"
          idView.set("USR00000");
        }
        //<< 
        //<< } else {
        else {
          //<< set $extract(idView,1,3) = ""
          mVar $extract = m$.var("$extract");
          $extract.var(idView.get(),1,3).set("");
          //<< set idView = "USR"_$translate($justify(idView+1,5)," ",0)       // pad with zeroes
          idView.set(mOp.Concat("USR",m$.Fnc.$translate(m$.Fnc.$justify(mOp.Add(idView.get(),1),5)," ",0)));
        }
      }
      //<< }
      //<< }
      //<< 
      //<< set objView=""
      objView.set("");
      //<< set $$$COMViewDescription(objView) = pstrName
      include.COMConst.$$$COMViewDescriptionSet(m$,objView,pstrName.get());
      //<< set $$$COMViewLocation(objView)    = ""
      include.COMConst.$$$COMViewLocationSet(m$,objView,"");
      //<< set $$$COMViewLock(objView)        = $get(^CacheTempView(YUSER,YUCI,"InForm"))
      include.COMConst.$$$COMViewLockSet(m$,objView,m$.Fnc.$get(m$.var("^CacheTempView",m$.var("YUSER").get(),m$.var("YUCI").get(),"InForm")));
      //<< if 'blnIsSuper {
      if (mOp.Not(blnIsSuper.get())) {
        //<< set $$$COMViewUser1(objView)=YBED
        include.COMConst.$$$COMViewUser1Set(m$,objView,m$.var("YBED").get());
      }
      //<< }
      //<< 
      //<< set strStatus = $$$Save("COMView",idClass_$$$COMMA_idView,objView,$$$YES)
      strStatus.set(include.COMSYS.$$$Save(m$,"COMView",mOp.Concat(mOp.Concat(idClass.get(),include.COMSYSString.$$$COMMA(m$)),idView.get()),objView,include.COMSYS.$$$YES(m$)));
      //<< 
      //<< set objViewUser = $get(^COMViewUser(0,idClass,YBED,1))
      objViewUser.set(m$.Fnc.$get(m$.var("^COMViewUser",0,idClass.get(),m$.var("YBED").get(),1)));
      //<< set $$$COMViewUserLastView(objViewUser) = idView
      include.COMConst.$$$COMViewUserLastViewSet(m$,objViewUser,idView.get());
      //<< set ^COMViewUser(0,idClass,YBED,1)      = objViewUser     ; $$$Save?
      m$.var("^COMViewUser",0,idClass.get(),m$.var("YBED").get(),1).set(objViewUser.get());
      //<< do DisplayView(idClass,idView)
      m$.Cmd.Do("DisplayView",idClass.get(),idView.get());
      //<< 
      //<< kill ^COMViewColumnUser(0,idClass,idView,YBED)
      m$.var("^COMViewColumnUser",0,idClass.get(),idView.get(),m$.var("YBED").get()).kill();
      //<< merge ^COMViewColumnUser(0,idClass,idView,YBED) = ^COMViewColumnUser(0,idClass,idCurrentView,YBED)
      m$.Cmd.Merge(m$.var("^COMViewColumnUser",0,idClass.get(),idView.get(),m$.var("YBED").get()),m$.var("^COMViewColumnUser",0,idClass.get(),idCurrentView.get(),m$.var("YBED").get()));
      //<< 
      //<< do SaveCurrentView(idView)
      m$.Cmd.Do("SaveCurrentView",idView.get());
    }
    //<< 
    //<< } else {
    else {
      //<< $$$Alert(strStatus)
      include.COMSYS.$$$Alert(m$,strStatus);
    }
    //<< }
    //<< 
    //<< if ($get(idClass)'="") && ($get(idView)'="") do HideDisabledButtons(idClass,idView)
    if ((mOp.NotEqual(m$.Fnc.$get(idClass),"")) && (mOp.NotEqual(m$.Fnc.$get(idView),""))) {
      m$.Cmd.Do("HideDisabledButtons",idClass.get(),idView.get());
    }
    //<< 
    //<< quit $$$OK
    return include.COMSYS.$$$OK(m$);
  }

  //<< 
  //<< 
  //<< SaveCurrentView(pidView)
  public Object SaveCurrentView(Object ... _p) {
    mVar pidView = m$.newVarRef("pidView",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Save the filters for a favourite
    //<< ;
    //<< ; History:
    //<< ; 22-May-2007   RPW     SR15524: Quit if there is no view.
    //<< ; 16-Feb-2007   RPW     SR15426: Display the grid after saving the data
    //<< ; 14-Feb-2007   SteveS  SR15431: Status handling, tstart/tcommit
    //<< ;                            Use standard alert, not VBConfirm
    //<< ; 29-Aug-2006   JW      SR14763: Language text, cleaned up.
    //<< ; 12-Apr-2005   Paul K  Commented
    //<< ;-------------------------------------------------------------------------------
    //<< new idClass,idFilter,strStatus
    mVar idClass = m$.var("idClass");
    mVar idFilter = m$.var("idFilter");
    mVar strStatus = m$.var("strStatus");
    m$.newVar(idClass,idFilter,strStatus);
    //<< 
    //<< quit:$get(pidView)="" $$$OK
    if (mOp.Equal(m$.Fnc.$get(pidView),"")) {
      return include.COMSYS.$$$OK(m$);
    }
    //<< 
    //<< set idClass   = $get(^CacheTempView(YUSER,"Class"))
    idClass.set(m$.Fnc.$get(m$.var("^CacheTempView",m$.var("YUSER").get(),"Class")));
    //<< set strStatus = $$CanModifyView(idClass,pidView)
    strStatus.set(m$.fnc$("CanModifyView",idClass.get(),pidView.get()));
    //<< 
    //<< ;+++++++++++++++++++++++++++++++++++++++
    //<< tstart
    //<< ;+++++++++++++++++++++++++++++++++++++++
    //<< 
    //<< if $$$ISOK(strStatus) {
    if (mOp.Logical(include.COMSYS.$$$ISOK(m$,strStatus))) {
      //<< set strStatus = $$SaveFilters(idClass,pidView)
      strStatus.set(m$.fnc$("SaveFilters",idClass.get(),pidView.get()));
      //<< if $$$ISOK(strStatus) {
      if (mOp.Logical(include.COMSYS.$$$ISOK(m$,strStatus))) {
        //<< do SaveColumns^COMViewColumn(idClass,pidView)
        m$.Cmd.Do("COMViewColumn.SaveColumns",idClass.get(),pidView.get());
        //<< if $get(^CacheTempView(YUSER,"EditMode")) {
        if (mOp.Logical(m$.Fnc.$get(m$.var("^CacheTempView",m$.var("YUSER").get(),"EditMode")))) {
          //<< kill ^CacheTempView(YUSER,"EditMode")
          m$.var("^CacheTempView",m$.var("YUSER").get(),"EditMode").kill();
          //<< do DisplayControls^COMViewFilterControl(idClass)
          m$.Cmd.Do("COMViewFilterControl.DisplayControls",idClass.get());
        }
      }
    }
    //<< }
    //<< }
    //<< }
    //<< 
    //<< ;+++++++++++++++++++++++++++++++++++++++
    //<< if $$$ISOK(strStatus) {
    if (mOp.Logical(include.COMSYS.$$$ISOK(m$,strStatus))) {
      //<< if $tlevel>0 tcommit
      if (mOp.Greater(m$.Fnc.$tlevel(),0)) {
      }
    }
    //<< } else {
    else {
      //<< trollback
      //<< $$$Alert(strStatus)
      include.COMSYS.$$$Alert(m$,strStatus);
    }
    //<< }
    //<< ;+++++++++++++++++++++++++++++++++++++++
    //<< 
    //<< do DisplayGrid^COMViewFilter()
    m$.Cmd.Do("COMViewFilter.DisplayGrid");
    //<< quit $$$OK
    return include.COMSYS.$$$OK(m$);
  }

  //<< 
  //<< 
  //<< SaveFilters(pidClass,pidView)
  public Object SaveFilters(Object ... _p) {
    mVar pidClass = m$.newVarRef("pidClass",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pidView = m$.newVarRef("pidView",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Saves favourite filters for the current view.
    //<< ;
    //<< ; History:
    //<< ; 31-Aug-2007   shobby  SRBR014677: For each user save the values of External
    //<< ;                           filters in case they are needed when reloading the
    //<< ;                           screen.  Managed in the routine that calls
    //<< ;                           AddExternalFilter.
    //<< ; 10-Jul-2007   HeberB  BR014579: Fixed logic to find out whether filter is external
    //<< ; 09-Jul-2007   HeberB  BR014579: Prevent external fields from being added to Filter entry
    //<< ; 14-Feb-2007   SteveS  SR15431: Save/kill properly -- order macros
    //<< ; 30-Dec-2004   Paul K  Created
    //<< ;-------------------------------------------------------------------------------
    //<< new idFilter,intExternalFilterId,intFilterLoop,objFilter,strStatus,strKey
    mVar idFilter = m$.var("idFilter");
    mVar intExternalFilterId = m$.var("intExternalFilterId");
    mVar intFilterLoop = m$.var("intFilterLoop");
    mVar objFilter = m$.var("objFilter");
    mVar strStatus = m$.var("strStatus");
    mVar strKey = m$.var("strKey");
    m$.newVar(idFilter,intExternalFilterId,intFilterLoop,objFilter,strStatus,strKey);
    //<< 
    //<< set strStatus=$$$OK
    strStatus.set(include.COMSYS.$$$OK(m$));
    //<< 
    //<< set idFilter = ""
    idFilter.set("");
    //<< for {
    for (;true;) {
      //<< set idFilter = $order(^COMViewFilter(0,pidClass,pidView,idFilter))
      idFilter.set(m$.Fnc.$order(m$.var("^COMViewFilter",0,pidClass.get(),pidView.get(),idFilter.get())));
      //<< quit:idFilter=""
      if (mOp.Equal(idFilter.get(),"")) {
        break;
      }
      //<< 
      //<< set strStatus = $$$Kill("COMViewFilter",pidClass_","_pidView_","_idFilter)
      strStatus.set(include.COMSYS.$$$Kill(m$,"COMViewFilter",mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(pidClass.get(),","),pidView.get()),","),idFilter.get())));
      //<< quit:$$$ISERR(strStatus)
      if (mOp.Logical(include.COMSYS.$$$ISERR(m$,strStatus))) {
        break;
      }
    }
    //<< }
    //<< 
    //<< if $$$ISOK(strStatus) {
    if (mOp.Logical(include.COMSYS.$$$ISOK(m$,strStatus))) {
      //<< set idFilter = ""
      idFilter.set("");
      //<< for {
      for (;true;) {
        //<< set idFilter = $order(^CacheTempView(YUSER,"Filter",idFilter))
        idFilter.set(m$.Fnc.$order(m$.var("^CacheTempView",m$.var("YUSER").get(),"Filter",idFilter.get())));
        //<< quit:idFilter=""
        if (mOp.Equal(idFilter.get(),"")) {
          break;
        }
        //<< 
        //<< set objFilter = $get(^CacheTempView(YUSER,"Filter",idFilter))
        objFilter.set(m$.Fnc.$get(m$.var("^CacheTempView",m$.var("YUSER").get(),"Filter",idFilter.get())));
        //<< set intExternalFilterId = $$GetIdExternalFilter(idFilter)
        intExternalFilterId.set(m$.fnc$("GetIdExternalFilter",idFilter.get()));
        //<< if intExternalFilterId'="" {
        if (mOp.NotEqual(intExternalFilterId.get(),"")) {
          //<< set ^CacheTempExternalFilter(YUCI,YUSER,$piece(objFilter,Y,1))=$piece(objFilter,Y,2)
          m$.var("^CacheTempExternalFilter",m$.var("YUCI").get(),m$.var("YUSER").get(),m$.Fnc.$piece(objFilter.get(),m$.var("Y").get(),1)).set(m$.Fnc.$piece(objFilter.get(),m$.var("Y").get(),2));
        }
        //<< 
        //<< } else {
        else {
          //<< set strKey    = pidClass_","_pidView_","_$increment(intFilterLoop)
          strKey.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(pidClass.get(),","),pidView.get()),","),m$.Fnc.$increment(intFilterLoop)));
          //<< set strStatus = $$$Save("COMViewFilter",strKey,objFilter,1)
          strStatus.set(include.COMSYS.$$$Save(m$,"COMViewFilter",strKey,objFilter,1));
        }
        //<< }
        //<< quit:$$$ISERR(strStatus)
        if (mOp.Logical(include.COMSYS.$$$ISERR(m$,strStatus))) {
          break;
        }
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
  //<< DeleteCurrentView(pidView)
  public Object DeleteCurrentView(Object ... _p) {
    mVar pidView = m$.newVarRef("pidView",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Deletes a favourite and shows the default favourite.
    //<< ;
    //<< ; Called By JS: DeleteView()
    //<< ;
    //<< ; History:
    //<< ; 09-Nov-2009   shobby  SR16560: Add direct call to ViewChanged.  This is
    //<< ;                           actually called from Javascript from within the
    //<< ;                           DisplayView routine.  However it won't actually run
    //<< ;                           as you can't to a Callback from Javascript to Cache
    //<< ;                           from within a callback from Javascript to cache.
    //<< ; 07-Apr-2009   shobby  SR16474: Moved the deleting of related classes to
    //<< ;                           OnBeforeDelete (hook)
    //<< ; 22-May-2007   RPW     SR15524: Count the number of views and if there is only
    //<< ;                           one do not allow it to be deleted.
    //<< ;                           Use Kill macro to kill globals
    //<< ; 22-Feb-2007   SteveS  SR15440: Get available view
    //<< ; 15-Feb-2007   SteveS  SR15431: Use standard alert, not VBConfirm
    //<< ; 28-Aug-2006   JW      SR14763: Set status. Language text. Cleaned up.
    //<< ; 31-Jan-2006   PO      SR14249: Hide disabled buttons
    //<< ; 12-Apr-2005   PaulK   Commented
    //<< ;-------------------------------------------------------------------------------
    //<< new idClass,idReq,idView,idxForm,intCount,strStatus
    mVar idClass = m$.var("idClass");
    mVar idReq = m$.var("idReq");
    mVar idView = m$.var("idView");
    mVar idxForm = m$.var("idxForm");
    mVar intCount = m$.var("intCount");
    mVar strStatus = m$.var("strStatus");
    m$.newVar(idClass,idReq,idView,idxForm,intCount,strStatus);
    //<< 
    //<< set idClass  = $get(^CacheTempView(YUSER,"Class"))
    idClass.set(m$.Fnc.$get(m$.var("^CacheTempView",m$.var("YUSER").get(),"Class")));
    //<< set intCount = 0
    intCount.set(0);
    //<< 
    //<< if $get(^CacheTempView(YUSER,YUCI,"InForm")) {
    if (mOp.Logical(m$.Fnc.$get(m$.var("^CacheTempView",m$.var("YUSER").get(),m$.var("YUCI").get(),"InForm")))) {
      //<< set idxForm = $$$Index($get(^CacheTempView(YUSER,"CallingForm")))
      idxForm.set(include.MEDConst.$$$Index(m$,m$.Fnc.$get(m$.var("^CacheTempView",m$.var("YUSER").get(),"CallingForm"))));
      //<< 
      //<< set idReq = ""
      idReq.set("");
      //<< for {
      for (;true;) {
        //<< set idReq = $order(^COMViews(0,1,$$$YES,idxForm,idClass,idReq))
        idReq.set(m$.Fnc.$order(m$.var("^COMViews",0,1,include.COMSYS.$$$YES(m$),idxForm.get(),idClass.get(),idReq.get())));
        //<< quit:idReq=""
        if (mOp.Equal(idReq.get(),"")) {
          break;
        }
        //<< 
        //<< set intCount = intCount+1
        intCount.set(mOp.Add(intCount.get(),1));
      }
      //<< }
      //<< 
      //<< set idReq = ""
      idReq.set("");
      //<< for {
      for (;true;) {
        //<< set idReq = $order(^COMViews(0,1,$$$YES," ",idClass,idReq))
        idReq.set(m$.Fnc.$order(m$.var("^COMViews",0,1,include.COMSYS.$$$YES(m$)," ",idClass.get(),idReq.get())));
        //<< quit:idReq=""
        if (mOp.Equal(idReq.get(),"")) {
          break;
        }
        //<< 
        //<< set intCount = intCount+1
        intCount.set(mOp.Add(intCount.get(),1));
      }
    }
    //<< }
    //<< }
    //<< 
    //<< if (pidView=0) || (intCount=1) {
    if ((mOp.Equal(pidView.get(),0)) || (mOp.Equal(intCount.get(),1))) {
      //<< set strStatus = $listbuild("Com00120")  ; "Cannot delete the default favourite."
      strStatus.set(m$.Fnc.$listbuild("Com00120"));
    }
    //<< 
    //<< } else {
    else {
      //<< set strStatus = $$CanModifyView(idClass,pidView)
      strStatus.set(m$.fnc$("CanModifyView",idClass.get(),pidView.get()));
      //<< 
      //<< if $$$ISOK(strStatus) {
      if (mOp.Logical(include.COMSYS.$$$ISOK(m$,strStatus))) {
        //<< kill ^CacheTempView(YUSER,"EditMode")
        m$.var("^CacheTempView",m$.var("YUSER").get(),"EditMode").kill();
        //<< 
        //<< set strStatus = $$$Kill("COMView",idClass_$$$COMMA_pidView)
        strStatus.set(include.COMSYS.$$$Kill(m$,"COMView",mOp.Concat(mOp.Concat(idClass.get(),include.COMSYSString.$$$COMMA(m$)),pidView.get())));
        //<< do ClearCache^COMViewSession()
        m$.Cmd.Do("COMViewSession.ClearCache");
        //<< set idView = $$GetAvailableView^COMViewFavourite(idClass)
        idView.set(m$.fnc$("COMViewFavourite.GetAvailableView",idClass.get()));
        //<< 
        //<< do DisplayView(idClass,idView)
        m$.Cmd.Do("DisplayView",idClass.get(),idView.get());
        //<< do ViewChanged(idView)
        m$.Cmd.Do("ViewChanged",idView.get());
        //<< do SetColumnsForView^COMViewColumn(idClass,idView)
        m$.Cmd.Do("COMViewColumn.SetColumnsForView",idClass.get(),idView.get());
        //<< do SetFiltersForView(idClass,idView)
        m$.Cmd.Do("SetFiltersForView",idClass.get(),idView.get());
        //<< do DisplayControls^COMViewFilterControl(idClass)
        m$.Cmd.Do("COMViewFilterControl.DisplayControls",idClass.get());
        //<< do DisplayGrid^COMViewFilter()
        m$.Cmd.Do("COMViewFilter.DisplayGrid");
      }
    }
    //<< }
    //<< }
    //<< 
    //<< if $$$ISERR(strStatus) {
    if (mOp.Logical(include.COMSYS.$$$ISERR(m$,strStatus))) {
      //<< $$$SetStatus
      include.COMView.$$$SetStatus(m$);
      //<< $$$Alert(strStatus)
      include.COMSYS.$$$Alert(m$,strStatus);
    }
    //<< }
    //<< 
    //<< if $get(idClass)'="" do HideDisabledButtons(idClass,pidView)
    if (mOp.NotEqual(m$.Fnc.$get(idClass),"")) {
      m$.Cmd.Do("HideDisabledButtons",idClass.get(),pidView.get());
    }
    //<< quit $$$OK
    return include.COMSYS.$$$OK(m$);
  }

  //<< 
  //<< 
  //<< EditCurrentView(pidView)
  public Object EditCurrentView(Object ... _p) {
    mVar pidView = m$.newVarRef("pidView",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Callback from when a user clicks the open favourite button
    //<< ;
    //<< ; History:
    //<< ; 22-May-2007   RPW     SR15524: quit if there is no view
    //<< ; 14-Feb-2007   SteveS  SR15431: Also store the favourite id
    //<< ;                            Use standard alert, not VBConfirm
    //<< ; 29-Aug-2006   JW      SR14763: Language text
    //<< ; 12-Apr-2005   Paul K  Commented
    //<< ;-------------------------------------------------------------------------------
    //<< new idClass,strStatus
    mVar idClass = m$.var("idClass");
    mVar strStatus = m$.var("strStatus");
    m$.newVar(idClass,strStatus);
    //<< 
    //<< quit:$get(pidView)="" $$$OK // SR15524
    if (mOp.Equal(m$.Fnc.$get(pidView),"")) {
      return include.COMSYS.$$$OK(m$);
    }
    //<< 
    //<< set idClass   = $get(^CacheTempView(YUSER,"Class"))
    idClass.set(m$.Fnc.$get(m$.var("^CacheTempView",m$.var("YUSER").get(),"Class")));
    //<< set strStatus = $$CanModifyView(idClass,pidView)
    strStatus.set(m$.fnc$("CanModifyView",idClass.get(),pidView.get()));
    //<< 
    //<< if $$$ISOK(strStatus) {
    if (mOp.Logical(include.COMSYS.$$$ISOK(m$,strStatus))) {
      //<< set ^CacheTempView(YUSER,"EditMode")            = $$$YES
      m$.var("^CacheTempView",m$.var("YUSER").get(),"EditMode").set(include.COMSYS.$$$YES(m$));
      //<< set ^CacheTempView(YUSER,"EditMode","ViewName") = pidView
      m$.var("^CacheTempView",m$.var("YUSER").get(),"EditMode","ViewName").set(pidView.get());
      //<< do DisplayControls^COMViewFilterControl(idClass)
      m$.Cmd.Do("COMViewFilterControl.DisplayControls",idClass.get());
    }
    //<< 
    //<< } else {
    else {
      //<< $$$Alert(strStatus)
      include.COMSYS.$$$Alert(m$,strStatus);
    }
    //<< }
    //<< 
    //<< quit $$$OK
    return include.COMSYS.$$$OK(m$);
  }

  //<< 
  //<< 
  //<< CreateFavouriteControl()
  public Object CreateFavouriteControl() {
    //<< ;-------------------------------------------------------------------------------
    //<< ; Creates the DOM for the header.
    //<< ;
    //<< ; History:
    //<< ; 18-May-2009   shobby  SR16443: Removed $$$DEVMODE test when setting the value of the
    //<< ;                           distribute checkbox.
    //<< ; 06-Apr-2009   shobby  SR16443: Reworked code.  Removed duplicate codes.
    //<< ;                           Structured controls so that the label and input
    //<< ;                           control remain together, to avoid confusion when the
    //<< ;                           text (ie User) appears on a different line than the
    //<< ;                           'User' input control.
    //<< ; 06-Apr-2009   shobby  SR16443: Corrected the display of the 'Distribute' checkbox.
    //<< ; 24-Mar-2008   shobby  SRBR014916: Improved loading of <options> when there is
    //<< ;                           a very long list.
    //<< ;                           ***** Note:
    //<< ;                           Bug in IE prevents manipulation of innerHTML.  So
    //<< ;                           outerHTML is used instead, which means that events
    //<< ;                           have to be attached *after* the options are added.
    //<< ; 14-May-2007   GRF     SR15440: Use DEVMODE macro
    //<< ; 23-Apr-2007   RPW     SR15440: Fixed cbLock handling
    //<< ; 15-Mar-2007   JW      SR15403: Distribute checkbox is only in Dev.
    //<< ; 14-Feb-2007   Steve S SR15431: 'This form only' checkbox
    //<< ; 09-Feb-2007   RPW     SR15426: Add the Lock checkbox.
    //<< ;                            Also use W3C Syntax to get DOM Elements.
    //<< ; 05-Apr-2005   Paul K  SR11984: Don't set the development checkbox if not in
    //<< ;                           development mode.
    //<< ; 30-Mar-2005   Paul K  SR11984: Added distribute? check box, aligned header stuff
    //<< ;-------------------------------------------------------------------------------
    //<< new blnForm,blnUseArray,idClass,idForm,idLocation,idUser,idView,objView
    mVar blnForm = m$.var("blnForm");
    mVar blnUseArray = m$.var("blnUseArray");
    mVar idClass = m$.var("idClass");
    mVar idForm = m$.var("idForm");
    mVar idLocation = m$.var("idLocation");
    mVar idUser = m$.var("idUser");
    mVar idView = m$.var("idView");
    mVar objView = m$.var("objView");
    m$.newVar(blnForm,blnUseArray,idClass,idForm,idLocation,idUser,idView,objView);
    //<< 
    //<< set idClass   = $get(^CacheTempView(YUSER,"Class"))
    idClass.set(m$.Fnc.$get(m$.var("^CacheTempView",m$.var("YUSER").get(),"Class")));
    //<< set idView    = $get(^CacheTempView(YUSER,"EditMode","ViewName"))
    idView.set(m$.Fnc.$get(m$.var("^CacheTempView",m$.var("YUSER").get(),"EditMode","ViewName")));
    //<< set objView   = $get(^COMView(0,idClass,idView,1))
    objView.set(m$.Fnc.$get(m$.var("^COMView",0,idClass.get(),idView.get(),1)));
    //<< set idForm    = $$$COMViewForm(objView)
    idForm.set(include.COMConst.$$$COMViewForm(m$,objView));
    //<< set blnForm   = ((idForm'="") && (idForm=$$$CallingForm))
    blnForm.set(((mOp.NotEqual(idForm.get(),"")) && (mOp.Equal(idForm.get(),include.COMView.$$$CallingForm(m$)))));
    //<< 
    //<< if '$data(^CacheTempView(YUSER,"ViewInitialised")) {
    if (mOp.Not(m$.Fnc.$data(m$.var("^CacheTempView",m$.var("YUSER").get(),"ViewInitialised")))) {
      //<< set ^CacheTempView(YUSER,"ViewInitialised")=$$$YES
      m$.var("^CacheTempView",m$.var("YUSER").get(),"ViewInitialised").set(include.COMSYS.$$$YES(m$));
      //<< ;   ++++++++++++++++++++++++++++++++++++ START JS  vvvvv    ; FIXME : Don't include comments in text sent as js <GRF>
      //<< &js<
      //<< function cvCreateInput(pobjText) {
      //<< var objSpace=document.createElement('span');
      //<< objSpace.innerHTML='&nbsp;&nbsp; ';
      //<< objText.appendChild(objSpace);
      //<< }
      //<< function cvCreateCheckBox(pobjText,pid) {
      //<< var objCheck=document.createElement('input');
      //<< objCheck.type='checkbox';
      //<< objCheck.id=pid;
      //<< objCheck.style.whiteSpace='nowrap';
      //<< pobjText.appendChild(objCheck);
      //<< cvCreateInput(pobjText);
      //<< return objCheck;
      //<< }
      //<< function cvCreateSpan(phdrctrl,pValue) {
      //<< var objText=document.createElement('span');
      //<< objText.style.whiteSpace='nowrap';
      //<< phdrctrl.appendChild(objText);
      //<< objText.innerHTML=pValue+'&nbsp;';
      //<< return objText;
      //<< }
      //<< var objText=cvCreateSpan(hdrctrl,'#($zconvert($$$StrCOMViewDescription,"o","JS"))#');
      //<< var objDescription=document.createElement('input');objText.appendChild(objDescription);
      //<< objDescription.id="description";
      //<< objDescription.style.fontSize=10;
      //<< objDescription.attachEvent("onkeyup",ControlChanged);
      //<< cvCreateInput(objText);
      //<< 
      //<< var objText=cvCreateSpan(hdrctrl,'<br/>#($zconvert($$$StrCOMViewLocation,"o","JS"))#');
      //<< var objLocation=document.createElement('select');objText.appendChild(objLocation);
      //<< objLocation.id="ViewLocation";
      //<< objLocation.style.fontSize=10;
      //<< cvCreateInput(objText);
      //<< 
      //<< var objText=cvCreateSpan(hdrctrl,'<br/>#($zconvert($$$StrCOMViewUser1,"o","JS"))#');
      //<< var objUser=document.createElement('select');
      //<< objUser.style.fontSize=10;
      //<< objUser.id="user";
      //<< objUser.style.whiteSpace='nowrap';
      //<< objText.appendChild(objUser);
      //<< cvCreateInput(objText);
      //<< if ('#($$$DEVMODE)#') {
      //<< var objText=cvCreateSpan(hdrctrl,'<br/>#($zconvert($$$StrCOMViewDistribute,"o","JS"))#');
      //<< var objCheck=cvCreateCheckBox(objText,'distribute')
      //<< objCheck.attachEvent('onclick',ControlChanged);
      //<< }
      //<< var objText=cvCreateSpan(hdrctrl,'#($zconvert($$$StrCOMViewLock,"o","JS"))#');
      //<< var objCheck=cvCreateCheckBox(objText,'lock');
      //<< objCheck.attachEvent('onclick',ControlChanged);
      //<< 
      //<< var objText=cvCreateSpan(hdrctrl,'#($$$JSText($$^WWWTEXT("Com00281")))#');
      //<< var objCheck=cvCreateCheckBox(objText,'formonly');
      //<< objCheck.attachEvent('onclick',FormOnlyTicked);
      //<< 
      //<< var objHR= document.createElement('hr');
      //<< document.getElementById('hdrctrl').appendChild(objHR);
      //<< >
      m$.Cmd.WriteJS("","\n");
      m$.Cmd.WriteJS("        function cvCreateInput(pobjText) {","\n");
      m$.Cmd.WriteJS("            var objSpace=document.createElement('span');","\n");
      m$.Cmd.WriteJS("            objSpace.innerHTML='&nbsp;&nbsp; ';","\n");
      m$.Cmd.WriteJS("            objText.appendChild(objSpace);","\n");
      m$.Cmd.WriteJS("        }","\n");
      m$.Cmd.WriteJS("        function cvCreateCheckBox(pobjText,pid) {","\n");
      m$.Cmd.WriteJS("            var objCheck=document.createElement('input');","\n");
      m$.Cmd.WriteJS("            objCheck.type='checkbox';","\n");
      m$.Cmd.WriteJS("            objCheck.id=pid;","\n");
      m$.Cmd.WriteJS("            objCheck.style.whiteSpace='nowrap';","\n");
      m$.Cmd.WriteJS("            pobjText.appendChild(objCheck);","\n");
      m$.Cmd.WriteJS("            cvCreateInput(pobjText);","\n");
      m$.Cmd.WriteJS("            return objCheck;","\n");
      m$.Cmd.WriteJS("        }","\n");
      m$.Cmd.WriteJS("        function cvCreateSpan(phdrctrl,pValue) {","\n");
      m$.Cmd.WriteJS("            var objText=document.createElement('span');","\n");
      m$.Cmd.WriteJS("            objText.style.whiteSpace='nowrap';","\n");
      m$.Cmd.WriteJS("            phdrctrl.appendChild(objText);","\n");
      m$.Cmd.WriteJS("            objText.innerHTML=pValue+'&nbsp;';","\n");
      m$.Cmd.WriteJS("            return objText;","\n");
      m$.Cmd.WriteJS("        }","\n");
      m$.Cmd.WriteJS(mOp.Concat(mOp.Concat("        var objText=cvCreateSpan(hdrctrl,'",(m$.Fnc.$zconvert(include.COMConst.$$$StrCOMViewDescription(m$),"o","JS"))),"');"),"\n");
      m$.Cmd.WriteJS("        var objDescription=document.createElement('input');objText.appendChild(objDescription);","\n");
      m$.Cmd.WriteJS("        objDescription.id=\"description\";","\n");
      m$.Cmd.WriteJS("        objDescription.style.fontSize=10;","\n");
      m$.Cmd.WriteJS("        objDescription.attachEvent(\"onkeyup\",ControlChanged);","\n");
      m$.Cmd.WriteJS("        cvCreateInput(objText);","\n");
      m$.Cmd.WriteJS("        ","\n");
      m$.Cmd.WriteJS(mOp.Concat(mOp.Concat("        var objText=cvCreateSpan(hdrctrl,'<br/>",(m$.Fnc.$zconvert(include.COMConst.$$$StrCOMViewLocation(m$),"o","JS"))),"');"),"\n");
      m$.Cmd.WriteJS("        var objLocation=document.createElement('select');objText.appendChild(objLocation);","\n");
      m$.Cmd.WriteJS("        objLocation.id=\"ViewLocation\";","\n");
      m$.Cmd.WriteJS("        objLocation.style.fontSize=10;","\n");
      m$.Cmd.WriteJS("        cvCreateInput(objText);","\n");
      m$.Cmd.WriteJS("        ","\n");
      m$.Cmd.WriteJS(mOp.Concat(mOp.Concat("        var objText=cvCreateSpan(hdrctrl,'<br/>",(m$.Fnc.$zconvert(include.COMConst.$$$StrCOMViewUser1(m$),"o","JS"))),"');"),"\n");
      m$.Cmd.WriteJS("        var objUser=document.createElement('select');","\n");
      m$.Cmd.WriteJS("        objUser.style.fontSize=10;","\n");
      m$.Cmd.WriteJS("        objUser.id=\"user\";","\n");
      m$.Cmd.WriteJS("        objUser.style.whiteSpace='nowrap';","\n");
      m$.Cmd.WriteJS("        objText.appendChild(objUser);","\n");
      m$.Cmd.WriteJS("        cvCreateInput(objText);","\n");
      m$.Cmd.WriteJS(mOp.Concat(mOp.Concat("        if ('",(include.COMSYS.$$$DEVMODE(m$))),"') {"),"\n");
      m$.Cmd.WriteJS(mOp.Concat(mOp.Concat("            var objText=cvCreateSpan(hdrctrl,'<br/>",(m$.Fnc.$zconvert(include.COMConst.$$$StrCOMViewDistribute(m$),"o","JS"))),"');"),"\n");
      m$.Cmd.WriteJS("            var objCheck=cvCreateCheckBox(objText,'distribute')","\n");
      m$.Cmd.WriteJS("            objCheck.attachEvent('onclick',ControlChanged);","\n");
      m$.Cmd.WriteJS("        }","\n");
      m$.Cmd.WriteJS(mOp.Concat(mOp.Concat("        var objText=cvCreateSpan(hdrctrl,'",(m$.Fnc.$zconvert(include.COMConst.$$$StrCOMViewLock(m$),"o","JS"))),"');"),"\n");
      m$.Cmd.WriteJS("        var objCheck=cvCreateCheckBox(objText,'lock');","\n");
      m$.Cmd.WriteJS("        objCheck.attachEvent('onclick',ControlChanged);","\n");
      m$.Cmd.WriteJS("        ","\n");
      m$.Cmd.WriteJS(mOp.Concat(mOp.Concat("        var objText=cvCreateSpan(hdrctrl,'",(include.COMSYSString.$$$JSText(m$,m$.fnc$("WWWTEXT.main","Com00281")))),"');"),"\n");
      m$.Cmd.WriteJS("        var objCheck=cvCreateCheckBox(objText,'formonly');","\n");
      m$.Cmd.WriteJS("        objCheck.attachEvent('onclick',FormOnlyTicked);","\n");
      m$.Cmd.WriteJS("        ","\n");
      m$.Cmd.WriteJS("        var objHR= document.createElement('hr');","\n");
      m$.Cmd.WriteJS("        document.getElementById('hdrctrl').appendChild(objHR);","\n");
      m$.Cmd.WriteJS("        ");
      //<< 
      //<< ;   ++++++++++++++++++++++++++++++++++++ END JS  ^^^^^
      //<< 
      //<< set blnUseArray = $$$YES  ;This can be removed later if the new code seems to hold up.
      blnUseArray.set(include.COMSYS.$$$YES(m$));
      //<< do StartCombo^COMCombo("objLocation","",1)
      m$.Cmd.Do("COMCombo.StartCombo","objLocation","",1);
      //<< set idLocation = ""
      idLocation.set("");
      //<< for {
      for (;true;) {
        //<< set idLocation = $order(^WWW0121(0,YM,idLocation))
        idLocation.set(m$.Fnc.$order(m$.var("^WWW0121",0,m$.var("YM").get(),idLocation.get())));
        //<< quit:idLocation=""
        if (mOp.Equal(idLocation.get(),"")) {
          break;
        }
        //<< 
        //<< do AddOption^COMCombo(idLocation,$zconvert(idLocation_" - "_$$$WWW0121LocationName($get(^WWW0121(0,YM,idLocation,1))),"o","JS"),blnUseArray)
        m$.Cmd.Do("COMCombo.AddOption",idLocation.get(),m$.Fnc.$zconvert(mOp.Concat(mOp.Concat(idLocation.get()," - "),include.WWWConst.$$$WWW0121LocationName(m$,m$.Fnc.$get(m$.var("^WWW0121",0,m$.var("YM").get(),idLocation.get(),1)))),"o","JS"),blnUseArray.get());
      }
      //<< }
      //<< do StopCombo^COMCombo(blnUseArray)
      m$.Cmd.Do("COMCombo.StopCombo",blnUseArray.get());
      //<< do StartCombo^COMCombo("objUser","",1)
      m$.Cmd.Do("COMCombo.StartCombo","objUser","",1);
      //<< 
      //<< set idUser = ""
      idUser.set("");
      //<< for {
      for (;true;) {
        //<< set idUser = $order(^WWW013(0,idUser))
        idUser.set(m$.Fnc.$order(m$.var("^WWW013",0,idUser.get())));
        //<< quit:idUser=""
        if (mOp.Equal(idUser.get(),"")) {
          break;
        }
        //<< 
        //<< do AddOption^COMCombo(idUser,$zconvert(idUser_" - "_$$$WWW013Name($get(^WWW013(0,idUser,1))),"o","JS"),blnUseArray)
        m$.Cmd.Do("COMCombo.AddOption",idUser.get(),m$.Fnc.$zconvert(mOp.Concat(mOp.Concat(idUser.get()," - "),include.WWWConst.$$$WWW013Name(m$,m$.Fnc.$get(m$.var("^WWW013",0,idUser.get(),1)))),"o","JS"),blnUseArray.get());
      }
      //<< }
      //<< do StopCombo^COMCombo(blnUseArray)
      m$.Cmd.Do("COMCombo.StopCombo",blnUseArray.get());
      //<< write "objLocation.attachEvent(""onchange"",ControlChanged);"
      m$.Cmd.Write("objLocation.attachEvent(\"onchange\",ControlChanged);");
    }
    //<< }
    //<< 
    //<< write "var formOnly = document.getElementById('formonly');"
    m$.Cmd.Write("var formOnly = document.getElementById('formonly');");
    //<< write "formOnly.checked="_$$$ToJSBoolean(blnForm)_";"
    m$.Cmd.Write(mOp.Concat(mOp.Concat("formOnly.checked=",include.COMSYSString.$$$ToJSBoolean(m$,blnForm)),";"));
    //<< write "document.getElementById('hdrctrl').style.display='block';",!
    m$.Cmd.Write("document.getElementById('hdrctrl').style.display='block';","\n");
    //<< write "document.getElementById('description').value='"_$zconvert($$$COMViewDescription(objView),"o","JS")_"';",! // SR15426
    m$.Cmd.Write(mOp.Concat(mOp.Concat("document.getElementById('description').value='",m$.Fnc.$zconvert(include.COMConst.$$$COMViewDescription(m$,objView),"o","JS")),"';"),"\n");
    //<< write "var cbLock=document.getElementById('lock');",!
    m$.Cmd.Write("var cbLock=document.getElementById('lock');","\n");
    //<< write "cbLock.checked="_$$$ToJSBoolean(+$$$COMViewLock(objView))_";",!
    m$.Cmd.Write(mOp.Concat(mOp.Concat("cbLock.checked=",include.COMSYSString.$$$ToJSBoolean(m$,mOp.Positive(include.COMConst.$$$COMViewLock(m$,objView)))),";"),"\n");
    //<< write "var selLocation=document.getElementById('ViewLocation');",!
    m$.Cmd.Write("var selLocation=document.getElementById('ViewLocation');","\n");
    //<< write "selLocation.value='"_$zconvert($$$COMViewLocation(objView),"o","JS")_"';",!
    m$.Cmd.Write(mOp.Concat(mOp.Concat("selLocation.value='",m$.Fnc.$zconvert(include.COMConst.$$$COMViewLocation(m$,objView),"o","JS")),"';"),"\n");
    //<< write "selLocation.attachEvent(""onchange"",ControlChanged);"       ; (outerHTML will be destroyed when adding options)
    m$.Cmd.Write("selLocation.attachEvent(\"onchange\",ControlChanged);");
    //<< write "var selUser=document.getElementById('user');",!
    m$.Cmd.Write("var selUser=document.getElementById('user');","\n");
    //<< write "selUser.value='"_$zconvert($$$COMViewUser1(objView),"o","JS")_"';",!
    m$.Cmd.Write(mOp.Concat(mOp.Concat("selUser.value='",m$.Fnc.$zconvert(include.COMConst.$$$COMViewUser1(m$,objView),"o","JS")),"';"),"\n");
    //<< write "selUser.attachEvent(""onchange"",ControlChanged);"           ; (outerHTML will be destroyed when adding options)
    m$.Cmd.Write("selUser.attachEvent(\"onchange\",ControlChanged);");
    //<< write "document.getElementById('distribute').checked="_$$$ToJSBoolean(+$$$COMViewDistribute(objView))_";",!
    m$.Cmd.Write(mOp.Concat(mOp.Concat("document.getElementById('distribute').checked=",include.COMSYSString.$$$ToJSBoolean(m$,mOp.Positive(include.COMConst.$$$COMViewDistribute(m$,objView)))),";"),"\n");
    //<< 
    //<< if '$$SuperUser^COMViewUtils() {
    if (mOp.Not(m$.fnc$("COMViewUtils.SuperUser"))) {
      //<< write "selUser.disabled=true;",!
      m$.Cmd.Write("selUser.disabled=true;","\n");
      //<< write:$$$DEVMODE "document.getElementById('distribute').disabled=true;",!
      if (mOp.Logical(include.COMSYS.$$$DEVMODE(m$))) {
        m$.Cmd.Write("document.getElementById('distribute').disabled=true;","\n");
      }
      //<< write "document.getElementById('lock').disabled=true;",!
      m$.Cmd.Write("document.getElementById('lock').disabled=true;","\n");
      //<< write "document.getElementById('formonly').disabled=true;"
      m$.Cmd.Write("document.getElementById('formonly').disabled=true;");
      //<< write "selLocation.disabled=true;",!
      m$.Cmd.Write("selLocation.disabled=true;","\n");
    }
    //<< }
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< CanModifyView(pidClass,pidView)
  public Object CanModifyView(Object ... _p) {
    mVar pidClass = m$.newVarRef("pidClass",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pidView = m$.newVarRef("pidView",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Does the current user have the correct privilages to modify the current view?
    //<< ;
    //<< ; History:
    //<< ; 02-Nov-2006   JW      SR15170: Simplified
    //<< ; 12-Apr-2005   Paul K  SR12608: Commented
    //<< ;-------------------------------------------------------------------------------
    //<< new objView,strStatus
    mVar objView = m$.var("objView");
    mVar strStatus = m$.var("strStatus");
    m$.newVar(objView,strStatus);
    //<< 
    //<< set strStatus = $$$OK
    strStatus.set(include.COMSYS.$$$OK(m$));
    //<< 
    //<< if pidClass="" {
    if (mOp.Equal(pidClass.get(),"")) {
      //<< set strStatus = $listbuild("Com00113")  ; "No class selected."
      strStatus.set(m$.Fnc.$listbuild("Com00113"));
    }
    //<< } elseif pidView="" {
    else if (mOp.Equal(pidView.get(),"")) {
      //<< set strStatus = $listbuild("Com00111")  ; "No favourite selected"
      strStatus.set(m$.Fnc.$listbuild("Com00111"));
    }
    //<< 
    //<< } elseif '$$SuperUser^COMViewUtils() {
    else if (mOp.Not(m$.fnc$("COMViewUtils.SuperUser"))) {
      //<< set objView = $get(^COMView(0,pidClass,pidView,1))
      objView.set(m$.Fnc.$get(m$.var("^COMView",0,pidClass.get(),pidView.get(),1)));
      //<< if $$$COMViewUser1(objView)'=YBED {
      if (mOp.NotEqual(include.COMConst.$$$COMViewUser1(m$,objView),m$.var("YBED").get())) {
        //<< set strStatus = $listbuild("Com00115",$$$COMViewDescription(objView),YBED)  ; "Favourite %1 cannot be modified by user %2."
        strStatus.set(m$.Fnc.$listbuild("Com00115",include.COMConst.$$$COMViewDescription(m$,objView),m$.var("YBED").get()));
      }
    }
    //<< }
    //<< }   ; FIXME : $$$MakeStatus() ? <GRF>
    //<< quit strStatus
    return strStatus.get();
  }

  //<< 
  //<< 
  //<< ViewChanged(pidView="")
  public Object ViewChanged(Object ... _p) {
    mVar pidView = m$.newVarRef("pidView",(((_p!=null)&&(_p.length>=1))?_p[0]:null),"");
    //<< ;-------------------------------------------------------------------------------
    //<< ; A user selected another view, refresh column header, controls and result grid.
    //<< ;
    //<< ; Called By JS: ViewChanged()
    //<< ;
    //<< ; History:
    //<< ; 21-Oct-2010   shobby  SR17540 Reload the form if CacheTemp variables have been lost.
    //<< ; 28-Jun-2007   HeberB  SRBR014579: Changing viewes, clear temp globals
    //<< ; 22-Feb-2007   SteveS  SR15440: Changing viewes, clear off the cache so it
    //<< ;                           can re-build
    //<< ; 09-Feb-2007   RPW     SR15426: Do not display the header when this is an
    //<< ;                           In-Form COMView.
    //<< ; 12-Apr-2005   Paul K  Commented
    //<< ;-------------------------------------------------------------------------------
    //<< new idClass,objViewUser
    mVar idClass = m$.var("idClass");
    mVar objViewUser = m$.var("objViewUser");
    m$.newVar(idClass,objViewUser);
    //<< 
    //<< set idClass = $get(^CacheTempView(YUSER,"Class"))
    idClass.set(m$.Fnc.$get(m$.var("^CacheTempView",m$.var("YUSER").get(),"Class")));
    //<< if idClass="" {
    if (mOp.Equal(idClass.get(),"")) {
      //<< do Recover^COMViewDisaster()        ; SR17540
      m$.Cmd.Do("COMViewDisaster.Recover");
    }
    //<< 
    //<< } else {
    else {
      //<< do ClearCache^COMViewSession()
      m$.Cmd.Do("COMViewSession.ClearCache");
      //<< 
      //<< kill ^CacheTempView(YUSER,"EditMode")
      m$.var("^CacheTempView",m$.var("YUSER").get(),"EditMode").kill();
      //<< 
      //<< set objViewUser = $get(^COMViewUser(0,idClass,YBED,1))
      objViewUser.set(m$.Fnc.$get(m$.var("^COMViewUser",0,idClass.get(),m$.var("YBED").get(),1)));
      //<< set $$$COMViewUserLastView(objViewUser) = pidView
      include.COMConst.$$$COMViewUserLastViewSet(m$,objViewUser,pidView.get());
      //<< set ^COMViewUser(0,idClass,YBED,1)      = objViewUser
      m$.var("^COMViewUser",0,idClass.get(),m$.var("YBED").get(),1).set(objViewUser.get());
      //<< 
      //<< do SetFiltersForView(idClass,pidView)
      m$.Cmd.Do("SetFiltersForView",idClass.get(),pidView.get());
      //<< do SetColumnsForView^COMViewColumn(idClass,pidView)
      m$.Cmd.Do("COMViewColumn.SetColumnsForView",idClass.get(),pidView.get());
      //<< do:'$get(^CacheTempView(YUSER,YUCI,"InForm")) DisplayHeader^COMViewFilterColumn(idClass)
      if (mOp.Not(m$.Fnc.$get(m$.var("^CacheTempView",m$.var("YUSER").get(),m$.var("YUCI").get(),"InForm")))) {
        m$.Cmd.Do("COMViewFilterColumn.DisplayHeader",idClass.get());
      }
      //<< do DisplayControls^COMViewFilterControl(idClass)
      m$.Cmd.Do("COMViewFilterControl.DisplayControls",idClass.get());
      //<< do DisplayGrid^COMViewFilter()
      m$.Cmd.Do("COMViewFilter.DisplayGrid");
      //<< do HideDisabledButtons(idClass,pidView)
      m$.Cmd.Do("HideDisabledButtons",idClass.get(),pidView.get());
    }
    //<< }
    //<< quit $$$OK
    return include.COMSYS.$$$OK(m$);
  }

  //<< 
  //<< 
  //<< HideDisabledButtons(pidClass,pidView)
  public Object HideDisabledButtons(Object ... _p) {
    mVar pidClass = m$.newVarRef("pidClass",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pidView = m$.newVarRef("pidView",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Hide buttons that a user is not permitted to use.
    //<< ;
    //<< ; Params: pidClass, pidView
    //<< ;
    //<< ; ByRefs: None
    //<< ;
    //<< ; Returns: Nothing
    //<< ;
    //<< ; History:
    //<< ; 15-May-2009   GRF     SR16474: strTrans rather than strtrans
    //<< ; 14-Nov-2007   GRF     SR15612: Location Tree buttons
    //<< ; 10-Jul-2007   GM      SRBR014577: Translation button will be hidden when
    //<< ;                           Compiler/Translator is empty.
    //<< ; 09-Feb-2007   RPW     SR15426: Do not continue if we are in form
    //<< ; 30-Jan-2006   PO      SR14249: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new objEmployee,strTrans,strValue
    mVar objEmployee = m$.var("objEmployee");
    mVar strTrans = m$.var("strTrans");
    mVar strValue = m$.var("strValue");
    m$.newVar(objEmployee,strTrans,strValue);
    //<< 
    //<< quit:$get(^CacheTempView(YUSER,YUCI,"InForm"))
    if (mOp.Logical(m$.Fnc.$get(m$.var("^CacheTempView",m$.var("YUSER").get(),m$.var("YUCI").get(),"InForm")))) {
      return null;
    }
    //<< 
    //<< if pidView = "" set pidView = $$GetCurrentView(pidClass)
    if (mOp.Equal(pidView.get(),"")) {
      pidView.set(m$.fnc$("GetCurrentView",pidClass.get()));
    }
    //<< 
    //<< $$$StartScript()
    include.COMSYS.$$$StartScript(m$);
    //<< 
    //<< if $$AllowedToCreateViews(YM,YBED) {
    if (mOp.Logical(m$.fnc$("AllowedToCreateViews",m$.var("YM").get(),m$.var("YBED").get()))) {
      //<< set strValue = ""
      strValue.set("");
    }
    //<< } else {
    else {
      //<< set strValue = "none"
      strValue.set("none");
    }
    //<< }
    //<< write "document.getElementById('newFavourite').style.display = '"_strValue_"';"
    m$.Cmd.Write(mOp.Concat(mOp.Concat("document.getElementById('newFavourite').style.display = '",strValue.get()),"';"));
    //<< 
    //<< if $$CanModifyView(pidClass,pidView) {
    if (mOp.Logical(m$.fnc$("CanModifyView",pidClass.get(),pidView.get()))) {
      //<< set strValue = ""
      strValue.set("");
    }
    //<< } else {
    else {
      //<< set strValue = "none"
      strValue.set("none");
    }
    //<< }
    //<< write "document.getElementById('openFavourite').style.display = '"_strValue_"';"
    m$.Cmd.Write(mOp.Concat(mOp.Concat("document.getElementById('openFavourite').style.display = '",strValue.get()),"';"));
    //<< write "document.getElementById('deleteFavourite').style.display = '"_strValue_"';"
    m$.Cmd.Write(mOp.Concat(mOp.Concat("document.getElementById('deleteFavourite').style.display = '",strValue.get()),"';"));
    //<< write "document.getElementById('saveFavourite').style.display = '"_strValue_"';"
    m$.Cmd.Write(mOp.Concat(mOp.Concat("document.getElementById('saveFavourite').style.display = '",strValue.get()),"';"));
    //<< 
    //<< write "document.getElementById('cvBackButton').style.display='"_$select($get(^CacheTempView(YUSER,"BackArrow"))&&($get(YBACK)'=""):"",1:"none")_"';"
    m$.Cmd.Write(mOp.Concat(mOp.Concat("document.getElementById('cvBackButton').style.display='",m$.Fnc.$select(mOp.Logical(m$.Fnc.$get(m$.var("^CacheTempView",m$.var("YUSER").get(),"BackArrow"))) && (mOp.NotEqual(m$.Fnc.$get(m$.var("YBACK")),"")),"",1,"none")),"';"));
    //<< 
    //<< ;---------------------------------------
    //<< ;  Optional Buttons
    //<< ;---------------------------------------
    //<< 
    //<< set objEmployee = $get(^WWW013(0,YBED,1))
    objEmployee.set(m$.Fnc.$get(m$.var("^WWW013",0,m$.var("YBED").get(),1)));
    //<< set strTrans    = $$$WWW013CompilerTranslator(objEmployee)
    strTrans.set(include.WWWConst.$$$WWW013CompilerTranslator(m$,objEmployee));
    //<< 
    //<< if strTrans'="" {
    if (mOp.NotEqual(strTrans.get(),"")) {
      //<< set strValue=""
      strValue.set("");
    }
    //<< } else {
    else {
      //<< set strValue="none"
      strValue.set("none");
    }
    //<< }
    //<< write "if (document.getElementById('TranslateFavourite') != null) {document.getElementById('TranslateFavourite').style.display = '"_strValue_"'};"
    m$.Cmd.Write(mOp.Concat(mOp.Concat("if (document.getElementById('TranslateFavourite') != null) {document.getElementById('TranslateFavourite').style.display = '",strValue.get()),"'};"));
    //<< 
    //<< do Display^COMViewLocnTree()
    m$.Cmd.Do("COMViewLocnTree.Display");
    //<< $$$EndScript()
    include.COMSYS.$$$EndScript(m$);
    //<< 
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< SetFiltersForView(pidClass,pidView)
  public Object SetFiltersForView(Object ... _p) {
    mVar pidClass = m$.newVarRef("pidClass",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pidView = m$.newVarRef("pidView",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Reset the filters for the current view.
    //<< ;
    //<< ; History:
    //<< ; 30-Oct-2012   shobby  SR18176: Call out to SetFixedFilters
    //<< ; 09-Sep-2008   PP      SR15866: Update COMView to Objects
    //<< ; 21-Oct-2005   JW      SR11573: use last key not first key
    //<< ; 16-Feb-2005   PO      SR11661: Set value in right filter.
    //<< ; 30-Nov-2004   Paul K  Created
    //<< ;-------------------------------------------------------------------------------
    //<< new blnIsAnObj,idFilter,idParentForm,idView,intBottom,intLastKey
    mVar blnIsAnObj = m$.var("blnIsAnObj");
    mVar idFilter = m$.var("idFilter");
    mVar idParentForm = m$.var("idParentForm");
    mVar idView = m$.var("idView");
    mVar intBottom = m$.var("intBottom");
    mVar intLastKey = m$.var("intLastKey");
    m$.newVar(blnIsAnObj,idFilter,idParentForm,idView,intBottom,intLastKey);
    //<< new lstFilters,objFilter,objView
    mVar lstFilters = m$.var("lstFilters");
    mVar objFilter = m$.var("objFilter");
    mVar objView = m$.var("objView");
    m$.newVar(lstFilters,objFilter,objView);
    //<< 
    //<< set blnIsAnObj = +$get(^CacheTempObj(YUSER,"Object"))
    blnIsAnObj.set(mOp.Positive(m$.Fnc.$get(m$.var("^CacheTempObj",m$.var("YUSER").get(),"Object"))));
    //<< set lstFilters = ""
    lstFilters.set("");
    //<< set objView    = $get(^COMView(0,pidClass,pidView,1))
    objView.set(m$.Fnc.$get(m$.var("^COMView",0,pidClass.get(),pidView.get(),1)));
    //<< 
    //<< kill ^CacheTempView(YUSER,"Filter")
    m$.var("^CacheTempView",m$.var("YUSER").get(),"Filter").kill();
    //<< 
    //<< set idParentForm = $get(^CacheTempView(YUSER,YUCI,"ParentForm"))
    idParentForm.set(m$.Fnc.$get(m$.var("^CacheTempView",m$.var("YUSER").get(),m$.var("YUCI").get(),"ParentForm")));
    //<< 
    //<< if (idParentForm="") ||
    //<< ( (idParentForm'="") && '$data(^CacheTempViewSave(YUSER,YUCI,idParentForm,"Filter")) ) {
    if ((mOp.Equal(idParentForm.get(),"")) || mOp.Logical(((mOp.NotEqual(idParentForm.get(),"")) && mOp.Not(m$.Fnc.$data(m$.var("^CacheTempViewSave",m$.var("YUSER").get(),m$.var("YUCI").get(),idParentForm.get(),"Filter")))))) {
      //<< 
      //<< if (pidClass'="") && (pidView'="") {
      if ((mOp.NotEqual(pidClass.get(),"")) && (mOp.NotEqual(pidView.get(),""))) {
        //<< set idFilter = ""
        idFilter.set("");
        //<< for {
        for (;true;) {
          //<< set idFilter = $order(^COMViewFilter(0,pidClass,pidView,idFilter))
          idFilter.set(m$.Fnc.$order(m$.var("^COMViewFilter",0,pidClass.get(),pidView.get(),idFilter.get())));
          //<< quit:idFilter=""
          if (mOp.Equal(idFilter.get(),"")) {
            break;
          }
          //<< 
          //<< set objFilter = $get(^COMViewFilter(0,pidClass,pidView,idFilter,1))
          objFilter.set(m$.Fnc.$get(m$.var("^COMViewFilter",0,pidClass.get(),pidView.get(),idFilter.get(),1)));
          //<< if $$$COMViewFilterField(objFilter)=$$$COMViewDefaultProperty(objView) { ; SR11661
          if (mOp.Equal(include.COMConst.$$$COMViewFilterField(m$,objFilter),include.COMConst.$$$COMViewDefaultProperty(m$,objView))) {
            //<< set $$$COMViewFilterValue1(objFilter) = $get(^CacheTempView(YUSER,"FilterValue"))
            include.COMConst.$$$COMViewFilterValue1Set(m$,objFilter,m$.Fnc.$get(m$.var("^CacheTempView",m$.var("YUSER").get(),"FilterValue")));
          }
          //<< }
          //<< set ^CacheTempView(YUSER,"Filter",idFilter) = objFilter
          m$.var("^CacheTempView",m$.var("YUSER").get(),"Filter",idFilter.get()).set(objFilter.get());
        }
      }
    }
    //<< 
    //<< }
    //<< }
    //<< } else {
    else {
      //<< merge ^CacheTempView(YUSER,"Filter")=^CacheTempViewSave(YUSER,YUCI,idParentForm,"Filter")
      m$.Cmd.Merge(m$.var("^CacheTempView",m$.var("YUSER").get(),"Filter"),m$.var("^CacheTempViewSave",m$.var("YUSER").get(),m$.var("YUCI").get(),idParentForm.get(),"Filter"));
    }
    //<< }
    //<< 
    //<< if (idParentForm'="") && ($data(^CacheTempViewExternal(YUSER,YUCI,idParentForm,"Filter"))) {
    if ((mOp.NotEqual(idParentForm.get(),"")) && mOp.Logical((m$.Fnc.$data(m$.var("^CacheTempViewExternal",m$.var("YUSER").get(),m$.var("YUCI").get(),idParentForm.get(),"Filter"))))) {
      //<< set intBottom = $order(^CacheTempView(YUSER,"Filter",""),-1)
      intBottom.set(m$.Fnc.$order(m$.var("^CacheTempView",m$.var("YUSER").get(),"Filter",""),mOp.Negative(1)));
      //<< set idFilter  = ""
      idFilter.set("");
      //<< for {
      for (;true;) {
        //<< set idFilter = $order(^CacheTempViewExternal(YUSER,YUCI,idParentForm,"Filter",idFilter))
        idFilter.set(m$.Fnc.$order(m$.var("^CacheTempViewExternal",m$.var("YUSER").get(),m$.var("YUCI").get(),idParentForm.get(),"Filter",idFilter.get())));
        //<< quit:idFilter=""
        if (mOp.Equal(idFilter.get(),"")) {
          break;
        }
        //<< 
        //<< set objFilter=$get(^CacheTempViewExternal(YUSER,YUCI,idParentForm,"Filter",idFilter))
        objFilter.set(m$.Fnc.$get(m$.var("^CacheTempViewExternal",m$.var("YUSER").get(),m$.var("YUCI").get(),idParentForm.get(),"Filter",idFilter.get())));
        //<< set ^CacheTempView(YUSER,"Filter",intBottom+idFilter) = objFilter
        m$.var("^CacheTempView",m$.var("YUSER").get(),"Filter",mOp.Add(intBottom.get(),idFilter.get())).set(objFilter.get());
        //<< set ^CacheTempView(YUSER,YUCI,"External",idFilter)    = intBottom+idFilter
        m$.var("^CacheTempView",m$.var("YUSER").get(),m$.var("YUCI").get(),"External",idFilter.get()).set(mOp.Add(intBottom.get(),idFilter.get()));
      }
    }
    //<< }
    //<< }
    //<< 
    //<< if '$data(^CacheTempView(YUSER,"Filter")) {
    if (mOp.Not(m$.Fnc.$data(m$.var("^CacheTempView",m$.var("YUSER").get(),"Filter")))) {
      //<< set objFilter=""
      objFilter.set("");
      //<< 
      //<< if 'blnIsAnObj {
      if (mOp.Not(blnIsAnObj.get())) {
        //<< set intLastKey = $order(^WWW002(0,pidClass,""),-1)
        intLastKey.set(m$.Fnc.$order(m$.var("^WWW002",0,pidClass.get(),""),mOp.Negative(1)));
        //<< set $$$COMViewFilterField(objFilter)      = "P"_intLastKey
        include.COMConst.$$$COMViewFilterFieldSet(m$,objFilter,mOp.Concat("P",intLastKey.get()));
        //<< set $$$COMViewFilterValue1(objFilter)     = $get(^CacheTempView(YUSER,"FilterValue"))
        include.COMConst.$$$COMViewFilterValue1Set(m$,objFilter,m$.Fnc.$get(m$.var("^CacheTempView",m$.var("YUSER").get(),"FilterValue")));
        //<< set $$$COMViewFilterComparator(objFilter) = $$$EnumCOMVIEWCOMPARATORStartsWith
        include.COMConst.$$$COMViewFilterComparatorSet(m$,objFilter,include.COMConst.$$$EnumCOMVIEWCOMPARATORStartsWith(m$));
        //<< set $$$COMViewFilterDisplay(objFilter)    = $$$YES
        include.COMConst.$$$COMViewFilterDisplaySet(m$,objFilter,include.COMSYS.$$$YES(m$));
      }
      //<< 
      //<< } else {
      else {
        //<< set $$$COMViewFilterField(objFilter)      = "ID"
        include.COMConst.$$$COMViewFilterFieldSet(m$,objFilter,"ID");
        //<< set $$$COMViewFilterValue1(objFilter)     = $get(^CacheTempView(YUSER,"FilterValue"))
        include.COMConst.$$$COMViewFilterValue1Set(m$,objFilter,m$.Fnc.$get(m$.var("^CacheTempView",m$.var("YUSER").get(),"FilterValue")));
        //<< set $$$COMViewFilterComparator(objFilter) = $$$EnumCOMVIEWCOMPARATORStartsWith
        include.COMConst.$$$COMViewFilterComparatorSet(m$,objFilter,include.COMConst.$$$EnumCOMVIEWCOMPARATORStartsWith(m$));
        //<< set $$$COMViewFilterDisplay(objFilter)    = $$$YES
        include.COMConst.$$$COMViewFilterDisplaySet(m$,objFilter,include.COMSYS.$$$YES(m$));
      }
      //<< }
      //<< set ^CacheTempView(YUSER,"Filter",1)=objFilter
      m$.var("^CacheTempView",m$.var("YUSER").get(),"Filter",1).set(objFilter.get());
    }
    //<< }
    //<< do SetFixedFilters(pidClass,$get(^CacheTempView(YUSER,"CallingForm"))) ;SR18176
    m$.Cmd.Do("SetFixedFilters",pidClass.get(),m$.Fnc.$get(m$.var("^CacheTempView",m$.var("YUSER").get(),"CallingForm")));
    //<< 
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< SetFixedFilters(YDATEI,YFORM)
  public Object SetFixedFilters(Object ... _p) {
    mVar YDATEI = m$.newVarRef("YDATEI",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar YFORM = m$.newVarRef("YFORM",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Applys any 'Fixed Filters' that should apply to all Favourites on this form.
    //<< ;
    //<< ; History:
    //<< ; 01-Nov-2012   shobby  SR18176: Check if there is a valid filter
    //<< ; 30-Oct-2012   shobby  SR18176: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new objFilters,i,objFilter,intFilter,objView,blnExists
    mVar objFilters = m$.var("objFilters");
    mVar i = m$.var("i");
    mVar objFilter = m$.var("objFilter");
    mVar intFilter = m$.var("intFilter");
    mVar objView = m$.var("objView");
    mVar blnExists = m$.var("blnExists");
    m$.newVar(objFilters,i,objFilter,intFilter,objView,blnExists);
    //<< 
    //<< if YFORM'="" {
    if (mOp.NotEqual(YFORM.get(),"")) {
      //<< ; if Form hook for this exists {
      //<< 
      //<< set objFilters=$$ExecuteHook^WWW001Hook(YDATEI,$$$EnumWWWEVENTTYPEOnAddFilter,"","",YFORM)
      objFilters.set(m$.fnc$("WWW001Hook.ExecuteHook",YDATEI.get(),include.WWWConst.$$$EnumWWWEVENTTYPEOnAddFilter(m$),"","",YFORM.get()));
      //<< if objFilters'=1 {                      ;Check if there is a filter.
      if (mOp.NotEqual(objFilters.get(),1)) {
        //<< for i=1:1:$length(objFilters,";") {
        for (i.set(1);(mOp.LessOrEqual(i.get(),m$.Fnc.$length(objFilters.get(),";")));i.set(mOp.Add(i.get(),1))) {
          //<< set blnExists=$$$NO
          blnExists.set(include.COMSYS.$$$NO(m$));
          //<< set objFilter=$piece(objFilters,";",i)
          objFilter.set(m$.Fnc.$piece(objFilters.get(),";",i.get()));
          //<< ; Look for already existing
          //<< set intFilter="" for { set intFilter=$order(^CacheTempView(YUSER,"Filter",intFilter)) quit:intFilter=""
          intFilter.set("");
          for (;true;) {
            intFilter.set(m$.Fnc.$order(m$.var("^CacheTempView",m$.var("YUSER").get(),"Filter",intFilter.get())));
            if (mOp.Equal(intFilter.get(),"")) {
              break;
            }
            //<< set objView=$get(^CacheTempView(YUSER,"Filter",intFilter))
            objView.set(m$.Fnc.$get(m$.var("^CacheTempView",m$.var("YUSER").get(),"Filter",intFilter.get())));
            //<< if objView=objFilter {
            if (mOp.Equal(objView.get(),objFilter.get())) {
              //<< set blnExists=$$$YES
              blnExists.set(include.COMSYS.$$$YES(m$));
              //<< quit
              break;
            }
          }
          //<< }
          //<< }
          //<< if 'blnExists {
          if (mOp.Not(blnExists.get())) {
            //<< set ^CacheTempView(YUSER,"Filter",$order(^CacheTempView(YUSER,"Filter",""),-1)+1)=objFilter
            m$.var("^CacheTempView",m$.var("YUSER").get(),"Filter",mOp.Add(m$.Fnc.$order(m$.var("^CacheTempView",m$.var("YUSER").get(),"Filter",""),mOp.Negative(1)),1)).set(objFilter.get());
          }
        }
      }
    }
    //<< }
    //<< }
    //<< }
    //<< }
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< SetSearchHeight(pintHeight)
  public Object SetSearchHeight(Object ... _p) {
    mVar pintHeight = m$.newVarRef("pintHeight",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Used for setting the user height for a particular 'pop-down' search
    //<< ;
    //<< ; History:
    //<< ; 21-Jan-2005   Paul K  Created
    //<< ;-------------------------------------------------------------------------------
    //<< new objViewUser,idClass
    mVar objViewUser = m$.var("objViewUser");
    mVar idClass = m$.var("idClass");
    m$.newVar(objViewUser,idClass);
    //<< 
    //<< set idClass     = $get(^CacheTempView(YUSER,"Class"))
    idClass.set(m$.Fnc.$get(m$.var("^CacheTempView",m$.var("YUSER").get(),"Class")));
    //<< set objViewUser = $get(^COMViewUser(0,idClass,YBED,1))
    objViewUser.set(m$.Fnc.$get(m$.var("^COMViewUser",0,idClass.get(),m$.var("YBED").get(),1)));
    //<< set $$$COMViewUserHeight(objViewUser) = +pintHeight
    include.COMConst.$$$COMViewUserHeightSet(m$,objViewUser,mOp.Positive(pintHeight.get()));
    //<< set ^COMViewUser(0,idClass,YBED,1)    = objViewUser         ; FIXME : $$$Save ? <GRF>
    m$.var("^COMViewUser",0,idClass.get(),m$.var("YBED").get(),1).set(objViewUser.get());
    //<< 
    //<< quit $$$OK
    return include.COMSYS.$$$OK(m$);
  }

  //<< 
  //<< 
  //<< GetSearchHeight(pidClass)
  public Object GetSearchHeight(Object ... _p) {
    mVar pidClass = m$.newVarRef("pidClass",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Used for getting the user height for a particular 'pop-down' search
    //<< ;
    //<< ; Returns: Number
    //<< ;
    //<< ; History:
    //<< ; 21-Jan-2005   Paul K  Created
    //<< ;-------------------------------------------------------------------------------
    //<< new intHeight,objViewUser
    mVar intHeight = m$.var("intHeight");
    mVar objViewUser = m$.var("objViewUser");
    m$.newVar(intHeight,objViewUser);
    //<< 
    //<< set intHeight = ""
    intHeight.set("");
    //<< 
    //<< if pidClass'="" {
    if (mOp.NotEqual(pidClass.get(),"")) {
      //<< set objViewUser = $get(^COMViewUser(0,pidClass,YBED,1))
      objViewUser.set(m$.Fnc.$get(m$.var("^COMViewUser",0,pidClass.get(),m$.var("YBED").get(),1)));
      //<< set intHeight   = $$$COMViewUserHeight(objViewUser)
      intHeight.set(include.COMConst.$$$COMViewUserHeight(m$,objViewUser));
    }
    //<< }
    //<< 
    //<< if intHeight=""  set intHeight = 400
    if (mOp.Equal(intHeight.get(),"")) {
      intHeight.set(400);
    }
    //<< if intHeight<300 set intHeight = 300
    if (mOp.Less(intHeight.get(),300)) {
      intHeight.set(300);
    }
    //<< 
    //<< quit intHeight
    return intHeight.get();
  }

  //<< 
  //<< 
  //<< SetSize(pintHeight,pintWidth)
  public Object SetSize(Object ... _p) {
    mVar pintHeight = m$.newVarRef("pintHeight",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pintWidth = m$.newVarRef("pintWidth",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Used for setting the user width and height of a 'pop-up' search
    //<< ;
    //<< ; History:
    //<< ; 03-Mar-2009   DavidR  SR16404: implemented the FIXME, could not replicate the
    //<< ;                           error but possible that the form failed because
    //<< ;                           idclass = ""
    //<< ; 21-Jan-2005   Paul K  Created
    //<< ;-------------------------------------------------------------------------------
    //<< new objViewUser,idClass
    mVar objViewUser = m$.var("objViewUser");
    mVar idClass = m$.var("idClass");
    m$.newVar(objViewUser,idClass);
    //<< 
    //<< set idClass     = $get(^CacheTempView(YUSER,"Class"))
    idClass.set(m$.Fnc.$get(m$.var("^CacheTempView",m$.var("YUSER").get(),"Class")));
    //<< if idClass'="" {
    if (mOp.NotEqual(idClass.get(),"")) {
      //<< set objViewUser = $get(^COMViewUser(0,idClass,YBED,1))
      objViewUser.set(m$.Fnc.$get(m$.var("^COMViewUser",0,idClass.get(),m$.var("YBED").get(),1)));
      //<< set $$$COMViewUserDialogHeight(objViewUser) = pintHeight
      include.COMConst.$$$COMViewUserDialogHeightSet(m$,objViewUser,pintHeight.get());
      //<< set $$$COMViewUserDialogWidth(objViewUser)  = pintWidth
      include.COMConst.$$$COMViewUserDialogWidthSet(m$,objViewUser,pintWidth.get());
      //<< set ^COMViewUser(0,idClass,YBED,1)          = objViewUser
      m$.var("^COMViewUser",0,idClass.get(),m$.var("YBED").get(),1).set(objViewUser.get());
    }
    //<< }
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< SetPostion(pintTop,pintLeft)   ; FIXME : SetPosition? requires spelling correction
  public Object SetPostion(Object ... _p) {
    mVar pintTop = m$.newVarRef("pintTop",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pintLeft = m$.newVarRef("pintLeft",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Used for setting the user top and left position 'pop-up' search
    //<< ;
    //<< ; History:
    //<< ; 21-Jan-2005   PaulK   Created
    //<< ;-------------------------------------------------------------------------------
    //<< new idClass,objViewUser
    mVar idClass = m$.var("idClass");
    mVar objViewUser = m$.var("objViewUser");
    m$.newVar(idClass,objViewUser);
    //<< 
    //<< set idClass = $get(^CacheTempView(YUSER,"Class"))
    idClass.set(m$.Fnc.$get(m$.var("^CacheTempView",m$.var("YUSER").get(),"Class")));
    //<< if idClass'="" {
    if (mOp.NotEqual(idClass.get(),"")) {
      //<< set objViewUser = $get(^COMViewUser(0,idClass,YBED,1))
      objViewUser.set(m$.Fnc.$get(m$.var("^COMViewUser",0,idClass.get(),m$.var("YBED").get(),1)));
      //<< set $$$COMViewUserDialogTop(objViewUser)  = pintTop
      include.COMConst.$$$COMViewUserDialogTopSet(m$,objViewUser,pintTop.get());
      //<< set $$$COMViewUserDialogLeft(objViewUser) = pintLeft
      include.COMConst.$$$COMViewUserDialogLeftSet(m$,objViewUser,pintLeft.get());
      //<< set ^COMViewUser(0,idClass,YBED,1)        = objViewUser
      m$.var("^COMViewUser",0,idClass.get(),m$.var("YBED").get(),1).set(objViewUser.get());
    }
    //<< }
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< GetTextForFavourite(pidClass, pidView, pobjView)
  public Object GetTextForFavourite(Object ... _p) {
    mVar pidClass = m$.newVarRef("pidClass",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pidView = m$.newVarRef("pidView",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pobjView = m$.newVarRef("pobjView",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Returns the proper text for the favourite.
    //<< ;
    //<< ; Params:
    //<< ;
    //<< ; Returns:
    //<< ;   the tanslated text for the favourite.
    //<< ;
    //<< ; History:
    //<< ; 24-Apr-2007   FrankF  SRBR014441: Translation for favourites.
    //<< ;-------------------------------------------------------------------------------
    //<< new objViewLang,strDesc
    mVar objViewLang = m$.var("objViewLang");
    mVar strDesc = m$.var("strDesc");
    m$.newVar(objViewLang,strDesc);
    //<< 
    //<< set objViewLang = $get(^COMViewLang(0, pidClass, SPRACHE, pidView, 1))
    objViewLang.set(m$.Fnc.$get(m$.var("^COMViewLang",0,pidClass.get(),m$.var("SPRACHE").get(),pidView.get(),1)));
    //<< if $$$COMViewLangDescription(objViewLang) '= "" {
    if (mOp.NotEqual(include.COMConst.$$$COMViewLangDescription(m$,objViewLang),"")) {
      //<< set strDesc = $$$JSText($$$COMViewLangDescription(objViewLang))
      strDesc.set(include.COMSYSString.$$$JSText(m$,include.COMConst.$$$COMViewLangDescription(m$,objViewLang)));
    }
    //<< 
    //<< } else {
    else {
      //<< set strDesc = $$$JSText($$$COMViewDescription(pobjView))
      strDesc.set(include.COMSYSString.$$$JSText(m$,include.COMConst.$$$COMViewDescription(m$,pobjView)));
    }
    //<< }
    //<< quit strDesc
    return strDesc.get();
  }

  //<< 
  //<< 
  //<< TranslateFavourite(pidView)
  public Object TranslateFavourite(Object ... _p) {
    mVar pidView = m$.newVarRef("pidView",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Show the form to translate the selected favourite.
    //<< ;
    //<< ; Params:
    //<< ;   pidView - the selected favourite
    //<< ;
    //<< ; History:
    //<< ; 24-Apr-2007   FrankF  SRBR014441: Translation for favourites.
    //<< ;-------------------------------------------------------------------------------
    //<< new idClass,idViewTranslation,objEmployee,objView
    mVar idClass = m$.var("idClass");
    mVar idViewTranslation = m$.var("idViewTranslation");
    mVar objEmployee = m$.var("objEmployee");
    mVar objView = m$.var("objView");
    m$.newVar(idClass,idViewTranslation,objEmployee,objView);
    //<< 
    //<< set idClass     = $get(^CacheTempView(YUSER, "Class"))
    idClass.set(m$.Fnc.$get(m$.var("^CacheTempView",m$.var("YUSER").get(),"Class")));
    //<< set objEmployee = $get(^WWW013(0, YBED, 1))
    objEmployee.set(m$.Fnc.$get(m$.var("^WWW013",0,m$.var("YBED").get(),1)));
    //<< set idViewTranslation = idClass_$$$COMMA_$$$WWW013CompilerTranslator(objEmployee)_$$$COMMA_pidView
    idViewTranslation.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(idClass.get(),include.COMSYSString.$$$COMMA(m$)),include.WWWConst.$$$WWW013CompilerTranslator(m$,objEmployee)),include.COMSYSString.$$$COMMA(m$)),pidView.get()));
    //<< 
    //<< do GoToForm^COMUtilForm("COMViewTranslation",idViewTranslation,,idViewTranslation,$$$YES)
    m$.Cmd.Do("COMUtilForm.GoToForm","COMViewTranslation",idViewTranslation.get(),null,idViewTranslation.get(),include.COMSYS.$$$YES(m$));
    //<< quit $$$OK
    return include.COMSYS.$$$OK(m$);
  }

  //<< 
  //<< 
  //<< CheckTranslationButton()
  public Object CheckTranslationButton() {
    //<< ;-------------------------------------------------------------------------------
    //<< ; Checks if the logged user is a translator.
    //<< ;
    //<< ; History:
    //<< ; 24-Apr-2007   FrankF  SRBR014441: Translation for favourites.
    //<< ;-------------------------------------------------------------------------------
    //<< new objEmployee
    mVar objEmployee = m$.var("objEmployee");
    m$.newVar(objEmployee);
    //<< 
    //<< set objEmployee = $get(^WWW013(0, YBED, 1))
    objEmployee.set(m$.Fnc.$get(m$.var("^WWW013",0,m$.var("YBED").get(),1)));
    //<< if $$$WWW013CompilerTranslator(objEmployee) '= "" {
    if (mOp.NotEqual(include.WWWConst.$$$WWW013CompilerTranslator(m$,objEmployee),"")) {
      //<< set YOPTION = 10
      mVar YOPTION = m$.var("YOPTION");
      YOPTION.set(10);
    }
    //<< }
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< ShowTranslationForm()
  public Object ShowTranslationForm() {
    //<< ;-------------------------------------------------------------------------------
    //<< ; Shows the Translation Favourite Form.
    //<< ;
    //<< ; History:
    //<< ; 24-Apr-2007   FrankF  SRBR014441: Translation for favourites.
    //<< ;-------------------------------------------------------------------------------
    //<< new idClass,idFavourite,idLanguage,idViewTranslation,objEmployee
    mVar idClass = m$.var("idClass");
    mVar idFavourite = m$.var("idFavourite");
    mVar idLanguage = m$.var("idLanguage");
    mVar idViewTranslation = m$.var("idViewTranslation");
    mVar objEmployee = m$.var("objEmployee");
    m$.newVar(idClass,idFavourite,idLanguage,idViewTranslation,objEmployee);
    //<< 
    //<< set objEmployee = $get(^WWW013(0, YBED, 1))
    objEmployee.set(m$.Fnc.$get(m$.var("^WWW013",0,m$.var("YBED").get(),1)));
    //<< set idLanguage  = $$$WWW013CompilerTranslator(objEmployee)
    idLanguage.set(include.WWWConst.$$$WWW013CompilerTranslator(m$,objEmployee));
    //<< set idClass     = $$$KEY1(YKEY)
    idClass.set(include.COMSYSWWW.$$$KEY1(m$,m$.var("YKEY")));
    //<< set idFavourite = $$$KEY2(YKEY)
    idFavourite.set(include.COMSYSWWW.$$$KEY2(m$,m$.var("YKEY")));
    //<< 
    //<< set idViewTranslation = idClass_$$$COMMA_idLanguage_$$$COMMA_idFavourite
    idViewTranslation.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(idClass.get(),include.COMSYSString.$$$COMMA(m$)),idLanguage.get()),include.COMSYSString.$$$COMMA(m$)),idFavourite.get()));
    //<< 
    //<< do GoToForm^COMUtilForm("COMViewTranslation",idViewTranslation,,idViewTranslation,$$$YES)
    m$.Cmd.Do("COMUtilForm.GoToForm","COMViewTranslation",idViewTranslation.get(),null,idViewTranslation.get(),include.COMSYS.$$$YES(m$));
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< SaveHook()
  public Object SaveHook() {
    //<< ;-------------------------------------------------------------------------------
    //<< ; Copies the base language into the 'EN' language of the tranlsation class (COMViewLang)
    //<< ;
    //<< ; History:
    //<< ; 04-May-2007   RPW     SRBR014441: Do not use early quits use status variable.
    //<< ; 24-Apr-2007   FrankF  SRBR014441: Translation for favourites.
    //<< ;-------------------------------------------------------------------------------
    //<< new idClass,idFavourite,objFavourite,objFavTranslation,strStatus
    mVar idClass = m$.var("idClass");
    mVar idFavourite = m$.var("idFavourite");
    mVar objFavourite = m$.var("objFavourite");
    mVar objFavTranslation = m$.var("objFavTranslation");
    mVar strStatus = m$.var("strStatus");
    m$.newVar(idClass,idFavourite,objFavourite,objFavTranslation,strStatus);
    //<< 
    //<< set strStatus   = $$$OK
    strStatus.set(include.COMSYS.$$$OK(m$));
    //<< set idClass     = $$$KEY1(YKEY)
    idClass.set(include.COMSYSWWW.$$$KEY1(m$,m$.var("YKEY")));
    //<< set idFavourite = $$$KEY2(YKEY)
    idFavourite.set(include.COMSYSWWW.$$$KEY2(m$,m$.var("YKEY")));
    //<< 
    //<< set objFavTranslation = $get(^COMViewLang(0,idClass,"EN",idFavourite,1))
    objFavTranslation.set(m$.Fnc.$get(m$.var("^COMViewLang",0,idClass.get(),"EN",idFavourite.get(),1)));
    //<< set objFavourite      = $get(^COMView(0,idClass,idFavourite, 1))
    objFavourite.set(m$.Fnc.$get(m$.var("^COMView",0,idClass.get(),idFavourite.get(),1)));
    //<< 
    //<< if $$$COMViewLangDescription(objFavTranslation) '= $$$COMViewDescription(objFavourite) {
    if (mOp.NotEqual(include.COMConst.$$$COMViewLangDescription(m$,objFavTranslation),include.COMConst.$$$COMViewDescription(m$,objFavourite))) {
      //<< set $$$COMViewLangDescription(objFavTranslation) = $$$COMViewDescription(objFavourite)
      include.COMConst.$$$COMViewLangDescriptionSet(m$,objFavTranslation,include.COMConst.$$$COMViewDescription(m$,objFavourite));
      //<< set strStatus = $$$Save("COMViewLang",idClass_$$$COMMA_"EN"_$$$COMMA_idFavourite,objFavTranslation,$$$YES)
      strStatus.set(include.COMSYS.$$$Save(m$,"COMViewLang",mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(idClass.get(),include.COMSYSString.$$$COMMA(m$)),"EN"),include.COMSYSString.$$$COMMA(m$)),idFavourite.get()),objFavTranslation,include.COMSYS.$$$YES(m$)));
    }
    //<< }
    //<< 
    //<< quit strStatus
    return strStatus.get();
  }

  //<< 
  //<< 
  //<< GetIdExternalFilter(pidFilter)
  public Object GetIdExternalFilter(Object ... _p) {
    mVar pidFilter = m$.newVarRef("pidFilter",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Check whether a filter is External and returns its id
    //<< ;
    //<< ; Returns:
    //<< ;   if External : id
    //<< ;   if not      : <empty>
    //<< ;
    //<< ; History:
    //<< ; 10-Jul-2007   HeberB  SRBR014579: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new idFilterExternal,strResult
    mVar idFilterExternal = m$.var("idFilterExternal");
    mVar strResult = m$.var("strResult");
    m$.newVar(idFilterExternal,strResult);
    //<< 
    //<< set strResult = ""
    strResult.set("");
    //<< set idFilterExternal = ""
    idFilterExternal.set("");
    //<< for {
    for (;true;) {
      //<< set idFilterExternal = $order(^CacheTempView(YUSER,YUCI,"External",idFilterExternal))
      idFilterExternal.set(m$.Fnc.$order(m$.var("^CacheTempView",m$.var("YUSER").get(),m$.var("YUCI").get(),"External",idFilterExternal.get())));
      //<< quit:idFilterExternal=""
      if (mOp.Equal(idFilterExternal.get(),"")) {
        break;
      }
      //<< 
      //<< if ($get(^CacheTempView(YUSER,YUCI,"External",idFilterExternal)) = pidFilter) {
      if ((mOp.Equal(m$.Fnc.$get(m$.var("^CacheTempView",m$.var("YUSER").get(),m$.var("YUCI").get(),"External",idFilterExternal.get())),pidFilter.get()))) {
        //<< set strResult = idFilterExternal
        strResult.set(idFilterExternal.get());
        //<< quit
        break;
      }
    }
    //<< }
    //<< }
    //<< quit strResult
    return strResult.get();
  }

  //<< 
  //<< 
  //<< GetCurrentSQL(pidClass="")
  public Object GetCurrentSQL(Object ... _p) {
    mVar pidClass = m$.newVarRef("pidClass",(((_p!=null)&&(_p.length>=1))?_p[0]:null),"");
    //<< ;-------------------------------------------------------------------------------
    //<< ; Finds if there is any SQL defined for a COMView
    //<< ;
    //<< ; Inputs:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 29-Jan-2008   shobby  SRBR014551: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new idView,strSQL
    mVar idView = m$.var("idView");
    mVar strSQL = m$.var("strSQL");
    m$.newVar(idView,strSQL);
    //<< 
    //<< set strSQL = ""
    strSQL.set("");
    //<< if (pidClass'="") {
    if ((mOp.NotEqual(pidClass.get(),""))) {
      //<< set idView = $$GetCurrentView^COMView(pidClass)
      idView.set(m$.fnc$("COMView.GetCurrentView",pidClass.get()));
      //<< if idView'="" {
      if (mOp.NotEqual(idView.get(),"")) {
        //<< set strSQL = $$$COMViewSQL1($get(^COMView(0,pidClass,idView,1)))
        strSQL.set(include.COMConst.$$$COMViewSQL1(m$,m$.Fnc.$get(m$.var("^COMView",0,pidClass.get(),idView.get(),1))));
      }
    }
    //<< }
    //<< }
    //<< quit strSQL
    return strSQL.get();
  }

//<< 
//<< 
}
