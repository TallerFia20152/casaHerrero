package edu.usmp.fia.taller.common.bean;

import java.io.Serializable;
import java.util.List;

public class Usuario implements Serializable {

	private Persona persona;
	private String loginUser;
	private String password;
	private boolean activate;
	private Rol rol;
	//private List<UsuarioDetalle> detalle;
	
	
	public Persona getPersona() {
		return persona;
	}
	public void setPersona(Persona persona) {
		this.persona = persona;
	}
	public String getLoginUser() {
		return loginUser;
	}
	public void setLoginUser(String loginUser) {
		this.loginUser = loginUser;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isActivate() {
		return activate;
	}
	public void setActivate(boolean activate) {
		this.activate = activate;
	}
	public Rol getRol() {
		return rol;
	}
	public void setRol(Rol rol) {
		this.rol = rol;
	}
	
}
