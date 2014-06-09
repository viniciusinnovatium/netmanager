//*****************************************************************************
//** TASC - ALPHALINC - MAC WWWFORMAT
//** Innovatium Systems - Code Converter - v1.30
//** 2014-06-05 19:01:38
//*****************************************************************************

import mLibrary.*;

//<< #include WWWConst
import include.WWWConst;
//TODO REVISAR CONVERSOR import COMSYS;

//<< WWWFORMAT(YDATEI,YART,YLFN,YINHALT,YRETURN)
public class WWWFORMAT extends mClass {

  public Object main(Object ... _p) {
    mVar YDATEI = m$.newVarRef("YDATEI",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar YART = m$.newVarRef("YART",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar YLFN = m$.newVarRef("YLFN",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    mVar YINHALT = m$.newVarRef("YINHALT",(((_p!=null)&&(_p.length>=4))?_p[3]:null));
    mVar YRETURN = m$.newVarRef("YRETURN",(((_p!=null)&&(_p.length>=5))?_p[4]:null));
    return _WWWFORMAT(YDATEI,YART,YLFN,YINHALT,YRETURN);
  }

  public Object _WWWFORMAT(Object ... _p) {
    mVar YDATEI = m$.newVarRef("YDATEI",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar YART = m$.newVarRef("YART",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar YLFN = m$.newVarRef("YLFN",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    mVar YINHALT = m$.newVarRef("YINHALT",(((_p!=null)&&(_p.length>=4))?_p[3]:null));
    mVar YRETURN = m$.newVarRef("YRETURN",(((_p!=null)&&(_p.length>=5))?_p[4]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Description of Function :
    //<< ;       Set format for output tables
    //<< ;       SETZEN AUSGABEFORMAT FÜR TABELLEN
    //<< ;
    //<< ; Inputs :
    //<< ;   YDATEI      Class ID
    //<< ;   YART        "P" or "D"
    //<< ;   YLFN        Class field no (key or data)
    //<< ;   YINHALT     Input Data (converted to output format and returned)
    //<< ;   YRETURN     Operation to be performed
    //<< ;                   =0  Equivalent to 3
    //<< ;                   1   Only format
    //<< ;                   2   Relationship Only
    //<< ;                   3   Format, Relationship and Colour [for WWW101 or INPARA Relations]
    //<< ;
    //<< ;                   4   Format, Data Export
    //<< ;
    //<< ; ByRef :
    //<< ;
    //<< ; Returns :     Formatted Data
    //<< ;
    //<< ; History :
    //<< ; 06-Jan-2011   GRF     SR17579: Use explicit tag
    //<< ; 09-Apr-2009   GRF     Doco; quits; remove old commented code
    //<< ; 11.02.2001    DT      Created
    //<< ;-------------------------------------------------------------------------------
    //<< NEW YINHALTK,YQ,YKE1,YDATA,YFE,YDAT,YKE,YSAT,YSPR,YKE3,YTYP,YII,YFARBCODE
    mVar YINHALTK = m$.var("YINHALTK");
    mVar YQ = m$.var("YQ");
    mVar YKE1 = m$.var("YKE1");
    mVar YDATA = m$.var("YDATA");
    mVar YFE = m$.var("YFE");
    mVar YDAT = m$.var("YDAT");
    mVar YKE = m$.var("YKE");
    mVar YSAT = m$.var("YSAT");
    mVar YSPR = m$.var("YSPR");
    mVar YKE3 = m$.var("YKE3");
    mVar YTYP = m$.var("YTYP");
    mVar YII = m$.var("YII");
    mVar YFARBCODE = m$.var("YFARBCODE");
    m$.newVar(YINHALTK,YQ,YKE1,YDATA,YFE,YDAT,YKE,YSAT,YSPR,YKE3,YTYP,YII,YFARBCODE);
    //<< 
    //<< SET YINHALT = $GET(YINHALT)
    YINHALT.set(m$.Fnc.$get(YINHALT));
    //<< IF $GET(YDATEI)="" QUIT YINHALT
    if (mOp.Equal(m$.Fnc.$get(YDATEI),"")) {
      return YINHALT.get();
    }
    //<< IF $GET(YLFN)=""   QUIT YINHALT
    if (mOp.Equal(m$.Fnc.$get(YLFN),"")) {
      return YINHALT.get();
    }
    //<< 
    //<< SET YRETURN = $GET(YRETURN)
    YRETURN.set(m$.Fnc.$get(YRETURN));
    //<< 
    //<< IF $GET(YART)="P" DO
    if (mOp.Equal(m$.Fnc.$get(YART),"P")) {
      //<< . DO KEY
      m$.Cmd.Do("KEY");
      //<< . IF +YRETURN=0 DO
      if (mOp.Equal(mOp.Positive(YRETURN.get()),0)) {
        //<< . . IF YINHALTK'="" SET YINHALT=YINHALTK_" ("_YINHALT_")"
        if (mOp.NotEqual(YINHALTK.get(),"")) {
          YINHALT.set(mOp.Concat(mOp.Concat(mOp.Concat(YINHALTK.get()," ("),YINHALT.get()),")"));
        }
      }
      //<< . ;
      //<< . IF YRETURN=2 SET YINHALT=YINHALTK
      if (mOp.Equal(YRETURN.get(),2)) {
        YINHALT.set(YINHALTK.get());
      }
      //<< . IF YRETURN=4 IF YINHALTK'="" SET YINHALT=YINHALTK
      if (mOp.Equal(YRETURN.get(),4)) {
        if (mOp.NotEqual(YINHALTK.get(),"")) {
          YINHALT.set(YINHALTK.get());
        }
      }
    }
    //<< 
    //<< IF $GET(YART)="D" DO
    if (mOp.Equal(m$.Fnc.$get(YART),"D")) {
      do {
        //<< . IF '$FIND(YINHALT,";") DO  QUIT
        if (mOp.Not(m$.Fnc.$find(YINHALT.get(),";"))) {
          //<< . . DO DATEN
          m$.Cmd.Do("DATEN");
          //<< . . IF (+YRETURN=0) || (YRETURN=3) DO
          if ((mOp.Equal(mOp.Positive(YRETURN.get()),0)) || (mOp.Equal(YRETURN.get(),3))) {
            //<< . . . IF YINHALTK'="" IF YINHALT'="" SET YINHALT="("_YINHALT_") "_YINHALTK  ;IF YINHALT'=YINHALTK
            if (mOp.NotEqual(YINHALTK.get(),"")) {
              if (mOp.NotEqual(YINHALT.get(),"")) {
                YINHALT.set(mOp.Concat(mOp.Concat(mOp.Concat("(",YINHALT.get()),") "),YINHALTK.get()));
              }
            }
            //<< . . . IF YINHALTK'="" IF YINHALT=""  SET YINHALT=YINHALTK
            if (mOp.NotEqual(YINHALTK.get(),"")) {
              if (mOp.Equal(YINHALT.get(),"")) {
                YINHALT.set(YINHALTK.get());
              }
            }
          }
          //<< . . ;
          //<< . . IF YRETURN=2 SET YINHALT=YINHALTK
          if (mOp.Equal(YRETURN.get(),2)) {
            YINHALT.set(YINHALTK.get());
          }
          //<< . . IF YRETURN=4 IF YINHALTK'="" SET YINHALT=YINHALTK
          if (mOp.Equal(YRETURN.get(),4)) {
            if (mOp.NotEqual(YINHALTK.get(),"")) {
              YINHALT.set(YINHALTK.get());
            }
          }
          break;
        }
        //<< . ;
        //<< . IF $FIND(YINHALT,";") IF $LENGTH(YINHALT,";")<10 DO  QUIT
        if (mOp.Logical(m$.Fnc.$find(YINHALT.get(),";"))) {
          if (mOp.Less(m$.Fnc.$length(YINHALT.get(),";"),10)) {
            //<< . . SET YINHALTX=YINHALT
            mVar YINHALTX = m$.var("YINHALTX");
            YINHALTX.set(YINHALT.get());
            //<< . . FOR YII=1:1 SET YINHALT=$PIECE(YINHALTX,";",YII) QUIT:YINHALT=""  DO  SET $PIECE(YINHALTX,";",YII)=YINHALT
            for (YII.set(1);(true);YII.set(mOp.Add(YII.get(),1))) {
              YINHALT.set(m$.Fnc.$piece(YINHALTX.get(),";",YII.get()));
              if (mOp.Equal(YINHALT.get(),"")) {
                break;
              }
              //<< . . . DO DATEN
              m$.Cmd.Do("DATEN");
              //<< . . . IF (+YRETURN=0) || (YRETURN=3) DO
              if ((mOp.Equal(mOp.Positive(YRETURN.get()),0)) || (mOp.Equal(YRETURN.get(),3))) {
                //<< . . . . IF YINHALTK'="" IF YINHALT'="" SET YINHALT="("_YINHALT_") "_YINHALTK  ;IF YINHALT'=YINHALTK
                if (mOp.NotEqual(YINHALTK.get(),"")) {
                  if (mOp.NotEqual(YINHALT.get(),"")) {
                    YINHALT.set(mOp.Concat(mOp.Concat(mOp.Concat("(",YINHALT.get()),") "),YINHALTK.get()));
                  }
                }
                //<< . . . . IF YINHALTK'="" IF YINHALT=""  SET YINHALT=YINHALTK
                if (mOp.NotEqual(YINHALTK.get(),"")) {
                  if (mOp.Equal(YINHALT.get(),"")) {
                    YINHALT.set(YINHALTK.get());
                  }
                }
              }
              //<< . . . ;
              //<< . . . IF YRETURN=2 SET YINHALT=YINHALTK
              if (mOp.Equal(YRETURN.get(),2)) {
                YINHALT.set(YINHALTK.get());
              }
              m$.pieceVar(YINHALTX,";",YII.get()).set(YINHALT.get());
            }
            //<< . . ;
            //<< . . SET YINHALT=YINHALTX
            YINHALT.set(YINHALTX.get());
            break;
          }
        }
      } while (false);
    }
    //<< 
    //<< IF YRETURN=3 IF $TRANSLATE($GET(YFARBCODE)," ")'="" SET YINHALT=YINHALT_Y_YFARBCODE  ;FIS;25.03.03;23255;ANZEIGEN IN FARBE
    if (mOp.Equal(YRETURN.get(),3)) {
      if (mOp.NotEqual(m$.Fnc.$translate(m$.Fnc.$get(YFARBCODE)," "),"")) {
        YINHALT.set(mOp.Concat(mOp.Concat(YINHALT.get(),m$.var("Y").get()),YFARBCODE.get()));
      }
    }
    //<< QUIT YINHALT
    return YINHALT.get();
  }

  //<< 
  //<< 
  //<< 
  //<< KEY
  public void KEY() {
    //<< ;-------------------------------------------------------------------------------
    //<< ; FORMAT KEY  ACHTUNG EINSPRUNG zb aus ^WWWFORM4   (EINSPRUNG MIT YDATEI,YLFN,YINHALT)
    //<< ;
    //<< ; Params:
    //<< ;
    //<< ; ByRefs:   YINHALTK
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 11-Feb-2010   shobby  SR17139:  Don't show Primary Key if flag is marked on form field.
    //<< ;                           Some assumptions  - This is a primary key so YLFN can be used in WWW121
    //<< ;                                             - Some additional checking that YFORM is valid.
    //<< ; 13-Dec-2006   JW      BR014285: Corrected language relation lookup
    //<< ;-------------------------------------------------------------------------------
    //<< new strGlobal,strRel,strKeys
    mVar strGlobal = m$.var("strGlobal");
    mVar strRel = m$.var("strRel");
    mVar strKeys = m$.var("strKeys");
    m$.newVar(strGlobal,strRel,strKeys);
    //<< 
    //<< SET YINHALTK = ""
    mVar YINHALTK = m$.var("YINHALTK");
    YINHALTK.set("");
    //<< ; FIXME : Get objKeyField once <GRF>
    //<< SET YTYP = $PIECE($GET(^WWW002(0,YDATEI,YLFN,1)),Y,3)
    mVar YTYP = m$.var("YTYP");
    YTYP.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW002",0,m$.var("YDATEI").get(),m$.var("YLFN").get(),1)),m$.var("Y").get(),3));
    //<< SET YQ   = 0
    mVar YQ = m$.var("YQ");
    YQ.set(0);
    //<< IF YINHALT'="" IF $PIECE($GET(^WWW002(0,YDATEI,YLFN,1)),Y,8)'="" DO   ;suchen alle key ;seek All
    if (mOp.NotEqual(m$.var("YINHALT").get(),"")) {
      if (mOp.NotEqual(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW002",0,m$.var("YDATEI").get(),m$.var("YLFN").get(),1)),m$.var("Y").get(),8),"")) {
        do {
          //<< . IF YLFN=1  QUIT:+$PIECE($GET(^WWW002(0,YDATEI,YLFN,1)),Y,20)'=0
          if (mOp.Equal(m$.var("YLFN").get(),1)) {
            if (mOp.NotEqual(mOp.Positive(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW002",0,m$.var("YDATEI").get(),m$.var("YLFN").get(),1)),m$.var("Y").get(),20)),0)) {
              break;
            }
          }
          //<< . IF YLFN'=1 QUIT:$PIECE($GET(^WWW002(0,YDATEI,YLFN,1)),Y,20)>1
          if (mOp.NotEqual(m$.var("YLFN").get(),1)) {
            if (mOp.Greater(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW002",0,m$.var("YDATEI").get(),m$.var("YLFN").get(),1)),m$.var("Y").get(),20),1)) {
              break;
            }
          }
          //<< . NEW YDAT,YKE,YFE,YSAT,YSPR,YDATA
          mVar YDAT = m$.var("YDAT");
          mVar YKE = m$.var("YKE");
          mVar YFE = m$.var("YFE");
          mVar YSAT = m$.var("YSAT");
          mVar YSPR = m$.var("YSPR");
          mVar YDATA = m$.var("YDATA");
          m$.newVarBlock(1,YDAT,YKE,YFE,YSAT,YSPR,YDATA);
          //<< . SET YDATA = $GET(^WWW001(0,YDATEI,1))
          YDATA.set(m$.Fnc.$get(m$.var("^WWW001",0,m$.var("YDATEI").get(),1)));
          //<< . SET YDAT  = $PIECE($GET(^WWW002(0,YDATEI,YLFN,1)),Y,8)   ;relationsdatei
          YDAT.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW002",0,m$.var("YDATEI").get(),m$.var("YLFN").get(),1)),m$.var("Y").get(),8));
          //<< . SET YKE   = $PIECE($GET(^WWW002(0,YDATEI,YLFN,1)),Y,9)   ;relationskey
          YKE.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW002",0,m$.var("YDATEI").get(),m$.var("YLFN").get(),1)),m$.var("Y").get(),9));
          //<< . SET YKE1=0
          mVar YKE1 = m$.var("YKE1");
          YKE1.set(0);
          //<< . IF YKE'="" DO  QUIT:YKE1=1
          if (mOp.NotEqual(YKE.get(),"")) {
            //<< . . FOR YKE2=1:1 SET YKE3=$PIECE(YKE,",",YKE2) QUIT:YKE3=""  DO
            mVar YKE2 = m$.var("YKE2");
            for (YKE2.set(1);(true);YKE2.set(mOp.Add(YKE2.get(),1))) {
              mVar YKE3 = m$.var("YKE3");
              YKE3.set(m$.Fnc.$piece(YKE.get(),",",YKE2.get()));
              if (mOp.Equal(YKE3.get(),"")) {
                break;
              }
              do {
                //<< . . . QUIT:$EXTRACT(YKE3)=""""
                if (mOp.Equal(m$.Fnc.$extract(YKE3.get()),"\"")) {
                  break;
                }
                //<< . . . IF $EXTRACT(YKE3)'="""" DO
                if (mOp.NotEqual(m$.Fnc.$extract(YKE3.get()),"\"")) {
                  //<< . . . . IF '$DATA(@(YKE3))  SET YKE1=1   ;NICHT DA  ;Not yonder
                  if (mOp.Not(m$.Fnc.$data(m$.indirectVar((YKE3.get()))))) {
                    YKE1.set(1);
                  }
                  //<< . . . . IF $GET(@(YKE3))="" SET YKE1=1   ;KEIN WERT ;no value
                  if (mOp.Equal(m$.Fnc.$get(m$.indirectVar((YKE3.get()))),"")) {
                    YKE1.set(1);
                  }
                }
              } while (false);
            }
            if (mOp.Equal(YKE1.get(),1)) {
              break;
            }
          }
          //<< . ;
          //<< . SET YFE=+$PIECE($GET(^WWW002(0,YDATEI,YLFN,1)),Y,10)  ;relationsdatenfeld
          YFE.set(mOp.Positive(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW002",0,m$.var("YDATEI").get(),m$.var("YLFN").get(),1)),m$.var("Y").get(),10)));
          //<< . IF +YFE=0 SET YFE=1
          if (mOp.Equal(mOp.Positive(YFE.get()),0)) {
            YFE.set(1);
          }
          //<< . ;
          //<< . // BR014285 vvvvvvvv
          //<< . set strKeys = $$$QUOTE(YINHALT)
          strKeys.set(include.COMSYSString.$$$QUOTE(m$,m$.var("YINHALT")));
          //<< . IF YKE'="" IF $EXTRACT(YKE)'="," set strKeys = YKE_","_strKeys
          if (mOp.NotEqual(YKE.get(),"")) {
            if (mOp.NotEqual(m$.Fnc.$extract(YKE.get()),",")) {
              strKeys.set(mOp.Concat(mOp.Concat(YKE.get(),","),strKeys.get()));
            }
          }
          //<< . ;
          //<< . set strRel=""
          strRel.set("");
          //<< . ;
          //<< . SET YSPR=$$$WWW001LanguageClassForRelations(YDATA)  // Check language relation
          YSPR.set(include.WWWConst.$$$WWW001LanguageClassForRelations(m$,YDATA));
          //<< . if YSPR'="" do
          if (mOp.NotEqual(YSPR.get(),"")) {
            //<< . . set strGlobal = $$$NodeString(YSPR,strKeys_",SPRACHE")
            strGlobal.set(include.COMSYSWWW.$$$NodeString(m$,YSPR,mOp.Concat(strKeys.get(),",SPRACHE")));
            //<< . . set strRel = $PIECE($$^WWWSETL(strGlobal),Y,1)
            strRel.set(m$.Fnc.$piece(m$.fnc$("WWWSETL.main",strGlobal.get()),m$.var("Y").get(),1));
          }
          //<< . ;
          //<< . if strRel="" do                                   // If no language relation
          if (mOp.Equal(strRel.get(),"")) {
            //<< . . set strGlobal = $$$NodeString(YDAT,strKeys)
            strGlobal.set(include.COMSYSWWW.$$$NodeString(m$,YDAT,strKeys));
            //<< . . SET strRel=$PIECE($$^WWWSETL(strGlobal),Y,YFE)   ;lesen datensatz relation ;read
            strRel.set(m$.Fnc.$piece(m$.fnc$("WWWSETL.main",strGlobal.get()),m$.var("Y").get(),YFE.get()));
          }
          //<< . ;
          //<< . SET YTYP=$PIECE($GET(^WWW003(0,YDAT,YFE,1)),Y,3)
          YTYP.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW003",0,YDAT.get(),YFE.get(),1)),m$.var("Y").get(),3));
          //<< . IF strRel'="" SET YINHALTK=strRel SET YQ=1
          if (mOp.NotEqual(strRel.get(),"")) {
            YINHALTK.set(strRel.get());
            YQ.set(1);
          }
          //<< . ;
          //<< . if $get(YFORM)'="" do
          if (mOp.NotEqual(m$.Fnc.$get(m$.var("YFORM")),"")) {
            //<< . . if $$$WWW120ClassUsedInForm($get(^WWW120(0,YFORM,1)))=YDATEI do
            if (mOp.Equal(include.WWWConst.$$$WWW120ClassUsedInForm(m$,m$.Fnc.$get(m$.var("^WWW120",0,m$.var("YFORM").get(),1))),m$.var("YDATEI").get())) {
              //<< . . . if $$$WWW121DoNotShowPrimaryKey($$Get^WWW121(YFORM,YLFN)) set YRETURN=4 ;SR17139
              if (mOp.Logical(include.WWWConst.$$$WWW121DoNotShowPrimaryKey(m$,m$.fnc$("WWW121.Get",m$.var("YFORM").get(),m$.var("YLFN").get())))) {
                mVar YRETURN = m$.var("YRETURN");
                YRETURN.set(4);
              }
            }
          }
        } while (false);
      }
      m$.restoreVarBlock(1);
    }
    //<< 
    //<< IF YQ=0 DO FORMAT
    if (mOp.Equal(YQ.get(),0)) {
      m$.Cmd.Do("FORMAT");
    }
    //<< IF YQ=1 IF YTYP'="" DO FORMATK
    if (mOp.Equal(YQ.get(),1)) {
      if (mOp.NotEqual(YTYP.get(),"")) {
        m$.Cmd.Do("FORMATK");
      }
    }
    //<< QUIT
    return;
  }

  //<< 
  //<< DATEN
  public void DATEN() {
    //<< ;-------------------------------------------------------------------------------
    //<< ; FORMAT DATEN  ACHTUNG EINSPRUNG VON AUSSEN  (YDATEI,LFN,YINHALT)
    //<< ;
    //<< ; Params:
    //<< ;
    //<< ; ByRefs:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 07-Sep-2012   SCR     SR18105: Color code for form VARPARA
    //<< ; 22-Feb-2007   JW      SR15452: Display "" as No for booleans.
    //<< ; 13-Dec-2006   JW      BR014285: Corrected language relation lookup
    //<< ;-------------------------------------------------------------------------------
    //<< new strGlobal,strRel,strKeys
    mVar strGlobal = m$.var("strGlobal");
    mVar strRel = m$.var("strRel");
    mVar strKeys = m$.var("strKeys");
    m$.newVar(strGlobal,strRel,strKeys);
    //<< 
    //<< SET YINHALTK=""
    mVar YINHALTK = m$.var("YINHALTK");
    YINHALTK.set("");
    //<< ; FIXME : Get objDataField once <GRF>
    //<< SET YTYP=$PIECE($GET(^WWW003(0,YDATEI,YLFN,1)),Y,3)
    mVar YTYP = m$.var("YTYP");
    YTYP.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW003",0,m$.var("YDATEI").get(),m$.var("YLFN").get(),1)),m$.var("Y").get(),3));
    //<< set:YTYP=2 YINHALT=+YINHALT     //SR15452
    if (mOp.Equal(YTYP.get(),2)) {
      m$.var("YINHALT").set(mOp.Positive(m$.var("YINHALT").get()));
    }
    //<< 
    //<< SET YQ=0
    mVar YQ = m$.var("YQ");
    YQ.set(0);
    //<< IF YINHALT'="" IF $PIECE($GET(^WWW003(0,YDATEI,YLFN,1)),Y,8)'="" DO  QUIT
    if (mOp.NotEqual(m$.var("YINHALT").get(),"")) {
      if (mOp.NotEqual(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW003",0,m$.var("YDATEI").get(),m$.var("YLFN").get(),1)),m$.var("Y").get(),8),"")) {
        do {
          //<< . ;WENN KEIN JA/NEIN DANN NICHT WENN NICHT ALLE PARAMETER ANGEZEIGT WERDEN SOLLEN ;when no Not when Not parameter will should
          //<< . IF $PIECE($GET(^WWW003(0,YDATEI,YLFN,1)),Y,3)'=2 IF $PIECE($GET(^WWW003(0,YDATEI,YLFN,1)),Y,28)'=1 QUIT:+$PIECE($GET(^WWW003(0,YDATEI,YLFN,1)),Y,20)'=0
          if (mOp.NotEqual(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW003",0,m$.var("YDATEI").get(),m$.var("YLFN").get(),1)),m$.var("Y").get(),3),2)) {
            if (mOp.NotEqual(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW003",0,m$.var("YDATEI").get(),m$.var("YLFN").get(),1)),m$.var("Y").get(),28),1)) {
              if (mOp.NotEqual(mOp.Positive(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW003",0,m$.var("YDATEI").get(),m$.var("YLFN").get(),1)),m$.var("Y").get(),20)),0)) {
                break;
              }
            }
          }
          //<< . NEW YDAT,YKE,YFE,YSAT,YSPR,YDATA,YV
          mVar YDAT = m$.var("YDAT");
          mVar YKE = m$.var("YKE");
          mVar YFE = m$.var("YFE");
          mVar YSAT = m$.var("YSAT");
          mVar YSPR = m$.var("YSPR");
          mVar YDATA = m$.var("YDATA");
          mVar YV = m$.var("YV");
          m$.newVarBlock(1,YDAT,YKE,YFE,YSAT,YSPR,YDATA,YV);
          //<< . SET YDAT = $PIECE($GET(^WWW003(0,YDATEI,YLFN,1)),Y,8)     // Database
          YDAT.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW003",0,m$.var("YDATEI").get(),m$.var("YLFN").get(),1)),m$.var("Y").get(),8));
          //<< . SET YKE  = $PIECE($GET(^WWW003(0,YDATEI,YLFN,1)),Y,9) // Keys
          YKE.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW003",0,m$.var("YDATEI").get(),m$.var("YLFN").get(),1)),m$.var("Y").get(),9));
          //<< . IF YKE'="" IF $EXTRACT(YKE)'="""" IF '$FIND(YKE,",")  QUIT:'$DATA(@(YKE))  QUIT:$GET(@(YKE))=""
          if (mOp.NotEqual(YKE.get(),"")) {
            if (mOp.NotEqual(m$.Fnc.$extract(YKE.get()),"\"")) {
              if (mOp.Not(m$.Fnc.$find(YKE.get(),","))) {
                if (mOp.Not(m$.Fnc.$data(m$.indirectVar((YKE.get()))))) {
                  break;
                }
                if (mOp.Equal(m$.Fnc.$get(m$.indirectVar((YKE.get()))),"")) {
                  break;
                }
              }
            }
          }
          //<< . ;FIS;24571;07.11.03;KEY VORDATEI MIT MEHREREN VARIABLEN;NUR WENN NICHT "," AN 1.STELLE;TYBD;15,12,2004;ERROR
          //<< . IF YKE'="" IF $EXTRACT(YKE)'=","  IF $FIND(YKE,",")  FOR YV=1:1  QUIT:$PIECE(YKE,",",YV,99)=""  IF $EXTRACT($PIECE(YKE,",",YV))'="""" SET:$GET(@($PIECE(YKE,",",YV)))="" YKE=""  QUIT:YKE=""
          if (mOp.NotEqual(YKE.get(),"")) {
            if (mOp.NotEqual(m$.Fnc.$extract(YKE.get()),",")) {
              if (mOp.Logical(m$.Fnc.$find(YKE.get(),","))) {
                for (YV.set(1);(true);YV.set(mOp.Add(YV.get(),1))) {
                  if (mOp.Equal(m$.Fnc.$piece(YKE.get(),",",YV.get(),99),"")) {
                    break;
                  }
                  if (mOp.NotEqual(m$.Fnc.$extract(m$.Fnc.$piece(YKE.get(),",",YV.get())),"\"")) {
                    if (mOp.Equal(m$.Fnc.$get(m$.indirectVar((m$.Fnc.$piece(YKE.get(),",",YV.get())))),"")) {
                      YKE.set("");
                    }
                    if (mOp.Equal(YKE.get(),"")) {
                      break;
                    }
                  }
                }
              }
            }
          }
          //<< . SET YTYP=""
          YTYP.set("");
          //<< . SET YFE = +$PIECE($GET(^WWW003(0,YDATEI,YLFN,1)),Y,10)
          YFE.set(mOp.Positive(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW003",0,m$.var("YDATEI").get(),m$.var("YLFN").get(),1)),m$.var("Y").get(),10)));
          //<< . IF +YFE=0 SET YFE=1
          if (mOp.Equal(mOp.Positive(YFE.get()),0)) {
            YFE.set(1);
          }
          //<< . ;
          //<< . // BR014285 vvvvvvvv
          //<< . SET YDATA=$GET(^WWW001(0,YDAT,1))
          YDATA.set(m$.Fnc.$get(m$.var("^WWW001",0,YDAT.get(),1)));
          //<< . ;
          //<< . set strKeys = $$$QUOTE(YINHALT)
          strKeys.set(include.COMSYSString.$$$QUOTE(m$,m$.var("YINHALT")));
          //<< . IF YKE'="" set strKeys = YKE_","_strKeys
          if (mOp.NotEqual(YKE.get(),"")) {
            strKeys.set(mOp.Concat(mOp.Concat(YKE.get(),","),strKeys.get()));
          }
          //<< . ;
          //<< . QUIT:$FIND(strKeys,",,")      ; FALSCHER KEY
          if (mOp.Logical(m$.Fnc.$find(strKeys.get(),",,"))) {
            break;
          }
          //<< . QUIT:$FIND(strKeys,"""""")    ; FALSCHER EINTRAG
          if (mOp.Logical(m$.Fnc.$find(strKeys.get(),"\"\""))) {
            break;
          }
          //<< . QUIT:$FIND(strKeys,";")       ; KEIN MULTIFELD
          if (mOp.Logical(m$.Fnc.$find(strKeys.get(),";"))) {
            break;
          }
          //<< . ;
          //<< . SET YTYP=$PIECE($GET(^WWW003(0,YDAT,YFE,1)),Y,3)
          YTYP.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW003",0,YDAT.get(),YFE.get(),1)),m$.var("Y").get(),3));
          //<< . ;
          //<< . set strRel=""
          strRel.set("");
          //<< . ;
          //<< . SET YSPR=$$$WWW001LanguageClassForRelations(YDATA)  // Check language relation
          YSPR.set(include.WWWConst.$$$WWW001LanguageClassForRelations(m$,YDATA));
          //<< . if YSPR'="" do
          if (mOp.NotEqual(YSPR.get(),"")) {
            //<< . . set strGlobal = $$$NodeString(YSPR,strKeys_",SPRACHE")
            strGlobal.set(include.COMSYSWWW.$$$NodeString(m$,YSPR,mOp.Concat(strKeys.get(),",SPRACHE")));
            //<< . . set strRel = $PIECE($$^WWWSETL(strGlobal),Y,1)
            strRel.set(m$.Fnc.$piece(m$.fnc$("WWWSETL.main",strGlobal.get()),m$.var("Y").get(),1));
          }
          //<< . ;
          //<< . if strRel="" do                                   // If no language relation
          if (mOp.Equal(strRel.get(),"")) {
            //<< . . set strGlobal = $$$NodeString(YDAT,strKeys)
            strGlobal.set(include.COMSYSWWW.$$$NodeString(m$,YDAT,strKeys));
            //<< . . SET strRel=$PIECE($$^WWWSETL(strGlobal),Y,YFE)   ;lesen datensatz relation ;read
            strRel.set(m$.Fnc.$piece(m$.fnc$("WWWSETL.main",strGlobal.get()),m$.var("Y").get(),YFE.get()));
          }
          //<< . ;
          //<< . ; IF YRETURN=3 IF $FIND(YDAT,"WWW101") || ($FIND(YDAT,"INPARA")) SET YFARBCODE=$PIECE($$^WWWSETL(strGlobal),Y,2)  ;FIS;25.03.03;23255;ANZEIGEN IN FARBE
          //<< . IF YRETURN=3 IF $FIND(YDAT,"WWW101") || ($FIND(YDAT,"INPARA")) || ($FIND(YDAT,"VARPARA")) SET YFARBCODE=$PIECE($$^WWWSETL(strGlobal),Y,2)  ; SR18105
          if (mOp.Equal(m$.var("YRETURN").get(),3)) {
            if (mOp.Logical(m$.Fnc.$find(YDAT.get(),"WWW101")) || mOp.Logical((m$.Fnc.$find(YDAT.get(),"INPARA"))) || mOp.Logical((m$.Fnc.$find(YDAT.get(),"VARPARA")))) {
              mVar YFARBCODE = m$.var("YFARBCODE");
              YFARBCODE.set(m$.Fnc.$piece(m$.fnc$("WWWSETL.main",strGlobal.get()),m$.var("Y").get(),2));
            }
          }
          //<< . ;
          //<< . quit:strRel=""
          if (mOp.Equal(strRel.get(),"")) {
            break;
          }
          //<< . ;
          //<< . SET YINHALTK=$EXTRACT($TRANSLATE(strRel,"|"," "),1,40)
          YINHALTK.set(m$.Fnc.$extract(m$.Fnc.$translate(strRel.get(),"|"," "),1,40));
          //<< . // TODO: Is this a sensible condition for NOT showing the stored value??
          //<< . IF $EXTRACT(YKE)="""" DO
          if (mOp.Equal(m$.Fnc.$extract(YKE.get()),"\"")) {
            //<< . . SET YINHALT=""
            mVar YINHALT = m$.var("YINHALT");
            YINHALT.set("");
          }
          //<< .
          //<< . SET YQ=1
          YQ.set(1);
          //<< . IF YTYP'="" DO FORMATK
          if (mOp.NotEqual(YTYP.get(),"")) {
            m$.Cmd.Do("FORMATK");
          }
        } while (false);
        return;
      }
      m$.restoreVarBlock(1);
    }
    //<< 
    //<< IF YQ=0 DO FORMAT
    if (mOp.Equal(YQ.get(),0)) {
      m$.Cmd.Do("FORMAT");
    }
    //<< QUIT
    return;
  }

  //<< 
  //<< ; ----------------------------
  //<< ; YTYP      Field type
  //<< ; 3         Memo             ; FIXME : May have had more than 200 chars before $e/$tr but never get "..." - both subr below <GRF>
  //<< ; 5         Password
  //<< ; 8         Currency
  //<< ; ----------------------------
  //<< 
  //<< FORMAT
  public Object FORMAT() {
    //<< ;-------------------------------------------------------------------------------
    //<< ; ByRef :
    //<< ;   YINHALT     Value in and out
    //<< ;   YTYP        Field Type
    //<< ;   YWHR        idCurrency (^WWWWAE)
    //<< ;-------------------------------------------------------------------------------
    //<< QUIT:YTYP=""
    if (mOp.Equal(m$.var("YTYP").get(),"")) {
      return null;
    }
    //<< QUIT:YINHALT=""
    if (mOp.Equal(m$.var("YINHALT").get(),"")) {
      return null;
    }
    //<< SET YINHALT = $$GetLiteral^WWWTR(YTYP,YINHALT)
    mVar YINHALT = m$.var("YINHALT");
    YINHALT.set(m$.fnc$("WWWTR.GetLiteral",m$.var("YTYP").get(),m$.var("YINHALT").get()));
    //<< 
    //<< IF YTYP=8 DO
    if (mOp.Equal(m$.var("YTYP").get(),8)) {
      //<< . IF $GET(YWHR)'="" DO   ;WÄHRUNG ANZEIGEN;TYBD;15.04.2003 ;money standard display
      if (mOp.NotEqual(m$.Fnc.$get(m$.var("YWHR")),"")) {
        do {
          //<< . . IF +$PIECE($GET(^WWWWAE(0,YWHR,1)),Y,4)=0 SET YINHALT=$$^WWWWHR(YWHR)_" "_YINHALT QUIT
          if (mOp.Equal(mOp.Positive(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWWWAE",0,m$.var("YWHR").get(),1)),m$.var("Y").get(),4)),0)) {
            YINHALT.set(mOp.Concat(mOp.Concat(m$.fnc$("WWWWHR.main",m$.var("YWHR").get())," "),YINHALT.get()));
            break;
          }
          //<< . . SET YINHALT=YINHALT_" "_$$^WWWWHR(YWHR)
          YINHALT.set(mOp.Concat(mOp.Concat(YINHALT.get()," "),m$.fnc$("WWWWHR.main",m$.var("YWHR").get())));
        } while (false);
      }
    }
    //<< 
    //<< IF YTYP=5 SET YINHALT = $EXTRACT("*****************",1,$LENGTH(YINHALT)) QUIT
    if (mOp.Equal(m$.var("YTYP").get(),5)) {
      YINHALT.set(m$.Fnc.$extract("*****************",1,m$.Fnc.$length(YINHALT.get())));
      return null;
    }
    //<< IF YTYP=3 SET YINHALT = $TRANSLATE($EXTRACT($PIECE(YINHALT,"|",1),1,200),"|"," ") SET:$EXTRACT(YINHALT,200)'="" YINHALT=YINHALT_"..." QUIT
    if (mOp.Equal(m$.var("YTYP").get(),3)) {
      YINHALT.set(m$.Fnc.$translate(m$.Fnc.$extract(m$.Fnc.$piece(YINHALT.get(),"|",1),1,200),"|"," "));
      if (mOp.NotEqual(m$.Fnc.$extract(YINHALT.get(),200),"")) {
        YINHALT.set(mOp.Concat(YINHALT.get(),"..."));
      }
      return null;
    }
    //<< QUIT
    return null;
  }

  //<< 
  //<< 
  //<< 
  //<< FORMATK
  public Object FORMATK() {
    //<< ;-------------------------------------------------------------------------------
    //<< ; ByRef :
    //<< ;   YINHALTK    Value in and out
    //<< ;   YTYP        Field Type
    //<< ;   YWHR        idCurrency (^WWWWAE)
    //<< ;-------------------------------------------------------------------------------
    //<< QUIT:YTYP=""
    if (mOp.Equal(m$.var("YTYP").get(),"")) {
      return null;
    }
    //<< QUIT:YINHALTK=""
    if (mOp.Equal(m$.var("YINHALTK").get(),"")) {
      return null;
    }
    //<< SET YINHALTK = $$GetLiteral^WWWTR(YTYP,YINHALTK)
    mVar YINHALTK = m$.var("YINHALTK");
    YINHALTK.set(m$.fnc$("WWWTR.GetLiteral",m$.var("YTYP").get(),m$.var("YINHALTK").get()));
    //<< 
    //<< IF YTYP=8 IF $GET(YWHR)'="" SET YINHALTK=YINHALTK_" "_$$^WWWWHR(YWHR)   ;WÄHRUNG ANZEIGEN ;money standard display
    if (mOp.Equal(m$.var("YTYP").get(),8)) {
      if (mOp.NotEqual(m$.Fnc.$get(m$.var("YWHR")),"")) {
        YINHALTK.set(mOp.Concat(mOp.Concat(YINHALTK.get()," "),m$.fnc$("WWWWHR.main",m$.var("YWHR").get())));
      }
    }
    //<< IF YTYP=5 SET YINHALTK = $EXTRACT("*****************",1,$LENGTH(YINHALTK)) QUIT
    if (mOp.Equal(m$.var("YTYP").get(),5)) {
      YINHALTK.set(m$.Fnc.$extract("*****************",1,m$.Fnc.$length(YINHALTK.get())));
      return null;
    }
    //<< IF YTYP=3 SET YINHALTK = $TRANSLATE($EXTRACT($PIECE(YINHALTK,"|",1),1,200),"|"," ") SET:$EXTRACT(YINHALTK,200)'="" YINHALTK=YINHALTK_"..." QUIT
    if (mOp.Equal(m$.var("YTYP").get(),3)) {
      YINHALTK.set(m$.Fnc.$translate(m$.Fnc.$extract(m$.Fnc.$piece(YINHALTK.get(),"|",1),1,200),"|"," "));
      if (mOp.NotEqual(m$.Fnc.$extract(YINHALTK.get(),200),"")) {
        YINHALTK.set(mOp.Concat(YINHALTK.get(),"..."));
      }
      return null;
    }
    //<< QUIT
    return null;
  }

//<< 
//<< 
}
