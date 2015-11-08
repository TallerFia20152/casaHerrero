package edu.usmp.fia.taller.simulacionMatricula.action;


import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpSession;

import edu.usmp.fia.taller.common.dao.DAOFactory;
import edu.usmp.fia.taller.common.action.ActionServlet;
import edu.usmp.fia.taller.common.action.Default;
import edu.usmp.fia.taller.common.action.HttpMethod;
import edu.usmp.fia.taller.common.action.HttpMethodType;
import edu.usmp.fia.taller.common.action.RequireLogin;
import edu.usmp.fia.taller.common.action.SessionParameters;
import edu.usmp.fia.taller.common.bean.SimulacionMatricula.Curso;

import edu.usmp.fia.taller.common.bean.Usuario;
/**
 * Servlet implementation class ListaCursosServlet
 */

@WebServlet("/ListarCursosAptosPreferibles")
public class ListarCursosAptosPreferibles extends ActionServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Default()
	@RequireLogin(true)
	@HttpMethod(HttpMethodType.GET)	
	public void ListarCursosAptosPreferible() throws Exception {
		
		List<Curso> listado=null;
		List<Curso> listadoCursosPropuestos=null;
		DAOFactory factory =null;
		
		
		try 
		{
			boolean existe;
			String mensaje;	
		
			HttpSession sesion= request.getSession();
			Usuario oUsuario= (Usuario) sesion.getAttribute(SessionParameters.USUARIO.text());

			factory= DAOFactory.getDAOFactory(DAOFactory.MYSQL);
			/*
			existe= factory.getSimulacionMatricula().BuscarPreMatricula(oUsuario.getPersona().getIdPersona().toString());
			
			System.out.println("EXISTE " + existe);
			if (existe)
			{
				System.out.println("INGRESO A MENSAJE");
				mensaje="Usted ya registro sus Cursos Preferibles.";
				request.setAttribute("mensaje", mensaje);
				request.getRequestDispatcher("SimulacionMatricula/mensaje.jsp").forward(request, response);
			}
			else 
			{
			*/	
				System.out.println("INGRESO A LISTAR");
				listadoCursosPropuestos = factory.getSimulacionMatricula().CursosProbables(oUsuario.getPersona().getIdPersona().toString());
				listado= factory.getSimulacionMatricula().ListarCursosAptos(oUsuario.getPersona().getIdPersona().toString());
				
				request.setAttribute("codigoAlumno", oUsuario.getPersona().getIdPersona().toString());
				request.setAttribute("listaCursoAptoPreferibles", listado);
				request.setAttribute("listaCursoProbables", listadoCursosPropuestos);
				request.getRequestDispatcher("SimulacionMatricula/MatriculaProgresiva/Pre_Matricula.jsp").forward(request, response);
			//}			
			
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
