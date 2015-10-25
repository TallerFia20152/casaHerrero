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
import edu.usmp.fia.taller.common.bean.PlanCurricular.ChangeBean;
import edu.usmp.fia.taller.common.bean.PlanCurricular.Curso;


@WebServlet("/applyChanges")
public class CURApplyServlet extends HttpServlet implements Constants {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		CurriculumBusiness chgBusiness = new CurriculumBusinessImpl();
		List<Curso> courses 	= Utils.getSessionCourses(request);
		List<Curso> newCourses = Utils.getSessionNewCourses(request);
		List<ChangeBean> changes 	= Utils.getSessionChanges(request);
		
		List<Curso> coursesChg = new ArrayList<Curso>();
		for (Curso c : courses) {
			Curso ncourse = new Curso(c);
			for (ChangeBean ch : changes) {
				if (ch.getCourse().getCode().equals(c.getCode())) {
					switch (ch.getType()) {
					case CHANGE_TYPE_NAME:
						if (ch.isEnable()) {
							ncourse.setName(ch.getCourse().getName());
						}
						break;
					case CHANGE_TYPE_REQUERIMENTS:
						if (ch.isEnable()) {
							ncourse.setRequirements(ch.getCourse().getRequirements());
						}
						break;
					case CHANGE_TYPE_HOURS:
						if (ch.isEnable()) {
							ncourse.setTheoHours(ch.getCourse().getTheoHours());
							ncourse.setPracHours(ch.getCourse().getPracHours());
							ncourse.setLaboHours(ch.getCourse().getLaboHours());
						}
						break;
					case CHANGE_TYPE_MOVE:
						if (ch.isEnable()) {
							ncourse.setCycle(ch.getCourse().getCycle());
							ncourse.setType(ch.getCourse().getType());
							ncourse.setMentions(ch.getCourse().getMentions());
						}
						break;
					case CHANGE_TYPE_CANCEL:
						if (ch.isEnable()) {
							ncourse.setId(2);
						}
						break;
					}
				}
			}
			
			if (ncourse.getId() != 2) {
				coursesChg.add(ncourse);
			}
		}
		
		for (Curso c : newCourses) {
			if (c.getId() == 1) {
				coursesChg.add(c);
			}
		}
		
		Map<String, List<Curso>> curriculum = chgBusiness
				.applyNewCurriculum(coursesChg);
		request.setAttribute(Constants.CURRICULUM_REQUIRED_COURSES,
				curriculum.get(Constants.CURRICULUM_REQUIRED_COURSES));
		request.setAttribute(Constants.CURRICULUM_MENTION_COURSES,
				curriculum.get(Constants.CURRICULUM_MENTION_COURSES));
		request.setAttribute(Constants.CURRICULUM_FREE_COURSES,
				curriculum.get(Constants.CURRICULUM_FREE_COURSES));
		
		RequestDispatcher reqDisp = getServletContext().getRequestDispatcher(
				VIEW_SECTION_PATH +"tableCurriculum.jsp");
		reqDisp.forward(request, response);
	}
}
