//*****************************************************************************
//** TASC - ALPHALINC - INC include.INSupStatus
//** Innovatium Systems - Code Converter - v1.30
//** 2014-06-27 18:27:18
//*****************************************************************************

package include;

import mLibrary.*;

//<< #include INConst
import include.INConst;
import include.COMSYS;

//<< #; INSupStatus.inc
//<< 
public class INSupStatus extends mInclude {

  //<< 
  //<< #;----------------------------------------------------------------------------------
  //<< #; Macros relating to INSupStatus (Supplier Status) functionality
  //<< #;----------------------------------------------------------------------------------
  //<< 
  //<< #define HasPermission(%sup,%s,%f)   $select($piece($get(^INSupStatus(0,%s,1)),Y,%f):$$$OK,1:$listbuild("IN00664",%sup,$$^WWWFELDNAME("INSupStatus","D",%f)))
  public static Object $$$HasPermission(mContext m$, Object ... _p) {
    mVar p$sup = m$.varRef("p$sup",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar p$s = m$.varRef("p$s",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    mVar p$f = m$.varRef("p$f",(((_p!=null)&&(_p.length>=3))?_p[2]:null));
    return (m$.Fnc.$select(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^INSupStatus",0,p$s.get(),1)),m$.var("Y").get(),p$f.get()),include.COMSYS.$$$OK(m$),1,m$.Fnc.$listbuild("IN00664",p$sup.get(),m$.fnc$("WWWFELDNAME.main","INSupStatus","D",p$f.get()))));
  }

  //<< #; "Supplier %1 does not have permission to: %2"
  //<< #;------------------------------------------
  //<< #; %sup     idSupplier
  //<< #; %s       idStatus
  //<< #; %f       intFieldNumber
  //<< #;------------------------------------------
  //<< 
  //<< #define DefaultStatus               $order(^INSupStatuss(0,1,$$$YES,""))
  public static Object $$$DefaultStatus(mContext m$) {
    return (m$.Fnc.$order(m$.var("^INSupStatuss",0,1,include.COMSYS.$$$YES(m$),"")));
  }

}
