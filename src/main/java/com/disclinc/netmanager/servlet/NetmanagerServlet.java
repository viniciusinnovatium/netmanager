package com.disclinc.netmanager.servlet;

import java.io.IOException;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mLibrary.mRequest;
import mLibrary.mSession;

/**
 * Servlet implementation class NetmanagerServlet
 */
public abstract class NetmanagerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public NetmanagerServlet() {
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Date init = new Date();
		doHandleRequest(request, response);
		Date end = new Date();
		System.out
				.println("###################### FIM DE EXECU��O! #############################");
		System.out
				.println("Tempo(s)" + (end.getTime() - init.getTime()) / 1000);
	}

	abstract void doHandleRequest(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException;

	mRequest gerenateRequest(HttpServletRequest request) {
		Enumeration<String> keys = request.getAttributeNames();

		Map<String, String[]> requestMap = new HashMap<String, String[]>();
		while (keys.hasMoreElements()) {
			String key = keys.nextElement();
			requestMap.put(key,
					new String[] { String.valueOf(request.getAttribute(key)) });
		}
		return new mRequest(requestMap);
	}

	mSession gerenateSession(HttpServletRequest request) {
		Enumeration<String> keys = request.getSession().getAttributeNames();

		Map<String, String[]> sessionMap = new HashMap<String, String[]>();
		while (keys.hasMoreElements()) {
			String key = keys.nextElement();
			sessionMap.put(key, new String[] { String.valueOf(request
					.getSession().getAttribute(key)) });
		}
		return new mSession(sessionMap);
	}

	void populateRequest(HttpServletRequest req, String str) {
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
