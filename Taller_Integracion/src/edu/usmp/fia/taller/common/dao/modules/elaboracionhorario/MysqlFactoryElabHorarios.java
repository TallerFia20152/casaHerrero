package edu.usmp.fia.taller.common.dao.modules.elaboracionhorario;

import edu.usmp.fia.taller.common.dao.modules.elaboracionhorario.DAOFactoryElabHorarios;
import edu.usmp.fia.taller.elaboracionhorario.dataaccess.MysqlElaboracionHorarios;
import edu.usmp.fia.taller.elaboracionhorario.dataaccess.interfaces.DAOElaboracionHorario;

public class MysqlFactoryElabHorarios  implements DAOFactoryElabHorarios {

	@Override
	public DAOElaboracionHorario elabHorarios() {
		return new MysqlElaboracionHorarios();
		// TODO Auto-generated method stub
		
	}



	

}
