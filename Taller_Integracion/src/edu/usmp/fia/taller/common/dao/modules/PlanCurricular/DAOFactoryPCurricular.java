package edu.usmp.fia.taller.common.dao.modules.PlanCurricular;

import java.util.List;

import edu.usmp.fia.taller.common.bean.PlanCurricular.Curso;;
public interface DAOFactoryPCurricular {
	public List<Curso> obtenerCursosPlan() throws Exception ;
	public List<Curso> obtenerCursosObligatorios() throws Exception ;
	public List<Curso> obtenerCursosLibres() throws Exception ;
	public List<Curso> obtenerCursosMencion() throws Exception;
	public List<Curso> obtenerListaMaestra() throws Exception;
	public String obtenerNuevoCodigo();
	public String obtenerSemestre();

}