//*****************************************************************************
//** TASC - ALPHALINC - MAC WWWDASHBOARDEntity
//** Innovatium Systems - Code Converter - v1.29
//** 2014-06-03 20:54:16
//*****************************************************************************

import mLibrary.*;

//<< 
//<< #include COMConst
import include.COMConst;
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

//<< WWWDASHBOARDEntity
public class WWWDASHBOARDEntity extends mClass {

  public void main() {
    _WWWDASHBOARDEntity();
  }

  public void _WWWDASHBOARDEntity() {
  }

  //<< 
  //<< ;-------------------------------------------------------------------------------
  //<< ; Use of ^COMEntity(0,"THIS NAMESPACE",1)
  //<< ;
  //<< ; If COMEntity is not updated following the copying of a namespace, data may be
  //<< ; posted into or retrieved from the wrong dataset.
  //<< ;
  //<< ; This entry is used to identify situations where this may have occurred.
  //<< ;
  //<< ; e.g. Copying namespace LIVE to TEST requires COMEntity to be modified to
  //<< ;      reflect the new mappings.
  //<< ;
  //<< ;      "THIS NAMESPACE" needs to be defined under LIVE as "LIVE".  An error will
  //<< ;      be reported in the System Dashboard if it is not present.
  //<< ;
  //<< ;      If LIVE is copied to TEST, "THIS NAMESPACE" will still point to "LIVE"
  //<< ;      and the Dashboard will show an error because it will expect it to point
  //<< ;      to "TEST".  A system user will need to edit the entities to make all
  //<< ;      references to "LIVE" be "TEST" instead.
  //<< ;-------------------------------------------------------------------------------
  //<< 
  //<< Message()
  public Object Message(Object ... _p) {
    //<< ;-------------------------------------------------------------------------------
    //<< ; Write out the warning messages for this test.
    //<< ;
    //<< ; Called By: OnAfterDataFields^WWWDASHBOARD
    //<< ; Inputs:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 21-Sep-2011   shobby  SR17835: Included 6th parameter (form) on "THIS NAMESPACE" line.
    //<< ; 15-Feb-2011   shobby  SR17661: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new idCOMEntity,objCOMEntity,strActual,strExpected
    mVar idCOMEntity = m$.var("idCOMEntity");
    mVar objCOMEntity = m$.var("objCOMEntity");
    mVar strActual = m$.var("strActual");
    mVar strExpected = m$.var("strExpected");
    m$.newVar(idCOMEntity,objCOMEntity,strActual,strExpected);
    //<< 
    //<< do MessageLine($$CheckThisNamespace(),$$$Text("WWW00152"),$$^WWWFORMNAME("COMEntity"),"THIS NAMESPACE",$$$COMEntityNamespace($$GetDefaultEntity()),$zu(5),"COMEntity") ;SR17835
    m$.Cmd.Do("MessageLine",m$.fnc$("CheckThisNamespace"),include.COMSYS.$$$Text(m$,"WWW00152"),m$.fnc$("WWWFORMNAME.main","COMEntity"),"THIS NAMESPACE",include.COMConst.$$$COMEntityNamespace(m$,m$.fnc$("GetDefaultEntity")),m$.Fnc.$zutil(5),"COMEntity");
    //<< ;""WWW00152"  ;Check Entity setup"
    //<< set idCOMEntity = ""
    idCOMEntity.set("");
    //<< for {
    for (;true;) {
      //<< set idCOMEntity = $order(^COMEntity(0,idCOMEntity))
      idCOMEntity.set(m$.Fnc.$order(m$.var("^COMEntity",0,idCOMEntity.get())));
      //<< quit:idCOMEntity=""
      if (mOp.Equal(idCOMEntity.get(),"")) {
        break;
      }
      //<< continue:idCOMEntity="THIS NAMESPACE"
      if (mOp.Equal(idCOMEntity.get(),"THIS NAMESPACE")) {
        continue;
      }
      //<< 
      //<< set objCOMEntity = $get(^COMEntity(0,idCOMEntity,1))
      objCOMEntity.set(m$.Fnc.$get(m$.var("^COMEntity",0,idCOMEntity.get(),1)));
      //<< set strExpected  = $$GetDefaultDatabaseForGlobals($$$COMEntityNamespace(objCOMEntity))
      strExpected.set(m$.fnc$("GetDefaultDatabaseForGlobals",include.COMConst.$$$COMEntityNamespace(m$,objCOMEntity)));
      //<< set strActual    = $zu(5)
      strActual.set(m$.Fnc.$zutil(5));
      //<< do MessageLine(strExpected=strActual,$$$Text("WWW00152"),$$^WWWFORMNAME("COMEntity"),idCOMEntity,strExpected,strActual,"COMEntity")
      m$.Cmd.Do("MessageLine",mOp.Equal(strExpected.get(),strActual.get()),include.COMSYS.$$$Text(m$,"WWW00152"),m$.fnc$("WWWFORMNAME.main","COMEntity"),idCOMEntity.get(),strExpected.get(),strActual.get(),"COMEntity");
    }
    //<< }
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< MessageLine(pblnFlag,YTOOLTIP,pstrTopic,YKEY,pstrExpected,pstrActual,pstrForm="")
  public Object MessageLine(Object ... _p) {
    mVar pblnFlag = m$.newVarRef("pblnFlag",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar YTOOLTIP = m$.newVarRef("YTOOLTIP",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pstrTopic = m$.newVarRef("pstrTopic",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    mVar YKEY = m$.newVarRef("YKEY",(((_p!=null)&&(_p.length>=4))?_p[3]:null));
    mVar pstrExpected = m$.newVarRef("pstrExpected",(((_p!=null)&&(_p.length>=5))?_p[4]:null));
    mVar pstrActual = m$.newVarRef("pstrActual",(((_p!=null)&&(_p.length>=6))?_p[5]:null));
    mVar pstrForm = m$.newVarRef("pstrForm",(((_p!=null)&&(_p.length>=7))?_p[6]:null),"");
    //<< ;-------------------------------------------------------------------------------
    //<< ; Write one line of the message
    //<< ;
    //<< ; Called By: Message^WWWDASHBOARDEntity, OnAfterDataFields^WWWDASHBOARD
    //<< ;
    //<< ; Inputs:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 19-Jul-2011   shobby  SR17835: Form to link to is now a parameter.
    //<< ; 15-Feb-2011   shobby  SR17661: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new strHelp,strImage
    mVar strHelp = m$.var("strHelp");
    mVar strImage = m$.var("strImage");
    m$.newVar(strHelp,strImage);
    //<< 
    //<< set strHelp = YTOOLTIP
    strHelp.set(YTOOLTIP.get());
    //<< set YBACK   = YBACK_YFORM_","
    mVar YBACK = m$.var("YBACK");
    YBACK.set(mOp.Concat(mOp.Concat(m$.var("YBACK").get(),m$.var("YFORM").get()),","));
    //<< 
    //<< if pblnFlag {
    if (mOp.Logical(pblnFlag.get())) {
      //<< set strImage = "ball_grey.gif"
      strImage.set("ball_grey.gif");
      //<< set YTOOLTIP = $$$Text(97)               ; "Ok"
      YTOOLTIP.set(include.COMSYS.$$$Text(m$,97));
    }
    //<< } else {
    else {
      //<< set strImage = "ball.gif"
      strImage.set("ball.gif");
    }
    //<< }
    //<< 
    //<< write "<TR>"
    m$.Cmd.Write("<TR>");
    //<< write "<TD><IMG SRC="_YGIF_strImage_" TITLE="""_YTOOLTIP_"""></TD>"
    m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<TD><IMG SRC=",m$.var("YGIF").get()),strImage.get())," TITLE=\""),YTOOLTIP.get()),"\"></TD>"));
    //<< write "<TD>"_pstrTopic_"</TD>"
    m$.Cmd.Write(mOp.Concat(mOp.Concat("<TD>",pstrTopic.get()),"</TD>"));
    //<< write "<TD><A HREF='"_YAKTION_"EP=WWWFORM&amp;YFORM="_pstrForm_$$WWWCGI2^WWWCGI()_"'>"_YKEY_"</TD>"
    m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<TD><A HREF='",m$.var("YAKTION").get()),"EP=WWWFORM&amp;YFORM="),pstrForm.get()),m$.fnc$("WWWCGI.WWWCGI2")),"'>"),YKEY.get()),"</TD>"));
    //<< write "<TD>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"_pstrExpected_"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</TD>"
    m$.Cmd.Write(mOp.Concat(mOp.Concat("<TD>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;",pstrExpected.get()),"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</TD>"));
    //<< write "<TD>"_pstrActual_"</TD>"
    m$.Cmd.Write(mOp.Concat(mOp.Concat("<TD>",pstrActual.get()),"</TD>"));
    //<< write "<TD><IMG SRC="_YGIF_"help.gif onclick=""CallBackNow('Show^WWWPopupMessage','"_$$$JSText(strHelp)_"','"_pstrTopic_"');""></TD>"
    m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<TD><IMG SRC=",m$.var("YGIF").get()),"help.gif onclick=\"CallBackNow('Show^WWWPopupMessage','"),include.COMSYSString.$$$JSText(m$,strHelp)),"','"),pstrTopic.get()),"');\"></TD>"));
    //<< write "</TR>"
    m$.Cmd.Write("</TR>");
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< Check()
  public Object Check(Object ... _p) {
    //<< ;-------------------------------------------------------------------------------
    //<< ; Checks whether the COMEntity setup matches the global mapping
    //<< ;
    //<< ; Inputs:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 15-Feb-2011   shobby  SR17661: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new blnResult
    mVar blnResult = m$.var("blnResult");
    m$.newVar(blnResult);
    //<< 
    //<< set blnResult = $$CheckThisNamespace()
    blnResult.set(m$.fnc$("CheckThisNamespace"));
    //<< if blnResult set blnResult = $$CheckMappedNamespaces()
    if (mOp.Logical(blnResult.get())) {
      blnResult.set(m$.fnc$("CheckMappedNamespaces"));
    }
    //<< quit blnResult
    return blnResult.get();
  }

  //<< 
  //<< 
  //<< CheckMappedNamespaces()
  public Object CheckMappedNamespaces(Object ... _p) {
    //<< new arrNS
    mVar arrNS = m$.var("arrNS");
    m$.newVar(arrNS);
    //<< ;do GetMappedNamespaces(.arrNS)
    //<< quit $$CheckEntity(.arrNS)
    return m$.fnc$("CheckEntity",arrNS);
  }

  //<< 
  //<< 
  //<< GetDefaultEntity()
  public Object GetDefaultEntity(Object ... _p) {
    //<< quit $get(^COMEntity(0,"THIS NAMESPACE",1))
    return m$.Fnc.$get(m$.var("^COMEntity",0,"THIS NAMESPACE",1));
  }

  //<< 
  //<< 
  //<< CheckThisNamespace()
  public Object CheckThisNamespace(Object ... _p) {
    //<< ;-------------------------------------------------------------------------------
    //<< ; There is a special COMEntity that can be setup with a key "THIS NAMESPACE"
    //<< ; This has no functionality other than to indicate that this namespace has been
    //<< ; copied but no-one reviewed the COMEntity settings.
    //<< ;
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 17-Feb-2011   shobby  SR17661: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new blnResult,objCOMEntity
    mVar blnResult = m$.var("blnResult");
    mVar objCOMEntity = m$.var("objCOMEntity");
    m$.newVar(blnResult,objCOMEntity);
    //<< 
    //<< set blnResult    = $$$OK
    blnResult.set(include.COMSYS.$$$OK(m$));
    //<< set objCOMEntity = $$GetDefaultEntity()
    objCOMEntity.set(m$.fnc$("GetDefaultEntity"));
    //<< if objCOMEntity'="" {
    if (mOp.NotEqual(objCOMEntity.get(),"")) {
      //<< if $$$COMEntityNamespace(objCOMEntity)'=$zu(5) {
      if (mOp.NotEqual(include.COMConst.$$$COMEntityNamespace(m$,objCOMEntity),m$.Fnc.$zutil(5))) {
        //<< set blnResult = '$$$OK
        blnResult.set(mOp.Not(include.COMSYS.$$$OK(m$)));
      }
    }
    //<< }
    //<< }
    //<< quit blnResult
    return blnResult.get();
  }

  //<< 
  //<< 
  //<< /*
  //<< GetMappedNamespaces(&parrNS)
  //<< ;-------------------------------------------------------------------------------
  //<< ; Get a list of what namespaces constitue the 'other' namespaces in a multi
  //<< ; namespace setup.
  //<< ;
  //<< ; Inputs:
  //<< ;
  //<< ; Returns:
  //<< ;
  //<< ; History:
  //<< ; 17-Feb-2011   shobby  SR17661: No longer used.
  //<< ; 15-Feb-2011   shobby  SR17661: Created
  //<< ;-------------------------------------------------------------------------------
  //<< new strNS,arrNS,objResult,sc
  //<< 
  //<< set strNS=$zu(5)
  //<< zn "%SYS"
  //<< Set objResult = ##class(%ResultSet).%New("Config.DataStorage:GlobalMappingList")
  //<< set sc = objResult.Execute()
  //<< if '$$$ISERR(sc) {
  //<< while objResult.Next() {
  //<< ;write !, objResult.GetData(1)
  //<< if objResult.GetData(1)=objResult.GetData(3) {
  //<< set parrNS(objResult.GetData(1))=""
  //<< }
  //<< }
  //<< do objResult.Close()
  //<< }
  //<< zn strNS
  //<< quit
  //<< */
  //<< 
  //<< 
  //<< CheckEntity(parrNS)
  public Object CheckEntity(Object ... _p) {
    mVar parrNS = m$.newVarRef("parrNS",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Compare the results with the COMEntity setup.
    //<< ;
    //<< ; Inputs:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 15-Feb-2011   shobby  SR17661: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new objCOMEntity,idCOMEntity,blnResult
    mVar objCOMEntity = m$.var("objCOMEntity");
    mVar idCOMEntity = m$.var("idCOMEntity");
    mVar blnResult = m$.var("blnResult");
    m$.newVar(objCOMEntity,idCOMEntity,blnResult);
    //<< 
    //<< set blnResult=$$$OK
    blnResult.set(include.COMSYS.$$$OK(m$));
    //<< 
    //<< set idCOMEntity=""
    idCOMEntity.set("");
    //<< for {
    for (;true;) {
      //<< set idCOMEntity = $order(^COMEntity(0,idCOMEntity))
      idCOMEntity.set(m$.Fnc.$order(m$.var("^COMEntity",0,idCOMEntity.get())));
      //<< quit:idCOMEntity=""
      if (mOp.Equal(idCOMEntity.get(),"")) {
        break;
      }
      //<< 
      //<< set objCOMEntity = $get(^COMEntity(0,idCOMEntity,1))
      objCOMEntity.set(m$.Fnc.$get(m$.var("^COMEntity",0,idCOMEntity.get(),1)));
      //<< continue:idCOMEntity="THIS NAMESPACE"
      if (mOp.Equal(idCOMEntity.get(),"THIS NAMESPACE")) {
        continue;
      }
      //<< 
      //<< if $$GetDefaultDatabaseForGlobals($$$COMEntityNamespace(objCOMEntity))'=$zu(5) {
      if (mOp.NotEqual(m$.fnc$("GetDefaultDatabaseForGlobals",include.COMConst.$$$COMEntityNamespace(m$,objCOMEntity)),m$.Fnc.$zutil(5))) {
        //<< ;   if '$data(parrNS($$$COMEntityNamespace(objCOMEntity))) {
        //<< set blnResult = '$$$OK
        blnResult.set(mOp.Not(include.COMSYS.$$$OK(m$)));
        //<< quit
        break;
      }
    }
    //<< }
    //<< }
    //<< quit blnResult
    return blnResult.get();
  }

  //<< 
  //<< 
  //<< GetDefaultDatabaseForGlobals(pstrNS)
  public Object GetDefaultDatabaseForGlobals(Object ... _p) {
    mVar pstrNS = m$.newVarRef("pstrNS",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Look at the cache configuration
    //<< ;
    //<< ; Inputs:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 15-Feb-2011   shobby  SR17661: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new strNS,strGlobal
    mVar strNS = m$.var("strNS");
    mVar strGlobal = m$.var("strGlobal");
    m$.newVar(strNS,strGlobal);
    //<< 
    //<< set strNS = $zu(5)
    strNS.set(m$.Fnc.$zutil(5));
    //<< zn "%SYS"
    //<< do ##class(Config.Configuration).GetNamespace(pstrNS,.strGlobal)
    m$.Cmd.Do("Config.Configuration.GetNamespace",pstrNS.get(),strGlobal);
    //<< zn strNS
    //<< quit $get(strGlobal)
    return m$.Fnc.$get(strGlobal);
  }

//<< 
//<< 
}
