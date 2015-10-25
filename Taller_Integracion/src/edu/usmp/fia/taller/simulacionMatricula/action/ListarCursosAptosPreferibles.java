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
		DAOFactory factory =null;
		
		try 
		{
			System.out.println("ingreso ListarCursosAptosPreferibles");
			//int codAlumno= Integer.parseInt(request.getParameter("codAlumno"));
			int codAlumno= 2010106278;
			
			System.out.println("COD ALUMNO => " + codAlumno );
			
			factory= DAOFactory.getDAOFactory(DAOFactory.MYSQL);
			listado= factory.getSimulacionMatricula().ListarCursosAptos(codAlumno);
						
			System.out.println("LISTADO CURSOS APTOS  " + listado);
			
			request.setAttribute("codigoAlumno", codAlumno);
			request.setAttribute("listaCursoAptoPreferibles", listado);
			request.getRequestDispatcher("SimulacionMatricula/MatriculaProgresiva/Pre_Matricula.jsp").forward(request, response);
			
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
