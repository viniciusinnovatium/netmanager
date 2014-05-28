//*****************************************************************************
//** TASC - ALPHALINC - MAC WWWBUTTON
//** Innovatium Systems - Code Converter - v1.28
//** 2014-05-26 21:13:12
//*****************************************************************************

import mLibrary.*;

//<< #include WWWConst
import include.WWWConst;
import include.COMSYS;
//<< #include COMConst
import include.COMConst;

//<< WWWBUTTON(YTEXT,YLINK,YTIP,YONCLICK)
public class WWWBUTTON extends mClass {

  public Object main(Object ... _p) {
    mVar YTEXT = m$.newVarRef("YTEXT",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar YLINK = m$.newVarRef("YLINK",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar YTIP = m$.newVarRef("YTIP",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    mVar YONCLICK = m$.newVarRef("YONCLICK",(((_p!=null)&&(_p.length>=4))?_p[3]:null));
    return _WWWBUTTON(YTEXT,YLINK,YTIP,YONCLICK);
  }

  public Object _WWWBUTTON(Object ... _p) {
    mVar YTEXT = m$.newVarRef("YTEXT",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar YLINK = m$.newVarRef("YLINK",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar YTIP = m$.newVarRef("YTIP",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    mVar YONCLICK = m$.newVarRef("YONCLICK",(((_p!=null)&&(_p.length>=4))?_p[3]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Description of Function :
    //<< ;       TEXT-BUTTON
    //<< ;
    //<< ;   BEISPIEL FÜR 1:  DO START^WWWBUTTON(Width,blnFixedPosn)
    //<< ;                    DO BUTTON^WWWBUTTON(TEXT,LINK,TOOLTIP)
    //<< ;             **     DO ZW^WWWBUTTON
    //<< ;             **     DO BUTTON^WWWBUTTON(TEXT,LINK,TOOLTIP)
    //<< ;                    DO END^WWWNBUTTON
    //<< ;   ** Repeat pairs for more buttons
    //<< ;
    //<< ; Inputs :
    //<< ;   YOPT   ? :  0=STAND ALONE BUTTON
    //<< ;               1=PART OF BUTTON LINE
    //<< ;   YTEXT    : BUTTON-TEXT (IMG-VALUE)
    //<< ;   YLINK    : LINK (EXECUTE ONCLICK)
    //<< ;
    //<< ;   YTIP     : Tool tip
    //<< ;   YONCLICK : ZUSÄTZLICHER EXECUTE ONCLICK
    //<< ;
    //<< ; ByRef :
    //<< ;   Y
    //<< ;
    //<< ; Returns :
    //<< ;
    //<< ;
    //<< ; History :
    //<< ; 20-Jun-2007   GRF     SR15549: Doco; braces; expand commands; macros
    //<< ; 10.04.2003    FIS     TEXT-BUTTON
    //<< ;-------------------------------------------------------------------------------
    //<< ;DO START(0)
    //<< do START(100)   ; DWR test
    m$.Cmd.Do("START",100);
    //<< do BUTTON($get(YTEXT),$get(YLINK),$get(YTIP),$get(YONCLICK))
    m$.Cmd.Do("BUTTON",m$.Fnc.$get(YTEXT),m$.Fnc.$get(YLINK),m$.Fnc.$get(YTIP),m$.Fnc.$get(YONCLICK));
    //<< do END
    m$.Cmd.Do("END");
    //<< quit
    return null;
  }

  //<< 
  //<< START(YWID,YFIX) ;STARTEN BUTTON-LEISTE / START BUTTON BAR
  public Object START(Object ... _p) {
    mVar YWID = m$.newVarRef("YWID",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar YFIX = m$.newVarRef("YFIX",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< new DESIGN
    mVar DESIGN = m$.var("DESIGN");
    m$.newVar(DESIGN);
    //<< 
    //<< set DESIGN="STANDARD"
    DESIGN.set("STANDARD");
    //<< set YWID=+$get(YWID)
    YWID.set(mOp.Positive(m$.Fnc.$get(YWID)));
    //<< write YCR,"<DIV STYLE="_""""
    m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat("<DIV STYLE=","\""));
    //<< write " height:22px;"
    m$.Cmd.Write(" height:22px;");
    //<< write " padding:0px;"
    m$.Cmd.Write(" padding:0px;");
    //<< if +$get(YFIX)=1 write " position:absolute;"
    if (mOp.Equal(mOp.Positive(m$.Fnc.$get(YFIX)),1)) {
      m$.Cmd.Write(" position:absolute;");
    }
    //<< 
    //<< if DESIGN="STANDARD" {
    if (mOp.Equal(DESIGN.get(),"STANDARD")) {
      //<< write " background-color:none;"
      m$.Cmd.Write(" background-color:none;");
      //<< write " border:none;"
      m$.Cmd.Write(" border:none;");
    }
    //<< 
    //<< } elseif DESIGN="EFFECT" {                            ; Never executed
    else if (mOp.Equal(DESIGN.get(),"EFFECT")) {
      //<< write " background-color:"_YSILVER_";"
      m$.Cmd.Write(mOp.Concat(mOp.Concat(" background-color:",m$.var("YSILVER").get()),";"));
      //<< write " border:1px outset;"
      m$.Cmd.Write(" border:1px outset;");
      //<< write " border-bottom-color:ButtonShadow;"
      m$.Cmd.Write(" border-bottom-color:ButtonShadow;");
      //<< write " border-right-color:ButtonShadow;"
      m$.Cmd.Write(" border-right-color:ButtonShadow;");
      //<< write " border-top-color:ButtonHighlight;"
      m$.Cmd.Write(" border-top-color:ButtonHighlight;");
      //<< write " border-left-color:ButtonHighlight;"
      m$.Cmd.Write(" border-left-color:ButtonHighlight;");
    }
    //<< }
    //<< 
    //<< if YWID=100 {                       ;100% OF FRAME
    if (mOp.Equal(YWID.get(),100)) {
      //<< write " width:100%;"
      m$.Cmd.Write(" width:100%;");
    }
    //<< 
    //<< } elseif YWID=0 {                   ; DEPENDING ON TEXT LENGTH
    else if (mOp.Equal(YWID.get(),0)) {
      //<< set YWID = 50
      YWID.set(50);
      //<< if $get(YTEXT)'="" {
      if (mOp.NotEqual(m$.Fnc.$get(m$.var("YTEXT")),"")) {
        //<< if $length(YTEXT)<2  set YWID = 24
        if (mOp.Less(m$.Fnc.$length(m$.var("YTEXT").get()),2)) {
          YWID.set(24);
        }
        //<< if $length(YTEXT)>10 set YWID = 100
        if (mOp.Greater(m$.Fnc.$length(m$.var("YTEXT").get()),10)) {
          YWID.set(100);
        }
      }
      //<< }
      //<< write " width:"_YWID_"px;"
      m$.Cmd.Write(mOp.Concat(mOp.Concat(" width:",YWID.get()),"px;"));
    }
    //<< } else {
    else {
      //<< write " width:"_YWID_"px;"      ;individual
      m$.Cmd.Write(mOp.Concat(mOp.Concat(" width:",YWID.get()),"px;"));
    }
    //<< }
    //<< write """"_">"
    m$.Cmd.Write(mOp.Concat("\"",">"));
    //<< write YCR,"<table border=0 cellspacing=0 cellpadding=0><tr>"
    m$.Cmd.Write(m$.var("YCR").get(),"<table border=0 cellspacing=0 cellpadding=0><tr>");
    //<< if DESIGN="EFFECT" write YCR,"<td><IMG SRC="_""""_YGIF_"delimiter1.gif"_""""_"></td>"
    if (mOp.Equal(DESIGN.get(),"EFFECT")) {
      m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<td><IMG SRC=","\""),m$.var("YGIF").get()),"delimiter1.gif"),"\""),"></td>"));
    }
    //<< write YCR
    m$.Cmd.Write(m$.var("YCR").get());
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< BUTTON(YTEXT,YLINK,YTIP,YONCLICK)
  public Object BUTTON(Object ... _p) {
    mVar YTEXT = m$.newVarRef("YTEXT",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar YLINK = m$.newVarRef("YLINK",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar YTIP = m$.newVarRef("YTIP",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    mVar YONCLICK = m$.newVarRef("YONCLICK",(((_p!=null)&&(_p.length>=4))?_p[3]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ;   CREATE BUTTON
    //<< ;
    //<< ; History:
    //<< ; 05-Jul-2007   RPW     SR15549: Changed YCOLOR to strColour
    //<< ;-------------------------------------------------------------------------------
    //<< new YI,YWID,DESIGN,strColour
    mVar YI = m$.var("YI");
    mVar YWID = m$.var("YWID");
    mVar DESIGN = m$.var("DESIGN");
    mVar strColour = m$.var("strColour");
    m$.newVar(YI,YWID,DESIGN,strColour);
    //<< 
    //<< set DESIGN = "STANDARD"
    DESIGN.set("STANDARD");
    //<< set YWID   = 50
    YWID.set(50);
    //<< if $get(YTEXT)'="" {
    if (mOp.NotEqual(m$.Fnc.$get(YTEXT),"")) {
      //<< if $length(YTEXT)<2  set YWID = 24
      if (mOp.Less(m$.Fnc.$length(YTEXT.get()),2)) {
        YWID.set(24);
      }
      //<< if $length(YTEXT)>10 set YWID = 100
      if (mOp.Greater(m$.Fnc.$length(YTEXT.get()),10)) {
        YWID.set(100);
      }
    }
    //<< }
    //<< write YCR,"<td nowrap>"
    m$.Cmd.Write(m$.var("YCR").get(),"<td nowrap>");
    //<< if $get(YLINK)'="" {
    if (mOp.NotEqual(m$.Fnc.$get(YLINK),"")) {
      //<< set strColour=$$$WWW012FontColor($get(^WWW012(0,YM,1)))     ; SR15549
      strColour.set(include.WWWConst.$$$WWW012FontColor(m$,m$.Fnc.$get(m$.var("^WWW012",0,m$.var("YM").get(),1))));
      //<< if strColour="" {
      if (mOp.Equal(strColour.get(),"")) {
        //<< set strColour="black"
        strColour.set("black");
      }
      //<< } else {
      else {
        //<< set strColour=$piece($get(^WWW100(0,"FARBE",SPRACHE,strColour,1)),Y,1)
        strColour.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW100",0,"FARBE",m$.var("SPRACHE").get(),strColour.get(),1)),m$.var("Y").get(),1));
      }
      //<< }
      //<< write "<a href="_""""_YLINK_""""
      m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat("<a href=","\""),YLINK.get()),"\""));
      //<< write " style="_""""_"text-decoration:none;"
      m$.Cmd.Write(mOp.Concat(mOp.Concat(" style=","\""),"text-decoration:none;"));
      //<< write " color:"_strColour_";"_""""
      m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(" color:",strColour.get()),";"),"\""));
      //<< write ">"
      m$.Cmd.Write(">");
    }
    //<< }
    //<< 
    //<< write YCR,"<DIV STYLE="_""""
    m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat("<DIV STYLE=","\""));
    //<< write " background-color:buttonface;"
    m$.Cmd.Write(" background-color:buttonface;");
    //<< write " height:22px;"
    m$.Cmd.Write(" height:22px;");
    //<< write " width:"_YWID_"px;"
    m$.Cmd.Write(mOp.Concat(mOp.Concat(" width:",YWID.get()),"px;"));
    //<< write " cursor:pointer;"
    m$.Cmd.Write(" cursor:pointer;");
    //<< write " text-align:center;"
    m$.Cmd.Write(" text-align:center;");
    //<< write " text-decoration:none;"
    m$.Cmd.Write(" text-decoration:none;");
    //<< write " padding:2px;"
    m$.Cmd.Write(" padding:2px;");
    //<< 
    //<< if DESIGN="STANDARD" {
    if (mOp.Equal(DESIGN.get(),"STANDARD")) {
      //<< write " border:2px outset;"
      m$.Cmd.Write(" border:2px outset;");
    }
    //<< ;   write " border:2px solid;"
    //<< ;   write " border-bottom-color:ButtonShadow;"
    //<< ;   write " border-right-color:ButtonShadow;"
    //<< ;   write " border-top-color:ButtonHighlight;"
    //<< ;   write " border-left-color:ButtonHighlight;"
    //<< 
    //<< } elseif DESIGN="EFFECT" {                            ; Never executed
    else if (mOp.Equal(DESIGN.get(),"EFFECT")) {
      //<< write " border:none;"
      m$.Cmd.Write(" border:none;");
      //<< write " padding:2px;"
      m$.Cmd.Write(" padding:2px;");
    }
    //<< }
    //<< write """"
    m$.Cmd.Write("\"");
    //<< 
    //<< if DESIGN="EFFECT" {                                  ; Never executed
    if (mOp.Equal(DESIGN.get(),"EFFECT")) {
      //<< write YCR," onMouseOver='"
      m$.Cmd.Write(m$.var("YCR").get()," onMouseOver='");
      //<< write " this.style.border="_""""_"2px outset"_""""_";"
      m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(" this.style.border=","\""),"2px outset"),"\""),";"));
      //<< write " this.style.padding="_""""_"1px"_""""_";"
      m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(" this.style.padding=","\""),"1px"),"\""),";"));
      //<< write " '"
      m$.Cmd.Write(" '");
      //<< write YCR," onMouseOut='"
      m$.Cmd.Write(m$.var("YCR").get()," onMouseOut='");
      //<< write " this.style.border="_""""_"none"_""""_";"
      m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(" this.style.border=","\""),"none"),"\""),";"));
      //<< write " this.style.padding="_""""_"3px"_""""_";"
      m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(" this.style.padding=","\""),"3px"),"\""),";"));
      //<< write " '"
      m$.Cmd.Write(" '");
    }
    //<< }
    //<< write YCR," onClick='"
    m$.Cmd.Write(m$.var("YCR").get()," onClick='");
    //<< 
    //<< write " this.style.border="_""""_"2px inset"_""""_";"
    m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(" this.style.border=","\""),"2px inset"),"\""),";"));
    //<< write " this.style.paddingTop="_""""_"2px"_""""_";"
    m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(" this.style.paddingTop=","\""),"2px"),"\""),";"));
    //<< write " this.style.paddingLeft="_""""_"2px"_""""_";"
    m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(" this.style.paddingLeft=","\""),"2px"),"\""),";"));
    //<< write " this.style.paddingRight="_""""_"0px"_""""_";"
    m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(" this.style.paddingRight=","\""),"0px"),"\""),";"));
    //<< write " this.style.paddingBottom="_""""_"0px"_""""_";"
    m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(" this.style.paddingBottom=","\""),"0px"),"\""),";"));
    //<< 
    //<< ;IF $G(YONCLICK)'="" WRITE " "_$TR(YONCLICK,"'","""")
    //<< ;IF $G(YLINK)'="" DO
    //<< ;. IF $F(YLINK,"'")  FOR YI=1:1  QUIT:$P(YLINK,"'",YI,999)=""   SET:$E($RE($P(YLINK,"'",YI)))'="\" $P(YLINK,"'",YI)=$P(YLINK,"'",YI)_"\"
    //<< ;. IF $F(YLINK,"""") FOR YI=1:1  QUIT:$P(YLINK,"""",YI,999)=""  SET:$E($RE($P(YLINK,"""",YI)))'="\" $P(YLINK,"""",YI)=$P(YLINK,"""",YI)_"\"
    //<< ;. WRITE " window.location="_""""_YLINK_""""_";"
    //<< 
    //<< write " '"
    m$.Cmd.Write(" '");
    //<< if $get(YTIP)'="" write YCR," title="_""""_YTIP_""""
    if (mOp.NotEqual(m$.Fnc.$get(YTIP),"")) {
      m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat(mOp.Concat(" title=","\""),YTIP.get()),"\""));
    }
    //<< write YCR,">"
    m$.Cmd.Write(m$.var("YCR").get(),">");
    //<< write YCR
    m$.Cmd.Write(m$.var("YCR").get());
    //<< if $get(YTEXT)'="" {
    if (mOp.NotEqual(m$.Fnc.$get(YTEXT),"")) {
      //<< if $length(YTEXT)<2 {
      if (mOp.Less(m$.Fnc.$length(YTEXT.get()),2)) {
        //<< write "<font size=2><b>"
        m$.Cmd.Write("<font size=2><b>");
      }
      //<< } else {
      else {
        //<< write "<font style="_""""_"font-size:11px;"_""""_">"
        m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<font style=","\""),"font-size:11px;"),"\""),">"));
      }
    }
    //<< }
    //<< }
    //<< write $get(YTEXT)
    m$.Cmd.Write(m$.Fnc.$get(YTEXT));
    //<< if $get(YTEXT)'="" write "</font>"              ; SR15549 only if open <font>   FIXME : <GRF> close <b>?
    if (mOp.NotEqual(m$.Fnc.$get(YTEXT),"")) {
      m$.Cmd.Write("</font>");
    }
    //<< write YCR,"</DIV>"
    m$.Cmd.Write(m$.var("YCR").get(),"</DIV>");
    //<< if $get(YLINK)'="" write YCR,"</A>"
    if (mOp.NotEqual(m$.Fnc.$get(YLINK),"")) {
      m$.Cmd.Write(m$.var("YCR").get(),"</A>");
    }
    //<< write YCR,"</td>"
    m$.Cmd.Write(m$.var("YCR").get(),"</td>");
    //<< quit
    return null;
  }

  //<< 
  //<< ZW ;ZWISCHEN 2 BUTTONS ;between t buttons
  public void ZW() {
    //<< write YCR,"<td>&nbsp;</td>",YCR
    m$.Cmd.Write(m$.var("YCR").get(),"<td>&nbsp;</td>",m$.var("YCR").get());
    //<< quit
    return;
  }

  //<< 
  //<< END ;END OF BAR
  public void END() {
    //<< new DESIGN
    mVar DESIGN = m$.var("DESIGN");
    m$.newVar(DESIGN);
    //<< 
    //<< set DESIGN="STANDARD"
    DESIGN.set("STANDARD");
    //<< if DESIGN="EFFECT" write YCR,"<td><IMG SRC="_""""_YGIF_"delimiter.gif"_""""_"></td>"    ; Never executed
    if (mOp.Equal(DESIGN.get(),"EFFECT")) {
      m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<td><IMG SRC=","\""),m$.var("YGIF").get()),"delimiter.gif"),"\""),"></td>"));
    }
    //<< write YCR,"</tr></table></DIV>",YCR
    m$.Cmd.Write(m$.var("YCR").get(),"</tr></table></DIV>",m$.var("YCR").get());
    //<< quit
    return;
  }

  //<< 
  //<< CreateOnClick(pstrObject,pstrImage="",pstrTitle="",pstrId="",plstCode1="",plstCode2="",pstrLinkType="")
  public Object CreateOnClick(Object ... _p) {
    mVar pstrObject = m$.newVarRef("pstrObject",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pstrImage = m$.newVarRef("pstrImage",(((_p!=null)&&(_p.length>=2))?_p[1]:null),"");
    mVar pstrTitle = m$.newVarRef("pstrTitle",(((_p!=null)&&(_p.length>=3))?_p[2]:null),"");
    mVar pstrId = m$.newVarRef("pstrId",(((_p!=null)&&(_p.length>=4))?_p[3]:null),"");
    mVar plstCode1 = m$.newVarRef("plstCode1",(((_p!=null)&&(_p.length>=5))?_p[4]:null),"");
    mVar plstCode2 = m$.newVarRef("plstCode2",(((_p!=null)&&(_p.length>=6))?_p[5]:null),"");
    mVar pstrLinkType = m$.newVarRef("pstrLinkType",(((_p!=null)&&(_p.length>=7))?_p[6]:null),"");
    //<< ;-------------------------------------------------------------------------------
    //<< ; The code that creates the button.
    //<< ;
    //<< ; Parameters:
    //<< ;   pstrObject:     The field on the screen that the button is attached to.
    //<< ;   pstrImage:      The image on the button.  Note each image should have an associated disabled image.
    //<< ;   pstrTitle:      The tooltip on the button.
    //<< ;   plstCode1:      The code that runs when the button is clicked.
    //<< ;   plstCode2:      The code that runs after the popup screen is closed.
    //<< ;   pstrLinkType:   Whether it is a 'class' or a 'HREF'.  It must be one of these.
    //<< ;
    //<< ; Returns
    //<< ;   The javascript to be written to the screen
    //<< ;
    //<< ; History:
    //<< ; 05-Jul-2007   shobby  SRBR014409: Rename pstrCode* to plstCode@
    //<< ; 05-Jul-2007   shobby  SRBR014409: Don't return anything if pstrLinkType is not
    //<< ;                           one of the two allowed conditions.
    //<< ; 04-Jul-2007   RPW     SRBR014409: Correct variable names, idx is a prefix not
    //<< ;                           a variable name result!=undefined can result in an
    //<< ;                           error, it should be result!==undefined
    //<< ; 26-Jun-2007   shobby  SRBR014409: Use standard routine to find disabled
    //<< ;                           equivalent of known images
    //<< ; 08-Jun-2007   shobby  SRBR014409: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new strJS,loop
    mVar strJS = m$.var("strJS");
    mVar loop = m$.var("loop");
    m$.newVar(strJS,loop);
    //<< 
    //<< set strJS = ""
    strJS.set("");
    //<< if pstrLinkType="class" {
    if (mOp.Equal(pstrLinkType.get(),"class")) {
      //<< set strJS = "<A class=link "
      strJS.set("<A class=link ");
    }
    //<< } elseif pstrLinkType="HREF" {
    else if (mOp.Equal(pstrLinkType.get(),"HREF")) {
      //<< set strJS = "HREF=""javascript:"
      strJS.set("HREF=\"javascript:");
    }
    //<< }
    //<< if strJS'="" {
    if (mOp.NotEqual(strJS.get(),"")) {
      //<< set strJS = strJS_"onclick="""
      strJS.set(mOp.Concat(strJS.get(),"onclick=\""));
      //<< set strJS = strJS_"  var result='';"
      strJS.set(mOp.Concat(strJS.get(),"  var result='';"));
      //<< set strJS = strJS_"  if ("_pstrObject_".readOnly != true) {"
      strJS.set(mOp.Concat(mOp.Concat(mOp.Concat(strJS.get(),"  if ("),pstrObject.get()),".readOnly != true) {"));
      //<< for loop=1:1:$listlength(plstCode1) {
      for (loop.set(1);(mOp.LessOrEqual(loop.get(),m$.Fnc.$listlength(plstCode1.get())));loop.set(mOp.Add(loop.get(),1))) {
        //<< set strJS = strJS_"    "_$listget(plstCode1,loop)
        strJS.set(mOp.Concat(mOp.Concat(strJS.get(),"    "),m$.Fnc.$listget(plstCode1.get(),loop.get())));
      }
      //<< }
      //<< set strJS = strJS_"  }"
      strJS.set(mOp.Concat(strJS.get(),"  }"));
      //<< set strJS = strJS_"  if ((result != '' )&&(result!==undefined)) {"
      strJS.set(mOp.Concat(strJS.get(),"  if ((result != '' )&&(result!==undefined)) {"));
      //<< set strJS = strJS_"    with (document.getElementById('"_pstrObject_"')) {"
      strJS.set(mOp.Concat(mOp.Concat(mOp.Concat(strJS.get(),"    with (document.getElementById('"),pstrObject.get()),"')) {"));
      //<< set strJS = strJS_"      value=result;"
      strJS.set(mOp.Concat(strJS.get(),"      value=result;"));
      //<< set strJS = strJS_"      focus();"
      strJS.set(mOp.Concat(strJS.get(),"      focus();"));
      //<< set strJS = strJS_"      fireEvent('onBlur');"
      strJS.set(mOp.Concat(strJS.get(),"      fireEvent('onBlur');"));
      //<< set strJS = strJS_"      fireEvent('onChange');"
      strJS.set(mOp.Concat(strJS.get(),"      fireEvent('onChange');"));
      //<< set strJS = strJS_"    }"
      strJS.set(mOp.Concat(strJS.get(),"    }"));
      //<< for loop=1:1:$listlength(plstCode2) {
      for (loop.set(1);(mOp.LessOrEqual(loop.get(),m$.Fnc.$listlength(plstCode2.get())));loop.set(mOp.Add(loop.get(),1))) {
        //<< set strJS = strJS_"    "_$listget(plstCode2,loop)
        strJS.set(mOp.Concat(mOp.Concat(strJS.get(),"    "),m$.Fnc.$listget(plstCode2.get(),loop.get())));
      }
      //<< }
      //<< set strJS = strJS_"  }"
      strJS.set(mOp.Concat(strJS.get(),"  }"));
      //<< set strJS = strJS_""""
      strJS.set(mOp.Concat(strJS.get(),"\""));
      //<< if pstrLinkType="HREF" set strJS = strJS_""
      if (mOp.Equal(pstrLinkType.get(),"HREF")) {
        strJS.set(mOp.Concat(strJS.get(),""));
      }
      //<< set strJS = strJS_">"
      strJS.set(mOp.Concat(strJS.get(),">"));
      //<< 
      //<< if pstrImage'="" {
      if (mOp.NotEqual(pstrImage.get(),"")) {
        //<< set strJS = strJS_"<IMG SRC="""_YGIF_$$Name^WWWIMAGE(pstrImage,YHID=2)_""" ALIGN=ABSBOTTOM TITLE="""_pstrTitle_""" border=0"
        strJS.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(strJS.get(),"<IMG SRC=\""),m$.var("YGIF").get()),m$.fnc$("WWWIMAGE.Name",pstrImage.get(),mOp.Equal(m$.var("YHID").get(),2))),"\" ALIGN=ABSBOTTOM TITLE=\""),pstrTitle.get()),"\" border=0"));
        //<< ;SR17861 set strJS = strJS_"<IMG SRC="""_YGIF_$$Name^WWWIMAGE(pstrImage,YHID=2)_""" ALIGN=ABSBOTTOM TITLE="""_pstrTitle_""" border=0 style='vertical-align:center; margin:1px; offset:0px;'"
        //<< if pstrId'="" set strJS = strJS_" id="""_pstrId_"IMG"""
        if (mOp.NotEqual(pstrId.get(),"")) {
          strJS.set(mOp.Concat(mOp.Concat(mOp.Concat(strJS.get()," id=\""),pstrId.get()),"IMG\""));
        }
        //<< set strJS = strJS_">"
        strJS.set(mOp.Concat(strJS.get(),">"));
      }
      //<< }
      //<< set strJS = strJS_"</A>"
      strJS.set(mOp.Concat(strJS.get(),"</A>"));
    }
    //<< }
    //<< quit strJS
    return strJS.get();
  }

  //<< 
  //<< 
  //<< DoOnClick(pstrAction) ;16913
  public Object DoOnClick(Object ... _p) {
    mVar pstrAction = m$.newVarRef("pstrAction",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< quit " document.WWW.style.cursor = 'wait'; SaveAction(1); "_pstrAction_" "
    return mOp.Concat(mOp.Concat(" document.WWW.style.cursor = 'wait'; SaveAction(1); ",pstrAction.get())," ");
  }

  //<< 
  //<< 
  //<< CreateWindowLocation(pstrAction) ;16913
  public Object CreateWindowLocation(Object ... _p) {
    mVar pstrAction = m$.newVarRef("pstrAction",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< quit " onClick=""document.WWW.style.cursor = 'wait'; SaveAction(1); window.location='"_pstrAction_"';"" "
    return mOp.Concat(mOp.Concat(" onClick=\"document.WWW.style.cursor = 'wait'; SaveAction(1); window.location='",pstrAction.get()),"';\" ");
  }

//<< 
//<< 
}
