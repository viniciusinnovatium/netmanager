package com.disclinc.netmanager.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mLibrary.mContext;
import mLibrary.mNMObject;

/**
 * Servlet implementation class TestePersistenciaServlet
 */
public class TestePersistenciaServlet extends NetmanagerServlet {
	private static final long serialVersionUID = 1L;

	@Override
	void doHandleRequest(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		mContext m$ = new mContext(response);
		mNMObject obj = new mNMObject();
		String record = obj.loadRecord(m$, "MEDPatient", "0||85");
		
		obj.saveRecord(m$, "MEDPatient", "0||9999999", record);
		record = obj.loadRecord(m$, "MEDPatient", "0||85");
		m$.Cmd.Write("\n"+record);
	}

	
}
