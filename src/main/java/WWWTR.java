//*****************************************************************************
//** TASC - ALPHALINC - MAC WWWTR
//** Innovatium Systems - Code Converter - v1.28
//** 2014-05-26 21:13:35
//*****************************************************************************

import mLibrary.*;

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

//<< WWWTR(pblnToInternal,penumDataType,pValue,pintShowDecs)
public class WWWTR extends mClass {

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

  public Object main(Object ... _p) {
    mVar pblnToInternal = m$.newVarRef("pblnToInternal",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar penumDataType = m$.newVarRef("penumDataType",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pValue = m$.newVarRef("pValue",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    mVar pintShowDecs = m$.newVarRef("pintShowDecs",(((_p!=null)&&(_p.length>=4))?_p[3]:null));
    return _WWWTR(pblnToInternal,penumDataType,pValue,pintShowDecs);
  }

  public Object _WWWTR(Object ... _p) {
    mVar pblnToInternal = m$.newVarRef("pblnToInternal",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar penumDataType = m$.newVarRef("penumDataType",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pValue = m$.newVarRef("pValue",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    mVar pintShowDecs = m$.newVarRef("pintShowDecs",(((_p!=null)&&(_p.length>=4))?_p[3]:null));
    //<< #;define LogR(%1,%2)    $$$JournalOff s ^zzLogR($g(YBED,"UNK"),$i(^zzLogR))= %1_"^WWWTR("_%2_") : "_$zh $$$JournalOn
    //<< #;define LogRx(%1)      $$$JournalOff s ^zzLogR($g(YBED,"UNK"),$i(^zzLogR))=%1 $$$JournalOn
    //<< #;define LogRm(%1)      $$$JournalOff m ^zzLogR($g(YBED,"UNK"),$i(^zzLogR))=%1 $$$JournalOn
    //<< 
    //<< ;-------------------------------------------------------------------------------
    //<< ; Inputs :
    //<< ;  pblnToInternal   Direction of transformation
    //<< ;                   = 1 Literal  to Internal format - Store
    //<< ;                   = 0 Internal to Literal  format - Display
    //<< ;
    //<< ;  penumDataType    DataType as in ^WWW100(0,"FELDTYP",SPRACHE,DataType,1)
    //<< ;                     with format in WWW101(0,"FELDFORMAT",SPRACHE,DataType,1) overriding
    //<< ;                     system setting in ^WWW100
    //<< ;  pValue           Value to be transformed
    //<< ;  pintShowDecs     Number of Decimal Places (applied to 12-Floating and 18-Exchange Rate only)
    //<< ;
    //<< ; ByRef :
    //<< ;   YDECIMAL        Decimal point as comma or period
    //<< ;   YDECIMALLEN     Number of decimal places (applied to 8-Currency only)
    //<< ;   SPRACHE         User's Language - for Locale-based conversions
    //<< ;   YWHR            Set Currency Code
    //<< ;
    //<< ;
    //<< ; Legacy Entry Point - DEPRECATED - use $$Convert^WWWTR rather than $$^WWWTR
    //<< ; 07-Jan-2011   GRF     SR17579: Add explicit entry point tags to eliminate need
    //<< ;                           for boolean parameter and make calls clearer.
    //<< ; 05-Jan-2009   GRF     SR15525: New version activated - original => WWWTRold
    //<< ;-------------------------------------------------------------------------------
    //<< 
    //<< quit $$Convert($get(pblnToInternal),$get(penumDataType),$get(pValue),$get(pintShowDecs))
    return m$.fnc$("Convert",m$.Fnc.$get(pblnToInternal),m$.Fnc.$get(penumDataType),m$.Fnc.$get(pValue),m$.Fnc.$get(pintShowDecs));
  }

  //<< 
  //<< 
  //<< Convert(pblnToInternal,penumDataType,pValue,pintShowDecs)
  public Object Convert(Object ... _p) {
    mVar pblnToInternal = m$.newVarRef("pblnToInternal",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar penumDataType = m$.newVarRef("penumDataType",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pValue = m$.newVarRef("pValue",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    mVar pintShowDecs = m$.newVarRef("pintShowDecs",(((_p!=null)&&(_p.length>=4))?_p[3]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Description of Function :
    //<< ;       Convert between Literal and Internal data formats
    //<< ;
    //<< ; *** USE GetInternal or GetLiteral IF pblnToInternal IS EXPLICITLY KNOWN ***
    //<< ;
    //<< ;  s YINHALT=$$Convert^WWWTR($$$NO,8,"1000")         ; display = 1.000,25 or 1,000.25  from internal 1000.25
    //<< ;  s YINHALT=$$Convert^WWWTR($$$YES,8,"1.000,00")    ; storage = 1000.25  from literal  1.000,25 or 1,000.25
    //<< ;  s YINHALT=$$Convert^WWWTR($$$NO,1,$horolog)       ; display DD.MM.YYYY or DD/MM/YYYY or MM/DD/YYYY or...
    //<< ;  s YINHALT=$$Convert^WWWTR($$$YES,1,"01.01.2000")  ; store in $horolog FORMAT
    //<< ;
    //<< ; Returns :
    //<< ;   Updated pValue (Null if input value is null)
    //<< ;
    //<< ; History :
    //<< ; 26-Mar-2009   GRF     SR16452: Added type 19 - Sequential Key
    //<< ; 29-Jan-2009   GRF     SR15525: Specific Entry Point rather than through
    //<< ;                           heading; retain legacy entry for now.
    //<< ; 13-Jun-2007   GRF     SR15525: General clean up
    //<< ; 11-Apr-2007   GRF     SRBR014310: Doco; braces
    //<< ; 11-Dec-2005   RPW     SR14144: Was not allowing a zero exchange rate
    //<< ; 22-Dec-2005   JW      SR13195: Edited memo and checkbox types for input.
    //<< ; 28-Oct-2005   JW      SR13074: Exchange Rate type. Invert depending on system setup.
    //<< ; 27-Oct-2005   SS/JW   SR13745: Added pintShowDecs (Dec. Places) parameter
    //<< ; 30-May-2005   RPW     SR12056: Attempt at Performance Increase
    //<< ; 15.Jan.1998   DT
    //<< ;-------------------------------------------------------------------------------
    //<< if $get(pValue)="" quit ""
    if (mOp.Equal(m$.Fnc.$get(pValue),"")) {
      return "";
    }
    //<< 
    //<< set pblnToInternal = +$get(pblnToInternal)
    pblnToInternal.set(mOp.Positive(m$.Fnc.$get(pblnToInternal)));
    //<< if '$data(penumDataType) set penumDataType = 6       ; "Text' by default
    if (mOp.Not(m$.Fnc.$data(penumDataType))) {
      penumDataType.set(6);
    }
    //<< set:$get(YDECIMAL)="" YDECIMAL = $extract($$GetNumberDelimiters^COMUtilLocale(SPRACHE),2)
    if (mOp.Equal(m$.Fnc.$get(m$.var("YDECIMAL")),"")) {
      m$.var("YDECIMAL").set(m$.Fnc.$extract(m$.fnc$("COMUtilLocale.GetNumberDelimiters",m$.var("SPRACHE").get()),2));
    }
    //<< 
    //<< if pblnToInternal {
    if (mOp.Logical(pblnToInternal.get())) {
      //<< do ToInternal(.pValue,penumDataType,YDECIMAL,$get(pintShowDecs))
      m$.Cmd.Do("ToInternal",pValue,penumDataType.get(),m$.var("YDECIMAL").get(),m$.Fnc.$get(pintShowDecs));
    }
    //<< } else {
    else {
      //<< do ToLiteral(.pValue,penumDataType,YDECIMAL,$get(pintShowDecs))
      m$.Cmd.Do("ToLiteral",pValue,penumDataType.get(),m$.var("YDECIMAL").get(),m$.Fnc.$get(pintShowDecs));
    }
    //<< }
    //<< quit pValue
    return pValue.get();
  }

  //<< 
  //<< 
  //<< GetInternal(penumDataType,pValue,pintShowDecs)
  public Object GetInternal(Object ... _p) {
    mVar penumDataType = m$.newVarRef("penumDataType",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pValue = m$.newVarRef("pValue",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pintShowDecs = m$.newVarRef("pintShowDecs",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Description of Function :
    //<< ;       Convert from Literal to Internal data format
    //<< ;
    //<< ;  s YINHALT=$$GetInternal^WWWTR(8,"1.000,00")    ; storage = 1000.25  from literal  1.000,25 or 1,000.25
    //<< ;  s YINHALT=$$GetInternal^WWWTR(1,"01.01.2000")  ; store in $horolog FORMAT
    //<< ;
    //<< ; Returns :
    //<< ;   Updated pValue (Null if input value is null)
    //<< ;
    //<< ; History :
    //<< ; 07-Jan-2011   GRF     SR17579: Add as explicit entry point tag ($$$YES case)
    //<< ;-------------------------------------------------------------------------------
    //<< if $get(pValue)="" quit ""
    if (mOp.Equal(m$.Fnc.$get(pValue),"")) {
      return "";
    }
    //<< 
    //<< if '$data(penumDataType) set penumDataType = 6       ; "Text' by default
    if (mOp.Not(m$.Fnc.$data(penumDataType))) {
      penumDataType.set(6);
    }
    //<< set:$get(YDECIMAL)="" YDECIMAL = $extract($$GetNumberDelimiters^COMUtilLocale(SPRACHE),2)
    if (mOp.Equal(m$.Fnc.$get(m$.var("YDECIMAL")),"")) {
      m$.var("YDECIMAL").set(m$.Fnc.$extract(m$.fnc$("COMUtilLocale.GetNumberDelimiters",m$.var("SPRACHE").get()),2));
    }
    //<< 
    //<< do ToInternal(.pValue,penumDataType,YDECIMAL,$get(pintShowDecs))
    m$.Cmd.Do("ToInternal",pValue,penumDataType.get(),m$.var("YDECIMAL").get(),m$.Fnc.$get(pintShowDecs));
    //<< quit pValue
    return pValue.get();
  }

  //<< 
  //<< 
  //<< GetLiteral(penumDataType,pValue,pintShowDecs)
  public Object GetLiteral(Object ... _p) {
    mVar penumDataType = m$.newVarRef("penumDataType",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pValue = m$.newVarRef("pValue",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pintShowDecs = m$.newVarRef("pintShowDecs",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Description of Function :
    //<< ;       Convert from Internal to Literal data format
    //<< ;
    //<< ;  s YINHALT=$$GetLiteral^WWWTR(8,"1000")         ; display = 1.000,25 or 1,000.25  from internal 1000.25
    //<< ;  s YINHALT=$$GetLiteral^WWWTR(1,$horolog)       ; display DD.MM.YYYY or DD/MM/YYYY or MM/DD/YYYY or...
    //<< ;
    //<< ; Returns :
    //<< ;   Updated pValue (Null if input value is null)
    //<< ;
    //<< ; History :
    //<< ; 07-Jan-2011   GRF     SR17579: Add as explicit entry point tag ($$$NO case)
    //<< ;-------------------------------------------------------------------------------
    //<< if $get(pValue)="" quit ""
    if (mOp.Equal(m$.Fnc.$get(pValue),"")) {
      return "";
    }
    //<< 
    //<< if '$data(penumDataType) set penumDataType = 6       ; "Text' by default
    if (mOp.Not(m$.Fnc.$data(penumDataType))) {
      penumDataType.set(6);
    }
    //<< set:$get(YDECIMAL)="" YDECIMAL = $extract($$GetNumberDelimiters^COMUtilLocale(SPRACHE),2)
    if (mOp.Equal(m$.Fnc.$get(m$.var("YDECIMAL")),"")) {
      m$.var("YDECIMAL").set(m$.Fnc.$extract(m$.fnc$("COMUtilLocale.GetNumberDelimiters",m$.var("SPRACHE").get()),2));
    }
    //<< 
    //<< do ToLiteral(.pValue,penumDataType,YDECIMAL,$get(pintShowDecs))
    m$.Cmd.Do("ToLiteral",pValue,penumDataType.get(),m$.var("YDECIMAL").get(),m$.Fnc.$get(pintShowDecs));
    //<< quit pValue
    return pValue.get();
  }

  //<< 
  //<< 
  //<< ToInternal(&pValue,penumDataType,YDECIMAL,pintShowDecs)
  public Object ToInternal(Object ... _p) {
    mVar pValue = m$.newVarRef("pValue",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar penumDataType = m$.newVarRef("penumDataType",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar YDECIMAL = m$.newVarRef("YDECIMAL",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    mVar pintShowDecs = m$.newVarRef("pintShowDecs",(((_p!=null)&&(_p.length>=4))?_p[3]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Input -> Storage
    //<< ;
    //<< ; Inputs:
    //<< ;   pValue          Value to be converted
    //<< ;   penumDataType   Data Type
    //<< ;   YDECIMAL        Decimal point as comma or period
    //<< ;   pintShowDecs    Required No of Decimal Places
    //<< ;
    //<< ; ByRefs:
    //<< ;   YWHR            Currency Code
    //<< ;   YDECIMALLEN     Number of Decimal Places
    //<< ;   YFORM           Calling form
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 23-May-2011   GRF     SR17250: relocate commented entries
    //<< ; 22-Feb-2010   GRF     SR17124: Corrected OutMemo; Restored call to InMemo
    //<< ; 18-Feb-2010   shobby  SR17124: Removed call to InMemo
    //<< ; 11-Apr-2007   GRF     SRBR014310: Naked References
    //<< ; 05-Apr-2007   RPW     Fixed IPAddress checks.
    //<< ; 27-Nov-2006   JW      SR15101: Convert invalid currency entry to 0
    //<< ;-------------------------------------------------------------------------------
    //<< set pValue = $translate(pValue,Y,"-")
    pValue.set(m$.Fnc.$translate(pValue.get(),m$.var("Y").get(),"-"));
    //<< ; FIXME : <GRF> Will treat Y_"123" as "-123".  Better than adding 2 pieces into
    //<< ;               one in record but may be other solutions.  (special char?)
    //<< 
    //<< if penumDataType=3 {
    if (mOp.Equal(penumDataType.get(),3)) {
      //<< set pValue = $$InMemo(pValue)           ;SR17124
      pValue.set(m$.fnc$("InMemo",pValue.get()));
    }
    //<< 
    //<< } else {
    else {
      //<< if ($get(YFORM)'="") && ($extract($get(YFORM),1,3)'="WWW") && ($extract($get(YFORM),1,3)'="APM") {
      if ((mOp.NotEqual(m$.Fnc.$get(m$.var("YFORM")),"")) && (mOp.NotEqual(m$.Fnc.$extract(m$.Fnc.$get(m$.var("YFORM")),1,3),"WWW")) && (mOp.NotEqual(m$.Fnc.$extract(m$.Fnc.$get(m$.var("YFORM")),1,3),"APM"))) {
        //<< ;   set pValue = $translate(pValue,""""_"'<>","´´()")              ;ANFÜHRUNGSZEICHEN NICHT UMSETZTEN ;FIS;19.02.03
        //<< if $$$WWW120DoNotConvertQuotes($get(^WWW120(0,YFORM,1)))'=$$$YES {
        if (mOp.NotEqual(include.WWWConst.$$$WWW120DoNotConvertQuotes(m$,m$.Fnc.$get(m$.var("^WWW120",0,m$.var("YFORM").get(),1))),include.COMSYS.$$$YES(m$))) {
          //<< set pValue = $translate(pValue,""""_"'","´´")
          pValue.set(m$.Fnc.$translate(pValue.get(),mOp.Concat("\"","'"),"´´"));
          //<< if (pValue["<") && (pValue[">") do ^WWWUML(pValue,2)  ;only where HTML tag present
          if ((mOp.Contains(pValue.get(),"<")) && (mOp.Contains(pValue.get(),">"))) {
            m$.Cmd.Do("WWWUML.main",pValue.get(),2);
          }
        }
      }
      //<< }
      //<< }
      //<< 
      //<< ;---------------------------------------
      //<< ; Commented types are left as-is
      //<< ;---------------------------------------
      //<< if penumDataType= 1       { set pValue = $$InDate(pValue)
      if (mOp.Equal(penumDataType.get(),1)) {
        pValue.set(m$.fnc$("InDate",pValue.get()));
      }
      //<< } elseif penumDataType= 2 { set pValue = $$InBoolean(pValue)
      else if (mOp.Equal(penumDataType.get(),2)) {
        pValue.set(m$.fnc$("InBoolean",pValue.get()));
      }
      //<< } elseif penumDataType= 4 { set pValue = $$InInteger(pValue,YDECIMAL)
      else if (mOp.Equal(penumDataType.get(),4)) {
        pValue.set(m$.fnc$("InInteger",pValue.get(),YDECIMAL.get()));
      }
      //<< } elseif penumDataType= 7 { set pValue = $$InTime(pValue)
      else if (mOp.Equal(penumDataType.get(),7)) {
        pValue.set(m$.fnc$("InTime",pValue.get()));
      }
      //<< } elseif penumDataType= 8 { set pValue = $$InCurrency(pValue,YDECIMAL,$get(YDECIMALLEN),$get(YWHR))
      else if (mOp.Equal(penumDataType.get(),8)) {
        pValue.set(m$.fnc$("InCurrency",pValue.get(),YDECIMAL.get(),m$.Fnc.$get(m$.var("YDECIMALLEN")),m$.Fnc.$get(m$.var("YWHR"))));
      }
      //<< } elseif penumDataType=12 { set pValue = $$InFloating(pValue,YDECIMAL,pintShowDecs)
      else if (mOp.Equal(penumDataType.get(),12)) {
        pValue.set(m$.fnc$("InFloating",pValue.get(),YDECIMAL.get(),pintShowDecs.get()));
      }
      //<< } elseif penumDataType=13 { set pValue = $$InIPFormat(pValue)
      else if (mOp.Equal(penumDataType.get(),13)) {
        pValue.set(m$.fnc$("InIPFormat",pValue.get()));
      }
      //<< } elseif penumDataType=14 { set pValue = $$InTimeStamp(pValue)
      else if (mOp.Equal(penumDataType.get(),14)) {
        pValue.set(m$.fnc$("InTimeStamp",pValue.get()));
      }
      //<< } elseif penumDataType=17 { set pValue = $$InDateYMD(pValue)
      else if (mOp.Equal(penumDataType.get(),17)) {
        pValue.set(m$.fnc$("InDateYMD",pValue.get()));
      }
      //<< } elseif penumDataType=18 { set pValue = $$InForEx(pValue,YDECIMAL,pintShowDecs)
      else if (mOp.Equal(penumDataType.get(),18)) {
        pValue.set(m$.fnc$("InForEx",pValue.get(),YDECIMAL.get(),pintShowDecs.get()));
      }
      //<< } elseif penumDataType=19 { set pValue = $$InSeqKey(pValue)
      else if (mOp.Equal(penumDataType.get(),19)) {
        pValue.set(m$.fnc$("InSeqKey",pValue.get()));
      }
    }
    //<< }
    //<< }
    //<< quit
    return null;
  }

  //<< ;--------------------------------------- Kept separately for improved performance
  //<< ;   } elseif penumDataType=0  { set pValue = $$InHidden(pValue)
  //<< ;   } elseif penumDataType= 3 { set pValue = $$InMemo(pValue)
  //<< ;   } elseif penumDataType= 5 { set pValue = $$InPassword(pValue)
  //<< ;   } elseif penumDataType= 6 { set pValue = $$InText(pValue)
  //<< ;   } elseif penumDataType= 9 { set pValue = $$InCounter(pValue)
  //<< ;   } elseif penumDataType=10 { set pValue = $$InFileName(pValue)
  //<< ;   } elseif penumDataType=11 { set pValue = $$InDraw(pValue)
  //<< ;   } elseif penumDataType=15 { set pValue = $$InCollection(pValue)
  //<< ;   } elseif penumDataType=16 { set pValue = $$InEmbedded(pValue)
  //<< ;---------------------------------------
  //<< 
  //<< 
  //<< ToLiteral(&pValue,penumDataType,YDECIMAL,pintShowDecs)
  public Object ToLiteral(Object ... _p) {
    mVar pValue = m$.newVarRef("pValue",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar penumDataType = m$.newVarRef("penumDataType",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar YDECIMAL = m$.newVarRef("YDECIMAL",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    mVar pintShowDecs = m$.newVarRef("pintShowDecs",(((_p!=null)&&(_p.length>=4))?_p[3]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ;   Convert internal format to literal format.
    //<< ;   OUTPUT VOM DISK ZUM USER
    //<< ;
    //<< ; Inputs:
    //<< ;   pValue          Value to be converted
    //<< ;   penumDataType   Data Type
    //<< ;   YDECIMAL        Decimal point as comma or period
    //<< ;   pintShowDecs    Required No of Decimal Places
    //<< ;
    //<< ; ByRef:
    //<< ;   YWHR            Currency Code
    //<< ;   YDECIMALLEN     Number of Decimal Places
    //<< ;
    //<< ; History:
    //<< ; 23-May-2011   GRF     SR17250: relocate commented entries
    //<< ; 02-Jun-2010   GRF     SR17146: pre-processing for date not required
    //<< ; 22-Feb-2010   GRF     SR17124: Corrected OutMemo; Restored call to InMemo
    //<< ; 15-May-2007   GRF     SRBR014469: Correction to Floating Point/Exchange Rate
    //<< ;                           types (12/18) to strip trailing zeros after the
    //<< ;                           decimal place.
    //<< ;-------------------------------------------------------------------------------
    //<< 
    //<< ;---------------------------------------
    //<< ; Commented types are left as-is
    //<< ;---------------------------------------
    //<< if penumDataType= 1        { set pValue = $$^WWWDATE(pValue) $$$LogRx("OutDate:"_pValue)    ;$$OutDate(pValue)
    if (mOp.Equal(penumDataType.get(),1)) {
      pValue.set(m$.fnc$("WWWDATE.main",pValue.get()));
      $$$LogRx(m$,mOp.Concat("OutDate:",pValue.get()));
    }
    //<< } elseif penumDataType= 2  { set pValue = $$OutBoolean(pValue)
    else if (mOp.Equal(penumDataType.get(),2)) {
      pValue.set(m$.fnc$("OutBoolean",pValue.get()));
    }
    //<< } elseif penumDataType= 3  { set pValue = $$OutMemo(pValue)
    else if (mOp.Equal(penumDataType.get(),3)) {
      pValue.set(m$.fnc$("OutMemo",pValue.get()));
    }
    //<< } elseif penumDataType= 4  { set pValue = $$OutInteger(pValue)
    else if (mOp.Equal(penumDataType.get(),4)) {
      pValue.set(m$.fnc$("OutInteger",pValue.get()));
    }
    //<< } elseif penumDataType= 7  { set pValue = $$OutTime(pValue)
    else if (mOp.Equal(penumDataType.get(),7)) {
      pValue.set(m$.fnc$("OutTime",pValue.get()));
    }
    //<< } elseif penumDataType= 8  { set pValue = $$OutCurrency(pValue,$get(YDECIMALLEN),$get(YWHR))
    else if (mOp.Equal(penumDataType.get(),8)) {
      pValue.set(m$.fnc$("OutCurrency",pValue.get(),m$.Fnc.$get(m$.var("YDECIMALLEN")),m$.Fnc.$get(m$.var("YWHR"))));
    }
    //<< } elseif penumDataType=12  { set pValue = $$OutFloating(pValue,YDECIMAL,pintShowDecs)
    else if (mOp.Equal(penumDataType.get(),12)) {
      pValue.set(m$.fnc$("OutFloating",pValue.get(),YDECIMAL.get(),pintShowDecs.get()));
    }
    //<< } elseif penumDataType=14  { set pValue = $$OutTimeStamp(pValue)
    else if (mOp.Equal(penumDataType.get(),14)) {
      pValue.set(m$.fnc$("OutTimeStamp",pValue.get()));
    }
    //<< } elseif penumDataType=17  { set pValue = $$OutDateYMD(pValue)
    else if (mOp.Equal(penumDataType.get(),17)) {
      pValue.set(m$.fnc$("OutDateYMD",pValue.get()));
    }
    //<< } elseif penumDataType=18  { set pValue = $$OutForEx(pValue,YDECIMAL,pintShowDecs)
    else if (mOp.Equal(penumDataType.get(),18)) {
      pValue.set(m$.fnc$("OutForEx",pValue.get(),YDECIMAL.get(),pintShowDecs.get()));
    }
    //<< } elseif penumDataType=19  { set pValue = $$OutSeqKey(pValue)
    else if (mOp.Equal(penumDataType.get(),19)) {
      pValue.set(m$.fnc$("OutSeqKey",pValue.get()));
    }
    //<< }
    //<< quit
    return null;
  }

  //<< ;--------------------------------------- Kept separately for improved performance
  //<< ;} elseif penumDataType=0  { set pValue = $$OutHidden(pValue)
  //<< ;} elseif penumDataType= 5 { set pValue = $$OutPassword(pValue)
  //<< ;} elseif penumDataType= 6 { set pValue = $$OutText(pValue)
  //<< ;} elseif penumDataType= 9 { set pValue = $$OutCounter(pValue)
  //<< ;} elseif penumDataType=10 { set pValue = $$OutFileName(pValue)
  //<< ;} elseif penumDataType=11 { set pValue = $$OutDraw(pValue)
  //<< ;} elseif penumDataType=13 { set pValue = $$OutIPFormat(pValue)
  //<< ;} elseif penumDataType=15 { set pValue = $$OutCollection(pValue)
  //<< ;} elseif penumDataType=16 { set pValue = $$OutEmbedded(pValue)
  //<< ;---------------------------------------
  //<< 
  //<< 
  //<< /*
  //<< InHidden(pValue)      ; Not in use
  //<< ;-------------------------------------------------------------------------------
  //<< ; penumDataType = 0
  //<< ;-------------------------------------------------------------------------------
  //<< quit pValue
  //<< 
  //<< OutHidden(pValue)     ; Not in use
  //<< quit pValue
  //<< */
  //<< 
  //<< 
  //<< InDate(pValue)
  public Object InDate(Object ... _p) {
    mVar pValue = m$.newVarRef("pValue",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; penumDataType = 1
    //<< ; Literal   : depends on location specification e.g. 15/01/2001
    //<< ; Internal  : +$horolog  e.g. 65000
    //<< ;-------------------------------------------------------------------------------
    //<< $$$LogR("InDate:",pValue)
    $$$LogR(m$,"InDate:",pValue);
    //<< /*   ; SR17146
    //<< if pValue="." {
    //<< set pValue = +$horolog
    //<< } else {
    //<< if $extract(pValue)="-" set pValue = $horolog-$extract(pValue,2,9)
    //<< if $extract(pValue)="+" set pValue = $horolog+$extract(pValue,2,9)
    //<< set pValue = $$^WWWDATE1(pValue)
    //<< }
    //<< */
    //<< set pValue = $$^WWWDATE1(pValue)
    pValue.set(m$.fnc$("WWWDATE1.main",pValue.get()));
    //<< $$$LogRx("ID:"_pValue)
    $$$LogRx(m$,mOp.Concat("ID:",pValue.get()));
    //<< quit pValue
    return pValue.get();
  }

  //<< 
  //<< /*  use directly
  //<< OutDate(pValue)
  //<< quit $$^WWWDATE(pValue)
  //<< */
  //<< 
  //<< 
  //<< InBoolean(pValue)
  public Object InBoolean(Object ... _p) {
    mVar pValue = m$.newVarRef("pValue",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; penumDataType = 2
    //<< ; "CHECKED" and "UNCHECKED" may be set in the Return Value
    //<< ;-------------------------------------------------------------------------------
    //<< if $find(pValue,$$$YES) set pValue = $$$YES   ; strange interpretation - "ABC1" => $$$YES, "ABC2" => $$$NO
    if (mOp.Logical(m$.Fnc.$find(pValue.get(),include.COMSYS.$$$YES(m$)))) {
      pValue.set(include.COMSYS.$$$YES(m$));
    }
    //<< if pValue="CHECKED"     set pValue = $$$YES
    if (mOp.Equal(pValue.get(),"CHECKED")) {
      pValue.set(include.COMSYS.$$$YES(m$));
    }
    //<< if pValue'=$$$YES       set pValue = ""       ; includes "UNCHECKED"
    if (mOp.NotEqual(pValue.get(),include.COMSYS.$$$YES(m$))) {
      pValue.set("");
    }
    //<< quit pValue
    return pValue.get();
  }

  //<< 
  //<< OutBoolean(pValue)
  public Object OutBoolean(Object ... _p) {
    mVar pValue = m$.newVarRef("pValue",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ; NOTE : Can not have pValue="" since stopped earlier but leave in case that changes.
    //<< quit $select(pValue=-1:$$$YES,pValue="":$$$NO,1:pValue)
    return m$.Fnc.$select(mOp.Equal(pValue.get(),mOp.Negative(1)),include.COMSYS.$$$YES(m$),mOp.Equal(pValue.get(),""),include.COMSYS.$$$NO(m$),1,pValue.get());
  }

  //<< 
  //<< 
  //<< InMemo(pValue)
  public Object InMemo(Object ... _p) {
    mVar pValue = m$.newVarRef("pValue",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; penumDataType = 3
    //<< ; FIXME : <GRF> Are we supposed to search only for CRLF or should simple CR be
    //<< ;               translated as well?   UNIX 13 / MAC 10 / PC 13,10  ?
    //<< ;-------------------------------------------------------------------------------
    //<< set pValue = $translate(pValue,$char(13,10),"|")
    pValue.set(m$.Fnc.$translate(pValue.get(),m$.Fnc.$char(13,10),"|"));
    //<< quit pValue
    return pValue.get();
  }

  //<< 
  //<< OutMemo(pValue)
  public Object OutMemo(Object ... _p) {
    mVar pValue = m$.newVarRef("pValue",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ;-------------------------------------------------------------------------------
    //<< quit $$Replace^COMUtilStr(pValue,"|",$$$CRLF)
    return m$.fnc$("COMUtilStr.Replace",pValue.get(),"|",include.COMSYSString.$$$CRLF(m$));
  }

  //<< 
  //<< 
  //<< InInteger(pValue,YDECIMAL)
  public Object InInteger(Object ... _p) {
    mVar pValue = m$.newVarRef("pValue",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar YDECIMAL = m$.newVarRef("YDECIMAL",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; penumDataType = 4   Involves truncation
    //<< ;
    //<< ; WARNING : Some data fields have type INTEGER when they should be FLOATING
    //<< ;           or something else.   (INTEGER was originally NUMBER - stricter
    //<< ;           interpretation)
    //<< ;-------------------------------------------------------------------------------
    //<< set pValue = +$$ConvertLocaleNumber(pValue,YDECIMAL)     ; temp
    pValue.set(mOp.Positive(m$.fnc$("ConvertLocaleNumber",pValue.get(),YDECIMAL.get())));
    //<< ;set pValue = $$ConvertLocaleNumber(pValue,YDECIMAL)\1   ; final - needs action to correct assigned types before swapping TODO : <GRF>
    //<< quit pValue
    return pValue.get();
  }

  //<< 
  //<< OutInteger(pValue)
  public Object OutInteger(Object ... _p) {
    mVar pValue = m$.newVarRef("pValue",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; NOTE : Literal form will now have thousands separator.
    //<< ;-------------------------------------------------------------------------------
    //<< set pValue = $$^WWWZAHL(pValue,0,0)
    pValue.set(m$.fnc$("WWWZAHL.main",pValue.get(),0,0));
    //<< quit pValue
    return pValue.get();
  }

  //<< 
  //<< 
  //<< /*
  //<< InPassword(pValue)    ; Not in use
  //<< ;-------------------------------------------------------------------------------
  //<< ; penumDataType = 5
  //<< ;-------------------------------------------------------------------------------
  //<< quit pValue
  //<< 
  //<< OutPassword(pValue)   ; Not in use
  //<< quit pValue
  //<< 
  //<< InText(pValue)        ; Not in use
  //<< ;-------------------------------------------------------------------------------
  //<< ; penumDataType = 6
  //<< ;-------------------------------------------------------------------------------
  //<< quit pValue
  //<< 
  //<< OutText(pValue)       ; Not in use
  //<< quit pValue
  //<< */
  //<< 
  //<< 
  //<< InTime(pValue)
  public Object InTime(Object ... _p) {
    mVar pValue = m$.newVarRef("pValue",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; penumDataType = 7
    //<< ; Literal   : HH:MM or HH:MM:SS
    //<< ; Internal  : 86399
    //<< ;-------------------------------------------------------------------------------
    //<< if pValue="." {   set pValue = $piece($horolog,",",2)
    if (mOp.Equal(pValue.get(),".")) {
      pValue.set(m$.Fnc.$piece(m$.Fnc.$horolog(),",",2));
    }
    //<< } else        {   set pValue = $$^WWWTIME1(pValue)
    else {
      pValue.set(m$.fnc$("WWWTIME1.main",pValue.get()));
    }
    //<< }
    //<< quit pValue
    return pValue.get();
  }

  //<< 
  //<< OutTime(pValue)
  public Object OutTime(Object ... _p) {
    mVar pValue = m$.newVarRef("pValue",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< set pValue = $$^WWWTIME(pValue)
    pValue.set(m$.fnc$("WWWTIME.main",pValue.get()));
    //<< quit pValue
    return pValue.get();
  }

  //<< 
  //<< 
  //<< InCurrency(pValue,YDECIMAL,YDECIMALLEN,pstrSetCurr)
  public Object InCurrency(Object ... _p) {
    mVar pValue = m$.newVarRef("pValue",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar YDECIMAL = m$.newVarRef("YDECIMAL",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar YDECIMALLEN = m$.newVarRef("YDECIMALLEN",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    mVar pstrSetCurr = m$.newVarRef("pstrSetCurr",(((_p!=null)&&(_p.length>=4))?_p[3]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; penumDataType = 8
    //<< ;
    //<< ; Inputs:
    //<< ;   pValue          Literal Value
    //<< ;   pstrSetCurr     (YWHR) Explicitly set currency code
    //<< ;   YDECIMALLEN     Number of Decimal Places
    //<< ;
    //<< ; Returns:
    //<< ;   curValue        May be simple float or foreign currency string
    //<< ;
    //<< ;-------------------------------------------------------------------------------
    //<< ;   If pstrSetCurr is null, the only conversion is from Locale-based
    //<< ;                           thousands/decimal literal format to an
    //<< ;                           internal format.
    //<< ;   If it is not null,      the following conversion is made in addition
    //<< ;                           to the Locale-based changes.
    //<< ;-------------------------------------------------------------------------------
    //<< ;               pValue                  Returns for pstrSetCurr = "USD"
    //<< ;           ""         not transformed
    //<< ; Category 1
    //<< ;          "0"                              0
    //<< ;               "@USD9.87@1.25"         0@USD9.87@1.25          (not expected)
    //<< ;        "abcdef"                           0                   (not expected)
    //<< ; Category 2
    //<< ;       "USD12.34"                      15.43@USD12.34@1.25
    //<< ;       "USD12.34@1.25"                 15.43@USD12.34@1.25
    //<< ;       "USD12.34@XYZ9.87@1.25"         15.43@USD12.34@1.25
    //<< ; Category 3
    //<< ;          "12.34@XYZ9.87@1.25"         15.43@XYZ9.87@1.25      (not expected ? - inconsistent figures)
    //<< ;          "12.34@1.25"                 15.43@1.25              (not expected)
    //<< ;          "12.34"                          15.43               (Sup Inv matching?)
    //<< ;
    //<< ;       curValue @ strCurrCalc
    //<< ;                      |
    //<< ;              strCurrCode_fltForeignCur@fltRate
    //<< ;-------------------------------------------------------------------------------
    //<< new curValue,fltForeignCur,fltRate,fltSetRate,strCurrCalc,strCurrCode
    mVar curValue = m$.var("curValue");
    mVar fltForeignCur = m$.var("fltForeignCur");
    mVar fltRate = m$.var("fltRate");
    mVar fltSetRate = m$.var("fltSetRate");
    mVar strCurrCalc = m$.var("strCurrCalc");
    mVar strCurrCode = m$.var("strCurrCode");
    m$.newVar(curValue,fltForeignCur,fltRate,fltSetRate,strCurrCalc,strCurrCode);
    //<< 
    //<< if YDECIMALLEN="" set YDECIMALLEN=2
    if (mOp.Equal(YDECIMALLEN.get(),"")) {
      YDECIMALLEN.set(2);
    }
    //<< 
    //<< set curValue    = $piece(pValue,"@",1)
    curValue.set(m$.Fnc.$piece(pValue.get(),"@",1));
    //<< set strCurrCalc = $piece(pValue,"@",2,99)
    strCurrCalc.set(m$.Fnc.$piece(pValue.get(),"@",2,99));
    //<< 
    //<< set curValue    = $translate(curValue," ;:_#`'")
    curValue.set(m$.Fnc.$translate(curValue.get()," ;:_#`'"));
    //<< set curValue    = $$ConvertLocaleNumber(curValue,YDECIMAL)                 ; Internal formats
    curValue.set(m$.fnc$("ConvertLocaleNumber",curValue.get(),YDECIMAL.get()));
    //<< set strCurrCalc = $$ConvertLocaleNumber(strCurrCalc,YDECIMAL)
    strCurrCalc.set(m$.fnc$("ConvertLocaleNumber",strCurrCalc.get(),YDECIMAL.get()));
    //<< 
    //<< set:$extract(curValue)="=" curValue = $$PerformCalculation(curValue)
    if (mOp.Equal(m$.Fnc.$extract(curValue.get()),"=")) {
      curValue.set(m$.fnc$("PerformCalculation",curValue.get()));
    }
    //<< 
    //<< if (pstrSetCurr'="") {
    if ((mOp.NotEqual(pstrSetCurr.get(),""))) {
      //<< if +curValue=0 {
      if (mOp.Equal(mOp.Positive(curValue.get()),0)) {
        //<< set strCurrCode = $zconvert($zstrip(curValue,"*E'A"),"U")
        strCurrCode.set(m$.Fnc.$zconvert(m$.Fnc.$zstrip(curValue.get(),"*E'A"),"U"));
        //<< if $ascii(strCurrCode)=128 set strCurrCode = "EUR"
        if (mOp.Equal(m$.Fnc.$ascii(strCurrCode.get()),128)) {
          strCurrCode.set("EUR");
        }
        //<< 
        //<< if (strCurrCode="") || '$data(^WWWWAE(0,strCurrCode)) {
        if ((mOp.Equal(strCurrCode.get(),"")) || mOp.Not(m$.Fnc.$data(m$.var("^WWWWAE",0,strCurrCode.get())))) {
          //<< ;---------------------------------------
          //<< ;   Category 1
          //<< ;---------------------------------------
          //<< set curValue = 0
          curValue.set(0);
        }
        //<< 
        //<< } else {
        else {
          //<< ;---------------------------------------
          //<< ;   Category 2 - recalculate AND rebuild
          //<< ;       curValue @ strCurrCalc  strCurrCode_fltForeignCur@fltRate
          //<< ;       "USD12.34"                  "USD"  _   "12.34"
          //<< ;       "USD12.34@1.25"             "USD"  _   "12.34"   @  "1.25"
          //<< ;       "USD12.34@XYZ9.87@1.25"     "USD"  _   "12.34"   @  "1.25"
          //<< ;---------------------------------------
          //<< ;       if strCurrCode="DM" set strCurrCode = "DEM"              ; obsolete
          //<< if strCurrCode="EU" set strCurrCode = "EUR"
          if (mOp.Equal(strCurrCode.get(),"EU")) {
            strCurrCode.set("EUR");
          }
          //<< 
          //<< set fltForeignCur = $zstrip(curValue,"*A","$"_$char(128))
          fltForeignCur.set(m$.Fnc.$zstrip(curValue.get(),"*A",mOp.Concat("$",m$.Fnc.$char(128))));
          //<< if +fltForeignCur=0 {
          if (mOp.Equal(mOp.Positive(fltForeignCur.get()),0)) {
            //<< set curValue = 0
            curValue.set(0);
          }
          //<< } else {
          else {
            //<< if strCurrCalc'="" {
            if (mOp.NotEqual(strCurrCalc.get(),"")) {
              //<< if strCurrCalc["@" {
              if (mOp.Contains(strCurrCalc.get(),"@")) {
                //<< set fltRate = $piece(strCurrCalc,"@",2)
                fltRate.set(m$.Fnc.$piece(strCurrCalc.get(),"@",2));
              }
              //<< } else {
              else {
                //<< set fltRate = strCurrCalc
                fltRate.set(strCurrCalc.get());
              }
            }
            //<< }
            //<< } else {
            else {
              //<< set fltRate = $$$WWWWAEUnitPrice($get(^WWWWAE(0,strCurrCode,1)))
              fltRate.set(include.WWWConst.$$$WWWWAEUnitPrice(m$,m$.Fnc.$get(m$.var("^WWWWAE",0,strCurrCode.get(),1))));
              //<< do GetConversionRate(YFORM,YKEY,.fltRate)
              m$.Cmd.Do("GetConversionRate",m$.var("YFORM").get(),m$.var("YKEY").get(),fltRate);
            }
            //<< }
            //<< 
            //<< set strCurrCalc=""
            strCurrCalc.set("");
            //<< if (strCurrCode'="") && (+fltForeignCur'=0) {
            if ((mOp.NotEqual(strCurrCode.get(),"")) && (mOp.NotEqual(mOp.Positive(fltForeignCur.get()),0))) {
              //<< set strCurrCalc = strCurrCode_fltForeignCur_"@"_fltRate
              strCurrCalc.set(mOp.Concat(mOp.Concat(mOp.Concat(strCurrCode.get(),fltForeignCur.get()),"@"),fltRate.get()));
            }
            //<< }
            //<< 
            //<< ;   SR14144 Allow any valid exchange rate to calculate the amount
            //<< if $isvalidnum(fltRate) {
            if (mOp.Logical(m$.Fnc.$isvalidnum(fltRate.get()))) {
              //<< set curValue = $justify(fltForeignCur*fltRate,0,YDECIMALLEN)
              curValue.set(m$.Fnc.$justify(mOp.Multiply(fltForeignCur.get(),fltRate.get()),0,YDECIMALLEN.get()));
            }
            //<< } else {
            else {
              //<< set curValue = fltForeignCur
              curValue.set(fltForeignCur.get());
            }
          }
        }
      }
      //<< }
      //<< }
      //<< }
      //<< 
      //<< } else {
      else {
        //<< ;---------------------------------------
        //<< ;   Category 3 - recalculate, but don't rebuild strCurrCalc
        //<< ;---------------------------------------
        //<< set fltSetRate = +$$$WWWWAEUnitPrice($get(^WWWWAE(0,pstrSetCurr,1)))
        fltSetRate.set(mOp.Positive(include.WWWConst.$$$WWWWAEUnitPrice(m$,m$.Fnc.$get(m$.var("^WWWWAE",0,pstrSetCurr.get(),1)))));
        //<< if fltSetRate'=0 set curValue = curValue * fltSetRate                 ;UMRECHNEN WÄHRUNGEN
        if (mOp.NotEqual(fltSetRate.get(),0)) {
          curValue.set(mOp.Multiply(curValue.get(),fltSetRate.get()));
        }
      }
    }
    //<< }
    //<< }
    //<< 
    //<< if strCurrCalc'="" {
    if (mOp.NotEqual(strCurrCalc.get(),"")) {
      //<< ;   if curValue is Locale-based then strCurrCalc needs to be as well.
      //<< set curValue = curValue_"@"_strCurrCalc
      curValue.set(mOp.Concat(mOp.Concat(curValue.get(),"@"),strCurrCalc.get()));
    }
    //<< }
    //<< 
    //<< quit curValue
    return curValue.get();
  }

  //<< 
  //<< OutCurrency(pValue,YDECIMALLEN,pstrCurrCode)
  public Object OutCurrency(Object ... _p) {
    mVar pValue = m$.newVarRef("pValue",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar YDECIMALLEN = m$.newVarRef("YDECIMALLEN",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pstrCurrCode = m$.newVarRef("pstrCurrCode",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    //<< new fltRate
    mVar fltRate = m$.var("fltRate");
    m$.newVar(fltRate);
    //<< 
    //<< if pValue["@" set pValue = $piece(pValue,"@",1)
    if (mOp.Contains(pValue.get(),"@")) {
      pValue.set(m$.Fnc.$piece(pValue.get(),"@",1));
    }
    //<< 
    //<< if pstrCurrCode="" set pstrCurrCode = " "
    if (mOp.Equal(pstrCurrCode.get(),"")) {
      pstrCurrCode.set(" ");
    }
    //<< set fltRate = +$$$WWWWAEUnitPrice($get(^WWWWAE(0,pstrCurrCode,1)))
    fltRate.set(mOp.Positive(include.WWWConst.$$$WWWWAEUnitPrice(m$,m$.Fnc.$get(m$.var("^WWWWAE",0,pstrCurrCode.get(),1)))));
    //<< if fltRate'=0 set pValue = pValue/fltRate
    if (mOp.NotEqual(fltRate.get(),0)) {
      pValue.set(mOp.Divide(pValue.get(),fltRate.get()));
    }
    //<< 
    //<< if (+pValue'=0) || (pValue="0") {
    if ((mOp.NotEqual(mOp.Positive(pValue.get()),0)) || (mOp.Equal(pValue.get(),"0"))) {
      //<< if YDECIMALLEN="" set YDECIMALLEN = 2
      if (mOp.Equal(YDECIMALLEN.get(),"")) {
        YDECIMALLEN.set(2);
      }
      //<< set pValue = $$^WWWZAHL(pValue,0,YDECIMALLEN)
      pValue.set(m$.fnc$("WWWZAHL.main",pValue.get(),0,YDECIMALLEN.get()));
    }
    //<< }
    //<< 
    //<< quit pValue
    return pValue.get();
  }

  //<< 
  //<< 
  //<< /*
  //<< InCounter(pValue)     ; Not in use
  //<< ;-------------------------------------------------------------------------------
  //<< ; penumDataType = 9
  //<< ;-------------------------------------------------------------------------------
  //<< ; Prior commented code - left as-is
  //<< ;if (pValue'="+") set pValue = $piece(+$translate(pValue,",","."),".",1)
  //<< quit pValue
  //<< 
  //<< OutCounter(pValue)  ; Not in use
  //<< ; Prior commented code - left as-is (only needs +pValue'=0 test)
  //<< ;if (+pValue'=0) && (pValue'="+") set pValue = +$piece(pValue,".",1)
  //<< quit pValue
  //<< */
  //<< 
  //<< /*
  //<< InFileName(pValue)    ; Not in use
  //<< ;-------------------------------------------------------------------------------
  //<< ; penumDataType = 10
  //<< ;-------------------------------------------------------------------------------
  //<< quit pValue
  //<< 
  //<< OutFileName(pValue)   ; Not in use
  //<< quit pValue
  //<< */
  //<< 
  //<< /*
  //<< InDraw(pValue)        ; Not in use
  //<< ;-------------------------------------------------------------------------------
  //<< ; penumDataType = 11
  //<< ;-------------------------------------------------------------------------------
  //<< quit pValue
  //<< 
  //<< OutDraw(pValue)       ; Not in use
  //<< quit pValue
  //<< */
  //<< 
  //<< 
  //<< InFloating(pValue,YDECIMAL,pintShowDecs)
  public Object InFloating(Object ... _p) {
    mVar pValue = m$.newVarRef("pValue",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar YDECIMAL = m$.newVarRef("YDECIMAL",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pintShowDecs = m$.newVarRef("pintShowDecs",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; penumDataType = 12   Also called by InForEx penumDataType=18
    //<< ;
    //<< ; possibly also CUR###
    //<< ;
    //<< ; Positive number        nnn.nnn            =+nnn.nnn           =nnn.nnn
    //<< ; Negative number       -nnn.nnn            =-nnn.nnn
    //<< ; Calculations          =nnn.nnn+nnn.nnn    =nnn.nnn-nnn.nnn    =nnn.nnn*nnn.nnn    =nnn.nnn/nnn.nnn
    //<< ;-------------------------------------------------------------------------------
    //<< if YDECIMALLEN="" set YDECIMALLEN = 2
    if (mOp.Equal(m$.var("YDECIMALLEN").get(),"")) {
      mVar YDECIMALLEN = m$.var("YDECIMALLEN");
      YDECIMALLEN.set(2);
    }
    //<< 
    //<< set pValue = $translate(pValue," ;:_#`'")
    pValue.set(m$.Fnc.$translate(pValue.get()," ;:_#`'"));
    //<< set pValue = $$ConvertLocaleNumber(pValue,YDECIMAL)
    pValue.set(m$.fnc$("ConvertLocaleNumber",pValue.get(),YDECIMAL.get()));
    //<< 
    //<< set:$extract(pValue)="=" pValue = $$PerformCalculation(pValue)
    if (mOp.Equal(m$.Fnc.$extract(pValue.get()),"=")) {
      pValue.set(m$.fnc$("PerformCalculation",pValue.get()));
    }
    //<< 
    //<< ;if +pValue=0 IF pValue'=0    set pValue = +$translate(pValue,"abcdefghijklmnopqrstuvwxyz$ABCDEFGHIJKLMNOPQRSTUVWXYZ"_$char(128))
    //<< if (+pValue=0) && (pValue'=0) set pValue = +$zstrip(pValue,"*A","$"_$char(128))
    if ((mOp.Equal(mOp.Positive(pValue.get()),0)) && (mOp.NotEqual(pValue.get(),0))) {
      pValue.set(mOp.Positive(m$.Fnc.$zstrip(pValue.get(),"*A",mOp.Concat("$",m$.Fnc.$char(128)))));
    }
    //<< if $extract(pValue,1,2)="0."  set pValue = +pValue
    if (mOp.Equal(m$.Fnc.$extract(pValue.get(),1,2),"0.")) {
      pValue.set(mOp.Positive(pValue.get()));
    }
    //<< set:pintShowDecs'="" pValue = +$justify(pValue,0,pintShowDecs)
    if (mOp.NotEqual(pintShowDecs.get(),"")) {
      pValue.set(mOp.Positive(m$.Fnc.$justify(pValue.get(),0,pintShowDecs.get())));
    }
    //<< 
    //<< quit pValue
    return pValue.get();
  }

  //<< 
  //<< OutFloating(pValue,YDECIMAL,pintShowDecs)
  public Object OutFloating(Object ... _p) {
    mVar pValue = m$.newVarRef("pValue",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar YDECIMAL = m$.newVarRef("YDECIMAL",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pintShowDecs = m$.newVarRef("pintShowDecs",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ;   Also called by OutForEx penumDataType=18
    //<< ;
    //<< ;  - If accuracy is not specified use number of decimals in number.
    //<< ;  - Convert to literal format
    //<< ;  - If there is a decimal point (locale-based) in the number,
    //<< ;       Remove trailing zeros.
    //<< ;       If last character is the decimal point, remove that too.
    //<< ;-------------------------------------------------------------------------------
    //<< if pintShowDecs="" set pintShowDecs = $length($piece(pValue,".",2))
    if (mOp.Equal(pintShowDecs.get(),"")) {
      pintShowDecs.set(m$.Fnc.$length(m$.Fnc.$piece(pValue.get(),".",2)));
    }
    //<< 
    //<< if (pValue'=0) {
    if ((mOp.NotEqual(pValue.get(),0))) {
      //<< set pValue = $$^WWWZAHL(pValue,0,pintShowDecs)
      pValue.set(m$.fnc$("WWWZAHL.main",pValue.get(),0,pintShowDecs.get()));
      //<< if pValue[YDECIMAL {
      if (mOp.Contains(pValue.get(),YDECIMAL.get())) {
        //<< for {
        for (;true;) {
          //<< quit:$extract(pValue,$length(pValue))'=0
          if (mOp.NotEqual(m$.Fnc.$extract(pValue.get(),m$.Fnc.$length(pValue.get())),0)) {
            break;
          }
          //<< 
          //<< set pValue = $extract(pValue,1,$length(pValue)-1)
          pValue.set(m$.Fnc.$extract(pValue.get(),1,mOp.Subtract(m$.Fnc.$length(pValue.get()),1)));
        }
        //<< }
        //<< if $extract(pValue,$length(pValue))=YDECIMAL set pValue = $extract(pValue,1,$length(pValue)-1)
        if (mOp.Equal(m$.Fnc.$extract(pValue.get(),m$.Fnc.$length(pValue.get())),YDECIMAL.get())) {
          pValue.set(m$.Fnc.$extract(pValue.get(),1,mOp.Subtract(m$.Fnc.$length(pValue.get()),1)));
        }
      }
    }
    //<< }
    //<< }
    //<< quit pValue
    return pValue.get();
  }

  //<< 
  //<< 
  //<< InIPFormat(pValue)
  public Object InIPFormat(Object ... _p) {
    mVar pValue = m$.newVarRef("pValue",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; penumDataType = 13
    //<< ;-------------------------------------------------------------------------------
    //<< set pValue = $$^WWWIP1($tr(pValue,"-, :\/#'+*;","..........."))
    pValue.set(m$.fnc$("WWWIP1.main",m$.Fnc.$translate(pValue.get(),"-, :\\/#'+*;","...........")));
    //<< quit pValue
    return pValue.get();
  }

  //<< 
  //<< /*
  //<< OutIPFormat(pValue)   ; Not in use
  //<< quit pValue
  //<< */
  //<< 
  //<< 
  //<< InTimeStamp(pValue)
  public Object InTimeStamp(Object ... _p) {
    mVar pValue = m$.newVarRef("pValue",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; penumDataType = 14
    //<< ; Literal   : DD/MM/YYYY HH:MM:SS
    //<< ; Internal  : 60000,40000 ($horolog)
    //<< ;-------------------------------------------------------------------------------
    //<< if (pValue=".")                  { set pValue = $horolog
    if ((mOp.Equal(pValue.get(),"."))) {
      pValue.set(m$.Fnc.$horolog());
    }
    //<< } elseif $piece(pValue," ",2)="" { set pValue = $$^WWWDATE1(pValue)
    else if (mOp.Equal(m$.Fnc.$piece(pValue.get()," ",2),"")) {
      pValue.set(m$.fnc$("WWWDATE1.main",pValue.get()));
    }
    //<< } else                           { set pValue = $$^WWWDATE1($piece(pValue," ",1))_","_$$^WWWTIME1($piece(pValue," ",2,4))
    else {
      pValue.set(mOp.Concat(mOp.Concat(m$.fnc$("WWWDATE1.main",m$.Fnc.$piece(pValue.get()," ",1)),","),m$.fnc$("WWWTIME1.main",m$.Fnc.$piece(pValue.get()," ",2,4))));
    }
    //<< }
    //<< quit pValue
    return pValue.get();
  }

  //<< 
  //<< OutTimeStamp(pValue)
  public Object OutTimeStamp(Object ... _p) {
    mVar pValue = m$.newVarRef("pValue",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< if $piece(pValue,",",2)'=""      { set pValue = $$^WWWDATE(pValue)_" "_$$^WWWTIME(+$piece(pValue,",",2))
    if (mOp.NotEqual(m$.Fnc.$piece(pValue.get(),",",2),"")) {
      pValue.set(mOp.Concat(mOp.Concat(m$.fnc$("WWWDATE.main",pValue.get())," "),m$.fnc$("WWWTIME.main",mOp.Positive(m$.Fnc.$piece(pValue.get(),",",2)))));
    }
    //<< } else                           { set pValue = $$^WWWDATE(pValue)
    else {
      pValue.set(m$.fnc$("WWWDATE.main",pValue.get()));
    }
    //<< }
    //<< quit pValue
    return pValue.get();
  }

  //<< 
  //<< 
  //<< /*
  //<< InCollection(pValue)  ; Not in use
  //<< ;-------------------------------------------------------------------------------
  //<< ; penumDataType = 15
  //<< ;-------------------------------------------------------------------------------
  //<< quit pValue
  //<< 
  //<< OutCollection(pValue) ; Not in use
  //<< ; vvvvv Disabled Block Start
  //<< ;  MULTI FELDER
  //<< ;IF '$FIND(pValue,";") IF $LISTGET(pValue,1)'=""  DO
  //<< . NEW Value1,loop
  //<< . SET Value1=pValue
  //<< . SET pValue=""
  //<< . FOR loop=1:1 QUIT:$LISTGET(Value1,loop)=""  SET pValue=pValue_$LISTGET(Value1,loop)_";"  QUIT:$LENGTH(pValue)>30000
  //<< ; ^^^^^ Disabled Block End
  //<< quit pValue
  //<< */
  //<< 
  //<< /*
  //<< InEmbedded(pValue)    ; Not in use
  //<< ;-------------------------------------------------------------------------------
  //<< ; penumDataType = 16
  //<< ;-------------------------------------------------------------------------------
  //<< quit pValue
  //<< 
  //<< OutEmbedded(pValue)   ; Not in use
  //<< quit pValue
  //<< */
  //<< 
  //<< 
  //<< InDateYMD(pValue)
  public Object InDateYMD(Object ... _p) {
    mVar pValue = m$.newVarRef("pValue",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; penumDataType = 17
    //<< ; Literal   : DD.MM.YYYY   or   DD   or   DD.MM   or   DD.MM.YY
    //<< ;             alternatively Locale-based
    //<< ;             MM.DD.YYYY   or   DD   or   MM.DD   or   MM.DD.YY
    //<< ;             (will also accept -/, as delimiters)
    //<< ; Internal  : YYYYMMDD
    //<< ;-------------------------------------------------------------------------------
    //<< new strDelim,strFormat
    mVar strDelim = m$.var("strDelim");
    mVar strFormat = m$.var("strFormat");
    m$.newVar(strDelim,strFormat);
    //<< 
    //<< do GetDateFormat^COMUtilLocale(.strFormat,.strDelim,SPRACHE)
    m$.Cmd.Do("COMUtilLocale.GetDateFormat",strFormat,strDelim,m$.var("SPRACHE").get());
    //<< set pValue = $translate(pValue,".-/,")
    pValue.set(m$.Fnc.$translate(pValue.get(),".-/,"));
    //<< 
    //<< if $extract(strFormat,1)="D" {
    if (mOp.Equal(m$.Fnc.$extract(strFormat.get(),1),"D")) {
      //<< if $length(pValue)=2 set pValue = pValue_$$^WWWMONTH()_$$^WWWYEAR()
      if (mOp.Equal(m$.Fnc.$length(pValue.get()),2)) {
        pValue.set(mOp.Concat(mOp.Concat(pValue.get(),m$.fnc$("WWWMONTH.main")),m$.fnc$("WWWYEAR.main")));
      }
      //<< if $length(pValue)=4 set pValue = pValue_$$^WWWYEAR()
      if (mOp.Equal(m$.Fnc.$length(pValue.get()),4)) {
        pValue.set(mOp.Concat(pValue.get(),m$.fnc$("WWWYEAR.main")));
      }
      //<< if $length(pValue)=6 set pValue = $extract(pValue,1,4)_$extract($$^WWWYEAR(),1,2)_$extract(pValue,5,6)
      if (mOp.Equal(m$.Fnc.$length(pValue.get()),6)) {
        pValue.set(mOp.Concat(mOp.Concat(m$.Fnc.$extract(pValue.get(),1,4),m$.Fnc.$extract(m$.fnc$("WWWYEAR.main"),1,2)),m$.Fnc.$extract(pValue.get(),5,6)));
      }
      //<< set pValue = $extract(pValue,5,8)_$extract(pValue,3,4)_$extract(pValue,1,2)
      pValue.set(mOp.Concat(mOp.Concat(m$.Fnc.$extract(pValue.get(),5,8),m$.Fnc.$extract(pValue.get(),3,4)),m$.Fnc.$extract(pValue.get(),1,2)));
    }
    //<< 
    //<< } elseif $extract(strFormat,1)="M" {
    else if (mOp.Equal(m$.Fnc.$extract(strFormat.get(),1),"M")) {
      //<< if $length(pValue)=2 set pValue = $$^WWWMONTH()_pValue_$$^WWWYEAR()
      if (mOp.Equal(m$.Fnc.$length(pValue.get()),2)) {
        pValue.set(mOp.Concat(mOp.Concat(m$.fnc$("WWWMONTH.main"),pValue.get()),m$.fnc$("WWWYEAR.main")));
      }
      //<< if $length(pValue)=4 set pValue = pValue_$$^WWWYEAR()
      if (mOp.Equal(m$.Fnc.$length(pValue.get()),4)) {
        pValue.set(mOp.Concat(pValue.get(),m$.fnc$("WWWYEAR.main")));
      }
      //<< if $length(pValue)=6 set pValue = $extract(pValue,1,4)_$extract($$^WWWYEAR(),1,2)_$extract(pValue,5,6)
      if (mOp.Equal(m$.Fnc.$length(pValue.get()),6)) {
        pValue.set(mOp.Concat(mOp.Concat(m$.Fnc.$extract(pValue.get(),1,4),m$.Fnc.$extract(m$.fnc$("WWWYEAR.main"),1,2)),m$.Fnc.$extract(pValue.get(),5,6)));
      }
      //<< set pValue = $extract(pValue,5,8)_$extract(pValue,1,2)_$extract(pValue,3,4)
      pValue.set(mOp.Concat(mOp.Concat(m$.Fnc.$extract(pValue.get(),5,8),m$.Fnc.$extract(pValue.get(),1,2)),m$.Fnc.$extract(pValue.get(),3,4)));
    }
    //<< 
    //<< } else {
    else {
    }
    //<< ; unrecognised date format (perhaps YYYYMMDD) - return as is
    //<< }
    //<< quit pValue
    return pValue.get();
  }

  //<< 
  //<< 
  //<< OutDateYMD(pValue)
  public Object OutDateYMD(Object ... _p) {
    mVar pValue = m$.newVarRef("pValue",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< new strDelim,strFormat
    mVar strDelim = m$.var("strDelim");
    mVar strFormat = m$.var("strFormat");
    m$.newVar(strDelim,strFormat);
    //<< 
    //<< do GetDateFormat^COMUtilLocale(.strFormat,.strDelim,SPRACHE)
    m$.Cmd.Do("COMUtilLocale.GetDateFormat",strFormat,strDelim,m$.var("SPRACHE").get());
    //<< if $extract(strFormat,1)="D" {
    if (mOp.Equal(m$.Fnc.$extract(strFormat.get(),1),"D")) {
      //<< set pValue = $extract(pValue,7,8)_strDelim_$extract(pValue,5,6)_strDelim_$extract(pValue,1,4)
      pValue.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(m$.Fnc.$extract(pValue.get(),7,8),strDelim.get()),m$.Fnc.$extract(pValue.get(),5,6)),strDelim.get()),m$.Fnc.$extract(pValue.get(),1,4)));
    }
    //<< 
    //<< } elseif $extract(strFormat,1)="M" {
    else if (mOp.Equal(m$.Fnc.$extract(strFormat.get(),1),"M")) {
      //<< set pValue = $extract(pValue,5,6)_strDelim_$extract(pValue,7,8)_strDelim_$extract(pValue,1,4)
      pValue.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(m$.Fnc.$extract(pValue.get(),5,6),strDelim.get()),m$.Fnc.$extract(pValue.get(),7,8)),strDelim.get()),m$.Fnc.$extract(pValue.get(),1,4)));
    }
    //<< 
    //<< } elseif strFormat="YYYYMMDD" {
    else if (mOp.Equal(strFormat.get(),"YYYYMMDD")) {
    }
    //<< ; return as is
    //<< 
    //<< } else {
    else {
    }
    //<< ; unrecognised date format - return as is
    //<< }
    //<< quit pValue
    return pValue.get();
  }

  //<< 
  //<< 
  //<< InForEx(pValue,YDECIMAL,pintShowDecs)
  public Object InForEx(Object ... _p) {
    mVar pValue = m$.newVarRef("pValue",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar YDECIMAL = m$.newVarRef("YDECIMAL",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pintShowDecs = m$.newVarRef("pintShowDecs",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; penumDataType = 18
    //<< ; If necessary, invert rate - retaining as much accuracy as possible internally
    //<< ; by leaving pintShowDecs as "".
    //<< ;
    //<< ; Can contain     "=###-###"   "=###+###"   "=###*###"
    //<< ;                 "=###/###"   "=###"       "###"           where ### is a value
    //<< ;                 "CUR###"                                        CUR is a currency code
    //<< ;-------------------------------------------------------------------------------
    //<< set pValue = $$InFloating(pValue,YDECIMAL,"")    ; Don't limit accuracy before inverting
    pValue.set(m$.fnc$("InFloating",pValue.get(),YDECIMAL.get(),""));
    //<< if +pValue'=0 {
    if (mOp.NotEqual(mOp.Positive(pValue.get()),0)) {
      //<< if $$$WWWSystemSetupExchangeRatesAsFraction($get(^WWWSystemSetup(0,0,1))) {
      if (mOp.Logical(include.WWWConst.$$$WWWSystemSetupExchangeRatesAsFraction(m$,m$.Fnc.$get(m$.var("^WWWSystemSetup",0,0,1))))) {
        //<< set pValue = 1 / pValue
        pValue.set(mOp.Divide(1,pValue.get()));
      }
    }
    //<< }
    //<< }
    //<< set:pintShowDecs'="" pValue = +$justify(pValue,0,pintShowDecs)
    if (mOp.NotEqual(pintShowDecs.get(),"")) {
      pValue.set(mOp.Positive(m$.Fnc.$justify(pValue.get(),0,pintShowDecs.get())));
    }
    //<< quit pValue
    return pValue.get();
  }

  //<< 
  //<< OutForEx(pValue,YDECIMAL,pintShowDecs)
  public Object OutForEx(Object ... _p) {
    mVar pValue = m$.newVarRef("pValue",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar YDECIMAL = m$.newVarRef("YDECIMAL",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pintShowDecs = m$.newVarRef("pintShowDecs",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ;  - Invert value if exchange rates are shown that way; limit accuracy to 10dp
    //<< ;  - If accuracy is not specified use number of decimals in number.
    //<< ;  - Convert to literal format
    //<< ;  - If there is a decimal point (locale-based) in the number,
    //<< ;       Remove trailing zeros.
    //<< ;       If last character is the decimal point, remove that too.
    //<< ;-------------------------------------------------------------------------------
    //<< if (+pValue'=0) {
    if ((mOp.NotEqual(mOp.Positive(pValue.get()),0))) {
      //<< if $$$WWWSystemSetupExchangeRatesAsFraction($get(^WWWSystemSetup(0,0,1))) {
      if (mOp.Logical(include.WWWConst.$$$WWWSystemSetupExchangeRatesAsFraction(m$,m$.Fnc.$get(m$.var("^WWWSystemSetup",0,0,1))))) {
        //<< set pValue = +$justify(1/pValue,0,10)
        pValue.set(mOp.Positive(m$.Fnc.$justify(mOp.Divide(1,pValue.get()),0,10)));
      }
    }
    //<< }
    //<< }
    //<< set pValue = $$OutFloating(pValue,YDECIMAL,pintShowDecs)
    pValue.set(m$.fnc$("OutFloating",pValue.get(),YDECIMAL.get(),pintShowDecs.get()));
    //<< quit pValue
    return pValue.get();
  }

  //<< 
  //<< 
  //<< InSeqKey(pValue)
  public Object InSeqKey(Object ... _p) {
    mVar pValue = m$.newVarRef("pValue",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; penumDataType = 19   Where an associated line is inserted with +.01 increments
    //<< ;                      Internal : "nnn.1"   Literal : "nnn.10"
    //<< ;
    //<< ; History:
    //<< ; 26-Mar-2009   GRF     SR16452: created
    //<< ;-------------------------------------------------------------------------------
    //<< set pValue = +pValue
    pValue.set(mOp.Positive(pValue.get()));
    //<< quit pValue
    return pValue.get();
  }

  //<< 
  //<< OutSeqKey(pValue)
  public Object OutSeqKey(Object ... _p) {
    mVar pValue = m$.newVarRef("pValue",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; History:
    //<< ; 26-Mar-2009   GRF     SR16452: created
    //<< ;-------------------------------------------------------------------------------
    //<< set pValue = $select(pValue[".":$justify(pValue,0,2),1:pValue)
    pValue.set(m$.Fnc.$select(mOp.Contains(pValue.get(),"."),m$.Fnc.$justify(pValue.get(),0,2),1,pValue.get()));
    //<< quit pValue
    return pValue.get();
  }

  //<< 
  //<< 
  //<< ;=============================================================  COMMON FUNCTIONS vvv
  //<< 
  //<< 
  //<< ConvertLocaleNumber(pstrValue,YDECIMAL)
  public Object ConvertLocaleNumber(Object ... _p) {
    mVar pstrValue = m$.newVarRef("pstrValue",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar YDECIMAL = m$.newVarRef("YDECIMAL",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Strip thousands delimiters and convert decimal place
    //<< ; in literal to internal numeric format change
    //<< ;
    //<< ;   Comma-Dot (English)  : Strip commas                            1,234.56 => 1234.56
    //<< ;   Dot-Comma (European) : Strip dots and convert commas to dots   1.234,56 => 1234.56
    //<< ;         becomes
    //<< ;   None-Dot  (Internal)
    //<< ;
    //<< ; set fltValue = $$ConvertLocaleNumber^WWWTR(pstrValue,YDECIMAL)
    //<< ;
    //<< ; History:
    //<< ; 23-May-2007   GRF     SR15525: created
    //<< ;-------------------------------------------------------------------------------
    //<< new numValue
    mVar numValue = m$.var("numValue");
    m$.newVar(numValue);
    //<< 
    //<< ;---------------------------------------
    //<< ; If necessary, calling routine should perform the following first.
    //<< ;    set:$get(YDECIMAL)="" YDECIMAL = $extract($$GetNumberDelimiters^COMUtilLocale(SPRACHE),2)
    //<< ;---------------------------------------
    //<< 
    //<< if YDECIMAL=","  {
    if (mOp.Equal(YDECIMAL.get(),",")) {
      //<< set numValue = $translate(pstrValue,",.",".")      ; European
      numValue.set(m$.Fnc.$translate(pstrValue.get(),",.","."));
    }
    //<< } else {
    else {
      //<< set numValue = $translate(pstrValue,",")           ; English
      numValue.set(m$.Fnc.$translate(pstrValue.get(),","));
    }
    //<< }
    //<< quit numValue
    return numValue.get();
  }

  //<< 
  //<< 
  //<< PerformCalculation(pstrCalc)
  public Object PerformCalculation(Object ... _p) {
    mVar pstrCalc = m$.newVarRef("pstrCalc",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Convert a calculation string starting with an equals character into an actual value.
    //<< ;
    //<< ; = ### op ###                    (without spaces)
    //<< ; = ###
    //<< ;
    //<< ; Where   op    can be     +, -, * or /
    //<< ; and     ###   is any number
    //<< ;
    //<< ; NOTE : doesn't handle leading + or - except in the single number version
    //<< ;
    //<< ; History:
    //<< ; 08-Jun-2007   GRF     SR15525: created
    //<< ;-------------------------------------------------------------------------------
    //<< new numValue
    mVar numValue = m$.var("numValue");
    m$.newVar(numValue);
    //<< 
    //<< set pstrCalc = $extract(pstrCalc,2,99)
    pstrCalc.set(m$.Fnc.$extract(pstrCalc.get(),2,99));
    //<< 
    //<< if (pstrCalc["-") {
    if ((mOp.Contains(pstrCalc.get(),"-"))) {
      //<< set numValue = $piece(pstrCalc,"-",1) - $piece(pstrCalc,"-",2)
      numValue.set(mOp.Subtract(m$.Fnc.$piece(pstrCalc.get(),"-",1),m$.Fnc.$piece(pstrCalc.get(),"-",2)));
    }
    //<< 
    //<< } elseif (pstrCalc["+") {
    else if ((mOp.Contains(pstrCalc.get(),"+"))) {
      //<< set numValue = $piece(pstrCalc,"+",1) + $piece(pstrCalc,"+",2)
      numValue.set(mOp.Add(m$.Fnc.$piece(pstrCalc.get(),"+",1),m$.Fnc.$piece(pstrCalc.get(),"+",2)));
    }
    //<< 
    //<< } elseif (pstrCalc["*") {
    else if ((mOp.Contains(pstrCalc.get(),"*"))) {
      //<< set numValue = $piece(pstrCalc,"*",1) * $piece(pstrCalc,"*",2)
      numValue.set(mOp.Multiply(m$.Fnc.$piece(pstrCalc.get(),"*",1),m$.Fnc.$piece(pstrCalc.get(),"*",2)));
    }
    //<< 
    //<< } elseif (pstrCalc["/") {
    else if ((mOp.Contains(pstrCalc.get(),"/"))) {
      //<< if +$piece(pstrCalc,"/",2)'=0 set numValue = $piece(pstrCalc,"/",1) / $piece(pstrCalc,"/",2)
      if (mOp.NotEqual(mOp.Positive(m$.Fnc.$piece(pstrCalc.get(),"/",2)),0)) {
        numValue.set(mOp.Divide(m$.Fnc.$piece(pstrCalc.get(),"/",1),m$.Fnc.$piece(pstrCalc.get(),"/",2)));
      }
    }
    //<< 
    //<< } else {
    else {
      //<< set numValue = +pstrCalc
      numValue.set(mOp.Positive(pstrCalc.get()));
    }
    //<< }
    //<< quit numValue
    return numValue.get();
  }

  //<< 
  //<< 
  //<< GetConversionRate(pstrYFORM,pstrYKEY,&pstrRate)
  public Object GetConversionRate(Object ... _p) {
    mVar pstrYFORM = m$.newVarRef("pstrYFORM",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pstrYKEY = m$.newVarRef("pstrYKEY",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pstrRate = m$.newVarRef("pstrRate",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Attempt to execute the code and log an error on failure.
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 01-Jun-2007   GRF     SR15525: was using YFORM rather than pstrYFORM
    //<< ; 15-Feb-2005   RPW     Do not log NOLINE errors at all.
    //<< ; 03-Feb-2005   RPW     Modified to show the error on the screen except for
    //<< ;                       NOLINE or NOROUTINE errors
    //<< ; 28-Jan-2005   RPW     Created (SR10061)
    //<< ;-------------------------------------------------------------------------------
    //<< new strCode,strRate
    mVar strCode = m$.var("strCode");
    mVar strRate = m$.var("strRate");
    m$.newVar(strCode,strRate);
    //<< 
    //<< set strCode = "set strRate=$$GetFCRate^"_pstrYFORM_"()"
    strCode.set(mOp.Concat(mOp.Concat("set strRate=$$GetFCRate^",pstrYFORM.get()),"()"));
    //<< set $ztrap  = "ExecuteCodeError^WWWTR"
    mVar $ztrap = m$.var("$ztrap");
    $ztrap.set("ExecuteCodeError^WWWTR");
    //<< xecute strCode
    m$.Cmd.Xecute(strCode.get());
    //<< if strRate'="" set pstrRate = strRate
    if (mOp.NotEqual(strRate.get(),"")) {
      pstrRate.set(strRate.get());
    }
    //<< quit
    return null;
  }

  //<< 
  //<< ExecuteCodeError  ; Internal Tag
  public void ExecuteCodeError() {
    //<< new strError,strUser
    mVar strError = m$.var("strError");
    mVar strUser = m$.var("strUser");
    m$.newVar(strError,strUser);
    //<< 
    //<< set $ztrap=""
    mVar $ztrap = m$.var("$ztrap");
    $ztrap.set("");
    //<< 
    //<< set strError = $zerror
    strError.set(m$.Fnc.$zerror());
    //<< 
    //<< if ($get(^DebugExecuteCode,0)'=0) && ($find(strError,"<NOLINE>")=0) {
    if ((mOp.NotEqual(m$.Fnc.$get(m$.var("^DebugExecuteCode"),0),0)) && (mOp.Equal(m$.Fnc.$find(strError.get(),"<NOLINE>"),0))) {
      //<< set strUser=$get(YBED,"UNKNOWN")
      strUser.set(m$.Fnc.$get(m$.var("YBED"),"UNKNOWN"));
      //<< set ^ExecuteCodeError(strUser,$i(^ExecuteCodeError(strUser)),$zdt($h,3),"Code")  = strCode
      m$.var("^ExecuteCodeError",strUser.get(),m$.Fnc.$increment(m$.var("^ExecuteCodeError",strUser.get())),m$.Fnc.$zdatetime(m$.Fnc.$horolog(),3),"Code").set(m$.var("strCode").get());
      //<< set ^ExecuteCodeError(strUser,$i(^ExecuteCodeError(strUser)),$zdt($h,3),"Error") = strError
      m$.var("^ExecuteCodeError",strUser.get(),m$.Fnc.$increment(m$.var("^ExecuteCodeError",strUser.get())),m$.Fnc.$zdatetime(m$.Fnc.$horolog(),3),"Error").set(strError.get());
    }
    //<< }
    //<< quit
    return;
  }

  //<< 
  //<< 
  //<< Cur(Amount)
  public Object Cur(Object ... _p) {
    mVar Amount = m$.newVarRef("Amount",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Return Currency Code
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 11-Apr-2005   PO      SR11349 Copied from ^COMSYSFC
    //<< ;-------------------------------------------------------------------------------
    //<< new Base,Foreign,Currency,Rate
    mVar Base = m$.var("Base");
    mVar Foreign = m$.var("Foreign");
    mVar Currency = m$.var("Currency");
    mVar Rate = m$.var("Rate");
    m$.newVar(Base,Foreign,Currency,Rate);
    //<< 
    //<< do Split(Amount,.Base,.Foreign,.Currency,.Rate)
    m$.Cmd.Do("Split",Amount.get(),Base,Foreign,Currency,Rate);
    //<< quit Currency
    return Currency.get();
  }

  //<< 
  //<< 
  //<< ConvRate(Amount)
  public Object ConvRate(Object ... _p) {
    mVar Amount = m$.newVarRef("Amount",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Return Conversion Rate
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 25-May-2007   GRF     SR15525: missing "@" in $length
    //<< ; 16-Jun-2005   PO      SR: Ensure Amount @ preceds FC amount
    //<< ; 30-May-2005   PO      SR12050: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new Base,Foreign,Currency,Rate
    mVar Base = m$.var("Base");
    mVar Foreign = m$.var("Foreign");
    mVar Currency = m$.var("Currency");
    mVar Rate = m$.var("Rate");
    m$.newVar(Base,Foreign,Currency,Rate);
    //<< 
    //<< ; Convert "USD20@.8" to "@USD20@.8" so aligned correctly for Split
    //<< 
    //<< if $length(Amount,"@")'=3 {
    if (mOp.NotEqual(m$.Fnc.$length(Amount.get(),"@"),3)) {
      //<< if Amount?1.A.E {
      if (mOp.Match(Amount.get(),"1.A.E")) {
        //<< set Amount = "@"_Amount
        Amount.set(mOp.Concat("@",Amount.get()));
      }
    }
    //<< }
    //<< }
    //<< do Split(Amount,.Base,.Foreign,.Currency,.Rate)
    m$.Cmd.Do("Split",Amount.get(),Base,Foreign,Currency,Rate);
    //<< quit Rate
    return Rate.get();
  }

  //<< 
  //<< 
  //<< FCBase(Amount)
  public Object FCBase(Object ... _p) {
    mVar Amount = m$.newVarRef("Amount",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Return Base Amount
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 01-Jun-2005   PO      SR12050: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new Base,Foreign,Currency,Rate
    mVar Base = m$.var("Base");
    mVar Foreign = m$.var("Foreign");
    mVar Currency = m$.var("Currency");
    mVar Rate = m$.var("Rate");
    m$.newVar(Base,Foreign,Currency,Rate);
    //<< 
    //<< do Split(Amount,.Base,.Foreign,.Currency,.Rate)
    m$.Cmd.Do("Split",Amount.get(),Base,Foreign,Currency,Rate);
    //<< quit Base
    return Base.get();
  }

  //<< 
  //<< FCAmount(Amount)
  public Object FCAmount(Object ... _p) {
    mVar Amount = m$.newVarRef("Amount",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Return Foreign Amount
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 25-May-2007   GRF     SR15525: missing "@" in $length
    //<< ; 16-Jun-2005   PO      SR: Ensure Amount @ preceds FC amount
    //<< ; 11-Apr-2005   PO      SR11349 Copied from ^COMSYSFC
    //<< ;-------------------------------------------------------------------------------
    //<< new Base,Foreign,Currency,Rate
    mVar Base = m$.var("Base");
    mVar Foreign = m$.var("Foreign");
    mVar Currency = m$.var("Currency");
    mVar Rate = m$.var("Rate");
    m$.newVar(Base,Foreign,Currency,Rate);
    //<< 
    //<< ; Convert "USD20@.8" to "@USD20@.8" so aligned correctly for Split
    //<< 
    //<< if $length(Amount,"@")'=3 {
    if (mOp.NotEqual(m$.Fnc.$length(Amount.get(),"@"),3)) {
      //<< if Amount?1.A.E {
      if (mOp.Match(Amount.get(),"1.A.E")) {
        //<< set Amount = "@"_Amount
        Amount.set(mOp.Concat("@",Amount.get()));
      }
    }
    //<< }
    //<< }
    //<< do Split(Amount,.Base,.Foreign,.Currency,.Rate)
    m$.Cmd.Do("Split",Amount.get(),Base,Foreign,Currency,Rate);
    //<< quit Foreign
    return Foreign.get();
  }

  //<< 
  //<< 
  //<< Split(Amount,Base,Foreign,Currency,Rate)
  public Object Split(Object ... _p) {
    mVar Amount = m$.newVarRef("Amount",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar Base = m$.newVarRef("Base",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar Foreign = m$.newVarRef("Foreign",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    mVar Currency = m$.newVarRef("Currency",(((_p!=null)&&(_p.length>=4))?_p[3]:null));
    mVar Rate = m$.newVarRef("Rate",(((_p!=null)&&(_p.length>=5))?_p[4]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Split FC Amount to Base Amount, Foreign Amount, Currency Code, Rate
    //<< ;
    //<< ; By Ref : Base,Foreign,Currency,Rate
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 11-Apr-2005   PO      SR11349 Copied from ^COMSYSFC
    //<< ;-------------------------------------------------------------------------------
    //<< new FC
    mVar FC = m$.var("FC");
    m$.newVar(FC);
    //<< 
    //<< set Base = $piece(Amount,"@",1)
    Base.set(m$.Fnc.$piece(Amount.get(),"@",1));
    //<< set FC   = $piece(Amount,"@",2)
    FC.set(m$.Fnc.$piece(Amount.get(),"@",2));
    //<< set Rate = $piece(Amount,"@",3)
    Rate.set(m$.Fnc.$piece(Amount.get(),"@",3));
    //<< 
    //<< set Foreign  = $translate(FC,"abcdefghijklmnopqrstuvwxyz$ABCDEFGHIJKLMNOPQRSTUVWXYZ")
    Foreign.set(m$.Fnc.$translate(FC.get(),"abcdefghijklmnopqrstuvwxyz$ABCDEFGHIJKLMNOPQRSTUVWXYZ"));
    //<< set Currency = $translate(FC," -1234567890,.")
    Currency.set(m$.Fnc.$translate(FC.get()," -1234567890,."));
    //<< 
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< ;+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
  //<< 
  //<< 
  //<< TestAll(pnumNewDP="")
  public Object TestAll(Object ... _p) {
    mVar pnumNewDP = m$.newVarRef("pnumNewDP",(((_p!=null)&&(_p.length>=1))?_p[0]:null),"");
    //<< new SPRACHE,YDECIMAL
    mVar SPRACHE = m$.var("SPRACHE");
    mVar YDECIMAL = m$.var("YDECIMAL");
    m$.newVar(SPRACHE,YDECIMAL);
    //<< do ^WWWVAR
    m$.Cmd.Do("WWWVAR.main");
    //<< if pnumNewDP'="" set YDECIMALLEN=+pnumNewDP
    if (mOp.NotEqual(pnumNewDP.get(),"")) {
      mVar YDECIMALLEN = m$.var("YDECIMALLEN");
      YDECIMALLEN.set(mOp.Positive(pnumNewDP.get()));
    }
    //<< 
    //<< set SPRACHE="EN"      ; DD/MM/YYYY   ,.   NN:NN
    SPRACHE.set("EN");
    //<< set YDECIMAL="."
    YDECIMAL.set(".");
    //<< do Test
    m$.Cmd.Do("Test");
    //<< set SPRACHE="FR"      ; MM/DD/YYYY   ,.   NN:NN
    SPRACHE.set("FR");
    //<< set YDECIMAL="."
    YDECIMAL.set(".");
    //<< do Test
    m$.Cmd.Do("Test");
    //<< set SPRACHE="DE"      ; DD.MM.YYYY   .,   NN:NN:NN
    SPRACHE.set("DE");
    //<< set YDECIMAL=","
    YDECIMAL.set(",");
    //<< do Test
    m$.Cmd.Do("Test");
    //<< set SPRACHE="PT"      ; DD/MM/YYYY   .,   NN:NN
    SPRACHE.set("PT");
    //<< set YDECIMAL=","
    YDECIMAL.set(",");
    //<< do Test
    m$.Cmd.Do("Test");
    //<< set SPRACHE="PT"
    SPRACHE.set("PT");
    //<< set YDECIMAL="."
    YDECIMAL.set(".");
    //<< do Test
    m$.Cmd.Do("Test");
    //<< set SPRACHE="JP"      ; YYYYMMDD     ,.   NN:NN
    SPRACHE.set("JP");
    //<< set YDECIMAL="."
    YDECIMAL.set(".");
    //<< do Test
    m$.Cmd.Do("Test");
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< Test ; May need to set YDECIMALLEN
  public void Test() {
    //<< new intShowDecs
    mVar intShowDecs = m$.var("intShowDecs");
    m$.newVar(intShowDecs);
    //<< write !!,"(",SPRACHE,":",YDECIMAL,")",!
    m$.Cmd.Write("\n","\n","(",m$.var("SPRACHE").get(),":",m$.var("YDECIMAL").get(),")","\n");
    //<< /*
    //<< ; OUT
    //<< w !!,"*** OUT ***"
    //<< 
    //<< w !," 1>",$$Convert(0,1,"65432"),"<"             ; Date     23/02/2020
    //<< 
    //<< w !," 2>",$$Convert(0,2,""),"<"                  ; Boolean
    //<< w !," 2>",$$Convert(0,2,"0"),"<"
    //<< w !," 2>",$$Convert(0,2,"1"),"<"
    //<< w !," 2>",$$Convert(0,2,"-1"),"<"
    //<< w !," 2>",$$Convert(0,2,"5"),"<"
    //<< w !," 2>",$$Convert(0,2,"ABC1"),"<"
    //<< w !," 2>",$$Convert(0,2,"ABC2"),"<"
    //<< w !," 2>",$$Convert(0,2,"CHECKED"),"<"
    //<< w !," 2>",$$Convert(0,2,"UNCHECKED"),"<"
    //<< 
    //<< w !," 4>",$$Convert(0,4,"12345"),"<"             ; Integer
    //<< w !," 4>",$$Convert(0,4,"0"),"<"
    //<< w !," 4>",$$Convert(0,4,"12345.67"),"<"
    //<< w !," 4>",$$Convert(0,4,"-12345"),"<"
    //<< 
    //<< w !," 7>",$$Convert(0,7,"54321"),"<"             ; Time
    //<< 
    //<< set YWHR="USD"
    //<< w !," 8>",$$Convert(0,8,"12.34"),"<"             ; Currency
    //<< w !," 8>",$$Convert(0,8,"12.34@5.67"),"<"
    //<< w !," 8>",$$Convert(0,8,"12.34@USD10@1.234"),"<"
    //<< w !," 8>",$$Convert(0,8,"12345.6789"),"<"
    //<< w !," 8>",$$Convert(0,8,"12345"),"<"
    //<< w !," 8>",$$Convert(0,8,".6789"),"<"
    //<< set YWHR="XYZ"
    //<< w !," 8>",$$Convert(0,8,"12.34"),"<"             ; Currency
    //<< w !," 8>",$$Convert(0,8,"12.34@5.67"),"<"
    //<< w !," 8>",$$Convert(0,8,"12.34@USD10@1.234"),"<"
    //<< w !," 8>",$$Convert(0,8,"12345.6789"),"<"
    //<< w !," 8>",$$Convert(0,8,"12345"),"<"
    //<< w !," 8>",$$Convert(0,8,".6789"),"<"
    //<< set YWHR=""
    //<< w !," 8>",$$Convert(0,8,"12.34"),"<"             ; Currency
    //<< w !," 8>",$$Convert(0,8,"12.34@5.67"),"<"
    //<< w !," 8>",$$Convert(0,8,"12.34@USD10@1.234"),"<"
    //<< w !," 8>",$$Convert(0,8,"12345.6789"),"<"
    //<< w !," 8>",$$Convert(0,8,"12345"),"<"
    //<< w !," 8>",$$Convert(0,8,".6789"),"<"
    //<< 
    //<< for intShowDecs="",2,5,8 {
    //<< w !,"12>",$$Convert(0,12,"123456",intShowDecs),"<"   ; Floating
    //<< w !,"12>",$$Convert(0,12,"123456.789123",intShowDecs),"<"
    //<< w !,"12>",$$Convert(0,12,".789123",intShowDecs),"<"
    //<< }
    //<< 
    //<< w !,"14>",$$Convert(0,14,"65432,54321"),"<"      ; TimeStamp
    //<< w !,"14>",$$Convert(0,14,"65432"),"<"
    //<< 
    //<< w !,"17>",$$Convert(0,17,"20070605"),"<"         ; DateYMD
    //<< 
    //<< for intShowDecs="",2,5,8 {
    //<< w !,"18>",$$Convert(0,18,".8",intShowDecs),"<"       ; ForEx
    //<< w !,"18>",$$Convert(0,18,"1.234567",intShowDecs),"<"
    //<< }
    //<< */
    //<< 
    //<< ; IN
    //<< w !!,"*** IN ***"
    m$.Cmd.Write("\n","\n","*** IN ***");
    //<< /*
    //<< w !," 1>",$$Convert(1,1,"."),"<"                  ; Date
    //<< w !," 1>",$$Convert(1,1,"05.06.2007"),"<"         ;  5 June = 60786   6 May = 60756
    //<< w !," 1>",$$Convert(1,1,"05/06/2007"),"<"
    //<< w !," 1>",$$Convert(1,1,"15.06.2007"),"<"         ; 15 June = 60796  16 May = 60766
    //<< w !," 1>",$$Convert(1,1,"05.16.2007"),"<"
    //<< w !," 1>",$$Convert(1,1,"20070605"),"<"
    //<< 
    //<< w !," 2>",$$Convert(1,2,""),"<"                   ; Boolean
    //<< w !," 2>",$$Convert(1,2,"0"),"<"
    //<< w !," 2>",$$Convert(1,2,"1"),"<"
    //<< w !," 2>",$$Convert(1,2,"-1"),"<"
    //<< w !," 2>",$$Convert(1,2,"5"),"<"
    //<< w !," 2>",$$Convert(1,2,"ABC1"),"<"
    //<< w !," 2>",$$Convert(1,2,"ABC2"),"<"
    //<< w !," 2>",$$Convert(1,2,"CHECKED"),"<"
    //<< w !," 2>",$$Convert(1,2,"UNCHECKED"),"<"
    //<< 
    //<< w !," 3>",$$Convert(1,3,"ABC"_$c(13,10)_"DEF"),"<"    ; Memo
    //<< 
    //<< w !," 4>",$$Convert(1,4,"123456"),"<"             ; Integer
    //<< w !," 4>",$$Convert(1,4,"123,456"),"<"
    //<< w !," 4>",$$Convert(1,4,"123.456"),"<"
    //<< w !," 4>",$$Convert(1,4,"123456.789"),"<"
    //<< w !," 4>",$$Convert(1,4,"123456,789"),"<"
    //<< w !," 4>",$$Convert(1,4,"123,456.789"),"<"
    //<< w !," 4>",$$Convert(1,4,"123.456,789"),"<"
    //<< */
    //<< w !," 7>",$$Convert(1,7,"03:45"),"<"             ; Time
    m$.Cmd.Write("\n"," 7>",m$.fnc$("Convert",1,7,"03:45"),"<");
    //<< w !," 7>",$$Convert(1,7,"03:45:10"),"<"
    m$.Cmd.Write("\n"," 7>",m$.fnc$("Convert",1,7,"03:45:10"),"<");
    //<< w !," 7>",$$Convert(1,7,"23:45"),"<"
    m$.Cmd.Write("\n"," 7>",m$.fnc$("Convert",1,7,"23:45"),"<");
    //<< w !," 7>",$$Convert(1,7,"23:45:10"),"<"
    m$.Cmd.Write("\n"," 7>",m$.fnc$("Convert",1,7,"23:45:10"),"<");
    //<< /*
    //<< set YWHR="USD"
    //<< w !," 8>",$$Convert(1,8,"12.34"),"<"              ; Currency
    //<< w !," 8>",$$Convert(1,8,"USD12.34"),"<"
    //<< w !," 8>",$$Convert(1,8,"12.34@USD10@1.234"),"<"
    //<< w !," 8>",$$Convert(1,8,"12345.6789"),"<"
    //<< w !," 8>",$$Convert(1,8,"12345"),"<"
    //<< w !," 8>",$$Convert(1,8,".6789"),"<"
    //<< set YWHR="XYZ"
    //<< w !," 8>",$$Convert(1,8,"12.34"),"<"
    //<< w !," 8>",$$Convert(1,8,"USD12.34"),"<"
    //<< w !," 8>",$$Convert(1,8,"12.34@USD10@1.234"),"<"
    //<< w !," 8>",$$Convert(1,8,"12345.6789"),"<"
    //<< w !," 8>",$$Convert(1,8,"12345"),"<"
    //<< w !," 8>",$$Convert(1,8,".6789"),"<"
    //<< set YWHR=""
    //<< w !," 8>",$$Convert(1,8,"12.34"),"<"
    //<< w !," 8>",$$Convert(1,8,"USD12.34"),"<"
    //<< w !," 8>",$$Convert(1,8,"12.34@USD10@1.234"),"<"
    //<< w !," 8>",$$Convert(1,8,"12345.6789"),"<"
    //<< w !," 8>",$$Convert(1,8,"12345"),"<"
    //<< w !," 8>",$$Convert(1,8,".6789"),"<"
    //<< 
    //<< 
    //<< for intShowDecs="",2,5,8 {
    //<< w !,"12>",$$Convert(1,12,"123456",intShowDecs),"<"        ; Floating
    //<< w !,"12>",$$Convert(1,12,"123,456",intShowDecs),"<"
    //<< w !,"12>",$$Convert(1,12,"123.456",intShowDecs),"<"
    //<< w !,"12>",$$Convert(1,12,"123456.789123",intShowDecs),"<"
    //<< w !,"12>",$$Convert(1,12,"123.456,789123",intShowDecs),"<"
    //<< w !,"12>",$$Convert(1,12,"123,456.789123",intShowDecs),"<"
    //<< 
    //<< w !,"12>",$$Convert(1,12,".789123",intShowDecs),"<"
    //<< w !,"12>",$$Convert(1,12,",789123",intShowDecs),"<"
    //<< }
    //<< 
    //<< 
    //<< w !,"13>",$$Convert(1,13,"123.012.210.001"),"<"  ; IPFormat
    //<< w !,"13>",$$Convert(1,13,"123/012;210-001"),"<"
    //<< w !,"13>",$$Convert(1,13,"256.123.210.542"),"<"
    //<< w !,"13>",$$Convert(1,13,"255.255.255.255"),"<"
    //<< w !,"13>",$$Convert(1,13,"0.0.0.0"),"<"
    //<< w !,"13>",$$Convert(1,13,"000.000.000.000"),"<"
    //<< w !,"13>",$$Convert(1,13,"000.000.000.001"),"<"
    //<< w !,"13>",$$Convert(1,13,"001.001.001.001"),"<"
    //<< w !,"13>",$$Convert(1,13,"127.000.000.001"),"<"
    //<< w !,"13>",$$Convert(1,13,"127.0.0.1"),"<"
    //<< w !,"13>",$$Convert(1,13,"10.0.0.55"),"<"
    //<< 
    //<< w !,"14>",$$Convert(1,14,"05.06.2007"),"<" ; TimeStamp
    //<< w !,"14>",$$Convert(1,14,"05/06/2007"),"<"
    //<< w !,"14>",$$Convert(1,14,"15.06.2007"),"<"
    //<< w !,"14>",$$Convert(1,14,"05.16.2007"),"<"
    //<< w !,"14>",$$Convert(1,14,"20070605"),"<"
    //<< w !,"14>",$$Convert(1,14,"05.06.2007 03:45:10"),"<"
    //<< w !,"14>",$$Convert(1,14,"05/06/2007 03:45:10"),"<"
    //<< w !,"14>",$$Convert(1,14,"15.06.2007 03:45:10"),"<"
    //<< w !,"14>",$$Convert(1,14,"05.16.2007 03:45:10"),"<"
    //<< w !,"14>",$$Convert(1,14,"20070605 03:45:10"),"<"
    //<< w !,"14>",$$Convert(1,14,"05.06.2007 03:45"),"<"
    //<< w !,"14>",$$Convert(1,14,"05/06/2007 03:45"),"<"
    //<< w !,"14>",$$Convert(1,14,"15.06.2007 03:45"),"<"
    //<< w !,"14>",$$Convert(1,14,"05.16.2007 03:45"),"<"
    //<< w !,"14>",$$Convert(1,14,"20070605 03:45"),"<"
    //<< w !,"14>",$$Convert(1,14,"05.06.2007 23:45:10"),"<"
    //<< w !,"14>",$$Convert(1,14,"05/06/2007 23:45:10"),"<"
    //<< w !,"14>",$$Convert(1,14,"15.06.2007 23:45:10"),"<"
    //<< w !,"14>",$$Convert(1,14,"05.16.2007 23:45:10"),"<"
    //<< w !,"14>",$$Convert(1,14,"20070605 23:45:10"),"<"
    //<< w !,"14>",$$Convert(1,14,"05.06.2007 23:45"),"<"
    //<< w !,"14>",$$Convert(1,14,"05/06/2007 23:45"),"<"
    //<< w !,"14>",$$Convert(1,14,"15.06.2007 23:45"),"<"
    //<< w !,"14>",$$Convert(1,14,"05.16.2007 23:45"),"<"
    //<< w !,"14>",$$Convert(1,14,"20070605 23:45"),"<"
    //<< 
    //<< w !,"17>",$$Convert(1,17,"05.06.2007"),"<" ; DateYMD
    //<< w !,"17>",$$Convert(1,17,"05/06/2007"),"<"
    //<< w !,"17>",$$Convert(1,17,"15.06.2007"),"<"
    //<< w !,"17>",$$Convert(1,17,"05.16.2007"),"<"
    //<< w !,"17>",$$Convert(1,17,"20070605"),"<"
    //<< */
    //<< for intShowDecs="",2,5,8 {
    for (Object _intShowDecs: new Object[] {"",2,5,8}) {
    intShowDecs.set(_intShowDecs);
      //<< w !,"18>",$$Convert(1,18,".8",intShowDecs),"<"       ; ForEx
      m$.Cmd.Write("\n","18>",m$.fnc$("Convert",1,18,".8",_intShowDecs),"<");
      //<< w !,"18>",$$Convert(1,18,"1.234567",intShowDecs),"<"
      m$.Cmd.Write("\n","18>",m$.fnc$("Convert",1,18,"1.234567",_intShowDecs),"<");
    }
    //<< }
    //<< 
    //<< quit
    return;
  }

//<< 
//<< 
}
