//*****************************************************************************
//** TASC - ALPHALINC - MAC INARTANG
//** Innovatium Systems - Code Converter - v1.30
//** 2014-06-26 20:39:40
//*****************************************************************************

import mLibrary.*;


//<< INARTANG(ART) ;INARTANG;FAN;ERRECHNEN ANGEBOTSMENGE EINES ARTIKELS;22.07.2002
public class INARTANG extends mClass {

  public Object main(Object ... _p) {
    mVar ART = m$.newVarRef("ART",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return _INARTANG(ART);
  }

  public Object _INARTANG(Object ... _p) {
    mVar ART = m$.newVarRef("ART",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;
    //<< ;/------------------------------------------------------------------\
    //<< ;| Description of Function :
    //<< ;|      ERRECHNEN ANGEBOTSMENGE EINES ARTIKELS
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
    //<< ;| FAN  22.07.2002
    //<< ;|
    //<< ;\------------------------------------------------------------------/
    //<< ;
    //<< NEW ANG,POK,POS,ANFRAGE,ANGEBOT,ANGEBOT1
    mVar ANG = m$.var("ANG");
    mVar POK = m$.var("POK");
    mVar POS = m$.var("POS");
    mVar ANFRAGE = m$.var("ANFRAGE");
    mVar ANGEBOT = m$.var("ANGEBOT");
    mVar ANGEBOT1 = m$.var("ANGEBOT1");
    m$.newVar(ANG,POK,POS,ANFRAGE,ANGEBOT,ANGEBOT1);
    //<< SET ART=$GET(ART)
    ART.set(m$.Fnc.$get(ART));
    //<< SET ANFRAGE=0  ;ANFRAGE
    ANFRAGE.set(0);
    //<< SET ANGEBOT=0  ;ANGEBOT ;proposition
    ANGEBOT.set(0);
    //<< SET PK=0       ;PREISKAKULATION
    mVar PK = m$.var("PK");
    PK.set(0);
    //<< IF ART="" QUIT "0/0/0"   ;KEIN AUFTRAG  ;TYBD 6.2.03 ;no mandate
    if (mOp.Equal(ART.get(),"")) {
      return "0/0/0";
    }
    //<< SET ART=$$^WWWUMLAU(ART,1)
    ART.set(m$.fnc$("WWWUMLAU.main",ART.get(),1));
    //<< IF '$DATA(^INANGPs(YM,5," ",ART)) IF '$DATA(^INANGPs(YM,5,0,ART)) QUIT "0/0/0"   ;KEIN ANGEBOT ;no proposition
    if (mOp.Not(m$.Fnc.$data(m$.var("^INANGPs",m$.var("YM").get(),5," ",ART.get())))) {
      if (mOp.Not(m$.Fnc.$data(m$.var("^INANGPs",m$.var("YM").get(),5,0,ART.get())))) {
        return "0/0/0";
      }
    }
    do {
      //<< DO   ;OFFENER ANGEBOTE
      //<< . IF ART'="" FOR POK=" " DO
      if (mOp.NotEqual(ART.get(),"")) {
        for (POK.set(null);(mOp.NotEqual(POK," "));) { POK.set(" ");
          do {
            //<< . . SET ANG="" FOR  SET ANG=$ORDER(^INANGPs(YM,5,POK,ART,ANG)) QUIT:ANG=""  IF $DATA(^INANG1(YM,ANG)) SET POS="" FOR  SET POS=$ORDER(^INANGPs(YM,5,POK,ART,ANG,POS)) QUIT:POS=""  DO   ;POSITIONENS SUCHE ;search
            ANG.set("");
            for (;true;) {
              ANG.set(m$.Fnc.$order(m$.var("^INANGPs",m$.var("YM").get(),5,POK.get(),ART.get(),ANG.get())));
              if (mOp.Equal(ANG.get(),"")) {
                break;
              }
              if (mOp.Logical(m$.Fnc.$data(m$.var("^INANG1",m$.var("YM").get(),ANG.get())))) {
                POS.set("");
                for (;true;) {
                  POS.set(m$.Fnc.$order(m$.var("^INANGPs",m$.var("YM").get(),5,POK.get(),ART.get(),ANG.get(),POS.get())));
                  if (mOp.Equal(POS.get(),"")) {
                    break;
                  }
                  do {
                    //<< . . . SET ANGEBOT1=$GET(^INANG(YM,ANG,1))
                    ANGEBOT1.set(m$.Fnc.$get(m$.var("^INANG",m$.var("YM").get(),ANG.get(),1)));
                    //<< . . . IF +$PIECE(ANGEBOT1,Y,2)=0 DO  QUIT  ;ANGEBOT ;proposition
                    if (mOp.Equal(mOp.Positive(m$.Fnc.$piece(ANGEBOT1.get(),m$.var("Y").get(),2)),0)) {
                      do {
                        //<< . . . . QUIT:$PIECE($GET(^INANGP(YM,ANG,POS,1)),Y,60)=1  ;ERLEDIGT
                        if (mOp.Equal(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^INANGP",m$.var("YM").get(),ANG.get(),POS.get(),1)),m$.var("Y").get(),60),1)) {
                          break;
                        }
                        //<< . . . . ;SET AUFTRAG=AUFTRAG+$PIECE($GET(^INAUFP(YM,AUF,POS,1)),Y,5) QUIT   ;AUFTRAGS MENGE KUNDEN
                        //<< . . . . SET ANGEBOT=ANGEBOT+1 QUIT   ;AUFTRAGE KUNDEN
                        ANGEBOT.set(mOp.Add(ANGEBOT.get(),1));
                        break;
                        //<< . . . . QUIT
                        //break; TODO REVISAR QUIT REPETIDO
                      } while (false);
                      break;
                    }
                    //<< . . . IF +$PIECE(ANGEBOT1,Y,2)=1 DO  QUIT  ;PREISKAKULATION
                    if (mOp.Equal(mOp.Positive(m$.Fnc.$piece(ANGEBOT1.get(),m$.var("Y").get(),2)),1)) {
                      do {
                        //<< . . . . QUIT:$PIECE($GET(^INANGP(YM,ANG,POS,1)),Y,60)=1  ;ERLEDIGT
                        if (mOp.Equal(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^INANGP",m$.var("YM").get(),ANG.get(),POS.get(),1)),m$.var("Y").get(),60),1)) {
                          break;
                        }
                        //<< . . . . ;SET EIGEN=EIGEN+$PIECE($GET(^INAUFP(YM,AUF,POS,1)),Y,5) QUIT   ;AUFTRAGS MENGE KUNDEN
                        //<< . . . . SET PK=PK+1 QUIT   ;AUFTRAGS MENGE KUNDEN  ;quantum
                        PK.set(mOp.Add(PK.get(),1));
                        break;
                        //<< . . . . QUIT
                      //break; TODO REVISAR QUIT REPETIDO
                      } while (false);
                      break;
                    }
                    //<< . . . IF +$PIECE(ANGEBOT1,Y,2)=2 DO  QUIT  ;ANFRAGE
                    if (mOp.Equal(mOp.Positive(m$.Fnc.$piece(ANGEBOT1.get(),m$.var("Y").get(),2)),2)) {
                      do {
                        //<< . . . . QUIT:$PIECE($GET(^INANGP(YM,ANG,POS,1)),Y,60)=1  ;ERLEDIGT
                        if (mOp.Equal(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^INANGP",m$.var("YM").get(),ANG.get(),POS.get(),1)),m$.var("Y").get(),60),1)) {
                          break;
                        }
                        //<< . . . . ;SET LIEFER=LIEFER+$PIECE($GET(^INAUFP(YM,AUF,POS,1)),Y,5) QUIT   ;AUFTRAGS MENGE KUNDEN
                        //<< . . . . SET ANFRAGE=ANFRAGE+1 QUIT   ;AUFTRAGS MENGE KUNDEN ;quantum
                        ANFRAGE.set(mOp.Add(ANFRAGE.get(),1));
                        break;
                        //<< . . . . QUIT
                        //break; TODO REVISAR QUIT REPETIDO
                      } while (false);
                      break;
                    }
                    //<< . . . QUIT
                    break;
                  } while (false);
                }
              }
            }
            //<< . . QUIT
            break;
          } while (false);
        }
      }
      //<< . QUIT
      break;
    } while(false);
    //<< QUIT ANFRAGE_"/"_ANGEBOT_"/"_PK
    return mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(ANFRAGE.get(),"/"),ANGEBOT.get()),"/"),PK.get());
  }

//<< 
}
