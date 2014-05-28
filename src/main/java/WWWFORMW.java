//*****************************************************************************
//** TASC - ALPHALINC - MAC WWWFORMW
//** Innovatium Systems - Code Converter - v1.28
//** 2014-05-26 21:13:49
//*****************************************************************************

import mLibrary.*;


//<< WWWFORMW
public class WWWFORMW extends mClass {

  public void main() {
    _WWWFORMW();
  }

  public void _WWWFORMW() {
    //<< ;-------------------------------------------------------------------------------
    //<< ; Description of Function :
    //<< ;       OPTION ERFASSUNG WIZARD  /  Wizard Option Acquisition
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
    //<< ; 20-Sep-2010   GRF     Case correction - wav as well as WAV in HELP; quits
    //<< ; 03.06.1998    DT      Created
    //<< ;-------------------------------------------------------------------------------
    //<< NEW YI,YPRIM,YA,YLFN
    mVar YI = m$.var("YI");
    mVar YPRIM = m$.var("YPRIM");
    mVar YA = m$.var("YA");
    mVar YLFN = m$.var("YLFN");
    m$.newVar(YI,YPRIM,YA,YLFN);
    //<< 
    //<< QUIT:YFORM=""
    if (mOp.Equal(m$.var("YFORM").get(),"")) {
      return;
    }
    //<< 
    //<< WRITE "<BR><BR>"
    m$.Cmd.Write("<BR><BR>");
    //<< 
    //<< SET YERSTES = 1
    mVar YERSTES = m$.var("YERSTES");
    YERSTES.set(1);
    //<< SET YART    = "P"  ;P=PRIMÄR,D=DATENFELD,M=MANUELLE,L=LISTGENERATOR
    mVar YART = m$.var("YART");
    YART.set("P");
    //<< SET YLFN    = ""
    YLFN.set("");
    //<< FOR  SET YLFN = $ORDER(^WWW121(0,YFORM,YLFN)) QUIT:YLFN=""  DO  QUIT:YERSTES'=1
    for (;true;) {
      YLFN.set(m$.Fnc.$order(m$.var("^WWW121",0,m$.var("YFORM").get(),YLFN.get())));
      if (mOp.Equal(YLFN.get(),"")) {
        break;
      }
      do {
        //<< . SET YSATZ = $GET(^WWW121(0,YFORM,YLFN,1))
        mVar YSATZ = m$.var("YSATZ");
        YSATZ.set(m$.Fnc.$get(m$.var("^WWW121",0,m$.var("YFORM").get(),YLFN.get(),1)));
        //<< . QUIT:$PIECE($GET(YOPTION),"#",YLFN)'=""
        if (mOp.NotEqual(m$.Fnc.$piece(m$.Fnc.$get(m$.var("YOPTION")),"#",YLFN.get()),"")) {
          break;
        }
        //<< . SET YERSTES=YERSTES+1
        YERSTES.set(mOp.Add(YERSTES.get(),1));
        //<< . SET YHIDDSE=0
        mVar YHIDDSE = m$.var("YHIDDSE");
        YHIDDSE.set(0);
        //<< . DO ^WWWFORM9
        m$.Cmd.Do("WWWFORM9.main");
        //<< . DO HELP
        m$.Cmd.Do("HELP");
      } while (false);
      if (mOp.NotEqual(YERSTES.get(),1)) {
        break;
      }
    }
    //<< 
    //<< QUIT:YERSTES'=1
    if (mOp.NotEqual(YERSTES.get(),1)) {
      return;
    }
    //<< 
    //<< SET YLFN = $PIECE($GET(YOPTION),"#",10)
    YLFN.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("YOPTION")),"#",10));
    //<< SET YLFN = $ORDER(^WWW122s(0,5,$$^WWWUMLAU(YFORM,1),YLFN))
    YLFN.set(m$.Fnc.$order(m$.var("^WWW122s",0,5,m$.fnc$("WWWUMLAU.main",m$.var("YFORM").get(),1),YLFN.get())));
    //<< IF YLFN'=""  DO
    if (mOp.NotEqual(YLFN.get(),"")) {
      do {
        //<< . SET YBBN = $ORDER(^WWW122s(0,5,$$^WWWUMLAU(YFORM,1),YLFN,YFORM,""))
        mVar YBBN = m$.var("YBBN");
        YBBN.set(m$.Fnc.$order(m$.var("^WWW122s",0,5,m$.fnc$("WWWUMLAU.main",m$.var("YFORM").get(),1),YLFN.get(),m$.var("YFORM").get(),"")));
        //<< . QUIT:YBBN=""
        if (mOp.Equal(YBBN.get(),"")) {
          break;
        }
        //<< . SET YSATZ = $GET(^WWW122(0,YFORM,YBBN,1))
        mVar YSATZ = m$.var("YSATZ");
        YSATZ.set(m$.Fnc.$get(m$.var("^WWW122",0,m$.var("YFORM").get(),YBBN.get(),1)));
        //<< . SET YLFN  = $PIECE(YSATZ,Y,1)               ;DATENBANKFELD
        YLFN.set(m$.Fnc.$piece(YSATZ.get(),m$.var("Y").get(),1));
        //<< . SET $PIECE(YSATZ,Y,15) = $PIECE($GET(YPARA),"#",YLFN)
        m$.pieceVar(YSATZ,m$.var("Y").get(),15).set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("YPARA")),"#",YLFN.get()));
        //<< . SET YHIDDSE = 0
        mVar YHIDDSE = m$.var("YHIDDSE");
        YHIDDSE.set(0);
        //<< . DO FORMVOR
        m$.Cmd.Do("FORMVOR");
      } while (false);
    }
    //<< 
    //<< QUIT
    return;
  }

  //<< 
  //<< 
  //<< FORMVOR ;VORGABEN FÜR FORMULAR ;to form
  public void FORMVOR() {
    //<< SET YART="D"  ;P=PRIMÄR,D=DATENFELD,M=MANUELLE,L=LISTGENERATOR
    mVar YART = m$.var("YART");
    YART.set("D");
    //<< IF $PIECE(YSATZ,Y,1)="" SET YART="M",YLFN=YBBN  ;WENN MANUELL, DANN
    if (mOp.Equal(m$.Fnc.$piece(m$.var("YSATZ").get(),m$.var("Y").get(),1),"")) {
      YART.set("M");
      mVar YLFN = m$.var("YLFN");
      YLFN.set(m$.var("YBBN").get());
    }
    //<< SET YERSTES=YERSTES+1
    mVar YERSTES = m$.var("YERSTES");
    YERSTES.set(mOp.Add(m$.var("YERSTES").get(),1));
    //<< DO ^WWWFORM9  ;ANZEIGEN DATENFELD ;display data item
    m$.Cmd.Do("WWWFORM9.main");
    //<< DO HELP
    m$.Cmd.Do("HELP");
    //<< QUIT
    return;
  }

  //<< 
  //<< 
  //<< HELP ;
  public void HELP() {
    //<< NEW YTEXT,YINHALT
    mVar YTEXT = m$.var("YTEXT");
    mVar YINHALT = m$.var("YINHALT");
    m$.newVar(YTEXT,YINHALT);
    //<< 
    //<< WRITE "</TR></TABLE>"
    m$.Cmd.Write("</TR></TABLE>");
    //<< SET YTABLEANZ = $GET(YTABLEANZ)-1
    mVar YTABLEANZ = m$.var("YTABLEANZ");
    YTABLEANZ.set(mOp.Subtract(m$.Fnc.$get(m$.var("YTABLEANZ")),1));
    //<< 
    //<< SET YTEXT = $$^WWWSETL("^WWW127(0,"_""""_YFORM_""""_","_""""_YART_""""_","_""""_YLFN_""""_","_""""_$$^WWWLANGU(YBED)_""""_","_""""_1_""""_")")
    YTEXT.set(m$.fnc$("WWWSETL.main",mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("^WWW127(0,","\""),m$.var("YFORM").get()),"\""),","),"\""),m$.var("YART").get()),"\""),","),"\""),m$.var("YLFN").get()),"\""),","),"\""),m$.fnc$("WWWLANGU.main",m$.var("YBED").get())),"\""),","),"\""),1),"\""),")")));
    //<< IF YTEXT="" SET YTEXT = $$^WWWSETL("^WWW127(0,"_""""_YFORM_""""_","_""""_YART_""""_","_""""_YLFN_""""_","_""""_"DE"_""""_","_""""_1_""""_")")
    if (mOp.Equal(YTEXT.get(),"")) {
      YTEXT.set(m$.fnc$("WWWSETL.main",mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("^WWW127(0,","\""),m$.var("YFORM").get()),"\""),","),"\""),m$.var("YART").get()),"\""),","),"\""),m$.var("YLFN").get()),"\""),","),"\""),"DE"),"\""),","),"\""),1),"\""),")")));
    }
    //<< SET YTEXT = $PIECE(YTEXT,"~",1)  ;NUR DER NORMALHILFE TEXT ;only the Text
    YTEXT.set(m$.Fnc.$piece(YTEXT.get(),"~",1));
    //<< FOR YI1=1:1 QUIT:$PIECE(YTEXT,"|",YI1,999)=""  DO
    mVar YI1 = m$.var("YI1");
    for (YI1.set(1);(true);YI1.set(mOp.Add(YI1.get(),1))) {
      if (mOp.Equal(m$.Fnc.$piece(YTEXT.get(),"|",YI1.get(),999),"")) {
        break;
      }
      do {
        //<< . SET YINHALT=$PIECE(YTEXT,"|",YI1)
        YINHALT.set(m$.Fnc.$piece(YTEXT.get(),"|",YI1.get()));
        //<< . IF YINHALT'="" IF '$FIND(YINHALT," ") IF $FIND(YINHALT,".GIF") || ($FIND(YINHALT,".gif")) QUIT
        if (mOp.NotEqual(YINHALT.get(),"")) {
          if (mOp.Not(m$.Fnc.$find(YINHALT.get()," "))) {
            if (mOp.Logical(m$.Fnc.$find(YINHALT.get(),".GIF")) || mOp.Logical((m$.Fnc.$find(YINHALT.get(),".gif")))) {
              break;
            }
          }
        }
        //<< . IF YINHALT'="" IF '$FIND(YINHALT," ") IF $FIND(YINHALT,".AVI") || ($FIND(YINHALT,".avi")) QUIT
        if (mOp.NotEqual(YINHALT.get(),"")) {
          if (mOp.Not(m$.Fnc.$find(YINHALT.get()," "))) {
            if (mOp.Logical(m$.Fnc.$find(YINHALT.get(),".AVI")) || mOp.Logical((m$.Fnc.$find(YINHALT.get(),".avi")))) {
              break;
            }
          }
        }
        //<< . IF YINHALT'="" IF '$FIND(YINHALT," ") IF $FIND(YINHALT,".WAV") || ($FIND(YINHALT,".wav")) QUIT
        if (mOp.NotEqual(YINHALT.get(),"")) {
          if (mOp.Not(m$.Fnc.$find(YINHALT.get()," "))) {
            if (mOp.Logical(m$.Fnc.$find(YINHALT.get(),".WAV")) || mOp.Logical((m$.Fnc.$find(YINHALT.get(),".wav")))) {
              break;
            }
          }
        }
        //<< . WRITE $PIECE(YTEXT,"|",YI1)
        m$.Cmd.Write(m$.Fnc.$piece(YTEXT.get(),"|",YI1.get()));
        //<< . WRITE " ",YCR
        m$.Cmd.Write(" ",m$.var("YCR").get());
      } while (false);
    }
    //<< 
    //<< QUIT
    return;
  }

//<< 
//<< 
}
