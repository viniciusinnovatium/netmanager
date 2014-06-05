//*****************************************************************************
//** TASC - ALPHALINC - MAC WWWQUERY
//** Innovatium Systems - Code Converter - v1.29
//** 2014-06-03 20:54:56
//*****************************************************************************

import mLibrary.*;


//<< WWWQUERY(CLASS,QUERY,PARAMETER,BACK,RESULT)
public class WWWQUERY extends mClass {

  public Object main(Object ... _p) {
    mVar CLASS = m$.newVarRef("CLASS",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar QUERY = m$.newVarRef("QUERY",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar PARAMETER = m$.newVarRef("PARAMETER",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    mVar BACK = m$.newVarRef("BACK",(((_p!=null)&&(_p.length>=4))?_p[3]:null));
    mVar RESULT = m$.newVarRef("RESULT",(((_p!=null)&&(_p.length>=5))?_p[4]:null));
    return _WWWQUERY(CLASS,QUERY,PARAMETER,BACK,RESULT);
  }

  public Object _WWWQUERY(Object ... _p) {
    mVar CLASS = m$.newVarRef("CLASS",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar QUERY = m$.newVarRef("QUERY",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar PARAMETER = m$.newVarRef("PARAMETER",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    mVar BACK = m$.newVarRef("BACK",(((_p!=null)&&(_p.length>=4))?_p[3]:null));
    mVar RESULT = m$.newVarRef("RESULT",(((_p!=null)&&(_p.length>=5))?_p[4]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Description of Function :
    //<< ;       EXECUTE QUERY
    //<< ;   DO WWWQUERY(CLASS,QUERY,PARAMETERLIST,1,0)
    //<< ;
    //<< ; Inputs :
    //<< ;   CLASS       Klassenname
    //<< ;   QUERY       Name des Query oder gesamtes query (select * from...)
    //<< ;   PARAMETER   Parameterliste PARA,PARA,
    //<< ;   BACK        1 = Rückbutton aktiv ;active
    //<< ;   RESULT      1 = NUR resultset (no show) ;only
    //<< ;
    //<< ; ByRef :
    //<< ;
    //<< ;
    //<< ; Returns :
    //<< ;
    //<< ;
    //<< ; History :
    //<< ; 12-Jan-2010   DWR     SR17074: Use current form, set YKEY to first field requested
    //<< ; 11-JAN-2010   SHOBBY/DWR  SR17074: add functionality to pass in YPARA for SQL
    //<< ; 28-Sep-2007   GRF     Doco; Naked References; FIX ME
    //<< ; 02-Sep-2005   JW      SR12966: WWWFORM is not shared
    //<< ; 30-May-2005   RPW     SR12056: Attempt at Performance Increase
    //<< ; 25.01.2001    DT
    //<< ;-------------------------------------------------------------------------------
    //<< new col,rset,sc,columns,OK,FELD,FELD1,YDATEI,YINHALT,YLFN,YLINK,YKEY,YFORM,YFKEY,YI,QUERY1,YI
    mVar col = m$.var("col");
    mVar rset = m$.var("rset");
    mVar sc = m$.var("sc");
    mVar columns = m$.var("columns");
    mVar OK = m$.var("OK");
    mVar FELD = m$.var("FELD");
    mVar FELD1 = m$.var("FELD1");
    mVar YDATEI = m$.var("YDATEI");
    mVar YINHALT = m$.var("YINHALT");
    mVar YLFN = m$.var("YLFN");
    mVar YLINK = m$.var("YLINK");
    mVar YKEY = m$.var("YKEY");
    mVar YFORM = m$.var("YFORM");
    mVar YFKEY = m$.var("YFKEY");
    mVar YI = m$.var("YI");
    mVar QUERY1 = m$.var("QUERY1");
    m$.newVar(col,rset,sc,columns,OK,FELD,FELD1,YDATEI,YINHALT,YLFN,YLINK,YKEY,YFORM,YFKEY,YI,QUERY1,YI);
    //<< 
    //<< set CLASS     = $get(CLASS)
    CLASS.set(m$.Fnc.$get(CLASS));
    //<< set QUERY     = $translate($get(QUERY),"|"," ")
    QUERY.set(m$.Fnc.$translate(m$.Fnc.$get(QUERY),"|"," "));
    //<< set PARAMETER = $get(PARAMETER)
    PARAMETER.set(m$.Fnc.$get(PARAMETER));
    //<< 
    //<< set OK=0
    OK.set(0);
    //<< ;-----------------------------------------------------------------------------------------------------
    //<< IF CLASS'="" DO  ;NORMALE QUERY
    if (mOp.NotEqual(CLASS.get(),"")) {
      //<< . SET rset=##class(%Library.ResultSet).%New()
      rset.set(m$.fnc$("$Library.ResultSet.$New"));
      //<< . SET OK=1
      OK.set(1);
      //<< . SET rset.ClassName=CLASS
      m$.prop(rset.get(),"ClassName").set(CLASS.get());
      //<< . SET rset.QueryName=QUERY
      m$.prop(rset.get(),"QueryName").set(QUERY.get());
    }
    //<< 
    //<< ;-----------------------------------------------------------------------------------------------------
    //<< ;IF CLASS="" IF $FIND($$^WWWUPER(QUERY),"SELECT") DO       ;DYNAMISCHE QUERY
    //<< IF (CLASS="") && $FIND($zconvert(QUERY,"U"),"SELECT") DO   ;DYNAMISCHE QUERY
    if ((mOp.Equal(CLASS.get(),"")) && mOp.Logical(m$.Fnc.$find(m$.Fnc.$zconvert(QUERY.get(),"U"),"SELECT"))) {
      //<< . set QUERY=$$FullReplace^COMUtilStr(QUERY,"@YPARA","'"_YPARA_"'")
      QUERY.set(m$.fnc$("COMUtilStr.FullReplace",QUERY.get(),"@YPARA",mOp.Concat(mOp.Concat("'",m$.var("YPARA").get()),"'")));
      //<< . SET rset = ##class(%Library.ResultSet).%New("%DynamicQuery:SQL")
      rset.set(m$.fnc$("$Library.ResultSet.$New","%DynamicQuery:SQL"));
      //<< . SET OK   = rset.Prepare(QUERY)
      OK.set(m$.fnc$(rset.getORef(),"Prepare",QUERY.get()));
    }
    //<< ;. SET OK=1  ; This would always allow this work even without a value prepare.
    //<< 
    //<< ;-----------------------------------------------------------------------------------------------------
    //<< QUIT:OK'=1
    if (mOp.NotEqual(OK.get(),1)) {
      return null;
    }
    //<< 
    //<< SET columns=rset.GetColumnCount()
    columns.set(m$.fnc$(rset.getORef(),"GetColumnCount"));
    //<< IF PARAMETER'="" SET sc=rset.Execute(PARAMETER)
    if (mOp.NotEqual(PARAMETER.get(),"")) {
      sc.set(m$.fnc$(rset.getORef(),"Execute",PARAMETER.get()));
    }
    //<< IF PARAMETER=""  SET sc=rset.Execute()
    if (mOp.Equal(PARAMETER.get(),"")) {
      sc.set(m$.fnc$(rset.getORef(),"Execute"));
    }
    //<< ;IF $$$ISERR(sc) QUIT  ; The execute failed
    //<< IF $GET(RESULT)=1 QUIT
    if (mOp.Equal(m$.Fnc.$get(RESULT),1)) {
      return null;
    }
    //<< 
    //<< IF $GET(BACK)=1 DO ^WWWBACK
    if (mOp.Equal(m$.Fnc.$get(BACK),1)) {
      m$.Cmd.Do("WWWBACK.main");
    }
    //<< WRITE YCR
    m$.Cmd.Write(m$.var("YCR").get());
    //<< SET YDATEI=CLASS
    YDATEI.set(CLASS.get());
    //<< SET QUERY1=""
    QUERY1.set("");
    //<< FOR YI=1:1 QUIT:$PIECE(QUERY," ",YI,999)=""  DO
    for (YI.set(1);(true);YI.set(mOp.Add(YI.get(),1))) {
      if (mOp.Equal(m$.Fnc.$piece(QUERY.get()," ",YI.get(),999),"")) {
        break;
      }
      //<< . SET YI(1)=$PIECE(QUERY," ",YI)
      YI.var(1).set(m$.Fnc.$piece(QUERY.get()," ",YI.get()));
      //<< . SET:$TRANSLATE(YI(1),"from","FROM")="FROM" YI(1)="FROM",YDATEI=$PIECE(QUERY," ",YI+1)
      if (mOp.Equal(m$.Fnc.$translate(YI.var(1).get(),"from","FROM"),"FROM")) {
        YI.var(1).set("FROM");
        YDATEI.set(m$.Fnc.$piece(QUERY.get()," ",mOp.Add(YI.get(),1)));
      }
      //<< . SET QUERY1=QUERY1_YI(1)_" "
      QUERY1.set(mOp.Concat(mOp.Concat(QUERY1.get(),YI.var(1).get())," "));
    }
    //<< IF $TRANSLATE(YDATEI," ")="" SET YDATEI=$PIECE($PIECE(QUERY1,"FROM ",2)," ",1)
    if (mOp.Equal(m$.Fnc.$translate(YDATEI.get()," "),"")) {
      YDATEI.set(m$.Fnc.$piece(m$.Fnc.$piece(QUERY1.get(),"FROM ",2)," ",1));
    }
    //<< SET YLINK=""
    YLINK.set("");
    //<< IF YDATEI'="" IF $DATA(^WWWFORM(YM,YDATEI)) SET YLINK=1  ;MIT LINK AUF DATENSATZ ;by means of upon data record
    if (mOp.NotEqual(YDATEI.get(),"")) {
      if (mOp.Logical(m$.Fnc.$data(m$.var("^WWWFORM",m$.var("YM").get(),YDATEI.get())))) {
        YLINK.set(1);
      }
    }
    //<< DO ^WWWFRAME(0)
    m$.Cmd.Do("WWWFRAME.main",0);
    //<< 
    //<< ;---------------------------------------
    //<< WRITE YCR,"<TR>"
    m$.Cmd.Write(m$.var("YCR").get(),"<TR>");
    //<< 
    //<< FOR col=1:1:columns DO
    for (col.set(1);(mOp.LessOrEqual(col.get(),columns.get()));col.set(mOp.Add(col.get(),1))) {
      //<< . WRITE "<TH NOWRAP ALIGN=LEFT BGCOLOR="_YDARKGRAY_">"
      m$.Cmd.Write(mOp.Concat(mOp.Concat("<TH NOWRAP ALIGN=LEFT BGCOLOR=",m$.var("YDARKGRAY").get()),">"));
      //<< . IF $PIECE(YVOR,Y,7)'="" WRITE "<FONT SIZE="_""""_$PIECE(YVOR,Y,7)_""""_">"
      if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),7),"")) {
        m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<FONT SIZE=","\""),m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),7)),"\""),">"));
      }
      //<< . SET FELD=rset.GetColumnName(col)
      FELD.set(m$.fnc$(rset.getORef(),"GetColumnName",col.get()));
      //<< . IF YDATEI'="" DO  ;SUCHEN DATENFELDER ;seek
      if (mOp.NotEqual(YDATEI.get(),"")) {
        do {
          //<< . . ;
          //<< . . ; FIXME : <GRF> There is no DO on the following line so it doesn't drop into
          //<< . . ;               the subsequent 3-dot block but looking at the test of FELD,
          //<< . . ;               it appears the IF FELD'="" should only have 2 dots similar
          //<< . . ;               to the following block.
          //<< . . ;     HOWEVER : it could be that the indentation effectively disables the
          //<< . . ;               block that shouldn't be run.
          //<< . . ;
          //<< . . ;               I believe removing the ". " on the second "IF FELD" of the
          //<< . . ;               three is correct.
          //<< . . ;
          //<< . . IF FELD="ID" SET FELD(col) = "P"_Y_0_Y_"ID"
          if (mOp.Equal(FELD.get(),"ID")) {
            FELD.var(col.get()).set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("P",m$.var("Y").get()),0),m$.var("Y").get()),"ID"));
          }
          //<< . . . SET FELD(col) = "P"_Y_FELD1_Y_$PIECE($GET(^WWW002(0,YDATEI,FELD1,1)),Y,3)
          //<< . . . IF $DATA(^WWW0021(0,YDATEI,FELD1,SPRACHE,1)) SET FELD=$PIECE(^WWW0021(0,YDATEI,FELD1,SPRACHE,1),Y,1) QUIT
          //<< . . . SET FELD = $PIECE($GET(^WWW002(0,YDATEI,FELD1,1)),Y,2)  ;FELDNAME
          //<< . . ;
          //<< . . IF (FELD'="")&&(FELD'="ID") DO
          if ((mOp.NotEqual(FELD.get(),"")) && (mOp.NotEqual(FELD.get(),"ID"))) {
            //<< . . . SET FELD1 = $ORDER(^WWW003s(0,3,$$^WWWUMLAU(YDATEI,1),$$^WWWUMLAU(FELD,1),YDATEI,""))
            FELD1.set(m$.Fnc.$order(m$.var("^WWW003s",0,3,m$.fnc$("WWWUMLAU.main",YDATEI.get(),1),m$.fnc$("WWWUMLAU.main",FELD.get(),1),YDATEI.get(),"")));
            //<< . . . IF FELD1'="" DO
            if (mOp.NotEqual(FELD1.get(),"")) {
              //<< . . . . set FELD=$$^WWWFELDNAME(YDATEI,"D",FELD1)
              FELD.set(m$.fnc$("WWWFELDNAME.main",YDATEI.get(),"D",FELD1.get()));
              //<< . . . . SET FELD(col) = "D"_Y_FELD1_Y_FELD
              FELD.var(col.get()).set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("D",m$.var("Y").get()),FELD1.get()),m$.var("Y").get()),FELD.get()));
            }
            //<< . . . . ;. SET FELD(col) = "D"_Y_FELD1_Y_$P($G(^WWW003(0,YDATEI,FELD1,1)),Y,3)
            //<< . . . . ;. IF $DATA(^WWW0031(0,YDATEI,FELD1,SPRACHE,1)) SET FELD=$PIECE(^WWW0031(0,YDATEI,FELD1,SPRACHE,1),Y,1) QUIT
            //<< . . . . ;. SET FELD = $PIECE($GET(^WWW003(0,YDATEI,FELD1,1)),Y,2)  ;FELDNAME
            //<< . . . if FELD1="" DO
            if (mOp.Equal(FELD1.get(),"")) {
              //<< . . . . SET FELD1 = $ORDER(^WWW002s(0,3,$$^WWWUMLAU(YDATEI,1),$$^WWWUMLAU(FELD,1),YDATEI,""))
              FELD1.set(m$.Fnc.$order(m$.var("^WWW002s",0,3,m$.fnc$("WWWUMLAU.main",YDATEI.get(),1),m$.fnc$("WWWUMLAU.main",FELD.get(),1),YDATEI.get(),"")));
              //<< . . . . set FELD=$$^WWWFELDNAME(YDATEI,"P",FELD1)
              FELD.set(m$.fnc$("WWWFELDNAME.main",YDATEI.get(),"P",FELD1.get()));
              //<< . . . . SET FELD(col) = "P"_Y_FELD1_Y_FELD
              FELD.var(col.get()).set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("P",m$.var("Y").get()),FELD1.get()),m$.var("Y").get()),FELD.get()));
            }
          }
        } while (false);
      }
      //<< . WRITE FELD
      m$.Cmd.Write(FELD.get());
      //<< . WRITE "&nbsp;"
      m$.Cmd.Write("&nbsp;");
      //<< . WRITE "</TH>"
      m$.Cmd.Write("</TH>");
    }
    //<< 
    //<< WRITE "</TR>",YCR
    m$.Cmd.Write("</TR>",m$.var("YCR").get());
    //<< ;---------------------------------------
    //<< 
    //<< ; FIXME : <GRF> probably should have a </TR> at the end of the for loop at 1-dot level.
    //<< ;               Should conditionally close <FONT> before </TD>
    //<< 
    //<< FOR  QUIT:'rset.Next()  DO
    for (;true;) {
      if (mOp.Not(m$.fnc$(rset.getORef(),"Next"))) {
        break;
      }
      //<< . WRITE YCR,"<TR>"
      m$.Cmd.Write(m$.var("YCR").get(),"<TR>");
      //<< . SET YDDSATZ=$GET(YDDSATZ)+1
      mVar YDDSATZ = m$.var("YDDSATZ");
      YDDSATZ.set(mOp.Add(m$.Fnc.$get(m$.var("YDDSATZ")),1));
      //<< . SET YKEY=""
      YKEY.set("");
      //<< . ;
      //<< . FOR col=1:1:columns DO
      for (col.set(1);(mOp.LessOrEqual(col.get(),columns.get()));col.set(mOp.Add(col.get(),1))) {
        //<< . . WRITE "<TD VALIGN=TOP NOWRAP"
        m$.Cmd.Write("<TD VALIGN=TOP NOWRAP");
        //<< . . IF YDDSATZ#2=1 WRITE " BGCOLOR="_YWHITE
        if (mOp.Equal(mOp.Modulus(YDDSATZ.get(),2),1)) {
          m$.Cmd.Write(mOp.Concat(" BGCOLOR=",m$.var("YWHITE").get()));
        }
        //<< . . IF YDDSATZ#2=0 WRITE " BGCOLOR="_YGRAY
        if (mOp.Equal(mOp.Modulus(YDDSATZ.get(),2),0)) {
          m$.Cmd.Write(mOp.Concat(" BGCOLOR=",m$.var("YGRAY").get()));
        }
        //<< . . IF $PIECE($GET(FELD(col)),Y,3)'="" IF $FIND(",1,4,7,8,9,12,14,",","_$PIECE($GET(FELD(col)),Y,3)_",") WRITE " align=right"
        if (mOp.NotEqual(m$.Fnc.$piece(m$.Fnc.$get(FELD.var(col.get())),m$.var("Y").get(),3),"")) {
          if (mOp.Logical(m$.Fnc.$find(",1,4,7,8,9,12,14,",mOp.Concat(mOp.Concat(",",m$.Fnc.$piece(m$.Fnc.$get(FELD.var(col.get())),m$.var("Y").get(),3)),",")))) {
            m$.Cmd.Write(" align=right");
          }
        }
        //<< . . WRITE ">"
        m$.Cmd.Write(">");
        //<< . . IF $PIECE(YVOR,Y,7)'="" WRITE "<FONT SIZE="_""""_$PIECE(YVOR,Y,7)_""""_">"
        if (mOp.NotEqual(m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),7),"")) {
          m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<FONT SIZE=","\""),m$.Fnc.$piece(m$.var("YVOR").get(),m$.var("Y").get(),7)),"\""),">"));
        }
        //<< . . ;
        //<< . . ;
        //<< . . SET YINHALT=rset.GetData(col)
        YINHALT.set(m$.fnc$(rset.getORef(),"GetData",col.get()));
        //<< . . ;
        //<< . . ;
        //<< . . IF YDATEI'="" IF $DATA(FELD(col)) DO
        if (mOp.NotEqual(YDATEI.get(),"")) {
          if (mOp.Logical(m$.Fnc.$data(FELD.var(col.get())))) {
            do {
              //<< . . . NEW YART
              mVar YART = m$.var("YART");
              m$.newVarBlock(3,YART);
              //<< . . . SET YART=$PIECE(FELD(col),Y,1)
              YART.set(m$.Fnc.$piece(FELD.var(col.get()).get(),m$.var("Y").get(),1));
              //<< . . . SET YLFN=$PIECE(FELD(col),Y,2)
              YLFN.set(m$.Fnc.$piece(FELD.var(col.get()).get(),m$.var("Y").get(),2));
              //<< . . . SET YTYP=$PIECE(FELD(col),Y,3)
              mVar YTYP = m$.var("YTYP");
              YTYP.set(m$.Fnc.$piece(FELD.var(col.get()).get(),m$.var("Y").get(),3));
              //<< . . . IF YART="P" IF +YLFN=0 DO  ;ID
              if (mOp.Equal(YART.get(),"P")) {
                if (mOp.Equal(mOp.Positive(YLFN.get()),0)) {
                  //<< . . . . NEW YI
                  m$.newVarBlock(4,YI);
                  //<< . . . . FOR YI=1:1 QUIT:$PIECE(YINHALT,"||",YI)=""  DO
                  for (YI.set(1);(true);YI.set(mOp.Add(YI.get(),1))) {
                    if (mOp.Equal(m$.Fnc.$piece(YINHALT.get(),"||",YI.get()),"")) {
                      break;
                    }
                    //<< . . . . . SET $PIECE(YKEY,",",YI)=$PIECE(YINHALT,"||",YI)
                    m$.pieceVar(YKEY,",",YI.get()).set(m$.Fnc.$piece(YINHALT.get(),"||",YI.get()));
                  }
                }
                m$.restoreVarBlock(4);
              }
              //<< . . . ;
              //<< . . . IF YART="P" IF +YLFN'=0 SET $PIECE(YKEY,",",YLFN)=YINHALT
              if (mOp.Equal(YART.get(),"P")) {
                if (mOp.NotEqual(mOp.Positive(YLFN.get()),0)) {
                  m$.pieceVar(YKEY,",",YLFN.get()).set(YINHALT.get());
                }
              }
              //<< . . . IF YART="P" SET YINHALT=$$^WWWFORMAT(YDATEI,"P",YLFN,YINHALT) QUIT  ;FORMAT KEY
              if (mOp.Equal(YART.get(),"P")) {
                YINHALT.set(m$.fnc$("WWWFORMAT.main",YDATEI.get(),"P",YLFN.get(),YINHALT.get()));
                break;
              }
              //<< . . . IF YART="D" IF YTYP=15 DO  QUIT                                     ;COLLECT
              if (mOp.Equal(YART.get(),"D")) {
                if (mOp.Equal(YTYP.get(),15)) {
                  //<< . . . . IF YINHALT'="" IF '$FIND(YINHALT,";") IF $LISTGET(YINHALT,1)'=""  DO
                  if (mOp.NotEqual(YINHALT.get(),"")) {
                    if (mOp.Not(m$.Fnc.$find(YINHALT.get(),";"))) {
                      if (mOp.NotEqual(m$.Fnc.$listget(YINHALT.get(),1),"")) {
                      }
                    }
                  }
                  //<< . . . . NEW YINHALT1,YI
                  mVar YINHALT1 = m$.var("YINHALT1");
                  m$.newVarBlock(4,YINHALT1,YI);
                  //<< . . . . SET YINHALT1=YINHALT
                  YINHALT1.set(YINHALT.get());
                  //<< . . . . SET YINHALT=""
                  YINHALT.set("");
                  //<< . . . . FOR YI=1:1 QUIT:$LISTGET(YINHALT1,YI)=""  SET YINHALT=YINHALT_$LISTGET(YINHALT1,YI)_";"  QUIT:$LENGTH(YINHALT)>30000
                  for (YI.set(1);(true);YI.set(mOp.Add(YI.get(),1))) {
                    if (mOp.Equal(m$.Fnc.$listget(YINHALT1.get(),YI.get()),"")) {
                      break;
                    }
                    YINHALT.set(mOp.Concat(mOp.Concat(YINHALT.get(),m$.Fnc.$listget(YINHALT1.get(),YI.get())),";"));
                    if (mOp.Greater(m$.Fnc.$length(YINHALT.get()),30000)) {
                      break;
                    }
                  }
                  break;
                }
                m$.restoreVarBlock(4);
              }
              //<< . . . IF YART="D" S YINHALT=$$^WWWFORMAT(YDATEI,"D",YLFN,YINHALT) QUIT  ;FORMAT  DATENFELDER
              if (mOp.Equal(YART.get(),"D")) {
                YINHALT.set(m$.fnc$("WWWFORMAT.main",YDATEI.get(),"D",YLFN.get(),YINHALT.get()));
                break;
              }
            } while (false);
          }
          m$.restoreVarBlock(3);
        }
        //<< . . ;
        //<< . . IF $GET(YART)="D" DO  ;IF YDATEI'="" IF YLINK=1 IF YKEY'="" DO
        if (mOp.Equal(m$.Fnc.$get(m$.var("YART")),"D")) {
          //<< . . . NEW YFORM,YKEY
          m$.newVarBlock(3,YFORM,YKEY);
          //<< . . . WRITE "<A"
          m$.Cmd.Write("<A");
          //<< . . . IF $GET(YTOOLTIP)=""  WRITE " TITLE="_""""_$$^WWWTEXT(374)_""""  ;DATENSATZ AUSWÄHLEN ;data record pick out
          if (mOp.Equal(m$.Fnc.$get(m$.var("YTOOLTIP")),"")) {
            m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(" TITLE=","\""),m$.fnc$("WWWTEXT.main",374)),"\""));
          }
          //<< . . . IF $GET(YTOOLTIP)'="" WRITE " TITLE="_""""_YTOOLTIP_""""         ;DATENSATZ AUSWÄHLEN ;data record pick out
          if (mOp.NotEqual(m$.Fnc.$get(m$.var("YTOOLTIP")),"")) {
            m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(" TITLE=","\""),m$.var("YTOOLTIP").get()),"\""));
          }
          //<< . . . WRITE " HREF="_""""_YAKTION_"EP=WWWFORM&amp;YFORM="_$get(YFORM) ;YDATEI
          m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(" HREF=","\""),m$.var("YAKTION").get()),"EP=WWWFORM&amp;YFORM="),m$.Fnc.$get(YFORM)));
          //<< . . . WRITE "&amp;YSEITE="_$GET(YSEITE)
          m$.Cmd.Write(mOp.Concat("&amp;YSEITE=",m$.Fnc.$get(m$.var("YSEITE"))));
          //<< . . . set YKEY=rset.GetData(1)   ; ;SR17074 treats first column as YKEY ONLY  ;FIXME could loop through the class and find out how many keys and then build accordingly
          YKEY.set(m$.fnc$(rset.getORef(),"GetData",1));
          //<< . . . DO ^WWWCGI
          m$.Cmd.Do("WWWCGI.main");
          //<< . . . WRITE """"_">"
          m$.Cmd.Write(mOp.Concat("\"",">"));
        }
        m$.restoreVarBlock(3);
        //<< . . ;
        //<< . . WRITE YINHALT
        m$.Cmd.Write(YINHALT.get());
        //<< . . IF YLINK=1 WRITE "</A>"
        if (mOp.Equal(YLINK.get(),1)) {
          m$.Cmd.Write("</A>");
        }
        //<< . . WRITE "&nbsp;"
        m$.Cmd.Write("&nbsp;");
        //<< . . WRITE "</TD>",YCR
        m$.Cmd.Write("</TD>",m$.var("YCR").get());
      }
    }
    //<< 
    //<< DO ^WWWFRAME(1)
    m$.Cmd.Do("WWWFRAME.main",1);
    //<< 
    //<< DO rset.Close()          ; Close this execution
    m$.Cmd.Do(rset.getORef(),"Close");
    //<< DO rset.%Close()         ; Close the rset object
    m$.Cmd.Do(rset.getORef(),"$Close");
    //<< QUIT
    return null;
  }

//<< 
//<< 
}
