package edu.usmp.fia.taller.simulacionMatricula.action;

import java.util.List;

import javax.servlet.annotation.WebServlet;

import edu.usmp.fia.taller.common.dao.DAOFactory;
import edu.usmp.fia.taller.common.action.ActionServlet;
import edu.usmp.fia.taller.common.action.Default;
import edu.usmp.fia.taller.common.action.HttpMethod;
import edu.usmp.fia.taller.common.action.HttpMethodType;
import edu.usmp.fia.taller.common.action.RequireLogin;
import edu.usmp.fia.taller.common.bean.SimulacionMatricula.Area;

@WebServlet("/SimulacionPreferido")
public class SimulacionPreferido extends ActionServlet {

	private static final long serialVersionUID = 1L;

	@Default()
	@RequireLogin(true)
	@HttpMethod(HttpMethodType.GET)	
	public void SimularCursoPreferido() throws Exception {
		
		List<Area> listaArea= null;
		DAOFactory factory =null;
		
		try 
		{
			System.out.println("INGRESO AL GET");
						
			factory= DAOFactory.getDAOFactory(DAOFactory.MYSQL);
			listaArea = factory.getSimulacionMatricula().SimulacionCursosPreferidos();
			
			System.out.println("LISTA DE AREAS "+ listaArea);

			request.setAttribute("listaAreaCurso", listaArea);
			request.getRequestDispatcher("SimulacionMatricula/SimulacionCursosPreferidos.jsp").forward(request, response);
			
		} catch (Exception e) {
			System.out.println("ERROR ====>> " +e.getMessage() + "");
			e.printStackTrace();
		}
		finally
		{
			if (listaArea!=null)
				listaArea=null;
			
			if (factory!=null)							
				factory=null;					
		}
	}
}
