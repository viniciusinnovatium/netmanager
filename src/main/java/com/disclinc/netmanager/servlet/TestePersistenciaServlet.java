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

		String id = "0||9999993";
		String classname = "MEDPatient";
		obj.saveRecord(m$, classname, id, record);
		m$.Cmd.Write("\nRegistro salvo para o ID: " + id);

		record = obj.loadRecord(m$, classname, "0||85");
		m$.Cmd.Write("\nRegistro carregado: " + record);

		obj.deleteRecord(m$, classname, id);
		record = obj.loadRecord(m$, classname, id);
		m$.Cmd.Write("\nRegistro do ID " + id + " foi removido: "
				+ (record == null || record.isEmpty()));

	}
}
