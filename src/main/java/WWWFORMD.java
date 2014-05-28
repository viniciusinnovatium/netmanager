//*****************************************************************************
//** TASC - ALPHALINC - MAC WWWFORMD
//** Innovatium Systems - Code Converter - v1.28
//** 2014-05-26 21:13:39
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

//<< WWWFORMD
public class WWWFORMD extends mClass {

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
    _WWWFORMD();
  }

  public void _WWWFORMD() {
    //<< #;define LogR(%1,%2)    $$$JournalOff s ^zzLogR($g(YBED,"UNK"),$i(^zzLogR))= %1_"^WWWFORMD("_%2_") : "_$zh $$$JournalOn
    //<< #;define LogR2(%1,%2)   $$$JournalOff s ^zzLogR($g(YBED,"UNK"),$i(^zzLogR))= %1_"^WWWFORMD("_%2_") : "_$zh $$$JournalOn
    //<< #;define LogRx(%1)      $$$JournalOff s ^zzLogR($g(YBED,"UNK"),$i(^zzLogR))=%1 $$$JournalOn
    //<< #;define LogRm(%1)      $$$JournalOff m ^zzLogR($g(YBED,"UNK"),$i(^zzLogR))=%1 $$$JournalOn
    //<< 
    //<< ;-------------------------------------------------------------------------------
    //<< ; Description of Function :
    //<< ;       Show datafields
    //<< ;
    //<< ; Inputs :
    //<< ;
    //<< ;
    //<< ; ByRef :
    //<< ;   YFORM       Form Name
    //<< ;   YVOR        Form Parameters
    //<< ;   YFOART      Form Type
    //<< ;   YKEY
    //<< ;   YA
    //<< ;   YINSEITE
    //<< ;
    //<< ; Returns :
    //<< ;
    //<< ;
    //<< ; History :
    //<< ; 14-Apr-2009   GRF     $$$KEY Macros
    //<< ; 08-May-2007   GRF     SRBR014310: Doco; brace format
    //<< ; 14-Mar-2007   GRF     SR12505: doco; naked reference; quits; FIXME
    //<< ; 02-Sep-2005   JW      SR12966: WWW122 is shared
    //<< ; 30-May-2005   RobertW SR12056: Attempt at Performance Increase
    //<< ; 17-APR-2005   TYBD    NOADMIN FLAG SET IN CHECK OF THE READ/WRITE CHECK ON RULES
    //<< ; 05.08.1997    DT      ANZEIGEN DATENFELDER
    //<< ;-------------------------------------------------------------------------------
    //<< NEW YA,YDADO,YI,YLFDNR,YLFN,YPRIM,YSEI,YSPL,YZEILE
    mVar YA = m$.var("YA");
    mVar YDADO = m$.var("YDADO");
    mVar YI = m$.var("YI");
    mVar YLFDNR = m$.var("YLFDNR");
    mVar YLFN = m$.var("YLFN");
    mVar YPRIM = m$.var("YPRIM");
    mVar YSEI = m$.var("YSEI");
    mVar YSPL = m$.var("YSPL");
    mVar YZEILE = m$.var("YZEILE");
    m$.newVar(YA,YDADO,YI,YLFDNR,YLFN,YPRIM,YSEI,YSPL,YZEILE);
    //<< 
    //<< $$$LogR("",YFORM_"<"_YFOART)
    $$$LogR(m$,"",mOp.Concat(mOp.Concat(m$.var("YFORM").get(),"<"),m$.var("YFOART").get()));
    //<< 
    //<< QUIT:YFORM=""
    if (mOp.Equal(m$.var("YFORM").get(),"")) {
      return;
    }
    //<< QUIT:'$DATA(^WWW122(0,YFORM))
    if (mOp.Not(m$.Fnc.$data(m$.var("^WWW122",0,m$.var("YFORM").get())))) {
      return;
    }
    //<< 
    //<< ;---------------------------------------
    //<< ; YVOR          objForm         ^WWW120
    //<< ;
    //<< ;   D44     $$$WWW120FormFormatting()
    //<< ;       0       Single Field Formatting
    //<< ;       1       Format According To Longest Field
    //<< ;       2       Format In Pixels
    //<< ;---------------------------------------
    //<< IF $$$WWW012LineBelowPrimaryKey($GET(YVOR1))=1 IF YFOART'=3 DO          ; not Grid Form
    if (mOp.Equal(include.WWWConst.$$$WWW012LineBelowPrimaryKey(m$,m$.Fnc.$get(m$.var("YVOR1"))),1)) {
      if (mOp.NotEqual(m$.var("YFOART").get(),3)) {
        //<< . IF $DATA(^WWW121(0,YFORM)) DO
        if (mOp.Logical(m$.Fnc.$data(m$.var("^WWW121",0,m$.var("YFORM").get())))) {
          do {
            //<< . . IF $PIECE(YVOR,Y,44)=1 DO  QUIT
            if (mOp.Equal(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),44),1)) {
              //<< . . . WRITE "<TR>"
              m$.Cmd.Write("<TR>");
              //<< . . . WRITE "<TD><HR></TD><TD><HR STYLE=""border-color:"_YLIGHTGREY_"""></TD>"
              m$.Cmd.Write(mOp.Concat(mOp.Concat("<TD><HR></TD><TD><HR STYLE=\"border-color:",m$.var("YLIGHTGREY").get()),"\"></TD>"));
              //<< . . . FOR YI=1:1:20 IF $DATA(^WWW122s(0,3,$$^WWWUMLAU(YFORM,1),YSEITE,YI,2)) DO  QUIT
              for (YI.set(1);(mOp.LessOrEqual(YI.get(),20));YI.set(mOp.Add(YI.get(),1))) {
                if (mOp.Logical(m$.Fnc.$data(m$.var("^WWW122s",0,3,m$.fnc$("WWWUMLAU.main",m$.var("YFORM").get(),1),m$.var("YSEITE").get(),YI.get(),2)))) {
                  //<< . . . . WRITE "<TD><HR></TD><TD><HR STYLE=""border-color:"_YLIGHTGREY_"""></TD>"  ;2.TABULATOR
                  m$.Cmd.Write(mOp.Concat(mOp.Concat("<TD><HR></TD><TD><HR STYLE=\"border-color:",m$.var("YLIGHTGREY").get()),"\"></TD>"));
                  break;
                }
              }
              //<< . . . ;
              //<< . . . WRITE "</TR>"
              m$.Cmd.Write("</TR>");
              break;
            }
            //<< . . ;
            //<< . . IF $PIECE(YVOR,Y,44)=2  WRITE "<HR STYLE=""border-color:"_YLIGHTGREY_""">"
            if (mOp.Equal(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),44),2)) {
              m$.Cmd.Write(mOp.Concat(mOp.Concat("<HR STYLE=\"border-color:",m$.var("YLIGHTGREY").get()),"\">"));
            }
            //<< . . IF +$PIECE(YVOR,Y,44)=0 WRITE "<HR STYLE=""border-color:"_YLIGHTGREY_""">"
            if (mOp.Equal(mOp.Positive(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),44)),0)) {
              m$.Cmd.Write(mOp.Concat(mOp.Concat("<HR STYLE=\"border-color:",m$.var("YLIGHTGREY").get()),"\">"));
            }
          } while (false);
        }
      }
    }
    //<< 
    //<< ; Form Type 3 : Grid
    //<< ;---------------------------------------
    //<< IF YFOART=3 IF ($$$WWW120AuthorizationToModifyData(YVOR)=$$$EnumReadOnly) DO ^WWWFORM4 QUIT    ;KEINE EINGABE BEI "NUR LESEBERECHTIGUNG"
    if (mOp.Equal(m$.var("YFOART").get(),3)) {
      if ((mOp.Equal(include.WWWConst.$$$WWW120AuthorizationToModifyData(m$,m$.var("YVOR")),include.COMSYSEnum.$$$EnumReadOnly(m$)))) {
        m$.Cmd.Do("WWWFORM4.main");
        return;
      }
    }
    //<< IF (YFOART=3) && '$DATA(^WWW121(0,YFORM)) {             ;KEIN PRIMÄRSCHL.   ;SRBR014310
    if ((mOp.Equal(m$.var("YFOART").get(),3)) && mOp.Not(m$.Fnc.$data(m$.var("^WWW121",0,m$.var("YFORM").get())))) {
      //<< WRITE "<TR><TD></TD>"
      m$.Cmd.Write("<TR><TD></TD>");
    }
    //<< }
    //<< 
    //<< ;------------------------------------------------------------------------
    //<< 
    //<< ; HIDDEN WEIL VERSTECKTER PRIMÄRSCHLÜSSEL ;since
    //<< IF ($$$KEY1(YKEY)'="") && '$DATA(^WWW121(0,YFORM,1)) {  ;SRBR014310
    if ((mOp.NotEqual(include.COMSYSWWW.$$$KEY1(m$,m$.var("YKEY")),"")) && mOp.Not(m$.Fnc.$data(m$.var("^WWW121",0,m$.var("YFORM").get(),1)))) {
      //<< WRITE YCR,"<INPUT NAME=""Y"_YFORM_"P1"""
      m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat("<INPUT NAME=\"Y",m$.var("YFORM").get()),"P1\""));
      //<< WRITE " TYPE=HIDDEN"
      m$.Cmd.Write(" TYPE=HIDDEN");
      //<< WRITE " VALUE='"_$$$KEY1(YKEY)_"'"
      m$.Cmd.Write(mOp.Concat(mOp.Concat(" VALUE='",include.COMSYSWWW.$$$KEY1(m$,m$.var("YKEY"))),"'"));
      //<< WRITE ">"
      m$.Cmd.Write(">");
    }
    //<< }
    //<< 
    //<< IF '$DATA(YA) SET YA=""
    if (mOp.Not(m$.Fnc.$data(YA))) {
      YA.set("");
    }
    //<< IF +$GET(YINSEITE)=0 SET YINSEITE = 1  ;MINDESTENS 1. INNENSEITE
    if (mOp.Equal(mOp.Positive(m$.Fnc.$get(m$.var("YINSEITE"))),0)) {
      mVar YINSEITE = m$.var("YINSEITE");
      YINSEITE.set(1);
    }
    //<< KILL ^WWWSOR(YUSER,1)
    m$.var("^WWWSOR",m$.var("YUSER").get(),1).kill();
    //<< SET YINPAGE = 0      ;KEINE UNTERSEITE VORHANDEN ;no on hand
    mVar YINPAGE = m$.var("YINPAGE");
    YINPAGE.set(0);
    //<< SET YERSTES = 1      ;SUCHLAUF DURCH DATEI + ANZEIGE DER FELDER ;trans- data file Show the
    mVar YERSTES = m$.var("YERSTES");
    YERSTES.set(1);
    //<< DO FIELDS
    m$.Cmd.Do("FIELDS");
    //<< SET YDECIMALLEN = 2  ;NORMAL DECIMAL (reset after FIELDS possibly changes it?)
    mVar YDECIMALLEN = m$.var("YDECIMALLEN");
    YDECIMALLEN.set(2);
    //<< ;------------------------------------------------------------------------
    //<< WRITE YCR,"</TR>",YCR                                    ;ABSCHLUSS FELD ;field
    m$.Cmd.Write(m$.var("YCR").get(),"</TR>",m$.var("YCR").get());
    //<< IF ($PIECE(YVOR,Y,2)'=3) && ($PIECE(YVOR,Y,44)'=1) {     ;SRBR014310
    if ((mOp.NotEqual(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),2),3)) && (mOp.NotEqual(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),44),1))) {
      //<< WRITE "</TABLE>",YCR                                 ;ABSCHLUSS FORMAT
      m$.Cmd.Write("</TABLE>",m$.var("YCR").get());
      //<< SET YTABLEANZ = $GET(YTABLEANZ)-1
      mVar YTABLEANZ = m$.var("YTABLEANZ");
      YTABLEANZ.set(mOp.Subtract(m$.Fnc.$get(m$.var("YTABLEANZ")),1));
    }
    //<< }
    //<< 
    //<< IF $GET(YFIELDSET)>1  WRITE YCR,"</FIELDSET>",YCR SET YFIELDSET = 1  ;LETZTEN SCHLIESSEN
    if (mOp.Greater(m$.Fnc.$get(m$.var("YFIELDSET")),1)) {
      m$.Cmd.Write(m$.var("YCR").get(),"</FIELDSET>",m$.var("YCR").get());
      mVar YFIELDSET = m$.var("YFIELDSET");
      YFIELDSET.set(1);
    }
    //<< IF +$GET(YFIELDSET)=1 WRITE YCR,"</FIELDSET>",YCR SET YFIELDSET = 0  ;LETZTEN SCHLIESSEN
    if (mOp.Equal(mOp.Positive(m$.Fnc.$get(m$.var("YFIELDSET"))),1)) {
      m$.Cmd.Write(m$.var("YCR").get(),"</FIELDSET>",m$.var("YCR").get());
      mVar YFIELDSET = m$.var("YFIELDSET");
      YFIELDSET.set(0);
    }
    //<< IF YFOART=3 DO ^WWWFORM4
    if (mOp.Equal(m$.var("YFOART").get(),3)) {
      m$.Cmd.Do("WWWFORM4.main");
    }
    //<< QUIT
    return;
  }

  //<< 
  //<< FIELDS
  public void FIELDS() {
    //<< ;-------------------------------------------------------------------------------
    //<< ;       Select Field         ;SELECT FELDER
    //<< ;
    //<< ; ByRef :
    //<< ;   YFORM
    //<< ;   YUSER
    //<< ;   YSCREENM
    //<< ;
    //<< ; History:
    //<< ; 11-Sep-2009   shobby  SR16887: Corrected previous change.
    //<< ; 14-Apr-2009   GRF     Clean up commented code; WWW122 macros
    //<< ; 03-Oct-2007   shobby  SRBR014592: Include customisations from $$Get^WWW122
    //<< ;                           (Including RelationWithSearchFunc)
    //<< ; 25-Jun-2007   shobby  SRBR014409: Move the CheckRules call to a point after
    //<< ;                           the fields have been drawn.  This avoids the problems
    //<< ;                           of having fields not completely drawn if they are in
    //<< ;                           a readonly state.  ie List boxes only have the
    //<< ;                           currently selected entry drawn.  If we want to
    //<< ;                           enable them later... this is now possible.
    //<< ; 09-May-2007   GRF     SRBR014310: D123 in WWW122D did not correspond with use
    //<< ;                           in WWW122 - reassigned to D113 in both.
    //<< ; 13-Mar-2007   GRF     SR12505: doco; don't need + on YHIDDSE
    //<< ; 14-Dec-2006   HeberB  BR014339: Not to hidden if WWW122D1 has description
    //<< ;  5-Oct-2006   HeberB  SRBR014265: New rule at WWW122D2 'If Condition On Execute'
    //<< ; 12-Sep-2006   HeberB  SRBR014111: enable entering code at 'Execute For Check'
    //<< ;  9-Sep-2005   JW      Only call WWWUMLAU once (idxForm)
    //<< ;-------------------------------------------------------------------------------
    //<< new idxForm,objCompanyData
    mVar idxForm = m$.var("idxForm");
    mVar objCompanyData = m$.var("objCompanyData");
    m$.newVar(idxForm,objCompanyData);
    //<< 
    //<< $$$LogR("FIELDS",YFORM)
    $$$LogR(m$,"FIELDS",m$.var("YFORM"));
    do {
      //<< . SET ^WWWSOR(YUSER_"PAGE")=""        ;TYBD;18,2,2003 YUSER_"PAGE"
      m$.var("^WWWSOR",mOp.Concat(m$.var("YUSER").get(),"PAGE")).set("");
      //<< . LOCK +^WWWSOR(YUSER_"PAGE"):2
      m$.Cmd.LockInc(m$.var("^WWWSOR",mOp.Concat(m$.var("YUSER").get(),"PAGE")),2);
      //<< . KILL ^WWWSOR(YUSER_"PAGE")
      m$.var("^WWWSOR",mOp.Concat(m$.var("YUSER").get(),"PAGE")).kill();
      //<< . NEW YHIDDSE
      mVar YHIDDSE = m$.var("YHIDDSE");
      m$.newVarBlock(1,YHIDDSE);
      //<< . SET YBBN = ""
      mVar YBBN = m$.var("YBBN");
      YBBN.set("");
      //<< . FOR  SET YBBN = $ORDER(^WWW122(0,YFORM,YBBN)) QUIT:YBBN=""  DO
      for (;true;) {
        YBBN.set(m$.Fnc.$order(m$.var("^WWW122",0,m$.var("YFORM").get(),YBBN.get())));
        if (mOp.Equal(YBBN.get(),"")) {
          break;
        }
        //<< . . SET YSATZ       = $$Get^WWW122(YFORM,YBBN)          ; FELDDEFINITION
        mVar YSATZ = m$.var("YSATZ");
        YSATZ.set(m$.fnc$("WWW122.Get",m$.var("YFORM").get(),YBBN.get()));
        //<< . .;SET YINSEITE    =+$PIECE(YSATZ,Y,81)                ; INNENSEITEN VORHANDEN
        //<< . . SET YLFN        = $PIECE(YSATZ,Y,1)                 ; Class field number
        mVar YLFN = m$.var("YLFN");
        YLFN.set(m$.Fnc.$piece(YSATZ.get(),m$.var("Y").get(),1));
        //<< . . SET YDECIMALLEN = 2
        mVar YDECIMALLEN = m$.var("YDECIMALLEN");
        YDECIMALLEN.set(2);
        //<< . . ;
        //<< . . ; Initially not hidden unless a Free Field        ;SONDERFELD
        //<< . . ;-----------------------------------
        //<< . . SET YHIDDSE=0
        YHIDDSE.set(0);
        //<< . . IF +$GET(YSCREENM)'=1 IF $EXTRACT($PIECE(YSATZ,Y,12),1,5)="_FREE" SET YHIDDSE=1
        if (mOp.NotEqual(mOp.Positive(m$.Fnc.$get(m$.var("YSCREENM"))),1)) {
          if (mOp.Equal(m$.Fnc.$extract(m$.Fnc.$piece(YSATZ.get(),m$.var("Y").get(),12),1,5),"_FREE")) {
            YHIDDSE.set(1);
          }
        }
        //<< . . ;
        //<< . . ; Company Defaults
        //<< . . ; FIXME : <GRF> Call to $$Get^WWW122 applies WWW122D to WWW122 but may not
        //<< . . ;               include all following logic.  It *DOESN'T* include WWW122D1
        //<< . . ;               override of HIDDEN
        //<< . . ;-----------------------------------
        //<< . . IF $DATA(^WWW122D(0,YFORM,YBBN,YM,1)) DO
        if (mOp.Logical(m$.Fnc.$data(m$.var("^WWW122D",0,m$.var("YFORM").get(),YBBN.get(),m$.var("YM").get(),1)))) {
          //<< . . . NEW YSATZ1
          mVar YSATZ1 = m$.var("YSATZ1");
          m$.newVarBlock(3,YSATZ1);
          //<< . . . SET YSATZ1=$GET(^WWW122D(0,YFORM,YBBN,YM,1))
          YSATZ1.set(m$.Fnc.$get(m$.var("^WWW122D",0,m$.var("YFORM").get(),YBBN.get(),m$.var("YM").get(),1)));
          //<< . . . ;
          //<< . . . ; If there is a description under Company Default or Language Customisation -
          //<< . . . ; not hidden, but this can be overridden by explicit Company default setting.
          //<< . . . ;---------------------------------
          //<< . . . ;
          //<< . . . IF YHIDDSE=1 IF $PIECE(YSATZ1,Y,6)'="" SET YHIDDSE=0                      ;SONDERFELD
          if (mOp.Equal(YHIDDSE.get(),1)) {
            if (mOp.NotEqual(m$.Fnc.$piece(YSATZ1.get(),m$.var("Y").get(),6),"")) {
              YHIDDSE.set(0);
            }
          }
          //<< . . . IF YHIDDSE=1 IF $PIECE($get(^WWW122D1(0,YFORM,YBBN,YM,SPRACHE,1)),Y,1)'="" SET YHIDDSE=0  ;SONDERFELD
          if (mOp.Equal(YHIDDSE.get(),1)) {
            if (mOp.NotEqual(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW122D1",0,m$.var("YFORM").get(),YBBN.get(),m$.var("YM").get(),m$.var("SPRACHE").get(),1)),m$.var("Y").get(),1),"")) {
              YHIDDSE.set(0);
            }
          }
          //<< . . . IF $PIECE(YSATZ1,Y,13)=1    SET YHIDDSE=1                                 ;HIDDEN
          if (mOp.Equal(m$.Fnc.$piece(YSATZ1.get(),m$.var("Y").get(),13),1)) {
            YHIDDSE.set(1);
          }
          //<< . . . ;
          //<< . . . ; Override standard settings with Company Defaults
          //<< . . . ;---------------------------------
          //<< . . . ;BR014592 VVVV    These changes are now done inside the $$Get^WWW122 method.  Except for these last three
          //<< . . . ;                 Left them in for now so as not to change the functionality, although I would question the
          //<< . . . ;                 piece 2/13 functionality which allows you to make a core mandatory field not mandatory
          //<< . . . IF $PIECE(YSATZ1,Y,2)=$$$YES SET $$$WWW122MandatoryInputItem(YSATZ) = $$$YES  ; D13
          if (mOp.Equal(m$.Fnc.$piece(YSATZ1.get(),m$.var("Y").get(),2),include.COMSYS.$$$YES(m$))) {
            include.WWWConst.$$$WWW122MandatoryInputItemSet(m$,YSATZ,include.COMSYS.$$$YES(m$));
          }
          //<< . . . IF $PIECE(YSATZ1,Y,2)=$$$NO  SET $$$WWW122MandatoryInputItem(YSATZ) = $$$NO
          if (mOp.Equal(m$.Fnc.$piece(YSATZ1.get(),m$.var("Y").get(),2),include.COMSYS.$$$NO(m$))) {
            include.WWWConst.$$$WWW122MandatoryInputItemSet(m$,YSATZ,include.COMSYS.$$$NO(m$));
          }
          //<< . . . IF $PIECE(YSATZ1,Y,1)'=""    SET $$$WWW122DefaultVariableInput(YSATZ) = $PIECE(YSATZ1,Y,1) SET ^WWWDUMMY(YUSER,"TEMP")=YFELD  ; D15 SONDERVORGABE ;FIS;16.04.04;25550;SPEICHERN VORBELEGUNG FÜR PRÜFEN SAVE OHNE DATENFELDER
          if (mOp.NotEqual(m$.Fnc.$piece(YSATZ1.get(),m$.var("Y").get(),1),"")) {
            include.WWWConst.$$$WWW122DefaultVariableInputSet(m$,YSATZ,m$.Fnc.$piece(YSATZ1.get(),m$.var("Y").get(),1));
            m$.var("^WWWDUMMY",m$.var("YUSER").get(),"TEMP").set(m$.var("YFELD").get());
          }
        }
        m$.restoreVarBlock(3);
        //<< . . . ;BR014592 ^^^^
        //<< . . ;
        //<< . . ; FIXME : Class WWW122DU does not exist - either killed or set to 1 in WWWSCRA <GRF>
        //<< . . IF $GET(YBED)'=""         IF $PIECE($GET(^WWW122DU(0,YFORM,YM,YBED,YBBN,1)),Y,1)=1         SET YHIDDSE=1,YHID=2  ;TYBD;HIDDENBY USER
        if (mOp.NotEqual(m$.Fnc.$get(m$.var("YBED")),"")) {
          if (mOp.Equal(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW122DU",0,m$.var("YFORM").get(),m$.var("YM").get(),m$.var("YBED").get(),YBBN.get(),1)),m$.var("Y").get(),1),1)) {
            YHIDDSE.set(1);
            mVar YHID = m$.var("YHID");
            YHID.set(2);
          }
        }
        //<< . . IF $GET(YUSERPROFILE)'="" IF $PIECE($GET(^WWW122DU(0,YFORM,YM,YUSERPROFILE,YBBN,1)),Y,1)=1 SET YHIDDSE=1,YHID=2  ;TYBD;HIDDENBY USER
        if (mOp.NotEqual(m$.Fnc.$get(m$.var("YUSERPROFILE")),"")) {
          if (mOp.Equal(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW122DU",0,m$.var("YFORM").get(),m$.var("YM").get(),m$.var("YUSERPROFILE").get(),YBBN.get(),1)),m$.var("Y").get(),1),1)) {
            YHIDDSE.set(1);
            mVar YHID = m$.var("YHID");
            YHID.set(2);
          }
        }
        //<< . . ;
        //<< . . IF $PIECE(YSATZ,Y,60)<1 SET $PIECE(YSATZ,Y,60)=1  ;SEITE=1 WENN FALSCH ;when wrong
        if (mOp.Less(m$.Fnc.$piece(YSATZ.get(),m$.var("Y").get(),60),1)) {
          m$.pieceVar(YSATZ,m$.var("Y").get(),60).set(1);
        }
        //<< . . SET YSEI   = +$PIECE(YSATZ,Y,60)
        mVar YSEI = m$.var("YSEI");
        YSEI.set(mOp.Positive(m$.Fnc.$piece(YSATZ.get(),m$.var("Y").get(),60)));
        //<< . . SET YZEILE = +$PIECE(YSATZ,Y,3)                   ;ZEILE
        mVar YZEILE = m$.var("YZEILE");
        YZEILE.set(mOp.Positive(m$.Fnc.$piece(YSATZ.get(),m$.var("Y").get(),3)));
        //<< . . SET YSPL   = +$PIECE(YSATZ,Y,4)                   ;SPALTE ;column
        mVar YSPL = m$.var("YSPL");
        YSPL.set(mOp.Positive(m$.Fnc.$piece(YSATZ.get(),m$.var("Y").get(),4)));
        //<< . . IF YSEITE '= +$PIECE(YSATZ,Y,60) SET YHIDDSE=1    ;FALSCHE SEITE = HIDDENFELD ;hide if on different tab
        if (mOp.NotEqual(m$.var("YSEITE").get(),mOp.Positive(m$.Fnc.$piece(YSATZ.get(),m$.var("Y").get(),60)))) {
          YHIDDSE.set(1);
        }
        //<< . . IF +$PIECE(YSATZ,Y,81)'=0        SET YHIDDSE=1    ;INNENSEITE ABER VERSTECKT  ;yet covert
        if (mOp.NotEqual(mOp.Positive(m$.Fnc.$piece(YSATZ.get(),m$.var("Y").get(),81)),0)) {
          YHIDDSE.set(1);
        }
        //<< . . IF '$DATA(^WWW122(0,YFORM,YBBN)) SET YHIDDSE=1
        if (mOp.Not(m$.Fnc.$data(m$.var("^WWW122",0,m$.var("YFORM").get(),YBBN.get())))) {
          YHIDDSE.set(1);
        }
        //<< . . IF $$^WWWACCESS($PIECE(YSATZ,Y,22),$PIECE(YSATZ,Y,24))'=1 SET YHIDDSE=1    ;KEINE FELDBERECHTIGUNG MODUL ;no module
        if (mOp.NotEqual(m$.fnc$("WWWACCESS.main",m$.Fnc.$piece(YSATZ.get(),m$.var("Y").get(),22),m$.Fnc.$piece(YSATZ.get(),m$.var("Y").get(),24)),1)) {
          YHIDDSE.set(1);
        }
        //<< . . IF YSEI=YSEITE IF +$PIECE(YSATZ,Y,81)'=0 IF +YINSEITE'=+$PIECE(YSATZ,Y,81) SET YHIDDSE=1  ;INNENSEITEN VORHANDEN ;on hand
        if (mOp.Equal(YSEI.get(),m$.var("YSEITE").get())) {
          if (mOp.NotEqual(mOp.Positive(m$.Fnc.$piece(YSATZ.get(),m$.var("Y").get(),81)),0)) {
            if (mOp.NotEqual(mOp.Positive(m$.var("YINSEITE").get()),mOp.Positive(m$.Fnc.$piece(YSATZ.get(),m$.var("Y").get(),81)))) {
              YHIDDSE.set(1);
            }
          }
        }
        //<< . . ;
        //<< . . ; final customised field specification saved in presentation order
        //<< . . ; (UserPAGE,HiddenFlag,PageTab,InnerTab,Row,Column,FormField,ClassField)
        //<< . . SET ^WWWSOR(YUSER_"PAGE",YHIDDSE,+YSEI,+$PIECE(YSATZ,Y,81),YZEILE,YSPL,YBBN,+YLFN,1)=YSATZ
        m$.var("^WWWSOR",mOp.Concat(m$.var("YUSER").get(),"PAGE"),YHIDDSE.get(),mOp.Positive(YSEI.get()),mOp.Positive(m$.Fnc.$piece(YSATZ.get(),m$.var("Y").get(),81)),YZEILE.get(),YSPL.get(),YBBN.get(),mOp.Positive(YLFN.get()),1).set(YSATZ.get());
      }
      //<< . ;
      //<< . ;RESTLICHE FELDER=HIDDEN
      //<< . IF $GET(YDATEI)'="" SET YLFN="" FOR  SET YLFN=$ORDER(^WWW003(0,YDATEI,YLFN)) QUIT:YLFN=""  DO
      if (mOp.NotEqual(m$.Fnc.$get(m$.var("YDATEI")),"")) {
        mVar YLFN = m$.var("YLFN");
        YLFN.set("");
        for (;true;) {
          YLFN.set(m$.Fnc.$order(m$.var("^WWW003",0,m$.var("YDATEI").get(),YLFN.get())));
          if (mOp.Equal(YLFN.get(),"")) {
            break;
          }
          do {
            //<< . . QUIT:$DATA(^WWW122s(0,4,YLFN,YFORM))
            if (mOp.Logical(m$.Fnc.$data(m$.var("^WWW122s",0,4,YLFN.get(),m$.var("YFORM").get())))) {
              break;
            }
            //<< . . SET YSATZ=YLFN,YBBN=YLFN
            mVar YSATZ = m$.var("YSATZ");
            YSATZ.set(YLFN.get());
            YBBN.set(YLFN.get());
            //<< . . SET ^WWWSOR(YUSER_"PAGE",1,1,0,1,1,YBBN,YLFN,1)=YSATZ
            m$.var("^WWWSOR",mOp.Concat(m$.var("YUSER").get(),"PAGE"),1,1,0,1,1,YBBN.get(),YLFN.get(),1).set(YSATZ.get());
          } while (false);
        }
      }
      //<< . ;
      //<< . FOR YHIDDEN=0,1 DO
      mVar YHIDDEN = m$.var("YHIDDEN");
      for (Object _YHIDDEN: new Object[] {0,1}) {
        YHIDDEN.set(_YHIDDEN);
        //<< . . SET YSEI=""
        mVar YSEI = m$.var("YSEI");
        YSEI.set("");
        //<< . . FOR  SET YSEI=$ORDER(^WWWSOR(YUSER_"PAGE",YHIDDEN,YSEI)) QUIT:YSEI=""  DO
        for (;true;) {
          YSEI.set(m$.Fnc.$order(m$.var("^WWWSOR",mOp.Concat(m$.var("YUSER").get(),"PAGE"),_YHIDDEN,YSEI.get())));
          if (mOp.Equal(YSEI.get(),"")) {
            break;
          }
          //<< . . . SET YINSEITE=""
          mVar YINSEITE = m$.var("YINSEITE");
          YINSEITE.set("");
          //<< . . . FOR  SET YINSEITE=$ORDER(^WWWSOR(YUSER_"PAGE",YHIDDEN,YSEI,YINSEITE)) QUIT:YINSEITE=""  DO
          for (;true;) {
            YINSEITE.set(m$.Fnc.$order(m$.var("^WWWSOR",mOp.Concat(m$.var("YUSER").get(),"PAGE"),_YHIDDEN,YSEI.get(),YINSEITE.get())));
            if (mOp.Equal(YINSEITE.get(),"")) {
              break;
            }
            //<< . . . . SET YZEILE=""
            mVar YZEILE = m$.var("YZEILE");
            YZEILE.set("");
            //<< . . . . FOR  SET YZEILE=$ORDER(^WWWSOR(YUSER_"PAGE",YHIDDEN,YSEI,YINSEITE,YZEILE)) QUIT:YZEILE=""  DO
            for (;true;) {
              YZEILE.set(m$.Fnc.$order(m$.var("^WWWSOR",mOp.Concat(m$.var("YUSER").get(),"PAGE"),_YHIDDEN,YSEI.get(),YINSEITE.get(),YZEILE.get())));
              if (mOp.Equal(YZEILE.get(),"")) {
                break;
              }
              //<< . . . . . SET YSPL=""
              mVar YSPL = m$.var("YSPL");
              YSPL.set("");
              //<< . . . . . FOR  SET YSPL=$ORDER(^WWWSOR(YUSER_"PAGE",YHIDDEN,YSEI,YINSEITE,YZEILE,YSPL)) QUIT:YSPL=""  DO
              for (;true;) {
                YSPL.set(m$.Fnc.$order(m$.var("^WWWSOR",mOp.Concat(m$.var("YUSER").get(),"PAGE"),_YHIDDEN,YSEI.get(),YINSEITE.get(),YZEILE.get(),YSPL.get())));
                if (mOp.Equal(YSPL.get(),"")) {
                  break;
                }
                //<< . . . . . . SET YXBBN=""
                mVar YXBBN = m$.var("YXBBN");
                YXBBN.set("");
                //<< . . . . . . FOR  SET YXBBN=$ORDER(^WWWSOR(YUSER_"PAGE",YHIDDEN,YSEI,YINSEITE,YZEILE,YSPL,YXBBN)) QUIT:YXBBN=""  DO
                for (;true;) {
                  YXBBN.set(m$.Fnc.$order(m$.var("^WWWSOR",mOp.Concat(m$.var("YUSER").get(),"PAGE"),_YHIDDEN,YSEI.get(),YINSEITE.get(),YZEILE.get(),YSPL.get(),YXBBN.get())));
                  if (mOp.Equal(YXBBN.get(),"")) {
                    break;
                  }
                  //<< . . . . . . . SET YXLFN=""
                  mVar YXLFN = m$.var("YXLFN");
                  YXLFN.set("");
                  //<< . . . . . . . FOR  SET YXLFN=$ORDER(^WWWSOR(YUSER_"PAGE",YHIDDEN,YSEI,YINSEITE,YZEILE,YSPL,YXBBN,YXLFN)) QUIT:YXLFN=""  DO
                  for (;true;) {
                    YXLFN.set(m$.Fnc.$order(m$.var("^WWWSOR",mOp.Concat(m$.var("YUSER").get(),"PAGE"),_YHIDDEN,YSEI.get(),YINSEITE.get(),YZEILE.get(),YSPL.get(),YXBBN.get(),YXLFN.get())));
                    if (mOp.Equal(YXLFN.get(),"")) {
                      break;
                    }
                    //<< . . . . . . . . SET YSATZ=$GET(^WWWSOR(YUSER_"PAGE",YHIDDEN,YSEI,YINSEITE,YZEILE,YSPL,YXBBN,YXLFN,1))
                    mVar YSATZ = m$.var("YSATZ");
                    YSATZ.set(m$.Fnc.$get(m$.var("^WWWSOR",mOp.Concat(m$.var("YUSER").get(),"PAGE"),_YHIDDEN,YSEI.get(),YINSEITE.get(),YZEILE.get(),YSPL.get(),YXBBN.get(),YXLFN.get(),1)));
                    //<< . . . . . . . . SET YLFN    = YXLFN    IF YLFN=0 SET YLFN = ""
                    mVar YLFN = m$.var("YLFN");
                    YLFN.set(YXLFN.get());
                    if (mOp.Equal(YLFN.get(),0)) {
                      YLFN.set("");
                    }
                    //<< . . . . . . . . SET YBBN    = YXBBN
                    YBBN.set(YXBBN.get());
                    //<< . . . . . . . . SET YHIDDSE = YHIDDEN
                    YHIDDSE.set(_YHIDDEN);
                    //<< . . . . . . . . SET YDECIMALLEN = 2
                    mVar YDECIMALLEN = m$.var("YDECIMALLEN");
                    YDECIMALLEN.set(2);
                    //<< . . . . . . . . IF $$$WWW122Decimals(YSATZ)'="" SET YDECIMALLEN = $$$WWW122Decimals(YSATZ)
                    if (mOp.NotEqual(include.WWWConst.$$$WWW122Decimals(m$,YSATZ),"")) {
                      YDECIMALLEN.set(include.WWWConst.$$$WWW122Decimals(m$,YSATZ));
                    }
                    //<< . . . . . . . . DO FORMVOR
                    m$.Cmd.Do("FORMVOR");
                  }
                }
              }
            }
          }
        }
      }
      //<< . ;
      //<< . $$$StartScript()
      include.COMSYS.$$$StartScript(m$);
      //<< . do CheckRules^WWWEVENT(YFORM,YFELD)     ; Customising Rules Check WWW122D2
      m$.Cmd.Do("WWWEVENT.CheckRules",m$.var("YFORM").get(),m$.var("YFELD").get());
      //<< . $$$EndScript()
      include.COMSYS.$$$EndScript(m$);
      //<< . LOCK -^WWWSOR(YUSER_"PAGE")
      m$.Cmd.Unlock(m$.var("^WWWSOR",mOp.Concat(m$.var("YUSER").get(),"PAGE")));
      //<< . KILL ^WWWSOR(YUSER_"PAGE")
      m$.var("^WWWSOR",mOp.Concat(m$.var("YUSER").get(),"PAGE")).kill();
    } while(false);
    m$.restoreVarBlock(1);
    //<< 
    //<< ;---------------------------------------
    //<< ;   YSATZ       objFormData     ^WWW122
    //<< ;   YSATZ1      objCompanyData  ^WWW122D
    //<< ;---------------------------------------
    //<< 
    //<< ; FIXME : <GRF> see note in further FIXME below re QUIT
    //<< DO  QUIT                              ;ZUSAMMENSTELLEN DER DATEN; ;the
    return;
  }

  //<< 
  //<< 
  //<< ; see ^^^ for QUIT
  //<< 
  //<< ;vvvvvvvvv FIXME : <GRF> Quit after DO above renders the following code obsolete (or should the quit be removed?)
  //<< 
  //<< ;vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv DISABLED BLOCK START
  //<< 
  //<< /*
  //<< ;------------------------------------------------------------------------
  //<< set idxForm = $$^WWWUMLAU(YFORM,1)  // JW
  //<< FOR YSEI=" ",YSEITE DO
  //<< . SET YERSTES=1  ;IMMER AUF JEDER SEITE ;constantly upon everyone side
  //<< . SET YZEILE=""
  //<< . FOR  SET YZEILE=$ORDER(^WWW122s(0,3,idxForm,YSEI,YZEILE)) QUIT:YZEILE=""  DO
  //<< . . SET YSPL=""
  //<< . . FOR  SET YSPL=$ORDER(^WWW122s(0,3,idxForm,YSEI,YZEILE,YSPL)) QUIT:YSPL=""  DO
  //<< . . . SET YBBN=""
  //<< . . . FOR  SET YBBN=$ORDER(^WWW122s(0,3,idxForm,YSEI,YZEILE,YSPL,YFORM,YBBN)) QUIT:YBBN=""  DO
  //<< . . . . SET YSATZ=$GET(^WWW122(0,YFORM,YBBN,1))             ;FELDDEFINITION
  //<< . . . . IF YSEI=YSEITE IF +$PIECE(YSATZ,Y,81)'=0 SET YINPAGE=1 QUIT:YINSEITE=+$PIECE(YSATZ,Y,81)  ;INNENSEITEN VORHANDEN ;on hand
  //<< . . . . SET YLFN=$PIECE(YSATZ,Y,1)                          ;DATENBANKFELD
  //<< . . . . IF +$PIECE(YSATZ,Y,60)<1 SET $PIECE(YSATZ,Y,60)=1   ;SEITE=1 WENN FALSCH ;when wrong
  //<< . . . . SET YHIDDSE=0                                       ;nicht hidden ;not
  //<< . . . . IF +$GET(YSCREENM)'=1 IF $EXTRACT($PIECE(YSATZ,Y,12),1,5)="_FREE" SET YHIDDSE=1  ;SONDERFELD
  //<< . . . . IF $DATA(^WWW122D(0,YFORM,YBBN,YM,1)) DO
  //<< . . . . . set objCompanyData = $get(^WWW122D(0,YFORM,YBBN,YM,1))
  //<< . . . . . IF YHIDDSE=1 IF $PIECE(objCompanyData,Y,6)'="" SET YHIDDSE=0                            ;SONDERFELD
  //<< . . . . . IF $PIECE(objCompanyData,Y,1)'=""  SET $PIECE(YSATZ,Y,15)=$PIECE(objCompanyData,Y,1)    ;SONDERVORGABE
  //<< . . . . . IF $PIECE(objCompanyData,Y,13)=1   SET YHIDDSE=1                                        ;HIDDEN
  //<< . . . . . IF $PIECE(objCompanyData,Y,4)'=""  SET $PIECE(YSATZ,Y,24)=$PIECE(objCompanyData,Y,4)    ;MODUL ;module
  //<< . . . . . IF $PIECE(objCompanyData,Y,42)'="" SET $PIECE(YSATZ,Y,22)=$PIECE(objCompanyData,Y,42)   ;BERECHTIGUNG
  //<< . . . . . IF $PIECE(objCompanyData,Y,63)'="" SET $PIECE(YSATZ,Y,63)=$TRANSLATE($PIECE(objCompanyData,Y,63),",",";")   ;RELATIONSFELDER
  //<< . . . . ;
  //<< . . . . IF YSEITE'=+$PIECE(YSATZ,Y,60)   SET YHIDDSE=1  ;FALSCHE SEITE = HIDDENFELD ;side
  //<< . . . . IF +$PIECE(YSATZ,Y,81)'=0        SET YHIDDSE=1  ;INNENSEITE ABER VERSTECKT ;yet covert
  //<< . . . . IF '$DATA(^WWW122(0,YFORM,YBBN)) SET YHIDDSE=1
  //<< . . . . IF $$^WWWACCESS($PIECE(YSATZ,Y,22),$PIECE(YSATZ,Y,24))'=1 SET YHIDDSE=1    ;KEINE FELDBERECHTIGUNG MODUL ;no module
  //<< . . . . DO FORMVOR
  //<< 
  //<< ;------------------------------------------------------------------------
  //<< SET YSEI=""
  //<< FOR  SET YSEI=$ORDER(^WWW122s(0,3,idxForm,YSEI)) QUIT:YSEI=""  IF YSEI'=" " IF YSEI'=YSEITE DO
  //<< .;SET YERSTES=1  ;IMMER AUF JEDER SEITE ;table-mat constantly upon everyone side
  //<< . SET YZEILE=""
  //<< . FOR  SET YZEILE=$ORDER(^WWW122s(0,3,idxForm,YSEI,YZEILE)) QUIT:YZEILE=""  DO
  //<< . . SET YSPL=""
  //<< . . FOR  SET YSPL=$ORDER(^WWW122s(0,3,idxForm,YSEI,YZEILE,YSPL)) QUIT:YSPL=""  DO
  //<< . . . SET YBBN=""
  //<< . . . FOR  SET YBBN=$ORDER(^WWW122s(0,3,idxForm,YSEI,YZEILE,YSPL,YFORM,YBBN)) QUIT:YBBN=""  DO
  //<< . . . . SET YSATZ=$GET(^WWW122(0,YFORM,YBBN,1))  ;FELDDEFINITION
  //<< . . . . IF YSEI=YSEITE IF +$PIECE(YSATZ,Y,81)'=0 SET YINPAGE=1 QUIT:YINSEITE=+$PIECE(YSATZ,Y,81)  ;INNENSEITEN VORHANDEN ;on hand
  //<< . . . . SET YLFN=$PIECE(YSATZ,Y,1)  ;DATENBANKFELD
  //<< . . . . IF +$PIECE(YSATZ,Y,60)<1 SET $PIECE(YSATZ,Y,60)=1  ;SEITE=1 WENN FALSCH ;when wrong
  //<< . . . . SET YHIDDSE=0   ;nicht hidden ;not
  //<< . . . . IF $EXTRACT($PIECE(YSATZ,Y,12),1,5)="_FREE" SET YHIDDSE=1  ;SONDERFELD
  //<< . . . . IF $DATA(^WWW122D(0,YFORM,YBBN,YM,1)) DO
  //<< . . . . . set objCompanyData = $get(^WWW122D(0,YFORM,YBBN,YM,1))
  //<< . . . . . IF YHIDDSE=1 IF $PIECE(objCompanyData,Y,6)'="" SET YHIDDSE=0  ;SONDERFELD
  //<< . . . . . IF $PIECE(objCompanyData,Y,1)'="" SET $PIECE(YSATZ,Y,15)=$PIECE(objCompanyData,Y,1)  ;SONDERVORGABE
  //<< . . . . . IF $PIECE(objCompanyData,Y,13)=1  SET YHIDDSE=1  ;HIDDEN
  //<< . . . . ;
  //<< . . . . IF YSEITE'=+$PIECE(YSATZ,Y,60)   SET YHIDDSE=1  ;FALSCHE SEITE = HIDDENFELD ;side
  //<< . . . . IF +$PIECE(YSATZ,Y,81)'=0        SET YHIDDSE=1  ;INNENSEITE ABER VERSTECKT ;yet covert
  //<< . . . . IF '$DATA(^WWW122(0,YFORM,YBBN)) SET YHIDDSE=1
  //<< . . . . IF $$^WWWACCESS($PIECE(YSATZ,Y,22),$PIECE(YSATZ,Y,24))'=1 SET YHIDDSE=1    ;KEINE FELDBERECHTIGUNG MODUL ;no module
  //<< . . . . DO FORMVOR
  //<< 
  //<< ;------------------------------------------------------------------------
  //<< IF YINPAGE=1 DO
  //<< . DO ^WWWFORM6  ;INNENSEITENREITER
  //<< . SET YSEI=""
  //<< . FOR  SET YSEI=$ORDER(^WWW122s(0,3,idxForm,YSEI)) QUIT:YSEI=""  DO
  //<< . . SET YZEILE=""
  //<< . . FOR  SET YZEILE=$ORDER(^WWW122s(0,3,idxForm,YSEI,YZEILE)) QUIT:YZEILE=""  DO
  //<< . . . SET YSPL=""
  //<< . . . FOR  SET YSPL=$ORDER(^WWW122s(0,3,idxForm,YSEI,YZEILE,YSPL)) QUIT:YSPL=""  DO
  //<< . . . . SET YBBN=""
  //<< . . . . FOR  SET YBBN=$ORDER(^WWW122s(0,3,idxForm,YSEI,YZEILE,YSPL,YFORM,YBBN)) QUIT:YBBN=""  DO
  //<< . . . . . SET YSATZ=$GET(^WWW122(0,YFORM,YBBN,1))  ;FELDDEFINITION
  //<< . . . . . IF +$PIECE(YSATZ,Y,81)'=+YINSEITE QUIT   ;INNENSEITEN VORHANDEN ;on hand
  //<< . . . . . SET YLFN=$PIECE(YSATZ,Y,1)               ;DATENBANKFELD
  //<< . . . . . IF +$PIECE(YSATZ,Y,60)<1 SET $PIECE(YSATZ,Y,60)=1  ;SEITE=1 WENN FALSCH ;when wrong
  //<< . . . . . SET YHIDDSE=0
  //<< . . . . . IF $EXTRACT($PIECE(YSATZ,Y,12),1,5)="_FREE" SET YHIDDSE=1       ;SONDERFELD
  //<< . . . . . IF $DATA(^WWW122D(0,YFORM,YBBN,YM,1)) DO
  //<< . . . . . . set objCompanyData = $get(^WWW122D(0,YFORM,YBBN,YM,1))
  //<< . . . . . . IF YHIDDSE=1 IF $PIECE(objCompanyData,Y,6)'="" SET YHIDDSE=0  ;SONDERFELD
  //<< . . . . . . IF $PIECE(objCompanyData,Y,1)'="" SET $PIECE(YSATZ,Y,15)=$PIECE(objCompanyData,Y,1)  ;SONDERVORGABE
  //<< . . . . . . IF HIDDEN'=1 IF $PIECE(objCompanyData,Y,13)=1  SET YHIDDSE=1  ;HIDDEN
  //<< . . . . . ;
  //<< . . . . . IF YSEITE'=+$PIECE(YSATZ,Y,60)   QUIT  ;FALSCHE SEITE = HIDDENFELD ;side
  //<< . . . . . IF '$DATA(^WWW122(0,YFORM,YBBN)) QUIT
  //<< . . . . . DO FORMVOR
  //<< 
  //<< ;------------------------------------------------------------------------
  //<< IF YDATEI'="" DO  ;RESTLICHE DATENFELDER FÜR SAVE ;to
  //<< . NEW YHIDDSE
  //<< . SET YLFN=""
  //<< . FOR  SET YLFN=$ORDER(^WWW003(0,YDATEI,YLFN)) QUIT:YLFN=""  DO
  //<< . . QUIT:$DATA(^WWW122s(0,4,YLFN,YFORM))
  //<< . . SET YSATZ=YLFN,YBBN=YLFN
  //<< . . SET YHIDDSE=1
  //<< . . DO FORMVOR
  //<< 
  //<< QUIT
  //<< */
  //<< ;^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ DISABLED BLOCK END
  //<< 
  //<< 
  //<< FORMVOR
  public void FORMVOR() {
    //<< ;-------------------------------------------------------------------------------
    //<< ; VORGABEN FÜR FORMULAR ;DEFAULTS FOR FORM
    //<< ;
    //<< ; ByRefs:
    //<< ; Based on YSATZ = $GET(^WWWSOR(YUSER_"PAGE",YHIDDEN,YSEI,YINSEITE,YZEILE,YSPL,YXBBN,YXLFN,1))
    //<< ;                         (UserPAGE,HiddenFlag,PageTab,InnerTab,Row,Column,FormField,ClassField)
    //<< ;                                            YHIDDSE                           YBBN   YLFN
    //<< ;   YDECIMALLEN     Number of Decimals
    //<< ;   YDADO           Single use check
    //<< ;   YOPTION         Validation Data
    //<< ;   YOPTION1        Validation Data
    //<< ;   YPARA1
    //<< ;   YERSTES         First field?
    //<< ;   YSPL
    //<< ;   YTABLEANZ
    //<< ;   YFOART
    //<< ;   YGJUMP          Carry over group name
    //<< ;   YDREID
    //<< ;   YFIELDSET
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 27-Jul-2007   shobby  SRBR014586: Use the NoAccess routine to do the tests on
    //<< ;                           YOPTION, YOPTION1 and YPARA1
    //<< ; 13-Mar-2007   GRF     SR12505: Duplicated closure of FIELDSET not required
    //<< ; 18-Jul-2006   JW      SR14832: Encapsulated group name translation
    //<< ;-------------------------------------------------------------------------------
    //<< $$$LogR("FORMVOR",YLFN_"<"_$get(YHIDDSE))
    $$$LogR(m$,"FORMVOR",mOp.Concat(mOp.Concat(m$.var("YLFN").get(),"<"),m$.Fnc.$get(m$.var("YHIDDSE"))));
    //<< 
    //<< ;Do not display a datafield twice on the same page
    //<< IF YLFN'="" QUIT:$DATA(YDADO(YLFN))  SET YDADO(YLFN)=""
    if (mOp.NotEqual(m$.var("YLFN").get(),"")) {
      if (mOp.Logical(m$.Fnc.$data(m$.var("YDADO").var(m$.var("YLFN").get())))) {
        return;
      }
      mVar YDADO = m$.var("YDADO");
      YDADO.var(m$.var("YLFN").get()).set("");
    }
    //<< 
    //<< ;---------------------------------------
    //<< ; YVOR      objForm
    //<< ;   D44         $$$WWW120FormFormatting()
    //<< ;                 0="Single Field Formatting"  1="Format Acc. To Longest Field"  2="Format In Pixels"
    //<< ;
    //<< ; YSATZ     objDataField
    //<< ;   D2          $$$WWW122DataInputType()                15 = Hidden
    //<< ;   D50         $$$WWW122OnlyShowIfOptionYOPTION()
    //<< ;   D51         $$$WWW122DisplayItemOnlyWhenMenuPa()
    //<< ;   D106        $$$WWW122OnlyShowIfOptionYOPTION1()
    //<< ;---------------------------------------
    //<< 
    //<< ;BR014586 (not sure what YHIDDSE is already set to at this point
    //<< if $get(YHIDDSE)'=$$$YES set YHIDDSE = $$NoAccess^WWWFORMCOMMON(YFORM,YDATEI,YBBN,"","","",$get(YOPTION),$get(YOPTION1),$get(YPARA1))
    if (mOp.NotEqual(m$.Fnc.$get(m$.var("YHIDDSE")),include.COMSYS.$$$YES(m$))) {
      mVar YHIDDSE = m$.var("YHIDDSE");
      YHIDDSE.set(m$.fnc$("WWWFORMCOMMON.NoAccess",m$.var("YFORM").get(),m$.var("YDATEI").get(),m$.var("YBBN").get(),"","","",m$.Fnc.$get(m$.var("YOPTION")),m$.Fnc.$get(m$.var("YOPTION1")),m$.Fnc.$get(m$.var("YPARA1"))));
    }
    //<< 
    //<< IF $PIECE(YVOR,Y,44)'=1 IF YFOART'=3 IF YHIDDSE=0 IF $PIECE(YSATZ,Y,2)'=15 IF YERSTES'=1 IF YSPL<2 DO
    if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),44),1)) {
      if (mOp.NotEqual(m$.var("YFOART").get(),3)) {
        if (mOp.Equal(m$.var("YHIDDSE").get(),0)) {
          if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),2),15)) {
            if (mOp.NotEqual(m$.var("YERSTES").get(),1)) {
              if (mOp.Less(m$.var("YSPL").get(),2)) {
                //<< . WRITE YCR,"</TR></TABLE>",YCR  ;ENDE DER ZEILE ;termination the
                m$.Cmd.Write(m$.var("YCR").get(),"</TR></TABLE>",m$.var("YCR").get());
                //<< . SET YTABLEANZ=$GET(YTABLEANZ)-1
                mVar YTABLEANZ = m$.var("YTABLEANZ");
                YTABLEANZ.set(mOp.Subtract(m$.Fnc.$get(m$.var("YTABLEANZ")),1));
              }
            }
          }
        }
      }
    }
    //<< 
    //<< ; NEW GROUP
    //<< ;---------------------------------------
    //<< ;   D38         $$$WWW122NewGroup()
    //<< ;       0           No Group Modification
    //<< ;       1           New Group
    //<< ;       2           Inner Group
    //<< ;       3           Close Group
    //<< ;   D39         $$$WWW122GroupName()
    //<< ;---------------------------------------
    //<< ; If not 3="Grid Form"
    //<< IF YFOART'=3 IF $PIECE(YSATZ,Y,38)>0 DO  ;NEUE GRUPPE VOR DATENFELD ;group pre-data item
    if (mOp.NotEqual(m$.var("YFOART").get(),3)) {
      if (mOp.Greater(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),38),0)) {
        do {
          //<< . IF YHIDDSE=0 DO  QUIT
          if (mOp.Equal(m$.var("YHIDDSE").get(),0)) {
            do {
              //<< . . ;
              //<< . . ;+++++++++++++++++++++++++++++++++++
              //<< . . ;
              //<< . . IF $PIECE(YVOR,Y,44)=1 DO  QUIT
              if (mOp.Equal(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),44),1)) {
                //<< . . . NEW YI
                mVar YI = m$.var("YI");
                m$.newVarBlock(3,YI);
                //<< . . . WRITE "<TR><TD>"
                m$.Cmd.Write("<TR><TD>");
                //<< . . . IF YERSTES'=1 WRITE "<HR>"
                if (mOp.NotEqual(m$.var("YERSTES").get(),1)) {
                  m$.Cmd.Write("<HR>");
                }
                //<< . . . IF YERSTES=1  WRITE "&nbsp;"
                if (mOp.Equal(m$.var("YERSTES").get(),1)) {
                  m$.Cmd.Write("&nbsp;");
                }
                //<< . . . WRITE "</TD>",YCR
                m$.Cmd.Write("</TD>",m$.var("YCR").get());
                //<< . . . ;
                //<< . . . ;--------
                //<< . . . ;
                //<< . . . write "<TD NOWRAP ALIGN=LEFT>"
                m$.Cmd.Write("<TD NOWRAP ALIGN=LEFT>");
                //<< . . . WRITE "<FONT SIZE="""_$PIECE(YVOR,Y,7)_""">"
                m$.Cmd.Write(mOp.Concat(mOp.Concat("<FONT SIZE=\"",m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),7)),"\">"));
                //<< . . . IF YERSTES'=1 IF $PIECE(YSATZ,Y,39)="" WRITE "<HR>"
                if (mOp.NotEqual(m$.var("YERSTES").get(),1)) {
                  if (mOp.Equal(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),39),"")) {
                    m$.Cmd.Write("<HR>");
                  }
                }
                //<< . . . IF YERSTES=1  IF $PIECE(YSATZ,Y,39)="" WRITE "&nbsp;"
                if (mOp.Equal(m$.var("YERSTES").get(),1)) {
                  if (mOp.Equal(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),39),"")) {
                    m$.Cmd.Write("&nbsp;");
                  }
                }
                //<< . . . IF $PIECE(YSATZ,Y,39)'="" DO
                if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),39),"")) {
                  //<< . . . . IF $GET(YGJUMP)'="" WRITE "<A NAME="""_YGJUMP_""">"
                  if (mOp.NotEqual(m$.Fnc.$get(m$.var("YGJUMP")),"")) {
                    m$.Cmd.Write(mOp.Concat(mOp.Concat("<A NAME=\"",m$.var("YGJUMP").get()),"\">"));
                  }
                  //<< . . . . SET YGJUMP=$TRANSLATE($zconvert($PIECE(YSATZ,Y,39),"U")," ")
                  mVar YGJUMP = m$.var("YGJUMP");
                  YGJUMP.set(m$.Fnc.$translate(m$.Fnc.$zconvert(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),39),"U")," "));
                  //<< . . . . WRITE "<A HREF=""#"_YGJUMP_""">"
                  m$.Cmd.Write(mOp.Concat(mOp.Concat("<A HREF=\"#",YGJUMP.get()),"\">"));
                  //<< . . . . write "<B>"_$$TranslateGroupName($PIECE(YSATZ,Y,39))_"</B>&nbsp;"
                  m$.Cmd.Write(mOp.Concat(mOp.Concat("<B>",m$.fnc$("TranslateGroupName",m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),39))),"</B>&nbsp;"));
                  //<< . . . . WRITE "</A>"
                  m$.Cmd.Write("</A>");
                }
                //<< . . . WRITE "</TD>",YCR
                m$.Cmd.Write("</TD>",m$.var("YCR").get());
                //<< . . . ;
                //<< . . . ;--------
                //<< . . . ;
                //<< . . . FOR YI=1:1:20 IF $DATA(^WWW122s(0,3,$$^WWWUMLAU(YFORM,1),YSEITE,YI,2)) DO  QUIT
                for (YI.set(1);(mOp.LessOrEqual(YI.get(),20));YI.set(mOp.Add(YI.get(),1))) {
                  if (mOp.Logical(m$.Fnc.$data(m$.var("^WWW122s",0,3,m$.fnc$("WWWUMLAU.main",m$.var("YFORM").get(),1),m$.var("YSEITE").get(),YI.get(),2)))) {
                    //<< . . . . WRITE "<TD><HR></TD><TD><HR></TD>"  ;2.TABULATOR
                    m$.Cmd.Write("<TD><HR></TD><TD><HR></TD>");
                    break;
                  }
                }
                //<< . . . ;
                //<< . . . WRITE YCR,"</TR>"
                m$.Cmd.Write(m$.var("YCR").get(),"</TR>");
                break;
              }
              m$.restoreVarBlock(3);
              //<< . . ;
              //<< . . ;+++++++++++++++++++++++++++++++++++
              //<< . . ;
              //<< . . IF $PIECE(YVOR,Y,44)=2 DO  QUIT
              if (mOp.Equal(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),44),2)) {
                do {
                  //<< . . . DO  QUIT   ;MIT RAHMEN ;by means of framework
                  do {
                    do {
                      //<< . . . . ;
                      //<< . . . . ;----- 3 : Close Group     ;AUSSCHALTEN GRUPPE
                      //<< . . . . IF $PIECE(YSATZ,Y,38)=3 WRITE YCR,"</FIELDSET>" WRITE:$GET(YFIELDSET)=2 YCR,"</FIELDSET>" SET YFIELDSET=0 QUIT
                      if (mOp.Equal(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),38),3)) {
                        m$.Cmd.Write(m$.var("YCR").get(),"</FIELDSET>");
                        if (mOp.Equal(m$.Fnc.$get(m$.var("YFIELDSET")),2)) {
                          m$.Cmd.Write(m$.var("YCR").get(),"</FIELDSET>");
                        }
                        mVar YFIELDSET = m$.var("YFIELDSET");
                        YFIELDSET.set(0);
                        break;
                      }
                      //<< . . . . ;-----
                      //<< . . . . IF $GET(YFIELDSET)>1    WRITE YCR,"</FIELDSET>",YCR SET YFIELDSET=1
                      if (mOp.Greater(m$.Fnc.$get(m$.var("YFIELDSET")),1)) {
                        m$.Cmd.Write(m$.var("YCR").get(),"</FIELDSET>",m$.var("YCR").get());
                        mVar YFIELDSET = m$.var("YFIELDSET");
                        YFIELDSET.set(1);
                      }
                      //<< . . . . ;
                      //<< . . . . ;----- 1 : New Group       ;NEUE GRUPPE
                      //<< . . . . IF $PIECE(YSATZ,Y,38)=1 DO
                      if (mOp.Equal(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),38),1)) {
                        //<< . . . . .;IF $GET(YFIELDSET)=2  WRITE YCR,"</FIELDSET>",YCR SET YFIELDSET=1      ; SR12505 already back to 1 from previous test
                        //<< . . . . . IF $GET(YFIELDSET)=1  WRITE YCR,"</FIELDSET>",YCR SET YFIELDSET=0
                        if (mOp.Equal(m$.Fnc.$get(m$.var("YFIELDSET")),1)) {
                          m$.Cmd.Write(m$.var("YCR").get(),"</FIELDSET>",m$.var("YCR").get());
                          mVar YFIELDSET = m$.var("YFIELDSET");
                          YFIELDSET.set(0);
                        }
                      }
                      //<< . . . . ;
                      //<< . . . . ;----- 2 : Inner Group     ;NEUE INNENGRUPPE
                      //<< . . . . ;IF $PIECE(YSATZ,Y,38)=2 DO                                              ; SR12505 ditto
                      //<< . . . . ;. IF $GET(YFIELDSET)=2  WRITE YCR,"</FIELDSET>",YCR SET YFIELDSET=1
                      //<< . . . . ;-----
                      //<< . . . . IF $PIECE(YVOR,Y,83)'="" WRITE YCR,"<FIELDSET>"  ;CSS-STYLESHEET
                      if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),83),"")) {
                        m$.Cmd.Write(m$.var("YCR").get(),"<FIELDSET>");
                      }
                      //<< . . . . IF $PIECE(YVOR,Y,83)="" IF $GET(YDREID)'=1 WRITE YCR,"<FIELDSET STYLE=""border-color:"_YLIGHTGREY_""">"
                      if (mOp.Equal(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),83),"")) {
                        if (mOp.NotEqual(m$.Fnc.$get(m$.var("YDREID")),1)) {
                          m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat("<FIELDSET STYLE=\"border-color:",m$.var("YLIGHTGREY").get()),"\">"));
                        }
                      }
                      //<< . . . . IF $PIECE(YVOR,Y,83)="" IF +$GET(YDREID)=1 WRITE YCR,"<FIELDSET STYLE=""border-color-dark:"_YLIGHTGREY_"; border-color-light:"_YDARKGRAY_";"">"  ;FIS;31.03.04;25445;RAHMEN 2-FARBIG
                      if (mOp.Equal(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),83),"")) {
                        if (mOp.Equal(mOp.Positive(m$.Fnc.$get(m$.var("YDREID"))),1)) {
                          m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<FIELDSET STYLE=\"border-color-dark:",m$.var("YLIGHTGREY").get()),"; border-color-light:"),m$.var("YDARKGRAY").get()),";\">"));
                        }
                      }
                      //<< . . . . ;
                      //<< . . . . IF $PIECE(YSATZ,Y,39)'="" WRITE "<LEGEND>" WRITE YCR,"<FONT SIZE="""_$PIECE(YVOR,Y,7)_""">" DO  WRITE "</FONT></LEGEND>"
                      if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),39),"")) {
                        m$.Cmd.Write("<LEGEND>");
                        m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat("<FONT SIZE=\"",m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),7)),"\">"));
                        //<< . . . . . WRITE "<B>"
                        m$.Cmd.Write("<B>");
                        //<< . . . . . write $$TranslateGroupName($PIECE(YSATZ,Y,39))
                        m$.Cmd.Write(m$.fnc$("TranslateGroupName",m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),39)));
                        //<< . . . . . WRITE "</B>"
                        m$.Cmd.Write("</B>");
                        m$.Cmd.Write("</FONT></LEGEND>");
                      }
                      //<< . . . . ;if YBED["SHOBBY" do
                      //<< . . . . ;. write "<img src='"_YGIF_"grouping.gif' top='0px' height='10px' style='position:absolute' onclick='if (this.parentNode.style.overflow=="""") {this.nextSibling.style.display=""block""; this.parentNode.style.overflow=""hidden""; this._height=this.parentNode.style.height; this.parentNode.style.height=""15px""} else {this.parentNode.style.overflow=""""; this.parentNode.style.height=this._height; this.style.position=""absolute""; this.nextSibling.style.display=""none"";};'>"
                      //<< . . . . ;. write "<div height=10 style='display:none'>&nbsp</div>"
                      //<< . . . . ;
                      //<< . . . . WRITE YCR
                      m$.Cmd.Write(m$.var("YCR").get());
                      //<< . . . . SET YFIELDSET = $GET(YFIELDSET)+1
                      mVar YFIELDSET = m$.var("YFIELDSET");
                      YFIELDSET.set(mOp.Add(m$.Fnc.$get(m$.var("YFIELDSET")),1));
                      //<< . . . . SET:YFIELDSET>2 YFIELDSET = 2
                      if (mOp.Greater(YFIELDSET.get(),2)) {
                        YFIELDSET.set(2);
                      }
                    } while (false);
                  } while(false);
                  break;
                  //<< . . . ;
                } while (false);
                break;
              }
              //<< . . . ;--------------------------------- ???
              //<< . . ;
              //<< . . ;+++++++++++++++++++++++++++++++++++
              //<< . . ;
              //<< . . IF +$PIECE(YVOR,Y,44)=0 DO  QUIT
              if (mOp.Equal(mOp.Positive(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),44)),0)) {
                //<< . . . WRITE "<TABLE WIDTH=100%>"
                m$.Cmd.Write("<TABLE WIDTH=100%>");
                //<< . . . SET YTABLEANZ=$GET(YTABLEANZ)+1
                mVar YTABLEANZ = m$.var("YTABLEANZ");
                YTABLEANZ.set(mOp.Add(m$.Fnc.$get(m$.var("YTABLEANZ")),1));
                //<< . . . WRITE YCR,"<TR><TD>"
                m$.Cmd.Write(m$.var("YCR").get(),"<TR><TD>");
                //<< . . . IF $PIECE(YSATZ,Y,39)="" WRITE "<HR>"
                if (mOp.Equal(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),39),"")) {
                  m$.Cmd.Write("<HR>");
                }
                //<< . . . IF $PIECE(YSATZ,Y,39)'="" do
                if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),39),"")) {
                  //<< . . . . write $$TranslateGroupName($piece(YSATZ,Y,39))
                  m$.Cmd.Write(m$.fnc$("TranslateGroupName",m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),39)));
                }
                //<< . . . .
                //<< . . . WRITE YCR,"</TD></TR>"
                m$.Cmd.Write(m$.var("YCR").get(),"</TD></TR>");
                //<< . . . WRITE "</TABLE>"
                m$.Cmd.Write("</TABLE>");
                //<< . . . SET YTABLEANZ = $GET(YTABLEANZ)-1
                YTABLEANZ.set(mOp.Subtract(m$.Fnc.$get(YTABLEANZ),1));
                break;
              }
            } while (false);
            break;
          }
        } while (false);
      }
    }
    //<< 
    //<< ;------------------------------------------------------------------------
    //<< SET YART="D"                  ;P=PRIMÄR,D=DATENFELD,M=MANUELLE,L=LISTGENERATOR
    mVar YART = m$.var("YART");
    YART.set("D");
    //<< IF $PIECE(YSATZ,Y,1)="" {
    if (mOp.Equal(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),1),"")) {
      //<< SET YART="M"
      YART.set("M");
      //<< set YLFN=YBBN  ;WENN MANUELL, DANN
      mVar YLFN = m$.var("YLFN");
      YLFN.set(m$.var("YBBN").get());
    }
    //<< }
    //<< SET YERSTES=YERSTES+1
    mVar YERSTES = m$.var("YERSTES");
    YERSTES.set(mOp.Add(m$.var("YERSTES").get(),1));
    //<< 
    //<< DO ^WWWFORM9  ;ANZEIGEN DATENFELD ;display data item
    m$.Cmd.Do("WWWFORM9.main");
    //<< QUIT
    return;
  }

  //<< 
  //<< 
  //<< TranslateGroupName(pstrName,pidForm)
  public Object TranslateGroupName(Object ... _p) {
    mVar pstrName = m$.newVarRef("pstrName",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pidForm = m$.newVarRef("pidForm",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Translate a group name into text
    //<< ;
    //<< ; Params:   pstrName - form def group name
    //<< ;
    //<< ; ByRefs:
    //<< ;
    //<< ; Returns:  textual description
    //<< ;
    //<< ; History:
    //<< ; 18-Jul-2006   JW      SR14832: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new strExec,strText
    mVar strExec = m$.var("strExec");
    mVar strText = m$.var("strText");
    m$.newVar(strExec,strText);
    //<< 
    //<< set pstrName = $$CalculateString(pstrName)
    pstrName.set(m$.fnc$("CalculateString",pstrName.get()));
    //<< set strText  = $$^WWWTEXT(pstrName)
    strText.set(m$.fnc$("WWWTEXT.main",pstrName.get()));
    //<< if strText'="" {
    if (mOp.NotEqual(strText.get(),"")) {
      //<< set pstrName = strText
      pstrName.set(strText.get());
    }
    //<< }
    //<< quit $$^WWWUML(pstrName)
    return m$.fnc$("WWWUML.main",pstrName.get());
  }

  //<< 
  //<< 
  //<< CalculateString(pstrText,YFORM="",YKEY="",YLFN="",YFELD="")
  public Object CalculateString(Object ... _p) {
    mVar pstrText = m$.newVarRef("pstrText",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar YFORM = m$.newVarRef("YFORM",(((_p!=null)&&(_p.length>=2))?_p[1]:null),"");
    mVar YKEY = m$.newVarRef("YKEY",(((_p!=null)&&(_p.length>=3))?_p[2]:null),"");
    mVar YLFN = m$.newVarRef("YLFN",(((_p!=null)&&(_p.length>=4))?_p[3]:null),"");
    mVar YFELD = m$.newVarRef("YFELD",(((_p!=null)&&(_p.length>=5))?_p[4]:null),"");
    //<< ;-------------------------------------------------------------------------------
    //<< ; Calculate a string from code if necessary
    //<< ;
    //<< ; NOTE: This should be called for all form def calculations! eg:
    //<< ;   - Default variable input
    //<< ;       Using YFORM,YKEY,YFLN,YFELD so they can be used in xecute
    //<< ;
    //<< ; Called By : WWWFORM, COMGridEdit31Body, COMLanguage
    //<< ;
    //<< ; Params:   pstrText - text/code to calculate
    //<< ;
    //<< ; ByRefs:
    //<< ;
    //<< ; Returns:  calculated text
    //<< ;
    //<< ; History:
    //<< ; 13-Nov-2006   JW      SR14550: Added Y params.
    //<< ; 24-Oct-2006   JW      BR014293: Should be 1st char not 2nd
    //<< ; 18-Jul-2006   JW      SR14832: Created
    //<< ;-------------------------------------------------------------------------------
    //<< if $extract(pstrText)="@" {
    if (mOp.Equal(m$.Fnc.$extract(pstrText.get()),"@")) {
      //<< set $extract(pstrText) = ""
      mVar $extract = m$.var("$extract");
      $extract.var(pstrText.get()).set("");
      //<< if ($extract(pstrText)'="$") && ($extract(pstrText)'="#") {
      if ((mOp.NotEqual(m$.Fnc.$extract(pstrText.get()),"$")) && (mOp.NotEqual(m$.Fnc.$extract(pstrText.get()),"#"))) {
        //<< set pstrText = $get(@(pstrText))
        pstrText.set(m$.Fnc.$get(m$.indirectVar((pstrText.get()))));
      }
      //<< 
      //<< } else {
      else {
        //<< xecute "set pstrText="_pstrText
        m$.Cmd.Xecute(mOp.Concat("set pstrText=",pstrText.get()));
      }
    }
    //<< }
    //<< }
    //<< quit pstrText
    return pstrText.get();
  }

  //<< 
  //<< 
  //<< Test(pstrValue="") ; Can be called from rules
  public Object Test(Object ... _p) {
    mVar pstrValue = m$.newVarRef("pstrValue",(((_p!=null)&&(_p.length>=1))?_p[0]:null),"");
    //<< quit pstrValue
    return pstrValue.get();
  }

  //<< 
  //<< 
  //<< CheckRules(pidForm,pidFormField,&pstrData,&pblnHidden,&pblnReadOnly,&pintNewFieldColor,&pblnMandatory,pblnKeepDefaults=$$$NO,&pstrNewFieldColor="",&pstrRelationClass="",&pstrRelationKeys="",&pblnUseValueOfDataField=$$$NO,&pstrRuleField="",&pstrMask,&pstrValue="",&pstrFontColor="", &pstrFilter) ;CORE-114
  public Object CheckRules(Object ... _p) {
    mVar pidForm = m$.newVarRef("pidForm",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pidFormField = m$.newVarRef("pidFormField",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pstrData = m$.newVarRef("pstrData",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    mVar pblnHidden = m$.newVarRef("pblnHidden",(((_p!=null)&&(_p.length>=4))?_p[3]:null));
    mVar pblnReadOnly = m$.newVarRef("pblnReadOnly",(((_p!=null)&&(_p.length>=5))?_p[4]:null));
    mVar pintNewFieldColor = m$.newVarRef("pintNewFieldColor",(((_p!=null)&&(_p.length>=6))?_p[5]:null));
    mVar pblnMandatory = m$.newVarRef("pblnMandatory",(((_p!=null)&&(_p.length>=7))?_p[6]:null));
    mVar pblnKeepDefaults = m$.newVarRef("pblnKeepDefaults",(((_p!=null)&&(_p.length>=8))?_p[7]:null),include.COMSYS.$$$NO(m$));
    mVar pstrNewFieldColor = m$.newVarRef("pstrNewFieldColor",(((_p!=null)&&(_p.length>=9))?_p[8]:null),"");
    mVar pstrRelationClass = m$.newVarRef("pstrRelationClass",(((_p!=null)&&(_p.length>=10))?_p[9]:null),"");
    mVar pstrRelationKeys = m$.newVarRef("pstrRelationKeys",(((_p!=null)&&(_p.length>=11))?_p[10]:null),"");
    mVar pblnUseValueOfDataField = m$.newVarRef("pblnUseValueOfDataField",(((_p!=null)&&(_p.length>=12))?_p[11]:null),include.COMSYS.$$$NO(m$));
    mVar pstrRuleField = m$.newVarRef("pstrRuleField",(((_p!=null)&&(_p.length>=13))?_p[12]:null),"");
    mVar pstrMask = m$.newVarRef("pstrMask",(((_p!=null)&&(_p.length>=14))?_p[13]:null));
    mVar pstrValue = m$.newVarRef("pstrValue",(((_p!=null)&&(_p.length>=15))?_p[14]:null),"");
    mVar pstrFontColor = m$.newVarRef("pstrFontColor",(((_p!=null)&&(_p.length>=16))?_p[15]:null),"");
    mVar pstrFilter = m$.newVarRef("pstrFilter",(((_p!=null)&&(_p.length>=17))?_p[16]:null));
    //<< ;         1         2           3           4           5               6                 7               8                         9                 10                        11                  12                          13              14          15              16
    //<< ;-------------------------------------------------------------------------------
    //<< ; Check the rules entered on WWW122D2, may replace part of WWWFORMD code
    //<< ;
    //<< ; Called By :   Enabled^COMGridEdit31G
    //<< ;               ScreenUpdateStyle^COMGridEdit31S
    //<< ;               CheckRules^WWWEVENT
    //<< ;               JSInitializingMasking^WWWFORM8
    //<< ;               Validate^WWWSAVD
    //<< ;               FieldFormat^WWWFieldValidation
    //<< ;
    //<< ; Notes:    **** Although the WWW122D2 macros are used, they apply equally to WWW122C2
    //<< ;
    //<< ; Params:
    //<< ;            1 pidForm                  - form id
    //<< ;            2 pidFormField             - data field number (WWW003)
    //<< ;            8 pblnKeepDefaults         (NO)
    //<< ;
    //<< ; ByRefs:
    //<< ;            3 pstrData                 - YFELD
    //<< ;            4 pblnHidden               - return booleans to indicate action to peform
    //<< ;            5 pblnReadOnly
    //<< ;            6 pintNewFieldColor        - background colour
    //<< ;            7 pblnMandatory
    //<< ;            9 pstrNewFieldColor        - background colour
    //<< ;           10 pstrRelationClass
    //<< ;           11 pstrRelationKeys
    //<< ;           12 pblnUseValueOfDataField  (NO)
    //<< ;           13 pstrRuleField
    //<< ;           14 pstrMask
    //<< ;           15 pstrValue
    //<< ;           16 pstrFontColor
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 29-May-2013   shobby  CORE-114: New 'Filter' field to limit results collected by 'Rules'
    //<< ; 17-May-2012   shobby  SR18013: Preserve the value of the manual field otherwise updating
    //<< ;                           formatting will blank the field.
    //<< ; 16-Aug-2011   shobby  SR17784: Multiple rules might run, if only one of them
    //<< ;                           sets hidden then hidden it is.
    //<< ; 03-Dec-2009   shobby  SR17070: Remove shortcut quit.  There is a bit of extra logic at the
    //<< ;                           end that should be included.
    //<< ; 26-Aug-2009   shobby  SR16511: If a disabled field has a color set then change
    //<< ;                           the font color.
    //<< ; 26-Aug-2009   shobby  SR16860: Get YFELDCONTAINER
    //<< ; 02-Jul-2009   shobby  SR16705: Don't update pstrValue if the rules determine
    //<< ;                           the value is empty, unless specifically set as empty.
    //<< ; 30-Jun-2009   shobby  SR16704: pstrValue to allow updating of manual fields.
    //<< ; 18-Jun-2009   GRF     SR16598: document adhoc change to set Mandatory to NO if
    //<< ;                           Read-Only is set.
    //<< ; 04-Jun-2009   shobby  SR16624: Corrected an unsaved changes issue that would
    //<< ;                           set a currency field to zero if it was empty.
    //<< ; 28-Mar-2009   shobby  SR16534: Put WWW122D2 data into an in-memory array.
    //<< ; 31-Jan-2008   shobby  SRBR014861: For currency fields remove extra precision,
    //<< ;                           otherwise we get stuck in an endless loop
    //<< ;                           ie Value is 1,0111 which is changed to 1,01 for on
    //<< ;                           screen display which triggers another change event etc.
    //<< ; 22-Jan-2008   heber   SRBR014794: FIX BYREF parameter pstrData
    //<< ; 04-Jan-2008   heber   SRBR014794: add mask to WWW122D2 - new parameter also
    //<< ; 05-Nov-2007   shobby  SRBR014759: Oops. Forgot to remove a new of YKEY
    //<< ; 30-Oct-2007   shobby  SRBR014759: Changes done under BR014557/BR014671 are
    //<< ;                           incompatible.  Now only new'ing the value of YKEY if
    //<< ;                           the current value is empty.
    //<< ; 18-Oct-2007   shobby  SRBR014557: New'd YKEY
    //<< ; 06-Sep-2007   shobby  SRBR014638: Consider more conditions that might make a
    //<< ;                           field mandatory.
    //<< ; 17-Aug-2007   shobby  SRBR014671: Make YKEY available for any code running
    //<< ;                           during  'Rules' processing.  Note that YKEY may not
    //<< ;                           physically exist on Disc at this point.
    //<< ; 30-Jul-2007   shobby  SRBR014613: Put additional check for readonly in to make
    //<< ;                           sure we are not trying to make a readonly field\
    //<< ;                           'editable' with customising rules.
    //<< ; 26-Jul-2007   GRF     SRBR014575: Add "&" to byref arguments
    //<< ; 19-Jul-2007   shobby  SRBR014617: Subroutined some functionality and included
    //<< ;                           tests on primary keys.
    //<< ; 13-Jul-2007   GRF     SRBR014605: English Property Name
    //<< ; 12-Jul-2007   shobby  SRBR014605: Use CalculateString to determine the value
    //<< ;                           of rule conditions
    //<< ; 09-Jul-2007   Frank   SRBR014575: Added 'If Empty' & 'If not Empty conditions'
    //<< ;                           and Relation fields.
    //<< ; 07-Jun-2007   shobby  SRBR014409: If customisation rules are set to make a
    //<< ;                           field hidden then ignore this.  Otherwise it won't
    //<< ;                           be able to be unhidden dynamically if it was hidden
    //<< ;                           during a load or save where it is not drawn to the
    //<< ;                           screen.
    //<< ; 05-Jun-2007   shobby  SRBR014409: Replaced ValueIs calculations with a call to
    //<< ;                           CalculateString
    //<< ; 04-Jun-2007   shobby  SRBR014500: xecute method on strValueIs was incorrectly defined.
    //<< ; 29-May-2007   shobby  SRBR014500:ValueIs can now be populated by calling a
    //<< ;                           method of the form @$$Test^SCHTest()
    //<< ; 13-Apr-2007   shobby  SRBR014343:Include additional field, pstrNewFieldColour,
    //<< ;                           to return the string description of a colour.
    //<< ;                           Change colour based on whether the field is
    //<< ;                           mandatory or read only.
    //<< ; 12-Apr-2007   shobby  SRBR014409:Only clear the value if the clear flag is set.
    //<< ; 12-Apr-2007   shobby  SRBR014409:Make the previous change conditional.
    //<< ;                           Existing usages of this function break otherwise.
    //<< ; 09-Apr-2007   shobby  SRBR014409:Only set default values for hidden, readonly,
    //<< ;                           newfieldcolour, Mandatory if not passed in
    //<< ;                       TODO:  Maybe should obtain default values from WWW122 etc.
    //<< ;                           Modify the input data with the value obtained from the rule.
    //<< ;                       TODO:  Add support for function calls that return a value.
    //<< ; 14-Mar-2007   GRF     SR12505: doco; no check required now performed in
    //<< ;                           WWWACCESS; moved cancelled code out of way.
    //<< ; 04-Oct-2006   HeberB  SRBR014265: Created based on WWWFORMD and added new rule
    //<< ;                           'If Condition On Execute'
    //<< ;-------------------------------------------------------------------------------
    //<< new arrRules,blnRule,blnTested,idRule,intClassField,objRule,objWWW122
    mVar arrRules = m$.var("arrRules");
    mVar blnRule = m$.var("blnRule");
    mVar blnTested = m$.var("blnTested");
    mVar idRule = m$.var("idRule");
    mVar intClassField = m$.var("intClassField");
    mVar objRule = m$.var("objRule");
    mVar objWWW122 = m$.var("objWWW122");
    m$.newVar(arrRules,blnRule,blnTested,idRule,intClassField,objRule,objWWW122);
    //<< new strCommand,strResult,strValue,strValueIs,YFELD,YFELDCONTAINER
    mVar strCommand = m$.var("strCommand");
    mVar strResult = m$.var("strResult");
    mVar strValue = m$.var("strValue");
    mVar strValueIs = m$.var("strValueIs");
    mVar YFELD = m$.var("YFELD");
    mVar YFELDCONTAINER = m$.var("YFELDCONTAINER");
    m$.newVar(strCommand,strResult,strValue,strValueIs,YFELD,YFELDCONTAINER);
    //<< 
    //<< $$$LogR2("CheckRules",$get(pidForm)_"<"_$get(pidFormField)_"<"_$get(pstrData)_"<")
    $$$LogR2(m$,"CheckRules",mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(m$.Fnc.$get(pidForm),"<"),m$.Fnc.$get(pidFormField)),"<"),m$.Fnc.$get(pstrData)),"<"));
    //<< 
    //<< set YFELDCONTAINER = $$$GRIDYFELDContainer
    YFELDCONTAINER.set(include.COMGridEdit31Interface.$$$GRIDYFELDContainer(m$));
    //<< 
    //<< if $get(YKEY)="" {
    if (mOp.Equal(m$.Fnc.$get(m$.var("YKEY")),"")) {
      //<< new YKEY
      mVar YKEY = m$.var("YKEY");
      m$.newVar(YKEY);
      //<< set YKEY = $$GetYKEY()
      YKEY.set(m$.fnc$("GetYKEY"));
    }
    //<< }
    //<< set objWWW122     = $$Get^WWW122(pidForm,pidFormField)
    objWWW122.set(m$.fnc$("WWW122.Get",pidForm.get(),pidFormField.get()));
    //<< set pblnMandatory = $$$WWW122MandatoryInputItem(objWWW122)
    pblnMandatory.set(include.WWWConst.$$$WWW122MandatoryInputItem(m$,objWWW122));
    //<< 
    //<< if pblnKeepDefaults {
    if (mOp.Logical(pblnKeepDefaults.get())) {
      //<< if $get(pblnHidden)=""     set pblnHidden   = $$$NO
      if (mOp.Equal(m$.Fnc.$get(pblnHidden),"")) {
        pblnHidden.set(include.COMSYS.$$$NO(m$));
      }
      //<< if $get(pblnReadOnly)=""   set pblnReadOnly = $$$NO
      if (mOp.Equal(m$.Fnc.$get(pblnReadOnly),"")) {
        pblnReadOnly.set(include.COMSYS.$$$NO(m$));
      }
      //<< if $get(pintNewFieldColor)="" {
      if (mOp.Equal(m$.Fnc.$get(pintNewFieldColor),"")) {
        //<< if pstrNewFieldColor'="" {
        if (mOp.NotEqual(pstrNewFieldColor.get(),"")) {
          //<< set pintNewFieldColor = $order(^WWW100s(0,1,$$$Index(pstrNewFieldColor),"FARBE",SPRACHE,""))
          pintNewFieldColor.set(m$.Fnc.$order(m$.var("^WWW100s",0,1,include.MEDConst.$$$Index(m$,pstrNewFieldColor),"FARBE",m$.var("SPRACHE").get(),"")));
        }
      }
      //<< }
      //<< } else {
      else {
        //<< ;       FIXME : <GRF> is it valid to say we want to keep the default and then blow it away?
        //<< set pintNewFieldColor = ""
        pintNewFieldColor.set("");
      }
    }
    //<< }
    //<< 
    //<< } else {
    else {
      //<< set pblnHidden        = $$$NO
      pblnHidden.set(include.COMSYS.$$$NO(m$));
      //<< set pblnReadOnly      = $$$NO
      pblnReadOnly.set(include.COMSYS.$$$NO(m$));
      //<< set pintNewFieldColor = ""
      pintNewFieldColor.set("");
    }
    //<< }
    //<< 
    //<< do GetRules(.arrRules,pidForm,pidFormField,YM)
    m$.Cmd.Do("GetRules",arrRules,pidForm.get(),pidFormField.get(),m$.var("YM").get());
    //<< 
    //<< if $data(arrRules) {
    if (mOp.Logical(m$.Fnc.$data(arrRules))) {
      //<< set YFELD = pstrData
      YFELD.set(pstrData.get());
      //<< set intClassField = $$$GetClassField(pidForm,pidFormField)
      intClassField.set(include.COMSYSWWW.$$$GetClassField(m$,pidForm,pidFormField));
      //<< if intClassField="" if $data(YMFELD) set pstrValue=$piece(YMFELD,Y,pidFormField) ;SR18013
      if (mOp.Equal(intClassField.get(),"")) {
        if (mOp.Logical(m$.Fnc.$data(m$.var("YMFELD")))) {
          pstrValue.set(m$.Fnc.$piece(m$.var("YMFELD").get(),m$.var("Y").get(),pidFormField.get()));
        }
      }
      //<< set idRule = ""
      idRule.set("");
      //<< for {
      for (;true;) {
        //<< set idRule = $order(arrRules(idRule))
        idRule.set(m$.Fnc.$order(arrRules.var(idRule.get())));
        //<< quit:idRule=""
        if (mOp.Equal(idRule.get(),"")) {
          break;
        }
        //<< 
        //<< set blnTested = $$$NO
        blnTested.set(include.COMSYS.$$$NO(m$));
        //<< set blnRule   = $$$NO
        blnRule.set(include.COMSYS.$$$NO(m$));
        //<< set objRule   = $get(arrRules(idRule,1))
        objRule.set(m$.Fnc.$get(arrRules.var(idRule.get(),1)));
        //<< 
        //<< ; data field
        //<< if $$$WWW122D2IfPrimaryKey(objRule)'="" {   ;Primary key takes precedence (new tests stop both)
        if (mOp.NotEqual(include.WWWConst.$$$WWW122D2IfPrimaryKey(m$,objRule),"")) {
          //<< set blnRule = $$TestRule(objRule,YKEY,$$$WWW122D2IfPrimaryKey(objRule),.blnTested,$$$COMMA)
          blnRule.set(m$.fnc$("TestRule",objRule.get(),m$.var("YKEY").get(),include.WWWConst.$$$WWW122D2IfPrimaryKey(m$,objRule),blnTested,include.COMSYSString.$$$COMMA(m$)));
        }
        //<< 
        //<< } elseif $$$WWW122D2IfDataField(objRule) '= "" {
        else if (mOp.NotEqual(include.WWWConst.$$$WWW122D2IfDataField(m$,objRule),"")) {
          //<< set blnRule = $$TestRule(objRule,pstrData,$$$WWW122D2IfDataField(objRule),.blnTested,Y)
          blnRule.set(m$.fnc$("TestRule",objRule.get(),pstrData.get(),include.WWWConst.$$$WWW122D2IfDataField(m$,objRule),blnTested,m$.var("Y").get()));
        }
        //<< }
        //<< 
        //<< continue:(blnTested && 'blnRule)    ; next rule if tested and negative
        if ((mOp.Logical(blnTested.get()) && mOp.Not(blnRule.get()))) {
          continue;
        }
        //<< 
        //<< ; If condition on execute                                         ; *** EXECUTE ***
        //<< if ($$$WWW122D2IfConditionOnExecute(objRule)'="") {
        if ((mOp.NotEqual(include.WWWConst.$$$WWW122D2IfConditionOnExecute(m$,objRule),""))) {
          //<< set blnTested  = $$$YES
          blnTested.set(include.COMSYS.$$$YES(m$));
          //<< set strResult  = ""
          strResult.set("");
          //<< set strCommand = "set strResult="_$$$WWW122D2IfConditionOnExecute(objRule)
          strCommand.set(mOp.Concat("set strResult=",include.WWWConst.$$$WWW122D2IfConditionOnExecute(m$,objRule)));
          //<< xecute strCommand
          m$.Cmd.Xecute(strCommand.get());
          //<< if strResult {
          if (mOp.Logical(strResult.get())) {
            //<< set blnRule = $$$YES
            blnRule.set(include.COMSYS.$$$YES(m$));
          }
          //<< } else {
          else {
            //<< set blnRule = $$$NO
            blnRule.set(include.COMSYS.$$$NO(m$));
          }
        }
        //<< }
        //<< }
        //<< continue:(blnTested && 'blnRule)
        if ((mOp.Logical(blnTested.get()) && mOp.Not(blnRule.get()))) {
          continue;
        }
        //<< 
        //<< if $$^WWWACCESS($$$WWW122D2ThisUserEntitlement(objRule),$$$WWW122D2ThisModuleEntitlement(objRule),YBED) = 1 set blnRule = $$$YES
        if (mOp.Equal(m$.fnc$("WWWACCESS.main",include.WWWConst.$$$WWW122D2ThisUserEntitlement(m$,objRule),include.WWWConst.$$$WWW122D2ThisModuleEntitlement(m$,objRule),m$.var("YBED").get()),1)) {
          blnRule.set(include.COMSYS.$$$YES(m$));
        }
        //<< continue:('blnRule)
        if ((mOp.Not(blnRule.get()))) {
          continue;
        }
        //<< 
        //<< ;SR17784 set pblnHidden = $$$NO
        //<< if $$$WWW122D2FieldNotDisplayed(objRule) set pblnReadOnly  = $$$YES  ; Could be from WWW122D2 or WWW122C2
        if (mOp.Logical(include.WWWConst.$$$WWW122D2FieldNotDisplayed(m$,objRule))) {
          pblnReadOnly.set(include.COMSYS.$$$YES(m$));
        }
        //<< if $$$WWW122D2ReadOnlyField(objRule)     set pblnReadOnly  = $$$YES
        if (mOp.Logical(include.WWWConst.$$$WWW122D2ReadOnlyField(m$,objRule))) {
          pblnReadOnly.set(include.COMSYS.$$$YES(m$));
        }
        //<< if $$$WWW122D2MandatoryField(objRule)    set pblnMandatory = $$$YES
        if (mOp.Logical(include.WWWConst.$$$WWW122D2MandatoryField(m$,objRule))) {
          pblnMandatory.set(include.COMSYS.$$$YES(m$));
        }
        //<< if $$$WWW122D2NewFieldColor(objRule) '= "" {
        if (mOp.NotEqual(include.WWWConst.$$$WWW122D2NewFieldColor(m$,objRule),"")) {
          //<< set pintNewFieldColor = $$$WWW122D2NewFieldColor(objRule)
          pintNewFieldColor.set(include.WWWConst.$$$WWW122D2NewFieldColor(m$,objRule));
          //<< set pstrFontColor     = $$$SysEnum("FARBE",pintNewFieldColor) ; Used if the field is disabled.
          pstrFontColor.set(include.COMSYSWWW.$$$SysEnum(m$,"FARBE",pintNewFieldColor));
        }
        //<< }
        //<< 
        //<< set strValue=""
        strValue.set("");
        //<< if +$$$WWW122D2Clear(objRule) {
        if (mOp.Logical(mOp.Positive(include.WWWConst.$$$WWW122D2Clear(m$,objRule)))) {
          //<< set pstrValue =  ""
          pstrValue.set("");
          //<< if intClassField'="" set $piece(pstrData,Y,intClassField) = $get(pstrValue)
          if (mOp.NotEqual(intClassField.get(),"")) {
            m$.pieceVar(pstrData,m$.var("Y").get(),intClassField.get()).set(m$.Fnc.$get(pstrValue));
          }
        }
        //<< 
        //<< } else {
        else {
          //<< set strValueIs = $$$WWW122D2ValueIs(objRule)
          strValueIs.set(include.WWWConst.$$$WWW122D2ValueIs(m$,objRule));
          //<< if strValueIs'="" {
          if (mOp.NotEqual(strValueIs.get(),"")) {
            //<< set strValue = $$CalculateString(strValueIs,pidForm,YKEY,pidFormField,pstrData)
            strValue.set(m$.fnc$("CalculateString",strValueIs.get(),pidForm.get(),m$.var("YKEY").get(),pidFormField.get(),pstrData.get()));
          }
          //<< }
          //<< if ($$$WWW122InputType(objWWW122)=8) && ($piece(pstrData,Y,intClassField)'="") {  ; Currency
          if ((mOp.Equal(include.WWWConst.$$$WWW122InputType(m$,objWWW122),8)) && (mOp.NotEqual(m$.Fnc.$piece(pstrData.get(),m$.var("Y").get(),intClassField.get()),""))) {
            //<< set strValue = +$justify($piece(pstrData,Y,intClassField),0,YDECIMALLEN)
            strValue.set(mOp.Positive(m$.Fnc.$justify(m$.Fnc.$piece(pstrData.get(),m$.var("Y").get(),intClassField.get()),0,m$.var("YDECIMALLEN").get())));
          }
          //<< }
          //<< if strValue'="" {
          if (mOp.NotEqual(strValue.get(),"")) {
            //<< set pstrValue = strValue
            pstrValue.set(strValue.get());
            //<< if intClassField'="" set $piece(pstrData,Y,intClassField) = $get(pstrValue)
            if (mOp.NotEqual(intClassField.get(),"")) {
              m$.pieceVar(pstrData,m$.var("Y").get(),intClassField.get()).set(m$.Fnc.$get(pstrValue));
            }
          }
        }
        //<< }
        //<< }
        //<< 
        //<< if $$$WWW122D2ApplyMask(objRule) '= "" set pstrMask = $$$WWW122D2ApplyMask(objRule)
        if (mOp.NotEqual(include.WWWConst.$$$WWW122D2ApplyMask(m$,objRule),"")) {
          pstrMask.set(include.WWWConst.$$$WWW122D2ApplyMask(m$,objRule));
        }
        //<< 
        //<< if $$$WWW122D2RelationClass(objRule) '= "" {
        if (mOp.NotEqual(include.WWWConst.$$$WWW122D2RelationClass(m$,objRule),"")) {
          //<< set pstrRelationClass       = $$$WWW122D2RelationClass(objRule)
          pstrRelationClass.set(include.WWWConst.$$$WWW122D2RelationClass(m$,objRule));
          //<< set pstrRelationKeys        = $$$WWW122D2RelationalPrimaryKeys(objRule)
          pstrRelationKeys.set(include.WWWConst.$$$WWW122D2RelationalPrimaryKeys(m$,objRule));
          //<< set pblnUseValueOfDataField = $$$WWW122D2AddDataFieldToRelationKey(objRule)
          pblnUseValueOfDataField.set(include.WWWConst.$$$WWW122D2AddDataFieldToRelationKey(m$,objRule));
          //<< set pstrRuleField           = $$$WWW122D2IfDataField(objRule)
          pstrRuleField.set(include.WWWConst.$$$WWW122D2IfDataField(m$,objRule));
        }
        //<< }
        //<< 
        //<< if $$$WWW122D2FieldNotDisplayed(objRule) {  ;SR17784
        if (mOp.Logical(include.WWWConst.$$$WWW122D2FieldNotDisplayed(m$,objRule))) {
          //<< set pblnHidden=$$$YES                   ;SR17784
          pblnHidden.set(include.COMSYS.$$$YES(m$));
        }
        //<< }                                           ;SR17784
        //<< set pstrFilter=$$$WWW122C2Filter1(objRule) ;CORE-114
        pstrFilter.set(include.WWWConst.$$$WWW122C2Filter1(m$,objRule));
      }
    }
    //<< }
    //<< }
    //<< set pblnReadOnly = $$ReadOnly(pidForm,pidFormField,pstrData,pblnReadOnly)
    pblnReadOnly.set(m$.fnc$("ReadOnly",pidForm.get(),pidFormField.get(),pstrData.get(),pblnReadOnly.get()));
    //<< 
    //<< ; FIXME : Transaction edit grids should be able to colour fields as mandatory but only validate when Posting.
    //<< ;         It should be possible to save the currently available details and finish providing the rest later. <GRF>
    //<< ;CORE-72 if pblnReadOnly set pblnMandatory=$$$NO
    //<< ;CORE-72 set pstrNewFieldColor=$$BACKGROUNDCOLOR^WWWFORM7(pblnMandatory,pblnReadOnly) ;SESPE-467
    //<< ;set ^zzSCH($i(^zzSCH))="readonly="_pblnReadOnly
    //<< if pblnReadOnly {
    if (mOp.Logical(pblnReadOnly.get())) {
      //<< set pintNewFieldColor = $$$WWW012FrameBodyColor($get(^WWW012(0,0,1)))
      pintNewFieldColor.set(include.WWWConst.$$$WWW012FrameBodyColor(m$,m$.Fnc.$get(m$.var("^WWW012",0,0,1))));
      //<< set pblnMandatory     = $$$NO ;shobby ADHOC can't be mandatory if it is readonly
      pblnMandatory.set(include.COMSYS.$$$NO(m$));
    }
    //<< 
    //<< } elseif pblnMandatory {
    else if (mOp.Logical(pblnMandatory.get())) {
      //<< if pintNewFieldColor="" set pintNewFieldColor = $$$WWW012FontColorMandatoryInput($get(^WWW012(0,0,1)))
      if (mOp.Equal(pintNewFieldColor.get(),"")) {
        pintNewFieldColor.set(include.WWWConst.$$$WWW012FontColorMandatoryInput(m$,m$.Fnc.$get(m$.var("^WWW012",0,0,1))));
      }
    }
    //<< }
    //<< 
    //<< set pstrNewFieldColor = $$$SysEnum("FARBE",pintNewFieldColor)
    pstrNewFieldColor.set(include.COMSYSWWW.$$$SysEnum(m$,"FARBE",pintNewFieldColor));
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< HasRules(pidForm,pidFormField)
  public Object HasRules(Object ... _p) {
    mVar pidForm = m$.newVarRef("pidForm",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pidFormField = m$.newVarRef("pidFormField",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Determines if this field has rules
    //<< ;
    //<< ; Called By : OnSortGrid^COMGridEdit31Events
    //<< ;
    //<< ; Params: Form Name and Record Key
    //<< ;
    //<< ; Returns: Boolean : Whether rules exist
    //<< ;
    //<< ; History:
    //<< ; 03-Mar-2011   shobby  SR17676: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new arrRules
    mVar arrRules = m$.var("arrRules");
    m$.newVar(arrRules);
    //<< 
    //<< do GetRules(.arrRules,pidForm,pidFormField,YM)
    m$.Cmd.Do("GetRules",arrRules,pidForm.get(),pidFormField.get(),m$.var("YM").get());
    //<< quit ''$data(arrRules)
    return mOp.Not(mOp.Not(m$.Fnc.$data(arrRules)));
  }

  //<< 
  //<< 
  //<< GetRules(&parrRules,pidForm,pidFormField="",pYM="")
  public Object GetRules(Object ... _p) {
    mVar parrRules = m$.newVarRef("parrRules",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pidForm = m$.newVarRef("pidForm",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pidFormField = m$.newVarRef("pidFormField",(((_p!=null)&&(_p.length>=3))?_p[2]:null),"");
    mVar pYM = m$.newVarRef("pYM",(((_p!=null)&&(_p.length>=4))?_p[3]:null),"");
    //<< ;-------------------------------------------------------------------------------
    //<< ; Puts the rules in to an in-memory array.
    //<< ;
    //<< ; Called By: CheckRules^WWWFORMD, CheckRules^WWWEVENT
    //<< ;
    //<< ; Params:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 28-May-2009   shobby      SR16534: Created
    //<< ;-------------------------------------------------------------------------------
    //<< ; TODO include new 'core' rules when available.
    //<< new idRule
    mVar idRule = m$.var("idRule");
    m$.newVar(idRule);
    //<< 
    //<< if pYM="" set pYM=YM
    if (mOp.Equal(pYM.get(),"")) {
      pYM.set(m$.var("YM").get());
    }
    //<< if pidFormField="" {
    if (mOp.Equal(pidFormField.get(),"")) {
      //<< set pidFormField = ""
      pidFormField.set("");
      //<< for {
      for (;true;) {
        //<< set pidFormField = $order(^WWW122C2(0,pidForm,pidFormField))
        pidFormField.set(m$.Fnc.$order(m$.var("^WWW122C2",0,pidForm.get(),pidFormField.get())));
        //<< quit:pidFormField=""
        if (mOp.Equal(pidFormField.get(),"")) {
          break;
        }
        //<< 
        //<< set idRule = ""
        idRule.set("");
        //<< for {
        for (;true;) {
          //<< set idRule = $order(^WWW122C2(0,pidForm,pidFormField,idRule))
          idRule.set(m$.Fnc.$order(m$.var("^WWW122C2",0,pidForm.get(),pidFormField.get(),idRule.get())));
          //<< quit:idRule=""
          if (mOp.Equal(idRule.get(),"")) {
            break;
          }
          //<< 
          //<< set parrRules(pidFormField,0,-10000+idRule,1) = $get(^WWW122C2(0,pidForm,pidFormField,idRule,1))
          parrRules.var(pidFormField.get(),0,mOp.Add(mOp.Negative(10000),idRule.get()),1).set(m$.Fnc.$get(m$.var("^WWW122C2",0,pidForm.get(),pidFormField.get(),idRule.get(),1)));
        }
      }
      //<< }
      //<< }
      //<< merge parrRules = ^WWW122D2(0,pidForm)
      m$.Cmd.Merge(parrRules,m$.var("^WWW122D2",0,pidForm.get()));
    }
    //<< 
    //<< } else {
    else {
      //<< set idRule=""
      idRule.set("");
      //<< for {
      for (;true;) {
        //<< set idRule=$order(^WWW122C2(0,pidForm,pidFormField,idRule))
        idRule.set(m$.Fnc.$order(m$.var("^WWW122C2",0,pidForm.get(),pidFormField.get(),idRule.get())));
        //<< quit:idRule=""
        if (mOp.Equal(idRule.get(),"")) {
          break;
        }
        //<< 
        //<< set parrRules(-10000+idRule,1) = $get(^WWW122C2(0,pidForm,pidFormField,idRule,1))
        parrRules.var(mOp.Add(mOp.Negative(10000),idRule.get()),1).set(m$.Fnc.$get(m$.var("^WWW122C2",0,pidForm.get(),pidFormField.get(),idRule.get(),1)));
      }
      //<< }
      //<< merge parrRules = ^WWW122D2(0,pidForm,pidFormField,pYM)
      m$.Cmd.Merge(parrRules,m$.var("^WWW122D2",0,pidForm.get(),pidFormField.get(),pYM.get()));
    }
    //<< }
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< TestRule(pobjRule,pstrData,pintPiece,&pblnTested,pintSeparator="~")
  public Object TestRule(Object ... _p) {
    mVar pobjRule = m$.newVarRef("pobjRule",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pstrData = m$.newVarRef("pstrData",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pintPiece = m$.newVarRef("pintPiece",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    mVar pblnTested = m$.newVarRef("pblnTested",(((_p!=null)&&(_p.length>=4))?_p[3]:null));
    mVar pintSeparator = m$.newVarRef("pintSeparator",(((_p!=null)&&(_p.length>=5))?_p[4]:null),"~");
    //<< ;-------------------------------------------------------------------------------
    //<< ; Tests whether a customising rule should be applied, for either a data field or
    //<< ; a primary key.
    //<< ;
    //<< ; Params:
    //<< ;   pobjRule:       The rule to be tested.
    //<< ;   pstrData:       The data record when testing a data field, or the primary key when
    //<< ;                   testing a primary key.
    //<< ;   pintPiece:      The piece within the pstrData being tested
    //<< ;   pblnTested:     Whether a test has been applied
    //<< ;   pintSeparator:  , or ~ based on primary key or data
    //<< ;
    //<< ; Returns:
    //<< ;   blnRule:        Whether or not a rule has been found to apply in this case.
    //<< ;
    //<< ; History:
    //<< ; 30-Oct-2007 shobby/GM SRBR014636: Class recompiled changing which changes the
    //<< ;                           'Property Name' of 'Is' to 'Is1'
    //<< ; 02-Aug-2007   GM      SRBR014636: Change WWW122D2Contains to WWW122D2Is and
    //<< ;                       WWW122D2DoesNotContain to WWW122D2IsNot
    //<< ; 20-Jul-2007   GRF     SRBR014617: Peer Review correction
    //<< ; 19-Jul-2007   shobby  SRBR014617: Created.  Taken out of CheckRules and adapted
    //<< ;                           to also work with Primary Keys
    //<< ;-------------------------------------------------------------------------------
    //<< new blnRule,strResult,strCommand,strIf
    mVar blnRule = m$.var("blnRule");
    mVar strResult = m$.var("strResult");
    mVar strCommand = m$.var("strCommand");
    mVar strIf = m$.var("strIf");
    m$.newVar(blnRule,strResult,strCommand,strIf);
    //<< 
    //<< set blnRule = $$$NO
    blnRule.set(include.COMSYS.$$$NO(m$));
    //<< set strIf   = $piece(pobjRule,Y,pintPiece)
    strIf.set(m$.Fnc.$piece(pobjRule.get(),m$.var("Y").get(),pintPiece.get()));
    //<< 
    //<< if (pintPiece '= "") {
    if ((mOp.NotEqual(pintPiece.get(),""))) {
      //<< ; if Contains
      //<< ;if $$$WWW122D2Contains(pobjRule) '= "" {
      //<< 
      //<< 
      //<< ; if Is
      //<< if $$$WWW122D2Is1(pobjRule) '= "" {
      if (mOp.NotEqual(include.WWWConst.$$$WWW122D2Is1(m$,pobjRule),"")) {
        //<< set pblnTested = $$$YES
        pblnTested.set(include.COMSYS.$$$YES(m$));
        //<< if $piece(pstrData,pintSeparator,pintPiece) = $$$WWW122D2Is1(pobjRule) set blnRule = $$$YES
        if (mOp.Equal(m$.Fnc.$piece(pstrData.get(),pintSeparator.get(),pintPiece.get()),include.WWWConst.$$$WWW122D2Is1(m$,pobjRule))) {
          blnRule.set(include.COMSYS.$$$YES(m$));
        }
      }
      //<< 
      //<< 
      //<< ; if Does not Contain
      //<< ;} elseif $$$WWW122D2DoesNotcontain(pobjRule) '= "" {
      //<< 
      //<< 
      //<< ; if Is Not
      //<< } elseif $$$WWW122D2IsNot(pobjRule) '= "" {
      else if (mOp.NotEqual(include.WWWConst.$$$WWW122D2IsNot(m$,pobjRule),"")) {
        //<< set pblnTested = $$$YES
        pblnTested.set(include.COMSYS.$$$YES(m$));
        //<< if $piece(pstrData,pintSeparator,pintPiece) '= $$$WWW122D2IsNot(pobjRule) set blnRule = $$$YES
        if (mOp.NotEqual(m$.Fnc.$piece(pstrData.get(),pintSeparator.get(),pintPiece.get()),include.WWWConst.$$$WWW122D2IsNot(m$,pobjRule))) {
          blnRule.set(include.COMSYS.$$$YES(m$));
        }
      }
      //<< 
      //<< 
      //<< ; Execute For Check                                               ; *** EXECUTE ***
      //<< } elseif $$$WWW122D2ExecuteForCheck(pobjRule) '= "" {
      else if (mOp.NotEqual(include.WWWConst.$$$WWW122D2ExecuteForCheck(m$,pobjRule),"")) {
        //<< set pblnTested = $$$YES
        pblnTested.set(include.COMSYS.$$$YES(m$));
        //<< set strResult = ""
        strResult.set("");
        //<< set strCommand = "set strResult="_$$$WWW122D2ExecuteForCheck(pobjRule)
        strCommand.set(mOp.Concat("set strResult=",include.WWWConst.$$$WWW122D2ExecuteForCheck(m$,pobjRule)));
        //<< xecute strCommand
        m$.Cmd.Xecute(strCommand.get());
        //<< if $piece(pstrData,pintSeparator,pintPiece) = strResult set blnRule = $$$YES
        if (mOp.Equal(m$.Fnc.$piece(pstrData.get(),pintSeparator.get(),pintPiece.get()),strResult.get())) {
          blnRule.set(include.COMSYS.$$$YES(m$));
        }
      }
      //<< 
      //<< 
      //<< ; Is Empty
      //<< } elseif $$$WWW122D2IsEmpty(pobjRule) {
      else if (mOp.Logical(include.WWWConst.$$$WWW122D2IsEmpty(m$,pobjRule))) {
        //<< set pblnTested = $$$YES
        pblnTested.set(include.COMSYS.$$$YES(m$));
        //<< set blnRule = ($piece(pstrData,pintSeparator,pintPiece) = "")
        blnRule.set((mOp.Equal(m$.Fnc.$piece(pstrData.get(),pintSeparator.get(),pintPiece.get()),"")));
      }
      //<< 
      //<< 
      //<< ; Is not Empty
      //<< } elseif $$$WWW122D2IsNotEmpty(pobjRule) {
      else if (mOp.Logical(include.WWWConst.$$$WWW122D2IsNotEmpty(m$,pobjRule))) {
        //<< set pblnTested = $$$YES
        pblnTested.set(include.COMSYS.$$$YES(m$));
        //<< set blnRule = ($piece(pstrData,pintSeparator,pintPiece) '= "")
        blnRule.set((mOp.NotEqual(m$.Fnc.$piece(pstrData.get(),pintSeparator.get(),pintPiece.get()),"")));
      }
    }
    //<< }
    //<< }
    //<< quit blnRule
    return blnRule.get();
  }

  //<< 
  //<< 
  //<< GetYKEY()
  public Object GetYKEY(Object ... _p) {
    //<< ;-------------------------------------------------------------------------------
    //<< ; Finds out what YKEY would be if it was available here.  Consider that a record
    //<< ; may not be saved at this point
    //<< ;
    //<< ; Params:
    //<< ;
    //<< ; Returns: YKEY derived from WWWDATEN keys
    //<< ;
    //<< ; History:
    //<< ; 19-Jul-2007   shobby  SRBR014617: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new strYKEY
    mVar strYKEY = m$.var("strYKEY");
    m$.newVar(strYKEY);
    //<< 
    //<< set strYKEY=""
    strYKEY.set("");
    //<< if ($get(YUSER)'="") && ($get(YFORM)'="") {
    if ((mOp.NotEqual(m$.Fnc.$get(m$.var("YUSER")),"")) && (mOp.NotEqual(m$.Fnc.$get(m$.var("YFORM")),""))) {
      //<< set strYKEY = $get(^WWWDATEN(YM,+$horolog,YUSER,YFORM,"P",1))
      strYKEY.set(m$.Fnc.$get(m$.var("^WWWDATEN",m$.var("YM").get(),mOp.Positive(m$.Fnc.$horolog()),m$.var("YUSER").get(),m$.var("YFORM").get(),"P",1)));
    }
    //<< }
    //<< quit strYKEY
    return strYKEY.get();
  }

  //<< 
  //<< 
  //<< ReadOnly(pidForm,pidFormField,pstrData,pblnReadOnly)
  public Object ReadOnly(Object ... _p) {
    mVar pidForm = m$.newVarRef("pidForm",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pidFormField = m$.newVarRef("pidFormField",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pstrData = m$.newVarRef("pstrData",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    mVar pblnReadOnly = m$.newVarRef("pblnReadOnly",(((_p!=null)&&(_p.length>=4))?_p[3]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Determines whether there are any reasons why this field should be read only.
    //<< ; For example if the record is locked by another user.  In any case a field that is
    //<< ; readonly can not be made editable by customisation rules.
    //<< ;
    //<< ; Called By: CheckRules^WWWFORMD
    //<< ;
    //<< ; Params:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 06-Jun-2012   shobby  SR18028: If form is readonly then control must be readonly.
    //<< ; 11-Sep-2007   shobby  SRBR014674: Because the screen is now more dynamic there
    //<< ;                           is a problem with with Status=2 (Edited) because it
    //<< ;                           will apply for both saved and unsaved records.
    //<< ;                           Additional test is included to force the Status=1
    //<< ;                           (New) for the purpose of dynamic rules if there is
    //<< ;                           no YKEY defined yet.
    //<< ; 16-Aug-2007   shobby  SRBR014674: YBEARB may not be defined.
    //<< ; 30-Jul-2007   shobby  SRBR014613: Taken from FIELDS^WWWFORMD
    //<< ;-------------------------------------------------------------------------------
    //<< new intHidden,objWWW122,YBEARB
    mVar intHidden = m$.var("intHidden");
    mVar objWWW122 = m$.var("objWWW122");
    mVar YBEARB = m$.var("YBEARB");
    m$.newVar(intHidden,objWWW122,YBEARB);
    //<< 
    //<< if pblnReadOnly=$$$NO {
    if (mOp.Equal(pblnReadOnly.get(),include.COMSYS.$$$NO(m$))) {
      //<< set objWWW122 = $$Get^WWW122(pidForm,pidFormField)
      objWWW122.set(m$.fnc$("WWW122.Get",pidForm.get(),pidFormField.get()));
      //<< if $$$NoKey(YKEY) {
      if (mOp.Logical(include.COMSYS.$$$NoKey(m$,m$.var("YKEY")))) {
        //<< set YBEARB = 1
        YBEARB.set(1);
      }
      //<< } else {
      else {
        //<< set YBEARB = $get(^WWWDATEN(YM,+$horolog,YUSER,YFORM,"STATUS",1))
        YBEARB.set(m$.Fnc.$get(m$.var("^WWWDATEN",m$.var("YM").get(),mOp.Positive(m$.Fnc.$horolog()),m$.var("YUSER").get(),m$.var("YFORM").get(),"STATUS",1)));
      }
      //<< }
      //<< if YBEARB=8 {           ;SR18028
      if (mOp.Equal(YBEARB.get(),8)) {
        //<< set intHidden=2     ;SR18028
        intHidden.set(2);
      }
      //<< } else {
      else {
        //<< ; FIXME : use elseif to reduce checking
        //<< if $$$WWW122UserAccessForChange(objWWW122)=$$$EnumReadOnly                                   set intHidden = 2    ; 5
        if (mOp.Equal(include.WWWConst.$$$WWW122UserAccessForChange(m$,objWWW122),include.COMSYSEnum.$$$EnumReadOnly(m$))) {
          intHidden.set(2);
        }
        //<< if (YBEARB'=1) && (YBEARB'=6) && ($$$WWW122UserAccessForChange(objWWW122)=$$$EnumCreateOnly) set intHidden = 2    ; 3
        if ((mOp.NotEqual(YBEARB.get(),1)) && (mOp.NotEqual(YBEARB.get(),6)) && (mOp.Equal(include.WWWConst.$$$WWW122UserAccessForChange(m$,objWWW122),include.COMSYSEnum.$$$EnumCreateOnly(m$)))) {
          intHidden.set(2);
        }
        //<< if ((YBEARB=1) || (YBEARB=6)) && ($$$WWW122UserAccessForChange(objWWW122)=$$$EnumModifyOnly) set intHidden = 2    ; 4
        if (mOp.Logical(((mOp.Equal(YBEARB.get(),1)) || (mOp.Equal(YBEARB.get(),6)))) && (mOp.Equal(include.WWWConst.$$$WWW122UserAccessForChange(m$,objWWW122),include.COMSYSEnum.$$$EnumModifyOnly(m$)))) {
          intHidden.set(2);
        }
        //<< if $$$WWW120AuthorizationToModifyData($get(YVOR))=$$$EnumReadOnly                            set intHidden = 2    ; 5
        if (mOp.Equal(include.WWWConst.$$$WWW120AuthorizationToModifyData(m$,m$.Fnc.$get(m$.var("YVOR"))),include.COMSYSEnum.$$$EnumReadOnly(m$))) {
          intHidden.set(2);
        }
        //<< 
        //<< if (($$$WWW122ManualCaptionAfterDataFie(objWWW122)'="") || ($$$WWW122Module2(objWWW122)'=""))      &&
        //<< ($$^WWWACCESS($$$WWW122ManualCaptionAfterDataFie(objWWW122),$$$WWW122Module2(objWWW122))=$$$YES)   {
        if (mOp.Logical(((mOp.NotEqual(include.WWWConst.$$$WWW122ManualCaptionAfterDataFie(m$,objWWW122),"")) || (mOp.NotEqual(include.WWWConst.$$$WWW122Module2(m$,objWWW122),"")))) && (mOp.Equal(m$.fnc$("WWWACCESS.main",include.WWWConst.$$$WWW122ManualCaptionAfterDataFie(m$,objWWW122),include.WWWConst.$$$WWW122Module2(m$,objWWW122)),include.COMSYS.$$$YES(m$)))) {
          //<< 
          //<< if $$$WWW122UserRightForChange(objWWW122)=$$$EnumReadOnly {          ; 5
          if (mOp.Equal(include.WWWConst.$$$WWW122UserRightForChange(m$,objWWW122),include.COMSYSEnum.$$$EnumReadOnly(m$))) {
            //<< set intHidden = 2
            intHidden.set(2);
          }
          //<< 
          //<< } elseif $$$WWW122UserRightForChange(objWWW122)=$$$EnumCreateOnly {  ; 3
          else if (mOp.Equal(include.WWWConst.$$$WWW122UserRightForChange(m$,objWWW122),include.COMSYSEnum.$$$EnumCreateOnly(m$))) {
            //<< if (YBEARB'=1) && (YBEARB'=6) set intHidden = 2
            if ((mOp.NotEqual(YBEARB.get(),1)) && (mOp.NotEqual(YBEARB.get(),6))) {
              intHidden.set(2);
            }
          }
          //<< 
          //<< } elseif $$$WWW122UserRightForChange(objWWW122)=$$$EnumModifyOnly {  ; 4
          else if (mOp.Equal(include.WWWConst.$$$WWW122UserRightForChange(m$,objWWW122),include.COMSYSEnum.$$$EnumModifyOnly(m$))) {
            //<< if (YBEARB=1) || (YBEARB=6)   set intHidden = 2
            if ((mOp.Equal(YBEARB.get(),1)) || (mOp.Equal(YBEARB.get(),6))) {
              intHidden.set(2);
            }
          }
          //<< 
          //<< } elseif $$$WWW122UserRightForChange(objWWW122)<2 {    ; = $$$EnumCreateModifyDelete
          else if (mOp.Less(include.WWWConst.$$$WWW122UserRightForChange(m$,objWWW122),2)) {
            //<< set intHidden = 0
            intHidden.set(0);
          }
        }
        //<< }
        //<< }
        //<< 
        //<< do IsInactive^WWWFORM9(objWWW122,pstrData,.intHidden)
        m$.Cmd.Do("WWWFORM9.IsInactive",objWWW122.get(),pstrData.get(),intHidden);
      }
      //<< }
      //<< if ($get(intHidden)=2) set pblnReadOnly=$$$YES
      if ((mOp.Equal(m$.Fnc.$get(intHidden),2))) {
        pblnReadOnly.set(include.COMSYS.$$$YES(m$));
      }
    }
    //<< }
    //<< quit pblnReadOnly
    return pblnReadOnly.get();
  }

//<< 
//<< 
}
