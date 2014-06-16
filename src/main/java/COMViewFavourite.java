//*****************************************************************************
//** TASC - ALPHALINC - MAC COMViewFavourite
//** Innovatium Systems - Code Converter - v1.30
//** 2014-06-13 20:26:59
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
//<< #include COMView
import include.COMView;

//<< COMViewFavourite
public class COMViewFavourite extends mClass {

  public void main() {
    _COMViewFavourite();
  }

  public void _COMViewFavourite() {
  }

  //<< 
  //<< GetAvailableView(pidClass)
  public Object GetAvailableView(Object ... _p) {
    mVar pidClass = m$.newVarRef("pidClass",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Return the first available view (favourite) for searching on this class.
    //<< ;
    //<< ; Params:   pidClass    : The class id
    //<< ;
    //<< ; Returns:  idView
    //<< ;
    //<< ; History:
    //<< ; 22-May-2007   RPW     SR<place SR Number here>:
    //<< ; xx-Feb-2007   Steve S     SR15431: Use Save macro to save COMView entry
    //<< ; 20-Feb-2007   Steve S     SR15440: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new idView,arrViews,blnInForm,idViewLoop,objView,strStatus,idOldView
    mVar idView = m$.var("idView");
    mVar arrViews = m$.var("arrViews");
    mVar blnInForm = m$.var("blnInForm");
    mVar idViewLoop = m$.var("idViewLoop");
    mVar objView = m$.var("objView");
    mVar strStatus = m$.var("strStatus");
    mVar idOldView = m$.var("idOldView");
    m$.newVar(idView,arrViews,blnInForm,idViewLoop,objView,strStatus,idOldView);
    //<< 
    //<< set idView = $$GetCurrentView^COMView(pidClass)
    idView.set(m$.fnc$("COMView.GetCurrentView",pidClass.get()));
    //<< 
    //<< do GetViews(pidClass,YLOCATION,YBED,.arrViews)
    m$.Cmd.Do("GetViews",pidClass.get(),m$.var("YLOCATION").get(),m$.var("YBED").get(),arrViews);
    //<< 
    //<< if '$data(arrViews(idView)) {
    if (mOp.Not(m$.Fnc.$data(arrViews.var(idView.get())))) {
      //<< set blnInForm=$get(^CacheTempView(YUSER,YUCI,"InForm"))
      blnInForm.set(m$.Fnc.$get(m$.var("^CacheTempView",m$.var("YUSER").get(),m$.var("YUCI").get(),"InForm")));
      //<< if blnInForm {
      if (mOp.Logical(blnInForm.get())) {
        //<< set idOldView=idView
        idOldView.set(idView.get());
        //<< $$$Order1(arrViews,idViewLoop) // get first view which is 'locked'
        idViewLoop.set("");
        for (;true;) {
          idViewLoop.set(m$.Fnc.$order(arrViews.var(idViewLoop.get())));
          if (mOp.Equal(idViewLoop.get(),"")) {
            break;
          }
          //<< set objView = $get(^COMView(0,pidClass,idViewLoop,1))
          objView.set(m$.Fnc.$get(m$.var("^COMView",0,pidClass.get(),idViewLoop.get(),1)));
          //<< if $$$COMViewLock(objView) {
          if (mOp.Logical(include.COMConst.$$$COMViewLock(m$,objView))) {
            //<< set idView=idViewLoop
            idView.set(idViewLoop.get());
            //<< quit
            break;
          }
        }
        //<< }
        //<< $$$End
        //<< 
        //<< if idView=idOldView {
        if (mOp.Equal(idView.get(),idOldView.get())) {
          //<< set idView=""
          idView.set("");
        }
      }
      //<< }
      //<< 
      //<< } else { // pick up the first (default)
      else {
        //<< set idView=$order(arrViews(""))
        idView.set(m$.Fnc.$order(arrViews.var("")));
      }
    }
    //<< }
    //<< }
    //<< 
    //<< if (idView="")||'$data(^COMView(0,pidClass,idView,1)) {
    if ((mOp.Equal(idView.get(),"")) || mOp.Not(m$.Fnc.$data(m$.var("^COMView",0,pidClass.get(),idView.get(),1)))) {
      //<< // Create default view
      //<< set idView=0
      idView.set(0);
      //<< if '$data(^COMView(0,pidClass,idView,1)) {
      if (mOp.Not(m$.Fnc.$data(m$.var("^COMView",0,pidClass.get(),idView.get(),1)))) {
        //<< set objView=""
        objView.set("");
        //<< set $$$COMViewDescription(objView)=$$$Text("Com00119")   ;Default
        include.COMConst.$$$COMViewDescriptionSet(m$,objView,include.COMSYS.$$$Text(m$,"Com00119"));
        //<< set strStatus = $$$Save("COMView",pidClass_","_idView,objView,1) //SR15431
        strStatus.set(include.COMSYS.$$$Save(m$,"COMView",mOp.Concat(mOp.Concat(pidClass.get(),","),idView.get()),objView,1));
      }
    }
    //<< }
    //<< }
    //<< 
    //<< quit idView
    return idView.get();
  }

  //<< 
  //<< 
  //<< GetViews(pidClass,pidLocation,pidUser,&parrView)
  public Object GetViews(Object ... _p) {
    mVar pidClass = m$.newVarRef("pidClass",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pidLocation = m$.newVarRef("pidLocation",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pidUser = m$.newVarRef("pidUser",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    mVar parrView = m$.newVarRef("parrView",(((_p!=null)&&(_p.length>=4))?_p[3]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Loop through all the views for this class and find those that are for this
    //<< ; location and user.
    //<< ;
    //<< ; Params:       pidClass    : The class we're searching on
    //<< ;               pidLocation : Location drill-down
    //<< ;               pidUser     : User id drill-down
    //<< ;               parrView    : (By ref) Array of views
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 02-Apr-2009   shobby  SR16462: Created a default 'In form' view if none is available.
    //<< ; 26-Mar-2007   PO      NO SR: Use blnLock variable
    //<< ; 19-Feb-2007   SteveS  SR15440: Lock drill-down, moved from COMView.mac
    //<< ; 14-Feb-2007   SteveS  SR15431: Form-specific favourite support
    //<< ;                            Pass views back in an array by ref
    //<< ;                            Order macro, 'continue' instead of nested 'if'
    //<< ; 30-Nov-2004   Paul K  Created
    //<< ;-------------------------------------------------------------------------------
    //<< new idView,idUser,idLocn,objView,idViewForm,blnInForm,blnLock,strStatus
    mVar idView = m$.var("idView");
    mVar idUser = m$.var("idUser");
    mVar idLocn = m$.var("idLocn");
    mVar objView = m$.var("objView");
    mVar idViewForm = m$.var("idViewForm");
    mVar blnInForm = m$.var("blnInForm");
    mVar blnLock = m$.var("blnLock");
    mVar strStatus = m$.var("strStatus");
    m$.newVar(idView,idUser,idLocn,objView,idViewForm,blnInForm,blnLock,strStatus);
    //<< 
    //<< ; TODO: This routine seems to only be called using YLOCATION / YBED as
    //<< ;       pidLocation and pidUser. Do we need these parameters?
    //<< 
    //<< set blnInForm = $get(^CacheTempView(YUSER,YUCI,"InForm")) //SR15440
    blnInForm.set(m$.Fnc.$get(m$.var("^CacheTempView",m$.var("YUSER").get(),m$.var("YUCI").get(),"InForm")));
    //<< 
    //<< set idView = ""
    idView.set("");
    //<< for {
    for (;true;) {
      //<< set idView = $order(^COMView(0,pidClass,idView))
      idView.set(m$.Fnc.$order(m$.var("^COMView",0,pidClass.get(),idView.get())));
      //<< quit:idView=""
      if (mOp.Equal(idView.get(),"")) {
        break;
      }
      //<< 
      //<< set objView    = $get(^COMView(0,pidClass,idView,1))
      objView.set(m$.Fnc.$get(m$.var("^COMView",0,pidClass.get(),idView.get(),1)));
      //<< set idLocn     = $$$COMViewLocation(objView)
      idLocn.set(include.COMConst.$$$COMViewLocation(m$,objView));
      //<< set idUser     = $$$COMViewUser1(objView)
      idUser.set(include.COMConst.$$$COMViewUser1(m$,objView));
      //<< set idViewForm = $$$COMViewForm(objView)
      idViewForm.set(include.COMConst.$$$COMViewForm(m$,objView));
      //<< set blnLock    = +$$$COMViewLock(objView)
      blnLock.set(mOp.Positive(include.COMConst.$$$COMViewLock(m$,objView)));
      //<< 
      //<< continue:(idLocn'="")&&(pidLocation'=idLocn)               // location drill-down
      if ((mOp.NotEqual(idLocn.get(),"")) && (mOp.NotEqual(pidLocation.get(),idLocn.get()))) {
        continue;
      }
      //<< continue:(idUser'="")&&(idUser'=pidUser)                   // user drill-down
      if ((mOp.NotEqual(idUser.get(),"")) && (mOp.NotEqual(idUser.get(),pidUser.get()))) {
        continue;
      }
      //<< continue:(idViewForm'="")&&(idViewForm'=$$$CallingForm)    // Form drill-down   //SR15431
      if ((mOp.NotEqual(idViewForm.get(),"")) && (mOp.NotEqual(idViewForm.get(),include.COMView.$$$CallingForm(m$)))) {
        continue;
      }
      //<< continue:blnInForm&&'blnLock                               // Lock drill-down SR15440   PO Changed
      if (mOp.Logical(blnInForm.get()) && mOp.Not(blnLock.get())) {
        continue;
      }
      //<< 
      //<< set parrView(idView)="" // SR15431
      parrView.var(idView.get()).set("");
    }
    //<< }
    //<< 
    //<< if blnInForm && '$data(parrView) {        ;16462
    if (mOp.Logical(blnInForm.get()) && mOp.Not(m$.Fnc.$data(parrView))) {
      //<< set idView  = $$^WWWNEXT("COMView")
      idView.set(m$.fnc$("WWWNEXT.main","COMView"));
      //<< set objView = ""
      objView.set("");
      //<< set $$$COMViewDescription(objView) = $$$Text("Com00322")   ;In form default
      include.COMConst.$$$COMViewDescriptionSet(m$,objView,include.COMSYS.$$$Text(m$,"Com00322"));
      //<< set $$$COMViewLock(objView)        = $$$YES
      include.COMConst.$$$COMViewLockSet(m$,objView,include.COMSYS.$$$YES(m$));
      //<< set strStatus = $$$Save("COMView",pidClass_","_idView,objView,$$$YES) //SR15431
      strStatus.set(include.COMSYS.$$$Save(m$,"COMView",mOp.Concat(mOp.Concat(pidClass.get(),","),idView.get()),objView,include.COMSYS.$$$YES(m$)));
      //<< set parrView(idView) = ""
      parrView.var(idView.get()).set("");
    }
    //<< }
    //<< 
    //<< quit
    return null;
  }

//<< 
}
