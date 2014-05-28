//*****************************************************************************
//** TASC - ALPHALINC - MAC WWW0121Utils
//** Innovatium Systems - Code Converter - v1.28
//** 2014-05-26 21:13:09
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
//<< #include INConst
import include.INConst;

//<< WWW0121Utils
public class WWW0121Utils extends mClass {

  //<< 
  //<< #define enumEntity      0
  public static Object $$$enumEntity(mContext m$) {
    return (0);
  }

  //<< #define enumSite        1
  public static Object $$$enumSite(mContext m$) {
    return (1);
  }

  //<< #define enumDept        2
  public static Object $$$enumDept(mContext m$) {
    return (2);
  }

  //<< 
  //<< #define BigNumber       9223372036000000000
  public static Object $$$BigNumber(mContext m$) {
    return (9223372036000000000D);
  }

  public void main() {
    _WWW0121Utils();
  }

  public void _WWW0121Utils() {
  }

  //<< 
  //<< Entity(pidCompany,pidLocn)
  public Object Entity(Object ... _p) {
    mVar pidCompany = m$.newVarRef("pidCompany",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pidLocn = m$.newVarRef("pidLocn",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Get main entity location
    //<< ;
    //<< ; Called by :   EntityQty^INARTMENGE
    //<< ;               FullTree^WWW0121Select
    //<< ;               ShowTree^WWW0121Show
    //<< ;
    //<< ; Input:
    //<< ;   pidCompany      Active company - often YM
    //<< ;   pidLocn         Location ID
    //<< ;
    //<< ; Returns:
    //<< ;   Entity Location ID
    //<< ;
    //<< ; History :
    //<< ; 20-Nov-2009   GRF     SR16871: remove company from keys
    //<< ; 02-Oct-2009   PPP     SR16892: Reverted change below - created SubEntity
    //<< ; 15-Sep-2009   PPP     SR16892: Bug fix.  Get the first Entity
    //<< ; 18-Oct-2007   GRF     revised using SavePath
    //<< ; 08-Aug-2007   FIS     created
    //<< ;-------------------------------------------------------------------------------
    //<< new strEntity
    mVar strEntity = m$.var("strEntity");
    m$.newVar(strEntity);
    //<< ;quit:($get(pidCompany)="") ""   ; SR16871
    //<< quit:($get(pidLocn)="") ""
    if ((mOp.Equal(m$.Fnc.$get(pidLocn),""))) {
      return "";
    }
    //<< 
    //<< ;do SavePath(pidCompany,$$$NO)   ; SR16871
    //<< do SavePath($$$NO)
    m$.Cmd.Do("SavePath",include.COMSYS.$$$NO(m$));
    //<< set strEntity = $piece($$GetPath(0,pidLocn),Y,4)
    strEntity.set(m$.Fnc.$piece(m$.fnc$("GetPath",0,pidLocn.get()),m$.var("Y").get(),4));
    //<< set strEntity = $piece(strEntity,",",$length(strEntity,","))
    strEntity.set(m$.Fnc.$piece(strEntity.get(),",",m$.Fnc.$length(strEntity.get(),",")));
    //<< //set strEntity = $piece(strEntity,",",1)   //SR16892
    //<< quit strEntity
    return strEntity.get();
  }

  //<< 
  //<< 
  //<< SubEntity(pidCompany,pidLocn)
  public Object SubEntity(Object ... _p) {
    mVar pidCompany = m$.newVarRef("pidCompany",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pidLocn = m$.newVarRef("pidLocn",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Get Sub Entity location for the current Location
    //<< ;
    //<< ; Called by :   SubEntityQty^INARTMENGE
    //<< ;
    //<< ; Input:
    //<< ;   pidCompany      Active company - often YM
    //<< ;   pidLocn         Location ID
    //<< ;
    //<< ; Returns:
    //<< ;   Entity Location ID
    //<< ;
    //<< ; History :
    //<< ; 20-Nov-2009   GRF     SR16871: remove company from keys
    //<< ; 15-Sep-2009   PPP     SR16892: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new strEntity
    mVar strEntity = m$.var("strEntity");
    m$.newVar(strEntity);
    //<< 
    //<< ;quit:($get(pidCompany)="") ""   ; SR16871
    //<< quit:($get(pidLocn)="") ""
    if ((mOp.Equal(m$.Fnc.$get(pidLocn),""))) {
      return "";
    }
    //<< 
    //<< ;do SavePath(pidCompany,$$$NO)   ; SR16871
    //<< do SavePath($$$NO)
    m$.Cmd.Do("SavePath",include.COMSYS.$$$NO(m$));
    //<< set strEntity = $piece($$GetPath(0,pidLocn),Y,4)
    strEntity.set(m$.Fnc.$piece(m$.fnc$("GetPath",0,pidLocn.get()),m$.var("Y").get(),4));
    //<< set strEntity = $piece(strEntity,",",1)
    strEntity.set(m$.Fnc.$piece(strEntity.get(),",",1));
    //<< quit strEntity
    return strEntity.get();
  }

  //<< 
  //<< 
  //<< MainSite(pidCompany,pidLocn)
  public Object MainSite(Object ... _p) {
    mVar pidCompany = m$.newVarRef("pidCompany",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pidLocn = m$.newVarRef("pidLocn",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Get main site location
    //<< ;
    //<< ; Input:
    //<< ;   pidCompany      Active company - often YM
    //<< ;   pidLocn         Location ID
    //<< ;
    //<< ; Returns:
    //<< ;   Site Location ID
    //<< ;
    //<< ; History :
    //<< ; 20-Nov-2009   GRF     SR16871: remove company from keys
    //<< ; 18-Oct-2007   GRF     created using SavePath
    //<< ;-------------------------------------------------------------------------------
    //<< new strSite
    mVar strSite = m$.var("strSite");
    m$.newVar(strSite);
    //<< 
    //<< ;quit:($get(pidCompany)="") ""   ; SR16871
    //<< quit:($get(pidLocn)="") ""
    if ((mOp.Equal(m$.Fnc.$get(pidLocn),""))) {
      return "";
    }
    //<< 
    //<< set Y="~"
    mVar Y = m$.var("Y");
    Y.set("~");
    //<< set strSite = $piece($$GetPath(0,pidLocn),Y,3)
    strSite.set(m$.Fnc.$piece(m$.fnc$("GetPath",0,pidLocn.get()),Y.get(),3));
    //<< 
    //<< set strSite = $piece(strSite,",",$length(strSite,","))
    strSite.set(m$.Fnc.$piece(strSite.get(),",",m$.Fnc.$length(strSite.get(),",")));
    //<< quit strSite
    return strSite.get();
  }

  //<< 
  //<< 
  //<< LocationPath(pidCompany,pidLocn)
  public Object LocationPath(Object ... _p) {
    mVar pidCompany = m$.newVarRef("pidCompany",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pidLocn = m$.newVarRef("pidLocn",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Get path from operating entity to this location
    //<< ;
    //<< ; Input:
    //<< ;   pidCompany      Active company - often YM
    //<< ;   pidLocn         Location ID
    //<< ;
    //<< ; Returns:
    //<< ;   String of Locations (Comma delimited)
    //<< ;
    //<< ; History :
    //<< ; 20-Nov-2009   GRF     SR16871: remove company from keys
    //<< ; 18-Oct-2007   GRF     SR15563: revised using SavePath
    //<< ; 17-Oct-2007   GRF     SR15563: may not have defined any locations yet
    //<< ; 08-Aug-2007   FIS     created
    //<< ;-------------------------------------------------------------------------------
    //<< new loop,strPath,strReturnPath,strSavePath
    mVar loop = m$.var("loop");
    mVar strPath = m$.var("strPath");
    mVar strReturnPath = m$.var("strReturnPath");
    mVar strSavePath = m$.var("strSavePath");
    m$.newVar(loop,strPath,strReturnPath,strSavePath);
    //<< 
    //<< ;quit:($get(pidCompany)="") ""   ; SR16871
    //<< quit:($get(pidLocn)="") ""
    if ((mOp.Equal(m$.Fnc.$get(pidLocn),""))) {
      return "";
    }
    //<< 
    //<< set strSavePath = $$GetPath(0,pidLocn)
    strSavePath.set(m$.fnc$("GetPath",0,pidLocn.get()));
    //<< 
    //<< set Y="~"
    mVar Y = m$.var("Y");
    Y.set("~");
    //<< set strReturnPath = ""
    strReturnPath.set("");
    //<< for loop=1:1:4 {
    for (loop.set(1);(mOp.LessOrEqual(loop.get(),4));loop.set(mOp.Add(loop.get(),1))) {
      //<< set strPath = $piece(strSavePath,Y,loop)
      strPath.set(m$.Fnc.$piece(strSavePath.get(),Y.get(),loop.get()));
      //<< if strPath'="" set strReturnPath = strReturnPath_","_strPath
      if (mOp.NotEqual(strPath.get(),"")) {
        strReturnPath.set(mOp.Concat(mOp.Concat(strReturnPath.get(),","),strPath.get()));
      }
    }
    //<< }
    //<< 
    //<< quit $extract(strReturnPath,2,999)
    return m$.Fnc.$extract(strReturnPath.get(),2,999);
  }

  //<< 
  //<< 
  //<< GetPath(pidCompany=0,pidLocn)
  public Object GetPath(Object ... _p) {
    mVar pidCompany = m$.newVarRef("pidCompany",(((_p!=null)&&(_p.length>=1))?_p[0]:null),0);
    mVar pidLocn = m$.newVarRef("pidLocn",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ;   Get location path for specified location
    //<< ;   Build performance global if necessary
    //<< ;
    //<< ; Inputs:
    //<< ;   pidCompany      Active company - often YM
    //<< ;   pidLocn         Location ID requiring path
    //<< ;
    //<< ; Returns:
    //<< ;   strPath         Departments~Sites~Entities for location upwards (see SavePath)
    //<< ;
    //<< ; History:
    //<< ; 30-Nov-2011   GRF     SR17967: move from CacheTemp to common global in nspace
    //<< ; 20-Nov-2009   GRF     SR16871: remove company from CacheTempWWW0121 keys
    //<< ; 03-Dec-2007   GRF     SR15612: SQL will not have YUCI
    //<< ; 16-Nov-2007   GRF     SR15563: add YUCI to ^CacheTempWWW0121("Path",...)
    //<< ;-------------------------------------------------------------------------------
    //<< new strPath
    mVar strPath = m$.var("strPath");
    m$.newVar(strPath);
    //<< 
    //<< quit:($get(pidLocn)="") ""
    if ((mOp.Equal(m$.Fnc.$get(pidLocn),""))) {
      return "";
    }
    //<< 
    //<< ;***************************************
    //<< lock +^WWW0121Path:10
    m$.Cmd.LockInc(m$.var("^WWW0121Path"),10);
    //<< do SavePath($$$NO)
    m$.Cmd.Do("SavePath",include.COMSYS.$$$NO(m$));
    //<< set strPath = $get(^WWW0121Path(0,pidLocn,1))
    strPath.set(m$.Fnc.$get(m$.var("^WWW0121Path",0,pidLocn.get(),1)));
    //<< lock -^WWW0121Path
    m$.Cmd.Unlock(m$.var("^WWW0121Path"));
    //<< ;***************************************
    //<< quit strPath                                 ; SR17967
    return strPath.get();
  }

  //<< ;if $get(YUCI)="" set YUCI = $zutil(5)
  //<< ;
  //<< ;lock +^CacheTempWWW0121("Path",YUCI):10
  //<< ;do SavePath($$$NO)
  //<< ;set strPath = $get(^CacheTempWWW0121("Path",YUCI,pidLocn))
  //<< ;lock -^CacheTempWWW0121("Path",YUCI)
  //<< ;quit strPath
  //<< 
  //<< 
  //<< MakePath(pidCompany=0)
  public Object MakePath(Object ... _p) {
    mVar pidCompany = m$.newVarRef("pidCompany",(((_p!=null)&&(_p.length>=1))?_p[0]:null),0);
    //<< ;-------------------------------------------------------------------------------
    //<< ;   ENTRY POINT - forced build of performance global
    //<< ;
    //<< ; Called By : CheckLocn^COMHCV1, OnAfterSave^WWW0121, OnAfterDelete^WWW0121
    //<< ;             PostBatch^INCostCentreChange
    //<< ;
    //<< ; Inputs:
    //<< ;   pidCompany      Active company - often YM
    //<< ;
    //<< ; History:
    //<< ; 30-Nov-2011   GRF     SR17967: move from CacheTemp to common global in nspace
    //<< ; 20-Nov-2009   GRF     SR16871: remove company from CacheTempWWW0121 keys
    //<< ; 16-Nov-2007   GRF     SR15563: add YUCI to ^CacheTempWWW0121("Path",...)
    //<< ;-------------------------------------------------------------------------------
    //<< set Y="~"
    mVar Y = m$.var("Y");
    Y.set("~");
    //<< ;***************************************
    //<< lock +^WWW0121Path:10
    m$.Cmd.LockInc(m$.var("^WWW0121Path"),10);
    //<< do SavePath($$$YES)
    m$.Cmd.Do("SavePath",include.COMSYS.$$$YES(m$));
    //<< lock -^WWW0121Path
    m$.Cmd.Unlock(m$.var("^WWW0121Path"));
    //<< ;***************************************
    //<< quit
    return null;
  }

  //<< ;lock +^CacheTempWWW0121("Path",YUCI):10     ; SR17967
  //<< ;do SavePath($$$YES)
  //<< ;lock -^CacheTempWWW0121("Path",YUCI)
  //<< ;quit
  //<< 
  //<< 
  //<< SavePath(pblnForce=$$$NO) private
  public Object SavePath(Object ... _p) {
    mVar pblnForce = m$.newVarRef("pblnForce",(((_p!=null)&&(_p.length>=1))?_p[0]:null),include.COMSYS.$$$NO(m$));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Builds fast access data representations
    //<< ;
    //<< ; e.g.  ^CacheTempWWW0121("Path",YUCI,"1-2-34")                       = "~1-2-34~1-2-3,1-2,1~ENT~"
    //<< ;       ^CacheTempWWW0121("Hier",YUCI,"ENT",1,"1-2","1-2-3","1-2-34") = "Location 34~1-2-34~CostCentre"
    //<< ;
    //<< ; replaced by
    //<< ; e.g.  ^WWW0121Path(0,idLocn,1)         = OtherList_Y_DeptList_Y_SiteList_Y_EntityList_Y_Error
    //<< ;       ^WWW0121Hier(0,[LocationLevels]) = LocnName_Y_Locn_Y_CostCentre
    //<< ;
    //<< ; where pieces are based on the location type - working up the hierarchy from
    //<< ; Unknown to Departments to Site Locations to Entities
    //<< ; Sub-entries appear first before the main entry thus;
    //<< ;   ENTITY      ENT
    //<< ;   SITE        1
    //<< ;               1-2         Sub-Site
    //<< ;               1-2-3       Sub-Sub-Site
    //<< ;   DEPARTMENT  1-2-34
    //<< ;               1-2-34-5    Sub-Dept
    //<< ; Inputs:
    //<< ;   pidCompany      Active company - often YM
    //<< ;   pblnForce       Force update (boolean)
    //<< ;
    //<< ; Returns:      nothing
    //<< ;
    //<< ; History :
    //<< ; 30-Nov-2011   GRF     SR17967: move from CacheTemp to common global in nspace
    //<< ; 20-Nov-2009   GRF     SR16871: remove company from CacheTempWWW0121 keys; add
    //<< ;                           Hierarchy listing
    //<< ; 16-Nov-2007   GRF     SR15563: add YUCI to ^CacheTempWWW0121("Path",...)
    //<< ; 18-Oct-2007   GRF     SR15563: created
    //<< ;-------------------------------------------------------------------------------
    //<< new idCostCentre,idLocn,idPathLocn,objLocation,objPathLocn
    mVar idCostCentre = m$.var("idCostCentre");
    mVar idLocn = m$.var("idLocn");
    mVar idPathLocn = m$.var("idPathLocn");
    mVar objLocation = m$.var("objLocation");
    mVar objPathLocn = m$.var("objPathLocn");
    m$.newVar(idCostCentre,idLocn,idPathLocn,objLocation,objPathLocn);
    //<< new strDept,strEntity,strError,strLevels,strLocnName,strLocnType,strSite,strOther
    mVar strDept = m$.var("strDept");
    mVar strEntity = m$.var("strEntity");
    mVar strError = m$.var("strError");
    mVar strLevels = m$.var("strLevels");
    mVar strLocnName = m$.var("strLocnName");
    mVar strLocnType = m$.var("strLocnType");
    mVar strSite = m$.var("strSite");
    mVar strOther = m$.var("strOther");
    m$.newVar(strDept,strEntity,strError,strLevels,strLocnName,strLocnType,strSite,strOther);
    //<< 
    //<< ;if pblnForce || '$data(^CacheTempWWW0121("Path",YUCI)) {           ; SR17967
    //<< ;   kill ^CacheTempWWW0121("Path",YUCI)
    //<< ;   kill ^CacheTempWWW0121("Hier",YUCI)
    //<< if pblnForce || '$data(^WWW0121Path) || '$data(^WWW0121Hier) {
    if (mOp.Logical(pblnForce.get()) || mOp.Not(m$.Fnc.$data(m$.var("^WWW0121Path"))) || mOp.Not(m$.Fnc.$data(m$.var("^WWW0121Hier")))) {
      //<< kill ^WWW0121Path
      m$.var("^WWW0121Path").kill();
      //<< kill ^WWW0121Hier
      m$.var("^WWW0121Hier").kill();
      //<< 
      //<< set idLocn=""
      idLocn.set("");
      //<< for {
      for (;true;) {
        //<< set idLocn = $order(^WWW0121(0,0,idLocn))
        idLocn.set(m$.Fnc.$order(m$.var("^WWW0121",0,0,idLocn.get())));
        //<< quit:idLocn=""
        if (mOp.Equal(idLocn.get(),"")) {
          break;
        }
        //<< 
        //<< set strError  = ""
        strError.set("");
        //<< set strEntity = ""
        strEntity.set("");
        //<< set strSite   = ""
        strSite.set("");
        //<< set strDept   = ""
        strDept.set("");
        //<< set strOther  = ""
        strOther.set("");
        //<< 
        //<< ; Store Location in Path
        //<< ;-------------------------------
        //<< set objLocation  = $get(^WWW0121(0,0,idLocn,1))
        objLocation.set(m$.Fnc.$get(m$.var("^WWW0121",0,0,idLocn.get(),1)));
        //<< set strLocnType  = $$$WWW0121LocationType(objLocation)
        strLocnType.set(include.WWWConst.$$$WWW0121LocationType(m$,objLocation));
        //<< set strLocnName  = $$$WWW0121LocationName(objLocation)
        strLocnName.set(include.WWWConst.$$$WWW0121LocationName(m$,objLocation));
        //<< set idCostCentre = $$$INFIBPARCostCentre($get(^INFIBPAR(0,0,idLocn,1)))    ; FIXME : Why not Inherit?
        idCostCentre.set(include.INConst.$$$INFIBPARCostCentre(m$,m$.Fnc.$get(m$.var("^INFIBPAR",0,0,idLocn.get(),1))));
        //<< 
        //<< if strLocnType=$$$enumEntity {
        if (mOp.Equal(strLocnType.get(),$$$enumEntity(m$))) {
          //<< set strEntity = ","_idLocn
          strEntity.set(mOp.Concat(",",idLocn.get()));
        }
        //<< 
        //<< } elseif strLocnType=$$$enumSite {
        else if (mOp.Equal(strLocnType.get(),$$$enumSite(m$))) {
          //<< set strSite   = ","_idLocn
          strSite.set(mOp.Concat(",",idLocn.get()));
        }
        //<< 
        //<< } elseif strLocnType=$$$enumDept {
        else if (mOp.Equal(strLocnType.get(),$$$enumDept(m$))) {
          //<< set strDept   = ","_idLocn
          strDept.set(mOp.Concat(",",idLocn.get()));
        }
        //<< 
        //<< } else {
        else {
          //<< set strOther  = ","_idLocn
          strOther.set(mOp.Concat(",",idLocn.get()));
        }
        //<< }
        //<< if idLocn=+idLocn {
        if (mOp.Equal(idLocn.get(),mOp.Positive(idLocn.get()))) {
          //<< set strLevels = idLocn
          strLevels.set(idLocn.get());
        }
        //<< } else {
        else {
          //<< set strLevels = $$$DBLQUOTE_idLocn_$$$DBLQUOTE
          strLevels.set(mOp.Concat(mOp.Concat(include.COMSYSString.$$$DBLQUOTE(m$),idLocn.get()),include.COMSYSString.$$$DBLQUOTE(m$)));
        }
        //<< }
        //<< 
        //<< ; Add Parent Hierarchy
        //<< ;-------------------------------
        //<< set idPathLocn = idLocn
        idPathLocn.set(idLocn.get());
        //<< set objPathLocn = $get(^WWW0121(0,0,idPathLocn,1))
        objPathLocn.set(m$.Fnc.$get(m$.var("^WWW0121",0,0,idPathLocn.get(),1)));
        //<< for {
        for (;true;) {
          //<< set idPathLocn = $$$WWW0121ParentLocn(objPathLocn)
          idPathLocn.set(include.WWWConst.$$$WWW0121ParentLocn(m$,objPathLocn));
          //<< quit:idPathLocn=""
          if (mOp.Equal(idPathLocn.get(),"")) {
            break;
          }
          //<< 
          //<< set objPathLocn = $get(^WWW0121(0,0,idPathLocn,1))
          objPathLocn.set(m$.Fnc.$get(m$.var("^WWW0121",0,0,idPathLocn.get(),1)));
          //<< set strLocnType = $$$WWW0121LocationType($get(^WWW0121(0,0,idPathLocn,1)))
          strLocnType.set(include.WWWConst.$$$WWW0121LocationType(m$,m$.Fnc.$get(m$.var("^WWW0121",0,0,idPathLocn.get(),1))));
          //<< 
          //<< if idPathLocn=idLocn {
          if (mOp.Equal(idPathLocn.get(),idLocn.get())) {
            //<< set strError = "Recursive"
            strError.set("Recursive");
            //<< quit                         ; for loop
            break;
          }
          //<< }
          //<< 
          //<< if strLocnType=$$$enumEntity {
          if (mOp.Equal(strLocnType.get(),$$$enumEntity(m$))) {
            //<< set strEntity = strEntity_","_idPathLocn
            strEntity.set(mOp.Concat(mOp.Concat(strEntity.get(),","),idPathLocn.get()));
          }
          //<< 
          //<< } elseif strLocnType=$$$enumSite {
          else if (mOp.Equal(strLocnType.get(),$$$enumSite(m$))) {
            //<< set strSite   = strSite_","_idPathLocn
            strSite.set(mOp.Concat(mOp.Concat(strSite.get(),","),idPathLocn.get()));
          }
          //<< 
          //<< } elseif strLocnType=$$$enumDept {
          else if (mOp.Equal(strLocnType.get(),$$$enumDept(m$))) {
            //<< set strDept   = strDept_","_idPathLocn
            strDept.set(mOp.Concat(mOp.Concat(strDept.get(),","),idPathLocn.get()));
          }
          //<< 
          //<< } else {
          else {
            //<< set strOther  = strOther_","_idPathLocn
            strOther.set(mOp.Concat(mOp.Concat(strOther.get(),","),idPathLocn.get()));
          }
          //<< }
          //<< if idPathLocn=+idPathLocn {
          if (mOp.Equal(idPathLocn.get(),mOp.Positive(idPathLocn.get()))) {
            //<< set strLevels = idPathLocn_$$$COMMA_strLevels
            strLevels.set(mOp.Concat(mOp.Concat(idPathLocn.get(),include.COMSYSString.$$$COMMA(m$)),strLevels.get()));
          }
          //<< } else {
          else {
            //<< set strLevels = $$$DBLQUOTE_idPathLocn_$$$DBLQUOTE_$$$COMMA_strLevels
            strLevels.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(include.COMSYSString.$$$DBLQUOTE(m$),idPathLocn.get()),include.COMSYSString.$$$DBLQUOTE(m$)),include.COMSYSString.$$$COMMA(m$)),strLevels.get()));
          }
        }
        //<< }
        //<< 
        //<< }
        //<< set strEntity = $extract(strEntity,2,999)   ; strip first comma
        strEntity.set(m$.Fnc.$extract(strEntity.get(),2,999));
        //<< set strSite   = $extract(strSite  ,2,999)
        strSite.set(m$.Fnc.$extract(strSite.get(),2,999));
        //<< set strDept   = $extract(strDept  ,2,999)
        strDept.set(m$.Fnc.$extract(strDept.get(),2,999));
        //<< set strOther  = $extract(strOther ,2,999)
        strOther.set(m$.Fnc.$extract(strOther.get(),2,999));
        //<< 
        //<< ;       set ^CacheTempWWW0121("Path",YUCI,idLocn) = strOther_Y_strDept_Y_strSite_Y_strEntity_Y_strError   ; SR17967
        //<< ;       xecute "set ^CacheTempWWW0121(""Hier"",YUCI,"_strLevels_") = strLocnName_Y_idLocn_Y_idCostCentre"
        //<< set ^WWW0121Path(0,idLocn,1) = strOther_Y_strDept_Y_strSite_Y_strEntity_Y_strError
        m$.var("^WWW0121Path",0,idLocn.get(),1).set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(strOther.get(),m$.var("Y").get()),strDept.get()),m$.var("Y").get()),strSite.get()),m$.var("Y").get()),strEntity.get()),m$.var("Y").get()),strError.get()));
        //<< xecute "set ^WWW0121Hier(0,"_strLevels_") = strLocnName_Y_idLocn_Y_idCostCentre"
        m$.Cmd.Xecute(mOp.Concat(mOp.Concat("set ^WWW0121Hier(0,",strLevels.get()),") = strLocnName_Y_idLocn_Y_idCostCentre"));
      }
    }
    //<< }
    //<< }
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< GetGLParams(pidLocn)
  public Object GetGLParams(Object ... _p) {
    mVar pidLocn = m$.newVarRef("pidLocn",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Find lowest location on hierarchy list that has General Ledger Parameters
    //<< ; specified and return that record.
    //<< ;
    //<< ; History:
    //<< ; 18-Nov-2009   GRF     SR17046/SR16871: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new idParamLocn,loop,objGLParams,strPath
    mVar idParamLocn = m$.var("idParamLocn");
    mVar loop = m$.var("loop");
    mVar objGLParams = m$.var("objGLParams");
    mVar strPath = m$.var("strPath");
    m$.newVar(idParamLocn,loop,objGLParams,strPath);
    //<< 
    //<< set strPath = $$LocationPath(0,pidLocn)
    strPath.set(m$.fnc$("LocationPath",0,pidLocn.get()));
    //<< for loop=1:1:$length(strPath,$$$COMMA) {
    for (loop.set(1);(mOp.LessOrEqual(loop.get(),m$.Fnc.$length(strPath.get(),include.COMSYSString.$$$COMMA(m$))));loop.set(mOp.Add(loop.get(),1))) {
      //<< set idParamLocn = $piece(strPath,$$$COMMA,loop)
      idParamLocn.set(m$.Fnc.$piece(strPath.get(),include.COMSYSString.$$$COMMA(m$),loop.get()));
      //<< set objGLParams = $get(^INFIBPAR(0,0,idParamLocn,1))
      objGLParams.set(m$.Fnc.$get(m$.var("^INFIBPAR",0,0,idParamLocn.get(),1)));
      //<< quit:objGLParams'=""
      if (mOp.NotEqual(objGLParams.get(),"")) {
        break;
      }
    }
    //<< 
    //<< }
    //<< ; TODO : Rather than all or nothing, inherit particular accounts
    //<< ;        This may work out too slow.
    //<< ;        Current requirement is : if you need to specify CC you must specify accts <GRF>
    //<< quit $get(objGLParams)
    return m$.Fnc.$get(objGLParams);
  }

  //<< 
  //<< 
  //<< ;*******************************************************************************
  //<< ;  Children^WWW0121Utils() produces
  //<< ; ^CacheTempWWW0121ShowTmp123(...)
  //<< ; e.g. for top-level location "E2"     TreeFork^WWW0121Select() displays as
  //<< ;
  //<< ;                                   |  E2                           Bold
  //<< ;   (2,1)       = 3                 |       2                       Bold
  //<< ;   (2,2)       = 2-10              |            3                  Bold
  //<< ;   (3,1)       = 4         <+      |                 4             Bold    <<<< Current
  //<< ;   (3,2)       = 3-05      <+      |                      4-10
  //<< ;   (3,3)       = 3-10      <+      |                 3-05          <
  //<< ;   (3,4)       = 3-20      <+      |                 3-10          <  not $$IsInPath
  //<< ;   (4,1)       = 4-10              |                 3-20          <  so these
  //<< ;   ("E2",1)    = 2                 |            3-20               <  locations are
  //<< ;   ("E2",2)    = E2A               |       E2A                     <  not expanded
  //<< ;   ("E2",3)    = ROB               |       ROB                     <
  //<< ;
  //<< ;   "<+"  Note : Numeric locations were initially sorted before strings
  //<< ;                Now : sort by +locn then by locn - with alpha strings stored last
  //<< ;*******************************************************************************
  //<< 
  //<< Children(pidCompany,pidLocn,&parrLocs,pblnExtent,pstrSortRule="NumAlpha",&parrChildren)
  public Object Children(Object ... _p) {
    mVar pidCompany = m$.newVarRef("pidCompany",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pidLocn = m$.newVarRef("pidLocn",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar parrLocs = m$.newVarRef("parrLocs",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    mVar pblnExtent = m$.newVarRef("pblnExtent",(((_p!=null)&&(_p.length>=4))?_p[3]:null));
    mVar pstrSortRule = m$.newVarRef("pstrSortRule",(((_p!=null)&&(_p.length>=5))?_p[4]:null),"NumAlpha");
    mVar parrChildren = m$.newVarRef("parrChildren",(((_p!=null)&&(_p.length>=6))?_p[5]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Get children location
    //<< ;
    //<< ; Inputs:
    //<< ;   pidLocn         Location ID
    //<< ;   parrLocs        By Reference Array or Global (.XYZ or ^XYZ)
    //<< ;   pblnExtent      $$$NO   Single level of descent
    //<< ;                   $$$YES  All hierarchical Children
    //<< ;   pstrSortRule    "Cache"    - locn as stored
    //<< ;                   "AlphaNum" - +locn then locn with 1.A.E sorted before 1.N.E
    //<< ;                   "NumAlpha" - +locn then locn with 1.A.E sorted after  1.N.E
    //<< ;
    //<< ; Returns (By Ref) :
    //<< ;   Arrays of Locations - assignment to sequence depends on sort rule
    //<< ;   If pblnExtent = NO  -> sequence number as key
    //<< ;       parrLocs(seq) = Child           for children of pidLocn only
    //<< ;       parrChildren(Child) = ""        for children of pidLocn only
    //<< ;
    //<< ;   If pblnExtent = YES -> parent location id + sequence number as key
    //<< ;       parrLocs(Parent,seq) = Child    repeated with each child as "Parent" as necessary
    //<< ;       parrChildren(location) = ""     for all descendants of pidLocn
    //<< ;
    //<< ;   Calling routine needs to clear arrays.
    //<< ;
    //<< ; History :
    //<< ; 20-Nov-2009   GRF     SR16871: remove company from keys
    //<< ; 02-Oct-2009   PPP     SR16920: Updated with CacheTemp to have subscripts
    //<< ; 01-Oct-2009   PPP     SR16920: Checking for spaces as well
    //<< ; 15-Sep-2009   PPP     SR16892: Added new parameter parrChildren to return Children
    //<< ; 15-Nov-2007   GRF     SR15563: Flexible presentation order (pstrSortRule) not
    //<< ;                           fully implemented yet
    //<< ; 16-Oct-2007   GRF     SR15563: Added second YM in WWW0121s; added quotes around
    //<< ;                           alpha locns as keys; won't work with special characters
    //<< ;                           in global name (e.g. locn 1-10)
    //<< ; 07-Aug-2007   FIS     created
    //<< ;-------------------------------------------------------------------------------
    //<< new count,idChildLocn,idxLocn,idxChild,strChildLocn,strGlobalNode,strSORKey,strTempFile
    mVar count = m$.var("count");
    mVar idChildLocn = m$.var("idChildLocn");
    mVar idxLocn = m$.var("idxLocn");
    mVar idxChild = m$.var("idxChild");
    mVar strChildLocn = m$.var("strChildLocn");
    mVar strGlobalNode = m$.var("strGlobalNode");
    mVar strSORKey = m$.var("strSORKey");
    mVar strTempFile = m$.var("strTempFile");
    m$.newVar(count,idChildLocn,idxLocn,idxChild,strChildLocn,strGlobalNode,strSORKey,strTempFile);
    //<< 
    //<< ;if $get(pidCompany)="" quit
    //<< if $get(pidLocn)=""    quit
    if (mOp.Equal(m$.Fnc.$get(pidLocn),"")) {
      return null;
    }
    //<< 
    //<< ;---------------------------------------
    //<< ;   Index 2 = P1 Company, D20 Parent Locn
    //<< ;---------------------------------------
    //<< set idxLocn    = $$^WWWUMLAU(pidLocn,1)  ;Parent Location as Sortkey
    idxLocn.set(m$.fnc$("WWWUMLAU.main",pidLocn.get(),1));
    //<< set pblnExtent = +$get(pblnExtent)       ;Search for all hierarchical Children
    pblnExtent.set(mOp.Positive(m$.Fnc.$get(pblnExtent)));
    //<< 
    //<< set strSORKey = YUSER_":"_pidLocn
    strSORKey.set(mOp.Concat(mOp.Concat(m$.var("YUSER").get(),":"),pidLocn.get()));
    //<< kill ^WWWSOR("WWW0121Utils",strSORKey)
    m$.var("^WWWSOR","WWW0121Utils",strSORKey.get()).kill();
    //<< set idChildLocn=""
    idChildLocn.set("");
    //<< for {
    for (;true;) {
      //<< set idChildLocn=$order(^WWW0121s(0,2,0,idxLocn,0,idChildLocn))
      idChildLocn.set(m$.Fnc.$order(m$.var("^WWW0121s",0,2,0,idxLocn.get(),0,idChildLocn.get())));
      //<< quit:idChildLocn=""
      if (mOp.Equal(idChildLocn.get(),"")) {
        break;
      }
      //<< 
      //<< if pstrSortRule       = "Cache" {
      if (mOp.Equal(pstrSortRule.get(),"Cache")) {
        //<< set strChildLocn = idChildLocn
        strChildLocn.set(idChildLocn.get());
      }
      //<< 
      //<< } elseif pstrSortRule = "AlphaNum" {
      else if (mOp.Equal(pstrSortRule.get(),"AlphaNum")) {
        //<< set strChildLocn = +idChildLocn
        strChildLocn.set(mOp.Positive(idChildLocn.get()));
      }
      //<< 
      //<< } else {              ; "NumAlpha"
      else {
        //<< set strChildLocn = +idChildLocn
        strChildLocn.set(mOp.Positive(idChildLocn.get()));
        //<< if (strChildLocn = 0) && ($extract(idChildLocn,1)'="0") {
        if ((mOp.Equal(strChildLocn.get(),0)) && (mOp.NotEqual(m$.Fnc.$extract(idChildLocn.get(),1),"0"))) {
          //<< set strChildLocn = $$$BigNumber
          strChildLocn.set($$$BigNumber(m$));
        }
      }
      //<< }
      //<< }
      //<< set ^WWWSOR("WWW0121Utils",strSORKey,strChildLocn,idChildLocn) = ""
      m$.var("^WWWSOR","WWW0121Utils",strSORKey.get(),strChildLocn.get(),idChildLocn.get()).set("");
    }
    //<< }
    //<< 
    //<< set count = 0
    count.set(0);
    //<< set strChildLocn = ""
    strChildLocn.set("");
    //<< for {
    for (;true;) {
      //<< set strChildLocn = $order(^WWWSOR("WWW0121Utils",strSORKey,strChildLocn))
      strChildLocn.set(m$.Fnc.$order(m$.var("^WWWSOR","WWW0121Utils",strSORKey.get(),strChildLocn.get())));
      //<< quit:strChildLocn=""
      if (mOp.Equal(strChildLocn.get(),"")) {
        break;
      }
      //<< 
      //<< set idChildLocn = ""
      idChildLocn.set("");
      //<< for {
      for (;true;) {
        //<< ;   set idChildLocn = $order(^WWW0121s(0,2,0,idxLocn,0,idChildLocn))
        //<< set idChildLocn = $order(^WWWSOR("WWW0121Utils",strSORKey,strChildLocn,idChildLocn))
        idChildLocn.set(m$.Fnc.$order(m$.var("^WWWSOR","WWW0121Utils",strSORKey.get(),strChildLocn.get(),idChildLocn.get())));
        //<< quit:idChildLocn=""
        if (mOp.Equal(idChildLocn.get(),"")) {
          break;
        }
        //<< 
        //<< set count=count+1
        count.set(mOp.Add(count.get(),1));
        //<< 
        //<< if pblnExtent '= $$$YES {  //Direct Children only
        if (mOp.NotEqual(pblnExtent.get(),include.COMSYS.$$$YES(m$))) {
          //<< if $extract($get(parrLocs))="^" {              ; Save in Global
          if (mOp.Equal(m$.Fnc.$extract(m$.Fnc.$get(parrLocs)),"^")) {
            //<< //  set strGlobalNode=parrLocs_"("_count_")" //SR16920
            //<< if parrLocs'["(" {
            if (mOp.NotContains(parrLocs.get(),"(")) {
              //<< set strGlobalNode = parrLocs_"("_count_")"
              strGlobalNode.set(mOp.Concat(mOp.Concat(mOp.Concat(parrLocs.get(),"("),count.get()),")"));
            }
            //<< } else {
            else {
              //<< set strGlobalNode = $piece(parrLocs,")",1)_","_count_")"
              strGlobalNode.set(mOp.Concat(mOp.Concat(mOp.Concat(m$.Fnc.$piece(parrLocs.get(),")",1),","),count.get()),")"));
            }
            //<< }
            //<< set @strGlobalNode = idChildLocn
            m$.indirectVar(strGlobalNode.get()).set(idChildLocn.get());
          }
          //<< 
          //<< } else {                         ; Save in Variable - will overflow if large number of sites - use global always?
          else {
            //<< set parrLocs(count) = idChildLocn    ; Not an issue under later releases of Cache  FIXME : Replace with array only?
            parrLocs.var(count.get()).set(idChildLocn.get());
          }
          //<< }
          //<< set parrChildren(idChildLocn) = ""
          parrChildren.var(idChildLocn.get()).set("");
        }
        //<< 
        //<< } else {               //All Children
        else {
          //<< if $extract($get(parrLocs))="^" {
          if (mOp.Equal(m$.Fnc.$extract(m$.Fnc.$get(parrLocs)),"^")) {
            //<< //  set strGlobalNode = parrLocs_"("""_pidLocn_""","_count_")" //SR16920
            //<< if parrLocs'["(" {
            if (mOp.NotContains(parrLocs.get(),"(")) {
              //<< set strGlobalNode = parrLocs_"("""_pidLocn_""","_count_")"
              strGlobalNode.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(parrLocs.get(),"(\""),pidLocn.get()),"\","),count.get()),")"));
            }
            //<< } else {
            else {
              //<< set strGlobalNode = $piece(parrLocs,")",1)_","""_pidLocn_""","_count_")"
              strGlobalNode.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(m$.Fnc.$piece(parrLocs.get(),")",1),",\""),pidLocn.get()),"\","),count.get()),")"));
            }
            //<< }
            //<< 
            //<< set @strGlobalNode = idChildLocn
            m$.indirectVar(strGlobalNode.get()).set(idChildLocn.get());
          }
          //<< 
          //<< } else {
          else {
            //<< set parrLocs(pidLocn,count)=idChildLocn
            parrLocs.var(pidLocn.get(),count.get()).set(idChildLocn.get());
          }
          //<< }
          //<< set parrChildren(idChildLocn)=""
          parrChildren.var(idChildLocn.get()).set("");
          //<< 
          //<< set idxChild=$$^WWWUMLAU(idChildLocn,1)
          idxChild.set(m$.fnc$("WWWUMLAU.main",idChildLocn.get(),1));
          //<< 
          //<< if $order(^WWW0121s(0,2,0,idxChild,""))'="" {
          if (mOp.NotEqual(m$.Fnc.$order(m$.var("^WWW0121s",0,2,0,idxChild.get(),"")),"")) {
            //<< ;       set strTempFile="^CacheTempWWW0121RelTmp"_$job_idChildLocn
            //<< //  set strTempFile="^CacheTempWWW0121RelTmp"_$job_$tr(idChildLocn,"- ","..")   //SR16920
            //<< set strTempFile="^CacheTempWWW0121RelTmp"_$job_"("""_idChildLocn_""")"
            strTempFile.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("^CacheTempWWW0121RelTmp",m$.Fnc.$job()),"(\""),idChildLocn.get()),"\")"));
            //<< kill @strTempFile
            m$.indirectVar(strTempFile.get()).kill();
            //<< //  do Children(0,idChildLocn,strTempFile,$$$YES)    ; Recursive call    //SR16892
            //<< do Children(0,idChildLocn,strTempFile,$$$YES,pstrSortRule,.parrChildren)    ; Recursive call
            m$.Cmd.Do("Children",0,idChildLocn.get(),strTempFile.get(),include.COMSYS.$$$YES(m$),pstrSortRule.get(),parrChildren);
            //<< if $extract($get(parrLocs))="^" {
            if (mOp.Equal(m$.Fnc.$extract(m$.Fnc.$get(parrLocs)),"^")) {
              //<< merge @parrLocs = @strTempFile
              m$.Cmd.Merge(m$.indirectVar(parrLocs.get()),m$.indirectVar(strTempFile.get()));
            }
            //<< } else {
            else {
              //<< merge parrLocs  = @strTempFile
              m$.Cmd.Merge(parrLocs,m$.indirectVar(strTempFile.get()));
            }
          }
        }
      }
    }
    //<< }
    //<< ;   kill @strTempFile
    //<< }
    //<< }
    //<< }
    //<< }
    //<< kill ^WWWSOR("WWW0121Utils",strSORKey)
    m$.var("^WWWSOR","WWW0121Utils",strSORKey.get()).kill();
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< GetShipTo(pidLocation)
  public Object GetShipTo(Object ... _p) {
    mVar pidLocation = m$.newVarRef("pidLocation",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ;
    //<< ;
    //<< ; Inputs:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 08-Dec-2009   PP      SRxxxx<>: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new idShipTo
    mVar idShipTo = m$.var("idShipTo");
    m$.newVar(idShipTo);
    //<< 
    //<< $$$VAR
    include.COMSYS.$$$VAR(m$);
    //<< 
    //<< if $get(pidLocation)'="" {
    if (mOp.NotEqual(m$.Fnc.$get(pidLocation),"")) {
      //<< set objLocation = $get(^WWW0121(0,0,pidLocation,1))
      mVar objLocation = m$.var("objLocation");
      objLocation.set(m$.Fnc.$get(m$.var("^WWW0121",0,0,pidLocation.get(),1)));
      //<< set idShipTo    = $$$WWW0121ShipTo(objLocation)
      idShipTo.set(include.WWWConst.$$$WWW0121ShipTo(m$,objLocation));
      //<< 
      //<< if idShipTo = "" {
      if (mOp.Equal(idShipTo.get(),"")) {
        //<< set idShipTo = pidLocation
        idShipTo.set(pidLocation.get());
      }
    }
    //<< }
    //<< }
    //<< quit idShipTo
    return idShipTo.get();
  }

  //<< 
  //<< GetBillTo(pidLocation)
  public Object GetBillTo(Object ... _p) {
    mVar pidLocation = m$.newVarRef("pidLocation",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ;
    //<< ;
    //<< ; Inputs:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 01-Jun-2011   PPP     SR17767: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new idBillTo
    mVar idBillTo = m$.var("idBillTo");
    m$.newVar(idBillTo);
    //<< 
    //<< $$$VAR
    include.COMSYS.$$$VAR(m$);
    //<< 
    //<< if $get(pidLocation)'="" {
    if (mOp.NotEqual(m$.Fnc.$get(pidLocation),"")) {
      //<< set objLocation = $get(^WWW0121(0,0,pidLocation,1))
      mVar objLocation = m$.var("objLocation");
      objLocation.set(m$.Fnc.$get(m$.var("^WWW0121",0,0,pidLocation.get(),1)));
      //<< set idBillTo    = $$$WWW0121BillTo(objLocation)
      idBillTo.set(include.WWWConst.$$$WWW0121BillTo(m$,objLocation));
      //<< 
      //<< if idBillTo = "" {
      if (mOp.Equal(idBillTo.get(),"")) {
        //<< set idBillTo = pidLocation
        idBillTo.set(pidLocation.get());
      }
    }
    //<< }
    //<< }
    //<< quit idBillTo
    return idBillTo.get();
  }

//<< 
//<< 
//<< //SR16920              Deprecated
//<< /*
//<< OldChildren(pidCompany,pidLocn,parrLocs,pblnExtent,pstrSortRule="NumAlpha",&parrChildren)
//<< ;-------------------------------------------------------------------------------
//<< ; Get children location
//<< ;
//<< ; Inputs:
//<< ;   pidCompany      Active company - often YM
//<< ;   pidLocn         Location ID
//<< ;   parrLocs        By Reference Array or Global (.XYZ or ^XYZ)
//<< ;   pblnExtent      $$$NO   Single level of descent
//<< ;                   $$$YES  All hierarchical Children
//<< ;   pstrSortRule    "Cache"    - locn as stored
//<< ;                   "AlphaNum" - +locn then locn with 1.A.E sorted before 1.N.E
//<< ;                   "NumAlpha" - +locn then locn with 1.A.E sorted after  1.N.E
//<< ;
//<< ; Returns :
//<< ;   Array of Locations
//<< ;       Case pblnExtent = 0 -> sequence number as key
//<< ;       Case pblnExtent = 1 -> parent location id + sequence number as key
//<< ;
//<< ; History :
//<< ; 01-Oct-2009   PPP     SR16920: Checking for spaces as well
//<< ; 15-Sep-2009   PPP     SR16892: Added new parameter parrChildren to return Children
//<< ; 15-Nov-2007   GRF     SR15563: Flexible presentation order (pstrSortRule) not
//<< ;                           fully implemented yet
//<< ; 16-Oct-2007   GRF     SR15563: Added second YM in WWW0121s; added quotes around
//<< ;                           alpha locns as keys; won't work with special characters
//<< ;                           in global name (e.g. locn 1-10)
//<< ; 07-Aug-2007   FIS     created
//<< ;-------------------------------------------------------------------------------
//<< new count,idChildLocn,idxLocn,idxChild,strChildLocn,strGlobalNode,strSORKey,strTempFile
//<< 
//<< if $get(pidCompany)="" quit
//<< if $get(pidLocn)=""    quit
//<< 
//<< 
//<< ;---------------------------------------
//<< ;   Index 2 = P1 Company, D20 Parent Locn
//<< ;---------------------------------------
//<< set idxLocn    = $$^WWWUMLAU(pidLocn,1)  ;Parent Location as Sortkey
//<< set pblnExtent = +$get(pblnExtent)       ;Search for all hierarchical Children
//<< 
//<< set strSORKey = YUSER_":"_pidLocn
//<< kill ^WWWSOR("WWW0121Utils",strSORKey)
//<< set idChildLocn=""
//<< for {
//<< set idChildLocn=$order(^WWW0121s(0,2,pidCompany,idxLocn,pidCompany,idChildLocn))
//<< quit:idChildLocn=""
//<< 
//<< if pstrSortRule       = "Cache" {
//<< set strChildLocn = idChildLocn
//<< 
//<< } elseif pstrSortRule = "AlphaNum" {
//<< set strChildLocn = +idChildLocn
//<< 
//<< } else {              ; "NumAlpha"
//<< set strChildLocn = +idChildLocn
//<< if (strChildLocn = 0) && ($extract(idChildLocn,1)'="0") {
//<< set strChildLocn = $$$BigNumber
//<< }
//<< }
//<< set ^WWWSOR("WWW0121Utils",strSORKey,strChildLocn,idChildLocn) = ""
//<< }
//<< 
//<< set count=0
//<< set strChildLocn=""
//<< for {
//<< set strChildLocn=$order(^WWWSOR("WWW0121Utils",strSORKey,strChildLocn))
//<< quit:strChildLocn=""
//<< 
//<< set idChildLocn=""
//<< for {
//<< ;   set idChildLocn=$order(^WWW0121s(0,2,pidCompany,idxLocn,pidCompany,idChildLocn))
//<< set idChildLocn=$order(^WWWSOR("WWW0121Utils",strSORKey,strChildLocn,idChildLocn))
//<< quit:idChildLocn=""
//<< 
//<< set count=count+1
//<< 
//<< if pblnExtent '= $$$YES {  //Direct Children only
//<< if $extract($get(parrLocs))="^" {              ; Save in Global
//<< set strGlobalNode=parrLocs_"("_count_")"
//<< //  set strGlobalNode=$piece(parrLocs,")",1)_","_count_")"
//<< set @strGlobalNode=idChildLocn
//<< } else {                                       ; Save in Variable - will overflow if large number of sites - use global always?
//<< set parrLocs(count)=idChildLocn
//<< }
//<< set parrChildren(idChildLocn)=""
//<< 
//<< } else {               //All Children
//<< if $extract($get(parrLocs))="^" {
//<< set strGlobalNode=parrLocs_"("""_pidLocn_""","_count_")"
//<< //set strGlobalNode=$piece(parrLocs,")",1)_","_count_")"
//<< set @strGlobalNode=idChildLocn
//<< 
//<< } else {
//<< set parrLocs(pidLocn,count)=idChildLocn
//<< }
//<< set parrChildren(idChildLocn)=""
//<< 
//<< set idxChild=$$^WWWUMLAU(idChildLocn,1)
//<< 
//<< if $order(^WWW0121s(0,2,pidCompany,idxChild,""))'="" {
//<< ;       set strTempFile="^CacheTempWWW0121RelTmp"_$job_idChildLocn
//<< set strTempFile="^CacheTempWWW0121RelTmp"_$job_$tr(idChildLocn,"- ","..")   //SR16920
//<< //set strTempFile="^CacheTempWWW0121RelTmp"_$job_"("""_idChildLocn_""")"
//<< ;--------------------------------
//<< ; FIXME : <GRF> may need other chars to be converted.  Do differently!  Move in as key
//<< ;               rather than as part of the Global name and don't need $translate.
//<< ;--------------------------------
//<< kill @strTempFile
//<< //do Children(pidCompany,idChildLocn,strTempFile,$$$YES)    ; Recursive call
//<< //SR16892
//<< do Children(pidCompany,idChildLocn,strTempFile,$$$YES,pstrSortRule,.parrChildren)    ; Recursive call
//<< if $extract($get(parrLocs))="^" {
//<< merge @parrLocs = @strTempFile
//<< } else {
//<< merge parrLocs  = @strTempFile
//<< }
//<< ;   kill @strTempFile
//<< }
//<< }
//<< }
//<< }
//<< kill ^WWWSOR("WWW0121Utils",strSORKey)
//<< quit
//<< */
//<< 
//<< 
}
