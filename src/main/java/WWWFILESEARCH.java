//*****************************************************************************
//** TASC - ALPHALINC - MAC WWWFILESEARCH
//** Innovatium Systems - Code Converter - v1.30
//** 2014-06-27 18:59:46
//*****************************************************************************

import mLibrary.*;


//<< WWWFILESEARCH(FILE)
public class WWWFILESEARCH extends mClass {

  public Object main(Object ... _p) {
    mVar FILE = m$.newVarRef("FILE",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return _WWWFILESEARCH(FILE);
  }

  public Object _WWWFILESEARCH(Object ... _p) {
    mVar FILE = m$.newVarRef("FILE",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< /*------------------------------------------------------------------------------
    //<< ; Description of Function :
    //<< ;       BUTTON FÜR DIE AUSWAHL VON DATEIEN
    //<< ;       BUTTON FOR THE SELECTION OF FILES
    //<< ;
    //<< ;   SUCH NACH DATEIEN IN EINEM VERZEICHNIS AUF DEM SERVER ;within within tabulation upon
    //<< ;   FUNKTION KANN HINTER EINEM DATENFELD IM fORMULAR AUFGERUFEN WERDEN: ;posterior data item
    //<< ;   Z.B. DO ^WWWFILESEARCH() ODER ^WWWFILESEARCH("C:\")
    //<< ;   WENN KEIN PFAD ANGEGEBEN WIRD, DANN WIRD DER PFAD AUS DEN MANDANTENPARAMETERN GENOMMEN.
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
    //<< ; 23-Nov-2005   GRF     SR13171 : Doco; FIXME
    //<< ; 30-May-2005   RobertW SR12056: Attempt at Performance Increase
    //<< ; 28.07.03      BEC     Created
    //<< ;-----------------------------------------------------------------------------*/
    //<< SET FILE=$GET(FILE)    ;VERZEICHNIS ;tabulation
    FILE.set(m$.Fnc.$get(FILE));
    //<< 
    //<< /*++++++++++++++++++++++++++++++++++++++
    //<< ;   VORGM       objWWW012       General Company Parameter
    //<< ;+++++++++++++++++++++++++++++++++++++*/
    //<< 
    //<< IF FILE="" DO   ;SETZTEN PFADVORGABE AUS MANDANTENPARAMETERN ;out of
    if (mOp.Equal(FILE.get(),"")) {
      //<< . NEW VORGM
      mVar VORGM = m$.var("VORGM");
      m$.newVarBlock(1,VORGM);
      //<< . SET VORGM=$GET(^WWW012(0,YM,1))
      VORGM.set(m$.Fnc.$get(m$.var("^WWW012",0,m$.var("YM").get(),1)));
      //<< . SET FILE=$PIECE($GET(VORGM),Y,49)                                 ; Physical WWW Directory
      FILE.set(m$.Fnc.$piece(m$.Fnc.$get(VORGM),m$.var("Y").get(),49));
      //<< . IF FILE'="" SET FILE=$PIECE(FILE,$PIECE($GET(VORGM),Y,47),1)      ; Picture Directory System
      if (mOp.NotEqual(FILE.get(),"")) {
        FILE.set(m$.Fnc.$piece(FILE.get(),m$.Fnc.$piece(m$.Fnc.$get(VORGM),m$.var("Y").get(),47),1));
      }
      //<< . SET FILE=FILE_$PIECE($GET(VORGM),Y,48)                            ; Append Picture Directory User ?????
      FILE.set(mOp.Concat(FILE.get(),m$.Fnc.$piece(m$.Fnc.$get(VORGM),m$.var("Y").get(),48)));
    }
    m$.restoreVarBlock(1);
    //<< ;                                      FIXME : Is this right??? Not used this way in WWWAMVAR or WWWVORG <GRF>
    //<< 
    //<< IF $FIND(FILE,"\") DO  ;MASKIEREN VON "\" DA ES SONST IM JAVASCRIPTAUFRUF PROBLEME GIBT
    if (mOp.Logical(m$.Fnc.$find(FILE.get(),"\\"))) {
      //<< . NEW YI,FILE1
      mVar YI = m$.var("YI");
      mVar FILE1 = m$.var("FILE1");
      m$.newVarBlock(1,YI,FILE1);
      //<< . SET FILE1=""
      FILE1.set("");
      //<< . FOR YI=1:1:10 DO
      for (YI.set(1);(mOp.LessOrEqual(YI.get(),10));YI.set(mOp.Add(YI.get(),1))) {
        do {
          //<< . . IF '$FIND($PIECE(FILE,"\",YI,999),"\") QUIT
          if (mOp.Not(m$.Fnc.$find(m$.Fnc.$piece(FILE.get(),"\\",YI.get(),999),"\\"))) {
            break;
          }
          //<< . . SET FILE1=$GET(FILE1)_$PIECE(FILE,"\",YI)_"\\"
          FILE1.set(mOp.Concat(mOp.Concat(m$.Fnc.$get(FILE1),m$.Fnc.$piece(FILE.get(),"\\",YI.get())),"\\\\"));
        } while (false);
      }
      //<< . SET FILE=FILE1
      FILE.set(FILE1.get());
    }
    m$.restoreVarBlock(1);
    do {
      //<< 
      //<< DO  ;ERSTELLEN DES BUTTONS IM FORMULAR ;form
      //<< . QUIT:$GET(YHID)=1
      if (mOp.Equal(m$.Fnc.$get(m$.var("YHID")),1)) {
        break;
      }
      //<< . QUIT:$GET(YHID)=2
      if (mOp.Equal(m$.Fnc.$get(m$.var("YHID")),2)) {
        break;
      }
      //<< . ;
      //<< . WRITE YCR,"<A HREF="_""""
      m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat("<A HREF=","\""));
      //<< . SET URL=YAKTION_"EP=WWWMANU1&amp;YEXEC=D|START^WWWFILESEARCH&amp;YUSER="_YUSER_"&amp;YBED="_YBED_"&amp;YTRAKT="_YTRAKT_"&amp;YUCI="_$GET(YUCI)_"&amp;YM="_YM_"&amp;YKEY="_YKEY_"&amp;YBACK="_YBACK_"&amp;YLFDAT="_"Y"_YFORM_YART_YLFN_"&amp;YLFFORM="_$GET(YBBN)_"&amp;YFORM="_YFORM_"&amp;YAUSWAHL="_FILE_"!"_"'+document."_YHTMFORM_".Y"_YFORM_YART_YLFN_".value+'"
      mVar URL = m$.var("URL");
      URL.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(m$.var("YAKTION").get(),"EP=WWWMANU1&amp;YEXEC=D|START^WWWFILESEARCH&amp;YUSER="),m$.var("YUSER").get()),"&amp;YBED="),m$.var("YBED").get()),"&amp;YTRAKT="),m$.var("YTRAKT").get()),"&amp;YUCI="),m$.Fnc.$get(m$.var("YUCI"))),"&amp;YM="),m$.var("YM").get()),"&amp;YKEY="),m$.var("YKEY").get()),"&amp;YBACK="),m$.var("YBACK").get()),"&amp;YLFDAT="),"Y"),m$.var("YFORM").get()),m$.var("YART").get()),m$.var("YLFN").get()),"&amp;YLFFORM="),m$.Fnc.$get(m$.var("YBBN"))),"&amp;YFORM="),m$.var("YFORM").get()),"&amp;YAUSWAHL="),FILE.get()),"!"),"'+document."),m$.var("YHTMFORM").get()),".Y"),m$.var("YFORM").get()),m$.var("YART").get()),m$.var("YLFN").get()),".value+'"));
      //<< . SET OPT="HEIGHT=500,WIDTH=400,SCROLLBARS=YES,RESIZEABLE=YES"
      mVar OPT = m$.var("OPT");
      OPT.set("HEIGHT=500,WIDTH=400,SCROLLBARS=YES,RESIZEABLE=YES");
      //<< . WRITE "javascript:var parameter=window.open('"_URL_"','Stucture','"_OPT_"');"
      m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("javascript:var parameter=window.open('",URL.get()),"','Stucture','"),OPT.get()),"');"));
      //<< . WRITE """"
      m$.Cmd.Write("\"");
      //<< . WRITE ">"
      m$.Cmd.Write(">");
      //<< . WRITE YCR,"<IMG SRC="_""""_YGIF_"search1.gif"_""""_" ALIGN=ABSBOTTOM TITLE="_""""_$$^WWWTEXT(148)_""""_" border=0>"
      m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<IMG SRC=","\""),m$.var("YGIF").get()),"search1.gif"),"\"")," ALIGN=ABSBOTTOM TITLE="),"\""),m$.fnc$("WWWTEXT.main",148)),"\"")," border=0>"));
      //<< . WRITE "</A>"
      m$.Cmd.Write("</A>");
    } while(false);
    //<< 
    //<< QUIT
    return null;
  }

  //<< 
  //<< 
  //<< START ;AUSWERTEN VARIABELEN UND STARTEN WWWPARAM (ANZEIGE DATEN IN MENUFORM) ;And launching within
  public void START() {
    //<< ;AUSFÜHREN DES SUCHFENSTER NACH EINER SUCHABFRAGE ;implement within unit
    //<< NEW (%request,%session,%KEY,%,%ZCS,%CGIEVAR)
    //<< 
    //<< DO ^WWWVAR  ;VORGABEN SETZEN ;typeset
    m$.Cmd.Do("WWWVAR.main");
    //<< NEW BETRIEB,DIR,SUCH
    mVar BETRIEB = m$.var("BETRIEB");
    mVar DIR = m$.var("DIR");
    mVar SUCH = m$.var("SUCH");
    m$.newVar(BETRIEB,DIR,SUCH);
    //<< 
    //<< SET FILE=$PIECE($GET(YAUSWAHL),"!",1)
    mVar FILE = m$.var("FILE");
    FILE.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("YAUSWAHL")),"!",1));
    //<< SET SUCH=$PIECE($GET(YAUSWAHL),"!",2)
    SUCH.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("YAUSWAHL")),"!",2));
    //<< KILL ^WWWSOR(YUSER)
    m$.var("^WWWSOR",m$.var("YUSER").get()).kill();
    //<< NEW YPARA,YSORT,FILENAME
    mVar YPARA = m$.var("YPARA");
    mVar YSORT = m$.var("YSORT");
    mVar FILENAME = m$.var("FILENAME");
    m$.newVar(YPARA,YSORT,FILENAME);
    //<< 
    //<< SET YPARA(1)=FILE
    YPARA.var(1).set(FILE.get());
    //<< IF SUCH="" SET YPARA(1)=YPARA(1)_"\*"         ;SELECT ALL
    if (mOp.Equal(SUCH.get(),"")) {
      YPARA.var(1).set(mOp.Concat(YPARA.var(1).get(),"\\*"));
    }
    //<< ;IF SUCH'="" SET YPARA(1)=YPARA(1)_"\"_SUCH   ;GEZIELT NACH FELDINHALT  ;tybd;23,09,2003;24302
    //<< IF SUCH'="" SET YPARA(1)=YPARA(1)_"\*"        ;GEZIELT NACH FELDINHALT  ;;tybd;23,09,2003;24302
    if (mOp.NotEqual(SUCH.get(),"")) {
      YPARA.var(1).set(mOp.Concat(YPARA.var(1).get(),"\\*"));
    }
    //<< SET YSORT(1)=$ZSEARCH(YPARA(1))
    YSORT.var(1).set(m$.Fnc.$zsearch(YPARA.var(1).get()));
    //<< IF YSORT(1)'=""  FOR  SET YSORT(1)=$ZSEARCH("") QUIT:YSORT(1)=""  DO
    if (mOp.NotEqual(YSORT.var(1).get(),"")) {
      for (;true;) {
        YSORT.var(1).set(m$.Fnc.$zsearch(""));
        if (mOp.Equal(YSORT.var(1).get(),"")) {
          break;
        }
        do {
          //<< . QUIT:$FIND(YSORT(1),"..")   ;DIRECTORY
          if (mOp.Logical(m$.Fnc.$find(YSORT.var(1).get(),".."))) {
            break;
          }
          //<< . QUIT:'$FIND(YSORT(1),".")   ;NO EXPANSION OR DIR ;expansion yourself
          if (mOp.Not(m$.Fnc.$find(YSORT.var(1).get(),"."))) {
            break;
          }
          //<< . ;
          //<< .;IF SUCH'="" IF '$FIND($$^WWWUPER(YSORT(1)),$TRANSLATE($$^WWWUPER(SUCH),"*"))       QUIT  ;;tybd;23,09,2003;24302
          //<< . IF SUCH'="" IF '$FIND($zconvert(YSORT(1),"U"),$TRANSLATE($zconvert(SUCH,"U"),"*")) QUIT  ;;tybd;23,09,2003;24302
          if (mOp.NotEqual(SUCH.get(),"")) {
            if (mOp.Not(m$.Fnc.$find(m$.Fnc.$zconvert(YSORT.var(1).get(),"U"),m$.Fnc.$translate(m$.Fnc.$zconvert(SUCH.get(),"U"),"*")))) {
              break;
            }
          }
          //<< . SET FILENAME=$PIECE(YSORT(1),"\",$LENGTH(YSORT(1),"\"))  ;
          FILENAME.set(m$.Fnc.$piece(YSORT.var(1).get(),"\\",m$.Fnc.$length(YSORT.var(1).get(),"\\")));
          //<< . QUIT:FILENAME=""
          if (mOp.Equal(FILENAME.get(),"")) {
            break;
          }
          //<< . SET ^WWWSOR(YUSER,FILENAME)=" "_Y_FILENAME
          m$.var("^WWWSOR",m$.var("YUSER").get(),FILENAME.get()).set(mOp.Concat(mOp.Concat(" ",m$.var("Y").get()),FILENAME.get()));
        } while (false);
      }
    }
    //<< 
    //<< 
    //<< /*++++++++++++++++++++++++++++++++++++++
    //<< ;   &FILE   = DATEI DIE ANGEZEIGT WIRD (STANDARD=WWWEXPLORE)  ;who
    //<< ;   &FIX    = FESTER ERSTER KEY (NUR WENN &FILE)              ;premier KEY when
    //<< ;   &RECORD = FELDER DIE ANGEZEIGT WERDEN SOLLEN (STANDARD=1) ;who will should
    //<< ;   &OFFSET = STRUKTUR (WIRD GEBILDET)
    //<< ;   &HEAD   = TEXT FÜR HEADER
    //<< ;+++++++++++++++++++++++++++++++++++++*/
    //<< 
    //<< SET %(YQUERY,"TARGET") = $GET(YTARGET)     ;TARGET DER AUSGABE ;the expenses
    m$.var("%",m$.var("YQUERY").get(),"TARGET").set(m$.Fnc.$get(m$.var("YTARGET")));
    //<< SET %(YQUERY,"FILE")   = "WWWSOR"
    m$.var("%",m$.var("YQUERY").get(),"FILE").set("WWWSOR");
    //<< SET %(YQUERY,"FIX")    = $GET(YUSER)
    m$.var("%",m$.var("YQUERY").get(),"FIX").set(m$.Fnc.$get(m$.var("YUSER")));
    //<< SET %(YQUERY,"RECORD") = "1"               ;FELDER, DIE ANGEZEIGT WERDEN (1,2,3,4)
    m$.var("%",m$.var("YQUERY").get(),"RECORD").set("1");
    //<< SET %(YQUERY,"YUCI")   = $GET(YUCI)        ;NAMESPACE
    m$.var("%",m$.var("YQUERY").get(),"YUCI").set(m$.Fnc.$get(m$.var("YUCI")));
    //<< SET %(YQUERY,"HEAD")   = $$^WWWTEXT(200)_" "_SUCH_" -> "_FILE         ;BETRIEB
    m$.var("%",m$.var("YQUERY").get(),"HEAD").set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(m$.fnc$("WWWTEXT.main",200)," "),SUCH.get())," -> "),FILE.get()));
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
    //<< 
    //<< MERGE %KEY=%(YQUERY)
    m$.Cmd.Merge(m$.var("%KEY"),m$.var("%",m$.var("YQUERY").get()));
    //<< DO ^WWWPARAM
    m$.Cmd.Do("WWWPARAM.main");
    //<< QUIT
    return;
  }

//<< 
//<< 
}
