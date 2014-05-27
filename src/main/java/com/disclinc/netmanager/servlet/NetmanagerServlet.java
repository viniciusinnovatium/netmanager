package com.disclinc.netmanager.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class NetmanagerServlet
 */
public class NetmanagerServlet extends HttpServlet {
	private final NetmanagerRequestHandler requestHandler = new NetmanagerRequestHandler();
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Date init = new Date();
		requestHandler.doPaciente(request, response.getWriter());
		Date end = new Date();
		System.out.println("Tempo(s)"+(end.getTime() - init.getTime())/1000);
	}
}
