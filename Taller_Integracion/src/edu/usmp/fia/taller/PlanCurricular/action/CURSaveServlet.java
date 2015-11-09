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
import edu.usmp.fia.taller.common.dao.DAOFactory;
import edu.usmp.fia.taller.common.dao.modules.PlanCurricular.DAOFactoryPCurricular;


@WebServlet("/saveChanges")
public class CURSaveServlet extends HttpServlet implements Constants {

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
					case CHANGE_TYPE_ORDER:
						if (ch.isEnable()) {
							ncourse.setOrder(ch.getCourse().getOrder());
							System.out.println("ch.orden: " + ch.getCourse().getOrder());
							ncourse.setType(ch.getCourse().getType());
							ncourse.setMentions(ch.getCourse().getMentions());
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
		
		Map<String, List<Curso>> curriculum = chgBusiness.applyNewCurriculum(coursesChg);
		List<Curso> cursosBD = new ArrayList<Curso>();
		DAOFactory dao = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		DAOFactoryPCurricular daoPlan = dao.getCourseDAO();
		cursosBD = daoPlan.obtenerCursosPCD();
		List<Curso> cursosCambiados = new ArrayList<Curso>();
		
		for (int i = 0; i<newCourses.size(); i++) {
			for (int j = 0; j < cursosBD.size(); j++) {
				if (cursosBD.get(j).getCode().equals(newCourses.get(i).getCode())) {
					System.out.println("son iguales:" + cursosBD.get(j).getCode() + " y " + newCourses.get(i).getCode());
					cursosCambiados.add(newCourses.get(i));
				} else {
					
				}
			}
		}
		
		for (int i = 0; i < newCourses.size(); i++) {
			System.out.println("codigos nuevos: " + newCourses.get(i).getCode());
		}
		Map<String, List<Curso>> curriculumNuevo2 = chgBusiness.actualizarCambios(coursesChg);
		Map<String, List<Curso>> curriculumNuevo = chgBusiness.grabarNewCurriculum(newCourses);
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
