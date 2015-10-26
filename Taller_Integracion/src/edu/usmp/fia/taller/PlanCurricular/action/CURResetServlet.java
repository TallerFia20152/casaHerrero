package edu.usmp.fia.taller.PlanCurricular.action;

import java.io.IOException;
import java.util.ArrayList;
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
import edu.usmp.fia.taller.PlanCurricular.util.Utils;
import edu.usmp.fia.taller.common.bean.PlanCurricular.Curso;


@WebServlet("/resetChanges")
public class CURResetServlet extends HttpServlet implements Constants {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		CurriculumBusiness chgBusiness = new CurriculumBusinessImpl();
		List<Curso> courses 	= Utils.getSessionCourses(request);
		
		Map<String, List<Curso>> curriculum = chgBusiness
				.applyNewCurriculum(courses);
		request.setAttribute(Constants.CURRICULUM_REQUIRED_COURSES,
				curriculum.get(Constants.CURRICULUM_REQUIRED_COURSES));
		request.setAttribute(Constants.CURRICULUM_MENTION_COURSES,
				curriculum.get(Constants.CURRICULUM_MENTION_COURSES));
		request.setAttribute(Constants.CURRICULUM_FREE_COURSES,
				curriculum.get(Constants.CURRICULUM_FREE_COURSES));
		
		RequestDispatcher reqDisp = getServletContext().getRequestDispatcher("/" +
				VIEW_SECTION_PATH +"tableCurriculum.jsp");
		reqDisp.forward(request, response);
	}
}
