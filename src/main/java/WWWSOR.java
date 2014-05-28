//*****************************************************************************
//** TASC - ALPHALINC - MAC WWWSOR
//** Innovatium Systems - Code Converter - v1.28
//** 2014-05-26 21:14:32
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

//<< WWWSOR(YDATEI,YFKEY,YAUSW,YRICHT,YSORT,YANZ,YKOMP,YFIND,YFFKY,YSAUSW)
public class WWWSOR extends mClass {

  public Object main(Object ... _p) {
    mVar YDATEI = m$.newVarRef("YDATEI",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar YFKEY = m$.newVarRef("YFKEY",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar YAUSW = m$.newVarRef("YAUSW",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    mVar YRICHT = m$.newVarRef("YRICHT",(((_p!=null)&&(_p.length>=4))?_p[3]:null));
    mVar YSORT = m$.newVarRef("YSORT",(((_p!=null)&&(_p.length>=5))?_p[4]:null));
    mVar YANZ = m$.newVarRef("YANZ",(((_p!=null)&&(_p.length>=6))?_p[5]:null));
    mVar YKOMP = m$.newVarRef("YKOMP",(((_p!=null)&&(_p.length>=7))?_p[6]:null));
    mVar YFIND = m$.newVarRef("YFIND",(((_p!=null)&&(_p.length>=8))?_p[7]:null));
    mVar YFFKY = m$.newVarRef("YFFKY",(((_p!=null)&&(_p.length>=9))?_p[8]:null));
    mVar YSAUSW = m$.newVarRef("YSAUSW",(((_p!=null)&&(_p.length>=10))?_p[9]:null));
    return _WWWSOR(YDATEI,YFKEY,YAUSW,YRICHT,YSORT,YANZ,YKOMP,YFIND,YFFKY,YSAUSW);
  }

  public Object _WWWSOR(Object ... _p) {
    mVar YDATEI = m$.newVarRef("YDATEI",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar YFKEY = m$.newVarRef("YFKEY",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar YAUSW = m$.newVarRef("YAUSW",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    mVar YRICHT = m$.newVarRef("YRICHT",(((_p!=null)&&(_p.length>=4))?_p[3]:null));
    mVar YSORT = m$.newVarRef("YSORT",(((_p!=null)&&(_p.length>=5))?_p[4]:null));
    mVar YANZ = m$.newVarRef("YANZ",(((_p!=null)&&(_p.length>=6))?_p[5]:null));
    mVar YKOMP = m$.newVarRef("YKOMP",(((_p!=null)&&(_p.length>=7))?_p[6]:null));
    mVar YFIND = m$.newVarRef("YFIND",(((_p!=null)&&(_p.length>=8))?_p[7]:null));
    mVar YFFKY = m$.newVarRef("YFFKY",(((_p!=null)&&(_p.length>=9))?_p[8]:null));
    mVar YSAUSW = m$.newVarRef("YSAUSW",(((_p!=null)&&(_p.length>=10))?_p[9]:null));
    //<< ;------------------------------------------------------------------------------
    //<< ; Description of Function :
    //<< ;       AUSWAHL AUS DATEI
    //<< ;       SELECTION FROM FILE
    //<< ;
    //<< ;   ERGEBNIS STEHT IN     / RESULTSET WILL BE IN            :  ^WWWSOR(YUSER,"KEY",LFN,KEY)=SCHLÜSSEL
    //<< ;   ALLE KEY' STEHEN IN   / ALL KEYS ARE IN                 :  ^WWWSOR(YUSER,"SEL",TEILKEY)=""
    //<< ;   LOCK IN               / DURING EXECUTION THE LOCK IS IN :  ^WWWSOR(YUSER,"LOCK")=$H
    //<< ;
    //<< ; Inputs :  YDATEI  - class name
    //<< ;           YFKEY   - FESTE PRIMÄRSCHLÜSSEL;FIXED KEY
    //<< ;           YAUSW   - VARIABLE PRIMÄRSCHLÜSSEL (AB KEY) ODER SORT AB ODER *=WILDCARD ;Or Confirm. Or
    //<< ;           YRICHT  - Orientation (Ascending/Descending) from YORIENT ?
    //<< ;           YSORT   - index key
    //<< ;           YANZ    - ANZAHL DER GESUCHTEN WERTE;NR. OF RECORDS ;Number the
    //<< ;           YKOMP   - 1 = KOMPLETTER KEY; 2 LETZTER KEY FEHLT(GRID-SUCHE); 1 TOTALKEY; 2 PARTKEY (GRID)
    //<< ;           YFIND   - SATZ IN FORM YFELD, WENN $F DER SAETZE->DANN STOP  ;STOP IF FOUND
    //<< ;           YFFKY   - SATZ IN FORM YKEY,  WENN $F DER SAETZE->DANN STOP  ;STOP IF CONTAIN
    //<< ;           YSAUSW  - FIX VORGABEN FÜR SORTKEY ; FIXED KEY FOR INDEX
    //<< ;
    //<< ; ByRef :
    //<< ;
    //<< ;
    //<< ; Returns :
    //<< ;
    //<< ;
    //<< ; History :
    //<< ; 08-Jun-2010   PPP     SR17356:Alpha Numeric Items not displaying the Pricing Details
    //<< ;                       form 'INItemPrice - corrected
    //<< ; 02-Aug-2007   GRF     SR15571: Revert previous SR15571 changes to 03-May-2007
    //<< ;                       copy from source logging for build.
    //<< ;                       Retain idxClass; keep LC/UC variables but assign from macro
    //<< ;                       - faster; Comment out Cache Object (AltSaveType = 4) blocks.
    //<< ; 31-Jul-2007   GRF     SR15571: Combine idClass/idClassIndex in if/else;
    //<< ;                       pstrDirection => pblnReverse.
    //<< ; 12-Jul-2007   RPW     SR15571: Rewrite into brace syntax and ignore differences
    //<< ;                       between object access (Access Type 4) and normal
    //<< ;                       Approach taken : If test is "enumAltSave=4", comment out;
    //<< ;                       if test is "enumAltSave'=4", delete that part of the test.
    //<< ; 03-May-2007   GRF     SR15509: Doco; quits; brace conversion with if/else
    //<< ;                       replacement; !/& => ||/&&; boolean macros
    //<< ; 05-Feb-2007   RPW     SR14900: Do not call code that doesn't exist
    //<< ; 03.02.1999    DT      (C) DITMAR TYBUSSEK
    //<< ;-----------------------------------------------------------------------------*/
    //<< new LC,UC,LC2,UC2,YLFN,YA,YI,YSRI,YMAXKEY,YMAL,YAUSW1,YWILD,YTKEY,YZWV,YKEY,Q
    mVar LC = m$.var("LC");
    mVar UC = m$.var("UC");
    mVar LC2 = m$.var("LC2");
    mVar UC2 = m$.var("UC2");
    mVar YLFN = m$.var("YLFN");
    mVar YA = m$.var("YA");
    mVar YI = m$.var("YI");
    mVar YSRI = m$.var("YSRI");
    mVar YMAXKEY = m$.var("YMAXKEY");
    mVar YMAL = m$.var("YMAL");
    mVar YAUSW1 = m$.var("YAUSW1");
    mVar YWILD = m$.var("YWILD");
    mVar YTKEY = m$.var("YTKEY");
    mVar YZWV = m$.var("YZWV");
    mVar YKEY = m$.var("YKEY");
    mVar Q = m$.var("Q");
    m$.newVar(LC,UC,LC2,UC2,YLFN,YA,YI,YSRI,YMAXKEY,YMAL,YAUSW1,YWILD,YTKEY,YZWV,YKEY,Q);
    //<< new YDATA,YDH,YYA,YFILE,YFILES,YSA,YSORTNAME,YDHLOCK
    mVar YDATA = m$.var("YDATA");
    mVar YDH = m$.var("YDH");
    mVar YYA = m$.var("YYA");
    mVar YFILE = m$.var("YFILE");
    mVar YFILES = m$.var("YFILES");
    mVar YSA = m$.var("YSA");
    mVar YSORTNAME = m$.var("YSORTNAME");
    mVar YDHLOCK = m$.var("YDHLOCK");
    m$.newVar(YDATA,YDH,YYA,YFILE,YFILES,YSA,YSORTNAME,YDHLOCK);
    //<< new idxClass,strChar,strSaveData,strSaveIndexKey
    mVar idxClass = m$.var("idxClass");
    mVar strChar = m$.var("strChar");
    mVar strSaveData = m$.var("strSaveData");
    mVar strSaveIndexKey = m$.var("strSaveIndexKey");
    m$.newVar(idxClass,strChar,strSaveData,strSaveIndexKey);
    //<< 
    //<< if YDATEI'="" {               ; 02-Aug-2007
    if (mOp.NotEqual(YDATEI.get(),"")) {
      //<< set idxClass=$$^WWWUMLAU(YDATEI)
      idxClass.set(m$.fnc$("WWWUMLAU.main",YDATEI.get()));
      //<< if $order(^WWW0011s(0,1,idxClass,""))'="" set YDATEI=$order(^WWW0011s(0,1,idxClass,""))  ;tybd;16,2,2005;27239;ALTERNATIVE CLASS
      if (mOp.NotEqual(m$.Fnc.$order(m$.var("^WWW0011s",0,1,idxClass.get(),"")),"")) {
        YDATEI.set(m$.Fnc.$order(m$.var("^WWW0011s",0,1,idxClass.get(),"")));
      }
    }
    //<< }
    //<< 
    //<< SET LC  = $$$LC
    LC.set(include.COMSYSString.$$$LC(m$));
    //<< SET UC  = $$$UC
    UC.set(include.COMSYSString.$$$UC(m$));
    //<< SET LC2 = $$$LC2
    LC2.set(include.COMSYSString.$$$LC2(m$));
    //<< SET UC2 = $$$UC2
    UC2.set(include.COMSYSString.$$$UC2(m$));
    //<< 
    //<< 
    //<< SET YSAUSW=$GET(YSAUSW)
    YSAUSW.set(m$.Fnc.$get(YSAUSW));
    //<< 
    //<< IF $EXTRACT(YSAUSW)="@" DO  ;WENN @ ;when
    if (mOp.Equal(m$.Fnc.$extract(YSAUSW.get()),"@")) {
      do {
        //<< . NEW YA
        m$.newVarBlock(1,YA);
        //<< . IF $EXTRACT(YSAUSW,2)'="$" SET YSAUSW=@($EXTRACT(YSAUSW,2,99)) QUIT
        if (mOp.NotEqual(m$.Fnc.$extract(YSAUSW.get(),2),"$")) {
          YSAUSW.set(m$.indirectVar((m$.Fnc.$extract(YSAUSW.get(),2,99))).get());
          break;
        }
        //<< . SET YA="S YSAUSW="_$EXTRACT(YSAUSW,2,99)
        YA.set(mOp.Concat("S YSAUSW=",m$.Fnc.$extract(YSAUSW.get(),2,99)));
        //<< . XECUTE YA
        m$.Cmd.Xecute(YA.get());
      } while (false);
    }
    m$.restoreVarBlock(1);
    //<< 
    //<< QUIT:$GET(YDATEI)=""
    if (mOp.Equal(m$.Fnc.$get(YDATEI),"")) {
      return null;
    }
    //<< 
    //<< SET YDH=$PIECE($HOROLOG,",",2)   ;SUCHE NACH 30 SEKUNDEN STOPPEN ;search within
    YDH.set(m$.Fnc.$piece(m$.Fnc.$horolog(),",",2));
    //<< SET YDATA="" IF $EXTRACT(YDATEI,1,2)'="IN" IF $EXTRACT(YDATEI,1,3)'="WWW" SET YDATA=$GET(^WWW001(0,YDATEI,1))
    YDATA.set("");
    if (mOp.NotEqual(m$.Fnc.$extract(YDATEI.get(),1,2),"IN")) {
      if (mOp.NotEqual(m$.Fnc.$extract(YDATEI.get(),1,3),"WWW")) {
        YDATA.set(m$.Fnc.$get(m$.var("^WWW001",0,YDATEI.get(),1)));
      }
    }
    //<< SET YALTERN = +$$$WWW001AltSaveProcedure(YDATA)    ; 02-Aug-2007  D8
    mVar YALTERN = m$.var("YALTERN");
    YALTERN.set(mOp.Positive(include.WWWConst.$$$WWW001AltSaveProcedure(m$,YDATA)));
    //<< IF YALTERN=5 SET YALTERN=0
    if (mOp.Equal(YALTERN.get(),5)) {
      YALTERN.set(0);
    }
    //<< 
    //<< set YSORTNAME=""
    YSORTNAME.set("");
    //<< if YSORT>0 {                                                        ; SR15509
    if (mOp.Greater(YSORT.get(),0)) {
      //<< set YSORTNAME=$piece($get(^WWW0013(0,YDATEI,YSORT,1)),Y,1)
      YSORTNAME.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW0013",0,YDATEI.get(),YSORT.get(),1)),m$.var("Y").get(),1));
      //<< if YSORTNAME="" {
      if (mOp.Equal(YSORTNAME.get(),"")) {
        //<< ;       if YALTERN=4  {        ; 02-Aug-2007 vvv
        //<< ;           set YSORTNAME="Index"_+YSORT
        //<< ;       } else {
        //<< set YSORTNAME=+YSORT
        YSORTNAME.set(mOp.Positive(YSORT.get()));
      }
    }
    //<< ;       }
    //<< }
    //<< }
    //<< 
    //<< ;SUCHE IN ZEITABHÄNGIGER DATEI ;search within data file
    //<< IF $GET(YTIMEFORM)=1 SET YDATEI=YDATEI_"t",YSORT=0
    if (mOp.Equal(m$.Fnc.$get(m$.var("YTIMEFORM")),1)) {
      YDATEI.set(mOp.Concat(YDATEI.get(),"t"));
      YSORT.set(0);
    }
    //<< 
    //<< /*  vvv  02-Aug-2007
    //<< IF YALTERN=4 {                                                      ; SR15509
    //<< IF $EXTRACT(YAUSW)="." SET YAUSW=$EXTRACT(YAUSW,2,999)
    //<< SET YAUSW=$TR(YAUSW,"|")
    //<< ;   DO ##class(User.Find).Find(YDATEI,YFKEY,YAUSW,YRICHT,YSORTNAME,YANZ,YUSER) // SR14900
    //<< quit                                               // *** EARLY EXIT ***
    //<< }
    //<< */
    //<< 
    //<< ;SET YFILE=YDATEI
    //<< ;IF $PIECE(YDATA,Y,22)'="" SET YFILE=$PIECE(YDATA,Y,22)   ;ANDERE DATEI ;data file
    //<< ;SET YFILES=YDATEI_"s"
    //<< ;IF $PIECE(YDATA,Y,23)'="" SET YFILES=$PIECE(YDATA,Y,23)  ;ANDERE SORTDATEI
    //<< 
    //<< set strSaveData     = $$$WWW001SaveDataInFile(YDATA)
    strSaveData.set(include.WWWConst.$$$WWW001SaveDataInFile(m$,YDATA));
    //<< set strSaveIndexKey = $$$WWW001SaveIndexKeyInFile(YDATA)
    strSaveIndexKey.set(include.WWWConst.$$$WWW001SaveIndexKeyInFile(m$,YDATA));
    //<< 
    //<< if strSaveData="" {                     ;ANDERE DATEI ;data file
    if (mOp.Equal(strSaveData.get(),"")) {
      //<< set YFILE = YDATEI
      YFILE.set(YDATEI.get());
    }
    //<< } else {
    else {
      //<< set YFILE = strSaveData
      YFILE.set(strSaveData.get());
    }
    //<< }
    //<< 
    //<< if strSaveIndexKey="" {                 ;ANDERE SORTDATEI
    if (mOp.Equal(strSaveIndexKey.get(),"")) {
      //<< set YFILES = YDATEI_"s"
      YFILES.set(mOp.Concat(YDATEI.get(),"s"));
    }
    //<< } else {
    else {
      //<< set YFILES = strSaveIndexKey
      YFILES.set(strSaveIndexKey.get());
    }
    //<< }
    //<< ;  ^^^  02-Aug-2007
    //<< 
    //<< IF '$DATA(YFIND) SET YFIND=""
    if (mOp.Not(m$.Fnc.$data(YFIND))) {
      YFIND.set("");
    }
    //<< IF '$DATA(YFFKY) SET YFFKY=""
    if (mOp.Not(m$.Fnc.$data(YFFKY))) {
      YFFKY.set("");
    }
    //<< 
    //<< IF YUMLAU="" {                                                      ; SR15509
    if (mOp.Equal(m$.var("YUMLAU").get(),"")) {
      //<< IF YFIND'="" SET YFIND=$TRANSLATE(YFIND,LC,UC)
      if (mOp.NotEqual(YFIND.get(),"")) {
        YFIND.set(m$.Fnc.$translate(YFIND.get(),LC.get(),UC.get()));
      }
      //<< IF YFFKY'="" SET YFFKY=$TRANSLATE(YFFKY,LC2,UC2)
      if (mOp.NotEqual(YFFKY.get(),"")) {
        YFFKY.set(m$.Fnc.$translate(YFFKY.get(),LC2.get(),UC2.get()));
      }
    }
    //<< } else {
    else {
      //<< IF YFIND'="" SET YFIND=$$^WWWUMLAU(YFIND,2)
      if (mOp.NotEqual(YFIND.get(),"")) {
        YFIND.set(m$.fnc$("WWWUMLAU.main",YFIND.get(),2));
      }
      //<< IF YFFKY'="" SET YFFKY=$$^WWWUMLAU(YFFKY,2)
      if (mOp.NotEqual(YFFKY.get(),"")) {
        YFFKY.set(m$.fnc$("WWWUMLAU.main",YFFKY.get(),2));
      }
    }
    //<< }
    //<< 
    //<< SET YA(9)=0
    YA.var(9).set(0);
    //<< 
    //<< ;---------------------------------------
    //<< ; Sort Direction        ;SORTIERRICHTUNG
    //<< ; YRICHT                YSRI
    //<< ;                 use as Direction for $query after constructing global as string (see subr NEXT)
    //<< ; ------    ----------------------------
    //<< ;  NO         1         Ascending
    //<< ;  YES       -1         Descending
    //<< ;---------------------------------------
    //<< SET YSRI=1
    YSRI.set(1);
    //<< IF YRICHT=$$$YES SET YSRI=-1
    if (mOp.Equal(YRICHT.get(),include.COMSYS.$$$YES(m$))) {
      YSRI.set(mOp.Negative(1));
    }
    //<< 
    //<< 
    //<< KILL ^WWWSOR(YUSER,"SEL")
    m$.var("^WWWSOR",m$.var("YUSER").get(),"SEL").kill();
    //<< KILL ^WWWSOR(YUSER,"KEY")
    m$.var("^WWWSOR",m$.var("YUSER").get(),"KEY").kill();
    //<< SET YDHLOCK=$HOROLOG  ;LOCK
    YDHLOCK.set(m$.Fnc.$horolog());
    //<< SET ^WWWSOR(YUSER,"LOCK")=YDHLOCK
    m$.var("^WWWSOR",m$.var("YUSER").get(),"LOCK").set(YDHLOCK.get());
    //<< 
    //<< IF +YANZ=0 SET YANZ=999999999
    if (mOp.Equal(mOp.Positive(YANZ.get()),0)) {
      YANZ.set(999999999);
    }
    //<< /*  vvv 02-Aug-2007
    //<< IF YALTERN=4 {                                                     ; SR15509
    //<< IF YSRI=1 {
    //<< IF YANZ=2 SET YANZ=1       ;EINEN WENIGER BEI VOR ;minus next to pre-
    //<< } else {
    //<< IF YANZ=1 SET YANZ=2       ;EINEN MEHR BEI RUECK  ;more next to
    //<< }
    //<< }
    //<< */
    //<< SET YMAXKEY=+$ORDER(^WWW002(0,YDATEI,""),-1)
    YMAXKEY.set(mOp.Positive(m$.Fnc.$order(m$.var("^WWW002",0,YDATEI.get(),""),mOp.Negative(1))));
    //<< IF YMAXKEY=0 SET YMAXKEY=1
    if (mOp.Equal(YMAXKEY.get(),0)) {
      YMAXKEY.set(1);
    }
    //<< SET YA(2)=""
    YA.var(2).set("");
    //<< SET YMAL=0
    YMAL.set(0);
    //<< 
    //<< SET YAUSW1=YAUSW
    YAUSW1.set(YAUSW.get());
    //<< IF $LENGTH(YAUSW)'=1 IF $EXTRACT(YAUSW,$LENGTH(YAUSW))="*" SET YAUSW=$EXTRACT(YAUSW,1,$LENGTH(YAUSW)-1)
    if (mOp.NotEqual(m$.Fnc.$length(YAUSW.get()),1)) {
      if (mOp.Equal(m$.Fnc.$extract(YAUSW.get(),m$.Fnc.$length(YAUSW.get())),"*")) {
        YAUSW.set(m$.Fnc.$extract(YAUSW.get(),1,mOp.Subtract(m$.Fnc.$length(YAUSW.get()),1)));
      }
    }
    //<< SET YWILD=""  ;WILD-KEY
    YWILD.set("");
    //<< ;ALLES DURCHSUCHEN OHNE VORGABE ;search all without default
    //<< IF YUMLAU="" {                                                     ; SR15509
    if (mOp.Equal(m$.var("YUMLAU").get(),"")) {
      //<< IF $EXTRACT(YAUSW)="*" SET YWILD=$TRANSLATE($EXTRACT(YAUSW,2,99),LC,UC),YAUSW=""
      if (mOp.Equal(m$.Fnc.$extract(YAUSW.get()),"*")) {
        YWILD.set(m$.Fnc.$translate(m$.Fnc.$extract(YAUSW.get(),2,99),LC.get(),UC.get()));
        YAUSW.set("");
      }
    }
    //<< } else {
    else {
      //<< IF $EXTRACT(YAUSW)="*" SET YWILD=$$^WWWUMLAU($EXTRACT(YAUSW,2,99),1),YAUSW=""
      if (mOp.Equal(m$.Fnc.$extract(YAUSW.get()),"*")) {
        YWILD.set(m$.fnc$("WWWUMLAU.main",m$.Fnc.$extract(YAUSW.get(),2,99),1));
        YAUSW.set("");
      }
    }
    //<< }
    //<< 
    //<< ;ALLES MIT VORGABE ;all with default
    //<< IF $EXTRACT(YAUSW)="|" SET YWILD=YAUSW,YAUSW=$EXTRACT(YAUSW,2,999)
    if (mOp.Equal(m$.Fnc.$extract(YAUSW.get()),"|")) {
      YWILD.set(YAUSW.get());
      YAUSW.set(m$.Fnc.$extract(YAUSW.get(),2,999));
    }
    //<< 
    //<< ;ALLES AB ;whatsoever Confirm.
    //<< IF $EXTRACT(YAUSW)="." SET YAUSW=$EXTRACT(YAUSW,2,999) DO
    if (mOp.Equal(m$.Fnc.$extract(YAUSW.get()),".")) {
      YAUSW.set(m$.Fnc.$extract(YAUSW.get(),2,999));
      do {
        //<< . QUIT:YSRI'=-1
        if (mOp.NotEqual(YSRI.get(),mOp.Negative(1))) {
          break;
        }
        //<< . IF +YAUSW'=0 IF $LENGTH(YAUSW)'=0 SET YAUSW=YAUSW
        if (mOp.NotEqual(mOp.Positive(YAUSW.get()),0)) {
          if (mOp.NotEqual(m$.Fnc.$length(YAUSW.get()),0)) {
            YAUSW.set(YAUSW.get());
          }
        }
        //<< . IF +YAUSW=0  IF $LENGTH(YAUSW)'=0 SET YAUSW=YAUSW_$CHAR(255)
        if (mOp.Equal(mOp.Positive(YAUSW.get()),0)) {
          if (mOp.NotEqual(m$.Fnc.$length(YAUSW.get()),0)) {
            YAUSW.set(mOp.Concat(YAUSW.get(),m$.Fnc.$char(255)));
          }
        }
      } while (false);
    }
    //<< 
    //<< ;--------------------------------------- vvv TODO : Replace with calls to ExtendedGlobalReference^WWWSETObject <GRF>
    //<< SET YA="^"_YFILE_"("_$$^WWWYM(YDATEI,0)
    YA.set(mOp.Concat(mOp.Concat(mOp.Concat("^",YFILE.get()),"("),m$.fnc$("WWWYM.main",YDATEI.get(),0)));
    //<< IF $PIECE(YDATA,Y,12)'="" IF $PIECE(YDATA,Y,13)'="" DO  ;UCI UND VOL ;UCI And
    if (mOp.NotEqual(m$.Fnc.$piece(YDATA.get(),m$.var("Y").get(),12),"")) {
      if (mOp.NotEqual(m$.Fnc.$piece(YDATA.get(),m$.var("Y").get(),13),"")) {
        //<< . SET YA="^["_""""_$PIECE(YDATA,Y,12)_""""_","_""""_$PIECE(YDATA,Y,13)_""""_"]"_$PIECE(YA,"^",2,999)
        YA.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("^[","\""),m$.Fnc.$piece(YDATA.get(),m$.var("Y").get(),12)),"\""),","),"\""),m$.Fnc.$piece(YDATA.get(),m$.var("Y").get(),13)),"\""),"]"),m$.Fnc.$piece(YA.get(),"^",2,999)));
      }
    }
    //<< 
    //<< SET YA(3)=YA
    YA.var(3).set(YA.get());
    //<< IF +YSORT'=0 DO
    if (mOp.NotEqual(mOp.Positive(YSORT.get()),0)) {
      //<< . SET YA(2)="^"_YFILES_"("_$$^WWWYM(YDATEI,1)
      YA.var(2).set(mOp.Concat(mOp.Concat(mOp.Concat("^",YFILES.get()),"("),m$.fnc$("WWWYM.main",YDATEI.get(),1)));
      //<< . SET YA(2)=YA(2)_""""_YSORTNAME_""""
      YA.var(2).set(mOp.Concat(mOp.Concat(mOp.Concat(YA.var(2).get(),"\""),YSORTNAME.get()),"\""));
      //<< . IF $PIECE(YDATA,Y,12)'="" IF $PIECE(YDATA,Y,13)'="" DO  ;UCI UND VOL ;UCI And
      if (mOp.NotEqual(m$.Fnc.$piece(YDATA.get(),m$.var("Y").get(),12),"")) {
        if (mOp.NotEqual(m$.Fnc.$piece(YDATA.get(),m$.var("Y").get(),13),"")) {
          //<< . . SET YA(2)="^["_""""_$PIECE(YDATA,Y,12)_""""_","_""""_$PIECE(YDATA,Y,13)_""""_"]"_$PIECE(YA(2),"^",2,999)
          YA.var(2).set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("^[","\""),m$.Fnc.$piece(YDATA.get(),m$.var("Y").get(),12)),"\""),","),"\""),m$.Fnc.$piece(YDATA.get(),m$.var("Y").get(),13)),"\""),"]"),m$.Fnc.$piece(YA.var(2).get(),"^",2,999)));
        }
      }
    }
    //<< ;--------------------------------------- ^^^
    //<< 
    //<< ;IF YAUSW'="" IF YANZ>2 IF YRICHT=1 SET YAUSW=YAUSW_$CHAR(255)
    //<< IF YAUSW'="" IF YANZ>2 IF YRICHT=1 DO  ;FIS; 03.01.03
    if (mOp.NotEqual(YAUSW.get(),"")) {
      if (mOp.Greater(YANZ.get(),2)) {
        if (mOp.Equal(YRICHT.get(),1)) {
          do {
            //<< . IF YAUSW'=0 IF $LENGTH(YAUSW)'=$LENGTH(+YAUSW) SET YAUSW=YAUSW_$CHAR(255) QUIT
            if (mOp.NotEqual(YAUSW.get(),0)) {
              if (mOp.NotEqual(m$.Fnc.$length(YAUSW.get()),m$.Fnc.$length(mOp.Positive(YAUSW.get())))) {
                YAUSW.set(mOp.Concat(YAUSW.get(),m$.Fnc.$char(255)));
                break;
              }
            }
          } while (false);
        }
      }
    }
    //<< . ;SET YAUSW=YAUSW+1  ;TYBD;2,05,2003
    //<< 
    //<< IF YAUSW="" IF YRICHT=1 SET YAUSW=$CHAR(255)
    if (mOp.Equal(YAUSW.get(),"")) {
      if (mOp.Equal(YRICHT.get(),1)) {
        YAUSW.set(m$.Fnc.$char(255));
      }
    }
    //<< SET YI=2
    YI.set(2);
    //<< FOR YI=1:1 QUIT:$PIECE(YFKEY,",",YI)=""  IF $PIECE(YFKEY,",",YI)=$PIECE(YAUSW,",",YI) SET $PIECE(YAUSW,",",YI)=""
    for (YI.set(1);(true);YI.set(mOp.Add(YI.get(),1))) {
      if (mOp.Equal(m$.Fnc.$piece(YFKEY.get(),",",YI.get()),"")) {
        break;
      }
      if (mOp.Equal(m$.Fnc.$piece(YFKEY.get(),",",YI.get()),m$.Fnc.$piece(YAUSW.get(),",",YI.get()))) {
        m$.pieceVar(YAUSW,",",YI.get()).set("");
      }
    }
    //<< FOR YI=1:1:YMAXKEY IF $EXTRACT(YAUSW,1)="," SET YAUSW=$EXTRACT(YAUSW,2,999)
    for (YI.set(1);(mOp.LessOrEqual(YI.get(),YMAXKEY.get()));YI.set(mOp.Add(YI.get(),1))) {
      if (mOp.Equal(m$.Fnc.$extract(YAUSW.get(),1),",")) {
        YAUSW.set(m$.Fnc.$extract(YAUSW.get(),2,999));
      }
    }
    //<< IF YFKEY'="" FOR YI=1:1:YMAXKEY QUIT:$PIECE(YFKEY,",",YI)=""  DO
    if (mOp.NotEqual(YFKEY.get(),"")) {
      for (YI.set(1);(mOp.LessOrEqual(YI.get(),YMAXKEY.get()));YI.set(mOp.Add(YI.get(),1))) {
        if (mOp.Equal(m$.Fnc.$piece(YFKEY.get(),",",YI.get()),"")) {
          break;
        }
        //<< . IF $EXTRACT(YA,$LENGTH(YA))'="(" IF $EXTRACT(YA,$LENGTH(YA))'="," SET YA=YA_","
        if (mOp.NotEqual(m$.Fnc.$extract(YA.get(),m$.Fnc.$length(YA.get())),"(")) {
          if (mOp.NotEqual(m$.Fnc.$extract(YA.get(),m$.Fnc.$length(YA.get())),",")) {
            YA.set(mOp.Concat(YA.get(),","));
          }
        }
        //<< . SET YA=YA_""""_$TRANSLATE($PIECE(YFKEY,",",YI),"""")_""""
        YA.set(mOp.Concat(mOp.Concat(mOp.Concat(YA.get(),"\""),m$.Fnc.$translate(m$.Fnc.$piece(YFKEY.get(),",",YI.get()),"\"")),"\""));
      }
    }
    //<< 
    //<< 
    //<< SET YI=YI-1
    YI.set(mOp.Subtract(YI.get(),1));
    //<< IF (YAUSW'="")||(YSAUSW'="") FOR YI=1:1:YMAXKEY QUIT:($PIECE(YAUSW,",",YI)="")&&($PIECE(YSAUSW,",",YI)="")  DO
    if ((mOp.NotEqual(YAUSW.get(),"")) || (mOp.NotEqual(YSAUSW.get(),""))) {
      for (YI.set(1);(mOp.LessOrEqual(YI.get(),YMAXKEY.get()));YI.set(mOp.Add(YI.get(),1))) {
        if ((mOp.Equal(m$.Fnc.$piece(YAUSW.get(),",",YI.get()),"")) && (mOp.Equal(m$.Fnc.$piece(YSAUSW.get(),",",YI.get()),""))) {
          break;
        }
        //<< . IF $PIECE(YSAUSW,",",YI)'="" SET $PIECE(YAUSW,",",YI)=$PIECE(YSAUSW,",",YI)  ;VORGABE FESTER SORTKEY ;default
        if (mOp.NotEqual(m$.Fnc.$piece(YSAUSW.get(),",",YI.get()),"")) {
          m$.pieceVar(YAUSW,",",YI.get()).set(m$.Fnc.$piece(YSAUSW.get(),",",YI.get()));
        }
        //<< . IF $EXTRACT(YA,$LENGTH(YA))'="(" IF $EXTRACT(YA,$LENGTH(YA))'="," SET YA=YA_","
        if (mOp.NotEqual(m$.Fnc.$extract(YA.get(),m$.Fnc.$length(YA.get())),"(")) {
          if (mOp.NotEqual(m$.Fnc.$extract(YA.get(),m$.Fnc.$length(YA.get())),",")) {
            YA.set(mOp.Concat(YA.get(),","));
          }
        }
        //<< . SET YA=YA_""""_$TRANSLATE($PIECE(YAUSW,",",YI),"""")_""""
        YA.set(mOp.Concat(mOp.Concat(mOp.Concat(YA.get(),"\""),m$.Fnc.$translate(m$.Fnc.$piece(YAUSW.get(),",",YI.get()),"\"")),"\""));
        //<< . IF +YSORT'=0 IF YUMLAU="" DO
        if (mOp.NotEqual(mOp.Positive(YSORT.get()),0)) {
          if (mOp.Equal(m$.var("YUMLAU").get(),"")) {
            //<< . . IF +YAUSW'=0 SET YA(2)=YA(2)_","_""""_$TRANSLATE($TRANSLATE($PIECE(YAUSW,",",YI),""""),LC,UC)_""""   ;TYBD;UMLAU;6,10,2004;26526
            if (mOp.NotEqual(mOp.Positive(YAUSW.get()),0)) {
              YA.var(2).set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(YA.var(2).get(),","),"\""),m$.Fnc.$translate(m$.Fnc.$translate(m$.Fnc.$piece(YAUSW.get(),",",YI.get()),"\""),LC.get(),UC.get())),"\""));
            }
            //<< . . IF +YAUSW=0  SET YA(2)=YA(2)_","_""""_$TRANSLATE($TRANSLATE($PIECE(YAUSW,",",YI),""""),LC,UC)_""""
            if (mOp.Equal(mOp.Positive(YAUSW.get()),0)) {
              YA.var(2).set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(YA.var(2).get(),","),"\""),m$.Fnc.$translate(m$.Fnc.$translate(m$.Fnc.$piece(YAUSW.get(),",",YI.get()),"\""),LC.get(),UC.get())),"\""));
            }
          }
        }
        //<< . ;
        //<< . IF +YSORT'=0 IF YUMLAU'="" DO
        if (mOp.NotEqual(mOp.Positive(YSORT.get()),0)) {
          if (mOp.NotEqual(m$.var("YUMLAU").get(),"")) {
            //<< . . IF +YAUSW'=0 SET YA(2)=YA(2)_","_""""_$$^WWWUMLAU($TRANSLATE($PIECE(YAUSW,",",YI),""""),1)_""""   ;TYBD;UMLAU;6,10,2004;26526
            if (mOp.NotEqual(mOp.Positive(YAUSW.get()),0)) {
              YA.var(2).set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(YA.var(2).get(),","),"\""),m$.fnc$("WWWUMLAU.main",m$.Fnc.$translate(m$.Fnc.$piece(YAUSW.get(),",",YI.get()),"\""),1)),"\""));
            }
            //<< . . IF +YAUSW=0  SET YA(2)=YA(2)_","_""""_$$^WWWUMLAU($TRANSLATE($PIECE(YAUSW,",",YI),""""),1)_""""
            if (mOp.Equal(mOp.Positive(YAUSW.get()),0)) {
              YA.var(2).set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(YA.var(2).get(),","),"\""),m$.fnc$("WWWUMLAU.main",m$.Fnc.$translate(m$.Fnc.$piece(YAUSW.get(),",",YI.get()),"\""),1)),"\""));
            }
          }
        }
      }
    }
    //<< 
    //<< ; TODO : Set from $$^WWWYM(YDATEI,1) above and reuse variable. <GRF>
    //<< SET YA(11)="^"_YFILES_"("_$$^WWWYM(YDATEI,1)
    YA.var(11).set(mOp.Concat(mOp.Concat(mOp.Concat("^",YFILES.get()),"("),m$.fnc$("WWWYM.main",YDATEI.get(),1)));
    //<< SET YA(11)=YA(11)_""""_YSORTNAME_""""
    YA.var(11).set(mOp.Concat(mOp.Concat(mOp.Concat(YA.var(11).get(),"\""),YSORTNAME.get()),"\""));
    //<< IF YSAUSW'="" IF YSORT'=0 SET YA(11)=YA(2)
    if (mOp.NotEqual(YSAUSW.get(),"")) {
      if (mOp.NotEqual(YSORT.get(),0)) {
        YA.var(11).set(YA.var(2).get());
      }
    }
    //<< //IF +YAUSW'=0 IF YSRI=-1 SET YA(2)=YA(2)_","_""""_$CHAR(255)_""""
    //<< //SR17356 - Alpha Numeric Items not displaying the Pricing Details form 'INItemPrice' - PPP 08-Jun-10
    //<< if +YAUSW'="" IF YSRI=-1 SET YA(2)=YA(2)_","_""""_$CHAR(255)_""""
    if (mOp.NotEqual(mOp.Positive(YAUSW.get()),"")) {
      if (mOp.Equal(YSRI.get(),mOp.Negative(1))) {
        YA.var(2).set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(YA.var(2).get(),","),"\""),m$.Fnc.$char(255)),"\""));
      }
    }
    //<< 
    //<< ;VERGLEICHSVARIABLE YA(1)
    //<< SET YA(1)="^"_YFILE_"("_$$^WWWYM(YDATEI,1)
    YA.var(1).set(mOp.Concat(mOp.Concat(mOp.Concat("^",YFILE.get()),"("),m$.fnc$("WWWYM.main",YDATEI.get(),1)));
    //<< IF $PIECE(YDATA,Y,12)'="" IF $PIECE(YDATA,Y,13)'="" DO  ;UCI UND VOL ;UCI And
    if (mOp.NotEqual(m$.Fnc.$piece(YDATA.get(),m$.var("Y").get(),12),"")) {
      if (mOp.NotEqual(m$.Fnc.$piece(YDATA.get(),m$.var("Y").get(),13),"")) {
        //<< . SET YA(1)="^["_""""_$PIECE(YDATA,Y,12)_""""_","_""""_$PIECE(YDATA,Y,13)_""""_"]"_$PIECE(YA(1),"^",2,999)
        YA.var(1).set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("^[","\""),m$.Fnc.$piece(YDATA.get(),m$.var("Y").get(),12)),"\""),","),"\""),m$.Fnc.$piece(YDATA.get(),m$.var("Y").get(),13)),"\""),"]"),m$.Fnc.$piece(YA.var(1).get(),"^",2,999)));
      }
    }
    //<< 
    //<< IF YFKEY'="" FOR YI=1:1:YMAXKEY QUIT:$PIECE(YFKEY,",",YI)=""  DO
    if (mOp.NotEqual(YFKEY.get(),"")) {
      for (YI.set(1);(mOp.LessOrEqual(YI.get(),YMAXKEY.get()));YI.set(mOp.Add(YI.get(),1))) {
        if (mOp.Equal(m$.Fnc.$piece(YFKEY.get(),",",YI.get()),"")) {
          break;
        }
        //<< . IF $EXTRACT(YA(1),$LENGTH(YA(1)))'="(" IF $EXTRACT(YA(1),$LENGTH(YA(1)))'="," SET YA(1)=YA(1)_","
        if (mOp.NotEqual(m$.Fnc.$extract(YA.var(1).get(),m$.Fnc.$length(YA.var(1).get())),"(")) {
          if (mOp.NotEqual(m$.Fnc.$extract(YA.var(1).get(),m$.Fnc.$length(YA.var(1).get())),",")) {
            YA.var(1).set(mOp.Concat(YA.var(1).get(),","));
          }
        }
        //<< . SET YA(1)=YA(1)_""""_$TRANSLATE($PIECE(YFKEY,",",YI),"""")_""""
        YA.var(1).set(mOp.Concat(mOp.Concat(mOp.Concat(YA.var(1).get(),"\""),m$.Fnc.$translate(m$.Fnc.$piece(YFKEY.get(),",",YI.get()),"\"")),"\""));
      }
    }
    //<< 
    //<< IF YFKEY'="" SET YA(1)=YA(1)_","
    if (mOp.NotEqual(YFKEY.get(),"")) {
      YA.var(1).set(mOp.Concat(YA.var(1).get(),","));
    }
    //<< 
    //<< ;--------------------------------------- vvv TODO : Replace with calls to ExtendedGlobalReference^WWWSETObject <GRF>
    //<< IF $PIECE(YDATA,Y,12)'="" IF $PIECE(YDATA,Y,13)'="" DO  ;UCI UND VOL ;UCI And
    if (mOp.NotEqual(m$.Fnc.$piece(YDATA.get(),m$.var("Y").get(),12),"")) {
      if (mOp.NotEqual(m$.Fnc.$piece(YDATA.get(),m$.var("Y").get(),13),"")) {
        //<< . SET YA(11)="^["_""""_$PIECE(YDATA,Y,12)_""""_","_""""_$PIECE(YDATA,Y,13)_""""_"]"_$PIECE(YA(11),"^",2,999)
        YA.var(11).set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("^[","\""),m$.Fnc.$piece(YDATA.get(),m$.var("Y").get(),12)),"\""),","),"\""),m$.Fnc.$piece(YDATA.get(),m$.var("Y").get(),13)),"\""),"]"),m$.Fnc.$piece(YA.var(11).get(),"^",2,999)));
      }
    }
    //<< ;--------------------------------------- ^^^
    //<< 
    //<< ; vvv 02-Aug-2007
    //<< set strChar=$extract(YA,$length(YA))
    strChar.set(m$.Fnc.$extract(YA.get(),m$.Fnc.$length(YA.get())));
    //<< if YSRI=1 {                                                     ; SR15509
    if (mOp.Equal(YSRI.get(),1)) {
      //<< if strChar="(" set YA=YA_"-1"
      if (mOp.Equal(strChar.get(),"(")) {
        YA.set(mOp.Concat(YA.get(),"-1"));
      }
      //<< if strChar="," set YA=YA_"-1"
      if (mOp.Equal(strChar.get(),",")) {
        YA.set(mOp.Concat(YA.get(),"-1"));
      }
    }
    //<< 
    //<< } else {
    else {
      //<< if strChar="(" set YA=YA_""""_$$$C255_""""
      if (mOp.Equal(strChar.get(),"(")) {
        YA.set(mOp.Concat(mOp.Concat(mOp.Concat(YA.get(),"\""),include.COMSYSString.$$$C255(m$)),"\""));
      }
      //<< if strChar="," set YA=YA_""""_$$$C255_""""
      if (mOp.Equal(strChar.get(),",")) {
        YA.set(mOp.Concat(mOp.Concat(mOp.Concat(YA.get(),"\""),include.COMSYSString.$$$C255(m$)),"\""));
      }
    }
    //<< }
    //<< ; ^^^
    //<< 
    //<< IF YSRI=-1 IF +YSORT=0 IF $LENGTH(YA,",")'=(YMAXKEY+1) IF $EXTRACT(YA,$LENGTH(YA))'=1 IF $EXTRACT(YA,$LENGTH(YA)-1)'=$CHAR(255) SET YA=YA_","_""""_$CHAR(255)_""""
    if (mOp.Equal(YSRI.get(),mOp.Negative(1))) {
      if (mOp.Equal(mOp.Positive(YSORT.get()),0)) {
        if (mOp.NotEqual(m$.Fnc.$length(YA.get(),","),(mOp.Add(YMAXKEY.get(),1)))) {
          if (mOp.NotEqual(m$.Fnc.$extract(YA.get(),m$.Fnc.$length(YA.get())),1)) {
            if (mOp.NotEqual(m$.Fnc.$extract(YA.get(),mOp.Subtract(m$.Fnc.$length(YA.get()),1)),m$.Fnc.$char(255))) {
              YA.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(YA.get(),","),"\""),m$.Fnc.$char(255)),"\""));
            }
          }
        }
      }
    }
    //<< 
    //<< SET YA=YA_")"
    YA.set(mOp.Concat(YA.get(),")"));
    //<< SET YA(2)=YA(2)_")"
    YA.var(2).set(mOp.Concat(YA.var(2).get(),")"));
    //<< 
    //<< IF $FIND(YA(2),"(,") SET YA(2)=$PIECE(YA(2),"(,",1)_"("_$PIECE(YA(2),"(,",2,99)
    if (mOp.Logical(m$.Fnc.$find(YA.var(2).get(),"(,"))) {
      YA.var(2).set(mOp.Concat(mOp.Concat(m$.Fnc.$piece(YA.var(2).get(),"(,",1),"("),m$.Fnc.$piece(YA.var(2).get(),"(,",2,99)));
    }
    //<< IF $FIND(YA(2),",)") SET YA(2)=$PIECE(YA(2),",)",1)_")"
    if (mOp.Logical(m$.Fnc.$find(YA.var(2).get(),",)"))) {
      YA.var(2).set(mOp.Concat(m$.Fnc.$piece(YA.var(2).get(),",)",1),")"));
    }
    //<< 
    //<< IF $FIND(YA(1),"(,") SET YA(1)=$PIECE(YA(1),"(,",1)_"("_$PIECE(YA(1),"(,",2,99)
    if (mOp.Logical(m$.Fnc.$find(YA.var(1).get(),"(,"))) {
      YA.var(1).set(mOp.Concat(mOp.Concat(m$.Fnc.$piece(YA.var(1).get(),"(,",1),"("),m$.Fnc.$piece(YA.var(1).get(),"(,",2,99)));
    }
    //<< IF $FIND(YA(1),",)") SET YA(1)=$PIECE(YA(1),",)",1)_")"
    if (mOp.Logical(m$.Fnc.$find(YA.var(1).get(),",)"))) {
      YA.var(1).set(mOp.Concat(m$.Fnc.$piece(YA.var(1).get(),",)",1),")"));
    }
    //<< 
    //<< IF $FIND(YA(11),"(,") SET YA(11)=$PIECE(YA(11),"(,",1)_"("_$PIECE(YA(11),"(,",2,99)
    if (mOp.Logical(m$.Fnc.$find(YA.var(11).get(),"(,"))) {
      YA.var(11).set(mOp.Concat(mOp.Concat(m$.Fnc.$piece(YA.var(11).get(),"(,",1),"("),m$.Fnc.$piece(YA.var(11).get(),"(,",2,99)));
    }
    //<< IF $FIND(YA(11),",)") SET YA(11)=$PIECE(YA(11),",)",1)_")"
    if (mOp.Logical(m$.Fnc.$find(YA.var(11).get(),",)"))) {
      YA.var(11).set(mOp.Concat(m$.Fnc.$piece(YA.var(11).get(),",)",1),")"));
    }
    //<< 
    //<< IF YAUSW=$CHAR(255) SET YAUSW=""
    if (mOp.Equal(YAUSW.get(),m$.Fnc.$char(255))) {
      YAUSW.set("");
    }
    //<< SET YYA=""
    YYA.set("");
    //<< 
    //<< IF +YSORT=0 IF YALTERN=4 IF $DATA(@(YA))#10=1 DO SATZ1   ;DATENSATZ VORHANDEN ;data record on hand
    if (mOp.Equal(mOp.Positive(YSORT.get()),0)) {
      if (mOp.Equal(YALTERN.get(),4)) {
        if (mOp.Equal(mOp.Modulus(m$.Fnc.$data(m$.indirectVar((YA.get()))),10),1)) {
          m$.Cmd.Do("SATZ1");
        }
      }
    }
    //<< FOR  DO SATZ QUIT:YA=""  QUIT:YANZ<YMAL  QUIT:YANZ=YMAL  QUIT:$PIECE($HOROLOG,",",2)>(YDH+600)
    for (;true;) {
      m$.Cmd.Do("SATZ");
      if (mOp.Equal(YA.get(),"")) {
        break;
      }
      if (mOp.Less(YANZ.get(),YMAL.get())) {
        break;
      }
      if (mOp.Equal(YANZ.get(),YMAL.get())) {
        break;
      }
      if (mOp.Greater(m$.Fnc.$piece(m$.Fnc.$horolog(),",",2),(mOp.Add(YDH.get(),600)))) {
        break;
      }
    }
    //<< 
    //<< QUIT
    return null;
  }

  //<< 
  //<< SATZ ;ZWISCHENSATZ SPEICHERN ;Save
  public void SATZ() {
    //<< IF +YSORT=0  DO NEXT  DO SATZ1
    if (mOp.Equal(mOp.Positive(m$.var("YSORT").get()),0)) {
      m$.Cmd.Do("NEXT");
      m$.Cmd.Do("SATZ1");
    }
    //<< IF +YSORT'=0 DO NEXTS DO SATZ1
    if (mOp.NotEqual(mOp.Positive(m$.var("YSORT").get()),0)) {
      m$.Cmd.Do("NEXTS");
      m$.Cmd.Do("SATZ1");
    }
    //<< QUIT
    return;
  }

  //<< 
  //<< SATZ1 ;
  public Object SATZ1() {
    //<< ;-------------------------------------------------------------------------------
    //<< ; History :
    //<< ; 02-Aug-2007   GRF     SR15571: Revert previous SR15571 changes to 03-May-2007
    //<< ;                       copy from source logging for build.
    //<< ; 31-Jul-2007   RPW     SR15571: Peer correction - missed test removed
    //<< ; 12-Jul-2007   RPW     SR15571: Rewrite into brace syntax
    //<< ;-------------------------------------------------------------------------------
    //<< QUIT:YA=""
    if (mOp.Equal(m$.var("YA").get(),"")) {
      return null;
    }
    //<< QUIT:YA(2)=""
    if (mOp.Equal(m$.var("YA").var(2).get(),"")) {
      return null;
    }
    //<< 
    //<< IF $LENGTH(YA,",")>1 IF $FIND(YA,"2)") IF $FIND(YDATEI,"t") QUIT  ;2.EBENE BEI ZEITABHÄNGIGE ERFASSUNG   ;next to logging
    if (mOp.Greater(m$.Fnc.$length(m$.var("YA").get(),","),1)) {
      if (mOp.Logical(m$.Fnc.$find(m$.var("YA").get(),"2)"))) {
        if (mOp.Logical(m$.Fnc.$find(m$.var("YDATEI").get(),"t"))) {
          return null;
        }
      }
    }
    //<< 
    //<< IF '$FIND(YA,"^[") IF $PIECE(YDATA,Y,22)="" QUIT:YDATEI'=$PIECE($PIECE(YA,"^",2),"(",1)
    if (mOp.Not(m$.Fnc.$find(m$.var("YA").get(),"^["))) {
      if (mOp.Equal(m$.Fnc.$piece(m$.var("YDATA").get(),m$.var("Y").get(),22),"")) {
        if (mOp.NotEqual(m$.var("YDATEI").get(),m$.Fnc.$piece(m$.Fnc.$piece(m$.var("YA").get(),"^",2),"(",1))) {
          return null;
        }
      }
    }
    //<< SET YKEY=$TRANSLATE($PIECE($PIECE($PIECE(YA,"(",2,99),",",2,99),",1)",1),"""")
    mVar YKEY = m$.var("YKEY");
    YKEY.set(m$.Fnc.$translate(m$.Fnc.$piece(m$.Fnc.$piece(m$.Fnc.$piece(m$.var("YA").get(),"(",2,99),",",2,99),",1)",1),"\""));
    //<< ;  02-Aug-2007
    //<< ;IF YALTERN=4 SET YKEY=$TRANSLATE($PIECE($PIECE(YA,"(",2),")",1),"""")
    //<< IF $FIND(YKEY,")") SET YKEY=$PIECE(YKEY,")",1)
    if (mOp.Logical(m$.Fnc.$find(YKEY.get(),")"))) {
      YKEY.set(m$.Fnc.$piece(YKEY.get(),")",1));
    }
    //<< 
    //<< QUIT:((YKEY="") || $FIND(YKEY,")"))
    if (mOp.Logical(((mOp.Equal(YKEY.get(),"")) || mOp.Logical(m$.Fnc.$find(YKEY.get(),")"))))) {
      return null;
    }
    //<< 
    //<< SET YTKEY=YKEY
    mVar YTKEY = m$.var("YTKEY");
    YTKEY.set(YKEY.get());
    //<< ;IF YALTERN>0 IF YALTERN'=4 DO     ; 02-Aug-2007
    //<< IF YALTERN>0 DO
    if (mOp.Greater(m$.var("YALTERN").get(),0)) {
      //<< . NEW YMMKEY
      mVar YMMKEY = m$.var("YMMKEY");
      m$.newVarBlock(1,YMMKEY);
      //<< . SET YMMKEY=0
      YMMKEY.set(0);
      //<< . IF $PIECE($TRANSLATE($GET(^WWW002(0,YDATEI,1,1)),"'",""""),Y,11)'="" SET YMMKEY=1
      if (mOp.NotEqual(m$.Fnc.$piece(m$.Fnc.$translate(m$.Fnc.$get(m$.var("^WWW002",0,m$.var("YDATEI").get(),1,1)),"'","\""),m$.var("Y").get(),11),"")) {
        YMMKEY.set(1);
      }
      //<< . IF $LENGTH(YTKEY,",")>YMAXKEY SET YTKEY=$PIECE(YTKEY,",",1,$LENGTH(YTKEY,",")-1)
      if (mOp.Greater(m$.Fnc.$length(YTKEY.get(),","),m$.var("YMAXKEY").get())) {
        YTKEY.set(m$.Fnc.$piece(YTKEY.get(),",",1,mOp.Subtract(m$.Fnc.$length(YTKEY.get(),","),1)));
      }
    }
    m$.restoreVarBlock(1);
    //<< 
    //<< IF $LENGTH(YTKEY,",")>1 IF YKOMP=2 SET YTKEY=$PIECE(YTKEY,",",1,$LENGTH(YTKEY,",")-1)
    if (mOp.Greater(m$.Fnc.$length(YTKEY.get(),","),1)) {
      if (mOp.Equal(m$.var("YKOMP").get(),2)) {
        YTKEY.set(m$.Fnc.$piece(YTKEY.get(),",",1,mOp.Subtract(m$.Fnc.$length(YTKEY.get(),","),1)));
      }
    }
    //<< IF +YSORT=0 SET YAUSW=$TRANSLATE(YKEY,"""")
    if (mOp.Equal(mOp.Positive(m$.var("YSORT").get()),0)) {
      mVar YAUSW = m$.var("YAUSW");
      YAUSW.set(m$.Fnc.$translate(YKEY.get(),"\""));
    }
    //<< IF +YSORT=0 IF $TRANSLATE(YFKEY,""""_",")'="" SET YAUSW=$PIECE(YAUSW,YFKEY_",",2)
    if (mOp.Equal(mOp.Positive(m$.var("YSORT").get()),0)) {
      if (mOp.NotEqual(m$.Fnc.$translate(m$.var("YFKEY").get(),mOp.Concat("\"",",")),"")) {
        mVar YAUSW = m$.var("YAUSW");
        YAUSW.set(m$.Fnc.$piece(m$.var("YAUSW").get(),mOp.Concat(m$.var("YFKEY").get(),","),2));
      }
    }
    //<< 
    //<< IF +YSORT'=0 DO  ;VORAUSWAHL WENN SORT FÜR NEXT SEARCH ;when to
    if (mOp.NotEqual(mOp.Positive(m$.var("YSORT").get()),0)) {
      //<< . NEW LFDAT,YSORTK,YSI,YQ,YSKTEIL
      mVar LFDAT = m$.var("LFDAT");
      mVar YSORTK = m$.var("YSORTK");
      mVar YSI = m$.var("YSI");
      mVar YQ = m$.var("YQ");
      mVar YSKTEIL = m$.var("YSKTEIL");
      m$.newVarBlock(1,LFDAT,YSORTK,YSI,YQ,YSKTEIL);
      //<< . SET YQ=0
      YQ.set(0);
      //<< . ;SET YFELD=$$^WWWSETL(YA)
      //<< . SET YFELD=YYA
      mVar YFELD = m$.var("YFELD");
      YFELD.set(m$.var("YYA").get());
      //<< . SET LFDAT=""
      LFDAT.set("");
      //<< . FOR  SET LFDAT=$ORDER(^WWW003(0,YDATEI,LFDAT)) QUIT:LFDAT=""  DO  QUIT:YQ=1
      for (;true;) {
        LFDAT.set(m$.Fnc.$order(m$.var("^WWW003",0,m$.var("YDATEI").get(),LFDAT.get())));
        if (mOp.Equal(LFDAT.get(),"")) {
          break;
        }
        do {
          //<< . . SET YSORTK=$PIECE($GET(^WWW003(0,YDATEI,LFDAT,1)),Y,6)
          YSORTK.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW003",0,m$.var("YDATEI").get(),LFDAT.get(),1)),m$.var("Y").get(),6));
          //<< . . QUIT:YSORTK=""
          if (mOp.Equal(YSORTK.get(),"")) {
            break;
          }
          //<< . . FOR YSI=1:1 SET YSORTK(1)=$PIECE(YSORTK,",",YSI) QUIT:YSORTK(1)=""  DO  QUIT:YQ=1
          for (YSI.set(1);(true);YSI.set(mOp.Add(YSI.get(),1))) {
            YSORTK.var(1).set(m$.Fnc.$piece(YSORTK.get(),",",YSI.get()));
            if (mOp.Equal(YSORTK.var(1).get(),"")) {
              break;
            }
            do {
              //<< . . . SET YSKTEIL=+$PIECE(YSORTK(1),".",2)
              YSKTEIL.set(mOp.Positive(m$.Fnc.$piece(YSORTK.var(1).get(),".",2)));
              //<< . . . IF YSKTEIL=0 SET YSKTEIL=1
              if (mOp.Equal(YSKTEIL.get(),0)) {
                YSKTEIL.set(1);
              }
              //<< . . . QUIT:YSKTEIL'=1  ;NUR ERSTES FELD ;only premier field
              if (mOp.NotEqual(YSKTEIL.get(),1)) {
                break;
              }
              //<< . . . IF $PIECE(YSORT,".",1)=$PIECE(YSORTK(1),".",1) SET $PIECE(YAUSW,",",YSKTEIL)=$TR($PIECE(YFELD,Y,LFDAT),",") SET YQ=1
              if (mOp.Equal(m$.Fnc.$piece(m$.var("YSORT").get(),".",1),m$.Fnc.$piece(YSORTK.var(1).get(),".",1))) {
                m$.pieceVar(m$.var("YAUSW"),",",YSKTEIL.get()).set(m$.Fnc.$translate(m$.Fnc.$piece(YFELD.get(),m$.var("Y").get(),LFDAT.get()),","));
                YQ.set(1);
              }
            } while (false);
            if (mOp.Equal(YQ.get(),1)) {
              break;
            }
          }
        } while (false);
        if (mOp.Equal(YQ.get(),1)) {
          break;
        }
      }
    }
    m$.restoreVarBlock(1);
    //<< 
    //<< SET YAUSWAHL=YAUSW
    mVar YAUSWAHL = m$.var("YAUSWAHL");
    YAUSWAHL.set(m$.var("YAUSW").get());
    //<< IF YDHLOCK'=$GET(^WWWSOR(YUSER,"LOCK")) HALT  ;FALSCHER LOCK          ; FIXME : HALT?   <GRF>
    if (mOp.NotEqual(m$.var("YDHLOCK").get(),m$.Fnc.$get(m$.var("^WWWSOR",m$.var("YUSER").get(),"LOCK")))) {
    }
    //<< QUIT:$DATA(^WWWSOR(YUSER,"SEL",YTKEY))
    if (mOp.Logical(m$.Fnc.$data(m$.var("^WWWSOR",m$.var("YUSER").get(),"SEL",YTKEY.get())))) {
      return null;
    }
    //<< SET ^WWWSOR(YUSER,"SEL",YTKEY)=""
    m$.var("^WWWSOR",m$.var("YUSER").get(),"SEL",YTKEY.get()).set("");
    //<< SET YMAL=YMAL+1
    mVar YMAL = m$.var("YMAL");
    YMAL.set(mOp.Add(m$.var("YMAL").get(),1));
    //<< SET ^WWWSOR(YUSER,"KEY",YMAL,YKEY)=YA
    m$.var("^WWWSOR",m$.var("YUSER").get(),"KEY",YMAL.get(),YKEY.get()).set(m$.var("YA").get());
    //<< IF YFFKY'="" DO
    if (mOp.NotEqual(m$.var("YFFKY").get(),"")) {
      //<< . SET Q=0
      mVar Q = m$.var("Q");
      Q.set(0);
      //<< . FOR YI=1:1 QUIT:$TRANSLATE($PIECE(YKEY,",",YI),"""")=""  DO  QUIT:Q=1   ;   I $TR($P(YKEY,",",YI+1),"""")="" I Q=1 K ^WWWSOR(YUSER,"KEY",YMAL,YKEY)   ;I Q=0 S YA=""
      mVar YI = m$.var("YI");
      for (YI.set(1);(true);YI.set(mOp.Add(YI.get(),1))) {
        if (mOp.Equal(m$.Fnc.$translate(m$.Fnc.$piece(YKEY.get(),",",YI.get()),"\""),"")) {
          break;
        }
        //<< . . ;
        //<< . . IF YUMLAU=""  IF '$FIND($TRANSLATE($TRANSLATE($PIECE(YKEY,",",YI),""""),LC2,UC2),$PIECE(YFFKY,",",YI)) SET Q=1 KILL ^WWWSOR(YUSER,"KEY",YMAL,YKEY)
        if (mOp.Equal(m$.var("YUMLAU").get(),"")) {
          if (mOp.Not(m$.Fnc.$find(m$.Fnc.$translate(m$.Fnc.$translate(m$.Fnc.$piece(YKEY.get(),",",YI.get()),"\""),m$.var("LC2").get(),m$.var("UC2").get()),m$.Fnc.$piece(m$.var("YFFKY").get(),",",YI.get())))) {
            Q.set(1);
            m$.var("^WWWSOR",m$.var("YUSER").get(),"KEY",YMAL.get(),YKEY.get()).kill();
          }
        }
        //<< . . IF YUMLAU'="" IF '$FIND($$^WWWUMLAU($TRANSLATE($PIECE(YKEY,",",YI),""""),2),$PIECE(YFFKY,",",YI))      SET Q=1 KILL ^WWWSOR(YUSER,"KEY",YMAL,YKEY)
        if (mOp.NotEqual(m$.var("YUMLAU").get(),"")) {
          if (mOp.Not(m$.Fnc.$find(m$.fnc$("WWWUMLAU.main",m$.Fnc.$translate(m$.Fnc.$piece(YKEY.get(),",",YI.get()),"\""),2),m$.Fnc.$piece(m$.var("YFFKY").get(),",",YI.get())))) {
            Q.set(1);
            m$.var("^WWWSOR",m$.var("YUSER").get(),"KEY",YMAL.get(),YKEY.get()).kill();
          }
        }
        if (mOp.Equal(Q.get(),1)) {
          break;
        }
      }
    }
    //<< 
    //<< IF YFIND'="" IF YA'="" DO
    if (mOp.NotEqual(m$.var("YFIND").get(),"")) {
      if (mOp.NotEqual(m$.var("YA").get(),"")) {
        //<< . SET YSA=YA
        mVar YSA = m$.var("YSA");
        YSA.set(m$.var("YA").get());
        //<< . IF $PIECE(YDATA,Y,22)'="" SET YSA="^"_YDATEI_"("_$PIECE(YSA,"(",2,99)   ;DT
        if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YDATA").get(),m$.var("Y").get(),22),"")) {
          YSA.set(mOp.Concat(mOp.Concat(mOp.Concat("^",m$.var("YDATEI").get()),"("),m$.Fnc.$piece(YSA.get(),"(",2,99)));
        }
        //<< . IF YUMLAU="" SET YFELD=$TRANSLATE($$^WWWSETL(YSA),LC,UC)
        if (mOp.Equal(m$.var("YUMLAU").get(),"")) {
          mVar YFELD = m$.var("YFELD");
          YFELD.set(m$.Fnc.$translate(m$.fnc$("WWWSETL.main",YSA.get()),m$.var("LC").get(),m$.var("UC").get()));
        }
        //<< . IF YUMLAU'="" SET YFELD=$$^WWWUMLAU($$^WWWSETL(YSA),1)
        if (mOp.NotEqual(m$.var("YUMLAU").get(),"")) {
          mVar YFELD = m$.var("YFELD");
          YFELD.set(m$.fnc$("WWWUMLAU.main",m$.fnc$("WWWSETL.main",YSA.get()),1));
        }
        //<< . FOR YI=1:1:$LENGTH(YFELD,Y) IF $PIECE(YFIND,Y,YI)'="" IF $PIECE(YFELD,Y,YI)'="" DO
        mVar YI = m$.var("YI");
        for (YI.set(1);(mOp.LessOrEqual(YI.get(),m$.Fnc.$length(m$.var("YFELD").get(),m$.var("Y").get())));YI.set(mOp.Add(YI.get(),1))) {
          if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YFIND").get(),m$.var("Y").get(),YI.get()),"")) {
            if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YFELD").get(),m$.var("Y").get(),YI.get()),"")) {
              //<< . . IF YUMLAU=""  IF '$FIND($TRANSLATE($PIECE(YFELD,Y,YI),LC,UC),$PIECE(YFIND,Y,YI)) KILL ^WWWSOR(YUSER,"KEY",YMAL,YKEY)
              if (mOp.Equal(m$.var("YUMLAU").get(),"")) {
                if (mOp.Not(m$.Fnc.$find(m$.Fnc.$translate(m$.Fnc.$piece(m$.var("YFELD").get(),m$.var("Y").get(),YI.get()),m$.var("LC").get(),m$.var("UC").get()),m$.Fnc.$piece(m$.var("YFIND").get(),m$.var("Y").get(),YI.get())))) {
                  m$.var("^WWWSOR",m$.var("YUSER").get(),"KEY",YMAL.get(),YKEY.get()).kill();
                }
              }
              //<< . . IF YUMLAU'="" IF '$FIND($$^WWWUMLAU($PIECE(YFELD,Y,YI),1),$PIECE(YFIND,Y,YI))    KILL ^WWWSOR(YUSER,"KEY",YMAL,YKEY)
              if (mOp.NotEqual(m$.var("YUMLAU").get(),"")) {
                if (mOp.Not(m$.Fnc.$find(m$.fnc$("WWWUMLAU.main",m$.Fnc.$piece(m$.var("YFELD").get(),m$.var("Y").get(),YI.get()),1),m$.Fnc.$piece(m$.var("YFIND").get(),m$.var("Y").get(),YI.get())))) {
                  m$.var("^WWWSOR",m$.var("YUSER").get(),"KEY",YMAL.get(),YKEY.get()).kill();
                }
              }
            }
          }
        }
      }
    }
    //<< 
    //<< QUIT
    return null;
  }

  //<< 
  //<< NEXT
  public void NEXT() {
    //<< ;-------------------------------------------------------------------------------
    //<< ;   NACHSTER DATENSATZ ;data record
    //<< ;
    //<< ; History :
    //<< ; 02-Oct-2007   shobby  SRBR014726: Support VAR filtering of records.  (OnFilter)
    //<< ; 02-Aug-2007   GRF     SR15571: Revert previous SR15571 changes to 03-May-2007
    //<< ;                       copy from source logging for build.
    //<< ; 31-Jul-2007   GRF     SR15571: Need to set a bypass boolean to ensure
    //<< ;                       only execute required code where dot-syntax QUITs have
    //<< ;                       been replaced.
    //<< ; 12-Jul-2007   RPW     SR15571: Rewrite into brace syntax
    //<< ;-------------------------------------------------------------------------------
    //<< NEW YQ,strKey
    mVar YQ = m$.var("YQ");
    mVar strKey = m$.var("strKey");
    m$.newVar(YQ,strKey);
    //<< 
    //<< FOR  DO  QUIT:YA=""  QUIT:YQ=1
    for (;true;) {
      do {
        //<< . SET YQ=1
        YQ.set(1);
        //<< . SET YA(9)=YA(9)+1
        mVar YA = m$.var("YA");
        YA.var(9).set(mOp.Add(m$.var("YA").var(9).get(),1));
        //<< . SET YA(2)=" "
        YA.var(2).set(" ");
        //<< . SET YA=$QUERY(@YA,YSRI)
        YA.set(m$.Fnc.$query(m$.indirectVar(YA.get()),m$.var("YSRI").get()));
        //<< . IF YA="" QUIT
        if (mOp.Equal(YA.get(),"")) {
          break;
        }
        //<< . ;
        //<< . SET YYA=""
        mVar YYA = m$.var("YYA");
        YYA.set("");
        //<< . SET YSA=YA
        mVar YSA = m$.var("YSA");
        YSA.set(YA.get());
        //<< . IF $PIECE(YDATA,Y,22)'="" SET YSA="^"_YDATEI_"("_$PIECE(YSA,"(",2,99)   ;DT
        if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YDATA").get(),m$.var("Y").get(),22),"")) {
          YSA.set(mOp.Concat(mOp.Concat(mOp.Concat("^",m$.var("YDATEI").get()),"("),m$.Fnc.$piece(YSA.get(),"(",2,99)));
        }
        //<< . IF YSA'="" SET YYA=$$^WWWSETL(YSA)
        if (mOp.NotEqual(YSA.get(),"")) {
          YYA.set(m$.fnc$("WWWSETL.main",YSA.get()));
        }
        //<< . ;IF +$GET(YAUSW1)'=0 IF YWILD="" I $E(YAUSW1)'="." IF YA'="" IF '$FIND($TRANSLATE($$^WWWUMLAU(YA),""""),$TRANSLATE(","_$EXTRACT(YAUSW1,1,99),"""")) SET YQ=0 QUIT
        //<< . IF YUMLAU=""  IF YWILD'="" IF $EXTRACT(YWILD)'="|" IF YA'="" IF '$FIND($TRANSLATE(YA_" "_YYA,LC,UC),YWILD) SET YQ=0 QUIT
        if (mOp.Equal(m$.var("YUMLAU").get(),"")) {
          if (mOp.NotEqual(m$.var("YWILD").get(),"")) {
            if (mOp.NotEqual(m$.Fnc.$extract(m$.var("YWILD").get()),"|")) {
              if (mOp.NotEqual(YA.get(),"")) {
                if (mOp.Not(m$.Fnc.$find(m$.Fnc.$translate(mOp.Concat(mOp.Concat(YA.get()," "),YYA.get()),m$.var("LC").get(),m$.var("UC").get()),m$.var("YWILD").get()))) {
                  YQ.set(0);
                  break;
                }
              }
            }
          }
        }
        //<< . IF YUMLAU'="" IF YWILD'="" IF $EXTRACT(YWILD)'="|" IF YA'="" IF '$FIND($$^WWWUMLAU(YA_" "_YYA,1),YWILD)    SET YQ=0 QUIT
        if (mOp.NotEqual(m$.var("YUMLAU").get(),"")) {
          if (mOp.NotEqual(m$.var("YWILD").get(),"")) {
            if (mOp.NotEqual(m$.Fnc.$extract(m$.var("YWILD").get()),"|")) {
              if (mOp.NotEqual(YA.get(),"")) {
                if (mOp.Not(m$.Fnc.$find(m$.fnc$("WWWUMLAU.main",mOp.Concat(mOp.Concat(YA.get()," "),YYA.get()),1),m$.var("YWILD").get()))) {
                  YQ.set(0);
                  break;
                }
              }
            }
          }
        }
        //<< . ;
        //<< . ;BR014726 VVVV
        //<< . set strKey=$piece(YA,$$$COMMA,2,$length(YA,$$$COMMA)-1)
        strKey.set(m$.Fnc.$piece(YA.get(),include.COMSYSString.$$$COMMA(m$),2,mOp.Subtract(m$.Fnc.$length(YA.get(),include.COMSYSString.$$$COMMA(m$)),1)));
        //<< . if strKey="" set YQ=0 quit        ; Bad data which doesn't have the ,1 as the last subscript will confuse things here without this test.
        if (mOp.Equal(strKey.get(),"")) {
          YQ.set(0);
          break;
        }
        //<< . ;Check this against YAUSW because if they are the same then the current
        //<< . ;record is being tested.  We don't want to exclude it if it has already been shown in readonly mode because it failed the filter
        //<< . ;test previously.  Removing this test will mean the filter will skip the first valid record when navigating to the next record.
        //<< . if (strKey=$get(YAUSW)) set YQ=1 quit
        if ((mOp.Equal(strKey.get(),m$.Fnc.$get(m$.var("YAUSW"))))) {
          YQ.set(1);
          break;
        }
        //<< . if '$$OnFilter(strKey,YYA) set YQ=0 QUIT
        if (mOp.Not(m$.fnc$("OnFilter",strKey.get(),YYA.get()))) {
          YQ.set(0);
          break;
        }
        //<< . ; BR014726 ^^^
        //<< . ;
        //<< . IF YWILD'="" IF $EXTRACT(YWILD)="|" IF YA'="" IF '$FIND($TRANSLATE($$^WWWUMLAU(YA),""""),$TRANSLATE(","_$EXTRACT(YWILD,2,99),"""")) SET YA=""
        if (mOp.NotEqual(m$.var("YWILD").get(),"")) {
          if (mOp.Equal(m$.Fnc.$extract(m$.var("YWILD").get()),"|")) {
            if (mOp.NotEqual(YA.get(),"")) {
              if (mOp.Not(m$.Fnc.$find(m$.Fnc.$translate(m$.fnc$("WWWUMLAU.main",YA.get()),"\""),m$.Fnc.$translate(mOp.Concat(",",m$.Fnc.$extract(m$.var("YWILD").get(),2,99)),"\"")))) {
                YA.set("");
              }
            }
          }
        }
        //<< . IF '$FIND($TRANSLATE(YA,""""),$TRANSLATE(YA(1),"""")) SET YA=""
        if (mOp.Not(m$.Fnc.$find(m$.Fnc.$translate(YA.get(),"\""),m$.Fnc.$translate(YA.var(1).get(),"\"")))) {
          YA.set("");
        }
      } while (false);
      if (mOp.Equal(m$.var("YA").get(),"")) {
        break;
      }
      if (mOp.Equal(YQ.get(),1)) {
        break;
      }
    }
    //<< 
    //<< QUIT
    return;
  }

  //<< 
  //<< OnFilter(YKEY="",YFELD="",&pblnCheck=$$$YES)
  public Object OnFilter(Object ... _p) {
    mVar YKEY = m$.newVarRef("YKEY",(((_p!=null)&&(_p.length>=1))?_p[0]:null),"");
    mVar YFELD = m$.newVarRef("YFELD",(((_p!=null)&&(_p.length>=2))?_p[1]:null),"");
    mVar pblnCheck = m$.newVarRef("pblnCheck",(((_p!=null)&&(_p.length>=3))?_p[2]:null),include.COMSYS.$$$YES(m$));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Call out to OnFilter core or VAR routines so the data displayed is restricted.
    //<< ; This can be used where the same form is required to show subsets of the stored
    //<< ; data records
    //<< ;
    //<< ; Inputs:
    //<< ;       YKEY:   Key of the record to be displayed.
    //<< ;       YFELD:  Data record.
    //<< ;       (Note parameters YKEY and YFELD are used to avoid confusion in the WWW001Hook
    //<< ;           and WWW001VARHooks records where these are specified as parameters)
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 22-Jan-2008   shobby  SRBR014887: Hooks run on the class. Need to convert YFORM to YDATEI
    //<< ; 24-Oct-2007   shobby  SRBR014726: YFORM mispelled
    //<< ; 09-Oct-2007   shobby  SRBR014744: Speed up.  If no call outs found don't retry. (Used by COMViewFilter)
    //<< ; 04-Oct-2007   shobby  SRBR014726: Make sure some variables are defined.
    //<< ; 02-Oct-2007   shobby  SRBR014726: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new strStatus,YPARA,YDATEI,objWWW120
    mVar strStatus = m$.var("strStatus");
    mVar YPARA = m$.var("YPARA");
    mVar YDATEI = m$.var("YDATEI");
    mVar objWWW120 = m$.var("objWWW120");
    m$.newVar(strStatus,YPARA,YDATEI,objWWW120);
    //<< 
    //<< set strStatus = $$$OK
    strStatus.set(include.COMSYS.$$$OK(m$));
    //<< if ($get(YUCI)'="") && ($get(YUSER)'="") && ($get(YFORM)'="") {
    if ((mOp.NotEqual(m$.Fnc.$get(m$.var("YUCI")),"")) && (mOp.NotEqual(m$.Fnc.$get(m$.var("YUSER")),"")) && (mOp.NotEqual(m$.Fnc.$get(m$.var("YFORM")),""))) {
      //<< set YPARA     = $get(^CacheTempForm(YUCI,YUSER,YFORM,"YPARA"))
      YPARA.set(m$.Fnc.$get(m$.var("^CacheTempForm",m$.var("YUCI").get(),m$.var("YUSER").get(),m$.var("YFORM").get(),"YPARA")));
      //<< set objWWW120 = $get(^WWW120(0,YFORM,1))                        ;SRBR014887
      objWWW120.set(m$.Fnc.$get(m$.var("^WWW120",0,m$.var("YFORM").get(),1)));
      //<< set YDATEI    = $$$WWW120ClassUsedInForm(objWWW120)             ;SRBR014887
      YDATEI.set(include.WWWConst.$$$WWW120ClassUsedInForm(m$,objWWW120));
      //<< 
      //<< if (YKEY'="") && (YDATEI'="") {
      if ((mOp.NotEqual(YKEY.get(),"")) && (mOp.NotEqual(YDATEI.get(),""))) {
        //<< set pblnCheck=$$$NO
        pblnCheck.set(include.COMSYS.$$$NO(m$));
        //<< if $data(^WWW001Hook(0,YDATEI,$$$EnumWWWEVENTTYPEOnFilter)) {
        if (mOp.Logical(m$.Fnc.$data(m$.var("^WWW001Hook",0,YDATEI.get(),include.WWWConst.$$$EnumWWWEVENTTYPEOnFilter(m$))))) {
          //<< xecute "set strStatus="_$piece(^WWW001Hook(0,YDATEI,$$$EnumWWWEVENTTYPEOnFilter,1),Y,1)
          m$.Cmd.Xecute(mOp.Concat("set strStatus=",m$.Fnc.$piece(m$.var("^WWW001Hook",0,YDATEI.get(),include.WWWConst.$$$EnumWWWEVENTTYPEOnFilter(m$),1).get(),m$.var("Y").get(),1)));
          //<< set pblnCheck=$$$YES
          pblnCheck.set(include.COMSYS.$$$YES(m$));
        }
        //<< }
        //<< 
        //<< if $$$ISOK(strStatus) {
        if (mOp.Logical(include.COMSYS.$$$ISOK(m$,strStatus))) {
          //<< if $data(^WWW001VARHooks(0,YDATEI,$$$EnumWWWEVENTTYPEOnFilter)) {
          if (mOp.Logical(m$.Fnc.$data(m$.var("^WWW001VARHooks",0,YDATEI.get(),include.WWWConst.$$$EnumWWWEVENTTYPEOnFilter(m$))))) {
            //<< xecute "set strStatus="_$piece(^WWW001VARHooks(0,YDATEI,$$$EnumWWWEVENTTYPEOnFilter,1),Y,1)
            m$.Cmd.Xecute(mOp.Concat("set strStatus=",m$.Fnc.$piece(m$.var("^WWW001VARHooks",0,YDATEI.get(),include.WWWConst.$$$EnumWWWEVENTTYPEOnFilter(m$),1).get(),m$.var("Y").get(),1)));
            //<< set pblnCheck=$$$YES
            pblnCheck.set(include.COMSYS.$$$YES(m$));
          }
        }
      }
    }
    //<< }
    //<< }
    //<< }
    //<< }
    //<< quit strStatus
    return strStatus.get();
  }

  //<< 
  //<< 
  //<< NEXTS
  public void NEXTS() {
    //<< ;-------------------------------------------------------------------------------
    //<< ;   NACHSTER DATENSATZ IN SORTFOLGE ;data record within
    //<< ;
    //<< ;   The blnProcess flag behaves similarly to strStatus elsewhere.  If set to $$$NO
    //<< ;   it indicates that subsequent processing in the FOR loop is not to be executed.
    //<< ;   Control resumes at the QUIT command at the bottom of the FOR loop.
    //<< ;
    //<< ;
    //<< ; History :
    //<< ; 02-Aug-2007   GRF     SR15571: Revert previous SR15571 changes to 03-May-2007
    //<< ;                       copy from source logging for build.
    //<< ; 31-Jul-2007   GRF     SR15571: Need to convert quits to a bypass boolean to ensure
    //<< ;                       only end the FOR loop when either test is met.  Early quits
    //<< ;                       would have resulted in the FOR loop stopping when blnQuit
    //<< ;                       was set to $$$NO; don't use $reverse.
    //<< ; 12-Jul-2007   RPW     SR15571: Rewrite into brace syntax
    //<< ;-------------------------------------------------------------------------------
    //<< NEW YQ
    mVar YQ = m$.var("YQ");
    m$.newVar(YQ);
    //<< 
    //<< FOR  DO  QUIT:YA=""  QUIT:YQ=1
    for (;true;) {
      do {
        //<< . SET YQ=1
        YQ.set(1);
        //<< . SET YA(9)=YA(9)+1
        mVar YA = m$.var("YA");
        YA.var(9).set(mOp.Add(m$.var("YA").var(9).get(),1));
        //<< . SET YA(2)=$QUERY(@YA(2),YSRI)
        YA.var(2).set(m$.Fnc.$query(m$.indirectVar(YA.var(2).get()),m$.var("YSRI").get()));
        //<< . ;
        //<< . IF YWILD'="" IF $EXTRACT(YWILD)="|" IF +$EXTRACT(YWILD,2,99)'=0 IF YA(2)'="" IF '$FIND($TRANSLATE(YA(2),""""),$TRANSLATE(","_$EXTRACT(YWILD,2,99),"""")) SET YQ=0  QUIT  ;GOTO NEXTS  ;NICHT ENTHALTEN ;Not include
        if (mOp.NotEqual(m$.var("YWILD").get(),"")) {
          if (mOp.Equal(m$.Fnc.$extract(m$.var("YWILD").get()),"|")) {
            if (mOp.NotEqual(mOp.Positive(m$.Fnc.$extract(m$.var("YWILD").get(),2,99)),0)) {
              if (mOp.NotEqual(YA.var(2).get(),"")) {
                if (mOp.Not(m$.Fnc.$find(m$.Fnc.$translate(YA.var(2).get(),"\""),m$.Fnc.$translate(mOp.Concat(",",m$.Fnc.$extract(m$.var("YWILD").get(),2,99)),"\"")))) {
                  YQ.set(0);
                  break;
                }
              }
            }
          }
        }
        //<< . IF YWILD'="" IF $EXTRACT(YWILD)="|" IF +$EXTRACT(YWILD,2,99)=0  IF YA(2)'="" IF '$FIND($TRANSLATE(YA(2),""""),$TRANSLATE(","_$EXTRACT(YWILD,2,99),"""")) SET YA="" QUIT  ;NICHT ENTHALTEN ;Not include
        if (mOp.NotEqual(m$.var("YWILD").get(),"")) {
          if (mOp.Equal(m$.Fnc.$extract(m$.var("YWILD").get()),"|")) {
            if (mOp.Equal(mOp.Positive(m$.Fnc.$extract(m$.var("YWILD").get(),2,99)),0)) {
              if (mOp.NotEqual(YA.var(2).get(),"")) {
                if (mOp.Not(m$.Fnc.$find(m$.Fnc.$translate(YA.var(2).get(),"\""),m$.Fnc.$translate(mOp.Concat(",",m$.Fnc.$extract(m$.var("YWILD").get(),2,99)),"\"")))) {
                  YA.set("");
                  break;
                }
              }
            }
          }
        }
        //<< . IF YSAUSW'="" IF YA(2)'=""     IF '$FIND($TRANSLATE(YA(2),""""),$TRANSLATE(","_YSAUSW,""""))            SET YA="" QUIT  ;NICHT ENTHALTEN ;Not include
        if (mOp.NotEqual(m$.var("YSAUSW").get(),"")) {
          if (mOp.NotEqual(YA.var(2).get(),"")) {
            if (mOp.Not(m$.Fnc.$find(m$.Fnc.$translate(YA.var(2).get(),"\""),m$.Fnc.$translate(mOp.Concat(",",m$.var("YSAUSW").get()),"\"")))) {
              YA.set("");
              break;
            }
          }
        }
        //<< . IF YSAUSW'="" IF +YSORT=YSAUSW IF '$FIND($TRANSLATE(YA(2),""""),$TRANSLATE(","_+YSORT_","_YSAUSW,"""")) SET YA="" QUIT  ;NICHT ENTHALTEN  ;FIS;10.12.02 ;Not include
        if (mOp.NotEqual(m$.var("YSAUSW").get(),"")) {
          if (mOp.Equal(mOp.Positive(m$.var("YSORT").get()),m$.var("YSAUSW").get())) {
            if (mOp.Not(m$.Fnc.$find(m$.Fnc.$translate(YA.var(2).get(),"\""),m$.Fnc.$translate(mOp.Concat(mOp.Concat(mOp.Concat(",",mOp.Positive(m$.var("YSORT").get())),","),m$.var("YSAUSW").get()),"\"")))) {
              YA.set("");
              break;
            }
          }
        }
        //<< . ;
        //<< . ;IF YFKEY'="" IF YA(2)'="" IF '$FIND($TRANSLATE(YA(2),""""),$TRANSLATE(","_YFKEY_",","""")) SET YQ=0 QUIT  ;GOTO NEXTS1  ;NICHT IM NEXTKEY ;Not
        //<< . IF YFKEY'="" IF YA(2)'="" IF '$FIND(","_$PIECE($TRANSLATE(YA(2),""""),","_+YSORT_",",2,99),$TRANSLATE(","_YFKEY_",","""")) SET YQ=0 QUIT  ;tybd;26515;4,11,2004;GOTO NEXTS1  ;NICHT IM NEXTKEY ;Not
        if (mOp.NotEqual(m$.var("YFKEY").get(),"")) {
          if (mOp.NotEqual(YA.var(2).get(),"")) {
            if (mOp.Not(m$.Fnc.$find(mOp.Concat(",",m$.Fnc.$piece(m$.Fnc.$translate(YA.var(2).get(),"\""),mOp.Concat(mOp.Concat(",",mOp.Positive(m$.var("YSORT").get())),","),2,99)),m$.Fnc.$translate(mOp.Concat(mOp.Concat(",",m$.var("YFKEY").get()),","),"\"")))) {
              YQ.set(0);
              break;
            }
          }
        }
        //<< . ;
        //<< . IF '$FIND($TRANSLATE(YA(2),""""),$TRANSLATE(YA(11),"""")) SET YA="" QUIT   ;ENDE ;termination
        if (mOp.Not(m$.Fnc.$find(m$.Fnc.$translate(YA.var(2).get(),"\""),m$.Fnc.$translate(YA.var(11).get(),"\"")))) {
          YA.set("");
          break;
        }
        //<< . IF YA(2)="" SET YA="" QUIT
        if (mOp.Equal(YA.var(2).get(),"")) {
          YA.set("");
          break;
        }
        //<< . ;
        //<< . SET YMAXSKEY=$LENGTH(YA(2),",")
        mVar YMAXSKEY = m$.var("YMAXSKEY");
        YMAXSKEY.set(m$.Fnc.$length(YA.var(2).get(),","));
        //<< . ;SET YPR=$PIECE(YA(2),")",1)
        //<< . SET YPR=$REVERSE($EXTRACT($REVERSE(YA(2)),2,999))  ;TYBD;WENN IM KEY "()" ENTHALTEN
        mVar YPR = m$.var("YPR");
        YPR.set(m$.Fnc.$reverse(m$.Fnc.$extract(m$.Fnc.$reverse(YA.var(2).get()),2,999)));
        //<< . SET YA=YA(3)
        YA.set(YA.var(3).get());
        //<< . FOR YI=(YMAXSKEY-YMAXKEY+1):1:YMAXSKEY DO
        mVar YI = m$.var("YI");
        for (YI.set((mOp.Add(mOp.Subtract(YMAXSKEY.get(),m$.var("YMAXKEY").get()),1)));(mOp.LessOrEqual(YI.get(),YMAXSKEY.get()));YI.set(mOp.Add(YI.get(),1))) {
          //<< . . IF $EXTRACT(YA,$LENGTH(YA))'="(" SET:$EXTRACT(YA,$LENGTH(YA))'="," YA=YA_","
          if (mOp.NotEqual(m$.Fnc.$extract(YA.get(),m$.Fnc.$length(YA.get())),"(")) {
            if (mOp.NotEqual(m$.Fnc.$extract(YA.get(),m$.Fnc.$length(YA.get())),",")) {
              YA.set(mOp.Concat(YA.get(),","));
            }
          }
          //<< . . SET YA=YA_$PIECE(YPR,",",YI) ;TEST ;I $F($PIECE(YPR,",",YI),")")!($F($PIECE(YPR,",",YI),"("))!($F($PIECE(YPR,",",YI),"%")) I YBED="TYBD" W YA(2)," "_$PIECE(YPR,",",YI)_"<BR>" K ^INKUNDE(0,$PIECE(YPR,",",YI),1)
          YA.set(mOp.Concat(YA.get(),m$.Fnc.$piece(YPR.get(),",",YI.get())));
        }
        //<< . ;
        //<< . SET YA=YA_")"
        YA.set(mOp.Concat(YA.get(),")"));
        //<< . ;
        //<< . IF $FIND(YA,"(,") SET YA=$PIECE(YA,"(,",1)_"("_$PIECE(YA,"(,",2,99)
        if (mOp.Logical(m$.Fnc.$find(YA.get(),"(,"))) {
          YA.set(mOp.Concat(mOp.Concat(m$.Fnc.$piece(YA.get(),"(,",1),"("),m$.Fnc.$piece(YA.get(),"(,",2,99)));
        }
        //<< . IF $FIND(YA,",)") SET YA=$PIECE(YA,",)",1)_")"
        if (mOp.Logical(m$.Fnc.$find(YA.get(),",)"))) {
          YA.set(mOp.Concat(m$.Fnc.$piece(YA.get(),",)",1),")"));
        }
        //<< . ;
        //<< . ;
        //<< . IF $PIECE(YDATA,Y,8)'=4 SET YA=$QUERY(@YA)
        if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YDATA").get(),m$.var("Y").get(),8),4)) {
          YA.set(m$.Fnc.$query(m$.indirectVar(YA.get())));
        }
        //<< . ;SET YA=$QUERY(@YA)  ;ORIGINALSATZ ;table-mat
        //<< . SET YYA=""
        mVar YYA = m$.var("YYA");
        YYA.set("");
        //<< . SET YSA=YA
        mVar YSA = m$.var("YSA");
        YSA.set(YA.get());
        //<< . IF $PIECE(YDATA,Y,22)'="" SET YSA="^"_YDATEI_"("_$PIECE(YSA,"(",2,99)   ;DT
        if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YDATA").get(),m$.var("Y").get(),22),"")) {
          YSA.set(mOp.Concat(mOp.Concat(mOp.Concat("^",m$.var("YDATEI").get()),"("),m$.Fnc.$piece(YSA.get(),"(",2,99)));
        }
        //<< . IF YSA'="" SET YYA=$$^WWWSETL(YSA)
        if (mOp.NotEqual(YSA.get(),"")) {
          YYA.set(m$.fnc$("WWWSETL.main",YSA.get()));
        }
        //<< . IF YUMLAU=""  IF YWILD'="" IF $EXTRACT(YWILD)'="|" IF YA'="" IF '$FIND($TRANSLATE(YA_" "_YYA,LC,UC),YWILD) SET YQ=0 QUIT  ;NICHT ENTHALTEN ;Not include
        if (mOp.Equal(m$.var("YUMLAU").get(),"")) {
          if (mOp.NotEqual(m$.var("YWILD").get(),"")) {
            if (mOp.NotEqual(m$.Fnc.$extract(m$.var("YWILD").get()),"|")) {
              if (mOp.NotEqual(YA.get(),"")) {
                if (mOp.Not(m$.Fnc.$find(m$.Fnc.$translate(mOp.Concat(mOp.Concat(YA.get()," "),YYA.get()),m$.var("LC").get(),m$.var("UC").get()),m$.var("YWILD").get()))) {
                  YQ.set(0);
                  break;
                }
              }
            }
          }
        }
        //<< . IF YUMLAU'="" IF YWILD'="" IF $EXTRACT(YWILD)'="|" IF YA'="" IF '$FIND($$^WWWUMLAU(YA_" "_YYA,1),YWILD)    SET YQ=0 QUIT  ;NICHT ENTHALTEN ;Not include
        if (mOp.NotEqual(m$.var("YUMLAU").get(),"")) {
          if (mOp.NotEqual(m$.var("YWILD").get(),"")) {
            if (mOp.NotEqual(m$.Fnc.$extract(m$.var("YWILD").get()),"|")) {
              if (mOp.NotEqual(YA.get(),"")) {
                if (mOp.Not(m$.Fnc.$find(m$.fnc$("WWWUMLAU.main",mOp.Concat(mOp.Concat(YA.get()," "),YYA.get()),1),m$.var("YWILD").get()))) {
                  YQ.set(0);
                  break;
                }
              }
            }
          }
        }
        //<< . IF YWILD="" IF YFKEY=""  IF '$FIND($TRANSLATE(YA,""""),$TRANSLATE(YA(1),""""))                             SET YQ=0 QUIT
        if (mOp.Equal(m$.var("YWILD").get(),"")) {
          if (mOp.Equal(m$.var("YFKEY").get(),"")) {
            if (mOp.Not(m$.Fnc.$find(m$.Fnc.$translate(YA.get(),"\""),m$.Fnc.$translate(YA.var(1).get(),"\"")))) {
              YQ.set(0);
              break;
            }
          }
        }
        //<< . IF YWILD="" IF YFKEY'="" IF '$FIND($TRANSLATE(YA,""""),$TRANSLATE(","_YFKEY,""""))                         SET YQ=0 QUIT
        if (mOp.Equal(m$.var("YWILD").get(),"")) {
          if (mOp.NotEqual(m$.var("YFKEY").get(),"")) {
            if (mOp.Not(m$.Fnc.$find(m$.Fnc.$translate(YA.get(),"\""),m$.Fnc.$translate(mOp.Concat(",",m$.var("YFKEY").get()),"\"")))) {
              YQ.set(0);
              break;
            }
          }
        }
      } while (false);
      if (mOp.Equal(m$.var("YA").get(),"")) {
        break;
      }
      if (mOp.Equal(YQ.get(),1)) {
        break;
      }
    }
    //<< 
    //<< QUIT
    return;
  }

//<< 
//<< 
}
