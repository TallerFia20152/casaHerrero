package edu.usmp.fia.taller.common.bean;

import java.io.Serializable;
import java.util.List;

public class Persona implements Serializable {

	//private int idPersona;
	private String idPersona;
	private String nombre;
	private String apePaterno;
	private String apeMaterno;	
	
	
	public String getIdPersona() {
		return idPersona;
	}
	public void setIdPersona(String idPersona) {
		this.idPersona = idPersona;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
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
	
	@Override
	public String toString() {
		return "{id:\"" + this.idPersona + "\", nombre1:\"" + this.nombre + "\", apepat:\"" + this.apePaterno + "\", apemat:\"" + this.apeMaterno + "\"}";
	}
	
}
