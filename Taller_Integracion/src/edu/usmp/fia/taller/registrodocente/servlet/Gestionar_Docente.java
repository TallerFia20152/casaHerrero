package edu.usmp.fia.taller.registrodocente.servlet;


import java.util.Vector;


import javax.servlet.annotation.WebServlet;
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
		
		request.getServletContext().getRequestDispatcher("/RegistroDocente/registroDocente.jsp").forward(request, response);
	}
	public void registrarDisponibilidadDocente() throws Exception {
		
		request.getServletContext().getRequestDispatcher("/RegistroDocente/registroDisponibilidadDocente.jsp").forward(request, response);
	}
	@HttpMethod(HttpMethodType.POST)
	@RequireLogin(true)
	public void guardarDocente() throws Exception {
		
		System.out.println("ENTRE AL post guardarDocente1111111111111111");
		Docente docente=null;
		Persona persona=null;
		try {
			docente=new Docente();
			persona=new Persona();
		//	SimpleDateFormat forma=new SimpleDateFormat("yyyy-MM-dd");

			String url_foto=request.getParameter("url_foto");
			System.out.println("22222222222222222222");
			String nombres=request.getParameter("nombres");
			String apellido_paterno=request.getParameter("apellido_paterno");
			String apellido_materno=request.getParameter("apellido_materno");
			String sexo=request.getParameter("sexo");
			char estado_civil=request.getParameter("estado_civil").charAt(0);
			int id_Pais_nacionalidad=Integer.parseInt(request.getParameter("pais"));
			String fecha_nacimiento=request.getParameter("fecha_nacimiento");
			System.out.println("3333333333333333333333");
			int id_Departamento_nacionalidad=Integer.parseInt(request.getParameter("departamento1"));
			
			System.out.println("3333333333333333333333aaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
			int id_Provincia_nacionalidad=Integer.parseInt(request.getParameter("provincia1"));
			//int id_Distrito_nacionalidad=Integer.parseInt(request.getParameter("distrito1"));
			System.out.println("3333333333333333333333bbbbbbbbbbbbbbbbbbbbbbbbbbbbbb");
			int id_Departamento_direccion=Integer.parseInt(request.getParameter("departamento2"));
			System.out.println("3333333333333333333333ccccccccccccccccccccccccccccc");
			int id_Provincia_direccion=Integer.parseInt(request.getParameter("provincia2"));
			System.out.println("3333333333333333333333dddddddddddddddddddddddddd");
			//int id_Distrito_direccion=Integer.parseInt(request.getParameter("distrito2"));
			String referencia_direccion=request.getParameter("referencia");
			
			char estado='1';
			String telefono1=request.getParameter("telefono1");
			String telefono2=request.getParameter("telefono2");
			String telefono3=request.getParameter("telefono3");
			String email1=request.getParameter("email1");
			String email2=request.getParameter("email2");
			String email3=request.getParameter("email3");
			String tipo_doc=request.getParameter("tipo_doc");
			int numero_doc=Integer.parseInt(request.getParameter("numero_doc"));
			String grado_academico=request.getParameter("grado_academico");
			String profesion=request.getParameter("profesion");
			String especialidad=request.getParameter("especialidad");
			String institucion=request.getParameter("institucion");
			String fecha_ingreso=request.getParameter("fecha_ingreso");
			
			System.out.println("444444444444444444444444");

			docente.setUrl_foto(url_foto);
			persona.setNombre1(nombres);
			persona.setApePaterno(apellido_paterno);
			persona.setApeMaterno(apellido_materno);
			persona.setSexo(sexo);
			docente.setEstado_civil(estado_civil);
			docente.setId_Pais_nacionalidad(id_Pais_nacionalidad);
			docente.setFecha_nacimiento(fecha_nacimiento);
			docente.setId_Departamento_nacionalidad(id_Departamento_nacionalidad);
			docente.setId_Provincia_nacionalidad(id_Provincia_nacionalidad);
			//docente.setId_Distrito_nacionalidad(id_Distrito_nacionalidad);
			docente.setId_Departamento_direccion(id_Departamento_direccion);
			docente.setId_Provincia_direccion(id_Provincia_direccion);
		//	docente.setId_Distrito_direccion(id_Distrito_direccion);
			docente.setReferencia_direccion(referencia_direccion);
			docente.setEstado(estado);
			docente.setTelefono1(telefono1);
			docente.setTelefono2(telefono2);
			docente.setTelefono3(telefono3);
			docente.setEmail1(email1);
			docente.setEmail2(email2);
			docente.setEmail3(email3);
			docente.setTipo_doc(tipo_doc);
			docente.setNumero_doc(numero_doc);
			docente.setGrado_academico(grado_academico);
			docente.setProfesion(profesion);
			docente.setEspecialidad(especialidad);
			docente.setInstitucion(institucion);
			docente.setFecha_ingreso(fecha_ingreso);
			
			System.out.println("55555555555555555555555555555555555");
					
			DAOFactory dao = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
			
			DAOFactoryRegDocente regdoce = dao.getRegistroDocente();
			String mensaje = regdoce.regisDocente().guardarDocente(docente, persona);
			System.out.println("666666666666666666666666666666666666");
			
			request.setAttribute("mensaje", mensaje);

			System.out.print("HOLA 2"+mensaje+"bbbbbbbbbb");
			request.getRequestDispatcher("/RegistroDocente/mensaje.jsp").forward(request, response);
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.print(e.getMessage());
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@HttpMethod(HttpMethodType.GET)
	@RequireLogin(true)
	public void listarHorasDisponibles() throws Exception {
		
		try {
			
			
			DAOFactory dao = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
			
			DAOFactoryRegDocente regdoce = dao.getRegistroDocente();
			Vector<Dia> dias = regdoce.regisDocente().listarDias();
			Vector<Hora> horas=regdoce.regisDocente().listarHoras();
			request.setAttribute("dias", dias);
			request.setAttribute("horas", horas);

			
			request.getRequestDispatcher("/RegistroDocente/registroDisponibilidadDocente.jsp").forward(request, response);
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.print(e.getMessage());
		}
	}
	
	
	
	
	
	
	

}
