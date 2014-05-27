//*****************************************************************************
//** TASC - ALPHALINC - MAC COMGridEdit31R
//** Innovatium Systems - Code Converter - v1.27
//** 2014-05-22 00:15:25
//*****************************************************************************

import mLibrary.*;

//<< #include WWWConst
import include.WWWConst;
import include.COMSYS;
//<< #include COMGridEdit31
import include.COMGridEdit31;
//<< #include COMConst
import include.COMConst;

public class COMGridEdit31R extends mClass {

  //<< 
  //<< COMGridEdit31R(YINHALT,YLFDAT)
  public Object main(Object ... _p) {
    mVar YINHALT = m$.newVarRef("YINHALT",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar YLFDAT = m$.newVarRef("YLFDAT",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    return _COMGridEdit31R(YINHALT,YLFDAT);
  }

  public Object _COMGridEdit31R(Object ... _p) {
    mVar YINHALT = m$.newVarRef("YINHALT",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar YLFDAT = m$.newVarRef("YLFDAT",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; History:
    //<< ; 21-Jul-2009   shobby  SR16730: New button for popup properties.
    //<< ; 03-Jun-2008   GRF     SR15739: Revisions to Duplicate moved to new routine.
    //<< ; 25-Feb-2008   shobby  SRBR014446: Add "EXPORTTOEXCEL"
    //<< ;-------------------------------------------------------------------------------
    //<< new YRETVAL
    mVar YRETVAL = m$.var("YRETVAL");
    m$.newVar(YRETVAL);
    //<< ;if $g(YBED)="GRF" quit $$newCOMGridEdit31R($g(YINHALT),$g(YLFDAT))
    //<< set YRETVAL = ""
    YRETVAL.set("");
    //<< if $get(YLFDAT)="" set YLFDAT = ""
    if (mOp.Equal(m$.Fnc.$get(YLFDAT),"")) {
      YLFDAT.set("");
    }
    //<< if YINHALT="SETFOCUS"            {  set YRETVAL = $$SETFOCUS(YLFDAT)
    if (mOp.Equal(YINHALT.get(),"SETFOCUS")) {
      YRETVAL.set(m$.fnc$("SETFOCUS",YLFDAT.get()));
    }
    //<< } elseif YINHALT="REORDERLAYOUT" {  set YRETVAL = $$REORDERLAYOUT(YLFDAT)
    else if (mOp.Equal(YINHALT.get(),"REORDERLAYOUT")) {
      YRETVAL.set(m$.fnc$("REORDERLAYOUT",YLFDAT.get()));
    }
    //<< } elseif YINHALT="TEST"          {  set YRETVAL = $$TEST(YLFDAT)
    else if (mOp.Equal(YINHALT.get(),"TEST")) {
      YRETVAL.set(m$.fnc$("TEST",YLFDAT.get()));
    }
    //<< } elseif YINHALT="VALIDATE"      {  set YRETVAL = $$VALIDATE(YLFDAT)
    else if (mOp.Equal(YINHALT.get(),"VALIDATE")) {
      YRETVAL.set(m$.fnc$("VALIDATE",YLFDAT.get()));
    }
    //<< } elseif YINHALT="WWWDATEN"      {  set YRETVAL = $$WWWDATEN(YLFDAT)
    else if (mOp.Equal(YINHALT.get(),"WWWDATEN")) {
      YRETVAL.set(m$.fnc$("WWWDATEN",YLFDAT.get()));
    }
    //<< } elseif YINHALT="BODYADDROWS"   {  set YRETVAL = $$BODYADDROWS(YLFDAT)
    else if (mOp.Equal(YINHALT.get(),"BODYADDROWS")) {
      YRETVAL.set(m$.fnc$("BODYADDROWS",YLFDAT.get()));
    }
    //<< } elseif YINHALT="PERPAGE"       {  set YRETVAL = $$PERPAGE(YLFDAT)
    else if (mOp.Equal(YINHALT.get(),"PERPAGE")) {
      YRETVAL.set(m$.fnc$("PERPAGE",YLFDAT.get()));
    }
    //<< } elseif YINHALT="SEARCHDATA"    {  set YRETVAL = $$SEARCHDATA()
    else if (mOp.Equal(YINHALT.get(),"SEARCHDATA")) {
      YRETVAL.set(m$.fnc$("SEARCHDATA"));
    }
    //<< ;} elseif YINHALT="COPY"         {  set YRETVAL = $$Duplicate^COMGridEdit31Add()    //SR14221 ; SR15739
    //<< } elseif YINHALT="COPY"          {  set YRETVAL = $$Duplicate^COMGridEdit31Copy()
    else if (mOp.Equal(YINHALT.get(),"COPY")) {
      YRETVAL.set(m$.fnc$("COMGridEdit31Copy.Duplicate"));
    }
    //<< } elseif YINHALT="EXPORTTOEXCEL" {  set YRETVAL = $$ExportToExcel^COMGridEdit31Excel()  ;BR014446
    else if (mOp.Equal(YINHALT.get(),"EXPORTTOEXCEL")) {
      YRETVAL.set(m$.fnc$("COMGridEdit31Excel.ExportToExcel"));
    }
    //<< } elseif YINHALT="POPUP"         {  set YRETVAL = $$Create^COMGridEdit31ExtraFields(YFORM,YBED,YLFDAT,$$$YES)   ;SR16730
    else if (mOp.Equal(YINHALT.get(),"POPUP")) {
      YRETVAL.set(m$.fnc$("COMGridEdit31ExtraFields.Create",m$.var("YFORM").get(),m$.var("YBED").get(),YLFDAT.get(),include.COMSYS.$$$YES(m$)));
    }
    //<< } elseif YINHALT="ALIGN"         {  set YRETVAL = $$ALIGN(YLFDAT)
    else if (mOp.Equal(YINHALT.get(),"ALIGN")) {
      YRETVAL.set(m$.fnc$("ALIGN",YLFDAT.get()));
    }
    //<< }
    //<< quit YRETVAL
    return YRETVAL.get();
  }

  //<< 
  //<< 
  //<< ALIGN(YLFDAT)
  public Object ALIGN(Object ... _p) {
    mVar YLFDAT = m$.newVarRef("YLFDAT",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Aligns the width of the columns in the expanded lines to those of the primary lines.
    //<< ;
    //<< ; Inputs:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 26-Mar-2012   shobby      SR17724: Created
    //<< ;-------------------------------------------------------------------------------
    //<< ;SR17724 Created
    //<< new idForm,idField,strStatus,objCOMGridEditLayout,idLayout
    mVar idForm = m$.var("idForm");
    mVar idField = m$.var("idField");
    mVar strStatus = m$.var("strStatus");
    mVar objCOMGridEditLayout = m$.var("objCOMGridEditLayout");
    mVar idLayout = m$.var("idLayout");
    m$.newVar(idForm,idField,strStatus,objCOMGridEditLayout,idLayout);
    //<< 
    //<< set idForm=$get(^WWWDATEN(YM,+$h,YUSER,YFORM,"V","LINKS"))
    idForm.set(m$.Fnc.$get(m$.var("^WWWDATEN",m$.var("YM").get(),mOp.Positive(m$.Fnc.$horolog()),m$.var("YUSER").get(),m$.var("YFORM").get(),"V","LINKS")));
    //<< if idForm'="" {
    if (mOp.NotEqual(idForm.get(),"")) {
      //<< set idField="" for { set idField=$order(^COMGridEditLayout(YM,YBED,idForm,idField)) quit:idField=""
      idField.set("");
      for (;true;) {
        idField.set(m$.Fnc.$order(m$.var("^COMGridEditLayout",m$.var("YM").get(),m$.var("YBED").get(),idForm.get(),idField.get())));
        if (mOp.Equal(idField.get(),"")) {
          break;
        }
        //<< set strStatus=$$KILL^COMUtils("COMGridEditLayout",YBED_","_idForm_","_idField)
        strStatus.set(m$.fnc$("COMUtils.KILL","COMGridEditLayout",mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(m$.var("YBED").get(),","),idForm.get()),","),idField.get())));
      }
      //<< }
      //<< 
      //<< set idField="" for { set idField=$order(^COMGridEditLayout(YM,YBED,YFORM,idField)) quit:idField=""
      idField.set("");
      for (;true;) {
        idField.set(m$.Fnc.$order(m$.var("^COMGridEditLayout",m$.var("YM").get(),m$.var("YBED").get(),m$.var("YFORM").get(),idField.get())));
        if (mOp.Equal(idField.get(),"")) {
          break;
        }
        //<< set objCOMGridEditLayout=$get(^COMGridEditLayout(YM,YBED,YFORM,idField,1))
        objCOMGridEditLayout.set(m$.Fnc.$get(m$.var("^COMGridEditLayout",m$.var("YM").get(),m$.var("YBED").get(),m$.var("YFORM").get(),idField.get(),1)));
        //<< set $$$COMGridEditLayoutWidth(objCOMGridEditLayout)=$$$COMGridEditLayoutWidth(objCOMGridEditLayout)
        include.COMConst.$$$COMGridEditLayoutWidthSet(m$,objCOMGridEditLayout,include.COMConst.$$$COMGridEditLayoutWidth(m$,objCOMGridEditLayout));
        //<< if $extract(idField)="P" {
        if (mOp.Equal(m$.Fnc.$extract(idField.get()),"P")) {
          //<< set idLayout=YBED_","_idForm_",P"_$order(^WWW121(0,idForm,""),-1)
          idLayout.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(m$.var("YBED").get(),","),idForm.get()),",P"),m$.Fnc.$order(m$.var("^WWW121",0,idForm.get(),""),mOp.Negative(1))));
        }
        //<< } else {
        else {
          //<< set idLayout=YBED_","_idForm_","_idField
          idLayout.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(m$.var("YBED").get(),","),idForm.get()),","),idField.get()));
        }
        //<< }
        //<< set strStatus=$$Save^COMUtils("COMGridEditLayout",idLayout,objCOMGridEditLayout,$$$YES)
        strStatus.set(m$.fnc$("COMUtils.Save","COMGridEditLayout",idLayout.get(),objCOMGridEditLayout.get(),include.COMSYS.$$$YES(m$)));
      }
    }
    //<< }
    //<< }
    //<< quit $$$YES
    return include.COMSYS.$$$YES(m$);
  }

  //<< 
  //<< newCOMGridEdit31R(pstrEventVal,YLFDAT)    ; see SR16533 <GRF> Test Fix for BODYADDROWS issue - not enabled yet
  public Object newCOMGridEdit31R(Object ... _p) {
    mVar pstrEventVal = m$.newVarRef("pstrEventVal",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar YLFDAT = m$.newVarRef("YLFDAT",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; History:
    //<< ; 03-Jun-2008   GRF     SR15739: Revisions to Duplicate moved to new routine.
    //<< ; 25-Feb-2008   shobby  SRBR014446: Add "EXPORTTOEXCEL"
    //<< ;-------------------------------------------------------------------------------
    //<< new YRETVAL,YINHALT
    mVar YRETVAL = m$.var("YRETVAL");
    mVar YINHALT = m$.var("YINHALT");
    m$.newVar(YRETVAL,YINHALT);
    //<< 
    //<< set YRETVAL = ""
    YRETVAL.set("");
    //<< if $get(YLFDAT)="" set YLFDAT = ""
    if (mOp.Equal(m$.Fnc.$get(YLFDAT),"")) {
      YLFDAT.set("");
    }
    //<< if pstrEventVal="SETFOCUS"            {  set YRETVAL = $$SETFOCUS(YLFDAT)
    if (mOp.Equal(pstrEventVal.get(),"SETFOCUS")) {
      YRETVAL.set(m$.fnc$("SETFOCUS",YLFDAT.get()));
    }
    //<< } elseif pstrEventVal="REORDERLAYOUT" {  set YRETVAL = $$REORDERLAYOUT(YLFDAT)
    else if (mOp.Equal(pstrEventVal.get(),"REORDERLAYOUT")) {
      YRETVAL.set(m$.fnc$("REORDERLAYOUT",YLFDAT.get()));
    }
    //<< } elseif pstrEventVal="TEST"          {  set YRETVAL = $$TEST(YLFDAT)
    else if (mOp.Equal(pstrEventVal.get(),"TEST")) {
      YRETVAL.set(m$.fnc$("TEST",YLFDAT.get()));
    }
    //<< } elseif pstrEventVal="VALIDATE"      {  set YRETVAL = $$VALIDATE(YLFDAT)
    else if (mOp.Equal(pstrEventVal.get(),"VALIDATE")) {
      YRETVAL.set(m$.fnc$("VALIDATE",YLFDAT.get()));
    }
    //<< } elseif pstrEventVal="WWWDATEN"      {  set YRETVAL = $$WWWDATEN(YLFDAT)
    else if (mOp.Equal(pstrEventVal.get(),"WWWDATEN")) {
      YRETVAL.set(m$.fnc$("WWWDATEN",YLFDAT.get()));
    }
    //<< } elseif pstrEventVal="BODYADDROWS"   {  set YRETVAL = $$BODYADDROWS(YLFDAT)
    else if (mOp.Equal(pstrEventVal.get(),"BODYADDROWS")) {
      YRETVAL.set(m$.fnc$("BODYADDROWS",YLFDAT.get()));
    }
    //<< } elseif pstrEventVal="PERPAGE"       {  set YRETVAL = $$PERPAGE(YLFDAT)
    else if (mOp.Equal(pstrEventVal.get(),"PERPAGE")) {
      YRETVAL.set(m$.fnc$("PERPAGE",YLFDAT.get()));
    }
    //<< } elseif pstrEventVal="SEARCHDATA"    {  set YRETVAL = $$SEARCHDATA()
    else if (mOp.Equal(pstrEventVal.get(),"SEARCHDATA")) {
      YRETVAL.set(m$.fnc$("SEARCHDATA"));
    }
    //<< ;} elseif pstrEventVal="COPY"         {  set YRETVAL = $$Duplicate^COMGridEdit31Add()   //SR14221 ; SR15739
    //<< } elseif pstrEventVal="COPY"          {  set YRETVAL = $$Duplicate^COMGridEdit31Copy()
    else if (mOp.Equal(pstrEventVal.get(),"COPY")) {
      YRETVAL.set(m$.fnc$("COMGridEdit31Copy.Duplicate"));
    }
    //<< } elseif pstrEventVal="EXPORTTOEXCEL" {  set YRETVAL = $$ExportToExcel^COMGridEdit31Excel() ;BR014446
    else if (mOp.Equal(pstrEventVal.get(),"EXPORTTOEXCEL")) {
      YRETVAL.set(m$.fnc$("COMGridEdit31Excel.ExportToExcel"));
    }
    //<< }
    //<< 
    //<< quit YRETVAL
    return YRETVAL.get();
  }

  //<< /*
  //<< ADDLINE(pYLFDAT="")         // Currently not in use.
  //<< ;-------------------------------------------------------------------------------
  //<< ; Adds an expanded line to the grid
  //<< ;
  //<< ; Returns:
  //<< ;
  //<< ; History:
  //<< ; 24-Aug-2005   shobby  SR11983:Parameter to mark that this is for an expanded line.
  //<< ; 06-Apr-2005   shobby  Created SR:SR11983
  //<< ;-------------------------------------------------------------------------------
  //<< new YFORM,YKEY,YFELD,ROW,PARENT
  //<< 
  //<< set YFORM=$piece(pYLFDAT,";",1)
  //<< set YKEY=$piece(pYLFDAT,";",2)
  //<< set ROW=$piece($piece(pYLFDAT,";",3),"_",1)
  //<< set PARENT=$piece(pYLFDAT,";",4)
  //<< set YFELD=$piece(pYLFDAT,";",5,9999)
  //<< 
  //<< ;do AddLine^COMGridEdit31(YFELD,YKEY,YFORM,$$$NO,ROW)
  //<< do AddLine^COMGridEdit31Add(YFELD,YKEY,YFORM,$$$NO,PARENT)
  //<< quit ""
  //<< 
  //<< 
  //<< BODYADDROWS(pYLFDAT="")
  //<< new strRETVAL,blnContinue,YROW,YSUCH,intLimit
  //<< 
  //<< set blnContinue = $piece(pYLFDAT,Y,1)
  //<< set YROW        = $piece(pYLFDAT,Y,2)
  //<< set YSUCH       = $piece(pYLFDAT,Y,3)
  //<< set intLimit    = $piece(pYLFDAT,Y,4)
  //<< set strRETVAL   = $$BODYADDROWS^COMGridEdit31Body(blnContinue,.YROW,.YSUCH,YROW+10)
  //<< quit strRETVAL
  //<< */
  //<< 
  //<< BODYADDROWS(pYLFDAT="")
  public Object BODYADDROWS(Object ... _p) {
    mVar pYLFDAT = m$.newVarRef("pYLFDAT",(((_p!=null)&&(_p.length>=1))?_p[0]:null),"");
    //<< ;-------------------------------------------------------------------------------
    //<< ; History:
    //<< ; 19-Oct-2005   JW      SR11573: Rewritten
    //<< ;-------------------------------------------------------------------------------
    //<< new blnContinue,intPage,strRETVAL
    mVar blnContinue = m$.var("blnContinue");
    mVar intPage = m$.var("intPage");
    mVar strRETVAL = m$.var("strRETVAL");
    m$.newVar(blnContinue,intPage,strRETVAL);
    //<< 
    //<< set intPage     = $piece(pYLFDAT,Y,1)
    intPage.set(m$.Fnc.$piece(pYLFDAT.get(),m$.var("Y").get(),1));
    //<< set blnContinue = $piece(pYLFDAT,Y,2)
    blnContinue.set(m$.Fnc.$piece(pYLFDAT.get(),m$.var("Y").get(),2));
    //<< 
    //<< set strRETVAL = $$BODYADDROWS^COMGridEdit31Body(intPage,blnContinue)
    strRETVAL.set(m$.fnc$("COMGridEdit31Body.BODYADDROWS",intPage.get(),blnContinue.get()));
    //<< quit strRETVAL
    return strRETVAL.get();
  }

  //<< 
  //<< 
  //<< PERPAGE(pintPerPage="")
  public Object PERPAGE(Object ... _p) {
    mVar pintPerPage = m$.newVarRef("pintPerPage",(((_p!=null)&&(_p.length>=1))?_p[0]:null),"");
    //<< ;-------------------------------------------------------------------------------
    //<< ; Change the number per page
    //<< ;
    //<< ; Params:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 30-Oct-2008   SCR     SR16026: Use Get Rows Per Page function instead of Macro
    //<< ; 14-May-2008   shobby  SRBR014943:GRIDPerPage (use $get)
    //<< ; 20-Oct-2005   JW      SR11573: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new blnOk,intPrev
    mVar blnOk = m$.var("blnOk");
    mVar intPrev = m$.var("intPrev");
    m$.newVar(blnOk,intPrev);
    //<< 
    //<< set intPrev = $$GetRowsPerPage^COMGridEdit31(YBED,YFORM)
    intPrev.set(m$.fnc$("COMGridEdit31.GetRowsPerPage",m$.var("YBED").get(),m$.var("YFORM").get()));
    //<< if (pintPerPage > 0) && (pintPerPage '= intPrev ) && (pintPerPage\1 = pintPerPage) {
    if ((mOp.Greater(pintPerPage.get(),0)) && (mOp.NotEqual(pintPerPage.get(),intPrev.get())) && (mOp.Equal(mOp.IntegerDivide(pintPerPage.get(),1),pintPerPage.get()))) {
      //<< do GetRowsPerPage^COMGridEdit31(YBED,YFORM,pintPerPage)
      m$.Cmd.Do("COMGridEdit31.GetRowsPerPage",m$.var("YBED").get(),m$.var("YFORM").get(),pintPerPage.get());
      //<< set blnOk = $$$YES_Y_$$$GRIDNumPages
      blnOk.set(mOp.Concat(mOp.Concat(include.COMSYS.$$$YES(m$),m$.var("Y").get()),include.COMGridEdit31.$$$GRIDNumPages(m$)));
    }
    //<< 
    //<< } else {
    else {
      //<< set blnOk = $$$NO_Y_intPrev
      blnOk.set(mOp.Concat(mOp.Concat(include.COMSYS.$$$NO(m$),m$.var("Y").get()),intPrev.get()));
    }
    //<< }
    //<< quit blnOk
    return blnOk.get();
  }

  //<< 
  //<< 
  //<< REORDERLAYOUT(pYLFDAT)
  public Object REORDERLAYOUT(Object ... _p) {
    mVar pYLFDAT = m$.newVarRef("pYLFDAT",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Reorders the order of displayed columns
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 15-Mar-2012   shobby  SR17724.29: Fixed problem when dragging from the scroll area
    //<< ;                           in to the first column of the fixed area.
    //<< ; 13-Apr-2010   GRF     -: loop rather than idx; idForm rather than strForm
    //<< ;                           (confusion with strFrom)
    //<< ; 15-Dec-2005   RPW/PO  SR13940: Ordering of the columns is now inverted.
    //<< ; 12-Sep-2005   JW      SR13099: Store changes in WWW122D not WWW122.
    //<< ; 26-Jun-2005   shobby  Removed the cached column order so that the new order is
    //<< ;                           used when creating new lines.
    //<< ; 07-Feb-2004   shobby  Improved positioning when multiple rows have same value.
    //<< ; 29-Dec-2004   Shobby  SR10061: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new idField,idForm,intFrom,intTo,loop,strOrder,objField,objFieldOld,strFrom,strStatus,strTo
    mVar idField = m$.var("idField");
    mVar idForm = m$.var("idForm");
    mVar intFrom = m$.var("intFrom");
    mVar intTo = m$.var("intTo");
    mVar loop = m$.var("loop");
    mVar strOrder = m$.var("strOrder");
    mVar objField = m$.var("objField");
    mVar objFieldOld = m$.var("objFieldOld");
    mVar strFrom = m$.var("strFrom");
    mVar strStatus = m$.var("strStatus");
    mVar strTo = m$.var("strTo");
    m$.newVar(idField,idForm,intFrom,intTo,loop,strOrder,objField,objFieldOld,strFrom,strStatus,strTo);
    //<< 
    //<< set idForm  = $get(^CacheTemp(YUSER,"Grid","Name"))
    idForm.set(m$.Fnc.$get(m$.var("^CacheTemp",m$.var("YUSER").get(),"Grid","Name")));
    //<< 
    //<< set intFrom = $piece($piece(pYLFDAT,";",1),"_",3)   ; FIXME : intFrom/intTo are not integers
    intFrom.set(m$.Fnc.$piece(m$.Fnc.$piece(pYLFDAT.get(),";",1),"_",3));
    //<< set intTo   = $piece($piece(pYLFDAT,";",2),"_",3)
    intTo.set(m$.Fnc.$piece(m$.Fnc.$piece(pYLFDAT.get(),";",2),"_",3));
    //<< 
    //<< set idForm=YFORM ; SR17724.29
    idForm.set(m$.var("YFORM").get());
    //<< if $piece(pYLFDAT,";",3)'="" {
    if (mOp.NotEqual(m$.Fnc.$piece(pYLFDAT.get(),";",3),"")) {
      //<< do setFixedColumns^COMGridEdit31V2(idForm,$piece($piece(pYLFDAT,";",3),",",2)) ;SR17724.29
      m$.Cmd.Do("COMGridEdit31V2.setFixedColumns",idForm.get(),m$.Fnc.$piece(m$.Fnc.$piece(pYLFDAT.get(),";",3),",",2));
    }
    //<< }
    //<< 
    //<< set strFrom = $$$COMMA_intFrom_$$$COMMA
    strFrom.set(mOp.Concat(mOp.Concat(include.COMSYSString.$$$COMMA(m$),intFrom.get()),include.COMSYSString.$$$COMMA(m$)));
    //<< set strTo   = $$$COMMA_intTo_$$$COMMA
    strTo.set(mOp.Concat(mOp.Concat(include.COMSYSString.$$$COMMA(m$),intTo.get()),include.COMSYSString.$$$COMMA(m$)));
    //<< 
    //<< set strOrder = $$$COMMA_$$GetColumnOrder^COMGridEdit31Body(idForm)_$$$COMMA
    strOrder.set(mOp.Concat(mOp.Concat(include.COMSYSString.$$$COMMA(m$),m$.fnc$("COMGridEdit31Body.GetColumnOrder",idForm.get())),include.COMSYSString.$$$COMMA(m$)));
    //<< set strOrder = $piece(strOrder,strFrom,1)_$$$COMMA_$piece(strOrder,strFrom,2)           // Remove column
    strOrder.set(mOp.Concat(mOp.Concat(m$.Fnc.$piece(strOrder.get(),strFrom.get(),1),include.COMSYSString.$$$COMMA(m$)),m$.Fnc.$piece(strOrder.get(),strFrom.get(),2)));
    //<< if intTo="" {
    if (mOp.Equal(intTo.get(),"")) {
      //<< ;At the start 17724.29
      //<< set strOrder=$$$COMMA_$piece(strFrom,$$$COMMA,2)_strOrder
      strOrder.set(mOp.Concat(mOp.Concat(include.COMSYSString.$$$COMMA(m$),m$.Fnc.$piece(strFrom.get(),include.COMSYSString.$$$COMMA(m$),2)),strOrder.get()));
    }
    //<< } else {
    else {
      //<< set strOrder = $piece(strOrder,strTo,1)_$$$COMMA_intTo_strFrom_$piece(strOrder,strTo,2) // Re-add
      strOrder.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(m$.Fnc.$piece(strOrder.get(),strTo.get(),1),include.COMSYSString.$$$COMMA(m$)),intTo.get()),strFrom.get()),m$.Fnc.$piece(strOrder.get(),strTo.get(),2)));
    }
    //<< }
    //<< set $extract(strOrder) = ""                     // Remove end commas
    mVar $extract = m$.var("$extract");
    $extract.var(strOrder.get()).set("");
    //<< set $extract(strOrder,$length(strOrder)) = ""
    $extract.var(strOrder.get(),m$.Fnc.$length(strOrder.get())).set("");
    //<< 
    //<< for loop=1:1:$length(strOrder,$$$COMMA) {
    for (loop.set(1);(mOp.LessOrEqual(loop.get(),m$.Fnc.$length(strOrder.get(),include.COMSYSString.$$$COMMA(m$))));loop.set(mOp.Add(loop.get(),1))) {
      //<< set idField = $piece(strOrder,$$$COMMA,loop)
      idField.set(m$.Fnc.$piece(strOrder.get(),include.COMSYSString.$$$COMMA(m$),loop.get()));
      //<< 
      //<< set objField    = $get(^WWW122D(0,idForm,idField,YM,1))
      objField.set(m$.Fnc.$get(m$.var("^WWW122D",0,idForm.get(),idField.get(),m$.var("YM").get(),1)));
      //<< set objFieldOld = objField
      objFieldOld.set(objField.get());
      //<< 
      //<< set $$$WWW122DDisplayOnPage(objField)     = 1
      include.WWWConst.$$$WWW122DDisplayOnPageSet(m$,objField,1);
      //<< set $$$WWW122DLinePosition(objField)      = loop
      include.WWWConst.$$$WWW122DLinePositionSet(m$,objField,loop.get());
      //<< set $$$WWW122DTabulatorPosition(objField) = 1
      include.WWWConst.$$$WWW122DTabulatorPositionSet(m$,objField,1);
      //<< 
      //<< if objFieldOld'=objField {
      if (mOp.NotEqual(objFieldOld.get(),objField.get())) {
        //<< set strStatus = $$$Save("WWW122D",idForm_","_idField_","_YM,objField,$$$YES)
        strStatus.set(include.COMSYS.$$$Save(m$,"WWW122D",mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(idForm.get(),","),idField.get()),","),m$.var("YM").get()),objField,include.COMSYS.$$$YES(m$)));
      }
    }
    //<< }
    //<< }
    //<< set ^CacheTemp(YUSER,"Grid",YFORM,"COLUMNORDER")=strOrder ;SR12743
    m$.var("^CacheTemp",m$.var("YUSER").get(),"Grid",m$.var("YFORM").get(),"COLUMNORDER").set(strOrder.get());
    //<< 
    //<< quit $$$OK
    return include.COMSYS.$$$OK(m$);
  }

  //<< 
  //<< 
  //<< VALIDATE(pstrInput)
  public Object VALIDATE(Object ... _p) {
    mVar pstrInput = m$.newVarRef("pstrInput",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Validates the integrity of the contents of the grid that are about to be saved.
    //<< ;
    //<< ; Returns:  error message if any, otherwise ""
    //<< ;
    //<< ; History:
    //<< ; 11-Mar-2009   HQN     AdHoc: Pass full parameter list explicitly use idForm
    //<< ; 27-Jun-2006   JW      SR13755: Return message not status.
    //<< ; 26-Jun-2006   JW      SR12775: Pass YFELD to Validate
    //<< ; 30-Sep-2005   JW      SR11573: Just pass in line, not field
    //<< ; 14-Apr-2005   Paul K  SR12136: Pass through 1 to run grid's OnBeforeSave code
    //<< ; 28-Feb-2005   JW      Check objdisc for data
    //<< ; 31-Jan-2004   shobby  Code Check.
    //<< ; 23-Nov-2004   Shobby  Created (SR10468)
    //<< ;-------------------------------------------------------------------------------
    //<< new strForm,idKey,strStatus,objMemory,objOrig,idLine,strKey,strMessage
    mVar strForm = m$.var("strForm");
    mVar idKey = m$.var("idKey");
    mVar strStatus = m$.var("strStatus");
    mVar objMemory = m$.var("objMemory");
    mVar objOrig = m$.var("objOrig");
    mVar idLine = m$.var("idLine");
    mVar strKey = m$.var("strKey");
    mVar strMessage = m$.var("strMessage");
    m$.newVar(strForm,idKey,strStatus,objMemory,objOrig,idLine,strKey,strMessage);
    //<< 
    //<< set strStatus  = $$$OK
    strStatus.set(include.COMSYS.$$$OK(m$));
    //<< set strMessage = ""
    strMessage.set("");
    //<< 
    //<< set strForm = $get(^CacheTemp(YUSER,"Grid","Name"))
    strForm.set(m$.Fnc.$get(m$.var("^CacheTemp",m$.var("YUSER").get(),"Grid","Name")));
    //<< if strForm'="" {
    if (mOp.NotEqual(strForm.get(),"")) {
      //<< set idKey = ""
      idKey.set("");
      //<< for {
      for (;true;) {
        //<< set idKey = $order(^WWWDATEN(YM,+$horolog,YUSER,strForm,"V","REFERENCEKEY",idKey))
        idKey.set(m$.Fnc.$order(m$.var("^WWWDATEN",m$.var("YM").get(),mOp.Positive(m$.Fnc.$horolog()),m$.var("YUSER").get(),strForm.get(),"V","REFERENCEKEY",idKey.get())));
        //<< quit:idKey=""
        if (mOp.Equal(idKey.get(),"")) {
          break;
        }
        //<< 
        //<< if '$$$KilledRecord(idKey,strForm) {
        if (mOp.Not(include.COMGridEdit31.$$$KilledRecord(m$,idKey,strForm))) {
          //<< set strKey    = $get(^WWWDATEN(YM,+$horolog,YUSER,strForm,"V","REFERENCEKEY",idKey,1))
          strKey.set(m$.Fnc.$get(m$.var("^WWWDATEN",m$.var("YM").get(),mOp.Positive(m$.Fnc.$horolog()),m$.var("YUSER").get(),strForm.get(),"V","REFERENCEKEY",idKey.get(),1)));
          //<< set idLine    = $$$KEY2(strKey)
          idLine.set(include.COMSYSWWW.$$$KEY2(m$,strKey));
          //<< set objMemory = $$GetYFELD^COMGridEdit31G(strForm,idKey,$$$YES,.objOrig)
          objMemory.set(m$.fnc$("COMGridEdit31G.GetYFELD",strForm.get(),idKey.get(),include.COMSYS.$$$YES(m$),objOrig));
          //<< 
          //<< if '$data(objOrig) || (objMemory'=objOrig) {
          if (mOp.Not(m$.Fnc.$data(objOrig)) || (mOp.NotEqual(objMemory.get(),objOrig.get()))) {
            //<< set strStatus = $$Validate^COMGridEdit31Save("Y"_idKey,objMemory,$$$YES,strForm)
            strStatus.set(m$.fnc$("COMGridEdit31Save.Validate",mOp.Concat("Y",idKey.get()),objMemory.get(),include.COMSYS.$$$YES(m$),strForm.get()));
          }
        }
        //<< }
        //<< }
        //<< if $$$ISERR(strStatus) {
        if (mOp.Logical(include.COMSYS.$$$ISERR(m$,strStatus))) {
          //<< set strMessage = $$$Text(strStatus)     ; Decode status
          strMessage.set(include.COMSYS.$$$Text(m$,strStatus));
          //<< quit
          break;
        }
      }
    }
    //<< }
    //<< }
    //<< }
    //<< quit strMessage
    return strMessage.get();
  }

  //<< 
  //<< 
  //<< DELETE()
  public Object DELETE(Object ... _p) {
    //<< ;-------------------------------------------------------------------------------
    //<< ; Delete ^CacheTemp Grid data, so grid will be remade on next display.
    //<< ; Called from OnAfterDelete procedure of parent form.
    //<< ;
    //<< ; Note: only necessary when grid is displayed on a page other than the first.
    //<< ;
    //<< ; Returns: nil
    //<< ;
    //<< ; History:
    //<< ; 19-Jul-2005   RPW     SR12981: Moved CleanupPreviousInstance to COMGridEdit31Tools
    //<< ; 06-Jan-2005   PO & JW SR11425 Created
    //<< ;-------------------------------------------------------------------------------
    //<< do CleanUpPreviousInstance^COMGridEdit31Tools($$$GRIDName)
    m$.Cmd.Do("COMGridEdit31Tools.CleanUpPreviousInstance",include.COMGridEdit31Interface.$$$GRIDName(m$));
    //<< 
    //<< kill ^CacheTemp(YUSER,"Grid")
    m$.var("^CacheTemp",m$.var("YUSER").get(),"Grid").kill();
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< SETFOCUS(YLFDAT)
  public Object SETFOCUS(Object ... _p) {
    mVar YLFDAT = m$.newVarRef("YLFDAT",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Changes the active grid on the shared form.
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 15-Oct-2004   shared  Created
    //<< ;-------------------------------------------------------------------------------
    //<< new YRETVAL
    mVar YRETVAL = m$.var("YRETVAL");
    m$.newVar(YRETVAL);
    //<< 
    //<< set YRETVAL=""
    YRETVAL.set("");
    //<< if $get(YLFDAT)="" {
    if (mOp.Equal(m$.Fnc.$get(YLFDAT),"")) {
      //<< kill ^CacheTemp(YUSER,"Grid","ActiveGrid")
      m$.var("^CacheTemp",m$.var("YUSER").get(),"Grid","ActiveGrid").kill();
    }
    //<< } else {
    else {
      //<< set ^CacheTemp(YUSER,"Grid","ActiveGrid")=YLFDAT
      m$.var("^CacheTemp",m$.var("YUSER").get(),"Grid","ActiveGrid").set(YLFDAT.get());
    }
    //<< }
    //<< quit YRETVAL
    return YRETVAL.get();
  }

  //<< 
  //<< 
  //<< WWWDATEN(YLFDAT)
  public Object WWWDATEN(Object ... _p) {
    mVar YLFDAT = m$.newVarRef("YLFDAT",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 07-Apr-2005   shobby  SR10549: Passed Column number into the WWWDATEN routine.
    //<< ;                           Required because Form Column does not always match
    //<< ;                           Class Column.
    //<< ;-------------------------------------------------------------------------------
    //<< new YFORM,YART,YLFN,YROW,YBBN
    mVar YFORM = m$.var("YFORM");
    mVar YART = m$.var("YART");
    mVar YLFN = m$.var("YLFN");
    mVar YROW = m$.var("YROW");
    mVar YBBN = m$.var("YBBN");
    m$.newVar(YFORM,YART,YLFN,YROW,YBBN);
    //<< 
    //<< set YFORM = $piece(YLFDAT,Y,1)
    YFORM.set(m$.Fnc.$piece(YLFDAT.get(),m$.var("Y").get(),1));
    //<< set YART  = $piece(YLFDAT,Y,2)
    YART.set(m$.Fnc.$piece(YLFDAT.get(),m$.var("Y").get(),2));
    //<< set YLFN  = $piece(YLFDAT,Y,3)
    YLFN.set(m$.Fnc.$piece(YLFDAT.get(),m$.var("Y").get(),3));
    //<< set YROW  = $piece(YLFDAT,Y,4)
    YROW.set(m$.Fnc.$piece(YLFDAT.get(),m$.var("Y").get(),4));
    //<< set YBBN  = $piece(YLFDAT,Y,5)
    YBBN.set(m$.Fnc.$piece(YLFDAT.get(),m$.var("Y").get(),5));
    //<< set $piece(^WWWDATEN(YM,+$horolog,YUSER,YFORM,YART,1),Y,YLFN) = $get(^WWWDATEN(YM,+$horolog,YUSER,YFORM,"V","Y"_YROW_"_"_YBBN,1))
    m$.pieceVar(m$.var("^WWWDATEN",m$.var("YM").get(),mOp.Positive(m$.Fnc.$horolog()),m$.var("YUSER").get(),YFORM.get(),YART.get(),1),m$.var("Y").get(),YLFN.get()).set(m$.Fnc.$get(m$.var("^WWWDATEN",m$.var("YM").get(),mOp.Positive(m$.Fnc.$horolog()),m$.var("YUSER").get(),YFORM.get(),"V",mOp.Concat(mOp.Concat(mOp.Concat("Y",YROW.get()),"_"),YBBN.get()),1)));
    //<< 
    //<< quit $$$YES
    return include.COMSYS.$$$YES(m$);
  }

  //<< 
  //<< 
  //<< HideShowRows(pintCol,blnChecked=$$$YES,pblnShow="",pblnRefresh=$$$YES,pstrValue,pblnEquals=$$$YES,pblnKill=$$$YES)
  public Object HideShowRows(Object ... _p) {
    mVar pintCol = m$.newVarRef("pintCol",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar blnChecked = m$.newVarRef("blnChecked",(((_p!=null)&&(_p.length>=2))?_p[1]:null),include.COMSYS.$$$YES(m$));
    mVar pblnShow = m$.newVarRef("pblnShow",(((_p!=null)&&(_p.length>=3))?_p[2]:null),"");
    mVar pblnRefresh = m$.newVarRef("pblnRefresh",(((_p!=null)&&(_p.length>=4))?_p[3]:null),include.COMSYS.$$$YES(m$));
    mVar pstrValue = m$.newVarRef("pstrValue",(((_p!=null)&&(_p.length>=5))?_p[4]:null));
    mVar pblnEquals = m$.newVarRef("pblnEquals",(((_p!=null)&&(_p.length>=6))?_p[5]:null),include.COMSYS.$$$YES(m$));
    mVar pblnKill = m$.newVarRef("pblnKill",(((_p!=null)&&(_p.length>=7))?_p[6]:null),include.COMSYS.$$$YES(m$));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Hide selected rows based on whether a field is checked
    //<< ;
    //<< ; Inputs:
    //<< ;   pblnShow        Set to $$$YES to display the line
    //<< ;                          $$$NO  to hide the line
    //<< ;                          ""     to toggle between hide and show
    //<< ;
    //<< ;   Process removes current HIDDEN line Status for ***ALL*** lines and then
    //<< ;   rebuild the HIDDEN values based on the instruction given.
    //<< ;
    //<< ;   Test if a particular field (pintCol) is either equal to or not equal to
    //<< ;   (pblnEquals) a particular value (pstrValue).
    //<< ;
    //<< ;   If we need to check for $$$YES (1) and $$$NO (0 or null) we set blnChecked
    //<< ;   and do not pass ANYTHING - even NULL in as pstrValue.
    //<< ;   This allows us to check for an actual null in a field when we set pstrValue to null.
    //<< ;
    //<< ;   pblnRefresh=$$$YES  Return to the current/first? grid page - check
    //<< ;
    //<< ;   pblnKill : If there are multiple conditions to be considered, set to $$$YES
    //<< ;              for the first condition and then $$$NO for subsequent conditions.
    //<< ;              Any matches are added to the list of hidden entries; a hidden
    //<< ;              entry will not be "shown" by a subsequent condition.
    //<< ;
    //<< ; ByRef: YUSER,YFORM
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 13-Oct-2010   shobby  SR17541: Add pblnKill - optionally kill HIDDEN, we may
    //<< ;                           want multiple conditions.
    //<< ; 22-Feb-2006   Steve S SR14149: Compare with any value, not just checkbox
    //<< ; 25-Jan-2005   JW      SR13087: Check for killed records
    //<< ; 14-Oct-2005   JW      SR11573: Rewrote to be Cache not JS (moved from *S)
    //<< ; 09-Mar-2005   JW      Created
    //<< ;-------------------------------------------------------------------------------
    //<< new WWWDATEN,blnShow,idRow,intCount,blnMatch
    mVar WWWDATEN = m$.var("WWWDATEN");
    mVar blnShow = m$.var("blnShow");
    mVar idRow = m$.var("idRow");
    mVar intCount = m$.var("intCount");
    mVar blnMatch = m$.var("blnMatch");
    m$.newVar(WWWDATEN,blnShow,idRow,intCount,blnMatch);
    //<< 
    //<< quit:$get(pintCol)=""
    if (mOp.Equal(m$.Fnc.$get(pintCol),"")) {
      return null;
    }
    //<< 
    //<< if pblnShow="" {
    if (mOp.Equal(pblnShow.get(),"")) {
      //<< set pblnShow = $data($$$WWWDATEN("HIDDEN"))
      pblnShow.set(m$.Fnc.$data(COMGridEdit31Events.$$$WWWDATENVar(m$,"HIDDEN")));
    }
    //<< }
    //<< if pblnKill kill $$$WWWDATEN("HIDDEN")
    if (mOp.Logical(pblnKill.get())) {
      m$.var("$$$WWWDATEN").var("HIDDEN").kill();
    }
    //<< if 'pblnShow {
    if (mOp.Not(pblnShow.get())) {
      //<< set intCount = 0
      intCount.set(0);
      //<< set idRow=""
      idRow.set("");
      //<< for {
      for (;true;) {
        //<< set idRow = $order($$$WWWDATEN("REFERENCEKEY",idRow))
        idRow.set(m$.Fnc.$order(COMGridEdit31Events.$$$WWWDATENVar(m$,"REFERENCEKEY",idRow)));
        //<< quit:idRow=""
        if (mOp.Equal(idRow.get(),"")) {
          break;
        }
        //<< continue:$$$KilledRecord(idRow,YFORM)
        if (mOp.Logical(include.COMGridEdit31.$$$KilledRecord(m$,idRow,m$.var("YFORM")))) {
          continue;
        }
        //<< 
        //<< if '$data(pstrValue) {
        if (mOp.Not(m$.Fnc.$data(pstrValue))) {
          //<< if pblnEquals {
          if (mOp.Logical(pblnEquals.get())) {
            //<< set blnMatch = (+$get($$$WWWDATEN("Y"_idRow_"_"_pintCol,1)) = blnChecked)
            blnMatch.set((mOp.Equal(mOp.Positive(m$.Fnc.$get(COMGridEdit31Events.$$$WWWDATENVar(m$,mOp.Concat(mOp.Concat(mOp.Concat("Y",idRow.get()),"_"),pintCol.get()),1))),blnChecked.get())));
          }
          //<< } else {
          else {
            //<< set blnMatch = (+$get($$$WWWDATEN("Y"_idRow_"_"_pintCol,1)) '= blnChecked)
            blnMatch.set((mOp.NotEqual(mOp.Positive(m$.Fnc.$get(COMGridEdit31Events.$$$WWWDATENVar(m$,mOp.Concat(mOp.Concat(mOp.Concat("Y",idRow.get()),"_"),pintCol.get()),1))),blnChecked.get())));
          }
        }
        //<< }
        //<< 
        //<< } else {
        else {
          //<< if pblnEquals {
          if (mOp.Logical(pblnEquals.get())) {
            //<< set blnMatch = ($get($$$WWWDATEN("Y"_idRow_"_"_pintCol,1)) = pstrValue)
            blnMatch.set((mOp.Equal(m$.Fnc.$get(COMGridEdit31Events.$$$WWWDATENVar(m$,mOp.Concat(mOp.Concat(mOp.Concat("Y",idRow.get()),"_"),pintCol.get()),1)),pstrValue.get())));
          }
          //<< } else {
          else {
            //<< set blnMatch = ($get($$$WWWDATEN("Y"_idRow_"_"_pintCol,1)) '= pstrValue)
            blnMatch.set((mOp.NotEqual(m$.Fnc.$get(COMGridEdit31Events.$$$WWWDATENVar(m$,mOp.Concat(mOp.Concat(mOp.Concat("Y",idRow.get()),"_"),pintCol.get()),1)),pstrValue.get())));
          }
        }
        //<< }
        //<< }
        //<< 
        //<< if blnMatch {
        if (mOp.Logical(blnMatch.get())) {
          //<< set WWWDATEN(idRow) = $$$YES
          WWWDATEN.var(idRow.get()).set(include.COMSYS.$$$YES(m$));
          //<< set intCount = intCount + 1
          intCount.set(mOp.Add(intCount.get(),1));
        }
      }
      //<< }
      //<< }
      //<< 
      //<< set WWWDATEN = intCount
      WWWDATEN.set(intCount.get());
      //<< merge $$$WWWDATEN("HIDDEN") = WWWDATEN
      mVar $$$WWWDATEN = m$.var("$$$WWWDATEN");
      m$.Cmd.Merge($$$WWWDATEN.var("HIDDEN"),WWWDATEN);
    }
    //<< }
    //<< 
    //<< if pblnRefresh write YCR,$$$GRIDGoToPage(1,$$$GRIDNumPages,"T",$$$NO)
    if (mOp.Logical(pblnRefresh.get())) {
      m$.Cmd.Write(m$.var("YCR").get(),include.COMGridEdit31.$$$GRIDGoToPage(m$,1,include.COMGridEdit31.$$$GRIDNumPages(m$),"T",include.COMSYS.$$$NO(m$)));
    }
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< ShowAllRows()
  public Object ShowAllRows(Object ... _p) {
    //<< ;-------------------------------------------------------------------------------
    //<< ; Undoes any hidden rows from HideShowRows
    //<< ;
    //<< ; Params:
    //<< ;
    //<< ; ByRefs:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 22-Feb-2006   Steve S SR14110: Created
    //<< ;-------------------------------------------------------------------------------
    //<< kill $$$WWWDATEN("HIDDEN")
    m$.var("$$$WWWDATEN").var("HIDDEN").kill();
    //<< write YCR,$$$GRIDGoToPage(1,$$$GRIDNumPages,"T",$$$NO)
    m$.Cmd.Write(m$.var("YCR").get(),include.COMGridEdit31.$$$GRIDGoToPage(m$,1,include.COMGridEdit31.$$$GRIDNumPages(m$),"T",include.COMSYS.$$$NO(m$)));
    //<< 
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< ;-------------------------------------------------------------------------------
  //<< ; Examples: (Ignoring form name)
  //<< ;
  //<< ;   (12,$$$YES)             Hide column 12
  //<< ;
  //<< ;   ("1;2;3","0;1;1")       Show column 1, hide columns 2 and 3
  //<< ;
  //<< ;   ("1;2;3")               Hide columns 1, 2 & 3
  //<< ;
  //<< ;   ("1;2;3","1;0")         Show column 1, explicitly hide column 2 and hide
  //<< ;                           column 3 because that was the last hide/show option
  //<< ;                           specified.
  //<< ;-------------------------------------------------------------------------------
  //<< HideShowColumns(pstrCols="",pstrHideSwitches="",pstrForm="")
  public Object HideShowColumns(Object ... _p) {
    mVar pstrCols = m$.newVarRef("pstrCols",(((_p!=null)&&(_p.length>=1))?_p[0]:null),"");
    mVar pstrHideSwitches = m$.newVarRef("pstrHideSwitches",(((_p!=null)&&(_p.length>=2))?_p[1]:null),"");
    mVar pstrForm = m$.newVarRef("pstrForm",(((_p!=null)&&(_p.length>=3))?_p[2]:null),"");
    //<< ;-------------------------------------------------------------------------------
    //<< ; Hide / Show columns dynamically.
    //<< ;
    //<< ; Params:   pstrCols         - semicolon-delimited list of form column ids
    //<< ;           pstrHideSwitches - semicolon-delimited list of whether to
    //<< ;                              hide=$$YES, or show=$$$NO
    //<< ;                              [other values will be treated as $$$NO]
    //<< ;
    //<< ;   Note:   If an element of strHideSwitches is "", it will default to the previous
    //<< ;           element. First element defaults to $$$YES.
    //<< ;           e.g. If all elements need to be hidden, just pass in "".
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 15-Jul-2010   CB/GRF  SR17403: Synchronise Grid Widths
    //<< ; 17-Jun-2009   GRF     Doco; clarify variable name (pstrHideSwitches); prefixes
    //<< ; 14-Oct-2005   JW      SR11573: moved from *S
    //<< ; 16-Mar-2005   JW      Changed 2nd parameter to a list
    //<< ; 10-Mar-2005   JW      SR11848: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new blnHide,idCol,intCols,loop
    mVar blnHide = m$.var("blnHide");
    mVar idCol = m$.var("idCol");
    mVar intCols = m$.var("intCols");
    mVar loop = m$.var("loop");
    m$.newVar(blnHide,idCol,intCols,loop);
    //<< 
    //<< quit:$get(pstrCols)=""
    if (mOp.Equal(m$.Fnc.$get(pstrCols),"")) {
      return null;
    }
    //<< quit:'$$GridExists^COMGridEdit31G()
    if (mOp.Not(m$.fnc$("COMGridEdit31G.GridExists"))) {
      return null;
    }
    //<< 
    //<< if $get(pstrForm)="" set pstrForm = $$$GRIDName
    if (mOp.Equal(m$.Fnc.$get(pstrForm),"")) {
      pstrForm.set(include.COMGridEdit31Interface.$$$GRIDName(m$));
    }
    //<< set blnHide = $$$YES
    blnHide.set(include.COMSYS.$$$YES(m$));
    //<< 
    //<< set intCols = $length(pstrCols,$$$SEMICOLON)
    intCols.set(m$.Fnc.$length(pstrCols.get(),include.COMSYSString.$$$SEMICOLON(m$)));
    //<< for loop=1:1:intCols {
    for (loop.set(1);(mOp.LessOrEqual(loop.get(),intCols.get()));loop.set(mOp.Add(loop.get(),1))) {
      //<< set idCol = $piece(pstrCols,$$$SEMICOLON,loop)
      idCol.set(m$.Fnc.$piece(pstrCols.get(),include.COMSYSString.$$$SEMICOLON(m$),loop.get()));
      //<< if $piece(pstrHideSwitches,$$$SEMICOLON,loop)'="" {
      if (mOp.NotEqual(m$.Fnc.$piece(pstrHideSwitches.get(),include.COMSYSString.$$$SEMICOLON(m$),loop.get()),"")) {
        //<< set blnHide = $piece(pstrHideSwitches,$$$SEMICOLON,loop)
        blnHide.set(m$.Fnc.$piece(pstrHideSwitches.get(),include.COMSYSString.$$$SEMICOLON(m$),loop.get()));
      }
      //<< }
      //<< write " hideShowColumn("_idCol_",("_blnHide_"==1),'"_pstrForm_"');"
      m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(" hideShowColumn(",idCol.get()),",("),blnHide.get()),"==1),'"),pstrForm.get()),"');"));
    }
    //<< }
    //<< write " syncGridWidths();" ; SR17403
    m$.Cmd.Write(" syncGridWidths();");
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< SEARCHDATA()
  public Object SEARCHDATA(Object ... _p) {
    //<< ;-------------------------------------------------------------------------------
    //<< ; Search invoices
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 26-Mar-2007   PO      -: New idFilter,objFilter
    //<< ; 04-May-2006   JW      SR14508: Changed YDATEI to YFORM
    //<< ; 08-Jun-2005   JW/RW   Created SR12484
    //<< ;-------------------------------------------------------------------------------
    //<< new blnGroup,blnNoConversion,idComparitor,idx,idField,idFilter,idKey
    mVar blnGroup = m$.var("blnGroup");
    mVar blnNoConversion = m$.var("blnNoConversion");
    mVar idComparitor = m$.var("idComparitor");
    mVar idx = m$.var("idx");
    mVar idField = m$.var("idField");
    mVar idFilter = m$.var("idFilter");
    mVar idKey = m$.var("idKey");
    m$.newVar(blnGroup,blnNoConversion,idComparitor,idx,idField,idFilter,idKey);
    //<< new loop,objFilter,strKey,strValue,YDATEI,YFORM
    mVar loop = m$.var("loop");
    mVar objFilter = m$.var("objFilter");
    mVar strKey = m$.var("strKey");
    mVar strValue = m$.var("strValue");
    mVar YDATEI = m$.var("YDATEI");
    mVar YFORM = m$.var("YFORM");
    m$.newVar(loop,objFilter,strKey,strValue,YDATEI,YFORM);
    //<< 
    //<< set strKey = $$GetYKEY^COMGridEdit31G()
    strKey.set(m$.fnc$("COMGridEdit31G.GetYKEY"));
    //<< set YFORM = $$$GRIDName
    YFORM.set(include.COMGridEdit31Interface.$$$GRIDName(m$));
    //<< 
    //<< do Initialise^COMViewCustom(YFORM,"RecordSelected^COMGridEdit31R")
    m$.Cmd.Do("COMViewCustom.Initialise",YFORM.get(),"RecordSelected^COMGridEdit31R");
    //<< if strKey="" {
    if (mOp.Equal(strKey.get(),"")) {
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
        //<< 
        //<< set idField         = $$$COMViewFilterField(objFilter)
        idField.set(include.COMConst.$$$COMViewFilterField(m$,objFilter));
        //<< set strValue        = $$$COMViewFilterValue1(objFilter)
        strValue.set(include.COMConst.$$$COMViewFilterValue1(m$,objFilter));
        //<< set idComparitor    = $$$COMViewFilterComparator(objFilter)
        idComparitor.set(include.COMConst.$$$COMViewFilterComparator(m$,objFilter));
        //<< set blnGroup        = $$$COMViewFilterGroupBy(objFilter)
        blnGroup.set(include.COMConst.$$$COMViewFilterGroupBy(m$,objFilter));
        //<< set blnNoConversion = $$$COMViewFilterNoconversion(objFilter)
        blnNoConversion.set(include.COMConst.$$$COMViewFilterNoconversion(m$,objFilter));
        //<< 
        //<< do AddFilter^COMViewCustom(idField,idComparitor,strValue,blnGroup,blnNoConversion)
        m$.Cmd.Do("COMViewCustom.AddFilter",idField.get(),idComparitor.get(),strValue.get(),blnGroup.get(),blnNoConversion.get());
      }
    }
    //<< }
    //<< 
    //<< } else {
    else {
      //<< set idKey = ""
      idKey.set("");
      //<< for loop=1:1:$length(strKey,",") {
      for (loop.set(1);(mOp.LessOrEqual(loop.get(),m$.Fnc.$length(strKey.get(),",")));loop.set(mOp.Add(loop.get(),1))) {
        //<< set idKey = $piece(strKey,",",loop)
        idKey.set(m$.Fnc.$piece(strKey.get(),",",loop.get()));
        //<< do AddFilter^COMViewCustom("P"_loop,"=",idKey)
        m$.Cmd.Do("COMViewCustom.AddFilter",mOp.Concat("P",loop.get()),"=",idKey.get());
      }
    }
    //<< }
    //<< }
    //<< do Start^COMViewCustom()
    m$.Cmd.Do("COMViewCustom.Start");
    //<< quit ""
    return "";
  }

  //<< 
  //<< 
  //<< RecordSelected(pobjResultSet)
  public Object RecordSelected(Object ... _p) {
    mVar pobjResultSet = m$.newVarRef("pobjResultSet",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Go to (first) record selected
    //<< ;
    //<< ; Params:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 13-Feb-2007   RPW     SR15426: Get the correct YUSER
    //<< ; 21-Oct-2005   JW      SR11573: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new blnUpdate,idKey,idRow,idUser,intPage,parentKey,strKey,YFORM
    mVar blnUpdate = m$.var("blnUpdate");
    mVar idKey = m$.var("idKey");
    mVar idRow = m$.var("idRow");
    mVar idUser = m$.var("idUser");
    mVar intPage = m$.var("intPage");
    mVar parentKey = m$.var("parentKey");
    mVar strKey = m$.var("strKey");
    mVar YFORM = m$.var("YFORM");
    m$.newVar(blnUpdate,idKey,idRow,idUser,intPage,parentKey,strKey,YFORM);
    //<< 
    //<< if pobjResultSet.Next() {
    if (mOp.Logical(m$.fnc$(m$.var("pobjResultSet").getORef(),"Next"))) {
      //<< set strKey=$$GetID^COMViewCustom(pobjResultSet)
      strKey.set(m$.fnc$("COMViewCustom.GetID",pobjResultSet.get()));
      //<< 
      //<< // SR15426: vvv
      //<< set idUser=$$$GetParentUser(YUSER)
      idUser.set(include.COMSYSWWW.$$$GetParentUser(m$,m$.var("YUSER")));
      //<< new YUSER
      mVar YUSER = m$.var("YUSER");
      m$.newVar(YUSER);
      //<< 
      //<< set YUSER=idUser
      YUSER.set(idUser.get());
      //<< // SR15426: ^^^
      //<< 
      //<< set parentKey = $piece(strKey,",",1,$length(strKey,",")-1)
      parentKey.set(m$.Fnc.$piece(strKey.get(),",",1,mOp.Subtract(m$.Fnc.$length(strKey.get(),","),1)));
      //<< set idKey     = $piece(strKey,",",$length(strKey,","))
      idKey.set(m$.Fnc.$piece(strKey.get(),",",m$.Fnc.$length(strKey.get(),",")));
      //<< set YFORM = $$$GRIDName
      YFORM.set(include.COMGridEdit31Interface.$$$GRIDName(m$));
      //<< 
      //<< if parentKey = $$GetYKEY^COMGridEdit31G() {     // Same parent
      if (mOp.Equal(parentKey.get(),m$.fnc$("COMGridEdit31G.GetYKEY"))) {
        //<< set idRow = $get($$$WWWDATEN("REFERENCEROW",idKey,1))
        idRow.set(m$.Fnc.$get(COMGridEdit31Events.$$$WWWDATENVar(m$,"REFERENCEROW",idKey,1)));
        //<< 
        //<< if idRow'="" {
        if (mOp.NotEqual(idRow.get(),"")) {
          //<< if $data($$$WWWDATEN("REFERENCEKEY",idRow,1)) { // FIXME - not displayed
          if (mOp.Logical(m$.Fnc.$data(COMGridEdit31Events.$$$WWWDATENVar(m$,"REFERENCEKEY",idRow,1)))) {
            //<< if $$$KilledRecord(idRow,YFORM) {
            if (mOp.Logical(include.COMGridEdit31.$$$KilledRecord(m$,idRow,YFORM))) {
              //<< $$$Alert("Com00231")      ; "That record has been deleted."
              include.COMSYS.$$$Alert(m$,"Com00231");
            }
            //<< 
            //<< } elseif $$$ViewableRow(idRow,YFORM) {
            else if (mOp.Logical(include.COMGridEdit31.$$$ViewableRow(m$,idRow,YFORM))) {
              //<< 
              //<< if $$$DisplayedRecord(idRow,YFORM) {
              if (mOp.Logical(include.COMGridEdit31.$$$DisplayedRecord(m$,idRow,YFORM))) {
                //<< set intPage = $$$GRIDPage
                intPage.set(include.COMGridEdit31.$$$GRIDPage(m$));
                //<< set blnUpdate=$$$YES
                blnUpdate.set(include.COMSYS.$$$YES(m$));
              }
              //<< 
              //<< } else {
              else {
                //<< set blnUpdate=$$$NO
                blnUpdate.set(include.COMSYS.$$$NO(m$));
                //<< set intPage = $$GetPage(idRow)
                intPage.set(m$.fnc$("GetPage",idRow.get()));
              }
              //<< }
              //<< write $$$GRIDGoToPage(intPage,$$$GRIDNumPages,$$$GRIDGetFirstCell(idRow),blnUpdate)
              m$.Cmd.Write(include.COMGridEdit31.$$$GRIDGoToPage(m$,intPage,include.COMGridEdit31.$$$GRIDNumPages(m$),include.COMGridEdit31.$$$GRIDGetFirstCell(m$,idRow),blnUpdate));
            }
          }
        }
      }
    }
    //<< }
    //<< }
    //<< }
    //<< }
    //<< // else {       TODO
    //<< //  do GoToForm^COMGridEdit31G($$$GRIDContainer,parentKey,$get(^CacheTemp(YUSER,"Grid","YSEITE")),idKey)
    //<< // }
    //<< }
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< GetPage(pidRow)
  public Object GetPage(Object ... _p) {
    mVar pidRow = m$.newVarRef("pidRow",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Get the page a record should be on - traverse the sorted records back to the
    //<< ; start from the current row (pidRow) to determine how many pages exist before
    //<< ; this position.
    //<< ;
    //<< ; Params:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 30-Oct-2008   SCR     SR16026: Use Get Rows Per Page function instead of Macro
    //<< ; 03-Jun-2008   GRF     SR15739: Revisions to GetNextDisplayLine moved to new
    //<< ;                           routine; parameter changes from $order direction to
    //<< ;                           pblnReverse (1=>$$$NO, -1=>$$$YES)
    //<< ; 14-May-2008   shobby  SRBR014943: $$$GRIDPerPage (Use $get)
    //<< ; 21-Oct-2005   JW      SR11573: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new intCount,intPage,perPage
    mVar intCount = m$.var("intCount");
    mVar intPage = m$.var("intPage");
    mVar perPage = m$.var("perPage");
    m$.newVar(intCount,intPage,perPage);
    //<< 
    //<< set perPage = $$GetRowsPerPage^COMGridEdit31(YBED,YFORM) ;SR16026  ;BR014943
    perPage.set(m$.fnc$("COMGridEdit31.GetRowsPerPage",m$.var("YBED").get(),m$.var("YFORM").get()));
    //<< for intPage=1:1 {
    for (intPage.set(1);(true);intPage.set(mOp.Add(intPage.get(),1))) {
      //<< set intCount = 0
      intCount.set(0);
      //<< while intCount < perPage {
      while (mOp.Less(intCount.get(),perPage.get())) {
        //<< set pidRow = $$GetNextDisplayLine^COMGridEdit31Body2(pidRow,$$$YES)
        pidRow.set(m$.fnc$("COMGridEdit31Body2.GetNextDisplayLine",pidRow.get(),include.COMSYS.$$$YES(m$)));
        //<< quit:pidRow=""
        if (mOp.Equal(pidRow.get(),"")) {
          break;
        }
        //<< 
        //<< set intCount = intCount + 1
        intCount.set(mOp.Add(intCount.get(),1));
      }
      //<< }
      //<< quit:pidRow=""
      if (mOp.Equal(pidRow.get(),"")) {
        break;
      }
    }
    //<< }
    //<< quit intPage
    return intPage.get();
  }

  //<< 
  //<< 
  //<< TEST(YLFDAT)
  public Object TEST(Object ... _p) {
    mVar YLFDAT = m$.newVarRef("YLFDAT",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< new x,loop,y,name
    mVar x = m$.var("x");
    mVar loop = m$.var("loop");
    mVar y = m$.var("y");
    mVar name = m$.var("name");
    m$.newVar(x,loop,y,name);
    //<< 
    //<< set x=$zhorolog
    x.set(m$.Fnc.$zhorolog());
    //<< set ^y(1,2,3)="aaa"
    m$.var("^y",1,2,3).set("aaa");
    //<< for loop=1:1:1000000 {
    for (loop.set(1);(mOp.LessOrEqual(loop.get(),1000000));loop.set(mOp.Add(loop.get(),1))) {
      //<< ;set name=$get(^y(1,2,3))
      //<< set name=^y(1,2,3)
      name.set(m$.var("^y",1,2,3).get());
    }
    //<< }
    //<< set x=$zhorolog-x
    x.set(mOp.Subtract(m$.Fnc.$zhorolog(),x.get()));
    //<< write !,x
    m$.Cmd.Write("\n",x.get());
    //<< quit $$$OK
    return include.COMSYS.$$$OK(m$);
  }

//<< 
//<< 
}
