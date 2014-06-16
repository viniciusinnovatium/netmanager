//*****************************************************************************
//** TASC - ALPHALINC - MAC COMViewSession
//** Innovatium Systems - Code Converter - v1.30
//** 2014-06-16 12:51:13
//*****************************************************************************

import mLibrary.*;

//<< #include COMView
import include.COMView;
import include.COMSYS;
//<< #include COMConst
import include.COMConst;

//<< COMViewSession
public class COMViewSession extends mClass {

  public void main() {
    _COMViewSession();
  }

  public void _COMViewSession() {
  }

  //<< 
  //<< 
  //<< SaveCache()
  public Object SaveCache() {
    //<< ;-------------------------------------------------------------------------------
    //<< ; Save the filter cache for the current session
    //<< ;
    //<< ; Params:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 22-Feb-2007   Steve S     SR15440: Created (code moved from DisplayGrid^COMViewFilter)
    //<< ;-------------------------------------------------------------------------------
    //<< new idParentForm,idFilter,strRef
    mVar idParentForm = m$.var("idParentForm");
    mVar idFilter = m$.var("idFilter");
    mVar strRef = m$.var("strRef");
    m$.newVar(idParentForm,idFilter,strRef);
    //<< 
    //<< set idParentForm=$get(^CacheTempView(YUSER,YUCI,"ParentForm"))
    idParentForm.set(m$.Fnc.$get(m$.var("^CacheTempView",m$.var("YUSER").get(),m$.var("YUCI").get(),"ParentForm")));
    //<< 
    //<< quit:(idParentForm="")
    if ((mOp.Equal(idParentForm.get(),""))) {
      return null;
    }
    //<< 
    //<< kill ^CacheTempViewSave(YUSER,YUCI,idParentForm,"Filter")
    m$.var("^CacheTempViewSave",m$.var("YUSER").get(),m$.var("YUCI").get(),idParentForm.get(),"Filter").kill();
    //<< merge ^CacheTempViewSave(YUSER,YUCI,idParentForm,"Filter")=^CacheTempView(YUSER,"Filter")
    m$.Cmd.Merge(m$.var("^CacheTempViewSave",m$.var("YUSER").get(),m$.var("YUCI").get(),idParentForm.get(),"Filter"),m$.var("^CacheTempView",m$.var("YUSER").get(),"Filter"));
    //<< 
    //<< $$$Order4(^CacheTempView,YUSER,YUCI,"External",idFilter)
    idFilter.set("");
    for (;true;) {
      idFilter.set(m$.Fnc.$order(m$.var("^CacheTempView",m$.var("YUSER").get(),m$.var("YUCI").get(),"External",idFilter.get())));
      if (mOp.Equal(idFilter.get(),"")) {
        break;
      }
      //<< set strRef = $get(^CacheTempView(YUSER,YUCI,"External",idFilter))
      strRef.set(m$.Fnc.$get(m$.var("^CacheTempView",m$.var("YUSER").get(),m$.var("YUCI").get(),"External",idFilter.get())));
      //<< kill ^CacheTempViewSave(YUSER,YUCI,idParentForm,"Filter",strRef)
      m$.var("^CacheTempViewSave",m$.var("YUSER").get(),m$.var("YUCI").get(),idParentForm.get(),"Filter",strRef.get()).kill();
    }
    //<< $$$End
    //<< 
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< ClearCache()
  public Object ClearCache() {
    //<< ;-------------------------------------------------------------------------------
    //<< ; Clear the filter cache for the current session
    //<< ;
    //<< ; Params:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 22-Feb-2007   SteveS  SR15440: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new idParentForm
    mVar idParentForm = m$.var("idParentForm");
    m$.newVar(idParentForm);
    //<< 
    //<< set idParentForm = $get(^CacheTempView(YUSER,YUCI,"ParentForm"))
    idParentForm.set(m$.Fnc.$get(m$.var("^CacheTempView",m$.var("YUSER").get(),m$.var("YUCI").get(),"ParentForm")));
    //<< quit:(idParentForm="")
    if ((mOp.Equal(idParentForm.get(),""))) {
      return null;
    }
    //<< 
    //<< kill ^CacheTempViewSave(YUSER,YUCI,idParentForm)
    m$.var("^CacheTempViewSave",m$.var("YUSER").get(),m$.var("YUCI").get(),idParentForm.get()).kill();
    //<< 
    //<< quit
    return null;
  }

  //<< 
  //<< StoreSize(pintWidth,pintHeight)
  public Object StoreSize(Object ... _p) {
    mVar pintWidth = m$.newVarRef("pintWidth",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pintHeight = m$.newVarRef("pintHeight",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Store the changed size of the COMView for this field for this user
    //<< ;
    //<< ; Called By: PrintUnloadConfirm^WWWBODY as callback
    //<< ;
    //<< ; Inputs:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 25-Jul-2007   GRF/RPW SRBR014600: key order reversed for cleanup of obsolete users
    //<< ; 24-Jul-2007   RPW     SRBR014600: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new objViewUser,strField,strStatus
    mVar objViewUser = m$.var("objViewUser");
    mVar strField = m$.var("strField");
    mVar strStatus = m$.var("strStatus");
    m$.newVar(objViewUser,strField,strStatus);
    //<< 
    //<< set objViewUser = ""
    objViewUser.set("");
    //<< set $$$COMViewUserSizeDialogWidth(objViewUser)  = pintWidth
    include.COMConst.$$$COMViewUserSizeDialogWidthSet(m$,objViewUser,pintWidth.get());
    //<< set $$$COMViewUserSizeDialogHeight(objViewUser) = pintHeight
    include.COMConst.$$$COMViewUserSizeDialogHeightSet(m$,objViewUser,pintHeight.get());
    //<< 
    //<< set strField = $get(^CacheTempView(YUSER,"Relation"))
    strField.set(m$.Fnc.$get(m$.var("^CacheTempView",m$.var("YUSER").get(),"Relation")));
    //<< 
    //<< if strField'="" {
    if (mOp.NotEqual(strField.get(),"")) {
      //<< set strStatus = $$$Save("COMViewUserSize",YBED_$$$COMMA_strField,objViewUser,$$$YES)
      strStatus.set(include.COMSYS.$$$Save(m$,"COMViewUserSize",mOp.Concat(mOp.Concat(m$.var("YBED").get(),include.COMSYSString.$$$COMMA(m$)),strField.get()),objViewUser,include.COMSYS.$$$YES(m$)));
    }
    //<< }
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< GetSize(pstrField,pstrDummy) ; Transient data set by StoreSize?  No class so not retained.
  public Object GetSize(Object ... _p) {
    mVar pstrField = m$.newVarRef("pstrField",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pstrDummy = m$.newVarRef("pstrDummy",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Get's the size of the COMView for this field and user
    //<< ;
    //<< ; Called By: Macro "GetSizeEvent" - Start^COMViewCustom; PARASUCH^WWWFORM75
    //<< ;
    //<< ; Inputs:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 27-Jul-2007   RPW     SRBR014600: Minimum sizings
    //<< ; 25-Jul-2007   GRF/RPW SRBR014600: key order reversed for cleanup of obsolete users
    //<< ; 24-Jul-2007   RPW     SRBR014600: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new intHeight,intWidth,objSize
    mVar intHeight = m$.var("intHeight");
    mVar intWidth = m$.var("intWidth");
    mVar objSize = m$.var("objSize");
    m$.newVar(intHeight,intWidth,objSize);
    //<< 
    //<< ; DEFAULT SIZES
    //<< ; NOTE : under MSIE6 will be reduced by -27 and -8 respectively in each save cycle even if not resized
    //<< set intHeight = 530
    intHeight.set(530);
    //<< set intWidth  = 570
    intWidth.set(570);
    //<< 
    //<< if $data(^COMViewUserSize(0,YBED,pstrField)) {
    if (mOp.Logical(m$.Fnc.$data(m$.var("^COMViewUserSize",0,m$.var("YBED").get(),pstrField.get())))) {
      //<< set objSize   = $get(^COMViewUserSize(0,YBED,pstrField,1))
      objSize.set(m$.Fnc.$get(m$.var("^COMViewUserSize",0,m$.var("YBED").get(),pstrField.get(),1)));
      //<< set intHeight = $$$COMViewUserSizeDialogHeight(objSize)
      intHeight.set(include.COMConst.$$$COMViewUserSizeDialogHeight(m$,objSize));
      //<< set intWidth  = $$$COMViewUserSizeDialogWidth(objSize)
      intWidth.set(include.COMConst.$$$COMViewUserSizeDialogWidth(m$,objSize));
      //<< 
      //<< if intHeight<250 set intHeight = 250
      if (mOp.Less(intHeight.get(),250)) {
        intHeight.set(250);
      }
      //<< if intWidth<250  set intWidth  = 250
      if (mOp.Less(intWidth.get(),250)) {
        intWidth.set(250);
      }
    }
    //<< }
    //<< 
    //<< quit intHeight_Y_intWidth
    return mOp.Concat(mOp.Concat(intHeight.get(),m$.var("Y").get()),intWidth.get());
  }

//<< 
}
