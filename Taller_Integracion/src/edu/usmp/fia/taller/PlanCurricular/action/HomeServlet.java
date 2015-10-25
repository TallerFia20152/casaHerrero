package edu.usmp.fia.taller.PlanCurricular.action;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.usmp.fia.taller.PlanCurricular.business.CurriculumBusiness;
import edu.usmp.fia.taller.PlanCurricular.business.impl.CurriculumBusinessImpl;
import edu.usmp.fia.taller.PlanCurricular.util.Constants;
import edu.usmp.fia.taller.common.bean.PlanCurricular.Curso;

@WebServlet("/G1_PlanCurricular")
public class HomeServlet extends HttpServlet implements Constants {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		CurriculumBusiness chgBusiness = new CurriculumBusinessImpl();
		Map<String, List<Curso>> curriculum = chgBusiness
				.getCurrentCurriculum();
		
		request.getSession().setAttribute(Constants.SESSION_SEMESTER, chgBusiness.getSemester());
		
		request.setAttribute(Constants.CURRICULUM_REQUIRED_COURSES,
				curriculum.get(Constants.CURRICULUM_REQUIRED_COURSES));
		request.setAttribute(Constants.CURRICULUM_MENTION_COURSES,
				curriculum.get(Constants.CURRICULUM_MENTION_COURSES));
		request.setAttribute(Constants.CURRICULUM_FREE_COURSES,
				curriculum.get(Constants.CURRICULUM_FREE_COURSES));
		request.getSession().setAttribute(Constants.SESSION_COURSES, 
				curriculum.get(Constants.CURRICULUM_ALL_COURSES));
		request.getSession().setAttribute(Constants.SESSION_NEW_COURSES, 
				curriculum.get(Constants.CURRICULUM_ALL_COURSES_COPY));

		RequestDispatcher reqDisp = getServletContext().getRequestDispatcher("/" + VIEW_PAGE_PATH +"viewHome.jsp");
		reqDisp.forward(request, response);
	}
}
