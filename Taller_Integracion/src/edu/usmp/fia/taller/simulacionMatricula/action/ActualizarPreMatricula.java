package edu.usmp.fia.taller.simulacionMatricula.action;

import javax.servlet.annotation.WebServlet;

import edu.usmp.fia.taller.common.dao.DAOFactory;
import edu.usmp.fia.taller.common.action.ActionServlet;
import edu.usmp.fia.taller.common.action.Default;
import edu.usmp.fia.taller.common.action.HttpMethod;
import edu.usmp.fia.taller.common.action.HttpMethodType;
import edu.usmp.fia.taller.common.action.RequireLogin;

@WebServlet("/ActualizarPreMatricula")
public class ActualizarPreMatricula extends ActionServlet {

	private static final long serialVersionUID = 1L;

	@Default()
	@RequireLogin(true)
	@HttpMethod(HttpMethodType.GET)	
	public void ActualizaPreMatricula() throws Exception {
		
		DAOFactory factory =null;
		
		try 
		{
			int usuario;
			System.out.println("INGRESO AL GET");
			int correlativo = Integer.parseInt(request.getParameter("correlativo"));
			
			usuario=(int) request.getSession().getAttribute("usuario");
			
			String[] cursos = request.getParameterValues("codCurso");
			String[] seccion= request.getParameterValues("codCurso");
			
			System.out.println("COD ALUMNO => " + usuario);
			
			factory= DAOFactory.getDAOFactory(DAOFactory.MYSQL);
			boolean eliminar= factory.getSimulacionMatricula().EliminarPreMatricula(correlativo);
			
			if (eliminar)
			{				
				for (int i=0;i< cursos.length;i++)
				{
					boolean insertar= factory.getSimulacionMatricula().InsertarPreMatricula(correlativo,usuario,cursos[i],seccion[i]);
					
					if (insertar)
					{
						System.out.println("SE ACTUALIZÓ CORRECTAMENTE LA PRE-MATRICULA");
					}
					else 
					{
						System.out.println(" NO SE ACTUALIZÓ LA PRE-MATRICULA. FAVOR DE COMUNICARSE CON EL ÁREA DE INFORMÁTICA");
					}						
				}
			}
			else
			{
				System.out.println(" NO SE ACTUALIZÓ LA PRE-MATRICULA. FAVOR DE COMUNICARSE CON EL ÁREA DE INFORMÁTICA");
			}			
			
			request.getRequestDispatcher("SimulacionMatricula/MatriculaProgresiva/Alumno/DetalleCurso.jsp").forward(request, response);
			
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
