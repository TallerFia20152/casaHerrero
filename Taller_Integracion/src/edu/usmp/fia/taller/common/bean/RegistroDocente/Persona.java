package edu.usmp.fia.taller.common.bean.RegistroDocente;

import java.io.Serializable;
import java.util.List;

public class Persona implements Serializable {

	private int idPersona;
	private String nombre1;
	private String nombre2;
	private String apePaterno;
	private String apeMaterno;
	private String sexo;
	private String email;
	private User usuario;
	
	
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
	public int getIdPersona() {
		return idPersona;
	}
	public void setIdPersona(int idPersona) {
		this.idPersona = idPersona;
	}
	public String getNombre1() {
		return nombre1;
	}
	public void setNombre1(String nombre1) {
		this.nombre1 = nombre1;
	}
	public String getNombre2() {
		return nombre2;
	}
	public void setNombre2(String nombre2) {
		this.nombre2 = nombre2;
	}
	public String getApePaterno() {
		return apePaterno;
	}
	public void setApePaterno(String apePaterno) {
		this.apePaterno = apePaterno;
	}
	public String getApeMaterno() {
		return apeMaterno;
	}
	public void setApeMaterno(String apeMaterno) {
		this.apeMaterno = apeMaterno;
	}
	public User getUsuario() {
		return usuario;
	}
	public void setUsuario(User usuario) {
		this.usuario = usuario;
	}
	
	@Override
	public String toString() {
		return "{id:\"" + this.idPersona + "\", nombre1:\"" + this.nombre1 + "\", nombre2:\"" + this.nombre2 + "\", apepat:\"" + this.apePaterno + "\", apemat:\"" + this.apeMaterno + "\"}";
	}
	
}
