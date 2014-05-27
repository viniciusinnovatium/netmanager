//*****************************************************************************
//** TASC - ALPHALINC - INC include.COMSYSOutput
//** Innovatium Systems - Code Converter - v1.27
//** 2014-05-22 00:12:36
//*****************************************************************************

package include;

import mLibrary.*;


//<< #;-------------------------------------------------------------------------------
//<< #;
//<< #; History:
//<< #; 25-Oct-2006      PO      SR15143: Created
//<< #;-------------------------------------------------------------------------------
//<< 
public class COMSYSOutput extends mInclude {

  //<< #define COMOUTPUTScreenPrinter      1
  public static Object $$$COMOUTPUTScreenPrinter(mContext m$) {
    return (1);
  }

  //<< #define COMOUTPUTPrinter            2
  public static Object $$$COMOUTPUTPrinter(mContext m$) {
    return (2);
  }

  //<< #define COMOUTPUTEmail              4
  public static Object $$$COMOUTPUTEmail(mContext m$) {
    return (4);
  }

  //<< #define COMOUTPUTFax                8
  public static Object $$$COMOUTPUTFax(mContext m$) {
    return (8);
  }

}
