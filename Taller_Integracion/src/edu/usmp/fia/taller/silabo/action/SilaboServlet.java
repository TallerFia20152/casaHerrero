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
import edu.usmp.fia.taller.common.bean.silabo.SemanaBean;
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
			Vector<CursoBean> object=obj.listarCursoxSilabo();//listar curso que no tienen silabo
			Vector<CursoBean> object1=obj.listar();//listar curso que no tienen silabo
			request.setAttribute("LIST_CURSOXSILABO",object);
			request.setAttribute("LIST_CURSO",object1);
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
				Vector<SilaboBean> object=obj.listarSilabo(idCurso);//lista el silabo ++++++
				System.out.print("llego al servlet0");
				Vector<CursoBean> object1=obj.listar();//Lista todos los cursos que no tienen silabo
				System.out.print("llego al servlet1");
				Vector<CursoBean> object2=obj.listarCursoxSilabo();//Lista los cursos que tienen silabo
				System.out.print("llego al servlet2 ==="+object.get(0).getIdSilabo());
				Vector<BibliografiaBean> object3=obj.listarBibliografia(object.get(0).getIdSilabo());
				System.out.print("llego al servlet3 ");
				Vector<SemanaBean> object4=obj.listarSemana(object.get(0).getIdSilabo());
				System.out.print("llego al servlet4 ----");
				request.setAttribute("LIST_CURSO",object1);
				request.setAttribute("LIST_BIBLIOGRAFIA",object3);
				request.setAttribute("LIST_CURSOXSILABO",object2);
				request.setAttribute("LIST_SEMANA",object4);
				request.setAttribute("LIST_SILABO",object);
				getServletContext().getRequestDispatcher("/silabo/index2.jsp").forward(request, response);
				
			}else if(dato.equals("Guardar y Exportar")){
				String idPc="1";
				String pFin=request.getParameter("prom_final");
				String fecha="";
				String id_curso=request.getParameter("lista");
				int id_silabo=obj.agregarSilabo(id_curso,idPc,pFin,fecha);
			//Agregar Semana
			for(int i=0;i<6;i++){
				int numsemana=0;
				String titulo=request.getParameter("txt_unidad_1_"+i);
				if(titulo!=null){
					numsemana=1+i;
					obj.agregarSemana(numsemana,1,id_silabo,titulo);
				}
			}
			for(int i=0;i<6;i++){
				int numsemana=0;
				String titulo=request.getParameter("txt_unidad_2_"+i);
				if(titulo!=null){
					numsemana=1+i;
					obj.agregarSemana(numsemana,2,id_silabo,titulo);
				}
			}
			for(int i=0;i<6;i++){
				int numsemana=0;
				String titulo=request.getParameter("txt_unidad_3_"+i);
				System.out.print(i);
				if(titulo!=null){
					numsemana=1+i;
					obj.agregarSemana(numsemana,3,id_silabo,titulo);
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
			}else if(dato.equals("Modificar Bibliografia")){
				for(int i=0;i<10;i++){
					String reseña=request.getParameter("reseña_"+i);
					String id_bibliografia=request.getParameter("id_bibliografia_"+i);
					if(reseña!=null){
						obj.modificarBibliografia(id_bibliografia,reseña);
					}
				}
				request.getRequestDispatcher("/welcome.jsp").forward(request,response);
			}else if (dato.equals("Modificar Promedio")){
				String promedio=request.getParameter("prom_final");
				String idSilabo=request.getParameter("id_silabo");
				if(promedio!=null){
					obj.modificarSilabo(promedio,idSilabo);
				}
				request.getRequestDispatcher("/welcome.jsp").forward(request,response);
			}
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
	}
}