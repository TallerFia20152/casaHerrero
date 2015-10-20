package edu.usmp.fia.taller.simulacionMatricula.action;

import java.util.List;

import javax.servlet.annotation.WebServlet;

import edu.usmp.fia.taller.common.dao.DAOFactory;
import edu.usmp.fia.taller.common.action.ActionServlet;
import edu.usmp.fia.taller.common.action.Default;
import edu.usmp.fia.taller.common.action.HttpMethod;
import edu.usmp.fia.taller.common.action.HttpMethodType;
import edu.usmp.fia.taller.common.action.RequireLogin;
import edu.usmp.fia.taller.common.bean.SimulacionMatricula.Curso;

/**
 * Servlet implementation class ListaCursosServlet
 */

@WebServlet("/AlumnoListarCursosAptos")
public class AlumnoListarCursosAptos extends ActionServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Default()
	@RequireLogin(true)
	@HttpMethod(HttpMethodType.GET)	
	public void ListarCursosApto() throws Exception {
		
		List<Curso> listado=null;
		DAOFactory factory =null;
		
		try 
		{
			int codAlumno=2010106278;
			
			factory= DAOFactory.getDAOFactory(DAOFactory.MYSQL);
			listado= factory.getSimulacionMatricula().ListarCursosAptos(codAlumno);
			
			System.out.println("Envia datos al jsp");
			request.setAttribute("listaCursoApto", listado);
			request.getRequestDispatcher("SimulacionMatricula/MatriculaProgresiva/Alumno/CursosAptos.jsp").forward(request, response);
			
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
