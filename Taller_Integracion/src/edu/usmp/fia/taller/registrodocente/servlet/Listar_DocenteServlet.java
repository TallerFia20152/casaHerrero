package edu.usmp.fia.taller.registrodocente.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpSession;

import edu.usmp.fia.taller.common.action.ActionServlet;
import edu.usmp.fia.taller.common.action.HttpMethod;
import edu.usmp.fia.taller.common.action.HttpMethodType;
import edu.usmp.fia.taller.common.action.RequireLogin;
import edu.usmp.fia.taller.common.action.SessionParameters;
import edu.usmp.fia.taller.common.bean.Modulo;
import edu.usmp.fia.taller.common.bean.Persona;
import edu.usmp.fia.taller.common.dao.DAOFactory;


@WebServlet("/listarDocentes")
public class Listar_DocenteServlet extends ActionServlet {

	@HttpMethod(HttpMethodType.POST)
	@RequireLogin(false)
	public void signup() throws Exception {

	}


	

}
