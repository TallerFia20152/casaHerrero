package edu.usmp.fia.taller.common.dao.modules;

import edu.usmp.fia.taller.login.dataaccess.MysqlLogin;
import edu.usmp.fia.taller.login.dataaccess.MysqlUsuario;
import edu.usmp.fia.taller.login.dataaccess.interfaces.DAOLogin;
import edu.usmp.fia.taller.login.dataaccess.interfaces.DAOUsuario;

public class MysqlFactoryGeneral implements DAOFactoryGeneral {

	@Override
	public DAOLogin getLogin() {
		return new MysqlLogin();
	}

	@Override
	public DAOUsuario getUsuario() {
		return new MysqlUsuario();
	}
	
}
