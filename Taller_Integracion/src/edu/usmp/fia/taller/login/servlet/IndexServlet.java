package edu.usmp.fia.taller.login.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.usmp.fia.taller.common.action.ActionServlet;
import edu.usmp.fia.taller.common.action.Default;
import edu.usmp.fia.taller.common.action.RequireLogin;

@WebServlet("/index")
public class IndexServlet extends ActionServlet {

	private static final long serialVersionUID = 1L;
       
	@Default
	@RequireLogin(false)
	public void index() throws ServletException, IOException {
		request.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
	} 

}
