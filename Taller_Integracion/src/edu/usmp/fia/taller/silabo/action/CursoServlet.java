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

@WebServlet("/Curso")
public class CursoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public CursoServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			DAOFactory dao = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
			DAOSilabo obj = dao.getSilaboDAO();
			Vector<CursoBean> object=obj.listarCurso();
			request.setAttribute("LIST_CURSO",object);
			getServletContext().getRequestDispatcher("/CatalogoCurso/Index.jsp").forward(request, response);
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		try {
			DAOFactory dao = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
			DAOSilabo plan = dao.getSilaboDAO();
			String dato=request.getParameter("btn_funcion");
			String codigo = request.getParameter("id_curso");
			if (dato.equals("Agregar Curso")){
				String codigoCurso=request.getParameter("codigo");
				String nombre=request.getParameter("nombre");
				String tipo=request.getParameter("tipo");
				//String estado=request.getParameter("estado");
				String sumilla=request.getParameter("sumilla");
				System.out.print("agrego el curso0");
				boolean v=plan.validarCurso(nombre);
				System.out.print("agrego el curso1");
				if(v){
					System.out.print("se repite el curso");
				}
				//plan.agregarCurso(codigoCurso,nombre,tipo,estado,sumilla);
				plan.agregarCurso("09"+codigoCurso,nombre,tipo,sumilla);
				Vector<CursoBean> object=plan.listarCurso();
				request.setAttribute("LIST_CURSO",object);
				getServletContext().getRequestDispatcher("/CatalogoCurso/Index.jsp").forward(request, response);
			}else if (dato.equals("Eliminar Curso")){
				String id=request.getParameter("id");
				plan.eliminarCurso(id);
				request.getRequestDispatcher("/welcome.jsp").forward(request,  response);
			}else if (dato.equals("Modificar Curso")){
				String nombre=request.getParameter("nombre");
				String tipo=request.getParameter("tipo");
				//String estado=request.getParameter("estado");
				String sumilla=request.getParameter("sumilla");
				String codigoCurso=request.getParameter("codigoCurso");
				plan.modificarCurso(codigoCurso,nombre,tipo,sumilla);
				request.getRequestDispatcher("/welcome.jsp").forward(request,response);
			}else if(dato.equals("Buscar Curso")){
				Vector<CursoBean> object1=plan.listarCurso();
				Vector<CursoBean> object2=plan.listarCursoxID(codigo);
				request.setAttribute("LIST_CURSO",object1);
				request.setAttribute("CURSO",object2);
				getServletContext().getRequestDispatcher("/CatalogoCurso/catalogo.jsp").forward(request, response);
			}
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
	}
}