package edu.usmp.fia.taller.login.dataaccess.interfaces;

import java.util.List;

import edu.usmp.fia.taller.common.bean.Modulo;
import edu.usmp.fia.taller.common.bean.UsuarioDetalle;


public interface DAOUsuario {
	
	public List<Modulo> getModulosPorUsuario(String idUsuario) throws Exception;

}
