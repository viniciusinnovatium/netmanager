//*****************************************************************************
//** TASC - ALPHALINC - MAC WWW128Form
//** Innovatium Systems - Code Converter - v1.27
//** 2014-05-22 00:14:31
//*****************************************************************************

import mLibrary.*;

//<< #include WWWConst
import include.WWWConst;
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

//<< WWW128Form
public class WWW128Form extends mClass {

  public void main() {
    _WWW128Form();
  }

  public void _WWW128Form() {
  }

  //<< ;BR014965 Change to class/form
  //<< 
  //<< ;---------------------------------------
  //<< ; Numerator Classes
  //<< ;           WWW128      WWW1280     WWW1281     WWW128Form
  //<< ;   P1      Form        Form        Form        Class
  //<< ;   P2       -          Location    Sequence    Form (associated with P1)
  //<< ;
  //<< ;   D1      SeqNo       SeqNo       SeqNo       Prefix
  //<< ;   D2      Increment   Increment    -          Link Class
  //<< ;   D3      Reset       Reset
  //<< ;   D4      ResetYear   ResetYear
  //<< ;---------------------------------------
  //<< 
  //<< OnBeforeFormConstruction(&YKEY)
  public Object OnBeforeFormConstruction(Object ... _p) {
    mVar YKEY = m$.newVarRef("YKEY",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; As WWW128 uses Form as the primary key (well sometimes)
    //<< ; When linking to WWW128Form we need to exchange form to the related class.
    //<< ;
    //<< ; Params:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 22-May-2009   shobby  SRBR014975: YKEY is actually a two part key, even though
    //<< ;                           when coming from WWW128 we only get the first part.
    //<< ; 18-May-2009   shobby  SRBR014965: Created
    //<< ;-------------------------------------------------------------------------------
    //<< if '$$$NoKey(YKEY) {
    if (mOp.Not(include.COMSYS.$$$NoKey(m$,YKEY))) {
      //<< set YKEY = $$$WWW120ClassUsedInForm($get(^WWW120(0,$$$KEY1(YKEY),1)))_","_$$$KEY2(YKEY)
      YKEY.set(mOp.Concat(mOp.Concat(include.WWWConst.$$$WWW120ClassUsedInForm(m$,m$.Fnc.$get(m$.var("^WWW120",0,include.COMSYSWWW.$$$KEY1(m$,YKEY),1))),","),include.COMSYSWWW.$$$KEY2(m$,YKEY)));
    }
    //<< }
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< GetLink(pidClass,pidForm="")
  public Object GetLink(Object ... _p) {
    mVar pidClass = m$.newVarRef("pidClass",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pidForm = m$.newVarRef("pidForm",(((_p!=null)&&(_p.length>=2))?_p[1]:null),"");
    //<< ;-------------------------------------------------------------------------------
    //<< ; Gets the link defined to force a class to share a numbering system with another class
    //<< ;
    //<< ; Called by : WWWNEXT, WWWForm128
    //<< ;
    //<< ; Inputs:   Keys for WWW128Form
    //<< ;
    //<< ; Returns:  Associated Class, if any (D2)
    //<< ;
    //<< ; History:
    //<< ; 20-May-2009   GRF     SRBR014965: standarise parameters
    //<< ; 03-Jul-2008   shobby  SRBR014965: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new objWWW128Form,strLink
    mVar objWWW128Form = m$.var("objWWW128Form");
    mVar strLink = m$.var("strLink");
    m$.newVar(objWWW128Form,strLink);
    //<< 
    //<< set strLink = ""
    strLink.set("");
    //<< 
    //<< if pidForm'="" {
    if (mOp.NotEqual(pidForm.get(),"")) {
      //<< set objWWW128Form = $get(^WWW128Form(0,pidClass,pidForm,1))
      objWWW128Form.set(m$.Fnc.$get(m$.var("^WWW128Form",0,pidClass.get(),pidForm.get(),1)));
      //<< set strLink       = $$$WWW128FormLink(objWWW128Form)
      strLink.set(include.WWWConst.$$$WWW128FormLink(m$,objWWW128Form));
    }
    //<< }
    //<< quit strLink
    return strLink.get();
  }

  //<< 
  //<< 
  //<< GetPrefix(pidClass,pidForm="")
  public Object GetPrefix(Object ... _p) {
    mVar pidClass = m$.newVarRef("pidClass",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pidForm = m$.newVarRef("pidForm",(((_p!=null)&&(_p.length>=2))?_p[1]:null),"");
    //<< ;-------------------------------------------------------------------------------
    //<< ; Gets the link defined to force a class to share a numbering system with another class
    //<< ;
    //<< ; Called by : WWWNEXT, WWWForm128
    //<< ;
    //<< ; Inputs:   Keys for WWW128Form
    //<< ;
    //<< ; Returns:  Assigned Prefix, if any (D1)
    //<< ;
    //<< ; History:
    //<< ; 20-May-2009   GRF     SRBR014965: standarise parameters
    //<< ; 03-Jul-2008   shobby  SRBR014965: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new objWWW128Form,strPrefix
    mVar objWWW128Form = m$.var("objWWW128Form");
    mVar strPrefix = m$.var("strPrefix");
    m$.newVar(objWWW128Form,strPrefix);
    //<< 
    //<< set strPrefix=""
    strPrefix.set("");
    //<< 
    //<< if pidForm'="" {
    if (mOp.NotEqual(pidForm.get(),"")) {
      //<< set objWWW128Form = $get(^WWW128Form(0,pidClass,pidForm,1))
      objWWW128Form.set(m$.Fnc.$get(m$.var("^WWW128Form",0,pidClass.get(),pidForm.get(),1)));
      //<< set strPrefix     = $$$WWW128FormPrefix(objWWW128Form)
      strPrefix.set(include.WWWConst.$$$WWW128FormPrefix(m$,objWWW128Form));
    }
    //<< }
    //<< quit strPrefix
    return strPrefix.get();
  }

  //<< 
  //<< 
  //<< GetPrefixes(pidClass)
  public Object GetPrefixes(Object ... _p) {
    mVar pidClass = m$.newVarRef("pidClass",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Build an array of id prefixes and then translate the array into a string.
    //<< ; When allocating a new sequence number it is necessary to check all associated
    //<< ; classes - each potentially its own prefix - to ensure that the number has not
    //<< ; been allocated elsewhere.  The string returned contains all possible cross-
    //<< ; checks that are required.
    //<< ;
    //<< ; Called by : WWWNEXT
    //<< ;
    //<< ; Inputs:
    //<< ;
    //<< ; Returns:
    //<< ;   String of "Prefix;Class" pairs, tilde delimited.
    //<< ;
    //<< ; History:
    //<< ; 03-Jul-2008   shobby  SRBR014965: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new arrPrefixes,idPrefix,strPrefixList
    mVar arrPrefixes = m$.var("arrPrefixes");
    mVar idPrefix = m$.var("idPrefix");
    mVar strPrefixList = m$.var("strPrefixList");
    m$.newVar(arrPrefixes,idPrefix,strPrefixList);
    //<< 
    //<< set strPrefixList = ""
    strPrefixList.set("");
    //<< do GetPrefixesLoop(pidClass,.arrPrefixes)
    m$.Cmd.Do("GetPrefixesLoop",pidClass.get(),arrPrefixes);
    //<< do GetPrefixesThatPointToMe(pidClass,.arrPrefixes)
    m$.Cmd.Do("GetPrefixesThatPointToMe",pidClass.get(),arrPrefixes);
    //<< set idPrefix = ""
    idPrefix.set("");
    //<< for {
    for (;true;) {
      //<< set idPrefix = $order(arrPrefixes(idPrefix))
      idPrefix.set(m$.Fnc.$order(arrPrefixes.var(idPrefix.get())));
      //<< quit:idPrefix=""
      if (mOp.Equal(idPrefix.get(),"")) {
        break;
      }
      //<< 
      //<< set $piece(strPrefixList,Y,$length(strPrefixList,Y)+1) = idPrefix
      m$.pieceVar(strPrefixList,m$.var("Y").get(),mOp.Add(m$.Fnc.$length(strPrefixList.get(),m$.var("Y").get()),1)).set(idPrefix.get());
    }
    //<< }
    //<< set strPrefixList = $piece(strPrefixList,Y,2,$length(strPrefixList,Y))
    strPrefixList.set(m$.Fnc.$piece(strPrefixList.get(),m$.var("Y").get(),2,m$.Fnc.$length(strPrefixList.get(),m$.var("Y").get())));
    //<< quit strPrefixList
    return strPrefixList.get();
  }

  //<< 
  //<< 
  //<< GetPrefixesLoop(pidClass,&parrPrefixes)
  public Object GetPrefixesLoop(Object ... _p) {
    mVar pidClass = m$.newVarRef("pidClass",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar parrPrefixes = m$.newVarRef("parrPrefixes",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Determine a list of prefixes that the IDs might have been saved with
    //<< ;
    //<< ; Inputs:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 20-May-2009   GRF     SRBR014965: use and test idLinkClass
    //<< ; 10-Jul-2008   shobby  SRBR014965: 2nd call to GetLink to prevent recursion.
    //<< ; 03-Jul-2008   shobby  SRBR014965: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new idForm,idLinkClass,objWWW128Form,strPrefix,strFormLink
    mVar idForm = m$.var("idForm");
    mVar idLinkClass = m$.var("idLinkClass");
    mVar objWWW128Form = m$.var("objWWW128Form");
    mVar strPrefix = m$.var("strPrefix");
    mVar strFormLink = m$.var("strFormLink");
    m$.newVar(idForm,idLinkClass,objWWW128Form,strPrefix,strFormLink);
    //<< 
    //<< set parrPrefixes(";"_pidClass)=""
    parrPrefixes.var(mOp.Concat(";",pidClass.get())).set("");
    //<< set idForm = ""
    idForm.set("");
    //<< for {
    for (;true;) {
      //<< set idForm = $order(^WWW128Form(0,pidClass,idForm))
      idForm.set(m$.Fnc.$order(m$.var("^WWW128Form",0,pidClass.get(),idForm.get())));
      //<< quit:idForm=""
      if (mOp.Equal(idForm.get(),"")) {
        break;
      }
      //<< 
      //<< set strPrefix   = $$GetPrefix(pidClass,idForm)
      strPrefix.set(m$.fnc$("GetPrefix",pidClass.get(),idForm.get()));
      //<< set strFormLink = $$GetLink(pidClass,idForm)
      strFormLink.set(m$.fnc$("GetLink",pidClass.get(),idForm.get()));
      //<< set parrPrefixes(strPrefix_";"_$$$WWW120ClassUsedInForm($get(^WWW120(0,idForm,1))))=""
      parrPrefixes.var(mOp.Concat(mOp.Concat(strPrefix.get(),";"),include.WWWConst.$$$WWW120ClassUsedInForm(m$,m$.Fnc.$get(m$.var("^WWW120",0,idForm.get(),1))))).set("");
      //<< ;   if (strFormLink'="")&&(strFormLink'=pidClass)&&($$GetLink($piece($get(^WWW120(0,strFormLink,1)),"~",11),strFormLink)'=idForm) {
      //<< ;       do GetPrefixesLoop(strFormLink,.parrPrefixes)
      //<< ;   }
      //<< if (strFormLink'="") && (strFormLink'=pidClass) {
      if ((mOp.NotEqual(strFormLink.get(),"")) && (mOp.NotEqual(strFormLink.get(),pidClass.get()))) {
        //<< set idLinkClass = $$$WWW120ClassUsedInForm($get(^WWW120(0,strFormLink,1)))
        idLinkClass.set(include.WWWConst.$$$WWW120ClassUsedInForm(m$,m$.Fnc.$get(m$.var("^WWW120",0,strFormLink.get(),1))));
        //<< if (idLinkClass'="") && ($$GetLink(idLinkClass,strFormLink)'=idForm) {
        if ((mOp.NotEqual(idLinkClass.get(),"")) && (mOp.NotEqual(m$.fnc$("GetLink",idLinkClass.get(),strFormLink.get()),idForm.get()))) {
          //<< do GetPrefixesLoop(strFormLink,.parrPrefixes)
          m$.Cmd.Do("GetPrefixesLoop",strFormLink.get(),parrPrefixes);
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
  //<< GetPrefixesThatPointToMe(pidLink,&parrPrefixes)
  public Object GetPrefixesThatPointToMe(Object ... _p) {
    mVar pidLink = m$.newVarRef("pidLink",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar parrPrefixes = m$.newVarRef("parrPrefixes",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Determine a list of prefixes that the IDs might have been saved with
    //<< ;
    //<< ; Inputs:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 20-May-2009   GRF     SRBR014965: $$$Index and clarify variable names
    //<< ; 09-Jul-2008   shobby  SRBR014965: YM not 0
    //<< ; 04-Jul-2008   shobby  SRBR014965: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new idClass,idxLinkClass
    mVar idClass = m$.var("idClass");
    mVar idxLinkClass = m$.var("idxLinkClass");
    m$.newVar(idClass,idxLinkClass);
    //<< 
    //<< set idxLinkClass = $$$Index(pidLink)
    idxLinkClass.set(include.MEDConst.$$$Index(m$,pidLink));
    //<< set idClass = ""
    idClass.set("");
    //<< for {
    for (;true;) {
      //<< set idClass = $order(^WWW128Forms(0,1,idxLinkClass,idClass))
      idClass.set(m$.Fnc.$order(m$.var("^WWW128Forms",0,1,idxLinkClass.get(),idClass.get())));
      //<< quit:idClass=""
      if (mOp.Equal(idClass.get(),"")) {
        break;
      }
      //<< 
      //<< do GetPrefixesLoop(idClass,.parrPrefixes)
      m$.Cmd.Do("GetPrefixesLoop",idClass.get(),parrPrefixes);
    }
    //<< }
    //<< quit
    return null;
  }

//<< 
}
