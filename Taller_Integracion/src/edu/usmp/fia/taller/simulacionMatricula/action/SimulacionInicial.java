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

@WebServlet("/SimulacionInicial")
public class SimulacionInicial extends ActionServlet {

	private static final long serialVersionUID = 1L;

	@Default()
	@RequireLogin(true)
	@HttpMethod(HttpMethodType.GET)	
	public void SimulacionInicialGeneral() throws Exception {
		
		List<Area> listaArea= null;
		DAOFactory factory =null;
		
		try 
		{
			System.out.println("INGRESO AL GET");
						
			factory= DAOFactory.getDAOFactory(DAOFactory.MYSQL);
			listaArea = factory.getSimulacionMatricula().SimulacionIncial();
			
			System.out.println("LISTADO DE CURSOS Y AREAS");
			/*
			for (int i=0;i<listaArea.size();i++)
			{
				System.out.println("CODIGO =>"+  listaArea.get(i).getId());
				System.out.println("AREA =>"+  listaArea.get(i).getNombre());			
				
				for (int j=0;j<listaArea.get(i).getCursoList().size();j++)
				{
					//System.out.println("LISTA DE AREA Y CURSO ===> "+ listaArea.get(arg0) );
					System.out.println("CURSO =>"+  listaArea.get(i).getCursoList().get(j).getCodigo());
					System.out.println("CURSO =>"+  listaArea.get(i).getCursoList().get(j).getCurso());
					System.out.println("CICLO =>"+  listaArea.get(i).getCursoList().get(j).getCiclo());
					System.out.println("CANTIDAD ALUMNOS =>"+  listaArea.get(i).getCursoList().get(j).getCantidadAlumnos());					
				}				
			}		
			*/
			request.setAttribute("listaAreaCurso", listaArea);
			request.getRequestDispatcher("SimulacionMatricula/SimulacionInicial.jsp").forward(request, response);
			
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
