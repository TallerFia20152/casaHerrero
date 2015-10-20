package edu.usmp.fia.taller.login.dataaccess;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import edu.usmp.fia.taller.common.bean.Modulo;
import edu.usmp.fia.taller.common.dao.MySqlDAOFactory;
import edu.usmp.fia.taller.login.dataaccess.interfaces.DAOUsuario;

public class MysqlUsuario implements DAOUsuario {

	
	public List<Modulo> getModulosPorUsuario(String idusuario) throws Exception {
		Connection oCn = null;
		PreparedStatement oPs = null;
		ResultSet oRs = null;
		List<Modulo> oList = new ArrayList<Modulo>();
		try {
			oCn = (Connection) MySqlDAOFactory.obtenerConexion();
			oPs = (PreparedStatement) oCn.prepareStatement("{call GET_MODULOS_BY_USER(?)}");
			oPs.setString(1, idusuario);
			oRs = oPs.executeQuery();
			while(oRs.next()) {
				Modulo oModulo = new Modulo();
				oModulo.setIdModulo(oRs.getInt("id_modulo"));
				oModulo.setDescripcion(oRs.getString("descripcion"));
				oList.add(oModulo);
			}
		} finally {
			MySqlDAOFactory.close(oRs);
			MySqlDAOFactory.close(oPs);
			MySqlDAOFactory.close(oCn);
		}
		return oList;
	}

	
}
