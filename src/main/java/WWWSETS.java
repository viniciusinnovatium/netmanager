//*****************************************************************************
//** TASC - ALPHALINC - MAC WWWSETS
//** Innovatium Systems - Code Converter - v1.29
//** 2014-06-03 20:55:16
//*****************************************************************************

import mLibrary.*;

//<< #include WWWConst
import include.WWWConst;
import include.COMSYS;

//<< WWWSETS(pstrGlobal,pobjRecord,&pstrStatus)
public class WWWSETS extends mClass {

  public Object main(Object ... _p) {
    mVar pstrGlobal = m$.newVarRef("pstrGlobal",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pobjRecord = m$.newVarRef("pobjRecord",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pstrStatus = m$.newVarRef("pstrStatus",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    return _WWWSETS(pstrGlobal,pobjRecord,pstrStatus);
  }

  public Object _WWWSETS(Object ... _p) {
    mVar pstrGlobal = m$.newVarRef("pstrGlobal",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pobjRecord = m$.newVarRef("pobjRecord",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pstrStatus = m$.newVarRef("pstrStatus",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Description of Function :
    //<< ;       Set Values
    //<< ;       WERTE SETZEN
    //<< ;   S YOK=$$^WWWSETS("^TEST(0,1,1)","DATA~DATA~DATA")
    //<< ;
    //<< ; Inputs :
    //<< ;   pstrGlobal      Full Global Reference                KEY INKL "^DATEI(...)"
    //<< ;                   e.g. pstrGlobal="^FINGLAccount(0,123,1)"
    //<< ;   pobjRecord      Data Record "X1~X2~ ... ~Xn"        DATENSATZ
    //<< ;
    //<< ; ByRef :
    //<< ;   pstrStatus
    //<< ;
    //<< ; Returns :
    //<< ;   blnError        $$$NO  : $$$QSave
    //<< ;                   $$$YES : $$$QDontSave => HardFail in WWWSPEI
    //<< ;
    //<< ; History :
    //<< ; 22-Oct-2008   shobby  BR014985: Included change from FIS
    //<< ; 10-Jul-2007   RPW     SR15571: Complete rewrite to brace syntax and nice variables.
    //<< ; 05-Feb-2007   RPW     SR14900: Remove unused code.
    //<< ; 02-Jan-2006   GRF     Naked Reference (in disabled block!); doco; quits
    //<< ; 05-Jan-2006   Steve S Added Doco
    //<< ; 04.09.1997    DT      (C) BY DITMAR TYBUSSEK
    //<< ;-------------------------------------------------------------------------------
    //<< ; objWWW001: Data Dictionary (WWW001)
    //<< ;       D8 :     Alternate Save Procedure
    //<< ;       D9 :     Record Length
    //<< ;       D11:     Alternate Delimiter (ASCII)
    //<< ;       D12:     Other UCI
    //<< ;       D13:     Other Volume
    //<< ;       D18:     Send Modification To
    //<< ;       D22:     Save Data In File
    //<< ;
    //<< ; idClass:   Pure class name (e.g. "FINGLAccount")
    //<< ;++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    //<< new blnError,enumAltSaveProc,idClass,intMaxLen,objWWW001,strAltDelim,strSaveInFile
    mVar blnError = m$.var("blnError");
    mVar enumAltSaveProc = m$.var("enumAltSaveProc");
    mVar idClass = m$.var("idClass");
    mVar intMaxLen = m$.var("intMaxLen");
    mVar objWWW001 = m$.var("objWWW001");
    mVar strAltDelim = m$.var("strAltDelim");
    mVar strSaveInFile = m$.var("strSaveInFile");
    m$.newVar(blnError,enumAltSaveProc,idClass,intMaxLen,objWWW001,strAltDelim,strSaveInFile);
    //<< 
    //<< set blnError = $$$YES
    blnError.set(include.COMSYS.$$$YES(m$));
    //<< 
    //<< ; FIXME : <GRF> simplify as
    //<< ;     quit:($extract($get(pstrGlobal))'="^")||$find(pstrGlobal,"""""") blnError
    //<< quit:('$data(pstrGlobal))||(pstrGlobal="")||($extract(pstrGlobal)'="^")||($find(pstrGlobal,"""""")) blnError
    if ((mOp.Not(m$.Fnc.$data(pstrGlobal))) || (mOp.Equal(pstrGlobal.get(),"")) || (mOp.NotEqual(m$.Fnc.$extract(pstrGlobal.get()),"^")) || mOp.Logical((m$.Fnc.$find(pstrGlobal.get(),"\"\"")))) {
      return blnError.get();
    }
    //<< 
    //<< do SetGlobal^WWWSETObject(.pstrGlobal,.objWWW001,.idClass)
    m$.Cmd.Do("WWWSETObject.SetGlobal",pstrGlobal,objWWW001,idClass);
    //<< 
    //<< set intMaxLen = $$$WWW001RecordLength(objWWW001)
    intMaxLen.set(include.WWWConst.$$$WWW001RecordLength(m$,objWWW001));
    //<< if (intMaxLen="") || (intMaxLen>325000) {
    if ((mOp.Equal(intMaxLen.get(),"")) || (mOp.Greater(intMaxLen.get(),325000))) {
      //<< set intMaxLen = 325000
      intMaxLen.set(325000);
    }
    //<< }
    //<< 
    //<< ;---------------------------------------
    //<< ;  1. Swap the Global name to that in $$$WWW001SaveDataInFile if applicable.
    //<< ;  2. Perform alternative storage if applicable, or
    //<< ;  3. Store the data in pobjRecord into the Global specified
    //<< ;---------------------------------------
    //<< 
    //<< set enumAltSaveProc=$$$WWW001AltSaveProcedure(objWWW001)
    enumAltSaveProc.set(include.WWWConst.$$$WWW001AltSaveProcedure(m$,objWWW001));
    //<< 
    //<< ; FIXME : <GRF> write as "if 0 /elseif 4 /elseif 5" rather than nesting.
    //<< ;               Puts bulk of processing on first test.
    //<< 
    //<< if enumAltSaveProc>0 {
    if (mOp.Greater(enumAltSaveProc.get(),0)) {
      //<< if enumAltSaveProc=4 {
      if (mOp.Equal(enumAltSaveProc.get(),4)) {
        //<< set blnError=$$OBJECT(idClass,pstrGlobal,pobjRecord,.pstrStatus)    ;KLASSEN
        blnError.set(m$.fnc$("OBJECT",idClass.get(),pstrGlobal.get(),pobjRecord.get(),pstrStatus));
      }
      //<< } elseif enumAltSaveProc=5 {
      else if (mOp.Equal(enumAltSaveProc.get(),5)) {
        //<< do PROG(pstrGlobal,.pobjRecord)
        m$.Cmd.Do("PROG",pstrGlobal.get(),pobjRecord);
        //<< set blnError=$$$NO                  ;DATEI FUER PROGRAMME ;data file
        blnError.set(include.COMSYS.$$$NO(m$));
      }
    }
    //<< }
    //<< } else {
    else {
      //<< set strAltDelim=+$$$WWW001AltDelimiterASCII(objWWW001)
      strAltDelim.set(mOp.Positive(include.WWWConst.$$$WWW001AltDelimiterASCII(m$,objWWW001)));
      //<< ; NULL or TILDE
      //<< if (strAltDelim'=0)  && (strAltDelim'=126) {
      if ((mOp.NotEqual(strAltDelim.get(),0)) && (mOp.NotEqual(strAltDelim.get(),126))) {
        //<< set pobjRecord=$translate(pobjRecord,Y,$char($piece(objWWW001,Y,11)))
        pobjRecord.set(m$.Fnc.$translate(pobjRecord.get(),m$.var("Y").get(),m$.Fnc.$char(m$.Fnc.$piece(objWWW001.get(),m$.var("Y").get(),11))));
      }
      //<< }
      //<< 
      //<< ;--------------------------------------- TSTART
      //<< if $data(%KEY) TSTART
      if (mOp.Logical(m$.Fnc.$data(m$.var("%KEY")))) {
      }
      //<< ;---------------------------------------
      //<< if '$data(pobjRecord) set pobjRecord=""
      if (mOp.Not(m$.Fnc.$data(pobjRecord))) {
        pobjRecord.set("");
      }
      //<< 
      //<< do Out^WWWDataExchange("Save",pstrGlobal,pobjRecord) //FIS 17-Jan-2008 ;BR014985
      m$.Cmd.Do("WWWDataExchange.Out","Save",pstrGlobal.get(),pobjRecord.get());
      //<< set @pstrGlobal=$extract(pobjRecord,1,intMaxLen)
      m$.indirectVar(pstrGlobal.get()).set(m$.Fnc.$extract(pobjRecord.get(),1,intMaxLen.get()));
      //<< set blnError=$$$NO
      blnError.set(include.COMSYS.$$$NO(m$));
      //<< ;---------------------------------------
      //<< if $data(%KEY) TCOMMIT      // JW FIXME: How about rollback otherwise ???
      if (mOp.Logical(m$.Fnc.$data(m$.var("%KEY")))) {
      }
    }
    //<< ;---------------------------------------
    //<< }
    //<< 
    //<< QUIT blnError
    return blnError.get();
  }

  //<< 
  //<< OBJECT(pidClass,pstrGlobal,pobjRecord,&pstrStatus)
  public Object OBJECT(Object ... _p) {
    mVar pidClass = m$.newVarRef("pidClass",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pstrGlobal = m$.newVarRef("pstrGlobal",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pobjRecord = m$.newVarRef("pobjRecord",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    mVar pstrStatus = m$.newVarRef("pstrStatus",(((_p!=null)&&(_p.length>=4))?_p[3]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ;   SAVE AS OBJECT
    //<< ;       SET YA2=##class(class).%New()   ;OPEN ;table-mat
    //<< ;       SET YA2.NAME=VALUE              ;table-mat
    //<< ;       SET YA5=YA2.%Save()             ;speichern ;table-mat memorize
    //<< ;       SET YA5=YA2.%close()            ;close ;table-mat
    //<< ;
    //<< ; Inputs:
    //<< ;   pidClass
    //<< ;   pstrGlobal      "^DATEI(KEY..)"
    //<< ;   pobjRecord      "GESAMTER;DATENSATZ;"
    //<< ;
    //<< ; ByRef:
    //<< ;   pstrStatus
    //<< ;
    //<< ; History:
    //<< ; 10-Jul-2007   RPW     SR15571: Complete rewrite to brace syntax and nice variables.
    //<< ;-------------------------------------------------------------------------------
    //<< new blnError,enumInputType,idField,idList,idObject,loop,lstProperty
    mVar blnError = m$.var("blnError");
    mVar enumInputType = m$.var("enumInputType");
    mVar idField = m$.var("idField");
    mVar idList = m$.var("idList");
    mVar idObject = m$.var("idObject");
    mVar loop = m$.var("loop");
    mVar lstProperty = m$.var("lstProperty");
    m$.newVar(blnError,enumInputType,idField,idList,idObject,loop,lstProperty);
    //<< new objField,objForm,strField,strPropertyName,strStatus
    mVar objField = m$.var("objField");
    mVar objForm = m$.var("objForm");
    mVar strField = m$.var("strField");
    mVar strPropertyName = m$.var("strPropertyName");
    mVar strStatus = m$.var("strStatus");
    m$.newVar(objField,objForm,strField,strPropertyName,strStatus);
    //<< 
    //<< set idObject=$$GetObjectId^WWWSETObject(pstrGlobal)
    idObject.set(m$.fnc$("WWWSETObject.GetObjectId",pstrGlobal.get()));
    //<< 
    //<< if $$Exists^WWWSETObject(pidClass,idObject) {
    if (mOp.Logical(m$.fnc$("WWWSETObject.Exists",pidClass.get(),idObject.get()))) {
      //<< set objForm=$System.OBJ.OpenId(pidClass,idObject)
      objForm.set(m$.getSystem().getOBJ().OpenId(pidClass.get(),idObject.get()));
    }
    //<< } else {
    else {
      //<< set objForm=$System.OBJ.New(pidClass)
      objForm.set(m$.getSystem().getOBJ().New(pidClass.get()));
      //<< set objForm.Company=$piece(idObject,"||",1)
      m$.prop(objForm.get(),"Company").set(m$.Fnc.$piece(idObject.get(),"||",1));
      //<< //$$$Order3(^WWW002,0,pidClass,idField)
      //<< //set %1 = "" for { set %1 = $order(%2(%3,%4,%1)) quit:%1=""
      //<< set idField = "" for { set idField = $order(^WWW002(0,pidClass,idField)) quit:idField=""
      idField.set("");
      for (;true;) {
        idField.set(m$.Fnc.$order(m$.var("^WWW002",0,pidClass.get(),idField.get())));
        if (mOp.Equal(idField.get(),"")) {
          break;
        }
        //<< set objField=$translate($get(^WWW002(0,pidClass,idField,1)),";-:_/*#",",,,,,,,")  ;DEFINITON
        objField.set(m$.Fnc.$translate(m$.Fnc.$get(m$.var("^WWW002",0,pidClass.get(),idField.get(),1)),";-:_/*#",",,,,,,,"));
        //<< continue:objField=""
        if (mOp.Equal(objField.get(),"")) {
          continue;
        }
        //<< 
        //<< set strPropertyName=$$$WWW002PropertyName(objField)
        strPropertyName.set(include.WWWConst.$$$WWW002PropertyName(m$,objField));
        //<< if strPropertyName="" set strPropertyName=$$$WWW002PropertyDescription(objField)  ;PROPERTYNAME
        if (mOp.Equal(strPropertyName.get(),"")) {
          strPropertyName.set(include.WWWConst.$$$WWW002PropertyDescription(m$,objField));
        }
        //<< continue:strPropertyName=""
        if (mOp.Equal(strPropertyName.get(),"")) {
          continue;
        }
        //<< 
        //<< set $zobjproperty(objForm,strPropertyName)=$piece(idObject,"||",idField+1)
        mVar $zobjproperty = m$.var("$zobjproperty");
        $zobjproperty.var(objForm.get(),strPropertyName.get()).set(m$.Fnc.$piece(idObject.get(),"||",mOp.Add(idField.get(),1)));
      }
    }
    //<< //$$$End
    //<< }
    //<< }
    //<< 
    //<< //$$$Order3(^WWW003,0,pidClass,idField)
    //<< //set %1 = "" for { set %1 = $order(%2(%3,%4,%1)) quit:%1=""
    //<< set idField = "" for { set idField = $order(^WWW003(0,pidClass,idField)) quit:idField=""
    idField.set("");
    for (;true;) {
      idField.set(m$.Fnc.$order(m$.var("^WWW003",0,pidClass.get(),idField.get())));
      if (mOp.Equal(idField.get(),"")) {
        break;
      }
      //<< set objField=$translate($get(^WWW003(0,pidClass,idField,1)),";-:_/*#",",,,,,,,")  ;DEFINITON
      objField.set(m$.Fnc.$translate(m$.Fnc.$get(m$.var("^WWW003",0,pidClass.get(),idField.get(),1)),";-:_/*#",",,,,,,,"));
      //<< continue:objField=""
      if (mOp.Equal(objField.get(),"")) {
        continue;
      }
      //<< 
      //<< set strPropertyName=$$$WWW003PropertyName(objField)  ;PROPERTYNAME
      strPropertyName.set(include.WWWConst.$$$WWW003PropertyName(m$,objField));
      //<< if strPropertyName="" set strPropertyName=$$$WWW003PropertyDescription(objField)   ;PROPERTYNAME
      if (mOp.Equal(strPropertyName.get(),"")) {
        strPropertyName.set(include.WWWConst.$$$WWW003PropertyDescription(m$,objField));
      }
      //<< continue:strPropertyName=""  ;KEINER ;nobody
      if (mOp.Equal(strPropertyName.get(),"")) {
        continue;
      }
      //<< continue:$FIND(strPropertyName,".")
      if (mOp.Logical(m$.Fnc.$find(strPropertyName.get(),"."))) {
        continue;
      }
      //<< 
      //<< set strField=$piece(pobjRecord,Y,idField)
      strField.set(m$.Fnc.$piece(pobjRecord.get(),m$.var("Y").get(),idField.get()));
      //<< 
      //<< if $$$WWW003AlternateInputType(objField)'="" {
      if (mOp.NotEqual(include.WWWConst.$$$WWW003AlternateInputType(m$,objField),"")) {
        //<< do DEEPSAVE($$$WWW003AlternateInputType(objField),strPropertyName,objForm,strField)
        m$.Cmd.Do("DEEPSAVE",include.WWWConst.$$$WWW003AlternateInputType(m$,objField),strPropertyName.get(),objForm.get(),strField.get());
      }
      //<< 
      //<< } else {
      else {
        //<< set enumInputType=$$$WWW003InputType(objField)
        enumInputType.set(include.WWWConst.$$$WWW003InputType(m$,objField));
        //<< if enumInputType'=15 {
        if (mOp.NotEqual(enumInputType.get(),15)) {
          //<< /*
          //<< if enumInputType=14 { // Timestamp
          //<< if strField'="" {
          //<< set strField=$zdatetime(strField,3) // ODBC Time this is required for Timestamps
          //<< }
          //<< }
          //<< */
          //<< 
          //<< // Do not save fields if they have the same value as on disk
          //<< 
          //<< if strField'=$zobjproperty(objForm,strPropertyName) {
          if (mOp.NotEqual(strField.get(),m$.Fnc.$zobjproperty(objForm.get(),strPropertyName.get()))) {
            //<< set $zobjproperty(objForm,strPropertyName)=strField
            mVar $zobjproperty = m$.var("$zobjproperty");
            $zobjproperty.var(objForm.get(),strPropertyName.get()).set(strField.get());
          }
        }
        //<< }
        //<< } else {
        else {
          //<< set idList=strField
          idList.set(strField.get());
          //<< set lstProperty=""
          lstProperty.set("");
          //<< 
          //<< ;   NOTE : didn't have $translate(idList,";") check before SR15571
          //<< ;          lstProperty will now have $listlength = 0 if idList is empty
          //<< ;          whereas previously it had $listlength = 1 with first element = "".
          //<< ;          But didn't have lstProperty'=$zobjproperty check either.     <GRF>
          //<< if $translate(idList,";")'="" {
          if (mOp.NotEqual(m$.Fnc.$translate(idList.get(),";"),"")) {
            //<< for loop=1:1:$length(idList,";") {
            for (loop.set(1);(mOp.LessOrEqual(loop.get(),m$.Fnc.$length(idList.get(),";")));loop.set(mOp.Add(loop.get(),1))) {
              //<< set lstProperty=lstProperty_$lb($piece(idList,";",loop))
              lstProperty.set(mOp.Concat(lstProperty.get(),m$.Fnc.$listbuild(m$.Fnc.$piece(idList.get(),";",loop.get()))));
            }
          }
          //<< }
          //<< }
          //<< if lstProperty'=$zobjproperty(objForm,strPropertyName) {
          if (mOp.NotEqual(lstProperty.get(),m$.Fnc.$zobjproperty(objForm.get(),strPropertyName.get()))) {
            //<< set $zobjproperty(objForm,strPropertyName)=lstProperty
            mVar $zobjproperty = m$.var("$zobjproperty");
            $zobjproperty.var(objForm.get(),strPropertyName.get()).set(lstProperty.get());
          }
        }
      }
    }
    //<< }
    //<< }
    //<< }
    //<< //$$$End
    //<< }
    //<< 
    //<< set strStatus=objForm.%Save()
    strStatus.set(m$.fnc$(objForm.getORef(),"%Save"));
    //<< 
    //<< set blnError=$$$NO
    blnError.set(include.COMSYS.$$$NO(m$));
    //<< if $$$ISERR(strStatus) {
    if (mOp.Logical(include.COMSYS.$$$ISERR(m$,strStatus))) {
      //<< set pstrStatus=$$ISStatusToDLStatus^COMUtilError(strStatus)
      pstrStatus.set(m$.fnc$("COMUtilError.ISStatusToDLStatus",strStatus.get()));
      //<< set blnError=$$$YES
      blnError.set(include.COMSYS.$$$YES(m$));
    }
    //<< }
    //<< quit blnError
    return blnError.get();
  }

  //<< 
  //<< DEEPSAVE(pidClass,pstrPropertyName,pobjForm,pidSubClass)
  public Object DEEPSAVE(Object ... _p) {
    mVar pidClass = m$.newVarRef("pidClass",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pstrPropertyName = m$.newVarRef("pstrPropertyName",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pobjForm = m$.newVarRef("pobjForm",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    mVar pidSubClass = m$.newVarRef("pidSubClass",(((_p!=null)&&(_p.length>=4))?_p[3]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Save existing objects
    //<< ;
    //<< ; Inputs:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 10-Jul-2007   RPW     SR15571: Rewrote in brace syntax
    //<< ;-------------------------------------------------------------------------------
    //<< new idObject,blnSame,objProperty
    mVar idObject = m$.var("idObject");
    mVar blnSame = m$.var("blnSame");
    mVar objProperty = m$.var("objProperty");
    m$.newVar(idObject,blnSame,objProperty);
    //<< 
    //<< quit:($get(YFORM)="")||($get(YUSER)="")||(pidSubClass="")
    if ((mOp.Equal(m$.Fnc.$get(m$.var("YFORM")),"")) || (mOp.Equal(m$.Fnc.$get(m$.var("YUSER")),"")) || (mOp.Equal(pidSubClass.get(),""))) {
      return null;
    }
    //<< 
    //<< set pidSubClass=$$^WWWYM(pidClass)_","_pidSubClass
    pidSubClass.set(mOp.Concat(mOp.Concat(m$.fnc$("WWWYM.main",pidClass.get()),","),pidSubClass.get()));
    //<< 
    //<< set idObject=$$GetObjectId^WWWSETObject("("_pidSubClass_")")
    idObject.set(m$.fnc$("WWWSETObject.GetObjectId",mOp.Concat(mOp.Concat("(",pidSubClass.get()),")")));
    //<< 
    //<< if $$Exists^WWWSETObject(pidClass,idObject) {
    if (mOp.Logical(m$.fnc$("WWWSETObject.Exists",pidClass.get(),idObject.get()))) {
      //<< set objProperty=$zobjProperty(pobjForm,pstrPropertyName)
      objProperty.set(m$.Fnc.$zobjproperty(pobjForm.get(),pstrPropertyName.get()));
      //<< set blnSame=$$$NO
      blnSame.set(include.COMSYS.$$$NO(m$));
      //<< if objProperty'="" {
      if (mOp.NotEqual(objProperty.get(),"")) {
        //<< set blnSame=(objProperty.%Id()=idObject)
        blnSame.set((mOp.Equal(m$.fnc$(objProperty.getORef(),"%Id"),idObject.get())));
      }
      //<< }
      //<< set:'blnSame $zobjProperty(pobjForm,pstrPropertyName)=$System.OBJ.OpenId(pidClass,idObject)
      if (mOp.Not(blnSame.get())) {
        m$.var("$zobjProperty",pobjForm.get(),pstrPropertyName.get()).set(m$.getSystem().getOBJ().OpenId(pidClass.get(),idObject.get()));
      }
    }
    //<< }
    //<< 
    //<< QUIT
    return null;
  }

  //<< 
  //<< PROG(pstrGlobal,&pobjRecord) ;SCHREIBEN PROGRAMM ;write programme
  public Object PROG(Object ... _p) {
    mVar pstrGlobal = m$.newVarRef("pstrGlobal",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pobjRecord = m$.newVarRef("pobjRecord",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ;
    //<< ; Inputs:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 10-Jul-2007   RPW     SR15571: Rewrote in brace syntax
    //<< ;-------------------------------------------------------------------------------
    //<< ;; Normally Disclinc would always have this
    //<< QUIT
    return null;
  }

//<< 
//<< /* vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv DISABLED BLOCK START
//<< ;QUIT   ;RISIKO
//<< NEW YPRO,YEXE,YDP,YNL,I,YI
//<< 
//<< SET YPRO=$TRANSLATE($PIECE($PIECE(pstrGlobal,"(",2),",",2),"""")
//<< QUIT:(($EXTRACT(YPRO,1,3)="WWW") || ($EXTRACT(YPRO)'="Y"))
//<< SET YDP="|"
//<< SET YNL=""
//<< IF $TRANSLATE(pobjRecord,YDP)'="" {
//<< SET YEXE="ZR  F I=1:1 S YI=$P(pobjRecord,YDP,I) Q:$P(pobjRecord,YDP,I,9999)=YNL  I YI'=YNL ZI YI ZS @YPRO"
//<< XECUTE YEXE
//<< }
//<< QUIT
//<< ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ DISABLED BLOCK END */
//<< 
//<< 
}
