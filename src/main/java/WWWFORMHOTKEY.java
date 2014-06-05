//*****************************************************************************
//** TASC - ALPHALINC - MAC WWWFORMHOTKEY
//** Innovatium Systems - Code Converter - v1.29
//** 2014-06-03 20:54:33
//*****************************************************************************

import mLibrary.*;

//<< 
//<< #include WWWConst
import include.WWWConst;
import include.COMSYS;

//<< WWWFORMHOTKEY
public class WWWFORMHOTKEY extends mClass {

  public void main() {
    _WWWFORMHOTKEY();
  }

  public void _WWWFORMHOTKEY() {
  }

  //<< ;-------------------------------------------------------------------------------
  //<< ;       112     F1
  //<< ;       113     F2
  //<< ;       114     F3 ...
  //<< ;                   F5  (116)  Note : IE refresh overrides
  //<< ;                   F6  (117)  Note : Also performs IE operation (shift between frames and URL field)
  //<< ;  11 Prev Record   F7  (118)
  //<< ;  12 Next Record   F8  (119)
  //<< ;   9 Search        F9  (120)
  //<< ;   3 Save          F12 (123)  Note : Conflict with IE8
  //<< ;-------------------------------------------------------------------------------
  //<< 
  //<< CallBack()
  public Object CallBack(Object ... _p) {
    //<< ;-------------------------------------------------------------------------------
    //<< ; This routine is call when the javascript is created and creates javascript
    //<< ; commands to build an array of codes to handle keydown events.  It is a bit
    //<< ; indirect but ensures that every keypress does not call back to cache to determine
    //<< ; whether it should be handled or not.
    //<< ;
    //<< ; Inputs:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 27-Jan-2011   shobby  SR17086: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new idCommand,intLine,objWWWFORMHOTKEY,strCommands
    mVar idCommand = m$.var("idCommand");
    mVar intLine = m$.var("intLine");
    mVar objWWWFORMHOTKEY = m$.var("objWWWFORMHOTKEY");
    mVar strCommands = m$.var("strCommands");
    m$.newVar(idCommand,intLine,objWWWFORMHOTKEY,strCommands);
    //<< 
    //<< set strCommands = ""
    strCommands.set("");
    //<< set intLine = 0
    intLine.set(0);
    //<< 
    //<< set idCommand = ""
    idCommand.set("");
    //<< for {
    for (;true;) {
      //<< set idCommand = $order(^WWWFORMHOTKEY(0,idCommand))
      idCommand.set(m$.Fnc.$order(m$.var("^WWWFORMHOTKEY",0,idCommand.get())));
      //<< quit:idCommand=""
      if (mOp.Equal(idCommand.get(),"")) {
        break;
      }
      //<< 
      //<< set objWWWFORMHOTKEY = $get(^WWWFORMHOTKEY(0,idCommand,1))
      objWWWFORMHOTKEY.set(m$.Fnc.$get(m$.var("^WWWFORMHOTKEY",0,idCommand.get(),1)));
      //<< if $data(^WWWFORMHOTKEYD(0,idCommand,1)) {
      if (mOp.Logical(m$.Fnc.$data(m$.var("^WWWFORMHOTKEYD",0,idCommand.get(),1)))) {
        //<< set objWWWFORMHOTKEY = $get(^WWWFORMHOTKEYD(0,idCommand,1))
        objWWWFORMHOTKEY.set(m$.Fnc.$get(m$.var("^WWWFORMHOTKEYD",0,idCommand.get(),1)));
      }
      //<< }
      //<< set strCommands=strCommands_"arr['"_+$$$WWWFORMHOTKEYKey1(objWWWFORMHOTKEY)_"-"_
      //<< +$$$WWWFORMHOTKEYAlt(objWWWFORMHOTKEY)_"-"_
      //<< +$$$WWWFORMHOTKEYCtrl(objWWWFORMHOTKEY)_"-"_
      //<< +$$$WWWFORMHOTKEYShift(objWWWFORMHOTKEY)_"']='"_idCommand_"';"_$$$CRLF
      strCommands.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(strCommands.get(),"arr['"),mOp.Positive(include.WWWConst.$$$WWWFORMHOTKEYKey1(m$,objWWWFORMHOTKEY))),"-"),mOp.Positive(include.WWWConst.$$$WWWFORMHOTKEYAlt(m$,objWWWFORMHOTKEY))),"-"),mOp.Positive(include.WWWConst.$$$WWWFORMHOTKEYCtrl(m$,objWWWFORMHOTKEY))),"-"),mOp.Positive(include.WWWConst.$$$WWWFORMHOTKEYShift(m$,objWWWFORMHOTKEY))),"']='"),idCommand.get()),"';"),include.COMSYSString.$$$CRLF(m$)));
    }
    //<< }
    //<< quit strCommands
    return strCommands.get();
  }

  //<< 
  //<< 
  //<< JS()
  public Object JS(Object ... _p) {
    //<< ;-------------------------------------------------------------------------------
    //<< ; js : pruef()  : Check certain key presses - includes testing for disabled
    //<< ; Standard Buttons
    //<< ;
    //<< ; Called By: WWWFORM8
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 14-Feb-2011   shobby      SR17660:   Scope YPARA here.  We don't want to use
    //<< ;                               it.  Only show popup help window if no field has
    //<< ;                               the focus.
    //<< ; 01-Feb-2011   shobby      SR17086.1: Rework so that it can work with forms
    //<< ;                               that have grids.
    //<< ; 28-Jan-2011   shobby      SR17086:   Some tweaks for Firefox.
    //<< ; 27-Jan-2011   shobby      SR17086:   Created ( Rewrite of code in WWWFORM8)
    //<< ;-------------------------------------------------------------------------------
    //<< new blnReadOnly,strButtons,YPARA    ;SR17660
    mVar blnReadOnly = m$.var("blnReadOnly");
    mVar strButtons = m$.var("strButtons");
    mVar YPARA = m$.var("YPARA");
    m$.newVar(blnReadOnly,strButtons,YPARA);
    //<< 
    //<< quit:((YFORM'="")    && ($$$WWW120NoEventkeyCheck($get(^WWW120(0,YFORM,1))) = $$$YES))
    if (mOp.Logical(((mOp.NotEqual(m$.var("YFORM").get(),"")) && (mOp.Equal(include.WWWConst.$$$WWW120NoEventkeyCheck(m$,m$.Fnc.$get(m$.var("^WWW120",0,m$.var("YFORM").get(),1))),include.COMSYS.$$$YES(m$)))))) {
      return null;
    }
    //<< quit:(($get(YM)'="") && ($$$WWW012NoEventkeyCheck($get(^WWW012(0,YM,1)))    = $$$YES))
    if (mOp.Logical(((mOp.NotEqual(m$.Fnc.$get(m$.var("YM")),"")) && (mOp.Equal(include.WWWConst.$$$WWW012NoEventkeyCheck(m$,m$.Fnc.$get(m$.var("^WWW012",0,m$.var("YM").get(),1))),include.COMSYS.$$$YES(m$)))))) {
      return null;
    }
    //<< 
    //<< if ($get(YNOEVENTKEY)'=1) && ($$$WWW120FormType(YVOR)'=11) && ($$$WWW120FormType(YVOR)'=9) {
    if ((mOp.NotEqual(m$.Fnc.$get(m$.var("YNOEVENTKEY")),1)) && (mOp.NotEqual(include.WWWConst.$$$WWW120FormType(m$,m$.var("YVOR")),11)) && (mOp.NotEqual(include.WWWConst.$$$WWW120FormType(m$,m$.var("YVOR")),9))) {
      //<< $$$StartScript()
      include.COMSYS.$$$StartScript(m$);
      //<< write " window.onhelp= function() {return false;}; "
      m$.Cmd.Write(" window.onhelp= function() {return false;}; ");
      //<< 
      //<< ;SR17086.1
      //<< write "function mapKey(keyCode,altKey,ctrlKey,shiftKey) {",!
      m$.Cmd.Write("function mapKey(keyCode,altKey,ctrlKey,shiftKey) {","\n");
      //<< write "  var arr=new Array();",!
      m$.Cmd.Write("  var arr=new Array();","\n");
      //<< write $$CallBack^WWWFORMHOTKEY(),!
      m$.Cmd.Write(m$.fnc$("WWWFORMHOTKEY.CallBack"),"\n");
      //<< write "  return arr[(keyCode+0)+'-'+(altKey+0)+'-'+(ctrlKey+0)+'-'+(shiftKey+0)];",!
      m$.Cmd.Write("  return arr[(keyCode+0)+'-'+(altKey+0)+'-'+(ctrlKey+0)+'-'+(shiftKey+0)];","\n");
      //<< write "}",!
      m$.Cmd.Write("}","\n");
      //<< 
      //<< write "function pruef(wert) {",!
      m$.Cmd.Write("function pruef(wert) {","\n");
      //<< write "  var blnResult=false;",!
      m$.Cmd.Write("  var blnResult=false;","\n");
      //<< write "  wert=mapKey(window.event.keyCode,window.event.altKey,window.event.ctrlKey,window.event.shiftKey);",!
      m$.Cmd.Write("  wert=mapKey(window.event.keyCode,window.event.altKey,window.event.ctrlKey,window.event.shiftKey);","\n");
      //<< write "  if (wert == 'BACK') { window.history.back(); }",!
      m$.Cmd.Write("  if (wert == 'BACK') { window.history.back(); }","\n");
      //<< write "  else if ((wert == 'HELP')&&(window.event.srcElement.id=='')) { subWindow('"_YAKTION_"EP=WWWHELP&amp;YFORM="_YFORM_$$WWWCGI2^WWWCGI(1)_"&amp;YSEITE="_YSEITE_"','HELP"_YTARGET_"');}",! ;SR17660
      m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("  else if ((wert == 'HELP')&&(window.event.srcElement.id=='')) { subWindow('",m$.var("YAKTION").get()),"EP=WWWHELP&amp;YFORM="),m$.var("YFORM").get()),m$.fnc$("WWWCGI.WWWCGI2",1)),"&amp;YSEITE="),m$.var("YSEITE").get()),"','HELP"),m$.var("YTARGET").get()),"');}"),"\n");
      //<< 
      //<< set strButtons=","_$translate($$$WWW120DoNOTDisplayStandardButto(YVOR),";",",")_","
      strButtons.set(mOp.Concat(mOp.Concat(",",m$.Fnc.$translate(include.WWWConst.$$$WWW120DoNOTDisplayStandardButto(m$,m$.var("YVOR")),";",",")),","));
      //<< set blnReadOnly= (($get(YBEARB)=4) || ($$$WWW120AuthorizationToModifyData(YVOR)=$$$EnumReadOnly) || ($find(strButtons,",3,")))
      blnReadOnly.set(((mOp.Equal(m$.Fnc.$get(m$.var("YBEARB")),4)) || (mOp.Equal(include.WWWConst.$$$WWW120AuthorizationToModifyData(m$,m$.var("YVOR")),include.COMSYSEnum.$$$EnumReadOnly(m$))) || mOp.Logical((m$.Fnc.$find(strButtons.get(),",3,")))));
      //<< if 'blnReadOnly {
      if (mOp.Not(blnReadOnly.get())) {
        //<< write "  else if (wert == 'SAVE') {window.focus();document.WWW.YBUTTON.value='';document.WWW.YOPEN.value='0'; window.setTimeout('SAVENOW()',100);}",!
        m$.Cmd.Write("  else if (wert == 'SAVE') {window.focus();document.WWW.YBUTTON.value='';document.WWW.YOPEN.value='0'; window.setTimeout('SAVENOW()',100);}","\n");
      }
      //<< } else {
      else {
        //<< write "  else if (wert == 'SAVE') {window.alert(""F12 "_$$^WWWTEXT(144,,1)_"!"");}",!   ; "Not Possible"   ; NICHT MÖGLICH
        m$.Cmd.Write(mOp.Concat(mOp.Concat("  else if (wert == 'SAVE') {window.alert(\"F12 ",m$.fnc$("WWWTEXT.main",144,null,1)),"!\");}"),"\n");
      }
      //<< }
      //<< 
      //<< if (YFORM'="")&&(($$$WWW120FormType($get(YVOR))=1) || ($$$WWW120FormType($get(YVOR))=3)) {
      if ((mOp.NotEqual(m$.var("YFORM").get(),"")) && mOp.Logical(((mOp.Equal(include.WWWConst.$$$WWW120FormType(m$,m$.Fnc.$get(m$.var("YVOR"))),1)) || (mOp.Equal(include.WWWConst.$$$WWW120FormType(m$,m$.Fnc.$get(m$.var("YVOR"))),3))))) {
        //<< if '$find(strButtons,",9,") write "  else if (wert == 'SEARCH') { ShowSearch(); }"      // COMView now always used.
        if (mOp.Not(m$.Fnc.$find(strButtons.get(),",9,"))) {
          m$.Cmd.Write("  else if (wert == 'SEARCH') { ShowSearch(); }");
        }
        //<< if ($$$WWW120FormType($get(YVOR))=1)&&('$get(YTIMEFORM)) {    ; Standard Form
        if ((mOp.Equal(include.WWWConst.$$$WWW120FormType(m$,m$.Fnc.$get(m$.var("YVOR"))),1)) && (mOp.Not(m$.Fnc.$get(m$.var("YTIMEFORM"))))) {
          //<< if '$find(strButtons,",12,") write "  else if (wert == 'PREV RECORD')  { window.location='"_$$DirectionURL2^WWWFORMF("BACK")_"'; }",!
          if (mOp.Not(m$.Fnc.$find(strButtons.get(),",12,"))) {
            m$.Cmd.Write(mOp.Concat(mOp.Concat("  else if (wert == 'PREV RECORD')  { window.location='",m$.fnc$("WWWFORMF.DirectionURL2","BACK")),"'; }"),"\n");
          }
          //<< if '$find(strButtons,",11,") write "  else if (wert == 'NEXT RECORD')  { window.location='"_$$DirectionURL2^WWWFORMF("NEXT")_"'; }",!
          if (mOp.Not(m$.Fnc.$find(strButtons.get(),",11,"))) {
            m$.Cmd.Write(mOp.Concat(mOp.Concat("  else if (wert == 'NEXT RECORD')  { window.location='",m$.fnc$("WWWFORMF.DirectionURL2","NEXT")),"'; }"),"\n");
          }
          //<< if '$find(strButtons,",10,") write "  else if (wert == 'FIRST RECORD') { window.location='"_$$DirectionURL2^WWWFORMF("FIRST")_"'; }",!
          if (mOp.Not(m$.Fnc.$find(strButtons.get(),",10,"))) {
            m$.Cmd.Write(mOp.Concat(mOp.Concat("  else if (wert == 'FIRST RECORD') { window.location='",m$.fnc$("WWWFORMF.DirectionURL2","FIRST")),"'; }"),"\n");
          }
          //<< if '$find(strButtons,",13,") write "  else if (wert == 'LAST RECORD')  { window.location='"_$$DirectionURL2^WWWFORMF("LAST")_"'; }",!
          if (mOp.Not(m$.Fnc.$find(strButtons.get(),",13,"))) {
            m$.Cmd.Write(mOp.Concat(mOp.Concat("  else if (wert == 'LAST RECORD')  { window.location='",m$.fnc$("WWWFORMF.DirectionURL2","LAST")),"'; }"),"\n");
          }
        }
      }
      //<< }
      //<< }
      //<< write "  else { blnResult=true;",!
      m$.Cmd.Write("  else { blnResult=true;","\n");
      //<< write "    if (typeof(pruefg)=='function') {"
      m$.Cmd.Write("    if (typeof(pruefg)=='function') {");
      //<< write "       pruefg(window.event.keyCode);"
      m$.Cmd.Write("       pruefg(window.event.keyCode);");
      //<< write "    }",!
      m$.Cmd.Write("    }","\n");
      //<< write " }"
      m$.Cmd.Write(" }");
      //<< write " return blnResult;"
      m$.Cmd.Write(" return blnResult;");
      //<< write " };"
      m$.Cmd.Write(" };");
      //<< $$$EndScript()
      include.COMSYS.$$$EndScript(m$);
      //<< 
      //<< if $get(YUSERAGENT)="MSIE" {
      if (mOp.Equal(m$.Fnc.$get(m$.var("YUSERAGENT")),"MSIE")) {
        //<< $$$StartScript("for=document event='onkeydown()'")
        include.COMSYS.$$$StartScript(m$,"for=document event='onkeydown()'");
        //<< write " pruef(window.event.keyCode); "
        m$.Cmd.Write(" pruef(window.event.keyCode); ");
      }
      //<< 
      //<< } else {
      else {
        //<< $$$StartScript()
        include.COMSYS.$$$StartScript(m$);
      }
      //<< }
      //<< 
      //<< &JS<
      //<< function keyEvent(e) {
      //<< if (!(document.all)) {pruef(e.which)}
      //<< return true;
      //<< }
      //<< document.onkeyup = keyEvent;
      //<< >
      m$.Cmd.WriteJS("","\n");
      m$.Cmd.WriteJS("        function keyEvent(e) {","\n");
      m$.Cmd.WriteJS("           if (!(document.all)) {pruef(e.which)}","\n");
      m$.Cmd.WriteJS("           return true;","\n");
      m$.Cmd.WriteJS("        }","\n");
      m$.Cmd.WriteJS("        document.onkeyup = keyEvent;","\n");
      m$.Cmd.WriteJS("        ");
      //<< $$$EndScript()
      include.COMSYS.$$$EndScript(m$);
    }
    //<< }
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< OnBeforeSave(pidFunction,pobjHotKeys)
  public Object OnBeforeSave(Object ... _p) {
    mVar pidFunction = m$.newVarRef("pidFunction",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pobjHotKeys = m$.newVarRef("pobjHotKeys",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Called By : Form WWWFORMHOTKEYD (Customisation) - to show main configuration
    //<< ;
    //<< ; ByRef : Q
    //<< ;
    //<< ; History:
    //<< ; 03-Mar-2011   GRF     SR17086: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new blnFound,idCommand,idxAlt,idxCtrl,idxKey,idxShift,strStatus
    mVar blnFound = m$.var("blnFound");
    mVar idCommand = m$.var("idCommand");
    mVar idxAlt = m$.var("idxAlt");
    mVar idxCtrl = m$.var("idxCtrl");
    mVar idxKey = m$.var("idxKey");
    mVar idxShift = m$.var("idxShift");
    mVar strStatus = m$.var("strStatus");
    m$.newVar(blnFound,idCommand,idxAlt,idxCtrl,idxKey,idxShift,strStatus);
    //<< 
    //<< set Q = $$$QSave
    mVar Q = m$.var("Q");
    Q.set(include.COMSYSWWW.$$$QSave(m$));
    //<< 
    //<< set idxAlt    = $$$Index($piece(pobjHotKeys,Y,2))
    idxAlt.set(include.MEDConst.$$$Index(m$,m$.Fnc.$piece(pobjHotKeys.get(),m$.var("Y").get(),2)));
    //<< set idxCtrl   = $$$Index($piece(pobjHotKeys,Y,3))
    idxCtrl.set(include.MEDConst.$$$Index(m$,m$.Fnc.$piece(pobjHotKeys.get(),m$.var("Y").get(),3)));
    //<< set idxShift  = $$$Index($piece(pobjHotKeys,Y,4))
    idxShift.set(include.MEDConst.$$$Index(m$,m$.Fnc.$piece(pobjHotKeys.get(),m$.var("Y").get(),4)));
    //<< set idxKey    = $$$Index($piece(pobjHotKeys,Y,5))
    idxKey.set(include.MEDConst.$$$Index(m$,m$.Fnc.$piece(pobjHotKeys.get(),m$.var("Y").get(),5)));
    //<< 
    //<< set blnFound  = $$$NO
    blnFound.set(include.COMSYS.$$$NO(m$));
    //<< set idCommand = ""
    idCommand.set("");
    //<< for {
    for (;true;) {
      //<< set idCommand = $order(^WWWFORMHOTKEYDs(0,1,idxAlt,idxCtrl,idxShift,idxKey,idCommand))
      idCommand.set(m$.Fnc.$order(m$.var("^WWWFORMHOTKEYDs",0,1,idxAlt.get(),idxCtrl.get(),idxShift.get(),idxKey.get(),idCommand.get())));
      //<< quit:idCommand=""
      if (mOp.Equal(idCommand.get(),"")) {
        break;
      }
      //<< continue:idCommand=pidFunction
      if (mOp.Equal(idCommand.get(),pidFunction.get())) {
        continue;
      }
      //<< 
      //<< set blnFound = $$$YES
      blnFound.set(include.COMSYS.$$$YES(m$));
    }
    //<< }
    //<< if 'blnFound {
    if (mOp.Not(blnFound.get())) {
      //<< set idCommand = ""
      idCommand.set("");
      //<< for {
      for (;true;) {
        //<< set idCommand = $order(^WWWFORMHOTKEYs(0,1,idxAlt,idxCtrl,idxShift,idxKey,idCommand))
        idCommand.set(m$.Fnc.$order(m$.var("^WWWFORMHOTKEYs",0,1,idxAlt.get(),idxCtrl.get(),idxShift.get(),idxKey.get(),idCommand.get())));
        //<< quit:idCommand=""
        if (mOp.Equal(idCommand.get(),"")) {
          break;
        }
        //<< continue:idCommand=pidFunction
        if (mOp.Equal(idCommand.get(),pidFunction.get())) {
          continue;
        }
        //<< 
        //<< set blnFound = $$$YES
        blnFound.set(include.COMSYS.$$$YES(m$));
      }
    }
    //<< }
    //<< }
    //<< 
    //<< if blnFound {
    if (mOp.Logical(blnFound.get())) {
      //<< set strStatus = $$$MakeStatus("WWW00137")  ; "This key combination already exists"
      strStatus.set(include.COMSYS.$$$MakeStatus(m$,"WWW00137"));
      //<< do ReturnError^COMUtilError(strStatus)
      m$.Cmd.Do("COMUtilError.ReturnError",strStatus.get());
      //<< set Q = $$$QDontSave
      Q.set(include.COMSYSWWW.$$$QDontSave(m$));
    }
    //<< }
    //<< quit
    return null;
  }

//<< 
//<< 
}
