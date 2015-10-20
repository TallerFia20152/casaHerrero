package edu.usmp.fia.taller.simulacionMatricula.action;

import java.util.List;

import javax.servlet.annotation.WebServlet;

import edu.usmp.fia.taller.common.dao.DAOFactory;
import edu.usmp.fia.taller.common.action.ActionServlet;
import edu.usmp.fia.taller.common.action.Default;
import edu.usmp.fia.taller.common.action.HttpMethod;
import edu.usmp.fia.taller.common.action.HttpMethodType;
import edu.usmp.fia.taller.common.action.RequireLogin;
import edu.usmp.fia.taller.common.bean.SimulacionMatricula.Alumno;

/**
 * Servlet implementation class ListaCursosServlet
 */

@WebServlet("/ListarAlumnos")
public class ListarAlumnos extends ActionServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Default()
	@RequireLogin(true)
	@HttpMethod(HttpMethodType.GET)	
	public void ListarAlumno() throws Exception {
		
		List<Alumno> listado=null;
		DAOFactory factory =null;
		
		try 
		{			
			System.out.println("ingreso get Listar Alumnos");
			factory= DAOFactory.getDAOFactory(DAOFactory.MYSQL);
			listado= factory.getSimulacionMatricula().ListarAlumnos();
			
			System.out.println("Envia datos al jsp");
			request.setAttribute("listaAlumno", listado);
			request.getRequestDispatcher("SimulacionMatricula/MatriculaProgresiva/Encargado/ListarAlumnos.jsp").forward(request, response);
			
		} catch (Exception e) {
			System.out.println("ERROR ====>> " +e.getMessage() + "");
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
