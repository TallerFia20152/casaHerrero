package edu.usmp.fia.taller.registrodocente.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.google.gson.Gson;

import edu.usmp.fia.taller.common.action.ActionServlet;
import edu.usmp.fia.taller.common.action.HttpMethod;
import edu.usmp.fia.taller.common.action.HttpMethodType;
import edu.usmp.fia.taller.common.action.RequireLogin;
import edu.usmp.fia.taller.common.bean.RegistroDocente.*;
import edu.usmp.fia.taller.common.dao.DAOFactory;
import edu.usmp.fia.taller.common.dao.modules.registrodocente.DAOFactoryRegDocente;


/**
 * Servlet implementation class Registrar_Docente
 */
@WebServlet("/Gestionar_Docente")
public class Gestionar_Docente extends ActionServlet {
	
	@HttpMethod(HttpMethodType.GET)
	@RequireLogin(true)
	public void registrarDocente() throws Exception {
		System.out.println("ENTRE AL GET");
		request.getServletContext().getRequestDispatcher("/RegistroDocente/registroDocente.jsp").forward(request, response);
	}
	
	@HttpMethod(HttpMethodType.POST)
	@RequireLogin(true)
	public void guardarDocente() throws Exception {
		Docente docente=null;
		Personaa persona=null;
		JSONObject  mensaje=new JSONObject();
					mensaje.put("exito", false);
					mensaje.put("mensaje", "Ocurrio un error al regstrar el Docente");
		try {
		//	SimpleDateFormat forma=new SimpleDateFormat("yyyy-MM-dd");

			
			//String jsonbj = new Gson().toJson(json);
			
			/*insertarCamposDinamicos("t_telefono_profesor",json_telefono,"telefono","1");
			insertarCamposDinamicos("t_telefono_profesor",json_email,"email","1");
			insertarCamposDinamicos("t_telefono_profesor",json_documento,"documento","1");*/
			/*
			response.setContentType("application/json");
			response.setCharacterEncoding("utf-8");
			PrintWriter out = response.getWriter(); */
			
			
			String url_foto=request.getParameter("urlfoto");
			String nombre=request.getParameter("nombres");
			String apellido_paterno=request.getParameter("apellidopaterno");
			String apellido_materno=request.getParameter("apellidomaterno");
			String sexo=request.getParameter("sexo");
			char estado_civil=request.getParameter("estadocivil").charAt(0);
			String fecha_nacimiento=request.getParameter("fechanacimiento");
			int id_Pais_nacionalidad=Integer.parseInt(request.getParameter("pais"));
			int id_Departamento_nacionalidad=Integer.parseInt(request.getParameter("departamento1"));
			int id_Provincia_nacionalidad=Integer.parseInt(request.getParameter("provincia1"));
			int id_Distrito_nacionalidad=Integer.parseInt(request.getParameter("distrito1"));
			int id_Departamento_direccion=Integer.parseInt(request.getParameter("departamento2"));
			int id_Provincia_direccion=Integer.parseInt(request.getParameter("provincia2"));
			int id_Distrito_direccion=Integer.parseInt(request.getParameter("distrito2"));
			String referencia_direccion=request.getParameter("referencia");
			char estado='1';

			persona=new Personaa();

			persona.setNombre1(nombre);
			persona.setApePaterno(apellido_paterno);
			persona.setApeMaterno(apellido_materno);
			persona.setSexo(sexo);
			DAOFactory dao = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
			DAOFactoryRegDocente regdoce = dao.getRegistroDocente();
			
			
			int idPersona = regdoce.regDocente().guardarPersona(persona);
			
			docente=new Docente();
			docente.setId_docente(idPersona);
			docente.setUrl_foto(url_foto);
			docente.setEstado_civil(estado_civil);
			docente.setId_Pais_nacionalidad(id_Pais_nacionalidad);
			docente.setId_Departamento_nacionalidad(id_Departamento_nacionalidad);
			docente.setId_Provincia_nacionalidad(id_Provincia_nacionalidad);
			docente.setId_Distrito_nacionalidad(id_Distrito_nacionalidad);
			docente.setId_Departamento_direccion(id_Departamento_direccion);
			docente.setId_Provincia_direccion(id_Provincia_direccion);
			docente.setId_Distrito_direccion(id_Distrito_direccion);
			docente.setFecha_nacimiento(fecha_nacimiento);
			docente.setEstado(estado);
			docente.setReferencia_direccion(referencia_direccion);
			/*
			docente.setCorreo(correo);
			docente.setTipo_documento(tipo_documento);
			docente.setGrado_academico(grado_academico);
			docente.setProfecion(profecion);
			docente.setEspecialidad(especialidad);
			docente.setInstitucion(institucion);
			docente.setFecha_ingreso(fecha_ingreso);*/

	//		DAOFactoryRegDocente regdoce = dao.getRegistroDocente();
			boolean resultadoExito = regdoce.regDocente().guardarDocente(docente);
			
			response.setContentType("application/json");
			response.setCharacterEncoding("utf-8");
			PrintWriter out = response.getWriter();
			if(resultadoExito){
				String json_telefono=request.getParameter("json_telefono");
				String json_email=request.getParameter("json_email");
				String json_documento=request.getParameter("json_documento");
				String json_gradoAcademico=request.getParameter("json_gradoAcademico");

				if(!json_telefono.equals("[]"))
				regdoce.regDocente().guardarTelefonos(json_telefono, ""+idPersona);

				if(!json_email.equals("[]"))
				regdoce.regDocente().guardarEmails(json_email, ""+idPersona);

				if(!json_documento.equals("[]"))
					regdoce.regDocente().guardarDocumentos(json_documento, ""+idPersona);

				if(!json_gradoAcademico.equals("[]"))
					regdoce.regDocente().guardarGradosAcademicos(json_gradoAcademico, ""+idPersona);

				 
				mensaje.put("exito", true);
				mensaje.put("mensaje", "El Docente fue registrado satisfactoriamente");
				
			}
			
			out.print(mensaje);
			//request.setAttribute("mensaje", mensaje);

			//request.getRequestDispatcher("/RegistroDocente/mensaje.jsp").forward(request, response);
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.print(e.getMessage());
		}
	}
	
	@HttpMethod(HttpMethodType.GET)
	@RequireLogin(true)
	public void cargarListas() throws Exception {
		
		try {
			
			
			DAOFactory dao = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
			
			DAOFactoryRegDocente regdoce = dao.getRegistroDocente();
			Vector<Dia> dias = regdoce.regDocente().listarDias();
			Vector<Hora> horas=regdoce.regDocente().listarHoras();
			Vector<Personaa> docentes=regdoce.regDocente().listarDocentes();
			Vector<Curso> cursos=regdoce.regDocente().listarCursos();
			request.setAttribute("dias", dias);
			request.setAttribute("horas", horas);
			request.setAttribute("docentes", docentes);
			request.setAttribute("cursos", cursos);
			
			
			
			request.getRequestDispatcher("/RegistroDocente/registroDisponibilidadDocente.jsp").forward(request, response);
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.print(e.getMessage());
		}
	}

}
