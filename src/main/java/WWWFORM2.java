//*****************************************************************************
//** TASC - ALPHALINC - MAC WWWFORM2
//** Innovatium Systems - Code Converter - v1.27
//** 2014-05-22 00:14:37
//*****************************************************************************

import mLibrary.*;


//<< WWWFORM2
public class WWWFORM2 extends mClass {

  public void main() {
    _WWWFORM2();
  }

  public void _WWWFORM2() {
    //<< ;-------------------------------------------------------------------------------
    //<< ; Description of Function :
    //<< ;       SPEICHERN LOKALE VARIABELN
    //<< ;
    //<< ;   ANWAHL BEI VERLASSEN DES FORMS ;next to forsake
    //<< ;   KEINE Y ;no
    //<< ;   ALLE V NUR BEI GLEICHEM FORMULAR ;only next to form
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
    //<< ; 23-Aug-2007   GRF     Replace $zsort with $order
    //<< ; 10.03.1999    DT
    //<< ;-------------------------------------------------------------------------------
    //<< ;VARIABLE SPEICHERN ;Save
    //<< NEW %X
    //<< 
    //<< SET YTRAKT=+$GET(YTRAKT)
    mVar YTRAKT = m$.var("YTRAKT");
    YTRAKT.set(mOp.Positive(m$.Fnc.$get(m$.var("YTRAKT"))));
    //<< KILL ^WWWZWS(0,+$HOROLOG,YUSER,0)
    m$.var("^WWWZWS",0,mOp.Positive(m$.Fnc.$horolog()),m$.var("YUSER").get(),0).kill();
    //<< 
    //<< SET %X="%ZZZZZ"
    m$.var("%X").set("%ZZZZZ");
    //<< SET LASTUSEDFORM=$GET(YFORM)
    mVar LASTUSEDFORM = m$.var("LASTUSEDFORM");
    LASTUSEDFORM.set(m$.Fnc.$get(m$.var("YFORM")));
    //<< FOR  SET %X=$ORDER(@%X) QUIT:%X=""  DO
    for (;true;) {
      m$.var("%X").set(m$.Fnc.$order(m$.indirectVar(m$.var("%X").get())));
      if (mOp.Equal(m$.var("%X").get(),"")) {
        break;
      }
      //<< . IF $DATA(@%X)'=10 SET %X(1)=@%X DO
      if (mOp.NotEqual(m$.Fnc.$data(m$.indirectVar(m$.var("%X").get())),10)) {
        m$.var("%X",1).set(m$.indirectVar(m$.var("%X").get()).get());
        do {
          //<< . . QUIT:$FIND(%X,YQUERY)
          if (mOp.Logical(m$.Fnc.$find(m$.var("%X").get(),m$.var("YQUERY").get()))) {
            break;
          }
          //<< . . QUIT:$FIND(%X,"HTTP_USER")
          if (mOp.Logical(m$.Fnc.$find(m$.var("%X").get(),"HTTP_USER"))) {
            break;
          }
          //<< . . QUIT:$EXTRACT(%X)="Y"
          if (mOp.Equal(m$.Fnc.$extract(m$.var("%X").get()),"Y")) {
            break;
          }
          //<< . . QUIT:$EXTRACT(%X)="%"
          if (mOp.Equal(m$.Fnc.$extract(m$.var("%X").get()),"%")) {
            break;
          }
          //<< . . QUIT:%X="SPRACHE"
          if (mOp.Equal(m$.var("%X").get(),"SPRACHE")) {
            break;
          }
          //<< . . QUIT:%X="LANGUAGE"
          if (mOp.Equal(m$.var("%X").get(),"LANGUAGE")) {
            break;
          }
          //<< . . QUIT:$LENGTH(%X)>32
          if (mOp.Greater(m$.Fnc.$length(m$.var("%X").get()),32)) {
            break;
          }
          //<< . . QUIT:$TRANSLATE(%X," []{}~²³µ\|.-_,.;:^<>°!§$%&/()?`´#'+*ÄäÜüßÖö@"_""""_$CHAR(0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32))'=%X
          if (mOp.NotEqual(m$.Fnc.$translate(m$.var("%X").get(),mOp.Concat(mOp.Concat(" []{}~²³µ\\|.-_,.;:^<>°!§$%&/()?`´#'+*ÄäÜüßÖö@","\""),m$.Fnc.$char(0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32))),m$.var("%X").get())) {
            break;
          }
          //<< . . ;
          //<< . . DO
          do {
            //<< . . . QUIT:%X="FFFELD"
            if (mOp.Equal(m$.var("%X").get(),"FFFELD")) {
              break;
            }
            //<< . . . QUIT:%X="FMFELD"
            if (mOp.Equal(m$.var("%X").get(),"FMFELD")) {
              break;
            }
            //<< . . . SET %X(1)=$TRANSLATE(%X(1),"""")
            m$.var("%X",1).set(m$.Fnc.$translate(m$.var("%X",1).get(),"\""));
          } while(false);
          //<< . . ;
          //<< . . SET ^WWWZWS(0,+$HOROLOG,YUSER,YTRAKT,%X,1)=$EXTRACT(%X(1),1,30000)
          m$.var("^WWWZWS",0,mOp.Positive(m$.Fnc.$horolog()),m$.var("YUSER").get(),YTRAKT.get(),m$.var("%X").get(),1).set(m$.Fnc.$extract(m$.var("%X",1).get(),1,30000));
        } while (false);
      }
      //<< . ;
      //<< . IF ($DATA(@%X)=10)||($DATA(@%X)=11) DO
      if ((mOp.Equal(m$.Fnc.$data(m$.indirectVar(m$.var("%X").get())),10)) || (mOp.Equal(m$.Fnc.$data(m$.indirectVar(m$.var("%X").get())),11))) {
        //<< . . SET %XXX=%X_"(%XXXX)",%XXXX=""
        m$.var("%XXX").set(mOp.Concat(m$.var("%X").get(),"(%XXXX)"));
        m$.var("%XXXX").set("");
        //<< . . FOR  SET %XXX=$ZORDER(@%XXX) QUIT:%XXX=""  DO
        for (;true;) {
          m$.var("%XXX").set(m$.Fnc.$zorder(m$.indirectVar(m$.var("%XXX").get())));
          if (mOp.Equal(m$.var("%XXX").get(),"")) {
            break;
          }
          do {
            //<< . . . SET %X(1)=@%XXX
            m$.var("%X",1).set(m$.indirectVar(m$.var("%XXX").get()).get());
            //<< . . . QUIT:$FIND(%XXX,YQUERY)
            if (mOp.Logical(m$.Fnc.$find(m$.var("%XXX").get(),m$.var("YQUERY").get()))) {
              break;
            }
            //<< . . . QUIT:$FIND(%XXX,"HTTP_USER")
            if (mOp.Logical(m$.Fnc.$find(m$.var("%XXX").get(),"HTTP_USER"))) {
              break;
            }
            //<< . . . QUIT:$EXTRACT(%XXX)="Y"
            if (mOp.Equal(m$.Fnc.$extract(m$.var("%XXX").get()),"Y")) {
              break;
            }
            //<< . . . QUIT:$EXTRACT(%XXX)="%"
            if (mOp.Equal(m$.Fnc.$extract(m$.var("%XXX").get()),"%")) {
              break;
            }
            //<< . . . QUIT:%XXX="SPRACHE"
            if (mOp.Equal(m$.var("%XXX").get(),"SPRACHE")) {
              break;
            }
            //<< . . . QUIT:%XXX="LANGUAGE"
            if (mOp.Equal(m$.var("%XXX").get(),"LANGUAGE")) {
              break;
            }
            //<< . . . QUIT:$LENGTH(%XXX)>32
            if (mOp.Greater(m$.Fnc.$length(m$.var("%XXX").get()),32)) {
              break;
            }
            //<< . . . QUIT:$TRANSLATE(%X," []{}~²³µ\|.-_,.;:^<>°!§$%&/?`´#'+*ÄäÜüßÖö@"_""""_$CHAR(0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32))'=%X
            if (mOp.NotEqual(m$.Fnc.$translate(m$.var("%X").get(),mOp.Concat(mOp.Concat(" []{}~²³µ\\|.-_,.;:^<>°!§$%&/?`´#'+*ÄäÜüßÖö@","\""),m$.Fnc.$char(0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32))),m$.var("%X").get())) {
              break;
            }
            //<< . . . SET %X(1)=$TRANSLATE(%X(1),"""") SET ^WWWZWS(0,+$HOROLOG,YUSER,YTRAKT,%XXX,1)=$EXTRACT(%X(1),1,30000)
            m$.var("%X",1).set(m$.Fnc.$translate(m$.var("%X",1).get(),"\""));
            m$.var("^WWWZWS",0,mOp.Positive(m$.Fnc.$horolog()),m$.var("YUSER").get(),YTRAKT.get(),m$.var("%XXX").get(),1).set(m$.Fnc.$extract(m$.var("%X",1).get(),1,30000));
          } while (false);
        }
      }
    }
    //<< 
    //<< ;------------------------------------------------------------------------
    //<< MERGE ^WWWZWS(0,+$HOROLOG,YUSER,0)=^WWWZWS(0,+$HOROLOG,YUSER,YTRAKT)  ;COPIE IN 0 ;within
    m$.Cmd.Merge(m$.var("^WWWZWS",0,mOp.Positive(m$.Fnc.$horolog()),m$.var("YUSER").get(),0),m$.var("^WWWZWS",0,mOp.Positive(m$.Fnc.$horolog()),m$.var("YUSER").get(),YTRAKT.get()));
    //<< SET Q=0
    mVar Q = m$.var("Q");
    Q.set(0);
    //<< QUIT
    return;
  }

//<< 
}
