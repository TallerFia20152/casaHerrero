package edu.usmp.fia.taller.common.bean.RegistroDocente;

public class DisponibilidadProfesor {
	private String id;
	private String profesorId;
	private String diaId;
	private String dia;
	private String estado;
	
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getProfesorId() {
		return profesorId;
	}
	public void setProfesorId(String profesorId) {
		this.profesorId = profesorId;
	}
	public String getDiaId() {
		return diaId;
	}
	public void setDiaId(String diaId) {
		this.diaId = diaId;
	}
	public String getDia() {
		return dia;
	}
	public void setDia(String dia) {
		this.dia = dia;
	}
	public String getHoraId() {
		return horaId;
	}
	public void setHoraId(String horaId) {
		this.horaId = horaId;
	}
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	private String horaId;
	private String hora;
	
	
}
