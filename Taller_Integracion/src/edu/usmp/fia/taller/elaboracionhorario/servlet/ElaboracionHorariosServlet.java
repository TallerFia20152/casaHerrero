package edu.usmp.fia.taller.elaboracionhorario.servlet;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpSession;

import org.json.JSONArray;
import org.json.JSONObject;

import edu.usmp.fia.taller.common.action.ActionServlet;
import edu.usmp.fia.taller.common.action.HttpMethod;
import edu.usmp.fia.taller.common.action.HttpMethodType;
import edu.usmp.fia.taller.common.action.RequireLogin;
import edu.usmp.fia.taller.common.dao.DAOFactory;



@WebServlet("/ElaboracionHorariosServlet")
public class ElaboracionHorariosServlet extends  ActionServlet  {


	@HttpMethod(HttpMethodType.GET)
	@RequireLogin(true)
	public void leerHorario() throws Exception {
		System.out.println("leerhorario");
		PrintWriter out = response.getWriter();
		try {
			String version = request.getParameter("version");
			String newVersion = request.getParameter("newVersion");
			String borrarVersion = request.getParameter("borrarVersion");
			System.out.println("prueba; "+"version: "+version+"  "+" newVersion: "+newVersion+" "+" borrarversion: "+ borrarVersion);
			System.out.println(version);
			HttpSession sesion = request.getSession();
			if(borrarVersion != null)
			{
				sesion.removeAttribute("versionHorario");
			}
			
			if(version != null)
			{
				sesion.setAttribute("versionHorario", version);
			}
			String versionHorario = (String)sesion.getAttribute("versionHorario");
			
			if(versionHorario == null)
			{
				
				DAOFactory oDAOFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
				List <String> versiones = oDAOFactory.getElaboracionHorario().elabHorarios().getHorarioDetalle();
				request.setAttribute("versiones", versiones );
				getServletContext().getRequestDispatcher("/ElaboracionHorarios/version.jsp").forward(request, response);
			}
			else
			{
				System.out.println("sigo aqui");
				String cycle = request.getParameter("cycle");
				if(cycle == null){ 
					cycle = "0";
				}
				System.out.println("cycle: getprimero "+ cycle);
				DAOFactory oDAOFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
				 JSONObject json = new JSONObject();
				 json=oDAOFactory.getElaboracionHorario().elabHorarios().getHoraTotales(cycle, versionHorario);
			  	request.setAttribute("json", json.toString() );
			  	
			  	JSONObject json2 = new JSONObject();
			  	json2=oDAOFactory.getElaboracionHorario().elabHorarios().getHoras(cycle, sesion);
			  	request.setAttribute("horas", json2.toString() );
			  	
			  	request.setAttribute("cycler", cycle);
			  	request.setAttribute("version", versionHorario);
			  	getServletContext().getRequestDispatcher("/ElaboracionHorarios/index.jsp").forward(request, response);
			}
		} catch (Exception e) {
			// TODO: handle exception
			out.print(e.getMessage());
		}
	}
	
	@HttpMethod(HttpMethodType.POST)
	@RequireLogin(true)
	public void leerSeccion() throws Exception{
		PrintWriter out = response.getWriter();
		try
		{
			String horas = request.getParameter("horas");
			
			String[] hArray = horas.split("-");
			
			DAOFactory oDAOFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
			JSONArray aulas = new JSONArray();
			aulas=oDAOFactory.getElaboracionHorario().elabHorarios().getDisponibilidadAula(hArray);
			JSONObject json = new JSONObject();
		    json.put("aulas", aulas);
		  	out.print(json.toString() );
		} catch (Exception e) {
			// TODO: handle exception
			out.print(e.getMessage());
		}
	}

	@HttpMethod(HttpMethodType.GET)
	@RequireLogin(true)
	public void cargarHorario() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("hola cargar horario");
				PrintWriter out = response.getWriter();
				try
				{
					String cycle = request.getParameter("cycle");
					System.out.println("ciclo: "+cycle);
					HttpSession sesion = request.getSession();
					String versionHorario = (String)sesion.getAttribute("versionHorario");
					System.out.println("versionHorario: "+versionHorario);
					String jsonHoras = request.getParameter("horas-horario");
					System.out.println("jsonHoras: "+jsonHoras);
					JSONArray jsonObject = new JSONArray(jsonHoras);
					DAOFactory oDAOFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
					oDAOFactory.getElaboracionHorario().elabHorarios().getCargarHorario(cycle, versionHorario, jsonObject);
					System.out.println("CYCLE final: "+cycle);
					response.sendRedirect("ElaboracionHorariosServlet?f=leerHorario&cycle="+cycle);
				} catch (Exception e) {
					// TODO: handle exception
					out.print(e.getMessage());
				}
	}
	

	
}
