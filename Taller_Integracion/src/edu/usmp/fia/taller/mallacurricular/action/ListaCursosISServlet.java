package edu.usmp.fia.taller.mallacurricular.action;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.usmp.fia.taller.common.dao.DAOFactory;
import edu.usmp.fia.taller.common.action.ActionServlet;
import edu.usmp.fia.taller.common.action.Default;
import edu.usmp.fia.taller.common.action.HttpMethod;
import edu.usmp.fia.taller.common.action.HttpMethodType;
import edu.usmp.fia.taller.common.action.RequireLogin;
import edu.usmp.fia.taller.common.bean.MallaCurricular.T_course;

/**
 * Servlet implementation class ListaCursosServlet
 */

@WebServlet("/ListaCursosISServlet")
public class ListaCursosISServlet extends ActionServlet {

	@Default
	@RequireLogin(true)
	@HttpMethod(HttpMethodType.GET)
	public void MostrarMallaIS() throws Exception {

		DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);

		List<T_course> cursos11 = factory.getMallaCurricular().findAlIS();
		List<T_course> cursos = factory.getMallaCurricular().findAl1IS();
		List<T_course> cursos2 = factory.getMallaCurricular().findAl2IS();
		List<T_course> cursos3 = factory.getMallaCurricular().findAl3IS();
		List<T_course> cursos4 = factory.getMallaCurricular().findAl4IS();
		List<T_course> cursos5 = factory.getMallaCurricular().findAl5IS();
		List<T_course> cursos6 = factory.getMallaCurricular().findAl6IS();
		List<T_course> cursos7 = factory.getMallaCurricular().findAl7IS();
		List<T_course> cursos8 = factory.getMallaCurricular().findAl8IS();
		List<T_course> cursos9 = factory.getMallaCurricular().findAl9IS();
		List<T_course> cursos10 = factory.getMallaCurricular().findAl10IS();
		
		for (Iterator<T_course> iter = cursos11.iterator(); iter.hasNext();) {
			T_course temp = iter.next();
			if (temp.getId() == 90671) {
				cursos6.add(temp);
			}
			if (temp.getId() == 90672) {
				cursos7.add(temp);
			}
			if (temp.getId() == 90665) {
				cursos7.add(temp);
			}
			if (temp.getId() == 91124) {
				cursos8.add(temp);
			}
			if (temp.getId() == 90861) {
				cursos8.add(temp);
			}
			if (temp.getId() == 90659) {
				cursos8.add(temp);
			}
			if (temp.getId() == 90658) {
				cursos9.add(temp);
			}
			if (temp.getId() == 90660) {
				cursos9.add(temp);
			}
			if (temp.getId() == 90085) {
				cursos9.add(temp);
			}
			if (temp.getId() == 90666) {
				cursos10.add(temp);
			}
		}

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
		// response.sendRedirect("/MallaCurricular/listaCursosIS.jsp");
		request.getRequestDispatcher("MallaCurricular/listaCursosIS.jsp").forward(request, response);

	}
}
