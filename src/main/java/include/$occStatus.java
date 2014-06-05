//*****************************************************************************
//** TASC - ALPHALINC - INC include.$occStatus
//** Innovatium Systems - Code Converter - v1.29
//** 2014-06-03 20:52:12
//*****************************************************************************

package include;

import mLibrary.*;


//<< /// Create a success %Status code
public class $occStatus extends mInclude {

  //<< #define OK                     1
  public static Object $$$OK(mContext m$) {
    return (1);
  }

  //<< 
  //<< /// Return true if the %Status code is success, and false otherwise
  //<< /// %sc - %Status code
  //<< #define ISOK(%sc)              (+%sc)
  public static Object $$$ISOK(mContext m$, Object ... _p) {
    mVar p$sc = m$.varRef("p$sc",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return ((mOp.Positive(p$sc.get())));
  }

  //<< 
  //<< /// Return true if the %Status code if an error, and false otherwise
  //<< /// %sc - %Status code
  //<< #define ISERR(%sc)             ('%sc)
  public static Object $$$ISERR(mContext m$, Object ... _p) {
    mVar p$sc = m$.varRef("p$sc",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return ((mOp.Not(p$sc.get())));
  }

  //<< 
  //<< /// Return the error code from a %Status value
  //<< /// %sc - %Status code
  //<< #define GETERRORCODE(%sc)      $listget($listget($extract(%sc,3,)),1,0)
  public static Object $$$GETERRORCODE(mContext m$, Object ... _p) {
    mVar p$sc = m$.varRef("p$sc",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$listget(m$.Fnc.$listget(m$.Fnc.$extract(p$sc.get(),3)),1,0));
  }

  //<< 
  //<< /// Create an error %Status code
  //<< /// %arg1 - Error code, total list of codes in %occErrors.inc
  //<< /// %arg2 - Optional additional information
  //<< #def1arg ERROR(%args)          $System.Status.Error(%args)
  public static Object $$$ERROR(mContext m$, Object ... _p) {
    mVar p$args = m$.varRef("p$args",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.getSystem().getStatus().Error(p$args.get()));
  }

  //<< #define  ERR(%code)            $System.Status.Error(%args)
  public static Object $$$ERR(mContext m$, Object ... _p) {
    mVar p$code = m$.varRef("p$code",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.getSystem().getStatus().Error(m$.var("%args").get()));
  }

}
