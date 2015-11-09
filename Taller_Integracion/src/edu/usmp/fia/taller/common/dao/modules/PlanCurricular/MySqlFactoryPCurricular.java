package edu.usmp.fia.taller.common.dao.modules.PlanCurricular;

import java.sql.Connection;	
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import edu.usmp.fia.taller.common.bean.PlanCurricular.Curso;
import edu.usmp.fia.taller.common.bean.PlanCurricular.T_Curso;
import edu.usmp.fia.taller.common.dao.DAOFactory;
import edu.usmp.fia.taller.common.dao.MySqlDAOFactory;

public class MySqlFactoryPCurricular extends MySqlDAOFactory implements DAOFactoryPCurricular {
	
	public List<Curso> obtenerCursosPlan() throws Exception {
		
		List<Curso> cursos = new ArrayList<Curso>();
		try {
			Connection con = MySqlDAOFactory.obtenerConexion();
			Statement stmt = con.createStatement();
			Statement stmt2 = con.createStatement();

			String query = "select a.curso_id, a.creditos_requisito, a.creditos, a.horasTeoria, a.horasLaboratorio,"
					+ " a.horasPractica, a.ciclo_id, b.nombre, a.Ordenar from t_plan_curricular_detalle a "
					+ "INNER JOIN t_curso b ON a.curso_id=b.id INNER JOIN t_ciclo c on a.ciclo_id=c.id where a.id=(select max(id) "
					+ "from t_plan_curricular)";
			ResultSet rs = stmt.executeQuery(query);
			String query2 = "select curso_id,curso_requisito_id from t_curso_requisito";

			while (rs.next()) {
				Curso curso = new Curso();
				curso.setCode(rs.getString("a.curso_id"));
				curso.setName(rs.getString("b.nombre"));
				curso.setCredits(rs.getInt("a.creditos"));
				curso.setCycle(rs.getInt("a.ciclo_id"));
				curso.setLaboHours(rs.getInt("a.horasLaboratorio"));
				curso.setTheoHours(rs.getInt("a.horasTeoria"));
				curso.setPracHours(rs.getInt("a.horasPractica"));
				curso.setOrder(rs.getInt("a.Ordenar"));

				ResultSet rs2 = stmt2.executeQuery(query2);

				List<String> arrayLista = new ArrayList<String>();
				while (rs2.next()) {
					if (curso.getCode().equals(rs2.getString("curso_id"))) {
						arrayLista.add(String.valueOf(rs2.getInt("curso_requisito_id")));
					}
				}

				curso.setRequirements(arrayLista);
				cursos.add(curso);
			}
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		return cursos;
	}
	
	public List<Curso> obtenerCursosObligatorios() throws Exception {
		List<Curso> cursos = new ArrayList<Curso>();

		try {
			Connection con = MySqlDAOFactory.obtenerConexion();
			Statement stmt = con.createStatement();
			Statement stmt2 = con.createStatement();

			String query = "select a.curso_id, a.creditos_requisito, a.curso_condicion_id, a.creditos, a.horasTeoria, "
					+ "a.horasLaboratorio, a.horasPractica, a.ciclo_id, b.nombre, a.Ordenar from t_plan_curricular_detalle a "
					+ "INNER JOIN t_curso b ON a.curso_id=b.id INNER JOIN t_ciclo c on a.ciclo_id=c.id "
					+ "where a.id=(select max(id) from t_plan_curricular) and a.curso_condicion_id = '1'";
			ResultSet rs = stmt.executeQuery(query);

			String query2 = "select curso_id, curso_requisito_id from t_curso_requisito";

			while (rs.next()) {
				Curso curso = new Curso();
				curso.setCode(rs.getString("a.curso_id"));
				curso.setName(rs.getString("b.nombre"));
				curso.setCredits(rs.getInt("a.creditos"));
				curso.setCycle(rs.getInt("a.ciclo_id"));
				curso.setLaboHours(rs.getInt("a.horasLaboratorio"));
				curso.setTheoHours(rs.getInt("a.horasTeoria"));
				curso.setPracHours(rs.getInt("a.horasPractica"));
				curso.setOrder(rs.getInt("a.Ordenar"));

				ResultSet rs2 = stmt2.executeQuery(query2);
				List<String> arrayLista = new ArrayList<String>();
				
				while (rs2.next()) {
					if (curso.getCode().equals(rs2.getString("curso_id"))) {
						arrayLista.add(String.valueOf(rs2.getInt("curso_requisito_id")));
					}
				}
				
				curso.setRequirements(arrayLista);
				cursos.add(curso);
			}
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		return cursos;
	}
	
	public List<Curso> obtenerCursosLibres() throws Exception {

		List<Curso> cursos = new ArrayList<Curso>();

		try {
			Connection con = MySqlDAOFactory.obtenerConexion();
			Statement stmt = con.createStatement();
			Statement stmt2 = con.createStatement();

			String query = "select a.curso_id, a.creditos_requisito, a.curso_condicion_id, a.creditos, "
					+ "a.horasTeoria, a.horasLaboratorio, a.horasPractica, a.ciclo_id, b.nombre, a.Ordenar "
					+ "from t_plan_curricular_detalle a INNER JOIN t_curso b ON a.curso_id=b.id "
					+ "INNER JOIN t_ciclo c on a.ciclo_id=c.id where a.id=(select max(id) "
					+ "from t_plan_curricular) and a.curso_condicion_id = '3'";
			ResultSet rs = stmt.executeQuery(query);
			String query2 = "select curso_id, curso_requisito_id from t_curso_requisito";
			while (rs.next()) {
				Curso curso = new Curso();
				curso.setCode(rs.getString("a.curso_id"));
				curso.setName(rs.getString("b.nombre"));
				curso.setCredits(rs.getInt("a.creditos"));
				curso.setCycle(rs.getInt("a.ciclo_id"));
				curso.setLaboHours(rs.getInt("a.horasLaboratorio"));
				curso.setTheoHours(rs.getInt("a.horasTeoria"));
				curso.setPracHours(rs.getInt("a.horasPractica"));
				curso.setOrder(rs.getInt("a.Ordenar"));

				ResultSet rs2 = stmt2.executeQuery(query2);
				List<String> arrayLista = new ArrayList<String>();
				
				while (rs2.next()) {
					if (curso.getCode().equals(rs2.getString("curso_id"))) {
						arrayLista.add(String.valueOf(rs2.getInt("curso_requisito_id")));
					}
				}

				curso.setRequirements(arrayLista);
				cursos.add(curso);
			}
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		return cursos;
	}
	
	public List<Curso> obtenerCursosMencion() throws Exception {

		List<Curso> cursos = new ArrayList<Curso>();

		try {
			Connection con = MySqlDAOFactory.obtenerConexion();
			Statement stmt = con.createStatement();
			Statement stmt2 = con.createStatement();

			String query = "select a.curso_id, a.creditos_requisito, a.curso_condicion_id, a.creditos, "
					+ "a.horasTeoria, a.horasLaboratorio, a.horasPractica, a.ciclo_id, b.nombre, m.mencion_id, a.Ordenar "
					+ "from t_plan_curricular_detalle a INNER JOIN t_curso b ON a.curso_id=b.id "
					+ "inner join t_curso_mencion m on a.curso_id= m.curso_id INNER JOIN t_ciclo c on a.ciclo_id=c.id "
					+ "where a.id=(select max(id) from t_plan_curricular)";
			ResultSet rs = stmt.executeQuery(query);
			String query2 = "select curso_id,curso_requisito_id from t_curso_requisito";
			while (rs.next()) {
				Curso curso = new Curso();
				curso.setCode(rs.getString("a.curso_id"));
				curso.setName(rs.getString("b.nombre"));
				curso.setCredits(rs.getInt("a.creditos"));
				curso.setCycle(rs.getInt("a.ciclo_id"));
				curso.setLaboHours(rs.getInt("a.horasLaboratorio"));
				curso.setTheoHours(rs.getInt("a.horasTeoria"));
				curso.setPracHours(rs.getInt("a.horasPractica"));
				curso.setOrder(rs.getInt("a.Ordenar"));

				ResultSet rs2 = stmt2.executeQuery(query2);
				List<String> arrayLista = new ArrayList<String>();

				while (rs2.next()) {
					if (curso.getCode().equals(rs2.getString("curso_id"))) {
						arrayLista.add(String.valueOf(rs2.getInt("curso_requisito_id")));
					}
				}

				curso.setRequirements(arrayLista);
				cursos.add(curso);
			}
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		return cursos;
	}
	
	public List<Curso> obtenerListaMaestra() throws Exception {

		List<Curso> cursos = new ArrayList<Curso>();

		try {
			Connection con = MySqlDAOFactory.obtenerConexion();
			Statement stmt = con.createStatement();
			Statement stmt2 = con.createStatement();
			Statement stmt3 = con.createStatement();
			
			String query = "select a.curso_id, a.creditos_requisito, a.curso_condicion_id, " 
				+ "a.creditos, a.horasTeoria, a.horasLaboratorio, a.horasPractica, " 
				+ "a.ciclo_id, b.nombre, a.Ordenar " 
				+ "from t_plan_curricular_detalle a " 
				+ "INNER JOIN t_curso b ON a.curso_id=b.id " 
				+ "INNER JOIN t_ciclo c on a.ciclo_id=c.id "
				+ "where a.id=(select max(id) " 
				+ "from t_plan_curricular)";
			ResultSet rs = stmt.executeQuery(query);
			String query2 = "select curso_id,curso_requisito_id from t_curso_requisito";
			String query3 = "select curso_id,mencion_id from  t_curso_mencion";
			while (rs.next()) {
				Curso curso = new Curso();
				curso.setCode(rs.getString("a.curso_id"));
				curso.setName(rs.getString("b.nombre"));
				curso.setCredits(rs.getInt("a.creditos"));
				curso.setCycle(rs.getInt("a.ciclo_id"));
				curso.setLaboHours(rs.getInt("a.horasLaboratorio"));
				curso.setTheoHours(rs.getInt("a.horasTeoria"));
				curso.setPracHours(rs.getInt("a.horasPractica"));
				curso.setType(rs.getInt("a.curso_condicion_id"));
				curso.setOrder(rs.getInt("a.Ordenar"));
				ResultSet rs3 = stmt3.executeQuery(query3);
				List<String> mentions = new ArrayList<String>();
				if (curso.getType() == 2) {
					while (rs3.next()) {
						if (curso.getCode().equals(rs3.getString("curso_id"))) {
							mentions.add(rs3.getString("mencion_id"));
						}
					}
					curso.setMentions(mentions);
				}

				ResultSet rs2 = stmt2.executeQuery(query2);
				List<String> arrayLista = new ArrayList<String>();
				
				while (rs2.next()) {
					if (curso.getCode().equals(rs2.getString("curso_id"))) {
						arrayLista.add("0"+String.valueOf(rs2.getInt("curso_requisito_id")));
					}
				}
				
				
				
				if (rs.getString("a.creditos_requisito") != null) {
					arrayLista.add("C:" + rs.getString("a.creditos_requisito"));
				}

				curso.setRequirements(arrayLista);
				cursos.add(curso);
			}
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		return cursos;
	}
	
	public List<T_Curso> obtenerT_Curso() {
		List<T_Curso> arrayCursos = new ArrayList<T_Curso>();

		try {
			Connection con = MySqlDAOFactory.obtenerConexion();
			Statement stmt4 = con.createStatement(); 
			
			String query4 = "select * from t_curso";
			
			ResultSet rs4 = stmt4.executeQuery(query4);
			
			
			while (rs4.next()) {
				T_Curso cursoTmp = new T_Curso();
				cursoTmp.setId(rs4.getInt("id"));
				cursoTmp.setNombre(rs4.getString("nombre"));
				cursoTmp.setTipo(rs4.getString("tipo"));
				cursoTmp.setEstado(rs4.getString("estado"));
				arrayCursos.add(cursoTmp);
			}
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		return arrayCursos;
	}
	
	public String obtenerNuevoCodigo() {

		try {
			Connection con = MySqlDAOFactory.obtenerConexion();
			Statement stmt = con.createStatement();

			String query = "select LPAD((max(curso_id)+10),6,'0') as variable from t_plan_curricular_detalle p";
			ResultSet rs = stmt.executeQuery(query);

			if (rs.next()) {
				return rs.getString("variable");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	
	public String obtenerSemestre() {		
		try {
			Connection con = MySqlDAOFactory.obtenerConexion();
			Statement stmt = con.createStatement();

			String query = "select s.nombre as variable from t_semestre s " 
				+ "where s.id=(select semestre_id from t_plan_curricular where id = (select max(id) " 
				+ "from t_plan_curricular))";
			ResultSet rs = stmt.executeQuery(query);

			if (rs.next()) {
				return rs.getString("variable");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
	
	public String guardarCursos(List<Curso> cursosCambiados) {		
		try {
			Connection con = MySqlDAOFactory.obtenerConexion();
			Statement stmt = con.createStatement();
			Curso tmp = new Curso();
			for (int i = 0; i < cursosCambiados.size(); i++) {
				tmp = cursosCambiados.get(i);				
				String query = "INSERT INTO `t_plan_curricular_detalle` "
						+ "(`id`, `curso_id`, `creditos`, `ciclo_id`, `curso_condicion_id`, `horasTeoria`, "
						+ "`horasLaboratorio`, `horasPractica`, `creditos_requisito`, `curso_area_id`, `Ordenar`, estado) "
						+ "VALUES (1, '" + tmp.getCode() + "', " + tmp.getCredits() + ", " + tmp.getCycle() + ", "
						+ "" + tmp.getType() + ", " + tmp.getTheoHours() + ", " + tmp.getLaboHours() +", "
						+ "" + tmp.getPracHours() + ", " + tmp.getCreditosReq() + ", " + tmp.getCursoArea() + ", "
						+ "" + tmp.getOrder() + ", ' ')";
				int filas = stmt.executeUpdate(query);
				if (filas == 1) {
					System.out.println("grabo correctamente: " + tmp.getCode());
				}
				
			}
			return "grabo correctamente";
		} catch (Exception e) {
			System.out.println("no grabo");
			System.out.println(e.getMessage());
		}
		return null;
	}
	
	public String actualizarCursos(List<Curso> cursosActualizados) {		
		try {
			Connection con = MySqlDAOFactory.obtenerConexion();
			Statement stmt = con.createStatement();
			Curso tmp = new Curso();
			for (int i = 0; i < cursosActualizados.size(); i++) {
				tmp = cursosActualizados.get(i);
				System.out.println("orden: " + tmp.getOrder());
				String query = "UPDATE `t_plan_curricular_detalle` "
						+ "SET `creditos`='" + tmp.getCredits() + "', `ciclo_id`='" + tmp.getCycle() + "', "
						+ "`curso_condicion_id`='" + tmp.getType() + "', `horasTeoria`='" + tmp.getTheoHours() + "', "
						+ "`horasLaboratorio`='" + tmp.getLaboHours() + "', `horasPractica`='" + tmp.getPracHours() + "', "
						+ "`creditos_requisito`='" + tmp.getCreditosReq() + "', "
						+ "`curso_area_id`='" + tmp.getCursoArea() + "', `Ordenar`='" + tmp.getOrder() + "' "
						+ "WHERE `id`='1' and`curso_id`='" + tmp.getCode() + "'";
				int filas = stmt.executeUpdate(query);
				if (filas == 1) {
					System.out.println("actualizo correctamente");
				}
				List<String> requisitos = tmp.getRequirements();
				for (int j = 0; j < requisitos.size(); j++) {
					String query2 = "UPDATE `t_curso_requisito` "
							+ "SET `curso_requisito_id`='" + requisitos.get(j) + "' "
							+ "WHERE `plan_curricular_id`='1' and`curso_id`='" + tmp.getCode() + "' ";
					int filas2 = stmt.executeUpdate(query2);
					if (filas2 == 1) {
						System.out.println("grabo correctamente los requisitos: " + tmp.getCode());
					}
				}
				List<String> menciones = tmp.getMentions();
				for (int k = 0; k < menciones.size(); k++) {
					String query3 = "UPDATE `t_curso_mencion` "
							+ "SET `mencion_id`='" + menciones.get(k) + "' "
							+ "WHERE `plan_curricular_id`='1' "
							+ "and`curso_id`='" + tmp.getCode() + "'";
					int filas3 = stmt.executeUpdate(query3);
					if (filas3 == 1) {
						System.out.println("grabo correctamente las menciones: " + tmp.getCode());
					}
				}
			}
			return "grabo correctamente";
		} catch (Exception e) {
			System.out.println("no grabo");
			System.out.println(e.getMessage());
		}
		return null;
	}
	
	
	public List<Curso> obtenerCursosPCD() {
		List<Curso> cursosBD = new ArrayList<Curso>();
		try {
			Connection con = MySqlDAOFactory.obtenerConexion();
			Statement stmt = con.createStatement();
			String query = "select curso_id from bd_taller_proyectos.t_plan_curricular_detalle";
				ResultSet rs = stmt.executeQuery(query);
				Curso tmp = new Curso();
				if (rs.next()) {
					tmp.setCode(rs.getString("curso_id"));
					cursosBD.add(tmp);
				}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return cursosBD;
	}
}
