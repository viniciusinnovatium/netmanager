//*****************************************************************************
//** TASC - ALPHALINC - MAC WWWEVENT4
//** Innovatium Systems - Code Converter - v1.29
//** 2014-06-03 20:54:16
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

//<< WWWEVENT4(YLOCK,YREQUEST)
public class WWWEVENT4 extends mClass {

  public Object main(Object ... _p) {
    mVar YLOCK = m$.newVarRef("YLOCK",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar YREQUEST = m$.newVarRef("YREQUEST",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    return _WWWEVENT4(YLOCK,YREQUEST);
  }

  public Object _WWWEVENT4(Object ... _p) {
    mVar YLOCK = m$.newVarRef("YLOCK",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar YREQUEST = m$.newVarRef("YREQUEST",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< 
    //<< ;--------------------------------------------------------------------------------
    //<< ; Description of Function :
    //<< ;       25774,EVENT BACKGROUND CHECKUP
    //<< ;
    //<< ; Called by: JavaScript EventValue calls - see WWWFORM re ""WWWEVENT4""
    //<< ;
    //<< ; Inputs :
    //<< ;   YREQUEST    = REQUEST TYP:
    //<< ;           EventRequest = Standard Anfrage (Lockprüfung, Messageprüfung, ...)
    //<< ;           DataRequest  = Daten neu laden# ;Data recent
    //<< ;   YLOCK       = INKL. LOCKPRÜFUNG JA/NEIN
    //<< ;
    //<< ; ByRef :
    //<< ;
    //<< ;
    //<< ; Returns :
    //<< ;   YRETVAL = RÜCKGABE:
    //<< ;       ""          = LOCK NOCH GÜLTIG ODER LOCK NEU GESETZT !
    //<< ;       "REFRESH"   = SEITE NEU LADEN (REFRESH)
    //<< ;       "RELOAD"    = LOCK NICHT MEHR GÜLTIG -> DATENSATZ VERÄNDERT, LOCK IST ABER WIEDER FREI
    //<< ;       "INVALID"   = LOCK NICHT MEHR GÜLTIG -> LOCK NICHT MEHR FREI
    //<< ;
    //<< ; History :
    //<< ; 03-May-2010   GRF     SR15961: use dteToday for efficiency
    //<< ; 19-Feb-2009   FIS     SR16065: log session action timestamp
    //<< ; 02-May-2007   GRF     SR15508: Naked References; quits
    //<< ; 02-Sep-2005   JW      SR12966: WWWUSER is shared
    //<< ; 20.06.2005    FIS     CORRECTION MADE
    //<< ; 16.07.2004    FIS
    //<< ;--------------------------------------------------------------------------------
    //<< NEW dteToday,YRETVAL
    mVar dteToday = m$.var("dteToday");
    mVar YRETVAL = m$.var("YRETVAL");
    m$.newVar(dteToday,YRETVAL);
    //<< 
    //<< SET YRETVAL = ""
    YRETVAL.set("");
    //<< SET YFORM   = $GET(YFORM)
    mVar YFORM = m$.var("YFORM");
    YFORM.set(m$.Fnc.$get(m$.var("YFORM")));
    //<< SET YUSER   = $GET(YUSER)
    mVar YUSER = m$.var("YUSER");
    YUSER.set(m$.Fnc.$get(m$.var("YUSER")));
    //<< 
    //<< IF YUSER=""                  QUIT YRETVAL
    if (mOp.Equal(YUSER.get(),"")) {
      return YRETVAL.get();
    }
    //<< IF $GET(YM)=""               QUIT YRETVAL
    if (mOp.Equal(m$.Fnc.$get(m$.var("YM")),"")) {
      return YRETVAL.get();
    }
    //<< IF $GET(YBED)=""             QUIT YRETVAL
    if (mOp.Equal(m$.Fnc.$get(m$.var("YBED")),"")) {
      return YRETVAL.get();
    }
    //<< IF '$DATA(^WWWUSER(0,YUSER)) QUIT YRETVAL
    if (mOp.Not(m$.Fnc.$data(m$.var("^WWWUSER",0,YUSER.get())))) {
      return YRETVAL.get();
    }
    //<< 
    //<< set dteToday = +$horolog     ; SR15961
    dteToday.set(mOp.Positive(m$.Fnc.$horolog()));
    //<< 
    //<< do LogAction^WWWUSER(YUSER)  //SR16065 ;log last action timestamp
    m$.Cmd.Do("WWWUSER.LogAction",YUSER.get());
    //<< 
    //<< IF $GET(YREQUEST)="EventRequest" DO
    if (mOp.Equal(m$.Fnc.$get(YREQUEST),"EventRequest")) {
      //<< . NEW YKEY,YFELD
      mVar YKEY = m$.var("YKEY");
      mVar YFELD = m$.var("YFELD");
      m$.newVarBlock(1,YKEY,YFELD);
      //<< . ;
      //<< . ;PRÜFEN LOCK ; check lock
      //<< . IF $GET(YLOCK)=1 IF YFORM'="" IF $DATA(^WWW120(0,YFORM)) DO
      if (mOp.Equal(m$.Fnc.$get(YLOCK),1)) {
        if (mOp.NotEqual(YFORM.get(),"")) {
          if (mOp.Logical(m$.Fnc.$data(m$.var("^WWW120",0,YFORM.get())))) {
            do {
              //<< . . NEW YDATEI,%SCHLUESSEL,LOCK
              mVar YDATEI = m$.var("YDATEI");
              mVar LOCK = m$.var("LOCK");
              m$.newVarBlock(2,YDATEI,LOCK);
              //<< . . QUIT:$EXTRACT(YFORM,1,6)="WWW127"                            ;NICHT BEI HILFE ;Not next to succour
              if (mOp.Equal(m$.Fnc.$extract(YFORM.get(),1,6),"WWW127")) {
                break;
              }
              //<< . . SET YKEY = $GET(^WWWDATEN(YM,dteToday,YUSER,YFORM,"P",1))   ;KEY HOLEN ;KEY send for
              YKEY.set(m$.Fnc.$get(m$.var("^WWWDATEN",m$.var("YM").get(),dteToday.get(),YUSER.get(),YFORM.get(),"P",1)));
              //<< . . QUIT:YKEY=""
              if (mOp.Equal(YKEY.get(),"")) {
                break;
              }
              //<< . . IF $FIND(YKEY,"+") QUIT                                      ;NUR WENN NICHT NEUERFASSUNG ;only when Not
              if (mOp.Logical(m$.Fnc.$find(YKEY.get(),"+"))) {
                break;
              }
              //<< . . SET YFELD = $GET(^WWWDATEN(YM,dteToday,YUSER,YFORM,"D",1))  ;DATENSATZ HOLEN ;data record send for
              YFELD.set(m$.Fnc.$get(m$.var("^WWWDATEN",m$.var("YM").get(),dteToday.get(),YUSER.get(),YFORM.get(),"D",1)));
              //<< . . QUIT:YFELD=""
              if (mOp.Equal(YFELD.get(),"")) {
                break;
              }
              //<< . . ;
              //<< . . SET LOCK = $get(^WWWDATEN(YM,dteToday,YUSER,YFORM,"LOCK",1))
              LOCK.set(m$.Fnc.$get(m$.var("^WWWDATEN",m$.var("YM").get(),dteToday.get(),YUSER.get(),YFORM.get(),"LOCK",1)));
              //<< . . if $translate(LOCK," ")'="" do
              if (mOp.NotEqual(m$.Fnc.$translate(LOCK.get()," "),"")) {
                do {
                  //<< . . . QUIT:$FIND(LOCK,"+")         ;KEIN NEUER DATENSATZ ;no data record
                  if (mOp.Logical(m$.Fnc.$find(LOCK.get(),"+"))) {
                    break;
                  }
                  //<< . . . IF '$DATA(@(LOCK)) DO  QUIT  ;NEU SETZEN WENN NICHT MEHR GÜLTIG ;recent typeset when Not more valuable
                  if (mOp.Not(m$.Fnc.$data(m$.indirectVar((LOCK.get()))))) {
                    do {
                      //<< . . . . SET YDATEI=""
                      YDATEI.set("");
                      //<< . . . . SET %SCHLUESSEL = $TRANSLATE($PIECE(LOCK,",",3),"""")
                      m$.var("%SCHLUESSEL").set(m$.Fnc.$translate(m$.Fnc.$piece(LOCK.get(),",",3),"\""));
                      //<< . . . . IF $PIECE($PIECE(%SCHLUESSEL,"/",1),"^",2)'="" IF +$PIECE($GET(^WWW001(0,$PIECE($PIECE(%SCHLUESSEL,"/",1),"^",2),1)),Y,6)=0 QUIT  ;KEINE SATZLOCKSEKUNDEN ;no
                      if (mOp.NotEqual(m$.Fnc.$piece(m$.Fnc.$piece(m$.var("%SCHLUESSEL").get(),"/",1),"^",2),"")) {
                        if (mOp.Equal(mOp.Positive(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW001",0,m$.Fnc.$piece(m$.Fnc.$piece(m$.var("%SCHLUESSEL").get(),"/",1),"^",2),1)),m$.var("Y").get(),6)),0)) {
                          break;
                        }
                      }
                      //<< . . . . IF %SCHLUESSEL'="" SET YDATEI = $PIECE(%SCHLUESSEL,"/",1)_"("_$$^WWWKEYBUILD($TRANSLATE($PIECE(%SCHLUESSEL,"/",2),".",","))_")"
                      if (mOp.NotEqual(m$.var("%SCHLUESSEL").get(),"")) {
                        YDATEI.set(mOp.Concat(mOp.Concat(mOp.Concat(m$.Fnc.$piece(m$.var("%SCHLUESSEL").get(),"/",1),"("),m$.fnc$("WWWKEYBUILD.main",m$.Fnc.$translate(m$.Fnc.$piece(m$.var("%SCHLUESSEL").get(),"/",2),".",","))),")"));
                      }
                      //<< . . . . IF $FIND(YDATEI,",,") QUIT  ;UNGÜLTIGE REFERENZ (BEI "." IM KEY Z.B. WWW004)
                      if (mOp.Logical(m$.Fnc.$find(YDATEI.get(),",,"))) {
                        break;
                      }
                      //<< . . . . IF YDATEI'="" IF $DATA(@YDATEI) IF $TRANSLATE($GET(^WWWDATEN(YM,dteToday,YUSER,YFORM,"D",2)),";,.|0123456789 "_Y_"""")'=$TRANSLATE(@YDATEI,";,.|0123456789 "_Y_"""") DO  QUIT  ;DATA RECORD HAS CHANGED
                      if (mOp.NotEqual(YDATEI.get(),"")) {
                        if (mOp.Logical(m$.Fnc.$data(m$.indirectVar(YDATEI.get())))) {
                          if (mOp.NotEqual(m$.Fnc.$translate(m$.Fnc.$get(m$.var("^WWWDATEN",m$.var("YM").get(),dteToday.get(),YUSER.get(),YFORM.get(),"D",2)),mOp.Concat(mOp.Concat(";,.|0123456789 ",m$.var("Y").get()),"\"")),m$.Fnc.$translate(m$.indirectVar(YDATEI.get()).get(),mOp.Concat(mOp.Concat(";,.|0123456789 ",m$.var("Y").get()),"\"")))) {
                            do {
                              //<< . . . . . IF $PIECE($GET(^WWW120(0,YFORM,1)),Y,84)'="" SET YRETVAL="INVALID" QUIT  ;FIS;20.06.05;27905;IF DATAFIELD MAKES FORM READONLY (NOT CHECKING THE EXACT FIELDS YET)
                              if (mOp.NotEqual(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW120",0,YFORM.get(),1)),m$.var("Y").get(),84),"")) {
                                YRETVAL.set("INVALID");
                                break;
                              }
                              //<< . . . . . SET YRETVAL="RELOAD"  ;RELOAD ?
                              YRETVAL.set("RELOAD");
                            } while (false);
                            break;
                          }
                        }
                      }
                      //<< . . . . ;
                      //<< . . . . SET ^WWW006(0,dteToday,%SCHLUESSEL,1) = YUSER_Y_$PIECE($HOROLOG,",",2)  ;SPEICHERN NEUEN LOCK ;Save
                      m$.var("^WWW006",0,dteToday.get(),m$.var("%SCHLUESSEL").get(),1).set(mOp.Concat(mOp.Concat(YUSER.get(),m$.var("Y").get()),m$.Fnc.$piece(m$.Fnc.$horolog(),",",2)));
                      //<< . . . . SET ^WWWDATEN(YM,dteToday,YUSER,YFORM,"LOCK",1) = "^WWW006(0,"_dteToday_","_""""_%SCHLUESSEL_""""_",1)"
                      m$.var("^WWWDATEN",m$.var("YM").get(),dteToday.get(),YUSER.get(),YFORM.get(),"LOCK",1).set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("^WWW006(0,",dteToday.get()),","),"\""),m$.var("%SCHLUESSEL").get()),"\""),",1)"));
                    } while (false);
                    break;
                  }
                  //<< . . . ;
                  //<< . . . SET %SCHLUESSEL = $TRANSLATE($PIECE(LOCK,",",3),"""")
                  m$.var("%SCHLUESSEL").set(m$.Fnc.$translate(m$.Fnc.$piece(LOCK.get(),",",3),"\""));
                  //<< . . . SET LOCK(1) = @(LOCK) IF $PIECE(LOCK(1),Y,1)'=YUSER  SET YRETVAL = "INVALID" QUIT  ;NICHT MEHR BESITZER DES DATENSATZES ;Not more
                  LOCK.var(1).set(m$.indirectVar((LOCK.get())).get());
                  if (mOp.NotEqual(m$.Fnc.$piece(LOCK.var(1).get(),m$.var("Y").get(),1),YUSER.get())) {
                    YRETVAL.set("INVALID");
                    break;
                  }
                  //<< . . . ;
                  //<< . . . IF $PIECE($PIECE(%SCHLUESSEL,"/",1),"^",2)'="" IF +$PIECE($GET(^WWW001(0,$PIECE($PIECE(%SCHLUESSEL,"/",1),"^",2),1)),Y,6)=0 QUIT  ;KEINE SATZLOCKSEKUNDEN ;no
                  if (mOp.NotEqual(m$.Fnc.$piece(m$.Fnc.$piece(m$.var("%SCHLUESSEL").get(),"/",1),"^",2),"")) {
                    if (mOp.Equal(mOp.Positive(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW001",0,m$.Fnc.$piece(m$.Fnc.$piece(m$.var("%SCHLUESSEL").get(),"/",1),"^",2),1)),m$.var("Y").get(),6)),0)) {
                      break;
                    }
                  }
                  //<< . . . ;
                  //<< . . . SET YDATEI=""
                  YDATEI.set("");
                  //<< . . . IF %SCHLUESSEL'="" SET YDATEI = $PIECE(%SCHLUESSEL,"/",1)_"("_$$^WWWKEYBUILD($TRANSLATE($PIECE(%SCHLUESSEL,"/",2),".",","))_")"
                  if (mOp.NotEqual(m$.var("%SCHLUESSEL").get(),"")) {
                    YDATEI.set(mOp.Concat(mOp.Concat(mOp.Concat(m$.Fnc.$piece(m$.var("%SCHLUESSEL").get(),"/",1),"("),m$.fnc$("WWWKEYBUILD.main",m$.Fnc.$translate(m$.Fnc.$piece(m$.var("%SCHLUESSEL").get(),"/",2),".",","))),")"));
                  }
                  //<< . . . IF $FIND(YDATEI,",,") QUIT  ;UNGÜLTIGE REFERENZ (BEI "." IM KEY: Z.B. MENÜPUNKTE IN WWW004)
                  if (mOp.Logical(m$.Fnc.$find(YDATEI.get(),",,"))) {
                    break;
                  }
                } while (false);
              }
            } while (false);
          }
          m$.restoreVarBlock(2);
        }
      }
      //<< . . . // AUSGESCHALTET, DA PROBLEM: WWWDATEN,2 UND @YDATEI STIMMEN NICHT ÜBEREIN, DA KLEINE UNTERSCHIEDE (Z.B. ÄNDERUNGSDATUM, ZAHLENFORMATE,...)
      //<< . . . ;IF YDATEI'="" IF $DATA(@YDATEI) IF $TRANSLATE($GET(^WWWDATEN(YM,dteToday,YUSER,YFORM,"D",2)),";,.|0 "_"""")'=$TRANSLATE(@YDATEI,";,.|0 "_"""") SET YRETVAL="RELOAD" QUIT  ;DATENSATZ WURDE VERÄNDERT. NEU LADEN ?
      //<< . . . ;IF YDATEI'="" IF $DATA(@YDATEI) IF $TRANSLATE($GET(^WWWDATEN(YM,dteToday,YUSER,YFORM,"D",2)),";,.|0123456789 "_Y_"""")'=$TRANSLATE(@YDATEI,";,.|0123456789 "_Y_"""") SET YRETVAL="RELOAD" QUIT  ;DATENSATZ WURDE VERÄNDERT. NEU LADEN ?
      //<< . ;
      //<< . ;PRÜFEN MELDUNGEN ;check
      //<< . IF YRETVAL="" IF $GET(YBED)'="" IF $DATA(^WWW013Ms(0,1," ",YBED)) DO
      if (mOp.Equal(YRETVAL.get(),"")) {
        if (mOp.NotEqual(m$.Fnc.$get(m$.var("YBED")),"")) {
          if (mOp.Logical(m$.Fnc.$data(m$.var("^WWW013Ms",0,1," ",m$.var("YBED").get())))) {
            do {
              //<< . . NEW TXT,TXT1,YFORM,YVOR,YOK
              mVar TXT = m$.var("TXT");
              mVar TXT1 = m$.var("TXT1");
              mVar YVOR = m$.var("YVOR");
              mVar YOK = m$.var("YOK");
              m$.newVarBlock(2,TXT,TXT1,YFORM,YVOR,YOK);
              //<< . . SET TXT1 = ""
              TXT1.set("");
              //<< . . SET TXT  = $ORDER(^WWW013Ms(0,1," ",YBED,""))
              TXT.set(m$.Fnc.$order(m$.var("^WWW013Ms",0,1," ",m$.var("YBED").get(),"")));
              //<< . . IF TXT'="" SET TXT1 = $GET(^WWW013M(0,YBED,TXT,1))
              if (mOp.NotEqual(TXT.get(),"")) {
                TXT1.set(m$.Fnc.$get(m$.var("^WWW013M",0,m$.var("YBED").get(),TXT.get(),1)));
              }
              //<< . . IF TXT'="" IF $TRANSLATE(TXT1,Y)="" DO ^WWWSKILL("WWW013M",YBED_","_TXT) QUIT
              if (mOp.NotEqual(TXT.get(),"")) {
                if (mOp.Equal(m$.Fnc.$translate(TXT1.get(),m$.var("Y").get()),"")) {
                  m$.Cmd.Do("WWWSKILL.main","WWW013M",mOp.Concat(mOp.Concat(m$.var("YBED").get(),","),TXT.get()));
                  break;
                }
              }
              //<< . . IF TXT1'="" DO
              if (mOp.NotEqual(TXT1.get(),"")) {
                //<< . . . SET YRETVAL = "!"
                YRETVAL.set("!");
                //<< . . . IF $PIECE(TXT1,Y,4)'="" SET YRETVAL = YRETVAL_"("_$PIECE(TXT1,Y,4)_":) "
                if (mOp.NotEqual(m$.Fnc.$piece(TXT1.get(),m$.var("Y").get(),4),"")) {
                  YRETVAL.set(mOp.Concat(mOp.Concat(mOp.Concat(YRETVAL.get(),"("),m$.Fnc.$piece(TXT1.get(),m$.var("Y").get(),4)),":) "));
                }
                //<< . . . SET YRETVAL = YRETVAL_$PIECE(TXT1,Y,1)
                YRETVAL.set(mOp.Concat(YRETVAL.get(),m$.Fnc.$piece(TXT1.get(),m$.var("Y").get(),1)));
              }
              //<< . . ;
              //<< . . SET $PIECE(TXT1,Y,2) = dteToday
              m$.pieceVar(TXT1,m$.var("Y").get(),2).set(dteToday.get());
              //<< . . SET $PIECE(TXT1,Y,3) = $PIECE($HOROLOG,",",2)
              m$.pieceVar(TXT1,m$.var("Y").get(),3).set(m$.Fnc.$piece(m$.Fnc.$horolog(),",",2));
              //<< . . SET YOK = $$^WWWSPEI("WWW013M",YBED_","_TXT,TXT1,1)
              YOK.set(m$.fnc$("WWWSPEI.main","WWW013M",mOp.Concat(mOp.Concat(m$.var("YBED").get(),","),TXT.get()),TXT1.get(),1));
            } while (false);
          }
          m$.restoreVarBlock(2);
        }
      }
    }
    m$.restoreVarBlock(1);
    //<< 
    //<< 
    //<< IF $GET(YREQUEST)="DataRequest" DO
    if (mOp.Equal(m$.Fnc.$get(YREQUEST),"DataRequest")) {
      //<< . NEW YDATEI,%SCHLUESSEL,LOCK
      mVar YDATEI = m$.var("YDATEI");
      mVar LOCK = m$.var("LOCK");
      m$.newVarBlock(1,YDATEI,LOCK);
      //<< . SET YFELD = ""
      mVar YFELD = m$.var("YFELD");
      YFELD.set("");
      //<< . SET LOCK=$get(^WWWDATEN(YM,dteToday,YUSER,YFORM,"LOCK",1))
      LOCK.set(m$.Fnc.$get(m$.var("^WWWDATEN",m$.var("YM").get(),dteToday.get(),YUSER.get(),YFORM.get(),"LOCK",1)));
      //<< . if $translate(LOCK," ")'="" do
      if (mOp.NotEqual(m$.Fnc.$translate(LOCK.get()," "),"")) {
        do {
          //<< . . QUIT:$FIND(LOCK,"+")           ;KEIN NEUER DATENSATZ ;no data record
          if (mOp.Logical(m$.Fnc.$find(LOCK.get(),"+"))) {
            break;
          }
          //<< . . ;
          //<< . . SET YDATEI=""
          YDATEI.set("");
          //<< . . SET %SCHLUESSEL = $TRANSLATE($PIECE(LOCK,",",3),"""")
          m$.var("%SCHLUESSEL").set(m$.Fnc.$translate(m$.Fnc.$piece(LOCK.get(),",",3),"\""));
          //<< . . IF %SCHLUESSEL'="" SET YDATEI = $PIECE(%SCHLUESSEL,"/",1)_"("_$$^WWWKEYBUILD($TRANSLATE($PIECE(%SCHLUESSEL,"/",2),".",","))_")"
          if (mOp.NotEqual(m$.var("%SCHLUESSEL").get(),"")) {
            YDATEI.set(mOp.Concat(mOp.Concat(mOp.Concat(m$.Fnc.$piece(m$.var("%SCHLUESSEL").get(),"/",1),"("),m$.fnc$("WWWKEYBUILD.main",m$.Fnc.$translate(m$.Fnc.$piece(m$.var("%SCHLUESSEL").get(),"/",2),".",","))),")"));
          }
          //<< . . IF $FIND(YDATEI,",,") QUIT     ;UNGÜLTIGE REFERENZ (BEI "." IM KEY Z.B. WWW004)
          if (mOp.Logical(m$.Fnc.$find(YDATEI.get(),",,"))) {
            break;
          }
          //<< . . IF '$DATA(@(LOCK)) DO          ;NEU SETZEN WENN NICHT MEHR GÜLTIG ;recent typeset when Not more valuable
          if (mOp.Not(m$.Fnc.$data(m$.indirectVar((LOCK.get()))))) {
            //<< . . . SET ^WWW006(0,dteToday,%SCHLUESSEL,1) = YUSER_Y_$PIECE($HOROLOG,",",2)  ;SPEICHERN NEUEN LOCK ;Save
            m$.var("^WWW006",0,dteToday.get(),m$.var("%SCHLUESSEL").get(),1).set(mOp.Concat(mOp.Concat(YUSER.get(),m$.var("Y").get()),m$.Fnc.$piece(m$.Fnc.$horolog(),",",2)));
            //<< . . . SET ^WWWDATEN(YM,dteToday,YUSER,YFORM,"LOCK",1) = "^WWW006(0,"_dteToday_","_""""_%SCHLUESSEL_""""_",1)"
            m$.var("^WWWDATEN",m$.var("YM").get(),dteToday.get(),YUSER.get(),YFORM.get(),"LOCK",1).set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("^WWW006(0,",dteToday.get()),","),"\""),m$.var("%SCHLUESSEL").get()),"\""),",1)"));
          }
          //<< . . ;
          //<< . . SET LOCK(1) = @(LOCK)
          LOCK.var(1).set(m$.indirectVar((LOCK.get())).get());
          //<< . . IF $PIECE(LOCK(1),Y,1)'=YUSER QUIT  ;NICHT DER EIGENE LOCK ;Not the
          if (mOp.NotEqual(m$.Fnc.$piece(LOCK.var(1).get(),m$.var("Y").get(),1),YUSER.get())) {
            break;
          }
          //<< . . IF (YDATEI'="") && $DATA(@YDATEI) SET YFELD = @YDATEI
          if ((mOp.NotEqual(YDATEI.get(),"")) && mOp.Logical(m$.Fnc.$data(m$.indirectVar(YDATEI.get())))) {
            YFELD.set(m$.indirectVar(YDATEI.get()).get());
          }
        } while (false);
      }
      //<< . ;
      //<< . IF YFELD'="" IF YFELD'=$GET(^WWWDATEN(YM,dteToday,YUSER,YFORM,"D",1)) DO
      if (mOp.NotEqual(YFELD.get(),"")) {
        if (mOp.NotEqual(YFELD.get(),m$.Fnc.$get(m$.var("^WWWDATEN",m$.var("YM").get(),dteToday.get(),YUSER.get(),YFORM.get(),"D",1)))) {
          //<< . . SET ^WWWDATEN(YM,dteToday,YUSER,YFORM,"D",2) = $GET(^WWWDATEN(YM,dteToday,YUSER,YFORM,"D",1))
          m$.var("^WWWDATEN",m$.var("YM").get(),dteToday.get(),YUSER.get(),YFORM.get(),"D",2).set(m$.Fnc.$get(m$.var("^WWWDATEN",m$.var("YM").get(),dteToday.get(),YUSER.get(),YFORM.get(),"D",1)));
          //<< . . SET ^WWWDATEN(YM,dteToday,YUSER,YFORM,"D",1) = YFELD
          m$.var("^WWWDATEN",m$.var("YM").get(),dteToday.get(),YUSER.get(),YFORM.get(),"D",1).set(YFELD.get());
          //<< . . SET YRETVAL = $$^WWWREFRESH(YUSER,YFORM)
          YRETVAL.set(m$.fnc$("WWWREFRESH.main",YUSER.get(),YFORM.get()));
          //<< . . SET ^WWWDATEN(YM,dteToday,YUSER,YFORM,"D",2) = YFELD
          m$.var("^WWWDATEN",m$.var("YM").get(),dteToday.get(),YUSER.get(),YFORM.get(),"D",2).set(YFELD.get());
        }
      }
      //<< . ;
      //<< . IF (YFELD="") || (YRETVAL="") SET YRETVAL = "!"_$$^WWWTEXT(392,,1)  ; "Another User has changed the data record. Please Refresh This Page. Save is not possible."
      if ((mOp.Equal(YFELD.get(),"")) || (mOp.Equal(YRETVAL.get(),""))) {
        YRETVAL.set(mOp.Concat("!",m$.fnc$("WWWTEXT.main",392,null,1)));
      }
    }
    m$.restoreVarBlock(1);
    //<< 
    //<< 
    //<< IF $GET(YREQUEST)="DeleteLock" DO
    if (mOp.Equal(m$.Fnc.$get(YREQUEST),"DeleteLock")) {
      //<< . NEW LOCK
      mVar LOCK = m$.var("LOCK");
      m$.newVarBlock(1,LOCK);
      //<< . SET LOCK = $get(^WWWDATEN(YM,dteToday,YUSER,YFORM,"LOCK",1))
      LOCK.set(m$.Fnc.$get(m$.var("^WWWDATEN",m$.var("YM").get(),dteToday.get(),YUSER.get(),YFORM.get(),"LOCK",1)));
      //<< . if $translate(LOCK," ")'="" do
      if (mOp.NotEqual(m$.Fnc.$translate(LOCK.get()," "),"")) {
        do {
          //<< . . QUIT:$FIND(LOCK,"+")           ;KEIN NEUER DATENSATZ ;no data record
          if (mOp.Logical(m$.Fnc.$find(LOCK.get(),"+"))) {
            break;
          }
          //<< . . KILL ^WWWDATEN(YM,dteToday,YUSER,YFORM,"LOCK",1)
          m$.var("^WWWDATEN",m$.var("YM").get(),dteToday.get(),YUSER.get(),YFORM.get(),"LOCK",1).kill();
        } while (false);
      }
    }
    m$.restoreVarBlock(1);
    //<< 
    //<< 
    //<< IF $GET(YREQUEST)="RefreshCheck" DO
    if (mOp.Equal(m$.Fnc.$get(YREQUEST),"RefreshCheck")) {
      do {
        //<< . NEW YKEY
        mVar YKEY = m$.var("YKEY");
        m$.newVarBlock(1,YKEY);
        //<< . SET YRETVAL = ""
        YRETVAL.set("");
        //<< . SET YKEY    = $GET(^WWWDATEN(YM,dteToday,YUSER,YFORM,"P",1))
        YKEY.set(m$.Fnc.$get(m$.var("^WWWDATEN",m$.var("YM").get(),dteToday.get(),YUSER.get(),YFORM.get(),"P",1)));
        //<< . QUIT:$FIND(YKEY,"+")
        if (mOp.Logical(m$.Fnc.$find(YKEY.get(),"+"))) {
          break;
        }
        //<< . SET YKEY = $TRANSLATE(YKEY,"][\}{|~ ,;:'()@#$%^&*_=+<>?/"_$CHAR(128)_"""")
        YKEY.set(m$.Fnc.$translate(YKEY.get(),mOp.Concat(mOp.Concat("][\\}{|~ ,;:'()@#$%^&*_=+<>?/",m$.Fnc.$char(128)),"\"")));
        //<< . IF YKEY'="" IF YKEY'=YLOCK SET YRETVAL = YLOCK
        if (mOp.NotEqual(YKEY.get(),"")) {
          if (mOp.NotEqual(YKEY.get(),YLOCK.get())) {
            YRETVAL.set(YLOCK.get());
          }
        }
      } while (false);
    }
    m$.restoreVarBlock(1);
    //<< 
    //<< QUIT YRETVAL
    return YRETVAL.get();
  }

//<< 
//<< 
}
