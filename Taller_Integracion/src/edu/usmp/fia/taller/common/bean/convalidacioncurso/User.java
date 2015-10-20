package edu.usmp.fia.taller.common.bean.convalidacioncurso;

import java.io.Serializable;
import java.util.List;

public class User implements Serializable {

	private int idUser;
	private String loginUser;
	private String password;
	private boolean activate;
	private List<UsuarioDetalle> detalle;
	
	
	public int getIdUser() {
		return idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
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
	public List<UsuarioDetalle> getDetalle() {
		return detalle;
	}
	public void setDetalle(List<UsuarioDetalle> detalle) {
		this.detalle = detalle;
	}
	
}
