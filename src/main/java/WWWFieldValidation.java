//*****************************************************************************
//** TASC - ALPHALINC - MAC WWWFieldValidation
//** Innovatium Systems - Code Converter - v1.29
//** 2014-06-03 20:54:17
//*****************************************************************************

import mLibrary.*;

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

//<< WWWFieldValidation
public class WWWFieldValidation extends mClass {

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

  //<< #define LogR2(%1,%2)    ;
  public static Object $$$LogR2(mContext m$, Object ... _p) {
    mVar p$1 = m$.varRef("p$1",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar p$2 = m$.varRef("p$2",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    return null;
  }

  //<< #define LogR2x(%1)      ;
  public static Object $$$LogR2x(mContext m$, Object ... _p) {
    mVar p$1 = m$.varRef("p$1",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return null;
  }

  //<< #define LogR2m(%1)      ;
  public static Object $$$LogR2m(mContext m$, Object ... _p) {
    mVar p$1 = m$.varRef("p$1",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return null;
  }

  public void main() {
    _WWWFieldValidation();
  }

  public void _WWWFieldValidation() {
  }

  //<< #;define LogR(%1,%2)    $$$JournalOff s ^zzLogR($g(YBED,"UNK"),$i(^zzLogR))= %1_"^WWWFieldValidation("_%2_") : "_$zh $$$JournalOn
  //<< #;define LogRx(%1)      $$$JournalOff s ^zzLogR($g(YBED,"UNK"),$i(^zzLogR))=%1 $$$JournalOn
  //<< #;define LogRm(%1)      $$$JournalOff m ^zzLogR($g(YBED,"UNK"),$i(^zzLogR))=%1 $$$JournalOn
  //<< #;define LogR2(%1,%2)   $$$JournalOff s ^zzLogR($g(YBED,"UNK"),$i(^zzLogR))= %1_"^WWWFieldValidation("_%2_") : "_$zh $$$JournalOn
  //<< #;define LogR2x(%1)     $$$JournalOff s ^zzLogR($g(YBED,"UNK"),$i(^zzLogR))=%1 $$$JournalOn
  //<< #;define LogR2m(%1)     $$$JournalOff m ^zzLogR($g(YBED,"UNK"),$i(^zzLogR))=%1 $$$JournalOn
  //<< 
  //<< ValidRelation(YART,YDATEI="",YFORM,YLFN,YINHALT="",pblnOnBlur=$$$YES,&pstrReason,pid="",pobj="")
  public Object ValidRelation(Object ... _p) {
    mVar YART = m$.newVarRef("YART",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar YDATEI = m$.newVarRef("YDATEI",(((_p!=null)&&(_p.length>=2))?_p[1]:null),"");
    mVar YFORM = m$.newVarRef("YFORM",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    mVar YLFN = m$.newVarRef("YLFN",(((_p!=null)&&(_p.length>=4))?_p[3]:null));
    mVar YINHALT = m$.newVarRef("YINHALT",(((_p!=null)&&(_p.length>=5))?_p[4]:null),"");
    mVar pblnOnBlur = m$.newVarRef("pblnOnBlur",(((_p!=null)&&(_p.length>=6))?_p[5]:null),include.COMSYS.$$$YES(m$));
    mVar pstrReason = m$.newVarRef("pstrReason",(((_p!=null)&&(_p.length>=7))?_p[6]:null));
    mVar pid = m$.newVarRef("pid",(((_p!=null)&&(_p.length>=8))?_p[7]:null),"");
    mVar pobj = m$.newVarRef("pobj",(((_p!=null)&&(_p.length>=9))?_p[8]:null),"");
    //<< ;-------------------------------------------------------------------------------
    //<< ; Validate a field's relation
    //<< ;
    //<< ; WARNING: If a composite index is used for the Sort Keys, this will FAIL miserably.
    //<< ; Also @net allows you to enter 5.1 for a sort keys, obviously this doesn't exist as
    //<< ; a separate index, so this will FAIL miserably, but not due to its own issues, but
    //<< ; because @net should flag this value as an error. Only integer index keys can be allowed.
    //<< ;
    //<< ;-------------------------------------------------------------------------------
    //<< ; Operation :
    //<< ;   1.  GetDetails : build array of class fields that associate with the
    //<< ;       specified class field (i.e. if field is UoM then list all Qty fields
    //<< ;       based on that unit)
    //<< ;       e.g. INRECSummary : F8  (Qty Ordered) is associated with D9 (Ordered Unit)
    //<< ;   2.  NeedToCheck - tests display and COMView properties
    //<< ;   3.  Only continue when there is data to check
    //<< ;   4.  DataAccess - Perform ClassHook checks
    //<< ;   5.  Call $$AssociatedValidation^YFORM if it exists - returns *TRUE* if data
    //<< ;       is acceptable (e.g. if unit specified is defined under item's INARTPACK.)
    //<< ;   6.  Recursively call ValidRelation for the fields in arrAssociatedTo
    //<< ;       NOTE : doesn't pass pstrReason (error) back from recursive calls and
    //<< ;       doesn't stop further processing if error found at sublevel; doesn't make
    //<< ;       recursive call as a function
    //<< ;   7. FieldFormat - changes background colour if validation error or based on
    //<< ;       CheckRules^WWWFORMD
    //<< ;-------------------------------------------------------------------------------
    //<< ; Params:   YART    - data type
    //<< ;           YDATEI  - class
    //<< ;           YFORM   - form
    //<< ;           YLFN    - data field (class # for "D", form # for "M", will be same for "P")
    //<< ;           YINHALT - data (internal!)
    //<< ;           pblnOnBlur - whether a form field needs to be updated (on blur)
    //<< ;
    //<< ; By Ref:   pstrReason - invalid reason
    //<< ;
    //<< ; Returns: nil
    //<< ;
    //<< ; History:
    //<< ; 04-Sep-2012   shobby  SR18102: Don't continue testing if an invalid thing is found.
    //<< ; 27-Jan-2011   GRF     SR17579: pass back errors from recursive calls & quit
    //<< ; 05-Jan-2011   GRF     SR17579: GetFormField macro; doco
    //<< ; 07-May-2009   GRF     SR16523: Better reporting of Relation Key issues;
    //<< ;                           clean up old corrections.
    //<< ; 25-Oct-2007   GRF     SR15563: DataAccess already dequotes strGlobalKey;
    //<< ;                           strRelKeys should be byRef
    //<< ; 18-Sep-2007   shobby  SRBR014619: Use standard interface to WWW122 to consider
    //<< ;                           customisation as well.
    //<< ; 26-Apr-2007   RPW     SRBR014310: If we have an associated field, check that I
    //<< ;                           am valid for it.
    //<< ; 26-Mar-2007   JW      SR15384: Changed name from GetValidationDetails. Don't
    //<< ;                           update %TXT
    //<< ; 14-Aug-2006   JW      SR14604: Don't test actual node. Could be "parent"
    //<< ; 05-Jul-2006   RPW     SR12522: Break out the information gathering for the
    //<< ;                           details of the relation
    //<< ; 15-Jun-2006   JW      SR12775: Check cache
    //<< ; 01-Sep-2005   JW      SR13360: Use %TXT, not alert.
    //<< ; 01-Sep-2005   JW      SR13387: No commas or double quotes allowed
    //<< ; 15-Aug-2005   JW      SR12290: Call back for data access
    //<< ; 14-Jul-2005   JW      SR12615: Created
    //<< ;-------------------------------------------------------------------------------
    //<< set pstrReason = ""
    pstrReason.set("");
    //<< 
    //<< $$$LogR("ValidRelation",$get(YART)_"<"_$get(YFORM)_"<"_$get(YLFN)_"<"_YDATEI_"<"_pblnOnBlur_"<")
    $$$LogR(m$,"ValidRelation",mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(m$.Fnc.$get(YART),"<"),m$.Fnc.$get(YFORM)),"<"),m$.Fnc.$get(YLFN)),"<"),YDATEI.get()),"<"),pblnOnBlur.get()),"<"));
    //<< 
    //<< quit:($get(YFORM)="")||($get(YLFN)="")||($get(YART)="") $$$YES
    if ((mOp.Equal(m$.Fnc.$get(YFORM),"")) || (mOp.Equal(m$.Fnc.$get(YLFN),"")) || (mOp.Equal(m$.Fnc.$get(YART),""))) {
      return include.COMSYS.$$$YES(m$);
    }
    //<< quit:'$$$DEVMODE&&($get(^CacheTempCheckRelation(YUCI,YART,YFORM,YLFN))=$$$NO) $$$YES
    if (mOp.Not(include.COMSYS.$$$DEVMODE(m$)) && (mOp.Equal(m$.Fnc.$get(m$.var("^CacheTempCheckRelation",m$.var("YUCI").get(),YART.get(),YFORM.get(),YLFN.get())),include.COMSYS.$$$NO(m$)))) {
      return include.COMSYS.$$$YES(m$);
    }
    //<< 
    //<< new arrAssociatedTo,blnHasData,blnTest,blnValid
    mVar arrAssociatedTo = m$.var("arrAssociatedTo");
    mVar blnHasData = m$.var("blnHasData");
    mVar blnTest = m$.var("blnTest");
    mVar blnValid = m$.var("blnValid");
    m$.newVar(arrAssociatedTo,blnHasData,blnTest,blnValid);
    //<< new idAssociated,idDisplay,idField,idRelation,idxKey,idxKeys,objClassFld,objFormFld
    mVar idAssociated = m$.var("idAssociated");
    mVar idDisplay = m$.var("idDisplay");
    mVar idField = m$.var("idField");
    mVar idRelation = m$.var("idRelation");
    mVar idxKey = m$.var("idxKey");
    mVar idxKeys = m$.var("idxKeys");
    mVar objClassFld = m$.var("objClassFld");
    mVar objFormFld = m$.var("objFormFld");
    m$.newVar(idAssociated,idDisplay,idField,idRelation,idxKey,idxKeys,objClassFld,objFormFld);
    //<< new strCallBack,strColour,strExecute,strGlobal,strGlobalIdx,strGlobalKey
    mVar strCallBack = m$.var("strCallBack");
    mVar strColour = m$.var("strColour");
    mVar strExecute = m$.var("strExecute");
    mVar strGlobal = m$.var("strGlobal");
    mVar strGlobalIdx = m$.var("strGlobalIdx");
    mVar strGlobalKey = m$.var("strGlobalKey");
    m$.newVar(strCallBack,strColour,strExecute,strGlobal,strGlobalIdx,strGlobalKey);
    //<< new strRelKeys,strSortKeys,strText,strValue,strYFELD,thisYM
    mVar strRelKeys = m$.var("strRelKeys");
    mVar strSortKeys = m$.var("strSortKeys");
    mVar strText = m$.var("strText");
    mVar strValue = m$.var("strValue");
    mVar strYFELD = m$.var("strYFELD");
    mVar thisYM = m$.var("thisYM");
    m$.newVar(strRelKeys,strSortKeys,strText,strValue,strYFELD,thisYM);
    //<< 
    //<< set blnValid = $$$YES
    blnValid.set(include.COMSYS.$$$YES(m$));
    //<< 
    //<< 
    //<< ; For "M"         get form def only.
    //<< ; For "D" and "P" get form def. If no relation, get class def.
    //<< ; NOTE : "C" represents Calculated field in WWW003Calc
    //<< 
    //<< ;                       "D" : $$Get^WWW122(YFORM,+$order(^WWW122s(0,4,YLFN,YFORM,""))),  ; SR17579
    //<< 
    //<< set objFormFld = $case(YART,
    //<< "D" : $$Get^WWW122(YFORM,+$$$GetFormField(YFORM,YLFN)),
    //<< "P" : $get(^WWW121(0,YFORM,YLFN,1)),
    //<< "M" : $$Get^WWW122(YFORM,YLFN),
    //<< : "")
    objFormFld.set(m$.Fnc.$case(YART.get(),"D",m$.fnc$("WWW122.Get",YFORM.get(),mOp.Positive(include.COMSYSWWW.$$$GetFormField(m$,YFORM,YLFN))),"P",m$.Fnc.$get(m$.var("^WWW121",0,YFORM.get(),YLFN.get(),1)),"M",m$.fnc$("WWW122.Get",YFORM.get(),YLFN.get()),""));
    //<< 
    //<< $$$LogRx("VR:1:"_objFormFld)
    $$$LogRx(m$,mOp.Concat("VR:1:",objFormFld.get()));
    //<< if objFormFld'="" {
    if (mOp.NotEqual(objFormFld.get(),"")) {
      //<< ; Check if we have an association or things are associated with us.
      //<< do GetDetails(YART,YFORM,YDATEI,YLFN,objFormFld,.blnTest,.idRelation,.idDisplay,.strRelKeys,.strSortKeys,.idAssociated,.arrAssociatedTo)
      m$.Cmd.Do("GetDetails",YART.get(),YFORM.get(),YDATEI.get(),YLFN.get(),objFormFld.get(),blnTest,idRelation,idDisplay,strRelKeys,strSortKeys,idAssociated,arrAssociatedTo);
      //<< 
      //<< $$$LogRx("VR:2:"_$get(blnTest)_"<"_YINHALT_"<"_$get(idRelation)_"<"_$get(idDisplay)_"<"_$get(idAssociated))
      $$$LogRx(m$,mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("VR:2:",m$.Fnc.$get(blnTest)),"<"),YINHALT.get()),"<"),m$.Fnc.$get(idRelation)),"<"),m$.Fnc.$get(idDisplay)),"<"),m$.Fnc.$get(idAssociated)));
      //<< $$$LogRx("VR:3:"_$get(strRelKeys)_"<"_$get(strSortKeys)_"<")
      $$$LogRx(m$,mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("VR:3:",m$.Fnc.$get(strRelKeys)),"<"),m$.Fnc.$get(strSortKeys)),"<"));
      //<< $$$LogRm(arrAssociatedTo)
      $$$LogRm(m$,arrAssociatedTo);
      //<< 
      //<< if blnTest && $$NeedToCheck(idRelation,idDisplay,YART,YDATEI,YLFN,idAssociated,.arrAssociatedTo) {
      if (mOp.Logical(blnTest.get()) && mOp.Logical(m$.fnc$("NeedToCheck",idRelation.get(),idDisplay.get(),YART.get(),YDATEI.get(),YLFN.get(),idAssociated.get(),arrAssociatedTo))) {
        //<< if YINHALT'="" {                        ; FIXME : test first to skip analysis for blank fields?  OK if from OnBlur
        if (mOp.NotEqual(YINHALT.get(),"")) {
          //<< if $find(YINHALT,$$$DBLQUOTE) || $find(YINHALT,$$$COMMA) {
          if (mOp.Logical(m$.Fnc.$find(YINHALT.get(),include.COMSYSString.$$$DBLQUOTE(m$))) || mOp.Logical(m$.Fnc.$find(YINHALT.get(),include.COMSYSString.$$$COMMA(m$)))) {
            //<< set blnValid = $$$NO    ; No commas, double quotes allowed in key
            blnValid.set(include.COMSYS.$$$NO(m$));
          }
          //<< 
          //<< } else {
          else {
            //<< set strGlobalKey = $$$DBLQUOTE_YINHALT_$$$DBLQUOTE
            strGlobalKey.set(mOp.Concat(mOp.Concat(include.COMSYSString.$$$DBLQUOTE(m$),YINHALT.get()),include.COMSYSString.$$$DBLQUOTE(m$)));
            //<< 
            //<< if strRelKeys'="" {
            if (mOp.NotEqual(strRelKeys.get(),"")) {
              //<< ;set blnValid = $$DefineKeys(YFORM,.strRelKeys,"","")
              //<< set blnValid = $$DefineKeys(YFORM,.strRelKeys,pid,pobj) ; CORE-86
              blnValid.set(m$.fnc$("DefineKeys",YFORM.get(),strRelKeys,pid.get(),pobj.get()));
              //<< set strGlobalKey = strRelKeys_","_strGlobalKey
              strGlobalKey.set(mOp.Concat(mOp.Concat(strRelKeys.get(),","),strGlobalKey.get()));
              //<< if 'blnValid set pstrReason = $$$Text("WWW00115")
              if (mOp.Not(blnValid.get())) {
                pstrReason.set(include.COMSYS.$$$Text(m$,"WWW00115"));
              }
            }
            //<< }        ; "Error when validating Relationship. Please contact our support team!"
            //<< 
            //<< 
            //<< if blnValid {                // Index record must not be blank
            if (mOp.Logical(blnValid.get())) {
              //<< if idRelation'="" {
              if (mOp.NotEqual(idRelation.get(),"")) {
                //<< set thisYM = $$$DBLQUOTE_$$$WWWYM(idRelation)_$$$DBLQUOTE_","   ; FIXME : simply 0, now - hardcode below
                thisYM.set(mOp.Concat(mOp.Concat(mOp.Concat(include.COMSYSString.$$$DBLQUOTE(m$),include.COMSYSWWW.$$$WWWYM(m$,idRelation)),include.COMSYSString.$$$DBLQUOTE(m$)),","));
                //<< set strGlobal = "^"_idRelation_"("_thisYM_strGlobalKey_")"
                strGlobal.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("^",idRelation.get()),"("),thisYM.get()),strGlobalKey.get()),")"));
                //<< $$$LogRx("VR:4:"_strGlobal_"<")
                $$$LogRx(m$,mOp.Concat(mOp.Concat("VR:4:",strGlobal.get()),"<"));
                //<< 
                //<< if strSortKeys'="" { // Index - sort keys
                if (mOp.NotEqual(strSortKeys.get(),"")) {
                  //<< if $find(strSortKeys,",") {
                  if (mOp.Logical(m$.Fnc.$find(strSortKeys.get(),","))) {
                    //<< set strGlobal = "^"_idRelation_"s("_thisYM_strSortKeys_","_strGlobalKey_")"
                    strGlobal.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("^",idRelation.get()),"s("),thisYM.get()),strSortKeys.get()),","),strGlobalKey.get()),")"));
                  }
                  //<< 
                  //<< } else {         // Index record must not be blank
                  else {
                    //<< set strGlobalIdx = "^"_idRelation_"s("_thisYM_strSortKeys_","" "","_strGlobalKey_")"
                    strGlobalIdx.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("^",idRelation.get()),"s("),thisYM.get()),strSortKeys.get()),",\" \","),strGlobalKey.get()),")"));
                    //<< if $data(@strGlobalIdx)#2=1 {
                    if (mOp.Equal(mOp.Modulus(m$.Fnc.$data(m$.indirectVar(strGlobalIdx.get())),2),1)) {
                      //<< set blnValid = $$$NO
                      blnValid.set(include.COMSYS.$$$NO(m$));
                    }
                  }
                }
                //<< }
                //<< }
                //<< }
                //<< 
                //<< if '$data(@strGlobal) set blnValid = $$$NO
                if(!idRelation.get().equals("MEDPatient")){//TODO REVISAR CONDIÇÃO PARA NÃO PRECISAR VALIDAR O ID DO PACIENTE NA TABELA RELACIONAL                	
	                if (mOp.Not(m$.Fnc.$data(m$.indirectVar(strGlobal.get())))) {
	                  blnValid.set(include.COMSYS.$$$NO(m$));
	                }
                }
                //<< 
                //<< if blnValid {
                if (mOp.Logical(blnValid.get())) {
                  //<< set strCallBack = $$$WWW001DataAccess($get(^WWW001(0,idRelation,1)))
                  strCallBack.set(include.WWWConst.$$$WWW001DataAccess(m$,m$.Fnc.$get(m$.var("^WWW001",0,idRelation.get(),1))));
                  //<< ; *** EXECUTE # ***
                  //<< if strCallBack'="" {
                  if (mOp.NotEqual(strCallBack.get(),"")) {
                    //<< set blnValid = $$DataAccess(strCallBack,strGlobalKey,YFORM,YART,YLFN,.pstrReason,idRelation) ;SR17034
                    blnValid.set(m$.fnc$("DataAccess",strCallBack.get(),strGlobalKey.get(),YFORM.get(),YART.get(),YLFN.get(),pstrReason,idRelation.get()));
                    //<< $$$LogRx("VR:5:"_blnValid_"<"_strCallBack)
                    $$$LogRx(m$,mOp.Concat(mOp.Concat(mOp.Concat("VR:5:",blnValid.get()),"<"),strCallBack.get()));
                  }
                }
              }
              //<< }
              //<< }
              //<< }
              //<< if blnValid {  ;SR18102
              if (mOp.Logical(blnValid.get())) {
                //<< 
                //<< set blnHasData = ''$data(arrAssociatedTo)
                blnHasData.set(mOp.Not(mOp.Not(m$.Fnc.$data(arrAssociatedTo))));
                //<< if (idAssociated'="") || blnHasData {
                if ((mOp.NotEqual(idAssociated.get(),"")) || mOp.Logical(blnHasData.get())) {
                  //<< ; CORE-86 vvvv
                  //<< ;set strYFELD = $$GetFormData^COMUtilForm(YFORM)         ; WWWDATEN record for current form data
                  //<< set strYFELD = pobj
                  strYFELD.set(pobj.get());
                  //<< if strYFELD="" {
                  if (mOp.Equal(strYFELD.get(),"")) {
                    //<< set strYFELD = $$GetFormData^COMUtilForm(YFORM)         ; WWWDATEN record for current form data
                    strYFELD.set(m$.fnc$("COMUtilForm.GetFormData",YFORM.get()));
                  }
                  //<< }
                  //<< if strYFELD="" {
                  if (mOp.Equal(strYFELD.get(),"")) {
                    //<< set strYFELD = $$$GRIDGetYFELD()
                    strYFELD.set(include.COMGridEdit31Interface.$$$GRIDGetYFELD(m$));
                  }
                  //<< }
                  //<< ; CORE-86 ^^^^
                  //<< if strYFELD="" {
                  if (mOp.Equal(strYFELD.get(),"")) {
                    //<< set strYFELD = $$$GRIDGetYFELD()
                    strYFELD.set(include.COMGridEdit31Interface.$$$GRIDGetYFELD(m$));
                  }
                  //<< }
                  //<< ; *** EXECUTE # ***
                  //<< if idAssociated'="" {  ; FIXME : Doesn't return error message if not valid - results in default "is invalid" message
                  if (mOp.NotEqual(idAssociated.get(),"")) {
                    //<< set strExecute = "set blnValid=$$AssociatedValidation^"_YFORM_"(strYFELD,$piece(strYFELD,Y,YLFN),idAssociated)"
                    strExecute.set(mOp.Concat(mOp.Concat("set blnValid=$$AssociatedValidation^",YFORM.get()),"(strYFELD,$piece(strYFELD,Y,YLFN),idAssociated)"));
                    //<< if '$$$ExecuteCode(strExecute) {
                    if (mOp.Not(include.COMSYS.$$$ExecuteCode(m$,strExecute))) {
                      //<< set blnValid = $$$YES
                      blnValid.set(include.COMSYS.$$$YES(m$));
                    }
                  }
                  //<< }
                  //<< }
                  //<< $$$LogRx("VR:6:"_blnValid)
                  $$$LogRx(m$,mOp.Concat("VR:6:",blnValid.get()));
                  //<< if blnHasData && blnValid {  ;SR18102
                  if (mOp.Logical(blnHasData.get()) && mOp.Logical(blnValid.get())) {
                    //<< set idField = ""
                    idField.set("");
                    //<< for {
                    for (;true;) {
                      //<< set idField = $order(arrAssociatedTo(idField))  ; based on class #
                      idField.set(m$.Fnc.$order(arrAssociatedTo.var(idField.get())));
                      //<< quit:idField=""
                      if (mOp.Equal(idField.get(),"")) {
                        break;
                      }
                      //<< 
                      //<< set strValue = $piece(strYFELD,Y,idField)
                      strValue.set(m$.Fnc.$piece(strYFELD.get(),m$.var("Y").get(),idField.get()));
                      //<< ;   do ValidRelation(YART,YDATEI,YFORM,idField,strValue,pblnOnBlur,pstrReason) ; SR17579
                      //<< ;set blnValid = $$ValidRelation(YART,YDATEI,YFORM,idField,strValue,pblnOnBlur,.pstrReason)
                      //<< set blnValid = $$ValidRelation(YART,YDATEI,YFORM,idField,strValue,pblnOnBlur,.pstrReason,pid,pobj) ; CORE-86
                      blnValid.set(m$.fnc$("ValidRelation",YART.get(),YDATEI.get(),YFORM.get(),idField.get(),strValue.get(),pblnOnBlur.get(),pstrReason,pid.get(),pobj.get()));
                      //<< quit:'blnValid
                      if (mOp.Not(blnValid.get())) {
                        break;
                      }
                      //<< $$$LogRx("VR:7:"_idField_"<"_blnValid_"<"_$get(pstrReason))
                      $$$LogRx(m$,mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("VR:7:",idField.get()),"<"),blnValid.get()),"<"),m$.Fnc.$get(pstrReason)));
                    }
                  }
                }
              }
            }
          }
        }
        //<< }
        //<< }
        //<< }
        //<< }
        //<< }
        //<< }
        //<< }  ; * YINHALT *
        //<< 
        //<< if pblnOnBlur do FieldFormat(blnValid,"Y"_YFORM_YART_YLFN)
        if (mOp.Logical(pblnOnBlur.get())) {
          m$.Cmd.Do("FieldFormat",blnValid.get(),mOp.Concat(mOp.Concat(mOp.Concat("Y",YFORM.get()),YART.get()),YLFN.get()));
        }
      }
      //<< 
      //<< } else {
      else {
        //<< set ^CacheTempCheckRelation(YUCI,YART,YFORM,YLFN) = $$$NO
        m$.var("^CacheTempCheckRelation",m$.var("YUCI").get(),YART.get(),YFORM.get(),YLFN.get()).set(include.COMSYS.$$$NO(m$));
      }
    }
    //<< }
    //<< }
    //<< quit blnValid
    return blnValid.get();
  }

  //<< 
  //<< 
  //<< GetDetails(pstrFieldType="D",pidForm,pidClass,pidField,pobjFormFld="",
  //<< &pblnTest,&pidRelation,&pidDisplay,&pstrRelKeys,&pstrSortKeys,&pidAssocFld,&parrAssociatedTo)
  public Object GetDetails(Object ... _p) {
    mVar pstrFieldType = m$.newVarRef("pstrFieldType",(((_p!=null)&&(_p.length>=1))?_p[0]:null),"D");
    mVar pidForm = m$.newVarRef("pidForm",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pidClass = m$.newVarRef("pidClass",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    mVar pidField = m$.newVarRef("pidField",(((_p!=null)&&(_p.length>=4))?_p[3]:null));
    mVar pobjFormFld = m$.newVarRef("pobjFormFld",(((_p!=null)&&(_p.length>=5))?_p[4]:null),"");
    mVar pblnTest = m$.newVarRef("pblnTest",(((_p!=null)&&(_p.length>=6))?_p[5]:null));
    mVar pidRelation = m$.newVarRef("pidRelation",(((_p!=null)&&(_p.length>=7))?_p[6]:null));
    mVar pidDisplay = m$.newVarRef("pidDisplay",(((_p!=null)&&(_p.length>=8))?_p[7]:null));
    mVar pstrRelKeys = m$.newVarRef("pstrRelKeys",(((_p!=null)&&(_p.length>=9))?_p[8]:null));
    mVar pstrSortKeys = m$.newVarRef("pstrSortKeys",(((_p!=null)&&(_p.length>=10))?_p[9]:null));
    mVar pidAssocFld = m$.newVarRef("pidAssocFld",(((_p!=null)&&(_p.length>=11))?_p[10]:null));
    mVar parrAssociatedTo = m$.newVarRef("parrAssociatedTo",(((_p!=null)&&(_p.length>=12))?_p[11]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Get the validation information to determine whether a validation should happen
    //<< ;
    //<< ; Params:
    //<< ;   pstrFieldType       The field type, defaults to D for Data Field other values,
    //<< ;                           P for Primary Key or M for manual field.
    //<< ;                       NOTE : "C" represents Calculated field in WWW003Calc
    //<< ;   pidForm             The id of the Form
    //<< ;   pidClass            The id of the class
    //<< ;   pidField            The id of the *CLASS* field
    //<< ;   pobjFormFld         The form field data (or "")
    //<< ;   pblnTest            (ByRef) Should we test for validation
    //<< ;   pidRelation         (ByRef) The name of the validation class
    //<< ;   pidDisplay          (ByRef) The display options - ^WWW100(0,"RELATION")
    //<< ;                               0 = "Display All Relations"
    //<< ;                               1 = "Display Relations After Input"
    //<< ;                               2 = "Don´t Display Relations (just Test)"
    //<< ;                               3 = "Only Marked Relationfields"
    //<< ;   pstrRelKeys         (ByRef) Relation Primary Keys
    //<< ;   pstrSortKey         (ByRef) Display if Sort Key Equals
    //<< ;   pidAssocFld         (ByRef)
    //<< ;   parrAssociatedTo    (ByRef) Class Fields with association links to this form field.
    //<< ;                       e.g. If WWW122 entries for F10 (D25 Qty Ordered) and F12
    //<< ;                       (D26 Qty Received) are defined to have a relationship
    //<< ;                       with F14 (D27 Unit of Measure) then this subroutine will
    //<< ;                       return the array,
    //<< ;                           parrAssociatedTo(25) = ""
    //<< ;                           parrAssociatedTo(26) = ""
    //<< ;                       when checking pidField 27.
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 03-Nov-2011   shobby  SR17725: Type 18 (FAT Search)
    //<< ; 14-Apr-2011   shobby  SR17719: Don't put manual fields into arrAssociatedTo
    //<< ;                           (crashes because SequenceNumber is a blank string)
    //<< ; 05-Jan-2011   GRF     SR17579: GetFormField macro; doco
    //<< ; 18-Sep-2007   shobby  SRBR014619: Use standard interface to WWW122 to consider
    //<< ;                           customisation as well.
    //<< ; 24-May-2007   RPW     SR15513: Fixed class v form field information
    //<< ; 26-Apr-2007   RPW     SRBR014310: If we have an associated field, check that
    //<< ;                           I am valid for it.
    //<< ; 26-Mar-2007   JW      SR15384: Changed name
    //<< ; 22-Aug-2006   JW      SR14929: Check data type
    //<< ; 05-Jul-2006   RPW     SR12522: Created
    //<< ;-------------------------------------------------------------------------------
    //<< quit:($get(pidForm)="")||($get(pidField)="")||(pstrFieldType="")
    if ((mOp.Equal(m$.Fnc.$get(pidForm),"")) || (mOp.Equal(m$.Fnc.$get(pidField),"")) || (mOp.Equal(pstrFieldType.get(),""))) {
      return null;
    }
    //<< 
    //<< $$$LogR2("GetDetails",pstrFieldType_"<"_pidForm_"<"_pidField_"<")
    $$$LogR2(m$,"GetDetails",mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(pstrFieldType.get(),"<"),pidForm.get()),"<"),pidField.get()),"<"));
    //<< 
    //<< new idAssociatedField,idField,objClassFld,objWWW122
    mVar idAssociatedField = m$.var("idAssociatedField");
    mVar idField = m$.var("idField");
    mVar objClassFld = m$.var("objClassFld");
    mVar objWWW122 = m$.var("objWWW122");
    m$.newVar(idAssociatedField,idField,objClassFld,objWWW122);
    //<< 
    //<< set pidAssocFld = ""
    pidAssocFld.set("");
    //<< 
    //<< if pobjFormFld="" {
    if (mOp.Equal(pobjFormFld.get(),"")) {
      //<< ;   set pobjFormFld = $$Get^WWW122(pidForm,+$order(^WWW122s(0,4,pidField,pidForm,"")))   ; SR17579
      //<< set pobjFormFld = $$Get^WWW122(pidForm,+$$$GetFormField(pidForm,pidField))
      pobjFormFld.set(m$.fnc$("WWW122.Get",pidForm.get(),mOp.Positive(include.COMSYSWWW.$$$GetFormField(m$,pidForm,pidField))));
    }
    //<< }
    //<< 
    //<< if pobjFormFld'="" {
    if (mOp.NotEqual(pobjFormFld.get(),"")) {
      //<< set pblnTest    = $$$NO
      pblnTest.set(include.COMSYS.$$$NO(m$));
      //<< set pidRelation = $$$WWW122RelationClass(pobjFormFld)   // Get form field relation
      pidRelation.set(include.WWWConst.$$$WWW122RelationClass(m$,pobjFormFld));
      //<< 
      //<< if pidRelation'="" {
      if (mOp.NotEqual(pidRelation.get(),"")) {
        //<< set pblnTest = '$$$WWW122NoRelationValidation(pobjFormFld)
        pblnTest.set(mOp.Not(include.WWWConst.$$$WWW122NoRelationValidation(m$,pobjFormFld)));
        //<< 
        //<< if pblnTest {
        if (mOp.Logical(pblnTest.get())) {
          //<< set pidDisplay   = $$$WWW122RelationDisplayOptions(pobjFormFld)
          pidDisplay.set(include.WWWConst.$$$WWW122RelationDisplayOptions(m$,pobjFormFld));
          //<< set pstrRelKeys  = $$$WWW122RelationalPrimaryKey(pobjFormFld)
          pstrRelKeys.set(include.WWWConst.$$$WWW122RelationalPrimaryKey(m$,pobjFormFld));
          //<< set pstrSortKeys = $$$WWW122DisplayIfSortCodes(pobjFormFld)
          pstrSortKeys.set(include.WWWConst.$$$WWW122DisplayIfSortCodes(m$,pobjFormFld));
        }
      }
      //<< }
      //<< 
      //<< } elseif pidClass'="" { // Check class definition
      else if (mOp.NotEqual(pidClass.get(),"")) {
        //<< set objClassFld = $case(pstrFieldType,
        //<< "D" : $get(^WWW003(0,pidClass,pidField,1)),
        //<< "P" : $get(^WWW002(0,pidClass,pidField,1)),
        //<< : "")
        objClassFld.set(m$.Fnc.$case(pstrFieldType.get(),"D",m$.Fnc.$get(m$.var("^WWW003",0,pidClass.get(),pidField.get(),1)),"P",m$.Fnc.$get(m$.var("^WWW002",0,pidClass.get(),pidField.get(),1)),""));
        //<< 
        //<< set pidRelation = $$$WWW003RelationDatabase(objClassFld)    // Get class field relation
        pidRelation.set(include.WWWConst.$$$WWW003RelationDatabase(m$,objClassFld));
        //<< if pidRelation'="" {
        if (mOp.NotEqual(pidRelation.get(),"")) {
          //<< set pblnTest = '$$$WWW003NoRelationValidation(objClassFld)
          pblnTest.set(mOp.Not(include.WWWConst.$$$WWW003NoRelationValidation(m$,objClassFld)));
          //<< 
          //<< if pblnTest {
          if (mOp.Logical(pblnTest.get())) {
            //<< if $$$WWW003InputType(objClassFld)=3 {          // Don't test Memo fields
            if (mOp.Equal(include.WWWConst.$$$WWW003InputType(m$,objClassFld),3)) {
              //<< set pblnTest = $$$NO
              pblnTest.set(include.COMSYS.$$$NO(m$));
            }
            //<< } else {
            else {
              //<< set pidDisplay   = $$$WWW003RelationDisplayOptions(objClassFld)
              pidDisplay.set(include.WWWConst.$$$WWW003RelationDisplayOptions(m$,objClassFld));
              //<< set pstrRelKeys  = $$$WWW003RelationalPrimaryKeys(objClassFld)
              pstrRelKeys.set(include.WWWConst.$$$WWW003RelationalPrimaryKeys(m$,objClassFld));
              //<< set pstrSortKeys = $$$WWW003DisplayIfSortKeyEqual(objClassFld)
              pstrSortKeys.set(include.WWWConst.$$$WWW003DisplayIfSortKeyEqual(m$,objClassFld));
            }
          }
        }
      }
      //<< }
      //<< }
      //<< }
      //<< }
      //<< 
      //<< //  only test Auto/Text/Select for now.
      //<< if $case(+$$$WWW122DataInputType(pobjFormFld),0:$$$NO,1:$$$NO,4:$$$NO,18:$$$NO,:$$$YES) { ;SR17725
      if (mOp.Logical(m$.Fnc.$case(mOp.Positive(include.WWWConst.$$$WWW122DataInputType(m$,pobjFormFld)),0,include.COMSYS.$$$NO(m$),1,include.COMSYS.$$$NO(m$),4,include.COMSYS.$$$NO(m$),18,include.COMSYS.$$$NO(m$),include.COMSYS.$$$YES(m$)))) {
        //<< set pblnTest = $$$NO
        pblnTest.set(include.COMSYS.$$$NO(m$));
      }
      //<< }
      //<< 
      //<< set idAssociatedField = $$$WWW122AssociatedwithField(pobjFormFld)
      idAssociatedField.set(include.WWWConst.$$$WWW122AssociatedwithField(m$,pobjFormFld));
      //<< if idAssociatedField'="" {
      if (mOp.NotEqual(idAssociatedField.get(),"")) {
        //<< set pblnTest     = $$$YES
        pblnTest.set(include.COMSYS.$$$YES(m$));
        //<< set pidAssocFld  = idAssociatedField
        pidAssocFld.set(idAssociatedField.get());
        //<< set pidDisplay   = $get(pidDisplay)
        pidDisplay.set(m$.Fnc.$get(pidDisplay));
        //<< set pstrRelKeys  = $get(pstrRelKeys)
        pstrRelKeys.set(m$.Fnc.$get(pstrRelKeys));
        //<< set pstrSortKeys = $get(pstrSortKeys)
        pstrSortKeys.set(m$.Fnc.$get(pstrSortKeys));
        //<< set pidRelation  = $get(pidRelation)
        pidRelation.set(m$.Fnc.$get(pidRelation));
      }
      //<< }
      //<< 
      //<< if $data(^WWW122s(0,7,pidField,pidForm)) {
      if (mOp.Logical(m$.Fnc.$data(m$.var("^WWW122s",0,7,pidField.get(),pidForm.get())))) {
        //<< set pidDisplay   = $get(pidDisplay)
        pidDisplay.set(m$.Fnc.$get(pidDisplay));
        //<< set pstrRelKeys  = $get(pstrRelKeys)
        pstrRelKeys.set(m$.Fnc.$get(pstrRelKeys));
        //<< set pstrSortKeys = $get(pstrSortKeys)
        pstrSortKeys.set(m$.Fnc.$get(pstrSortKeys));
        //<< set pidRelation  = $get(pidRelation)
        pidRelation.set(m$.Fnc.$get(pidRelation));
        //<< 
        //<< set idField = ""
        idField.set("");
        //<< for {
        for (;true;) {
          //<< set idField = $order(^WWW122s(0,7,pidField,pidForm,idField))
          idField.set(m$.Fnc.$order(m$.var("^WWW122s",0,7,pidField.get(),pidForm.get(),idField.get())));
          //<< quit:idField=""
          if (mOp.Equal(idField.get(),"")) {
            break;
          }
          //<< 
          //<< set objWWW122 = $$Get^WWW122(pidForm,idField)       ;SR17719
          objWWW122.set(m$.fnc$("WWW122.Get",pidForm.get(),idField.get()));
          //<< if $$$WWW122SequenceNumber(objWWW122)'="" set parrAssociatedTo($$$WWW122SequenceNumber(objWWW122))="" ;SR17719
          if (mOp.NotEqual(include.WWWConst.$$$WWW122SequenceNumber(m$,objWWW122),"")) {
            parrAssociatedTo.var(include.WWWConst.$$$WWW122SequenceNumber(m$,objWWW122)).set("");
          }
        }
        //<< }
        //<< set pblnTest=''$data(parrAssociatedTo)
        pblnTest.set(mOp.Not(mOp.Not(m$.Fnc.$data(parrAssociatedTo))));
      }
    }
    //<< }
    //<< }
    //<< $$$LogR2x("parrAssociatedTo...")
    $$$LogR2x(m$,"parrAssociatedTo...");
    //<< $$$LogR2m(parrAssociatedTo)
    $$$LogR2m(m$,parrAssociatedTo);
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< NeedToCheck(pidRelation,pidDisplay,YART,YDATEI,YLFN,pidAssociated,&parrAssociatedTo) private
  public Object NeedToCheck(Object ... _p) {
    mVar pidRelation = m$.newVarRef("pidRelation",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pidDisplay = m$.newVarRef("pidDisplay",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar YART = m$.newVarRef("YART",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    mVar YDATEI = m$.newVarRef("YDATEI",(((_p!=null)&&(_p.length>=4))?_p[3]:null));
    mVar YLFN = m$.newVarRef("YLFN",(((_p!=null)&&(_p.length>=5))?_p[4]:null));
    mVar pidAssociated = m$.newVarRef("pidAssociated",(((_p!=null)&&(_p.length>=6))?_p[5]:null));
    mVar parrAssociatedTo = m$.newVarRef("parrAssociatedTo",(((_p!=null)&&(_p.length>=7))?_p[6]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Whether we need to check the relation
    //<< ;
    //<< ; Test the relation if
    //<< ;   relational display is
    //<< ;       1 = "Display Relations After Input"
    //<< ;       2 = "Don´t Display Relations (just Test)"
    //<< ;   OR  select can change to combo
    //<< ; unless
    //<< ;   exceptions below
    //<< ;
    //<< ; Params:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 19-Oct-2010   shobby  SR17565: Call to common ComboToSearch routine.
    //<< ; 22-Aug-2006   JW      SR?????: Added $get
    //<< ; 14-Aug-2006   JW      SR14604: Also check ComboToSearch
    //<< ; 19-Jul-2005   JW      SR12615: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new blnCheck
    mVar blnCheck = m$.var("blnCheck");
    m$.newVar(blnCheck);
    //<< 
    //<< set blnCheck = ((pidAssociated'="") || $data(parrAssociatedTo))
    blnCheck.set(((mOp.NotEqual(pidAssociated.get(),"")) || mOp.Logical(m$.Fnc.$data(parrAssociatedTo))));
    //<< 
    //<< if 'blnCheck {
    if (mOp.Not(blnCheck.get())) {
      //<< ;SR17565 set blnCheck = $case(pidDisplay,1:$$$YES,2:$$$YES,:$$$NO) || $$$WWW001ComboToSearch($get(^WWW001(0,pidRelation,1)))
      //<< set blnCheck = $case(pidDisplay,1:$$$YES,2:$$$YES,:$$$NO) || $$ComboToSearch^WWWFOR71("",pidRelation)  ;SR17565
      blnCheck.set(mOp.Logical(m$.Fnc.$case(pidDisplay.get(),1,include.COMSYS.$$$YES(m$),2,include.COMSYS.$$$YES(m$),include.COMSYS.$$$NO(m$))) || mOp.Logical(m$.fnc$("WWWFOR71.ComboToSearch","",pidRelation.get())));
      //<< 
      //<< if blnCheck {          // EXCEPTIONS //
      if (mOp.Logical(blnCheck.get())) {
        //<< ; If it's the last primary key, and has its own relation
        //<< if (YART="P") && (pidRelation=YDATEI) && ($order(^WWW002(0,YDATEI,""),-1)=YLFN) {
        if ((mOp.Equal(YART.get(),"P")) && (mOp.Equal(pidRelation.get(),YDATEI.get())) && (mOp.Equal(m$.Fnc.$order(m$.var("^WWW002",0,YDATEI.get(),""),mOp.Negative(1)),YLFN.get()))) {
          //<< set blnCheck = $$$NO
          blnCheck.set(include.COMSYS.$$$NO(m$));
        }
        //<< 
        //<< ; The following classes are not checked
        //<< } elseif $case(pidRelation,"WWW013":$$$YES,"INPLZ":$$$YES,:$$$NO) {
        else if (mOp.Logical(m$.Fnc.$case(pidRelation.get(),"WWW013",include.COMSYS.$$$YES(m$),"INPLZ",include.COMSYS.$$$YES(m$),include.COMSYS.$$$NO(m$)))) {
          //<< set blnCheck = $$$NO
          blnCheck.set(include.COMSYS.$$$NO(m$));
        }
      }
    }
    //<< }
    //<< }
    //<< }
    //<< quit blnCheck
    return blnCheck.get();
  }

  //<< 
  //<< 
  //<< DefineKeys(YFORM,&pstrRelKeys="",pid="",pobj="")
  public Object DefineKeys(Object ... _p) {
    mVar YFORM = m$.newVarRef("YFORM",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pstrRelKeys = m$.newVarRef("pstrRelKeys",(((_p!=null)&&(_p.length>=2))?_p[1]:null),"");
    mVar pid = m$.newVarRef("pid",(((_p!=null)&&(_p.length>=3))?_p[2]:null),"");
    mVar pobj = m$.newVarRef("pobj",(((_p!=null)&&(_p.length>=4))?_p[3]:null),"");
    //<< ;-------------------------------------------------------------------------------
    //<< ; Define variables if not already defined
    //<< ;
    //<< ; Note: This function does the same checking on the string as @net does.
    //<< ;       See Parser below for better checking
    //<< ;
    //<< ; Params:   YFORM - related form
    //<< ;           pid - current key (optional - may take from form)
    //<< ;           pobj - current object (optional - may take from form)
    //<< ;
    //<< ; ByRefs:   pstrRelKeys     string we want to define
    //<< ;
    //<< ; Returns:  blnValid
    //<< ;
    //<< ; History:
    //<< ; 25-Oct-2007   GRF     SR15563: replace i with loop; preserve key values and
    //<< ;                           return in pstrRelKeys
    //<< ; 23-Nov-2006   PO      SR15217: Handle global references in relational primary
    //<< ;                           keys and if volatile variables set contents back in
    //<< ;                           to relational primary keys
    //<< ; 14-Aug-2006   JW      SR14604: Check stored variables
    //<< ;  9-Feb-2006   JW      Removed private. Added pid and pobj params. Just in case
    //<< ;                           we're not on form
    //<< ; 10-Nov-2005   JW      SR13812: Move defined check after the field check,
    //<< ;                       as value may need to be updated.
    //<< ; 15-Jul-2005   JW      SR12615: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new blnValid,dte,idClsFld,idKey,idStep,idType,idVarFld,idxKey,loop
    mVar blnValid = m$.var("blnValid");
    mVar dte = m$.var("dte");
    mVar idClsFld = m$.var("idClsFld");
    mVar idKey = m$.var("idKey");
    mVar idStep = m$.var("idStep");
    mVar idType = m$.var("idType");
    mVar idVarFld = m$.var("idVarFld");
    mVar idxKey = m$.var("idxKey");
    mVar loop = m$.var("loop");
    m$.newVar(blnValid,dte,idClsFld,idKey,idStep,idType,idVarFld,idxKey,loop);
    //<< 
    //<< set dte      = +$horolog
    dte.set(mOp.Positive(m$.Fnc.$horolog()));
    //<< set blnValid = $$$YES
    blnValid.set(include.COMSYS.$$$YES(m$));
    //<< 
    //<< if YFORM=$$$GRIDName {
    if (mOp.Equal(YFORM.get(),include.COMGridEdit31Interface.$$$GRIDName(m$))) {
      //<< if pid=""  set pid  = $$$GRIDGetCurrentYKEY     ; Get from grid if blank
      if (mOp.Equal(pid.get(),"")) {
        pid.set(include.COMGridEdit31Interface.$$$GRIDGetCurrentYKEY(m$));
      }
      //<< if pobj="" set pobj = $$$GRIDGetYFELD(pid)
      if (mOp.Equal(pobj.get(),"")) {
        pobj.set(include.COMGridEdit31Interface.$$$GRIDGetYFELD(m$,pid));
      }
    }
    //<< 
    //<< } else {
    else {
      //<< if pid=""  set pid  = $get(^WWWDATEN(0,dte,YUSER,YFORM,"P",1))     // Get from form if blank
      if (mOp.Equal(pid.get(),"")) {
        pid.set(m$.Fnc.$get(m$.var("^WWWDATEN",0,dte.get(),m$.var("YUSER").get(),YFORM.get(),"P",1)));
      }
      //<< if pobj="" set pobj = $get(^WWWDATEN(0,dte,YUSER,YFORM,"D",1))
      if (mOp.Equal(pobj.get(),"")) {
        pobj.set(m$.Fnc.$get(m$.var("^WWWDATEN",0,dte.get(),m$.var("YUSER").get(),YFORM.get(),"D",1)));
      }
    }
    //<< }
    //<< 
    //<< if ($extract(pstrRelKeys) = "^") && ($data(@pstrRelKeys)#2=1) { ; Should the $data check be included?
    if ((mOp.Equal(m$.Fnc.$extract(pstrRelKeys.get()),"^")) && (mOp.Equal(mOp.Modulus(m$.Fnc.$data(m$.indirectVar(pstrRelKeys.get())),2),1))) {
    }
    //<< ; Do nothing - already defined
    //<< 
    //<< } else {
    else {
      //<< for loop=1:1:$length(pstrRelKeys,",") {
      for (loop.set(1);(mOp.LessOrEqual(loop.get(),m$.Fnc.$length(pstrRelKeys.get(),",")));loop.set(mOp.Add(loop.get(),1))) {
        //<< set idKey = $piece(pstrRelKeys,",",loop)
        idKey.set(m$.Fnc.$piece(pstrRelKeys.get(),",",loop.get()));
        //<< 
        //<< continue:$extract(idKey)=$$$DBLQUOTE    // Is a string
        if (mOp.Equal(m$.Fnc.$extract(idKey.get()),include.COMSYSString.$$$DBLQUOTE(m$))) {
          continue;
        }
        //<< continue:idKey=+idKey                   // Is a number
        if (mOp.Equal(idKey.get(),mOp.Positive(idKey.get()))) {
          continue;
        }
        //<< 
        //<< set idxKey = $$$Index(idKey)                        // Check primary keys
        idxKey.set(include.MEDConst.$$$Index(m$,idKey));
        //<< if $data(^WWW121s(0,2,idxKey,YFORM)) {
        if (mOp.Logical(m$.Fnc.$data(m$.var("^WWW121s",0,2,idxKey.get(),YFORM.get())))) {
          //<< set idVarFld = $order(^WWW121s(0,2,idxKey,YFORM,""))
          idVarFld.set(m$.Fnc.$order(m$.var("^WWW121s",0,2,idxKey.get(),YFORM.get(),"")));
          //<< set @idKey = $piece(pid,",",idVarFld)
          m$.indirectVar(idKey.get()).set(m$.Fnc.$piece(pid.get(),",",idVarFld.get()));
        }
        //<< 
        //<< } elseif $data(^WWW122s(0,2,idxKey,YFORM)) {        // Check data fields
        else if (mOp.Logical(m$.Fnc.$data(m$.var("^WWW122s",0,2,idxKey.get(),YFORM.get())))) {
          //<< set idVarFld = +$order(^WWW122s(0,2,idxKey,YFORM,""))
          idVarFld.set(mOp.Positive(m$.Fnc.$order(m$.var("^WWW122s",0,2,idxKey.get(),YFORM.get(),""))));
          //<< set idClsFld = $$$WWW122SequenceNumber($get(^WWW122(0,YFORM,idVarFld,1)))
          idClsFld.set(include.WWWConst.$$$WWW122SequenceNumber(m$,m$.Fnc.$get(m$.var("^WWW122",0,YFORM.get(),idVarFld.get(),1))));
          //<< if idClsFld="" {
          if (mOp.Equal(idClsFld.get(),"")) {
            //<< set @idKey = $piece($get(^WWWDATEN(0,dte,YUSER,YFORM,"M",1)),Y,idVarFld)    // Is this necessary?
            m$.indirectVar(idKey.get()).set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWWDATEN",0,dte.get(),m$.var("YUSER").get(),YFORM.get(),"M",1)),m$.var("Y").get(),idVarFld.get()));
          }
          //<< } else {
          else {
            //<< set @idKey = $piece(pobj,Y,idClsFld)
            m$.indirectVar(idKey.get()).set(m$.Fnc.$piece(pobj.get(),m$.var("Y").get(),idClsFld.get()));
          }
        }
        //<< }
        //<< }
        //<< 
        //<< if $get(@idKey)="" {            ; Check stored variables from last step
        if (mOp.Equal(m$.Fnc.$get(m$.indirectVar(idKey.get())),"")) {
          //<< set idStep = $order(^WWWZWS(0,dte,YUSER," "),-1)    // Last number
          idStep.set(m$.Fnc.$order(m$.var("^WWWZWS",0,dte.get(),m$.var("YUSER").get()," "),mOp.Negative(1)));
          //<< if idStep'="" {
          if (mOp.NotEqual(idStep.get(),"")) {
            //<< set @idKey = $get(^WWWZWS(0,dte,YUSER,idStep,idKey,1))
            m$.indirectVar(idKey.get()).set(m$.Fnc.$get(m$.var("^WWWZWS",0,dte.get(),m$.var("YUSER").get(),idStep.get(),idKey.get(),1)));
          }
          //<< }
          //<< 
          //<< if $get(@idKey)="" {
          if (mOp.Equal(m$.Fnc.$get(m$.indirectVar(idKey.get())),"")) {
            //<< set blnValid = $$$NO    ; Quit if relation key is not defined or is ""
            blnValid.set(include.COMSYS.$$$NO(m$));
            //<< quit
            break;
          }
        }
        //<< }
        //<< }
        //<< set $piece(pstrRelKeys,",",loop) = $$$DBLQUOTE_@idKey_$$$DBLQUOTE
        m$.pieceVar(pstrRelKeys,",",loop.get()).set(mOp.Concat(mOp.Concat(include.COMSYSString.$$$DBLQUOTE(m$),m$.indirectVar(idKey.get()).get()),include.COMSYSString.$$$DBLQUOTE(m$)));
      }
    }
    //<< }
    //<< }
    //<< quit blnValid
    return blnValid.get();
  }

  //<< 
  //<< 
  //<< FieldFormat(pblnValid=$$$YES,pidField)
  public Object FieldFormat(Object ... _p) {
    mVar pblnValid = m$.newVarRef("pblnValid",(((_p!=null)&&(_p.length>=1))?_p[0]:null),include.COMSYS.$$$YES(m$));
    mVar pidField = m$.newVarRef("pidField",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Update the field format based on validity.
    //<< ;
    //<< ; Called By: ValidRelation^WWWFieldValidation, (Deprecated: OnBlur^INWEFREI & VAR version)
    //<< ;
    //<< ; Params:   pblnValid - valid or not
    //<< ;           pidField  - field number ("Y"_YFORM_YART_YLFN e.g. "YINItemGroupD3" )
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 26-Aug-2010   GRF     SR17513: variable naming
    //<< ; 24-Aug-2010   shobby  SR17513: If a Regular Field, YLFN is class field.  If a
    //<< ;                           Manual Field, YLFN is form field.
    //<< ; 03-Dec-2009   shobby  SR17070: Don't use ResetFieldFormat as the 'default'
    //<< ;                           colour may no longer be the one it was when the form
    //<< ;                           was first loaded.
    //<< ; 18-Jul-2005   JW      SR12615: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new bgColour,idFormField,strNewFieldColor,YFELD
    mVar bgColour = m$.var("bgColour");
    mVar idFormField = m$.var("idFormField");
    mVar strNewFieldColor = m$.var("strNewFieldColor");
    mVar YFELD = m$.var("YFELD");
    m$.newVar(bgColour,idFormField,strNewFieldColor,YFELD);
    //<< 
    //<< $$$LogR("FieldFormat",$get(pidField)_"<")
    $$$LogR(m$,"FieldFormat",mOp.Concat(m$.Fnc.$get(pidField),"<"));
    //<< 
    //<< quit:$get(pidField)=""
    if (mOp.Equal(m$.Fnc.$get(pidField),"")) {
      return null;
    }
    //<< 
    //<< if pblnValid {
    if (mOp.Logical(pblnValid.get())) {
      //<< set YFELD = $$GetFormData^COMUtilForm(YFORM)    ; idClassFld
      YFELD.set(m$.fnc$("COMUtilForm.GetFormData",m$.var("YFORM").get()));
      //<< set strNewFieldColor=""
      strNewFieldColor.set("");
      //<< if ($get(YLFN)'="") {
      if ((mOp.NotEqual(m$.Fnc.$get(m$.var("YLFN")),""))) {
        //<< set idFormField = $$$GetFormField(YFORM,YLFN)                                  ;SR17513
        idFormField.set(include.COMSYSWWW.$$$GetFormField(m$,m$.var("YFORM"),m$.var("YLFN")));
        //<< if idFormField="" set idFormField = YLFN                                       ;SR17513
        if (mOp.Equal(idFormField.get(),"")) {
          idFormField.set(m$.var("YLFN").get());
        }
        //<< do CheckRules^WWWFORMD(YFORM,idFormField,.YFELD,,,,,,.strNewFieldColor,,,,,,,) ;SR17513
        m$.Cmd.Do("WWWFORMD.CheckRules",m$.var("YFORM").get(),idFormField.get(),YFELD,null,null,null,null,null,strNewFieldColor,null,null,null,null,null,null,null);
        //<< ;SR17513 if $get(YLFN)'="" do CheckRules^WWWFORMD(YFORM,$$$GetFormField(YFORM,YLFN),.YFELD,,,,,,.strNewFieldColor,,,,,,,)
        //<< do UpdateFieldFormat^COMUtils(pidField_".style","backgroundColor",strNewFieldColor)
        m$.Cmd.Do("COMUtils.UpdateFieldFormat",mOp.Concat(pidField.get(),".style"),"backgroundColor",strNewFieldColor.get());
      }
    }
    //<< }
    //<< ;   do ResetFieldFormat^COMUtils(pidField_".style","backgroundColor")
    //<< 
    //<< } else {
    else {
      //<< set bgColour = $$$SysEnum("FARBE",+$$$WWW012ColorforWarnings($get(^WWW012(0,0,1))))
      bgColour.set(include.COMSYSWWW.$$$SysEnum(m$,"FARBE",mOp.Positive(include.WWWConst.$$$WWW012ColorforWarnings(m$,m$.Fnc.$get(m$.var("^WWW012",0,0,1))))));
      //<< do UpdateFieldFormat^COMUtils(pidField_".style","backgroundColor",bgColour)
      m$.Cmd.Do("COMUtils.UpdateFieldFormat",mOp.Concat(pidField.get(),".style"),"backgroundColor",bgColour.get());
    }
    //<< }
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< DataAccess(pstrCallBack,YKEY,YFORM="",YART="",YLFN="",&pstrError="",YDATEI="",&pblnCheckFound,YKEYCONTAINER="")
  public Object DataAccess(Object ... _p) {
    mVar pstrCallBack = m$.newVarRef("pstrCallBack",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar YKEY = m$.newVarRef("YKEY",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar YFORM = m$.newVarRef("YFORM",(((_p!=null)&&(_p.length>=3))?_p[2]:null),"");
    mVar YART = m$.newVarRef("YART",(((_p!=null)&&(_p.length>=4))?_p[3]:null),"");
    mVar YLFN = m$.newVarRef("YLFN",(((_p!=null)&&(_p.length>=5))?_p[4]:null),"");
    mVar pstrError = m$.newVarRef("pstrError",(((_p!=null)&&(_p.length>=6))?_p[5]:null),"");
    mVar YDATEI = m$.newVarRef("YDATEI",(((_p!=null)&&(_p.length>=7))?_p[6]:null),"");
    mVar pblnCheckFound = m$.newVarRef("pblnCheckFound",(((_p!=null)&&(_p.length>=8))?_p[7]:null));
    mVar YKEYCONTAINER = m$.newVarRef("YKEYCONTAINER",(((_p!=null)&&(_p.length>=9))?_p[8]:null),"");
    //<< ;-------------------------------------------------------------------------------
    //<< ; Call data access function
    //<< ;
    //<< ; Called By : ValidRelation^WWWFieldValidation,
    //<< ;               DataAccess^COMViewFilter
    //<< ;               GetWarehouseLocations^INReqTable
    //<< ;               PARAM^WWWFOR71
    //<< ;               ANZEIGE^WWWSEAR3
    //<< ;
    //<< ; Params:
    //<< ;   YKEY, YFORM, YART, YLFN are all available as parameters to the function
    //<< ;   pstrCallBack        function to call
    //<< ;   pstrError           byRef: error message
    //<< ;   pblnCheckFound      byRef: Used when looping through items for a list.
    //<< ;                       If no callouts are found, don't keep looking.
    //<< ;   YKEYCONTAINER       Check keys
    //<< ;
    //<< ; Returns:  valid - yes/no
    //<< ;
    //<< ; History:
    //<< ; 18-Nov-2011   PPP     SR17955: Ensure that YFELD always exists
    //<< ; 11-Dec-2007   GM      SRBR014601: Included new parameter "YKEYCONTAINER"
    //<< ; 07-Dec-2007   GRF     Clarify pblnSkipCheck purpose and document calling use
    //<< ; 09-Oct-2007   shobby  SRBR014744: Pass the class that is being used to populate
    //<< ;                           the list in to the DataAccess call
    //<< ; 28-Sep-2007   shobby  SRBR014731: Get the YFELD of the on screen data.
    //<< ; 15-Aug-2005   JW      SR12290: Created
    //<< ;-------------------------------------------------------------------------------
    //<< ; Calling routine
    //<< ;   set blnCheckFound = $$$YES
    //<< ;   for {
    //<< ;       (getting record)
    //<< ;
    //<< ;       if blnCheckFound {
    //<< ;           set blnValid = $$DataAccess^WWWFieldValidation( ... ,.blnCheckFound)
    //<< ;       }
    //<< ;       if blnValid {
    //<< ;           (action on valid record)
    //<< ;       }
    //<< ;   }
    //<< ;
    //<< ; If $$DataAccess^WWWFieldValidation does not find a call back or either of the
    //<< ; hooks then the pblnFoundCheck flag will not be set to $$$YES and this routine
    //<< ; will not be recalled again for the remaining records detected by the for loop.
    //<< ;-------------------------------------------------------------------------------
    //<< new blnValid,strStatus
    mVar blnValid = m$.var("blnValid");
    mVar strStatus = m$.var("strStatus");
    m$.newVar(blnValid,strStatus);
    //<< new YFELD
    mVar YFELD = m$.var("YFELD");
    m$.newVar(YFELD);
    //<< 
    //<< $$$LogR("DataAccess",YFORM_"<"_YART_"<"_YLFN_"<"_$get(pstrCallBack)_"<")
    $$$LogR(m$,"DataAccess",mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(YFORM.get(),"<"),YART.get()),"<"),YLFN.get()),"<"),m$.Fnc.$get(pstrCallBack)),"<"));
    //<< 
    //<< set strStatus = $$$OK
    strStatus.set(include.COMSYS.$$$OK(m$));
    //<< 
    //<< set YFELD = $$GetFormData^COMUtilForm(YFORM)  ; note that the YFELD variable may be a parameter in the pstrCallBack variable.
    YFELD.set(m$.fnc$("COMUtilForm.GetFormData",YFORM.get()));
    //<< //SR17955
    //<< if YFELD="" {
    if (mOp.Equal(YFELD.get(),"")) {
      //<< set YFELD = $$$GRIDGetYFELD()
      YFELD.set(include.COMGridEdit31Interface.$$$GRIDGetYFELD(m$));
    }
    //<< }
    //<< set YKEY  = $translate(YKEY,"""","")
    YKEY.set(m$.Fnc.$translate(YKEY.get(),"\"",""));
    //<< set pblnCheckFound = $$$NO
    pblnCheckFound.set(include.COMSYS.$$$NO(m$));
    //<< 
    //<< ; *** EXECUTE # ***
    //<< if pstrCallBack'="" {
    if (mOp.NotEqual(pstrCallBack.get(),"")) {
      //<< xecute "set strStatus="_pstrCallBack
      m$.Cmd.Xecute(mOp.Concat("set strStatus=",pstrCallBack.get()));
      //<< set pblnCheckFound = $$$YES
      pblnCheckFound.set(include.COMSYS.$$$YES(m$));
    }
    //<< }
    //<< 
    //<< if ($$$ISOK(strStatus) && (YDATEI'="")) {
    if ((mOp.Logical(include.COMSYS.$$$ISOK(m$,strStatus)) && (mOp.NotEqual(YDATEI.get(),"")))) {
      //<< if $data(^WWW001Hook(0,YDATEI,$$$EnumWWWEVENTTYPEOnBeforeDataAccess)) {
      if (mOp.Logical(m$.Fnc.$data(m$.var("^WWW001Hook",0,YDATEI.get(),include.WWWConst.$$$EnumWWWEVENTTYPEOnBeforeDataAccess(m$))))) {
        //<< ; *** EXECUTE # ***
        //<< xecute "set strStatus="_$piece(^WWW001Hook(0,YDATEI,$$$EnumWWWEVENTTYPEOnBeforeDataAccess,1),Y,1)
        m$.Cmd.Xecute(mOp.Concat("set strStatus=",m$.Fnc.$piece(m$.var("^WWW001Hook",0,YDATEI.get(),include.WWWConst.$$$EnumWWWEVENTTYPEOnBeforeDataAccess(m$),1).get(),m$.var("Y").get(),1)));
        //<< set pblnCheckFound = $$$YES
        pblnCheckFound.set(include.COMSYS.$$$YES(m$));
      }
      //<< }
      //<< 
      //<< if $$$ISOK(strStatus) {
      if (mOp.Logical(include.COMSYS.$$$ISOK(m$,strStatus))) {
        //<< if $data(^WWW001VARHooks(0,YDATEI,$$$EnumWWWEVENTTYPEOnBeforeDataAccess)) {
        if (mOp.Logical(m$.Fnc.$data(m$.var("^WWW001VARHooks",0,YDATEI.get(),include.WWWConst.$$$EnumWWWEVENTTYPEOnBeforeDataAccess(m$))))) {
          //<< ; *** EXECUTE # ***
          //<< xecute "set strStatus="_$piece(^WWW001VARHooks(0,YDATEI,$$$EnumWWWEVENTTYPEOnBeforeDataAccess,1),Y,1)
          m$.Cmd.Xecute(mOp.Concat("set strStatus=",m$.Fnc.$piece(m$.var("^WWW001VARHooks",0,YDATEI.get(),include.WWWConst.$$$EnumWWWEVENTTYPEOnBeforeDataAccess(m$),1).get(),m$.var("Y").get(),1)));
          //<< set pblnCheckFound = $$$YES
          pblnCheckFound.set(include.COMSYS.$$$YES(m$));
        }
      }
    }
    //<< }
    //<< }
    //<< }
    //<< 
    //<< set blnValid = $$$ISOK(strStatus)
    blnValid.set(include.COMSYS.$$$ISOK(m$,strStatus));
    //<< 
    //<< if 'blnValid {
    if (mOp.Not(blnValid.get())) {
      //<< if strStatus=$$$NO {    // Default error message
      if (mOp.Equal(strStatus.get(),include.COMSYS.$$$NO(m$))) {
        //<< set pstrError = $listbuild("WWW00027",YINHALT)  ; "`%1` cannot be used at this time."
        pstrError.set(m$.Fnc.$listbuild("WWW00027",m$.var("YINHALT").get()));
      }
      //<< } else {
      else {
        //<< set pstrError = strStatus
        pstrError.set(strStatus.get());
      }
    }
    //<< }
    //<< }
    //<< quit blnValid
    return blnValid.get();
  }

  //<< 
  //<< 
  //<< GetRelation(pstrFieldType="D",pidForm,pidClass,pidField,pobjFormFld="",&pblnTest,&pidRelation)
  public Object GetRelation(Object ... _p) {
    mVar pstrFieldType = m$.newVarRef("pstrFieldType",(((_p!=null)&&(_p.length>=1))?_p[0]:null),"D");
    mVar pidForm = m$.newVarRef("pidForm",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pidClass = m$.newVarRef("pidClass",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    mVar pidField = m$.newVarRef("pidField",(((_p!=null)&&(_p.length>=4))?_p[3]:null));
    mVar pobjFormFld = m$.newVarRef("pobjFormFld",(((_p!=null)&&(_p.length>=5))?_p[4]:null),"");
    mVar pblnTest = m$.newVarRef("pblnTest",(((_p!=null)&&(_p.length>=6))?_p[5]:null));
    mVar pidRelation = m$.newVarRef("pidRelation",(((_p!=null)&&(_p.length>=7))?_p[6]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Get the validation relation information to determine whether a validation should happen
    //<< ;
    //<< ; Called by:    FIELD^WWWEVENT
    //<< ; Params:
    //<< ;   pstrFieldType       The field type, defaults to D for Data Field other values,
    //<< ;                           P for Primary Key or M for manual field.
    //<< ;                       NOTE : "C" represents Calculated field in WWW003Calc
    //<< ;   pidForm             The id of the Form
    //<< ;   pidClass            The id of the class
    //<< ;   pidField            The id of the field on the form/class
    //<< ;   pobjFormFld         The form field data (or "")
    //<< ;   pblnTest            (ByRef) Should we test for validation
    //<< ;
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 05-Jan-2011   GRF     SR17579: GetFormField macro; doco
    //<< ; 25-Feb-2010   GRF     SR16521: parrAssociatedTo => arrAssociatedTo & new;
    //<< ;                           remove unused pidAssociatedField
    //<< ; 06-May-2009   PPP     SR16521: Barcode Scanning to identify Item
    //<< ;-------------------------------------------------------------------------------
    //<< new arrAssociatedTo,idAssociatedField,idField,objClassFld
    mVar arrAssociatedTo = m$.var("arrAssociatedTo");
    mVar idAssociatedField = m$.var("idAssociatedField");
    mVar idField = m$.var("idField");
    mVar objClassFld = m$.var("objClassFld");
    m$.newVar(arrAssociatedTo,idAssociatedField,idField,objClassFld);
    //<< 
    //<< 
    //<< $$$LogR("GetRelation",$get(pidForm)_"<"_$get(pidClass)_"<"_pstrFieldType_"<"_$get(pidField)_"<")
    $$$LogR(m$,"GetRelation",mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(m$.Fnc.$get(pidForm),"<"),m$.Fnc.$get(pidClass)),"<"),pstrFieldType.get()),"<"),m$.Fnc.$get(pidField)),"<"));
    //<< 
    //<< 
    //<< quit:($get(pidForm)="")||($get(pidField)="")||($get(pstrFieldType)="")
    if ((mOp.Equal(m$.Fnc.$get(pidForm),"")) || (mOp.Equal(m$.Fnc.$get(pidField),"")) || (mOp.Equal(m$.Fnc.$get(pstrFieldType),""))) {
      return null;
    }
    //<< 
    //<< if pobjFormFld="" {
    if (mOp.Equal(pobjFormFld.get(),"")) {
      //<< ;   set pobjFormFld = $$Get^WWW122(pidForm,+$order(^WWW122s(0,4,pidField,pidForm,"")))  ; SR17579
      //<< set pobjFormFld = $$Get^WWW122(pidForm,+$$$GetFormField(pidForm,pidField))
      pobjFormFld.set(m$.fnc$("WWW122.Get",pidForm.get(),mOp.Positive(include.COMSYSWWW.$$$GetFormField(m$,pidForm,pidField))));
    }
    //<< }
    //<< /*
    //<< ; FIXME : Why aren't we performing full D/P/C/M check here - if we do then don't need to pass
    //<< ;         from WWWEVENT - only require to send if checking WWWDATEN info.
    //<< 
    //<< ; e.g. (from WWEVENT)
    //<< if pobjFormFld="" {
    //<< set pobjFormFld = $case(pstrFieldType,
    //<< "D" : $$Get^WWW122(YFORM,+$$$GetFormField(pidForm,pidField)),
    //<< "P" : $get(^WWW121(0,pidForm,pidField,1)),
    //<< "M" : $$Get^WWW122(pidForm,pidField),
    //<< : "")
    //<< */
    //<< if pobjFormFld'="" {
    if (mOp.NotEqual(pobjFormFld.get(),"")) {
      //<< set pblnTest    = $$$NO
      pblnTest.set(include.COMSYS.$$$NO(m$));
      //<< set pidRelation = $$$WWW122RelationClass(pobjFormFld)   // Get form field relation
      pidRelation.set(include.WWWConst.$$$WWW122RelationClass(m$,pobjFormFld));
      //<< 
      //<< if pidRelation'="" {
      if (mOp.NotEqual(pidRelation.get(),"")) {
        //<< set pblnTest = '$$$WWW122NoRelationValidation(pobjFormFld)
        pblnTest.set(mOp.Not(include.WWWConst.$$$WWW122NoRelationValidation(m$,pobjFormFld)));
      }
      //<< 
      //<< } elseif pidClass'="" { // Check class definition
      else if (mOp.NotEqual(pidClass.get(),"")) {
        //<< set objClassFld = $case(pstrFieldType,
        //<< "D" : $get(^WWW003(0,pidClass,pidField,1)),
        //<< "P" : $get(^WWW002(0,pidClass,pidField,1)),
        //<< : "")
        objClassFld.set(m$.Fnc.$case(pstrFieldType.get(),"D",m$.Fnc.$get(m$.var("^WWW003",0,pidClass.get(),pidField.get(),1)),"P",m$.Fnc.$get(m$.var("^WWW002",0,pidClass.get(),pidField.get(),1)),""));
        //<< 
        //<< set pidRelation = $$$WWW003RelationDatabase(objClassFld)    // Get class field relation
        pidRelation.set(include.WWWConst.$$$WWW003RelationDatabase(m$,objClassFld));
        //<< if pidRelation'="" {
        if (mOp.NotEqual(pidRelation.get(),"")) {
          //<< set pblnTest = '$$$WWW003NoRelationValidation(objClassFld)
          pblnTest.set(mOp.Not(include.WWWConst.$$$WWW003NoRelationValidation(m$,objClassFld)));
          //<< 
          //<< if pblnTest {
          if (mOp.Logical(pblnTest.get())) {
            //<< if $$$WWW003InputType(objClassFld)=3 {          // Don't test Memo fields
            if (mOp.Equal(include.WWWConst.$$$WWW003InputType(m$,objClassFld),3)) {
              //<< set pblnTest = $$$NO
              pblnTest.set(include.COMSYS.$$$NO(m$));
            }
          }
        }
      }
      //<< }
      //<< }
      //<< }
      //<< }
      //<< 
      //<< //Only test Auto/Text/Select for now.
      //<< if $case(+$$$WWW122DataInputType(pobjFormFld),0:$$$NO,1:$$$NO,4:$$$NO,:$$$YES) {
      if (mOp.Logical(m$.Fnc.$case(mOp.Positive(include.WWWConst.$$$WWW122DataInputType(m$,pobjFormFld)),0,include.COMSYS.$$$NO(m$),1,include.COMSYS.$$$NO(m$),4,include.COMSYS.$$$NO(m$),include.COMSYS.$$$YES(m$)))) {
        //<< set pblnTest=$$$NO
        pblnTest.set(include.COMSYS.$$$NO(m$));
      }
      //<< }
      //<< 
      //<< set idAssociatedField = $$$WWW122AssociatedwithField(pobjFormFld)
      idAssociatedField.set(include.WWWConst.$$$WWW122AssociatedwithField(m$,pobjFormFld));
      //<< if idAssociatedField'="" {
      if (mOp.NotEqual(idAssociatedField.get(),"")) {
        //<< set pblnTest    = $$$YES
        pblnTest.set(include.COMSYS.$$$YES(m$));
        //<< set pidRelation = $get(pidRelation)
        pidRelation.set(m$.Fnc.$get(pidRelation));
      }
      //<< }
      //<< 
      //<< if $data(^WWW122s(0,7,pidField,pidForm)) {
      if (mOp.Logical(m$.Fnc.$data(m$.var("^WWW122s",0,7,pidField.get(),pidForm.get())))) {
        //<< set pidRelation  = $get(pidRelation)
        pidRelation.set(m$.Fnc.$get(pidRelation));
        //<< set idField = ""
        idField.set("");
        //<< for {
        for (;true;) {
          //<< set idField = $order(^WWW122s(0,7,pidField,pidForm,idField))
          idField.set(m$.Fnc.$order(m$.var("^WWW122s",0,7,pidField.get(),pidForm.get(),idField.get())));
          //<< quit:idField=""
          if (mOp.Equal(idField.get(),"")) {
            break;
          }
          //<< 
          //<< set arrAssociatedTo($$$WWW122SequenceNumber($get(^WWW122(0,pidForm,idField,1))))="" //SR15513
          arrAssociatedTo.var(include.WWWConst.$$$WWW122SequenceNumber(m$,m$.Fnc.$get(m$.var("^WWW122",0,pidForm.get(),idField.get(),1)))).set("");
        }
        //<< }
        //<< set pblnTest=''$data(arrAssociatedTo)
        pblnTest.set(mOp.Not(mOp.Not(m$.Fnc.$data(arrAssociatedTo))));
      }
    }
    //<< }
    //<< }
    //<< quit
    return null;
  }

//<< 
//<< 
//<< //////////////////////////////////////////////////////////
//<< //                                                      //
//<< //      THE FOLLOWING 4 ROUTINES ARE NOT IN USE         //
//<< //                                                      //
//<< // It would have parsed the relational primary keys,    //
//<< // but there is no point as @Net doesn't do it.         //
//<< // (See SR13031)                                        //
//<< //                                                      //
//<< //  To reinstate, swap the line above:                  //
//<< //      set blnValid = $$DefineKeys(.strRelKeys)        //
//<< //  to                                                  //
//<< //      set blnValid = $$ParseKeys(.strRelKeys)         //
//<< //                                                      //
//<< //////////////////////////////////////////////////////////
//<< /*
//<< ParseKeys(pstrToParse="")
//<< new lenParse,i,j,count,strToParse,strParsed,strParseNow,blnValid
//<< 
//<< set lenParse = $length(pstrToParse,",")
//<< set i = 1
//<< 
//<< do {
//<< for j=i:1:lenParse {
//<< set strParseNow = $piece(pstrToParse,",",i,j)
//<< 
//<< set blnValid = $$ParseKey(.strParseNow)
//<< quit:strParseNow=""
//<< quit:blnValid
//<< }
//<< quit:'blnValid
//<< 
//<< set $piece(strParsed,",",$i(count)) = strParseNow
//<< set i=j+1
//<< 
//<< } while (i <= lenParse)
//<< 
//<< set pstrToParse = strParsed
//<< 
//<< quit blnValid
//<< 
//<< 
//<< ParseKey(pstrToParse="")
//<< new lenParse,i,j,count,strToParse,strParsed,strParseNow,blnValid
//<< 
//<< set lenParse = $length(pstrToParse,",")
//<< set i = 1
//<< 
//<< do {
//<< for j=i:1:lenParse {
//<< set strParseNow = $piece(pstrToParse,"_",i,j)
//<< 
//<< set blnValid = $$ParseExpr(.strParseNow)
//<< quit:strParseNow=""
//<< quit:blnValid
//<< }
//<< quit:'blnValid
//<< 
//<< set $piece(strParsed,"_",$i(count)) = strParseNow
//<< set i=j+1
//<< 
//<< } while (i <= lenParse)
//<< 
//<< set pstrToParse = strParsed
//<< 
//<< quit blnValid
//<< 
//<< 
//<< ParseExpr(pstrToParse="")
//<< new blnValid,strParseNow
//<< 
//<< set blnValid=$$$YES
//<< 
//<< if '$isvalidnum(pstrToParse) {      // Is a number
//<< if '($extract(pstrToParse)=$$$DBLQUOTE && ($extract($reverse(pstrToParse))=$$$DBLQUOTE)) {  // Is a string
//<< 
//<< if $find(pstrToParse,"(") {
//<< set strParseNow = $piece(pstrToParse,"(",2,999)
//<< set $extract(strParseNow,$length(strParseNow)) = ""     // Remove ")"
//<< 
//<< set blnValid = $$ParseKeys(strParseNow)
//<< 
//<< set $piece(pstrToParse,")",2,999) = strParseNow_")"
//<< }
//<< 
//<< if blnValid {
//<< if $extract(pstrToParse) '= "$" {
//<< if '$data(@pstrToParse) {                   // Is defined
//<< // Look it up
//<< set blnValid = $$DefineVar(.pstrToParse)
//<< }
//<< }
//<< }
//<< }
//<< }
//<< quit blnValid
//<< 
//<< 
//<< DefineVar(pstrVar="") private
//<< new idVarFld,idClsFld,idxKey,idxVar
//<< 
//<< set idxVar = $$$Index(pstrVar)  // Loop through primary keys
//<< 
//<< if $data(^WWW121s(0,2,idxVar,YFORM)) {
//<< set idVarFld = $order(^WWW121s(0,2,idxVar,YFORM,""))
//<< set pstrVar = $piece($get(^WWWDATEN(0,+$horolog,YUSER,YFORM,"P",1)),",",idVarFld)
//<< 
//<< } else {                        // Loop through data fields
//<< set idVarFld = $order(^WWW122s(0,2,idxVar,YFORM,""))
//<< if idVarFld'="" {
//<< set idClsFld = $$$WWW122SequenceNumber($get(^WWW122(0,YFORM,idVarFld,1)))
//<< if idClsFld="" {
//<< set pstrVar = $piece($get(^WWWDATEN(0,+$horolog,YUSER,YFORM,"M",1)),"~",idVarFld)
//<< } else {
//<< set pstrVar = $piece($get(^WWWDATEN(0,+$horolog,YUSER,YFORM,"D",1)),"~",idClsFld)
//<< }
//<< } else {
//<< set pstrVar=""
//<< }
//<< }
//<< set pstrVar = $$^WWWKEYBUILD(pstrVar)       ; Define variable
//<< 
//<< quit (pstrVar'="")
//<< */
//<< 
}
