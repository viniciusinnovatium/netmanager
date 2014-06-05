//*****************************************************************************
//** TASC - ALPHALINC - MAC WWW004
//** Innovatium Systems - Code Converter - v1.29
//** 2014-06-03 20:54:13
//*****************************************************************************

import mLibrary.*;

//<< 
//<< #include WWWConst
import include.WWWConst;
import include.COMSYS;

//<< WWW004
public class WWW004 extends mClass {

  public void main() {
    _WWW004();
  }

  public void _WWW004() {
    //<< 
    //<< ;-------------------------------------------------------------------------------
    //<< ; Description of Function :
    //<< ;   KONTROLLE MENUSPRACHENTEXTE
    //<< ;   Remove Language Text Menu sub-class entries if menu entry no longer exists
    //<< ;
    //<< ; ByRef :
    //<< ;   KEY     array - Tests element 2; not otherwise used
    //<< ;
    //<< ; Returns :
    //<< ;   WWWSOR entry : error text (ByRef)
    //<< ;
    //<< ; History :
    //<< ;
    //<< ; 02.01.1998    DT      Created
    //<< ;-------------------------------------------------------------------------------
    //<< NEW YY
    mVar YY = m$.var("YY");
    m$.newVar(YY);
    //<< 
    //<< IF $DATA(KEY(2)) IF '$FIND(KEY(2),".") SET ^WWWSOR(YUSER,1)=$$^WWWTEXT(330)  ; "Point (.) Is Missing In Menu Item!"
    if (mOp.Logical(m$.Fnc.$data(m$.var("KEY").var(2)))) {
      if (mOp.Not(m$.Fnc.$find(m$.var("KEY").var(2).get(),"."))) {
        m$.var("^WWWSOR",m$.var("YUSER").get(),1).set(m$.fnc$("WWWTEXT.main",330));
      }
    }
    //<< 
    //<< SET YY=""
    YY.set("");
    //<< FOR  SET YY=$ORDER(^WWW0041(0,YY)) QUIT:YY=""  DO                 ; Application Name
    for (;true;) {
      YY.set(m$.Fnc.$order(m$.var("^WWW0041",0,YY.get())));
      if (mOp.Equal(YY.get(),"")) {
        break;
      }
      //<< . SET YY(1)=""
      YY.var(1).set("");
      //<< . FOR  SET YY(1)=$ORDER(^WWW0041(0,YY,YY(1))) QUIT:YY(1)=""  DO   ; Menu Item No
      for (;true;) {
        YY.var(1).set(m$.Fnc.$order(m$.var("^WWW0041",0,YY.get(),YY.var(1).get())));
        if (mOp.Equal(YY.var(1).get(),"")) {
          break;
        }
        //<< . . IF '$DATA(^WWW004(0,YY,YY(1))) KILL ^WWW0041(0,YY,YY(1))
        if (mOp.Not(m$.Fnc.$data(m$.var("^WWW004",0,YY.get(),YY.var(1).get())))) {
          m$.var("^WWW0041",0,YY.get(),YY.var(1).get()).kill();
        }
      }
    }
    //<< QUIT
    return;
  }

  //<< 
  //<< 
  //<< Get(pidApplicn,pidSection)
  public Object Get(Object ... _p) {
    mVar pidApplicn = m$.newVarRef("pidApplicn",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pidSection = m$.newVarRef("pidSection",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Returns a Menu record with translations done
    //<< ;
    //<< ; Called By : OnAfterDataFields^WWWMenuOverview, GetMenu^WWWMenuOverview
    //<< ;
    //<< ; ByRef: YBED
    //<< ;
    //<< ; Returns : Language Customised Menu entry
    //<< ;
    //<< ; History:
    //<< ; 27-Apr-2010   GRF     SR16402: use idLang; menu globals ALWAYS 0 not YM
    //<< ; 28-Feb-2009   HQN     SR16402: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new idLang,objMenu
    mVar idLang = m$.var("idLang");
    mVar objMenu = m$.var("objMenu");
    m$.newVar(idLang,objMenu);
    //<< 
    //<< set objMenu = $get(^WWW004(0,pidApplicn,pidSection,1))
    objMenu.set(m$.Fnc.$get(m$.var("^WWW004",0,pidApplicn.get(),pidSection.get(),1)));
    //<< set idLang  = $$^WWWLANGU(YBED)
    idLang.set(m$.fnc$("WWWLANGU.main",m$.var("YBED").get()));
    //<< if $data(YBED) && $data(^WWW0041(0,pidApplicn,pidSection,idLang)) {
    if (mOp.Logical(m$.Fnc.$data(m$.var("YBED"))) && mOp.Logical(m$.Fnc.$data(m$.var("^WWW0041",0,pidApplicn.get(),pidSection.get(),idLang.get())))) {
      //<< set $$$WWW004MenuDescription(objMenu) = $get(^WWW0041(0,pidApplicn,pidSection,idLang,1))
      include.WWWConst.$$$WWW004MenuDescriptionSet(m$,objMenu,m$.Fnc.$get(m$.var("^WWW0041",0,pidApplicn.get(),pidSection.get(),idLang.get(),1)));
    }
    //<< }
    //<< quit objMenu
    return objMenu.get();
  }

  //<< 
  //<< OnBeforeDataAccess(YKEY,YFELD)
  public Object OnBeforeDataAccess(Object ... _p) {
    mVar YKEY = m$.newVarRef("YKEY",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar YFELD = m$.newVarRef("YFELD",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Filters the list of mega menus a user can select from
    //<< ;
    //<< ; Returns : Language Customised Menu entry
    //<< ;
    //<< ; History:
    //<< ; 04-Oct-2013   shobby      CORE-280: quit with 1 if form condition not found
    //<< ; 20-Jun-2012   shobby      SR17998: Created
    //<< ;-------------------------------------------------------------------------------
    //<< if YFORM="WWW013" quit $piece(YKEY,".",2)=""
    if (mOp.Equal(m$.var("YFORM").get(),"WWW013")) {
      return mOp.Equal(m$.Fnc.$piece(YKEY.get(),".",2),"");
    }
    //<< quit 1
    return 1;
  }

//<< 
//<< 
}
