package edu.usmp.fia.taller.common.bean.convalidacioncurso;

public class ConvalidacionAlumno {

	private String cursoorigencodigo;
	private String cursoorigennombre;
	private Alumno alumno;
	private int nota;
	private String semestre;
	private UniversidadOrigen universidadorigen;

	public String getCursoorigencodigo() {
		return cursoorigencodigo;
	}

	public void setCursoorigencodigo(String cursoorigencodigo) {
		this.cursoorigencodigo = cursoorigencodigo;
	}

	public String getCursoorigennombre() {
		return cursoorigennombre;
	}

	public void setCursoorigennombre(String cursoorigennombre) {
		this.cursoorigennombre = cursoorigennombre;
	}

	public Alumno getAlumno() {
		return alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}

	public int getNota() {
		return nota;
	}

	public void setNota(int nota) {
		this.nota = nota;
	}

	public String getSemestre() {
		return semestre;
	}

	public void setSemestre(String semestre) {
		this.semestre = semestre;
	}

	public UniversidadOrigen getUniversidadorigen() {
		return universidadorigen;
	}

	public void setUniversidadorigen(UniversidadOrigen universidadorigen) {
		this.universidadorigen = universidadorigen;
	}

}
