//*****************************************************************************
//** TASC - ALPHALINC - MAC WWWDATE
//** Innovatium Systems - Code Converter - v1.27
//** 2014-05-22 00:15:18
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

public class WWWDATE extends mClass {

  //<< WWWDATE(YA="",SPRACHE1)
  public Object main(Object ... _p) {
    mVar YA = m$.newVarRef("YA",(((_p!=null)&&(_p.length>=1))?_p[0]:null),"");
    mVar SPRACHE1 = m$.newVarRef("SPRACHE1",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    return _WWWDATE(YA,SPRACHE1);
  }

  public Object _WWWDATE(Object ... _p) {
    mVar YA = m$.newVarRef("YA",(((_p!=null)&&(_p.length>=1))?_p[0]:null),"");
    mVar SPRACHE1 = m$.newVarRef("SPRACHE1",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Description of Function :
    //<< ;       ANZEIGEN DATUM AUS $H
    //<< ;
    //<< ; Inputs :
    //<< ;   YA        = Input date $H FORMAT
    //<< ;               "."         equates to today
    //<< ;               "A.0000B"   equates to date A with " (B)" suffix
    //<< ;               "A.1"       returns week - NOTE: now obscured by (B) processing above
    //<< ;
    //<< ;   SPRACHE1  = FORMAT DER SPRACHE ;the Language - will affect how presented (D/M/Y cf M.D.Y etc.)
    //<< ;
    //<< ; ByRef :
    //<< ;   Y,YM,YBED   System variables
    //<< ;   SPRACHE     System language (as a default)
    //<< ;
    //<< ; Returns :
    //<< ;
    //<< ;
    //<< ; History :
    //<< ; 14-May-2009   GRF     SR16522: If called from SQL YBED is not available - set
    //<< ;                           initial environment
    //<< ; 07-May-2009   GRF     SR16522: use new date functionality
    //<< ; 20-Aug-2007   GM      SR13729: Change "FELDFORMAT" parameter to $$GetFormat^INPARA()
    //<< ; 22-May-2006   GRF     Doco
    //<< ; 24-Mar-2006   JW      SR14422: Allow counter on date
    //<< ; 09-Jun-2005   Steve S Default date to null string (avoids UNDEFINED error)
    //<< ; 07-Apr-2005   RobertW SR11836 : Change limits
    //<< ; 30.Jul.1997   DT      Created
    //<< ;-------------------------------------------------------------------------------
    //<< if '$data(YBED) do ^WWWVAR                      ; SR16522
    if (mOp.Not(m$.Fnc.$data(m$.var("YBED")))) {
      m$.Cmd.Do("WWWVAR.main");
    }
    //<< quit $$IntToLit(YA,$get(SPRACHE1,SPRACHE))      ; SR16522
    return m$.fnc$("IntToLit",YA.get(),m$.Fnc.$get(SPRACHE1,m$.var("SPRACHE").get()));
  }

  //<< 
  //<< /*
  //<< ;vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv DISABLED BLOCK SR16522
  //<< 
  //<< NEW (YM,Y,YA,YBED,SPRACHE,SPRACHE1)     ; FIXME : Exclusive new is very inefficient.
  //<< 
  //<< ;+++++++++++++++++++++++++++++++++++++++ YA RESOLUTION
  //<< 
  //<< IF $GET(YA)="." SET YA=+$HOROLOG
  //<< 
  //<< //SR14422 - display counter A.0000B as A (B)
  //<< set YB=""
  //<< if $find(YA,".") {  // FIXME - possible conflict with display of week.
  //<< set YB = " ("_+$piece(YA,".",2)_")"
  //<< set YA = $piece(YA,".",1)
  //<< }
  //<< 
  //<< ; 28-Apr-2005 JW  SR12241 All non-numbers need to be converted to blank
  //<< if '$isValidNum($piece(YA,",",1)) set YA="" QUIT YA
  //<< ;IF $GET(YA)="" QUIT YA            ; 07-Apr-2005 RobertW SR11836 Blank and Zero are different.
  //<< ;IF +$GET(YA)=0 SET YA="" QUIT YA  ; 07-Apr-2005 RobertW SR11836 Why limit this? 0 is valid
  //<< IF +$GET(YA)>131125 SET YA="" QUIT YA
  //<< IF $LENGTH(YA)=10 IF '$FIND(YA,$$$COMMA) QUIT YA
  //<< 
  //<< ;SET YA=$TR(YA," _!$%&/()=?`*+#.ABCDEFGHIJKLMNOPQRSTUVWXYZ")
  //<< SET YA=$TRANSLATE(YA," _!$%&/()=?`*+#ABCDEFGHIJKLMNOPQRSTUVWXYZ")
  //<< 
  //<< IF '$DATA(Y) DO ^WWWVORG
  //<< if $get(YBED)="" set YBED="UNKNOWN"
  //<< IF $PIECE(YA,".",2)="1" SET YA=+$PIECE(YA,".",1) QUIT $$^WWWWEEK(YA,1)  ;WOCHENAUSGABE
  //<< 
  //<< ;IF $LENGTH(+YA)<5 QUIT YA  ;KEINE TAGESZAHL ;no   ; 07-Apr-2005 RobertW SR11836 Why limit this? 5678 is a valid +$h value.
  //<< IF $LENGTH(+YA)>6 QUIT YA   ;KEINE TAGESZAHL ;no
  //<< 
  //<< SET YA=+YA
  //<< 
  //<< // FIXME: Is changing to positive sensible? A negative value is invalid.
  //<< IF YA<0 SET YA=-YA
  //<< 
  //<< ;+++++++++++++++++++++++++++++++++++++++ SPRACHE1 RESOLUTION
  //<< 
  //<< IF $GET(SPRACHE)="" SET SPRACHE=$$^WWWLANGU(YBED)
  //<< SET SPRACHE2=$GET(SPRACHE1)
  //<< IF SPRACHE2="" SET SPRACHE2=SPRACHE
  //<< 
  //<< ;+++++++++++++++++++++++++++++++++++++++ FORMAT RESOLUTION
  //<< 
  //<< ;SET TRENN="."
  //<< ;SET FORMAT="TT.MM.JJJJ"   ; (Tag/Day, Monat/Month, Jahr/Year)
  //<< 
  //<< ;IF $DATA(^WWW100(0,"FELDFORMAT",SPRACHE2,1,1)) SET FORMAT=$PIECE(^(1),Y,1) SET TRENN=$EXTRACT(FORMAT,3)
  //<< ;IF $DATA(^WWW101(0,"FELDFORMAT",SPRACHE2,1,1)) SET FORMAT=$PIECE(^(1),Y,1) SET TRENN=$EXTRACT(FORMAT,3)
  //<< 
  //<< SET FORMAT=$$GetFormat^INPARA(1,"TT.MM.JJJJ")  ;SR13729
  //<< SET TRENN=$EXTRACT(FORMAT,3)  ;SR13729
  //<< 
  //<< ;+++++++++++++++++++++++++++++++++++++++ FORMAT APPLICATION
  //<< ; $zdate($h,8) = YYYYMMDD
  //<< 
  //<< ;  T...  :  DD/MM/YYYY
  //<< ;  D...  :  DD/MM/YYYY
  //<< ;  other :  MM/DD/YYYY
  //<< IF TRENN="/" DO
  //<< . IF $EXTRACT(FORMAT)="T" SET YA=$zdate($PIECE(+YA,".",1),8) SET YA=$EXTRACT(YA,7,8)_TRENN_$EXTRACT(YA,5,6)_TRENN_$EXTRACT(YA,1,4) QUIT
  //<< . IF $EXTRACT(FORMAT)="D" SET YA=$zdate($PIECE(+YA,".",1),8) SET YA=$EXTRACT(YA,7,8)_TRENN_$EXTRACT(YA,5,6)_TRENN_$EXTRACT(YA,1,4) QUIT
  //<< . SET YA=$zdate($PIECE(+YA,".",1),8)                         SET YA=$EXTRACT(YA,5,6)_TRENN_$EXTRACT(YA,7,8)_TRENN_$EXTRACT(YA,1,4)
  //<< 
  //<< ;  M...  :  MM*DD*YYYY   where * is TRENN character
  //<< ;  other :  DD*MM*YYYY
  //<< 
  //<< IF TRENN'="/" DO
  //<< . IF $EXTRACT(FORMAT)="M" SET YA=$zdate($PIECE(+YA,".",1),8) SET YA=$EXTRACT(YA,5,6)_TRENN_$EXTRACT(YA,7,8)_TRENN_$EXTRACT(YA,1,4) QUIT
  //<< . SET YA=$zdate($PIECE(+YA,".",1),8)                         SET YA=$EXTRACT(YA,7,8)_TRENN_$EXTRACT(YA,5,6)_TRENN_$EXTRACT(YA,1,4)
  //<< 
  //<< QUIT YA_YB  //SR14422
  //<< */
  //<< 
  //<< 
  //<< IntToLit(pstrIntDate="",pidLanguage="")
  public Object IntToLit(Object ... _p) {
    mVar pstrIntDate = m$.newVarRef("pstrIntDate",(((_p!=null)&&(_p.length>=1))?_p[0]:null),"");
    mVar pidLanguage = m$.newVarRef("pidLanguage",(((_p!=null)&&(_p.length>=2))?_p[1]:null),"");
    //<< ;-------------------------------------------------------------------------------
    //<< ; Description of Function :
    //<< ;       Convert horolg format to date string
    //<< ;       ANZEIGEN DATUM AUS $H
    //<< ;
    //<< ; Inputs :
    //<< ;   pstrIntDate = Input date internal Horolog FORMAT or some variations
    //<< ;               "."         equates to today
    //<< ;               "A.0000B"   equates to date A with " (B)" suffix
    //<< ;               "A.1"       returns week - NOTE: now obscured by (B) processing above
    //<< ;
    //<< ;   pidLanguage  = FORMAT DER SPRACHE ;the Language - will affect how presented (D/M/Y cf M.D.Y etc.)
    //<< ;
    //<< ; ByRef :
    //<< ;   Y,YM,YBED   System variables
    //<< ;   SPRACHE     System language (as a default)
    //<< ;
    //<< ; Returns :
    //<< ;
    //<< ;
    //<< ; History :
    //<< ; 07-May-2009   GRF     SR16522: only show counter for dates with one
    //<< ; 22-May-2006   GRF     Doco
    //<< ; 24-Mar-2006   JW      SR14422: Allow counter on date
    //<< ; 09-Jun-2005   Steve S Default date to null string (avoids UNDEFINED error)
    //<< ; 28-Apr-2005   JW      SR12241 All non-numbers need to be converted to blank
    //<< ; 07-Apr-2005   RPW     SR11836 : Change limits
    //<< ; 30.Jul.1997   DT      Created
    //<< ;-------------------------------------------------------------------------------
    //<< new blnWeek,idLocale,strCounter,strDelim,strFormat
    mVar blnWeek = m$.var("blnWeek");
    mVar idLocale = m$.var("idLocale");
    mVar strCounter = m$.var("strCounter");
    mVar strDelim = m$.var("strDelim");
    mVar strFormat = m$.var("strFormat");
    m$.newVar(blnWeek,idLocale,strCounter,strDelim,strFormat);
    //<< ;+++++++++++++++++++++++++++++++++++++++ pstrIntDate RESOLUTION
    //<< 
    //<< if pstrIntDate="." set pstrIntDate=+$horolog
    if (mOp.Equal(pstrIntDate.get(),".")) {
      pstrIntDate.set(mOp.Positive(m$.Fnc.$horolog()));
    }
    //<< 
    //<< ; Display counter A.0000B as A (B)   SR14422
    //<< ; but treat A.1 as week
    //<< set strCounter=""
    strCounter.set("");
    //<< if $find(pstrIntDate,".") {
    if (mOp.Logical(m$.Fnc.$find(pstrIntDate.get(),"."))) {
      //<< set strCounter  = $piece(pstrIntDate,".",2)
      strCounter.set(m$.Fnc.$piece(pstrIntDate.get(),".",2));
      //<< set pstrIntDate = $piece(pstrIntDate,".",1)
      pstrIntDate.set(m$.Fnc.$piece(pstrIntDate.get(),".",1));
    }
    //<< }
    //<< 
    //<< if strCounter=1 {
    if (mOp.Equal(strCounter.get(),1)) {
      //<< set blnWeek = $$$YES
      blnWeek.set(include.COMSYS.$$$YES(m$));
    }
    //<< 
    //<< } else {
    else {
      //<< set blnWeek = $$$NO
      blnWeek.set(include.COMSYS.$$$NO(m$));
      //<< if strCounter set strCounter = " ("_+strCounter_")"
      if (mOp.Logical(strCounter.get())) {
        strCounter.set(mOp.Concat(mOp.Concat(" (",mOp.Positive(strCounter.get())),")"));
      }
    }
    //<< }
    //<< 
    //<< if '$isValidNum($piece(pstrIntDate,$$$COMMA,1))  quit ""   ; All non-numbers need to be converted to blank   SR12241
    if (mOp.Not(m$.Fnc.$isvalidnum(m$.Fnc.$piece(pstrIntDate.get(),include.COMSYSString.$$$COMMA(m$),1)))) {
      return "";
    }
    //<< if $extract(pstrIntDate,1)="-"                   quit ""   ; Ditto negative values                           SR15525
    if (mOp.Equal(m$.Fnc.$extract(pstrIntDate.get(),1),"-")) {
      return "";
    }
    //<< if pstrIntDate>131125                            quit ""   ; Max date 03 Jan 2200
    if (mOp.Greater(pstrIntDate.get(),131125)) {
      return "";
    }
    //<< ;IF pstrIntDate=""                               QUIT ""   ; 07-Apr-2005 RobertW SR11836 Blank and Zero are different.
    //<< ;IF +pstrIntDate=0                               QUIT ""   ; 07-Apr-2005 RobertW SR11836 Why limit this? 0 is valid
    //<< IF $LENGTH(pstrIntDate)=10 IF '$FIND(pstrIntDate,$$$COMMA) QUIT pstrIntDate     ; FIXME : Won't be executed after Jan 2200 test
    if (mOp.Equal(m$.Fnc.$length(pstrIntDate.get()),10)) {
      if (mOp.Not(m$.Fnc.$find(pstrIntDate.get(),include.COMSYSString.$$$COMMA(m$)))) {
        return pstrIntDate.get();
      }
    }
    //<< 
    //<< SET pstrIntDate=$TRANSLATE(pstrIntDate," _!$%&/()=?`*+#ABCDEFGHIJKLMNOPQRSTUVWXYZ")
    pstrIntDate.set(m$.Fnc.$translate(pstrIntDate.get()," _!$%&/()=?`*+#ABCDEFGHIJKLMNOPQRSTUVWXYZ"));
    //<< ; FIXME - already rejected by isValidNum - only deals with post comma
    //<< 
    //<< IF '$DATA(Y) DO ^WWWVORG
    if (mOp.Not(m$.Fnc.$data(m$.var("Y")))) {
      m$.Cmd.Do("WWWVORG.main");
    }
    //<< if $get(YBED)="" set YBED="UNKNOWN"
    if (mOp.Equal(m$.Fnc.$get(m$.var("YBED")),"")) {
      mVar YBED = m$.var("YBED");
      YBED.set("UNKNOWN");
    }
    //<< 
    //<< set pstrIntDate = +pstrIntDate
    pstrIntDate.set(mOp.Positive(pstrIntDate.get()));
    //<< if blnWeek quit $$^WWWWEEK(pstrIntDate,1)  ;WOCHENAUSGABE
    if (mOp.Logical(blnWeek.get())) {
      return m$.fnc$("WWWWEEK.main",pstrIntDate.get(),1);
    }
    //<< IF $LENGTH(pstrIntDate)>6 QUIT pstrIntDate   ;KEINE TAGESZAHL   ; FIXME : already covered by Jan 2200 test
    if (mOp.Greater(m$.Fnc.$length(pstrIntDate.get()),6)) {
      return pstrIntDate.get();
    }
    //<< 
    //<< ;+++++++++++++++++++++++++++++++++++++++ SPRACHE1 RESOLUTION
    //<< 
    //<< IF $GET(SPRACHE)="" SET SPRACHE=$$^WWWLANGU(YBED)
    if (mOp.Equal(m$.Fnc.$get(m$.var("SPRACHE")),"")) {
      mVar SPRACHE = m$.var("SPRACHE");
      SPRACHE.set(m$.fnc$("WWWLANGU.main",m$.var("YBED").get()));
    }
    //<< SET idLocale = $GET(pidLanguage)
    idLocale.set(m$.Fnc.$get(pidLanguage));
    //<< IF idLocale="" SET idLocale=SPRACHE
    if (mOp.Equal(idLocale.get(),"")) {
      idLocale.set(m$.var("SPRACHE").get());
    }
    //<< 
    //<< ;+++++++++++++++++++++++++++++++++++++++ FORMAT RESOLUTION
    //<< 
    //<< do GetDateFormat^COMUtilLocale(.strFormat,.strDelim,idLocale)
    m$.Cmd.Do("COMUtilLocale.GetDateFormat",strFormat,strDelim,idLocale.get());
    //<< 
    //<< set numDateYMD = $zdate($piece(+pstrIntDate,".",1),8)           ; YYYYMMDD (strip counter "A.0000B")
    mVar numDateYMD = m$.var("numDateYMD");
    numDateYMD.set(m$.Fnc.$zdate(m$.Fnc.$piece(mOp.Positive(pstrIntDate.get()),".",1),8));
    //<< 
    //<< if $extract(strFormat,1) = "D" {
    if (mOp.Equal(m$.Fnc.$extract(strFormat.get(),1),"D")) {
      //<< set strDate = $extract(numDateYMD,7,8)_strDelim_$extract(numDateYMD,5,6)_strDelim_$extract(numDateYMD,1,4)
      mVar strDate = m$.var("strDate");
      strDate.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(m$.Fnc.$extract(numDateYMD.get(),7,8),strDelim.get()),m$.Fnc.$extract(numDateYMD.get(),5,6)),strDelim.get()),m$.Fnc.$extract(numDateYMD.get(),1,4)));
    }
    //<< 
    //<< } elseif $extract(strFormat,1) = "M" {
    else if (mOp.Equal(m$.Fnc.$extract(strFormat.get(),1),"M")) {
      //<< set strDate = $extract(numDateYMD,5,6)_strDelim_$extract(numDateYMD,7,8)_strDelim_$extract(numDateYMD,1,4)
      mVar strDate = m$.var("strDate");
      strDate.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(m$.Fnc.$extract(numDateYMD.get(),5,6),strDelim.get()),m$.Fnc.$extract(numDateYMD.get(),7,8)),strDelim.get()),m$.Fnc.$extract(numDateYMD.get(),1,4)));
    }
    //<< 
    //<< } elseif $extract(strFormat,1) = "Y" {
    else if (mOp.Equal(m$.Fnc.$extract(strFormat.get(),1),"Y")) {
      //<< set strDate = $extract(numDateYMD,1,4)_strDelim_$extract(numDateYMD,5,6)_strDelim_$extract(numDateYMD,7,8)
      mVar strDate = m$.var("strDate");
      strDate.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(m$.Fnc.$extract(numDateYMD.get(),1,4),strDelim.get()),m$.Fnc.$extract(numDateYMD.get(),5,6)),strDelim.get()),m$.Fnc.$extract(numDateYMD.get(),7,8)));
    }
    //<< 
    //<< } else {
    else {
      //<< ;   Unexpected format - treat as DD*MM*YYYY
      //<< set strDate = $extract(numDateYMD,7,8)_strDelim_$extract(numDateYMD,5,6)_strDelim_$extract(numDateYMD,1,4)
      mVar strDate = m$.var("strDate");
      strDate.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(m$.Fnc.$extract(numDateYMD.get(),7,8),strDelim.get()),m$.Fnc.$extract(numDateYMD.get(),5,6)),strDelim.get()),m$.Fnc.$extract(numDateYMD.get(),1,4)));
    }
    //<< }
    //<< 
    //<< quit strDate_strCounter //SR14422
    return mOp.Concat(m$.var("strDate").get(),strCounter.get());
  }

  //<< 
  //<< 
  //<< IntToDMY(pdteValue)
  public Object IntToDMY(Object ... _p) {
    mVar pdteValue = m$.newVarRef("pdteValue",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Convert hololog format date into DD.MM.YYYY regardless of FELDFORMAT setting.
    //<< ;   Not intended to cover counter suffix cases or require extra
    //<< ;   validation - calling code to ensure valid internal date
    //<< ;
    //<< ; Returns : literal date in set format
    //<< ;
    //<< ; History:
    //<< ; 04-Jun-2010   GRF     SR17146: created
    //<< ;-------------------------------------------------------------------------------
    //<< new strDMYDate
    mVar strDMYDate = m$.var("strDMYDate");
    m$.newVar(strDMYDate);
    //<< 
    //<< if '$get(pdteValue) set pdteValue = +$horolog
    if (mOp.Not(m$.Fnc.$get(pdteValue))) {
      pdteValue.set(mOp.Positive(m$.Fnc.$horolog()));
    }
    //<< if pdteValue<0      set pdteValue = +$horolog
    if (mOp.Less(pdteValue.get(),0)) {
      pdteValue.set(mOp.Positive(m$.Fnc.$horolog()));
    }
    //<< if pdteValue>100000 set pdteValue = +$horolog  ; approx 100 years ahead
    if (mOp.Greater(pdteValue.get(),100000)) {
      pdteValue.set(mOp.Positive(m$.Fnc.$horolog()));
    }
    //<< 
    //<< set strDMYDate = $translate($zdate(+pdteValue,4),"/",".")
    strDMYDate.set(m$.Fnc.$translate(m$.Fnc.$zdate(mOp.Positive(pdteValue.get()),4),"/","."));
    //<< if $length(strDMYDate)=8 {     ; 1900-1999 omits century
    if (mOp.Equal(m$.Fnc.$length(strDMYDate.get()),8)) {
      //<< set strDMYDate = $extract(strDMYDate,1,6)_"19"_$extract(strDMYDate,7,8)
      strDMYDate.set(mOp.Concat(mOp.Concat(m$.Fnc.$extract(strDMYDate.get(),1,6),"19"),m$.Fnc.$extract(strDMYDate.get(),7,8)));
    }
    //<< }
    //<< quit strDMYDate
    return strDMYDate.get();
  }

  //<< 
  //<< 
  //<< SystemDateFormat() ; Use GetDateFormat^COMUtilLocale instead - converts to D,M,Y as well
  public Object SystemDateFormat(Object ... _p) {
    //<< ;-------------------------------------------------------------------------------
    //<< ; Return the current system date format
    //<< ;
    //<< ; Called By : Execute on Form Construction : Form FINAPVoucherLoad F7, F9
    //<< ;             WWWFieldRules [OldTranslateDate - deprecated]
    //<< ;
    //<< ; Params:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 09-Aug-2011   shobby  SR17807: GetFormat has moved.
    //<< ; 20-Aug-2007   GM      SR13729: Change "FELDFORMAT" parameter to $$GetFormat^INPARA()
    //<< ; 15-Aug-2005   JW      SR12410: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new FORMAT
    mVar FORMAT = m$.var("FORMAT");
    m$.newVar(FORMAT);
    //<< 
    //<< ;SET FORMAT="TT/MM/JJJJ"
    //<< ;IF $GET(SPRACHE)'="" {
    //<< ;IF $DATA(^WWW100(0,"FELDFORMAT",SPRACHE,1,1)) SET FORMAT=$PIECE(^(1),Y,1)
    //<< ;IF $DATA(^WWW101(0,"FELDFORMAT",SPRACHE,1,1)) SET FORMAT=$PIECE(^(1),Y,1)
    //<< ;}
    //<< ;SR17807 SET FORMAT=$$GetFormat^INPARA(1,"TT/MM/JJJJ")  ;SR13729
    //<< SET FORMAT=$$GetFormat^WWW100(1,"TT/MM/JJJJ")  ;SR13729 ;SR17807
    FORMAT.set(m$.fnc$("WWW100.GetFormat",1,"TT/MM/JJJJ"));
    //<< 
    //<< quit FORMAT
    return FORMAT.get();
  }

//<< 
}
