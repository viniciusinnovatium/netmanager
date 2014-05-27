//*****************************************************************************
//** TASC - ALPHALINC - MAC WWWTIME
//** Innovatium Systems - Code Converter - v1.27
//** 2014-05-22 00:14:54
//*****************************************************************************

import mLibrary.*;


//<< WWWTIME(YA,pSPRACHE)
public class WWWTIME extends mClass {

  public Object main(Object ... _p) {
    mVar YA = m$.newVarRef("YA",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pSPRACHE = m$.newVarRef("pSPRACHE",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    return _WWWTIME(YA,pSPRACHE);
  }

  public Object _WWWTIME(Object ... _p) {
    mVar YA = m$.newVarRef("YA",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pSPRACHE = m$.newVarRef("pSPRACHE",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Description of Function :
    //<< ;       ZEIT AUS $H
    //<< ;   WENN EIN "." VOR DER ZEIT STEHT, WIRD KEIN am ODER pm NACHGESTELLT
    //<< ;
    //<< ; Inputs :
    //<< ;   YA      Time in seconds
    //<< ;           "." indicates "NOW"
    //<< ;           ".digits" converts to "digits and sets NOAMPM flag (Don't show "am" or "pm" - obsolete)
    //<< ;
    //<< ; ByRef :
    //<< ;
    //<< ;
    //<< ; Returns :
    //<< ;
    //<< ;
    //<< ; History :
    //<< ; 09-Aug-2011   shobby  SR17807: GetFormat has moved.
    //<< ; 23-Aug-2007   GRF     SR13729: Included pSPRACHE in new command; Extracted just
    //<< ;                       the delimiter from TRENN function call; commented out
    //<< ;                       unnecessary DE quit
    //<< ; 20-Aug-2007   GM      SR13729: Change "FELDFORMAT" parameter to $$GetFormat^INPARA()
    //<< ; 30.07.1997    DT
    //<< ;-------------------------------------------------------------------------------
    //<< new (pSPRACHE,SPRACHE,Y,YA)  ;SR13729
    mVar SPRACHE = m$.var("SPRACHE");
    mVar Y = m$.var("Y");
    m$.newVarExcept(pSPRACHE,SPRACHE,Y,YA);
    //<< 
    //<< SET YA=$GET(YA)
    YA.set(m$.Fnc.$get(YA));
    //<< SET NOAMPM=0
    mVar NOAMPM = m$.var("NOAMPM");
    NOAMPM.set(0);
    //<< IF $EXTRACT(YA)="." IF $EXTRACT(YA,2,99)=""  SET YA=$PIECE($HOROLOG,",",2)  ;FIS;16.12.04
    if (mOp.Equal(m$.Fnc.$extract(YA.get()),".")) {
      if (mOp.Equal(m$.Fnc.$extract(YA.get(),2,99),"")) {
        YA.set(m$.Fnc.$piece(m$.Fnc.$horolog(),",",2));
      }
    }
    //<< IF $EXTRACT(YA)="." IF $EXTRACT(YA,2,99)'="" SET YA=$EXTRACT(YA,2,99),NOAMPM=1
    if (mOp.Equal(m$.Fnc.$extract(YA.get()),".")) {
      if (mOp.NotEqual(m$.Fnc.$extract(YA.get(),2,99),"")) {
        YA.set(m$.Fnc.$extract(YA.get(),2,99));
        NOAMPM.set(1);
      }
    }
    //<< IF '$DATA(SPRACHE) SET SPRACHE="DE"
    if (mOp.Not(m$.Fnc.$data(SPRACHE))) {
      SPRACHE.set("DE");
    }
    //<< IF YA>100000000 SET YA=(9999*3600)
    if (mOp.Greater(YA.get(),100000000)) {
      YA.set((mOp.Multiply(9999,3600)));
    }
    //<< IF YA="" QUIT YA
    if (mOp.Equal(YA.get(),"")) {
      return YA.get();
    }
    //<< 
    //<< IF '$DATA(Y) DO ^WWWVORG
    if (mOp.Not(m$.Fnc.$data(Y))) {
      m$.Cmd.Do("WWWVORG.main");
    }
    //<< 
    //<< IF $PIECE(YA,",",2)'="" SET YA=$PIECE(YA,",",2)
    if (mOp.NotEqual(m$.Fnc.$piece(YA.get(),",",2),"")) {
      YA.set(m$.Fnc.$piece(YA.get(),",",2));
    }
    //<< SET YSEC=YA#60
    mVar YSEC = m$.var("YSEC");
    YSEC.set(mOp.Modulus(YA.get(),60));
    //<< SET YA=YA\60    ; now minutes
    YA.set(mOp.IntegerDivide(YA.get(),60));
    //<< 
    //<< if $get(pSPRACHE)'="" set SPRACHE=pSPRACHE
    if (mOp.NotEqual(m$.Fnc.$get(pSPRACHE),"")) {
      SPRACHE.set(pSPRACHE.get());
    }
    //<< 
    //<< ;IF $DATA(^WWW100(0,"FELDFORMAT",SPRACHE,7,1)) SET TRENN=$EXTRACT($PIECE(^WWW100(0,"FELDFORMAT",SPRACHE,7,1),Y,1),3)
    //<< ;SET TRENN=$$GetFormat^INPARA(7,":") ;SR13729
    //<< ;SR17807 SET TRENN=$extract($$GetFormat^INPARA(7,":"),3) ;SR13729 fix
    //<< SET TRENN=$extract($$GetFormat^WWW100(7,":"),3) ;SR13729 fix ;SR17807
    mVar TRENN = m$.var("TRENN");
    TRENN.set(m$.Fnc.$extract(m$.fnc$("WWW100.GetFormat",7,":"),3));
    //<< IF SPRACHE="DE" SET TRENN=":"
    if (mOp.Equal(SPRACHE.get(),"DE")) {
      TRENN.set(":");
    }
    //<< 
    //<< ;IF $GET(SPRACHE)="DE" QUIT $TRANSLATE($JUSTIFY(YA\60,2)_TRENN_$JUSTIFY(YA#60,2)_TRENN_$JUSTIFY(YSEC,2)," ","0") ;SR13729
    //<< QUIT $TRANSLATE($JUSTIFY(YA\60,2)_TRENN_$JUSTIFY(YA#60,2)_TRENN_$JUSTIFY(YSEC,2)," ","0")
    return m$.Fnc.$translate(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(m$.Fnc.$justify(mOp.IntegerDivide(YA.get(),60),2),TRENN.get()),m$.Fnc.$justify(mOp.Modulus(YA.get(),60),2)),TRENN.get()),m$.Fnc.$justify(YSEC.get(),2))," ","0");
  }

//<< 
//<< ;S YUHR=YA\60
//<< ;S strYAM="am"
//<< ;S:YUHR>12 YUHR=YUHR-12,strYAM="pm"
//<< ;I NOAMPM=1 S strYAM=""  ;KEIN AM ODER PM
//<< ;Q $TR($J(YUHR,2)_TRENN_$J(YA#60,2)_TRENN_$J(YSEC,2)," ","0")_" "_strYAM
//<< 
}
