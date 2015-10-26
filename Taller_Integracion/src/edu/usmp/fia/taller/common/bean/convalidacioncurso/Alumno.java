package edu.usmp.fia.taller.common.bean.convalidacioncurso;

import com.mysql.jdbc.Blob;

public class Alumno {
	private Persona persona;
	private String dni;
	private String fechanacimiento;
	private String direccion;
	private Distrito distrito;
	private int numerocelular;
	private int numerocasa;
	private Blob fotografia;
	private ModalidadIngreso modalidadingreso;
	private Especialidad especialidad;
	private Facultad facultad;

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getFechanacimiento() {
		return fechanacimiento;
	}

	public void setFechanacimiento(String fechanacimiento) {
		this.fechanacimiento = fechanacimiento;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Distrito getDistrito() {
		return distrito;
	}

	public void setDistrito(Distrito distrito) {
		this.distrito = distrito;
	}

	public int getNumerocelular() {
		return numerocelular;
	}

	public void setNumerocelular(int numerocelular) {
		this.numerocelular = numerocelular;
	}

	public int getNumerocasa() {
		return numerocasa;
	}

	public void setNumerocasa(int numerocasa) {
		this.numerocasa = numerocasa;
	}

	public Blob getFotografia() {
		return fotografia;
	}

	public void setFotografia(Blob fotografia) {
		this.fotografia = fotografia;
	}

	public ModalidadIngreso getModalidadingreso() {
		return modalidadingreso;
	}

	public void setModalidadingreso(ModalidadIngreso modalidadingreso) {
		this.modalidadingreso = modalidadingreso;
	}

	public Especialidad getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(Especialidad especialidad) {
		this.especialidad = especialidad;
	}

	public Facultad getFacultad() {
		return facultad;
	}

	public void setFacultad(Facultad facultad) {
		this.facultad = facultad;
	}

}
