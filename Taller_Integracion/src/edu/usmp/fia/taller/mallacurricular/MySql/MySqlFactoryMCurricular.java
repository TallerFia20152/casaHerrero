package edu.usmp.fia.taller.mallacurricular.MySql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import edu.usmp.fia.taller.mallacurricular.interfaces.DAOFactoryMCurricular;

import edu.usmp.fia.taller.common.bean.MallaCurricular.T_course;

import edu.usmp.fia.taller.common.dao.MySqlDAOFactory;

public class MySqlFactoryMCurricular implements DAOFactoryMCurricular<T_course> {

	@Override
	public List<T_course> findAll() {
		List<T_course> cursos = new ArrayList<T_course>();
		
		Connection con = MySqlDAOFactory.obtenerConexion();

		try {
			// String sql =
			// "SELECT * FROM bd_tallerproyectos.t_course where t_cycle_id=1";
			
			StringBuffer sentencia=new StringBuffer();
			
			sentencia.append("select pcd.id, pcd.curso_id, pcd.ciclo_id, pcd.curso_area_id, c.nombre from t_plan_curricular_detalle pcd "); 
			sentencia.append("inner join t_curso c on pcd.curso_id=c.id where ciclo_id='1'"); 
			
						
			PreparedStatement ps = con.prepareStatement(sentencia.toString());
			ResultSet rs = ps.executeQuery();
			T_course curso;
			while (rs.next()) {
				curso = new T_course();
				// curso.setId(rs.getInt("id"));
				// curso.setName(rs.getString("name"));
				// curso.setT_cycle_id(rs.getInt("t_cycle_id"));
				// curso.setT_course_id(rs.getInt("t_course_id"));
				curso.setId(rs.getInt("pcd.curso_id"));
				curso.setName(rs.getString("c.nombre"));
				curso.setT_cycle_id(rs.getInt("pcd.ciclo_id"));
				curso.setMencion(rs.getInt("pcd.curso_area_id"));
			//	curso.setT_course_id(rs.getInt("t_course_id"));
				cursos.add(curso);

			}

		} catch (Exception e) {
			System.out.print(e.getMessage());
		}

		return cursos;
	}

	@Override
	public List<T_course> findAl2() {
		List<T_course> cursos2 = new ArrayList<T_course>();
		Connection con = MySqlDAOFactory.obtenerConexion();

		try {
//			String sql = "SELECT * FROM bd_tallerproyectos.t_course  where t_cycle_id=2";
			StringBuffer sentencia=new StringBuffer();
			
			sentencia.append("select pcd.id, pcd.curso_id, pcd.ciclo_id, pcd.curso_area_id, c.nombre from t_plan_curricular_detalle pcd "); 
			sentencia.append("inner join t_curso c on pcd.curso_id=c.id where ciclo_id='2'"); 
			
						
			PreparedStatement ps = con.prepareStatement(sentencia.toString());
			ResultSet rs = ps.executeQuery();
			T_course curso;
			while (rs.next()) {
				curso = new T_course();
				// curso.setId(rs.getInt("id"));
				// curso.setName(rs.getString("name"));
				// curso.setT_cycle_id(rs.getInt("t_cycle_id"));
				// curso.setT_course_id(rs.getInt("t_course_id"));
				curso.setId(rs.getInt("pcd.curso_id"));
				curso.setName(rs.getString("c.nombre"));
				curso.setT_cycle_id(rs.getInt("pcd.ciclo_id"));
				curso.setMencion(rs.getInt("pcd.curso_area_id"));
			//	curso.setT_course_id(rs.getInt("t_course_id"));
				cursos2.add(curso);
			}

		} catch (Exception e) {
			System.out.print(e.getMessage());
		}

		return cursos2;
	}

	@Override
	public List<T_course> findAl3() {
		List<T_course> cursos3 = new ArrayList<T_course>();
		Connection con = MySqlDAOFactory.obtenerConexion();

		try {
//			String sql = "SELECT * FROM bd_tallerproyectos.t_course  where t_cycle_id=3";
			StringBuffer sentencia=new StringBuffer();
			sentencia.append("select pcd.id, pcd.curso_id, pcd.ciclo_id, pcd.curso_area_id, c.nombre from t_plan_curricular_detalle pcd "); 
			sentencia.append("inner join t_curso c on pcd.curso_id=c.id where ciclo_id='3'"); 
			
						
			PreparedStatement ps = con.prepareStatement(sentencia.toString());
			ResultSet rs = ps.executeQuery();
			T_course curso;
			while (rs.next()) {
				curso = new T_course();
				// curso.setId(rs.getInt("id"));
				// curso.setName(rs.getString("name"));
				// curso.setT_cycle_id(rs.getInt("t_cycle_id"));
				// curso.setT_course_id(rs.getInt("t_course_id"));
				curso.setId(rs.getInt("pcd.curso_id"));
				curso.setName(rs.getString("c.nombre"));
				curso.setT_cycle_id(rs.getInt("pcd.ciclo_id"));
				curso.setMencion(rs.getInt("pcd.curso_area_id"));
			//	curso.setT_course_id(rs.getInt("t_course_id"));
				
				cursos3.add(curso);

			}

		} catch (Exception e) {
			System.out.print(e.getMessage());
		}

		return cursos3;
	}

	@Override
	public List<T_course> findAl4() {
		List<T_course> cursos4 = new ArrayList<T_course>();
		Connection con = MySqlDAOFactory.obtenerConexion();

		try {
//			String sql = "SELECT * FROM bd_tallerproyectos.t_course  where t_cycle_id=4";
			StringBuffer sentencia=new StringBuffer();
			sentencia.append("select pcd.id, pcd.curso_id, pcd.ciclo_id, pcd.curso_area_id, c.nombre from t_plan_curricular_detalle pcd "); 
			sentencia.append("inner join t_curso c on pcd.curso_id=c.id where ciclo_id='4'"); 
			
						
			PreparedStatement ps = con.prepareStatement(sentencia.toString());
			ResultSet rs = ps.executeQuery();
			T_course curso;
			while (rs.next()) {
				curso = new T_course();
				// curso.setId(rs.getInt("id"));
				// curso.setName(rs.getString("name"));
				// curso.setT_cycle_id(rs.getInt("t_cycle_id"));
				// curso.setT_course_id(rs.getInt("t_course_id"));
				curso.setId(rs.getInt("pcd.curso_id"));
				curso.setName(rs.getString("c.nombre"));
				curso.setT_cycle_id(rs.getInt("pcd.ciclo_id"));
				curso.setMencion(rs.getInt("pcd.curso_area_id"));
			//	curso.setT_course_id(rs.getInt("t_course_id"));
				cursos4.add(curso);

			}

		} catch (Exception e) {
			System.out.print(e.getMessage());
		}

		return cursos4;
	}

	@Override
	public List<T_course> findAl5() {
		List<T_course> cursos5 = new ArrayList<T_course>();
		Connection con = MySqlDAOFactory.obtenerConexion();

		try {
//			String sql = "SELECT * FROM bd_tallerproyectos.t_course  where t_cycle_id=5";
			StringBuffer sentencia=new StringBuffer();
			sentencia.append("select pcd.id, pcd.curso_id, pcd.ciclo_id, pcd.curso_area_id, c.nombre from t_plan_curricular_detalle pcd "); 
			sentencia.append("inner join t_curso c on pcd.curso_id=c.id where ciclo_id='5'"); 
			
						
			PreparedStatement ps = con.prepareStatement(sentencia.toString());
			ResultSet rs = ps.executeQuery();
			T_course curso;
			while (rs.next()) {
				curso = new T_course();
				// curso.setId(rs.getInt("id"));
				// curso.setName(rs.getString("name"));
				// curso.setT_cycle_id(rs.getInt("t_cycle_id"));
				// curso.setT_course_id(rs.getInt("t_course_id"));
				curso.setId(rs.getInt("pcd.curso_id"));
				curso.setName(rs.getString("c.nombre"));
				curso.setT_cycle_id(rs.getInt("pcd.ciclo_id"));
				curso.setMencion(rs.getInt("pcd.curso_area_id"));
			//	curso.setT_course_id(rs.getInt("t_course_id"));
				cursos5.add(curso);

			}

		} catch (Exception e) {
			System.out.print(e.getMessage());
		}

		return cursos5;
	}

	@Override
	public List<T_course> findAl6() {
		List<T_course> cursos6 = new ArrayList<T_course>();
		Connection con = MySqlDAOFactory.obtenerConexion();

		try {
//			String sql = "SELECT * FROM bd_tallerproyectos.t_course  where t_cycle_id=6";
			StringBuffer sentencia=new StringBuffer();
			sentencia.append("select pcd.id, pcd.curso_id, pcd.ciclo_id, pcd.curso_area_id, c.nombre from t_plan_curricular_detalle pcd "); 
			sentencia.append("inner join t_curso c on pcd.curso_id=c.id where ciclo_id='6'"); 
			
						
			PreparedStatement ps = con.prepareStatement(sentencia.toString());
			ResultSet rs = ps.executeQuery();
			T_course curso;
			while (rs.next()) {
				curso = new T_course();
				// curso.setId(rs.getInt("id"));
				// curso.setName(rs.getString("name"));
				// curso.setT_cycle_id(rs.getInt("t_cycle_id"));
				// curso.setT_course_id(rs.getInt("t_course_id"));
				curso.setId(rs.getInt("pcd.curso_id"));
				curso.setName(rs.getString("c.nombre"));
				curso.setT_cycle_id(rs.getInt("pcd.ciclo_id"));
				curso.setMencion(rs.getInt("pcd.curso_area_id"));
			//	curso.setT_course_id(rs.getInt("t_course_id"));
				cursos6.add(curso);

			}

		} catch (Exception e) {
			System.out.print(e.getMessage());
		}

		return cursos6;
	}

	@Override
	public List<T_course> findAl7() {
		List<T_course> cursos7 = new ArrayList<T_course>();
		Connection con = MySqlDAOFactory.obtenerConexion();

		try {
//			String sql = "SELECT * FROM bd_tallerproyectos.t_course  where t_cycle_id=7";
			StringBuffer sentencia=new StringBuffer();
			sentencia.append("select pcd.id, pcd.curso_id, pcd.ciclo_id, pcd.curso_area_id, c.nombre from t_plan_curricular_detalle pcd "); 
			sentencia.append("inner join t_curso c on pcd.curso_id=c.id where ciclo_id='7'"); 
			
						
			PreparedStatement ps = con.prepareStatement(sentencia.toString());
			ResultSet rs = ps.executeQuery();
			T_course curso;
			while (rs.next()) {
				curso = new T_course();
				// curso.setId(rs.getInt("id"));
				// curso.setName(rs.getString("name"));
				// curso.setT_cycle_id(rs.getInt("t_cycle_id"));
				// curso.setT_course_id(rs.getInt("t_course_id"));
				curso.setId(rs.getInt("pcd.curso_id"));
				curso.setName(rs.getString("c.nombre"));
				curso.setT_cycle_id(rs.getInt("pcd.ciclo_id"));
				curso.setMencion(rs.getInt("pcd.curso_area_id"));
			//	curso.setT_course_id(rs.getInt("t_course_id"));
				cursos7.add(curso);

			}

		} catch (Exception e) {
			System.out.print(e.getMessage());
		}

		return cursos7;
	}

	@Override
	public List<T_course> findAl8() {
		List<T_course> cursos8 = new ArrayList<T_course>();
		Connection con = MySqlDAOFactory.obtenerConexion();

		try {
//			String sql = "SELECT * FROM bd_tallerproyectos.t_course  where t_cycle_id=8";
			StringBuffer sentencia=new StringBuffer();
			sentencia.append("select pcd.id, pcd.curso_id, pcd.ciclo_id, pcd.curso_area_id, c.nombre from t_plan_curricular_detalle pcd "); 
			sentencia.append("inner join t_curso c on pcd.curso_id=c.id where ciclo_id='8'"); 
			
						
			PreparedStatement ps = con.prepareStatement(sentencia.toString());
			ResultSet rs = ps.executeQuery();
			T_course curso;
			while (rs.next()) {
				curso = new T_course();
				// curso.setId(rs.getInt("id"));
				// curso.setName(rs.getString("name"));
				// curso.setT_cycle_id(rs.getInt("t_cycle_id"));
				// curso.setT_course_id(rs.getInt("t_course_id"));
				curso.setId(rs.getInt("pcd.curso_id"));
				curso.setName(rs.getString("c.nombre"));
				curso.setT_cycle_id(rs.getInt("pcd.ciclo_id"));
				curso.setMencion(rs.getInt("pcd.curso_area_id"));
			//	curso.setT_course_id(rs.getInt("t_course_id"));
				cursos8.add(curso);

			}

		} catch (Exception e) {
			System.out.print(e.getMessage());
		}

		return cursos8;
	}

	@Override
	public List<T_course> findAl9() {
		List<T_course> cursos9 = new ArrayList<T_course>();
		Connection con = MySqlDAOFactory.obtenerConexion();

		try {
//			String sql = "SELECT * FROM bd_tallerproyectos.t_course  where t_cycle_id=9";
			StringBuffer sentencia=new StringBuffer();
			sentencia.append("select pcd.id, pcd.curso_id, pcd.ciclo_id, pcd.curso_area_id, c.nombre from t_plan_curricular_detalle pcd "); 
			sentencia.append("inner join t_curso c on pcd.curso_id=c.id where ciclo_id='9'"); 
			
						
			PreparedStatement ps = con.prepareStatement(sentencia.toString());
			ResultSet rs = ps.executeQuery();
			T_course curso;
			while (rs.next()) {
				curso = new T_course();
				// curso.setId(rs.getInt("id"));
				// curso.setName(rs.getString("name"));
				// curso.setT_cycle_id(rs.getInt("t_cycle_id"));
				// curso.setT_course_id(rs.getInt("t_course_id"));
				curso.setId(rs.getInt("pcd.curso_id"));
				curso.setName(rs.getString("c.nombre"));
				curso.setT_cycle_id(rs.getInt("pcd.ciclo_id"));
				curso.setMencion(rs.getInt("pcd.curso_area_id"));
			//	curso.setT_course_id(rs.getInt("t_course_id"));
				cursos9.add(curso);

			}

		} catch (Exception e) {
			System.out.print(e.getMessage());
		}

		return cursos9;
	}

	@Override
	public List<T_course> findAl10() {
		List<T_course> cursos10 = new ArrayList<T_course>();
		Connection con = MySqlDAOFactory.obtenerConexion();

		try {
//			String sql = "SELECT * FROM bd_tallerproyectos.t_course  where t_cycle_id=10";
			StringBuffer sentencia=new StringBuffer();
			sentencia.append("select pcd.id, pcd.curso_id, pcd.ciclo_id, pcd.curso_area_id, c.nombre from t_plan_curricular_detalle pcd "); 
			sentencia.append("inner join t_curso c on pcd.curso_id=c.id where ciclo_id='10'"); 
			
						
			PreparedStatement ps = con.prepareStatement(sentencia.toString());
			ResultSet rs = ps.executeQuery();
			T_course curso;
			while (rs.next()) {
				curso = new T_course();
				// curso.setId(rs.getInt("id"));
				// curso.setName(rs.getString("name"));
				// curso.setT_cycle_id(rs.getInt("t_cycle_id"));
				// curso.setT_course_id(rs.getInt("t_course_id"));
				curso.setId(rs.getInt("pcd.curso_id"));
				curso.setName(rs.getString("c.nombre"));
				curso.setT_cycle_id(rs.getInt("pcd.ciclo_id"));
				curso.setMencion(rs.getInt("pcd.curso_area_id"));
			//	curso.setT_course_id(rs.getInt("t_course_id"));
				cursos10.add(curso);

			}

		} catch (Exception e) {
			System.out.print(e.getMessage());
		}

		return cursos10;
	}
	
//	/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*MENSION SI /*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*
//	/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*MENSION SI /*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*
	
//	/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*MENSION SI /*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*
//	/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*MENSION SI /*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*
//	/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*MENSION SI /*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*
//	/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*MENSION SI /*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*//	/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*MENSION SI /*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*
//	/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*MENSION SI /*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*
//	/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*MENSION SI /*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*
	
//	/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*MENSION SI /*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*
//	/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*MENSION SI /*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*
	
//	/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*MENSION SI /*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*
//	/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*MENSION SI /*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*
//	/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*MENSION SI /*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*
		
	
	
	
	
	
	
	
	public List<T_course> findAl1SI() {
		List<T_course> cursos = new ArrayList<T_course>();
		Connection con = MySqlDAOFactory.obtenerConexion();

		try {
			// String sql =
			// "SELECT * FROM bd_tallerproyectos.t_course where t_cycle_id=1";
			
			StringBuffer sentencia=new StringBuffer();
			
			sentencia.append("select pcd.id, pcd.curso_id, pcd.ciclo_id, pcd.curso_area_id, c.nombre from t_plan_curricular_detalle pcd "); 
			sentencia.append("inner join t_curso c on pcd.curso_id=c.id where ciclo_id='1'"); 
			
						
			PreparedStatement ps = con.prepareStatement(sentencia.toString());
			ResultSet rs = ps.executeQuery();
			T_course curso;
			while (rs.next()) {
				curso = new T_course();
				// curso.setId(rs.getInt("id"));
				// curso.setName(rs.getString("name"));
				// curso.setT_cycle_id(rs.getInt("t_cycle_id"));
				// curso.setT_course_id(rs.getInt("t_course_id"));
				curso.setId(rs.getInt("pcd.curso_id"));
				curso.setName(rs.getString("c.nombre"));
				curso.setT_cycle_id(rs.getInt("pcd.ciclo_id"));
				curso.setMencion(rs.getInt("pcd.curso_area_id"));
			//	curso.setT_course_id(rs.getInt("t_course_id"));
				cursos.add(curso);

			}

		} catch (Exception e) {
			System.out.print(e.getMessage());
		}

		return cursos;
	}

	@Override
	public List<T_course> findAl2SI() {
		List<T_course> cursos2 = new ArrayList<T_course>();
		Connection con = MySqlDAOFactory.obtenerConexion();

		try {
//			String sql = "SELECT * FROM bd_tallerproyectos.t_course  where t_cycle_id=2";
			StringBuffer sentencia=new StringBuffer();
			

			sentencia.append("select pcd.id, pcd.curso_id, pcd.ciclo_id, pcd.curso_area_id, c.nombre from t_plan_curricular_detalle pcd "); 
			sentencia.append("inner join t_curso c on pcd.curso_id=c.id where ciclo_id='2'"); 
			
						
			PreparedStatement ps = con.prepareStatement(sentencia.toString());
			ResultSet rs = ps.executeQuery();
			T_course curso;
			while (rs.next()) {
				curso = new T_course();
				// curso.setId(rs.getInt("id"));
				// curso.setName(rs.getString("name"));
				// curso.setT_cycle_id(rs.getInt("t_cycle_id"));
				// curso.setT_course_id(rs.getInt("t_course_id"));
				curso.setId(rs.getInt("pcd.curso_id"));
				curso.setName(rs.getString("c.nombre"));
				curso.setT_cycle_id(rs.getInt("pcd.ciclo_id"));
				curso.setMencion(rs.getInt("pcd.curso_area_id"));
			//	curso.setT_course_id(rs.getInt("t_course_id"));
				cursos2.add(curso);

			}

		} catch (Exception e) {
			System.out.print(e.getMessage());
		}

		return cursos2;
	}

	@Override
	public List<T_course> findAl3SI() {
		List<T_course> cursos3 = new ArrayList<T_course>();
		Connection con = MySqlDAOFactory.obtenerConexion();

		try {
//			String sql = "SELECT * FROM bd_tallerproyectos.t_course  where t_cycle_id=3";
			StringBuffer sentencia=new StringBuffer();

			sentencia.append("select pcd.id, pcd.curso_id, pcd.ciclo_id, pcd.curso_area_id, c.nombre from t_plan_curricular_detalle pcd "); 
			sentencia.append("inner join t_curso c on pcd.curso_id=c.id where ciclo_id='3'"); 
			
						
			PreparedStatement ps = con.prepareStatement(sentencia.toString());
			ResultSet rs = ps.executeQuery();
			T_course curso;
			while (rs.next()) {
				curso = new T_course();
				// curso.setId(rs.getInt("id"));
				// curso.setName(rs.getString("name"));
				// curso.setT_cycle_id(rs.getInt("t_cycle_id"));
				// curso.setT_course_id(rs.getInt("t_course_id"));
				curso.setId(rs.getInt("pcd.curso_id"));
				curso.setName(rs.getString("c.nombre"));
				curso.setT_cycle_id(rs.getInt("pcd.ciclo_id"));
				curso.setMencion(rs.getInt("pcd.curso_area_id"));
			//	curso.setT_course_id(rs.getInt("t_course_id"));
				cursos3.add(curso);

			}

		} catch (Exception e) {
			System.out.print(e.getMessage());
		}

		return cursos3;
	}

	@Override
	public List<T_course> findAl4SI() {
		List<T_course> cursos4 = new ArrayList<T_course>();
		Connection con = MySqlDAOFactory.obtenerConexion();

		try {
//			String sql = "SELECT * FROM bd_tallerproyectos.t_course  where t_cycle_id=4";
			StringBuffer sentencia=new StringBuffer();

			sentencia.append("select pcd.id, pcd.curso_id, pcd.ciclo_id, pcd.curso_area_id, c.nombre from t_plan_curricular_detalle pcd "); 
			sentencia.append("inner join t_curso c on pcd.curso_id=c.id where ciclo_id='4'"); 
			
						
			PreparedStatement ps = con.prepareStatement(sentencia.toString());
			ResultSet rs = ps.executeQuery();
			T_course curso;
			while (rs.next()) {
				curso = new T_course();
				// curso.setId(rs.getInt("id"));
				// curso.setName(rs.getString("name"));
				// curso.setT_cycle_id(rs.getInt("t_cycle_id"));
				// curso.setT_course_id(rs.getInt("t_course_id"));
				curso.setId(rs.getInt("pcd.curso_id"));
				curso.setName(rs.getString("c.nombre"));
				curso.setT_cycle_id(rs.getInt("pcd.ciclo_id"));
				curso.setMencion(rs.getInt("pcd.curso_area_id"));
			//	curso.setT_course_id(rs.getInt("t_course_id"));
				cursos4.add(curso);

			}

		} catch (Exception e) {
			System.out.print(e.getMessage());
		}

		return cursos4;
	}

	@Override
	public List<T_course> findAl5SI() {
		List<T_course> cursos5 = new ArrayList<T_course>();
		Connection con = MySqlDAOFactory.obtenerConexion();

		try {
//			String sql = "SELECT * FROM bd_tallerproyectos.t_course  where t_cycle_id=5";
			StringBuffer sentencia=new StringBuffer();

			sentencia.append("select pcd.id, pcd.curso_id, pcd.ciclo_id, pcd.curso_area_id, c.nombre from t_plan_curricular_detalle pcd "); 
			sentencia.append("inner join t_curso c on pcd.curso_id=c.id where ciclo_id='5'"); 
			
						
			PreparedStatement ps = con.prepareStatement(sentencia.toString());
			ResultSet rs = ps.executeQuery();
			T_course curso;
			while (rs.next()) {
				curso = new T_course();
				// curso.setId(rs.getInt("id"));
				// curso.setName(rs.getString("name"));
				// curso.setT_cycle_id(rs.getInt("t_cycle_id"));
				// curso.setT_course_id(rs.getInt("t_course_id"));
				curso.setId(rs.getInt("pcd.curso_id"));
				curso.setName(rs.getString("c.nombre"));
				curso.setT_cycle_id(rs.getInt("pcd.ciclo_id"));
				curso.setMencion(rs.getInt("pcd.curso_area_id"));
			//	curso.setT_course_id(rs.getInt("t_course_id"));
				cursos5.add(curso);

			}

		} catch (Exception e) {
			System.out.print(e.getMessage());
		}

		return cursos5;
	}

	@Override
	public List<T_course> findAl6SI() {
		List<T_course> cursos6 = new ArrayList<T_course>();
		Connection con = MySqlDAOFactory.obtenerConexion();

		try {
//			String sql = "SELECT * FROM bd_tallerproyectos.t_course  where t_cycle_id=6";
			StringBuffer sentencia=new StringBuffer();

			sentencia.append("select pcd.id, pcd.curso_id, pcd.ciclo_id, pcd.curso_area_id, c.nombre from t_plan_curricular_detalle pcd "); 
			sentencia.append("inner join t_curso c on pcd.curso_id=c.id where ciclo_id='6'"); 
			
						
			PreparedStatement ps = con.prepareStatement(sentencia.toString());
			ResultSet rs = ps.executeQuery();
			T_course curso;
			while (rs.next()) {
				curso = new T_course();
				// curso.setId(rs.getInt("id"));
				// curso.setName(rs.getString("name"));
				// curso.setT_cycle_id(rs.getInt("t_cycle_id"));
				// curso.setT_course_id(rs.getInt("t_course_id"));
				curso.setId(rs.getInt("pcd.curso_id"));
				curso.setName(rs.getString("c.nombre"));
				curso.setT_cycle_id(rs.getInt("pcd.ciclo_id"));
				curso.setMencion(rs.getInt("pcd.curso_area_id"));
			//	curso.setT_course_id(rs.getInt("t_course_id"));
				cursos6.add(curso);

			}

		} catch (Exception e) {
			System.out.print(e.getMessage());
		}

		return cursos6;
	}

	@Override
	public List<T_course> findAl7SI() {
		List<T_course> cursos7 = new ArrayList<T_course>();
		Connection con = MySqlDAOFactory.obtenerConexion();

		try {
//			String sql = "SELECT * FROM bd_tallerproyectos.t_course  where t_cycle_id=7";
			StringBuffer sentencia=new StringBuffer();

			sentencia.append("select pcd.id, pcd.curso_id, pcd.ciclo_id, pcd.curso_area_id, c.nombre from t_plan_curricular_detalle pcd "); 
			sentencia.append("inner join t_curso c on pcd.curso_id=c.id where ciclo_id='7'"); 
			
						
			PreparedStatement ps = con.prepareStatement(sentencia.toString());
			ResultSet rs = ps.executeQuery();
			T_course curso;
			while (rs.next()) {
				curso = new T_course();
				// curso.setId(rs.getInt("id"));
				// curso.setName(rs.getString("name"));
				// curso.setT_cycle_id(rs.getInt("t_cycle_id"));
				// curso.setT_course_id(rs.getInt("t_course_id"));
				curso.setId(rs.getInt("pcd.curso_id"));
				curso.setName(rs.getString("c.nombre"));
				curso.setT_cycle_id(rs.getInt("pcd.ciclo_id"));
				curso.setMencion(rs.getInt("pcd.curso_area_id"));
			//	curso.setT_course_id(rs.getInt("t_course_id"));
				cursos7.add(curso);

			}

		} catch (Exception e) {
			System.out.print(e.getMessage());
		}

		return cursos7;
	}

	@Override
	public List<T_course> findAl8SI() {
		List<T_course> cursos8 = new ArrayList<T_course>();
		Connection con = MySqlDAOFactory.obtenerConexion();

		try {
//			String sql = "SELECT * FROM bd_tallerproyectos.t_course  where t_cycle_id=8";
			StringBuffer sentencia=new StringBuffer();

			sentencia.append("select pcd.id, pcd.curso_id, pcd.ciclo_id, pcd.curso_area_id, c.nombre from t_plan_curricular_detalle pcd "); 
			sentencia.append("inner join t_curso c on pcd.curso_id=c.id where ciclo_id='8'"); 
			
						
			PreparedStatement ps = con.prepareStatement(sentencia.toString());
			ResultSet rs = ps.executeQuery();
			T_course curso;
			while (rs.next()) {
				curso = new T_course();
				// curso.setId(rs.getInt("id"));
				// curso.setName(rs.getString("name"));
				// curso.setT_cycle_id(rs.getInt("t_cycle_id"));
				// curso.setT_course_id(rs.getInt("t_course_id"));
				curso.setId(rs.getInt("pcd.curso_id"));
				curso.setName(rs.getString("c.nombre"));
				curso.setT_cycle_id(rs.getInt("pcd.ciclo_id"));
				curso.setMencion(rs.getInt("pcd.curso_area_id"));
			//	curso.setT_course_id(rs.getInt("t_course_id"));
				cursos8.add(curso);

			}

		} catch (Exception e) {
			System.out.print(e.getMessage());
		}

		return cursos8;
	}

	@Override
	public List<T_course> findAl9SI() {
		List<T_course> cursos9 = new ArrayList<T_course>();
		Connection con = MySqlDAOFactory.obtenerConexion();

		try {
//			String sql = "SELECT * FROM bd_tallerproyectos.t_course  where t_cycle_id=9";
			StringBuffer sentencia=new StringBuffer();

			sentencia.append("select pcd.id, pcd.curso_id, pcd.ciclo_id, pcd.curso_area_id, c.nombre from t_plan_curricular_detalle pcd "); 
			sentencia.append("inner join t_curso c on pcd.curso_id=c.id where ciclo_id='9'"); 
			
						
			PreparedStatement ps = con.prepareStatement(sentencia.toString());
			ResultSet rs = ps.executeQuery();
			T_course curso;
			while (rs.next()) {
				curso = new T_course();
				// curso.setId(rs.getInt("id"));
				// curso.setName(rs.getString("name"));
				// curso.setT_cycle_id(rs.getInt("t_cycle_id"));
				// curso.setT_course_id(rs.getInt("t_course_id"));
				curso.setId(rs.getInt("pcd.curso_id"));
				curso.setName(rs.getString("c.nombre"));
				curso.setT_cycle_id(rs.getInt("pcd.ciclo_id"));
				curso.setMencion(rs.getInt("pcd.curso_area_id"));
			//	curso.setT_course_id(rs.getInt("t_course_id"));
				cursos9.add(curso);

			}

		} catch (Exception e) {
			System.out.print(e.getMessage());
		}

		return cursos9;
	}

	@Override
	public List<T_course> findAl10SI() {
		List<T_course> cursos10 = new ArrayList<T_course>();
		Connection con = MySqlDAOFactory.obtenerConexion();

		try {
//			String sql = "SELECT * FROM bd_tallerproyectos.t_course  where t_cycle_id=10";
			StringBuffer sentencia=new StringBuffer();

			sentencia.append("select pcd.id, pcd.curso_id, pcd.ciclo_id, pcd.curso_area_id, c.nombre from t_plan_curricular_detalle pcd "); 
			sentencia.append("inner join t_curso c on pcd.curso_id=c.id where ciclo_id='10'"); 
			
						
			PreparedStatement ps = con.prepareStatement(sentencia.toString());
			ResultSet rs = ps.executeQuery();
			T_course curso;
			while (rs.next()) {
				curso = new T_course();
				// curso.setId(rs.getInt("id"));
				// curso.setName(rs.getString("name"));
				// curso.setT_cycle_id(rs.getInt("t_cycle_id"));
				// curso.setT_course_id(rs.getInt("t_course_id"));
				curso.setId(rs.getInt("pcd.curso_id"));
				curso.setName(rs.getString("c.nombre"));
				curso.setT_cycle_id(rs.getInt("pcd.ciclo_id"));
				curso.setMencion(rs.getInt("pcd.curso_area_id"));
			//	curso.setT_course_id(rs.getInt("t_course_id"));
				cursos10.add(curso);

			}

		} catch (Exception e) {
			System.out.print(e.getMessage());
		}

		return cursos10;
	}
	
	
	
	public List<T_course> findAlSI() {
		List<T_course> cursos = new ArrayList<T_course>();
		Connection con = MySqlDAOFactory.obtenerConexion();

		try {
			// String sql =
			// "SELECT * FROM bd_tallerproyectos.t_course where t_cycle_id=1";
			
			StringBuffer sentencia=new StringBuffer();
			
			
sentencia.append("select c.id, c.nombre, cm.mencion_id from t_curso c inner join  t_curso_mencion cm on c.id=cm.curso_id where mencion_id='1'");
			
			PreparedStatement ps = con.prepareStatement(sentencia.toString());
			ResultSet rs = ps.executeQuery();
			T_course curso;
			while (rs.next()) {
				curso = new T_course();
				// curso.setId(rs.getInt("id"));
				// curso.setName(rs.getString("name"));
				// curso.setT_cycle_id(rs.getInt("t_cycle_id"));
				// curso.setT_course_id(rs.getInt("t_course_id"));
				curso.setId(rs.getInt("c.id"));
				curso.setName(rs.getString("c.nombre"));
				//curso.setT_cycle_id(rs.getInt("pcd.ciclo_id"));
				curso.setMencion(rs.getInt("cm.mencion_id"));
			//	curso.setT_course_id(rs.getInt("t_course_id"));
				cursos.add(curso);
				
				if (curso.getId() == 90861) {
					curso.setLeft("681.641px");	
					curso.setTop("453.5px");
				}
				if (curso.getId() == 90085) {
					curso.setLeft("813.969px");	
					curso.setTop("385.5px");
				}
				if (curso.getId() == 91119) {
					curso.setLeft("813.969px");	
					curso.setTop("453.5px");
				}
				if (curso.getId() == 90548) {
					curso.setLeft("946.297px");	
					curso.setTop("317.5px");
				}
				if (curso.getId() == 90116) {
					curso.setLeft("946.297px");	
					curso.setTop("385.5px");
				}
				if (curso.getId() == 90934) {
					curso.setLeft("946.297px");	
					curso.setTop("453.5px");
				}
				if (curso.getId() == 90670) {
					curso.setLeft("1069.95px");	
					curso.setTop("249.5px");
				}
				if (curso.getId() == 91122) {
					curso.setLeft("1069.95px");
					curso.setTop("317.5px");
				}
				if (curso.getId() == 90088) {
					curso.setLeft("1069.95px");	
					curso.setTop("385.5px");
				}
				if (curso.getId() == 90933) {
					curso.setLeft("1194.61px");	
					curso.setTop("249.5px");
				}
			}

		} catch (Exception e) {
			System.out.print(e.getMessage());
		}

		return cursos;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*MENSION SI /*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*
	
	
	
	
//	/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*MENSION IS /*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*
//	/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*MENSION IS /*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*
	
//	/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*MENSION IS /*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*
//	/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*MENSION IS /*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*
//	/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*MENSION IS /*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*
//	/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*MENSION IS /*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*//	/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*MENSION SI /*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*
//	/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*MENSION IS /*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*
//	/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*MENSION IS /*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*

//	/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*MENSION IS /*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*
//	/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*MENSION IS /*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*
	
//	/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*MENSION IS /*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*
//	/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*MENSION IS /*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*
//	/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*MENSION IS /*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*
		
	
	
	
	
	
	

	
	
	
	public List<T_course> findAl1IS() {
		List<T_course> cursos = new ArrayList<T_course>();
		Connection con = MySqlDAOFactory.obtenerConexion();

		try {
			// String sql =
			// "SELECT * FROM bd_tallerproyectos.t_course where t_cycle_id=1";
			
			StringBuffer sentencia=new StringBuffer();
			
			sentencia.append("select pcd.id, pcd.curso_id, pcd.ciclo_id, pcd.curso_area_id, c.nombre from t_plan_curricular_detalle pcd "); 
			sentencia.append("inner join t_curso c on pcd.curso_id=c.id where ciclo_id='1'"); 
			
						
			PreparedStatement ps = con.prepareStatement(sentencia.toString());
			ResultSet rs = ps.executeQuery();
			T_course curso;
			while (rs.next()) {
				curso = new T_course();
				// curso.setId(rs.getInt("id"));
				// curso.setName(rs.getString("name"));
				// curso.setT_cycle_id(rs.getInt("t_cycle_id"));
				// curso.setT_course_id(rs.getInt("t_course_id"));
				curso.setId(rs.getInt("pcd.curso_id"));
				curso.setName(rs.getString("c.nombre"));
				curso.setT_cycle_id(rs.getInt("pcd.ciclo_id"));
				curso.setMencion(rs.getInt("pcd.curso_area_id"));
			//	curso.setT_course_id(rs.getInt("t_course_id"));
				cursos.add(curso);

			}

		} catch (Exception e) {
			System.out.print(e.getMessage());
		}

		return cursos;
	}

	@Override
	public List<T_course> findAl2IS() {
		List<T_course> cursos2 = new ArrayList<T_course>();
		Connection con = MySqlDAOFactory.obtenerConexion();

		try {
//			String sql = "SELECT * FROM bd_tallerproyectos.t_course  where t_cycle_id=2";
			StringBuffer sentencia=new StringBuffer();
			

			sentencia.append("select pcd.id, pcd.curso_id, pcd.ciclo_id, pcd.curso_area_id, c.nombre from t_plan_curricular_detalle pcd "); 
			sentencia.append("inner join t_curso c on pcd.curso_id=c.id where ciclo_id='2'"); 
			
						
			PreparedStatement ps = con.prepareStatement(sentencia.toString());
			ResultSet rs = ps.executeQuery();
			T_course curso;
			while (rs.next()) {
				curso = new T_course();
				// curso.setId(rs.getInt("id"));
				// curso.setName(rs.getString("name"));
				// curso.setT_cycle_id(rs.getInt("t_cycle_id"));
				// curso.setT_course_id(rs.getInt("t_course_id"));
				curso.setId(rs.getInt("pcd.curso_id"));
				curso.setName(rs.getString("c.nombre"));
				curso.setT_cycle_id(rs.getInt("pcd.ciclo_id"));
				curso.setMencion(rs.getInt("pcd.curso_area_id"));
			//	curso.setT_course_id(rs.getInt("t_course_id"));
				cursos2.add(curso);

			}

		} catch (Exception e) {
			System.out.print(e.getMessage());
		}

		return cursos2;
	}

	@Override
	public List<T_course> findAl3IS() {
		List<T_course> cursos3 = new ArrayList<T_course>();
		Connection con = MySqlDAOFactory.obtenerConexion();

		try {
//			String sql = "SELECT * FROM bd_tallerproyectos.t_course  where t_cycle_id=3";
			StringBuffer sentencia=new StringBuffer();

			sentencia.append("select pcd.id, pcd.curso_id, pcd.ciclo_id, pcd.curso_area_id, c.nombre from t_plan_curricular_detalle pcd "); 
			sentencia.append("inner join t_curso c on pcd.curso_id=c.id where ciclo_id='3'"); 
			
						
			PreparedStatement ps = con.prepareStatement(sentencia.toString());
			ResultSet rs = ps.executeQuery();
			T_course curso;
			while (rs.next()) {
				curso = new T_course();
				// curso.setId(rs.getInt("id"));
				// curso.setName(rs.getString("name"));
				// curso.setT_cycle_id(rs.getInt("t_cycle_id"));
				// curso.setT_course_id(rs.getInt("t_course_id"));
				curso.setId(rs.getInt("pcd.curso_id"));
				curso.setName(rs.getString("c.nombre"));
				curso.setT_cycle_id(rs.getInt("pcd.ciclo_id"));
				curso.setMencion(rs.getInt("pcd.curso_area_id"));
			//	curso.setT_course_id(rs.getInt("t_course_id"));
				cursos3.add(curso);

			}

		} catch (Exception e) {
			System.out.print(e.getMessage());
		}

		return cursos3;
	}

	@Override
	public List<T_course> findAl4IS() {
		List<T_course> cursos4 = new ArrayList<T_course>();
		Connection con = MySqlDAOFactory.obtenerConexion();

		try {
//			String sql = "SELECT * FROM bd_tallerproyectos.t_course  where t_cycle_id=4";
			StringBuffer sentencia=new StringBuffer();

			sentencia.append("select pcd.id, pcd.curso_id, pcd.ciclo_id, pcd.curso_area_id, c.nombre from t_plan_curricular_detalle pcd "); 
			sentencia.append("inner join t_curso c on pcd.curso_id=c.id where ciclo_id='4'"); 
			
						
			PreparedStatement ps = con.prepareStatement(sentencia.toString());
			ResultSet rs = ps.executeQuery();
			T_course curso;
			while (rs.next()) {
				curso = new T_course();
				// curso.setId(rs.getInt("id"));
				// curso.setName(rs.getString("name"));
				// curso.setT_cycle_id(rs.getInt("t_cycle_id"));
				// curso.setT_course_id(rs.getInt("t_course_id"));
				curso.setId(rs.getInt("pcd.curso_id"));
				curso.setName(rs.getString("c.nombre"));
				curso.setT_cycle_id(rs.getInt("pcd.ciclo_id"));
				curso.setMencion(rs.getInt("pcd.curso_area_id"));
			//	curso.setT_course_id(rs.getInt("t_course_id"));
				cursos4.add(curso);

			}

		} catch (Exception e) {
			System.out.print(e.getMessage());
		}

		return cursos4;
	}

	@Override
	public List<T_course> findAl5IS() {
		List<T_course> cursos5 = new ArrayList<T_course>();
		Connection con = MySqlDAOFactory.obtenerConexion();

		try {
//			String sql = "SELECT * FROM bd_tallerproyectos.t_course  where t_cycle_id=5";
			StringBuffer sentencia=new StringBuffer();

			sentencia.append("select pcd.id, pcd.curso_id, pcd.ciclo_id, pcd.curso_area_id, c.nombre from t_plan_curricular_detalle pcd "); 
			sentencia.append("inner join t_curso c on pcd.curso_id=c.id where ciclo_id='5'"); 
			
						
			PreparedStatement ps = con.prepareStatement(sentencia.toString());
			ResultSet rs = ps.executeQuery();
			T_course curso;
			while (rs.next()) {
				curso = new T_course();
				// curso.setId(rs.getInt("id"));
				// curso.setName(rs.getString("name"));
				// curso.setT_cycle_id(rs.getInt("t_cycle_id"));
				// curso.setT_course_id(rs.getInt("t_course_id"));
				curso.setId(rs.getInt("pcd.curso_id"));
				curso.setName(rs.getString("c.nombre"));
				curso.setT_cycle_id(rs.getInt("pcd.ciclo_id"));
				curso.setMencion(rs.getInt("pcd.curso_area_id"));
			//	curso.setT_course_id(rs.getInt("t_course_id"));
				cursos5.add(curso);

			}

		} catch (Exception e) {
			System.out.print(e.getMessage());
		}

		return cursos5;
	}

	@Override
	public List<T_course> findAl6IS() {
		List<T_course> cursos6 = new ArrayList<T_course>();
		Connection con = MySqlDAOFactory.obtenerConexion();

		try {
//			String sql = "SELECT * FROM bd_tallerproyectos.t_course  where t_cycle_id=6";
			StringBuffer sentencia=new StringBuffer();

			sentencia.append("select pcd.id, pcd.curso_id, pcd.ciclo_id, pcd.curso_area_id, c.nombre from t_plan_curricular_detalle pcd "); 
			sentencia.append("inner join t_curso c on pcd.curso_id=c.id where ciclo_id='6'"); 
			
						
			PreparedStatement ps = con.prepareStatement(sentencia.toString());
			ResultSet rs = ps.executeQuery();
			T_course curso;
			while (rs.next()) {
				curso = new T_course();
				// curso.setId(rs.getInt("id"));
				// curso.setName(rs.getString("name"));
				// curso.setT_cycle_id(rs.getInt("t_cycle_id"));
				// curso.setT_course_id(rs.getInt("t_course_id"));
				curso.setId(rs.getInt("pcd.curso_id"));
				curso.setName(rs.getString("c.nombre"));
				curso.setT_cycle_id(rs.getInt("pcd.ciclo_id"));
				curso.setMencion(rs.getInt("pcd.curso_area_id"));
			//	curso.setT_course_id(rs.getInt("t_course_id"));
				cursos6.add(curso);

			}

		} catch (Exception e) {
			System.out.print(e.getMessage());
		}

		return cursos6;
	}

	@Override
	public List<T_course> findAl7IS() {
		List<T_course> cursos7 = new ArrayList<T_course>();
		Connection con = MySqlDAOFactory.obtenerConexion();

		try {
//			String sql = "SELECT * FROM bd_tallerproyectos.t_course  where t_cycle_id=7";
			StringBuffer sentencia=new StringBuffer();

			sentencia.append("select pcd.id, pcd.curso_id, pcd.ciclo_id, pcd.curso_area_id, c.nombre from t_plan_curricular_detalle pcd "); 
			sentencia.append("inner join t_curso c on pcd.curso_id=c.id where ciclo_id='7'"); 
			
						
			PreparedStatement ps = con.prepareStatement(sentencia.toString());
			ResultSet rs = ps.executeQuery();
			T_course curso;
			while (rs.next()) {
				curso = new T_course();
				// curso.setId(rs.getInt("id"));
				// curso.setName(rs.getString("name"));
				// curso.setT_cycle_id(rs.getInt("t_cycle_id"));
				// curso.setT_course_id(rs.getInt("t_course_id"));
				curso.setId(rs.getInt("pcd.curso_id"));
				curso.setName(rs.getString("c.nombre"));
				curso.setT_cycle_id(rs.getInt("pcd.ciclo_id"));
				curso.setMencion(rs.getInt("pcd.curso_area_id"));
			//	curso.setT_course_id(rs.getInt("t_course_id"));
				cursos7.add(curso);

			}

		} catch (Exception e) {
			System.out.print(e.getMessage());
		}

		return cursos7;
	}

	@Override
	public List<T_course> findAl8IS() {
		List<T_course> cursos8 = new ArrayList<T_course>();
		Connection con = MySqlDAOFactory.obtenerConexion();

		try {
//			String sql = "SELECT * FROM bd_tallerproyectos.t_course  where t_cycle_id=8";
			StringBuffer sentencia=new StringBuffer();

			sentencia.append("select pcd.id, pcd.curso_id, pcd.ciclo_id, pcd.curso_area_id, c.nombre from t_plan_curricular_detalle pcd "); 
			sentencia.append("inner join t_curso c on pcd.curso_id=c.id where ciclo_id='8'"); 
			
						
			PreparedStatement ps = con.prepareStatement(sentencia.toString());
			ResultSet rs = ps.executeQuery();
			T_course curso;
			while (rs.next()) {
				curso = new T_course();
				// curso.setId(rs.getInt("id"));
				// curso.setName(rs.getString("name"));
				// curso.setT_cycle_id(rs.getInt("t_cycle_id"));
				// curso.setT_course_id(rs.getInt("t_course_id"));
				curso.setId(rs.getInt("pcd.curso_id"));
				curso.setName(rs.getString("c.nombre"));
				curso.setT_cycle_id(rs.getInt("pcd.ciclo_id"));
				curso.setMencion(rs.getInt("pcd.curso_area_id"));
			//	curso.setT_course_id(rs.getInt("t_course_id"));
				cursos8.add(curso);

			}

		} catch (Exception e) {
			System.out.print(e.getMessage());
		}

		return cursos8;
	}

	@Override
	public List<T_course> findAl9IS() {
		List<T_course> cursos9 = new ArrayList<T_course>();
		Connection con = MySqlDAOFactory.obtenerConexion();

		try {
//			String sql = "SELECT * FROM bd_tallerproyectos.t_course  where t_cycle_id=9";
			StringBuffer sentencia=new StringBuffer();

			sentencia.append("select pcd.id, pcd.curso_id, pcd.ciclo_id, pcd.curso_area_id, c.nombre from t_plan_curricular_detalle pcd "); 
			sentencia.append("inner join t_curso c on pcd.curso_id=c.id where ciclo_id='9'"); 
			
						
			PreparedStatement ps = con.prepareStatement(sentencia.toString());
			ResultSet rs = ps.executeQuery();
			T_course curso;
			while (rs.next()) {
				curso = new T_course();
				// curso.setId(rs.getInt("id"));
				// curso.setName(rs.getString("name"));
				// curso.setT_cycle_id(rs.getInt("t_cycle_id"));
				// curso.setT_course_id(rs.getInt("t_course_id"));
				curso.setId(rs.getInt("pcd.curso_id"));
				curso.setName(rs.getString("c.nombre"));
				curso.setT_cycle_id(rs.getInt("pcd.ciclo_id"));
				curso.setMencion(rs.getInt("pcd.curso_area_id"));
			//	curso.setT_course_id(rs.getInt("t_course_id"));
				cursos9.add(curso);

			}

		} catch (Exception e) {
			System.out.print(e.getMessage());
		}

		return cursos9;
	}

	@Override
	public List<T_course> findAl10IS() {
		List<T_course> cursos10 = new ArrayList<T_course>();
		Connection con = MySqlDAOFactory.obtenerConexion();

		try {
//			String sql = "SELECT * FROM bd_tallerproyectos.t_course  where t_cycle_id=10";
			StringBuffer sentencia=new StringBuffer();

			sentencia.append("select pcd.id, pcd.curso_id, pcd.ciclo_id, pcd.curso_area_id, c.nombre from t_plan_curricular_detalle pcd "); 
			sentencia.append("inner join t_curso c on pcd.curso_id=c.id where ciclo_id='10'"); 
			
						
			PreparedStatement ps = con.prepareStatement(sentencia.toString());
			ResultSet rs = ps.executeQuery();
			T_course curso;
			while (rs.next()) {
				curso = new T_course();
				// curso.setId(rs.getInt("id"));
				// curso.setName(rs.getString("name"));
				// curso.setT_cycle_id(rs.getInt("t_cycle_id"));
				// curso.setT_course_id(rs.getInt("t_course_id"));
				curso.setId(rs.getInt("pcd.curso_id"));
				curso.setName(rs.getString("c.nombre"));
				curso.setT_cycle_id(rs.getInt("pcd.ciclo_id"));
				curso.setMencion(rs.getInt("pcd.curso_area_id"));
			//	curso.setT_course_id(rs.getInt("t_course_id"));
				cursos10.add(curso);

			}

		} catch (Exception e) {
			System.out.print(e.getMessage());
		}

		return cursos10;
	}
	
	
	
	public List<T_course> findAlIS() {
		List<T_course> cursos = new ArrayList<T_course>();
		Connection con = MySqlDAOFactory.obtenerConexion();

		try {
			// String sql =
			// "SELECT * FROM bd_tallerproyectos.t_course where t_cycle_id=1";
			
			StringBuffer sentencia=new StringBuffer();
			
			
			sentencia.append("select c.id, c.nombre, cm.mencion_id from t_curso c inner join  t_curso_mencion cm on c.id=cm.curso_id where mencion_id='3'");
			
			PreparedStatement ps = con.prepareStatement(sentencia.toString());
			ResultSet rs = ps.executeQuery();
			T_course curso;
			while (rs.next()) {
				curso = new T_course();
				// curso.setId(rs.getInt("id"));
				// curso.setName(rs.getString("name"));
				// curso.setT_cycle_id(rs.getInt("t_cycle_id"));
				// curso.setT_course_id(rs.getInt("t_course_id"));
				curso.setId(rs.getInt("c.id"));
				curso.setName(rs.getString("c.nombre"));
				//curso.setT_cycle_id(rs.getInt("pcd.ciclo_id"));
				curso.setMencion(rs.getInt("cm.mencion_id"));
			//	curso.setT_course_id(rs.getInt("t_course_id"));
				if (curso.getId() == 90671) {
					curso.setLeft("681.641px");	
					curso.setTop("453.5px");
				}
				if (curso.getId() == 90665) {
					curso.setLeft("813.969px");	
					curso.setTop("385.5px");
				}
				if (curso.getId() == 90672) {
					curso.setLeft("813.969px");	
					curso.setTop("453.5px");
				}
				if (curso.getId() == 90861) {
					curso.setLeft("946.297px");	
					curso.setTop("317.5px");
				}
				if (curso.getId() == 90659) {
					curso.setLeft("946.297px");	
					curso.setTop("385.5px");
				}
				if (curso.getId() == 91124) {
					curso.setLeft("946.297px");	
					curso.setTop("453.5px");
				}
				
				if (curso.getId() == 90085) {
					curso.setLeft("1069.95px");	
					curso.setTop("249.5px");
				}
				if (curso.getId() == 90660) {
					curso.setLeft("1069.95px");	
					curso.setTop("385.5px");
				}
				if (curso.getId() == 90658) {
					curso.setLeft("1069.95px");	
					curso.setTop("317.5px");
				}
				if (curso.getId() == 90666) {
					curso.setLeft("1194.61px");	
					curso.setTop("317.5px");
				}
				cursos.add(curso);

			}

		} catch (Exception e) {
			System.out.print(e.getMessage());
		}

		return cursos;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*MENSION IS /*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*
	
	
	
	
	
	
//	/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*MENSION TI /*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*
//	/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*MENSION TI /*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*
	
//	/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*MENSION TI /*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*
//	/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*MENSION TI /*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*
//	/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*MENSION TI /*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*
//	/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*MENSION TI /*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*//	/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*MENSION SI /*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*
//	/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*MENSION TI /*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*
//	/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*MENSION TI /*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*

//	/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*MENSION TI /*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*
//	/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*MENSION TI /*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*
	
//	/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*MENSION TI /*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*
//	/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*MENSION TI /*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*
//	/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*MENSION TI /*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*
		
	
	
	
	
	
	

	
	
	
	public List<T_course> findAl1TI() {
		List<T_course> cursos = new ArrayList<T_course>();
		Connection con = MySqlDAOFactory.obtenerConexion();

		try {
			// String sql =
			// "SELECT * FROM bd_tallerproyectos.t_course where t_cycle_id=1";
			
			StringBuffer sentencia=new StringBuffer();
			
			sentencia.append("select pcd.id, pcd.curso_id, pcd.ciclo_id, pcd.curso_area_id, c.nombre from t_plan_curricular_detalle pcd "); 
			sentencia.append("inner join t_curso c on pcd.curso_id=c.id where ciclo_id='1'"); 
			
						
			PreparedStatement ps = con.prepareStatement(sentencia.toString());
			ResultSet rs = ps.executeQuery();
			T_course curso;
			while (rs.next()) {
				curso = new T_course();
				// curso.setId(rs.getInt("id"));
				// curso.setName(rs.getString("name"));
				// curso.setT_cycle_id(rs.getInt("t_cycle_id"));
				// curso.setT_course_id(rs.getInt("t_course_id"));
				curso.setId(rs.getInt("pcd.curso_id"));
				curso.setName(rs.getString("c.nombre"));
				curso.setT_cycle_id(rs.getInt("pcd.ciclo_id"));
				curso.setMencion(rs.getInt("pcd.curso_area_id"));
			//	curso.setT_course_id(rs.getInt("t_course_id"));
				cursos.add(curso);

			}

		} catch (Exception e) {
			System.out.print(e.getMessage());
		}

		return cursos;
	}

	@Override
	public List<T_course> findAl2TI() {
		List<T_course> cursos2 = new ArrayList<T_course>();
		Connection con = MySqlDAOFactory.obtenerConexion();

		try {
//			String sql = "SELECT * FROM bd_tallerproyectos.t_course  where t_cycle_id=2";
			StringBuffer sentencia=new StringBuffer();
			

			sentencia.append("select pcd.id, pcd.curso_id, pcd.ciclo_id, pcd.curso_area_id, c.nombre from t_plan_curricular_detalle pcd "); 
			sentencia.append("inner join t_curso c on pcd.curso_id=c.id where ciclo_id='2'"); 
			
						
			PreparedStatement ps = con.prepareStatement(sentencia.toString());
			ResultSet rs = ps.executeQuery();
			T_course curso;
			while (rs.next()) {
				curso = new T_course();
				// curso.setId(rs.getInt("id"));
				// curso.setName(rs.getString("name"));
				// curso.setT_cycle_id(rs.getInt("t_cycle_id"));
				// curso.setT_course_id(rs.getInt("t_course_id"));
				curso.setId(rs.getInt("pcd.curso_id"));
				curso.setName(rs.getString("c.nombre"));
				curso.setT_cycle_id(rs.getInt("pcd.ciclo_id"));
				curso.setMencion(rs.getInt("pcd.curso_area_id"));
			//	curso.setT_course_id(rs.getInt("t_course_id"));
				cursos2.add(curso);

			}

		} catch (Exception e) {
			System.out.print(e.getMessage());
		}

		return cursos2;
	}

	@Override
	public List<T_course> findAl3TI() {
		List<T_course> cursos3 = new ArrayList<T_course>();
		Connection con = MySqlDAOFactory.obtenerConexion();

		try {
//			String sql = "SELECT * FROM bd_tallerproyectos.t_course  where t_cycle_id=3";
			StringBuffer sentencia=new StringBuffer();

			sentencia.append("select pcd.id, pcd.curso_id, pcd.ciclo_id, pcd.curso_area_id, c.nombre from t_plan_curricular_detalle pcd "); 
			sentencia.append("inner join t_curso c on pcd.curso_id=c.id where ciclo_id='3'"); 
			
						
			PreparedStatement ps = con.prepareStatement(sentencia.toString());
			ResultSet rs = ps.executeQuery();
			T_course curso;
			while (rs.next()) {
				curso = new T_course();
				// curso.setId(rs.getInt("id"));
				// curso.setName(rs.getString("name"));
				// curso.setT_cycle_id(rs.getInt("t_cycle_id"));
				// curso.setT_course_id(rs.getInt("t_course_id"));
				curso.setId(rs.getInt("pcd.curso_id"));
				curso.setName(rs.getString("c.nombre"));
				curso.setT_cycle_id(rs.getInt("pcd.ciclo_id"));
				curso.setMencion(rs.getInt("pcd.curso_area_id"));
			//	curso.setT_course_id(rs.getInt("t_course_id"));
				cursos3.add(curso);

			}

		} catch (Exception e) {
			System.out.print(e.getMessage());
		}

		return cursos3;
	}

	@Override
	public List<T_course> findAl4TI() {
		List<T_course> cursos4 = new ArrayList<T_course>();
		Connection con = MySqlDAOFactory.obtenerConexion();

		try {
//			String sql = "SELECT * FROM bd_tallerproyectos.t_course  where t_cycle_id=4";
			StringBuffer sentencia=new StringBuffer();

			sentencia.append("select pcd.id, pcd.curso_id, pcd.ciclo_id, pcd.curso_area_id, c.nombre from t_plan_curricular_detalle pcd "); 
			sentencia.append("inner join t_curso c on pcd.curso_id=c.id where ciclo_id='4'"); 
			
						
			PreparedStatement ps = con.prepareStatement(sentencia.toString());
			ResultSet rs = ps.executeQuery();
			T_course curso;
			while (rs.next()) {
				curso = new T_course();
				// curso.setId(rs.getInt("id"));
				// curso.setName(rs.getString("name"));
				// curso.setT_cycle_id(rs.getInt("t_cycle_id"));
				// curso.setT_course_id(rs.getInt("t_course_id"));
				curso.setId(rs.getInt("pcd.curso_id"));
				curso.setName(rs.getString("c.nombre"));
				curso.setT_cycle_id(rs.getInt("pcd.ciclo_id"));
				curso.setMencion(rs.getInt("pcd.curso_area_id"));
			//	curso.setT_course_id(rs.getInt("t_course_id"));
				cursos4.add(curso);

			}

		} catch (Exception e) {
			System.out.print(e.getMessage());
		}

		return cursos4;
	}

	@Override
	public List<T_course> findAl5TI() {
		List<T_course> cursos5 = new ArrayList<T_course>();
		Connection con = MySqlDAOFactory.obtenerConexion();

		try {
//			String sql = "SELECT * FROM bd_tallerproyectos.t_course  where t_cycle_id=5";
			StringBuffer sentencia=new StringBuffer();

			sentencia.append("select pcd.id, pcd.curso_id, pcd.ciclo_id, pcd.curso_area_id, c.nombre from t_plan_curricular_detalle pcd "); 
			sentencia.append("inner join t_curso c on pcd.curso_id=c.id where ciclo_id='5'"); 
			
						
			PreparedStatement ps = con.prepareStatement(sentencia.toString());
			ResultSet rs = ps.executeQuery();
			T_course curso;
			while (rs.next()) {
				curso = new T_course();
				// curso.setId(rs.getInt("id"));
				// curso.setName(rs.getString("name"));
				// curso.setT_cycle_id(rs.getInt("t_cycle_id"));
				// curso.setT_course_id(rs.getInt("t_course_id"));
				curso.setId(rs.getInt("pcd.curso_id"));
				curso.setName(rs.getString("c.nombre"));
				curso.setT_cycle_id(rs.getInt("pcd.ciclo_id"));
				curso.setMencion(rs.getInt("pcd.curso_area_id"));
			//	curso.setT_course_id(rs.getInt("t_course_id"));
				cursos5.add(curso);

			}

		} catch (Exception e) {
			System.out.print(e.getMessage());
		}

		return cursos5;
	}

	@Override
	public List<T_course> findAl6TI() {
		List<T_course> cursos6 = new ArrayList<T_course>();
		Connection con = MySqlDAOFactory.obtenerConexion();

		try {
//			String sql = "SELECT * FROM bd_tallerproyectos.t_course  where t_cycle_id=6";
			StringBuffer sentencia=new StringBuffer();

			sentencia.append("select pcd.id, pcd.curso_id, pcd.ciclo_id, pcd.curso_area_id, c.nombre from t_plan_curricular_detalle pcd "); 
			sentencia.append("inner join t_curso c on pcd.curso_id=c.id where ciclo_id='6'"); 
			
						
			PreparedStatement ps = con.prepareStatement(sentencia.toString());
			ResultSet rs = ps.executeQuery();
			T_course curso;
			while (rs.next()) {
				curso = new T_course();
				// curso.setId(rs.getInt("id"));
				// curso.setName(rs.getString("name"));
				// curso.setT_cycle_id(rs.getInt("t_cycle_id"));
				// curso.setT_course_id(rs.getInt("t_course_id"));
				curso.setId(rs.getInt("pcd.curso_id"));
				curso.setName(rs.getString("c.nombre"));
				curso.setT_cycle_id(rs.getInt("pcd.ciclo_id"));
				curso.setMencion(rs.getInt("pcd.curso_area_id"));
			//	curso.setT_course_id(rs.getInt("t_course_id"));
				cursos6.add(curso);

			}

		} catch (Exception e) {
			System.out.print(e.getMessage());
		}

		return cursos6;
	}

	@Override
	public List<T_course> findAl7TI() {
		List<T_course> cursos7 = new ArrayList<T_course>();
		Connection con = MySqlDAOFactory.obtenerConexion();

		try {
//			String sql = "SELECT * FROM bd_tallerproyectos.t_course  where t_cycle_id=7";
			StringBuffer sentencia=new StringBuffer();

			sentencia.append("select pcd.id, pcd.curso_id, pcd.ciclo_id, pcd.curso_area_id, c.nombre from t_plan_curricular_detalle pcd "); 
			sentencia.append("inner join t_curso c on pcd.curso_id=c.id where ciclo_id='7'"); 
			
						
			PreparedStatement ps = con.prepareStatement(sentencia.toString());
			ResultSet rs = ps.executeQuery();
			T_course curso;
			while (rs.next()) {
				curso = new T_course();
				// curso.setId(rs.getInt("id"));
				// curso.setName(rs.getString("name"));
				// curso.setT_cycle_id(rs.getInt("t_cycle_id"));
				// curso.setT_course_id(rs.getInt("t_course_id"));
				curso.setId(rs.getInt("pcd.curso_id"));
				curso.setName(rs.getString("c.nombre"));
				curso.setT_cycle_id(rs.getInt("pcd.ciclo_id"));
				curso.setMencion(rs.getInt("pcd.curso_area_id"));
			//	curso.setT_course_id(rs.getInt("t_course_id"));
				cursos7.add(curso);

			}

		} catch (Exception e) {
			System.out.print(e.getMessage());
		}

		return cursos7;
	}

	@Override
	public List<T_course> findAl8TI() {
		List<T_course> cursos8 = new ArrayList<T_course>();
		Connection con = MySqlDAOFactory.obtenerConexion();

		try {
//			String sql = "SELECT * FROM bd_tallerproyectos.t_course  where t_cycle_id=8";
			StringBuffer sentencia=new StringBuffer();

			sentencia.append("select pcd.id, pcd.curso_id, pcd.ciclo_id, pcd.curso_area_id, c.nombre from t_plan_curricular_detalle pcd "); 
			sentencia.append("inner join t_curso c on pcd.curso_id=c.id where ciclo_id='8'"); 
			
						
			PreparedStatement ps = con.prepareStatement(sentencia.toString());
			ResultSet rs = ps.executeQuery();
			T_course curso;
			while (rs.next()) {
				curso = new T_course();
				// curso.setId(rs.getInt("id"));
				// curso.setName(rs.getString("name"));
				// curso.setT_cycle_id(rs.getInt("t_cycle_id"));
				// curso.setT_course_id(rs.getInt("t_course_id"));
				curso.setId(rs.getInt("pcd.curso_id"));
				curso.setName(rs.getString("c.nombre"));
				curso.setT_cycle_id(rs.getInt("pcd.ciclo_id"));
				curso.setMencion(rs.getInt("pcd.curso_area_id"));
			//	curso.setT_course_id(rs.getInt("t_course_id"));
				cursos8.add(curso);

			}

		} catch (Exception e) {
			System.out.print(e.getMessage());
		}

		return cursos8;
	}

	@Override
	public List<T_course> findAl9TI() {
		List<T_course> cursos9 = new ArrayList<T_course>();
		Connection con = MySqlDAOFactory.obtenerConexion();

		try {
//			String sql = "SELECT * FROM bd_tallerproyectos.t_course  where t_cycle_id=9";
			StringBuffer sentencia=new StringBuffer();

			sentencia.append("select pcd.id, pcd.curso_id, pcd.ciclo_id, pcd.curso_area_id, c.nombre from t_plan_curricular_detalle pcd "); 
			sentencia.append("inner join t_curso c on pcd.curso_id=c.id where ciclo_id='9'"); 
			
						
			PreparedStatement ps = con.prepareStatement(sentencia.toString());
			ResultSet rs = ps.executeQuery();
			T_course curso;
			while (rs.next()) {
				curso = new T_course();
				// curso.setId(rs.getInt("id"));
				// curso.setName(rs.getString("name"));
				// curso.setT_cycle_id(rs.getInt("t_cycle_id"));
				// curso.setT_course_id(rs.getInt("t_course_id"));
				curso.setId(rs.getInt("pcd.curso_id"));
				curso.setName(rs.getString("c.nombre"));
				curso.setT_cycle_id(rs.getInt("pcd.ciclo_id"));
				curso.setMencion(rs.getInt("pcd.curso_area_id"));
			//	curso.setT_course_id(rs.getInt("t_course_id"));
				cursos9.add(curso);

			}

		} catch (Exception e) {
			System.out.print(e.getMessage());
		}

		return cursos9;
	}

	@Override
	public List<T_course> findAl10TI() {
		List<T_course> cursos10 = new ArrayList<T_course>();
		Connection con = MySqlDAOFactory.obtenerConexion();

		try {
//			String sql = "SELECT * FROM bd_tallerproyectos.t_course  where t_cycle_id=10";
			StringBuffer sentencia=new StringBuffer();

			sentencia.append("select pcd.id, pcd.curso_id, pcd.ciclo_id, pcd.curso_area_id, c.nombre from t_plan_curricular_detalle pcd "); 
			sentencia.append("inner join t_curso c on pcd.curso_id=c.id where ciclo_id='10'"); 
			
						
			PreparedStatement ps = con.prepareStatement(sentencia.toString());
			ResultSet rs = ps.executeQuery();
			T_course curso;
			while (rs.next()) {
				curso = new T_course();
				// curso.setId(rs.getInt("id"));
				// curso.setName(rs.getString("name"));
				// curso.setT_cycle_id(rs.getInt("t_cycle_id"));
				// curso.setT_course_id(rs.getInt("t_course_id"));
				curso.setId(rs.getInt("pcd.curso_id"));
				curso.setName(rs.getString("c.nombre"));
				curso.setT_cycle_id(rs.getInt("pcd.ciclo_id"));
				curso.setMencion(rs.getInt("pcd.curso_area_id"));
			//	curso.setT_course_id(rs.getInt("t_course_id"));
				cursos10.add(curso);

			}

		} catch (Exception e) {
			System.out.print(e.getMessage());
		}

		return cursos10;
	}
	
	
	
	public List<T_course> findAlTI() {
		List<T_course> cursos = new ArrayList<T_course>();
		Connection con = MySqlDAOFactory.obtenerConexion();

		try {
			// String sql =
			// "SELECT * FROM bd_tallerproyectos.t_course where t_cycle_id=1";
			
			StringBuffer sentencia=new StringBuffer();
			
			
			sentencia.append("select c.id, c.nombre, cm.mencion_id from t_curso c inner join  t_curso_mencion cm on c.id=cm.curso_id where mencion_id='2'");
					
			PreparedStatement ps = con.prepareStatement(sentencia.toString());
			ResultSet rs = ps.executeQuery();
			T_course curso;
			while (rs.next()) {
				curso = new T_course();
				// curso.setId(rs.getInt("id"));
				// curso.setName(rs.getString("name"));
				// curso.setT_cycle_id(rs.getInt("t_cycle_id"));
				// curso.setT_course_id(rs.getInt("t_course_id"));
				curso.setId(rs.getInt("c.id"));
				curso.setName(rs.getString("c.nombre"));
				//curso.setT_cycle_id(rs.getInt("pcd.ciclo_id"));
				curso.setMencion(rs.getInt("cm.mencion_id"));
			//	curso.setT_course_id(rs.getInt("t_course_id"));
				cursos.add(curso);

				if (curso.getId() == 90675) {
					curso.setLeft("681.641px");	
					curso.setTop("453.5px");
				}
				if (curso.getId() == 91119) {
					curso.setLeft("813.969px");	
					curso.setTop("385.5px");
				}
				if (curso.getId() == 90676) {
					curso.setLeft("813.969px");	
					curso.setTop("453.5px");
				}
				if (curso.getId() == 90179) {
					curso.setLeft("1194.61px");	
					curso.setTop("385.5px");
				}
				if (curso.getId() == 90548) {
					curso.setLeft("946.297px");	
					curso.setTop("385.5px");
				}
				if (curso.getId() == 90677) {
					curso.setLeft("946.297px");	
					curso.setTop("453.5px");
				}
				if (curso.getId() == 90088) {
					curso.setLeft("1069.95px");	
					curso.setTop("249.5px");
				}
				if (curso.getId() == 90674) {
					curso.setLeft("1069.95px");	
					curso.setTop("385.5px");
				}
				if (curso.getId() == 90678) {
					curso.setLeft("1069.95px");	
					curso.setTop("453.5px");
				}
				if (curso.getId() == 90670) {
					curso.setLeft("1194.61px");	
					curso.setTop("249.5px");
				}
				
			}

		} catch (Exception e) {
			System.out.print(e.getMessage());
		}

		return cursos;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*MENSION SI /*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*


	
	
	
//	/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*MENSION IS /*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*
	
	
	
	
	
	
//	/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*MENSION LI /*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*
//	/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*MENSION LI /*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*
	
//	/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*MENSION LI /*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*
//	/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*MENSION LI /*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*
//	/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*MENSION LI /*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*
//	/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*MENSION LI /*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*//	/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*MENSION SI /*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*
//	/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*MENSION LI /*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*
//	/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*MENSION LI /*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*
	
//	/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*MENSION LI /*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*
//	/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*MENSION LI /*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*
	
//	/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*MENSION LI /*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*
//	/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*MENSION LI /*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*
//	/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*MENSION LI /*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*
		
	
	
	
	
	
	

	
	
	
	public List<T_course> findAl1LI() {
		List<T_course> cursos = new ArrayList<T_course>();
		Connection con = MySqlDAOFactory.obtenerConexion();

		try {
			// String sql =
			// "SELECT * FROM bd_tallerproyectos.t_course where t_cycle_id=1";
			
			StringBuffer sentencia=new StringBuffer();
			
			sentencia.append("select pcd.id, pcd.curso_id, pcd.ciclo_id, pcd.curso_area_id, c.nombre from t_plan_curricular_detalle pcd "); 
			sentencia.append("inner join t_curso c on pcd.curso_id=c.id where ciclo_id='1'"); 
			
						
			PreparedStatement ps = con.prepareStatement(sentencia.toString());
			ResultSet rs = ps.executeQuery();
			T_course curso;
			while (rs.next()) {
				curso = new T_course();
				// curso.setId(rs.getInt("id"));
				// curso.setName(rs.getString("name"));
				// curso.setT_cycle_id(rs.getInt("t_cycle_id"));
				// curso.setT_course_id(rs.getInt("t_course_id"));
				curso.setId(rs.getInt("pcd.curso_id"));
				curso.setName(rs.getString("c.nombre"));
				curso.setT_cycle_id(rs.getInt("pcd.ciclo_id"));
				curso.setMencion(rs.getInt("pcd.curso_area_id"));
			//	curso.setT_course_id(rs.getInt("t_course_id"));
				cursos.add(curso);

			}

		} catch (Exception e) {
			System.out.print(e.getMessage());
		}

		return cursos;
	}

	@Override
	public List<T_course> findAl2LI() {
		List<T_course> cursos2 = new ArrayList<T_course>();
		Connection con = MySqlDAOFactory.obtenerConexion();

		try {
//			String sql = "SELECT * FROM bd_tallerproyectos.t_course  where t_cycle_id=2";
			StringBuffer sentencia=new StringBuffer();
			

			sentencia.append("select pcd.id, pcd.curso_id, pcd.ciclo_id, pcd.curso_area_id, c.nombre from t_plan_curricular_detalle pcd "); 
			sentencia.append("inner join t_curso c on pcd.curso_id=c.id where ciclo_id='2'"); 
			
						
			PreparedStatement ps = con.prepareStatement(sentencia.toString());
			ResultSet rs = ps.executeQuery();
			T_course curso;
			while (rs.next()) {
				curso = new T_course();
				// curso.setId(rs.getInt("id"));
				// curso.setName(rs.getString("name"));
				// curso.setT_cycle_id(rs.getInt("t_cycle_id"));
				// curso.setT_course_id(rs.getInt("t_course_id"));
				curso.setId(rs.getInt("pcd.curso_id"));
				curso.setName(rs.getString("c.nombre"));
				curso.setT_cycle_id(rs.getInt("pcd.ciclo_id"));
				curso.setMencion(rs.getInt("pcd.curso_area_id"));
			//	curso.setT_course_id(rs.getInt("t_course_id"));
				cursos2.add(curso);

			}

		} catch (Exception e) {
			System.out.print(e.getMessage());
		}

		return cursos2;
	}

	@Override
	public List<T_course> findAl3LI() {
		List<T_course> cursos3 = new ArrayList<T_course>();
		Connection con = MySqlDAOFactory.obtenerConexion();

		try {
//			String sql = "SELECT * FROM bd_tallerproyectos.t_course  where t_cycle_id=3";
			StringBuffer sentencia=new StringBuffer();

			sentencia.append("select pcd.id, pcd.curso_id, pcd.ciclo_id, pcd.curso_area_id, c.nombre from t_plan_curricular_detalle pcd "); 
			sentencia.append("inner join t_curso c on pcd.curso_id=c.id where ciclo_id='3'"); 
			
						
			PreparedStatement ps = con.prepareStatement(sentencia.toString());
			ResultSet rs = ps.executeQuery();
			T_course curso;
			while (rs.next()) {
				curso = new T_course();
				// curso.setId(rs.getInt("id"));
				// curso.setName(rs.getString("name"));
				// curso.setT_cycle_id(rs.getInt("t_cycle_id"));
				// curso.setT_course_id(rs.getInt("t_course_id"));
				curso.setId(rs.getInt("pcd.curso_id"));
				curso.setName(rs.getString("c.nombre"));
				curso.setT_cycle_id(rs.getInt("pcd.ciclo_id"));
				curso.setMencion(rs.getInt("pcd.curso_area_id"));
			//	curso.setT_course_id(rs.getInt("t_course_id"));
				cursos3.add(curso);

			}

		} catch (Exception e) {
			System.out.print(e.getMessage());
		}

		return cursos3;
	}

	@Override
	public List<T_course> findAl4LI() {
		List<T_course> cursos4 = new ArrayList<T_course>();
		Connection con = MySqlDAOFactory.obtenerConexion();

		try {
//			String sql = "SELECT * FROM bd_tallerproyectos.t_course  where t_cycle_id=4";
			StringBuffer sentencia=new StringBuffer();

			sentencia.append("select pcd.id, pcd.curso_id, pcd.ciclo_id, pcd.curso_area_id, c.nombre from t_plan_curricular_detalle pcd "); 
			sentencia.append("inner join t_curso c on pcd.curso_id=c.id where ciclo_id='4'"); 
			
						
			PreparedStatement ps = con.prepareStatement(sentencia.toString());
			ResultSet rs = ps.executeQuery();
			T_course curso;
			while (rs.next()) {
				curso = new T_course();
				// curso.setId(rs.getInt("id"));
				// curso.setName(rs.getString("name"));
				// curso.setT_cycle_id(rs.getInt("t_cycle_id"));
				// curso.setT_course_id(rs.getInt("t_course_id"));
				curso.setId(rs.getInt("pcd.curso_id"));
				curso.setName(rs.getString("c.nombre"));
				curso.setT_cycle_id(rs.getInt("pcd.ciclo_id"));
				curso.setMencion(rs.getInt("pcd.curso_area_id"));
			//	curso.setT_course_id(rs.getInt("t_course_id"));
				cursos4.add(curso);

			}

		} catch (Exception e) {
			System.out.print(e.getMessage());
		}

		return cursos4;
	}

	@Override
	public List<T_course> findAl5LI() {
		List<T_course> cursos5 = new ArrayList<T_course>();
		Connection con = MySqlDAOFactory.obtenerConexion();

		try {
//			String sql = "SELECT * FROM bd_tallerproyectos.t_course  where t_cycle_id=5";
			StringBuffer sentencia=new StringBuffer();

			sentencia.append("select pcd.id, pcd.curso_id, pcd.ciclo_id, pcd.curso_area_id, c.nombre from t_plan_curricular_detalle pcd "); 
			sentencia.append("inner join t_curso c on pcd.curso_id=c.id where ciclo_id='5'"); 
			
						
			PreparedStatement ps = con.prepareStatement(sentencia.toString());
			ResultSet rs = ps.executeQuery();
			T_course curso;
			while (rs.next()) {
				curso = new T_course();
				// curso.setId(rs.getInt("id"));
				// curso.setName(rs.getString("name"));
				// curso.setT_cycle_id(rs.getInt("t_cycle_id"));
				// curso.setT_course_id(rs.getInt("t_course_id"));
				curso.setId(rs.getInt("pcd.curso_id"));
				curso.setName(rs.getString("c.nombre"));
				curso.setT_cycle_id(rs.getInt("pcd.ciclo_id"));
				curso.setMencion(rs.getInt("pcd.curso_area_id"));
			//	curso.setT_course_id(rs.getInt("t_course_id"));
				cursos5.add(curso);

			}

		} catch (Exception e) {
			System.out.print(e.getMessage());
		}

		return cursos5;
	}

	@Override
	public List<T_course> findAl6LI() {
		List<T_course> cursos6 = new ArrayList<T_course>();
		Connection con = MySqlDAOFactory.obtenerConexion();

		try {
//			String sql = "SELECT * FROM bd_tallerproyectos.t_course  where t_cycle_id=6";
			StringBuffer sentencia=new StringBuffer();

			sentencia.append("select pcd.id, pcd.curso_id, pcd.ciclo_id, pcd.curso_area_id, c.nombre from t_plan_curricular_detalle pcd "); 
			sentencia.append("inner join t_curso c on pcd.curso_id=c.id where ciclo_id='6'"); 
			
						
			PreparedStatement ps = con.prepareStatement(sentencia.toString());
			ResultSet rs = ps.executeQuery();
			T_course curso;
			while (rs.next()) {
				curso = new T_course();
				// curso.setId(rs.getInt("id"));
				// curso.setName(rs.getString("name"));
				// curso.setT_cycle_id(rs.getInt("t_cycle_id"));
				// curso.setT_course_id(rs.getInt("t_course_id"));
				curso.setId(rs.getInt("pcd.curso_id"));
				curso.setName(rs.getString("c.nombre"));
				curso.setT_cycle_id(rs.getInt("pcd.ciclo_id"));
				curso.setMencion(rs.getInt("pcd.curso_area_id"));
			//	curso.setT_course_id(rs.getInt("t_course_id"));
				cursos6.add(curso);

			}

		} catch (Exception e) {
			System.out.print(e.getMessage());
		}

		return cursos6;
	}

	@Override
	public List<T_course> findAl7LI() {
		List<T_course> cursos7 = new ArrayList<T_course>();
		Connection con = MySqlDAOFactory.obtenerConexion();

		try {
//			String sql = "SELECT * FROM bd_tallerproyectos.t_course  where t_cycle_id=7";
			StringBuffer sentencia=new StringBuffer();

			sentencia.append("select pcd.id, pcd.curso_id, pcd.ciclo_id, pcd.curso_area_id, c.nombre from t_plan_curricular_detalle pcd "); 
			sentencia.append("inner join t_curso c on pcd.curso_id=c.id where ciclo_id='7'"); 
			
						
			PreparedStatement ps = con.prepareStatement(sentencia.toString());
			ResultSet rs = ps.executeQuery();
			T_course curso;
			while (rs.next()) {
				curso = new T_course();
				// curso.setId(rs.getInt("id"));
				// curso.setName(rs.getString("name"));
				// curso.setT_cycle_id(rs.getInt("t_cycle_id"));
				// curso.setT_course_id(rs.getInt("t_course_id"));
				curso.setId(rs.getInt("pcd.curso_id"));
				curso.setName(rs.getString("c.nombre"));
				curso.setT_cycle_id(rs.getInt("pcd.ciclo_id"));
				curso.setMencion(rs.getInt("pcd.curso_area_id"));
			//	curso.setT_course_id(rs.getInt("t_course_id"));
				cursos7.add(curso);

			}

		} catch (Exception e) {
			System.out.print(e.getMessage());
		}

		return cursos7;
	}

	@Override
	public List<T_course> findAl8LI() {
		List<T_course> cursos8 = new ArrayList<T_course>();
		Connection con = MySqlDAOFactory.obtenerConexion();

		try {
//			String sql = "SELECT * FROM bd_tallerproyectos.t_course  where t_cycle_id=8";
			StringBuffer sentencia=new StringBuffer();

			sentencia.append("select pcd.id, pcd.curso_id, pcd.ciclo_id, pcd.curso_area_id, c.nombre from t_plan_curricular_detalle pcd "); 
			sentencia.append("inner join t_curso c on pcd.curso_id=c.id where ciclo_id='8'"); 
			
						
			PreparedStatement ps = con.prepareStatement(sentencia.toString());
			ResultSet rs = ps.executeQuery();
			T_course curso;
			while (rs.next()) {
				curso = new T_course();
				// curso.setId(rs.getInt("id"));
				// curso.setName(rs.getString("name"));
				// curso.setT_cycle_id(rs.getInt("t_cycle_id"));
				// curso.setT_course_id(rs.getInt("t_course_id"));
				curso.setId(rs.getInt("pcd.curso_id"));
				curso.setName(rs.getString("c.nombre"));
				curso.setT_cycle_id(rs.getInt("pcd.ciclo_id"));
				curso.setMencion(rs.getInt("pcd.curso_area_id"));
			//	curso.setT_course_id(rs.getInt("t_course_id"));
				cursos8.add(curso);

			}

		} catch (Exception e) {
			System.out.print(e.getMessage());
		}

		return cursos8;
	}

	@Override
	public List<T_course> findAl9LI() {
		List<T_course> cursos9 = new ArrayList<T_course>();
		Connection con = MySqlDAOFactory.obtenerConexion();

		try {
//			String sql = "SELECT * FROM bd_tallerproyectos.t_course  where t_cycle_id=9";
			StringBuffer sentencia=new StringBuffer();

			sentencia.append("select pcd.id, pcd.curso_id, pcd.ciclo_id, pcd.curso_area_id, c.nombre from t_plan_curricular_detalle pcd "); 
			sentencia.append("inner join t_curso c on pcd.curso_id=c.id where ciclo_id='9'"); 
			
						
			PreparedStatement ps = con.prepareStatement(sentencia.toString());
			ResultSet rs = ps.executeQuery();
			T_course curso;
			while (rs.next()) {
				curso = new T_course();
				// curso.setId(rs.getInt("id"));
				// curso.setName(rs.getString("name"));
				// curso.setT_cycle_id(rs.getInt("t_cycle_id"));
				// curso.setT_course_id(rs.getInt("t_course_id"));
				curso.setId(rs.getInt("pcd.curso_id"));
				curso.setName(rs.getString("c.nombre"));
				curso.setT_cycle_id(rs.getInt("pcd.ciclo_id"));
				curso.setMencion(rs.getInt("pcd.curso_area_id"));
			//	curso.setT_course_id(rs.getInt("t_course_id"));
				cursos9.add(curso);

			}

		} catch (Exception e) {
			System.out.print(e.getMessage());
		}

		return cursos9;
	}

	@Override
	public List<T_course> findAl10LI() {
		List<T_course> cursos10 = new ArrayList<T_course>();
		Connection con = MySqlDAOFactory.obtenerConexion();

		try {
//			String sql = "SELECT * FROM bd_tallerproyectos.t_course  where t_cycle_id=10";
			StringBuffer sentencia=new StringBuffer();

			sentencia.append("select pcd.id, pcd.curso_id, pcd.ciclo_id, pcd.curso_area_id, c.nombre from t_plan_curricular_detalle pcd "); 
			sentencia.append("inner join t_curso c on pcd.curso_id=c.id where ciclo_id='10'"); 
			
						
			PreparedStatement ps = con.prepareStatement(sentencia.toString());
			ResultSet rs = ps.executeQuery();
			T_course curso;
			while (rs.next()) {
				curso = new T_course();
				// curso.setId(rs.getInt("id"));
				// curso.setName(rs.getString("name"));
				// curso.setT_cycle_id(rs.getInt("t_cycle_id"));
				// curso.setT_course_id(rs.getInt("t_course_id"));
				curso.setId(rs.getInt("pcd.curso_id"));
				curso.setName(rs.getString("c.nombre"));
				curso.setT_cycle_id(rs.getInt("pcd.ciclo_id"));
				curso.setMencion(rs.getInt("pcd.curso_area_id"));
			//	curso.setT_course_id(rs.getInt("t_course_id"));
				cursos10.add(curso);

			}

		} catch (Exception e) {
			System.out.print(e.getMessage());
		}

		return cursos10;
	}
	
	
	
	public List<T_course> findAlLI() {
		List<T_course> cursos = new ArrayList<T_course>();
		Connection con = MySqlDAOFactory.obtenerConexion();

		try {
			// String sql =
			// "SELECT * FROM bd_tallerproyectos.t_course where t_cycle_id=1";
			
			StringBuffer sentencia=new StringBuffer();
			
			
			sentencia.append("select pcd.id, pcd.curso_id, pcd.ciclo_id, pcd.curso_area_id, c.nombre, cm.mencion_id from t_plan_curricular_detalle pcd "); 
			sentencia.append("inner join t_curso c on pcd.curso_id=c.id inner join T_curso_mencion cm on pcd.curso_id=cm.curso_id where ciclo_id='14' ");
				
						
			PreparedStatement ps = con.prepareStatement(sentencia.toString());
			ResultSet rs = ps.executeQuery();
			T_course curso;
			while (rs.next()) {
				curso = new T_course();
				// curso.setId(rs.getInt("id"));
				// curso.setName(rs.getString("name"));
				// curso.setT_cycle_id(rs.getInt("t_cycle_id"));
				// curso.setT_course_id(rs.getInt("t_course_id"));
				curso.setId(rs.getInt("pcd.curso_id"));
				curso.setName(rs.getString("c.nombre"));
				curso.setT_cycle_id(rs.getInt("pcd.ciclo_id"));
				curso.setMencion(rs.getInt("cm.mencion_id"));
			//	curso.setT_course_id(rs.getInt("t_course_id"));
				cursos.add(curso);

			}

		} catch (Exception e) {
			System.out.print(e.getMessage());
		}

		return cursos;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*MENSION LI /*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*

}
