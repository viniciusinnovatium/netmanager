//*****************************************************************************
//** TASC - ALPHALINC - MAC COMViewFilterCombo
//** Innovatium Systems - Code Converter - v1.30
//** 2014-07-07 18:29:52
//*****************************************************************************

import mLibrary.*;

//<< ;-------------------------------------------------------------------------------
//<< ; creates relation combos for COMView
//<< ;-------------------------------------------------------------------------------
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

//<< COMViewFilterCombo
public class COMViewFilterCombo extends mClass {

  //<< 
  //<< #define DefaultRecords 300
  public static Object $$$DefaultRecords(mContext m$) {
    return (300);
  }

  public void main() {
    _COMViewFilterCombo();
  }

  public void _COMViewFilterCombo() {
  }

  //<< 
  //<< CreateCombo(pidClass,pidFilter,pobjFld)
  public Object CreateCombo(Object ... _p) {
    mVar pidClass = m$.newVarRef("pidClass",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pidFilter = m$.newVarRef("pidFilter",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pobjFld = m$.newVarRef("pobjFld",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Creates a combo box on the screen if less than 200 entries for a relation
    //<< ; otherwise puts in a text box with search button to drill down further.
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 21-Apr-2011   GRF     -: Get strSortCodes once
    //<< ; 07-Jan-2011   GRF     SR17579: Use explicit tag for WWWTR calls
    //<< ; 05-Jan-2010   GRF     SR15525: Call to $$Convert^WWWTR rather than $$^WWWTR
    //<< ; 17-Sep-2009   shobby  SR16708: Removed changes from 16521
    //<< ; 02-Jul-2009   PPP     SR16663: Add the Calculated Relation Display Fields
    //<< ; 06-May-2009   PPP     SR16521: Barcodes scanned to get Item
    //<< ;                           Create TextBox with OnBlur event if relation class
    //<< ;                           or class is a Quick Search Class
    //<< ; 01-Sep-2008   shobby  SRBR014976: Set the FontFace as per company settings.
    //<< ; 12-Feb-2008   shobby  SRBR014896: Limit the size of a line in a combo box.
    //<< ; 11-Feb-2008   shobby  SRBR014896: Don't use a combo box if property is marked
    //<< ; 31-Jul-2007   Karine  SR15548: Filter in DataAccess
    //<< ; 19-Aug-2006   RPW     SR14360: Handle """" not just an empty string
    //<< ; 15-Aug-2006   RPW     SR14807: quit if we are getting null relationships
    //<< ; 15-Mar-2004   PaulK   Added macro usage
    //<< ; 25-Nov-2004   PaulK   Created
    //<< ;-------------------------------------------------------------------------------
    //<< new blnDataAccess,blnInvalid,idClass,idRef,intCount,Loop,objFilter,objRef
    mVar blnDataAccess = m$.var("blnDataAccess");
    mVar blnInvalid = m$.var("blnInvalid");
    mVar idClass = m$.var("idClass");
    mVar idRef = m$.var("idRef");
    mVar intCount = m$.var("intCount");
    mVar Loop = m$.var("Loop");
    mVar objFilter = m$.var("objFilter");
    mVar objRef = m$.var("objRef");
    m$.newVar(blnDataAccess,blnInvalid,idClass,idRef,intCount,Loop,objFilter,objRef);
    //<< new strCalcRelationItems,strDisplay,strDefault,strGlobal,strJS,strPiece
    mVar strCalcRelationItems = m$.var("strCalcRelationItems");
    mVar strDisplay = m$.var("strDisplay");
    mVar strDefault = m$.var("strDefault");
    mVar strGlobal = m$.var("strGlobal");
    mVar strJS = m$.var("strJS");
    mVar strPiece = m$.var("strPiece");
    m$.newVar(strCalcRelationItems,strDisplay,strDefault,strGlobal,strJS,strPiece);
    //<< new strQuery,strRef,strRelation,strRelationItems,strSortCodes
    mVar strQuery = m$.var("strQuery");
    mVar strRef = m$.var("strRef");
    mVar strRelation = m$.var("strRelation");
    mVar strRelationItems = m$.var("strRelationItems");
    mVar strSortCodes = m$.var("strSortCodes");
    m$.newVar(strQuery,strRef,strRelation,strRelationItems,strSortCodes);
    //<< 
    //<< set blnDataAccess = $$$YES
    blnDataAccess.set(include.COMSYS.$$$YES(m$));
    //<< set blnInvalid    = $$$NO
    blnInvalid.set(include.COMSYS.$$$NO(m$));
    //<< 
    //<< set idClass   = $$$WWW002RelationClass(pobjFld)
    idClass.set(include.WWWConst.$$$WWW002RelationClass(m$,pobjFld));
    //<< set objFilter = $get(^CacheTempView(YUSER,"Filter",pidFilter))
    objFilter.set(m$.Fnc.$get(m$.var("^CacheTempView",m$.var("YUSER").get(),"Filter",pidFilter.get())));
    //<< 
    //<< set strQuery  = "^"_idClass
    strQuery.set(mOp.Concat("^",idClass.get()));
    //<< if $$$WWW002DisplayIfSortKeyEqual(pobjFld) set strQuery = strQuery_"s"
    if (mOp.Logical(include.WWWConst.$$$WWW002DisplayIfSortKeyEqual(m$,pobjFld))) {
      strQuery.set(mOp.Concat(strQuery.get(),"s"));
    }
    //<< set strQuery = strQuery_"("_$select($$$WWW001SharedFile($get(^WWW001(0,idClass,1))):0,1:YM) ; FIXME : YM Deprecated
    strQuery.set(mOp.Concat(mOp.Concat(strQuery.get(),"("),m$.Fnc.$select(include.WWWConst.$$$WWW001SharedFile(m$,m$.Fnc.$get(m$.var("^WWW001",0,idClass.get(),1))),0,1,m$.var("YM").get())));
    //<< 
    //<< set strSortCodes = $$$WWW002DisplayIfSortKeyEqual(pobjFld)
    strSortCodes.set(include.WWWConst.$$$WWW002DisplayIfSortKeyEqual(m$,pobjFld));
    //<< if strSortCodes'="" {
    if (mOp.NotEqual(strSortCodes.get(),"")) {
      //<< for Loop=1:1:$length(strSortCodes,",") {
      for (Loop.set(1);(mOp.LessOrEqual(Loop.get(),m$.Fnc.$length(strSortCodes.get(),",")));Loop.set(mOp.Add(Loop.get(),1))) {
        //<< quit:+$piece(strSortCodes,",",Loop)'=$piece(strSortCodes,",",Loop)
        if (mOp.NotEqual(mOp.Positive(m$.Fnc.$piece(strSortCodes.get(),",",Loop.get())),m$.Fnc.$piece(strSortCodes.get(),",",Loop.get()))) {
          break;
        }
        //<< 
        //<< set strPiece = $$$AddQuotes($piece(strSortCodes,",",Loop))
        strPiece.set(include.COMSYS.$$$AddQuotes(m$,m$.Fnc.$piece(strSortCodes.get(),",",Loop.get())));
        //<< if strPiece="" {
        if (mOp.Equal(strPiece.get(),"")) {
          //<< set blnInvalid = $$$YES
          blnInvalid.set(include.COMSYS.$$$YES(m$));
          //<< quit
          break;
        }
        //<< }
        //<< set strQuery = strQuery_","_strPiece
        strQuery.set(mOp.Concat(mOp.Concat(strQuery.get(),","),strPiece.get()));
      }
    }
    //<< }
    //<< }
    //<< if $$$WWW002RelationalPrimaryKeys(pobjFld)'="" {
    if (mOp.NotEqual(include.WWWConst.$$$WWW002RelationalPrimaryKeys(m$,pobjFld),"")) {
      //<< for Loop=1:1:$length($$$WWW002RelationalPrimaryKeys(pobjFld),",") {
      for (Loop.set(1);(mOp.LessOrEqual(Loop.get(),m$.Fnc.$length(include.WWWConst.$$$WWW002RelationalPrimaryKeys(m$,pobjFld),",")));Loop.set(mOp.Add(Loop.get(),1))) {
        //<< set strRelation = $piece($$$WWW002RelationalPrimaryKeys(pobjFld),",",Loop)
        strRelation.set(m$.Fnc.$piece(include.WWWConst.$$$WWW002RelationalPrimaryKeys(m$,pobjFld),",",Loop.get()));
        //<< if (+strRelation'=strRelation) && '$find(strRelation,"""") {
        if ((mOp.NotEqual(mOp.Positive(strRelation.get()),strRelation.get())) && mOp.Not(m$.Fnc.$find(strRelation.get(),"\""))) {
          //<< if '$data(@strRelation) {
          if (mOp.Not(m$.Fnc.$data(m$.indirectVar(strRelation.get())))) {
            //<< do FindRelation^COMViewUtils(idClass,strRelation,$get(^CacheTempView(YUSER,"RelationKey")))
            m$.Cmd.Do("COMViewUtils.FindRelation",idClass.get(),strRelation.get(),m$.Fnc.$get(m$.var("^CacheTempView",m$.var("YUSER").get(),"RelationKey")));
          }
          //<< }
          //<< set strRelation = $$$AddQuotes($get(@strRelation))
          strRelation.set(include.COMSYS.$$$AddQuotes(m$,m$.Fnc.$get(m$.indirectVar(strRelation.get()))));
        }
        //<< }
        //<< if (strRelation="") || (strRelation="""""") {
        if ((mOp.Equal(strRelation.get(),"")) || (mOp.Equal(strRelation.get(),"\"\""))) {
          //<< set blnInvalid = $$$YES
          blnInvalid.set(include.COMSYS.$$$YES(m$));
          //<< quit
          break;
        }
        //<< }
        //<< set strQuery = strQuery_","_strRelation
        strQuery.set(mOp.Concat(mOp.Concat(strQuery.get(),","),strRelation.get()));
      }
    }
    //<< }
    //<< }
    //<< 
    //<< quit:blnInvalid
    if (mOp.Logical(blnInvalid.get())) {
      return null;
    }
    //<< 
    //<< set strGlobal = strQuery_")"
    strGlobal.set(mOp.Concat(strQuery.get(),")"));
    //<< set intCount  = 0
    intCount.set(0);
    //<< set strJS = ""
    strJS.set("");
    //<< set strJS = strJS_"var s = document.createElement('select');"
    strJS.set(mOp.Concat(strJS.get(),"var s = document.createElement('select');"));
    //<< set strJS = strJS_"s.attachEvent('onchange',ControlChanged);"
    strJS.set(mOp.Concat(strJS.get(),"s.attachEvent('onchange',ControlChanged);"));
    //<< set strJS = strJS_"s.style.fontFamily='"_$$FontFace^WWW012()_"';" ;BR014976
    strJS.set(mOp.Concat(mOp.Concat(mOp.Concat(strJS.get(),"s.style.fontFamily='"),m$.fnc$("WWW012.FontFace")),"';"));
    //<< set strJS = strJS_"s.id='value"_pidFilter_"';"
    strJS.set(mOp.Concat(mOp.Concat(mOp.Concat(strJS.get(),"s.id='value"),pidFilter.get()),"';"));
    //<< if $$$COMViewFilterComparator(objFilter)=$$$EnumCOMVIEWCOMPARATORWithin {
    if (mOp.Equal(include.COMConst.$$$COMViewFilterComparator(m$,objFilter),include.COMConst.$$$EnumCOMVIEWCOMPARATORWithin(m$))) {
      //<< set strJS = strJS_"s.multiple=true;"
      strJS.set(mOp.Concat(strJS.get(),"s.multiple=true;"));
      //<< set strJS = strJS_"s.size='5';"
      strJS.set(mOp.Concat(strJS.get(),"s.size='5';"));
    }
    //<< }
    //<< set strJS = strJS_"var o = document.createElement('option');"
    strJS.set(mOp.Concat(strJS.get(),"var o = document.createElement('option');"));
    //<< set strJS = strJS_"o.value='';"
    strJS.set(mOp.Concat(strJS.get(),"o.value='';"));
    //<< set strJS = strJS_"s.appendChild(o);"
    strJS.set(mOp.Concat(strJS.get(),"s.appendChild(o);"));
    //<< 
    //<< set strRelationItems     = $$$WWW002RelationalDisplayItems(pobjFld)
    strRelationItems.set(include.WWWConst.$$$WWW002RelationalDisplayItems(m$,pobjFld));
    //<< set strCalcRelationItems = $$$WWW003CalcRelationalDisplayItems(pobjFld)
    strCalcRelationItems.set(include.WWWConst.$$$WWW003CalcRelationalDisplayItems(m$,pobjFld));
    //<< 
    //<< for {
    for (;true;) {
      //<< set strGlobal = $query(@strGlobal)
      strGlobal.set(m$.Fnc.$query(m$.indirectVar(strGlobal.get())));
      //<< quit:$extract(strGlobal,1,$length(strQuery))'=strQuery
      if (mOp.NotEqual(m$.Fnc.$extract(strGlobal.get(),1,m$.Fnc.$length(strQuery.get())),strQuery.get())) {
        break;
      }
      //<< 
      //<< set idRef = $qsubscript(strGlobal,$qlength(strGlobal)-($$$WWW002DisplayIfSortKeyEqual(pobjFld)=""))
      idRef.set(m$.Fnc.$qsubscript(strGlobal.get(),mOp.Subtract(m$.Fnc.$qlength(strGlobal.get()),(mOp.Equal(include.WWWConst.$$$WWW002DisplayIfSortKeyEqual(m$,pobjFld),"")))));
      //<< 
      //<< ;Check the DataAccess for the field
      //<< if $$$COMViewFilterDataAccess(objFilter)'="" {
      if (mOp.NotEqual(include.COMConst.$$$COMViewFilterDataAccess(m$,objFilter),"")) {
        //<< xecute "set blnDataAccess="_$$$COMViewFilterDataAccess(objFilter)
        m$.Cmd.Xecute(mOp.Concat("set blnDataAccess=",include.COMConst.$$$COMViewFilterDataAccess(m$,objFilter)));
      }
      //<< 
      //<< } else {
      else {
        //<< set blnDataAccess = $$$YES
        blnDataAccess.set(include.COMSYS.$$$YES(m$));
      }
      //<< }
      //<< continue:'blnDataAccess
      if (mOp.Not(blnDataAccess.get())) {
        continue;
      }
      //<< 
      //<< if $$$WWW002DisplayIfSortKeyEqual(pobjFld)'="" {
      if (mOp.NotEqual(include.WWWConst.$$$WWW002DisplayIfSortKeyEqual(m$,pobjFld),"")) {
        //<< set objRef = $get(@$$GetGlobal(strGlobal))
        objRef.set(m$.Fnc.$get(m$.indirectVar(m$.fnc$("GetGlobal",strGlobal.get()))));
      }
      //<< } else {
      else {
        //<< set objRef = $get(@strGlobal)
        objRef.set(m$.Fnc.$get(m$.indirectVar(strGlobal.get())));
      }
      //<< }
      //<< set strRef = $$GetLiteral^WWWTR($$$WWW003InputType(pobjFld),idRef)
      strRef.set(m$.fnc$("WWWTR.GetLiteral",include.WWWConst.$$$WWW003InputType(m$,pobjFld),idRef.get()));
      //<< 
      //<< if (strCalcRelationItems'="") {   ; SR16663
      if ((mOp.NotEqual(strCalcRelationItems.get(),""))) {
        //<< for Loop=1:1:$length(strRelationItems,";") {
        for (Loop.set(1);(mOp.LessOrEqual(Loop.get(),m$.Fnc.$length(strRelationItems.get(),";")));Loop.set(mOp.Add(Loop.get(),1))) {
          //<< if Loop=1 {
          if (mOp.Equal(Loop.get(),1)) {
            //<< set strRef = strRef_" - "
            strRef.set(mOp.Concat(strRef.get()," - "));
          }
          //<< } else {
          else {
            //<< set strRef = strRef_" "
            strRef.set(mOp.Concat(strRef.get()," "));
          }
          //<< }
          //<< set strRef = strRef_" "_$$GetCalculatedValue^WWWFOR71($$$WWW002RelationClass(pobjFld),
          //<< $piece(strCalcRelationItems,";",Loop),
          //<< $$$WWW002RelationalPrimaryKeys(pobjFld)_","_idRef,
          //<< objRef)
          strRef.set(mOp.Concat(mOp.Concat(strRef.get()," "),m$.fnc$("WWWFOR71.GetCalculatedValue",include.WWWConst.$$$WWW002RelationClass(m$,pobjFld),m$.Fnc.$piece(strCalcRelationItems.get(),";",Loop.get()),mOp.Concat(mOp.Concat(include.WWWConst.$$$WWW002RelationalPrimaryKeys(m$,pobjFld),","),idRef.get()),objRef.get())));
        }
      }
      //<< }
      //<< 
      //<< } else {
      else {
        //<< if (strRelationItems="") set strRelationItems = 1  ;show something from relation class!!
        if ((mOp.Equal(strRelationItems.get(),""))) {
          strRelationItems.set(1);
        }
        //<< for Loop=1:1:$length(strRelationItems,";") {
        for (Loop.set(1);(mOp.LessOrEqual(Loop.get(),m$.Fnc.$length(strRelationItems.get(),";")));Loop.set(mOp.Add(Loop.get(),1))) {
          //<< if Loop=1 {
          if (mOp.Equal(Loop.get(),1)) {
            //<< set strRef = strRef_" - "
            strRef.set(mOp.Concat(strRef.get()," - "));
          }
          //<< } else {
          else {
            //<< set strRef = strRef_" "
            strRef.set(mOp.Concat(strRef.get()," "));
          }
          //<< }
          //<< set strRef = strRef_$piece(objRef,Y,$piece(strRelationItems,";",Loop))
          strRef.set(mOp.Concat(strRef.get(),m$.Fnc.$piece(objRef.get(),m$.var("Y").get(),m$.Fnc.$piece(strRelationItems.get(),";",Loop.get()))));
        }
      }
      //<< }
      //<< }
      //<< 
      //<< set strJS = strJS_"var o = document.createElement('option');"
      strJS.set(mOp.Concat(strJS.get(),"var o = document.createElement('option');"));
      //<< set strJS = strJS_"o.value='"_$zcvt(idRef,"o","JS")_"';"
      strJS.set(mOp.Concat(mOp.Concat(mOp.Concat(strJS.get(),"o.value='"),m$.Fnc.$zconvert(idRef.get(),"o","JS")),"';"));
      //<< if $find(","_$$$COMViewFilterValue1(objFilter)_",",","_idRef_",") {
      if (mOp.Logical(m$.Fnc.$find(mOp.Concat(mOp.Concat(",",include.COMConst.$$$COMViewFilterValue1(m$,objFilter)),","),mOp.Concat(mOp.Concat(",",idRef.get()),",")))) {
        //<< set strJS = strJS_"o.selected=true;"
        strJS.set(mOp.Concat(strJS.get(),"o.selected=true;"));
      }
      //<< }
      //<< set strJS = strJS_"o.innerHTML='"_$zcvt($extract(strRef,1,40),"o","JS")_"';"
      strJS.set(mOp.Concat(mOp.Concat(mOp.Concat(strJS.get(),"o.innerHTML='"),m$.Fnc.$zconvert(m$.Fnc.$extract(strRef.get(),1,40),"o","JS")),"';"));
      //<< if ((idClass="WWW101") || (idClass="INPARA")) && ($$$WWW101ColorCode(objRef)'="") {
      if (mOp.Logical(((mOp.Equal(idClass.get(),"WWW101")) || (mOp.Equal(idClass.get(),"INPARA")))) && (mOp.NotEqual(include.WWWConst.$$$WWW101ColorCode(m$,objRef),""))) {
        //<< set strJS=strJS_"o.style.backgroundColor='"_$$$Colour($$$WWW101ColorCode(objRef))_"';"
        strJS.set(mOp.Concat(mOp.Concat(mOp.Concat(strJS.get(),"o.style.backgroundColor='"),include.COMSYS.$$$Colour(m$,include.WWWConst.$$$WWW101ColorCode(m$,objRef))),"';"));
      }
      //<< }
      //<< set strJS=strJS_"s.appendChild(o);"
      strJS.set(mOp.Concat(strJS.get(),"s.appendChild(o);"));
      //<< set intCount=intCount+1
      intCount.set(mOp.Add(intCount.get(),1));
      //<< quit:intCount>$$$DefaultRecords
      if (mOp.Greater(intCount.get(),$$$DefaultRecords(m$))) {
        break;
      }
      //<< quit:$length(strJS)>32000
      if (mOp.Greater(m$.Fnc.$length(strJS.get()),32000)) {
        break;
      }
    }
    //<< }
    //<< 
    //<< ;if (intCount<=$$$DefaultRecords) && ($length(strJS)<=32000) {                              ;BR014896
    //<< ;  1 : "Display Relations After Input"
    //<< if (intCount<=$$$DefaultRecords) && ($length(strJS)<=32000) && ($$$WWW002RelationDisplayOptions(pobjFld)'=1) {  ;BR014896
    if ((mOp.LessOrEqual(intCount.get(),$$$DefaultRecords(m$))) && (mOp.LessOrEqual(m$.Fnc.$length(strJS.get()),32000)) && (mOp.NotEqual(include.WWWConst.$$$WWW002RelationDisplayOptions(m$,pobjFld),1))) {
      //<< set strDefault=$$DefaultValue(idClass,$$$WWW002RelationalPrimaryKeys(pobjFld),1,.strDisplay)
      strDefault.set(m$.fnc$("DefaultValue",idClass.get(),include.WWWConst.$$$WWW002RelationalPrimaryKeys(m$,pobjFld),1,strDisplay));
      //<< if strDefault'="" {
      if (mOp.NotEqual(strDefault.get(),"")) {
        //<< set strJS=strJS_"var o = document.createElement('option');"
        strJS.set(mOp.Concat(strJS.get(),"var o = document.createElement('option');"));
        //<< set strJS=strJS_"o.value='"_$zcvt(strDefault,"o","JS")_"';"
        strJS.set(mOp.Concat(mOp.Concat(mOp.Concat(strJS.get(),"o.value='"),m$.Fnc.$zconvert(strDefault.get(),"o","JS")),"';"));
        //<< if $find(","_$$$COMViewFilterValue1(objFilter)_",",","_strDefault_",") {
        if (mOp.Logical(m$.Fnc.$find(mOp.Concat(mOp.Concat(",",include.COMConst.$$$COMViewFilterValue1(m$,objFilter)),","),mOp.Concat(mOp.Concat(",",strDefault.get()),",")))) {
          //<< set strJS=strJS_"o.selected='true';"
          strJS.set(mOp.Concat(strJS.get(),"o.selected='true';"));
        }
        //<< }
        //<< set strJS=strJS_"o.innerHTML='"_$zcvt(strDisplay,"o","JS")_"';"
        strJS.set(mOp.Concat(mOp.Concat(mOp.Concat(strJS.get(),"o.innerHTML='"),m$.Fnc.$zconvert(strDisplay.get(),"o","JS")),"';"));
        //<< set strJS=strJS_"s.appendChild(o);"
        strJS.set(mOp.Concat(strJS.get(),"s.appendChild(o);"));
      }
      //<< }
      //<< write strJS
      m$.Cmd.Write(strJS.get());
      //<< ;SR17396 write "ctrl"_pidFilter_"_3.appendChild(s);"
      //<< write "document.getElementById('ctrl"_pidFilter_"_3').appendChild(s);"  ;SR17396
      m$.Cmd.Write(mOp.Concat(mOp.Concat("document.getElementById('ctrl",pidFilter.get()),"_3').appendChild(s);"));
      //<< ;   write "s.value='"_$$$COMViewFilterValue1(objFilter)_"';"
      //<< write "s.initialValue='"_$$$COMViewFilterValue1(objFilter)_"';"
      m$.Cmd.Write(mOp.Concat(mOp.Concat("s.initialValue='",include.COMConst.$$$COMViewFilterValue1(m$,objFilter)),"';"));
    }
    //<< ;   write "s.options[0].selected=true;"
    //<< 
    //<< } else {
    else {
      //<< ;too many items to successfully fit into a combo. create separate control.
      //<< do CreateText^COMViewFilterControl(pidClass,pidFilter)
      m$.Cmd.Do("COMViewFilterControl.CreateText",pidClass.get(),pidFilter.get());
      //<< do CreateSearchButton(pidClass,pidFilter)
      m$.Cmd.Do("CreateSearchButton",pidClass.get(),pidFilter.get());
    }
    //<< }
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< GetGlobal(pstrIndex,pintNumKeys="")
  public Object GetGlobal(Object ... _p) {
    mVar pstrIndex = m$.newVarRef("pstrIndex",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pintNumKeys = m$.newVarRef("pintNumKeys",(((_p!=null)&&(_p.length>=2))?_p[1]:null),"");
    //<< new idClass,strGlobal,KeyLoop
    mVar idClass = m$.var("idClass");
    mVar strGlobal = m$.var("strGlobal");
    mVar KeyLoop = m$.var("KeyLoop");
    m$.newVar(idClass,strGlobal,KeyLoop);
    //<< 
    //<< set idClass = $piece(pstrIndex,"(",1)
    idClass.set(m$.Fnc.$piece(pstrIndex.get(),"(",1));
    //<< set idClass = $extract(idClass,2,$length(idClass)-1)
    idClass.set(m$.Fnc.$extract(idClass.get(),2,mOp.Subtract(m$.Fnc.$length(idClass.get()),1)));
    //<< if pintNumKeys="" set pintNumKeys = $order(^WWW002(0,idClass,""),-1)
    if (mOp.Equal(pintNumKeys.get(),"")) {
      pintNumKeys.set(m$.Fnc.$order(m$.var("^WWW002",0,idClass.get(),""),mOp.Negative(1)));
    }
    //<< 
    //<< set strGlobal = "^"_idClass_"("_$qsubscript(pstrIndex,1)
    strGlobal.set(mOp.Concat(mOp.Concat(mOp.Concat("^",idClass.get()),"("),m$.Fnc.$qsubscript(pstrIndex.get(),1)));
    //<< for KeyLoop=pintNumKeys:-1:1 {
    for (KeyLoop.set(pintNumKeys.get());(mOp.GreaterOrEqual(KeyLoop.get(),1));KeyLoop.set(mOp.Add(KeyLoop.get(),-1))) {
      //<< set strGlobal = strGlobal_","_$$$AddQuotes($qsubscript(pstrIndex,$qlength(pstrIndex)-KeyLoop+1))
      strGlobal.set(mOp.Concat(mOp.Concat(strGlobal.get(),","),include.COMSYS.$$$AddQuotes(m$,m$.Fnc.$qsubscript(pstrIndex.get(),mOp.Add(mOp.Subtract(m$.Fnc.$qlength(pstrIndex.get()),KeyLoop.get()),1)))));
    }
    //<< }
    //<< quit strGlobal_",1)"
    return mOp.Concat(strGlobal.get(),",1)");
  }

  //<< 
  //<< 
  //<< CreateSearchButton(pidClass,pidFilter,blnNewNumber=1)
  public Object CreateSearchButton(Object ... _p) {
    mVar pidClass = m$.newVarRef("pidClass",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pidFilter = m$.newVarRef("pidFilter",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar blnNewNumber = m$.newVarRef("blnNewNumber",(((_p!=null)&&(_p.length>=3))?_p[2]:null),1);
    //<< ;-------------------------------------------------------------------------------
    //<< ; Creates a search button to go next to the text box.
    //<< ;
    //<< ; Note. As ^CacheTempView is subscripted by YUSER, a new YUSER number
    //<< ; is required when opening the sub form.
    //<< ;
    //<< ; History:
    //<< ; 22-May-2012   shobby  SR18019: Don't try and interpret numerical constants
    //<< ;                           in relationships.
    //<< ; 21-Feb-2007   PO      SR15435: Use getElementById for the date field
    //<< ; 31-Aug-2006   HeberB  SRBR014211: add relational keys to search button
    //<< ; 10-Nov-2005   JW      SR11904: Child user for popups
    //<< ;  8-Aug-2005   JW      SR13116: Password is not available. Get it.
    //<< ;                           Y check is redundant. YPARA is set incorrectly.
    //<< ; 23-Mar-2005   Paul K  Made change for related class fields SR11966
    //<< ; 15-Dec-2004   Paul K  Created
    //<< ;-------------------------------------------------------------------------------
    //<< new idField,idRelation,idRelationPartial,loopId,objField,objFilter,strLink
    mVar idField = m$.var("idField");
    mVar idRelation = m$.var("idRelation");
    mVar idRelationPartial = m$.var("idRelationPartial");
    mVar loopId = m$.var("loopId");
    mVar objField = m$.var("objField");
    mVar objFilter = m$.var("objFilter");
    mVar strLink = m$.var("strLink");
    m$.newVar(idField,idRelation,idRelationPartial,loopId,objField,objFilter,strLink);
    //<< 
    //<< set objFilter = $get(^CacheTempView(YUSER,"Filter",pidFilter))
    objFilter.set(m$.Fnc.$get(m$.var("^CacheTempView",m$.var("YUSER").get(),"Filter",pidFilter.get())));
    //<< set idField   = $$$COMViewFilterField(objFilter)
    idField.set(include.COMConst.$$$COMViewFilterField(m$,objFilter));
    //<< set objField  = $$GetRelation^COMViewUtils(.pidClass,.idField) ; Should this pass 2nd parm for changing?
    objField.set(m$.fnc$("COMViewUtils.GetRelation",pidClass,idField));
    //<< 
    //<< set strLink = YAKTION_"EP=WWWFORM"
    strLink.set(mOp.Concat(m$.var("YAKTION").get(),"EP=WWWFORM"));
    //<< set strLink = strLink_"&YFORM=WWWPARA"
    strLink.set(mOp.Concat(strLink.get(),"&YFORM=WWWPARA"));
    //<< set strLink = strLink_"&YLFFORM=4"
    strLink.set(mOp.Concat(strLink.get(),"&YLFFORM=4"));
    //<< set strLink = strLink_"&YTRAKT=1"
    strLink.set(mOp.Concat(strLink.get(),"&YTRAKT=1"));
    //<< set strLink = strLink_"&YBACK="
    strLink.set(mOp.Concat(strLink.get(),"&YBACK="));
    //<< set strLink = strLink_"&YUCI="_YUCI  ; Namespace
    strLink.set(mOp.Concat(mOp.Concat(strLink.get(),"&YUCI="),m$.var("YUCI").get()));
    //<< set strLink = strLink_"&YBED="_YBED  ; User
    strLink.set(mOp.Concat(mOp.Concat(strLink.get(),"&YBED="),m$.var("YBED").get()));
    //<< set strLink = strLink_"&YM="_YM      ; Company
    strLink.set(mOp.Concat(mOp.Concat(strLink.get(),"&YM="),m$.var("YM").get()));
    //<< 
    //<< if (blnNewNumber=$$$YES) {
    if ((mOp.Equal(blnNewNumber.get(),include.COMSYS.$$$YES(m$)))) {
      //<< set strLink = strLink_"&YUSER="_$$GetChildUser^WWWUSER(YUSER)
      strLink.set(mOp.Concat(mOp.Concat(strLink.get(),"&YUSER="),m$.fnc$("WWWUSER.GetChildUser",m$.var("YUSER").get())));
    }
    //<< } else {
    else {
      //<< set strLink = strLink_"&YUSER="_YUSER  ;USER
      strLink.set(mOp.Concat(mOp.Concat(strLink.get(),"&YUSER="),m$.var("YUSER").get()));
    }
    //<< }
    //<< 
    //<< set strLink = strLink_"&YLFDAT=Y"_$$$WWW002RelationClass(objField)_"D0"
    strLink.set(mOp.Concat(mOp.Concat(mOp.Concat(strLink.get(),"&YLFDAT=Y"),include.WWWConst.$$$WWW002RelationClass(m$,objField)),"D0"));
    //<< 
    //<< // Include relational primary keys to search button
    //<< set idRelation = $$$WWW002RelationalPrimaryKeys(objField)
    idRelation.set(include.WWWConst.$$$WWW002RelationalPrimaryKeys(m$,objField));
    //<< if (idRelation '= "")  {
    if ((mOp.NotEqual(idRelation.get(),""))) {
      //<< for loopId=1:1 {
      for (loopId.set(1);(true);loopId.set(mOp.Add(loopId.get(),1))) {
        //<< set idRelationPartial = $piece(idRelation, YKOMMA, loopId)
        idRelationPartial.set(m$.Fnc.$piece(idRelation.get(),m$.var("YKOMMA").get(),loopId.get()));
        //<< quit:idRelationPartial=""
        if (mOp.Equal(idRelationPartial.get(),"")) {
          break;
        }
        //<< 
        //<< if $find(idRelationPartial,"""") {
        if (mOp.Logical(m$.Fnc.$find(idRelationPartial.get(),"\""))) {
          //<< set idRelationPartial = $translate(idRelationPartial,"""")  // extract quotes from string
          idRelationPartial.set(m$.Fnc.$translate(idRelationPartial.get(),"\""));
        }
        //<< } elseif (+idRelationPartial=idRelationPartial) {               ;SR18019
        else if ((mOp.Equal(mOp.Positive(idRelationPartial.get()),idRelationPartial.get()))) {
        }
        //<< ; numeric contant entered.  No change required.             ;SR18019
        //<< } else {
        else {
          //<< set idRelationPartial = @idRelationPartial  // get value from GLOBAL
          idRelationPartial.set(m$.indirectVar(idRelationPartial.get()).get());
        }
        //<< }
        //<< if (loopId = 1) {
        if ((mOp.Equal(loopId.get(),1))) {
          //<< set strLink = strLink _ "&YFKEY=" _ idRelationPartial
          strLink.set(mOp.Concat(mOp.Concat(strLink.get(),"&YFKEY="),idRelationPartial.get()));
        }
        //<< } else {
        else {
          //<< set strLink = strLink _ YKOMMA _ idRelationPartial
          strLink.set(mOp.Concat(mOp.Concat(strLink.get(),m$.var("YKOMMA").get()),idRelationPartial.get()));
        }
      }
    }
    //<< }
    //<< }
    //<< }
    //<< 
    //<< set strLink = strLink_"&YSEC="
    strLink.set(mOp.Concat(strLink.get(),"&YSEC="));
    //<< 
    //<< &js<
    //<< var obj = document.createElement('img');
    //<< obj.src=FilePath+'search1.gif';
    //<< obj.className='coolButton';
    //<< //SR17583 obj.style.verticalAlign='text-bottom';
    //<< obj.style.verticalAlign='middle';           //SR17583
    //<< obj.attachEvent('onclick',#("SubSearch"_pidFilter)#);
    //<< ctrl#(pidFilter)#_3.appendChild(obj);
    //<< 
    //<< function #("SubSearch"_pidFilter)#() {
    //<< var field=document.getElementById('#("value"_pidFilter)#');  //SR17853
    //<< 
    //<< var result = window.showModalDialog('#(strLink)#'+(new Date()).getSeconds(),'Parameter','DialogWidth: 570px; DialogHeight: 530px; resizable: yes; scroll: no; help:no; status: no;');
    //<< if (result != null) {
    //<< field.value=result;
    //<< }
    //<< field.fireEvent('onkeyup');
    //<< }
    //<< 
    //<< >
    m$.Cmd.WriteJS("","\n");
    m$.Cmd.WriteJS("    var obj = document.createElement('img');","\n");
    m$.Cmd.WriteJS("    obj.src=FilePath+'search1.gif';","\n");
    m$.Cmd.WriteJS("    obj.className='coolButton';","\n");
    m$.Cmd.WriteJS("    //SR17583 obj.style.verticalAlign='text-bottom';","\n");
    m$.Cmd.WriteJS("    obj.style.verticalAlign='middle';           //SR17583","\n");
    m$.Cmd.WriteJS(mOp.Concat(mOp.Concat("    obj.attachEvent('onclick',",(mOp.Concat("SubSearch",pidFilter.get()))),");"),"\n");
    m$.Cmd.WriteJS(mOp.Concat(mOp.Concat("    ctrl",(pidFilter.get())),"_3.appendChild(obj);"),"\n");
    m$.Cmd.WriteJS(mOp.Concat(mOp.Concat("    function ",(mOp.Concat("SubSearch",pidFilter.get()))),"() {"),"\n");
    m$.Cmd.WriteJS(mOp.Concat(mOp.Concat("        var field=document.getElementById('",(mOp.Concat("value",pidFilter.get()))),"');  //SR17853"),"\n");
    m$.Cmd.WriteJS(mOp.Concat(mOp.Concat("        var result = window.showModalDialog('",(strLink.get())),"'+(new Date()).getSeconds(),'Parameter','DialogWidth: 570px; DialogHeight: 530px; resizable: yes; scroll: no; help:no; status: no;');"),"\n");
    m$.Cmd.WriteJS("        if (result != null) {","\n");
    m$.Cmd.WriteJS("            field.value=result;","\n");
    m$.Cmd.WriteJS("        }","\n");
    m$.Cmd.WriteJS("        field.fireEvent('onkeyup');","\n");
    m$.Cmd.WriteJS("    }","\n");
    m$.Cmd.WriteJS("    ","\n");
    m$.Cmd.WriteJS("    ");
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< DefaultValue(pidClass,pidRelation,pblnDisplay=0,pstrDisplay="")
  public Object DefaultValue(Object ... _p) {
    mVar pidClass = m$.newVarRef("pidClass",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pidRelation = m$.newVarRef("pidRelation",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pblnDisplay = m$.newVarRef("pblnDisplay",(((_p!=null)&&(_p.length>=3))?_p[2]:null),0);
    mVar pstrDisplay = m$.newVarRef("pstrDisplay",(((_p!=null)&&(_p.length>=4))?_p[3]:null),"");
    //<< ;-------------------------------------------------------------------------------
    //<< ; Add the variable for a current value - for a filter class
    //<< ;
    //<< ; Params:
    //<< ;
    //<< ; ByRefs:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 02-Nov-2006   JW      SR15166: Use less likely characters for variable indirection.
    //<< ;-------------------------------------------------------------------------------
    //<< new strValue
    mVar strValue = m$.var("strValue");
    m$.newVar(strValue);
    //<< 
    //<< set strValue = ""
    strValue.set("");
    //<< if pidClass="WWW012" {
    if (mOp.Equal(pidClass.get(),"WWW012")) {
      //<< set strValue    = "YM"
      strValue.set("YM");
      //<< set pstrDisplay = $$$StrWWW012Company
      pstrDisplay.set(include.WWWConst.$$$StrWWW012Company(m$));
    }
    //<< 
    //<< } elseif pidClass="WWW0121" {
    else if (mOp.Equal(pidClass.get(),"WWW0121")) {
      //<< set strValue    = "YLOCATION"
      strValue.set("YLOCATION");
      //<< set pstrDisplay = $$$StrWWW0121Location
      pstrDisplay.set(include.WWWConst.$$$StrWWW0121Location(m$));
    }
    //<< 
    //<< } elseif pidClass="WWW013" {
    else if (mOp.Equal(pidClass.get(),"WWW013")) {
      //<< set strValue    = "YBED"
      strValue.set("YBED");
      //<< set pstrDisplay = $$$StrWWW013UserName
      pstrDisplay.set(include.WWWConst.$$$StrWWW013UserName(m$));
    }
    //<< 
    //<< } elseif ((pidClass="WWW100") && ($find(pidRelation,"""WAEHRUNG"""))) {
    else if (mOp.Logical(((mOp.Equal(pidClass.get(),"WWW100")) && mOp.Logical((m$.Fnc.$find(pidRelation.get(),"\"WAEHRUNG\"")))))) {
      //<< set strValue    = "YWHR"
      strValue.set("YWHR");
      //<< set pstrDisplay = $$$Text("Com00135")  ; "Currency"
      pstrDisplay.set(include.COMSYS.$$$Text(m$,"Com00135"));
    }
    //<< 
    //<< } elseif pidClass="WWWUSER" {
    else if (mOp.Equal(pidClass.get(),"WWWUSER")) {
      //<< set strValue    = "YUSER"
      strValue.set("YUSER");
      //<< set pstrDisplay = $$$StrWWWUSERUserNumber
      pstrDisplay.set(include.WWWConst.$$$StrWWWUSERUserNumber(m$));
    }
    //<< 
    //<< } elseif ((pidClass="WWW100") && ($find(pidRelation,"""LAND"""))) {
    else if (mOp.Logical(((mOp.Equal(pidClass.get(),"WWW100")) && mOp.Logical((m$.Fnc.$find(pidRelation.get(),"\"LAND\"")))))) {
      //<< set strValue    = "YCOUNTRY"
      strValue.set("YCOUNTRY");
      //<< set pstrDisplay = $$$Text("Com00136")  ; "Country"
      pstrDisplay.set(include.COMSYS.$$$Text(m$,"Com00136"));
    }
    //<< 
    //<< } elseif ((pidClass="WWW100") && ($find(pidRelation,"""SPRACHE"""))) {
    else if (mOp.Logical(((mOp.Equal(pidClass.get(),"WWW100")) && mOp.Logical((m$.Fnc.$find(pidRelation.get(),"\"SPRACHE\"")))))) {
      //<< set strValue    = "LANGUAGE"
      strValue.set("LANGUAGE");
      //<< set pstrDisplay = $$$Text("Com00137")  ; "Language"
      pstrDisplay.set(include.COMSYS.$$$Text(m$,"Com00137"));
    }
    //<< }
    //<< 
    //<< if strValue'="" {
    if (mOp.NotEqual(strValue.get(),"")) {
      //<< if 'pblnDisplay {
      if (mOp.Not(pblnDisplay.get())) {
        //<< set strValue = @strValue
        strValue.set(m$.indirectVar(strValue.get()).get());
      }
      //<< } else {
      else {
        //<< set pstrDisplay = $$$Text($listbuild("Com00138",pstrDisplay,@strValue))  ; "Current %1 (%2)"
        pstrDisplay.set(include.COMSYS.$$$Text(m$,m$.Fnc.$listbuild("Com00138",pstrDisplay.get(),m$.indirectVar(strValue.get()).get())));
        //<< set strValue = "»"_strValue_"«"
        strValue.set(mOp.Concat(mOp.Concat("»",strValue.get()),"«"));
      }
    }
    //<< }
    //<< }
    //<< quit strValue
    return strValue.get();
  }

//<< 
//<< 
}
