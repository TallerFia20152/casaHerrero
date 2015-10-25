package edu.usmp.fia.taller.common.bean.convalidacioncurso;

public class PlanCurricular {
	private int id;
	private Semestre semestre;
	private String fechacreacion;
	private String fechamodificacion;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Semestre getSemestre() {
		return semestre;
	}

	public void setSemestre(Semestre semestre) {
		this.semestre = semestre;
	}

	public String getFechacreacion() {
		return fechacreacion;
	}

	public void setFechacreacion(String fechacreacion) {
		this.fechacreacion = fechacreacion;
	}

	public String getFechamodificacion() {
		return fechamodificacion;
	}

	public void setFechamodificacion(String fechamodificacion) {
		this.fechamodificacion = fechamodificacion;
	}

}
