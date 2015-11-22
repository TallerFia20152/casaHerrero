package edu.usmp.fia.taller.simulacionMatricula.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import edu.usmp.fia.taller.common.bean.SimulacionMatricula.Curso;
import edu.usmp.fia.taller.common.dao.DAOFactory;

/**
 * Servlet implementation class ReporteCruceXCurso
 */
@WebServlet("/ReporteCruceXCurso")
public class ReporteCruceXCurso extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReporteCruceXCurso() {
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
		DAOFactory factory =null;
		List<Curso> listado=null;
		
		try 
		{
			String codCurso=request.getParameter("codCurso");
			System.out.println("INGRESOOOO " + codCurso);		
			
			factory= DAOFactory.getDAOFactory(DAOFactory.MYSQL);		
			listado= factory.getSimulacionMatricula().ListarCursosXCiclo(codCurso);
			
			response.setContentType("application/json;charset=UTF-8");
			Gson gson = new Gson();				
	        String json = gson.toJson(listado);
	        response.getWriter().write(json);
	        //response.getWriter().write(json);
				
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
