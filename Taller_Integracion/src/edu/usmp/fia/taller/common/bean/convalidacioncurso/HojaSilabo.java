package edu.usmp.fia.taller.common.bean.convalidacioncurso;

import com.mysql.jdbc.Blob;

public class HojaSilabo {
	private String cursoorigencodigo;
	private Alumno alumno;
	private Blob hoja;
	private int conhoja;

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

	public Blob getHoja() {
		return hoja;
	}

	public void setHoja(Blob hoja) {
		this.hoja = hoja;
	}

	public int getConhoja() {
		return conhoja;
	}

	public void setConhoja(int conhoja) {
		this.conhoja = conhoja;
	}

}
