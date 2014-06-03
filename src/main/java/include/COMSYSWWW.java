//*****************************************************************************
//** TASC - ALPHALINC - INC include.COMSYSWWW
//** Innovatium Systems - Code Converter - v1.27
//** 2014-05-22 00:12:42
//*****************************************************************************

package include;

import mLibrary.*;

//<< #include WWWConst
import include.WWWConst;
import include.COMSYS;

//<< #; COMSYSWWW.inc        Macros for @Net functions
public class COMSYSWWW extends mInclude {

  //<< 
  //<< #define ParentSeparator             "x"
  public static Object $$$ParentSeparator(mContext m$) {
    return ("x");
  }

  //<< #define GetParentUser(%u)           ($piece(%u,$$$ParentSeparator,1,$select($length(%u,$$$ParentSeparator)=1:1,1:($length(%u,$$$ParentSeparator)-1))))
  public static Object $$$GetParentUser(mContext m$, Object ... _p) {
    mVar p$u = m$.varRef("p$u",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return ((m$.Fnc.$piece(p$u.get(),$$$ParentSeparator(m$),1,m$.Fnc.$select(mOp.Equal(m$.Fnc.$length(p$u.get(),$$$ParentSeparator(m$)),1),1,1,(mOp.Subtract(m$.Fnc.$length(p$u.get(),$$$ParentSeparator(m$)),1))))));
  }

  //<< #define GetTopUser(%u)              (+%u)
  public static Object $$$GetTopUser(mContext m$, Object ... _p) {
    mVar p$u = m$.varRef("p$u",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return ((mOp.Positive(p$u.get())));
  }

  //<< #define IsTopUser(%u)               (%u = $$$GetTopUser(%u))
  public static Object $$$IsTopUser(mContext m$, Object ... _p) {
    mVar p$u = m$.varRef("p$u",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return ((mOp.Equal(p$u.get(),$$$GetTopUser(m$,p$u))));
  }

  //<< 
  //<< #def1arg StartFrameSet(%args)       do StartFrameSet^WWWSession(%args)
  public static Object $$$StartFrameSet(mContext m$, Object ... _p) {
    //mVar p$args = m$.varRef("p$args",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //m$.Cmd.Do("WWWSession.StartFrameSet",p$args.get());
    m$.Cmd.Do("WWWSession.StartFrameSet",_p);
    return null;
  }

  //<< #define EndFrameSet                 write "</FRAMESET>"
  public static Object $$$EndFrameSet(mContext m$) {
    m$.Cmd.Write("</FRAMESET>");
    return null;
  }

  //<< 
  //<< ;-------------------------------------------------------------------------------
  //<< ; 10-Jul-2009   DWR SR16565: added missing key in definition of GetClass
  //<< ; 22-Jan-2007   PO  SR15316: Created IsUsedElsewhere - I don't have lock, nor does anyone else
  //<< ;-------------------------------------------------------------------------------
  //<< 
  //<< ;#if it's not locked by anyone or by someone else, consider this as bad.
  //<< #define InUseElsewhere(%1,%2,%3,%4) $case($$GetLockUser^WWWMultiLock(%1,%2,%3),%4:0,"":1,:1)
  public static Object $$$InUseElsewhere(mContext m$, Object ... _p) {
    mVar p$1 = m$.varRef("p$1",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar p$2 = m$.varRef("p$2",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar p$3 = m$.varRef("p$3",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    mVar p$4 = m$.varRef("p$4",(((_p!=null)&&(_p.length>=4))?_p[3]:null));
    return (m$.Fnc.$case(m$.fnc$("WWWMultiLock.GetLockUser",p$1.get(),p$2.get(),p$3.get()),p$4.get(),0,"",1,1));
  }

  //<< 
  //<< 
  //<< #; Returns 0 or YM depending on whether a class is shared
  //<< #define WWWYM(%class)               $select($$$WWW001SharedFile($get(^WWW001(0,%class,1))):0,1:YM)
  public static Object $$$WWWYM(mContext m$, Object ... _p) {
    mVar p$class = m$.varRef("p$class",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$select(include.WWWConst.$$$WWW001SharedFile(m$,m$.Fnc.$get(m$.var("^WWW001",0,p$class.get(),1))),0,1,m$.var("YM").get()));
  }

  //<< 
  //<< #; Returns "" or ",1" depending on 'alternative save procedure'
  //<< #define Add1(%class)                $select($$$WWW001AltSaveProcedure($get(^WWW001(0,%class,1)))=4:"",1:",1")
  public static Object $$$Add1(mContext m$, Object ... _p) {
    mVar p$class = m$.varRef("p$class",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$select(mOp.Equal(include.WWWConst.$$$WWW001AltSaveProcedure(m$,m$.Fnc.$get(m$.var("^WWW001",0,p$class.get(),1))),4),"",1,",1"));
  }

  //<< 
  //<< #; Create global string
  //<< #define GlobalString(%class,%keys)  "^"_%class_"("_$$^WWWKEYBUILD($$$WWWYM(%class)_$select(%keys'="":","_%keys,1:""))_")"
  public static Object $$$GlobalString(mContext m$, Object ... _p) {
    mVar p$class = m$.varRef("p$class",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar p$keys = m$.varRef("p$keys",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    return (mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("^",p$class.get()),"("),m$.fnc$("WWWKEYBUILD.main",mOp.Concat($$$WWWYM(m$,p$class),m$.Fnc.$select(mOp.NotEqual(p$keys.get(),""),mOp.Concat(",",p$keys.get()),1,"")))),")"));
  }

  //<< 
  //<< #; Create full @net node string
  //<< #define NodeString(%c,%k)           "^"_%c_"("""_$$$WWWYM(%c)_""""_$$$COMMA_%k_$$$Add1(%c)_")"
  public static Object $$$NodeString(mContext m$, Object ... _p) {
    mVar p$c = m$.varRef("p$c",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar p$k = m$.varRef("p$k",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    return (mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("^",p$c.get()),"(\""),$$$WWWYM(m$,p$c)),"\""),include.COMSYSString.$$$COMMA(m$)),p$k.get()),$$$Add1(m$,p$c)),")"));
  }

  //<< 
  //<< #define DATA(%1,%2)                 @("^"_%1_"("_$$^WWWKEYBUILD($$$WWWYM(%1)_$$$COMMA_%2_",1")_")")
  public static Object $$$DATA(mContext m$, Object ... _p) {
    mVar p$1 = m$.varRef("p$1",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar p$2 = m$.varRef("p$2",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    return (m$.indirectVar((mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("^",p$1.get()),"("),m$.fnc$("WWWKEYBUILD.main",mOp.Concat(mOp.Concat(mOp.Concat($$$WWWYM(m$,p$1),include.COMSYSString.$$$COMMA(m$)),p$2.get()),",1"))),")"))).get());
  }

  public static mVar $$$DATAVar(mContext m$, Object ... _p) {
    mVar p$1 = m$.varRef("p$1",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar p$2 = m$.varRef("p$2",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    return (m$.indirectVar((mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("^",p$1.get()),"("),m$.fnc$("WWWKEYBUILD.main",mOp.Concat(mOp.Concat(mOp.Concat($$$WWWYM(m$,p$1),include.COMSYSString.$$$COMMA(m$)),p$2.get()),",1"))),")"))));
  }

  //<< 
  //<< 
  //<< #; Translates form field index into class field index and vice versa
  //<< #define GetClass(%form)                 $piece($get(^WWW120(0,%form,1)),Y,11)
  public static Object $$$GetClass(mContext m$, Object ... _p) {
    mVar p$form = m$.varRef("p$form",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW120",0,p$form.get(),1)),m$.var("Y").get(),11));
  }

  //<< 
  //<< #define GetClassField(%form,%frmfield)  $piece($get(^WWW122(0,%form,+%frmfield,1)),Y,1)
  public static Object $$$GetClassField(mContext m$, Object ... _p) {
    mVar p$form = m$.varRef("p$form",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar p$frmfield = m$.varRef("p$frmfield",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    return (m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW122",0,p$form.get(),mOp.Positive(p$frmfield.get()),1)),m$.var("Y").get(),1));
  }

  //<< #define GetFormField(%form,%clsfield)   $order(^WWW122s(0,4,+%clsfield,%form,""))
  public static Object $$$GetFormField(mContext m$, Object ... _p) {
    mVar p$form = m$.varRef("p$form",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar p$clsfield = m$.varRef("p$clsfield",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    return (m$.Fnc.$order(m$.var("^WWW122s",0,4,mOp.Positive(p$clsfield.get()),p$form.get(),"")));
  }

  //<< #define GetUserID(%1)                   $piece($get(^WWWUSER(0,%1,1)),Y,2)
  public static Object $$$GetUserID(mContext m$, Object ... _p) {
    mVar p$1 = m$.varRef("p$1",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWWUSER",0,p$1.get(),1)),m$.var("Y").get(),2));
  }

  //<< 
  //<< #define GetFormData(%form,%type)        $get(^WWWDATEN(0,+$horolog,YUSER,%form,%type,1))
  public static Object $$$GetFormData(mContext m$, Object ... _p) {
    mVar p$form = m$.varRef("p$form",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar p$type = m$.varRef("p$type",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    return (m$.Fnc.$get(m$.var("^WWWDATEN",0,mOp.Positive(m$.Fnc.$horolog()),m$.var("YUSER").get(),p$form.get(),p$type.get(),1)));
  }

  //<< #define GetFormDataOld(%form,%type)     $get(^WWWDATEN(0,+$horolog,YUSER,%form,%type,2))
  public static Object $$$GetFormDataOld(mContext m$, Object ... _p) {
    mVar p$form = m$.varRef("p$form",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar p$type = m$.varRef("p$type",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    return (m$.Fnc.$get(m$.var("^WWWDATEN",0,mOp.Positive(m$.Fnc.$horolog()),m$.var("YUSER").get(),p$form.get(),p$type.get(),2)));
  }

  //<< 
  //<< #; Common @Net Manager functions
  //<< #define NextKey(%str)                   $$^WWWNEXT(%str)
  public static Object $$$NextKey(mContext m$, Object ... _p) {
    mVar p$str = m$.varRef("p$str",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.fnc$("WWWNEXT.main",p$str.get()));
  }

  //<< #define FormatDate(%str)                $$^WWWDATE(%str)
  public static Object $$$FormatDate(mContext m$, Object ... _p) {
    mVar p$str = m$.varRef("p$str",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.fnc$("WWWDATE.main",p$str.get()));
  }

  //<< #define FormatTime(%time)               $$^WWWTIME(%time)
  public static Object $$$FormatTime(mContext m$, Object ... _p) {
    mVar p$time = m$.varRef("p$time",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.fnc$("WWWTIME.main",p$time.get()));
  }

  //<< #define FormatTimeStamp(%str)           $$^WWWDATE($piece(%str,",",1))_" "_$$^WWWTIME($piece(%str,",",2))
  public static Object $$$FormatTimeStamp(mContext m$, Object ... _p) {
    mVar p$str = m$.varRef("p$str",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (mOp.Concat(mOp.Concat(m$.fnc$("WWWDATE.main",m$.Fnc.$piece(p$str.get(),",",1))," "),m$.fnc$("WWWTIME.main",m$.Fnc.$piece(p$str.get(),",",2))));
  }

  //<< #define FieldName(%Form,%Type,%Number)  $$^WWWFELDNAME(%Form,%Type,%Number)
  public static Object $$$FieldName(mContext m$, Object ... _p) {
    mVar p$Form = m$.varRef("p$Form",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar p$Type = m$.varRef("p$Type",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar p$Number = m$.varRef("p$Number",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    return (m$.fnc$("WWWFELDNAME.main",p$Form.get(),p$Type.get(),p$Number.get()));
  }

  //<< #define FormName(%1)                    $$^WWWFORMNAME(%1)
  public static Object $$$FormName(mContext m$, Object ... _p) {
    mVar p$1 = m$.varRef("p$1",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.fnc$("WWWFORMNAME.main",p$1.get()));
  }

  //<< 
  //<< #define KEY1(%1)        $piece(%1,$$$COMMA,1)
  public static Object $$$KEY1(mContext m$, Object ... _p) {
    mVar p$1 = m$.varRef("p$1",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$1.get(),include.COMSYSString.$$$COMMA(m$),1));
  }

  public static void $$$KEY1Set(mContext m$, Object ... _p) {
    mVar p$1 = m$.varRef("p$1",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$1,include.COMSYSString.$$$COMMA(m$),1).set(_setval.get());
  }

  //<< #define KEY2(%1)        $piece(%1,$$$COMMA,2)
  public static Object $$$KEY2(mContext m$, Object ... _p) {
    mVar p$1 = m$.varRef("p$1",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$1.get(),include.COMSYSString.$$$COMMA(m$),2));
  }

  public static void $$$KEY2Set(mContext m$, Object ... _p) {
    mVar p$1 = m$.varRef("p$1",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$1,include.COMSYSString.$$$COMMA(m$),2).set(_setval.get());
  }

  //<< #define KEY3(%1)        $piece(%1,$$$COMMA,3)
  public static Object $$$KEY3(mContext m$, Object ... _p) {
    mVar p$1 = m$.varRef("p$1",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$1.get(),include.COMSYSString.$$$COMMA(m$),3));
  }

  public static void $$$KEY3Set(mContext m$, Object ... _p) {
    mVar p$1 = m$.varRef("p$1",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$1,include.COMSYSString.$$$COMMA(m$),3).set(_setval.get());
  }

  //<< #define KEY4(%1)        $piece(%1,$$$COMMA,4)
  public static Object $$$KEY4(mContext m$, Object ... _p) {
    mVar p$1 = m$.varRef("p$1",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$1.get(),include.COMSYSString.$$$COMMA(m$),4));
  }

  public static void $$$KEY4Set(mContext m$, Object ... _p) {
    mVar p$1 = m$.varRef("p$1",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$1,include.COMSYSString.$$$COMMA(m$),4).set(_setval.get());
  }

  //<< #define KEY5(%1)        $piece(%1,$$$COMMA,5)
  public static Object $$$KEY5(mContext m$, Object ... _p) {
    mVar p$1 = m$.varRef("p$1",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$1.get(),include.COMSYSString.$$$COMMA(m$),5));
  }

  public static void $$$KEY5Set(mContext m$, Object ... _p) {
    mVar p$1 = m$.varRef("p$1",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$1,include.COMSYSString.$$$COMMA(m$),5).set(_setval.get());
  }

  //<< #define KEY6(%1)        $piece(%1,$$$COMMA,6)
  public static Object $$$KEY6(mContext m$, Object ... _p) {
    mVar p$1 = m$.varRef("p$1",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$1.get(),include.COMSYSString.$$$COMMA(m$),6));
  }

  public static void $$$KEY6Set(mContext m$, Object ... _p) {
    mVar p$1 = m$.varRef("p$1",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$1,include.COMSYSString.$$$COMMA(m$),6).set(_setval.get());
  }

  //<< #define KEY(%1,%2)      $piece(%1,$$$COMMA,%2)
  public static Object $$$KEY(mContext m$, Object ... _p) {
    mVar p$1 = m$.varRef("p$1",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar p$2 = m$.varRef("p$2",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    return (m$.Fnc.$piece(p$1.get(),include.COMSYSString.$$$COMMA(m$),p$2.get()));
  }

  public static void $$$KEYSet(mContext m$, Object ... _p) {
    mVar p$1 = m$.varRef("p$1",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar p$2 = m$.varRef("p$2",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    m$.pieceVar(p$1,include.COMSYSString.$$$COMMA(m$),p$2.get()).set(_setval.get());
  }

  //<< #define KEYMAX(%1)      $piece(%1,$$$COMMA,$length(%1,$$$COMMA))
  public static Object $$$KEYMAX(mContext m$, Object ... _p) {
    mVar p$1 = m$.varRef("p$1",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$1.get(),include.COMSYSString.$$$COMMA(m$),m$.Fnc.$length(p$1.get(),include.COMSYSString.$$$COMMA(m$))));
  }

  public static void $$$KEYMAXSet(mContext m$, Object ... _p) {
    mVar p$1 = m$.varRef("p$1",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$1,include.COMSYSString.$$$COMMA(m$),m$.Fnc.$length(p$1.get(),include.COMSYSString.$$$COMMA(m$))).set(_setval.get());
  }

  //<< 
  //<< #define CopyIncrement   0.01
  public static Object $$$CopyIncrement(mContext m$) {
    return (0.01);
  }

  //<< 
  //<< #; Return descriptions from Application/System Parameters
  //<< #define AppEnum(%str1,%str2) $$GetEnumDescription^COMUtils(%str1,%str2)
  public static Object $$$AppEnum(mContext m$, Object ... _p) {
    mVar p$str1 = m$.varRef("p$str1",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar p$str2 = m$.varRef("p$str2",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    return (m$.fnc$("COMUtils.GetEnumDescription",p$str1.get(),p$str2.get()));
  }

  //<< #define SysEnum(%str1,%str2) $$GetEnumDescription^COMUtils(%str1,%str2,$$$YES)
  public static Object $$$SysEnum(mContext m$, Object ... _p) {
    mVar p$str1 = m$.varRef("p$str1",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar p$str2 = m$.varRef("p$str2",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    return (m$.fnc$("COMUtils.GetEnumDescription",p$str1.get(),p$str2.get(),include.COMSYS.$$$YES(m$)));
  }

  //<< 
  //<< // ***********************************************
  //<< // Various Execution tests in @netManager Form definition
  //<< // Variable Q               :    0                :   1
  //<< // BeforeSaveDataRecord     :  Save changes       : Don't save changes
  //<< // BeforeDeletePossibility  :  Show Delete Button : Don't Show it
  //<< // BeforeDeletionDataRecord :  Allow Deletion     : Don't allow deletion
  //<< #define QDontSave   1
  public static Object $$$QDontSave(mContext m$) {
    return (1);
  }

  //<< #define QSave       0
  public static Object $$$QSave(mContext m$) {
    return (0);
  }

  //<< #define QDontDelete 1
  public static Object $$$QDontDelete(mContext m$) {
    return (1);
  }

  //<< #define QDelete     0
  public static Object $$$QDelete(mContext m$) {
    return (0);
  }

  //<< 
  //<< // Execution tests for @netManager buttons
  //<< #define YQEnable            0
  public static Object $$$YQEnable(mContext m$) {
    return (0);
  }

  //<< #define YQDisable(%obj)     1_$$DecodeError^COMUtilError(%obj)
  public static Object $$$YQDisable(mContext m$, Object ... _p) {
    mVar p$obj = m$.varRef("p$obj",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (mOp.Concat(1,m$.fnc$("COMUtilError.DecodeError",p$obj.get())));
  }

  //<< // ***********************************************
  //<< 
  //<< 
  //<< #define MadeChangeText      " if (document.WWW.YBEARB!=null) BEARB("""_$GET(^WWW100(0,"BEARBEITUNG",SPRACHE,2,1))_""");"
  public static Object $$$MadeChangeText(mContext m$) {
    return (mOp.Concat(mOp.Concat(" if (document.WWW.YBEARB!=null) BEARB(\"",m$.Fnc.$get(m$.var("^WWW100",0,"BEARBEITUNG",m$.var("SPRACHE").get(),2,1))),"\");"));
  }

  //<< 
  //<< #;  SR15339 vvv
  //<< #define DYNTABLEGridLineFocusForm(%1)       $piece(%1,$char(31),1)
  public static Object $$$DYNTABLEGridLineFocusForm(mContext m$, Object ... _p) {
    mVar p$1 = m$.varRef("p$1",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$1.get(),m$.Fnc.$char(31),1));
  }

  public static void $$$DYNTABLEGridLineFocusFormSet(mContext m$, Object ... _p) {
    mVar p$1 = m$.varRef("p$1",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$1,m$.Fnc.$char(31),1).set(_setval.get());
  }

  //<< #define DYNTABLEGridLineFocusGrid(%1)       $piece(%1,$char(31),2)
  public static Object $$$DYNTABLEGridLineFocusGrid(mContext m$, Object ... _p) {
    mVar p$1 = m$.varRef("p$1",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$1.get(),m$.Fnc.$char(31),2));
  }

  public static void $$$DYNTABLEGridLineFocusGridSet(mContext m$, Object ... _p) {
    mVar p$1 = m$.varRef("p$1",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$1,m$.Fnc.$char(31),2).set(_setval.get());
  }

  //<< #define DYNTABLEGridLineFocusDynTable(%1)   $piece(%1,$char(31),3)
  public static Object $$$DYNTABLEGridLineFocusDynTable(mContext m$, Object ... _p) {
    mVar p$1 = m$.varRef("p$1",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$1.get(),m$.Fnc.$char(31),3));
  }

  public static void $$$DYNTABLEGridLineFocusDynTableSet(mContext m$, Object ... _p) {
    mVar p$1 = m$.varRef("p$1",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$1,m$.Fnc.$char(31),3).set(_setval.get());
  }

  //<< #define DYNTABLEGridLineFocusRow(%1)        $piece(%1,$char(31),4)
  public static Object $$$DYNTABLEGridLineFocusRow(mContext m$, Object ... _p) {
    mVar p$1 = m$.varRef("p$1",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$1.get(),m$.Fnc.$char(31),4));
  }

  public static void $$$DYNTABLEGridLineFocusRowSet(mContext m$, Object ... _p) {
    mVar p$1 = m$.varRef("p$1",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$1,m$.Fnc.$char(31),4).set(_setval.get());
  }

  //<< 
  //<< #; FIXME : Should this be 1,3,4 rather than 1,2,3? <GRF>
  //<< #define DYNTABLEAfterDataFieldsForm(%1)     $piece(%1,$char(31),1)
  public static Object $$$DYNTABLEAfterDataFieldsForm(mContext m$, Object ... _p) {
    mVar p$1 = m$.varRef("p$1",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$1.get(),m$.Fnc.$char(31),1));
  }

  public static void $$$DYNTABLEAfterDataFieldsFormSet(mContext m$, Object ... _p) {
    mVar p$1 = m$.varRef("p$1",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$1,m$.Fnc.$char(31),1).set(_setval.get());
  }

  //<< #define DYNTABLEAfterDataFieldsDynTable(%1) $piece(%1,$char(31),2)
  public static Object $$$DYNTABLEAfterDataFieldsDynTable(mContext m$, Object ... _p) {
    mVar p$1 = m$.varRef("p$1",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$1.get(),m$.Fnc.$char(31),2));
  }

  public static void $$$DYNTABLEAfterDataFieldsDynTableSet(mContext m$, Object ... _p) {
    mVar p$1 = m$.varRef("p$1",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$1,m$.Fnc.$char(31),2).set(_setval.get());
  }

  //<< #define DYNTABLEAfterDataFieldsKey(%1)      $piece(%1,$char(31),3)
  public static Object $$$DYNTABLEAfterDataFieldsKey(mContext m$, Object ... _p) {
    mVar p$1 = m$.varRef("p$1",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$piece(p$1.get(),m$.Fnc.$char(31),3));
  }

  public static void $$$DYNTABLEAfterDataFieldsKeySet(mContext m$, Object ... _p) {
    mVar p$1 = m$.varRef("p$1",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar _setval = m$.varRef("_setval",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    m$.pieceVar(p$1,m$.Fnc.$char(31),3).set(_setval.get());
  }

  //<< #;  SR15339 ^^^
  //<< 
  //<< #;  SR15442 vvv
  //<< #define New     1
  public static Object $$$New(mContext m$) {
    return (1);
  }

  //<< #define Changed 2
  public static Object $$$Changed(mContext m$) {
    return (2);
  }

  //<< #define Saved   3
  public static Object $$$Saved(mContext m$) {
    return (3);
  }

  //<< #define InUse   4
  public static Object $$$InUse(mContext m$) {
    return (4);
  }

  //<< #;  SR15442 ^^^
  //<< 
  //<< 
  //<< #;  SR15384 vvv
  //<< #define FLDHidden       0
  public static Object $$$FLDHidden(mContext m$) {
    return (0);
  }

  //<< #define FLDDate         1
  public static Object $$$FLDDate(mContext m$) {
    return (1);
  }

  //<< #define FLDBoolean      2
  public static Object $$$FLDBoolean(mContext m$) {
    return (2);
  }

  //<< #define FLDMemo         3
  public static Object $$$FLDMemo(mContext m$) {
    return (3);
  }

  //<< #define FLDNumeric      4
  public static Object $$$FLDNumeric(mContext m$) {
    return (4);
  }

  //<< #define FLDPassword     5
  public static Object $$$FLDPassword(mContext m$) {
    return (5);
  }

  //<< #define FLDText         6
  public static Object $$$FLDText(mContext m$) {
    return (6);
  }

  //<< #define FLDTime         7
  public static Object $$$FLDTime(mContext m$) {
    return (7);
  }

  //<< #define FLDCurrency     8
  public static Object $$$FLDCurrency(mContext m$) {
    return (8);
  }

  //<< #define FLDCounter      9
  public static Object $$$FLDCounter(mContext m$) {
    return (9);
  }

  //<< #define FLDFile         10
  public static Object $$$FLDFile(mContext m$) {
    return (10);
  }

  //<< #define FLDDraw         11
  public static Object $$$FLDDraw(mContext m$) {
    return (11);
  }

  //<< #define FLDFloating     12
  public static Object $$$FLDFloating(mContext m$) {
    return (12);
  }

  //<< #define FLDIP           13
  public static Object $$$FLDIP(mContext m$) {
    return (13);
  }

  //<< #define FLDTimestamp    14
  public static Object $$$FLDTimestamp(mContext m$) {
    return (14);
  }

  //<< #define FLDCollection   15
  public static Object $$$FLDCollection(mContext m$) {
    return (15);
  }

  //<< #define FLDEmbedded     16
  public static Object $$$FLDEmbedded(mContext m$) {
    return (16);
  }

  //<< #define FLDDate2        17
  public static Object $$$FLDDate2(mContext m$) {
    return (17);
  }

  //<< #define FLDExchange     18
  public static Object $$$FLDExchange(mContext m$) {
    return (18);
  }

  //<< #;  SR15384 ^^^
  //<< 
  //<< #define FIELDENABLED    set YHID=0
  public static Object $$$FIELDENABLED(mContext m$) {
    mVar YHID = m$.var("YHID");
    YHID.set(0);
    return null;
  }

  //<< #define FIELDPARTIAL    set YHID=1
  public static Object $$$FIELDPARTIAL(mContext m$) {
    mVar YHID = m$.var("YHID");
    YHID.set(1);
    return null;
  }

  //<< #define FIELDDISABLED   set YHID=2
  public static Object $$$FIELDDISABLED(mContext m$) {
    mVar YHID = m$.var("YHID");
    YHID.set(2);
    return null;
  }

  //<< 
  //<< #; condition for a class field be maskable: text or date and not a key
  //<< #define IsToMask(%1,%2)  ((%1'="P")&&((%2=6)||(%2=1)))
  public static Object $$$IsToMask(mContext m$, Object ... _p) {
    mVar p$1 = m$.varRef("p$1",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar p$2 = m$.varRef("p$2",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    return (((mOp.NotEqual(p$1.get(),"P")) && mOp.Logical(((mOp.Equal(p$2.get(),6)) || (mOp.Equal(p$2.get(),1))))));
  }

}
