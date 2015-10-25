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
import edu.usmp.fia.taller.common.bean.convalidacioncurso.Departamento;
import edu.usmp.fia.taller.common.bean.convalidacioncurso.Distrito;
import edu.usmp.fia.taller.common.bean.convalidacioncurso.Especialidad;
import edu.usmp.fia.taller.common.bean.convalidacioncurso.Facultad;
import edu.usmp.fia.taller.common.bean.convalidacioncurso.ModalidadIngreso;
import edu.usmp.fia.taller.common.bean.convalidacioncurso.Persona;
import edu.usmp.fia.taller.common.bean.convalidacioncurso.PlanCurricularDetalle;
import edu.usmp.fia.taller.common.bean.convalidacioncurso.UniversidadOrigen;
import edu.usmp.fia.taller.common.dao.DAOFactory;


@WebServlet("/convalidacion")
public class HistoriaConvalidacion extends ActionServlet {
	 @HttpMethod(HttpMethodType.POST)
	    @RequireLogin(false)
	    public void convalidacion() throws IOException, Exception {
	        List<PlanCurricularDetalle> detalles = null;
	        Alumno alu = new Alumno();
	        alu.setPersona(new Persona());
	        alu.getPersona().setId(request.getParameter("codalu"));
	        DAOFactory oDAOFactory;
	        response.setContentType("application/json;charset=UTF-8");
	        PrintWriter out = response.getWriter();
	        Gson gson = new Gson();
	        try {
	            oDAOFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
	            detalles = oDAOFactory.getConvalidacion().getHistoriaConvalidacion().listarcursos(alu);
	        } catch (Exception e) {
	            e.getMessage();
	            throw e;
	        } finally {
	            out.print(gson.toJson(detalles));
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
	            alumno.getPersona().setId(request.getParameter("codigo"));
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

	    
	    @HttpMethod(HttpMethodType.POST)
	    @RequireLogin(false)
	    public void obtenerDatosAlumno() throws IOException, Exception {
	        Alumno alu = new Alumno();
	        alu.setPersona(new Persona());
	        alu.getPersona().setId(request.getParameter("codalu"));
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
	    

	    @HttpMethod(HttpMethodType.GET)
	    @RequireLogin(false)
	    public void listarUniversidades() throws IOException, Exception {
	    	List<UniversidadOrigen> unis = null;
        
	        DAOFactory oDAOFactory;
	        response.setContentType("application/json;charset=UTF-8");
	        PrintWriter out = response.getWriter();
	        Gson gson = new Gson();
	        try {
	            oDAOFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
	            unis = oDAOFactory.getConvalidacion().getHistoriaConvalidacion().listaruniversidades();
	        } catch (Exception e) {
	            e.getMessage();
	            throw e;
	        } finally {
	            out.print(gson.toJson(unis));
	            out.close();
	        }
	    }
	    
	    @HttpMethod(HttpMethodType.GET)
	    @RequireLogin(false)
	    public void listardistritos() throws IOException, Exception {
	    	List<Distrito> distritos = null;
	    	Departamento depa = new Departamento();
	    	depa.setId(Integer.parseInt(request.getParameter("coddep")));
	    	
	        DAOFactory oDAOFactory;
	        response.setContentType("application/json;charset=UTF-8");
	        PrintWriter out = response.getWriter();
	        Gson gson = new Gson();
	        try {
	            oDAOFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
	            distritos = oDAOFactory.getConvalidacion().getHistoriaConvalidacion().listardistritos(depa);
	        } catch (Exception e) {
	            e.getMessage();
	            throw e;
	        } finally {
	            out.print(gson.toJson(distritos));
	            out.close();
	        }
	    }
	    @HttpMethod(HttpMethodType.GET)
	    @RequireLogin(false)
	    public void listarespecialidades() throws IOException, Exception {
	    	List<Especialidad> especialidades = null;
	    	Facultad fac = new Facultad();
	    	fac.setId(Integer.parseInt(request.getParameter("codfac")));
	    	
	        DAOFactory oDAOFactory;
	        response.setContentType("application/json;charset=UTF-8");
	        PrintWriter out = response.getWriter();
	        Gson gson = new Gson();
	        try {
	            oDAOFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
	            especialidades = oDAOFactory.getConvalidacion().getHistoriaConvalidacion().listarespecialidades(fac);
	        } catch (Exception e) {
	            e.getMessage();
	            throw e;
	        } finally {
	            out.print(gson.toJson(especialidades));
	            out.close();
	        }
	    }
	    @HttpMethod(HttpMethodType.GET)
	    @RequireLogin(false)
	    public void listarmodalidades() throws IOException, Exception {
	    	List<ModalidadIngreso> modalidades = null;
	    	
	        DAOFactory oDAOFactory;
	        response.setContentType("application/json;charset=UTF-8");
	        PrintWriter out = response.getWriter();
	        Gson gson = new Gson();
	        try {
	            oDAOFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
	            modalidades = oDAOFactory.getConvalidacion().getHistoriaConvalidacion().listarmodalidades();
	        } catch (Exception e) {
	            e.getMessage();
	            throw e;
	        } finally {
	            out.print(gson.toJson(modalidades));
	            out.close();
	        }
	    }
}
