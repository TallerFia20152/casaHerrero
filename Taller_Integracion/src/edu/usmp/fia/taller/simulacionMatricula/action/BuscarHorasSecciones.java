package edu.usmp.fia.taller.simulacionMatricula.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import edu.usmp.fia.taller.common.action.SessionParameters;
import edu.usmp.fia.taller.common.bean.Usuario;
import edu.usmp.fia.taller.common.bean.RegistroDocente.Hora;
import edu.usmp.fia.taller.common.bean.SimulacionMatricula.Curso;
import edu.usmp.fia.taller.common.bean.SimulacionMatricula.Horas;
import edu.usmp.fia.taller.common.bean.SimulacionMatricula.Seccion;
import edu.usmp.fia.taller.common.dao.DAOFactory;

@WebServlet("/BuscarHorasSecciones")
public class BuscarHorasSecciones extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuscarHorasSecciones() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.err.println("INGRESA SELECIONA");
		
		List<Horas> listado=null;
		
		DAOFactory factory =null;
		
		try 
		{
			System.out.println("INGRESOOOO");
			
			String codCurso=request.getParameter("codCurso");
			String seccion=request.getParameter("seccion");
			
			
			factory= DAOFactory.getDAOFactory(DAOFactory.MYSQL);		
			listado=factory.getSimulacionMatricula().HorasSeccion(codCurso,seccion);

			response.setContentType("application/json;charset=UTF-8");
			Gson gson = new Gson();				
	        String json = gson.toJson(listado);
	        response.getWriter().write(json);
				
            System.out.println("SALE DEL SERVLET BUSCAR HORAS SECCIONES");
							
				
				
		} catch (Exception e) {
			System.out.println("ERROR ListarCursosAptosPreferibles ====>> " +e.getMessage() + "");
		}
		finally
		{
			if (listado!=null)
				listado=null;
			
			if (factory!=null)							
				factory=null;					
		}
		
		
	}

}
