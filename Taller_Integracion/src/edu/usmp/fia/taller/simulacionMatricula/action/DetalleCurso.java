package edu.usmp.fia.taller.simulacionMatricula.action;

import javax.servlet.annotation.WebServlet;

import edu.usmp.fia.taller.common.dao.DAOFactory;
import edu.usmp.fia.taller.common.action.ActionServlet;
import edu.usmp.fia.taller.common.action.Default;
import edu.usmp.fia.taller.common.action.HttpMethod;
import edu.usmp.fia.taller.common.action.HttpMethodType;
import edu.usmp.fia.taller.common.action.RequireLogin;
import edu.usmp.fia.taller.common.bean.SimulacionMatricula.Curso;

@WebServlet("/DetalleCurso")
public class DetalleCurso extends ActionServlet {

	private static final long serialVersionUID = 1L;

	@Default()
	@RequireLogin(true)
	@HttpMethod(HttpMethodType.GET)	
	public void DetalleCursos() throws Exception {
		
		Curso curso=null;
		DAOFactory factory =null;
		
		try 
		{
			String codCurso = request.getParameter("codCurso");
			
			System.out.println("COD ALUMNO => " + codCurso);
			
			factory= DAOFactory.getDAOFactory(DAOFactory.MYSQL);
			curso= factory.getSimulacionMatricula().ListarDetalleCurso(codCurso);
			
			request.setAttribute("listaCursos", curso);
			request.getRequestDispatcher("SimulacionMatricula/MatriculaProgresiva/Encargado/DetalleCurso.jsp").forward(request, response);
			
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
