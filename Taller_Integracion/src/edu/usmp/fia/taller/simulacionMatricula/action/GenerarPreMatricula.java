package edu.usmp.fia.taller.simulacionMatricula.action;

import javax.servlet.annotation.WebServlet;

import edu.usmp.fia.taller.common.dao.DAOFactory;
import edu.usmp.fia.taller.common.action.ActionServlet;
import edu.usmp.fia.taller.common.action.Default;
import edu.usmp.fia.taller.common.action.HttpMethod;
import edu.usmp.fia.taller.common.action.HttpMethodType;
import edu.usmp.fia.taller.common.action.RequireLogin;
import edu.usmp.fia.taller.common.bean.SimulacionMatricula.Curso;

@WebServlet("/GenerarPreMatricula")
public class GenerarPreMatricula extends ActionServlet {

	private static final long serialVersionUID = 1L;

	@Default()
	@RequireLogin(true)
	@HttpMethod(HttpMethodType.GET)	
	public void GeneraPreMatricula() throws Exception {
		
		Curso curso=null;
		DAOFactory factory =null;
		
		try 
		{
			System.out.println("INGRESO AL GET");
			String codAlumno = request.getParameter("codAlumno");
			
			String[] codCurso = request.getParameterValues("codCurso");
			
			System.out.println("COD ALUMNO => " + codCurso);
			
			factory= DAOFactory.getDAOFactory(DAOFactory.MYSQL);
			curso= factory.getSimulacionMatricula().ListarDetalleCurso(codAlumno);
			
			curso= factory.getSimulacionMatricula().ListarDetalleCurso(codAlumno);
			
			request.getRequestDispatcher("SimulacionMatricula/MatriculaProgresiva/Encargado/GenerarPreMatricula.jsp").forward(request, response);
			
		} catch (Exception e) {
			System.out.println("ERROR ====>> " +e.getMessage() + "");
			e.printStackTrace();
		}
		finally
		{
			if (curso!=null)
				curso=null;
			
			if (factory!=null)							
				factory=null;					
		}

	}
}
