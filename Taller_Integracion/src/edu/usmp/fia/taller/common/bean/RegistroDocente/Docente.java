package edu.usmp.fia.taller.common.bean.RegistroDocente;


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
	private char estado;
	private char estado_civil;
	private String sexo;
	private String referencia_direccion;
	public String getReferencia_direccion() {
		return referencia_direccion;
	}
	public void setReferencia_direccion(String referencia_direccion) {
		this.referencia_direccion = referencia_direccion;
	}
	private String fecha_nacimiento;
	
	
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
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getFecha_nacimiento() {
		return fecha_nacimiento;
	}
	public void setFecha_nacimiento(String fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
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
