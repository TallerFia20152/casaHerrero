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
/**
 * Servlet implementation class ListaCursosServlet
 */

@WebServlet("/RegistrarHorarios")
public class RegistrarHorarios extends ActionServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Default()
	@RequireLogin(true)
	@HttpMethod(HttpMethodType.POST)	
	public void ListarCursosAptosPreferible() throws Exception {

		DAOFactory factory =null;
		
		try 
		{
			System.out.println("INGRESO A RegistrarHorarios POST");
			boolean registro=false;
			boolean existe=false;
			String mensaje="";
			
			String[] codCurso = request.getParameterValues("codigos");
			String[] seccion = request.getParameterValues("seccion");
			
			for(int i=0;i<codCurso.length;i++)
			{
				System.out.println("CURSO   "+ codCurso[i]);
				seccion[i]=seccion[i].substring(0,4);
				
				System.out.println("SECCION "+ seccion[i]);
			}
			
			HttpSession sesion= request.getSession();
			Usuario oUsuario= (Usuario) sesion.getAttribute(SessionParameters.USUARIO.text());
			
			factory= DAOFactory.getDAOFactory(DAOFactory.MYSQL);
			existe= factory.getSimulacionMatricula().BuscarHorariosAlumnos(oUsuario.getPersona().getIdPersona().toString());

			
			if (!existe)
			{
				registro= factory.getSimulacionMatricula().RegistrarHorariosAlumno(oUsuario.getPersona().getIdPersona().toString(),codCurso,seccion);
				
				System.out.println("INGRESARÁ");
				if(registro)
				{
					System.out.println("CORRECTO");
					mensaje="Se registró correctamente los horarios para los cursos preferidos.";
				}
				else
				{
					System.out.println("INCORRECTO");
					mensaje="No se pudo escoger los horarios para los cursos preferidos.";
				}		
				
			}else
			{
				mensaje="Usted ya seleccionó los horarios de sus Cursos Preferibles.";
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
