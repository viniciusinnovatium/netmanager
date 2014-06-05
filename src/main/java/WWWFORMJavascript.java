//*****************************************************************************
//** TASC - ALPHALINC - MAC WWWFORMJavascript
//** Innovatium Systems - Code Converter - v1.29
//** 2014-06-03 20:55:04
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

//<< WWWFORMJavascript
public class WWWFORMJavascript extends mClass {

  public void main() {
    _WWWFORMJavascript();
  }

  public void _WWWFORMJavascript() {
  }

  //<< 
  //<< EventValue()
  public Object EventValue(Object ... _p) {
    //<< ;-------------------------------------------------------------------------------
    //<< ; Add some additional javascript references so that calls can be made back to cache
    //<< ; from popup menu forms.
    //<< ;
    //<< ; Called By: (WWWBODY commented)
    //<< ;
    //<< ; Params:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 31-Jul-2012   shobby  SR18075: Preserve SPRACHE in new field
    //<< ; 28-Jul-2009   shobby  SR16751: Define the retval variable
    //<< ; 23-Mar-2009   shobby  SR16427: Created
    //<< ;-------------------------------------------------------------------------------
    //<< write "function EventValue(Namespace,User,Form,Fixkey,Field,Value,Funct,LocalVar,Tab) {" ; SRBR014066
    m$.Cmd.Write("function EventValue(Namespace,User,Form,Fixkey,Field,Value,Funct,LocalVar,Tab) {");
    //<< write YCR, "   var retval;" ; 16751
    m$.Cmd.Write(m$.var("YCR").get(),"   var retval;");
    //<< if $find($zversion,"Windows") {
    if (mOp.Logical(m$.Fnc.$find(m$.Fnc.$zversion(),"Windows"))) {
      //<< write YCR, "   var von = /"_$char(128)_"/g;"
      m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat("   var von = /",m$.Fnc.$char(128)),"/g;"));
      //<< write YCR, "   var nach = ""&euro;"";"        ; euro in eurozeichen umwandeln bei csp
      m$.Cmd.Write(m$.var("YCR").get(),"   var nach = \"&euro;\";");
      //<< write YCR, "   if (Value != false) { if (Value != true) Value=Value.replace(von,nach);}"
      m$.Cmd.Write(m$.var("YCR").get(),"   if (Value != false) { if (Value != true) Value=Value.replace(von,nach);}");
    }
    //<< }
    //<< if +$get(YHYPER)=0 {  ;eventbroker
    if (mOp.Equal(mOp.Positive(m$.Fnc.$get(m$.var("YHYPER"))),0)) {
      //<< ;SR18075 write YCR, "   retval = document.WebLink.CacheMethod("""_$get(%KEY("MGWCHD"))_""", Namespace + ""."" + User + ""."" + Form + ""."" + Field + ""."" + Funct + ""."" + Fixkey + ""."" + LocalVar, Value);"
      //<< write YCR, "   retval = document.WebLink.CacheMethod("""_$get(%KEY("MGWCHD"))_""", Namespace + ""."" + User + ""."" + Form + ""."" + Field + ""."" + Funct + ""."" + Fixkey + ""."" + """_SPRACHE_""" + ""."" + LocalVar, Value);"  ;SR18075
      m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("   retval = document.WebLink.CacheMethod(\"",m$.Fnc.$get(m$.var("%KEY","MGWCHD"))),"\", Namespace + \".\" + User + \".\" + Form + \".\" + Field + \".\" + Funct + \".\" + Fixkey + \".\" + \""),m$.var("SPRACHE").get()),"\" + \".\" + LocalVar, Value);"));
    }
    //<< 
    //<< } elseif +$get(YHYPER)=1 {  ;if '$find($zversion,"4.0") {  ;HyperEvent neu
    else if (mOp.Equal(mOp.Positive(m$.Fnc.$get(m$.var("YHYPER"))),1)) {
      //<< ;SR18075 write YCR, "   Para=Namespace + ""."" + User + ""."" + Form + ""."" + Field + ""."" + Funct + ""."" + Fixkey + ""."" + LocalVar ;"
      //<< write YCR, "   Para=Namespace + ""."" + User + ""."" + Form + ""."" + Field + ""."" + Funct + ""."" + Fixkey + ""."" + """_SPRACHE_""" + ""."" + LocalVar ;" ;SR18075
      m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat("   Para=Namespace + \".\" + User + \".\" + Form + \".\" + Field + \".\" + Funct + \".\" + Fixkey + \".\" + \"",m$.var("SPRACHE").get()),"\" + \".\" + LocalVar ;"));
      //<< write YCR, "   retval = "_$get(%(YQUERY,"HYPER"))_";"
      m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat("   retval = ",m$.Fnc.$get(m$.var("%",m$.var("YQUERY").get(),"HYPER"))),";"));
    }
    //<< }
    //<< write YCR, "   if (retval != null) { "
    m$.Cmd.Write(m$.var("YCR").get(),"   if (retval != null) { ");
    //<< write YCR, "        retval=retval.replace(/'/g,String.fromCharCode(10,13));"
    m$.Cmd.Write(m$.var("YCR").get(),"        retval=retval.replace(/'/g,String.fromCharCode(10,13));");
    //<< write YCR, "        retval=retval.replace(/`/g,'\'');"
    m$.Cmd.Write(m$.var("YCR").get(),"        retval=retval.replace(/`/g,'\\'');");
    //<< write YCR, "      } "
    m$.Cmd.Write(m$.var("YCR").get(),"      } ");
    //<< write YCR, "   if (retval != null) retval=retvalcheck(retval,Value,Funct,Field,'"_YHTMFORM_"');"
    m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat("   if (retval != null) retval=retvalcheck(retval,Value,Funct,Field,'",m$.var("YHTMFORM").get()),"');"));
    //<< write YCR, "   return(retval);"
    m$.Cmd.Write(m$.var("YCR").get(),"   return(retval);");
    //<< write YCR, "}"
    m$.Cmd.Write(m$.var("YCR").get(),"}");
    //<< quit
    return null;
  }

  //<< 
  //<< Cspxml(YQUERY)
  public Object Cspxml(Object ... _p) {
    mVar YQUERY = m$.newVarRef("YQUERY",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Subroutined this logic.
    //<< ;
    //<< ; Called By: EVENTCALL^WWWFORM8, Event^WWWMENU5 (also  OldEVENTCALL^WWWFORM8)
    //<< ;
    //<< ; Params:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 20-Mar-2009   shobby  SR16427: Created
    //<< ;-------------------------------------------------------------------------------
    //<< set strScript=""
    mVar strScript = m$.var("strScript");
    strScript.set("");
    //<< if $get(%(YQUERY,"XMLHTTPREQ"))=1 {
    if (mOp.Equal(m$.Fnc.$get(m$.var("%",YQUERY.get(),"XMLHTTPREQ")),1)) {
      //<< set strScript = "<script type='text/javascript' src=""/"
      strScript.set("<script type='text/javascript' src=\"/");
      //<< if '+$get(^SysSetup("FieldEvents")) set strScript = strScript_"csp/broker/"
      if (mOp.Not(mOp.Positive(m$.Fnc.$get(m$.var("^SysSetup","FieldEvents"))))) {
        strScript.set(mOp.Concat(strScript.get(),"csp/broker/"));
      }
      //<< set strScript=strScript_"cspxmlhttp.js""></script>"
      strScript.set(mOp.Concat(strScript.get(),"cspxmlhttp.js\"></script>"));
    }
    //<< }
    //<< quit strScript
    return strScript.get();
  }

  //<< 
  //<< SR16427()
  public Object SR16427(Object ... _p) {
    //<< quit $$$YES ;YBED="SHOBBY"  ; test reversion SHOBBY
    return include.COMSYS.$$$YES(m$);
  }

}
