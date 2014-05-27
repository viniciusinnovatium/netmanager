package com.disclinc.netmanager.servlet;

import java.io.IOException;
import java.io.Writer;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import mLibrary.mContext;
import mLibrary.mFnc;
import mLibrary.mRequest;
import mLibrary.mSession;
import mLibrary.mVar;
import User.www;

public class NetmanagerRequestHandler {

	public void doPaciente(HttpServletRequest request, Writer writer)
			throws IOException {
		mContext m$ = new mContext(writer);
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
		}else{
			//queryStr = queryStr.concat("&YANZ=@net_Manager");
		}
		populateRequest(request, queryStr);
		m$.setRequest(gerenateRequest(request));
		m$.setSession(gerenateSession(request));

		www www = new www();
		www.setContext(m$);
		www.OnPage(null);
		System.out
				.println("###################### FIM DE EXECUÇÃO! #############################");

	}

	public void doMenu(HttpServletRequest request, Writer writer)
			throws IOException {
		mContext m$ = new mContext(writer);
		m$.var("^WWWUSER", 0, "10010643489", 1)
				.set("^1441,1450,1459,~INNOV~63314~55641~0~0~10~FRAME210010643489~0~0~~~~MEDPatient~~~~~PT~0~1~~~~~~~~~~~~~~MSIE~192.168.100.156");
		m$.var("%", "%KEY", "YFORMWAIT").set(1);
		request.getSession(true);
		populateRequest(request,
				"EP=WWWMENU&YUSER=10010643489&YBED=INNOV&YUCI=SESDF&YM=0&YXURL=");
		m$.setRequest(gerenateRequest(request));
		m$.setSession(gerenateSession(request));

		www www = new www();
		www.setContext(m$);
		www.OnPage(null);
		System.out
				.println("###################### FIM DE EXECUÇÃO! #############################");
	}

	public void doTest(HttpServletRequest request, Writer writer)
			throws IOException {
		mContext m$ = new mContext(writer);
		Object[] subs = new Object[] { "^WWW001", "0", "FINAPInvPrePost", "1" };
		mVar var = m$.var(subs);

		m$.Cmd.Write("<!DOCTYPE html><html><head><meta charset=\"ISO-8859-1\"> <title>Insert title here</title><body>");

		m$.Cmd.Write("<label>Recuperando o valor: " + var.get()
				+ "</label></br>");
		String next = null;

		m$.var("^WWW001", "VINICIUS", "B").set("B");
		m$.var("^WWW001", "VINICIUS", "C").set("C");
		m$.var("^WWW001", "VINICIUS", "A").set("A");
		m$.var("^WWW001", "VINICIUS", "1A").set("1A");
		m$.var("^WWW001", "VINICIUS", "2A").set("2A");
		m$.var("^WWW001", "VINICIUS", "3").set("3");

		m$.Cmd.Write("<label>Recuperando o valor inserido: "
				+ m$.var("^WWW001", "VINICIUS", "C").get() + "</label></br>");

		subs = new Object[] { "^WWW001", "VINICIUS", "1A" };
		var = m$.var(subs);
		while (!"".equals((next = mFnc.$order(var).toString()))) {
			m$.Cmd.Write("<label>dolar order: " + next + "</label></br>");
			subs[subs.length - 1] = next;
			var = m$.var(subs);
		}

		// Refazendo o mesmo dolar order para verificar o cache de acesso a
		// banco
		subs = new Object[] { "^WWW001", "VINICIUS", "1A" };
		var = m$.var(subs);
		while (!"".equals((next = mFnc.$order(var).toString()))) {
			m$.Cmd.Write("<label>outro dolar order: " + next + "</label></br>");
			subs[subs.length - 1] = next;
			var = m$.var(subs);
		}

		m$.var("^WWW001", "VINICIUS", "3").set(66);
		m$.Cmd.Write("<label>modificado em cache: "
				+ m$.var("^WWW001", "VINICIUS", "3").get() + "</label></br>");
		m$.Cmd.Write("</body></html>");
	}

	private mRequest gerenateRequest(HttpServletRequest request) {
		Enumeration<String> keys = request.getAttributeNames();

		Map<String, String[]> requestMap = new HashMap<String, String[]>();
		while (keys.hasMoreElements()) {
			String key = keys.nextElement();
			requestMap.put(key,
					new String[] { String.valueOf(request.getAttribute(key)) });
		}
		return new mRequest(requestMap);
	}

	private mSession gerenateSession(HttpServletRequest request) {
		Enumeration<String> keys = request.getSession().getAttributeNames();

		Map<String, String[]> sessionMap = new HashMap<String, String[]>();
		while (keys.hasMoreElements()) {
			String key = keys.nextElement();
			sessionMap.put(key, new String[] { String.valueOf(request
					.getSession().getAttribute(key)) });
		}
		return new mSession(sessionMap);
	}

	public static void populateRequest(HttpServletRequest req, String str) {
		String[] atributos = str.split("&");
		String[] parameter = null;
		for (String attr : atributos) {
			parameter = attr.split("=");
			if (parameter.length == 1) {
				req.setAttribute(parameter[0], "");
			} else if (parameter.length == 2) {
				req.setAttribute(parameter[0], parameter[1]);
			}

		}
	}
}
