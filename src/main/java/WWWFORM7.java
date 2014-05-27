//*****************************************************************************
//** TASC - ALPHALINC - MAC WWWFORM7
//** Innovatium Systems - Code Converter - v1.27
//** 2014-05-22 00:14:38
//*****************************************************************************

import mLibrary.mClass;
import mLibrary.mContext;
import mLibrary.mOp;
import mLibrary.mVar;
//<< 
//<< #include COMSYS
//<< #include WWWConst

//<< WWWFORM7
public class WWWFORM7 extends mClass {

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

  public void main() {
    _WWWFORM7();
  }

  public void _WWWFORM7() {
    //<< #;define LogR(%1,%2)    $$$JournalOff s ^zzLogR($g(YBED,"UNK"),$i(^zzLogR))= %1_"^WWWFORM7("_%2_") : "_$zh $$$JournalOn
    //<< #;define LogR2(%1,%2)   $$$JournalOff s ^zzLogR($g(YBED,"UNK"),$i(^zzLogR))= %1_"^WWWFORM7("_%2_") : "_$zh $$$JournalOn
    //<< #;define LogRx(%1)      $$$JournalOff s ^zzLogR($g(YBED,"UNK"),$i(^zzLogR))=%1 $$$JournalOn
    //<< 
    //<< ;-------------------------------------------------------------------------------
    //<< ; 30-Mar-2009   shobby  SR16459: code restoration from SES/DEV merge (SRBR014794)
    //<< ;-------------------------------------------------------------------------------
    //<< do Start($$$NO)  ;BR014501 Preserve backwards compatability while adding a parameter.
    m$.Cmd.Do("Start",include.COMSYS.$$$NO(m$));
    //<< quit
    return;
  }

  //<< 
  //<< ;---------------------------------------
  //<< ; YTYP : Input Type
  //<< ;---------------------------------------
  //<< ;  0 - Hidden
  //<< ;  1 - Date
  //<< ;  2 - Yes/No
  //<< ;  3 - Memo
  //<< ;  4 - Integer
  //<< ;  5 - Password
  //<< ;  6 - Text
  //<< ;  7 - Time
  //<< ;  8 - Currency            <
  //<< ;  9 - Counter
  //<< ; 10 - File Name
  //<< ; 11 - Draw
  //<< ; 12 - Floating            <
  //<< ; 13 - IP-format
  //<< ; 14 - Timestamp
  //<< ; 15 - Collection
  //<< ; 16 - Embedded
  //<< ; 17 - Date CCYYMMDD
  //<< ; 18 - Exchange Rate       <
  //<< ;---------------------------------------
  //<< 
  //<< 
  //<< Start(pblnOnBehind=$$$NO)
  public Object Start(Object ... _p) {
    mVar pblnOnBehind = m$.newVarRef("pblnOnBehind",(((_p!=null)&&(_p.length>=1))?_p[0]:null),include.COMSYS.$$$NO(m$));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Description of Function :
    //<< ;       EINGABE FELDER/CONROLS ; Draw the Form Data Fields.
    //<< ;
    //<< ; Called By : ^WWWFORM7 (previous wrapper), ^WWWFORM9 (5 calls - "P", "D", "M", "L", "O")
    //<< ;             FORMVOR^WWWFORMH ("H")
    //<< ;
    //<< ; Inputs : pblnOnBehind (passed to ANTWORPWRAPPER)
    //<< ;
    //<< ; ByRef :
    //<< ;   YSATZ       objWWW121 & objWWW122?
    //<< ;   YPARA(1)    idClass/idForm            \ or File information or relation information
    //<< ;   YPARA(2)    key[,key[,key]...]        / or colour
    //<< ;
    //<< ; Returns :
    //<< ;
    //<< ; History :
    //<< ; 07-Jan-2011   GRF     SR17579: Use explicit tag for WWWTR calls
    //<< ; 28-Sep-2007   shobby  SRBR014731: Exclude the number of items that are not
    //<< ;                           shown in the drop down from the calculation as to
    //<< ;                           whether to change to a Search function.
    //<< ; 27-Jul-2007   shobby  SRBR014645: Redirected calls from ANTWORT to ANTWORTWRAPPER
    //<< ; 18-Jun-2007   Frank   BR014485: Adding max length for fields for customization.
    //<< ; 01-Jun-2007   shobby  SRBR014501: Put the onBehind calls before the translated references.
    //<< ; 07-May-2007   GRF     SR15511: Doco; quits; naked refs
    //<< ; 22-Aug-2006   JW      SR14929: Check data type before conversion (SR14604)
    //<< ; 18-Aug-2006   RPW/JW  SR14604: Make 0 always show a popup
    //<< ; 01-Aug-2006   SC      SR14604: Switch form fields from to Search if > Max data records setting.
    //<< ; 14-Jul-2006   FAN&JW  SR14581: Don't tab into read only fields.  23-Aug -1
    //<< ; 06-Jul-2006   JW      Added Dev Msg
    //<< ; 07-Apr-2006   RPW     SR14473: Use OnChange for Checkboxes instead of OnBlur
    //<< ; 28-Oct-2005   JW      SR13074: Exchange Rate type
    //<< ; 11-Oct-2005   RPW     SR13571: Use the Disabled attribute as this works correctly.
    //<< ; 29-Aug-2005   RPW     SR13571: Select controls do not have the readonly attribute,
    //<< ;                           added style property called readOnly (too match
    //<< ;                           checking code), which is set to true when YHID=2.
    //<< ; 23-Aug-2005   JW      SR12876: Don't use browse button for files.
    //<< ; 16-Aug-2005   JW      SR12290: Do not do OnBlur Code if field is readonly.
    //<< ; 30-May-2005   SCR     SR:12220 Bug fix <B>*<B> to <B>*</B>
    //<< ; 30-May-2005   RobertW SR12056: Attempt at Performance Increase
    //<< ; 05.Aug.1997   DT
    //<< ;-------------------------------------------------------------------------------
    //<< new YSPACE,YSPACES,YSHOWRELA,strYINHALT,intMaxDataShow
    mVar YSPACE = m$.var("YSPACE");
    mVar YSPACES = m$.var("YSPACES");
    mVar YSHOWRELA = m$.var("YSHOWRELA");
    mVar strYINHALT = m$.var("strYINHALT");
    mVar intMaxDataShow = m$.var("intMaxDataShow");
    m$.newVar(YSPACE,YSPACES,YSHOWRELA,strYINHALT,intMaxDataShow);
    //<< 
    //<< $$$LogR("Start",pblnOnBehind_"<"_$get(YFORM)_"<"_YFORM_YART_YLFN_"<"_YTYP)
    $$$LogR(m$,"Start",mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(pblnOnBehind.get(),"<"),m$.Fnc.$get(m$.var("YFORM"))),"<"),m$.var("YFORM").get()),m$.var("YART").get()),m$.var("YLFN").get()),"<"),m$.var("YTYP").get()));
    //<< 
    //<< if $piece(YSATZ,Y,91)="" set $piece(YSATZ,Y,91)=$piece(YVOR,Y,91)  ;SCHRIFTART DATENEINGABE ;data input
    if (mOp.Equal(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),91),"")) {
      m$.pieceVar(m$.var("YSATZ"),m$.var("Y").get(),91).set(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),91));
    }
    //<< set YSPACES=+$piece(YVOR,Y,32) if YSPACES'=0 if +$piece(YSATZ,Y,7)'=0 set YSPACES=YSPACES+($piece(YSATZ,Y,7)*5)   ;SPACES PLUS U. MINUS ;plus minus
    YSPACES.set(mOp.Positive(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),32)));
    if (mOp.NotEqual(YSPACES.get(),0)) {
      if (mOp.NotEqual(mOp.Positive(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),7)),0)) {
        YSPACES.set(mOp.Add(YSPACES.get(),(mOp.Multiply(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),7),5))));
      }
    }
    //<< set YTABX=YTABX+1  ;TABINDEX PLUS EINZ
    mVar YTABX = m$.var("YTABX");
    YTABX.set(mOp.Add(m$.var("YTABX").get(),1));
    //<< set YSTATUS=" "
    mVar YSTATUS = m$.var("YSTATUS");
    YSTATUS.set(" ");
    //<< 
    //<< if YTYP=16 quit  ;No embeded objects displayed, only via separate forms ;TYBD;10,3,2005
    if (mOp.Equal(m$.var("YTYP").get(),16)) {
      return null;
    }
    //<< 
    //<< ;------------------------------------------------------------------------
    //<< if (YTYP=0) || (YHIDDSE=1) do  quit  ;nur hidden weil andere Seite ;solely since Side
    if ((mOp.Equal(m$.var("YTYP").get(),0)) || (mOp.Equal(m$.var("YHIDDSE").get(),1))) {
      do {
        //<< . set YHID=1
        mVar YHID = m$.var("YHID");
        YHID.set(1);
        //<< . write YCR,"<INPUT NAME=""Y"_YFORM_YART_YLFN_""""
        m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<INPUT NAME=\"Y",m$.var("YFORM").get()),m$.var("YART").get()),m$.var("YLFN").get()),"\""));
        //<< . write " ID=""Y"_YFORM_YART_YLFN_""""          ;SR17253
        m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(" ID=\"Y",m$.var("YFORM").get()),m$.var("YART").get()),m$.var("YLFN").get()),"\""));
        //<< . write " TYPE=HIDDEN"
        m$.Cmd.Write(" TYPE=HIDDEN");
        //<< . if $get(YTYP)'="" set YINHALT = $$GetLiteral^WWWTR(YTYP,YINHALT)
        if (mOp.NotEqual(m$.Fnc.$get(m$.var("YTYP")),"")) {
          mVar YINHALT = m$.var("YINHALT");
          YINHALT.set(m$.fnc$("WWWTR.GetLiteral",m$.var("YTYP").get(),m$.var("YINHALT").get()));
        }
        //<< . if $find(YINHALT,"""") do  quit
        if (mOp.Logical(m$.Fnc.$find(m$.var("YINHALT").get(),"\""))) {
          //<< . . if $find(YINHALT,"'") set YINHALT = $translate(YINHALT,"'","´")
          if (mOp.Logical(m$.Fnc.$find(m$.var("YINHALT").get(),"'"))) {
            mVar YINHALT = m$.var("YINHALT");
            YINHALT.set(m$.Fnc.$translate(m$.var("YINHALT").get(),"'","´"));
          }
          //<< . . write " VALUE='"_YINHALT_"'" write ">"
          m$.Cmd.Write(mOp.Concat(mOp.Concat(" VALUE='",m$.var("YINHALT").get()),"'"));
          m$.Cmd.Write(">");
          break;
        }
        //<< . ;
        //<< . if YINHALT'="" write " VALUE="""_YINHALT_""""
        if (mOp.NotEqual(m$.var("YINHALT").get(),"")) {
          m$.Cmd.Write(mOp.Concat(mOp.Concat(" VALUE=\"",m$.var("YINHALT").get()),"\""));
        }
        //<< . write ">"
        m$.Cmd.Write(">");
      } while (false);
      return null;
    }
    //<< 
    //<< ;------------------------------------------------------------------------
    //<< 
    //<< if YBEDBER=1 write YCR,YCR,"<!-- ********************* Feldname:'"_YNAME_"' NAME: 'Y"_YFORM_YART_YLFN_"' (WWWFORM7)******************* -->",YCR,YCR
    if (mOp.Equal(m$.var("YBEDBER").get(),1)) {
      m$.Cmd.Write(m$.var("YCR").get(),m$.var("YCR").get(),mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<!-- ********************* Feldname:'",m$.var("YNAME").get()),"' NAME: 'Y"),m$.var("YFORM").get()),m$.var("YART").get()),m$.var("YLFN").get()),"' (WWWFORM7)******************* -->"),m$.var("YCR").get(),m$.var("YCR").get());
    }
    //<< 
    //<< ; vvv BR014485 version 1
    //<< set YLAMX=50                                          ;MAXIMALE LÄNGE DER Antwort ;length of the Answer
    mVar YLAMX = m$.var("YLAMX");
    YLAMX.set(50);
    //<< if +$piece(YVOR,Y,20)'=0 set YLAMX=$piece(YVOR,Y,20)  ;mauelle vorgabe der max.antwortlänge ;who
    if (mOp.NotEqual(mOp.Positive(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),20)),0)) {
      YLAMX.set(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),20));
    }
    //<< 
    //<< ; BR014485
    //<< set objFormCustomization = $get(^WWW120D(0,YFORM,YM,1))
    mVar objFormCustomization = m$.var("objFormCustomization");
    objFormCustomization.set(m$.Fnc.$get(m$.var("^WWW120D",0,m$.var("YFORM").get(),m$.var("YM").get(),1)));
    //<< set intMaxLength = $$$WWW120DMaxLengthOfResponseField(objFormCustomization)
    mVar intMaxLength = m$.var("intMaxLength");
    intMaxLength.set(include.WWWConst.$$$WWW120DMaxLengthOfResponseField(m$,objFormCustomization));
    //<< if intMaxLength > 0 set YLAMX = intMaxLength
    if (mOp.Greater(intMaxLength.get(),0)) {
      YLAMX.set(intMaxLength.get());
    }
    //<< 
    //<< ; vvv BR014485 alternative version
    //<< ;set objFormCustomization = $get(^WWW120D(0,YFORM,YM,1))
    //<< ;set YLAMX = +$$$WWW120DMaxLengthOfResponseField(objFormCustomization)
    //<< ;if YLAMX<0  set YLAMX = 0
    //<< ;if YLAMX=0  set YLAMX = $$$WWW120MaxLengthOfResponseField(YFORM)
    //<< ;if YLAMX<=0 set YLAMX = 50
    //<< ; ^^^
    //<< 
    //<< if YHID'=1 if YTYP'=0 set YINHALT=$$^WWWUML(YINHALT)  ;SICHTBARES FELD;AUSGESCHALTET;TYBD;28.07.2004;26177;UMSTELLUNG BEI PARAMETERN NUR WENN "" NICHT LÖSCHEN
    if (mOp.NotEqual(m$.var("YHID").get(),1)) {
      if (mOp.NotEqual(m$.var("YTYP").get(),0)) {
        mVar YINHALT = m$.var("YINHALT");
        YINHALT.set(m$.fnc$("WWWUML.main",m$.var("YINHALT").get()));
      }
    }
    //<< set YTYPE="TEXT"
    mVar YTYPE = m$.var("YTYPE");
    YTYPE.set("TEXT");
    //<< 
    //<< ;---------------------------------------
    //<< ;setzen der eingabearten ;typeset who
    //<< ;---------------------------------------
    //<< if YPARA(1)="" do
    if (mOp.Equal(m$.var("YPARA").var(1).get(),"")) {
      //<< . if YTYP=1 do
      if (mOp.Equal(m$.var("YTYP").get(),1)) {
        //<< . . if YINHALT="." set YINHALT = +$horolog   ;TAGESDATUM
        if (mOp.Equal(m$.var("YINHALT").get(),".")) {
          mVar YINHALT = m$.var("YINHALT");
          YINHALT.set(mOp.Positive(m$.Fnc.$horolog()));
        }
      }
      //<< . ;
      //<< . if YTYP=7 do
      if (mOp.Equal(m$.var("YTYP").get(),7)) {
        //<< . . if YINHALT="." set YINHALT = $piece($horolog,",",2)   ;UHRZEIT
        if (mOp.Equal(m$.var("YINHALT").get(),".")) {
          mVar YINHALT = m$.var("YINHALT");
          YINHALT.set(m$.Fnc.$piece(m$.Fnc.$horolog(),",",2));
        }
      }
      //<< . ;
      //<< . if YTYP=17 do      ;BEC;SETZTEN TAGESDATUM BEI ANDEM FORMAT JJCCMMTT ;next to format
      if (mOp.Equal(m$.var("YTYP").get(),17)) {
        //<< . . if YINHALT="." do
        if (mOp.Equal(m$.var("YINHALT").get(),".")) {
          //<< . . . set YINHALT = $$GetLiteral^WWWTR(1,+$horolog)   ;TAGESDATUM
          mVar YINHALT = m$.var("YINHALT");
          YINHALT.set(m$.fnc$("WWWTR.GetLiteral",1,mOp.Positive(m$.Fnc.$horolog())));
          //<< . . . set YINHALT = $$GetInternal^WWWTR(17,YINHALT)
          YINHALT.set(m$.fnc$("WWWTR.GetInternal",17,YINHALT.get()));
        }
      }
      //<< . ;
      //<< . if YTYP=8 if $find(YINHALT,"@") do
      if (mOp.Equal(m$.var("YTYP").get(),8)) {
        if (mOp.Logical(m$.Fnc.$find(m$.var("YINHALT").get(),"@"))) {
          //<< . . set YSTATUS=" "_$zconvert($translate($piece(YINHALT,"@",2),"1234567890., "),"U")_": "_$$^WWWZAHL($translate($piece(YINHALT,"@",2),"ABCDEFGHIJKLMNOPQRSTUVWXYZ"),0,2)_" (x "_$translate($piece(YINHALT,"@",3),".",YDECIMAL)_") "_YSTATUS  ;FIS;21.05.04;25727        // FIXME JW - status bar description of currency amount
          YSTATUS.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(" ",m$.Fnc.$zconvert(m$.Fnc.$translate(m$.Fnc.$piece(m$.var("YINHALT").get(),"@",2),"1234567890., "),"U")),": "),m$.fnc$("WWWZAHL.main",m$.Fnc.$translate(m$.Fnc.$piece(m$.var("YINHALT").get(),"@",2),"ABCDEFGHIJKLMNOPQRSTUVWXYZ"),0,2))," (x "),m$.Fnc.$translate(m$.Fnc.$piece(m$.var("YINHALT").get(),"@",3),".",m$.var("YDECIMAL").get())),") "),YSTATUS.get()));
        }
      }
      //<< . ;
      //<< . if (YTYP=8) && ($get(^CacheTemp(YUSER,YFORM,"Toggles","Currency"))="Foreign") do
      if ((mOp.Equal(m$.var("YTYP").get(),8)) && (mOp.Equal(m$.Fnc.$get(m$.var("^CacheTemp",m$.var("YUSER").get(),m$.var("YFORM").get(),"Toggles","Currency")),"Foreign"))) {
        //<< . . set YINHALT = $$GetLiteral^WWWTR(8,$$FCAmount^WWWTR(YINHALT))
        mVar YINHALT = m$.var("YINHALT");
        YINHALT.set(m$.fnc$("WWWTR.GetLiteral",8,m$.fnc$("WWWTR.FCAmount",m$.var("YINHALT").get())));
      }
      //<< . ;
      //<< . if (YTYP=8) && ($get(^CacheTemp(YUSER,YFORM,"Toggles","Currency"))'="Foreign") do
      if ((mOp.Equal(m$.var("YTYP").get(),8)) && (mOp.NotEqual(m$.Fnc.$get(m$.var("^CacheTemp",m$.var("YUSER").get(),m$.var("YFORM").get(),"Toggles","Currency")),"Foreign"))) {
        //<< . . set YINHALT = $$GetLiteral^WWWTR(8,$$FCBase^WWWTR(YINHALT))
        mVar YINHALT = m$.var("YINHALT");
        YINHALT.set(m$.fnc$("WWWTR.GetLiteral",8,m$.fnc$("WWWTR.FCBase",m$.var("YINHALT").get())));
      }
      //<< . ;
      //<< . if (YTYP'=8) set YINHALT = $$GetLiteral^WWWTR(YTYP,YINHALT)  ;Convert to External Format
      if ((mOp.NotEqual(m$.var("YTYP").get(),8))) {
        mVar YINHALT = m$.var("YINHALT");
        YINHALT.set(m$.fnc$("WWWTR.GetLiteral",m$.var("YTYP").get(),m$.var("YINHALT").get()));
      }
      //<< . ;
      //<< . if YTYP=15 set YXTYP = 16  ;COLLATION
      if (mOp.Equal(m$.var("YTYP").get(),15)) {
        mVar YXTYP = m$.var("YXTYP");
        YXTYP.set(16);
      }
      //<< . if YTYP=1  set YTYPE = "date" set YLANGE = 10
      if (mOp.Equal(m$.var("YTYP").get(),1)) {
        YTYPE.set("date");
        mVar YLANGE = m$.var("YLANGE");
        YLANGE.set(10);
      }
      //<< . if YTYP=17 set YTYPE = "date" set YLANGE = 10
      if (mOp.Equal(m$.var("YTYP").get(),17)) {
        YTYPE.set("date");
        mVar YLANGE = m$.var("YLANGE");
        YLANGE.set(10);
      }
      //<< . if YTYP=9  set YTYPE = "int"
      if (mOp.Equal(m$.var("YTYP").get(),9)) {
        YTYPE.set("int");
      }
      //<< . if YTYP=4  set YTYPE = "float"
      if (mOp.Equal(m$.var("YTYP").get(),4)) {
        YTYPE.set("float");
      }
      //<< . if YTYP=5  set YTYPE = "PASSWORD"
      if (mOp.Equal(m$.var("YTYP").get(),5)) {
        YTYPE.set("PASSWORD");
      }
      //<< . if (YTYP=8) || (YTYP=12) || (YTYP=18) set YTYPE = "float"   ; incl. currecy types
      if ((mOp.Equal(m$.var("YTYP").get(),8)) || (mOp.Equal(m$.var("YTYP").get(),12)) || (mOp.Equal(m$.var("YTYP").get(),18))) {
        YTYPE.set("float");
      }
      //<< . if YTYP=0  set YTYPE = "HIDDEN"
      if (mOp.Equal(m$.var("YTYP").get(),0)) {
        YTYPE.set("HIDDEN");
      }
      //<< . if YTYP=10 set YTYPE = "FILENAME"
      if (mOp.Equal(m$.var("YTYP").get(),10)) {
        YTYPE.set("FILENAME");
      }
      //<< . if YTYP=11 set YTYPE = "SCRIBBLE"
      if (mOp.Equal(m$.var("YTYP").get(),11)) {
        YTYPE.set("SCRIBBLE");
      }
      //<< . if YTYP=7  set YLANGE = 8 if SPRACHE'="DE" set YLANGE = 11      ;Time    ; FIXME : "DE"
      if (mOp.Equal(m$.var("YTYP").get(),7)) {
        mVar YLANGE = m$.var("YLANGE");
        YLANGE.set(8);
        if (mOp.NotEqual(m$.var("SPRACHE").get(),"DE")) {
          YLANGE.set(11);
        }
      }
      //<< . if YXTYP=9 set YTYPE = "FILENAME"
      if (mOp.Equal(m$.var("YXTYP").get(),9)) {
        YTYPE.set("FILENAME");
      }
      //<< . if YTYPE="FILE" do                            ;WENN AUF DISK GESUCHT WERDEN SOLL ;when upon studied will
      if (mOp.Equal(YTYPE.get(),"FILE")) {
        //<< . . set YPARA(1) = $piece($get(YPARA(2)),"*",1)  ;'="" DANN DISK
        mVar YPARA = m$.var("YPARA");
        YPARA.var(1).set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("YPARA").var(2)),"*",1));
        //<< . . set YPARA(2) = $piece($get(YPARA(2)),"*",2)
        YPARA.var(2).set(m$.Fnc.$piece(m$.Fnc.$get(YPARA.var(2)),"*",2));
      }
      //<< . ;
      //<< . if YXTYP=8 set YTYPE = "RANGE"
      if (mOp.Equal(m$.var("YXTYP").get(),8)) {
        YTYPE.set("RANGE");
      }
      //<< . if YXTYP=7 set YTYPE = "SCRIBBLE"
      if (mOp.Equal(m$.var("YXTYP").get(),7)) {
        YTYPE.set("SCRIBBLE");
      }
    }
    //<< 
    //<< ;------------------------------------------------------------------------
    //<< 
    //<< if YFOART=7 if YART="P" set YXTYP=1,YTYPE="text",YTYP=6  ;PRINÄRSCHLUESSEL BEI SUCHMASCHINE ;next to
    if (mOp.Equal(m$.var("YFOART").get(),7)) {
      if (mOp.Equal(m$.var("YART").get(),"P")) {
        mVar YXTYP = m$.var("YXTYP");
        YXTYP.set(1);
        YTYPE.set("text");
        mVar YTYP = m$.var("YTYP");
        YTYP.set(6);
      }
    }
    //<< if (YXTYP=3) || (YTYP=2) set YINHALT=+YINHALT
    if ((mOp.Equal(m$.var("YXTYP").get(),3)) || (mOp.Equal(m$.var("YTYP").get(),2))) {
      mVar YINHALT = m$.var("YINHALT");
      YINHALT.set(mOp.Positive(m$.var("YINHALT").get()));
    }
    //<< if YPARA(1)'="" if YPARA(20)'=2 do
    if (mOp.NotEqual(m$.var("YPARA").var(1).get(),"")) {
      if (mOp.NotEqual(m$.var("YPARA").var(20).get(),2)) {
        do {
          //<< . kill ^WWWSOR(YUSER,2)  ;KILL PARAMETER
          m$.var("^WWWSOR",m$.var("YUSER").get(),2).kill();
          //<< . if YFOART=7 if $extract(YPARA(2))'="""" quit  ;BEI SUCHMSCHINE KEINE GROßEN DATEIEN IN PARAMETER ;next to no within parameter
          if (mOp.Equal(m$.var("YFOART").get(),7)) {
            if (mOp.NotEqual(m$.Fnc.$extract(m$.var("YPARA").var(2).get()),"\"")) {
              break;
            }
          }
          //<< . do ^WWWFOR71  ;relationen suchen wenn mit Anzeige ;seek when by means of show Field
          m$.Cmd.Do("WWWFOR71.main");
          //<< . if $order(^WWWSOR(YUSER,2,""))="" set YPARA(7)=0
          if (mOp.Equal(m$.Fnc.$order(m$.var("^WWWSOR",m$.var("YUSER").get(),2,"")),"")) {
            mVar YPARA = m$.var("YPARA");
            YPARA.var(7).set(0);
          }
          //<< . if YPARA(20)'=1 if YPARA(7)=0 if +YXTYP=0 set YXTYP=4  ;SELECT OHNE SELECT;TYBD;19,11,2004
          if (mOp.NotEqual(m$.var("YPARA").var(20).get(),1)) {
            if (mOp.Equal(m$.var("YPARA").var(7).get(),0)) {
              if (mOp.Equal(mOp.Positive(m$.var("YXTYP").get()),0)) {
                mVar YXTYP = m$.var("YXTYP");
                YXTYP.set(4);
              }
            }
          }
          //<< . ;
          //<< . set intMaxDataShow = $$GetMaxSelectRecords^WWW012()
          intMaxDataShow.set(m$.fnc$("WWW012.GetMaxSelectRecords"));
          //<< . if +YPARA(20)=0 if (YPARA(7)-$get(YPARA("Excluded")))>intMaxDataShow if $$ComboToSearch^WWWFOR71(YXTYP,YPARA(1)) do
          if (mOp.Equal(mOp.Positive(m$.var("YPARA").var(20).get()),0)) {
            if (mOp.Greater((mOp.Subtract(m$.var("YPARA").var(7).get(),m$.Fnc.$get(m$.var("YPARA").var("Excluded")))),intMaxDataShow.get())) {
              if (mOp.Logical(m$.fnc$("WWWFOR71.ComboToSearch",m$.var("YXTYP").get(),m$.var("YPARA").var(1).get()))) {
                //<< . . set YPARA(7)=0
                mVar YPARA = m$.var("YPARA");
                YPARA.var(7).set(0);
                //<< . . set YPARA(20)=1
                YPARA.var(20).set(1);
                //<< . . set YXTYP=1
                mVar YXTYP = m$.var("YXTYP");
                YXTYP.set(1);
                //<< . . set $$$WWW122RelationWithSearchFuncti(YSATZ) = 1
                include.WWWConst.$$$WWW122RelationWithSearchFunctiSet(m$,m$.var("YSATZ"),1);
              }
            }
          }
        } while (false);
      }
    }
    //<< 
    //<< if '$find(YFORM,"_") && '$find(YFORM,"-") && $data(@("^Y"_YFORM_YART_YLFN)) do  ;INDIVIDUAL SELECTFELD
    if (mOp.Not(m$.Fnc.$find(m$.var("YFORM").get(),"_")) && mOp.Not(m$.Fnc.$find(m$.var("YFORM").get(),"-")) && mOp.Logical(m$.Fnc.$data(m$.indirectVar((mOp.Concat(mOp.Concat(mOp.Concat("^Y",m$.var("YFORM").get()),m$.var("YART").get()),m$.var("YLFN").get())))))) {
      //<< . merge ^WWWSOR(YUSER,2)=@("^Y"_YFORM_YART_YLFN)
      m$.Cmd.Merge(m$.var("^WWWSOR",m$.var("YUSER").get(),2),m$.indirectVar((mOp.Concat(mOp.Concat(mOp.Concat("^Y",m$.var("YFORM").get()),m$.var("YART").get()),m$.var("YLFN").get()))));
      //<< . ;SET ^YformnameD3(SORT,SELECT)=TEXT
      //<< . set YPARA(7)  = 2
      mVar YPARA = m$.var("YPARA");
      YPARA.var(7).set(2);
      //<< . set YPARA(55) = ""
      YPARA.var(55).set("");
      //<< . set YXTYP     = 4   ;SELECTFELD
      mVar YXTYP = m$.var("YXTYP");
      YXTYP.set(4);
    }
    //<< 
    //<< ;------------------------------------------------------------------------ ;position der Frage zur antwort
    //<< if $piece(YVOR,Y,70)'=0 if $piece(YSATZ,Y,70)="" set $piece(YSATZ,Y,70)=$piece(YVOR,Y,70)
    if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),70),0)) {
      if (mOp.Equal(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),70),"")) {
        m$.pieceVar(m$.var("YSATZ"),m$.var("Y").get(),70).set(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),70));
      }
    }
    //<< 
    //<< ;           $$$WWW121 / $$$WWW122
    //<< ;   D70     $$$WWW122PositionCaptionToAnswer()
    //<< ;   D92     $$$WWW122ExecuteBeforeDataField()    Execute At Form Construction (Before)
    //<< ;   D93     $$$WWW122FixAnswerLengthInPixel()
    //<< 
    //<< ;+++++++++++++++++++++++++++++++++++++++
    //<< ;  0    Caption Before Answer
    //<< ;+++++++++++++++++++++++++++++++++++++++
    //<< 
    //<< if +$piece(YSATZ,Y,70)=0 do  ;normal                        ; *** EXECUTE ***
    if (mOp.Equal(mOp.Positive(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),70)),0)) {
      //<< . do VOR
      m$.Cmd.Do("VOR");
      //<< . do FRAGE
      m$.Cmd.Do("FRAGE");
      //<< . do OnBeforeField
      m$.Cmd.Do("OnBeforeField");
      //<< . do NEXT
      m$.Cmd.Do("NEXT");
      //<< . do ANTWORTWRAPPER(pblnOnBehind)
      m$.Cmd.Do("ANTWORTWRAPPER",pblnOnBehind.get());
      //<< . if (YNAME'="") || (YNAME0'="") if YTYP=8 write YCR,"<B>" do ^WWWEURO(2,$piece(YVOR1,Y,75),"R") write "</B>"   ;WÄHRUNG ;money standard
      if ((mOp.NotEqual(m$.var("YNAME").get(),"")) || (mOp.NotEqual(m$.var("YNAME0").get(),""))) {
        if (mOp.Equal(m$.var("YTYP").get(),8)) {
          m$.Cmd.Write(m$.var("YCR").get(),"<B>");
          m$.Cmd.Do("WWWEURO.main",2,m$.Fnc.$piece(m$.var("YVOR1").get(),m$.var("Y").get(),75),"R");
          m$.Cmd.Write("</B>");
        }
      }
    }
    //<< 
    //<< ;+++++++++++++++++++++++++++++++++++++++
    //<< ;  1    Caption Over Answer
    //<< ;+++++++++++++++++++++++++++++++++++++++
    //<< if +$piece(YSATZ,Y,70)=1 do  ;frage oberhalb ;over          ; *** EXECUTE ***
    if (mOp.Equal(mOp.Positive(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),70)),1)) {
      //<< . do VOR
      m$.Cmd.Do("VOR");
      //<< . do FRAGE
      m$.Cmd.Do("FRAGE");
      //<< . do OnBeforeField
      m$.Cmd.Do("OnBeforeField");
      //<< . if (YNAME'="") || (YNAME0'="") if YTYP=8 write YCR,"<B>" do ^WWWEURO(2,$piece(YVOR1,Y,75),"R") write "</B>"   ;WÄHRUNG ;money standard
      if ((mOp.NotEqual(m$.var("YNAME").get(),"")) || (mOp.NotEqual(m$.var("YNAME0").get(),""))) {
        if (mOp.Equal(m$.var("YTYP").get(),8)) {
          m$.Cmd.Write(m$.var("YCR").get(),"<B>");
          m$.Cmd.Do("WWWEURO.main",2,m$.Fnc.$piece(m$.var("YVOR1").get(),m$.var("Y").get(),75),"R");
          m$.Cmd.Write("</B>");
        }
      }
      //<< . write "<BR>"
      m$.Cmd.Write("<BR>");
      //<< . if +$piece(YSATZ,Y,93)'=0 do  ;FESTE BREITE ;width
      if (mOp.NotEqual(mOp.Positive(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),93)),0)) {
        //<< . . write YCR,"<TABLE BORDER=0 frame=void cellpadding=0 cellspacing=0>"
        m$.Cmd.Write(m$.var("YCR").get(),"<TABLE BORDER=0 frame=void cellpadding=0 cellspacing=0>");
        //<< . . set YTABLEANZ = $get(YTABLEANZ)+1
        mVar YTABLEANZ = m$.var("YTABLEANZ");
        YTABLEANZ.set(mOp.Add(m$.Fnc.$get(m$.var("YTABLEANZ")),1));
        //<< . . write YCR,"<TR>"
        m$.Cmd.Write(m$.var("YCR").get(),"<TR>");
        //<< . . write "<TD NOWRAP VALIGN="_YVAUS_" ALIGN="_YFAUS
        m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat("<TD NOWRAP VALIGN=",m$.var("YVAUS").get())," ALIGN="),m$.var("YFAUS").get()));
        //<< . . write " WIDTH="_$piece(YSATZ,Y,93)
        m$.Cmd.Write(mOp.Concat(" WIDTH=",m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),93)));
        //<< . . write ">",YCR
        m$.Cmd.Write(">",m$.var("YCR").get());
      }
      //<< . ;
      //<< . do ANTWORTWRAPPER(pblnOnBehind)
      m$.Cmd.Do("ANTWORTWRAPPER",pblnOnBehind.get());
      //<< . if +$piece(YSATZ,Y,93)'=0 do  ;FESTE BREITE ;width
      if (mOp.NotEqual(mOp.Positive(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),93)),0)) {
        //<< . . write YCR,"</TD></TR></TABLE>"
        m$.Cmd.Write(m$.var("YCR").get(),"</TD></TR></TABLE>");
        //<< . . set YTABLEANZ = $get(YTABLEANZ)-1
        mVar YTABLEANZ = m$.var("YTABLEANZ");
        YTABLEANZ.set(mOp.Subtract(m$.Fnc.$get(m$.var("YTABLEANZ")),1));
      }
    }
    //<< 
    //<< ;+++++++++++++++++++++++++++++++++++++++
    //<< ;  2    Caption After Answer
    //<< ;+++++++++++++++++++++++++++++++++++++++
    //<< if +$piece(YSATZ,Y,70)=2 do  ;frage hinter ;posterior       ; *** EXECUTE ***
    if (mOp.Equal(mOp.Positive(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),70)),2)) {
      //<< . set YFAUS="RIGHT"
      mVar YFAUS = m$.var("YFAUS");
      YFAUS.set("RIGHT");
      //<< . do VOR
      m$.Cmd.Do("VOR");
      //<< . do OnBeforeField
      m$.Cmd.Do("OnBeforeField");
      //<< . do ANTWORTWRAPPER(pblnOnBehind)
      m$.Cmd.Do("ANTWORTWRAPPER",pblnOnBehind.get());
      //<< . do NEXT
      m$.Cmd.Do("NEXT");
      //<< . if (YNAME'="") || (YNAME0'="") if YTYP=8 write YCR,"<B>" do ^WWWEURO(2,$piece(YVOR1,Y,75),"R") write "</B>"   ;WÄHRUNG ;money standard
      if ((mOp.NotEqual(m$.var("YNAME").get(),"")) || (mOp.NotEqual(m$.var("YNAME0").get(),""))) {
        if (mOp.Equal(m$.var("YTYP").get(),8)) {
          m$.Cmd.Write(m$.var("YCR").get(),"<B>");
          m$.Cmd.Do("WWWEURO.main",2,m$.Fnc.$piece(m$.var("YVOR1").get(),m$.var("Y").get(),75),"R");
          m$.Cmd.Write("</B>");
        }
      }
      //<< . do FRAGE
      m$.Cmd.Do("FRAGE");
    }
    //<< 
    //<< ;+++++++++++++++++++++++++++++++++++++++
    //<< ;  3    Caption Under Answer
    //<< ;+++++++++++++++++++++++++++++++++++++++
    //<< if +$piece(YSATZ,Y,70)=3 do   ;frage unter ;under           ; *** EXECUTE ***
    if (mOp.Equal(mOp.Positive(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),70)),3)) {
      //<< . do VOR
      m$.Cmd.Do("VOR");
      //<< . do OnBeforeField
      m$.Cmd.Do("OnBeforeField");
      //<< . do ANTWORTWRAPPER(pblnOnBehind)
      m$.Cmd.Do("ANTWORTWRAPPER",pblnOnBehind.get());
      //<< . write YCR,"<BR>"
      m$.Cmd.Write(m$.var("YCR").get(),"<BR>");
      //<< . do FRAGE
      m$.Cmd.Do("FRAGE");
      //<< . if (YNAME'="") || (YNAME0'="") if YTYP=8 write YCR,"<B>" do ^WWWEURO(2,$piece(YVOR1,Y,75),"R") write "</B>"   ;WÄHRUNG ;money standard
      if ((mOp.NotEqual(m$.var("YNAME").get(),"")) || (mOp.NotEqual(m$.var("YNAME0").get(),""))) {
        if (mOp.Equal(m$.var("YTYP").get(),8)) {
          m$.Cmd.Write(m$.var("YCR").get(),"<B>");
          m$.Cmd.Do("WWWEURO.main",2,m$.Fnc.$piece(m$.var("YVOR1").get(),m$.var("Y").get(),75),"R");
          m$.Cmd.Write("</B>");
        }
      }
    }
    //<< 
    //<< ;+++++++++++++++++++++++++++++++++++++++
    //<< ;  4    No Caption
    //<< ;+++++++++++++++++++++++++++++++++++++++
    //<< if +$piece(YSATZ,Y,70)=4 do  ;keine frage ;None             ; *** EXECUTE ***
    if (mOp.Equal(mOp.Positive(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),70)),4)) {
      //<< . do VOR
      m$.Cmd.Do("VOR");
      //<< . set YNAME=""  ;KEINE BEZEICHNUNG ;no notation
      mVar YNAME = m$.var("YNAME");
      YNAME.set("");
      //<< . do FRAGE
      m$.Cmd.Do("FRAGE");
      //<< . do OnBeforeField
      m$.Cmd.Do("OnBeforeField");
      //<< . if YNAME0'="" do NEXT
      if (mOp.NotEqual(m$.var("YNAME0").get(),"")) {
        m$.Cmd.Do("NEXT");
      }
      //<< . if YNAME0="" do
      if (mOp.Equal(m$.var("YNAME0").get(),"")) {
        //<< . . set YSPALTE = YSPAL
        mVar YSPALTE = m$.var("YSPALTE");
        YSPALTE.set(m$.var("YSPAL").get());
        //<< . . if +$piece(YSATZ,Y,93)'=0 do  ;FESTE BREITE ;width
        if (mOp.NotEqual(mOp.Positive(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),93)),0)) {
          //<< . . . write YCR,"<TABLE BORDER=0 frame=void cellpadding=0 cellspacing=0>"
          m$.Cmd.Write(m$.var("YCR").get(),"<TABLE BORDER=0 frame=void cellpadding=0 cellspacing=0>");
          //<< . . . set YTABLEANZ = $get(YTABLEANZ)+1
          mVar YTABLEANZ = m$.var("YTABLEANZ");
          YTABLEANZ.set(mOp.Add(m$.Fnc.$get(m$.var("YTABLEANZ")),1));
          //<< . . . write YCR,"<TR>"
          m$.Cmd.Write(m$.var("YCR").get(),"<TR>");
          //<< . . . write "<TD NOWRAP VALIGN="_YVAUS_" ALIGN="_YFAUS
          m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat("<TD NOWRAP VALIGN=",m$.var("YVAUS").get())," ALIGN="),m$.var("YFAUS").get()));
          //<< . . . write " WIDTH="_$piece(YSATZ,Y,93)
          m$.Cmd.Write(mOp.Concat(" WIDTH=",m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),93)));
          //<< . . . write ">",YCR
          m$.Cmd.Write(">",m$.var("YCR").get());
        }
      }
      //<< . ;
      //<< . do ANTWORTWRAPPER(pblnOnBehind)
      m$.Cmd.Do("ANTWORTWRAPPER",pblnOnBehind.get());
      //<< . if YNAME0="" if +$piece(YSATZ,Y,93)'=0 do  ;FESTE BREITE ;width
      if (mOp.Equal(m$.var("YNAME0").get(),"")) {
        if (mOp.NotEqual(mOp.Positive(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),93)),0)) {
          //<< . . write YCR
          m$.Cmd.Write(m$.var("YCR").get());
          //<< . . write "</TD></TR></TABLE>"
          m$.Cmd.Write("</TD></TR></TABLE>");
          //<< . . set YTABLEANZ = $get(YTABLEANZ)-1
          mVar YTABLEANZ = m$.var("YTABLEANZ");
          YTABLEANZ.set(mOp.Subtract(m$.Fnc.$get(m$.var("YTABLEANZ")),1));
        }
      }
    }
    //<< 
    //<< ;---------------------------------------
    //<< ;   D64     $$$WWW012FontColorMandatoryInput
    //<< ; Empty Mandatory or Primary Key, Enabled and not Search Engine
    //<< ; If no Colour assigned for mandatory fields, append a red asterisk to the field
    //<< ;---------------------------------------
    //<< ; FIXME : perhaps - if (YART="P") || ((YPFLICHT=1) && (YINHALT="")) ... ?
    //<< if (YPFLICHT=1) || (YART="P") if (YINHALT="") || (YART="P") if +YHID=0 if YFOART'=7 if $piece(YVOR,Y,64)="" write "<FONT COLOR=RED><B>*</B></FONT>"
    if ((mOp.Equal(m$.var("YPFLICHT").get(),1)) || (mOp.Equal(m$.var("YART").get(),"P"))) {
      if ((mOp.Equal(m$.var("YINHALT").get(),"")) || (mOp.Equal(m$.var("YART").get(),"P"))) {
        if (mOp.Equal(mOp.Positive(m$.var("YHID").get()),0)) {
          if (mOp.NotEqual(m$.var("YFOART").get(),7)) {
            if (mOp.Equal(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),64),"")) {
              m$.Cmd.Write("<FONT COLOR=RED><B>*</B></FONT>");
            }
          }
        }
      }
    }
    //<< write YCR
    m$.Cmd.Write(m$.var("YCR").get());
    //<< 
    //<< ;---------------------------------------
    //<< ;  DEVELOPER'S REMINDER
    //<< ;---------------------------------------
    //<< if $$$DEVMODE {
    if (mOp.Logical(include.COMSYS.$$$DEVMODE(m$))) {
      //<< if ($$$Contains(("WWW001","WWW002","WWW003","WWW003Calc"),YFORM)) {
      if (mOp.Logical((include.COMSYS.$$$Contains(m$,("WWW001"),m$.var("YFORM"))))) {
        //<< if (YART="P") && (YLFN=1) {
        if ((mOp.Equal(m$.var("YART").get(),"P")) && (mOp.Equal(m$.var("YLFN").get(),1))) {
          //<< write "<td><font color=red size=2><b><i>"
          m$.Cmd.Write("<td><font color=red size=2><b><i>");
          //<< write " &nbsp Don't forget to compile after making changes!"
          m$.Cmd.Write(" &nbsp Don't forget to compile after making changes!");
          //<< write "</i></b></font></td>"
          m$.Cmd.Write("</i></b></font></td>");
        }
      }
    }
    //<< }
    //<< }
    //<< }
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< INHALT ;NACHTRÄGLICHER INHALT IN WWWDATEN ;ADDITIONAL CONTENTS IN WWW DATA
  public void INHALT() {
    //<< new YI
    mVar YI = m$.var("YI");
    m$.newVar(YI);
    //<< 
    //<< quit:YLFN=""
    if (mOp.Equal(m$.var("YLFN").get(),"")) {
      return;
    }
    //<< 
    //<< ; if "@" found for Currency Type 8 (thus Foreign Currency) - Format is retained
    //<< 
    //<< if YART="D" do      ; Data Field
    if (mOp.Equal(m$.var("YART").get(),"D")) {
      do {
        //<< . quit:YDATEI=""
        if (mOp.Equal(m$.var("YDATEI").get(),"")) {
          break;
        }
        //<< . set YI(6)=$piece($get(^WWW003(0,YDATEI,YLFN,1)),Y,3) ; Input Type
        YI.var(6).set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW003",0,m$.var("YDATEI").get(),m$.var("YLFN").get(),1)),m$.var("Y").get(),3));
        //<< . if YI(6)'="" if YI(6)'=8 if '$find(YINHALT,";") set $piece(^WWWDATEN(0,+$horolog,YUSER,YFORM,"D",1),Y,YLFN) = $$GetInternal^WWWTR(YI(6),YINHALT)
        if (mOp.NotEqual(YI.var(6).get(),"")) {
          if (mOp.NotEqual(YI.var(6).get(),8)) {
            if (mOp.Not(m$.Fnc.$find(m$.var("YINHALT").get(),";"))) {
              m$.pieceVar(m$.var("^WWWDATEN",0,mOp.Positive(m$.Fnc.$horolog()),m$.var("YUSER").get(),m$.var("YFORM").get(),"D",1),m$.var("Y").get(),m$.var("YLFN").get()).set(m$.fnc$("WWWTR.GetInternal",YI.var(6).get(),m$.var("YINHALT").get()));
            }
          }
        }
        //<< . if YI(6)'="" if YI(6)=8 do  ; Foreign Currency
        if (mOp.NotEqual(YI.var(6).get(),"")) {
          if (mOp.Equal(YI.var(6).get(),8)) {
            do {
              //<< . . new YOLDV
              mVar YOLDV = m$.var("YOLDV");
              m$.newVar(YOLDV);
              //<< . . set YOLDV = $piece($get(^WWWDATEN(0,+$horolog,YUSER,YFORM,"D",2)),Y,YLFN)
              YOLDV.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWWDATEN",0,mOp.Positive(m$.Fnc.$horolog()),m$.var("YUSER").get(),m$.var("YFORM").get(),"D",2)),m$.var("Y").get(),m$.var("YLFN").get()));
              //<< . . if $find(YOLDV,"@") if $$GetLiteral^WWWTR(YI(6),YOLDV)=YINHALT quit
              if (mOp.Logical(m$.Fnc.$find(YOLDV.get(),"@"))) {
                if (mOp.Equal(m$.fnc$("WWWTR.GetLiteral",YI.var(6).get(),YOLDV.get()),m$.var("YINHALT").get())) {
                  break;
                }
              }
              //<< . . set $piece(^WWWDATEN(0,+$horolog,YUSER,YFORM,"D",1),Y,YLFN) = $$GetInternal^WWWTR(YI(6),YINHALT)
              m$.pieceVar(m$.var("^WWWDATEN",0,mOp.Positive(m$.Fnc.$horolog()),m$.var("YUSER").get(),m$.var("YFORM").get(),"D",1),m$.var("Y").get(),m$.var("YLFN").get()).set(m$.fnc$("WWWTR.GetInternal",YI.var(6).get(),m$.var("YINHALT").get()));
            } while (false);
          }
        }
      } while (false);
    }
    //<< 
    //<< if YART="P" do      ; Primary Key
    if (mOp.Equal(m$.var("YART").get(),"P")) {
      do {
        //<< . quit:YDATEI=""
        if (mOp.Equal(m$.var("YDATEI").get(),"")) {
          break;
        }
        //<< . set YI(6)=$piece($get(^WWW002(0,YDATEI,YLFN,1)),Y,3) ; Input Type
        YI.var(6).set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW002",0,m$.var("YDATEI").get(),m$.var("YLFN").get(),1)),m$.var("Y").get(),3));
        //<< . if YI(6)'="" if YI(6)'=8 if '$find(YINHALT,";") set $piece(^WWWDATEN(0,+$horolog,YUSER,YFORM,"P",1),",",YLFN) = $$GetInternal^WWWTR(YI(6),YINHALT)
        if (mOp.NotEqual(YI.var(6).get(),"")) {
          if (mOp.NotEqual(YI.var(6).get(),8)) {
            if (mOp.Not(m$.Fnc.$find(m$.var("YINHALT").get(),";"))) {
              m$.pieceVar(m$.var("^WWWDATEN",0,mOp.Positive(m$.Fnc.$horolog()),m$.var("YUSER").get(),m$.var("YFORM").get(),"P",1),",",m$.var("YLFN").get()).set(m$.fnc$("WWWTR.GetInternal",YI.var(6).get(),m$.var("YINHALT").get()));
            }
          }
        }
        //<< . if YI(6)'="" if YI(6)=8 do  ; Foreign Currency
        if (mOp.NotEqual(YI.var(6).get(),"")) {
          if (mOp.Equal(YI.var(6).get(),8)) {
            do {
              //<< . . new YOLDV
              mVar YOLDV = m$.var("YOLDV");
              m$.newVar(YOLDV);
              //<< . . set YOLDV = $piece($get(^WWWDATEN(0,+$horolog,YUSER,YFORM,"P",2)),",",YLFN)
              YOLDV.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWWDATEN",0,mOp.Positive(m$.Fnc.$horolog()),m$.var("YUSER").get(),m$.var("YFORM").get(),"P",2)),",",m$.var("YLFN").get()));
              //<< . . if $find(YOLDV,"@") if $$GetLiteral^WWWTR(YI(6),YOLDV)=YINHALT quit
              if (mOp.Logical(m$.Fnc.$find(YOLDV.get(),"@"))) {
                if (mOp.Equal(m$.fnc$("WWWTR.GetLiteral",YI.var(6).get(),YOLDV.get()),m$.var("YINHALT").get())) {
                  break;
                }
              }
              //<< . . set $piece(^WWWDATEN(0,+$horolog,YUSER,YFORM,"P",1),",",YLFN) = $$GetInternal^WWWTR(YI(6),YINHALT)
              m$.pieceVar(m$.var("^WWWDATEN",0,mOp.Positive(m$.Fnc.$horolog()),m$.var("YUSER").get(),m$.var("YFORM").get(),"P",1),",",m$.var("YLFN").get()).set(m$.fnc$("WWWTR.GetInternal",YI.var(6).get(),m$.var("YINHALT").get()));
            } while (false);
          }
        }
      } while (false);
    }
    //<< 
    //<< if YART="M" do      ; Manual Form Field
    if (mOp.Equal(m$.var("YART").get(),"M")) {
      //<< . set YI(6)=$piece($get(^WWW122(0,YFORM,YLFN,1)),Y,5) ; Input Type
      YI.var(6).set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW122",0,m$.var("YFORM").get(),m$.var("YLFN").get(),1)),m$.var("Y").get(),5));
      //<< . set:YI(6)="" YI(6) = 6  ; TEXT
      if (mOp.Equal(YI.var(6).get(),"")) {
        YI.var(6).set(6);
      }
      //<< . if YI(6)'="" if YI(6)'=8 if '$find(YINHALT,";") set $piece(^WWWDATEN(0,+$horolog,YUSER,YFORM,"M",1),Y,YLFN) = $$GetInternal^WWWTR(YI(6),YINHALT)
      if (mOp.NotEqual(YI.var(6).get(),"")) {
        if (mOp.NotEqual(YI.var(6).get(),8)) {
          if (mOp.Not(m$.Fnc.$find(m$.var("YINHALT").get(),";"))) {
            m$.pieceVar(m$.var("^WWWDATEN",0,mOp.Positive(m$.Fnc.$horolog()),m$.var("YUSER").get(),m$.var("YFORM").get(),"M",1),m$.var("Y").get(),m$.var("YLFN").get()).set(m$.fnc$("WWWTR.GetInternal",YI.var(6).get(),m$.var("YINHALT").get()));
          }
        }
      }
      //<< . if YI(6)'="" if YI(6)=8 do  ; Foreign Currency
      if (mOp.NotEqual(YI.var(6).get(),"")) {
        if (mOp.Equal(YI.var(6).get(),8)) {
          do {
            //<< . . new YOLDV
            mVar YOLDV = m$.var("YOLDV");
            m$.newVar(YOLDV);
            //<< . . set YOLDV = $piece($get(^WWWDATEN(0,+$horolog,YUSER,YFORM,"M",2)),Y,YLFN)
            YOLDV.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWWDATEN",0,mOp.Positive(m$.Fnc.$horolog()),m$.var("YUSER").get(),m$.var("YFORM").get(),"M",2)),m$.var("Y").get(),m$.var("YLFN").get()));
            //<< . . if $find(YOLDV,"@") if $$GetLiteral^WWWTR(YI(6),YOLDV)=YINHALT quit
            if (mOp.Logical(m$.Fnc.$find(YOLDV.get(),"@"))) {
              if (mOp.Equal(m$.fnc$("WWWTR.GetLiteral",YI.var(6).get(),YOLDV.get()),m$.var("YINHALT").get())) {
                break;
              }
            }
            //<< . . set $piece(^WWWDATEN(0,+$horolog,YUSER,YFORM,"M",1),Y,YLFN) = $$GetInternal^WWWTR(YI(6),YINHALT)
            m$.pieceVar(m$.var("^WWWDATEN",0,mOp.Positive(m$.Fnc.$horolog()),m$.var("YUSER").get(),m$.var("YFORM").get(),"M",1),m$.var("Y").get(),m$.var("YLFN").get()).set(m$.fnc$("WWWTR.GetInternal",YI.var(6).get(),m$.var("YINHALT").get()));
          } while (false);
        }
      }
    }
    //<< 
    //<< quit
    return;
  }

  //<< 
  //<< VORTABLESTYLE()
  public Object VORTABLESTYLE(Object ... _p) {
    //<< ;-------------------------------------------------------------------------------
    //<< ; Margin settings separate the control on the form
    //<< ;
    //<< ; History
    //<< ; 24-Jan-2013   shobby  SESPE-474:  Creation
    //<< ;-------------------------------------------------------------------------------
    //<< new str
    mVar str = m$.var("str");
    m$.newVar(str);
    //<< 
    //<< set str=""
    str.set("");
    //<< set str=str_" style='margin-top:2px; margin-bottom:2px;'"       ;SESPE-474
    str.set(mOp.Concat(str.get()," style='margin-top:2px; margin-bottom:2px;'"));
    //<< 
    //<< quit str
    return str.get();
  }

  //<< 
  //<< VOR
  public void VOR() {
    //<< ;-------------------------------------------------------------------------------
    //<< ; Tabs and Splitting       (TABULATOREN UND SPALTEN)
    //<< ;
    //<< ; Called By : Start^WWWFORM7 - Multiple instances
    //<< ;
    //<< ; History
    //<< ; 04-Oct-2012   shobby  SR18129: Better alignment of caption and input controls
    //<< ; 01-Jun-2012   shobby  SR18027: Put id's on the caption and control.
    //<< ; 27-Sep-2011   shobby  SR17853: Reverted doCancelEvent
    //<< ; 09-Mar-2011   shobby  SR17261.1 : If a field has an ID then the help window won't
    //<< ;                           be loaded which is what we want if there is already a
    //<< ;                           popup help.
    //<< ; 02-Dec-2010   shobby  SR17261:    Include onhelp link
    //<< ;-------------------------------------------------------------------------------
    //<< ;   D44     $$$WWW120FormFormatting
    //<< ;               0   "Single Field Formatting"
    //<< ;               1   "Format Acc. To Longest Field"
    //<< ;               2   "Format In Pixels"
    //<< ;---------------------------------------
    //<< new YTDSET,strId ;SR18027
    mVar YTDSET = m$.var("YTDSET");
    mVar strId = m$.var("strId");
    m$.newVar(YTDSET,strId);
    //<< 
    //<< set strId="Y"_YFORM_YART_YLFN_"_CAPTION" ;SR18027
    strId.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("Y",m$.var("YFORM").get()),m$.var("YART").get()),m$.var("YLFN").get()),"_CAPTION"));
    //<< 
    //<< $$$LogR2("VOR",$get(YFOART)_"<"_$get(YFOART1)_"<"_YFORM_YART_YLFN)
    $$$LogR2(m$,"VOR",mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(m$.Fnc.$get(m$.var("YFOART")),"<"),m$.Fnc.$get(m$.var("YFOART1"))),"<"),m$.var("YFORM").get()),m$.var("YART").get()),m$.var("YLFN").get()));
    //<< 
    //<< set YTDSET = ""  ;WURDE EINE TABELLE AUFGEMACHT? DANN = 1  ; Set to 1 when table has been called (<TD> set)
    YTDSET.set("");
    //<< if +YSPAL=0 set YSPAL = 1
    if (mOp.Equal(mOp.Positive(m$.var("YSPAL").get()),0)) {
      mVar YSPAL = m$.var("YSPAL");
      YSPAL.set(1);
    }
    //<< if +$get(YSPALTE)=0 set YSPALTE = 1
    if (mOp.Equal(mOp.Positive(m$.Fnc.$get(m$.var("YSPALTE"))),0)) {
      mVar YSPALTE = m$.var("YSPALTE");
      YSPALTE.set(1);
    }
    //<< set YNSPAL = 0
    mVar YNSPAL = m$.var("YNSPAL");
    YNSPAL.set(0);
    //<< if YSPAL=YSPALTE set YNSPAL = 1,YSPALTE = 1
    if (mOp.Equal(m$.var("YSPAL").get(),m$.var("YSPALTE").get())) {
      YNSPAL.set(1);
      mVar YSPALTE = m$.var("YSPALTE");
      YSPALTE.set(1);
    }
    //<< 
    //<< ; Form Type 3 : Grid ?
    //<< ;---------------------------------------
    //<< if YFOART1=3 write YCR,"<TD NOWRAP VALIGN="_YVAUS_" ALIGN="_YFAUS_">" set YTDSET=1 quit
    if (mOp.Equal(m$.var("YFOART1").get(),3)) {
      m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<TD NOWRAP VALIGN=",m$.var("YVAUS").get())," ALIGN="),m$.var("YFAUS").get()),">"));
      YTDSET.set(1);
      return;
    }
    //<< 
    //<< ; "Format Acc. To Longest Field"  or  "Format In Pixels"
    //<< ;------------------------------------------------------------------------
    //<< if $piece(YVOR,Y,44)'=1 if YZEILE'=0 if (YZEIPO+1)<YZEILE do  set YZEIPO = YZEILE-1
    if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),44),1)) {
      if (mOp.NotEqual(m$.var("YZEILE").get(),0)) {
        if (mOp.Less((mOp.Add(m$.var("YZEIPO").get(),1)),m$.var("YZEILE").get())) {
          //<< . for  quit:(YZEIPO+1)'<YZEILE  do
          for (;true;) {
            if (mOp.NotLess((mOp.Add(m$.var("YZEIPO").get(),1)),m$.var("YZEILE").get())) {
              break;
            }
            //<< . . write YCR,"<TABLE BORDER=0 CELLSPACE=0"_$$VORTABLESTYLE()_">" ;SESPE-474
            m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat("<TABLE BORDER=0 CELLSPACE=0",m$.fnc$("VORTABLESTYLE")),">"));
            //<< . . write YCR,"<TR><TD>&nbsp;</TD></TR>"
            m$.Cmd.Write(m$.var("YCR").get(),"<TR><TD>&nbsp;</TD></TR>");
            //<< . . write YCR,"</TABLE>"
            m$.Cmd.Write(m$.var("YCR").get(),"</TABLE>");
            //<< . . set YZEIPO = YZEIPO+1
            mVar YZEIPO = m$.var("YZEIPO");
            YZEIPO.set(mOp.Add(m$.var("YZEIPO").get(),1));
            //<< . . set YTDSET = 1
            YTDSET.set(1);
          }
          m$.var("YZEIPO").set(mOp.Subtract(m$.var("YZEILE").get(),1));
        }
      }
    }
    //<< 
    //<< ;------------------------------------------------------------------------
    //<< ; EINZELFORMATE     Single Formats
    //<< if $piece(YVOR,Y,44)=1 do          ; "Format Acc. To Longest Field"
    if (mOp.Equal(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),44),1)) {
      //<< . if (YSPAL=1) || (YNSPAL=1) do
      if ((mOp.Equal(m$.var("YSPAL").get(),1)) || (mOp.Equal(YNSPAL.get(),1))) {
        do {
          //<< . . write YCR
          m$.Cmd.Write(m$.var("YCR").get());
          //<< . . if (YART="P") && (YLFN=1) && (YFOART=3) quit
          if ((mOp.Equal(m$.var("YART").get(),"P")) && (mOp.Equal(m$.var("YLFN").get(),1)) && (mOp.Equal(m$.var("YFOART").get(),3))) {
            break;
          }
          //<< . . write YCR,"</TR><TR>",YCR,"<TD NOWRAP VALIGN="_YVAUS_" ALIGN="_YFAUS_">"
          m$.Cmd.Write(m$.var("YCR").get(),"</TR><TR>",m$.var("YCR").get(),mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<TD NOWRAP VALIGN=",m$.var("YVAUS").get())," ALIGN="),m$.var("YFAUS").get()),">"));
          //<< . . set YZEIPO = YZEIPO+1
          mVar YZEIPO = m$.var("YZEIPO");
          YZEIPO.set(mOp.Add(m$.var("YZEIPO").get(),1));
          //<< . . set YTDSET = 1
          YTDSET.set(1);
        } while (false);
      }
      //<< . ;
      //<< . if YSPAL>YSPALTE for  quit:YSPAL=YSPALTE  do
      if (mOp.Greater(m$.var("YSPAL").get(),m$.var("YSPALTE").get())) {
        for (;true;) {
          if (mOp.Equal(m$.var("YSPAL").get(),m$.var("YSPALTE").get())) {
            break;
          }
          do {
            //<< . . if YNSPAL=0 if (YSPALTE+1)=YSPAL write YCR,"<TD NOWRAP VALIGN="_YVAUS_" ALIGN="_YFAUS_">" set YSPALTE=YSPAL set YTDSET=1 quit
            if (mOp.Equal(YNSPAL.get(),0)) {
              if (mOp.Equal((mOp.Add(m$.var("YSPALTE").get(),1)),m$.var("YSPAL").get())) {
                m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<TD NOWRAP VALIGN=",m$.var("YVAUS").get())," ALIGN="),m$.var("YFAUS").get()),">"));
                mVar YSPALTE = m$.var("YSPALTE");
                YSPALTE.set(m$.var("YSPAL").get());
                YTDSET.set(1);
                break;
              }
            }
            //<< . . write YCR,"</TD>"
            m$.Cmd.Write(m$.var("YCR").get(),"</TD>");
            //<< . . write YCR,"<TD>"
            m$.Cmd.Write(m$.var("YCR").get(),"<TD>");
            //<< . . write YCR,"</TD>"
            m$.Cmd.Write(m$.var("YCR").get(),"</TD>");
            //<< . . ;
            //<< . . write YCR,"<TD NOWRAP VALIGN="_YVAUS_" ALIGN="_YFAUS_">"
            m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<TD NOWRAP VALIGN=",m$.var("YVAUS").get())," ALIGN="),m$.var("YFAUS").get()),">"));
            //<< . . set YSPALTE = YSPALTE+1
            mVar YSPALTE = m$.var("YSPALTE");
            YSPALTE.set(mOp.Add(m$.var("YSPALTE").get(),1));
            //<< . . set YTDSET  = 1
            YTDSET.set(1);
          } while (false);
        }
      }
    }
    //<< 
    //<< ;------------------------------------------------------------------------
    //<< ; EINZELLÄNGE       Single Length
    //<< if +$piece(YVOR,Y,44)=0 do         ; "Single Field Formatting"
    if (mOp.Equal(mOp.Positive(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),44)),0)) {
      //<< . if (YSPAL=1) || (YNSPAL=1) do
      if ((mOp.Equal(m$.var("YSPAL").get(),1)) || (mOp.Equal(YNSPAL.get(),1))) {
        //<< . . write YCR,"<TABLE BORDER=0 CELLSPACING=0"_$$VORTABLESTYLE()_">" ;SESPE-474
        m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat("<TABLE BORDER=0 CELLSPACING=0",m$.fnc$("VORTABLESTYLE")),">"));
        //<< . . set YTABLEANZ = $get(YTABLEANZ)+1
        mVar YTABLEANZ = m$.var("YTABLEANZ");
        YTABLEANZ.set(mOp.Add(m$.Fnc.$get(m$.var("YTABLEANZ")),1));
        //<< . . ;
        //<< . . write YCR,"<TR><TD NOWRAP VALIGN="_YVAUS_" ALIGN="_YFAUS_">"
        m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<TR><TD NOWRAP VALIGN=",m$.var("YVAUS").get())," ALIGN="),m$.var("YFAUS").get()),">"));
        //<< . . set YZEIPO = YZEIPO+1
        mVar YZEIPO = m$.var("YZEIPO");
        YZEIPO.set(mOp.Add(m$.var("YZEIPO").get(),1));
        //<< . . set YTDSET = 1
        YTDSET.set(1);
      }
      //<< . ;
      //<< . if YSPAL>YSPALTE for  quit:YSPAL=YSPALTE  do
      if (mOp.Greater(m$.var("YSPAL").get(),m$.var("YSPALTE").get())) {
        for (;true;) {
          if (mOp.Equal(m$.var("YSPAL").get(),m$.var("YSPALTE").get())) {
            break;
          }
          do {
            //<< . . if YNSPAL=0 if (YSPALTE+1)=YSPAL write YCR,"<TD NOWRAP VALIGN="_YVAUS_" ALIGN="_YFAUS_">" set YSPALTE=YSPAL set YTDSET=1 quit
            if (mOp.Equal(YNSPAL.get(),0)) {
              if (mOp.Equal((mOp.Add(m$.var("YSPALTE").get(),1)),m$.var("YSPAL").get())) {
                m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<TD NOWRAP VALIGN=",m$.var("YVAUS").get())," ALIGN="),m$.var("YFAUS").get()),">"));
                mVar YSPALTE = m$.var("YSPALTE");
                YSPALTE.set(m$.var("YSPAL").get());
                YTDSET.set(1);
                break;
              }
            }
            //<< . . if YSPALTE'=1 write YCR,"</TD><TD>"
            if (mOp.NotEqual(m$.var("YSPALTE").get(),1)) {
              m$.Cmd.Write(m$.var("YCR").get(),"</TD><TD>");
            }
            //<< . . if YSPALTE=1  write YCR,"<TABLE BORDER=0 CELLSPACING=0>",YCR,"<TR><TD WIDTH="_YSPACES_">"
            if (mOp.Equal(m$.var("YSPALTE").get(),1)) {
              m$.Cmd.Write(m$.var("YCR").get(),"<TABLE BORDER=0 CELLSPACING=0>",m$.var("YCR").get(),mOp.Concat(mOp.Concat("<TR><TD WIDTH=",m$.var("YSPACES").get()),">"));
            }
            //<< . . set YTABLEANZ = $get(YTABLEANZ)+1
            mVar YTABLEANZ = m$.var("YTABLEANZ");
            YTABLEANZ.set(mOp.Add(m$.Fnc.$get(m$.var("YTABLEANZ")),1));
            //<< . . write YCR,"</TD>"
            m$.Cmd.Write(m$.var("YCR").get(),"</TD>");
            //<< . . ;
            //<< . . write YCR,"<TD NOWRAP VALIGN="_YVAUS_" ALIGN="_YFAUS_">"
            m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<TD NOWRAP VALIGN=",m$.var("YVAUS").get())," ALIGN="),m$.var("YFAUS").get()),">"));
            //<< . . set YSPALTE=YSPALTE+1
            mVar YSPALTE = m$.var("YSPALTE");
            YSPALTE.set(mOp.Add(m$.var("YSPALTE").get(),1));
            //<< . . set YTDSET=1
            YTDSET.set(1);
          } while (false);
        }
      }
    }
    //<< 
    //<< ;------------------------------------------------------------------------
    //<< ; MINIMALLAENGE     Minimal Length
    //<< if +$piece(YVOR,Y,44)=2 do         ; "Format In Pixels"
    if (mOp.Equal(mOp.Positive(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),44)),2)) {
      //<< . new YTABB
      mVar YTABB = m$.var("YTABB");
      m$.newVar(YTABB);
      //<< . set YTABB=0
      YTABB.set(0);
      //<< . if (YSPAL=1) || (YNSPAL=1) do
      if ((mOp.Equal(m$.var("YSPAL").get(),1)) || (mOp.Equal(YNSPAL.get(),1))) {
        //<< . . write YCR,"<TABLE BORDER=0 CELLSPACING=0"_$$VORTABLESTYLE()_">" ;SESPE-474
        m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat("<TABLE BORDER=0 CELLSPACING=0",m$.fnc$("VORTABLESTYLE")),">"));
        //<< . . set YTABLEANZ = $get(YTABLEANZ)+1
        mVar YTABLEANZ = m$.var("YTABLEANZ");
        YTABLEANZ.set(mOp.Add(m$.Fnc.$get(m$.var("YTABLEANZ")),1));
        //<< . . ;
        //<< . . ;SR18027 write YCR,"<TR>",YCR,"<TD id='Help' " ;SR17261.1
        //<< . . ;SR18027 write YCR,"<TR>",YCR,"<TD id='"_strId_"' style='float:left; padding-top:3px; vertical-align:middle;' " ;SR17261.1 ;SR17725 ;SR18027 ;SRStandards
        //<< . . ;SR18129 write YCR,"<TR>",YCR,"<TD id='"_strId_"' " ;SR17261.1 ;SR17725 ;SR18027 ;SRStandards
        //<< . . write YCR,"<TR>",YCR,"<TD id='"_strId_"' style='float:left; padding-top:"_YPADDINGTOP_"; vertical-align:"_YVAUS_";' " ;SR17261.1 ;SR17725 ;SR18027 ;SRStandards ;SR18129
        m$.Cmd.Write(m$.var("YCR").get(),"<TR>",m$.var("YCR").get(),mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<TD id='",strId.get()),"' style='float:left; padding-top:"),m$.var("YPADDINGTOP").get()),"; vertical-align:"),m$.var("YVAUS").get()),";' "));
        //<< . . write YCR," onHelp='{ window.event.returnValue = false; window.event.cancelBubble = true; retval = EventValue("""_YUCI_""","""_YUSER_""","""_YFORM_""",""FIX"_$translate(YKEY,".","~")_""",""Y"_YFORM_YART_YLFN_""","" "",""3"",""NOVALUE"");}'"  ; SR17261 ;SR17853
        m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(" onHelp='{ window.event.returnValue = false; window.event.cancelBubble = true; retval = EventValue(\"",m$.var("YUCI").get()),"\",\""),m$.var("YUSER").get()),"\",\""),m$.var("YFORM").get()),"\",\"FIX"),m$.Fnc.$translate(m$.var("YKEY").get(),".","~")),"\",\"Y"),m$.var("YFORM").get()),m$.var("YART").get()),m$.var("YLFN").get()),"\",\" \",\"3\",\"NOVALUE\");}'"));
        //<< . . write " WIDTH="_YSPACES
        m$.Cmd.Write(mOp.Concat(" WIDTH=",m$.var("YSPACES").get()));
        //<< . . write " NOWRAP VALIGN="_YVAUS_" ALIGN="_YFAUS
        m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(" NOWRAP VALIGN=",m$.var("YVAUS").get())," ALIGN="),m$.var("YFAUS").get()));
        //<< . . write ">"
        m$.Cmd.Write(">");
        //<< . . set YZEIPO    = YZEIPO+1
        mVar YZEIPO = m$.var("YZEIPO");
        YZEIPO.set(mOp.Add(m$.var("YZEIPO").get(),1));
        //<< . . set YTDSET    = 1
        YTDSET.set(1);
        //<< . . set YTABB     = 1
        YTABB.set(1);
      }
      //<< . ;
      //<< . if YSPAL>YSPALTE for  quit:YSPAL=YSPALTE  do
      if (mOp.Greater(m$.var("YSPAL").get(),m$.var("YSPALTE").get())) {
        for (;true;) {
          if (mOp.Equal(m$.var("YSPAL").get(),m$.var("YSPALTE").get())) {
            break;
          }
          do {
            //<< . . if YNSPAL=0 if (YSPALTE+1)=YSPAL do  quit            ; FIXME : quit appears redundant
            if (mOp.Equal(YNSPAL.get(),0)) {
              if (mOp.Equal((mOp.Add(m$.var("YSPALTE").get(),1)),m$.var("YSPAL").get())) {
                //<< . . . ;SR18027 write YCR,"<TD id='Help' "  ;SR17261.1
                //<< . . . write YCR,"<TD id='"_strId_"' "  ;SR17261.1 ;SR18027
                m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat("<TD id='",strId.get()),"' "));
                //<< . . . write " style='padding-top:"_YPADDINGTOP_";'" ;SR18129
                m$.Cmd.Write(mOp.Concat(mOp.Concat(" style='padding-top:",m$.var("YPADDINGTOP").get()),";'"));
                //<< . . . write " WIDTH="_YSPACES
                m$.Cmd.Write(mOp.Concat(" WIDTH=",m$.var("YSPACES").get()));
                //<< . . . write YCR," onHelp='{ window.event.returnValue = false; window.event.cancelBubble = true; retval = EventValue("""_YUCI_""","""_YUSER_""","""_YFORM_""",""FIX"_$translate(YKEY,".","~")_""",""Y"_YFORM_YART_YLFN_""","" "",""3"",""NOVALUE"");}'"  ; SR17261
                m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(" onHelp='{ window.event.returnValue = false; window.event.cancelBubble = true; retval = EventValue(\"",m$.var("YUCI").get()),"\",\""),m$.var("YUSER").get()),"\",\""),m$.var("YFORM").get()),"\",\"FIX"),m$.Fnc.$translate(m$.var("YKEY").get(),".","~")),"\",\"Y"),m$.var("YFORM").get()),m$.var("YART").get()),m$.var("YLFN").get()),"\",\" \",\"3\",\"NOVALUE\");}'"));
                //<< . . . write " NOWRAP VALIGN="_YVAUS_" ALIGN="_YFAUS_">"
                m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(" NOWRAP VALIGN=",m$.var("YVAUS").get())," ALIGN="),m$.var("YFAUS").get()),">"));
                //<< . . . set YSPALTE = YSPAL
                mVar YSPALTE = m$.var("YSPALTE");
                YSPALTE.set(m$.var("YSPAL").get());
                //<< . . . set YTDSET  = 1
                YTDSET.set(1);
                break;
              }
            }
            //<< . . ;
            //<< . . if YSPALTE'=1 write YCR,"</TD><TD WIDTH="_YSPACES_">"
            if (mOp.NotEqual(m$.var("YSPALTE").get(),1)) {
              m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat("</TD><TD WIDTH=",m$.var("YSPACES").get()),">"));
            }
            //<< . . if YSPALTE=1  write:YTABB=1 YCR,"</TABLE>" write YCR,"<TABLE BORDER=0 CELLSPACING=0>",YCR,"<TR><TD WIDTH="_YSPACES_">"
            if (mOp.Equal(m$.var("YSPALTE").get(),1)) {
              if (mOp.Equal(YTABB.get(),1)) {
                m$.Cmd.Write(m$.var("YCR").get(),"</TABLE>");
              }
              m$.Cmd.Write(m$.var("YCR").get(),"<TABLE BORDER=0 CELLSPACING=0>",m$.var("YCR").get(),mOp.Concat(mOp.Concat("<TR><TD WIDTH=",m$.var("YSPACES").get()),">"));
            }
            //<< . . ; FIXME : YTABLEANZ not adjusted - conditional closing table - will we be closing new table appropriately
            //<< . . write YCR,"</TD>"
            m$.Cmd.Write(m$.var("YCR").get(),"</TD>");
            //<< . . ;
            //<< . . ;SR18027 write YCR,"<TD id='Help' WIDTH="_YSPACES_" NOWRAP VALIGN="_YVAUS_" ALIGN="_YFAUS ;SR17261.1
            //<< . . write YCR,"<TD id='"_strId_"' WIDTH="_YSPACES_" NOWRAP VALIGN="_YVAUS_" ALIGN="_YFAUS ;SR17261.1 ;SR18027
            m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<TD id='",strId.get()),"' WIDTH="),m$.var("YSPACES").get())," NOWRAP VALIGN="),m$.var("YVAUS").get())," ALIGN="),m$.var("YFAUS").get()));
            //<< . . write YCR," onHelp='{ window.event.returnValue = false; window.event.cancelBubble = true; retval = EventValue("""_YUCI_""","""_YUSER_""","""_YFORM_""",""FIX"_$translate(YKEY,".","~")_""",""Y"_YFORM_YART_YLFN_""","" "",""3"",""NOVALUE"");}'"  ; SR17261 ;SR17853
            m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(" onHelp='{ window.event.returnValue = false; window.event.cancelBubble = true; retval = EventValue(\"",m$.var("YUCI").get()),"\",\""),m$.var("YUSER").get()),"\",\""),m$.var("YFORM").get()),"\",\"FIX"),m$.Fnc.$translate(m$.var("YKEY").get(),".","~")),"\",\"Y"),m$.var("YFORM").get()),m$.var("YART").get()),m$.var("YLFN").get()),"\",\" \",\"3\",\"NOVALUE\");}'"));
            //<< . . write ">"                        ;SR17261
            m$.Cmd.Write(">");
            //<< . . set YSPALTE = YSPALTE+1
            mVar YSPALTE = m$.var("YSPALTE");
            YSPALTE.set(mOp.Add(m$.var("YSPALTE").get(),1));
            //<< . . set YTDSET  = 1
            YTDSET.set(1);
          } while (false);
        }
      }
    }
    //<< 
    //<< ; "Format In Pixels"
    //<< ;---------------------------------------
    //<< if +YTDSET=0 if +$piece(YVOR,Y,44)=2 write YCR,"<TR><TD NOWRAP VALIGN="_YVAUS_" ALIGN="_YFAUS_">"
    if (mOp.Equal(mOp.Positive(YTDSET.get()),0)) {
      if (mOp.Equal(mOp.Positive(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),44)),2)) {
        m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<TR><TD NOWRAP VALIGN=",m$.var("YVAUS").get())," ALIGN="),m$.var("YFAUS").get()),">"));
      }
    }
    //<< quit
    return;
  }

  //<< 
  //<< 
  //<< FRAGE
  public void FRAGE() {
    //<< ;--------------------------------------------------------------------------------
    //<< ; FORMAT FRAGE ; Format Caption
    //<< ;
    //<< ; History:
    //<< ; 19-Jun-2007   shobby  SRBR014547: Handle hyperlinked relations on COMTempList
    //<< ;                           for any class whose name starts with COMTempList
    //<< ;                           (ie COMTempListINCALLPROJ)
    //<< ; 21-Dec-2006   JW      SR14235: Rewrote sections. Added reference to child window
    //<< ; 18-Oct-2006   shobby  SRBR014296: If list is build from a COMTempList that is
    //<< ;                           a filtered or modified version of an existing class
    //<< ;                           still build the reference link if the form exists.
    //<< ;                           Requires that the 2nd key is the name of the form to
    //<< ;                           link to.  1st Key would normally be YUSER
    //<< ;  8-May-2006   JW      SR14508: Remove anchor when unecessary
    //<< ; 10-Nov-2005   JW      SR11904: Child user for popups
    //<< ;-------------------------------------------------------------------------------
    //<< $$$LogR2("FRAGE",YTYP_"<"_YFORM_YART_YLFN)
    $$$LogR2(m$,"FRAGE",mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(m$.var("YTYP").get(),"<"),m$.var("YFORM").get()),m$.var("YART").get()),m$.var("YLFN").get()));
    //<< 
    //<< quit:YTYP=0  ;=HIDDEN
    if (mOp.Equal(m$.var("YTYP").get(),0)) {
      return;
    }
    //<< 
    //<< new YLINK,blnSpan,strDesc
    mVar YLINK = m$.var("YLINK");
    mVar blnSpan = m$.var("blnSpan");
    mVar strDesc = m$.var("strDesc");
    m$.newVar(YLINK,blnSpan,strDesc);
    //<< 
    //<< set YLINK   = 0              ;KEIN LINK ;no
    YLINK.set(0);
    //<< set blnSpan = $$$NO
    blnSpan.set(include.COMSYS.$$$NO(m$));
    //<< 
    //<< ;------------------------------------------------------------------------; ZUSATZLINK BEI FELD FRAGE
    //<< 
    //<< // COMBOBOX-PARAMETER ;FIS;24872;06.01.04
    //<< //
    //<< // SR14235 - This looks like a really dodgy function.  A combobox that allows user entry as well.
    //<< // This link takes you to WWW101C - where you define user based options.
    //<< //
    //<< // This is currently ONLY used on the WWWOUT form.  Seriously, what's the point?
    //<< 
    //<< if $$$WWW122ComboboxFunction($get(YSATZ)) && ((YNAME'="") || (YNAME0'="")) && ($get(YPARA(1))="") {
    if (mOp.Logical(include.WWWConst.$$$WWW122ComboboxFunction(m$,m$.Fnc.$get(m$.var("YSATZ")))) && mOp.Logical(((mOp.NotEqual(m$.var("YNAME").get(),"")) || (mOp.NotEqual(m$.var("YNAME0").get(),"")))) && (mOp.Equal(m$.Fnc.$get(m$.var("YPARA").var(1)),""))) {
      //<< set YLINK   = 1
      YLINK.set(1);
      //<< set strDesc = $piece($get(^WWW120(0,"WWW101C",1)),Y,1)
      strDesc.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW120",0,"WWW101C",1)),m$.var("Y").get(),1));
      //<< if $data(^WWW1201(0,"WWW101C",SPRACHE,1)) {
      if (mOp.Logical(m$.Fnc.$data(m$.var("^WWW1201",0,"WWW101C",m$.var("SPRACHE").get(),1)))) {
        //<< set strDesc = $piece($get(^WWW1201(0,"WWW101C",SPRACHE,1)),Y,1)
        strDesc.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW1201",0,"WWW101C",m$.var("SPRACHE").get(),1)),m$.var("Y").get(),1));
      }
      //<< }
      //<< set strURL = $$FormURL^WWWCGI("WWW101C",YFORM_YART_YLFN,"&amp;YLOCKBACK="_YTRAKT,$$$YES)
      mVar strURL = m$.var("strURL");
      strURL.set(m$.fnc$("WWWCGI.FormURL","WWW101C",mOp.Concat(mOp.Concat(m$.var("YFORM").get(),m$.var("YART").get()),m$.var("YLFN").get()),mOp.Concat("&amp;YLOCKBACK=",m$.var("YTRAKT").get()),include.COMSYS.$$$YES(m$)));
      //<< 
      //<< write "<A href='' title="""_strDesc_""" onclick=""subWindow('"_strURL_"','TEILEFRAME2'); return false;"">"
      m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<A href='' title=\"",strDesc.get()),"\" onclick=\"subWindow('"),strURL.get()),"','TEILEFRAME2'); return false;\">"));
    }
    //<< }
    //<< 
    //<< if ((YNAME'="") || (YNAME0'="")) && ($get(YPARA(1))'="") do
    if (mOp.Logical(((mOp.NotEqual(m$.var("YNAME").get(),"")) || (mOp.NotEqual(m$.var("YNAME0").get(),"")))) && (mOp.NotEqual(m$.Fnc.$get(m$.var("YPARA").var(1)),""))) {
      do {
        //<< . new YYBACK
        mVar YYBACK = m$.var("YYBACK");
        m$.newVar(YYBACK);
        //<< . ;
        //<< . if $extract(YPARA(1),1,11)="COMTempList" do
        if (mOp.Equal(m$.Fnc.$extract(m$.var("YPARA").var(1).get(),1,11),"COMTempList")) {
          //<< . . set YPARA(1) = $piece(YPARA(2),"""",2)
          mVar YPARA = m$.var("YPARA");
          YPARA.var(1).set(m$.Fnc.$piece(m$.var("YPARA").var(2).get(),"\"",2));
          //<< . . if YPARA(1)'="" if $data(^WWW120(0,YPARA(1))) set YPARA(2) = """"
          if (mOp.NotEqual(YPARA.var(1).get(),"")) {
            if (mOp.Logical(m$.Fnc.$data(m$.var("^WWW120",0,YPARA.var(1).get())))) {
              YPARA.var(2).set("\"");
            }
          }
        }
        //<< . ;
        //<< . // Don't add hyperlink if relation class has >1 key
        //<< . if $extract(YPARA(2))'="""" if '$find(YPARA(1),"PARA") if YPARA(1)'=YFORM quit:$data(^WWW002(0,YPARA(1),2))  quit:'$data(^WWW120(0,YPARA(1)))  ;2 KEY FÜR ALLE;11.11.2003 ;KEY to
        if (mOp.NotEqual(m$.Fnc.$extract(m$.var("YPARA").var(2).get()),"\"")) {
          if (mOp.Not(m$.Fnc.$find(m$.var("YPARA").var(1).get(),"PARA"))) {
            if (mOp.NotEqual(m$.var("YPARA").var(1).get(),m$.var("YFORM").get())) {
              if (mOp.Logical(m$.Fnc.$data(m$.var("^WWW002",0,m$.var("YPARA").var(1).get(),2)))) {
                break;
              }
              if (mOp.Not(m$.Fnc.$data(m$.var("^WWW120",0,m$.var("YPARA").var(1).get())))) {
                break;
              }
            }
          }
        }
        //<< . ;
        //<< . quit:$extract(YPARA(2),2,8)="JA/NEIN"
        if (mOp.Equal(m$.Fnc.$extract(m$.var("YPARA").var(2).get(),2,8),"JA/NEIN")) {
          break;
        }
        //<< . quit:YPARA(1)="WWW100"
        if (mOp.Equal(m$.var("YPARA").var(1).get(),"WWW100")) {
          break;
        }
        //<< . if '$data(^WWW120(0,YPARA(1),1)) quit:$$^WWWACCESS($piece($get(^WWW001(0,YPARA(1),1)),Y,2),$piece($get(^WWW001(0,YPARA(1),1)),Y,5))'=1     ;WENN FORMULAR ;when form
        if (mOp.Not(m$.Fnc.$data(m$.var("^WWW120",0,m$.var("YPARA").var(1).get(),1)))) {
          if (mOp.NotEqual(m$.fnc$("WWWACCESS.main",m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW001",0,m$.var("YPARA").var(1).get(),1)),m$.var("Y").get(),2),m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW001",0,m$.var("YPARA").var(1).get(),1)),m$.var("Y").get(),5)),1)) {
            break;
          }
        }
        //<< . if $data(^WWW120(0,YPARA(1),1))  quit:$$^WWWACCESS($piece($get(^WWW120(0,YPARA(1),1)),Y,22),$piece($get(^WWW120(0,YPARA(1),1)),Y,24))'=1   ;WENN KEIN FORMULAR ;when no form
        if (mOp.Logical(m$.Fnc.$data(m$.var("^WWW120",0,m$.var("YPARA").var(1).get(),1)))) {
          if (mOp.NotEqual(m$.fnc$("WWWACCESS.main",m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW120",0,m$.var("YPARA").var(1).get(),1)),m$.var("Y").get(),22),m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW120",0,m$.var("YPARA").var(1).get(),1)),m$.var("Y").get(),24)),1)) {
            break;
          }
        }
        //<< . if $get(YBER)'=1 if $get(YBER)'="" quit:YPARA(1)="WWW101"  ;SYSTEMPARAMETER
        if (mOp.NotEqual(m$.Fnc.$get(m$.var("YBER")),1)) {
          if (mOp.NotEqual(m$.Fnc.$get(m$.var("YBER")),"")) {
            if (mOp.Equal(m$.var("YPARA").var(1).get(),"WWW101")) {
              break;
            }
          }
        }
        //<< . ;
        //<< . set YYBACK = YBACK
        YYBACK.set(m$.var("YBACK").get());
        //<< . new YI,YQ,YFKEY,YKEY,YBACK
        mVar YI = m$.var("YI");
        mVar YQ = m$.var("YQ");
        mVar YFKEY = m$.var("YFKEY");
        mVar YKEY = m$.var("YKEY");
        mVar YBACK = m$.var("YBACK");
        m$.newVar(YI,YQ,YFKEY,YKEY,YBACK);
        //<< . set YBACK = ""  ;KEIN ZURÜCK WEIL KEY NICHT BRAUCHBAR BEI ZURÜCK; S YBACK=YYBACK_YFORM_","
        YBACK.set("");
        //<< . set YFKEY = ""
        YFKEY.set("");
        //<< . set YQ    = 0
        YQ.set(0);
        //<< . set YI    = ""
        YI.set("");
        //<< . if $data(^WWW120(0,YPARA(1),1)) set YI = YPARA(1)
        if (mOp.Logical(m$.Fnc.$data(m$.var("^WWW120",0,m$.var("YPARA").var(1).get(),1)))) {
          YI.set(m$.var("YPARA").var(1).get());
        }
        //<< //. do:YI'=""  if YQ=0 set YI="" for  set YI = $order(^WWW120s(0,1,$$^WWWUMLAU(YPARA(1),1),YI)) quit:YI=""  do  quit:YQ=1
        //<< . do:YI'=""
        if (mOp.NotEqual(YI.get(),"")) {
          do {
            //<< . . if ($piece($get(^WWW120(0,YI,1)),Y,2)=3) || ($piece($get(^WWW120(0,YI,1)),Y,2)=1) do     ; (YFOART) Grid or Standard form
            if ((mOp.Equal(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW120",0,YI.get(),1)),m$.var("Y").get(),2),3)) || (mOp.Equal(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW120",0,YI.get(),1)),m$.var("Y").get(),2),1))) {
              //<< . . . set YQ=1
              YQ.set(1);
              //<< . . . set YLINK=1  ;LINK VORHANDEN ;on hand
              YLINK.set(1);
              //<< . . . write YCR,"<A"
              m$.Cmd.Write(m$.var("YCR").get(),"<A");
              //<< . . . new PARAN,strURL
              mVar PARAN = m$.var("PARAN");
              mVar strURL = m$.var("strURL");
              m$.newVar(PARAN,strURL);
              //<< . . . ;
              //<< . . . set PARAN=$piece($get(^WWW001(0,YPARA(1),1)),Y,1)    ; objClass
              PARAN.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW001",0,m$.var("YPARA").var(1).get(),1)),m$.var("Y").get(),1));
              //<< . . . if $data(^WWW0011(0,YPARA(1),SPRACHE,1)) set PARAN=$piece($get(^WWW0011(0,YPARA(1),SPRACHE,1)),Y,1)
              if (mOp.Logical(m$.Fnc.$data(m$.var("^WWW0011",0,m$.var("YPARA").var(1).get(),m$.var("SPRACHE").get(),1)))) {
                PARAN.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW0011",0,m$.var("YPARA").var(1).get(),m$.var("SPRACHE").get(),1)),m$.var("Y").get(),1));
              }
              //<< . . . do
              do {
                //<< . . . . write " TITLE="""_PARAN       ; FIXME : "DE"
                m$.Cmd.Write(mOp.Concat(" TITLE=\"",PARAN.get()));
                //<< . . . . if $$^WWWACCESS(1)=1 if $get(SPRACHE)="DE" if YPARA(2)'="" write " -"_$translate($piece(YPARA(2),",",1),"""")_"- "
                if (mOp.Equal(m$.fnc$("WWWACCESS.main",1),1)) {
                  if (mOp.Equal(m$.Fnc.$get(m$.var("SPRACHE")),"DE")) {
                    if (mOp.NotEqual(m$.var("YPARA").var(2).get(),"")) {
                      m$.Cmd.Write(mOp.Concat(mOp.Concat(" -",m$.Fnc.$translate(m$.Fnc.$piece(m$.var("YPARA").var(2).get(),",",1),"\"")),"- "));
                    }
                  }
                }
                //<< . . . . write """"   ;PARAMETER BEARBEITEN
                m$.Cmd.Write("\"");
              } while(false);
              //<< . . . ;
              //<< . . . for YI(1)=1:1 quit:$piece(YPARA(2),",",YI(1))=""  do
              for (m$.var("YI",1).set(1);(true);m$.var("YI",1).set(mOp.Add(m$.var("YI",1).get(),1))) {
                if (mOp.Equal(m$.Fnc.$piece(m$.var("YPARA").var(2).get(),",",YI.var(1).get()),"")) {
                  break;
                }
                //<< . . . . set YI(2)=$piece(YPARA(2),",",YI(1))
                YI.var(2).set(m$.Fnc.$piece(m$.var("YPARA").var(2).get(),",",YI.var(1).get()));
                //<< . . . . if YFKEY'=""             set YFKEY = YFKEY_","
                if (mOp.NotEqual(YFKEY.get(),"")) {
                  YFKEY.set(mOp.Concat(YFKEY.get(),","));
                }
                //<< . . . . if $extract(YI(2))=""""  set YFKEY = YFKEY_$translate(YI(2),"""")
                if (mOp.Equal(m$.Fnc.$extract(YI.var(2).get()),"\"")) {
                  YFKEY.set(mOp.Concat(YFKEY.get(),m$.Fnc.$translate(YI.var(2).get(),"\"")));
                }
                //<< . . . . if $extract(YI(2))'="""" set YFKEY = YFKEY_$get(@YI(2))
                if (mOp.NotEqual(m$.Fnc.$extract(YI.var(2).get()),"\"")) {
                  YFKEY.set(mOp.Concat(YFKEY.get(),m$.Fnc.$get(m$.indirectVar(YI.var(2).get()))));
                }
              }
              //<< . . . ;
              //<< . . . if YFKEY="" if YINHALT'="" set YFKEY = YINHALT
              if (mOp.Equal(YFKEY.get(),"")) {
                if (mOp.NotEqual(m$.var("YINHALT").get(),"")) {
                  YFKEY.set(m$.var("YINHALT").get());
                }
              }
              //<< . . . set strURL = $$FormURL^WWWCGI(YI,YFKEY,"&amp;YLOCKBACK="_YTRAKT,$$$YES)
              strURL.set(m$.fnc$("WWWCGI.FormURL",YI.get(),YFKEY.get(),mOp.Concat("&amp;YLOCKBACK=",m$.var("YTRAKT").get()),include.COMSYS.$$$YES(m$)));
              //<< . . . write " href='' onclick=""subWindow('"_strURL_"','TEILEFRAME2'); return false;"">"
              m$.Cmd.Write(mOp.Concat(mOp.Concat(" href='' onclick=\"subWindow('",strURL.get()),"','TEILEFRAME2'); return false;\">"));
            }
          } while(false);
          //<< . if YQ=0 set YI="" for  set YI = $order(^WWW120s(0,1,$$^WWWUMLAU(YPARA(1),1),YI)) quit:YI=""  do  quit:YQ=1
          if (mOp.Equal(YQ.get(),0)) {
            YI.set("");
            for (;true;) {
              YI.set(m$.Fnc.$order(m$.var("^WWW120s",0,1,m$.fnc$("WWWUMLAU.main",m$.var("YPARA").var(1).get(),1),YI.get())));
              if (mOp.Equal(YI.get(),"")) {
                break;
              }
              //<< . . if ($piece($get(^WWW120(0,YI,1)),Y,2)=3) || ($piece($get(^WWW120(0,YI,1)),Y,2)=1) do     ; (YFOART) Grid or Standard form
              if ((mOp.Equal(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW120",0,YI.get(),1)),m$.var("Y").get(),2),3)) || (mOp.Equal(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW120",0,YI.get(),1)),m$.var("Y").get(),2),1))) {
                //<< . . . set YQ=1
                YQ.set(1);
                //<< . . . set YLINK=1  ;LINK VORHANDEN ;on hand
                YLINK.set(1);
                //<< . . . write YCR,"<A"
                m$.Cmd.Write(m$.var("YCR").get(),"<A");
                //<< . . . new PARAN,strURL
                mVar PARAN = m$.var("PARAN");
                mVar strURL = m$.var("strURL");
                m$.newVar(PARAN,strURL);
                //<< . . . ;
                //<< . . . set PARAN=$piece($get(^WWW001(0,YPARA(1),1)),Y,1)    ; objClass
                PARAN.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW001",0,m$.var("YPARA").var(1).get(),1)),m$.var("Y").get(),1));
                //<< . . . if $data(^WWW0011(0,YPARA(1),SPRACHE,1)) set PARAN=$piece($get(^WWW0011(0,YPARA(1),SPRACHE,1)),Y,1)
                if (mOp.Logical(m$.Fnc.$data(m$.var("^WWW0011",0,m$.var("YPARA").var(1).get(),m$.var("SPRACHE").get(),1)))) {
                  PARAN.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW0011",0,m$.var("YPARA").var(1).get(),m$.var("SPRACHE").get(),1)),m$.var("Y").get(),1));
                }
                //<< . . . do
                do {
                  //<< . . . . write " TITLE="""_PARAN       ; FIXME : "DE"
                  m$.Cmd.Write(mOp.Concat(" TITLE=\"",PARAN.get()));
                  //<< . . . . if $$^WWWACCESS(1)=1 if $get(SPRACHE)="DE" if YPARA(2)'="" write " -"_$translate($piece(YPARA(2),",",1),"""")_"- "
                  if (mOp.Equal(m$.fnc$("WWWACCESS.main",1),1)) {
                    if (mOp.Equal(m$.Fnc.$get(m$.var("SPRACHE")),"DE")) {
                      if (mOp.NotEqual(m$.var("YPARA").var(2).get(),"")) {
                        m$.Cmd.Write(mOp.Concat(mOp.Concat(" -",m$.Fnc.$translate(m$.Fnc.$piece(m$.var("YPARA").var(2).get(),",",1),"\"")),"- "));
                      }
                    }
                  }
                  //<< . . . . write """"   ;PARAMETER BEARBEITEN
                  m$.Cmd.Write("\"");
                } while(false);
                //<< . . . ;
                //<< . . . for YI(1)=1:1 quit:$piece(YPARA(2),",",YI(1))=""  do
                for (m$.var("YI",1).set(1);(true);m$.var("YI",1).set(mOp.Add(m$.var("YI",1).get(),1))) {
                  if (mOp.Equal(m$.Fnc.$piece(m$.var("YPARA").var(2).get(),",",YI.var(1).get()),"")) {
                    break;
                  }
                  //<< . . . . set YI(2)=$piece(YPARA(2),",",YI(1))
                  YI.var(2).set(m$.Fnc.$piece(m$.var("YPARA").var(2).get(),",",YI.var(1).get()));
                  //<< . . . . if YFKEY'=""             set YFKEY = YFKEY_","
                  if (mOp.NotEqual(YFKEY.get(),"")) {
                    YFKEY.set(mOp.Concat(YFKEY.get(),","));
                  }
                  //<< . . . . if $extract(YI(2))=""""  set YFKEY = YFKEY_$translate(YI(2),"""")
                  if (mOp.Equal(m$.Fnc.$extract(YI.var(2).get()),"\"")) {
                    YFKEY.set(mOp.Concat(YFKEY.get(),m$.Fnc.$translate(YI.var(2).get(),"\"")));
                  }
                  //<< . . . . if $extract(YI(2))'="""" set YFKEY = YFKEY_$get(@YI(2))
                  if (mOp.NotEqual(m$.Fnc.$extract(YI.var(2).get()),"\"")) {
                    YFKEY.set(mOp.Concat(YFKEY.get(),m$.Fnc.$get(m$.indirectVar(YI.var(2).get()))));
                  }
                }
                //<< . . . ;
                //<< . . . if YFKEY="" if YINHALT'="" set YFKEY = YINHALT
                if (mOp.Equal(YFKEY.get(),"")) {
                  if (mOp.NotEqual(m$.var("YINHALT").get(),"")) {
                    YFKEY.set(m$.var("YINHALT").get());
                  }
                }
                //<< . . . set strURL = $$FormURL^WWWCGI(YI,YFKEY,"&amp;YLOCKBACK="_YTRAKT,$$$YES)
                strURL.set(m$.fnc$("WWWCGI.FormURL",YI.get(),YFKEY.get(),mOp.Concat("&amp;YLOCKBACK=",m$.var("YTRAKT").get()),include.COMSYS.$$$YES(m$)));
                //<< . . . write " href='' onclick=""subWindow('"_strURL_"','TEILEFRAME2'); return false;"">"
                m$.Cmd.Write(mOp.Concat(mOp.Concat(" href='' onclick=\"subWindow('",strURL.get()),"','TEILEFRAME2'); return false;\">"));
              }
              if (mOp.Equal(YQ.get(),1)) {
                break;
              }
            }
          }
        }
      } while (false);
    }
    //<< 
    //<< ;------------------------------------------------------------------------
    //<< if (YNAME'="") || (YNAME0'="") if $extract(YPARA(2))'="""" if $translate(YSTATUS," ")'="" if YLINK'=1 do
    if ((mOp.NotEqual(m$.var("YNAME").get(),"")) || (mOp.NotEqual(m$.var("YNAME0").get(),""))) {
      if (mOp.NotEqual(m$.Fnc.$extract(m$.var("YPARA").var(2).get()),"\"")) {
        if (mOp.NotEqual(m$.Fnc.$translate(m$.var("YSTATUS").get()," "),"")) {
          if (mOp.NotEqual(YLINK.get(),1)) {
            //<< . write YCR,"<SPAN"
            m$.Cmd.Write(m$.var("YCR").get(),"<SPAN");
            //<< . write " TITLE="""_YSTATUS_""""   ;TOOL-TIP FÜR TEXTFELD ;to
            m$.Cmd.Write(mOp.Concat(mOp.Concat(" TITLE=\"",m$.var("YSTATUS").get()),"\""));
            //<< . write YCR,">"
            m$.Cmd.Write(m$.var("YCR").get(),">");
            //<< . set blnSpan = $$$YES
            blnSpan.set(include.COMSYS.$$$YES(m$));
          }
        }
      }
    }
    //<< 
    //<< ;------------------------------------------------------------------------ ;format und farben
    //<< set YSPALTE = YSPAL
    mVar YSPALTE = m$.var("YSPALTE");
    YSPALTE.set(m$.var("YSPAL").get());
    //<< if YART="P" if $piece($get(YVOR1),Y,95)=1 write YCR,"<STRONG><B>"
    if (mOp.Equal(m$.var("YART").get(),"P")) {
      if (mOp.Equal(m$.Fnc.$piece(m$.Fnc.$get(m$.var("YVOR1")),m$.var("Y").get(),95),1)) {
        m$.Cmd.Write(m$.var("YCR").get(),"<STRONG><B>");
      }
    }
    //<< if (YNAME'="") || (YNAME0'="") if (YART="P") || (YART="D") || (YART="M") if +$piece(YSATZ,Y,10)=0 do
    if ((mOp.NotEqual(m$.var("YNAME").get(),"")) || (mOp.NotEqual(m$.var("YNAME0").get(),""))) {
      if ((mOp.Equal(m$.var("YART").get(),"P")) || (mOp.Equal(m$.var("YART").get(),"D")) || (mOp.Equal(m$.var("YART").get(),"M"))) {
        if (mOp.Equal(mOp.Positive(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),10)),0)) {
          do {
            //<< . quit:+$piece(YVOR,Y,8)=0
            if (mOp.Equal(mOp.Positive(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),8)),0)) {
              break;
            }
            //<< . if $find($piece(YVOR,Y,8),1) write YCR,"<STRONG><B>"
            if (mOp.Logical(m$.Fnc.$find(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),8),1))) {
              m$.Cmd.Write(m$.var("YCR").get(),"<STRONG><B>");
            }
            //<< . if $find($piece(YVOR,Y,8),2) write YCR,"<U>"
            if (mOp.Logical(m$.Fnc.$find(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),8),2))) {
              m$.Cmd.Write(m$.var("YCR").get(),"<U>");
            }
            //<< . if $find($piece(YVOR,Y,8),3) write YCR,"<I>"
            if (mOp.Logical(m$.Fnc.$find(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),8),3))) {
              m$.Cmd.Write(m$.var("YCR").get(),"<I>");
            }
            //<< . if $find($piece(YVOR,Y,8),4) write YCR,"<STRIKE>"
            if (mOp.Logical(m$.Fnc.$find(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),8),4))) {
              m$.Cmd.Write(m$.var("YCR").get(),"<STRIKE>");
            }
            //<< . if $find($piece(YVOR,Y,8),5) write YCR,"<BLINK>"
            if (mOp.Logical(m$.Fnc.$find(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),8),5))) {
              m$.Cmd.Write(m$.var("YCR").get(),"<BLINK>");
            }
            //<< . if $find($piece(YVOR,Y,8),6) write YCR,"<MARQUEE>"
            if (mOp.Logical(m$.Fnc.$find(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),8),6))) {
              m$.Cmd.Write(m$.var("YCR").get(),"<MARQUEE>");
            }
          } while (false);
        }
      }
    }
    //<< 
    //<< if (YNAME'="") || (YNAME0'="") write YCR,"<FONT SIZE="""_$piece(YVOR,Y,7)_""">"
    if ((mOp.NotEqual(m$.var("YNAME").get(),"")) || (mOp.NotEqual(m$.var("YNAME0").get(),""))) {
      m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat("<FONT SIZE=\"",m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),7)),"\">"));
    }
    //<< ;------------------------------------------------------------------------
    //<< if (YNAME'="") || (YNAME0'="") if (YART="P") || (YART="D") || (YART="M") if (+$piece(YSATZ,Y,8)'=0) || (+$piece(YSATZ,Y,9)'=0) || (+$piece(YSATZ,Y,11)'=0) do
    if ((mOp.NotEqual(m$.var("YNAME").get(),"")) || (mOp.NotEqual(m$.var("YNAME0").get(),""))) {
      if ((mOp.Equal(m$.var("YART").get(),"P")) || (mOp.Equal(m$.var("YART").get(),"D")) || (mOp.Equal(m$.var("YART").get(),"M"))) {
        if ((mOp.NotEqual(mOp.Positive(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),8)),0)) || (mOp.NotEqual(mOp.Positive(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),9)),0)) || (mOp.NotEqual(mOp.Positive(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),11)),0))) {
          //<< . if $piece(YSATZ,Y,11)'="" write "<FONT FACE="""_$piece($get(^WWW100(0,"SCHRIFTART",SPRACHE,$piece(YSATZ,Y,11),1)),Y,1)_""">"
          if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),11),"")) {
            m$.Cmd.Write(mOp.Concat(mOp.Concat("<FONT FACE=\"",m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW100",0,"SCHRIFTART",m$.var("SPRACHE").get(),m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),11),1)),m$.var("Y").get(),1)),"\">"));
          }
          //<< . if $piece(YSATZ,Y,9)'=""  write "<FONT SIZE="""_$piece(YSATZ,Y,9)_""">"
          if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),9),"")) {
            m$.Cmd.Write(mOp.Concat(mOp.Concat("<FONT SIZE=\"",m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),9)),"\">"));
          }
          //<< . if $piece(YSATZ,Y,8)'=""  do
          if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),8),"")) {
            do {
              //<< . . if (YXTYP=3) || (YTYP=2) if YINHALT'=1 set YINHALT=""   ;TYBD; WENN CHECK UND ROT;TYBD;16,12,2003
              if ((mOp.Equal(m$.var("YXTYP").get(),3)) || (mOp.Equal(m$.var("YTYP").get(),2))) {
                if (mOp.NotEqual(m$.var("YINHALT").get(),1)) {
                  mVar YINHALT = m$.var("YINHALT");
                  YINHALT.set("");
                }
              }
              //<< . . if $piece(YSATZ,Y,8)=114 if YINHALT'="" quit        ;NICHT IN ROT, WENN INHALT VORHANDEN (114=RED)
              if (mOp.Equal(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),8),114)) {
                if (mOp.NotEqual(m$.var("YINHALT").get(),"")) {
                  break;
                }
              }
              //<< . . if $piece(YSATZ,Y,8)=101 if YINHALT'="" quit        ;NICHT IN ROT, WENN INHALT VORHANDEN (101=ORANGERED)
              if (mOp.Equal(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),8),101)) {
                if (mOp.NotEqual(m$.var("YINHALT").get(),"")) {
                  break;
                }
              }
              //<< . . write YCR,"<FONT"
              m$.Cmd.Write(m$.var("YCR").get(),"<FONT");
              //<< . . write " COLOR="""_$piece($get(^WWW100(0,"FARBE",SPRACHE,$piece(YSATZ,Y,8),1)),Y,1)_""""
              m$.Cmd.Write(mOp.Concat(mOp.Concat(" COLOR=\"",m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW100",0,"FARBE",m$.var("SPRACHE").get(),m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),8),1)),m$.var("Y").get(),1)),"\""));
              //<< . . write ">"
              m$.Cmd.Write(">");
            } while (false);
          }
        }
      }
    }
    //<< 
    //<< ;------------------------------------------------------------------------
    //<< if (YNAME'="") || (YNAME0'="") if (YART="P") || (YART="D") || (YART="M") if +$piece(YSATZ,Y,10)'=0 do
    if ((mOp.NotEqual(m$.var("YNAME").get(),"")) || (mOp.NotEqual(m$.var("YNAME0").get(),""))) {
      if ((mOp.Equal(m$.var("YART").get(),"P")) || (mOp.Equal(m$.var("YART").get(),"D")) || (mOp.Equal(m$.var("YART").get(),"M"))) {
        if (mOp.NotEqual(mOp.Positive(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),10)),0)) {
          //<< . if $find($piece(YSATZ,Y,10),1) write YCR,"<STRONG><B>"
          if (mOp.Logical(m$.Fnc.$find(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),10),1))) {
            m$.Cmd.Write(m$.var("YCR").get(),"<STRONG><B>");
          }
          //<< . if $find($piece(YSATZ,Y,10),2) write YCR,"<U>"
          if (mOp.Logical(m$.Fnc.$find(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),10),2))) {
            m$.Cmd.Write(m$.var("YCR").get(),"<U>");
          }
          //<< . if $find($piece(YSATZ,Y,10),3) write YCR,"<I>"
          if (mOp.Logical(m$.Fnc.$find(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),10),3))) {
            m$.Cmd.Write(m$.var("YCR").get(),"<I>");
          }
          //<< . if $find($piece(YSATZ,Y,10),4) write YCR,"<STRIKE>"
          if (mOp.Logical(m$.Fnc.$find(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),10),4))) {
            m$.Cmd.Write(m$.var("YCR").get(),"<STRIKE>");
          }
          //<< . if $find($piece(YSATZ,Y,10),5) write YCR,"<BLINK>"
          if (mOp.Logical(m$.Fnc.$find(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),10),5))) {
            m$.Cmd.Write(m$.var("YCR").get(),"<BLINK>");
          }
          //<< . if $find($piece(YSATZ,Y,10),6) write YCR,"<MARQUEE>"
          if (mOp.Logical(m$.Fnc.$find(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),10),6))) {
            m$.Cmd.Write(m$.var("YCR").get(),"<MARQUEE>");
          }
        }
      }
    }
    //<< 
    //<< ;------------------------------------------------------------------------
    //<< set YSPACE=""
    mVar YSPACE = m$.var("YSPACE");
    YSPACE.set("");
    //<< if (YNAME'="") || (YNAME0'="") if +YSPACES=0 for YI=1:1:+$piece(YSATZ,Y,7) set YSPACE=YSPACE_"&nbsp;"  ;mehr spaces WENN NICHT FESTE LÄNGE
    if ((mOp.NotEqual(m$.var("YNAME").get(),"")) || (mOp.NotEqual(m$.var("YNAME0").get(),""))) {
      if (mOp.Equal(mOp.Positive(m$.var("YSPACES").get()),0)) {
        mVar YI = m$.var("YI");
        for (YI.set(1);(mOp.LessOrEqual(YI.get(),mOp.Positive(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),7))));YI.set(mOp.Add(YI.get(),1))) {
          YSPACE.set(mOp.Concat(YSPACE.get(),"&nbsp;"));
        }
      }
    }
    //<< if $translate(YSTATUS," ")="" set YSTATUS=$translate(YNAME,"()><.;'""")  ;STATUSANZEIGE
    if (mOp.Equal(m$.Fnc.$translate(m$.var("YSTATUS").get()," "),"")) {
      mVar YSTATUS = m$.var("YSTATUS");
      YSTATUS.set(m$.Fnc.$translate(m$.var("YNAME").get(),"()><.;'\""));
    }
    //<< 
    //<< if YFORM'="" if YBBN'="" if YM'="" if (YART="M") || (YART="D") do
    if (mOp.NotEqual(m$.var("YFORM").get(),"")) {
      if (mOp.NotEqual(m$.var("YBBN").get(),"")) {
        if (mOp.NotEqual(m$.var("YM").get(),"")) {
          if ((mOp.Equal(m$.var("YART").get(),"M")) || (mOp.Equal(m$.var("YART").get(),"D"))) {
            //<< . if $piece($get(^WWW122D(0,YFORM,YBBN,YM,1)),Y,6)'=""          set YNAME=$piece($get(^WWW122D(0,YFORM,YBBN,YM,1)),Y,6)           ;MANUELLER FELDNAME
            if (mOp.NotEqual(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW122D",0,m$.var("YFORM").get(),m$.var("YBBN").get(),m$.var("YM").get(),1)),m$.var("Y").get(),6),"")) {
              mVar YNAME = m$.var("YNAME");
              YNAME.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW122D",0,m$.var("YFORM").get(),m$.var("YBBN").get(),m$.var("YM").get(),1)),m$.var("Y").get(),6));
            }
            //<< . if $piece($get(^WWW122D1(0,YFORM,YBBN,YM,SPRACHE,1)),Y,1)'="" set YNAME=$piece($get(^WWW122D1(0,YFORM,YBBN,YM,SPRACHE,1)),Y,1)  ;CUSTOMIZING SPRACHE;TYBD;20,5,2004
            if (mOp.NotEqual(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW122D1",0,m$.var("YFORM").get(),m$.var("YBBN").get(),m$.var("YM").get(),m$.var("SPRACHE").get(),1)),m$.var("Y").get(),1),"")) {
              mVar YNAME = m$.var("YNAME");
              YNAME.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW122D1",0,m$.var("YFORM").get(),m$.var("YBBN").get(),m$.var("YM").get(),m$.var("SPRACHE").get(),1)),m$.var("Y").get(),1));
            }
          }
        }
      }
    }
    //<< 
    //<< if YFORM'="" if YBBN'="" if YM'="" if YART="P" do
    if (mOp.NotEqual(m$.var("YFORM").get(),"")) {
      if (mOp.NotEqual(m$.var("YBBN").get(),"")) {
        if (mOp.NotEqual(m$.var("YM").get(),"")) {
          if (mOp.Equal(m$.var("YART").get(),"P")) {
            //<< . if $piece($get(^WWW121D(0,YFORM,YBBN,YM,1)),Y,6)'=""          set YNAME=$piece($get(^WWW121D(0,YFORM,YBBN,YM,1)),Y,6)           ;MANUELLER FELDNAME
            if (mOp.NotEqual(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW121D",0,m$.var("YFORM").get(),m$.var("YBBN").get(),m$.var("YM").get(),1)),m$.var("Y").get(),6),"")) {
              mVar YNAME = m$.var("YNAME");
              YNAME.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW121D",0,m$.var("YFORM").get(),m$.var("YBBN").get(),m$.var("YM").get(),1)),m$.var("Y").get(),6));
            }
            //<< . if $piece($get(^WWW121D1(0,YFORM,YBBN,YM,SPRACHE,1)),Y,1)'="" set YNAME=$piece($get(^WWW121D1(0,YFORM,YBBN,YM,SPRACHE,1)),Y,1)  ;CUSTOMIZING SPRACHE;TYBD;20,5,2004
            if (mOp.NotEqual(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW121D1",0,m$.var("YFORM").get(),m$.var("YBBN").get(),m$.var("YM").get(),m$.var("SPRACHE").get(),1)),m$.var("Y").get(),1),"")) {
              mVar YNAME = m$.var("YNAME");
              YNAME.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW121D1",0,m$.var("YFORM").get(),m$.var("YBBN").get(),m$.var("YM").get(),m$.var("SPRACHE").get(),1)),m$.var("Y").get(),1));
            }
          }
        }
      }
    }
    //<< 
    //<< if +$piece(YVOR,Y,19)'=0 set YNAME=$extract(YNAME,1,$piece(YVOR,1,19))   ;längenbeschränkung
    if (mOp.NotEqual(mOp.Positive(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),19)),0)) {
      mVar YNAME = m$.var("YNAME");
      YNAME.set(m$.Fnc.$extract(m$.var("YNAME").get(),1,m$.Fnc.$piece(m$.var("YVOR").get(),1,19)));
    }
    //<< 
    //<< ; Other than Grid Forms
    //<< ;---------------------------------------
    //<< if YFOART1'=3 do
    if (mOp.NotEqual(m$.var("YFOART1").get(),3)) {
      //<< . if $piece(YVOR,Y,36)'=3 do   ;AUSRICHTUNG NICHT RECHTS ;Not on the right
      if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),36),3)) {
        //<< . . for  quit:$extract($reverse(YNAME))'=" "  set YNAME = $reverse($extract($reverse(YNAME),2,99))  ; FIXME : use $zcvt instead
        for (;true;) {
          if (mOp.NotEqual(m$.Fnc.$extract(m$.Fnc.$reverse(m$.var("YNAME").get()))," ")) {
            break;
          }
          mVar YNAME = m$.var("YNAME");
          YNAME.set(m$.Fnc.$reverse(m$.Fnc.$extract(m$.Fnc.$reverse(m$.var("YNAME").get()),2,99)));
        }
        //<< . . set YNAME = YSPACE_YNAME  ;LEERZEILEN VORNE
        mVar YNAME = m$.var("YNAME");
        YNAME.set(mOp.Concat(YSPACE.get(),m$.var("YNAME").get()));
      }
      //<< . ;
      //<< . ;SR17514
      //<< . if $piece(YVOR,Y,36)=3 do   ;AUSRICHTUNG RECHTS ;on the right
      if (mOp.Equal(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),36),3)) {
        //<< . . for  quit:$extract($reverse(YNAME))'=" "  set YNAME = $reverse($extract($reverse(YNAME),2,99))  ; FIXME : use $zcvt instead
        for (;true;) {
          if (mOp.NotEqual(m$.Fnc.$extract(m$.Fnc.$reverse(m$.var("YNAME").get()))," ")) {
            break;
          }
          mVar YNAME = m$.var("YNAME");
          YNAME.set(m$.Fnc.$reverse(m$.Fnc.$extract(m$.Fnc.$reverse(m$.var("YNAME").get()),2,99)));
        }
        //<< . . for  quit:$extract(YNAME)'=" "            set YNAME = $extract(YNAME,2,99)
        for (;true;) {
          if (mOp.NotEqual(m$.Fnc.$extract(m$.var("YNAME").get())," ")) {
            break;
          }
          mVar YNAME = m$.var("YNAME");
          YNAME.set(m$.Fnc.$extract(m$.var("YNAME").get(),2,99));
        }
        //<< . . set YNAME = YNAME_YSPACE   ;LEERZEILEN VERLÄNGERN ;prolong
        mVar YNAME = m$.var("YNAME");
        YNAME.set(mOp.Concat(m$.var("YNAME").get(),YSPACE.get()));
      }
      //<< . ;
      //<< . if YNAME0'="" do
      if (mOp.NotEqual(m$.var("YNAME0").get(),"")) {
        //<< . . new YI
        mVar YI = m$.var("YI");
        m$.newVar(YI);
        //<< . . for YI=1:1 set YI(1) = $piece(YNAME0,"|",YI) quit:YI(1)=""  do
        for (YI.set(1);(true);YI.set(mOp.Add(YI.get(),1))) {
          YI.var(1).set(m$.Fnc.$piece(m$.var("YNAME0").get(),"|",YI.get()));
          if (mOp.Equal(YI.var(1).get(),"")) {
            break;
          }
          //<< . . . write $$^WWWUML(YI(1),1)_"&nbsp;" if YNAME'="" write YCR,"<BR>"          ;
          m$.Cmd.Write(mOp.Concat(m$.fnc$("WWWUML.main",YI.var(1).get(),1),"&nbsp;"));
          if (mOp.NotEqual(m$.var("YNAME").get(),"")) {
            m$.Cmd.Write(m$.var("YCR").get(),"<BR>");
          }
        }
      }
      //<< . ;
      //<< . if (YNAME'="") || (YNAME0'="") do
      if ((mOp.NotEqual(m$.var("YNAME").get(),"")) || (mOp.NotEqual(m$.var("YNAME0").get(),""))) {
        do {
          //<< . . if YHID=1 if YART="P" if $extract(YINHALT)="+" quit  ;VERSTECKES FELD;TYBD;7,1,2004
          if (mOp.Equal(m$.var("YHID").get(),1)) {
            if (mOp.Equal(m$.var("YART").get(),"P")) {
              if (mOp.Equal(m$.Fnc.$extract(m$.var("YINHALT").get()),"+")) {
                break;
              }
            }
          }
          //<< . . if $piece(YSATZ,Y,70)=1 if YXTYP'=3 if YTYP'=2 if YXTYP'=4 if YXTYP'=6 if YXTYP'=1 if YART'="P" if YPARA(7)>1 if (YXTYP=2) || (YXTYP=11) || (YPARA(7)<5) write "&nbsp;" quit  ;GRUPPE FÜR RADIOBUTTON WENN ANZEIGE OBEN
          if (mOp.Equal(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),70),1)) {
            if (mOp.NotEqual(m$.var("YXTYP").get(),3)) {
              if (mOp.NotEqual(m$.var("YTYP").get(),2)) {
                if (mOp.NotEqual(m$.var("YXTYP").get(),4)) {
                  if (mOp.NotEqual(m$.var("YXTYP").get(),6)) {
                    if (mOp.NotEqual(m$.var("YXTYP").get(),1)) {
                      if (mOp.NotEqual(m$.var("YART").get(),"P")) {
                        if (mOp.Greater(m$.var("YPARA").var(7).get(),1)) {
                          if ((mOp.Equal(m$.var("YXTYP").get(),2)) || (mOp.Equal(m$.var("YXTYP").get(),11)) || (mOp.Less(m$.var("YPARA").var(7).get(),5))) {
                            m$.Cmd.Write("&nbsp;");
                            break;
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
          //<< . . if '$find(YNAME,"m2") if '$find(YNAME,"m3") write:$extract(YNAME,1,6)'="_BLANK" $$^WWWUML(YNAME,1) write "&nbsp;" quit
          if (mOp.Not(m$.Fnc.$find(m$.var("YNAME").get(),"m2"))) {
            if (mOp.Not(m$.Fnc.$find(m$.var("YNAME").get(),"m3"))) {
              if (mOp.NotEqual(m$.Fnc.$extract(m$.var("YNAME").get(),1,6),"_BLANK")) {
                m$.Cmd.Write(m$.fnc$("WWWUML.main",m$.var("YNAME").get(),1));
              }
              m$.Cmd.Write("&nbsp;");
              break;
            }
          }
          //<< . . if $find(YNAME,"m2") write $piece(YNAME,"m2",1)_"m<sup>"_2_"</sup>"_$piece(YNAME,"m2",2,99)_"&nbsp;" quit
          if (mOp.Logical(m$.Fnc.$find(m$.var("YNAME").get(),"m2"))) {
            m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(m$.Fnc.$piece(m$.var("YNAME").get(),"m2",1),"m<sup>"),2),"</sup>"),m$.Fnc.$piece(m$.var("YNAME").get(),"m2",2,99)),"&nbsp;"));
            break;
          }
          //<< . . if $find(YNAME,"m3") write $piece(YNAME,"m3",1)_"m<sup>"_3_"</sup>"_$piece(YNAME,"m3",2,99)_"&nbsp;" quit
          if (mOp.Logical(m$.Fnc.$find(m$.var("YNAME").get(),"m3"))) {
            m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(m$.Fnc.$piece(m$.var("YNAME").get(),"m3",1),"m<sup>"),3),"</sup>"),m$.Fnc.$piece(m$.var("YNAME").get(),"m3",2,99)),"&nbsp;"));
            break;
          }
        } while (false);
      }
    }
    //<< 
    //<< if (YNAME'="") || (YNAME0'="") write YCR,"</FONT>" ;SR17514
    if ((mOp.NotEqual(m$.var("YNAME").get(),"")) || (mOp.NotEqual(m$.var("YNAME0").get(),""))) {
      m$.Cmd.Write(m$.var("YCR").get(),"</FONT>");
    }
    //<< ;------------------------------------------------------------------------
    //<< if YLINK=1 write YCR,"</A>",YCR  ;LINK AUSSCHALTEN ;eliminate
    if (mOp.Equal(YLINK.get(),1)) {
      m$.Cmd.Write(m$.var("YCR").get(),"</A>",m$.var("YCR").get());
    }
    //<< if blnSpan write YCR,"</SPAN>"
    if (mOp.Logical(blnSpan.get())) {
      m$.Cmd.Write(m$.var("YCR").get(),"</SPAN>");
    }
    //<< 
    //<< ;   D161        $$$WWW012DoNotShowFontFaceButtonsF
    //<< 
    //<< if (YNAME'="") || (YNAME0'="") if (YTYP=8) write YCR,"<B>" do ^WWWEURO(2,$piece(YVOR1,Y,75),"L") write "</B>"   ;WÄHRUNG ;money standard
    if ((mOp.NotEqual(m$.var("YNAME").get(),"")) || (mOp.NotEqual(m$.var("YNAME0").get(),""))) {
      if ((mOp.Equal(m$.var("YTYP").get(),8))) {
        m$.Cmd.Write(m$.var("YCR").get(),"<B>");
        m$.Cmd.Do("WWWEURO.main",2,m$.Fnc.$piece(m$.var("YVOR1").get(),m$.var("Y").get(),75),"L");
        m$.Cmd.Write("</B>");
      }
    }
    //<< 
    //<< ; FIXME : Specific namespaces - deprecated : REMOVE?
    //<< if ($extract(YUCI,1,10)="INTRAPREND") || (YUCI="MESSE") if YHID'=2 if YTYP=3 do
    if ((mOp.Equal(m$.Fnc.$extract(m$.var("YUCI").get(),1,10),"INTRAPREND")) || (mOp.Equal(m$.var("YUCI").get(),"MESSE"))) {
      if (mOp.NotEqual(m$.var("YHID").get(),2)) {
        if (mOp.Equal(m$.var("YTYP").get(),3)) {
          do {
            //<< . if $get(YVOR1)="" new YVOR1 set YVOR1=$get(^WWW012(0,0,1))  ;FIS;17.12.04 ;NUR BEI BEDARF NEU HOLEN
            if (mOp.Equal(m$.Fnc.$get(m$.var("YVOR1")),"")) {
              mVar YVOR1 = m$.var("YVOR1");
              m$.newVar(YVOR1);
              YVOR1.set(m$.Fnc.$get(m$.var("^WWW012",0,0,1)));
            }
            //<< . if $piece(YVOR1,Y,161)=$$$YES quit
            if (mOp.Equal(m$.Fnc.$piece(m$.var("YVOR1").get(),m$.var("Y").get(),161),include.COMSYS.$$$YES(m$))) {
              break;
            }
            //<< . write "<br><br>"
            m$.Cmd.Write("<br><br>");
            //<< . write "<INPUT TYPE=BUTTON VALUE=a NAME=A onClick=""document."_YHTMFORM_".Y"_YFORM_YART_YLFN_".style.fontFamily='Arial'"">"
            m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<INPUT TYPE=BUTTON VALUE=a NAME=A onClick=\"document.",m$.var("YHTMFORM").get()),".Y"),m$.var("YFORM").get()),m$.var("YART").get()),m$.var("YLFN").get()),".style.fontFamily='Arial'\">"));
            //<< . write "<INPUT TYPE=BUTTON VALUE=c NAME=C onClick=""document."_YHTMFORM_".Y"_YFORM_YART_YLFN_".style.fontFamily='Courier'"">"
            m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<INPUT TYPE=BUTTON VALUE=c NAME=C onClick=\"document.",m$.var("YHTMFORM").get()),".Y"),m$.var("YFORM").get()),m$.var("YART").get()),m$.var("YLFN").get()),".style.fontFamily='Courier'\">"));
          } while (false);
        }
      }
    }
    //<< 
    //<< quit
    return;
  }

  //<< 
  //<< 
  //<< NEXT ;ZWISCHEN FRAGE UND ANTWORT ;inter- caption And
  public void NEXT() {
    //<< ;-------------------------------------------------------------------------------
    //<< ;
    //<< ;
    //<< ; Inputs:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 23-Nov-2012   shobby  SR18185: Improve alignment of data fields that are made readony
    //<< ;                           in the OnBeforeFormConstruction event.
    //<< ; 20-Nov-2012   shobby  SR18178: Vertical alignment correction
    //<< ; 05-Nov-2012   shobby  SR18179: Improved separation of combo boxes.
    //<< ; 04-Oct-2012   shobby  SR18129: Better alignment of caption and input controls
    //<< ; 01-Jun-2012   shobby  SR18027: Put id's on the caption and control.
    //<< ; 27-Sep-2011   shobby  SR17853: Reverted doCancelEvent
    //<< ; 09-Mar-2011   shobby  SR17261.1 : If a field has an ID then the help window won't
    //<< ;                           be loaded which is what we want if there is already a
    //<< ;                           popup help.
    //<< ; 28-Oct-2009   shobby  SR16942: Simplified existing code.  Added call to
    //<< ;                           onhelp, (note that "NOVALUE" is used in place of
    //<< ;                           YVARIA (Variable for event broker) from the previous
    //<< ;                           help call. Shouldn't be necessary for help text.
    //<< ;-------------------------------------------------------------------------------
    //<< ;   D44     $$$WWW120FormFormatting()
    //<< ;   D93     $$$WWW121FixAnswerLengthInPixel()  or $$$WWW122...
    //<< ;---------------------------------------
    //<< $$$LogR2("NEXT","")
    $$$LogR2(m$,"NEXT","");
    //<< new strId   ;SR18027
    mVar strId = m$.var("strId");
    m$.newVar(strId);
    //<< 
    //<< set strId="Y"_YFORM_YART_YLFN_"_CONTROL" ;SR180127
    strId.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("Y",m$.var("YFORM").get()),m$.var("YART").get()),m$.var("YLFN").get()),"_CONTROL"));
    //<< 
    //<< if (YFOART1'=3) && $find(";0;1;2;",(";"_$piece(YVOR,Y,44)_";")) {
    if ((mOp.NotEqual(m$.var("YFOART1").get(),3)) && mOp.Logical(m$.Fnc.$find(";0;1;2;",(mOp.Concat(mOp.Concat(";",m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),44)),";"))))) {
      //<< write YCR,"</TD>"
      m$.Cmd.Write(m$.var("YCR").get(),"</TD>");
      //<< 
      //<< ;SR18027 write YCR,"<TD id='help' NOWRAP VALIGN="_YVAUS ;SR17261.1
      //<< write YCR,"<TD id='"_strId_"' NOWRAP VALIGN="_YVAUS ;SR17261.1 ;SR18027
      m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat(mOp.Concat("<TD id='",strId.get()),"' NOWRAP VALIGN="),m$.var("YVAUS").get()));
      //<< if +$piece(YSATZ,Y,93)'=0 write " WIDTH="_$piece(YSATZ,Y,93)
      if (mOp.NotEqual(mOp.Positive(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),93)),0)) {
        m$.Cmd.Write(mOp.Concat(" WIDTH=",m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),93)));
      }
      //<< if YHID=1 {                                 ;SR18185
      if (mOp.Equal(m$.var("YHID").get(),1)) {
        //<< write " style='padding:3px; " ;SR18129  ;SR18185
        m$.Cmd.Write(" style='padding:3px; ");
      }
      //<< } else {                                    ;SR18185
      else {
        //<< write " style='padding:0px; " ;SR18129  ;SR18185
        m$.Cmd.Write(" style='padding:0px; ");
      }
      //<< }                                           ;SR18185
      //<< ;SR18178 write "vertical-align:middle; " ;SR18179
      //<< write "vertical-align:"_YVAUS_"; " ;SR18179 ;SR18178
      m$.Cmd.Write(mOp.Concat(mOp.Concat("vertical-align:",m$.var("YVAUS").get()),"; "));
      //<< write "' " ;SR18129
      m$.Cmd.Write("' ");
      //<< write YCR," onHelp='{ window.event.returnValue = false; window.event.cancelBubble = true; retval = EventValue("""_YUCI_""","""_YUSER_""","""_YFORM_""",""FIX"_$translate(YKEY,".","~")_""",""Y"_YFORM_YART_YLFN_""","" "",""3"",""NOVALUE"");}'" ;SR17853
      m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(" onHelp='{ window.event.returnValue = false; window.event.cancelBubble = true; retval = EventValue(\"",m$.var("YUCI").get()),"\",\""),m$.var("YUSER").get()),"\",\""),m$.var("YFORM").get()),"\",\"FIX"),m$.Fnc.$translate(m$.var("YKEY").get(),".","~")),"\",\"Y"),m$.var("YFORM").get()),m$.var("YART").get()),m$.var("YLFN").get()),"\",\" \",\"3\",\"NOVALUE\");}'"));
      //<< write ">"
      m$.Cmd.Write(">");
    }
    //<< }
    //<< quit
    return;
  }

  //<< 
  //<< 
  //<< ANTWORTWRAPPER(pblnOnBehind=$$$NO) ;ANTWORT
  public Object ANTWORTWRAPPER(Object ... _p) {
    mVar pblnOnBehind = m$.newVarRef("pblnOnBehind",(((_p!=null)&&(_p.length>=1))?_p[0]:null),include.COMSYS.$$$NO(m$));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Handles the fact that ANTWORT routine has short cut quits which would
    //<< ; stop this code from running when ANTWORT was called.
    //<< ;
    //<< ; Inputs: pblnOnBehind
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 09-Aug-2007   shobby  SRBR014667: Run RELATION function conditionally based
    //<< ;                           on the type of field that was handled in $$ANTWORT
    //<< ; 26-Jul-2007   shobby  SRBR014645: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new blnRelation
    mVar blnRelation = m$.var("blnRelation");
    m$.newVar(blnRelation);
    //<< 
    //<< $$$LogR2("ANTWORTWRAPPER",pblnOnBehind_"<"_$get(YKEY)_"<"_YFORM_YART_YLFN)
    $$$LogR2(m$,"ANTWORTWRAPPER",mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(pblnOnBehind.get(),"<"),m$.Fnc.$get(m$.var("YKEY"))),"<"),m$.var("YFORM").get()),m$.var("YART").get()),m$.var("YLFN").get()));
    //<< 
    //<< set blnRelation = $$ANTWORT()
    blnRelation.set(m$.fnc$("ANTWORT"));
    //<< write YCR,"</FONT>"  ;SR17514
    m$.Cmd.Write(m$.var("YCR").get(),"</FONT>");
    //<< 
    //<< if pblnOnBehind {
    if (mOp.Logical(pblnOnBehind.get())) {
      //<< ; BR014501
      //<< ; D97   $$$WWW122ExecuteAfterDataField()     ; Execute At Form Construction (After)
      //<< if $piece(YSATZ,Y,97)'="" {                             ; *** EXECUTE ***
      if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),97),"")) {
        //<< write " " xecute $piece(YSATZ,Y,97)
        m$.Cmd.Write(" ");
        m$.Cmd.Xecute(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),97));
      }
      //<< }  ;execute hinter feld ;posterior
      //<< if $$EXIST^%R("Y"_YFORM_YART_YLFN_"onBehind.OBJ",$get(YUCI)) {
      if (mOp.Logical(m$.fnc$("$R.EXIST",mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("Y",m$.var("YFORM").get()),m$.var("YART").get()),m$.var("YLFN").get()),"onBehind.OBJ"),m$.Fnc.$get(m$.var("YUCI"))))) {
        //<< write " " xecute "DO ^Y"_YFORM_YART_YLFN_"onBehind"
        m$.Cmd.Write(" ");
        m$.Cmd.Xecute(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("DO ^Y",m$.var("YFORM").get()),m$.var("YART").get()),m$.var("YLFN").get()),"onBehind"));
      }
    }
    //<< }
    //<< }
    //<< if blnRelation do RELATION
    if (mOp.Logical(blnRelation.get())) {
      m$.Cmd.Do("RELATION");
    }
    //<< 
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< ANTWORT()
  public Object ANTWORT(Object ... _p) {
    //<< ;-------------------------------------------------------------------------------
    //<< ; History:
    //<< ; 03-Oct-2013   shobby  CORE-159: Corrected a problem in WWWFORM7 where Primary keys were referencing the form data field routines. (WWW122 not WWW121)
    //<< ; 30-Aug-2013   shobby  CORE-76: Removed CoreChanges date formatting. There is a property for this.
    //<< ; 07-May-2013   shobby  CORE-75.11: FATSearch manages it's own relations now.
    //<< ; 02-Nov-2012   shobby  SR18179: Allow Manual Field size to be overridden.
    //<< ; 25-Jun-2012   shobby  SR18026.2: Only show options LinkedToGrid if readonly.
    //<< ; 18-Jun-2012   SCR     SR18045: Make the cursor visible on the numeric fields
    //<< ; 29-Apr-2012   shobby  SR18000: Flat Controls included at field level
    //<< ; 14-Apr-2012   shobby  SR18000: Flat Controls
    //<< ; 03-Nov-2011   shobby  SR17725: New control.  FATSearch
    //<< ; 16-Sep-2011   PPP/PABLO SR17905:combobox, the value doesn't show correctly if it has a '-' character
    //<< ; 24-Aug-2011   shobby  SR17861: Formatting changes to improve appearance with
    //<< ;                           Windows 7 and FF.
    //<< ; 09-Mar-2011   shobby  SR17680: INItemStatus allows defining of colours for drop
    //<< ;                           down lists.
    //<< ; 24-Feb-2011   shobby  SR17514: Change <A> to a <DIV> in disabled drop down
    //<< ;                           controls to prevent a phantom hyperlink in Firefox.
    //<< ; 09-Dec-2010   shobby  SR17251: Block double enter key in textarea controls.
    //<< ; 07-Oct-2010   shobby  SR17564: Call out to a new 'Inheritable Checkbox' control
    //<< ; 11-May-2010   shobby  SR17291: textarea needs an id. (firefox)
    //<< ; 31-Mar-2008   shobby  SRBR014925: For 'Memo fields with format buttons',
    //<< ;                           don't disregard this check for large memo fields.
    //<< ; 28-Feb-2008   shobby  SRBR014894: Previous comment for HideRelationClassIDs
    //<< ;                           was incorrect.  The functionality from drop down
    //<< ;                           lists is achieved with the DoNotShowPrimaryKey field.
    //<< ; 15-Feb-2008   GRF     SRBR014895: Provide direct calls to PARASUCH^WWWFORM75
    //<< ; 08-Feb-2008   shobby  SRBR014895: Put the text search button on memo fields.
    //<< ; 07-Feb-2008   shobby  SRBR014894: HideRelationClassIDs functionality extended
    //<< ;                           to Standard Forms
    //<< ; 28-Oct-2007   shobby  SRBR014513: Test to determine whether to apply 'Memo
    //<< ;                           Fields with Format Buttons' should only check the
    //<< ;                           length and width if there is a '-' character in YLANGE.
    //<< ; 09-Aug-2007   shobby  SRBR014667: ANTWORT now returns a value to determine whether
    //<< ;                           to run the RELATION routine which has been moved to
    //<< ;                           ANTWORTWRAPPER.
    //<< ;
    //<< ;
    //<< ; *** Caution:  All the short cut quits in this routine make the logic confusing.
    //<< ;
    //<< ;
    //<< ; 23-Aug-2011   shobby  SR17861: Some changes to formatting based on suggestions
    //<< ;                           by Gustavo F to improve appearance in Windows 7 and FF.
    //<< ; 08-Aug-2007   Frank   SRBR014628: 'Modified Input Field Length' does not
    //<< ;                           override Customization anymore.
    //<< ; 26-Jul-2007   Frank   SRBR014471: 'Modified Field Length' does not override
    //<< ;                           Customization anymore.
    //<< ; 27-Jul-2007   shobby  SRBR014645: Removed call to 'Execute On Form Construction
    //<< ;                           (after)' into ANTWORTWRAPPER, removed parameter
    //<< ;                           pblnOnBehind
    //<< ; 22-Jun-2007   GM      SRBR014514: Show properties of all fields in status bar
    //<< ;                           of Internet Explorer
    //<< ; 01-Jun-2007   shobby  SRBR014501: Put onBehind calls before translated references.
    //<< ; 30-May-2006   SC      SR14631: For Multi-Selects, do not show selection colour
    //<< ;                           (blue) if read-only (now grey).
    //<< ; 22-Dec-2005   JW      SR13195: Put </textarea> on same line (getting extra CR)
    //<< ;-------------------------------------------------------------------------------
    //<< if +$get(YPARA(29))=0 set YPARA(29)=1  ;SORTIERUNG AUF/AB  ;sorting
    if (mOp.Equal(mOp.Positive(m$.Fnc.$get(m$.var("YPARA").var(29))),0)) {
      mVar YPARA = m$.var("YPARA");
      YPARA.var(29).set(1);
    }
    //<< write YCR,"<FONT SIZE="""_$piece(YVOR,Y,7)_""">"
    m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat("<FONT SIZE=\"",m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),7)),"\">"));
    //<< 
    //<< ;---------------------------------------
    //<< ; VERSTECKTE INHALTE
    //<< ;---------------------------------------
    //<< write YCR
    m$.Cmd.Write(m$.var("YCR").get());
    //<< if (YTYPE="HIDDEN") || (YHID=1) || (YTYP=0) do  quit $$$NO   ; *** EARLY EXIT ***    HIDDEN
    if ((mOp.Equal(m$.var("YTYPE").get(),"HIDDEN")) || (mOp.Equal(m$.var("YHID").get(),1)) || (mOp.Equal(m$.var("YTYP").get(),0))) {
      //<< . do
      do {
        //<< . . if YART="P" if $extract(YINHALT)="+" quit
        if (mOp.Equal(m$.var("YART").get(),"P")) {
          if (mOp.Equal(m$.Fnc.$extract(m$.var("YINHALT").get()),"+")) {
            break;
          }
        }
        //<< . . if YART="P" if $piece($get(YVOR1),Y,95)=1 write "<B>"
        if (mOp.Equal(m$.var("YART").get(),"P")) {
          if (mOp.Equal(m$.Fnc.$piece(m$.Fnc.$get(m$.var("YVOR1")),m$.var("Y").get(),95),1)) {
            m$.Cmd.Write("<B>");
          }
        }
        //<< . . write YINHALT
        m$.Cmd.Write(m$.var("YINHALT").get());
        //<< . . if YART="P" if $piece($get(YVOR1),Y,95)=1 write "</B>"
        if (mOp.Equal(m$.var("YART").get(),"P")) {
          if (mOp.Equal(m$.Fnc.$piece(m$.Fnc.$get(m$.var("YVOR1")),m$.var("Y").get(),95),1)) {
            m$.Cmd.Write("</B>");
          }
        }
      } while(false);
      //<< . ;
      //<< . write YCR,"<INPUT",YCR," NAME=""Y"_YFORM_YART_YLFN_"""",YCR," SIZE="""_YLANGE_"""",YCR," MAXLENGTH="""_YLANGE_""""
      m$.Cmd.Write(m$.var("YCR").get(),"<INPUT",m$.var("YCR").get(),mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(" NAME=\"Y",m$.var("YFORM").get()),m$.var("YART").get()),m$.var("YLFN").get()),"\""),m$.var("YCR").get(),mOp.Concat(mOp.Concat(" SIZE=\"",m$.var("YLANGE").get()),"\""),m$.var("YCR").get(),mOp.Concat(mOp.Concat(" MAXLENGTH=\"",m$.var("YLANGE").get()),"\""));
      //<< . write " ID=""Y"_YFORM_YART_YLFN_""""          ;SR17253
      m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(" ID=\"Y",m$.var("YFORM").get()),m$.var("YART").get()),m$.var("YLFN").get()),"\""));
      //<< . write YCR," TYPE=HIDDEN"
      m$.Cmd.Write(m$.var("YCR").get()," TYPE=HIDDEN");
      //<< . write YCR," VALUE="""_YINHALT_""""
      m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat(" VALUE=\"",m$.var("YINHALT").get()),"\""));
      //<< . if +$piece(YSATZ,Y,61)=0 if $get(YHID)=2  write YCR," TABINDEX=-1"    ; TAB STOP IN READ ONLY FIELD.14.07.06;FAN
      if (mOp.Equal(mOp.Positive(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),61)),0)) {
        if (mOp.Equal(m$.Fnc.$get(m$.var("YHID")),2)) {
          m$.Cmd.Write(m$.var("YCR").get()," TABINDEX=-1");
        }
      }
      //<< . if +$piece(YSATZ,Y,61)=0 if $get(YHID)'=2 write YCR," TABINDEX="""_YTABX_""""
      if (mOp.Equal(mOp.Positive(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),61)),0)) {
        if (mOp.NotEqual(m$.Fnc.$get(m$.var("YHID")),2)) {
          m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat(" TABINDEX=\"",m$.var("YTABX").get()),"\""));
        }
      }
      //<< . if +$piece(YSATZ,Y,61)'=0                 write YCR," TABINDEX="""_+$piece(YSATZ,Y,61)_""""
      if (mOp.NotEqual(mOp.Positive(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),61)),0)) {
        m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat(" TABINDEX=\"",mOp.Positive(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),61))),"\""));
      }
      //<< . write ">"
      m$.Cmd.Write(">");
      //<< . if YTYP=1 set YINHALT=$$^WWWDATE1(YINHALT)  ;DISP TO DATA
      if (mOp.Equal(m$.var("YTYP").get(),1)) {
        mVar YINHALT = m$.var("YINHALT");
        YINHALT.set(m$.fnc$("WWWDATE1.main",m$.var("YINHALT").get()));
      }
      //<< . if YTYP=7 set YINHALT=$$^WWWTIME1(YINHALT)  ;DISP TO DATA
      if (mOp.Equal(m$.var("YTYP").get(),7)) {
        mVar YINHALT = m$.var("YINHALT");
        YINHALT.set(m$.fnc$("WWWTIME1.main",m$.var("YINHALT").get()));
      }
      //<< . if YINHALT'="" if YPARA(1)'="" do
      if (mOp.NotEqual(m$.var("YINHALT").get(),"")) {
        if (mOp.NotEqual(m$.var("YPARA").var(1).get(),"")) {
          do {
            //<< . . new YDATA
            mVar YDATA = m$.var("YDATA");
            m$.newVar(YDATA);
            //<< . . if YPARA(3)="" set YPARA(3)=1
            if (mOp.Equal(m$.var("YPARA").var(3).get(),"")) {
              mVar YPARA = m$.var("YPARA");
              YPARA.var(3).set(1);
            }
            //<< . . set YPARA(4)="^"_YPARA(1)_"("_$$^WWWYM(YPARA(1),1)
            mVar YPARA = m$.var("YPARA");
            YPARA.var(4).set(mOp.Concat(mOp.Concat(mOp.Concat("^",m$.var("YPARA").var(1).get()),"("),m$.fnc$("WWWYM.main",m$.var("YPARA").var(1).get(),1)));
            //<< . . set YDATA=$get(^WWW001(0,YPARA(1),1))
            YDATA.set(m$.Fnc.$get(m$.var("^WWW001",0,YPARA.var(1).get(),1)));
            //<< . . if $piece(YDATA,Y,12)'="" if $piece(YDATA,Y,13)'="" do  ;UCI UND VOL ;UCI And
            if (mOp.NotEqual(m$.Fnc.$piece(YDATA.get(),m$.var("Y").get(),12),"")) {
              if (mOp.NotEqual(m$.Fnc.$piece(YDATA.get(),m$.var("Y").get(),13),"")) {
                do {
                  //<< . . . quit:$find(YPARA(4),"^[")
                  if (mOp.Logical(m$.Fnc.$find(YPARA.var(4).get(),"^["))) {
                    break;
                  }
                  //<< . . . set YPARA(4)="^["""_$piece(YDATA,Y,12)_""","""_$piece(YDATA,Y,13)_"""]"_$piece(YPARA(4),"^",2,999)
                  YPARA.var(4).set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("^[\"",m$.Fnc.$piece(YDATA.get(),m$.var("Y").get(),12)),"\",\""),m$.Fnc.$piece(YDATA.get(),m$.var("Y").get(),13)),"\"]"),m$.Fnc.$piece(YPARA.var(4).get(),"^",2,999)));
                } while (false);
              }
            }
            //<< . . ;
            //<< . . set YDATA=$get(^WWW001(0,YPARA(1),1))
            YDATA.set(m$.Fnc.$get(m$.var("^WWW001",0,YPARA.var(1).get(),1)));
            //<< . . set Q=0
            mVar Q = m$.var("Q");
            Q.set(0);
            //<< . . for YI=1:1 set YPARA(9)=$piece(YPARA(2),",",YI) quit:YPARA(9)=""  set YPARA(4)=YPARA(4)_YPARA(9)_"," if $extract(YPARA(9))'="""" if $get(@(YPARA(9)))="" set Q=1 quit
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
            //<< . . if Q=1 set Q=0 quit
            if (mOp.Equal(Q.get(),1)) {
              Q.set(0);
              break;
            }
            //<< . . if $piece(YDATA,Y,8)'=4 set YPARA(6)=YPARA(4)_""""_YINHALT_""",1)"
            if (mOp.NotEqual(m$.Fnc.$piece(YDATA.get(),m$.var("Y").get(),8),4)) {
              YPARA.var(6).set(mOp.Concat(mOp.Concat(mOp.Concat(YPARA.var(4).get(),"\""),m$.var("YINHALT").get()),"\",1)"));
            }
            //<< . . if $piece(YDATA,Y,8)=4  set YPARA(6)=YPARA(4)_""""_YINHALT_""")"
            if (mOp.Equal(m$.Fnc.$piece(YDATA.get(),m$.var("Y").get(),8),4)) {
              YPARA.var(6).set(mOp.Concat(mOp.Concat(mOp.Concat(YPARA.var(4).get(),"\""),m$.var("YINHALT").get()),"\")"));
            }
            //<< . . set YPARA(3)=$translate(YPARA(3),";",",")
            YPARA.var(3).set(m$.Fnc.$translate(YPARA.var(3).get(),";",","));
            //<< . . new YII
            mVar YII = m$.var("YII");
            m$.newVar(YII);
            //<< . . set YPARA(100)=""
            YPARA.var(100).set("");
            //<< . . for YII=1:1 set YII(1)=$piece(YPARA(3),",",YII) quit:YII(1)=""  do
            for (YII.set(1);(true);YII.set(mOp.Add(YII.get(),1))) {
              YII.var(1).set(m$.Fnc.$piece(YPARA.var(3).get(),",",YII.get()));
              if (mOp.Equal(YII.var(1).get(),"")) {
                break;
              }
              //<< . . . set YPARA(101)=$extract($translate($piece($$^WWWSETL(YPARA(6)),Y,YII(1)),"|"," "),1,60)
              YPARA.var(101).set(m$.Fnc.$extract(m$.Fnc.$translate(m$.Fnc.$piece(m$.fnc$("WWWSETL.main",YPARA.var(6).get()),m$.var("Y").get(),YII.var(1).get()),"|"," "),1,60));
              //<< . . . set YPARA(102)=$piece($get(^WWW003(0,YPARA(1),YII(1),1)),Y,3)
              YPARA.var(102).set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW003",0,YPARA.var(1).get(),YII.var(1).get(),1)),m$.var("Y").get(),3));
              //<< . . . if YPARA(102)=1 set YPARA(101)=$$GetLiteral^WWWTR(YPARA(102),YPARA(101))
              if (mOp.Equal(YPARA.var(102).get(),1)) {
                YPARA.var(101).set(m$.fnc$("WWWTR.GetLiteral",YPARA.var(102).get(),YPARA.var(101).get()));
              }
              //<< . . . set YPARA(100)=YPARA(100)_YPARA(101)_" "
              YPARA.var(100).set(mOp.Concat(mOp.Concat(YPARA.var(100).get(),YPARA.var(101).get())," "));
            }
            //<< . . ;
            //<< . . if YART="P" if $piece($get(YVOR1),Y,95)=1 write "<B>"
            if (mOp.Equal(m$.var("YART").get(),"P")) {
              if (mOp.Equal(m$.Fnc.$piece(m$.Fnc.$get(m$.var("YVOR1")),m$.var("Y").get(),95),1)) {
                m$.Cmd.Write("<B>");
              }
            }
            //<< . . write " ("_YPARA(100)_")"
            m$.Cmd.Write(mOp.Concat(mOp.Concat(" (",YPARA.var(100).get()),")"));
            //<< . . if YART="P" if $piece($get(YVOR1),Y,95)=1 write "</B>"
            if (mOp.Equal(m$.var("YART").get(),"P")) {
              if (mOp.Equal(m$.Fnc.$piece(m$.Fnc.$get(m$.var("YVOR1")),m$.var("Y").get(),95),1)) {
                m$.Cmd.Write("</B>");
              }
            }
          } while (false);
        }
      }
      return include.COMSYS.$$$NO(m$);
    }
    //<< 
    //<< ;---------------------------------------  ;SR17564
    //<< ; Inheritable checkbox
    //<< ;---------------------------------------
    //<< if (YXTYP=17) && ($$$WWW122InheritedFrom($$Get^WWW122(YFORM,YBBN))'="") {
    if ((mOp.Equal(m$.var("YXTYP").get(),17)) && (mOp.NotEqual(include.WWWConst.$$$WWW122InheritedFrom(m$,m$.fnc$("WWW122.Get",m$.var("YFORM").get(),m$.var("YBBN").get())),""))) {
      //<< do Display^WWWFORM7InheritableCheckBox()
      m$.Cmd.Do("WWWFORM7InheritableCheckBox.Display");
      //<< quit $$$YES
      return include.COMSYS.$$$YES(m$);
    }
    //<< }
    //<< 
    //<< ;---------------------------------------  ;SR17725
    //<< ; FAT Search
    //<< ;---------------------------------------
    //<< if (YXTYP=18) {
    if ((mOp.Equal(m$.var("YXTYP").get(),18))) {
      //<< do Display^WWWFORM7FATSearch(YFORM,YART,YLFN)
      m$.Cmd.Do("WWWFORM7FATSearch.Display",m$.var("YFORM").get(),m$.var("YART").get(),m$.var("YLFN").get());
      //<< ;CORE-75.11 quit $$$YES ;SR17725
      //<< quit $$$NO ;CORE-75.11 (Relation is managed within Display^WWWFORM7FATSearch)
      return include.COMSYS.$$$NO(m$);
    }
    //<< }
    //<< 
    //<< ;---------------------------------------
    //<< ; CHECKBOXEN                                                ; *** EXECUTE ***
    //<< ;   D99     $$$WWW122ExecuteWithinDataField()    ; Execute At Form Construction (Within)
    //<< ;---------------------------------------
    //<< if (YXTYP=3) || (YTYP=2) do  quit $$$YES                 ; *** EARLY EXIT ***
    if ((mOp.Equal(m$.var("YXTYP").get(),3)) || (mOp.Equal(m$.var("YTYP").get(),2))) {
      //<< . ;SR17514 a:hover{color:red; text-decoration:underline}
      //<< . ;SR17514 IF (YHID=2) && (YSTATUS'="") WRITE YCR,"<A" DO STAT WRITE ">"
      //<< . if (YHID=2) && (YSTATUS'="") write YCR,"<A class='b' ; " do STAT write ">"
      if ((mOp.Equal(m$.var("YHID").get(),2)) && (mOp.NotEqual(m$.var("YSTATUS").get(),""))) {
        m$.Cmd.Write(m$.var("YCR").get(),"<A class='b' ; ");
        m$.Cmd.Do("STAT");
        m$.Cmd.Write(">");
      }
      //<< . write YCR,"<INPUT TYPE=""CHECKBOX"""
      m$.Cmd.Write(m$.var("YCR").get(),"<INPUT TYPE=\"CHECKBOX\"");
      //<< . write YCR," NAME=""Y"_YFORM_YART_YLFN_""""
      m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(" NAME=\"Y",m$.var("YFORM").get()),m$.var("YART").get()),m$.var("YLFN").get()),"\""));
      //<< . write " ID=""Y"_YFORM_YART_YLFN_""""          ;SR17253
      m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(" ID=\"Y",m$.var("YFORM").get()),m$.var("YART").get()),m$.var("YLFN").get()),"\""));
      //<< . write YCR," VALUE=""1"""
      m$.Cmd.Write(m$.var("YCR").get()," VALUE=\"1\"");
      //<< . if +$piece(YSATZ,Y,61)=0 if $get(YHID)=2  write YCR," TABINDEX=-1"            ; TAB STOP IN READ ONLY FIELD.14.07.06;FAN
      if (mOp.Equal(mOp.Positive(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),61)),0)) {
        if (mOp.Equal(m$.Fnc.$get(m$.var("YHID")),2)) {
          m$.Cmd.Write(m$.var("YCR").get()," TABINDEX=-1");
        }
      }
      //<< . if +$piece(YSATZ,Y,61)=0 if $get(YHID)'=2 write YCR," TABINDEX="""_YTABX_""""
      if (mOp.Equal(mOp.Positive(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),61)),0)) {
        if (mOp.NotEqual(m$.Fnc.$get(m$.var("YHID")),2)) {
          m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat(" TABINDEX=\"",m$.var("YTABX").get()),"\""));
        }
      }
      //<< . if +$piece(YSATZ,Y,61)'=0                 write YCR," TABINDEX="""_+$piece(YSATZ,Y,61)_""""
      if (mOp.NotEqual(mOp.Positive(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),61)),0)) {
        m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat(" TABINDEX=\"",mOp.Positive(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),61))),"\""));
      }
      //<< . ;
      //<< . ; *** EXECUTE ***
      //<< . if $piece(YSATZ,Y,99)'="" xecute $piece(YSATZ,Y,99)  ;EXECUTE INNERHALB EINES EINGABEFELDES GUE ;EXECUTE inside
      if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),99),"")) {
        m$.Cmd.Xecute(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),99));
      }
      //<< . if $$EXIST^%R("Y"_YFORM_YART_YLFN_"onField.OBJ",$get(YUCI)) write YCR xecute "DO ^Y"_YFORM_YART_YLFN_"onField"  ;CUSTOMIZED EXECUTE;FIS;24947;10.01.04
      if (mOp.Logical(m$.fnc$("$R.EXIST",mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("Y",m$.var("YFORM").get()),m$.var("YART").get()),m$.var("YLFN").get()),"onField.OBJ"),m$.Fnc.$get(m$.var("YUCI"))))) {
        m$.Cmd.Write(m$.var("YCR").get());
        m$.Cmd.Xecute(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("DO ^Y",m$.var("YFORM").get()),m$.var("YART").get()),m$.var("YLFN").get()),"onField"));
      }
      //<< . ;
      //<< . if YINHALT="1" write YCR," CHECKED=""CHECKED"""
      if (mOp.Equal(m$.var("YINHALT").get(),"1")) {
        m$.Cmd.Write(m$.var("YCR").get()," CHECKED=\"CHECKED\"");
      }
      //<< . ;
      //<< . write YCR," style="""
      m$.Cmd.Write(m$.var("YCR").get()," style=\"");
      //<< . if $$$WWW122FlatControls(YSATZ) write "border:none; margin:1px; " ;SR18000
      if (mOp.Logical(include.WWWConst.$$$WWW122FlatControls(m$,m$.var("YSATZ")))) {
        m$.Cmd.Write("border:none; margin:1px; ");
      }
      //<< . write "padding-left:1"   ;style;TYBD;28,7,2004
      m$.Cmd.Write("padding-left:1");
      //<< . if $piece(YSATZ,Y,78)'="" write YCR,"; "_$piece(YSATZ,Y,78)   ;style
      if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),78),"")) {
        m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat("; ",m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),78)));
      }
      //<< . if YHID=2 do LESEN1
      if (mOp.Equal(m$.var("YHID").get(),2)) {
        m$.Cmd.Do("LESEN1");
      }
      //<< . write """"   ;STYLE ENDE;TYBD;28,7,2004
      m$.Cmd.Write("\"");
      //<< . do SAVE
      m$.Cmd.Do("SAVE");
      //<< . if YHID=2 if YHTMFORM="WWW2" write " disabled"
      if (mOp.Equal(m$.var("YHID").get(),2)) {
        if (mOp.Equal(m$.var("YHTMFORM").get(),"WWW2")) {
          m$.Cmd.Write(" disabled");
        }
      }
      //<< . if YHID=2 do LESEN
      if (mOp.Equal(m$.var("YHID").get(),2)) {
        m$.Cmd.Do("LESEN");
      }
      //<< . if (YHID'=2) && (YSTATUS'="") do STAT
      if ((mOp.NotEqual(m$.var("YHID").get(),2)) && (mOp.NotEqual(m$.var("YSTATUS").get(),""))) {
        m$.Cmd.Do("STAT");
      }
      //<< . if $piece(YSATZ,Y,82)'=""     do READONLY  ;ANDERE FELDER AUF READ ONLY WENN EINGABE ;upon READ when
      if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),82),"")) {
        m$.Cmd.Do("READONLY");
      }
      //<< . if $piece(YSATZ,Y,83)'=""     do WRITE     ;ANDERE FELDER AUF WRITE WENN EINGABE ;upon when
      if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),83),"")) {
        m$.Cmd.Do("WRITE");
      }
      //<< . if YJAVA=1 do JAVA^WWWFORM8
      if (mOp.Equal(m$.var("YJAVA").get(),1)) {
        m$.Cmd.Do("WWWFORM8.JAVA");
      }
      //<< . write ">"
      m$.Cmd.Write(">");
      //<< . if (YHID=2) && (YSTATUS'="") write YCR,"</A>"
      if ((mOp.Equal(m$.var("YHID").get(),2)) && (mOp.NotEqual(m$.var("YSTATUS").get(),""))) {
        m$.Cmd.Write(m$.var("YCR").get(),"</A>");
      }
      //<< . set YINHALT=+YINHALT
      mVar YINHALT = m$.var("YINHALT");
      YINHALT.set(mOp.Positive(m$.var("YINHALT").get()));
      return include.COMSYS.$$$YES(m$);
    }
    //<< 
    //<< ;---------------------------------------
    //<< ; Memo Text Field    ;LANGE TEXTE MEMO FELDER               ; *** EXECUTE ***
    //<< ;   D99     $$$WWW122ExecuteWithinDataField()    ; Execute At Form Construction (Within)
    //<< ;---------------------------------------
    //<< ;BEI TEXTEN;TYBD22,03,2003;ABER NUR WENN NICHT ÜBERSCHRIEBEN 1 BEI FORMDEF TYBD; 4,12,2003;NUR WENN NICHT WWW FORMS
    //<< if YXTYP'=1 if YTYPE="TEXT" if YINHALT'="" if $find(YINHALT,"|") if $extract($get(YFORM))'="W" set YXTYP=5,YTYP=3
    if (mOp.NotEqual(m$.var("YXTYP").get(),1)) {
      if (mOp.Equal(m$.var("YTYPE").get(),"TEXT")) {
        if (mOp.NotEqual(m$.var("YINHALT").get(),"")) {
          if (mOp.Logical(m$.Fnc.$find(m$.var("YINHALT").get(),"|"))) {
            if (mOp.NotEqual(m$.Fnc.$extract(m$.Fnc.$get(m$.var("YFORM"))),"W")) {
              mVar YXTYP = m$.var("YXTYP");
              YXTYP.set(5);
              mVar YTYP = m$.var("YTYP");
              YTYP.set(3);
            }
          }
        }
      }
    }
    //<< if YTYP=3 if YART="P" set YTYPE="TEXT",YTYP=6  ;KEIN LANGTEXT BEI PRIMÄRSCHL. ;no next to
    if (mOp.Equal(m$.var("YTYP").get(),3)) {
      if (mOp.Equal(m$.var("YART").get(),"P")) {
        mVar YTYPE = m$.var("YTYPE");
        YTYPE.set("TEXT");
        mVar YTYP = m$.var("YTYP");
        YTYP.set(6);
      }
    }
    //<< 
    //<< if (YTYP=3) || (YXTYP=5) do  quit $$$NO                ; *** EARLY EXIT ***
    if ((mOp.Equal(m$.var("YTYP").get(),3)) || (mOp.Equal(m$.var("YXTYP").get(),5))) {
      //<< . new YROW,YCOL,CHAR
      mVar YROW = m$.var("YROW");
      mVar YCOL = m$.var("YCOL");
      mVar CHAR = m$.var("CHAR");
      m$.newVar(YROW,YCOL,CHAR);
      //<< . do
      do {
        //<< . . ;;IF $PIECE($GET(^WWW012(0,0,1)),Y,152)=1 QUIT     ;;MINI HTML-EDITOR;BEC;;23380;23.02.04
        //<< . . ;IF $PIECE($GET(^WWW012(0,0,1)),Y,161)=1  QUIT     ;;MINI HTML-EDITOR;BEC;;23380;23.02.04
        //<< . . if $get(YVOR1)="" new YVOR1 set YVOR1=$get(^WWW012(0,0,1))  ;FIS;17.12.04 ;NUR BEI BEDARF NEU HOLEN
        if (mOp.Equal(m$.Fnc.$get(m$.var("YVOR1")),"")) {
          mVar YVOR1 = m$.var("YVOR1");
          m$.newVar(YVOR1);
          YVOR1.set(m$.Fnc.$get(m$.var("^WWW012",0,0,1)));
        }
        //<< . . if $piece(YVOR1,Y,161)=1 quit  ;do not show format buttons
        if (mOp.Equal(m$.Fnc.$piece(m$.var("YVOR1").get(),m$.var("Y").get(),161),1)) {
          break;
        }
        //<< . . if YHID'=2 if ($piece(YSATZ,Y,105)=1) do ^WWWFORMT write "<BR>"  ;FORMATIERUNGEN ;BR014513 ;BR014925  ; SR16459
        if (mOp.NotEqual(m$.var("YHID").get(),2)) {
          if ((mOp.Equal(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),105),1))) {
            m$.Cmd.Do("WWWFORMT.main");
            m$.Cmd.Write("<BR>");
          }
        }
      } while(false);
      //<< . ;
      //<< . set YROW=5,YCOL=40
      YROW.set(5);
      YCOL.set(40);
      //<< . if YLANGE>300  set YROW=7,YCOL=60
      if (mOp.Greater(m$.var("YLANGE").get(),300)) {
        YROW.set(7);
        YCOL.set(60);
      }
      //<< . if YLANGE>500  set YROW=9,YCOL=80
      if (mOp.Greater(m$.var("YLANGE").get(),500)) {
        YROW.set(9);
        YCOL.set(80);
      }
      //<< . if YLANGE>1000 set YROW=18,YCOL=80
      if (mOp.Greater(m$.var("YLANGE").get(),1000)) {
        YROW.set(18);
        YCOL.set(80);
      }
      //<< . if YLFN=1 if YDATEI'="" if $order(^WWW003(0,YDATEI,YLFN))="" set YROW=18,YCOL=80
      if (mOp.Equal(m$.var("YLFN").get(),1)) {
        if (mOp.NotEqual(m$.var("YDATEI").get(),"")) {
          if (mOp.Equal(m$.Fnc.$order(m$.var("^WWW003",0,m$.var("YDATEI").get(),m$.var("YLFN").get())),"")) {
            YROW.set(18);
            YCOL.set(80);
          }
        }
      }
      //<< . if $length(YLANGE)=4 if $extract(YLANGE,3)'=0 set YROW=$extract(YLANGE,1,2),YCOL=$extract(YLANGE,3,4)
      if (mOp.Equal(m$.Fnc.$length(m$.var("YLANGE").get()),4)) {
        if (mOp.NotEqual(m$.Fnc.$extract(m$.var("YLANGE").get(),3),0)) {
          YROW.set(m$.Fnc.$extract(m$.var("YLANGE").get(),1,2));
          YCOL.set(m$.Fnc.$extract(m$.var("YLANGE").get(),3,4));
        }
      }
      //<< . if $length(YLANGE)=3 if $extract(YLANGE,2)'=0 set YROW=$extract(YLANGE),YCOL=$extract(YLANGE,2,3)
      if (mOp.Equal(m$.Fnc.$length(m$.var("YLANGE").get()),3)) {
        if (mOp.NotEqual(m$.Fnc.$extract(m$.var("YLANGE").get(),2),0)) {
          YROW.set(m$.Fnc.$extract(m$.var("YLANGE").get()));
          YCOL.set(m$.Fnc.$extract(m$.var("YLANGE").get(),2,3));
        }
      }
      //<< . if YLANGE?1.N1"-"1.N set YROW=$piece(YLANGE,"-",1),YCOL=$piece(YLANGE,"-",2)
      if (mOp.Match(m$.var("YLANGE").get(),"1.N1\"-\"1.N")) {
        YROW.set(m$.Fnc.$piece(m$.var("YLANGE").get(),"-",1));
        YCOL.set(m$.Fnc.$piece(m$.var("YLANGE").get(),"-",2));
      }
      //<< . write YCR,"<TEXTAREA ID=""Y"_YFORM_YART_YLFN_""""                                 ;SR17291
      m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<TEXTAREA ID=\"Y",m$.var("YFORM").get()),m$.var("YART").get()),m$.var("YLFN").get()),"\""));
      //<< . write " onkeypress='if (returnKeyHack==true) {return false;}' onkeyup='returnKeyHack=false;';" ;SR17251
      m$.Cmd.Write(" onkeypress='if (returnKeyHack==true) {return false;}' onkeyup='returnKeyHack=false;';");
      //<< . write " NAME=""Y"_YFORM_YART_YLFN_""" ROWS="""_YROW_""" COLS="""_YCOL
      m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(" NAME=\"Y",m$.var("YFORM").get()),m$.var("YART").get()),m$.var("YLFN").get()),"\" ROWS=\""),YROW.get()),"\" COLS=\""),YCOL.get()));
      //<< . if YCOL<61  write YCR," WRAP=""physical"""
      if (mOp.Less(YCOL.get(),61)) {
        m$.Cmd.Write(m$.var("YCR").get()," WRAP=\"physical\"");
      }
      //<< . if YCOL'<61 write YCR," WRAP=""virtual"""
      if (mOp.NotLess(YCOL.get(),61)) {
        m$.Cmd.Write(m$.var("YCR").get()," WRAP=\"virtual\"");
      }
      //<< . write YCR
      m$.Cmd.Write(m$.var("YCR").get());
      //<< . ;IF +$PIECE(YSATZ,Y,61)=0 WRITE YCR," TABINDEX="""_YTABX_""""
      //<< . if +$piece(YSATZ,Y,61)=0 if $get(YHID)=2  write YCR," TABINDEX=-1"    ; TAB STOP IN READ ONLY FIELD.14.07.06;FAN
      if (mOp.Equal(mOp.Positive(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),61)),0)) {
        if (mOp.Equal(m$.Fnc.$get(m$.var("YHID")),2)) {
          m$.Cmd.Write(m$.var("YCR").get()," TABINDEX=-1");
        }
      }
      //<< . if +$piece(YSATZ,Y,61)=0 if $get(YHID)'=2 write YCR," TABINDEX="""_YTABX_""""
      if (mOp.Equal(mOp.Positive(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),61)),0)) {
        if (mOp.NotEqual(m$.Fnc.$get(m$.var("YHID")),2)) {
          m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat(" TABINDEX=\"",m$.var("YTABX").get()),"\""));
        }
      }
      //<< . if +$piece(YSATZ,Y,61)'=0 write YCR," TABINDEX="""_+$piece(YSATZ,Y,61)_""""
      if (mOp.NotEqual(mOp.Positive(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),61)),0)) {
        m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat(" TABINDEX=\"",mOp.Positive(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),61))),"\""));
      }
      //<< . ;
      //<< . ; *** EXECUTE ***
      //<< . if $piece(YSATZ,Y,99)'="" xecute $piece(YSATZ,Y,99)  ;EXECUTE INNERHALB EINES EINGABEFELDES GUE ;EXECUTE inside
      if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),99),"")) {
        m$.Cmd.Xecute(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),99));
      }
      //<< . if $$EXIST^%R("Y"_YFORM_YART_YLFN_"onField.OBJ",$get(YUCI)) write YCR xecute "DO ^Y"_YFORM_YART_YLFN_"onField"  ;CUSTOMIZED EXECUTE;FIS;24947;10.01.04
      if (mOp.Logical(m$.fnc$("$R.EXIST",mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("Y",m$.var("YFORM").get()),m$.var("YART").get()),m$.var("YLFN").get()),"onField.OBJ"),m$.Fnc.$get(m$.var("YUCI"))))) {
        m$.Cmd.Write(m$.var("YCR").get());
        m$.Cmd.Xecute(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("DO ^Y",m$.var("YFORM").get()),m$.var("YART").get()),m$.var("YLFN").get()),"onField"));
      }
      //<< . ;
      //<< . write YCR," STYLE="""
      m$.Cmd.Write(m$.var("YCR").get()," STYLE=\"");
      //<< . write "font-family:"
      m$.Cmd.Write("font-family:");
      //<< . if $piece(YSATZ,Y,91)'="" write $piece($get(^WWW100(0,"SCHRIFTART",SPRACHE,$piece(YSATZ,Y,91),1)),Y,1)
      if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),91),"")) {
        m$.Cmd.Write(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW100",0,"SCHRIFTART",m$.var("SPRACHE").get(),m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),91),1)),m$.var("Y").get(),1));
      }
      //<< . if $piece(YSATZ,Y,91)=""  write YCR,"ARIAL"
      if (mOp.Equal(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),91),"")) {
        m$.Cmd.Write(m$.var("YCR").get(),"ARIAL");
      }
      //<< . write "; font-size:10pt"   ;TYBD;27,7,2004;MOZILLA;26159
      m$.Cmd.Write("; font-size:10pt");
      //<< . if $piece(YSATZ,Y,78)'="" write "; "_$piece(YSATZ,Y,78)   ;style
      if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),78),"")) {
        m$.Cmd.Write(mOp.Concat("; ",m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),78)));
      }
      //<< . if YHID=2 do LESEN1                             ; Disabled field      ;TYBD;STYLE NEU;28,7,2007
      if (mOp.Equal(m$.var("YHID").get(),2)) {
        m$.Cmd.Do("LESEN1");
      }
      //<< . if (YPFLICHT=1) || (YART="P") do PFLICHT        ; Mandatory Field
      if ((mOp.Equal(m$.var("YPFLICHT").get(),1)) || (mOp.Equal(m$.var("YART").get(),"P"))) {
        m$.Cmd.Do("PFLICHT");
      }
      //<< . if $$$WWW122FlatControls(YSATZ) write "; border:none; margin:1px; " ;SR18000
      if (mOp.Logical(include.WWWConst.$$$WWW122FlatControls(m$,m$.var("YSATZ")))) {
        m$.Cmd.Write("; border:none; margin:1px; ");
      }
      //<< . write """"
      m$.Cmd.Write("\"");
      //<< . ;
      //<< . if YHID=2 do LESEN                              ; Disabled field
      if (mOp.Equal(m$.var("YHID").get(),2)) {
        m$.Cmd.Do("LESEN");
      }
      //<< . do SAVE
      m$.Cmd.Do("SAVE");
      //<< . if YSTATUS'="" do STAT
      if (mOp.NotEqual(m$.var("YSTATUS").get(),"")) {
        m$.Cmd.Do("STAT");
      }
      //<< . if $piece(YSATZ,Y,82)'="" do READONLY  ;ANDERE FELDER AUF READ ONLY WENN EINGABE ;upon READ when
      if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),82),"")) {
        m$.Cmd.Do("READONLY");
      }
      //<< . if $piece(YSATZ,Y,83)'="" do WRITE     ;ANDERE FELDER AUF WRITE WENN EINGABE ;upon when
      if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),83),"")) {
        m$.Cmd.Do("WRITE");
      }
      //<< . if YJAVA=1 do JAVA^WWWFORM8
      if (mOp.Equal(m$.var("YJAVA").get(),1)) {
        m$.Cmd.Do("WWWFORM8.JAVA");
      }
      //<< . write ">"
      m$.Cmd.Write(">");
      //<< . do
      do {
        //<< . . new I,YZWS
        mVar I = m$.var("I");
        mVar YZWS = m$.var("YZWS");
        m$.newVar(I,YZWS);
        //<< . . for YI=1:1 set YZWS=$piece(YINHALT,"|",YI) quit:$piece(YINHALT,"|",YI,9999)=""  do
        mVar YI = m$.var("YI");
        for (YI.set(1);(true);YI.set(mOp.Add(YI.get(),1))) {
          YZWS.set(m$.Fnc.$piece(m$.var("YINHALT").get(),"|",YI.get()));
          if (mOp.Equal(m$.Fnc.$piece(m$.var("YINHALT").get(),"|",YI.get(),9999),"")) {
            break;
          }
          //<< . . . write $char(13)_$char(10)
          m$.Cmd.Write(mOp.Concat(m$.Fnc.$char(13),m$.Fnc.$char(10)));
          //<< . . . write YZWS  ;TYBD;28,7,2004; KEINE UMSETZUNG IN FELD
          m$.Cmd.Write(YZWS.get());
        }
      } while(false);
      //<< . ;
      //<< . write "</TEXTAREA>"
      m$.Cmd.Write("</TEXTAREA>");
      //<< . do PARASUCH^WWWFORM75
      m$.Cmd.Do("WWWFORM75.PARASUCH");
      return include.COMSYS.$$$NO(m$);
    }
    //<< 
    //<< ;---------------------------------------
    //<< ;---------------------------------------
    //<< if (YPARA(7)>0) && (YXTYP=14) do  if YXTYP=14 quit $$$NO   ; *** EARLY EXIT ***
    if ((mOp.Greater(m$.var("YPARA").var(7).get(),0)) && (mOp.Equal(m$.var("YXTYP").get(),14))) {
      do {
        //<< . if $piece($get(^WWW012(0,0,1)),Y,82)'=1 set YXTYP=6 quit  ;KEIN EVENTBROKER ;no
        if (mOp.NotEqual(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW012",0,0,1)),m$.var("Y").get(),82),1)) {
          mVar YXTYP = m$.var("YXTYP");
          YXTYP.set(6);
          break;
        }
        //<< . if '+$get(^SysSetup("FieldEvents")) do ^WWWFORM72
        if (mOp.Not(mOp.Positive(m$.Fnc.$get(m$.var("^SysSetup","FieldEvents"))))) {
          m$.Cmd.Do("WWWFORM72.main");
        }
        //<< . if +$get(^SysSetup("FieldEvents"))  do WWWFORM72^PJOWWWFORM72             ; FIXME : replace/remove?
        if (mOp.Logical(mOp.Positive(m$.Fnc.$get(m$.var("^SysSetup","FieldEvents"))))) {
          m$.Cmd.Do("PJOWWWFORM72.WWWFORM72");
        }
        //<< . set YXTYP=14
        mVar YXTYP = m$.var("YXTYP");
        YXTYP.set(14);
      } while (false);
      if (mOp.Equal(m$.var("YXTYP").get(),14)) {
        return include.COMSYS.$$$NO(m$);
      }
    }
    //<< ;multiple mit auswahl und select ;by means of Selection and
    //<< 
    //<< if $get(YPARA(1))'="" if $get(YPARA(20))=1 if ($get(YPARA(21))=1) || '$data(^WWWSOR(YUSER,2)) set YPARA(7)=0,YXTYP=0
    if (mOp.NotEqual(m$.Fnc.$get(m$.var("YPARA").var(1)),"")) {
      if (mOp.Equal(m$.Fnc.$get(m$.var("YPARA").var(20)),1)) {
        if ((mOp.Equal(m$.Fnc.$get(m$.var("YPARA").var(21)),1)) || mOp.Not(m$.Fnc.$data(m$.var("^WWWSOR",m$.var("YUSER").get(),2)))) {
          mVar YPARA = m$.var("YPARA");
          YPARA.var(7).set(0);
          mVar YXTYP = m$.var("YXTYP");
          YXTYP.set(0);
        }
      }
    }
    //<< 
    //<< ;---------------------------------------
    //<< ; RADIO BUTTONS                                             ; *** EXECUTE ***
    //<< ;   D99     $$$WWW122ExecuteWithinDataField()    ; Execute At Form Construction (Within)
    //<< ;
    //<< ;  ^WWWSOR2(YUSER,2,idxEnum,Enum) = Combo display string
    //<< ;---------------------------------------
    //<< if YXTYP'=4 if YXTYP'=6 if YXTYP'=1 if YART'="P" if YPARA(7)>1 if YXTYP=2||(YXTYP=11) do  quit $$$NO  ; *** EARLY EXIT ***
    if (mOp.NotEqual(m$.var("YXTYP").get(),4)) {
      if (mOp.NotEqual(m$.var("YXTYP").get(),6)) {
        if (mOp.NotEqual(m$.var("YXTYP").get(),1)) {
          if (mOp.NotEqual(m$.var("YART").get(),"P")) {
            if (mOp.Greater(m$.var("YPARA").var(7).get(),1)) {
              if (mOp.Equal(m$.var("YXTYP").get(),2) || (mOp.Equal(m$.var("YXTYP").get(),11))) {
                //<< . if $piece(YVOR,Y,83)'="" write YCR,"<FIELDSET>"
                if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),83),"")) {
                  m$.Cmd.Write(m$.var("YCR").get(),"<FIELDSET>");
                }
                //<< . if $piece(YVOR,Y,83)="" if $get(YDREID)'=1 write YCR,"<FIELDSET STYLE=""border-color:"_YLIGHTGREY_""">"
                if (mOp.Equal(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),83),"")) {
                  if (mOp.NotEqual(m$.Fnc.$get(m$.var("YDREID")),1)) {
                    m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat("<FIELDSET STYLE=\"border-color:",m$.var("YLIGHTGREY").get()),"\">"));
                  }
                }
                //<< . if $piece(YVOR,Y,83)="" if +$get(YDREID)=1 write YCR,"<FIELDSET STYLE=""border-color-dark:"_YLIGHTGREY_"; border-color-light:"_YDARKGRAY_";"">"  ;FIS;31.03.04;25445;RAHMEN 2-FARBIG
                if (mOp.Equal(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),83),"")) {
                  if (mOp.Equal(mOp.Positive(m$.Fnc.$get(m$.var("YDREID"))),1)) {
                    m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<FIELDSET STYLE=\"border-color-dark:",m$.var("YLIGHTGREY").get()),"; border-color-light:"),m$.var("YDARKGRAY").get()),";\">"));
                  }
                }
                //<< . if YPARA(7)=3 if YXTYP'=2 set YXTYP=11   ;WENN 2 UND NICHT VERTIKAL DANN HORIZONTAL ;when And Not vertical horizontal
                if (mOp.Equal(m$.var("YPARA").var(7).get(),3)) {
                  if (mOp.NotEqual(m$.var("YXTYP").get(),2)) {
                    mVar YXTYP = m$.var("YXTYP");
                    YXTYP.set(11);
                  }
                }
                //<< . if $piece(YSATZ,Y,70)=1 write YCR,"<LEGEND>"_$get(YNAME)_"</LEGEND>",YCR  ;GRUPPE ;group
                if (mOp.Equal(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),70),1)) {
                  m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat("<LEGEND>",m$.Fnc.$get(m$.var("YNAME"))),"</LEGEND>"),m$.var("YCR").get());
                }
                //<< . set YSORT=""
                mVar YSORT = m$.var("YSORT");
                YSORT.set("");
                //<< . for  set YSORT=$order(^WWWSOR(YUSER,2,YSORT),$get(YPARA(29))) quit:YSORT=""  set YPARA(5)="" for  set YPARA(5)=$order(^WWWSOR(YUSER,2,YSORT,YPARA(5)),$get(YPARA(29))) quit:YPARA(5)=""  do
                for (;true;) {
                  YSORT.set(m$.Fnc.$order(m$.var("^WWWSOR",m$.var("YUSER").get(),2,YSORT.get()),m$.Fnc.$get(m$.var("YPARA").var(29))));
                  if (mOp.Equal(YSORT.get(),"")) {
                    break;
                  }
                  mVar YPARA = m$.var("YPARA");
                  YPARA.var(5).set("");
                  for (;true;) {
                    YPARA.var(5).set(m$.Fnc.$order(m$.var("^WWWSOR",m$.var("YUSER").get(),2,YSORT.get(),YPARA.var(5).get()),m$.Fnc.$get(YPARA.var(29))));
                    if (mOp.Equal(YPARA.var(5).get(),"")) {
                      break;
                    }
                    //<< . . if +YPARA(12)'=0 set YA=$piece($get(^WWWSOR(YUSER,2,YSORT,YPARA(5))),"(",1)
                    if (mOp.NotEqual(mOp.Positive(YPARA.var(12).get()),0)) {
                      mVar YA = m$.var("YA");
                      YA.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWWSOR",m$.var("YUSER").get(),2,YSORT.get(),YPARA.var(5).get())),"(",1));
                    }
                    //<< . . if +YPARA(12)=0  set YA=$get(^WWWSOR(YUSER,2,YSORT,YPARA(5)))
                    if (mOp.Equal(mOp.Positive(YPARA.var(12).get()),0)) {
                      mVar YA = m$.var("YA");
                      YA.set(m$.Fnc.$get(m$.var("^WWWSOR",m$.var("YUSER").get(),2,YSORT.get(),YPARA.var(5).get())));
                    }
                    //<< . . if (YHID=2) && (YSTATUS'="") write YCR,"<A" do STAT write ">"
                    if ((mOp.Equal(m$.var("YHID").get(),2)) && (mOp.NotEqual(m$.var("YSTATUS").get(),""))) {
                      m$.Cmd.Write(m$.var("YCR").get(),"<A");
                      m$.Cmd.Do("STAT");
                      m$.Cmd.Write(">");
                    }
                    //<< . . write YCR,"<INPUT TYPE=""RADIO"" NAME=""Y"_YFORM_YART_YLFN_""" VALUE="""_YPARA(5)_""""
                    m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<INPUT TYPE=\"RADIO\" NAME=\"Y",m$.var("YFORM").get()),m$.var("YART").get()),m$.var("YLFN").get()),"\" VALUE=\""),YPARA.var(5).get()),"\""));
                    //<< . . if YINHALT=YPARA(5) write YCR," CHECKED=""CHECKED"""
                    if (mOp.Equal(m$.var("YINHALT").get(),YPARA.var(5).get())) {
                      m$.Cmd.Write(m$.var("YCR").get()," CHECKED=\"CHECKED\"");
                    }
                    //<< . . ;WRITE YCR
                    //<< . . if +$piece(YSATZ,Y,61)=0 if $get(YHID)=2  write YCR," TABINDEX=-1"    ; TAB STOP IN READ ONLY FIELD.14.07.06;FAN
                    if (mOp.Equal(mOp.Positive(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),61)),0)) {
                      if (mOp.Equal(m$.Fnc.$get(m$.var("YHID")),2)) {
                        m$.Cmd.Write(m$.var("YCR").get()," TABINDEX=-1");
                      }
                    }
                    //<< . . if +$piece(YSATZ,Y,61)=0 if $get(YHID)'=2 write YCR," TABINDEX="""_YTABX_""""
                    if (mOp.Equal(mOp.Positive(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),61)),0)) {
                      if (mOp.NotEqual(m$.Fnc.$get(m$.var("YHID")),2)) {
                        m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat(" TABINDEX=\"",m$.var("YTABX").get()),"\""));
                      }
                    }
                    //<< . . if +$piece(YSATZ,Y,61)'=0 write YCR," TABINDEX="""_+$piece(YSATZ,Y,61)_""""
                    if (mOp.NotEqual(mOp.Positive(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),61)),0)) {
                      m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat(" TABINDEX=\"",mOp.Positive(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),61))),"\""));
                    }
                    //<< . . ;
                    //<< . . ; *** EXECUTE ***
                    //<< . . if $piece(YSATZ,Y,99)'="" xecute $piece(YSATZ,Y,99)  ;EXECUTE INNERHALB EINES EINGABEFELDES GUE ;EXECUTE inside
                    if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),99),"")) {
                      m$.Cmd.Xecute(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),99));
                    }
                    //<< . . if $$EXIST^%R("Y"_YFORM_YART_YLFN_"onField.OBJ",$get(YUCI)) write YCR xecute "DO ^Y"_YFORM_YART_YLFN_"onField"  ;CUSTOMIZED EXECUTE;FIS;24947;10.01.04
                    if (mOp.Logical(m$.fnc$("$R.EXIST",mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("Y",m$.var("YFORM").get()),m$.var("YART").get()),m$.var("YLFN").get()),"onField.OBJ"),m$.Fnc.$get(m$.var("YUCI"))))) {
                      m$.Cmd.Write(m$.var("YCR").get());
                      m$.Cmd.Xecute(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("DO ^Y",m$.var("YFORM").get()),m$.var("YART").get()),m$.var("YLFN").get()),"onField"));
                    }
                    //<< . . ;
                    //<< . . write YCR," style="""   ;TYBD; STYLE NEU;28,7,2004
                    m$.Cmd.Write(m$.var("YCR").get()," style=\"");
                    //<< . . if $piece(YSATZ,Y,78)'="" write YCR,"; "_$piece(YSATZ,Y,78)   ;style
                    if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),78),"")) {
                      m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat("; ",m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),78)));
                    }
                    //<< . . if YHID=2 do LESEN1                           ; Disabled field
                    if (mOp.Equal(m$.var("YHID").get(),2)) {
                      m$.Cmd.Do("LESEN1");
                    }
                    //<< . . if (YPFLICHT=1) || (YART="P") do PFLICHT      ; Mandatory Field
                    if ((mOp.Equal(m$.var("YPFLICHT").get(),1)) || (mOp.Equal(m$.var("YART").get(),"P"))) {
                      m$.Cmd.Do("PFLICHT");
                    }
                    //<< . . write """"  ;ENDE STYLE;TYBD;28,7,,2004
                    m$.Cmd.Write("\"");
                    //<< . . ;
                    //<< . . do SAVE
                    m$.Cmd.Do("SAVE");
                    //<< . . if YHID=2 if YHTMFORM="WWW2" write " disabled"
                    if (mOp.Equal(m$.var("YHID").get(),2)) {
                      if (mOp.Equal(m$.var("YHTMFORM").get(),"WWW2")) {
                        m$.Cmd.Write(" disabled");
                      }
                    }
                    //<< . . if YHID=2 do LESEN
                    if (mOp.Equal(m$.var("YHID").get(),2)) {
                      m$.Cmd.Do("LESEN");
                    }
                    //<< . . if $piece(YSATZ,Y,82)'="" do READONLY  ;ANDERE FELDER AUF READ ONLY WENN EINGABE ;upon READ when
                    if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),82),"")) {
                      m$.Cmd.Do("READONLY");
                    }
                    //<< . . if $piece(YSATZ,Y,83)'="" do WRITE     ;ANDERE FELDER AUF WRITE WENN EINGABE ;upon when
                    if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),83),"")) {
                      m$.Cmd.Do("WRITE");
                    }
                    //<< . . if (YHID'=2) && (YSTATUS'="") if YSORT=$order(^WWWSOR(YUSER,2,"")) do STAT    ;NUR EIN MAL ;only uni- sometimes
                    if ((mOp.NotEqual(m$.var("YHID").get(),2)) && (mOp.NotEqual(m$.var("YSTATUS").get(),""))) {
                      if (mOp.Equal(YSORT.get(),m$.Fnc.$order(m$.var("^WWWSOR",m$.var("YUSER").get(),2,"")))) {
                        m$.Cmd.Do("STAT");
                      }
                    }
                    //<< . . if YJAVA=1 do JAVA^WWWFORM8
                    if (mOp.Equal(m$.var("YJAVA").get(),1)) {
                      m$.Cmd.Do("WWWFORM8.JAVA");
                    }
                    //<< . . if $translate($piece(YA," ",2,99)," -")="" set $piece(YA," ",2)=YPARA(5)
                    if (mOp.Equal(m$.Fnc.$translate(m$.Fnc.$piece(m$.var("YA").get()," ",2,99)," -"),"")) {
                      m$.pieceVar(m$.var("YA")," ",2).set(YPARA.var(5).get());
                    }
                    //<< . . write "> "_$piece(YA," ",2,99)
                    m$.Cmd.Write(mOp.Concat("> ",m$.Fnc.$piece(m$.var("YA").get()," ",2,99)));
                    //<< . . write YCR,"</INPUT>"
                    m$.Cmd.Write(m$.var("YCR").get(),"</INPUT>");
                    //<< . . if (YHID=2) && (YSTATUS'="") write YCR,"</A>"
                    if ((mOp.Equal(m$.var("YHID").get(),2)) && (mOp.NotEqual(m$.var("YSTATUS").get(),""))) {
                      m$.Cmd.Write(m$.var("YCR").get(),"</A>");
                    }
                    //<< . . ;YXTYP=11 = HORIZONTALE ANORDNUMG
                    //<< . . if YXTYP'=11 if $piece(YVOR,Y,44)<3 if ($order(^WWWSOR(YUSER,2,YSORT,YPARA(5)))'="") || ($order(^WWWSOR(YUSER,2,YSORT))'="") write "<BR>"  ;EINEN ZEILENFORSCHUB, WENN RADIO
                    if (mOp.NotEqual(m$.var("YXTYP").get(),11)) {
                      if (mOp.Less(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),44),3)) {
                        if ((mOp.NotEqual(m$.Fnc.$order(m$.var("^WWWSOR",m$.var("YUSER").get(),2,YSORT.get(),YPARA.var(5).get())),"")) || (mOp.NotEqual(m$.Fnc.$order(m$.var("^WWWSOR",m$.var("YUSER").get(),2,YSORT.get())),""))) {
                          m$.Cmd.Write("<BR>");
                        }
                      }
                    }
                  }
                }
                //<< . ;
                //<< . write YCR,"</FIELDSET>"
                m$.Cmd.Write(m$.var("YCR").get(),"</FIELDSET>");
                return include.COMSYS.$$$NO(m$);
              }
            }
          }
        }
      }
    }
    //<< 
    //<< ;---------------------------------------
    //<< ;MULTIFELDER AUSWAHL UND SELECT ;Selection And
    //<< ;---------------------------------------
    //<< if +YPARA(7)=0 if (YXTYP=4) || (YXTYP=6) do  ;SELECT OHNE SELECT ;without
    if (mOp.Equal(mOp.Positive(m$.var("YPARA").var(7).get()),0)) {
      if ((mOp.Equal(m$.var("YXTYP").get(),4)) || (mOp.Equal(m$.var("YXTYP").get(),6))) {
        //<< . set YPARA(7)=4
        mVar YPARA = m$.var("YPARA");
        YPARA.var(7).set(4);
        //<< . if YINHALT="" set ^WWWSOR(YUSER,2," "," ") = $$^WWWNBSP("    ")
        if (mOp.Equal(m$.var("YINHALT").get(),"")) {
          m$.var("^WWWSOR",m$.var("YUSER").get(),2," "," ").set(m$.fnc$("WWWNBSP.main","    "));
        }
        //<< . ;IF YINHALT'="" SET ^WWWSOR(YUSER,2," ",YINHALT)=YINHALT  ;WENN INHALT ABER KEINE RELATION ANGEZEIGT WIRD BEI SELECTFELDERN
        //<< . set YPARA(55)=0
        YPARA.var(55).set(0);
      }
    }
    //<< 
    //<< ;---------------------------------------
    //<< ;---------------------------------------
    //<< if YPARA(7)<2 if YART="P" if YPARA(1)'="" if YFOART'=7 if +YPARA(20)=0 do  ;SELECT OHNE SELECT PRIMÄRSCHLUESSEL ;without
    if (mOp.Less(m$.var("YPARA").var(7).get(),2)) {
      if (mOp.Equal(m$.var("YART").get(),"P")) {
        if (mOp.NotEqual(m$.var("YPARA").var(1).get(),"")) {
          if (mOp.NotEqual(m$.var("YFOART").get(),7)) {
            if (mOp.Equal(mOp.Positive(m$.var("YPARA").var(20).get()),0)) {
              //<< . set YPARA(7)=4
              mVar YPARA = m$.var("YPARA");
              YPARA.var(7).set(4);
              //<< . set ^WWWSOR(YUSER,2," "," ") = $$^WWWNBSP("    ")
              m$.var("^WWWSOR",m$.var("YUSER").get(),2," "," ").set(m$.fnc$("WWWNBSP.main","    "));
              //<< . set YPARA(55)=0
              YPARA.var(55).set(0);
            }
          }
        }
      }
    }
    //<< 
    //<< ;---------------------------------------
    //<< ;                                                           ; *** EXECUTE ***
    //<< ;  ^WWWSOR2(YUSER,2,idxEnum,Enum) = Combo display string
    //<< ;---------------------------------------
    //<< if YPARA(7)>1 do  quit $$$NO                           ; *** EARLY EXIT ***
    if (mOp.Greater(m$.var("YPARA").var(7).get(),1)) {
      //<< . if YLANGE<30 set YLANGE=80
      if (mOp.Less(m$.var("YLANGE").get(),30)) {
        mVar YLANGE = m$.var("YLANGE");
        YLANGE.set(80);
      }
      //<< . if (YHID=2) && (YSTATUS'="") write YCR,"<DIV" do STAT write ">" ;SR17514   was "<A"
      if ((mOp.Equal(m$.var("YHID").get(),2)) && (mOp.NotEqual(m$.var("YSTATUS").get(),""))) {
        m$.Cmd.Write(m$.var("YCR").get(),"<DIV");
        m$.Cmd.Do("STAT");
        m$.Cmd.Write(">");
      }
      //<< . write YCR,"<select"
      m$.Cmd.Write(m$.var("YCR").get(),"<select");
      //<< . write YCR," NAME=""Y"_YFORM_YART_YLFN_""""
      m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(" NAME=\"Y",m$.var("YFORM").get()),m$.var("YART").get()),m$.var("YLFN").get()),"\""));
      //<< . write " ID=""Y"_YFORM_YART_YLFN_""""          ;SR17253
      m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(" ID=\"Y",m$.var("YFORM").get()),m$.var("YART").get()),m$.var("YLFN").get()),"\""));
      //<< . if YXTYP=6 write YCR," MULTIPLE=MULTIPLE" do
      if (mOp.Equal(m$.var("YXTYP").get(),6)) {
        m$.Cmd.Write(m$.var("YCR").get()," MULTIPLE=MULTIPLE");
        //<< . . if $piece(YSATZ,Y,30)<1 set $piece(YSATZ,Y,30)=8
        if (mOp.Less(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),30),1)) {
          m$.pieceVar(m$.var("YSATZ"),m$.var("Y").get(),30).set(8);
        }
        //<< . . set:YPARA(7)>$piece(YSATZ,Y,30) YPARA(7)=$piece(YSATZ,Y,30) write YCR," SIZE="_YPARA(7)
        if (mOp.Greater(m$.var("YPARA").var(7).get(),m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),30))) {
          m$.var("YPARA",7).set(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),30));
        }
        m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(" SIZE=",m$.var("YPARA").var(7).get()));
      }
      //<< . ;
      //<< . if +$piece(YSATZ,Y,61)=0 if $get(YHID)=2  write YCR," TABINDEX=-1"    ; TAB STOP IN READ ONLY FIELD.14.07.06;FAN
      if (mOp.Equal(mOp.Positive(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),61)),0)) {
        if (mOp.Equal(m$.Fnc.$get(m$.var("YHID")),2)) {
          m$.Cmd.Write(m$.var("YCR").get()," TABINDEX=-1");
        }
      }
      //<< . if +$piece(YSATZ,Y,61)=0 if $get(YHID)'=2 write YCR," TABINDEX="""_YTABX_""""
      if (mOp.Equal(mOp.Positive(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),61)),0)) {
        if (mOp.NotEqual(m$.Fnc.$get(m$.var("YHID")),2)) {
          m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat(" TABINDEX=\"",m$.var("YTABX").get()),"\""));
        }
      }
      //<< . if +$piece(YSATZ,Y,61)'=0 write YCR," TABINDEX="""_+$piece(YSATZ,Y,61)_""""
      if (mOp.NotEqual(mOp.Positive(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),61)),0)) {
        m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat(" TABINDEX=\"",mOp.Positive(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),61))),"\""));
      }
      //<< . ;
      //<< . ; *** EXECUTE ***
      //<< . if $piece(YSATZ,Y,99)'="" xecute $piece(YSATZ,Y,99)  ;EXECUTE INNERHALB EINES EINGABEFELDES GUE ;EXECUTE inside
      if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),99),"")) {
        m$.Cmd.Xecute(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),99));
      }
      //<< . if $$EXIST^%R("Y"_YFORM_YART_YLFN_"onField.OBJ",$get(YUCI)) write YCR xecute "DO ^Y"_YFORM_YART_YLFN_"onField"  ;CUSTOMIZED EXECUTE;FIS;24947;10.01.04
      if (mOp.Logical(m$.fnc$("$R.EXIST",mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("Y",m$.var("YFORM").get()),m$.var("YART").get()),m$.var("YLFN").get()),"onField.OBJ"),m$.Fnc.$get(m$.var("YUCI"))))) {
        m$.Cmd.Write(m$.var("YCR").get());
        m$.Cmd.Xecute(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("DO ^Y",m$.var("YFORM").get()),m$.var("YART").get()),m$.var("YLFN").get()),"onField"));
      }
      //<< . ;
      //<< . if $piece(YSATZ,Y,82)'="" do READONLY  ;ANDERE FELDER AUF READ ONLY WENN EINGABE ;upon READ when
      if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),82),"")) {
        m$.Cmd.Do("READONLY");
      }
      //<< . if $piece(YSATZ,Y,83)'="" do WRITE     ;ANDERE FELDER AUF WRITE WENN EINGABE ;upon when
      if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),83),"")) {
        m$.Cmd.Do("WRITE");
      }
      //<< . ;
      //<< . write YCR," style="""  ;TYBD;STYLE NEW;28,7,2004;26159
      m$.Cmd.Write(m$.var("YCR").get()," style=\"");
      //<< . IF (YPFLICHT'=1) && (YART'="P") WRITE ";padding-top:0 ;padding-bottom:0; line-Height:15px;" ;SR17861
      if ((mOp.NotEqual(m$.var("YPFLICHT").get(),1)) && (mOp.NotEqual(m$.var("YART").get(),"P"))) {
        m$.Cmd.Write(";padding-top:0 ;padding-bottom:0; line-Height:15px;");
      }
      //<< . ;SR17861 write "padding-top:0 ;padding-bottom:0"   ;style
      //<< . if $piece(YSATZ,Y,78)'="" write "; "_$piece(YSATZ,Y,78)   ;style
      if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),78),"")) {
        m$.Cmd.Write(mOp.Concat("; ",m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),78)));
      }
      //<< . if $get(YPARA(55))>1 do
      if (mOp.Greater(m$.Fnc.$get(m$.var("YPARA").var(55)),1)) {
        do {
          //<< . . quit:$piece(YSATZ,Y,91)'=""  ;SCHRIFTART NEU ;recent
          if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),91),"")) {
            break;
          }
          //<< . . ;SR17253 WRITE "; font-face: 'Courier New'"
          //<< . . write "; font-family: 'Courier New'"
          m$.Cmd.Write("; font-family: 'Courier New'");
        } while (false);
      }
      //<< . ;
      //<< . if +$piece(YSATZ,Y,88)'=0 write "; width:"_($piece(YSATZ,Y,88)*8)_"px"
      if (mOp.NotEqual(mOp.Positive(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),88)),0)) {
        m$.Cmd.Write(mOp.Concat(mOp.Concat("; width:",(mOp.Multiply(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),88),8))),"px"));
      }
      //<< . if $piece(YSATZ,Y,91)'="" do                        ;SCHRIFTART NEU ;recent
      if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),91),"")) {
        //<< . . ;SR17253 WRITE "; font-face: '"  _$PIECE($GET(^WWW100(0,"SCHRIFTART",SPRACHE,$PIECE(YSATZ,Y,91),1)),Y,1)_"'"
        //<< . . write "; font-family: "_$piece($get(^WWW100(0,"SCHRIFTART",SPRACHE,$piece(YSATZ,Y,91),1)),Y,1)_";"
        m$.Cmd.Write(mOp.Concat(mOp.Concat("; font-family: ",m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW100",0,"SCHRIFTART",m$.var("SPRACHE").get(),m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),91),1)),m$.var("Y").get(),1)),";"));
      }
      //<< . ;
      //<< . if (YPFLICHT=1) || (YART="P") do PFLICHT        ; Mandatory Field
      if ((mOp.Equal(m$.var("YPFLICHT").get(),1)) || (mOp.Equal(m$.var("YART").get(),"P"))) {
        m$.Cmd.Do("PFLICHT");
      }
      //<< . if YHID=2 do LESEN1                             ; Disabled field  ;SR17514
      if (mOp.Equal(m$.var("YHID").get(),2)) {
        m$.Cmd.Do("LESEN1");
      }
      //<< . IF (YHID'=2) &&(YPFLICHT'=1) && (YART'="P") WRITE "; margin-top:1px; margin-bottom:1px; background-color:white; " ;SR17861
      if ((mOp.NotEqual(m$.var("YHID").get(),2)) && (mOp.NotEqual(m$.var("YPFLICHT").get(),1)) && (mOp.NotEqual(m$.var("YART").get(),"P"))) {
        m$.Cmd.Write("; margin-top:1px; margin-bottom:1px; background-color:white; ");
      }
      //<< . if $$$WWW122FlatControls(YSATZ) write "; border:none; margin:1px; " ;SR18000
      if (mOp.Logical(include.WWWConst.$$$WWW122FlatControls(m$,m$.var("YSATZ")))) {
        m$.Cmd.Write("; border:none; margin:1px; ");
      }
      //<< . write """"  ;STYLE ENDE ;termination
      m$.Cmd.Write("\"");
      //<< . ;
      //<< . if YJAVA=1 if YHID'=2 do JAVA^WWWFORM8
      if (mOp.Equal(m$.var("YJAVA").get(),1)) {
        if (mOp.NotEqual(m$.var("YHID").get(),2)) {
          m$.Cmd.Do("WWWFORM8.JAVA");
        }
      }
      //<< . do
      do {
        //<< . . if $get(YHTMFORM)'="WWW2" if YXTYP=6 if YPARA(7)>100 quit  ;KEINE PRÜFUNG MEHR ;no quiz more
        if (mOp.NotEqual(m$.Fnc.$get(m$.var("YHTMFORM")),"WWW2")) {
          if (mOp.Equal(m$.var("YXTYP").get(),6)) {
            if (mOp.Greater(m$.var("YPARA").var(7).get(),100)) {
              break;
            }
          }
        }
        //<< . . do SAVE
        m$.Cmd.Do("SAVE");
      } while(false);
      //<< . ;
      //<< . if +$$$WWW012ActivateFastSelect(YVOR1)=1 write YCR," onkeyup=""QUICKSELECT(this, event);"""  ;FIS;06.08.03;24121;QUICK SELECT-AUSWAHL
      if (mOp.Equal(mOp.Positive(include.WWWConst.$$$WWW012ActivateFastSelect(m$,m$.var("YVOR1"))),1)) {
        m$.Cmd.Write(m$.var("YCR").get()," onkeyup=\"QUICKSELECT(this, event);\"");
      }
      //<< . if YHID=2 do LESEN
      if (mOp.Equal(m$.var("YHID").get(),2)) {
        m$.Cmd.Do("LESEN");
      }
      //<< . if YHID=2 if YHTMFORM="WWW2" write " DISABLED" ; SR13571: Fake a readOnly property. Changed to Disabled this works
      if (mOp.Equal(m$.var("YHID").get(),2)) {
        if (mOp.Equal(m$.var("YHTMFORM").get(),"WWW2")) {
          m$.Cmd.Write(" DISABLED");
        }
      }
      //<< . if (YHID'=2) && (YSTATUS'="") do STAT
      if ((mOp.NotEqual(m$.var("YHID").get(),2)) && (mOp.NotEqual(m$.var("YSTATUS").get(),""))) {
        m$.Cmd.Do("STAT");
      }
      //<< . write ">"
      m$.Cmd.Write(">");
      //<< . ;
      //<< . if YINHALT="" do
      if (mOp.Equal(m$.var("YINHALT").get(),"")) {
        //<< . . write YCR,"<option value="""">"_$$^WWWNBSP("    ")    ; SELECTED=SELECTED>"
        m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat("<option value=\"\">",m$.fnc$("WWWNBSP.main","    ")));
        //<< . . write "</option>"
        m$.Cmd.Write("</option>");
      }
      //<< . ;
      //<< . if YINHALT'="" if YHID'=2 write YCR,"<option value=""""> </option>"
      if (mOp.NotEqual(m$.var("YINHALT").get(),"")) {
        if (mOp.NotEqual(m$.var("YHID").get(),2)) {
          m$.Cmd.Write(m$.var("YCR").get(),"<option value=\"\"> </option>");
        }
      }
      //<< . set YLANGE3=0
      mVar YLANGE3 = m$.var("YLANGE3");
      YLANGE3.set(0);
      //<< . set YSORT=""                ;WENN MULTIAUSWAHL UND DATEN VORHANDEN, DANN AUSWAHL AN ANFANG
      mVar YSORT = m$.var("YSORT");
      YSORT.set("");
      //<< . if YXTYP=6 if YINHALT'="" for  set YSORT=$order(^WWWSOR(YUSER,2,YSORT),$get(YPARA(29))) quit:YSORT=""  set YPARA(5)="" for  set YPARA(5)=$order(^WWWSOR(YUSER,2,YSORT,YPARA(5)),$get(YPARA(29))) quit:YPARA(5)=""  do
      if (mOp.Equal(m$.var("YXTYP").get(),6)) {
        if (mOp.NotEqual(m$.var("YINHALT").get(),"")) {
          for (;true;) {
            YSORT.set(m$.Fnc.$order(m$.var("^WWWSOR",m$.var("YUSER").get(),2,YSORT.get()),m$.Fnc.$get(m$.var("YPARA").var(29))));
            if (mOp.Equal(YSORT.get(),"")) {
              break;
            }
            mVar YPARA = m$.var("YPARA");
            YPARA.var(5).set("");
            for (;true;) {
              YPARA.var(5).set(m$.Fnc.$order(m$.var("^WWWSOR",m$.var("YUSER").get(),2,YSORT.get(),YPARA.var(5).get()),m$.Fnc.$get(YPARA.var(29))));
              if (mOp.Equal(YPARA.var(5).get(),"")) {
                break;
              }
              //<< . . set YA=$get(^WWWSOR(YUSER,2,YSORT,YPARA(5)))
              mVar YA = m$.var("YA");
              YA.set(m$.Fnc.$get(m$.var("^WWWSOR",m$.var("YUSER").get(),2,YSORT.get(),YPARA.var(5).get())));
              //<< . . set YINHALT1=$translate(YINHALT,";",",")
              mVar YINHALT1 = m$.var("YINHALT1");
              YINHALT1.set(m$.Fnc.$translate(m$.var("YINHALT").get(),";",","));
              //<< . . ;IF $FIND(","_YINHALT1_",",","_YPARA(5)_",") DO
              //<< . . ;IF $FIND(","_$$^WWWUPER(YINHALT1)_",",","_$TRANSLATE($$^WWWUPER($$^WWWUML(YPARA(5))),";",",")_",") DO  ;TYBD;28,7,2004;TYBD;WENN UMLAUT;
              //<< . . if $find(","_$zconvert(YINHALT1,"U")_",",","_$translate($zconvert($$^WWWUML(YPARA(5)),"U"),";",",")_",") do  ;TYBD;28,7,2004;TYBD;WENN UMLAUT;
              if (mOp.Logical(m$.Fnc.$find(mOp.Concat(mOp.Concat(",",m$.Fnc.$zconvert(YINHALT1.get(),"U")),","),mOp.Concat(mOp.Concat(",",m$.Fnc.$translate(m$.Fnc.$zconvert(m$.fnc$("WWWUML.main",YPARA.var(5).get()),"U"),";",",")),",")))) {
                do {
                  //<< . . . //WRITE YCR,"<option value="""_YPARA(5)_""" SELECTED=SELECTED"        ;***Multi-Select Option START (selected)
                  //<< . . . write YCR,"<option value="""_YPARA(5)
                  m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat("<option value=\"",YPARA.var(5).get()));
                  //<< . . . if ($$$WWW122UserAccessForChange(YSATZ)'=5) write """ SELECTED=SELECTED"  //SR14631   ;***Multi-Select Option START (selected)
                  if ((mOp.NotEqual(include.WWWConst.$$$WWW122UserAccessForChange(m$,m$.var("YSATZ")),5))) {
                    m$.Cmd.Write("\" SELECTED=SELECTED");
                  }
                  //<< . . . if $get(YCOLOR)=1 do FARBE                      ;FARBE AUSWÄHLEN ;colour selection
                  if (mOp.Equal(m$.Fnc.$get(m$.var("YCOLOR")),1)) {
                    m$.Cmd.Do("FARBE");
                  }
                  //<< . . . if $get(YCOLOR1)'="" if YPARA(5)'="" do FARBE1  ;COLOR IN SELECT ;within
                  if (mOp.NotEqual(m$.Fnc.$get(m$.var("YCOLOR1")),"")) {
                    if (mOp.NotEqual(YPARA.var(5).get(),"")) {
                      m$.Cmd.Do("FARBE1");
                    }
                  }
                  //<< . . . if $get(YCOLOR)=2 do  ;SCHRIFTARTEN
                  if (mOp.Equal(m$.Fnc.$get(m$.var("YCOLOR")),2)) {
                    //<< . . . . write YCR," style="""
                    m$.Cmd.Write(m$.var("YCR").get()," style=\"");
                    //<< . . . . ;SR17253 WRITE "font-face: '"    _$PIECE($GET(^WWW100(0,"SCHRIFTART",SPRACHE,YPARA(5),1)),Y,1)_"'"
                    //<< . . . . write "; font-family: '"_$piece($get(^WWW100(0,"SCHRIFTART",SPRACHE,YPARA(5),1)),Y,1)_"'"
                    m$.Cmd.Write(mOp.Concat(mOp.Concat("; font-family: '",m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW100",0,"SCHRIFTART",m$.var("SPRACHE").get(),YPARA.var(5).get(),1)),m$.var("Y").get(),1)),"'"));
                    //<< . . . . write """"
                    m$.Cmd.Write("\"");
                  }
                  //<< . . . ;
                  //<< . . . if $get(YPARA(80))'="" if $find(","_YPARA(80)_",",","_YPARA(5)_",") write YCR," STYLE=""color:"_$piece($get(^WWW100(0,"FARBMARKIERUNG",SPRACHE,1,1)),Y,1)_""""
                  if (mOp.NotEqual(m$.Fnc.$get(YPARA.var(80)),"")) {
                    if (mOp.Logical(m$.Fnc.$find(mOp.Concat(mOp.Concat(",",YPARA.var(80).get()),","),mOp.Concat(mOp.Concat(",",YPARA.var(5).get()),",")))) {
                      m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat(" STYLE=\"color:",m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW100",0,"FARBMARKIERUNG",m$.var("SPRACHE").get(),1,1)),m$.var("Y").get(),1)),"\""));
                    }
                  }
                  //<< . . . if $get(YPARA(81))'="" if $find(","_YPARA(81)_",",","_YPARA(5)_",") write YCR," STYLE=""color:"_$piece($get(^WWW100(0,"FARBMARKIERUNG",SPRACHE,2,1)),Y,1)_""""
                  if (mOp.NotEqual(m$.Fnc.$get(YPARA.var(81)),"")) {
                    if (mOp.Logical(m$.Fnc.$find(mOp.Concat(mOp.Concat(",",YPARA.var(81).get()),","),mOp.Concat(mOp.Concat(",",YPARA.var(5).get()),",")))) {
                      m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat(" STYLE=\"color:",m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW100",0,"FARBMARKIERUNG",m$.var("SPRACHE").get(),2,1)),m$.var("Y").get(),1)),"\""));
                    }
                  }
                  //<< . . . if $get(YPARA(82))'="" if $find(","_YPARA(82)_",",","_YPARA(5)_",") write YCR," STYLE=""color:"_$piece($get(^WWW100(0,"FARBMARKIERUNG",SPRACHE,3,1)),Y,1)_""""
                  if (mOp.NotEqual(m$.Fnc.$get(YPARA.var(82)),"")) {
                    if (mOp.Logical(m$.Fnc.$find(mOp.Concat(mOp.Concat(",",YPARA.var(82).get()),","),mOp.Concat(mOp.Concat(",",YPARA.var(5).get()),",")))) {
                      m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat(" STYLE=\"color:",m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW100",0,"FARBMARKIERUNG",m$.var("SPRACHE").get(),3,1)),m$.var("Y").get(),1)),"\""));
                    }
                  }
                  //<< . . . if YXTYP=6 if $get(YCOLOR)'=1 write YCR," style=""background-color:gainsboro"""
                  if (mOp.Equal(m$.var("YXTYP").get(),6)) {
                    if (mOp.NotEqual(m$.Fnc.$get(m$.var("YCOLOR")),1)) {
                      m$.Cmd.Write(m$.var("YCR").get()," style=\"background-color:gainsboro\"");
                    }
                  }
                  //<< . . . if YPARA(55)>1 write ">"_$$^WWWNBSP($translate($extract(YA,1,YLANGE+4),"""><"))_"</option>" quit
                  if (mOp.Greater(YPARA.var(55).get(),1)) {
                    m$.Cmd.Write(mOp.Concat(mOp.Concat(">",m$.fnc$("WWWNBSP.main",m$.Fnc.$translate(m$.Fnc.$extract(YA.get(),1,mOp.Add(m$.var("YLANGE").get(),4)),"\"><"))),"</option>"));
                    break;
                  }
                  //<< . . . write ">"_$translate($extract(YA,1,YLANGE+4),"""><")_"</option>"  ;***Multi-Select Option END (selected)
                  m$.Cmd.Write(mOp.Concat(mOp.Concat(">",m$.Fnc.$translate(m$.Fnc.$extract(YA.get(),1,mOp.Add(m$.var("YLANGE").get(),4)),"\"><")),"</option>"));
                  //<< . . . if $length(YA)>YLANGE3 set YLANGE3=$length(YA)+9
                  if (mOp.Greater(m$.Fnc.$length(YA.get()),YLANGE3.get())) {
                    YLANGE3.set(mOp.Add(m$.Fnc.$length(YA.get()),9));
                  }
                } while (false);
              }
            }
          }
        }
      }
      //<< . ;
      //<< . if YXTYP=6 if YINHALT'="" do
      if (mOp.Equal(m$.var("YXTYP").get(),6)) {
        if (mOp.NotEqual(m$.var("YINHALT").get(),"")) {
          //<< . . if YLANGE3>YLANGE set YLANGE3=YLANGE
          if (mOp.Greater(YLANGE3.get(),m$.var("YLANGE").get())) {
            YLANGE3.set(m$.var("YLANGE").get());
          }
          //<< . . if YLANGE3=0 set YLANGE3=YLANGE
          if (mOp.Equal(YLANGE3.get(),0)) {
            YLANGE3.set(m$.var("YLANGE").get());
          }
          //<< . . write YCR,"<option value="""">"_$extract("-----------------------------------------------------------------------",1,YLANGE3)_"</option>"
          m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat("<option value=\"\">",m$.Fnc.$extract("-----------------------------------------------------------------------",1,YLANGE3.get())),"</option>"));
        }
      }
      //<< . . ;ZWISCHEN BODEN BEI MULTI ;inter- ground next to
      //<< . ;
      //<< . set YSORT=""
      YSORT.set("");
      //<< . new blnLinkedToGrid
      mVar blnLinkedToGrid = m$.var("blnLinkedToGrid");
      m$.newVar(blnLinkedToGrid);
      //<< . set blnLinkedToGrid=$$$NO
      blnLinkedToGrid.set(include.COMSYS.$$$NO(m$));
      //<< . if YART="M" set blnLinkedToGrid=$$IsLinkedTo^COMGridEdit31Links(YBBN)
      if (mOp.Equal(m$.var("YART").get(),"M")) {
        blnLinkedToGrid.set(m$.fnc$("COMGridEdit31Links.IsLinkedTo",m$.var("YBBN").get()));
      }
      //<< . for  set YSORT=$order(^WWWSOR(YUSER,2,YSORT),$get(YPARA(29))) quit:YSORT=""  set YPARA(5)="" for  set YPARA(5)=$order(^WWWSOR(YUSER,2,YSORT,YPARA(5)),$get(YPARA(29))) quit:YPARA(5)=""  do
      for (;true;) {
        YSORT.set(m$.Fnc.$order(m$.var("^WWWSOR",m$.var("YUSER").get(),2,YSORT.get()),m$.Fnc.$get(m$.var("YPARA").var(29))));
        if (mOp.Equal(YSORT.get(),"")) {
          break;
        }
        mVar YPARA = m$.var("YPARA");
        YPARA.var(5).set("");
        for (;true;) {
          YPARA.var(5).set(m$.Fnc.$order(m$.var("^WWWSOR",m$.var("YUSER").get(),2,YSORT.get(),YPARA.var(5).get()),m$.Fnc.$get(YPARA.var(29))));
          if (mOp.Equal(YPARA.var(5).get(),"")) {
            break;
          }
          //<< . . set YA=$get(^WWWSOR(YUSER,2,YSORT,YPARA(5)))
          mVar YA = m$.var("YA");
          YA.set(m$.Fnc.$get(m$.var("^WWWSOR",m$.var("YUSER").get(),2,YSORT.get(),YPARA.var(5).get())));
          //<< . . if $get(YBBN)'="" if $length(YA,"-")>1 do
          if (mOp.NotEqual(m$.Fnc.$get(m$.var("YBBN")),"")) {
            if (mOp.Greater(m$.Fnc.$length(YA.get(),"-"),1)) {
              //<< . . . if YART="D" if $$HideRelationClassIDs^WWW122HideRelation(YFORM,YBBN) set YA=$$TrimSpaces^COMUtilStr($piece(YA,"-",2,$length(YA,"-"))) ;BR014894 ;SR17905
              if (mOp.Equal(m$.var("YART").get(),"D")) {
                if (mOp.Logical(m$.fnc$("WWW122HideRelation.HideRelationClassIDs",m$.var("YFORM").get(),m$.var("YBBN").get()))) {
                  YA.set(m$.fnc$("COMUtilStr.TrimSpaces",m$.Fnc.$piece(YA.get(),"-",2,m$.Fnc.$length(YA.get(),"-"))));
                }
              }
              //<< . . . if YART="P" if $$HideRelationClassIDs^WWW121HideRelation(YFORM,YBBN) set YA=$$TrimSpaces^COMUtilStr($piece(YA,"-",2,$length(YA,"-"))) ;BR014894 ;SR17840 ;SR17905 ;CORE-159
              if (mOp.Equal(m$.var("YART").get(),"P")) {
                if (mOp.Logical(m$.fnc$("WWW121HideRelation.HideRelationClassIDs",m$.var("YFORM").get(),m$.var("YBBN").get()))) {
                  YA.set(m$.fnc$("COMUtilStr.TrimSpaces",m$.Fnc.$piece(YA.get(),"-",2,m$.Fnc.$length(YA.get(),"-"))));
                }
              }
              //<< . . . if YART="M" if $$HideRelationClassIDs^WWW122HideRelation(YFORM,YBBN) set YA=$$TrimSpaces^COMUtilStr($piece(YA,"-",2,$length(YA,"-"))) ;SR17993
              if (mOp.Equal(m$.var("YART").get(),"M")) {
                if (mOp.Logical(m$.fnc$("WWW122HideRelation.HideRelationClassIDs",m$.var("YFORM").get(),m$.var("YBBN").get()))) {
                  YA.set(m$.fnc$("COMUtilStr.TrimSpaces",m$.Fnc.$piece(YA.get(),"-",2,m$.Fnc.$length(YA.get(),"-"))));
                }
              }
            }
          }
          //<< . . set YINHALT1=$translate(YINHALT,";",",")
          mVar YINHALT1 = m$.var("YINHALT1");
          YINHALT1.set(m$.Fnc.$translate(m$.var("YINHALT").get(),";",","));
          //<< . . if YHID'=2 if '$find(","_$zconvert(YINHALT1,"U")_",",","_$translate($zconvert($$^WWWUML(YPARA(5)),"U"),";",",")_",") do
          if (mOp.NotEqual(m$.var("YHID").get(),2)) {
            if (mOp.Not(m$.Fnc.$find(mOp.Concat(mOp.Concat(",",m$.Fnc.$zconvert(YINHALT1.get(),"U")),","),mOp.Concat(mOp.Concat(",",m$.Fnc.$translate(m$.Fnc.$zconvert(m$.fnc$("WWWUML.main",YPARA.var(5).get()),"U"),";",",")),",")))) {
              do {
                //<< . . . write YCR,"<option value="""_YPARA(5)_""""                        ;***Multi-Select Option START (not selected)
                m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat("<option value=\"",YPARA.var(5).get()),"\""));
                //<< . . . if $get(YCOLOR)=1 do FARBE
                if (mOp.Equal(m$.Fnc.$get(m$.var("YCOLOR")),1)) {
                  m$.Cmd.Do("FARBE");
                }
                //<< . . . if YPARA(5)'="" do FARBE1  ;COLOR IN SELECT ;within ;SR17680
                if (mOp.NotEqual(YPARA.var(5).get(),"")) {
                  m$.Cmd.Do("FARBE1");
                }
                //<< . . . ;SR17680 if $get(YCOLOR1)'="" if YPARA(5)'="" do FARBE1  ;COLOR IN SELECT ;within
                //<< . . . if $get(YCOLOR)=2 do  ;SCHRIFTARTEN
                if (mOp.Equal(m$.Fnc.$get(m$.var("YCOLOR")),2)) {
                  //<< . . . . write YCR," style="""
                  m$.Cmd.Write(m$.var("YCR").get()," style=\"");
                  //<< . . . . ;SR17253 WRITE "font-face: '"    _$PIECE($GET(^WWW100(0,"SCHRIFTART",SPRACHE,YPARA(5),1)),Y,1)_"'"
                  //<< . . . . write "font-family: '"_$piece($get(^WWW100(0,"SCHRIFTART",SPRACHE,YPARA(5),1)),Y,1)_"'"         ;SR17253
                  m$.Cmd.Write(mOp.Concat(mOp.Concat("font-family: '",m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW100",0,"SCHRIFTART",m$.var("SPRACHE").get(),YPARA.var(5).get(),1)),m$.var("Y").get(),1)),"'"));
                  //<< . . . . write """"
                  m$.Cmd.Write("\"");
                }
                //<< . . . ;
                //<< . . . if $get(YPARA(80))'="" if $find(","_YPARA(80)_",",","_YPARA(5)_",") write YCR," STYLE=""color:"_$piece($get(^WWW100(0,"FARBMARKIERUNG",SPRACHE,1,1)),Y,1)_""""
                if (mOp.NotEqual(m$.Fnc.$get(YPARA.var(80)),"")) {
                  if (mOp.Logical(m$.Fnc.$find(mOp.Concat(mOp.Concat(",",YPARA.var(80).get()),","),mOp.Concat(mOp.Concat(",",YPARA.var(5).get()),",")))) {
                    m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat(" STYLE=\"color:",m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW100",0,"FARBMARKIERUNG",m$.var("SPRACHE").get(),1,1)),m$.var("Y").get(),1)),"\""));
                  }
                }
                //<< . . . if $get(YPARA(81))'="" if $find(","_YPARA(81)_",",","_YPARA(5)_",") write YCR," STYLE=""color:"_$piece($get(^WWW100(0,"FARBMARKIERUNG",SPRACHE,2,1)),Y,1)_""""
                if (mOp.NotEqual(m$.Fnc.$get(YPARA.var(81)),"")) {
                  if (mOp.Logical(m$.Fnc.$find(mOp.Concat(mOp.Concat(",",YPARA.var(81).get()),","),mOp.Concat(mOp.Concat(",",YPARA.var(5).get()),",")))) {
                    m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat(" STYLE=\"color:",m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW100",0,"FARBMARKIERUNG",m$.var("SPRACHE").get(),2,1)),m$.var("Y").get(),1)),"\""));
                  }
                }
                //<< . . . if $get(YPARA(82))'="" if $find(","_YPARA(82)_",",","_YPARA(5)_",") write YCR," STYLE=""color:"_$piece($get(^WWW100(0,"FARBMARKIERUNG",SPRACHE,3,1)),Y,1)_""""
                if (mOp.NotEqual(m$.Fnc.$get(YPARA.var(82)),"")) {
                  if (mOp.Logical(m$.Fnc.$find(mOp.Concat(mOp.Concat(",",YPARA.var(82).get()),","),mOp.Concat(mOp.Concat(",",YPARA.var(5).get()),",")))) {
                    m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat(" STYLE=\"color:",m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW100",0,"FARBMARKIERUNG",m$.var("SPRACHE").get(),3,1)),m$.var("Y").get(),1)),"\""));
                  }
                }
                //<< . . . if $get(YPARA(83))'="" if $find(","_YPARA(83)_",",","_YPARA(5)_",") write YCR," STYLE=""color:"_$piece($get(^WWW100(0,"FARBMARKIERUNG",SPRACHE,4,1)),Y,1)_""""
                if (mOp.NotEqual(m$.Fnc.$get(YPARA.var(83)),"")) {
                  if (mOp.Logical(m$.Fnc.$find(mOp.Concat(mOp.Concat(",",YPARA.var(83).get()),","),mOp.Concat(mOp.Concat(",",YPARA.var(5).get()),",")))) {
                    m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat(" STYLE=\"color:",m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW100",0,"FARBMARKIERUNG",m$.var("SPRACHE").get(),4,1)),m$.var("Y").get(),1)),"\""));
                  }
                }
                //<< . . . if $get(YPARA(84))'="" if $find(","_YPARA(84)_",",","_YPARA(5)_",") write YCR," STYLE=""color:"_$piece($get(^WWW100(0,"FARBMARKIERUNG",SPRACHE,5,1)),Y,1)_""""
                if (mOp.NotEqual(m$.Fnc.$get(YPARA.var(84)),"")) {
                  if (mOp.Logical(m$.Fnc.$find(mOp.Concat(mOp.Concat(",",YPARA.var(84).get()),","),mOp.Concat(mOp.Concat(",",YPARA.var(5).get()),",")))) {
                    m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat(" STYLE=\"color:",m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW100",0,"FARBMARKIERUNG",m$.var("SPRACHE").get(),5,1)),m$.var("Y").get(),1)),"\""));
                  }
                }
                //<< . . . if $get(YPARA(55))>1   write ">"_$$^WWWNBSP($translate($extract(YA,1,YLANGE+4),"""><"))_"</option>" quit
                if (mOp.Greater(m$.Fnc.$get(YPARA.var(55)),1)) {
                  m$.Cmd.Write(mOp.Concat(mOp.Concat(">",m$.fnc$("WWWNBSP.main",m$.Fnc.$translate(m$.Fnc.$extract(YA.get(),1,mOp.Add(m$.var("YLANGE").get(),4)),"\"><"))),"</option>"));
                  break;
                }
                //<< . . . if '$find(YA,"&nbsp;") write ">"_$translate($extract(YA,1,YLANGE+4),"""><")_"</option>"             quit ;***Multi-Select Option END (not selected)
                if (mOp.Not(m$.Fnc.$find(YA.get(),"&nbsp;"))) {
                  m$.Cmd.Write(mOp.Concat(mOp.Concat(">",m$.Fnc.$translate(m$.Fnc.$extract(YA.get(),1,mOp.Add(m$.var("YLANGE").get(),4)),"\"><")),"</option>"));
                  break;
                }
                //<< . . . if $find(YA,"&nbsp;")  write ">"_$translate(YA,"""><")_"</option>"                                  quit
                if (mOp.Logical(m$.Fnc.$find(YA.get(),"&nbsp;"))) {
                  m$.Cmd.Write(mOp.Concat(mOp.Concat(">",m$.Fnc.$translate(YA.get(),"\"><")),"</option>"));
                  break;
                }
              } while (false);
            }
          }
          //<< . . ;
          //<< . . ;if YXTYP'=6 if $find(","_$zconvert(YINHALT1,"U")_",",","_$translate($zconvert($$^WWWUML(YPARA(5)),"U"),";",",")_",") do
          //<< . . if YXTYP'=6 if (blnLinkedToGrid&&(YHID=2))||$find(","_$zconvert(YINHALT1,"U")_",",","_$translate($zconvert($$^WWWUML(YPARA(5)),"U"),";",",")_",") do ;SR18026 ;SR18026.2
          if (mOp.NotEqual(m$.var("YXTYP").get(),6)) {
            if ((mOp.Logical(blnLinkedToGrid.get()) && (mOp.Equal(m$.var("YHID").get(),2))) || mOp.Logical(m$.Fnc.$find(mOp.Concat(mOp.Concat(",",m$.Fnc.$zconvert(YINHALT1.get(),"U")),","),mOp.Concat(mOp.Concat(",",m$.Fnc.$translate(m$.Fnc.$zconvert(m$.fnc$("WWWUML.main",YPARA.var(5).get()),"U"),";",",")),",")))) {
              do {
                //<< . . . write YCR,"<option value="""_YPARA(5)_""" SELECTED=SELECTED"
                m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat("<option value=\"",YPARA.var(5).get()),"\" SELECTED=SELECTED"));
                //<< . . . if $get(YCOLOR)=1 do FARBE
                if (mOp.Equal(m$.Fnc.$get(m$.var("YCOLOR")),1)) {
                  m$.Cmd.Do("FARBE");
                }
                //<< . . . if $get(YCOLOR1)'="" if YPARA(5)'="" do FARBE1  ;COLOR IN SELECT ;within
                if (mOp.NotEqual(m$.Fnc.$get(m$.var("YCOLOR1")),"")) {
                  if (mOp.NotEqual(YPARA.var(5).get(),"")) {
                    m$.Cmd.Do("FARBE1");
                  }
                }
                //<< . . . if $get(YPARA(80))'="" if $find(","_YPARA(80)_",",","_YPARA(5)_",") write " STYLE=""color:"_$piece($get(^WWW100(0,"FARBMARKIERUNG",SPRACHE,1,1)),Y,1)_""""
                if (mOp.NotEqual(m$.Fnc.$get(YPARA.var(80)),"")) {
                  if (mOp.Logical(m$.Fnc.$find(mOp.Concat(mOp.Concat(",",YPARA.var(80).get()),","),mOp.Concat(mOp.Concat(",",YPARA.var(5).get()),",")))) {
                    m$.Cmd.Write(mOp.Concat(mOp.Concat(" STYLE=\"color:",m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW100",0,"FARBMARKIERUNG",m$.var("SPRACHE").get(),1,1)),m$.var("Y").get(),1)),"\""));
                  }
                }
                //<< . . . if $get(YPARA(81))'="" if $find(","_YPARA(81)_",",","_YPARA(5)_",") write " STYLE=""color:"_$piece($get(^WWW100(0,"FARBMARKIERUNG",SPRACHE,2,1)),Y,1)_""""
                if (mOp.NotEqual(m$.Fnc.$get(YPARA.var(81)),"")) {
                  if (mOp.Logical(m$.Fnc.$find(mOp.Concat(mOp.Concat(",",YPARA.var(81).get()),","),mOp.Concat(mOp.Concat(",",YPARA.var(5).get()),",")))) {
                    m$.Cmd.Write(mOp.Concat(mOp.Concat(" STYLE=\"color:",m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW100",0,"FARBMARKIERUNG",m$.var("SPRACHE").get(),2,1)),m$.var("Y").get(),1)),"\""));
                  }
                }
                //<< . . . if $get(YPARA(82))'="" if $find(","_YPARA(82)_",",","_YPARA(5)_",") write " STYLE=""color:"_$piece($get(^WWW100(0,"FARBMARKIERUNG",SPRACHE,3,1)),Y,1)_""""
                if (mOp.NotEqual(m$.Fnc.$get(YPARA.var(82)),"")) {
                  if (mOp.Logical(m$.Fnc.$find(mOp.Concat(mOp.Concat(",",YPARA.var(82).get()),","),mOp.Concat(mOp.Concat(",",YPARA.var(5).get()),",")))) {
                    m$.Cmd.Write(mOp.Concat(mOp.Concat(" STYLE=\"color:",m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW100",0,"FARBMARKIERUNG",m$.var("SPRACHE").get(),3,1)),m$.var("Y").get(),1)),"\""));
                  }
                }
                //<< . . . if $get(YPARA(83))'="" if $find(","_YPARA(83)_",",","_YPARA(5)_",") write " STYLE=""color:"_$piece($get(^WWW100(0,"FARBMARKIERUNG",SPRACHE,4,1)),Y,1)_""""
                if (mOp.NotEqual(m$.Fnc.$get(YPARA.var(83)),"")) {
                  if (mOp.Logical(m$.Fnc.$find(mOp.Concat(mOp.Concat(",",YPARA.var(83).get()),","),mOp.Concat(mOp.Concat(",",YPARA.var(5).get()),",")))) {
                    m$.Cmd.Write(mOp.Concat(mOp.Concat(" STYLE=\"color:",m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW100",0,"FARBMARKIERUNG",m$.var("SPRACHE").get(),4,1)),m$.var("Y").get(),1)),"\""));
                  }
                }
                //<< . . . if $get(YPARA(84))'="" if $find(","_YPARA(84)_",",","_YPARA(5)_",") write " STYLE=""color:"_$piece($get(^WWW100(0,"FARBMARKIERUNG",SPRACHE,5,1)),Y,1)_""""
                if (mOp.NotEqual(m$.Fnc.$get(YPARA.var(84)),"")) {
                  if (mOp.Logical(m$.Fnc.$find(mOp.Concat(mOp.Concat(",",YPARA.var(84).get()),","),mOp.Concat(mOp.Concat(",",YPARA.var(5).get()),",")))) {
                    m$.Cmd.Write(mOp.Concat(mOp.Concat(" STYLE=\"color:",m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW100",0,"FARBMARKIERUNG",m$.var("SPRACHE").get(),5,1)),m$.var("Y").get(),1)),"\""));
                  }
                }
                //<< . . . if YXTYP=6 if $get(YCOLOR)'=1 write YCR," style=""background-color:gainsboro"""   ;MARKIERUNG
                if (mOp.Equal(m$.var("YXTYP").get(),6)) {
                  if (mOp.NotEqual(m$.Fnc.$get(m$.var("YCOLOR")),1)) {
                    m$.Cmd.Write(m$.var("YCR").get()," style=\"background-color:gainsboro\"");
                  }
                }
                //<< . . . if $get(YPARA(55))>1 write ">"_$$^WWWNBSP($translate($extract(YA,1,YLANGE+4),"""><"))_"</option>" quit
                if (mOp.Greater(m$.Fnc.$get(YPARA.var(55)),1)) {
                  m$.Cmd.Write(mOp.Concat(mOp.Concat(">",m$.fnc$("WWWNBSP.main",m$.Fnc.$translate(m$.Fnc.$extract(YA.get(),1,mOp.Add(m$.var("YLANGE").get(),4)),"\"><"))),"</option>"));
                  break;
                }
                //<< . . . write ">"_$translate($extract(YA,1,YLANGE+4),"""><")_"</option>"
                m$.Cmd.Write(mOp.Concat(mOp.Concat(">",m$.Fnc.$translate(m$.Fnc.$extract(YA.get(),1,mOp.Add(m$.var("YLANGE").get(),4)),"\"><")),"</option>"));
              } while (false);
            }
          }
        }
      }
      //<< . ;
      //<< . write YCR,"</select>"
      m$.Cmd.Write(m$.var("YCR").get(),"</select>");
      //<< . if (YHID=2) && (YSTATUS'="") write YCR,"</DIV>"       ;SR17514    was "</A>"
      if ((mOp.Equal(m$.var("YHID").get(),2)) && (mOp.NotEqual(m$.var("YSTATUS").get(),""))) {
        m$.Cmd.Write(m$.var("YCR").get(),"</DIV>");
      }
      //<< . if '+$get(^SysSetup("FieldEvents")) if YXTYP=6 do ^WWWFORM73(YFORM,YART,YLFN)  ;SCRIPT SCHREIBEN ;write
      if (mOp.Not(mOp.Positive(m$.Fnc.$get(m$.var("^SysSetup","FieldEvents"))))) {
        if (mOp.Equal(m$.var("YXTYP").get(),6)) {
          m$.Cmd.Do("WWWFORM73.main",m$.var("YFORM").get(),m$.var("YART").get(),m$.var("YLFN").get());
        }
      }
      //<< . do PARASUCH^WWWFORM75     ; direct call
      m$.Cmd.Do("WWWFORM75.PARASUCH");
      return include.COMSYS.$$$NO(m$);
    }
    //<< 
    //<< ;---------------------------------------
    //<< ;COLLECTION                                                 ; *** EXECUTE ***
    //<< ;---------------------------------------
    //<< if (YTYP=15) || (YXTYP=16) do  quit $$$NO                 ; *** EARLY EXIT ***    ;MEHRERE DATENFELDER ;divers
    if ((mOp.Equal(m$.var("YTYP").get(),15)) || (mOp.Equal(m$.var("YXTYP").get(),16))) {
      //<< . new YLFN2
      mVar YLFN2 = m$.var("YLFN2");
      m$.newVar(YLFN2);
      //<< . if $piece(YSATZ,Y,30)<1 set $piece(YSATZ,Y,30)=8
      if (mOp.Less(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),30),1)) {
        m$.pieceVar(m$.var("YSATZ"),m$.var("Y").get(),30).set(8);
      }
      //<< . for YLFN2=1:1:$piece(YSATZ,Y,30) do  if YLFN2'=$piece(YSATZ,Y,30) write YCR,"<BR>"
      for (YLFN2.set(1);(mOp.LessOrEqual(YLFN2.get(),m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),30)));YLFN2.set(mOp.Add(YLFN2.get(),1))) {
        //<< . . set YSTATUS=""
        mVar YSTATUS = m$.var("YSTATUS");
        YSTATUS.set("");
        //<< . . if +YLANGE=0 set YLANGE=1
        if (mOp.Equal(mOp.Positive(m$.var("YLANGE").get()),0)) {
          mVar YLANGE = m$.var("YLANGE");
          YLANGE.set(1);
        }
        //<< . . set YLANGE1=YLANGE
        mVar YLANGE1 = m$.var("YLANGE1");
        YLANGE1.set(m$.var("YLANGE").get());
        //<< . . if (YTYPE'="float") || (YLANGE>12) do  ;FELD VERLÄNGERN ;field prolong
        if ((mOp.NotEqual(m$.var("YTYPE").get(),"float")) || (mOp.Greater(m$.var("YLANGE").get(),12))) {
          //<< . . . if YLANGE>2 set YLANGE1=YLANGE1+1
          if (mOp.Greater(m$.var("YLANGE").get(),2)) {
            YLANGE1.set(mOp.Add(YLANGE1.get(),1));
          }
          //<< . . . if YLANGE>6 set YLANGE1=YLANGE1+1
          if (mOp.Greater(m$.var("YLANGE").get(),6)) {
            YLANGE1.set(mOp.Add(YLANGE1.get(),1));
          }
        }
        //<< . . ;
        //<< . . if YLANGE1>YLAMX set YLANGE1=YLAMX  ;NICHT GRÖßER ALS ;Not when
        if (mOp.Greater(YLANGE1.get(),m$.var("YLAMX").get())) {
          YLANGE1.set(m$.var("YLAMX").get());
        }
        //<< . . if YTYPE="FILE" set YLANGE=200
        if (mOp.Equal(m$.var("YTYPE").get(),"FILE")) {
          mVar YLANGE = m$.var("YLANGE");
          YLANGE.set(200);
        }
        //<< . . if YTYP=8 set YLANGE=30
        if (mOp.Equal(m$.var("YTYP").get(),8)) {
          mVar YLANGE = m$.var("YLANGE");
          YLANGE.set(30);
        }
        //<< . . if $piece(YSATZ,Y,88)>0 set YLANGE1=+$piece(YSATZ,Y,88)
        if (mOp.Greater(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),88),0)) {
          YLANGE1.set(mOp.Positive(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),88)));
        }
        //<< . . if (YHID=2) && (YSTATUS'="") write YCR,"<A" do STAT write ">"
        if ((mOp.Equal(m$.var("YHID").get(),2)) && (mOp.NotEqual(YSTATUS.get(),""))) {
          m$.Cmd.Write(m$.var("YCR").get(),"<A");
          m$.Cmd.Do("STAT");
          m$.Cmd.Write(">");
        }
        //<< . . write YCR,"<INPUT"
        m$.Cmd.Write(m$.var("YCR").get(),"<INPUT");
        //<< . . write YCR," NAME=""Y"_YFORM_YART_YLFN_""""   ;"C"_YLFN2_""""
        m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(" NAME=\"Y",m$.var("YFORM").get()),m$.var("YART").get()),m$.var("YLFN").get()),"\""));
        //<< . . write " ID=""Y"_YFORM_YART_YLFN_""""            ;SR17253
        m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(" ID=\"Y",m$.var("YFORM").get()),m$.var("YART").get()),m$.var("YLFN").get()),"\""));
        //<< . . write YCR," SIZE="""_YLANGE1_""""
        m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat(" SIZE=\"",YLANGE1.get()),"\""));
        //<< . . write YCR," MAXLENGTH="""_YLANGE_""""
        m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat(" MAXLENGTH=\"",m$.var("YLANGE").get()),"\""));
        //<< . . if +$piece(YSATZ,Y,61)=0 if $get(YHID)=2  write YCR," TABINDEX=-1"    ; TAB STOP IN READ ONLY FIELD.14.07.06;FAN
        if (mOp.Equal(mOp.Positive(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),61)),0)) {
          if (mOp.Equal(m$.Fnc.$get(m$.var("YHID")),2)) {
            m$.Cmd.Write(m$.var("YCR").get()," TABINDEX=-1");
          }
        }
        //<< . . if +$piece(YSATZ,Y,61)=0 if $get(YHID)'=2 write YCR," TABINDEX="""_YTABX_""""
        if (mOp.Equal(mOp.Positive(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),61)),0)) {
          if (mOp.NotEqual(m$.Fnc.$get(m$.var("YHID")),2)) {
            m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat(" TABINDEX=\"",m$.var("YTABX").get()),"\""));
          }
        }
        //<< . . if +$piece(YSATZ,Y,61)'=0 write YCR," TABINDEX="""_+$piece(YSATZ,Y,61)_""""
        if (mOp.NotEqual(mOp.Positive(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),61)),0)) {
          m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat(" TABINDEX=\"",mOp.Positive(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),61))),"\""));
        }
        //<< . . ;
        //<< . . ; *** EXECUTE ***
        //<< . . if $piece(YSATZ,Y,99)'="" xecute $piece(YSATZ,Y,99)  ;EXECUTE INNERHALB EINES EINGABEFELDES GUE ;EXECUTE inside
        if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),99),"")) {
          m$.Cmd.Xecute(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),99));
        }
        //<< . . if $$EXIST^%R("Y"_YFORM_YART_YLFN_"onField.OBJ",$get(YUCI)) write YCR xecute "DO ^Y"_YFORM_YART_YLFN_"onField"  ;CUSTOMIZED EXECUTE;FIS;24947;10.01.04
        if (mOp.Logical(m$.fnc$("$R.EXIST",mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("Y",m$.var("YFORM").get()),m$.var("YART").get()),m$.var("YLFN").get()),"onField.OBJ"),m$.Fnc.$get(m$.var("YUCI"))))) {
          m$.Cmd.Write(m$.var("YCR").get());
          m$.Cmd.Xecute(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("DO ^Y",m$.var("YFORM").get()),m$.var("YART").get()),m$.var("YLFN").get()),"onField"));
        }
        //<< . . ;
        //<< . . write YCR," TYPE="""_YTYPE_""""
        m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat(" TYPE=\"",m$.var("YTYPE").get()),"\""));
        //<< . . if $piece(YINHALT,";",YLFN2)'="" write YCR," VALUE="""_$piece(YINHALT,";",YLFN2)_""""
        if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YINHALT").get(),";",YLFN2.get()),"")) {
          m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat(" VALUE=\"",m$.Fnc.$piece(m$.var("YINHALT").get(),";",YLFN2.get())),"\""));
        }
        //<< . . ;
        //<< . . write YCR," style="""
        m$.Cmd.Write(m$.var("YCR").get()," style=\"");
        //<< . . write "padding-top:0 ;padding-bottom:0"   ;style
        m$.Cmd.Write("padding-top:0 ;padding-bottom:0");
        //<< . . if $piece(YSATZ,Y,91)'="" do  ;SCHRIFTART NEU ;recent
        if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),91),"")) {
          //<< . . . ;WRITE YCR," style="""
          //<< . . . ;SR17253 WRITE "; '"             _$PIECE($GET(^WWW100(0,"SCHRIFTART",SPRACHE,$PIECE(YSATZ,Y,91),1)),Y,1)_"'"         ; FIXME : font-face/font-family?
          //<< . . . write "font-family: '"_$piece($get(^WWW100(0,"SCHRIFTART",SPRACHE,$piece(YSATZ,Y,91),1)),Y,1)_"'"     ;SR17253
          m$.Cmd.Write(mOp.Concat(mOp.Concat("font-family: '",m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW100",0,"SCHRIFTART",m$.var("SPRACHE").get(),m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),91),1)),m$.var("Y").get(),1)),"'"));
        }
        //<< . . . ;WRITE """"
        //<< . . ;
        //<< . . if YTYPE="float" write "; text-align:right"
        if (mOp.Equal(m$.var("YTYPE").get(),"float")) {
          m$.Cmd.Write("; text-align:right");
        }
        //<< . . if YART="P" if YHID=2 if $piece($get(YVOR1),Y,95)=1 write "; font-weight:bold"
        if (mOp.Equal(m$.var("YART").get(),"P")) {
          if (mOp.Equal(m$.var("YHID").get(),2)) {
            if (mOp.Equal(m$.Fnc.$piece(m$.Fnc.$get(m$.var("YVOR1")),m$.var("Y").get(),95),1)) {
              m$.Cmd.Write("; font-weight:bold");
            }
          }
        }
        //<< . . if $piece(YSATZ,Y,78)'="" write "; "_$piece(YSATZ,Y,78)   ;style
        if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),78),"")) {
          m$.Cmd.Write(mOp.Concat("; ",m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),78)));
        }
        //<< . . if YHID=2 do LESEN1                             ; Disabled field
        if (mOp.Equal(m$.var("YHID").get(),2)) {
          m$.Cmd.Do("LESEN1");
        }
        //<< . . if (YPFLICHT=1) || (YART="P") do PFLICHT        ; Mandatory Field
        if ((mOp.Equal(m$.var("YPFLICHT").get(),1)) || (mOp.Equal(m$.var("YART").get(),"P"))) {
          m$.Cmd.Do("PFLICHT");
        }
        //<< . . write """"  ;ende style;28,7,2004
        m$.Cmd.Write("\"");
        //<< . . ;
        //<< . . if $piece(YSATZ,Y,82)'="" do READONLY  ;ANDERE FELDER AUF READ ONLY WENN EINGABE ;upon READ when
        if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),82),"")) {
          m$.Cmd.Do("READONLY");
        }
        //<< . . if $piece(YSATZ,Y,83)'="" do WRITE     ;ANDERE FELDER AUF WRITE WENN EINGABE ;upon when
        if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),83),"")) {
          m$.Cmd.Do("WRITE");
        }
        //<< . . if YJAVA=1 do JAVA^WWWFORM8
        if (mOp.Equal(m$.var("YJAVA").get(),1)) {
          m$.Cmd.Do("WWWFORM8.JAVA");
        }
        //<< . . do SAVE
        m$.Cmd.Do("SAVE");
        //<< . . if YHID=2 do LESEN
        if (mOp.Equal(m$.var("YHID").get(),2)) {
          m$.Cmd.Do("LESEN");
        }
        //<< . . if (YHID'=2) && (YSTATUS'="") do STAT
        if ((mOp.NotEqual(m$.var("YHID").get(),2)) && (mOp.NotEqual(YSTATUS.get(),""))) {
          m$.Cmd.Do("STAT");
        }
        //<< . . if YHID'=2 write YCR," onFocus='select();'"
        if (mOp.NotEqual(m$.var("YHID").get(),2)) {
          m$.Cmd.Write(m$.var("YCR").get()," onFocus='select();'");
        }
        //<< . . if YTYP=1 do
        if (mOp.Equal(m$.var("YTYP").get(),1)) {
          //<< . . . ;IF $PIECE($GET(^WWW012(0,0,1)),Y,82)=1  IF SPRACHE="DE" IF $GET(YPARA(67))'="" WRITE YCR WRITE " onChange='this.value=checkdate(this.value); if (!OK) {this.value="""";this.focus();}'"  ;TYBD;8.5.03;DATUM UND UMLEKFUNKTION // PO COMMENTED OUT: checkdate js function nolonger defined
          //<< . . . ;IF $PIECE($GET(^WWW012(0,0,1)),Y,82)'=1 IF $PIECE(YSATZ,Y,66)'=1               WRITE YCR WRITE " onChange='this.value=checkdate(this.value); if (!OK) {this.value="""";this.focus();}'"  ;FIS;2.5.03;22865NUR WENN OHNE EVENTBROKER // PO COMMENTED OUT: checkdate js function nolonger defined
          //<< . . . if SPRACHE="DE" if YINHALT'="" write YCR," title=""KW "_$extract($$^WWWWEEK(YINHALT),1,2)_""""              ; FIXME : "DE"
          if (mOp.Equal(m$.var("SPRACHE").get(),"DE")) {
            if (mOp.NotEqual(m$.var("YINHALT").get(),"")) {
              m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat(" title=\"KW ",m$.Fnc.$extract(m$.fnc$("WWWWEEK.main",m$.var("YINHALT").get()),1,2)),"\""));
            }
          }
        }
        //<< . . ;
        //<< . . write ">"
        m$.Cmd.Write(">");
        //<< . . if (YHID=2) && (YSTATUS'="") write YCR,"</A>"
        if ((mOp.Equal(m$.var("YHID").get(),2)) && (mOp.NotEqual(YSTATUS.get(),""))) {
          m$.Cmd.Write(m$.var("YCR").get(),"</A>");
        }
        if (mOp.NotEqual(YLFN2.get(),m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),30))) {
          m$.Cmd.Write(m$.var("YCR").get(),"<BR>");
        }
      }
      return include.COMSYS.$$$NO(m$);
    }
    do {
      //<< 
      //<< ;---------------------------------------
      //<< ;NORMALER TEXT KLEIN ;Text                                  ; *** EXECUTE ***
      //<< ;---------------------------------------
      //<< do
      //<< . set YXTYP=1  ;TEXTFELD ERZWINGEN FEHLER AUS OPTIONSFELD WENN KEINE DATEN IN MULTISELECTFELD;TYBD;23828;24.06.2003
      mVar YXTYP = m$.var("YXTYP");
      YXTYP.set(1);
      //<< . if +YLANGE=0 set YLANGE=1
      if (mOp.Equal(mOp.Positive(m$.var("YLANGE").get()),0)) {
        mVar YLANGE = m$.var("YLANGE");
        YLANGE.set(1);
      }
      //<< . set YLANGE1=YLANGE
      mVar YLANGE1 = m$.var("YLANGE1");
      YLANGE1.set(m$.var("YLANGE").get());
      //<< . if (YTYPE'="float") || (YLANGE>12) do  ;FELD VERLÄNGERN ;field prolong
      if ((mOp.NotEqual(m$.var("YTYPE").get(),"float")) || (mOp.Greater(m$.var("YLANGE").get(),12))) {
        //<< . . if YLANGE>2 set YLANGE1=YLANGE1+1
        if (mOp.Greater(m$.var("YLANGE").get(),2)) {
          YLANGE1.set(mOp.Add(YLANGE1.get(),1));
        }
        //<< . . if YLANGE>6 set YLANGE1=YLANGE1+1
        if (mOp.Greater(m$.var("YLANGE").get(),6)) {
          YLANGE1.set(mOp.Add(YLANGE1.get(),1));
        }
      }
      //<< . ;
      //<< . if YLANGE1>YLAMX set YLANGE1=YLAMX  ;NICHT GRÖßER ALS ;Not when
      if (mOp.Greater(YLANGE1.get(),m$.var("YLAMX").get())) {
        YLANGE1.set(m$.var("YLAMX").get());
      }
      //<< . if YTYPE="FILE" set YLANGE=200
      if (mOp.Equal(m$.var("YTYPE").get(),"FILE")) {
        mVar YLANGE = m$.var("YLANGE");
        YLANGE.set(200);
      }
      //<< . if YTYP=8 set YLANGE=30
      if (mOp.Equal(m$.var("YTYP").get(),8)) {
        mVar YLANGE = m$.var("YLANGE");
        YLANGE.set(30);
      }
      //<< . if YTYP=7 if SPRACHE'="DE" set YLANGE1=10  ;TYBD;UHRZEIT ZU LANG IN "EN";4,8,2004    ; FIXME : "DE"
      if (mOp.Equal(m$.var("YTYP").get(),7)) {
        if (mOp.NotEqual(m$.var("SPRACHE").get(),"DE")) {
          YLANGE1.set(10);
        }
      }
      //<< . ;
      //<< . ; If we have a customized field size for a Data Field, ignore the 'Modified Field Length' value.
      //<< . if ((YART = "D")||(YART = "M")) && (+$$$WWW122DFieldLength($get(^WWW122D(0,YFORM,YLFN,YM,1))) = 0) && ($piece(YSATZ,Y,88) > 0) do ;SRBR014471 ;SR18179
      if (mOp.Logical(((mOp.Equal(m$.var("YART").get(),"D")) || (mOp.Equal(m$.var("YART").get(),"M")))) && (mOp.Equal(mOp.Positive(include.WWWConst.$$$WWW122DFieldLength(m$,m$.Fnc.$get(m$.var("^WWW122D",0,m$.var("YFORM").get(),m$.var("YLFN").get(),m$.var("YM").get(),1)))),0)) && (mOp.Greater(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),88),0))) {
        //<< . . set YLANGE1=+$piece(YSATZ,Y,88)
        YLANGE1.set(mOp.Positive(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),88)));
      }
      //<< . ;
      //<< . ; If we have a customized field size for a Primary Key, ignore the 'Modified Input Field Length' value.
      //<< . if (YART = "P") && (+$$$WWW121DFieldLength($get(^WWW121D(0,YFORM,YLFN,YM,1))) = 0) && ($piece(YSATZ,Y,88) > 0) do ;SRBR014628
      if ((mOp.Equal(m$.var("YART").get(),"P")) && (mOp.Equal(mOp.Positive(include.WWWConst.$$$WWW121DFieldLength(m$,m$.Fnc.$get(m$.var("^WWW121D",0,m$.var("YFORM").get(),m$.var("YLFN").get(),m$.var("YM").get(),1)))),0)) && (mOp.Greater(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),88),0))) {
        //<< . . set YLANGE1=+$piece(YSATZ,Y,88)
        YLANGE1.set(mOp.Positive(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),88)));
      }
      //<< . ;
      //<< . write YCR,"<INPUT"
      m$.Cmd.Write(m$.var("YCR").get(),"<INPUT");
      //<< . ;IF YHID=2 WRITE " readOnly"
      //<< . write YCR," NAME=""Y"_YFORM_YART_YLFN_""""
      m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(" NAME=\"Y",m$.var("YFORM").get()),m$.var("YART").get()),m$.var("YLFN").get()),"\""));
      //<< . write YCR," ID=""Y"_YFORM_YART_YLFN_""""          ;SR17253
      m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(" ID=\"Y",m$.var("YFORM").get()),m$.var("YART").get()),m$.var("YLFN").get()),"\""));
      //<< . write YCR," SIZE="""_YLANGE1_""""
      m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat(" SIZE=\"",YLANGE1.get()),"\""));
      //<< . write YCR," MAXLENGTH="""_YLANGE_""""
      m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat(" MAXLENGTH=\"",m$.var("YLANGE").get()),"\""));
      //<< . ;
      //<< . ; *** EXECUTE ***
      //<< . if $piece(YSATZ,Y,99)'="" xecute $piece(YSATZ,Y,99)  ;EXECUTE INNERHALB EINES EINGABEFELDES GUE ;EXECUTE inside
      if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),99),"")) {
        m$.Cmd.Xecute(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),99));
      }
      //<< . if $$EXIST^%R("Y"_YFORM_YART_YLFN_"onField.OBJ",$get(YUCI)) write YCR xecute "DO ^Y"_YFORM_YART_YLFN_"onField"  ;CUSTOMIZED EXECUTE;FIS;24947;10.01.04
      if (mOp.Logical(m$.fnc$("$R.EXIST",mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("Y",m$.var("YFORM").get()),m$.var("YART").get()),m$.var("YLFN").get()),"onField.OBJ"),m$.Fnc.$get(m$.var("YUCI"))))) {
        m$.Cmd.Write(m$.var("YCR").get());
        m$.Cmd.Xecute(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("DO ^Y",m$.var("YFORM").get()),m$.var("YART").get()),m$.var("YLFN").get()),"onField"));
      }
      //<< . ;
      //<< . write YCR," TYPE="""_YTYPE_""""
      m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat(" TYPE=\"",m$.var("YTYPE").get()),"\""));
      //<< . if YINHALT'="" write YCR," VALUE="""_YINHALT_""""
      if (mOp.NotEqual(m$.var("YINHALT").get(),"")) {
        m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat(" VALUE=\"",m$.var("YINHALT").get()),"\""));
      }
      //<< . ;IF +$PIECE(YSATZ,Y,61)=0 WRITE YCR," TABINDEX="""_YTABX_""""
      //<< . if +$piece(YSATZ,Y,61)=0 if $get(YHID)=2  write YCR," TABINDEX=-1"    ; TAB STOP IN READ ONLY FIELD.14.07.06;FAN
      if (mOp.Equal(mOp.Positive(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),61)),0)) {
        if (mOp.Equal(m$.Fnc.$get(m$.var("YHID")),2)) {
          m$.Cmd.Write(m$.var("YCR").get()," TABINDEX=-1");
        }
      }
      //<< . if +$piece(YSATZ,Y,61)=0 if $get(YHID)'=2 write YCR," TABINDEX="""_YTABX_""""
      if (mOp.Equal(mOp.Positive(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),61)),0)) {
        if (mOp.NotEqual(m$.Fnc.$get(m$.var("YHID")),2)) {
          m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat(" TABINDEX=\"",m$.var("YTABX").get()),"\""));
        }
      }
      //<< . if +$piece(YSATZ,Y,61)'=0                 write YCR," TABINDEX="""_+$piece(YSATZ,Y,61)_""""
      if (mOp.NotEqual(mOp.Positive(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),61)),0)) {
        m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat(" TABINDEX=\"",mOp.Positive(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),61))),"\""));
      }
      //<< . ;
      //<< . write YCR," style="""            ;NEUER STYLE;TYBD;26159;28,7,2004
      m$.Cmd.Write(m$.var("YCR").get()," style=\"");
      //<< . if $piece(YSATZ,Y,91)'="" do     ;SCHRIFTART NEU ;recent
      if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),91),"")) {
        //<< . . ;SR17253 WRITE "font-face: '"    _$PIECE($GET(^WWW100(0,"SCHRIFTART",SPRACHE,$PIECE(YSATZ,Y,91),1)),Y,1)_"'"
        //<< . . write "font-family: '"_$piece($get(^WWW100(0,"SCHRIFTART",SPRACHE,$piece(YSATZ,Y,91),1)),Y,1)_"'"   ;SR17253
        m$.Cmd.Write(mOp.Concat(mOp.Concat("font-family: '",m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW100",0,"SCHRIFTART",m$.var("SPRACHE").get(),m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),91),1)),m$.var("Y").get(),1)),"'"));
      }
      //<< . ;
      //<< . write "; padding-top:0 ;padding-bottom:0"   ;style
      m$.Cmd.Write("; padding-top:0 ;padding-bottom:0");
      //<< . ;if YTYPE="float" write "; text-align:right"
      //<< . if YTYPE="float" write "; text-align:right; padding-right:1px" ; SR18045
      if (mOp.Equal(m$.var("YTYPE").get(),"float")) {
        m$.Cmd.Write("; text-align:right; padding-right:1px");
      }
      //<< . if YART="P" if YHID=2 if $piece($get(YVOR1),Y,95)=1 write "; font-weight:bold"
      if (mOp.Equal(m$.var("YART").get(),"P")) {
        if (mOp.Equal(m$.var("YHID").get(),2)) {
          if (mOp.Equal(m$.Fnc.$piece(m$.Fnc.$get(m$.var("YVOR1")),m$.var("Y").get(),95),1)) {
            m$.Cmd.Write("; font-weight:bold");
          }
        }
      }
      //<< . if $piece(YSATZ,Y,78)'="" write "; "_$piece(YSATZ,Y,78)   ;style
      if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),78),"")) {
        m$.Cmd.Write(mOp.Concat("; ",m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),78)));
      }
      //<< . if YINHALT'="" if YPARA(20)=1 if YPARA(2)'="" set YCOLOR1=YPARA(2) set YPARA(5)=YINHALT do FARBE2
      if (mOp.NotEqual(m$.var("YINHALT").get(),"")) {
        if (mOp.Equal(m$.var("YPARA").var(20).get(),1)) {
          if (mOp.NotEqual(m$.var("YPARA").var(2).get(),"")) {
            mVar YCOLOR1 = m$.var("YCOLOR1");
            YCOLOR1.set(m$.var("YPARA").var(2).get());
            mVar YPARA = m$.var("YPARA");
            YPARA.var(5).set(m$.var("YINHALT").get());
            m$.Cmd.Do("FARBE2");
          }
        }
      }
      //<< . if YHID=2 do LESEN1                             ; Disabled field
      if (mOp.Equal(m$.var("YHID").get(),2)) {
        m$.Cmd.Do("LESEN1");
      }
      //<< . if (YPFLICHT=1) || (YART="P") do PFLICHT        ; Mandatory Field
      if ((mOp.Equal(m$.var("YPFLICHT").get(),1)) || (mOp.Equal(m$.var("YART").get(),"P"))) {
        m$.Cmd.Do("PFLICHT");
      }
      //<< . IF (YHID'=2) && (YPFLICHT'=1) && (YART'="P") write "; background-color:white; "   ;SR17861
      if ((mOp.NotEqual(m$.var("YHID").get(),2)) && (mOp.NotEqual(m$.var("YPFLICHT").get(),1)) && (mOp.NotEqual(m$.var("YART").get(),"P"))) {
        m$.Cmd.Write("; background-color:white; ");
      }
      //<< . write "; margin-bottom:1px; "                                         ;SR17861
      m$.Cmd.Write("; margin-bottom:1px; ");
      //<< . ;SR18129 if $$$WWW122FlatControls(YSATZ) write "; border:none; margin:1px; margin-bottom:2px; " ;SR18000
      //<< . if $$$WWW122FlatControls(YSATZ) write "; border:none; margin:0px; margin-bottom:0px; border:0px; padding:0px; " ;SR18000 ;SR18129
      if (mOp.Logical(include.WWWConst.$$$WWW122FlatControls(m$,m$.var("YSATZ")))) {
        m$.Cmd.Write("; border:none; margin:0px; margin-bottom:0px; border:0px; padding:0px; ");
      }
      //<< . write """"  ;STYLE ENDE ;termination
      m$.Cmd.Write("\"");
      //<< . ;
      //<< . if YHID=2 do LESEN
      if (mOp.Equal(m$.var("YHID").get(),2)) {
        m$.Cmd.Do("LESEN");
      }
      //<< . if $piece(YSATZ,Y,82)'="" do READONLY  ;ANDERE FELDER AUF READ ONLY WENN EINGABE ;upon READ when
      if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),82),"")) {
        m$.Cmd.Do("READONLY");
      }
      //<< . if $piece(YSATZ,Y,83)'="" do WRITE     ;ANDERE FELDER AUF WRITE WENN EINGABE ;upon when
      if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),83),"")) {
        m$.Cmd.Do("WRITE");
      }
      //<< . if YJAVA=1 do JAVA^WWWFORM8
      if (mOp.Equal(m$.var("YJAVA").get(),1)) {
        m$.Cmd.Do("WWWFORM8.JAVA");
      }
      //<< . do SAVE
      m$.Cmd.Do("SAVE");
      //<< . if YSTATUS'="" do STAT
      if (mOp.NotEqual(m$.var("YSTATUS").get(),"")) {
        m$.Cmd.Do("STAT");
      }
      //<< . if YHID'=2 write YCR," onFocus='select();'"
      if (mOp.NotEqual(m$.var("YHID").get(),2)) {
        m$.Cmd.Write(m$.var("YCR").get()," onFocus='select();'");
      }
      //<< . if YTYP=1 do
      if (mOp.Equal(m$.var("YTYP").get(),1)) {
        //<< . . ;IF $EXTRACT(YART)="L" IF YHTMFORM="WWW" WRITE YCR WRITE " onChange='this.value=checkdate(this.value); if (!OK) {this.value="""";this.focus();}'"  QUIT  ;TYBD;23826;29.06.2003;DATUM UND UMLEKFUNKTION // PO COMMENTED OUT: checkdate js function nolonger defined
        //<< . . ;IF $PIECE($GET(^WWW012(0,0,1)),Y,82)=1 IF SPRACHE="DE" IF $GET(YPARA(67))'="" WRITE YCR WRITE " onChange='this.value=checkdate(this.value); if (!OK) {this.value="""";this.focus();}'"  ;TYBD;8.5.03;DATUM UND UMLEKFUNKTION // PO COMMENTED OUT: checkdate js function nolonger defined
        //<< . . ;IF $PIECE($GET(^WWW012(0,0,1)),Y,82)'=1 IF $PIECE(YSATZ,Y,66)'=1 WRITE YCR WRITE " onChange='this.value=checkdate(this.value); if (!OK) {this.value="""";this.focus();}'"  ;FIS;2.5.03;22865NUR WENN OHNE EVENTBROKER // PO COMMENTED OUT: checkdate js function nolonger defined
        //<< . . if SPRACHE="DE" if YINHALT'="" if '$find(YINHALT,"W") write YCR," title=""KW "_$extract($$^WWWWEEK(YINHALT),1,2)_""""    ; FIXME : "DE"
        if (mOp.Equal(m$.var("SPRACHE").get(),"DE")) {
          if (mOp.NotEqual(m$.var("YINHALT").get(),"")) {
            if (mOp.Not(m$.Fnc.$find(m$.var("YINHALT").get(),"W"))) {
              m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat(" title=\"KW ",m$.Fnc.$extract(m$.fnc$("WWWWEEK.main",m$.var("YINHALT").get()),1,2)),"\""));
            }
          }
        }
      }
      //<< . ;
      //<< . ;if ((+$$$WWWClientParamCoreChangesALL($get(^WWWClientParam(YM,YM,1)))) && ((YTYP=1) || (YTYP=17))) do
      //<< . ;write YCR," onkeyup = 'if ((window.event.keyCode != 8) && (window.event.keyCode != 46)) { if ((this.value.substring(0,1) != ""+"") && (this.value.substring(0,1) != ""-"")){ var mask = ""##/##/####""; var coringa = ""#""; var texto = mask.substring(this.value.length); if (texto.substring(0,1) != coringa){ this.value += texto.substring(0,1); } } };' "
      //<< . ;
      //<< . write ">"
      m$.Cmd.Write(">");
      //<< . if $piece(YSATZ,Y,119)=1 if YTYP=6 do         ;COMBO-BOX;FIS;24872;05.01.04
      if (mOp.Equal(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),119),1)) {
        if (mOp.Equal(m$.var("YTYP").get(),6)) {
          do {
            //<< . . quit:$piece($get(^WWW012(0,0,1)),Y,82)'=1  ;NUR MIT HYPEREVENT ;only by means of
            if (mOp.NotEqual(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW012",0,0,1)),m$.var("Y").get(),82),1)) {
              break;
            }
            //<< . . write YCR,"<img src="""_YGIF_"combobox.gif"" border=0 style=""vertical-align:center;"""
            m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat("<img src=\"",m$.var("YGIF").get()),"combobox.gif\" border=0 style=\"vertical-align:center;\""));
            //<< . . write " onClick='retval = EventValue("""_YUCI_""","""_YUSER_""","""_YFORM_""",""FIX"",""WWWFORM74"",document."_YHTMFORM_".COMBO"_YFORM_".value,""6"",""COMBO"_YFORM_YART_YLFN_""");'"
            m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(" onClick='retval = EventValue(\"",m$.var("YUCI").get()),"\",\""),m$.var("YUSER").get()),"\",\""),m$.var("YFORM").get()),"\",\"FIX\",\"WWWFORM74\",document."),m$.var("YHTMFORM").get()),".COMBO"),m$.var("YFORM").get()),".value,\"6\",\"COMBO"),m$.var("YFORM").get()),m$.var("YART").get()),m$.var("YLFN").get()),"\");'"));
            //<< . . write ">"
            m$.Cmd.Write(">");
            //<< . . write YCR,"<div id=""COMBO"_YFORM_YART_YLFN_""""
            m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<div id=\"COMBO",m$.var("YFORM").get()),m$.var("YART").get()),m$.var("YLFN").get()),"\""));
            //<< . . write " style=""position:absolute; top:0; left:0; height:20; width:80; border:1px solid black; background-color:white; z-index:5000; visibility:hidden; scrollbars:yes;"""
            m$.Cmd.Write(" style=\"position:absolute; top:0; left:0; height:20; width:80; border:1px solid black; background-color:white; z-index:5000; visibility:hidden; scrollbars:yes;\"");
            //<< . . write ">"
            m$.Cmd.Write(">");
            //<< . . do
            do {
              //<< . . . write YCR,"<IFRAME name=""COMBO"_YFORM_YART_YLFN_""""
              m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<IFRAME name=\"COMBO",m$.var("YFORM").get()),m$.var("YART").get()),m$.var("YLFN").get()),"\""));
              //<< . . . write " src=""javascript:window.location='"_YAKTION_"EP=WWWMANU&amp;YEXEC=*DO|ANZEIGE^WWWFORM74&amp;YFORM="_YFORM_"&amp;YLFDAT="_YFORM_YART_YLFN
              m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(" src=\"javascript:window.location='",m$.var("YAKTION").get()),"EP=WWWMANU&amp;YEXEC=*DO|ANZEIGE^WWWFORM74&amp;YFORM="),m$.var("YFORM").get()),"&amp;YLFDAT="),m$.var("YFORM").get()),m$.var("YART").get()),m$.var("YLFN").get()));
              //<< . . . new YFORM
              mVar YFORM = m$.var("YFORM");
              m$.newVar(YFORM);
              //<< . . . do ^WWWCGI
              m$.Cmd.Do("WWWCGI.main");
              //<< . . . write "'"""
              m$.Cmd.Write("'\"");
              //<< . . . write YCR," BORDER=0 FRAMEBORDER=0"
              m$.Cmd.Write(m$.var("YCR").get()," BORDER=0 FRAMEBORDER=0");
              //<< . . . write " FRAMESPACING=0 WIDTH=100% HEIGHT=100% SCROLLING=AUTO"
              m$.Cmd.Write(" FRAMESPACING=0 WIDTH=100% HEIGHT=100% SCROLLING=AUTO");
              //<< . . . write ">"
              m$.Cmd.Write(">");
              //<< . . . write YCR,"</IFRAME>"
              m$.Cmd.Write(m$.var("YCR").get(),"</IFRAME>");
            } while(false);
            //<< . . ;
            //<< . . write "</div>"
            m$.Cmd.Write("</div>");
            //<< . . write YCR,"<div id=""YCOMBO"_YFORM_YART_YLFN_""" style=""position:relative; visibility:hidden;""></div>"
            m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<div id=\"YCOMBO",m$.var("YFORM").get()),m$.var("YART").get()),m$.var("YLFN").get()),"\" style=\"position:relative; visibility:hidden;\"></div>"));
          } while (false);
        }
      }
    } while(false);
    //<< 
    //<< ;---------------------------------------
    //<< ;PARAMETER
    //<< ;   D97     $$$WWW122ExecuteAfterDataField()
    //<< ;---------------------------------------
    //<< do PARASUCH^WWWFORM75     ; direct call
    m$.Cmd.Do("WWWFORM75.PARASUCH");
    //<< write YCR
    m$.Cmd.Write(m$.var("YCR").get());
    //<< quit $$$YES
    return include.COMSYS.$$$YES(m$);
  }

  //<< 
  //<< RELATION  ;ANZEIGEN RELATION ;display
  public void RELATION() {
    //<< ;---------------------------------------
    //<< ;  ^WWWSOR2(YUSER,2,idxEnum,Enum) = Combo display string
    //<< ;---------------------------------------
    //<< if +$piece(YSATZ,Y,70)'=0                         quit  ;nur bei normalen feldern ;solely next to
    if (mOp.NotEqual(mOp.Positive(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),70)),0)) {
      return;
    }
    //<< if YART="P" if (YPARA(1)="") || (YPARA(1)=YDATEI) quit  ;KEINE ANZEIGE ;no Show
    if (mOp.Equal(m$.var("YART").get(),"P")) {
      if ((mOp.Equal(m$.var("YPARA").var(1).get(),"")) || (mOp.Equal(m$.var("YPARA").var(1).get(),m$.var("YDATEI").get()))) {
        return;
      }
    }
    //<< if YART="P" if $data(^WWWSOR(YUSER,2)) set YSHOWRELA=1
    if (mOp.Equal(m$.var("YART").get(),"P")) {
      if (mOp.Logical(m$.Fnc.$data(m$.var("^WWWSOR",m$.var("YUSER").get(),2)))) {
        mVar YSHOWRELA = m$.var("YSHOWRELA");
        YSHOWRELA.set(1);
      }
    }
    //<< quit:$get(YSHOWRELA)'=1   ;KEINE ANZEIGE ;no Show
    if (mOp.NotEqual(m$.Fnc.$get(m$.var("YSHOWRELA")),1)) {
      return;
    }
    //<< quit:+$get(YPARA(20))'=1  ;KEINE RELATION ;no
    if (mOp.NotEqual(mOp.Positive(m$.Fnc.$get(m$.var("YPARA").var(20))),1)) {
      return;
    }
    //<< 
    //<< new YVALUE,YLENGTH
    mVar YVALUE = m$.var("YVALUE");
    mVar YLENGTH = m$.var("YLENGTH");
    m$.newVar(YVALUE,YLENGTH);
    //<< set YVALUE=""
    YVALUE.set("");
    //<< set YLENGTH=30
    YLENGTH.set(30);
    //<< if $data(YPARA(20)) if $data(YPARA(21)) if YPARA(20)'=0 if YPARA(21)=1 do
    if (mOp.Logical(m$.Fnc.$data(m$.var("YPARA").var(20)))) {
      if (mOp.Logical(m$.Fnc.$data(m$.var("YPARA").var(21)))) {
        if (mOp.NotEqual(m$.var("YPARA").var(20).get(),0)) {
          if (mOp.Equal(m$.var("YPARA").var(21).get(),1)) {
            do {
              //<< . set YSORT=""
              mVar YSORT = m$.var("YSORT");
              YSORT.set("");
              //<< . set YSORT=$order(^WWWSOR(YUSER,2,YSORT))
              YSORT.set(m$.Fnc.$order(m$.var("^WWWSOR",m$.var("YUSER").get(),2,YSORT.get())));
              //<< . quit:YSORT=""
              if (mOp.Equal(YSORT.get(),"")) {
                break;
              }
              //<< . set YPARA(5)=""
              mVar YPARA = m$.var("YPARA");
              YPARA.var(5).set("");
              //<< . set YPARA(5)=$order(^WWWSOR(YUSER,2,YSORT,YPARA(5)))
              YPARA.var(5).set(m$.Fnc.$order(m$.var("^WWWSOR",m$.var("YUSER").get(),2,YSORT.get(),YPARA.var(5).get())));
              //<< . quit:YPARA(5)=""
              if (mOp.Equal(YPARA.var(5).get(),"")) {
                break;
              }
              //<< . do
              do {
                //<< . . new YA1
                mVar YA1 = m$.var("YA1");
                m$.newVar(YA1);
                //<< . . set YA=$get(^WWWSOR(YUSER,2,YSORT,YPARA(5)))
                mVar YA = m$.var("YA");
                YA.set(m$.Fnc.$get(m$.var("^WWWSOR",m$.var("YUSER").get(),2,YSORT.get(),YPARA.var(5).get())));
                //<< . . set YA1=$piece($piece(YA,"(",2),")",1)
                YA1.set(m$.Fnc.$piece(m$.Fnc.$piece(YA.get(),"(",2),")",1));
                //<< . . set YA1=$translate(YA1,"[]","()")  ;FIS;11.05.04;25691
                YA1.set(m$.Fnc.$translate(YA1.get(),"[]","()"));
                //<< . . if $length(YA1)=1 set YA1=YA  ;TYBD;8,3,2004
                if (mOp.Equal(m$.Fnc.$length(YA1.get()),1)) {
                  YA1.set(YA.get());
                }
                //<< . . if YA1=YINHALT set YA1=$piece(YA," (",1)
                if (mOp.Equal(YA1.get(),m$.var("YINHALT").get())) {
                  YA1.set(m$.Fnc.$piece(YA.get()," (",1));
                }
                //<< . . if YA1=YINHALT set YA1=YA
                if (mOp.Equal(YA1.get(),m$.var("YINHALT").get())) {
                  YA1.set(YA.get());
                }
                //<< . . if $get(YPARA(80))'="" if $find(","_YPARA(80)_",",","_YPARA(5)_",") write "<FONT COLOR="_$piece($get(^WWW100(0,"FARBMARKIERUNG",SPRACHE,1,1)),Y,1)_">"
                if (mOp.NotEqual(m$.Fnc.$get(YPARA.var(80)),"")) {
                  if (mOp.Logical(m$.Fnc.$find(mOp.Concat(mOp.Concat(",",YPARA.var(80).get()),","),mOp.Concat(mOp.Concat(",",YPARA.var(5).get()),",")))) {
                    m$.Cmd.Write(mOp.Concat(mOp.Concat("<FONT COLOR=",m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW100",0,"FARBMARKIERUNG",m$.var("SPRACHE").get(),1,1)),m$.var("Y").get(),1)),">"));
                  }
                }
                //<< . . if $get(YPARA(81))'="" if $find(","_YPARA(81)_",",","_YPARA(5)_",") write "<FONT COLOR="_$piece($get(^WWW100(0,"FARBMARKIERUNG",SPRACHE,2,1)),Y,1)_">"
                if (mOp.NotEqual(m$.Fnc.$get(YPARA.var(81)),"")) {
                  if (mOp.Logical(m$.Fnc.$find(mOp.Concat(mOp.Concat(",",YPARA.var(81).get()),","),mOp.Concat(mOp.Concat(",",YPARA.var(5).get()),",")))) {
                    m$.Cmd.Write(mOp.Concat(mOp.Concat("<FONT COLOR=",m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW100",0,"FARBMARKIERUNG",m$.var("SPRACHE").get(),2,1)),m$.var("Y").get(),1)),">"));
                  }
                }
                //<< . . if $get(YPARA(82))'="" if $find(","_YPARA(82)_",",","_YPARA(5)_",") write "<FONT COLOR="_$piece($get(^WWW100(0,"FARBMARKIERUNG",SPRACHE,3,1)),Y,1)_">"
                if (mOp.NotEqual(m$.Fnc.$get(YPARA.var(82)),"")) {
                  if (mOp.Logical(m$.Fnc.$find(mOp.Concat(mOp.Concat(",",YPARA.var(82).get()),","),mOp.Concat(mOp.Concat(",",YPARA.var(5).get()),",")))) {
                    m$.Cmd.Write(mOp.Concat(mOp.Concat("<FONT COLOR=",m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW100",0,"FARBMARKIERUNG",m$.var("SPRACHE").get(),3,1)),m$.var("Y").get(),1)),">"));
                  }
                }
                //<< . . ;WRITE "&nbsp;&nbsp;"_$EXTRACT(YA1,1,(YLAMX-YLANGE))
                //<< . . set YVALUE=YA1
                YVALUE.set(YA1.get());
                //<< . . if (YXTYP=3) || (YTYP=2) set YVALUE = $extract(YA1,1,(YLAMX-YLANGE))
                if ((mOp.Equal(m$.var("YXTYP").get(),3)) || (mOp.Equal(m$.var("YTYP").get(),2))) {
                  YVALUE.set(m$.Fnc.$extract(YA1.get(),1,(mOp.Subtract(m$.var("YLAMX").get(),m$.var("YLANGE").get()))));
                }
                //<< . . if ($extract(YPARA(2))="""") || ($find(YPARA(1),"PARA")) if YVALUE'="" set YLENGTH = $length(YVALUE)
                if ((mOp.Equal(m$.Fnc.$extract(YPARA.var(2).get()),"\"")) || mOp.Logical((m$.Fnc.$find(YPARA.var(1).get(),"PARA")))) {
                  if (mOp.NotEqual(YVALUE.get(),"")) {
                    YLENGTH.set(m$.Fnc.$length(YVALUE.get()));
                  }
                }
              } while(false);
            } while (false);
          }
        }
      }
    }
    do {
      //<< 
      //<< ;------------------------------------------------------------------------
      //<< do  ;ANZEIGE DANEBEN ;Show
      //<< . write YCR
      m$.Cmd.Write(m$.var("YCR").get());
      //<< . if YLENGTH<5 set YLENGTH=8
      if (mOp.Less(YLENGTH.get(),5)) {
        YLENGTH.set(8);
      }
      //<< . if $extract(YART)="L" if YLENGTH>17 set YLENGTH=17  ;BEI LISTGENERATOR ;next to
      if (mOp.Equal(m$.Fnc.$extract(m$.var("YART").get()),"L")) {
        if (mOp.Greater(YLENGTH.get(),17)) {
          YLENGTH.set(17);
        }
      }
      //<< . write YCR,"<INPUT NAME=""DUMMY"_YART_YLFN_""""
      m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat(mOp.Concat("<INPUT NAME=\"DUMMY",m$.var("YART").get()),m$.var("YLFN").get()),"\""));
      //<< . write YCR," SIZE="_YLENGTH_YCR_" TABINDEX=9999"_YCR_" VALUE="""_YVALUE_""""
      m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(" SIZE=",YLENGTH.get()),m$.var("YCR").get())," TABINDEX=9999"),m$.var("YCR").get())," VALUE=\""),YVALUE.get()),"\""));
      //<< . ;
      //<< . write YCR," STYLE="""
      m$.Cmd.Write(m$.var("YCR").get()," STYLE=\"");
      //<< . if $piece(YVOR,Y,77)="" if $piece(YVOR,Y,5)'="" write "border:0px solid "_$piece($get(^WWW100(0,"FARBE",SPRACHE,$piece(YVOR,Y,5),1)),Y,1)
      if (mOp.Equal(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),77),"")) {
        if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),5),"")) {
          m$.Cmd.Write(mOp.Concat("border:0px solid ",m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW100",0,"FARBE",m$.var("SPRACHE").get(),m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),5),1)),m$.var("Y").get(),1)));
        }
      }
      //<< . if $piece(YVOR,Y,77)'="" write "border:0px solid "_$piece($get(^WWW100(0,"FARBE",SPRACHE,$piece(YVOR,Y,77),1)),Y,1)
      if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),77),"")) {
        m$.Cmd.Write(mOp.Concat("border:0px solid ",m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW100",0,"FARBE",m$.var("SPRACHE").get(),m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),77),1)),m$.var("Y").get(),1)));
      }
      //<< . do LESEN1   ;TYBD;28,7,2004;STYLE
      m$.Cmd.Do("LESEN1");
      //<< . write " ;padding-top:0 "
      m$.Cmd.Write(" ;padding-top:0 ");
      //<< . write """"
      m$.Cmd.Write("\"");
      //<< . do LESEN
      m$.Cmd.Do("LESEN");
      //<< . write ">"
      m$.Cmd.Write(">");
      //<< . write "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
      m$.Cmd.Write("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
    } while(false);
    //<< 
    //<< quit
    return;
  }

  //<< 
  //<< 
  //<< PFLICHT
  public Object PFLICHT() {
    //<< ;-------------------------------------------------------------------------------
    //<< ; Mandatory Field   PFLICHTFELD
    //<< ;
    //<< ; Called By:    ANTWORT^WWWFORM7 (multiple calls)
    //<< ;-------------------------------------------------------------------------------
    //<< quit:YFOART=7       ; exclude Search Engines
    if (mOp.Equal(m$.var("YFOART").get(),7)) {
      return null;
    }
    //<< quit:+YHID'=0       ; Field must be enabled
    if (mOp.NotEqual(mOp.Positive(m$.var("YHID").get()),0)) {
      return null;
    }
    //<< 
    //<< if $piece(YVOR,Y,64)'="" {         ;    D64     $$$WWW012FontColorMandatoryInput
    if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),64),"")) {
      //<< write "; background-color:"_$piece($get(^WWW100(0,"FARBE",SPRACHE,$piece(YVOR,Y,64),1)),Y,1)    ;TYBD;26159;28.07.04
      m$.Cmd.Write(mOp.Concat("; background-color:",m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW100",0,"FARBE",m$.var("SPRACHE").get(),m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),64),1)),m$.var("Y").get(),1)));
    }
    //<< }
    //<< quit
    return null;
  }

  //<< 
  //<< LESEN1
  public void LESEN1() {
    //<< ;-------------------------------------------------------------------------------
    //<< ; Disabled field   ;LESEFELD STYLE  ;TYBD;STYLE NEU;28,7,2007
    //<< ;
    //<< ; Called By:    ^WWWFORM72 (multiple calls), ^WWWFORM7InheritableCheckBox
    //<< ;
    //<< ;-------------------------------------------------------------------------------
    //<< if $piece(YVOR,Y,77)="" {                    ; Background Color
    if (mOp.Equal(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),77),"")) {
      //<< if $piece(YVOR,Y,5)'="" write "; background-color:"_$piece($get(^WWW100(0,"FARBE",SPRACHE,$piece(YVOR,Y,5),1)),Y,1)
      if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),5),"")) {
        m$.Cmd.Write(mOp.Concat("; background-color:",m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW100",0,"FARBE",m$.var("SPRACHE").get(),m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),5),1)),m$.var("Y").get(),1)));
      }
    }
    //<< 
    //<< } else {                                     ; Frame Body Color
    else {
      //<< write "; background-color:"_$piece($get(^WWW100(0,"FARBE",SPRACHE,$piece(YVOR,Y,77),1)),Y,1)
      m$.Cmd.Write(mOp.Concat("; background-color:",m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW100",0,"FARBE",m$.var("SPRACHE").get(),m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),77),1)),m$.var("Y").get(),1)));
    }
    //<< }
    //<< quit
    return;
  }

  //<< 
  //<< LESEN
  public void LESEN() {
    //<< ;-------------------------------------------------------------------------------
    //<< ; Disabled field    ;LESEFELD
    //<< ;
    //<< ; Called By:    ^WWWFORM72 (multiple calls), ^WWWFORM7InheritableCheckBox
    //<< ;
    //<< ;-------------------------------------------------------------------------------
    //<< write YCR," readOnly"
    m$.Cmd.Write(m$.var("YCR").get()," readOnly");
    //<< if YHTMFORM="WWW2" if $piece(YVOR,Y,125)=1 write YCR," disabled"      ; D125 Display Read-Only Fields as Totally Disabled
    if (mOp.Equal(m$.var("YHTMFORM").get(),"WWW2")) {
      if (mOp.Equal(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),125),1)) {
        m$.Cmd.Write(m$.var("YCR").get()," disabled");
      }
    }
    //<< write YCR," unselectable"
    m$.Cmd.Write(m$.var("YCR").get()," unselectable");
    //<< quit
    return;
  }

  //<< 
  //<< 
  //<< STAT
  public void STAT() {
    //<< write $$STATHTML() ;SR17725
    m$.Cmd.Write(m$.fnc$("STATHTML"));
    //<< quit
    return;
  }

  //<< 
  //<< STATHTML()
  public Object STATHTML(Object ... _p) {
    //<< ;-------------------------------------------------------------------------------
    //<< ;   STATUS achtung einsprung von aussen
    //<< ;   On Mouse Over a field, display certain field details in the status area in the
    //<< ;   bottom left of the browser border based on highest user access level.
    //<< ;
    //<< ; Called By:    ^WWWFORM72 (multiple calls), ^WWWFORM7InheritableCheckBox (multiple calls)
    //<< ;
    //<< ; ByRef:                                Sys Admin   DB Admin      Other
    //<< ;   YBEDBER     Access Classes             (1)         (2)          -
    //<< ;   YSTATUS     Field Name                  *           *           *
    //<< ;   YART        Class Type (P,D,M)          *
    //<< ;   YLFN        Class Field No              *           *
    //<< ;   YBBN        Form Field No               /F
    //<< ;   YSATZ #25   Execute OnBlur              /E   "format"
    //<< ;   YSATZ #92   Exec At Form-Con (Before)   /V
    //<< ;   YSATZ #97   Exec At Form-Con (After)    /N
    //<< ;   YLANGE      Field Length?               /L
    //<< ;   YSATZ #88   Modified Field Length       /EL
    //<< ;
    //<< ; History:
    //<< ; 10-Nov-2011   shobby  SR17725: Don't write directly.  Return the HTML
    //<< ; 28-Mar-2011   GRF     SR17639: Manual fields have no class entry so no SQL
    //<< ; 10-Jan-2008   heber   SRBR014868: prevent null as subscript
    //<< ; 04-Jan-2008   heber   SRBR014794: Changed masking STAT display
    //<< ; 16-Jul-2007   HeberB  SRBR014502:Add JS for masking
    //<< ; 13-Jun-2007   GM      SRBR014498: The "property" field of a class field is
    //<< ;                           appearing in Internet Explorer's status bar when
    //<< ;                           passing the mouse over a field and if it does not
    //<< ;                           happen there's no SQL
    //<< ; 18-May-2007   GRF     Doco
    //<< ;-------------------------------------------------------------------------------
    //<< new strHTML
    mVar strHTML = m$.var("strHTML");
    m$.newVar(strHTML);
    //<< 
    //<< ;---------------------------------------
    //<< ; D25       $$$WWW122ExecuteOnBlur
    //<< ; D88       $$$WWW122ModifiedFieldLength
    //<< ; D92       $$$WWW122ExecuteBeforeDataField
    //<< ; D97       $$$WWW122ExecuteAfterDataField
    //<< ;---------------------------------------
    //<< 
    //<< set strHTML=""
    strHTML.set("");
    //<< if '$find(","_$translate(YBEDBER,";",",")_",",",1,") if $find(","_$translate(YBEDBER,";",",")_",",",2,") set YSTATUS=YSTATUS_" /"_YLFN
    if (mOp.Not(m$.Fnc.$find(mOp.Concat(mOp.Concat(",",m$.Fnc.$translate(m$.var("YBEDBER").get(),";",",")),","),",1,"))) {
      if (mOp.Logical(m$.Fnc.$find(mOp.Concat(mOp.Concat(",",m$.Fnc.$translate(m$.var("YBEDBER").get(),";",",")),","),",2,"))) {
        mVar YSTATUS = m$.var("YSTATUS");
        YSTATUS.set(mOp.Concat(mOp.Concat(m$.var("YSTATUS").get()," /"),m$.var("YLFN").get()));
      }
    }
    //<< 
    //<< if $find(","_$translate(YBEDBER,";",",")_",",",1,") {
    if (mOp.Logical(m$.Fnc.$find(mOp.Concat(mOp.Concat(",",m$.Fnc.$translate(m$.var("YBEDBER").get(),";",",")),","),",1,"))) {
      //<< set YSTATUS = YSTATUS_" /"_YART_YLFN_"/F"_$get(YBBN)_"/E"_$translate($piece(YSATZ,Y,25),"""<>'´`;")_"/V"_$translate($piece(YSATZ,Y,92),"""<>'´`;")_"/N"_$translate($piece(YSATZ,Y,97),"""<>'´`;")_"/L"_YLANGE_"/EL"_$piece(YSATZ,Y,88)
      mVar YSTATUS = m$.var("YSTATUS");
      YSTATUS.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(m$.var("YSTATUS").get()," /"),m$.var("YART").get()),m$.var("YLFN").get()),"/F"),m$.Fnc.$get(m$.var("YBBN"))),"/E"),m$.Fnc.$translate(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),25),"\"<>'´`;")),"/V"),m$.Fnc.$translate(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),92),"\"<>'´`;")),"/N"),m$.Fnc.$translate(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),97),"\"<>'´`;")),"/L"),m$.var("YLANGE").get()),"/EL"),m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),88)));
      //<< set YSTATUS = YSTATUS_"/SQL="
      YSTATUS.set(mOp.Concat(YSTATUS.get(),"/SQL="));
      //<< 
      //<< ;   if ($get(YDATEI)'="") && ($get(YLFN)'="") {  ; SR17639
      //<< if ($get(YDATEI)'="") && ($get(YLFN)'="") && (YART'="M") {
      if ((mOp.NotEqual(m$.Fnc.$get(m$.var("YDATEI")),"")) && (mOp.NotEqual(m$.Fnc.$get(m$.var("YLFN")),"")) && (mOp.NotEqual(m$.var("YART").get(),"M"))) {
        //<< if YART="P" {
        if (mOp.Equal(m$.var("YART").get(),"P")) {
          //<< set YSTATUS = YSTATUS_$$$WWW002PropertyName($get(^WWW002(0,YDATEI,YLFN,1))) ;ERFASSUNGSART
          YSTATUS.set(mOp.Concat(YSTATUS.get(),include.WWWConst.$$$WWW002PropertyName(m$,m$.Fnc.$get(m$.var("^WWW002",0,m$.var("YDATEI").get(),m$.var("YLFN").get(),1)))));
        }
        //<< } else {
        else {
          //<< set YSTATUS = YSTATUS_$$$WWW003PropertyName($get(^WWW003(0,YDATEI,YLFN,1))) ;ERFASSUNGSART
          YSTATUS.set(mOp.Concat(YSTATUS.get(),include.WWWConst.$$$WWW003PropertyName(m$,m$.Fnc.$get(m$.var("^WWW003",0,m$.var("YDATEI").get(),m$.var("YLFN").get(),1)))));
        }
      }
      //<< }
      //<< } else {
      else {
        //<< set YSTATUS = YSTATUS_"<no SQL>"
        YSTATUS.set(mOp.Concat(YSTATUS.get(),"<no SQL>"));
      }
    }
    //<< }
    //<< }
    //<< 
    //<< if ($get(YUSER)'="") && ($get(YUCI)'="") && ($get(YFORM)'="") && ($get(YBBN)'="") &&
    //<< ($get(^CacheTempMasking($get(YUSER),$get(YUCI),$get(YFORM),$get(YBBN))) = $$$YES) {
    if ((mOp.NotEqual(m$.Fnc.$get(m$.var("YUSER")),"")) && (mOp.NotEqual(m$.Fnc.$get(m$.var("YUCI")),"")) && (mOp.NotEqual(m$.Fnc.$get(m$.var("YFORM")),"")) && (mOp.NotEqual(m$.Fnc.$get(m$.var("YBBN")),"")) && (mOp.Equal(m$.Fnc.$get(m$.var("^CacheTempMasking",m$.Fnc.$get(m$.var("YUSER")),m$.Fnc.$get(m$.var("YUCI")),m$.Fnc.$get(m$.var("YFORM")),m$.Fnc.$get(m$.var("YBBN")))),include.COMSYS.$$$YES(m$)))) {
      //<< set strHTML=strHTML_YCR_" onMouseover='window.status="""_YSTATUS_" "" + "_$$GetMaskVarName^WWWFORM8(YFORM, YBBN)_";'"
      strHTML.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(strHTML.get(),m$.var("YCR").get())," onMouseover='window.status=\""),m$.var("YSTATUS").get())," \" + "),m$.fnc$("WWWFORM8.GetMaskVarName",m$.var("YFORM").get(),m$.var("YBBN").get())),";'"));
    }
    //<< 
    //<< } else {
    else {
      //<< set strHTML=strHTML_YCR_" onMouseover='window.status="""_YSTATUS_""";'"
      strHTML.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(strHTML.get(),m$.var("YCR").get())," onMouseover='window.status=\""),m$.var("YSTATUS").get()),"\";'"));
    }
    //<< }
    //<< set strHTML=strHTML_YCR_" onMouseout='window.status="""";'"
    strHTML.set(mOp.Concat(mOp.Concat(strHTML.get(),m$.var("YCR").get())," onMouseout='window.status=\"\";'"));
    //<< quit strHTML ;SR17725
    return strHTML.get();
  }

  //<< 
  //<< 
  //<< FARBE ;FARBE AUSWÄHLEN ;colour pick out
  public void FARBE() {
    //<< if YPARA(5)'=8 if $translate(YPARA(5)," ")'="" write YCR," STYLE=""background-color: "_$piece($get(^WWW100(0,"FARBE",SPRACHE,YPARA(5),1)),Y,1)_""""
    if (mOp.NotEqual(m$.var("YPARA").var(5).get(),8)) {
      if (mOp.NotEqual(m$.Fnc.$translate(m$.var("YPARA").var(5).get()," "),"")) {
        m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat(" STYLE=\"background-color: ",m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW100",0,"FARBE",m$.var("SPRACHE").get(),m$.var("YPARA").var(5).get(),1)),m$.var("Y").get(),1)),"\""));
      }
    }
    //<< quit
    return;
  }

  //<< 
  //<< 
  //<< FARBE1
  public void FARBE1() {
    //<< ;-------------------------------------------------------------------------------
    //<< ; Colour within
    //<< ;
    //<< ; ByRef:    YSATZ
    //<< ;           YPARA(5)
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 07-Sep-2012   SCR     SR18105: Color code for form VARPARA
    //<< ; 28-Mar-2011   shobby  SR17680.1: Put a $get around YCOLOR1 to remove crash if
    //<< ;                           undefined.
    //<< ; 09-Mar-2011   shobby  SR17680: Unfortunately need to call out to the IN module
    //<< ;                           to find colour codes for INItemStatus
    //<< ;-------------------------------------------------------------------------------
    //<< new COLOR
    mVar COLOR = m$.var("COLOR");
    m$.newVar(COLOR);
    //<< 
    //<< quit:YPARA(5)=""
    if (mOp.Equal(m$.var("YPARA").var(5).get(),"")) {
      return;
    }
    //<< set COLOR = ""
    COLOR.set("");
    //<< 
    //<< if $$$WWW122RelationClass(YSATZ)="INItemStatus" {      ; SR17680
    if (mOp.Equal(include.WWWConst.$$$WWW122RelationClass(m$,m$.var("YSATZ")),"INItemStatus")) {
      //<< set COLOR = $$GetColorCode^INItemStatus(YPARA(5))  ; SR17680
      COLOR.set(m$.fnc$("INItemStatus.GetColorCode",m$.var("YPARA").var(5).get()));
    }
    //<< 
    //<< } elseif ($piece($get(YCOLOR1),",",1)'="") && ($piece(YCOLOR1,",",2)'=""){
    else if ((mOp.NotEqual(m$.Fnc.$piece(m$.Fnc.$get(m$.var("YCOLOR1")),",",1),"")) && (mOp.NotEqual(m$.Fnc.$piece(m$.var("YCOLOR1").get(),",",2),""))) {
      //<< set COLOR = $piece($get(^WWW101(0,$translate($piece(YCOLOR1,",",1),""""),SPRACHE,YPARA(5),1)),Y,2)
      COLOR.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW101",0,m$.Fnc.$translate(m$.Fnc.$piece(m$.var("YCOLOR1").get(),",",1),"\""),m$.var("SPRACHE").get(),m$.var("YPARA").var(5).get(),1)),m$.var("Y").get(),2));
      //<< if COLOR="" set COLOR = $piece($get(^INPARA(0,$translate($piece(YCOLOR1,",",1),""""),SPRACHE,YPARA(5),1)),Y,2)
      if (mOp.Equal(COLOR.get(),"")) {
        COLOR.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^INPARA",0,m$.Fnc.$translate(m$.Fnc.$piece(m$.var("YCOLOR1").get(),",",1),"\""),m$.var("SPRACHE").get(),m$.var("YPARA").var(5).get(),1)),m$.var("Y").get(),2));
      }
      //<< if COLOR="" set COLOR = $piece($get(^VARPARA(0,$translate($piece(YCOLOR1,",",1),""""),SPRACHE,YPARA(5),1)),Y,2) ; SR18105
      if (mOp.Equal(COLOR.get(),"")) {
        COLOR.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^VARPARA",0,m$.Fnc.$translate(m$.Fnc.$piece(m$.var("YCOLOR1").get(),",",1),"\""),m$.var("SPRACHE").get(),m$.var("YPARA").var(5).get(),1)),m$.var("Y").get(),2));
      }
    }
    //<< }
    //<< quit:$translate(COLOR," ")=""
    if (mOp.Equal(m$.Fnc.$translate(COLOR.get()," "),"")) {
      return;
    }
    //<< write YCR," STYLE=""background-color: "_$piece($get(^WWW100(0,"FARBE",SPRACHE,COLOR,1)),Y,1)_""""
    m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat(" STYLE=\"background-color: ",m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW100",0,"FARBE",m$.var("SPRACHE").get(),COLOR.get(),1)),m$.var("Y").get(),1)),"\""));
    //<< quit
    return;
  }

  //<< 
  //<< 
  //<< FARBE2 ;FARBE IN DATENFELD ;colour within data item
  public void FARBE2() {
    //<< ; History:
    //<< ; 07-Sep-2012   SCR     SR18105: Color code for form VARPARA
    //<< new COLOR
    mVar COLOR = m$.var("COLOR");
    m$.newVar(COLOR);
    //<< 
    //<< quit:$piece(YCOLOR1,",",1)=""
    if (mOp.Equal(m$.Fnc.$piece(m$.var("YCOLOR1").get(),",",1),"")) {
      return;
    }
    //<< quit:$piece(YCOLOR1,",",2)=""
    if (mOp.Equal(m$.Fnc.$piece(m$.var("YCOLOR1").get(),",",2),"")) {
      return;
    }
    //<< quit:YPARA(5)=""
    if (mOp.Equal(m$.var("YPARA").var(5).get(),"")) {
      return;
    }
    //<< 
    //<< set COLOR = $piece($get(^WWW101(0,$translate($piece(YCOLOR1,",",1),""""),SPRACHE,YPARA(5),1)),Y,2)
    COLOR.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW101",0,m$.Fnc.$translate(m$.Fnc.$piece(m$.var("YCOLOR1").get(),",",1),"\""),m$.var("SPRACHE").get(),m$.var("YPARA").var(5).get(),1)),m$.var("Y").get(),2));
    //<< if COLOR="" set COLOR = $piece($get(^INPARA(0,$translate($piece(YCOLOR1,",",1),""""),SPRACHE,YPARA(5),1)),Y,2)
    if (mOp.Equal(COLOR.get(),"")) {
      COLOR.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^INPARA",0,m$.Fnc.$translate(m$.Fnc.$piece(m$.var("YCOLOR1").get(),",",1),"\""),m$.var("SPRACHE").get(),m$.var("YPARA").var(5).get(),1)),m$.var("Y").get(),2));
    }
    //<< if COLOR="" set COLOR = $piece($get(^VARPARA(0,$translate($piece(YCOLOR1,",",1),""""),SPRACHE,YPARA(5),1)),Y,2)
    if (mOp.Equal(COLOR.get(),"")) {
      COLOR.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^VARPARA",0,m$.Fnc.$translate(m$.Fnc.$piece(m$.var("YCOLOR1").get(),",",1),"\""),m$.var("SPRACHE").get(),m$.var("YPARA").var(5).get(),1)),m$.var("Y").get(),2));
    }
    //<< quit:$translate(COLOR," ")=""
    if (mOp.Equal(m$.Fnc.$translate(COLOR.get()," "),"")) {
      return;
    }
    //<< write "; background-color:"_$piece($get(^WWW100(0,"FARBE",SPRACHE,COLOR,1)),Y,1)
    m$.Cmd.Write(mOp.Concat("; background-color:",m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW100",0,"FARBE",m$.var("SPRACHE").get(),COLOR.get(),1)),m$.var("Y").get(),1)));
    //<< quit
    return;
  }

  //<< 
  //<< 
  //<< SAVE
  public void SAVE() {
    //<< ;if +$get(^SysSetup("FieldEvents")) {       ; FIXME : Replace/Remove?
    //<< ;   do SAVEPHIL3^PJOSAVE                    ;         No Longer exists but other ^SysSetup("FieldEvents") entries are present
    //<< ;} else {
    //<< ;   do SAVEORIG
    //<< ;}
    //<< do SAVEORIG
    m$.Cmd.Do("SAVEORIG");
    //<< quit
    return;
  }

  //<< 
  //<< 
  //<< SAVEORIG ;event broker oder savenow ;or
  public void SAVEORIG() {
    //<< ;-------------------------------------------------------------------------------
    //<< ; History:
    //<< ; 06-Sep-2010   shobby  SR17449: Make Enter work as tab key for firefox.
    //<< ; 28-Oct-2009   shobby  SR16942: VariableForEventBroker call.
    //<< ; 10-Feb-2009   shobby  SR16126:Made previous change optional based on a company parameter.
    //<< ; 12-Nov-2008   shobby  SR16126:Simulate commas in a primary key.
    //<< ; 04-Jan-2008   HeberB  SRBR014794: Replaced masking funtions
    //<< ; 16-Jul-2007   HeberB  SRBR014502: Add JS masking code if needed
    //<< ; 10-Aug-2006   JW      SR13594: Encapsulated -> HyperEvent^WWWFORM75
    //<< ;  9-Dec-2005   JW      SR13195: Rewrote submitting. Ignore OnKeyDown.
    //<< ; 28-Oct-2005   JW      SR13074: Exchange Rate type
    //<< ;-------------------------------------------------------------------------------
    //<< new THISVALUE,strEvent   ;TYBD; 26.03.2003; WEGEN DER RADIOBUTTONS
    mVar THISVALUE = m$.var("THISVALUE");
    mVar strEvent = m$.var("strEvent");
    m$.newVar(THISVALUE,strEvent);
    //<< 
    //<< set THISVALUE="this.value"
    THISVALUE.set("this.value");
    //<< if YXTYP'=4 if YXTYP'=6 if YXTYP'=1 if YART'="P" if YPARA(7)>1 if (YXTYP=2) || (YXTYP=11) set THISVALUE=""""_$get(YPARA(5))_""""
    if (mOp.NotEqual(m$.var("YXTYP").get(),4)) {
      if (mOp.NotEqual(m$.var("YXTYP").get(),6)) {
        if (mOp.NotEqual(m$.var("YXTYP").get(),1)) {
          if (mOp.NotEqual(m$.var("YART").get(),"P")) {
            if (mOp.Greater(m$.var("YPARA").var(7).get(),1)) {
              if ((mOp.Equal(m$.var("YXTYP").get(),2)) || (mOp.Equal(m$.var("YXTYP").get(),11))) {
                THISVALUE.set(mOp.Concat(mOp.Concat("\"",m$.Fnc.$get(m$.var("YPARA").var(5))),"\""));
              }
            }
          }
        }
      }
    }
    //<< 
    //<< if YART'="P" do
    if (mOp.NotEqual(m$.var("YART").get(),"P")) {
      do {
        //<< . quit:YTYP=3
        if (mOp.Equal(m$.var("YTYP").get(),3)) {
          break;
        }
        //<< . quit:YXTYP=5
        if (mOp.Equal(m$.var("YXTYP").get(),5)) {
          break;
        }
        //<< . ;SR17449 IF '$$SimulateCommainPrimaryKey^WWW012() IF YTYPE'="FILE" if YPARA(1)=""  WRITE YCR," onKeyDown='if (document.all) {if (event.keyCode == 13) event.keyCode = 9;}'" QUIT  ;ENTER=NEXTFELD ;tybd;26159;mozilla;9,8,2004 ;16126
        //<< . ;SR17449 IF $$SimulateCommainPrimaryKey^WWW012()  IF YTYPE'="FILE" if YPARA(1)'="" WRITE YCR," onKeyDown='if (document.all) {if (event.keyCode == 13) {event.keyCode = 9;} else if (event.keyCode==188) {window.event.returnValue=false; this.value=this.value+"""_$$$FAKECOMMA_"""} }'" QUIT  ;tybd;26159;mozilla;9,8,2004 ;16126
        //<< . if '$$SimulateCommainPrimaryKey^WWW012() if YTYPE'="FILE" if YPARA(1)=""  write YCR," onKeyDown='switchKey(13,9);'" quit  ;ENTER=NEXTFELD ;tybd;26159;mozilla;9,8,2004 ;16126 ;SR17449
        if (mOp.Not(m$.fnc$("WWW012.SimulateCommainPrimaryKey"))) {
          if (mOp.NotEqual(m$.var("YTYPE").get(),"FILE")) {
            if (mOp.Equal(m$.var("YPARA").var(1).get(),"")) {
              m$.Cmd.Write(m$.var("YCR").get()," onKeyDown='switchKey(13,9);'");
              break;
            }
          }
        }
        //<< . if $$SimulateCommainPrimaryKey^WWW012()  if YTYPE'="FILE" if YPARA(1)'="" write YCR," onKeyDown='switchKey(13,9); if (event.keyCode==188) {window.event.returnValue=false; this.value=this.value+"""_$$$FAKECOMMA_"""} '" quit  ;tybd;26159;mozilla;9,8,2004 ;16126  ;SR17449
        if (mOp.Logical(m$.fnc$("WWW012.SimulateCommainPrimaryKey"))) {
          if (mOp.NotEqual(m$.var("YTYPE").get(),"FILE")) {
            if (mOp.NotEqual(m$.var("YPARA").var(1).get(),"")) {
              m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat(" onKeyDown='switchKey(13,9); if (event.keyCode==188) {window.event.returnValue=false; this.value=this.value+\"",include.COMSYSString.$$$FAKECOMMA(m$)),"\"} '"));
              break;
            }
          }
        }
        //<< . write YCR," onKeyDown='if (document.all) {if (event.keyCode == 13) event.returnValue=false;}'"   ;ENTER="" ;tybd;26159;mozilla;9,8,2004
        m$.Cmd.Write(m$.var("YCR").get()," onKeyDown='if (document.all) {if (event.keyCode == 13) event.returnValue=false;}'");
      } while (false);
    }
    //<< 
    //<< do PrintJSMasking(YART,YTYP,YFORM,YBBN,YSATZ)
    m$.Cmd.Do("PrintJSMasking",m$.var("YART").get(),m$.var("YTYP").get(),m$.var("YFORM").get(),m$.var("YBBN").get(),m$.var("YSATZ").get());
    //<< 
    //<< new YVARIA
    mVar YVARIA = m$.var("YVARIA");
    m$.newVar(YVARIA);
    //<< set YVARIA=$$VariableForEventBroker()
    YVARIA.set(m$.fnc$("VariableForEventBroker"));
    //<< 
    //<< ;------------------------------------------------------------------------
    //<< if $get(YHTMFORM)'="WWW2" if YHID=2 if YART="P" quit   ;NUR READ ONLY ;only READ
    if (mOp.NotEqual(m$.Fnc.$get(m$.var("YHTMFORM")),"WWW2")) {
      if (mOp.Equal(m$.var("YHID").get(),2)) {
        if (mOp.Equal(m$.var("YART").get(),"P")) {
          return;
        }
      }
    }
    //<< 
    //<< if YPARA(1)="" if (YTYP=8) || (YTYP=4) || (YTYP=7) || (YTYP=2) || (YTYP=12) || (YTYP=1) || (YTYP=18) if $piece(YSATZ,Y,25)="" set $piece(YSATZ,Y,25)="format"   ;automatischesformat  ;TYBD;2.5.2003    //SR13074
    if (mOp.Equal(m$.var("YPARA").var(1).get(),"")) {
      if ((mOp.Equal(m$.var("YTYP").get(),8)) || (mOp.Equal(m$.var("YTYP").get(),4)) || (mOp.Equal(m$.var("YTYP").get(),7)) || (mOp.Equal(m$.var("YTYP").get(),2)) || (mOp.Equal(m$.var("YTYP").get(),12)) || (mOp.Equal(m$.var("YTYP").get(),1)) || (mOp.Equal(m$.var("YTYP").get(),18))) {
        if (mOp.Equal(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),25),"")) {
          m$.pieceVar(m$.var("YSATZ"),m$.var("Y").get(),25).set("format");
        }
      }
    }
    //<< if $$$WWW120ConstantFieldValidating(YVOR)=1 if $piece(YSATZ,Y,25)=""                                     set $piece(YSATZ,Y,25)="format"  ;IMMER EVENTBROKER ;constantly
    if (mOp.Equal(include.WWWConst.$$$WWW120ConstantFieldValidating(m$,m$.var("YVOR")),1)) {
      if (mOp.Equal(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),25),"")) {
        m$.pieceVar(m$.var("YSATZ"),m$.var("Y").get(),25).set("format");
      }
    }
    //<< if $piece(YSATZ,Y,25)="" if ($piece(YSATZ,Y,17)'="") || ($piece(YSATZ,Y,18)'="") || (+$piece(YSATZ,Y,19)'=0) set $piece(YSATZ,Y,25)="format"  ; automatischesformat
    if (mOp.Equal(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),25),"")) {
      if ((mOp.NotEqual(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),17),"")) || (mOp.NotEqual(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),18),"")) || (mOp.NotEqual(mOp.Positive(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),19)),0))) {
        m$.pieceVar(m$.var("YSATZ"),m$.var("Y").get(),25).set("format");
      }
    }
    //<< 
    //<< if YHID=2 if YART'="P" if YXTYP'=1 if $$$WWW122ExecuteOnBlur(YSATZ)="format" do  quit  ;READ ONLY FELD;TYBD;06,07,2003;23862;
    if (mOp.Equal(m$.var("YHID").get(),2)) {
      if (mOp.NotEqual(m$.var("YART").get(),"P")) {
        if (mOp.NotEqual(m$.var("YXTYP").get(),1)) {
          if (mOp.Equal(include.WWWConst.$$$WWW122ExecuteOnBlur(m$,m$.var("YSATZ")),"format")) {
            //<< . if YPARA(20)=1 set YSHOWRELA=1  ;TYBD/BEC;27468;11,3,2005;RELATION ANZEIGEN Z.B. CHECKFELD;#
            if (mOp.Equal(m$.var("YPARA").var(20).get(),1)) {
              mVar YSHOWRELA = m$.var("YSHOWRELA");
              YSHOWRELA.set(1);
            }
            return;
          }
        }
      }
    }
    //<< 
    //<< ;------------------------------------------------------------------------
    //<< ;HYPEREVENT AB HIER ;Confirm. here is
    //<< 
    //<< do HyperEvent^WWWFORM75()
    m$.Cmd.Do("WWWFORM75.HyperEvent");
    //<< 
    //<< quit
    return;
  }

  //<< 
  //<< 
  //<< VariableForEventBroker()
  public Object VariableForEventBroker(Object ... _p) {
    //<< ;-------------------------------------------------------------------------------
    //<< ;
    //<< ;
    //<< ; Inputs:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 28-Oct-2009   shobby  SR16942: Subroutine of existing code.
    //<< ;-------------------------------------------------------------------------------
    //<< new YVARIA
    mVar YVARIA = m$.var("YVARIA");
    m$.newVar(YVARIA);
    //<< 
    //<< set YVARIA="NOVALUE"  ;VARIABLE FÜR EVENTBROKER  ;to
    YVARIA.set("NOVALUE");
    //<< if $piece(YSATZ,Y,68)'="" do
    if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),68),"")) {
      do {
        //<< . if $extract($piece(YSATZ,Y,68))="@" do  quit  ;FIS;05.06.03;23752;FELDNUMMERM ALS VARIABLE ZUR SPEICHERUNG IN WWWEVENT
        if (mOp.Equal(m$.Fnc.$extract(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),68)),"@")) {
          //<< . . set $piece(YSATZ,Y,68)=$extract($piece(YSATZ,Y,68),2,99)
          m$.pieceVar(m$.var("YSATZ"),m$.var("Y").get(),68).set(m$.Fnc.$extract(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),68),2,99));
          //<< . . set YVARIA="MORE"
          YVARIA.set("MORE");
          //<< . . for YVARIA(2)=1:1 set YVARIA(3)=$piece($piece(YSATZ,Y,68),",",YVARIA(2)) quit:YVARIA(3)=""  do  ;TEIL AUS VARIABLE ;part out of
          for (m$.var("YVARIA",2).set(1);(true);m$.var("YVARIA",2).set(mOp.Add(m$.var("YVARIA",2).get(),1))) {
            YVARIA.var(3).set(m$.Fnc.$piece(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),68),",",YVARIA.var(2).get()));
            if (mOp.Equal(YVARIA.var(3).get(),"")) {
              break;
            }
            //<< . . . if YVARIA(2)>1 set YVARIA=YVARIA_Y
            if (mOp.Greater(YVARIA.var(2).get(),1)) {
              YVARIA.set(mOp.Concat(YVARIA.get(),m$.var("Y").get()));
            }
            //<< . . . set YVARIA=YVARIA_"""+ document."_YHTMFORM_".Y"_YFORM_YART_YVARIA(3)_".value + """
            YVARIA.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(YVARIA.get(),"\"+ document."),m$.var("YHTMFORM").get()),".Y"),m$.var("YFORM").get()),m$.var("YART").get()),YVARIA.var(3).get()),".value + \""));
          }
          break;
        }
        //<< . ;
        //<< . if '$find($piece(YSATZ,Y,68),",") if $get(@($piece(YSATZ,Y,68)))'="" set YVARIA=@($piece(YSATZ,Y,68))  quit   ;ZUSATZVARIABEL ÜBERGEBEN ;transfer
        if (mOp.Not(m$.Fnc.$find(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),68),","))) {
          if (mOp.NotEqual(m$.Fnc.$get(m$.indirectVar((m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),68)))),"")) {
            YVARIA.set(m$.indirectVar((m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),68))).get());
            break;
          }
        }
        //<< . if $find($piece(YSATZ,Y,68),",") do   ;MEHRFACHVARIABLEN
        if (mOp.Logical(m$.Fnc.$find(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),68),","))) {
          //<< . . set YVARIA=""
          YVARIA.set("");
          //<< . . for YVARIA(2)=1:1 set YVARIA(3)=$piece($piece(YSATZ,Y,68),",",YVARIA(2)) quit:YVARIA(3)=""  do  ;TEIL AUS VARIABLE ;part out of
          for (m$.var("YVARIA",2).set(1);(true);m$.var("YVARIA",2).set(mOp.Add(m$.var("YVARIA",2).get(),1))) {
            YVARIA.var(3).set(m$.Fnc.$piece(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),68),",",YVARIA.var(2).get()));
            if (mOp.Equal(YVARIA.var(3).get(),"")) {
              break;
            }
            //<< . . . if $get(@(YVARIA(3)))'="" set YVARIA=YVARIA_@(YVARIA(3))_"_"
            if (mOp.NotEqual(m$.Fnc.$get(m$.indirectVar((YVARIA.var(3).get()))),"")) {
              YVARIA.set(mOp.Concat(mOp.Concat(YVARIA.get(),m$.indirectVar((YVARIA.var(3).get())).get()),"_"));
            }
          }
        }
      } while (false);
    }
    //<< quit YVARIA
    return YVARIA.get();
  }

  //<< 
  //<< 
  //<< READONLY
  public void READONLY() {
    //<< ;------------------------------------------------------------------------
    //<< ;   bei onchange=readOnly ANDERER FELDER;TYBD;4,5,2004
    //<< ;
    //<< ; Called By:    ^WWWFORM72 (multiple calls), ^WWWFORM7InheritableCheckBox
    //<< ;
    //<< ;------------------------------------------------------------------------
    //<< do READONLY^WWWFORM75
    m$.Cmd.Do("WWWFORM75.READONLY");
    //<< quit
    return;
  }

  //<< 
  //<< WRITE
  public void WRITE() {
    //<< ;------------------------------------------------------------------------
    //<< ;   bei onchange=write enable ANDERER FELDERTYBD;4,5,2004
    //<< ;
    //<< ; Called By:    ^WWWFORM72 (multiple calls), ^WWWFORM7InheritableCheckBox
    //<< ;
    //<< ;------------------------------------------------------------------------
    //<< do WRITE^WWWFORM75
    m$.Cmd.Do("WWWFORM75.WRITE");
    //<< quit
    return;
  }

  //<< 
  //<< PARASUCH ; DEPRECATED
  public void PARASUCH() {
    //<< ;------------------------------------------------------------------------
    //<< ;   Parameter Search        PARAMETERSUCHE
    //<< ;
    //<< ; Please provide direct call to PARASUCH^WWWFORM75 in future - it appears
    //<< ; there are no calls to this tag outside this routine.
    //<< ;------------------------------------------------------------------------
    //<< do PARASUCH^WWWFORM75
    m$.Cmd.Do("WWWFORM75.PARASUCH");
    //<< quit
    return;
  }

  //<< 
  //<< 
  //<< ;SR17701 GetCoreMask(pYFELD,pYMFELD,pobjWWW122)
  //<< ;SR17701 ;-------------------------------------------------------------------------------
  //<< ;SR17701 ; Returns from WWW122, the mask to be applied to the field.
  //<< ;SR17701 ; Finds which mask should be applied.
  //<< ;SR17701 ;
  //<< ;SR17701 ; Called By: ApplyCoreMasking^WWWFORM8, JSInitializingMasking^WWWFORM8, FieldValidation^WWWEVENT
  //<< ;SR17701 ;
  //<< ;SR17701 ; History:
  //<< ;SR17701 ;
  //<< ;SR17701 ; 30-Mar-2009  shobby  SR16459: subroutine restored from SES/DEV merge.
  //<< ;SR17701 ; 15-Feb-2008  GRF     Corrected new list
  //<< ;SR17701 ; 04-Jan-2008  HeberB  SRBR014794: Created
  //<< ;SR17701 ;-------------------------------------------------------------------------------
  //<< ;SR17701 new idDataField,objWWW122,strConditionValue,strForm,strMask,strMask2,strValueAtField
  //<< 
  //<< ;SR17701 ; FIXME : <GRF> bad naming objWWW122 and pobjWWW122 - potential for error
  //<< ;SR17701 ;               and harder to follow
  //<< ;SR17701 quit $$$WWW122Mask($$Get^WWW122(YFORM,4)) ;SR17701
  //<< ;SR17701 set strForm = YFORM               ; FIXME : <GRF> not used
  //<< 
  //<< ;SR17701 set strMask           = $$$WWW122Mask(pobjWWW122)
  //<< ;SR17701 set strMask2          = $$$WWW122Mask2(pobjWWW122)
  //<< ;SR17701 set strConditionValue = $$$WWW122Contains(pobjWWW122)
  //<< ;SR17701 set idDataField       = $$$WWW122ApplyMaskIfDataField(pobjWWW122)
  //<< ;SR17701 set strValueAtField = ""
  //<< ;SR17701 ; A Data (D) or Manual (M) field may have been chosen
  //<< ;SR17701 ; check type of field
  //<< 
  //<< ;SR17701 ; get type of condition field
  //<< ;SR17701 if (idDataField '= "") {
  //<< ;SR17701    set objWWW122 = $get(^WWW122(0,YFORM,idDataField,1))
  //<< 
  //<< ;SR17701    if ($$$WWW122SequenceNumber(objWWW122) = "") {
  //<< ;SR17701        ; Manual field - uses YMFELD
  //<< ;SR17701        if (pYMFELD '= "") set strValueAtField = $piece(pYMFELD,Y,idDataField)
  //<< ;SR17701    } else {
  //<< ;SR17701        ; Data field - uses YFELD
  //<< ;SR17701        set strValueAtField = $piece(pYFELD,Y,idDataField)
  //<< ;SR17701    }
  //<< ;SR17701 }
  //<< ;SR17701 ; there is a condition on WWW122 to be checked
  //<< ;SR17701 if (idDataField '= "") && (strConditionValue '= "") {
  //<< ;SR17701    if (strValueAtField '= strConditionValue) {
  //<< ;SR17701        set strMask = strMask2
  //<< ;SR17701    }
  //<< ;SR17701 }
  //<< ;SR17701 quit strMask
  //<< 
  //<< 
  //<< PrintJSMasking(pstrYART,pstrYTYP,pidYFORM,pidYBBN,pobjWWW122)
  public Object PrintJSMasking(Object ... _p) {
    mVar pstrYART = m$.newVarRef("pstrYART",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pstrYTYP = m$.newVarRef("pstrYTYP",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pidYFORM = m$.newVarRef("pidYFORM",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    mVar pidYBBN = m$.newVarRef("pidYBBN",(((_p!=null)&&(_p.length>=4))?_p[3]:null));
    mVar pobjWWW122 = m$.newVarRef("pobjWWW122",(((_p!=null)&&(_p.length>=5))?_p[4]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Add JS code to apply masking to field on Key Up
    //<< ;
    //<< ; History:
    //<< ; 30-Mar-2009   shobby  SR16459: subroutine restored from SES/DEV merge.
    //<< ; 30-May-2008   heber   SRBR014945: enable special chars when date masking active
    //<< ; 04-Jan-2008   HeberB  SRBR014794: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new strJSMaskedFieldName
    mVar strJSMaskedFieldName = m$.var("strJSMaskedFieldName");
    m$.newVar(strJSMaskedFieldName);
    //<< 
    //<< ; only TEXT/Date type and not KEYs field
    //<< quit:'($$$IsToMask(pstrYART,pstrYTYP))
    if (mOp.Not((include.COMSYSWWW.$$$IsToMask(m$,pstrYART,pstrYTYP)))) {
      return null;
    }
    //<< 
    //<< // is guaranteed that this code comes surely after WWWFORM8
    //<< 
    //<< if ($get(^CacheTempMasking(YUSER,YUCI,pidYFORM,pidYBBN)) = $$$YES) {
    if ((mOp.Equal(m$.Fnc.$get(m$.var("^CacheTempMasking",m$.var("YUSER").get(),m$.var("YUCI").get(),pidYFORM.get(),pidYBBN.get())),include.COMSYS.$$$YES(m$)))) {
      //<< set strJSMaskedFieldName = $$GetMaskVarName^WWWFORM8(pidYFORM, pidYBBN)
      strJSMaskedFieldName.set(m$.fnc$("WWWFORM8.GetMaskVarName",pidYFORM.get(),pidYBBN.get()));
      //<< write YCR," onKeyUp='if (document.all) {"
      m$.Cmd.Write(m$.var("YCR").get()," onKeyUp='if (document.all) {");
      //<< ; SRBR014945 ---vvvvvv
      //<< ; WRITE YCR,"    this.value = doMasking("_strJSMaskedFieldName_",this.value,event.keyCode);"
      //<< ; WRITE YCR," }'"
      //<< 
      //<< ; keep special character for date fields
      //<< if (pstrYTYP = 1) {                                  ; 1 - DateType
      if ((mOp.Equal(pstrYTYP.get(),1))) {
        //<< write YCR,"  textInput = this.value;"
        m$.Cmd.Write(m$.var("YCR").get(),"  textInput = this.value;");
        //<< write YCR,"  if ((this.value != ""."")&&(textInput.charAt(0) != ""+"")&&(textInput.charAt(0) != ""-"")) {"
        m$.Cmd.Write(m$.var("YCR").get(),"  if ((this.value != \".\")&&(textInput.charAt(0) != \"+\")&&(textInput.charAt(0) != \"-\")) {");
        //<< write YCR,"  this.value = doMasking("_strJSMaskedFieldName_",this.value,event.keyCode);"
        m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat("  this.value = doMasking(",strJSMaskedFieldName.get()),",this.value,event.keyCode);"));
        //<< write YCR,"  }"
        m$.Cmd.Write(m$.var("YCR").get(),"  }");
      }
      //<< } else {
      else {
        //<< write YCR,"  this.value = doMasking("_strJSMaskedFieldName_",this.value,event.keyCode);"
        m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat("  this.value = doMasking(",strJSMaskedFieldName.get()),",this.value,event.keyCode);"));
      }
      //<< }
      //<< write YCR," }'"
      m$.Cmd.Write(m$.var("YCR").get()," }'");
    }
    //<< ;
    //<< ;----^^^^^^
    //<< }
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< CheckMask(pstrMask,&plstError)
  public Object CheckMask(Object ... _p) {
    mVar pstrMask = m$.newVarRef("pstrMask",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar plstError = m$.newVarRef("plstError",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Verifies whether mask holds only valid characters
    //<< ; Char ' is invalid because of a bug on IE (see SRBR014502)
    //<< ; Called when mask is saved
    //<< ;
    //<< ; Returns: <empty>  if valid
    //<< ;          <list> if error, mask, invalid char and position
    //<< ;
    //<< ; History:
    //<< ; 27-Jul-2007   HeberB      SRBR014502:Created
    //<< ;-------------------------------------------------------------------------------
    //<< new blnError,intChar,intLen,intState,loop,lstInvalidChars,lstNumbers
    mVar blnError = m$.var("blnError");
    mVar intChar = m$.var("intChar");
    mVar intLen = m$.var("intLen");
    mVar intState = m$.var("intState");
    mVar loop = m$.var("loop");
    mVar lstInvalidChars = m$.var("lstInvalidChars");
    mVar lstNumbers = m$.var("lstNumbers");
    m$.newVar(blnError,intChar,intLen,intState,loop,lstInvalidChars,lstNumbers);
    //<< new strMaskChar,strResult,strRule
    mVar strMaskChar = m$.var("strMaskChar");
    mVar strResult = m$.var("strResult");
    mVar strRule = m$.var("strRule");
    m$.newVar(strMaskChar,strResult,strRule);
    //<< 
    //<< set plstError       = ""
    plstError.set("");
    //<< set lstNumbers      = $listbuild("0","1","2","3","4","5","6","7","8","9")
    lstNumbers.set(m$.Fnc.$listbuild("0","1","2","3","4","5","6","7","8","9"));
    //<< set lstInvalidChars = $listbuild("'")
    lstInvalidChars.set(m$.Fnc.$listbuild("'"));
    //<< 
    //<< set strResult = ""
    strResult.set("");
    //<< set strRule   = "ANE"
    strRule.set("ANE");
    //<< set blnError  = $$$NO
    blnError.set(include.COMSYS.$$$NO(m$));
    //<< set intState  = 1
    intState.set(1);
    //<< set intLen    = $length(pstrMask)
    intLen.set(m$.Fnc.$length(pstrMask.get()));
    //<< for intChar=1:1:intLen {
    for (intChar.set(1);(mOp.LessOrEqual(intChar.get(),intLen.get()));intChar.set(mOp.Add(intChar.get(),1))) {
      //<< set strMaskChar = $extract(pstrMask,intChar)
      strMaskChar.set(m$.Fnc.$extract(pstrMask.get(),intChar.get()));
      //<< if ($listfind(lstInvalidChars,strMaskChar)) {     // invalid char
      if (mOp.Logical((m$.Fnc.$listfind(lstInvalidChars.get(),strMaskChar.get())))) {
        //<< set blnError = $$$YES
        blnError.set(include.COMSYS.$$$YES(m$));
        //<< quit
        break;
      }
      //<< }
      //<< 
      //<< if (intState = 1) {
      if ((mOp.Equal(intState.get(),1))) {
        //<< if ($listfind(lstNumbers,strMaskChar)) {
        if (mOp.Logical((m$.Fnc.$listfind(lstNumbers.get(),strMaskChar.get())))) {
          //<< set intState = 2
          intState.set(2);
        }
        //<< } else {
        else {
          //<< set blnError = $$$YES
          blnError.set(include.COMSYS.$$$YES(m$));
        }
      }
      //<< }
      //<< 
      //<< } elseif (intState = 2) {
      else if ((mOp.Equal(intState.get(),2))) {
        //<< if ($listfind(lstNumbers,strMaskChar)) {
        if (mOp.Logical((m$.Fnc.$listfind(lstNumbers.get(),strMaskChar.get())))) {
        }
        //<< } else {
        else {
          //<< if ($find(strRule,strMaskChar) > 0) {
          if ((mOp.Greater(m$.Fnc.$find(strRule.get(),strMaskChar.get()),0))) {
            //<< set intState = 1
            intState.set(1);
          }
          //<< } else {
          else {
            //<< if (strMaskChar = """") {
            if ((mOp.Equal(strMaskChar.get(),"\""))) {
              //<< set intState = 4
              intState.set(4);
            }
            //<< } else {
            else {
              //<< set blnError = $$$YES
              blnError.set(include.COMSYS.$$$YES(m$));
            }
          }
        }
      }
      //<< }
      //<< }
      //<< }
      //<< } elseif (intState = 3) {
      else if ((mOp.Equal(intState.get(),3))) {
        //<< if (strMaskChar = """") set intState = 1
        if ((mOp.Equal(strMaskChar.get(),"\""))) {
          intState.set(1);
        }
      }
      //<< 
      //<< } elseif (intState = 4) {
      else if ((mOp.Equal(intState.get(),4))) {
        //<< set intState = 3
        intState.set(3);
      }
      //<< }
      //<< quit:(blnError)
      if (mOp.Logical((blnError.get()))) {
        break;
      }
    }
    //<< }
    //<< if (blnError) {
    if (mOp.Logical((blnError.get()))) {
      //<< set plstError= $listbuild(pstrMask,strMaskChar,intChar)
      plstError.set(m$.Fnc.$listbuild(pstrMask.get(),strMaskChar.get(),intChar.get()));
    }
    //<< }
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< ;SR17701 VerifyMask(pstrMask1,pstrMask2)
  //<< VerifyMask(pstrMask1)       ;SR17701
  public Object VerifyMask(Object ... _p) {
    mVar pstrMask1 = m$.newVarRef("pstrMask1",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Check masks and builds alert message
    //<< ;
    //<< ; Called By: OnBeforeSave^WWW122, OnBeforeSave^WWW122D2
    //<< ;
    //<< ; Returns: OK if valid masks
    //<< ;          <string> if error, string points the invalid char
    //<< ;
    //<< ; History:
    //<< ; 15-Apr-2011   shobby  SR17701: Only one mask to check now.
    //<< ; 04-Jan-2008   heber   SRBR014794: Changed input parameters
    //<< ; 28-Aug-2007   Karine  SR15592:Individual check created for WWW122 and WWW122D
    //<< ; 27-Jul-2007   HeberB  SRBR014502:Created
    //<< ;-------------------------------------------------------------------------------
    //<< ;SR17701 new lstError1,lstError2,lstMask,strStatus
    //<< new lstError1,lstMask,strStatus ;SR17701
    mVar lstError1 = m$.var("lstError1");
    mVar lstMask = m$.var("lstMask");
    mVar strStatus = m$.var("strStatus");
    m$.newVar(lstError1,lstMask,strStatus);
    //<< 
    //<< set lstError1 = ""
    lstError1.set("");
    //<< ;SR17701 set lstError2 = ""
    //<< set strStatus = $$$OK
    strStatus.set(include.COMSYS.$$$OK(m$));
    //<< 
    //<< if ($get(pstrMask1) '= "") do CheckMask(pstrMask1,.lstError1)
    if ((mOp.NotEqual(m$.Fnc.$get(pstrMask1),""))) {
      m$.Cmd.Do("CheckMask",pstrMask1.get(),lstError1);
    }
    //<< ;SR17701 if ($get(pstrMask2) '= "") do CheckMask(pstrMask2,.lstError2)
    //<< 
    //<< ;SR17701 if (lstError1 '="") && (lstError2 '= "") {
    //<< ;SR17701    set strStatus = $listbuild("WWW00073",$listget(lstError1,1),$listget(lstError1,2),$listget(lstError1,3),
    //<< ;SR17701                                          $listget(lstError2,1),$listget(lstError2,2),$listget(lstError2,3))
    //<< ;SR17701 ;  "Mask '%1' has an inadequate character '%2' at position '%3' and mask '%4' has an inadequate character '%5' at position '%6'"
    //<< 
    //<< ;SR17701 } elseif (lstError1 '= "") {
    //<< if (lstError1 '= "") {                  ;SR17701
    if ((mOp.NotEqual(lstError1.get(),""))) {
      //<< set strStatus = $listbuild("WWW00072",$listget(lstError1,1),$listget(lstError1,2),$listget(lstError1,3))
      strStatus.set(m$.Fnc.$listbuild("WWW00072",m$.Fnc.$listget(lstError1.get(),1),m$.Fnc.$listget(lstError1.get(),2),m$.Fnc.$listget(lstError1.get(),3)));
    }
    //<< ;   "Mask '%1' has an inadequate character '%2' at position '%3'"
    //<< 
    //<< ;SR17701 } elseif (lstError2 '= "") {
    //<< ;SR17701    set strStatus = $listbuild("WWW00072",$listget(lstError2,1),$listget(lstError2,2),$listget(lstError2,3))
    //<< }
    //<< quit strStatus
    return strStatus.get();
  }

  //<< 
  //<< 
  //<< OnBeforeField ; *** EXECUTE ***
  public void OnBeforeField() {
    //<< ;-------------------------------------------------------------------------------
    //<< ; Subroutine of common code from above.
    //<< ;
    //<< ;   $$$WWW121ExecuteOnFormStartBeforeD()    ;WWW121
    //<< ;   $$$WWW122ExecuteBeforeDataField()       ;WWW122
    //<< ;   $$$WWW122DExecuteBeforeDataField()      ;WWW122D
    //<< ;   $$$WWW121DExecuteBeforeDataField()      ;WWW121D
    //<< ;                                                - all piece 92 - Common macro used (WWW121)
    //<< ;
    //<< ; Called By:    Start^WWWFORM7
    //<< ;       Caption Before Answer / Caption After Answer / Caption Over Answer / Caption Below Answer / No Caption
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 07-Sep-2010   shobby  SR17524: Included code sent by Guilherme
    //<< ; 30-Aug-2010   GRF     SR17524:
    //<< ; 16-Nov-2009   shobby  SR16952: Put call to INHALT in which had been forgotten.
    //<< ; 26-Oct-2009   shobby  SR16952: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new objWWW121D
    mVar objWWW121D = m$.var("objWWW121D");
    m$.newVar(objWWW121D);
    //<< 
    //<< if $$$WWW121ExecuteOnFormStartBeforeD(YSATZ)'="" {
    if (mOp.NotEqual(include.WWWConst.$$$WWW121ExecuteOnFormStartBeforeD(m$,m$.var("YSATZ")),"")) {
      //<< xecute $$$WWW121ExecuteOnFormStartBeforeD(YSATZ)
      m$.Cmd.Xecute(include.WWWConst.$$$WWW121ExecuteOnFormStartBeforeD(m$,m$.var("YSATZ")));
    }
    //<< }
    //<< if ($$EXIST^%R("Y"_YFORM_YART_YLFN_"onBefore.OBJ",$get(YUCI))) {
    if (mOp.Logical((m$.fnc$("$R.EXIST",mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("Y",m$.var("YFORM").get()),m$.var("YART").get()),m$.var("YLFN").get()),"onBefore.OBJ"),m$.Fnc.$get(m$.var("YUCI")))))) {
      //<< xecute "DO ^Y"_YFORM_YART_YLFN_"onBefore"
      m$.Cmd.Xecute(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("DO ^Y",m$.var("YFORM").get()),m$.var("YART").get()),m$.var("YLFN").get()),"onBefore"));
    }
    //<< }
    //<< 
    //<< ; SR17524 - restore validation
    //<< if (($$$WWW121ExecuteOnFormStartBeforeD(YSATZ)'="") ||
    //<< ($$EXIST^%R("Y"_YFORM_YART_YLFN_"onBefore.OBJ",$get(YUCI)))) {
    if (mOp.Logical(((mOp.NotEqual(include.WWWConst.$$$WWW121ExecuteOnFormStartBeforeD(m$,m$.var("YSATZ")),"")) || mOp.Logical((m$.fnc$("$R.EXIST",mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("Y",m$.var("YFORM").get()),m$.var("YART").get()),m$.var("YLFN").get()),"onBefore.OBJ"),m$.Fnc.$get(m$.var("YUCI")))))))) {
      //<< if YART'="" if YINHALT'="" do INHALT
      if (mOp.NotEqual(m$.var("YART").get(),"")) {
        if (mOp.NotEqual(m$.var("YINHALT").get(),"")) {
          m$.Cmd.Do("INHALT");
        }
      }
    }
    //<< }
    //<< 
    //<< if YART="P" {   ; Not specifically OnBeforeField but included here as follows each call to this tag
    if (mOp.Equal(m$.var("YART").get(),"P")) {
      //<< set objWWW121D = $get(^WWW121D(0,YFORM,YLFN,YM,1))
      objWWW121D.set(m$.Fnc.$get(m$.var("^WWW121D",0,m$.var("YFORM").get(),m$.var("YLFN").get(),m$.var("YM").get(),1)));
      //<< if $$^WWWACCESS($$$WWW121DAllowedEntitlements(objWWW121D),$$$WWW121DAllowedModules(objWWW121D),YBED)'=$$$YES set YHID=2
      if (mOp.NotEqual(m$.fnc$("WWWACCESS.main",include.WWWConst.$$$WWW121DAllowedEntitlements(m$,objWWW121D),include.WWWConst.$$$WWW121DAllowedModules(m$,objWWW121D),m$.var("YBED").get()),include.COMSYS.$$$YES(m$))) {
        mVar YHID = m$.var("YHID");
        YHID.set(2);
      }
    }
    //<< }
    //<< quit
    return;
  }

//<< 
}
