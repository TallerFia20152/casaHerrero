package edu.usmp.fia.taller.silabo.action;
import java.io.IOException;
import java.util.Vector;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.usmp.fia.taller.common.bean.silabo.BibliografiaBean;
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
			String idCurso=request.getParameter("txt_Idcurso");
			
			if (dato.equals("Buscar Sílabo")){
		
				Vector<SilaboBean> object=obj.listarSilabo(idCurso);
				Vector<CursoBean> object1=obj.listar();
				Vector<BibliografiaBean> object3=obj.listarBibliografia(object.get(0).getIdSilabo());
				request.setAttribute("LIST_CURSO",object1);
				request.setAttribute("LIST_BIBLIOGRAFIA",object3);
				if(object!=null){
					request.setAttribute("LIST_SILABO",object);
				}
				getServletContext().getRequestDispatcher("/silabo/index2.jsp").forward(request, response);
				
			}else if(dato.equals("Guardar y Exportar")){
				
				
				String idPc="1";
				String pFin=request.getParameter("prom_final");
				String fecha="";
				String id_curso=request.getParameter("lista");
				int id_silabo=obj.agregarSilabo(id_curso,idPc,pFin,fecha);
				System.out.print("promedio final =="+pFin);
			//Agregar Semana
			/*for(int i=0;i<10;i++){
				int numsemana=0;
				int numsesion=0;
				String titulo=request.getParameter("titulo_"+i);
				String descripcion="";
				if(titulo!=null){
					numsemana=1+i;
					numsesion=1;
					obj.agregarSemana(numsemana,numsesion,id_silabo,titulo,descripcion);
				}
			}
			*/
			//Agregar Bibliografia
				for(int i=0;i<10;i++){
					String titulo=request.getParameter("bibliografia_"+i);
					if(titulo!=null){
						obj.agregarBibliografia(id_silabo,titulo);
					}
				}
				request.getRequestDispatcher("/welcome.jsp").forward(request,response);
			}else if(dato.equals("Modificar Bibliografia")){
				System.out.print("llego al servelt ");
				for(int i=0;i<10;i++){
					String reseña=request.getParameter("reseña_"+i);
					String id_bibliografia=request.getParameter("id_bibliografia_"+i);
					System.out.print(""+request.getParameter("reseña_"+i));
					if(reseña!=null){
						obj.modificarBibliografia(id_bibliografia,reseña);
					}
				}
				request.getRequestDispatcher("/welcome.jsp").forward(request,response);
			}
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
	}
}