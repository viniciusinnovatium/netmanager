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

		www www = new www();
		www.setContext(m$);
		www.Page();
	}

}
