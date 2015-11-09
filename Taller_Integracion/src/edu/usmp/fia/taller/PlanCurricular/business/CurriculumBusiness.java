package edu.usmp.fia.taller.PlanCurricular.business;

import java.util.List;
import java.util.Map;

import edu.usmp.fia.taller.common.bean.PlanCurricular.Curso;
import edu.usmp.fia.taller.common.bean.PlanCurricular.T_Curso;

public interface CurriculumBusiness {

	public String getSemester();
	public Map<String, List<Curso>> getCurrentCurriculum();
	public Map<String, List<Curso>> applyNewCurriculum(List<Curso> courses);
	public List<T_Curso> getCursosT_ciclo();
	public Map<String, List<Curso>> grabarNewCurriculum(List<Curso> courses);
	public Map<String, List<Curso>> actualizarCambios(List<Curso> courses);
}
