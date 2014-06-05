//*****************************************************************************
//** TASC - ALPHALINC - MAC COMUtilLocale
//** Innovatium Systems - Code Converter - v1.29
//** 2014-06-03 20:55:04
//*****************************************************************************

import mLibrary.*;

//<< ;-------------------------------------------------------------------------------
//<< ;   Routines relating to Locality-based settings
//<< ;-------------------------------------------------------------------------------
//<< #include WWWConst
import include.WWWConst;
import include.COMSYS;
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

//<< COMUtilLocale
public class COMUtilLocale extends mClass {

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
    _COMUtilLocale();
  }

  public void _COMUtilLocale() {
  }

  //<< #;define LogR(%1,%2)    $$$JournalOff s ^zzLogR($g(YBED,"UNK"),$i(^zzLogR))= %1_"^COMUtilLocale("_%2_") : "_$zh $$$JournalOn
  //<< #;define LogRx(%1)      $$$JournalOff s ^zzLogR($g(YBED,"UNK"),$i(^zzLogR))=%1 $$$JournalOn
  //<< #;define LogRm(%1)      $$$JournalOff m ^zzLogR($g(YBED,"UNK"),$i(^zzLogR))=%1 $$$JournalOn
  //<< 
  //<< ;+++++++++++++++++++++++++++++++++++++++
  //<< ;  ^WWW100(0,"FELDFORMAT",Language,Type,1)  over-ridden by
  //<< ;  ^WWW101(0,"FELDFORMAT",Language,Type,1)  over-ridden by   <<< This should be deprecated
  //<< ;  ^INPARA(0,"FELDFORMAT",Language,Type,1)
  //<< ;
  //<< ;     Type
  //<< ;       0       ""
  //<< ;       1       "DD/MM/YYYY"        Date
  //<< ;       2       "X"
  //<< ;       3       "XXXXXXXXXX"
  //<< ;       4       "NNNN.NN"
  //<< ;       5       ""
  //<< ;       6       "XXXXXXXXXX"
  //<< ;       7       "NN:NN"             Time
  //<< ;       8       "NN,NNN.NN"         Thousands/Decimals
  //<< ;       9       "NNNN"
  //<< ;+++++++++++++++++++++++++++++++++++++++
  //<< 
  //<< GetNumberDelimiters(pidLanguage)
  public Object GetNumberDelimiters(Object ... _p) {
    mVar pidLanguage = m$.newVarRef("pidLanguage",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Common code to identify delimiters for thousands and decimal place
    //<< ; either Comma-Dot (English) or Dot-Comma (European)
    //<< ;
    //<< ; Called By :   ^INWEAUFD4, Initialise^WWWEVENT, AdjustCurrencyAmount^WWWEVENT,
    //<< ;               Convert^WWWTR, ^WWWVORG, ^WWWZAHL
    //<< ;
    //<< ; History:
    //<< ; 20-Jul-2011   shobby  SR17807: During an upgrade it is possible that INPARA is not
    //<< ;                                compiled yet. Unfortunate situation with a COM routine
    //<< ;                                calling a IN routine.
    //<< ; 05-Sep-2007   GRF     SR13729: Need to pass Language through to INPARA rather
    //<< ;                           than relying on SPRACHE.
    //<< ; 20-Aug-2007   GM      SR13729: Change "FELDFORMAT" parameter to $$GetFormat^INPARA()
    //<< ; 23-May-2007   GRF     SR15525: created
    //<< ;-------------------------------------------------------------------------------
    //<< new strDelim
    mVar strDelim = m$.var("strDelim");
    m$.newVar(strDelim);
    //<< 
    //<< $$$LogR("GetNumberDelimiters",pidLanguage)
    $$$LogR(m$,"GetNumberDelimiters",pidLanguage);
    //<< 
    //<< if pidLanguage'="" {
    if (mOp.NotEqual(pidLanguage.get(),"")) {
      //<< ;SR17807 set strDelim = $$GetFormat^INPARA(8,".,",pidLanguage)  ; 17807
      //<< set strDelim = $$GetFormat^WWW100(8,".,",pidLanguage)   ; 17807
      strDelim.set(m$.fnc$("WWW100.GetFormat",8,".,",pidLanguage.get()));
      //<< set strDelim = $translate(strDelim,"nNxX")
      strDelim.set(m$.Fnc.$translate(strDelim.get(),"nNxX"));
    }
    //<< }
    //<< 
    //<< if $length($get(strDelim))'=2 {
    if (mOp.NotEqual(m$.Fnc.$length(m$.Fnc.$get(strDelim)),2)) {
      //<< ;   European override at system level, Default to English format
      //<< set strDelim = $select($$$WWW012DecimalSigns($get(^WWW012(0,0,1)))=",":".,",1:",.")
      strDelim.set(m$.Fnc.$select(mOp.Equal(include.WWWConst.$$$WWW012DecimalSigns(m$,m$.Fnc.$get(m$.var("^WWW012",0,0,1))),","),".,",1,",."));
    }
    //<< }
    //<< 
    //<< quit strDelim
    return strDelim.get();
  }

  //<< 
  //<< 
  //<< GetDateFormat(&pstrFormat,&pstrDelim,pidLanguage="")
  public Object GetDateFormat(Object ... _p) {
    mVar pstrFormat = m$.newVarRef("pstrFormat",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pstrDelim = m$.newVarRef("pstrDelim",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pidLanguage = m$.newVarRef("pidLanguage",(((_p!=null)&&(_p.length>=3))?_p[2]:null),"");
    //<< ;-------------------------------------------------------------------------------
    //<< ;   Common code to identify date format
    //<< ;   based on user's (or nominated) language as Locale identifier
    //<< ;
    //<< ;     e.g. DD.MM.YYYY   or   MM/DD/YYYY   or variation
    //<< ;
    //<< ; Japanese YYYYMMDD - delimiter = ""   Okay here - check where used
    //<< ;
    //<< ; Inputs:
    //<< ;   pidLanguage     Optional Language code - defaults to SPRACHE
    //<< ;
    //<< ; Returns (By Ref):
    //<< ;   pstrFormat      DD.MM.YYYY
    //<< ;   pstrDelim       Delimiter from format (usually . / - or ,)
    //<< ;                                         Could be null for YYYYMMDD
    //<< ;
    //<< ;
    //<< ; History:
    //<< ; 09-Aug-11 shobby  SR17807:    GetFormat has moved.
    //<< ; 07-May-2009   GRF     SR16522: Pass override language to INPARA call
    //<< ; 20-Aug-2007   GM      SR13729: Change "FELDFORMAT" parameter to $$GetFormat^INPARA()
    //<< ; 13-Jun-2007   GRF     SR15525: created
    //<< ;-------------------------------------------------------------------------------
    //<< set:pidLanguage="" pidLanguage=$get(SPRACHE,"EN")
    if (mOp.Equal(pidLanguage.get(),"")) {
      pidLanguage.set(m$.Fnc.$get(m$.var("SPRACHE"),"EN"));
    }
    //<< 
    //<< set pstrDelim  = ""
    pstrDelim.set("");
    //<< ;SR17807 set pstrFormat = $$GetFormat^INPARA(1,"DD.MM.YYYY",pidLanguage)
    //<< set pstrFormat = $$GetFormat^WWW100(1,"DD.MM.YYYY",pidLanguage) ;SR17807
    pstrFormat.set(m$.fnc$("WWW100.GetFormat",1,"DD.MM.YYYY",pidLanguage.get()));
    //<< 
    //<< 
    //<< set pstrFormat = $translate(pstrFormat,"AJT","YYD")            ; TT.MM.JJJJ or DD.MM.AAAA => DD.MM.YYYY
    pstrFormat.set(m$.Fnc.$translate(pstrFormat.get(),"AJT","YYD"));
    //<< 
    //<< if $length(pstrFormat)=10 {                                    ; since fails YYYYMMDD
    if (mOp.Equal(m$.Fnc.$length(pstrFormat.get()),10)) {
      //<< set pstrDelim = $extract(pstrFormat,3)
      pstrDelim.set(m$.Fnc.$extract(pstrFormat.get(),3));
      //<< if pstrDelim="Y" set pstrDelim = $extract(pstrFormat,5)    ; YYYY.MM.DD?
      if (mOp.Equal(pstrDelim.get(),"Y")) {
        pstrDelim.set(m$.Fnc.$extract(pstrFormat.get(),5));
      }
    }
    //<< }
    //<< if pstrFormat="" set pstrDelim = "."
    if (mOp.Equal(pstrFormat.get(),"")) {
      pstrDelim.set(".");
    }
    //<< 
    //<< quit
    return null;
  }

//<< 
}
