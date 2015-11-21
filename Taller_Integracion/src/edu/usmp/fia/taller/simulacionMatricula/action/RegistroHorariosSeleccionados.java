package edu.usmp.fia.taller.simulacionMatricula.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONArray;
import org.json.JSONObject;

import edu.usmp.fia.taller.common.action.SessionParameters;
import edu.usmp.fia.taller.common.bean.Usuario;
import edu.usmp.fia.taller.common.dao.DAOFactory;

/**
 * Servlet implementation class RegistroHorariosSeleccionados
 */
@WebServlet("/RegistroHorariosSeleccionados")
public class RegistroHorariosSeleccionados extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistroHorariosSeleccionados() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DAOFactory factory =null;
		String mensaje="";
		boolean eliminar;
        boolean registro;
        try {
        	
        	HttpSession sesion= request.getSession();
			Usuario oUsuario= (Usuario) sesion.getAttribute(SessionParameters.USUARIO.text());

			//CURSO SECCION
            String jsonCursoSeccion=request.getParameter("jsonCursoSeccion");                        
            JSONArray jsonCursoSeccion1 = new JSONArray(jsonCursoSeccion);
            
            System.out.println("JSON " + jsonCursoSeccion);   
            System.out.println("jsonCursoSeccion1 " + jsonCursoSeccion1);
                        
            List<String> codCurso = new ArrayList<String>();
            List<String> seccion = new ArrayList<String>();
            
            for(int index = 0; index < jsonCursoSeccion1.length(); index++) 
            {
                JSONObject jsonObjectCursoSeccion = jsonCursoSeccion1.getJSONObject(index);
                String codCur= jsonObjectCursoSeccion.getString("CodCurso");
                String secc= jsonObjectCursoSeccion.getString("Seccion");
                
                System.out.println("COD CURSO " + codCur);
                System.out.println("SECCION " + secc);
                
                codCurso.add(codCur);
                seccion.add(secc);
            }
            
            //CURSOS CRUCES
            String jsonCruces=request.getParameter("jsonCruces");
            JSONArray jsonCruces1 = new JSONArray(jsonCruces);            
            System.out.println("jsonCruces1 " + jsonCruces1);
            
            List<String> codCurso1 = new ArrayList<String>();
            List<String> seccion1 = new ArrayList<String>();
            List<String> codCurso2 = new ArrayList<String>();
            List<String> seccion2 = new ArrayList<String>();
            
            for(int index = 0; index < jsonCruces1.length(); index++) 
            {
                JSONObject jsonObjectCruce = jsonCruces1.getJSONObject(index);
                
                String codCur1= jsonObjectCruce.getString("CodCurso1");
                String secc1= jsonObjectCruce.getString("Seccion1");
                
                String codCur2= jsonObjectCruce.getString("CodCurso2");
                String secc2= jsonObjectCruce.getString("Seccion2");
                
                System.out.println("COD CURSO1 " + codCur1);
                System.out.println("SECCION1 " + secc1);
                
                System.out.println("COD CURSO2 " + codCur2);
                System.out.println("SECCION2 " + secc2);
                System.out.println("");
                
                codCurso1.add(codCur1);
                seccion1.add(secc1);                
                codCurso2.add(codCur2);
                seccion2.add(secc2);
            }
            eliminar=false;            
            registro=false;
            
			factory= DAOFactory.getDAOFactory(DAOFactory.MYSQL);			
					
			eliminar=factory.getSimulacionMatricula().EliminarCruceAlumno(oUsuario.getPersona().getIdPersona().toString());
			
			eliminar= factory.getSimulacionMatricula().EliminarHorariosAlumno(oUsuario.getPersona().getIdPersona().toString());
			registro = factory.getSimulacionMatricula().RegistrarHorariosAlumno(oUsuario.getPersona().getIdPersona().toString(),codCurso,seccion);
			
			System.out.println("INGRESARÁ");
			if(registro)
			{
				registro = factory.getSimulacionMatricula().RegistrarCrucesHorariosAlumno(oUsuario.getPersona().getIdPersona().toString(),codCurso1,seccion1,codCurso2,seccion2);
				System.out.println("CORRECTO");
				mensaje="Se registró correctamente los horarios para los cursos preferidos.";
			}
			else
			{
				System.out.println("INCORRECTO");
				mensaje="No se pudo escoger los horarios para los cursos preferidos.";
			}
			
			request.setAttribute("mensaje", mensaje);
			request.getRequestDispatcher("SimulacionMatricula/mensaje.jsp").forward(request, response);
            
            
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        //
	}

}
