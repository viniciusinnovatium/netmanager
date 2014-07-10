//*****************************************************************************
//** TASC - ALPHALINC - MAC WWWSETK
//** Innovatium Systems - Code Converter - v1.32
//** 2014-07-08 12:46:46
//*****************************************************************************

import mLibrary.*;
//<< 
//<< #include WWWConst
import include.WWWConst;
import include.COMSYS;

//<< WWWSETK(pstrGlobal)
public class WWWSETK extends mClass {

  public Object main(Object ... _p) {
    mVar pstrGlobal = m$.newVarRef("pstrGlobal",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return _WWWSETK(pstrGlobal);
  }

  public Object _WWWSETK(Object ... _p) {
    mVar pstrGlobal = m$.newVarRef("pstrGlobal",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Description of Function :
    //<< ;       Kill Values
    //<< ;       WERTE KILLEN
    //<< ;
    //<< ; Inputs :
    //<< ;   pstrGlobal=SCHLÜSSEL DER ZU LÖSCHEN IST ;the within Delete
    //<< ;
    //<< ; ByRef :
    //<< ;
    //<< ;
    //<< ; Returns :
    //<< ;
    //<< ;
    //<< ; History :
    //<< ; 22-Oct-2008   shobby  BR014985: Included change from FIS
    //<< ; 10-Jul-2007   RPW     SR15571: Rewrote to brace syntax
    //<< ; 05-Feb-2007   RPW     SR14900: Remove unused code.
    //<< ; 31.08.1997    DT      (C) BY DITMAR TYBUSSEK
    //<< ;-------------------------------------------------------------------------------
    //<< new pobjRecord,idClass,objWWW001,enumAltSaveProc
    mVar pobjRecord = m$.var("pobjRecord");
    mVar idClass = m$.var("idClass");
    mVar objWWW001 = m$.var("objWWW001");
    mVar enumAltSaveProc = m$.var("enumAltSaveProc");
    m$.newVar(pobjRecord,idClass,objWWW001,enumAltSaveProc);
    //<< 
    //<< SET pobjRecord=""
    pobjRecord.set("");
    //<< QUIT:$EXTRACT(pstrGlobal)'="^" pobjRecord
    if (mOp.NotEqual(m$.Fnc.$extract(pstrGlobal.get()),"^")) {
      return pobjRecord.get();
    }
    //<< 
    //<< do SetGlobal^WWWSETObject(.pstrGlobal,.objWWW001,.idClass)
    m$.Cmd.Do("WWWSETObject.SetGlobal",pstrGlobal,objWWW001,idClass);
    //<< 
    //<< set pobjRecord      = $$^WWWSETL(pstrGlobal)
    pobjRecord.set(m$.fnc$("WWWSETL.main",pstrGlobal.get()));
    //<< set enumAltSaveProc = $$$WWW001AltSaveProcedure(objWWW001)
    enumAltSaveProc.set(include.WWWConst.$$$WWW001AltSaveProcedure(m$,objWWW001));
    //<< 
    //<< if enumAltSaveProc>0 {                   ; ALTERNATIVE SAVE PROCEDURE
    if (mOp.Greater(enumAltSaveProc.get(),0)) {
      //<< if enumAltSaveProc=4 {
      if (mOp.Equal(enumAltSaveProc.get(),4)) {
      	if (idClass.get().toString().substring(0,3).equals("WWW")) {
            //<< do OBJECT(idClass,pstrGlobal)    ; CACHE
            m$.Cmd.Do("OBJECT",idClass.get(),pstrGlobal.get());
    	}
    	else {
	    	// ORM - NetManager Object
	      	mNMObject NMO = new mNMObject();
	      	mVar globalRef = m$.indirectVar(pstrGlobal.get());
	      	String globalRefID = "";
	      	for (int i=1;i<globalRef.getSubs().length;i++) {
	      		globalRefID = (globalRefID.isEmpty()?"":globalRefID+"||")+mFncUtil.toString(globalRef.getSubs()[i]);
	      	}
	      	NMO.deleteRecord(m$,idClass.get().toString(),globalRefID);
    	}
      }
      //<< } elseif enumAltSaveProc=5 {
      else if (mOp.Equal(enumAltSaveProc.get(),5)) {
        //<< do PROG(pstrGlobal)              ; DATEI FUER PROGRAMME ;data file
        m$.Cmd.Do("PROG",pstrGlobal.get());
      }
    }
    //<< }
    //<< } else {
    else {
      //<< ;***************************************
      //<< if $DATA(%KEY) TSTART
      if (mOp.Logical(m$.Fnc.$data(m$.var("%KEY")))) {
      }
	  if (idClass.get().toString().substring(0,3).equals("WWW")) {
		//<< KILL @pstrGlobal
		m$.indirectVar(pstrGlobal.get()).kill();
	  }
	  else {
		// ORM - NetManager Object
		mNMObject NMO = new mNMObject();
		mVar globalRef = m$.indirectVar(pstrGlobal.get());
		String globalRefID = "";
		for (int i=1;i<globalRef.getSubs().length-1;i++) {
		  globalRefID = (globalRefID.isEmpty()?"":globalRefID+"||")+mFncUtil.toString(globalRef.getSubs()[i]);
		}
		NMO.deleteRecord(m$,idClass.get().toString(),globalRefID);
	  }
      //<< do Out^WWWDataExchange("Delete",pstrGlobal) //FIS 17-Jan-2008 ;BR014985
      m$.Cmd.Do("WWWDataExchange.Out","Delete",pstrGlobal.get());
      //<< ;   SET Q=0                     ; SR15571
      //<< if $DATA(%KEY) TCOMMIT      ; JW FIXME: How about rollback otherwise ???
      if (mOp.Logical(m$.Fnc.$data(m$.var("%KEY")))) {
      }
    }
    //<< }
    //<< ;***************************************
    //<< QUIT pobjRecord
    return pobjRecord.get();
  }

  //<< 
  //<< OBJECT(pidClass,pstrGlobal)
  public Object OBJECT(Object ... _p) {
    mVar pidClass = m$.newVarRef("pidClass",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pstrGlobal = m$.newVarRef("pstrGlobal",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Delete the Caché Object
    //<< ;
    //<< ; Inputs:
    //<< ;   pstrGlobal="^DATEI(KEY...)"
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 10-Jul-2007   RPW     SR15571: Rewrote to brace syntax
    //<< ;-------------------------------------------------------------------------------
    //<< ;SET YA2=##class(class).%Exists(YA4)  ;table-mat
    //<< ;IF YA2 SET YA2=##class(class).%Delete(YA4) ;table-mat
    //<< new idObject
    mVar idObject = m$.var("idObject");
    m$.newVar(idObject);
    //<< 
    //<< set idObject=$$GetObjectId^WWWSETObject(pstrGlobal)
    idObject.set(m$.fnc$("WWWSETObject.GetObjectId",pstrGlobal.get()));
    //<< 
    //<< if $$Exists^WWWSETObject(pidClass,idObject) {  ;WENN ALTER DATENSATZ VORHANDEN = LÖSCHEN ;when governor data record on hand Delete
    if (mOp.Logical(m$.fnc$("WWWSETObject.Exists",pidClass.get(),idObject.get()))) {
      //<< do $zobjclassmethod(pidClass,"%DeleteId",idObject)
      m$.Cmd.Do("$zobjclassmethod",pidClass.get(),"%DeleteId",idObject.get());
    }
    //<< }
    //<< 
    //<< quit
    return null;
  }

  //<< 
  //<< PROG(pstrGlobal) ;LOESCHEN PROGRAMM ;programme
  public Object PROG(Object ... _p) {
    mVar pstrGlobal = m$.newVarRef("pstrGlobal",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; History:
    //<< ; 10-Jul-2007   RPW     SR15571: Rewrote to brace syntax
    //<< ;-------------------------------------------------------------------------------
    //<< ; Normally Disclinc would always have this
    //<< QUIT
    return null;
  }

//<< 
//<< /* vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv DISABLED BLOCK START
//<< NEW YPRO,YEXE,YDP,YNL
//<< SET YPRO=$TRANSLATE($PIECE($PIECE(pstrGlobal,"(",2),",",2),"""")
//<< QUIT:((YPRO="") || ($EXTRACT(YPRO,1,3)="WWW") || ($EXTRACT(YPRO)'="Y") || ('$data(^$ROUTINE(YPRO))))
//<< SET YEXE="ZR  ZS @YPRO"
//<< XECUTE YEXE
//<< QUIT
//<< ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ DISABLED BLOCK END */
//<< 
}
