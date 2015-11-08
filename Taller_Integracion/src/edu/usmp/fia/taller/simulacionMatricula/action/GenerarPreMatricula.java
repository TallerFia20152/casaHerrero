package edu.usmp.fia.taller.simulacionMatricula.action;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpSession;

import edu.usmp.fia.taller.common.dao.DAOFactory;
import edu.usmp.fia.taller.common.action.ActionServlet;
import edu.usmp.fia.taller.common.action.Default;
import edu.usmp.fia.taller.common.action.HttpMethod;
import edu.usmp.fia.taller.common.action.HttpMethodType;
import edu.usmp.fia.taller.common.action.RequireLogin;
import edu.usmp.fia.taller.common.action.SessionParameters;
import edu.usmp.fia.taller.common.bean.Usuario;

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
			//boolean eliminar=false;
			boolean registro=false;
			boolean eliminar=false;
			boolean existe=false;
			String mensaje="";
			
			String[] codCurso = request.getParameterValues("codigos");			
			
			HttpSession sesion= request.getSession();
			Usuario oUsuario= (Usuario) sesion.getAttribute(SessionParameters.USUARIO.text());
			
			factory= DAOFactory.getDAOFactory(DAOFactory.MYSQL);
			
			
			existe= factory.getSimulacionMatricula().BuscarPreMatricula(oUsuario.getPersona().getIdPersona().toString());

			if (existe)
			{
				eliminar= factory.getSimulacionMatricula().EliminarHorariosAlumno(oUsuario.getPersona().getIdPersona().toString());
				eliminar= factory.getSimulacionMatricula().EliminarPreMatricula(oUsuario.getPersona().getIdPersona().toString());				
			}
			for(int i=0;i<codCurso.length;i++)
			{
				System.out.println("CURSO "+ codCurso[i]);
			}
		
			registro= factory.getSimulacionMatricula().GenerarPreMatricula(oUsuario.getPersona().getIdPersona().toString(),codCurso);
			
			System.out.println("INGRESARÁ");
			if(registro)
			{
				System.out.println("CORRECTO");
				mensaje="Se registró correctamente los cursos preferibles";
			}
			else
			{
				System.out.println("INCORRECTO");
				mensaje="No se pudo registrar los cursos preferibles, favor de reintentar.Si el error persistiese comuniquese con el Area de Informatica";
			}	
		
			
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
