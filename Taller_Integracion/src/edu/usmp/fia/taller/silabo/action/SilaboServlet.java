package edu.usmp.fia.taller.silabo.action;
import java.io.IOException;
import java.util.Vector;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import edu.usmp.fia.taller.common.bean.silabo.CursoBean;
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
			System.out.print("pas o 1111");
			DAOFactory dao = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
			DAOSilabo obj = dao.getSilaboDAO();System.out.print("pas o 1112");
			Vector<CursoBean> object=obj.listar();
			request.setAttribute("LIST_CURSO",object);System.out.print("pas o 1113");
			getServletContext().getRequestDispatcher("/silabo/index.jsp").forward(request, response);System.out.print("pas o 1114");
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		try {
			DAOFactory dao = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
			DAOSilabo obj = dao.getSilaboDAO();
			String idCurso=request.getParameter("txt_idcurso");
			String idPc=request.getParameter("txt_idcurso");
			String idBi=request.getParameter("txt_idcurso");
			String idSemana=request.getParameter("txt_idcurso");
			String pFin=request.getParameter("txt_idcurso");
			String fecha=request.getParameter("txt_idcurso");
			boolean v=obj.agregarSilabo(idCurso,idPc,idBi,idSemana,pFin,fecha);
			
			//int agregarSemana();
			//int agregarBibliografia();
			
			if(v){
				System.out.print("Agrego correctamente");
			}
			request.getRequestDispatcher("/welcome.jsp").forward(request,response);
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
	}
}