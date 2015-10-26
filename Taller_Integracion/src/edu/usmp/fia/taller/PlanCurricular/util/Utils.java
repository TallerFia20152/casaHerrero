package edu.usmp.fia.taller.PlanCurricular.util;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import edu.usmp.fia.taller.common.bean.PlanCurricular.ChangeBean;
import edu.usmp.fia.taller.common.bean.PlanCurricular.Curso;

public class Utils {

	public static Curso getCourseByCode(String code, List<Curso> courses) {
		if (courses != null && !courses.isEmpty()) {
			for (Curso c : courses) {
				if (c.getCode().equals(code)) {
					return c;
				}
			}
			return null;
		} else {
			return null;
		}
	}
	
	public static Curso getCourseByName(String name, List<Curso> courses) {
		if (courses != null && !courses.isEmpty()) {
			for (Curso c : courses) {
				if (c.getName().equals(name)) {
					return c;
				}
			}
			return null;
		} else {
			return null;
		}
	}
	
	public static ChangeBean getChangeByCourseAndType(String code, int type, List<ChangeBean> changes) {
		if (changes != null && !changes.isEmpty()) {
			for (ChangeBean c : changes) {
				if (c.getType() == type && c.getCourse().getCode().equals(code)) {
					return c;
				}
			}
			return null;
		} else {
			return null;
		}
	}
	
	public static int countNewCourses(List<Curso> courses) {
		int count = 0;
		if (courses != null && !courses.isEmpty()) {
			for (Curso c : courses) {
				if (c.getId() == 1) {
					count++;
				}
			}
		}
		return count;
	}
	
	public static List<Curso> getSessionCourses(HttpServletRequest request) {
		List<Curso> courses = new ArrayList<Curso>();
		Object data = request.getSession().getAttribute(Constants.SESSION_COURSES);
		if (data != null) {
			courses = (List<Curso>) data;
		}
		return courses;
	}
	
	public static List<ChangeBean> getSessionChanges(HttpServletRequest request) {
		List<ChangeBean> changes = new ArrayList<ChangeBean>();
		Object data = request.getSession().getAttribute(Constants.SESSION_CHANGES);
		if (data != null) {
			changes = (List<ChangeBean>) data;
		}
		return changes;
	}
	
	public static List<Curso> getSessionNewCourses(HttpServletRequest request) {
		List<Curso> courses = new ArrayList<Curso>();
		Object data = request.getSession().getAttribute(Constants.SESSION_NEW_COURSES);
		if (data != null) {
			courses = (List<Curso>) data;
		}
		return courses;
	}
	
	public static void replaceCourse(Curso course, List<Curso> courses) {
		for (int i = 0; i < courses.size(); ++i) {
			if (courses.get(i).getCode().equals(course.getCode())) {
				courses.set(i, new Curso(course));
				break;
			}
		}
	}
	
	public static void removeCourse(Curso course, List<Curso> courses) {
		for (int i = 0; i < courses.size(); ++i) {
			if (courses.get(i).getCode().equals(course.getCode())) {
				courses.remove(i);
				break;
			}
		}
	}
	
	public static String getCourseTypeName(int id) {
		switch (id) {
		case Constants.COURSE_TYPE_REQUIRED:
			return Constants.COURSE_TYPE_NAME_REQUIRED;
		case Constants.COURSE_TYPE_ELECTIVE:
			return Constants.COURSE_TYPE_NAME_ELECTIVE;
		default:
			return Constants.COURSE_TYPE_NAME_FREE;
		}
	}
	
	public static String getNextCourseCode(String code, List<Curso> courses) {
		if (code != null) {
			int num = Integer.parseInt(code) + countNewCourses(courses);
			return String.format("%06d", num);
		}
		return code;
	}
	
	public static int getIntegerParameter(HttpServletRequest request, String name) {

		Object value = request.getParameter(name);
		if (value != null && value.toString().matches("[\\d]+")) {
			return Integer.parseInt(value.toString());
		}
		return 0;
	}
}
