package edu.usmp.fia.taller.common.dao.modules;

import edu.usmp.fia.taller.login.dataaccess.interfaces.DAOLogin;
import edu.usmp.fia.taller.login.dataaccess.interfaces.DAOUsuario;

public interface DAOFactoryGeneral {

	public DAOLogin getLogin();
	public DAOUsuario getUsuario();
	
}
