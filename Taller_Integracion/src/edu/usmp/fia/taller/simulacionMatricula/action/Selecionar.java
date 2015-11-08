package edu.usmp.fia.taller.simulacionMatricula.action;

import javax.servlet.annotation.WebServlet;

import edu.usmp.fia.taller.common.dao.DAOFactory;
import edu.usmp.fia.taller.common.action.ActionServlet;
import edu.usmp.fia.taller.common.action.Default;
import edu.usmp.fia.taller.common.action.HttpMethod;
import edu.usmp.fia.taller.common.action.HttpMethodType;
import edu.usmp.fia.taller.common.action.RequireLogin;
import edu.usmp.fia.taller.common.bean.SimulacionMatricula.Curso;

@WebServlet("/Seleccionar")
public class Selecionar extends ActionServlet {

	private static final long serialVersionUID = 1L;

	@Default()
	@RequireLogin(true)
	@HttpMethod(HttpMethodType.GET)	
	public void Seleccionar() throws Exception {		
		System.err.println("LLEGO AL SERVLET");
		request.getRequestDispatcher("SimulacionMatricula/SeleccionarHorarios.jsp").forward(request, response);

	}
}
