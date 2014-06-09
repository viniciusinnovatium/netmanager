//*****************************************************************************
//** TASC - ALPHALINC - MAC WWWDOCUMENT
//** Innovatium Systems - Code Converter - v1.30
//** 2014-06-05 20:50:12
//*****************************************************************************

import mLibrary.*;

//<< #include WWWConst
import include.WWWConst;
//TODO REVISAR IMPORT CONVERSOR import COMSYS;
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

//<< WWWDOCUMENT ;WWWDOCUMENT;DT;DOCUMENTANZEIGE;26.01.2001
public class WWWDOCUMENT extends mClass {

  public void main() {
    _WWWDOCUMENT();
  }

  public void _WWWDOCUMENT() {
    //<< ;/------------------------------------------------------------------\
    //<< ;| Description of Function :
    //<< ;|      DOCUMENTANZEIGE
    //<< ;|
    //<< ;| Inputs :
    //<< ;|
    //<< ;|
    //<< ;| ByRef :
    //<< ;|
    //<< ;|
    //<< ;| Returns :
    //<< ;|
    //<< ;|
    //<< ;| History :
    //<< ;|
    //<< ;| 18-Sep-2008  shobby  BR014966: Support language texts for customisation help text.
    //<< ;| DT   26.01.2001
    //<< ;|
    //<< ;\------------------------------------------------------------------/
    //<< ;
    //<< ;als unter window ;when under
    //<< NEW TEXT,YDATEI,YKEY,YLFN,YTEXT,YI
    mVar TEXT = m$.var("TEXT");
    mVar YDATEI = m$.var("YDATEI");
    mVar YKEY = m$.var("YKEY");
    mVar YLFN = m$.var("YLFN");
    mVar YTEXT = m$.var("YTEXT");
    mVar YI = m$.var("YI");
    m$.newVar(TEXT,YDATEI,YKEY,YLFN,YTEXT,YI);
    //<< 
    //<< SET YKEY="",YFKEY=""
    YKEY.set("");
    mVar YFKEY = m$.var("YFKEY");
    YFKEY.set("");
    //<< SET YDATA=$GET(%(YQUERY,"YDATA"))  ;LAUFENDE NR
    mVar YDATA = m$.var("YDATA");
    YDATA.set(m$.Fnc.$get(m$.var("%",m$.var("YQUERY").get(),"YDATA")));
    //<< SET YDATEI=$PIECE(YDATA,"|",1)
    YDATEI.set(m$.Fnc.$piece(YDATA.get(),"|",1));
    //<< SET YKEY=$PIECE(YDATA,"|",2)
    YKEY.set(m$.Fnc.$piece(YDATA.get(),"|",2));
    //<< SET YLFN=$PIECE(YDATA,"|",3)
    YLFN.set(m$.Fnc.$piece(YDATA.get(),"|",3));
    //<< DO ^WWWLESE(YDATEI,YKEY)
    m$.Cmd.Do("WWWLESE.main",YDATEI.get(),YKEY.get());
    //<< WRITE YCR
    m$.Cmd.Write(m$.var("YCR").get());
    //<< ;WRITE "<TABLE BORDER=0>"
    //<< ;WRITE YCR
    //<< ;WRITE "<TR><TD ALIGN=LEFT VALIGN=TOP>"
    //<< ;WRITE YCR
    //<< ;WRITE "<FONT SIZE=2>"
    //<< ;WRITE YCR
    //<< SET YTEXT=$$$Text($PIECE($G(YFELD),Y,$G(YLFN))) ;BR014966
    YTEXT.set(include.COMSYS.$$$Text(m$,m$.Fnc.$piece(m$.Fnc.$get(m$.var("YFELD")),m$.var("Y").get(),m$.Fnc.$get(YLFN))));
    //<< ;FOR YI=1:1 SET YTEXT(1)=$PIECE(YTEXT,"|",YI) QUIT:$PIECE(YTEXT,"|",YI,9999)=""  DO
    //<< ;.WRITE YTEXT(1)
    //<< ;.WRITE "<br>"
    //<< ;.WRITE YCR
    //<< ;.QUIT
    //<< NEW YCORR
    mVar YCORR = m$.var("YCORR");
    m$.newVar(YCORR);
    //<< ;IF +$$^WWWBEDBER(YBED)=1 SET YCORR=1  ;FIS;13.07.04;25386
    //<< IF +$$$WWW012enableSpellChecking($GET(^WWW012(0,YM,1)))=1 IF $DATA(^WWWDICTIONARY01(0)) SET YCORR=1     ;BEC;15.10.04;26588;PRÜFUNG DES PARAMETERS
    if (mOp.Equal(mOp.Positive(include.WWWConst.$$$WWW012enableSpellChecking(m$,m$.Fnc.$get(m$.var("^WWW012",0,m$.var("YM").get(),1)))),1)) {
      if (mOp.Logical(m$.Fnc.$data(m$.var("^WWWDICTIONARY01",0)))) {
        YCORR.set(1);
      }
    }
    //<< DO TEXT^WWWHELP()    ;BEC;25189;25.02.04 // BR014099
    m$.Cmd.Do("WWWHELP.TEXT");
    //<< ;WRITE YCR
    //<< ;WRITE "</TD></TR>"
    //<< ;WRITE "</TABLE>"
    //<< ;WRITE YCR
    //<< QUIT
    return;
  }

  //<< 
  //<< SAVE ;SAVE START MASKE ;take-off mask
  public void SAVE() {
    //<< SET %(YQUERY,"YKEY")=""
    m$.var("%",m$.var("YQUERY").get(),"YKEY").set("");
    //<< SET YDATA=$GET(%(YQUERY,"YDATA"))
    mVar YDATA = m$.var("YDATA");
    YDATA.set(m$.Fnc.$get(m$.var("%",m$.var("YQUERY").get(),"YDATA")));
    //<< SET %(YQUERY,"YDATA")=YDATA
    m$.var("%",m$.var("YQUERY").get(),"YDATA").set(YDATA.get());
    //<< DO ^WWWFORM
    m$.Cmd.Do("WWWFORM.main");
    //<< QUIT
    return;
  }

//<< 
}
