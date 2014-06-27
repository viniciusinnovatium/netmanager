package com.disclinc.netmanager.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mLibrary.mContext;
import mLibrary.mFncUtil;
import mLibrary.mPage;
import mLibrary.mRequest;
import mLibrary.mSession;

/**
 * Servlet implementation class CLSServlet
 */
public class CLSServlet extends NetmanagerServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5636899190300524413L;

	@Override
	void doHandleRequest(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {

		if (request.getParameter("YFORMWAIT") != null) {
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e1) {
				throw new ServletException(
						"Fail to lock form construction until menu construction finish",
						e1);
			}
		}

		mContext m$ = new mContext(response);
		m$.setRequest(new mRequest(request));
		m$.setSession(new mSession(request.getSession(true)));

		String className = request.getServletPath().replace("/", "")
				.replace(".cls", "");
		className = className.replaceFirst("%", "\\$");
		className = mFncUtil.normalizeClassname(className);
		mPage mPage;
		try {
			/*
			 * if (className.contains("Broker")) {
			 * m$.Cmd.Write("00000001000013jtTsui000000qG2oyPfDuLAHjt5zHYuLmQ--"
			 * ); m$.Cmd.Write("\r\n#R");
			 * m$.Cmd.Write("\r\nYMEDPatientD4mask=\""
			 * ,m$.Fnc.$zconvert("2N1\"/\"2N1\"/\"4N","","JS"),
			 * "\";document.WWW2.YMEDPatientD4.value = doMasking(YMEDPatientD4mask,document.WWW2.YMEDPatientD4.value,49);YMEDPatientD11mask=\""
			 * ,m$.Fnc.$zconvert("3N1\".\"3N1\".\"3N1\"-\"2N","","JS"),
			 * "\";document.WWW2.YMEDPatientD11.value = doMasking(YMEDPatientD11mask,document.WWW2.YMEDPatientD11.value,49);YMEDPatientD13mask=\""
			 * ,m$.Fnc.$zconvert("5N1\"-\"3N","","JS"),
			 * "\";document.WWW2.YMEDPatientD13.value = doMasking(YMEDPatientD13mask,document.WWW2.YMEDPatientD13.value,49);YMEDPatientD16mask=\""
			 * ,m$.Fnc.$zconvert("1\"(\"2N1\")\"1\" \"4N1\"-\"4N","","JS"),
			 * "\";document.WWW2.YMEDPatientD16.value = doMasking(YMEDPatientD16mask,document.WWW2.YMEDPatientD16.value,49);YMEDPatientD32mask=\""
			 * ,m$.Fnc.$zconvert("1\"(\"2N1\")\"1\" \"4N1\"-\"4N","","JS"),
			 * "\";document.WWW2.YMEDPatientD32.value = doMasking(YMEDPatientD32mask,document.WWW2.YMEDPatientD32.value,49);YMEDPatientD42mask=\""
			 * ,m$.Fnc.$zconvert("1\"(\"2N1\")\"1\" \"4N1\"-\"4N","","JS"),
			 * "\";document.WWW2.YMEDPatientD41.value = doMasking(YMEDPatientD42mask,document.WWW2.YMEDPatientD41.value,49);YMEDPatientD43mask=\""
			 * ,m$.Fnc.$zconvert("1\"(\"2N1\")\"1\" \"4N1\"-\"4N","","JS"),
			 * "\";document.WWW2.YMEDPatientD42.value = doMasking(YMEDPatientD43mask,document.WWW2.YMEDPatientD42.value,49);PrepareUpdate('WWW2','YMEDPatientD4.style','backgroundColor','palegoldenrod');PrepareUpdate('WWW2','YMEDPatientD4','readOnly','false');var obj=document.getElementById('YMEDPatientD4_CAPTION');if(obj!=null) obj.style.display='block';var obj=document.getElementById('YMEDPatientD4_CONTROL');if(obj!=null) {  obj.style.display='block';}PrepareUpdate('WWW2','CalendarButtonD4','readOnly','false');PrepareUpdate('WWW2','CalendarButtonD4IMG','src','/SESDF/date.gif');PrepareUpdate('WWW2','BUTTON_SEARCH4','readOnly','false');PrepareUpdate('WWW2','BUTTON_SEARCH4IMG','src','/SESDF/search1.gif');"
			 * ); m$.Cmd.Write("\r\n#OK");
			 * //m$.Cmd.Write("\r\n#YMEDPatientD23~ASDAS"); } else { mPage =
			 * (mPage) Class.forName(className).newInstance();
			 * mPage.setContext(m$); mPage.Page(); }
			 */
			mPage = (mPage) Class.forName(className).newInstance();
			mPage.setContext(m$);
			mPage.Page();

		} catch (Exception e) {
			throw new ServletException("Fail to execute URL " + className, e);
		}
	}
}
