package edu.usmp.fia.taller.simulacionMatricula.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.itextpdf.text.pdf.PdfStructTreeController.returnType;

import edu.usmp.fia.taller.common.bean.SimulacionMatricula.Curso;
import edu.usmp.fia.taller.common.bean.SimulacionMatricula.CursoCruce;
import edu.usmp.fia.taller.common.dao.DAOFactory;

/**
 * Servlet implementation class CruceXCiclo
 */
@WebServlet("/CruceXCiclo")
public class CruceXCiclo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CruceXCiclo() {
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
	
	private List<CursoCruce> CursoCruce(List<CursoCruce> listado, String codCurso)
	{
		List<CursoCruce> listadoTemporal= new ArrayList<>();
		CursoCruce cursoTemporal;
		
		for(CursoCruce curso:listado)
		{
			System.out.println("CODIGO DEL CURSO " + codCurso);
			
			if(curso.getCodigo1().equalsIgnoreCase(codCurso))
			{
				listadoTemporal.add(curso);				
			}
			
			
			
			if(curso.getCodigo2().equalsIgnoreCase(codCurso))
			{
				System.out.println("INGRESA AQUI");
				cursoTemporal= new CursoCruce();
				cursoTemporal.setCodigo1(curso.getCodigo2());
				cursoTemporal.setCurso1(curso.getCurso2());
				cursoTemporal.setSeccion1(curso.getSeccion2());
				cursoTemporal.setCiclo1(curso.getCiclo2());
				
				cursoTemporal.setCodigo2(curso.getCodigo1());
				cursoTemporal.setCurso2(curso.getCurso1());
				cursoTemporal.setSeccion2(curso.getSeccion1());
				cursoTemporal.setCiclo2(curso.getCiclo1());
				cursoTemporal.setCantidadCruce(curso.getCantidadCruce());
				
				listadoTemporal.add(cursoTemporal);				
			}
		}
		
		return listadoTemporal;
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DAOFactory factory =null;
		List<CursoCruce> listado=null;
		
		List<CursoCruce> listadoSera=null;
		
		try 
		{
			String codCurso=request.getParameter("codCurso");
			System.out.println("INGRESOOOO " + codCurso);		
			
			factory= DAOFactory.getDAOFactory(DAOFactory.MYSQL);		
			listado= factory.getSimulacionMatricula().ListarCursosXCicloCruces();
			
			listadoSera= CursoCruce(listado, codCurso);
			
			response.setContentType("application/json;charset=UTF-8");
			Gson gson = new Gson();				
	        String json = gson.toJson(listadoSera);
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
