package edu.usmp.fia.taller.PlanCurricular.business;

import java.util.List;

import edu.usmp.fia.taller.common.bean.PlanCurricular.ChangeBean;
import edu.usmp.fia.taller.common.bean.PlanCurricular.Curso;

public interface ChangeBusiness {

	public List<Curso> getCourses();

	public ChangeBean changeName(String code, String newName,
			List<Curso> courses, List<Curso> newCourses,
			List<ChangeBean> changes);

	public ChangeBean changeHours(String code, int tHs, int pHs, int lHs,
			List<Curso> courses, List<Curso> newCourses,
			List<ChangeBean> changes);

	public ChangeBean moveCourse(String code, int type, int cycle,
			String[] mentions, List<Curso> courses,
			List<Curso> newCourses, List<ChangeBean> changes);

	public ChangeBean changeAddCourse(int type, String name, int cycle,
			int tHrs, int pHrs, int lHrs, String[] mentions,
			List<Curso> courses, List<Curso> newCourses,
			List<ChangeBean> changes);
	
	public ChangeBean cancelCourse(String code, List<Curso> courses, List<Curso> newCourses,
			List<ChangeBean> changes);
	
	public ChangeBean changeRequeriments(String code, String newreq1, String newreq2, int newcred1, int newcred2,
			List<Curso> courses, List<Curso> newCourses,
			List<ChangeBean> changes);
}
