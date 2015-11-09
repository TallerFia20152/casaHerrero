package edu.usmp.fia.taller.silabo.MySql;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import java.util.Vector;

import edu.usmp.fia.taller.common.bean.silabo.BibliografiaBean;
import edu.usmp.fia.taller.common.bean.silabo.CursoBean;
import edu.usmp.fia.taller.common.bean.silabo.SemanaBean;
import edu.usmp.fia.taller.common.bean.silabo.SilaboBean;
import edu.usmp.fia.taller.common.dao.MySqlDAOFactory;
import edu.usmp.fia.taller.silabo.interfaces.DAOSilabo;

public class MySqlSilaboDao extends MySqlDAOFactory implements DAOSilabo{
	//Listar curso con cuando no tiene silabo
	@Override
	public Vector<CursoBean> listar() throws Exception {
		Vector<CursoBean> VECTOR_OUT = null;
		try {
			Connection con = MySqlDAOFactory.obtenerConexion();
			Statement stmt = con.createStatement();
			
			String query = "SELECT * FROM t_curso where estado_silabo='0'";
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
	//Listar curso con cuando tiene silabo
	public Vector<CursoBean> listarCursoxSilabo() throws Exception {
		Vector<CursoBean> VECTOR_OUT = null;
		try {
			Connection con = MySqlDAOFactory.obtenerConexion();
			Statement stmt = con.createStatement();
			
			String query = "SELECT * FROM t_curso where estado_silabo='1'";
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
	//Listar bibliografia
	public Vector<BibliografiaBean> listarBibliografia(String id) throws Exception {
		Vector<BibliografiaBean> VECTOR_OUT = null;
		try {
			Connection con = MySqlDAOFactory.obtenerConexion();
			Statement stmt = con.createStatement();
			
			String query = "SELECT * FROM t_bibliografia where id_silabo='"+id+"'";
			ResultSet rs = stmt.executeQuery(query);
			VECTOR_OUT = new Vector<BibliografiaBean>();
			while(rs.next()){			
				BibliografiaBean OBJETO = new BibliografiaBean();
				OBJETO.setIdBibliografia(rs.getString("id_bibliografia"));
				OBJETO.setReseña(rs.getString("reseña"));
				VECTOR_OUT.add(OBJETO);
			}
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		
		return VECTOR_OUT;
	}
	
	public Vector<SemanaBean> listarSemana(String id) throws Exception {
		Vector<SemanaBean> VECTOR_OUT = null;
		try {
			Connection con = MySqlDAOFactory.obtenerConexion();
			Statement stmt = con.createStatement();
			
			String query = "SELECT * FROM t_semana where id_silabo='"+id+"'";
			ResultSet rs = stmt.executeQuery(query);
			VECTOR_OUT = new Vector<SemanaBean>();
			while(rs.next()){			
				SemanaBean OBJETO = new SemanaBean();
				OBJETO.setIdSemana(rs.getString("id_semana"));
				OBJETO.setNumSemana(Integer.parseInt(rs.getString("num_semana")));
				OBJETO.setNumSesion(Integer.parseInt(rs.getString("num_sesion")));
				OBJETO.setTitulo(rs.getString("tema"));
				VECTOR_OUT.add(OBJETO);
			}
			
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		
		return VECTOR_OUT;
	}

	// Listar Silabo por IDCURSO
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
				OBJETO.setSumilla(rs.getString("c.sumilla"));
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
			modificarSilaboCurso(idCurso);
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
	
	public void agregarSemana(int numsemana,int numsesion,int idsilabo,String titulo) throws Exception {
		
		try {
			Connection con = MySqlDAOFactory.obtenerConexion();
			Statement stmt = con.createStatement();
			stmt.executeUpdate("INSERT INTO t_semana " +
							"(num_semana,num_sesion,id_silabo,tema) VALUES " +
							"("+numsemana+","+numsesion+","+idsilabo+",'"+titulo+"')");
			
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
	// Modificar Silabo
	public boolean modificarSilabo(String promedio,String IdSilabo) throws Exception {
		try {
			Connection con = MySqlDAOFactory.obtenerConexion();
			Statement stmt = con.createStatement();
			stmt.executeUpdate("update t_silabo set prom_final='"+promedio+"' where id_silabo='"+IdSilabo+"'");
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		return false;

	}
	public void modificarSilaboCurso(String IdCurso) throws Exception {
		try {
			Connection con = MySqlDAOFactory.obtenerConexion();
			Statement stmt = con.createStatement();
			stmt.executeUpdate("update t_curso set estado_silabo='1' where id='"+IdCurso+"'");
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
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
	//cambios recientes  
	@Override
	public Vector<CursoBean> listarCurso() throws Exception {
		
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
				OBJETO.setTipoCurso(rs.getString("tipo"));
				OBJETO.setSumillaCurso(rs.getString("sumilla"));
				VECTOR_OUT.add(OBJETO);
			}
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		return VECTOR_OUT;
		
	}
	
	@Override
	public Vector<CursoBean> listarCursoxID(String id) throws Exception {
		
		Vector<CursoBean> VECTOR_OUT = null;
		try {
			Connection con = MySqlDAOFactory.obtenerConexion();
			Statement stmt = con.createStatement();
			
			String query = "SELECT * FROM t_curso where id='"+id+"'";
			ResultSet rs = stmt.executeQuery(query);
			VECTOR_OUT = new Vector<CursoBean>();
			while(rs.next()){			
				CursoBean OBJETO = new CursoBean();
				OBJETO.setIdCurso(rs.getString("id"));
				OBJETO.setNombreCurso(rs.getString("nombre"));
				OBJETO.setTipoCurso(rs.getString("tipo"));
				OBJETO.setSumillaCurso(rs.getString("sumilla"));
				VECTOR_OUT.add(OBJETO);
			}
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		return VECTOR_OUT;
		
	}
	
	public boolean agregarCurso(String codigo,String nombre,String tipo,String sumilla)throws Exception {
		
		boolean flag = false;
		try {
			Connection con = MySqlDAOFactory.obtenerConexion();
			Statement stmt = con.createStatement();
			
			//int e=Integer.parseInt(estado);
			int t=Integer.parseInt(tipo);
			int filas = 	stmt.executeUpdate("INSERT INTO t_curso " +
							"(id,nombre,tipo,estado,sumilla,estado_silabo) VALUES " +
							"('"+codigo+"','"+nombre+"',"+t+",1,'"+sumilla+"','0')");
			if(filas == 1){
				flag = true;
			}
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		return flag;
	}
	
	public boolean eliminarCurso(String id)throws Exception {
		
		return false;
	}
	
	public boolean modificarCurso(String id,String nombre,String tipo, String sumilla)throws Exception {
		try {
			Connection con = MySqlDAOFactory.obtenerConexion();
			Statement stmt = con.createStatement();
			int t=Integer.parseInt(tipo);
			System.out.print("codigo del curso ::::: MySql MC paso 1");
			stmt.executeUpdate("update t_curso set nombre='"+nombre+"',sumilla='"+sumilla+"',tipo="+t+" where id='"+id+"'");
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		return false;
	}
	
	public boolean validarCurso(String nombre)throws Exception {
		boolean flag=false;
		try {
			Connection con = MySqlDAOFactory.obtenerConexion();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("Select * from t_curso where nombre='"+nombre+"'");
			if(rs==null){
				System.out.print("rs = null");
				flag=true;
			}
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		return flag;
	}
}