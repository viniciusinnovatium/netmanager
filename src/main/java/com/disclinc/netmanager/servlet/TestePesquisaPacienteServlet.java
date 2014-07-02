package com.disclinc.netmanager.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.innovatium.mumps2java.dataaccess.MedpatientDAO;
import br.com.innovatium.mumps2java.dataaccess.ServiceLocator;
import br.com.innovatium.mumps2java.dataaccess.ServiceLocatorException;
import br.com.innovatium.mumps2java.model.Medpatient;

/**
 * Servlet implementation class TestePesquisaPacienteServlet
 */
public class TestePesquisaPacienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TestePesquisaPacienteServlet() {
		super();
		// TODO Auto-generated constructor stub
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
		try {
			MedpatientDAO dao = ServiceLocator.locate(MedpatientDAO.class);
			Medpatient p = dao.find(request.getParameter("id"));
			if (p != null) {
				response.getWriter().write(
						"O nome do paciente eh: " + p.getName());
			} else {
				response.getWriter().write("Nao existe paciente");
			}

			List<Medpatient> l = dao.total(request.getParameter("id"));
			response.getWriter().write("\nTotal de pacientes eh: " + l.size());

		} catch (ServiceLocatorException e) {
			throw new ServletException(e);
		}
	}

}
