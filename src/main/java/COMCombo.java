//*****************************************************************************
//** TASC - ALPHALINC - MAC COMCombo
//** Innovatium Systems - Code Converter - v1.30
//** 2014-07-01 19:21:52
//*****************************************************************************

import mLibrary.*;

//<< ;-------------------------------------------------------------------------------
//<< ; populates @Net Combos
//<< ;-------------------------------------------------------------------------------
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

//<< COMCombo
public class COMCombo extends mClass {

  public void main() {
    _COMCombo();
  }

  public void _COMCombo() {
  }

  //<< 
  //<< StartCombo(pstrComboName,pstrValue="",pblnNoScriptTag=$$$NO,pblnMandatory=$$$NO)
  public Object StartCombo(Object ... _p) {
    mVar pstrComboName = m$.newVarRef("pstrComboName",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pstrValue = m$.newVarRef("pstrValue",(((_p!=null)&&(_p.length>=2))?_p[1]:null),"");
    mVar pblnNoScriptTag = m$.newVarRef("pblnNoScriptTag",(((_p!=null)&&(_p.length>=3))?_p[2]:null),include.COMSYS.$$$NO(m$));
    mVar pblnMandatory = m$.newVarRef("pblnMandatory",(((_p!=null)&&(_p.length>=4))?_p[3]:null),include.COMSYS.$$$NO(m$));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Starts the combo process off. Either writes at screen paint time
    //<< ; or hyperevent time.
    //<< ;
    //<< ; Note:
    //<< ; 30-Mar-2005   JW      TODO: if pstrValue is set, it selects that option, but
    //<< ;                       does not update the current data (YFELD).
    //<< ;
    //<< ; History:
    //<< ; 24-Mar-2008   shobby  SRBR014916: Improve performance when loading a large no.
    //<< ;                           of options. Included YUCI as key on CacheTempCombo
    //<< ; 03-Apr-2007   JW      SR15384: Catch exception: eg field has been moved/hidden
    //<< ;                           via customisation
    //<< ; 22-Nov-2004   PaulK   Created
    //<< ;-------------------------------------------------------------------------------
    //<< new strHTML
    mVar strHTML = m$.var("strHTML");
    m$.newVar(strHTML);
    //<< 
    //<< set strHTML = ""
    strHTML.set("");
    //<< kill ^CacheTempCombo(YUCI,YUSER,"HTML") ;BR014916
    m$.var("^CacheTempCombo",m$.var("YUCI").get(),m$.var("YUSER").get(),"HTML").kill();
    //<< if $get(%KEY("HYPEREVENT"))'=1 if 'pblnNoScriptTag $$$Append(strHTML,$$$CRLF_"<script language=javascript type='text/javascript'>")
    if (mOp.NotEqual(m$.Fnc.$get(m$.var("%KEY","HYPEREVENT")),1)) {
      if (mOp.Not(pblnNoScriptTag.get())) {
        include.COMSYSString.$$$Append(m$,strHTML,mOp.Concat(include.COMSYSString.$$$CRLF(m$),"<script language=javascript type='text/javascript'>"));
      }
    }
    //<< $$$Append(strHTML,"try {")      // SR15384
    include.COMSYSString.$$$Append(m$,strHTML,"try {");
    //<< $$$Append(strHTML,"var s = typeof("_pstrComboName_")=='object'?"_pstrComboName_":document.getElementById('"_pstrComboName_"');"_$$$CRLF)
    include.COMSYSString.$$$Append(m$,strHTML,mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("var s = typeof(",pstrComboName.get()),")=='object'?"),pstrComboName.get()),":document.getElementById('"),pstrComboName.get()),"');"),include.COMSYSString.$$$CRLF(m$)));
    //<< $$$Append(strHTML,"s.innerHTML='';"_$$$CRLF)
    include.COMSYSString.$$$Append(m$,strHTML,mOp.Concat("s.innerHTML='';",include.COMSYSString.$$$CRLF(m$)));
    //<< set ^CacheTempCombo(YUCI,YUSER,"Value")  = pstrValue ;BR014916
    m$.var("^CacheTempCombo",m$.var("YUCI").get(),m$.var("YUSER").get(),"Value").set(pstrValue.get());
    //<< set ^CacheTempCombo(YUCI,YUSER,"Buffer") = strHTML   ;BR014916
    m$.var("^CacheTempCombo",m$.var("YUCI").get(),m$.var("YUSER").get(),"Buffer").set(strHTML.get());
    //<< set ^CacheTempCombo(YUCI,YUSER,"Hyper")  = ($get(%KEY("HYPEREVENT"))=1)||(pblnNoScriptTag)  ;BR014916
    m$.var("^CacheTempCombo",m$.var("YUCI").get(),m$.var("YUSER").get(),"Hyper").set((mOp.Equal(m$.Fnc.$get(m$.var("%KEY","HYPEREVENT")),1)) || mOp.Logical((pblnNoScriptTag.get())));
    //<< 
    //<< if 'pblnMandatory do AddOption("","")
    if (mOp.Not(pblnMandatory.get())) {
      m$.Cmd.Do("AddOption","","");
    }
    //<< 
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< StopCombo(pblnUseArray=$$$NO)
  public Object StopCombo(Object ... _p) {
    mVar pblnUseArray = m$.newVarRef("pblnUseArray",(((_p!=null)&&(_p.length>=1))?_p[0]:null),include.COMSYS.$$$NO(m$));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Clears the write buffer and send the rest of combo creation to the screen.
    //<< ;
    //<< ; History:
    //<< ; 01-Sep-2008   shobby  SRBR014976: Set the FontFace as per company settings.
    //<< ; 24-Mar-2008   shobby  SRBR014916: Improve performance when loading a large no.
    //<< ;                           of options. Included YUCI as key on CacheTempCombo
    //<< ; 03-Apr-2007   JW      SR15384: Catch exception: eg field has been moved/hidden
    //<< ;                           via customisation
    //<< ; 22-Nov-2004   PaulK   Created
    //<< ;-------------------------------------------------------------------------------
    //<< new strHTML,idxHTML
    mVar strHTML = m$.var("strHTML");
    mVar idxHTML = m$.var("idxHTML");
    m$.newVar(strHTML,idxHTML);
    //<< 
    //<< set strHTML=$get(^CacheTempCombo(YUCI,YUSER,"Buffer"))  ;BR014916
    strHTML.set(m$.Fnc.$get(m$.var("^CacheTempCombo",m$.var("YUCI").get(),m$.var("YUSER").get(),"Buffer")));
    //<< $$$Append(strHTML,"} catch(e) {}")      // SR15384
    include.COMSYSString.$$$Append(m$,strHTML,"} catch(e) {}");
    //<< write strHTML
    m$.Cmd.Write(strHTML.get());
    //<< if pblnUseArray {
    if (mOp.Logical(pblnUseArray.get())) {
      //<< write "s.outerHTML=s.outerHTML.split('>')[0]+'>'"
      m$.Cmd.Write("s.outerHTML=s.outerHTML.split('>')[0]+'>'");
      //<< set idxHTML=""
      idxHTML.set("");
      //<< for {
      for (;true;) {
        //<< set idxHTML=$order(^CacheTempCombo(YUCI,YUSER,"HTML",idxHTML))  ;BR014916
        idxHTML.set(m$.Fnc.$order(m$.var("^CacheTempCombo",m$.var("YUCI").get(),m$.var("YUSER").get(),"HTML",idxHTML.get())));
        //<< quit:idxHTML=""
        if (mOp.Equal(idxHTML.get(),"")) {
          break;
        }
        //<< write "+'"_$get(^CacheTempCombo(YUCI,YUSER,"HTML",idxHTML))_"'"  ;BR014916
        m$.Cmd.Write(mOp.Concat(mOp.Concat("+'",m$.Fnc.$get(m$.var("^CacheTempCombo",m$.var("YUCI").get(),m$.var("YUSER").get(),"HTML",idxHTML.get()))),"'"));
      }
      //<< }
      //<< write "+'</select>';"_$$$CRLF
      m$.Cmd.Write(mOp.Concat("+'</select>';",include.COMSYSString.$$$CRLF(m$)));
    }
    //<< }
    //<< write "s.style.fontFamily='"_$$FontFace^WWW012()_"';"  //BR014976
    m$.Cmd.Write(mOp.Concat(mOp.Concat("s.style.fontFamily='",m$.fnc$("WWW012.FontFace")),"';"));
    //<< if '^CacheTempCombo(YUCI,YUSER,"Hyper") write "</script>"  ;BR014916 ;BR014976
    if (mOp.Not(m$.var("^CacheTempCombo",m$.var("YUCI").get(),m$.var("YUSER").get(),"Hyper").get())) {
      //m$.Cmd.Write("</script>");
    }
    //<< kill ^CacheTempCombo(YUCI,YUSER)  ;BR014916
    m$.var("^CacheTempCombo",m$.var("YUCI").get(),m$.var("YUSER").get()).kill();
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< AddOption(pidKey,pstrName,pblnUseArray=$$$NO)
  public Object AddOption(Object ... _p) {
    mVar pidKey = m$.newVarRef("pidKey",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pstrName = m$.newVarRef("pstrName",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pblnUseArray = m$.newVarRef("pblnUseArray",(((_p!=null)&&(_p.length>=3))?_p[2]:null),include.COMSYS.$$$NO(m$));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Adds an option to the combo, if keys match, selects that option.
    //<< ;
    //<< ; History:
    //<< ; 24-Mar-2008   shobby  SRBR014916: Improve performance when loading a large number of options.
    //<< ;                                   Included YUCI as a key on CacheTempCombo
    //<< ; 22-Nov-2004   Paul K  Created
    //<< ;-------------------------------------------------------------------------------
    //<< new strHTML,strHTML1
    mVar strHTML = m$.var("strHTML");
    mVar strHTML1 = m$.var("strHTML1");
    m$.newVar(strHTML,strHTML1);
    //<< 
    //<< if pblnUseArray {
    if (mOp.Logical(pblnUseArray.get())) {
      //<< set strHTML=$get(^CacheTempCombo(YUCI,YUSER,"HTML",99999)) ;BR014916
      strHTML.set(m$.Fnc.$get(m$.var("^CacheTempCombo",m$.var("YUCI").get(),m$.var("YUSER").get(),"HTML",99999)));
      //<< set strHTML1="<OPTION value="_pidKey
      strHTML1.set(mOp.Concat("<OPTION value=",pidKey.get()));
      //<< if (pidKey=$get(^CacheTempCombo(YUCI,YUSER,"Value")))&&(pidKey'="") { ;BR014916
      if ((mOp.Equal(pidKey.get(),m$.Fnc.$get(m$.var("^CacheTempCombo",m$.var("YUCI").get(),m$.var("YUSER").get(),"Value")))) && (mOp.NotEqual(pidKey.get(),""))) {
        //<< set strHTML1=strHTML1_" selected"
        strHTML1.set(mOp.Concat(strHTML1.get()," selected"));
      }
      //<< }
      //<< set strHTML1=strHTML1_">"_pstrName_"</OPTION>"
      strHTML1.set(mOp.Concat(mOp.Concat(mOp.Concat(strHTML1.get(),">"),pstrName.get()),"</OPTION>"));
      //<< if ($length(strHTML)+$length(strHTML1))>32000 {
      if (mOp.Greater((mOp.Add(m$.Fnc.$length(strHTML.get()),m$.Fnc.$length(strHTML1.get()))),32000)) {
        //<< merge ^CacheTempCombo(YUCI,YUSER,"HTML",$order(^CacheTempCombo(YUCI,YUSER,"HTML",99999),-1)+1)=^CacheTempCombo(YUCI,YUSER,"HTML",99999) ;BR014916
        m$.Cmd.Merge(m$.var("^CacheTempCombo",m$.var("YUCI").get(),m$.var("YUSER").get(),"HTML",mOp.Add(m$.Fnc.$order(m$.var("^CacheTempCombo",m$.var("YUCI").get(),m$.var("YUSER").get(),"HTML",99999),mOp.Negative(1)),1)),m$.var("^CacheTempCombo",m$.var("YUCI").get(),m$.var("YUSER").get(),"HTML",99999));
        //<< set strHTML=""
        strHTML.set("");
      }
      //<< }
      //<< set strHTML=strHTML_strHTML1
      strHTML.set(mOp.Concat(strHTML.get(),strHTML1.get()));
      //<< set ^CacheTempCombo(YUCI,YUSER,"HTML",99999)=strHTML ;BR014916
      m$.var("^CacheTempCombo",m$.var("YUCI").get(),m$.var("YUSER").get(),"HTML",99999).set(strHTML.get());
    }
    //<< } else {
    else {
      //<< set strHTML=$get(^CacheTempCombo(YUCI,YUSER,"Buffer")) ;BR014916
      strHTML.set(m$.Fnc.$get(m$.var("^CacheTempCombo",m$.var("YUCI").get(),m$.var("YUSER").get(),"Buffer")));
      //<< 
      //<< set strHTML=strHTML_"var o = document.createElement('option');"_$$$CRLF
      strHTML.set(mOp.Concat(mOp.Concat(strHTML.get(),"var o = document.createElement('option');"),include.COMSYSString.$$$CRLF(m$)));
      //<< set strHTML=strHTML_"o.value='"_pidKey_"';"_$$$CRLF
      strHTML.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(strHTML.get(),"o.value='"),pidKey.get()),"';"),include.COMSYSString.$$$CRLF(m$)));
      //<< set strHTML=strHTML_"o.innerHTML='"_pstrName_"';"_$$$CRLF
      strHTML.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(strHTML.get(),"o.innerHTML='"),pstrName.get()),"';"),include.COMSYSString.$$$CRLF(m$)));
      //<< 
      //<< if (pidKey=$get(^CacheTempCombo(YUCI,YUSER,"Value")))&&(pidKey'="") { ;BR014916
      if ((mOp.Equal(pidKey.get(),m$.Fnc.$get(m$.var("^CacheTempCombo",m$.var("YUCI").get(),m$.var("YUSER").get(),"Value")))) && (mOp.NotEqual(pidKey.get(),""))) {
        //<< set strHTML=strHTML_"o.selected=true;"_$$$CRLF
        strHTML.set(mOp.Concat(mOp.Concat(strHTML.get(),"o.selected=true;"),include.COMSYSString.$$$CRLF(m$)));
      }
      //<< }
      //<< set strHTML=strHTML_"s.appendChild(o);"_$$$CRLF
      strHTML.set(mOp.Concat(mOp.Concat(strHTML.get(),"s.appendChild(o);"),include.COMSYSString.$$$CRLF(m$)));
      //<< if $length(strHTML)>32000 {
      if (mOp.Greater(m$.Fnc.$length(strHTML.get()),32000)) {
        //<< write strHTML
        m$.Cmd.Write(strHTML.get());
        //<< set strHTML=""
        strHTML.set("");
      }
      //<< }
      //<< 
      //<< set ^CacheTempCombo(YUCI,YUSER,"Buffer")=strHTML ;BR014916
      m$.var("^CacheTempCombo",m$.var("YUCI").get(),m$.var("YUSER").get(),"Buffer").set(strHTML.get());
    }
    //<< }
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< AddGroup(pstrName="")
  public Object AddGroup(Object ... _p) {
    mVar pstrName = m$.newVarRef("pstrName",(((_p!=null)&&(_p.length>=1))?_p[0]:null),"");
    //<< ;-------------------------------------------------------------------------------
    //<< ; Adds unselectable group separators to combo boxes.
    //<< ; Clears the buffer if too big.
    //<< ;
    //<< ; History:
    //<< ; 24-Mar-2008   shobby  SRBR014916: Included YUCI as a key on CacheTempCombo
    //<< ; 22-Nov-2004   PaulK   Created
    //<< ;-------------------------------------------------------------------------------
    //<< new strHTML
    mVar strHTML = m$.var("strHTML");
    m$.newVar(strHTML);
    //<< 
    //<< set strHTML = $get(^CacheTempCombo(YUCI,YUSER,"Buffer")) ;BR014916
    strHTML.set(m$.Fnc.$get(m$.var("^CacheTempCombo",m$.var("YUCI").get(),m$.var("YUSER").get(),"Buffer")));
    //<< set strHTML = strHTML_"var g = document.createElement('optgroup');"_$$$CRLF
    strHTML.set(mOp.Concat(mOp.Concat(strHTML.get(),"var g = document.createElement('optgroup');"),include.COMSYSString.$$$CRLF(m$)));
    //<< set strHTML = strHTML_"g.label='"_pstrName_"';"_$$$CRLF
    strHTML.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(strHTML.get(),"g.label='"),pstrName.get()),"';"),include.COMSYSString.$$$CRLF(m$)));
    //<< set strHTML = strHTML_"s.appendChild(g);"_$$$CRLF
    strHTML.set(mOp.Concat(mOp.Concat(strHTML.get(),"s.appendChild(g);"),include.COMSYSString.$$$CRLF(m$)));
    //<< 
    //<< if $length(strHTML)>32000 {
    if (mOp.Greater(m$.Fnc.$length(strHTML.get()),32000)) {
      //<< write strHTML
      m$.Cmd.Write(strHTML.get());
      //<< set strHTML = ""
      strHTML.set("");
    }
    //<< }
    //<< set ^CacheTempCombo(YUCI,YUSER,"Buffer")=strHTML ;BR014916
    m$.var("^CacheTempCombo",m$.var("YUCI").get(),m$.var("YUSER").get(),"Buffer").set(strHTML.get());
    //<< quit
    return null;
  }

//<< 
//<< 
//<< 
//<< /* UNFINISHED - update a combo field based on another field... get relations automatically
//<< 
//<< Would be great if this could be called automatically on blur for an fields based on another
//<< 
//<< UpdateCombo(pidForm,pidType,pidField)
//<< ;-------------------------------------------------------------------------------
//<< ; Update a combo list based on another field changing... very generic - look at field defs.
//<< ;
//<< ; Params:
//<< ;
//<< ; ByRefs:
//<< ;
//<< ; Returns:
//<< ;
//<< ; History:
//<< ; 04-Oct-2006   JW      SR15084: Created
//<< ;-------------------------------------------------------------------------------
//<< new strGlobal,strQuery,idKey
//<< 
//<< do StartCombo("document.WWW2.Y"_pidForm_pidType_pidField,"",$$$YES)
//<< 
//<< Get relation details:
//<< GetValidationInformation^WWWFieldValidation
//<< 
//<< Define keys:
//<< DefineKeys^WWWFieldValidation
//<< 
//<< 
//<< 
//<< set strGlobal = $$$GlobalString(pidClass,pstrRelKeys)
//<< $$$Query(strGlobal,strQuery)
//<< set idKey = $$$DEQUOTE($$$QueryANid(strQuery))
//<< 
//<< //do AddOption^COMCombo(idKey,idKey_" - REL")       // encapsulate fn to get REL here
//<< 
//<< $$$End
//<< 
//<< do StopCombo^COMCombo()
//<< 
//<< quit
//<< */
//<< 
}
