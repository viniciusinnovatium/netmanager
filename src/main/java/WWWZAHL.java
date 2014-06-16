//*****************************************************************************
//** TASC - ALPHALINC - MAC WWWZAHL
//** Innovatium Systems - Code Converter - v1.30
//** 2014-06-16 19:00:08
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

public class WWWZAHL extends mClass {

  //<< #define space40 "                                       "
  public static Object $$$space40(mContext m$) {
    return ("                                       ");
  }

  //<< 
  //<< WWWZAHL(pnumValueIn,pintWidth,pintDecimalPlaces,pidCurrencyCode,pblnSymbolOnRight="",pfltConvRate,pstrConvTimeStamp,pblnSymbol=$$$YES)
  public Object main(Object ... _p) {
    mVar pnumValueIn = m$.newVarRef("pnumValueIn",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pintWidth = m$.newVarRef("pintWidth",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pintDecimalPlaces = m$.newVarRef("pintDecimalPlaces",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    mVar pidCurrencyCode = m$.newVarRef("pidCurrencyCode",(((_p!=null)&&(_p.length>=4))?_p[3]:null));
    mVar pblnSymbolOnRight = m$.newVarRef("pblnSymbolOnRight",(((_p!=null)&&(_p.length>=5))?_p[4]:null),"");
    mVar pfltConvRate = m$.newVarRef("pfltConvRate",(((_p!=null)&&(_p.length>=6))?_p[5]:null));
    mVar pstrConvTimeStamp = m$.newVarRef("pstrConvTimeStamp",(((_p!=null)&&(_p.length>=7))?_p[6]:null));
    mVar pblnSymbol = m$.newVarRef("pblnSymbol",(((_p!=null)&&(_p.length>=8))?_p[7]:null),include.COMSYS.$$$YES(m$));
    return _WWWZAHL(pnumValueIn,pintWidth,pintDecimalPlaces,pidCurrencyCode,pblnSymbolOnRight,pfltConvRate,pstrConvTimeStamp,pblnSymbol);
  }

  public Object _WWWZAHL(Object ... _p) {
    mVar pnumValueIn = m$.newVarRef("pnumValueIn",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pintWidth = m$.newVarRef("pintWidth",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pintDecimalPlaces = m$.newVarRef("pintDecimalPlaces",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    mVar pidCurrencyCode = m$.newVarRef("pidCurrencyCode",(((_p!=null)&&(_p.length>=4))?_p[3]:null));
    mVar pblnSymbolOnRight = m$.newVarRef("pblnSymbolOnRight",(((_p!=null)&&(_p.length>=5))?_p[4]:null),"");
    mVar pfltConvRate = m$.newVarRef("pfltConvRate",(((_p!=null)&&(_p.length>=6))?_p[5]:null));
    mVar pstrConvTimeStamp = m$.newVarRef("pstrConvTimeStamp",(((_p!=null)&&(_p.length>=7))?_p[6]:null));
    mVar pblnSymbol = m$.newVarRef("pblnSymbol",(((_p!=null)&&(_p.length>=8))?_p[7]:null),include.COMSYS.$$$YES(m$));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Description of Function :
    //<< ;       AUSGABE ZAHLENFORMAT
    //<< ;       Return formatted number
    //<< ;
    //<< ; Inputs :
    //<< ; pnumValueIn       = Amount to be shown/converted                        ; DARZUSTELLENDER ZAHLENWERT
    //<< ; pintWidth         = Minimum Width of string, pads with spaces if necesary     DEFAULT=0  (OPTIONAL)
    //<< ;                                                                         ; MINDEST-AUSGABELÄNGE (RECHTSBÜNDIG)
    //<< ; pintDecimalPlaces = Decimal Places to be shown  DEFAULT=2  (OPTIONAL)   ; ANZAHL DER NACHKOMMASTELLEN
    //<< ; pidCurrencyCode   = Currency Code                                       ; WÄHRUNG DIE ANGEZEIGT WERDEN UND GGF GERECHNET WERDEN SOLL
    //<< ; pblnSymbolOnRight =   1         Right Justify currency                  ; WÄHRUNGSZEICHEN RECHTS NEBEN DER ZAHL
    //<< ;                       0 (not 1) Left Justify currency                   ; LINKS NEBEN DER ZAHL
    //<< ;                       ""        Tri-state - use currency-based setting  ; WIE IM PARAMETER
    //<< ; pfltConvRate      = Alternate Conversion rate. Useful if A is not in Base Currency so you want the conversion rate of 1.
    //<< ;                                                                         ; ALTERNATIVER UMRECHNUNGSFAKTOR FREMDWÄHRUNG
    //<< ; pstrConvTimeStamp = which allows the routine to get the conversion rate at the specified date
    //<< ; pblnSymbol        = Show the currency symbol or not
    //<< ;
    //<< ; ByRef :
    //<< ;
    //<< ;
    //<< ; Returns :
    //<< ; The modified currency value
    //<< ;
    //<< ; History :
    //<< ; 21-Sep-2010   GRF     -: Code clean up
    //<< ; 23-May-2007   GRF     SR15525: use COMUtilLocale function and ConvertLocaleNumber^WWWTR
    //<< ;                           to fix flawed logic; parameters renamed.
    //<< ; 23-Oct-2006   RPW     SR15068: Removed naked reference
    //<< ; 27-Jun-2006   RPW     SR14603: Determine whether to show the currency symbol or not.
    //<< ; 06-May-2005   SteveS  SR12291: Don't overwrite D, use DSYMBOL to store the currency symbol.
    //<< ; 24-Mar-2005   RPW     SR11959: Modified to get the date based conversion field
    //<< ; 08.08.1997    DT
    //<< ;-------------------------------------------------------------------------------
    //<< new strCurrSymbol,strValueOut,TRENN,YWHR1,YWHR2
    mVar strCurrSymbol = m$.var("strCurrSymbol");
    mVar strValueOut = m$.var("strValueOut");
    mVar TRENN = m$.var("TRENN");
    mVar YWHR1 = m$.var("YWHR1");
    mVar YWHR2 = m$.var("YWHR2");
    m$.newVar(strCurrSymbol,strValueOut,TRENN,YWHR1,YWHR2);
    //<< 
    //<< ;---------------------------------------
    //<< ; Parameter Check
    //<< ;---------------------------------------
    //<< set pintWidth         = +$get(pintWidth)
    pintWidth.set(mOp.Positive(m$.Fnc.$get(pintWidth)));
    //<< set pidCurrencyCode   =  $get(pidCurrencyCode)
    pidCurrencyCode.set(m$.Fnc.$get(pidCurrencyCode));
    //<< set pblnSymbolOnRight =  $get(pblnSymbolOnRight)
    pblnSymbolOnRight.set(m$.Fnc.$get(pblnSymbolOnRight));
    //<< if $get(pintDecimalPlaces)="" {
    if (mOp.Equal(m$.Fnc.$get(pintDecimalPlaces),"")) {
      //<< set pintDecimalPlaces=$$GetDecimalPoints(pidCurrencyCode)   ; Currency format NOT floating
      pintDecimalPlaces.set(m$.fnc$("GetDecimalPoints",pidCurrencyCode.get()));
    }
    //<< }
    //<< 
    //<< ; If we have only a date field or nothing, the data is assumed to be wrong - set to NOW
    //<< ; Verify date and time are both numeric (strip leading zeros if formatted to (5N1","5N)
    //<< set pstrConvTimeStamp=$get(pstrConvTimeStamp)
    pstrConvTimeStamp.set(m$.Fnc.$get(pstrConvTimeStamp));
    //<< if $length(pstrConvTimeStamp,",")=1 set pstrConvTimeStamp=$horolog
    if (mOp.Equal(m$.Fnc.$length(pstrConvTimeStamp.get(),","),1)) {
      pstrConvTimeStamp.set(m$.Fnc.$horolog());
    }
    //<< set $piece(pstrConvTimeStamp,",",1)=+$piece(pstrConvTimeStamp,",",1)
    m$.pieceVar(pstrConvTimeStamp,",",1).set(mOp.Positive(m$.Fnc.$piece(pstrConvTimeStamp.get(),",",1)));
    //<< set $piece(pstrConvTimeStamp,",",2)=+$piece(pstrConvTimeStamp,",",2)
    m$.pieceVar(pstrConvTimeStamp,",",2).set(mOp.Positive(m$.Fnc.$piece(pstrConvTimeStamp.get(),",",2)));
    //<< 
    //<< ;---------------------------------------
    //<< ; Variable Initiation
    //<< ;---------------------------------------
    //<< do:$get(Y)="" ^WWWVAR
    if (mOp.Equal(m$.Fnc.$get(m$.var("Y")),"")) {
      m$.Cmd.Do("WWWVAR.main");
    }
    //<< if $get(SPRACHE)="" set SPRACHE="EN"
    if (mOp.Equal(m$.Fnc.$get(m$.var("SPRACHE")),"")) {
      mVar SPRACHE = m$.var("SPRACHE");
      SPRACHE.set("EN");
    }
    //<< set:$get(YDECIMAL)="" YDECIMAL = $extract($$GetNumberDelimiters^COMUtilLocale(SPRACHE),2)
    if (mOp.Equal(m$.Fnc.$get(m$.var("YDECIMAL")),"")) {
      m$.var("YDECIMAL").set(m$.Fnc.$extract(m$.fnc$("COMUtilLocale.GetNumberDelimiters",m$.var("SPRACHE").get()),2));
    }
    //<< 
    //<< /* DISABLED AS SHOULD ALWAYS ALREADY BE IN INTERNAL FORMAT
    //<< ;  Previous code was usually ineffective and didn't get picked up
    //<< ;---------------------------------------
    //<< ; Remove any literal Thousands/Decimals formatting - reinstalled later with $fnumber
    //<< ;---------------------------------------
    //<< set pnumValueIn = $$ConvertLocaleNumber^WWWTR(pnumValueIn,YDECIMAL)
    //<< */
    //<< 
    //<< ;---------------------------------------
    //<< ; Apply Conversion Rate
    //<< ;---------------------------------------
    //<< if +pnumValueIn=0 {
    if (mOp.Equal(mOp.Positive(pnumValueIn.get()),0)) {
      //<< set strValueOut=""
      strValueOut.set("");
    }
    //<< } elseif (pidCurrencyCode'="") {
    else if ((mOp.NotEqual(pidCurrencyCode.get(),""))) {
      //<< ;   FIXME : <GRF> Why is pidCurrencyCode anything other than "EUR" for Euros?   It is WWWWHR that returns
      //<< ;                 $char(128) as the symbol for currency "EUR" but this is not the currency code itself.
      //<< ;                 Should be able to get YWHR2 directly from all pidCurrencyCode values otherwise the
      //<< ;                 strCurrSymbol will be null for $char(128).
      //<< set YWHR1 = pidCurrencyCode
      YWHR1.set(pidCurrencyCode.get());
      //<< if $ASCII(YWHR1)=128 set YWHR1="EUR"
      if (mOp.Equal(m$.Fnc.$ascii(YWHR1.get()),128)) {
        YWHR1.set("EUR");
      }
      //<< if YWHR1="EU"        set YWHR1="EUR"
      if (mOp.Equal(YWHR1.get(),"EU")) {
        YWHR1.set("EUR");
      }
      //<< 
      //<< set YWHR2 = $$FindConversionRate(YWHR1,pstrConvTimeStamp)
      YWHR2.set(m$.fnc$("FindConversionRate",YWHR1.get(),pstrConvTimeStamp.get()));
      //<< if $get(pfltConvRate)'="" set YWHR2=pfltConvRate         ;UMRECHNUNGSFAKTOR FEMDWÄHRUNG
      if (mOp.NotEqual(m$.Fnc.$get(pfltConvRate),"")) {
        YWHR2.set(pfltConvRate.get());
      }
      //<< 
      //<< if +YWHR2'=0 set pnumValueIn = pnumValueIn/YWHR2         ;WÄHRUNG UMRECHNEN ;money standard
      if (mOp.NotEqual(mOp.Positive(YWHR2.get()),0)) {
        pnumValueIn.set(mOp.Divide(pnumValueIn.get(),YWHR2.get()));
      }
    }
    //<< }
    //<< 
    //<< ;---------------------------------------
    //<< ; Locale-Based FORMAT Thousands/Decimal Place
    //<< ;---------------------------------------
    //<< set strValueOut = $fnumber(pnumValueIn,",",pintDecimalPlaces)
    strValueOut.set(m$.Fnc.$fnumber(pnumValueIn.get(),",",pintDecimalPlaces.get()));
    //<< set:YDECIMAL="," strValueOut = $TRANSLATE(strValueOut,",.",".,")    ; NOTE : Assumes only dot-comma or comma-dot formats.
    if (mOp.Equal(m$.var("YDECIMAL").get(),",")) {
      strValueOut.set(m$.Fnc.$translate(strValueOut.get(),",.",".,"));
    }
    //<< 
    //<< ;---------------------------------------
    //<< ; Currency Symbol
    //<< ;---------------------------------------
    //<< if pblnSymbol {
    if (mOp.Logical(pblnSymbol.get())) {
      //<< set strCurrSymbol = $$^WWWWHR(pidCurrencyCode)
      strCurrSymbol.set(m$.fnc$("WWWWHR.main",pidCurrencyCode.get()));
      //<< 
      //<< ;   set:pblnSymbolOnRight="" pblnSymbolOnRight = $$$WWWWAESymbolOnTheRight($GET(^WWWWAE(0,pidCurrencyCode,1)))
      //<< set intPadding = pintWidth - $length(strValueOut)
      mVar intPadding = m$.var("intPadding");
      intPadding.set(mOp.Subtract(pintWidth.get(),m$.Fnc.$length(strValueOut.get())));
      //<< set:intPadding>0 strValueOut=$extract($$$space40,1,intPadding)_strValueOut
      if (mOp.Greater(intPadding.get(),0)) {
        strValueOut.set(mOp.Concat(m$.Fnc.$extract($$$space40(m$),1,intPadding.get()),strValueOut.get()));
      }
      //<< 
      //<< if strCurrSymbol'="" {
      if (mOp.NotEqual(strCurrSymbol.get(),"")) {
        //<< if pblnSymbolOnRight="" set pblnSymbolOnRight = $$$WWWWAESymbolOnTheRight($get(^WWWWAE(0,pidCurrencyCode,1)))
        if (mOp.Equal(pblnSymbolOnRight.get(),"")) {
          pblnSymbolOnRight.set(include.WWWConst.$$$WWWWAESymbolOnTheRight(m$,m$.Fnc.$get(m$.var("^WWWWAE",0,pidCurrencyCode.get(),1))));
        }
        //<< if pblnSymbolOnRight=$$$YES {
        if (mOp.Equal(pblnSymbolOnRight.get(),include.COMSYS.$$$YES(m$))) {
          //<< set strValueOut = strValueOut_" "_strCurrSymbol           ; "   12.00 FF"
          strValueOut.set(mOp.Concat(mOp.Concat(strValueOut.get()," "),strCurrSymbol.get()));
        }
        //<< } else {
        else {
          //<< set strValueOut = strCurrSymbol_" "_strValueOut           ; "$     12.00"
          strValueOut.set(mOp.Concat(mOp.Concat(strCurrSymbol.get()," "),strValueOut.get()));
        }
      }
    }
    //<< }
    //<< }
    //<< }
    //<< quit strValueOut
    return strValueOut.get();
  }

  //<< 
  //<< 
  //<< FindConversionRate(pstrFC,pstrTimeStamp,pblnReturnDateTime=$$$NO)
  public Object FindConversionRate(Object ... _p) {
    mVar pstrFC = m$.newVarRef("pstrFC",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pstrTimeStamp = m$.newVarRef("pstrTimeStamp",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pblnReturnDateTime = m$.newVarRef("pblnReturnDateTime",(((_p!=null)&&(_p.length>=3))?_p[2]:null),include.COMSYS.$$$NO(m$));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Find the correct conversion rate given a date. First it checks WWWWAE and
    //<< ; if the date is older, checks WWWWAEDATE for the matching region of dates.
    //<< ;
    //<< ; Parameters:
    //<< ; pstrFC            The foreign Currency type, ie USD or AUD
    //<< ; pstrTimeStamp     A time stamp in full horolog format.
    //<< ;
    //<< ; Returns:
    //<< ; The floating point conversion rate.
    //<< ;
    //<< ; History:
    //<< ; 12-Jan-2007   GRF     SR15376: restore missing test; boolean macro
    //<< ; 23-Oct-2006   RPW     SR15068: use new DateDiff macro
    //<< ; 23-Jan-2006   Steve S Boolean macros
    //<< ; 18-May-2005   shobby  Default value for pstrTimeStamp SR12008
    //<< ;  9-May-2005   JW      Added $get
    //<< ; 07-Apr-2005   RobertW SR11836: Allow the date and time of the exchange rate
    //<< ;                       to be returned as well.
    //<< ; 06-Apr-2005   RobertW SR11836: Modified this to handle empty time, just add
    //<< ;                       1 to the day.  Also handles empty date.
    //<< ; 24-Mar-2005   RobertW SR11959: Modified from FCConvRate in COMSYSFC
    //<< ;-------------------------------------------------------------------------------
    //<< new objConvRate,dteRate,tmeRate,strIndex,blnQuit,strStart,strTimeIndex,strRate
    mVar objConvRate = m$.var("objConvRate");
    mVar dteRate = m$.var("dteRate");
    mVar tmeRate = m$.var("tmeRate");
    mVar strIndex = m$.var("strIndex");
    mVar blnQuit = m$.var("blnQuit");
    mVar strStart = m$.var("strStart");
    mVar strTimeIndex = m$.var("strTimeIndex");
    mVar strRate = m$.var("strRate");
    m$.newVar(objConvRate,dteRate,tmeRate,strIndex,blnQuit,strStart,strTimeIndex,strRate);
    //<< 
    //<< set objConvRate = ""
    objConvRate.set("");
    //<< set strRate     = ""
    strRate.set("");
    //<< 
    //<< if $get(pstrFC)'="" {
    if (mOp.NotEqual(m$.Fnc.$get(pstrFC),"")) {
      //<< set objConvRate = $get(^WWWWAE(0,pstrFC,1))
      objConvRate.set(m$.Fnc.$get(m$.var("^WWWWAE",0,pstrFC.get(),1)));
      //<< set strStart    = $piece(objConvRate,Y,6)
      strStart.set(m$.Fnc.$piece(objConvRate.get(),m$.var("Y").get(),6));
      //<< set strRate     = strStart
      strRate.set(strStart.get());
      //<< if $get(pstrTimeStamp)="" {
      if (mOp.Equal(m$.Fnc.$get(pstrTimeStamp),"")) {
        //<< set pstrTimeStamp = $horolog
        pstrTimeStamp.set(m$.Fnc.$horolog());
      }
      //<< }
      //<< set dteRate = +$get(pstrTimeStamp)
      dteRate.set(mOp.Positive(m$.Fnc.$get(pstrTimeStamp)));
      //<< set tmeRate = $piece(pstrTimeStamp,",",2)
      tmeRate.set(m$.Fnc.$piece(pstrTimeStamp.get(),",",2));
      //<< if tmeRate="" {
      if (mOp.Equal(tmeRate.get(),"")) {
        //<< set dteRate = dteRate+1
        dteRate.set(mOp.Add(dteRate.get(),1));
      }
      //<< }
      //<< set tmeRate = +tmeRate
      tmeRate.set(mOp.Positive(tmeRate.get()));
      //<< 
      //<< set pstrTimeStamp = dteRate_","_tmeRate
      pstrTimeStamp.set(mOp.Concat(mOp.Concat(dteRate.get(),","),tmeRate.get()));
      //<< 
      //<< if $$$DateDiff(pstrTimeStamp,strStart) > 0 {
      if (mOp.Greater(include.COMSYSDate.$$$DateDiff(m$,pstrTimeStamp,strStart),0)) {
        //<< if $data(^WWWWAEDATE(0,pstrFC,dteRate,tmeRate,1))=1 {  ;We have an exact match return
        if (mOp.Equal(m$.Fnc.$data(m$.var("^WWWWAEDATE",0,pstrFC.get(),dteRate.get(),tmeRate.get(),1)),1)) {
          //<< set dtePrev = dteRate
          mVar dtePrev = m$.var("dtePrev");
          dtePrev.set(dteRate.get());
          //<< set tmePrev = $order(^WWWWAEDATE(0,pstrFC,dteRate,tmeRate+1))
          mVar tmePrev = m$.var("tmePrev");
          tmePrev.set(m$.Fnc.$order(m$.var("^WWWWAEDATE",0,pstrFC.get(),dteRate.get(),mOp.Add(tmeRate.get(),1))));
          //<< if tmePrev="" {
          if (mOp.Equal(tmePrev.get(),"")) {
            //<< set dtePrev = $order(^WWWWAEDATE(0,pstrFC,dteRate+1))
            dtePrev.set(m$.Fnc.$order(m$.var("^WWWWAEDATE",0,pstrFC.get(),mOp.Add(dteRate.get(),1))));
            //<< if dtePrev'="" {
            if (mOp.NotEqual(dtePrev.get(),"")) {
              //<< set tmePrev = $order(^WWWWAEDATE(0,pstrFC,dtePrev,""))
              tmePrev.set(m$.Fnc.$order(m$.var("^WWWWAEDATE",0,pstrFC.get(),dtePrev.get(),"")));
            }
          }
          //<< }
          //<< }
          //<< 
          //<< set strRate = +dteRate_","_+tmeRate
          strRate.set(mOp.Concat(mOp.Concat(mOp.Positive(dteRate.get()),","),mOp.Positive(tmeRate.get())));
          //<< if (dtePrev'="") && (tmePrev'="") {
          if ((mOp.NotEqual(dtePrev.get(),"")) && (mOp.NotEqual(tmePrev.get(),""))) {
            //<< set objConvRate = ^WWWWAEDATE(0,pstrFC,dtePrev,tmePrev,1)
            objConvRate.set(m$.var("^WWWWAEDATE",0,pstrFC.get(),dtePrev.get(),tmePrev.get(),1).get());
          }
        }
        //<< }
        //<< 
        //<< } else {
        else {
          //<< set strIndex = ""
          strIndex.set("");
          //<< set blnQuit  = $$$NO
          blnQuit.set(include.COMSYS.$$$NO(m$));
          //<< for {
          for (;true;) {
            //<< set strIndex = $order(^WWWWAEDATE(0,pstrFC,strIndex)) quit:strIndex=""
            strIndex.set(m$.Fnc.$order(m$.var("^WWWWAEDATE",0,pstrFC.get(),strIndex.get())));
            if (mOp.Equal(strIndex.get(),"")) {
              break;
            }
            //<< 
            //<< if (strIndex=dteRate) {
            if ((mOp.Equal(strIndex.get(),dteRate.get()))) {
              //<< set strTimeIndex = ""
              strTimeIndex.set("");
              //<< for {
              for (;true;) {
                //<< set strTimeIndex = $order(^WWWWAEDATE(0,pstrFC,strIndex,strTimeIndex))
                strTimeIndex.set(m$.Fnc.$order(m$.var("^WWWWAEDATE",0,pstrFC.get(),strIndex.get(),strTimeIndex.get())));
                //<< quit:strTimeIndex=""
                if (mOp.Equal(strTimeIndex.get(),"")) {
                  break;
                }
                //<< 
                //<< set blnQuit = (tmeRate<=strTimeIndex)
                blnQuit.set((mOp.LessOrEqual(tmeRate.get(),strTimeIndex.get())));
                //<< quit:blnQuit
                if (mOp.Logical(blnQuit.get())) {
                  break;
                }
              }
            }
            //<< }
            //<< }
            //<< 
            //<< if strIndex>dteRate {
            if (mOp.Greater(strIndex.get(),dteRate.get())) {
              //<< set blnQuit      = $$$YES
              blnQuit.set(include.COMSYS.$$$YES(m$));
              //<< set strTimeIndex = $order(^WWWWAEDATE(0,pstrFC,strIndex,""))
              strTimeIndex.set(m$.Fnc.$order(m$.var("^WWWWAEDATE",0,pstrFC.get(),strIndex.get(),"")));
            }
            //<< }
            //<< quit:blnQuit
            if (mOp.Logical(blnQuit.get())) {
              break;
            }
          }
          //<< }
          //<< 
          //<< set objConvRate=""
          objConvRate.set("");
          //<< if (strIndex'="")&&(strTimeIndex'="") {
          if ((mOp.NotEqual(strIndex.get(),"")) && (mOp.NotEqual(strTimeIndex.get(),""))) {
            //<< set objConvRate=$get(^WWWWAEDATE(0,pstrFC,strIndex,strTimeIndex,1))
            objConvRate.set(m$.Fnc.$get(m$.var("^WWWWAEDATE",0,pstrFC.get(),strIndex.get(),strTimeIndex.get(),1)));
            //<< set dtePrev=strIndex
            mVar dtePrev = m$.var("dtePrev");
            dtePrev.set(strIndex.get());
            //<< set tmePrev=$order(^WWWWAEDATE(0,pstrFC,strIndex,strTimeIndex),-1)
            mVar tmePrev = m$.var("tmePrev");
            tmePrev.set(m$.Fnc.$order(m$.var("^WWWWAEDATE",0,pstrFC.get(),strIndex.get(),strTimeIndex.get()),mOp.Negative(1)));
            //<< if tmePrev="" {
            if (mOp.Equal(tmePrev.get(),"")) {
              //<< set dtePrev=$order(^WWWWAEDATE(0,pstrFC,strIndex),-1)
              dtePrev.set(m$.Fnc.$order(m$.var("^WWWWAEDATE",0,pstrFC.get(),strIndex.get()),mOp.Negative(1)));
              //<< if dtePrev'="" {
              if (mOp.NotEqual(dtePrev.get(),"")) {
                //<< set tmePrev=$order(^WWWWAEDATE(0,pstrFC,dtePrev,""),-1)
                tmePrev.set(m$.Fnc.$order(m$.var("^WWWWAEDATE",0,pstrFC.get(),dtePrev.get(),""),mOp.Negative(1)));
              }
            }
            //<< }
            //<< }
            //<< 
            //<< set strRate=+dtePrev_","_+tmePrev
            strRate.set(mOp.Concat(mOp.Concat(mOp.Positive(dtePrev.get()),","),mOp.Positive(tmePrev.get())));
          }
        }
      }
    }
    //<< }
    //<< }
    //<< }
    //<< }
    //<< //if objConvRate'=""     ; FIXME : no operation
    //<< 
    //<< quit $piece(objConvRate,Y,5)_$select(pblnReturnDateTime:Y_strRate,$$$YES:"")
    return mOp.Concat(m$.Fnc.$piece(objConvRate.get(),m$.var("Y").get(),5),m$.Fnc.$select(pblnReturnDateTime.get(),mOp.Concat(m$.var("Y").get(),strRate.get()),include.COMSYS.$$$YES(m$),""));
  }

  //<< 
  //<< 
  //<< GetDecimalPoints(pstrFC)
  public Object GetDecimalPoints(Object ... _p) {
    mVar pstrFC = m$.newVarRef("pstrFC",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Get the number of decimal places for a currency
    //<< ;
    //<< ; Params:
    //<< ;
    //<< ; ByRefs:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 21-Feb-2006   RPW     SR14229: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new intDP,objConvRate
    mVar intDP = m$.var("intDP");
    mVar objConvRate = m$.var("objConvRate");
    m$.newVar(intDP,objConvRate);
    //<< 
    //<< set intDP = 2
    intDP.set(2);
    //<< if pstrFC'="" {
    if (mOp.NotEqual(pstrFC.get(),"")) {
      //<< set objConvRate = $get(^WWWWAE(0,pstrFC,1))
      objConvRate.set(m$.Fnc.$get(m$.var("^WWWWAE",0,pstrFC.get(),1)));
      //<< if objConvRate'="" set intDP = $piece(objConvRate,"~",8)
      if (mOp.NotEqual(objConvRate.get(),"")) {
        intDP.set(m$.Fnc.$piece(objConvRate.get(),"~",8));
      }
    }
    //<< }
    //<< 
    //<< if intDP="" set intDP = 2
    if (mOp.Equal(intDP.get(),"")) {
      intDP.set(2);
    }
    //<< 
    //<< quit intDP
    return intDP.get();
  }

//<< 
//<< 
}
