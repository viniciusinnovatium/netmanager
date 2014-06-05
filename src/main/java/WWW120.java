//*****************************************************************************
//** TASC - ALPHALINC - MAC WWW120
//** Innovatium Systems - Code Converter - v1.29
//** 2014-06-03 20:55:08
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
//<< #include COMConst
import include.COMConst;

//<< WWW120
public class WWW120 extends mClass {

  public void main() {
    _WWW120();
  }

  public void _WWW120() {
    //<< 
    //<< ;15-Jul-2011    shobby  SR17584:   Class/Form changed (Do Not remove comment)
    //<< ;                                  InnerFrameHeight
    //<< 
    //<< ;-------------------------------------------------------------------------------
    //<< ; Description of Function :
    //<< ;       AUFBAU AUTOMATISCHE MASKEN
    //<< ;   NOTE : The saved form record is updated directly without further reference
    //<< ;          to WWWSPEI.
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
    //<< ; 10-Sep-2008   shobby  BR014980: Call to HelpFile No longer necessary
    //<< ; 08-May-2007   GRF     SRBR014310: Doco; some braces; boolean macros
    //<< ; 13-Nov-2006   Steve S SR14915: Call to HelpFile
    //<< ; 20-Jul-2005   GRF     SR12996: review when Multi-select not saving; ! => ||
    //<< ; 27.05.1998    DT
    //<< ;-------------------------------------------------------------------------------
    //<< new YFORM
    mVar YFORM = m$.var("YFORM");
    m$.newVar(YFORM);
    //<< 
    //<< QUIT:'$DATA(YKEY)
    if (mOp.Not(m$.Fnc.$data(m$.var("YKEY")))) {
      return;
    }
    //<< QUIT:YKEY=""
    if (mOp.Equal(m$.var("YKEY").get(),"")) {
      return;
    }
    //<< 
    //<< do Update(YKEY)
    m$.Cmd.Do("Update",m$.var("YKEY").get());
    //<< quit
    return;
  }

  //<< 
  //<< 
  //<< Update(YKEY)
  public Object Update(Object ... _p) {
    mVar YKEY = m$.newVarRef("YKEY",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< SET YFORM  = YKEY
    mVar YFORM = m$.var("YFORM");
    YFORM.set(YKEY.get());
    //<< SET YFOART = $$$WWW120FormType($GET(^WWW120(0,YFORM,1)))
    mVar YFOART = m$.var("YFOART");
    YFOART.set(include.WWWConst.$$$WWW120FormType(m$,m$.Fnc.$get(m$.var("^WWW120",0,YFORM.get(),1))));
    //<< 
    //<< IF YFOART=3 SET $$$WWW120FormFormatting(^WWW120(0,YFORM,1)) = 1   ;grid form => dann feldlänge automatisch ;automatic
    if (mOp.Equal(YFOART.get(),3)) {
      include.WWWConst.$$$WWW120FormFormattingSet(m$,m$.var("^WWW120",0,YFORM.get(),1),1);
    }
    //<< 
    //<< ;-------------------------------------------------------------------------------
    //<< ;AUTOMATIK FUER NORMALE FORMULARE
    //<< ;-------------------------------------------------------------------------------
    //<< 
    //<< // FIXME: After the build change this to use all macros.
    //<< 
    //<< IF (YFOART=2) || (YFOART=6) || (YFOART=8) {      ; SRBR014310
    if ((mOp.Equal(YFOART.get(),2)) || (mOp.Equal(YFOART.get(),6)) || (mOp.Equal(YFOART.get(),8))) {
      //<< SET $PIECE(^WWW120(0,YFORM,1),Y,123)="" ;NO FAST SAVE ;next
      m$.pieceVar(m$.var("^WWW120",0,YFORM.get(),1),m$.var("Y").get(),123).set("");
      //<< SET $PIECE(^WWW120(0,YFORM,1),Y,124)="" ;NO SUPER FAST SAVE ;way-out next
      m$.pieceVar(m$.var("^WWW120",0,YFORM.get(),1),m$.var("Y").get(),124).set("");
    }
    //<< }
    //<< 
    //<< IF $DATA(^WWW124(0,YFORM))                       SET $PIECE(^WWW120(0,YFORM,1),Y,124) = ""       ;NO SUPER FAST SAVE WHEN BUTTONS ;way-out next
    if (mOp.Logical(m$.Fnc.$data(m$.var("^WWW124",0,YFORM.get())))) {
      m$.pieceVar(m$.var("^WWW120",0,YFORM.get(),1),m$.var("Y").get(),124).set("");
    }
    //<< IF $PIECE($GET(^WWW120(0,YFORM,1)),Y,123)=$$$YES SET $PIECE(^WWW120(0,YFORM,1),Y,82)  = $$$YES   ;FAST SAVE
    if (mOp.Equal(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW120",0,YFORM.get(),1)),m$.var("Y").get(),123),include.COMSYS.$$$YES(m$))) {
      m$.pieceVar(m$.var("^WWW120",0,YFORM.get(),1),m$.var("Y").get(),82).set(include.COMSYS.$$$YES(m$));
    }
    //<< IF $PIECE($GET(^WWW120(0,YFORM,1)),Y,124)=$$$YES SET $PIECE(^WWW120(0,YFORM,1),Y,123) = $$$YES SET $PIECE(^WWW120(0,YFORM,1),Y,82) = $$$YES ;FAST SAVE
    if (mOp.Equal(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW120",0,YFORM.get(),1)),m$.var("Y").get(),124),include.COMSYS.$$$YES(m$))) {
      m$.pieceVar(m$.var("^WWW120",0,YFORM.get(),1),m$.var("Y").get(),123).set(include.COMSYS.$$$YES(m$));
      m$.pieceVar(m$.var("^WWW120",0,YFORM.get(),1),m$.var("Y").get(),82).set(include.COMSYS.$$$YES(m$));
    }
    //<< 
    //<< ;-------------------------------------------------------------------------------
    //<< ; D30 Create form automatically
    //<< ;-------------------------------------------------------------------------------
    //<< IF $PIECE($GET(^WWW120(0,YFORM,1)),Y,30)=$$$YES DO  ;FORMULAR AUTOMATISCH ERSTELLEN
    if (mOp.Equal(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW120",0,YFORM.get(),1)),m$.var("Y").get(),30),include.COMSYS.$$$YES(m$))) {
      do {
        //<< . QUIT:YFOART=2  ;Listen
        if (mOp.Equal(YFOART.get(),2)) {
          break;
        }
        //<< . ;
        //<< . IF YFOART'=6 IF YFOART'=8 SET $PIECE(^WWW120(0,YFORM,1),Y,123) = $$$YES   ;SAVE WWWDATEN
        if (mOp.NotEqual(YFOART.get(),6)) {
          if (mOp.NotEqual(YFOART.get(),8)) {
            m$.pieceVar(m$.var("^WWW120",0,YFORM.get(),1),m$.var("Y").get(),123).set(include.COMSYS.$$$YES(m$));
          }
        }
        //<< . SET $PIECE(^WWW120(0,YFORM,1),Y,82) = $$$YES     ;STÄNDIGE FELDVALIDIERUNG
        m$.pieceVar(m$.var("^WWW120",0,YFORM.get(),1),m$.var("Y").get(),82).set(include.COMSYS.$$$YES(m$));
        //<< . SET $PIECE(^WWW120(0,YFORM,1),Y,29) = $$$YES     ;STÄNDIGE PROTOKOLLIERUNG
        m$.pieceVar(m$.var("^WWW120",0,YFORM.get(),1),m$.var("Y").get(),29).set(include.COMSYS.$$$YES(m$));
        //<< . SET $PIECE(^WWW120(0,YFORM,1),Y,30) = $$$NO      ;AUFBEREITET
        m$.pieceVar(m$.var("^WWW120",0,YFORM.get(),1),m$.var("Y").get(),30).set(include.COMSYS.$$$NO(m$));
        //<< . SET $PIECE(^WWW120(0,YFORM,1),Y,13) = $$$YES     ;GERAHMT =JA
        m$.pieceVar(m$.var("^WWW120",0,YFORM.get(),1),m$.var("Y").get(),13).set(include.COMSYS.$$$YES(m$));
        //<< . SET $PIECE(^WWW120(0,YFORM,1),Y,44) = 2          ;FORMAT
        m$.pieceVar(m$.var("^WWW120",0,YFORM.get(),1),m$.var("Y").get(),44).set(2);
        //<< . SET $PIECE(^WWW120(0,YFORM,1),Y,32) = 200        ;FORMATLÄNGE
        m$.pieceVar(m$.var("^WWW120",0,YFORM.get(),1),m$.var("Y").get(),32).set(200);
        //<< . ;
        //<< . ;IF $PIECE($GET(^WWW120(0,YFORM,1)),Y,2)'=1 IF $PIECE($GET(^WWW120(0,YFORM,1)),Y,2)'=3 QUIT
        //<< . IF $PIECE($GET(^WWW120(0,YFORM,1)),Y,2)'=1 IF $PIECE($GET(^WWW120(0,YFORM,1)),Y,2)'=3 IF $PIECE($GET(^WWW120(0,YFORM,1)),Y,2)'=11 QUIT  ;FIS;EDIT TABLE;25029;04.02.04
        if (mOp.NotEqual(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW120",0,YFORM.get(),1)),m$.var("Y").get(),2),1)) {
          if (mOp.NotEqual(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW120",0,YFORM.get(),1)),m$.var("Y").get(),2),3)) {
            if (mOp.NotEqual(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW120",0,YFORM.get(),1)),m$.var("Y").get(),2),11)) {
              break;
            }
          }
        }
        //<< . ;
        //<< . SET YI(1) = $PIECE($GET(^WWW120(0,YFORM,1)),Y,11)
        mVar YI = m$.var("YI");
        YI.var(1).set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW120",0,YFORM.get(),1)),m$.var("Y").get(),11));
        //<< . IF YI(1)'="" IF $PIECE(^WWW120(0,YFORM,1),Y,1)="" SET $PIECE(^WWW120(0,YFORM,1),Y,1)=$PIECE($GET(^WWW001(0,YI(1),1)),Y,1)  ;NAME AUS KLASSE ÜBERNEHMEN;FIS;03.02.05
        if (mOp.NotEqual(YI.var(1).get(),"")) {
          if (mOp.Equal(m$.Fnc.$piece(m$.var("^WWW120",0,YFORM.get(),1).get(),m$.var("Y").get(),1),"")) {
            m$.pieceVar(m$.var("^WWW120",0,YFORM.get(),1),m$.var("Y").get(),1).set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW001",0,YI.var(1).get(),1)),m$.var("Y").get(),1));
          }
        }
        //<< . IF YI(1)'="" DO
        if (mOp.NotEqual(YI.var(1).get(),"")) {
          //<< . . ;
          //<< . . ; Copy Class Keys to Form Keys
          //<< . . ;
          //<< . . SET YI(2)=""
          YI.var(2).set("");
          //<< . . FOR  SET YI(2)=$ORDER(^WWW002(0,YI(1),YI(2))) QUIT:YI(2)=""  DO
          for (;true;) {
            YI.var(2).set(m$.Fnc.$order(m$.var("^WWW002",0,YI.var(1).get(),YI.var(2).get())));
            if (mOp.Equal(YI.var(2).get(),"")) {
              break;
            }
            //<< . . . IF '$DATA(^WWW121(0,YFORM,YI(2),1)) SET ^WWW121(0,YFORM,YI(2),1)=Y_Y_YI(2)
            if (mOp.Not(m$.Fnc.$data(m$.var("^WWW121",0,YFORM.get(),YI.var(2).get(),1)))) {
              m$.var("^WWW121",0,YFORM.get(),YI.var(2).get(),1).set(mOp.Concat(mOp.Concat(m$.var("Y").get(),m$.var("Y").get()),YI.var(2).get()));
            }
            //<< . . . IF $PIECE($GET(^WWW002(0,YI(1),YI(2),1)),Y,3)'=0 IF '$DATA(^WWW127(0,YFORM,"P",YI(2),SPRACHE,1)) SET ^WWW127(0,YFORM,"P",YI(2),SPRACHE,1)=""
            if (mOp.NotEqual(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW002",0,YI.var(1).get(),YI.var(2).get(),1)),m$.var("Y").get(),3),0)) {
              if (mOp.Not(m$.Fnc.$data(m$.var("^WWW127",0,YFORM.get(),"P",YI.var(2).get(),m$.var("SPRACHE").get(),1)))) {
                m$.var("^WWW127",0,YFORM.get(),"P",YI.var(2).get(),m$.var("SPRACHE").get(),1).set("");
              }
            }
          }
          //<< . . ;
          //<< . . SET YLFP=0,YLFSEI=1
          mVar YLFP = m$.var("YLFP");
          YLFP.set(0);
          mVar YLFSEI = m$.var("YLFSEI");
          YLFSEI.set(1);
          //<< . . ;
          //<< . . ; Copy Class Fields to Form Fields
          //<< . . ;
          //<< . . SET YI(22)=""
          YI.var(22).set("");
          //<< . . SET YI(2)=""
          YI.var(2).set("");
          //<< . . FOR  SET YI(2)=$ORDER(^WWW003(0,YI(1),YI(2))) QUIT:YI(2)=""  DO
          for (;true;) {
            YI.var(2).set(m$.Fnc.$order(m$.var("^WWW003",0,YI.var(1).get(),YI.var(2).get())));
            if (mOp.Equal(YI.var(2).get(),"")) {
              break;
            }
            do {
              //<< . . . QUIT:$PIECE($GET(^WWW003(0,YI(1),YI(2),1)),Y,3)=16  ;EMBEDED NICHT EINBAUEN;TYBD;27338;14,2,2005
              if (mOp.Equal(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW003",0,YI.var(1).get(),YI.var(2).get(),1)),m$.var("Y").get(),3),16)) {
                break;
              }
              //<< . . . SET YI(22)=YI(22)+1
              YI.var(22).set(mOp.Add(YI.var(22).get(),1));
              //<< . . . IF '$DATA(^WWW122(0,YFORM,YI(22),1)) DO
              if (mOp.Not(m$.Fnc.$data(m$.var("^WWW122",0,YFORM.get(),YI.var(22).get(),1)))) {
                do {
                  //<< . . . . ;
                  //<< . . . . ;------ Form Name
                  //<< . . . . SET YI(9)=$PIECE($GET(^WWW003(0,YI(1),YI(2),1)),Y,2)
                  YI.var(9).set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW003",0,YI.var(1).get(),YI.var(2).get(),1)),m$.var("Y").get(),2));
                  //<< . . . . IF $FIND($PIECE($GET(^WWW003(0,YI(1),YI(2),1)),Y,25),".") SET YI(9)=$PIECE($GET(^WWW003(0,YI(1),YI(2),1)),Y,25)  ;EMBEDDED MIT PROP.PROP...
                  if (mOp.Logical(m$.Fnc.$find(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW003",0,YI.var(1).get(),YI.var(2).get(),1)),m$.var("Y").get(),25),"."))) {
                    YI.var(9).set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW003",0,YI.var(1).get(),YI.var(2).get(),1)),m$.var("Y").get(),25));
                  }
                  //<< . . . . ;
                  //<< . . . . ;------ Alternate Input Type
                  //<< . . . . IF $PIECE($GET(^WWW003(0,YI(1),YI(2),1)),Y,26)'="" DO  QUIT  ;NICHT FÜR EMBEDED FELD, ABER TEILE IN FELD AUFBAUEN
                  if (mOp.NotEqual(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW003",0,YI.var(1).get(),YI.var(2).get(),1)),m$.var("Y").get(),26),"")) {
                    //<< . . . . . NEW PROP
                    mVar PROP = m$.var("PROP");
                    m$.newVarBlock(5,PROP);
                    //<< . . . . . SET YI(10) = $PIECE($GET(^WWW003(0,YI(1),YI(2),1)),Y,26)
                    YI.var(10).set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW003",0,YI.var(1).get(),YI.var(2).get(),1)),m$.var("Y").get(),26));
                    //<< . . . . . SET PROP   = $PIECE($GET(^WWW003(0,YI(1),YI(2),1)),Y,25)
                    PROP.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW003",0,YI.var(1).get(),YI.var(2).get(),1)),m$.var("Y").get(),25));
                    //<< . . . . . SET YI(20)=""
                    YI.var(20).set("");
                    //<< . . . . . FOR  SET YI(20)=$ORDER(^WWW003(0,YI(10),YI(20))) QUIT:YI(20)=""  DO
                    for (;true;) {
                      YI.var(20).set(m$.Fnc.$order(m$.var("^WWW003",0,YI.var(10).get(),YI.var(20).get())));
                      if (mOp.Equal(YI.var(20).get(),"")) {
                        break;
                      }
                      //<< . . . . . . SET YI(22)=YI(22)+1
                      YI.var(22).set(mOp.Add(YI.var(22).get(),1));
                      //<< . . . . . . IF '$DATA(^WWW122(0,YFORM,YI(22),1)) DO
                      if (mOp.Not(m$.Fnc.$data(m$.var("^WWW122",0,YFORM.get(),YI.var(22).get(),1)))) {
                        //<< . . . . . . . SET YI(9)=PROP_"."_$PIECE($GET(^WWW003(0,YI(10),YI(20),1)),Y,25)  ;DATENFELD ;data item
                        YI.var(9).set(mOp.Concat(mOp.Concat(PROP.get(),"."),m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW003",0,YI.var(10).get(),YI.var(20).get(),1)),m$.var("Y").get(),25)));
                        //<< . . . . . . . SET YMUSS=$PIECE($GET(^WWW003(0,YI(10),YI(20),1)),Y,18)           ;MUSSFELD
                        mVar YMUSS = m$.var("YMUSS");
                        YMUSS.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW003",0,YI.var(10).get(),YI.var(20).get(),1)),m$.var("Y").get(),18));
                        //<< . . . . . . . SET YLFP=YLFP+1
                        YLFP.set(mOp.Add(YLFP.get(),1));
                        //<< . . . . . . . SET ^WWW122(0,YFORM,YI(22),1)=Y_0_Y_+$GET(YLFP)_Y_1_Y_16_Y_Y_Y_Y_Y_Y_Y_YI(9)_Y_YMUSS
                        m$.var("^WWW122",0,YFORM.get(),YI.var(22).get(),1).set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(m$.var("Y").get(),0),m$.var("Y").get()),mOp.Positive(m$.Fnc.$get(YLFP))),m$.var("Y").get()),1),m$.var("Y").get()),16),m$.var("Y").get()),m$.var("Y").get()),m$.var("Y").get()),m$.var("Y").get()),m$.var("Y").get()),m$.var("Y").get()),m$.var("Y").get()),YI.var(9).get()),m$.var("Y").get()),YMUSS.get()));
                        //<< . . . . . . . SET $PIECE(^WWW122(0,YFORM,YI(22),1),Y,60)=YLFSEI  ;SEITE ;side
                        m$.pieceVar(m$.var("^WWW122",0,YFORM.get(),YI.var(22).get(),1),m$.var("Y").get(),60).set(YLFSEI.get());
                        //<< . . . . . . . IF YI(22)=1 SET $PIECE(^WWW122(0,YFORM,YI(22),1),Y,38)=1
                        if (mOp.Equal(YI.var(22).get(),1)) {
                          m$.pieceVar(m$.var("^WWW122",0,YFORM.get(),YI.var(22).get(),1),m$.var("Y").get(),38).set(1);
                        }
                        //<< . . . . . . . DO ^WWWSSORT("^WWW122(0,"_""""_YFORM_""""_","_YI(22)_",1)")
                        m$.Cmd.Do("WWWSSORT.main",mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("^WWW122(0,","\""),YFORM.get()),"\""),","),YI.var(22).get()),",1)"));
                      }
                    }
                    break;
                  }
                  m$.restoreVarBlock(5);
                  //<< . . . . ;
                  //<< . . . . ;----- Mandatory Field
                  //<< . . . . SET YMUSS=$PIECE($GET(^WWW003(0,YI(1),YI(2),1)),Y,18)      ;MUSSFELD
                  mVar YMUSS = m$.var("YMUSS");
                  YMUSS.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW003",0,YI.var(1).get(),YI.var(2).get(),1)),m$.var("Y").get(),18));
                  //<< . . . . ;
                  //<< . . . . ;----- On automatic build - start new tab after each 40 fields
                  //<< . . . . ;SET YLFP=YLFP+1 IF YLFP>2000 SET YLFP=1,YLFSEI=YLFSEI+1   ;KEIN SEITENWECHSEL
                  //<< . . . . SET YLFP=YLFP+1
                  YLFP.set(mOp.Add(YLFP.get(),1));
                  //<< . . . . IF YLFP>40 SET YLFP=1,YLFSEI=YLFSEI+1                      ;NACH 20 SEITE+1
                  if (mOp.Greater(YLFP.get(),40)) {
                    YLFP.set(1);
                    YLFSEI.set(mOp.Add(YLFSEI.get(),1));
                  }
                  //<< . . . . ;
                  //<< . . . . ;----- Build and save record
                  //<< . . . . ; ClassFld# : AutomaticDataType : Row# : Col1 ... : Caption : blnMandatory
                  //<< . . . . SET ^WWW122(0,YFORM,YI(22),1)=YI(2)_Y_0_Y_+$GET(YLFP)_Y_1_Y_Y_Y_Y_Y_Y_Y_Y_YI(9)_Y_YMUSS
                  m$.var("^WWW122",0,YFORM.get(),YI.var(22).get(),1).set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(YI.var(2).get(),m$.var("Y").get()),0),m$.var("Y").get()),mOp.Positive(m$.Fnc.$get(YLFP))),m$.var("Y").get()),1),m$.var("Y").get()),m$.var("Y").get()),m$.var("Y").get()),m$.var("Y").get()),m$.var("Y").get()),m$.var("Y").get()),m$.var("Y").get()),m$.var("Y").get()),YI.var(9).get()),m$.var("Y").get()),YMUSS.get()));
                  //<< . . . . SET $PIECE(^WWW122(0,YFORM,YI(22),1),Y,60)=YLFSEI                   ; tab        ;SEITE
                  m$.pieceVar(m$.var("^WWW122",0,YFORM.get(),YI.var(22).get(),1),m$.var("Y").get(),60).set(YLFSEI.get());
                  //<< . . . . IF YI(22)=1 set $PIECE(^WWW122(0,YFORM,YI(22),1),Y,38)=1            ; new group
                  if (mOp.Equal(YI.var(22).get(),1)) {
                    m$.pieceVar(m$.var("^WWW122",0,YFORM.get(),YI.var(22).get(),1),m$.var("Y").get(),38).set(1);
                  }
                  //<< . . . . DO ^WWWSSORT("^WWW122(0,"_""""_YFORM_""""_","_YI(22)_",1)")
                  m$.Cmd.Do("WWWSSORT.main",mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("^WWW122(0,","\""),YFORM.get()),"\""),","),YI.var(22).get()),",1)"));
                } while (false);
              }
              //<< . . . ;
              //<< . . . IF '$DATA(^WWW127(0,YFORM,"D",YI(2),SPRACHE,1)) SET ^WWW127(0,YFORM,"D",YI(2),SPRACHE,1)=""
              if (mOp.Not(m$.Fnc.$data(m$.var("^WWW127",0,YFORM.get(),"D",YI.var(2).get(),m$.var("SPRACHE").get(),1)))) {
                m$.var("^WWW127",0,YFORM.get(),"D",YI.var(2).get(),m$.var("SPRACHE").get(),1).set("");
              }
            } while (false);
          }
        }
      } while (false);
    }
    //<< 
    //<< ;-------------------------------------------------------------------------------
    //<< ;AUTOMATIK FUER LISTEN      D44     $$$WWW120FormFormatting
    //<< ;-------------------------------------------------------------------------------
    //<< IF $PIECE($GET(^WWW120(0,YFORM,1)),Y,2)=2 {      ; SRBR014310
    if (mOp.Equal(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW120",0,YFORM.get(),1)),m$.var("Y").get(),2),2)) {
      //<< IF $PIECE(^WWW120(0,YFORM,1),Y,44)="" SET $PIECE(^WWW120(0,YFORM,1),Y,44)=1
      if (mOp.Equal(m$.Fnc.$piece(m$.var("^WWW120",0,YFORM.get(),1).get(),m$.var("Y").get(),44),"")) {
        m$.pieceVar(m$.var("^WWW120",0,YFORM.get(),1),m$.var("Y").get(),44).set(1);
      }
    }
    //<< }
    //<< 
    //<< ;-------------------------------------------------------------------------------
    //<< ; D30       $$$WWW120CreateFormAutomatically (Reset for once-only execution)
    //<< ;-------------------------------------------------------------------------------
    //<< IF $PIECE($GET(^WWW120(0,YFORM,1)),Y,30)=$$$YES DO
    if (mOp.Equal(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW120",0,YFORM.get(),1)),m$.var("Y").get(),30),include.COMSYS.$$$YES(m$))) {
      //<< . SET $PIECE(^WWW120(0,YFORM,1),Y,30) = $$$NO
      m$.pieceVar(m$.var("^WWW120",0,YFORM.get(),1),m$.var("Y").get(),30).set(include.COMSYS.$$$NO(m$));
      //<< . KILL ^WWW131(0,YFORM),^WWW132(0,YFORM),^WWW133(0,YFORM)
      m$.var("^WWW131",0,YFORM.get()).kill();
      m$.var("^WWW132",0,YFORM.get()).kill();
      m$.var("^WWW133",0,YFORM.get()).kill();
      //<< . IF '$DATA(^WWW131(0,YFORM)) SET ^WWW131(0,YFORM,1,1)=$PIECE(^WWW120(0,YFORM,1),Y,11)_Y_Y_Y_Y_1_Y_Y_Y_1_Y_Y_Y_Y_Y_Y_Y_"-"_Y_1
      if (mOp.Not(m$.Fnc.$data(m$.var("^WWW131",0,YFORM.get())))) {
        m$.var("^WWW131",0,YFORM.get(),1,1).set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(m$.Fnc.$piece(m$.var("^WWW120",0,YFORM.get(),1).get(),m$.var("Y").get(),11),m$.var("Y").get()),m$.var("Y").get()),m$.var("Y").get()),m$.var("Y").get()),1),m$.var("Y").get()),m$.var("Y").get()),m$.var("Y").get()),1),m$.var("Y").get()),m$.var("Y").get()),m$.var("Y").get()),m$.var("Y").get()),m$.var("Y").get()),m$.var("Y").get()),m$.var("Y").get()),"-"),m$.var("Y").get()),1));
      }
      //<< . SET YI(3)=""
      mVar YI = m$.var("YI");
      YI.var(3).set("");
      //<< . FOR  SET YI(3)=$ORDER(^WWW131(0,YFORM,YI(3))) QUIT:YI(3)=""  DO
      for (;true;) {
        YI.var(3).set(m$.Fnc.$order(m$.var("^WWW131",0,YFORM.get(),YI.var(3).get())));
        if (mOp.Equal(YI.var(3).get(),"")) {
          break;
        }
        //<< . . SET YI(1)=$PIECE($GET(^WWW131(0,YFORM,YI(3),1)),Y,1)
        YI.var(1).set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW131",0,YFORM.get(),YI.var(3).get(),1)),m$.var("Y").get(),1));
        //<< . . IF YI(1)'="" DO
        if (mOp.NotEqual(YI.var(1).get(),"")) {
          //<< . . . SET YI(2)=""
          YI.var(2).set("");
          //<< . . . FOR  SET YI(2)=$ORDER(^WWW002(0,YI(1),YI(2))) QUIT:YI(2)=""  DO
          for (;true;) {
            YI.var(2).set(m$.Fnc.$order(m$.var("^WWW002",0,YI.var(1).get(),YI.var(2).get())));
            if (mOp.Equal(YI.var(2).get(),"")) {
              break;
            }
            //<< . . . . IF '$DATA(^WWW132(0,YFORM,YI(3),YI(2),1)) SET ^WWW132(0,YFORM,YI(3),YI(2),1)=YI(2)_Y_Y_1_Y_1_Y_Y_Y_1_Y
            if (mOp.Not(m$.Fnc.$data(m$.var("^WWW132",0,YFORM.get(),YI.var(3).get(),YI.var(2).get(),1)))) {
              m$.var("^WWW132",0,YFORM.get(),YI.var(3).get(),YI.var(2).get(),1).set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(YI.var(2).get(),m$.var("Y").get()),m$.var("Y").get()),1),m$.var("Y").get()),1),m$.var("Y").get()),m$.var("Y").get()),m$.var("Y").get()),1),m$.var("Y").get()));
            }
          }
          //<< . . . ;
          //<< . . . SET YI(2)=""
          YI.var(2).set("");
          //<< . . . FOR  SET YI(2)=$ORDER(^WWW003(0,YI(1),YI(2))) QUIT:YI(2)=""  DO
          for (;true;) {
            YI.var(2).set(m$.Fnc.$order(m$.var("^WWW003",0,YI.var(1).get(),YI.var(2).get())));
            if (mOp.Equal(YI.var(2).get(),"")) {
              break;
            }
            //<< . . . . IF '$DATA(^WWW133(0,YFORM,YI(3),YI(2),1)) SET ^WWW133(0,YFORM,YI(3),YI(2),1)=YI(2)_Y_Y_Y_1_Y_Y_Y_1_Y
            if (mOp.Not(m$.Fnc.$data(m$.var("^WWW133",0,YFORM.get(),YI.var(3).get(),YI.var(2).get(),1)))) {
              m$.var("^WWW133",0,YFORM.get(),YI.var(3).get(),YI.var(2).get(),1).set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(YI.var(2).get(),m$.var("Y").get()),m$.var("Y").get()),m$.var("Y").get()),1),m$.var("Y").get()),m$.var("Y").get()),m$.var("Y").get()),1),m$.var("Y").get()));
            }
          }
        }
      }
    }
    //<< 
    //<< ;-------------------------------------------------------------------------------
    //<< ;VORGABEN AUS MANDANTENVORGABE ;default from company defaults
    //<< ;-------------------------------------------------------------------------------
    //<< IF +$$$WWW120InheritCompanyProperties($get(^WWW120(0,YFORM,1)))=$$$NO DO
    if (mOp.Equal(mOp.Positive(include.WWWConst.$$$WWW120InheritCompanyProperties(m$,m$.Fnc.$get(m$.var("^WWW120",0,YFORM.get(),1)))),include.COMSYS.$$$NO(m$))) {
      do {
        //<< . NEW YVOR1,YQ,YI,YVOR
        mVar YVOR1 = m$.var("YVOR1");
        mVar YQ = m$.var("YQ");
        mVar YI = m$.var("YI");
        mVar YVOR = m$.var("YVOR");
        m$.newVarBlock(1,YVOR1,YQ,YI,YVOR);
        //<< . SET YQ=0
        YQ.set(0);
        //<< . FOR YI=3:1:9 IF $PIECE($GET(^WWW120(0,YFORM,1)),Y,YI)'="" SET YQ=1 QUIT
        for (YI.set(3);(mOp.LessOrEqual(YI.get(),9));YI.set(mOp.Add(YI.get(),1))) {
          if (mOp.NotEqual(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW120",0,YFORM.get(),1)),m$.var("Y").get(),YI.get()),"")) {
            YQ.set(1);
            break;
          }
        }
        //<< . QUIT:YQ=1
        if (mOp.Equal(YQ.get(),1)) {
          break;
        }
        //<< . SET $PIECE(^WWW120(0,YFORM,1),Y,31)=1
        m$.pieceVar(m$.var("^WWW120",0,YFORM.get(),1),m$.var("Y").get(),31).set(1);
        //<< . IF $PIECE($GET(^WWW120(0,YFORM,1)),Y,2)=3 SET $PIECE(^WWW120(0,YFORM,1),Y,36)=1   ;WENN GRID, DANN LEFT
        if (mOp.Equal(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWW120",0,YFORM.get(),1)),m$.var("Y").get(),2),3)) {
          m$.pieceVar(m$.var("^WWW120",0,YFORM.get(),1),m$.var("Y").get(),36).set(1);
        }
        //<< . ;
        //<< . DO ^WWWFORMX                 ; sets YVOR and YVOR1 from WWW120 and WWW012 respectively + YFIXHEADER, YI
        m$.Cmd.Do("WWWFORMX.main");
        //<< . ;
        //<< . SET $PIECE(YVOR,Y,31)=0
        m$.pieceVar(YVOR,m$.var("Y").get(),31).set(0);
        //<< . SET ^WWW120(0,YFORM,1)=YVOR
        m$.var("^WWW120",0,YFORM.get(),1).set(YVOR.get());
      } while (false);
    }
    m$.restoreVarBlock(1);
    //<< 
    //<< QUIT
    return null;
  }

  //<< 
  //<< 
  //<< OnAfterDataFields(pidForm,&pobjForm)
  public Object OnAfterDataFields(Object ... _p) {
    mVar pidForm = m$.newVarRef("pidForm",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pobjForm = m$.newVarRef("pobjForm",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Load Edit Grid
    //<< ;
    //<< ; Params:
    //<< ; pidForm - Form Id
    //<< ; pobjForm - Form Record
    //<< ;
    //<< ; ByRefs: This is not really needed as we use & for ByRef parameters now.
    //<< ;
    //<< ; Returns: Nothing
    //<< ;
    //<< ; History:
    //<< ; 05-Aug-2008   GRF     SR15826: Added call to ShowCustom on Tab 1
    //<< ; 18-Dec-2006   PO      SR15351: Created
    //<< ;-------------------------------------------------------------------------------
    //<< ;if YSEITE = 5 {         ; SR15826 vvv
    //<< if YSEITE=1 {
    if (mOp.Equal(m$.var("YSEITE").get(),1)) {
      //<< do ShowCustom(YKEY)
      m$.Cmd.Do("ShowCustom",m$.var("YKEY").get());
    }
    //<< } elseif YSEITE = 5 {    ; SR15826 ^^^
    else if (mOp.Equal(m$.var("YSEITE").get(),5)) {
      //<< do LoadGrid(pidForm,pobjForm)
      m$.Cmd.Do("LoadGrid",pidForm.get(),pobjForm.get());
    }
    //<< //  do SwitchBetweenClassAndForm(.pobjForm)
    //<< }
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< ShowCustom(pidForm)
  public Object ShowCustom(Object ... _p) {
    mVar pidForm = m$.newVarRef("pidForm",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Displays customisation of form
    //<< ;
    //<< ; Params: pidForm
    //<< ;
    //<< ; Returns: Nothing
    //<< ;
    //<< ; History:
    //<< ; 05-Aug-2008   GRF     SR15826: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new dteChanged,dteCreated,idCoy,idKey,objCustom,strFormName
    mVar dteChanged = m$.var("dteChanged");
    mVar dteCreated = m$.var("dteCreated");
    mVar idCoy = m$.var("idCoy");
    mVar idKey = m$.var("idKey");
    mVar objCustom = m$.var("objCustom");
    mVar strFormName = m$.var("strFormName");
    m$.newVar(dteChanged,dteCreated,idCoy,idKey,objCustom,strFormName);
    //<< 
    //<< if (pidForm'="") && $data(^WWW120D(0,pidForm)) {
    if ((mOp.NotEqual(pidForm.get(),"")) && mOp.Logical(m$.Fnc.$data(m$.var("^WWW120D",0,pidForm.get())))) {
      //<< do Start^COMTable($listbuild($$$StrWWW120DCompany,
      //<< $$$StrWWW120DCreatedBy,
      //<< $$$StrWWW120DCreatedOn,
      //<< $$$StrWWW120DModifiedBy,
      //<< $$$StrWWW120DModifiedOn),
      //<< $$^WWWFORMNAME("WWW120D")_":",$$$NO,$$$YES,$$$NO)
      m$.Cmd.Do("COMTable.Start",m$.Fnc.$listbuild(include.WWWConst.$$$StrWWW120DCompany(m$),include.WWWConst.$$$StrWWW120DCreatedBy(m$),include.WWWConst.$$$StrWWW120DCreatedOn(m$),include.WWWConst.$$$StrWWW120DModifiedBy(m$),include.WWWConst.$$$StrWWW120DModifiedOn(m$)),mOp.Concat(m$.fnc$("WWWFORMNAME.main","WWW120D"),":"),include.COMSYS.$$$NO(m$),include.COMSYS.$$$YES(m$),include.COMSYS.$$$NO(m$));
      //<< set idCoy = ""
      idCoy.set("");
      //<< for {
      for (;true;) {
        //<< set idCoy = $order(^WWW120D(0,pidForm,idCoy))
        idCoy.set(m$.Fnc.$order(m$.var("^WWW120D",0,pidForm.get(),idCoy.get())));
        //<< quit:idCoy=""
        if (mOp.Equal(idCoy.get(),"")) {
          break;
        }
        //<< 
        //<< set objCustom = $get(^WWW120D(0,pidForm,idCoy,1))
        objCustom.set(m$.Fnc.$get(m$.var("^WWW120D",0,pidForm.get(),idCoy.get(),1)));
        //<< set idKey = pidForm_","_idCoy
        idKey.set(mOp.Concat(mOp.Concat(pidForm.get(),","),idCoy.get()));
        //<< 
        //<< if $$$WWW120DCreatedOn(objCustom) {
        if (mOp.Logical(include.WWWConst.$$$WWW120DCreatedOn(m$,objCustom))) {
          //<< set dteCreated = $$^WWWDATE(+$$$WWW120DCreatedOn(objCustom))
          dteCreated.set(m$.fnc$("WWWDATE.main",mOp.Positive(include.WWWConst.$$$WWW120DCreatedOn(m$,objCustom))));
        }
        //<< } else {
        else {
          //<< set dteCreated = "&nbsp;"
          dteCreated.set("&nbsp;");
        }
        //<< }
        //<< if $$$WWW120DModifiedOn(objCustom) {
        if (mOp.Logical(include.WWWConst.$$$WWW120DModifiedOn(m$,objCustom))) {
          //<< set dteChanged = $$^WWWDATE(+$$$WWW120DModifiedOn(objCustom))
          dteChanged.set(m$.fnc$("WWWDATE.main",mOp.Positive(include.WWWConst.$$$WWW120DModifiedOn(m$,objCustom))));
        }
        //<< } else {
        else {
          //<< set dteChanged = "&nbsp;"
          dteChanged.set("&nbsp;");
        }
        //<< }
        //<< 
        //<< do NewLine^COMTable()
        m$.Cmd.Do("COMTable.NewLine");
        //<< do InsertCell^COMTable(idCoy,"WWW120D",idKey)
        m$.Cmd.Do("COMTable.InsertCell",idCoy.get(),"WWW120D",idKey.get());
        //<< do InsertCell^COMTable($$$WWW120DCreatedBy(objCustom),"WWW120D",idKey)
        m$.Cmd.Do("COMTable.InsertCell",include.WWWConst.$$$WWW120DCreatedBy(m$,objCustom),"WWW120D",idKey.get());
        //<< do InsertCell^COMTable(dteCreated,"WWW120D",idKey)
        m$.Cmd.Do("COMTable.InsertCell",dteCreated.get(),"WWW120D",idKey.get());
        //<< do InsertCell^COMTable($$$WWW120DModifiedBy(objCustom),"WWW120D",idKey)
        m$.Cmd.Do("COMTable.InsertCell",include.WWWConst.$$$WWW120DModifiedBy(m$,objCustom),"WWW120D",idKey.get());
        //<< do InsertCell^COMTable(dteChanged,"WWW120D",idKey)
        m$.Cmd.Do("COMTable.InsertCell",dteChanged.get(),"WWW120D",idKey.get());
        //<< do EndLine^COMTable()
        m$.Cmd.Do("COMTable.EndLine");
      }
      //<< }
      //<< do Stop^COMTable()
      m$.Cmd.Do("COMTable.Stop");
    }
    //<< }
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< LoadGrid(pidForm,pobjForm)
  public Object LoadGrid(Object ... _p) {
    mVar pidForm = m$.newVarRef("pidForm",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pobjForm = m$.newVarRef("pobjForm",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Load the Edit Grid
    //<< ;
    //<< ; Params:
    //<< ;   pidForm - Form Id
    //<< ;   pobjForm - Form Record
    //<< ;
    //<< ; ByRefs:
    //<< ;   YVOR        objForm        ^WWW120
    //<< ;
    //<< ; Returns: Nothing
    //<< ;
    //<< ; History:
    //<< ; 05-Dec-2008   GRF     Clarify Enabled test
    //<< ; 18-Dec-2006   PO      SR15351: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new YAUSWAHL,YFELD,YFORM,YKEY
    mVar YAUSWAHL = m$.var("YAUSWAHL");
    mVar YFELD = m$.var("YFELD");
    mVar YFORM = m$.var("YFORM");
    mVar YKEY = m$.var("YKEY");
    m$.newVar(YAUSWAHL,YFELD,YFORM,YKEY);
    //<< 
    //<< set YFORM = "WWW120DynTable"
    YFORM.set("WWW120DynTable");
    //<< set YFELD = ""
    YFELD.set("");
    //<< set YKEY = $get(pidForm)
    YKEY.set(m$.Fnc.$get(pidForm));
    //<< 
    //<< set $$$COMGridEditParameterSharedForm(YAUSWAHL)    = $$$YES
    include.COMConst.$$$COMGridEditParameterSharedFormSet(m$,YAUSWAHL,include.COMSYS.$$$YES(m$));
    //<< set $$$COMGridEditParameterMaximumHeight(YAUSWAHL) = 300
    include.COMConst.$$$COMGridEditParameterMaximumHeightSet(m$,YAUSWAHL,300);
    //<< set $$$COMGridEditParameterGridName(YAUSWAHL)      = YFORM
    include.COMConst.$$$COMGridEditParameterGridNameSet(m$,YAUSWAHL,YFORM.get());
    //<< set $$$COMGridEditParameterEnabled(YAUSWAHL)       = ($$$WWW120AuthorizationToModifyData(YVOR)'=$$$EnumReadOnly)
    include.COMConst.$$$COMGridEditParameterEnabledSet(m$,YAUSWAHL,(mOp.NotEqual(include.WWWConst.$$$WWW120AuthorizationToModifyData(m$,m$.var("YVOR")),include.COMSYSEnum.$$$EnumReadOnly(m$))));
    //<< set $$$COMGridEditParameterContainer(YAUSWAHL)     = "WWW120"
    include.COMConst.$$$COMGridEditParameterContainerSet(m$,YAUSWAHL,"WWW120");
    //<< 
    //<< do ^COMGridEdit31
    m$.Cmd.Do("COMGridEdit31.main");
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< OnBeforeSave(pidForm,pobjForm)
  public Object OnBeforeSave(Object ... _p) {
    mVar pidForm = m$.newVarRef("pidForm",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pobjForm = m$.newVarRef("pobjForm",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Ensure save is allowed and save Edit Grid content.
    //<< ;
    //<< ; Params:
    //<< ; pidForm - Form Id
    //<< ; pobjForm - Form Record
    //<< ;
    //<< ; Returns: Nothing
    //<< ;
    //<< ; History:
    //<< ; 12-Apr-2010   GRF     SR17177: arrDynTable rather than objDynamicTable
    //<< ; 23-Mar-2010   shobby  SR17245: Removed redundant code.
    //<< ; 18-Dec-2006   PO      SR15351: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new arrDynTable,arrPagesUsed,idTable,intPage,strStatus
    mVar arrDynTable = m$.var("arrDynTable");
    mVar arrPagesUsed = m$.var("arrPagesUsed");
    mVar idTable = m$.var("idTable");
    mVar intPage = m$.var("intPage");
    mVar strStatus = m$.var("strStatus");
    m$.newVar(arrDynTable,arrPagesUsed,idTable,intPage,strStatus);
    //<< 
    //<< set strStatus = $$$OK
    strStatus.set(include.COMSYS.$$$OK(m$));
    //<< $$$GRIDGetContents(.arrDynTable)
    include.COMGridEdit31Interface.$$$GRIDGetContents(m$,arrDynTable);
    //<< kill arrPagesUsed
    arrPagesUsed.kill();
    //<< ;SR17245 if $get(idTable)'="" {  //due to UNDEF error
    //<< set idTable = ""
    idTable.set("");
    //<< for {
    for (;true;) {
      //<< set idTable = $order(arrDynTable(pidForm,idTable))
      idTable.set(m$.Fnc.$order(arrDynTable.var(pidForm.get(),idTable.get())));
      //<< quit:idTable=""
      if (mOp.Equal(idTable.get(),"")) {
        break;
      }
      //<< 
      //<< set intPage = $$$WWW120DynTablePages1(arrDynTable(pidForm,idTable))
      intPage.set(include.WWWConst.$$$WWW120DynTablePages1(m$,arrDynTable.var(pidForm.get(),idTable.get())));
      //<< if intPage '= "" {
      if (mOp.NotEqual(intPage.get(),"")) {
        //<< if $data(arrPagesUsed(intPage)) {
        if (mOp.Logical(m$.Fnc.$data(arrPagesUsed.var(intPage.get())))) {
          //<< set strStatus = "WWW00059"  ; "Currently there can only be one Dynamic Table per page of a form."
          strStatus.set("WWW00059");
          //<< quit
          break;
        }
        //<< } else {
        else {
          //<< set arrPagesUsed(intPage) = ""
          arrPagesUsed.var(intPage.get()).set("");
        }
      }
    }
    //<< }
    //<< }
    //<< }
    //<< ;SR17245 }
    //<< 
    //<< ;SR17245;if ($$$WWW120DynamicTableBasis(pobjForm) = $$$EnumWWWBASEDONClass) || ($$$WWW120DynamicTableBasis(pobjForm) = $$$EnumWWWBASEDONForm) {
    //<< ;SR17245;   if $$$WWW120DynTableClassOrForm(pobjForm) = "" {
    //<< ;SR17245;       set strStatus = "Class / Form field must be filled out."
    //<< ;SR17245;   }
    //<< ;SR17245;}
    //<< 
    //<< ;SR17245 if $$$ISOK(strStatus) set strStatus = $$ValidateLines^WWW120DynTable(pidForm,pobjForm)
    //<< 
    //<< ;SR17245if $$$ISOK(strStatus) {
    //<< ;SR17245    set strStatus = $$$GRIDSave(pidForm)
    //<< ;SR17245}
    //<< 
    //<< if $$$ISERR(strStatus) {
    if (mOp.Logical(include.COMSYS.$$$ISERR(m$,strStatus))) {
      //<< $$$Alert(strStatus)
      include.COMSYS.$$$Alert(m$,strStatus);
      //<< set Q = $$$QDontSave
      mVar Q = m$.var("Q");
      Q.set(include.COMSYSWWW.$$$QDontSave(m$));
    }
    //<< }
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< DoNotDisplay(pidForm)
  public Object DoNotDisplay(Object ... _p) {
    mVar pidForm = m$.newVarRef("pidForm",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Check characters in Form and Customisation to don't display standard buttons
    //<< ;
    //<< ; Params:   pidForm         : The form name
    //<< ;           pstrSeparator   : Separator character
    //<< ; ByRefs:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 13-Dec-2007   shobby  SRBR014601: Call to this routine has been removed from
    //<< ;                           all locations and only put in WWWFORMX.  As such it
    //<< ;                           is no longer necessary to consider that the list may
    //<< ;                           be comma separated, as in WWWFORMF.
    //<< ;                           Removed parameter pstrSeparator.
    //<< ; 11-Dez-2007   GM      SRBR014601: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new objWWW120,objWWW120D,strResult
    mVar objWWW120 = m$.var("objWWW120");
    mVar objWWW120D = m$.var("objWWW120D");
    mVar strResult = m$.var("strResult");
    m$.newVar(objWWW120,objWWW120D,strResult);
    //<< 
    //<< set objWWW120  = $get(^WWW120(0,pidForm,1))
    objWWW120.set(m$.Fnc.$get(m$.var("^WWW120",0,pidForm.get(),1)));
    //<< set objWWW120D = $get(^WWW120D(0,pidForm,YM,1))
    objWWW120D.set(m$.Fnc.$get(m$.var("^WWW120D",0,pidForm.get(),m$.var("YM").get(),1)));
    //<< 
    //<< set strResult = $$$WWW120DoNOTDisplayStandardButto(objWWW120)_";"_$$$WWW120DDoNOTDisplayStandardButto(objWWW120D)
    strResult.set(mOp.Concat(mOp.Concat(include.WWWConst.$$$WWW120DoNOTDisplayStandardButto(m$,objWWW120),";"),include.WWWConst.$$$WWW120DDoNOTDisplayStandardButto(m$,objWWW120D)));
    //<< quit strResult
    return strResult.get();
  }

  //<< 
  //<< 
  //<< ClassUsedInForm(pidForm="")
  public Object ClassUsedInForm(Object ... _p) {
    mVar pidForm = m$.newVarRef("pidForm",(((_p!=null)&&(_p.length>=1))?_p[0]:null),"");
    //<< ;-------------------------------------------------------------------------------
    //<< ; Find the class used by the form
    //<< ;
    //<< ; Params:   pidForm : The form name
    //<< ;
    //<< ; ByRefs:
    //<< ;
    //<< ; Returns:  strClass : The name of the class
    //<< ;
    //<< ; History:
    //<< ; 25-Jan-2008   shobby  SRBR014754: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new objWWW120,strClass
    mVar objWWW120 = m$.var("objWWW120");
    mVar strClass = m$.var("strClass");
    m$.newVar(objWWW120,strClass);
    //<< 
    //<< set strClass = ""
    strClass.set("");
    //<< if pidForm'="" {
    if (mOp.NotEqual(pidForm.get(),"")) {
      //<< set objWWW120 = $get(^WWW120(0,pidForm,1))
      objWWW120.set(m$.Fnc.$get(m$.var("^WWW120",0,pidForm.get(),1)));
      //<< set strClass  = $$$WWW120ClassUsedInForm(objWWW120)
      strClass.set(include.WWWConst.$$$WWW120ClassUsedInForm(m$,objWWW120));
    }
    //<< }
    //<< quit strClass
    return strClass.get();
  }

  //<< 
  //<< 
  //<< AutoResizeRows(pidForm="")
  public Object AutoResizeRows(Object ... _p) {
    mVar pidForm = m$.newVarRef("pidForm",(((_p!=null)&&(_p.length>=1))?_p[0]:null),"");
    //<< ;-------------------------------------------------------------------------------
    //<< ; Determines whether the lines on a grid can Auto Expand based on the contents
    //<< ; of the cell.
    //<< ;
    //<< ; Inputs:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 28-Feb-2008   shobby  SRBR014904: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new blnAutoResizeRows,objWWW120D
    mVar blnAutoResizeRows = m$.var("blnAutoResizeRows");
    mVar objWWW120D = m$.var("objWWW120D");
    m$.newVar(blnAutoResizeRows,objWWW120D);
    //<< 
    //<< set blnAutoResizeRows = $$$NO
    blnAutoResizeRows.set(include.COMSYS.$$$NO(m$));
    //<< if (pidForm'="") {
    if ((mOp.NotEqual(pidForm.get(),""))) {
      //<< set blnAutoResizeRows = +$$$WWW120AutoResizeRows($get(^WWW120(0,pidForm,1)))
      blnAutoResizeRows.set(mOp.Positive(include.WWWConst.$$$WWW120AutoResizeRows(m$,m$.Fnc.$get(m$.var("^WWW120",0,pidForm.get(),1)))));
      //<< set objWWW120D = $get(^WWW120D(0,pidForm,0,1))
      objWWW120D.set(m$.Fnc.$get(m$.var("^WWW120D",0,pidForm.get(),0,1)));
      //<< if $$$WWW120DAutoResizeRows(objWWW120D)'="" {
      if (mOp.NotEqual(include.WWWConst.$$$WWW120DAutoResizeRows(m$,objWWW120D),"")) {
        //<< set blnAutoResizeRows = +$$$WWW120DAutoResizeRows(objWWW120D)
        blnAutoResizeRows.set(mOp.Positive(include.WWWConst.$$$WWW120DAutoResizeRows(m$,objWWW120D)));
      }
    }
    //<< }
    //<< }
    //<< quit blnAutoResizeRows
    return blnAutoResizeRows.get();
  }

  //<< 
  //<< 
  //<< OnBeforeDataAccess(YKEY="",YFORM="")
  public Object OnBeforeDataAccess(Object ... _p) {
    mVar YKEY = m$.newVarRef("YKEY",(((_p!=null)&&(_p.length>=1))?_p[0]:null),"");
    mVar YFORM = m$.newVarRef("YFORM",(((_p!=null)&&(_p.length>=2))?_p[1]:null),"");
    //<< ;-------------------------------------------------------------------------------
    //<< ; Restricts the list of forms to show
    //<< ;
    //<< ; Inputs:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 08-Jul-2008   shobby  SRBR014965: Defaults for parameters.
    //<< ; 03-Jul-2008   shobby  SRBR014965: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new idClass,strStatus
    mVar idClass = m$.var("idClass");
    mVar strStatus = m$.var("strStatus");
    m$.newVar(idClass,strStatus);
    //<< 
    //<< set strStatus = $$$OK
    strStatus.set(include.COMSYS.$$$OK(m$));
    //<< if '$$$NoKey(YKEY) {
    if (mOp.Not(include.COMSYS.$$$NoKey(m$,YKEY))) {
      //<< if $get(YFORM)="WWW128Form" {
      if (mOp.Equal(m$.Fnc.$get(YFORM),"WWW128Form")) {
        //<< set strStatus = ($$$WWW120ClassUsedInForm($get(^WWW120(0,YKEY,1))) = $$$KEY1(YKEYCONTAINER))
        strStatus.set((mOp.Equal(include.WWWConst.$$$WWW120ClassUsedInForm(m$,m$.Fnc.$get(m$.var("^WWW120",0,YKEY.get(),1))),include.COMSYSWWW.$$$KEY1(m$,m$.var("YKEYCONTAINER")))));
        //<< if $$$ISOK(strStatus) set strStatus = $$HasCounter(YKEY)
        if (mOp.Logical(include.COMSYS.$$$ISOK(m$,strStatus))) {
          strStatus.set(m$.fnc$("HasCounter",YKEY.get()));
        }
      }
      //<< } elseif ($get(YFORM)="WWW128") {
      else if ((mOp.Equal(m$.Fnc.$get(YFORM),"WWW128"))) {
        //<< set strStatus = $$$NO
        strStatus.set(include.COMSYS.$$$NO(m$));
      }
    }
    //<< }
    //<< }
    //<< quit strStatus
    return strStatus.get();
  }

  //<< 
  //<< 
  //<< OnFilter()
  public Object OnFilter(Object ... _p) {
    //<< quit $$$OK
    return include.COMSYS.$$$OK(m$);
  }

  //<< 
  //<< 
  //<< HasCounter(pYKEY)
  public Object HasCounter(Object ... _p) {
    mVar pYKEY = m$.newVarRef("pYKEY",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ;
    //<< ;
    //<< ; Inputs:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 26-Feb-2008   shobby  SRBR014965: Extended test to look at the Automatic
    //<< ;                           Sequence Counter field on the form definition.
    //<< ; 09-Jul-2008   shobby  SRBR014965: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new blnCounter,objWWW002,idLast,idClass,objWWW120,objWWW121,idLastKey
    mVar blnCounter = m$.var("blnCounter");
    mVar objWWW002 = m$.var("objWWW002");
    mVar idLast = m$.var("idLast");
    mVar idClass = m$.var("idClass");
    mVar objWWW120 = m$.var("objWWW120");
    mVar objWWW121 = m$.var("objWWW121");
    mVar idLastKey = m$.var("idLastKey");
    m$.newVar(blnCounter,objWWW002,idLast,idClass,objWWW120,objWWW121,idLastKey);
    //<< 
    //<< set blnCounter = $$$NO
    blnCounter.set(include.COMSYS.$$$NO(m$));
    //<< if pYKEY'="" {
    if (mOp.NotEqual(pYKEY.get(),"")) {
      //<< set objWWW120 = $get(^WWW120(0,pYKEY,1))
      objWWW120.set(m$.Fnc.$get(m$.var("^WWW120",0,pYKEY.get(),1)));
      //<< set idLastKey = $order(^WWW121(0,pYKEY,""),-1)
      idLastKey.set(m$.Fnc.$order(m$.var("^WWW121",0,pYKEY.get(),""),mOp.Negative(1)));
      //<< if idLastKey'="" {
      if (mOp.NotEqual(idLastKey.get(),"")) {
        //<< set objWWW121 = $get(^WWW121(0,pYKEY,idLastKey,1))
        objWWW121.set(m$.Fnc.$get(m$.var("^WWW121",0,pYKEY.get(),idLastKey.get(),1)));
        //<< if $$$WWW121AutomaticSequenceCounter(objWWW121) {
        if (mOp.Logical(include.WWWConst.$$$WWW121AutomaticSequenceCounter(m$,objWWW121))) {
          //<< set blnCounter = $$$YES
          blnCounter.set(include.COMSYS.$$$YES(m$));
        }
      }
      //<< }
      //<< }
      //<< if 'blnCounter {
      if (mOp.Not(blnCounter.get())) {
        //<< set idClass = $$$WWW120ClassUsedInForm(objWWW120)
        idClass.set(include.WWWConst.$$$WWW120ClassUsedInForm(m$,objWWW120));
        //<< if idClass'="" {
        if (mOp.NotEqual(idClass.get(),"")) {
          //<< set idLastKey = $order(^WWW002(0,idClass,""),-1)
          idLastKey.set(m$.Fnc.$order(m$.var("^WWW002",0,idClass.get(),""),mOp.Negative(1)));
          //<< if idLastKey'="" {
          if (mOp.NotEqual(idLastKey.get(),"")) {
            //<< set objWWW002 = $get(^WWW002(0,idClass,idLastKey,1))
            objWWW002.set(m$.Fnc.$get(m$.var("^WWW002",0,idClass.get(),idLastKey.get(),1)));
            //<< if $$$WWW002InputType(objWWW002)=9 { ;Counter
            if (mOp.Equal(include.WWWConst.$$$WWW002InputType(m$,objWWW002),9)) {
              //<< set blnCounter = $$$YES
              blnCounter.set(include.COMSYS.$$$YES(m$));
            }
          }
        }
      }
    }
    //<< }
    //<< }
    //<< }
    //<< }
    //<< }
    //<< quit blnCounter
    return blnCounter.get();
  }

  //<< 
  //<< 
  //<< FormHeaderOrImageFile(pYKEY="")
  public Object FormHeaderOrImageFile(Object ... _p) {
    mVar pYKEY = m$.newVarRef("pYKEY",(((_p!=null)&&(_p.length>=1))?_p[0]:null),"");
    //<< ;-------------------------------------------------------------------------------
    //<< ;
    //<< ; Params:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 16-Sep-2008   shobby  SRBR014983: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new objWWW120,objWWW120D,strHeader
    mVar objWWW120 = m$.var("objWWW120");
    mVar objWWW120D = m$.var("objWWW120D");
    mVar strHeader = m$.var("strHeader");
    m$.newVar(objWWW120,objWWW120D,strHeader);
    //<< 
    //<< set strHeader = ""
    strHeader.set("");
    //<< 
    //<< if pYKEY'="" {
    if (mOp.NotEqual(pYKEY.get(),"")) {
      //<< set objWWW120  = $get(^WWW120(0,pYKEY,1))
      objWWW120.set(m$.Fnc.$get(m$.var("^WWW120",0,pYKEY.get(),1)));
      //<< set strHeader  = $$$WWW120FormHeaderOrImageFile(objWWW120)
      strHeader.set(include.WWWConst.$$$WWW120FormHeaderOrImageFile(m$,objWWW120));
      //<< set objWWW120D = $get(^WWW120D(0,pYKEY,YM,1))
      objWWW120D.set(m$.Fnc.$get(m$.var("^WWW120D",0,pYKEY.get(),m$.var("YM").get(),1)));
      //<< if $$$WWW120DFormHeaderOrImageFile(objWWW120D) '="" {
      if (mOp.NotEqual(include.WWWConst.$$$WWW120DFormHeaderOrImageFile(m$,objWWW120D),"")) {
        //<< set strHeader = $$$WWW120DFormHeaderOrImageFile(objWWW120D)
        strHeader.set(include.WWWConst.$$$WWW120DFormHeaderOrImageFile(m$,objWWW120D));
      }
    }
    //<< }
    //<< }
    //<< quit strHeader
    return strHeader.get();
  }

  //<< 
  //<< DoNotDisplayFormHeader(YFORM)
  public Object DoNotDisplayFormHeader(Object ... _p) {
    mVar YFORM = m$.newVarRef("YFORM",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ;
    //<< ; Params:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 24-Apr-2011   shobby  SR17998: Don't put Mega menu of WWWPARA
    //<< ; 23-Apr-2011   shobby  SR17998: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new blnResult
    mVar blnResult = m$.var("blnResult");
    m$.newVar(blnResult);
    //<< 
    //<< set blnResult=$$$NO
    blnResult.set(include.COMSYS.$$$NO(m$));
    //<< 
    //<< if $get(YFORM)'="" {
    if (mOp.NotEqual(m$.Fnc.$get(YFORM),"")) {
      //<< if ($$$WWW013MenuType($get(^WWW013(0,YBED,1)))'=13) {
      if ((mOp.NotEqual(include.WWWConst.$$$WWW013MenuType(m$,m$.Fnc.$get(m$.var("^WWW013",0,m$.var("YBED").get(),1))),13))) {
        //<< set objWWW120 = $get(^WWW120(0,YFORM,1))
        mVar objWWW120 = m$.var("objWWW120");
        objWWW120.set(m$.Fnc.$get(m$.var("^WWW120",0,YFORM.get(),1)));
        //<< if $$$WWW120DoNOTDisplayFormHeader(objWWW120) {
        if (mOp.Logical(include.WWWConst.$$$WWW120DoNOTDisplayFormHeader(m$,objWWW120))) {
          //<< set blnResult=$$$YES
          blnResult.set(include.COMSYS.$$$YES(m$));
        }
        //<< } elseif $$$WWW120InheritCompanyProperties(objWWW120) {
        else if (mOp.Logical(include.WWWConst.$$$WWW120InheritCompanyProperties(m$,objWWW120))) {
          //<< if $$$WWW012DoNotDisplayHeader(YVOR1) set blnResult=$$$YES
          if (mOp.Logical(include.WWWConst.$$$WWW012DoNotDisplayHeader(m$,m$.var("YVOR1")))) {
            blnResult.set(include.COMSYS.$$$YES(m$));
          }
        }
      }
      //<< }
      //<< } else {
      else {
        //<< ; TODO: Need to find a more generic way of doing this with popups only
        //<< if YFORM="WWWPARA" set blnResult=$$$YES
        if (mOp.Equal(YFORM.get(),"WWWPARA")) {
          blnResult.set(include.COMSYS.$$$YES(m$));
        }
        //<< if YFORM="COMViewSearch" set blnResult=$$$YES
        if (mOp.Equal(YFORM.get(),"COMViewSearch")) {
          blnResult.set(include.COMSYS.$$$YES(m$));
        }
      }
    }
    //<< }
    //<< }
    //<< quit blnResult
    return blnResult.get();
  }

  //<< 
  //<< FixedColumns()
  public Object FixedColumns(Object ... _p) {
    //<< ;-------------------------------------------------------------------------------
    //<< ; Determine the default value for the checkbox
    //<< ;
    //<< ; Params:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 13-Sep-2013   shobby  CORE-254: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new strFixedColumns
    mVar strFixedColumns = m$.var("strFixedColumns");
    m$.newVar(strFixedColumns);
    //<< set strFixedColumns=""
    strFixedColumns.set("");
    //<< if YFORM'="" {
    if (mOp.NotEqual(m$.var("YFORM").get(),"")) {
      //<< set strFixedColumns=$$$WWW120FixedColumns($get(^WWW120(0,YFORM,1)))
      strFixedColumns.set(include.WWWConst.$$$WWW120FixedColumns(m$,m$.Fnc.$get(m$.var("^WWW120",0,m$.var("YFORM").get(),1))));
      //<< if strFixedColumns="" set strFixedColumns=$$$WWW012FixedColumns($get(^WWW120(0,YM,1)))
      if (mOp.Equal(strFixedColumns.get(),"")) {
        strFixedColumns.set(include.WWWConst.$$$WWW012FixedColumns(m$,m$.Fnc.$get(m$.var("^WWW120",0,m$.var("YM").get(),1))));
      }
    }
    //<< }
    //<< quit strFixedColumns
    return strFixedColumns.get();
  }

//<< 
//<< 
//<< 
//<< 
}
