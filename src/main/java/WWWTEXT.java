//*****************************************************************************
//** TASC - ALPHALINC - MAC WWWTEXT
//** Innovatium Systems - Code Converter - v1.29
//** 2014-06-03 20:54:41
//*****************************************************************************

import mLibrary.*;

//<< ;WWWTEXT(pstrToDecode="",pintJustify="",pintUmlaut="",pidLang="")   ;SRBR014425
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

//<< WWWTEXT(pstrToDecode="",pintJustify="",pintUmlaut=1,pidLang="") ;SRBR014425
public class WWWTEXT extends mClass {

  public Object main(Object ... _p) {
    mVar pstrToDecode = m$.newVarRef("pstrToDecode",(((_p!=null)&&(_p.length>=1))?_p[0]:null),"");
    mVar pintJustify = m$.newVarRef("pintJustify",(((_p!=null)&&(_p.length>=2))?_p[1]:null),"");
    mVar pintUmlaut = m$.newVarRef("pintUmlaut",(((_p!=null)&&(_p.length>=3))?_p[2]:null),1);
    mVar pidLang = m$.newVarRef("pidLang",(((_p!=null)&&(_p.length>=4))?_p[3]:null),"");
    return _WWWTEXT(pstrToDecode,pintJustify,pintUmlaut,pidLang);
  }

  public Object _WWWTEXT(Object ... _p) {
    mVar pstrToDecode = m$.newVarRef("pstrToDecode",(((_p!=null)&&(_p.length>=1))?_p[0]:null),"");
    mVar pintJustify = m$.newVarRef("pintJustify",(((_p!=null)&&(_p.length>=2))?_p[1]:null),"");
    mVar pintUmlaut = m$.newVarRef("pintUmlaut",(((_p!=null)&&(_p.length>=3))?_p[2]:null),1);
    mVar pidLang = m$.newVarRef("pidLang",(((_p!=null)&&(_p.length>=4))?_p[3]:null),"");
    //<< ;-------------------------------------------------------------------------------
    //<< ; Description of Function :
    //<< ;       TEXTE IN SPRACHE
    //<< ;
    //<< ; Inputs :
    //<< ;   pstrToDecode    String to decode. In the following format:
    //<< ;                    - "idCode,intJustify idCode,intJustify ...;string"
    //<< ;                   where
    //<< ;                       idCode      - ^WWW009 id
    //<< ;                       intJustify  - length to justify. See Justify tag
    //<< ;                       string      - alternative text if the initial codes can't be decoded
    //<< ;
    //<< ;   pintJustify     (optional) length to justify whole string. See Justify tag.
    //<< ;   pintUmlaut      (optional) if not equal to 1, convert using ^WWWUML  [FIXME : boolean? enum?]
    //<< ;   pidLang         (optional) override current/default language
    //<< ;
    //<< ; ByRef :
    //<< ;
    //<< ;
    //<< ; Returns :         string - decoded text
    //<< ;                   NOTE : Can return spurious error messages if already expanded
    //<< ;                          since space delimited sub-strings are checked for a
    //<< ;                          matching idError : e.g. "Line Number 1 requires..."
    //<< ;                          matches ^WWW009(0,1,"EN",1) = "User-Identification"
    //<< ;
    //<< ;
    //<< ; History :
    //<< ; 12-Feb-2013   SCR     HEVA-834: Check for already converted text
    //<< ; 17-Apr-2007   HeberB  SRBR014425: Default no umlaute translation
    //<< ; 02-Mar-2007   GM      SRBR014336: Call routine to delete spaces in key of
    //<< ;                           language text
    //<< ; 04-Oct-2006   JW      SR15098: Default to "EN" not "DE". Rewrote.
    //<< ; ------------------------------------------------------------------------------
    //<< ; Before Rewrite History:
    //<< ; 07-Sep-2006   GRF     Naked References; quits; remove unnecessary $get(X1)
    //<< ;                           & YBED test; &&/||; doco  FIX MEs
    //<< ; 20-Jul-2005   GRF     Doco
    //<< ; 22-Jun-2005   RPW     SR12741: Fixed null subscript error. Was in error check
    //<< ;                           for spaces. If the string was all spaces, would
    //<< ;                           result in the error.
    //<< ; 31-May-2005   RPW     SR12056: Moved WWWLANGU outside the for loop.
    //<< ; 27-May-2005   RPW     SR12056: Attempt at perform improvement
    //<< ; 01.08.1997    DT
    //<< ;-------------------------------------------------------------------------------
    //<< new idLang,idText,strAlternative,strText,blnError
    mVar idLang = m$.var("idLang");
    mVar idText = m$.var("idText");
    mVar strAlternative = m$.var("strAlternative");
    mVar strText = m$.var("strText");
    mVar blnError = m$.var("blnError");
    m$.newVar(idLang,idText,strAlternative,strText,blnError);
    //<< 
    //<< quit:pstrToDecode="" ""
    if (mOp.Equal(pstrToDecode.get(),"")) {
      return "";
    }
    //<< 
    //<< ; HEVA-834 vvvv
    //<< if ('$ListValid(pstrToDecode) && ($length(pstrToDecode," ")>1)) {
    if ((mOp.Not(m$.Fnc.$listvalid(pstrToDecode.get())) && (mOp.Greater(m$.Fnc.$length(pstrToDecode.get()," "),1)))) {
      //<< quit pstrToDecode   ; Converted text , quit
      return pstrToDecode.get();
    }
    //<< }
    //<< ; HEVA-834 ^^^^
    //<< ;---------------------------------------
    //<< ; FIXME : Should we ensure WWW009 entries are stored without spaces at
    //<< ;           either end as part of the save process?   <GRF>
    //<< ;---------------------------------------
    //<< ; FIXME : WWW009 D1 is a memo field but "|" are not interpreted as
    //<< ;         $char(13,10) in alert messages
    //<< ;         NOTE : Tooltip can recognise $c(10), $c(13) or $c(13,10)
    //<< ;                but alert can only recognise $c(13) and $c(13,10)
    //<< ;                [under WINDOWS - may be different in UNIX]  <GRF>
    //<< ;---------------------------------------
    //<< 
    //<< set idLang = $get(SPRACHE)
    idLang.set(m$.Fnc.$get(m$.var("SPRACHE")));
    //<< 
    //<< if $get(Y)="" do ^WWWVORG               ; WWWVORG sets/resets SPRACHE
    if (mOp.Equal(m$.Fnc.$get(m$.var("Y")),"")) {
      m$.Cmd.Do("WWWVORG.main");
    }
    //<< if $get(YUCI)="" set YUCI=$zutil(5)
    if (mOp.Equal(m$.Fnc.$get(m$.var("YUCI")),"")) {
      mVar YUCI = m$.var("YUCI");
      YUCI.set(m$.Fnc.$zutil(5));
    }
    //<< 
    //<< if pidLang'="" {
    if (mOp.NotEqual(pidLang.get(),"")) {
      //<< set idLang = pidLang
      idLang.set(pidLang.get());
    }
    //<< 
    //<< } elseif idLang = "" {
    else if (mOp.Equal(idLang.get(),"")) {
      //<< set idLang = $$^WWWLANGU($get(YBED))
      idLang.set(m$.fnc$("WWWLANGU.main",m$.Fnc.$get(m$.var("YBED"))));
    }
    //<< }
    //<< 
    //<< set idText          = $piece(pstrToDecode,";",1)
    idText.set(m$.Fnc.$piece(pstrToDecode.get(),";",1));
    //<< set strAlternative  = $piece(pstrToDecode,";",2)
    strAlternative.set(m$.Fnc.$piece(pstrToDecode.get(),";",2));
    //<< 
    //<< set idText = $$$RTRIMWS(idText) //BR014336
    idText.set(include.COMSYSString.$$$RTRIMWS(m$,idText));
    //<< 
    //<< set strText = $$GetText(idText,idLang,$$$NO)
    strText.set(m$.fnc$("GetText",idText.get(),idLang.get(),include.COMSYS.$$$NO(m$)));
    //<< 
    //<< if ($translate(strText," ")="") && (idLang'="EN") {         // If not decoded
    if ((mOp.Equal(m$.Fnc.$translate(strText.get()," "),"")) && (mOp.NotEqual(idLang.get(),"EN"))) {
      //<< set strText = $$GetText(idText,"EN",$$$YES)     // Default
      strText.set(m$.fnc$("GetText",idText.get(),"EN",include.COMSYS.$$$YES(m$)));
    }
    //<< }
    //<< 
    //<< if $translate(strText," ")="" {         // If not decoded
    if (mOp.Equal(m$.Fnc.$translate(strText.get()," "),"")) {
      //<< if strAlternative '= "" {
      if (mOp.NotEqual(strAlternative.get(),"")) {
        //<< set strText = strAlternative            // Return alternative text
        strText.set(strAlternative.get());
      }
      //<< } else {
      else {
        //<< set strText = idText                    // Return code
        strText.set(idText.get());
      }
    }
    //<< }
    //<< }
    //<< 
    //<< if pintUmlaut'=1 {
    if (mOp.NotEqual(pintUmlaut.get(),1)) {
      //<< set strText = $$^WWWUML(strText)     ;UMLAUTE FÜR INTERNET ;to INTERNET
      strText.set(m$.fnc$("WWWUML.main",strText.get()));
    }
    //<< }
    //<< 
    //<< if pintJustify '= "" {                      // Justify
    if (mOp.NotEqual(pintJustify.get(),"")) {
      //<< set strText = $$Justify(strText,pintJustify)
      strText.set(m$.fnc$("Justify",strText.get(),pintJustify.get()));
    }
    //<< }
    //<< quit strText
    return strText.get();
  }

  //<< 
  //<< 
  //<< GetText(pstrCodes,pidLang,pblnLogError)
  public Object GetText(Object ... _p) {
    mVar pstrCodes = m$.newVarRef("pstrCodes",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pidLang = m$.newVarRef("pidLang",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pblnLogError = m$.newVarRef("pblnLogError",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Attempt to decode the input code(s) and possibly justify.
    //<< ; Also attempt to use cache
    //<< ;
    //<< ; Params:   pstrCodes       - string to decode - see main header
    //<< ;           pidLang         - language to use
    //<< ;           pblnLogError    - whether to log errors to ^CacheTempWWWTEXTERROR
    //<< ;
    //<< ; ByRefs:
    //<< ;
    //<< ; Returns:  string - translated text
    //<< ;
    //<< ; History:
    //<< ; 17-Sep-2013   SCR     HEVA-1205
    //<< ; 05-Oct-2006   JW      SR15098: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new strFullText,intLoop,strCode,idCode,intJustify,strText,blnCache,blnError
    mVar strFullText = m$.var("strFullText");
    mVar intLoop = m$.var("intLoop");
    mVar strCode = m$.var("strCode");
    mVar idCode = m$.var("idCode");
    mVar intJustify = m$.var("intJustify");
    mVar strText = m$.var("strText");
    mVar blnCache = m$.var("blnCache");
    mVar blnError = m$.var("blnError");
    m$.newVar(strFullText,intLoop,strCode,idCode,intJustify,strText,blnCache,blnError);
    //<< 
    //<< set strFullText = ""
    strFullText.set("");
    //<< 
    //<< set blnError = $$$NO
    blnError.set(include.COMSYS.$$$NO(m$));
    //<< set blnCache = ($length(pstrCodes)<=255) && (pstrCodes'="")
    blnCache.set((mOp.LessOrEqual(m$.Fnc.$length(pstrCodes.get()),255)) && (mOp.NotEqual(pstrCodes.get(),"")));
    //<< 
    //<< if blnCache {       // Check Cache
    if (mOp.Logical(blnCache.get())) {
      //<< set strFullText = $get(^CacheTempWWWTEXT(YUCI,pidLang,pstrCodes))
      strFullText.set(m$.Fnc.$get(m$.var("^CacheTempWWWTEXT",m$.var("YUCI").get(),pidLang.get(),pstrCodes.get())));
    }
    //<< }
    //<< if (blnCache) && $data(^SysSetup("WWW009Debug",pstrCodes)) {
    if (mOp.Logical((blnCache.get())) && mOp.Logical(m$.Fnc.$data(m$.var("^SysSetup","WWW009Debug",pstrCodes.get())))) {
      //<< set strDebug    = ""
      mVar strDebug = m$.var("strDebug");
      strDebug.set("");
      //<< for intDebugLoop=$stack(-1)-2:-1:5 {
      mVar intDebugLoop = m$.var("intDebugLoop");
      for (intDebugLoop.set(mOp.Subtract(m$.Fnc.$stack(mOp.Negative(1)),2));(mOp.GreaterOrEqual(intDebugLoop.get(),5));intDebugLoop.set(mOp.Add(intDebugLoop.get(),-1))) {
        //<< set strDebug=strDebug_"[ "_$stack(intDebugLoop)_" = "_$stack(intDebugLoop,"MCODE")_" @ "_$stack(intDebugLoop,"PLACE")_" ]"
        strDebug.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(strDebug.get(),"[ "),m$.Fnc.$stack(intDebugLoop.get()))," = "),m$.Fnc.$stack(intDebugLoop.get(),"MCODE"))," @ "),m$.Fnc.$stack(intDebugLoop.get(),"PLACE"))," ]"));
      }
      //<< }
      //<< set strDebugVars=$get(^SysSetup("WWW009Debug",pstrCodes))
      mVar strDebugVars = m$.var("strDebugVars");
      strDebugVars.set(m$.Fnc.$get(m$.var("^SysSetup","WWW009Debug",pstrCodes.get())));
      //<< for intDebugLoop=1:1:$length(strDebugVars,",") {
      for (intDebugLoop.set(1);(mOp.LessOrEqual(intDebugLoop.get(),m$.Fnc.$length(strDebugVars.get(),",")));intDebugLoop.set(mOp.Add(intDebugLoop.get(),1))) {
        //<< set strDebugVar=$piece(strDebugVars,",",intDebugLoop)
        mVar strDebugVar = m$.var("strDebugVar");
        strDebugVar.set(m$.Fnc.$piece(strDebugVars.get(),",",intDebugLoop.get()));
        //<< set:strDebugVar'="" strDebug=strDebug_"["_strDebugVar_"="_$get(@strDebugVar)_"]"
        if (mOp.NotEqual(strDebugVar.get(),"")) {
          strDebug.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(strDebug.get(),"["),strDebugVar.get()),"="),m$.Fnc.$get(m$.indirectVar(strDebugVar.get()))),"]"));
        }
      }
      //<< }
      //<< set ^CacheTempWWWTEXTLog(YUCI,pstrCodes)=strDebug
      m$.var("^CacheTempWWWTEXTLog",m$.var("YUCI").get(),pstrCodes.get()).set(strDebug.get());
    }
    //<< }
    //<< 
    //<< if strFullText="" {                 // Otherwise, decode each piece
    if (mOp.Equal(strFullText.get(),"")) {
      //<< for intLoop = 1:1 {
      for (intLoop.set(1);(true);intLoop.set(mOp.Add(intLoop.get(),1))) {
        //<< set strCode = $piece(pstrCodes," ",intLoop)
        strCode.set(m$.Fnc.$piece(pstrCodes.get()," ",intLoop.get()));
        //<< quit:strCode=""
        if (mOp.Equal(strCode.get(),"")) {
          break;
        }
        //<< 
        //<< set idCode      = $piece(strCode,",",1)     // id to decode
        idCode.set(m$.Fnc.$piece(strCode.get(),",",1));
        //<< set intJustify  = $piece(strCode,",",2)
        intJustify.set(m$.Fnc.$piece(strCode.get(),",",2));
        //<< 
        //<< if idCode="" {
        if (mOp.Equal(idCode.get(),"")) {
          //<< set strText = ""                            // no id, just justify
          strText.set("");
        }
        //<< } else {
        else {
          //<< set strText = $$$WWW009Text($get(^WWW009(0,pidLang,idCode,1)))
          strText.set(include.WWWConst.$$$WWW009Text(m$,m$.Fnc.$get(m$.var("^WWW009",0,pidLang.get(),idCode.get(),1))));
          //<< if strText="" {
          if (mOp.Equal(strText.get(),"")) {
            //<< set blnError = $$$YES                   // Not found - return error
            blnError.set(include.COMSYS.$$$YES(m$));
          }
        }
        //<< }
        //<< }
        //<< if intLoop>1 $$$Append(strFullText," ")
        if (mOp.Greater(intLoop.get(),1)) {
          include.COMSYSString.$$$Append(m$,strFullText," ");
        }
        //<< $$$Append(strFullText,$$Justify(strText,intJustify))
        include.COMSYSString.$$$Append(m$,strFullText,m$.fnc$("Justify",strText.get(),intJustify.get()));
      }
      //<< }
      //<< 
      //<< 
      //<< ; If we can put this in the cache, then do so
      //<< if blnCache {
      if (mOp.Logical(blnCache.get())) {
        //<< if pblnLogError && blnError {       // If error,
        if (mOp.Logical(pblnLogError.get()) && mOp.Logical(blnError.get())) {
          //<< for intLoop=$stack:-1:1 {       ; Run through the stack and dump it into the error global
          for (intLoop.set(m$.Fnc.$stack());(mOp.GreaterOrEqual(intLoop.get(),1));intLoop.set(mOp.Add(intLoop.get(),-1))) {
            //<< set ^CacheTempWWWTEXTERROR(YUCI,pstrCodes,intLoop) = $stack($stack-intLoop,"PLACE")
            m$.var("^CacheTempWWWTEXTERROR",m$.var("YUCI").get(),pstrCodes.get(),intLoop.get()).set(m$.Fnc.$stack(mOp.Subtract(m$.Fnc.$stack(),intLoop.get()),"PLACE"));
          }
        }
        //<< }
        //<< }
        //<< 
        //<< set ^CacheTempWWWTEXT(YUCI,pidLang,pstrCodes)=strFullText
        m$.var("^CacheTempWWWTEXT",m$.var("YUCI").get(),pidLang.get(),pstrCodes.get()).set(strFullText.get());
      }
    }
    //<< }
    //<< }
    //<< 
    //<< if $get(YBED)["STEVER" {
    if (mOp.Contains(m$.Fnc.$get(m$.var("YBED")),"STEVER")) {
      //<< set ^CacheTempSCR($i(^CacheTempSCR))=pstrCodes_"="_strFullText
      m$.var("^CacheTempSCR",m$.Fnc.$increment(m$.var("^CacheTempSCR"))).set(mOp.Concat(mOp.Concat(pstrCodes.get(),"="),strFullText.get()));
      //<< if pstrCodes="IN00747" {
      if (mOp.Equal(pstrCodes.get(),"IN00747")) {
        //<< for intDumpFrame=$stack(-1):-1:1 {
        mVar intDumpFrame = m$.var("intDumpFrame");
        for (intDumpFrame.set(m$.Fnc.$stack(mOp.Negative(1)));(mOp.GreaterOrEqual(intDumpFrame.get(),1));intDumpFrame.set(mOp.Add(intDumpFrame.get(),-1))) {
          //<< set ^CacheTempSCR($i(^CacheTempSCR))="Frame="_intDumpFrame_" Type="_$stack(intDumpFrame)_" Location="_$stack(intDumpFrame,"PLACE")_" Code="_$stack(intDumpFrame,"MCODE")
          m$.var("^CacheTempSCR",m$.Fnc.$increment(m$.var("^CacheTempSCR"))).set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("Frame=",intDumpFrame.get())," Type="),m$.Fnc.$stack(intDumpFrame.get()))," Location="),m$.Fnc.$stack(intDumpFrame.get(),"PLACE"))," Code="),m$.Fnc.$stack(intDumpFrame.get(),"MCODE")));
        }
      }
    }
    //<< }
    //<< 
    //<< }
    //<< }
    //<< 
    //<< quit strFullText
    return strFullText.get();
  }

  //<< 
  //<< 
  //<< Justify(pstrValue,pintMove)
  public Object Justify(Object ... _p) {
    mVar pstrValue = m$.newVarRef("pstrValue",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pintMove = m$.newVarRef("pintMove",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Align text left or right, and pad with spaces
    //<< ;
    //<< ; Params:   pstrValue   - text to justify
    //<< ;           pintMove    - pintMove - direction and number of spaces to justify
    //<< ;                           If positive - Left Justify  with trailing space fill
    //<< ;                           If negative - Right Justify with leading space fill
    //<< ;                           Doesn't truncate pstrValue if abs(pintMove) < length
    //<< ;
    //<< ; ByRefs:
    //<< ;
    //<< ; Returns:  string - justified value
    //<< ;
    //<< ; History:
    //<< ; 05-Oct-2006   JW      SR15098: Created (replaced UMSE)
    //<< ;-------------------------------------------------------------------------------
    //<< new intLength
    mVar intLength = m$.var("intLength");
    m$.newVar(intLength);
    //<< 
    //<< set intLength = $length(pstrValue)
    intLength.set(m$.Fnc.$length(pstrValue.get()));
    //<< if pintMove > intLength {               // Left Justify  with trailing space fill
    if (mOp.Greater(pintMove.get(),intLength.get())) {
      //<< set pstrValue = pstrValue_$justify("",pintMove-intLength)
      pstrValue.set(mOp.Concat(pstrValue.get(),m$.Fnc.$justify("",mOp.Subtract(pintMove.get(),intLength.get()))));
    }
    //<< 
    //<< } elseif -pintMove > intLength {        // Right Justify with leading space fill
    else if (mOp.Greater(mOp.Negative(pintMove.get()),intLength.get())) {
      //<< set pstrValue = $justify(pstrValue,-pintMove)
      pstrValue.set(m$.Fnc.$justify(pstrValue.get(),mOp.Negative(pintMove.get())));
    }
    //<< }
    //<< quit pstrValue
    return pstrValue.get();
  }

//<< 
//<< 
}
