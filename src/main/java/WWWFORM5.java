//*****************************************************************************
//** TASC - ALPHALINC - MAC WWWFORM5
//** Innovatium Systems - Code Converter - v1.30
//** 2014-06-10 15:22:00
//*****************************************************************************

import mLibrary.*;

//<< #include WWWConst
import include.WWWConst;
//import COMSYS;
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

//<< WWWFORM5
public class WWWFORM5 extends mClass {

  //<< 
  //<< #define LogR(%1,%2)     ;
  public static Object $$$LogR(mContext m$, Object ... _p) {
    mVar p$1 = m$.varRef("p$1",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar p$2 = m$.varRef("p$2",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    return null;
  }

  //<< #define LogRx(%1)       ;
  public static Object $$$LogRx(mContext m$, Object ... _p) {
    mVar p$1 = m$.varRef("p$1",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return null;
  }

  //<< #define LogRm(%1)       ;
  public static Object $$$LogRm(mContext m$, Object ... _p) {
    mVar p$1 = m$.varRef("p$1",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return null;
  }

  public void main() {
    _WWWFORM5();
  }

  public void _WWWFORM5() {
    //<< #;define LogR(%1,%2)    $$$JournalOff s ^zzLogR($g(YBED,"UNK"),$i(^zzLogR))= %1_"^WWWFORM5("_%2_") : "_$zh $$$JournalOn
    //<< #;define LogRx(%1)      $$$JournalOff s ^zzLogR($g(YBED,"UNK"),$i(^zzLogR))=%1 $$$JournalOn
    //<< #;define LogRm(%1)      $$$JournalOff m ^zzLogR($g(YBED,"UNK"),$i(^zzLogR))=%1 $$$JournalOn
    //<< ;-------------------------------------------------------------------------------
    //<< ; Description of Function :
    //<< ;       DEFAULTS FOR INDIVIDUAL ROUTINES   VORGABEN FÜR INDIVIDUALROUTINEN
    //<< ;
    //<< ; Inputs :
    //<< ;
    //<< ;
    //<< ; ByRef :
    //<< ;   YKEY
    //<< ;   A
    //<< ;   YCHANGE
    //<< ;
    //<< ; Returns :
    //<< ;   VV
    //<< ;   YP
    //<< ;
    //<< ;
    //<< ; History :
    //<< ; 02-Jan-2007   GRF     SR15335: Doco; brace format; use macros
    //<< ; 24.01.1998    DT
    //<< ;-------------------------------------------------------------------------------
    //<< new YI,YVOR1
    mVar YI = m$.var("YI");
    mVar YVOR1 = m$.var("YVOR1");
    m$.newVar(YI,YVOR1);
    //<< 
    //<< $$$LogR("","")
    $$$LogR(m$,"","");
    //<< 
    //<< set YP    = "HTM"
    mVar YP = m$.var("YP");
    YP.set("HTM");
    //<< set YVOR1 = $get(^WWW012(0,0,1))
    YVOR1.set(m$.Fnc.$get(m$.var("^WWW012",0,0,1)));
    //<< 
    //<< ;                                                          ; standard             ; in use
    //<< ;   D25     $$$WWW012VariableNameForPrimaryKey()           ; YKEY                 ; KEY
    //<< ;   D26     $$$WWW012VariableNameForDataItems()            ; YINHALT   (A?)       ; A
    //<< ;   D27     $$$WWW012VariableNameForDataSet()              ; YFELD                ; VV
    //<< ;   D28     $$$WWW012VariableNameForDataAvaila()           ; -         (YCHANGE?) ; MK1
    //<< ;   D30     $$$WWW012ExecuteAfterDataIsSaved()
    //<< if $$$WWW012ExecuteAfterDataIsSaved(YVOR1)'="" xecute $$$WWW012ExecuteAfterDataIsSaved(YVOR1)   ;  *** EXECUTE ? *** Actually *BEFORE* Saved
    if (mOp.NotEqual(include.WWWConst.$$$WWW012ExecuteAfterDataIsSaved(m$,YVOR1),"")) {
      m$.Cmd.Xecute(include.WWWConst.$$$WWW012ExecuteAfterDataIsSaved(m$,YVOR1));
    }
    //<< 
    //<< if $$$WWW012VariableNameForPrimaryKey(YVOR1)'="" {     ;PRIMÄRSCHLUESSEL
    if (mOp.NotEqual(include.WWWConst.$$$WWW012VariableNameForPrimaryKey(m$,YVOR1),"")) {
      //<< if $data(YKEY) {
      if (mOp.Logical(m$.Fnc.$data(m$.var("YKEY")))) {
        //<< set YVOR1(1) = $$$WWW012VariableNameForPrimaryKey(YVOR1)
        YVOR1.var(1).set(include.WWWConst.$$$WWW012VariableNameForPrimaryKey(m$,YVOR1));
        //<< for YI=1:1 {
        for (YI.set(1);(true);YI.set(mOp.Add(YI.get(),1))) {
          //<< quit:$piece(YKEY,",",YI)=""
          if (mOp.Equal(m$.Fnc.$piece(m$.var("YKEY").get(),",",YI.get()),"")) {
            break;
          }
          //<< 
          //<< set @(YVOR1(1)_"("_YI_")")=$translate($piece(YKEY,",",YI),"""")
          m$.indirectVar((mOp.Concat(mOp.Concat(mOp.Concat(YVOR1.var(1).get(),"("),YI.get()),")"))).set(m$.Fnc.$translate(m$.Fnc.$piece(m$.var("YKEY").get(),",",YI.get()),"\""));
        }
      }
    }
    //<< }
    //<< }
    //<< }
    //<< 
    //<< if $$$WWW012VariableNameForDataItems(YVOR1)'="" {      ;DATENFELDER
    if (mOp.NotEqual(include.WWWConst.$$$WWW012VariableNameForDataItems(m$,YVOR1),"")) {
      //<< if $data(A) set @($$$WWW012VariableNameForDataItems(YVOR1))=A
      if (mOp.Logical(m$.Fnc.$data(m$.var("A")))) {
        m$.indirectVar((include.WWWConst.$$$WWW012VariableNameForDataItems(m$,YVOR1))).set(m$.var("A").get());
      }
    }
    //<< }
    //<< 
    //<< if $$$WWW012VariableNameForDataSet(YVOR1)'="" {        ;DATENSATZ ;data record
    if (mOp.NotEqual(include.WWWConst.$$$WWW012VariableNameForDataSet(m$,YVOR1),"")) {
      //<< if $data(YFELD) set @($$$WWW012VariableNameForDataSet(YVOR1)_"(1)")=YFELD
      if (mOp.Logical(m$.Fnc.$data(m$.var("YFELD")))) {
        m$.indirectVar((mOp.Concat(include.WWWConst.$$$WWW012VariableNameForDataSet(m$,YVOR1),"(1)"))).set(m$.var("YFELD").get());
      }
      //<< set VV(1)=YFELD
      mVar VV = m$.var("VV");
      VV.var(1).set(m$.var("YFELD").get());
    }
    //<< }
    //<< 
    //<< if $$$WWW012VariableNameForDataAvaila(YVOR1)'="" {     ;DATENSATZ VORHANDEN J/N ;data record on hand
    if (mOp.NotEqual(include.WWWConst.$$$WWW012VariableNameForDataAvaila(m$,YVOR1),"")) {
      //<< set @($$$WWW012VariableNameForDataAvaila(YVOR1)) = ''$data(YCHANGE)
      m$.indirectVar((include.WWWConst.$$$WWW012VariableNameForDataAvaila(m$,YVOR1))).set(mOp.Not(mOp.Not(m$.Fnc.$data(m$.var("YCHANGE")))));
    }
    //<< }
    //<< quit
    return;
  }

//<< 
//<< 
}
