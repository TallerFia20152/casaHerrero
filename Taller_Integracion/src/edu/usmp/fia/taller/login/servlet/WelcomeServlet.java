package edu.usmp.fia.taller.login.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.usmp.fia.taller.common.action.ActionServlet;
import edu.usmp.fia.taller.common.action.Default;
import edu.usmp.fia.taller.common.action.HttpMethod;
import edu.usmp.fia.taller.common.action.HttpMethodType;
import edu.usmp.fia.taller.common.action.RequireLogin;
import edu.usmp.fia.taller.common.action.SessionParameters;
import edu.usmp.fia.taller.common.bean.Modulo;
import edu.usmp.fia.taller.common.bean.Persona;
import edu.usmp.fia.taller.common.bean.Usuario;
import edu.usmp.fia.taller.common.dao.DAOFactory;


@WebServlet("/welcome")
public class WelcomeServlet extends ActionServlet {

	public static final String MODULES = "modules";
	
	@Default
	@HttpMethod(HttpMethodType.GET)
	public void modules() throws Exception {
		log.info("welcome");
		Usuario oUsuario = (Usuario) request.getSession(false).getAttribute(SessionParameters.USUARIO.text());
		DAOFactory oDAOFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		List<Modulo> oList = oDAOFactory.getGeneral().getUsuario().getModulosPorUsuario(oUsuario.getPersona().getIdPersona());
		
		for(Modulo oModulo: oList) {
			log.info(oModulo.getDescripcion());
		}
		
		request.setAttribute(MODULES, oList);
		request.getServletContext().getRequestDispatcher("/welcome.jsp").forward(request, response);
	} 

}
