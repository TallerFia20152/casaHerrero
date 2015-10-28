package edu.usmp.fia.taller.common.bean.RegistroDocente;

public class CursoAptoProfesor {
	private String cursoId;
	private String profesorId;
	private String fechaActualizacion;
	private String Nombre;
	
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	private char estado;
	
	public String getCursoId() {
		return cursoId;
	}
	public void setCursoId(String cursoId) {
		this.cursoId = cursoId;
	}
	public String getProfesorId() {
		return profesorId;
	}
	public void setProfesorId(String profesorId) {
		this.profesorId = profesorId;
	}
	public String getFechaActualizacion() {
		return fechaActualizacion;
	}
	public void setFechaActualizacion(String fechaActualizacion) {
		this.fechaActualizacion = fechaActualizacion;
	}
	public char getEstado() {
		return estado;
	}
	public void setEstado(char estado) {
		this.estado = estado;
	}
	
}
