//*****************************************************************************
//** TASC - ALPHALINC - MAC WWWSETL
//** Innovatium Systems - Code Converter - v1.29
//** 2014-06-03 20:55:08
//*****************************************************************************

import mLibrary.*;

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
//<< #include WWWConst
import include.WWWConst;

//<< WWWSETL(pstrGlobal,YTEST)
public class WWWSETL extends mClass {

  public Object main(Object ... _p) {
    mVar pstrGlobal = m$.newVarRef("pstrGlobal",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar YTEST = m$.newVarRef("YTEST",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    return _WWWSETL(pstrGlobal,YTEST);
  }

  public Object _WWWSETL(Object ... _p) {
    mVar pstrGlobal = m$.newVarRef("pstrGlobal",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar YTEST = m$.newVarRef("YTEST",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Description of Function :
    //<< ;       Read Values
    //<< ;       WERTE LESEN
    //<< ;
    //<< ; Usage :
    //<< ;   set YFELD=$$^WWWSETL("^DATEI(YM,KEY,KEYn,1)")
    //<< ;
    //<< ; Inputs :
    //<< ;   pstrGlobal
    //<< ;   YTEST
    //<< ;
    //<< ; ByRef :
    //<< ;
    //<< ;
    //<< ; Returns :
    //<< ;   pobjRecord   = GESAMTER DATENSATZ ;data record
    //<< ;
    //<< ; History :
    //<< ; 12-Jul-2007   RPW     SR15571: Rewrote in Brace Syntax
    //<< ; 05-Feb-2007   RPW     SR14900: Remove unused code.
    //<< ; 12-Jul-2005   GRF     Doco
    //<< ; 31.08.1997    DT      (C) BY DITMAR TYBUSSEK
    //<< ;-------------------------------------------------------------------------------
    //<< new pobjRecord,idClass,objWWW001,enumAltSaveProc,strAltDelim
    mVar pobjRecord = m$.var("pobjRecord");
    mVar idClass = m$.var("idClass");
    mVar objWWW001 = m$.var("objWWW001");
    mVar enumAltSaveProc = m$.var("enumAltSaveProc");
    mVar strAltDelim = m$.var("strAltDelim");
    m$.newVar(pobjRecord,idClass,objWWW001,enumAltSaveProc,strAltDelim);
    //<< 
    //<< set pobjRecord=""
    pobjRecord.set("");
    //<< quit:'$data(pstrGlobal) pobjRecord               ;KEIN SCHLÜSSEL ;no keys
    if (mOp.Not(m$.Fnc.$data(pstrGlobal))) {
      return pobjRecord.get();
    }
    //<< quit:$find(pstrGlobal,"""""") pobjRecord         ;KEIN SUBSCRIPT ;null subscript
    if (mOp.Logical(m$.Fnc.$find(pstrGlobal.get(),"\"\""))) {
      return pobjRecord.get();
    }
    //<< quit:$extract(pstrGlobal)'="^" pobjRecord        ;FALSCHER PARAMETER
    if (mOp.NotEqual(m$.Fnc.$extract(pstrGlobal.get()),"^")) {
      return pobjRecord.get();
    }
    //<< quit:$length(pstrGlobal)>255 pobjRecord          ;FALSCHE LÄNGE  ;too long
    if (mOp.Greater(m$.Fnc.$length(pstrGlobal.get()),255)) {
      return pobjRecord.get();
    }
    //<< 
    //<< ;TYBD;IN UND WWW IMMER STANDARD @NET ZUGRIFF;30,9,2004
    //<< do SetGlobal^WWWSETObject(.pstrGlobal,.objWWW001,.idClass)
    m$.Cmd.Do("WWWSETObject.SetGlobal",pstrGlobal,objWWW001,idClass);
    //<< 
    //<< set enumAltSaveProc=$$$WWW001AltSaveProcedure(objWWW001)
    enumAltSaveProc.set(include.WWWConst.$$$WWW001AltSaveProcedure(m$,objWWW001));
    //<< 
    //<< if enumAltSaveProc>0 {         ;ALTERNATIVE SPEICHERUNG ;option
    if (mOp.Greater(enumAltSaveProc.get(),0)) {
      //<< if enumAltSaveProc=4 {
      if (mOp.Equal(enumAltSaveProc.get(),4)) {
        //<< set pobjRecord=$$OBJECT(idClass,pstrGlobal)   ;CACHE
    	if (idClass.get().toString().substring(0,3).equals("WWW") || idClass.get().toString().substring(0,3).equals("VAR")) {
        	pobjRecord.set(m$.fnc$("OBJECT",idClass.get(),pstrGlobal.get()));
    	}
    	else {
	    	// ORM - NetManager Object
	      	mNMObject NMO = new mNMObject();
	      	mVar globalRef = m$.indirectVar(pstrGlobal.get());
	      	String globalRefID = "";
	      	for (int i=1;i<globalRef.getSubs().length;i++) {
	      		globalRefID = (globalRefID.isEmpty()?"":globalRefID+"||")+mFncUtil.toString(globalRef.getSubs()[i]);
	      	}
	      	pobjRecord.set(NMO.loadRecord(m$,idClass.get().toString(),globalRefID));
    	}
      }
      //<< 
      //<< } elseif enumAltSaveProc=5 {
      else if (mOp.Equal(enumAltSaveProc.get(),5)) {
        //<< do PROG(pstrGlobal,.pobjRecord)
        m$.Cmd.Do("PROG",pstrGlobal.get(),pobjRecord);
      }
    }
    //<< }
    //<< 
    //<< } else {
    else {
      //<< if $length(pstrGlobal,"""")#2=0 {
      if (mOp.Equal(mOp.Modulus(m$.Fnc.$length(pstrGlobal.get(),"\""),2),0)) {
        //<< set pobjRecord= ""                 ; odd number of double quotes is invalid   ; UNGLEICHE ""
        pobjRecord.set("");
      }
      //<< } else {
      else {
        //<< set pobjRecord=$get(@pstrGlobal)
      	if (idClass.get().toString().substring(0,3).equals("WWW") || idClass.get().toString().substring(0,3).equals("VAR")) {
          pobjRecord.set(m$.Fnc.$get(m$.indirectVar(pstrGlobal.get())));
      	}
      	else {
	    	// ORM - NetManager Object
	    	mNMObject NMO = new mNMObject();
	    	mVar globalRef = m$.indirectVar(pstrGlobal.get());
	    	String globalRefID = "";
	    	for (int i=1;i<globalRef.getSubs().length-1;i++) {
	    		globalRefID = (globalRefID.isEmpty()?"":globalRefID+"||")+mFncUtil.toString(globalRef.getSubs()[i]);
	    	}
	    	pobjRecord.set(NMO.loadRecord(m$,idClass.get().toString(),globalRefID));
      	}
        //<< if (pobjRecord="") && ($get(YTEST)=1) && $data(@pstrGlobal) {
        if ((mOp.Equal(pobjRecord.get(),"")) && (mOp.Equal(m$.Fnc.$get(YTEST),1)) && mOp.Logical(m$.Fnc.$data(m$.indirectVar(pstrGlobal.get())))) {
          //<< set pobjRecord=Y               ;DATENSATZ VORHANDEN;TYBD;30,04,2003
          pobjRecord.set(m$.var("Y").get());
        }
        //<< }
        //<< 
        //<< set strAltDelim = +$$$WWW001AltDelimiterASCII(objWWW001)
        strAltDelim.set(mOp.Positive(include.WWWConst.$$$WWW001AltDelimiterASCII(m$,objWWW001)));
        //<< 
        //<< ;       126 "~" 223 "ß"
        //<< if (pobjRecord'="") && (strAltDelim'=0) && (strAltDelim'=126) {
        if ((mOp.NotEqual(pobjRecord.get(),"")) && (mOp.NotEqual(strAltDelim.get(),0)) && (mOp.NotEqual(strAltDelim.get(),126))) {
          //<< set pobjRecord=$translate(pobjRecord,$char(strAltDelim)_Y,Y_$char(223))
          pobjRecord.set(m$.Fnc.$translate(pobjRecord.get(),mOp.Concat(m$.Fnc.$char(strAltDelim.get()),m$.var("Y").get()),mOp.Concat(m$.var("Y").get(),m$.Fnc.$char(223))));
        }
      }
    }
    //<< }
    //<< }
    //<< }
    //<< quit pobjRecord
    return pobjRecord.get();
  }

  //<< 
  //<< 
  //<< OBJECT(pidClass,pstrGlobal) ;READ AS OBJECT
  public Object OBJECT(Object ... _p) {
    mVar pidClass = m$.newVarRef("pidClass",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pstrGlobal = m$.newVarRef("pstrGlobal",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ;   SAVE AS OBJECT
    //<< ;   SET YA2      = ##class(class).%New()   ;OPEN ;table-mat
    //<< ;   SET YA2.NAME = VALUE                   ;table-mat
    //<< ;   SET YA5      = YA2.%Save()             ;speichern ;table-mat memorize
    //<< ;   SET YA5      = YA2.%close()            ;close ;table-mat
    //<< ;
    //<< ; History:
    //<< ; 10-Jul-2007   RPW     SR15571: Complete rewrite to brace syntax and nice variables.
    //<< ;-------------------------------------------------------------------------------
    //<< new idObject,objRecord,objForm,objClassField,strPropertyName,idList,idField,lstProperty
    mVar idObject = m$.var("idObject");
    mVar objRecord = m$.var("objRecord");
    mVar objForm = m$.var("objForm");
    mVar objClassField = m$.var("objClassField");
    mVar strPropertyName = m$.var("strPropertyName");
    mVar idList = m$.var("idList");
    mVar idField = m$.var("idField");
    mVar lstProperty = m$.var("lstProperty");
    m$.newVar(idObject,objRecord,objForm,objClassField,strPropertyName,idList,idField,lstProperty);
    //<< new loop,enumInputType,strValue
    mVar loop = m$.var("loop");
    mVar enumInputType = m$.var("enumInputType");
    mVar strValue = m$.var("strValue");
    m$.newVar(loop,enumInputType,strValue);
    //<< 
    //<< set idObject=$$GetObjectId^WWWSETObject(pstrGlobal)
    idObject.set(m$.fnc$("WWWSETObject.GetObjectId",pstrGlobal.get()));
    //<< 
    //<< set objRecord=""  ;DATENSATZ ;data record
    objRecord.set("");
    //<< if $$Exists^WWWSETObject(pidClass,idObject) {
    if (mOp.Logical(m$.fnc$("WWWSETObject.Exists",pidClass.get(),idObject.get()))) {
      //<< set objForm = $SYSTEM.OBJ.OpenId(pidClass,idObject)
      objForm.set(m$.getSystem().getOBJ().OpenId(pidClass.get(),idObject.get()));
      //<< set idField = ""
      idField.set("");
      //<< for {
      for (;true;) {
        //<< set idField = $order(^WWW003(0,pidClass,idField))
        idField.set(m$.Fnc.$order(m$.var("^WWW003",0,pidClass.get(),idField.get())));
        //<< quit:idField=""
        if (mOp.Equal(idField.get(),"")) {
          break;
        }
        //<< 
        //<< set objClassField = $translate($get(^WWW003(0,pidClass,idField,1)),";-:_/*#",",,,,,,")  ;DEFINITON
        objClassField.set(m$.Fnc.$translate(m$.Fnc.$get(m$.var("^WWW003",0,pidClass.get(),idField.get(),1)),";-:_/*#",",,,,,,"));
        //<< quit:objClassField=""
        if (mOp.Equal(objClassField.get(),"")) {
          break;
        }
        //<< 
        //<< set strPropertyName = $$$WWW003PropertyName(objClassField)
        strPropertyName.set(include.WWWConst.$$$WWW003PropertyName(m$,objClassField));
        //<< if strPropertyName="" set strPropertyName = $$$WWW003PropertyDescription(objClassField)  //$PIECE(objClassField,Y,1)  ;PROPERTYNAME
        if (mOp.Equal(strPropertyName.get(),"")) {
          strPropertyName.set(include.WWWConst.$$$WWW003PropertyDescription(m$,objClassField));
        }
        //<< continue:strPropertyName=""
        if (mOp.Equal(strPropertyName.get(),"")) {
          continue;
        }
        //<< ;KEINER ;nobody
        //<< if $$$WWW003AlternateInputType(objClassField)'="" {
        if (mOp.NotEqual(include.WWWConst.$$$WWW003AlternateInputType(m$,objClassField),"")) {
          //<< do DEEPLOAD($$$WWW003AlternateInputType(objClassField),strPropertyName,objForm)
          m$.Cmd.Do("DEEPLOAD",include.WWWConst.$$$WWW003AlternateInputType(m$,objClassField),strPropertyName.get(),objForm.get());
        }
        //<< } else {
        else {
          //<< 
          //<< set enumInputType=$$$WWW003InputType(objClassField)
          enumInputType.set(include.WWWConst.$$$WWW003InputType(m$,objClassField));
          //<< 
          //<< if enumInputType'=15 {
          if (mOp.NotEqual(enumInputType.get(),15)) {
            //<< set strValue=$zobjproperty(objForm,strPropertyName)
            strValue.set(m$.Fnc.$zobjproperty(objForm.get(),strPropertyName.get()));
            //<< /*
            //<< if enumInputType=14 {
            //<< if strValue'="" {
            //<< set strValue=$zdatetimeh(strValue,3) // Convert back from ODBC format for timestamps
            //<< }
            //<< }
            //<< */
            //<< set $piece(objRecord,Y,idField)=strValue
            m$.pieceVar(objRecord,m$.var("Y").get(),idField.get()).set(strValue.get());
          }
          //<< 
          //<< } else {
          else {
            //<< set lstProperty=$zobjproperty(objForm,strPropertyName)
            lstProperty.set(m$.Fnc.$zobjproperty(objForm.get(),strPropertyName.get()));
            //<< set idList=""
            idList.set("");
            //<< for loop=1:1:$listlength(lstProperty) {
            for (loop.set(1);(mOp.LessOrEqual(loop.get(),m$.Fnc.$listlength(lstProperty.get())));loop.set(mOp.Add(loop.get(),1))) {
              //<< set $piece(idList,";",loop)=$listget(lstProperty,loop)
              m$.pieceVar(idList,";",loop.get()).set(m$.Fnc.$listget(lstProperty.get(),loop.get()));
            }
            //<< }
            //<< set $piece(objRecord,Y,idField)=idList
            m$.pieceVar(objRecord,m$.var("Y").get(),idField.get()).set(idList.get());
          }
        }
      }
    }
    //<< }
    //<< }
    //<< }
    //<< }
    //<< 
    //<< quit objRecord
    return objRecord.get();
  }

  //<< 
  //<< DEEPLOAD(pidClass,pstrPropertyName,pobjForm)
  public Object DEEPLOAD(Object ... _p) {
    mVar pidClass = m$.newVarRef("pidClass",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pstrPropertyName = m$.newVarRef("pstrPropertyName",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pobjForm = m$.newVarRef("pobjForm",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Load existing objects
    //<< ;
    //<< ; Inputs:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 10-Jul-2007   RPW     SR15571: Rewrote in brace syntax (renamed from DEEPSAVE)
    //<< ;-------------------------------------------------------------------------------
    //<< quit:($get(YFORM)="")||($get(YUSER)="")
    if ((mOp.Equal(m$.Fnc.$get(m$.var("YFORM")),"")) || (mOp.Equal(m$.Fnc.$get(m$.var("YUSER")),""))) {
      return null;
    }
    //<< new idField,objClassField,strSubPropertyName
    mVar idField = m$.var("idField");
    mVar objClassField = m$.var("objClassField");
    mVar strSubPropertyName = m$.var("strSubPropertyName");
    m$.newVar(idField,objClassField,strSubPropertyName);
    //<< 
    //<< set idField=""
    idField.set("");
    //<< for {
    for (;true;) {
      //<< set idField=$order(^WWW003(0,pidClass,idField))
      idField.set(m$.Fnc.$order(m$.var("^WWW003",0,pidClass.get(),idField.get())));
      //<< quit:idField=""
      if (mOp.Equal(idField.get(),"")) {
        break;
      }
      //<< 
      //<< set objClassField=$translate($get(^WWW003(0,pidClass,idField,1)),";-:_/*#",",,,,,,,")
      objClassField.set(m$.Fnc.$translate(m$.Fnc.$get(m$.var("^WWW003",0,pidClass.get(),idField.get(),1)),";-:_/*#",",,,,,,,"));
      //<< quit:objClassField=""
      if (mOp.Equal(objClassField.get(),"")) {
        break;
      }
      //<< 
      //<< set strSubPropertyName=$$$WWW003PropertyName(objClassField)
      strSubPropertyName.set(include.WWWConst.$$$WWW003PropertyName(m$,objClassField));
      //<< if strSubPropertyName="" set strSubPropertyName=$$$WWW003PropertyDescription(objClassField)
      if (mOp.Equal(strSubPropertyName.get(),"")) {
        strSubPropertyName.set(include.WWWConst.$$$WWW003PropertyDescription(m$,objClassField));
      }
      //<< continue:strSubPropertyName=""
      if (mOp.Equal(strSubPropertyName.get(),"")) {
        continue;
      }
      //<< 
      //<< if $$$WWW003AlternateInputType(objClassField)'="" {
      if (mOp.NotEqual(include.WWWConst.$$$WWW003AlternateInputType(m$,objClassField),"")) {
        //<< do DEEPLOAD($$$WWW003AlternateInputType(objClassField),pstrPropertyName_"."_strSubPropertyName)
        m$.Cmd.Do("DEEPLOAD",include.WWWConst.$$$WWW003AlternateInputType(m$,objClassField),mOp.Concat(mOp.Concat(pstrPropertyName.get(),"."),strSubPropertyName.get()));
      }
      //<< } else {
      else {
        //<< if $ZOBJPROPERTY(pobjForm,pstrPropertyName)'="" {
        if (mOp.NotEqual(m$.Fnc.$zobjproperty(pobjForm.get(),pstrPropertyName.get()),"")) {
          //<< set ^WWWDATEN(YM,+$horolog,YUSER,YFORM,"DEEP",pidClass,pstrPropertyName,strSubPropertyName)=$ZOBJPROPERTY(pobjForm,pstrPropertyName_"."_strSubPropertyName)
          m$.var("^WWWDATEN",m$.var("YM").get(),mOp.Positive(m$.Fnc.$horolog()),m$.var("YUSER").get(),m$.var("YFORM").get(),"DEEP",pidClass.get(),pstrPropertyName.get(),strSubPropertyName.get()).set(m$.Fnc.$zobjproperty(pobjForm.get(),mOp.Concat(mOp.Concat(pstrPropertyName.get(),"."),strSubPropertyName.get())));
        }
        //<< } else {
        else {
          //<< set ^WWWDATEN(YM,+$horolog,YUSER,YFORM,"DEEP",pidClass,pstrPropertyName,strSubPropertyName)=""
          m$.var("^WWWDATEN",m$.var("YM").get(),mOp.Positive(m$.Fnc.$horolog()),m$.var("YUSER").get(),m$.var("YFORM").get(),"DEEP",pidClass.get(),pstrPropertyName.get(),strSubPropertyName.get()).set("");
        }
      }
    }
    //<< }
    //<< }
    //<< }
    //<< 
    //<< quit
    return null;
  }

  //<< 
  //<< PROG(pstrGlobal,&pobjRecord)
  public Object PROG(Object ... _p) {
    mVar pstrGlobal = m$.newVarRef("pstrGlobal",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pobjRecord = m$.newVarRef("pobjRecord",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ;   read program        ;LESEN PROGRAMM
    //<< ;   Loads a program and passes through each line
    //<< ;
    //<< ; Inputs:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 10-Jul-2007   RPW     SR15571: Rewrote in brace syntax
    //<< ;-------------------------------------------------------------------------------
    //<< QUIT:$FIND($GET(YAKTION),"/csp/") ;; Normally Disclinc would always have this
    if (mOp.Logical(m$.Fnc.$find(m$.Fnc.$get(m$.var("YAKTION")),"/csp/"))) {
      return null;
    }
    //<< QUIT
    return null;
  }

//<< 
//<< /* vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv DISABLED BLOCK START
//<< NEW YPRO,YEXE,I
//<< SET YPRO=$TRANSLATE($PIECE($PIECE(pstrGlobal,"(",2),",",2),"""")
//<< if ((YPRO'="") && (YPRO'="WWWSEAR3") && ($data(^$ROUTINE(YPRO)))) {
//<< SET YEXE="ZL @YPRO F I=1:1 Q:$T(+I)=""""  S pobjRecord=$E(pobjRecord_$T(+I),1,14000)_""|"""
//<< XECUTE YEXE
//<< }
//<< QUIT
//<< ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ DISABLED BLOCK END */
//<< 
//<< 
}
