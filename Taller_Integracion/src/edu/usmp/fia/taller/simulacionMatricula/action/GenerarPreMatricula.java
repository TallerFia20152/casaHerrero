package edu.usmp.fia.taller.simulacionMatricula.action;

import javax.servlet.annotation.WebServlet;

import edu.usmp.fia.taller.common.dao.DAOFactory;
import edu.usmp.fia.taller.common.action.ActionServlet;
import edu.usmp.fia.taller.common.action.Default;
import edu.usmp.fia.taller.common.action.HttpMethod;
import edu.usmp.fia.taller.common.action.HttpMethodType;
import edu.usmp.fia.taller.common.action.RequireLogin;

@WebServlet("/GenerarPreMatricula")
public class GenerarPreMatricula extends ActionServlet {

	private static final long serialVersionUID = 1L;

	@Default()
	@RequireLogin(true)
	@HttpMethod(HttpMethodType.POST)	
	public void GeneraPreMatricula() throws Exception {

		DAOFactory factory =null;
		
		try 
		{
			System.out.println("INGRESO");
			boolean registro=false;
			String mensaje="";
			String[] codCurso = request.getParameterValues("codigos");
			
			String codigoAlumno=request.getParameter("codigoAlumno");
			
			System.out.println("COD ALUMNO => " + codigoAlumno);
			
			for(int i=0;i<codCurso.length;i++)
			{
				System.out.println("CURSO "+ codCurso[i]);
			}
			
			factory= DAOFactory.getDAOFactory(DAOFactory.MYSQL);
			registro= factory.getSimulacionMatricula().GenerarPreMatricula(codigoAlumno,codCurso);
			
			System.out.println("INGRESARÁ");
			if(registro)
			{
				System.out.println("CORRECTO");
				mensaje="Se generó correctamente la Pre Matricula";
			}
			else
			{
				System.out.println("INCORRECTO");
				mensaje="No se pudo generar la Pre Matricula";
			}
			
			System.out.println("DATO DE LA VARIABLE MENSAJE");
			
			request.setAttribute("mensaje", mensaje);
			request.getRequestDispatcher("SimulacionMatricula/mensaje.jsp").forward(request, response);
			
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
