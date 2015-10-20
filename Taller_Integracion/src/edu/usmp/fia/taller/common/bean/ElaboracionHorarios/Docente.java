package edu.usmp.fia.taller.common.bean.ElaboracionHorarios;

import java.io.Serializable;
import java.util.List;
import java.util.Date;

public class Docente {

	private int id_docente;
	private int id_Pais_nacionalidad;
	private int id_Departamento_nacionalidad;
	private int id_Provincia_nacionalidad;
	private int id_Distrito_nacionalidad;
	private int id_Departamento_direccion;
	private int id_Provincia_direccion;
	private int id_Distrito_direccion;
	private String nombre;
	private String apellido_materno;
	private String apellido_paterno;
	private String url_foto;
	private int telefono;
	private String correo;
	private char estado;
	private char estado_civil;
	private char sexo;
	private String fecha_nacimiento;
	private String referencia_direccion;
	private String tipo_documento;
	private String grado_academico;
	private String profecion;
	private String especialidad;
	private String institucion;
	private String fecha_ingreso;
	
	
	
	public String getTipo_documento() {
		return tipo_documento;
	}
	public void setTipo_documento(String tipo_documento) {
		this.tipo_documento = tipo_documento;
	}
	public String getGrado_academico() {
		return grado_academico;
	}
	public void setGrado_academico(String grado_academico) {
		this.grado_academico = grado_academico;
	}
	public String getProfecion() {
		return profecion;
	}
	public void setProfecion(String profecion) {
		this.profecion = profecion;
	}
	public String getEspecialidad() {
		return especialidad;
	}
	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}
	public String getInstitucion() {
		return institucion;
	}
	public void setInstitucion(String institucion) {
		this.institucion = institucion;
	}
	public String getFecha_ingreso() {
		return fecha_ingreso;
	}
	public void setFecha_ingreso(String fecha_ingreso) {
		this.fecha_ingreso = fecha_ingreso;
	}
	public int getId_docente() {
		return id_docente;
	}
	public void setId_docente(int id_docente) {
		this.id_docente = id_docente;
	}
	public int getId_Pais_nacionalidad() {
		return id_Pais_nacionalidad;
	}
	public void setId_Pais_nacionalidad(int id_Pais_nacionalidad) {
		this.id_Pais_nacionalidad = id_Pais_nacionalidad;
	}
	public int getId_Departamento_nacionalidad() {
		return id_Departamento_nacionalidad;
	}
	public void setId_Departamento_nacionalidad(int id_Departamento_nacionalidad) {
		this.id_Departamento_nacionalidad = id_Departamento_nacionalidad;
	}
	public int getId_Provincia_nacionalidad() {
		return id_Provincia_nacionalidad;
	}
	public void setId_Provincia_nacionalidad(int id_Provincia_nacionalidad) {
		this.id_Provincia_nacionalidad = id_Provincia_nacionalidad;
	}
	public int getId_Distrito_nacionalidad() {
		return id_Distrito_nacionalidad;
	}
	public void setId_Distrito_nacionalidad(int id_Distrito_nacionalidad) {
		this.id_Distrito_nacionalidad = id_Distrito_nacionalidad;
	}
	public int getId_Departamento_direccion() {
		return id_Departamento_direccion;
	}
	public void setId_Departamento_direccion(int id_Departamento_direccion) {
		this.id_Departamento_direccion = id_Departamento_direccion;
	}
	public int getId_Provincia_direccion() {
		return id_Provincia_direccion;
	}
	public void setId_Provincia_direccion(int id_Provincia_direccion) {
		this.id_Provincia_direccion = id_Provincia_direccion;
	}
	public int getId_Distrito_direccion() {
		return id_Distrito_direccion;
	}
	public void setId_Distrito_direccion(int id_Distrito_direccion) {
		this.id_Distrito_direccion = id_Distrito_direccion;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido_materno() {
		return apellido_materno;
	}
	public void setApellido_materno(String apellido_materno) {
		this.apellido_materno = apellido_materno;
	}
	public String getApellido_paterno() {
		return apellido_paterno;
	}
	public void setApellido_paterno(String apellido_paterno) {
		this.apellido_paterno = apellido_paterno;
	}
	public String getUrl_foto() {
		return url_foto;
	}
	public void setUrl_foto(String url_foto) {
		this.url_foto = url_foto;
	}
	public int getTelefono() {
		return telefono;
	}
	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public char getEstado() {
		return estado;
	}
	public void setEstado(char estado) {
		this.estado = estado;
	}
	public char getEstado_civil() {
		return estado_civil;
	}
	public void setEstado_civil(char estado_civil) {
		this.estado_civil = estado_civil;
	}
	public char getSexo() {
		return sexo;
	}
	public void setSexo(char sexo) {
		this.sexo = sexo;
	}
	public String getFecha_nacimiento() {
		return fecha_nacimiento;
	}
	public void setFecha_nacimiento(String fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}
	public String getReferencia_direccion() {
		return referencia_direccion;
	}
	public void setReferencia_direccion(String referencia_direccion) {
		this.referencia_direccion = referencia_direccion;
	}
	
	//private List<UsuarioDetalle> detalle;

	/*
	public List<UsuarioDetalle> getDetalle() {
		return detalle;
	}
	public void setDetalle(List<UsuarioDetalle> detalle) {
		this.detalle = detalle;
	}*/
	
}
