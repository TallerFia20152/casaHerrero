package edu.usmp.fia.taller.common.dao.modules.convalidacioncurso;

import edu.usmp.fia.taller.convalidacioncurso.dataaccess.MysqlHistoriaConvalidacion;
import edu.usmp.fia.taller.convalidacioncurso.dataaccess.interfaces.DAOHistoriaConvalidacion;

public class MysqlFactoryConvalidacion implements DAOFactoryConvalidacion{

	@Override
	public DAOHistoriaConvalidacion getHistoriaConvalidacion() {
		// TODO Auto-generated method stub
		return new MysqlHistoriaConvalidacion();
	}

}
