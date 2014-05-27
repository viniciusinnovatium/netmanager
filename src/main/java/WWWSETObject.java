//*****************************************************************************
//** TASC - ALPHALINC - MAC WWWSETObject
//** Innovatium Systems - Code Converter - v1.27
//** 2014-05-22 00:15:30
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

//<< WWWSETObject
public class WWWSETObject extends mClass {

  public void main() {
    _WWWSETObject();
  }

  public void _WWWSETObject() {
  }

  //<< 
  //<< GetObjectId(pstrGlobal)
  public Object GetObjectId(Object ... _p) {
    mVar pstrGlobal = m$.newVarRef("pstrGlobal",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Get the Caché id from the @Net id.
    //<< ;
    //<< ; Inputs:
    //<< ; pstrGlobal: The name of the global to find the id for
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 10-Jul-2007   RPW     SR15571: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new idANM,idObject,loop,strPiece
    mVar idANM = m$.var("idANM");
    mVar idObject = m$.var("idObject");
    mVar loop = m$.var("loop");
    mVar strPiece = m$.var("strPiece");
    m$.newVar(idANM,idObject,loop,strPiece);
    //<< 
    //<< ; TODO : Consider rewrite with $ql and $qs - benchmark
    //<< 
    //<< set idANM    = $translate($piece($piece(pstrGlobal,"(",2),")",1),"""")
    idANM.set(m$.Fnc.$translate(m$.Fnc.$piece(m$.Fnc.$piece(pstrGlobal.get(),"(",2),")",1),"\""));
    //<< set idObject = ""
    idObject.set("");
    //<< for loop=1:1 {
    for (loop.set(1);(true);loop.set(mOp.Add(loop.get(),1))) {
      //<< set strPiece = $piece(idANM,",",loop)
      strPiece.set(m$.Fnc.$piece(idANM.get(),",",loop.get()));
      //<< quit:strPiece=""
      if (mOp.Equal(strPiece.get(),"")) {
        break;
      }
      //<< 
      //<< set:loop'=1 idObject = idObject_"||"
      if (mOp.NotEqual(loop.get(),1)) {
        idObject.set(mOp.Concat(idObject.get(),"||"));
      }
      //<< set idObject = idObject_strPiece
      idObject.set(mOp.Concat(idObject.get(),strPiece.get()));
    }
    //<< }
    //<< 
    //<< quit idObject
    return idObject.get();
  }

  //<< 
  //<< Exists(pstrClassName,pidObject)
  public Object Exists(Object ... _p) {
    mVar pstrClassName = m$.newVarRef("pstrClassName",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pidObject = m$.newVarRef("pidObject",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Check if the data with the id exists on the object
    //<< ;
    //<< ; Inputs:
    //<< ; pstrClassName: The class to check
    //<< ; pidObject    : The id of the entry in the class
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 10-Jul-2007   RPW     SR15571: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new blnExists
    mVar blnExists = m$.var("blnExists");
    m$.newVar(blnExists);
    //<< 
    //<< set blnExists = $$$NO
    blnExists.set(include.COMSYS.$$$NO(m$));
    //<< if (pstrClassName'="") && (pidObject'="") {
    if ((mOp.NotEqual(pstrClassName.get(),"")) && (mOp.NotEqual(pidObject.get(),""))) {
      //<< set blnExists = $zobjclassmethod(pstrClassName,"%ExistsId",pidObject)
      blnExists.set(m$.Fnc.$zobjclassmethod(pstrClassName.get(),"%ExistsId",pidObject.get()));
    }
    //<< }
    //<< 
    //<< quit blnExists
    return blnExists.get();
  }

  //<< 
  //<< SetGlobal(&pstrGlobal,&pobjWWW001,&pidClass)
  public Object SetGlobal(Object ... _p) {
    mVar pstrGlobal = m$.newVarRef("pstrGlobal",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pobjWWW001 = m$.newVarRef("pobjWWW001",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pidClass = m$.newVarRef("pidClass",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Get the actual global that needs to be used to load/save/kill the data
    //<< ;
    //<< ; Inputs:
    //<< ; pstrGlobal: The name of the global to load
    //<< ; pobjWWW001: The class entry for this class.
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 10-Jul-2007   RPW     SR15571: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new strSaveInFile
    mVar strSaveInFile = m$.var("strSaveInFile");
    m$.newVar(strSaveInFile);
    //<< 
    //<< set pidClass=$piece($piece(pstrGlobal,"(",1),"^",2)
    pidClass.set(m$.Fnc.$piece(m$.Fnc.$piece(pstrGlobal.get(),"(",1),"^",2));
    //<< 
    //<< set pobjWWW001=""
    pobjWWW001.set("");
    //<< 
    //<< if ($extract(pidClass,1,2)'="IN") && (($extract(pidClass,1,3)'="WWW") || (pidClass="WWW000")) {
    if ((mOp.NotEqual(m$.Fnc.$extract(pidClass.get(),1,2),"IN")) && mOp.Logical(((mOp.NotEqual(m$.Fnc.$extract(pidClass.get(),1,3),"WWW")) || (mOp.Equal(pidClass.get(),"WWW000"))))) {
      //<< set pobjWWW001=$get(^WWW001(0,pidClass,1))
      pobjWWW001.set(m$.Fnc.$get(m$.var("^WWW001",0,pidClass.get(),1)));
    }
    //<< }
    //<< 
    //<< set strSaveInFile=$$$WWW001SaveDataInFile(pobjWWW001)
    strSaveInFile.set(include.WWWConst.$$$WWW001SaveDataInFile(m$,pobjWWW001));
    //<< 
    //<< if strSaveInFile'="" {
    if (mOp.NotEqual(strSaveInFile.get(),"")) {
      //<< set pstrGlobal="^"_strSaveInFile_"("_$piece(pstrGlobal,"(",2,99)
      pstrGlobal.set(mOp.Concat(mOp.Concat(mOp.Concat("^",strSaveInFile.get()),"("),m$.Fnc.$piece(pstrGlobal.get(),"(",2,99)));
    }
    //<< }
    //<< 
    //<< do ExtendedGlobalReference(.pstrGlobal,pobjWWW001)
    m$.Cmd.Do("ExtendedGlobalReference",pstrGlobal,pobjWWW001.get());
    //<< 
    //<< quit
    return null;
  }

  //<< 
  //<< ExtendedGlobalReference(&pstrGlobal,pobjWWW001)
  public Object ExtendedGlobalReference(Object ... _p) {
    mVar pstrGlobal = m$.newVarRef("pstrGlobal",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pobjWWW001 = m$.newVarRef("pobjWWW001",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Get the extended global reference if it's required
    //<< ;
    //<< ; Inputs:
    //<< ; pstrGlobal: The global to extend
    //<< ; pobjWWW001: WWW001 object
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 12-Jul-2007   RPW     SR15571: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new strUCI,strVolume
    mVar strUCI = m$.var("strUCI");
    mVar strVolume = m$.var("strVolume");
    m$.newVar(strUCI,strVolume);
    //<< 
    //<< ; FIXME : <GRF> May need to consider Environment Syntax ^|nsp|gbl as well as
    //<< ;               bracked syntax in the $find test.
    //<< 
    //<< set strUCI    = $$$WWW001OtherUCI(pobjWWW001)
    strUCI.set(include.WWWConst.$$$WWW001OtherUCI(m$,pobjWWW001));
    //<< set strVolume = $$$WWW001OtherVolume(pobjWWW001)
    strVolume.set(include.WWWConst.$$$WWW001OtherVolume(m$,pobjWWW001));
    //<< 
    //<< if (strUCI'="") && (strVolume'="") {
    if ((mOp.NotEqual(strUCI.get(),"")) && (mOp.NotEqual(strVolume.get(),""))) {
      //<< if '$find(pstrGlobal,"^[") {
      if (mOp.Not(m$.Fnc.$find(pstrGlobal.get(),"^["))) {
        //<< set pstrGlobal="^["""_strUCI_""","""_strVolume_"""]"_$piece(pstrGlobal,"^",2,999)
        pstrGlobal.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("^[\"",strUCI.get()),"\",\""),strVolume.get()),"\"]"),m$.Fnc.$piece(pstrGlobal.get(),"^",2,999)));
      }
    }
    //<< }
    //<< }
    //<< 
    //<< quit
    return null;
  }

//<< 
}
