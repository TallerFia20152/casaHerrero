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

@WebServlet("/AlumnoListarCursosPropuestos")
public class AlumnoListarCursosPropuestos extends ActionServlet {

	private static final long serialVersionUID = 1L;

	@Default()
	@RequireLogin(true)
	@HttpMethod(HttpMethodType.GET)	
	public void CursosPropuesto() throws Exception {
		
		List<Curso> listaCursos= null;
		DAOFactory factory =null;
		
		try 
		{
			int codigoAlumno =2010106278;
						
			factory= DAOFactory.getDAOFactory(DAOFactory.MYSQL);
			listaCursos = factory.getSimulacionMatricula().CursosPropuestos(codigoAlumno);
			
			if (listaCursos==null)
				listaCursos=new ArrayList<Curso>();


			request.setAttribute("CursosPropuestos", listaCursos);
			request.getRequestDispatcher("SimulacionMatricula/MatriculaProgresiva/Alumno/CursosPropuestos.jsp").forward(request, response);
			
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
