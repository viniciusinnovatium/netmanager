//*****************************************************************************
//** TASC - ALPHALINC - INC include.COMSYSEnum
//** Innovatium Systems - Code Converter - v1.29
//** 2014-06-03 20:52:12
//*****************************************************************************

package include;

import mLibrary.*;


//<< #; SR14612: Payment Macros
public class COMSYSEnum extends mInclude {

  //<< #define EnumPayByCheque         2
  public static Object $$$EnumPayByCheque(mContext m$) {
    return (2);
  }

  //<< #define EnumPayByEFT            1
  public static Object $$$EnumPayByEFT(mContext m$) {
    return (1);
  }

  //<< 
  //<< #; SR15344: DRP Lead Time macros
  //<< #define DRPSupplier             0
  public static Object $$$DRPSupplier(mContext m$) {
    return (0);
  }

  //<< #define DRPConfirm              1
  public static Object $$$DRPConfirm(mContext m$) {
    return (1);
  }

  //<< #define DRPPlace                2
  public static Object $$$DRPPlace(mContext m$) {
    return (2);
  }

  //<< #define DRPRaise                3
  public static Object $$$DRPRaise(mContext m$) {
    return (3);
  }

  //<< #define DRPSource               4
  public static Object $$$DRPSource(mContext m$) {
    return (4);
  }

  //<< #define DRPFirm                 5
  public static Object $$$DRPFirm(mContext m$) {
    return (5);
  }

  //<< 
  //<< #; SR16328: UserAccessForChange/AuthorizationToModifyData : Applicn Param "ÄNDERUNG"
  //<< #define EnumCreateModifyDelete  1
  public static Object $$$EnumCreateModifyDelete(mContext m$) {
    return (1);
  }

  //<< #define EnumCreateModify        2
  public static Object $$$EnumCreateModify(mContext m$) {
    return (2);
  }

  //<< #define EnumCreateOnly          3
  public static Object $$$EnumCreateOnly(mContext m$) {
    return (3);
  }

  //<< #define EnumModifyOnly          4
  public static Object $$$EnumModifyOnly(mContext m$) {
    return (4);
  }

  //<< #define EnumReadOnly            5
  public static Object $$$EnumReadOnly(mContext m$) {
    return (5);
  }

//<< 
}
