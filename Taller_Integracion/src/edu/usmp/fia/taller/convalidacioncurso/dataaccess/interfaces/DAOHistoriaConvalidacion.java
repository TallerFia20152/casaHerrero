/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.usmp.fia.taller.convalidacioncurso.dataaccess.interfaces;

import edu.usmp.fia.taller.common.bean.convalidacioncurso.Alumno;
import edu.usmp.fia.taller.common.bean.convalidacioncurso.AlumnoConvalidacion;
import edu.usmp.fia.taller.common.bean.convalidacioncurso.Convalidacion;
import edu.usmp.fia.taller.common.bean.convalidacioncurso.ConvalidacionAlumno;
import edu.usmp.fia.taller.common.bean.convalidacioncurso.Departamento;
import edu.usmp.fia.taller.common.bean.convalidacioncurso.Distrito;
import edu.usmp.fia.taller.common.bean.convalidacioncurso.Especialidad;
import edu.usmp.fia.taller.common.bean.convalidacioncurso.Facultad;
import edu.usmp.fia.taller.common.bean.convalidacioncurso.ModalidadIngreso;
import edu.usmp.fia.taller.common.bean.convalidacioncurso.PlanCurricularDetalle;
import edu.usmp.fia.taller.common.bean.convalidacioncurso.UniversidadOrigen;

import java.util.List;

/**
 *
 * @author Ingeniero
 */
public interface DAOHistoriaConvalidacion {
    
    public List<PlanCurricularDetalle> listarcursos(Alumno wAlumno)throws Exception;
    public List<Convalidacion> listarconvalidaciones(Alumno wAlumno)throws Exception;
    public List<Alumno> listaralumnos(Alumno wAlumno)throws Exception;
    public Alumno obtenerDatosAlumno(Alumno wAlumno)throws Exception;
    public List<UniversidadOrigen> listaruniversidades()throws Exception;
    public List<Especialidad> listarespecialidades(Facultad wFacultad)throws Exception;
    public List<Distrito> listardistritos(Departamento wDepartamento)throws Exception;
    public List<ModalidadIngreso> listarmodalidades()throws Exception;
    public void registrarAlumno(Alumno wAlumno)throws Exception;
    public void registrarConvalidacionAlumno(List<AlumnoConvalidacion> wConvalidacionAlumnos)throws Exception;
    public List<ConvalidacionAlumno> listarCursosxconvalidar(Alumno wAlumno)throws Exception;
    public PlanCurricularDetalle BuscarHistorico(ConvalidacionAlumno wConvalidacionAlumno)throws Exception;
    public List<ConvalidacionAlumno> BuscarEnConvalidacion(PlanCurricularDetalle wPlanCurricularDetalle)throws Exception;
    
    
}
