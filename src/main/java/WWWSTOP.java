//*****************************************************************************
//** TASC - ALPHALINC - MAC WWWSTOP
//** Innovatium Systems - Code Converter - v1.27
//** 2014-05-22 00:14:54
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

//<< WWWSTOP
public class WWWSTOP extends mClass {

  public void main() {
    _WWWSTOP();
  }

  public void _WWWSTOP() {
    //<< ;-------------------------------------------------------------------------------
    //<< ; Description of Function :
    //<< ;       STOP HTML SEITE
    //<< ;
    //<< ; Inputs :
    //<< ;
    //<< ;
    //<< ; ByRef :
    //<< ;   SET YNOFOOT=1 ==> KEINE FUSSNOTE
    //<< ;
    //<< ;
    //<< ; Returns :
    //<< ;
    //<< ;
    //<< ; History :
    //<< ; 11-Dec-2009   GRF     SR16871: get data once; macros
    //<< ; 19-Nov-2009   shobby  SR17032: Disabled 'NumberOfHits' functionality.
    //<< ; 07-May-2007   GRF     SR15511: Doco; quits
    //<< ; 03-May-2006   Steve S SR14592: End the div
    //<< ; 03.06.1998    DT      (C) BY DITMAR TYBUSSEK
    //<< ;-------------------------------------------------------------------------------
    //<< new idNewForm,objForm,objSystem,strData,strEmail,strKey
    mVar idNewForm = m$.var("idNewForm");
    mVar objForm = m$.var("objForm");
    mVar objSystem = m$.var("objSystem");
    mVar strData = m$.var("strData");
    mVar strEmail = m$.var("strEmail");
    mVar strKey = m$.var("strKey");
    m$.newVar(idNewForm,objForm,objSystem,strData,strEmail,strKey);
    //<< 
    //<< set objSystem = $get(^WWW012(0,0,1))
    objSystem.set(m$.Fnc.$get(m$.var("^WWW012",0,0,1)));
    //<< 
    //<< ; Display footer?
    //<< ;---------------------------------------
    //<< IF $GET(YFORM)="" SET YNOFOOT=1
    if (mOp.Equal(m$.Fnc.$get(m$.var("YFORM")),"")) {
      mVar YNOFOOT = m$.var("YNOFOOT");
      YNOFOOT.set(1);
    }
    //<< IF $GET(YNOFOOT)="" IF $GET(YFORM)'="" DO
    if (mOp.Equal(m$.Fnc.$get(m$.var("YNOFOOT")),"")) {
      if (mOp.NotEqual(m$.Fnc.$get(m$.var("YFORM")),"")) {
        do {
          //<< . set objForm   = $get(^WWW120(0,YFORM,1))
          objForm.set(m$.Fnc.$get(m$.var("^WWW120",0,m$.var("YFORM").get(),1)));
          //<< . SET YNOFOOT=1
          mVar YNOFOOT = m$.var("YNOFOOT");
          YNOFOOT.set(1);
          //<< . IF $$$WWW120PageEndWithDateAndTime(objForm)=$$$YES      SET YNOFOOT="" QUIT
          if (mOp.Equal(include.WWWConst.$$$WWW120PageEndWithDateAndTime(m$,objForm),include.COMSYS.$$$YES(m$))) {
            YNOFOOT.set("");
            break;
          }
          //<< . IF $$$WWW120InheritCompanyProperties(objForm)=$$$YES DO
          if (mOp.Equal(include.WWWConst.$$$WWW120InheritCompanyProperties(m$,objForm),include.COMSYS.$$$YES(m$))) {
            //<< . . IF $$$WWW012PageEndWithDateAndTime(objSystem)=$$$YES  SET YNOFOOT=""
            if (mOp.Equal(include.WWWConst.$$$WWW012PageEndWithDateAndTime(m$,objSystem),include.COMSYS.$$$YES(m$))) {
              YNOFOOT.set("");
            }
          }
        } while (false);
      }
    }
    //<< 
    //<< 
    //<< ;IF YBEDBER=1 WRITE YCR,"<!-- ************************* FORM END "_$GET(YUSER)_" (WWWSTOP) ************************* -->"
    //<< 
    //<< ; FIXME : Doesn't close HTML on early exit - is this right?
    //<< IF $GET(YUSER)'="" IF +$$$WWWUSERHTMLStarted($GET(^WWWUSER(0,YUSER,1)))=$$$NO DO  QUIT     ; *** EARLY EXIT ***
    if (mOp.NotEqual(m$.Fnc.$get(m$.var("YUSER")),"")) {
      if (mOp.Equal(mOp.Positive(include.WWWConst.$$$WWWUSERHTMLStarted(m$,m$.Fnc.$get(m$.var("^WWWUSER",0,m$.var("YUSER").get(),1)))),include.COMSYS.$$$NO(m$))) {
        //<< . SET $$$WWWUSERHTMLStarted(^WWWUSER(0,YUSER,1))         = 0   ;HTML AUS
        include.WWWConst.$$$WWWUSERHTMLStartedSet(m$,m$.var("^WWWUSER",0,m$.var("YUSER").get(),1),0);
        //<< . SET $$$WWWUSERBODYStarted(^WWWUSER(0,YUSER,1))         = 0   ;BODY AUS
        include.WWWConst.$$$WWWUSERBODYStartedSet(m$,m$.var("^WWWUSER",0,m$.var("YUSER").get(),1),0);
        //<< . SET $$$WWWUSERFormStarted(^WWWUSER(0,YUSER,1))         = 0   ;FORMULAR AUS ;form
        include.WWWConst.$$$WWWUSERFormStartedSet(m$,m$.var("^WWWUSER",0,m$.var("YUSER").get(),1),0);
        //<< . SET $$$WWWUSERFormHeaderDisplayed(^WWWUSER(0,YUSER,1)) = 0   ;KOPF AUS     ;heading
        include.WWWConst.$$$WWWUSERFormHeaderDisplayedSet(m$,m$.var("^WWWUSER",0,m$.var("YUSER").get(),1),0);
        //<< . SET $$$WWWUSERLastSave(^WWWUSER(0,YUSER,1))            = ""  ;SAVE
        include.WWWConst.$$$WWWUSERLastSaveSet(m$,m$.var("^WWWUSER",0,m$.var("YUSER").get(),1),"");
        //<< . SET YNOFOOT = 1
        mVar YNOFOOT = m$.var("YNOFOOT");
        YNOFOOT.set(1);
        return;
      }
    }
    //<< 
    //<< IF (YFIXHEADER'=1) && ($GET(YNOFOOT)="") DO
    if ((mOp.NotEqual(m$.var("YFIXHEADER").get(),1)) && (mOp.Equal(m$.Fnc.$get(m$.var("YNOFOOT")),""))) {
      //<< . NEW HELP
      mVar HELP = m$.var("HELP");
      m$.newVar(HELP);
      //<< . SET HELP=0
      HELP.set(0);
      //<< . IF $FIND(","_$TRANSLATE($$^WWWBEDBER(YBED),";",",")_",",",1,") SET HELP=1
      if (mOp.Logical(m$.Fnc.$find(mOp.Concat(mOp.Concat(",",m$.Fnc.$translate(m$.fnc$("WWWBEDBER.main",m$.var("YBED").get()),";",",")),","),",1,"))) {
        HELP.set(1);
      }
      //<< . ;WRITE "<BR>"
      //<< . WRITE "<FONT SIZE=1>"
      m$.Cmd.Write("<FONT SIZE=1>");
      //<< . WRITE "["
      m$.Cmd.Write("[");
      //<< . IF HELP=1 DO  ;FIS; HILFE FÜR ADMIN: ANZEIGE NAME
      if (mOp.Equal(HELP.get(),1)) {
        //<< . . WRITE "<A HREF=""#"""
        m$.Cmd.Write("<A HREF=\"#\"");
        //<< . . WRITE " TITLE="""_YUSER_" ("_$PIECE($GET(^WWW013(0,YBED,1)),Y,1)_")"">"
        m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(" TITLE=\"",m$.var("YUSER").get())," ("),m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW013",0,m$.var("YBED").get(),1)),m$.var("Y").get(),1)),")\">"));
      }
      //<< . ;
      //<< . WRITE YBED
      m$.Cmd.Write(m$.var("YBED").get());
      //<< . IF HELP=1 WRITE "</A>"
      if (mOp.Equal(HELP.get(),1)) {
        m$.Cmd.Write("</A>");
      }
      //<< . WRITE ", "
      m$.Cmd.Write(", ");
      //<< . IF HELP=1 DO  ;FIS; HILFE FÜR ADMIN: ANZEIGE TAGESZAHL
      if (mOp.Equal(HELP.get(),1)) {
        //<< . . WRITE "<A HREF=""#"""
        m$.Cmd.Write("<A HREF=\"#\"");
        //<< . . WRITE " TITLE="""_+$HOROLOG_""">"
        m$.Cmd.Write(mOp.Concat(mOp.Concat(" TITLE=\"",mOp.Positive(m$.Fnc.$horolog())),"\">"));
      }
      //<< . ;
      //<< . WRITE $$^WWWDATE($HOROLOG)
      m$.Cmd.Write(m$.fnc$("WWWDATE.main",m$.Fnc.$horolog()));
      //<< . IF HELP=1 WRITE "</A>"
      if (mOp.Equal(HELP.get(),1)) {
        m$.Cmd.Write("</A>");
      }
      //<< . WRITE ", "
      m$.Cmd.Write(", ");
      //<< . WRITE $$^WWWTIME($HOROLOG)
      m$.Cmd.Write(m$.fnc$("WWWTIME.main",m$.Fnc.$horolog()));
      //<< . WRITE "]["
      m$.Cmd.Write("][");
      //<< . set strEmail = $$$WWW012EMailForHelp(objSystem)
      strEmail.set(include.WWWConst.$$$WWW012EMailForHelp(m$,objSystem));
      //<< . IF strEmail'="" DO
      if (mOp.NotEqual(strEmail.get(),"")) {
        //<< . . WRITE "<A"
        m$.Cmd.Write("<A");
        //<< . . WRITE " HREF=""mailto:"
        m$.Cmd.Write(" HREF=\"mailto:");
        //<< . . write strEmail
        m$.Cmd.Write(strEmail.get());
        //<< . . write "?subject=" IF $GET(YFORM)'="" WRITE $$$WWW120FormHeaderOrImageFile(objForm)
        m$.Cmd.Write("?subject=");
        if (mOp.NotEqual(m$.Fnc.$get(m$.var("YFORM")),"")) {
          m$.Cmd.Write(include.WWWConst.$$$WWW120FormHeaderOrImageFile(m$,objForm));
        }
        //<< . . WRITE "&body=%0D%0ADate: "_$$^WWWDATE($HOROLOG)
        m$.Cmd.Write(mOp.Concat("&body=%0D%0ADate: ",m$.fnc$("WWWDATE.main",m$.Fnc.$horolog())));
        //<< . . WRITE "%0D%0ATime: "_$$^WWWTIME($HOROLOG)
        m$.Cmd.Write(mOp.Concat("%0D%0ATime: ",m$.fnc$("WWWTIME.main",m$.Fnc.$horolog())));
        //<< . . WRITE "%0D%0AMenu: "_$GET(YANZ)
        m$.Cmd.Write(mOp.Concat("%0D%0AMenu: ",m$.Fnc.$get(m$.var("YANZ"))));
        //<< . . WRITE "%0D%0AForm: "_$GET(YFORM)
        m$.Cmd.Write(mOp.Concat("%0D%0AForm: ",m$.Fnc.$get(m$.var("YFORM"))));
        //<< . . WRITE "%0D%0AYUCI: "_YUCI
        m$.Cmd.Write(mOp.Concat("%0D%0AYUCI: ",m$.var("YUCI").get()));
        //<< . . WRITE "%0D%0AYBED: "_YBED_" ("_$$$WWW013Name($get(^WWW013(YM,YBED,1)))_")"
        m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("%0D%0AYBED: ",m$.var("YBED").get())," ("),include.WWWConst.$$$WWW013Name(m$,m$.Fnc.$get(m$.var("^WWW013",m$.var("YM").get(),m$.var("YBED").get(),1)))),")"));
        //<< . . WRITE "%0D%0AYUSER: "_YUSER
        m$.Cmd.Write(mOp.Concat("%0D%0AYUSER: ",m$.var("YUSER").get()));
        //<< . . WRITE "%0D%0AYLOCATION: "_YLOCATION
        m$.Cmd.Write(mOp.Concat("%0D%0AYLOCATION: ",m$.var("YLOCATION").get()));
        //<< . . WRITE "%0D%0AYM: "_YM
        m$.Cmd.Write(mOp.Concat("%0D%0AYM: ",m$.var("YM").get()));
        //<< . . WRITE "%0D%0AYKEY: "_$GET(YKEY)
        m$.Cmd.Write(mOp.Concat("%0D%0AYKEY: ",m$.Fnc.$get(m$.var("YKEY"))));
        //<< . . WRITE "%0D%0AAlphalinc Version: "_$$GetVersion^WWWKOPF()
        m$.Cmd.Write(mOp.Concat("%0D%0AAlphalinc Version: ",m$.fnc$("WWWKOPF.GetVersion")));
        //<< . . WRITE "%0D%0ACache Version: "_$zv
        m$.Cmd.Write(mOp.Concat("%0D%0ACache Version: ",m$.Fnc.$zversion()));
        //<< . . WRITE "%0D%0AMachine: "_$zu(110)
        m$.Cmd.Write(mOp.Concat("%0D%0AMachine: ",m$.Fnc.$zutil(110)));
        //<< . . WRITE "%0D%0AInfo: "_$GET(YERROR)
        m$.Cmd.Write(mOp.Concat("%0D%0AInfo: ",m$.Fnc.$get(m$.var("YERROR"))));
        //<< . . WRITE """>"
        m$.Cmd.Write("\">");
        //<< . . write strEmail
        m$.Cmd.Write(strEmail.get());
        //<< . . WRITE "</A>"
        m$.Cmd.Write("</A>");
      }
      //<< . ;
      //<< . WRITE "]"
      m$.Cmd.Write("]");
      //<< . WRITE "</font>"
      m$.Cmd.Write("</font>");
    }
    //<< 
    //<< WRITE YCR,"</div>"
    m$.Cmd.Write(m$.var("YCR").get(),"</div>");
    //<< WRITE YCR,"</BODY></HTML>",YCR
    m$.Cmd.Write(m$.var("YCR").get(),"</BODY></HTML>",m$.var("YCR").get());
    //<< 
    //<< IF $GET(YUSER)'="" DO
    if (mOp.NotEqual(m$.Fnc.$get(m$.var("YUSER")),"")) {
      do {
        //<< . IF $GET(YFORM)'="" SET ^WWWPAGE(0,YUSER,YFORM,1) = $GET(YSEITE)_Y_$GET(YINSEITE)  ;SEITENWERTE SPEICHERN ;Save
        if (mOp.NotEqual(m$.Fnc.$get(m$.var("YFORM")),"")) {
          m$.var("^WWWPAGE",0,m$.var("YUSER").get(),m$.var("YFORM").get(),1).set(mOp.Concat(mOp.Concat(m$.Fnc.$get(m$.var("YSEITE")),m$.var("Y").get()),m$.Fnc.$get(m$.var("YINSEITE"))));
        }
        //<< . QUIT:'$DATA(^WWWUSER(0,YUSER))
        if (mOp.Not(m$.Fnc.$data(m$.var("^WWWUSER",0,m$.var("YUSER").get())))) {
          break;
        }
        //<< . SET $PIECE(^WWWUSER(0,YUSER,1),Y,5)  = 0    ;HTML AUS     ; $$$WWWUSERHTMLStarted
        m$.pieceVar(m$.var("^WWWUSER",0,m$.var("YUSER").get(),1),m$.var("Y").get(),5).set(0);
        //<< . SET $PIECE(^WWWUSER(0,YUSER,1),Y,6)  = 0    ;BODY AUS
        m$.pieceVar(m$.var("^WWWUSER",0,m$.var("YUSER").get(),1),m$.var("Y").get(),6).set(0);
        //<< . SET $PIECE(^WWWUSER(0,YUSER,1),Y,9)  = 0    ;FORMULAR AUS  ;form
        m$.pieceVar(m$.var("^WWWUSER",0,m$.var("YUSER").get(),1),m$.var("Y").get(),9).set(0);
        //<< . SET $PIECE(^WWWUSER(0,YUSER,1),Y,10) = 0    ;KOPF AUS      ;heading
        m$.pieceVar(m$.var("^WWWUSER",0,m$.var("YUSER").get(),1),m$.var("Y").get(),10).set(0);
        //<< . SET $PIECE(^WWWUSER(0,YUSER,1),Y,22) = ""   ;SAVE
        m$.pieceVar(m$.var("^WWWUSER",0,m$.var("YUSER").get(),1),m$.var("Y").get(),22).set("");
        //<< . LOCK +^WWWSOR(YUSER,"PAGE"):2               ;CHECK AUF SEITE;TYBD;19,12,2003
        m$.Cmd.LockInc(m$.var("^WWWSOR",m$.var("YUSER").get(),"PAGE"),2);
        //<< . LOCK -^WWWSOR(YUSER,"PAGE")
        m$.Cmd.Unlock(m$.var("^WWWSOR",m$.var("YUSER").get(),"PAGE"));
        //<< . KILL ^WWWSOR(YUSER)
        m$.var("^WWWSOR",m$.var("YUSER").get()).kill();
      } while (false);
    }
    //<< 
    //<< DO CLOSE^WWWSTART
    m$.Cmd.Do("WWWSTART.CLOSE");
    //<< 
    //<< QUIT
    return;
  }

//<< 
//<< 
}
