package edu.usmp.fia.taller.convalidacioncurso.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import com.google.gson.Gson;

import edu.usmp.fia.taller.common.action.ActionServlet;
import edu.usmp.fia.taller.common.action.Default;
import edu.usmp.fia.taller.common.action.HttpMethod;
import edu.usmp.fia.taller.common.action.HttpMethodType;
import edu.usmp.fia.taller.common.action.RequireLogin;
import edu.usmp.fia.taller.common.bean.convalidacioncurso.Alumno;
import edu.usmp.fia.taller.common.bean.convalidacioncurso.Curso;
import edu.usmp.fia.taller.common.bean.convalidacioncurso.Persona;
import edu.usmp.fia.taller.common.dao.DAOFactory;


@WebServlet("/convalidacion")
public class HistoriaConvalidacion extends ActionServlet {
	 @HttpMethod(HttpMethodType.POST)
	    @RequireLogin(false)
	    public void convalidacion() throws IOException, Exception {
	        List<Curso> Cursos = null;
	        DAOFactory oDAOFactory;
	        response.setContentType("application/json;charset=UTF-8");
	        PrintWriter out = response.getWriter();
	        Gson gson = new Gson();
	        try {
	            oDAOFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
	            Cursos = oDAOFactory.getConvalidacion().getHistoriaConvalidacion().listarcursos();
	        } catch (Exception e) {
	            e.getMessage();
	            throw e;
	        } finally {
	            out.print(gson.toJson(Cursos));
	            out.close();
	        }
	    }

	    @HttpMethod(HttpMethodType.POST)
	    @RequireLogin(false)
	    public void listarAlumnos() throws IOException, Exception {
	        List<Alumno> Alumnos = null;
	        Alumno alumno = new Alumno();
	        alumno.setPersona(new Persona());
	        if (request.getParameter("codigo") == null) {
	            alumno.getPersona().setNomcom(request.getParameter("nombre"));
	        } else {
	            alumno.getPersona().setId(Integer.parseInt(request.getParameter("codigo")));
	        }

	        DAOFactory oDAOFactory;
	        response.setContentType("application/json;charset=UTF-8");
	        PrintWriter out = response.getWriter();
	        Gson gson = new Gson();
	        try {
	            oDAOFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
	            Alumnos = oDAOFactory.getConvalidacion().getHistoriaConvalidacion().listaralumnos(alumno);
	        } catch (Exception e) {
	            e.getMessage();
	            throw e;
	        } finally {
	            out.print(gson.toJson(Alumnos));
	            out.close();
	            alumno = null;
	        }
	    }

	    @Default
	    @RequireLogin(false)
	    public void inicio() throws ServletException, IOException {
	        response.sendRedirect(request.getServletContext().getContextPath() + "/convalidacioncurso/inicio.jsp");
	    }
	    @Default
	    @RequireLogin(false)
	    public void mantenimiento() throws ServletException, IOException {
	        response.sendRedirect(request.getServletContext().getContextPath() + "/convalidacioncurso/mantenimientAlumno.jsp");
	    }
	    @Default
	    @RequireLogin(false)
	    public void reporte() throws ServletException, IOException {
	        response.sendRedirect(request.getServletContext().getContextPath() + "/convalidacioncurso/convalidarCursos.jsp");
	    }

	    @HttpMethod(HttpMethodType.POST)
	    @RequireLogin(false)
	    public void obtenerDatosAlumno() throws IOException, Exception {
	        Alumno alu = new Alumno();
	        alu.setPersona(new Persona());
	        alu.getPersona().setId(Integer.parseInt(request.getParameter("codalu")));
	        DAOFactory oDAOFactory;
	        response.setContentType("application/json;charset=UTF-8");
	        PrintWriter out = response.getWriter();
	        Gson gson = new Gson();
	        try {
	            oDAOFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
	            alu = oDAOFactory.getConvalidacion().getHistoriaConvalidacion().obtenerDatosAlumno(alu);
	        } catch (Exception e) {
	            e.getMessage();
	            throw e;
	        } finally {
	            out.print(gson.toJson(alu));
	            out.close();
	            alu = null;
	        }
	    }
	

}
