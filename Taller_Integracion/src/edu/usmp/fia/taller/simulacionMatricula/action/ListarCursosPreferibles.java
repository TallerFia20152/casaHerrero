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

@WebServlet("/ListarCursosPreferibles")
public class ListarCursosPreferibles extends ActionServlet {

	private static final long serialVersionUID = 1L;

	@Default()
	@RequireLogin(true)
	@HttpMethod(HttpMethodType.GET)	
	public void ListarCursosPreferible() throws Exception {
		
		List<Curso> listaCursos= null;
		DAOFactory factory =null;
		
		try 
		{
			String codigoAlumno = request.getParameter("codAlumno");			
			factory= DAOFactory.getDAOFactory(DAOFactory.MYSQL);
			
			listaCursos = factory.getSimulacionMatricula().CursosPreferibles(codigoAlumno);
			System.out.println("LISTADO DE CURSOS PREFERIBLES "+ listaCursos);
			
			request.setAttribute("CursosPeferibles", listaCursos);
			request.getRequestDispatcher("SimulacionMatricula/CursosPreferibles.jsp").forward(request, response);
			
		} catch (Exception e) {
			System.out.println("ERROR ====>> " +e.getMessage() + "");
			e.printStackTrace();
		}
		finally
		{
			if (listaCursos!=null)
				listaCursos=null;
			
			if (factory!=null)							
				factory=null;					
		}
	}
}
