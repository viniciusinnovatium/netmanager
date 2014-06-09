//*****************************************************************************
//** TASC - ALPHALINC - MAC WWWField
//** Innovatium Systems - Code Converter - v1.30
//** 2014-06-09 14:57:43
//*****************************************************************************

import mLibrary.*;

//<< 
//<< #include WWWConst
import include.WWWConst;
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

//<< WWWField
public class WWWField extends mClass {

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
    _WWWField();
  }

  public void _WWWField() {
  }

  //<< #;define LogR(%1,%2)    $$$JournalOff s ^zzLogR($g(YBED,"UNK"),$i(^zzLogR))= %1_"^WWWField("_%2_") : "_$zh $$$JournalOn
  //<< #;define LogRx(%1)      $$$JournalOff s ^zzLogR($g(YBED,"UNK"),$i(^zzLogR))=%1 $$$JournalOn
  //<< #;define LogRm(%1)      $$$JournalOff m ^zzLogR($g(YBED,"UNK"),$i(^zzLogR))=%1 $$$JournalOn
  //<< 
  //<< GetDetails(YFORM,YART,YLFN,&pidClass,&pintFormFld,&pobjForm,&pobjFormFld,&pobjClsFld,&pobjCustFld,&pintType,&pobjClsCustFld)
  public Object GetDetails(Object ... _p) {
    mVar YFORM = m$.newVarRef("YFORM",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar YART = m$.newVarRef("YART",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar YLFN = m$.newVarRef("YLFN",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    mVar pidClass = m$.newVarRef("pidClass",(((_p!=null)&&(_p.length>=4))?_p[3]:null));
    mVar pintFormFld = m$.newVarRef("pintFormFld",(((_p!=null)&&(_p.length>=5))?_p[4]:null));
    mVar pobjForm = m$.newVarRef("pobjForm",(((_p!=null)&&(_p.length>=6))?_p[5]:null));
    mVar pobjFormFld = m$.newVarRef("pobjFormFld",(((_p!=null)&&(_p.length>=7))?_p[6]:null));
    mVar pobjClsFld = m$.newVarRef("pobjClsFld",(((_p!=null)&&(_p.length>=8))?_p[7]:null));
    mVar pobjCustFld = m$.newVarRef("pobjCustFld",(((_p!=null)&&(_p.length>=9))?_p[8]:null));
    mVar pintType = m$.newVarRef("pintType",(((_p!=null)&&(_p.length>=10))?_p[9]:null));
    mVar pobjClsCustFld = m$.newVarRef("pobjClsCustFld",(((_p!=null)&&(_p.length>=11))?_p[10]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Get the form record and other form details
    //<< ;
    //<< ; Params:   YFORM       - WWW120 key
    //<< ;           YART        - "P" / "D"
    //<< ;           YLFN        - WWW002/WWW003 id
    //<< ;           pidClass    - WWW001 id
    //<< ;           pintFormFld - WWW121/WWW122 id
    //<< ;           pobjForm    - WWW120 record
    //<< ;           pobjFormFld - WWW121/WWW122 record
    //<< ;           pobjClsFld  - WWW002/WWW003 record
    //<< ;           pobjCustFld - WWW121D/WWW122D record
    //<< ;           pintType    - field data type
    //<< ;           pobjClsCustFld - WWW002D record
    //<< ;
    //<< ; Returns:  field record
    //<< ;
    //<< ; History:
    //<< ; 18-Sep-2007   shobby  SRBR014619: Use standard interface to WWW122 to
    //<< ;                           consider customisation as well.
    //<< ; 10-Apr-2007   PO      SR15442: Included class customisation field
    //<< ; 23-Jan-2007   JW      SR15384: Encapsulated
    //<< ;-------------------------------------------------------------------------------
    //<< 
    //<< $$$LogR("GetDetails",$get(YFORM)_"<"_$get(YART)_"<"_$get(YLFN))
    $$$LogR(m$,"GetDetails",mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(m$.Fnc.$get(YFORM),"<"),m$.Fnc.$get(YART)),"<"),m$.Fnc.$get(YLFN)));
    //<< 
    //<< set pintFormFld = YLFN   ; Form field # defaults to class field #
    pintFormFld.set(YLFN.get());
    //<< 
    //<< set pobjForm = $get(^WWW120(0,YFORM,1))
    pobjForm.set(m$.Fnc.$get(m$.var("^WWW120",0,YFORM.get(),1)));
    //<< set pidClass = $$$WWW120ClassUsedInForm(pobjForm)
    pidClass.set(include.WWWConst.$$$WWW120ClassUsedInForm(m$,pobjForm));
    //<< 
    //<< set pobjFormFld = ""
    pobjFormFld.set("");
    //<< set pobjClsFld  = ""
    pobjClsFld.set("");
    //<< set pobjCustFld = ""
    pobjCustFld.set("");
    //<< 
    //<< if YART="P" {
    if (mOp.Equal(YART.get(),"P")) {
      //<< set pobjFormFld = $get(^WWW121(0,YFORM,pintFormFld,1))   ;DATEN AUS PRIMÄRSCHLÜSSEL ;out of
      pobjFormFld.set(m$.Fnc.$get(m$.var("^WWW121",0,YFORM.get(),pintFormFld.get(),1)));
      //<< set pobjCustFld = $get(^WWW121D(0,YFORM,pintFormFld,YM,1))
      pobjCustFld.set(m$.Fnc.$get(m$.var("^WWW121D",0,YFORM.get(),pintFormFld.get(),m$.var("YM").get(),1)));
      //<< 
      //<< if pidClass'="" {       // Does it make sense to have a key but no class ? Manual form wouldn't have key?
      if (mOp.NotEqual(pidClass.get(),"")) {
        //<< set pobjClsFld     = $get(^WWW002(0,pidClass,YLFN,1))
        pobjClsFld.set(m$.Fnc.$get(m$.var("^WWW002",0,pidClass.get(),YLFN.get(),1)));
        //<< set pobjClsCustFld = $get(^WWW002D(0,pidClass,YLFN,YM,1))
        pobjClsCustFld.set(m$.Fnc.$get(m$.var("^WWW002D",0,pidClass.get(),YLFN.get(),m$.var("YM").get(),1)));
      }
    }
    //<< }
    //<< 
    //<< } else {
    else {
      //<< if YART="D" {
      if (mOp.Equal(YART.get(),"D")) {
        //<< set pintFormFld = $order(^WWW122s(0,4,YLFN,YFORM,""))   ; Actual Form Fld # is first form field to link to class field
        pintFormFld.set(m$.Fnc.$order(m$.var("^WWW122s",0,4,YLFN.get(),YFORM.get(),"")));
        //<< if (pidClass'="") {
        if ((mOp.NotEqual(pidClass.get(),""))) {
          //<< set pobjClsFld = $get(^WWW003(0,pidClass,YLFN,1))
          pobjClsFld.set(m$.Fnc.$get(m$.var("^WWW003",0,pidClass.get(),YLFN.get(),1)));
        }
      }
      //<< }
      //<< }
      //<< 
      //<< if pintFormFld'="" {
      if (mOp.NotEqual(pintFormFld.get(),"")) {
        //<< set pobjFormFld = $$Get^WWW122(YFORM,pintFormFld)
        pobjFormFld.set(m$.fnc$("WWW122.Get",YFORM.get(),pintFormFld.get()));
        //<< set pobjCustFld = $get(^WWW122D(0,YFORM,pintFormFld,YM,1))
        pobjCustFld.set(m$.Fnc.$get(m$.var("^WWW122D",0,YFORM.get(),pintFormFld.get(),m$.var("YM").get(),1)));
      }
    }
    //<< }
    //<< }
    //<< 
    //<< set pintType = $$GetInputType(YART,YLFN,pobjFormFld,pobjClsFld,pobjCustFld)
    pintType.set(m$.fnc$("GetInputType",YART.get(),YLFN.get(),pobjFormFld.get(),pobjClsFld.get(),pobjCustFld.get()));
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< GetInputType(YART,YLFN,pobjFormFld,pobjClsFld,pobjCustFld)
  public Object GetInputType(Object ... _p) {
    mVar YART = m$.newVarRef("YART",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar YLFN = m$.newVarRef("YLFN",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pobjFormFld = m$.newVarRef("pobjFormFld",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    mVar pobjClsFld = m$.newVarRef("pobjClsFld",(((_p!=null)&&(_p.length>=4))?_p[3]:null));
    mVar pobjCustFld = m$.newVarRef("pobjCustFld",(((_p!=null)&&(_p.length>=5))?_p[4]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Get the field's input type
    //<< ;
    //<< ; Params:
    //<< ;
    //<< ; Returns:  enum
    //<< ;
    //<< ; History:
    //<< ; 30-Jan-2007   JW      SR15384: Encapsulated
    //<< ;-------------------------------------------------------------------------------
    //<< new intType
    mVar intType = m$.var("intType");
    m$.newVar(intType);
    //<< 
    //<< if YART="P" {
    if (mOp.Equal(YART.get(),"P")) {
      //<< set intType = $$$WWW002InputType(pobjClsFld)
      intType.set(include.WWWConst.$$$WWW002InputType(m$,pobjClsFld));
      //<< if (intType="") && (YLFN'=1) set intType = 1                 ; Date field for time forms?
      if ((mOp.Equal(intType.get(),"")) && (mOp.NotEqual(YLFN.get(),1))) {
        intType.set(1);
      }
    }
    //<< 
    //<< } else {
    else {
      //<< 
      //<< set intType = $$$WWW122DInputType(pobjCustFld)
      intType.set(include.WWWConst.$$$WWW122DInputType(m$,pobjCustFld));
      //<< if intType="" {
      if (mOp.Equal(intType.get(),"")) {
        //<< if $$$WWW122DataInputType(pobjFormFld)=3 {               ; Checkbox
        if (mOp.Equal(include.WWWConst.$$$WWW122DataInputType(m$,pobjFormFld),3)) {
          //<< set intType = 2
          intType.set(2);
        }
        //<< 
        //<< } else {
        else {
          //<< set intType = $$$WWW122InputType(pobjFormFld)
          intType.set(include.WWWConst.$$$WWW122InputType(m$,pobjFormFld));
          //<< 
          //<< if (intType="") && (YART="D") {
          if ((mOp.Equal(intType.get(),"")) && (mOp.Equal(YART.get(),"D"))) {
            //<< set intType = $$$WWW003InputType(pobjClsFld)     ; Get from class
            intType.set(include.WWWConst.$$$WWW003InputType(m$,pobjClsFld));
          }
        }
      }
    }
    //<< }
    //<< }
    //<< }
    //<< }
    //<< 
    //<< if intType="" set intType = 6                                    ; Default to text type.
    if (mOp.Equal(intType.get(),"")) {
      intType.set(6);
    }
    //<< quit intType
    return intType.get();
  }

  //<< 
  //<< 
  //<< GetID(pidForm,pidFormFld,&pstrType,&pintField)
  public Object GetID(Object ... _p) {
    mVar pidForm = m$.newVarRef("pidForm",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pidFormFld = m$.newVarRef("pidFormFld",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pstrType = m$.newVarRef("pstrType",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    mVar pintField = m$.newVarRef("pintField",(((_p!=null)&&(_p.length>=4))?_p[3]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Get the HTML id for a given @net form / field. Also return field details.
    //<< ; (Not for primary keys)
    //<< ;
    //<< ; Params:
    //<< ;
    //<< ; Returns:  string id
    //<< ;
    //<< ; History:
    //<< ; 27-Mar-2007   JW      SR15384: Encapsulated
    //<< ;-------------------------------------------------------------------------------
    //<< new idClsFld
    mVar idClsFld = m$.var("idClsFld");
    m$.newVar(idClsFld);
    //<< 
    //<< set idClsFld = $$$WWW122SequenceNumber($get(^WWW122(0,pidForm,pidFormFld,1)))
    idClsFld.set(include.WWWConst.$$$WWW122SequenceNumber(m$,m$.Fnc.$get(m$.var("^WWW122",0,pidForm.get(),pidFormFld.get(),1))));
    //<< 
    //<< if idClsFld="" {
    if (mOp.Equal(idClsFld.get(),"")) {
      //<< set pstrType = "M"
      pstrType.set("M");
      //<< set pintField = pidFormFld
      pintField.set(pidFormFld.get());
    }
    //<< } else {
    else {
      //<< set pstrType = "D"
      pstrType.set("D");
      //<< set pintField = idClsFld
      pintField.set(idClsFld.get());
    }
    //<< }
    //<< quit "Y"_pidForm_pstrType_pintField
    return mOp.Concat(mOp.Concat(mOp.Concat("Y",pidForm.get()),pstrType.get()),pintField.get());
  }

  //<< 
  //<< 
  //<< SplitID(strField,pidForm,&YART,&YLFN)
  public Object SplitID(Object ... _p) {
    mVar strField = m$.newVarRef("strField",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pidForm = m$.newVarRef("pidForm",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar YART = m$.newVarRef("YART",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    mVar YLFN = m$.newVarRef("YLFN",(((_p!=null)&&(_p.length>=4))?_p[3]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; split a field's HTML id into parts
    //<< ;
    //<< ; Params:
    //<< ;   strField                                        e.g. YINAbcD16
    //<< ;   pidForm     Form Name                           e.g. INAbc
    //<< ;
    //<< ; Returns:
    //<< ;   YART    (ByRef)     Field Type (P,D,M,???)      e.g. D
    //<< ;   YLFN    (ByRef)     Field Number                e.g. 16
    //<< ;
    //<< ; History:
    //<< ; 26-Mar-2007   JW      SR15384: Encapsulated
    //<< ;-------------------------------------------------------------------------------
    //<< set YART = $$$StripNum($piece(strField,pidForm,2))  // YFORM_YART_YLFN
    YART.set(include.COMSYSString.$$$StripNum(m$,m$.Fnc.$piece(strField.get(),pidForm.get(),2)));
    //<< set YLFN = $piece(strField,pidForm_YART,2)          // Field number
    YLFN.set(m$.Fnc.$piece(strField.get(),mOp.Concat(pidForm.get(),YART.get()),2));
    //<< 
    //<< set:YART="" YART="D"
    if (mOp.Equal(YART.get(),"")) {
      YART.set("D");
    }
    //<< 
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< GetLast(&YINHALT)
  public Object GetLast(Object ... _p) {
    mVar YINHALT = m$.newVarRef("YINHALT",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Recall a previous input for the current field.
    //<< ;
    //<< ; Params:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 07-Jan-2011   GRF     SR17579: Use explicit tag for WWWTR calls
    //<< ; 05-Jan-2010   GRF     SR15525: Call to $$Convert^WWWTR rather than $$^WWWTR
    //<< ; 21-Feb-2007   JW      SR15384: Encapsulated
    //<< ;-------------------------------------------------------------------------------
    //<< new YA,YKEY,YLAST,YII,NUM,strStored
    mVar YA = m$.var("YA");
    mVar YKEY = m$.var("YKEY");
    mVar YLAST = m$.var("YLAST");
    mVar YII = m$.var("YII");
    mVar NUM = m$.var("NUM");
    mVar strStored = m$.var("strStored");
    m$.newVar(YA,YKEY,YLAST,YII,NUM,strStored);
    //<< 
    //<< $$$LogR("GetLast",$get(YINHALT)_"<")
    $$$LogR(m$,"GetLast",mOp.Concat(m$.Fnc.$get(YINHALT),"<"));
    //<< 
    //<< set NUM = $extract(YINHALT,3,5)+1
    NUM.set(mOp.Add(m$.Fnc.$extract(YINHALT.get(),3,5),1));
    //<< set YINHALT = ""
    YINHALT.set("");
    //<< set strStored = ""
    strStored.set("");
    //<< 
    //<< if YDATEI'="" {
    if (mOp.NotEqual(m$.var("YDATEI").get(),"")) {
      //<< set YKEY=$get(^WWWDATEN(YM,+$horolog,YUSER,YFORM,"P",1))
      YKEY.set(m$.Fnc.$get(m$.var("^WWWDATEN",m$.var("YM").get(),mOp.Positive(m$.Fnc.$horolog()),m$.var("YUSER").get(),m$.var("YFORM").get(),"P",1)));
      //<< if YKEY'="" {
      if (mOp.NotEqual(YKEY.get(),"")) {
        //<< set YA=""
        YA.set("");
        //<< set YA(1)="^WWWLAST("""_YM_""","""_YDATEI_""","""_YKEY_""",YA)"
        YA.var(1).set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("^WWWLAST(\"",m$.var("YM").get()),"\",\""),m$.var("YDATEI").get()),"\",\""),YKEY.get()),"\",YA)"));
        //<< set YA(2)="^WWWLAST("""_YM_""","""_YDATEI_""","""_YKEY_""",YA,1)"
        YA.var(2).set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("^WWWLAST(\"",m$.var("YM").get()),"\",\""),m$.var("YDATEI").get()),"\",\""),YKEY.get()),"\",YA,1)"));
        //<< set YLAST=""
        YLAST.set("");
        //<< for YII=1:1:NUM-1 set YA=$order(@(YA(1)),-1) quit:YA=""
        for (YII.set(1);(mOp.LessOrEqual(YII.get(),mOp.Subtract(NUM.get(),1)));YII.set(mOp.Add(YII.get(),1))) {
          YA.set(m$.Fnc.$order(m$.indirectVar((YA.var(1).get())),mOp.Negative(1)));
          if (mOp.Equal(YA.get(),"")) {
            break;
          }
        }
        //<< set YA=$order(@(YA(1)),-1)
        YA.set(m$.Fnc.$order(m$.indirectVar((YA.var(1).get())),mOp.Negative(1)));
        //<< 
        //<< if YA'="" {
        if (mOp.NotEqual(YA.get(),"")) {
          //<< set strStored = $piece($get(@(YA(2))),Y,YLFN)
          strStored.set(m$.Fnc.$piece(m$.Fnc.$get(m$.indirectVar((YA.var(2).get()))),m$.var("Y").get(),m$.var("YLFN").get()));
          //<< set YINHALT = $$GetLiteral^WWWTR(YTYP,strStored)
          YINHALT.set(m$.fnc$("WWWTR.GetLiteral",m$.var("YTYP").get(),strStored.get()));
        }
      }
    }
    //<< }
    //<< }
    //<< }
    //<< quit strStored
    return strStored.get();
  }

//<< 
//<< 
}
