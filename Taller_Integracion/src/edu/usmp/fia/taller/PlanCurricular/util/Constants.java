package edu.usmp.fia.taller.PlanCurricular.util;

public interface Constants {

	public static final int COURSE_TYPE_REQUIRED = 1;
	public static final int COURSE_TYPE_ELECTIVE = 2;
	public static final int COURSE_TYPE_FREE = 3;
	public static final int COURSE_MENTION_SI = 1;
	public static final int COURSE_MENTION_TI = 2;
	public static final int COURSE_MENTION_SW = 3;
	
	public static final String COURSE_TYPE_NAME_REQUIRED = "Obligatorio";
	public static final String COURSE_TYPE_NAME_ELECTIVE = "Electivo con Mencion";
	public static final String COURSE_TYPE_NAME_FREE = "Electivo Libe";
	public static final String COURSE_MENTION_NAME_SI = "Sistemas de Informacion";
	public static final String COURSE_MENTION_NAME_TI = "Tecnologia de la Informacion";
	public static final String COURSE_MENTION_Name_SW = "Ingenieria de Software";

	public static final String CHANGE_NAME_NAME = "Cambios de Nombre";
	public static final int CHANGE_TYPE_NAME = 1;
	public static final String CHANGE_NAME_REQUERIMENTS = "Cambios de Requisitos";
	public static final int CHANGE_TYPE_REQUERIMENTS = 2;
	public static final String CHANGE_NAME_HOURS = "Cambios de Horas";
	public static final int CHANGE_TYPE_HOURS = 3;
	public static final String CHANGE_NAME_ADD = "Nuevos Cursos";
	public static final int CHANGE_TYPE_ADD = 4;
	public static final String CHANGE_NAME_MOVE = "Cursos Movidos";
	public static final int CHANGE_TYPE_MOVE = 5;
	public static final String CHANGE_NAME_CANCEL = "Cursos Dados de Baja";
	public static final int CHANGE_TYPE_CANCEL = 6;
	
	public static final int CHANGE_STATUS_TRUE = 1;
	public static final int CHANGE_STATUS_FALSE = 0;
	
	public static final String CURRICULUM_ALL_COURSES = "allCourses";
	public static final String CURRICULUM_ALL_COURSES_COPY = "allCoursesCopy";
	public static final String CURRICULUM_REQUIRED_COURSES = "requiredCourses";
	public static final String CURRICULUM_MENTION_COURSES = "mentionCourses";
	public static final String CURRICULUM_FREE_COURSES = "freeCourses";
	
	public static final String VIEW_SECTION_PATH = "/PlanCurricular/views/sections/";
	public static final String VIEW_PAGE_PATH = "/PlanCurricular/views/";
	
	public static final String SESSION_SEMESTER = "semester";
	public static final String SESSION_COURSES = "sessionCourses";
	public static final String SESSION_NEW_COURSES = "sessionNewCourses";
	public static final String SESSION_CHANGES = "sessionChanges";
	public static final String REQUEST_COURSES = "requestCourses";
}
