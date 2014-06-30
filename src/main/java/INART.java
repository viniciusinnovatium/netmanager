//*****************************************************************************
//** TASC - ALPHALINC - MAC INART
//** Innovatium Systems - Code Converter - v1.30
//** 2014-06-26 19:22:42
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
//<< #include INConst
import include.INConst;

//<< INART
public class INART extends mClass {

  //<< 
  //<< #define DEMAND  1
  public static Object $$$DEMAND(mContext m$) {
    return (1);
  }

  //<< #define SUPPLY  2
  public static Object $$$SUPPLY(mContext m$) {
    return (2);
  }

  public void main() {
    _INART();
  }

  public void _INART() {
    //<< 
    //<< ;-------------------------------------------------------------------------------
    //<< ; Description of Function :
    //<< ;       PRÜFUNG BEI SPEICHERN ARTIKEL
    //<< ;
    //<< ;   ARTIKEL HISTORY ;item
    //<< ;   D ^INARTHIST(YKEY,$$^WWWTEXT(32508))  ;Datensatzänderung - ZU VIELE EINTRÄGE
    //<< ; Inputs :
    //<< ;   YKEY    idItem
    //<< ;   YFELD   objINART
    //<< ;   BETR    Site Location (YLOCATION)
    //<< ;
    //<< ; Called By:
    //<< ;   OnAfterSaveEvent for INART Form
    //<< ;
    //<< ; ByRef :
    //<< ;
    //<< ;
    //<< ; Returns :
    //<< ;
    //<< ;
    //<< ; History :
    //<< ; 05-Nov-2010   GRF     SR17243: OnAfterSave health check of INARTPACK units
    //<< ; 11-Feb-2009   HQN     SR16347: Added INARTPACK saving defaults
    //<< ; 20-Nov-2008   shobby  SR16169: Allow non-numeric UOMs
    //<< ; 25-Aug-2006   GRF     SR12027: quits; doco; macros & code clarification
    //<< ;                       Use Supplier Product No instead of Product Description
    //<< ; 12-Jul-2005   GRF     SR12027: Identify INARTK Product Description Use
    //<< ; 24-Jun-2005   GRF     Comments; clarify; ! => ||
    //<< ; 30.01.2000    DT
    //<< ;-------------------------------------------------------------------------------
    //<< NEW YKALK,BETR,WG,ME,LIEF,strStatus
    mVar YKALK = m$.var("YKALK");
    mVar BETR = m$.var("BETR");
    mVar WG = m$.var("WG");
    mVar ME = m$.var("ME");
    mVar LIEF = m$.var("LIEF");
    mVar strStatus = m$.var("strStatus");
    m$.newVar(YKALK,BETR,WG,ME,LIEF,strStatus);
    //<< 
    //<< QUIT:$GET(YKEY)=""
    if (mOp.Equal(m$.Fnc.$get(m$.var("YKEY")),"")) {
      return;
    }
    //<< QUIT:$GET(YFELD)=""
    if (mOp.Equal(m$.Fnc.$get(m$.var("YFELD")),"")) {
      return;
    }
    //<< 
    //<< ;UEBERSICHT DRP
    //<< SET ^INDRPUSER(0,YUSER,1) = Y_YKEY
    m$.var("^INDRPUSER",0,m$.var("YUSER").get(),1).set(mOp.Concat(m$.var("Y").get(),m$.var("YKEY").get()));
    //<< 
    //<< ;KALKULATIONSVORGABEN AUS BETRIEBSDATEI SUCHEN ;out of seek
    //<< IF $GET(BETR)="" SET BETR = $GET(YLOCATION)
    if (mOp.Equal(m$.Fnc.$get(BETR),"")) {
      BETR.set(m$.Fnc.$get(m$.var("YLOCATION")));
    }
    //<< IF BETR="" SET BETR = $ORDER(^INKALK(0,""))      ; FIXME : The first location may not be a usable location. <GRF>
    if (mOp.Equal(BETR.get(),"")) {
      BETR.set(m$.Fnc.$order(m$.var("^INKALK",0,"")));
    }
    //<< IF BETR="" SET BETR = 1                          ; FIXME : We may not even HAVE a location "1".             <GRF>
    if (mOp.Equal(BETR.get(),"")) {
      BETR.set(1);
    }
    //<< 
    //<< ; Item Group      ;WARENGRUPPE SUCHEN
    //<< ; Use defaults if not set up and store in item record  ;SETZEN STANDARDWARENGRUPPE IN ARTIKEL
    //<< ;---------------------------------------
    //<< SET WG=$PIECE(YFELD,Y,30)
    WG.set(m$.Fnc.$piece(m$.var("YFELD").get(),m$.var("Y").get(),30));
    //<< IF WG="" {
    if (mOp.Equal(WG.get(),"")) {
      //<< SET WG = $$$INVORGDefaultItemGroup($GET(^INVORG(0,0,1)))
      WG.set(include.INConst.$$$INVORGDefaultItemGroup(m$,m$.Fnc.$get(m$.var("^INVORG",0,0,1))));
      //<< IF (WG="") && (BETR'="") SET WG = $ORDER(^INKALK(0,BETR,""))
      if ((mOp.Equal(WG.get(),"")) && (mOp.NotEqual(BETR.get(),""))) {
        WG.set(m$.Fnc.$order(m$.var("^INKALK",0,BETR.get(),"")));
      }
      //<< SET $PIECE(YFELD,Y,30) = WG
      m$.pieceVar(m$.var("YFELD"),m$.var("Y").get(),30).set(WG.get());
    }
    //<< }
    //<< 
    //<< ;+++++++++++++++++++++++++++++++++++++++
    //<< ;   Calculation Rules
    //<< ;   YKALK       objINKALKART    Item Level - first choice, or
    //<< ;   YKALK       objINKALK       Group Level - based on default group if
    //<< ;+++++++++++++++++++++++++++++++++++++++
    //<< 
    //<< IF WG'="" IF '$DATA(^INKALK(0,BETR,WG)) SET WG = $$$INVORGDefaultItemGroup($GET(^INVORG(0,0,1)))   ;DFLT WARENGRUPPE = 1.
    if (mOp.NotEqual(WG.get(),"")) {
      if (mOp.Not(m$.Fnc.$data(m$.var("^INKALK",0,BETR.get(),WG.get())))) {
        WG.set(include.INConst.$$$INVORGDefaultItemGroup(m$,m$.Fnc.$get(m$.var("^INVORG",0,0,1))));
      }
    }
    //<< 
    //<< SET YKALK=""
    YKALK.set("");
    //<< IF BETR'="" {
    if (mOp.NotEqual(BETR.get(),"")) {
      //<< IF WG'="" SET YKALK = $GET(^INKALK(0,BETR,WG,1))
      if (mOp.NotEqual(WG.get(),"")) {
        YKALK.set(m$.Fnc.$get(m$.var("^INKALK",0,BETR.get(),WG.get(),1)));
      }
      //<< IF (YKEY'="") && $DATA(^INKALKART(0,BETR,YKEY)) {
      if ((mOp.NotEqual(m$.var("YKEY").get(),"")) && mOp.Logical(m$.Fnc.$data(m$.var("^INKALKART",0,BETR.get(),m$.var("YKEY").get())))) {
        //<< SET YKALK = $GET(^INKALKART(0,BETR,YKEY,1))  ;ARTIKELKALKULATIONSVORGABEN
        YKALK.set(m$.Fnc.$get(m$.var("^INKALKART",0,BETR.get(),m$.var("YKEY").get(),1)));
      }
    }
    //<< }
    //<< }
    //<< 
    //<< ; Ensure the Quantity Unit exists   ; PRUEFEN DER MENGENEINHEIT AUF BESTAND
    //<< ;---------------------------------------
    //<< IF $$$INARTOldQuantityUnit(YFELD)'="" {
    if (mOp.NotEqual(include.INConst.$$$INARTOldQuantityUnit(m$,m$.var("YFELD")),"")) {
      //<< IF $DATA(^INWE(0,YKEY)) {
      if (mOp.Logical(m$.Fnc.$data(m$.var("^INWE",0,m$.var("YKEY").get())))) {
        //<< IF $$$INARTOldQuantityUnit(YFELD)'=$$$INARTUnitofMeasure(YFELD) {
        if (mOp.NotEqual(include.INConst.$$$INARTOldQuantityUnit(m$,m$.var("YFELD")),include.INConst.$$$INARTUnitofMeasure(m$,m$.var("YFELD")))) {
          //<< SET $$$INARTUnitofMeasure(YFELD)=$$$INARTOldQuantityUnit(YFELD)      ;NICHT ZULÄSSIGE PRUEFUNG ;Not
          include.INConst.$$$INARTUnitofMeasureSet(m$,m$.var("YFELD"),include.INConst.$$$INARTOldQuantityUnit(m$,m$.var("YFELD")));
        }
      }
    }
    //<< }
    //<< }
    //<< }
    //<< 
    //<< IF +$$$INARTItemType(YFELD)=0      SET $$$INARTItemType(YFELD)     =0  ;ARTIKELART=0 "Make or Buy"
    if (mOp.Equal(mOp.Positive(include.INConst.$$$INARTItemType(m$,m$.var("YFELD"))),0)) {
      include.INConst.$$$INARTItemTypeSet(m$,m$.var("YFELD"),0);
    }
    //<< IF $$$INARTUnitofMeasure(YFELD)="" SET $$$INARTUnitofMeasure(YFELD)=1  ;when no units, set to "EACH"   ;16169
    if (mOp.Equal(include.INConst.$$$INARTUnitofMeasure(m$,m$.var("YFELD")),"")) {
      include.INConst.$$$INARTUnitofMeasureSet(m$,m$.var("YFELD"),1);
    }
    //<< 
    //<< IF $$$INARTItemType(YFELD)=2 {                          ; D26 = "Service"
    if (mOp.Equal(include.INConst.$$$INARTItemType(m$,m$.var("YFELD")),2)) {
      //<< if "~2~10~11~15~16~17~" '[ ("~"_$$$INARTUnitofMeasure(YFELD)_"~") set $$$INARTUnitofMeasure(YFELD)=10  ;DFLT. MINUTEN
      if (mOp.NotContains("~2~10~11~15~16~17~",(mOp.Concat(mOp.Concat("~",include.INConst.$$$INARTUnitofMeasure(m$,m$.var("YFELD"))),"~")))) {
        include.INConst.$$$INARTUnitofMeasureSet(m$,m$.var("YFELD"),10);
      }
    }
    //<< }
    //<< 
    //<< ;+++++++++++++++++++++++++++++++++++++++
    //<< ;      * = Service Units above
    //<< ;---------------------------------------
    //<< ;    1       Each
    //<< ;    2   *   Hours
    //<< ;    3       Litre
    //<< ;    4       Kg
    //<< ;    5       m
    //<< ;    6       m²
    //<< ;    7       *Litre
    //<< ;    9       Package
    //<< ;   10   *   Minutes
    //<< ;   11   *   Industry-Minutes
    //<< ;   12       m³
    //<< ;   13       Pair
    //<< ;   14       Grams
    //<< ;   15   *   Days
    //<< ;   16   *   Weeks
    //<< ;   17   *   Months
    //<< ;   18       mm
    //<< ;   19       km
    //<< ;   20       mm²
    //<< ;   21       mg
    //<< ;   22       /100
    //<< ;+++++++++++++++++++++++++++++++++++++++
    //<< 
    //<< ;-------------------------------------------------------------------------------
    //<< ; Based on Unit of Measure, reset certain parameters...
    //<< ;
    //<< ;   D15         $$$INARTLength1()
    //<< ;   D16         $$$INARTWidth()
    //<< ;   D17         $$$INARTHeight()
    //<< ;   D18         $$$INARTSurface()
    //<< ;   D37         $$$INARTMaterial()
    //<< ;   D43         $$$INARTWeight()
    //<< ;   D44         $$$INARTVolume()
    //<< ;   D45         $$$INARTExecutionTime()
    //<< ;-------------------------------------------------------------------------------
    //<< 
    //<< SET ME = $$$INARTUnitofMeasure(YFELD)   ;MENGENEINHEIT
    ME.set(include.INConst.$$$INARTUnitofMeasure(m$,m$.var("YFELD")));
    //<< SET $$$INARTOldQuantityUnit(YFELD) = ME  ;GGF NEUE MENGENEINHEIT ZUR PRUEFUNG  ; D40 => D196
    include.INConst.$$$INARTOldQuantityUnitSet(m$,m$.var("YFELD"),ME.get());
    //<< 
    //<< IF (ME'=2) && (ME'=10) && (ME'=11) SET $$$INARTExecutionTime(YFELD) = 0
    if ((mOp.NotEqual(ME.get(),2)) && (mOp.NotEqual(ME.get(),10)) && (mOp.NotEqual(ME.get(),11))) {
      include.INConst.$$$INARTExecutionTimeSet(m$,m$.var("YFELD"),0);
    }
    //<< 
    //<< ; derive from BOM?
    //<< SET $$$INARTExecutionTime(YFELD) = $$^INARTDAUER(YKEY)   ;FIXME : This is over-written in next block
    include.INConst.$$$INARTExecutionTimeSet(m$,m$.var("YFELD"),m$.fnc$("INARTDAUER.main",m$.var("YKEY").get()));
    //<< SET $$$INARTWeight(YFELD)        = $$^INGEWICHT(YKEY)
    include.INConst.$$$INARTWeightSet(m$,m$.var("YFELD"),m$.fnc$("INGEWICHT.main",m$.var("YKEY").get()));
    //<< 
    //<< ;*******************************************************************************
    //<< 
    //<< ; ItemType=1 ("Buy" Items) indicates external processing?    ;(AUSSER FREMDLEISTUNGEN)
    //<< 
    //<< ; Hours
    //<< IF ME=2 {
    if (mOp.Equal(ME.get(),2)) {
      //<< IF $$$INARTItemType(YFELD)'=1 SET $$$INARTItemType(YFELD)=2
      if (mOp.NotEqual(include.INConst.$$$INARTItemType(m$,m$.var("YFELD")),1)) {
        include.INConst.$$$INARTItemTypeSet(m$,m$.var("YFELD"),2);
      }
      //<< SET $$$INARTExecutionTime(YFELD) = 3600
      include.INConst.$$$INARTExecutionTimeSet(m$,m$.var("YFELD"),3600);
      //<< SET $$$INARTWeight(YFELD)        = ""
      include.INConst.$$$INARTWeightSet(m$,m$.var("YFELD"),"");
      //<< SET $$$INARTVolume(YFELD)        = ""
      include.INConst.$$$INARTVolumeSet(m$,m$.var("YFELD"),"");
      //<< SET $$$INARTMaterial(YFELD)      = ""
      include.INConst.$$$INARTMaterialSet(m$,m$.var("YFELD"),"");
    }
    //<< }
    //<< 
    //<< ; Minutes                ;MINUTEN
    //<< IF ME=10 {
    if (mOp.Equal(ME.get(),10)) {
      //<< IF $$$INARTItemType(YFELD)'=1 SET $$$INARTItemType(YFELD)=2
      if (mOp.NotEqual(include.INConst.$$$INARTItemType(m$,m$.var("YFELD")),1)) {
        include.INConst.$$$INARTItemTypeSet(m$,m$.var("YFELD"),2);
      }
      //<< SET $$$INARTExecutionTime(YFELD) = 60
      include.INConst.$$$INARTExecutionTimeSet(m$,m$.var("YFELD"),60);
      //<< SET $$$INARTWeight(YFELD)        = ""
      include.INConst.$$$INARTWeightSet(m$,m$.var("YFELD"),"");
      //<< SET $$$INARTVolume(YFELD)        = ""
      include.INConst.$$$INARTVolumeSet(m$,m$.var("YFELD"),"");
      //<< SET $$$INARTMaterial(YFELD)      = ""
      include.INConst.$$$INARTMaterialSet(m$,m$.var("YFELD"),"");
    }
    //<< }
    //<< 
    //<< ; Industry Minutes       ;INDUSTRIIMINUTEN
    //<< IF ME=11 {
    if (mOp.Equal(ME.get(),11)) {
      //<< IF $$$INARTItemType(YFELD)'=1 SET $$$INARTItemType(YFELD)=2
      if (mOp.NotEqual(include.INConst.$$$INARTItemType(m$,m$.var("YFELD")),1)) {
        include.INConst.$$$INARTItemTypeSet(m$,m$.var("YFELD"),2);
      }
      //<< SET $$$INARTExecutionTime(YFELD) = 60                 ; FIXME: Shouldn't this be 100? <GRF>
      include.INConst.$$$INARTExecutionTimeSet(m$,m$.var("YFELD"),60);
      //<< SET $$$INARTWeight(YFELD)        = ""
      include.INConst.$$$INARTWeightSet(m$,m$.var("YFELD"),"");
      //<< SET $$$INARTVolume(YFELD)        = ""
      include.INConst.$$$INARTVolumeSet(m$,m$.var("YFELD"),"");
      //<< SET $$$INARTMaterial(YFELD)      = ""
      include.INConst.$$$INARTMaterialSet(m$,m$.var("YFELD"),"");
    }
    //<< }
    //<< 
    //<< ;*******************************************************************************
    //<< 
    //<< ; Kilograms    ;KG NUR WENN KEIN AUTOMATISCHES GEWICHT
    //<< IF ME=4  SET $$$INARTWeight(YFELD) = 1
    if (mOp.Equal(ME.get(),4)) {
      include.INConst.$$$INARTWeightSet(m$,m$.var("YFELD"),1);
    }
    //<< 
    //<< ; Grams        ;G NUR WENN KEIN AUTOMATISCHES GEWICHT
    //<< IF ME=14 SET $$$INARTWeight(YFELD) = 0.001
    if (mOp.Equal(ME.get(),14)) {
      include.INConst.$$$INARTWeightSet(m$,m$.var("YFELD"),0.001);
    }
    //<< 
    //<< ;*******************************************************************************
    //<< ; No Height - 2D - Calculate Surface Area if no entry
    //<< ; Height    - 3D - Calculate Volume if no entry
    //<< 
    //<< ; millimetres
    //<< if ME=18 {
    if (mOp.Equal(ME.get(),18)) {
      //<< if $$$INARTLength1(YFELD) && $$$INARTWidth(YFELD) {
      if (mOp.Logical(include.INConst.$$$INARTLength1(m$,m$.var("YFELD"))) && mOp.Logical(include.INConst.$$$INARTWidth(m$,m$.var("YFELD")))) {
        //<< if '$$$INARTSurface(YFELD) && '$$$INARTHeight(YFELD) {
        if (mOp.Not(include.INConst.$$$INARTSurface(m$,m$.var("YFELD"))) && mOp.Not(include.INConst.$$$INARTHeight(m$,m$.var("YFELD")))) {
          //<< set $$$INARTSurface(YFELD) = $JUSTIFY(($$$INARTLength1(YFELD)/1000)*($$$INARTWidth(YFELD)/1000),0,4)
          include.INConst.$$$INARTSurfaceSet(m$,m$.var("YFELD"),m$.Fnc.$justify(mOp.Multiply((mOp.Divide(include.INConst.$$$INARTLength1(m$,m$.var("YFELD")),1000)),(mOp.Divide(include.INConst.$$$INARTWidth(m$,m$.var("YFELD")),1000))),0,4));
        }
        //<< }
        //<< if '$$$INARTVolume(YFELD) && $$$INARTHeight(YFELD) {
        if (mOp.Not(include.INConst.$$$INARTVolume(m$,m$.var("YFELD"))) && mOp.Logical(include.INConst.$$$INARTHeight(m$,m$.var("YFELD")))) {
          //<< SET $$$INARTVolume(YFELD) = $JUSTIFY(($$$INARTLength1(YFELD)/1000)*($$$INARTWidth(YFELD)/1000)*($$$INARTHeight(YFELD)/1000),0,4)
          include.INConst.$$$INARTVolumeSet(m$,m$.var("YFELD"),m$.Fnc.$justify(mOp.Multiply(mOp.Multiply((mOp.Divide(include.INConst.$$$INARTLength1(m$,m$.var("YFELD")),1000)),(mOp.Divide(include.INConst.$$$INARTWidth(m$,m$.var("YFELD")),1000))),(mOp.Divide(include.INConst.$$$INARTHeight(m$,m$.var("YFELD")),1000))),0,4));
        }
      }
    }
    //<< }
    //<< }
    //<< }
    //<< 
    //<< ; metres, metres², metres³
    //<< if (ME=5) || (ME=6) || (ME=12) {
    if ((mOp.Equal(ME.get(),5)) || (mOp.Equal(ME.get(),6)) || (mOp.Equal(ME.get(),12))) {
      //<< if $$$INARTLength1(YFELD) && $$$INARTWidth(YFELD) {
      if (mOp.Logical(include.INConst.$$$INARTLength1(m$,m$.var("YFELD"))) && mOp.Logical(include.INConst.$$$INARTWidth(m$,m$.var("YFELD")))) {
        //<< if '$$$INARTSurface(YFELD) && '$$$INARTHeight(YFELD) {
        if (mOp.Not(include.INConst.$$$INARTSurface(m$,m$.var("YFELD"))) && mOp.Not(include.INConst.$$$INARTHeight(m$,m$.var("YFELD")))) {
          //<< set $$$INARTSurface(YFELD) = $JUSTIFY($$$INARTLength1(YFELD)*$$$INARTWidth(YFELD),0,4)
          include.INConst.$$$INARTSurfaceSet(m$,m$.var("YFELD"),m$.Fnc.$justify(mOp.Multiply(include.INConst.$$$INARTLength1(m$,m$.var("YFELD")),include.INConst.$$$INARTWidth(m$,m$.var("YFELD"))),0,4));
        }
        //<< }
        //<< if '$$$INARTVolume(YFELD) && $$$INARTHeight(YFELD) {
        if (mOp.Not(include.INConst.$$$INARTVolume(m$,m$.var("YFELD"))) && mOp.Logical(include.INConst.$$$INARTHeight(m$,m$.var("YFELD")))) {
          //<< SET $$$INARTVolume(YFELD) = $JUSTIFY($$$INARTLength1(YFELD)*$$$INARTWidth(YFELD)*$$$INARTHeight(YFELD),0,4)
          include.INConst.$$$INARTVolumeSet(m$,m$.var("YFELD"),m$.Fnc.$justify(mOp.Multiply(mOp.Multiply(include.INConst.$$$INARTLength1(m$,m$.var("YFELD")),include.INConst.$$$INARTWidth(m$,m$.var("YFELD"))),include.INConst.$$$INARTHeight(m$,m$.var("YFELD"))),0,4));
        }
      }
    }
    //<< }
    //<< }
    //<< }
    //<< 
    //<< ;*******************************************************************************
    //<< 
    //<< SET $PIECE(YFELD,Y,47) = $$^INARTKOST(YKEY,1)  ;SELBSTKOSTEN NEU RECHNEN ;total production costs recent have faith in
    m$.pieceVar(m$.var("YFELD"),m$.var("Y").get(),47).set(m$.fnc$("INARTKOST.main",m$.var("YKEY").get(),1));
    //<< 
    //<< IF $$$INARTItemType(YFELD)'=2 IF $$$INARTItemType(YFELD)'=3 DO
    if (mOp.NotEqual(include.INConst.$$$INARTItemType(m$,m$.var("YFELD")),2)) {
      if (mOp.NotEqual(include.INConst.$$$INARTItemType(m$,m$.var("YFELD")),3)) {
        //<< . IF $PIECE(YFELD,Y,140)="" SET $PIECE(YFELD,Y,140) = $PIECE(YFELD,Y,47)  ;DURCHSCHNITTLICHER EK ;Planned Cost
        if (mOp.Equal(m$.Fnc.$piece(m$.var("YFELD").get(),m$.var("Y").get(),140),"")) {
          m$.pieceVar(m$.var("YFELD"),m$.var("Y").get(),140).set(m$.Fnc.$piece(m$.var("YFELD").get(),m$.var("Y").get(),47));
        }
      }
    }
    //<< 
    //<< SET $PIECE(YFELD,Y,50) = $$^INDAUERTAGE($PIECE(YFELD,Y,45)) ;DAUER IN TAGEN ;permanence within
    m$.pieceVar(m$.var("YFELD"),m$.var("Y").get(),50).set(m$.fnc$("INDAUERTAGE.main",m$.Fnc.$piece(m$.var("YFELD").get(),m$.var("Y").get(),45)));
    //<< 
    //<< 
    //<< ;NEU SETZTEN HERSTELLSTUNDENSÄTZTE ;recent
    //<< SET $PIECE(YFELD,Y,251) = ""  ;MASCHINEN-STUNDENSATZ
    m$.pieceVar(m$.var("YFELD"),m$.var("Y").get(),251).set("");
    //<< SET $PIECE(YFELD,Y,252) = ""  ;BEDIENER-STUNDENSATZ
    m$.pieceVar(m$.var("YFELD"),m$.var("Y").get(),252).set("");
    //<< IF $$$INARTItemType(YFELD)=2 DO  ;NUR LEISTUNGEN ;only LEISTUNGEN
    if (mOp.Equal(include.INConst.$$$INARTItemType(m$,m$.var("YFELD")),2)) {
      do {
        //<< . NEW KALK
        mVar KALK = m$.var("KALK");
        m$.newVarBlock(1,KALK);
        //<< . QUIT:$GET(YKEY)=""
        if (mOp.Equal(m$.Fnc.$get(m$.var("YKEY")),"")) {
          break;
        }
        //<< . SET KALK = $$^INMASCHKOST(1,YKEY)
        KALK.set(m$.fnc$("INMASCHKOST.main",1,m$.var("YKEY").get()));
        //<< . SET $PIECE(YFELD,Y,251) = $PIECE(KALK,Y,1)
        m$.pieceVar(m$.var("YFELD"),m$.var("Y").get(),251).set(m$.Fnc.$piece(KALK.get(),m$.var("Y").get(),1));
        //<< . SET $PIECE(YFELD,Y,252) = $PIECE(KALK,Y,2)
        m$.pieceVar(m$.var("YFELD"),m$.var("Y").get(),252).set(m$.Fnc.$piece(KALK.get(),m$.var("Y").get(),2));
      } while (false);
    }
    m$.restoreVarBlock(1);
    //<< 
    //<< IF $PIECE(YFELD,Y,57)'="" DO       ;MASCHINE ;machine
    if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YFELD").get(),m$.var("Y").get(),57),"")) {
      do {
        //<< . QUIT:$$$INARTItemType(YFELD)'=2  ;NUR LEISTUNGEN ;only service
        if (mOp.NotEqual(include.INConst.$$$INARTItemType(m$,m$.var("YFELD")),2)) {
          break;
        }
        //<< . ;FERTIGUNGSPLATZ
        //<< . QUIT:$PIECE(YFELD,Y,61)'=""      ;SCHON BELEGT ;production site
        if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YFELD").get(),m$.var("Y").get(),61),"")) {
          break;
        }
        //<< . IF $PIECE($GET(^INMASCH(0,$PIECE(YFELD,Y,57),1)),Y,9)'="" DO  ;FERTIGUNGSNEST
        if (mOp.NotEqual(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^INMASCH",0,m$.Fnc.$piece(m$.var("YFELD").get(),m$.var("Y").get(),57),1)),m$.var("Y").get(),9),"")) {
          //<< . . SET $PIECE(YFELD,Y,61) = $PIECE($GET(^INMASCH(0,$PIECE(YFELD,Y,57),1)),Y,9)  ;VORGABE   ;default
          m$.pieceVar(m$.var("YFELD"),m$.var("Y").get(),61).set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^INMASCH",0,m$.Fnc.$piece(m$.var("YFELD").get(),m$.var("Y").get(),57),1)),m$.var("Y").get(),9));
        }
      } while (false);
    }
    //<< 
    //<< 
    //<< IF YKALK'="" DO  ;VORGABEN ÜBERTRAGEN ;transport
    if (mOp.NotEqual(YKALK.get(),"")) {
      //<< . IF $PIECE(YKALK,Y,25)=1 DO  ;IMMER NEU BERECHNEN! 1.PREIS ;constantly recent
      if (mOp.Equal(m$.Fnc.$piece(YKALK.get(),m$.var("Y").get(),25),1)) {
        do {
          //<< . . IF $PIECE(YKALK,Y,30)'="" IF $$$INARTItemType(YFELD)'="" QUIT:$FIND($PIECE(YKALK,Y,30),$$$INARTItemType(YFELD))   ;AUSSNAHMEN DER UEBERGABE = NICHT ANZEIGEN ;the Not display
          if (mOp.NotEqual(m$.Fnc.$piece(YKALK.get(),m$.var("Y").get(),30),"")) {
            if (mOp.NotEqual(include.INConst.$$$INARTItemType(m$,m$.var("YFELD")),"")) {
              if (mOp.Logical(m$.Fnc.$find(m$.Fnc.$piece(YKALK.get(),m$.var("Y").get(),30),include.INConst.$$$INARTItemType(m$,m$.var("YFELD"))))) {
                break;
              }
            }
          }
          //<< . . IF +$PIECE(YFELD,Y,47)'=0 SET $PIECE(YFELD,Y,88) = ""   ;PREIS LÖSCHEN DANN NEU ;price Delete recent
          if (mOp.NotEqual(mOp.Positive(m$.Fnc.$piece(m$.var("YFELD").get(),m$.var("Y").get(),47)),0)) {
            m$.pieceVar(m$.var("YFELD"),m$.var("Y").get(),88).set("");
          }
          //<< . . IF $PIECE(YKALK,Y,11)'="" SET $PIECE(YFELD,Y,86) = $PIECE(YKALK,Y,11)  ;AUFSCHL1
          if (mOp.NotEqual(m$.Fnc.$piece(YKALK.get(),m$.var("Y").get(),11),"")) {
            m$.pieceVar(m$.var("YFELD"),m$.var("Y").get(),86).set(m$.Fnc.$piece(YKALK.get(),m$.var("Y").get(),11));
          }
          //<< . . IF $PIECE(YKALK,Y,16)'="" SET $PIECE(YFELD,Y,90) = $PIECE(YKALK,Y,16)  ;PREISKZ1
          if (mOp.NotEqual(m$.Fnc.$piece(YKALK.get(),m$.var("Y").get(),16),"")) {
            m$.pieceVar(m$.var("YFELD"),m$.var("Y").get(),90).set(m$.Fnc.$piece(YKALK.get(),m$.var("Y").get(),16));
          }
        } while (false);
      }
      //<< . ;
      //<< . IF $PIECE(YKALK,Y,26)=1 DO  ;IMMER NEU BERECHNEN! 2.PREIS ;constantly recent
      if (mOp.Equal(m$.Fnc.$piece(YKALK.get(),m$.var("Y").get(),26),1)) {
        do {
          //<< . . IF $PIECE(YKALK,Y,31)'="" IF $$$INARTItemType(YFELD)'="" QUIT:$FIND($PIECE(YKALK,Y,31),$$$INARTItemType(YFELD))   ;AUSSNAHMEN DER UEBERGABE = NICHT ANZEIGEN ;the Not display
          if (mOp.NotEqual(m$.Fnc.$piece(YKALK.get(),m$.var("Y").get(),31),"")) {
            if (mOp.NotEqual(include.INConst.$$$INARTItemType(m$,m$.var("YFELD")),"")) {
              if (mOp.Logical(m$.Fnc.$find(m$.Fnc.$piece(YKALK.get(),m$.var("Y").get(),31),include.INConst.$$$INARTItemType(m$,m$.var("YFELD"))))) {
                break;
              }
            }
          }
          //<< . . IF +$PIECE(YFELD,Y,47)'=0 SET $PIECE(YFELD,Y,98)  = ""   ;PREIS LÖSCHEN DANN NEU ;price Delete recent
          if (mOp.NotEqual(mOp.Positive(m$.Fnc.$piece(m$.var("YFELD").get(),m$.var("Y").get(),47)),0)) {
            m$.pieceVar(m$.var("YFELD"),m$.var("Y").get(),98).set("");
          }
          //<< . . IF $PIECE(YKALK,Y,12)'="" SET $PIECE(YFELD,Y,96)  = $PIECE(YKALK,Y,12)  ;AUFSCHL2
          if (mOp.NotEqual(m$.Fnc.$piece(YKALK.get(),m$.var("Y").get(),12),"")) {
            m$.pieceVar(m$.var("YFELD"),m$.var("Y").get(),96).set(m$.Fnc.$piece(YKALK.get(),m$.var("Y").get(),12));
          }
          //<< . . IF $PIECE(YKALK,Y,17)'="" SET $PIECE(YFELD,Y,100) = $PIECE(YKALK,Y,17)  ;PREISKZ2
          if (mOp.NotEqual(m$.Fnc.$piece(YKALK.get(),m$.var("Y").get(),17),"")) {
            m$.pieceVar(m$.var("YFELD"),m$.var("Y").get(),100).set(m$.Fnc.$piece(YKALK.get(),m$.var("Y").get(),17));
          }
        } while (false);
      }
      //<< . ;
      //<< . IF $PIECE(YKALK,Y,27)=1 DO  ;IMMER NEU BERECHNEN! 3.PREIS ;constantly recent
      if (mOp.Equal(m$.Fnc.$piece(YKALK.get(),m$.var("Y").get(),27),1)) {
        do {
          //<< . . IF $PIECE(YKALK,Y,32)'="" IF $$$INARTItemType(YFELD)'="" QUIT:$FIND($PIECE(YKALK,Y,32),$$$INARTItemType(YFELD))   ;AUSSNAHMEN DER UEBERGABE = NICHT ANZEIGEN ;the Not display
          if (mOp.NotEqual(m$.Fnc.$piece(YKALK.get(),m$.var("Y").get(),32),"")) {
            if (mOp.NotEqual(include.INConst.$$$INARTItemType(m$,m$.var("YFELD")),"")) {
              if (mOp.Logical(m$.Fnc.$find(m$.Fnc.$piece(YKALK.get(),m$.var("Y").get(),32),include.INConst.$$$INARTItemType(m$,m$.var("YFELD"))))) {
                break;
              }
            }
          }
          //<< . . IF +$PIECE(YFELD,Y,47)'=0 SET $PIECE(YFELD,Y,108) = ""   ;PREIS LÖSCHEN DANN NEU ;price Delete recent
          if (mOp.NotEqual(mOp.Positive(m$.Fnc.$piece(m$.var("YFELD").get(),m$.var("Y").get(),47)),0)) {
            m$.pieceVar(m$.var("YFELD"),m$.var("Y").get(),108).set("");
          }
          //<< . . IF $PIECE(YKALK,Y,13)'="" SET $PIECE(YFELD,Y,106) = $PIECE(YKALK,Y,13)  ;AUFSCHL3
          if (mOp.NotEqual(m$.Fnc.$piece(YKALK.get(),m$.var("Y").get(),13),"")) {
            m$.pieceVar(m$.var("YFELD"),m$.var("Y").get(),106).set(m$.Fnc.$piece(YKALK.get(),m$.var("Y").get(),13));
          }
          //<< . . IF $PIECE(YKALK,Y,18)'="" SET $PIECE(YFELD,Y,110) = $PIECE(YKALK,Y,18)  ;PREISKZ3
          if (mOp.NotEqual(m$.Fnc.$piece(YKALK.get(),m$.var("Y").get(),18),"")) {
            m$.pieceVar(m$.var("YFELD"),m$.var("Y").get(),110).set(m$.Fnc.$piece(YKALK.get(),m$.var("Y").get(),18));
          }
        } while (false);
      }
      //<< . ;
      //<< . IF $PIECE(YKALK,Y,28)=1 DO  ;IMMER NEU BERECHNEN! 4.PREIS ;constantly recent
      if (mOp.Equal(m$.Fnc.$piece(YKALK.get(),m$.var("Y").get(),28),1)) {
        do {
          //<< . . IF $PIECE(YKALK,Y,33)'="" IF $$$INARTItemType(YFELD)'="" QUIT:$FIND($PIECE(YKALK,Y,33),$$$INARTItemType(YFELD))   ;AUSSNAHMEN DER UEBERGABE = NICHT ANZEIGEN ;the Not display
          if (mOp.NotEqual(m$.Fnc.$piece(YKALK.get(),m$.var("Y").get(),33),"")) {
            if (mOp.NotEqual(include.INConst.$$$INARTItemType(m$,m$.var("YFELD")),"")) {
              if (mOp.Logical(m$.Fnc.$find(m$.Fnc.$piece(YKALK.get(),m$.var("Y").get(),33),include.INConst.$$$INARTItemType(m$,m$.var("YFELD"))))) {
                break;
              }
            }
          }
          //<< . . IF +$PIECE(YFELD,Y,47)'=0 SET $PIECE(YFELD,Y,118) = ""   ;PREIS LÖSCHEN DANN NEU ;price Delete recent
          if (mOp.NotEqual(mOp.Positive(m$.Fnc.$piece(m$.var("YFELD").get(),m$.var("Y").get(),47)),0)) {
            m$.pieceVar(m$.var("YFELD"),m$.var("Y").get(),118).set("");
          }
          //<< . . IF $PIECE(YKALK,Y,14)'="" SET $PIECE(YFELD,Y,116) = $PIECE(YKALK,Y,14)  ;AUFSCHL4
          if (mOp.NotEqual(m$.Fnc.$piece(YKALK.get(),m$.var("Y").get(),14),"")) {
            m$.pieceVar(m$.var("YFELD"),m$.var("Y").get(),116).set(m$.Fnc.$piece(YKALK.get(),m$.var("Y").get(),14));
          }
          //<< . . IF $PIECE(YKALK,Y,19)'="" SET $PIECE(YFELD,Y,120) = $PIECE(YKALK,Y,19)  ;PREISKZ4
          if (mOp.NotEqual(m$.Fnc.$piece(YKALK.get(),m$.var("Y").get(),19),"")) {
            m$.pieceVar(m$.var("YFELD"),m$.var("Y").get(),120).set(m$.Fnc.$piece(YKALK.get(),m$.var("Y").get(),19));
          }
        } while (false);
      }
    }
    //<< 
    //<< IF YKALK'="" DO   ;EINMALIGE VORGABE ;default
    if (mOp.NotEqual(YKALK.get(),"")) {
      do {
        //<< . IF $PIECE(YFELD,Y,86)'="" QUIT   ; SCHON EINMAL KAA ÜBERTRAGEN ;yet sometimes transport
        if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YFELD").get(),m$.var("Y").get(),86),"")) {
          break;
        }
        //<< . DO
        do {
          //<< . . IF $PIECE(YKALK,Y,30)'="" IF $$$INARTItemType(YFELD)'="" QUIT:$FIND($PIECE(YKALK,Y,30),$$$INARTItemType(YFELD))   ;AUSSNAHMEN DER UEBERGABE = NICHT ANZEIGEN
          if (mOp.NotEqual(m$.Fnc.$piece(YKALK.get(),m$.var("Y").get(),30),"")) {
            if (mOp.NotEqual(include.INConst.$$$INARTItemType(m$,m$.var("YFELD")),"")) {
              if (mOp.Logical(m$.Fnc.$find(m$.Fnc.$piece(YKALK.get(),m$.var("Y").get(),30),include.INConst.$$$INARTItemType(m$,m$.var("YFELD"))))) {
                break;
              }
            }
          }
          //<< . . IF $PIECE(YFELD,Y,86)="" SET $PIECE(YFELD,Y,86)=$PIECE(YKALK,Y,11)  ;AUFSCHL1
          if (mOp.Equal(m$.Fnc.$piece(m$.var("YFELD").get(),m$.var("Y").get(),86),"")) {
            m$.pieceVar(m$.var("YFELD"),m$.var("Y").get(),86).set(m$.Fnc.$piece(YKALK.get(),m$.var("Y").get(),11));
          }
          //<< . . IF $PIECE(YFELD,Y,90)="" SET $PIECE(YFELD,Y,90)=$PIECE(YKALK,Y,16)  ;PREISKZ1
          if (mOp.Equal(m$.Fnc.$piece(m$.var("YFELD").get(),m$.var("Y").get(),90),"")) {
            m$.pieceVar(m$.var("YFELD"),m$.var("Y").get(),90).set(m$.Fnc.$piece(YKALK.get(),m$.var("Y").get(),16));
          }
        } while(false);
        //<< . ;
        //<< . DO
        do {
          //<< . . IF $PIECE(YKALK,Y,31)'="" IF $$$INARTItemType(YFELD)'="" QUIT:$FIND($PIECE(YKALK,Y,31),$$$INARTItemType(YFELD))   ;AUSSNAHMEN DER UEBERGABE = NICHT ANZEIGEN
          if (mOp.NotEqual(m$.Fnc.$piece(YKALK.get(),m$.var("Y").get(),31),"")) {
            if (mOp.NotEqual(include.INConst.$$$INARTItemType(m$,m$.var("YFELD")),"")) {
              if (mOp.Logical(m$.Fnc.$find(m$.Fnc.$piece(YKALK.get(),m$.var("Y").get(),31),include.INConst.$$$INARTItemType(m$,m$.var("YFELD"))))) {
                break;
              }
            }
          }
          //<< . . IF $PIECE(YFELD,Y,96)=""  SET $PIECE(YFELD,Y,96) =$PIECE(YKALK,Y,12)  ;AUFSCHL2
          if (mOp.Equal(m$.Fnc.$piece(m$.var("YFELD").get(),m$.var("Y").get(),96),"")) {
            m$.pieceVar(m$.var("YFELD"),m$.var("Y").get(),96).set(m$.Fnc.$piece(YKALK.get(),m$.var("Y").get(),12));
          }
          //<< . . IF $PIECE(YFELD,Y,100)="" SET $PIECE(YFELD,Y,100)=$PIECE(YKALK,Y,17)  ;PREISKZ2
          if (mOp.Equal(m$.Fnc.$piece(m$.var("YFELD").get(),m$.var("Y").get(),100),"")) {
            m$.pieceVar(m$.var("YFELD"),m$.var("Y").get(),100).set(m$.Fnc.$piece(YKALK.get(),m$.var("Y").get(),17));
          }
        } while(false);
        //<< . ;
        //<< . DO
        do {
          //<< . . IF $PIECE(YKALK,Y,32)'="" IF $$$INARTItemType(YFELD)'="" QUIT:$FIND($PIECE(YKALK,Y,32),$$$INARTItemType(YFELD))   ;AUSSNAHMEN DER UEBERGABE = NICHT ANZEIGEN
          if (mOp.NotEqual(m$.Fnc.$piece(YKALK.get(),m$.var("Y").get(),32),"")) {
            if (mOp.NotEqual(include.INConst.$$$INARTItemType(m$,m$.var("YFELD")),"")) {
              if (mOp.Logical(m$.Fnc.$find(m$.Fnc.$piece(YKALK.get(),m$.var("Y").get(),32),include.INConst.$$$INARTItemType(m$,m$.var("YFELD"))))) {
                break;
              }
            }
          }
          //<< . . IF $PIECE(YFELD,Y,106)="" SET $PIECE(YFELD,Y,106)=$PIECE(YKALK,Y,13)  ;AUFSCHL3
          if (mOp.Equal(m$.Fnc.$piece(m$.var("YFELD").get(),m$.var("Y").get(),106),"")) {
            m$.pieceVar(m$.var("YFELD"),m$.var("Y").get(),106).set(m$.Fnc.$piece(YKALK.get(),m$.var("Y").get(),13));
          }
          //<< . . IF $PIECE(YFELD,Y,110)="" SET $PIECE(YFELD,Y,110)=$PIECE(YKALK,Y,18)  ;PREISKZ3
          if (mOp.Equal(m$.Fnc.$piece(m$.var("YFELD").get(),m$.var("Y").get(),110),"")) {
            m$.pieceVar(m$.var("YFELD"),m$.var("Y").get(),110).set(m$.Fnc.$piece(YKALK.get(),m$.var("Y").get(),18));
          }
        } while(false);
        //<< . ;
        //<< . DO
        do {
          //<< . . IF $PIECE(YKALK,Y,33)'="" IF $$$INARTItemType(YFELD)'="" QUIT:$FIND($PIECE(YKALK,Y,33),$$$INARTItemType(YFELD))   ;AUSSNAHMEN DER UEBERGABE = NICHT ANZEIGEN
          if (mOp.NotEqual(m$.Fnc.$piece(YKALK.get(),m$.var("Y").get(),33),"")) {
            if (mOp.NotEqual(include.INConst.$$$INARTItemType(m$,m$.var("YFELD")),"")) {
              if (mOp.Logical(m$.Fnc.$find(m$.Fnc.$piece(YKALK.get(),m$.var("Y").get(),33),include.INConst.$$$INARTItemType(m$,m$.var("YFELD"))))) {
                break;
              }
            }
          }
          //<< . . IF $PIECE(YFELD,Y,116)="" SET $PIECE(YFELD,Y,116)=$PIECE(YKALK,Y,14)  ;AUFSCHL4
          if (mOp.Equal(m$.Fnc.$piece(m$.var("YFELD").get(),m$.var("Y").get(),116),"")) {
            m$.pieceVar(m$.var("YFELD"),m$.var("Y").get(),116).set(m$.Fnc.$piece(YKALK.get(),m$.var("Y").get(),14));
          }
          //<< . . IF $PIECE(YFELD,Y,120)="" SET $PIECE(YFELD,Y,120)=$PIECE(YKALK,Y,19)  ;PREISKZ4
          if (mOp.Equal(m$.Fnc.$piece(m$.var("YFELD").get(),m$.var("Y").get(),120),"")) {
            m$.pieceVar(m$.var("YFELD"),m$.var("Y").get(),120).set(m$.Fnc.$piece(YKALK.get(),m$.var("Y").get(),19));
          }
        } while(false);
      } while (false);
    }
    //<< 
    //<< ;PREISE UND AUFSCHLAG ;price and overcharge
    //<< FOR YI=88,98,108,118 DO
    mVar YI = m$.var("YI");
    for (Object _YI: new Object[] {88,98,108,118}) {
    YI.set(_YI);
      do {
        //<< . ;
        //<< . IF +$PIECE(YFELD,Y,YI-2)=0   IF $PIECE(YFELD,Y,YI-2)'=0    IF $PIECE(YFELD,Y,YI+2)="" SET $PIECE(YFELD,Y,YI)="",$PIECE(YFELD,Y,YI-2)=""  ;EK=VK UND KEIN PREISKENNZEICHEN UND KEINE EK=VK ;TYBD;2,1,2005;And no
        if (mOp.Equal(mOp.Positive(m$.Fnc.$piece(m$.var("YFELD").get(),m$.var("Y").get(),mOp.Subtract(_YI,2))),0)) {
          if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YFELD").get(),m$.var("Y").get(),mOp.Subtract(_YI,2)),0)) {
            if (mOp.Equal(m$.Fnc.$piece(m$.var("YFELD").get(),m$.var("Y").get(),mOp.Add(_YI,2)),"")) {
              m$.pieceVar(m$.var("YFELD"),m$.var("Y").get(),_YI).set("");
              m$.pieceVar(m$.var("YFELD"),m$.var("Y").get(),mOp.Subtract(_YI,2)).set("");
            }
          }
        }
        //<< . IF (+$PIECE(YFELD,Y,YI-2)=0)||(+$PIECE(YFELD,Y,YI-2)=-100) IF $PIECE(YFELD,Y,YI+2)="" SET $PIECE(YFELD,Y,YI)="",$PIECE(YFELD,Y,YI-2)=""  ;EK=VK UND KEIN PREISKENNZEICHEN UND KEINE EK=VK ;TYBD;2,1,2005;And no
        if ((mOp.Equal(mOp.Positive(m$.Fnc.$piece(m$.var("YFELD").get(),m$.var("Y").get(),mOp.Subtract(_YI,2))),0)) || (mOp.Equal(mOp.Positive(m$.Fnc.$piece(m$.var("YFELD").get(),m$.var("Y").get(),mOp.Subtract(_YI,2))),mOp.Negative(100)))) {
          if (mOp.Equal(m$.Fnc.$piece(m$.var("YFELD").get(),m$.var("Y").get(),mOp.Add(_YI,2)),"")) {
            m$.pieceVar(m$.var("YFELD"),m$.var("Y").get(),_YI).set("");
            m$.pieceVar(m$.var("YFELD"),m$.var("Y").get(),mOp.Subtract(_YI,2)).set("");
          }
        }
        //<< . ;
        //<< . IF $PIECE(YFELD,Y,YI)="" IF +$PIECE(YFELD,Y,YI-2)=0 IF $PIECE(YFELD,Y,YI+2)="" IF $PIECE($GET(^INVORG(0,0,1)),Y,202)'=1 QUIT   ;TYBD;18,09,03;KEIN AUFSCHLAG UND KEIN VK
        if (mOp.Equal(m$.Fnc.$piece(m$.var("YFELD").get(),m$.var("Y").get(),_YI),"")) {
          if (mOp.Equal(mOp.Positive(m$.Fnc.$piece(m$.var("YFELD").get(),m$.var("Y").get(),mOp.Subtract(_YI,2))),0)) {
            if (mOp.Equal(m$.Fnc.$piece(m$.var("YFELD").get(),m$.var("Y").get(),mOp.Add(_YI,2)),"")) {
              if (mOp.NotEqual(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^INVORG",0,0,1)),m$.var("Y").get(),202),1)) {
                break;
              }
            }
          }
        }
        //<< . IF $PIECE(YFELD,Y,YI)="" IF +$PIECE(YFELD,Y,YI-2)'=0 DO   ;AUFSCHLAG UND KEIN VK ;overcharge And no Sale
        if (mOp.Equal(m$.Fnc.$piece(m$.var("YFELD").get(),m$.var("Y").get(),_YI),"")) {
          if (mOp.NotEqual(mOp.Positive(m$.Fnc.$piece(m$.var("YFELD").get(),m$.var("Y").get(),mOp.Subtract(_YI,2))),0)) {
            //<< . . SET YINHALT=$$^WWWZAHL($PIECE(YFELD,Y,YI-2),0,9)        ;AUFSCHLAG ;overcharge
            mVar YINHALT = m$.var("YINHALT");
            YINHALT.set(m$.fnc$("WWWZAHL.main",m$.Fnc.$piece(m$.var("YFELD").get(),m$.var("Y").get(),mOp.Subtract(_YI,2)),0,9));
            //<< . . SET YVAR=YKEY
            mVar YVAR = m$.var("YVAR");
            YVAR.set(m$.var("YKEY").get());
            //<< . . DO ^INEKVK
            m$.Cmd.Do("INEKVK.main");
            //<< . . IF %TXT(1)'="" IF $$^WWWTR(1,12,%TXT(1))'="" SET $PIECE(YFELD,Y,YI)=$$^WWWTR(1,12,%TXT(1)) ;VK EINTRAGEN ;Sale
            if (mOp.NotEqual(m$.var("%TXT",1).get(),"")) {
              if (mOp.NotEqual(m$.fnc$("WWWTR.main",1,12,m$.var("%TXT",1).get()),"")) {
                m$.pieceVar(m$.var("YFELD"),m$.var("Y").get(),_YI).set(m$.fnc$("WWWTR.main",1,12,m$.var("%TXT",1).get()));
              }
            }
          }
        }
        //<< . ;
        //<< . IF +$PIECE(YFELD,Y,YI)'=0 DO                       ;AUFSCHLAG NACHRECHNEN ;overcharge
        if (mOp.NotEqual(mOp.Positive(m$.Fnc.$piece(m$.var("YFELD").get(),m$.var("Y").get(),_YI)),0)) {
          //<< . . SET YINHALT=$$^WWWZAHL($PIECE(YFELD,Y,YI),0,2)   ;VK ;Sale
          mVar YINHALT = m$.var("YINHALT");
          YINHALT.set(m$.fnc$("WWWZAHL.main",m$.Fnc.$piece(m$.var("YFELD").get(),m$.var("Y").get(),_YI),0,2));
          //<< . . SET YVAR=YKEY
          mVar YVAR = m$.var("YVAR");
          YVAR.set(m$.var("YKEY").get());
          //<< . . DO ^INVKEK
          m$.Cmd.Do("INVKEK.main");
          //<< . . IF %TXT(1)'="" IF $$^WWWTR(1,12,%TXT(1))'="" SET $PIECE(YFELD,Y,YI-2)=$$^WWWTR(1,12,%TXT(1))
          if (mOp.NotEqual(m$.var("%TXT",1).get(),"")) {
            if (mOp.NotEqual(m$.fnc$("WWWTR.main",1,12,m$.var("%TXT",1).get()),"")) {
              m$.pieceVar(m$.var("YFELD"),m$.var("Y").get(),mOp.Subtract(_YI,2)).set(m$.fnc$("WWWTR.main",1,12,m$.var("%TXT",1).get()));
            }
          }
        }
        //<< . ;
        //<< . IF $PIECE(YFELD,Y,YI+2)'="" IF $PIECE($GET(^INVORG(0,0,1)),Y,202)=1 DO   ;EK=VK;TYBD;2,1,2005
        if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YFELD").get(),m$.var("Y").get(),mOp.Add(_YI,2)),"")) {
          if (mOp.Equal(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^INVORG",0,0,1)),m$.var("Y").get(),202),1)) {
            //<< . . SET YINHALT=$$^WWWZAHL($PIECE(YFELD,Y,YI-2),0,9)                         ;AUFSCHLAG ;overcharge
            mVar YINHALT = m$.var("YINHALT");
            YINHALT.set(m$.fnc$("WWWZAHL.main",m$.Fnc.$piece(m$.var("YFELD").get(),m$.var("Y").get(),mOp.Subtract(_YI,2)),0,9));
            //<< . . SET YVAR=YKEY
            mVar YVAR = m$.var("YVAR");
            YVAR.set(m$.var("YKEY").get());
            //<< . . DO ^INEKVK
            m$.Cmd.Do("INEKVK.main");
            //<< . . IF %TXT(1)'="" IF $$^WWWTR(1,12,%TXT(1))'="" SET $PIECE(YFELD,Y,YI)=$$^WWWTR(1,12,%TXT(1)) ;VK EINTRAGEN ;Sale
            if (mOp.NotEqual(m$.var("%TXT",1).get(),"")) {
              if (mOp.NotEqual(m$.fnc$("WWWTR.main",1,12,m$.var("%TXT",1).get()),"")) {
                m$.pieceVar(m$.var("YFELD"),m$.var("Y").get(),_YI).set(m$.fnc$("WWWTR.main",1,12,m$.var("%TXT",1).get()));
              }
            }
          }
        }
      } while (false);
    }
    //<< 
    //<< ;******************************************************************************* SUPPLIER
    //<< 
    //<< SET LIEF=$$^INARTLIEF($PIECE(YKEY,",",1))
    LIEF.set(m$.fnc$("INARTLIEF.main",m$.Fnc.$piece(m$.var("YKEY").get(),",",1)));
    //<< IF LIEF'="" SET $PIECE(YFELD,Y,195)=$PIECE($GET(^INLIEF(0,LIEF,1)),Y,8)  ;LIEFERANTENNAME IN ARTIKELSTAMM ;within
    if (mOp.NotEqual(LIEF.get(),"")) {
      m$.pieceVar(m$.var("YFELD"),m$.var("Y").get(),195).set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^INLIEF",0,LIEF.get(),1)),m$.var("Y").get(),8));
    }
    //<< 
    //<< IF LIEF'="" DO  ;NEW INFO TO INART
    if (mOp.NotEqual(LIEF.get(),"")) {
      //<< . NEW ARTK1
      mVar ARTK1 = m$.var("ARTK1");
      m$.newVarBlock(1,ARTK1);
      //<< . set ARTK1=$GET(^INARTK(0,YKEY,LIEF,1))
      ARTK1.set(m$.Fnc.$get(m$.var("^INARTK",0,m$.var("YKEY").get(),LIEF.get(),1)));
      //<< . ;
      //<< .;set $PIECE(YFELD,Y,151) = $$$INARTKProductDescription(ARTK1)                      ; D1   BESTELLBEZEICHNUNG
      //<< . set $$$INARTProductDescription(YFELD) = $$$INARTKSupplierItemNo(ARTK1)            ; D8   SR12027
      include.INConst.$$$INARTProductDescriptionSet(m$,m$.var("YFELD"),include.INConst.$$$INARTKSupplierItemNo(m$,ARTK1));
      //<< . set $$$INARTManufacturerDesc(YFELD)   = $$$INARTKManufacturersDescription(ARTK1)  ;HERSTELLERBEZEICHNUNG
      include.INConst.$$$INARTManufacturerDescSet(m$,m$.var("YFELD"),include.INConst.$$$INARTKManufacturersDescription(m$,ARTK1));
      //<< . set $$$INARTManufacturer(YFELD)       = $$$INARTKManufacturer(ARTK1)              ;HERSTELLER
      include.INConst.$$$INARTManufacturerSet(m$,m$.var("YFELD"),include.INConst.$$$INARTKManufacturer(m$,ARTK1));
      //<< . set $$$INARTSupplierCatalog(YFELD)    = $$$INARTKSupplierCatalog(ARTK1)           ;KATALOG
      include.INConst.$$$INARTSupplierCatalogSet(m$,m$.var("YFELD"),include.INConst.$$$INARTKSupplierCatalog(m$,ARTK1));
      //<< . set $$$INARTSuppliersItemGroup(YFELD) = $$$INARTKSuppliersCatalogGroup(ARTK1)     ;UNTERKATALOG/WARENGRUPPE
      include.INConst.$$$INARTSuppliersItemGroupSet(m$,m$.var("YFELD"),include.INConst.$$$INARTKSuppliersCatalogGroup(m$,ARTK1));
    }
    m$.restoreVarBlock(1);
    //<< 
    //<< ;*******************************************************************************
    //<< 
    //<< IF $$$INVORGUseItemSuperIndex($GET(^INVORG(0,0,1)))=$$$YES SET YFELD=$$^INARTINDEX(YFELD)   ;TYBD;21,2,2005;SUPERINDEX MIT TEIL STING SUCHE / PARTSTING SEARCH
    if (mOp.Equal(include.INConst.$$$INVORGUseItemSuperIndex(m$,m$.Fnc.$get(m$.var("^INVORG",0,0,1))),include.COMSYS.$$$YES(m$))) {
      mVar YFELD = m$.var("YFELD");
      YFELD.set(m$.fnc$("INARTINDEX.main",m$.var("YFELD").get()));
    }
    //<< 
    //<< 
    //<< ;*******************************************************************************  Save Record (INART)
    //<< 
    //<< SET YOK=$$^WWWSPEI(YDATEI,YKEY,YFELD,1)
    mVar YOK = m$.var("YOK");
    YOK.set(m$.fnc$("WWWSPEI.main",m$.var("YDATEI").get(),m$.var("YKEY").get(),m$.var("YFELD").get(),1));
    do {
      //<< 
      //<< ;*******************************************************************************
      //<< 
      //<< DO   ;KG UND METER IN LIEFERANTENKONDITIONEN PRUEFEN
      //<< . NEW ART,ART1,YART1,YARTK1,ME,LIEF
      mVar ART = m$.var("ART");
      mVar ART1 = m$.var("ART1");
      mVar YART1 = m$.var("YART1");
      mVar YARTK1 = m$.var("YARTK1");
      m$.newVarBlock(1,ART,ART1,YART1,YARTK1,ME,LIEF);
      //<< . SET YART1 = YFELD                        ; objINART
      YART1.set(m$.var("YFELD").get());
      //<< . SET ART   = YKEY
      ART.set(m$.var("YKEY").get());
      //<< . DO   ;LÖSCHEN DES FAKTORS, WENN GLEICHE EINHEIT
      do {
        //<< . . SET ME=$$$INARTUnitofMeasure(YART1)
        ME.set(include.INConst.$$$INARTUnitofMeasure(m$,YART1));
        //<< . . SET LIEF=""
        LIEF.set("");
        //<< . . FOR  SET LIEF=$ORDER(^INARTK(0,ART,LIEF)) QUIT:LIEF=""  DO
        for (;true;) {
          LIEF.set(m$.Fnc.$order(m$.var("^INARTK",0,ART.get(),LIEF.get())));
          if (mOp.Equal(LIEF.get(),"")) {
            break;
          }
          do {
            //<< . . . QUIT:$$$INARTKDeliveryQuantityUnit($get(^INARTK(0,ART,LIEF,1)))'=ME
            if (mOp.NotEqual(include.INConst.$$$INARTKDeliveryQuantityUnit(m$,m$.Fnc.$get(m$.var("^INARTK",0,ART.get(),LIEF.get(),1))),ME.get())) {
              break;
            }
            //<< . . . ;
            //<< . . . SET $$$INARTKConversionFactor(^INARTK(0,ART,LIEF,1))=""
            include.INConst.$$$INARTKConversionFactorSet(m$,m$.var("^INARTK",0,ART.get(),LIEF.get(),1),"");
          } while (false);
        }
      } while(false);
      //<< . ;
      //<< . DO  ;KOPIE, WENN KG UND METER
      do {
        //<< . . SET ME=$$$INARTUnitofMeasure(YART1)
        ME.set(include.INConst.$$$INARTUnitofMeasure(m$,YART1));
        //<< . . IF (ME'=5) && (ME'=6) && (ME'=12) && (ME'=18) QUIT
        if ((mOp.NotEqual(ME.get(),5)) && (mOp.NotEqual(ME.get(),6)) && (mOp.NotEqual(ME.get(),12)) && (mOp.NotEqual(ME.get(),18))) {
          break;
        }
        //<< . . QUIT:+$PIECE(YART1,Y,172)=0                                ; D172   $$$INARTWeightUM()
        if (mOp.Equal(mOp.Positive(m$.Fnc.$piece(YART1.get(),m$.var("Y").get(),172)),0)) {
          break;
        }
        //<< . . SET LIEF=""
        LIEF.set("");
        //<< . . FOR  SET LIEF=$ORDER(^INARTK(0,ART,LIEF)) QUIT:LIEF=""  DO
        for (;true;) {
          LIEF.set(m$.Fnc.$order(m$.var("^INARTK",0,ART.get(),LIEF.get())));
          if (mOp.Equal(LIEF.get(),"")) {
            break;
          }
          do {
            //<< . . . QUIT:$$$INARTKDeliveryQuantityUnit($get(^INARTK(0,ART,LIEF,1)))'=4
            if (mOp.NotEqual(include.INConst.$$$INARTKDeliveryQuantityUnit(m$,m$.Fnc.$get(m$.var("^INARTK",0,ART.get(),LIEF.get(),1))),4)) {
              break;
            }
            //<< . . . ;
            //<< . . . SET YARTK1=$GET(^INARTK(0,ART,LIEF,1))
            YARTK1.set(m$.Fnc.$get(m$.var("^INARTK",0,ART.get(),LIEF.get(),1)));
            //<< . . . QUIT:+$$$INARTKConversionFactor(YARTK1)'=0
            if (mOp.NotEqual(mOp.Positive(include.INConst.$$$INARTKConversionFactor(m$,YARTK1)),0)) {
              break;
            }
            //<< . . . SET $$$INARTKConversionFactor(^INARTK(0,ART,LIEF,1))=$PIECE(YART1,Y,172)
            include.INConst.$$$INARTKConversionFactorSet(m$,m$.var("^INARTK",0,ART.get(),LIEF.get(),1),m$.Fnc.$piece(YART1.get(),m$.var("Y").get(),172));
          } while (false);
        }
      } while(false);
    } while(false);
    m$.restoreVarBlock(1);
    //<< 
    //<< ; Hours, Minutes, Industry Minutes
    //<< if (ME=2) || (ME=10) || (ME=11) {
    if ((mOp.Equal(ME.get(),2)) || (mOp.Equal(ME.get(),10)) || (mOp.Equal(ME.get(),11))) {
      //<< set $$$INARTSetupCosts(^INART(0,YKEY,1))=$$^INARTRWERT(YKEY)  ; D71   RECHNEN RÜSTKOSTEN FÜR LEISTUNGEN
      include.INConst.$$$INARTSetupCostsSet(m$,m$.var("^INART",0,m$.var("YKEY").get(),1),m$.fnc$("INARTRWERT.main",m$.var("YKEY").get()));
    }
    //<< } else {
    else {
      //<< DO ^INARTNEU(YKEY)  ;ARTIKELTEILE NEU BERECHNEN ;recent calculate
      m$.Cmd.Do("INARTNEU.main",m$.var("YKEY").get());
    }
    //<< }
    //<< 
    //<< DO ^INKUNDEARTSPERR(,YKEY)  ;SPEICHERN KUNDEN-ARTIKELSPERRE;FIS;15.02.05;27351
    m$.Cmd.Do("INKUNDEARTSPERR.main",null,m$.var("YKEY").get());
    //<< 
    //<< set strStatus = $$HealthCheck^INARTPACK(YKEY)   ; SR17243 vvv
    strStatus.set(m$.fnc$("INARTPACK.HealthCheck",m$.var("YKEY").get()));
    //<< if $$$ISERR(strStatus) {
    if (mOp.Logical(include.COMSYS.$$$ISERR(m$,strStatus))) {
      //<< $$$Alert(strStatus)       ; Can't display message AFTER loading form
      include.COMSYS.$$$Alert(m$,strStatus);
      //<< do GoToForm^COMUtilForm("INARTPACK",YKEY)
      m$.Cmd.Do("COMUtilForm.GoToForm","INARTPACK",m$.var("YKEY").get());
    }
    //<< }
    //<< quit
    return;
  }

  //<< 
  //<< 
  //<< KILL ;KILL WENN LÖSCHEN ;when Delete
  public Object KILL() {
    //<< QUIT:YKEY=""
    if (mOp.Equal(m$.var("YKEY").get(),"")) {
      return null;
    }
    //<< DO ^INARTKILL(YKEY)
    m$.Cmd.Do("INARTKILL.main",m$.var("YKEY").get());
    //<< QUIT
    return null;
  }

  //<< 
  //<< 
  //<< KILL1 ;KEIN LÖSCHEN MÖGLICH ;no Delete potential
  public void KILL1() {
    //<< ;-------------------------------------------------------------------------------
    //<< ; Check to disable/enable record Delete button.
    //<< ;
    //<< ; Delete button disabled if Q set to $$$QDontSave,
    //<< ; Delete button allowed if Q set to $$$QSave.
    //<< ;
    //<< ; Params:
    //<< ;
    //<< ; ByRefs:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 05-Nov-2010   GRF     -: use delete macros rather than save - same values
    //<< ; 20-Jul-2010   PPP/CB  SR17468 : Use alSOH.StockHistory instead of INARTHISTL
    //<< ; 07-Mar-2006   SC      SR14378: Disable delete in item on a Bill of Materials,
    //<< ;                           or has Transaction History.
    //<< ;-------------------------------------------------------------------------------
    //<< SET Q = $$$QDelete
    mVar Q = m$.var("Q");
    Q.set(include.COMSYSWWW.$$$QDelete(m$));
    //<< QUIT:$GET(YKEY)=""
    if (mOp.Equal(m$.Fnc.$get(m$.var("YKEY")),"")) {
      return;
    }
    //<< 
    //<< IF +$TRANSLATE($$^INARTAUF(YKEY),"/")'=0 {
    if (mOp.NotEqual(mOp.Positive(m$.Fnc.$translate(m$.fnc$("INARTAUF.main",m$.var("YKEY").get()),"/")),0)) {
      //<< SET Q = $$$QDontDelete                       ;MENGE VORHANDEN ;quantity on hand
      Q.set(include.COMSYSWWW.$$$QDontDelete(m$));
    }
    //<< 
    //<< } elseif +$$^INARTMENGE(YKEY)'=0 {
    else if (mOp.NotEqual(mOp.Positive(m$.fnc$("INARTMENGE.main",m$.var("YKEY").get())),0)) {
      //<< SET Q = $$$QDontDelete                       ;AUFRTÄGE VORHANDEN ;quantity on hand
      Q.set(include.COMSYSWWW.$$$QDontDelete(m$));
    }
    //<< 
    //<< } elseif $DATA(^INARTTs(0,1,$$^WWWUMLAU(YKEY,1))) {
    else if (mOp.Logical(m$.Fnc.$data(m$.var("^INARTTs",0,1,m$.fnc$("WWWUMLAU.main",m$.var("YKEY").get(),1))))) {
      //<< SET Q = $$$QDontDelete                       ;If item is on a Bill of Materials. ;SR14378
      Q.set(include.COMSYSWWW.$$$QDontDelete(m$));
    }
    //<< 
    //<< 
    //<< //} elseif $DATA(^INARTHISTL(0,YKEY)) {       ; SR17468
    //<< } elseif ##class(alSOH.iStockHistory).ItemHasTransactions(YKEY) {
    else if (mOp.Logical(m$.fnc$("alSOH.iStockHistory.ItemHasTransactions",m$.var("YKEY").get()))) {
      //<< SET Q = $$$QDontDelete                       ;If item has transaction history.   ;SR14378
      Q.set(include.COMSYSWWW.$$$QDontDelete(m$));
    }
    //<< }
    //<< 
    //<< ;IF Q=$$$QDontDelete DO ^WWWINFO($$^WWWTEXT(32528),1)   ;NICHT GELÖSCHT, DA AUFTRÄGE
    //<< quit
    return;
  }

  //<< 
  //<< 
  //<< OnAfterPrimaryKey(YKEY="",YFELD="")
  public Object OnAfterPrimaryKey(Object ... _p) {
    mVar YKEY = m$.newVarRef("YKEY",(((_p!=null)&&(_p.length>=1))?_p[0]:null),"");
    mVar YFELD = m$.newVarRef("YFELD",(((_p!=null)&&(_p.length>=2))?_p[1]:null),"");
    //<< ;-------------------------------------------------------------------------------
    //<< ;
    //<< ; Params:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 16-Feb-2009   GRF     SR16347: Call ItemUnits to improve INART presentation
    //<< ; 27-Jul-2005   shobby  SR12786 Created
    //<< ;-------------------------------------------------------------------------------
    //<< do BuildCustomsMessage(YKEY,YFELD)
    m$.Cmd.Do("BuildCustomsMessage",YKEY.get(),YFELD.get());
    //<< do ^INARTINFO
    m$.Cmd.Do("INARTINFO.main");
    //<< do ItemUnits^INARTPACK(YKEY)     ; SR16347
    m$.Cmd.Do("INARTPACK.ItemUnits",YKEY.get());
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< BuildCustomsMessage(YKEY="",YFELD="")
  public Object BuildCustomsMessage(Object ... _p) {
    mVar YKEY = m$.newVarRef("YKEY",(((_p!=null)&&(_p.length>=1))?_p[0]:null),"");
    mVar YFELD = m$.newVarRef("YFELD",(((_p!=null)&&(_p.length>=2))?_p[1]:null),"");
    //<< ;-------------------------------------------------------------------------------
    //<< ; Determines and displays an appropriate message as to how Customs are applied to this item.
    //<< ;
    //<< ; Params:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 31-Oct-2006   Steve S SRBR014280: (Peer review) Added carriage returns
    //<< ; 13-Oct-2006   HeberB  SRBR014280: Only display message when defined on INVORG
    //<< ; 21-Aug-2006   shobby  SRBR014203: Don't display a message when no record is loaded.
    //<< ; 15-Jul-2005   shobby  SR12786: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new objINVORG,strForm,strLevel,strMessage
    mVar objINVORG = m$.var("objINVORG");
    mVar strForm = m$.var("strForm");
    mVar strLevel = m$.var("strLevel");
    mVar strMessage = m$.var("strMessage");
    m$.newVar(objINVORG,strForm,strLevel,strMessage);
    //<< 
    //<< set strForm   = YFORM
    strForm.set(m$.var("YFORM").get());
    //<< set objINVORG = $get(^INVORG(0,0,1))
    objINVORG.set(m$.Fnc.$get(m$.var("^INVORG",0,0,1)));
    //<< 
    //<< if $$$NoKey(YKEY) || ($$$INVORGHideCustomsInformation(objINVORG)) {
    if (mOp.Logical(include.COMSYS.$$$NoKey(m$,YKEY)) || mOp.Logical((include.INConst.$$$INVORGHideCustomsInformation(m$,objINVORG)))) {
      //<< set strMessage = "&nbsp;"
      strMessage.set("&nbsp;");
    }
    //<< 
    //<< } elseif $$$INARTExemptFromDuty(YFELD) {
    else if (mOp.Logical(include.INConst.$$$INARTExemptFromDuty(m$,YFELD))) {
      //<< set strMessage = "IN00353"              ; "This item is not subject to Customs."
      strMessage.set("IN00353");
    }
    //<< 
    //<< } elseif $$HasCustoms(YKEY,.strLevel) {
    else if (mOp.Logical(m$.fnc$("HasCustoms",YKEY.get(),strLevel))) {
      //<< set strMessage = "IN00354"              ; "This item has Customs rate set up at Supplier or Country level."
      strMessage.set("IN00354");
    }
    //<< 
    //<< } else {
    else {
      //<< set strMessage = "IN00355"              ; "This item is subject to Customs but has no rates set up."
      strMessage.set("IN00355");
    }
    //<< }
    //<< 
    //<< do DisplayMessage^COMUtils(strForm,YKEY,strMessage,,0,6)
    m$.Cmd.Do("COMUtils.DisplayMessage",strForm.get(),YKEY.get(),strMessage.get(),null,0,6);
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< OnAfterDataFields(YKEY="",YFELD="")
  public Object OnAfterDataFields(Object ... _p) {
    mVar YKEY = m$.newVarRef("YKEY",(((_p!=null)&&(_p.length>=1))?_p[0]:null),"");
    mVar YFELD = m$.newVarRef("YFELD",(((_p!=null)&&(_p.length>=2))?_p[1]:null),"");
    //<< ;-------------------------------------------------------------------------------
    //<< ;
    //<< ; Params:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 10-Oct-2006   JW      SR15104: Add page 3 check, add param to INARTPRICESHOW1
    //<< ; 27-Jul-2005   shobby  SR12786 Created
    //<< ;-------------------------------------------------------------------------------
    //<< if YSEITE=3 {
    if (mOp.Equal(m$.var("YSEITE").get(),3)) {
      //<< do Show^INARTPRICESHOW1(YKEY)
      m$.Cmd.Do("INARTPRICESHOW1.Show",YKEY.get());
    }
    //<< } elseif YSEITE=6 {
    else if (mOp.Equal(m$.var("YSEITE").get(),6)) {
      //<< do ShowCustoms(YKEY,YFELD)
      m$.Cmd.Do("ShowCustoms",YKEY.get(),YFELD.get());
    }
    //<< }
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< ShowCustoms(YKEY="",YFELD="")
  public Object ShowCustoms(Object ... _p) {
    mVar YKEY = m$.newVarRef("YKEY",(((_p!=null)&&(_p.length>=1))?_p[0]:null),"");
    mVar YFELD = m$.newVarRef("YFELD",(((_p!=null)&&(_p.length>=2))?_p[1]:null),"");
    //<< ;-------------------------------------------------------------------------------
    //<< ; Display a tree of all customs rates for this item.
    //<< ;
    //<< ; Params:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 15-Jul-2005   shobby  SR12786: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new fltRate,idCountry,idSupplier,objINARTK,objINLIEF
    mVar fltRate = m$.var("fltRate");
    mVar idCountry = m$.var("idCountry");
    mVar idSupplier = m$.var("idSupplier");
    mVar objINARTK = m$.var("objINARTK");
    mVar objINLIEF = m$.var("objINLIEF");
    m$.newVar(fltRate,idCountry,idSupplier,objINARTK,objINLIEF);
    //<< new strDescription,strKey,strKey2,strKey3
    mVar strDescription = m$.var("strDescription");
    mVar strKey = m$.var("strKey");
    mVar strKey2 = m$.var("strKey2");
    mVar strKey3 = m$.var("strKey3");
    m$.newVar(strDescription,strKey,strKey2,strKey3);
    //<< 
    //<< if '$$$NoKey(YKEY) {
    if (mOp.Not(include.COMSYS.$$$NoKey(m$,YKEY))) {
      //<< do StartTree^COMTree2($get(YPARA))
      m$.Cmd.Do("COMTree2.StartTree",m$.Fnc.$get(m$.var("YPARA")));
      //<< set fltRate        = $$GetRate(YKEY,"INARTCustom",.strKey)
      fltRate.set(m$.fnc$("GetRate",YKEY.get(),"INARTCustom",strKey));
      //<< set strDescription = YKEY_":"_$$$INARTSearchName(YFELD)
      strDescription.set(mOp.Concat(mOp.Concat(YKEY.get(),":"),include.INConst.$$$INARTSearchName(m$,YFELD)));
      //<< do AddNode^COMTree2("",strKey,"",strDescription,"","INARTCustom","","",fltRate,"","")
      m$.Cmd.Do("COMTree2.AddNode","",strKey.get(),"",strDescription.get(),"","INARTCustom","","",fltRate.get(),"","");
      //<< set idSupplier = ""
      idSupplier.set("");
      //<< for {
      for (;true;) {
        //<< set idSupplier = $order(^INARTK(0,YKEY,idSupplier))
        idSupplier.set(m$.Fnc.$order(m$.var("^INARTK",0,YKEY.get(),idSupplier.get())));
        //<< quit:idSupplier=""
        if (mOp.Equal(idSupplier.get(),"")) {
          break;
        }
        //<< 
        //<< set objINLIEF      = $get(^INLIEF(0,idSupplier,1))
        objINLIEF.set(m$.Fnc.$get(m$.var("^INLIEF",0,idSupplier.get(),1)));
        //<< set objINARTK      = $get(^INARTK(0,YKEY,idSupplier,1))
        objINARTK.set(m$.Fnc.$get(m$.var("^INARTK",0,YKEY.get(),idSupplier.get(),1)));
        //<< set fltRate        = $$GetRate(YKEY_","_idSupplier,"INARTKCustom",.strKey2)
        fltRate.set(m$.fnc$("GetRate",mOp.Concat(mOp.Concat(YKEY.get(),","),idSupplier.get()),"INARTKCustom",strKey2));
        //<< set strDescription = idSupplier_":"_$$$INLIEFShortName(objINLIEF)
        strDescription.set(mOp.Concat(mOp.Concat(idSupplier.get(),":"),include.INConst.$$$INLIEFShortName(m$,objINLIEF)));
        //<< do AddNode^COMTree2(strKey,strKey2,"",strDescription,"","INARTKCustom","","",fltRate,"","")
        m$.Cmd.Do("COMTree2.AddNode",strKey.get(),strKey2.get(),"",strDescription.get(),"","INARTKCustom","","",fltRate.get(),"","");
        //<< 
        //<< set idCountry = ""
        idCountry.set("");
        //<< for {
        for (;true;) {
          //<< set idCountry = $order(^INARTKCountry(0,YKEY,idSupplier,idCountry))
          idCountry.set(m$.Fnc.$order(m$.var("^INARTKCountry",0,YKEY.get(),idSupplier.get(),idCountry.get())));
          //<< quit:idCountry=""
          if (mOp.Equal(idCountry.get(),"")) {
            break;
          }
          //<< 
          //<< set fltRate        = $$GetRate(YKEY_","_idSupplier_","_idCountry,"INARTKCountryCustom",.strKey3)
          fltRate.set(m$.fnc$("GetRate",mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(YKEY.get(),","),idSupplier.get()),","),idCountry.get()),"INARTKCountryCustom",strKey3));
          //<< set strDescription = idCountry_":"_$$GetEnumDescription^COMUtils("LAND",idCountry,1)
          strDescription.set(mOp.Concat(mOp.Concat(idCountry.get(),":"),m$.fnc$("COMUtils.GetEnumDescription","LAND",idCountry.get(),1)));
          //<< do AddNode^COMTree2(strKey2,strKey3,"",strDescription,"","INARTKCountryCustom","","",fltRate,"","")
          m$.Cmd.Do("COMTree2.AddNode",strKey2.get(),strKey3.get(),"",strDescription.get(),"","INARTKCountryCustom","","",fltRate.get(),"","");
        }
      }
      //<< }
      //<< }
      //<< do StopTree^COMTree2(1)
      m$.Cmd.Do("COMTree2.StopTree",1);
    }
    //<< }
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< HasCustoms(YKEY="",pstrLevel="")
  public Object HasCustoms(Object ... _p) {
    mVar YKEY = m$.newVarRef("YKEY",(((_p!=null)&&(_p.length>=1))?_p[0]:null),"");
    mVar pstrLevel = m$.newVarRef("pstrLevel",(((_p!=null)&&(_p.length>=2))?_p[1]:null),"");
    //<< ;-------------------------------------------------------------------------------
    //<< ; Determine if this item has customs at any level.
    //<< ;
    //<< ; Params:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 15-Jul-2005   shobby  SR12786?: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new blnHasCustoms
    mVar blnHasCustoms = m$.var("blnHasCustoms");
    m$.newVar(blnHasCustoms);
    //<< 
    //<< set blnHasCustoms = $$$NO
    blnHasCustoms.set(include.COMSYS.$$$NO(m$));
    //<< if YKEY'="" {
    if (mOp.NotEqual(YKEY.get(),"")) {
      //<< set blnHasCustoms = $$$YES
      blnHasCustoms.set(include.COMSYS.$$$YES(m$));
      //<< if '$data(^INARTCustom(0,YKEY)) {
      if (mOp.Not(m$.Fnc.$data(m$.var("^INARTCustom",0,YKEY.get())))) {
        //<< if '$data(^INARTKCustom(0,YKEY)) {
        if (mOp.Not(m$.Fnc.$data(m$.var("^INARTKCustom",0,YKEY.get())))) {
          //<< if '$data(^INARTKCountryCustom(0,YKEY)) {
          if (mOp.Not(m$.Fnc.$data(m$.var("^INARTKCountryCustom",0,YKEY.get())))) {
            //<< set blnHasCustoms = $$$NO
            blnHasCustoms.set(include.COMSYS.$$$NO(m$));
          }
        }
      }
    }
    //<< }
    //<< }
    //<< }
    //<< }
    //<< quit blnHasCustoms
    return blnHasCustoms.get();
  }

  //<< 
  //<< 
  //<< GetRate(YKEY,YDATEI,pidLinkKey)
  public Object GetRate(Object ... _p) {
    mVar YKEY = m$.newVarRef("YKEY",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar YDATEI = m$.newVarRef("YDATEI",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pidLinkKey = m$.newVarRef("pidLinkKey",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Find the rate that applies for this level
    //<< ;
    //<< ; Params:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 15-Jul-2005   shobby  SR12786 Created
    //<< ;-------------------------------------------------------------------------------
    //<< new fltRate,idDate,obj
    mVar fltRate = m$.var("fltRate");
    mVar idDate = m$.var("idDate");
    mVar obj = m$.var("obj");
    m$.newVar(fltRate,idDate,obj);
    //<< 
    //<< set fltRate = "......."
    fltRate.set(".......");
    //<< if $get(YKEY)'="" {
    if (mOp.NotEqual(m$.Fnc.$get(YKEY),"")) {
      //<< set pidLinkKey = $$^WWWKEYBUILD(YKEY)
      pidLinkKey.set(m$.fnc$("WWWKEYBUILD.main",YKEY.get()));
      //<< set idDate     = ""
      idDate.set("");
      //<< xecute "set idDate=$order(^"_YDATEI_"("_$$^WWWYM(YDATEI)_","_pidLinkKey_",""""),-1)"
      m$.Cmd.Xecute(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("set idDate=$order(^",YDATEI.get()),"("),m$.fnc$("WWWYM.main",YDATEI.get())),","),pidLinkKey.get()),",\"\"),-1)"));
      //<< if idDate'="" {
      if (mOp.NotEqual(idDate.get(),"")) {
        //<< set obj = ""
        obj.set("");
        //<< xecute "set obj=$get(^"_YDATEI_"("_$$^WWWYM(YDATEI)_","_pidLinkKey_",idDate,1))"
        m$.Cmd.Xecute(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("set obj=$get(^",YDATEI.get()),"("),m$.fnc$("WWWYM.main",YDATEI.get())),","),pidLinkKey.get()),",idDate,1))"));
        //<< set fltRate = $$$INARTCustomRate(obj)
        fltRate.set(include.INConst.$$$INARTCustomRate(m$,obj));
      }
      //<< }
      //<< set pidLinkKey = $translate(pidLinkKey_","_idDate,"""")
      pidLinkKey.set(m$.Fnc.$translate(mOp.Concat(mOp.Concat(pidLinkKey.get(),","),idDate.get()),"\""));
    }
    //<< }
    //<< quit fltRate
    return fltRate.get();
  }

  //<< 
  //<< 
  //<< OnBeforeSave(pobjItem="")
  public Object OnBeforeSave(Object ... _p) {
    mVar pobjItem = m$.newVarRef("pobjItem",(((_p!=null)&&(_p.length>=1))?_p[0]:null),"");
    //<< ;-------------------------------------------------------------------------------
    //<< ; Routine to execute before saving an item record
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 24-Jun-2005   GRF     Ensure Q is cleanly set
    //<< ; 17-Jun-2005   Steve S Use Macros
    //<< ; 04-Apr-2005   Steve S Created SR11996
    //<< ;-------------------------------------------------------------------------------
    //<< new idForeignAcc,idInlandAcc,strStatus
    mVar idForeignAcc = m$.var("idForeignAcc");
    mVar idInlandAcc = m$.var("idInlandAcc");
    mVar strStatus = m$.var("strStatus");
    m$.newVar(idForeignAcc,idInlandAcc,strStatus);
    //<< 
    //<< ;TODO: Do we need this routine, now that @net manager supports relation validation?
    //<< 
    //<< set Q = $$$QSave
    mVar Q = m$.var("Q");
    Q.set(include.COMSYSWWW.$$$QSave(m$));
    //<< set idInlandAcc  = $$$INARTRevenueAccountInland(pobjItem)
    idInlandAcc.set(include.INConst.$$$INARTRevenueAccountInland(m$,pobjItem));
    //<< set idForeignAcc = $$$INARTRevenueAccountForeign(pobjItem)
    idForeignAcc.set(include.INConst.$$$INARTRevenueAccountForeign(m$,pobjItem));
    //<< set strStatus    = $$$OK
    strStatus.set(include.COMSYS.$$$OK(m$));
    //<< 
    //<< if (idInlandAcc'="") && '$data(^INFIBSA(0,idInlandAcc,1)) {
    if ((mOp.NotEqual(idInlandAcc.get(),"")) && mOp.Not(m$.Fnc.$data(m$.var("^INFIBSA",0,idInlandAcc.get(),1)))) {
      //<< set strStatus = $$^WWWFELDNAME("INART","D",31)_" '"_idInlandAcc_"' : "_$$^WWWTEXT(86)   ; "Not Available!"
      strStatus.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(m$.fnc$("WWWFELDNAME.main","INART","D",31)," '"),idInlandAcc.get()),"' : "),m$.fnc$("WWWTEXT.main",86)));
    }
    //<< }
    //<< 
    //<< if (strStatus=$$$OK) && (idForeignAcc'="") && ('$data(^INFIBSA(0,idForeignAcc,1))) {
    if ((mOp.Equal(strStatus.get(),include.COMSYS.$$$OK(m$))) && (mOp.NotEqual(idForeignAcc.get(),"")) && (mOp.Not(m$.Fnc.$data(m$.var("^INFIBSA",0,idForeignAcc.get(),1))))) {
      //<< set strStatus = $$^WWWFELDNAME("INART","D",32)_" '"_idForeignAcc_"' : "_$$^WWWTEXT(86)
      strStatus.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(m$.fnc$("WWWFELDNAME.main","INART","D",32)," '"),idForeignAcc.get()),"' : "),m$.fnc$("WWWTEXT.main",86)));
    }
    //<< }
    //<< 
    //<< if strStatus'=$$$OK {
    if (mOp.NotEqual(strStatus.get(),include.COMSYS.$$$OK(m$))) {
      //<< set Q = $$$QDontSave
      Q.set(include.COMSYSWWW.$$$QDontSave(m$));
      //<< do ^WWWINFO(strStatus)
      m$.Cmd.Do("WWWINFO.main",strStatus.get());
    }
    //<< }
    //<< 
    //<< if ((+$$$WWWClientParamCoreChangesALL($get(^WWWClientParam(YM,YM,1))))
    //<< && '(+$$$WWWClientParamCoreChangesTCI($get(^WWWClientParam(YM,YM,1))))){
    if ((mOp.Logical((mOp.Positive(include.WWWConst.$$$WWWClientParamCoreChangesALL(m$,m$.Fnc.$get(m$.var("^WWWClientParam",m$.var("YM").get(),m$.var("YM").get(),1)))))) && mOp.Not((mOp.Positive(include.WWWConst.$$$WWWClientParamCoreChangesTCI(m$,m$.Fnc.$get(m$.var("^WWWClientParam",m$.var("YM").get(),m$.var("YM").get(),1)))))))) {
      //<< ;Rotina VAR para gerar o código do Produto
      //<< if (strStatus=$$$OK){
      if ((mOp.Equal(strStatus.get(),include.COMSYS.$$$OK(m$)))) {
        //<< do GerarChaveINART^VARINART(YKEY, pobjItem)
        m$.Cmd.Do("VARINART.GerarChaveINART",m$.var("YKEY").get(),pobjItem.get());
      }
    }
    //<< }
    //<< }
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< OnBeforeDataAccess(YKEY,YFELD)
  public Object OnBeforeDataAccess(Object ... _p) {
    mVar YKEY = m$.newVarRef("YKEY",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar YFELD = m$.newVarRef("YFELD",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Filters what COMView displays for chosing. It is mandatory to test if the calling form
    //<< ; is the intended one.
    //<< ;
    //<< ; Called by : OnBeforeDataAccess Class Hook for INART
    //<< ; Params:
    //<< ;
    //<< ; Returns:
    //<< ; $$$YES - if the item can be displayed for the user
    //<< ; $$$NO  - if the item cannot be displayed (it will be hidden)
    //<< ;
    //<< ; History:
    //<< ; 19-Nov-2009   shobby  SR17034: Call to OnBeforeDataAccess
    //<< ; 21-Jan-2008   GRF     SRBR014847: variable prefix; doco
    //<< ; 15-Jan-2008   LUIS    SRBR014847: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new idItem,objStocktake,strItemGroups,strStatus
    mVar idItem = m$.var("idItem");
    mVar objStocktake = m$.var("objStocktake");
    mVar strItemGroups = m$.var("strItemGroups");
    mVar strStatus = m$.var("strStatus");
    m$.newVar(idItem,objStocktake,strItemGroups,strStatus);
    //<< 
    //<< ;It defaults to show everything in order to keep other things from breaking
    //<< set strStatus = $$$YES
    strStatus.set(include.COMSYS.$$$YES(m$));
    //<< 
    //<< ;Choose which check to run based on the calling form
    //<< if ($get(YFORM)="INWEINVELINE") {
    if ((mOp.Equal(m$.Fnc.$get(m$.var("YFORM")),"INWEINVELINE"))) {
      //<< if $data(^CacheTempStocktakePara(YUSER,"idStocktake")) {
      if (mOp.Logical(m$.Fnc.$data(m$.var("^CacheTempStocktakePara",m$.var("YUSER").get(),"idStocktake")))) {
        //<< 
        //<< ;The idStocktake was stored at OnAfterPrimaryKey^INWEINVEHeader
        //<< set objStocktake = $$GetStocktake^INStocktaking($get(^CacheTempStocktakePara(YUSER,"idStocktake")))
        objStocktake.set(m$.fnc$("INStocktaking.GetStocktake",m$.Fnc.$get(m$.var("^CacheTempStocktakePara",m$.var("YUSER").get(),"idStocktake"))));
        //<< 
        //<< set strItemGroups = $$$INWEINVPItemGroup(objStocktake)
        strItemGroups.set(include.INConst.$$$INWEINVPItemGroup(m$,objStocktake));
        //<< set idItem = YKEY
        idItem.set(YKEY.get());
        //<< 
        //<< ;If the item is not on the allowed lists, don't allow it be shown
        //<< if '$$ItemGroupCheckById^INStocktaking(idItem,strItemGroups) {
        if (mOp.Not(m$.fnc$("INStocktaking.ItemGroupCheckById",idItem.get(),strItemGroups.get()))) {
          //<< set strStatus = $$$NO
          strStatus.set(include.COMSYS.$$$NO(m$));
        }
      }
    }
    //<< }
    //<< }
    //<< 
    //<< } elseif (YFORM'="") {
    else if ((mOp.NotEqual(m$.var("YFORM").get(),""))) {
      //<< if ((+$$$WWWClientParamCoreChangesALL($get(^WWWClientParam(YM,YM,1))) &&
      //<< ((YFORM = "INReqLine") ||
      //<< (YFORM = "INReqKitLine")||
      //<< (YFORM = "INTFRLine")))) {
      if (mOp.Logical(((mOp.Logical(mOp.Positive(include.WWWConst.$$$WWWClientParamCoreChangesALL(m$,m$.Fnc.$get(m$.var("^WWWClientParam",m$.var("YM").get(),m$.var("YM").get(),1))))) && mOp.Logical(((mOp.Equal(m$.var("YFORM").get(),"INReqLine")) || (mOp.Equal(m$.var("YFORM").get(),"INReqKitLine")) || (mOp.Equal(m$.var("YFORM").get(),"INTFRLine")))))))) {
        //<< quit strStatus
        return strStatus.get();
      }
      //<< }
      //<< else {
      else {
        //<< if $data(^rOBJ(YFORM_"OBDA")) xecute "set strStatus=$$OnBeforeDataAccess^"_YFORM_"OBDA(YKEY,YFELD)"     ;SR17034
        if (mOp.Logical(m$.Fnc.$data(m$.var("^rOBJ",mOp.Concat(m$.var("YFORM").get(),"OBDA"))))) {
          m$.Cmd.Xecute(mOp.Concat(mOp.Concat("set strStatus=$$OnBeforeDataAccess^",m$.var("YFORM").get()),"OBDA(YKEY,YFELD)"));
        }
      }
    }
    //<< }
    //<< }
    //<< quit strStatus
    return strStatus.get();
  }

  //<< 
  //<< 
  //<< OnBeforeSQL(&YSQL)
  public Object OnBeforeSQL(Object ... _p) {
    mVar YSQL = m$.newVarRef("YSQL",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; The OnBeforeSQL code will behave differently according to what the calling form is.
    //<< ; This routine redirects to a procedure based on the form name.
    //<< ;
    //<< ; Inputs:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 25-Nov-2009   shobby  SR17034: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new strStatus
    mVar strStatus = m$.var("strStatus");
    m$.newVar(strStatus);
    //<< 
    //<< set strStatus = $$$OK
    strStatus.set(include.COMSYS.$$$OK(m$));
    //<< if $data(^rOBJ(YFORM_"OBSQL")) xecute "set strStatus=$$OnBeforeSQL^"_YFORM_"OBSQL(.YSQL)"       ;SR17034
    if (mOp.Logical(m$.Fnc.$data(m$.var("^rOBJ",mOp.Concat(m$.var("YFORM").get(),"OBSQL"))))) {
      m$.Cmd.Xecute(mOp.Concat(mOp.Concat("set strStatus=$$OnBeforeSQL^",m$.var("YFORM").get()),"OBSQL(.YSQL)"));
    }
    //<< 
    //<< quit strStatus
    return strStatus.get();
  }

  //<< 
  //<< 
  //<< GetPAB(pidItem,pidLocation,ptmsUntil)
  public Object GetPAB(Object ... _p) {
    mVar pidItem = m$.newVarRef("pidItem",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pidLocation = m$.newVarRef("pidLocation",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar ptmsUntil = m$.newVarRef("ptmsUntil",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Returns the Projected Available Balance at the $horolog format
    //<< ; date passed in via ptmsUntil
    //<< ;
    //<< ; Called by:
    //<< ;   Form INART (Customised) F294 - 'Execute Before Data Field'
    //<< ;
    //<< ; Inputs:
    //<< ;   pidItem         Item No
    //<< ;   pidLocation     Site Location
    //<< ;   ptmsUntil       Date,Time
    //<< ;                       If omitted - use now to get PAB
    //<< ;                       If null    - return current qty on hand
    //<< ;                       If past    - use now to get PAB
    //<< ;                       If future  - find PAB at specified time
    //<< ;
    //<< ; Returns:
    //<< ;   The Projected Available Balance (unformatted)
    //<< ;
    //<< ; History:
    //<< ; 03-May-2007   GRF     SRBR014346: Direct call to INDRPRUNSort rather than
    //<< ;                           through INDRPRUN; older dates become now
    //<< ; 30-Mar-2007   RPW     SRBR014346: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new dteDate,fltPAB,objWWWSOR,strID,strQuery,strType,tmeTime,tmeUntil,tmsNow
    mVar dteDate = m$.var("dteDate");
    mVar fltPAB = m$.var("fltPAB");
    mVar objWWWSOR = m$.var("objWWWSOR");
    mVar strID = m$.var("strID");
    mVar strQuery = m$.var("strQuery");
    mVar strType = m$.var("strType");
    mVar tmeTime = m$.var("tmeTime");
    mVar tmeUntil = m$.var("tmeUntil");
    mVar tmsNow = m$.var("tmsNow");
    m$.newVar(dteDate,fltPAB,objWWWSOR,strID,strQuery,strType,tmeTime,tmeUntil,tmsNow);
    //<< 
    //<< set tmsNow    = $horolog
    tmsNow.set(m$.Fnc.$horolog());
    //<< set ptmsUntil = $get(ptmsUntil,tmsNow)
    ptmsUntil.set(m$.Fnc.$get(ptmsUntil,tmsNow.get()));
    //<< if (ptmsUntil'="") && (ptmsUntil<tmsNow) {
    if ((mOp.NotEqual(ptmsUntil.get(),"")) && (mOp.Less(ptmsUntil.get(),tmsNow.get()))) {
      //<< set ptmsUntil = tmsNow
      ptmsUntil.set(tmsNow.get());
    }
    //<< }
    //<< set tmeUntil  = +$piece(ptmsUntil,",",2)
    tmeUntil.set(mOp.Positive(m$.Fnc.$piece(ptmsUntil.get(),",",2)));
    //<< 
    //<< if '$data(^INART(0,pidItem,1)) || '$data(^WWW0121(0,0,pidLocation,1)) {
    if (mOp.Not(m$.Fnc.$data(m$.var("^INART",0,pidItem.get(),1))) || mOp.Not(m$.Fnc.$data(m$.var("^WWW0121",0,0,pidLocation.get(),1)))) {
    }
    //<< ztrap "PAB1" // Crash here if the item is not a real item or the location is not a real location
    //<< }
    //<< 
    //<< set fltPAB = $$^INARTMENGE(pidItem,,pidLocation,,2)
    fltPAB.set(m$.fnc$("INARTMENGE.main",pidItem.get(),null,pidLocation.get(),null,2));
    //<< 
    //<< kill ^WWWSOR(YUSER,"0")
    m$.var("^WWWSOR",m$.var("YUSER").get(),"0").kill();
    //<< kill ^WWWSOR(YUSER,"RMA")
    m$.var("^WWWSOR",m$.var("YUSER").get(),"RMA").kill();
    //<< if pidItem'="" {
    if (mOp.NotEqual(pidItem.get(),"")) {
      //<< do Sort^INDRPRUNSort(pidItem,pidLocation)
      m$.Cmd.Do("INDRPRUNSort.Sort",pidItem.get(),pidLocation.get());
    }
    //<< }
    //<< 
    //<< set strQuery="^WWWSOR("_YUSER_",0)"
    strQuery.set(mOp.Concat(mOp.Concat("^WWWSOR(",m$.var("YUSER").get()),",0)"));
    //<< set %3 = $qlength(strQuery)
    m$.var("%3").set(m$.Fnc.$qlength(strQuery));
    //<< set %4 = $name(@strQuery,%3)
    m$.var("%4").set(m$.Fnc.$name(m$.indirectVar(strQuery.get()),m$.var("%3").get()));
    //<< for {
    for (;true;) {
      //<< set strQuery = $query(@strQuery)
      strQuery.set(m$.Fnc.$query(m$.indirectVar(strQuery.get())));
      //<< quit:((strQuery="") || ($name(@strQuery,%3)'=%4))
      if (mOp.Logical(((mOp.Equal(strQuery.get(),"")) || (mOp.NotEqual(m$.Fnc.$name(m$.indirectVar(strQuery.get()),m$.var("%3").get()),m$.var("%4").get()))))) {
        break;
      }
      //<< 
      //<< set dteDate = $qsubscript(strQuery,3)
      dteDate.set(m$.Fnc.$qsubscript(strQuery,3));
      //<< quit:(dteDate>ptmsUntil)||(dteDate="")
      if ((mOp.Greater(dteDate.get(),ptmsUntil.get())) || (mOp.Equal(dteDate.get(),""))) {
        break;
      }
      //<< 
      //<< set tmeTime = $qsubscript(strQuery,4)
      tmeTime.set(m$.Fnc.$qsubscript(strQuery,4));
      //<< continue:tmeTime=""
      if (mOp.Equal(tmeTime.get(),"")) {
        continue;
      }
      //<< quit:((dteDate=+ptmsUntil) && (tmeTime>tmeUntil))
      if (mOp.Logical(((mOp.Equal(dteDate.get(),mOp.Positive(ptmsUntil.get()))) && (mOp.Greater(tmeTime.get(),tmeUntil.get()))))) {
        break;
      }
      //<< 
      //<< set strID = $qsubscript(strQuery,5)
      strID.set(m$.Fnc.$qsubscript(strQuery,5));
      //<< continue:(strID="")
      if ((mOp.Equal(strID.get(),""))) {
        continue;
      }
      //<< 
      //<< set strType   = $piece(strID,"#",2)
      strType.set(m$.Fnc.$piece(strID.get(),"#",2));
      //<< set objWWWSOR = $get(^WWWSOR(YUSER,"0",dteDate,tmeTime,strID))
      objWWWSOR.set(m$.Fnc.$get(m$.var("^WWWSOR",m$.var("YUSER").get(),"0",dteDate.get(),tmeTime.get(),strID.get())));
      //<< 
      //<< if strType=$$$SUPPLY {
      if (mOp.Equal(strType.get(),$$$SUPPLY(m$))) {
        //<< set fltPAB = fltPAB+$piece(objWWWSOR,Y,5)
        fltPAB.set(mOp.Add(fltPAB.get(),m$.Fnc.$piece(objWWWSOR.get(),m$.var("Y").get(),5)));
      }
      //<< 
      //<< } elseif strType=$$$DEMAND {
      else if (mOp.Equal(strType.get(),$$$DEMAND(m$))) {
        //<< set fltPAB = fltPAB-$piece(objWWWSOR,Y,5)
        fltPAB.set(mOp.Subtract(fltPAB.get(),m$.Fnc.$piece(objWWWSOR.get(),m$.var("Y").get(),5)));
      }
      //<< 
      //<< } else {
      else {
      }
    }
    //<< ztrap "PAB2" // Crash if we get here, there is another type.
    //<< }
    //<< }
    //<< 
    //<< kill ^WWWSOR(YUSER,"0")
    m$.var("^WWWSOR",m$.var("YUSER").get(),"0").kill();
    //<< kill ^WWWSOR(YUSER,"RMA")
    m$.var("^WWWSOR",m$.var("YUSER").get(),"RMA").kill();
    //<< quit fltPAB
    return fltPAB.get();
  }

  //<< 
  //<< 
  //<< ValidItem(pidItem)
  public Object ValidItem(Object ... _p) {
    mVar pidItem = m$.newVarRef("pidItem",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Common tag for repeated test
    //<< ;
    //<< ; Returns $$$OK if pidItem contains an item ID that exists in Item Master
    //<< ;
    //<< ; History :
    //<< ; 30-Sep-2008   GRF     SR15810: Remove unnecessary duplicated test; doco
    //<< ; 29-Aug-2008   shobby  SRBR014971: Updated from the SES version.
    //<< ; 21-Dec-2007   PhilJ   Created
    //<< ;-------------------------------------------------------------------------------
    //<< new strStatus
    mVar strStatus = m$.var("strStatus");
    m$.newVar(strStatus);
    //<< 
    //<< set strStatus = $$$OK
    strStatus.set(include.COMSYS.$$$OK(m$));
    //<< 
    //<< if ($get(pidItem)="") || '$data(^INART(0,pidItem,1)) {
    if ((mOp.Equal(m$.Fnc.$get(pidItem),"")) || mOp.Not(m$.Fnc.$data(m$.var("^INART",0,pidItem.get(),1)))) {
      //<< set strStatus = $$$MakeStatus("STK0002",pidItem)
      strStatus.set(include.COMSYS.$$$MakeStatus(m$,"STK0002",pidItem));
    }
    //<< } ; "Item Number ´%1´ does not exist."
    //<< quit strStatus
    return strStatus.get();
  }

  //<< 
  //<< 
  //<< GetItem(pidItem)
  public Object GetItem(Object ... _p) {
    mVar pidItem = m$.newVarRef("pidItem",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Get an Item otherwise a blank string
    //<< ;
    //<< ; Inputs:
    //<< ;   pidItem         Item No
    //<< ;
    //<< ; Returns:
    //<< ;   an item object
    //<< ;
    //<< ; History:
    //<< ; 11-Jan-2008   PJones  Created (currently used in INStocktaking)
    //<< ;-------------------------------------------------------------------------------
    //<< quit $get(^INART(0,pidItem,1))
    return m$.Fnc.$get(m$.var("^INART",0,pidItem.get(),1));
  }

  //<< 
  //<< 
  //<< IsAsset(pobjItem)
  public Object IsAsset(Object ... _p) {
    mVar pobjItem = m$.newVarRef("pobjItem",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Is an item an asset?
    //<< ; History:
    //<< ; 30-Sep-2008   GRF     SR15810: Correct variable name
    //<< ; 24-Feb-2008   PJones
    //<< ;-------------------------------------------------------------------------------
    //<< new blnResult
    mVar blnResult = m$.var("blnResult");
    m$.newVar(blnResult);
    //<< 
    //<< set blnResult = $$$YES
    blnResult.set(include.COMSYS.$$$YES(m$));
    //<< if '$$$INARTItemWithoutInventoryMaint(pobjItem) set blnResult = $$$NO
    if (mOp.Not(include.INConst.$$$INARTItemWithoutInventoryMaint(m$,pobjItem))) {
      blnResult.set(include.COMSYS.$$$NO(m$));
    }
    //<< quit blnResult
    return blnResult.get();
  }

  //<< 
  //<< 
  //<< IsAssetItemId(pidItem)
  public Object IsAssetItemId(Object ... _p) {
    mVar pidItem = m$.newVarRef("pidItem",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Is an item an asset? Query by pidItem
    //<< ; History:
    //<< ; 24-Feb-2008   PJones
    //<< ;-------------------------------------------------------------------------------
    //<< new obj
    mVar obj = m$.var("obj");
    m$.newVar(obj);
    //<< 
    //<< set obj = $$GetItem(pidItem)
    obj.set(m$.fnc$("GetItem",pidItem.get()));
    //<< quit $$IsAsset(obj)
    return m$.fnc$("IsAsset",obj.get());
  }

  //<< 
  //<< 
  //<< GetGroup(pidItem)
  public Object GetGroup(Object ... _p) {
    mVar pidItem = m$.newVarRef("pidItem",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; get the group number
    //<< ; History:
    //<< ; 03-Oct-2008   GRF     SR15810: Get default if group is blank
    //<< ; 22-Feb-2008   PJones
    //<< ;-------------------------------------------------------------------------------
    //<< new idGroup,objItem
    mVar idGroup = m$.var("idGroup");
    mVar objItem = m$.var("objItem");
    m$.newVar(idGroup,objItem);
    //<< 
    //<< set objItem = $get(^INART(0,pidItem,1))
    objItem.set(m$.Fnc.$get(m$.var("^INART",0,pidItem.get(),1)));
    //<< set idGroup = $$$INARTItemGroup(objItem)
    idGroup.set(include.INConst.$$$INARTItemGroup(m$,objItem));
    //<< set:idGroup="" idGroup = $$$INVORGDefaultItemGroup($get(^INVORG(0,0,1)))
    if (mOp.Equal(idGroup.get(),"")) {
      idGroup.set(include.INConst.$$$INVORGDefaultItemGroup(m$,m$.Fnc.$get(m$.var("^INVORG",0,0,1))));
    }
    //<< quit idGroup
    return idGroup.get();
  }

  //<< 
  //<< 
  //<< GetUnitOfMeasure(pidItem)
  public Object GetUnitOfMeasure(Object ... _p) {
    mVar pidItem = m$.newVarRef("pidItem",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< quit $$$INARTUnitofMeasure($$GetItem(pidItem))
    return include.INConst.$$$INARTUnitofMeasure(m$,m$.fnc$("GetItem",pidItem.get()));
  }

  //<< 
  //<< 
  //<< SQLGetDescUnitOfMeasure(pidItem)
  public Object SQLGetDescUnitOfMeasure(Object ... _p) {
    mVar pidItem = m$.newVarRef("pidItem",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< do ^WWWVAR
    m$.Cmd.Do("WWWVAR.main");
    //<< if ($get(pidItem) '= "") {
    if ((mOp.NotEqual(m$.Fnc.$get(pidItem),""))) {
      //<< quit $$$WWW101Text($$Get^WWW101("EINHEIT","PT",$$GetUnitOfMeasure(pidItem)))   ; FIXME : "PT"???
      return include.WWWConst.$$$WWW101Text(m$,m$.fnc$("WWW101.Get","EINHEIT","PT",m$.fnc$("GetUnitOfMeasure",pidItem.get())));
    }
    //<< }
    //<< quit ""
    return "";
  }

  //<< 
  //<< 
  //<< ;SR18093 IsInUse(pidItem)
  //<< ;SR18093 ;-------------------------------------------------------------------------------
  //<< ;SR18093 ; Returns a boolean indicating whether or not this item is currently in use
  //<< ;SR18093 ; within the system
  //<< ;SR18093 ;
  //<< ;SR18093 ; Inputs:
  //<< ;SR18093 ;  pidItem         Item No
  //<< ;SR18093 ;
  //<< ;SR18093 ; History
  //<< ;SR18093 ; 18-Apr-2008  HQN     SR15675: Created
  //<< ;SR18093 ;-------------------------------------------------------------------------------
  //<< ;SR18093 new blnIsInUse,objResultSet
  //<< 
  //<< ;SR18093 set blnIsInUse = $$$NO
  //<< 
  //<< ;SR18093 set objResultSet = ##class(%Library.ResultSet).%New("alSOH.dStockBalance:GetViaItem")
  //<< ;SR18093 if objResultSet.Execute(pidItem) {
  //<< ;SR18093    if objResultSet.Next() {
  //<< ;SR18093        set blnIsInUse = $$$YES
  //<< ;SR18093    }
  //<< ;SR18093 }
  //<< ;SR18093 quit blnIsInUse
  //<< 
  //<< 
  //<< IsInUse(pidItem)
  public Object IsInUse(Object ... _p) {
    mVar pidItem = m$.newVarRef("pidItem",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Returns a boolean indicating whether or not this item is currently in use
    //<< ; within the system
    //<< ;
    //<< ; Inputs:
    //<< ; pidItem   Item No
    //<< ;
    //<< ; History
    //<< ; 26-Fev-2012 RGB  SR18093: Correction, routine is not checking for stock quantity
    //<< ; 18-Apr-2008 HQN  SR15675: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new blnIsInUse,objResultSet,mySQL
    mVar blnIsInUse = m$.var("blnIsInUse");
    mVar objResultSet = m$.var("objResultSet");
    mVar mySQL = m$.var("mySQL");
    m$.newVar(blnIsInUse,objResultSet,mySQL);
    //<< 
    //<< set blnIsInUse = $$$NO
    blnIsInUse.set(include.COMSYS.$$$NO(m$));
    //<< if pidItem="" quit blnIsInUse
    if (mOp.Equal(pidItem.get(),"")) {
      return blnIsInUse.get();
    }
    //<< 
    //<< set objResultSet = ##class(%ResultSet).%New()  ;Create Result Set Object
    if (!mOp.Equal(pidItem.get(),"")) {//TODO REVISAR REMOVER ESSE IF
    //TODO REVISAR VERIFICAR SE É A MESMA CLASSA DE $LIBRARY objResultSet.set(m$.fnc$("$ResultSet.$New"));    
    return blnIsInUse.get();
  }
    //<< 
    //<< set mySQL = "SELECT %ID FROM alSOH.dStockBalance "_
    //<< "WHERE Item = '"_pidItem_"' "_
    //<< "AND QtyOnHand>0 "
    mySQL.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("SELECT %ID FROM alSOH.dStockBalance ","WHERE Item = '"),pidItem.get()),"' "),"AND QtyOnHand>0 "));
    //<< 
    //<< do objResultSet.Prepare(mySQL)  ;Prepare Query
    m$.Cmd.Do(objResultSet.getORef(),"Prepare",mySQL.get());
    //<< do objResultSet.Execute()  ;Execute Query
    m$.Cmd.Do(objResultSet.getORef(),"Execute");
    //<< if objResultSet.Next() {
    if (mOp.Logical(m$.fnc$(objResultSet.getORef(),"Next"))) {
      //<< set blnIsInUse = $$$YES
      blnIsInUse.set(include.COMSYS.$$$YES(m$));
    }
    //<< }
    //<< 
    //<< do objResultSet.Close()
    m$.Cmd.Do(objResultSet.getORef(),"Close");
    //<< 
    //<< quit blnIsInUse
    return blnIsInUse.get();
  }

  //<< 
  //<< 
  //<< OnAfterSaveHook(pidItem,pobjItem)
  public Object OnAfterSaveHook(Object ... _p) {
    mVar pidItem = m$.newVarRef("pidItem",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pobjItem = m$.newVarRef("pobjItem",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; If INART record is changed *assume* Policy has been altered - simply means
    //<< ; ^CacheTempPolicy entry will be recreated when next used.
    //<< ;
    //<< ; See also : CheckPolicy^INRECPDA2
    //<< ;
    //<< ; History:
    //<< ; 11-Jan-2010   GRF     SR17104: Created
    //<< ;-------------------------------------------------------------------------------
    //<< lock +^CacheTempPolicy(YUCI,pidItem):2
    m$.Cmd.LockInc(m$.var("^CacheTempPolicy",m$.var("YUCI").get(),pidItem.get()),2);
    //<< kill ^CacheTempPolicy(YUCI,pidItem)
    m$.var("^CacheTempPolicy",m$.var("YUCI").get(),pidItem.get()).kill();
    //<< lock -^CacheTempPolicy(YUCI,pidItem)
    m$.Cmd.Unlock(m$.var("^CacheTempPolicy",m$.var("YUCI").get(),pidItem.get()));
    //<< quit $$$YES
    return include.COMSYS.$$$YES(m$);
  }

  //<< 
  //<< 
  //<< OnBeforeSaveHook(pYKEY,pYFELD)
  public Object OnBeforeSaveHook(Object ... _p) {
    mVar pYKEY = m$.newVarRef("pYKEY",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pYFELD = m$.newVarRef("pYFELD",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Ensures there is a valid entry for the UnitOfMeasure entry within INARTPACK
    //<< ; Updates corresponding record for Base/Inventory INARTPACK
    //<< ;
    //<< ; History:
    //<< ; 15-Feb-2010   shobby  SRAdhoc: Check that loop contains a value.
    //<< ; 13-Jan-2010   shobby  SR17119: Restructured updates to INARTPACK to take into
    //<< ;                           account that base unit and Inventory Unit are no
    //<< ;                           longer stored.
    //<< ; 06-Jan-2010   shobby  SR17097: Renamed from OnAfterSaveHook
    //<< ; 13-Feb-2009   GRF     SR16347: Language Text
    //<< ; 12-Feb-2009   HQN     SR16347: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new loop,objINARTPACK,strStatus
    mVar loop = m$.var("loop");
    mVar objINARTPACK = m$.var("objINARTPACK");
    mVar strStatus = m$.var("strStatus");
    m$.newVar(loop,objINARTPACK,strStatus);
    //<< 
    //<< ; Base UoM can only be selected from existing INARTPACK records (initially
    //<< ; automatically matched to Inventory UoM)
    //<< ; If Inventory UoM is changed to something not in INARTPACK, a new
    //<< ; INARTPACK record is created with the unit = 1 of itself.
    //<< ; This will then need to be correctly expressed in terms of the Base UoM
    //<< 
    //<< set strStatus = $$$OK
    strStatus.set(include.COMSYS.$$$OK(m$));
    //<< for loop = $$$INARTBaseUnit(pYFELD),$$$INARTUnitofMeasure(pYFELD) {
    for (Object _loop: new Object[] {include.INConst.$$$INARTBaseUnit(m$,pYFELD),include.INConst.$$$INARTUnitofMeasure(m$,pYFELD)}) {
    loop.set(_loop);
      //<< quit:$$$ISERR(strStatus)
      if (mOp.Logical(include.COMSYS.$$$ISERR(m$,strStatus))) {
        break;
      }
      //<< 
      //<< if loop'="" {
      if (mOp.NotEqual(_loop,"")) {
        //<< if '$data(^INARTPACK(0,pYKEY,loop)) {
        if (mOp.Not(m$.Fnc.$data(m$.var("^INARTPACK",0,pYKEY.get(),_loop)))) {
          //<< quit:$$$ISERR(strStatus)
          if (mOp.Logical(include.COMSYS.$$$ISERR(m$,strStatus))) {
            break;
          }
          //<< 
          //<< set objINARTPACK = ""
          objINARTPACK.set("");
          //<< set $$$INARTPACKQuantity(objINARTPACK) = 1
          include.INConst.$$$INARTPACKQuantitySet(m$,objINARTPACK,1);
          //<< set $$$INARTPACKUnit(objINARTPACK)     = loop
          include.INConst.$$$INARTPACKUnitSet(m$,objINARTPACK,_loop);
          //<< set strStatus = $$$Save("INARTPACK",pYKEY_$$$COMMA_loop,objINARTPACK,$$$YES)
          strStatus.set(include.COMSYS.$$$Save(m$,"INARTPACK",mOp.Concat(mOp.Concat(pYKEY.get(),include.COMSYSString.$$$COMMA(m$)),_loop),objINARTPACK,include.COMSYS.$$$YES(m$)));
        }
      }
    }
    //<< }
    //<< }
    //<< }
    //<< quit strStatus
    return strStatus.get();
  }

  //<< 
  //<< 
  //<< GetPackUOM(pidItem="")
  public Object GetPackUOM(Object ... _p) {
    mVar pidItem = m$.newVarRef("pidItem",(((_p!=null)&&(_p.length>=1))?_p[0]:null),"");
    //<< ;-------------------------------------------------------------------------------
    //<< ; Get the Pack UOM for this item.
    //<< ;
    //<< ; Inputs:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 25-Aug-2009   PPP     SR16842: If no Pack Unit defined, Inv Unit is PackUnit
    //<< ; 25-Aug-2009   shobby  SR16511: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new idUOM,objItem
    mVar idUOM = m$.var("idUOM");
    mVar objItem = m$.var("objItem");
    m$.newVar(idUOM,objItem);
    //<< 
    //<< set idUOM = ""
    idUOM.set("");
    //<< if '$$$NoKey(pidItem) {
    if (mOp.Not(include.COMSYS.$$$NoKey(m$,pidItem))) {
      //<< set idUOM = $order(^INARTPACKs(0,6,1,pidItem,""))
      idUOM.set(m$.Fnc.$order(m$.var("^INARTPACKs",0,6,1,pidItem.get(),"")));
      //<< if idUOM="" {
      if (mOp.Equal(idUOM.get(),"")) {
        //<< set objItem = $get(^INART(0,pidItem,1))
        objItem.set(m$.Fnc.$get(m$.var("^INART",0,pidItem.get(),1)));
        //<< set idUOM   = $$$INARTUnitofMeasure(objItem)
        idUOM.set(include.INConst.$$$INARTUnitofMeasure(m$,objItem));
      }
    }
    //<< }
    //<< }
    //<< quit idUOM
    return idUOM.get();
  }

  //<< 
  //<< MultidoseInjectable(pidItem="")
  public Object MultidoseInjectable(Object ... _p) {
    mVar pidItem = m$.newVarRef("pidItem",(((_p!=null)&&(_p.length>=1))?_p[0]:null),"");
    //<< ;-------------------------------------------------------------------------------
    //<< ;
    //<< ; Inputs:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 10-Dec-2012   shobby  HEVA-700: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new blnResult
    mVar blnResult = m$.var("blnResult");
    m$.newVar(blnResult);
    //<< 
    //<< set blnResult=$$$NO
    blnResult.set(include.COMSYS.$$$NO(m$));
    //<< if '$$$NoKey(pidItem) {
    if (mOp.Not(include.COMSYS.$$$NoKey(m$,pidItem))) {
      //<< set blnResult=$$$INARTMultidoseInjectable($get(^INART(0,pidItem,1)))
      blnResult.set(include.INConst.$$$INARTMultidoseInjectable(m$,m$.Fnc.$get(m$.var("^INART",0,pidItem.get(),1))));
    }
    //<< }
    //<< quit +blnResult
    return mOp.Positive(blnResult.get());
  }

//<< 
}
