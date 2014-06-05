//*****************************************************************************
//** TASC - ALPHALINC - MAC WWWFORM7InheritableCheckBox
//** Innovatium Systems - Code Converter - v1.29
//** 2014-06-03 20:55:19
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

//<< WWWFORM7InheritableCheckBox
public class WWWFORM7InheritableCheckBox extends mClass {

  public void main() {
    _WWWFORM7InheritableCheckBox();
  }

  public void _WWWFORM7InheritableCheckBox() {
  }

  //<< 
  //<< Display()
  public Object Display(Object ... _p) {
    //<< ;-------------------------------------------------------------------------------
    //<< ; This routine will display a tri-state checkbox that can inherit from a parent
    //<< ; location.  A reworking of the code in WWWFORM7 for normal checkboxes.
    //<< ; NOTE: Only supports location fields.
    //<< ;
    //<< ; TODO:
    //<< ;   If the call to TemporaryStorageLocations is changed to metadata then we
    //<< ;       could use this process for other types of data fields rather than just
    //<< ;       Locations.
    //<< ;
    //<< ; Called By: ANTWORT^WWWFORM7
    //<< ;
    //<< ; ByRef :   YFORM, YART, YLFN, YSTATUS, YHID, YINHALT, YTABX, YJAVA
    //<< ;           YSATZ       objWWW122
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 09-Mar-2011   shobby  SR17594.1: changed window.event to event to stop an
    //<< ;                           error with firefox.
    //<< ; 11-Nov-2011   shobby  SR17612: change event from onmousedown to onmouseup
    //<< ; 08-Nov-2010   shobby  SR17594: Changes to work under Firefox
    //<< ; 27-Oct-2010   GRF     SR17564.1: enumValue rather than intValue; boolean macros
    //<< ; 12-Oct-2010   shobby  SRBR014837: Made intValue more generic from metadata.
    //<< ; 07-Oct-2010   shobby  SR17564: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new enumValue,id,strRoutine
    mVar enumValue = m$.var("enumValue");
    mVar id = m$.var("id");
    mVar strRoutine = m$.var("strRoutine");
    m$.newVar(enumValue,id,strRoutine);
    //<< 
    //<< set id         = "Y"_YFORM_YART_YLFN
    id.set(mOp.Concat(mOp.Concat(mOp.Concat("Y",m$.var("YFORM").get()),m$.var("YART").get()),m$.var("YLFN").get()));
    //<< set enumValue  = $$$NO
    enumValue.set(include.COMSYS.$$$NO(m$));
    //<< set strRoutine = $$$WWW122InheritedFrom($$Get^WWW122(YFORM,YBBN))  ;BR014837
    strRoutine.set(include.WWWConst.$$$WWW122InheritedFrom(m$,m$.fnc$("WWW122.Get",m$.var("YFORM").get(),m$.var("YBBN").get())));
    //<< if (strRoutine'="") {
    if ((mOp.NotEqual(strRoutine.get(),""))) {
      //<< xecute "set enumValue="_strRoutine
      m$.Cmd.Xecute(mOp.Concat("set enumValue=",strRoutine.get()));
    }
    //<< }
    //<< 
    //<< ; SR17594.1
    //<< &html<
    //<< <SPAN onmouseup='var xResult=InheritableCheckBoxClick(this,"#(enumValue)#");
    //<< document.getElementById("#(id)#").value=xResult;
    //<< xResult = EventValue("#(YUCI)#","#(YUSER)#","#(YFORM)#","FIX#($translate(YKEY,".","~"))#","#("Y"_YFORM_YART_YLFN)#",xResult,"2","","#(YSEITE)#");
    //<< event.cancelBubble=true;
    //<< '
    //<< style='height:20px; float:right; '
    //<< >
    //<< >
    m$.Cmd.WriteHtml("","\n");
    m$.Cmd.WriteHtml(mOp.Concat(mOp.Concat("        <SPAN onmouseup='var xResult=InheritableCheckBoxClick(this,\"",(enumValue.get())),"\");"),"\n");
    m$.Cmd.WriteHtml(mOp.Concat(mOp.Concat("                      document.getElementById(\"",(id.get())),"\").value=xResult; "),"\n");
    m$.Cmd.WriteHtml(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("                      xResult = EventValue(\"",(m$.var("YUCI").get())),"\",\""),(m$.var("YUSER").get())),"\",\""),(m$.var("YFORM").get())),"\",\"FIX"),(m$.Fnc.$translate(m$.var("YKEY").get(),".","~"))),"\",\""),(mOp.Concat(mOp.Concat(mOp.Concat("Y",m$.var("YFORM").get()),m$.var("YART").get()),m$.var("YLFN").get()))),"\",xResult,\"2\",\"\",\""),(m$.var("YSEITE").get())),"\");"),"\n");
    m$.Cmd.WriteHtml("                      event.cancelBubble=true;","\n");
    m$.Cmd.WriteHtml("                     ' ","\n");
    m$.Cmd.WriteHtml("           style='height:20px; float:right; '","\n");
    m$.Cmd.WriteHtml("        >","\n");
    m$.Cmd.WriteHtml("    ");
    //<< 
    //<< if (YHID=2) && (YSTATUS'="") write YCR,"<A" do STAT^WWWFORM7 write ">"
    if ((mOp.Equal(m$.var("YHID").get(),2)) && (mOp.NotEqual(m$.var("YSTATUS").get(),""))) {
      m$.Cmd.Write(m$.var("YCR").get(),"<A");
      m$.Cmd.Do("WWWFORM7.STAT");
      m$.Cmd.Write(">");
    }
    //<< write YCR,"<INPUT TYPE=""CHECKBOX"""
    m$.Cmd.Write(m$.var("YCR").get(),"<INPUT TYPE=\"CHECKBOX\"");
    //<< write YCR," NAME="""_id_""""
    m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat(" NAME=\"",id.get()),"\""));
    //<< write YCR," ID="""_id_""""              ;SR17253
    m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat(" ID=\"",id.get()),"\""));
    //<< write YCR," VALUE="""_YINHALT_""""      ;SR17612
    m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat(" VALUE=\"",m$.var("YINHALT").get()),"\""));
    //<< write YCR," TABINDEX="
    m$.Cmd.Write(m$.var("YCR").get()," TABINDEX=");
    //<< 
    //<< ; Tab Index  D61
    //<< ;---------------------------------------
    //<< if +$$$WWW122TabIndex(YSATZ)=0 {
    if (mOp.Equal(mOp.Positive(include.WWWConst.$$$WWW122TabIndex(m$,m$.var("YSATZ"))),0)) {
      //<< if $get(YHID)=2 {
      if (mOp.Equal(m$.Fnc.$get(m$.var("YHID")),2)) {
        //<< write YCR,"-1"           ;TAB STOP IN READ ONLY FIELD
        m$.Cmd.Write(m$.var("YCR").get(),"-1");
      }
      //<< } else {
      else {
        //<< write YCR,""""_YTABX_""""
        m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat("\"",m$.var("YTABX").get()),"\""));
      }
    }
    //<< }
    //<< } else {
    else {
      //<< write YCR,""""_+$$$WWW122TabIndex(YSATZ)_""""
      m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat("\"",mOp.Positive(include.WWWConst.$$$WWW122TabIndex(m$,m$.var("YSATZ")))),"\""));
    }
    //<< }
    //<< 
    //<< ; Execute on Form Construction (within) D99                       ; *** EXECUTE ***
    //<< if $$$WWW122ExecuteWithinDataField(YSATZ)'="" xecute $$$WWW122ExecuteWithinDataField(YSATZ)
    if (mOp.NotEqual(include.WWWConst.$$$WWW122ExecuteWithinDataField(m$,m$.var("YSATZ")),"")) {
      m$.Cmd.Xecute(include.WWWConst.$$$WWW122ExecuteWithinDataField(m$,m$.var("YSATZ")));
    }
    //<< if $$EXIST^%R("Y"_YFORM_YART_YLFN_"onField.OBJ",$get(YUCI)) write YCR xecute "do ^Y"_YFORM_YART_YLFN_"onField"  ;CUSTOMIZED EXECUTE
    if (mOp.Logical(m$.fnc$("$R.EXIST",mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("Y",m$.var("YFORM").get()),m$.var("YART").get()),m$.var("YLFN").get()),"onField.OBJ"),m$.Fnc.$get(m$.var("YUCI"))))) {
      m$.Cmd.Write(m$.var("YCR").get());
      m$.Cmd.Xecute(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("do ^Y",m$.var("YFORM").get()),m$.var("YART").get()),m$.var("YLFN").get()),"onField"));
    }
    //<< 
    //<< ; Explicitly or inherited "YES" - mark as checked
    //<< ;---------------------------------------
    //<< if (YINHALT=$$$YES) || (YINHALT=$$$INHERIT && enumValue=1) write YCR," CHECKED=""CHECKED"""
    if ((mOp.Equal(m$.var("YINHALT").get(),include.COMSYS.$$$YES(m$))) || (mOp.Equal(mOp.Equal(m$.var("YINHALT").get(),include.COMSYS.$$$INHERIT(m$)) && mOp.Logical(enumValue.get()),1))) {
      m$.Cmd.Write(m$.var("YCR").get()," CHECKED=\"CHECKED\"");
    }
    //<< 
    //<< write YCR," style="""
    m$.Cmd.Write(m$.var("YCR").get()," style=\"");
    //<< write "padding-left:1; "_$$$WWW122StyleDefinition(YSATZ)   ; D78
    m$.Cmd.Write(mOp.Concat("padding-left:1; ",include.WWWConst.$$$WWW122StyleDefinition(m$,m$.var("YSATZ"))));
    //<< if YHID=2 do LESEN1^WWWFORM7
    if (mOp.Equal(m$.var("YHID").get(),2)) {
      m$.Cmd.Do("WWWFORM7.LESEN1");
    }
    //<< write """"
    m$.Cmd.Write("\"");
    //<< 
    //<< ;DO SAVE
    //<< if (YHID=2) || (YINHALT=$$$INHERIT) if YHTMFORM="WWW2" write " disabled"
    if ((mOp.Equal(m$.var("YHID").get(),2)) || (mOp.Equal(m$.var("YINHALT").get(),include.COMSYS.$$$INHERIT(m$)))) {
      if (mOp.Equal(m$.var("YHTMFORM").get(),"WWW2")) {
        m$.Cmd.Write(" disabled");
      }
    }
    //<< if YHID=2 do LESEN^WWWFORM7
    if (mOp.Equal(m$.var("YHID").get(),2)) {
      m$.Cmd.Do("WWWFORM7.LESEN");
    }
    //<< if (YHID'=2) && (YSTATUS'="") do STAT^WWWFORM7
    if ((mOp.NotEqual(m$.var("YHID").get(),2)) && (mOp.NotEqual(m$.var("YSTATUS").get(),""))) {
      m$.Cmd.Do("WWWFORM7.STAT");
    }
    //<< 
    //<< if $$$WWW122READOnlyFieldsWithFieldEn(YSATZ) do READONLY^WWWFORM7
    if (mOp.Logical(include.WWWConst.$$$WWW122READOnlyFieldsWithFieldEn(m$,m$.var("YSATZ")))) {
      m$.Cmd.Do("WWWFORM7.READONLY");
    }
    //<< if $$$WWW122WriteFieldsWithFieldEntry(YSATZ) do WRITE^WWWFORM7
    if (mOp.Logical(include.WWWConst.$$$WWW122WriteFieldsWithFieldEntry(m$,m$.var("YSATZ")))) {
      m$.Cmd.Do("WWWFORM7.WRITE");
    }
    //<< if YJAVA=1 do JAVA^WWWFORM8
    if (mOp.Equal(m$.var("YJAVA").get(),1)) {
      m$.Cmd.Do("WWWFORM8.JAVA");
    }
    //<< write ">"
    m$.Cmd.Write(">");
    //<< if (YHID=2) && (YSTATUS'="") write YCR,"</A>"
    if ((mOp.Equal(m$.var("YHID").get(),2)) && (mOp.NotEqual(m$.var("YSTATUS").get(),""))) {
      m$.Cmd.Write(m$.var("YCR").get(),"</A>");
    }
    //<< ;SR17612 set YINHALT=+YINHALT
    //<< 
    //<< 
    //<< ; Firefox will lose the click event if clicking on a disabled checkbox.  Here, an invisible
    //<< ; DIV will accept the click allowing it to bubble up to the SPAN.   ; SR17594
    //<< if YUSERAGENT'="MSIE" write YCR,"<DIV style='position:relative; top:-20px; width:20px; height:20px;'></DIV>"
    if (mOp.NotEqual(m$.var("YUSERAGENT").get(),"MSIE")) {
      m$.Cmd.Write(m$.var("YCR").get(),"<DIV style='position:relative; top:-20px; width:20px; height:20px;'></DIV>");
    }
    //<< 
    //<< write YCR,"</SPAN>"
    m$.Cmd.Write(m$.var("YCR").get(),"</SPAN>");
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< Javascript()
  public Object Javascript(Object ... _p) {
    //<< ;-------------------------------------------------------------------------------
    //<< ; This routine will display a tri-state checkbox that can inherit from a parent
    //<< ; location.  A reworking of the code in WWWFORM7 for normal checkboxes.
    //<< ; NOTE: Only supports location fields.
    //<< ;
    //<< ; Called By: ^WWWFORM8
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 11-Nov-2010   shobby  SR17612: 'Inherit' value is now ""
    //<< ; 08-Nov-2010   shobby  SR17594: Changes to work under Firefox
    //<< ; 07-Oct-2010   shobby  SR17564: Created
    //<< ;-------------------------------------------------------------------------------
    //<< &js<
    //<< function InheritableCheckBoxClick(obj1,inheritedValue) {
    //<< var obj=obj1.children[0];
    //<< 
    //<< switch (obj.value) {
    //<< case '0': { obj.value=1;  obj.checked=true;                obj.disabled=false; break;}
    //<< case '1': { obj.value=''; obj.checked=(inheritedValue==1); obj.disabled=true;  break;}
    //<< default:  { obj.value=0;  obj.checked=false;               obj.disabled=false; break;}
    //<< }
    //<< // to reverse the click on the checkbox.
    //<< if (isIE()&&(obj.value!='')) obj.checked=!obj.checked;
    //<< return obj.value;
    //<< }
    //<< >
    m$.Cmd.WriteJS("","\n");
    m$.Cmd.WriteJS("        function InheritableCheckBoxClick(obj1,inheritedValue) {","\n");
    m$.Cmd.WriteJS("            var obj=obj1.children[0];","\n");
    m$.Cmd.WriteJS("            ","\n");
    m$.Cmd.WriteJS("            switch (obj.value) {","\n");
    m$.Cmd.WriteJS("                case '0': { obj.value=1;  obj.checked=true;                obj.disabled=false; break;}","\n");
    m$.Cmd.WriteJS("                case '1': { obj.value=''; obj.checked=(inheritedValue==1); obj.disabled=true;  break;}","\n");
    m$.Cmd.WriteJS("                default:  { obj.value=0;  obj.checked=false;               obj.disabled=false; break;}","\n");
    m$.Cmd.WriteJS("            } ","\n");
    m$.Cmd.WriteJS("            // to reverse the click on the checkbox.","\n");
    m$.Cmd.WriteJS("            if (isIE()&&(obj.value!='')) obj.checked=!obj.checked;","\n");
    m$.Cmd.WriteJS("            return obj.value;","\n");
    m$.Cmd.WriteJS("        }","\n");
    m$.Cmd.WriteJS("    ");
    //<< quit
    return null;
  }

//<< 
}
