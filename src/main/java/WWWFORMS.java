//*****************************************************************************
//** TASC - ALPHALINC - MAC WWWFORMS
//** Innovatium Systems - Code Converter - v1.29
//** 2014-06-03 20:54:44
//*****************************************************************************

import mLibrary.*;

//<< #include WWWConst
import include.WWWConst;
import include.COMSYS;

//<< WWWFORMS
public class WWWFORMS extends mClass {

  public void main() {
    _WWWFORMS();
  }

  public void _WWWFORMS() {
    //<< ;-------------------------------------------------------------------------------
    //<< ;       SUCHEN DATENSATZ NEXT,FIRST,LAST..
    //<< ;
    //<< ;   YKEY = ALTER UND NEUER KEY ;governor And KEY
    //<< ;   YDATEI = DATEINAME ;file name
    //<< ;   YFKEY  = FESTE PRIMÄRSCHLÜSSEL
    //<< ;   YAUSW  = VARIABLE PRIMÄRSCHLÜSSEL (AB KEY)
    //<< ;   YRICHT = 1 UP ; 2 DOWN                  RICHTUNG  ;trend
    //<< ;   YSORT  = SORTIERSCHLUESSEL
    //<< ;   YANZ   = ANZAHL DER GESUCHTEN WERTE ;Number the
    //<< ;   YKOMP  = 1 = KOMPLETTER KEY; 2 LETZTER KEY FEHLT(GRID-SUCHE)
    //<< ;   YFIND  = ZU FINDENDER DATENSATZ ;within data record
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
    //<< ; 30-Aug-2010   GRF     Quits
    //<< ; 25.05.1998    DT
    //<< ;-------------------------------------------------------------------------------
    //<< IF +$$$WWW120IndexForNextDataRecord(YVOR)=0 IF YDATEI'="" IF '$DATA(^WWW002(0,YDATEI)) SET $$$WWW120IndexForNextDataRecord(YVOR)=1  ;KEIN PRIMÄRSCHL DANN SORT #1 ;no
    if (mOp.Equal(mOp.Positive(include.WWWConst.$$$WWW120IndexForNextDataRecord(m$,m$.var("YVOR"))),0)) {
      if (mOp.NotEqual(m$.var("YDATEI").get(),"")) {
        if (mOp.Not(m$.Fnc.$data(m$.var("^WWW002",0,m$.var("YDATEI").get())))) {
          include.WWWConst.$$$WWW120IndexForNextDataRecordSet(m$,m$.var("YVOR"),1);
        }
      }
    }
    //<< DO SORT  ;I +$P(YVOR,Y,49)'=0 DO SORT   ;WENN SUCHE NACH SORTIERSCHLÜSSEL
    m$.Cmd.Do("SORT");
    //<< QUIT
    return;
  }

  //<< 
  //<< KEY ;SORTIERT NACH KEY  (EINSPRUNG AUCH AUS ANDEREN ROUTINEN) ;within KEY too out of
  public void KEY() {
    //<< IF YKEY="" IF $GET(YKEY1)'="" SET YKEY=YKEY1  ;WENN ANZEIGE=LEER DURCH SAVE ODER KILL ;when trans- Or
    if (mOp.Equal(m$.var("YKEY").get(),"")) {
      if (mOp.NotEqual(m$.Fnc.$get(m$.var("YKEY1")),"")) {
        mVar YKEY = m$.var("YKEY");
        YKEY.set(m$.var("YKEY1").get());
      }
    }
    //<< IF YDATEI'="" DO
    if (mOp.NotEqual(m$.var("YDATEI").get(),"")) {
      //<< . SET YDATEIX=YDATEI
      mVar YDATEIX = m$.var("YDATEIX");
      YDATEIX.set(m$.var("YDATEI").get());
      //<< . SET YDATA=$GET(^WWW001(0,YDATEI,1))
      mVar YDATA = m$.var("YDATA");
      YDATA.set(m$.Fnc.$get(m$.var("^WWW001",0,m$.var("YDATEI").get(),1)));
      //<< . IF $PIECE(YDATA,Y,12)'="" IF $PIECE(YDATA,Y,13)'="" DO  ;UCI UND VOL ;UCI And
      if (mOp.NotEqual(m$.Fnc.$piece(YDATA.get(),m$.var("Y").get(),12),"")) {
        if (mOp.NotEqual(m$.Fnc.$piece(YDATA.get(),m$.var("Y").get(),13),"")) {
          //<< . . SET YDATEIX="["_""""_$PIECE(YDATA,Y,12)_""""_","_""""_$PIECE(YDATA,Y,13)_""""_"]"_YDATEI
          YDATEIX.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("[","\""),m$.Fnc.$piece(YDATA.get(),m$.var("Y").get(),12)),"\""),","),"\""),m$.Fnc.$piece(YDATA.get(),m$.var("Y").get(),13)),"\""),"]"),m$.var("YDATEI").get()));
        }
      }
      //<< . ;
      //<< . SET YMAXKEY=+$ORDER(^WWW002(0,YDATEI,""),-1)
      mVar YMAXKEY = m$.var("YMAXKEY");
      YMAXKEY.set(mOp.Positive(m$.Fnc.$order(m$.var("^WWW002",0,m$.var("YDATEI").get(),""),mOp.Negative(1))));
      //<< . IF YMAXKEY=0 SET YMAXKEY=1
      if (mOp.Equal(YMAXKEY.get(),0)) {
        YMAXKEY.set(1);
      }
      //<< . IF YRICHT="NEXT" IF YKEY=""             SET YRICHT="FIRST"
      if (mOp.Equal(m$.var("YRICHT").get(),"NEXT")) {
        if (mOp.Equal(m$.var("YKEY").get(),"")) {
          mVar YRICHT = m$.var("YRICHT");
          YRICHT.set("FIRST");
        }
      }
      //<< . IF YRICHT="BACK" IF YFKEY="" IF YKEY="" SET YRICHT="LAST"
      if (mOp.Equal(m$.var("YRICHT").get(),"BACK")) {
        if (mOp.Equal(m$.var("YFKEY").get(),"")) {
          if (mOp.Equal(m$.var("YKEY").get(),"")) {
            mVar YRICHT = m$.var("YRICHT");
            YRICHT.set("LAST");
          }
        }
      }
      //<< . IF YRICHT="FIRST" DO  ;ERSTEN DATENSATZ SUCHEN ;data record seek
      if (mOp.Equal(m$.var("YRICHT").get(),"FIRST")) {
        //<< . . NEW YNKEY,YI,YSKEY
        mVar YNKEY = m$.var("YNKEY");
        mVar YI = m$.var("YI");
        mVar YSKEY = m$.var("YSKEY");
        m$.newVarBlock(2,YNKEY,YI,YSKEY);
        //<< . . SET YNKEY="",YNKEY(1)=""
        YNKEY.set("");
        YNKEY.var(1).set("");
        //<< . . SET YSKEY=YKEY
        YSKEY.set(m$.var("YKEY").get());
        //<< . . FOR YI=1:1:(YMAXKEY-1) DO  IF (YMAXKEY-1)'=YI SET YNKEY=YNKEY_","
        for (YI.set(1);(mOp.LessOrEqual(YI.get(),(mOp.Subtract(YMAXKEY.get(),1))));YI.set(mOp.Add(YI.get(),1))) {
          do {
            //<< . . . IF $PIECE(YFKEY,",",YI)'="" SET YNKEY=YNKEY_""""_$PIECE(YFKEY,",",YI)_"""" SET YNKEY(1)=YNKEY(1)_""""_$PIECE(YFKEY,",",YI)_"""" QUIT
            if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YFKEY").get(),",",YI.get()),"")) {
              YNKEY.set(mOp.Concat(mOp.Concat(mOp.Concat(YNKEY.get(),"\""),m$.Fnc.$piece(m$.var("YFKEY").get(),",",YI.get())),"\""));
              YNKEY.var(1).set(mOp.Concat(mOp.Concat(mOp.Concat(YNKEY.var(1).get(),"\""),m$.Fnc.$piece(m$.var("YFKEY").get(),",",YI.get())),"\""));
              break;
            }
            //<< . . . IF $PIECE(YKEY,",",YI)'=""  SET YNKEY=YNKEY_""""_$PIECE(YKEY,",",YI)_"""" QUIT
            if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YKEY").get(),",",YI.get()),"")) {
              YNKEY.set(mOp.Concat(mOp.Concat(mOp.Concat(YNKEY.get(),"\""),m$.Fnc.$piece(m$.var("YKEY").get(),",",YI.get())),"\""));
              break;
            }
            //<< . . . IF $PIECE(YKEY,",",YI)=""   SET YNKEY=YNKEY_""""_"-1"_""""                QUIT
            if (mOp.Equal(m$.Fnc.$piece(m$.var("YKEY").get(),",",YI.get()),"")) {
              YNKEY.set(mOp.Concat(mOp.Concat(mOp.Concat(YNKEY.get(),"\""),"-1"),"\""));
              break;
            }
          } while (false);
          if (mOp.NotEqual((mOp.Subtract(YMAXKEY.get(),1)),YI.get())) {
            YNKEY.set(mOp.Concat(YNKEY.get(),","));
          }
        }
        //<< . . ;
        //<< . . IF YNKEY'="" SET YKEY=$QUERY(@("^"_YDATEIX_"("_$$^WWWYM(YDATEI,1)_YNKEY_","_""""_"-1"_""""_")")) SET YKEY=$PIECE($PIECE(YKEY,"(",2,99),",",2,YMAXKEY+1)
        if (mOp.NotEqual(YNKEY.get(),"")) {
          mVar YKEY = m$.var("YKEY");
          YKEY.set(m$.Fnc.$query(m$.indirectVar((mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("^",YDATEIX.get()),"("),m$.fnc$("WWWYM.main",m$.var("YDATEI").get(),1)),YNKEY.get()),","),"\""),"-1"),"\""),")")))));
          YKEY.set(m$.Fnc.$piece(m$.Fnc.$piece(YKEY.get(),"(",2,99),",",2,mOp.Add(YMAXKEY.get(),1)));
        }
        //<< . . IF YNKEY=""  SET YKEY=$QUERY(@("^"_YDATEIX_"("_$$^WWWYM(YDATEI,1)_""""_"-1"_""""_")"))           SET YKEY=$PIECE($PIECE(YKEY,"(",2,99),",",2,YMAXKEY+1)
        if (mOp.Equal(YNKEY.get(),"")) {
          mVar YKEY = m$.var("YKEY");
          YKEY.set(m$.Fnc.$query(m$.indirectVar((mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("^",YDATEIX.get()),"("),m$.fnc$("WWWYM.main",m$.var("YDATEI").get(),1)),"\""),"-1"),"\""),")")))));
          YKEY.set(m$.Fnc.$piece(m$.Fnc.$piece(YKEY.get(),"(",2,99),",",2,mOp.Add(YMAXKEY.get(),1)));
        }
      }
      m$.restoreVarBlock(2);
      //<< . ;
      //<< . IF YRICHT="NEXT" DO
      if (mOp.Equal(m$.var("YRICHT").get(),"NEXT")) {
        //<< . . NEW YNKEY,YI,YSKEY
        mVar YNKEY = m$.var("YNKEY");
        mVar YI = m$.var("YI");
        mVar YSKEY = m$.var("YSKEY");
        m$.newVarBlock(2,YNKEY,YI,YSKEY);
        //<< . . SET YNKEY="",YNKEY(1)=""
        YNKEY.set("");
        YNKEY.var(1).set("");
        //<< . . SET YSKEY=YKEY
        YSKEY.set(m$.var("YKEY").get());
        //<< . . FOR YI=1:1:YMAXKEY DO  IF YMAXKEY'=YI SET YNKEY=YNKEY_","
        for (YI.set(1);(mOp.LessOrEqual(YI.get(),YMAXKEY.get()));YI.set(mOp.Add(YI.get(),1))) {
          do {
            //<< . . . IF $PIECE(YFKEY,",",YI)'="" SET YNKEY=YNKEY_""""_$PIECE(YFKEY,",",YI)_"""" SET YNKEY(1)=YNKEY(1)_""""_$PIECE(YFKEY,",",YI)_"""" QUIT
            if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YFKEY").get(),",",YI.get()),"")) {
              YNKEY.set(mOp.Concat(mOp.Concat(mOp.Concat(YNKEY.get(),"\""),m$.Fnc.$piece(m$.var("YFKEY").get(),",",YI.get())),"\""));
              YNKEY.var(1).set(mOp.Concat(mOp.Concat(mOp.Concat(YNKEY.var(1).get(),"\""),m$.Fnc.$piece(m$.var("YFKEY").get(),",",YI.get())),"\""));
              break;
            }
            //<< . . . IF $PIECE(YKEY,",",YI)'=""  SET YNKEY=YNKEY_""""_$PIECE(YKEY,",",YI)_"""" QUIT
            if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YKEY").get(),",",YI.get()),"")) {
              YNKEY.set(mOp.Concat(mOp.Concat(mOp.Concat(YNKEY.get(),"\""),m$.Fnc.$piece(m$.var("YKEY").get(),",",YI.get())),"\""));
              break;
            }
            //<< . . . IF $PIECE(YKEY,",",YI)=""   SET YNKEY=YNKEY_""""_"-1"_""""                QUIT
            if (mOp.Equal(m$.Fnc.$piece(m$.var("YKEY").get(),",",YI.get()),"")) {
              YNKEY.set(mOp.Concat(mOp.Concat(mOp.Concat(YNKEY.get(),"\""),"-1"),"\""));
              break;
            }
          } while (false);
          if (mOp.NotEqual(YMAXKEY.get(),YI.get())) {
            YNKEY.set(mOp.Concat(YNKEY.get(),","));
          }
        }
        //<< . . ;
        //<< . . IF $PIECE(YDATA,Y,8)'=4 IF YKEY'="" SET YKEY=$QUERY(@("^"_YDATEIX_"("_$$^WWWYM(YDATEI,1)_YNKEY_","_""""_$CHAR(255)_""""_")")) IF '$FIND($TRANSLATE(YKEY,""""),$TRANSLATE(YFKEY,"""")_",") SET YKEY=""
        if (mOp.NotEqual(m$.Fnc.$piece(YDATA.get(),m$.var("Y").get(),8),4)) {
          if (mOp.NotEqual(m$.var("YKEY").get(),"")) {
            mVar YKEY = m$.var("YKEY");
            YKEY.set(m$.Fnc.$query(m$.indirectVar((mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("^",YDATEIX.get()),"("),m$.fnc$("WWWYM.main",m$.var("YDATEI").get(),1)),YNKEY.get()),","),"\""),m$.Fnc.$char(255)),"\""),")")))));
            if (mOp.Not(m$.Fnc.$find(m$.Fnc.$translate(YKEY.get(),"\""),mOp.Concat(m$.Fnc.$translate(m$.var("YFKEY").get(),"\""),",")))) {
              YKEY.set("");
            }
          }
        }
        //<< . . IF $PIECE(YDATA,Y,8)=4  IF YKEY'="" SET YKEY=$QUERY(@("^"_YDATEIX_"("_$$^WWWYM(YDATEI,1)_YNKEY_")")) IF YFKEY'="" IF '$FIND($TRANSLATE(YKEY,""""),$TRANSLATE(YFKEY,"""")_",") SET YKEY=""
        if (mOp.Equal(m$.Fnc.$piece(YDATA.get(),m$.var("Y").get(),8),4)) {
          if (mOp.NotEqual(m$.var("YKEY").get(),"")) {
            mVar YKEY = m$.var("YKEY");
            YKEY.set(m$.Fnc.$query(m$.indirectVar((mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("^",YDATEIX.get()),"("),m$.fnc$("WWWYM.main",m$.var("YDATEI").get(),1)),YNKEY.get()),")")))));
            if (mOp.NotEqual(m$.var("YFKEY").get(),"")) {
              if (mOp.Not(m$.Fnc.$find(m$.Fnc.$translate(YKEY.get(),"\""),mOp.Concat(m$.Fnc.$translate(m$.var("YFKEY").get(),"\""),",")))) {
                YKEY.set("");
              }
            }
          }
        }
        //<< . . IF YNKEY(1)'="" IF YKEY="" SET YKEY=$QUERY(@("^"_YDATEIX_"("_$$^WWWYM(YDATEI,1)_YNKEY(1)_")"))
        if (mOp.NotEqual(YNKEY.var(1).get(),"")) {
          if (mOp.Equal(m$.var("YKEY").get(),"")) {
            mVar YKEY = m$.var("YKEY");
            YKEY.set(m$.Fnc.$query(m$.indirectVar((mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("^",YDATEIX.get()),"("),m$.fnc$("WWWYM.main",m$.var("YDATEI").get(),1)),YNKEY.var(1).get()),")")))));
          }
        }
        //<< . . IF $PIECE(YDATA,Y,8)'=4    SET YKEY=$PIECE($PIECE(YKEY,"(",2),",",2,YMAXKEY+1)
        if (mOp.NotEqual(m$.Fnc.$piece(YDATA.get(),m$.var("Y").get(),8),4)) {
          mVar YKEY = m$.var("YKEY");
          YKEY.set(m$.Fnc.$piece(m$.Fnc.$piece(m$.var("YKEY").get(),"(",2),",",2,mOp.Add(YMAXKEY.get(),1)));
        }
        //<< . . IF $PIECE(YDATA,Y,8)=4     SET YKEY=$PIECE($PIECE(YKEY,"(",2),",",1,YMAXKEY+1)  ;OHNE MANDANT ;without Company
        if (mOp.Equal(m$.Fnc.$piece(YDATA.get(),m$.var("Y").get(),8),4)) {
          mVar YKEY = m$.var("YKEY");
          YKEY.set(m$.Fnc.$piece(m$.Fnc.$piece(m$.var("YKEY").get(),"(",2),",",1,mOp.Add(YMAXKEY.get(),1)));
        }
        //<< . . IF YFKEY'="" IF '$FIND($TRANSLATE(YKEY,""""),$TRANSLATE(YFKEY,"""")_",") SET YKEY=""
        if (mOp.NotEqual(m$.var("YFKEY").get(),"")) {
          if (mOp.Not(m$.Fnc.$find(m$.Fnc.$translate(m$.var("YKEY").get(),"\""),mOp.Concat(m$.Fnc.$translate(m$.var("YFKEY").get(),"\""),",")))) {
            mVar YKEY = m$.var("YKEY");
            YKEY.set("");
          }
        }
      }
      m$.restoreVarBlock(2);
      //<< . ;
      //<< . IF YRICHT="BACK" DO
      if (mOp.Equal(m$.var("YRICHT").get(),"BACK")) {
        //<< . . NEW YNKEY,YI,YSKEY
        mVar YNKEY = m$.var("YNKEY");
        mVar YI = m$.var("YI");
        mVar YSKEY = m$.var("YSKEY");
        m$.newVarBlock(2,YNKEY,YI,YSKEY);
        //<< . . SET YNKEY="",YNKEY(1)=""
        YNKEY.set("");
        YNKEY.var(1).set("");
        //<< . . FOR YI=1:1:YMAXKEY DO  QUIT:$PIECE(YKEY,",",YI)=""  IF YI'=YMAXKEY SET:$PIECE(YKEY,",",YI+1)'="" YNKEY=YNKEY_","
        for (YI.set(1);(mOp.LessOrEqual(YI.get(),YMAXKEY.get()));YI.set(mOp.Add(YI.get(),1))) {
          do {
            //<< . . . IF $PIECE(YFKEY,",",YI)'="" SET YNKEY=YNKEY_""""_$PIECE(YFKEY,",",YI)_"""" SET YNKEY(1)=YNKEY(1)_""""_$PIECE(YFKEY,",",YI)_"""" QUIT
            if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YFKEY").get(),",",YI.get()),"")) {
              YNKEY.set(mOp.Concat(mOp.Concat(mOp.Concat(YNKEY.get(),"\""),m$.Fnc.$piece(m$.var("YFKEY").get(),",",YI.get())),"\""));
              YNKEY.var(1).set(mOp.Concat(mOp.Concat(mOp.Concat(YNKEY.var(1).get(),"\""),m$.Fnc.$piece(m$.var("YFKEY").get(),",",YI.get())),"\""));
              break;
            }
            //<< . . . SET YNKEY=YNKEY_""""_$PIECE(YKEY,",",YI)_""""
            YNKEY.set(mOp.Concat(mOp.Concat(mOp.Concat(YNKEY.get(),"\""),m$.Fnc.$piece(m$.var("YKEY").get(),",",YI.get())),"\""));
          } while (false);
          if (mOp.Equal(m$.Fnc.$piece(m$.var("YKEY").get(),",",YI.get()),"")) {
            break;
          }
          if (mOp.NotEqual(YI.get(),YMAXKEY.get())) {
            if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YKEY").get(),",",mOp.Add(YI.get(),1)),"")) {
              YNKEY.set(mOp.Concat(YNKEY.get(),","));
            }
          }
        }
        //<< . . ;
        //<< . . IF $TRANSLATE(YNKEY,"""")'="" SET YKEY=$QUERY(@("^"_YDATEIX_"("_$$^WWWYM(YDATEI,1)_YNKEY_")"),-1) IF '$FIND($TRANSLATE(YKEY,""""),YFKEY) SET YKEY=""
        if (mOp.NotEqual(m$.Fnc.$translate(YNKEY.get(),"\""),"")) {
          mVar YKEY = m$.var("YKEY");
          YKEY.set(m$.Fnc.$query(m$.indirectVar((mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("^",YDATEIX.get()),"("),m$.fnc$("WWWYM.main",m$.var("YDATEI").get(),1)),YNKEY.get()),")"))),mOp.Negative(1)));
          if (mOp.Not(m$.Fnc.$find(m$.Fnc.$translate(YKEY.get(),"\""),m$.var("YFKEY").get()))) {
            YKEY.set("");
          }
        }
        //<< . . IF $TRANSLATE(YNKEY(1),"""")'="" IF YKEY="" SET YKEY=$QUERY(@("^"_YDATEIX_"("_$$^WWWYM(YDATEI,1)_YNKEY(1)_","_""""_$CHAR(255)_""""_")"),-1)
        if (mOp.NotEqual(m$.Fnc.$translate(YNKEY.var(1).get(),"\""),"")) {
          if (mOp.Equal(m$.var("YKEY").get(),"")) {
            mVar YKEY = m$.var("YKEY");
            YKEY.set(m$.Fnc.$query(m$.indirectVar((mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("^",YDATEIX.get()),"("),m$.fnc$("WWWYM.main",m$.var("YDATEI").get(),1)),YNKEY.var(1).get()),","),"\""),m$.Fnc.$char(255)),"\""),")"))),mOp.Negative(1)));
          }
        }
        //<< . . IF $PIECE(YDATA,Y,8)'=4 SET YKEY=$PIECE($PIECE(YKEY,"(",2),",",2,YMAXKEY+1)
        if (mOp.NotEqual(m$.Fnc.$piece(YDATA.get(),m$.var("Y").get(),8),4)) {
          mVar YKEY = m$.var("YKEY");
          YKEY.set(m$.Fnc.$piece(m$.Fnc.$piece(m$.var("YKEY").get(),"(",2),",",2,mOp.Add(YMAXKEY.get(),1)));
        }
        //<< . . IF $PIECE(YDATA,Y,8)=4  SET YKEY=$PIECE($PIECE(YKEY,"(",2),",",1,YMAXKEY+1)  ;OHNE MANDANT ;without Company
        if (mOp.Equal(m$.Fnc.$piece(YDATA.get(),m$.var("Y").get(),8),4)) {
          mVar YKEY = m$.var("YKEY");
          YKEY.set(m$.Fnc.$piece(m$.Fnc.$piece(m$.var("YKEY").get(),"(",2),",",1,mOp.Add(YMAXKEY.get(),1)));
        }
        //<< . . IF YFKEY'="" IF '$FIND($TRANSLATE(YKEY,""""),$TRANSLATE(YFKEY,"""")) SET YKEY=""
        if (mOp.NotEqual(m$.var("YFKEY").get(),"")) {
          if (mOp.Not(m$.Fnc.$find(m$.Fnc.$translate(m$.var("YKEY").get(),"\""),m$.Fnc.$translate(m$.var("YFKEY").get(),"\"")))) {
            mVar YKEY = m$.var("YKEY");
            YKEY.set("");
          }
        }
      }
      m$.restoreVarBlock(2);
      //<< . ;
      //<< . IF YRICHT="LAST" DO
      if (mOp.Equal(m$.var("YRICHT").get(),"LAST")) {
        //<< . . NEW YNKEY,YI,YSKEY
        mVar YNKEY = m$.var("YNKEY");
        mVar YI = m$.var("YI");
        mVar YSKEY = m$.var("YSKEY");
        m$.newVarBlock(2,YNKEY,YI,YSKEY);
        //<< . . SET YNKEY="",YNKEY(1)=""
        YNKEY.set("");
        YNKEY.var(1).set("");
        //<< . . SET YSKEY=YKEY
        YSKEY.set(m$.var("YKEY").get());
        //<< . . FOR YI=1:1:(YMAXKEY-1) DO  IF (YMAXKEY-1)'=YI SET YNKEY=YNKEY_","
        for (YI.set(1);(mOp.LessOrEqual(YI.get(),(mOp.Subtract(YMAXKEY.get(),1))));YI.set(mOp.Add(YI.get(),1))) {
          do {
            //<< . . . IF $PIECE(YFKEY,",",YI)'="" SET YNKEY=YNKEY_""""_$PIECE(YFKEY,",",YI)_"""" SET YNKEY(1)=YNKEY(1)_""""_$PIECE(YFKEY,",",YI)_"""" QUIT
            if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YFKEY").get(),",",YI.get()),"")) {
              YNKEY.set(mOp.Concat(mOp.Concat(mOp.Concat(YNKEY.get(),"\""),m$.Fnc.$piece(m$.var("YFKEY").get(),",",YI.get())),"\""));
              YNKEY.var(1).set(mOp.Concat(mOp.Concat(mOp.Concat(YNKEY.var(1).get(),"\""),m$.Fnc.$piece(m$.var("YFKEY").get(),",",YI.get())),"\""));
              break;
            }
            //<< . . . IF $PIECE(YKEY,",",YI)'=""  SET YNKEY=YNKEY_""""_$PIECE(YKEY,",",YI)_"""" QUIT
            if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YKEY").get(),",",YI.get()),"")) {
              YNKEY.set(mOp.Concat(mOp.Concat(mOp.Concat(YNKEY.get(),"\""),m$.Fnc.$piece(m$.var("YKEY").get(),",",YI.get())),"\""));
              break;
            }
            //<< . . . IF $PIECE(YKEY,",",YI)=""   SET YNKEY=YNKEY_""""_$CHAR(255)_""""          QUIT
            if (mOp.Equal(m$.Fnc.$piece(m$.var("YKEY").get(),",",YI.get()),"")) {
              YNKEY.set(mOp.Concat(mOp.Concat(mOp.Concat(YNKEY.get(),"\""),m$.Fnc.$char(255)),"\""));
              break;
            }
          } while (false);
          if (mOp.NotEqual((mOp.Subtract(YMAXKEY.get(),1)),YI.get())) {
            YNKEY.set(mOp.Concat(YNKEY.get(),","));
          }
        }
        //<< . . ;
        //<< . . IF YNKEY'="" SET YKEY=$QUERY(@("^"_YDATEIX_"("_$$^WWWYM(YDATEI,1)_YNKEY_","_""""_$CHAR(255)_""""_")"),-1) SET YKEY=$PIECE($PIECE(YKEY,"(",2,99),",",2,YMAXKEY+1)
        if (mOp.NotEqual(YNKEY.get(),"")) {
          mVar YKEY = m$.var("YKEY");
          YKEY.set(m$.Fnc.$query(m$.indirectVar((mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("^",YDATEIX.get()),"("),m$.fnc$("WWWYM.main",m$.var("YDATEI").get(),1)),YNKEY.get()),","),"\""),m$.Fnc.$char(255)),"\""),")"))),mOp.Negative(1)));
          YKEY.set(m$.Fnc.$piece(m$.Fnc.$piece(YKEY.get(),"(",2,99),",",2,mOp.Add(YMAXKEY.get(),1)));
        }
        //<< . . IF YNKEY=""  SET YKEY=$QUERY(@("^"_YDATEIX_"("_$$^WWWYM(YDATEI,1)_""""_$CHAR(255)_""""_")"),-1) SET YKEY=$PIECE($PIECE(YKEY,"(",2,99),",",2,YMAXKEY+1)
        if (mOp.Equal(YNKEY.get(),"")) {
          mVar YKEY = m$.var("YKEY");
          YKEY.set(m$.Fnc.$query(m$.indirectVar((mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("^",YDATEIX.get()),"("),m$.fnc$("WWWYM.main",m$.var("YDATEI").get(),1)),"\""),m$.Fnc.$char(255)),"\""),")"))),mOp.Negative(1)));
          YKEY.set(m$.Fnc.$piece(m$.Fnc.$piece(YKEY.get(),"(",2,99),",",2,mOp.Add(YMAXKEY.get(),1)));
        }
      }
      m$.restoreVarBlock(2);
    }
    //<< 
    //<< QUIT
    return;
  }

  //<< 
  //<< 
  //<< SORT ;SORTIERT NACH SORTKEY ;within
  public void SORT() {
    //<< ;-------------------------------------------------------------------------------
    //<< ; Get the next key
    //<< ;
    //<< ; Params:
    //<< ;
    //<< ; ByRefs:   YKEY
    //<< ;           YMAXKEY
    //<< ;           KEY
    //<< ;           YA(2)
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 27-Mar-2006   JW      SR14421: Doco
    //<< ;-------------------------------------------------------------------------------
    //<< NEW YSORT,YORIENT,YAUSWAHL,YFELD,SCHLUESSEL,YANZ,YDATA
    mVar YSORT = m$.var("YSORT");
    mVar YORIENT = m$.var("YORIENT");
    mVar YAUSWAHL = m$.var("YAUSWAHL");
    mVar YFELD = m$.var("YFELD");
    mVar SCHLUESSEL = m$.var("SCHLUESSEL");
    mVar YANZ = m$.var("YANZ");
    mVar YDATA = m$.var("YDATA");
    m$.newVar(YSORT,YORIENT,YAUSWAHL,YFELD,SCHLUESSEL,YANZ,YDATA);
    //<< 
    //<< SET YSORT = +$$$WWW120IndexForNextDataRecord(YVOR)
    YSORT.set(mOp.Positive(include.WWWConst.$$$WWW120IndexForNextDataRecord(m$,m$.var("YVOR"))));
    //<< QUIT:YDATEI=""
    if (mOp.Equal(m$.var("YDATEI").get(),"")) {
      return;
    }
    //<< 
    //<< SET YMAXKEY = +$ORDER(^WWW002(0,YDATEI,""),-1)
    mVar YMAXKEY = m$.var("YMAXKEY");
    YMAXKEY.set(mOp.Positive(m$.Fnc.$order(m$.var("^WWW002",0,m$.var("YDATEI").get(),""),mOp.Negative(1))));
    //<< IF YMAXKEY=0      SET YMAXKEY=1
    if (mOp.Equal(YMAXKEY.get(),0)) {
      YMAXKEY.set(1);
    }
    //<< IF YRICHT="FIRST" SET YORIENT=0,YKEY=""
    if (mOp.Equal(m$.var("YRICHT").get(),"FIRST")) {
      YORIENT.set(0);
      mVar YKEY = m$.var("YKEY");
      YKEY.set("");
    }
    //<< IF YRICHT="NEXT"  SET YORIENT=0
    if (mOp.Equal(m$.var("YRICHT").get(),"NEXT")) {
      YORIENT.set(0);
    }
    //<< IF YRICHT="LAST"  SET YORIENT=1,YKEY=""
    if (mOp.Equal(m$.var("YRICHT").get(),"LAST")) {
      YORIENT.set(1);
      mVar YKEY = m$.var("YKEY");
      YKEY.set("");
    }
    //<< IF YRICHT="BACK"  SET YORIENT=1
    if (mOp.Equal(m$.var("YRICHT").get(),"BACK")) {
      YORIENT.set(1);
    }
    //<< 
    //<< SET YDATA = $GET(^WWW001(0,YDATEI,1))
    YDATA.set(m$.Fnc.$get(m$.var("^WWW001",0,m$.var("YDATEI").get(),1)));
    //<< 
    //<< SET YANZ=2
    YANZ.set(2);
    //<< IF (YKEY="") || (YKEY=YFKEY) SET YANZ=1
    if ((mOp.Equal(m$.var("YKEY").get(),"")) || (mOp.Equal(m$.var("YKEY").get(),m$.var("YFKEY").get()))) {
      YANZ.set(1);
    }
    //<< IF (YORIENT=1) && (YKEY'="") SET YANZ=1
    if ((mOp.Equal(YORIENT.get(),1)) && (mOp.NotEqual(m$.var("YKEY").get(),""))) {
      YANZ.set(1);
    }
    //<< 
    //<< SET YAUSWAHL = YKEY
    YAUSWAHL.set(m$.var("YKEY").get());
    //<< 
    //<< IF YSORT'=0 IF YKEY'="" DO
    if (mOp.NotEqual(YSORT.get(),0)) {
      if (mOp.NotEqual(m$.var("YKEY").get(),"")) {
        do {
          //<< . QUIT:YMAXKEY=0
          if (mOp.Equal(YMAXKEY.get(),0)) {
            break;
          }
          //<< . SET SCHLUESSEL="^"_YDATEI_"("_$$^WWWYM(YDATEI,1)
          SCHLUESSEL.set(mOp.Concat(mOp.Concat(mOp.Concat("^",m$.var("YDATEI").get()),"("),m$.fnc$("WWWYM.main",m$.var("YDATEI").get(),1)));
          //<< . FOR YI=1:1:YMAXKEY SET KEY=$PIECE(YKEY,",",YI) SET SCHLUESSEL=SCHLUESSEL_""""_KEY_""""_","
          mVar YI = m$.var("YI");
          for (YI.set(1);(mOp.LessOrEqual(YI.get(),YMAXKEY.get()));YI.set(mOp.Add(YI.get(),1))) {
            mVar KEY = m$.var("KEY");
            KEY.set(m$.Fnc.$piece(m$.var("YKEY").get(),",",YI.get()));
            SCHLUESSEL.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(SCHLUESSEL.get(),"\""),KEY.get()),"\""),","));
          }
          //<< . IF $PIECE(YDATA,Y,8)'=4 SET SCHLUESSEL=SCHLUESSEL_"1)"  ;KEINOBJEKT
          if (mOp.NotEqual(m$.Fnc.$piece(YDATA.get(),m$.var("Y").get(),8),4)) {
            SCHLUESSEL.set(mOp.Concat(SCHLUESSEL.get(),"1)"));
          }
          //<< . IF $PIECE(YDATA,Y,8)=4 DO  ;OBJEKT ;thing
          if (mOp.Equal(m$.Fnc.$piece(YDATA.get(),m$.var("Y").get(),8),4)) {
            //<< . . SET:$EXTRACT(SCHLUESSEL,$LENGTH(SCHLUESSEL))="," SCHLUESSEL=$EXTRACT(SCHLUESSEL,1,$LENGTH(SCHLUESSEL)-1)
            if (mOp.Equal(m$.Fnc.$extract(SCHLUESSEL.get(),m$.Fnc.$length(SCHLUESSEL.get())),",")) {
              SCHLUESSEL.set(m$.Fnc.$extract(SCHLUESSEL.get(),1,mOp.Subtract(m$.Fnc.$length(SCHLUESSEL.get()),1)));
            }
            //<< . . SET SCHLUESSEL=SCHLUESSEL_")"
            SCHLUESSEL.set(mOp.Concat(SCHLUESSEL.get(),")"));
          }
          //<< . ;
          //<< . ;SET YA(2)=$QUERY(@SCHLUESSEL) ;table-mat
          //<< . SET YAUSWAHL = $$^WWWSKEY(SCHLUESSEL,YSORT)       // Get index values for this record
          YAUSWAHL.set(m$.fnc$("WWWSKEY.main",SCHLUESSEL.get(),YSORT.get()));
        } while (false);
      }
    }
    //<< 
    //<< DO ^WWWSOR(YDATEI,YFKEY,YAUSWAHL,YORIENT,YSORT,YANZ,1,"")
    m$.Cmd.Do("WWWSOR.main",m$.var("YDATEI").get(),m$.var("YFKEY").get(),YAUSWAHL.get(),YORIENT.get(),YSORT.get(),YANZ.get(),1,"");
    //<< SET YA(2) = $ORDER(^WWWSOR(YUSER,"KEY",""),-1)
    mVar YA = m$.var("YA");
    YA.var(2).set(m$.Fnc.$order(m$.var("^WWWSOR",m$.var("YUSER").get(),"KEY",""),mOp.Negative(1)));
    //<< IF YA(2)'="" SET YKEY = $ORDER(^WWWSOR(YUSER,"KEY",YA(2),""))
    if (mOp.NotEqual(YA.var(2).get(),"")) {
      mVar YKEY = m$.var("YKEY");
      YKEY.set(m$.Fnc.$order(m$.var("^WWWSOR",m$.var("YUSER").get(),"KEY",YA.var(2).get(),"")));
    }
    //<< 
    //<< KILL ^WWWSOR(YUSER)
    m$.var("^WWWSOR",m$.var("YUSER").get()).kill();
    //<< QUIT
    return;
  }

//<< 
//<< 
}
