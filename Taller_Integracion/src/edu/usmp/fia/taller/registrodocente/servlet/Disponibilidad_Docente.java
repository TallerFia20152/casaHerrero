package edu.usmp.fia.taller.registrodocente.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




import org.json.simple.JSONObject;

import com.mysql.jdbc.Connection;

import edu.usmp.fia.taller.common.action.ActionServlet;
import edu.usmp.fia.taller.common.action.HttpMethod;
import edu.usmp.fia.taller.common.action.HttpMethodType;
import edu.usmp.fia.taller.common.action.RequireLogin;
import edu.usmp.fia.taller.common.bean.RegistroDocente.*;
import edu.usmp.fia.taller.common.dao.DAOFactory;
import edu.usmp.fia.taller.common.dao.MySqlDAOFactory;
import edu.usmp.fia.taller.common.dao.modules.registrodocente.DAOFactoryRegDocente;



@WebServlet("/Disponibilidad_Docente")
public class Disponibilidad_Docente extends ActionServlet {

	@HttpMethod(HttpMethodType.POST)
	@RequireLogin(true)
	public void guardarDisponibilidadDocente() throws Exception {

		String id_profesor=request.getParameter("profesor_id");
		String json_cursosAptos=request.getParameter("json_curso");
		String json_rangoHoras=request.getParameter("json_rangoHoras");
		DAOFactory dao = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		DAOFactoryRegDocente regdoce = dao.getRegistroDocente();
			
			if(!json_cursosAptos.equals("[]"))
					regdoce.regDocente().guardarCursosAptos(json_cursosAptos, id_profesor);
			if(!json_rangoHoras.equals("[]"))
					regdoce.regDocente().guardarRangoHoras(json_rangoHoras, id_profesor);

			JSONObject  mensaje=new JSONObject();
				mensaje.put("exito", true);
				mensaje.put("mensaje", "Se registro la disponibilidad satisfactoriamente");
				
			response.setContentType("application/json");
			response.setCharacterEncoding("utf-8");
			PrintWriter out = response.getWriter();
			out.print(mensaje);
	}

}
