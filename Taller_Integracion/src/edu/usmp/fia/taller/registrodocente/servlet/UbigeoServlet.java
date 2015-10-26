package edu.usmp.fia.taller.registrodocente.servlet;


import java.io.PrintWriter;
import java.util.List;
import javax.servlet.annotation.WebServlet;
import edu.usmp.fia.taller.common.action.ActionServlet;
import edu.usmp.fia.taller.common.action.HttpMethod;
import edu.usmp.fia.taller.common.action.HttpMethodType;
import edu.usmp.fia.taller.common.action.RequireLogin;
import edu.usmp.fia.taller.common.bean.RegistroDocente.*;
import edu.usmp.fia.taller.common.dao.DAOFactory;
import com.google.gson.Gson;

@WebServlet("/ubigeo")
public class UbigeoServlet extends ActionServlet {

	@HttpMethod(HttpMethodType.POST)
	@RequireLogin(false)
	public void listarDepartamentos() throws Exception {
		DAOFactory oDAOFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		//List<Ubigeo> oUbigeo = oDAOFactory.getRegistroDocente().getDepartamentos();
		List<Ubigeo> oUbigeo = oDAOFactory.getRegistroDocente().regDocente().getDepartamentos();
		String json = new Gson().toJson(oUbigeo);
		
		response.setContentType("application/json");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter(); 
		
		out.print(json.toString());
	}
	@HttpMethod(HttpMethodType.POST)
	@RequireLogin(false)
	public void listarProvincias() throws Exception {
		String coddpto = request.getParameter("coddpto");
		DAOFactory oDAOFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		List<Ubigeo> oUbigeo = oDAOFactory.getRegistroDocente().regDocente().getProvincias(coddpto);
		String json = new Gson().toJson(oUbigeo);

		response.setContentType("application/json");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter(); 
		
		out.print(json.toString());
	}
	@HttpMethod(HttpMethodType.POST)
	@RequireLogin(false)
	public void listarDistritos() throws Exception {
		String coddpto = request.getParameter("coddpto");
		String codprov = request.getParameter("codprov");
		DAOFactory oDAOFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		List<Ubigeo> oUbigeo = oDAOFactory.getRegistroDocente().regDocente().getDistritos(coddpto,codprov);
		String json = new Gson().toJson(oUbigeo);
	    //response.setHeader("Content-Type", "application/json");
		//response.setContentType("application/json");
		response.setContentType("application/json");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter(); 
		
		out.print(json.toString());
	}


	

}
