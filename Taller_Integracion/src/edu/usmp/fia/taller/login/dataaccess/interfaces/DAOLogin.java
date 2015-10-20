package edu.usmp.fia.taller.login.dataaccess.interfaces;

import edu.usmp.fia.taller.common.bean.Persona;
import edu.usmp.fia.taller.common.bean.Usuario;

public interface DAOLogin {

	public Usuario getUsuario(String user, String password) throws Exception;
	
}
