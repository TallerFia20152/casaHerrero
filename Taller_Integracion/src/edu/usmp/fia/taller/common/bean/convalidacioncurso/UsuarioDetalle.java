package edu.usmp.fia.taller.common.bean.convalidacioncurso;

import java.io.Serializable;

public class UsuarioDetalle implements Serializable {


	private UserType userType;
	private boolean activate;
	
	
	public UserType getUserType() {
		return userType;
	}
	public void setUserType(UserType userType) {
		this.userType = userType;
	}
	public boolean isActivate() {
		return activate;
	}
	public void setActivate(boolean activate) {
		this.activate = activate;
	}
	
}
