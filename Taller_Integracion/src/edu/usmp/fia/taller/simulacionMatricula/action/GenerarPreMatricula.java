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
		
		
		DAOFactory factory =null;
		
		try 
		{
			boolean registro=false;
			String mensaje="";
			
			System.out.println("INGRESO AL GET");
			String codAlumno = request.getParameter("codAlumno");			
			String[] codCurso = request.getParameterValues("codCurso");
			
			System.out.println("COD ALUMNO => " + codCurso);
			
			factory= DAOFactory.getDAOFactory(DAOFactory.MYSQL);
			registro= factory.getSimulacionMatricula().GenerarPreMatricula(codAlumno,codCurso);
			
			if(registro)
			{
				mensaje="Se gener� correctamente la Pre Matricula";
			}
			else
			{
				mensaje="No se gener� la Pre Matricula";
			}
			
			request.setAttribute(mensaje, "mensaje");
			request.getRequestDispatcher("SimulacionMatricula/MatriculaProgresiva/mensaje.jsp").forward(request, response);
			
		} catch (Exception e) {
			System.out.println("ERROR ====>> " +e.getMessage() + "");
			e.printStackTrace();
		}
		finally
		{			
			if (factory!=null)							
				factory=null;					
		}

	}
}
