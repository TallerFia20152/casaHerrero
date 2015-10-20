/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.usmp.fia.taller.convalidacioncurso.dataaccess.interfaces;

import edu.usmp.fia.taller.common.bean.convalidacioncurso.Alumno;
import edu.usmp.fia.taller.common.bean.convalidacioncurso.Convalidacion;
import edu.usmp.fia.taller.common.bean.convalidacioncurso.Curso;
import java.util.List;

/**
 *
 * @author Ingeniero
 */
public interface DAOHistoriaConvalidacion {
    
    public List<Curso> listarcursos()throws Exception;
    public List<Convalidacion> listarconvalidaciones();
    public List<Alumno> listaralumnos(Alumno wAlumno)throws Exception;
    public Alumno obtenerDatosAlumno(Alumno wAlumno)throws Exception;
}
