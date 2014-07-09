package com.disclinc.netmanager.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mLibrary.mContext;

/**
 * Servlet implementation class TesteAlteracaoCacheDistribuidoServlet
 */
public class TesteAlteracaoCacheDistribuidoServlet extends NetmanagerServlet {
	private static final long serialVersionUID = 1L;

	@Override
	void doHandleRequest(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {

		mContext m$ = new mContext(response);
		
		Object antes = m$.var("^teste", "pedido", "vinicius", "valor").get();
		m$.Cmd.Write("valor antes da alteracao do cache: "+antes);
		
		m$.var("^teste", "pedido", "vinicius", "valor").set(88);
		
		Object depois = m$.var("^teste", "pedido", "vinicius", "valor").get();
		m$.Cmd.Write("\nvalor depois da alteracao do cache: "+depois);
		
	}

}
