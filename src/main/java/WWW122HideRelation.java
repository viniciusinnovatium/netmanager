//*****************************************************************************
//** TASC - ALPHALINC - MAC WWW122HideRelation
//** Innovatium Systems - Code Converter - v1.28
//** 2014-05-26 21:13:10
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

//<< WWW122HideRelation
public class WWW122HideRelation extends mClass {

  public void main() {
    _WWW122HideRelation();
  }

  public void _WWW122HideRelation() {
  }

  //<< 
  //<< HideRelationClassIDs(pYFORM,pidFormField)
  public Object HideRelationClassIDs(Object ... _p) {
    mVar pYFORM = m$.newVarRef("pYFORM",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pidFormField = m$.newVarRef("pidFormField",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Check HideRelationClassIDs in WWW012 and WWW122.
    //<< ;
    //<< ; ByRef:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 28-Oct-2008   GRF     SRBR014894: Boolean Macros
    //<< ; 29-Nov-2007   GM      SRBR014805: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new blnHide,blnWWW012Hide,blnWWW122Hide,objWWW122
    mVar blnHide = m$.var("blnHide");
    mVar blnWWW012Hide = m$.var("blnWWW012Hide");
    mVar blnWWW122Hide = m$.var("blnWWW122Hide");
    mVar objWWW122 = m$.var("objWWW122");
    m$.newVar(blnHide,blnWWW012Hide,blnWWW122Hide,objWWW122);
    //<< 
    //<< set blnHide = $$$NO
    blnHide.set(include.COMSYS.$$$NO(m$));
    //<< 
    //<< set blnWWW012Hide = $$$WWW012HideRelationClassIDs($get(^WWW012(0,YM,1)))
    blnWWW012Hide.set(include.WWWConst.$$$WWW012HideRelationClassIDs(m$,m$.Fnc.$get(m$.var("^WWW012",0,m$.var("YM").get(),1))));
    //<< set objWWW122     = $$Get^WWW122(pYFORM,pidFormField)                       ; merge WWW122 and WWW122D
    objWWW122.set(m$.fnc$("WWW122.Get",pYFORM.get(),pidFormField.get()));
    //<< set blnWWW122Hide = $$$WWW122HideRelationClassIDs(objWWW122)
    blnWWW122Hide.set(include.WWWConst.$$$WWW122HideRelationClassIDs(m$,objWWW122));
    //<< 
    //<< if (blnWWW122Hide = $$$YES)                          ||
    //<< ((blnWWW122Hide = "") && (blnWWW012Hide = $$$YES))    {
    if ((mOp.Equal(blnWWW122Hide.get(),include.COMSYS.$$$YES(m$))) || mOp.Logical(((mOp.Equal(blnWWW122Hide.get(),"")) && (mOp.Equal(blnWWW012Hide.get(),include.COMSYS.$$$YES(m$)))))) {
      //<< set blnHide = $$$YES
      blnHide.set(include.COMSYS.$$$YES(m$));
    }
    //<< }
    //<< quit blnHide
    return blnHide.get();
  }

//<< 
//<< 
//<< 
}
