//*****************************************************************************
//** TASC - ALPHALINC - MAC WWW0121
//** Innovatium Systems - Code Converter - v1.29
//** 2014-06-03 20:55:01
//*****************************************************************************

import mLibrary.*;

//<< 
//<< #include INConst
import include.INConst;
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
//<< #include %occInclude
import include.$occInclude;
import include.$occConstant;
import include.$occStatus;
import include.$occErrors;

//<< WWW0121
public class WWW0121 extends mClass {

  public void main() {
    _WWW0121();
  }

  public void _WWW0121() {
    //<< 
    //<< ;-------------------------------------------------------------------------------
    //<< ; Description of Function :
    //<< ;       BUTTON FÜR DIE AUSWAHL DER Betriebe
    //<< ;
    //<< ; Params : no explicit variables
    //<< ;
    //<< ;
    //<< ; Implicit Inputs :
    //<< ;   YHID        1   ?
    //<< ;               2   ?
    //<< ;   YFORM       Form ID
    //<< ;   YART        Field type (P/D/M)
    //<< ;   YLFN        Field number
    //<< ;   YGIF        Image path
    //<< ;
    //<< ; Returns : nothing
    //<< ;
    //<< ;
    //<< ; History :
    //<< ; 21-Aug-2007   Frank   SRBR014566: refactoring: putting the URL formation in a new tag.
    //<< ; 12-Jun-2007   RPW     SRadhoc: removed . syntax
    //<< ; 06-Jun-2007   GRF     SR15522: removed orphan </A>; cleared unneeded YCRs &
    //<< ;                       consolidated block of changed code
    //<< ; 05-May-2007   HeberB  SR15522: Replace open.window by subwindow
    //<< ; 26-Apr-2007   shobby  SRBR014454: Change the image to a tree
    //<< ; 22-Dec-2006   GRF     SR15208: Expand commands; split URL construction
    //<< ; 03.06.2001    DT
    //<< ;-------------------------------------------------------------------------------
    //<< ; ERSTELLEN DES BUTTONS
    //<< quit:$get(YHID)=1
    if (mOp.Equal(m$.Fnc.$get(m$.var("YHID")),1)) {
      return;
    }
    //<< quit:$get(YHID)=2
    if (mOp.Equal(m$.Fnc.$get(m$.var("YHID")),2)) {
      return;
    }
    //<< 
    //<< write "<IMG SRC="_""""_YGIF_"searchtree.gif"_""""_" ALIGN=ABSBOTTOM TITLE="_""""_$$^WWWTEXT(148)_""""_" border=0"    ; "Search"
    m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<IMG SRC=","\""),m$.var("YGIF").get()),"searchtree.gif"),"\"")," ALIGN=ABSBOTTOM TITLE="),"\""),m$.fnc$("WWWTEXT.main",148)),"\"")," border=0"));
    //<< write " class=link "
    m$.Cmd.Write(" class=link ");
    //<< write " onClick='"_$$CreateLocationPopupJS("Y"_YFORM_YART_YLFN)_"'"
    m$.Cmd.Write(mOp.Concat(mOp.Concat(" onClick='",m$.fnc$("CreateLocationPopupJS",mOp.Concat(mOp.Concat(mOp.Concat("Y",m$.var("YFORM").get()),m$.var("YART").get()),m$.var("YLFN").get()))),"'"));
    //<< write ">"
    m$.Cmd.Write(">");
    //<< 
    //<< quit
    return;
  }

  //<< 
  //<< 
  //<< TempReqValidation(pidKey,YFELD,pidCompany,pidToLocn,pidFromLocn)
  public Object TempReqValidation(Object ... _p) {
    mVar pidKey = m$.newVarRef("pidKey",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar YFELD = m$.newVarRef("YFELD",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pidCompany = m$.newVarRef("pidCompany",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    mVar pidToLocn = m$.newVarRef("pidToLocn",(((_p!=null)&&(_p.length>=4))?_p[3]:null));
    mVar pidFromLocn = m$.newVarRef("pidFromLocn",(((_p!=null)&&(_p.length>=5))?_p[4]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Temporary validation called by (alREQ.dUReq).IsFirmable
    //<< ; to ensure we can't firm if bad locations in header
    //<< ;
    //<< ; History:
    //<< ; 14-Dec-2007   GRF/HUY pidToLocn required for D3
    //<< ; 13-Dec-2007   GRF     Created
    //<< ;-------------------------------------------------------------------------------
    //<< new strStatus
    mVar strStatus = m$.var("strStatus");
    m$.newVar(strStatus);
    //<< 
    //<< set strStatus = $$OnDataAccess^WWW0121(pidCompany_","_pidToLocn,"INReq","D",3,YFELD)       ; $$$FldINReqToLocn
    strStatus.set(m$.fnc$("WWW0121.OnDataAccess",mOp.Concat(mOp.Concat(pidCompany.get(),","),pidToLocn.get()),"INReq","D",3,YFELD.get()));
    //<< 
    //<< if $$$ISOK(strStatus) {
    if (mOp.Logical(include.COMSYS.$$$ISOK(m$,strStatus))) {
      //<< set strStatus = $$OnDataAccess^WWW0121(pidCompany_","_pidFromLocn,"INReq","D",4,YFELD) ; $$$FldINReqFromLocn
      strStatus.set(m$.fnc$("WWW0121.OnDataAccess",mOp.Concat(mOp.Concat(pidCompany.get(),","),pidFromLocn.get()),"INReq","D",4,YFELD.get()));
    }
    //<< }
    //<< 
    //<< quit strStatus
    return strStatus.get();
  }

  //<< 
  //<< 
  //<< TempReqLineValidation(pidKey,YFELD,pidCompany,pidFromLocn)
  public Object TempReqLineValidation(Object ... _p) {
    mVar pidKey = m$.newVarRef("pidKey",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar YFELD = m$.newVarRef("YFELD",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pidCompany = m$.newVarRef("pidCompany",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    mVar pidFromLocn = m$.newVarRef("pidFromLocn",(((_p!=null)&&(_p.length>=4))?_p[3]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Temporary validation called by (alREQ.dUReqLine).IsFirmable
    //<< ; to ensure we can't firm if dodgy ReqLine entries
    //<< ;
    //<< ; History:
    //<< ; 13-Dec-2007   GRF     Created
    //<< ;-------------------------------------------------------------------------------
    //<< new GKEY
    mVar GKEY = m$.var("GKEY");
    m$.newVar(GKEY);
    //<< 
    //<< set GKEY = pidKey
    GKEY.set(pidKey.get());
    //<< quit $$OnDataAccess^WWW0121(pidCompany_","_pidFromLocn,"INReqLine","D",9,YFELD)   ; $$$FldINReqLineFromStockLocn
    return m$.fnc$("WWW0121.OnDataAccess",mOp.Concat(mOp.Concat(pidCompany.get(),","),pidFromLocn.get()),"INReqLine","D",9,YFELD.get());
  }

  //<< 
  //<< 
  //<< OnDataAccess(YKEY,YFORM,pidDataType,pintFldNo,YFELD)
  public Object OnDataAccess(Object ... _p) {
    mVar YKEY = m$.newVarRef("YKEY",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar YFORM = m$.newVarRef("YFORM",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pidDataType = m$.newVarRef("pidDataType",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    mVar pintFldNo = m$.newVarRef("pintFldNo",(((_p!=null)&&(_p.length>=4))?_p[3]:null));
    mVar YFELD = m$.newVarRef("YFELD",(((_p!=null)&&(_p.length>=5))?_p[4]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Limits the list of locations that a user can switch to based on the 'Allowed Locations'
    //<< ; in the users profile.
    //<< ;
    //<< ; Called by:
    //<< ;   WWWFieldValidation
    //<< ;   COMViewFilter
    //<< ;   WWWFOR71
    //<< ;   WWWSEAR3                Search
    //<< ;
    //<< ; Params:
    //<< ;   pstrKey             WWW0121 Key (Company,Locn)
    //<< ;   YFORM               Calling Form ID - provides
    //<< ;   pidDataType         P, D, or M          (YART)
    //<< ;   pintFldNo           Field Number        (YLFN)
    //<< ;   YFELD               Current (unsaved) Data Structure
    //<< ;
    //<< ; Returns:
    //<< ;   $$$NO       Location is Not Accessable
    //<< ;   $$$YES      Location is Accessable
    //<< ;
    //<< ; History:
    //<< ; 13-Jun-2013   shobby  CORE-101: Missing bracket routine failed to compile.
    //<< ; 13-Jun-2013   SCR     HEVA-971: Disable Type validation
    //<< ; 20-Mar-2013   SCR     HEVA-811: Valdate INReq with Type based on Destination Location
    //<< ; 05-Sep-2012   shobby  SR18090: Can only Issue to departments.
    //<< ; 27-Apr-2012   shobby  SR17826: Validate idCompany and idLocn
    //<< ; 01-Mar-2012   shobby  SR17826: Disable using Inactive locations.
    //<< ; 17-Aug-2009   GRF     SR16768: text corrections
    //<< ; 20-Jul-2009   DWR     SR16772: Added form INReqKit to be handled as INReq
    //<< ; 17-Jul-2009   PPP     SR16768:1. Added checks for DispenseToPatient form (location checks)
    //<< ;                               2. Added language text IN01080
    //<< ; 11-Mar-2009   GRF     SR16415: Add $$TransferLocation test to allow
    //<< ;                           "Consumable" requisitions.
    //<< ; 13-Jan-2009   HQN     SR16296: Location check based on ReqType for ReqLines
    //<< ; 12-Jan-2008   HQN     SR16296: Depending on ReqType, alter Location rules
    //<< ; 11-Dec-2007   GRF     SR15612: Parent needs to come from Grid key (GKEY)
    //<< ; 07-Dec-2007   GRF     SR15612: Apply to INReqLine
    //<< ; 04-Dec-2007   GRF     SR15612: Restrict Locations on INReq & INMOV
    //<< ; 15-Nov-2007   GRF     SR15563: Internationalise - WWW00078, WWW00079
    //<< ;                           (May already be covered by restricted relation validation)
    //<< ; 24-Oct-2007   GRF     SR15563: Generalise for locn hierarchy; DO NOT put "+"
    //<< ;                           in front of $$$KEY1
    //<< ; 28-Sep-2007   shobby  SRBR014724: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new blnDataAccess,idCompany,idFromLocn,idFromMainLocn,idLocn,idParent,idToLocn,idToMainLocn
    mVar blnDataAccess = m$.var("blnDataAccess");
    mVar idCompany = m$.var("idCompany");
    mVar idFromLocn = m$.var("idFromLocn");
    mVar idFromMainLocn = m$.var("idFromMainLocn");
    mVar idLocn = m$.var("idLocn");
    mVar idParent = m$.var("idParent");
    mVar idToLocn = m$.var("idToLocn");
    mVar idToMainLocn = m$.var("idToMainLocn");
    m$.newVar(blnDataAccess,idCompany,idFromLocn,idFromMainLocn,idLocn,idParent,idToLocn,idToMainLocn);
    //<< new objParent,objWWW013,strLocnList,strPath,objWWW0121 ;SR17826
    mVar objParent = m$.var("objParent");
    mVar objWWW013 = m$.var("objWWW013");
    mVar strLocnList = m$.var("strLocnList");
    mVar strPath = m$.var("strPath");
    mVar objWWW0121 = m$.var("objWWW0121");
    m$.newVar(objParent,objWWW013,strLocnList,strPath,objWWW0121);
    //<< 
    //<< set idCompany = $$$KEY1(YKEY)
    idCompany.set(include.COMSYSWWW.$$$KEY1(m$,YKEY));
    //<< set idLocn    = $$$KEY2(YKEY)
    idLocn.set(include.COMSYSWWW.$$$KEY2(m$,YKEY));
    //<< 
    //<< if (idCompany'="") && (idLocn'="") {
    if ((mOp.NotEqual(idCompany.get(),"")) && (mOp.NotEqual(idLocn.get(),""))) {
      //<< set objWWW0121 = $get(^WWW0121(0,idCompany,idLocn,1)) ;SR17826
      objWWW0121.set(m$.Fnc.$get(m$.var("^WWW0121",0,idCompany.get(),idLocn.get(),1)));
    }
    //<< } else {
    else {
      //<< set objWWW0121 = ""
      objWWW0121.set("");
    }
    //<< }
    //<< ;---------------------------------------
    //<< ; TODO : <GRF> can we preserve for YBED so don't need to re-get strLocnList for each location every time?
    //<< ; Would need to clear out if ^WWW013 is changed
    //<< 
    //<< set objWWW013   = $get(^WWW013(0,YBED,1))
    objWWW013.set(m$.Fnc.$get(m$.var("^WWW013",0,m$.var("YBED").get(),1)));
    //<< set strLocnList = $$$WWW013AllowedLocations(objWWW013)
    strLocnList.set(include.WWWConst.$$$WWW013AllowedLocations(m$,objWWW013));
    //<< ;---------------------------------------
    //<< set blnDataAccess = $$$YES
    blnDataAccess.set(include.COMSYS.$$$YES(m$));
    //<< 
    //<< if YFORM="WWW0131B" {                                 ; Change Location - Authorised
    if (mOp.Equal(YFORM.get(),"WWW0131B")) {
      //<< set blnDataAccess = $$AccessAllowed(idCompany,idLocn,strLocnList)
      blnDataAccess.set(m$.fnc$("AccessAllowed",idCompany.get(),idLocn.get(),strLocnList.get()));
    }
    //<< 
    //<< } elseif YFORM="INLP" {                                     ; Storage Places - Inventory Locn
    else if (mOp.Equal(YFORM.get(),"INLP")) {
      //<< if '$$InventoryAllowed^WWW0121Rules(idCompany,idLocn) {    ; common code version
      if (mOp.Not(m$.fnc$("WWW0121Rules.InventoryAllowed",idCompany.get(),idLocn.get()))) {
        //<< set blnDataAccess = $$$MakeStatus("WWW00078")       ; "This location isn't set as an Inventory Location"
        blnDataAccess.set(include.COMSYS.$$$MakeStatus(m$,"WWW00078"));
      }
    }
    //<< }
    //<< 
    //<< 
    //<< } elseif YFORM="INTFRRequest" {                             ; Transfer - Transfer Locn
    else if (mOp.Equal(YFORM.get(),"INTFRRequest")) {
      //<< if '$$TransferLocation^WWW0121Rules(idCompany,idLocn) {
      if (mOp.Not(m$.fnc$("WWW0121Rules.TransferLocation",idCompany.get(),idLocn.get()))) {
        //<< set blnDataAccess = $$$MakeStatus("WWW00079")       ; "This location isn't set as an Transfer Location"
        blnDataAccess.set(include.COMSYS.$$$MakeStatus(m$,"WWW00079"));
      }
    }
    //<< }
    //<< } elseif (YFORM = "INReq") || (YFORM = "INReqKit") {
    else if ((mOp.Equal(YFORM.get(),"INReq")) || (mOp.Equal(YFORM.get(),"INReqKit"))) {
      //<< if '$$InventoryAllowed^WWW0121Rules(idCompany,idLocn) && '$$TransferLocation^WWW0121Rules(idCompany,idLocn) { ; SR16057
      if (mOp.Not(m$.fnc$("WWW0121Rules.InventoryAllowed",idCompany.get(),idLocn.get())) && mOp.Not(m$.fnc$("WWW0121Rules.TransferLocation",idCompany.get(),idLocn.get()))) {
        //<< set blnDataAccess = $$$MakeStatus("WWW00111")     ; "This location must be either an Inventory or a Transfer Location."
        blnDataAccess.set(include.COMSYS.$$$MakeStatus(m$,"WWW00111"));
      }
    }
    //<< ; HEVA-971 vvvv
    //<< ;} elseif pidDataType="D" {
    //<< ;   if pintFldNo=3 {
    //<< ;       set idFromLocn  = $$$INReqFromLocn(YFELD)
    //<< ;       set idToLocn    = $$$INReqToLocn(YFELD) ; ; HEVA-811
    //<< ;       set blnDataAccess = $$TypeCheck(idFromLocn,idToLocn,blnDataAccess,YFELD,pintFldNo)
    //<< ;   } elseif pintFldNo=4 {
    //<< ;       set idFromLocn  = $$$INReqFromLocn(YFELD)
    //<< ;       set idToLocn    = $$$INReqToLocn(YFELD) ; ; HEVA-811
    //<< ;       set blnDataAccess = $$TypeCheck(idFromLocn,idToLocn,blnDataAccess,YFELD,pintFldNo)
    //<< ;   }
    //<< ; HEVA-971 ^^^^
    //<< }  ;CORE-101
    //<< } elseif YFORM = "INReqLine" {
    else if (mOp.Equal(YFORM.get(),"INReqLine")) {
      //<< if '$$InventoryAllowed^WWW0121Rules(idCompany,idLocn) {
      if (mOp.Not(m$.fnc$("WWW0121Rules.InventoryAllowed",idCompany.get(),idLocn.get()))) {
        //<< set blnDataAccess = $$$MakeStatus("WWW00078")     ; "This location isn't set as an Inventory Location"
        blnDataAccess.set(include.COMSYS.$$$MakeStatus(m$,"WWW00078"));
      }
      //<< 
      //<< } elseif pidDataType="D" {
      else if (mOp.Equal(pidDataType.get(),"D")) {
        //<< if pintFldNo=9 {
        if (mOp.Equal(pintFldNo.get(),9)) {
          //<< set idParent = $$$KEY1($get(GKEY))
          idParent.set(include.COMSYSWWW.$$$KEY1(m$,m$.Fnc.$get(m$.var("GKEY"))));
          //<< if idParent'="" {
          if (mOp.NotEqual(idParent.get(),"")) {
            //<< set objParent = $get(^INReq(0,idParent,1))
            objParent.set(m$.Fnc.$get(m$.var("^INReq",0,idParent.get(),1)));
            //<< set idFromLocn  = $$$INReqFromLocn(objParent)
            idFromLocn.set(include.INConst.$$$INReqFromLocn(m$,objParent));
            //<< set idToLocn    = $$$INReqToLocn(objParent) ; ; HEVA-811
            idToLocn.set(include.INConst.$$$INReqToLocn(m$,objParent));
            //<< set blnDataAccess = $$TypeCheck(idFromLocn,idToLocn,blnDataAccess,objParent,pintFldNo)
            blnDataAccess.set(m$.fnc$("TypeCheck",idFromLocn.get(),idToLocn.get(),blnDataAccess.get(),objParent.get(),pintFldNo.get()));
          }
        }
      }
    }
    //<< }
    //<< }
    //<< }
    //<< ; HEVA-811 ^^^^
    //<< //*****
    //<< // vvv SR16768
    //<< } elseif YFORM = "INDispenseToPatient" {
    else if (mOp.Equal(YFORM.get(),"INDispenseToPatient")) {
      //<< 
      //<< if '$$InventoryAllowed^WWW0121Rules(idCompany,idLocn) && '$$TransferLocation^WWW0121Rules(idCompany,idLocn) { ; SR16057
      if (mOp.Not(m$.fnc$("WWW0121Rules.InventoryAllowed",idCompany.get(),idLocn.get())) && mOp.Not(m$.fnc$("WWW0121Rules.TransferLocation",idCompany.get(),idLocn.get()))) {
        //<< set blnDataAccess = $$$MakeStatus("WWW00111")     ; "This location must be either an Inventory or a Transfer Location."
        blnDataAccess.set(include.COMSYS.$$$MakeStatus(m$,"WWW00111"));
      }
      //<< 
      //<< 
      //<< } elseif pidDataType="D" && ( ($$$INIssueType(YFELD)="") || ($$$INIssueType(YFELD)=1) || ($$$INIssueType(YFELD)=2) ) {      //Only for Issue Type 1 & 2
      else if (mOp.Equal(pidDataType.get(),"D") && mOp.Logical(((mOp.Equal(include.INConst.$$$INIssueType(m$,YFELD),"")) || (mOp.Equal(include.INConst.$$$INIssueType(m$,YFELD),1)) || (mOp.Equal(include.INConst.$$$INIssueType(m$,YFELD),2))))) {
        //<< 
        //<< if pintFldNo=2 {
        if (mOp.Equal(pintFldNo.get(),2)) {
          //<< new objToLocn
          mVar objToLocn = m$.var("objToLocn");
          m$.newVar(objToLocn);
          //<< 
          //<< if (idLocn '= "") {
          if ((mOp.NotEqual(idLocn.get(),""))) {
            //<< set objToLocn = ^WWW0121(YM,0,idLocn,1)
            objToLocn.set(m$.var("^WWW0121",m$.var("YM").get(),0,idLocn.get(),1).get());
            //<< if ($$$WWW0121LocationType(objToLocn)'=2) {       ;Department
            if ((mOp.NotEqual(include.WWWConst.$$$WWW0121LocationType(m$,objToLocn),2))) {
              //<< set blnDataAccess = $listbuild( "WWW00179")  ;To Location is not type department
              blnDataAccess.set(m$.Fnc.$listbuild("WWW00179"));
            }
          }
          //<< }
          //<< }
          //<< if blnDataAccess=$$$YES {
          if (mOp.Equal(blnDataAccess.get(),include.COMSYS.$$$YES(m$))) {
            //<< set idFromLocn = $$$INIssueFromLocn(YFELD)
            idFromLocn.set(include.INConst.$$$INIssueFromLocn(m$,YFELD));
            //<< if idFromLocn=idLocn {
            if (mOp.Equal(idFromLocn.get(),idLocn.get())) {
              //<< set blnDataAccess = $listbuild("IN01079")                   ; "Issue requires different locations"
              blnDataAccess.set(m$.Fnc.$listbuild("IN01079"));
            }
            //<< 
            //<< } elseif idFromLocn'="" {
            else if (mOp.NotEqual(idFromLocn.get(),"")) {
              //<< set idFromMainLocn = $$MainSite^WWW0121Utils(idCompany,idFromLocn)
              idFromMainLocn.set(m$.fnc$("WWW0121Utils.MainSite",idCompany.get(),idFromLocn.get()));
              //<< set idToMainLocn   = $$MainSite^WWW0121Utils(idCompany,idLocn)
              idToMainLocn.set(m$.fnc$("WWW0121Utils.MainSite",idCompany.get(),idLocn.get()));
              //<< 
              //<< if (idToMainLocn="") {
              if ((mOp.Equal(idToMainLocn.get(),""))) {
                //<< set blnDataAccess = $listbuild("IN00384",idLocn)        ; "Can't find main location for %1"
                blnDataAccess.set(m$.Fnc.$listbuild("IN00384",idLocn.get()));
              }
              //<< 
              //<< } elseif (idFromMainLocn="") {
              else if ((mOp.Equal(idFromMainLocn.get(),""))) {
                //<< set blnDataAccess = $listbuild("IN00384",idFromLocn)    ; "Can't find main location for %1"
                blnDataAccess.set(m$.Fnc.$listbuild("IN00384",idFromLocn.get()));
              }
              //<< 
              //<< } else {
              else {
                //<< if $$$INIssueType(YFELD) = 1 { ; Department
                if (mOp.Equal(include.INConst.$$$INIssueType(m$,YFELD),1)) {
                  //<< if idFromMainLocn'=idToMainLocn {
                  if (mOp.NotEqual(idFromMainLocn.get(),idToMainLocn.get())) {
                    //<< set blnDataAccess = $listbuild("IN01077",idToMainLocn,idFromMainLocn)
                    blnDataAccess.set(m$.Fnc.$listbuild("IN01077",idToMainLocn.get(),idFromMainLocn.get()));
                  }
                }
                //<< ;                       "Issue requires the same Main Location : %1, %2"
                //<< }
                //<< } elseif $$$INIssueType(YFELD) = 2 { ; Transfer
                else if (mOp.Equal(include.INConst.$$$INIssueType(m$,YFELD),2)) {
                  //<< if idFromMainLocn=idToMainLocn {
                  if (mOp.Equal(idFromMainLocn.get(),idToMainLocn.get())) {
                    //<< set blnDataAccess = $listbuild("IN01078",idToMainLocn,idFromMainLocn)
                    blnDataAccess.set(m$.Fnc.$listbuild("IN01078",idToMainLocn.get(),idFromMainLocn.get()));
                  }
                }
                //<< ;                       "Issue requires different Main Locations : %1, %2"
                //<< }
                //<< } else {
                else {
                }
              }
            }
          }
        }
        //<< //
        //<< }
        //<< }
        //<< }
        //<< }
        //<< } elseif pintFldNo=3 {
        else if (mOp.Equal(pintFldNo.get(),3)) {
          //<< set idToLocn = $$$INIssueToLocn(YFELD)
          idToLocn.set(include.INConst.$$$INIssueToLocn(m$,YFELD));
          //<< if idToLocn=idLocn {
          if (mOp.Equal(idToLocn.get(),idLocn.get())) {
            //<< set blnDataAccess = $listbuild("IN01079")               ; "Issue requires different locations"
            blnDataAccess.set(m$.Fnc.$listbuild("IN01079"));
          }
          //<< 
          //<< } elseif idToLocn'="" {
          else if (mOp.NotEqual(idToLocn.get(),"")) {
            //<< set idFromMainLocn = $$MainSite^WWW0121Utils(idCompany,idLocn)
            idFromMainLocn.set(m$.fnc$("WWW0121Utils.MainSite",idCompany.get(),idLocn.get()));
            //<< set idToMainLocn   = $$MainSite^WWW0121Utils(idCompany,idToLocn)
            idToMainLocn.set(m$.fnc$("WWW0121Utils.MainSite",idCompany.get(),idToLocn.get()));
            //<< if (idToMainLocn="") {
            if ((mOp.Equal(idToMainLocn.get(),""))) {
              //<< set blnDataAccess = $listbuild("IN00384",idToLocn)  ; "Can't find main location for %1"
              blnDataAccess.set(m$.Fnc.$listbuild("IN00384",idToLocn.get()));
            }
            //<< 
            //<< } elseif (idFromMainLocn="") {
            else if ((mOp.Equal(idFromMainLocn.get(),""))) {
              //<< set blnDataAccess = $listbuild("IN00384",idLocn)    ; "Can't find main location for %1"
              blnDataAccess.set(m$.Fnc.$listbuild("IN00384",idLocn.get()));
            }
            //<< } else {
            else {
              //<< if $$$INIssueType(YFELD) = 1 { ; Department
              if (mOp.Equal(include.INConst.$$$INIssueType(m$,YFELD),1)) {
                //<< if idFromMainLocn'=idToMainLocn {
                if (mOp.NotEqual(idFromMainLocn.get(),idToMainLocn.get())) {
                  //<< set blnDataAccess = $listbuild("IN01077",idToMainLocn,idFromMainLocn)
                  blnDataAccess.set(m$.Fnc.$listbuild("IN01077",idToMainLocn.get(),idFromMainLocn.get()));
                }
              }
              //<< ;                       "Issue requires the same Main Location : %1, %2"
              //<< }
              //<< } elseif $$$INIssueType(YFELD) = 2 { ; Transfer
              else if (mOp.Equal(include.INConst.$$$INIssueType(m$,YFELD),2)) {
                //<< if idFromMainLocn=idToMainLocn {
                if (mOp.Equal(idFromMainLocn.get(),idToMainLocn.get())) {
                  //<< set blnDataAccess = $listbuild("IN01078",idToMainLocn,idFromMainLocn)
                  blnDataAccess.set(m$.Fnc.$listbuild("IN01078",idToMainLocn.get(),idFromMainLocn.get()));
                }
              }
              //<< ;                       "Issue requires different Main Locations : %1, %2"
              //<< }
              //<< } else {
              else {
              }
            }
          }
        }
      }
    }
    //<< //
    //<< }
    //<< }
    //<< }
    //<< }
    //<< }
    //<< 
    //<< // ^^^ SR16768
    //<< 
    //<< } elseif YFORM = "INMOV" {
    else if (mOp.Equal(YFORM.get(),"INMOV")) {
      //<< if '$$InventoryAllowed^WWW0121Rules(idCompany,idLocn) {
      if (mOp.Not(m$.fnc$("WWW0121Rules.InventoryAllowed",idCompany.get(),idLocn.get()))) {
        //<< set blnDataAccess = $$$MakeStatus("WWW00078")     ; "This location isn't set as an Inventory Location"
        blnDataAccess.set(include.COMSYS.$$$MakeStatus(m$,"WWW00078"));
      }
      //<< 
      //<< } elseif pidDataType="D" {
      else if (mOp.Equal(pidDataType.get(),"D")) {
        //<< if pintFldNo=2 {
        if (mOp.Equal(pintFldNo.get(),2)) {
          //<< if idLocn'=YLOCATION {
          if (mOp.NotEqual(idLocn.get(),m$.var("YLOCATION").get())) {
            //<< set strPath = $$GetPath^WWW0121Utils(idCompany,idLocn)
            strPath.set(m$.fnc$("WWW0121Utils.GetPath",idCompany.get(),idLocn.get()));
            //<< set strPath = $$$COMMA_$translate(strPath,"~",",")_$$$COMMA
            strPath.set(mOp.Concat(mOp.Concat(include.COMSYSString.$$$COMMA(m$),m$.Fnc.$translate(strPath.get(),"~",",")),include.COMSYSString.$$$COMMA(m$)));
            //<< if strPath'[($$$COMMA_YLOCATION_$$$COMMA) {
            if (mOp.NotContains(strPath.get(),(mOp.Concat(mOp.Concat(include.COMSYSString.$$$COMMA(m$),m$.var("YLOCATION").get()),include.COMSYSString.$$$COMMA(m$))))) {
              //<< set blnDataAccess = $listbuild("IN00513",YLOCATION)
              blnDataAccess.set(m$.Fnc.$listbuild("IN00513",m$.var("YLOCATION").get()));
            }
          }
        }
      }
    }
    //<< ;                       "Move Location must be local to user's location : %1"
    //<< }
    //<< }
    //<< }
    //<< }
    //<< }
    //<< quit blnDataAccess
    return blnDataAccess.get();
  }

  //<< 
  //<< 
  //<< AccessAllowed(pidCompany,pidLocn,pstrLocnList)
  public Object AccessAllowed(Object ... _p) {
    mVar pidCompany = m$.newVarRef("pidCompany",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pidLocn = m$.newVarRef("pidLocn",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pstrLocnList = m$.newVarRef("pstrLocnList",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Limits the list of locations that a user can switch to based on the 'Allowed Locations'
    //<< ; in the users profile.
    //<< ;
    //<< ; Params:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 24-Oct-2007   GRF     SR15563: Extract from OnDataAccess
    //<< ;-------------------------------------------------------------------------------
    //<< new blnAllowed
    mVar blnAllowed = m$.var("blnAllowed");
    m$.newVar(blnAllowed);
    //<< 
    //<< set blnAllowed = $$$NO
    blnAllowed.set(include.COMSYS.$$$NO(m$));
    //<< if (pidCompany=YM) && (pidLocn'="") {
    if ((mOp.Equal(pidCompany.get(),m$.var("YM").get())) && (mOp.NotEqual(pidLocn.get(),""))) {
      //<< if (pstrLocnList="") || ((";"_pstrLocnList_";")[(";"_pidLocn_";")) {
      if ((mOp.Equal(pstrLocnList.get(),"")) || (mOp.Contains((mOp.Concat(mOp.Concat(";",pstrLocnList.get()),";")),(mOp.Concat(mOp.Concat(";",pidLocn.get()),";"))))) {
        //<< set blnAllowed = $$$YES
        blnAllowed.set(include.COMSYS.$$$YES(m$));
      }
    }
    //<< }
    //<< }
    //<< quit blnAllowed
    return blnAllowed.get();
  }

  //<< 
  //<< 
  //<< CreateLocationPopup(strFieldId)
  public Object CreateLocationPopup(Object ... _p) {
    mVar strFieldId = m$.newVarRef("strFieldId",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Write the javascript code to create a popup screen.
    //<< ; This routine is similar to ^WWW0121.
    //<< ;
    //<< ; The ^WWW0121 write the image of the search tree with the link. It should
    //<< ; be used on a form construction to place the button after or before the data field.
    //<< ; The routine ^WWW0121 only works if you use it within the events "Execute on Form
    //<< ; Construction (before)" or "Execute on Form Construction (after)" because it uses
    //<< ; the global variables YART and YLFN.
    //<< ;
    //<< ; This routine writes just the code to be executed to show the popup screen.
    //<< ; It should be used on a CallBackNow call or directly from a EventValue call. This
    //<< ; routine was created to be used to add the Location Search screen button after a
    //<< ; datafield. Create a button, and add the call on the "Hyper Event OnClick" field:
    //<< ;
    //<< ; - 'CreateLocationPopup^WWW0121'              if the button is to be shown on a Grid Edit    or
    //<< ; - 'CreateLocationPopup^WWW0121(YFormnameD2)' if the button is to be shown after the regular datafield.
    //<< ;
    //<< ; You should pass as parameter the data field type (e.g. 'M', 'D') and the data
    //<< ; field number of the field that will receive the id of the Location selected on
    //<< ; the popup screen.
    //<< ;
    //<< ; Then go the field definition where you want to add the button next to and select
    //<< ; the created button on the property 'Button After Input Field'.
    //<< ;
    //<< ; ***** 18-Oct-2007: Additional notes.
    //<< ;                    Create a button in a grid form with the 'Function (JavaScript) OnClick' property
    //<< ;                    set to CallBack('CreateLocationPopup^WWW0121','YFIELDNAME')
    //<< ;                    Then it is not necessary to use the "Execute on Form Construction (after)"
    //<< ;                    or worry about the id of the field
    //<< ;
    //<< ; Params:
    //<< ;   strFieldId   - the id of the field that will receive the id of the selected location.
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 18-Oct-2007   shobby  SRBR014566: More information in header comments.
    //<< ; 23-Aug-2007   Frank   SRBR014566: Created
    //<< ;-------------------------------------------------------------------------------
    //<< &html<
    //<< #($$CreateLocationPopupJS(strFieldId))#
    //<< >
    m$.Cmd.WriteHtml(mOp.Modulus("",(m$.fnc$("CreateLocationPopupJS",strFieldId.get()))),"\n");
    m$.Cmd.WriteHtml("    ");
    //<< quit $$$OK
    return include.COMSYS.$$$OK(m$);
  }

  //<< 
  //<< CreateLocationPopupJS(strFieldId)
  public Object CreateLocationPopupJS(Object ... _p) {
    mVar strFieldId = m$.newVarRef("strFieldId",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ;
    //<< ;
    //<< ; Inputs:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 18-Oct-2007   shobby      SRBR014566: Commented
    //<< ;-------------------------------------------------------------------------------
    //<< new strURL,strOPT,strLocationPopupJS
    mVar strURL = m$.var("strURL");
    mVar strOPT = m$.var("strOPT");
    mVar strLocationPopupJS = m$.var("strLocationPopupJS");
    m$.newVar(strURL,strOPT,strLocationPopupJS);
    //<< 
    //<< set strURL = YAKTION_"EP=WWWMANU1&amp;YEXEC=D|START^WWW0121&amp;YUSER="_YUSER_"&amp;YBED="_YBED_"&amp;YTRAKT="_YTRAKT
    strURL.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(m$.var("YAKTION").get(),"EP=WWWMANU1&amp;YEXEC=D|START^WWW0121&amp;YUSER="),m$.var("YUSER").get()),"&amp;YBED="),m$.var("YBED").get()),"&amp;YTRAKT="),m$.var("YTRAKT").get()));
    //<< set strURL = strURL_"&amp;YUCI="_$get(YUCI)_"&amp;YM="_YM_"&amp;YKEY="_YKEY_"&amp;YBACK="_YBACK_"&amp;YLFDAT="_strFieldId
    strURL.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(strURL.get(),"&amp;YUCI="),m$.Fnc.$get(m$.var("YUCI"))),"&amp;YM="),m$.var("YM").get()),"&amp;YKEY="),m$.var("YKEY").get()),"&amp;YBACK="),m$.var("YBACK").get()),"&amp;YLFDAT="),strFieldId.get()));
    //<< set strURL = strURL_"&amp;YLFFORM="_$get(YBBN)_"&amp;YFORM="_YFORM
    strURL.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(strURL.get(),"&amp;YLFFORM="),m$.Fnc.$get(m$.var("YBBN"))),"&amp;YFORM="),m$.var("YFORM").get()));
    //<< set strOPT = "HEIGHT=500,WIDTH=400,SCROLLBARS=YES,RESIZEABLE=YES"
    strOPT.set("HEIGHT=500,WIDTH=400,SCROLLBARS=YES,RESIZEABLE=YES");
    //<< 
    //<< quit "subWindow("""_strURL_""",""Structure"","""_strOPT_""");"
    return mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("subWindow(\"",strURL.get()),"\",\"Structure\",\""),strOPT.get()),"\");");
  }

  //<< 
  //<< 
  //<< START
  public void START() {
    //<< ;-------------------------------------------------------------------------------
    //<< ;   AUSWERTEN VARIABELEN UND STARTEN WWWPARAM (ANZEIGE DATEN IN MENUFORM)
    //<< ;
    //<< ; History:
    //<< ; 09-Sep-2008   GRF
    //<< ; 05-Sep-2007   GRF     SR15594: fix for SRBR014582 - YM is required to work with
    //<< ;                           all other forms, YKEY is special situation.
    //<< ; 18-Jul-2007   Karine  SRBR014582: Search location popup was fixed for company
    //<< ;                           related to the user logged in.
    //<< ; 12-Jun-2007   RPW     SR15537: Let the system know to close on existing data
    //<< ; 12-Jun-2007   RPW     SRadhoc: removed . syntax
    //<< ;-------------------------------------------------------------------------------
    //<< NEW (%request,%session,%KEY,%,%ZCS,%CGIEVAR)
    //<< 
    //<< DO ^WWWVAR  ;VORGABEN SETZEN ;set defaults
    m$.Cmd.Do("WWWVAR.main");
    //<< 
    //<< ; FIXME : This is the * OLD * hierarchy structure based on delimiters and
    //<< ;         *NOT* the Parent Location field (WWW0121 D20).
    //<< ;         Using this mechanism location 1004-1 is subordinate to 1004
    //<< ;         regardless of the link in D20.
    //<< ;
    //<< ;         A record for ^WWW0121(0,0,"A-B-C-D") becomes
    //<< ;                      ^WWW01210(0,"A","B","C","D") = "name~A-B-C-D"
    //<< 
    //<< ;---------------------------------------
    //<< ; WWW01210 is not a defined @nM class; it is a multi-level keyed structure
    //<< ; created from WWW0121.  A recently created list will be reused; an older
    //<< ; list will be replaced.
    //<< ;
    //<< ; ^WWW01210(0,idLocnTree) = strLocnName [WWW0121D1] ~ idLocn
    //<< ;
    //<< ; If idLocn contains sub-locations specified by recognised delimiters
    //<< ; (e.g. "1\4\2") they will be split apart into the various pieces,
    //<< ; treating each as a separate sub-key with the delimiter characters
    //<< ; being converted to "." for processing.
    //<< ;
    //<< ; e.g. ^WWW01210(0,1,4,2) = "Locn Name~1.4.2"
    //<< ;
    //<< ; NOTE : there is no final 1 subscript on the key since it is a multi-level key.
    //<< ;---------------------------------------
    //<< 
    //<< LOCK +^WWW01210(YM):0 IF $TEST KILL ^WWW01210(YM)
    m$.Cmd.LockInc(m$.var("^WWW01210",m$.var("YM").get()),0);
    if (mOp.Logical(m$.Fnc.$test())) {
      m$.var("^WWW01210",m$.var("YM").get()).kill();
    }
    //<< 
    //<< IF '$DATA(^WWW01210(YM)) {
    if (mOp.Not(m$.Fnc.$data(m$.var("^WWW01210",m$.var("YM").get())))) {
      //<< set BETRIEB=""
      mVar BETRIEB = m$.var("BETRIEB");
      BETRIEB.set("");
      //<< for {
      for (;true;) {
        //<< set BETRIEB=$order(^WWW0121(0,0,BETRIEB))
        BETRIEB.set(m$.Fnc.$order(m$.var("^WWW0121",0,0,BETRIEB.get())));
        //<< quit:BETRIEB=""
        if (mOp.Equal(BETRIEB.get(),"")) {
          break;
        }
        //<< 
        //<< SET BETRIEB(0)   = $TRANSLATE(BETRIEB,",;-_?/+*#':<>\^|{[]}","....................")       ;ALLES PUNKT
        BETRIEB.var(0).set(m$.Fnc.$translate(BETRIEB.get(),",;-_?/+*#':<>\\^|{[]}","...................."));
        //<< SET BETRIEB("T") = $PIECE($GET(^WWW0121(0,0,BETRIEB,1)),Y,1)_Y_BETRIEB
        BETRIEB.var("T").set(mOp.Concat(mOp.Concat(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW0121",0,0,BETRIEB.get(),1)),m$.var("Y").get(),1),m$.var("Y").get()),BETRIEB.get()));
        //<< SET BETRIEB(9)   = "^WWW01210("_""""_YM_""""
        BETRIEB.var(9).set(mOp.Concat(mOp.Concat(mOp.Concat("^WWW01210(","\""),m$.var("YM").get()),"\""));
        //<< FOR BETRIEB(1)=1:1 {
        for (m$.var("BETRIEB",1).set(1);(true);m$.var("BETRIEB",1).set(mOp.Add(m$.var("BETRIEB",1).get(),1))) {
          //<< SET BETRIEB(2) = $PIECE(BETRIEB(0),".",BETRIEB(1))
          BETRIEB.var(2).set(m$.Fnc.$piece(BETRIEB.var(0).get(),".",BETRIEB.var(1).get()));
          //<< QUIT:BETRIEB(2)=""
          if (mOp.Equal(BETRIEB.var(2).get(),"")) {
            break;
          }
          //<< 
          //<< SET BETRIEB(9) = BETRIEB(9)_","_""""_BETRIEB(2)_""""
          BETRIEB.var(9).set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(BETRIEB.var(9).get(),","),"\""),BETRIEB.var(2).get()),"\""));
        }
        //<< }
        //<< 
        //<< SET BETRIEB(8)  = BETRIEB(9)_")"
        BETRIEB.var(8).set(mOp.Concat(BETRIEB.var(9).get(),")"));
        //<< SET @BETRIEB(8) = BETRIEB("T")       ; Create ^WWW01210
        m$.indirectVar(BETRIEB.var(8).get()).set(BETRIEB.var("T").get());
      }
    }
    //<< }
    //<< }
    //<< 
    //<< ;---------------------------------------
    //<< ;&FILE      = DATEI DIE ANGEZEIGT WIRD (STANDARD=WWWEXPLORE)
    //<< ;&FIX       = FESTER ERSTER KEY (NUR WENN &FILE)
    //<< ;&RECORD    = FELDER DIE ANGEZEIGT WERDEN SOLLEN (STANDARD=1)
    //<< ;&OFFSET    = STRUKTUR (WIRD GEBILDET)
    //<< ;&HEAD      = TEXT FÜR HEADER
    //<< ;---------------------------------------
    //<< SET %(YQUERY,"TARGET") = $GET(YTARGET)     ;TARGET DER AUSGABE ;the expenses
    m$.var("%",m$.var("YQUERY").get(),"TARGET").set(m$.Fnc.$get(m$.var("YTARGET")));
    //<< SET %(YQUERY,"FILE")   = "WWW01210"
    m$.var("%",m$.var("YQUERY").get(),"FILE").set("WWW01210");
    //<< 
    //<< ;---------------------------------------
    //<< ; NOTE : Class WWW0121 allows the user to set up location details for a company
    //<< ;        when not in that company.  It is necessary to obtain the company ID
    //<< ;        from YKEY than simply YM.
    //<< ;---------------------------------------
    //<< 
    //<< ; Could also test for YFORM="SALLocation" but that form does not appear to be in use. <GRF>
    //<< 
    //<< if YFORM="WWW0121" {                       ; SRBR014582   ; SR15594
    if (mOp.Equal(m$.var("YFORM").get(),"WWW0121")) {
      //<< SET %(YQUERY,"FIX") = YKEY
      m$.var("%",m$.var("YQUERY").get(),"FIX").set(m$.var("YKEY").get());
    }
    //<< } else {
    else {
      //<< SET %(YQUERY,"FIX") = YM
      m$.var("%",m$.var("YQUERY").get(),"FIX").set(m$.var("YM").get());
    }
    //<< }
    //<< SET %(YQUERY,"RECORD") = "1"               ; FIELDS TO BE NOTIFIED ; FELDER, DIE ANGEZEIGT WERDEN (1,2,3,4)
    m$.var("%",m$.var("YQUERY").get(),"RECORD").set("1");
    //<< SET %(YQUERY,"YUCI")   = $GET(YUCI)        ; NAMESPACE
    m$.var("%",m$.var("YQUERY").get(),"YUCI").set(m$.Fnc.$get(m$.var("YUCI")));
    //<< SET %(YQUERY,"HEAD")   = $$^WWWTEXT(388)   ; "Location"    BETRIEB
    m$.var("%",m$.var("YQUERY").get(),"HEAD").set(m$.fnc$("WWWTEXT.main",388));
    //<< SET %(YQUERY,"YKEY")   = YKEY
    m$.var("%",m$.var("YQUERY").get(),"YKEY").set(m$.var("YKEY").get());
    //<< SET %(YQUERY,"YTRAKT") = YTRAKT
    m$.var("%",m$.var("YQUERY").get(),"YTRAKT").set(m$.var("YTRAKT").get());
    //<< SET %(YQUERY,"YBACK")  = YBACK
    m$.var("%",m$.var("YQUERY").get(),"YBACK").set(m$.var("YBACK").get());
    //<< SET %(YQUERY,"FORM")   = YFORM             ;ERFASSEN  ;Edit
    m$.var("%",m$.var("YQUERY").get(),"FORM").set(m$.var("YFORM").get());
    //<< SET %(YQUERY,"YFORM")  = YFORM             ;ERFASSEN BETRIEB ;Edit location
    m$.var("%",m$.var("YQUERY").get(),"YFORM").set(m$.var("YFORM").get());
    //<< SET %(YQUERY,"OFFSET") = ""                ;ANZEIGE AB SUBSCRIPT ;Show Confirm.
    m$.var("%",m$.var("YQUERY").get(),"OFFSET").set("");
    //<< ;SET %(YQUERY,"YBILD") = "www"             ;ANZEIGE AB SUBSCRIPT
    //<< ;&YLFDAT="_"Y"_YFORM_YART_YLFN_"&YLFORM="_$get(YBBN)
    //<< 
    //<< set YIGNOREJUMP=1                          ; SR15537
    mVar YIGNOREJUMP = m$.var("YIGNOREJUMP");
    YIGNOREJUMP.set(1);
    //<< 
    //<< MERGE %KEY=%(YQUERY)
    m$.Cmd.Merge(m$.var("%KEY"),m$.var("%",m$.var("YQUERY").get()));
    //<< 
    //<< DO ^WWWPARAM
    m$.Cmd.Do("WWWPARAM.main");
    //<< QUIT
    return;
  }

  //<< 
  //<< 
  //<< OnBeforeSave(pidKey,pYFELD,pYFORM="WWW0121")
  public Object OnBeforeSave(Object ... _p) {
    mVar pidKey = m$.newVarRef("pidKey",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pYFELD = m$.newVarRef("pYFELD",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pYFORM = m$.newVarRef("pYFORM",(((_p!=null)&&(_p.length>=3))?_p[2]:null),"WWW0121");
    //<< ;-------------------------------------------------------------------------------
    //<< ; On Before Save of WWW0121 form
    //<< ;
    //<< ; Params:
    //<< ;   pidKEY      YM,locn
    //<< ;   pYFELD      objWWW0121
    //<< ;   pYFORM      "WWW0121C", etc. as means of triggering extra validation
    //<< ;
    //<< ; ByRefs:
    //<< ;   Q           Save/Don't Save flag
    //<< ;
    //<< ; Returns: none
    //<< ;
    //<< ; History:
    //<< ; 29-Nov-2011   GRF     SR17967: Ensure location hierarchy is up-to-date before
    //<< ;                           Getting current cost centre in OnLocnChange.
    //<< ; 23-Oct-2009   GRF     SR16871: Check potential changes affecting Cost Centre
    //<< ; 15-Oct-2007   GRF     SR15563: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new idCompany,idLocn,strStatus
    mVar idCompany = m$.var("idCompany");
    mVar idLocn = m$.var("idLocn");
    mVar strStatus = m$.var("strStatus");
    m$.newVar(idCompany,idLocn,strStatus);
    //<< 
    //<< set idCompany = $$$KEY1(pidKey)
    idCompany.set(include.COMSYSWWW.$$$KEY1(m$,pidKey));
    //<< set idLocn    = $$$KEY2(pidKey)
    idLocn.set(include.COMSYSWWW.$$$KEY2(m$,pidKey));
    //<< 
    //<< do MakePath^WWW0121Utils(idCompany)             ; SR17967
    m$.Cmd.Do("WWW0121Utils.MakePath",idCompany.get());
    //<< set strStatus = $$OnBeforeSave^WWW0121Rules(idCompany,idLocn,pYFELD,pYFORM)
    strStatus.set(m$.fnc$("WWW0121Rules.OnBeforeSave",idCompany.get(),idLocn.get(),pYFELD.get(),pYFORM.get()));
    //<< 
    //<< if $$$ISERR(strStatus) {
    if (mOp.Logical(include.COMSYS.$$$ISERR(m$,strStatus))) {
      //<< $$$DecomposeStatus(strStatus)
      include.COMSYS.$$$DecomposeStatus(m$,strStatus);
      //<< $$$Alert(strStatus)
      include.COMSYS.$$$Alert(m$,strStatus);
      //<< set Q = $$$QDontSave
      mVar Q = m$.var("Q");
      Q.set(include.COMSYSWWW.$$$QDontSave(m$));
    }
    //<< 
    //<< } else {  ; SR16871
    else {
      //<< do OnLocnChange^INCostCentre(idLocn,pYFELD)
      m$.Cmd.Do("INCostCentre.OnLocnChange",idLocn.get(),pYFELD.get());
    }
    //<< }
    //<< 
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< OnAfterSave(pYKEY,pYFELD)
  public Object OnAfterSave(Object ... _p) {
    mVar pYKEY = m$.newVarRef("pYKEY",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pYFELD = m$.newVarRef("pYFELD",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; On After Save of WWW0121 form
    //<< ;
    //<< ; Params:
    //<< ;
    //<< ; ByRefs:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 26-Oct-2007   GRF     SR15563: pass coy to DeleteStockLoc since may not match YM
    //<< ; 18-Oct-2007   GRF     SR15563: Rebuild Location Path shortcut; correct keys
    //<< ;                           for FINMATRIX call
    //<< ; 28-Apr-2006   JW      SR14421: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new idCompany,idLocn
    mVar idCompany = m$.var("idCompany");
    mVar idLocn = m$.var("idLocn");
    m$.newVar(idCompany,idLocn);
    //<< 
    //<< set idCompany = $$$KEY1(pYKEY)
    idCompany.set(include.COMSYSWWW.$$$KEY1(m$,pYKEY));
    //<< set idLocn    = $$$KEY2(pYKEY)
    idLocn.set(include.COMSYSWWW.$$$KEY2(m$,pYKEY));
    //<< do MakePath^WWW0121Utils(idCompany)             ; SR15563
    m$.Cmd.Do("WWW0121Utils.MakePath",idCompany.get());
    //<< do FINMATRIX^INFIBCHARMATRIX(pYKEY,pYFELD)      ; Code from form def
    m$.Cmd.Do("INFIBCHARMATRIX.FINMATRIX",pYKEY.get(),pYFELD.get());
    //<< do CreateDeleteStockLoc(idCompany,idLocn)
    m$.Cmd.Do("CreateDeleteStockLoc",idCompany.get(),idLocn.get());
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< CreateDeleteStockLoc(pidCompany,pidLocn)
  public Object CreateDeleteStockLoc(Object ... _p) {
    mVar pidCompany = m$.newVarRef("pidCompany",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pidLocn = m$.newVarRef("pidLocn",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Create Delete Stock location for this location
    //<< ;
    //<< ; Params:
    //<< ;   pidCompany
    //<< ;   pidLocn     Location
    //<< ;
    //<< ; History:
    //<< ; 24-Oct-2008   HQN     SR16057: Create delete storage for transfer locations
    //<< ;                           this allows handling of consumption locations
    //<< ; 11-Feb-2008   GRF
    //<< ; 26-Oct-2007   GRF     SR15563: Don't create if location is not flagged as
    //<< ;                           an "Inventory Location"; pass coy since may not
    //<< ;                           match YM if called from form WWW0121
    //<< ; 28-Apr-2006   JW      SR14421: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new idDelStkLocn
    mVar idDelStkLocn = m$.var("idDelStkLocn");
    m$.newVar(idDelStkLocn);
    //<< 
    //<< set idDelStkLocn = $$$INVORGDeleteStockLocation($get(^INVORG(pidCompany,pidCompany,1)))
    idDelStkLocn.set(include.INConst.$$$INVORGDeleteStockLocation(m$,m$.Fnc.$get(m$.var("^INVORG",pidCompany.get(),pidCompany.get(),1))));
    //<< 
    //<< quit:idDelStkLocn=""
    if (mOp.Equal(idDelStkLocn.get(),"")) {
      return null;
    }
    //<< 
    //<< ;if $$InventoryAllowed^WWW0121Rules(pidCompany,pidLocn) {
    //<< if $$InventoryAllowed^WWW0121Rules(pidCompany,pidLocn) || $$TransferLocation^WWW0121Rules(pidCompany,pidLocn) { ; SR16057
    if (mOp.Logical(m$.fnc$("WWW0121Rules.InventoryAllowed",pidCompany.get(),pidLocn.get())) || mOp.Logical(m$.fnc$("WWW0121Rules.TransferLocation",pidCompany.get(),pidLocn.get()))) {
      //<< ;   if '$data(^INLP(YM,pidLocn,idDelStkLocn,1)) {
      //<< if '$data(^INLP(pidCompany,pidLocn,idDelStkLocn,1)) {
      if (mOp.Not(m$.Fnc.$data(m$.var("^INLP",pidCompany.get(),pidLocn.get(),idDelStkLocn.get(),1)))) {
        //<< do Save^COMUtils("INLP",pidLocn_","_idDelStkLocn,"",1)
        m$.Cmd.Do("COMUtils.Save","INLP",mOp.Concat(mOp.Concat(pidLocn.get(),","),idDelStkLocn.get()),"",1);
      }
    }
    //<< }
    //<< }
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< OnDeleteCheck(pidKey,pYFELD,pYFORM)
  public Object OnDeleteCheck(Object ... _p) {
    mVar pidKey = m$.newVarRef("pidKey",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pYFELD = m$.newVarRef("pYFELD",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pYFORM = m$.newVarRef("pYFORM",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; History:
    //<< ; 29-Sep-2008   Luke    SR15936: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new idCompany,idLocn,objLocn,strStatus,strMessage
    mVar idCompany = m$.var("idCompany");
    mVar idLocn = m$.var("idLocn");
    mVar objLocn = m$.var("objLocn");
    mVar strStatus = m$.var("strStatus");
    mVar strMessage = m$.var("strMessage");
    m$.newVar(idCompany,idLocn,objLocn,strStatus,strMessage);
    //<< 
    //<< set strStatus = $$$OK
    strStatus.set(include.COMSYS.$$$OK(m$));
    //<< set idCompany = $$$KEY1(pidKey)
    idCompany.set(include.COMSYSWWW.$$$KEY1(m$,pidKey));
    //<< set idLocn    = $$$KEY2(pidKey)
    idLocn.set(include.COMSYSWWW.$$$KEY2(m$,pidKey));
    //<< set objLocn = ##class(alLOC.dLocation).%OpenId(idLocn)
    objLocn.set(m$.fnc$("alLOC.dLocation.$OpenId",idLocn.get()));
    //<< set Q=$$$QDelete
    mVar Q = m$.var("Q");
    Q.set(include.COMSYSWWW.$$$QDelete(m$));
    //<< if objLocn '= $$$NULLOREF {
    if (mOp.NotEqual(objLocn.get(),include.$occConstant.$$$NULLOREF(m$))) {
      //<< if objLocn.Storages.Count() > 0 {
      if (mOp.Greater(m$.fnc$(objLocn.getORef(),"Storages.Count"),0)) {
        //<< set strMessage = $$$Text("alLOC0008",idLocn)
        strMessage.set(include.COMSYS.$$$Text(m$,"alLOC0008",idLocn));
        //<< set Q=$$$QDontDelete _" "_  strMessage
        Q.set(mOp.Concat(mOp.Concat(include.COMSYSWWW.$$$QDontDelete(m$)," "),strMessage.get()));
      }
    }
    //<< }
    //<< } ; "Can not Delete Location (%1) as storages still exist. Please remove all Storages from this location to delete"
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< OnBeforeDelete(pidKey,pYFELD,pYFORM="WWW0121")
  public Object OnBeforeDelete(Object ... _p) {
    mVar pidKey = m$.newVarRef("pidKey",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pYFELD = m$.newVarRef("pYFELD",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pYFORM = m$.newVarRef("pYFORM",(((_p!=null)&&(_p.length>=3))?_p[2]:null),"WWW0121");
    //<< ;-------------------------------------------------------------------------------
    //<< ; On Before Deletion of WWW0121 form
    //<< ;
    //<< ; Params:
    //<< ;   pidKEY      YM,locn
    //<< ;   pYFELD      objWWW0121
    //<< ;   pYFORM      "WWW0121C", etc. as means of triggering extra validation
    //<< ;
    //<< ; ByRefs:
    //<< ;   Q           Save/Don't Save flag
    //<< ;
    //<< ; Returns: none
    //<< ;
    //<< ; History:
    //<< ; 29-Nov-2011   GRF     SR17967: Ensure location hierarchy is up-to-date before
    //<< ;                           Getting current cost centre in OnLocnChange.
    //<< ; 23-Oct-2009   GRF     SR16871: Check potential changes affecting Cost Centre
    //<< ; 17-Oct-2007   GRF     SR15563: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new idCompany,idLocn,strStatus
    mVar idCompany = m$.var("idCompany");
    mVar idLocn = m$.var("idLocn");
    mVar strStatus = m$.var("strStatus");
    m$.newVar(idCompany,idLocn,strStatus);
    //<< 
    //<< set idCompany = $$$KEY1(pidKey)
    idCompany.set(include.COMSYSWWW.$$$KEY1(m$,pidKey));
    //<< set idLocn    = $$$KEY2(pidKey)
    idLocn.set(include.COMSYSWWW.$$$KEY2(m$,pidKey));
    //<< 
    //<< do MakePath^WWW0121Utils(idCompany)             ; SR17967
    m$.Cmd.Do("WWW0121Utils.MakePath",idCompany.get());
    //<< set strStatus = $$OnBeforeDelete^WWW0121Rules(idCompany,idLocn,pYFELD,pYFORM)
    strStatus.set(m$.fnc$("WWW0121Rules.OnBeforeDelete",idCompany.get(),idLocn.get(),pYFELD.get(),pYFORM.get()));
    //<< if $$$ISERR(strStatus) {
    if (mOp.Logical(include.COMSYS.$$$ISERR(m$,strStatus))) {
      //<< set Q=$$$QDontDelete
      mVar Q = m$.var("Q");
      Q.set(include.COMSYSWWW.$$$QDontDelete(m$));
      //<< $$$DecomposeStatus(strStatus)
      include.COMSYS.$$$DecomposeStatus(m$,strStatus);
      //<< $$$Alert(strStatus)
      include.COMSYS.$$$Alert(m$,strStatus);
    }
    //<< 
    //<< } else {  ; SR16871
    else {
      //<< do OnLocnChange^INCostCentre(idLocn,"")
      m$.Cmd.Do("INCostCentre.OnLocnChange",idLocn.get(),"");
    }
    //<< }
    //<< 
    //<< quit strStatus
    return strStatus.get();
  }

  //<< 
  //<< OnAfterDelete(pYKEY)
  public Object OnAfterDelete(Object ... _p) {
    mVar pYKEY = m$.newVarRef("pYKEY",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; On After Delete of WWW0121 form
    //<< ;
    //<< ; Params:
    //<< ;   pYKEY   for form WWW0121    P1,P2
    //<< ;                    WWW0121C   YM
    //<< ;
    //<< ; ByRefs:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 18-Oct-2007   GRF     SR15563: Created to Rebuild Location Path shortcut
    //<< ;-------------------------------------------------------------------------------
    //<< do MakePath^WWW0121Utils($$$KEY1(pYKEY))        ; pass idCompany       ; SR15563
    m$.Cmd.Do("WWW0121Utils.MakePath",include.COMSYSWWW.$$$KEY1(m$,pYKEY));
    //<< quit
    return null;
  }

  //<< 
  //<< GetGroupDemandsBy(pidLoc)
  public Object GetGroupDemandsBy(Object ... _p) {
    mVar pidLoc = m$.newVarRef("pidLoc",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Get the Group Demands by Method, defaults to 0 if undefined.
    //<< ;
    //<< ; Inputs:
    //<< ;
    //<< ; ByRef:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 29-May-2007   RPW     SR15513: Created
    //<< ;-------------------------------------------------------------------------------
    //<< quit +$$$WWW0121GroupDemandsBy($get(^WWW0121(0,0,pidLoc,1)))
    return mOp.Positive(include.WWWConst.$$$WWW0121GroupDemandsBy(m$,m$.Fnc.$get(m$.var("^WWW0121",0,0,pidLoc.get(),1))));
  }

  //<< 
  //<< 
  //<< IsDistributionLocation(pidLocn)
  public Object IsDistributionLocation(Object ... _p) {
    mVar pidLocn = m$.newVarRef("pidLocn",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Whether the location is distribution Location or not.
    //<< ;
    //<< ; Params:   pidLocn
    //<< ;
    //<< ; Returns:  status
    //<< ;
    //<< ; History:
    //<< ; 10-Oct-2007   GRF     SR15563: Macro change
    //<< ; 30-Jul-2007   Karine  BR15548: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new strStatus,objWWW0121
    mVar strStatus = m$.var("strStatus");
    mVar objWWW0121 = m$.var("objWWW0121");
    m$.newVar(strStatus,objWWW0121);
    //<< 
    //<< set strStatus = $$$YES
    strStatus.set(include.COMSYS.$$$YES(m$));
    //<< if pidLocn'="" {
    if (mOp.NotEqual(pidLocn.get(),"")) {
      //<< set objWWW0121=$get(^WWW0121(0,0,pidLocn,1))
      objWWW0121.set(m$.Fnc.$get(m$.var("^WWW0121",0,0,pidLocn.get(),1)));
      //<< set strStatus = $$$WWW0121DistributionLocn(objWWW0121)  ; SR15563
      strStatus.set(include.WWWConst.$$$WWW0121DistributionLocn(m$,objWWW0121));
    }
    //<< }
    //<< 
    //<< quit strStatus
    return strStatus.get();
  }

  //<< 
  //<< OnBeforeDataAccess(pYKEY,pYFELD)
  public Object OnBeforeDataAccess(Object ... _p) {
    mVar pYKEY = m$.newVarRef("pYKEY",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pYFELD = m$.newVarRef("pYFELD",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; In COMView, show just locations from item selected
    //<< ;
    //<< ; Params:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 22-Jan-2008   GM      SRBR014818: fixed errors - CheckLocations parameters and
    //<< ;                           result
    //<< ; 21-Jan-2008   GRF     SRBR014847: variable prefix; doco
    //<< ; 15-Jan-2008   Luis    SRBR014847: Added a check for valid locations when
    //<< ;                           coming from INWEINVELINE
    //<< ; 18-Dec-2007   GM      SRBR014818: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new idSite,objStocktake,strSiteLocns,strStatus
    mVar idSite = m$.var("idSite");
    mVar objStocktake = m$.var("objStocktake");
    mVar strSiteLocns = m$.var("strSiteLocns");
    mVar strStatus = m$.var("strStatus");
    m$.newVar(idSite,objStocktake,strSiteLocns,strStatus);
    //<< 
    //<< $$$VAR
    include.COMSYS.$$$VAR(m$);
    //<< set strStatus = $$$OK
    strStatus.set(include.COMSYS.$$$OK(m$));
    //<< 
    //<< if YFORM="INWEINVELINE" {
    if (mOp.Equal(m$.var("YFORM").get(),"INWEINVELINE")) {
      //<< if $data(^CacheTempStocktakePara(YUSER,"idStocktake")) {
      if (mOp.Logical(m$.Fnc.$data(m$.var("^CacheTempStocktakePara",m$.var("YUSER").get(),"idStocktake")))) {
        //<< ;Load the record using the id that was stored in OnAfterPrimaryKey^INWEINVEHeader
        //<< set objStocktake = $$GetStocktake^INStocktaking($get(^CacheTempStocktakePara(YUSER,"idStocktake")))
        objStocktake.set(m$.fnc$("INStocktaking.GetStocktake",m$.Fnc.$get(m$.var("^CacheTempStocktakePara",m$.var("YUSER").get(),"idStocktake"))));
        //<< 
        //<< ;Get the list of locations
        //<< set strSiteLocns = $$$INWEINVPSiteLocation(objStocktake)
        strSiteLocns.set(include.INConst.$$$INWEINVPSiteLocation(m$,objStocktake));
        //<< 
        //<< ;Check for locations that were selected for the stocktake
        //<< set idSite    = $$$KEY2(pYKEY)
        idSite.set(include.COMSYSWWW.$$$KEY2(m$,pYKEY));
        //<< set strStatus = $$SiteCheck^INStocktaking(idSite,strSiteLocns)     ; returns pseudo-strStatus
        strStatus.set(m$.fnc$("INStocktaking.SiteCheck",idSite.get(),strSiteLocns.get()));
      }
    }
    //<< }
    //<< 
    //<< } elseif YFORM="INReqSourceLine" {
    else if (mOp.Equal(m$.var("YFORM").get(),"INReqSourceLine")) {
      //<< set strStatus = $$CheckLocations(pYKEY,+YUSER)                         ; returns strStatus
      strStatus.set(m$.fnc$("CheckLocations",pYKEY.get(),mOp.Positive(m$.var("YUSER").get())));
    }
    //<< }
    //<< quit strStatus
    return strStatus.get();
  }

  //<< 
  //<< 
  //<< CheckLocations(pYKEY,YUSER="")
  public Object CheckLocations(Object ... _p) {
    mVar pYKEY = m$.newVarRef("pYKEY",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar YUSER = m$.newVarRef("YUSER",(((_p!=null)&&(_p.length>=2))?_p[1]:null),"");
    //<< ;-------------------------------------------------------------------------------
    //<< ; In COMView, get locations from item selected
    //<< ;
    //<< ; Params:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 15-Feb-2008   GRF     SRBR014818: bln rather than str for Distribution
    //<< ; 22-Jan-2008   GM      SRBR014818: fixed errors - parameters and result
    //<< ; 07-Jan-2008   GM      SRBR014818: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new blnDistribution,idLocn,idItem,objLine,intRow,idYKEY,strYUSER,objWWW0121,strStatus
    mVar blnDistribution = m$.var("blnDistribution");
    mVar idLocn = m$.var("idLocn");
    mVar idItem = m$.var("idItem");
    mVar objLine = m$.var("objLine");
    mVar intRow = m$.var("intRow");
    mVar idYKEY = m$.var("idYKEY");
    mVar strYUSER = m$.var("strYUSER");
    mVar objWWW0121 = m$.var("objWWW0121");
    mVar strStatus = m$.var("strStatus");
    m$.newVar(blnDistribution,idLocn,idItem,objLine,intRow,idYKEY,strYUSER,objWWW0121,strStatus);
    //<< 
    //<< set strStatus = $$$OK      ; FIXME : blnInclude rather than strStatus? <GRF>
    strStatus.set(include.COMSYS.$$$OK(m$));
    //<< set idLocn    = $$$KEY2(pYKEY)
    idLocn.set(include.COMSYSWWW.$$$KEY2(m$,pYKEY));
    //<< 
    //<< if idLocn=YLOCATION {
    if (mOp.Equal(idLocn.get(),m$.var("YLOCATION").get())) {
      //<< set strStatus = '$$$OK
      strStatus.set(mOp.Not(include.COMSYS.$$$OK(m$)));
    }
    //<< 
    //<< } else {
    else {
      //<< set idItem = ""
      idItem.set("");
      //<< set intRow = $piece($piece($get(^WWWDATEN(0,+$horolog,YUSER,YFORM,"V","FOCUSFIELD")),"Y",2),"_",1)
      intRow.set(m$.Fnc.$piece(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWWDATEN",0,mOp.Positive(m$.Fnc.$horolog()),YUSER.get(),m$.var("YFORM").get(),"V","FOCUSFIELD")),"Y",2),"_",1));
      //<< if intRow'="" {
      if (mOp.NotEqual(intRow.get(),"")) {
        //<< set idYKEY = $$GetYKEY^COMGridEdit31Interface(intRow)
        idYKEY.set(m$.fnc$("COMGridEdit31Interface.GetYKEY",intRow.get()));
        //<< set objLine = $$$GRIDGetYFELD(idYKEY)
        objLine.set(include.COMGridEdit31Interface.$$$GRIDGetYFELD(m$,idYKEY));
        //<< set idItem  = $$$INRequisitionItem(objLine)
        idItem.set(include.INConst.$$$INRequisitionItem(m$,objLine));
        //<< set objWWW0121 = $get(^WWW0121(0,0,idLocn,1))
        objWWW0121.set(m$.Fnc.$get(m$.var("^WWW0121",0,0,idLocn.get(),1)));
      }
      //<< }
      //<< 
      //<< //only include the location in the warehouses if it's a distribution location
      //<< set blnDistribution = $$$WWW0121DistributionLocn(objWWW0121)
      blnDistribution.set(include.WWWConst.$$$WWW0121DistributionLocn(m$,objWWW0121));
      //<< 
      //<< if idItem="" {
      if (mOp.Equal(idItem.get(),"")) {
        //<< set strStatus='$$$OK
        strStatus.set(mOp.Not(include.COMSYS.$$$OK(m$)));
      }
      //<< 
      //<< } elseif '$data(^WWW0121(0,0,idLocn)){
      else if (mOp.Not(m$.Fnc.$data(m$.var("^WWW0121",0,0,idLocn.get())))) {
        //<< set strStatus = '$$$OK
        strStatus.set(mOp.Not(include.COMSYS.$$$OK(m$)));
      }
      //<< 
      //<< } elseif 'blnDistribution {
      else if (mOp.Not(blnDistribution.get())) {
        //<< set strStatus = '$$$OK
        strStatus.set(mOp.Not(include.COMSYS.$$$OK(m$)));
      }
    }
    //<< }
    //<< }
    //<< quit strStatus
    return strStatus.get();
  }

  //<< 
  //<< 
  //<< TemporaryStorageLocations(pidLocn,pblnIgnoreThis=$$$NO)
  public Object TemporaryStorageLocations(Object ... _p) {
    mVar pidLocn = m$.newVarRef("pidLocn",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pblnIgnoreThis = m$.newVarRef("pblnIgnoreThis",(((_p!=null)&&(_p.length>=2))?_p[1]:null),include.COMSYS.$$$NO(m$));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Returns whether this location supports TSU (pallets) or,
    //<< ; if inherited ($$$INHERIT = ""), continue looking up the location tree for an answer.
    //<< ;
    //<< ; Inputs:
    //<< ; pblnIgnoreThis : $$$YES - Show inherited value if we set current location to $$$INHERIT
    //<< ;                  $$$NO  - Show current actual or inherited value
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 11-Nov-2010   shobby  SR17612: $$$INHERIT macro is now ""
    //<< ; 26-Oct-2010   GRF     SR17541: $$$INHERIT macro
    //<< ; 07-Oct-2010   shobby  SR17541: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new blnResult,objWWW0121
    mVar blnResult = m$.var("blnResult");
    mVar objWWW0121 = m$.var("objWWW0121");
    m$.newVar(blnResult,objWWW0121);
    //<< 
    //<< set blnResult = $$$NO
    blnResult.set(include.COMSYS.$$$NO(m$));
    //<< if pidLocn'="" {
    if (mOp.NotEqual(pidLocn.get(),"")) {
      //<< for {
      for (;true;) {
        //<< set objWWW0121 = $get(^WWW0121(0,0,pidLocn,1))
        objWWW0121.set(m$.Fnc.$get(m$.var("^WWW0121",0,0,pidLocn.get(),1)));
        //<< if 'pblnIgnoreThis {
        if (mOp.Not(pblnIgnoreThis.get())) {
          //<< set blnResult = $$$WWW0121TemporaryStorageLocations(objWWW0121)
          blnResult.set(include.WWWConst.$$$WWW0121TemporaryStorageLocations(m$,objWWW0121));
          //<< quit:(blnResult'=$$$INHERIT)
          if ((mOp.NotEqual(blnResult.get(),include.COMSYS.$$$INHERIT(m$)))) {
            break;
          }
        }
        //<< 
        //<< } else {
        else {
          //<< set pblnIgnoreThis = $$$NO
          pblnIgnoreThis.set(include.COMSYS.$$$NO(m$));
        }
        //<< }
        //<< set pidLocn = $$$WWW0121ParentLocn(objWWW0121)
        pidLocn.set(include.WWWConst.$$$WWW0121ParentLocn(m$,objWWW0121));
        //<< quit:(pidLocn="")
        if ((mOp.Equal(pidLocn.get(),""))) {
          break;
        }
      }
    }
    //<< }
    //<< 
    //<< }
    //<< if blnResult=$$$INHERIT set blnResult = $$$NO  ;Top location
    if (mOp.Equal(blnResult.get(),include.COMSYS.$$$INHERIT(m$))) {
      blnResult.set(include.COMSYS.$$$NO(m$));
    }
    //<< quit blnResult
    return blnResult.get();
  }

  //<< 
  //<< TypeCheck(pidFromLocn,pidToLocn,pblnDataAccess,pYFELD,pintFldNo)
  public Object TypeCheck(Object ... _p) {
    mVar pidFromLocn = m$.newVarRef("pidFromLocn",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pidToLocn = m$.newVarRef("pidToLocn",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pblnDataAccess = m$.newVarRef("pblnDataAccess",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    mVar pYFELD = m$.newVarRef("pYFELD",(((_p!=null)&&(_p.length>=4))?_p[3]:null));
    mVar pintFldNo = m$.newVarRef("pintFldNo",(((_p!=null)&&(_p.length>=5))?_p[4]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Check Req Type based on Locations and INVORG Type based on Destination Loc
    //<< ;
    //<< ; History:
    //<< ; 28-Mar-2013   SCR     HEVA-811: Use 'Transfer or Issue' Calc
    //<< ; 19-Mar-2013   SCR     HEVA-811: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new idFromMainLocn,idToMainLocn,objVORG,intReqType,objDest,idCalc
    mVar idFromMainLocn = m$.var("idFromMainLocn");
    mVar idToMainLocn = m$.var("idToMainLocn");
    mVar objVORG = m$.var("objVORG");
    mVar intReqType = m$.var("intReqType");
    mVar objDest = m$.var("objDest");
    mVar idCalc = m$.var("idCalc");
    m$.newVar(idFromMainLocn,idToMainLocn,objVORG,intReqType,objDest,idCalc);
    //<< 
    //<< if (pidFromLocn="") || (pidToLocn="") {
    if ((mOp.Equal(pidFromLocn.get(),"")) || (mOp.Equal(pidToLocn.get(),""))) {
      //<< quit pblnDataAccess
      return pblnDataAccess.get();
    }
    //<< }
    //<< if pidFromLocn=pidToLocn {
    if (mOp.Equal(pidFromLocn.get(),pidToLocn.get())) {
      //<< set pblnDataAccess = $listbuild("IN00404")
      pblnDataAccess.set(m$.Fnc.$listbuild("IN00404"));
      //<< ;                       "Requisition requires different locations"
      //<< quit pblnDataAccess
      return pblnDataAccess.get();
    }
    //<< 
    //<< }
    //<< set idFromMainLocn  = $$MainSite^WWW0121Utils(YM,pidFromLocn)
    idFromMainLocn.set(m$.fnc$("WWW0121Utils.MainSite",m$.var("YM").get(),pidFromLocn.get()));
    //<< set idToMainLocn    = $$MainSite^WWW0121Utils(YM,pidToLocn)
    idToMainLocn.set(m$.fnc$("WWW0121Utils.MainSite",m$.var("YM").get(),pidToLocn.get()));
    //<< set objVORG         = $get(^INVORG(YM,YM,1))
    objVORG.set(m$.Fnc.$get(m$.var("^INVORG",m$.var("YM").get(),m$.var("YM").get(),1)));
    //<< set intReqType      = $$$INReqType(pYFELD)
    intReqType.set(include.INConst.$$$INReqType(m$,pYFELD));
    //<< set idCalc          = +$$$INVORGTransferorIssueCalc(objVORG)
    idCalc.set(mOp.Positive(include.INConst.$$$INVORGTransferorIssueCalc(m$,objVORG)));
    //<< if (idCalc=0) {
    if ((mOp.Equal(idCalc.get(),0))) {
      //<< if (idToMainLocn="") {
      if ((mOp.Equal(idToMainLocn.get(),""))) {
        //<< set pblnDataAccess = $listbuild("IN00384",pidToLocn)
        pblnDataAccess.set(m$.Fnc.$listbuild("IN00384",pidToLocn.get()));
      }
      //<< ;                       "Can't find main location for %1"
      //<< } elseif (idFromMainLocn="") {
      else if ((mOp.Equal(idFromMainLocn.get(),""))) {
        //<< set pblnDataAccess = $listbuild("IN00384",pidFromLocn)
        pblnDataAccess.set(m$.Fnc.$listbuild("IN00384",pidFromLocn.get()));
      }
      //<< ;                       "Can't find main location for %1"
      //<< } else {
      else {
        //<< if ($$$INReqType(pYFELD) = 1)  { ; Department
        if ((mOp.Equal(include.INConst.$$$INReqType(m$,pYFELD),1))) {
          //<< if idFromMainLocn'=idToMainLocn {
          if (mOp.NotEqual(idFromMainLocn.get(),idToMainLocn.get())) {
            //<< set pblnDataAccess = $listbuild("IN00385",idToMainLocn,idFromMainLocn)
            pblnDataAccess.set(m$.Fnc.$listbuild("IN00385",idToMainLocn.get(),idFromMainLocn.get()));
          }
        }
        //<< ;                       "Requisition requires the same main location : %1, %2"
        //<< }
        //<< } elseif $$$INReqType(pYFELD) = 2 { ; Transfer
        else if (mOp.Equal(include.INConst.$$$INReqType(m$,pYFELD),2)) {
          //<< if idFromMainLocn=idToMainLocn {
          if (mOp.Equal(idFromMainLocn.get(),idToMainLocn.get())) {
            //<< set pblnDataAccess = $listbuild("IN01080",idToMainLocn,idFromMainLocn)  //SR16768
            pblnDataAccess.set(m$.Fnc.$listbuild("IN01080",idToMainLocn.get(),idFromMainLocn.get()));
          }
        }
      }
    }
    //<< ;       "Transfer Requisition requires different Main Locations : %1, %2"
    //<< }
    //<< }
    //<< }
    //<< } elseif (idCalc=1) {
    else if ((mOp.Equal(idCalc.get(),1))) {
      //<< set objDest = $get(^WWW0121(0,YM,pidToLocn,1))
      objDest.set(m$.Fnc.$get(m$.var("^WWW0121",0,m$.var("YM").get(),pidToLocn.get(),1)));
      //<< if (pintFldNo'=4) {
      if ((mOp.NotEqual(pintFldNo.get(),4))) {
        //<< if $$$WWW0121StorageLocn(objDest) {
        if (mOp.Logical(include.WWWConst.$$$WWW0121StorageLocn(m$,objDest))) {
          //<< set:intReqType=1 pblnDataAccess="IN01409"  ; Type must be for Inter-Site when sending to this 'To Location'
          if (mOp.Equal(intReqType.get(),1)) {
            pblnDataAccess.set("IN01409");
          }
        }
        //<< } else {
        else {
          //<< set:intReqType=2 pblnDataAccess="IN01410"  ; Type must be for Inter-Department when sending to this 'To Location'
          if (mOp.Equal(intReqType.get(),2)) {
            pblnDataAccess.set("IN01410");
          }
        }
      }
    }
    //<< }
    //<< }
    //<< 
    //<< } elseif (idCalc=2) {
    else if ((mOp.Equal(idCalc.get(),2))) {
      //<< set:intReqType'=2 pblnDataAccess =  "IN01413"  ;Type must be Inter-Site
      if (mOp.NotEqual(intReqType.get(),2)) {
        pblnDataAccess.set("IN01413");
      }
    }
    //<< } elseif (idCalc=3) {
    else if ((mOp.Equal(idCalc.get(),3))) {
      //<< set:intReqType'=1 pblnDataAccess =  "IN01412"  ;Type must be Inter-Department
      if (mOp.NotEqual(intReqType.get(),1)) {
        pblnDataAccess.set("IN01412");
      }
    }
    //<< }
    //<< 
    //<< quit $get(pblnDataAccess)
    return m$.Fnc.$get(pblnDataAccess);
  }

//<< 
}
