package edu.usmp.fia.taller.registrodocente.servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.List;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

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
			

			String tipoRegistro=request.getParameter("tipoRegistro");
			int idPersona=Integer.parseInt(request.getParameter("codigo"));
			String url_foto=request.getParameter("urlfoto");
			System.out.print("\n"+1+"\n");
			String nombre=request.getParameter("nombres");
			System.out.print("\n"+2+"\n");
			String apellido_paterno=request.getParameter("apellidopaterno");
			System.out.print("\n"+3+"\n");
			String apellido_materno=request.getParameter("apellidomaterno");
			System.out.print("\n"+4+"\n");
			String sexo=request.getParameter("sexo");
			System.out.print("\n"+5+"\n");
			char estado_civil=request.getParameter("estadocivil").charAt(0);
			System.out.print("\n"+6+"\n");
			String fecha_nacimiento=request.getParameter("fechanacimiento");
			System.out.print("\n"+7+"\n");
			int id_Pais_nacionalidad=Integer.parseInt(request.getParameter("pais"));
			System.out.print("\n"+8+"\n");
			int id_Departamento_nacionalidad=Integer.parseInt(request.getParameter("departamento1"));
			System.out.print("\n"+9+"\n");
			int id_Provincia_nacionalidad=Integer.parseInt(request.getParameter("provincia1"));
			System.out.print("\n"+10+"\n");
			int id_Distrito_nacionalidad=Integer.parseInt(request.getParameter("distrito1"));
			System.out.print("\n"+11+"\n");
			int id_Departamento_direccion=Integer.parseInt(request.getParameter("departamento2"));
			System.out.print("\n"+12+"\n");
			int id_Provincia_direccion=Integer.parseInt(request.getParameter("provincia2"));
			System.out.print("\n"+13+"\n");
			int id_Distrito_direccion=Integer.parseInt(request.getParameter("distrito2"));
			System.out.print("\n"+14+"\n");
			String referencia_direccion=request.getParameter("referencia");
			System.out.print("\n"+15+"\n");
			char estado='1';

			persona=new Personaa();
			persona.setIdPersona(idPersona);
			persona.setNombre1(nombre);
			persona.setApePaterno(apellido_paterno);
			persona.setApeMaterno(apellido_materno);
			persona.setSexo(sexo);
			DAOFactory dao = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
			DAOFactoryRegDocente regdoce = dao.getRegistroDocente();
			int idPersonaRes=-1;
			if(tipoRegistro==null){
				idPersonaRes = regdoce.regDocente().guardarPersona(persona);
			}else{
				idPersonaRes = regdoce.regDocente().modificarPersona(persona);
			}

			System.out.print("\n"+idPersonaRes+"\n");
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
			boolean resultadoExito=false;
			if(tipoRegistro==null){
				resultadoExito = regdoce.regDocente().guardarDocente(docente);
			}else{
				resultadoExito = regdoce.regDocente().modificarDocente(docente);
			}
			
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
	
	@HttpMethod(HttpMethodType.POST)
	@RequireLogin(true)
	public void guardarDisponibilidadDocente() throws Exception {

		String id_profesor=request.getParameter("codigo");
		String json_cursosAptos=request.getParameter("json_curso");
		
		DAOFactory dao = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		DAOFactoryRegDocente regdoce = dao.getRegistroDocente();
			
			if(!json_cursosAptos.equals("[]"))
					regdoce.regDocente().guardarCursosAptos(json_cursosAptos, id_profesor);

			JSONObject  mensaje=new JSONObject();
				mensaje.put("exito", true);
				mensaje.put("mensaje", "Se registro la disponibilidad satisfactoriamente");
				
			response.setContentType("application/json");
			response.setCharacterEncoding("utf-8");
			PrintWriter out = response.getWriter();
			out.print(mensaje);
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
	
	
	@HttpMethod(HttpMethodType.GET)
	@RequireLogin(true)
	public void SeleccionarDocente() throws Exception {

		String codigo=request.getParameter("dato");
		System.out.println("en tre al servlet SeleccionarDocente y el godigo es "+codigo);
		try {
			
			
			DAOFactory dao = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
			DAOFactoryRegDocente regdoce = dao.getRegistroDocente();
			
			Personaa docente = regdoce.regDocente().buscarDocente(codigo);
			Vector<CursoAptoProfesor> cursos=regdoce.regDocente().buscarCursoAptos(codigo);
			Vector<DisponibilidadProfesor> horas=regdoce.regDocente().buscarHorasDisponibles(codigo);

			request.setAttribute("docente", docente);
			request.setAttribute("cursosAptos", cursos);
			request.setAttribute("horasDisponibles", horas);
			
			request.getRequestDispatcher("Gestionar_Docente?f=cargarListas").forward(request, response);
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.print(e.getMessage());
		}
	}
	
	
	@HttpMethod(HttpMethodType.POST)
	@RequireLogin(true)
	public void SeleccionarCurso() throws Exception {
		String codigo=request.getParameter("dato");
		System.out.println("en tre al servlet SeleccionarDocente y el godigo es "+codigo);
		Vector<Curso> cursos1 = null;
		try {
			
			cursos1=new Vector<Curso>();
			DAOFactory dao = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
			DAOFactoryRegDocente regdoce = dao.getRegistroDocente();
			Curso curso=regdoce.regDocente().buscarCurso(codigo);
			
			String json = new Gson().toJson(curso);

			response.setContentType("application/json");
			response.setCharacterEncoding("utf-8");
			PrintWriter out = response.getWriter(); 
			
			out.print(json.toString());
			/*
			cursos1.addElement(curso);
			
			request.setAttribute("cursos1", cursos1);
			
			request.getRequestDispatcher("Gestionar_Docente?f=cargarListas").forward(request, response);
			*/
		} catch (Exception e) {
			// TODO: handle exception
			System.out.print(e.getMessage());
		}
	}
	@HttpMethod(HttpMethodType.GET)
	@RequireLogin(true)
	public void cargarDocentes() throws Exception {
		
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
			
			request.getRequestDispatcher("/RegistroDocente/ListadoDocentes.jsp").forward(request, response);
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.print(e.getMessage());
		}
	}
	
	@HttpMethod(HttpMethodType.GET)
	@RequireLogin(true)
	public void eliminarDocente() throws Exception {
		String codigo=request.getParameter("dato");
		try {
			DAOFactory dao = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
			DAOFactoryRegDocente regdoce = dao.getRegistroDocente();
			
			String mensaje = regdoce.regDocente().eliminarDocente(codigo);
			request.setAttribute("mensaje", mensaje);
			System.out.println("en mensaje es : "+mensaje);
			request.getRequestDispatcher("/RegistroDocente/mensaje.jsp").forward(request, response);
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.print(e.getMessage());
		}
	}
	
	
	@HttpMethod(HttpMethodType.GET)
	@RequireLogin(true)
	public void modificarDocente() throws Exception {
		String codigo=request.getParameter("dato");
		try {
			DAOFactory dao = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
			DAOFactoryRegDocente regdoce = dao.getRegistroDocente();
			
			Personaa persona=regdoce.regDocente().buscarPersona(codigo);
			Docente docente=regdoce.regDocente().buscarDocente1(codigo);
			Vector<Email> emails=regdoce.regDocente().buscarEmail(codigo);
			Vector<Telefono> telefonos=regdoce.regDocente().buscarTelefono(codigo);
			Vector<Documento> documentos=regdoce.regDocente().buscarDocumento(codigo);
			Vector<GradoAcademico> gradoAcademicos=regdoce.regDocente().buscarGradoAcademico(codigo);
			List<Ubigeo> departamentos = dao.getRegistroDocente().regDocente().getDepartamentos();
			List<Ubigeo> provincias1 = dao.getRegistroDocente().regDocente().getProvincias(""+docente.getId_Departamento_nacionalidad());
			List<Ubigeo> provincias2 = dao.getRegistroDocente().regDocente().getProvincias(""+docente.getId_Departamento_direccion());
			List<Ubigeo> distritos1 = dao.getRegistroDocente().regDocente().getDistritos(""+docente.getId_Departamento_nacionalidad(),""+docente.getId_Provincia_nacionalidad());
			List<Ubigeo> distritos2 = dao.getRegistroDocente().regDocente().getDistritos(""+docente.getId_Departamento_direccion(),""+docente.getId_Provincia_direccion());
			
			//docente.getId_Departamento_nacionalidad()
			request.setAttribute("persona", persona);
			request.setAttribute("docente", docente);
			request.setAttribute("emails", emails);
			request.setAttribute("telefonos", telefonos);
			request.setAttribute("documentos", documentos);
			request.setAttribute("gradoAcademicos", gradoAcademicos);
			request.setAttribute("departamentos", departamentos);
			request.setAttribute("provincias1", provincias1);
			request.setAttribute("provincias2", provincias2);
			request.setAttribute("distritos1", distritos1);
			request.setAttribute("distritos2", distritos2);
			
			request.getRequestDispatcher("/RegistroDocente/modificarDocente.jsp").forward(request, response);
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.print(e.getMessage());
		}
	}
	
	@HttpMethod(HttpMethodType.POST)
	@RequireLogin(true)
	
	public void procesoArchivo() throws Exception {
		String nombre=request.getParameter("nombre");
		Part arch=request.getPart("archivo");
		InputStream is= arch.getInputStream();
		File f =new File("C:/Users/Ronald/Desktop/nueva integracion 02-11/Taller_Integracion_V7/WebContent/RegistroDocente/imagenDocente"+nombre);
		FileOutputStream ous=new FileOutputStream(f);
		int dato =is.read();
		while(dato!=-1){
			ous.write(dato);
			dato=is.read();
		}
		ous.close();
		is.close();
		
		
	}
}
