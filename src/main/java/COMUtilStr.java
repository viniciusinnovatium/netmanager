//*****************************************************************************
//** TASC - ALPHALINC - MAC COMUtilStr
//** Innovatium Systems - Code Converter - v1.28
//** 2014-05-26 21:14:00
//*****************************************************************************

import mLibrary.*;

//<< 
//<< ;-------------------------------------------------------------------------------
//<< ; String Manipulation Utilities
//<< ;
//<< ; See also :
//<< ;   COMUtilDate     Date/Time Utilities
//<< ;   COMUtils        Other Common Utilities
//<< ;
//<< ; History:
//<< ; 01-Jul-2004   GRF     Created; moved some routines from COMUtils
//<< ;-------------------------------------------------------------------------------
//<< #include %occOptions
import include.$occOptions;
//<< #include COMConst
import include.COMConst;
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
//<< #include WWWConst
import include.WWWConst;

//<< COMUtilStr
public class COMUtilStr extends mClass {

  public void main() {
    _COMUtilStr();
  }

  public void _COMUtilStr() {
  }

  //<< 
  //<< RangeCheck(pstrValue="",pstrLower="",pstrUpper="")
  public Object RangeCheck(Object ... _p) {
    mVar pstrValue = m$.newVarRef("pstrValue",(((_p!=null)&&(_p.length>=1))?_p[0]:null),"");
    mVar pstrLower = m$.newVarRef("pstrLower",(((_p!=null)&&(_p.length>=2))?_p[1]:null),"");
    mVar pstrUpper = m$.newVarRef("pstrUpper",(((_p!=null)&&(_p.length>=3))?_p[2]:null),"");
    //<< ;-------------------------------------------------------------------------------
    //<< ; Check that a value (string/number) falls within a range.
    //<< ;
    //<< ; Params:   pstrValue       : Any string to check
    //<< ;           pstrLower       : Lower bound
    //<< ;           pstrUpper       : Upper bound
    //<< ;
    //<< ; ByRefs:
    //<< ;
    //<< ; Returns: blnFlag      (within the range or not)
    //<< ;
    //<< ; History:
    //<< ; 26-Sep-2006   JW      SR14956: Peer review. Removed excess conditions, $gets.
    //<< ; 13-Sep-2006   SteveS  SR14956: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new blnFlag
    mVar blnFlag = m$.var("blnFlag");
    m$.newVar(blnFlag);
    //<< 
    //<< set blnFlag = $$$YES
    blnFlag.set(include.COMSYS.$$$YES(m$));
    //<< 
    //<< if (pstrUpper'="") { // upper limit specified: check this
    if ((mOp.NotEqual(pstrUpper.get(),""))) {
      //<< if pstrValue]]pstrUpper {
      if (mOp.Logical(mOp.SortsAfter(pstrValue.get(),pstrUpper.get()))) {
        //<< set blnFlag = $$$NO
        blnFlag.set(include.COMSYS.$$$NO(m$));
      }
    }
    //<< }
    //<< }
    //<< 
    //<< if (pstrLower'="") { // lower limit specified: check this
    if ((mOp.NotEqual(pstrLower.get(),""))) {
      //<< if (pstrLower'=pstrValue) && (pstrLower]]pstrValue) {
      if ((mOp.NotEqual(pstrLower.get(),pstrValue.get())) && mOp.Logical((mOp.SortsAfter(pstrLower.get(),pstrValue.get())))) {
        //<< set blnFlag = $$$NO
        blnFlag.set(include.COMSYS.$$$NO(m$));
      }
    }
    //<< }
    //<< }
    //<< quit blnFlag
    return blnFlag.get();
  }

  //<< 
  //<< 
  //<< FindLanguageCode(pstrText,pstrModule="")
  public Object FindLanguageCode(Object ... _p) {
    mVar pstrText = m$.newVarRef("pstrText",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pstrModule = m$.newVarRef("pstrModule",(((_p!=null)&&(_p.length>=2))?_p[1]:null),"");
    //<< ;-------------------------------------------------------------------------------
    //<< ; Looks through all of the language texts and finds close matches
    //<< ;
    //<< ; Returns:List (Format : Code,Text,NumMatches)
    //<< ;
    //<< ;
    //<< ; History:
    //<< ; 18-Apr-2005   PaulK   Moved from FINUtils
    //<< ; 08-Mar-2005   PaulK   Allow for "Com" module language texts
    //<< ; 05-Feb-2004   PaulK   Don't test if word has a '%' in it, and must have at least 3 chars
    //<< ; 04-Feb-2004   PaulK   Created
    //<< ;-------------------------------------------------------------------------------
    //<< new ArrayMatches,idLanguage,strText,numMatches,intWordLoop,lstMatches
    mVar ArrayMatches = m$.var("ArrayMatches");
    mVar idLanguage = m$.var("idLanguage");
    mVar strText = m$.var("strText");
    mVar numMatches = m$.var("numMatches");
    mVar intWordLoop = m$.var("intWordLoop");
    mVar lstMatches = m$.var("lstMatches");
    m$.newVar(ArrayMatches,idLanguage,strText,numMatches,intWordLoop,lstMatches);
    //<< 
    //<< if pstrModule="FI" set pstrModule = "Fi"
    if (mOp.Equal(pstrModule.get(),"FI")) {
      pstrModule.set("Fi");
    }
    //<< if pstrModule="CO" set pstrModule = "Co"
    if (mOp.Equal(pstrModule.get(),"CO")) {
      pstrModule.set("Co");
    }
    //<< set pstrText=$zconvert(pstrText,"U")
    pstrText.set(m$.Fnc.$zconvert(pstrText.get(),"U"));
    //<< set idLanguage = pstrModule
    idLanguage.set(pstrModule.get());
    //<< set lstMatches = ""
    lstMatches.set("");
    //<< if pstrText'="" {
    if (mOp.NotEqual(pstrText.get(),"")) {
      //<< for {
      for (;true;) {
        //<< set idLanguage = $order(^WWW009(0,"EN",idLanguage))
        idLanguage.set(m$.Fnc.$order(m$.var("^WWW009",0,"EN",idLanguage.get())));
        //<< quit:$extract(idLanguage,1,$length(pstrModule))'=pstrModule
        if (mOp.NotEqual(m$.Fnc.$extract(idLanguage.get(),1,m$.Fnc.$length(pstrModule.get())),pstrModule.get())) {
          break;
        }
        //<< quit:idLanguage=""
        if (mOp.Equal(idLanguage.get(),"")) {
          break;
        }
        //<< 
        //<< set strText    = $get(^WWW009(0,"EN",idLanguage,1))
        strText.set(m$.Fnc.$get(m$.var("^WWW009",0,"EN",idLanguage.get(),1)));
        //<< set numMatches = 0
        numMatches.set(0);
        //<< for intWordLoop=1:1:$length(pstrText," ") {
        for (intWordLoop.set(1);(mOp.LessOrEqual(intWordLoop.get(),m$.Fnc.$length(pstrText.get()," ")));intWordLoop.set(mOp.Add(intWordLoop.get(),1))) {
          //<< if '$find($piece(pstrText," ",intWordLoop),"%") {
          if (mOp.Not(m$.Fnc.$find(m$.Fnc.$piece(pstrText.get()," ",intWordLoop.get()),"%"))) {
            //<< if $length($piece(pstrText," ",intWordLoop))>2 {
            if (mOp.Greater(m$.Fnc.$length(m$.Fnc.$piece(pstrText.get()," ",intWordLoop.get())),2)) {
              //<< if $find($zconvert(strText,"U"),$piece(pstrText," ",intWordLoop)) {
              if (mOp.Logical(m$.Fnc.$find(m$.Fnc.$zconvert(strText.get(),"U"),m$.Fnc.$piece(pstrText.get()," ",intWordLoop.get())))) {
                //<< set numMatches = numMatches+1
                numMatches.set(mOp.Add(numMatches.get(),1));
              }
            }
          }
        }
        //<< }
        //<< }
        //<< }
        //<< }
        //<< if numMatches>0 {
        if (mOp.Greater(numMatches.get(),0)) {
          //<< set ArrayMatches(numMatches,idLanguage) = strText
          ArrayMatches.var(numMatches.get(),idLanguage.get()).set(strText.get());
        }
      }
    }
    //<< }
    //<< }
    //<< }
    //<< set numMatches = ""
    numMatches.set("");
    //<< for {
    for (;true;) {
      //<< set numMatches = $order(ArrayMatches(numMatches),-1)
      numMatches.set(m$.Fnc.$order(ArrayMatches.var(numMatches.get()),mOp.Negative(1)));
      //<< quit:numMatches=""
      if (mOp.Equal(numMatches.get(),"")) {
        break;
      }
      //<< 
      //<< set idLanguage = ""
      idLanguage.set("");
      //<< for {
      for (;true;) {
        //<< set idLanguage = $order(ArrayMatches(numMatches,idLanguage))
        idLanguage.set(m$.Fnc.$order(ArrayMatches.var(numMatches.get(),idLanguage.get())));
        //<< quit:idLanguage=""
        if (mOp.Equal(idLanguage.get(),"")) {
          break;
        }
        //<< 
        //<< set lstMatches=lstMatches_$listbuild($listbuild(numMatches,idLanguage,ArrayMatches(numMatches,idLanguage)))
        lstMatches.set(mOp.Concat(lstMatches.get(),m$.Fnc.$listbuild(m$.Fnc.$listbuild(numMatches.get(),idLanguage.get(),ArrayMatches.var(numMatches.get(),idLanguage.get()).get()))));
      }
    }
    //<< }
    //<< }
    //<< quit lstMatches
    return lstMatches.get();
  }

  //<< 
  //<< 
  //<< SortStrList(pSourceList="",pDelim="",pblnASCIISort=$$$NO)
  public Object SortStrList(Object ... _p) {
    mVar pSourceList = m$.newVarRef("pSourceList",(((_p!=null)&&(_p.length>=1))?_p[0]:null),"");
    mVar pDelim = m$.newVarRef("pDelim",(((_p!=null)&&(_p.length>=2))?_p[1]:null),"");
    mVar pblnASCIISort = m$.newVarRef("pblnASCIISort",(((_p!=null)&&(_p.length>=3))?_p[2]:null),include.COMSYS.$$$NO(m$));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Sort a string containing multiple pieces
    //<< ;
    //<< ; Returns: Sorted version of string with duplicates and nulls removed.
    //<< ;          By default, strictly numeric values will appear in numeric order
    //<< ;          BEFORE strings.  If the ASCII Sort flag is set to YES all values
    //<< ;          are sorted as text strings
    //<< ;          i.e.  1P;20;10;1;2;2R;10;1P;11;;103 becomes
    //<< ;             1;10;103;11;1P;2;20;2R   rather than   1;2;10;11;20;103;1P;2R
    //<< ;
    //<< ; History:
    //<< ; 01-Jul-2004   GRF     SR10478 : Created
    //<< ;-------------------------------------------------------------------------------
    //<< new idx,ListLength,SortedList,sp,SubString
    mVar idx = m$.var("idx");
    mVar ListLength = m$.var("ListLength");
    mVar SortedList = m$.var("SortedList");
    mVar sp = m$.var("sp");
    mVar SubString = m$.var("SubString");
    m$.newVar(idx,ListLength,SortedList,sp,SubString);
    //<< 
    //<< if pDelim="" set pDelim=";"
    if (mOp.Equal(pDelim.get(),"")) {
      pDelim.set(";");
    }
    //<< 
    //<< quit:pSourceList="" pSourceList
    if (mOp.Equal(pSourceList.get(),"")) {
      return pSourceList.get();
    }
    //<< set ListLength=$length(pSourceList,pDelim)
    ListLength.set(m$.Fnc.$length(pSourceList.get(),pDelim.get()));
    //<< if ListLength=1 quit pSourceList
    if (mOp.Equal(ListLength.get(),1)) {
      return pSourceList.get();
    }
    //<< 
    //<< kill ^CacheTemp("COMUtilStr","SortStrList",$job)
    m$.var("^CacheTemp","COMUtilStr","SortStrList",m$.Fnc.$job()).kill();
    //<< set sp=$select(pblnASCIISort:" ",1:"")                  ; space prefix for strict ASCII sort
    sp.set(m$.Fnc.$select(pblnASCIISort.get()," ",1,""));
    //<< 
    //<< for idx=1:1:ListLength {
    for (idx.set(1);(mOp.LessOrEqual(idx.get(),ListLength.get()));idx.set(mOp.Add(idx.get(),1))) {
      //<< set SubString=$piece(pSourceList,pDelim,idx)
      SubString.set(m$.Fnc.$piece(pSourceList.get(),pDelim.get(),idx.get()));
      //<< if SubString'="" set ^CacheTemp("COMUtilStr","SortStrList",$job,sp_SubString)=""
      if (mOp.NotEqual(SubString.get(),"")) {
        m$.var("^CacheTemp","COMUtilStr","SortStrList",m$.Fnc.$job(),mOp.Concat(sp.get(),SubString.get())).set("");
      }
    }
    //<< }
    //<< 
    //<< set SortedList=""
    SortedList.set("");
    //<< set SubString=""
    SubString.set("");
    //<< for  {
    for (;true;) {
      //<< set SubString=$order(^CacheTemp("COMUtilStr","SortStrList",$job,SubString))
      SubString.set(m$.Fnc.$order(m$.var("^CacheTemp","COMUtilStr","SortStrList",m$.Fnc.$job(),SubString.get())));
      //<< quit:SubString=""
      if (mOp.Equal(SubString.get(),"")) {
        break;
      }
      //<< 
      //<< if SortedList'="" set SortedList=SortedList_pDelim
      if (mOp.NotEqual(SortedList.get(),"")) {
        SortedList.set(mOp.Concat(SortedList.get(),pDelim.get()));
      }
      //<< if pblnASCIISort {
      if (mOp.Logical(pblnASCIISort.get())) {
        //<< set SortedList = SortedList_$extract(SubString,2,$length(SubString))
        SortedList.set(mOp.Concat(SortedList.get(),m$.Fnc.$extract(SubString.get(),2,m$.Fnc.$length(SubString.get()))));
      }
      //<< } else {
      else {
        //<< set SortedList = SortedList_SubString
        SortedList.set(mOp.Concat(SortedList.get(),SubString.get()));
      }
    }
    //<< }
    //<< }
    //<< kill ^CacheTemp("COMUtilStr","SortStrList",$job)
    m$.var("^CacheTemp","COMUtilStr","SortStrList",m$.Fnc.$job()).kill();
    //<< quit SortedList
    return SortedList.get();
  }

  //<< 
  //<< 
  //<< Strip(pstrString="",StripChar="",RemoveSpaces=$$$NO)
  public Object Strip(Object ... _p) {
    mVar pstrString = m$.newVarRef("pstrString",(((_p!=null)&&(_p.length>=1))?_p[0]:null),"");
    mVar StripChar = m$.newVarRef("StripChar",(((_p!=null)&&(_p.length>=2))?_p[1]:null),"");
    mVar RemoveSpaces = m$.newVarRef("RemoveSpaces",(((_p!=null)&&(_p.length>=3))?_p[2]:null),include.COMSYS.$$$NO(m$));
    //<< ;-------------------------------------------------------------------------------
    //<< ; History:
    //<< ; 05-Nov-2004   GRF     Add parameter defaults
    //<< ;-------------------------------------------------------------------------------
    //<< 
    //<< ;FIXME: Isn't it possible to do this using $zstrip only?
    //<< 
    //<< if StripChar="" set StripChar = "`~!@#$%^&*()-_=+[{]}\|;:'"",<.>/?"
    if (mOp.Equal(StripChar.get(),"")) {
      StripChar.set("`~!@#$%^&*()-_=+[{]}\\|;:'\",<.>/?");
    }
    //<< set pstrString = $translate(pstrString,StripChar)
    pstrString.set(m$.Fnc.$translate(pstrString.get(),StripChar.get()));
    //<< if RemoveSpaces set pstrString = $translate(pstrString," ")
    if (mOp.Logical(RemoveSpaces.get())) {
      pstrString.set(m$.Fnc.$translate(pstrString.get()," "));
    }
    //<< 
    //<< quit pstrString
    return pstrString.get();
  }

  //<< 
  //<< 
  //<< Trim(String="")
  public Object Trim(Object ... _p) {
    mVar String = m$.newVarRef("String",(((_p!=null)&&(_p.length>=1))?_p[0]:null),"");
    //<< ; ----------------------------------------------------------------------------
    //<< ; Routine to remove trailing spaces
    //<< ;
    //<< ; 08-Feb-2005   shobby  Default value for parameter.
    //<< ; ----------------------------------------------------------------------------
    //<< new len
    mVar len = m$.var("len");
    m$.newVar(len);
    //<< 
    //<< set len = $length(String)
    len.set(m$.Fnc.$length(String.get()));
    //<< while ($extract(String,len,len)=" ") {
    while ((mOp.Equal(m$.Fnc.$extract(String.get(),len.get(),len.get())," "))) {
      //<< set len = len-1
      len.set(mOp.Subtract(len.get(),1));
    }
    //<< }
    //<< quit $extract(String,1,len)
    return m$.Fnc.$extract(String.get(),1,len.get());
  }

  //<< 
  //<< 
  //<< TrimSpaces(String="")
  public Object TrimSpaces(Object ... _p) {
    mVar String = m$.newVarRef("String",(((_p!=null)&&(_p.length>=1))?_p[0]:null),"");
    //<< ;-------------------------------------------------------------------------------
    //<< ; Removes leading and trailing spaces from a string (uses $zstrip).
    //<< ;
    //<< ; Returns:String
    //<< ;
    //<< ; History:
    //<< ; 01-Nov-2004   SteveS  Created
    //<< ;-------------------------------------------------------------------------------
    //<< quit $zstrip(String,"<>W")
    return m$.Fnc.$zstrip(String.get(),"<>W");
  }

  //<< 
  //<< 
  //<< CutString(pstrText="",pintWidth="",pintMaxRows="",pblnUseSpaces=1)
  public Object CutString(Object ... _p) {
    mVar pstrText = m$.newVarRef("pstrText",(((_p!=null)&&(_p.length>=1))?_p[0]:null),"");
    mVar pintWidth = m$.newVarRef("pintWidth",(((_p!=null)&&(_p.length>=2))?_p[1]:null),"");
    mVar pintMaxRows = m$.newVarRef("pintMaxRows",(((_p!=null)&&(_p.length>=3))?_p[2]:null),"");
    mVar pblnUseSpaces = m$.newVarRef("pblnUseSpaces",(((_p!=null)&&(_p.length>=4))?_p[3]:null),1);
    //<< ;-------------------------------------------------------------------------------
    //<< ; Slices a string into rows
    //<< ;
    //<< ; Returns:List
    //<< ;
    //<< ; History:
    //<< ; 05-Nov-2004   GRF     Add parameter defaults
    //<< ; 20-Oct-2004   PK/SS   Created
    //<< ;-------------------------------------------------------------------------------
    //<< new CharLoop,intLine,lstText
    mVar CharLoop = m$.var("CharLoop");
    mVar intLine = m$.var("intLine");
    mVar lstText = m$.var("lstText");
    m$.newVar(CharLoop,intLine,lstText);
    //<< 
    //<< if pintWidth=""   set pintWidth   = 500
    if (mOp.Equal(pintWidth.get(),"")) {
      pintWidth.set(500);
    }
    //<< if pintMaxRows="" set pintMaxRows = 1
    if (mOp.Equal(pintMaxRows.get(),"")) {
      pintMaxRows.set(1);
    }
    //<< 
    //<< set lstText = ""
    lstText.set("");
    //<< for {
    for (;true;) {
      //<< quit:pstrText=""
      if (mOp.Equal(pstrText.get(),"")) {
        break;
      }
      //<< quit:$listlength(lstText)>=pintMaxRows
      if (mOp.GreaterOrEqual(m$.Fnc.$listlength(lstText.get()),pintMaxRows.get())) {
        break;
      }
      //<< 
      //<< for CharLoop=(pintWidth+1):-1:0 {
      for (CharLoop.set((mOp.Add(pintWidth.get(),1)));(mOp.GreaterOrEqual(CharLoop.get(),0));CharLoop.set(mOp.Add(CharLoop.get(),-1))) {
        //<< quit:'pblnUseSpaces
        if (mOp.Not(pblnUseSpaces.get())) {
          break;
        }
        //<< quit:$extract(pstrText,CharLoop)=" "
        if (mOp.Equal(m$.Fnc.$extract(pstrText.get(),CharLoop.get())," ")) {
          break;
        }
      }
      //<< }
      //<< if CharLoop=0 set CharLoop = pintWidth+1  ;if no spaces...
      if (mOp.Equal(CharLoop.get(),0)) {
        CharLoop.set(mOp.Add(pintWidth.get(),1));
      }
      //<< set lstText  = lstText_$listbuild($extract(pstrText,1,CharLoop-1))
      lstText.set(mOp.Concat(lstText.get(),m$.Fnc.$listbuild(m$.Fnc.$extract(pstrText.get(),1,mOp.Subtract(CharLoop.get(),1)))));
      //<< set pstrText = $zstrip($extract(pstrText,CharLoop,$length(pstrText)),"<W")
      pstrText.set(m$.Fnc.$zstrip(m$.Fnc.$extract(pstrText.get(),CharLoop.get(),m$.Fnc.$length(pstrText.get())),"<W"));
    }
    //<< }
    //<< quit lstText
    return lstText.get();
  }

  //<< 
  //<< 
  //<< Replace(pstrSource="",pstrFrom="",pstrTo="")
  public Object Replace(Object ... _p) {
    mVar pstrSource = m$.newVarRef("pstrSource",(((_p!=null)&&(_p.length>=1))?_p[0]:null),"");
    mVar pstrFrom = m$.newVarRef("pstrFrom",(((_p!=null)&&(_p.length>=2))?_p[1]:null),"");
    mVar pstrTo = m$.newVarRef("pstrTo",(((_p!=null)&&(_p.length>=3))?_p[2]:null),"");
    //<< ;-------------------------------------------------------------------------------
    //<< ; Replaces one string with another in a string.
    //<< ; Note: will not replace if the 'to' string string contains the 'from' string.
    //<< ;
    //<< ; Returns:String
    //<< ;
    //<< ; History:
    //<< ; 17-Feb-2005   PO      SR11661 Added support where pstrFrom is found in pstrTo.
    //<< ; 05-Nov-2004   GRF     Add parameter defaults
    //<< ; 09-Jan-2004   PaulK   Commented
    //<< ;-------------------------------------------------------------------------------
    //<< if pstrFrom'="" {
    if (mOp.NotEqual(pstrFrom.get(),"")) {
      //<< if $find(pstrTo,pstrFrom) {
      if (mOp.Logical(m$.Fnc.$find(pstrTo.get(),pstrFrom.get()))) {
        //<< set pstrSource=$$FullReplace(pstrSource,pstrFrom,pstrTo)
        pstrSource.set(m$.fnc$("FullReplace",pstrSource.get(),pstrFrom.get(),pstrTo.get()));
      }
      //<< } else {
      else {
        //<< for {
        for (;true;) {
          //<< quit:'$find(pstrSource,pstrFrom)
          if (mOp.Not(m$.Fnc.$find(pstrSource.get(),pstrFrom.get()))) {
            break;
          }
          //<< 
          //<< set pstrSource=$piece(pstrSource,pstrFrom,1)_pstrTo_$piece(pstrSource,pstrFrom,2,999)
          pstrSource.set(mOp.Concat(mOp.Concat(m$.Fnc.$piece(pstrSource.get(),pstrFrom.get(),1),pstrTo.get()),m$.Fnc.$piece(pstrSource.get(),pstrFrom.get(),2,999)));
        }
      }
    }
    //<< }
    //<< }
    //<< }
    //<< quit pstrSource
    return pstrSource.get();
  }

  //<< 
  //<< 
  //<< FullReplace(pstrSource="",pstrFrom="",pstrTo="")
  public Object FullReplace(Object ... _p) {
    mVar pstrSource = m$.newVarRef("pstrSource",(((_p!=null)&&(_p.length>=1))?_p[0]:null),"");
    mVar pstrFrom = m$.newVarRef("pstrFrom",(((_p!=null)&&(_p.length>=2))?_p[1]:null),"");
    mVar pstrTo = m$.newVarRef("pstrTo",(((_p!=null)&&(_p.length>=3))?_p[2]:null),"");
    //<< ;-------------------------------------------------------------------------------
    //<< ; This procedure does all that Replace does plus handles where pstrFrom is found
    //<< ; in pstrTo, Replace procedure left as is slightly faster.
    //<< ;
    //<< ; History:
    //<< ; 17-Feb-2005   PO      SR11661 Created.
    //<< ;-------------------------------------------------------------------------------
    //<< new strResult,strPiece,intIndex,intNumPieces
    mVar strResult = m$.var("strResult");
    mVar strPiece = m$.var("strPiece");
    mVar intIndex = m$.var("intIndex");
    mVar intNumPieces = m$.var("intNumPieces");
    m$.newVar(strResult,strPiece,intIndex,intNumPieces);
    //<< 
    //<< set strResult    = ""
    strResult.set("");
    //<< set intIndex     = 0
    intIndex.set(0);
    //<< set intNumPieces = $length(pstrSource,pstrFrom)-1
    intNumPieces.set(mOp.Subtract(m$.Fnc.$length(pstrSource.get(),pstrFrom.get()),1));
    //<< 
    //<< for {
    for (;true;) {
      //<< quit:intNumPieces=intIndex
      if (mOp.Equal(intNumPieces.get(),intIndex.get())) {
        break;
      }
      //<< set intIndex  = intIndex+1
      intIndex.set(mOp.Add(intIndex.get(),1));
      //<< set strPiece  = $piece(pstrSource,pstrFrom,intIndex)
      strPiece.set(m$.Fnc.$piece(pstrSource.get(),pstrFrom.get(),intIndex.get()));
      //<< set strResult = strResult_strPiece_pstrTo
      strResult.set(mOp.Concat(mOp.Concat(strResult.get(),strPiece.get()),pstrTo.get()));
    }
    //<< }
    //<< 
    //<< set strResult = strResult_$piece(pstrSource,pstrFrom,intIndex+1)
    strResult.set(mOp.Concat(strResult.get(),m$.Fnc.$piece(pstrSource.get(),pstrFrom.get(),mOp.Add(intIndex.get(),1))));
    //<< quit strResult
    return strResult.get();
  }

  //<< 
  //<< 
  //<< GetMemoTextWithCRLF(pstrMemoText)
  public Object GetMemoTextWithCRLF(Object ... _p) {
    mVar pstrMemoText = m$.newVarRef("pstrMemoText",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; @nm stores new line on memo field as '|' character. This routine will Replace '|'
    //<< ; for CRLF chars (Carriage Return and Line Feed). This is used on SQL statements
    //<< ; of JReports.
    //<< ;
    //<< ; Inputs:
    //<< ;   pstrMemoText - the text from a memo that will be updated.
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 19-Jul-2007   Frank   SRBR014491: Created
    //<< ;-------------------------------------------------------------------------------
    //<< quit:($get(pstrMemoText)="") ""
    if ((mOp.Equal(m$.Fnc.$get(pstrMemoText),""))) {
      return "";
    }
    //<< quit $$FullReplace(pstrMemoText,$$$NewLineCharForMemoFields,$CHAR(13,10))
    return m$.fnc$("FullReplace",pstrMemoText.get(),include.COMSYS.$$$NewLineCharForMemoFields(m$),m$.Fnc.$char(13,10));
  }

  //<< 
  //<< 
  //<< Upper(Text="")
  public Object Upper(Object ... _p) {
    mVar Text = m$.newVarRef("Text",(((_p!=null)&&(_p.length>=1))?_p[0]:null),"");
    //<< quit $zconvert(Text,"u")    ; Use $$$UPPER() Macro from COMSYSString.INC instead
    return m$.Fnc.$zconvert(Text.get(),"u");
  }

  //<< 
  //<< 
  //<< Lower(Text="")
  public Object Lower(Object ... _p) {
    mVar Text = m$.newVarRef("Text",(((_p!=null)&&(_p.length>=1))?_p[0]:null),"");
    //<< quit $zconvert(Text,"L")    ; Use $$$LOWER() Macro from COMSYSString.INC instead
    return m$.Fnc.$zconvert(Text.get(),"L");
  }

  //<< 
  //<< 
  //<< Proper(Text="")
  public Object Proper(Object ... _p) {
    mVar Text = m$.newVarRef("Text",(((_p!=null)&&(_p.length>=1))?_p[0]:null),"");
    //<< ;-------------------------------------------------------------------------------
    //<< ; History:
    //<< ; 12-May-2006   RPW     SR14609: Do not use $$Upper^COMUtils, use $$$UPPER
    //<< ; 05-Nov-2004   GRF     Convert dot to "{...}" form; Add parameter defaults;
    //<< ;                           removed duplicated $$Upper conversion
    //<< ;-------------------------------------------------------------------------------
    //<< new Char,Pos,UpFlag
    mVar Char = m$.var("Char");
    mVar Pos = m$.var("Pos");
    mVar UpFlag = m$.var("UpFlag");
    m$.newVar(Char,Pos,UpFlag);
    //<< 
    //<< set UpFlag = $$$YES
    UpFlag.set(include.COMSYS.$$$YES(m$));
    //<< set Text   = $$$LOWER(Text)
    Text.set(include.COMSYSString.$$$LOWER(m$,Text));
    //<< 
    //<< for Pos=1:1:$length(Text) {
    for (Pos.set(1);(mOp.LessOrEqual(Pos.get(),m$.Fnc.$length(Text.get())));Pos.set(mOp.Add(Pos.get(),1))) {
      //<< set Char = $extract(Text,Pos)
      Char.set(m$.Fnc.$extract(Text.get(),Pos.get()));
      //<< if UpFlag set $extract(Text,Pos) = $$$UPPER(Char)
      if (mOp.Logical(UpFlag.get())) {
        mVar $extract = m$.var("$extract");
        $extract.var(Text.get(),Pos.get()).set(include.COMSYSString.$$$UPPER(m$,Char));
      }
      //<< set UpFlag = ("`~!@#$%^&*()-_=+[{]}\|;:'"",<.>/? "[Char)
      UpFlag.set((mOp.Contains("`~!@#$%^&*()-_=+[{]}\\|;:'\",<.>/? ",Char.get())));
    }
    //<< }
    //<< quit Text
    return Text.get();
  }

  //<< 
  //<< 
  //<< DoubleQuotes(string)
  public Object DoubleQuotes(Object ... _p) {
    mVar string = m$.newVarRef("string",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ; ----------------------------------------------------------------------------
    //<< ; Function to double all instances of double quotes
    //<< ; History:
    //<< ; 05-Nov-2004   GRF     Replace %i variable with idx
    //<< ; ----------------------------------------------------------------------------
    //<< new cnt,idx,result
    mVar cnt = m$.var("cnt");
    mVar idx = m$.var("idx");
    mVar result = m$.var("result");
    m$.newVar(cnt,idx,result);
    //<< 
    //<< set result = ""
    result.set("");
    //<< set cnt    = $length(string,"""")
    cnt.set(m$.Fnc.$length(string.get(),"\""));
    //<< for idx=1:1:cnt {
    for (idx.set(1);(mOp.LessOrEqual(idx.get(),cnt.get()));idx.set(mOp.Add(idx.get(),1))) {
      //<< if (idx'=1) set result = result_""""""
      if ((mOp.NotEqual(idx.get(),1))) {
        result.set(mOp.Concat(result.get(),"\"\""));
      }
      //<< set result = result_$piece(string,"""",idx)
      result.set(mOp.Concat(result.get(),m$.Fnc.$piece(string.get(),"\"",idx.get())));
    }
    //<< }
    //<< quit result
    return result.get();
  }

  //<< 
  //<< 
  //<< Colour(pintColour="",pstrDefault="")
  public Object Colour(Object ... _p) {
    mVar pintColour = m$.newVarRef("pintColour",(((_p!=null)&&(_p.length>=1))?_p[0]:null),"");
    mVar pstrDefault = m$.newVarRef("pstrDefault",(((_p!=null)&&(_p.length>=2))?_p[1]:null),"");
    //<< ;-------------------------------------------------------------------------------
    //<< ; Turns a colour code into a colour name.
    //<< ;
    //<< ; Returns:String(colour)
    //<< ;
    //<< ; History:
    //<< ; 12-May-2009   SCR     SR16199: Return Text Only
    //<< ; 21-Dec-2007   GRF     BR014751: Ensure pintColour is a number
    //<< ; 05-Jan-2005   GRF     SR11415: Use parameter defaults
    //<< ; 20-Jul-2004   Paul K  Created
    //<< ;-------------------------------------------------------------------------------
    //<< new strColour
    mVar strColour = m$.var("strColour");
    m$.newVar(strColour);
    //<< 
    //<< set strColour = ""
    strColour.set("");
    //<< 
    //<< if pintColour'="" {
    if (mOp.NotEqual(pintColour.get(),"")) {
      //<< set pintColour = +pintColour
      pintColour.set(mOp.Positive(pintColour.get()));
      //<< ;   set strColour  = $get(^WWW100(0,"FARBE","EN",pintColour,1))
      //<< set strColour  = $$$WWW100Text($get(^WWW100(0,"FARBE","EN",pintColour,1)))
      strColour.set(include.WWWConst.$$$WWW100Text(m$,m$.Fnc.$get(m$.var("^WWW100",0,"FARBE","EN",pintColour.get(),1))));
    }
    //<< }
    //<< if strColour="" {
    if (mOp.Equal(strColour.get(),"")) {
      //<< set strColour = pstrDefault
      strColour.set(pstrDefault.get());
    }
    //<< }
    //<< quit strColour
    return strColour.get();
  }

  //<< 
  //<< 
  //<< ArrayToString(pArray,pDelim=",",pblnAddValue=$$$NO,pSubDelim=";",pblnNulls=$$$YES)
  public Object ArrayToString(Object ... _p) {
    mVar pArray = m$.newVarRef("pArray",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pDelim = m$.newVarRef("pDelim",(((_p!=null)&&(_p.length>=2))?_p[1]:null),",");
    mVar pblnAddValue = m$.newVarRef("pblnAddValue",(((_p!=null)&&(_p.length>=3))?_p[2]:null),include.COMSYS.$$$NO(m$));
    mVar pSubDelim = m$.newVarRef("pSubDelim",(((_p!=null)&&(_p.length>=4))?_p[3]:null),";");
    mVar pblnNulls = m$.newVarRef("pblnNulls",(((_p!=null)&&(_p.length>=5))?_p[4]:null),include.COMSYS.$$$YES(m$));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Convert first dimension of array to a string, with delimiter
    //<< ; If a 1D array can also add the values stored in the array
    //<< ;
    //<< ; Params:   pArray       - 1D array of elements
    //<< ;           pDelim       - delimits each element in string
    //<< ;           pblnAddValue - if YES adds corresponding value
    //<< ;           pSubDelim    - separator between subscript and value
    //<< ;
    //<< ; e.g.  XX("A")=123  XX("B")=""  XX("C")=456  XX("D")=789
    //<< ;
    //<< ; $$ArrayToString(.XX) or $$ArrayToString(.XX,",")
    //<< ;                  returns string :  A,B,C,D
    //<< ;
    //<< ; $$ArrayToString(.XX,,$$$YES) or $$ArrayToString(.XX,",",$$$YES,";") or similar
    //<< ;       or similar returns string :  A;123,B;,C;456,D;789
    //<< ;
    //<< ; $$ArrayToString(.XX,,$$$YES,,$$$NO) or $$ArrayToString(.XX,",",$$$YES,";",$$$NO)
    //<< ;       or similar returns string :  A;123,C;456,D;789
    //<< ;
    //<< ; History:
    //<< ; 28-Feb-2005   JW      SR11405 : Addded pblnOne option for extra 1
    //<< ; 16-Feb-2005   GRF     SR10478 : Optional inclusion of values; eliminate
    //<< ;                       with trailing delimiter (checked current usage - okay)
    //<< ; 31-Jan-2005   JW      Created
    //<< ;-------------------------------------------------------------------------------
    //<< new Delim,element,strList,SubString,Value
    mVar Delim = m$.var("Delim");
    mVar element = m$.var("element");
    mVar strList = m$.var("strList");
    mVar SubString = m$.var("SubString");
    mVar Value = m$.var("Value");
    m$.newVar(Delim,element,strList,SubString,Value);
    //<< 
    //<< set Delim   = ""
    Delim.set("");
    //<< set strList = ""
    strList.set("");
    //<< set element = ""
    element.set("");
    //<< for {
    for (;true;) {
      //<< set element = $order(pArray(element))
      element.set(m$.Fnc.$order(pArray.var(element.get())));
      //<< quit:element=""
      if (mOp.Equal(element.get(),"")) {
        break;
      }
      //<< 
      //<< set Value = $get(pArray(element))
      Value.set(m$.Fnc.$get(pArray.var(element.get())));
      //<< if (Value'="") || pblnNulls {
      if ((mOp.NotEqual(Value.get(),"")) || mOp.Logical(pblnNulls.get())) {
        //<< set SubString = element
        SubString.set(element.get());
        //<< if pblnAddValue {
        if (mOp.Logical(pblnAddValue.get())) {
          //<< set SubString = SubString_pSubDelim_Value
          SubString.set(mOp.Concat(mOp.Concat(SubString.get(),pSubDelim.get()),Value.get()));
        }
        //<< }
        //<< set strList = strList_Delim_SubString
        strList.set(mOp.Concat(mOp.Concat(strList.get(),Delim.get()),SubString.get()));
        //<< set Delim   = pDelim
        Delim.set(pDelim.get());
      }
    }
    //<< }
    //<< }
    //<< quit strList
    return strList.get();
  }

  //<< 
  //<< 
  //<< StringToArray(&pArray,pString="",pDelim=",",pSubDelim="",pblnValueFirst=$$$NO)
  public Object StringToArray(Object ... _p) {
    mVar pArray = m$.newVarRef("pArray",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pString = m$.newVarRef("pString",(((_p!=null)&&(_p.length>=2))?_p[1]:null),"");
    mVar pDelim = m$.newVarRef("pDelim",(((_p!=null)&&(_p.length>=3))?_p[2]:null),",");
    mVar pSubDelim = m$.newVarRef("pSubDelim",(((_p!=null)&&(_p.length>=4))?_p[3]:null),"");
    mVar pblnValueFirst = m$.newVarRef("pblnValueFirst",(((_p!=null)&&(_p.length>=5))?_p[4]:null),include.COMSYS.$$$NO(m$));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Convert multi-piece string into array; optional pSubDelim to set values too.
    //<< ;
    //<< ; Params:   pArray          - result array
    //<< ;           pString         - string to break up
    //<< ;           pDelim          - string delimiter
    //<< ;           pSubDelim       - separator between subscript and value
    //<< ;           pblnValueFirst  - whether value is before subscript.
    //<< ;
    //<< ; ByRef :   pArray(element)=""  or pArray(element)=value if pSubDelim'=""
    //<< ;
    //<< ; Returns : strStatus if null string or invalid (null) array elements present.
    //<< ;
    //<< ; History:
    //<< ; 18-Sep-2006   Steve S SR14952 : Support value being the first piece
    //<< ; 16-Feb-2005   GRF     SR10478 : Created to reverse ArrayToString
    //<< ;-------------------------------------------------------------------------------
    //<< new idx,StringLength,strStatus,SubString,Value
    mVar idx = m$.var("idx");
    mVar StringLength = m$.var("StringLength");
    mVar strStatus = m$.var("strStatus");
    mVar SubString = m$.var("SubString");
    mVar Value = m$.var("Value");
    m$.newVar(idx,StringLength,strStatus,SubString,Value);
    //<< 
    //<< set strStatus = $$$NO
    strStatus.set(include.COMSYS.$$$NO(m$));
    //<< kill pArray
    pArray.kill();
    //<< quit:pString="" strStatus
    if (mOp.Equal(pString.get(),"")) {
      return strStatus.get();
    }
    //<< 
    //<< set strStatus = $$$YES
    strStatus.set(include.COMSYS.$$$YES(m$));
    //<< 
    //<< set StringLength = $length(pString,pDelim)
    StringLength.set(m$.Fnc.$length(pString.get(),pDelim.get()));
    //<< for idx=1:1:StringLength {
    for (idx.set(1);(mOp.LessOrEqual(idx.get(),StringLength.get()));idx.set(mOp.Add(idx.get(),1))) {
      //<< set SubString = $piece(pString,pDelim,idx)
      SubString.set(m$.Fnc.$piece(pString.get(),pDelim.get(),idx.get()));
      //<< set Value=""
      Value.set("");
      //<< if pSubDelim'="" {
      if (mOp.NotEqual(pSubDelim.get(),"")) {
        //<< if 'pblnValueFirst { //SR14952
        if (mOp.Not(pblnValueFirst.get())) {
          //<< set Value     = $piece(SubString,pSubDelim,2)
          Value.set(m$.Fnc.$piece(SubString.get(),pSubDelim.get(),2));
          //<< set SubString = $piece(SubString,pSubDelim,1)
          SubString.set(m$.Fnc.$piece(SubString.get(),pSubDelim.get(),1));
        }
        //<< } else {
        else {
          //<< set Value     = $piece(SubString,pSubDelim,1)
          Value.set(m$.Fnc.$piece(SubString.get(),pSubDelim.get(),1));
          //<< set SubString = $piece(SubString,pSubDelim,2)
          SubString.set(m$.Fnc.$piece(SubString.get(),pSubDelim.get(),2));
        }
      }
      //<< }
      //<< }
      //<< if SubString'="" {
      if (mOp.NotEqual(SubString.get(),"")) {
        //<< set pArray(SubString) = Value
        pArray.var(SubString.get()).set(Value.get());
      }
      //<< } else {
      else {
        //<< set strStatus = $$$NO
        strStatus.set(include.COMSYS.$$$NO(m$));
      }
    }
    //<< }
    //<< }
    //<< quit strStatus
    return strStatus.get();
  }

  //<< 
  //<< 
  //<< SortString(pstrUnsorted,pstrDelim=",")
  public Object SortString(Object ... _p) {
    mVar pstrUnsorted = m$.newVarRef("pstrUnsorted",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pstrDelim = m$.newVarRef("pstrDelim",(((_p!=null)&&(_p.length>=2))?_p[1]:null),",");
    //<< ;-------------------------------------------------------------------------------
    //<< ; Sort multiple values in a string delimited by a specified character
    //<< ;
    //<< ; Params:   pstrUnsorted    - unsorted string
    //<< ;           pstrDelim       - delimiter for string passed in
    //<< ;
    //<< ; ByRefs:
    //<< ;
    //<< ; Returns:  string - sorted
    //<< ;
    //<< ; History:
    //<< ; 29-Nov-2006   JW      SR15205: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new arrVals,strSorted
    mVar arrVals = m$.var("arrVals");
    mVar strSorted = m$.var("strSorted");
    m$.newVar(arrVals,strSorted);
    //<< 
    //<< do StringToArray(.arrVals,pstrUnsorted,pstrDelim)
    m$.Cmd.Do("StringToArray",arrVals,pstrUnsorted.get(),pstrDelim.get());
    //<< set strSorted = $$ArrayToString(.arrVals,pstrDelim)
    strSorted.set(m$.fnc$("ArrayToString",arrVals,pstrDelim.get()));
    //<< 
    //<< quit strSorted
    return strSorted.get();
  }

  //<< 
  //<< 
  //<< MultiFind(pstrVals1,pstrVals2,pstrDelim1=";",pstrDelim2=";")
  public Object MultiFind(Object ... _p) {
    mVar pstrVals1 = m$.newVarRef("pstrVals1",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pstrVals2 = m$.newVarRef("pstrVals2",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pstrDelim1 = m$.newVarRef("pstrDelim1",(((_p!=null)&&(_p.length>=3))?_p[2]:null),";");
    mVar pstrDelim2 = m$.newVarRef("pstrDelim2",(((_p!=null)&&(_p.length>=4))?_p[3]:null),";");
    //<< ;-------------------------------------------------------------------------------
    //<< ; Match an element of One multi-piece string to an element of a 2nd
    //<< ;
    //<< ; Params:   pstrVals1,pstrVals2     - 2 multi-piece strings
    //<< ;           pstrDelim1,pstrDelim2   - respective delimiters
    //<< ;
    //<< ; ByRefs:
    //<< ;
    //<< ; Returns:  whether there was a match
    //<< ;
    //<< ; History:
    //<< ; 11-Sep-2006   JW      SR14771: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new intLoop,blnFound,strCurVal
    mVar intLoop = m$.var("intLoop");
    mVar blnFound = m$.var("blnFound");
    mVar strCurVal = m$.var("strCurVal");
    m$.newVar(intLoop,blnFound,strCurVal);
    //<< 
    //<< set blnFound=$$$NO
    blnFound.set(include.COMSYS.$$$NO(m$));
    //<< 
    //<< if (pstrVals1'="") && (pstrVals2'="") {
    if ((mOp.NotEqual(pstrVals1.get(),"")) && (mOp.NotEqual(pstrVals2.get(),""))) {
      //<< set pstrVals1 = pstrDelim1_pstrVals1_pstrDelim1
      pstrVals1.set(mOp.Concat(mOp.Concat(pstrDelim1.get(),pstrVals1.get()),pstrDelim1.get()));
      //<< 
      //<< for intLoop=1:1:$length(pstrVals2,pstrDelim2) {
      for (intLoop.set(1);(mOp.LessOrEqual(intLoop.get(),m$.Fnc.$length(pstrVals2.get(),pstrDelim2.get())));intLoop.set(mOp.Add(intLoop.get(),1))) {
        //<< set strCurVal = $piece(pstrVals2,pstrDelim2,intLoop)
        strCurVal.set(m$.Fnc.$piece(pstrVals2.get(),pstrDelim2.get(),intLoop.get()));
        //<< 
        //<< if $find(pstrVals1,pstrDelim1_strCurVal_pstrDelim1) {   // value found
        if (mOp.Logical(m$.Fnc.$find(pstrVals1.get(),mOp.Concat(mOp.Concat(pstrDelim1.get(),strCurVal.get()),pstrDelim1.get())))) {
          //<< set blnFound=$$$YES
          blnFound.set(include.COMSYS.$$$YES(m$));
          //<< quit
          break;
        }
      }
    }
    //<< }
    //<< }
    //<< }
    //<< quit blnFound
    return blnFound.get();
  }

  //<< 
  //<< 
  //<< ValueToCSV(pstrValue="")
  public Object ValueToCSV(Object ... _p) {
    mVar pstrValue = m$.newVarRef("pstrValue",(((_p!=null)&&(_p.length>=1))?_p[0]:null),"");
    //<< ;-------------------------------------------------------------------------------
    //<< ; Convert to value into CSV form
    //<< ;
    //<< ; CSV format used
    //<< ; Note: this format is what MS Excel uses.
    //<< ; - replace all double quotes with two double quotes
    //<< ; - wrap all values that contain double quotes or commas in double quotes
    //<< ;
    //<< ; History:
    //<< ; 18-Feb-2005   GRF     Use macro for clarity
    //<< ; 16-Feb-2005   PO      SR11661 Created.
    //<< ;-------------------------------------------------------------------------------
    //<< new strResult
    mVar strResult = m$.var("strResult");
    m$.newVar(strResult);
    //<< 
    //<< set strResult = pstrValue
    strResult.set(pstrValue.get());
    //<< 
    //<< if $find(strResult,$$$DBLQUOTE) {
    if (mOp.Logical(m$.Fnc.$find(strResult.get(),include.COMSYSString.$$$DBLQUOTE(m$)))) {
      //<< set strResult = $$Replace(strResult,$$$DBLQUOTE,$$$DBLQUOTE_$$$DBLQUOTE)
      strResult.set(m$.fnc$("Replace",strResult.get(),include.COMSYSString.$$$DBLQUOTE(m$),mOp.Concat(include.COMSYSString.$$$DBLQUOTE(m$),include.COMSYSString.$$$DBLQUOTE(m$))));
    }
    //<< }
    //<< if $find(strResult,",")||$find(strResult,$$$DBLQUOTE) {
    if (mOp.Logical(m$.Fnc.$find(strResult.get(),",")) || mOp.Logical(m$.Fnc.$find(strResult.get(),include.COMSYSString.$$$DBLQUOTE(m$)))) {
      //<< set strResult = $$$DBLQUOTE_strResult_$$$DBLQUOTE
      strResult.set(mOp.Concat(mOp.Concat(include.COMSYSString.$$$DBLQUOTE(m$),strResult.get()),include.COMSYSString.$$$DBLQUOTE(m$)));
    }
    //<< }
    //<< quit strResult
    return strResult.get();
  }

  //<< 
  //<< 
  //<< GetCSVValues(pstrCSV="",arrValues)
  public Object GetCSVValues(Object ... _p) {
    mVar pstrCSV = m$.newVarRef("pstrCSV",(((_p!=null)&&(_p.length>=1))?_p[0]:null),"");
    mVar arrValues = m$.newVarRef("arrValues",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Provided a CSV string an array including the separated values will be returned.
    //<< ;
    //<< ; CSV format used detailed in ValuesToCSV
    //<< ;
    //<< ; History:
    //<< ; 18-Feb-2005   PO      SR11661 Made necessary change for complete functionality.
    //<< ; 18-Feb-2005   GRF     Use macro for clarity
    //<< ; 16-Feb-2005   PO      SR11661 Created.
    //<< ;-------------------------------------------------------------------------------
    //<< new strValue,intIndex,intStart,intCount,strCSVTmp
    mVar strValue = m$.var("strValue");
    mVar intIndex = m$.var("intIndex");
    mVar intStart = m$.var("intStart");
    mVar intCount = m$.var("intCount");
    mVar strCSVTmp = m$.var("strCSVTmp");
    m$.newVar(strValue,intIndex,intStart,intCount,strCSVTmp);
    //<< 
    //<< set intCount = 0
    intCount.set(0);
    //<< for intIndex=1:1:$length(pstrCSV) {
    for (intIndex.set(1);(mOp.LessOrEqual(intIndex.get(),m$.Fnc.$length(pstrCSV.get())));intIndex.set(mOp.Add(intIndex.get(),1))) {
      //<< set intCount  = intCount+1
      intCount.set(mOp.Add(intCount.get(),1));
      //<< set strCSVTmp = $extract(pstrCSV,intIndex,$length(pstrCSV))
      strCSVTmp.set(m$.Fnc.$extract(pstrCSV.get(),intIndex.get(),m$.Fnc.$length(pstrCSV.get())));
      //<< if $extract(pstrCSV,intIndex)'=$$$DBLQUOTE {
      if (mOp.NotEqual(m$.Fnc.$extract(pstrCSV.get(),intIndex.get()),include.COMSYSString.$$$DBLQUOTE(m$))) {
        //<< set arrValues(intCount) = $piece(strCSVTmp,",",1)
        arrValues.var(intCount.get()).set(m$.Fnc.$piece(strCSVTmp.get(),",",1));
        //<< set intIndex = intIndex+$length(arrValues(intCount))
        intIndex.set(mOp.Add(intIndex.get(),m$.Fnc.$length(arrValues.var(intCount.get()).get())));
      }
      //<< } else {
      else {
        //<< set intStart = intIndex
        intStart.set(intIndex.get());
        //<< set intIndex = intIndex+1
        intIndex.set(mOp.Add(intIndex.get(),1));
        //<< for {
        for (;true;) {
          //<< while $extract(pstrCSV,intIndex,intIndex+1)=($$$DBLQUOTE_$$$DBLQUOTE) {
          while (mOp.Equal(m$.Fnc.$extract(pstrCSV.get(),intIndex.get(),mOp.Add(intIndex.get(),1)),(mOp.Concat(include.COMSYSString.$$$DBLQUOTE(m$),include.COMSYSString.$$$DBLQUOTE(m$))))) {
            //<< set intIndex = intIndex+2
            intIndex.set(mOp.Add(intIndex.get(),2));
          }
          //<< }
          //<< if $extract(pstrCSV,intIndex)=$$$DBLQUOTE {
          if (mOp.Equal(m$.Fnc.$extract(pstrCSV.get(),intIndex.get()),include.COMSYSString.$$$DBLQUOTE(m$))) {
            //<< set intIndex = intIndex+1
            intIndex.set(mOp.Add(intIndex.get(),1));
            //<< quit
            break;
          }
          //<< } else {
          else {
            //<< set intIndex = intIndex+1
            intIndex.set(mOp.Add(intIndex.get(),1));
          }
        }
        //<< }
        //<< }
        //<< set arrValues(intCount) = $$Replace($extract(pstrCSV,intStart+1,intIndex-2),$$$DBLQUOTE_$$$DBLQUOTE,$$$DBLQUOTE)
        arrValues.var(intCount.get()).set(m$.fnc$("Replace",m$.Fnc.$extract(pstrCSV.get(),mOp.Add(intStart.get(),1),mOp.Subtract(intIndex.get(),2)),mOp.Concat(include.COMSYSString.$$$DBLQUOTE(m$),include.COMSYSString.$$$DBLQUOTE(m$)),include.COMSYSString.$$$DBLQUOTE(m$)));
      }
    }
    //<< }
    //<< }
    //<< set arrValues = intCount
    arrValues.set(intCount.get());
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< Capitalise(pstrString="")
  public Object Capitalise(Object ... _p) {
    mVar pstrString = m$.newVarRef("pstrString",(((_p!=null)&&(_p.length>=1))?_p[0]:null),"");
    //<< ;-------------------------------------------------------------------------------
    //<< ; Capitalises the first letter of each word in a sentence.
    //<< ;
    //<< ; Returns: String
    //<< ;
    //<< ; History:
    //<< ; 03-Mar-2010   GRF     -: Use Macro
    //<< ; 12-Sep-2005   SteveS  SR12483: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new idx,strLetter,strPunc
    mVar idx = m$.var("idx");
    mVar strLetter = m$.var("strLetter");
    mVar strPunc = m$.var("strPunc");
    m$.newVar(idx,strLetter,strPunc);
    //<< 
    //<< set strPunc = ".:;, "
    strPunc.set(".:;, ");
    //<< 
    //<< for idx=1:1:($length(pstrString)) {
    for (idx.set(1);(mOp.LessOrEqual(idx.get(),(m$.Fnc.$length(pstrString.get()))));idx.set(mOp.Add(idx.get(),1))) {
      //<< set strLetter = $extract(pstrString,idx)
      strLetter.set(m$.Fnc.$extract(pstrString.get(),idx.get()));
      //<< 
      //<< if (idx=1) || $find(strPunc,($extract(pstrString,idx-1))) {
      if ((mOp.Equal(idx.get(),1)) || mOp.Logical(m$.Fnc.$find(strPunc.get(),(m$.Fnc.$extract(pstrString.get(),mOp.Subtract(idx.get(),1)))))) {
        //<< set $extract(pstrString,idx) = $$$UPPER(strLetter)
        mVar $extract = m$.var("$extract");
        $extract.var(pstrString.get(),idx.get()).set(include.COMSYSString.$$$UPPER(m$,strLetter));
      }
    }
    //<< }
    //<< }
    //<< quit pstrString
    return pstrString.get();
  }

  //<< 
  //<< 
  //<< EscapeString(pstrToEscape="",pstrCharsToEscape="",pblnIncludeExtraChr=$$$NO)
  public Object EscapeString(Object ... _p) {
    mVar pstrToEscape = m$.newVarRef("pstrToEscape",(((_p!=null)&&(_p.length>=1))?_p[0]:null),"");
    mVar pstrCharsToEscape = m$.newVarRef("pstrCharsToEscape",(((_p!=null)&&(_p.length>=2))?_p[1]:null),"");
    mVar pblnIncludeExtraChr = m$.newVarRef("pblnIncludeExtraChr",(((_p!=null)&&(_p.length>=3))?_p[2]:null),include.COMSYS.$$$NO(m$));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Escape strings, designed for hyperevents where data passes through EventBroker and can cause js actions to be performed.
    //<< ;
    //<< ; Note: Since it was never thought to escape micro operation data, the data can therefore appear to contain micro ops.
    //<< ; The solution to this has been clearly to escape micro op data, however due to the number of points in the code that
    //<< ; micro ops are used, instead of tracking down all occurrences, a of form escaping has been used where it is consider highly
    //<< ; unlikely to come across in data being sent via any hyperevent.
    //<< ;
    //<< ; The use of ASCII nul has been investigated however Internet Explorers implementation of the responseText property in the
    //<< ; XMLHttpRequest object terminates the returned string at any nuls found in the HTTP response.
    //<< ; Therefore the character 0xFF has been used.
    //<< ;
    //<< ; Params:   pstrToEscape - String to be escaped.
    //<< ;           pstrCharsToEscape - Which characters that need to be escaped.
    //<< ;           pblnIncudeExtraChr - Whether extra character is to be included when escaping.
    //<< ;
    //<< ; Returns: pstrToEscape - string has been escaped
    //<< ;
    //<< ; History:
    //<< ; 25-Nov-2005   PO      SR13792: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new counter,strChar,strExtractEscapeChar
    mVar counter = m$.var("counter");
    mVar strChar = m$.var("strChar");
    mVar strExtractEscapeChar = m$.var("strExtractEscapeChar");
    m$.newVar(counter,strChar,strExtractEscapeChar);
    //<< 
    //<< set strExtractEscapeChar = $case(pblnIncludeExtraChr,$$$YES:$char(255),:"")
    strExtractEscapeChar.set(m$.Fnc.$case(pblnIncludeExtraChr.get(),include.COMSYS.$$$YES(m$),m$.Fnc.$char(255),""));
    //<< 
    //<< for counter = 1:1:$length(pstrCharsToEscape) {
    for (counter.set(1);(mOp.LessOrEqual(counter.get(),m$.Fnc.$length(pstrCharsToEscape.get())));counter.set(mOp.Add(counter.get(),1))) {
      //<< set strChar = $extract(pstrCharsToEscape,counter)
      strChar.set(m$.Fnc.$extract(pstrCharsToEscape.get(),counter.get()));
      //<< 
      //<< if pstrToEscape [ strChar {
      if (mOp.Contains(pstrToEscape.get(),strChar.get())) {
        //<< set pstrToEscape = $$Replace^COMUtilStr(pstrToEscape,strChar,strExtractEscapeChar_"%"_$zhex($ascii(strChar)))
        pstrToEscape.set(m$.fnc$("COMUtilStr.Replace",pstrToEscape.get(),strChar.get(),mOp.Concat(mOp.Concat(strExtractEscapeChar.get(),"%"),m$.Fnc.$zhex(m$.Fnc.$ascii(strChar.get())))));
      }
    }
    //<< }
    //<< }
    //<< quit pstrToEscape
    return pstrToEscape.get();
  }

  //<< 
  //<< 
  //<< UnEscapeString(pstrToUnEscape="",pstrCharsToUnEscape="",pblnIncludedExtraChr=$$$NO)
  public Object UnEscapeString(Object ... _p) {
    mVar pstrToUnEscape = m$.newVarRef("pstrToUnEscape",(((_p!=null)&&(_p.length>=1))?_p[0]:null),"");
    mVar pstrCharsToUnEscape = m$.newVarRef("pstrCharsToUnEscape",(((_p!=null)&&(_p.length>=2))?_p[1]:null),"");
    mVar pblnIncludedExtraChr = m$.newVarRef("pblnIncludedExtraChr",(((_p!=null)&&(_p.length>=3))?_p[2]:null),include.COMSYS.$$$NO(m$));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Unescape strings escaped by sub-routine EscapeString
    //<< ;
    //<< ; Params:   pstrToEscape - String to be unescaped.
    //<< ;           pstrCharsToUnEscape - Which characters that need to be unescaped.
    //<< ;           pblnIncudeExtraChr - Whether extra character is included in escaped string.
    //<< ;
    //<< ; ByRefs: None
    //<< ;
    //<< ; Returns: pstrToUnEscape - string has been unescaped
    //<< ;
    //<< ; History:
    //<< ; 27-Jan-2006   PO      SR14130: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new counter,strChar,strExtractEscapeChar
    mVar counter = m$.var("counter");
    mVar strChar = m$.var("strChar");
    mVar strExtractEscapeChar = m$.var("strExtractEscapeChar");
    m$.newVar(counter,strChar,strExtractEscapeChar);
    //<< 
    //<< set strExtractEscapeChar = $case(pblnIncludedExtraChr,$$$YES:$char(255),:"")
    strExtractEscapeChar.set(m$.Fnc.$case(pblnIncludedExtraChr.get(),include.COMSYS.$$$YES(m$),m$.Fnc.$char(255),""));
    //<< 
    //<< for counter = 1:1:$length(pstrCharsToUnEscape) {
    for (counter.set(1);(mOp.LessOrEqual(counter.get(),m$.Fnc.$length(pstrCharsToUnEscape.get())));counter.set(mOp.Add(counter.get(),1))) {
      //<< set strChar = $extract(pstrCharsToUnEscape,counter)
      strChar.set(m$.Fnc.$extract(pstrCharsToUnEscape.get(),counter.get()));
      //<< 
      //<< if pstrToUnEscape [ strExtractEscapeChar_"%"_$zhex($ascii(strChar)) {
      if (mOp.Logical(mOp.Concat(mOp.Concat(mOp.Contains(pstrToUnEscape.get(),strExtractEscapeChar.get()),"%"),m$.Fnc.$zhex(m$.Fnc.$ascii(strChar.get()))))) {
        //<< set pstrToUnEscape = $$Replace^COMUtilStr(pstrToUnEscape,strExtractEscapeChar_"%"_$zhex($ascii(strChar)),strChar)
        pstrToUnEscape.set(m$.fnc$("COMUtilStr.Replace",pstrToUnEscape.get(),mOp.Concat(mOp.Concat(strExtractEscapeChar.get(),"%"),m$.Fnc.$zhex(m$.Fnc.$ascii(strChar.get()))),strChar.get()));
      }
    }
    //<< }
    //<< }
    //<< quit pstrToUnEscape
    return pstrToUnEscape.get();
  }

  //<< 
  //<< 
  //<< MakeKey(pstrKey="",pidForm,pintKeyNumber=1)
  public Object MakeKey(Object ... _p) {
    mVar pstrKey = m$.newVarRef("pstrKey",(((_p!=null)&&(_p.length>=1))?_p[0]:null),"");
    mVar pidForm = m$.newVarRef("pidForm",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pintKeyNumber = m$.newVarRef("pintKeyNumber",(((_p!=null)&&(_p.length>=3))?_p[2]:null),1);
    //<< 
    //<< ;<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< Not Complete! Do not use yet!
    //<< 
    //<< /*-------------------------------------------------------------------------------
    //<< ; Process a single string into a valid @NM key
    //<< ;
    //<< ; Params: pstrKey:          The original string
    //<< ;         pidForm:          The form it's being entered on
    //<< ;         pintKeyNumber:    If the form has more than one key, the
    //<< ;                           key number to use.
    //<< ;
    //<< ; ByRefs:
    //<< ;
    //<< ; Returns: String
    //<< ;
    //<< ; History:
    //<< ; 06-Jan-2011   GRF     SR17579: Use explicit tag for WWWTR calls
    //<< ; 05-Jan-2010   GRF     SR15525: Call to $$Convert^WWWTR rather than $$^WWWTR
    //<< ; 28-Dec-2005   SteveS  SR14064: Created
    //<< ;-------------------------------------------------------------------------------*/
    //<< new objWWW120,YDATEI,YTYP,YFORM,YI,objWWW002,YKEY
    mVar objWWW120 = m$.var("objWWW120");
    mVar YDATEI = m$.var("YDATEI");
    mVar YTYP = m$.var("YTYP");
    mVar YFORM = m$.var("YFORM");
    mVar YI = m$.var("YI");
    mVar objWWW002 = m$.var("objWWW002");
    mVar YKEY = m$.var("YKEY");
    m$.newVar(objWWW120,YDATEI,YTYP,YFORM,YI,objWWW002,YKEY);
    //<< 
    //<< if $get(Y)="" do ^WWWVAR
    if (mOp.Equal(m$.Fnc.$get(m$.var("Y")),"")) {
      m$.Cmd.Do("WWWVAR.main");
    }
    //<< 
    //<< if ($get(pidForm)'="") && ($get(pintKeyNumber)'="") {
    if ((mOp.NotEqual(m$.Fnc.$get(pidForm),"")) && (mOp.NotEqual(m$.Fnc.$get(pintKeyNumber),""))) {
      //<< set objWWW120 = $get(^WWW120(0,pidForm,1))
      objWWW120.set(m$.Fnc.$get(m$.var("^WWW120",0,pidForm.get(),1)));
      //<< set YDATEI    = $$$WWW120ClassUsedInForm(objWWW120)
      YDATEI.set(include.WWWConst.$$$WWW120ClassUsedInForm(m$,objWWW120));
      //<< 
      //<< if (YDATEI'="") {
      if ((mOp.NotEqual(YDATEI.get(),""))) {
        //<< set objWWW002 = $get(^WWW002(0,YDATEI,pintKeyNumber,1))
        objWWW002.set(m$.Fnc.$get(m$.var("^WWW002",0,YDATEI.get(),pintKeyNumber.get(),1)));
        //<< set YTYP      = $$$WWW002InputType(objWWW002)
        YTYP.set(include.WWWConst.$$$WWW002InputType(m$,objWWW002));
        //<< set YFORM     = pidForm
        YFORM.set(pidForm.get());
        //<< set YI        = pintKeyNumber
        YI.set(pintKeyNumber.get());
        //<< 
        //<< ; WWWEVENT does this processing first upon tabbing away
        //<< set pstrKey = $translate($$GetInternal^WWWTR(YTYP,pstrKey),"&,;()'"_Y_"""","+//////")
        pstrKey.set(m$.Fnc.$translate(m$.fnc$("WWWTR.GetInternal",YTYP.get(),pstrKey.get()),mOp.Concat(mOp.Concat("&,;()'",m$.var("Y").get()),"\""),"+//////"));
        //<< 
        //<< ; WWWSAVP does this processing when the form is submitted
        //<< set YKEY(YI)=pstrKey
        YKEY.var(YI.get()).set(pstrKey.get());
        //<< do PRUEFP^WWWSAVP ;test key
        m$.Cmd.Do("WWWSAVP.PRUEFP");
        //<< set pstrKey = $$GetInternal^WWWTR(YTYP,YKEY(YI))
        pstrKey.set(m$.fnc$("WWWTR.GetInternal",YTYP.get(),YKEY.var(YI.get()).get()));
      }
    }
    //<< }
    //<< }
    //<< quit pstrKey
    return pstrKey.get();
  }

  //<< 
  //<< 
  //<< StringToAscii(pstrText,pblnAsHashCode=$$$NO,pblnUpperNoSpecChar=$$$NO)
  public Object StringToAscii(Object ... _p) {
    mVar pstrText = m$.newVarRef("pstrText",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pblnAsHashCode = m$.newVarRef("pblnAsHashCode",(((_p!=null)&&(_p.length>=2))?_p[1]:null),include.COMSYS.$$$NO(m$));
    mVar pblnUpperNoSpecChar = m$.newVarRef("pblnUpperNoSpecChar",(((_p!=null)&&(_p.length>=3))?_p[2]:null),include.COMSYS.$$$NO(m$));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Convert String into ASCII Code               ***** SEE FOLLOWING WARNING *****
    //<< ;
    //<< ; Params: pstrText:            The original string
    //<< ;         pblnAsHashCode:      Return simple hash code
    //<< ;         pblnUpperNoSpecChar: convert upper string without spec. char.
    //<< ;
    //<< ; Returns: Ascii String / Hash Number
    //<< ;
    //<< ; History:
    //<< ; 25-Aug-2008   GRF     SR15852: remove unnecessary +; warning added
    //<< ; 18-Aug-2008   FIS     SR15852: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new strReturn,idx
    mVar strReturn = m$.var("strReturn");
    mVar idx = m$.var("idx");
    m$.newVar(strReturn,idx);
    //<< 
    //<< if (pblnUpperNoSpecChar = $$$YES) {
    if ((mOp.Equal(pblnUpperNoSpecChar.get(),include.COMSYS.$$$YES(m$)))) {
      //<< set pstrText = $$^WWWUMLAU(pstrText,3)
      pstrText.set(m$.fnc$("WWWUMLAU.main",pstrText.get(),3));
    }
    //<< }
    //<< 
    //<< set strReturn = ""
    strReturn.set("");
    //<< set idx=1
    idx.set(1);
    //<< if (pblnAsHashCode = $$$YES) {     // simple hash code   // should use Bob Jenkin's hashcode in some future
    if ((mOp.Equal(pblnAsHashCode.get(),include.COMSYS.$$$YES(m$)))) {
      //<< while ($extract(pstrText,idx,$length(pstrText)) '= "") {
      while ((mOp.NotEqual(m$.Fnc.$extract(pstrText.get(),idx.get(),m$.Fnc.$length(pstrText.get())),""))) {
        //<< set strReturn = (31 * strReturn) + $ascii($extract(pstrText,idx))
        strReturn.set(mOp.Add((mOp.Multiply(31,strReturn.get())),m$.Fnc.$ascii(m$.Fnc.$extract(pstrText.get(),idx.get()))));
        //<< set idx = idx+1
        idx.set(mOp.Add(idx.get(),1));
      }
    }
    //<< }
    //<< } else {                           // ASCII char by char
    else {
      //<< while ($extract(pstrText,idx,$length(pstrText)) '= "") {
      while ((mOp.NotEqual(m$.Fnc.$extract(pstrText.get(),idx.get(),m$.Fnc.$length(pstrText.get())),""))) {
        //<< set strReturn = strReturn_$ascii($extract(pstrText,idx))
        strReturn.set(mOp.Concat(strReturn.get(),m$.Fnc.$ascii(m$.Fnc.$extract(pstrText.get(),idx.get()))));
        //<< set idx = idx+1
        idx.set(mOp.Add(idx.get(),1));
      }
    }
    //<< }
    //<< }
    //<< 
    //<< quit strReturn
    return strReturn.get();
  }

  //<< 
  //<< ;+++++++++++++++++++++++++++++++++++++++
  //<< ; WARNING : StringToAscii
  //<< ; =======
  //<< ;
  //<< ; If the output from the StringToAscii function is treated as a numeric value,
  //<< ;   (e.g. if stored as YUSER and then testing +YUSER)
  //<< ; the results will not be unique over a certain string length.
  //<< ;
  //<< ; e.g.
  //<< ; "ABCDEFGHIA" => 65666768697071727365 => 65666768697071727360
  //<< ; "ABCDEFGHIB" => 65666768697071727366 => 65666768697071727360
  //<< ;
  //<< ; The same will occur with the Hash Switch set to $$$YES with the problem
  //<< ; occurring with longer strings.
  //<< ;
  //<< ; If the result has other digits appended before being treated as a numeric
  //<< ; value, the problem will appear with shorter base strings.
  //<< ;+++++++++++++++++++++++++++++++++++++++
  //<< 
  //<< GetBase64Encode(pstrText="")
  public Object GetBase64Encode(Object ... _p) {
    mVar pstrText = m$.newVarRef("pstrText",(((_p!=null)&&(_p.length>=1))?_p[0]:null),"");
    //<< ;-------------------------------------------------------------------------------
    //<< ; Convert Text to Base64 using UTF8 Translation
    //<< ; The UTF8 takes care of any unicode characters that may be in the text/
    //<< ;
    //<< ; Params: pstrText
    //<< ;
    //<< ; ByRefs:
    //<< ;
    //<< ; Returns: Base64
    //<< ;
    //<< ; History:
    //<< ; 22-Jan-2009   SCR     SR16320: Created
    //<< ;-------------------------------------------------------------------------------*/
    //<< set pstrText = $zconvert(pstrText,"O","UTF8")
    pstrText.set(m$.Fnc.$zconvert(pstrText.get(),"O","UTF8"));
    //<< quit $SYSTEM.Encryption.Base64Encode(pstrText)
    return m$.getSystem().getEncryption().Base64Encode(pstrText.get());
  }

  //<< 
  //<< 
  //<< GetBase64Decode(pstrBase64="")
  public Object GetBase64Decode(Object ... _p) {
    mVar pstrBase64 = m$.newVarRef("pstrBase64",(((_p!=null)&&(_p.length>=1))?_p[0]:null),"");
    //<< ;-------------------------------------------------------------------------------
    //<< ; Convert Base64 to text using UTF8 Translation
    //<< ; The UTF8 takes care of any unicode characters that may be in the text/
    //<< ;
    //<< ; Params: pstrBase64
    //<< ;
    //<< ; ByRefs:
    //<< ;
    //<< ; Returns: text
    //<< ;
    //<< ; History:
    //<< ; 22-Jan-2009   SCR     SR16320: Created
    //<< ;-------------------------------------------------------------------------------*/
    //<< new strText
    mVar strText = m$.var("strText");
    m$.newVar(strText);
    //<< 
    //<< set strText = $SYSTEM.Encryption.Base64Decode(pstrBase64)
    strText.set(m$.getSystem().getEncryption().Base64Decode(pstrBase64.get()));
    //<< quit $zconvert(strText,"I","UTF8")
    return m$.Fnc.$zconvert(strText.get(),"I","UTF8");
  }

  //<< 
  //<< 
  //<< NullDevice()
  public Object NullDevice(Object ... _p) {
    //<< ;-------------------------------------------------------------------------------
    //<< ; Return Null Device for OS
    //<< ;
    //<< ; Inputs: none
    //<< ;
    //<< ; Returns: device ie: //./null
    //<< ;
    //<< ; History:
    //<< ; 18-Nov-2009   SCR     SR16929: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new strDev
    mVar strDev = m$.var("strDev");
    m$.newVar(strDev);
    //<< 
    //<< if $$$isWINDOWS {
    if (mOp.Logical(include.$occOptions.$$$isWINDOWS(m$))) {
      //<< set strDev="//./nul"
      strDev.set("//./nul");
    }
    //<< 
    //<< } elseIf $$$isUNIX {
    else if (mOp.Logical(include.$occOptions.$$$isUNIX(m$))) {
      //<< set strDev="/dev/null/"
      strDev.set("/dev/null/");
    }
    //<< 
    //<< } elseIf $$$isVMS {
    else if (mOp.Logical(include.$occOptions.$$$isVMS(m$))) {
      //<< set strDev="NL:"
      strDev.set("NL:");
    }
    //<< 
    //<< } else {
    else {
      //<< set strDev=""
      strDev.set("");
    }
    //<< }
    //<< quit strDev
    return strDev.get();
  }

}
