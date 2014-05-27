//*****************************************************************************
//** TASC - ALPHALINC - MAC WWWFOR71
//** Innovatium Systems - Code Converter - v1.27
//** 2014-05-22 00:14:34
//*****************************************************************************

import mLibrary.*;

//<< 
//<< ;---------------------------------------
//<< ; SEE DOCO AT BOTTOM OF ROUTINE
//<< ;---------------------------------------
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
//<< #include WWWConst
import include.WWWConst;

//<< WWWFOR71
public class WWWFOR71 extends mClass {

  //<< 
  //<< #define LogR(%1,%2)     ;
  public static Object $$$LogR(mContext m$, Object ... _p) {
    mVar p$1 = m$.varRef("p$1",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar p$2 = m$.varRef("p$2",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    return null;
  }

  //<< #define LogR2(%1,%2)    ;
  public static Object $$$LogR2(mContext m$, Object ... _p) {
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
    _WWWFOR71();
  }

  public void _WWWFOR71() {
    //<< #;define LogR(%1,%2)    $$$JournalOff s ^zzLogR($g(YBED,"UNK"),$i(^zzLogR))= %1_"^WWWFOR71("_%2_") : "_$zh $$$JournalOn
    //<< #;define LogR2(%1,%2)   $$$JournalOff s ^zzLogR($g(YBED,"UNK"),$i(^zzLogR))= %1_"^WWWFOR71("_%2_") : "_$zh $$$JournalOn
    //<< #;define LogRx(%1)      $$$JournalOff s ^zzLogR($g(YBED,"UNK"),$i(^zzLogR))=%1 $$$JournalOn
    //<< #;define LogRm(%1)      $$$JournalOff m ^zzLogR($g(YBED,"UNK"),$i(^zzLogR))=%1 $$$JournalOn
    //<< 
    //<< ;-------------------------------------------------------------------------------
    //<< ; Description of Function : Assembling Search Parameters
    //<< ;
    //<< ;
    //<< ; Called By : Start^WWWFORM7, ^WWWPARA (for types "P", "D", "M")
    //<< ;
    //<< ; Inputs :
    //<< ;   YPARA(1)    = Relation Database
    //<< ;   YPARA(2)    = Relational Primary Keys
    //<< ;   YPARA(3)    = Relational Display Items
    //<< ;   YPARA(12)   = Sort The Relation (boolean)
    //<< ;   YPARA(20)   = Relation Display Options
    //<< ;   YPARA(33)   = Display If Sort Key Equal
    //<< ;   YPARA(67)   = New Display fo Event Broker          NEUES ANZEIGEFELD AUS EVENTBROKER
    //<< ;   YPARA(79)   = Mark Field                           MARKIERUNGSFELD
    //<< ;   YPARA(120)  = bln:Without Primary Key              OHNE PRIMÄRSCHLÜSSEL J/N
    //<< ;
    //<< ; ByRef :
    //<< ;
    //<< ;
    //<< ; Returns :   ;AUSGANGSVARIABLEN
    //<< ;   S ^WWWSOR(YUSER,2,SORTIERFOLGE,PARAMETER) = GEFUNDENER TEXT ZUM PARAMETER
    //<< ;   S ^WWWSOR(YUSER,2,idxParameter,Parameter) = Found on the Text Parameters
    //<< ;   YPARA(0)    = Language Class for Relations (normally Class_"1" if not blank)
    //<< ;   YPARA(5)    = Search Key                           SCHLÜSSEL DER SUCHDATEI
    //<< ;   YPARA(7)    = Number of Parameters Found  (+1?)    ANZAHL DER GEFUNDENEN PARAMETER
    //<< ;   YPARA(20)   = SPÄTER ANZEIGEN = 1 ;display
    //<< ;   YPARA(21)   = ANZAHL DER GEFUNDENEN TEXTE BEI "ANZEIGE SPÄTER"
    //<< ;                 (FÜR AUSWAHL DER ANZEIGE: TEXT/SELECTION/RADIO..)
    //<< ;   YPARA(51)   = MAXIMALE FELDLÄNGE DES SCHLÜSSELS ;field size
    //<< ;   YPARA(52)   = MAXIMALE FELDLÄNGE DER Datenfelder ;field size the Properties
    //<< ;   YPARA(55)   = 2 : ES GIBT MEHRERE PARAMETER NEBENEINANDER (ZEICHENART=COURIER)
    //<< ;                ;it divers parameter abreast
    //<< ;   YPARA(80)   = MARKIERUNGSFELDER ROT  ; red
    //<< ;   YPARA(81)   = MARKIERUNGSFELDER GELB ; yellow
    //<< ;   YPARA(82)   = MARKIERUNGSFELDER GRÜN ; green
    //<< ;   YPARA(555)  = Input Type for last primary key
    //<< ;   YPARA("ANZ")        = Number of entries? compared with YANZMAX
    //<< ;   YPARA("CF")         = Calculated Field [semicolon delimited list]
    //<< ;   YPARA("Excluded")   = Number of items that exist but are not desired in the list. (Change combo to search?)
    //<< ;
    //<< ; History :
    //<< ; 07-Jan-2011   GRF     SR17579: Use explicit tag for WWWTR calls
    //<< ; 13-Feb-2008   GRF     Doco
    //<< ; 28-Sep-2007   shobby  SRBR014731: Remember the number of items that were not
    //<< ;                           added to the drop down list.
    //<< ; 30-May-2006   SC      SR14631: Show all selections for read-only multi-select lists.
    //<< ; 26-Apr-2006   JW&PP   SR14508: Don't check for space if we want an actual match (below)
    //<< ; 01-Sep-2005   JW      SR12966: INART is not shared
    //<< ; 13-Jul-2005   GRF     FIXME
    //<< ; 30-May-2005   RobertW SR12056: Attempt at Performance Increase
    //<< ; 05-May-2005   shobby  2nd attempt.  If readonly still use a combo box but only
    //<< ;                           populate with the current value (SR12166)
    //<< ; 02-May-2005   shobby  Don't populate a list if the field is read only. (SR12166)
    //<< ; 02-May-2005   Paul K  Problem when key searching on is not last primary key and
    //<< ;                           last primary key is a date field. SR:12248
    //<< ; 05.08.1997    DT      (C) BY DITMAR TYBUSSEK
    //<< ;-------------------------------------------------------------------------------
    //<< do PARAM
    m$.Cmd.Do("PARAM");
    //<< $$$LogRx("Post:1")
    $$$LogRx(m$,"Post:1");
    //<< $$$LogRm(YPARA)
    $$$LogRm(m$,m$.var("YPARA"));
    //<< $$$LogRx("Post:2")
    $$$LogRx(m$,"Post:2");
    //<< $$$LogRm(^WWWSOR(YUSER,2))
    $$$LogRm(m$,m$.var("^WWWSOR",m$.var("YUSER").get(),2));
    //<< 
    //<< quit
    return;
  }

  //<< 
  //<< 
  //<< ; FIXME : repeats whole process when form contains multiple combo-boxes with
  //<< ;         the same relation (e.g. "JA/NEIN") - can we re-use on this one at
  //<< ;         least and perhaps on some others where no filtering occurs?
  //<< PARAM
  public void PARAM() {
    //<< ;-------------------------------------------------------------------------------
    //<< ; History:
    //<< ; 07-Sep-2012   SCR     SR18105: Color code for form VARPARA
    //<< ; 07-May-2010   PPP     SR17287: If Calculated Rel field exists - set the normal
    //<< ;                           Relation field to null
    //<< ; 29-Jun-2009   PPP     SR16663: Add the Calculated Relation Display Fields
    //<< ; 11-Dec-2007   GM      SRBR014601: Included "YKEY" parameter
    //<< ; 24-Oct-2007   shobby  SRBR014745: Don't limit the length of the text in a
    //<< ;                           dropdown.  It may have been customised larger than
    //<< ;                           the size defined in the class definition.
    //<< ; 09-Oct-2007   shobby  SRBR014744: Removed blnCheck flag that would decide if
    //<< ;                           the DataAccess routine is called.
    //<< ; 09-Oct-2007   shobby  SRBR014744: Pass the class that is being used to populate
    //<< ;                           the list in to the DataAccess call
    //<< ; 01-Oct-2007   shobby  SRBR014731: Keep the number of records that have been
    //<< ;                           filtered out to use in the calculation of whether
    //<< ;                           to change to a combo search.
    //<< ; 07-Aug-2007   shobby  BR014660: Create a KEY(0) variable.
    //<< ; 09-Jul-2007   shobby  BR014594: If this list is based on class fields then
    //<< ;                           display a bit more information for those fields
    //<< ;                           which are free fields.
    //<< ; 05-Jul-2007   shobby  BR014594: Create an array of KEY variables that hold
    //<< ;                           the pieces of the YKEY.  This is used as a parameter
    //<< ;                           in relational primary keys class design.
    //<< ;  6-Dec-2006   JW      BR014285: Data Access
    //<< ; 22-Aug-2006   JW      SR14929: Check data type before conversion (SR14604)
    //<< ; 18-Aug-2006   RPW/JW  SR14604: Make 0 always show a popup
    //<< ; 01-Aug-2006   JW      SR14604: Check limit if can change Combo to Search.
    //<< ;-------------------------------------------------------------------------------
    //<< new ERSTFELD,FELDKEY,LC,UC,YANZMAX,YDATA,YFILE,YFILES,YSORTNAME,YMAXKEY,YSKPR
    mVar ERSTFELD = m$.var("ERSTFELD");
    mVar FELDKEY = m$.var("FELDKEY");
    mVar LC = m$.var("LC");
    mVar UC = m$.var("UC");
    mVar YANZMAX = m$.var("YANZMAX");
    mVar YDATA = m$.var("YDATA");
    mVar YFILE = m$.var("YFILE");
    mVar YFILES = m$.var("YFILES");
    mVar YSORTNAME = m$.var("YSORTNAME");
    mVar YMAXKEY = m$.var("YMAXKEY");
    mVar YSKPR = m$.var("YSKPR");
    m$.newVar(ERSTFELD,FELDKEY,LC,UC,YANZMAX,YDATA,YFILE,YFILES,YSORTNAME,YMAXKEY,YSKPR);
    //<< new blnCheck,loop,strExec,strGlobal,KEY
    mVar blnCheck = m$.var("blnCheck");
    mVar loop = m$.var("loop");
    mVar strExec = m$.var("strExec");
    mVar strGlobal = m$.var("strGlobal");
    mVar KEY = m$.var("KEY");
    m$.newVar(blnCheck,loop,strExec,strGlobal,KEY);
    //<< 
    //<< $$$LogR("PARAM",$get(YFORM))
    $$$LogR(m$,"PARAM",m$.Fnc.$get(m$.var("YFORM")));
    //<< $$$LogRm(YPARA)
    $$$LogRm(m$,m$.var("YPARA"));
    //<< 
    //<< ;+++++++++++++++++++++++++++++++++++++++
    //<< ; Data Records :
    //<< ;   YDATA           objWWW001           Data Dictionary
    //<< ;+++++++++++++++++++++++++++++++++++++++
    //<< 
    //<< for loop=1:1:20 {
    for (loop.set(1);(mOp.LessOrEqual(loop.get(),20));loop.set(mOp.Add(loop.get(),1))) {
      //<< set KEY(loop) = $piece($get(YKEY),$$$COMMA,loop)
      KEY.var(loop.get()).set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("YKEY")),include.COMSYSString.$$$COMMA(m$),loop.get()));
    }
    //<< }
    //<< if KEY(1)'="" {    ;  Only relevant to WWW122D2 (Customizing Rules form)
    if (mOp.NotEqual(KEY.var(1).get(),"")) {
      //<< set KEY(0) = $$$WWW120ClassUsedInForm($get(^WWW120(0,KEY(1),1)))
      KEY.var(0).set(include.WWWConst.$$$WWW120ClassUsedInForm(m$,m$.Fnc.$get(m$.var("^WWW120",0,KEY.var(1).get(),1))));
    }
    //<< }
    //<< 
    //<< set LC = "ÜÄÖüäöß][\}{|abcdefghijklmnopqrstuvwxyz,()@#$%^&*_=+<>?/"_$char(128)_""" "
    LC.set(mOp.Concat(mOp.Concat("ÜÄÖüäöß][\\}{|abcdefghijklmnopqrstuvwxyz,()@#$%^&*_=+<>?/",m$.Fnc.$char(128)),"\" "));
    //<< set UC = "UAOUAOSUAOUAOABCDEFGHIJKLMNOPQRSTUVWXYZ                   "
    UC.set("UAOUAOSUAOUAOABCDEFGHIJKLMNOPQRSTUVWXYZ                   ");
    //<< 
    //<< kill ^WWWSOR(YUSER,2)
    m$.var("^WWWSOR",m$.var("YUSER").get(),2).kill();
    //<< 
    //<< set YPARA(21)  = 0
    mVar YPARA = m$.var("YPARA");
    YPARA.var(21).set(0);
    //<< set YPARA(55)  = 0
    YPARA.var(55).set(0);
    //<< set YPARA(80)  = ""  ;MARKIERUNGEN ROT  ;red
    YPARA.var(80).set("");
    //<< set YPARA(81)  = ""  ;MARKIERUNGEN GELB ;yellow
    YPARA.var(81).set("");
    //<< set YPARA(82)  = ""  ;MARKIERUNGEN GRÜN ;green
    YPARA.var(82).set("");
    //<< set YPARA(83)  = ""  ;MARKIERUNGEN GRÜN ;green    > blue?  see later
    YPARA.var(83).set("");
    //<< set YPARA(84)  = ""  ;MARKIERUNGEN GRÜN ;green    > gray?  see later
    YPARA.var(84).set("");
    //<< set YPARA(555) = ""  ;FORMAT DES KEY ;format KEY
    YPARA.var(555).set("");
    //<< set YDATA      = ""
    YDATA.set("");
    //<< if $extract(YPARA(1),1,2)'="IN" if $extract(YPARA(1),1,3)'="WWW" set YDATA=$get(^WWW001(0,YPARA(1),1))  ;VARIABEL AUS DATENSATZDEF.  FELD 8=DATEIART
    if (mOp.NotEqual(m$.Fnc.$extract(YPARA.var(1).get(),1,2),"IN")) {
      if (mOp.NotEqual(m$.Fnc.$extract(YPARA.var(1).get(),1,3),"WWW")) {
        YDATA.set(m$.Fnc.$get(m$.var("^WWW001",0,YPARA.var(1).get(),1)));
      }
    }
    //<< 
    //<< ; *****************************************************
    //<< ; FIXME : These routines do not exist - may never get called due to nature of alternate storage <GRF>
    //<< ;         The codes 6 & 7 have been removed from ^WWW100(0,"SPEICHERUNG")
    //<< if $$$WWW001AltSaveProcedure(YDATA)=7 do ^WWWFOR717  ;SQLSTORAGE
    if (mOp.Equal(include.WWWConst.$$$WWW001AltSaveProcedure(m$,YDATA),7)) {
      m$.Cmd.Do("WWWFOR717.main");
    }
    //<< if $$$WWW001AltSaveProcedure(YDATA)=6 do ^WWWFOR71A  ;ABACUS
    if (mOp.Equal(include.WWWConst.$$$WWW001AltSaveProcedure(m$,YDATA),6)) {
      m$.Cmd.Do("WWWFOR71A.main");
    }
    //<< ; *****************************************************
    //<< 
    //<< 
    //<< ; YPARA(33) : Relation Test
    //<< ;             Index#,$$$Index(Value)                          Source from ^GLOBALs(0,Index#,idxValue)
    //<< ;             Index#,@Variable                                Source from ^GLOBALs(0,Index#,$$$Index(@Variable))
    //<< ;             Index#,$$$Index(Value),idxValue3,idxValue4      Source from ^GLOBALs(0,Index#,idxValue,3,4) see FIXME - believe should be
    //<< ;                                                             Source from ^GLOBALs(0,Index#,idxValue,idxValue3,idxValue4)
    //<< set YSORTNAME=""
    YSORTNAME.set("");
    //<< if $piece($get(YPARA(33)),",",1)>0 do
    if (mOp.Greater(m$.Fnc.$piece(m$.Fnc.$get(YPARA.var(33)),",",1),0)) {
      //<< . set YSORTNAME = $piece($get(^WWW0013(0,YPARA(1),$piece(YPARA(33),",",1),1)),Y,1)
      YSORTNAME.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW0013",0,YPARA.var(1).get(),m$.Fnc.$piece(YPARA.var(33).get(),",",1),1)),m$.var("Y").get(),1));
      //<< . if YSORTNAME="" do
      if (mOp.Equal(YSORTNAME.get(),"")) {
        //<< . . if $piece(YDATA,Y,8)=4  set YSORTNAME = "Index"_$piece(YPARA(33),",",1)    ; WWW001AltSaveProcedure 4="Caché Object"
        if (mOp.Equal(m$.Fnc.$piece(YDATA.get(),m$.var("Y").get(),8),4)) {
          YSORTNAME.set(mOp.Concat("Index",m$.Fnc.$piece(YPARA.var(33).get(),",",1)));
        }
        //<< . . if $piece(YDATA,Y,8)'=4 set YSORTNAME = +$piece(YPARA(33),",",1)
        if (mOp.NotEqual(m$.Fnc.$piece(YDATA.get(),m$.var("Y").get(),8),4)) {
          YSORTNAME.set(mOp.Positive(m$.Fnc.$piece(YPARA.var(33).get(),",",1)));
        }
      }
    }
    //<< 
    //<< 
    //<< set YFILE  = YPARA(1)
    YFILE.set(YPARA.var(1).get());
    //<< if $piece(YDATA,Y,22)'="" set YFILE  = $piece(YDATA,Y,22)  ;ANDERE DATEI ;data file
    if (mOp.NotEqual(m$.Fnc.$piece(YDATA.get(),m$.var("Y").get(),22),"")) {
      YFILE.set(m$.Fnc.$piece(YDATA.get(),m$.var("Y").get(),22));
    }
    //<< set YFILES = YPARA(1)_"s"
    YFILES.set(mOp.Concat(YPARA.var(1).get(),"s"));
    //<< if $piece(YDATA,Y,23)'="" set YFILES = $piece(YDATA,Y,23)  ;ANDERE SORTDATEI
    if (mOp.NotEqual(m$.Fnc.$piece(YDATA.get(),m$.var("Y").get(),23),"")) {
      YFILES.set(m$.Fnc.$piece(YDATA.get(),m$.var("Y").get(),23));
    }
    //<< if (+YPARA(3)=0) && (+YPARA("CF")=0) set YPARA(3) = 1
    if ((mOp.Equal(mOp.Positive(YPARA.var(3).get()),0)) && (mOp.Equal(mOp.Positive(YPARA.var("CF").get()),0))) {
      YPARA.var(3).set(1);
    }
    //<< set YPARA(3)    = $translate(YPARA(3),";",",")
    YPARA.var(3).set(m$.Fnc.$translate(YPARA.var(3).get(),";",","));
    //<< set YPARA("CF") = $translate($get(YPARA("CF")),";",",")
    YPARA.var("CF").set(m$.Fnc.$translate(m$.Fnc.$get(YPARA.var("CF")),";",","));
    //<< if YPARA("CF")'="" set YPARA(3) = ""
    if (mOp.NotEqual(YPARA.var("CF").get(),"")) {
      YPARA.var(3).set("");
    }
    //<< 
    //<< ;if $piece(YSATZ,Y,23)=5 set YPARA(20)=1     ; "Relation Display Options" = 1 : "Display Relations after Input"
    //<< ;   02-May-2005:shobby:SR12166 -
    //<< ;       If the field is read only then we probably don't need to populate a list
    //<< ;       at all and just use a disabled text box.
    //<< ;       This is accomplished by setting the value which marks whether
    //<< ;       'Relation Display Options' is set to 'Display Relations after Input'.
    //<< ;       In which case the desired functionality is achieved.
    //<< if YPARA(20)=1 quit:YINHALT=""  do PARAM1 quit   ;NUR WENN INHALT DANN ANZEIGE ;only when purport Show
    if (mOp.Equal(YPARA.var(20).get(),1)) {
      if (mOp.Equal(m$.var("YINHALT").get(),"")) {
        return;
      }
      m$.Cmd.Do("PARAM1");
      return;
    }
    //<< if YTYPE="FILE"                 do PARAM2 quit   ;WENN DISKINHALT ;when
    if (mOp.Equal(m$.var("YTYPE").get(),"FILE")) {
      m$.Cmd.Do("PARAM2");
      return;
    }
    //<< 
    //<< set YPARA(52)=$piece($get(YSATZ),Y,64)           ;MANUELLE LÄNGE DER RELATION (DATENFELDER) ;longitude the
    YPARA.var(52).set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("YSATZ")),m$.var("Y").get(),64));
    //<< set YPARA(51)=""                                 ;FELDLÄNGE FÜR PRIMÄRSCHLÜSSEL ;field size to
    YPARA.var(51).set("");
    //<< if $find(YPARA(52),"-") set YPARA(51)=$piece(YPARA(52),"-",1) set YPARA(52)=$piece(YPARA(52),"-",2)  ;WENN MIT "-" (PRIMÄRSCHLUESSEL)
    if (mOp.Logical(m$.Fnc.$find(YPARA.var(52).get(),"-"))) {
      YPARA.var(51).set(m$.Fnc.$piece(YPARA.var(52).get(),"-",1));
      YPARA.var(52).set(m$.Fnc.$piece(YPARA.var(52).get(),"-",2));
    }
    //<< ;QUIT:$DATA(^WWWSOR(YUSER,2))
    //<< 
    //<< ;YPARA(4) : LAUFVARIABLE
    //<< set YPARA(4) = "^"_YFILE_"("_$$^WWWYM(YPARA(1),1)
    YPARA.var(4).set(mOp.Concat(mOp.Concat(mOp.Concat("^",YFILE.get()),"("),m$.fnc$("WWWYM.main",YPARA.var(1).get(),1)));
    //<< if $piece(YDATA,Y,12)'="" if $piece(YDATA,Y,13)'="" do  ;UCI UND VOL ;UCI And
    if (mOp.NotEqual(m$.Fnc.$piece(YDATA.get(),m$.var("Y").get(),12),"")) {
      if (mOp.NotEqual(m$.Fnc.$piece(YDATA.get(),m$.var("Y").get(),13),"")) {
        do {
          //<< . quit:$find(YPARA(4),"^[")
          if (mOp.Logical(m$.Fnc.$find(YPARA.var(4).get(),"^["))) {
            break;
          }
          //<< . set YPARA(4)="^["""_$piece(YDATA,Y,12)_""","""_$piece(YDATA,Y,13)_"""]"_$piece(YPARA(4),"^",2,999)
          YPARA.var(4).set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("^[\"",m$.Fnc.$piece(YDATA.get(),m$.var("Y").get(),12)),"\",\""),m$.Fnc.$piece(YDATA.get(),m$.var("Y").get(),13)),"\"]"),m$.Fnc.$piece(YPARA.var(4).get(),"^",2,999)));
        } while (false);
      }
    }
    do {
      //<< 
      //<< do  ;PRUEFEN AUF SORTKEY ;upon
      //<< . set YSKPR    = ""      ;PRUEFUNG AUF $D ;upon
      YSKPR.set("");
      //<< . set YSKPR(1) = ""      ;PRUEFUNG AUF NICHT $D ;upon Not
      YSKPR.var(1).set("");
      //<< . if +$piece($get(YPARA(33)),",",1)'=0 do
      if (mOp.NotEqual(mOp.Positive(m$.Fnc.$piece(m$.Fnc.$get(YPARA.var(33)),",",1)),0)) {
        //<< . . set YSKPR(2)="^"_YFILES_"("_$$^WWWYM(YPARA(1),1) do  ;PRUEFEN CACHE
        YSKPR.var(2).set(mOp.Concat(mOp.Concat(mOp.Concat("^",YFILES.get()),"("),m$.fnc$("WWWYM.main",YPARA.var(1).get(),1)));
        do {
          //<< . . . set YSKPR(2) = YSKPR(2)_""""_YSORTNAME_""""
          YSKPR.var(2).set(mOp.Concat(mOp.Concat(mOp.Concat(YSKPR.var(2).get(),"\""),YSORTNAME.get()),"\""));
          //<< . . . set YSKPR(2) = YSKPR(2)_","
          YSKPR.var(2).set(mOp.Concat(YSKPR.var(2).get(),","));
        } while(false);
        //<< . . ;
        //<< . . if $piece(YPARA(33),",",3,99)'="" do  ;WEITERE VORGABEN
        if (mOp.NotEqual(m$.Fnc.$piece(YPARA.var(33).get(),",",3,99),"")) {
          //<< . . . new YI
          mVar YI = m$.var("YI");
          m$.newVar(YI);
          //<< . . . for YI=3:1 set YI(1) = $piece(YPARA(33),",",YI) quit:YI(1)=""  set YSKPR(2) = YSKPR(2)_YI_","   ; FIXME : Should this be concatenate YI(1) rather than YI?
          for (YI.set(3);(true);YI.set(mOp.Add(YI.get(),1))) {
            YI.var(1).set(m$.Fnc.$piece(YPARA.var(33).get(),",",YI.get()));
            if (mOp.Equal(YI.var(1).get(),"")) {
              break;
            }
            YSKPR.var(2).set(mOp.Concat(mOp.Concat(YSKPR.var(2).get(),YI.get()),","));
          }
        }
        //<< . . ;
        //<< . . set YSKPR(1)=YSKPR(2)_""" "",YPARA(5))"
        YSKPR.var(1).set(mOp.Concat(YSKPR.var(2).get(),"\" \",YPARA(5))"));
        //<< . . if $piece(YPARA(33),",",2)'="" do
        if (mOp.NotEqual(m$.Fnc.$piece(YPARA.var(33).get(),",",2),"")) {
          do {
            //<< . . . if $extract($piece(YPARA(33),",",2))="@" set $piece(YPARA(33),",",2)=$$^WWWUMLAU(@($extract($piece(YPARA(33),",",2),2,99)),1)
            if (mOp.Equal(m$.Fnc.$extract(m$.Fnc.$piece(YPARA.var(33).get(),",",2)),"@")) {
              m$.pieceVar(YPARA.var(33),",",2).set(m$.fnc$("WWWUMLAU.main",m$.indirectVar((m$.Fnc.$extract(m$.Fnc.$piece(YPARA.var(33).get(),",",2),2,99))).get(),1));
            }
            //<< . . . quit:$piece(YPARA(33),",",2)=""
            if (mOp.Equal(m$.Fnc.$piece(YPARA.var(33).get(),",",2),"")) {
              break;
            }
            //<< . . . if $extract($piece(YPARA(33),",",2))'="@"  set YSKPR = YSKPR(2)_""""_$piece(YPARA(33),",",2)_""""
            if (mOp.NotEqual(m$.Fnc.$extract(m$.Fnc.$piece(YPARA.var(33).get(),",",2)),"@")) {
              YSKPR.set(mOp.Concat(mOp.Concat(mOp.Concat(YSKPR.var(2).get(),"\""),m$.Fnc.$piece(YPARA.var(33).get(),",",2)),"\""));
            }
            //<< . . . if $extract($piece(YPARA(33),",",2))="@"   set YSKPR = YSKPR(2)_""""_@($piece(YPARA(33),",",2))_""""  ; FIXME : 2nd indirection requires variable to be in uppercase
            if (mOp.Equal(m$.Fnc.$extract(m$.Fnc.$piece(YPARA.var(33).get(),",",2)),"@")) {
              YSKPR.set(mOp.Concat(mOp.Concat(mOp.Concat(YSKPR.var(2).get(),"\""),m$.indirectVar((m$.Fnc.$piece(YPARA.var(33).get(),",",2))).get()),"\""));
            }
            //<< . . . if YPARA(2)'="" if $extract(YPARA(2))'="," set YSKPR = YSKPR_","_YPARA(2)  ;_","
            if (mOp.NotEqual(YPARA.var(2).get(),"")) {
              if (mOp.NotEqual(m$.Fnc.$extract(YPARA.var(2).get()),",")) {
                YSKPR.set(mOp.Concat(mOp.Concat(YSKPR.get(),","),YPARA.var(2).get()));
              }
            }
            //<< . . . set YSKPR = YSKPR_",YPARA(5)"
            YSKPR.set(mOp.Concat(YSKPR.get(),",YPARA(5)"));
            //<< . . . if $extract(YPARA(2))="," set YSKPR = YSKPR_YPARA(2)
            if (mOp.Equal(m$.Fnc.$extract(YPARA.var(2).get()),",")) {
              YSKPR.set(mOp.Concat(YSKPR.get(),YPARA.var(2).get()));
            }
            //<< . . . set YSKPR = YSKPR_")"
            YSKPR.set(mOp.Concat(YSKPR.get(),")"));
          } while (false);
        }
      }
    } while(false);
    //<< 
    //<< ; Special for Item Master Data searches
    //<< ;---------------------------------------
    //<< if $find($translate(YSKPR,""""),"^INARTs("_YM_",7,2,") do  quit
    if (mOp.Logical(m$.Fnc.$find(m$.Fnc.$translate(YSKPR.get(),"\""),mOp.Concat(mOp.Concat("^INARTs(",m$.var("YM").get()),",7,2,")))) {
      //<< . new NAME
      mVar NAME = m$.var("NAME");
      m$.newVar(NAME);
      //<< . set NAME = ""
      NAME.set("");
      //<< . for  set NAME = $order(^INARTs(YM,7,2,NAME)) quit:NAME=""  do
      for (;true;) {
        NAME.set(m$.Fnc.$order(m$.var("^INARTs",m$.var("YM").get(),7,2,NAME.get())));
        if (mOp.Equal(NAME.get(),"")) {
          break;
        }
        //<< . . set YPARA(5) = ""
        YPARA.var(5).set("");
        //<< . . for YPARA(7)=1:1 set YPARA(5) = $order(^INARTs(YM,7,2,NAME,YPARA(5))) quit:YPARA(5)=""  do
        for (m$.var("YPARA",7).set(1);(true);m$.var("YPARA",7).set(mOp.Add(m$.var("YPARA",7).get(),1))) {
          YPARA.var(5).set(m$.Fnc.$order(m$.var("^INARTs",m$.var("YM").get(),7,2,NAME.get(),YPARA.var(5).get())));
          if (mOp.Equal(YPARA.var(5).get(),"")) {
            break;
          }
          //<< . . . set YSORT(1)  = NAME
          mVar YSORT = m$.var("YSORT");
          YSORT.var(1).set(NAME.get());
          //<< . . . set YSORT     = YPARA(5)
          YSORT.set(YPARA.var(5).get());
          //<< . . . set YPARA(53) = $piece($get(^INART(YM,YPARA(5),1)),Y,1)
          YPARA.var(53).set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^INART",m$.var("YM").get(),YPARA.var(5).get(),1)),m$.var("Y").get(),1));
          //<< . . . set ^WWWSOR(YUSER,2,$$^WWWUMLAU(YSORT(1),3)_" ",YPARA(5))=" ("_YSORT_")  "_YPARA(53)
          m$.var("^WWWSOR",m$.var("YUSER").get(),2,mOp.Concat(m$.fnc$("WWWUMLAU.main",YSORT.var(1).get(),3)," "),YPARA.var(5).get()).set(mOp.Concat(mOp.Concat(mOp.Concat(" (",YSORT.get()),")  "),YPARA.var(53).get()));
        }
      }
      return;
    }
    //<< 
    //<< set Q       = 0
    mVar Q = m$.var("Q");
    Q.set(0);
    //<< set YCOLOR  = 0
    mVar YCOLOR = m$.var("YCOLOR");
    YCOLOR.set(0);
    //<< set YCOLOR1 = ""
    mVar YCOLOR1 = m$.var("YCOLOR1");
    YCOLOR1.set("");
    //<< if $find(YPARA(2),"FARBE")                    set YCOLOR  = 1         ;WENN FARBCODE ;when colour
    if (mOp.Logical(m$.Fnc.$find(YPARA.var(2).get(),"FARBE"))) {
      YCOLOR.set(1);
    }
    //<< ; if (YPARA(1)="WWW101") || (YPARA(1)="INPARA") set YCOLOR1 = YPARA(2)  ;WENN FARBCODE IN TEXT ;when within Text
    //<< if (YPARA(1)="WWW101") || (YPARA(1)="INPARA") || (YPARA(1)="VARPARA") set YCOLOR1 = YPARA(2)  ;SR18105 ;WENN FARBCODE IN TEXT ;when within Text
    if ((mOp.Equal(YPARA.var(1).get(),"WWW101")) || (mOp.Equal(YPARA.var(1).get(),"INPARA")) || (mOp.Equal(YPARA.var(1).get(),"VARPARA"))) {
      YCOLOR1.set(YPARA.var(2).get());
    }
    //<< if $find(YPARA(2),"SCHRIFTART")               set YCOLOR  = 2         ;WENN SCHRIFTART ;when font
    if (mOp.Logical(m$.Fnc.$find(YPARA.var(2).get(),"SCHRIFTART"))) {
      YCOLOR.set(2);
    }
    //<< 
    //<< for YI=1:1 set YPARA(9)=$piece(YPARA(2),",",YI) quit:YPARA(9)=""  set YPARA(4)=YPARA(4)_YPARA(9)_"," if $extract(YPARA(9))'="""" if $get(@(YPARA(9)))="" set Q=1 quit
    mVar YI = m$.var("YI");
    for (YI.set(1);(true);YI.set(mOp.Add(YI.get(),1))) {
      YPARA.var(9).set(m$.Fnc.$piece(YPARA.var(2).get(),",",YI.get()));
      if (mOp.Equal(YPARA.var(9).get(),"")) {
        break;
      }
      YPARA.var(4).set(mOp.Concat(mOp.Concat(YPARA.var(4).get(),YPARA.var(9).get()),","));
      if (mOp.NotEqual(m$.Fnc.$extract(YPARA.var(9).get()),"\"")) {
        if (mOp.Equal(m$.Fnc.$get(m$.indirectVar((YPARA.var(9).get()))),"")) {
          Q.set(1);
          break;
        }
      }
    }
    //<< 
    //<< 
    //<< ;---------------------------------------
    //<< if Q=1 set Q=0 quit
    if (mOp.Equal(Q.get(),1)) {
      Q.set(0);
      return;
    }
    //<< ;---------------------------------------
    //<< 
    //<< 
    //<< set YPARA(10)    = YPARA(4)_"YPARA(5))"  ;ZIELVARIABLE FÜR @VARIABLE
    YPARA.var(10).set(mOp.Concat(YPARA.var(4).get(),"YPARA(5))"));
    //<< set YPARA(5)     = ""
    YPARA.var(5).set("");
    //<< set YPARA("ANZ") = 0                ; WACH WEGEN DMV PARAMETERANZEIGE WENN RELATION
    YPARA.var("ANZ").set(0);
    //<< 
    //<< set YANZMAX = $$GetMaxSelectRecords^WWW012()
    YANZMAX.set(m$.fnc$("WWW012.GetMaxSelectRecords"));
    //<< if '$$ComboToSearch(YXTYP,YPARA(1)) {
    if (mOp.Not(m$.fnc$("ComboToSearch",m$.var("YXTYP").get(),YPARA.var(1).get()))) {
      //<< set YANZMAX = 9999
      YANZMAX.set(9999);
    }
    //<< }
    //<< 
    //<< if ($piece(YSATZ,Y,23)=5) && ($$$WWW122DataInputType(YSATZ)'=6) {
    if ((mOp.Equal(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),23),5)) && (mOp.NotEqual(include.WWWConst.$$$WWW122DataInputType(m$,m$.var("YSATZ")),6))) {
      //<< set YANZMAX  = 2
      YANZMAX.set(2);
      //<< set YPARA(5) = YINHALT
      YPARA.var(5).set(m$.var("YINHALT").get());
      //<< set YPARA(5) = $order(@(YPARA(10)),-1)
      YPARA.var(5).set(m$.Fnc.$order(m$.indirectVar((YPARA.var(10).get())),mOp.Negative(1)));
    }
    //<< }
    //<< 
    //<< set strExec  = $$$WWW001DataAccess($get(^WWW001(0,YPARA(1),1)))
    strExec.set(include.WWWConst.$$$WWW001DataAccess(m$,m$.Fnc.$get(m$.var("^WWW001",0,YPARA.var(1).get(),1))));
    //<< set blnCheck = $$$YES
    blnCheck.set(include.COMSYS.$$$YES(m$));
    //<< 
    //<< set strGlobal = "^"_YFILE_"("_$$^WWWYM(YPARA(1),1)
    strGlobal.set(mOp.Concat(mOp.Concat(mOp.Concat("^",YFILE.get()),"("),m$.fnc$("WWWYM.main",YPARA.var(1).get(),1)));
    //<< 
    //<< set YMAXKEY    = $length(YPARA(2),",")+1  ; null string => 1
    YMAXKEY.set(mOp.Add(m$.Fnc.$length(YPARA.var(2).get(),","),1));
    //<< set YPARA(555) = $$$WWW002InputType($get(^WWW002(0,YPARA(1),YMAXKEY,1)))
    YPARA.var(555).set(include.WWWConst.$$$WWW002InputType(m$,m$.Fnc.$get(m$.var("^WWW002",0,YPARA.var(1).get(),YMAXKEY.get(),1))));
    //<< set YPARA(0)   = $$$WWW001LanguageClassForRelations($get(^WWW001(0,YPARA(1),1)))  ;SPRACHDATEI
    YPARA.var(0).set(include.WWWConst.$$$WWW001LanguageClassForRelations(m$,m$.Fnc.$get(m$.var("^WWW001",0,YPARA.var(1).get(),1))));
    //<< 
    //<< // TODO JW:
    //<< //   - surely rewrite this doing $query ?
    //<< //   - why are we rebuilding the global EVERY time ?   - different rules may apply to DataAccess when data is sourced from different forms/fields
    //<< 
    //<< ; YPARA(20) "Relation Display Options" '= 0 : "Display All Relations"
    //<< ; may treat "" differently depending on whether equated on setting YPARA(20)
    //<< set YPARA("Excluded")=0
    YPARA.var("Excluded").set(0);
    //<< for YPARA(7)=1:1 set YPARA(5)=$order(@(YPARA(10))) quit:YPARA(5)=""  do  if YPARA(20)'=0 quit:YPARA("ANZ")>YANZMAX  if $get(YYYFORM)="WWWHPR" quit:YPARA("ANZ")>3   ;BEI HILFE  ;next to succour
    for (m$.var("YPARA",7).set(1);(true);m$.var("YPARA",7).set(mOp.Add(m$.var("YPARA",7).get(),1))) {
      YPARA.var(5).set(m$.Fnc.$order(m$.indirectVar((YPARA.var(10).get()))));
      if (mOp.Equal(YPARA.var(5).get(),"")) {
        break;
      }
      do {
        //<< . if $piece(YDATA,Y,8)'=4 set YPARA(6)=YPARA(4)_""""_YPARA(5)_""",1)"  ;KEIN OBJECT ;no
        if (mOp.NotEqual(m$.Fnc.$piece(YDATA.get(),m$.var("Y").get(),8),4)) {
          YPARA.var(6).set(mOp.Concat(mOp.Concat(mOp.Concat(YPARA.var(4).get(),"\""),YPARA.var(5).get()),"\",1)"));
        }
        //<< . if $piece(YDATA,Y,8)=4  set YPARA(6)=YPARA(4)_""""_YPARA(5)_""")"    ;OBJECT
        if (mOp.Equal(m$.Fnc.$piece(YDATA.get(),m$.var("Y").get(),8),4)) {
          YPARA.var(6).set(mOp.Concat(mOp.Concat(mOp.Concat(YPARA.var(4).get(),"\""),YPARA.var(5).get()),"\")"));
        }
        //<< . ;
        //<< . //SET YPARA(44)="^"_YFILE_"("_$$^WWWYM(YPARA(1),1)    // BR014285
        //<< . set YPARA(44) = ""
        YPARA.var(44).set("");
        //<< . ;
        //<< . for YI=1:1 set YPARA(19)=$piece(YPARA(2),",",YI) quit:YPARA(19)=""  do
        for (YI.set(1);(true);YI.set(mOp.Add(YI.get(),1))) {
          YPARA.var(19).set(m$.Fnc.$piece(YPARA.var(2).get(),",",YI.get()));
          if (mOp.Equal(YPARA.var(19).get(),"")) {
            break;
          }
          //<< . . if $extract(YPARA(19))'="""" set YPARA(19)=""""_$get(@YPARA(19))_""""
          if (mOp.NotEqual(m$.Fnc.$extract(YPARA.var(19).get()),"\"")) {
            YPARA.var(19).set(mOp.Concat(mOp.Concat("\"",m$.Fnc.$get(m$.indirectVar(YPARA.var(19).get()))),"\""));
          }
          //<< . . set YPARA(44) = YPARA(44)_YPARA(19)_","
          YPARA.var(44).set(mOp.Concat(mOp.Concat(YPARA.var(44).get(),YPARA.var(19).get()),","));
        }
        //<< . ;
        //<< . // Check data access
        //<< . if (blnCheck&&'$$DataAccess^WWWFieldValidation(strExec,YPARA(44)_YPARA(5),YFORM,YTYP,YLFN,,YPARA(1),.blnCheck,YKEY)) set YPARA("Excluded")=YPARA("Excluded")+1 quit   // BR014285 ;BR014731  ;BR014744 ;BR014601
        if ((mOp.Logical(blnCheck.get()) && mOp.Not(m$.fnc$("WWWFieldValidation.DataAccess",strExec.get(),mOp.Concat(YPARA.var(44).get(),YPARA.var(5).get()),m$.var("YFORM").get(),m$.var("YTYP").get(),m$.var("YLFN").get(),null,YPARA.var(1).get(),blnCheck,m$.var("YKEY").get())))) {
          YPARA.var("Excluded").set(mOp.Add(YPARA.var("Excluded").get(),1));
          break;
        }
        //<< . ;
        //<< . set YPARA(44) = strGlobal_YPARA(44)
        YPARA.var(44).set(mOp.Concat(strGlobal.get(),YPARA.var(44).get()));
        //<< . ;
        //<< . if $piece(YDATA,Y,8)=4 do   ;NUR BEI FREMDSPEICHERUNG (LETZTER KEY) ;only next to
        if (mOp.Equal(m$.Fnc.$piece(YDATA.get(),m$.var("Y").get(),8),4)) {
          //<< . . set ERSTFELD = $order(^WWW003(0,YPARA(1),""))
          ERSTFELD.set(m$.Fnc.$order(m$.var("^WWW003",0,YPARA.var(1).get(),"")));
          //<< . . set FELDKEY  = ""
          FELDKEY.set("");
          //<< . . if ERSTFELD'="" set FELDKEY=$piece(^WWW003(0,YPARA(1),ERSTFELD,1),Y,11)
          if (mOp.NotEqual(ERSTFELD.get(),"")) {
            FELDKEY.set(m$.Fnc.$piece(m$.var("^WWW003",0,YPARA.var(1).get(),ERSTFELD.get(),1).get(),m$.var("Y").get(),11));
          }
          //<< . . set YPARA(19) = YPARA(44)_""""_YPARA(5)_""""
          YPARA.var(19).set(mOp.Concat(mOp.Concat(mOp.Concat(YPARA.var(44).get(),"\""),YPARA.var(5).get()),"\""));
          //<< . . if FELDKEY'="" set YPARA(19) = YPARA(19)_","_FELDKEY
          if (mOp.NotEqual(FELDKEY.get(),"")) {
            YPARA.var(19).set(mOp.Concat(mOp.Concat(YPARA.var(19).get(),","),FELDKEY.get()));
          }
          //<< . . set YPARA(19) = YPARA(19)_")"
          YPARA.var(19).set(mOp.Concat(YPARA.var(19).get(),")"));
        }
        //<< . ;
        //<< . if $piece(YDATA,Y,8)'=4 do  ;STANDARDSPEICHERUNG
        if (mOp.NotEqual(m$.Fnc.$piece(YDATA.get(),m$.var("Y").get(),8),4)) {
          //<< . . set YPARA(19) = YPARA(44)_""""_YPARA(5)_""",1)"
          YPARA.var(19).set(mOp.Concat(mOp.Concat(mOp.Concat(YPARA.var(44).get(),"\""),YPARA.var(5).get()),"\",1)"));
        }
        //<< . ;
        //<< . ;BEC;ÄNDERUNG WACH 5 ZEILEN;2699013.12.04
        //<< . if $piece(YDATA,Y,8)'=4 do  ;STANDARDSPEICHERUNG
        if (mOp.NotEqual(m$.Fnc.$piece(YDATA.get(),m$.var("Y").get(),8),4)) {
          //<< . . if $extract(YPARA(2))'="," set YPARA(19)=YPARA(44)_""""_YPARA(5)_""",1)"
          if (mOp.NotEqual(m$.Fnc.$extract(YPARA.var(2).get()),",")) {
            YPARA.var(19).set(mOp.Concat(mOp.Concat(mOp.Concat(YPARA.var(44).get(),"\""),YPARA.var(5).get()),"\",1)"));
          }
          //<< . . if $extract(YPARA(2))=","  set YPARA(19)=YPARA(44)_""""_YPARA(5)_""","""_@$piece(YPARA(2),",",2)_""",1)"  ;WAC;10.12.2004 WENN REALTION ,SPRACHE ALS Relations-Primärschlüssel
          if (mOp.Equal(m$.Fnc.$extract(YPARA.var(2).get()),",")) {
            YPARA.var(19).set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(YPARA.var(44).get(),"\""),YPARA.var(5).get()),"\",\""),m$.indirectVar(m$.Fnc.$piece(YPARA.var(2).get(),",",2)).get()),"\",1)"));
          }
        }
        //<< . ;
        //<< . //IF $EXTRACT(YPARA(2))'="," IF YSKPR(1)'="" IF $PIECE(YDATA,Y,8)'=4 IF $DATA(@(YSKPR(1))) SET YPARA(7)=YPARA(7)-1 QUIT  ;NUR WENN SORTKEY VORHANDEN ODER GLEICH ;only when on hand Or without delay
        //<< . if YSKPR="" if $extract(YPARA(2))'="," if YSKPR(1)'="" if $piece(YDATA,Y,8)'=4 if $data(@(YSKPR(1))) set YPARA(7)=YPARA(7)-1 quit  ; SR14508: Don't check for space if we want an actual match (below)
        if (mOp.Equal(YSKPR.get(),"")) {
          if (mOp.NotEqual(m$.Fnc.$extract(YPARA.var(2).get()),",")) {
            if (mOp.NotEqual(YSKPR.var(1).get(),"")) {
              if (mOp.NotEqual(m$.Fnc.$piece(YDATA.get(),m$.var("Y").get(),8),4)) {
                if (mOp.Logical(m$.Fnc.$data(m$.indirectVar((YSKPR.var(1).get()))))) {
                  YPARA.var(7).set(mOp.Subtract(YPARA.var(7).get(),1));
                  break;
                }
              }
            }
          }
        }
        //<< . ;
        //<< . ;IF YSKPR(1)'="" IF $PIECE(YDATA,Y,8)'=4 IF $DATA(@(YSKPR(1))) SET YPARA(7)=YPARA(7)-1 QUIT  ;NUR WENN SORTKEY VORHANDEN ODER GLEICH ;only when on hand Or without delay
        //<< . if YSKPR'="" if $piece(YDATA,Y,8)'=4 if '$data(@(YSKPR)) set YPARA(7)=YPARA(7)-1 quit  ;NUR WENN SORTKEY VORHANDEN ODER GLEICH ;only when on hand Or without delay
        if (mOp.NotEqual(YSKPR.get(),"")) {
          if (mOp.NotEqual(m$.Fnc.$piece(YDATA.get(),m$.var("Y").get(),8),4)) {
            if (mOp.Not(m$.Fnc.$data(m$.indirectVar((YSKPR.get()))))) {
              YPARA.var(7).set(mOp.Subtract(YPARA.var(7).get(),1));
              break;
            }
          }
        }
        //<< . ;
        //<< . ;MEHRFACHANZEIGEN SUCHEN (YPARA(3)) ;seek
        //<< . new YSORTXD
        mVar YSORTXD = m$.var("YSORTXD");
        m$.newVar(YSORTXD);
        //<< . if YFILE'=YPARA(1) set YPARA(19)="^"_YPARA(1)_"("_$piece(YPARA(19),"(",2,99)
        if (mOp.NotEqual(YFILE.get(),YPARA.var(1).get())) {
          YPARA.var(19).set(mOp.Concat(mOp.Concat(mOp.Concat("^",YPARA.var(1).get()),"("),m$.Fnc.$piece(YPARA.var(19).get(),"(",2,99)));
        }
        //<< . set YSORTXD=$$^WWWSETL(YPARA(19))   ;WERTE LESEN  ;read
        YSORTXD.set(m$.fnc$("WWWSETL.main",YPARA.var(19).get()));
        //<< . if YUCI="INTRAPREND" if YPARA(1)="WWW013" if +$piece(YSORTXD,Y,35)'=0 if $piece(YSORTXD,Y,35)<$horolog set YPARA(7)=YPARA(7)-1 quit  ;MITARBEITER AUSGESCHIEDEN
        if (mOp.Equal(m$.var("YUCI").get(),"INTRAPREND")) {
          if (mOp.Equal(YPARA.var(1).get(),"WWW013")) {
            if (mOp.NotEqual(mOp.Positive(m$.Fnc.$piece(YSORTXD.get(),m$.var("Y").get(),35)),0)) {
              if (mOp.Less(m$.Fnc.$piece(YSORTXD.get(),m$.var("Y").get(),35),m$.Fnc.$horolog())) {
                YPARA.var(7).set(mOp.Subtract(YPARA.var(7).get(),1));
                break;
              }
            }
          }
        }
        //<< . set YSORT=""
        mVar YSORT = m$.var("YSORT");
        YSORT.set("");
        //<< . ;
        //<< . ; Calculated Fields
        //<< . if $get(YPARA("CF"))'=""  do
        if (mOp.NotEqual(m$.Fnc.$get(YPARA.var("CF")),"")) {
          //<< . . for YPARA(88)=1:1 quit:$piece(YPARA("CF"),",",YPARA(88))=""  do
          for (m$.var("YPARA",88).set(1);(true);m$.var("YPARA",88).set(mOp.Add(m$.var("YPARA",88).get(),1))) {
            if (mOp.Equal(m$.Fnc.$piece(YPARA.var("CF").get(),",",YPARA.var(88).get()),"")) {
              break;
            }
            //<< . . . set idField = $piece(YPARA("CF"),",",YPARA(88))
            mVar idField = m$.var("idField");
            idField.set(m$.Fnc.$piece(YPARA.var("CF").get(),",",YPARA.var(88).get()));
            //<< . . . if idField set YSORT=YSORT_$$GetCalculatedValue(YPARA(1),idField,YPARA(2)_","_YPARA(5),YSORTXD)
            if (mOp.Logical(idField.get())) {
              YSORT.set(mOp.Concat(YSORT.get(),m$.fnc$("GetCalculatedValue",YPARA.var(1).get(),idField.get(),mOp.Concat(mOp.Concat(YPARA.var(2).get(),","),YPARA.var(5).get()),YSORTXD.get())));
            }
          }
        }
        //<< . ;
        //<< . for YPARA(88)=1:1 quit:$piece(YPARA(3),",",YPARA(88))=""  do
        for (m$.var("YPARA",88).set(1);(true);m$.var("YPARA",88).set(mOp.Add(m$.var("YPARA",88).get(),1))) {
          if (mOp.Equal(m$.Fnc.$piece(YPARA.var(3).get(),",",YPARA.var(88).get()),"")) {
            break;
          }
          do {
            //<< . . new YSORTX,YSORTX1,YSORTX2,YSORTX3
            mVar YSORTX = m$.var("YSORTX");
            mVar YSORTX1 = m$.var("YSORTX1");
            mVar YSORTX2 = m$.var("YSORTX2");
            mVar YSORTX3 = m$.var("YSORTX3");
            m$.newVar(YSORTX,YSORTX1,YSORTX2,YSORTX3);
            //<< . . set YSORTX=$piece(YSORTXD,Y,$piece(YPARA(3),",",YPARA(88)))   ;FELD LESEN  ;field read
            YSORTX.set(m$.Fnc.$piece(YSORTXD.get(),m$.var("Y").get(),m$.Fnc.$piece(YPARA.var(3).get(),",",YPARA.var(88).get())));
            //<< . . ;
            //<< . . if $get(YPARA(79))'="" do  ;MARKIERUNG
            if (mOp.NotEqual(m$.Fnc.$get(YPARA.var(79)),"")) {
              //<< . . . if +$piece($$^WWWSETL(YPARA(19)),Y,YPARA(79))=1 if $length(YPARA(80))<10000 set YPARA(80)=YPARA(80)_YPARA(5)_","  ; red
              if (mOp.Equal(mOp.Positive(m$.Fnc.$piece(m$.fnc$("WWWSETL.main",YPARA.var(19).get()),m$.var("Y").get(),YPARA.var(79).get())),1)) {
                if (mOp.Less(m$.Fnc.$length(YPARA.var(80).get()),10000)) {
                  YPARA.var(80).set(mOp.Concat(mOp.Concat(YPARA.var(80).get(),YPARA.var(5).get()),","));
                }
              }
              //<< . . . if +$piece($$^WWWSETL(YPARA(19)),Y,YPARA(79))=2 if $length(YPARA(81))<10000 set YPARA(81)=YPARA(81)_YPARA(5)_","  ; yellow
              if (mOp.Equal(mOp.Positive(m$.Fnc.$piece(m$.fnc$("WWWSETL.main",YPARA.var(19).get()),m$.var("Y").get(),YPARA.var(79).get())),2)) {
                if (mOp.Less(m$.Fnc.$length(YPARA.var(81).get()),10000)) {
                  YPARA.var(81).set(mOp.Concat(mOp.Concat(YPARA.var(81).get(),YPARA.var(5).get()),","));
                }
              }
              //<< . . . if +$piece($$^WWWSETL(YPARA(19)),Y,YPARA(79))=3 if $length(YPARA(82))<10000 set YPARA(82)=YPARA(82)_YPARA(5)_","  ; green
              if (mOp.Equal(mOp.Positive(m$.Fnc.$piece(m$.fnc$("WWWSETL.main",YPARA.var(19).get()),m$.var("Y").get(),YPARA.var(79).get())),3)) {
                if (mOp.Less(m$.Fnc.$length(YPARA.var(82).get()),10000)) {
                  YPARA.var(82).set(mOp.Concat(mOp.Concat(YPARA.var(82).get(),YPARA.var(5).get()),","));
                }
              }
              //<< . . . if +$piece($$^WWWSETL(YPARA(19)),Y,YPARA(79))=4 if $length(YPARA(83))<10000 set YPARA(83)=YPARA(83)_YPARA(5)_","  ; blue
              if (mOp.Equal(mOp.Positive(m$.Fnc.$piece(m$.fnc$("WWWSETL.main",YPARA.var(19).get()),m$.var("Y").get(),YPARA.var(79).get())),4)) {
                if (mOp.Less(m$.Fnc.$length(YPARA.var(83).get()),10000)) {
                  YPARA.var(83).set(mOp.Concat(mOp.Concat(YPARA.var(83).get(),YPARA.var(5).get()),","));
                }
              }
              //<< . . . if +$piece($$^WWWSETL(YPARA(19)),Y,YPARA(79))=5 if $length(YPARA(84))<10000 set YPARA(84)=YPARA(84)_YPARA(5)_","  ; gray
              if (mOp.Equal(mOp.Positive(m$.Fnc.$piece(m$.fnc$("WWWSETL.main",YPARA.var(19).get()),m$.var("Y").get(),YPARA.var(79).get())),5)) {
                if (mOp.Less(m$.Fnc.$length(YPARA.var(84).get()),10000)) {
                  YPARA.var(84).set(mOp.Concat(mOp.Concat(YPARA.var(84).get(),YPARA.var(5).get()),","));
                }
              }
            }
            //<< . . ;
            //<< . . set YSORTX2=$get(^WWW003(0,YPARA(1),$piece(YPARA(3),",",YPARA(88)),1))   ;AUS DATENSATZDEFINITION ;out of
            YSORTX2.set(m$.Fnc.$get(m$.var("^WWW003",0,YPARA.var(1).get(),m$.Fnc.$piece(YPARA.var(3).get(),",",YPARA.var(88).get()),1)));
            //<< . . set YSORTX1=$piece(YSORTX2,Y,3)   ;FELDART DER DATENFELDES ;the
            YSORTX1.set(m$.Fnc.$piece(YSORTX2.get(),m$.var("Y").get(),3));
            //<< . . set YSORTX4=$piece(YSORTX2,Y,4)   ;LÄNGE DES FELDES ;length
            mVar YSORTX4 = m$.var("YSORTX4");
            YSORTX4.set(m$.Fnc.$piece(YSORTX2.get(),m$.var("Y").get(),4));
            //<< . . ;I $F(YPARA(2),",") I YSORTX4>25 S YSORTX4=25  ;MAXIMALE LÄNGE
            //<< . . if +$piece(YPARA(52),",",YPARA(88))'=0 set YSORTX4=+$piece(YPARA(52),",",YPARA(88))   ;MANUELLE LÄNGE DER RELATION ;length
            if (mOp.NotEqual(mOp.Positive(m$.Fnc.$piece(YPARA.var(52).get(),",",YPARA.var(88).get())),0)) {
              YSORTX4.set(mOp.Positive(m$.Fnc.$piece(YPARA.var(52).get(),",",YPARA.var(88).get())));
            }
            //<< . . if YPARA(88)'=1 set YPARA(55)=2  ;MEHRERE PARAMETER IN DER ANZEIGE! ;divers parameter within the
            if (mOp.NotEqual(YPARA.var(88).get(),1)) {
              YPARA.var(55).set(2);
            }
            //<< . .
            //<< . . if YSORTX'="" if $piece(YSORTX2,Y,8)'="" do  quit   ;WENN PARAMETER DES EINTRAGS ;when parameter
            if (mOp.NotEqual(YSORTX.get(),"")) {
              if (mOp.NotEqual(m$.Fnc.$piece(YSORTX2.get(),m$.var("Y").get(),8),"")) {
                do {
                  //<< . . . new YFILE,YDATA
                  m$.newVar(YFILE,YDATA);
                  //<< . . . set YDATA="" if $extract($piece(YSORTX2,Y,8),1,2)'="IN" if $extract($piece(YSORTX2,Y,8),1,3)'="WWW" set YDATA=$get(^WWW001(0,$piece(YSORTX2,Y,8),1))  ;VARIABEL AUS DATENSATZDEF.  FELD 8=DATEIART ;out of field
                  YDATA.set("");
                  if (mOp.NotEqual(m$.Fnc.$extract(m$.Fnc.$piece(YSORTX2.get(),m$.var("Y").get(),8),1,2),"IN")) {
                    if (mOp.NotEqual(m$.Fnc.$extract(m$.Fnc.$piece(YSORTX2.get(),m$.var("Y").get(),8),1,3),"WWW")) {
                      YDATA.set(m$.Fnc.$get(m$.var("^WWW001",0,m$.Fnc.$piece(YSORTX2.get(),m$.var("Y").get(),8),1)));
                    }
                  }
                  //<< . . . set YFILE=$piece(YSORTX2,Y,8)
                  YFILE.set(m$.Fnc.$piece(YSORTX2.get(),m$.var("Y").get(),8));
                  //<< . . . if $piece(YDATA,Y,22)'="" set YFILE=$piece(YDATA,Y,22)  ;ANDERE DATEI ;data file
                  if (mOp.NotEqual(m$.Fnc.$piece(YDATA.get(),m$.var("Y").get(),22),"")) {
                    YFILE.set(m$.Fnc.$piece(YDATA.get(),m$.var("Y").get(),22));
                  }
                  //<< . . . set YSORTX3="^"_YFILE_"("_$$^WWWYM($piece(YSORTX2,Y,8))_","
                  YSORTX3.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("^",YFILE.get()),"("),m$.fnc$("WWWYM.main",m$.Fnc.$piece(YSORTX2.get(),m$.var("Y").get(),8))),","));
                  //<< . . . if $piece(YDATA,Y,12)'="" if $piece(YDATA,Y,13)'="" do  ;UCI & VOL
                  if (mOp.NotEqual(m$.Fnc.$piece(YDATA.get(),m$.var("Y").get(),12),"")) {
                    if (mOp.NotEqual(m$.Fnc.$piece(YDATA.get(),m$.var("Y").get(),13),"")) {
                      do {
                        //<< . . . . quit:$find(YSORTX3,"^[")
                        if (mOp.Logical(m$.Fnc.$find(YSORTX3.get(),"^["))) {
                          break;
                        }
                        //<< . . . . set YSORTX3="^["""_$piece(YDATA,Y,12)_""","""_$piece(YDATA,Y,13)_"""]"_$piece(YSORTX3,"^",2,999)
                        YSORTX3.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("^[\"",m$.Fnc.$piece(YDATA.get(),m$.var("Y").get(),12)),"\",\""),m$.Fnc.$piece(YDATA.get(),m$.var("Y").get(),13)),"\"]"),m$.Fnc.$piece(YSORTX3.get(),"^",2,999)));
                      } while (false);
                    }
                  }
                  //<< . . . ;
                  //<< . . . if $piece(YSORTX2,Y,9)'="" set:'$find($piece(YSORTX2,Y,9),"""") YPARA(7)=YPARA(7)-1 quit:'$find($piece(YSORTX2,Y,9),"""")  set YSORTX3=YSORTX3_$piece(YSORTX2,Y,9)_","
                  if (mOp.NotEqual(m$.Fnc.$piece(YSORTX2.get(),m$.var("Y").get(),9),"")) {
                    if (mOp.Not(m$.Fnc.$find(m$.Fnc.$piece(YSORTX2.get(),m$.var("Y").get(),9),"\""))) {
                      YPARA.var(7).set(mOp.Subtract(YPARA.var(7).get(),1));
                    }
                    if (mOp.Not(m$.Fnc.$find(m$.Fnc.$piece(YSORTX2.get(),m$.var("Y").get(),9),"\""))) {
                      break;
                    }
                    YSORTX3.set(mOp.Concat(mOp.Concat(YSORTX3.get(),m$.Fnc.$piece(YSORTX2.get(),m$.var("Y").get(),9)),","));
                  }
                  //<< . . . set YSORTX3=YSORTX3_""""_YSORTX_""""
                  YSORTX3.set(mOp.Concat(mOp.Concat(mOp.Concat(YSORTX3.get(),"\""),YSORTX.get()),"\""));
                  //<< . . . if $piece(YDATA,Y,8)'=4 set YSORTX3=YSORTX3_",1)"
                  if (mOp.NotEqual(m$.Fnc.$piece(YDATA.get(),m$.var("Y").get(),8),4)) {
                    YSORTX3.set(mOp.Concat(YSORTX3.get(),",1)"));
                  }
                  //<< . . . if $piece(YDATA,Y,8)=4  set YSORTX3=YSORTX3_")"
                  if (mOp.Equal(m$.Fnc.$piece(YDATA.get(),m$.var("Y").get(),8),4)) {
                    YSORTX3.set(mOp.Concat(YSORTX3.get(),")"));
                  }
                  //<< . . . if YFILE'=$piece(YSORTX2,Y,8) set YSORTX3="^"_$piece(YSORTX2,Y,8)_"("_$piece(YSORTX3,"(",2,99)
                  if (mOp.NotEqual(YFILE.get(),m$.Fnc.$piece(YSORTX2.get(),m$.var("Y").get(),8))) {
                    YSORTX3.set(mOp.Concat(mOp.Concat(mOp.Concat("^",m$.Fnc.$piece(YSORTX2.get(),m$.var("Y").get(),8)),"("),m$.Fnc.$piece(YSORTX3.get(),"(",2,99)));
                  }
                  //<< . . . set YSORTXX=$piece($$^WWWSETL(YSORTX3),Y,$piece($piece(YSORTX2,Y,10),",",1))
                  mVar YSORTXX = m$.var("YSORTXX");
                  YSORTXX.set(m$.Fnc.$piece(m$.fnc$("WWWSETL.main",YSORTX3.get()),m$.var("Y").get(),m$.Fnc.$piece(m$.Fnc.$piece(YSORTX2.get(),m$.var("Y").get(),10),",",1)));
                  //<< . . . set YSORT=YSORT_YSORTXX_" "
                  YSORT.set(mOp.Concat(mOp.Concat(YSORT.get(),YSORTXX.get())," "));
                } while (false);
                break;
              }
            }
            //<< . . ;
            //<< . . ;ZUSAMMENBAU DER ANZEIGEZEILE OHNE PARAMETER ;the without parameter
            //<< . . set YSORT=YSORT_$$GetLiteral^WWWTR(YSORTX1,YSORTX)_" "
            YSORT.set(mOp.Concat(mOp.Concat(YSORT.get(),m$.fnc$("WWWTR.GetLiteral",YSORTX1.get(),YSORTX.get()))," "));
          } while (false);
        }
        //<< . ;
        //<< . ;
        //<< . ;ZUSAMMENSTELLEN
        //<< . if YSORT="" set YSORT=" "
        if (mOp.Equal(YSORT.get(),"")) {
          YSORT.set(" ");
        }
        //<< . set YSORT(1)=YSORT
        YSORT.var(1).set(YSORT.get());
        //<< . ;
        //<< . ;UNTERSCHIEDLICHE SPRACHE ;Language
        //<< . if YPARA(0)'="" do
        if (mOp.NotEqual(YPARA.var(0).get(),"")) {
          do {
            //<< . . set YPARA(99)="^"_YPARA(0)_"("_$$^WWWYM(YPARA(1),1)
            YPARA.var(99).set(mOp.Concat(mOp.Concat(mOp.Concat("^",YPARA.var(0).get()),"("),m$.fnc$("WWWYM.main",YPARA.var(1).get(),1)));
            //<< . . if $piece(YDATA,Y,12)'="" if $piece(YDATA,Y,13)'="" do  ;UCI UND VOL ;UCI And
            if (mOp.NotEqual(m$.Fnc.$piece(YDATA.get(),m$.var("Y").get(),12),"")) {
              if (mOp.NotEqual(m$.Fnc.$piece(YDATA.get(),m$.var("Y").get(),13),"")) {
                do {
                  //<< . . . quit:$find(YPARA(99),"^[")
                  if (mOp.Logical(m$.Fnc.$find(YPARA.var(99).get(),"^["))) {
                    break;
                  }
                  //<< . . . set YPARA(99)="^["""_$piece(YDATA,Y,12)_""","""_$piece(YDATA,Y,13)_"""]"_$piece(YPARA(99),"^",2,999)
                  YPARA.var(99).set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("^[\"",m$.Fnc.$piece(YDATA.get(),m$.var("Y").get(),12)),"\",\""),m$.Fnc.$piece(YDATA.get(),m$.var("Y").get(),13)),"\"]"),m$.Fnc.$piece(YPARA.var(99).get(),"^",2,999)));
                } while (false);
              }
            }
            //<< . . ;
            //<< . . set Q=0
            Q.set(0);
            //<< . . for YI=1:1 set YPARA(9)=$piece(YPARA(2),",",YI) quit:YPARA(9)=""  set YPARA(99)=YPARA(99)_YPARA(9)_"," if $extract(YPARA(9))'="""" if $get(@(YPARA(9)))="" set Q=1 quit
            for (YI.set(1);(true);YI.set(mOp.Add(YI.get(),1))) {
              YPARA.var(9).set(m$.Fnc.$piece(YPARA.var(2).get(),",",YI.get()));
              if (mOp.Equal(YPARA.var(9).get(),"")) {
                break;
              }
              YPARA.var(99).set(mOp.Concat(mOp.Concat(YPARA.var(99).get(),YPARA.var(9).get()),","));
              if (mOp.NotEqual(m$.Fnc.$extract(YPARA.var(9).get()),"\"")) {
                if (mOp.Equal(m$.Fnc.$get(m$.indirectVar((YPARA.var(9).get()))),"")) {
                  Q.set(1);
                  break;
                }
              }
            }
            //<< . . if Q=1 set Q=0 quit
            if (mOp.Equal(Q.get(),1)) {
              Q.set(0);
              break;
            }
            //<< . . set YPARA(99)=YPARA(99)_"YPARA(5),"""_SPRACHE_""",1)"
            YPARA.var(99).set(mOp.Concat(mOp.Concat(mOp.Concat(YPARA.var(99).get(),"YPARA(5),\""),m$.var("SPRACHE").get()),"\",1)"));
            //<< . . if $data(@(YPARA(99)))#10'=1 quit  ;KEIN SATZ ;no typesetting
            if (mOp.NotEqual(mOp.Modulus(m$.Fnc.$data(m$.indirectVar((YPARA.var(99).get()))),10),1)) {
              break;
            }
            //<< . . set YSORT=$piece($get(@YPARA(99)),Y,1)
            YSORT.set(m$.Fnc.$piece(m$.Fnc.$get(m$.indirectVar(YPARA.var(99).get())),m$.var("Y").get(),1));
            //<< . . if YSORT="" set YSORT=" "
            if (mOp.Equal(YSORT.get(),"")) {
              YSORT.set(" ");
            }
            //<< . . set YSORT(1)=YSORT
            YSORT.var(1).set(YSORT.get());
          } while (false);
        }
        //<< .
        //<< . set YSORT = $$CheckFreeFields(YSORT,YPARA(1),YPARA(2),YPARA(5))   ;BR014594
        YSORT.set(m$.fnc$("CheckFreeFields",YSORT.get(),YPARA.var(1).get(),YPARA.var(2).get(),YPARA.var(5).get()));
        //<< . ;SORTIERUNG ;sorting
        //<< . if +YPARA(12)=0 set YSORT(1)=YPARA(5)  ;NICHT SORTIERT ;Not
        if (mOp.Equal(mOp.Positive(YPARA.var(12).get()),0)) {
          YSORT.var(1).set(YPARA.var(5).get());
        }
        //<< . set YSORT=$extract($translate(YSORT,"|"," "),1,100)
        YSORT.set(m$.Fnc.$extract(m$.Fnc.$translate(YSORT.get(),"|"," "),1,100));
        //<< . ;
        //<< . ; YPARA(20) "Relation Display Options" = 1 : "Display Relations after Input"
        //<< . ;
        //<< . if YXTYP'=6 if YPARA(20)=1 if YXTYP'=1 do  if YPARA(22)=1 set YPARA(7)=YPARA(7)-1 quit
        if (mOp.NotEqual(m$.var("YXTYP").get(),6)) {
          if (mOp.Equal(YPARA.var(20).get(),1)) {
            if (mOp.NotEqual(m$.var("YXTYP").get(),1)) {
              //<< . . new YYI
              mVar YYI = m$.var("YYI");
              m$.newVar(YYI);
              //<< . . set YPARA(22)=1
              YPARA.var(22).set(1);
              //<< . . if YUMLAU=""  if $find($translate(YPARA(5),LC,UC),$translate(YINHALT,LC,UC)) set YPARA(21)=YPARA(21)+1,YPARA(22)=0
              if (mOp.Equal(m$.var("YUMLAU").get(),"")) {
                if (mOp.Logical(m$.Fnc.$find(m$.Fnc.$translate(YPARA.var(5).get(),LC.get(),UC.get()),m$.Fnc.$translate(m$.var("YINHALT").get(),LC.get(),UC.get())))) {
                  YPARA.var(21).set(mOp.Add(YPARA.var(21).get(),1));
                  YPARA.var(22).set(0);
                }
              }
              //<< . . if YUMLAU'="" if $find($$^WWWUMLAU(YPARA(5),1),$$^WWWUMLAU(YINHALT,1))       set YPARA(21)=YPARA(21)+1,YPARA(22)=0
              if (mOp.NotEqual(m$.var("YUMLAU").get(),"")) {
                if (mOp.Logical(m$.Fnc.$find(m$.fnc$("WWWUMLAU.main",YPARA.var(5).get(),1),m$.fnc$("WWWUMLAU.main",m$.var("YINHALT").get(),1)))) {
                  YPARA.var(21).set(mOp.Add(YPARA.var(21).get(),1));
                  YPARA.var(22).set(0);
                }
              }
              if (mOp.Equal(YPARA.var(22).get(),1)) {
                YPARA.var(7).set(mOp.Subtract(YPARA.var(7).get(),1));
                break;
              }
            }
          }
        }
        //<< . ;
        //<< . if YXTYP=6 if YPARA(20)=1 do  if YPARA(22)=1 set YPARA(7)=YPARA(7)-1 quit
        if (mOp.Equal(m$.var("YXTYP").get(),6)) {
          if (mOp.Equal(YPARA.var(20).get(),1)) {
            //<< . . new YYI
            mVar YYI = m$.var("YYI");
            m$.newVar(YYI);
            //<< . . set YPARA(22)=1
            YPARA.var(22).set(1);
            //<< . . if YUMLAU=""  for YYI=1:1 quit:$piece(YINHALT,",",YYI)=""  if $find($translate(YPARA(5),LC,UC),$translate($piece(YINHALT,",",YYI),LC,UC)) set YPARA(21)=YPARA(21)+1,YPARA(22)=0 quit
            if (mOp.Equal(m$.var("YUMLAU").get(),"")) {
              for (YYI.set(1);(true);YYI.set(mOp.Add(YYI.get(),1))) {
                if (mOp.Equal(m$.Fnc.$piece(m$.var("YINHALT").get(),",",YYI.get()),"")) {
                  break;
                }
                if (mOp.Logical(m$.Fnc.$find(m$.Fnc.$translate(YPARA.var(5).get(),LC.get(),UC.get()),m$.Fnc.$translate(m$.Fnc.$piece(m$.var("YINHALT").get(),",",YYI.get()),LC.get(),UC.get())))) {
                  YPARA.var(21).set(mOp.Add(YPARA.var(21).get(),1));
                  YPARA.var(22).set(0);
                  break;
                }
              }
            }
            //<< . . if YUMLAU'="" for YYI=1:1 quit:$piece(YINHALT,",",YYI)=""  if $find($$^WWWUMLAU(YPARA(5),1),$$^WWWUMLAU($piece(YINHALT,",",YYI),1)) set YPARA(21)=YPARA(21)+1,YPARA(22)=0 quit
            if (mOp.NotEqual(m$.var("YUMLAU").get(),"")) {
              for (YYI.set(1);(true);YYI.set(mOp.Add(YYI.get(),1))) {
                if (mOp.Equal(m$.Fnc.$piece(m$.var("YINHALT").get(),",",YYI.get()),"")) {
                  break;
                }
                if (mOp.Logical(m$.Fnc.$find(m$.fnc$("WWWUMLAU.main",YPARA.var(5).get(),1),m$.fnc$("WWWUMLAU.main",m$.Fnc.$piece(m$.var("YINHALT").get(),",",YYI.get()),1)))) {
                  YPARA.var(21).set(mOp.Add(YPARA.var(21).get(),1));
                  YPARA.var(22).set(0);
                  break;
                }
              }
            }
            if (mOp.Equal(YPARA.var(22).get(),1)) {
              YPARA.var(7).set(mOp.Subtract(YPARA.var(7).get(),1));
              break;
            }
          }
        }
        //<< . ;
        //<< . if YXTYP=1 if YPARA(20)=1 do  if YPARA(22)=1 set YPARA(7)=YPARA(7)-1 quit
        if (mOp.Equal(m$.var("YXTYP").get(),1)) {
          if (mOp.Equal(YPARA.var(20).get(),1)) {
            //<< . . new YYI
            mVar YYI = m$.var("YYI");
            m$.newVar(YYI);
            //<< . . set YPARA(22)=1
            YPARA.var(22).set(1);
            //<< . . if YUMLAU=""  for YYI=1:1 quit:$piece(YINHALT,",",YYI)=""  if $translate(YPARA(5),LC,UC)=$translate($piece(YINHALT,",",YYI),LC,UC) set YPARA(21)=1,YPARA(22)=0,YPARA(7)=1 quit
            if (mOp.Equal(m$.var("YUMLAU").get(),"")) {
              for (YYI.set(1);(true);YYI.set(mOp.Add(YYI.get(),1))) {
                if (mOp.Equal(m$.Fnc.$piece(m$.var("YINHALT").get(),",",YYI.get()),"")) {
                  break;
                }
                if (mOp.Equal(m$.Fnc.$translate(YPARA.var(5).get(),LC.get(),UC.get()),m$.Fnc.$translate(m$.Fnc.$piece(m$.var("YINHALT").get(),",",YYI.get()),LC.get(),UC.get()))) {
                  YPARA.var(21).set(1);
                  YPARA.var(22).set(0);
                  YPARA.var(7).set(1);
                  break;
                }
              }
            }
            //<< . . if YUMLAU'="" for YYI=1:1 quit:$piece(YINHALT,",",YYI)=""  if $$^WWWUMLAU(YPARA(5),1)=$$^WWWUMLAU($piece(YINHALT,",",YYI),1) set YPARA(21)=1,YPARA(22)=0,YPARA(7)=1 quit
            if (mOp.NotEqual(m$.var("YUMLAU").get(),"")) {
              for (YYI.set(1);(true);YYI.set(mOp.Add(YYI.get(),1))) {
                if (mOp.Equal(m$.Fnc.$piece(m$.var("YINHALT").get(),",",YYI.get()),"")) {
                  break;
                }
                if (mOp.Equal(m$.fnc$("WWWUMLAU.main",YPARA.var(5).get(),1),m$.fnc$("WWWUMLAU.main",m$.Fnc.$piece(m$.var("YINHALT").get(),",",YYI.get()),1))) {
                  YPARA.var(21).set(1);
                  YPARA.var(22).set(0);
                  YPARA.var(7).set(1);
                  break;
                }
              }
            }
            if (mOp.Equal(YPARA.var(22).get(),1)) {
              YPARA.var(7).set(mOp.Subtract(YPARA.var(7).get(),1));
              break;
            }
          }
        }
        //<< . ;
        //<< . set YPARA(53)=YPARA(5)
        YPARA.var(53).set(YPARA.var(5).get());
        //<< . if YPARA(555)=1  set YPARA(53)=$$^WWWDATE(YPARA(53))  ;DATUM IM KEY ;Date KEY
        if (mOp.Equal(YPARA.var(555).get(),1)) {
          YPARA.var(53).set(m$.fnc$("WWWDATE.main",YPARA.var(53).get()));
        }
        //<< . if +YPARA(51)'=0 set YPARA(53)=$extract(YPARA(53)_"                                       ",1,$length(YPARA(51)))  ;LÄNGE PRIMÄRSCHLÜSSEL ;longitude
        if (mOp.NotEqual(mOp.Positive(YPARA.var(51).get()),0)) {
          YPARA.var(53).set(m$.Fnc.$extract(mOp.Concat(YPARA.var(53).get(),"                                       "),1,m$.Fnc.$length(YPARA.var(51).get())));
        }
        //<< . ;
        //<< . if $find(YSORT,"m2") set YSORT=$piece(YSORT,"m2",1)_"m²"_$piece(YSORT,"m2",2,99)
        if (mOp.Logical(m$.Fnc.$find(YSORT.get(),"m2"))) {
          YSORT.set(mOp.Concat(mOp.Concat(m$.Fnc.$piece(YSORT.get(),"m2",1),"m²"),m$.Fnc.$piece(YSORT.get(),"m2",2,99)));
        }
        //<< . if $find(YSORT,"m3") set YSORT=$piece(YSORT,"m3",1)_"m³"_$piece(YSORT,"m3",2,99)
        if (mOp.Logical(m$.Fnc.$find(YSORT.get(),"m3"))) {
          YSORT.set(mOp.Concat(mOp.Concat(m$.Fnc.$piece(YSORT.get(),"m3",1),"m³"),m$.Fnc.$piece(YSORT.get(),"m3",2,99)));
        }
        //<< . ;
        //<< . set YPARA("ANZ")=$get(YPARA("ANZ"))+1  ;TYBD;18,2,2004
        YPARA.var("ANZ").set(mOp.Add(m$.Fnc.$get(YPARA.var("ANZ")),1));
        //<< . if $get(YPARA(120))'=1 do  ;TYBD;21,8,2004;SCHLÜSSEL ANZEIGE J/N;26262
        if (mOp.NotEqual(m$.Fnc.$get(YPARA.var(120)),1)) {
          do {
            //<< . . if $extract(YPARA(2))'="""" if +YPARA(12)'=0 do  ;wenn Parameter ;when Parameters
            if (mOp.NotEqual(m$.Fnc.$extract(YPARA.var(2).get()),"\"")) {
              if (mOp.NotEqual(mOp.Positive(YPARA.var(12).get()),0)) {
                do {
                  //<< . . . if '$find(YPARA(53),"---------------") set ^WWWSOR(YUSER,2,$$^WWWUMLAU(YSORT(1),3)_" ",YPARA(5))=YSORT_" - "_YPARA(53)_" " quit  ;$$^WWWUML(YSORT_" - "_YPARA(53)_" ") QUIT  ;BEI PARAMETERN
                  if (mOp.Not(m$.Fnc.$find(YPARA.var(53).get(),"---------------"))) {
                    m$.var("^WWWSOR",m$.var("YUSER").get(),2,mOp.Concat(m$.fnc$("WWWUMLAU.main",YSORT.var(1).get(),3)," "),YPARA.var(5).get()).set(mOp.Concat(mOp.Concat(mOp.Concat(YSORT.get()," - "),YPARA.var(53).get())," "));
                    break;
                  }
                  //<< . . . if $find(YPARA(53),"---------------")  set ^WWWSOR(YUSER,2,$$^WWWUMLAU(YSORT(1),3)_" ",YPARA(5))=YPARA(53)_" "             quit  ;$$^WWWUML(YSORT_" - "_YPARA(53)_" ") QUIT  ;BEI PARAMETERN
                  if (mOp.Logical(m$.Fnc.$find(YPARA.var(53).get(),"---------------"))) {
                    m$.var("^WWWSOR",m$.var("YUSER").get(),2,mOp.Concat(m$.fnc$("WWWUMLAU.main",YSORT.var(1).get(),3)," "),YPARA.var(5).get()).set(mOp.Concat(YPARA.var(53).get()," "));
                    break;
                  }
                } while (false);
              }
            }
            //<< . . ;
            //<< . . if $extract(YPARA(2))="""" if +YPARA(12)'=0 do  quit  ;SORTIERT
            if (mOp.Equal(m$.Fnc.$extract(YPARA.var(2).get()),"\"")) {
              if (mOp.NotEqual(mOp.Positive(YPARA.var(12).get()),0)) {
                do {
                  //<< . . . if +YPARA(5)'=0!(YPARA(5)=0) set ^WWWSOR(YUSER,2,$$^WWWUMLAU(YSORT(1),3)_" ",YPARA(5))=" "_YSORT_" " quit   ;$$^WWWUML(" "_YSORT_" ") QUIT   ;BEI PARAMETERN OHNE PARAMETERANGABE BEI ZAHLEN
                  if (mOp.Or(mOp.NotEqual(mOp.Positive(YPARA.var(5).get()),0),(mOp.Equal(YPARA.var(5).get(),0)))) {
                    m$.var("^WWWSOR",m$.var("YUSER").get(),2,mOp.Concat(m$.fnc$("WWWUMLAU.main",YSORT.var(1).get(),3)," "),YPARA.var(5).get()).set(mOp.Concat(mOp.Concat(" ",YSORT.get())," "));
                    break;
                  }
                  //<< . . . if +YPARA(5)=0 if YPARA(5)'=0 do
                  if (mOp.Equal(mOp.Positive(YPARA.var(5).get()),0)) {
                    if (mOp.NotEqual(YPARA.var(5).get(),0)) {
                      do {
                        //<< . . . . if $$$UPPER(YPARA(53))'=$$$UPPER(YPARA(5)) if '$find(YPARA(53),"---------------") set ^WWWSOR(YUSER,2,$$^WWWUMLAU(YSORT(1),3)_" ",YPARA(5))=" "_YSORT_"-"_YPARA(53)_" " quit    ;WENN GLEICH DANN NICHT ;TYBD;1,8,2007;25508;$$^WWWUML(" "_YSORT_"-"_YPARA(53)_" ") QUIT   ;BEI PARAMETERN OHNE PARAMETERANGABE BEI BUCHSTABEN
                        if (mOp.NotEqual(include.COMSYSString.$$$UPPER(m$,YPARA.var(53)),include.COMSYSString.$$$UPPER(m$,YPARA.var(5)))) {
                          if (mOp.Not(m$.Fnc.$find(YPARA.var(53).get(),"---------------"))) {
                            m$.var("^WWWSOR",m$.var("YUSER").get(),2,mOp.Concat(m$.fnc$("WWWUMLAU.main",YSORT.var(1).get(),3)," "),YPARA.var(5).get()).set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(" ",YSORT.get()),"-"),YPARA.var(53).get())," "));
                            break;
                          }
                        }
                        //<< . . . . if '$find(YPARA(53),"---------------")                                            set ^WWWSOR(YUSER,2,$$^WWWUMLAU(YSORT(1),3)_" ",YPARA(5))=" "_YPARA(53)_" "           quit   ;$$^WWWUML(" "_YSORT_"-"_YPARA(53)_" ") QUIT   ;BEI PARAMETERN OHNE PARAMETERANGABE BEI BUCHSTABEN
                        if (mOp.Not(m$.Fnc.$find(YPARA.var(53).get(),"---------------"))) {
                          m$.var("^WWWSOR",m$.var("YUSER").get(),2,mOp.Concat(m$.fnc$("WWWUMLAU.main",YSORT.var(1).get(),3)," "),YPARA.var(5).get()).set(mOp.Concat(mOp.Concat(" ",YPARA.var(53).get())," "));
                          break;
                        }
                      } while (false);
                    }
                  }
                } while (false);
                break;
              }
            }
            //<< . . ;
            //<< . . if $translate(YPARA(53)," ")'=$translate(YSORT," ") if YSORT'="" if +YPARA(12)=0 do
            if (mOp.NotEqual(m$.Fnc.$translate(YPARA.var(53).get()," "),m$.Fnc.$translate(YSORT.get()," "))) {
              if (mOp.NotEqual(YSORT.get(),"")) {
                if (mOp.Equal(mOp.Positive(YPARA.var(12).get()),0)) {
                  do {
                    //<< . . . if '$find(YSORT,"---------------") do  quit
                    if (mOp.Not(m$.Fnc.$find(YSORT.get(),"---------------"))) {
                      //<< . . . . set ^WWWSOR(YUSER,2,$extract($$$UPPER(YSORT(1)),1,100),YPARA(5))=YPARA(53)_" - "_YSORT_" "
                      m$.var("^WWWSOR",m$.var("YUSER").get(),2,m$.Fnc.$extract(include.COMSYSString.$$$UPPER(m$,YSORT.var(1)),1,100),YPARA.var(5).get()).set(mOp.Concat(mOp.Concat(mOp.Concat(YPARA.var(53).get()," - "),YSORT.get())," "));
                      break;
                    }
                    //<< . . . ;
                    //<< . . . if $find(YSORT,"---------------")  set ^WWWSOR(YUSER,2,$$$UPPER(YSORT(1)),YPARA(5))=YSORT_" " quit   ;$$^WWWUML(YPARA(53)_" - "_YSORT_" ") QUIT
                    if (mOp.Logical(m$.Fnc.$find(YSORT.get(),"---------------"))) {
                      m$.var("^WWWSOR",m$.var("YUSER").get(),2,include.COMSYSString.$$$UPPER(m$,YSORT.var(1)),YPARA.var(5).get()).set(mOp.Concat(YSORT.get()," "));
                      break;
                    }
                  } while (false);
                }
              }
            }
            //<< . . ;
            //<< . . if $translate(YPARA(53)," ")=$translate(YSORT," ")||(YSORT="") if +YPARA(12)=0 set ^WWWSOR(YUSER,2,$$$UPPER(YSORT(1)),YPARA(5))=" "_YPARA(53)_" " quit   ;$$^WWWUML(" "_YPARA(53)_" ") QUIT
            if (mOp.Equal(m$.Fnc.$translate(YPARA.var(53).get()," "),m$.Fnc.$translate(YSORT.get()," ")) || (mOp.Equal(YSORT.get(),""))) {
              if (mOp.Equal(mOp.Positive(YPARA.var(12).get()),0)) {
                m$.var("^WWWSOR",m$.var("YUSER").get(),2,include.COMSYSString.$$$UPPER(m$,YSORT.var(1)),YPARA.var(5).get()).set(mOp.Concat(mOp.Concat(" ",YPARA.var(53).get())," "));
                break;
              }
            }
          } while (false);
        }
        //<< . . ;
        //<< . if $get(YPARA(120))=1 do  ;TYBD;21,8,2004;SCHLÜSSEL ANZEIGE J/N;26262
        if (mOp.Equal(m$.Fnc.$get(YPARA.var(120)),1)) {
          do {
            //<< . . if $extract(YPARA(2))'="""" if +YPARA(12)'=0 do  ;wenn Parameter ;when Parameters
            if (mOp.NotEqual(m$.Fnc.$extract(YPARA.var(2).get()),"\"")) {
              if (mOp.NotEqual(mOp.Positive(YPARA.var(12).get()),0)) {
                do {
                  //<< . . . if '$find(YPARA(53),"---------------") set ^WWWSOR(YUSER,2,$$^WWWUMLAU(YSORT(1),3)_" ",YPARA(5))=YPARA(53)      quit  ;YSORT_" - "_YPARA(53)_" " QUIT  ;$$^WWWUML(YSORT_" - "_YPARA(53)_" ") QUIT  ;BEI PARAMETERN
                  if (mOp.Not(m$.Fnc.$find(YPARA.var(53).get(),"---------------"))) {
                    m$.var("^WWWSOR",m$.var("YUSER").get(),2,mOp.Concat(m$.fnc$("WWWUMLAU.main",YSORT.var(1).get(),3)," "),YPARA.var(5).get()).set(YPARA.var(53).get());
                    break;
                  }
                  //<< . . . if $find(YPARA(53),"---------------")  set ^WWWSOR(YUSER,2,$$^WWWUMLAU(YSORT(1),3)_" ",YPARA(5))=YPARA(53)_" "  quit  ;$$^WWWUML(YSORT_" - "_YPARA(53)_" ") QUIT  ;BEI PARAMETERN
                  if (mOp.Logical(m$.Fnc.$find(YPARA.var(53).get(),"---------------"))) {
                    m$.var("^WWWSOR",m$.var("YUSER").get(),2,mOp.Concat(m$.fnc$("WWWUMLAU.main",YSORT.var(1).get(),3)," "),YPARA.var(5).get()).set(mOp.Concat(YPARA.var(53).get()," "));
                    break;
                  }
                } while (false);
              }
            }
            //<< . . . ;
            //<< . . if $extract(YPARA(2))="""" if +YPARA(12)'=0 do  quit  ;SORTIERT
            if (mOp.Equal(m$.Fnc.$extract(YPARA.var(2).get()),"\"")) {
              if (mOp.NotEqual(mOp.Positive(YPARA.var(12).get()),0)) {
                do {
                  //<< . . . if +YPARA(5)'=0!(YPARA(5)=0) set ^WWWSOR(YUSER,2,$$^WWWUMLAU(YSORT(1),3)_" ",YPARA(5))=" "_YSORT_" " quit   ;$$^WWWUML(" "_YSORT_" ") QUIT   ;BEI PARAMETERN OHNE PARAMETERANGABE BEI ZAHLEN
                  if (mOp.Or(mOp.NotEqual(mOp.Positive(YPARA.var(5).get()),0),(mOp.Equal(YPARA.var(5).get(),0)))) {
                    m$.var("^WWWSOR",m$.var("YUSER").get(),2,mOp.Concat(m$.fnc$("WWWUMLAU.main",YSORT.var(1).get(),3)," "),YPARA.var(5).get()).set(mOp.Concat(mOp.Concat(" ",YSORT.get())," "));
                    break;
                  }
                  //<< . . . if +YPARA(5)=0 if YPARA(5)'=0 do
                  if (mOp.Equal(mOp.Positive(YPARA.var(5).get()),0)) {
                    if (mOp.NotEqual(YPARA.var(5).get(),0)) {
                      do {
                        //<< . . . . if $$$UPPER(YPARA(53))'=$$$UPPER(YPARA(5)) if '$find(YPARA(53),"---------------") set ^WWWSOR(YUSER,2,$$^WWWUMLAU(YSORT(1),3)_" ",YPARA(5))=" "_YPARA(53)  ;" "_YSORT_"-"_YPARA(53)_" " QUIT    ;WENN GLEICH DANN NICHT ;TYBD;1,8,2007;25508;$$^WWWUML(" "_YSORT_"-"_YPARA(53)_" ") QUIT   ;BEI PARAMETERN OHNE PARAMETERANGABE BEI BUCHSTABEN
                        if (mOp.NotEqual(include.COMSYSString.$$$UPPER(m$,YPARA.var(53)),include.COMSYSString.$$$UPPER(m$,YPARA.var(5)))) {
                          if (mOp.Not(m$.Fnc.$find(YPARA.var(53).get(),"---------------"))) {
                            m$.var("^WWWSOR",m$.var("YUSER").get(),2,mOp.Concat(m$.fnc$("WWWUMLAU.main",YSORT.var(1).get(),3)," "),YPARA.var(5).get()).set(mOp.Concat(" ",YPARA.var(53).get()));
                          }
                        }
                        //<< . . . . if '$find(YPARA(53),"---------------") set ^WWWSOR(YUSER,2,$$^WWWUMLAU(YSORT(1),3)_" ",YPARA(5))=" "_YPARA(53)_" " quit   ;$$^WWWUML(" "_YSORT_"-"_YPARA(53)_" ") QUIT   ;BEI PARAMETERN OHNE PARAMETERANGABE BEI BUCHSTABEN
                        if (mOp.Not(m$.Fnc.$find(YPARA.var(53).get(),"---------------"))) {
                          m$.var("^WWWSOR",m$.var("YUSER").get(),2,mOp.Concat(m$.fnc$("WWWUMLAU.main",YSORT.var(1).get(),3)," "),YPARA.var(5).get()).set(mOp.Concat(mOp.Concat(" ",YPARA.var(53).get())," "));
                          break;
                        }
                      } while (false);
                    }
                  }
                } while (false);
                break;
              }
            }
            //<< . . . ;
            //<< . . if $translate(YPARA(53)," ")'=$translate(YSORT," ") if YSORT'="" if +YPARA(12)=0 do
            if (mOp.NotEqual(m$.Fnc.$translate(YPARA.var(53).get()," "),m$.Fnc.$translate(YSORT.get()," "))) {
              if (mOp.NotEqual(YSORT.get(),"")) {
                if (mOp.Equal(mOp.Positive(YPARA.var(12).get()),0)) {
                  do {
                    //<< . . . if '$find(YSORT,"---------------") do  quit
                    if (mOp.Not(m$.Fnc.$find(YSORT.get(),"---------------"))) {
                      //<< . . . . set ^WWWSOR(YUSER,2,$extract($zconvert(YSORT(1),"U"),1,100),YPARA(5))=YSORT   ;YPARA(53)_" - "_YSORT_" "
                      m$.var("^WWWSOR",m$.var("YUSER").get(),2,m$.Fnc.$extract(m$.Fnc.$zconvert(YSORT.var(1).get(),"U"),1,100),YPARA.var(5).get()).set(YSORT.get());
                      break;
                    }
                    //<< . . . ;
                    //<< . . . if $find(YSORT,"---------------")  set ^WWWSOR(YUSER,2,$$$UPPER(YSORT(1)),YPARA(5))=YSORT_" " quit   ;$$^WWWUML(YPARA(53)_" - "_YSORT_" ") QUIT
                    if (mOp.Logical(m$.Fnc.$find(YSORT.get(),"---------------"))) {
                      m$.var("^WWWSOR",m$.var("YUSER").get(),2,include.COMSYSString.$$$UPPER(m$,YSORT.var(1)),YPARA.var(5).get()).set(mOp.Concat(YSORT.get()," "));
                      break;
                    }
                  } while (false);
                }
              }
            }
            //<< . . ;
            //<< . . if $translate(YPARA(53)," ")=$translate(YSORT," ")!(YSORT="") if +YPARA(12)=0 set ^WWWSOR(YUSER,2,$$$UPPER(YSORT(1)),YPARA(5))=" "_YPARA(53)_" " quit   ;$$^WWWUML(" "_YPARA(53)_" ") QUIT
            if (mOp.Or(mOp.Equal(m$.Fnc.$translate(YPARA.var(53).get()," "),m$.Fnc.$translate(YSORT.get()," ")),(mOp.Equal(YSORT.get(),"")))) {
              if (mOp.Equal(mOp.Positive(YPARA.var(12).get()),0)) {
                m$.var("^WWWSOR",m$.var("YUSER").get(),2,include.COMSYSString.$$$UPPER(m$,YSORT.var(1)),YPARA.var(5).get()).set(mOp.Concat(mOp.Concat(" ",YPARA.var(53).get())," "));
                break;
              }
            }
          } while (false);
        }
      } while (false);
      if (mOp.NotEqual(YPARA.var(20).get(),0)) {
        if (mOp.Greater(YPARA.var("ANZ").get(),YANZMAX.get())) {
          break;
        }
        if (mOp.Equal(m$.Fnc.$get(m$.var("YYYFORM")),"WWWHPR")) {
          if (mOp.Greater(YPARA.var("ANZ").get(),3)) {
            break;
          }
        }
      }
    }
    //<< 
    //<< quit
    return;
  }

  //<< 
  //<< 
  //<< CheckFreeFields(pstrDescription,pstrDesignClass="",pstrListClass="",pintField="")
  public Object CheckFreeFields(Object ... _p) {
    mVar pstrDescription = m$.newVarRef("pstrDescription",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pstrDesignClass = m$.newVarRef("pstrDesignClass",(((_p!=null)&&(_p.length>=2))?_p[1]:null),"");
    mVar pstrListClass = m$.newVarRef("pstrListClass",(((_p!=null)&&(_p.length>=3))?_p[2]:null),"");
    mVar pintField = m$.newVarRef("pintField",(((_p!=null)&&(_p.length>=4))?_p[3]:null),"");
    //<< ;-------------------------------------------------------------------------------
    //<< ; Display more information in the list if this is a class definition field.
    //<< ; Include customisation and highlight with brackets any _FREE fields.
    //<< ;
    //<< ; Called By: PARAM^WWWFORM71
    //<< ;
    //<< ; Params:
    //<< ;   pstrDescription:    The text to display in the list.
    //<< ;                       Passes straight through if this is not WWW003
    //<< ;   pstrDesignClass:    The class that the list is based on.
    //<< ;                       (Only interested if this is WWW003, class fields)
    //<< ;   pstrListClass:      The class that the properties are used to populate the list.
    //<< ;   pintField:          The field number.
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 25-May-2009   shobby  SR16574: This routine should handle both class and form.
    //<< ;                           When pstrDesignClass is WWW003 then pintField is the
    //<< ;                           classfield, else it is the form field.
    //<< ; 17-Mar-2008   shobby  SRBR014874: Use $$$FREE macro, put blnFree test inside
    //<< ;                           the 'if' conditions.
    //<< ; 14-Mar-2008   GM      SRBR014874: Included conditions to show translation itens
    //<< ; 03-Aug-2007   shobby  SRBR014594: Handle the case where pstrListClass is
    //<< ;                           passed in as a string and not a variable.
    //<< ;                           ie INFIBPAR on the SALAccount form.
    //<< ; 09-Jul-2007   shobby  SRBR014594: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new blnFree,intClassField,intFormField,objWWW003,objWWW0031
    mVar blnFree = m$.var("blnFree");
    mVar intClassField = m$.var("intClassField");
    mVar intFormField = m$.var("intFormField");
    mVar objWWW003 = m$.var("objWWW003");
    mVar objWWW0031 = m$.var("objWWW0031");
    m$.newVar(blnFree,intClassField,intFormField,objWWW003,objWWW0031);
    //<< 
    //<< set blnFree = $$$NO
    blnFree.set(include.COMSYS.$$$NO(m$));
    //<< 
    //<< if (pstrDesignClass="WWW003") || (pstrDesignClass="WWW122") {
    if ((mOp.Equal(pstrDesignClass.get(),"WWW003")) || (mOp.Equal(pstrDesignClass.get(),"WWW122"))) {
      //<< if (pstrListClass'="") && (pintField'="") {
      if ((mOp.NotEqual(pstrListClass.get(),"")) && (mOp.NotEqual(pintField.get(),""))) {
        //<< set blnFree = ($extract(pstrDescription,1,5)=$$$FREE)
        blnFree.set((mOp.Equal(m$.Fnc.$extract(pstrDescription.get(),1,5),include.COMSYS.$$$FREE(m$))));
        //<< if ($extract(pstrListClass)="""") && ($extract(pstrListClass,$length(pstrListClass))="""") {
        if ((mOp.Equal(m$.Fnc.$extract(pstrListClass.get()),"\"")) && (mOp.Equal(m$.Fnc.$extract(pstrListClass.get(),m$.Fnc.$length(pstrListClass.get())),"\""))) {
          //<< set pstrListClass = $extract(pstrListClass,2,$length(pstrListClass)-1)
          pstrListClass.set(m$.Fnc.$extract(pstrListClass.get(),2,mOp.Subtract(m$.Fnc.$length(pstrListClass.get()),1)));
        }
        //<< } else {
        else {
          //<< set pstrListClass = @pstrListClass
          pstrListClass.set(m$.indirectVar(pstrListClass.get()).get());
        }
        //<< }
        //<< 
        //<< if pstrDesignClass="WWW122" {
        if (mOp.Equal(pstrDesignClass.get(),"WWW122")) {
          //<< set intFormField  = pintField
          intFormField.set(pintField.get());
          //<< set intClassField = $$$GetClassField(pstrListClass,intFormField)
          intClassField.set(include.COMSYSWWW.$$$GetClassField(m$,pstrListClass,intFormField));
          //<< if intClassField'="" {
          if (mOp.NotEqual(intClassField.get(),"")) {
            //<< set pstrDescription = $$^WWWFELDNAME(pstrListClass,"D",intClassField)
            pstrDescription.set(m$.fnc$("WWWFELDNAME.main",pstrListClass.get(),"D",intClassField.get()));
          }
          //<< } else {
          else {
            //<< set pstrDescription = $$^WWWFELDNAME(pstrListClass,"M",intFormField)
            pstrDescription.set(m$.fnc$("WWWFELDNAME.main",pstrListClass.get(),"M",intFormField.get()));
          }
        }
        //<< }
        //<< 
        //<< } elseif pstrDesignClass="WWW003" {
        else if (mOp.Equal(pstrDesignClass.get(),"WWW003")) {
          //<< set intClassField = pintField
          intClassField.set(pintField.get());
          //<< set intFormField  = $$$GetFormField(pstrListClass,intClassField)
          intFormField.set(include.COMSYSWWW.$$$GetFormField(m$,pstrListClass,intClassField));
          //<< if intFormField'="" {
          if (mOp.NotEqual(intFormField.get(),"")) {
            //<< set pstrDescription = $$^WWWFELDNAME(pstrListClass,"D",intClassField)
            pstrDescription.set(m$.fnc$("WWWFELDNAME.main",pstrListClass.get(),"D",intClassField.get()));
          }
          //<< } else {
          else {
            //<< set pstrDescription = $get(^WWW0031(0,pstrListClass,intClassField,SPRACHE,1))
            pstrDescription.set(m$.Fnc.$get(m$.var("^WWW0031",0,pstrListClass.get(),intClassField.get(),m$.var("SPRACHE").get(),1)));
            //<< if pstrDescription="" {
            if (mOp.Equal(pstrDescription.get(),"")) {
              //<< set pstrDescription = $$$WWW003PropertyDescription($get(^WWW003(0,pstrListClass,intClassField,1)))
              pstrDescription.set(include.WWWConst.$$$WWW003PropertyDescription(m$,m$.Fnc.$get(m$.var("^WWW003",0,pstrListClass.get(),intClassField.get(),1))));
            }
          }
        }
        //<< }
        //<< }
        //<< }
        //<< 
        //<< if $extract(pstrDescription,1,5)=$$$FREE {
        if (mOp.Equal(m$.Fnc.$extract(pstrDescription.get(),1,5),include.COMSYS.$$$FREE(m$))) {
          //<< ; if there is no customisation use the property name so we know which free field it is.
          //<< set objWWW003       = $get(^WWW003(0,pstrListClass,intClassField,1))
          objWWW003.set(m$.Fnc.$get(m$.var("^WWW003",0,pstrListClass.get(),intClassField.get(),1)));
          //<< set pstrDescription = $$$WWW003PropertyName(objWWW003)
          pstrDescription.set(include.WWWConst.$$$WWW003PropertyName(m$,objWWW003));
        }
        //<< }
        //<< if blnFree set pstrDescription = "["_pstrDescription_"]"
        if (mOp.Logical(blnFree.get())) {
          pstrDescription.set(mOp.Concat(mOp.Concat("[",pstrDescription.get()),"]"));
        }
      }
    }
    //<< }
    //<< }
    //<< quit pstrDescription
    return pstrDescription.get();
  }

  //<< 
  //<< 
  //<< ComboToSearch(penumDataType,pidRelation)
  public Object ComboToSearch(Object ... _p) {
    mVar penumDataType = m$.newVarRef("penumDataType",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pidRelation = m$.newVarRef("pidRelation",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Can this field be changed from a combo to a search ?
    //<< ;
    //<< ; Called By : BUILDSELECT^COMGridEdit31F, BUILDSELECTOVERRIDE^COMGridEdit31F,
    //<< ;             NeedToCheck^WWWFieldValidation, Start^WWWFORM7, PARAM^WWWFORM71
    //<< ;
    //<< ; Params:   penumDataType   - data type of the field
    //<< ;           pidRelation     - relation class
    //<< ;
    //<< ; ByRefs:
    //<< ;
    //<< ; Returns:  boolean
    //<< ;
    //<< ; History:
    //<< ; 19-Oct-2010   Shobby  SR17565: removal of WWW001ComboToSearch test reverted
    //<< ; 22-Aug-2006   JW      SR14929: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new blnChange
    mVar blnChange = m$.var("blnChange");
    m$.newVar(blnChange);
    //<< 
    //<< set blnChange = $$$NO
    blnChange.set(include.COMSYS.$$$NO(m$));
    //<< 
    //<< if $case(+penumDataType,0:$$$YES,1:$$$YES,4:$$$YES,:$$$NO) {     ; "EINGABE"? Automatic/Text/Select ?
    if (mOp.Logical(m$.Fnc.$case(mOp.Positive(penumDataType.get()),0,include.COMSYS.$$$YES(m$),1,include.COMSYS.$$$YES(m$),4,include.COMSYS.$$$YES(m$),include.COMSYS.$$$NO(m$)))) {
      //<< ;SR17565
      //<< if $$$WWW001ComboToSearch($get(^WWW001(0,pidRelation,1))) {
      if (mOp.Logical(include.WWWConst.$$$WWW001ComboToSearch(m$,m$.Fnc.$get(m$.var("^WWW001",0,pidRelation.get(),1))))) {
        //<< set blnChange = $$$YES
        blnChange.set(include.COMSYS.$$$YES(m$));
      }
    }
    //<< }
    //<< }
    //<< quit blnChange
    return blnChange.get();
  }

  //<< 
  //<< 
  //<< PARAM1
  public Object PARAM1() {
    //<< ;-------------------------------------------------------------------------------
    //<< ;PARAMETER NUR WENN FELDER mit einem Wert ;parameter only when by means of Value
    //<< ;
    //<< ; Called By: PARAM^WWWFORM71
    //<< ;
    //<< ;-------------------------------------------------------------------------------
    //<< quit:$data(^WWWSOR(YUSER,2))
    if (mOp.Logical(m$.Fnc.$data(m$.var("^WWWSOR",m$.var("YUSER").get(),2)))) {
      return null;
    }
    //<< 
    //<< ;IF +YPARA(3)=0 SET YPARA(3)=1 ;table-mat
    //<< set YPARA(4) = "^"_YFILE_"("_$$^WWWYM(YPARA(1),1)
    mVar YPARA = m$.var("YPARA");
    YPARA.var(4).set(mOp.Concat(mOp.Concat(mOp.Concat("^",m$.var("YFILE").get()),"("),m$.fnc$("WWWYM.main",m$.var("YPARA").var(1).get(),1)));
    //<< set Q      = 0
    mVar Q = m$.var("Q");
    Q.set(0);
    //<< set YCOLOR = 0
    mVar YCOLOR = m$.var("YCOLOR");
    YCOLOR.set(0);
    //<< if $find(YPARA(2),"FARBE") set YCOLOR=1
    if (mOp.Logical(m$.Fnc.$find(YPARA.var(2).get(),"FARBE"))) {
      YCOLOR.set(1);
    }
    //<< for YI=1:1 set YPARA(9)=$piece(YPARA(2),",",YI) quit:YPARA(9)=""  set YPARA(4)=YPARA(4)_YPARA(9)_"," if $extract(YPARA(9))'="""" if $get(@(YPARA(9)))="" set Q=1 quit
    mVar YI = m$.var("YI");
    for (YI.set(1);(true);YI.set(mOp.Add(YI.get(),1))) {
      YPARA.var(9).set(m$.Fnc.$piece(YPARA.var(2).get(),",",YI.get()));
      if (mOp.Equal(YPARA.var(9).get(),"")) {
        break;
      }
      YPARA.var(4).set(mOp.Concat(mOp.Concat(YPARA.var(4).get(),YPARA.var(9).get()),","));
      if (mOp.NotEqual(m$.Fnc.$extract(YPARA.var(9).get()),"\"")) {
        if (mOp.Equal(m$.Fnc.$get(m$.indirectVar((YPARA.var(9).get()))),"")) {
          Q.set(1);
          break;
        }
      }
    }
    //<< if Q=1 set Q = 0 quit
    if (mOp.Equal(Q.get(),1)) {
      Q.set(0);
      return null;
    }
    //<< 
    //<< if $piece(YDATA,Y,8)'=4 set YPARA(6) = YPARA(4)_""""_YINHALT_""",1)"
    if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YDATA").get(),m$.var("Y").get(),8),4)) {
      YPARA.var(6).set(mOp.Concat(mOp.Concat(mOp.Concat(YPARA.var(4).get(),"\""),m$.var("YINHALT").get()),"\",1)"));
    }
    //<< if $piece(YDATA,Y,8)=4  set YPARA(6) = YPARA(4)_""""_YINHALT_""")"
    if (mOp.Equal(m$.Fnc.$piece(m$.var("YDATA").get(),m$.var("Y").get(),8),4)) {
      YPARA.var(6).set(mOp.Concat(mOp.Concat(mOp.Concat(YPARA.var(4).get(),"\""),m$.var("YINHALT").get()),"\")"));
    }
    //<< if YFILE'=YPARA(1) set YPARA(6) = "^"_YPARA(1)_"("_$piece(YPARA(6),"(",2,99)
    if (mOp.NotEqual(m$.var("YFILE").get(),YPARA.var(1).get())) {
      YPARA.var(6).set(mOp.Concat(mOp.Concat(mOp.Concat("^",YPARA.var(1).get()),"("),m$.Fnc.$piece(YPARA.var(6).get(),"(",2,99)));
    }
    //<< set YSORT = $$^WWWSETL(YPARA(6))
    mVar YSORT = m$.var("YSORT");
    YSORT.set(m$.fnc$("WWWSETL.main",YPARA.var(6).get()));
    //<< 
    //<< if YSORT'="" do  quit
    if (mOp.NotEqual(YSORT.get(),"")) {
      //<< . set YSORT(1)=""
      YSORT.var(1).set("");
      //<< . // Calculated Fields //SR16663
      //<< . if $get(YPARA("CF"))'=""  do
      if (mOp.NotEqual(m$.Fnc.$get(YPARA.var("CF")),"")) {
        //<< . . for YPARA(88)=1:1 quit:$piece(YPARA("CF"),",",YPARA(88))=""  do
        for (m$.var("YPARA",88).set(1);(true);m$.var("YPARA",88).set(mOp.Add(m$.var("YPARA",88).get(),1))) {
          if (mOp.Equal(m$.Fnc.$piece(YPARA.var("CF").get(),",",YPARA.var(88).get()),"")) {
            break;
          }
          //<< . . . set idField = $piece(YPARA("CF"),",",YPARA(88))
          mVar idField = m$.var("idField");
          idField.set(m$.Fnc.$piece(YPARA.var("CF").get(),",",YPARA.var(88).get()));
          //<< . . . if idField set YSORT(1)=YSORT(1)_$$GetCalculatedValue(YPARA(1),idField,YPARA(2)_","_YINHALT,YSORT)
          if (mOp.Logical(idField.get())) {
            YSORT.var(1).set(mOp.Concat(YSORT.var(1).get(),m$.fnc$("GetCalculatedValue",YPARA.var(1).get(),idField.get(),mOp.Concat(mOp.Concat(YPARA.var(2).get(),","),m$.var("YINHALT").get()),YSORT.get())));
          }
        }
      }
      //<< . ;
      //<< . for YPARA(88)=1:1 quit:$piece(YPARA(3),",",YPARA(88))=""  do
      for (m$.var("YPARA",88).set(1);(true);m$.var("YPARA",88).set(mOp.Add(m$.var("YPARA",88).get(),1))) {
        if (mOp.Equal(m$.Fnc.$piece(YPARA.var(3).get(),",",YPARA.var(88).get()),"")) {
          break;
        }
        //<< . . set YSORT(1)=YSORT(1)_$piece(YSORT,Y,+$piece(YPARA(3),",",YPARA(88)))
        YSORT.var(1).set(mOp.Concat(YSORT.var(1).get(),m$.Fnc.$piece(YSORT.get(),m$.var("Y").get(),mOp.Positive(m$.Fnc.$piece(YPARA.var(3).get(),",",YPARA.var(88).get())))));
        //<< . . if $piece(YSORT,Y,+$piece(YPARA(3),",",YPARA(88)))'="" set YSORT(1)=YSORT(1)_","
        if (mOp.NotEqual(m$.Fnc.$piece(YSORT.get(),m$.var("Y").get(),mOp.Positive(m$.Fnc.$piece(YPARA.var(3).get(),",",YPARA.var(88).get()))),"")) {
          YSORT.var(1).set(mOp.Concat(YSORT.var(1).get(),","));
        }
        //<< . . if $get(YPARA(79))'="" do  ;MARKIERUNG
        if (mOp.NotEqual(m$.Fnc.$get(YPARA.var(79)),"")) {
          //<< . . . if +$piece($$^WWWSETL(YPARA(6)),Y,YPARA(79))=1 set YPARA(80)=YINHALT  ;ROT  ;red
          if (mOp.Equal(mOp.Positive(m$.Fnc.$piece(m$.fnc$("WWWSETL.main",YPARA.var(6).get()),m$.var("Y").get(),YPARA.var(79).get())),1)) {
            YPARA.var(80).set(m$.var("YINHALT").get());
          }
          //<< . . . if +$piece($$^WWWSETL(YPARA(6)),Y,YPARA(79))=2 set YPARA(81)=YINHALT  ;GELB ;yellow
          if (mOp.Equal(mOp.Positive(m$.Fnc.$piece(m$.fnc$("WWWSETL.main",YPARA.var(6).get()),m$.var("Y").get(),YPARA.var(79).get())),2)) {
            YPARA.var(81).set(m$.var("YINHALT").get());
          }
          //<< . . . if +$piece($$^WWWSETL(YPARA(6)),Y,YPARA(79))=3 set YPARA(82)=YINHALT  ;GRÜN ;green
          if (mOp.Equal(mOp.Positive(m$.Fnc.$piece(m$.fnc$("WWWSETL.main",YPARA.var(6).get()),m$.var("Y").get(),YPARA.var(79).get())),3)) {
            YPARA.var(82).set(m$.var("YINHALT").get());
          }
        }
      }
      //<< . ;
      //<< . if $extract($reverse(YSORT(1)))="," set YSORT(1)=$reverse($extract($reverse(YSORT(1)),2,99))   ;, AUSFILTERN;22,07,2003
      if (mOp.Equal(m$.Fnc.$extract(m$.Fnc.$reverse(YSORT.var(1).get())),",")) {
        YSORT.var(1).set(m$.Fnc.$reverse(m$.Fnc.$extract(m$.Fnc.$reverse(YSORT.var(1).get()),2,99)));
      }
      //<< . set YPARA(21)=1
      YPARA.var(21).set(1);
      //<< . set YSORT(1)=$translate(YSORT(1),"()","[]")  ;FIS;11.05.04;25691
      YSORT.var(1).set(m$.Fnc.$translate(YSORT.var(1).get(),"()","[]"));
      //<< . ;SET ^WWWSOR(YUSER,2,$$^WWWUPER(YINHALT),YINHALT)=YSORT(1)_" ("_YSORT(1)_")"    ;$$^WWWUML(YSORT(1))_" ("_$$^WWWUML(YSORT(1))_")";TYBD;28,7,2004;25887;
      //<< . set ^WWWSOR(YUSER,2,$zconvert(YINHALT,"U"),YINHALT)=YSORT(1)_" ("_YSORT(1)_")"  ;$$^WWWUML(YSORT(1))_" ("_$$^WWWUML(YSORT(1))_")";TYBD;28,7,2004;25887;
      m$.var("^WWWSOR",m$.var("YUSER").get(),2,m$.Fnc.$zconvert(m$.var("YINHALT").get(),"U"),m$.var("YINHALT").get()).set(mOp.Concat(mOp.Concat(mOp.Concat(YSORT.var(1).get()," ("),YSORT.var(1).get()),")"));
      return null;
    }
    //<< 
    //<< set YPARA(10)=YPARA(4)_"YPARA(5))"
    YPARA.var(10).set(mOp.Concat(YPARA.var(4).get(),"YPARA(5))"));
    //<< set YPARA(5)=""
    YPARA.var(5).set("");
    //<< 
    //<< ; YPARA(20) "Relation Display Options" '= 1 : "Display Relations after Input"
    //<< ;                                      '= 0 : "Display All Relations"
    //<< if YPARA(20)'=1 for YPARA(7)=1:1 set YPARA(5)=$order(@(YPARA(10))) quit:YPARA(5)=""  do  if YPARA(20)'=0 quit:YPARA(7)>1300  if $get(YYYFORM)="WWWHPR" quit:YPARA(7)>3   ;BEI HILFE  ;next to succour
    if (mOp.NotEqual(YPARA.var(20).get(),1)) {
      for (m$.var("YPARA",7).set(1);(true);m$.var("YPARA",7).set(mOp.Add(m$.var("YPARA",7).get(),1))) {
        YPARA.var(5).set(m$.Fnc.$order(m$.indirectVar((YPARA.var(10).get()))));
        if (mOp.Equal(YPARA.var(5).get(),"")) {
          break;
        }
        do {
          //<< . set YPARA(6)=YPARA(4)_""""_YPARA(5)_""",1)"
          YPARA.var(6).set(mOp.Concat(mOp.Concat(mOp.Concat(YPARA.var(4).get(),"\""),YPARA.var(5).get()),"\",1)"));
          //<< . set YPARA(44)="^"_YFILE_"("_$$^WWWYM(YPARA(1),1)
          YPARA.var(44).set(mOp.Concat(mOp.Concat(mOp.Concat("^",m$.var("YFILE").get()),"("),m$.fnc$("WWWYM.main",YPARA.var(1).get(),1)));
          //<< . for YI=1:1 set YPARA(19)=$piece(YPARA(2),",",YI) quit:YPARA(19)=""  do
          for (YI.set(1);(true);YI.set(mOp.Add(YI.get(),1))) {
            YPARA.var(19).set(m$.Fnc.$piece(YPARA.var(2).get(),",",YI.get()));
            if (mOp.Equal(YPARA.var(19).get(),"")) {
              break;
            }
            //<< . . set:$extract(YPARA(19))'="""" YPARA(19)=""""_$get(@YPARA(19))_""""
            if (mOp.NotEqual(m$.Fnc.$extract(YPARA.var(19).get()),"\"")) {
              YPARA.var(19).set(mOp.Concat(mOp.Concat("\"",m$.Fnc.$get(m$.indirectVar(YPARA.var(19).get()))),"\""));
            }
            //<< . . set YPARA(44)=YPARA(44)_YPARA(19)_","
            YPARA.var(44).set(mOp.Concat(mOp.Concat(YPARA.var(44).get(),YPARA.var(19).get()),","));
          }
          //<< . ;
          //<< . if $piece(YDATA,Y,8)=4 do
          if (mOp.Equal(m$.Fnc.$piece(m$.var("YDATA").get(),m$.var("Y").get(),8),4)) {
            //<< . . set ERSTFELD=$order(^WWW003(0,YPARA(1),""))
            mVar ERSTFELD = m$.var("ERSTFELD");
            ERSTFELD.set(m$.Fnc.$order(m$.var("^WWW003",0,YPARA.var(1).get(),"")));
            //<< . . set FELDKEY=""
            mVar FELDKEY = m$.var("FELDKEY");
            FELDKEY.set("");
            //<< . . if ERSTFELD'="" set FELDKEY=$piece(^WWW003(0,YPARA(1),ERSTFELD,1),Y,11)
            if (mOp.NotEqual(ERSTFELD.get(),"")) {
              FELDKEY.set(m$.Fnc.$piece(m$.var("^WWW003",0,YPARA.var(1).get(),ERSTFELD.get(),1).get(),m$.var("Y").get(),11));
            }
            //<< . . set YPARA(19)=YPARA(44)_""""_YPARA(5)_""""
            YPARA.var(19).set(mOp.Concat(mOp.Concat(mOp.Concat(YPARA.var(44).get(),"\""),YPARA.var(5).get()),"\""));
            //<< . . if FELDKEY'="" set YPARA(19)=YPARA(19)_","_FELDKEY
            if (mOp.NotEqual(FELDKEY.get(),"")) {
              YPARA.var(19).set(mOp.Concat(mOp.Concat(YPARA.var(19).get(),","),FELDKEY.get()));
            }
            //<< . . set YPARA(19)=YPARA(19)_")"
            YPARA.var(19).set(mOp.Concat(YPARA.var(19).get(),")"));
          }
          //<< . ;
          //<< . if $piece(YDATA,Y,8)'=4 set YPARA(19)=YPARA(44)_""""_YPARA(5)_""",1)"
          if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YDATA").get(),m$.var("Y").get(),8),4)) {
            YPARA.var(19).set(mOp.Concat(mOp.Concat(mOp.Concat(YPARA.var(44).get(),"\""),YPARA.var(5).get()),"\",1)"));
          }
          //<< . ;
          //<< . set YSORT=""
          YSORT.set("");
          //<< . for YPARA(88)=1:1 quit:$piece(YPARA(3),",",YPARA(88))=""  do
          for (m$.var("YPARA",88).set(1);(true);m$.var("YPARA",88).set(mOp.Add(m$.var("YPARA",88).get(),1))) {
            if (mOp.Equal(m$.Fnc.$piece(YPARA.var(3).get(),",",YPARA.var(88).get()),"")) {
              break;
            }
            do {
              //<< . . new YSORTX,YSORTX1,YSORTX2,YSORTX3,YSORTX4
              mVar YSORTX = m$.var("YSORTX");
              mVar YSORTX1 = m$.var("YSORTX1");
              mVar YSORTX2 = m$.var("YSORTX2");
              mVar YSORTX3 = m$.var("YSORTX3");
              mVar YSORTX4 = m$.var("YSORTX4");
              m$.newVar(YSORTX,YSORTX1,YSORTX2,YSORTX3,YSORTX4);
              //<< . . if YFILE'=YPARA(1) set YPARA(19)="^"_YPARA(1)_"("_$piece(YPARA(19),"(",2,99)
              if (mOp.NotEqual(m$.var("YFILE").get(),YPARA.var(1).get())) {
                YPARA.var(19).set(mOp.Concat(mOp.Concat(mOp.Concat("^",YPARA.var(1).get()),"("),m$.Fnc.$piece(YPARA.var(19).get(),"(",2,99)));
              }
              //<< . . set YSORTX=$piece($$^WWWSETL(YPARA(19)),Y,$piece(YPARA(3),",",YPARA(88)))
              YSORTX.set(m$.Fnc.$piece(m$.fnc$("WWWSETL.main",YPARA.var(19).get()),m$.var("Y").get(),m$.Fnc.$piece(YPARA.var(3).get(),",",YPARA.var(88).get())));
              //<< . . quit:YSORTX=""
              if (mOp.Equal(YSORTX.get(),"")) {
                break;
              }
              //<< . . if $get(YPARA(79))'="" do  ;MARKIERUNG
              if (mOp.NotEqual(m$.Fnc.$get(YPARA.var(79)),"")) {
                //<< . . . if +$piece($$^WWWSETL(YPARA(19)),Y,YPARA(79))=1 set YPARA(80)=YPARA(80)_YPARA(5)_","  ; red
                if (mOp.Equal(mOp.Positive(m$.Fnc.$piece(m$.fnc$("WWWSETL.main",YPARA.var(19).get()),m$.var("Y").get(),YPARA.var(79).get())),1)) {
                  YPARA.var(80).set(mOp.Concat(mOp.Concat(YPARA.var(80).get(),YPARA.var(5).get()),","));
                }
                //<< . . . if +$piece($$^WWWSETL(YPARA(19)),Y,YPARA(79))=2 set YPARA(81)=YPARA(81)_YPARA(5)_","  ; yellow
                if (mOp.Equal(mOp.Positive(m$.Fnc.$piece(m$.fnc$("WWWSETL.main",YPARA.var(19).get()),m$.var("Y").get(),YPARA.var(79).get())),2)) {
                  YPARA.var(81).set(mOp.Concat(mOp.Concat(YPARA.var(81).get(),YPARA.var(5).get()),","));
                }
                //<< . . . if +$piece($$^WWWSETL(YPARA(19)),Y,YPARA(79))=3 set YPARA(82)=YPARA(82)_YPARA(5)_","  ; green
                if (mOp.Equal(mOp.Positive(m$.Fnc.$piece(m$.fnc$("WWWSETL.main",YPARA.var(19).get()),m$.var("Y").get(),YPARA.var(79).get())),3)) {
                  YPARA.var(82).set(mOp.Concat(mOp.Concat(YPARA.var(82).get(),YPARA.var(5).get()),","));
                }
              }
              //<< . . ;
              //<< . . if YPARA(88)'=1 set YPARA(55)=2
              if (mOp.NotEqual(YPARA.var(88).get(),1)) {
                YPARA.var(55).set(2);
              }
              //<< . . set YSORTX2=$get(^WWW003(0,YPARA(1),$piece(YPARA(3),",",YPARA(88)),1))
              YSORTX2.set(m$.Fnc.$get(m$.var("^WWW003",0,YPARA.var(1).get(),m$.Fnc.$piece(YPARA.var(3).get(),",",YPARA.var(88).get()),1)));
              //<< . . set YSORTX1=$piece(YSORTX2,Y,3)
              YSORTX1.set(m$.Fnc.$piece(YSORTX2.get(),m$.var("Y").get(),3));
              //<< . . set YSORTX4=$piece(YSORTX2,Y,4)
              YSORTX4.set(m$.Fnc.$piece(YSORTX2.get(),m$.var("Y").get(),4));
              //<< . . if $find(YPARA(3),",") if YSORTX4>25 set YSORTX4=25
              if (mOp.Logical(m$.Fnc.$find(YPARA.var(3).get(),","))) {
                if (mOp.Greater(YSORTX4.get(),25)) {
                  YSORTX4.set(25);
                }
              }
              //<< . . if +$piece($piece($get(YSATZ),Y,64),",",YPARA(88))'=0 set YSORTX4=+$piece($piece($get(YSATZ),Y,64),",",YPARA(88))   ;MANUELLE LÄNGE DER RELATION ;longitude the
              if (mOp.NotEqual(mOp.Positive(m$.Fnc.$piece(m$.Fnc.$piece(m$.Fnc.$get(m$.var("YSATZ")),m$.var("Y").get(),64),",",YPARA.var(88).get())),0)) {
                YSORTX4.set(mOp.Positive(m$.Fnc.$piece(m$.Fnc.$piece(m$.Fnc.$get(m$.var("YSATZ")),m$.var("Y").get(),64),",",YPARA.var(88).get())));
              }
              //<< . . if $piece(YSORTX2,Y,8)'="" do  quit   ;WENN PARAMETER ;when parameter
              if (mOp.NotEqual(m$.Fnc.$piece(YSORTX2.get(),m$.var("Y").get(),8),"")) {
                do {
                  //<< . . . new YFILE,YDATA
                  mVar YFILE = m$.var("YFILE");
                  mVar YDATA = m$.var("YDATA");
                  m$.newVar(YFILE,YDATA);
                  //<< . . . set YDATA="" if $extract($piece(YSORTX2,Y,8),1,2)'="IN" if $extract($piece(YSORTX2,Y,8),1,3)'="WWW" set YDATA=$get(^WWW001(0,$piece(YSORTX2,Y,8),1))  ;VARIABEL AUS DATENSATZDEF.  FELD 8=DATEIART ;out of field
                  YDATA.set("");
                  if (mOp.NotEqual(m$.Fnc.$extract(m$.Fnc.$piece(YSORTX2.get(),m$.var("Y").get(),8),1,2),"IN")) {
                    if (mOp.NotEqual(m$.Fnc.$extract(m$.Fnc.$piece(YSORTX2.get(),m$.var("Y").get(),8),1,3),"WWW")) {
                      YDATA.set(m$.Fnc.$get(m$.var("^WWW001",0,m$.Fnc.$piece(YSORTX2.get(),m$.var("Y").get(),8),1)));
                    }
                  }
                  //<< . . . set YFILE=$piece(YSORTX2,Y,8)
                  YFILE.set(m$.Fnc.$piece(YSORTX2.get(),m$.var("Y").get(),8));
                  //<< . . . if $piece(YDATA,Y,22)'="" set YFILE=$piece(YDATA,Y,22)  ;ANDERE DATEI ;data file
                  if (mOp.NotEqual(m$.Fnc.$piece(YDATA.get(),m$.var("Y").get(),22),"")) {
                    YFILE.set(m$.Fnc.$piece(YDATA.get(),m$.var("Y").get(),22));
                  }
                  //<< . . . set YSORTX3="^"_YFILE_"("_$$^WWWYM($piece(YSORTX2,Y,8))_","
                  YSORTX3.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("^",YFILE.get()),"("),m$.fnc$("WWWYM.main",m$.Fnc.$piece(YSORTX2.get(),m$.var("Y").get(),8))),","));
                  //<< . . . if $piece(YSORTX2,Y,9)'="" quit:'$find($piece(YSORTX2,Y,9),"""")  set YSORTX3=YSORTX3_$piece(YSORTX2,Y,9)_","
                  if (mOp.NotEqual(m$.Fnc.$piece(YSORTX2.get(),m$.var("Y").get(),9),"")) {
                    if (mOp.Not(m$.Fnc.$find(m$.Fnc.$piece(YSORTX2.get(),m$.var("Y").get(),9),"\""))) {
                      break;
                    }
                    YSORTX3.set(mOp.Concat(mOp.Concat(YSORTX3.get(),m$.Fnc.$piece(YSORTX2.get(),m$.var("Y").get(),9)),","));
                  }
                  //<< . . . set YSORTX3=YSORTX3_""""_YSORTX_""""
                  YSORTX3.set(mOp.Concat(mOp.Concat(mOp.Concat(YSORTX3.get(),"\""),YSORTX.get()),"\""));
                  //<< . . . if $piece(YDATA,Y,8)'=4 set YSORTX3=YSORTX3_",1)"
                  if (mOp.NotEqual(m$.Fnc.$piece(YDATA.get(),m$.var("Y").get(),8),4)) {
                    YSORTX3.set(mOp.Concat(YSORTX3.get(),",1)"));
                  }
                  //<< . . . if $piece(YDATA,Y,8)=4 set YSORTX3=YSORTX3_")"
                  if (mOp.Equal(m$.Fnc.$piece(YDATA.get(),m$.var("Y").get(),8),4)) {
                    YSORTX3.set(mOp.Concat(YSORTX3.get(),")"));
                  }
                  //<< . . . if YFILE'=$piece(YSORTX2,Y,8) set YSORTX3="^"_$piece(YSORTX2,Y,8)_"("_$piece(YSORTX3,"(",2,99)
                  if (mOp.NotEqual(YFILE.get(),m$.Fnc.$piece(YSORTX2.get(),m$.var("Y").get(),8))) {
                    YSORTX3.set(mOp.Concat(mOp.Concat(mOp.Concat("^",m$.Fnc.$piece(YSORTX2.get(),m$.var("Y").get(),8)),"("),m$.Fnc.$piece(YSORTX3.get(),"(",2,99)));
                  }
                  //<< . . . set YSORTXX=$piece($$^WWWSETL(YSORTX3),Y,$piece($piece(YSORTX2,Y,10),",",1))
                  mVar YSORTXX = m$.var("YSORTXX");
                  YSORTXX.set(m$.Fnc.$piece(m$.fnc$("WWWSETL.main",YSORTX3.get()),m$.var("Y").get(),m$.Fnc.$piece(m$.Fnc.$piece(YSORTX2.get(),m$.var("Y").get(),10),",",1)));
                  //<< . . . set YSORT=YSORT_$extract(YSORTXX_"                                        ",1,YSORTX4)_" "
                  YSORT.set(mOp.Concat(mOp.Concat(YSORT.get(),m$.Fnc.$extract(mOp.Concat(YSORTXX.get(),"                                        "),1,YSORTX4.get()))," "));
                } while (false);
                break;
              }
              //<< . . ;
              //<< . . set YSORT=YSORT_$extract($$GetLiteral^WWWTR(YSORTX1,YSORTX)_"                                        ",1,YSORTX4)_" "
              YSORT.set(mOp.Concat(mOp.Concat(YSORT.get(),m$.Fnc.$extract(mOp.Concat(m$.fnc$("WWWTR.GetLiteral",YSORTX1.get(),YSORTX.get()),"                                        "),1,YSORTX4.get()))," "));
            } while (false);
          }
          //<< . ;
          //<< . if YSORT="" set YSORT=" "
          if (mOp.Equal(YSORT.get(),"")) {
            YSORT.set(" ");
          }
          //<< . set YSORT(1)=YSORT
          YSORT.var(1).set(YSORT.get());
          //<< . ;
          //<< . set YPARA(0)=$$$WWW001LanguageClassForRelations($get(^WWW001(0,YPARA(1),1)))  ;Language class
          YPARA.var(0).set(include.WWWConst.$$$WWW001LanguageClassForRelations(m$,m$.Fnc.$get(m$.var("^WWW001",0,YPARA.var(1).get(),1))));
          //<< . if YPARA(0)'="" do
          if (mOp.NotEqual(YPARA.var(0).get(),"")) {
            do {
              //<< . . set YPARA(99)="^"_YPARA(0)_"("_$$^WWWYM(YPARA(1),1)
              YPARA.var(99).set(mOp.Concat(mOp.Concat(mOp.Concat("^",YPARA.var(0).get()),"("),m$.fnc$("WWWYM.main",YPARA.var(1).get(),1)));
              //<< . . if $piece(YDATA,Y,12)'="" if $piece(YDATA,Y,13)'="" do  ;UCI UND VOL ;UCI And
              if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YDATA").get(),m$.var("Y").get(),12),"")) {
                if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YDATA").get(),m$.var("Y").get(),13),"")) {
                  do {
                    //<< . . . quit:$find(YPARA(99),"^[")
                    if (mOp.Logical(m$.Fnc.$find(YPARA.var(99).get(),"^["))) {
                      break;
                    }
                    //<< . . . set YPARA(99)="^["""_$piece(YDATA,Y,12)_""","""_$piece(YDATA,Y,13)_"""]"_$piece(YPARA(99),"^",2,999)
                    YPARA.var(99).set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("^[\"",m$.Fnc.$piece(m$.var("YDATA").get(),m$.var("Y").get(),12)),"\",\""),m$.Fnc.$piece(m$.var("YDATA").get(),m$.var("Y").get(),13)),"\"]"),m$.Fnc.$piece(YPARA.var(99).get(),"^",2,999)));
                  } while (false);
                }
              }
              //<< . . ;
              //<< . . set Q=0
              Q.set(0);
              //<< . . for YI=1:1 set YPARA(9)=$piece(YPARA(2),",",YI) quit:YPARA(9)=""  set YPARA(99)=YPARA(99)_YPARA(9)_"," if $extract(YPARA(9))'="""" if $get(@(YPARA(9)))="" set Q=1 quit
              for (YI.set(1);(true);YI.set(mOp.Add(YI.get(),1))) {
                YPARA.var(9).set(m$.Fnc.$piece(YPARA.var(2).get(),",",YI.get()));
                if (mOp.Equal(YPARA.var(9).get(),"")) {
                  break;
                }
                YPARA.var(99).set(mOp.Concat(mOp.Concat(YPARA.var(99).get(),YPARA.var(9).get()),","));
                if (mOp.NotEqual(m$.Fnc.$extract(YPARA.var(9).get()),"\"")) {
                  if (mOp.Equal(m$.Fnc.$get(m$.indirectVar((YPARA.var(9).get()))),"")) {
                    Q.set(1);
                    break;
                  }
                }
              }
              //<< . . if Q=1 set Q=0 quit
              if (mOp.Equal(Q.get(),1)) {
                Q.set(0);
                break;
              }
              //<< . . set YPARA(99)=YPARA(99)_"YPARA(5),"""_SPRACHE_""",1)"
              YPARA.var(99).set(mOp.Concat(mOp.Concat(mOp.Concat(YPARA.var(99).get(),"YPARA(5),\""),m$.var("SPRACHE").get()),"\",1)"));
              //<< . . quit:$data(@(YPARA(99)))#10'=1
              if (mOp.NotEqual(mOp.Modulus(m$.Fnc.$data(m$.indirectVar((YPARA.var(99).get()))),10),1)) {
                break;
              }
              //<< . . set YSORT=$piece($get(@YPARA(99)),Y,1)
              YSORT.set(m$.Fnc.$piece(m$.Fnc.$get(m$.indirectVar(YPARA.var(99).get())),m$.var("Y").get(),1));
              //<< . . if YSORT="" set YSORT=" "
              if (mOp.Equal(YSORT.get(),"")) {
                YSORT.set(" ");
              }
              //<< . . set YSORT(1)=YSORT
              YSORT.var(1).set(YSORT.get());
            } while (false);
          }
          //<< . ;
          //<< . if +YPARA(12)=0 set YSORT(1)=YPARA(5)  ;NICHT SORTIERT ;Not
          if (mOp.Equal(mOp.Positive(YPARA.var(12).get()),0)) {
            YSORT.var(1).set(YPARA.var(5).get());
          }
          //<< . set YSORT=$extract($translate(YSORT,"|"," "),1,100)
          YSORT.set(m$.Fnc.$extract(m$.Fnc.$translate(YSORT.get(),"|"," "),1,100));
          //<< . ;
          //<< . ; YPARA(20) "Relation Display Options" '= 1 : "Display Relations after Input"
          //<< . ;
          //<< . if YXTYP'=6 if YPARA(20)=1 if YXTYP'=1 do  if YPARA(22)=1 set YPARA(7)=YPARA(7)-1 quit
          if (mOp.NotEqual(m$.var("YXTYP").get(),6)) {
            if (mOp.Equal(YPARA.var(20).get(),1)) {
              if (mOp.NotEqual(m$.var("YXTYP").get(),1)) {
                //<< . . new YYI
                mVar YYI = m$.var("YYI");
                m$.newVar(YYI);
                //<< . . set YPARA(22)=1
                YPARA.var(22).set(1);
                //<< . . if YUMLAU="" if $find($translate(YPARA(5),LC,UC),$translate(YINHALT,LC,UC)) set YPARA(21)=YPARA(21)+1,YPARA(22)=0
                if (mOp.Equal(m$.var("YUMLAU").get(),"")) {
                  if (mOp.Logical(m$.Fnc.$find(m$.Fnc.$translate(YPARA.var(5).get(),m$.var("LC").get(),m$.var("UC").get()),m$.Fnc.$translate(m$.var("YINHALT").get(),m$.var("LC").get(),m$.var("UC").get())))) {
                    YPARA.var(21).set(mOp.Add(YPARA.var(21).get(),1));
                    YPARA.var(22).set(0);
                  }
                }
                //<< . . if YUMLAU'="" if $find($$^WWWUMLAU(YPARA(5),1),$$^WWWUMLAU(YINHALT,1))      set YPARA(21)=YPARA(21)+1,YPARA(22)=0
                if (mOp.NotEqual(m$.var("YUMLAU").get(),"")) {
                  if (mOp.Logical(m$.Fnc.$find(m$.fnc$("WWWUMLAU.main",YPARA.var(5).get(),1),m$.fnc$("WWWUMLAU.main",m$.var("YINHALT").get(),1)))) {
                    YPARA.var(21).set(mOp.Add(YPARA.var(21).get(),1));
                    YPARA.var(22).set(0);
                  }
                }
                if (mOp.Equal(YPARA.var(22).get(),1)) {
                  YPARA.var(7).set(mOp.Subtract(YPARA.var(7).get(),1));
                  break;
                }
              }
            }
          }
          //<< . ;
          //<< . if YXTYP=6 if YPARA(20)=1 do  if YPARA(22)=1 set YPARA(7)=YPARA(7)-1 quit
          if (mOp.Equal(m$.var("YXTYP").get(),6)) {
            if (mOp.Equal(YPARA.var(20).get(),1)) {
              //<< . . new YYI
              mVar YYI = m$.var("YYI");
              m$.newVar(YYI);
              //<< . . set YPARA(22)=1
              YPARA.var(22).set(1);
              //<< . . if YUMLAU=""  for YYI=1:1 quit:$piece(YINHALT,",",YYI)=""  if $find($translate(YPARA(5),LC,UC),$translate($piece(YINHALT,",",YYI),LC,UC)) set YPARA(21)=YPARA(21)+1,YPARA(22)=0 quit
              if (mOp.Equal(m$.var("YUMLAU").get(),"")) {
                for (YYI.set(1);(true);YYI.set(mOp.Add(YYI.get(),1))) {
                  if (mOp.Equal(m$.Fnc.$piece(m$.var("YINHALT").get(),",",YYI.get()),"")) {
                    break;
                  }
                  if (mOp.Logical(m$.Fnc.$find(m$.Fnc.$translate(YPARA.var(5).get(),m$.var("LC").get(),m$.var("UC").get()),m$.Fnc.$translate(m$.Fnc.$piece(m$.var("YINHALT").get(),",",YYI.get()),m$.var("LC").get(),m$.var("UC").get())))) {
                    YPARA.var(21).set(mOp.Add(YPARA.var(21).get(),1));
                    YPARA.var(22).set(0);
                    break;
                  }
                }
              }
              //<< . . if YUMLAU'="" for YYI=1:1 quit:$piece(YINHALT,",",YYI)=""  if $find($$^WWWUMLAU(YPARA(5),1),$$^WWWUMLAU($piece(YINHALT,",",YYI),1))       set YPARA(21)=YPARA(21)+1,YPARA(22)=0 quit
              if (mOp.NotEqual(m$.var("YUMLAU").get(),"")) {
                for (YYI.set(1);(true);YYI.set(mOp.Add(YYI.get(),1))) {
                  if (mOp.Equal(m$.Fnc.$piece(m$.var("YINHALT").get(),",",YYI.get()),"")) {
                    break;
                  }
                  if (mOp.Logical(m$.Fnc.$find(m$.fnc$("WWWUMLAU.main",YPARA.var(5).get(),1),m$.fnc$("WWWUMLAU.main",m$.Fnc.$piece(m$.var("YINHALT").get(),",",YYI.get()),1)))) {
                    YPARA.var(21).set(mOp.Add(YPARA.var(21).get(),1));
                    YPARA.var(22).set(0);
                    break;
                  }
                }
              }
              if (mOp.Equal(YPARA.var(22).get(),1)) {
                YPARA.var(7).set(mOp.Subtract(YPARA.var(7).get(),1));
                break;
              }
            }
          }
          //<< . ;
          //<< . if YXTYP=1 if YPARA(20)=1 do  if YPARA(22)=1 set YPARA(7)=YPARA(7)-1 quit
          if (mOp.Equal(m$.var("YXTYP").get(),1)) {
            if (mOp.Equal(YPARA.var(20).get(),1)) {
              //<< . . new YYI
              mVar YYI = m$.var("YYI");
              m$.newVar(YYI);
              //<< . . set YPARA(22)=1
              YPARA.var(22).set(1);
              //<< . . if YUMLAU=""  for YYI=1:1 quit:$piece(YINHALT,",",YYI)=""  if $translate(YPARA(5),LC,UC)=$translate($piece(YINHALT,",",YYI),LC,UC) set YPARA(21)=1,YPARA(22)=0,YPARA(7)=1 quit
              if (mOp.Equal(m$.var("YUMLAU").get(),"")) {
                for (YYI.set(1);(true);YYI.set(mOp.Add(YYI.get(),1))) {
                  if (mOp.Equal(m$.Fnc.$piece(m$.var("YINHALT").get(),",",YYI.get()),"")) {
                    break;
                  }
                  if (mOp.Equal(m$.Fnc.$translate(YPARA.var(5).get(),m$.var("LC").get(),m$.var("UC").get()),m$.Fnc.$translate(m$.Fnc.$piece(m$.var("YINHALT").get(),",",YYI.get()),m$.var("LC").get(),m$.var("UC").get()))) {
                    YPARA.var(21).set(1);
                    YPARA.var(22).set(0);
                    YPARA.var(7).set(1);
                    break;
                  }
                }
              }
              //<< . . if YUMLAU'="" for YYI=1:1 quit:$piece(YINHALT,",",YYI)=""  if $$^WWWUMLAU(YPARA(5),1)=$$^WWWUMLAU($piece(YINHALT,",",YYI),1)       set YPARA(21)=1,YPARA(22)=0,YPARA(7)=1 quit
              if (mOp.NotEqual(m$.var("YUMLAU").get(),"")) {
                for (YYI.set(1);(true);YYI.set(mOp.Add(YYI.get(),1))) {
                  if (mOp.Equal(m$.Fnc.$piece(m$.var("YINHALT").get(),",",YYI.get()),"")) {
                    break;
                  }
                  if (mOp.Equal(m$.fnc$("WWWUMLAU.main",YPARA.var(5).get(),1),m$.fnc$("WWWUMLAU.main",m$.Fnc.$piece(m$.var("YINHALT").get(),",",YYI.get()),1))) {
                    YPARA.var(21).set(1);
                    YPARA.var(22).set(0);
                    YPARA.var(7).set(1);
                    break;
                  }
                }
              }
              if (mOp.Equal(YPARA.var(22).get(),1)) {
                YPARA.var(7).set(mOp.Subtract(YPARA.var(7).get(),1));
                break;
              }
            }
          }
          //<< . ;
          //<< . if +YPARA(12)'=0 set ^WWWSOR(YUSER,2,$zconvert(YSORT(1),"U"),YPARA(5)) = YSORT_" ("_YPARA(5)_")"
          if (mOp.NotEqual(mOp.Positive(YPARA.var(12).get()),0)) {
            m$.var("^WWWSOR",m$.var("YUSER").get(),2,m$.Fnc.$zconvert(YSORT.var(1).get(),"U"),YPARA.var(5).get()).set(mOp.Concat(mOp.Concat(mOp.Concat(YSORT.get()," ("),YPARA.var(5).get()),")"));
          }
          //<< . if +YPARA(12)=0  set ^WWWSOR(YUSER,2,$zconvert(YSORT(1),"U"),YPARA(5)) = YPARA(5)_" ("_YSORT_")"
          if (mOp.Equal(mOp.Positive(YPARA.var(12).get()),0)) {
            m$.var("^WWWSOR",m$.var("YUSER").get(),2,m$.Fnc.$zconvert(YSORT.var(1).get(),"U"),YPARA.var(5).get()).set(mOp.Concat(mOp.Concat(mOp.Concat(YPARA.var(5).get()," ("),YSORT.get()),")"));
          }
        } while (false);
        if (mOp.NotEqual(YPARA.var(20).get(),0)) {
          if (mOp.Greater(YPARA.var(7).get(),1300)) {
            break;
          }
          if (mOp.Equal(m$.Fnc.$get(m$.var("YYYFORM")),"WWWHPR")) {
            if (mOp.Greater(YPARA.var(7).get(),3)) {
              break;
            }
          }
        }
      }
    }
    //<< 
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< PARAM2
  public void PARAM2() {
    //<< ;-------------------------------------------------------------------------------
    //<< ; LESEN DER DISK ALS PARAMETER ;read the when parameter
    //<< ;
    //<< ; Called By: PARAM^WWWFORM71
    //<< ;
    //<< ;-------------------------------------------------------------------------------
    //<< set YPARA(19) = YPARA(2)  ;SUCHSTRING
    mVar YPARA = m$.var("YPARA");
    YPARA.var(19).set(m$.var("YPARA").var(2).get());
    //<< if YPARA(19)'="" if $extract(YPARA(19))'="""" set YPARA(19) = $get(@YPARA(2)) if YPARA(19)="" quit  ;VARIABLENZUWEISUNG UND Q, WENN DIE VARIABLE ""
    if (mOp.NotEqual(YPARA.var(19).get(),"")) {
      if (mOp.NotEqual(m$.Fnc.$extract(YPARA.var(19).get()),"\"")) {
        YPARA.var(19).set(m$.Fnc.$get(m$.indirectVar(YPARA.var(2).get())));
        if (mOp.Equal(YPARA.var(19).get(),"")) {
          return;
        }
      }
    }
    //<< set YPARA(19) = $translate(YPARA(19),"""*")
    YPARA.var(19).set(m$.Fnc.$translate(YPARA.var(19).get(),"\"*"));
    //<< if $find(YPARA(1),"##") {    ;wenn mandant = path in verzeichnis ;when within
    if (mOp.Logical(m$.Fnc.$find(YPARA.var(1).get(),"##"))) {
      //<< set YPARA(1) = $piece(YPARA(1),"##",1)_$piece($translate($piece($get(^WWW012(0,YM,1)),Y,1),"-,+#/\()[]")," ",1)_$piece(YPARA(1),"##",2)
      YPARA.var(1).set(mOp.Concat(mOp.Concat(m$.Fnc.$piece(YPARA.var(1).get(),"##",1),m$.Fnc.$piece(m$.Fnc.$translate(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW012",0,m$.var("YM").get(),1)),m$.var("Y").get(),1),"-,+#/\\()[]")," ",1)),m$.Fnc.$piece(YPARA.var(1).get(),"##",2)));
    }
    //<< }
    //<< 
    //<< if $extract(YPARA(1),$length(YPARA(1)))'="\" set YPARA(1) = YPARA(1)_"\"
    if (mOp.NotEqual(m$.Fnc.$extract(YPARA.var(1).get(),m$.Fnc.$length(YPARA.var(1).get())),"\\")) {
      YPARA.var(1).set(mOp.Concat(YPARA.var(1).get(),"\\"));
    }
    //<< set YPARA(1) = YPARA(1)_"*"                ;ALLES AUSWÄHLEN ;whatsoever pick out
    YPARA.var(1).set(mOp.Concat(YPARA.var(1).get(),"*"));
    //<< set YSORT(1) = $zsearch(YPARA(1))
    mVar YSORT = m$.var("YSORT");
    YSORT.var(1).set(m$.Fnc.$zsearch(YPARA.var(1).get()));
    //<< if YSORT(1)'=""  for  set YSORT(1)=$zsearch("") quit:YSORT(1)=""  do
    if (mOp.NotEqual(YSORT.var(1).get(),"")) {
      for (;true;) {
        YSORT.var(1).set(m$.Fnc.$zsearch(""));
        if (mOp.Equal(YSORT.var(1).get(),"")) {
          break;
        }
        do {
          //<< . quit:$find(YSORT(1),"..")   ;DIRECTORY
          if (mOp.Logical(m$.Fnc.$find(YSORT.var(1).get(),".."))) {
            break;
          }
          //<< . quit:'$find(YSORT(1),".")   ;KEINE ERWEITERUNG ODER DIR ;no amplification Or yourself
          if (mOp.Not(m$.Fnc.$find(YSORT.var(1).get(),"."))) {
            break;
          }
          //<< . quit:'$find($piece(YSORT(1),"\",$length(YSORT(1),"\")),YPARA(19))      ;NICHT VORHANDEN IN SUCHSTRING, SUCHSTRING = FILENAME
          if (mOp.Not(m$.Fnc.$find(m$.Fnc.$piece(YSORT.var(1).get(),"\\",m$.Fnc.$length(YSORT.var(1).get(),"\\")),YPARA.var(19).get()))) {
            break;
          }
          //<< . set ^WWWSOR(YUSER,2,$$^WWWUMLAU(YSORT(1),3)_" ",YSORT(1))=YSORT(1)_" "
          m$.var("^WWWSOR",m$.var("YUSER").get(),2,mOp.Concat(m$.fnc$("WWWUMLAU.main",YSORT.var(1).get(),3)," "),YSORT.var(1).get()).set(mOp.Concat(YSORT.var(1).get()," "));
          //<< . set YTYPE    = "TEXT"
          mVar YTYPE = m$.var("YTYPE");
          YTYPE.set("TEXT");
          //<< . set YPARA(7) = $get(YPARA(7))+1
          YPARA.var(7).set(mOp.Add(m$.Fnc.$get(YPARA.var(7)),1));
        } while (false);
      }
    }
    //<< 
    //<< quit
    return;
  }

  //<< 
  //<< 
  //<< GetCalculatedValue(pidClass,pidField,pidKeys,pstrData)
  public Object GetCalculatedValue(Object ... _p) {
    mVar pidClass = m$.newVarRef("pidClass",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pidField = m$.newVarRef("pidField",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pidKeys = m$.newVarRef("pidKeys",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    mVar pstrData = m$.newVarRef("pstrData",(((_p!=null)&&(_p.length>=4))?_p[3]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Get the Calculated Value of the Field for a Class
    //<< ;
    //<< ; Called By: TEXT^COMGridEdit31F, MiniText^COMGridEdit31F,
    //<< ;            DisplayValue^COMViewFilter, CreateCombo^COMViewFilterCombo,
    //<< ;            PARAMETER^WWWEVENT, PARAM^WWWFORM71
    //<< ;
    //<< ; Params:   pidClass    - Class
    //<< ;           pidField    - Calculated Field #
    //<< ;           pidKeys     - ID Keys
    //<< ;           pstrData    - Original Data
    //<< ;
    //<< ; ByRefs:
    //<< ;
    //<< ; Returns:  %String Value
    //<< ;
    //<< ; History:
    //<< ; 05-Jul-2011   shobby  SR17815: Somewhere buried deep down in the call to
    //<< ;                           GetCalculatedValue, it may be that a calculated property
    //<< ;                           is called that relies on YFELD being set.
    //<< ;                           INMOVByPallet (OriginalPhysicalStorage) is an example.
    //<< ;                           So the parameter has been renamed to YFELD .
    //<< ;                           pstrData should remain because it is possible that INRECSummary
    //<< ;                           is using this.
    //<< ; 29-Jun-2009   PPP     SR16663: Add the Calculated Relation Display Fields
    //<< ;-------------------------------------------------------------------------------
    //<< new strValue,YFELD ;SR17815
    mVar strValue = m$.var("strValue");
    mVar YFELD = m$.var("YFELD");
    m$.newVar(strValue,YFELD);
    //<< 
    //<< set YFELD=pstrData ;SR17815
    YFELD.set(pstrData.get());
    //<< set pidKeys  = $translate(pidKeys,$char(34))
    pidKeys.set(m$.Fnc.$translate(pidKeys.get(),m$.Fnc.$char(34)));
    //<< set strValue = $$GetCalculatedValue^COMViewFilter(pidClass,"c"_pidField,pidKeys,pstrData," ")
    strValue.set(m$.fnc$("COMViewFilter.GetCalculatedValue",pidClass.get(),mOp.Concat("c",pidField.get()),pidKeys.get(),pstrData.get()," "));
    //<< 
    //<< quit strValue
    return strValue.get();
  }

//<< 
//<< /* EXAMPLES OF YPARA and WWWSOR USE         ["--" : No entry]
//<< 
//<< A number of the YPARA entries are used to simulate $query using $order
//<< - would have been better using different variable names.
//<< These are indicated with "##".
//<< Others are used to construct the "Enum - Description  " string
//<< Those marked with "?" may not be cleared from some earlier processing
//<< rather than indicating actual data passed in.
//<< 
//<< ^WWW100(0,"JA/NEIN",SPRACHE,enumCode,1)
//<< ---------------------------------------
//<< 
//<< INITIAL YPARA                               FINAL YPARA                         FINAL WWWSOR
//<< 0             --                            ""                                  ^WWWSOR(YUSER,2,0,0) = "0 - No  "
//<< 1           WWW100                          WWW100                              ^WWWSOR(YUSER,2,1,1) = "1 - Yes  "
//<< 2           "JA/NEIN",SPRACHE               "JA/NEIN",SPRACHE
//<< 3           1                               1
//<< 4             --                    ##      ^WWW100(0,"JA/NEIN",SPRACHE,
//<< 5             --                    ##      ""
//<< 6             --                    ##      ^WWW100(0,"JA/NEIN",SPRACHE,"1",1)
//<< ?   7           0                               3
//<< 9             --                            ""
//<< 10            --                    ##      ^WWW100(0,"JA/NEIN",SPRACHE,YPARA(5))
//<< 12          ""                              ""
//<< 19            --                    ##      ^WWW100(0,"JA/NEIN","EN","1",1)
//<< 20          ""                              ""
//<< 21            --                            0
//<< ?   29          1                               1
//<< 33          ""                              ""
//<< 44            --                    ##      ^WWW100(0,"JA/NEIN","EN",
//<< 51            --                            ""
//<< 52            --                            ""
//<< 53            --                            1
//<< 55            --                            0
//<< 67          ""                              ""
//<< 79          ""                              ""
//<< ?   80          ""                              ""
//<< 81            --                            ""
//<< 82            --                            ""
//<< 83            --                            ""
//<< 84            --                            ""
//<< 88            --                            2
//<< 120         ""                              ""
//<< 155           --                            6
//<< "ANZ"         --                            2
//<< ?   "CF         ""                              ""
//<< "Excluded"    --                            0
//<< 
//<< 
//<< ^WWW100(0,"FARBE",SPRACHE,enumCode,1)
//<< ---------------------------------------
//<< INITIAL YPARA                               FINAL YPARA                         FINAL WWWSOR
//<< 0             --                            ""                                  ^WWWSOR(YUSER,2,1,1)   = "1 - aliceblue  "
//<< 1           WWW100                          WWW100                              ^WWWSOR(YUSER,2,2,2)   = "2 - antiquewhite  "
//<< 2           "FARBE",SPRACHE                 "FARBE",SPRACHE                     ...
//<< 3           1                               1                                   ^WWWSOR(YUSER,284,284) = "284 - windowtext  "
//<< 4             --                    ##      ^WWW100(0,"FARBE",SPRACHE,
//<< 5             --                    ##      ""
//<< 6             --                    ##      ^WWW100(0,"FARBE",SPRACHE,"284",1)
//<< ?   7           0                               169
//<< 9             --                            ""
//<< 10            --                    ##      ^WWW100(0,"FARBE",SPRACHE,YPARA(5))
//<< 12          ""                              ""
//<< 19            --                    ##      ^WWW100(0,"FARBE","EN","284",1)
//<< 20          ""                              ""
//<< 21            --                            0
//<< ?   29          1                               1
//<< 33          ""                              ""
//<< 44            --                    ##      ^WWW100(0,"FARBE","EN",
//<< 51            --                            ""
//<< 52            --                            ""
//<< 53            --                            284
//<< 55            --                            0
//<< 67          ""                              ""
//<< 79          ""                              ""
//<< ?   80          ""                              ""
//<< 81            --                            ""
//<< 82            --                            ""
//<< 83            --                            ""
//<< 84            --                            ""
//<< 88            --                            2
//<< 120         ""                              ""
//<< 155           --                            6
//<< "ANZ"         --                            168
//<< ?   "CF         ""                              ""
//<< "Excluded"    --                            0
//<< 
//<< 
//<< 
//<< */
//<< 
//<< 
//<< 
//<< 
//<< 
}
