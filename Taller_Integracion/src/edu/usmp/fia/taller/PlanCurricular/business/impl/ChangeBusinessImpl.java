package edu.usmp.fia.taller.PlanCurricular.business.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import edu.usmp.fia.taller.PlanCurricular.business.ChangeBusiness;
import edu.usmp.fia.taller.PlanCurricular.util.Constants;
import edu.usmp.fia.taller.PlanCurricular.util.Utils;
import edu.usmp.fia.taller.common.bean.PlanCurricular.ChangeBean;
import edu.usmp.fia.taller.common.bean.PlanCurricular.Curso;
import edu.usmp.fia.taller.common.dao.DAOFactory;
import edu.usmp.fia.taller.common.dao.modules.PlanCurricular.DAOFactoryPCurricular;

public class ChangeBusinessImpl implements ChangeBusiness {

	
	public List<Curso> getCourses() {
		List<Curso> courses = new ArrayList<Curso>();
		try {
			DAOFactory daoFact = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
			DAOFactoryPCurricular cursosdao = daoFact.getCourseDAO();
			courses = cursosdao.obtenerCursosPlan();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return courses;
	}

	
	public ChangeBean changeName(String code, String newName,
			List<Curso> courses, List<Curso> newCourses,
			List<ChangeBean> changes) {

		Curso course = Utils.getCourseByCode(code, courses);
		ChangeBean change = new ChangeBean(Constants.CHANGE_TYPE_NAME,
				Constants.CHANGE_NAME_NAME);

		if (course == null) {
			change.setCode(400);
			change.setMessage("Curso seleccionado no existe.");
//		} else if (Utils.getChangeByCourseAndType(code,
//				Constants.CHANGE_TYPE_NAME, changes) != null) {
//			change.setCode(400);
//			change.setMessage("Este cambio ya existe para el curso seleccionado.");
		} else if (course.getName().equals(newName)) {
			change.setCode(400);
			change.setMessage("El nuevo nombre no puede ser igual al nombre actual.");
		} else if (Utils.getCourseByName(newName, courses) != null) {
			change.setCode(400);
			change.setMessage("El nuevo nombre ya esta pertence a otro curso.");
		} else if (newName == null || newName.trim().length() < 3) {
			change.setCode(400);
			change.setMessage("El nuevo nombre no puede contener menos de tres caracteres.");
		} else if (!newName.matches("^[a-zA-Z0-9-·¡È…ÌÕÛ”˙⁄ ]*$")) {
			change.setCode(400);
			change.setMessage("El nuevo nombre contiene caracteres invalidos, solo se permiten letras y n˙meros.");
		} else if (newName.length()>100) {
			change.setCode(400);
			change.setMessage("Nombre de curso excede del lÌmite de texto");
		} else {
			change.setCode(200);
			change.setMessage("[INFO] Cambio de nombre agregado ["
					+ course.getCode() + " " + course.getName() + "]");

			change.setDescription("Se cambio el nombre del curso <b>"
					+ course.getName() + "</b> a <b>" + newName + "</b>");

			/* Create new Course */
			Curso newCourse = new Curso(course);
			newCourse.setName(newName);

			/* Update Changes and New Courses */
			Utils.replaceCourse(newCourse, newCourses);
			change.setCourse(newCourse);
			changes.add(change);
		}
		return change;
	}

	
	public ChangeBean changeHours(String code, int tHs, int pHs, int lHs,
			List<Curso> courses, List<Curso> newCourses,
			List<ChangeBean> changes) {

		Curso course = Utils.getCourseByCode(code, courses);
		ChangeBean change = new ChangeBean(Constants.CHANGE_TYPE_HOURS, Constants.CHANGE_NAME_HOURS);

		if (course == null) {
			change.setCode(400);
			change.setMessage("Curso seleccionado no existe.");
//		} else if (Utils.getChangeByCourseAndType(code,
//				Constants.CHANGE_TYPE_HOURS, changes) != null) {
//			change.setCode(400);
//			change.setMessage("Este cambio ya existe para el curso seleccionado.");
		} else if (course.getTheoHours() == tHs && course.getPracHours() == pHs && course.getLaboHours() == lHs) {
			change.setCode(400);
			change.setMessage("La nueva distribucion de horas no puede ser igual a la actual.");
		} else if ((tHs + pHs + lHs) == 0) {
			change.setCode(400);
			change.setMessage("La distribucion total de horas no puede ser 0 horas.");
		} else if ((tHs + pHs + lHs) > 6) {
			change.setCode(400);
			change.setMessage("La distribucion total de horas no puede ser mayor a 6 horas.");
		} else {
			change.setCode(200);
			change.setMessage("[INFO] Cambio de horas agregado ["
					+ course.getCode() + " " + course.getName() + "]");

			change.setDescription("Se cambio la distribucion de horas del curso <b>"
					+ course.getName() + "</b> de <b>T:" + course.getTheoHours() + "&nbsp;|&nbsp;P:" + course.getPracHours() + "&nbsp;|&nbsp;L:" + course.getLaboHours() + "</b>" 
					+ "&nbsp;a&nbsp;<b>T:" + tHs + "&nbsp;|&nbsp;P:" + pHs + "&nbsp;|&nbsp;L:" + lHs + "</b>");
			
			/* Create new Course */
		
			Curso newCourse = new Curso(course);
			newCourse.setTheoHours(tHs);
			newCourse.setPracHours(pHs);
			newCourse.setLaboHours(lHs);
			
			int credits =0;
			double phs=pHs;
			double lhs=lHs;
			if(pHs==0){
				credits=tHs;
				if(lHs!=0){
				
					credits=credits+(int)Math.ceil(lhs/2);
				}
				
			}else{
				credits=tHs+(int)Math.ceil(phs/2);
			
				if(lHs!=0){
			
					credits=credits+(int)Math.ceil(lhs/2);
				}
			}
			
			
			
			/* Update Changes and New Courses */
				
		Utils.replaceCourse(newCourse, newCourses);
		change.setCourse(newCourse);
		changes.add(change);
		}
		return change;
	}

	public ChangeBean moveCourse(String code, int type, int cycle, String[] mentions,
			List<Curso> courses, List<Curso> newCourses,
			List<ChangeBean> changes) {

		Curso course = Utils.getCourseByCode(code, courses);
		ChangeBean change = new ChangeBean(Constants.CHANGE_TYPE_MOVE,
				Constants.CHANGE_NAME_MOVE);

		if (course == null) {
			change.setCode(400);
			change.setMessage("Curso seleccionado no existe.");
//		} else if (Utils.getChangeByCourseAndType(code,
//				Constants.CHANGE_TYPE_MOVE, changes) != null) {
//			change.setCode(400);
//			change.setMessage("Este cambio ya existe para el curso seleccionado.");
		} else if (type < 1 || type >3) {
			change.setCode(400);
			change.setMessage("Tipo de curso no v√°lido.");
		} else {
			if (type == 1 && cycle == 0) {
				change.setCode(400);
				change.setMessage("Debe seleccionar un ciclo v√°lido.");
			} else if (type == 2 && (mentions == null || mentions.length == 0)) {
				change.setCode(400);
				change.setMessage("Menci√≥n de curso no v√°lida.");
			} else {
				change.setCode(200);
				change.setMessage("[INFO] Movimiento de curso agregado ["
						+ course.getCode() + " " + course.getName() + "]");
	
				change.setDescription("Se movio el curso <b>"
						+ course.getName() + "</b> de <b>" + Utils.getCourseTypeName(course.getType()) + "</b>" 
						+ "</b> a <b>" + Utils.getCourseTypeName(type) + "</b>");
	
				/* Create new Course */
				Curso newCourse = new Curso(course);
				newCourse.setType(type);
				newCourse.setCycle(cycle);
				if (type == Constants.COURSE_TYPE_ELECTIVE) {
					newCourse.setMentions(Arrays.asList(mentions));
				}
	
				/* Update Changes and New Courses */
				
				
				
				Utils.replaceCourse(newCourse, newCourses);
				change.setCourse(newCourse);
				changes.add(change);
			}
		}
		return change;
	}

	
	public ChangeBean changeAddCourse(int type, String name, int cycle,
			int tHs, int pHs, int lHs, String[] mentions,
			List<Curso> courses, List<Curso> newCourses,
			List<ChangeBean> changes) {

		DAOFactory daoFact = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		DAOFactoryPCurricular dao = daoFact.getCourseDAO();
		
		String code = Utils.getNextCourseCode(dao.obtenerNuevoCodigo(), newCourses);
		ChangeBean change = new ChangeBean(Constants.CHANGE_TYPE_ADD,
				Constants.CHANGE_NAME_ADD);

		if (code == null) {
			change.setCode(400);
			change.setMessage("El codigo del nuevo curso no puede ser generado.");
		} else if (Utils.getCourseByName(name, courses) != null) {
			change.setCode(400);
			change.setMessage("El nombre del nuevo curso ya pertence a otro curso.");
		} else if (Utils.getCourseByName(name, newCourses) != null) {
			change.setCode(400);
			change.setMessage("El nombre del nuevo curso ya pertence a otro curso.");
		} else if (name == null || name.trim().length() < 3) {
			change.setCode(400);
			change.setMessage("El nombre del nuevo curso no puede contener menos de tres caracteres.");
		} else if (!name.matches("^[a-zA-Z0-9-·¡È…ÌÕÛ”˙⁄ ]*$")) {
			change.setCode(400);
			change.setMessage("El nombre del nuevo curso contiene caracteres invalidos, solo se permiten letras y numeros.");
		} else if (type == Constants.COURSE_TYPE_ELECTIVE && (mentions == null || mentions.length == 0)) {
			change.setCode(400);
			change.setMessage("El nuevo curso debe pertenecer a alguna mencion.");
		} else if ((tHs + pHs + lHs) == 0) {
			change.setCode(400);
			change.setMessage("La distribucion total de horas no puede ser 0 horas.");
		} else if ((tHs + pHs + lHs) > 6) {
			change.setCode(400);
			change.setMessage("La distribucion total de horas no puede ser mayor a 6 horas.");
		} else if (name.length()>100) {
			change.setCode(400);
			change.setMessage("Nombre de curso excede del lÌmite de texto");
		} else {
			change.setCode(200);
			change.setMessage("[INFO] Nuevo curso agregado ["
					+ code + " " + name + "]");

			change.setDescription("Se agrego el nuevo curso <b>"
					+ code + " " + name + "</b>");

			/* Create new Course */
			Curso newCourse = new Curso();
			newCourse.setId(1);
			newCourse.setCode(code);
			newCourse.setName(name);
			newCourse.setType(type);
			newCourse.setCycle(cycle);
			if (mentions != null) {
				newCourse.setMentions(Arrays.asList(mentions));
			}
			newCourse.setTheoHours(tHs);
			newCourse.setPracHours(pHs);
			newCourse.setLaboHours(lHs);
			int credits =0;
			double phs=pHs;
			double lhs=lHs;
			if(pHs==0){
				credits=tHs;
				if(lHs!=0){
				
					credits=credits+(int)Math.ceil(lhs/2);
				}
				
			}else{
				credits=tHs+(int)Math.ceil(phs/2);
			
				if(lHs!=0){
			
					credits=credits+(int)Math.ceil(lhs/2);
				}
			}
			
			newCourse.setCredits(credits);
			/* Update Changes and New Courses */
			newCourses.add(newCourse);
			change.setCourse(newCourse);
			changes.add(change);
		}
		return change;
	}
	
	public ChangeBean cancelCourse(String code, List<Curso> courses, List<Curso> newCourses,
			List<ChangeBean> changes) {

		Curso course = Utils.getCourseByCode(code, courses);
		ChangeBean change = new ChangeBean(Constants.CHANGE_TYPE_CANCEL,
				Constants.CHANGE_NAME_CANCEL);

		if (course == null) {
			change.setCode(400);
			change.setMessage("Curso seleccionado no existe.");
		} else {
			change.setCode(200);
			change.setMessage("[INFO] Baja de curso agregado ["
					+ course.getCode() + " " + course.getName() + "]");

			change.setDescription("Se dio de baja al curso <b>"
					+ course.getName() + "</b>");
			
			/* Update Changes and New Courses */
			Utils.removeCourse(course, newCourses);
			change.setCourse(course);
			changes.add(change);
		}
		return change;
	}
	
	
	public ChangeBean changeRequeriments(String code, String newreq1, String newreq2, int newcred1, int newcred2,
			List<Curso> courses, List<Curso> newCourses,
			List<ChangeBean> changes) {

		Curso course = Utils.getCourseByCode(code, courses);
		ChangeBean change = new ChangeBean(Constants.CHANGE_TYPE_REQUERIMENTS,
				Constants.CHANGE_NAME_REQUERIMENTS);

		if (course == null) {
			change.setCode(400);
			change.setMessage("Curso seleccionado no existe.");
//		} else if (Utils.getChangeByCourseAndType(code,
//				Constants.CHANGE_TYPE_REQUERIMENTS, changes) != null) {
//			change.setCode(400);
//			change.setMessage("Este cambio ya existe para el curso seleccionado.");
		} else if (newreq1.equals(newreq2)) {
			change.setCode(400);
			change.setMessage("Ambos requisitos no pueden ser los mismos");
		} else if (newreq1.equals("z") && newcred1 == 0) {
			change.setCode(400);
			change.setMessage("El valor del nuevo requisito 1 no puede ser cero");
		} else if (newreq2.equals("z") && newcred2 == 0) {
			change.setCode(400);
			change.setMessage("El valor del nuevo requisito 2 no puede ser cero");
		} else {
			change.setCode(200);
			change.setMessage("[INFO] Cambio de requisito agregado ["
					+ course.getCode() + " " + course.getName() + "]");

			change.setDescription("Se cambio los requesitos del curso <b>"
					+ course.getName() + "</b>");

			/* Create new Course */
			Curso newCourse = new Curso(course);
			
			List<String> requirements = new ArrayList<String>();
						
			if ( newreq1.equals("z") ) {
				requirements.add("C:" + newcred1);
			} else {
				requirements.add(newreq1);
			}
			
			if ( newreq2.equals("z") ) {
				requirements.add("C:" + newcred2);
			} else {
				requirements.add(newreq2);
			}
			
			newCourse.setRequirements(requirements);

			/* Update Changes and New Courses */
			Utils.replaceCourse(newCourse, newCourses);
			change.setCourse(newCourse);
			changes.add(change);
		}
		return change;
	}
}
