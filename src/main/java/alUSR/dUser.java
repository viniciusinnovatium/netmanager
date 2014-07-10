//*****************************************************************************
//** TASC - ALPHALINC - CLASS alUSR.dUser
//** Innovatium Systems - Code Converter - v1.31
//** 2014-07-07 17:54:23
//*****************************************************************************

package alUSR;

import mLibrary.*;

//<< Class alUSR.dUser Extends %Persistent [ ClassType = persistent, ProcedureBlock ]
public class dUser extends mPersistent {
  //<< {
  //<< 
  //<< /*----------------------------------------------------------------------------------
  //<< ; History:
  //<< ; 24-Jan-2008   LB      SR15626 Created
  //<< ;---------------------------------------------------------------------------------*/
  //<< 
  //<< /*----------------------------------------------------------------------------------
  //<< ;   AtNet Manager Element Mappings
  //<< ;-----------------------------------------------------------------------------------
  //<< ; Number    V1 Description                  Input Type
  //<< ;-----------------------------------------------------------------------------------
  //<< ;   P1      UserName...                     6 - Text
  //<< ;   D1      Name                            6 - Text
  //<< ;   D9      E- Mail Address                 6 - Text
  //<< ;   D44     HomeLocation                    6 - Text
  //<< ;---------------------------------------------------------------------------------*/
  //<< Property UserName As alSYS.dt.dtString(CAPTION = "AL00007") [ Required ];
  public String UserName;
  //<< 
  //<< Property Name As alSYS.dt.dtString(CAPTION = "AL00005") [ Required ];
  public String Name;
  //<< 
  //<< Property EmailAddress As alSYS.dt.dtString(CAPTION = "AL00001");
  public String EmailAddress;
  //<< 
  //<< Property HomeLocation As alLOC.dLocation(CAPTION = "AL00003");
  public alLOC.dLocation HomeLocation;

//<< 
//<< //++++++++++++++++++++++++++++++++++++++++++
//<< 
//<< Index Index On UserName [ IdKey, Unique ];
//<< 
//<< //++++++++++++++++++++++++++++++++++++++++++
//<< 
//<< }
}
