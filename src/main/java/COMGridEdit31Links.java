//*****************************************************************************
//** TASC - ALPHALINC - MAC COMGridEdit31Links
//** Innovatium Systems - Code Converter - v1.29
//** 2014-06-03 20:55:39
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

//<< COMGridEdit31Links
public class COMGridEdit31Links extends mClass {

  //<< #def1arg WWWDATEN(%args)    ^WWWDATEN(YM,+$horolog,YUSER,$get(^CacheTemp(YUSER,"Grid","Name")," "),"V",%args)
  public static Object $$$WWWDATEN(mContext m$, Object ... _p) {
    mVar p$args = m$.varRef("p$args",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.var("^WWWDATEN",m$.var("YM").get(),mOp.Positive(m$.Fnc.$horolog()),m$.var("YUSER").get(),m$.Fnc.$get(m$.var("^CacheTemp",m$.var("YUSER").get(),"Grid","Name")," "),"V",p$args.get()).get());
  }

  public static mVar $$$WWWDATENVar(mContext m$, Object ... _p) {
    mVar p$args = m$.varRef("p$args",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.var("^WWWDATEN",m$.var("YM").get(),mOp.Positive(m$.Fnc.$horolog()),m$.var("YUSER").get(),m$.Fnc.$get(m$.var("^CacheTemp",m$.var("YUSER").get(),"Grid","Name")," "),"V",p$args.get()));
  }

  public void main() {
    _COMGridEdit31Links();
  }

  public void _COMGridEdit31Links() {
  }

  //<< 
  //<< UpdateHeader(YFORM,YROW)
  public Object UpdateHeader(Object ... _p) {
    mVar YFORM = m$.newVarRef("YFORM",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar YROW = m$.newVarRef("YROW",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Updates linked fields in the header based on the contents of a grid.
    //<< ;
    //<< ; Inputs:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 25-Jun-2012   SCR         SR18026: Removed Item field check
    //<< ; 19-Jun-2012   shobby      SR18026: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new YFELD,YMFELD,idField,intField,intPiece,YFORMCONTAINER
    mVar YFELD = m$.var("YFELD");
    mVar YMFELD = m$.var("YMFELD");
    mVar idField = m$.var("idField");
    mVar intField = m$.var("intField");
    mVar intPiece = m$.var("intPiece");
    mVar YFORMCONTAINER = m$.var("YFORMCONTAINER");
    m$.newVar(YFELD,YMFELD,idField,intField,intPiece,YFORMCONTAINER);
    //<< 
    //<< set YFELD = $$GetYFELD^COMGridEdit31G(YFORM,YROW)
    YFELD.set(m$.fnc$("COMGridEdit31G.GetYFELD",YFORM.get(),YROW.get()));
    //<< set YMFELD = $$GetYMFELDContainer^COMGridEdit31G()
    YMFELD.set(m$.fnc$("COMGridEdit31G.GetYMFELDContainer"));
    //<< set YFORMCONTAINER= $get(^CacheTemp(YUSER,"Grid","Container"))
    YFORMCONTAINER.set(m$.Fnc.$get(m$.var("^CacheTemp",m$.var("YUSER").get(),"Grid","Container")));
    //<< 
    //<< set idField="" for { set idField=$order(^CacheTemp(YUSER,"Grid","LinkedTo",idField)) quit:idField=""
    idField.set("");
    for (;true;) {
      idField.set(m$.Fnc.$order(m$.var("^CacheTemp",m$.var("YUSER").get(),"Grid","LinkedTo",idField.get())));
      if (mOp.Equal(idField.get(),"")) {
        break;
      }
      //<< set intField=$extract(idField,2,9999)
      intField.set(m$.Fnc.$extract(idField.get(),2,9999));
      //<< set intPiece=$get(^CacheTemp(YUSER,"Grid","LinkedTo",idField))
      intPiece.set(m$.Fnc.$get(m$.var("^CacheTemp",m$.var("YUSER").get(),"Grid","LinkedTo",idField.get())));
      //<< do PopulateDataField^COMUtils(YFORMCONTAINER,intField,$piece(YFELD,Y,intPiece),"M",YFELD,$$$NO)
      m$.Cmd.Do("COMUtils.PopulateDataField",YFORMCONTAINER.get(),intField.get(),m$.Fnc.$piece(YFELD.get(),m$.var("Y").get(),intPiece.get()),"M",YFELD.get(),include.COMSYS.$$$NO(m$));
    }
    //<< }
    //<< quit ""
    return "";
  }

  //<< 
  //<< 
  //<< UpdateGrid(pstrField,YINHALT,pstrOrigInput,pblnForce=0)
  public Object UpdateGrid(Object ... _p) {
    mVar pstrField = m$.newVarRef("pstrField",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar YINHALT = m$.newVarRef("YINHALT",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar pstrOrigInput = m$.newVarRef("pstrOrigInput",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    mVar pblnForce = m$.newVarRef("pblnForce",(((_p!=null)&&(_p.length>=4))?_p[3]:null),0);
    //<< ;-------------------------------------------------------------------------------
    //<< ;
    //<< ;
    //<< ; Inputs:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 25-Jun-2012   SCR         SR18026: Added force option to use YINHALT
    //<< ; 07-Jun-2012   shobby      SR18026: Created
    //<< ;-------------------------------------------------------------------------------
    //<< ;SR18026
    //<< new strField,intGridField,arrGrid,strGridForm,YKEY,YKEYCONTAINER,YROW,objWWW122
    mVar strField = m$.var("strField");
    mVar intGridField = m$.var("intGridField");
    mVar arrGrid = m$.var("arrGrid");
    mVar strGridForm = m$.var("strGridForm");
    mVar YKEY = m$.var("YKEY");
    mVar YKEYCONTAINER = m$.var("YKEYCONTAINER");
    mVar YROW = m$.var("YROW");
    mVar objWWW122 = m$.var("objWWW122");
    m$.newVar(strField,intGridField,arrGrid,strGridForm,YKEY,YKEYCONTAINER,YROW,objWWW122);
    //<< new YFELDCONTAINER,YMFELDCONTAINER,intHeaderField
    mVar YFELDCONTAINER = m$.var("YFELDCONTAINER");
    mVar YMFELDCONTAINER = m$.var("YMFELDCONTAINER");
    mVar intHeaderField = m$.var("intHeaderField");
    m$.newVar(YFELDCONTAINER,YMFELDCONTAINER,intHeaderField);
    //<< 
    //<< set YFELDCONTAINER=$$GetYFELDContainer^COMGridEdit31Interface()
    YFELDCONTAINER.set(m$.fnc$("COMGridEdit31Interface.GetYFELDContainer"));
    //<< set YMFELDCONTAINER=$$GetYMFELDContainer^COMGridEdit31Interface(1)
    YMFELDCONTAINER.set(m$.fnc$("COMGridEdit31Interface.GetYMFELDContainer",1));
    //<< set strGridField=""
    mVar strGridField = m$.var("strGridField");
    strGridField.set("");
    //<< set YKEY=""
    YKEY.set("");
    //<< 
    //<< if YFORM'="" {
    if (mOp.NotEqual(m$.var("YFORM").get(),"")) {
      //<< set strGridForm=$get(^CacheTemp(YUSER,"Grid","Name"))
      strGridForm.set(m$.Fnc.$get(m$.var("^CacheTemp",m$.var("YUSER").get(),"Grid","Name")));
      //<< if strGridForm'="" {
      if (mOp.NotEqual(strGridForm.get(),"")) {
        //<< set strField=$piece(pstrField,YFORM,2)
        strField.set(m$.Fnc.$piece(pstrField.get(),m$.var("YFORM").get(),2));
        //<< if strField'="" {
        if (mOp.NotEqual(strField.get(),"")) {
          //<< set intGridField=$get(^CacheTemp(YUSER,"Grid","LinkedTo",strField))
          intGridField.set(m$.Fnc.$get(m$.var("^CacheTemp",m$.var("YUSER").get(),"Grid","LinkedTo",strField.get())));
          //<< if intGridField'="" {
          if (mOp.NotEqual(intGridField.get(),"")) {
            //<< set intHeaderField=$extract(strField,2,99999)
            intHeaderField.set(m$.Fnc.$extract(strField.get(),2,99999));
            //<< set YKEYCONTAINER=$$$GRIDYKEYContainer
            YKEYCONTAINER.set(include.COMGridEdit31Interface.$$$GRIDYKEYContainer(m$));
            //<< set YROW=$piece($piece($$$WWWDATEN("FOCUSFIELD"),"Y",2),"_",1)
            YROW.set(m$.Fnc.$piece(m$.Fnc.$piece($$$WWWDATEN(m$,"FOCUSFIELD"),"Y",2),"_",1));
            //<< set YKEY=$piece($$GetYKEY^COMGridEdit31Interface(YROW),",",2)
            YKEY.set(m$.Fnc.$piece(m$.fnc$("COMGridEdit31Interface.GetYKEY",YROW.get()),",",2));
            //<< if YKEY'="" {
            if (mOp.NotEqual(YKEY.get(),"")) {
              //<< do GetGridContents^COMGridEdit31G(.arrGrid)  ;SR17779
              m$.Cmd.Do("COMGridEdit31G.GetGridContents",arrGrid);
              //<< set $piece(arrGrid(YKEYCONTAINER,YKEY),Y,intGridField)=$select('pblnForce:$piece(YMFELDCONTAINER,Y,intHeaderField),1:YINHALT)
              m$.pieceVar(arrGrid.var(YKEYCONTAINER.get(),YKEY.get()),m$.var("Y").get(),intGridField.get()).set(m$.Fnc.$select(mOp.Not(pblnForce.get()),m$.Fnc.$piece(YMFELDCONTAINER.get(),m$.var("Y").get(),intHeaderField.get()),1,YINHALT.get()));
              //<< do SetGridContents^COMGridEdit31G(.arrGrid)  ;SR17779
              m$.Cmd.Do("COMGridEdit31G.SetGridContents",arrGrid);
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
    //<< quit
    return null;
  }

  //<< 
  //<< GetLinkedTo()
  public Object GetLinkedTo(Object ... _p) {
    //<< ;-------------------------------------------------------------------------------
    //<< ;
    //<< ;
    //<< ; Inputs:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 08-Apr-2013   SCR         HEVA-877: Call Change Row if 'OnAfterRowChange' is defined
    //<< ; 07-Jun-2012   shobby      SR18026: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new idField,objWWW122,blnHasLinks
    mVar idField = m$.var("idField");
    mVar objWWW122 = m$.var("objWWW122");
    mVar blnHasLinks = m$.var("blnHasLinks");
    m$.newVar(idField,objWWW122,blnHasLinks);
    //<< 
    //<< set blnHasLinks=$$$NO
    blnHasLinks.set(include.COMSYS.$$$NO(m$));
    //<< set idField="" for { set idField=$order(^WWW122(0,YFORM,idField)) quit:idField=""
    idField.set("");
    for (;true;) {
      idField.set(m$.Fnc.$order(m$.var("^WWW122",0,m$.var("YFORM").get(),idField.get())));
      if (mOp.Equal(idField.get(),"")) {
        break;
      }
      //<< set objWWW122=$get(^WWW122(0,YFORM,idField,1))
      objWWW122.set(m$.Fnc.$get(m$.var("^WWW122",0,m$.var("YFORM").get(),idField.get(),1)));
      //<< if $$$WWW122LinkedTo(objWWW122)'="" {
      if (mOp.NotEqual(include.WWWConst.$$$WWW122LinkedTo(m$,objWWW122),"")) {
        //<< if $$$WWW122SequenceNumber(objWWW122)'="" {
        if (mOp.NotEqual(include.WWWConst.$$$WWW122SequenceNumber(m$,objWWW122),"")) {
          //<< set ^CacheTemp(YUSER,"Grid","LinkedTo",$$$WWW122LinkedTo(objWWW122))=$$$WWW122SequenceNumber(objWWW122)
          m$.var("^CacheTemp",m$.var("YUSER").get(),"Grid","LinkedTo",include.WWWConst.$$$WWW122LinkedTo(m$,objWWW122)).set(include.WWWConst.$$$WWW122SequenceNumber(m$,objWWW122));
          //<< set blnHasLinks=$$$YES
          blnHasLinks.set(include.COMSYS.$$$YES(m$));
        }
      }
    }
    //<< }
    //<< }
    //<< }
    //<< set:$data(^WWW120Hook(0,YFORM,$$$EnumWWWEVENTTYPEOnAfterRowChange)) blnHasLinks=$$$YES ; HEVA-875
    if (mOp.Logical(m$.Fnc.$data(m$.var("^WWW120Hook",0,m$.var("YFORM").get(),include.WWWConst.$$$EnumWWWEVENTTYPEOnAfterRowChange(m$))))) {
      blnHasLinks.set(include.COMSYS.$$$YES(m$));
    }
    //<< if blnHasLinks {
    if (mOp.Logical(blnHasLinks.get())) {
      //<< $$$StartScript()
      include.COMSYS.$$$StartScript(m$);
      //<< write " function callChangeRow(val) { return ChangeRow(val); }"
      m$.Cmd.Write(" function callChangeRow(val) { return ChangeRow(val); }");
      //<< $$$EndScript()
      include.COMSYS.$$$EndScript(m$);
    }
    //<< }
    //<< quit
    return null;
  }

  //<< 
  //<< IsLinkedTo(YBBN)
  public Object IsLinkedTo(Object ... _p) {
    mVar YBBN = m$.newVarRef("YBBN",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Used to determine if a particular selection control has links.  If so then
    //<< ; we populate all values, not just the selected value for a readonly control
    //<< ; ensuring that when other lines on the grid are selected the control populates
    //<< ; appropriately.
    //<< ;
    //<< ; Inputs:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 07-Jun-2012   shobby      SR18026: Created
    //<< ;-------------------------------------------------------------------------------
    //<< quit $data(^CacheTemp(YUSER,"Grid","LinkedTo","M"_YBBN))
    return m$.Fnc.$data(m$.var("^CacheTemp",m$.var("YUSER").get(),"Grid","LinkedTo",mOp.Concat("M",YBBN.get())));
  }

//<< 
//<< 
//<< 
//<< 
//<< 
//<< 
//<< 
}
