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

@WebServlet("/ListarCursosObligatorios")
public class ListarCursosObligatorios extends ActionServlet {

	private static final long serialVersionUID = 1L;

	@Default()
	@RequireLogin(true)
	@HttpMethod(HttpMethodType.GET)	
	public void ListarCursosObligatorio() throws Exception {
		
		List<Curso> listado=null;
		DAOFactory factory =null;
		
		try 
		{
			System.out.println("INGRESO AL GET");
			int codAlumno= Integer.parseInt(request.getParameter("codAlumno"));
			
			System.out.println("COD ALUMNO => " + codAlumno );
			
			factory= DAOFactory.getDAOFactory(DAOFactory.MYSQL);
			listado= factory.getSimulacionMatricula().ListarCursoObligatorios(codAlumno);
			
			request.setAttribute("cursos", listado);
			request.getRequestDispatcher("SimulacionMatricula/MatriculaProgresiva/Encargado/ListarCursosObligatorios.jsp").forward(request, response);
			
		} catch (Exception e) {
			System.out.println("ERROR ====>> " +e.getMessage() + "");
			e.printStackTrace();
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
