//*****************************************************************************
//** TASC - ALPHALINC - INC include.MEDConst
//** Innovatium Systems - Code Converter - v1.27
//** 2014-05-22 00:14:14
//*****************************************************************************

package include;

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

//<< ; Enumerated values for Cache Datatypes
//<< ;
public class MEDConst extends mInclude {

  //<< #def1arg SaveGlobal(%obj) $$Save^SALUtils(YM,%obj)
  public static Object $$$SaveGlobal(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.fnc$("SALUtils.Save",m$.var("YM").get(),p$obj.get()));
  }

  //<< #define Index(%obj) $$Index^COMUtilIndex(%obj)
  public static Object $$$Index(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.fnc$("COMUtilIndex.Index",p$obj.get()));
  }

  //<< #define MEDAdmissionPatient(%obj) $piece(%obj,"~",1)
  public static Object $$$MEDAdmissionPatient(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",1));
  }

  public static void $$$MEDAdmissionPatientSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",1).set(_setval.get());
  }

  //<< #define FldMEDAdmissionPatient 1
  public static Object $$$FldMEDAdmissionPatient(mContext m$) {
    return (1);
  }

  //<< #define StrMEDAdmissionPatient $$GetPropertyName^COMConst("MEDAdmission",1)
  public static Object $$$StrMEDAdmissionPatient(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDAdmission",1));
  }

  //<< #define MEDAdmissionLocation(%obj) $piece(%obj,"~",2)
  public static Object $$$MEDAdmissionLocation(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",2));
  }

  public static void $$$MEDAdmissionLocationSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",2).set(_setval.get());
  }

  //<< #define FldMEDAdmissionLocation 2
  public static Object $$$FldMEDAdmissionLocation(mContext m$) {
    return (2);
  }

  //<< #define StrMEDAdmissionLocation $$GetPropertyName^COMConst("MEDAdmission",2)
  public static Object $$$StrMEDAdmissionLocation(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDAdmission",2));
  }

  //<< #define MEDAdmissionRoom(%obj) $piece(%obj,"~",3)
  public static Object $$$MEDAdmissionRoom(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",3));
  }

  public static void $$$MEDAdmissionRoomSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",3).set(_setval.get());
  }

  //<< #define FldMEDAdmissionRoom 3
  public static Object $$$FldMEDAdmissionRoom(mContext m$) {
    return (3);
  }

  //<< #define StrMEDAdmissionRoom $$GetPropertyName^COMConst("MEDAdmission",3)
  public static Object $$$StrMEDAdmissionRoom(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDAdmission",3));
  }

  //<< #define MEDAdmissionBed(%obj) $piece(%obj,"~",4)
  public static Object $$$MEDAdmissionBed(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",4));
  }

  public static void $$$MEDAdmissionBedSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",4).set(_setval.get());
  }

  //<< #define FldMEDAdmissionBed 4
  public static Object $$$FldMEDAdmissionBed(mContext m$) {
    return (4);
  }

  //<< #define StrMEDAdmissionBed $$GetPropertyName^COMConst("MEDAdmission",4)
  public static Object $$$StrMEDAdmissionBed(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDAdmission",4));
  }

  //<< #define MEDAdmissionReason(%obj) $piece(%obj,"~",5)
  public static Object $$$MEDAdmissionReason(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",5));
  }

  public static void $$$MEDAdmissionReasonSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",5).set(_setval.get());
  }

  //<< #define FldMEDAdmissionReason 5
  public static Object $$$FldMEDAdmissionReason(mContext m$) {
    return (5);
  }

  //<< #define StrMEDAdmissionReason $$GetPropertyName^COMConst("MEDAdmission",5)
  public static Object $$$StrMEDAdmissionReason(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDAdmission",5));
  }

  //<< #define MEDAdmissionDateAdmitted(%obj) $piece(%obj,"~",6)
  public static Object $$$MEDAdmissionDateAdmitted(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",6));
  }

  public static void $$$MEDAdmissionDateAdmittedSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",6).set(_setval.get());
  }

  //<< #define FldMEDAdmissionDateAdmitted 6
  public static Object $$$FldMEDAdmissionDateAdmitted(mContext m$) {
    return (6);
  }

  //<< #define StrMEDAdmissionDateAdmitted $$GetPropertyName^COMConst("MEDAdmission",6)
  public static Object $$$StrMEDAdmissionDateAdmitted(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDAdmission",6));
  }

  //<< #define MEDAdmissionTimeAdmitted(%obj) $piece(%obj,"~",7)
  public static Object $$$MEDAdmissionTimeAdmitted(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",7));
  }

  public static void $$$MEDAdmissionTimeAdmittedSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",7).set(_setval.get());
  }

  //<< #define FldMEDAdmissionTimeAdmitted 7
  public static Object $$$FldMEDAdmissionTimeAdmitted(mContext m$) {
    return (7);
  }

  //<< #define StrMEDAdmissionTimeAdmitted $$GetPropertyName^COMConst("MEDAdmission",7)
  public static Object $$$StrMEDAdmissionTimeAdmitted(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDAdmission",7));
  }

  //<< #define MEDAdmissionDateDischarged(%obj) $piece(%obj,"~",8)
  public static Object $$$MEDAdmissionDateDischarged(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",8));
  }

  public static void $$$MEDAdmissionDateDischargedSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",8).set(_setval.get());
  }

  //<< #define FldMEDAdmissionDateDischarged 8
  public static Object $$$FldMEDAdmissionDateDischarged(mContext m$) {
    return (8);
  }

  //<< #define StrMEDAdmissionDateDischarged $$GetPropertyName^COMConst("MEDAdmission",8)
  public static Object $$$StrMEDAdmissionDateDischarged(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDAdmission",8));
  }

  //<< #define MEDAdmissionTimeDischarged(%obj) $piece(%obj,"~",9)
  public static Object $$$MEDAdmissionTimeDischarged(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",9));
  }

  public static void $$$MEDAdmissionTimeDischargedSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",9).set(_setval.get());
  }

  //<< #define FldMEDAdmissionTimeDischarged 9
  public static Object $$$FldMEDAdmissionTimeDischarged(mContext m$) {
    return (9);
  }

  //<< #define StrMEDAdmissionTimeDischarged $$GetPropertyName^COMConst("MEDAdmission",9)
  public static Object $$$StrMEDAdmissionTimeDischarged(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDAdmission",9));
  }

  //<< #define MEDAdmissionCreatedBy(%obj) $piece(%obj,"~",10)
  public static Object $$$MEDAdmissionCreatedBy(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",10));
  }

  public static void $$$MEDAdmissionCreatedBySet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",10).set(_setval.get());
  }

  //<< #define FldMEDAdmissionCreatedBy 10
  public static Object $$$FldMEDAdmissionCreatedBy(mContext m$) {
    return (10);
  }

  //<< #define StrMEDAdmissionCreatedBy $$GetPropertyName^COMConst("MEDAdmission",10)
  public static Object $$$StrMEDAdmissionCreatedBy(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDAdmission",10));
  }

  //<< #define MEDAdmissionCreatedDate(%obj) $piece(%obj,"~",11)
  public static Object $$$MEDAdmissionCreatedDate(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",11));
  }

  public static void $$$MEDAdmissionCreatedDateSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",11).set(_setval.get());
  }

  //<< #define FldMEDAdmissionCreatedDate 11
  public static Object $$$FldMEDAdmissionCreatedDate(mContext m$) {
    return (11);
  }

  //<< #define StrMEDAdmissionCreatedDate $$GetPropertyName^COMConst("MEDAdmission",11)
  public static Object $$$StrMEDAdmissionCreatedDate(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDAdmission",11));
  }

  //<< #define MEDAdmissionChangedBy(%obj) $piece(%obj,"~",12)
  public static Object $$$MEDAdmissionChangedBy(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",12));
  }

  public static void $$$MEDAdmissionChangedBySet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",12).set(_setval.get());
  }

  //<< #define FldMEDAdmissionChangedBy 12
  public static Object $$$FldMEDAdmissionChangedBy(mContext m$) {
    return (12);
  }

  //<< #define StrMEDAdmissionChangedBy $$GetPropertyName^COMConst("MEDAdmission",12)
  public static Object $$$StrMEDAdmissionChangedBy(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDAdmission",12));
  }

  //<< #define MEDAdmissionChangedDate(%obj) $piece(%obj,"~",13)
  public static Object $$$MEDAdmissionChangedDate(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",13));
  }

  public static void $$$MEDAdmissionChangedDateSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",13).set(_setval.get());
  }

  //<< #define FldMEDAdmissionChangedDate 13
  public static Object $$$FldMEDAdmissionChangedDate(mContext m$) {
    return (13);
  }

  //<< #define StrMEDAdmissionChangedDate $$GetPropertyName^COMConst("MEDAdmission",13)
  public static Object $$$StrMEDAdmissionChangedDate(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDAdmission",13));
  }

  //<< #define MEDAdmissionFREE1(%obj) $piece(%obj,"~",21)
  public static Object $$$MEDAdmissionFREE1(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",21));
  }

  public static void $$$MEDAdmissionFREE1Set(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",21).set(_setval.get());
  }

  //<< #define FldMEDAdmissionFREE1 21
  public static Object $$$FldMEDAdmissionFREE1(mContext m$) {
    return (21);
  }

  //<< #define StrMEDAdmissionFREE1 $$GetPropertyName^COMConst("MEDAdmission",21)
  public static Object $$$StrMEDAdmissionFREE1(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDAdmission",21));
  }

  //<< #define MEDAdmissionFREE2(%obj) $piece(%obj,"~",22)
  public static Object $$$MEDAdmissionFREE2(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",22));
  }

  public static void $$$MEDAdmissionFREE2Set(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",22).set(_setval.get());
  }

  //<< #define FldMEDAdmissionFREE2 22
  public static Object $$$FldMEDAdmissionFREE2(mContext m$) {
    return (22);
  }

  //<< #define StrMEDAdmissionFREE2 $$GetPropertyName^COMConst("MEDAdmission",22)
  public static Object $$$StrMEDAdmissionFREE2(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDAdmission",22));
  }

  //<< #define MEDAdmissionFREE3(%obj) $piece(%obj,"~",23)
  public static Object $$$MEDAdmissionFREE3(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",23));
  }

  public static void $$$MEDAdmissionFREE3Set(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",23).set(_setval.get());
  }

  //<< #define FldMEDAdmissionFREE3 23
  public static Object $$$FldMEDAdmissionFREE3(mContext m$) {
    return (23);
  }

  //<< #define StrMEDAdmissionFREE3 $$GetPropertyName^COMConst("MEDAdmission",23)
  public static Object $$$StrMEDAdmissionFREE3(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDAdmission",23));
  }

  //<< #define MEDAdmissionFREE4(%obj) $piece(%obj,"~",24)
  public static Object $$$MEDAdmissionFREE4(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",24));
  }

  public static void $$$MEDAdmissionFREE4Set(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",24).set(_setval.get());
  }

  //<< #define FldMEDAdmissionFREE4 24
  public static Object $$$FldMEDAdmissionFREE4(mContext m$) {
    return (24);
  }

  //<< #define StrMEDAdmissionFREE4 $$GetPropertyName^COMConst("MEDAdmission",24)
  public static Object $$$StrMEDAdmissionFREE4(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDAdmission",24));
  }

  //<< #define MEDAdmissionFREE5(%obj) $piece(%obj,"~",25)
  public static Object $$$MEDAdmissionFREE5(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",25));
  }

  public static void $$$MEDAdmissionFREE5Set(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",25).set(_setval.get());
  }

  //<< #define FldMEDAdmissionFREE5 25
  public static Object $$$FldMEDAdmissionFREE5(mContext m$) {
    return (25);
  }

  //<< #define StrMEDAdmissionFREE5 $$GetPropertyName^COMConst("MEDAdmission",25)
  public static Object $$$StrMEDAdmissionFREE5(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDAdmission",25));
  }

  //<< #define MEDAdmissionFREE6(%obj) $piece(%obj,"~",26)
  public static Object $$$MEDAdmissionFREE6(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",26));
  }

  public static void $$$MEDAdmissionFREE6Set(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",26).set(_setval.get());
  }

  //<< #define FldMEDAdmissionFREE6 26
  public static Object $$$FldMEDAdmissionFREE6(mContext m$) {
    return (26);
  }

  //<< #define StrMEDAdmissionFREE6 $$GetPropertyName^COMConst("MEDAdmission",26)
  public static Object $$$StrMEDAdmissionFREE6(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDAdmission",26));
  }

  //<< #define MEDAdmissionFREE7(%obj) $piece(%obj,"~",27)
  public static Object $$$MEDAdmissionFREE7(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",27));
  }

  public static void $$$MEDAdmissionFREE7Set(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",27).set(_setval.get());
  }

  //<< #define FldMEDAdmissionFREE7 27
  public static Object $$$FldMEDAdmissionFREE7(mContext m$) {
    return (27);
  }

  //<< #define StrMEDAdmissionFREE7 $$GetPropertyName^COMConst("MEDAdmission",27)
  public static Object $$$StrMEDAdmissionFREE7(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDAdmission",27));
  }

  //<< #define MEDAdmissionFREE8(%obj) $piece(%obj,"~",28)
  public static Object $$$MEDAdmissionFREE8(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",28));
  }

  public static void $$$MEDAdmissionFREE8Set(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",28).set(_setval.get());
  }

  //<< #define FldMEDAdmissionFREE8 28
  public static Object $$$FldMEDAdmissionFREE8(mContext m$) {
    return (28);
  }

  //<< #define StrMEDAdmissionFREE8 $$GetPropertyName^COMConst("MEDAdmission",28)
  public static Object $$$StrMEDAdmissionFREE8(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDAdmission",28));
  }

  //<< #define MEDAdmissionFREE9(%obj) $piece(%obj,"~",29)
  public static Object $$$MEDAdmissionFREE9(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",29));
  }

  public static void $$$MEDAdmissionFREE9Set(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",29).set(_setval.get());
  }

  //<< #define FldMEDAdmissionFREE9 29
  public static Object $$$FldMEDAdmissionFREE9(mContext m$) {
    return (29);
  }

  //<< #define StrMEDAdmissionFREE9 $$GetPropertyName^COMConst("MEDAdmission",29)
  public static Object $$$StrMEDAdmissionFREE9(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDAdmission",29));
  }

  //<< #define MEDAdmissionFREE10(%obj) $piece(%obj,"~",30)
  public static Object $$$MEDAdmissionFREE10(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",30));
  }

  public static void $$$MEDAdmissionFREE10Set(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",30).set(_setval.get());
  }

  //<< #define FldMEDAdmissionFREE10 30
  public static Object $$$FldMEDAdmissionFREE10(mContext m$) {
    return (30);
  }

  //<< #define StrMEDAdmissionFREE10 $$GetPropertyName^COMConst("MEDAdmission",30)
  public static Object $$$StrMEDAdmissionFREE10(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDAdmission",30));
  }

  //<< #define FldMEDAdmissionAdmissionID 1
  public static Object $$$FldMEDAdmissionAdmissionID(mContext m$) {
    return (1);
  }

  //<< #define StrMEDAdmissionAdmissionID $$GetPropertyName^COMConst("MEDAdmission",,1)
  public static Object $$$StrMEDAdmissionAdmissionID(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDAdmission",null,1));
  }

  //<< 
  //<< #define MEDAuthorizePatient(%obj) $piece(%obj,"~",1)
  public static Object $$$MEDAuthorizePatient(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",1));
  }

  public static void $$$MEDAuthorizePatientSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",1).set(_setval.get());
  }

  //<< #define FldMEDAuthorizePatient 1
  public static Object $$$FldMEDAuthorizePatient(mContext m$) {
    return (1);
  }

  //<< #define StrMEDAuthorizePatient $$GetPropertyName^COMConst("MEDAuthorize",1)
  public static Object $$$StrMEDAuthorizePatient(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDAuthorize",1));
  }

  //<< #define MEDAuthorizeName(%obj) $piece(%obj,"~",2)
  public static Object $$$MEDAuthorizeName(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",2));
  }

  public static void $$$MEDAuthorizeNameSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",2).set(_setval.get());
  }

  //<< #define FldMEDAuthorizeName 2
  public static Object $$$FldMEDAuthorizeName(mContext m$) {
    return (2);
  }

  //<< #define StrMEDAuthorizeName $$GetPropertyName^COMConst("MEDAuthorize",2)
  public static Object $$$StrMEDAuthorizeName(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDAuthorize",2));
  }

  //<< #define MEDAuthorizeSSN(%obj) $piece(%obj,"~",3)
  public static Object $$$MEDAuthorizeSSN(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",3));
  }

  public static void $$$MEDAuthorizeSSNSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",3).set(_setval.get());
  }

  //<< #define FldMEDAuthorizeSSN 3
  public static Object $$$FldMEDAuthorizeSSN(mContext m$) {
    return (3);
  }

  //<< #define StrMEDAuthorizeSSN $$GetPropertyName^COMConst("MEDAuthorize",3)
  public static Object $$$StrMEDAuthorizeSSN(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDAuthorize",3));
  }

  //<< #define MEDAuthorizeGender(%obj) $piece(%obj,"~",4)
  public static Object $$$MEDAuthorizeGender(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",4));
  }

  public static void $$$MEDAuthorizeGenderSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",4).set(_setval.get());
  }

  //<< #define FldMEDAuthorizeGender 4
  public static Object $$$FldMEDAuthorizeGender(mContext m$) {
    return (4);
  }

  //<< #define StrMEDAuthorizeGender $$GetPropertyName^COMConst("MEDAuthorize",4)
  public static Object $$$StrMEDAuthorizeGender(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDAuthorize",4));
  }

  //<< #define MEDAuthorizeRelation(%obj) $piece(%obj,"~",5)
  public static Object $$$MEDAuthorizeRelation(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",5));
  }

  public static void $$$MEDAuthorizeRelationSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",5).set(_setval.get());
  }

  //<< #define FldMEDAuthorizeRelation 5
  public static Object $$$FldMEDAuthorizeRelation(mContext m$) {
    return (5);
  }

  //<< #define StrMEDAuthorizeRelation $$GetPropertyName^COMConst("MEDAuthorize",5)
  public static Object $$$StrMEDAuthorizeRelation(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDAuthorize",5));
  }

  //<< #define MEDAuthorizeTel(%obj) $piece(%obj,"~",6)
  public static Object $$$MEDAuthorizeTel(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",6));
  }

  public static void $$$MEDAuthorizeTelSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",6).set(_setval.get());
  }

  //<< #define FldMEDAuthorizeTel 6
  public static Object $$$FldMEDAuthorizeTel(mContext m$) {
    return (6);
  }

  //<< #define StrMEDAuthorizeTel $$GetPropertyName^COMConst("MEDAuthorize",6)
  public static Object $$$StrMEDAuthorizeTel(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDAuthorize",6));
  }

  //<< #define MEDAuthorizeTel2(%obj) $piece(%obj,"~",7)
  public static Object $$$MEDAuthorizeTel2(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",7));
  }

  public static void $$$MEDAuthorizeTel2Set(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",7).set(_setval.get());
  }

  //<< #define FldMEDAuthorizeTel2 7
  public static Object $$$FldMEDAuthorizeTel2(mContext m$) {
    return (7);
  }

  //<< #define StrMEDAuthorizeTel2 $$GetPropertyName^COMConst("MEDAuthorize",7)
  public static Object $$$StrMEDAuthorizeTel2(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDAuthorize",7));
  }

  //<< #define MEDAuthorizeCreatedBy(%obj) $piece(%obj,"~",8)
  public static Object $$$MEDAuthorizeCreatedBy(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",8));
  }

  public static void $$$MEDAuthorizeCreatedBySet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",8).set(_setval.get());
  }

  //<< #define FldMEDAuthorizeCreatedBy 8
  public static Object $$$FldMEDAuthorizeCreatedBy(mContext m$) {
    return (8);
  }

  //<< #define StrMEDAuthorizeCreatedBy $$GetPropertyName^COMConst("MEDAuthorize",8)
  public static Object $$$StrMEDAuthorizeCreatedBy(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDAuthorize",8));
  }

  //<< #define MEDAuthorizeCreatedDate(%obj) $piece(%obj,"~",9)
  public static Object $$$MEDAuthorizeCreatedDate(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",9));
  }

  public static void $$$MEDAuthorizeCreatedDateSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",9).set(_setval.get());
  }

  //<< #define FldMEDAuthorizeCreatedDate 9
  public static Object $$$FldMEDAuthorizeCreatedDate(mContext m$) {
    return (9);
  }

  //<< #define StrMEDAuthorizeCreatedDate $$GetPropertyName^COMConst("MEDAuthorize",9)
  public static Object $$$StrMEDAuthorizeCreatedDate(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDAuthorize",9));
  }

  //<< #define MEDAuthorizeChangedBy(%obj) $piece(%obj,"~",10)
  public static Object $$$MEDAuthorizeChangedBy(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",10));
  }

  public static void $$$MEDAuthorizeChangedBySet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",10).set(_setval.get());
  }

  //<< #define FldMEDAuthorizeChangedBy 10
  public static Object $$$FldMEDAuthorizeChangedBy(mContext m$) {
    return (10);
  }

  //<< #define StrMEDAuthorizeChangedBy $$GetPropertyName^COMConst("MEDAuthorize",10)
  public static Object $$$StrMEDAuthorizeChangedBy(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDAuthorize",10));
  }

  //<< #define MEDAuthorizeChangedDate(%obj) $piece(%obj,"~",11)
  public static Object $$$MEDAuthorizeChangedDate(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",11));
  }

  public static void $$$MEDAuthorizeChangedDateSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",11).set(_setval.get());
  }

  //<< #define FldMEDAuthorizeChangedDate 11
  public static Object $$$FldMEDAuthorizeChangedDate(mContext m$) {
    return (11);
  }

  //<< #define StrMEDAuthorizeChangedDate $$GetPropertyName^COMConst("MEDAuthorize",11)
  public static Object $$$StrMEDAuthorizeChangedDate(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDAuthorize",11));
  }

  //<< #define MEDAuthorizeFREE1(%obj) $piece(%obj,"~",21)
  public static Object $$$MEDAuthorizeFREE1(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",21));
  }

  public static void $$$MEDAuthorizeFREE1Set(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",21).set(_setval.get());
  }

  //<< #define FldMEDAuthorizeFREE1 21
  public static Object $$$FldMEDAuthorizeFREE1(mContext m$) {
    return (21);
  }

  //<< #define StrMEDAuthorizeFREE1 $$GetPropertyName^COMConst("MEDAuthorize",21)
  public static Object $$$StrMEDAuthorizeFREE1(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDAuthorize",21));
  }

  //<< #define MEDAuthorizeFREE2(%obj) $piece(%obj,"~",22)
  public static Object $$$MEDAuthorizeFREE2(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",22));
  }

  public static void $$$MEDAuthorizeFREE2Set(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",22).set(_setval.get());
  }

  //<< #define FldMEDAuthorizeFREE2 22
  public static Object $$$FldMEDAuthorizeFREE2(mContext m$) {
    return (22);
  }

  //<< #define StrMEDAuthorizeFREE2 $$GetPropertyName^COMConst("MEDAuthorize",22)
  public static Object $$$StrMEDAuthorizeFREE2(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDAuthorize",22));
  }

  //<< #define MEDAuthorizeFREE3(%obj) $piece(%obj,"~",23)
  public static Object $$$MEDAuthorizeFREE3(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",23));
  }

  public static void $$$MEDAuthorizeFREE3Set(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",23).set(_setval.get());
  }

  //<< #define FldMEDAuthorizeFREE3 23
  public static Object $$$FldMEDAuthorizeFREE3(mContext m$) {
    return (23);
  }

  //<< #define StrMEDAuthorizeFREE3 $$GetPropertyName^COMConst("MEDAuthorize",23)
  public static Object $$$StrMEDAuthorizeFREE3(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDAuthorize",23));
  }

  //<< #define MEDAuthorizeFREE4(%obj) $piece(%obj,"~",24)
  public static Object $$$MEDAuthorizeFREE4(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",24));
  }

  public static void $$$MEDAuthorizeFREE4Set(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",24).set(_setval.get());
  }

  //<< #define FldMEDAuthorizeFREE4 24
  public static Object $$$FldMEDAuthorizeFREE4(mContext m$) {
    return (24);
  }

  //<< #define StrMEDAuthorizeFREE4 $$GetPropertyName^COMConst("MEDAuthorize",24)
  public static Object $$$StrMEDAuthorizeFREE4(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDAuthorize",24));
  }

  //<< #define MEDAuthorizeFREE5(%obj) $piece(%obj,"~",25)
  public static Object $$$MEDAuthorizeFREE5(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",25));
  }

  public static void $$$MEDAuthorizeFREE5Set(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",25).set(_setval.get());
  }

  //<< #define FldMEDAuthorizeFREE5 25
  public static Object $$$FldMEDAuthorizeFREE5(mContext m$) {
    return (25);
  }

  //<< #define StrMEDAuthorizeFREE5 $$GetPropertyName^COMConst("MEDAuthorize",25)
  public static Object $$$StrMEDAuthorizeFREE5(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDAuthorize",25));
  }

  //<< #define MEDAuthorizeFREE6(%obj) $piece(%obj,"~",26)
  public static Object $$$MEDAuthorizeFREE6(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",26));
  }

  public static void $$$MEDAuthorizeFREE6Set(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",26).set(_setval.get());
  }

  //<< #define FldMEDAuthorizeFREE6 26
  public static Object $$$FldMEDAuthorizeFREE6(mContext m$) {
    return (26);
  }

  //<< #define StrMEDAuthorizeFREE6 $$GetPropertyName^COMConst("MEDAuthorize",26)
  public static Object $$$StrMEDAuthorizeFREE6(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDAuthorize",26));
  }

  //<< #define MEDAuthorizeFREE7(%obj) $piece(%obj,"~",27)
  public static Object $$$MEDAuthorizeFREE7(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",27));
  }

  public static void $$$MEDAuthorizeFREE7Set(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",27).set(_setval.get());
  }

  //<< #define FldMEDAuthorizeFREE7 27
  public static Object $$$FldMEDAuthorizeFREE7(mContext m$) {
    return (27);
  }

  //<< #define StrMEDAuthorizeFREE7 $$GetPropertyName^COMConst("MEDAuthorize",27)
  public static Object $$$StrMEDAuthorizeFREE7(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDAuthorize",27));
  }

  //<< #define MEDAuthorizeFREE8(%obj) $piece(%obj,"~",28)
  public static Object $$$MEDAuthorizeFREE8(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",28));
  }

  public static void $$$MEDAuthorizeFREE8Set(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",28).set(_setval.get());
  }

  //<< #define FldMEDAuthorizeFREE8 28
  public static Object $$$FldMEDAuthorizeFREE8(mContext m$) {
    return (28);
  }

  //<< #define StrMEDAuthorizeFREE8 $$GetPropertyName^COMConst("MEDAuthorize",28)
  public static Object $$$StrMEDAuthorizeFREE8(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDAuthorize",28));
  }

  //<< #define MEDAuthorizeFREE9(%obj) $piece(%obj,"~",29)
  public static Object $$$MEDAuthorizeFREE9(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",29));
  }

  public static void $$$MEDAuthorizeFREE9Set(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",29).set(_setval.get());
  }

  //<< #define FldMEDAuthorizeFREE9 29
  public static Object $$$FldMEDAuthorizeFREE9(mContext m$) {
    return (29);
  }

  //<< #define StrMEDAuthorizeFREE9 $$GetPropertyName^COMConst("MEDAuthorize",29)
  public static Object $$$StrMEDAuthorizeFREE9(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDAuthorize",29));
  }

  //<< #define MEDAuthorizeFREE10(%obj) $piece(%obj,"~",30)
  public static Object $$$MEDAuthorizeFREE10(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",30));
  }

  public static void $$$MEDAuthorizeFREE10Set(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",30).set(_setval.get());
  }

  //<< #define FldMEDAuthorizeFREE10 30
  public static Object $$$FldMEDAuthorizeFREE10(mContext m$) {
    return (30);
  }

  //<< #define StrMEDAuthorizeFREE10 $$GetPropertyName^COMConst("MEDAuthorize",30)
  public static Object $$$StrMEDAuthorizeFREE10(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDAuthorize",30));
  }

  //<< #define FldMEDAuthorizeAuthorizationID 1
  public static Object $$$FldMEDAuthorizeAuthorizationID(mContext m$) {
    return (1);
  }

  //<< #define StrMEDAuthorizeAuthorizationID $$GetPropertyName^COMConst("MEDAuthorize",,1)
  public static Object $$$StrMEDAuthorizeAuthorizationID(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDAuthorize",null,1));
  }

  //<< 
  //<< #define MEDDispenseStatus(%obj) $piece(%obj,"~",1)
  public static Object $$$MEDDispenseStatus(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",1));
  }

  public static void $$$MEDDispenseStatusSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",1).set(_setval.get());
  }

  //<< #define FldMEDDispenseStatus 1
  public static Object $$$FldMEDDispenseStatus(mContext m$) {
    return (1);
  }

  //<< #define StrMEDDispenseStatus $$GetPropertyName^COMConst("MEDDispense",1)
  public static Object $$$StrMEDDispenseStatus(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDDispense",1));
  }

  //<< #define MEDDispenseDateProcessed(%obj) $piece(%obj,"~",2)
  public static Object $$$MEDDispenseDateProcessed(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",2));
  }

  public static void $$$MEDDispenseDateProcessedSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",2).set(_setval.get());
  }

  //<< #define FldMEDDispenseDateProcessed 2
  public static Object $$$FldMEDDispenseDateProcessed(mContext m$) {
    return (2);
  }

  //<< #define StrMEDDispenseDateProcessed $$GetPropertyName^COMConst("MEDDispense",2)
  public static Object $$$StrMEDDispenseDateProcessed(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDDispense",2));
  }

  //<< #define MEDDispensePrescription(%obj) $piece(%obj,"~",3)
  public static Object $$$MEDDispensePrescription(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",3));
  }

  public static void $$$MEDDispensePrescriptionSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",3).set(_setval.get());
  }

  //<< #define FldMEDDispensePrescription 3
  public static Object $$$FldMEDDispensePrescription(mContext m$) {
    return (3);
  }

  //<< #define StrMEDDispensePrescription $$GetPropertyName^COMConst("MEDDispense",3)
  public static Object $$$StrMEDDispensePrescription(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDDispense",3));
  }

  //<< #define MEDDispensePrescriber(%obj) $piece(%obj,"~",4)
  public static Object $$$MEDDispensePrescriber(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",4));
  }

  public static void $$$MEDDispensePrescriberSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",4).set(_setval.get());
  }

  //<< #define FldMEDDispensePrescriber 4
  public static Object $$$FldMEDDispensePrescriber(mContext m$) {
    return (4);
  }

  //<< #define StrMEDDispensePrescriber $$GetPropertyName^COMConst("MEDDispense",4)
  public static Object $$$StrMEDDispensePrescriber(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDDispense",4));
  }

  //<< #define MEDDispenseSupplyingLocation(%obj) $piece(%obj,"~",5)
  public static Object $$$MEDDispenseSupplyingLocation(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",5));
  }

  public static void $$$MEDDispenseSupplyingLocationSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",5).set(_setval.get());
  }

  //<< #define FldMEDDispenseSupplyingLocation 5
  public static Object $$$FldMEDDispenseSupplyingLocation(mContext m$) {
    return (5);
  }

  //<< #define StrMEDDispenseSupplyingLocation $$GetPropertyName^COMConst("MEDDispense",5)
  public static Object $$$StrMEDDispenseSupplyingLocation(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDDispense",5));
  }

  //<< #define MEDDispenseDestinationLocation(%obj) $piece(%obj,"~",6)
  public static Object $$$MEDDispenseDestinationLocation(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",6));
  }

  public static void $$$MEDDispenseDestinationLocationSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",6).set(_setval.get());
  }

  //<< #define FldMEDDispenseDestinationLocation 6
  public static Object $$$FldMEDDispenseDestinationLocation(mContext m$) {
    return (6);
  }

  //<< #define StrMEDDispenseDestinationLocation $$GetPropertyName^COMConst("MEDDispense",6)
  public static Object $$$StrMEDDispenseDestinationLocation(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDDispense",6));
  }

  //<< #define MEDDispenseIssueType(%obj) $piece(%obj,"~",7)
  public static Object $$$MEDDispenseIssueType(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",7));
  }

  public static void $$$MEDDispenseIssueTypeSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",7).set(_setval.get());
  }

  //<< #define FldMEDDispenseIssueType 7
  public static Object $$$FldMEDDispenseIssueType(mContext m$) {
    return (7);
  }

  //<< #define StrMEDDispenseIssueType $$GetPropertyName^COMConst("MEDDispense",7)
  public static Object $$$StrMEDDispenseIssueType(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDDispense",7));
  }

  //<< #define MEDDispenseRemarks(%obj) $piece(%obj,"~",8)
  public static Object $$$MEDDispenseRemarks(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",8));
  }

  public static void $$$MEDDispenseRemarksSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",8).set(_setval.get());
  }

  //<< #define FldMEDDispenseRemarks 8
  public static Object $$$FldMEDDispenseRemarks(mContext m$) {
    return (8);
  }

  //<< #define StrMEDDispenseRemarks $$GetPropertyName^COMConst("MEDDispense",8)
  public static Object $$$StrMEDDispenseRemarks(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDDispense",8));
  }

  //<< #define MEDDispenseIssue(%obj) $piece(%obj,"~",9)
  public static Object $$$MEDDispenseIssue(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",9));
  }

  public static void $$$MEDDispenseIssueSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",9).set(_setval.get());
  }

  //<< #define FldMEDDispenseIssue 9
  public static Object $$$FldMEDDispenseIssue(mContext m$) {
    return (9);
  }

  //<< #define StrMEDDispenseIssue $$GetPropertyName^COMConst("MEDDispense",9)
  public static Object $$$StrMEDDispenseIssue(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDDispense",9));
  }

  //<< #define MEDDispenseCreatedDate(%obj) $piece(%obj,"~",10)
  public static Object $$$MEDDispenseCreatedDate(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",10));
  }

  public static void $$$MEDDispenseCreatedDateSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",10).set(_setval.get());
  }

  //<< #define FldMEDDispenseCreatedDate 10
  public static Object $$$FldMEDDispenseCreatedDate(mContext m$) {
    return (10);
  }

  //<< #define StrMEDDispenseCreatedDate $$GetPropertyName^COMConst("MEDDispense",10)
  public static Object $$$StrMEDDispenseCreatedDate(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDDispense",10));
  }

  //<< #define MEDDispenseCreatedBy(%obj) $piece(%obj,"~",11)
  public static Object $$$MEDDispenseCreatedBy(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",11));
  }

  public static void $$$MEDDispenseCreatedBySet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",11).set(_setval.get());
  }

  //<< #define FldMEDDispenseCreatedBy 11
  public static Object $$$FldMEDDispenseCreatedBy(mContext m$) {
    return (11);
  }

  //<< #define StrMEDDispenseCreatedBy $$GetPropertyName^COMConst("MEDDispense",11)
  public static Object $$$StrMEDDispenseCreatedBy(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDDispense",11));
  }

  //<< #define MEDDispenseModifiedDate(%obj) $piece(%obj,"~",12)
  public static Object $$$MEDDispenseModifiedDate(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",12));
  }

  public static void $$$MEDDispenseModifiedDateSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",12).set(_setval.get());
  }

  //<< #define FldMEDDispenseModifiedDate 12
  public static Object $$$FldMEDDispenseModifiedDate(mContext m$) {
    return (12);
  }

  //<< #define StrMEDDispenseModifiedDate $$GetPropertyName^COMConst("MEDDispense",12)
  public static Object $$$StrMEDDispenseModifiedDate(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDDispense",12));
  }

  //<< #define MEDDispenseModifiedBy(%obj) $piece(%obj,"~",13)
  public static Object $$$MEDDispenseModifiedBy(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",13));
  }

  public static void $$$MEDDispenseModifiedBySet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",13).set(_setval.get());
  }

  //<< #define FldMEDDispenseModifiedBy 13
  public static Object $$$FldMEDDispenseModifiedBy(mContext m$) {
    return (13);
  }

  //<< #define StrMEDDispenseModifiedBy $$GetPropertyName^COMConst("MEDDispense",13)
  public static Object $$$StrMEDDispenseModifiedBy(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDDispense",13));
  }

  //<< #define MEDDispensePickListPrinted(%obj) $piece(%obj,"~",14)
  public static Object $$$MEDDispensePickListPrinted(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",14));
  }

  public static void $$$MEDDispensePickListPrintedSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",14).set(_setval.get());
  }

  //<< #define FldMEDDispensePickListPrinted 14
  public static Object $$$FldMEDDispensePickListPrinted(mContext m$) {
    return (14);
  }

  //<< #define StrMEDDispensePickListPrinted $$GetPropertyName^COMConst("MEDDispense",14)
  public static Object $$$StrMEDDispensePickListPrinted(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDDispense",14));
  }

  //<< #define MEDDispensePatient(%obj) $piece(%obj,"~",15)
  public static Object $$$MEDDispensePatient(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",15));
  }

  public static void $$$MEDDispensePatientSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",15).set(_setval.get());
  }

  //<< #define FldMEDDispensePatient 15
  public static Object $$$FldMEDDispensePatient(mContext m$) {
    return (15);
  }

  //<< #define StrMEDDispensePatient $$GetPropertyName^COMConst("MEDDispense",15)
  public static Object $$$StrMEDDispensePatient(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDDispense",15));
  }

  //<< #define FldMEDDispenseDispensation 1
  public static Object $$$FldMEDDispenseDispensation(mContext m$) {
    return (1);
  }

  //<< #define StrMEDDispenseDispensation $$GetPropertyName^COMConst("MEDDispense",,1)
  public static Object $$$StrMEDDispenseDispensation(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDDispense",null,1));
  }

  //<< 
  //<< #define FldMEDDispenseIssueCompany1 1
  public static Object $$$FldMEDDispenseIssueCompany1(mContext m$) {
    return (1);
  }

  //<< #define StrMEDDispenseIssueCompany1 $$GetPropertyName^COMConst("MEDDispenseIssue",,1)
  public static Object $$$StrMEDDispenseIssueCompany1(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDDispenseIssue",null,1));
  }

  //<< 
  //<< #define MEDDispenseLineItemName(%obj) $piece(%obj,"~",1)
  public static Object $$$MEDDispenseLineItemName(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",1));
  }

  public static void $$$MEDDispenseLineItemNameSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",1).set(_setval.get());
  }

  //<< #define FldMEDDispenseLineItemName 1
  public static Object $$$FldMEDDispenseLineItemName(mContext m$) {
    return (1);
  }

  //<< #define StrMEDDispenseLineItemName $$GetPropertyName^COMConst("MEDDispenseLine",1)
  public static Object $$$StrMEDDispenseLineItemName(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDDispenseLine",1));
  }

  //<< #define MEDDispenseLineDoseQuantity(%obj) $piece(%obj,"~",2)
  public static Object $$$MEDDispenseLineDoseQuantity(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",2));
  }

  public static void $$$MEDDispenseLineDoseQuantitySet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",2).set(_setval.get());
  }

  //<< #define FldMEDDispenseLineDoseQuantity 2
  public static Object $$$FldMEDDispenseLineDoseQuantity(mContext m$) {
    return (2);
  }

  //<< #define StrMEDDispenseLineDoseQuantity $$GetPropertyName^COMConst("MEDDispenseLine",2)
  public static Object $$$StrMEDDispenseLineDoseQuantity(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDDispenseLine",2));
  }

  //<< #define MEDDispenseLineDoseUOM(%obj) $piece(%obj,"~",3)
  public static Object $$$MEDDispenseLineDoseUOM(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",3));
  }

  public static void $$$MEDDispenseLineDoseUOMSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",3).set(_setval.get());
  }

  //<< #define FldMEDDispenseLineDoseUOM 3
  public static Object $$$FldMEDDispenseLineDoseUOM(mContext m$) {
    return (3);
  }

  //<< #define StrMEDDispenseLineDoseUOM $$GetPropertyName^COMConst("MEDDispenseLine",3)
  public static Object $$$StrMEDDispenseLineDoseUOM(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDDispenseLine",3));
  }

  //<< #define MEDDispenseLineRoute(%obj) $piece(%obj,"~",4)
  public static Object $$$MEDDispenseLineRoute(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",4));
  }

  public static void $$$MEDDispenseLineRouteSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",4).set(_setval.get());
  }

  //<< #define FldMEDDispenseLineRoute 4
  public static Object $$$FldMEDDispenseLineRoute(mContext m$) {
    return (4);
  }

  //<< #define StrMEDDispenseLineRoute $$GetPropertyName^COMConst("MEDDispenseLine",4)
  public static Object $$$StrMEDDispenseLineRoute(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDDispenseLine",4));
  }

  //<< #define MEDDispenseLineFrequency(%obj) $piece(%obj,"~",5)
  public static Object $$$MEDDispenseLineFrequency(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",5));
  }

  public static void $$$MEDDispenseLineFrequencySet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",5).set(_setval.get());
  }

  //<< #define FldMEDDispenseLineFrequency 5
  public static Object $$$FldMEDDispenseLineFrequency(mContext m$) {
    return (5);
  }

  //<< #define StrMEDDispenseLineFrequency $$GetPropertyName^COMConst("MEDDispenseLine",5)
  public static Object $$$StrMEDDispenseLineFrequency(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDDispenseLine",5));
  }

  //<< #define MEDDispenseLineFromDate(%obj) $piece(%obj,"~",6)
  public static Object $$$MEDDispenseLineFromDate(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",6));
  }

  public static void $$$MEDDispenseLineFromDateSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",6).set(_setval.get());
  }

  //<< #define FldMEDDispenseLineFromDate 6
  public static Object $$$FldMEDDispenseLineFromDate(mContext m$) {
    return (6);
  }

  //<< #define StrMEDDispenseLineFromDate $$GetPropertyName^COMConst("MEDDispenseLine",6)
  public static Object $$$StrMEDDispenseLineFromDate(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDDispenseLine",6));
  }

  //<< #define MEDDispenseLineFromTime(%obj) $piece(%obj,"~",7)
  public static Object $$$MEDDispenseLineFromTime(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",7));
  }

  public static void $$$MEDDispenseLineFromTimeSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",7).set(_setval.get());
  }

  //<< #define FldMEDDispenseLineFromTime 7
  public static Object $$$FldMEDDispenseLineFromTime(mContext m$) {
    return (7);
  }

  //<< #define StrMEDDispenseLineFromTime $$GetPropertyName^COMConst("MEDDispenseLine",7)
  public static Object $$$StrMEDDispenseLineFromTime(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDDispenseLine",7));
  }

  //<< #define MEDDispenseLineToDate(%obj) $piece(%obj,"~",8)
  public static Object $$$MEDDispenseLineToDate(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",8));
  }

  public static void $$$MEDDispenseLineToDateSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",8).set(_setval.get());
  }

  //<< #define FldMEDDispenseLineToDate 8
  public static Object $$$FldMEDDispenseLineToDate(mContext m$) {
    return (8);
  }

  //<< #define StrMEDDispenseLineToDate $$GetPropertyName^COMConst("MEDDispenseLine",8)
  public static Object $$$StrMEDDispenseLineToDate(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDDispenseLine",8));
  }

  //<< #define MEDDispenseLineToTime(%obj) $piece(%obj,"~",9)
  public static Object $$$MEDDispenseLineToTime(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",9));
  }

  public static void $$$MEDDispenseLineToTimeSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",9).set(_setval.get());
  }

  //<< #define FldMEDDispenseLineToTime 9
  public static Object $$$FldMEDDispenseLineToTime(mContext m$) {
    return (9);
  }

  //<< #define StrMEDDispenseLineToTime $$GetPropertyName^COMConst("MEDDispenseLine",9)
  public static Object $$$StrMEDDispenseLineToTime(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDDispenseLine",9));
  }

  //<< #define MEDDispenseLineRemarks(%obj) $piece(%obj,"~",10)
  public static Object $$$MEDDispenseLineRemarks(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",10));
  }

  public static void $$$MEDDispenseLineRemarksSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",10).set(_setval.get());
  }

  //<< #define FldMEDDispenseLineRemarks 10
  public static Object $$$FldMEDDispenseLineRemarks(mContext m$) {
    return (10);
  }

  //<< #define StrMEDDispenseLineRemarks $$GetPropertyName^COMConst("MEDDispenseLine",10)
  public static Object $$$StrMEDDispenseLineRemarks(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDDispenseLine",10));
  }

  //<< #define MEDDispenseLineIssueQuantity(%obj) $piece(%obj,"~",11)
  public static Object $$$MEDDispenseLineIssueQuantity(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",11));
  }

  public static void $$$MEDDispenseLineIssueQuantitySet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",11).set(_setval.get());
  }

  //<< #define FldMEDDispenseLineIssueQuantity 11
  public static Object $$$FldMEDDispenseLineIssueQuantity(mContext m$) {
    return (11);
  }

  //<< #define StrMEDDispenseLineIssueQuantity $$GetPropertyName^COMConst("MEDDispenseLine",11)
  public static Object $$$StrMEDDispenseLineIssueQuantity(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDDispenseLine",11));
  }

  //<< #define MEDDispenseLineIssueUOM(%obj) $piece(%obj,"~",12)
  public static Object $$$MEDDispenseLineIssueUOM(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",12));
  }

  public static void $$$MEDDispenseLineIssueUOMSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",12).set(_setval.get());
  }

  //<< #define FldMEDDispenseLineIssueUOM 12
  public static Object $$$FldMEDDispenseLineIssueUOM(mContext m$) {
    return (12);
  }

  //<< #define StrMEDDispenseLineIssueUOM $$GetPropertyName^COMConst("MEDDispenseLine",12)
  public static Object $$$StrMEDDispenseLineIssueUOM(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDDispenseLine",12));
  }

  //<< #define MEDDispenseLineDiluent(%obj) $piece(%obj,"~",13)
  public static Object $$$MEDDispenseLineDiluent(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",13));
  }

  public static void $$$MEDDispenseLineDiluentSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",13).set(_setval.get());
  }

  //<< #define FldMEDDispenseLineDiluent 13
  public static Object $$$FldMEDDispenseLineDiluent(mContext m$) {
    return (13);
  }

  //<< #define StrMEDDispenseLineDiluent $$GetPropertyName^COMConst("MEDDispenseLine",13)
  public static Object $$$StrMEDDispenseLineDiluent(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDDispenseLine",13));
  }

  //<< #define MEDDispenseLineDiluentQty(%obj) $piece(%obj,"~",14)
  public static Object $$$MEDDispenseLineDiluentQty(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",14));
  }

  public static void $$$MEDDispenseLineDiluentQtySet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",14).set(_setval.get());
  }

  //<< #define FldMEDDispenseLineDiluentQty 14
  public static Object $$$FldMEDDispenseLineDiluentQty(mContext m$) {
    return (14);
  }

  //<< #define StrMEDDispenseLineDiluentQty $$GetPropertyName^COMConst("MEDDispenseLine",14)
  public static Object $$$StrMEDDispenseLineDiluentQty(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDDispenseLine",14));
  }

  //<< #define MEDDispenseLineDiluentUOM(%obj) $piece(%obj,"~",15)
  public static Object $$$MEDDispenseLineDiluentUOM(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",15));
  }

  public static void $$$MEDDispenseLineDiluentUOMSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",15).set(_setval.get());
  }

  //<< #define FldMEDDispenseLineDiluentUOM 15
  public static Object $$$FldMEDDispenseLineDiluentUOM(mContext m$) {
    return (15);
  }

  //<< #define StrMEDDispenseLineDiluentUOM $$GetPropertyName^COMConst("MEDDispenseLine",15)
  public static Object $$$StrMEDDispenseLineDiluentUOM(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDDispenseLine",15));
  }

  //<< #define MEDDispenseLineUDO(%obj) $piece(%obj,"~",16)
  public static Object $$$MEDDispenseLineUDO(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",16));
  }

  public static void $$$MEDDispenseLineUDOSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",16).set(_setval.get());
  }

  //<< #define FldMEDDispenseLineUDO 16
  public static Object $$$FldMEDDispenseLineUDO(mContext m$) {
    return (16);
  }

  //<< #define StrMEDDispenseLineUDO $$GetPropertyName^COMConst("MEDDispenseLine",16)
  public static Object $$$StrMEDDispenseLineUDO(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDDispenseLine",16));
  }

  //<< #define MEDDispenseLineValidation(%obj) $piece(%obj,"~",17)
  public static Object $$$MEDDispenseLineValidation(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",17));
  }

  public static void $$$MEDDispenseLineValidationSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",17).set(_setval.get());
  }

  //<< #define FldMEDDispenseLineValidation 17
  public static Object $$$FldMEDDispenseLineValidation(mContext m$) {
    return (17);
  }

  //<< #define StrMEDDispenseLineValidation $$GetPropertyName^COMConst("MEDDispenseLine",17)
  public static Object $$$StrMEDDispenseLineValidation(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDDispenseLine",17));
  }

  //<< #define MEDDispenseLineValidatedBy(%obj) $piece(%obj,"~",18)
  public static Object $$$MEDDispenseLineValidatedBy(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",18));
  }

  public static void $$$MEDDispenseLineValidatedBySet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",18).set(_setval.get());
  }

  //<< #define FldMEDDispenseLineValidatedBy 18
  public static Object $$$FldMEDDispenseLineValidatedBy(mContext m$) {
    return (18);
  }

  //<< #define StrMEDDispenseLineValidatedBy $$GetPropertyName^COMConst("MEDDispenseLine",18)
  public static Object $$$StrMEDDispenseLineValidatedBy(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDDispenseLine",18));
  }

  //<< #define MEDDispenseLineValidatedStatus(%obj) $piece(%obj,"~",19)
  public static Object $$$MEDDispenseLineValidatedStatus(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",19));
  }

  public static void $$$MEDDispenseLineValidatedStatusSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",19).set(_setval.get());
  }

  //<< #define FldMEDDispenseLineValidatedStatus 19
  public static Object $$$FldMEDDispenseLineValidatedStatus(mContext m$) {
    return (19);
  }

  //<< #define StrMEDDispenseLineValidatedStatus $$GetPropertyName^COMConst("MEDDispenseLine",19)
  public static Object $$$StrMEDDispenseLineValidatedStatus(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDDispenseLine",19));
  }

  //<< #define MEDDispenseLineRejectReason(%obj) $piece(%obj,"~",20)
  public static Object $$$MEDDispenseLineRejectReason(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",20));
  }

  public static void $$$MEDDispenseLineRejectReasonSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",20).set(_setval.get());
  }

  //<< #define FldMEDDispenseLineRejectReason 20
  public static Object $$$FldMEDDispenseLineRejectReason(mContext m$) {
    return (20);
  }

  //<< #define StrMEDDispenseLineRejectReason $$GetPropertyName^COMConst("MEDDispenseLine",20)
  public static Object $$$StrMEDDispenseLineRejectReason(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDDispenseLine",20));
  }

  //<< #define MEDDispenseLineRejectNoted(%obj) $piece(%obj,"~",21)
  public static Object $$$MEDDispenseLineRejectNoted(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",21));
  }

  public static void $$$MEDDispenseLineRejectNotedSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",21).set(_setval.get());
  }

  //<< #define FldMEDDispenseLineRejectNoted 21
  public static Object $$$FldMEDDispenseLineRejectNoted(mContext m$) {
    return (21);
  }

  //<< #define StrMEDDispenseLineRejectNoted $$GetPropertyName^COMConst("MEDDispenseLine",21)
  public static Object $$$StrMEDDispenseLineRejectNoted(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDDispenseLine",21));
  }

  //<< #define MEDDispenseLineTotalRequestedQuantity(%obj) $piece(%obj,"~",22)
  public static Object $$$MEDDispenseLineTotalRequestedQuantity(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",22));
  }

  public static void $$$MEDDispenseLineTotalRequestedQuantitySet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",22).set(_setval.get());
  }

  //<< #define FldMEDDispenseLineTotalRequestedQuantity 22
  public static Object $$$FldMEDDispenseLineTotalRequestedQuantity(mContext m$) {
    return (22);
  }

  //<< #define StrMEDDispenseLineTotalRequestedQuantity $$GetPropertyName^COMConst("MEDDispenseLine",22)
  public static Object $$$StrMEDDispenseLineTotalRequestedQuantity(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDDispenseLine",22));
  }

  //<< #define MEDDispenseLineLastSuspendPresDisp(%obj) $piece(%obj,"~",23)
  public static Object $$$MEDDispenseLineLastSuspendPresDisp(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",23));
  }

  public static void $$$MEDDispenseLineLastSuspendPresDispSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",23).set(_setval.get());
  }

  //<< #define FldMEDDispenseLineLastSuspendPresDisp 23
  public static Object $$$FldMEDDispenseLineLastSuspendPresDisp(mContext m$) {
    return (23);
  }

  //<< #define StrMEDDispenseLineLastSuspendPresDisp $$GetPropertyName^COMConst("MEDDispenseLine",23)
  public static Object $$$StrMEDDispenseLineLastSuspendPresDisp(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDDispenseLine",23));
  }

  //<< #define MEDDispenseLineValidatedOn(%obj) $piece(%obj,"~",24)
  public static Object $$$MEDDispenseLineValidatedOn(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",24));
  }

  public static void $$$MEDDispenseLineValidatedOnSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",24).set(_setval.get());
  }

  //<< #define FldMEDDispenseLineValidatedOn 24
  public static Object $$$FldMEDDispenseLineValidatedOn(mContext m$) {
    return (24);
  }

  //<< #define StrMEDDispenseLineValidatedOn $$GetPropertyName^COMConst("MEDDispenseLine",24)
  public static Object $$$StrMEDDispenseLineValidatedOn(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDDispenseLine",24));
  }

  //<< #define MEDDispenseLineDiluentQtyPicked(%obj) $piece(%obj,"~",25)
  public static Object $$$MEDDispenseLineDiluentQtyPicked(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",25));
  }

  public static void $$$MEDDispenseLineDiluentQtyPickedSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",25).set(_setval.get());
  }

  //<< #define FldMEDDispenseLineDiluentQtyPicked 25
  public static Object $$$FldMEDDispenseLineDiluentQtyPicked(mContext m$) {
    return (25);
  }

  //<< #define StrMEDDispenseLineDiluentQtyPicked $$GetPropertyName^COMConst("MEDDispenseLine",25)
  public static Object $$$StrMEDDispenseLineDiluentQtyPicked(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDDispenseLine",25));
  }

  //<< #define MEDDispenseLineUDOInPreviousDispense(%obj) $piece(%obj,"~",26)
  public static Object $$$MEDDispenseLineUDOInPreviousDispense(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",26));
  }

  public static void $$$MEDDispenseLineUDOInPreviousDispenseSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",26).set(_setval.get());
  }

  //<< #define FldMEDDispenseLineUDOInPreviousDispense 26
  public static Object $$$FldMEDDispenseLineUDOInPreviousDispense(mContext m$) {
    return (26);
  }

  //<< #define StrMEDDispenseLineUDOInPreviousDispense $$GetPropertyName^COMConst("MEDDispenseLine",26)
  public static Object $$$StrMEDDispenseLineUDOInPreviousDispense(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDDispenseLine",26));
  }

  //<< #define MEDDispenseLineFREE1(%obj) $piece(%obj,"~",41)
  public static Object $$$MEDDispenseLineFREE1(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",41));
  }

  public static void $$$MEDDispenseLineFREE1Set(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",41).set(_setval.get());
  }

  //<< #define FldMEDDispenseLineFREE1 41
  public static Object $$$FldMEDDispenseLineFREE1(mContext m$) {
    return (41);
  }

  //<< #define StrMEDDispenseLineFREE1 $$GetPropertyName^COMConst("MEDDispenseLine",41)
  public static Object $$$StrMEDDispenseLineFREE1(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDDispenseLine",41));
  }

  //<< #define MEDDispenseLineFREE2(%obj) $piece(%obj,"~",42)
  public static Object $$$MEDDispenseLineFREE2(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",42));
  }

  public static void $$$MEDDispenseLineFREE2Set(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",42).set(_setval.get());
  }

  //<< #define FldMEDDispenseLineFREE2 42
  public static Object $$$FldMEDDispenseLineFREE2(mContext m$) {
    return (42);
  }

  //<< #define StrMEDDispenseLineFREE2 $$GetPropertyName^COMConst("MEDDispenseLine",42)
  public static Object $$$StrMEDDispenseLineFREE2(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDDispenseLine",42));
  }

  //<< #define MEDDispenseLineFREE3(%obj) $piece(%obj,"~",43)
  public static Object $$$MEDDispenseLineFREE3(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",43));
  }

  public static void $$$MEDDispenseLineFREE3Set(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",43).set(_setval.get());
  }

  //<< #define FldMEDDispenseLineFREE3 43
  public static Object $$$FldMEDDispenseLineFREE3(mContext m$) {
    return (43);
  }

  //<< #define StrMEDDispenseLineFREE3 $$GetPropertyName^COMConst("MEDDispenseLine",43)
  public static Object $$$StrMEDDispenseLineFREE3(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDDispenseLine",43));
  }

  //<< #define MEDDispenseLineFREE4(%obj) $piece(%obj,"~",44)
  public static Object $$$MEDDispenseLineFREE4(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",44));
  }

  public static void $$$MEDDispenseLineFREE4Set(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",44).set(_setval.get());
  }

  //<< #define FldMEDDispenseLineFREE4 44
  public static Object $$$FldMEDDispenseLineFREE4(mContext m$) {
    return (44);
  }

  //<< #define StrMEDDispenseLineFREE4 $$GetPropertyName^COMConst("MEDDispenseLine",44)
  public static Object $$$StrMEDDispenseLineFREE4(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDDispenseLine",44));
  }

  //<< #define MEDDispenseLineFREE5(%obj) $piece(%obj,"~",45)
  public static Object $$$MEDDispenseLineFREE5(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",45));
  }

  public static void $$$MEDDispenseLineFREE5Set(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",45).set(_setval.get());
  }

  //<< #define FldMEDDispenseLineFREE5 45
  public static Object $$$FldMEDDispenseLineFREE5(mContext m$) {
    return (45);
  }

  //<< #define StrMEDDispenseLineFREE5 $$GetPropertyName^COMConst("MEDDispenseLine",45)
  public static Object $$$StrMEDDispenseLineFREE5(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDDispenseLine",45));
  }

  //<< #define MEDDispenseLineFREE6(%obj) $piece(%obj,"~",46)
  public static Object $$$MEDDispenseLineFREE6(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",46));
  }

  public static void $$$MEDDispenseLineFREE6Set(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",46).set(_setval.get());
  }

  //<< #define FldMEDDispenseLineFREE6 46
  public static Object $$$FldMEDDispenseLineFREE6(mContext m$) {
    return (46);
  }

  //<< #define StrMEDDispenseLineFREE6 $$GetPropertyName^COMConst("MEDDispenseLine",46)
  public static Object $$$StrMEDDispenseLineFREE6(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDDispenseLine",46));
  }

  //<< #define FldMEDDispenseLineDispense 1
  public static Object $$$FldMEDDispenseLineDispense(mContext m$) {
    return (1);
  }

  //<< #define StrMEDDispenseLineDispense $$GetPropertyName^COMConst("MEDDispenseLine",,1)
  public static Object $$$StrMEDDispenseLineDispense(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDDispenseLine",null,1));
  }

  //<< #define FldMEDDispenseLineLine 2
  public static Object $$$FldMEDDispenseLineLine(mContext m$) {
    return (2);
  }

  //<< #define StrMEDDispenseLineLine $$GetPropertyName^COMConst("MEDDispenseLine",,2)
  public static Object $$$StrMEDDispenseLineLine(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDDispenseLine",null,2));
  }

  //<< 
  //<< #define MEDDispensePickLineItem(%obj) $piece(%obj,"~",1)
  public static Object $$$MEDDispensePickLineItem(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",1));
  }

  public static void $$$MEDDispensePickLineItemSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",1).set(_setval.get());
  }

  //<< #define FldMEDDispensePickLineItem 1
  public static Object $$$FldMEDDispensePickLineItem(mContext m$) {
    return (1);
  }

  //<< #define StrMEDDispensePickLineItem $$GetPropertyName^COMConst("MEDDispensePickLine",1)
  public static Object $$$StrMEDDispensePickLineItem(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDDispensePickLine",1));
  }

  //<< #define MEDDispensePickLineIssueUOM(%obj) $piece(%obj,"~",2)
  public static Object $$$MEDDispensePickLineIssueUOM(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",2));
  }

  public static void $$$MEDDispensePickLineIssueUOMSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",2).set(_setval.get());
  }

  //<< #define FldMEDDispensePickLineIssueUOM 2
  public static Object $$$FldMEDDispensePickLineIssueUOM(mContext m$) {
    return (2);
  }

  //<< #define StrMEDDispensePickLineIssueUOM $$GetPropertyName^COMConst("MEDDispensePickLine",2)
  public static Object $$$StrMEDDispensePickLineIssueUOM(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDDispensePickLine",2));
  }

  //<< #define MEDDispensePickLineRequestedQty(%obj) $piece(%obj,"~",3)
  public static Object $$$MEDDispensePickLineRequestedQty(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",3));
  }

  public static void $$$MEDDispensePickLineRequestedQtySet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",3).set(_setval.get());
  }

  //<< #define FldMEDDispensePickLineRequestedQty 3
  public static Object $$$FldMEDDispensePickLineRequestedQty(mContext m$) {
    return (3);
  }

  //<< #define StrMEDDispensePickLineRequestedQty $$GetPropertyName^COMConst("MEDDispensePickLine",3)
  public static Object $$$StrMEDDispensePickLineRequestedQty(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDDispensePickLine",3));
  }

  //<< #define MEDDispensePickLineIssueQty(%obj) $piece(%obj,"~",4)
  public static Object $$$MEDDispensePickLineIssueQty(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",4));
  }

  public static void $$$MEDDispensePickLineIssueQtySet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",4).set(_setval.get());
  }

  //<< #define FldMEDDispensePickLineIssueQty 4
  public static Object $$$FldMEDDispensePickLineIssueQty(mContext m$) {
    return (4);
  }

  //<< #define StrMEDDispensePickLineIssueQty $$GetPropertyName^COMConst("MEDDispensePickLine",4)
  public static Object $$$StrMEDDispensePickLineIssueQty(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDDispensePickLine",4));
  }

  //<< #define MEDDispensePickLineToStorage(%obj) $piece(%obj,"~",6)
  public static Object $$$MEDDispensePickLineToStorage(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",6));
  }

  public static void $$$MEDDispensePickLineToStorageSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",6).set(_setval.get());
  }

  //<< #define FldMEDDispensePickLineToStorage 6
  public static Object $$$FldMEDDispensePickLineToStorage(mContext m$) {
    return (6);
  }

  //<< #define StrMEDDispensePickLineToStorage $$GetPropertyName^COMConst("MEDDispensePickLine",6)
  public static Object $$$StrMEDDispensePickLineToStorage(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDDispensePickLine",6));
  }

  //<< #define MEDDispensePickLineFromStorage(%obj) $piece(%obj,"~",7)
  public static Object $$$MEDDispensePickLineFromStorage(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",7));
  }

  public static void $$$MEDDispensePickLineFromStorageSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",7).set(_setval.get());
  }

  //<< #define FldMEDDispensePickLineFromStorage 7
  public static Object $$$FldMEDDispensePickLineFromStorage(mContext m$) {
    return (7);
  }

  //<< #define StrMEDDispensePickLineFromStorage $$GetPropertyName^COMConst("MEDDispensePickLine",7)
  public static Object $$$StrMEDDispensePickLineFromStorage(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDDispensePickLine",7));
  }

  //<< #define MEDDispensePickLineBundle(%obj) $piece(%obj,"~",8)
  public static Object $$$MEDDispensePickLineBundle(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",8));
  }

  public static void $$$MEDDispensePickLineBundleSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",8).set(_setval.get());
  }

  //<< #define FldMEDDispensePickLineBundle 8
  public static Object $$$FldMEDDispensePickLineBundle(mContext m$) {
    return (8);
  }

  //<< #define StrMEDDispensePickLineBundle $$GetPropertyName^COMConst("MEDDispensePickLine",8)
  public static Object $$$StrMEDDispensePickLineBundle(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDDispensePickLine",8));
  }

  //<< #define MEDDispensePickLinePrescriptionLine(%obj) $piece(%obj,"~",9)
  public static Object $$$MEDDispensePickLinePrescriptionLine(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",9));
  }

  public static void $$$MEDDispensePickLinePrescriptionLineSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",9).set(_setval.get());
  }

  //<< #define FldMEDDispensePickLinePrescriptionLine 9
  public static Object $$$FldMEDDispensePickLinePrescriptionLine(mContext m$) {
    return (9);
  }

  //<< #define StrMEDDispensePickLinePrescriptionLine $$GetPropertyName^COMConst("MEDDispensePickLine",9)
  public static Object $$$StrMEDDispensePickLinePrescriptionLine(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDDispensePickLine",9));
  }

  //<< #define MEDDispensePickLineIsDiluent(%obj) $piece(%obj,"~",10)
  public static Object $$$MEDDispensePickLineIsDiluent(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",10));
  }

  public static void $$$MEDDispensePickLineIsDiluentSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",10).set(_setval.get());
  }

  //<< #define FldMEDDispensePickLineIsDiluent 10
  public static Object $$$FldMEDDispensePickLineIsDiluent(mContext m$) {
    return (10);
  }

  //<< #define StrMEDDispensePickLineIsDiluent $$GetPropertyName^COMConst("MEDDispensePickLine",10)
  public static Object $$$StrMEDDispensePickLineIsDiluent(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDDispensePickLine",10));
  }

  //<< #define MEDDispensePickLinePickUOM(%obj) $piece(%obj,"~",11)
  public static Object $$$MEDDispensePickLinePickUOM(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",11));
  }

  public static void $$$MEDDispensePickLinePickUOMSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",11).set(_setval.get());
  }

  //<< #define FldMEDDispensePickLinePickUOM 11
  public static Object $$$FldMEDDispensePickLinePickUOM(mContext m$) {
    return (11);
  }

  //<< #define StrMEDDispensePickLinePickUOM $$GetPropertyName^COMConst("MEDDispensePickLine",11)
  public static Object $$$StrMEDDispensePickLinePickUOM(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDDispensePickLine",11));
  }

  //<< #define MEDDispensePickLinePickQty(%obj) $piece(%obj,"~",12)
  public static Object $$$MEDDispensePickLinePickQty(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",12));
  }

  public static void $$$MEDDispensePickLinePickQtySet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",12).set(_setval.get());
  }

  //<< #define FldMEDDispensePickLinePickQty 12
  public static Object $$$FldMEDDispensePickLinePickQty(mContext m$) {
    return (12);
  }

  //<< #define StrMEDDispensePickLinePickQty $$GetPropertyName^COMConst("MEDDispensePickLine",12)
  public static Object $$$StrMEDDispensePickLinePickQty(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDDispensePickLine",12));
  }

  //<< #define FldMEDDispensePickLineDispense 1
  public static Object $$$FldMEDDispensePickLineDispense(mContext m$) {
    return (1);
  }

  //<< #define StrMEDDispensePickLineDispense $$GetPropertyName^COMConst("MEDDispensePickLine",,1)
  public static Object $$$StrMEDDispensePickLineDispense(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDDispensePickLine",null,1));
  }

  //<< #define FldMEDDispensePickLineLine 2
  public static Object $$$FldMEDDispensePickLineLine(mContext m$) {
    return (2);
  }

  //<< #define StrMEDDispensePickLineLine $$GetPropertyName^COMConst("MEDDispensePickLine",,2)
  public static Object $$$StrMEDDispensePickLineLine(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDDispensePickLine",null,2));
  }

  //<< 
  //<< #define MEDDrugInteractionClinicalImportance(%obj) $piece(%obj,"~",1)
  public static Object $$$MEDDrugInteractionClinicalImportance(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",1));
  }

  public static void $$$MEDDrugInteractionClinicalImportanceSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",1).set(_setval.get());
  }

  //<< #define FldMEDDrugInteractionClinicalImportance 1
  public static Object $$$FldMEDDrugInteractionClinicalImportance(mContext m$) {
    return (1);
  }

  //<< #define StrMEDDrugInteractionClinicalImportance $$GetPropertyName^COMConst("MEDDrugInteraction",1)
  public static Object $$$StrMEDDrugInteractionClinicalImportance(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDDrugInteraction",1));
  }

  //<< #define MEDDrugInteractionInteractionImportance(%obj) $piece(%obj,"~",2)
  public static Object $$$MEDDrugInteractionInteractionImportance(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",2));
  }

  public static void $$$MEDDrugInteractionInteractionImportanceSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",2).set(_setval.get());
  }

  //<< #define FldMEDDrugInteractionInteractionImportance 2
  public static Object $$$FldMEDDrugInteractionInteractionImportance(mContext m$) {
    return (2);
  }

  //<< #define StrMEDDrugInteractionInteractionImportance $$GetPropertyName^COMConst("MEDDrugInteraction",2)
  public static Object $$$StrMEDDrugInteractionInteractionImportance(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDDrugInteraction",2));
  }

  //<< #define MEDDrugInteractionEarlyInteraction(%obj) $piece(%obj,"~",3)
  public static Object $$$MEDDrugInteractionEarlyInteraction(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",3));
  }

  public static void $$$MEDDrugInteractionEarlyInteractionSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",3).set(_setval.get());
  }

  //<< #define FldMEDDrugInteractionEarlyInteraction 3
  public static Object $$$FldMEDDrugInteractionEarlyInteraction(mContext m$) {
    return (3);
  }

  //<< #define StrMEDDrugInteractionEarlyInteraction $$GetPropertyName^COMConst("MEDDrugInteraction",3)
  public static Object $$$StrMEDDrugInteractionEarlyInteraction(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDDrugInteraction",3));
  }

  //<< #define MEDDrugInteractionOccuranceProbability(%obj) $piece(%obj,"~",4)
  public static Object $$$MEDDrugInteractionOccuranceProbability(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",4));
  }

  public static void $$$MEDDrugInteractionOccuranceProbabilitySet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",4).set(_setval.get());
  }

  //<< #define FldMEDDrugInteractionOccuranceProbability 4
  public static Object $$$FldMEDDrugInteractionOccuranceProbability(mContext m$) {
    return (4);
  }

  //<< #define StrMEDDrugInteractionOccuranceProbability $$GetPropertyName^COMConst("MEDDrugInteraction",4)
  public static Object $$$StrMEDDrugInteractionOccuranceProbability(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDDrugInteraction",4));
  }

  //<< #define MEDDrugInteractionEffect(%obj) $piece(%obj,"~",5)
  public static Object $$$MEDDrugInteractionEffect(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",5));
  }

  public static void $$$MEDDrugInteractionEffectSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",5).set(_setval.get());
  }

  //<< #define FldMEDDrugInteractionEffect 5
  public static Object $$$FldMEDDrugInteractionEffect(mContext m$) {
    return (5);
  }

  //<< #define StrMEDDrugInteractionEffect $$GetPropertyName^COMConst("MEDDrugInteraction",5)
  public static Object $$$StrMEDDrugInteractionEffect(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDDrugInteraction",5));
  }

  //<< #define MEDDrugInteractionMechanism(%obj) $piece(%obj,"~",6)
  public static Object $$$MEDDrugInteractionMechanism(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",6));
  }

  public static void $$$MEDDrugInteractionMechanismSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",6).set(_setval.get());
  }

  //<< #define FldMEDDrugInteractionMechanism 6
  public static Object $$$FldMEDDrugInteractionMechanism(mContext m$) {
    return (6);
  }

  //<< #define StrMEDDrugInteractionMechanism $$GetPropertyName^COMConst("MEDDrugInteraction",6)
  public static Object $$$StrMEDDrugInteractionMechanism(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDDrugInteraction",6));
  }

  //<< #define MEDDrugInteractionSuggestion(%obj) $piece(%obj,"~",7)
  public static Object $$$MEDDrugInteractionSuggestion(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",7));
  }

  public static void $$$MEDDrugInteractionSuggestionSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",7).set(_setval.get());
  }

  //<< #define FldMEDDrugInteractionSuggestion 7
  public static Object $$$FldMEDDrugInteractionSuggestion(mContext m$) {
    return (7);
  }

  //<< #define StrMEDDrugInteractionSuggestion $$GetPropertyName^COMConst("MEDDrugInteraction",7)
  public static Object $$$StrMEDDrugInteractionSuggestion(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDDrugInteraction",7));
  }

  //<< #define MEDDrugInteractionCreatedBy(%obj) $piece(%obj,"~",10)
  public static Object $$$MEDDrugInteractionCreatedBy(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",10));
  }

  public static void $$$MEDDrugInteractionCreatedBySet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",10).set(_setval.get());
  }

  //<< #define FldMEDDrugInteractionCreatedBy 10
  public static Object $$$FldMEDDrugInteractionCreatedBy(mContext m$) {
    return (10);
  }

  //<< #define StrMEDDrugInteractionCreatedBy $$GetPropertyName^COMConst("MEDDrugInteraction",10)
  public static Object $$$StrMEDDrugInteractionCreatedBy(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDDrugInteraction",10));
  }

  //<< #define MEDDrugInteractionCreatedAt(%obj) $piece(%obj,"~",11)
  public static Object $$$MEDDrugInteractionCreatedAt(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",11));
  }

  public static void $$$MEDDrugInteractionCreatedAtSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",11).set(_setval.get());
  }

  //<< #define FldMEDDrugInteractionCreatedAt 11
  public static Object $$$FldMEDDrugInteractionCreatedAt(mContext m$) {
    return (11);
  }

  //<< #define StrMEDDrugInteractionCreatedAt $$GetPropertyName^COMConst("MEDDrugInteraction",11)
  public static Object $$$StrMEDDrugInteractionCreatedAt(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDDrugInteraction",11));
  }

  //<< #define MEDDrugInteractionModifiedBy(%obj) $piece(%obj,"~",12)
  public static Object $$$MEDDrugInteractionModifiedBy(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",12));
  }

  public static void $$$MEDDrugInteractionModifiedBySet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",12).set(_setval.get());
  }

  //<< #define FldMEDDrugInteractionModifiedBy 12
  public static Object $$$FldMEDDrugInteractionModifiedBy(mContext m$) {
    return (12);
  }

  //<< #define StrMEDDrugInteractionModifiedBy $$GetPropertyName^COMConst("MEDDrugInteraction",12)
  public static Object $$$StrMEDDrugInteractionModifiedBy(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDDrugInteraction",12));
  }

  //<< #define MEDDrugInteractionModifiedAt(%obj) $piece(%obj,"~",13)
  public static Object $$$MEDDrugInteractionModifiedAt(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",13));
  }

  public static void $$$MEDDrugInteractionModifiedAtSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",13).set(_setval.get());
  }

  //<< #define FldMEDDrugInteractionModifiedAt 13
  public static Object $$$FldMEDDrugInteractionModifiedAt(mContext m$) {
    return (13);
  }

  //<< #define StrMEDDrugInteractionModifiedAt $$GetPropertyName^COMConst("MEDDrugInteraction",13)
  public static Object $$$StrMEDDrugInteractionModifiedAt(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDDrugInteraction",13));
  }

  //<< #define MEDDrugInteractionActive1(%obj) $piece(%obj,"~",14)
  public static Object $$$MEDDrugInteractionActive1(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",14));
  }

  public static void $$$MEDDrugInteractionActive1Set(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",14).set(_setval.get());
  }

  //<< #define FldMEDDrugInteractionActive1 14
  public static Object $$$FldMEDDrugInteractionActive1(mContext m$) {
    return (14);
  }

  //<< #define StrMEDDrugInteractionActive1 $$GetPropertyName^COMConst("MEDDrugInteraction",14)
  public static Object $$$StrMEDDrugInteractionActive1(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDDrugInteraction",14));
  }

  //<< #define FldMEDDrugInteractionDrug 1
  public static Object $$$FldMEDDrugInteractionDrug(mContext m$) {
    return (1);
  }

  //<< #define StrMEDDrugInteractionDrug $$GetPropertyName^COMConst("MEDDrugInteraction",,1)
  public static Object $$$StrMEDDrugInteractionDrug(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDDrugInteraction",null,1));
  }

  //<< #define FldMEDDrugInteractionInteractiveDrug 2
  public static Object $$$FldMEDDrugInteractionInteractiveDrug(mContext m$) {
    return (2);
  }

  //<< #define StrMEDDrugInteractionInteractiveDrug $$GetPropertyName^COMConst("MEDDrugInteraction",,2)
  public static Object $$$StrMEDDrugInteractionInteractiveDrug(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDDrugInteraction",null,2));
  }

  //<< 
  //<< #define MEDFrequencyFrequency(%obj) $piece(%obj,"~",1)
  public static Object $$$MEDFrequencyFrequency(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",1));
  }

  public static void $$$MEDFrequencyFrequencySet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",1).set(_setval.get());
  }

  //<< #define FldMEDFrequencyFrequency 1
  public static Object $$$FldMEDFrequencyFrequency(mContext m$) {
    return (1);
  }

  //<< #define StrMEDFrequencyFrequency $$GetPropertyName^COMConst("MEDFrequency",1)
  public static Object $$$StrMEDFrequencyFrequency(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDFrequency",1));
  }

  //<< #define MEDFrequencyConversion(%obj) $piece(%obj,"~",2)
  public static Object $$$MEDFrequencyConversion(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",2));
  }

  public static void $$$MEDFrequencyConversionSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",2).set(_setval.get());
  }

  //<< #define FldMEDFrequencyConversion 2
  public static Object $$$FldMEDFrequencyConversion(mContext m$) {
    return (2);
  }

  //<< #define StrMEDFrequencyConversion $$GetPropertyName^COMConst("MEDFrequency",2)
  public static Object $$$StrMEDFrequencyConversion(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDFrequency",2));
  }

  //<< #define FldMEDFrequencyFrequencyID 1
  public static Object $$$FldMEDFrequencyFrequencyID(mContext m$) {
    return (1);
  }

  //<< #define StrMEDFrequencyFrequencyID $$GetPropertyName^COMConst("MEDFrequency",,1)
  public static Object $$$StrMEDFrequencyFrequencyID(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDFrequency",null,1));
  }

  //<< 
  //<< #define MEDICDDescription(%obj) $piece(%obj,"~",1)
  public static Object $$$MEDICDDescription(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",1));
  }

  public static void $$$MEDICDDescriptionSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",1).set(_setval.get());
  }

  //<< #define FldMEDICDDescription 1
  public static Object $$$FldMEDICDDescription(mContext m$) {
    return (1);
  }

  //<< #define StrMEDICDDescription $$GetPropertyName^COMConst("MEDICD",1)
  public static Object $$$StrMEDICDDescription(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDICD",1));
  }

  //<< #define MEDICDType(%obj) $piece(%obj,"~",2)
  public static Object $$$MEDICDType(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",2));
  }

  public static void $$$MEDICDTypeSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",2).set(_setval.get());
  }

  //<< #define FldMEDICDType 2
  public static Object $$$FldMEDICDType(mContext m$) {
    return (2);
  }

  //<< #define StrMEDICDType $$GetPropertyName^COMConst("MEDICD",2)
  public static Object $$$StrMEDICDType(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDICD",2));
  }

  //<< #define MEDICDGender(%obj) $piece(%obj,"~",3)
  public static Object $$$MEDICDGender(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",3));
  }

  public static void $$$MEDICDGenderSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",3).set(_setval.get());
  }

  //<< #define FldMEDICDGender 3
  public static Object $$$FldMEDICDGender(mContext m$) {
    return (3);
  }

  //<< #define StrMEDICDGender $$GetPropertyName^COMConst("MEDICD",3)
  public static Object $$$StrMEDICDGender(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDICD",3));
  }

  //<< #define FldMEDICDICDCode 1
  public static Object $$$FldMEDICDICDCode(mContext m$) {
    return (1);
  }

  //<< #define StrMEDICDICDCode $$GetPropertyName^COMConst("MEDICD",,1)
  public static Object $$$StrMEDICDICDCode(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDICD",null,1));
  }

  //<< 
  //<< #define MEDInfuseTimeUnitspermL(%obj) $piece(%obj,"~",1)
  public static Object $$$MEDInfuseTimeUnitspermL(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",1));
  }

  public static void $$$MEDInfuseTimeUnitspermLSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",1).set(_setval.get());
  }

  //<< #define FldMEDInfuseTimeUnitspermL 1
  public static Object $$$FldMEDInfuseTimeUnitspermL(mContext m$) {
    return (1);
  }

  //<< #define StrMEDInfuseTimeUnitspermL $$GetPropertyName^COMConst("MEDInfuseTime",1)
  public static Object $$$StrMEDInfuseTimeUnitspermL(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDInfuseTime",1));
  }

  //<< #define MEDInfuseTimeUnitsperHour(%obj) $piece(%obj,"~",2)
  public static Object $$$MEDInfuseTimeUnitsperHour(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",2));
  }

  public static void $$$MEDInfuseTimeUnitsperHourSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",2).set(_setval.get());
  }

  //<< #define FldMEDInfuseTimeUnitsperHour 2
  public static Object $$$FldMEDInfuseTimeUnitsperHour(mContext m$) {
    return (2);
  }

  //<< #define StrMEDInfuseTimeUnitsperHour $$GetPropertyName^COMConst("MEDInfuseTime",2)
  public static Object $$$StrMEDInfuseTimeUnitsperHour(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDInfuseTime",2));
  }

  //<< #define FldMEDInfuseTimeUnit 1
  public static Object $$$FldMEDInfuseTimeUnit(mContext m$) {
    return (1);
  }

  //<< #define StrMEDInfuseTimeUnit $$GetPropertyName^COMConst("MEDInfuseTime",,1)
  public static Object $$$StrMEDInfuseTimeUnit(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDInfuseTime",null,1));
  }

  //<< 
  //<< #define MEDPatientSurname(%obj) $piece(%obj,"~",1)
  public static Object $$$MEDPatientSurname(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",1));
  }

  public static void $$$MEDPatientSurnameSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",1).set(_setval.get());
  }

  //<< #define FldMEDPatientSurname 1
  public static Object $$$FldMEDPatientSurname(mContext m$) {
    return (1);
  }

  //<< #define StrMEDPatientSurname $$GetPropertyName^COMConst("MEDPatient",1)
  public static Object $$$StrMEDPatientSurname(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDPatient",1));
  }

  //<< #define MEDPatientOtherNames(%obj) $piece(%obj,"~",2)
  public static Object $$$MEDPatientOtherNames(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",2));
  }

  public static void $$$MEDPatientOtherNamesSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",2).set(_setval.get());
  }

  //<< #define FldMEDPatientOtherNames 2
  public static Object $$$FldMEDPatientOtherNames(mContext m$) {
    return (2);
  }

  //<< #define StrMEDPatientOtherNames $$GetPropertyName^COMConst("MEDPatient",2)
  public static Object $$$StrMEDPatientOtherNames(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDPatient",2));
  }

  //<< #define MEDPatientGender(%obj) $piece(%obj,"~",3)
  public static Object $$$MEDPatientGender(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",3));
  }

  public static void $$$MEDPatientGenderSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",3).set(_setval.get());
  }

  //<< #define FldMEDPatientGender 3
  public static Object $$$FldMEDPatientGender(mContext m$) {
    return (3);
  }

  //<< #define StrMEDPatientGender $$GetPropertyName^COMConst("MEDPatient",3)
  public static Object $$$StrMEDPatientGender(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDPatient",3));
  }

  //<< #define MEDPatientDOB(%obj) $piece(%obj,"~",4)
  public static Object $$$MEDPatientDOB(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",4));
  }

  public static void $$$MEDPatientDOBSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",4).set(_setval.get());
  }

  //<< #define FldMEDPatientDOB 4
  public static Object $$$FldMEDPatientDOB(mContext m$) {
    return (4);
  }

  //<< #define StrMEDPatientDOB $$GetPropertyName^COMConst("MEDPatient",4)
  public static Object $$$StrMEDPatientDOB(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDPatient",4));
  }

  //<< #define MEDPatientAdmitted(%obj) $piece(%obj,"~",5)
  public static Object $$$MEDPatientAdmitted(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",5));
  }

  public static void $$$MEDPatientAdmittedSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",5).set(_setval.get());
  }

  //<< #define FldMEDPatientAdmitted 5
  public static Object $$$FldMEDPatientAdmitted(mContext m$) {
    return (5);
  }

  //<< #define StrMEDPatientAdmitted $$GetPropertyName^COMConst("MEDPatient",5)
  public static Object $$$StrMEDPatientAdmitted(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDPatient",5));
  }

  //<< #define MEDPatientRoom(%obj) $piece(%obj,"~",6)
  public static Object $$$MEDPatientRoom(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",6));
  }

  public static void $$$MEDPatientRoomSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",6).set(_setval.get());
  }

  //<< #define FldMEDPatientRoom 6
  public static Object $$$FldMEDPatientRoom(mContext m$) {
    return (6);
  }

  //<< #define StrMEDPatientRoom $$GetPropertyName^COMConst("MEDPatient",6)
  public static Object $$$StrMEDPatientRoom(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDPatient",6));
  }

  //<< #define MEDPatientPID(%obj) $piece(%obj,"~",7)
  public static Object $$$MEDPatientPID(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",7));
  }

  public static void $$$MEDPatientPIDSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",7).set(_setval.get());
  }

  //<< #define FldMEDPatientPID 7
  public static Object $$$FldMEDPatientPID(mContext m$) {
    return (7);
  }

  //<< #define StrMEDPatientPID $$GetPropertyName^COMConst("MEDPatient",7)
  public static Object $$$StrMEDPatientPID(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDPatient",7));
  }

  //<< #define MEDPatientDepartment(%obj) $piece(%obj,"~",8)
  public static Object $$$MEDPatientDepartment(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",8));
  }

  public static void $$$MEDPatientDepartmentSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",8).set(_setval.get());
  }

  //<< #define FldMEDPatientDepartment 8
  public static Object $$$FldMEDPatientDepartment(mContext m$) {
    return (8);
  }

  //<< #define StrMEDPatientDepartment $$GetPropertyName^COMConst("MEDPatient",8)
  public static Object $$$StrMEDPatientDepartment(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDPatient",8));
  }

  //<< #define MEDPatientMothersName(%obj) $piece(%obj,"~",9)
  public static Object $$$MEDPatientMothersName(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",9));
  }

  public static void $$$MEDPatientMothersNameSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",9).set(_setval.get());
  }

  //<< #define FldMEDPatientMothersName 9
  public static Object $$$FldMEDPatientMothersName(mContext m$) {
    return (9);
  }

  //<< #define StrMEDPatientMothersName $$GetPropertyName^COMConst("MEDPatient",9)
  public static Object $$$StrMEDPatientMothersName(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDPatient",9));
  }

  //<< #define MEDPatientMothersDOB(%obj) $piece(%obj,"~",10)
  public static Object $$$MEDPatientMothersDOB(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",10));
  }

  public static void $$$MEDPatientMothersDOBSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",10).set(_setval.get());
  }

  //<< #define FldMEDPatientMothersDOB 10
  public static Object $$$FldMEDPatientMothersDOB(mContext m$) {
    return (10);
  }

  //<< #define StrMEDPatientMothersDOB $$GetPropertyName^COMConst("MEDPatient",10)
  public static Object $$$StrMEDPatientMothersDOB(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDPatient",10));
  }

  //<< #define MEDPatientSSN(%obj) $piece(%obj,"~",11)
  public static Object $$$MEDPatientSSN(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",11));
  }

  public static void $$$MEDPatientSSNSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",11).set(_setval.get());
  }

  //<< #define FldMEDPatientSSN 11
  public static Object $$$FldMEDPatientSSN(mContext m$) {
    return (11);
  }

  //<< #define StrMEDPatientSSN $$GetPropertyName^COMConst("MEDPatient",11)
  public static Object $$$StrMEDPatientSSN(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDPatient",11));
  }

  //<< #define MEDPatientStreet(%obj) $piece(%obj,"~",12)
  public static Object $$$MEDPatientStreet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",12));
  }

  public static void $$$MEDPatientStreetSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",12).set(_setval.get());
  }

  //<< #define FldMEDPatientStreet 12
  public static Object $$$FldMEDPatientStreet(mContext m$) {
    return (12);
  }

  //<< #define StrMEDPatientStreet $$GetPropertyName^COMConst("MEDPatient",12)
  public static Object $$$StrMEDPatientStreet(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDPatient",12));
  }

  //<< #define MEDPatientZipCode(%obj) $piece(%obj,"~",13)
  public static Object $$$MEDPatientZipCode(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",13));
  }

  public static void $$$MEDPatientZipCodeSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",13).set(_setval.get());
  }

  //<< #define FldMEDPatientZipCode 13
  public static Object $$$FldMEDPatientZipCode(mContext m$) {
    return (13);
  }

  //<< #define StrMEDPatientZipCode $$GetPropertyName^COMConst("MEDPatient",13)
  public static Object $$$StrMEDPatientZipCode(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDPatient",13));
  }

  //<< #define MEDPatientCity(%obj) $piece(%obj,"~",14)
  public static Object $$$MEDPatientCity(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",14));
  }

  public static void $$$MEDPatientCitySet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",14).set(_setval.get());
  }

  //<< #define FldMEDPatientCity 14
  public static Object $$$FldMEDPatientCity(mContext m$) {
    return (14);
  }

  //<< #define StrMEDPatientCity $$GetPropertyName^COMConst("MEDPatient",14)
  public static Object $$$StrMEDPatientCity(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDPatient",14));
  }

  //<< #define MEDPatientState(%obj) $piece(%obj,"~",15)
  public static Object $$$MEDPatientState(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",15));
  }

  public static void $$$MEDPatientStateSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",15).set(_setval.get());
  }

  //<< #define FldMEDPatientState 15
  public static Object $$$FldMEDPatientState(mContext m$) {
    return (15);
  }

  //<< #define StrMEDPatientState $$GetPropertyName^COMConst("MEDPatient",15)
  public static Object $$$StrMEDPatientState(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDPatient",15));
  }

  //<< #define MEDPatientTel(%obj) $piece(%obj,"~",16)
  public static Object $$$MEDPatientTel(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",16));
  }

  public static void $$$MEDPatientTelSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",16).set(_setval.get());
  }

  //<< #define FldMEDPatientTel 16
  public static Object $$$FldMEDPatientTel(mContext m$) {
    return (16);
  }

  //<< #define StrMEDPatientTel $$GetPropertyName^COMConst("MEDPatient",16)
  public static Object $$$StrMEDPatientTel(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDPatient",16));
  }

  //<< #define MEDPatientEmail(%obj) $piece(%obj,"~",17)
  public static Object $$$MEDPatientEmail(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",17));
  }

  public static void $$$MEDPatientEmailSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",17).set(_setval.get());
  }

  //<< #define FldMEDPatientEmail 17
  public static Object $$$FldMEDPatientEmail(mContext m$) {
    return (17);
  }

  //<< #define StrMEDPatientEmail $$GetPropertyName^COMConst("MEDPatient",17)
  public static Object $$$StrMEDPatientEmail(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDPatient",17));
  }

  //<< #define MEDPatientExternalCode(%obj) $piece(%obj,"~",18)
  public static Object $$$MEDPatientExternalCode(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",18));
  }

  public static void $$$MEDPatientExternalCodeSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",18).set(_setval.get());
  }

  //<< #define FldMEDPatientExternalCode 18
  public static Object $$$FldMEDPatientExternalCode(mContext m$) {
    return (18);
  }

  //<< #define StrMEDPatientExternalCode $$GetPropertyName^COMConst("MEDPatient",18)
  public static Object $$$StrMEDPatientExternalCode(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDPatient",18));
  }

  //<< #define MEDPatientCreatedBy(%obj) $piece(%obj,"~",19)
  public static Object $$$MEDPatientCreatedBy(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",19));
  }

  public static void $$$MEDPatientCreatedBySet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",19).set(_setval.get());
  }

  //<< #define FldMEDPatientCreatedBy 19
  public static Object $$$FldMEDPatientCreatedBy(mContext m$) {
    return (19);
  }

  //<< #define StrMEDPatientCreatedBy $$GetPropertyName^COMConst("MEDPatient",19)
  public static Object $$$StrMEDPatientCreatedBy(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDPatient",19));
  }

  //<< #define MEDPatientCreatedDate(%obj) $piece(%obj,"~",20)
  public static Object $$$MEDPatientCreatedDate(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",20));
  }

  public static void $$$MEDPatientCreatedDateSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",20).set(_setval.get());
  }

  //<< #define FldMEDPatientCreatedDate 20
  public static Object $$$FldMEDPatientCreatedDate(mContext m$) {
    return (20);
  }

  //<< #define StrMEDPatientCreatedDate $$GetPropertyName^COMConst("MEDPatient",20)
  public static Object $$$StrMEDPatientCreatedDate(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDPatient",20));
  }

  //<< #define MEDPatientChangedBy(%obj) $piece(%obj,"~",21)
  public static Object $$$MEDPatientChangedBy(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",21));
  }

  public static void $$$MEDPatientChangedBySet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",21).set(_setval.get());
  }

  //<< #define FldMEDPatientChangedBy 21
  public static Object $$$FldMEDPatientChangedBy(mContext m$) {
    return (21);
  }

  //<< #define StrMEDPatientChangedBy $$GetPropertyName^COMConst("MEDPatient",21)
  public static Object $$$StrMEDPatientChangedBy(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDPatient",21));
  }

  //<< #define MEDPatientChangedDate(%obj) $piece(%obj,"~",22)
  public static Object $$$MEDPatientChangedDate(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",22));
  }

  public static void $$$MEDPatientChangedDateSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",22).set(_setval.get());
  }

  //<< #define FldMEDPatientChangedDate 22
  public static Object $$$FldMEDPatientChangedDate(mContext m$) {
    return (22);
  }

  //<< #define StrMEDPatientChangedDate $$GetPropertyName^COMConst("MEDPatient",22)
  public static Object $$$StrMEDPatientChangedDate(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDPatient",22));
  }

  //<< #define MEDPatientName(%obj) $piece(%obj,"~",23)
  public static Object $$$MEDPatientName(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",23));
  }

  public static void $$$MEDPatientNameSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",23).set(_setval.get());
  }

  //<< #define FldMEDPatientName 23
  public static Object $$$FldMEDPatientName(mContext m$) {
    return (23);
  }

  //<< #define StrMEDPatientName $$GetPropertyName^COMConst("MEDPatient",23)
  public static Object $$$StrMEDPatientName(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDPatient",23));
  }

  //<< #define MEDPatientFREE1(%obj) $piece(%obj,"~",31)
  public static Object $$$MEDPatientFREE1(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",31));
  }

  public static void $$$MEDPatientFREE1Set(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",31).set(_setval.get());
  }

  //<< #define FldMEDPatientFREE1 31
  public static Object $$$FldMEDPatientFREE1(mContext m$) {
    return (31);
  }

  //<< #define StrMEDPatientFREE1 $$GetPropertyName^COMConst("MEDPatient",31)
  public static Object $$$StrMEDPatientFREE1(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDPatient",31));
  }

  //<< #define MEDPatientFREE2(%obj) $piece(%obj,"~",32)
  public static Object $$$MEDPatientFREE2(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",32));
  }

  public static void $$$MEDPatientFREE2Set(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",32).set(_setval.get());
  }

  //<< #define FldMEDPatientFREE2 32
  public static Object $$$FldMEDPatientFREE2(mContext m$) {
    return (32);
  }

  //<< #define StrMEDPatientFREE2 $$GetPropertyName^COMConst("MEDPatient",32)
  public static Object $$$StrMEDPatientFREE2(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDPatient",32));
  }

  //<< #define MEDPatientFREE3(%obj) $piece(%obj,"~",33)
  public static Object $$$MEDPatientFREE3(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",33));
  }

  public static void $$$MEDPatientFREE3Set(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",33).set(_setval.get());
  }

  //<< #define FldMEDPatientFREE3 33
  public static Object $$$FldMEDPatientFREE3(mContext m$) {
    return (33);
  }

  //<< #define StrMEDPatientFREE3 $$GetPropertyName^COMConst("MEDPatient",33)
  public static Object $$$StrMEDPatientFREE3(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDPatient",33));
  }

  //<< #define MEDPatientFREE4(%obj) $piece(%obj,"~",34)
  public static Object $$$MEDPatientFREE4(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",34));
  }

  public static void $$$MEDPatientFREE4Set(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",34).set(_setval.get());
  }

  //<< #define FldMEDPatientFREE4 34
  public static Object $$$FldMEDPatientFREE4(mContext m$) {
    return (34);
  }

  //<< #define StrMEDPatientFREE4 $$GetPropertyName^COMConst("MEDPatient",34)
  public static Object $$$StrMEDPatientFREE4(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDPatient",34));
  }

  //<< #define MEDPatientFREE5(%obj) $piece(%obj,"~",35)
  public static Object $$$MEDPatientFREE5(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",35));
  }

  public static void $$$MEDPatientFREE5Set(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",35).set(_setval.get());
  }

  //<< #define FldMEDPatientFREE5 35
  public static Object $$$FldMEDPatientFREE5(mContext m$) {
    return (35);
  }

  //<< #define StrMEDPatientFREE5 $$GetPropertyName^COMConst("MEDPatient",35)
  public static Object $$$StrMEDPatientFREE5(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDPatient",35));
  }

  //<< #define MEDPatientFREE6(%obj) $piece(%obj,"~",36)
  public static Object $$$MEDPatientFREE6(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",36));
  }

  public static void $$$MEDPatientFREE6Set(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",36).set(_setval.get());
  }

  //<< #define FldMEDPatientFREE6 36
  public static Object $$$FldMEDPatientFREE6(mContext m$) {
    return (36);
  }

  //<< #define StrMEDPatientFREE6 $$GetPropertyName^COMConst("MEDPatient",36)
  public static Object $$$StrMEDPatientFREE6(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDPatient",36));
  }

  //<< #define MEDPatientFREE7(%obj) $piece(%obj,"~",37)
  public static Object $$$MEDPatientFREE7(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",37));
  }

  public static void $$$MEDPatientFREE7Set(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",37).set(_setval.get());
  }

  //<< #define FldMEDPatientFREE7 37
  public static Object $$$FldMEDPatientFREE7(mContext m$) {
    return (37);
  }

  //<< #define StrMEDPatientFREE7 $$GetPropertyName^COMConst("MEDPatient",37)
  public static Object $$$StrMEDPatientFREE7(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDPatient",37));
  }

  //<< #define MEDPatientFREE8(%obj) $piece(%obj,"~",38)
  public static Object $$$MEDPatientFREE8(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",38));
  }

  public static void $$$MEDPatientFREE8Set(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",38).set(_setval.get());
  }

  //<< #define FldMEDPatientFREE8 38
  public static Object $$$FldMEDPatientFREE8(mContext m$) {
    return (38);
  }

  //<< #define StrMEDPatientFREE8 $$GetPropertyName^COMConst("MEDPatient",38)
  public static Object $$$StrMEDPatientFREE8(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDPatient",38));
  }

  //<< #define MEDPatientFREE9(%obj) $piece(%obj,"~",39)
  public static Object $$$MEDPatientFREE9(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",39));
  }

  public static void $$$MEDPatientFREE9Set(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",39).set(_setval.get());
  }

  //<< #define FldMEDPatientFREE9 39
  public static Object $$$FldMEDPatientFREE9(mContext m$) {
    return (39);
  }

  //<< #define StrMEDPatientFREE9 $$GetPropertyName^COMConst("MEDPatient",39)
  public static Object $$$StrMEDPatientFREE9(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDPatient",39));
  }

  //<< #define MEDPatientFREE10(%obj) $piece(%obj,"~",40)
  public static Object $$$MEDPatientFREE10(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",40));
  }

  public static void $$$MEDPatientFREE10Set(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",40).set(_setval.get());
  }

  //<< #define FldMEDPatientFREE10 40
  public static Object $$$FldMEDPatientFREE10(mContext m$) {
    return (40);
  }

  //<< #define StrMEDPatientFREE10 $$GetPropertyName^COMConst("MEDPatient",40)
  public static Object $$$StrMEDPatientFREE10(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDPatient",40));
  }

  //<< #define MEDPatientFREE11(%obj) $piece(%obj,"~",41)
  public static Object $$$MEDPatientFREE11(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",41));
  }

  public static void $$$MEDPatientFREE11Set(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",41).set(_setval.get());
  }

  //<< #define FldMEDPatientFREE11 41
  public static Object $$$FldMEDPatientFREE11(mContext m$) {
    return (41);
  }

  //<< #define StrMEDPatientFREE11 $$GetPropertyName^COMConst("MEDPatient",41)
  public static Object $$$StrMEDPatientFREE11(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDPatient",41));
  }

  //<< #define MEDPatientFREE12(%obj) $piece(%obj,"~",42)
  public static Object $$$MEDPatientFREE12(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",42));
  }

  public static void $$$MEDPatientFREE12Set(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",42).set(_setval.get());
  }

  //<< #define FldMEDPatientFREE12 42
  public static Object $$$FldMEDPatientFREE12(mContext m$) {
    return (42);
  }

  //<< #define StrMEDPatientFREE12 $$GetPropertyName^COMConst("MEDPatient",42)
  public static Object $$$StrMEDPatientFREE12(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDPatient",42));
  }

  //<< #define MEDPatientFREE13(%obj) $piece(%obj,"~",43)
  public static Object $$$MEDPatientFREE13(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",43));
  }

  public static void $$$MEDPatientFREE13Set(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",43).set(_setval.get());
  }

  //<< #define FldMEDPatientFREE13 43
  public static Object $$$FldMEDPatientFREE13(mContext m$) {
    return (43);
  }

  //<< #define StrMEDPatientFREE13 $$GetPropertyName^COMConst("MEDPatient",43)
  public static Object $$$StrMEDPatientFREE13(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDPatient",43));
  }

  //<< #define MEDPatientFREE14(%obj) $piece(%obj,"~",44)
  public static Object $$$MEDPatientFREE14(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",44));
  }

  public static void $$$MEDPatientFREE14Set(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",44).set(_setval.get());
  }

  //<< #define FldMEDPatientFREE14 44
  public static Object $$$FldMEDPatientFREE14(mContext m$) {
    return (44);
  }

  //<< #define StrMEDPatientFREE14 $$GetPropertyName^COMConst("MEDPatient",44)
  public static Object $$$StrMEDPatientFREE14(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDPatient",44));
  }

  //<< #define MEDPatientFREE15(%obj) $piece(%obj,"~",45)
  public static Object $$$MEDPatientFREE15(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",45));
  }

  public static void $$$MEDPatientFREE15Set(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",45).set(_setval.get());
  }

  //<< #define FldMEDPatientFREE15 45
  public static Object $$$FldMEDPatientFREE15(mContext m$) {
    return (45);
  }

  //<< #define StrMEDPatientFREE15 $$GetPropertyName^COMConst("MEDPatient",45)
  public static Object $$$StrMEDPatientFREE15(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDPatient",45));
  }

  //<< #define MEDPatientAllergies(%obj) $piece(%obj,"~",46)
  public static Object $$$MEDPatientAllergies(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",46));
  }

  public static void $$$MEDPatientAllergiesSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",46).set(_setval.get());
  }

  //<< #define FldMEDPatientAllergies 46
  public static Object $$$FldMEDPatientAllergies(mContext m$) {
    return (46);
  }

  //<< #define StrMEDPatientAllergies $$GetPropertyName^COMConst("MEDPatient",46)
  public static Object $$$StrMEDPatientAllergies(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDPatient",46));
  }

  //<< #define MEDPatientAdmissionDate(%obj) $piece(%obj,"~",47)
  public static Object $$$MEDPatientAdmissionDate(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",47));
  }

  public static void $$$MEDPatientAdmissionDateSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",47).set(_setval.get());
  }

  //<< #define FldMEDPatientAdmissionDate 47
  public static Object $$$FldMEDPatientAdmissionDate(mContext m$) {
    return (47);
  }

  //<< #define StrMEDPatientAdmissionDate $$GetPropertyName^COMConst("MEDPatient",47)
  public static Object $$$StrMEDPatientAdmissionDate(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDPatient",47));
  }

  //<< #define MEDPatientLocation(%obj) $piece(%obj,"~",48)
  public static Object $$$MEDPatientLocation(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",48));
  }

  public static void $$$MEDPatientLocationSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",48).set(_setval.get());
  }

  //<< #define FldMEDPatientLocation 48
  public static Object $$$FldMEDPatientLocation(mContext m$) {
    return (48);
  }

  //<< #define StrMEDPatientLocation $$GetPropertyName^COMConst("MEDPatient",48)
  public static Object $$$StrMEDPatientLocation(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDPatient",48));
  }

  //<< #define MEDPatientRoom1(%obj) $piece(%obj,"~",49)
  public static Object $$$MEDPatientRoom1(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",49));
  }

  public static void $$$MEDPatientRoom1Set(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",49).set(_setval.get());
  }

  //<< #define FldMEDPatientRoom1 49
  public static Object $$$FldMEDPatientRoom1(mContext m$) {
    return (49);
  }

  //<< #define StrMEDPatientRoom1 $$GetPropertyName^COMConst("MEDPatient",49)
  public static Object $$$StrMEDPatientRoom1(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDPatient",49));
  }

  //<< #define MEDPatientBed(%obj) $piece(%obj,"~",50)
  public static Object $$$MEDPatientBed(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",50));
  }

  public static void $$$MEDPatientBedSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",50).set(_setval.get());
  }

  //<< #define FldMEDPatientBed 50
  public static Object $$$FldMEDPatientBed(mContext m$) {
    return (50);
  }

  //<< #define StrMEDPatientBed $$GetPropertyName^COMConst("MEDPatient",50)
  public static Object $$$StrMEDPatientBed(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDPatient",50));
  }

  //<< #define MEDPatientCurrentlyAdmitted(%obj) $piece(%obj,"~",51)
  public static Object $$$MEDPatientCurrentlyAdmitted(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",51));
  }

  public static void $$$MEDPatientCurrentlyAdmittedSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",51).set(_setval.get());
  }

  //<< #define FldMEDPatientCurrentlyAdmitted 51
  public static Object $$$FldMEDPatientCurrentlyAdmitted(mContext m$) {
    return (51);
  }

  //<< #define StrMEDPatientCurrentlyAdmitted $$GetPropertyName^COMConst("MEDPatient",51)
  public static Object $$$StrMEDPatientCurrentlyAdmitted(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDPatient",51));
  }

  //<< #define FldMEDPatientPatientID 1
  public static Object $$$FldMEDPatientPatientID(mContext m$) {
    return (1);
  }

  //<< #define StrMEDPatientPatientID $$GetPropertyName^COMConst("MEDPatient",,1)
  public static Object $$$StrMEDPatientPatientID(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDPatient",null,1));
  }

  //<< 
  //<< #define MEDPrescriptionStatus(%obj) $piece(%obj,"~",1)
  public static Object $$$MEDPrescriptionStatus(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",1));
  }

  public static void $$$MEDPrescriptionStatusSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",1).set(_setval.get());
  }

  //<< #define FldMEDPrescriptionStatus 1
  public static Object $$$FldMEDPrescriptionStatus(mContext m$) {
    return (1);
  }

  //<< #define StrMEDPrescriptionStatus $$GetPropertyName^COMConst("MEDPrescription",1)
  public static Object $$$StrMEDPrescriptionStatus(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDPrescription",1));
  }

  //<< #define MEDPrescriptionPatientID(%obj) $piece(%obj,"~",2)
  public static Object $$$MEDPrescriptionPatientID(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",2));
  }

  public static void $$$MEDPrescriptionPatientIDSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",2).set(_setval.get());
  }

  //<< #define FldMEDPrescriptionPatientID 2
  public static Object $$$FldMEDPrescriptionPatientID(mContext m$) {
    return (2);
  }

  //<< #define StrMEDPrescriptionPatientID $$GetPropertyName^COMConst("MEDPrescription",2)
  public static Object $$$StrMEDPrescriptionPatientID(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDPrescription",2));
  }

  //<< #define MEDPrescriptionDateCreated(%obj) $piece(%obj,"~",3)
  public static Object $$$MEDPrescriptionDateCreated(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",3));
  }

  public static void $$$MEDPrescriptionDateCreatedSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",3).set(_setval.get());
  }

  //<< #define FldMEDPrescriptionDateCreated 3
  public static Object $$$FldMEDPrescriptionDateCreated(mContext m$) {
    return (3);
  }

  //<< #define StrMEDPrescriptionDateCreated $$GetPropertyName^COMConst("MEDPrescription",3)
  public static Object $$$StrMEDPrescriptionDateCreated(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDPrescription",3));
  }

  //<< #define MEDPrescriptionPrescriptionType(%obj) $piece(%obj,"~",4)
  public static Object $$$MEDPrescriptionPrescriptionType(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",4));
  }

  public static void $$$MEDPrescriptionPrescriptionTypeSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",4).set(_setval.get());
  }

  //<< #define FldMEDPrescriptionPrescriptionType 4
  public static Object $$$FldMEDPrescriptionPrescriptionType(mContext m$) {
    return (4);
  }

  //<< #define StrMEDPrescriptionPrescriptionType $$GetPropertyName^COMConst("MEDPrescription",4)
  public static Object $$$StrMEDPrescriptionPrescriptionType(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDPrescription",4));
  }

  //<< #define MEDPrescriptionIssueType(%obj) $piece(%obj,"~",5)
  public static Object $$$MEDPrescriptionIssueType(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",5));
  }

  public static void $$$MEDPrescriptionIssueTypeSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",5).set(_setval.get());
  }

  //<< #define FldMEDPrescriptionIssueType 5
  public static Object $$$FldMEDPrescriptionIssueType(mContext m$) {
    return (5);
  }

  //<< #define StrMEDPrescriptionIssueType $$GetPropertyName^COMConst("MEDPrescription",5)
  public static Object $$$StrMEDPrescriptionIssueType(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDPrescription",5));
  }

  //<< #define MEDPrescriptionSupplyingLocn(%obj) $piece(%obj,"~",6)
  public static Object $$$MEDPrescriptionSupplyingLocn(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",6));
  }

  public static void $$$MEDPrescriptionSupplyingLocnSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",6).set(_setval.get());
  }

  //<< #define FldMEDPrescriptionSupplyingLocn 6
  public static Object $$$FldMEDPrescriptionSupplyingLocn(mContext m$) {
    return (6);
  }

  //<< #define StrMEDPrescriptionSupplyingLocn $$GetPropertyName^COMConst("MEDPrescription",6)
  public static Object $$$StrMEDPrescriptionSupplyingLocn(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDPrescription",6));
  }

  //<< #define MEDPrescriptionNumberOfRepeats(%obj) $piece(%obj,"~",7)
  public static Object $$$MEDPrescriptionNumberOfRepeats(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",7));
  }

  public static void $$$MEDPrescriptionNumberOfRepeatsSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",7).set(_setval.get());
  }

  //<< #define FldMEDPrescriptionNumberOfRepeats 7
  public static Object $$$FldMEDPrescriptionNumberOfRepeats(mContext m$) {
    return (7);
  }

  //<< #define StrMEDPrescriptionNumberOfRepeats $$GetPropertyName^COMConst("MEDPrescription",7)
  public static Object $$$StrMEDPrescriptionNumberOfRepeats(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDPrescription",7));
  }

  //<< #define MEDPrescriptionFrequency(%obj) $piece(%obj,"~",8)
  public static Object $$$MEDPrescriptionFrequency(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",8));
  }

  public static void $$$MEDPrescriptionFrequencySet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",8).set(_setval.get());
  }

  //<< #define FldMEDPrescriptionFrequency 8
  public static Object $$$FldMEDPrescriptionFrequency(mContext m$) {
    return (8);
  }

  //<< #define StrMEDPrescriptionFrequency $$GetPropertyName^COMConst("MEDPrescription",8)
  public static Object $$$StrMEDPrescriptionFrequency(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDPrescription",8));
  }

  //<< #define MEDPrescriptionProviderNumber(%obj) $piece(%obj,"~",9)
  public static Object $$$MEDPrescriptionProviderNumber(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",9));
  }

  public static void $$$MEDPrescriptionProviderNumberSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",9).set(_setval.get());
  }

  //<< #define FldMEDPrescriptionProviderNumber 9
  public static Object $$$FldMEDPrescriptionProviderNumber(mContext m$) {
    return (9);
  }

  //<< #define StrMEDPrescriptionProviderNumber $$GetPropertyName^COMConst("MEDPrescription",9)
  public static Object $$$StrMEDPrescriptionProviderNumber(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDPrescription",9));
  }

  //<< #define MEDPrescriptionDoctorName(%obj) $piece(%obj,"~",10)
  public static Object $$$MEDPrescriptionDoctorName(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",10));
  }

  public static void $$$MEDPrescriptionDoctorNameSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",10).set(_setval.get());
  }

  //<< #define FldMEDPrescriptionDoctorName 10
  public static Object $$$FldMEDPrescriptionDoctorName(mContext m$) {
    return (10);
  }

  //<< #define StrMEDPrescriptionDoctorName $$GetPropertyName^COMConst("MEDPrescription",10)
  public static Object $$$StrMEDPrescriptionDoctorName(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDPrescription",10));
  }

  //<< #define MEDPrescriptionNotes(%obj) $piece(%obj,"~",11)
  public static Object $$$MEDPrescriptionNotes(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",11));
  }

  public static void $$$MEDPrescriptionNotesSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",11).set(_setval.get());
  }

  //<< #define FldMEDPrescriptionNotes 11
  public static Object $$$FldMEDPrescriptionNotes(mContext m$) {
    return (11);
  }

  //<< #define StrMEDPrescriptionNotes $$GetPropertyName^COMConst("MEDPrescription",11)
  public static Object $$$StrMEDPrescriptionNotes(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDPrescription",11));
  }

  //<< #define MEDPrescriptionBaseItem(%obj) $piece(%obj,"~",12)
  public static Object $$$MEDPrescriptionBaseItem(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",12));
  }

  public static void $$$MEDPrescriptionBaseItemSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",12).set(_setval.get());
  }

  //<< #define FldMEDPrescriptionBaseItem 12
  public static Object $$$FldMEDPrescriptionBaseItem(mContext m$) {
    return (12);
  }

  //<< #define StrMEDPrescriptionBaseItem $$GetPropertyName^COMConst("MEDPrescription",12)
  public static Object $$$StrMEDPrescriptionBaseItem(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDPrescription",12));
  }

  //<< #define MEDPrescriptionDispensingLocn(%obj) $piece(%obj,"~",13)
  public static Object $$$MEDPrescriptionDispensingLocn(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",13));
  }

  public static void $$$MEDPrescriptionDispensingLocnSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",13).set(_setval.get());
  }

  //<< #define FldMEDPrescriptionDispensingLocn 13
  public static Object $$$FldMEDPrescriptionDispensingLocn(mContext m$) {
    return (13);
  }

  //<< #define StrMEDPrescriptionDispensingLocn $$GetPropertyName^COMConst("MEDPrescription",13)
  public static Object $$$StrMEDPrescriptionDispensingLocn(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDPrescription",13));
  }

  //<< #define MEDPrescriptionDueDate(%obj) $piece(%obj,"~",14)
  public static Object $$$MEDPrescriptionDueDate(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",14));
  }

  public static void $$$MEDPrescriptionDueDateSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",14).set(_setval.get());
  }

  //<< #define FldMEDPrescriptionDueDate 14
  public static Object $$$FldMEDPrescriptionDueDate(mContext m$) {
    return (14);
  }

  //<< #define StrMEDPrescriptionDueDate $$GetPropertyName^COMConst("MEDPrescription",14)
  public static Object $$$StrMEDPrescriptionDueDate(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDPrescription",14));
  }

  //<< #define MEDPrescriptionDueTime(%obj) $piece(%obj,"~",15)
  public static Object $$$MEDPrescriptionDueTime(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",15));
  }

  public static void $$$MEDPrescriptionDueTimeSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",15).set(_setval.get());
  }

  //<< #define FldMEDPrescriptionDueTime 15
  public static Object $$$FldMEDPrescriptionDueTime(mContext m$) {
    return (15);
  }

  //<< #define StrMEDPrescriptionDueTime $$GetPropertyName^COMConst("MEDPrescription",15)
  public static Object $$$StrMEDPrescriptionDueTime(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDPrescription",15));
  }

  //<< #define MEDPrescriptionPatientSurname(%obj) $piece(%obj,"~",16)
  public static Object $$$MEDPrescriptionPatientSurname(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",16));
  }

  public static void $$$MEDPrescriptionPatientSurnameSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",16).set(_setval.get());
  }

  //<< #define FldMEDPrescriptionPatientSurname 16
  public static Object $$$FldMEDPrescriptionPatientSurname(mContext m$) {
    return (16);
  }

  //<< #define StrMEDPrescriptionPatientSurname $$GetPropertyName^COMConst("MEDPrescription",16)
  public static Object $$$StrMEDPrescriptionPatientSurname(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDPrescription",16));
  }

  //<< #define MEDPrescriptionPatientOtherNames(%obj) $piece(%obj,"~",17)
  public static Object $$$MEDPrescriptionPatientOtherNames(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",17));
  }

  public static void $$$MEDPrescriptionPatientOtherNamesSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",17).set(_setval.get());
  }

  //<< #define FldMEDPrescriptionPatientOtherNames 17
  public static Object $$$FldMEDPrescriptionPatientOtherNames(mContext m$) {
    return (17);
  }

  //<< #define StrMEDPrescriptionPatientOtherNames $$GetPropertyName^COMConst("MEDPrescription",17)
  public static Object $$$StrMEDPrescriptionPatientOtherNames(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDPrescription",17));
  }

  //<< #define MEDPrescriptionPatientBirthDate(%obj) $piece(%obj,"~",18)
  public static Object $$$MEDPrescriptionPatientBirthDate(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",18));
  }

  public static void $$$MEDPrescriptionPatientBirthDateSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",18).set(_setval.get());
  }

  //<< #define FldMEDPrescriptionPatientBirthDate 18
  public static Object $$$FldMEDPrescriptionPatientBirthDate(mContext m$) {
    return (18);
  }

  //<< #define StrMEDPrescriptionPatientBirthDate $$GetPropertyName^COMConst("MEDPrescription",18)
  public static Object $$$StrMEDPrescriptionPatientBirthDate(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDPrescription",18));
  }

  //<< #define MEDPrescriptionPatientAddress(%obj) $piece(%obj,"~",19)
  public static Object $$$MEDPrescriptionPatientAddress(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",19));
  }

  public static void $$$MEDPrescriptionPatientAddressSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",19).set(_setval.get());
  }

  //<< #define FldMEDPrescriptionPatientAddress 19
  public static Object $$$FldMEDPrescriptionPatientAddress(mContext m$) {
    return (19);
  }

  //<< #define StrMEDPrescriptionPatientAddress $$GetPropertyName^COMConst("MEDPrescription",19)
  public static Object $$$StrMEDPrescriptionPatientAddress(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDPrescription",19));
  }

  //<< #define MEDPrescriptionReasonForAdmission(%obj) $piece(%obj,"~",20)
  public static Object $$$MEDPrescriptionReasonForAdmission(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",20));
  }

  public static void $$$MEDPrescriptionReasonForAdmissionSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",20).set(_setval.get());
  }

  //<< #define FldMEDPrescriptionReasonForAdmission 20
  public static Object $$$FldMEDPrescriptionReasonForAdmission(mContext m$) {
    return (20);
  }

  //<< #define StrMEDPrescriptionReasonForAdmission $$GetPropertyName^COMConst("MEDPrescription",20)
  public static Object $$$StrMEDPrescriptionReasonForAdmission(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDPrescription",20));
  }

  //<< #define MEDPrescriptionAdmittingLocn(%obj) $piece(%obj,"~",21)
  public static Object $$$MEDPrescriptionAdmittingLocn(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",21));
  }

  public static void $$$MEDPrescriptionAdmittingLocnSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",21).set(_setval.get());
  }

  //<< #define FldMEDPrescriptionAdmittingLocn 21
  public static Object $$$FldMEDPrescriptionAdmittingLocn(mContext m$) {
    return (21);
  }

  //<< #define StrMEDPrescriptionAdmittingLocn $$GetPropertyName^COMConst("MEDPrescription",21)
  public static Object $$$StrMEDPrescriptionAdmittingLocn(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDPrescription",21));
  }

  //<< #define MEDPrescriptionTransportationMethod(%obj) $piece(%obj,"~",22)
  public static Object $$$MEDPrescriptionTransportationMethod(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",22));
  }

  public static void $$$MEDPrescriptionTransportationMethodSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",22).set(_setval.get());
  }

  //<< #define FldMEDPrescriptionTransportationMethod 22
  public static Object $$$FldMEDPrescriptionTransportationMethod(mContext m$) {
    return (22);
  }

  //<< #define StrMEDPrescriptionTransportationMethod $$GetPropertyName^COMConst("MEDPrescription",22)
  public static Object $$$StrMEDPrescriptionTransportationMethod(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDPrescription",22));
  }

  //<< #define MEDPrescriptionHoldScriptInPharmacy(%obj) $piece(%obj,"~",23)
  public static Object $$$MEDPrescriptionHoldScriptInPharmacy(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",23));
  }

  public static void $$$MEDPrescriptionHoldScriptInPharmacySet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",23).set(_setval.get());
  }

  //<< #define FldMEDPrescriptionHoldScriptInPharmacy 23
  public static Object $$$FldMEDPrescriptionHoldScriptInPharmacy(mContext m$) {
    return (23);
  }

  //<< #define StrMEDPrescriptionHoldScriptInPharmacy $$GetPropertyName^COMConst("MEDPrescription",23)
  public static Object $$$StrMEDPrescriptionHoldScriptInPharmacy(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDPrescription",23));
  }

  //<< #define MEDPrescriptionPharmacist(%obj) $piece(%obj,"~",24)
  public static Object $$$MEDPrescriptionPharmacist(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",24));
  }

  public static void $$$MEDPrescriptionPharmacistSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",24).set(_setval.get());
  }

  //<< #define FldMEDPrescriptionPharmacist 24
  public static Object $$$FldMEDPrescriptionPharmacist(mContext m$) {
    return (24);
  }

  //<< #define StrMEDPrescriptionPharmacist $$GetPropertyName^COMConst("MEDPrescription",24)
  public static Object $$$StrMEDPrescriptionPharmacist(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDPrescription",24));
  }

  //<< #define MEDPrescriptionRepeatsDispensed(%obj) $piece(%obj,"~",25)
  public static Object $$$MEDPrescriptionRepeatsDispensed(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",25));
  }

  public static void $$$MEDPrescriptionRepeatsDispensedSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",25).set(_setval.get());
  }

  //<< #define FldMEDPrescriptionRepeatsDispensed 25
  public static Object $$$FldMEDPrescriptionRepeatsDispensed(mContext m$) {
    return (25);
  }

  //<< #define StrMEDPrescriptionRepeatsDispensed $$GetPropertyName^COMConst("MEDPrescription",25)
  public static Object $$$StrMEDPrescriptionRepeatsDispensed(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDPrescription",25));
  }

  //<< #define MEDPrescriptionCreatedBy(%obj) $piece(%obj,"~",26)
  public static Object $$$MEDPrescriptionCreatedBy(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",26));
  }

  public static void $$$MEDPrescriptionCreatedBySet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",26).set(_setval.get());
  }

  //<< #define FldMEDPrescriptionCreatedBy 26
  public static Object $$$FldMEDPrescriptionCreatedBy(mContext m$) {
    return (26);
  }

  //<< #define StrMEDPrescriptionCreatedBy $$GetPropertyName^COMConst("MEDPrescription",26)
  public static Object $$$StrMEDPrescriptionCreatedBy(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDPrescription",26));
  }

  //<< #define MEDPrescriptionChangedOn(%obj) $piece(%obj,"~",27)
  public static Object $$$MEDPrescriptionChangedOn(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",27));
  }

  public static void $$$MEDPrescriptionChangedOnSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",27).set(_setval.get());
  }

  //<< #define FldMEDPrescriptionChangedOn 27
  public static Object $$$FldMEDPrescriptionChangedOn(mContext m$) {
    return (27);
  }

  //<< #define StrMEDPrescriptionChangedOn $$GetPropertyName^COMConst("MEDPrescription",27)
  public static Object $$$StrMEDPrescriptionChangedOn(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDPrescription",27));
  }

  //<< #define MEDPrescriptionChangedBy(%obj) $piece(%obj,"~",28)
  public static Object $$$MEDPrescriptionChangedBy(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",28));
  }

  public static void $$$MEDPrescriptionChangedBySet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",28).set(_setval.get());
  }

  //<< #define FldMEDPrescriptionChangedBy 28
  public static Object $$$FldMEDPrescriptionChangedBy(mContext m$) {
    return (28);
  }

  //<< #define StrMEDPrescriptionChangedBy $$GetPropertyName^COMConst("MEDPrescription",28)
  public static Object $$$StrMEDPrescriptionChangedBy(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDPrescription",28));
  }

  //<< #define MEDPrescriptionCreatedOn(%obj) $piece(%obj,"~",29)
  public static Object $$$MEDPrescriptionCreatedOn(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",29));
  }

  public static void $$$MEDPrescriptionCreatedOnSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",29).set(_setval.get());
  }

  //<< #define FldMEDPrescriptionCreatedOn 29
  public static Object $$$FldMEDPrescriptionCreatedOn(mContext m$) {
    return (29);
  }

  //<< #define StrMEDPrescriptionCreatedOn $$GetPropertyName^COMConst("MEDPrescription",29)
  public static Object $$$StrMEDPrescriptionCreatedOn(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDPrescription",29));
  }

  //<< #define MEDPrescriptionLastIssued(%obj) $piece(%obj,"~",30)
  public static Object $$$MEDPrescriptionLastIssued(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",30));
  }

  public static void $$$MEDPrescriptionLastIssuedSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",30).set(_setval.get());
  }

  //<< #define FldMEDPrescriptionLastIssued 30
  public static Object $$$FldMEDPrescriptionLastIssued(mContext m$) {
    return (30);
  }

  //<< #define StrMEDPrescriptionLastIssued $$GetPropertyName^COMConst("MEDPrescription",30)
  public static Object $$$StrMEDPrescriptionLastIssued(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDPrescription",30));
  }

  //<< #define MEDPrescriptionAuthorizedPerson(%obj) $piece(%obj,"~",31)
  public static Object $$$MEDPrescriptionAuthorizedPerson(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",31));
  }

  public static void $$$MEDPrescriptionAuthorizedPersonSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",31).set(_setval.get());
  }

  //<< #define FldMEDPrescriptionAuthorizedPerson 31
  public static Object $$$FldMEDPrescriptionAuthorizedPerson(mContext m$) {
    return (31);
  }

  //<< #define StrMEDPrescriptionAuthorizedPerson $$GetPropertyName^COMConst("MEDPrescription",31)
  public static Object $$$StrMEDPrescriptionAuthorizedPerson(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDPrescription",31));
  }

  //<< #define MEDPrescriptionFREE1(%obj) $piece(%obj,"~",32)
  public static Object $$$MEDPrescriptionFREE1(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",32));
  }

  public static void $$$MEDPrescriptionFREE1Set(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",32).set(_setval.get());
  }

  //<< #define FldMEDPrescriptionFREE1 32
  public static Object $$$FldMEDPrescriptionFREE1(mContext m$) {
    return (32);
  }

  //<< #define StrMEDPrescriptionFREE1 $$GetPropertyName^COMConst("MEDPrescription",32)
  public static Object $$$StrMEDPrescriptionFREE1(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDPrescription",32));
  }

  //<< #define MEDPrescriptionFREE2(%obj) $piece(%obj,"~",33)
  public static Object $$$MEDPrescriptionFREE2(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",33));
  }

  public static void $$$MEDPrescriptionFREE2Set(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",33).set(_setval.get());
  }

  //<< #define FldMEDPrescriptionFREE2 33
  public static Object $$$FldMEDPrescriptionFREE2(mContext m$) {
    return (33);
  }

  //<< #define StrMEDPrescriptionFREE2 $$GetPropertyName^COMConst("MEDPrescription",33)
  public static Object $$$StrMEDPrescriptionFREE2(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDPrescription",33));
  }

  //<< #define MEDPrescriptionFREE3(%obj) $piece(%obj,"~",34)
  public static Object $$$MEDPrescriptionFREE3(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",34));
  }

  public static void $$$MEDPrescriptionFREE3Set(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",34).set(_setval.get());
  }

  //<< #define FldMEDPrescriptionFREE3 34
  public static Object $$$FldMEDPrescriptionFREE3(mContext m$) {
    return (34);
  }

  //<< #define StrMEDPrescriptionFREE3 $$GetPropertyName^COMConst("MEDPrescription",34)
  public static Object $$$StrMEDPrescriptionFREE3(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDPrescription",34));
  }

  //<< #define MEDPrescriptionFREE4(%obj) $piece(%obj,"~",35)
  public static Object $$$MEDPrescriptionFREE4(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",35));
  }

  public static void $$$MEDPrescriptionFREE4Set(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",35).set(_setval.get());
  }

  //<< #define FldMEDPrescriptionFREE4 35
  public static Object $$$FldMEDPrescriptionFREE4(mContext m$) {
    return (35);
  }

  //<< #define StrMEDPrescriptionFREE4 $$GetPropertyName^COMConst("MEDPrescription",35)
  public static Object $$$StrMEDPrescriptionFREE4(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDPrescription",35));
  }

  //<< #define MEDPrescriptionFREE5(%obj) $piece(%obj,"~",36)
  public static Object $$$MEDPrescriptionFREE5(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",36));
  }

  public static void $$$MEDPrescriptionFREE5Set(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",36).set(_setval.get());
  }

  //<< #define FldMEDPrescriptionFREE5 36
  public static Object $$$FldMEDPrescriptionFREE5(mContext m$) {
    return (36);
  }

  //<< #define StrMEDPrescriptionFREE5 $$GetPropertyName^COMConst("MEDPrescription",36)
  public static Object $$$StrMEDPrescriptionFREE5(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDPrescription",36));
  }

  //<< #define MEDPrescriptionFREE6(%obj) $piece(%obj,"~",37)
  public static Object $$$MEDPrescriptionFREE6(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",37));
  }

  public static void $$$MEDPrescriptionFREE6Set(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",37).set(_setval.get());
  }

  //<< #define FldMEDPrescriptionFREE6 37
  public static Object $$$FldMEDPrescriptionFREE6(mContext m$) {
    return (37);
  }

  //<< #define StrMEDPrescriptionFREE6 $$GetPropertyName^COMConst("MEDPrescription",37)
  public static Object $$$StrMEDPrescriptionFREE6(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDPrescription",37));
  }

  //<< #define MEDPrescriptionFREE7(%obj) $piece(%obj,"~",38)
  public static Object $$$MEDPrescriptionFREE7(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",38));
  }

  public static void $$$MEDPrescriptionFREE7Set(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",38).set(_setval.get());
  }

  //<< #define FldMEDPrescriptionFREE7 38
  public static Object $$$FldMEDPrescriptionFREE7(mContext m$) {
    return (38);
  }

  //<< #define StrMEDPrescriptionFREE7 $$GetPropertyName^COMConst("MEDPrescription",38)
  public static Object $$$StrMEDPrescriptionFREE7(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDPrescription",38));
  }

  //<< #define MEDPrescriptionFREE8(%obj) $piece(%obj,"~",39)
  public static Object $$$MEDPrescriptionFREE8(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",39));
  }

  public static void $$$MEDPrescriptionFREE8Set(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",39).set(_setval.get());
  }

  //<< #define FldMEDPrescriptionFREE8 39
  public static Object $$$FldMEDPrescriptionFREE8(mContext m$) {
    return (39);
  }

  //<< #define StrMEDPrescriptionFREE8 $$GetPropertyName^COMConst("MEDPrescription",39)
  public static Object $$$StrMEDPrescriptionFREE8(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDPrescription",39));
  }

  //<< #define MEDPrescriptionFREE9(%obj) $piece(%obj,"~",40)
  public static Object $$$MEDPrescriptionFREE9(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",40));
  }

  public static void $$$MEDPrescriptionFREE9Set(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",40).set(_setval.get());
  }

  //<< #define FldMEDPrescriptionFREE9 40
  public static Object $$$FldMEDPrescriptionFREE9(mContext m$) {
    return (40);
  }

  //<< #define StrMEDPrescriptionFREE9 $$GetPropertyName^COMConst("MEDPrescription",40)
  public static Object $$$StrMEDPrescriptionFREE9(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDPrescription",40));
  }

  //<< #define MEDPrescriptionFREE10(%obj) $piece(%obj,"~",41)
  public static Object $$$MEDPrescriptionFREE10(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",41));
  }

  public static void $$$MEDPrescriptionFREE10Set(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",41).set(_setval.get());
  }

  //<< #define FldMEDPrescriptionFREE10 41
  public static Object $$$FldMEDPrescriptionFREE10(mContext m$) {
    return (41);
  }

  //<< #define StrMEDPrescriptionFREE10 $$GetPropertyName^COMConst("MEDPrescription",41)
  public static Object $$$StrMEDPrescriptionFREE10(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDPrescription",41));
  }

  //<< #define MEDPrescriptionIssuingLocation(%obj) $piece(%obj,"~",42)
  public static Object $$$MEDPrescriptionIssuingLocation(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",42));
  }

  public static void $$$MEDPrescriptionIssuingLocationSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",42).set(_setval.get());
  }

  //<< #define FldMEDPrescriptionIssuingLocation 42
  public static Object $$$FldMEDPrescriptionIssuingLocation(mContext m$) {
    return (42);
  }

  //<< #define StrMEDPrescriptionIssuingLocation $$GetPropertyName^COMConst("MEDPrescription",42)
  public static Object $$$StrMEDPrescriptionIssuingLocation(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDPrescription",42));
  }

  //<< #define MEDPrescriptionPickPrinted(%obj) $piece(%obj,"~",43)
  public static Object $$$MEDPrescriptionPickPrinted(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",43));
  }

  public static void $$$MEDPrescriptionPickPrintedSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",43).set(_setval.get());
  }

  //<< #define FldMEDPrescriptionPickPrinted 43
  public static Object $$$FldMEDPrescriptionPickPrinted(mContext m$) {
    return (43);
  }

  //<< #define StrMEDPrescriptionPickPrinted $$GetPropertyName^COMConst("MEDPrescription",43)
  public static Object $$$StrMEDPrescriptionPickPrinted(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDPrescription",43));
  }

  //<< #define FldMEDPrescriptionPrescriptionNumber 1
  public static Object $$$FldMEDPrescriptionPrescriptionNumber(mContext m$) {
    return (1);
  }

  //<< #define StrMEDPrescriptionPrescriptionNumber $$GetPropertyName^COMConst("MEDPrescription",,1)
  public static Object $$$StrMEDPrescriptionPrescriptionNumber(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDPrescription",null,1));
  }

  //<< 
  //<< #define FldMEDPrescriptionIssueCompany1 1
  public static Object $$$FldMEDPrescriptionIssueCompany1(mContext m$) {
    return (1);
  }

  //<< #define StrMEDPrescriptionIssueCompany1 $$GetPropertyName^COMConst("MEDPrescriptionIssue",,1)
  public static Object $$$StrMEDPrescriptionIssueCompany1(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDPrescriptionIssue",null,1));
  }

  //<< 
  //<< #define MEDPrescriptionLineItem(%obj) $piece(%obj,"~",1)
  public static Object $$$MEDPrescriptionLineItem(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",1));
  }

  public static void $$$MEDPrescriptionLineItemSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",1).set(_setval.get());
  }

  //<< #define FldMEDPrescriptionLineItem 1
  public static Object $$$FldMEDPrescriptionLineItem(mContext m$) {
    return (1);
  }

  //<< #define StrMEDPrescriptionLineItem $$GetPropertyName^COMConst("MEDPrescriptionLine",1)
  public static Object $$$StrMEDPrescriptionLineItem(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDPrescriptionLine",1));
  }

  //<< #define MEDPrescriptionLineItemName(%obj) $piece(%obj,"~",2)
  public static Object $$$MEDPrescriptionLineItemName(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",2));
  }

  public static void $$$MEDPrescriptionLineItemNameSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",2).set(_setval.get());
  }

  //<< #define FldMEDPrescriptionLineItemName 2
  public static Object $$$FldMEDPrescriptionLineItemName(mContext m$) {
    return (2);
  }

  //<< #define StrMEDPrescriptionLineItemName $$GetPropertyName^COMConst("MEDPrescriptionLine",2)
  public static Object $$$StrMEDPrescriptionLineItemName(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDPrescriptionLine",2));
  }

  //<< #define MEDPrescriptionLineDoseQty(%obj) $piece(%obj,"~",3)
  public static Object $$$MEDPrescriptionLineDoseQty(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",3));
  }

  public static void $$$MEDPrescriptionLineDoseQtySet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",3).set(_setval.get());
  }

  //<< #define FldMEDPrescriptionLineDoseQty 3
  public static Object $$$FldMEDPrescriptionLineDoseQty(mContext m$) {
    return (3);
  }

  //<< #define StrMEDPrescriptionLineDoseQty $$GetPropertyName^COMConst("MEDPrescriptionLine",3)
  public static Object $$$StrMEDPrescriptionLineDoseQty(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDPrescriptionLine",3));
  }

  //<< #define MEDPrescriptionLineDoseUOM(%obj) $piece(%obj,"~",4)
  public static Object $$$MEDPrescriptionLineDoseUOM(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",4));
  }

  public static void $$$MEDPrescriptionLineDoseUOMSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",4).set(_setval.get());
  }

  //<< #define FldMEDPrescriptionLineDoseUOM 4
  public static Object $$$FldMEDPrescriptionLineDoseUOM(mContext m$) {
    return (4);
  }

  //<< #define StrMEDPrescriptionLineDoseUOM $$GetPropertyName^COMConst("MEDPrescriptionLine",4)
  public static Object $$$StrMEDPrescriptionLineDoseUOM(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDPrescriptionLine",4));
  }

  //<< #define MEDPrescriptionLineFrequency(%obj) $piece(%obj,"~",5)
  public static Object $$$MEDPrescriptionLineFrequency(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",5));
  }

  public static void $$$MEDPrescriptionLineFrequencySet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",5).set(_setval.get());
  }

  //<< #define FldMEDPrescriptionLineFrequency 5
  public static Object $$$FldMEDPrescriptionLineFrequency(mContext m$) {
    return (5);
  }

  //<< #define StrMEDPrescriptionLineFrequency $$GetPropertyName^COMConst("MEDPrescriptionLine",5)
  public static Object $$$StrMEDPrescriptionLineFrequency(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDPrescriptionLine",5));
  }

  //<< #define MEDPrescriptionLineDuration(%obj) $piece(%obj,"~",6)
  public static Object $$$MEDPrescriptionLineDuration(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",6));
  }

  public static void $$$MEDPrescriptionLineDurationSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",6).set(_setval.get());
  }

  //<< #define FldMEDPrescriptionLineDuration 6
  public static Object $$$FldMEDPrescriptionLineDuration(mContext m$) {
    return (6);
  }

  //<< #define StrMEDPrescriptionLineDuration $$GetPropertyName^COMConst("MEDPrescriptionLine",6)
  public static Object $$$StrMEDPrescriptionLineDuration(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDPrescriptionLine",6));
  }

  //<< #define MEDPrescriptionLineDoseTotalQuantity(%obj) $piece(%obj,"~",7)
  public static Object $$$MEDPrescriptionLineDoseTotalQuantity(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",7));
  }

  public static void $$$MEDPrescriptionLineDoseTotalQuantitySet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",7).set(_setval.get());
  }

  //<< #define FldMEDPrescriptionLineDoseTotalQuantity 7
  public static Object $$$FldMEDPrescriptionLineDoseTotalQuantity(mContext m$) {
    return (7);
  }

  //<< #define StrMEDPrescriptionLineDoseTotalQuantity $$GetPropertyName^COMConst("MEDPrescriptionLine",7)
  public static Object $$$StrMEDPrescriptionLineDoseTotalQuantity(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDPrescriptionLine",7));
  }

  //<< #define MEDPrescriptionLineInformationRequired(%obj) $piece(%obj,"~",8)
  public static Object $$$MEDPrescriptionLineInformationRequired(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",8));
  }

  public static void $$$MEDPrescriptionLineInformationRequiredSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",8).set(_setval.get());
  }

  //<< #define FldMEDPrescriptionLineInformationRequired 8
  public static Object $$$FldMEDPrescriptionLineInformationRequired(mContext m$) {
    return (8);
  }

  //<< #define StrMEDPrescriptionLineInformationRequired $$GetPropertyName^COMConst("MEDPrescriptionLine",8)
  public static Object $$$StrMEDPrescriptionLineInformationRequired(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDPrescriptionLine",8));
  }

  //<< #define MEDPrescriptionLineNotes(%obj) $piece(%obj,"~",9)
  public static Object $$$MEDPrescriptionLineNotes(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",9));
  }

  public static void $$$MEDPrescriptionLineNotesSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",9).set(_setval.get());
  }

  //<< #define FldMEDPrescriptionLineNotes 9
  public static Object $$$FldMEDPrescriptionLineNotes(mContext m$) {
    return (9);
  }

  //<< #define StrMEDPrescriptionLineNotes $$GetPropertyName^COMConst("MEDPrescriptionLine",9)
  public static Object $$$StrMEDPrescriptionLineNotes(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDPrescriptionLine",9));
  }

  //<< #define MEDPrescriptionLineIndication(%obj) $piece(%obj,"~",10)
  public static Object $$$MEDPrescriptionLineIndication(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",10));
  }

  public static void $$$MEDPrescriptionLineIndicationSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",10).set(_setval.get());
  }

  //<< #define FldMEDPrescriptionLineIndication 10
  public static Object $$$FldMEDPrescriptionLineIndication(mContext m$) {
    return (10);
  }

  //<< #define StrMEDPrescriptionLineIndication $$GetPropertyName^COMConst("MEDPrescriptionLine",10)
  public static Object $$$StrMEDPrescriptionLineIndication(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDPrescriptionLine",10));
  }

  //<< #define MEDPrescriptionLineStrength(%obj) $piece(%obj,"~",11)
  public static Object $$$MEDPrescriptionLineStrength(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",11));
  }

  public static void $$$MEDPrescriptionLineStrengthSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",11).set(_setval.get());
  }

  //<< #define FldMEDPrescriptionLineStrength 11
  public static Object $$$FldMEDPrescriptionLineStrength(mContext m$) {
    return (11);
  }

  //<< #define StrMEDPrescriptionLineStrength $$GetPropertyName^COMConst("MEDPrescriptionLine",11)
  public static Object $$$StrMEDPrescriptionLineStrength(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDPrescriptionLine",11));
  }

  //<< #define MEDPrescriptionLineFormulation(%obj) $piece(%obj,"~",12)
  public static Object $$$MEDPrescriptionLineFormulation(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",12));
  }

  public static void $$$MEDPrescriptionLineFormulationSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",12).set(_setval.get());
  }

  //<< #define FldMEDPrescriptionLineFormulation 12
  public static Object $$$FldMEDPrescriptionLineFormulation(mContext m$) {
    return (12);
  }

  //<< #define StrMEDPrescriptionLineFormulation $$GetPropertyName^COMConst("MEDPrescriptionLine",12)
  public static Object $$$StrMEDPrescriptionLineFormulation(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDPrescriptionLine",12));
  }

  //<< #define MEDPrescriptionLineRouteOfAdministration(%obj) $piece(%obj,"~",13)
  public static Object $$$MEDPrescriptionLineRouteOfAdministration(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",13));
  }

  public static void $$$MEDPrescriptionLineRouteOfAdministrationSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",13).set(_setval.get());
  }

  //<< #define FldMEDPrescriptionLineRouteOfAdministration 13
  public static Object $$$FldMEDPrescriptionLineRouteOfAdministration(mContext m$) {
    return (13);
  }

  //<< #define StrMEDPrescriptionLineRouteOfAdministration $$GetPropertyName^COMConst("MEDPrescriptionLine",13)
  public static Object $$$StrMEDPrescriptionLineRouteOfAdministration(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDPrescriptionLine",13));
  }

  //<< #define MEDPrescriptionLineDispenseQuantity(%obj) $piece(%obj,"~",14)
  public static Object $$$MEDPrescriptionLineDispenseQuantity(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",14));
  }

  public static void $$$MEDPrescriptionLineDispenseQuantitySet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",14).set(_setval.get());
  }

  //<< #define FldMEDPrescriptionLineDispenseQuantity 14
  public static Object $$$FldMEDPrescriptionLineDispenseQuantity(mContext m$) {
    return (14);
  }

  //<< #define StrMEDPrescriptionLineDispenseQuantity $$GetPropertyName^COMConst("MEDPrescriptionLine",14)
  public static Object $$$StrMEDPrescriptionLineDispenseQuantity(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDPrescriptionLine",14));
  }

  //<< #define MEDPrescriptionLineDispenseUOM(%obj) $piece(%obj,"~",15)
  public static Object $$$MEDPrescriptionLineDispenseUOM(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",15));
  }

  public static void $$$MEDPrescriptionLineDispenseUOMSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",15).set(_setval.get());
  }

  //<< #define FldMEDPrescriptionLineDispenseUOM 15
  public static Object $$$FldMEDPrescriptionLineDispenseUOM(mContext m$) {
    return (15);
  }

  //<< #define StrMEDPrescriptionLineDispenseUOM $$GetPropertyName^COMConst("MEDPrescriptionLine",15)
  public static Object $$$StrMEDPrescriptionLineDispenseUOM(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDPrescriptionLine",15));
  }

  //<< #define MEDPrescriptionLineDispenseTotQty(%obj) $piece(%obj,"~",16)
  public static Object $$$MEDPrescriptionLineDispenseTotQty(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",16));
  }

  public static void $$$MEDPrescriptionLineDispenseTotQtySet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",16).set(_setval.get());
  }

  //<< #define FldMEDPrescriptionLineDispenseTotQty 16
  public static Object $$$FldMEDPrescriptionLineDispenseTotQty(mContext m$) {
    return (16);
  }

  //<< #define StrMEDPrescriptionLineDispenseTotQty $$GetPropertyName^COMConst("MEDPrescriptionLine",16)
  public static Object $$$StrMEDPrescriptionLineDispenseTotQty(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDPrescriptionLine",16));
  }

  //<< #define MEDPrescriptionLineDispensedQty(%obj) $piece(%obj,"~",17)
  public static Object $$$MEDPrescriptionLineDispensedQty(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",17));
  }

  public static void $$$MEDPrescriptionLineDispensedQtySet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",17).set(_setval.get());
  }

  //<< #define FldMEDPrescriptionLineDispensedQty 17
  public static Object $$$FldMEDPrescriptionLineDispensedQty(mContext m$) {
    return (17);
  }

  //<< #define StrMEDPrescriptionLineDispensedQty $$GetPropertyName^COMConst("MEDPrescriptionLine",17)
  public static Object $$$StrMEDPrescriptionLineDispensedQty(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDPrescriptionLine",17));
  }

  //<< #define MEDPrescriptionLineFREE1(%obj) $piece(%obj,"~",18)
  public static Object $$$MEDPrescriptionLineFREE1(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",18));
  }

  public static void $$$MEDPrescriptionLineFREE1Set(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",18).set(_setval.get());
  }

  //<< #define FldMEDPrescriptionLineFREE1 18
  public static Object $$$FldMEDPrescriptionLineFREE1(mContext m$) {
    return (18);
  }

  //<< #define StrMEDPrescriptionLineFREE1 $$GetPropertyName^COMConst("MEDPrescriptionLine",18)
  public static Object $$$StrMEDPrescriptionLineFREE1(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDPrescriptionLine",18));
  }

  //<< #define MEDPrescriptionLineFREE2(%obj) $piece(%obj,"~",19)
  public static Object $$$MEDPrescriptionLineFREE2(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",19));
  }

  public static void $$$MEDPrescriptionLineFREE2Set(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",19).set(_setval.get());
  }

  //<< #define FldMEDPrescriptionLineFREE2 19
  public static Object $$$FldMEDPrescriptionLineFREE2(mContext m$) {
    return (19);
  }

  //<< #define StrMEDPrescriptionLineFREE2 $$GetPropertyName^COMConst("MEDPrescriptionLine",19)
  public static Object $$$StrMEDPrescriptionLineFREE2(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDPrescriptionLine",19));
  }

  //<< #define MEDPrescriptionLineFREE3(%obj) $piece(%obj,"~",20)
  public static Object $$$MEDPrescriptionLineFREE3(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",20));
  }

  public static void $$$MEDPrescriptionLineFREE3Set(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",20).set(_setval.get());
  }

  //<< #define FldMEDPrescriptionLineFREE3 20
  public static Object $$$FldMEDPrescriptionLineFREE3(mContext m$) {
    return (20);
  }

  //<< #define StrMEDPrescriptionLineFREE3 $$GetPropertyName^COMConst("MEDPrescriptionLine",20)
  public static Object $$$StrMEDPrescriptionLineFREE3(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDPrescriptionLine",20));
  }

  //<< #define MEDPrescriptionLineFREE4(%obj) $piece(%obj,"~",21)
  public static Object $$$MEDPrescriptionLineFREE4(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",21));
  }

  public static void $$$MEDPrescriptionLineFREE4Set(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",21).set(_setval.get());
  }

  //<< #define FldMEDPrescriptionLineFREE4 21
  public static Object $$$FldMEDPrescriptionLineFREE4(mContext m$) {
    return (21);
  }

  //<< #define StrMEDPrescriptionLineFREE4 $$GetPropertyName^COMConst("MEDPrescriptionLine",21)
  public static Object $$$StrMEDPrescriptionLineFREE4(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDPrescriptionLine",21));
  }

  //<< #define MEDPrescriptionLineFREE5(%obj) $piece(%obj,"~",22)
  public static Object $$$MEDPrescriptionLineFREE5(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",22));
  }

  public static void $$$MEDPrescriptionLineFREE5Set(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",22).set(_setval.get());
  }

  //<< #define FldMEDPrescriptionLineFREE5 22
  public static Object $$$FldMEDPrescriptionLineFREE5(mContext m$) {
    return (22);
  }

  //<< #define StrMEDPrescriptionLineFREE5 $$GetPropertyName^COMConst("MEDPrescriptionLine",22)
  public static Object $$$StrMEDPrescriptionLineFREE5(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDPrescriptionLine",22));
  }

  //<< #define MEDPrescriptionLineFREE6(%obj) $piece(%obj,"~",23)
  public static Object $$$MEDPrescriptionLineFREE6(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",23));
  }

  public static void $$$MEDPrescriptionLineFREE6Set(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",23).set(_setval.get());
  }

  //<< #define FldMEDPrescriptionLineFREE6 23
  public static Object $$$FldMEDPrescriptionLineFREE6(mContext m$) {
    return (23);
  }

  //<< #define StrMEDPrescriptionLineFREE6 $$GetPropertyName^COMConst("MEDPrescriptionLine",23)
  public static Object $$$StrMEDPrescriptionLineFREE6(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDPrescriptionLine",23));
  }

  //<< #define MEDPrescriptionLineFREE7(%obj) $piece(%obj,"~",24)
  public static Object $$$MEDPrescriptionLineFREE7(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",24));
  }

  public static void $$$MEDPrescriptionLineFREE7Set(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",24).set(_setval.get());
  }

  //<< #define FldMEDPrescriptionLineFREE7 24
  public static Object $$$FldMEDPrescriptionLineFREE7(mContext m$) {
    return (24);
  }

  //<< #define StrMEDPrescriptionLineFREE7 $$GetPropertyName^COMConst("MEDPrescriptionLine",24)
  public static Object $$$StrMEDPrescriptionLineFREE7(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDPrescriptionLine",24));
  }

  //<< #define MEDPrescriptionLineFREE8(%obj) $piece(%obj,"~",25)
  public static Object $$$MEDPrescriptionLineFREE8(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",25));
  }

  public static void $$$MEDPrescriptionLineFREE8Set(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",25).set(_setval.get());
  }

  //<< #define FldMEDPrescriptionLineFREE8 25
  public static Object $$$FldMEDPrescriptionLineFREE8(mContext m$) {
    return (25);
  }

  //<< #define StrMEDPrescriptionLineFREE8 $$GetPropertyName^COMConst("MEDPrescriptionLine",25)
  public static Object $$$StrMEDPrescriptionLineFREE8(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDPrescriptionLine",25));
  }

  //<< #define MEDPrescriptionLineFREE9(%obj) $piece(%obj,"~",26)
  public static Object $$$MEDPrescriptionLineFREE9(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",26));
  }

  public static void $$$MEDPrescriptionLineFREE9Set(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",26).set(_setval.get());
  }

  //<< #define FldMEDPrescriptionLineFREE9 26
  public static Object $$$FldMEDPrescriptionLineFREE9(mContext m$) {
    return (26);
  }

  //<< #define StrMEDPrescriptionLineFREE9 $$GetPropertyName^COMConst("MEDPrescriptionLine",26)
  public static Object $$$StrMEDPrescriptionLineFREE9(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDPrescriptionLine",26));
  }

  //<< #define MEDPrescriptionLineFREE10(%obj) $piece(%obj,"~",27)
  public static Object $$$MEDPrescriptionLineFREE10(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",27));
  }

  public static void $$$MEDPrescriptionLineFREE10Set(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",27).set(_setval.get());
  }

  //<< #define FldMEDPrescriptionLineFREE10 27
  public static Object $$$FldMEDPrescriptionLineFREE10(mContext m$) {
    return (27);
  }

  //<< #define StrMEDPrescriptionLineFREE10 $$GetPropertyName^COMConst("MEDPrescriptionLine",27)
  public static Object $$$StrMEDPrescriptionLineFREE10(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDPrescriptionLine",27));
  }

  //<< #define MEDPrescriptionLineFromDate(%obj) $piece(%obj,"~",28)
  public static Object $$$MEDPrescriptionLineFromDate(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",28));
  }

  public static void $$$MEDPrescriptionLineFromDateSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",28).set(_setval.get());
  }

  //<< #define FldMEDPrescriptionLineFromDate 28
  public static Object $$$FldMEDPrescriptionLineFromDate(mContext m$) {
    return (28);
  }

  //<< #define StrMEDPrescriptionLineFromDate $$GetPropertyName^COMConst("MEDPrescriptionLine",28)
  public static Object $$$StrMEDPrescriptionLineFromDate(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDPrescriptionLine",28));
  }

  //<< #define MEDPrescriptionLineFromTime(%obj) $piece(%obj,"~",29)
  public static Object $$$MEDPrescriptionLineFromTime(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",29));
  }

  public static void $$$MEDPrescriptionLineFromTimeSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",29).set(_setval.get());
  }

  //<< #define FldMEDPrescriptionLineFromTime 29
  public static Object $$$FldMEDPrescriptionLineFromTime(mContext m$) {
    return (29);
  }

  //<< #define StrMEDPrescriptionLineFromTime $$GetPropertyName^COMConst("MEDPrescriptionLine",29)
  public static Object $$$StrMEDPrescriptionLineFromTime(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDPrescriptionLine",29));
  }

  //<< #define MEDPrescriptionLineDiluent(%obj) $piece(%obj,"~",30)
  public static Object $$$MEDPrescriptionLineDiluent(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",30));
  }

  public static void $$$MEDPrescriptionLineDiluentSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",30).set(_setval.get());
  }

  //<< #define FldMEDPrescriptionLineDiluent 30
  public static Object $$$FldMEDPrescriptionLineDiluent(mContext m$) {
    return (30);
  }

  //<< #define StrMEDPrescriptionLineDiluent $$GetPropertyName^COMConst("MEDPrescriptionLine",30)
  public static Object $$$StrMEDPrescriptionLineDiluent(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDPrescriptionLine",30));
  }

  //<< #define MEDPrescriptionLineDiluentQty(%obj) $piece(%obj,"~",31)
  public static Object $$$MEDPrescriptionLineDiluentQty(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",31));
  }

  public static void $$$MEDPrescriptionLineDiluentQtySet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",31).set(_setval.get());
  }

  //<< #define FldMEDPrescriptionLineDiluentQty 31
  public static Object $$$FldMEDPrescriptionLineDiluentQty(mContext m$) {
    return (31);
  }

  //<< #define StrMEDPrescriptionLineDiluentQty $$GetPropertyName^COMConst("MEDPrescriptionLine",31)
  public static Object $$$StrMEDPrescriptionLineDiluentQty(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDPrescriptionLine",31));
  }

  //<< #define MEDPrescriptionLineIfNeeded(%obj) $piece(%obj,"~",32)
  public static Object $$$MEDPrescriptionLineIfNeeded(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",32));
  }

  public static void $$$MEDPrescriptionLineIfNeededSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",32).set(_setval.get());
  }

  //<< #define FldMEDPrescriptionLineIfNeeded 32
  public static Object $$$FldMEDPrescriptionLineIfNeeded(mContext m$) {
    return (32);
  }

  //<< #define StrMEDPrescriptionLineIfNeeded $$GetPropertyName^COMConst("MEDPrescriptionLine",32)
  public static Object $$$StrMEDPrescriptionLineIfNeeded(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDPrescriptionLine",32));
  }

  //<< #define MEDPrescriptionLineUrgent(%obj) $piece(%obj,"~",33)
  public static Object $$$MEDPrescriptionLineUrgent(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",33));
  }

  public static void $$$MEDPrescriptionLineUrgentSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",33).set(_setval.get());
  }

  //<< #define FldMEDPrescriptionLineUrgent 33
  public static Object $$$FldMEDPrescriptionLineUrgent(mContext m$) {
    return (33);
  }

  //<< #define StrMEDPrescriptionLineUrgent $$GetPropertyName^COMConst("MEDPrescriptionLine",33)
  public static Object $$$StrMEDPrescriptionLineUrgent(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDPrescriptionLine",33));
  }

  //<< #define MEDPrescriptionLineToDate(%obj) $piece(%obj,"~",34)
  public static Object $$$MEDPrescriptionLineToDate(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",34));
  }

  public static void $$$MEDPrescriptionLineToDateSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",34).set(_setval.get());
  }

  //<< #define FldMEDPrescriptionLineToDate 34
  public static Object $$$FldMEDPrescriptionLineToDate(mContext m$) {
    return (34);
  }

  //<< #define StrMEDPrescriptionLineToDate $$GetPropertyName^COMConst("MEDPrescriptionLine",34)
  public static Object $$$StrMEDPrescriptionLineToDate(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDPrescriptionLine",34));
  }

  //<< #define MEDPrescriptionLineToTime(%obj) $piece(%obj,"~",35)
  public static Object $$$MEDPrescriptionLineToTime(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",35));
  }

  public static void $$$MEDPrescriptionLineToTimeSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",35).set(_setval.get());
  }

  //<< #define FldMEDPrescriptionLineToTime 35
  public static Object $$$FldMEDPrescriptionLineToTime(mContext m$) {
    return (35);
  }

  //<< #define StrMEDPrescriptionLineToTime $$GetPropertyName^COMConst("MEDPrescriptionLine",35)
  public static Object $$$StrMEDPrescriptionLineToTime(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDPrescriptionLine",35));
  }

  //<< #define MEDPrescriptionLineDiagnosis(%obj) $piece(%obj,"~",36)
  public static Object $$$MEDPrescriptionLineDiagnosis(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",36));
  }

  public static void $$$MEDPrescriptionLineDiagnosisSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",36).set(_setval.get());
  }

  //<< #define FldMEDPrescriptionLineDiagnosis 36
  public static Object $$$FldMEDPrescriptionLineDiagnosis(mContext m$) {
    return (36);
  }

  //<< #define StrMEDPrescriptionLineDiagnosis $$GetPropertyName^COMConst("MEDPrescriptionLine",36)
  public static Object $$$StrMEDPrescriptionLineDiagnosis(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDPrescriptionLine",36));
  }

  //<< #define MEDPrescriptionLineContinuous(%obj) $piece(%obj,"~",37)
  public static Object $$$MEDPrescriptionLineContinuous(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",37));
  }

  public static void $$$MEDPrescriptionLineContinuousSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",37).set(_setval.get());
  }

  //<< #define FldMEDPrescriptionLineContinuous 37
  public static Object $$$FldMEDPrescriptionLineContinuous(mContext m$) {
    return (37);
  }

  //<< #define StrMEDPrescriptionLineContinuous $$GetPropertyName^COMConst("MEDPrescriptionLine",37)
  public static Object $$$StrMEDPrescriptionLineContinuous(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDPrescriptionLine",37));
  }

  //<< #define MEDPrescriptionLineInfusionSpeed(%obj) $piece(%obj,"~",38)
  public static Object $$$MEDPrescriptionLineInfusionSpeed(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",38));
  }

  public static void $$$MEDPrescriptionLineInfusionSpeedSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",38).set(_setval.get());
  }

  //<< #define FldMEDPrescriptionLineInfusionSpeed 38
  public static Object $$$FldMEDPrescriptionLineInfusionSpeed(mContext m$) {
    return (38);
  }

  //<< #define StrMEDPrescriptionLineInfusionSpeed $$GetPropertyName^COMConst("MEDPrescriptionLine",38)
  public static Object $$$StrMEDPrescriptionLineInfusionSpeed(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDPrescriptionLine",38));
  }

  //<< #define MEDPrescriptionLineInfusionTime(%obj) $piece(%obj,"~",39)
  public static Object $$$MEDPrescriptionLineInfusionTime(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",39));
  }

  public static void $$$MEDPrescriptionLineInfusionTimeSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",39).set(_setval.get());
  }

  //<< #define FldMEDPrescriptionLineInfusionTime 39
  public static Object $$$FldMEDPrescriptionLineInfusionTime(mContext m$) {
    return (39);
  }

  //<< #define StrMEDPrescriptionLineInfusionTime $$GetPropertyName^COMConst("MEDPrescriptionLine",39)
  public static Object $$$StrMEDPrescriptionLineInfusionTime(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDPrescriptionLine",39));
  }

  //<< #define MEDPrescriptionLineRemarks(%obj) $piece(%obj,"~",40)
  public static Object $$$MEDPrescriptionLineRemarks(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",40));
  }

  public static void $$$MEDPrescriptionLineRemarksSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",40).set(_setval.get());
  }

  //<< #define FldMEDPrescriptionLineRemarks 40
  public static Object $$$FldMEDPrescriptionLineRemarks(mContext m$) {
    return (40);
  }

  //<< #define StrMEDPrescriptionLineRemarks $$GetPropertyName^COMConst("MEDPrescriptionLine",40)
  public static Object $$$StrMEDPrescriptionLineRemarks(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDPrescriptionLine",40));
  }

  //<< #define MEDPrescriptionLineSolution(%obj) $piece(%obj,"~",41)
  public static Object $$$MEDPrescriptionLineSolution(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",41));
  }

  public static void $$$MEDPrescriptionLineSolutionSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",41).set(_setval.get());
  }

  //<< #define FldMEDPrescriptionLineSolution 41
  public static Object $$$FldMEDPrescriptionLineSolution(mContext m$) {
    return (41);
  }

  //<< #define StrMEDPrescriptionLineSolution $$GetPropertyName^COMConst("MEDPrescriptionLine",41)
  public static Object $$$StrMEDPrescriptionLineSolution(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDPrescriptionLine",41));
  }

  //<< #define MEDPrescriptionLineInfusionUnit(%obj) $piece(%obj,"~",42)
  public static Object $$$MEDPrescriptionLineInfusionUnit(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",42));
  }

  public static void $$$MEDPrescriptionLineInfusionUnitSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",42).set(_setval.get());
  }

  //<< #define FldMEDPrescriptionLineInfusionUnit 42
  public static Object $$$FldMEDPrescriptionLineInfusionUnit(mContext m$) {
    return (42);
  }

  //<< #define StrMEDPrescriptionLineInfusionUnit $$GetPropertyName^COMConst("MEDPrescriptionLine",42)
  public static Object $$$StrMEDPrescriptionLineInfusionUnit(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDPrescriptionLine",42));
  }

  //<< #define MEDPrescriptionLineStatus(%obj) $piece(%obj,"~",43)
  public static Object $$$MEDPrescriptionLineStatus(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",43));
  }

  public static void $$$MEDPrescriptionLineStatusSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",43).set(_setval.get());
  }

  //<< #define FldMEDPrescriptionLineStatus 43
  public static Object $$$FldMEDPrescriptionLineStatus(mContext m$) {
    return (43);
  }

  //<< #define StrMEDPrescriptionLineStatus $$GetPropertyName^COMConst("MEDPrescriptionLine",43)
  public static Object $$$StrMEDPrescriptionLineStatus(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDPrescriptionLine",43));
  }

  //<< #define MEDPrescriptionLineInfusionPump(%obj) $piece(%obj,"~",44)
  public static Object $$$MEDPrescriptionLineInfusionPump(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",44));
  }

  public static void $$$MEDPrescriptionLineInfusionPumpSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",44).set(_setval.get());
  }

  //<< #define FldMEDPrescriptionLineInfusionPump 44
  public static Object $$$FldMEDPrescriptionLineInfusionPump(mContext m$) {
    return (44);
  }

  //<< #define StrMEDPrescriptionLineInfusionPump $$GetPropertyName^COMConst("MEDPrescriptionLine",44)
  public static Object $$$StrMEDPrescriptionLineInfusionPump(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDPrescriptionLine",44));
  }

  //<< #define MEDPrescriptionLineInfusionUOM(%obj) $piece(%obj,"~",45)
  public static Object $$$MEDPrescriptionLineInfusionUOM(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",45));
  }

  public static void $$$MEDPrescriptionLineInfusionUOMSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",45).set(_setval.get());
  }

  //<< #define FldMEDPrescriptionLineInfusionUOM 45
  public static Object $$$FldMEDPrescriptionLineInfusionUOM(mContext m$) {
    return (45);
  }

  //<< #define StrMEDPrescriptionLineInfusionUOM $$GetPropertyName^COMConst("MEDPrescriptionLine",45)
  public static Object $$$StrMEDPrescriptionLineInfusionUOM(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDPrescriptionLine",45));
  }

  //<< #define MEDPrescriptionLineDiluentLine(%obj) $piece(%obj,"~",46)
  public static Object $$$MEDPrescriptionLineDiluentLine(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",46));
  }

  public static void $$$MEDPrescriptionLineDiluentLineSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",46).set(_setval.get());
  }

  //<< #define FldMEDPrescriptionLineDiluentLine 46
  public static Object $$$FldMEDPrescriptionLineDiluentLine(mContext m$) {
    return (46);
  }

  //<< #define StrMEDPrescriptionLineDiluentLine $$GetPropertyName^COMConst("MEDPrescriptionLine",46)
  public static Object $$$StrMEDPrescriptionLineDiluentLine(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDPrescriptionLine",46));
  }

  //<< #define MEDPrescriptionLineDiluentUOM(%obj) $piece(%obj,"~",47)
  public static Object $$$MEDPrescriptionLineDiluentUOM(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",47));
  }

  public static void $$$MEDPrescriptionLineDiluentUOMSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",47).set(_setval.get());
  }

  //<< #define FldMEDPrescriptionLineDiluentUOM 47
  public static Object $$$FldMEDPrescriptionLineDiluentUOM(mContext m$) {
    return (47);
  }

  //<< #define StrMEDPrescriptionLineDiluentUOM $$GetPropertyName^COMConst("MEDPrescriptionLine",47)
  public static Object $$$StrMEDPrescriptionLineDiluentUOM(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDPrescriptionLine",47));
  }

  //<< #define MEDPrescriptionLinePRN(%obj) $piece(%obj,"~",48)
  public static Object $$$MEDPrescriptionLinePRN(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",48));
  }

  public static void $$$MEDPrescriptionLinePRNSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",48).set(_setval.get());
  }

  //<< #define FldMEDPrescriptionLinePRN 48
  public static Object $$$FldMEDPrescriptionLinePRN(mContext m$) {
    return (48);
  }

  //<< #define StrMEDPrescriptionLinePRN $$GetPropertyName^COMConst("MEDPrescriptionLine",48)
  public static Object $$$StrMEDPrescriptionLinePRN(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDPrescriptionLine",48));
  }

  //<< #define MEDPrescriptionLineAdministeronly(%obj) $piece(%obj,"~",49)
  public static Object $$$MEDPrescriptionLineAdministeronly(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",49));
  }

  public static void $$$MEDPrescriptionLineAdministeronlySet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",49).set(_setval.get());
  }

  //<< #define FldMEDPrescriptionLineAdministeronly 49
  public static Object $$$FldMEDPrescriptionLineAdministeronly(mContext m$) {
    return (49);
  }

  //<< #define StrMEDPrescriptionLineAdministeronly $$GetPropertyName^COMConst("MEDPrescriptionLine",49)
  public static Object $$$StrMEDPrescriptionLineAdministeronly(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDPrescriptionLine",49));
  }

  //<< #define FldMEDPrescriptionLinePrescriptionNumber 1
  public static Object $$$FldMEDPrescriptionLinePrescriptionNumber(mContext m$) {
    return (1);
  }

  //<< #define StrMEDPrescriptionLinePrescriptionNumber $$GetPropertyName^COMConst("MEDPrescriptionLine",,1)
  public static Object $$$StrMEDPrescriptionLinePrescriptionNumber(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDPrescriptionLine",null,1));
  }

  //<< #define FldMEDPrescriptionLineLine 2
  public static Object $$$FldMEDPrescriptionLineLine(mContext m$) {
    return (2);
  }

  //<< #define StrMEDPrescriptionLineLine $$GetPropertyName^COMConst("MEDPrescriptionLine",,2)
  public static Object $$$StrMEDPrescriptionLineLine(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDPrescriptionLine",null,2));
  }

  //<< 
  //<< #define MEDPrescriptionSetupDiluentCategory(%obj) $piece(%obj,"~",1)
  public static Object $$$MEDPrescriptionSetupDiluentCategory(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",1));
  }

  public static void $$$MEDPrescriptionSetupDiluentCategorySet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",1).set(_setval.get());
  }

  //<< #define FldMEDPrescriptionSetupDiluentCategory 1
  public static Object $$$FldMEDPrescriptionSetupDiluentCategory(mContext m$) {
    return (1);
  }

  //<< #define StrMEDPrescriptionSetupDiluentCategory $$GetPropertyName^COMConst("MEDPrescriptionSetup",1)
  public static Object $$$StrMEDPrescriptionSetupDiluentCategory(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDPrescriptionSetup",1));
  }

  //<< #define MEDPrescriptionSetupIfRequiredColour(%obj) $piece(%obj,"~",2)
  public static Object $$$MEDPrescriptionSetupIfRequiredColour(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",2));
  }

  public static void $$$MEDPrescriptionSetupIfRequiredColourSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",2).set(_setval.get());
  }

  //<< #define FldMEDPrescriptionSetupIfRequiredColour 2
  public static Object $$$FldMEDPrescriptionSetupIfRequiredColour(mContext m$) {
    return (2);
  }

  //<< #define StrMEDPrescriptionSetupIfRequiredColour $$GetPropertyName^COMConst("MEDPrescriptionSetup",2)
  public static Object $$$StrMEDPrescriptionSetupIfRequiredColour(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDPrescriptionSetup",2));
  }

  //<< #define MEDPrescriptionSetupUrgentColour(%obj) $piece(%obj,"~",3)
  public static Object $$$MEDPrescriptionSetupUrgentColour(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",3));
  }

  public static void $$$MEDPrescriptionSetupUrgentColourSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",3).set(_setval.get());
  }

  //<< #define FldMEDPrescriptionSetupUrgentColour 3
  public static Object $$$FldMEDPrescriptionSetupUrgentColour(mContext m$) {
    return (3);
  }

  //<< #define StrMEDPrescriptionSetupUrgentColour $$GetPropertyName^COMConst("MEDPrescriptionSetup",3)
  public static Object $$$StrMEDPrescriptionSetupUrgentColour(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDPrescriptionSetup",3));
  }

  //<< #define MEDPrescriptionSetupIssueType(%obj) $piece(%obj,"~",4)
  public static Object $$$MEDPrescriptionSetupIssueType(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",4));
  }

  public static void $$$MEDPrescriptionSetupIssueTypeSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",4).set(_setval.get());
  }

  //<< #define FldMEDPrescriptionSetupIssueType 4
  public static Object $$$FldMEDPrescriptionSetupIssueType(mContext m$) {
    return (4);
  }

  //<< #define StrMEDPrescriptionSetupIssueType $$GetPropertyName^COMConst("MEDPrescriptionSetup",4)
  public static Object $$$StrMEDPrescriptionSetupIssueType(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDPrescriptionSetup",4));
  }

  //<< #define MEDPrescriptionSetupDaysToAutoClose(%obj) $piece(%obj,"~",5)
  public static Object $$$MEDPrescriptionSetupDaysToAutoClose(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",5));
  }

  public static void $$$MEDPrescriptionSetupDaysToAutoCloseSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",5).set(_setval.get());
  }

  //<< #define FldMEDPrescriptionSetupDaysToAutoClose 5
  public static Object $$$FldMEDPrescriptionSetupDaysToAutoClose(mContext m$) {
    return (5);
  }

  //<< #define StrMEDPrescriptionSetupDaysToAutoClose $$GetPropertyName^COMConst("MEDPrescriptionSetup",5)
  public static Object $$$StrMEDPrescriptionSetupDaysToAutoClose(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDPrescriptionSetup",5));
  }

  //<< #define MEDPrescriptionSetupDiluentNameSize(%obj) $piece(%obj,"~",6)
  public static Object $$$MEDPrescriptionSetupDiluentNameSize(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",6));
  }

  public static void $$$MEDPrescriptionSetupDiluentNameSizeSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",6).set(_setval.get());
  }

  //<< #define FldMEDPrescriptionSetupDiluentNameSize 6
  public static Object $$$FldMEDPrescriptionSetupDiluentNameSize(mContext m$) {
    return (6);
  }

  //<< #define StrMEDPrescriptionSetupDiluentNameSize $$GetPropertyName^COMConst("MEDPrescriptionSetup",6)
  public static Object $$$StrMEDPrescriptionSetupDiluentNameSize(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDPrescriptionSetup",6));
  }

  //<< #define MEDPrescriptionSetupDefaultFrequency(%obj) $piece(%obj,"~",7)
  public static Object $$$MEDPrescriptionSetupDefaultFrequency(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",7));
  }

  public static void $$$MEDPrescriptionSetupDefaultFrequencySet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",7).set(_setval.get());
  }

  //<< #define FldMEDPrescriptionSetupDefaultFrequency 7
  public static Object $$$FldMEDPrescriptionSetupDefaultFrequency(mContext m$) {
    return (7);
  }

  //<< #define StrMEDPrescriptionSetupDefaultFrequency $$GetPropertyName^COMConst("MEDPrescriptionSetup",7)
  public static Object $$$StrMEDPrescriptionSetupDefaultFrequency(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDPrescriptionSetup",7));
  }

  //<< #define MEDPrescriptionSetupmLUnit(%obj) $piece(%obj,"~",8)
  public static Object $$$MEDPrescriptionSetupmLUnit(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",8));
  }

  public static void $$$MEDPrescriptionSetupmLUnitSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",8).set(_setval.get());
  }

  //<< #define FldMEDPrescriptionSetupmLUnit 8
  public static Object $$$FldMEDPrescriptionSetupmLUnit(mContext m$) {
    return (8);
  }

  //<< #define StrMEDPrescriptionSetupmLUnit $$GetPropertyName^COMConst("MEDPrescriptionSetup",8)
  public static Object $$$StrMEDPrescriptionSetupmLUnit(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDPrescriptionSetup",8));
  }

  //<< #define MEDPrescriptionSetupContinuousFrequency(%obj) $piece(%obj,"~",9)
  public static Object $$$MEDPrescriptionSetupContinuousFrequency(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",9));
  }

  public static void $$$MEDPrescriptionSetupContinuousFrequencySet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",9).set(_setval.get());
  }

  //<< #define FldMEDPrescriptionSetupContinuousFrequency 9
  public static Object $$$FldMEDPrescriptionSetupContinuousFrequency(mContext m$) {
    return (9);
  }

  //<< #define StrMEDPrescriptionSetupContinuousFrequency $$GetPropertyName^COMConst("MEDPrescriptionSetup",9)
  public static Object $$$StrMEDPrescriptionSetupContinuousFrequency(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDPrescriptionSetup",9));
  }

  //<< #define MEDPrescriptionSetupDefaultInfusionUnit(%obj) $piece(%obj,"~",10)
  public static Object $$$MEDPrescriptionSetupDefaultInfusionUnit(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",10));
  }

  public static void $$$MEDPrescriptionSetupDefaultInfusionUnitSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",10).set(_setval.get());
  }

  //<< #define FldMEDPrescriptionSetupDefaultInfusionUnit 10
  public static Object $$$FldMEDPrescriptionSetupDefaultInfusionUnit(mContext m$) {
    return (10);
  }

  //<< #define StrMEDPrescriptionSetupDefaultInfusionUnit $$GetPropertyName^COMConst("MEDPrescriptionSetup",10)
  public static Object $$$StrMEDPrescriptionSetupDefaultInfusionUnit(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDPrescriptionSetup",10));
  }

  //<< #define MEDPrescriptionSetupAutoRejectPRNIN(%obj) $piece(%obj,"~",11)
  public static Object $$$MEDPrescriptionSetupAutoRejectPRNIN(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",11));
  }

  public static void $$$MEDPrescriptionSetupAutoRejectPRNINSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",11).set(_setval.get());
  }

  //<< #define FldMEDPrescriptionSetupAutoRejectPRNIN 11
  public static Object $$$FldMEDPrescriptionSetupAutoRejectPRNIN(mContext m$) {
    return (11);
  }

  //<< #define StrMEDPrescriptionSetupAutoRejectPRNIN $$GetPropertyName^COMConst("MEDPrescriptionSetup",11)
  public static Object $$$StrMEDPrescriptionSetupAutoRejectPRNIN(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDPrescriptionSetup",11));
  }

  //<< #define MEDPrescriptionSetupAutoRejectLocationsforPRN(%obj) $piece(%obj,"~",12)
  public static Object $$$MEDPrescriptionSetupAutoRejectLocationsforPRN(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",12));
  }

  public static void $$$MEDPrescriptionSetupAutoRejectLocationsforPRNSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",12).set(_setval.get());
  }

  //<< #define FldMEDPrescriptionSetupAutoRejectLocationsforPRN 12
  public static Object $$$FldMEDPrescriptionSetupAutoRejectLocationsforPRN(mContext m$) {
    return (12);
  }

  //<< #define StrMEDPrescriptionSetupAutoRejectLocationsforPRN $$GetPropertyName^COMConst("MEDPrescriptionSetup",12)
  public static Object $$$StrMEDPrescriptionSetupAutoRejectLocationsforPRN(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDPrescriptionSetup",12));
  }

  //<< #define MEDPrescriptionSetupAutoRejectReasonforPRNIN(%obj) $piece(%obj,"~",13)
  public static Object $$$MEDPrescriptionSetupAutoRejectReasonforPRNIN(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",13));
  }

  public static void $$$MEDPrescriptionSetupAutoRejectReasonforPRNINSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",13).set(_setval.get());
  }

  //<< #define FldMEDPrescriptionSetupAutoRejectReasonforPRNIN 13
  public static Object $$$FldMEDPrescriptionSetupAutoRejectReasonforPRNIN(mContext m$) {
    return (13);
  }

  //<< #define StrMEDPrescriptionSetupAutoRejectReasonforPRNIN $$GetPropertyName^COMConst("MEDPrescriptionSetup",13)
  public static Object $$$StrMEDPrescriptionSetupAutoRejectReasonforPRNIN(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDPrescriptionSetup",13));
  }

  //<< #define MEDPrescriptionSetupRestrictQuantityField(%obj) $piece(%obj,"~",14)
  public static Object $$$MEDPrescriptionSetupRestrictQuantityField(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",14));
  }

  public static void $$$MEDPrescriptionSetupRestrictQuantityFieldSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",14).set(_setval.get());
  }

  //<< #define FldMEDPrescriptionSetupRestrictQuantityField 14
  public static Object $$$FldMEDPrescriptionSetupRestrictQuantityField(mContext m$) {
    return (14);
  }

  //<< #define StrMEDPrescriptionSetupRestrictQuantityField $$GetPropertyName^COMConst("MEDPrescriptionSetup",14)
  public static Object $$$StrMEDPrescriptionSetupRestrictQuantityField(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDPrescriptionSetup",14));
  }

  //<< #define MEDPrescriptionSetupForceUsePickedLot(%obj) $piece(%obj,"~",15)
  public static Object $$$MEDPrescriptionSetupForceUsePickedLot(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",15));
  }

  public static void $$$MEDPrescriptionSetupForceUsePickedLotSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",15).set(_setval.get());
  }

  //<< #define FldMEDPrescriptionSetupForceUsePickedLot 15
  public static Object $$$FldMEDPrescriptionSetupForceUsePickedLot(mContext m$) {
    return (15);
  }

  //<< #define StrMEDPrescriptionSetupForceUsePickedLot $$GetPropertyName^COMConst("MEDPrescriptionSetup",15)
  public static Object $$$StrMEDPrescriptionSetupForceUsePickedLot(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDPrescriptionSetup",15));
  }

  //<< #define MEDPrescriptionSetupSingleDoseFrequency(%obj) $piece(%obj,"~",16)
  public static Object $$$MEDPrescriptionSetupSingleDoseFrequency(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",16));
  }

  public static void $$$MEDPrescriptionSetupSingleDoseFrequencySet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",16).set(_setval.get());
  }

  //<< #define FldMEDPrescriptionSetupSingleDoseFrequency 16
  public static Object $$$FldMEDPrescriptionSetupSingleDoseFrequency(mContext m$) {
    return (16);
  }

  //<< #define StrMEDPrescriptionSetupSingleDoseFrequency $$GetPropertyName^COMConst("MEDPrescriptionSetup",16)
  public static Object $$$StrMEDPrescriptionSetupSingleDoseFrequency(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDPrescriptionSetup",16));
  }

  //<< #define MEDPrescriptionSetupFREE1(%obj) $piece(%obj,"~",20)
  public static Object $$$MEDPrescriptionSetupFREE1(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",20));
  }

  public static void $$$MEDPrescriptionSetupFREE1Set(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",20).set(_setval.get());
  }

  //<< #define FldMEDPrescriptionSetupFREE1 20
  public static Object $$$FldMEDPrescriptionSetupFREE1(mContext m$) {
    return (20);
  }

  //<< #define StrMEDPrescriptionSetupFREE1 $$GetPropertyName^COMConst("MEDPrescriptionSetup",20)
  public static Object $$$StrMEDPrescriptionSetupFREE1(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDPrescriptionSetup",20));
  }

  //<< #define MEDPrescriptionSetupFREE2(%obj) $piece(%obj,"~",21)
  public static Object $$$MEDPrescriptionSetupFREE2(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",21));
  }

  public static void $$$MEDPrescriptionSetupFREE2Set(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",21).set(_setval.get());
  }

  //<< #define FldMEDPrescriptionSetupFREE2 21
  public static Object $$$FldMEDPrescriptionSetupFREE2(mContext m$) {
    return (21);
  }

  //<< #define StrMEDPrescriptionSetupFREE2 $$GetPropertyName^COMConst("MEDPrescriptionSetup",21)
  public static Object $$$StrMEDPrescriptionSetupFREE2(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDPrescriptionSetup",21));
  }

  //<< #define FldMEDPrescriptionSetupCompany1 1
  public static Object $$$FldMEDPrescriptionSetupCompany1(mContext m$) {
    return (1);
  }

  //<< #define StrMEDPrescriptionSetupCompany1 $$GetPropertyName^COMConst("MEDPrescriptionSetup",,1)
  public static Object $$$StrMEDPrescriptionSetupCompany1(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDPrescriptionSetup",null,1));
  }

  //<< 
  //<< #define MEDPrescriptionSolItem(%obj) $piece(%obj,"~",1)
  public static Object $$$MEDPrescriptionSolItem(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",1));
  }

  public static void $$$MEDPrescriptionSolItemSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",1).set(_setval.get());
  }

  //<< #define FldMEDPrescriptionSolItem 1
  public static Object $$$FldMEDPrescriptionSolItem(mContext m$) {
    return (1);
  }

  //<< #define StrMEDPrescriptionSolItem $$GetPropertyName^COMConst("MEDPrescriptionSol",1)
  public static Object $$$StrMEDPrescriptionSolItem(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDPrescriptionSol",1));
  }

  //<< #define MEDPrescriptionSolDoseUOM(%obj) $piece(%obj,"~",2)
  public static Object $$$MEDPrescriptionSolDoseUOM(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",2));
  }

  public static void $$$MEDPrescriptionSolDoseUOMSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",2).set(_setval.get());
  }

  //<< #define FldMEDPrescriptionSolDoseUOM 2
  public static Object $$$FldMEDPrescriptionSolDoseUOM(mContext m$) {
    return (2);
  }

  //<< #define StrMEDPrescriptionSolDoseUOM $$GetPropertyName^COMConst("MEDPrescriptionSol",2)
  public static Object $$$StrMEDPrescriptionSolDoseUOM(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDPrescriptionSol",2));
  }

  //<< #define MEDPrescriptionSolDoseQuantity(%obj) $piece(%obj,"~",3)
  public static Object $$$MEDPrescriptionSolDoseQuantity(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",3));
  }

  public static void $$$MEDPrescriptionSolDoseQuantitySet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",3).set(_setval.get());
  }

  //<< #define FldMEDPrescriptionSolDoseQuantity 3
  public static Object $$$FldMEDPrescriptionSolDoseQuantity(mContext m$) {
    return (3);
  }

  //<< #define StrMEDPrescriptionSolDoseQuantity $$GetPropertyName^COMConst("MEDPrescriptionSol",3)
  public static Object $$$StrMEDPrescriptionSolDoseQuantity(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDPrescriptionSol",3));
  }

  //<< #define MEDPrescriptionSolVolume(%obj) $piece(%obj,"~",4)
  public static Object $$$MEDPrescriptionSolVolume(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",4));
  }

  public static void $$$MEDPrescriptionSolVolumeSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",4).set(_setval.get());
  }

  //<< #define FldMEDPrescriptionSolVolume 4
  public static Object $$$FldMEDPrescriptionSolVolume(mContext m$) {
    return (4);
  }

  //<< #define StrMEDPrescriptionSolVolume $$GetPropertyName^COMConst("MEDPrescriptionSol",4)
  public static Object $$$StrMEDPrescriptionSolVolume(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDPrescriptionSol",4));
  }

  //<< #define FldMEDPrescriptionSolPrescriptionNumber 1
  public static Object $$$FldMEDPrescriptionSolPrescriptionNumber(mContext m$) {
    return (1);
  }

  //<< #define StrMEDPrescriptionSolPrescriptionNumber $$GetPropertyName^COMConst("MEDPrescriptionSol",,1)
  public static Object $$$StrMEDPrescriptionSolPrescriptionNumber(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDPrescriptionSol",null,1));
  }

  //<< #define FldMEDPrescriptionSolLine 2
  public static Object $$$FldMEDPrescriptionSolLine(mContext m$) {
    return (2);
  }

  //<< #define StrMEDPrescriptionSolLine $$GetPropertyName^COMConst("MEDPrescriptionSol",,2)
  public static Object $$$StrMEDPrescriptionSolLine(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDPrescriptionSol",null,2));
  }

  //<< 
  //<< #define MEDProviderName(%obj) $piece(%obj,"~",1)
  public static Object $$$MEDProviderName(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",1));
  }

  public static void $$$MEDProviderNameSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",1).set(_setval.get());
  }

  //<< #define FldMEDProviderName 1
  public static Object $$$FldMEDProviderName(mContext m$) {
    return (1);
  }

  //<< #define StrMEDProviderName $$GetPropertyName^COMConst("MEDProvider",1)
  public static Object $$$StrMEDProviderName(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDProvider",1));
  }

  //<< #define MEDProviderProviderNo(%obj) $piece(%obj,"~",2)
  public static Object $$$MEDProviderProviderNo(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",2));
  }

  public static void $$$MEDProviderProviderNoSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",2).set(_setval.get());
  }

  //<< #define FldMEDProviderProviderNo 2
  public static Object $$$FldMEDProviderProviderNo(mContext m$) {
    return (2);
  }

  //<< #define StrMEDProviderProviderNo $$GetPropertyName^COMConst("MEDProvider",2)
  public static Object $$$StrMEDProviderProviderNo(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDProvider",2));
  }

  //<< #define MEDProviderLicenseType(%obj) $piece(%obj,"~",3)
  public static Object $$$MEDProviderLicenseType(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",3));
  }

  public static void $$$MEDProviderLicenseTypeSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",3).set(_setval.get());
  }

  //<< #define FldMEDProviderLicenseType 3
  public static Object $$$FldMEDProviderLicenseType(mContext m$) {
    return (3);
  }

  //<< #define StrMEDProviderLicenseType $$GetPropertyName^COMConst("MEDProvider",3)
  public static Object $$$StrMEDProviderLicenseType(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDProvider",3));
  }

  //<< #define MEDProviderLicenseNumber(%obj) $piece(%obj,"~",4)
  public static Object $$$MEDProviderLicenseNumber(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",4));
  }

  public static void $$$MEDProviderLicenseNumberSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",4).set(_setval.get());
  }

  //<< #define FldMEDProviderLicenseNumber 4
  public static Object $$$FldMEDProviderLicenseNumber(mContext m$) {
    return (4);
  }

  //<< #define StrMEDProviderLicenseNumber $$GetPropertyName^COMConst("MEDProvider",4)
  public static Object $$$StrMEDProviderLicenseNumber(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDProvider",4));
  }

  //<< #define MEDProviderSpeciality(%obj) $piece(%obj,"~",5)
  public static Object $$$MEDProviderSpeciality(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",5));
  }

  public static void $$$MEDProviderSpecialitySet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",5).set(_setval.get());
  }

  //<< #define FldMEDProviderSpeciality 5
  public static Object $$$FldMEDProviderSpeciality(mContext m$) {
    return (5);
  }

  //<< #define StrMEDProviderSpeciality $$GetPropertyName^COMConst("MEDProvider",5)
  public static Object $$$StrMEDProviderSpeciality(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDProvider",5));
  }

  //<< #define MEDProviderSSN(%obj) $piece(%obj,"~",6)
  public static Object $$$MEDProviderSSN(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",6));
  }

  public static void $$$MEDProviderSSNSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",6).set(_setval.get());
  }

  //<< #define FldMEDProviderSSN 6
  public static Object $$$FldMEDProviderSSN(mContext m$) {
    return (6);
  }

  //<< #define StrMEDProviderSSN $$GetPropertyName^COMConst("MEDProvider",6)
  public static Object $$$StrMEDProviderSSN(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDProvider",6));
  }

  //<< #define MEDProviderStatus(%obj) $piece(%obj,"~",7)
  public static Object $$$MEDProviderStatus(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",7));
  }

  public static void $$$MEDProviderStatusSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",7).set(_setval.get());
  }

  //<< #define FldMEDProviderStatus 7
  public static Object $$$FldMEDProviderStatus(mContext m$) {
    return (7);
  }

  //<< #define StrMEDProviderStatus $$GetPropertyName^COMConst("MEDProvider",7)
  public static Object $$$StrMEDProviderStatus(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDProvider",7));
  }

  //<< #define MEDProviderCreatedBy(%obj) $piece(%obj,"~",8)
  public static Object $$$MEDProviderCreatedBy(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",8));
  }

  public static void $$$MEDProviderCreatedBySet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",8).set(_setval.get());
  }

  //<< #define FldMEDProviderCreatedBy 8
  public static Object $$$FldMEDProviderCreatedBy(mContext m$) {
    return (8);
  }

  //<< #define StrMEDProviderCreatedBy $$GetPropertyName^COMConst("MEDProvider",8)
  public static Object $$$StrMEDProviderCreatedBy(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDProvider",8));
  }

  //<< #define MEDProviderCreatedDate(%obj) $piece(%obj,"~",9)
  public static Object $$$MEDProviderCreatedDate(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",9));
  }

  public static void $$$MEDProviderCreatedDateSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",9).set(_setval.get());
  }

  //<< #define FldMEDProviderCreatedDate 9
  public static Object $$$FldMEDProviderCreatedDate(mContext m$) {
    return (9);
  }

  //<< #define StrMEDProviderCreatedDate $$GetPropertyName^COMConst("MEDProvider",9)
  public static Object $$$StrMEDProviderCreatedDate(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDProvider",9));
  }

  //<< #define MEDProviderChangedBy(%obj) $piece(%obj,"~",10)
  public static Object $$$MEDProviderChangedBy(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",10));
  }

  public static void $$$MEDProviderChangedBySet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",10).set(_setval.get());
  }

  //<< #define FldMEDProviderChangedBy 10
  public static Object $$$FldMEDProviderChangedBy(mContext m$) {
    return (10);
  }

  //<< #define StrMEDProviderChangedBy $$GetPropertyName^COMConst("MEDProvider",10)
  public static Object $$$StrMEDProviderChangedBy(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDProvider",10));
  }

  //<< #define MEDProviderChangedOn(%obj) $piece(%obj,"~",11)
  public static Object $$$MEDProviderChangedOn(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",11));
  }

  public static void $$$MEDProviderChangedOnSet(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",11).set(_setval.get());
  }

  //<< #define FldMEDProviderChangedOn 11
  public static Object $$$FldMEDProviderChangedOn(mContext m$) {
    return (11);
  }

  //<< #define StrMEDProviderChangedOn $$GetPropertyName^COMConst("MEDProvider",11)
  public static Object $$$StrMEDProviderChangedOn(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDProvider",11));
  }

  //<< #define MEDProviderFREE1(%obj) $piece(%obj,"~",21)
  public static Object $$$MEDProviderFREE1(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",21));
  }

  public static void $$$MEDProviderFREE1Set(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",21).set(_setval.get());
  }

  //<< #define FldMEDProviderFREE1 21
  public static Object $$$FldMEDProviderFREE1(mContext m$) {
    return (21);
  }

  //<< #define StrMEDProviderFREE1 $$GetPropertyName^COMConst("MEDProvider",21)
  public static Object $$$StrMEDProviderFREE1(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDProvider",21));
  }

  //<< #define MEDProviderFREE2(%obj) $piece(%obj,"~",22)
  public static Object $$$MEDProviderFREE2(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",22));
  }

  public static void $$$MEDProviderFREE2Set(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",22).set(_setval.get());
  }

  //<< #define FldMEDProviderFREE2 22
  public static Object $$$FldMEDProviderFREE2(mContext m$) {
    return (22);
  }

  //<< #define StrMEDProviderFREE2 $$GetPropertyName^COMConst("MEDProvider",22)
  public static Object $$$StrMEDProviderFREE2(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDProvider",22));
  }

  //<< #define MEDProviderFREE3(%obj) $piece(%obj,"~",23)
  public static Object $$$MEDProviderFREE3(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",23));
  }

  public static void $$$MEDProviderFREE3Set(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",23).set(_setval.get());
  }

  //<< #define FldMEDProviderFREE3 23
  public static Object $$$FldMEDProviderFREE3(mContext m$) {
    return (23);
  }

  //<< #define StrMEDProviderFREE3 $$GetPropertyName^COMConst("MEDProvider",23)
  public static Object $$$StrMEDProviderFREE3(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDProvider",23));
  }

  //<< #define MEDProviderFREE4(%obj) $piece(%obj,"~",24)
  public static Object $$$MEDProviderFREE4(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",24));
  }

  public static void $$$MEDProviderFREE4Set(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",24).set(_setval.get());
  }

  //<< #define FldMEDProviderFREE4 24
  public static Object $$$FldMEDProviderFREE4(mContext m$) {
    return (24);
  }

  //<< #define StrMEDProviderFREE4 $$GetPropertyName^COMConst("MEDProvider",24)
  public static Object $$$StrMEDProviderFREE4(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDProvider",24));
  }

  //<< #define MEDProviderFREE5(%obj) $piece(%obj,"~",25)
  public static Object $$$MEDProviderFREE5(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",25));
  }

  public static void $$$MEDProviderFREE5Set(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",25).set(_setval.get());
  }

  //<< #define FldMEDProviderFREE5 25
  public static Object $$$FldMEDProviderFREE5(mContext m$) {
    return (25);
  }

  //<< #define StrMEDProviderFREE5 $$GetPropertyName^COMConst("MEDProvider",25)
  public static Object $$$StrMEDProviderFREE5(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDProvider",25));
  }

  //<< #define MEDProviderFREE6(%obj) $piece(%obj,"~",26)
  public static Object $$$MEDProviderFREE6(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",26));
  }

  public static void $$$MEDProviderFREE6Set(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",26).set(_setval.get());
  }

  //<< #define FldMEDProviderFREE6 26
  public static Object $$$FldMEDProviderFREE6(mContext m$) {
    return (26);
  }

  //<< #define StrMEDProviderFREE6 $$GetPropertyName^COMConst("MEDProvider",26)
  public static Object $$$StrMEDProviderFREE6(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDProvider",26));
  }

  //<< #define MEDProviderFREE7(%obj) $piece(%obj,"~",27)
  public static Object $$$MEDProviderFREE7(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",27));
  }

  public static void $$$MEDProviderFREE7Set(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",27).set(_setval.get());
  }

  //<< #define FldMEDProviderFREE7 27
  public static Object $$$FldMEDProviderFREE7(mContext m$) {
    return (27);
  }

  //<< #define StrMEDProviderFREE7 $$GetPropertyName^COMConst("MEDProvider",27)
  public static Object $$$StrMEDProviderFREE7(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDProvider",27));
  }

  //<< #define MEDProviderFREE8(%obj) $piece(%obj,"~",28)
  public static Object $$$MEDProviderFREE8(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",28));
  }

  public static void $$$MEDProviderFREE8Set(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",28).set(_setval.get());
  }

  //<< #define FldMEDProviderFREE8 28
  public static Object $$$FldMEDProviderFREE8(mContext m$) {
    return (28);
  }

  //<< #define StrMEDProviderFREE8 $$GetPropertyName^COMConst("MEDProvider",28)
  public static Object $$$StrMEDProviderFREE8(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDProvider",28));
  }

  //<< #define MEDProviderFREE9(%obj) $piece(%obj,"~",29)
  public static Object $$$MEDProviderFREE9(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",29));
  }

  public static void $$$MEDProviderFREE9Set(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",29).set(_setval.get());
  }

  //<< #define FldMEDProviderFREE9 29
  public static Object $$$FldMEDProviderFREE9(mContext m$) {
    return (29);
  }

  //<< #define StrMEDProviderFREE9 $$GetPropertyName^COMConst("MEDProvider",29)
  public static Object $$$StrMEDProviderFREE9(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDProvider",29));
  }

  //<< #define MEDProviderFREE10(%obj) $piece(%obj,"~",30)
  public static Object $$$MEDProviderFREE10(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",30));
  }

  public static void $$$MEDProviderFREE10Set(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",30).set(_setval.get());
  }

  //<< #define FldMEDProviderFREE10 30
  public static Object $$$FldMEDProviderFREE10(mContext m$) {
    return (30);
  }

  //<< #define StrMEDProviderFREE10 $$GetPropertyName^COMConst("MEDProvider",30)
  public static Object $$$StrMEDProviderFREE10(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDProvider",30));
  }

  //<< #define MEDProviderUser1(%obj) $piece(%obj,"~",31)
  public static Object $$$MEDProviderUser1(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$obj.get(),"~",31));
  }

  public static void $$$MEDProviderUser1Set(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$obj,"~",31).set(_setval.get());
  }

  //<< #define FldMEDProviderUser1 31
  public static Object $$$FldMEDProviderUser1(mContext m$) {
    return (31);
  }

  //<< #define StrMEDProviderUser1 $$GetPropertyName^COMConst("MEDProvider",31)
  public static Object $$$StrMEDProviderUser1(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDProvider",31));
  }

  //<< #define FldMEDProviderID1 1
  public static Object $$$FldMEDProviderID1(mContext m$) {
    return (1);
  }

  //<< #define StrMEDProviderID1 $$GetPropertyName^COMConst("MEDProvider",,1)
  public static Object $$$StrMEDProviderID1(mContext m$) {
    return (m$.fnc$("COMConst.GetPropertyName","MEDProvider",null,1));
  }

  //<< 
  //<< #define EnumMEDIUMLetter "0"
  public static Object $$$EnumMEDIUMLetter(mContext m$) {
    return ("0");
  }

  //<< #define EnumMEDIUMEmail "1"
  public static Object $$$EnumMEDIUMEmail(mContext m$) {
    return ("1");
  }

  //<< #define EnumMEDIUMFax "2"
  public static Object $$$EnumMEDIUMFax(mContext m$) {
    return ("2");
  }

  //<< #define EnumMEDIUMPhone "3"
  public static Object $$$EnumMEDIUMPhone(mContext m$) {
    return ("3");
  }

  //<< #define EnumMEDIUMMeeting "4"
  public static Object $$$EnumMEDIUMMeeting(mContext m$) {
    return ("4");
  }

  //<< #define EnumMEDIUMOther "5"
  public static Object $$$EnumMEDIUMOther(mContext m$) {
    return ("5");
  }

  //<< #define EnumMEDIUMOrderPosition "6"
  public static Object $$$EnumMEDIUMOrderPosition(mContext m$) {
    return ("6");
  }

  //<< #define EnumMEDIUM1Printer "0"
  public static Object $$$EnumMEDIUM1Printer(mContext m$) {
    return ("0");
  }

  //<< #define EnumMEDIUM1Email "1"
  public static Object $$$EnumMEDIUM1Email(mContext m$) {
    return ("1");
  }

  //<< #define EnumMEDIUM1Fax "2"
  public static Object $$$EnumMEDIUM1Fax(mContext m$) {
    return ("2");
  }

  //<< #define EnumMEDIUM1XML "3"
  public static Object $$$EnumMEDIUM1XML(mContext m$) {
    return ("3");
  }

  //<< #define EnumMEDIUM1EDI "4"
  public static Object $$$EnumMEDIUM1EDI(mContext m$) {
    return ("4");
  }

  //<< #define EnumMEDIUM1FTP "5"
  public static Object $$$EnumMEDIUM1FTP(mContext m$) {
    return ("5");
  }

  //<< #define EnumMEDIUM1EDIPro "6"
  public static Object $$$EnumMEDIUM1EDIPro(mContext m$) {
    return ("6");
  }

  //<< #define EnumMEDIUM1StandardInterface "9"
  public static Object $$$EnumMEDIUM1StandardInterface(mContext m$) {
    return ("9");
  }

  //<< #define EnumMEDIUM2Printers "0"
  public static Object $$$EnumMEDIUM2Printers(mContext m$) {
    return ("0");
  }

  //<< #define EnumMEDIUM2Email "1"
  public static Object $$$EnumMEDIUM2Email(mContext m$) {
    return ("1");
  }

  //<< #define EnumMEDIUM2Fax "2"
  public static Object $$$EnumMEDIUM2Fax(mContext m$) {
    return ("2");
  }

  //<< #define EnumMEDIUM2AfterDocumentSpecification "9"
  public static Object $$$EnumMEDIUM2AfterDocumentSpecification(mContext m$) {
    return ("9");
  }

  //<< #define EnumMEDPRESCRIPTIONStandard "1"
  public static Object $$$EnumMEDPRESCRIPTIONStandard(mContext m$) {
    return ("1");
  }

  //<< #define EnumMEDPRESCRIPTIONCustomManufacture "2"
  public static Object $$$EnumMEDPRESCRIPTIONCustomManufacture(mContext m$) {
    return ("2");
  }

  //<< #define EnumMEDPROVIDERSTAActive "1"
  public static Object $$$EnumMEDPROVIDERSTAActive(mContext m$) {
    return ("1");
  }

  //<< #define EnumMEDPROVIDERSTAInactive "2"
  public static Object $$$EnumMEDPROVIDERSTAInactive(mContext m$) {
    return ("2");
  }

}
