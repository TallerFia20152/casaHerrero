package edu.usmp.fia.taller.mallacurricular.action;

import java.util.List;

import javax.servlet.annotation.WebServlet;

import edu.usmp.fia.taller.common.dao.DAOFactory;
import edu.usmp.fia.taller.common.action.ActionServlet;
import edu.usmp.fia.taller.common.action.Default;
import edu.usmp.fia.taller.common.action.HttpMethod;
import edu.usmp.fia.taller.common.action.HttpMethodType;
import edu.usmp.fia.taller.common.action.RequireLogin;
import edu.usmp.fia.taller.common.bean.MallaCurricular.T_course;

@WebServlet("/ListaCursosServlet")
public class ListaCursosServlet extends ActionServlet {

	@Default
	@RequireLogin(true)
	@HttpMethod(HttpMethodType.GET)
	public void MostrarMallaGeneral() throws Exception {

		DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);

		List<T_course> cursos = factory.getMallaCurricular().findAll();
		List<T_course> cursos2 = factory.getMallaCurricular().findAl2();
		List<T_course> cursos3 = factory.getMallaCurricular().findAl3();
		List<T_course> cursos4 = factory.getMallaCurricular().findAl4();
		List<T_course> cursos5 = factory.getMallaCurricular().findAl5();
		List<T_course> cursos6 = factory.getMallaCurricular().findAl6();
		List<T_course> cursos7 = factory.getMallaCurricular().findAl7();
		List<T_course> cursos8 = factory.getMallaCurricular().findAl8();
		List<T_course> cursos9 = factory.getMallaCurricular().findAl9();
		List<T_course> cursos10 = factory.getMallaCurricular().findAl10();

		request.setAttribute("cursos", cursos);
		request.setAttribute("cursos2", cursos2);
		request.setAttribute("cursos3", cursos3);
		request.setAttribute("cursos4", cursos4);
		request.setAttribute("cursos5", cursos5);
		request.setAttribute("cursos6", cursos6);
		request.setAttribute("cursos7", cursos7);
		request.setAttribute("cursos8", cursos8);
		request.setAttribute("cursos9", cursos9);
		request.setAttribute("cursos10", cursos10);

		// response.sendRedirect("/MallaCurricular/listaCursos.jsp");
		request.getRequestDispatcher("MallaCurricular/listaCursos.jsp").forward(request, response);

	}
}
