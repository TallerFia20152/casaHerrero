package edu.usmp.fia.taller.PlanCurricular.business;

import java.util.List;
import java.util.Map;

import edu.usmp.fia.taller.common.bean.PlanCurricular.Curso;

public interface CurriculumBusiness {

	public String getSemester();
	public Map<String, List<Curso>> getCurrentCurriculum();
	public Map<String, List<Curso>> applyNewCurriculum(List<Curso> courses);
}
