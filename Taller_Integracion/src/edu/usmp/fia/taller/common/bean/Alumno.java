package edu.usmp.fia.taller.common.bean;

public class Alumno {

	private int idAlumno;
	private int idUSMP;
	private Persona person;
	

	public int getIdAlumno() {
		return idAlumno;
	}
	public void setIdAlumno(int idAlumno) {
		this.idAlumno = idAlumno;
	}
	public int getIdUSMP() {
		return idUSMP;
	}
	public void setIdUSMP(int idUSMP) {
		this.idUSMP = idUSMP;
	}
	public Persona getPerson() {
		return person;
	}
	public void setPerson(Persona person) {
		this.person = person;
	}
	
}
