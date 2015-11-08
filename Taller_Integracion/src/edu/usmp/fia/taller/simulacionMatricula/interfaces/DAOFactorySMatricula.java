package edu.usmp.fia.taller.simulacionMatricula.interfaces;

import java.util.List;
import edu.usmp.fia.taller.common.bean.SimulacionMatricula.*;

public interface DAOFactorySMatricula {

	//MATRICULA PROGRESIVA
	//ALUMNO
	public boolean GenerarPreMatricula(String codAlumno, String[] codCurso) throws Exception ;
	public boolean EliminarPreMatricula(String codAlumno) throws Exception ;
	public boolean EliminarHorariosAlumno(String codAlumno) throws Exception ;
	public List<Seccion> SeleccionarSeccion(String idCurso) throws Exception ;
	public List<Horas> HorasSeccion(String idCurso,String seccion) throws Exception ;
	public List<Seccion> SeleccionarSeccionAgrupados(String idCurso) throws Exception ;
	
	
	public boolean RegistrarHorariosAlumno(String codAlumno, String[] codCurso,String[] seccion) throws Exception ;
		
	//ENCARGADO
	public List<Alumno> ListarAlumnos() throws Exception;	
	public List<Curso> ListarCursoObligatorios(int codAlumno) throws Exception;	
	public Curso ListarDetalleCurso(String curso) throws Exception;
	public List<Curso> ListarCursoCantAlumno() throws Exception;	
	
	//LOS DOS MODULOS(ENCARGADO Y ALUMNO)
	public List<Curso> CursosProbables(String codigoAlumno) throws Exception ;
	public List<Curso> CursosPreferibles(String codigoAlumno) throws Exception ;
	public List<Curso> ListarCursosAptos(String codAlumno) throws Exception;
	
	
	//SIMULACION DE MATRICULA
	public List<Area> SimulacionCursosPreferidos() throws Exception;	
	public List<Area> SimulacionIncial() throws Exception;	
	public List<Area> SimulacionProbable() throws Exception;

	
	public boolean BuscarPreMatricula(String codAlumno) throws Exception;	
	public boolean BuscarHorariosAlumnos(String codAlumno)throws Exception;	
	
	public List<Curso> ListarReporteMatriculaProgrevisa() throws Exception;
	
}
