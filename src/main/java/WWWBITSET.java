//*****************************************************************************
//** TASC - ALPHALINC - MAC WWWBITSET
//** Innovatium Systems - Code Converter - v1.27
//** 2014-05-22 00:15:35
//*****************************************************************************

import mLibrary.*;


//<< WWWBITSET(YDATEI,YKEY,SET,YFELD,YKILLBI,YBITLIST,NOBACKGROUND,YYM,YXREF)
public class WWWBITSET extends mClass {

  public Object main(Object ... _p) {
    mVar YDATEI = m$.newVarRef("YDATEI",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar YKEY = m$.newVarRef("YKEY",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar SET = m$.newVarRef("SET",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    mVar YFELD = m$.newVarRef("YFELD",(((_p!=null)&&(_p.length>=4))?_p[3]:null));
    mVar YKILLBI = m$.newVarRef("YKILLBI",(((_p!=null)&&(_p.length>=5))?_p[4]:null));
    mVar YBITLIST = m$.newVarRef("YBITLIST",(((_p!=null)&&(_p.length>=6))?_p[5]:null));
    mVar NOBACKGROUND = m$.newVarRef("NOBACKGROUND",(((_p!=null)&&(_p.length>=7))?_p[6]:null));
    mVar YYM = m$.newVarRef("YYM",(((_p!=null)&&(_p.length>=8))?_p[7]:null));
    mVar YXREF = m$.newVarRef("YXREF",(((_p!=null)&&(_p.length>=9))?_p[8]:null));
    return _WWWBITSET(YDATEI,YKEY,SET,YFELD,YKILLBI,YBITLIST,NOBACKGROUND,YYM,YXREF);
  }

  public Object _WWWBITSET(Object ... _p) {
    mVar YDATEI = m$.newVarRef("YDATEI",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar YKEY = m$.newVarRef("YKEY",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar SET = m$.newVarRef("SET",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    mVar YFELD = m$.newVarRef("YFELD",(((_p!=null)&&(_p.length>=4))?_p[3]:null));
    mVar YKILLBI = m$.newVarRef("YKILLBI",(((_p!=null)&&(_p.length>=5))?_p[4]:null));
    mVar YBITLIST = m$.newVarRef("YBITLIST",(((_p!=null)&&(_p.length>=6))?_p[5]:null));
    mVar NOBACKGROUND = m$.newVarRef("NOBACKGROUND",(((_p!=null)&&(_p.length>=7))?_p[6]:null));
    mVar YYM = m$.newVarRef("YYM",(((_p!=null)&&(_p.length>=8))?_p[7]:null));
    mVar YXREF = m$.newVarRef("YXREF",(((_p!=null)&&(_p.length>=9))?_p[8]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Description of Function :
    //<< ;       BITS SETZTEN ODER L÷SCHEN
    //<< ;       S OK=$$^WWWBITSET(YDATEI,YKEY,1)  ;BEISPIEL
    //<< ;
    //<< ; Inputs :
    //<< ;   YDATEI          = DATEI
    //<< ;   YKEY            = KEY
    //<< ;   SET             = 1 = SET 1 ;table-mat table-mat
    //<< ;   SET             = 0 = KILL, SET 0
    //<< ;   YFELD           = DATENSATZ ; RECORD
    //<< ;   YKILLBI         = 1  ;KILL bi FILE
    //<< ;   YBITLIST        ="1,2,3" ;DANN NUR ƒNDERUNG DER BITS , WENN "" DANN ALLE BITS
    //<< ;   NOBACKGROUND    ="1" = NOT IN BACKGROUND
    //<< ;   YYM             = COMPANY OR 0 FOR CENTRAL FILE OR ""
    //<< ;   YXREF           = XREF FILE FOR BITS LIKE
    //<< ;
    //<< ; ByRef :
    //<< ;
    //<< ; Returns :
    //<< ;
    //<< ; History :
    //<< ; 28-Sep-2007   GRF     Doco; quits
    //<< ; 31-May-2007   HeberB  BR014465:Add new characters
    //<< ; 23.06.2003    DT
    //<< ;-------------------------------------------------------------------------------
    //<< ;QUIT ""  ;AUSGESCHALTET = TEST TYBD;24.06.2003
    //<< NEW RETURN,YRET,WWWYM
    mVar RETURN = m$.var("RETURN");
    mVar YRET = m$.var("YRET");
    mVar WWWYM = m$.var("WWWYM");
    m$.newVar(RETURN,YRET,WWWYM);
    //<< 
    //<< SET RETURN=""
    RETURN.set("");
    //<< QUIT:$GET(YDATEI)="" RETURN
    if (mOp.Equal(m$.Fnc.$get(YDATEI),"")) {
      return RETURN.get();
    }
    //<< ;QUIT:$GET(YKEY)="" RETURN
    //<< QUIT:$TR($GET(YKEY),"""")="" RETURN        ;BEC;27141;11.01.05
    if (mOp.Equal(m$.Fnc.$translate(m$.Fnc.$get(YKEY),"\""),"")) {
      return RETURN.get();
    }
    //<< 
    //<< SET WWWYM    = $GET(YYM)
    WWWYM.set(m$.Fnc.$get(YYM));
    //<< SET YKILLBI  = $GET(YKILLBI)
    YKILLBI.set(m$.Fnc.$get(YKILLBI));
    //<< SET YBITLIST = $GET(YBITLIST)
    YBITLIST.set(m$.Fnc.$get(YBITLIST));
    //<< SET YXREF    = $GET(YXREF)
    YXREF.set(m$.Fnc.$get(YXREF));
    //<< SET SET      = $GET(SET)
    SET.set(m$.Fnc.$get(SET));
    //<< 
    //<< IF $GET(NOBACKGROUND)'=1 IF $PIECE($GET(^WWW012(0,YM,1)),Y,167)=1 DO  IF RETURN=1 QUIT RETURN  ;HINTERGRUNDVERARBEITUNG
    if (mOp.NotEqual(m$.Fnc.$get(NOBACKGROUND),1)) {
      if (mOp.Equal(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW012",0,m$.var("YM").get(),1)),m$.var("Y").get(),167),1)) {
        do {
          //<< . NEW YNEXT
          mVar YNEXT = m$.var("YNEXT");
          m$.newVar(YNEXT);
          //<< . IF '$DATA(^WWWBITRUN) SET ^WWWBITRUN=""
          if (mOp.Not(m$.Fnc.$data(m$.var("^WWWBITRUN")))) {
            m$.var("^WWWBITRUN").set("");
          }
          //<< . LOCK +^WWWBITRUN:0 IF $TEST LOCK -^WWWBITRUN JOB ^WWWBITRUN::0 IF '$TEST QUIT  ;NICHT M÷GLICH ;Not potential
          m$.Cmd.LockInc(m$.var("^WWWBITRUN"),0);
          if (mOp.Logical(m$.Fnc.$test())) {
            m$.Cmd.Unlock(m$.var("^WWWBITRUN"));
            m$.Cmd.Job("WWWBITRUN.main");
            if (mOp.Not(m$.Fnc.$test())) {
              break;
            }
          }
          //<< . SET YNEXT=$$^WWWNEXT("WWWBITRUN")
          YNEXT.set(m$.fnc$("WWWNEXT.main","WWWBITRUN"));
          //<< . SET ^WWWBITRUN(YM,YNEXT,1,1)=YDATEI
          m$.var("^WWWBITRUN",m$.var("YM").get(),YNEXT.get(),1,1).set(YDATEI.get());
          //<< . SET ^WWWBITRUN(YM,YNEXT,2,1)=YKEY
          m$.var("^WWWBITRUN",m$.var("YM").get(),YNEXT.get(),2,1).set(YKEY.get());
          //<< . SET ^WWWBITRUN(YM,YNEXT,3,1)=YFELD
          m$.var("^WWWBITRUN",m$.var("YM").get(),YNEXT.get(),3,1).set(YFELD.get());
          //<< . SET ^WWWBITRUN(YM,YNEXT,4,1)=SET_Y_YKILLBI_Y_YBITLIST_Y_WWWYM_Y_YXREF
          m$.var("^WWWBITRUN",m$.var("YM").get(),YNEXT.get(),4,1).set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(SET.get(),m$.var("Y").get()),YKILLBI.get()),m$.var("Y").get()),YBITLIST.get()),m$.var("Y").get()),WWWYM.get()),m$.var("Y").get()),YXREF.get()));
          //<< . SET RETURN=1
          RETURN.set(1);
        } while (false);
        if (mOp.Equal(RETURN.get(),1)) {
          return RETURN.get();
        }
      }
    }
    //<< 
    //<< ;UMLAUTE IN $TR ; TYBD;30,9,2004
    //<< ;BR014465
    //<< ;SET LC="‹ƒ÷¸‰ˆﬂ][\}{|abcdefghijklmnopqrstuvwxyz,()@#$%^&*_=+<>?/"_$CHAR(128)_""""_" "   ;SPEEDUP;TYBD;25.09.2004
    //<< ;SET UC="UAOUAOSUAOUAOABCDEFGHIJKLMNOPQRSTUVWXYZ                   "
    //<< SET LC="·‡„‚ÈËÍÌÏÓÛÚıÙ˙˘˚Á‹ƒ÷¸‰ˆﬂ][\}{|abcdefghijklmnopqrstuvwxyz,()@#$%^&*_=+<>?/"_$CHAR(128)_""""_" "   ;SPEEDUP;TYBD;25.09.2004
    mVar LC = m$.var("LC");
    LC.set(mOp.Concat(mOp.Concat(mOp.Concat("·‡„‚ÈËÍÌÏÓÛÚıÙ˙˘˚Á‹ƒ÷¸‰ˆﬂ][\\}{|abcdefghijklmnopqrstuvwxyz,()@#$%^&*_=+<>?/",m$.Fnc.$char(128)),"\"")," "));
    //<< SET UC="¡¿√¬…» ÕÃŒ”“’‘⁄Ÿ€«UAOUAOSUAOUAOABCDEFGHIJKLMNOPQRSTUVWXYZ                   "
    mVar UC = m$.var("UC");
    UC.set("¡¿√¬…» ÕÃŒ”“’‘⁄Ÿ€«UAOUAOSUAOUAOABCDEFGHIJKLMNOPQRSTUVWXYZ                   ");
    //<< SET WWWYM=$P($GET(YYM),",",1)  ;NICHT MIT ","
    WWWYM.set(m$.Fnc.$piece(m$.Fnc.$get(YYM),",",1));
    //<< IF WWWYM="" SET WWWYM=$$^WWWYM(YDATEI,0)  ;VERSCHOBEN;TYBD;27.10,2004
    if (mOp.Equal(WWWYM.get(),"")) {
      WWWYM.set(m$.fnc$("WWWYM.main",YDATEI.get(),0));
    }
    //<< IF $GET(YXREF)'="" DO  IF +$PIECE($GET(^WWW001(0,YDATEI,1)),Y,24)=0 QUIT RETURN  ;SETZEN XREF DATEI
    if (mOp.NotEqual(m$.Fnc.$get(YXREF),"")) {
      //<< . SET RETURN=$$^WWWBITSETXREF(YDATEI,YXREF,YKEY,$PIECE(YKEY,",",$LENGTH(YKEY,",")),SET,WWWYM)  ;TYBD;20,12,2004;UNTERBITMAP
      RETURN.set(m$.fnc$("WWWBITSETXREF.main",YDATEI.get(),YXREF.get(),YKEY.get(),m$.Fnc.$piece(YKEY.get(),",",m$.Fnc.$length(YKEY.get(),",")),SET.get(),WWWYM.get()));
      //<< . SET RETURN=1
      RETURN.set(1);
      if (mOp.Equal(mOp.Positive(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW001",0,YDATEI.get(),1)),m$.var("Y").get(),24)),0)) {
        return RETURN.get();
      }
    }
    do {
      //<< 
      //<< ;SET YRET(1)="SET YRET=$SORTBEGIN(^"_YDATEI_"b)" XECUTE YRET(1)
      //<< ;SET YRET(1)="SET YRET=$SORTBEGIN(^"_YDATEI_"bi)" XECUTE YRET(1)
      //<< DO
      //<< . NEW BIT,BITX,BITS,BITM,COUNT,FIELD,YLFN,YLFN1,OK,YKEY1,ID,SCHL
      mVar BIT = m$.var("BIT");
      mVar BITX = m$.var("BITX");
      mVar BITS = m$.var("BITS");
      mVar BITM = m$.var("BITM");
      mVar COUNT = m$.var("COUNT");
      mVar FIELD = m$.var("FIELD");
      mVar YLFN = m$.var("YLFN");
      mVar YLFN1 = m$.var("YLFN1");
      mVar OK = m$.var("OK");
      mVar YKEY1 = m$.var("YKEY1");
      mVar ID = m$.var("ID");
      mVar SCHL = m$.var("SCHL");
      m$.newVar(BIT,BITX,BITS,BITM,COUNT,FIELD,YLFN,YLFN1,OK,YKEY1,ID,SCHL);
      //<< . SET OK=0
      OK.set(0);
      //<< . DO
      do {
        //<< . . SET YKEY=$EXTRACT(YKEY,1,128)             ;BEC;27141;11.01.05
        YKEY.set(m$.Fnc.$extract(YKEY.get(),1,128));
        //<< . . SET SCHL(1)="^"_YDATEI_"bi("_""""_WWWYM_""""_","_2_","_""""_$TRANSLATE(YKEY,"""")_""""_")"
        SCHL.var(1).set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("^",YDATEI.get()),"bi("),"\""),WWWYM.get()),"\""),","),2),","),"\""),m$.Fnc.$translate(YKEY.get(),"\"")),"\""),")"));
        //<< . . SET SCHL(10)="^"_YDATEI_"bi("_""""_WWWYM_""""_","_2_","_""""_$TRANSLATE(YKEY,"""")_""""_",ID)"
        SCHL.var(10).set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("^",YDATEI.get()),"bi("),"\""),WWWYM.get()),"\""),","),2),","),"\""),m$.Fnc.$translate(YKEY.get(),"\"")),"\""),",ID)"));
        //<< . . SET SCHL(2)="^"_YDATEI_"bi("_""""_WWWYM_""""_","_1_",ID,"_""""_$TRANSLATE(YKEY,"""")_""""_")"
        SCHL.var(2).set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("^",YDATEI.get()),"bi("),"\""),WWWYM.get()),"\""),","),1),",ID,"),"\""),m$.Fnc.$translate(YKEY.get(),"\"")),"\""),")"));
        //<< . . SET SCHL(3)="^"_YDATEI_"bi("_""""_WWWYM_""""_")"
        SCHL.var(3).set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("^",YDATEI.get()),"bi("),"\""),WWWYM.get()),"\""),")"));
        //<< . . IF '$DATA(@SCHL(1)) DO
        if (mOp.Not(m$.Fnc.$data(m$.indirectVar(SCHL.var(1).get())))) {
          //<< . . . LOCK +@SCHL(3):1
          m$.Cmd.LockInc(m$.indirectVar(m$.var("SCHL",3).get()),1);
          //<< . . . SET ID=$GET(@SCHL(3))+1
          ID.set(mOp.Add(m$.Fnc.$get(m$.indirectVar(SCHL.var(3).get())),1));
          //<< . . . SET @SCHL(3)=ID
          m$.indirectVar(SCHL.var(3).get()).set(ID.get());
          //<< . . . SET @SCHL(10)=""
          m$.indirectVar(SCHL.var(10).get()).set("");
          //<< . . . SET @SCHL(2)=""
          m$.indirectVar(SCHL.var(2).get()).set("");
          //<< . . . LOCK -@SCHL(3)
          m$.Cmd.Unlock(m$.indirectVar(m$.var("SCHL",3).get()));
        }
        //<< . . ;
        //<< . . SET ID=""
        ID.set("");
        //<< . . SET ID=$ORDER(@SCHL(10))
        ID.set(m$.Fnc.$order(m$.indirectVar(SCHL.var(10).get())));
        //<< . . IF ID'="" DO
        if (mOp.NotEqual(ID.get(),"")) {
          //<< . . . ;SET YKEY=ID   ;NEUE ID ;table-mat ID
          //<< . . . SET OK=1
          OK.set(1);
        }
      } while(false);
      //<< . ;
      //<< . QUIT:OK=0
      if (mOp.Equal(OK.get(),0)) {
        break;
      }
      //<< . ;
      //<< . SET BIT=0   ;=DATENSATZ VORHANDEN j/n ;on hand
      BIT.set(0);
      //<< . SET BITX=1  ;=DATENbit
      BITX.set(1);
      //<< . SET OK=$$^WWWBIT(YDATEI,ID,BIT,BITX,SET,WWWYM)  ;KEY, MAIN BIT 0 = EXISTS
      OK.set(m$.fnc$("WWWBIT.main",YDATEI.get(),ID.get(),BIT.get(),BITX.get(),SET.get(),WWWYM.get()));
      //<< . DO  ;SET KEY ALS FULLTEXT ;table-mat KEY when
      do {
        //<< . . SET BIT=9999  ;F‹R FULLTEXT DES KEY ;to KEY
        BIT.set(9999);
        //<< . . IF YUMLAU="" SET BITX=$TRANSLATE(YKEY,LC,UC)  ;TYBD;6,11,2003;MIT UMSETZTUNG;26526
        if (mOp.Equal(m$.var("YUMLAU").get(),"")) {
          BITX.set(m$.Fnc.$translate(YKEY.get(),LC.get(),UC.get()));
        }
        //<< . . IF YUMLAU'="" SET BITX=$$^WWWUMLAU(YKEY,1)  ;TYBD;6,11,2003;MIT UMSETZTUNG;26526
        if (mOp.NotEqual(m$.var("YUMLAU").get(),"")) {
          BITX.set(m$.fnc$("WWWUMLAU.main",YKEY.get(),1));
        }
        //<< . . SET OK=$$^WWWBIT(YDATEI,ID,BIT,BITX,SET,WWWYM)  ;KEY IN FULLTEXT ;KEY within
        OK.set(m$.fnc$("WWWBIT.main",YDATEI.get(),ID.get(),BIT.get(),BITX.get(),SET.get(),WWWYM.get()));
      } while(false);
      //<< . ;
      //<< . IF YKILLBI=1 DO  ;L÷SCHEN bi, da datensatz gelˆscht
      if (mOp.Equal(YKILLBI.get(),1)) {
        //<< . . KILL @SCHL(10)
        m$.indirectVar(SCHL.var(10).get()).kill();
        //<< . . KILL @SCHL(2)
        m$.indirectVar(SCHL.var(2).get()).kill();
      }
      //<< . ;
      //<< . SET RETURN=1  ;OK
      RETURN.set(1);
      //<< . IF YFELD="" QUIT  ;NO DELETE OR SET ON NO DATA;TYBD;29,10,2004
      if (mOp.Equal(YFELD.get(),"")) {
        break;
      }
      //<< . ;
      //<< . ;DATENFELDER
      //<< . ;
      //<< . SET YLFN=""
      YLFN.set("");
      //<< . FOR  SET YLFN=$ORDER(^WWW001B(0,YDATEI,YLFN)) QUIT:YLFN=""  DO
      for (;true;) {
        YLFN.set(m$.Fnc.$order(m$.var("^WWW001B",0,YDATEI.get(),YLFN.get())));
        if (mOp.Equal(YLFN.get(),"")) {
          break;
        }
        do {
          //<< . . IF $GET(YBITLIST)'="" QUIT:'$FIND(","_YBITLIST_",",","_YLFN_",")  ;NICHT IN DER LISTE ;Not within the list
          if (mOp.NotEqual(m$.Fnc.$get(YBITLIST),"")) {
            if (mOp.Not(m$.Fnc.$find(mOp.Concat(mOp.Concat(",",YBITLIST.get()),","),mOp.Concat(mOp.Concat(",",YLFN.get()),",")))) {
              break;
            }
          }
          //<< . . SET YLFN1=$GET(^WWW001B(0,YDATEI,YLFN,1))
          YLFN1.set(m$.Fnc.$get(m$.var("^WWW001B",0,YDATEI.get(),YLFN.get(),1)));
          //<< . . DO SETBIT
          m$.Cmd.Do("SETBIT");
        } while (false);
      }
      //<< . ;
      //<< . ;CUSTOMIZING
      //<< . SET YLFN=""
      YLFN.set("");
      //<< . FOR  SET YLFN=$ORDER(^WWW001BD(0,YDATEI,YM,YLFN)) QUIT:YLFN=""  DO
      for (;true;) {
        YLFN.set(m$.Fnc.$order(m$.var("^WWW001BD",0,YDATEI.get(),m$.var("YM").get(),YLFN.get())));
        if (mOp.Equal(YLFN.get(),"")) {
          break;
        }
        //<< . . SET YLFN1=$GET(^WWW001BD(0,YDATEI,YM,YLFN,1))
        YLFN1.set(m$.Fnc.$get(m$.var("^WWW001BD",0,YDATEI.get(),m$.var("YM").get(),YLFN.get(),1)));
        //<< . . DO SETBIT
        m$.Cmd.Do("SETBIT");
      }
    } while(false);
    //<< 
    //<< ;SET YRET(1)="SET YRET=$SORTEND(^"_YDATEI_"bi)" XECUTE YRET(1)
    //<< ;SET YRET(1)="SET YRET=$SORTEND(^"_YDATEI_"b)" XECUTE YRET(1)
    //<< QUIT RETURN
    return RETURN.get();
  }

  //<< 
  //<< SETBIT ;
  public void SETBIT() {
    //<< ;FULLTEXT
    //<< IF +$PIECE(YLFN1,Y,5)=1 IF $PIECE(YFELD,Y,YLFN)'="" DO    ;FULLTEXT BIT = GENAUER INHALT ;bit purport
    if (mOp.Equal(mOp.Positive(m$.Fnc.$piece(m$.var("YLFN1").get(),m$.var("Y").get(),5)),1)) {
      if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YFELD").get(),m$.var("Y").get(),m$.var("YLFN").get()),"")) {
        //<< . SET BIT=9999  ;FELDNUMMER = FULLTEXT
        mVar BIT = m$.var("BIT");
        BIT.set(9999);
        //<< . ;SET BITX(2)=$TRANSLATE($PIECE(YFELD,Y,YLFN),",;:-_!?=(){}ß$&/¥#'|<>."_"""","                       ")  ;TYBD;BIT MIT . UND , BEI 0.10 UND
        //<< . SET BITX(2)=$TRANSLATE($PIECE(YFELD,Y,YLFN),";:_!?=(){}ß$&¥#'|<>"_"""","                       ")
        mVar BITX = m$.var("BITX");
        BITX.var(2).set(m$.Fnc.$translate(m$.Fnc.$piece(m$.var("YFELD").get(),m$.var("Y").get(),m$.var("YLFN").get()),mOp.Concat(";:_!?=(){}ß$&¥#'|<>","\""),"                       "));
        //<< . FOR BITX(1)=1:1 QUIT:$PIECE(BITX(2)," ",BITX(1),9999)=""  DO
        for (m$.var("BITX",1).set(1);(true);m$.var("BITX",1).set(mOp.Add(m$.var("BITX",1).get(),1))) {
          if (mOp.Equal(m$.Fnc.$piece(BITX.var(2).get()," ",BITX.var(1).get(),9999),"")) {
            break;
          }
          do {
            //<< . . SET BITX=$EXTRACT($PIECE(BITX(2)," ",BITX(1)),1,50)
            BITX.set(m$.Fnc.$extract(m$.Fnc.$piece(BITX.var(2).get()," ",BITX.var(1).get()),1,50));
            //<< . . ;
            //<< . . ;vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv DISABLED BLOCK
            //<< . . ;AB HIER PR‹FUNG DER ZAHLEN ALS .;TYBD;17.01.2005
            //<< . . ;IF $FIND(BITX,".") DO  ;"." WIRD NICHT IN WWWUMLAU UMGESETZT;FIS;03.03.05
            //<< . . . IF $EXTRACT($REVERSE($PIECE(BITX,".",2)))=0!($EXTRACT($PIECE(BITX,".",2))>0) QUIT  ;NUMBER DO NOT CHANGE;TYBD;17.1.2004
            //<< . . . SET BITX=$TRANSLATE(BITX,"."," ")
            //<< . . ;^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
            //<< . . ;
            //<< . . ;AB HIER PR‹FUNG DER ZAHLEN ALS ,;TYBD;17.01.2005
            //<< . . IF $FIND(BITX,",") DO
            if (mOp.Logical(m$.Fnc.$find(BITX.get(),","))) {
              do {
                //<< . . . IF $EXTRACT($REVERSE($PIECE(BITX,",",2)))=0!($EXTRACT($PIECE(BITX,",",2))>0) QUIT  ;NUMBER DO NOT CHANGE;TYBD;17.1.2004
                if (mOp.Or(mOp.Equal(m$.Fnc.$extract(m$.Fnc.$reverse(m$.Fnc.$piece(BITX.get(),",",2))),0),(mOp.Greater(m$.Fnc.$extract(m$.Fnc.$piece(BITX.get(),",",2)),0)))) {
                  break;
                }
                //<< . . . SET BITX=$TRANSLATE(BITX,","," ")
                BITX.set(m$.Fnc.$translate(BITX.get(),","," "));
              } while (false);
            }
            //<< . . ;
            //<< . . ;vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv DISABLED BLOCK
            //<< . . ;AB HIER PR‹FUNG DER ZAHLEN ALS ,;TYBD;17.01.2005
            //<< . . ;IF $FIND(BITX,"-") DO  ;"-" WIRD NICHT IN WWWUMLAU UMGESETZT;FIS;03.03.05
            //<< . . ;. IF $EXTRACT($REVERSE($PIECE(BITX,"-",2)))=0!($EXTRACT($PIECE(BITX,"-",2))>0) QUIT  ;NUMBER DO NOT CHANGE;TYBD;17.1.2004
            //<< . . ;. SET BITX=$TRANSLATE(BITX,"-"," ")
            //<< . . ;^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
            //<< . . ;
            //<< . . ;AB HIER PR‹FUNG DER ZAHLEN ALS ,;TYBD;17.01.2005
            //<< . . IF $FIND(BITX,"/") DO
            if (mOp.Logical(m$.Fnc.$find(BITX.get(),"/"))) {
              do {
                //<< . . . IF $EXTRACT($REVERSE($PIECE(BITX,"/",2)))=0!($EXTRACT($PIECE(BITX,"/",2))>0) QUIT  ;NUMBER DO NOT CHANGE;TYBD;17.1.2004
                if (mOp.Or(mOp.Equal(m$.Fnc.$extract(m$.Fnc.$reverse(m$.Fnc.$piece(BITX.get(),"/",2))),0),(mOp.Greater(m$.Fnc.$extract(m$.Fnc.$piece(BITX.get(),"/",2)),0)))) {
                  break;
                }
                //<< . . . SET BITX=$TRANSLATE(BITX,"/"," ")
                BITX.set(m$.Fnc.$translate(BITX.get(),"/"," "));
              } while (false);
            }
            //<< . . ;
            //<< . . QUIT:$TRANSLATE(BITX," ")=""  ;WENN KEIN INHALT;NO CONTENT;TYBD;29,10,2004
            if (mOp.Equal(m$.Fnc.$translate(BITX.get()," "),"")) {
              break;
            }
            //<< . . ;
            //<< . . ;SET BITX=$TRANSLATE(BITX,",;:-_!=()/&¥#'")  ;DATEN Bit;TYBD;6,11,2003;NUR WWWUMLAU;26526
            //<< . . IF YUMLAU="" SET BITX=$TRANSLATE(BITX,LC,UC)
            if (mOp.Equal(m$.var("YUMLAU").get(),"")) {
              BITX.set(m$.Fnc.$translate(BITX.get(),m$.var("LC").get(),m$.var("UC").get()));
            }
            //<< . . IF YUMLAU'="" SET BITX=$$^WWWUMLAU(BITX,1,1)
            if (mOp.NotEqual(m$.var("YUMLAU").get(),"")) {
              BITX.set(m$.fnc$("WWWUMLAU.main",BITX.get(),1,1));
            }
            //<< . . QUIT:$TRANSLATE(BITX," ")=""  ;WENN KEIN INHALT;NO CONTENT;TYBD;29,10,2004
            if (mOp.Equal(m$.Fnc.$translate(BITX.get()," "),"")) {
              break;
            }
            //<< . . ;
            //<< . . SET OK=$$^WWWBIT(YDATEI,ID,BIT,BITX,SET,WWWYM)
            mVar OK = m$.var("OK");
            OK.set(m$.fnc$("WWWBIT.main",m$.var("YDATEI").get(),m$.var("ID").get(),BIT.get(),BITX.get(),m$.var("SET").get(),m$.var("WWWYM").get()));
          } while (false);
        }
      }
    }
    //<< 
    //<< ;NUR WENN GLEICH DER VORGABE ;only when without delay the default
    //<< ;IF $PIECE(YLFN1,Y,1)=$PIECE(YFELD,Y,YLFN) DO  QUIT  ;NUR WENN GLEICH INHALT
    //<< IF $PIECE(YLFN1,Y,1)'="" IF $PIECE(YLFN1,Y,1)=$PIECE(YFELD,Y,YLFN) DO    ;NUR WENN GLEICH INHALT  ;FIS;24.06.04;25940
    if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YLFN1").get(),m$.var("Y").get(),1),"")) {
      if (mOp.Equal(m$.Fnc.$piece(m$.var("YLFN1").get(),m$.var("Y").get(),1),m$.Fnc.$piece(m$.var("YFELD").get(),m$.var("Y").get(),m$.var("YLFN").get()))) {
        //<< . SET BIT=YLFN  ;FELDNUMMER
        mVar BIT = m$.var("BIT");
        BIT.set(m$.var("YLFN").get());
        //<< . SET BITX=1    ;DATENbit IMMER 1 ;constantly
        mVar BITX = m$.var("BITX");
        BITX.set(1);
        //<< . SET OK=$$^WWWBIT(YDATEI,ID,BIT,BITX,SET,WWWYM)
        mVar OK = m$.var("OK");
        OK.set(m$.fnc$("WWWBIT.main",m$.var("YDATEI").get(),m$.var("ID").get(),BIT.get(),BITX.get(),m$.var("SET").get(),m$.var("WWWYM").get()));
      }
    }
    //<< 
    //<< ;NUR WENN NICHT LEER ;only when Not void
    //<< IF $PIECE(YLFN1,Y,2)=1 IF $PIECE(YFELD,Y,YLFN)'="" DO   ;NUR WENN NICHT LEER ;only when Not void
    if (mOp.Equal(m$.Fnc.$piece(m$.var("YLFN1").get(),m$.var("Y").get(),2),1)) {
      if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YFELD").get(),m$.var("Y").get(),m$.var("YLFN").get()),"")) {
        //<< . SET BIT=YLFN  ;FELDNUMMER
        mVar BIT = m$.var("BIT");
        BIT.set(m$.var("YLFN").get());
        //<< . SET BITX=1    ;DATEN Bit
        mVar BITX = m$.var("BITX");
        BITX.set(1);
        //<< . SET OK=$$^WWWBIT(YDATEI,ID,BIT,BITX,SET,WWWYM)
        mVar OK = m$.var("OK");
        OK.set(m$.fnc$("WWWBIT.main",m$.var("YDATEI").get(),m$.var("ID").get(),BIT.get(),BITX.get(),m$.var("SET").get(),m$.var("WWWYM").get()));
      }
    }
    //<< 
    //<< ;SUMMENBILDUNG
    //<< ;IF $PIECE(YLFN1,Y,3)=1 IF $PIECE(YFELD,Y,YLFN)'="" DO  QUIT  ;SUMMENBILDUNG
    //<< IF $PIECE(YLFN1,Y,3)=1 DO
    if (mOp.Equal(m$.Fnc.$piece(m$.var("YLFN1").get(),m$.var("Y").get(),3),1)) {
      do {
        //<< . SET BIT=YLFN  ;FELDNUMMER
        mVar BIT = m$.var("BIT");
        BIT.set(m$.var("YLFN").get());
        //<< . IF +$PIECE(YFELD,Y,YLFN)=0 DO  QUIT  ;SUMME L÷SCHEN;FIS;25940;24.06.04
        if (mOp.Equal(mOp.Positive(m$.Fnc.$piece(m$.var("YFELD").get(),m$.var("Y").get(),m$.var("YLFN").get())),0)) {
          //<< . . FOR BITX=1:1:40 SET OK=$$^WWWBIT(YDATEI,ID,YLFN,BITX,0,WWWYM)
          mVar BITX = m$.var("BITX");
          for (BITX.set(1);(mOp.LessOrEqual(BITX.get(),40));BITX.set(mOp.Add(BITX.get(),1))) {
            mVar OK = m$.var("OK");
            OK.set(m$.fnc$("WWWBIT.main",m$.var("YDATEI").get(),m$.var("ID").get(),m$.var("YLFN").get(),BITX.get(),0,m$.var("WWWYM").get()));
          }
          break;
        }
        //<< . ;
        //<< . SET BITM=""
        mVar BITM = m$.var("BITM");
        BITM.set("");
        //<< . SET BITR=$PIECE(YFELD,Y,YLFN)*100  ;BETRAG ;Sum
        mVar BITR = m$.var("BITR");
        BITR.set(mOp.Multiply(m$.Fnc.$piece(m$.var("YFELD").get(),m$.var("Y").get(),m$.var("YLFN").get()),100));
        //<< . FOR BITX=1:1 QUIT:BITR<1  DO
        mVar BITX = m$.var("BITX");
        for (BITX.set(1);(true);BITX.set(mOp.Add(BITX.get(),1))) {
          if (mOp.Less(BITR.get(),1)) {
            break;
          }
          //<< . . SET $EXTRACT(BITM,BITX)=BITR#2
          mVar $EXTRACT = m$.var("$EXTRACT");
          $EXTRACT.var(BITM.get(),BITX.get()).set(mOp.Modulus(BITR.get(),2));
          //<< . . SET BITR=BITR\2
          BITR.set(mOp.IntegerDivide(BITR.get(),2));
          //<< . . IF BITR<1 SET BITR=0
          if (mOp.Less(BITR.get(),1)) {
            BITR.set(0);
          }
        }
        //<< . ;
        //<< . FOR BITX=1:1:$LENGTH(BITM) IF $EXTRACT(BITM,BITX)=1 DO
        for (BITX.set(1);(mOp.LessOrEqual(BITX.get(),m$.Fnc.$length(BITM.get())));BITX.set(mOp.Add(BITX.get(),1))) {
          if (mOp.Equal(m$.Fnc.$extract(BITM.get(),BITX.get()),1)) {
            //<< . . SET OK=$$^WWWBIT(YDATEI,ID,BIT,BITX,SET,WWWYM)
            mVar OK = m$.var("OK");
            OK.set(m$.fnc$("WWWBIT.main",m$.var("YDATEI").get(),m$.var("ID").get(),BIT.get(),BITX.get(),m$.var("SET").get(),m$.var("WWWYM").get()));
          }
        }
        //<< 
        //<< ;GENAUER INHALT ;purport
        //<< ;IF +$PIECE(YLFN1,Y,4)=1 DO    ;BIT = EXACT ;OLD VERSION;SR13264;FIS;26.08.05
        //<< . SET BIT=YLFN  ;FELDNUMMER
        BIT.set(m$.var("YLFN").get());
        //<< . SET BITX=""
        BITX.set("");
        //<< . IF $PIECE($GET(^WWW003(0,YDATEI,YLFN,1)),Y,3)=2 IF $PIECE(YFELD,Y,YLFN)'=1 SET $PIECE(YFELD,Y,YLFN)=0  ;JA/NEIN FELD = 0/1 ;field
        if (mOp.Equal(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW003",0,m$.var("YDATEI").get(),m$.var("YLFN").get(),1)),m$.var("Y").get(),3),2)) {
          if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YFELD").get(),m$.var("Y").get(),m$.var("YLFN").get()),1)) {
            m$.pieceVar(m$.var("YFELD"),m$.var("Y").get(),m$.var("YLFN").get()).set(0);
          }
        }
        //<< . IF YUMLAU=""  SET BITX=$TRANSLATE($EXTRACT($PIECE(YFELD,Y,YLFN),1,50),LC,UC)  ;DATEN Bit
        if (mOp.Equal(m$.var("YUMLAU").get(),"")) {
          BITX.set(m$.Fnc.$translate(m$.Fnc.$extract(m$.Fnc.$piece(m$.var("YFELD").get(),m$.var("Y").get(),m$.var("YLFN").get()),1,50),m$.var("LC").get(),m$.var("UC").get()));
        }
        //<< . IF YUMLAU'="" SET BITX=$$^WWWUMLAU($EXTRACT($PIECE(YFELD,Y,YLFN),1,50),1)  ;DATEN Bit;TYBD;26526;6,10,2004
        if (mOp.NotEqual(m$.var("YUMLAU").get(),"")) {
          BITX.set(m$.fnc$("WWWUMLAU.main",m$.Fnc.$extract(m$.Fnc.$piece(m$.var("YFELD").get(),m$.var("Y").get(),m$.var("YLFN").get()),1,50),1));
        }
        //<< . IF $PIECE(YFELD,Y,YLFN)="" SET OK=$$^WWWBIT(YDATEI,ID,BIT,BITX,0,WWWYM) QUIT  ;L÷SCHEN ;Delete
        if (mOp.Equal(m$.Fnc.$piece(m$.var("YFELD").get(),m$.var("Y").get(),m$.var("YLFN").get()),"")) {
          mVar OK = m$.var("OK");
          OK.set(m$.fnc$("WWWBIT.main",m$.var("YDATEI").get(),m$.var("ID").get(),BIT.get(),BITX.get(),0,m$.var("WWWYM").get()));
          break;
        }
        //<< . QUIT:BITX=""
        if (mOp.Equal(BITX.get(),"")) {
          break;
        }
        //<< . SET OK=$$^WWWBIT(YDATEI,ID,BIT,BITX,SET,WWWYM)
        mVar OK = m$.var("OK");
        OK.set(m$.fnc$("WWWBIT.main",m$.var("YDATEI").get(),m$.var("ID").get(),BIT.get(),BITX.get(),m$.var("SET").get(),m$.var("WWWYM").get()));
      } while (false);
    }
    //<< 
    //<< IF +$PIECE(YLFN1,Y,4)=1 DO    ;BIT = EXACT ;NEW VERSION;SR13264;FIS;26.08.05
    if (mOp.Equal(mOp.Positive(m$.Fnc.$piece(m$.var("YLFN1").get(),m$.var("Y").get(),4)),1)) {
      do {
        //<< . SET BIT=YLFN  ;FELDNUMMER
        mVar BIT = m$.var("BIT");
        BIT.set(m$.var("YLFN").get());
        //<< . SET BITX=""
        mVar BITX = m$.var("BITX");
        BITX.set("");
        //<< . IF $PIECE($GET(^WWW003(0,YDATEI,YLFN,1)),Y,3)=2 IF $PIECE(YFELD,Y,YLFN)'=1 SET $PIECE(YFELD,Y,YLFN)=0  ;YES/NO FIELD = 0/1
        if (mOp.Equal(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW003",0,m$.var("YDATEI").get(),m$.var("YLFN").get(),1)),m$.var("Y").get(),3),2)) {
          if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YFELD").get(),m$.var("Y").get(),m$.var("YLFN").get()),1)) {
            m$.pieceVar(m$.var("YFELD"),m$.var("Y").get(),m$.var("YLFN").get()).set(0);
          }
        }
        //<< . IF $PIECE(YFELD,Y,YLFN)="" SET OK=$$^WWWBIT(YDATEI,ID,BIT,BITX,0,WWWYM) QUIT  ;L÷SCHEN ;Delete
        if (mOp.Equal(m$.Fnc.$piece(m$.var("YFELD").get(),m$.var("Y").get(),m$.var("YLFN").get()),"")) {
          mVar OK = m$.var("OK");
          OK.set(m$.fnc$("WWWBIT.main",m$.var("YDATEI").get(),m$.var("ID").get(),BIT.get(),BITX.get(),0,m$.var("WWWYM").get()));
          break;
        }
        //<< . IF YUMLAU="" SET BITX(2)=$TRANSLATE($EXTRACT($PIECE(YFELD,Y,YLFN),1,50),LC,UC)  ;DATEN Bit
        if (mOp.Equal(m$.var("YUMLAU").get(),"")) {
          BITX.var(2).set(m$.Fnc.$translate(m$.Fnc.$extract(m$.Fnc.$piece(m$.var("YFELD").get(),m$.var("Y").get(),m$.var("YLFN").get()),1,50),m$.var("LC").get(),m$.var("UC").get()));
        }
        //<< . IF YUMLAU'="" SET BITX(2)=$$^WWWUMLAU($EXTRACT($PIECE(YFELD,Y,YLFN),1,50),1)  ;DATEN Bit;TYBD;26526;6,10,2004
        if (mOp.NotEqual(m$.var("YUMLAU").get(),"")) {
          BITX.var(2).set(m$.fnc$("WWWUMLAU.main",m$.Fnc.$extract(m$.Fnc.$piece(m$.var("YFELD").get(),m$.var("Y").get(),m$.var("YLFN").get()),1,50),1));
        }
        //<< . FOR BITX(1)=1:1 QUIT:$PIECE(BITX(2),";",BITX(1),999)=""  DO   ;WENN PARAMETER;TYBD;21,4,2005;
        for (m$.var("BITX",1).set(1);(true);m$.var("BITX",1).set(mOp.Add(m$.var("BITX",1).get(),1))) {
          if (mOp.Equal(m$.Fnc.$piece(BITX.var(2).get(),";",BITX.var(1).get(),999),"")) {
            break;
          }
          do {
            //<< . . SET BITX=$EXTRACT($PIECE(BITX(2),";",BITX(1)),1,50)
            BITX.set(m$.Fnc.$extract(m$.Fnc.$piece(BITX.var(2).get(),";",BITX.var(1).get()),1,50));
            //<< . . ;IF $PIECE($GET(^WWW003(0,YDATEI,YLFN,1)),Y,3)=2 IF BITX'=1 SET BITX=0  ;JA/NEIN FELD = 0/1 ;field
            //<< . . ;IF $PIECE(YFELD,Y,YLFN)="" SET OK=$$^WWWBIT(YDATEI,ID,BIT,BITX,0,WWWYM) QUIT  ;L÷SCHEN ;Delete ;FIS;27.05.05;27744;IN TEMP FILE AUFBAUEN
            //<< . . QUIT:BITX=""
            if (mOp.Equal(BITX.get(),"")) {
              break;
            }
            //<< . . SET OK=$$^WWWBIT(YDATEI,ID,BIT,BITX,SET,WWWYM)  ;FIS;27.05.05;27744;IN TEMP FILE AUFBAUEN
            mVar OK = m$.var("OK");
            OK.set(m$.fnc$("WWWBIT.main",m$.var("YDATEI").get(),m$.var("ID").get(),BIT.get(),BITX.get(),m$.var("SET").get(),m$.var("WWWYM").get()));
          } while (false);
        }
      } while (false);
    }
    //<< 
    //<< QUIT
    return;
  }

}
