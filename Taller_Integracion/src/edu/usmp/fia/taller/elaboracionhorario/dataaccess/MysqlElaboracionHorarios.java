package edu.usmp.fia.taller.elaboracionhorario.dataaccess;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.json.JSONArray;
import org.json.JSONObject;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.sql.Statement;
import edu.usmp.fia.taller.common.bean.ElaboracionHorarios.*;
import edu.usmp.fia.taller.common.dao.MySqlDAOFactory;
import edu.usmp.fia.taller.elaboracionhorario.dataaccess.interfaces.DAOElaboracionHorario;

public class MysqlElaboracionHorarios extends MySqlDAOFactory implements DAOElaboracionHorario {

	@Override
	public List<Curso> getCursoAll() throws Exception {
		// TODO Auto-generated method stub
		Connection oCn = null;
		PreparedStatement oPs = null;
		ResultSet oRs = null;
		Curso objCurso = null;
		List <Curso> listCurso= new ArrayList<Curso>();
		try {
			oCn = (Connection) MySqlDAOFactory.obtenerConexion();
			oPs = (PreparedStatement) oCn.prepareStatement("SELECT * FROM t_curso");
			oRs = oPs.executeQuery();
			while(oRs.next()) {
				objCurso = new Curso();
				objCurso.setIdCurso(oRs.getInt("id"));
				objCurso.setNombreCurso(oRs.getString("nombre"));
				listCurso.add(objCurso);
			}
			close(oRs);

		} finally {
			close(oRs);
			close(oPs);
			close(oCn);
		}
		return listCurso;

	}

	@Override
	public List<Docente> getProfesoresAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertHorarios(HorariosBean objHor) throws Exception {
		// TODO Auto-generated method stub
		Connection oCn = null;
		PreparedStatement oPs = null;
		ResultSet oRs = null;
		Curso objCurso = null;
		int estado=0;
		int id=0;
		try {
			oCn =(Connection) MySqlDAOFactory.obtenerConexion();
			System.out.println("INSERT INTO t_horario_tmp ('codFac','c01','cicest','tur','codCur','codCurteo','profesor','curso','desRes','codSec','aula','escual','numCre','lunes','martes','miercoles','jueves','viernes','sabado','domingo') VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
			oPs =  (PreparedStatement) oCn.prepareStatement("INSERT INTO t_horario_tmp ('codFac','c01','cicest','tur','codCur','codCurteo','profesor','curso','desRes','codSec','aula','escual','numCre','lunes','martes','miercoles','jueves','viernes','sabado','domingo') VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",Statement.RETURN_GENERATED_KEYS);
			
			oPs.setInt(1, objHor.getCodFac());
			oPs.setInt(2, objHor.getC01());
			oPs.setString(3, objHor.getCicest());
			oPs.setString(4, objHor.getTur());
			oPs.setInt(5, objHor.getCodCur());
			oPs.setInt(6, objHor.getCodCurteo());
			oPs.setString(7, objHor.getProfesor());
			oPs.setString(8, objHor.getCurso());
			oPs.setString(9, objHor.getDesRes());
			oPs.setString(10, objHor.getCodSec());
			oPs.setString(11, objHor.getAula());
			oPs.setString(12, objHor.getEscual());
			oPs.setInt(13, objHor.getNumCre());	
			oPs.setString(14, objHor.getLunes());
			oPs.setString(15, objHor.getMartes());
			oPs.setString(16, objHor.getMiercoles());
			oPs.setString(17, objHor.getJueves());
			oPs.setString(18, objHor.getViernes());
			oPs.setString(19, objHor.getSabado());
			oPs.setString(20, objHor.getDomingo());


			estado=oPs.executeUpdate();
			ResultSet rs=oPs.getGeneratedKeys();
			if(rs.next()){
				id=rs.getInt(1);
			} 
			close(oRs);

		} finally {
			close(oRs);
			close(oPs);
			close(oCn);
		}
		return estado;
	}

	@Override
	public List<String> getHorarioDetalle() throws Exception {
		// TODO Auto-generated method stub
		String query = "SELECT DISTINCT version FROM t_horario_detalle";
		System.out.println(query);
		Connection con = (Connection) MySqlDAOFactory.obtenerConexion();
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		System.out.println("sigo aqui");
		java.util.List<String> versiones = new ArrayList<String>();
		int i = 0;
		while(rs.next())
		{
			versiones.add(rs.getString("version"));
			System.out.println(rs.getString("version"));
			i++;
		}
		close(con);
		return versiones;
	}

	@Override
	public JSONObject getHoraTotales(String cycle,String versionHorario) throws Exception {
		String query = 
				"SELECT tt.name,tt.horas,tt.horasTeoria,tt.horasLaboratorio,tt.horasPractica,tt.id,GROUP_CONCAT(profesor) as profesor FROM ("+
					"SELECT "+
						"CONCAT(i.abreviatura,'-', j.nombre) as name, "+
						"(l.horasTeoria+l.horasLaboratorio+l.horasPractica-(SELECT COUNT(*) FROM t_horario_detalle WHERE curso_seccion_id = i.id AND version = '"+versionHorario+"')) as horas, "+
						"(l.horasTeoria) as horasTeoria, "+
						"(l.horasLaboratorio) as horasLaboratorio, "+
						"(l.horasPractica) as horasPractica, "+
						"e.id, "+
						"CONCAT(k.nombre, ' ',k.apellido_paterno,'=',GROUP_CONCAT(DISTINCT CONCAT(g.id,'-',h.id) SEPARATOR '::')) as profesor "+
					"FROM "+
						"t_ciclo a "+
					"INNER JOIN "+
						"t_plan_curricular_detalle b "+
					"ON "+
						"a.id = b.ciclo_id "+
					"INNER JOIN "+
						"t_curso c "+
					"ON "+
						"c.id = b.curso_id "+
					"INNER JOIN "+
						"t_curso_profesor d "+
					"ON "+
						"d.curso_id = c.id "+
					"INNER JOIN "+
						"t_profesor e "+
					"ON "+
						"d.profesor_id = e.id "+
					"INNER JOIN "+
						"t_disponibilidad_profesor f "+
					"ON "+
						"f.profesor_id = e.id "+
					"INNER JOIN "+
						"t_dia g "+
					"ON "+
						"g.id = f.dia_id "+
					"INNER JOIN "+
						"t_hora h "+
					"ON "+
						"h.id = f.hora_id "+
					"INNER JOIN "+
						"t_curso_seccion i "+
					"ON "+
						"i.curso_id = c.id "+
					"INNER JOIN "+
						"t_seccion j "+
					"ON "+
						"j.id = i.seccion_id "+
					"INNER JOIN "+
						"t_persona k "+
					"ON "+
						"k.id = e.id "+
					"INNER JOIN "+
						"t_plan_curricular_detalle l "+
					"ON "+
						"l.curso_id = c.id "+
					"WHERE "+
						"a.nombre = '"+cycle+"' "+
					"GROUP BY CONCAT(i.abreviatura,' - ', j.nombre, ' ', k.apellido_paterno) "+
					" ORDER BY name ASC ) tt GROUP BY tt.name";
				System.out.println("QUERY: "+query);
				Connection con = (Connection) MySqlDAOFactory.obtenerConexion();
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(query);
				
				Map<String, Object> data = new HashMap<String, Object>();
				int i = 0;
				String secciones = "";
				while(rs.next())
				{	
					if(!secciones.equalsIgnoreCase(rs.getString("name")))
					{
						Map<String, Object> seccion = new HashMap<String, Object>();
						
						String nombreSeccion = rs.getString("name");
						String[] nombresSeccion = nombreSeccion.split("-");
						String nombreCurso = nombresSeccion[0];
						String seccionCurso = nombresSeccion[1];
						
						seccion.put("seccion", rs.getString("name"));
						seccion.put("se", seccionCurso);
						seccion.put("name", nombreCurso);
						seccion.put("horas", rs.getString("horas"));
						
						seccion.put("horasTeoria", rs.getString("horasTeoria"));
						seccion.put("horasLaboratorio", rs.getString("horasLaboratorio"));
						seccion.put("horasPractica", rs.getString("horasPractica"));
						
						String[] profes = rs.getString("profesor").split(",");
						Map<String, Object> teachers = new HashMap<String, Object>();
						for(int iProfe = 0; iProfe < profes.length; ++iProfe)
						{
							Map<String, Object> teacher = new HashMap<String, Object>();
							
							Map<String, Object> disponibilidad = new HashMap<String, Object>();
							String[] disponibilidadProfe = profes[iProfe].split("=");
							String[] disPro = disponibilidadProfe[1].split("::");
							
							for(int iDis = 0; iDis < disPro.length; ++iDis)
							{
								disponibilidad.put(String.valueOf(iDis), disPro[iDis]);
							}
							
							
							teacher.put("nombre", disponibilidadProfe[0]);
							teacher.put("disponibilidad", disponibilidad);
							
							teachers.put(String.valueOf(iProfe), teacher);
						}
						seccion.put("profesores", teachers);
						
						data.put(String.valueOf(i), seccion);
						
						secciones = rs.getString("name");
						
						i++;
					}
				}
				close(con);
			    JSONObject json = new JSONObject();
			    json.put("cursos", data);
			    return json;
	}

	@Override
	public JSONObject getHoras(String cycle,HttpSession sesion) throws Exception {
		// TODO Auto-generated method stub
	  	
	  	String query2 = "SELECT "+
	  						"c.dia_id as dia, "+
	  						"c.hora_id as hora, "+
	  						"CONCAT(d.nombre, ' ', d.apellido_paterno) as nombre, "+
	  						"CONCAT(b.abreviatura,' - ',g.nombre) as curso "+
	  					"FROM "+ 
	  						"t_horario_detalle a "+
	  					"INNER JOIN "+
	  						"t_curso_seccion b "+
	  					"ON "+
	  						"a.curso_seccion_id = b.id "+
	  					"INNER JOIN "+
	  						"t_disponibilidad_profesor c "+
	  					"ON "+
	  						"c.id = disponibilidad_profesor_id "+
	  					"INNER JOIN "+
	  						"t_persona d "+
	  					"ON "+
	  						"d.id = c.profesor_id "+
	  					"INNER JOIN "+
	  						"t_plan_curricular_detalle e "+
	  					"ON "+
	  						"e.curso_id = b.curso_id "+
	  					"INNER JOIN "+
	  						"t_ciclo f "+
	  					"ON "+
	  						"f.id = e.ciclo_id "+
	  					"INNER JOIN "+
	  						"t_seccion g "+
	  					"ON "+
	  						"g.id = b.seccion_id "+
	  					"WHERE "+
	  						"f.nombre = '"+cycle+"' AND a.version = '"+sesion.getAttribute("versionHorario")+"'";
	  	//System.out.print(query2);
	  	System.out.println("QUERY2: "+query2);
	  	Connection con2 = (Connection) MySqlDAOFactory.obtenerConexion();
		Statement stmt2 = con2.createStatement();
		ResultSet rs2 = stmt2.executeQuery(query2);
		
		Map<String, Object> dataHorasResult = new HashMap<String, Object>();
		int i2 = 0;
		while(rs2.next())
		{
			Map<String, Object> dataHoras = new HashMap<String, Object>();
			dataHoras.put("dia", rs2.getString("dia"));
			dataHoras.put("hora", rs2.getString("hora"));
			dataHoras.put("nombre", rs2.getString("nombre"));
			dataHoras.put("curso", rs2.getString("curso"));
			
			dataHorasResult.put(String.valueOf(i2), dataHoras);
			
			i2++;
		}
		close(con2);
		JSONObject json2 = new JSONObject();
		json2.put("horas", dataHorasResult);
		return json2;
	}

	@Override
	public JSONArray getDisponibilidadAula(String[] hArray) throws Exception {
		String query = "SELECT * FROM t_disponibilidad_aula a INNER JOIN t_aula b ON a.aula_id = b.id INNER JOIN t_pabellon c ON c.id = b.pabellon_id WHERE dia_id = "+hArray[0]+" AND hora_id = "+hArray[1];
		//out.print(query);

		Connection con = (Connection) MySqlDAOFactory.obtenerConexion();
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(query);
					
		JSONArray aulas = new JSONArray();
		while(rs.next())
		{
			Map<String, String> detail = new HashMap<String, String>();
			detail.put("id", rs.getString("id"));
			detail.put("data", rs.getString("abreviatura")+"-"+rs.getString("descripcion")+" Cap: "+rs.getString("capacidad"));
			
			aulas.put(detail);
		}
		return aulas;
	}

	@Override
	public void getCargarHorario(String cycle, String versionHorario,JSONArray jsonObject) throws Exception {
		// TODO Auto-generated method stub
		Connection con3= (Connection) MySqlDAOFactory.obtenerConexion();
		Statement stmt3 = con3.createStatement();
		
		String queryDelete = "DELETE FROM t_horario_detalle WHERE curso_seccion_id IN (SELECT b.id FROM t_plan_curricular_detalle a INNER JOIN t_curso_seccion b ON a.curso_id = b.curso_id INNER JOIN t_ciclo c ON c.id = a.ciclo_id WHERE c.nombre = '"+cycle+"') AND version = '"+versionHorario+"'";
		System.out.print(queryDelete);
		stmt3.executeUpdate(queryDelete);
		System.out.println("siso despues del delete");
		String query = "";
		for (int i = 0; i < jsonObject.length(); i++){
		    String datos = (String)jsonObject.get(i);//nombre+'=='+profesoor+'=='+$(this).attr("hora-data");
		    String[] arrayDatos = datos.split("==");
		    String[] arrayHoras = arrayDatos[2].split("-");
		    
		    String buscarCursoSeccion = "SELECT a.id as id FROM t_curso_seccion a INNER JOIN t_seccion b ON a.seccion_id = b.id WHERE CONCAT(a.abreviatura,' - ',b.nombre) = '"+arrayDatos[0]+"'";
			System.out.println("buscarCursoSeccion: "+buscarCursoSeccion);
		    ResultSet rs3 = stmt3.executeQuery(buscarCursoSeccion);
			String idSeccion = "";
			while(rs3.next())
			{
				idSeccion = rs3.getString("id");
			}
			close(con3);
			
			String buscarDisponibilidadProfesor = "SELECT a.id as id FROM t_disponibilidad_profesor a INNER JOIN t_persona b ON a.profesor_id = b.id WHERE CONCAT(b.nombre,' ',b.apellido_paterno) = '"+arrayDatos[1]+"' AND dia_id = '"+arrayHoras[0]+"' AND hora_id = '"+arrayHoras[1]+"'";
			System.out.println(buscarDisponibilidadProfesor);
			ResultSet rs2 = stmt3.executeQuery(buscarDisponibilidadProfesor);
			String idDisponibilidadProfesor = "";
			while(rs2.next())
			{
				idDisponibilidadProfesor = rs2.getString("id");
			}
		    
		    query = "INSERT INTO t_horario_detalle (id, curso_seccion_id, disponibilidad_aula_id, disponibilidad_profesor_id, version) VALUES (1, '"+idSeccion+"', '68', '"+idDisponibilidadProfesor+"', '"+versionHorario+"')";
		    System.out.println(query);
		    stmt3.executeUpdate(query);
		}
	}

}
