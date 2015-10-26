package edu.usmp.fia.taller.silabo.MySql;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;
import edu.usmp.fia.taller.common.bean.silabo.CursoBean;
import edu.usmp.fia.taller.common.dao.MySqlDAOFactory;
import edu.usmp.fia.taller.silabo.interfaces.DAOSilabo;

public class MySqlSilaboDao extends MySqlDAOFactory implements DAOSilabo{
	@Override
	public Vector<CursoBean> listar() throws Exception {
		Vector<CursoBean> VECTOR_OUT = null;
		try {
			Connection con = MySqlDAOFactory.obtenerConexion();
			Statement stmt = con.createStatement();
			
			String query = "SELECT * FROM t_curso";
			ResultSet rs = stmt.executeQuery(query);
			VECTOR_OUT = new Vector<CursoBean>();
			while(rs.next()){			
				CursoBean OBJETO = new CursoBean();
				OBJETO.setIdCurso(rs.getString("id"));
				OBJETO.setNombreCurso(rs.getString("nombre"));
				//OBJETO.setTipoCurso(rs.getString("creditos"));
				//OBJETO.setEstadoCruso(rs.getString("ciclo_id"));
				VECTOR_OUT.add(OBJETO);
			}
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		return VECTOR_OUT;
	}
	
	public boolean agregarSilabo(String idCurso,String idPc,String idBi,String idSemana,String pFin,String fecha ) throws Exception {

		boolean flag = false;
		try {
			Connection con = MySqlDAOFactory.obtenerConexion();
			Statement stmt = con.createStatement();
			int filas = 	stmt.executeUpdate("INSERT INTO t_silabo " +
							"(id,nombre,tipo,estado) VALUES " +
							"('"+idCurso+"','"+idPc+"','"+idBi+"','"+idSemana+"','"+pFin+"',"+fecha+")");
			if(filas == 1){
				flag = true;
			}
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		return flag;
	}
	/*
	public boolean agregarSemana() throws Exception {

		boolean flag = false;
		try {
			Connection con = MySqlDAOFactory.obtenerConexion();
			Statement stmt = con.createStatement();
			int filas = 	stmt.executeUpdate("INSERT INTO t_semana " +
							"(id,nombre,tipo,estado) VALUES " +
							"('"+idCurso+"','"+idPc+"','"+idBi+"','"+idSemana+"','"+pFin+"',"+fecha+")");
			if(filas == 1){
				flag = true;
			}
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		return flag;
	}
	
	public boolean agregarBibliografia() throws Exception {

		boolean flag = false;
		try {
			Connection con = MySqlDAOFactory.obtenerConexion();
			Statement stmt = con.createStatement();
			int filas = 	stmt.executeUpdate("INSERT INTO t_bibliografia " +
							"(id,nombre,tipo,estado) VALUES " +
							"('"+idCurso+"','"+idPc+"','"+idBi+"','"+idSemana+"','"+pFin+"',"+fecha+")");
			if(filas == 1){
				flag = true;
			}
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		return flag;
	}
	*/
}