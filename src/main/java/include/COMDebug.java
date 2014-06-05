//*****************************************************************************
//** TASC - ALPHALINC - INC include.COMDebug
//** Innovatium Systems - Code Converter - v1.29
//** 2014-06-03 20:55:04
//*****************************************************************************

package include;

import mLibrary.*;


//<< ; COMDebug
//<< ;----------------------------------------------------------------------------------
//<< ; 11-Apr-2007  GRF     Remove obsolete users
//<< ; 12-Nov-2007  GRF     Revise Users
//<< ;----------------------------------------------------------------------------------
//<< 
public class COMDebug extends mInclude {

  //<< #define JournalOn   do $zu(139,0)
  public static Object $$$JournalOn(mContext m$) {
    m$.Fnc.$zutil(139,0);
    return null;
  }

  //<< #define JournalOff  do $zu(139,1)
  public static Object $$$JournalOff(mContext m$) {
    m$.Fnc.$zutil(139,1);
    return null;
  }

  //<< 
  //<< ; Could use a specific test for whether at POS or @NM
  //<< #define DevLowYBED          $g(%request.Data("YBED",1))
  public static Object $$$DevLowYBED(mContext m$) {
    return (m$.Fnc.$get(m$.getRequest().varData("YBED",1)));
  }

  //<< #define DevLowYUSER         $case($p($g(%request.Data("WARG_1",1)),".",2),"":$g(%request.Data("WARG_5",1)),:$p($g(%request.Data("WARG_1",1)),".",2))
  public static Object $$$DevLowYUSER(mContext m$) {
    return (m$.Fnc.$case(m$.Fnc.$piece(m$.Fnc.$get(m$.getRequest().varData("WARG_1",1)),".",2),"",m$.Fnc.$get(m$.getRequest().varData("WARG_5",1)),m$.Fnc.$piece(m$.Fnc.$get(m$.getRequest().varData("WARG_1",1)),".",2)));
  }

  //<< #define DevLowYBEDFromYUSER $p($g(^WWWUSER(0,$$$DevLowYUSER,1)),"~",2)
  public static Object $$$DevLowYBEDFromYUSER(mContext m$) {
    return (m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWWUSER",0,$$$DevLowYUSER(m$),1)),"~",2));
  }

  //<< 
  //<< ; Developer macros : if $$$DevUser { ... }
  //<< #define DevFrank            ($g(YBED)="FRANK")
  public static Object $$$DevFrank(mContext m$) {
    return ((mOp.Equal(m$.Fnc.$get(m$.var("YBED")),"FRANK")));
  }

  //<< #define DevHeber            ($g(YBED)="HEBER")
  public static Object $$$DevHeber(mContext m$) {
    return ((mOp.Equal(m$.Fnc.$get(m$.var("YBED")),"HEBER")));
  }

  //<< #define DevGlen             ($g(YBED)="GRF")
  public static Object $$$DevGlen(mContext m$) {
    return ((mOp.Equal(m$.Fnc.$get(m$.var("YBED")),"GRF")));
  }

  //<< #define DevPaulP            ($g(YBED)="PAULP")
  public static Object $$$DevPaulP(mContext m$) {
    return ((mOp.Equal(m$.Fnc.$get(m$.var("YBED")),"PAULP")));
  }

  //<< #define DevShobby           ($g(YBED)="SHOBBY")
  public static Object $$$DevShobby(mContext m$) {
    return ((mOp.Equal(m$.Fnc.$get(m$.var("YBED")),"SHOBBY")));
  }

  //<< #define DevSteveR           ($g(YBED)="STEVER")
  public static Object $$$DevSteveR(mContext m$) {
    return ((mOp.Equal(m$.Fnc.$get(m$.var("YBED")),"STEVER")));
  }

  //<< #define DevLuis             ($g(YBED)="LUIS")
  public static Object $$$DevLuis(mContext m$) {
    return ((mOp.Equal(m$.Fnc.$get(m$.var("YBED")),"LUIS")));
  }

  //<< #define DevGustavo          ($g(YBED)="GUSTAVO")
  public static Object $$$DevGustavo(mContext m$) {
    return ((mOp.Equal(m$.Fnc.$get(m$.var("YBED")),"GUSTAVO")));
  }

  //<< #define DevAndreas          ($g(YBED)="AFISCHER")
  public static Object $$$DevAndreas(mContext m$) {
    return ((mOp.Equal(m$.Fnc.$get(m$.var("YBED")),"AFISCHER")));
  }

  //<< 
  //<< 
  //<< #define SCH(%str)           set:$$$DevShobby ^zzSCH($i(^zzSCH))=%str
  public static Object $$$SCH(mContext m$, Object ... _p) {
    mVar p$str = m$.varRef("p$str",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    if (mOp.Logical($$$DevShobby(m$))) {
      m$.var("^zzSCH",m$.Fnc.$increment(m$.var("^zzSCH"))).set(p$str.get());
    }
    return null;
  }

  //<< #define SCHM(%str)          merge:$$$DevShobby ^zzSCH($i(^zzSCH))=%str
  public static Object $$$SCHM(mContext m$, Object ... _p) {
    mVar p$str = m$.varRef("p$str",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    if (mOp.Logical($$$DevShobby(m$))) {
      m$.Cmd.Merge(m$.var("^zzSCH",m$.Fnc.$increment(m$.var("^zzSCH"))),p$str);
    }
    return null;
  }

  //<< 
  //<< ; could use %KEY("YUSER") instead of $p($g(%REQUEST),".",2)
  //<< 
  //<< ;
  //<< ; $case($p($g(%request.Data("WARG_1",1)),".",2),"":$g(%request.Data("WARG_5",1)),:$p($g(%request.Data("WARG_1",1)),".",2)
  //<< ;
  //<< ; ^WWWUSER(0,,"~",2)
  //<< ; $p($g()
  //<< ; $g(%request.Data("YBED",1))
  //<< ;
  //<< 
  //<< ; #define DevRob           (($g(YBED)="ROB")||(($g(%request)'="")&&$case("ROB",$$$DevLowYBED:1,$case($$$DevLowYUSER,"":"",:$$$DevLowYBEDFromYUSER):1,:0)))
  //<< ; #define DevRob2          (($g(YBED)="ROB2")||(($g(%request)'="")&&$case("ROB2",$$$DevLowYBED:1,$case($$$DevLowYUSER,"":"",:$$$DevLowYBEDFromYUSER):1,:0)))
  //<< ; #define DevLowRob            (($get(%request)'="")&&(($g(%request.Data("YBED",1))="ROB")||($p($g(^WWWUSER(0,$p($g(%request.Data("WARG_1",1)),".",2),1)),"~",2)="ROB")))
  //<< ; #define DevLowRob2           (($get(%request)'="")&&(($g(%request.Data("YBED",1))="ROB2")||($p($g(^WWWUSER(0,$p($g(%request.Data("WARG_1",1)),".",2),1)),"~",2)="ROB2")))
  //<< ; #define DevRobHang           if $$$DevRob for %drl=1:1:100 hang 1
  //<< ; #define DevRob2Hang          if $$$DevRob2 for %drl2=1:1:100 hang 1
  //<< ; #define DevRobSet(%id,%str)      if $$$DevRob $$$JournalOff set ^zzRPW($i(^zzRPW)) = %id_":"_%str $$$JournalOn
  //<< ; #define DevRob2Set(%id,%str) if $$$DevRob2 $$$JournalOff set ^zzRPW2($i(^zzRPW2)) = %id_":"_%str $$$JournalOn
  //<< 
  //<< #define DevLowGlen          (($get(%request)'="")&&(($g(%request.Data("YBED",1))="GRF")||($p($g(^WWWUSER(0,$p($g(%request.Data("WARG_1",1)),".",2),1)),"~",2)="GRF")))
  public static Object $$$DevLowGlen(mContext m$) {
    return (((mOp.NotEqual(m$.Fnc.$get(m$.getRequest()),"")) && mOp.Logical(((mOp.Equal(m$.Fnc.$get(m$.getRequest().varData("YBED",1)),"GRF")) || (mOp.Equal(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWWUSER",0,m$.Fnc.$piece(m$.Fnc.$get(m$.getRequest().varData("WARG_1",1)),".",2),1)),"~",2),"GRF"))))));
  }

  //<< #define DevLowPaulP         (($get(%request)'="")&&(($g(%request.Data("YBED",1))="PAULP")||($p($g(^WWWUSER(0,$p($g(%request.Data("WARG_1",1)),".",2),1)),"~",2)="PAULP")))
  public static Object $$$DevLowPaulP(mContext m$) {
    return (((mOp.NotEqual(m$.Fnc.$get(m$.getRequest()),"")) && mOp.Logical(((mOp.Equal(m$.Fnc.$get(m$.getRequest().varData("YBED",1)),"PAULP")) || (mOp.Equal(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWWUSER",0,m$.Fnc.$piece(m$.Fnc.$get(m$.getRequest().varData("WARG_1",1)),".",2),1)),"~",2),"PAULP"))))));
  }

  //<< #define DevLowShobby        (($get(%request)'="")&&(($g(%request.Data("YBED",1))="SHOBBY")||($p($g(^WWWUSER(0,$p($g(%request.Data("WARG_1",1)),".",2),1)),"~",2)="SHOBBY")))
  public static Object $$$DevLowShobby(mContext m$) {
    return (((mOp.NotEqual(m$.Fnc.$get(m$.getRequest()),"")) && mOp.Logical(((mOp.Equal(m$.Fnc.$get(m$.getRequest().varData("YBED",1)),"SHOBBY")) || (mOp.Equal(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWWUSER",0,m$.Fnc.$piece(m$.Fnc.$get(m$.getRequest().varData("WARG_1",1)),".",2),1)),"~",2),"SHOBBY"))))));
  }

  //<< #define DevLowSteveR        (($get(%request)'="")&&(($g(%request.Data("YBED",1))="STEVER")||($p($g(^WWWUSER(0,$p($g(%request.Data("WARG_1",1)),".",2),1)),"~",2)="STEVER")))
  public static Object $$$DevLowSteveR(mContext m$) {
    return (((mOp.NotEqual(m$.Fnc.$get(m$.getRequest()),"")) && mOp.Logical(((mOp.Equal(m$.Fnc.$get(m$.getRequest().varData("YBED",1)),"STEVER")) || (mOp.Equal(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^WWWUSER",0,m$.Fnc.$piece(m$.Fnc.$get(m$.getRequest().varData("WARG_1",1)),".",2),1)),"~",2),"STEVER"))))));
  }

  //<< 
  //<< #define DevFrankHang        if $$$DevFrank for %dfl=1:1:100 hang 1
  public static Object $$$DevFrankHang(mContext m$) {
    if (mOp.Logical($$$DevFrank(m$))) {
      for (m$.var("%dfl").set(1);(mOp.LessOrEqual(m$.var("%dfl").get(),100));m$.var("%dfl").set(mOp.Add(m$.var("%dfl").get(),1))) {
        m$.Cmd.Hang(1);
      }
    }
    return null;
  }

  //<< #define DevHeberHang        if $$$DevHeber for %dfl=1:1:100 hang 1
  public static Object $$$DevHeberHang(mContext m$) {
    if (mOp.Logical($$$DevHeber(m$))) {
      for (m$.var("%dfl").set(1);(mOp.LessOrEqual(m$.var("%dfl").get(),100));m$.var("%dfl").set(mOp.Add(m$.var("%dfl").get(),1))) {
        m$.Cmd.Hang(1);
      }
    }
    return null;
  }

  //<< #define DevGlenHang         if $$$DevGlen for %dgl=1:1:100 hang 1
  public static Object $$$DevGlenHang(mContext m$) {
    if (mOp.Logical($$$DevGlen(m$))) {
      for (m$.var("%dgl").set(1);(mOp.LessOrEqual(m$.var("%dgl").get(),100));m$.var("%dgl").set(mOp.Add(m$.var("%dgl").get(),1))) {
        m$.Cmd.Hang(1);
      }
    }
    return null;
  }

  //<< #define DevshobbyHang       if $$$DevShobby for %dgl=1:1:100 hang 1
  public static Object $$$DevshobbyHang(mContext m$) {
    if (mOp.Logical($$$DevShobby(m$))) {
      for (m$.var("%dgl").set(1);(mOp.LessOrEqual(m$.var("%dgl").get(),100));m$.var("%dgl").set(mOp.Add(m$.var("%dgl").get(),1))) {
        m$.Cmd.Hang(1);
      }
    }
    return null;
  }

  //<< #define DevLuisHang         if $$$DevLuis for %dgl=1:1:100 hang 1
  public static Object $$$DevLuisHang(mContext m$) {
    if (mOp.Logical($$$DevLuis(m$))) {
      for (m$.var("%dgl").set(1);(mOp.LessOrEqual(m$.var("%dgl").get(),100));m$.var("%dgl").set(mOp.Add(m$.var("%dgl").get(),1))) {
        m$.Cmd.Hang(1);
      }
    }
    return null;
  }

  //<< #define DevGustavoHang      if $$$DevGustavo for %dgl=1:1:100 hang 1
  public static Object $$$DevGustavoHang(mContext m$) {
    if (mOp.Logical($$$DevGustavo(m$))) {
      for (m$.var("%dgl").set(1);(mOp.LessOrEqual(m$.var("%dgl").get(),100));m$.var("%dgl").set(mOp.Add(m$.var("%dgl").get(),1))) {
        m$.Cmd.Hang(1);
      }
    }
    return null;
  }

  //<< #define DevAndreasHang      if $$$DevAndreas for %dgl=1:1:100 hang 1
  public static Object $$$DevAndreasHang(mContext m$) {
    if (mOp.Logical($$$DevAndreas(m$))) {
      for (m$.var("%dgl").set(1);(mOp.LessOrEqual(m$.var("%dgl").get(),100));m$.var("%dgl").set(mOp.Add(m$.var("%dgl").get(),1))) {
        m$.Cmd.Hang(1);
      }
    }
    return null;
  }

  //<< 
  //<< //#define DevGlenSet(%id,%str)  if $$$DevGlen $$$JournalOff set ^zzGRF($i(^zzGRF)) = %id_":"_%str $$$JournalOn
  //<< //#define DevGlenAlt(%amt)      if $$$DevGlen $$$Alert("!"_%amt)
  //<< //#define DevGlenMerge(%id,%str)    if $$$DevGlen $$$JournalOff merge ^zzGRF($i(^zzGRF)) = %id_":"_%str $$$JournalOn
  //<< //#define DevAndreasMerge(%id,%str) if $$$DevAndreas $$$JournalOff merge ^zzAF($i(^zzAF)) = %id_":"_%str $$$JournalOn
  //<< 
  //<< #define debugMsg(%str)      if +$get(^SysSetup("js debug"))'=0 w "if (typeof(debugMsg)=='function') debugMsg('"_$zconvert(%str,"o","JS")_"');"
  public static Object $$$debugMsg(mContext m$, Object ... _p) {
    mVar p$str = m$.varRef("p$str",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    if (mOp.NotEqual(mOp.Positive(m$.Fnc.$get(m$.var("^SysSetup","js debug"))),0)) {
      m$.Cmd.Write(mOp.Concat(mOp.Concat("if (typeof(debugMsg)=='function') debugMsg('",m$.Fnc.$zconvert(p$str.get(),"o","JS")),"');"));
    }
    return null;
  }

//<< 
//<< // ***********************************************
}
