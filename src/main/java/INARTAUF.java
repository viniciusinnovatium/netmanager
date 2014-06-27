//*****************************************************************************
//** TASC - ALPHALINC - MAC INARTAUF
//** Innovatium Systems - Code Converter - v1.30
//** 2014-06-26 20:37:36
//*****************************************************************************

import mLibrary.*;


//<< INARTAUF(ART)
public class INARTAUF extends mClass {

  public Object main(Object ... _p) {
    mVar ART = m$.newVarRef("ART",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return _INARTAUF(ART);
  }

  public Object _INARTAUF(Object ... _p) {
    mVar ART = m$.newVarRef("ART",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Description of Function :
    //<< ;       ERRECHNEN AUFTRAGSMENGE EINES ARTIKELS (CALCULATE ORDER QUANTITY OF AN ARTICLE)
    //<< ;
    //<< ; Inputs :
    //<< ;   ART     Item ID
    //<< ;
    //<< ; ByRef :
    //<< ;
    //<< ; Returns :
    //<< ;
    //<< ; History :
    //<< ; 04.07.2000    DT
    //<< ;-------------------------------------------------------------------------------
    //<< NEW AUF,POK,POS,AUFTRAG,AUFTRAG1,EIGEN,LIEFER,MERK
    mVar AUF = m$.var("AUF");
    mVar POK = m$.var("POK");
    mVar POS = m$.var("POS");
    mVar AUFTRAG = m$.var("AUFTRAG");
    mVar AUFTRAG1 = m$.var("AUFTRAG1");
    mVar EIGEN = m$.var("EIGEN");
    mVar LIEFER = m$.var("LIEFER");
    mVar MERK = m$.var("MERK");
    m$.newVar(AUF,POK,POS,AUFTRAG,AUFTRAG1,EIGEN,LIEFER,MERK);
    //<< 
    //<< SET ART = $GET(ART)
    ART.set(m$.Fnc.$get(ART));
    //<< IF ART="" QUIT "0/0/0"   ;KEIN AUFTRAG  ;TYBD 6.2.03 ;no mandate
    if (mOp.Equal(ART.get(),"")) {
      return "0/0/0";
    }
    //<< 
    //<< ;---------------------------------------
    //<< ; AUFTRAG1      objOrder
    //<< ;---------------------------------------
    //<< 
    //<< SET AUFTRAG = 0  ;KUNDENAUFTRÄGE
    AUFTRAG.set(0);
    //<< SET EIGEN   = 0  ;EIGENAUFTRÄGE
    EIGEN.set(0);
    //<< SET LIEFER  = 0  ;LIEFERANTENAUFTRÄGE
    LIEFER.set(0);
    //<< 
    //<< SET AUF = ""  ;SUCHEN AUFTRAGSBESTAND ;seek volume of orders
    AUF.set("");
    //<< SET ART=$$^WWWUMLAU(ART,1)
    ART.set(m$.fnc$("WWWUMLAU.main",ART.get(),1));
    //<< IF '$DATA(^INAUFPs(YM,5," ",ART)) IF '$DATA(^INAUFPs(YM,5,0,ART)) QUIT "0/0/0"   ;KEIN AUFTRAG ;no mandate
    if (mOp.Not(m$.Fnc.$data(m$.var("^INAUFPs",m$.var("YM").get(),5," ",ART.get())))) {
      if (mOp.Not(m$.Fnc.$data(m$.var("^INAUFPs",m$.var("YM").get(),5,0,ART.get())))) {
        return "0/0/0";
      }
    }
    //<< SET MERK=""
    MERK.set("");
    do {
      //<< DO   ;OFFENER AUFTRAG ;mandate
      //<< . IF ART'="" FOR POK=" ",0 DO  ;NUR OFFENE POSITIONEN ;only
      if (mOp.NotEqual(ART.get(),"")) {
        for (Object _POK: new Object[] {" ",0}) {
          POK.set(_POK);
          //<< . . SET AUF=""
          AUF.set("");
          //<< . . FOR  SET AUF=$ORDER(^INAUFPs(YM,5,POK,ART,AUF)) QUIT:AUF=""  DO
          for (;true;) {
            AUF.set(m$.Fnc.$order(m$.var("^INAUFPs",m$.var("YM").get(),5,_POK,ART.get(),AUF.get())));
            if (mOp.Equal(AUF.get(),"")) {
              break;
            }
            do {
              //<< . . . QUIT:$DATA(MERK(AUF))  ;BEREITS GEZÄHLT ;yet
              if (mOp.Logical(m$.Fnc.$data(MERK.var(AUF.get())))) {
                break;
              }
              //<< . . . IF '$DATA(^INAUF1(YM,AUF)) QUIT  ;AUFTRAG GESCHLOSSEN ;mandate thick
              if (mOp.Not(m$.Fnc.$data(m$.var("^INAUF1",m$.var("YM").get(),AUF.get())))) {
                break;
              }
              //<< . . . SET POS=""
              POS.set("");
              //<< . . . FOR  SET POS=$ORDER(^INAUFPs(YM,5,POK,ART,AUF,POS)) QUIT:POS=""  DO  QUIT:$DATA(MERK(AUF))  ;POSITIONENS SUCHE ;search
              for (;true;) {
                POS.set(m$.Fnc.$order(m$.var("^INAUFPs",m$.var("YM").get(),5,_POK,ART.get(),AUF.get(),POS.get())));
                if (mOp.Equal(POS.get(),"")) {
                  break;
                }
                do {
                  //<< . . . . SET AUFTRAG1=$GET(^INAUF(YM,AUF,1))
                  AUFTRAG1.set(m$.Fnc.$get(m$.var("^INAUF",m$.var("YM").get(),AUF.get(),1)));
                  //<< . . . . ;
                  //<< . . . . ; Customer Order
                  //<< . . . . ;
                  //<< . . . . IF +$PIECE(AUFTRAG1,Y,2)=0 DO  QUIT
                  if (mOp.Equal(mOp.Positive(m$.Fnc.$piece(AUFTRAG1.get(),m$.var("Y").get(),2)),0)) {
                    do {
                      //<< . . . . . QUIT:$PIECE($GET(^INAUFP(YM,AUF,POS,1)),Y,60)=1  ;ERLEDIGT   ; Line Completed
                      if (mOp.Equal(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^INAUFP",m$.var("YM").get(),AUF.get(),POS.get(),1)),m$.var("Y").get(),60),1)) {
                        break;
                      }
                      //<< . . . . . ;SET AUFTRAG=AUFTRAG+$PIECE($GET(^INAUFP(YM,AUF,POS,1)),Y,5) QUIT   ;AUFTRAGS MENGE KUNDEN
                      //<< . . . . . SET AUFTRAG=AUFTRAG+1        ;AUFTRAGE KUNDEN
                      AUFTRAG.set(mOp.Add(AUFTRAG.get(),1));
                      //<< . . . . . SET MERK(AUF)=""             ;ULM,03.03.03 MERKER, DAMIT AUFTRÄGE NICHT DOPPELT GEZÄHLT WERDEN  /FIS,6.3.03
                      MERK.var(AUF.get()).set("");
                    } while (false);
                    break;
                  }
                  //<< . . . . ;
                  //<< . . . . ; Manufacturing Order
                  //<< . . . . ;
                  //<< . . . . IF +$PIECE(AUFTRAG1,Y,2)=1 DO  QUIT
                  if (mOp.Equal(mOp.Positive(m$.Fnc.$piece(AUFTRAG1.get(),m$.var("Y").get(),2)),1)) {
                    do {
                      //<< . . . . . QUIT:$ORDER(^INWEAUFALT(YM,AUF,POS,""))'=""  ;WE VORHANDEN ;In on hand
                      if (mOp.NotEqual(m$.Fnc.$order(m$.var("^INWEAUFALT",m$.var("YM").get(),AUF.get(),POS.get(),"")),"")) {
                        break;
                      }
                      //<< . . . . . QUIT:$ORDER(^INWEAUF(YM,AUF,POS,""))'=""  ;WE VORHANDEN ;In on hand
                      if (mOp.NotEqual(m$.Fnc.$order(m$.var("^INWEAUF",m$.var("YM").get(),AUF.get(),POS.get(),"")),"")) {
                        break;
                      }
                      //<< . . . . . QUIT:$PIECE($GET(^INAUFP(YM,AUF,POS,1)),Y,60)=1  ;ERLEDIGT
                      if (mOp.Equal(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^INAUFP",m$.var("YM").get(),AUF.get(),POS.get(),1)),m$.var("Y").get(),60),1)) {
                        break;
                      }
                      //<< . . . . . ;SET EIGEN=EIGEN+$PIECE($GET(^INAUFP(YM,AUF,POS,1)),Y,5) QUIT   ;AUFTRAGS MENGE KUNDEN
                      //<< . . . . . SET EIGEN=EIGEN+1        ;AUFTRAGS MENGE KUNDEN  ;quantum
                      EIGEN.set(mOp.Add(EIGEN.get(),1));
                      //<< . . . . . SET MERK(AUF)=""         ;ULM,03.03.03 MERKER, DAMIT AUFTRÄGE NICHT DOPPELT GEZÄHLT WERDEN  /FIS,6.3.03
                      MERK.var(AUF.get()).set("");
                    } while (false);
                    break;
                  }
                  //<< . . . . ;
                  //<< . . . . ; Purchase Order
                  //<< . . . . ;
                  //<< . . . . IF +$PIECE(AUFTRAG1,Y,2)=2 DO  QUIT
                  if (mOp.Equal(mOp.Positive(m$.Fnc.$piece(AUFTRAG1.get(),m$.var("Y").get(),2)),2)) {
                    do {
                      //<< . . . . . ;QUIT:$ORDER(^INWEAUF(YM,AUF,POS,""))'=""  ;WE VORHANDEN
                      //<< . . . . . QUIT:$PIECE($GET(^INAUFP(YM,AUF,POS,1)),Y,60)=1  ;ERLEDIGT
                      if (mOp.Equal(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^INAUFP",m$.var("YM").get(),AUF.get(),POS.get(),1)),m$.var("Y").get(),60),1)) {
                        break;
                      }
                      //<< . . . . . ;SET LIEFER=LIEFER+$PIECE($GET(^INAUFP(YM,AUF,POS,1)),Y,5) QUIT   ;AUFTRAGS MENGE KUNDEN
                      //<< . . . . . SET LIEFER=LIEFER+1        ;AUFTRAGS MENGE KUNDEN ;quantum
                      LIEFER.set(mOp.Add(LIEFER.get(),1));
                      //<< . . . . . SET MERK(AUF)=""           ;ULM,03.03.03 MERKER, DAMIT AUFTRÄGE NICHT DOPPELT GEZÄHLT WERDEN  /FIS,6.3.03
                      MERK.var(AUF.get()).set("");
                    } while (false);
                    break;
                  }
                } while (false);
                if (mOp.Logical(m$.Fnc.$data(MERK.var(AUF.get())))) {
                  break;
                }
              }
            } while (false);
          }
        }
      }
    } while(false);
    //<< 
    //<< QUIT AUFTRAG_"/"_EIGEN_"/"_LIEFER
    return mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(AUFTRAG.get(),"/"),EIGEN.get()),"/"),LIEFER.get());
    //<< 
    //<< ; vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv DISABLED BLOCK START
    //<< 
    /*
    //<< SET AUF=""
    AUF.set("");
    //<< FOR  SET AUF=$ORDER(^INAUF1(YM,AUF)) QUIT:AUF=""  DO   ;OFFENER AUFTRAG ;mandate
    for (;true;) {
      AUF.set(m$.Fnc.$order(m$.var("^INAUF1",m$.var("YM").get(),AUF.get())));
      if (mOp.Equal(AUF.get(),"")) {
        break;
      }
      //<< . IF ART'="" FOR POK=" ",0 DO
      if (mOp.NotEqual(ART.get(),"")) {
        for (Object _POK: new Object[] {" ",0}) {
          POK.set(_POK);
          //<< . . SET POS=""
          POS.set("");
          //<< . . FOR  SET POS=$ORDER(^INAUFPs(YM,5,$$^WWWUMLAU(POK,1),$$^WWWUMLAU(ART,1),$$^WWWUMLAU(AUF,1),POS)) QUIT:POS=""  DO   ;POSITIONENS SUCHE ;search
          for (;true;) {
            POS.set(m$.Fnc.$order(m$.var("^INAUFPs",m$.var("YM").get(),5,m$.fnc$("WWWUMLAU.main",_POK,1),m$.fnc$("WWWUMLAU.main",ART.get(),1),m$.fnc$("WWWUMLAU.main",AUF.get(),1),POS.get())));
            if (mOp.Equal(POS.get(),"")) {
              break;
            }
            do {
              //<< . . . SET AUFTRAG1=$GET(^INAUF(YM,AUF,1))
              AUFTRAG1.set(m$.Fnc.$get(m$.var("^INAUF",m$.var("YM").get(),AUF.get(),1)));
              //<< . . . IF +$PIECE(AUFTRAG1,Y,2)=0 DO  QUIT
              if (mOp.Equal(mOp.Positive(m$.Fnc.$piece(AUFTRAG1.get(),m$.var("Y").get(),2)),0)) {
                do {
                  //<< . . . . QUIT:$PIECE($GET(^INAUFP(YM,AUF,POS,1)),Y,60)=1  ;ERLEDIGT
                  if (mOp.Equal(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^INAUFP",m$.var("YM").get(),AUF.get(),POS.get(),1)),m$.var("Y").get(),60),1)) {
                    break;
                  }
                  //<< . . . . ;SET AUFTRAG=AUFTRAG+$PIECE($GET(^INAUFP(YM,AUF,POS,1)),Y,5) QUIT   ;AUFTRAGS MENGE KUNDEN
                  //<< . . . . SET AUFTRAG=AUFTRAG+1 QUIT   ;AUFTRAGE KUNDEN
                  AUFTRAG.set(mOp.Add(AUFTRAG.get(),1));
                  break;
                } while (false);
                break;
              }
              //<< . . . ;
              //<< . . . IF +$PIECE(AUFTRAG1,Y,2)=1 DO  QUIT
              if (mOp.Equal(mOp.Positive(m$.Fnc.$piece(AUFTRAG1.get(),m$.var("Y").get(),2)),1)) {
                do {
                  //<< . . . . QUIT:$ORDER(^INWEAUFALT(YM,AUF,POS,""))'=""  ;WE VORHANDEN ;In on hand
                  if (mOp.NotEqual(m$.Fnc.$order(m$.var("^INWEAUFALT",m$.var("YM").get(),AUF.get(),POS.get(),"")),"")) {
                    break;
                  }
                  //<< . . . . QUIT:$ORDER(^INWEAUF(YM,AUF,POS,""))'=""  ;WE VORHANDEN ;In on hand
                  if (mOp.NotEqual(m$.Fnc.$order(m$.var("^INWEAUF",m$.var("YM").get(),AUF.get(),POS.get(),"")),"")) {
                    break;
                  }
                  //<< . . . . QUIT:$PIECE($GET(^INAUFP(YM,AUF,POS,1)),Y,60)=1  ;ERLEDIGT
                  if (mOp.Equal(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^INAUFP",m$.var("YM").get(),AUF.get(),POS.get(),1)),m$.var("Y").get(),60),1)) {
                    break;
                  }
                  //<< . . . . ;SET EIGEN=EIGEN+$PIECE($GET(^INAUFP(YM,AUF,POS,1)),Y,5) QUIT   ;AUFTRAGS MENGE KUNDEN
                  //<< . . . . SET EIGEN=EIGEN+1 QUIT   ;AUFTRAGS MENGE KUNDEN  ;quantum
                  EIGEN.set(mOp.Add(EIGEN.get(),1));
                  break;
                } while (false);
                break;
              }
              //<< . . . ;
              //<< . . . IF +$PIECE(AUFTRAG1,Y,2)=2 DO  QUIT
              if (mOp.Equal(mOp.Positive(m$.Fnc.$piece(AUFTRAG1.get(),m$.var("Y").get(),2)),2)) {
                do {
                  //<< . . . . ;QUIT:$ORDER(^INWEAUF(YM,AUF,POS,""))'=""  ;WE VORHANDEN
                  //<< . . . . QUIT:$PIECE($GET(^INAUFP(YM,AUF,POS,1)),Y,60)=1  ;ERLEDIGT
                  if (mOp.Equal(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^INAUFP",m$.var("YM").get(),AUF.get(),POS.get(),1)),m$.var("Y").get(),60),1)) {
                    break;
                  }
                  //<< . . . . ;SET LIEFER=LIEFER+$PIECE($GET(^INAUFP(YM,AUF,POS,1)),Y,5) QUIT   ;AUFTRAGS MENGE KUNDEN
                  //<< . . . . SET LIEFER=LIEFER+1 QUIT   ;AUFTRAGS MENGE KUNDEN ;quantum
                  LIEFER.set(mOp.Add(LIEFER.get(),1));
                  break;
                } while (false);
                break;
              }
            } while (false);
          }
        }
      }
    }
    //<< 
    //<< QUIT AUFTRAG_"/"_EIGEN_"/"_LIEFER
    return mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(AUFTRAG.get(),"/"),EIGEN.get()),"/"),LIEFER.get());
    */
  }

//<< 
}
