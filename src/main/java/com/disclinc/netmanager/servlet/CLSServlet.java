package com.disclinc.netmanager.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mLibrary.mContext;
import mLibrary.mPage;

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
		mContext m$ = new mContext(response.getWriter());
		request.getSession(true);
		m$.setRequest(gerenateRequest(request));
		m$.setSession(gerenateSession(request));
		
				
		String className = request.getServletPath().replace("/", "")
					.replace(".cls", "");
		className = className.replaceFirst("%", "\\$");

		mPage mPage;
		try {
			mPage = (mPage) Class.forName(className).newInstance();
			mPage.setContext(m$);
			mPage.OnPage((Object[]) null);
			
		} catch (ClassNotFoundException e) {
			className = "User."+className;
			try {
				mPage = (mPage) Class.forName(className).newInstance();
				mPage.setContext(m$);
				mPage.OnPage((Object[]) null);
			} catch (Exception e1) {
				throw new ServletException("Fail to execute URL " + className, e1);
			} 
			
		}catch (Exception e) {
			throw new ServletException("Fail to execute URL " + className, e);
		}

	}

}
