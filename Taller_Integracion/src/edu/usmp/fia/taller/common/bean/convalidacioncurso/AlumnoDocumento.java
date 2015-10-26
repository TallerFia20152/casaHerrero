package edu.usmp.fia.taller.common.bean.convalidacioncurso;

import com.mysql.jdbc.Blob;

public class AlumnoDocumento {
	private Documento documento;
	private Alumno alumno;
	private String entregado;
	private Blob documento_imagen;

	public Documento getDocumento() {
		return documento;
	}

	public void setDocumento(Documento documento) {
		this.documento = documento;
	}

	public Alumno getAlumno() {
		return alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}

	public String getEntregado() {
		return entregado;
	}

	public void setEntregado(String entregado) {
		this.entregado = entregado;
	}

	public Blob getDocumento_imagen() {
		return documento_imagen;
	}

	public void setDocumento_imagen(Blob documento_imagen) {
		this.documento_imagen = documento_imagen;
	}

}
