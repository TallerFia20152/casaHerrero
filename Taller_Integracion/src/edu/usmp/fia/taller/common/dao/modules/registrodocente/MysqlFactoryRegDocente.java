package edu.usmp.fia.taller.common.dao.modules.registrodocente;

import edu.usmp.fia.taller.registrodocente.dataaccess.MysqlRegistroDocente;
import edu.usmp.fia.taller.registrodocente.dataaccess.interfaces.DAORegistroDocente;

public class MysqlFactoryRegDocente implements DAOFactoryRegDocente{

	@Override
	public DAORegistroDocente regDocente() {
		// TODO Auto-generated method stub
		return new MysqlRegistroDocente();
	}

}
