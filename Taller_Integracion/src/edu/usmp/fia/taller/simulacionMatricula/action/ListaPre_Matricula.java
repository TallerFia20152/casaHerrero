package edu.usmp.fia.taller.simulacionMatricula.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.annotation.WebServlet;

import edu.usmp.fia.taller.common.dao.DAOFactory;
import edu.usmp.fia.taller.common.action.ActionServlet;
import edu.usmp.fia.taller.common.action.Default;
import edu.usmp.fia.taller.common.action.HttpMethod;
import edu.usmp.fia.taller.common.action.HttpMethodType;
import edu.usmp.fia.taller.common.action.RequireLogin;
import edu.usmp.fia.taller.common.bean.SimulacionMatricula.Curso;

@WebServlet("/ListaPre_Matricula")
public class ListaPre_Matricula extends ActionServlet {

	private static final long serialVersionUID = 1L;

	@Default()
	@RequireLogin(true)
	@HttpMethod(HttpMethodType.GET)	
	public void ListarPre_Matricula() throws Exception {
		
		List<Curso> listaCursos= null;
		DAOFactory factory =null;
		
		try 
		{
			int codigoAlumno = Integer.parseInt(request.getParameter("codAlumno"));
			
			System.out.println("codigo del alumno " + codigoAlumno);
			
			factory= DAOFactory.getDAOFactory(DAOFactory.MYSQL);
			listaCursos = factory.getSimulacionMatricula().ListarPreMatricula(codigoAlumno);
			
			if (listaCursos==null)
				listaCursos=new ArrayList<Curso>();
			
			System.out.println("DATOS " + listaCursos);
			System.out.println("LISTADO DE CURSOS Y AREAS");

			request.setAttribute("CursosPropuestos", listaCursos);
			request.getRequestDispatcher("SimulacionMatricula/MatriculaProgresiva/Encargado/ListarPreMatricula.jsp").forward(request, response);
			
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
