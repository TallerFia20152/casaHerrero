package edu.usmp.fia.taller.simulacionMatricula.action;

import java.util.ArrayList;
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
import edu.usmp.fia.taller.common.bean.SimulacionMatricula.Seccion;
import edu.usmp.fia.taller.common.bean.Usuario;
/**
 * Servlet implementation class ListaCursosServlet
 */

@WebServlet("/SeleccionarHorarios")
public class SeleccionarHorarios extends ActionServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Default()
	@RequireLogin(true)
	@HttpMethod(HttpMethodType.GET)	
	public void ListarCursosAptosPreferible() throws Exception {
		
		List<Curso> listado=null;
		List<Curso> listadoReturn=null;
		DAOFactory factory =null;
		
		try 
		{
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
				existe=false;
				existe= factory.getSimulacionMatricula().BuscarHorariosAlumnos(oUsuario.getPersona().getIdPersona().toString());
				
				if (existe) 
				{
					request.setAttribute("mensaje", "Ya seleccionó los horarios de sus cursos preferibles");
					request.getRequestDispatcher("SimulacionMatricula/mensaje.jsp").forward(request, response);
				}
				else 
				{
					List<Seccion> listadoSeccion= new ArrayList<Seccion>();
					listadoReturn= new ArrayList<Curso>();
					listado= factory.getSimulacionMatricula().CursosPreferibles(oUsuario.getPersona().getIdPersona().toString());
					for(Curso cursoPreferible:listado)
					{
						listadoSeccion=factory.getSimulacionMatricula().SeleccionarSeccion(cursoPreferible.getCodigo());
						cursoPreferible.setSeccion(listadoSeccion);
						listadoReturn.add(cursoPreferible);
					}
					request.setAttribute("listadoCursos", listadoReturn);
					request.getRequestDispatcher("SimulacionMatricula/SeleccionarHorarios.jsp").forward(request, response);
				}
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
