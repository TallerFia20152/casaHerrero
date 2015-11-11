package edu.usmp.fia.taller.PlanCurricular.business;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.usmp.fia.taller.common.bean.PlanCurricular.Curso;
import edu.usmp.fia.taller.common.bean.PlanCurricular.T_Curso;

public interface CurriculumBusiness {

	public String getSemester();
	public Map<String, List<Curso>> getCurrentCurriculum();
	public Map<String, List<Curso>> applyNewCurriculum(List<Curso> courses);
	public List<T_Curso> getCursosT_ciclo();
	public List<String> grabarNewCurriculum(List<Curso> courses);
	public HashMap<String, String> actualizarCambios(List<Curso> courses);
}
