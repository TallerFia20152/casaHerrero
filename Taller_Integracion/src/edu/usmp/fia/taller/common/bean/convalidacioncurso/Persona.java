package edu.usmp.fia.taller.common.bean.convalidacioncurso;

import java.io.Serializable;

public class Persona implements Serializable {

	private String id;
	private String nombre;
	private String apellidopaterno;
	private String apellidomaterno;
	private String sexo;
	private String email;
	private Usuario usuario;
	// variable usada para cargar lista - nombre completo apepat.apemat.nombres
	private String nomcom;

	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidopaterno() {
		return apellidopaterno;
	}

	public void setApellidopaterno(String apellidopaterno) {
		this.apellidopaterno = apellidopaterno;
	}

	public String getApellidomaterno() {
		return apellidomaterno;
	}

	public void setApellidomaterno(String apellidomaterno) {
		this.apellidomaterno = apellidomaterno;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getNomcom() {
		return nomcom;
	}

	public void setNomcom(String nomcom) {
		this.nomcom = nomcom;
	}

}
