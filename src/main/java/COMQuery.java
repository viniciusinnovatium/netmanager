//*****************************************************************************
//** TASC - ALPHALINC - MAC COMQuery
//** Innovatium Systems - Code Converter - v1.27
//** 2014-05-22 00:15:27
//*****************************************************************************

import mLibrary.*;

//<< 
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

//<< COMQuery ; Query
public class COMQuery extends mClass {

  public void main() {
    _COMQuery();
  }

  public void _COMQuery() {
  }

  //<< 
  //<< ;-------------------------------------------------------------------------------
  //<< ; Description
  //<< ;
  //<< ; 1.  Uses the "Loop" entry to build a list in @Storage;
  //<< ;     counts the number of lines found.                             [GetData]
  //<< ; 2.  Uses count to determine whether mutiple pages are required
  //<< ;     - if so provide Page Group.                                   [Pages]
  //<< ; 3.  Display column headings
  //<< ; 4.  Loop through @Storage lines - Extract as id()
  //<< ; 5.     Retrieve basic data as variable 'id'.
  //<< ; 6.     Prepare to Highlight as required.
  //<< ; 7.     Retrieve secondary data for "Ref" entries as function
  //<< ;        or actual data location.
  //<< ; 8.     Create a new line on the table
  //<< ; 9.     Build and display each Column                              [Col]
  //<< ;        Entries *may* link to other forms
  //<< ;
  //<< ; NOTE : If a Page Link is used to display additional lines, the
  //<< ;        current form is replaced by a fresh copy with the browser
  //<< ;        variable %("%KEY","QueryPage") set to PageNo_":"_QueryName
  //<< ;        The Query array is cleared and rebuilt so is unsuitable
  //<< ;        to preserve values from page to page.
  //<< ;
  //<< ;        The routine called to process the form needs to manage
  //<< ;        this independently of THIS routine.
  //<< ;
  //<< ;        Do not use ^mtemp("Query",$job,Query("Name")) as this is
  //<< ;        the top level of @Storage which is used for the line count.
  //<< ;        Similarly ^mtemp("Query",$job,Query("Name"),0) contains a
  //<< ;        key string to identify a changed query.  [ @Storage@(0) ]
  //<< ;
  //<< ;        The suggested solution is to put them in
  //<< ;        @Storage@("Save",SaveType) as this will be outside the
  //<< ;        numerical range used by Line in the subroutine Query.
  //<< ;
  //<< ; History
  //<< ; 08-Oct-2004   GRF     SR10464 : Documentation added
  //<< ;-------------------------------------------------------------------------------
  //<< 
  //<< Query(&Query,&VORG)
  public Object Query(Object ... _p) {
    mVar Query = m$.newVarRef("Query",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar VORG = m$.newVarRef("VORG",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Main Query Entry Point
    //<< ;   Display a Table
    //<< ;   Handles multiple pages
    //<< ;
    //<< ; ByRef : Query  - Array of Query Parameters
    //<< ; Query("Name")  - Query Name
    //<< ; Query("Class") - Default Class
    //<< ; Query("Form")  - Form for Link back (Current Form)
    //<< ; Query("Loop")  - Call back code for building the list of rows
    //<< ; Query("Link")  - Default Link, Y delimited
    //<< ;                1 - Form Name to link to (@Code for execute)
    //<< ;                2 - Field Type (P or D)
    //<< ;                3 - Field Number
    //<< ; Query("Get")   - Get Record execute Code, sets id
    //<< ;                  If it is necessary to modify some data item for display
    //<< ;                  purposes (e.g. if a text entry contains a date string),
    //<< ;                  pass id into a routine to update the value, returning the
    //<< ;                  new id
    //<< ;                   - returning the whole id -
    //<< ; Query("Col",Num) - Column Data, Y delimited
    //<< ;                1 - Field Type (P or D)
    //<< ;                2 - Field Number
    //<< ;                3 - Alignment Left or Right (L, C or R)
    //<< ;                4 - Reference Flag (R, L or Null) [reference or link]
    //<< ;                5 - Reference Class
    //<< ;                6 - Reference Data - links with Query("Ref",Ref)
    //<< ;                7 - Default Data if it is extracted as NULL.
    //<< ;                8 - Column Heading
    //<< ;                9 - No Data Format (1 = Dont format the data)
    //<< ; Query("Col",Num,"Link") - Column Link, overides default, same format
    //<< ; Query("Col",Num,"DoInstead") - Code to handle writing out cell content
    //<< ; Query("Ref",Ref)  - Execute code to set Reference data
    //<< ; Query("PageSize") - Number of records to show on a page. (Default 100)
    //<< ; Query("Title") - Heading to be displayed above the grid
    //<< ;
    //<< ; ByRef : VORG - Parameters
    //<< ;
    //<< ; History
    //<< ; 20-Mar-2012   SCR     SR17993: Added 'No Data format' and center option
    //<< ; 12-Oct-2005   JW      SR13671: Added "Title"
    //<< ; 08-Oct-2004   GRF     SR10464 : 'Pages' was displaying too many page numbers
    //<< ;                       because End was returning other than a count of the lines.
    //<< ;                       This could generate an UNDEFINED error when trying to
    //<< ;                       execute the "Get" command.
    //<< ; 29-Apr-2004   shobby  If the Reference is to a method call then don't use a
    //<< ;                       get around the returned value. (TR007245)
    //<< ; 20-May-2003   SCR     New Change
    //<< ;-------------------------------------------------------------------------------
    //<< new ANZM,blnHighlight,Class,Col,ColSpec,count,DataString,End,id,Line
    mVar ANZM = m$.var("ANZM");
    mVar blnHighlight = m$.var("blnHighlight");
    mVar Class = m$.var("Class");
    mVar Col = m$.var("Col");
    mVar ColSpec = m$.var("ColSpec");
    mVar count = m$.var("count");
    mVar DataString = m$.var("DataString");
    mVar End = m$.var("End");
    mVar id = m$.var("id");
    mVar Line = m$.var("Line");
    m$.newVar(ANZM,blnHighlight,Class,Col,ColSpec,count,DataString,End,id,Line);
    //<< new PageSize,QueryName,Ref,RefType,Start,Storage,strHeading,YDDSATZ
    mVar PageSize = m$.var("PageSize");
    mVar QueryName = m$.var("QueryName");
    mVar Ref = m$.var("Ref");
    mVar RefType = m$.var("RefType");
    mVar Start = m$.var("Start");
    mVar Storage = m$.var("Storage");
    mVar strHeading = m$.var("strHeading");
    mVar YDDSATZ = m$.var("YDDSATZ");
    m$.newVar(PageSize,QueryName,Ref,RefType,Start,Storage,strHeading,YDDSATZ);
    //<< 
    //<< // TODO: Investigate safety of having $job in the subscript for ^mtemp
    //<< 
    //<< set ANZM       = 0
    ANZM.set(0);
    //<< set YDDSATZ    = 1
    YDDSATZ.set(1);
    //<< set strHeading = ""
    strHeading.set("");
    //<< set Col        = ""
    Col.set("");
    //<< set PageSize   = $get(Query("PageSize"))
    PageSize.set(m$.Fnc.$get(Query.var("PageSize")));
    //<< if 'PageSize set PageSize = 100
    if (mOp.Not(PageSize.get())) {
      PageSize.set(100);
    }
    //<< 
    //<< ; Get Data
    //<< 
    //<< set QueryName = $get(Query("Name"))
    QueryName.set(m$.Fnc.$get(Query.var("Name")));
    //<< if (QueryName="") set QueryName = " "
    if ((mOp.Equal(QueryName.get(),""))) {
      QueryName.set(" ");
    }
    //<< set Storage   = "^mtemp(""Query"","_$job_","""_QueryName_""")"
    Storage.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("^mtemp(\"Query\",",m$.Fnc.$job()),",\""),QueryName.get()),"\")"));
    //<< Do GetData(.Query,Storage)
    m$.Cmd.Do("GetData",Query,Storage.get());
    //<< 
    //<< if $get(Query("Title"))'="" {       //SR13671
    if (mOp.NotEqual(m$.Fnc.$get(Query.var("Title")),"")) {
      //<< write YCR,"<br><FONT SIZE=2><B>&nbsp;",Query("Title"),"</B></FONT>"
      m$.Cmd.Write(m$.var("YCR").get(),"<br><FONT SIZE=2><B>&nbsp;",Query.var("Title").get(),"</B></FONT>");
    }
    //<< }
    //<< 
    //<< do ^WWWFRAME(0)
    m$.Cmd.Do("WWWFRAME.main",0);
    //<< 
    //<< set Start = 1
    Start.set(1);
    //<< set End   = $piece($get(@Storage),Y,1)
    End.set(m$.Fnc.$piece(m$.Fnc.$get(m$.indirectVar(Storage.get())),m$.var("Y").get(),1));
    //<< 
    //<< if End>PageSize do Pages(End,PageSize,.Query,.Start,.End)
    if (mOp.Greater(End.get(),PageSize.get())) {
      m$.Cmd.Do("Pages",End.get(),PageSize.get(),Query,Start,End);
    }
    //<< 
    //<< for  {
    for (;true;) {
      //<< set Col = $order(Query("Col",Col))
      Col.set(m$.Fnc.$order(Query.var("Col",Col.get())));
      //<< quit:Col=""
      if (mOp.Equal(Col.get(),"")) {
        break;
      }
      //<< 
      //<< set ColSpec=Query("Col",Col)
      ColSpec.set(Query.var("Col",Col.get()).get());
      //<< set Class=""
      Class.set("");
      //<< if $piece(ColSpec,Y,8)'="" {
      if (mOp.NotEqual(m$.Fnc.$piece(ColSpec.get(),m$.var("Y").get(),8),"")) {
        //<< set $piece(strHeading,Y,Col) = $piece(ColSpec,Y,8)
        m$.pieceVar(strHeading,m$.var("Y").get(),Col.get()).set(m$.Fnc.$piece(ColSpec.get(),m$.var("Y").get(),8));
      }
      //<< } else {
      else {
        //<< if $piece(ColSpec,Y,4)="R" set Class = $piece(ColSpec,Y,5)  ; Referenced Data Class
        if (mOp.Equal(m$.Fnc.$piece(ColSpec.get(),m$.var("Y").get(),4),"R")) {
          Class.set(m$.Fnc.$piece(ColSpec.get(),m$.var("Y").get(),5));
        }
        //<< if Class=""                set Class = $get(Query("Class"))
        if (mOp.Equal(Class.get(),"")) {
          Class.set(m$.Fnc.$get(Query.var("Class")));
        }
        //<< set $piece(strHeading,Y,Col) = $$^WWWFELDNAME(Class,$extract($piece(ColSpec,Y,1)),$piece(ColSpec,Y,2))
        m$.pieceVar(strHeading,m$.var("Y").get(),Col.get()).set(m$.fnc$("WWWFELDNAME.main",Class.get(),m$.Fnc.$extract(m$.Fnc.$piece(ColSpec.get(),m$.var("Y").get(),1)),m$.Fnc.$piece(ColSpec.get(),m$.var("Y").get(),2)));
      }
    }
    //<< }
    //<< }
    //<< do FF^WWWW()  ;FORMFEED
    m$.Cmd.Do("WWWW.FF");
    //<< do START100^WWWTAB
    m$.Cmd.Do("WWWTAB.START100");
    //<< do HEADER^WWWTAB(strHeading)
    m$.Cmd.Do("WWWTAB.HEADER",strHeading.get());
    //<< 
    //<< set count=""
    count.set("");
    //<< for Line=Start:1:End {
    for (Line.set(Start.get());(mOp.LessOrEqual(Line.get(),End.get()));Line.set(mOp.Add(Line.get(),1))) {
      //<< kill id
      id.kill();
      //<< merge id = ^mtemp("Query",$job,QueryName,Line)
      m$.Cmd.Merge(id,m$.var("^mtemp","Query",m$.Fnc.$job(),QueryName.get(),Line.get()));
      //<< if '$data(id) continue                          ; SR10464
      if (mOp.Not(m$.Fnc.$data(id))) {
        continue;
      }
      //<< // TODO : Consider appropriate error message rather than skipping <GRF>
      //<< 
      //<< xecute Query("Get")  ; Set id
      m$.Cmd.Xecute(Query.var("Get").get());
      //<< 
      //<< ; based on id, determine whether to highlight line.
      //<< set blnHighlight = 0
      blnHighlight.set(0);
      //<< if $data(Query("Highlight")) xecute Query("Highlight")
      if (mOp.Logical(m$.Fnc.$data(Query.var("Highlight")))) {
        m$.Cmd.Xecute(Query.var("Highlight").get());
      }
      //<< 
      //<< set DataString = id
      DataString.set(id.get());
      //<< set Ref = ""
      Ref.set("");
      //<< for  {
      for (;true;) {
        //<< set Ref = $order(Query("Ref",Ref))
        Ref.set(m$.Fnc.$order(Query.var("Ref",Ref.get())));
        //<< quit:Ref=""
        if (mOp.Equal(Ref.get(),"")) {
          break;
        }
        //<< 
        //<< if $extract(Query("Ref",Ref),1,2)="$$" {
        if (mOp.Equal(m$.Fnc.$extract(Query.var("Ref",Ref.get()).get(),1,2),"$$")) {
          //<< xecute "Set Ref(Ref)="_Query("Ref",Ref)             ; 29-Apr-2004
          m$.Cmd.Xecute(mOp.Concat("Set Ref(Ref)=",Query.var("Ref",Ref.get()).get()));
        }
        //<< } else {
        else {
          //<< xecute "Set Ref(Ref)=$get("_Query("Ref",Ref)_")"
          m$.Cmd.Xecute(mOp.Concat(mOp.Concat("Set Ref(Ref)=$get(",Query.var("Ref",Ref.get()).get()),")"));
        }
      }
      //<< }
      //<< }
      //<< 
      //<< set Col=""
      Col.set("");
      //<< do NL^WWWTAB
      m$.Cmd.Do("WWWTAB.NL");
      //<< for {
      for (;true;) {
        //<< set Col=$order(Query("Col",Col))
        Col.set(m$.Fnc.$order(Query.var("Col",Col.get())));
        //<< quit:Col=""
        if (mOp.Equal(Col.get(),"")) {
          break;
        }
        //<< 
        //<< do Col(.Query,Col,.id,.Ref,blnHighlight)
        m$.Cmd.Do("Col",Query,Col.get(),id,Ref,blnHighlight.get());
      }
      //<< }
      //<< do EL^WWWTAB
      m$.Cmd.Do("WWWTAB.EL");
    }
    //<< }
    //<< do ^WWWFRAME(1)
    m$.Cmd.Do("WWWFRAME.main",1);
    //<< 
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< Col(&Query,Col,&id,&Ref,pblnHighlight)
  public Object Col(Object ... _p) {
    mVar Query = m$.newVarRef("Query",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar Col = m$.newVarRef("Col",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar id = m$.newVarRef("id",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    mVar Ref = m$.newVarRef("Ref",(((_p!=null)&&(_p.length>=4))?_p[3]:null));
    mVar pblnHighlight = m$.newVarRef("pblnHighlight",(((_p!=null)&&(_p.length>=5))?_p[4]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ;
    //<< ; History
    //<< ;
    //<< ; 20-Mar-2012   SCR     SR17993: Added 'No Data Format' and center options
    //<< ; 16-Oct-2006   PO      SR15122: DoInstead code now returns string
    //<< ; 05-May-2006   PO      SR14427: Allow link drawn out to be done by foreign code
    //<< ;                           (Phase 2)
    //<< ; 13-Sep-2005   RPW     SR13306: Added the ability to handle checkboxes with a
    //<< ;                           call back. If we are a checkbox, dont write out the
    //<< ;                           hyperlink
    //<< ; 29-Apr-2004   shobby  TR007245: Included a default value when there is no data
    //<< ;-------------------------------------------------------------------------------
    //<< new Class,ColSpec,Data,Form,Format,Link,LinkData,NextId,strDoInstead
    mVar Class = m$.var("Class");
    mVar ColSpec = m$.var("ColSpec");
    mVar Data = m$.var("Data");
    mVar Form = m$.var("Form");
    mVar Format = m$.var("Format");
    mVar Link = m$.var("Link");
    mVar LinkData = m$.var("LinkData");
    mVar NextId = m$.var("NextId");
    mVar strDoInstead = m$.var("strDoInstead");
    m$.newVar(Class,ColSpec,Data,Form,Format,Link,LinkData,NextId,strDoInstead);
    //<< new RefData,RefType,Source,strDefault,tmpGray,tmpWhite,CheckBox,idKey,idRecord
    mVar RefData = m$.var("RefData");
    mVar RefType = m$.var("RefType");
    mVar Source = m$.var("Source");
    mVar strDefault = m$.var("strDefault");
    mVar tmpGray = m$.var("tmpGray");
    mVar tmpWhite = m$.var("tmpWhite");
    mVar CheckBox = m$.var("CheckBox");
    mVar idKey = m$.var("idKey");
    mVar idRecord = m$.var("idRecord");
    m$.newVar(RefData,RefType,Source,strDefault,tmpGray,tmpWhite,CheckBox,idKey,idRecord);
    //<< new blnNoFormat
    mVar blnNoFormat = m$.var("blnNoFormat");
    m$.newVar(blnNoFormat);
    //<< 
    //<< set ColSpec = $get(Query("Col",Col))
    ColSpec.set(m$.Fnc.$get(Query.var("Col",Col.get())));
    //<< set Link    = $get(Query("Col",Col,"Link"))
    Link.set(m$.Fnc.$get(Query.var("Col",Col.get(),"Link")));
    //<< if Link="" set Link = $get(Query("Link"))
    if (mOp.Equal(Link.get(),"")) {
      Link.set(m$.Fnc.$get(Query.var("Link")));
    }
    //<< 
    //<< set CheckBox     = $get(Query("Col",Col,"CheckBox")) ; SR13306
    CheckBox.set(m$.Fnc.$get(Query.var("Col",Col.get(),"CheckBox")));
    //<< set strDoInstead = $get(Query("Col",Col,"DoInstead")) ; SR14427 (Phase 2)
    strDoInstead.set(m$.Fnc.$get(Query.var("Col",Col.get(),"DoInstead")));
    //<< 
    //<< set Source     = $piece(ColSpec,Y,1,2)
    Source.set(m$.Fnc.$piece(ColSpec.get(),m$.var("Y").get(),1,2));
    //<< set Format     = $piece(ColSpec,Y,3)
    Format.set(m$.Fnc.$piece(ColSpec.get(),m$.var("Y").get(),3));
    //<< set RefType    = $piece(ColSpec,Y,4)
    RefType.set(m$.Fnc.$piece(ColSpec.get(),m$.var("Y").get(),4));
    //<< set RefData    = $piece(ColSpec,Y,6)
    RefData.set(m$.Fnc.$piece(ColSpec.get(),m$.var("Y").get(),6));
    //<< set strDefault = $piece(ColSpec,Y,7)
    strDefault.set(m$.Fnc.$piece(ColSpec.get(),m$.var("Y").get(),7));
    //<< set Form       = $piece(ColSpec,Y,5)
    Form.set(m$.Fnc.$piece(ColSpec.get(),m$.var("Y").get(),5));
    //<< set blnNoFormat= $piece(ColSpec,Y,9) ;SR17993
    blnNoFormat.set(m$.Fnc.$piece(ColSpec.get(),m$.var("Y").get(),9));
    //<< set Class=""
    Class.set("");
    //<< if RefType="R" set Class = $piece(ColSpec,Y,5)  ; Referenced Data Class
    if (mOp.Equal(RefType.get(),"R")) {
      Class.set(m$.Fnc.$piece(ColSpec.get(),m$.var("Y").get(),5));
    }
    //<< if Class=""    set Class = $get(Query("Class"))
    if (mOp.Equal(Class.get(),"")) {
      Class.set(m$.Fnc.$get(Query.var("Class")));
    }
    //<< 
    //<< if RefData'="" {
    if (mOp.NotEqual(RefData.get(),"")) {
      //<< set Data = $$Data(Ref(RefData),Source,Class,,blnNoFormat)   ;SR17993
      Data.set(m$.fnc$("Data",Ref.var(RefData.get()).get(),Source.get(),Class.get(),null,blnNoFormat.get()));
    }
    //<< } else {
    else {
      //<< set Data = $$Data(.id,Source,Class,,blnNoFormat)            ;SR17993
      Data.set(m$.fnc$("Data",id,Source.get(),Class.get(),null,blnNoFormat.get()));
    }
    //<< }
    //<< if Data="" set Data = strDefault
    if (mOp.Equal(Data.get(),"")) {
      Data.set(strDefault.get());
    }
    //<< 
    //<< set LinkData = ""
    LinkData.set("");
    //<< if RefType="L" { ; Link Ref Type
    if (mOp.Equal(RefType.get(),"L")) {
      //<< set LinkData = Data
      LinkData.set(Data.get());
      //<< set Data     = "Link"
      Data.set("Link");
    }
    //<< }
    //<< set:'blnNoFormat Data = $zconvert(Data,"O","HTML")  ; Convert '>' to &gt etc. ; SR17993
    if (mOp.Not(blnNoFormat.get())) {
      Data.set(m$.Fnc.$zconvert(Data.get(),"O","HTML"));
    }
    //<< ;set Data = $zconvert(Data,"O","HTML")  ; Convert '>' to &gt etc.
    //<< if Data="" set Data = "&nbsp;"
    if (mOp.Equal(Data.get(),"")) {
      Data.set("&nbsp;");
    }
    //<< 
    //<< set tmpGray =YGRAY
    tmpGray.set(m$.var("YGRAY").get());
    //<< set tmpWhite=YWHITE
    tmpWhite.set(m$.var("YWHITE").get());
    //<< if pblnHighlight {
    if (mOp.Logical(pblnHighlight.get())) {
      //<< set YWHITE="lightgreen"
      mVar YWHITE = m$.var("YWHITE");
      YWHITE.set("lightgreen");
      //<< set YGRAY ="lightgreen"
      mVar YGRAY = m$.var("YGRAY");
      YGRAY.set("lightgreen");
    }
    //<< }
    //<< ; SR17993 vvvv
    //<< if Format="L" {
    if (mOp.Equal(Format.get(),"L")) {
      //<< do NFL^WWWTAB
      m$.Cmd.Do("WWWTAB.NFL");
    }
    //<< } elseif Format="C" {
    else if (mOp.Equal(Format.get(),"C")) {
      //<< do NFZ^WWWTAB
      m$.Cmd.Do("WWWTAB.NFZ");
    }
    //<< } else {
    else {
      //<< do NFR^WWWTAB
      m$.Cmd.Do("WWWTAB.NFR");
    }
    //<< }
    //<< ; SR17993 ^^^^
    //<< ;if Format="L"  do NFL^WWWTAB
    //<< ;if Format'="L" do NFR^WWWTAB
    //<< 
    //<< write "&nbsp;"
    m$.Cmd.Write("&nbsp;");
    //<< write "<FONT SIZE=2>"
    m$.Cmd.Write("<FONT SIZE=2>");
    //<< ;write "id="_
    //<< 
    //<< set YGRAY  = tmpGray
    mVar YGRAY = m$.var("YGRAY");
    YGRAY.set(tmpGray.get());
    //<< set YWHITE = tmpWhite
    mVar YWHITE = m$.var("YWHITE");
    YWHITE.set(tmpWhite.get());
    //<< 
    //<< if strDoInstead="" { // SR14427 (Phase 2)
    if (mOp.Equal(strDoInstead.get(),"")) {
      //<< if Link'="" {
      if (mOp.NotEqual(Link.get(),"")) {
        //<< set LinkData = ""
        LinkData.set("");
        //<< set Form     = $piece(Link,Y,1)
        Form.set(m$.Fnc.$piece(Link.get(),m$.var("Y").get(),1));
        //<< set NextId   = $$Data(.id,$piece(Link,Y,2,3))
        NextId.set(m$.fnc$("Data",id,m$.Fnc.$piece(Link.get(),m$.var("Y").get(),2,3)));
        //<< if CheckBox="" { ; SR13306
        if (mOp.Equal(CheckBox.get(),"")) {
          //<< do Link(Form,NextId)
          m$.Cmd.Do("Link",Form.get(),NextId.get());
        }
      }
      //<< }
      //<< }
      //<< 
      //<< if LinkData'="" {
      if (mOp.NotEqual(LinkData.get(),"")) {
        //<< set Form   = $piece(LinkData,",",1)
        Form.set(m$.Fnc.$piece(LinkData.get(),",",1));
        //<< set NextId = $piece(LinkData,",",2,9)
        NextId.set(m$.Fnc.$piece(LinkData.get(),",",2,9));
        //<< set Link   = LinkData
        Link.set(LinkData.get());
        //<< do Link(Form,NextId)
        m$.Cmd.Do("Link",Form.get(),NextId.get());
      }
      //<< }
      //<< 
      //<< ; SR13306 Handle the checkbox instead of the YES/NO hyperlink.
      //<< if '$get(Query("Locked"),0) && (CheckBox'="") {
      if (mOp.Not(m$.Fnc.$get(Query.var("Locked"),0)) && (mOp.NotEqual(CheckBox.get(),""))) {
        //<< set Data     = $select(Data="Yes":1,1:0) ; Handle Old Data.
        Data.set(m$.Fnc.$select(mOp.Equal(Data.get(),"Yes"),1,1,0));
        //<< set idKey    = $piece(NextId,Y,1)
        idKey.set(m$.Fnc.$piece(NextId.get(),m$.var("Y").get(),1));
        //<< set idRecord = $piece(NextId,Y,2)
        idRecord.set(m$.Fnc.$piece(NextId.get(),m$.var("Y").get(),2));
        //<< write "<input type=checkbox "_$select(Data=1:"CHECKED",1:"")_" onclick='EventValue("""_YUCI_""","""_YUSER_""","""_YFORM_""",""FIX"","""_CheckBox_""","""_idKey_""",""6"","""_idRecord_"""+this.checked);'>"
        m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<input type=checkbox ",m$.Fnc.$select(mOp.Equal(Data.get(),1),"CHECKED",1,""))," onclick='EventValue(\""),m$.var("YUCI").get()),"\",\""),m$.var("YUSER").get()),"\",\""),m$.var("YFORM").get()),"\",\"FIX\",\""),CheckBox.get()),"\",\""),idKey.get()),"\",\"6\",\""),idRecord.get()),"\"+this.checked);'>"));
      }
      //<< } else {
      else {
        //<< write Data
        m$.Cmd.Write(Data.get());
      }
      //<< }
      //<< if Link'="" {
      if (mOp.NotEqual(Link.get(),"")) {
        //<< write "</A>"
        m$.Cmd.Write("</A>");
      }
    }
    //<< }
    //<< } else {
    else {
      //<< xecute "write $$"_strDoInstead_"("""_Col_""","""_Data_""")" // SR15122
      m$.Cmd.Xecute(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("write $$",strDoInstead.get()),"(\""),Col.get()),"\",\""),Data.get()),"\")"));
    }
    //<< }
    //<< write "&nbsp;"
    m$.Cmd.Write("&nbsp;");
    //<< do EF^WWWTAB
    m$.Cmd.Do("WWWTAB.EF");
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< Data(&Record,Field,Class,Blank,pblnNoFormat=0)
  public Object Data(Object ... _p) {
    mVar Record = m$.newVarRef("Record",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar Field = m$.newVarRef("Field",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar Class = m$.newVarRef("Class",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    mVar Blank = m$.newVarRef("Blank",(((_p!=null)&&(_p.length>=4))?_p[3]:null));
    mVar pblnNoFormat = m$.newVarRef("pblnNoFormat",(((_p!=null)&&(_p.length>=5))?_p[4]:null),0);
    //<< ;-------------------------------------------------------------------------------
    //<< ; Get Data from Source
    //<< ;   Record - Data
    //<< ;   Field - Type & Number
    //<< ;   Class - Used for formating, No Class = No Formatting
    //<< ;   Blank - Return Blank if Data is Null, Used for Referenced data
    //<< ;
    //<< ; History
    //<< ; 20-Mar-2012   SCR     SR17993: No Format Option
    //<< ; 20-Aug-2004   shobby  SR10265: Pass in the 'Return' parameter to WWWFORMAT to
    //<< ;                           specify the relation.
    //<< ;-------------------------------------------------------------------------------
    //<< new Cnt,Data,End,Index,Return,Start,Type
    mVar Cnt = m$.var("Cnt");
    mVar Data = m$.var("Data");
    mVar End = m$.var("End");
    mVar Index = m$.var("Index");
    mVar Return = m$.var("Return");
    mVar Start = m$.var("Start");
    mVar Type = m$.var("Type");
    m$.newVar(Cnt,Data,End,Index,Return,Start,Type);
    //<< 
    //<< 
    //<< set Type   = $extract($piece(Field,Y,1),1)
    Type.set(m$.Fnc.$extract(m$.Fnc.$piece(Field.get(),m$.var("Y").get(),1),1));
    //<< set Return = $extract($piece(Field,Y,1),2)
    Return.set(m$.Fnc.$extract(m$.Fnc.$piece(Field.get(),m$.var("Y").get(),1),2));
    //<< 
    //<< set (Start,End) = $piece(Field,Y,2)
    Start.set(m$.Fnc.$piece(Field.get(),m$.var("Y").get(),2));
    End.set(m$.Fnc.$piece(Field.get(),m$.var("Y").get(),2));
    //<< if +Start'=Start {               ;  Range Check
    if (mOp.NotEqual(mOp.Positive(Start.get()),Start.get())) {
      //<< set Start = +Start
      Start.set(mOp.Positive(Start.get()));
      //<< set End   = $piece(End,"-",2)
      End.set(m$.Fnc.$piece(End.get(),"-",2));
    }
    //<< }
    //<< set Data=""
    Data.set("");
    //<< if Type="P" {
    if (mOp.Equal(Type.get(),"P")) {
      //<< set Index = 0
      Index.set(0);
      //<< for Cnt = Start:1:End {
      for (Cnt.set(Start.get());(mOp.LessOrEqual(Cnt.get(),End.get()));Cnt.set(mOp.Add(Cnt.get(),1))) {
        //<< set Index = Index+1
        Index.set(mOp.Add(Index.get(),1));
        //<< set $piece(Data,",",Index) = $get(Record(Cnt))
        m$.pieceVar(Data,",",Index.get()).set(m$.Fnc.$get(Record.var(Cnt.get())));
      }
    }
    //<< }
    //<< }
    //<< 
    //<< if Type="D"            set Data = $piece(Record,Y,Start,End)
    if (mOp.Equal(Type.get(),"D")) {
      Data.set(m$.Fnc.$piece(Record.get(),m$.var("Y").get(),Start.get(),End.get()));
    }
    //<< if ($get(Class)'="")&&('pblnNoFormat)     set Data = $$^WWWFORMAT(Class,Type,Start,Data,Return) ;SR17993
    if ((mOp.NotEqual(m$.Fnc.$get(Class),"")) && (mOp.Not(pblnNoFormat.get()))) {
      Data.set(m$.fnc$("WWWFORMAT.main",Class.get(),Type.get(),Start.get(),Data.get(),Return.get()));
    }
    //<< ;if $get(Class)'=""     set Data = $$^WWWFORMAT(Class,Type,Start,Data,Return)
    //<< if $get(Blank),Data="" set Data = " "
    if (mOp.Logical(m$.Fnc.$get(Blank)) && mOp.Equal(Data.get(),"")) {
      Data.set(" ");
    }
    //<< 
    //<< quit Data
    return Data.get();
  }

  //<< 
  //<< 
  //<< Link(Form,Key,Options)
  public Object Link(Object ... _p) {
    mVar Form = m$.newVarRef("Form",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar Key = m$.newVarRef("Key",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar Options = m$.newVarRef("Options",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Provide hyperlinks from displayed data to other forms if required.
    //<< ;
    //<< ; History
    //<< ; 08-May-2006   PO      SR14427 (Phase 2): Allow for table to be displayed on a
    //<< ;                           form when no record is loaded.
    //<< ; 24-Apr-2006   HJRB    SRBR014014: YOPEN=2 to keep DATEN between pages
    //<< ; 12-Oct-2005   JW      SR13671: YPARA shouldn't have extra comma
    //<< ; 01-Aug-2005   PO      SR13009 Also only add form name to YBACK if Form and
    //<< ;                           YFORM not same; if Form and YFORM are same and YBACK
    //<< ;                           ends with YFORM then remove it.
    //<< ; 21-Jul-2005   PO      SR13009 Do not continually append to YBACK
    //<< ; 13-May-2004   sh/paul TR007715 : Only set YPARA if it isn't blank,
    //<< ;                           Sometimes can end up with YPARA being set in this
    //<< ;                           link twice.
    //<< ; 30-Apr-2004   shobby  TR007578: Append YFORM to existing YBACK rather than
    //<< ;                           overwriting
    //<< ;                           <TODO - shobby, need to find the ID somewhere>
    //<< ; 29-Apr-2004   shobby  TR007245: Put 2nd part of Key into YPARA
    //<< ;-------------------------------------------------------------------------------
    //<< new strYBACK
    mVar strYBACK = m$.var("strYBACK");
    m$.newVar(strYBACK);
    //<< 
    //<< set strYBACK = YBACK
    strYBACK.set(m$.var("YBACK").get());
    //<< write "<A HREF="_""""_YAKTION_"EP=WWWFORM"
    m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat("<A HREF=","\""),m$.var("YAKTION").get()),"EP=WWWFORM"));
    //<< if $extract(Form)="@" xecute $extract(Form,2,999)
    if (mOp.Equal(m$.Fnc.$extract(Form.get()),"@")) {
      m$.Cmd.Xecute(m$.Fnc.$extract(Form.get(),2,999));
    }
    //<< if (Form'=YFORM) && ($reverse($piece($reverse(YBACK),",",2))'=YFORM) {
    if ((mOp.NotEqual(Form.get(),m$.var("YFORM").get())) && (mOp.NotEqual(m$.Fnc.$reverse(m$.Fnc.$piece(m$.Fnc.$reverse(m$.var("YBACK").get()),",",2)),m$.var("YFORM").get()))) {
      //<< set strYBACK = strYBACK_YFORM_","
      strYBACK.set(mOp.Concat(mOp.Concat(strYBACK.get(),m$.var("YFORM").get()),","));
    }
    //<< 
    //<< } elseif (Form=YFORM) && ($reverse($piece($reverse(YBACK),",",2))=YFORM) {
    else if ((mOp.Equal(Form.get(),m$.var("YFORM").get())) && (mOp.Equal(m$.Fnc.$reverse(m$.Fnc.$piece(m$.Fnc.$reverse(m$.var("YBACK").get()),",",2)),m$.var("YFORM").get()))) {
      //<< set strYBACK = $piece(strYBACK,",",1,$length(strYBACK,",")-2)_","
      strYBACK.set(mOp.Concat(m$.Fnc.$piece(strYBACK.get(),",",1,mOp.Subtract(m$.Fnc.$length(strYBACK.get(),","),2)),","));
    }
    //<< }
    //<< set YBACK = strYBACK
    mVar YBACK = m$.var("YBACK");
    YBACK.set(strYBACK.get());
    //<< write "&amp;YFORM="_Form_"&amp;YKEY="_$piece(Key,Y,1)_"&amp;YBACK="_YBACK ;_YFORM_","
    m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("&amp;YFORM=",Form.get()),"&amp;YKEY="),m$.Fnc.$piece(Key.get(),m$.var("Y").get(),1)),"&amp;YBACK="),YBACK.get()));
    //<< 
    //<< if $piece(Key,Y,2)'="" {
    if (mOp.NotEqual(m$.Fnc.$piece(Key.get(),m$.var("Y").get(),2),"")) {
      //<< write "&amp;YPARA="_$piece(Key,Y,2)
      m$.Cmd.Write(mOp.Concat("&amp;YPARA=",m$.Fnc.$piece(Key.get(),m$.var("Y").get(),2)));
    }
    //<< }
    //<< if YFKEY_YKEY '= "" write "&amp;YFKEY="_YFKEY_YKEY_","
    if (mOp.NotEqual(mOp.Concat(m$.var("YFKEY").get(),m$.var("YKEY").get()),"")) {
      m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat("&amp;YFKEY=",m$.var("YFKEY").get()),m$.var("YKEY").get()),","));
    }
    //<< 
    //<< new YFORM,YKEY,YBACK,YSEITE,YPARA
    mVar YFORM = m$.var("YFORM");
    mVar YKEY = m$.var("YKEY");
    mVar YSEITE = m$.var("YSEITE");
    mVar YPARA = m$.var("YPARA");
    m$.newVar(YFORM,YKEY,YBACK,YSEITE,YPARA);
    //<< do ^WWWCGI
    m$.Cmd.Do("WWWCGI.main");
    //<< write """"_">"
    m$.Cmd.Write(mOp.Concat("\"",">"));
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< Pages(Count,PageSize,&Query,&Start,&End)
  public Object Pages(Object ... _p) {
    mVar Count = m$.newVarRef("Count",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar PageSize = m$.newVarRef("PageSize",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar Query = m$.newVarRef("Query",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    mVar Start = m$.newVarRef("Start",(((_p!=null)&&(_p.length>=4))?_p[3]:null));
    mVar End = m$.newVarRef("End",(((_p!=null)&&(_p.length>=5))?_p[4]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; If the number of entries is greater than the nominated page size
    //<< ; display an extra group to allow movement through the pages.
    //<< ; e.g.
    //<< ;    Items per page  [ 100 ]  1  2  3  4  5
    //<< ;                                -  -  -  -     <= Hyperlinks when on page 1
    //<< ;
    //<< ; ByRef : Query,Start,End
    //<< ;
    //<< ; TODO : Consider adding << and >> (and possibly < and >) buttons since
    //<< ;        normally only 10 pages each side of currently displayed page -
    //<< ;        no fast shift if a lot of data exists <GRF>
    //<< ;
    //<< ;
    //<< ; History:
    //<< ; 16-May-2006   Steve S SR14579: Show "Items Per Page" as greyed-out (readonly)
    //<< ; 12-Oct-2005   JW      SR13671: Added YPARA
    //<< ;-------------------------------------------------------------------------------
    //<< new Current,Max,Page
    mVar Current = m$.var("Current");
    mVar Max = m$.var("Max");
    mVar Page = m$.var("Page");
    m$.newVar(Current,Max,Page);
    //<< 
    //<< set Current = 0
    Current.set(0);
    //<< if ($zconvert($get(Query("Name")),"O","HTML")=$piece($get(%("%KEY","QueryPage")),":",2)) {
    if ((mOp.Equal(m$.Fnc.$zconvert(m$.Fnc.$get(Query.var("Name")),"O","HTML"),m$.Fnc.$piece(m$.Fnc.$get(m$.var("%","%KEY","QueryPage")),":",2)))) {
      //<< set Current = +$get(%("%KEY","QueryPage"))
      Current.set(mOp.Positive(m$.Fnc.$get(m$.var("%","%KEY","QueryPage"))));
    }
    //<< }
    //<< if 'Current set Current = 1
    if (mOp.Not(Current.get())) {
      Current.set(1);
    }
    //<< set Max   = Count-1   \ PageSize + 1
    Max.set(mOp.Add(mOp.IntegerDivide(mOp.Subtract(Count.get(),1),PageSize.get()),1));
    //<< set Start = Current-1 * PageSize + 1
    Start.set(mOp.Add(mOp.Multiply(mOp.Subtract(Current.get(),1),PageSize.get()),1));
    //<< set End   = Current   * PageSize
    End.set(mOp.Multiply(Current.get(),PageSize.get()));
    //<< if (End>Count) set End = Count
    if ((mOp.Greater(End.get(),Count.get()))) {
      End.set(Count.get());
    }
    //<< 
    //<< //FIXME: Using a FIN language text in a COM module ???
    //<< 
    //<< write "<TR SIZE=2>",!,"<TD ALIGN=LEFT VALIGN=TOP>"
    m$.Cmd.Write("<TR SIZE=2>","\n","<TD ALIGN=LEFT VALIGN=TOP>");
    //<< write YCR,"<FONT SIZE=2><B>   "_$$^WWWTEXT("Fin00068")_": "_"</B></FONT>"      ;  Items per page
    m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat(mOp.Concat("<FONT SIZE=2><B>   ",m$.fnc$("WWWTEXT.main","Fin00068")),": "),"</B></FONT>"));
    //<< write "</A>"
    m$.Cmd.Write("</A>");
    //<< write YCR,"<INPUT NAME="_"YANZAHL SIZE=5 MAXLENGTH=5 TYPE=float VALUE="_""""_PageSize_""""
    m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("<INPUT NAME=","YANZAHL SIZE=5 MAXLENGTH=5 TYPE=float VALUE="),"\""),PageSize.get()),"\""));
    //<< write YCR," TABINDEX=ART style="_""""_"padding-top:0 ;padding-bottom:0"_""""_" style="_""""_"text-align:right; background-color:lightgrey"_"""" //SR14579
    m$.Cmd.Write(m$.var("YCR").get(),mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(" TABINDEX=ART style=","\""),"padding-top:0 ;padding-bottom:0"),"\"")," style="),"\""),"text-align:right; background-color:lightgrey"),"\""));
    //<< ;write " onChange='submit();'"
    //<< ;write "  onFocus='select();'"
    //<< write "  readOnly"
    m$.Cmd.Write("  readOnly");
    //<< write "  unselectable"
    m$.Cmd.Write("  unselectable");
    //<< write ">"
    m$.Cmd.Write(">");
    //<< 
    //<< for Page=$select(Current-10<1:1,1:Current-10):1:$select(Current+10>Max:Max,1:Current+10) {
    for (Page.set(m$.Fnc.$select(mOp.Less(mOp.Subtract(Current.get(),10),1),1,1,mOp.Subtract(Current.get(),10)));(mOp.LessOrEqual(Page.get(),m$.Fnc.$select(mOp.Greater(mOp.Add(Current.get(),10),Max.get()),Max.get(),1,mOp.Add(Current.get(),10))));Page.set(mOp.Add(Page.get(),1))) {
      //<< write "&nbsp;"
      m$.Cmd.Write("&nbsp;");
      //<< if Page'=Current {
      if (mOp.NotEqual(Page.get(),Current.get())) {
        //<< ;do Link("@s Form=$$PageLink($get(Options),"""_$get(Query("Name"))_""")",YKEY,Page)
        //<< do Link("@s Form=$$PageLink($get(Options),"""_$get(Query("Name"))_""")",YKEY_Y_YPARA,Page)  //SR13671
        m$.Cmd.Do("Link",mOp.Concat(mOp.Concat("@s Form=$$PageLink($get(Options),\"",m$.Fnc.$get(Query.var("Name"))),"\")"),mOp.Concat(mOp.Concat(m$.var("YKEY").get(),m$.var("Y").get()),m$.var("YPARA").get()),Page.get());
        //<< write "<U>",Page,"</U></A>"
        m$.Cmd.Write("<U>",Page.get(),"</U></A>");
      }
      //<< 
      //<< } else {
      else {
        //<< write Page
        m$.Cmd.Write(Page.get());
      }
    }
    //<< }
    //<< }
    //<< write "</TR>"
    m$.Cmd.Write("</TR>");
    //<< quit
    return null;
  }

  //<< 
  //<< 
  //<< PageLink(Page,PageName)
  public Object PageLink(Object ... _p) {
    mVar Page = m$.newVarRef("Page",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar PageName = m$.newVarRef("PageName",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Generated URL for re-calling form with an offset to the required page of data
    //<< ;
    //<< ; History:
    //<< ; 24-Apr-2006   JW      SRBR014014: YOPEN=2 to keep DATEN between pages
    //<< ;-------------------------------------------------------------------------------
    //<< new Form,Rec
    mVar Form = m$.var("Form");
    mVar Rec = m$.var("Rec");
    m$.newVar(Form,Rec);
    //<< 
    //<< set Form = YFORM
    Form.set(m$.var("YFORM").get());
    //<< if $get(YSEITE) write "&amp;YSEITE="_YSEITE
    if (mOp.Logical(m$.Fnc.$get(m$.var("YSEITE")))) {
      m$.Cmd.Write(mOp.Concat("&amp;YSEITE=",m$.var("YSEITE").get()));
    }
    //<< kill YPARA1
    m$.var("YPARA1").kill();
    //<< 
    //<< write "&amp;YOPEN=2"
    m$.Cmd.Write("&amp;YOPEN=2");
    //<< write "&amp;QueryPage="_Page_":"_$zconvert($get(PageName),"O","HTML")
    m$.Cmd.Write(mOp.Concat(mOp.Concat(mOp.Concat("&amp;QueryPage=",Page.get()),":"),m$.Fnc.$zconvert(m$.Fnc.$get(PageName),"O","HTML")));
    //<< quit Form
    return Form.get();
  }

  //<< 
  //<< 
  //<< GetData(&Query,&Storage)
  public Object GetData(Object ... _p) {
    mVar Query = m$.newVarRef("Query",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar Storage = m$.newVarRef("Storage",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Use the "Loop" command to build the lines to be displayed
    //<< ; Retain and recheck key so only extract data once for a query session.
    //<< ; Set the number of lines in @Storage
    //<< ;
    //<< ; If there are multiple pages, the form will be called again whenever
    //<< ; a page link is used to view other information.  In that case the Browser
    //<< ; will pass in a value through %("%KEY","QueryPage") - this will not exist on
    //<< ; the initial entry.
    //<< ;
    //<< ; ("QueryPage" is set in PageLink() when there are multiple pages.)
    //<< ;
    //<< ; ByRef : Query   - Array of Query parameters
    //<< ;         Storage - Data storage location (^mtemp)
    //<< ;
    //<< ; History:
    //<< ; 08-Oct-2004   GRF     SR10464 : Replace ! with ||
    //<< ;-------------------------------------------------------------------------------
    //<< new Count,key
    mVar Count = m$.var("Count");
    mVar key = m$.var("key");
    m$.newVar(Count,key);
    //<< 
    //<< set key=YKEY_Y_YFORM_Y_$GET(YSEITE)_Y_$get(Query("Name"))
    key.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(m$.var("YKEY").get(),m$.var("Y").get()),m$.var("YFORM").get()),m$.var("Y").get()),m$.Fnc.$get(m$.var("YSEITE"))),m$.var("Y").get()),m$.Fnc.$get(Query.var("Name"))));
    //<< 
    //<< ; If the key is different or we are coming into the form from other than a Page Link
    //<< if ((key'=$get(@Storage@(0))) || '$data(%("%KEY","QueryPage"))) {
    if (mOp.Logical(((mOp.NotEqual(key.get(),m$.Fnc.$get(m$.indirectVar(Storage.get()).var(0)))) || mOp.Not(m$.Fnc.$data(m$.var("%","%KEY","QueryPage")))))) {
      //<< kill @Storage
      m$.indirectVar(Storage.get()).kill();
      //<< set Count=""
      Count.set("");
      //<< xecute "set Count=$$"_Query("Loop")_"(.Query,.Storage,.VORG)"
      m$.Cmd.Xecute(mOp.Concat(mOp.Concat("set Count=$$",Query.var("Loop").get()),"(.Query,.Storage,.VORG)"));
      //<< set @Storage = Count_Y_$horolog
      m$.indirectVar(Storage.get()).set(mOp.Concat(mOp.Concat(Count.get(),m$.var("Y").get()),m$.Fnc.$horolog()));
      //<< kill %("%KEY","QueryPage")
      m$.var("%","%KEY","QueryPage").kill();
    }
    //<< }
    //<< set @Storage@(0) = key
    m$.indirectVar(Storage.get()).var(0).set(key.get());
    //<< quit
    return null;
  }

//<< 
//<< 
}
