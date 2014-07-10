//*****************************************************************************
//** TASC - ALPHALINC - CLASS User.WWWStatus
//** Innovatium Systems - Code Converter - v1.31
//** 2014-07-07 17:54:26
//*****************************************************************************

package User;

import mLibrary.*;

//<< /// Status Codes:
//<< Class User.WWWStatus Extends (%Library.Persistent, %XML.Adaptor) [ ClassType = persistent, Not ProcedureBlock, StorageStrategy = StorageAtNet ]
public class WWWStatus extends mPersistent {
  //<< {
  //<< 
  //<< Property Company As %String(MAXLEN = 30, XMLPROJECTION = "attribute") [ Required ];
  public String Company;
  //<< 
  //<< /// Description
  //<< Property Description As %String(CAPTION = "Description", MAXLEN = 30) [ Required ];
  public String Description;
  //<< 
  //<< Property LangDescription As %String(CAPTION = "LangDescription") [ Calculated, SqlComputeCode = { set {LangDescription}=$$GetDescription^WWWStatus({StatusClass},{StatusCode},$g(SPRACHE))}, SqlComputed ];
  public String LangDescription;
  //<< 
  //<< /// Status Class
  //<< Property StatusClass As %String(CAPTION = "Status Class", COLLATION = "EXACT", MAXLEN = 30, XMLPROJECTION = "attribute") [ Required ];
  public String StatusClass;
  //<< 
  //<< /// Status Code
  //<< Property StatusCode As %Numeric(CAPTION = "Status Code", XMLPROJECTION = "attribute") [ Required ];
  public Double StatusCode;

  //<< 
  //<< Index IDKEY On (Company, StatusClass, StatusCode) [ IdKey, PrimaryKey, Unique ];
  //<< 
  //<< Method %OnBeforeSave(insert As %Boolean) As %Status [ Private, ServerOnly = 1 ]
  public Object $OnBeforeSave(Object ... _p) {
    mVar insert = m$.newVarRef("insert",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< {
    //<< set strClass="WWWStatus"
    mVar strClass = m$.var("strClass");
    strClass.set("WWWStatus");
    //<< set $piece(idKey,",",1)=i%StatusClass
    m$.pieceVar(m$.var("idKey"),",",1).set(m$.var("i%StatusClass").get());
    //<< set $piece(idKey,",",2)=i%StatusCode
    m$.pieceVar(m$.var("idKey"),",",2).set(m$.var("i%StatusCode").get());
    //<< set $piece(objRec,"~",1)=i%Description
    m$.pieceVar(m$.var("objRec"),"~",1).set(m$.var("i%Description").get());
    //<< set sc=$$OnBeforeSave^COMObject(insert,strClass,idKey,.objRec)
    mVar sc = m$.var("sc");
    sc.set(m$.fnc$("COMObject.OnBeforeSave",insert.get(),strClass.get(),m$.var("idKey").get(),m$.var("objRec")));
    //<< set i%Description=$piece(objRec,"~",1)
    m$.prop(this,"Description").set(m$.Fnc.$piece(m$.var("objRec").get(),"~",1));
    //<< Quit sc
    return sc.get();
  //<< }
  }

  //<< 
  //<< Method LangDescriptionGet() As %String [ CodeMode = expression ]
  public Object LangDescriptionGet() {
    //<< {
    //<< $$GetDescription^WWWStatus(..StatusClass,..StatusCode,$g(SPRACHE))
    return m$.fnc$("WWWStatus.GetDescription",this.StatusClass,this.StatusCode,m$.Fnc.$get(m$.var("SPRACHE")));
  //<< }
  }

//<< 
//<< }
}
