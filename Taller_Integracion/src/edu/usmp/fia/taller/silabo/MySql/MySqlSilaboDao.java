package edu.usmp.fia.taller.silabo.MySql;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import java.util.Vector;

import edu.usmp.fia.taller.common.bean.silabo.BibliografiaBean;
import edu.usmp.fia.taller.common.bean.silabo.CursoBean;
import edu.usmp.fia.taller.common.bean.silabo.SilaboBean;
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
				VECTOR_OUT.add(OBJETO);
			}
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		return VECTOR_OUT;
	}
	
	public Vector<BibliografiaBean> listarBibliografia(String id) throws Exception {
		Vector<BibliografiaBean> VECTOR_OUT = null;
		try {
			Connection con = MySqlDAOFactory.obtenerConexion();
			Statement stmt = con.createStatement();
			
			String query = "SELECT * FROM t_bibliografia where id_bibliografia='"+id+"'";
			ResultSet rs = stmt.executeQuery(query);
			VECTOR_OUT = new Vector<BibliografiaBean>();
			while(rs.next()){			
				BibliografiaBean OBJETO = new BibliografiaBean();
				OBJETO.setIdBibliografia(rs.getString("id_bibliografia"));
				OBJETO.setReseña(rs.getString("reseña"));
				VECTOR_OUT.add(OBJETO);
			}
			System.out.print("encontro la bibliografia: " +rs.getString("reseña"));
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		
		return VECTOR_OUT;
	}
	public int agregarSilabo(String idCurso,String idPc,String pFin,String fecha ) throws Exception {

		Date date = new Date();
		fecha=""+date;
		System.out.print("fecha:"+fecha);
		
		try {
			Connection con = MySqlDAOFactory.obtenerConexion();
			Statement stmt = con.createStatement();
			stmt.executeUpdate("INSERT INTO t_silabo " +
							"(id_curso,id_plan_curricular,prom_final,fecha) VALUES " +
							"('"+idCurso+"',"+idPc+",'"+pFin+"','2015/10/08')");
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		return idSilabo();
	}
	
	public int idSilabo() throws Exception{
		int max=0;
		try {
			Connection con = MySqlDAOFactory.obtenerConexion();
			Statement stmt = con.createStatement();
			String query = "SELECT * FROM t_silabo";
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()){
				max=Math.max(max,rs.getInt("id_silabo"));
			}
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		return max;
	}
	
	public void agregarSemana(int numsemana,int numsesion,int idsilabo,String titulo,String descripcion) throws Exception {
		
		try {
			Connection con = MySqlDAOFactory.obtenerConexion();
			Statement stmt = con.createStatement();
			stmt.executeUpdate("INSERT INTO t_semana " +
							"(numsemana,numsesion,idsilabo,titulo,descripcion) VALUES " +
							"("+numsemana+","+numsesion+","+idsilabo+",'"+titulo+"',"+descripcion+")");
			
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
	}
	
	public void agregarBibliografia(int id_silabo,String reseña) throws Exception {
		
		try {
			Connection con = MySqlDAOFactory.obtenerConexion();
			Statement stmt = con.createStatement();
			stmt.executeUpdate("INSERT INTO t_bibliografia " +
							"(id_silabo,reseña) VALUES " +
							"("+id_silabo+",'"+reseña+"')");
			
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
	}

	// Listar Beans	
	public Vector<SilaboBean> listarSilabo(String id) throws Exception {
		Vector<SilaboBean> VECTOR_OUT = null;
		
		System.out.print("id:"+id);
		try {
			Connection con = MySqlDAOFactory.obtenerConexion();
			Statement stmt = con.createStatement();
			String query = "SELECT * FROM t_silabo s,t_curso c, t_plan_curricular_detalle pc,t_curso_condicion cc, t_curso_area a  where s.id_curso=c.id AND pc.curso_id=c.id AND a.id=pc.curso_area_id AND cc.id=pc.curso_condicion_id AND s.id_curso='"+id+"'";
			ResultSet rs = stmt.executeQuery(query);
			VECTOR_OUT = new Vector<SilaboBean>();
			while(rs.next()){			
				SilaboBean OBJETO = new SilaboBean();
				OBJETO.setIdCurso(rs.getString("c.id"));
				OBJETO.setIdSilabo(rs.getString("s.id_silabo"));
				OBJETO.setNombreCurso(rs.getString("c.nombre"));
				OBJETO.setAreaCu(rs.getString("a.nombre"));
				OBJETO.setCondCurso(rs.getString("cc.nombre"));
				OBJETO.setCreditos(rs.getString("pc.creditos"));
				//OBJETO.setSumilla(rs.getString(""));
				OBJETO.setPromFinal(rs.getString("s.prom_final"));
				//OBJETO.setRequisito(rs.getString(""));
				OBJETO.setHorasP(rs.getString("pc.horasLaboratorio"));
				OBJETO.setHorasT(rs.getString("pc.horasTeoria"));
				VECTOR_OUT.add(OBJETO);
			}
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		
		return VECTOR_OUT;
	}
	public Vector<CursoBean> listarPlan() throws Exception {
		
		return null;
	}
	// Modificar Silabo
	public boolean modificarSilabo(String idCurso, String idPc, String idBi,
			String idSemana, String pFin, String fecha) throws Exception {
		
		try {
			Connection con = MySqlDAOFactory.obtenerConexion();
			Statement stmt = con.createStatement();
			//stmt.executeUpdate("update t_bibliografia set reseña='"+nombre+"',estado="+e+",tipo="+t+" where id='"+idCurso+"'");
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		return false;

	}
	public boolean modificarSemana(String idCurso) throws Exception {
		
		return false;
	}
	public boolean modificarBibliografia(String idBibliografia,String reseña) throws Exception {

		try {
			Connection con = MySqlDAOFactory.obtenerConexion();
			Statement stmt = con.createStatement();
			stmt.executeUpdate("update t_bibliografia set reseña='"+reseña+"' where id_bibliografia="+idBibliografia+"");
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		return false;
	}
	
}