package edu.usmp.fia.taller.convalidacioncurso.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import edu.usmp.fia.taller.common.action.ActionServlet;
import edu.usmp.fia.taller.common.action.Default;
import edu.usmp.fia.taller.common.action.RequireLogin;

@WebServlet("/redireccion")
public class Redireccion extends ActionServlet {

	@Default
    @RequireLogin(false)
    public void regcur() throws ServletException, IOException {
        response.sendRedirect(request.getServletContext().getContextPath() + "/convalidacioncurso/inicio.jsp");
    }
    @Default
    @RequireLogin(false)
    public void regalu() throws ServletException, IOException {
        response.sendRedirect(request.getServletContext().getContextPath() + "/convalidacioncurso/registroAlumno.jsp");
    }
    @Default
    @RequireLogin(false)
    public void reporte() throws ServletException, IOException {
        response.sendRedirect(request.getServletContext().getContextPath() + "/convalidacioncurso/convalidarCursos.jsp");
    }
    @Default
    @RequireLogin(false)
    public void adjuntar() throws ServletException, IOException {
        response.sendRedirect(request.getServletContext().getContextPath() + "/convalidacioncurso/subirArchivos.jsp");
    }
    @Default
    @RequireLogin(false)
    public void convalidacion() throws ServletException, IOException {
        response.sendRedirect(request.getServletContext().getContextPath() + "/convalidacioncurso/convalidacion.jsp");
    }
	
}
