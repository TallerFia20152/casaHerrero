package edu.usmp.fia.taller.common.bean;

import java.io.Serializable;

public class UsuarioDetalle implements Serializable {


	private Rol userType;
	private boolean activate;
	
	
	public Rol getUserType() {
		return userType;
	}
	public void setUserType(Rol userType) {
		this.userType = userType;
	}
	public boolean isActivate() {
		return activate;
	}
	public void setActivate(boolean activate) {
		this.activate = activate;
	}
	
}
