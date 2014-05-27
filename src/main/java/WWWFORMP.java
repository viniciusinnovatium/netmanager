//*****************************************************************************
//** TASC - ALPHALINC - MAC WWWFORMP
//** Innovatium Systems - Code Converter - v1.27
//** 2014-05-22 00:14:49
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
//<< #include WWWConst
import include.WWWConst;

//<< WWWFORMP
public class WWWFORMP extends mClass {

  public void main() {
    _WWWFORMP();
  }

  public void _WWWFORMP() {
    //<< ;-------------------------------------------------------------------------------
    //<< ; Description of Function :
    //<< ;       Display Primary Keys
    //<< ;
    //<< ; Called By : RUECK^WWWFORM  [if (YFOART=1) || (YFOART=3)]
    //<< ;             COM.fwk.www.ui.FormDataFieldsUI :: show
    //<< ;
    //<< ; ByRef :
    //<< ;
    //<< ;
    //<< ; Returns :
    //<< ;
    //<< ;
    //<< ; History :
    //<< ; 09-Nov-2010   GRF     SR17243: Doco; macros; remove duplicated test
    //<< ; 20-Oct-2008   GRF     SR12505: "Don't Allow Characters" over-ride
    //<< ; 08.09.2004    FIS     Customise Executable Calls for Keys
    //<< ; 28,11,2003    TYBD
    //<< ; 05.09.2003    TYBD
    //<< ; 05.08.1997    DT      (C) BY DITMAR TYBUSSEK
    //<< ;-------------------------------------------------------------------------------
    //<< new YI,YPRIM,YA,YLFN
    mVar YI = m$.var("YI");
    mVar YPRIM = m$.var("YPRIM");
    mVar YA = m$.var("YA");
    mVar YLFN = m$.var("YLFN");
    m$.newVar(YI,YPRIM,YA,YLFN);
    //<< 
    //<< quit:YFORM=""
    if (mOp.Equal(m$.var("YFORM").get(),"")) {
      return;
    }
    //<< 
    //<< if $$$WWW120CreateFormAutomatically($get(^WWW120(0,YFORM,1)))'=$$$YES if '$data(^WWW121(0,YFORM)) do  quit
    if (mOp.NotEqual(include.WWWConst.$$$WWW120CreateFormAutomatically(m$,m$.Fnc.$get(m$.var("^WWW120",0,m$.var("YFORM").get(),1))),include.COMSYS.$$$YES(m$))) {
      if (mOp.Not(m$.Fnc.$data(m$.var("^WWW121",0,m$.var("YFORM").get())))) {
        //<< . if YKEY'="" set YFKEY=""                ;NEUFESTLEGEN FIXKEY
        if (mOp.NotEqual(m$.var("YKEY").get(),"")) {
          mVar YFKEY = m$.var("YFKEY");
          YFKEY.set("");
        }
        //<< . if YKEY="" if YFKEY'="" set YKEY=YFKEY  ;FÜR NEU BEI UNTERFORMULAREN ;to recent next to
        if (mOp.Equal(m$.var("YKEY").get(),"")) {
          if (mOp.NotEqual(m$.var("YFKEY").get(),"")) {
            mVar YKEY = m$.var("YKEY");
            YKEY.set(m$.var("YFKEY").get());
          }
        }
        //<< .;if YFOART=3 if '$data(^WWW121(0,YFORM)) do ^WWWFORM3     ; SR17243
        //<< . if YFOART=3 do ^WWWFORM3                ; Form Type 3 : GRID - no keys
        if (mOp.Equal(m$.var("YFOART").get(),3)) {
          m$.Cmd.Do("WWWFORM3.main");
        }
        //<< . write YCR,"<INPUT TYPE=HIDDEN NAME=""Y"_YFORM_"P1"" VALUE="""_YKEY_""">"
        m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<INPUT TYPE=HIDDEN NAME=\"Y",m$.var("YFORM").get()),"P1\" VALUE=\""),m$.var("YKEY").get()),"\">"));
        return;
      }
    }
    //<< 
    //<< ;---------------------------------------
    //<< 
    //<< if $piece($get(^WWW121(0,YFORM,1,1)),Y,16)="" set YFKEY = ""       ; $$$WWW121FixedInputForHiddenField()
    if (mOp.Equal(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW121",0,m$.var("YFORM").get(),1,1)),m$.var("Y").get(),16),"")) {
      mVar YFKEY = m$.var("YFKEY");
      YFKEY.set("");
    }
    //<< if YKEY'="" set YFKEY = ""                ;NEUFESTLEGEN FIXKEY
    if (mOp.NotEqual(m$.var("YKEY").get(),"")) {
      mVar YFKEY = m$.var("YFKEY");
      YFKEY.set("");
    }
    //<< if YKEY="" if YFKEY'="" set YKEY = YFKEY  ;FÜR NEU BEI UNTERFORMULAREN ;to recent next to
    if (mOp.Equal(m$.var("YKEY").get(),"")) {
      if (mOp.NotEqual(m$.var("YFKEY").get(),"")) {
        mVar YKEY = m$.var("YKEY");
        YKEY.set(m$.var("YFKEY").get());
      }
    }
    //<< 
    //<< if '$data(YA) set YA = ""
    if (mOp.Not(m$.Fnc.$data(YA))) {
      YA.set("");
    }
    //<< set YART = "P"  ;P=PRIMÄR,D=DATENFELD,M=MANUELLE,L=LISTGENERATOR
    mVar YART = m$.var("YART");
    YART.set("P");
    //<< 
    //<< set YLFN = ""
    YLFN.set("");
    //<< for  set YLFN = $order(^WWW121(0,YFORM,YLFN)) quit:YLFN=""  do
    for (;true;) {
      YLFN.set(m$.Fnc.$order(m$.var("^WWW121",0,m$.var("YFORM").get(),YLFN.get())));
      if (mOp.Equal(YLFN.get(),"")) {
        break;
      }
      //<< . set YSATZ = $get(^WWW121(0,YFORM,YLFN,1))
      mVar YSATZ = m$.var("YSATZ");
      YSATZ.set(m$.Fnc.$get(m$.var("^WWW121",0,m$.var("YFORM").get(),YLFN.get(),1)));
      //<< . if $data(^WWW121D(0,YFORM,YLFN,YM,1)) do             ; Customise Executable Calls for Keys
      if (mOp.Logical(m$.Fnc.$data(m$.var("^WWW121D",0,m$.var("YFORM").get(),YLFN.get(),m$.var("YM").get(),1)))) {
        //<< . . new YSATZ1
        mVar YSATZ1 = m$.var("YSATZ1");
        m$.newVar(YSATZ1);
        //<< . . set YSATZ1 = $get(^WWW121D(0,YFORM,YLFN,YM,1))
        YSATZ1.set(m$.Fnc.$get(m$.var("^WWW121D",0,m$.var("YFORM").get(),YLFN.get(),m$.var("YM").get(),1)));
        //<< . . if $$$WWW121DDontAllowCharacters(YSATZ1) '="" set $$$WWW121DontAllowChars(YSATZ) = $$$WWW121DDontAllowCharacters(YSATZ1)
        if (mOp.NotEqual(include.WWWConst.$$$WWW121DDontAllowCharacters(m$,YSATZ1),"")) {
          include.WWWConst.$$$WWW121DontAllowCharsSet(m$,YSATZ,include.WWWConst.$$$WWW121DDontAllowCharacters(m$,YSATZ1));
        }
        //<< . . if $piece(YSATZ1,Y,92)'="" set $piece(YSATZ,Y,92) = $piece(YSATZ1,Y,92)   ; $$$WWW121ExecuteOnFormStartBeforeD()
        if (mOp.NotEqual(m$.Fnc.$piece(YSATZ1.get(),m$.var("Y").get(),92),"")) {
          m$.pieceVar(YSATZ,m$.var("Y").get(),92).set(m$.Fnc.$piece(YSATZ1.get(),m$.var("Y").get(),92));
        }
        //<< . . if $piece(YSATZ1,Y,99)'="" set $piece(YSATZ,Y,99) = $piece(YSATZ1,Y,99)   ; $$$WWW121DExecuteInDataField() [No WWW121 definition]
        if (mOp.NotEqual(m$.Fnc.$piece(YSATZ1.get(),m$.var("Y").get(),99),"")) {
          m$.pieceVar(YSATZ,m$.var("Y").get(),99).set(m$.Fnc.$piece(YSATZ1.get(),m$.var("Y").get(),99));
        }
        //<< . . if $piece(YSATZ1,Y,97)'="" set $piece(YSATZ,Y,97) = $piece(YSATZ1,Y,97)   ; $$$WWW121ExecuteOnFormConstruct()
        if (mOp.NotEqual(m$.Fnc.$piece(YSATZ1.get(),m$.var("Y").get(),97),"")) {
          m$.pieceVar(YSATZ,m$.var("Y").get(),97).set(m$.Fnc.$piece(YSATZ1.get(),m$.var("Y").get(),97));
        }
      }
      //<< . ;
      //<< . set YBBN=YLFN
      mVar YBBN = m$.var("YBBN");
      YBBN.set(YLFN.get());
      //<< . do ^WWWFORM9
      m$.Cmd.Do("WWWFORM9.main");
      //<< . if $piece(YVOR,Y,2)'=3 do      ; (YFOART)  ; Display keys if not a Grid
      if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),2),3)) {
        do {
          //<< . . new LASTHIDD,LFN2
          mVar LASTHIDD = m$.var("LASTHIDD");
          mVar LFN2 = m$.var("LFN2");
          m$.newVar(LASTHIDD,LFN2);
          //<< . . set LASTHIDD = 0
          LASTHIDD.set(0);
          //<< . . ;
          //<< . . set LFN2 = $order(^WWW121(0,YFORM,YLFN))
          LFN2.set(m$.Fnc.$order(m$.var("^WWW121",0,m$.var("YFORM").get(),YLFN.get())));
          //<< . . if LFN2'="" if $piece($get(^WWW121(0,YFORM,LFN2,1)),Y,4)=2 quit  ;KEIN ENDE ;no termination
          if (mOp.NotEqual(LFN2.get(),"")) {
            if (mOp.Equal(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW121",0,m$.var("YFORM").get(),LFN2.get(),1)),m$.var("Y").get(),4),2)) {
              break;
            }
          }
          //<< . . ;
          //<< . . if YLFN=$order(^WWW121(0,YFORM,""),-1) if $piece($get(^WWW121(0,YFORM,YLFN,1)),Y,16)'="" set LASTHIDD=1 if YLFN'=$order(^WWW121(0,YFORM,"")) if $order(^WWW121(0,YFORM,YLFN))'="" quit  ; WENNN MEHRERE UNSICHTBARE FELDER VON WAC
          if (mOp.Equal(YLFN.get(),m$.Fnc.$order(m$.var("^WWW121",0,m$.var("YFORM").get(),""),mOp.Negative(1)))) {
            if (mOp.NotEqual(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW121",0,m$.var("YFORM").get(),YLFN.get(),1)),m$.var("Y").get(),16),"")) {
              LASTHIDD.set(1);
              if (mOp.NotEqual(YLFN.get(),m$.Fnc.$order(m$.var("^WWW121",0,m$.var("YFORM").get(),"")))) {
                if (mOp.NotEqual(m$.Fnc.$order(m$.var("^WWW121",0,m$.var("YFORM").get(),YLFN.get())),"")) {
                  break;
                }
              }
            }
          }
          //<< . . if $piece(YVOR,Y,66)=2 if ($get(YTYPE)="HIDDEN") || ($get(YHID)=1) || ($get(YTYP)=0) quit    ; WACH, BEI FORMS MIT MANUELLEN UND HIDDEN FELDERN
          if (mOp.Equal(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),66),2)) {
            if ((mOp.Equal(m$.Fnc.$get(m$.var("YTYPE")),"HIDDEN")) || (mOp.Equal(m$.Fnc.$get(m$.var("YHID")),1)) || (mOp.Equal(m$.Fnc.$get(m$.var("YTYP")),0))) {
              break;
            }
          }
          //<< . . if LASTHIDD'=1         if ($get(YTYPE)="HIDDEN") || ($get(YHID)=1) || ($get(YTYP)=0) quit
          if (mOp.NotEqual(LASTHIDD.get(),1)) {
            if ((mOp.Equal(m$.Fnc.$get(m$.var("YTYPE")),"HIDDEN")) || (mOp.Equal(m$.Fnc.$get(m$.var("YHID")),1)) || (mOp.Equal(m$.Fnc.$get(m$.var("YTYP")),0))) {
              break;
            }
          }
          //<< . . write YCR,"</TR>",YCR               ; ABSCHLUSS FELD ;field
          m$.Cmd.Write(m$.var("YCR").get(),"</TR>",m$.var("YCR").get());
          //<< . . if $piece(YVOR,Y,44)'=$$$YES do
          if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),44),include.COMSYS.$$$YES(m$))) {
            //<< . . . write YCR,"</TABLE>",YCR          ; ABSCHLUSS FORMAT
            m$.Cmd.Write(m$.var("YCR").get(),"</TABLE>",m$.var("YCR").get());
            //<< . . . set YTABLEANZ = $get(YTABLEANZ)-1
            mVar YTABLEANZ = m$.var("YTABLEANZ");
            YTABLEANZ.set(mOp.Subtract(m$.Fnc.$get(m$.var("YTABLEANZ")),1));
          }
        } while (false);
      }
    }
    //<< 
    //<< ;ZEITABHÄNIGE VORABERFASSUNG VON DATEN = GÜLTIG AB DATUM ;valuable Confirm. Date
    //<< if $get(YTIMEFORM)=1 do
    if (mOp.Equal(m$.Fnc.$get(m$.var("YTIMEFORM")),1)) {
      //<< . set YSATZ = ""
      mVar YSATZ = m$.var("YSATZ");
      YSATZ.set("");
      //<< . set YBBN  = $order(^WWW121(0,YFORM,""),-1)+1
      mVar YBBN = m$.var("YBBN");
      YBBN.set(mOp.Add(m$.Fnc.$order(m$.var("^WWW121",0,m$.var("YFORM").get(),""),mOp.Negative(1)),1));
      //<< . set YLFN  = YBBN
      YLFN.set(YBBN.get());
      //<< . do ^WWWFORM9
      m$.Cmd.Do("WWWFORM9.main");
      //<< . write YCR,"</TR>",YCR   ;ABSCHLUSS FELD ;field
      m$.Cmd.Write(m$.var("YCR").get(),"</TR>",m$.var("YCR").get());
      //<< . if $piece(YVOR,Y,44)'=$$$YES do
      if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),44),include.COMSYS.$$$YES(m$))) {
        //<< . . write YCR,"</TABLE>",YCR   ;ABSCHLUSS FORMAT
        m$.Cmd.Write(m$.var("YCR").get(),"</TABLE>",m$.var("YCR").get());
        //<< . . set YTABLEANZ = $get(YTABLEANZ)-1
        mVar YTABLEANZ = m$.var("YTABLEANZ");
        YTABLEANZ.set(mOp.Subtract(m$.Fnc.$get(m$.var("YTABLEANZ")),1));
      }
    }
    //<< 
    //<< quit
    return;
  }

//<< 
//<< 
}
