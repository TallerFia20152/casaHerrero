package edu.usmp.fia.taller.simulacionMatricula.action;

import java.io.IOException;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import edu.usmp.fia.taller.common.bean.SimulacionMatricula.Alumno;
import edu.usmp.fia.taller.common.bean.SimulacionMatricula.Curso;
import edu.usmp.fia.taller.common.dao.DAOFactory;

@WebServlet("/ReporteCiclo")
public class ReporteCiclo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReporteCiclo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		DAOFactory factory =null;
		List<Curso> listado=null;
		
		try 
		{
			String ciclo=request.getParameter("ciclo");
			System.out.println("INGRESOOOO " + ciclo);		
			
			factory= DAOFactory.getDAOFactory(DAOFactory.MYSQL);		
			listado= factory.getSimulacionMatricula().ListarCursosXCiclo(ciclo);
			
			for(Curso curso:listado)
			{
				System.out.println("REPORTE CRUCES");
				System.out.println(curso.getCodigo());
				System.out.println(curso.getCurso());
			}
			
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
