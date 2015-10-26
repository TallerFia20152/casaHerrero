package edu.usmp.fia.taller.simulacionMatricula.action;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebServlet;

import edu.usmp.fia.taller.common.action.ActionServlet;
import edu.usmp.fia.taller.common.action.Default;
import edu.usmp.fia.taller.common.action.HttpMethod;
import edu.usmp.fia.taller.common.action.HttpMethodType;
import edu.usmp.fia.taller.common.action.RequireLogin;
import edu.usmp.fia.taller.common.bean.SimulacionMatricula.Alumno;
import edu.usmp.fia.taller.common.dao.DAOFactory;

@WebServlet("/EnviarCorreo")
public class EnviarCorreo extends ActionServlet {

	private static final long serialVersionUID = 1L;
	private String host;
	private String port;
	private String user;
	private String pass;

	public void init() {
		// reads SMTP server setting from web.xml file
		ServletContext context = getServletContext();
		host = context.getInitParameter("host");
		port = context.getInitParameter("port");
		user = context.getInitParameter("user");
		pass = context.getInitParameter("pass");
		
		System.out.println("HOST  " + host);
		System.out.println("PORT " + port);
		System.out.println("USUARIO  " + user);
		System.out.println("PASSWORD " + pass);
	}
	
	@Default()
	@RequireLogin(true)
	@HttpMethod(HttpMethodType.POST)	
	public void SimulacionInicialGeneral() throws Exception {
		

		//String para = request.getParameter("para");
		String asunto = request.getParameter("asunto");
		String contenido = request.getParameter("contenido");
		
		System.out.println("ASUNTO "+ asunto);
		System.out.println("CONTENIDO "+ contenido);
		
		List<Alumno> listado=null;
		DAOFactory factory =null;
		
		String mensajeCorreo="";	
		try 
		{		
			factory= DAOFactory.getDAOFactory(DAOFactory.MYSQL);
			listado= factory.getSimulacionMatricula().ListarAlumnos();	
			
			for(Alumno alumno:listado)
			{
				String para=alumno.getCorreo();
				if(para.equals("") || para==null)
				{
					
				}
				else
				{
					System.out.println("CORREO ALUMNO "+ para);				
					EmailUtility.sendEmail(host, port, user, pass, para, asunto,contenido);	
				}				
			}
			mensajeCorreo="Se envió corectamente los mensajes a los alumnos";
			
			request.setAttribute("mensaje", mensajeCorreo);
			
			
		} catch (Exception ex) {
			ex.printStackTrace();						
			mensajeCorreo="Error al enviar los mensajes a los alumnos.Favor de notificar a Informática " + ex.getMessage();
			
			request.setAttribute("mensajeCorreo", mensajeCorreo);
			System.out.println(mensajeCorreo);
		}
		finally 
		{			
			request.getRequestDispatcher("SimulacionMatricula/mensaje.jsp").forward(request, response);
		}
	}
}
