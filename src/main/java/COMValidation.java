//*****************************************************************************
//** TASC - ALPHALINC - MAC COMValidation
//** Innovatium Systems - Code Converter - v1.30
//** 2014-06-10 15:55:37
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

//<< COMValidation
public class COMValidation extends mClass {

  public void main() {
    _COMValidation();
  }

  public void _COMValidation() {
  }

  //<< 
  //<< ValidateCPForCNPJ(pstrCode="")
  public Object ValidateCPForCNPJ(Object ... _p) {
    mVar pstrCode = m$.newVarRef("pstrCode",(((_p!=null)&&(_p.length>=1))?_p[0]:null),"");
    //<< ;-------------------------------------------------------------------------------
    //<< ; Checks whether the passed in code is either a CPF or CNPJ
    //<< ;
    //<< ; Params:   pstrCode:   The code to be checked.
    //<< ;
    //<< ; Returns:
    //<< ;           strStatus:Either true or an error message
    //<< ;
    //<< ; History:
    //<< ; 09-Nov-2006   shobby          Created: SRBR014161
    //<< ;
    //<< ;-------------------------------------------------------------------------------
    //<< ;
    //<< new strStatus
    mVar strStatus = m$.var("strStatus");
    m$.newVar(strStatus);
    //<< 
    //<< set strStatus=$$$OK
    strStatus.set(include.COMSYS.$$$OK(m$));
    //<< if pstrCode="" {
    if (mOp.Equal(pstrCode.get(),"")) {
    }
    //<< ;Code is not mandatory so "" is ok
    //<< } elseif $length(pstrCode)=14 {
    else if (mOp.Equal(m$.Fnc.$length(pstrCode.get()),14)) {
      //<< set strStatus=$$ValidateCNPJ(pstrCode)
      strStatus.set(m$.fnc$("ValidateCNPJ",pstrCode.get()));
    }
    //<< } else {
    else {
      //<< set strStatus=$$ValidateCPF(pstrCode)
      strStatus.set(m$.fnc$("ValidateCPF",pstrCode.get()));
    }
    //<< }
    //<< quit strStatus
    return strStatus.get();
  }

  //<< 
  //<< 
  //<< ValidateCNPJ(pstrCode="")
  public Object ValidateCNPJ(Object ... _p) {
    mVar pstrCode = m$.newVarRef("pstrCode",(((_p!=null)&&(_p.length>=1))?_p[0]:null),"");
    //<< ;-------------------------------------------------------------------------------
    //<< ; Checks whether the passed in code is a valid CNPJ
    //<< ;
    //<< ; Params:   pstrCode:   The code to be checked.
    //<< ;
    //<< ; Returns:
    //<< ;           strStatus:Either true or an error message
    //<< ;
    //<< ; History:
    //<< ; 22-Oct-2008   shobby          SRBR014968: Changed $listbuild to $$$MakeStatus
    //<< ; 15-Dec-2006   shobby          SRBR014161: Corrected failure when first digit is a zero.
    //<< ; 29-Nov-2006   shobby          SRBR014161: Not necessary to append 1st check digit to code when calculating 2nd digit.
    //<< ; 09-Nov-2006   shobby          SRBR014161: Created
    //<< ;
    //<< ;-------------------------------------------------------------------------------
    //<< new strStatus,strMultiplier,intX1,intX2
    mVar strStatus = m$.var("strStatus");
    mVar strMultiplier = m$.var("strMultiplier");
    mVar intX1 = m$.var("intX1");
    mVar intX2 = m$.var("intX2");
    m$.newVar(strStatus,strMultiplier,intX1,intX2);
    //<< 
    //<< set strStatus=$$$OK
    strStatus.set(include.COMSYS.$$$OK(m$));
    //<< if (pstrCode?14.14n) {
    if ((mOp.Match(pstrCode.get(),"14.14n"))) {
      //<< set intX1=$$GetDigit(pstrCode,"5,4,3,2,9,8,7,6,5,4,3,2")
      intX1.set(m$.fnc$("GetDigit",pstrCode.get(),"5,4,3,2,9,8,7,6,5,4,3,2"));
      //<< set intX2=$$GetDigit(pstrCode,"6,5,4,3,2,9,8,7,6,5,4,3,2")
      intX2.set(m$.fnc$("GetDigit",pstrCode.get(),"6,5,4,3,2,9,8,7,6,5,4,3,2"));
      //<< if ($extract(pstrCode,13)'=intX1)||($extract(pstrCode,14)'=intX2) {
      if ((mOp.NotEqual(m$.Fnc.$extract(pstrCode.get(),13),intX1.get())) || (mOp.NotEqual(m$.Fnc.$extract(pstrCode.get(),14),intX2.get()))) {
        //<< set strStatus=$$$MakeStatus("Com00271",pstrCode,"CNPJ") ;%1 is an Invalid %2 Code
        strStatus.set(include.COMSYS.$$$MakeStatus(m$,"Com00271",pstrCode,"CNPJ"));
      }
    }
    //<< }
    //<< } else {
    else {
      //<< set strStatus=$$$MakeStatus("Com00271",pstrCode,"CNPJ") ;%1 is an Invalid %2 Code
      strStatus.set(include.COMSYS.$$$MakeStatus(m$,"Com00271",pstrCode,"CNPJ"));
    }
    //<< ; No description why.  The intent is not to prompt the user to put a valid code in
    //<< ; but to validate that the code that they are copying is legitimate.
    //<< }
    //<< quit strStatus
    return strStatus.get();
  }

  //<< 
  //<< 
  //<< ValidateCPF(pstrCode="")
  public Object ValidateCPF(Object ... _p) {
    mVar pstrCode = m$.newVarRef("pstrCode",(((_p!=null)&&(_p.length>=1))?_p[0]:null),"");
    //<< ;-------------------------------------------------------------------------------
    //<< ; Checks whether the passed in code is a valid CPF
    //<< ;
    //<< ; Params:   pstrCode:   The code to be checked.
    //<< ;
    //<< ; Returns:
    //<< ;           strStatus:Either true or an error message
    //<< ;
    //<< ; History:
    //<< ; 22-Oct-2008   shobby          SRBR014968: Changed $listbuild to $$$MakeStatus
    //<< ; 15-Dec-2006   shobby          SRBR014161: Corrected failure when first digit is a zero.
    //<< ; 29-Nov-2006   shobby          SRBR014161: Not necessary to append 1st check digit to code when calculating 2nd digit.
    //<< ; 09-Nov-2006   shobby          SRBR014161: Created
    //<< ;
    //<< ;-------------------------------------------------------------------------------
    //<< new strStatus,strMultiplier,intX1,intX2
    mVar strStatus = m$.var("strStatus");
    mVar strMultiplier = m$.var("strMultiplier");
    mVar intX1 = m$.var("intX1");
    mVar intX2 = m$.var("intX2");
    m$.newVar(strStatus,strMultiplier,intX1,intX2);
    //<< 
    //<< set strStatus=$$$OK
    strStatus.set(include.COMSYS.$$$OK(m$));
    //<< if (pstrCode?11.11n) {
    if ((mOp.Match(pstrCode.get(),"11.11n"))) {
      //<< set intX1=$$GetDigit(pstrCode,"10,9,8,7,6,5,4,3,2")
      intX1.set(m$.fnc$("GetDigit",pstrCode.get(),"10,9,8,7,6,5,4,3,2"));
      //<< set intX2=$$GetDigit(pstrCode,"11,10,9,8,7,6,5,4,3,2")
      intX2.set(m$.fnc$("GetDigit",pstrCode.get(),"11,10,9,8,7,6,5,4,3,2"));
      //<< if ($extract(pstrCode,10)'=intX1)||($extract(pstrCode,11)'=intX2) {
      if ((mOp.NotEqual(m$.Fnc.$extract(pstrCode.get(),10),intX1.get())) || (mOp.NotEqual(m$.Fnc.$extract(pstrCode.get(),11),intX2.get()))) {
        //<< set strStatus=$$$MakeStatus("Com00271",pstrCode,"CPF") ;%1 is an Invalid %2 Code
        strStatus.set(include.COMSYS.$$$MakeStatus(m$,"Com00271",pstrCode,"CPF"));
      }
    }
    //<< }
    //<< } else {
    else {
      //<< set strStatus=$$$MakeStatus("Com00271",pstrCode,"CPF") ;%1 is an Invalid %2 Code
      strStatus.set(include.COMSYS.$$$MakeStatus(m$,"Com00271",pstrCode,"CPF"));
    }
    //<< ; No description why.  The intent is not to prompt the user to put a valid code in
    //<< ; but to validate that the code that they are copying is legitimate.
    //<< }
    //<< quit strStatus
    return strStatus.get();
  }

  //<< 
  //<< 
  //<< GetDigit(pintCode="",pintMultiplier="")
  public Object GetDigit(Object ... _p) {
    mVar pintCode = m$.newVarRef("pintCode",(((_p!=null)&&(_p.length>=1))?_p[0]:null),"");
    mVar pintMultiplier = m$.newVarRef("pintMultiplier",(((_p!=null)&&(_p.length>=2))?_p[1]:null),"");
    //<< ;-------------------------------------------------------------------------------
    //<< ; Determines the check digit based on the passed in code and the multiplier.
    //<< ;
    //<< ; Parameters
    //<< ;   pintCode:       The partial CPF or CNPJ code used to calculate the check digit.
    //<< ;   pintMultiplier: The amount that each digit in the partial code is multiplied by.
    //<< ;
    //<< ; Returns
    //<< ;   intDigit:  The check digit.
    //<< ;
    //<< ; History:
    //<< ; 09-Nov-2006   shobby          Created: SRBR014161
    //<< ;-------------------------------------------------------------------------------
    //<< new intSum,idx,intDigit
    mVar intSum = m$.var("intSum");
    mVar idx = m$.var("idx");
    mVar intDigit = m$.var("intDigit");
    m$.newVar(intSum,idx,intDigit);
    //<< 
    //<< set intSum=0
    intSum.set(0);
    //<< for idx=1:1:$length(pintMultiplier) {
    for (idx.set(1);(mOp.LessOrEqual(idx.get(),m$.Fnc.$length(pintMultiplier.get())));idx.set(mOp.Add(idx.get(),1))) {
      //<< set intSum=intSum+($extract(pintCode,idx)*$piece(pintMultiplier,",",idx))
      intSum.set(mOp.Add(intSum.get(),(mOp.Multiply(m$.Fnc.$extract(pintCode.get(),idx.get()),m$.Fnc.$piece(pintMultiplier.get(),",",idx.get())))));
    }
    //<< }
    //<< set intDigit=intSum\11
    intDigit.set(mOp.IntegerDivide(intSum.get(),11));
    //<< set intDigit=intSum-(intDigit*11)
    intDigit.set(mOp.Subtract(intSum.get(),(mOp.Multiply(intDigit.get(),11))));
    //<< if intDigit<2 {
    if (mOp.Less(intDigit.get(),2)) {
      //<< set intDigit=0
      intDigit.set(0);
    }
    //<< } else {
    else {
      //<< set intDigit=(11-intDigit)
      intDigit.set((mOp.Subtract(11,intDigit.get())));
    }
    //<< }
    //<< quit intDigit
    return intDigit.get();
  }

//<< 
//<< 
}
