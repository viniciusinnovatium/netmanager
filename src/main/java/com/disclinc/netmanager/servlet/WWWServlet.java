package com.disclinc.netmanager.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mLibrary.mContext;
import mLibrary.mRequest;
import mLibrary.mSession;
import User.www;

/**
 * Servlet implementation class WWWServlet
 */
public class WWWServlet extends NetmanagerServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1782787623674362578L;

	@Override
	void doHandleRequest(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		mContext m$ = new mContext(response);
		m$.var("^WWWUSER", 0, "10010643489", 1)
				.set("^1441,1450,1459,~INNOV~63314~55641~0~0~10~FRAME210010643489~0~0~~~~MEDPatient~~~~~PT~0~1~~~~~~~~~~~~~~MSIE~192.168.100.156");
		m$.var("%", "%KEY", "YFORMWAIT").set(1);
		String queryStr = request.getQueryString();
		request.getSession(true);
		if (queryStr == null || queryStr.isEmpty()) {
			// m$.var("^WWWUSER", 0, "10010643489",
			// 1).set("^1441,1450,1459,~INNOV~63314~55641~0~0~10~FRAME210010643489~0~0~~~~MEDPatient~~~~~PT~0~1~~~~~~~~~~~~~~MSIE~192.168.100.156");
			queryStr = "EP=WWWFORM&YFORM=MEDPatient&YUCI=SESDF&YBED=INNOV&YM=0&YUSER=10010643489&YPARA=~&YANZ=VARMega,450.10.&YNAME=Cadastro_de_Pacientes&YLOCKKILL=1";
			String reqStr2 = "EP=WWWFORM&YFORM=VARAlertaLocal&YUCI=SESDF&YBED=INNOV&YM=0&YUSER=10010643489&YPARA=~&YANZ=VARMega,450.10.&YNAME=Alerta_de_Reposição&YLOCKKILL=1";
			String reqStr3 = "EP=WWWFORM&YFORM=MEDPrescription&YUCI=SESDF&YBED=INNOV&YM=0&YUSER=10010643489&YPARA=~&YANZ=VARMega,450.10.&YNAME=Cadastro_de_Prescrição&YLOCKKILL=1";
		}
		m$.setRequest(new mRequest(request,queryStr));
		m$.setSession(new mSession());
		//m$.Cmd.WriteJS("<script type=\"text/javascript\"> function showMenu(pintFrame) {var strWindow = window.open('','MENUE10010180968','HEIGHT=500,WIDTH=300,SCROLLBARS=YES,RESIZEABLE=YES');if (strWindow.location.href == 'about:blank') {window.open('www.cls?EP=WWWMENU&amp;YUSER=10010180968&amp;YBED=INNOV&amp;YUCI=SESDF&amp;YM=0','MENUE10010180968','HEIGHT=500,WIDTH=300,SCROLLBARS=YES,RESIZEABLE=YES');strWindow.opener=window.frames[pintFrame];     addWindow(strWindow);    } else {    strWindow.focus();   } }function addWindow(pobjWindow) {   try {    var intLen = 0;    if (window.subWindows!=undefined) {intLen = window.subWindows.length    } else {     window.subWindows = new Array();   }window.subWindows[intLen] = pobjWindow;    } catch(e) { }  }  function closeWindows() {if (window.subWindows!=undefined) {    var strWindow;     for(var i=0;i<window.subWindows.length;i++) {      with (window.subWindows[i]) {      if (!closed) {        changes = false;        close();       }     }    }   } }  function getCookie(pstrName) {     var objCookie = document.cookie,         prefix = pstrName + '=',         begin = objCookie.indexOf('; ' + prefix);     if (begin == -1) {         begin = objCookie.indexOf(prefix);         if (begin != 0) return null;     } else {         begin += 2;     }     var end = document.cookie.indexOf(';', begin);     if (end == -1) {         end = objCookie.length;     }     return unescape(objCookie.substring(begin + prefix.length, end));  }  function incrementWindowCount(pstrName) {     var strCookieValue = getCookie(pstrName);     if (strCookieValue == null) strCookieValue = '0:' + document.location.href;    document.cookie = pstrName + ' = ' + (parseInt(strCookieValue) + 1) + strCookieValue.substring(strCookieValue.indexOf(':'),strCookieValue.length);  }  function decrementWindowCount(pstrName) {     var strCookieValue = getCookie(pstrName),         intCount;     if (strCookieValue != null) {        intCount = parseInt(strCookieValue) - 1;        strCookieValue = intCount + strCookieValue.substring(strCookieValue.indexOf(':'),strCookieValue.length);        document.cookie = pstrName + ' = ' + strCookieValue;     } else {        strCookieValue = 0;     }     return parseInt(strCookieValue);  } function EventValue(Namespace,User,Form,Fixkey,Field,Value,Funct,LocalVar,Tab) {    var retval;    var von = /&#8364/g;    var nach = \"&euro;\";    if (Value != false) { if (Value != true) Value=Value.replace(von,nach);}    Para=Namespace + \".\" + User + \".\" + Form + \".\" + Field + \".\" + Funct + \".\" + Fixkey + \".\" + \"PT\" + \".\" + LocalVar ;    retval = cspHttpServerMethod(\"G0eWJptT2U7Pp5_BGVZkbmhkkvtmWW1uwP$N9Key$IdkwxZjfbCY7JSJF$NRZ08c\",Para,Value);    if (retval != null) {    retval=retval.replace(/\'/g,String.fromCharCode(10,13));   retval=retval.replace(/`/g,\'\\'\');    }     if (retval != null) retval=retvalcheck(retval,Value,Funct,Field,'WWW');    return(retval); } </script>");
		www www = new www();
		www.setContext(m$);
		www.Page();
	}

}
