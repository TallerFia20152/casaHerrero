/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.usmp.fia.taller.common.bean.convalidacioncurso;

/**
 *
 * @author Ingeniero
 */
public class Convalidacion {

	private PlanCurricular plancurricular;
	private Curso curso;
	private String cursoorigencodigo;
	private Alumno alumno;
	private String fecha;
	private String comentarios;

	public PlanCurricular getPlancurricular() {
		return plancurricular;
	}

	public void setPlancurricular(PlanCurricular plancurricular) {
		this.plancurricular = plancurricular;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public String getCursoorigencodigo() {
		return cursoorigencodigo;
	}

	public void setCursoorigencodigo(String cursoorigencodigo) {
		this.cursoorigencodigo = cursoorigencodigo;
	}

	public Alumno getAlumno() {
		return alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getComentarios() {
		return comentarios;
	}

	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}

}
