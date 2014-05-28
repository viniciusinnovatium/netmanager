//*****************************************************************************
//** TASC - ALPHALINC - MAC COMUtilForm
//** Innovatium Systems - Code Converter - v1.28
//** 2014-05-26 21:13:05
//*****************************************************************************

import mLibrary.*;

//<< ;-------------------------------------------------------------------------------
//<< ; Common Utilities for @netManager Forms
//<< ;
//<< ; See also :
//<< ;   COMUtilDate     Date/Time Utilities
//<< ;   COMUtilStr      String Manipulation
//<< ;   COMUtilGlo      Global Manipulation
//<< ;   COMUtilClass    @netManager Class Utilities
//<< ;
//<< ; History:
//<< ; 23-Feb-2005   GRF     Created; moved some routines from COMUtils
//<< ;-------------------------------------------------------------------------------
//<< #include COMConst
import include.COMConst;
import include.COMSYS;
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
import include.$occInclude;

//<< COMUtilForm
public class COMUtilForm extends mClass {

  public void main() {
    _COMUtilForm();
  }

  public void _COMUtilForm() {
  }

  //<< 
  //<< GetFieldDetails(pidField,&pidForm,&pidFieldType,&pidFieldNo)
  public Object GetFieldDetails(Object ... _p) {
    mVar pidField = m$.newVarRef("pidField",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pidForm = m$.newVarRef("pidForm",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pidFieldType = m$.newVarRef("pidFieldType",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    mVar pidFieldNo = m$.newVarRef("pidFieldNo",(((_p!=null)&&(_p.length>=4))?_p[3]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Provided a field name eg. YFINAPInvD22 break up into
    //<< ; Form name, Field type, Field number
    //<< ;
    //<< ; Returns: Nothing, all done through arguments
    //<< ;
    //<< ; History:
    //<< ; 14-Apr-2005   PO      Created SR:
    //<< ;-------------------------------------------------------------------------------
    //<< new intLoop
    mVar intLoop = m$.var("intLoop");
    m$.newVar(intLoop);
    //<< 
    //<< set pidForm      = ""
    pidForm.set("");
    //<< set pidFieldType = ""
    pidFieldType.set("");
    //<< set pidFieldNo   = ""
    pidFieldNo.set("");
    //<< 
    //<< for intLoop=$length(pidField):-1:1 { ; Should always leave by quit, for loop limit used as a safeguard
    for (intLoop.set(m$.Fnc.$length(pidField.get()));(mOp.GreaterOrEqual(intLoop.get(),1));intLoop.set(mOp.Add(intLoop.get(),-1))) {
      //<< set pidFieldNo = $extract(pidField,intLoop)_pidFieldNo
      pidFieldNo.set(mOp.Concat(m$.Fnc.$extract(pidField.get(),intLoop.get()),pidFieldNo.get()));
      //<< quit:+$extract(pidField,intLoop)'=$extract(pidField,intLoop)
      if (mOp.NotEqual(mOp.Positive(m$.Fnc.$extract(pidField.get(),intLoop.get())),m$.Fnc.$extract(pidField.get(),intLoop.get()))) {
        break;
      }
    }
    //<< }
    //<< 
    //<< set pidFieldType = $extract(pidFieldNo)
    pidFieldType.set(m$.Fnc.$extract(pidFieldNo.get()));
    //<< set pidFieldNo   = $extract(pidFieldNo,2,$length(pidFieldNo))
    pidFieldNo.set(m$.Fnc.$extract(pidFieldNo.get(),2,m$.Fnc.$length(pidFieldNo.get())));
    //<< set pidForm      = $extract(pidField,2,intLoop-1) ; strip off the "Y"
    pidForm.set(m$.Fnc.$extract(pidField.get(),2,mOp.Subtract(intLoop.get(),1)));
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< GoToForm(pstrForm,pidKey,plngPage,pstrParam,pblnOpenNewWindow=$$$NO,pstrWindowName="",
  //<< pstrYAUSWAHL,pblnModalWin=$$$NO)
  public Object GoToForm(Object ... _p) {
    mVar pstrForm = m$.newVarRef("pstrForm",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pidKey = m$.newVarRef("pidKey",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar plngPage = m$.newVarRef("plngPage",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    mVar pstrParam = m$.newVarRef("pstrParam",(((_p!=null)&&(_p.length>=4))?_p[3]:null));
    mVar pblnOpenNewWindow = m$.newVarRef("pblnOpenNewWindow",(((_p!=null)&&(_p.length>=5))?_p[4]:null),include.COMSYS.$$$NO(m$));
    mVar pstrWindowName = m$.newVarRef("pstrWindowName",(((_p!=null)&&(_p.length>=6))?_p[5]:null),"");
    mVar pstrYAUSWAHL = m$.newVarRef("pstrYAUSWAHL",(((_p!=null)&&(_p.length>=7))?_p[6]:null));
    mVar pblnModalWin = m$.newVarRef("pblnModalWin",(((_p!=null)&&(_p.length>=8))?_p[7]:null),include.COMSYS.$$$NO(m$));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Utility to present the nominated form
    //<< ; NOTE: This is preferable over RedirectForm
    //<< ;
    //<< ; Inputs :
    //<< ;   pstrForm    Form Name
    //<< ;   pidKey      Keys
    //<< ;   plngPage    Tab Number
    //<< ;   pstrParam   YPARA
    //<< ;   pblnOpenNewWindow  Currently only applicable for HyperEvents
    //<< ;   pstrWindowName
    //<< ;   pstrYAUSWAHL    YAUSWAHL
    //<< ;   pblnModalWin Open as Modal Window
    //<< ;
    //<< ; History.
    //<< ; 26-Aug-2011   GRF     SR17866.2: Preserve PDA variable YSTARTAT
    //<< ; 27-Sep-2010   shobby  SR17541: Can use showmodaldialog with firefox.
    //<< ; 12-Jul-2010   FIS     SR17426: use this.location rather document.parent in FF
    //<< ; 01-Jun-2010   FIS     SR17343: use & rather &amp; in URL for firefox
    //<< ; 16-Dec-2008   FIS     SR16235: Open form in modal window
    //<< ; 21-Dec-2006   JW      SR14235: Added reference to child window
    //<< ; 11-Oct-2006   PO      SR15090: Include script tags as OnAfterSave^INTFR
    //<< ;                           pretending to be in hyperevent to make use of
    //<< ;                           setting location of main frame.
    //<< ; 15-Aug-2006   PO      SR14582: Prevent js error from being displayed (have
    //<< ;                           not been able to figure out real solution)
    //<< ; 28-Jun-2006   GRF     & => &&
    //<< ; 09-Feb-2006   JW      SR14274: Added YAUSWAHL param
    //<< ; 10-Nov-2005   JW      SR13817: Change YUSER for pop-up window
    //<< ; 03-Nov-2005   PO      SR13578: Include js form loading.
    //<< ; 21-Jul-2005   PO      SR13009 Handling of YBACK now done correctly by
    //<< ;                       WWW code - changes reverted until complete
    //<< ; 06-Dec-2004   JW      SR10541: Removed change and created new function
    //<< ;                           LoadFormNow^COMGridEdit31G
    //<< ; 01-Dec-2004   shobby/JW   SR11066: Allow overriding of the back button.
    //<< ;-------------------------------------------------------------------------------
    //<< new strBack,strURL
    mVar strBack = m$.var("strBack");
    mVar strURL = m$.var("strURL");
    m$.newVar(strBack,strURL);
    //<< 
    //<< set strBack = $get(YBACK)     ; "A,B,C,D,E,"
    strBack.set(m$.Fnc.$get(m$.var("YBACK")));
    //<< 
    //<< ; FIXME : <GRF> SR15976 - it appears that this should not be performed since
    //<< ;               it makes the back arrow call the CALLED form before returning
    //<< ;               to the ORIGINAL form on the second click.
    //<< ;               Still need to be able to return with the key for the earlier
    //<< ;               form rather than using an inappropriate YKEY.
    //<< 
    //<< if (YFORM'="") && ($piece(strBack,",",$length(strBack,",")-1)'=YFORM) && (strBack'=YFORM) {
    if ((mOp.NotEqual(m$.var("YFORM").get(),"")) && (mOp.NotEqual(m$.Fnc.$piece(strBack.get(),",",mOp.Subtract(m$.Fnc.$length(strBack.get(),","),1)),m$.var("YFORM").get())) && (mOp.NotEqual(strBack.get(),m$.var("YFORM").get()))) {
      //<< set strBack = strBack_YFORM_","  ;only add YFORM to the stack if not last element
      strBack.set(mOp.Concat(mOp.Concat(strBack.get(),m$.var("YFORM").get()),","));
    }
    //<< }
    //<< 
    //<< if $$$ALWAYS { ;$get(%("%KEY","HYPEREVENT")) {
    if (mOp.Logical(include.COMSYS.$$$ALWAYS(m$))) {
      //<< set strURL = YAKTION_"EP=WWWFORM&amp;YFORM="_pstrForm
      strURL.set(mOp.Concat(mOp.Concat(m$.var("YAKTION").get(),"EP=WWWFORM&amp;YFORM="),pstrForm.get()));
      //<< if pblnOpenNewWindow {
      if (mOp.Logical(pblnOpenNewWindow.get())) {
        //<< set strURL = strURL_"&amp;YBACK=,"
        strURL.set(mOp.Concat(strURL.get(),"&amp;YBACK=,"));
      }
      //<< } elseif strBack '= "" {
      else if (mOp.NotEqual(strBack.get(),"")) {
        //<< set strURL = strURL_"&amp;YBACK="_strBack
        strURL.set(mOp.Concat(mOp.Concat(strURL.get(),"&amp;YBACK="),strBack.get()));
      }
      //<< }
      //<< set strURL = strURL_"&amp;YKEY="_pidKey
      strURL.set(mOp.Concat(mOp.Concat(strURL.get(),"&amp;YKEY="),pidKey.get()));
      //<< if $get(pstrParam)'="" set strURL = strURL_"&amp;YPARA="_pstrParam
      if (mOp.NotEqual(m$.Fnc.$get(pstrParam),"")) {
        strURL.set(mOp.Concat(mOp.Concat(strURL.get(),"&amp;YPARA="),pstrParam.get()));
      }
      //<< if $get(plngPage)'=""  set strURL = strURL_"&amp;YSEITE="_plngPage
      if (mOp.NotEqual(m$.Fnc.$get(plngPage),"")) {
        strURL.set(mOp.Concat(mOp.Concat(strURL.get(),"&amp;YSEITE="),plngPage.get()));
      }
      //<< if $get(YFKEY)'=""     set strURL = strURL_"&amp;YFKEY="_YFKEY
      if (mOp.NotEqual(m$.Fnc.$get(m$.var("YFKEY")),"")) {
        strURL.set(mOp.Concat(mOp.Concat(strURL.get(),"&amp;YFKEY="),m$.var("YFKEY").get()));
      }
      //<< set strURL = strURL_"&amp;YBED="_YBED
      strURL.set(mOp.Concat(mOp.Concat(strURL.get(),"&amp;YBED="),m$.var("YBED").get()));
      //<< 
      //<< set strURL = strURL_"&amp;YM="_YM
      strURL.set(mOp.Concat(mOp.Concat(strURL.get(),"&amp;YM="),m$.var("YM").get()));
      //<< set strURL = strURL_"&amp;YUCI="_YUCI
      strURL.set(mOp.Concat(mOp.Concat(strURL.get(),"&amp;YUCI="),m$.var("YUCI").get()));
      //<< 
      //<< if $get(pstrYAUSWAHL)'="" set strURL = strURL_"&amp;YAUSWAHL="_pstrYAUSWAHL
      if (mOp.NotEqual(m$.Fnc.$get(pstrYAUSWAHL),"")) {
        strURL.set(mOp.Concat(mOp.Concat(strURL.get(),"&amp;YAUSWAHL="),pstrYAUSWAHL.get()));
      }
      //<< if $get(YSTARTAT)'="" set strURL = strURL_"&amp;YSTARTAT="_YSTARTAT    ; SR17866.2
      if (mOp.NotEqual(m$.Fnc.$get(m$.var("YSTARTAT")),"")) {
        strURL.set(mOp.Concat(mOp.Concat(strURL.get(),"&amp;YSTARTAT="),m$.var("YSTARTAT").get()));
      }
      //<< 
      //<< $$$StartScript()
      include.COMSYS.$$$StartScript(m$);
      //<< 
      //<< if pblnOpenNewWindow {
      if (mOp.Logical(pblnOpenNewWindow.get())) {
        //<< set strURL = strURL_"&amp;YUSER="_$$GetChildUser^WWWUSER(YUSER)
        strURL.set(mOp.Concat(mOp.Concat(strURL.get(),"&amp;YUSER="),m$.fnc$("WWWUSER.GetChildUser",m$.var("YUSER").get())));
        //<< ;SR17541 if (pblnModalWin = $$$YES) && (YUSERAGENT = "MSIE") {
        //<< if (pblnModalWin = $$$YES) {                            ;SR17541
        if ((mOp.Equal(pblnModalWin.get(),include.COMSYS.$$$YES(m$)))) {
          //<< write " window.showModalDialog('"_$$Replace^COMUtilStr(strURL,"&amp;","&")_"&Timeout=' + new Date().getSeconds(),'"_pstrWindowName_"','DialogWidth: 650px; DialogHeight: 450px; resizable: yes; status: no;');"
          m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(" window.showModalDialog('",m$.fnc$("COMUtilStr.Replace",strURL.get(),"&amp;","&")),"&Timeout=' + new Date().getSeconds(),'"),pstrWindowName.get()),"','DialogWidth: 650px; DialogHeight: 450px; resizable: yes; status: no;');"));
        }
        //<< 
        //<< } elseif pstrWindowName="" {
        else if (mOp.Equal(pstrWindowName.get(),"")) {
          //<< write "subWindow('"_$$Replace^COMUtilStr(strURL,"&amp;","&")_"');"            //SR17343
          m$.Cmd.Write(mOp.Concat(mOp.Concat("subWindow('",m$.fnc$("COMUtilStr.Replace",strURL.get(),"&amp;","&")),"');"));
        }
        //<< 
        //<< } else {
        else {
          //<< write "try { subWindow('"_$$Replace^COMUtilStr(strURL,"&amp;","&")_"','"_pstrWindowName_"'); } catch(e) {}"  //SR17343
          m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("try { subWindow('",m$.fnc$("COMUtilStr.Replace",strURL.get(),"&amp;","&")),"','"),pstrWindowName.get()),"'); } catch(e) {}"));
        }
      }
      //<< }
      //<< 
      //<< } else {
      else {
        //<< set strURL = strURL_"&amp;YUSER="_YUSER
        strURL.set(mOp.Concat(mOp.Concat(strURL.get(),"&amp;YUSER="),m$.var("YUSER").get()));
        //<< //  write "document.frames.parent[document.frames.parent.length-1].location = '"_$$Replace^COMUtilStr(strURL,"&amp;","&")_"';"
        //<< ;SR17875 the following gives an error in Windows Mobile 6.1
        //<< write "parent.frames[parent.frames.length-1].location = '"_$$Replace^COMUtilStr(strURL,"&amp;","&")_"';"
        m$.Cmd.Write(mOp.Concat(mOp.Concat("parent.frames[parent.frames.length-1].location = '",m$.fnc$("COMUtilStr.Replace",strURL.get(),"&amp;","&")),"';"));
      }
      //<< //  write " if (document.frames.parent && document.frames.parent.length > 0) document.frames.parent[document.frames.parent.length-1].location = '"_$$Replace^COMUtilStr(strURL,"&amp;","&")_"';"  //SR17426
      //<< //  write " else this.location.href = '"_$$Replace^COMUtilStr(strURL,"&amp;","&")_"';"  //SR17426
      //<< }
      //<< 
      //<< $$$EndScript()
      include.COMSYS.$$$EndScript(m$);
    }
    //<< 
    //<< } else {   ; $$$NEVER
    else {
      //<< set %("VAR","YBACK")  = strBack
      m$.var("%","VAR","YBACK").set(strBack.get());
      //<< if $get(pstrParam)'=""    set %("VAR","YPARA")    = pstrParam
      if (mOp.NotEqual(m$.Fnc.$get(pstrParam),"")) {
        m$.var("%","VAR","YPARA").set(pstrParam.get());
      }
      //<< if $get(pstrYAUSWAHL)'="" set %("VAR","YAUSWAHL") = pstrYAUSWAHL
      if (mOp.NotEqual(m$.Fnc.$get(pstrYAUSWAHL),"")) {
        m$.var("%","VAR","YAUSWAHL").set(pstrYAUSWAHL.get());
      }
      //<< if $get(plngPage)'=""     set %("VAR","YSEITE")   = plngPage
      if (mOp.NotEqual(m$.Fnc.$get(plngPage),"")) {
        m$.var("%","VAR","YSEITE").set(plngPage.get());
      }
      //<< if $get(YFKEY)'=""        set %("VAR","YFKEY")    = YFKEY
      if (mOp.NotEqual(m$.Fnc.$get(m$.var("YFKEY")),"")) {
        m$.var("%","VAR","YFKEY").set(m$.var("YFKEY").get());
      }
      //<< set %("VAR","YKEY")  = pidKey
      m$.var("%","VAR","YKEY").set(pidKey.get());
      //<< set %("VAR","YFORM") = pstrForm
      m$.var("%","VAR","YFORM").set(pstrForm.get());
      //<< 
      //<< do ^WWWFORM
      m$.Cmd.Do("WWWFORM.main");
    }
    //<< }
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< GoToGridOnForm(pstrForm,pidKey,plngPage="",pstrParam="",pblnOpenNewWindow=$$$NO,pstrWindowName="",pstrYAUSWAHL="",pintGridLine)
  public Object GoToGridOnForm(Object ... _p) {
    mVar pstrForm = m$.newVarRef("pstrForm",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pidKey = m$.newVarRef("pidKey",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar plngPage = m$.newVarRef("plngPage",(((_p!=null)&&(_p.length>=3))?_p[2]:null),"");
    mVar pstrParam = m$.newVarRef("pstrParam",(((_p!=null)&&(_p.length>=4))?_p[3]:null),"");
    mVar pblnOpenNewWindow = m$.newVarRef("pblnOpenNewWindow",(((_p!=null)&&(_p.length>=5))?_p[4]:null),include.COMSYS.$$$NO(m$));
    mVar pstrWindowName = m$.newVarRef("pstrWindowName",(((_p!=null)&&(_p.length>=6))?_p[5]:null),"");
    mVar pstrYAUSWAHL = m$.newVarRef("pstrYAUSWAHL",(((_p!=null)&&(_p.length>=7))?_p[6]:null),"");
    mVar pintGridLine = m$.newVarRef("pintGridLine",(((_p!=null)&&(_p.length>=8))?_p[7]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Extension of GoToForm^COMUtilForm
    //<< ; Redirects to a specified form(pstrForm) and gives focus to a line on that form's grid.
    //<< ;
    //<< ; Inputs :
    //<< ;   1 pstrForm          Form Name
    //<< ;   2 pidKey            Keys
    //<< ;   3 plngPage          Tab Number
    //<< ;   4 pstrParam         YPARA
    //<< ;   5 pblnOpenNewWindow Currently only applicable for HyperEvents
    //<< ;   6 pstrWindowName
    //<< ;   7 pstrYAUSWAHL      YAUSWAHL
    //<< ;   8 pintGridLine      Line Number on the Grid. Go to this line.
    //<< ;
    //<< ; History
    //<< ; 21-Apr-2006   SC      SR14427: Created.
    //<< ;-------------------------------------------------------------------------------
    //<< set ^CacheTemp(YUSER,"GridLine") = pintGridLine
    m$.var("^CacheTemp",m$.var("YUSER").get(),"GridLine").set(pintGridLine.get());
    //<< do GoToForm(pstrForm,pidKey,plngPage,pstrParam,pblnOpenNewWindow,pstrWindowName,pstrYAUSWAHL)
    m$.Cmd.Do("GoToForm",pstrForm.get(),pidKey.get(),plngPage.get(),pstrParam.get(),pblnOpenNewWindow.get(),pstrWindowName.get(),pstrYAUSWAHL.get());
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< RefreshForm()
  public Object RefreshForm(Object ... _p) {
    //<< ;-------------------------------------------------------------------------------
    //<< ; Refreshes the current form and resets YBACK so as not to have to press the back
    //<< ; button multiple times to get to the previous form.
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 21-Jul-2005   PO          SR13009 Handling of YBACK now done by WWW code
    //<< ;                               - changes reverted until complete
    //<< ; 17-Aug-2004   Shobby      Created
    //<< ;-------------------------------------------------------------------------------
    //<< if $length(YBACK,",")>0 {
    if (mOp.Greater(m$.Fnc.$length(m$.var("YBACK").get(),","),0)) {
      //<< set YBACK = $piece(YBACK,",",1,$length(YBACK,",")-1)     ; A,B,C,D,E, => A,B,C,D,E  ; FIXME : YBACK normally finishes with comma ? <GRF>
      mVar YBACK = m$.var("YBACK");
      YBACK.set(m$.Fnc.$piece(m$.var("YBACK").get(),",",1,mOp.Subtract(m$.Fnc.$length(m$.var("YBACK").get(),","),1)));
    }
    //<< }
    //<< do RedirectForm(YFORM,YKEY,YBACK,YPARA,YSEITE)
    m$.Cmd.Do("RedirectForm",m$.var("YFORM").get(),m$.var("YKEY").get(),m$.var("YBACK").get(),m$.var("YPARA").get(),m$.var("YSEITE").get());
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< ReloadForm(pstrParam)
  public Object ReloadForm(Object ... _p) {
    mVar pstrParam = m$.newVarRef("pstrParam",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Reload the current form. Same functionality as RefreshForm, but takes less time.
    //<< ; Note: This is preferrable over RefreshForm()
    //<< ;
    //<< ; Params: pstrParam - (optional) value for YPARA
    //<< ;
    //<< ; Returns: nil
    //<< ;
    //<< ; History:
    //<< ; 16-May-2013   shobby  CORE-81: SR17998 change to be patched to 1.70.4
    //<< ; 30-Jun-2006   JW      SR14528: Added pstrParam
    //<< ; 21-Jul-2005   PO      SR13009 Handling of YBACK now done correctly by WWW code
    //<< ;                           - changes reverted until complete
    //<< ;  3-Feb-2005   JW      Created
    //<< ;-------------------------------------------------------------------------------
    //<< if $$$WWW013MenuType($get(^WWW013(0,YBED,1)))=13 {
    if (mOp.Equal(include.WWWConst.$$$WWW013MenuType(m$,m$.Fnc.$get(m$.var("^WWW013",0,m$.var("YBED").get(),1))),13)) {
      //<< do GoToForm^COMUtilForm(YFORM,YKEY) ;SR17998
      m$.Cmd.Do("COMUtilForm.GoToForm",m$.var("YFORM").get(),m$.var("YKEY").get());
    }
    //<< } else {
    else {
      //<< new lenBack
      mVar lenBack = m$.var("lenBack");
      m$.newVar(lenBack);
      //<< 
      //<< ; remove YFORM from YBACK
      //<< set lenBack = $length(YBACK,",")
      lenBack.set(m$.Fnc.$length(m$.var("YBACK").get(),","));
      //<< set $piece(YBACK,",",lenBack-1,lenBack) = ""     ; A,B,C,D,E, => A,B,C,D,
      m$.pieceVar(m$.var("YBACK"),",",mOp.Subtract(lenBack.get(),1),lenBack.get()).set("");
      //<< 
      //<< set %("VAR","YBACK") = YBACK
      m$.var("%","VAR","YBACK").set(m$.var("YBACK").get());
      //<< if $data(pstrParam) set %("VAR","YPARA") = pstrParam
      if (mOp.Logical(m$.Fnc.$data(pstrParam))) {
        m$.var("%","VAR","YPARA").set(pstrParam.get());
      }
      //<< 
      //<< do ^WWWFORM
      m$.Cmd.Do("WWWFORM.main");
    }
    //<< }
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< RedirectForm(YFORM,YKEY,YBACK,YPARA,YSEITE,pblnSeach=$$$NO,pblnPopup=$$$NO) ;CORE-107.1
  public Object RedirectForm(Object ... _p) {
    mVar YFORM = m$.newVarRef("YFORM",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar YKEY = m$.newVarRef("YKEY",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar YBACK = m$.newVarRef("YBACK",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    mVar YPARA = m$.newVarRef("YPARA",(((_p!=null)&&(_p.length>=4))?_p[3]:null));
    mVar YSEITE = m$.newVarRef("YSEITE",(((_p!=null)&&(_p.length>=5))?_p[4]:null));
    mVar pblnSeach = m$.newVarRef("pblnSeach",(((_p!=null)&&(_p.length>=6))?_p[5]:null),include.COMSYS.$$$NO(m$));
    mVar pblnPopup = m$.newVarRef("pblnPopup",(((_p!=null)&&(_p.length>=7))?_p[6]:null),include.COMSYS.$$$NO(m$));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Utility to redirect the current form to another
    //<< ; Note: this uses HTML REDIRECT thereby changing the
    //<< ; current URL
    //<< ;
    //<< ; NOTE: Use GoToForm instead of this function when possible ******
    //<< ;
    //<< ;
    //<< ; 22-May-2013   shobby  CORE-107.1: Additional parameter so that Menu is not shown on a search function within a popup.
    //<< ; 29-Jul-2012   SCR     SR17993: Start with Search option
    //<< ; 08-Feb-2006   RPW     SR13655: Hyper events
    //<< ;-------------------------------------------------------------------------------
    //<< new strEnd,strEP
    mVar strEnd = m$.var("strEnd");
    mVar strEP = m$.var("strEP");
    m$.newVar(strEnd,strEP);
    //<< 
    //<< set strEP="WWWFORM"
    strEP.set("WWWFORM");
    //<< set:pblnSeach strEP="WWWSEAR"
    if (mOp.Logical(pblnSeach.get())) {
      strEP.set("WWWSEAR");
    }
    //<< 
    //<< if $get(%("%KEY","HYPEREVENT")) {
    if (mOp.Logical(m$.Fnc.$get(m$.var("%","%KEY","HYPEREVENT")))) {
      //<< write "window.location='"_YAKTION_"EP=WWWFORM&amp;YFORM="_YFORM_"&amp;YKEY="_YKEY_"&amp;YBACK="_YBACK ; SR17993
      m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("window.location='",m$.var("YAKTION").get()),"EP=WWWFORM&amp;YFORM="),YFORM.get()),"&amp;YKEY="),YKEY.get()),"&amp;YBACK="),YBACK.get()));
      //<< ;write "window.location='"_YAKTION_"EP=WWWFORM&amp;YFORM="_YFORM_"&amp;YKEY="_YKEY_"&amp;YBACK="_YBACK
      //<< set strEnd = "'"
      strEnd.set("'");
    }
    //<< 
    //<< } else {
    else {
      //<< write "<META HTTP-EQUIV=""refresh"" CONTENT=""0; URL="
      m$.Cmd.Write("<META HTTP-EQUIV=\"refresh\" CONTENT=\"0; URL=");
      //<< write YAKTION_"EP="_strEP_"&amp;YFORM="_YFORM_"&amp;YKEY="_YKEY_"&amp;YBACK="_YBACK ; SR17993
      m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(m$.var("YAKTION").get(),"EP="),strEP.get()),"&amp;YFORM="),YFORM.get()),"&amp;YKEY="),YKEY.get()),"&amp;YBACK="),YBACK.get()));
      //<< ;write YAKTION_"EP=WWWFORM&amp;YFORM="_YFORM_"&amp;YKEY="_YKEY_"&amp;YBACK="_YBACK
      //<< set strEnd = """>"
      strEnd.set("\">");
    }
    //<< }
    //<< if YPARA'=""  write "&amp;YPARA="_YPARA
    if (mOp.NotEqual(YPARA.get(),"")) {
      m$.Cmd.Write(mOp.Concat("&amp;YPARA=",YPARA.get()));
    }
    //<< if YSEITE'="" write "&amp;YSEITE="_YSEITE
    if (mOp.NotEqual(YSEITE.get(),"")) {
      m$.Cmd.Write(mOp.Concat("&amp;YSEITE=",YSEITE.get()));
    }
    //<< if pblnPopup write "&amp;YPOPUP=1" ;CORE-107.1
    if (mOp.Logical(pblnPopup.get())) {
      m$.Cmd.Write("&amp;YPOPUP=1");
    }
    //<< 
    //<< set YFORM  = ""
    YFORM.set("");
    //<< set YKEY   = ""
    YKEY.set("");
    //<< set YBACK  = ""
    YBACK.set("");
    //<< set YPARA  = ""
    YPARA.set("");
    //<< set YSEITE = ""
    YSEITE.set("");
    //<< do ^WWWCGI
    m$.Cmd.Do("WWWCGI.main");
    //<< write strEnd
    m$.Cmd.Write(strEnd.get());
    //<< 
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< CopyForm(pidForm,pstrToNameSp,pstrFromNameSp)
  public Object CopyForm(Object ... _p) {
    mVar pidForm = m$.newVarRef("pidForm",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pstrToNameSp = m$.newVarRef("pstrToNameSp",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pstrFromNameSp = m$.newVarRef("pstrFromNameSp",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Copy a form and the associated class from one namespace (source) to another
    //<< ; (destination)
    //<< ;
    //<< ; History:
    //<< ; 20-Sep-2011   GRF     SR17847: standard prefixes
    //<< ; 08-Sep-2011   shobby  SR17847: Add WWW120Hook
    //<< ; 21-Jul-2009   GRF     Add WWW122C2 - CoreRules
    //<< ; 17-May-2007   Karine  BR014458 Added WWW001Hook to the List
    //<< ; 22-Jun-2005   SCR     SR12755 Added WWW003Calc to the List
    //<< ; 15-Mar-2005   Paul K  Use Macros instead of $piece(x,Y,n)
    //<< ; 23-Feb-2005   GRF     Simplify strings now subroutines combined
    //<< ; 05-Nov-2004   GRF     Split "Form" line for easier reading
    //<< ;-------------------------------------------------------------------------------
    //<< new loop,strClassList,strGlobal,strNamespace
    mVar loop = m$.var("loop");
    mVar strClassList = m$.var("strClassList");
    mVar strGlobal = m$.var("strGlobal");
    mVar strNamespace = m$.var("strNamespace");
    m$.newVar(loop,strClassList,strGlobal,strNamespace);
    //<< 
    //<< if (pstrFromNameSp'="") && (pstrToNameSp'="") && (pidForm'="") {
    if ((mOp.NotEqual(pstrFromNameSp.get(),"")) && (mOp.NotEqual(pstrToNameSp.get(),"")) && (mOp.NotEqual(pidForm.get(),""))) {
      //<< if $get(Y)="" do ^WWWVAR
      if (mOp.Equal(m$.Fnc.$get(m$.var("Y")),"")) {
        m$.Cmd.Do("WWWVAR.main");
      }
      //<< set strClassList = "WWW120,WWW1201,WWW1203,WWW121,WWW1210,WWW1211,WWW122,WWW1221,WWW122C2,WWW120Hook"
      strClassList.set("WWW120,WWW1201,WWW1203,WWW121,WWW1210,WWW1211,WWW122,WWW1221,WWW122C2,WWW120Hook");
      //<< set strClassList = strClassList_",WWW123,WWW1231,WWW1232,WWW124,WWW1251,WWW126"
      strClassList.set(mOp.Concat(strClassList.get(),",WWW123,WWW1231,WWW1232,WWW124,WWW1251,WWW126"));
      //<< set strClassList = strClassList_",WWW127,WWW129,WWW1291,WWW1290,WWW131,WWW132,WWW133,WWW003Calc"   ;Form
      strClassList.set(mOp.Concat(strClassList.get(),",WWW127,WWW129,WWW1291,WWW1290,WWW131,WWW132,WWW133,WWW003Calc"));
      //<< set strClassList = strClassList_",WWW001,WWW0011,WWW0021,WWW002,WWW003,WWW0031,WWW001Hook"         ;Class
      strClassList.set(mOp.Concat(strClassList.get(),",WWW001,WWW0011,WWW0021,WWW002,WWW003,WWW0031,WWW001Hook"));
      //<< 
      //<< set strNamespace = $zutil(5)
      strNamespace.set(m$.Fnc.$zutil(5));
      //<< do $zutil(5,pstrToNameSp)
      m$.Fnc.$zutil(5,pstrToNameSp.get());
      //<< for loop=1:1:$length(strClassList,",") {
      for (loop.set(1);(mOp.LessOrEqual(loop.get(),m$.Fnc.$length(strClassList.get(),",")));loop.set(mOp.Add(loop.get(),1))) {
        //<< set strGlobal = $piece(strClassList,",",loop)
        strGlobal.set(m$.Fnc.$piece(strClassList.get(),",",loop.get()));
        //<< 
        //<< xecute "kill ^"_strGlobal_"(0,"""_pidForm_""")"
        m$.Cmd.Xecute(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("kill ^",strGlobal.get()),"(0,\""),pidForm.get()),"\")"));
        //<< xecute "merge ^"_strGlobal_"(0,"""_pidForm_""")=^["""_pstrFromNameSp_"""]"_strGlobal_"(0,"""_pidForm_""")"
        m$.Cmd.Xecute(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("merge ^",strGlobal.get()),"(0,\""),pidForm.get()),"\")=^[\""),pstrFromNameSp.get()),"\"]"),strGlobal.get()),"(0,\""),pidForm.get()),"\")"));
        //<< do ^WWWSSORT(strGlobal,pidForm)
        m$.Cmd.Do("WWWSSORT.main",strGlobal.get(),pidForm.get());
        //<< 
        //<< ; Special processing
        //<< if strGlobal="WWW120" set $$$WWW120FormInformation(^WWW120(0,pidForm,1)) = ""
        if (mOp.Equal(strGlobal.get(),"WWW120")) {
          include.WWWConst.$$$WWW120FormInformationSet(m$,m$.var("^WWW120",0,pidForm.get(),1),"");
        }
      }
      //<< }
      //<< do $zutil(5,strNamespace)
      m$.Fnc.$zutil(5,strNamespace.get());
    }
    //<< }
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< SetNewSearch(pstrModule="")
  public Object SetNewSearch(Object ... _p) {
    mVar pstrModule = m$.newVarRef("pstrModule",(((_p!=null)&&(_p.length>=1))?_p[0]:null),"");
    //<< ;-------------------------------------------------------------------------------
    //<< ; Set new search option for a Module
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 21-Jul-2009   GRF     variable prefixes
    //<< ; 22-Feb-2005   Paul K  Reduce incidence of calling WWWVAR
    //<< ; 05-Nov-2004   GRF     Missing QUIT
    //<< ; 27-Sep-2004   SCR     Created
    //<< ;-------------------------------------------------------------------------------
    //<< new idField,idForm,objFieldRec
    mVar idField = m$.var("idField");
    mVar idForm = m$.var("idForm");
    mVar objFieldRec = m$.var("objFieldRec");
    m$.newVar(idField,idForm,objFieldRec);
    //<< 
    //<< if $get(Y)="" do ^WWWVAR
    if (mOp.Equal(m$.Fnc.$get(m$.var("Y")),"")) {
      m$.Cmd.Do("WWWVAR.main");
    }
    //<< set pstrModule = $zconvert(pstrModule,"u")
    pstrModule.set(m$.Fnc.$zconvert(pstrModule.get(),"u"));
    //<< 
    //<< set idForm = ""
    idForm.set("");
    //<< for  {
    for (;true;) {
      //<< set idForm = $order(^WWW122(0,idForm))
      idForm.set(m$.Fnc.$order(m$.var("^WWW122",0,idForm.get())));
      //<< quit:idForm=""
      if (mOp.Equal(idForm.get(),"")) {
        break;
      }
      //<< 
      //<< ; Check Form Name for matching Module prefix
      //<< if (pstrModule'="") && ($extract($zconvert(idForm,"u"),1,$length(pstrModule))=pstrModule) {
      if ((mOp.NotEqual(pstrModule.get(),"")) && (mOp.Equal(m$.Fnc.$extract(m$.Fnc.$zconvert(idForm.get(),"u"),1,m$.Fnc.$length(pstrModule.get())),pstrModule.get()))) {
        //<< set idField = ""
        idField.set("");
        //<< for {
        for (;true;) {
          //<< set idField = $order(^WWW122(0,idForm,idField))
          idField.set(m$.Fnc.$order(m$.var("^WWW122",0,idForm.get(),idField.get())));
          //<< quit:idField=""
          if (mOp.Equal(idField.get(),"")) {
            break;
          }
          //<< 
          //<< set objFieldRec = $get(^WWW122(0,idForm,idField,1))
          objFieldRec.set(m$.Fnc.$get(m$.var("^WWW122",0,idForm.get(),idField.get(),1)));
          //<< ; If old search is on and new is off
          //<< if ($$$WWW122RelationWithSearchFuncti(objFieldRec)) && ('$$$WWW122SearchAsFullTextSearch(objFieldRec)) {
          if (mOp.Logical((include.WWWConst.$$$WWW122RelationWithSearchFuncti(m$,objFieldRec))) && (mOp.Not(include.WWWConst.$$$WWW122SearchAsFullTextSearch(m$,objFieldRec)))) {
            //<< write !,idForm," ",idField
            m$.Cmd.Write("\n",idForm.get()," ",idField.get());
            //<< set $$$WWW122SearchAsFullTextSearch(objFieldRec) = $$$YES ; set new search on
            include.WWWConst.$$$WWW122SearchAsFullTextSearchSet(m$,objFieldRec,include.COMSYS.$$$YES(m$));
            //<< set ^WWW122(0,idForm,idField,1) = objFieldRec
            m$.var("^WWW122",0,idForm.get(),idField.get(),1).set(objFieldRec.get());
          }
        }
      }
    }
    //<< }
    //<< }
    //<< }
    //<< }
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< GetFormData(pstrForm,pType="D",pblnOld=$$$NO)
  public Object GetFormData(Object ... _p) {
    mVar pstrForm = m$.newVarRef("pstrForm",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pType = m$.newVarRef("pType",(((_p!=null)&&(_p.length>=2))?_p[1]:null),"D");
    mVar pblnOld = m$.newVarRef("pblnOld",(((_p!=null)&&(_p.length>=3))?_p[2]:null),include.COMSYS.$$$NO(m$));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Return a form's current data (YFELD or YMFELD or YKEY) from WWWDATEN
    //<< ;
    //<< ; Params:   pstrForm - overrides YFORM (eg for Grid)
    //<< ;           pType - type of data:   D - YFELD (default)
    //<< ;                                   M - YMFELD
    //<< ;                                   P - YKEY
    //<< ;           pblnOld: Value before screen controls are changed.
    //<< ;
    //<< ; Returns: data
    //<< ;
    //<< ; History:
    //<< ; 04-Jan-2008   shobby  SRBR014815: Sometimes need to know what the value was at
    //<< ;                           time of screen load.
    //<< ; 14-Mar-2005   JW      Created
    //<< ;-------------------------------------------------------------------------------
    //<< new strYFELD,strGlobal
    mVar strYFELD = m$.var("strYFELD");
    mVar strGlobal = m$.var("strGlobal");
    m$.newVar(strYFELD,strGlobal);
    //<< 
    //<< if $get(pstrForm)="" set pstrForm = $get(YFORM)
    if (mOp.Equal(m$.Fnc.$get(pstrForm),"")) {
      pstrForm.set(m$.Fnc.$get(m$.var("YFORM")));
    }
    //<< 
    //<< set strYFELD = ""
    strYFELD.set("");
    //<< if ($get(YUSER)'="") && (pstrForm'="") && (pType'="") {
    if ((mOp.NotEqual(m$.Fnc.$get(m$.var("YUSER")),"")) && (mOp.NotEqual(pstrForm.get(),"")) && (mOp.NotEqual(pType.get(),""))) {
      //<< if 'pblnOld {
      if (mOp.Not(pblnOld.get())) {
        //<< set strYFELD = $$$GetFormData(pstrForm,pType)
        strYFELD.set(include.COMSYSWWW.$$$GetFormData(m$,pstrForm,pType));
      }
      //<< } else {
      else {
        //<< set strYFELD = $$$GetFormDataOld(pstrForm,pType)
        strYFELD.set(include.COMSYSWWW.$$$GetFormDataOld(m$,pstrForm,pType));
      }
    }
    //<< }
    //<< }
    //<< quit strYFELD
    return strYFELD.get();
  }

  //<< 
  //<< 
  //<< ToggleReadOnly(pFields,blnReadOnly=$$$YES,pstrForm,pstrActiveColour="",pstrFieldType="D")
  public Object ToggleReadOnly(Object ... _p) {
    mVar pFields = m$.newVarRef("pFields",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar blnReadOnly = m$.newVarRef("blnReadOnly",(((_p!=null)&&(_p.length>=2))?_p[1]:null),include.COMSYS.$$$YES(m$));
    mVar pstrForm = m$.newVarRef("pstrForm",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    mVar pstrActiveColour = m$.newVarRef("pstrActiveColour",(((_p!=null)&&(_p.length>=4))?_p[3]:null),"");
    mVar pstrFieldType = m$.newVarRef("pstrFieldType",(((_p!=null)&&(_p.length>=5))?_p[4]:null),"D");
    //<< ;-------------------------------------------------------------------------------
    //<< ; Toggle read only status of form fields.
    //<< ;
    //<< ; Params:   pFields - fields to make readonly (';' delimited)
    //<< ;           blnReadOnly - yes (default) or no
    //<< ;           pstrForm - overrides YFORM
    //<< ;           pstrFieldType - the field type D/M
    //<< ;
    //<< ; Returns: nil
    //<< ;
    //<< ; History:
    //<< ; 19-Oct-2010   GRF     SR17295: i=>loop
    //<< ; 12-May-2010   shobby  SR17295: ResetFieldFormat can't be relied on for colour
    //<< ; 12-May-2010   shobby  SR17295: Correction for manual fields.
    //<< ; 17-Jan-2007   SteveS  SR15355: Change tooltips on Calender Buttons
    //<< ; 10-Oct-2006   SteveS  SR15012: Added pstrFieldType parameter
    //<< ; 26-Jul-2006   JW      SR14581: Set tabindex. Use original colour.
    //<< ; 22-Jul-2005   JW      SR12615: Updated call to UpdateFieldFormat
    //<< ; 27-May-2005   JW      Removed pstrFieldType as don't want to toggle a manual
    //<< ;                           field.  Checked usages and updated.
    //<< ; 06-Apr-2005   SteveS  Pass in pstrFieldType
    //<< ; 10-Mar-2005   JW      Created
    //<< ;-------------------------------------------------------------------------------
    //<< new blnGrid,colour,idClass,idField,intFormField,loop,numFields,strField,strReadOnly
    mVar blnGrid = m$.var("blnGrid");
    mVar colour = m$.var("colour");
    mVar idClass = m$.var("idClass");
    mVar idField = m$.var("idField");
    mVar intFormField = m$.var("intFormField");
    mVar loop = m$.var("loop");
    mVar numFields = m$.var("numFields");
    mVar strField = m$.var("strField");
    mVar strReadOnly = m$.var("strReadOnly");
    m$.newVar(blnGrid,colour,idClass,idField,intFormField,loop,numFields,strField,strReadOnly);
    //<< 
    //<< if $get(pstrForm)="" {
    if (mOp.Equal(m$.Fnc.$get(pstrForm),"")) {
      //<< set pstrForm = $get(YFORM)
      pstrForm.set(m$.Fnc.$get(m$.var("YFORM")));
    }
    //<< }
    //<< 
    //<< if ($get(pFields)'="") && ($get(pstrForm)'="") {
    if ((mOp.NotEqual(m$.Fnc.$get(pFields),"")) && (mOp.NotEqual(m$.Fnc.$get(pstrForm),""))) {
      //<< set numFields = $length(pFields,";")
      numFields.set(m$.Fnc.$length(pFields.get(),";"));
      //<< 
      //<< if blnReadOnly {
      if (mOp.Logical(blnReadOnly.get())) {
        //<< set colour      = YGRAY
        colour.set(m$.var("YGRAY").get());
        //<< set strReadOnly = "true"
        strReadOnly.set("true");
      }
      //<< } else {
      else {
        //<< set colour      = pstrActiveColour ; TODO: may want to make it so multiple active colours can be passed in
        colour.set(pstrActiveColour.get());
        //<< set strReadOnly = "false"
        strReadOnly.set("false");
      }
      //<< }
      //<< 
      //<< set idClass = $$$WWW120ClassUsedInForm($get(^WWW120(0,pstrForm,1)))
      idClass.set(include.WWWConst.$$$WWW120ClassUsedInForm(m$,m$.Fnc.$get(m$.var("^WWW120",0,pstrForm.get(),1))));
      //<< for loop=1:1:numFields {
      for (loop.set(1);(mOp.LessOrEqual(loop.get(),numFields.get()));loop.set(mOp.Add(loop.get(),1))) {
        //<< set idField = $piece(pFields,";",loop)
        idField.set(m$.Fnc.$piece(pFields.get(),";",loop.get()));
        //<< if $length(idField,"_")>1 {
        if (mOp.Greater(m$.Fnc.$length(idField.get(),"_"),1)) {
          //<< set strField = "tdY"_idField                          ; FIXME : idField is the form field from the grid here<GRF>
          strField.set(mOp.Concat("tdY",idField.get()));
          //<< set blnGrid  = $$$YES
          blnGrid.set(include.COMSYS.$$$YES(m$));
        }
        //<< } else {
        else {
          //<< set strField = "Y"_pstrForm_pstrFieldType_idField     ; FIXME : idField is the (P?/)D/M field here <GRF>
          strField.set(mOp.Concat(mOp.Concat(mOp.Concat("Y",pstrForm.get()),pstrFieldType.get()),idField.get()));
          //<< set blnGrid  = $$$NO
          blnGrid.set(include.COMSYS.$$$NO(m$));
        }
        //<< }
        //<< 
        //<< write "var button = document.getElementById('CalendarButton"_pstrFieldType_idField_"');"
        m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat("var button = document.getElementById('CalendarButton",pstrFieldType.get()),idField.get()),"');"));
        //<< 
        //<< if blnReadOnly {
        if (mOp.Logical(blnReadOnly.get())) {
          //<< do UpdateFieldFormat^COMUtils(strField,"tabIndex","")
          m$.Cmd.Do("COMUtils.UpdateFieldFormat",strField.get(),"tabIndex","");
          //<< write "if (button != null) button.title = '"_$$$JSText($$^WWWTEXT(86))_"';" ; "Not available"
          m$.Cmd.Write(mOp.Concat(mOp.Concat("if (button != null) button.title = '",include.COMSYSString.$$$JSText(m$,m$.fnc$("WWWTEXT.main",86))),"';"));
        }
        //<< 
        //<< } else {
        else {
          //<< do ResetFieldFormat^COMUtils(strField,"tabIndex")
          m$.Cmd.Do("COMUtils.ResetFieldFormat",strField.get(),"tabIndex");
          //<< write "if (button != null) button.title = '"_$$$JSText($$^WWWTEXT(124))_"';" ; "Date"
          m$.Cmd.Write(mOp.Concat(mOp.Concat("if (button != null) button.title = '",include.COMSYSString.$$$JSText(m$,m$.fnc$("WWWTEXT.main",124))),"';"));
        }
        //<< }
        //<< 
        //<< 
        //<< if blnGrid {
        if (mOp.Logical(blnGrid.get())) {
          //<< set idField = $$$GetClassField(YFORM,$piece(strField,"_",2))     ; FIXME : idField is the class field here <GRF>
          idField.set(include.COMSYSWWW.$$$GetClassField(m$,m$.var("YFORM"),m$.Fnc.$piece(strField.get(),"_",2)));
        }
        //<< }
        //<< 
        //<< if $$$WWW003InputType($$GetRelation^COMViewUtils(idClass,"D"_idField,pstrForm))'=2 {
        if (mOp.NotEqual(include.WWWConst.$$$WWW003InputType(m$,m$.fnc$("COMViewUtils.GetRelation",idClass.get(),mOp.Concat("D",idField.get()),pstrForm.get())),2)) {
          //<< 
          //<< if pstrFieldType="M" {
          if (mOp.Equal(pstrFieldType.get(),"M")) {
            //<< set intFormField = idField      ; SR17295
            intFormField.set(idField.get());
          }
          //<< } else {
          else {
            //<< set intFormField = $order(^WWW122s(0,4,idField,pstrForm,""))     ; FIXME : idField is the class field - "M" should set intFormField to initial idField <GRF>
            intFormField.set(m$.Fnc.$order(m$.var("^WWW122s",0,4,idField.get(),pstrForm.get(),"")));
          }
          //<< }
          //<< if $$$WWW122DataInputType($get(^WWW122(0,pstrForm,intFormField,1)))=4 {
          if (mOp.Equal(include.WWWConst.$$$WWW122DataInputType(m$,m$.Fnc.$get(m$.var("^WWW122",0,pstrForm.get(),intFormField.get(),1))),4)) {
            //<< do UpdateFieldFormat^COMUtils(strField,"disabled",strReadOnly)
            m$.Cmd.Do("COMUtils.UpdateFieldFormat",strField.get(),"disabled",strReadOnly.get());
          }
          //<< }
          //<< 
          //<< do UpdateFieldFormat^COMUtils(strField,"readOnly",strReadOnly)
          m$.Cmd.Do("COMUtils.UpdateFieldFormat",strField.get(),"readOnly",strReadOnly.get());
          //<< if 'blnReadOnly && (colour="") {
          if (mOp.Not(blnReadOnly.get()) && (mOp.Equal(colour.get(),""))) {
            //<< do UpdateFieldFormat^COMUtils(strField_".style","backgroundColor",colour)       ;SR17295
            m$.Cmd.Do("COMUtils.UpdateFieldFormat",mOp.Concat(strField.get(),".style"),"backgroundColor",colour.get());
          }
          //<< ;SR17295    do ResetFieldFormat^COMUtils(strField_".style","backgroundColor")
          //<< } else {
          else {
            //<< do UpdateFieldFormat^COMUtils(strField_".style","backgroundColor",colour)
            m$.Cmd.Do("COMUtils.UpdateFieldFormat",mOp.Concat(strField.get(),".style"),"backgroundColor",colour.get());
          }
        }
        //<< }
        //<< 
        //<< } else {
        else {
          //<< do UpdateFieldFormat^COMUtils(strField,"disabled",strReadOnly)
          m$.Cmd.Do("COMUtils.UpdateFieldFormat",strField.get(),"disabled",strReadOnly.get());
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
  //<< SwitchCurrencies
  public void SwitchCurrencies() {
    //<< ;-------------------------------------------------------------------------------
    //<< ; Switch between currencies displayed on form
    //<< ;
    //<< ; History:
    //<< ; 09-Jun-2005   PO      SR#: Set to use ReloadForm
    //<< ; 22-Mar-2005   PO      SR11349 Created
    //<< ;-------------------------------------------------------------------------------
    //<< if $$$CurrencyToUse = "Foreign" {
    if (mOp.Equal(include.COMSYSNum.$$$CurrencyToUse(m$),"Foreign")) {
      //<< set ^CacheTemp(YUSER,YFORM,"Toggles","Currency") = "Base"
      m$.var("^CacheTemp",m$.var("YUSER").get(),m$.var("YFORM").get(),"Toggles","Currency").set("Base");
    }
    //<< } else {
    else {
      //<< set ^CacheTemp(YUSER,YFORM,"Toggles","Currency") = "Foreign"
      m$.var("^CacheTemp",m$.var("YUSER").get(),m$.var("YFORM").get(),"Toggles","Currency").set("Foreign");
    }
    //<< }
    //<< set ^CacheTemp(YUSER,YFORM,"Flags","SwitchCurrencies") = ""
    m$.var("^CacheTemp",m$.var("YUSER").get(),m$.var("YFORM").get(),"Flags","SwitchCurrencies").set("");
    //<< do ReloadForm()
    m$.Cmd.Do("ReloadForm");
    //<< quit
    return;
  }

  //<< 
  //<< 
  //<< ClearMRUList(pidForm)
  public Object ClearMRUList(Object ... _p) {
    mVar pidForm = m$.newVarRef("pidForm",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Code to clear an MRU list for a given form for the current user
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 07-Jul-2005   shobby  SR12892: WWW1262 is no longer shared.
    //<< ; 09-May-2005   SteveS  Created
    //<< ;-------------------------------------------------------------------------------
    //<< new idKey,idKeyPart,strMessage
    mVar idKey = m$.var("idKey");
    mVar idKeyPart = m$.var("idKeyPart");
    mVar strMessage = m$.var("strMessage");
    m$.newVar(idKey,idKeyPart,strMessage);
    //<< 
    //<< set strMessage = ""
    strMessage.set("");
    //<< 
    //<< if ($data(^WWW120(0,pidForm))) {
    if (mOp.Logical((m$.Fnc.$data(m$.var("^WWW120",0,pidForm.get()))))) {
      //<< set idKey = ""
      idKey.set("");
      //<< for {
      for (;true;) {
        //<< set idKey = $order(^WWW1262(0,pidForm,YBED,idKey))
        idKey.set(m$.Fnc.$order(m$.var("^WWW1262",0,pidForm.get(),m$.var("YBED").get(),idKey.get())));
        //<< quit:idKey=""
        if (mOp.Equal(idKey.get(),"")) {
          break;
        }
        //<< 
        //<< set idKeyPart = ""
        idKeyPart.set("");
        //<< for {
        for (;true;) {
          //<< set idKeyPart = $order(^WWW1262(0,pidForm,YBED,idKey,idKeyPart))
          idKeyPart.set(m$.Fnc.$order(m$.var("^WWW1262",0,pidForm.get(),m$.var("YBED").get(),idKey.get(),idKeyPart.get())));
          //<< quit:idKeyPart=""
          if (mOp.Equal(idKeyPart.get(),"")) {
            break;
          }
          //<< 
          //<< do KILL^COMUtils("WWW1262",pidForm_$$$COMMA_YBED_$$$COMMA_idKey_$$$COMMA_idKeyPart)
          m$.Cmd.Do("COMUtils.KILL","WWW1262",mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(pidForm.get(),include.COMSYSString.$$$COMMA(m$)),m$.var("YBED").get()),include.COMSYSString.$$$COMMA(m$)),idKey.get()),include.COMSYSString.$$$COMMA(m$)),idKeyPart.get()));
        }
      }
      //<< }
      //<< }
      //<< set strMessage = $$$Text("Com00076")                         ; "Delete performed"
      strMessage.set(include.COMSYS.$$$Text(m$,"Com00076"));
    }
    //<< 
    //<< } else {
    else {
      //<< set strMessage = $$$Text($listbuild("Com00188",pidForm))     ; "Form %1 not found."
      strMessage.set(include.COMSYS.$$$Text(m$,m$.Fnc.$listbuild("Com00188",pidForm.get())));
    }
    //<< }
    //<< 
    //<< do ReturnError^COMUtils(strMessage)
    m$.Cmd.Do("COMUtils.ReturnError",strMessage.get());
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< DisplayText(strText,strColour="",strAlign="right",strSize="2",blnIncludeBreaks=0)
  public Object DisplayText(Object ... _p) {
    mVar strText = m$.newVarRef("strText",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar strColour = m$.newVarRef("strColour",(((_p!=null)&&(_p.length>=2))?_p[1]:null),"");
    mVar strAlign = m$.newVarRef("strAlign",(((_p!=null)&&(_p.length>=3))?_p[2]:null),"right");
    mVar strSize = m$.newVarRef("strSize",(((_p!=null)&&(_p.length>=4))?_p[3]:null),"2");
    mVar blnIncludeBreaks = m$.newVarRef("blnIncludeBreaks",(((_p!=null)&&(_p.length>=5))?_p[4]:null),0);
    //<< ;-------------------------------------------------------------------------------
    //<< ; Display text on a form
    //<< ;
    //<< ; Returns: Nothing
    //<< ;
    //<< ; NOTE: The HTML output here can end up being rendered underneath controls that
    //<< ; are written out standardly using WWW code. I think the reason this problem is
    //<< ; occurring is since the width of the base* table containing the WWW2 form is
    //<< ; specified.
    //<< ; (* Not actually certain it is a base table.)
    //<< ;
    //<< ; History:
    //<< ; 08-Jun-2005   PO      Included br tags to ensure grid does not render over
    //<< ;                           the top of text
    //<< ; 30-May-2005   PO      SR12050: Created
    //<< ;-------------------------------------------------------------------------------
    //<< if strColour="" set strColour = $get(YRED)
    if (mOp.Equal(strColour.get(),"")) {
      strColour.set(m$.Fnc.$get(m$.var("YRED")));
    }
    //<< write "<table style='border:0;' align='"_strAlign_"'><tr><td><font color='"_strColour_"' size="_strSize_">"_strText_"</font></td></tr></table>"
    m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<table style='border:0;' align='",strAlign.get()),"'><tr><td><font color='"),strColour.get()),"' size="),strSize.get()),">"),strText.get()),"</font></td></tr></table>"));
    //<< if blnIncludeBreaks write "<br /><br />"
    if (mOp.Logical(blnIncludeBreaks.get())) {
      m$.Cmd.Write("<br /><br />");
    }
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< ListExecs(pidForm="")
  public Object ListExecs(Object ... _p) {
    mVar pidForm = m$.newVarRef("pidForm",(((_p!=null)&&(_p.length>=1))?_p[0]:null),"");
    //<< ;-------------------------------------------------------------------------------
    //<< ; Display executable commands associated with a form
    //<< ;
    //<< ; Inputs :
    //<< ;   pidForm     : Form name
    //<< ;
    //<< ; Returns: Nothing
    //<< ;
    //<< ; History:
    //<< ; 19-Dec-2005   GRF     Created (for checking SR14022)
    //<< ;-------------------------------------------------------------------------------
    //<< new blnHead,ClassNo,Command,FieldName,FieldNo,FormName,lengthName,objButton,objData
    mVar blnHead = m$.var("blnHead");
    mVar ClassNo = m$.var("ClassNo");
    mVar Command = m$.var("Command");
    mVar FieldName = m$.var("FieldName");
    mVar FieldNo = m$.var("FieldNo");
    mVar FormName = m$.var("FormName");
    mVar lengthName = m$.var("lengthName");
    mVar objButton = m$.var("objButton");
    mVar objData = m$.var("objData");
    m$.newVar(blnHead,ClassNo,Command,FieldName,FieldNo,FormName,lengthName,objButton,objData);
    //<< new ObjectName,objForm,objKey,objWWW003,objWWW012,Seq
    mVar ObjectName = m$.var("ObjectName");
    mVar objForm = m$.var("objForm");
    mVar objKey = m$.var("objKey");
    mVar objWWW003 = m$.var("objWWW003");
    mVar objWWW012 = m$.var("objWWW012");
    mVar Seq = m$.var("Seq");
    m$.newVar(ObjectName,objForm,objKey,objWWW003,objWWW012,Seq);
    //<< 
    //<< quit:pidForm=""
    if (mOp.Equal(pidForm.get(),"")) {
      return null;
    }
    //<< 
    //<< do:'$data(Y) ^WWWVAR
    if (mOp.Not(m$.Fnc.$data(m$.var("Y")))) {
      m$.Cmd.Do("WWWVAR.main");
    }
    //<< 
    //<< ; TODO : Add customisation entries
    //<< ; TODO : Check all fields being checked
    //<< 
    //<< set lengthName = 40
    lengthName.set(40);
    //<< 
    //<< set objForm  = $get(^WWW120(0,pidForm,1))
    objForm.set(m$.Fnc.$get(m$.var("^WWW120",0,pidForm.get(),1)));
    //<< set FormName = $$$WWW120FormHeaderOrImageFile(objForm)
    FormName.set(include.WWWConst.$$$WWW120FormHeaderOrImageFile(m$,objForm));
    //<< 
    //<< write !,"Executable Commands for form : ",pidForm," (",FormName,")",!
    m$.Cmd.Write("\n","Executable Commands for form : ",pidForm.get()," (",FormName.get(),")","\n");
    //<< 
    //<< write !,"System",!!
    m$.Cmd.Write("\n","System","\n","\n");
    //<< set objWWW012 = $get(^WWW012(0,0,1))
    objWWW012.set(m$.Fnc.$get(m$.var("^WWW012",0,0,1)));
    //<< for FieldNo=29,30 {
    for (Object _FieldNo: new Object[] {29,30}) {
    FieldNo.set(_FieldNo);
      //<< set Command = $piece(objWWW012,Y,FieldNo)
      Command.set(m$.Fnc.$piece(objWWW012.get(),m$.var("Y").get(),_FieldNo));
      //<< if Command'="" {
      if (mOp.NotEqual(Command.get(),"")) {
        //<< set FieldName = $$$WWW003CaptionInForms($get(^WWW003(0,"WWW012",FieldNo,1)))
        FieldName.set(include.WWWConst.$$$WWW003CaptionInForms(m$,m$.Fnc.$get(m$.var("^WWW003",0,"WWW012",_FieldNo,1))));
        //<< set FieldName = FieldName_$justify("",lengthName)
        FieldName.set(mOp.Concat(FieldName.get(),m$.Fnc.$justify("",lengthName.get())));
        //<< write FieldNo,?5,$extract(FieldName,1,lengthName)," : ",Command,!
        m$.Cmd.Write(_FieldNo,"\t","5",m$.Fnc.$extract(FieldName.get(),1,lengthName.get())," : ",Command.get(),"\n");
      }
    }
    //<< }
    //<< }
    //<< 
    //<< write !,"Form",!!
    m$.Cmd.Write("\n","Form","\n","\n");
    //<< for FieldNo=14:1:18,59,86,87,89,93,126 {
    for (FieldNo.set(14);(mOp.LessOrEqual(FieldNo.get(),18));FieldNo.set(mOp.Add(FieldNo.get(),1))) {
      //<< set Command = $piece(objForm,Y,FieldNo)
      Command.set(m$.Fnc.$piece(objForm.get(),m$.var("Y").get(),FieldNo.get()));
      //<< if Command'="" {
      if (mOp.NotEqual(Command.get(),"")) {
        //<< set FieldName = $$$WWW003CaptionInForms($get(^WWW003(0,"WWW120",FieldNo,1)))
        FieldName.set(include.WWWConst.$$$WWW003CaptionInForms(m$,m$.Fnc.$get(m$.var("^WWW003",0,"WWW120",FieldNo.get(),1))));
        //<< set FieldName = FieldName_$justify("",lengthName)
        FieldName.set(mOp.Concat(FieldName.get(),m$.Fnc.$justify("",lengthName.get())));
        //<< write FieldNo,?5,$extract(FieldName,1,lengthName)," : ",Command,!
        m$.Cmd.Write(FieldNo.get(),"\t","5",m$.Fnc.$extract(FieldName.get(),1,lengthName.get())," : ",Command.get(),"\n");
      }
    }
    //<< }
    //<< }
    //<< 
    //<< write !,"Keys",!!
    m$.Cmd.Write("\n","Keys","\n","\n");
    //<< set Seq = ""
    Seq.set("");
    //<< for {
    for (;true;) {
      //<< set Seq = $order(^WWW121(0,pidForm,Seq))
      Seq.set(m$.Fnc.$order(m$.var("^WWW121",0,pidForm.get(),Seq.get())));
      //<< quit:Seq=""
      if (mOp.Equal(Seq.get(),"")) {
        break;
      }
      //<< 
      //<< set blnHead = $$$YES
      blnHead.set(include.COMSYS.$$$YES(m$));
      //<< set objKey  = $get(^WWW121(0,pidForm,Seq,1))
      objKey.set(m$.Fnc.$get(m$.var("^WWW121",0,pidForm.get(),Seq.get(),1)));
      //<< for FieldNo=19,25,26,92,97 {
      for (Object _FieldNo: new Object[] {19,25,26,92,97}) {
        FieldNo.set(_FieldNo);
        //<< set Command = $piece(objKey,Y,FieldNo)
        Command.set(m$.Fnc.$piece(objKey.get(),m$.var("Y").get(),_FieldNo));
        //<< if Command'="" {
        if (mOp.NotEqual(Command.get(),"")) {
          //<< if blnHead {
          if (mOp.Logical(blnHead.get())) {
            //<< set ObjectName = $$$WWW002TextInForms($get(^WWW002(0,pidForm,Seq,1)))
            ObjectName.set(include.WWWConst.$$$WWW002TextInForms(m$,m$.Fnc.$get(m$.var("^WWW002",0,pidForm.get(),Seq.get(),1))));
            //<< write Seq,?5,ObjectName,!
            m$.Cmd.Write(Seq.get(),"\t","5",ObjectName.get(),"\n");
            //<< set blnHead = $$$NO
            blnHead.set(include.COMSYS.$$$NO(m$));
          }
          //<< }
          //<< set FieldName = $$$WWW003CaptionInForms($get(^WWW003(0,"WWW121",FieldNo,1)))
          FieldName.set(include.WWWConst.$$$WWW003CaptionInForms(m$,m$.Fnc.$get(m$.var("^WWW003",0,"WWW121",_FieldNo,1))));
          //<< set FieldName = FieldName_$justify("",lengthName)
          FieldName.set(mOp.Concat(FieldName.get(),m$.Fnc.$justify("",lengthName.get())));
          //<< write ?5,FieldNo,?10,$extract(FieldName,1,lengthName)," : ",Command,!
          m$.Cmd.Write("\t","5",_FieldNo,"\t","10",m$.Fnc.$extract(FieldName.get(),1,lengthName.get())," : ",Command.get(),"\n");
        }
      }
    }
    //<< }
    //<< }
    //<< }
    //<< 
    //<< ;---------------------------------------
    //<< ;   D25     $$$WWW122ExecuteOnBlur
    //<< ;   D92     $$$WWW122ExecuteBeforeDataField     On Form Construction (before)
    //<< ;   D97     $$$WWW122ExecuteAfterDataField      On Form Construction (after)
    //<< ;   D99     $$$WWW122ExecuteWithinDataField     On Form Construction (within)
    //<< ;---------------------------------------
    //<< write !,"Data",!!
    m$.Cmd.Write("\n","Data","\n","\n");
    //<< set Seq = ""
    Seq.set("");
    //<< for {
    for (;true;) {
      //<< set Seq = $order(^WWW122(0,pidForm,Seq))
      Seq.set(m$.Fnc.$order(m$.var("^WWW122",0,pidForm.get(),Seq.get())));
      //<< quit:Seq=""
      if (mOp.Equal(Seq.get(),"")) {
        break;
      }
      //<< 
      //<< set blnHead = $$$YES
      blnHead.set(include.COMSYS.$$$YES(m$));
      //<< set objData = $get(^WWW122(0,pidForm,Seq,1))
      objData.set(m$.Fnc.$get(m$.var("^WWW122",0,pidForm.get(),Seq.get(),1)));
      //<< set ClassNo = $$$WWW122SequenceNumber(objData)
      ClassNo.set(include.WWWConst.$$$WWW122SequenceNumber(m$,objData));
      //<< if ClassNo="" {
      if (mOp.Equal(ClassNo.get(),"")) {
        //<< set ObjectName = $$$WWW122ManualCaption(objData)
        ObjectName.set(include.WWWConst.$$$WWW122ManualCaption(m$,objData));
      }
      //<< } else {
      else {
        //<< set objWWW003  = $get(^WWW003(0,pidForm,ClassNo,1))
        objWWW003.set(m$.Fnc.$get(m$.var("^WWW003",0,pidForm.get(),ClassNo.get(),1)));
        //<< set ObjectName = $$$WWW003CaptionInForms(objWWW003)
        ObjectName.set(include.WWWConst.$$$WWW003CaptionInForms(m$,objWWW003));
      }
      //<< }
      //<< 
      //<< for FieldNo=25,92,97,99 {
      for (Object _FieldNo: new Object[] {25,92,97,99}) {
        FieldNo.set(_FieldNo);
        //<< set Command = $piece(objData,Y,FieldNo)
        Command.set(m$.Fnc.$piece(objData.get(),m$.var("Y").get(),_FieldNo));
        //<< if Command'="" {
        if (mOp.NotEqual(Command.get(),"")) {
          //<< if blnHead {
          if (mOp.Logical(blnHead.get())) {
            //<< write Seq,?5,ObjectName,!
            m$.Cmd.Write(Seq.get(),"\t","5",ObjectName.get(),"\n");
            //<< set blnHead = $$$NO
            blnHead.set(include.COMSYS.$$$NO(m$));
          }
          //<< }
          //<< set FieldName = $$$WWW003CaptionInForms($get(^WWW003(0,"WWW122",FieldNo,1)))
          FieldName.set(include.WWWConst.$$$WWW003CaptionInForms(m$,m$.Fnc.$get(m$.var("^WWW003",0,"WWW122",_FieldNo,1))));
          //<< set FieldName = FieldName_$justify("",lengthName)
          FieldName.set(mOp.Concat(FieldName.get(),m$.Fnc.$justify("",lengthName.get())));
          //<< write ?5,FieldNo,?10,$extract(FieldName,1,lengthName)," : ",Command,!
          m$.Cmd.Write("\t","5",_FieldNo,"\t","10",m$.Fnc.$extract(FieldName.get(),1,lengthName.get())," : ",Command.get(),"\n");
        }
      }
    }
    //<< }
    //<< }
    //<< }
    //<< 
    //<< ;---------------------------------------
    //<< ;   D6      $$$WWW124ExecuteOnClick()
    //<< ;   D25     $$$WWW124ExecuteForManualLink()
    //<< ;   D52     $$$WWW124ExecuteAfterBackwardStep()
    //<< ;   D62     $$$WWW124ExecuteToCheckForDisabled()
    //<< ;   D65     $$$WWW124HyperEventOnClick()
    //<< ;---------------------------------------
    //<< 
    //<< write !,"Buttons",!!
    m$.Cmd.Write("\n","Buttons","\n","\n");
    //<< set:$get(SPRACHE)="" SPRACHE="EN"
    if (mOp.Equal(m$.Fnc.$get(m$.var("SPRACHE")),"")) {
      m$.var("SPRACHE").set("EN");
    }
    //<< set Seq = ""
    Seq.set("");
    //<< for {
    for (;true;) {
      //<< set Seq = $order(^WWW124(0,pidForm,SPRACHE,Seq))
      Seq.set(m$.Fnc.$order(m$.var("^WWW124",0,pidForm.get(),m$.var("SPRACHE").get(),Seq.get())));
      //<< quit:Seq=""
      if (mOp.Equal(Seq.get(),"")) {
        break;
      }
      //<< 
      //<< set blnHead   = $$$YES
      blnHead.set(include.COMSYS.$$$YES(m$));
      //<< set objButton = $get(^WWW124(0,pidForm,SPRACHE,Seq,1))
      objButton.set(m$.Fnc.$get(m$.var("^WWW124",0,pidForm.get(),m$.var("SPRACHE").get(),Seq.get(),1)));
      //<< for FieldNo=6,25,52,62,65 {
      for (Object _FieldNo: new Object[] {6,25,52,62,65}) {
        FieldNo.set(_FieldNo);
        //<< set Command = $piece(objButton,Y,FieldNo)
        Command.set(m$.Fnc.$piece(objButton.get(),m$.var("Y").get(),_FieldNo));
        //<< if Command'="" {
        if (mOp.NotEqual(Command.get(),"")) {
          //<< if blnHead {
          if (mOp.Logical(blnHead.get())) {
            //<< set ObjectName = $$$WWW124ButtonDescription(objButton)
            ObjectName.set(include.WWWConst.$$$WWW124ButtonDescription(m$,objButton));
            //<< write Seq,?5,ObjectName,!
            m$.Cmd.Write(Seq.get(),"\t","5",ObjectName.get(),"\n");
            //<< set blnHead = $$$NO
            blnHead.set(include.COMSYS.$$$NO(m$));
          }
          //<< }
          //<< set FieldName = $$$WWW003CaptionInForms($get(^WWW003(0,"WWW124",FieldNo,1)))      ; D2
          FieldName.set(include.WWWConst.$$$WWW003CaptionInForms(m$,m$.Fnc.$get(m$.var("^WWW003",0,"WWW124",_FieldNo,1))));
          //<< set FieldName = FieldName_$justify("",lengthName)
          FieldName.set(mOp.Concat(FieldName.get(),m$.Fnc.$justify("",lengthName.get())));
          //<< write ?5,FieldNo,?10,$extract(FieldName,1,lengthName)," : ",Command,!
          m$.Cmd.Write("\t","5",_FieldNo,"\t","10",m$.Fnc.$extract(FieldName.get(),1,lengthName.get())," : ",Command.get(),"\n");
        }
      }
    }
    //<< }
    //<< }
    //<< }
    //<< write !,"*****************************",!
    m$.Cmd.Write("\n","*****************************","\n");
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< Delete(pidForm)
  public Object Delete(Object ... _p) {
    mVar pidForm = m$.newVarRef("pidForm",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Wrapper for DEL^WWWFLOE. @Net form deletion.
    //<< ;
    //<< ; Params:   pidForm - (mandatory) form to delete
    //<< ;
    //<< ; ByRefs:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 19-Apr-2006   JW      SR14429: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new VORGX,VORG,YQ
    mVar VORGX = m$.var("VORGX");
    mVar VORG = m$.var("VORG");
    mVar YQ = m$.var("YQ");
    m$.newVar(VORGX,VORG,YQ);
    //<< 
    //<< if ($get(pidForm)'="") && $data(^WWW120(0,pidForm,1)) {
    if ((mOp.NotEqual(m$.Fnc.$get(pidForm),"")) && mOp.Logical(m$.Fnc.$data(m$.var("^WWW120",0,pidForm.get(),1)))) {
      //<< set VORGX   = pidForm
      VORGX.set(pidForm.get());
      //<< set VORG(2) = $$$YES
      VORG.var(2).set(include.COMSYS.$$$YES(m$));
      //<< set YQ      = 1
      YQ.set(1);
      //<< do DEL^WWWFLOE
      m$.Cmd.Do("WWWFLOE.DEL");
    }
    //<< }
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< FormRedirect(pidForm, pidKey)
  public Object FormRedirect(Object ... _p) {
    mVar pidForm = m$.newVarRef("pidForm",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pidKey = m$.newVarRef("pidKey",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Redirect to appropriate to form. Also lock current form and display
    //<< ; message prior to redirection.
    //<< ;
    //<< ; Params:
    //<< ; pidForm - Form Id
    //<< ; pidKey - Key
    //<< ;
    //<< ; ByRefs: None
    //<< ;
    //<< ; Returns: Nothing
    //<< ;
    //<< ; History:
    //<< ; 21-Jul-2009   GRF     Enum Macro
    //<< ; 27-Oct-2006   PO      SR15143: Created
    //<< ;-------------------------------------------------------------------------------
    //<< set $$$WWW120AuthorizationToModifyData(YVOR) = $$$EnumReadOnly
    include.WWWConst.$$$WWW120AuthorizationToModifyDataSet(m$,m$.var("YVOR"),include.COMSYSEnum.$$$EnumReadOnly(m$));
    //<< 
    //<< $$$Alert($listbuild("Com00263", $$^WWWFORMNAME(pidForm)))  ; "Redirecting to the form %1."
    include.COMSYS.$$$Alert(m$,m$.Fnc.$listbuild("Com00263",m$.fnc$("WWWFORMNAME.main",pidForm.get())));
    //<< 
    //<< do RedirectForm^COMUtilForm(pidForm,pidKey,$get(YBACK),"","")
    m$.Cmd.Do("COMUtilForm.RedirectForm",pidForm.get(),pidKey.get(),m$.Fnc.$get(m$.var("YBACK")),"","");
    //<< quit
    return null;
  }

  //<< 
  //<< AfterFieldText(pstrText)
  public Object AfterFieldText(Object ... _p) {
    mVar pstrText = m$.newVarRef("pstrText",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Display Text after the field
    //<< ; Params:
    //<< ;   pstrText
    //<< ;
    //<< ; ByRefs: None
    //<< ;
    //<< ; Returns: Nothing
    //<< ;
    //<< ; History:
    //<< ; 04-Oct-2012   shobby  SR18129: Better alignment of caption and input controls
    //<< ; 15-May-2012   PO      SR17993: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new strFont
    mVar strFont = m$.var("strFont");
    m$.newVar(strFont);
    //<< set:$get(YFORM)'="" strFont=$PIECE($GET(^WWW120(0,YFORM,1)),Y,7)
    if (mOp.NotEqual(m$.Fnc.$get(m$.var("YFORM")),"")) {
      strFont.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW120",0,m$.var("YFORM").get(),1)),m$.var("Y").get(),7));
    }
    //<< if $get(strFont)="" set strFont=$PIECE($get(YVOR),Y,7)
    if (mOp.Equal(m$.Fnc.$get(strFont),"")) {
      strFont.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("YVOR")),m$.var("Y").get(),7));
    }
    //<< if strFont="" set strFont=2
    if (mOp.Equal(strFont.get(),"")) {
      strFont.set(2);
    }
    //<< 
    //<< 
    //<< ;SR18129 write "<FONT SIZE="""_strFont_""">",$$$Text(pstrText)_"</FONT>"
    //<< write "<FONT SIZE="""_strFont_""""                                                           ;SR18129
    m$.Cmd.Write(mOp.Concat(mOp.Concat("<FONT SIZE=\"",strFont.get()),"\""));
    //<< if YVAUS="TOP" write " style='vertical-align:top; position:relative; top:"_YPADDINGTOP_";' " ;SR18129
    if (mOp.Equal(m$.var("YVAUS").get(),"TOP")) {
      m$.Cmd.Write(mOp.Concat(mOp.Concat(" style='vertical-align:top; position:relative; top:",m$.var("YPADDINGTOP").get()),";' "));
    }
    //<< write ">",$$$Text(pstrText)_"</FONT>"                                                        ;SR18129
    m$.Cmd.Write(">",mOp.Concat(include.COMSYS.$$$Text(m$,pstrText),"</FONT>"));
    //<< quit
    return null;
  }

//<< 
}
