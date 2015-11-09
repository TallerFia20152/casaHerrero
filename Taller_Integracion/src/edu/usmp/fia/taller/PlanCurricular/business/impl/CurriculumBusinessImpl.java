package edu.usmp.fia.taller.PlanCurricular.business.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.usmp.fia.taller.PlanCurricular.business.CurriculumBusiness;
import edu.usmp.fia.taller.PlanCurricular.util.Constants;
import edu.usmp.fia.taller.common.bean.PlanCurricular.Curso;
import edu.usmp.fia.taller.common.bean.PlanCurricular.T_Curso;
import edu.usmp.fia.taller.common.dao.DAOFactory;
import edu.usmp.fia.taller.common.dao.modules.PlanCurricular.DAOFactoryPCurricular;

public class CurriculumBusinessImpl implements CurriculumBusiness {

	
	public Map<String, List<Curso>> getCurrentCurriculum() {
		
		List<Curso> listaMaestra = new ArrayList<Curso>();
		List<Curso> copiaMaestra = new ArrayList<Curso>();
		List<Curso> freeCourses = new ArrayList<Curso>();
		List<Curso> requiredCourses = new ArrayList<Curso>();
		List<Curso> mentionCourses = new ArrayList<Curso>();
		
		
		try {
			DAOFactory daoFact = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
			DAOFactoryPCurricular cursosdao = daoFact.getCourseDAO();
			listaMaestra = cursosdao.obtenerListaMaestra();
			copiaMaestra = cursosdao.obtenerListaMaestra();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		for(int i=0;i<listaMaestra.size();i++){
			
			if(listaMaestra.get(i).getType()==1){
				requiredCourses.add(listaMaestra.get(i));
			}else if(listaMaestra.get(i).getType()==2){
				mentionCourses.add(listaMaestra.get(i));
			}else if(listaMaestra.get(i).getType()==3){
				freeCourses.add(listaMaestra.get(i));
			}
		}
		
		Collections.sort(requiredCourses, new Comparator<Curso>() {
			
			public int compare(Curso o1, Curso o2) {
				return (o1.getCycle() < o2.getCycle()) ? -1 : 1;
			}			
		});

		Map<String, List<Curso>> curriculum = new HashMap<String, List<Curso>>();
		curriculum.put(Constants.CURRICULUM_ALL_COURSES, listaMaestra);
		curriculum.put(Constants.CURRICULUM_ALL_COURSES_COPY, copiaMaestra);
		curriculum.put(Constants.CURRICULUM_REQUIRED_COURSES, requiredCourses);
		curriculum.put(Constants.CURRICULUM_MENTION_COURSES, mentionCourses);
		curriculum.put(Constants.CURRICULUM_FREE_COURSES, freeCourses);
		
		return curriculum;
	}
	
	public List<T_Curso> getCursosT_ciclo() {
		List<T_Curso> cursosT_ciclo = new ArrayList<T_Curso>();
		try {
			DAOFactory daoFact = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
			DAOFactoryPCurricular cursosdao = daoFact.getCourseDAO();
			cursosT_ciclo = cursosdao.obtenerT_Curso();
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return cursosT_ciclo;
	}
	
	public Map<String, List<Curso>> applyNewCurriculum(List<Curso> courses) {
		List<Curso> freeCourses = new ArrayList<Curso>();
		List<Curso> requiredCourses = new ArrayList<Curso>();
		List<Curso> mentionCourses = new ArrayList<Curso>();
		
		for(int i=0;i<courses.size();i++){
			
			if(courses.get(i).getType()==1){
				requiredCourses.add(courses.get(i));
			}else if(courses.get(i).getType()==2){
				mentionCourses.add(courses.get(i));
			}else if(courses.get(i).getType()==3){
				freeCourses.add(courses.get(i));
			}
		}
		
		Collections.sort(requiredCourses, new Comparator<Curso>() {
			
			public int compare(Curso o1, Curso o2) {
				return (o1.getCycle() < o2.getCycle()) ? -1 : 1;
			}			
		});

		Map<String, List<Curso>> curriculum = new HashMap<String, List<Curso>>();
		curriculum.put(Constants.CURRICULUM_REQUIRED_COURSES, requiredCourses);
		curriculum.put(Constants.CURRICULUM_MENTION_COURSES, mentionCourses);
		curriculum.put(Constants.CURRICULUM_FREE_COURSES, freeCourses);
		return curriculum;
	}
	
	public Map<String, List<Curso>> saveNewCurriculum(List<Curso> courses) {
		List<Curso> freeCourses = new ArrayList<Curso>();
		List<Curso> requiredCourses = new ArrayList<Curso>();
		List<Curso> mentionCourses = new ArrayList<Curso>();
		
		for(int i=0;i<courses.size();i++){
			if(courses.get(i).getType()==1){
				requiredCourses.add(courses.get(i));
			}else if(courses.get(i).getType()==2){
				mentionCourses.add(courses.get(i));
			}else if(courses.get(i).getType()==3){
				freeCourses.add(courses.get(i));
			}
		}
		
		Collections.sort(requiredCourses, new Comparator<Curso>() {			
			public int compare(Curso o1, Curso o2) {
				return (o1.getCycle() < o2.getCycle()) ? -1 : 1;
			}			
		});

		Map<String, List<Curso>> curriculum = new HashMap<String, List<Curso>>();
		curriculum.put(Constants.CURRICULUM_REQUIRED_COURSES, requiredCourses);
		curriculum.put(Constants.CURRICULUM_MENTION_COURSES, mentionCourses);
		curriculum.put(Constants.CURRICULUM_FREE_COURSES, freeCourses);
		return curriculum;
	}
	
	public Map<String, List<Curso>> grabarNewCurriculum(List<Curso> courses) {
		List<Curso> freeCourses = new ArrayList<Curso>();
		List<Curso> requiredCourses = new ArrayList<Curso>();
		List<Curso> mentionCourses = new ArrayList<Curso>();
		
		for(int i=0;i<courses.size();i++){
			if(courses.get(i).getType()==1){
				requiredCourses.add(courses.get(i));
			}else if(courses.get(i).getType()==2){
				mentionCourses.add(courses.get(i));
			}else if(courses.get(i).getType()==3){
				freeCourses.add(courses.get(i));
			}
		}
		
		Collections.sort(requiredCourses, new Comparator<Curso>() {			
			public int compare(Curso o1, Curso o2) {
				return (o1.getCycle() < o2.getCycle()) ? -1 : 1;
			}			
		});
		DAOFactory dao = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		DAOFactoryPCurricular pCurricularDao = dao.getCourseDAO();
		pCurricularDao.guardarCursos(courses);

		Map<String, List<Curso>> curriculum = new HashMap<String, List<Curso>>();
		curriculum.put(Constants.CURRICULUM_REQUIRED_COURSES, requiredCourses);
		curriculum.put(Constants.CURRICULUM_MENTION_COURSES, mentionCourses);
		curriculum.put(Constants.CURRICULUM_FREE_COURSES, freeCourses);
		return curriculum;
	}
	
	public Map<String, List<Curso>> actualizarCambios(List<Curso> courses) {
		List<Curso> freeCourses = new ArrayList<Curso>();
		List<Curso> requiredCourses = new ArrayList<Curso>();
		List<Curso> mentionCourses = new ArrayList<Curso>();
		
		for(int i=0;i<courses.size();i++){
			if(courses.get(i).getType()==1){
				requiredCourses.add(courses.get(i));
			}else if(courses.get(i).getType()==2){
				mentionCourses.add(courses.get(i));
			}else if(courses.get(i).getType()==3){
				freeCourses.add(courses.get(i));
			}
		}
		
		Collections.sort(requiredCourses, new Comparator<Curso>() {			
			public int compare(Curso o1, Curso o2) {
				return (o1.getCycle() < o2.getCycle()) ? -1 : 1;
			}			
		});
		DAOFactory dao = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		DAOFactoryPCurricular pCurricularDao = dao.getCourseDAO();
		pCurricularDao.actualizarCursos(courses);

		Map<String, List<Curso>> curriculum = new HashMap<String, List<Curso>>();
		curriculum.put(Constants.CURRICULUM_REQUIRED_COURSES, requiredCourses);
		curriculum.put(Constants.CURRICULUM_MENTION_COURSES, mentionCourses);
		curriculum.put(Constants.CURRICULUM_FREE_COURSES, freeCourses);
		return curriculum;
	}

	
	public String getSemester() {
		DAOFactory daoFact = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		DAOFactoryPCurricular dao = daoFact.getCourseDAO();
		return dao.obtenerSemestre();
	}
	
}
