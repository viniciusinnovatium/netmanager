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
		System.out.println("");
		System.out
				.println("###################### FIM DE EXECUÇÃO! #############################");
		System.out
				.println("Tempo(s)" + (end.getTime() - init.getTime()) / 1000);
	}

	abstract void doHandleRequest(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException;
	
}
