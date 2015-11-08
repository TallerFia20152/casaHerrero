package edu.usmp.fia.taller.simulacionMatricula.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import edu.usmp.fia.taller.common.action.SessionParameters;
import edu.usmp.fia.taller.common.bean.Usuario;
import edu.usmp.fia.taller.common.bean.SimulacionMatricula.Curso;
import edu.usmp.fia.taller.common.bean.SimulacionMatricula.Seccion;
import edu.usmp.fia.taller.common.dao.DAOFactory;

@WebServlet("/SeleccionaHorarios")
public class SeleccionaHorarios_ajax extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SeleccionaHorarios_ajax() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.err.println("INGRESA SELECIONA");
		
		List<Curso> listado=null;
		List<Curso> listadoReturn=null;
		DAOFactory factory =null;
		
		try 
		{
			System.out.println("INGRESOOOO");
			boolean existe=false;
			
			HttpSession sesion= request.getSession();
			Usuario oUsuario= (Usuario) sesion.getAttribute(SessionParameters.USUARIO.text());
			
			factory= DAOFactory.getDAOFactory(DAOFactory.MYSQL);
			
			existe= factory.getSimulacionMatricula().BuscarPreMatricula(oUsuario.getPersona().getIdPersona().toString());
								
			if(!existe)
			{				
				request.setAttribute("mensaje", "Usted no a escogido sus cursos preferibles");
				request.getRequestDispatcher("SimulacionMatricula/mensaje.jsp").forward(request, response);
			}
			else				
			{
				/*
				existe=false;
				existe= factory.getSimulacionMatricula().BuscarHorariosAlumnos(oUsuario.getPersona().getIdPersona().toString());
				
				if (existe) 
				{
					request.setAttribute("mensaje", "Ya seleccionó los horarios de sus cursos preferibles");
					request.getRequestDispatcher("SimulacionMatricula/mensaje.jsp").forward(request, response);
				}
				else 
				{
				*/
					List<Seccion> listadoSeccion= new ArrayList<Seccion>();
					listadoReturn= new ArrayList<Curso>();
					listado= factory.getSimulacionMatricula().CursosPreferibles(oUsuario.getPersona().getIdPersona().toString());
					
					for(Curso cursoPreferible:listado)
					{
						
						listadoSeccion=factory.getSimulacionMatricula().SeleccionarSeccion(cursoPreferible.getCodigo());
						
						for(Seccion seccion:listadoSeccion)
						{
							System.err.println("SECCION " + seccion.getId());
							System.err.println("SECCION " + seccion.getDescripcion());
						}
						cursoPreferible.setSeccion(listadoSeccion);
						listadoReturn.add(cursoPreferible);
						
					}
					
					response.setContentType("application/json;charset=UTF-8");
					Gson gson = new Gson();				
			        String json = gson.toJson(listado);
			        response.getWriter().write(json);
						
		            System.out.println("SALE DEL SERVLET SELECCIONAAHORARIOS");
					//request.setAttribute("listadoCursos", listadoReturn);
					//request.getRequestDispatcher("SimulacionMatricula/SeleccionarHorarios.jsp").forward(request, response);
				//}			
				
		}			
		} catch (Exception e) {
			System.out.println("ERROR ListarCursosAptosPreferibles ====>> " +e.getMessage() + "");
		}
		finally
		{
			if (listado!=null)
				listado=null;
			
			if (factory!=null)							
				factory=null;					
		}
		
		
	}

}
