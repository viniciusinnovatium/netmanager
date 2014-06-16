//*****************************************************************************
//** TASC - ALPHALINC - MAC COMViewFilterColumn
//** Innovatium Systems - Code Converter - v1.30
//** 2014-06-13 20:51:35
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
//<< #include COMConst
import include.COMConst;
//<< #include WWWConst
import include.WWWConst;

//<< COMViewFilterColumn ; Controls the display of user driven and default columns.
public class COMViewFilterColumn extends mClass {

  public void main() {
    _COMViewFilterColumn();
  }

  public void _COMViewFilterColumn() {
  }

  //<< 
  //<< Output(penumType,&pobjOutput)
  public Object Output(Object ... _p) {
    mVar penumType = m$.newVarRef("penumType",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pobjOutput = m$.newVarRef("pobjOutput",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Wrapper for the routines that create the body of an export to CSV or Excel
    //<< ; Moved from COM.COMViewToExcel so that that routine could be reused to print
    //<< ; out the contents of a grid.
    //<< ;
    //<< ; Inputs:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 08-Dec-2008   shobby  SR16222: Order of DisplayFilter and DisplayHeader
    //<< ;                           was incorrect in the CSV file - Swapped.
    //<< ; 25-Feb-2008   shobby  SRBR014446: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new idClass
    mVar idClass = m$.var("idClass");
    m$.newVar(idClass);
    //<< 
    //<< set idClass=$get(^CacheTempView(YUSER,"Class"))
    idClass.set(m$.Fnc.$get(m$.var("^CacheTempView",m$.var("YUSER").get(),"Class")));
    //<< do DisplayFilter^COMViewFilterColumn(idClass,penumType,pobjOutput) //BR014788 ;16222
    m$.Cmd.Do("COMViewFilterColumn.DisplayFilter",idClass.get(),penumType.get(),pobjOutput.get());
    //<< do DisplayHeader^COMViewFilterColumn(idClass,penumType,pobjOutput)
    m$.Cmd.Do("COMViewFilterColumn.DisplayHeader",idClass.get(),penumType.get(),pobjOutput.get());
    //<< do OnBeforeDisplayGrid^COMViewFilter(penumType,pobjOutput) // SR14896
    m$.Cmd.Do("COMViewFilter.OnBeforeDisplayGrid",penumType.get(),pobjOutput.get());
    //<< 
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< DisplayHeader(pidClass="",penumType=$$$EnumDisplayTypeCOMView,&pobjOutput="")
  public Object DisplayHeader(Object ... _p) {
    mVar pidClass = m$.newVarRef("pidClass",(((_p!=null)&&(_p.length>=1))?_p[0]:null),"");
    mVar penumType = m$.newVarRef("penumType",(((_p!=null)&&(_p.length>=2))?_p[1]:null),include.COMSYS.$$$EnumDisplayTypeCOMView(m$));
    mVar pobjOutput = m$.newVarRef("pobjOutput",(((_p!=null)&&(_p.length>=3))?_p[2]:null),"");
    //<< ;-------------------------------------------------------------------------------
    //<< ; Displays the column headers
    //<< ;
    //<< ; Parameters
    //<< ; pidClass  : The class name
    //<< ; penumType : The type of export, -1 = COMView, 0 = Excel, 1 = CSV
    //<< ; pobjOutput: The file type to output (not used for COMView export)
    //<< ;
    //<< ; History:
    //<< ; 07-Apr-2009   PPP     SR16468: Header details - Object Properties to go
    //<< ;                           through language translation before display
    //<< ;                           (WWWClassTranslation)
    //<< ; 09-Sep-2008   PPP     SR15866: Update COMView to Objects
    //<< ; 21-Feb-2008   shobby  SRBR014900: GetDescription^COMUtilClass has moved to
    //<< ;                           COMViewDescription
    //<< ; 24-Jul-2006   RPW     SR14254: Added support for exporting to CSV and Excel
    //<< ; 12-Apr-2005   Paul K  Added support for custom commands
    //<< ; 07-Feb-2005   PO      SR10965 Adding support for related classes.
    //<< ;-------------------------------------------------------------------------------
    //<< new blnObj,idKey,lstColumns,idField,FieldLoop,objField,idView,strDescription
    mVar blnObj = m$.var("blnObj");
    mVar idKey = m$.var("idKey");
    mVar lstColumns = m$.var("lstColumns");
    mVar idField = m$.var("idField");
    mVar FieldLoop = m$.var("FieldLoop");
    mVar objField = m$.var("objField");
    mVar idView = m$.var("idView");
    mVar strDescription = m$.var("strDescription");
    m$.newVar(blnObj,idKey,lstColumns,idField,FieldLoop,objField,idView,strDescription);
    //<< new idClass,idRelationField,strPiece2,intLen
    mVar idClass = m$.var("idClass");
    mVar idRelationField = m$.var("idRelationField");
    mVar strPiece2 = m$.var("strPiece2");
    mVar intLen = m$.var("intLen");
    m$.newVar(idClass,idRelationField,strPiece2,intLen);
    //<< 
    //<< set blnObj = +$get(^CacheTempObj(YUSER,"Object"))
    blnObj.set(mOp.Positive(m$.Fnc.$get(m$.var("^CacheTempObj",m$.var("YUSER").get(),"Object"))));
    //<< 
    //<< set idKey=""
    idKey.set("");
    //<< if pidClass="" set pidClass = $get(^CacheTempView(YUSER,"Class"))
    if (mOp.Equal(pidClass.get(),"")) {
      pidClass.set(m$.Fnc.$get(m$.var("^CacheTempView",m$.var("YUSER").get(),"Class")));
    }
    //<< 
    //<< set idView     = $$GetCurrentView^COMView(pidClass)
    idView.set(m$.fnc$("COMView.GetCurrentView",pidClass.get()));
    //<< set lstColumns = $$GetColumns(pidClass,idView)
    lstColumns.set(m$.fnc$("GetColumns",pidClass.get(),idView.get()));
    //<< 
    //<< if penumType=$$$EnumDisplayTypeExcel {
    if (mOp.Equal(penumType.get(),include.COMSYS.$$$EnumDisplayTypeExcel(m$))) {
      //<< do pobjOutput.WriteLine("<tr>")
      m$.Cmd.Do(pobjOutput.getORef(),"WriteLine","<tr>");
    }
    //<< 
    //<< } elseif penumType=$$$EnumDisplayTypeCOMView {
    else if (mOp.Equal(penumType.get(),include.COMSYS.$$$EnumDisplayTypeCOMView(m$))) {
      //<< write "ClearCol();"
      m$.Cmd.Write("ClearCol();");
      //<< if $data(^CacheTempView(YUSER,"Command")) {
      if (mOp.Logical(m$.Fnc.$data(m$.var("^CacheTempView",m$.var("YUSER").get(),"Command")))) {
        //<< write "AddCol(hdr,'&nbsp;','"_(30*$order(^CacheTempView(YUSER,"Command",""),-1))_"','','','');"  ;leave 30px for each pic.
        m$.Cmd.Write(mOp.Concat(mOp.Concat("AddCol(hdr,'&nbsp;','",(mOp.Multiply(30,m$.Fnc.$order(m$.var("^CacheTempView",m$.var("YUSER").get(),"Command",""),mOp.Negative(1))))),"','','','');"));
      }
    }
    //<< }
    //<< }
    //<< 
    //<< 
    //<< set intLen = $listlength(lstColumns)
    intLen.set(m$.Fnc.$listlength(lstColumns.get()));
    //<< for FieldLoop=1:1:intLen {
    for (FieldLoop.set(1);(mOp.LessOrEqual(FieldLoop.get(),intLen.get()));FieldLoop.set(mOp.Add(FieldLoop.get(),1))) {
      //<< set idField  = $listget(lstColumns,FieldLoop)
      idField.set(m$.Fnc.$listget(lstColumns.get(),FieldLoop.get()));
      //<< set idClass  = " "
      idClass.set(" ");
      //<< set objField = $get(^COMViewColumnUser(0,pidClass,idView,YBED,idField))
      objField.set(m$.Fnc.$get(m$.var("^COMViewColumnUser",0,pidClass.get(),idView.get(),m$.var("YBED").get(),idField.get())));
      //<< if idField="RowCount" {
      if (mOp.Equal(idField.get(),"RowCount")) {
        //<< set strDescription = $$$Text("Com00150")       ; "Count"
        strDescription.set(include.COMSYS.$$$Text(m$,"Com00150"));
      }
      //<< 
      //<< } else {
      else {
        //<< if 'blnObj {
        if (mOp.Not(blnObj.get())) {
          //<< set idClass         = pidClass
          idClass.set(pidClass.get());
          //<< set idRelationField = idField
          idRelationField.set(idField.get());
          //<< if $extract($piece(idField,".",2),1)="C" {
          if (mOp.Equal(m$.Fnc.$extract(m$.Fnc.$piece(idField.get(),".",2),1),"C")) {
            //<< set strPiece2       = $piece(idField,".",2)
            strPiece2.set(m$.Fnc.$piece(idField.get(),".",2));
            //<< set idClass         = $extract(strPiece2,2,$length(strPiece2))
            idClass.set(m$.Fnc.$extract(strPiece2.get(),2,m$.Fnc.$length(strPiece2.get())));
            //<< set idRelationField = $piece(idField,".",3)
            idRelationField.set(m$.Fnc.$piece(idField.get(),".",3));
          }
          //<< 
          //<< } else {
          else {
            //<< if $find(idRelationField,".") {    ; FIXME : <GRF> GetRelation^COMViewUtils is a function.
            if (mOp.Logical(m$.Fnc.$find(idRelationField.get(),"."))) {
              //<< do GetRelation^COMViewUtils(.idClass,idRelationField)
              m$.Cmd.Do("COMViewUtils.GetRelation",idClass,idRelationField.get());
              //<< set idRelationField = $piece(idRelationField,".",2)
              idRelationField.set(m$.Fnc.$piece(idRelationField.get(),".",2));
            }
          }
          //<< }
          //<< }
          //<< set strDescription = $$GetDescription^COMViewDescription(idClass,$extract(idRelationField,1),$extract(idRelationField,2,99))
          strDescription.set(m$.fnc$("COMViewDescription.GetDescription",idClass.get(),m$.Fnc.$extract(idRelationField.get(),1),m$.Fnc.$extract(idRelationField.get(),2,99)));
        }
        //<< 
        //<< } else {
        else {
          //<< set strDescription = $$GetTextRelated^WWWClassTranslation(pidClass,idField,$get(SPRACHE))
          strDescription.set(m$.fnc$("WWWClassTranslation.GetTextRelated",pidClass.get(),idField.get(),m$.Fnc.$get(m$.var("SPRACHE"))));
        }
      }
      //<< }
      //<< }
      //<< if penumType=$$$EnumDisplayTypeCOMView {
      if (mOp.Equal(penumType.get(),include.COMSYS.$$$EnumDisplayTypeCOMView(m$))) {
        //<< write "AddCol(hdr,'"_$zcvt(strDescription,"o","JS")_"','"_$$$COMViewColumnWidth(objField)_"','"_$$$COMViewColumnSort1(objField)_"','"_idField_"','"_$zconvert($$GetDescription^COMViewDescription(idClass)_" > "_strDescription,"o","JS")_"');" ;BR014900
        m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("AddCol(hdr,'",m$.Fnc.$zconvert(strDescription.get(),"o","JS")),"','"),include.COMConst.$$$COMViewColumnWidth(m$,objField)),"','"),include.COMConst.$$$COMViewColumnSort1(m$,objField)),"','"),idField.get()),"','"),m$.Fnc.$zconvert(mOp.Concat(mOp.Concat(m$.fnc$("COMViewDescription.GetDescription",idClass.get())," > "),strDescription.get()),"o","JS")),"');"));
      }
      //<< } else {
      else {
        //<< do:penumType=$$$EnumDisplayTypeExcel pobjOutput.Write("<td class='header'>")
        if (mOp.Equal(penumType.get(),include.COMSYS.$$$EnumDisplayTypeExcel(m$))) {
          m$.Cmd.Do(pobjOutput.getORef(),"Write","<td class='header'>");
        }
        //<< do pobjOutput.Write(strDescription)
        m$.Cmd.Do(pobjOutput.getORef(),"Write",strDescription.get());
        //<< do:(penumType=$$$EnumDisplayTypeCSV)&&(FieldLoop<intLen) pobjOutput.Write(",")
        if ((mOp.Equal(penumType.get(),include.COMSYS.$$$EnumDisplayTypeCSV(m$))) && (mOp.Less(FieldLoop.get(),intLen.get()))) {
          m$.Cmd.Do(pobjOutput.getORef(),"Write",",");
        }
        //<< do:(penumType=$$$EnumDisplayTypeExcel) pobjOutput.WriteLine("</td>")
        if ((mOp.Equal(penumType.get(),include.COMSYS.$$$EnumDisplayTypeExcel(m$)))) {
          m$.Cmd.Do(pobjOutput.getORef(),"WriteLine","</td>");
        }
      }
    }
    //<< }
    //<< }
    //<< 
    //<< if penumType=$$$EnumDisplayTypeExcel {
    if (mOp.Equal(penumType.get(),include.COMSYS.$$$EnumDisplayTypeExcel(m$))) {
      //<< do pobjOutput.WriteLine("</tr>")
      m$.Cmd.Do(pobjOutput.getORef(),"WriteLine","</tr>");
    }
    //<< 
    //<< } elseif penumType=$$$EnumDisplayTypeCSV {
    else if (mOp.Equal(penumType.get(),include.COMSYS.$$$EnumDisplayTypeCSV(m$))) {
      //<< do pobjOutput.WriteLine()
      m$.Cmd.Do(pobjOutput.getORef(),"WriteLine");
    }
    //<< }
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< Format(pstrText,pblnBold=$$$NO,penumType=$$$EnumDisplayTypeCOMView)
  public Object Format(Object ... _p) {
    mVar pstrText = m$.newVarRef("pstrText",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pblnBold = m$.newVarRef("pblnBold",(((_p!=null)&&(_p.length>=2))?_p[1]:null),include.COMSYS.$$$NO(m$));
    mVar penumType = m$.newVarRef("penumType",(((_p!=null)&&(_p.length>=3))?_p[2]:null),include.COMSYS.$$$EnumDisplayTypeCOMView(m$));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Only put the HTML in, if it is an Excel output.
    //<< ;
    //<< ; Params:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 08-Dec-2008   shobby  SR16222: Created
    //<< ;-------------------------------------------------------------------------------
    //<< if penumType=$$$EnumDisplayTypeExcel {
    if (mOp.Equal(penumType.get(),include.COMSYS.$$$EnumDisplayTypeExcel(m$))) {
      //<< if pblnBold set pstrText="<b>"_pstrText_"</b>"
      if (mOp.Logical(pblnBold.get())) {
        pstrText.set(mOp.Concat(mOp.Concat("<b>",pstrText.get()),"</b>"));
      }
      //<< set pstrText=pstrText_"<br>"
      pstrText.set(mOp.Concat(pstrText.get(),"<br>"));
    }
    //<< }
    //<< quit pstrText
    return pstrText.get();
  }

  //<< 
  //<< 
  //<< DisplayFilter(pidClass="",penumType=$$$EnumDisplayTypeCOMView,pobjOutput="")
  public Object DisplayFilter(Object ... _p) {
    mVar pidClass = m$.newVarRef("pidClass",(((_p!=null)&&(_p.length>=1))?_p[0]:null),"");
    mVar penumType = m$.newVarRef("penumType",(((_p!=null)&&(_p.length>=2))?_p[1]:null),include.COMSYS.$$$EnumDisplayTypeCOMView(m$));
    mVar pobjOutput = m$.newVarRef("pobjOutput",(((_p!=null)&&(_p.length>=3))?_p[2]:null),"");
    //<< ;-------------------------------------------------------------------------------
    //<< ;
    //<< ; Params: pidClass: name of the class where the COMView was open
    //<< ;         pobjOutput: the object that contains all http structure
    //<< ;
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 07-Apr-2009   PPP     SR16468: Header details - Object Properties to go through
    //<< ;                       language translation before display (WWWClassTranslation)
    //<< ; 08-Dec-2008   shobby  SR16222:Only put the HTML in, if it is an Excel output.
    //<< ; 09-Sep-2008   PP      SR15866:Update COMView to Objects
    //<< ; 21-Feb-2007   shobby  SRBR014900: GetDescription^COMViewDescription moved from
    //<< ;                           COMUtilClass
    //<< ; 12-Dec-2007   shobby  SRBR014788: Code check issues. Made the operation
    //<< ;                           optional based on a COMViewConfig
    //<< ; 19-Nov-2007   Karine  SRBR014788: Created: Show selected fields in a COMView
    //<< ;                           and its filters
    //<< ;-------------------------------------------------------------------------------
    //<< new blnObj,idComparator,idField,intField,objCOMViewConfig,objFilter
    mVar blnObj = m$.var("blnObj");
    mVar idComparator = m$.var("idComparator");
    mVar idField = m$.var("idField");
    mVar intField = m$.var("intField");
    mVar objCOMViewConfig = m$.var("objCOMViewConfig");
    mVar objFilter = m$.var("objFilter");
    m$.newVar(blnObj,idComparator,idField,intField,objCOMViewConfig,objFilter);
    //<< new strComparator,strDescField,strField,strFilter,strFilterDetails,strTitle
    mVar strComparator = m$.var("strComparator");
    mVar strDescField = m$.var("strDescField");
    mVar strField = m$.var("strField");
    mVar strFilter = m$.var("strFilter");
    mVar strFilterDetails = m$.var("strFilterDetails");
    mVar strTitle = m$.var("strTitle");
    m$.newVar(strComparator,strDescField,strField,strFilter,strFilterDetails,strTitle);
    //<< 
    //<< set blnObj=+$get(^CacheTempObj(YUSER,"Object"))     //SR15866
    blnObj.set(mOp.Positive(m$.Fnc.$get(m$.var("^CacheTempObj",m$.var("YUSER").get(),"Object"))));
    //<< 
    //<< set objCOMViewConfig=$get(^COMViewConfig(0,YM,1))
    objCOMViewConfig.set(m$.Fnc.$get(m$.var("^COMViewConfig",0,m$.var("YM").get(),1)));
    //<< if $$$COMViewConfigDisplayFilterInExcel(objCOMViewConfig) {
    if (mOp.Logical(include.COMConst.$$$COMViewConfigDisplayFilterInExcel(m$,objCOMViewConfig))) {
      //<< ; SR16222 vvv
      //<< do pobjOutput.WriteLine($$Format($$GetDescription^COMViewDescription(YFORM),$$$YES,penumType))
      m$.Cmd.Do(pobjOutput.getORef(),"WriteLine",m$.fnc$("Format",m$.fnc$("COMViewDescription.GetDescription",m$.var("YFORM").get()),include.COMSYS.$$$YES(m$),penumType.get()));
      //<< do pobjOutput.WriteLine($$Format($$$Text($listbuild("Com00319",$$^WWWDATE($h)_" "_$$^WWWTIME($h))),$$$NO,penumType))  ;Report Generated:
      m$.Cmd.Do(pobjOutput.getORef(),"WriteLine",m$.fnc$("Format",include.COMSYS.$$$Text(m$,m$.Fnc.$listbuild("Com00319",mOp.Concat(mOp.Concat(m$.fnc$("WWWDATE.main",m$.Fnc.$horolog())," "),m$.fnc$("WWWTIME.main",m$.Fnc.$horolog())))),include.COMSYS.$$$NO(m$),penumType.get()));
      //<< 
      //<< if $data(^CacheTempView(YUSER,"Filter")) {
      if (mOp.Logical(m$.Fnc.$data(m$.var("^CacheTempView",m$.var("YUSER").get(),"Filter")))) {
        //<< set strTitle = $$$Text("Com00304") // "Field Selection : "
        strTitle.set(include.COMSYS.$$$Text(m$,"Com00304"));
        //<< do pobjOutput.WriteLine($$Format(strTitle,$$$YES,penumType)) //$$$TEXT NO WWW009
        m$.Cmd.Do(pobjOutput.getORef(),"WriteLine",m$.fnc$("Format",strTitle.get(),include.COMSYS.$$$YES(m$),penumType.get()));
      }
      //<< }
      //<< ; SR16222 ^^^
      //<< 
      //<< set strFilter=""
      strFilter.set("");
      //<< for {
      for (;true;) {
        //<< set strFilter=$order(^CacheTempView(YUSER,"Filter",strFilter))
        strFilter.set(m$.Fnc.$order(m$.var("^CacheTempView",m$.var("YUSER").get(),"Filter",strFilter.get())));
        //<< quit:strFilter=""
        if (mOp.Equal(strFilter.get(),"")) {
          break;
        }
        //<< 
        //<< set objFilter = $get(^CacheTempView(YUSER,"Filter",strFilter))
        objFilter.set(m$.Fnc.$get(m$.var("^CacheTempView",m$.var("YUSER").get(),"Filter",strFilter.get())));
        //<< set idField          = $piece(objFilter,Y,1)
        idField.set(m$.Fnc.$piece(objFilter.get(),m$.var("Y").get(),1));
        //<< set strFilterDetails = $piece(objFilter,Y,2)
        strFilterDetails.set(m$.Fnc.$piece(objFilter.get(),m$.var("Y").get(),2));
        //<< set idComparator     = $piece(objFilter,Y,3)
        idComparator.set(m$.Fnc.$piece(objFilter.get(),m$.var("Y").get(),3));
        //<< 
        //<< if strFilterDetails '="" {
        if (mOp.NotEqual(strFilterDetails.get(),"")) {
          //<< if 'blnObj {
          if (mOp.Not(blnObj.get())) {
            //<< set strField = $extract(idField,1)
            strField.set(m$.Fnc.$extract(idField.get(),1));
            //<< set intField = $extract(idField,2,99) //field number
            intField.set(m$.Fnc.$extract(idField.get(),2,99));
            //<< //Get the right field description including languages and customized names
            //<< set strDescField = $$GetDescription^COMViewDescription(pidClass,strField,intField) ;BR014900
            strDescField.set(m$.fnc$("COMViewDescription.GetDescription",pidClass.get(),strField.get(),intField.get()));
          }
          //<< } else {
          else {
            //<< //set strDescField = idField
            //<< set strDescField = $$GetTextRelated^WWWClassTranslation(pidClass,idField,$get(SPRACHE))         //SR16468
            strDescField.set(m$.fnc$("WWWClassTranslation.GetTextRelated",pidClass.get(),idField.get(),m$.Fnc.$get(m$.var("SPRACHE"))));
          }
          //<< }
          //<< 
          //<< set strComparator = $$$AppEnum("COMVIEWCOMPARATOR",idComparator)
          strComparator.set(include.COMSYSWWW.$$$AppEnum(m$,"COMVIEWCOMPARATOR",idComparator));
          //<< 
          //<< do pobjOutput.WriteLine($$Format("   "_strDescField_" - "_strComparator_" = "_strFilterDetails,$$$NO,penumType))
          m$.Cmd.Do(pobjOutput.getORef(),"WriteLine",m$.fnc$("Format",mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("   ",strDescField.get())," - "),strComparator.get())," = "),strFilterDetails.get()),include.COMSYS.$$$NO(m$),penumType.get()));
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
  //<< SelectColumn(pidField="",pintPosition="")
  public Object SelectColumn(Object ... _p) {
    mVar pidField = m$.newVarRef("pidField",(((_p!=null)&&(_p.length>=1))?_p[0]:null),"");
    mVar pintPosition = m$.newVarRef("pintPosition",(((_p!=null)&&(_p.length>=2))?_p[1]:null),"");
    //<< ;-------------------------------------------------------------------------------
    //<< ; Called when a user wants the add/remove a column from the result grid.
    //<< ;
    //<< ; Called by Select^COMViewChoose and JS: ColumnClick()
    //<< ;
    //<< ; History:
    //<< ; 15-Feb-2007   Steve S SR15431: Use standard alert, not VBConfirm
    //<< ; 29-Aug-2006   JW      SR14763: Language text
    //<< ; 12-Apr-2005   Paul K  Commented
    //<< ;-------------------------------------------------------------------------------
    //<< new idColumn,idClass,idView,intColumn,idField
    mVar idColumn = m$.var("idColumn");
    mVar idClass = m$.var("idClass");
    mVar idView = m$.var("idView");
    mVar intColumn = m$.var("intColumn");
    mVar idField = m$.var("idField");
    m$.newVar(idColumn,idClass,idView,intColumn,idField);
    //<< 
    //<< set idClass=$get(^CacheTempView(YUSER,"Class"))
    idClass.set(m$.Fnc.$get(m$.var("^CacheTempView",m$.var("YUSER").get(),"Class")));
    //<< 
    //<< if (idClass'="") && (pidField'="") {
    if ((mOp.NotEqual(idClass.get(),"")) && (mOp.NotEqual(pidField.get(),""))) {
      //<< set idView = $$GetCurrentView^COMView(idClass)
      idView.set(m$.fnc$("COMView.GetCurrentView",idClass.get()));
      //<< if $data(^COMViewColumnUser(0,idClass,idView,YBED,pidField)) {
      if (mOp.Logical(m$.Fnc.$data(m$.var("^COMViewColumnUser",0,idClass.get(),idView.get(),m$.var("YBED").get(),pidField.get())))) {
        //<< if ($order(^COMViewColumnUser(0,idClass,idView,YBED,pidField))="")    &&
        //<< ($order(^COMViewColumnUser(0,idClass,idView,YBED,pidField),-1)="")    {
        if ((mOp.Equal(m$.Fnc.$order(m$.var("^COMViewColumnUser",0,idClass.get(),idView.get(),m$.var("YBED").get(),pidField.get())),"")) && (mOp.Equal(m$.Fnc.$order(m$.var("^COMViewColumnUser",0,idClass.get(),idView.get(),m$.var("YBED").get(),pidField.get()),mOp.Negative(1)),""))) {
          //<< 
          //<< $$$Alert("Com00151") //SR15431
          include.COMSYS.$$$Alert(m$,"Com00151");
        }
        //<< //  write "VBConfirm('"_$$$Text("Com00151")_"',16,'"_$$$Text("Com00254")_"');"  ;Must have at least one column.   ; Search Error    SR14763
        //<< 
        //<< } else {
        else {
          //<< kill ^COMViewColumnUser(0,idClass,idView,YBED,pidField)
          m$.var("^COMViewColumnUser",0,idClass.get(),idView.get(),m$.var("YBED").get(),pidField.get()).kill();
        }
      }
      //<< }
      //<< 
      //<< } else {
      else {
        //<< set intColumn=0
        intColumn.set(0);
        //<< set idField=""
        idField.set("");
        //<< for {
        for (;true;) {
          //<< set idField=$order(^COMViewColumnUser(0,idClass,idView,YBED,idField))
          idField.set(m$.Fnc.$order(m$.var("^COMViewColumnUser",0,idClass.get(),idView.get(),m$.var("YBED").get(),idField.get())));
          //<< quit:idField=""
          if (mOp.Equal(idField.get(),"")) {
            break;
          }
          //<< 
          //<< if $$$COMViewColumnUserColumn1($get(^COMViewColumnUser(0,idClass,idView,YBED,idField)))>intColumn {
          if (mOp.Greater(include.COMConst.$$$COMViewColumnUserColumn1(m$,m$.Fnc.$get(m$.var("^COMViewColumnUser",0,idClass.get(),idView.get(),m$.var("YBED").get(),idField.get()))),intColumn.get())) {
            //<< set intColumn=$$$COMViewColumnUserColumn1($get(^COMViewColumnUser(0,idClass,idView,YBED,idField)))
            intColumn.set(include.COMConst.$$$COMViewColumnUserColumn1(m$,m$.Fnc.$get(m$.var("^COMViewColumnUser",0,idClass.get(),idView.get(),m$.var("YBED").get(),idField.get()))));
          }
        }
        //<< }
        //<< }
        //<< set ^COMViewColumnUser(0,idClass,idView,YBED,pidField)=$increment(intColumn)
        m$.var("^COMViewColumnUser",0,idClass.get(),idView.get(),m$.var("YBED").get(),pidField.get()).set(m$.Fnc.$increment(intColumn));
      }
      //<< }
      //<< do DisplayHeader(idClass)
      m$.Cmd.Do("DisplayHeader",idClass.get());
      //<< do DisplayGrid^COMViewFilter()
      m$.Cmd.Do("COMViewFilter.DisplayGrid");
    }
    //<< }
    //<< quit $$$OK
    return include.COMSYS.$$$OK(m$);
  }

  //<< 
  //<< 
  //<< GetColumns(pidClass,pidView="",pblnRemovedFixed=1)
  public Object GetColumns(Object ... _p) {
    mVar pidClass = m$.newVarRef("pidClass",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pidView = m$.newVarRef("pidView",(((_p!=null)&&(_p.length>=2))?_p[1]:null),"");
    mVar pblnRemovedFixed = m$.newVarRef("pblnRemovedFixed",(((_p!=null)&&(_p.length>=3))?_p[2]:null),1);
    //<< ;-------------------------------------------------------------------------------
    //<< ; Returns the currently selected columns.
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ;  4-Sep-2006   JW      SR14949: Don't remove fixed filter columns
    //<< ; 29-Dec-2004   Paul K  Created
    //<< ;-------------------------------------------------------------------------------
    //<< new lstColumns,intColumn,arrColumns,idField,objColumn,intGroup
    mVar lstColumns = m$.var("lstColumns");
    mVar intColumn = m$.var("intColumn");
    mVar arrColumns = m$.var("arrColumns");
    mVar idField = m$.var("idField");
    mVar objColumn = m$.var("objColumn");
    mVar intGroup = m$.var("intGroup");
    m$.newVar(lstColumns,intColumn,arrColumns,idField,objColumn,intGroup);
    //<< 
    //<< if pidView="" set pidView=$$GetCurrentView^COMView(pidClass)
    if (mOp.Equal(pidView.get(),"")) {
      pidView.set(m$.fnc$("COMView.GetCurrentView",pidClass.get()));
    }
    //<< 
    //<< set lstColumns=""
    lstColumns.set("");
    //<< 
    //<< if (pidClass'="")&&(pidView'="") {
    if ((mOp.NotEqual(pidClass.get(),"")) && (mOp.NotEqual(pidView.get(),""))) {
      //<< set idField=""
      idField.set("");
      //<< for {
      for (;true;) {
        //<< set idField=$order(^COMViewColumnUser(0,pidClass,pidView,YBED,idField))
        idField.set(m$.Fnc.$order(m$.var("^COMViewColumnUser",0,pidClass.get(),pidView.get(),m$.var("YBED").get(),idField.get())));
        //<< quit:idField=""
        if (mOp.Equal(idField.get(),"")) {
          break;
        }
        //<< 
        //<< set objColumn=$get(^COMViewColumnUser(0,pidClass,pidView,YBED,idField))
        objColumn.set(m$.Fnc.$get(m$.var("^COMViewColumnUser",0,pidClass.get(),pidView.get(),m$.var("YBED").get(),idField.get())));
        //<< set arrColumns(0,+$$$COMViewColumnColumn1(objColumn),idField)=""
        arrColumns.var(0,mOp.Positive(include.COMConst.$$$COMViewColumnColumn1(m$,objColumn)),idField.get()).set("");
      }
    }
    //<< }
    //<< }
    //<< set intGroup=""
    intGroup.set("");
    //<< for {
    for (;true;) {
      //<< set intGroup=$order(arrColumns(intGroup),-1)
      intGroup.set(m$.Fnc.$order(arrColumns.var(intGroup.get()),mOp.Negative(1)));
      //<< quit:intGroup=""
      if (mOp.Equal(intGroup.get(),"")) {
        break;
      }
      //<< 
      //<< set intColumn=""
      intColumn.set("");
      //<< for {
      for (;true;) {
        //<< set intColumn=$order(arrColumns(intGroup,intColumn))
        intColumn.set(m$.Fnc.$order(arrColumns.var(intGroup.get(),intColumn.get())));
        //<< quit:intColumn=""
        if (mOp.Equal(intColumn.get(),"")) {
          break;
        }
        //<< 
        //<< set idField=""
        idField.set("");
        //<< for {
        for (;true;) {
          //<< set idField=$order(arrColumns(intGroup,intColumn,idField))
          idField.set(m$.Fnc.$order(arrColumns.var(intGroup.get(),intColumn.get(),idField.get())));
          //<< quit:idField=""
          if (mOp.Equal(idField.get(),"")) {
            break;
          }
          //<< 
          //<< set lstColumns=lstColumns_$listbuild(idField)
          lstColumns.set(mOp.Concat(lstColumns.get(),m$.Fnc.$listbuild(idField.get())));
        }
      }
    }
    //<< }
    //<< }
    //<< }
    //<< //SR14949 - removed as unnecessary
    //<< ;if pblnRemovedFixed set lstColumns=$$RemoveFixedFilterColumns(lstColumns)
    //<< 
    //<< quit lstColumns
    return lstColumns.get();
  }

  //<< 
  //<< 
  //<< RemoveFixedFilterColumns(plstColumns)
  public Object RemoveFixedFilterColumns(Object ... _p) {
    mVar plstColumns = m$.newVarRef("plstColumns",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; If a column is also part of the fixed filters, don't show it on the screen.
    //<< ;
    //<< ; Returns:List
    //<< ;
    //<< ; History:
    //<< ; 12-Apr-2005   Paul K  Commented
    //<< ;-------------------------------------------------------------------------------
    //<< new idFilter,intFind,objFilter
    mVar idFilter = m$.var("idFilter");
    mVar intFind = m$.var("intFind");
    mVar objFilter = m$.var("objFilter");
    m$.newVar(idFilter,intFind,objFilter);
    //<< 
    //<< set idFilter = ""
    idFilter.set("");
    //<< for {
    for (;true;) {
      //<< set idFilter = $order(^CacheTempView(YUSER,"FixedFilter",idFilter))
      idFilter.set(m$.Fnc.$order(m$.var("^CacheTempView",m$.var("YUSER").get(),"FixedFilter",idFilter.get())));
      //<< quit:idFilter=""
      if (mOp.Equal(idFilter.get(),"")) {
        break;
      }
      //<< 
      //<< set objFilter = $get(^CacheTempView(YUSER,"FixedFilter",idFilter))
      objFilter.set(m$.Fnc.$get(m$.var("^CacheTempView",m$.var("YUSER").get(),"FixedFilter",idFilter.get())));
      //<< set intFind   = $listfind(plstColumns,$$$COMViewFilterField(objFilter))
      intFind.set(m$.Fnc.$listfind(plstColumns.get(),include.COMConst.$$$COMViewFilterField(m$,objFilter)));
      //<< if ('$$$COMViewFilterGroupBy(objFilter)) && (intFind>0) {
      if ((mOp.Not(include.COMConst.$$$COMViewFilterGroupBy(m$,objFilter))) && (mOp.Greater(intFind.get(),0))) {
        //<< set plstColumns = $list(plstColumns,1,intFind-1)_$list(plstColumns,intFind+1,$listlength(plstColumns))
        plstColumns.set(mOp.Concat(m$.Fnc.$list(plstColumns.get(),1,mOp.Subtract(intFind.get(),1)),m$.Fnc.$list(plstColumns.get(),mOp.Add(intFind.get(),1),m$.Fnc.$listlength(plstColumns.get()))));
      }
    }
    //<< }
    //<< }
    //<< 
    //<< quit plstColumns
    return plstColumns.get();
  }

  //<< 
  //<< 
  //<< SetColumnWidth(pidField="",pstrWidth="")
  public Object SetColumnWidth(Object ... _p) {
    mVar pidField = m$.newVarRef("pidField",(((_p!=null)&&(_p.length>=1))?_p[0]:null),"");
    mVar pstrWidth = m$.newVarRef("pstrWidth",(((_p!=null)&&(_p.length>=2))?_p[1]:null),"");
    //<< ;-------------------------------------------------------------------------------
    //<< ; Called when a user modifies the with of a column, save again that user.
    //<< ;
    //<< ; History:
    //<< ; 12-Apr-2005   Paul K  Commented
    //<< ;-------------------------------------------------------------------------------
    //<< new idColumn,strWidth,objField,idClass,idView
    mVar idColumn = m$.var("idColumn");
    mVar strWidth = m$.var("strWidth");
    mVar objField = m$.var("objField");
    mVar idClass = m$.var("idClass");
    mVar idView = m$.var("idView");
    m$.newVar(idColumn,strWidth,objField,idClass,idView);
    //<< 
    //<< set idClass = $get(^CacheTempView(YUSER,"Class"))
    idClass.set(m$.Fnc.$get(m$.var("^CacheTempView",m$.var("YUSER").get(),"Class")));
    //<< if (pidField'="") && (pstrWidth'="") {
    if ((mOp.NotEqual(pidField.get(),"")) && (mOp.NotEqual(pstrWidth.get(),""))) {
      //<< set pidField = $piece(pidField,"head",2)
      pidField.set(m$.Fnc.$piece(pidField.get(),"head",2));
      //<< set idView   = $$GetCurrentView^COMView(idClass)
      idView.set(m$.fnc$("COMView.GetCurrentView",idClass.get()));
      //<< set $$$COMViewColumnUserWidth(^COMViewColumnUser(0,idClass,idView,YBED,pidField)) = pstrWidth
      include.COMConst.$$$COMViewColumnUserWidthSet(m$,m$.var("^COMViewColumnUser",0,idClass.get(),idView.get(),m$.var("YBED").get(),pidField.get()),pstrWidth.get());
    }
    //<< }
    //<< quit $$$OK
    return include.COMSYS.$$$OK(m$);
  }

  //<< 
  //<< 
  //<< GetSort(pidClass,pintDirection)
  public Object GetSort(Object ... _p) {
    mVar pidClass = m$.newVarRef("pidClass",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pintDirection = m$.newVarRef("pintDirection",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Return which field (if any) the user is currently sorting on.
    //<< ; N.B. pintDirection is passed by reference.
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 12-Apr-2005   Paul K  Commented
    //<< ;-------------------------------------------------------------------------------
    //<< new idField,idView
    mVar idField = m$.var("idField");
    mVar idView = m$.var("idView");
    m$.newVar(idField,idView);
    //<< 
    //<< set idView  = $$GetCurrentView^COMView(pidClass)
    idView.set(m$.fnc$("COMView.GetCurrentView",pidClass.get()));
    //<< set idField = ""
    idField.set("");
    //<< for {
    for (;true;) {
      //<< set idField = $order(^COMViewColumnUser(0,pidClass,idView,YBED,idField))
      idField.set(m$.Fnc.$order(m$.var("^COMViewColumnUser",0,pidClass.get(),idView.get(),m$.var("YBED").get(),idField.get())));
      //<< quit:idField=""
      if (mOp.Equal(idField.get(),"")) {
        break;
      }
      //<< 
      //<< set pintDirection = $$$COMViewColumnUserSort1($get(^COMViewColumnUser(0,pidClass,idView,YBED,idField)))
      pintDirection.set(include.COMConst.$$$COMViewColumnUserSort1(m$,m$.Fnc.$get(m$.var("^COMViewColumnUser",0,pidClass.get(),idView.get(),m$.var("YBED").get(),idField.get()))));
      //<< quit:pintDirection'=""
      if (mOp.NotEqual(pintDirection.get(),"")) {
        break;
      }
    }
    //<< }
    //<< 
    //<< quit idField
    return idField.get();
  }

  //<< 
  //<< 
  //<< SortColumn(pidField="",pintDirection="")
  public Object SortColumn(Object ... _p) {
    mVar pidField = m$.newVarRef("pidField",(((_p!=null)&&(_p.length>=1))?_p[0]:null),"");
    mVar pintDirection = m$.newVarRef("pintDirection",(((_p!=null)&&(_p.length>=2))?_p[1]:null),"");
    //<< ;-------------------------------------------------------------------------------
    //<< ; Called when the user clicks on a column header to sort by that column.
    //<< ; Refreshs the grid with that column sorted.
    //<< ;
    //<< ; Called by JS: SortColumn()
    //<< ;
    //<< ; History:
    //<< ; 01-Feb-2006   PO      SR13158: Allow for sorting to be turned off.
    //<< ; 12-Apr-2005   Paul K  Commented
    //<< ;-------------------------------------------------------------------------------
    //<< new objField,intSort,strClass,idField,idClass,intDirection,idView
    mVar objField = m$.var("objField");
    mVar intSort = m$.var("intSort");
    mVar strClass = m$.var("strClass");
    mVar idField = m$.var("idField");
    mVar idClass = m$.var("idClass");
    mVar intDirection = m$.var("intDirection");
    mVar idView = m$.var("idView");
    m$.newVar(objField,intSort,strClass,idField,idClass,intDirection,idView);
    //<< 
    //<< set idClass = $get(^CacheTempView(YUSER,"Class"))
    idClass.set(m$.Fnc.$get(m$.var("^CacheTempView",m$.var("YUSER").get(),"Class")));
    //<< 
    //<< if (idClass'="") && (pidField'="") {
    if ((mOp.NotEqual(idClass.get(),"")) && (mOp.NotEqual(pidField.get(),""))) {
      //<< set strClass = $$$Index(idClass)
      strClass.set(include.MEDConst.$$$Index(m$,idClass));
      //<< set idView   = $$GetCurrentView^COMView(idClass)
      idView.set(m$.fnc$("COMView.GetCurrentView",idClass.get()));
      //<< set idField  = $$GetSort(idClass,.intDirection)
      idField.set(m$.fnc$("GetSort",idClass.get(),intDirection));
      //<< 
      //<< if (idField=pidField) {
      if ((mOp.Equal(idField.get(),pidField.get()))) {
        //<< if pintDirection="" { // SR13158
        if (mOp.Equal(pintDirection.get(),"")) {
          //<< if intDirection = 1 {
          if (mOp.Equal(intDirection.get(),1)) {
            //<< set pintDirection = -1
            pintDirection.set(mOp.Negative(1));
          }
          //<< } elseif intDirection = -1 {
          else if (mOp.Equal(intDirection.get(),mOp.Negative(1))) {
            //<< if $$$COMViewColumnUserSort1($get(^COMViewColumnUser(0,idClass,idView,YBED,idField))) = "" {
            if (mOp.Equal(include.COMConst.$$$COMViewColumnUserSort1(m$,m$.Fnc.$get(m$.var("^COMViewColumnUser",0,idClass.get(),idView.get(),m$.var("YBED").get(),idField.get()))),"")) {
              //<< set pintDirection = 1
              pintDirection.set(1);
            }
            //<< } else {
            else {
              //<< set pintDirection = ""
              pintDirection.set("");
            }
          }
        }
        //<< }
        //<< }
        //<< }
        //<< set $$$COMViewColumnUserSort1(^COMViewColumnUser(0,idClass,idView,YBED,idField)) = pintDirection
        include.COMConst.$$$COMViewColumnUserSort1Set(m$,m$.var("^COMViewColumnUser",0,idClass.get(),idView.get(),m$.var("YBED").get(),idField.get()),pintDirection.get());
      }
      //<< 
      //<< } else {
      else {
        //<< if idField'="" {
        if (mOp.NotEqual(idField.get(),"")) {
          //<< set $$$COMViewColumnUserSort1(^COMViewColumnUser(0,idClass,idView,YBED,idField))=""
          include.COMConst.$$$COMViewColumnUserSort1Set(m$,m$.var("^COMViewColumnUser",0,idClass.get(),idView.get(),m$.var("YBED").get(),idField.get()),"");
        }
        //<< }
        //<< if pintDirection="" set pintDirection = 1
        if (mOp.Equal(pintDirection.get(),"")) {
          pintDirection.set(1);
        }
        //<< set $$$COMViewColumnUserSort1(^COMViewColumnUser(0,idClass,idView,YBED,pidField)) = pintDirection
        include.COMConst.$$$COMViewColumnUserSort1Set(m$,m$.var("^COMViewColumnUser",0,idClass.get(),idView.get(),m$.var("YBED").get(),pidField.get()),pintDirection.get());
      }
      //<< }
      //<< do DisplayHeader(idClass)
      m$.Cmd.Do("DisplayHeader",idClass.get());
      //<< do DisplayGrid^COMViewFilter()
      m$.Cmd.Do("COMViewFilter.DisplayGrid");
    }
    //<< }
    //<< quit $$$OK
    return include.COMSYS.$$$OK(m$);
  }

  //<< 
  //<< 
  //<< ColumnName(pidField="")
  public Object ColumnName(Object ... _p) {
    mVar pidField = m$.newVarRef("pidField",(((_p!=null)&&(_p.length>=1))?_p[0]:null),"");
    //<< ;-------------------------------------------------------------------------------
    //<< ; Sets the Column name, accessed by the function ColumnName
    //<< ; (right-click menu option on COMView col header)
    //<< ;
    //<< ; Inputs:pidField - Column
    //<< ;
    //<< ; Returns: OK
    //<< ;
    //<< ; History:
    //<< ; 11-Nov-2009   PPP     SR17025: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new idClass,idField,idForm,strCallback,strDesc,strPrompt
    mVar idClass = m$.var("idClass");
    mVar idField = m$.var("idField");
    mVar idForm = m$.var("idForm");
    mVar strCallback = m$.var("strCallback");
    mVar strDesc = m$.var("strDesc");
    mVar strPrompt = m$.var("strPrompt");
    m$.newVar(idClass,idField,idForm,strCallback,strDesc,strPrompt);
    //<< 
    //<< set idClass = $get(^CacheTempView(YUSER,"Class"))
    idClass.set(m$.Fnc.$get(m$.var("^CacheTempView",m$.var("YUSER").get(),"Class")));
    //<< 
    //<< //Only do Column Name Change for non - @NM classes ie Object Classes
    //<< if '$data(^WWW001(0,idClass)) {
    if (mOp.Not(m$.Fnc.$data(m$.var("^WWW001",0,idClass.get())))) {
      //<< set idForm  = $$GetClassForNestedField(idClass, pidField)
      idForm.set(m$.fnc$("GetClassForNestedField",idClass.get(),pidField.get()));
      //<< set idField = $piece(pidField,"->",$length(pidField,"->"))
      idField.set(m$.Fnc.$piece(pidField.get(),"->",m$.Fnc.$length(pidField.get(),"->")));
      //<< set strDesc = $$GetCustomisedText^WWWClassTranslation(idForm,idField)
      strDesc.set(m$.fnc$("WWWClassTranslation.GetCustomisedText",idForm.get(),idField.get()));
      //<< 
      //<< //  set strPrompt   = $$$JSText($$$Text($lb("IN01150",idForm_":"_idField)))
      //<< set strPrompt   = $$$JSText($$$Text($lb("IN01150",idField)))
      strPrompt.set(include.COMSYSString.$$$JSText(m$,include.COMSYS.$$$Text(m$,m$.Fnc.$listbuild("IN01150",idField.get()))));
      //<< set strDesc     = $$$JSText(strDesc)
      strDesc.set(include.COMSYSString.$$$JSText(m$,strDesc));
      //<< set strCallback = "SetColumnName^COMViewFilterColumn"
      strCallback.set("SetColumnName^COMViewFilterColumn");
      //<< 
      //<< &js<
      //<< var strResult=prompt('#(strPrompt)#','#(strDesc)#','');
      //<< if (strResult!=null) CallBackNow('#(strCallback)#','#(idClass)#','#(idForm)#','#(idField)#',strResult);
      //<< >
      m$.Cmd.WriteJS("","\n");
      m$.Cmd.WriteJS(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("            var strResult=prompt('",(strPrompt.get())),"','"),(strDesc.get())),"','');"),"\n");
      m$.Cmd.WriteJS(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("            if (strResult!=null) CallBackNow('",(strCallback.get())),"','"),(idClass.get())),"','"),(idForm.get())),"','"),(idField.get())),"',strResult);"),"\n");
      m$.Cmd.WriteJS("        ");
    }
    //<< 
    //<< }
    //<< quit $$$OK
    return include.COMSYS.$$$OK(m$);
  }

  //<< 
  //<< 
  //<< SetColumnName(pidClass,pidForm,pidField,pstrName)
  public Object SetColumnName(Object ... _p) {
    mVar pidClass = m$.newVarRef("pidClass",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pidForm = m$.newVarRef("pidForm",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pidField = m$.newVarRef("pidField",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    mVar pstrName = m$.newVarRef("pstrName",(((_p!=null)&&(_p.length>=4))?_p[3]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Called by Callback from ColumnName subroutine after input from the User
    //<< ;
    //<< ; Inputs:
    //<< ;  pidClass - Class Name
    //<< ;  pidForm  - Form Name
    //<< ;  pidField - Column Name
    //<< ;  pstrName - Column Description defined by User
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 11-Nov-2009   PP      SR17025: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new objWWW122D,strKey,strStatus
    mVar objWWW122D = m$.var("objWWW122D");
    mVar strKey = m$.var("strKey");
    mVar strStatus = m$.var("strStatus");
    m$.newVar(objWWW122D,strKey,strStatus);
    //<< 
    //<< if $get(pstrName)'="" {
    if (mOp.NotEqual(m$.Fnc.$get(pstrName),"")) {
      //<< set objWWW122D = $get(^WWW122D(0,pidForm,pidField,0,1))
      objWWW122D.set(m$.Fnc.$get(m$.var("^WWW122D",0,pidForm.get(),pidField.get(),0,1)));
      //<< set $$$WWW122DFieldDescription(objWWW122D) = pstrName
      include.WWWConst.$$$WWW122DFieldDescriptionSet(m$,objWWW122D,pstrName.get());
      //<< set strKey    = pidForm_","_pidField_","_0
      strKey.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(pidForm.get(),","),pidField.get()),","),0));
      //<< set strStatus = $$$Save("WWW122D",strKey,objWWW122D,1)
      strStatus.set(include.COMSYS.$$$Save(m$,"WWW122D",strKey,objWWW122D,1));
    }
    //<< 
    //<< } else {
    else {
      //<< set strKey    = pidForm_","_pidField_","_0
      strKey.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(pidForm.get(),","),pidField.get()),","),0));
      //<< set strStatus = $$$Kill("WWW122D",strKey)
      strStatus.set(include.COMSYS.$$$Kill(m$,"WWW122D",strKey));
    }
    //<< }
    //<< 
    //<< do DisplayHeader(pidClass)
    m$.Cmd.Do("DisplayHeader",pidClass.get());
    //<< do DisplayGrid^COMViewFilter()
    m$.Cmd.Do("COMViewFilter.DisplayGrid");
    //<< 
    //<< quit $$$OK
    return include.COMSYS.$$$OK(m$);
  }

  //<< 
  //<< 
  //<< SwapColumns(pidSource="",pidDest="")
  public Object SwapColumns(Object ... _p) {
    mVar pidSource = m$.newVarRef("pidSource",(((_p!=null)&&(_p.length>=1))?_p[0]:null),"");
    mVar pidDest = m$.newVarRef("pidDest",(((_p!=null)&&(_p.length>=2))?_p[1]:null),"");
    //<< ;-------------------------------------------------------------------------------
    //<< ; Called when a user moves a column from one position to another. Refreshes the grid
    //<< ;
    //<< ; Called by JS: endDragColumn()
    //<< ;
    //<< ; History:
    //<< ; 12-Apr-2005   Paul K  Commented
    //<< ;-------------------------------------------------------------------------------
    //<< new idClass,objSource,objDest,lstColumns,ColumnLoop,idField,idView
    mVar idClass = m$.var("idClass");
    mVar objSource = m$.var("objSource");
    mVar objDest = m$.var("objDest");
    mVar lstColumns = m$.var("lstColumns");
    mVar ColumnLoop = m$.var("ColumnLoop");
    mVar idField = m$.var("idField");
    mVar idView = m$.var("idView");
    m$.newVar(idClass,objSource,objDest,lstColumns,ColumnLoop,idField,idView);
    //<< 
    //<< set idClass = $get(^CacheTempView(YUSER,"Class"))
    idClass.set(m$.Fnc.$get(m$.var("^CacheTempView",m$.var("YUSER").get(),"Class")));
    //<< set idView  = $$GetCurrentView^COMView(idClass)
    idView.set(m$.fnc$("COMView.GetCurrentView",idClass.get()));
    //<< 
    //<< set pidSource = $piece(pidSource,"head",2)
    pidSource.set(m$.Fnc.$piece(pidSource.get(),"head",2));
    //<< set pidDest   = $piece(pidDest,"head",2)
    pidDest.set(m$.Fnc.$piece(pidDest.get(),"head",2));
    //<< 
    //<< if (idClass'="") && (pidSource'="") && (pidDest'="") {
    if ((mOp.NotEqual(idClass.get(),"")) && (mOp.NotEqual(pidSource.get(),"")) && (mOp.NotEqual(pidDest.get(),""))) {
      //<< set lstColumns = $$GetColumns(idClass,idView,0)
      lstColumns.set(m$.fnc$("GetColumns",idClass.get(),idView.get(),0));
      //<< 
      //<< if $listfind(lstColumns,pidSource)>$listfind(lstColumns,pidDest) {
      if (mOp.Greater(m$.Fnc.$listfind(lstColumns.get(),pidSource.get()),m$.Fnc.$listfind(lstColumns.get(),pidDest.get()))) {
        //<< set lstColumns = $list(lstColumns,1,$listfind(lstColumns,pidSource)-1)_$list(lstColumns,$listfind(lstColumns,pidSource)+1,$listlength(lstColumns))  ;remove source
        lstColumns.set(mOp.Concat(m$.Fnc.$list(lstColumns.get(),1,mOp.Subtract(m$.Fnc.$listfind(lstColumns.get(),pidSource.get()),1)),m$.Fnc.$list(lstColumns.get(),mOp.Add(m$.Fnc.$listfind(lstColumns.get(),pidSource.get()),1),m$.Fnc.$listlength(lstColumns.get()))));
        //<< set lstColumns = $list(lstColumns,1,$listfind(lstColumns,pidDest)-1)_$listbuild(pidSource)_$list(lstColumns,$listfind(lstColumns,pidDest),$listlength(lstColumns))  ;add in right spot
        lstColumns.set(mOp.Concat(mOp.Concat(m$.Fnc.$list(lstColumns.get(),1,mOp.Subtract(m$.Fnc.$listfind(lstColumns.get(),pidDest.get()),1)),m$.Fnc.$listbuild(pidSource.get())),m$.Fnc.$list(lstColumns.get(),m$.Fnc.$listfind(lstColumns.get(),pidDest.get()),m$.Fnc.$listlength(lstColumns.get()))));
      }
      //<< 
      //<< } else {
      else {
        //<< set lstColumns = $list(lstColumns,1,$listfind(lstColumns,pidSource)-1)_$list(lstColumns,$listfind(lstColumns,pidSource)+1,$listlength(lstColumns))  ;remove source
        lstColumns.set(mOp.Concat(m$.Fnc.$list(lstColumns.get(),1,mOp.Subtract(m$.Fnc.$listfind(lstColumns.get(),pidSource.get()),1)),m$.Fnc.$list(lstColumns.get(),mOp.Add(m$.Fnc.$listfind(lstColumns.get(),pidSource.get()),1),m$.Fnc.$listlength(lstColumns.get()))));
        //<< set lstColumns = $list(lstColumns,1,$listfind(lstColumns,pidDest))_$listbuild(pidSource)_$list(lstColumns,$listfind(lstColumns,pidDest)+1,$listlength(lstColumns))  ;add in right spot
        lstColumns.set(mOp.Concat(mOp.Concat(m$.Fnc.$list(lstColumns.get(),1,m$.Fnc.$listfind(lstColumns.get(),pidDest.get())),m$.Fnc.$listbuild(pidSource.get())),m$.Fnc.$list(lstColumns.get(),mOp.Add(m$.Fnc.$listfind(lstColumns.get(),pidDest.get()),1),m$.Fnc.$listlength(lstColumns.get()))));
      }
      //<< }
      //<< 
      //<< for ColumnLoop=1:1:$listlength(lstColumns) {
      for (ColumnLoop.set(1);(mOp.LessOrEqual(ColumnLoop.get(),m$.Fnc.$listlength(lstColumns.get())));ColumnLoop.set(mOp.Add(ColumnLoop.get(),1))) {
        //<< set idField = $listget(lstColumns,ColumnLoop)
        idField.set(m$.Fnc.$listget(lstColumns.get(),ColumnLoop.get()));
        //<< set $$$COMViewColumnUserColumn1(^COMViewColumnUser(0,idClass,idView,YBED,idField)) = ColumnLoop
        include.COMConst.$$$COMViewColumnUserColumn1Set(m$,m$.var("^COMViewColumnUser",0,idClass.get(),idView.get(),m$.var("YBED").get(),idField.get()),ColumnLoop.get());
      }
      //<< }
      //<< do DisplayHeader(idClass)
      m$.Cmd.Do("DisplayHeader",idClass.get());
      //<< do DisplayGrid^COMViewFilter()
      m$.Cmd.Do("COMViewFilter.DisplayGrid");
    }
    //<< }
    //<< quit $$$OK
    return include.COMSYS.$$$OK(m$);
  }

  //<< 
  //<< 
  //<< GetClassForNestedField(pidClass,pidField)
  public Object GetClassForNestedField(Object ... _p) {
    mVar pidClass = m$.newVarRef("pidClass",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pidField = m$.newVarRef("pidField",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Get Class For Nested Field
    //<< ; for e.g.  alSOH.dPeriodBalance,Item->ItemPolicy->StorageType = alLOC.dStorageType
    //<< ;
    //<< ; Inputs:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 27-Jul-2011   shobby  SR17788:
    //<< ; 01-Dec-2009   PPP     SR17025: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new idClass,idField,idFieldClass,intCnt
    mVar idClass = m$.var("idClass");
    mVar idField = m$.var("idField");
    mVar idFieldClass = m$.var("idFieldClass");
    mVar intCnt = m$.var("intCnt");
    m$.newVar(idClass,idField,idFieldClass,intCnt);
    //<< 
    //<< set idClass = pidClass
    idClass.set(pidClass.get());
    //<< 
    //<< if $find(pidField,"->") { ;SR17788
    if (mOp.Logical(m$.Fnc.$find(pidField.get(),"->"))) {
      //<< for intCnt = 1:1:$length(pidField,"->") {
      for (intCnt.set(1);(mOp.LessOrEqual(intCnt.get(),m$.Fnc.$length(pidField.get(),"->")));intCnt.set(mOp.Add(intCnt.get(),1))) {
        //<< set idField      = $piece(pidField,"->",intCnt)
        idField.set(m$.Fnc.$piece(pidField.get(),"->",intCnt.get()));
        //<< set idFieldClass = $$GetClass^COMViewObject(idClass,idField)    //alLOC.dStorage
        idFieldClass.set(m$.fnc$("COMViewObject.GetClass",idClass.get(),idField.get()));
        //<< set idClass      = idFieldClass
        idClass.set(idFieldClass.get());
      }
    }
    //<< }
    //<< }
    //<< quit idClass
    return idClass.get();
  }

//<< 
//<< 
//<< 
}
