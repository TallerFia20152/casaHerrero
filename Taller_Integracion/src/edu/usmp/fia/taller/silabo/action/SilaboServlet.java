package edu.usmp.fia.taller.silabo.action;
import java.io.IOException;
import java.util.Vector;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import edu.usmp.fia.taller.common.bean.silabo.CursoBean;
import edu.usmp.fia.taller.common.bean.silabo.SilaboBean;
import edu.usmp.fia.taller.common.dao.DAOFactory;
import edu.usmp.fia.taller.silabo.interfaces.*;

@WebServlet("/Silabo")
public class SilaboServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public SilaboServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			DAOFactory dao = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
			DAOSilabo obj = dao.getSilaboDAO();
			Vector<CursoBean> object=obj.listar();
			request.setAttribute("LIST_CURSO",object);
			getServletContext().getRequestDispatcher("/silabo/index.jsp").forward(request, response);
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		try {
			DAOFactory dao = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
			DAOSilabo obj = dao.getSilaboDAO();
			String dato=request.getParameter("btn_funcion");
			String idCurso=request.getParameter("id_curso");
			
			if (dato.equals("Buscar Sílabo")){
			
				
				Vector<SilaboBean> object=obj.listarSilabo(idCurso);
				Vector<CursoBean> object1=obj.listar();
				request.setAttribute("LIST_CURSO",object1);
				request.setAttribute("LIST_SILABO",object);
				
				getServletContext().getRequestDispatcher("/silabo/index2.jsp").forward(request, response);
			}else if(dato.equals("Agregar Silabo")){
				
				String idPc="13";
				String pFin=request.getParameter("prom_final");
				String fecha="";
				int id_silabo=obj.agregarSilabo(idCurso,idPc,pFin,fecha);
			
			//Agregar Semana
			for(int i=0;i<10;i++){
				int numsemana=Integer.parseInt(request.getParameter("numsemana_"+i));
				int numsesion=Integer.parseInt(request.getParameter("numsesion_"+i));
				String titulo=request.getParameter("bibliografia_"+i);
				String descripcion=request.getParameter("bibliografia_"+i);
				if(titulo!=null){
					obj.agregarSemana(numsemana,numsesion,id_silabo,titulo,descripcion);
				}
			}
			
			//Agregar Bibliografia
			for(int i=0;i<10;i++){
				String titulo=request.getParameter("bibliografia_"+i);
				if(titulo!=null){
					obj.agregarBibliografia(id_silabo,titulo);
				}
			}
			request.getRequestDispatcher("/welcome.jsp").forward(request,response);
			}
			
			
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
	}
}