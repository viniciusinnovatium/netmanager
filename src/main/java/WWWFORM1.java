//*****************************************************************************
//** TASC - ALPHALINC - MAC WWWFORM1
//** Innovatium Systems - Code Converter - v1.28
//** 2014-05-26 21:13:16
//*****************************************************************************

import mLibrary.*;

//<< 
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
//<< #include WWWConst
import include.WWWConst;
//<< #include WWWFORM
import include.WWWFORM;

//<< WWWFORM1
public class WWWFORM1 extends mClass {

  public void main() {
    _WWWFORM1();
  }

  public void _WWWFORM1() {
    //<< 
    //<< ;-------------------------------------------------------------------------------
    //<< ;   Button Display          BUTTON ANZEIGEN
    //<< ;
    //<< ; Inputs:
    //<< ;   YFORM       Form Name
    //<< ;   YVOR        objWWW120
    //<< ;   YFOART      Form Type
    //<< ;                   1   Standard Form
    //<< ;                   2   List Generator
    //<< ;                   3   Grid Form
    //<< ;                   4   Manual Input (with Button)
    //<< ;                   5   Manual Input (without Button)
    //<< ;                   6   Menu Input Type
    //<< ;                   7   Search Engine
    //<< ;                   8   Wizard
    //<< ;                   9   BitMap Search
    //<< ;                   10  Gantt Chart
    //<< ;                   11  Edit Table
    //<< ;                   12  Grid Edit Only
    //<< ;   SPRACHE     Language
    //<< ;   YTIMEFORM
    //<< ;   YMENU
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 26-Aug-2010   GRF     SR17515: YTABLEANZ should be incr not decr on <TABLE>
    //<< ; 24-Jan-2008   shobby  SRBR014526: Call to standard Coolbar function.
    //<< ; 20-Nov-2007   shobby  Optionally add buttons to popup up forms (specified by
    //<< ;                           user) in a new window.
    //<< ; 12-Nov-2007   GRF     Doco; !=>||
    //<< ; 24-Aug-2007   GRF     Uncomment closing angle bracket for TABLE HTML tag
    //<< ; 07-May-2007   GRF     SR15511: Doco; quits
    //<< ; 21-Dec-2006   JW      SR14235: Added reference to child window
    //<< ; 19-Dec-2006   JW      BR014262: Call GetType, js fn showMenu.  Don't show
    //<< ;                           button for full screen mode.
    //<< ; 10-Nov-2006   JW      BR014276: Replace idMenuType with YMENU (already defined)
    //<< ; 20-Oct-2006   Steve S BR014276: Added button for menu type 4
    //<< ; 01-Sep-2006   HeberB  SR14404 : Translation link with current key affects help text
    //<< ; 21-Nov-2005   GRF     SR13171 : Doco
    //<< ; 14-Oct-2005   Steve S SR13651: Add translation tool for reports
    //<< ; 05.08.1997    DT      Created
    //<< ;-------------------------------------------------------------------------------
    //<< quit:$get(YFORM)="WWWBLANK"
    if (mOp.Equal(m$.Fnc.$get(m$.var("YFORM")),"WWWBLANK")) {
      return;
    }
    //<< new YYQ
    mVar YYQ = m$.var("YYQ");
    m$.newVar(YYQ);
    //<< 
    //<< ; FORM WITHOUT BUTTONS                  D10     $$$WWW124ButtonBelongsToADataItem()
    //<< ;---------------------------------------
    //<< ; FIXME : does this assume buttons will always be in sequence i.e. no gaps?  No button 2 with value in button 1?
    //<< set YYQ = $$$NO
    YYQ.set(include.COMSYS.$$$NO(m$));
    //<< if YFOART=5 {                                        ; Manual Input (without Button)
    if (mOp.Equal(m$.var("YFOART").get(),5)) {
      //<< if '$data(^WWW124(0,YFORM)) set YYQ = $$$YES     ; no manual buttons exist
      if (mOp.Not(m$.Fnc.$data(m$.var("^WWW124",0,m$.var("YFORM").get())))) {
        YYQ.set(include.COMSYS.$$$YES(m$));
      }
      //<< if '$data(^WWW124(0,YFORM,SPRACHE,2,1)) if $piece($get(^WWW124(0,YFORM,SPRACHE,1,1)),Y,10)=$$$YES set YYQ = $$$YES
      if (mOp.Not(m$.Fnc.$data(m$.var("^WWW124",0,m$.var("YFORM").get(),m$.var("SPRACHE").get(),2,1)))) {
        if (mOp.Equal(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW124",0,m$.var("YFORM").get(),m$.var("SPRACHE").get(),1,1)),m$.var("Y").get(),10),include.COMSYS.$$$YES(m$))) {
          YYQ.set(include.COMSYS.$$$YES(m$));
        }
      }
    }
    //<< }
    //<< 
    //<< quit:YYQ=$$$YES
    if (mOp.Equal(YYQ.get(),include.COMSYS.$$$YES(m$))) {
      return;
    }
    //<< 
    //<< if YBEDBER=1 write YCR,YCR,"<!-- ************************* STANDARD BUTTON (WWWFORM1/WWWFORMF) ************************* -->",YCR,YCR
    if (mOp.Equal(m$.var("YBEDBER").get(),1)) {
      m$.Cmd.Write(m$.var("YCR").get(),m$.var("YCR").get(),"<!-- ************************* STANDARD BUTTON (WWWFORM1/WWWFORMF) ************************* -->",m$.var("YCR").get(),m$.var("YCR").get());
    }
    //<< 
    //<< ; Form Centred                          D10     $$$WWW120FormCentered()
    //<< ;---------------------------------------
    //<< if (YFOART=5)||(YFOART=8) if $piece(YVOR,Y,10)=$$$YES do
    if ((mOp.Equal(m$.var("YFOART").get(),5)) || (mOp.Equal(m$.var("YFOART").get(),8))) {
      if (mOp.Equal(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),10),include.COMSYS.$$$YES(m$))) {
        do {
          //<< . if YFOART=5 if $data(^WWW124(0,YFORM)) quit
          if (mOp.Equal(m$.var("YFOART").get(),5)) {
            if (mOp.Logical(m$.Fnc.$data(m$.var("^WWW124",0,m$.var("YFORM").get())))) {
              break;
            }
          }
          //<< . write "<CENTER>"
          m$.Cmd.Write("<CENTER>");
        } while (false);
      }
    }
    //<< 
    //<< if $get(YMENU)="" set YMENU = $$GetType^WWWMENU()
    if (mOp.Equal(m$.Fnc.$get(m$.var("YMENU")),"")) {
      mVar YMENU = m$.var("YMENU");
      YMENU.set(m$.fnc$("WWWMENU.GetType"));
    }
    //<< 
    //<< ;------------------------------------------------------------------------
    //<< set YTABLEANZ = $get(YTABLEANZ)+1
    mVar YTABLEANZ = m$.var("YTABLEANZ");
    YTABLEANZ.set(mOp.Add(m$.Fnc.$get(m$.var("YTABLEANZ")),1));
    //<< set ^CacheTempToolbar(YUSER)=1 ;SR18053
    m$.var("^CacheTempToolbar",m$.var("YUSER").get()).set(1);
    //<< write $$Coolbar^WWWFORMCOMMON(YVOR)
    m$.Cmd.Write(m$.fnc$("WWWFORMCOMMON.Coolbar",m$.var("YVOR").get()));
    //<< 
    //<< ;+++++++++++++++++++++++++++++++++++++++ ( * Boolean, # System Param)
    //<< ; * D10     $$$WWW120FormCentered()
    //<< ; * D13     $$$WWW120DisplayFrames()
    //<< ; * D45     $$$WWW120PicturesAsButtons()
    //<< ;   D46     $$$WWW120StandardSubmit()
    //<< ; # D94     $$$WWW120DoNOTDisplayStandardButto()
    //<< ; * D106    $$$WWW120FormForEffectiveDate()
    //<< ;   D126    $$$WWW120ExecuteDuringButtonLine()
    //<< ;+++++++++++++++++++++++++++++++++++++++
    //<< 
    //<< ;---------------------------------------
    //<< ; $$SR16455 : Currently returns $$$NO
    //<< ;---------------------------------------
    //<< set $piece(YVOR,Y,94) = $translate($piece(YVOR,Y,94),";",",")  ;UMSETZEN
    m$.pieceVar(m$.var("YVOR"),m$.var("Y").get(),94).set(m$.Fnc.$translate(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),94),";",","));
    //<< 
    //<< if '$$$WWW120PicturesAsButtons(YVOR) write YCR,"<TR>"
    if (mOp.Not(include.WWWConst.$$$WWW120PicturesAsButtons(m$,m$.var("YVOR")))) {
      m$.Cmd.Write(m$.var("YCR").get(),"<TR>");
    }
    //<< 
    //<< ; STANDARD BUTTONS
    //<< ;---------------------------------------
    //<< if $$$WWW120StandardSubmit(YVOR)'="," do
    if (mOp.NotEqual(include.WWWConst.$$$WWW120StandardSubmit(m$,m$.var("YVOR")),",")) {
      //<< . if YFOART=1                 do HEAD1^WWWFORMF    ; STANDARD
      if (mOp.Equal(m$.var("YFOART").get(),1)) {
        m$.Cmd.Do("WWWFORMF.HEAD1");
      }
      //<< . if (YFOART=2) || (YFOART=9) do HEAD2^WWWFORMM    ; LIST GENERATOR or BIT MAP SEARCH (same as HEAD4^WWWFORMM)
      if ((mOp.Equal(m$.var("YFOART").get(),2)) || (mOp.Equal(m$.var("YFOART").get(),9))) {
        m$.Cmd.Do("WWWFORMM.HEAD2");
      }
      //<< . if YFOART=3                 do HEAD3^WWWFORMF    ; GRID
      if (mOp.Equal(m$.var("YFOART").get(),3)) {
        m$.Cmd.Do("WWWFORMF.HEAD3");
      }
      //<< . ;
      //<< . if +$piece(YVOR,Y,45)=$$$NO do
      if (mOp.Equal(mOp.Positive(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),45)),include.COMSYS.$$$NO(m$))) {
        //<< . . write YCR,"</TABLE>"
        m$.Cmd.Write(m$.var("YCR").get(),"</TABLE>");
        //<< . . set YTABLEANZ = $get(YTABLEANZ)-1
        YTABLEANZ.set(mOp.Subtract(m$.Fnc.$get(YTABLEANZ),1));
        //<< . . write YCR,"<TABLE CELLSPACING=0 BORDER=0>"     ;TEXTE ALS BUTTON ;when
        m$.Cmd.Write(m$.var("YCR").get(),"<TABLE CELLSPACING=0 BORDER=0>");
        //<< . . set YTABLEANZ = YTABLEANZ+1    ;SR17515 was -1
        YTABLEANZ.set(mOp.Add(YTABLEANZ.get(),1));
      }
      //<< . ;
      //<< . if YFOART=4  do HEAD4^WWWFORMM set YKEY = ""     ;MANUELLE
      if (mOp.Equal(m$.var("YFOART").get(),4)) {
        m$.Cmd.Do("WWWFORMM.HEAD4");
        mVar YKEY = m$.var("YKEY");
        YKEY.set("");
      }
      //<< . if (YFOART=5) || (YFOART=8) if $data(^WWW122(0,YFORM)) do HEAD4^WWWFORMM  ;OHNE BUTTON ABER MIT OK! ;without yet by means of
      if ((mOp.Equal(m$.var("YFOART").get(),5)) || (mOp.Equal(m$.var("YFOART").get(),8))) {
        if (mOp.Logical(m$.Fnc.$data(m$.var("^WWW122",0,m$.var("YFORM").get())))) {
          m$.Cmd.Do("WWWFORMM.HEAD4");
        }
      }
      //<< . if YFOART=6  do HEAD4^WWWFORMM,DELETE^WWWFORMF
      if (mOp.Equal(m$.var("YFOART").get(),6)) {
        m$.Cmd.Do("WWWFORMM.HEAD4");
        m$.Cmd.Do("WWWFORMF.DELETE");
      }
      //<< . if YFOART=7  do HEAD4^WWWFORMM
      if (mOp.Equal(m$.var("YFOART").get(),7)) {
        m$.Cmd.Do("WWWFORMM.HEAD4");
      }
    }
    //<< 
    //<< 
    //<< ;+++++++++++++++++++++++++++++++++++++++
    //<< ;  D66      $$$WWW120PositioningOfButtonLine()
    //<< ;   0   Buttons Above
    //<< ;   1   Button Down
    //<< ;   2   Text Border Left
    //<< ;   3   Selection
    //<< ;+++++++++++++++++++++++++++++++++++++++
    //<< ;SONDERBUTTON  ;wenn keine ;when None
    //<< if ($get(YTIMEFORM)'=1) && ($piece(YVOR,Y,66)'=2) && ($order(^WWW124s(0,2,$$^WWWUMLAU(YFORM,1),SPRACHE,""))'="" || (+$get(YSCREENM)'=0)) {
    if ((mOp.NotEqual(m$.Fnc.$get(m$.var("YTIMEFORM")),1)) && (mOp.NotEqual(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),66),2)) && (mOp.NotEqual(m$.Fnc.$order(m$.var("^WWW124s",0,2,m$.fnc$("WWWUMLAU.main",m$.var("YFORM").get(),1),m$.var("SPRACHE").get(),"")),"") || (mOp.NotEqual(mOp.Positive(m$.Fnc.$get(m$.var("YSCREENM"))),0)))) {
      //<< if $piece(YVOR,Y,45) if YFOART'=4 if YFOART'=8 if YFOART'=5 write $$Delimiter^WWWFORMCOMMON()
      if (mOp.Logical(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),45))) {
        if (mOp.NotEqual(m$.var("YFOART").get(),4)) {
          if (mOp.NotEqual(m$.var("YFOART").get(),8)) {
            if (mOp.NotEqual(m$.var("YFOART").get(),5)) {
              m$.Cmd.Write(m$.fnc$("WWWFORMCOMMON.Delimiter"));
            }
          }
        }
      }
      //<< 
      //<< Set doWWWFORMC = $case($$$WWW120PositioningOfButtonLine(YVOR), 3:"^WWWFORMC3",: "^WWWFORMC")
      mVar doWWWFORMC = m$.var("doWWWFORMC");
      doWWWFORMC.set(m$.Fnc.$case(include.WWWConst.$$$WWW120PositioningOfButtonLine(m$,m$.var("YVOR")),3,"^WWWFORMC3","^WWWFORMC"));
      //<< do @doWWWFORMC
      m$.Cmd.Do(doWWWFORMC.get());
    }
    //<< }
    //<< if $get(YTIMEFORM)'=1 if $piece(YVOR,Y,46)'="," do   ;WENN , DANN KEINEN
    if (mOp.NotEqual(m$.Fnc.$get(m$.var("YTIMEFORM")),1)) {
      if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),46),",")) {
        //<< . ;WV  WIEDERVORLAGE
        //<< . if '$find(","_$piece(YVOR,Y,94)_",",",14,") if (YFOART=1)||(YFOART=3) do WV^WWWFORMF  ;WIEDERVORLAGE
        if (mOp.Not(m$.Fnc.$find(mOp.Concat(mOp.Concat(",",m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),94)),","),",14,"))) {
          if ((mOp.Equal(m$.var("YFOART").get(),1)) || (mOp.Equal(m$.var("YFOART").get(),3))) {
            m$.Cmd.Do("WWWFORMF.WV");
          }
        }
        //<< . ;
        //<< . ;COPY  KOPIEREN DATENSATZ ;data record
        //<< . if '$find(","_$piece(YVOR,Y,94)_",",",15,") if (YFOART=1)||(YFOART=3) if $data(^WWW121(0,YFORM)) do COPY^WWWFORMF  ;COPY
        if (mOp.Not(m$.Fnc.$find(mOp.Concat(mOp.Concat(",",m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),94)),","),",15,"))) {
          if ((mOp.Equal(m$.var("YFOART").get(),1)) || (mOp.Equal(m$.var("YFOART").get(),3))) {
            if (mOp.Logical(m$.Fnc.$data(m$.var("^WWW121",0,m$.var("YFORM").get())))) {
              m$.Cmd.Do("WWWFORMF.COPY");
            }
          }
        }
        //<< . ;
        //<< . ;ZEITABHÄNGIGE ERFASSUNG;BEC;24383;18.11.03
        //<< . ;
        //<< . do
        do {
          //<< . . new BER,MOD
          mVar BER = m$.var("BER");
          mVar MOD = m$.var("MOD");
          m$.newVarBlock(2,BER,MOD);
          //<< . . set BER=""
          BER.set("");
          //<< . . set MOD=""
          MOD.set("");
          //<< . . if $get(YM)'="" if $get(YFORM)'="" if $data(^WWW121D(0,YFORM,1,YM,1)) do
          if (mOp.NotEqual(m$.Fnc.$get(m$.var("YM")),"")) {
            if (mOp.NotEqual(m$.Fnc.$get(m$.var("YFORM")),"")) {
              if (mOp.Logical(m$.Fnc.$data(m$.var("^WWW121D",0,m$.var("YFORM").get(),1,m$.var("YM").get(),1)))) {
                //<< . . . set BER=$piece($get(^WWW121D(0,YFORM,1,YM,1)),Y,64)   ;BERECHTIGUNG NUR AUS DEM ERSTEN PRIMÄRSCHLÜSSEL ;only out of
                BER.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW121D",0,m$.var("YFORM").get(),1,m$.var("YM").get(),1)),m$.var("Y").get(),64));
                //<< . . . set MOD=$piece($get(^WWW121D(0,YFORM,1,YM,1)),Y,65)   ;BERECHTIGUNG NUR AUS DEM ERSTEN PRIMÄRSCHLÜSSEL ;only out of
                MOD.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW121D",0,m$.var("YFORM").get(),1,m$.var("YM").get(),1)),m$.var("Y").get(),65));
              }
            }
          }
          //<< . . ;
          //<< . . if (BER'="")||(MOD'="") quit:$$^WWWACCESS(BER,MOD)'=$$$YES  ;KEINE BERECHTIGUNG ;no
          if ((mOp.NotEqual(BER.get(),"")) || (mOp.NotEqual(MOD.get(),""))) {
            if (mOp.NotEqual(m$.fnc$("WWWACCESS.main",BER.get(),MOD.get()),include.COMSYS.$$$YES(m$))) {
              break;
            }
          }
          //<< . . if $piece(YVOR,Y,106)=$$$YES if (YFOART=1)||(YFOART=3) if YKEY'="" if $data(^WWW121(0,YFORM)) do TM^WWWFORMF  ;ERFASSUNG BEI ZEIT ;logging next to time
          if (mOp.Equal(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),106),include.COMSYS.$$$YES(m$))) {
            if ((mOp.Equal(m$.var("YFOART").get(),1)) || (mOp.Equal(m$.var("YFOART").get(),3))) {
              if (mOp.NotEqual(m$.var("YKEY").get(),"")) {
                if (mOp.Logical(m$.Fnc.$data(m$.var("^WWW121",0,m$.var("YFORM").get())))) {
                  m$.Cmd.Do("WWWFORMF.TM");
                }
              }
            }
          }
        } while(false);
        m$.restoreVarBlock(2);
      }
    }
    //<< 
    //<< ;-------------------------------------------------------------------------------
    //<< 
    //<< if ($$$WWW013CompilerTranslator($get(^WWW013(0,YBED,1)))'="") && $find(","_$$^WWWBEDBER(YBED)_",",",1,") {
    if ((mOp.NotEqual(include.WWWConst.$$$WWW013CompilerTranslator(m$,m$.Fnc.$get(m$.var("^WWW013",0,m$.var("YBED").get(),1))),"")) && mOp.Logical(m$.Fnc.$find(mOp.Concat(mOp.Concat(",",m$.fnc$("WWWBEDBER.main",m$.var("YBED").get())),","),",1,"))) {
      //<< if ($get(YFORM)'="") && (YFORM'="WWWLNG") && (YFORM'="WWWBLANK") && $$$WWW120PicturesAsButtons(YVOR) {
      if ((mOp.NotEqual(m$.Fnc.$get(m$.var("YFORM")),"")) && (mOp.NotEqual(m$.var("YFORM").get(),"WWWLNG")) && (mOp.NotEqual(m$.var("YFORM").get(),"WWWBLANK")) && mOp.Logical(include.WWWConst.$$$WWW120PicturesAsButtons(m$,m$.var("YVOR")))) {
        //<< do TranslationButton()
        m$.Cmd.Do("TranslationButton");
      }
    }
    //<< }
    //<< }
    //<< do CreatePopupShortcutsLink()
    m$.Cmd.Do("CreatePopupShortcutsLink");
    //<< 
    //<< if (YMENU=4) && $$$IsTopUser(YUSER) && '$$$WWW013useFullScreenandHeader($get(^WWW013(0,YBED,1))) {
    if ((mOp.Equal(m$.var("YMENU").get(),4)) && mOp.Logical(include.COMSYSWWW.$$$IsTopUser(m$,m$.var("YUSER"))) && mOp.Not(include.WWWConst.$$$WWW013useFullScreenandHeader(m$,m$.Fnc.$get(m$.var("^WWW013",0,m$.var("YBED").get(),1))))) {
      //<< write "<TD WIDTH=10"
      m$.Cmd.Write("<TD WIDTH=10");
      //<< if +$$$WWW120PicturesAsButtons(YVOR)=$$$YES write " class=""coolButton"">"  ;MOUSEEFFECT
      if (mOp.Equal(mOp.Positive(include.WWWConst.$$$WWW120PicturesAsButtons(m$,m$.var("YVOR"))),include.COMSYS.$$$YES(m$))) {
        m$.Cmd.Write(" class=\"coolButton\">");
      }
      //<< write "<A class=link onClick=""parent.showMenu(0);"">"
      m$.Cmd.Write("<A class=link onClick=\"parent.showMenu(0);\">");
      //<< 
      //<< write "<IMG SRC="""_YGIF_"baum.gif"" TITLE="""_$$$Text("WWW00048")_""" border=0></A>" ; "Menu Window"
      m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<IMG SRC=\"",m$.var("YGIF").get()),"baum.gif\" TITLE=\""),include.COMSYS.$$$Text(m$,"WWW00048")),"\" border=0></A>"));
      //<< write "</TD>"
      m$.Cmd.Write("</TD>");
    }
    //<< }
    //<< 
    //<< ;-------------------------------------------------------------------------------
    //<< ; Execute During Button Line                 EXECUTE ZWISCHEN BUTTON          ; *** EXECUTE ***
    //<< ; D126      $$$WWW120ExecuteDuringButtonLine()
    //<< ;-------------------------------------------------------------------------------
    //<< if $piece(YVOR,Y,126)'=""  do  ;TYBD;EXECUTE VERSCHOBEN VOR DEN DELIMITER; TYBD;5.09.2003
    if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),126),"")) {
      //<< . ;IF YBEDBER=1 WRITE YCR,YCR,"<!-- ************************* EXECUTE DURING BUTTON LINE  :"_$PIECE(YVOR,Y,126)_" (WWWFORM1) ************************** -->",YCR,YCR
      //<< . if $get(YTIMEFORM)'=1 xecute $piece(YVOR,Y,126)  ;EXE ZWISCHEN DEN BUTTON ;inter-
      if (mOp.NotEqual(m$.Fnc.$get(m$.var("YTIMEFORM")),1)) {
        m$.Cmd.Xecute(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),126));
      }
    }
    //<< 
    //<< if $piece(YVOR,Y,45)=$$$YES if YFOART'=5 if YFOART'="" write "<TD><IMG SRC="""_YGIF_"delimiter.gif""></TD>"
    if (mOp.Equal(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),45),include.COMSYS.$$$YES(m$))) {
      if (mOp.NotEqual(m$.var("YFOART").get(),5)) {
        if (mOp.NotEqual(m$.var("YFOART").get(),"")) {
          m$.Cmd.Write(mOp.Concat(mOp.Concat("<TD><IMG SRC=\"",m$.var("YGIF").get()),"delimiter.gif\"></TD>"));
        }
      }
    }
    //<< write YCR,"<TD> </TD>"
    m$.Cmd.Write(m$.var("YCR").get(),"<TD> </TD>");
    //<< write YCR,"</TR>"
    m$.Cmd.Write(m$.var("YCR").get(),"</TR>");
    //<< write YCR,"</TABLE>"
    m$.Cmd.Write(m$.var("YCR").get(),"</TABLE>");
    //<< set YTABLEANZ=$get(YTABLEANZ)-1
    YTABLEANZ.set(mOp.Subtract(m$.Fnc.$get(YTABLEANZ),1));
    //<< 
    //<< ;------------------------------------------------------------------------
    //<< ;MANUELLE OHNE BUTTON ;without
    //<< if +$piece(YVOR,Y,45)=$$$YES if $piece(YVOR,Y,13)'=$$$YES write YCR,"<HR>"
    if (mOp.Equal(mOp.Positive(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),45)),include.COMSYS.$$$YES(m$))) {
      if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),13),include.COMSYS.$$$YES(m$))) {
        m$.Cmd.Write(m$.var("YCR").get(),"<HR>");
      }
    }
    //<< if (YFOART=5) || (YFOART=8)  if $piece(YVOR,Y,10) =$$$YES write "</CENTER>"
    if ((mOp.Equal(m$.var("YFOART").get(),5)) || (mOp.Equal(m$.var("YFOART").get(),8))) {
      if (mOp.Equal(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),10),include.COMSYS.$$$YES(m$))) {
        m$.Cmd.Write("</CENTER>");
      }
    }
    //<< if '$$$WWW120PicturesAsButtons(YVOR) write YCR,"</TR>"
    if (mOp.Not(include.WWWConst.$$$WWW120PicturesAsButtons(m$,m$.var("YVOR")))) {
      m$.Cmd.Write(m$.var("YCR").get(),"</TR>");
    }
    //<< kill ^CacheTempToolbar(YUSER) ;SR18053
    m$.var("^CacheTempToolbar",m$.var("YUSER").get()).kill();
    //<< quit
    return;
  }

  //<< 
  //<< 
  //<< TranslationButton()
  public Object TranslationButton(Object ... _p) {
    //<< ;-------------------------------------------------------------------------------
    //<< ; Show the translation button
    //<< ;
    //<< ; Params:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 20-Dec-2006   JW      SR14235: Encapsulated. Added reference to child window
    //<< ;-------------------------------------------------------------------------------
    //<< new YKEY,strURL
    mVar YKEY = m$.var("YKEY");
    mVar strURL = m$.var("strURL");
    m$.newVar(YKEY,strURL);
    //<< 
    //<< $$$OpenTD($$$NO)
    include.WWWFORM.$$$OpenTD(m$,include.COMSYS.$$$NO(m$));
    //<< 
    //<< set strURL = YAKTION_"EP=WWWMANU&amp;YFORM="
    strURL.set(mOp.Concat(m$.var("YAKTION").get(),"EP=WWWMANU&amp;YFORM="));
    //<< 
    //<< ; Link to REPLanguage for reporting forms
    //<< if $extract(YFORM,1,6)'="REPRUN" {
    if (mOp.NotEqual(m$.Fnc.$extract(m$.var("YFORM").get(),1,6),"REPRUN")) {
      //<< $$$Append(strURL,"WWWLNG&amp;YEXEC=D|^WWWLNG3(\'"_YFORM_"\')")
      include.COMSYSString.$$$Append(m$,strURL,mOp.Concat(mOp.Concat("WWWLNG&amp;YEXEC=D|^WWWLNG3(\\'",m$.var("YFORM").get()),"\\')"));
    }
    //<< } else {
    else {
      //<< $$$Append(strURL,"REPLanguage&amp;YEXEC=do|WriteLanguageTable^REPLanguage(\'"_$select($get(^CacheTempReport(YUSER,YFORM))="":YPARA,1:$get(^CacheTempReport(YUSER,YFORM)))_"\')")
      include.COMSYSString.$$$Append(m$,strURL,mOp.Concat(mOp.Concat("REPLanguage&amp;YEXEC=do|WriteLanguageTable^REPLanguage(\\'",m$.Fnc.$select(mOp.Equal(m$.Fnc.$get(m$.var("^CacheTempReport",m$.var("YUSER").get(),m$.var("YFORM").get())),""),m$.var("YPARA").get(),1,m$.Fnc.$get(m$.var("^CacheTempReport",m$.var("YUSER").get(),m$.var("YFORM").get())))),"\\')"));
    }
    //<< }
    //<< $$$Append(strURL,$$WWWCGI2^WWWCGI($$$YES))
    include.COMSYSString.$$$Append(m$,strURL,m$.fnc$("WWWCGI.WWWCGI2",include.COMSYS.$$$YES(m$)));
    //<< 
    //<< write "<A href='' onclick=""subWindow('"_strURL_"','LANGUAGE'); return false;"">"
    m$.Cmd.Write(mOp.Concat(mOp.Concat("<A href='' onclick=\"subWindow('",strURL.get()),"','LANGUAGE'); return false;\">"));
    //<< do StopButton^WWWFORMCOMMON("translation","text.gif","BUTTON_TRANSLATION")
    m$.Cmd.Do("WWWFORMCOMMON.StopButton","translation","text.gif","BUTTON_TRANSLATION");
    //<< write "</A>"
    m$.Cmd.Write("</A>");
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< CreatePopupShortcutsLink()
  public Object CreatePopupShortcutsLink(Object ... _p) {
    //<< ;-------------------------------------------------------------------------------
    //<< ;
    //<< ; Params:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 20-Nov-2007   shobby  SRBR014812: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new strURL,objWWW013,lstPopupForms,intLoop
    mVar strURL = m$.var("strURL");
    mVar objWWW013 = m$.var("objWWW013");
    mVar lstPopupForms = m$.var("lstPopupForms");
    mVar intLoop = m$.var("intLoop");
    m$.newVar(strURL,objWWW013,lstPopupForms,intLoop);
    //<< 
    //<< if YBED'="" {
    if (mOp.NotEqual(m$.var("YBED").get(),"")) {
      //<< set objWWW013     = $get(^WWW013(0,YBED,1))
      objWWW013.set(m$.Fnc.$get(m$.var("^WWW013",0,m$.var("YBED").get(),1)));
      //<< set lstPopupForms = $$$WWW013PopupShortcuts(objWWW013)
      lstPopupForms.set(include.WWWConst.$$$WWW013PopupShortcuts(m$,objWWW013));
      //<< for intLoop=1:1:$length(lstPopupForms,";") {
      for (intLoop.set(1);(mOp.LessOrEqual(intLoop.get(),m$.Fnc.$length(lstPopupForms.get(),";")));intLoop.set(mOp.Add(intLoop.get(),1))) {
        //<< if $piece(lstPopupForms,";",intLoop)'="" {
        if (mOp.NotEqual(m$.Fnc.$piece(lstPopupForms.get(),";",intLoop.get()),"")) {
          //<< set strURL = YAKTION_"EP=WWWFORM&YFORM="_$piece(lstPopupForms,";",intLoop)_"&YKEY=&YUSER="_YUSER_"&YBED="_YBED
          strURL.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(m$.var("YAKTION").get(),"EP=WWWFORM&YFORM="),m$.Fnc.$piece(lstPopupForms.get(),";",intLoop.get())),"&YKEY=&YUSER="),m$.var("YUSER").get()),"&YBED="),m$.var("YBED").get()));
          //<< $$$OpenTD($$$NO)
          include.WWWFORM.$$$OpenTD(m$,include.COMSYS.$$$NO(m$));
          //<< write "<A onClick="""
          m$.Cmd.Write("<A onClick=\"");
          //<< write " window.open('"_strURL_"' ,'Parameter',''); "
          m$.Cmd.Write(mOp.Concat(mOp.Concat(" window.open('",strURL.get()),"' ,'Parameter',''); "));
          //<< write """>"
          m$.Cmd.Write("\">");
          //<< do StopButton^WWWFORMCOMMON($piece(lstPopupForms,";",intLoop),"open.gif","BUTTON_POPUP_"_intLoop)
          m$.Cmd.Do("WWWFORMCOMMON.StopButton",m$.Fnc.$piece(lstPopupForms.get(),";",intLoop.get()),"open.gif",mOp.Concat("BUTTON_POPUP_",intLoop.get()));
          //<< write "</A>"
          m$.Cmd.Write("</A>");
          //<< write "</TD>"
          m$.Cmd.Write("</TD>");
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
}
