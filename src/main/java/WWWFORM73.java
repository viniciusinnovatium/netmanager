//*****************************************************************************
//** TASC - ALPHALINC - MAC WWWFORM73
//** Innovatium Systems - Code Converter - v1.30
//** 2014-06-16 18:32:19
//*****************************************************************************

import mLibrary.*;


//<< WWWFORM73(YFORM,YART1,YLFN,NOY)
public class WWWFORM73 extends mClass {

  public Object main(Object ... _p) {
    mVar YFORM = m$.newVarRef("YFORM",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar YART1 = m$.newVarRef("YART1",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar YLFN = m$.newVarRef("YLFN",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    mVar NOY = m$.newVarRef("NOY",(((_p!=null)&&(_p.length>=4))?_p[3]:null));
    return _WWWFORM73(YFORM,YART1,YLFN,NOY);
  }

  public Object _WWWFORM73(Object ... _p) {
    mVar YFORM = m$.newVarRef("YFORM",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar YART1 = m$.newVarRef("YART1",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar YLFN = m$.newVarRef("YLFN",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    mVar NOY = m$.newVarRef("NOY",(((_p!=null)&&(_p.length>=4))?_p[3]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Description of Function :
    //<< ;       SELECT DER MULTISELECTFELDER
    //<< ;
    //<< ; Inputs :
    //<< ;
    //<< ;
    //<< ; ByRef :
    //<< ;
    //<< ;
    //<< ; Returns :
    //<< ;
    //<< ;
    //<< ; History :
    //<< ; 21-Jan-2009   GRF     Replace YRETVAL name (easier tracking)
    //<< ; 01.06.2002    DT
    //<< ;-------------------------------------------------------------------------------
    //<< NEW YY
    mVar YY = m$.var("YY");
    m$.newVar(YY);
    //<< 
    //<< SET YY="Y"
    YY.set("Y");
    //<< IF $GET(NOY)=1 SET YY=""  ;OHNE Y ;FIS;01.10.03 ;without
    if (mOp.Equal(m$.Fnc.$get(NOY),1)) {
      YY.set("");
    }
    //<< SET YFORM = $GET(YFORM)
    YFORM.set(m$.Fnc.$get(YFORM));
    //<< SET YART1 = $GET(YART1)
    YART1.set(m$.Fnc.$get(YART1));
    //<< SET YLFN  = $GET(YLFN)
    YLFN.set(m$.Fnc.$get(YLFN));
    //<< WRITE YCR,"<SCRIPT LANGUAGE = JavaScript>"
    m$.Cmd.Write(m$.var("YCR").get(),"<SCRIPT LANGUAGE = JavaScript>");
    //<< WRITE YCR,"function MULTISELECT"_YART1_YLFN_"()"
    m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat(mOp.Concat("function MULTISELECT",YART1.get()),YLFN.get()),"()"));
    //<< WRITE YCR,"{"
    m$.Cmd.Write(m$.var("YCR").get(),"{");
    //<< WRITE YCR,"  var boxLength = document."_YHTMFORM_"."_YY_YFORM_YART1_YLFN_".length;"
    m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("  var boxLength = document.",m$.var("YHTMFORM").get()),"."),YY.get()),YFORM.get()),YART1.get()),YLFN.get()),".length;"));
    //<< WRITE YCR,"  var fieldinput = "_""""_""""_" ;"
    m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat(mOp.Concat("  var fieldinput = ","\""),"\"")," ;"));
    //<< WRITE YCR,"  var count = 0;"
    m$.Cmd.Write(m$.var("YCR").get(),"  var count = 0;");
    //<< WRITE YCR,"  for (i = 0; i < boxLength; i++) "
    m$.Cmd.Write(m$.var("YCR").get(),"  for (i = 0; i < boxLength; i++) ");
    //<< WRITE YCR,"    {"
    m$.Cmd.Write(m$.var("YCR").get(),"    {");
    //<< WRITE YCR,"    if (document."_YHTMFORM_"."_YY_YFORM_YART1_YLFN_".options[i].selected==true)"
    m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("    if (document.",m$.var("YHTMFORM").get()),"."),YY.get()),YFORM.get()),YART1.get()),YLFN.get()),".options[i].selected==true)"));
    //<< WRITE YCR,"      {"
    m$.Cmd.Write(m$.var("YCR").get(),"      {");
    //<< WRITE YCR,"      if (document."_YHTMFORM_"."_YY_YFORM_YART1_YLFN_".options[i].value != "_""""_""""_")"
    m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("      if (document.",m$.var("YHTMFORM").get()),"."),YY.get()),YFORM.get()),YART1.get()),YLFN.get()),".options[i].value != "),"\""),"\""),")"));
    //<< WRITE YCR,"         {"
    m$.Cmd.Write(m$.var("YCR").get(),"         {");
    //<< WRITE YCR,"         fieldinput = fieldinput + document."_YHTMFORM_"."_YY_YFORM_YART1_YLFN_".options[i].value + "_""""_";"_""""_";"
    m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("         fieldinput = fieldinput + document.",m$.var("YHTMFORM").get()),"."),YY.get()),YFORM.get()),YART1.get()),YLFN.get()),".options[i].value + "),"\""),";"),"\""),";"));
    //<< WRITE YCR,"         }"
    m$.Cmd.Write(m$.var("YCR").get(),"         }");
    //<< WRITE YCR,"      }"
    m$.Cmd.Write(m$.var("YCR").get(),"      }");
    //<< WRITE YCR,"    count++;"
    m$.Cmd.Write(m$.var("YCR").get(),"    count++;");
    //<< WRITE YCR,"   }"
    m$.Cmd.Write(m$.var("YCR").get(),"   }");
    //<< WRITE YCR,"  return fieldinput;"
    m$.Cmd.Write(m$.var("YCR").get(),"  return fieldinput;");
    //<< WRITE YCR," }"
    m$.Cmd.Write(m$.var("YCR").get()," }");
    //<< WRITE YCR,"</script>"
    m$.Cmd.Write(m$.var("YCR").get(),"</script>");
    //<< QUIT
    return null;
  }

  //<< 
  //<< VAR(YFORM,YART1,YLFN,NOY) ;FIS;AANHÄNGEN AN STRING;06.02.04 ;upon
  public Object VAR(Object ... _p) {
    mVar YFORM = m$.newVarRef("YFORM",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar YART1 = m$.newVarRef("YART1",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar YLFN = m$.newVarRef("YLFN",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    mVar NOY = m$.newVarRef("NOY",(((_p!=null)&&(_p.length>=4))?_p[3]:null));
    //<< new strReturn,YY
    mVar strReturn = m$.var("strReturn");
    mVar YY = m$.var("YY");
    m$.newVar(strReturn,YY);
    //<< 
    //<< SET YY="Y"
    YY.set("Y");
    //<< IF $GET(NOY)=1 SET YY=""  ;OHNE Y ;FIS;01.10.03 ;without
    if (mOp.Equal(m$.Fnc.$get(NOY),1)) {
      YY.set("");
    }
    //<< SET YFORM = $GET(YFORM)
    YFORM.set(m$.Fnc.$get(YFORM));
    //<< SET YART1 = $GET(YART1)
    YART1.set(m$.Fnc.$get(YART1));
    //<< SET YLFN  = $GET(YLFN)
    YLFN.set(m$.Fnc.$get(YLFN));
    //<< SET strReturn=""
    strReturn.set("");
    //<< SET strReturn = strReturn_YCR_"<SCRIPT LANGUAGE = JavaScript>"
    strReturn.set(mOp.Concat(mOp.Concat(strReturn.get(),m$.var("YCR").get()),"<SCRIPT LANGUAGE = JavaScript>"));
    //<< SET strReturn = strReturn_YCR_"function MULTISELECT"_YART1_YLFN_"()"
    strReturn.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(strReturn.get(),m$.var("YCR").get()),"function MULTISELECT"),YART1.get()),YLFN.get()),"()"));
    //<< SET strReturn = strReturn_YCR_"{ "
    strReturn.set(mOp.Concat(mOp.Concat(strReturn.get(),m$.var("YCR").get()),"{ "));
    //<< SET strReturn = strReturn_YCR_"  var boxLength = document."_YHTMFORM_"."_YY_YFORM_YART1_YLFN_".length;"
    strReturn.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(strReturn.get(),m$.var("YCR").get()),"  var boxLength = document."),m$.var("YHTMFORM").get()),"."),YY.get()),YFORM.get()),YART1.get()),YLFN.get()),".length;"));
    //<< SET strReturn = strReturn_YCR_"  var fieldinput = "_""""_""""_" ;"
    strReturn.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(strReturn.get(),m$.var("YCR").get()),"  var fieldinput = "),"\""),"\"")," ;"));
    //<< SET strReturn = strReturn_YCR_"  var count = 0;"
    strReturn.set(mOp.Concat(mOp.Concat(strReturn.get(),m$.var("YCR").get()),"  var count = 0;"));
    //<< SET strReturn = strReturn_YCR_"  for (i = 0; i < boxLength; i++) "
    strReturn.set(mOp.Concat(mOp.Concat(strReturn.get(),m$.var("YCR").get()),"  for (i = 0; i < boxLength; i++) "));
    //<< SET strReturn = strReturn_YCR_"    {"
    strReturn.set(mOp.Concat(mOp.Concat(strReturn.get(),m$.var("YCR").get()),"    {"));
    //<< SET strReturn = strReturn_YCR_"    if (document."_YHTMFORM_"."_YY_YFORM_YART1_YLFN_".options[i].selected==true)"
    strReturn.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(strReturn.get(),m$.var("YCR").get()),"    if (document."),m$.var("YHTMFORM").get()),"."),YY.get()),YFORM.get()),YART1.get()),YLFN.get()),".options[i].selected==true)"));
    //<< SET strReturn = strReturn_YCR_"      {"
    strReturn.set(mOp.Concat(mOp.Concat(strReturn.get(),m$.var("YCR").get()),"      {"));
    //<< SET strReturn = strReturn_YCR_"      if (document."_YHTMFORM_"."_YY_YFORM_YART1_YLFN_".options[i].value != "_""""_""""_")"
    strReturn.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(strReturn.get(),m$.var("YCR").get()),"      if (document."),m$.var("YHTMFORM").get()),"."),YY.get()),YFORM.get()),YART1.get()),YLFN.get()),".options[i].value != "),"\""),"\""),")"));
    //<< SET strReturn = strReturn_YCR_"         {"
    strReturn.set(mOp.Concat(mOp.Concat(strReturn.get(),m$.var("YCR").get()),"         {"));
    //<< SET strReturn = strReturn_YCR_"         fieldinput = fieldinput + document."_YHTMFORM_"."_YY_YFORM_YART1_YLFN_".options[i].value + "_""""_";"_""""_";"
    strReturn.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(strReturn.get(),m$.var("YCR").get()),"         fieldinput = fieldinput + document."),m$.var("YHTMFORM").get()),"."),YY.get()),YFORM.get()),YART1.get()),YLFN.get()),".options[i].value + "),"\""),";"),"\""),";"));
    //<< SET strReturn = strReturn_YCR_"         }"
    strReturn.set(mOp.Concat(mOp.Concat(strReturn.get(),m$.var("YCR").get()),"         }"));
    //<< SET strReturn = strReturn_YCR_"      }"
    strReturn.set(mOp.Concat(mOp.Concat(strReturn.get(),m$.var("YCR").get()),"      }"));
    //<< SET strReturn = strReturn_YCR_"    count++;"
    strReturn.set(mOp.Concat(mOp.Concat(strReturn.get(),m$.var("YCR").get()),"    count++;"));
    //<< SET strReturn = strReturn_YCR_"   }"
    strReturn.set(mOp.Concat(mOp.Concat(strReturn.get(),m$.var("YCR").get()),"   }"));
    //<< SET strReturn = strReturn_YCR_"  return fieldinput;"
    strReturn.set(mOp.Concat(mOp.Concat(strReturn.get(),m$.var("YCR").get()),"  return fieldinput;"));
    //<< SET strReturn = strReturn_YCR_" }"
    strReturn.set(mOp.Concat(mOp.Concat(strReturn.get(),m$.var("YCR").get())," }"));
    //<< SET strReturn = strReturn_YCR_"</script>"
    strReturn.set(mOp.Concat(mOp.Concat(strReturn.get(),m$.var("YCR").get()),"</script>"));
    //<< QUIT strReturn
    return strReturn.get();
  }

//<< 
}
