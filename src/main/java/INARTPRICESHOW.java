//*****************************************************************************
//** TASC - ALPHALINC - MAC INARTPRICESHOW
//** Innovatium Systems - Code Converter - v1.30
//** 2014-06-27 19:47:08
//*****************************************************************************

import mLibrary.*;


//<< INARTPRICESHOW(LINK)
public class INARTPRICESHOW extends mClass {

  public Object main(Object ... _p) {
    mVar LINK = m$.newVarRef("LINK",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return _INARTPRICESHOW(LINK);
  }

  public Object _INARTPRICESHOW(Object ... _p) {
    mVar LINK = m$.newVarRef("LINK",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ;| Description of Function :
    //<< ;   SHOW LOCATION BASE PRICES
    //<< ;
    //<< ; Inputs :
    //<< ;
    //<< ;
    //<< ; ByRef :
    //<< ;
    //<< ;
    //<< ; Returns :
    //<< ;
    //<< ;
    //<< ; History :
    //<< ; 25-Aug-2009   PPP     SR16842: Updated to new PRices Form ^INItemPrice
    //<< ; 11-Oct-2006   JW      SR15104: KEY was newed instead of YKEY. Rewrote.
    //<< ; 11.02.2004    BEC
    //<< ;-------------------------------------------------------------------------------
    //<< NEW PRICELOC,LOCATION
    mVar PRICELOC = m$.var("PRICELOC");
    mVar LOCATION = m$.var("LOCATION");
    m$.newVar(PRICELOC,LOCATION);
    //<< 
    //<< SET LINK=$GET(LINK)      ;SHOW LINK
    LINK.set(m$.Fnc.$get(LINK));
    //<< SET YKEY=$GET(YKEY)
    mVar YKEY = m$.var("YKEY");
    YKEY.set(m$.Fnc.$get(m$.var("YKEY")));
    //<< SET YLOCATION=$GET(YLOCATION)
    mVar YLOCATION = m$.var("YLOCATION");
    YLOCATION.set(m$.Fnc.$get(m$.var("YLOCATION")));
    //<< 
    //<< /*
    //<< SET LOCATION=$PIECE($$^INVALIDLOCATION(YKEY,YLOCATION),Y,1)
    //<< IF LOCATION="" SET LOCATION=$GET(YLOCATION)
    //<< SET PRICELOC=""
    //<< IF YLOCATION'="" IF YKEY'="" DO
    //<< . IF $PIECE($$^INSALESPRICE(YKEY,1,YLOCATION,,,,,,1),Y,3)=1 SET PRICELOC=1
    //<< . IF $DATA(^INARTPREISBE1(YM,YKEY,YLOCATION))               SET PRICELOC=1
    //<< */
    //<< set PRICELOC = 0
    PRICELOC.set(0);
    //<< set rs = ##class(%Library.ResultSet).%New()
    mVar rs = m$.var("rs");
    rs.set(m$.fnc$("$Library.ResultSet.$New"));
    //<< if rs.Prepare("SELECT %ID FROM INItemPrice WHERE ItemNo = ? AND Location = ?") {
    if (mOp.Logical(m$.fnc$(rs.getORef(),"Prepare","SELECT %ID FROM INItemPrice WHERE ItemNo = ? AND Location = ?"))) {
      //<< if rs.Execute(YKEY,YLOCATION) {
      if (mOp.Logical(m$.fnc$(rs.getORef(),"Execute",YKEY.get(),YLOCATION.get()))) {
        //<< if rs.Next(.sc) {
        if (mOp.Logical(m$.fnc$(rs.getORef(),"Next",m$.var("sc")))) {
          //<< set PRICELOC = 1
          PRICELOC.set(1);
        }
      }
    }
    //<< }
    //<< }
    //<< }
    //<< do rs.%Close()
    m$.Cmd.Do(rs.getORef(),"$Close");
    //<< 
    //<< WRITE "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
    m$.Cmd.Write("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
    //<< 
    //<< 
    //<< // SR15104: vvvvvvvvvvvvvvvvvvvv
    //<< 
    //<< WRITE "<A TITLE="""_$$^WWWTEXT(33758)_""""   ;"Anzeigen Betriebsabhängige Preise "
    m$.Cmd.Write(mOp.Concat(mOp.Concat("<A TITLE=\"",m$.fnc$("WWWTEXT.main",33758)),"\""));
    //<< //WRITE " HREF="""_YAKTION_"EP=WWWFORM&YFORM=INARTPREISBE"
    //<< WRITE " HREF="""_YAKTION_"EP=WWWFORM&YFORM=INItemPrice"
    m$.Cmd.Write(mOp.Concat(mOp.Concat(" HREF=\"",m$.var("YAKTION").get()),"EP=WWWFORM&YFORM=INItemPrice"));
    //<< set YPARA = $get(YKEY)_",INART"
    mVar YPARA = m$.var("YPARA");
    YPARA.set(mOp.Concat(m$.Fnc.$get(YKEY),",INART"));
    //<< do Link("","INART,")
    m$.Cmd.Do("Link","","INART,");
    //<< WRITE """>"
    m$.Cmd.Write("\">");
    //<< 
    //<< IF PRICELOC=1 {
    if (mOp.Equal(PRICELOC.get(),1)) {
      //<< WRITE "<Font color="_YRED_">"
      m$.Cmd.Write(mOp.Concat(mOp.Concat("<Font color=",m$.var("YRED").get()),">"));
      //<< WRITE $$^WWWTEXT(33756)  ;Location Dependent Prices Do Exist
      m$.Cmd.Write(m$.fnc$("WWWTEXT.main",33756));
      //<< WRITE "</FONT>"
      m$.Cmd.Write("</FONT>");
    }
    //<< } else {
    else {
      //<< WRITE $$^WWWTEXT(33757)  ;No Location Specific Prices
      m$.Cmd.Write(m$.fnc$("WWWTEXT.main",33757));
    }
    //<< }
    //<< WRITE "</a>"
    m$.Cmd.Write("</a>");
    //<< 
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< Link(YKEY,YBACK)
  public Object Link(Object ... _p) {
    mVar YKEY = m$.newVarRef("YKEY",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar YBACK = m$.newVarRef("YBACK",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Wrapper to scope YKEY, YBACK
    //<< ;
    //<< ; Params:   YKEY,YBACK - important that they are not renamed !
    //<< ;
    //<< ; ByRefs:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 19-Dec-2006   JW      SR15322: Moved from WWWCGI
    //<< ; 09-Oct-2006   JW      SR15104: Created
    //<< ;-------------------------------------------------------------------------------
    //<< write $$WWWCGI2^WWWCGI()
    m$.Cmd.Write(m$.fnc$("WWWCGI.WWWCGI2"));
    //<< quit
    return null;
  }

//<< 
}
