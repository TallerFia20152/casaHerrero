package edu.usmp.fia.taller.simulacionMatricula.MySql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

import edu.usmp.fia.taller.common.bean.SimulacionMatricula.Alumno;
import edu.usmp.fia.taller.common.bean.SimulacionMatricula.Area;
import edu.usmp.fia.taller.common.bean.SimulacionMatricula.Curso;
import edu.usmp.fia.taller.common.bean.SimulacionMatricula.Profesor;
import edu.usmp.fia.taller.common.dao.MySqlDAOFactory;
import edu.usmp.fia.taller.simulacionMatricula.interfaces.DAOFactorySMatricula;


public class MySqlFactorySMatricula implements DAOFactorySMatricula {

	private static final String CODIGO_CURSO_INGLESI = "090971";
	private static final String CODIGO_CURSO_INGLESII = "091155";
	
	private Connection con = null;
		
	
	public MySqlFactorySMatricula() {		
		con= (Connection) MySqlDAOFactory.obtenerConexion();		
	}	

	@Override
	public List<Alumno> ListarAlumnos() throws Exception {
		List<Alumno> listado = null;
		StringBuffer sql=null;		
		Alumno alumno=null;
		
		PreparedStatement ps=null;
		ResultSet rs =null;
		try {
			sql=new StringBuffer();
			listado = new ArrayList<Alumno>();
						
			sql.append("SELECT t.id, p.nombre, p.apellido_paterno,p.apellido_materno,p.email ");
			sql.append(" FROM t_alumno t, t_persona p,t_curso_apto ca ");
			sql.append(" WHERE t.id=p.id");
			sql.append(" AND t.id=ca.alumno_id");
			sql.append(" Group by 1");
			sql.append(" Order by 1");			
			
			//if (con==null)
				con = MySqlDAOFactory.obtenerConexion();
			
			ps = con.prepareStatement(sql.toString());
			rs = ps.executeQuery();			
			
			while (rs.next()) 
			{
				alumno= new Alumno();				
				alumno.setCodUSMP(rs.getInt("t.id"));
				alumno.setNombre(rs.getString("p.nombre").toUpperCase());
				alumno.setApPaterno(rs.getString("p.apellido_paterno").toUpperCase());
				alumno.setApMaterno(rs.getString("p.apellido_materno").toUpperCase());
				alumno.setCorreo(rs.getString("p.email"));
				listado.add(alumno);
			}			
			return listado;
			
		} catch (Exception e) {
			System.out.print(e.getMessage());
			System.out.println("Error al listado a todos los alumnos");			
			return null;
		}
		finally
		{			
			LimpiarConexion(con,sql, ps, rs);
			
			if (alumno!=null)
				alumno=null;
			
			if (listado!=null)
				listado=null;		
		}
	}

	@Override
	public List<Curso> ListarCursosAptos(int codAlumno) throws Exception {
		List<Curso> listado = null;
		StringBuffer sql=null;		
		Curso curso =null;
		
		PreparedStatement ps=null;
		ResultSet rs =null;
		try 
		{
			sql=new StringBuffer();
			listado = new ArrayList<Curso>();
						
			sql.append(" Select i.id,a.estado, i.nombre,i.tipo, ci.nombre ,p.creditos ");
			sql.append(" From t_curso_apto a, t_curso i ,t_plan_curricular_detalle p ,t_ciclo ci");
			sql.append(" Where a.curso_id=i.id ");
			sql.append(" And p.curso_id=a.curso_id ");
			sql.append(" And ci.id=p.ciclo_id ");
			sql.append(" And (a.estado='Apto' or a.estado='Repite') ");
			sql.append(" And i.estado= 1 ");
			sql.append(" And a.alumno_id='" + codAlumno + "'");
			sql.append(" Order by ci.id");
			
			System.out.println("SQL SCRIPT ==> " + sql.toString());
			
			if (con==null)
				con = MySqlDAOFactory.obtenerConexion();
			
			ps = con.prepareStatement(sql.toString());
			rs = ps.executeQuery();			
			
			while (rs.next())
			{
				curso= new Curso();				
				curso.setCodigo(rs.getInt("id"));
				curso.setEstado(rs.getString("estado"));
				curso.setCurso(rs.getString("nombre"));
				curso.setCredito(rs.getString("creditos"));
				curso.setCiclo(rs.getString("ci.nombre"));
				curso.setTipoCurso(rs.getString("tipo"));				
				listado.add(curso);
			}
			
			return listado;
			
		} catch (Exception e) {
			System.out.print(e.getMessage());			
			return null;
		}
		finally
		{					
			LimpiarConexion(con, sql, ps, rs);
			
			if (listado!=null)
				listado=null;
			
		}
	}

	@Override
	public List<Curso> ListarCursoObligatorios(int codAlumno) throws Exception {
		List<Curso> listado = null;
		StringBuffer sql=null;		
		Curso curso =null;
		
		PreparedStatement ps=null;
		ResultSet rs =null;
		
		try 
		{
			sql=new StringBuffer();
			listado = new ArrayList<Curso>();
								
			sql.append(" Select i.id,a.estado, i.nombre,i.tipo, p.ciclo_id,p.creditos ");
			sql.append(" From t_curso_apto a, t_curso i ,t_plan_curricular_detalle p ");
			sql.append(" Where a.curso_id=i.id ");
			sql.append(" And p.curso_id=a.curso_id ");
			sql.append(" And a.estado='Repite' ");
			sql.append(" And i.estado= 1 ");
			sql.append(" And a.alumno_id='" + codAlumno + "' ");
			sql.append(" Order by tipo desc ");
			
			if (con==null)
				con=MySqlDAOFactory.obtenerConexion();	
			
			ps = con.prepareStatement(sql.toString());
			rs = ps.executeQuery();			
			
			while (rs.next())
			{
				curso= new Curso();				
				curso.setCodigo(rs.getInt("id"));
				curso.setEstado(rs.getString("estado"));
				curso.setCurso(rs.getString("nombre"));
				curso.setCredito(rs.getString("creditos"));
				curso.setCiclo(rs.getString("ciclo_id"));
				curso.setTipoCurso(rs.getString("tipo"));
				listado.add(curso);
			}
			
			return listado;
			
		} catch (Exception e) {
			System.out.print(e.getMessage());
			throw new Exception("Error al listado a todos los alumnos");			
			//return null;
		}
		finally
		{			
			LimpiarConexion(con, sql, ps, rs);
			
			if (listado!=null)
				listado=null;
			
		}
	}
	

	@Override
	public List<Curso> ListarCursoCantAlumno() throws Exception {
		List<Curso> listado = null;
		StringBuffer sql=null;
		Curso curso =null;
		PreparedStatement ps=null;
		ResultSet rs =null;
		
		try 
		{
			sql=new StringBuffer();
			listado = new ArrayList<Curso>();
						
			sql.append(" Select distinct a.curso_id as codigo ,c.nombre ,c.tipo ");
			sql.append(" From t_curso_apto a, t_curso c ");
			sql.append(" where c.id=a.curso_id ");
			sql.append(" order by 1");
			
			//if (con==null)
				//con=MySqlDAOFactory.obtenerConexion();	
			
			ps = con.prepareStatement(sql.toString());
			rs = ps.executeQuery();			
			
			while (rs.next())
			{
				curso= new Curso();				
				curso.setCodigo(rs.getInt("codigo"));
				curso.setCurso(rs.getString("nombre"));
				curso.setTipoCurso(rs.getString("tipo").toUpperCase());				
				
				listado.add(curso);
			}

			return listado;
			
		} catch (Exception e) {
			System.out.print(e.getMessage());
			System.out.println("Error al listar");
			return null;
		}
		finally
		{
			LimpiarConexion(con, sql, ps, rs);
			
			if (listado!=null)
				listado=null;
			
		}
	}

	@Override
	public Curso ListarDetalleCurso(String codigo) throws Exception {
		
		StringBuffer sql=null;

		Curso curso =null;
		Profesor profesor=null;
		ArrayList<Profesor> listaProfesor=null;
		PreparedStatement ps=null;
		ResultSet rs =null;
		
		try 
		{
			sql=new StringBuffer();
						
			sql.append(" SELECT cu.id,cu.nombre,pcd.creditos,cu.tipo,ci.nombre,cc.nombre, ");
			sql.append(" pcd.horasTeoria,pcd.horasLaboratorio,pcd.horasPractica, ");			
			sql.append(" pe.apellido_Paterno,pe.apellido_Materno,pe.nombre");			
			sql.append(" FROM bd_taller_proyectos.t_plan_curricular_detalle pcd ");
			sql.append(" Inner join bd_taller_proyectos.t_curso cu  ");
			sql.append(" Inner join bd_taller_proyectos.t_ciclo ci ");
			sql.append(" Inner join bd_taller_proyectos.t_curso_condicion cc ");
			sql.append(" Inner join bd_taller_proyectos.t_curso_profesor cp ");
			sql.append(" Inner join bd_taller_proyectos.t_profesor p ");
			sql.append(" Inner join bd_taller_proyectos.t_persona pe ");			
			sql.append(" On pcd.curso_id=cu.id ");
			sql.append(" And pcd.ciclo_id=ci.id ");
			sql.append(" And pcd.curso_condicion_id=cc.id ");
			sql.append(" And pcd.curso_id=cp.curso_id ");
			sql.append(" And cp.profesor_id=p.id ");
			sql.append(" And pe.id=p.id ");			
			sql.append(" Where cu.id=" + codigo );
			
			System.out.println("LA QUERY => " + sql.toString());
			
			if (con==null)
				con=MySqlDAOFactory.obtenerConexion();	

			ps = con.prepareStatement(sql.toString());
			rs = ps.executeQuery();

			curso = new Curso();			
			listaProfesor= new ArrayList<>();

			while (rs.next()) {				
				System.out.println("Ingeso cargar datos del profesor");
				profesor= new Profesor();
				// DATOS DEL PROFESOR
				profesor.setNombre(rs.getString("pe.nombre"));
				profesor.setApMaterno(rs.getString("pe.apellido_Materno"));
				profesor.setApPaterno(rs.getString("pe.apellido_Paterno"));				
				listaProfesor.add(profesor);
							
				curso = new Curso();
				
				//DATOS DE LOS CURSOS
				curso.setCodigo(rs.getInt("cu.id"));
				curso.setCredito(rs.getString("pcd.creditos"));
				curso.setCurso(rs.getString("cu.nombre"));
				curso.setCiclo(rs.getString("ci.nombre"));
				curso.setTipoCurso(rs.getString("cu.tipo"));
				curso.setCondicion(rs.getString("cc.nombre"));				
				curso.setHorasTeoria(rs.getString("pcd.horasTeoria"));
				curso.setHorasLaboratorio(rs.getString("pcd.horasLaboratorio"));
				curso.setHorasPractica(rs.getString("pcd.horasPractica"));				
			}
			
			curso.setProfesor(listaProfesor);
			System.out.println("RETORNA CURSO Y PROFESORES");
			return curso;
		} catch (Exception e) {
			System.out.print("Error al Listar Detalle Curso  " + e.getMessage());
			return null;
		}
		finally
		{
			LimpiarConexion(con, sql, ps, rs);
			
			if (listaProfesor!=null)
				listaProfesor=null;
			
			if (curso!=null)
				curso=null;
			
			if (profesor!=null)
				profesor=null;			
		}
	}

	@Override
	public List<Area> SimulacionCursosPreferidos() throws Exception {
		
		StringBuffer sql =null;
		List<Area> listaArea = null;
		
		Area area = null;
		Curso curso = null;		
				
		PreparedStatement ps=null;
		ResultSet rs =null;
		
		try {
			sql=new StringBuffer();
			
			sql.append("SELECT ca.nombre as area, cu.id as cod_curso, cu.nombre as nom_curso, count(*) as cantidad ");
			sql.append("FROM t_pre_matricula pm  ");
			sql.append("INNER JOIN t_pre_matricula_detalle pmd ");
			sql.append("INNER JOIN t_curso cu ");
			sql.append("INNER JOIN t_plan_curricular_detalle pcd ");
			sql.append("INNER JOIN t_curso_area ca ");
			sql.append("ON pm.id=pmd.id and pmd.curso_id=cu.id and cu.id=pcd.curso_id and pcd.curso_area_id=ca.id ");
			sql.append("WHERE pm.semestre_id='4' ");			
			sql.append("GROUP BY ca.nombre, cu.id, cu.nombre ");
			
			if (con==null)
				con=MySqlDAOFactory.obtenerConexion();	
			
			ps = con.prepareStatement(sql.toString());
			rs = ps.executeQuery();

			boolean crearListaArea = true;

			while (rs.next()) {
				if (crearListaArea) {
					listaArea = new ArrayList<>();
					crearListaArea = false;
				}

				area = new Area();
				area.setNombre(rs.getString("area"));

				curso = new Curso();
				curso.setCodigo(rs.getInt("cod_curso"));
				curso.setCurso(rs.getString("nom_curso"));
				curso.setCantidadAlumnos(Integer.parseInt(rs.getString("cantidad")));

				boolean areaInList = false;
				if (listaArea.size() == 0) {
					area.setCursoList(new ArrayList<Curso>());
					area.getCursoList().add(curso);
					listaArea.add(area);
				} else {
					for (Area datoArea : listaArea) {
						if (area.getNombre().equalsIgnoreCase(datoArea.getNombre())) 
						{
							datoArea.getCursoList().add(curso);
							areaInList = true;
							break;
						}
					}
					if (!areaInList) {
						area.setCursoList(new ArrayList<Curso>());
						area.getCursoList().add(curso);
						listaArea.add(area);
					}
				}
			}
			ordenarXArea(listaArea);
			return listaArea;
		} catch (Exception e) {
			System.out.println("ERROR SIMULACION CURSOS PREFERIDOS" + e.getMessage());
			return null;
		}
		finally
		{
			LimpiarConexion(con, sql, ps, rs);
			
			if (area!=null)
				area=null;
			
			if (curso!=null)
				curso=null;
			
			if (listaArea!=null)
				listaArea=null;		
		}
	} 
	
	private void ordenarXArea(List<Area> areaList){
		if(areaList!=null){
			if(areaList.size()!=0){
				for(int i=0;i<areaList.size()-1;i++){
					for(int j=i+1;j<areaList.size();j++){
						if(areaList.get(i).getNombre().compareToIgnoreCase(areaList.get(j).getNombre()) > 0 ){
							areaList.add(j+1, areaList.get(i));
							areaList.remove(i);
							areaList.add(i, areaList.get(j-1));
							areaList.remove(j);
						}
					}
				}
				for(Area area:areaList){
					ordenarXCurso(area.getCursoList());
				}
			}
		}		
	}
			
	private void ordenarXCurso(List<Curso> cursoList){
		if(cursoList!=null){
			if(cursoList.size()!=0){
				for(int i=0;i<cursoList.size()-1;i++){
					for(int j=i+1;j<cursoList.size();j++){
						if(cursoList.get(i).getCurso().compareToIgnoreCase(cursoList.get(j).getCurso()) > 0 ){
							cursoList.add(j+1, cursoList.get(i));
							cursoList.remove(i);
							cursoList.add(i, cursoList.get(j-1));
							cursoList.remove(j);
						}
					}
				}
			}
		}
	}
	
	
	@Override
	public List<Area> SimulacionIncial() throws Exception {
		
		StringBuffer query = null;
		Connection con = null;		
		PreparedStatement ps=null;
		ResultSet rs =null;
		
		List<Area> listadoArea=null;
		try {		
			query = new StringBuffer();
			
			query.append("SELECT cap.nombre as area ,cu.id as cod_curso ,cu.nombre as nom_curso,count(cu.id) as cuenta ");
			query.append("FROM t_curso_apto ca ");
			query.append("INNER JOIN t_curso cu ON ca.curso_id = cu.id ");
			query.append("INNER JOIN t_plan_curricular_detalle pc ON cu.id = pc.curso_id ");
			query.append("INNER JOIN t_curso_area cap ON pc.curso_area_id = cap.id ");
			query.append("WHERE  pc.curso_condicion_id = 1 or pc.curso_condicion_id = 2 or pc.curso_condicion_id = 3 ");
			query.append("GROUP BY cu.id ");
			query.append("ORDER BY cap.id ");
			

			if (con==null)
				con=MySqlDAOFactory.obtenerConexion();	
			
			ps = con.prepareStatement(query.toString());
			rs = ps.executeQuery();

			List<Area> returnSimulacionAreaList = null;
			boolean createBeanSimulacionAreaList = true;
			Area simulacionAreaBean = null;
			Curso simulacionCursoBean = null;

			while (rs.next()) {
				if (createBeanSimulacionAreaList) {
					returnSimulacionAreaList = new ArrayList<>();
					createBeanSimulacionAreaList = false;
				}
				simulacionAreaBean = new Area();
				simulacionAreaBean.setNombre(rs.getString("area"));

				simulacionCursoBean = new Curso();
				simulacionCursoBean.setCodigo(rs.getInt("cod_curso"));
				simulacionCursoBean.setCurso(rs.getString("nom_curso"));
				simulacionCursoBean.setCantidadAlumnos(Integer.parseInt(rs.getString("cuenta")));

				boolean areaInList = false;
				if (returnSimulacionAreaList.size() == 0) {
					simulacionAreaBean.setCursoList(new ArrayList<Curso>());
					simulacionAreaBean.getCursoList().add(simulacionCursoBean);
					returnSimulacionAreaList.add(simulacionAreaBean);
				} else {
					for (Area returnSimulacionAreaBean : returnSimulacionAreaList) {
						if (simulacionAreaBean.getNombre().equalsIgnoreCase(
								returnSimulacionAreaBean.getNombre())) {
							returnSimulacionAreaBean.getCursoList().add(
									simulacionCursoBean);
							areaInList = true;
							break;
						}
					}
					if (!areaInList) {
						simulacionAreaBean
								.setCursoList(new ArrayList<Curso>());
						simulacionAreaBean.getCursoList().add(simulacionCursoBean);
						returnSimulacionAreaList.add(simulacionAreaBean);
					}
				}
			}
			ordenarXArea(returnSimulacionAreaList);
			return returnSimulacionAreaList;
		} catch (Exception e) {
			System.out.println("ERROR AL GENERAR LA SIMULACION GENERAL - INICIAL");
			return null;
		}
		finally 
		{
			LimpiarConexion(con, query, ps, rs);
			
			if (listadoArea!=null)
					listadoArea=null;
		}
	}
	@Override
	public List<Curso> CursosPreferibles(int codigoAlumno) throws Exception {			
		List<Curso> listaCurso = null;
		Curso cursoAlumno = null;
				
		PreparedStatement ps=null;
		ResultSet rs =null;
		StringBuffer sql=null;
		
		try {
			
			System.out.println("SCRIPT NUEVO");
			sql= new StringBuffer();
			
			sql.append("SELECT cu.id as cod_curso ,cu.nombre as nom_curso, ca.estado as estado,");
			sql.append(" pc.ciclo_id, cap.nombre as area, pc.creditos,cu.estado");
			sql.append(" FROM t_pre_matricula_alumno pma ,t_curso cu,t_plan_curricular_detalle pc ");			
			sql.append(" WHERE pma.alumno_id= "+ codigoAlumno);
			sql.append(" AND ca.curso_id = cu.id");			
			sql.append(" AND cu.id = pc.curso_id ");
						
			System.out.println("QUERY SCRIPT PREFERIBLE => " + sql.toString());
			
			con=MySqlDAOFactory.obtenerConexion();
			
			ps = con.prepareStatement(sql.toString());
			rs = ps.executeQuery();
			
			listaCurso = new ArrayList<Curso>();
			
			while (rs.next()) {
				cursoAlumno = new Curso();
				cursoAlumno.setCodigo(rs.getInt("cod_curso"));
				cursoAlumno.setCurso(rs.getString("nom_curso"));
				cursoAlumno.setCredito(rs.getString("creditos"));
				cursoAlumno.setEstado(rs.getString("estado"));
				listaCurso.add(cursoAlumno);
			}
				
			return listaCurso;	
			
		} catch (Exception e) {
			System.out.println("ERROR SIMULACION INICIAL");
			return null;
		}
		finally 
		{
			LimpiarConexion(con, sql, ps, rs);			
		}
	}
	
	
	@Override
	public List<Curso> CursosProbables(int codigoAlumno) throws Exception {			
		List<Curso> listaCurso = null;
		Curso cursoAlumno = null;
				
		PreparedStatement ps=null;
		ResultSet rs =null;
		StringBuffer query=null;
		
		try {
			
			System.out.println("SCRIPT NUEVO");
			
			query = new StringBuffer();
			query.append("SELECT cu.id as cod_curso ,cu.nombre as nom_curso, ca.estado as estado, pc.ciclo_id, cap.nombre as area, pc.creditos,cu.estado");
			query.append(" FROM t_curso_apto ca ");
			query.append(" INNER JOIN t_curso cu ON ca.curso_id = cu.id ");
			query.append(" INNER JOIN t_plan_curricular_detalle pc ON cu.id = pc.curso_id ");
			query.append(" INNER JOIN t_curso_area cap ON pc.curso_area_id = cap.id ");
			query.append(" WHERE ca.alumno_id=" + codigoAlumno + " " );
			query.append(" And ( pc.curso_condicion_id = 1 OR pc.curso_condicion_id = 2 or pc.curso_condicion_id = 3) ");
			query.append(" ORDER BY ca.estado desc, pc.ciclo_id asc, cap.id asc,  pc.creditos asc");
			
			System.out.println("QUERY SCRIPT => " + query.toString());
			
			con=MySqlDAOFactory.obtenerConexion();
			
			ps = con.prepareStatement(query.toString());
			rs = ps.executeQuery();
			
			listaCurso = new ArrayList<Curso>();
			
			while (rs.next()) {
				cursoAlumno = new Curso();
				cursoAlumno.setArea(rs.getString("area"));
				cursoAlumno.setCodigo(rs.getInt("cod_curso"));
				cursoAlumno.setCurso(rs.getString("nom_curso"));
				cursoAlumno.setCredito(rs.getString("creditos"));
				cursoAlumno.setEstado(rs.getString("estado"));
				listaCurso.add(cursoAlumno);
				listaCurso = FiltrarCursoXCredito(listaCurso);
			}
				
			return listaCurso;	
			
		} catch (Exception e) {
			System.out.println("ERROR SIMULACION INICIAL");
			return null;
		}
		finally 
		{
			LimpiarConexion(con, query, ps, rs);			
		}
	}
	
	public List<Curso> FiltrarCursoXCredito(List<Curso> listaCursos) throws Exception {
		List<Curso> lista=new ArrayList<>();
		int credito=0;
		
		for( Curso curso : listaCursos)
		{
			switch (Integer.toString(curso.getCodigo())) {
			case CODIGO_CURSO_INGLESI:
				lista.add(curso);
				break;
			case CODIGO_CURSO_INGLESII:
				lista.add(curso);
				break;
			default:
				if (credito + Integer.parseInt(curso.getCredito())<=22)
				{
					credito+=Integer.parseInt(curso.getCredito());
					lista.add(curso);
				}
				break;
			}
		}
		return lista;
	}

	@Override
	public List<Area> SimulacionConcluyente() throws Exception {

		PreparedStatement ps=null;
		ResultSet rs =null;
		StringBuffer query=null;
		
		try {
		
			List<Alumno> alumnoIdList = ListarAlumnos();
			
			List<Area> returnAreaList = null;
			boolean createReturnAreaList = true;
			Area returnArea = null;

			List<Curso> cursoAlumnoList = null;
			boolean createCursoAlumnoList = true;
			Curso cursoAlumno = null;
			
			Integer cicloAlumno = null;

			for (Alumno alumno : alumnoIdList) {
				cicloAlumno = ObtenerCicloAlumno(alumno.getCodUSMP());
				
				cursoAlumnoList = null;
				cursoAlumno = null;
				createCursoAlumnoList = true;
							
				query = new StringBuffer();
				query.append("SELECT cu.id as cod_curso ,cu.nombre as nom_curso, ca.estado as estado, pc.ciclo_id, cap.nombre as area, pc.creditos ");
				query.append(" FROM t_curso_apto ca ");
				query.append(" INNER JOIN t_curso cu ON ca.curso_id = cu.id ");
				query.append(" INNER JOIN t_plan_curricular_detalle pc ON cu.id = pc.curso_id ");
				query.append(" INNER JOIN t_curso_area cap ON pc.curso_area_id = cap.id ");
				query.append(" WHERE ca.alumno_id="+ alumno.getCodUSMP() );
				query.append(" And (pc.curso_condicion_id = 1 OR pc.curso_condicion_id = 2 or pc.curso_condicion_id = 3) ");
				query.append(" ORDER BY ca.estado desc, pc.ciclo_id asc, cap.id asc,  pc.creditos desc");
				
				if (con==null)
					con=MySqlDAOFactory.obtenerConexion();
				
				System.out.println("SCRIPT "+ query);
				
				ps = con.prepareStatement(query.toString());
				rs = ps.executeQuery();				

				
				while (rs.next()) {
					if (createCursoAlumnoList) {
						cursoAlumnoList = new ArrayList<>();
						createCursoAlumnoList = false;
					}
					System.out.println("ASIGNA VALORES");
					
					cursoAlumno = new Curso();
					cursoAlumno.setArea(rs.getString("area"));
					cursoAlumno.setCodigo(rs.getInt("cod_curso"));
					cursoAlumno.setCurso(rs.getString("nom_curso"));
					cursoAlumno.setCredito(rs.getString("creditos"));
					cursoAlumno.setCuenta(1);
					cursoAlumnoList.add(cursoAlumno);					
					cursoAlumnoList = FiltrarCursoXCredito(cursoAlumnoList); 
					System.out.println("SALIO FILTRAR X ALUMNO");
				}
				
				LimpiarConexion(con, query, ps, rs);
				
				System.out.println("datos de la lista de Alumnos " + cursoAlumnoList);
				if (cursoAlumnoList!=null)
				{
					for (Curso curso : cursoAlumnoList) {
						
						System.out.println("AREA" + curso.getArea());
						System.out.println("CODIGO" + curso.getCodigo());
						System.out.println("CURSO" + curso.getCurso());
						System.out.println("CREDITO" + curso.getCredito());
					}
				}
				if (cursoAlumnoList != null) {
					if (createReturnAreaList) {
						returnAreaList = new ArrayList<>();
						createReturnAreaList = false;
					}

					for (Curso curso : cursoAlumnoList) {
						Curso cursoSeccion = ObtenerCursoSeccion(Integer.toString(curso.getCodigo()), cicloAlumno);
						
						if(cursoSeccion!=null){
							curso.setSeccion(cursoSeccion.getSeccion());
							curso.setCantidadAlumnos(cursoSeccion.getCantidadAlumnos());
							curso.setTurno(cursoSeccion.getTurno());
							returnArea = new Area();
							returnArea.setNombre(curso.getArea());
							boolean areaInList = false;
							if (returnAreaList.size() == 0) {
								returnArea.setCursoList(new ArrayList<Curso>());
								returnArea.getCursoList().add(curso);
								returnAreaList.add(returnArea);
							} else {
								for (Area area : returnAreaList) {
									boolean cursoInArea = false;
									if (returnArea.getNombre().equalsIgnoreCase(area.getNombre())) {
										for (Curso cursoArea : area.getCursoList()) {
											if (curso.getCodigo()==cursoArea.getCodigo() &&
												curso.getSeccion().equalsIgnoreCase(cursoArea.getSeccion())) {
												cursoArea.setCuenta(cursoArea.getCuenta() + 1);
												cursoInArea = true;
												break;
											}
										}
										if (!cursoInArea) {
											area.getCursoList().add(curso);
										}
										areaInList = true;
										break;
									}
								}
								if (!areaInList) {
									returnArea.setCursoList(new ArrayList<Curso>());
									returnArea.getCursoList().add(curso);
									returnAreaList.add(returnArea);
								}
							}
						}
					}
				}
			}
			System.out.println("ENVIA A ORDENAR");
			ordenarXArea(returnAreaList);
			return returnAreaList;			
			
		} catch (Exception e) {
			System.out.println("ERROR AL OBTENER LA SIMULACION CONCLUYENTE   => "+ e.getMessage());
			return null;
		}
		finally 
		{
			LimpiarConexion(con, query, ps, rs);		
		}
		
	}
	
	private Integer ObtenerCicloAlumno(Integer alumnoId) throws Exception {
				
		PreparedStatement ps=null;
		ResultSet rs =null;
		StringBuffer query=null;
		
		try {
			
			Integer cicloAlumno=0;
			
			query = new StringBuffer();
			
			query.append("SELECT SUM(pcd.creditos) as creditos ");
			query.append("FROM t_alumno a ");
			query.append("INNER JOIN t_pre_matricula pm  ON a.id = pm.alumno_id ");
			query.append("INNER JOIN t_matricula m  ON pm.id = m.pre_matricula_id ");
			query.append("INNER JOIN t_matricula_detalle md ON m.id = md.id ");
			query.append("INNER JOIN t_curso c ON md.curso_id = c.id ");
			query.append("INNER JOIN t_plan_curricular_detalle pcd ON c.id = pcd.curso_id ");
			query.append("WHERE pm.alumno_id = ? and md.promedio_final >= 10.5");
			
			
			if (con==null)
				con=MySqlDAOFactory.obtenerConexion();
			
			ps = con.prepareStatement(query.toString());
			ps.setInt(1,alumnoId);
			rs = ps.executeQuery();
						
			if (rs.next()) {
				if(rs.getString("creditos") !=null){
					Integer numeroCreditos = Integer.parseInt(rs.getString("creditos"));
					if(numeroCreditos<=23){
						cicloAlumno = 1;
					}else if(numeroCreditos<=46){
						cicloAlumno = 2;
					}else if(numeroCreditos<=68){
						cicloAlumno = 3;
					}else if(numeroCreditos<=90){
						cicloAlumno = 4;
					}else if(numeroCreditos<=112){
						cicloAlumno = 5;
					}else if(numeroCreditos<=134){
						cicloAlumno = 6;
					}else if(numeroCreditos<=156){
						cicloAlumno = 7;
					}else if(numeroCreditos<=178){
						cicloAlumno = 8;
					}else if(numeroCreditos<=200){
						cicloAlumno = 9;
					}else{
						cicloAlumno = 10;
					}
				}
			}
			return cicloAlumno;
			
		} catch (Exception e) {
			System.out.println("ERROR AL OBTENER EL CICLO DEL ALUMNO   => "+ e.getMessage());
			return 0;
		}
		finally 
		{
			LimpiarConexion(con, query, ps, rs);
		}
	}
	
	private Curso ObtenerCursoSeccion(String cursoId, Integer cicloAlumno) throws Exception {
				
		PreparedStatement ps=null;
		ResultSet rs =null;
		StringBuffer query=null;
		
		try {
			
			query = new StringBuffer();
			query.append("SELECT c.id as cod_curso ,c.nombre as nom_curso, ca.nombre as nom_area, s.nombre as seccion, a.capacidad as capacidad, h.turno as turno ");
			query.append("FROM t_curso c ");
			query.append("INNER JOIN t_plan_curricular_detalle pcd on c.id = pcd.curso_id ");
			query.append("INNER JOIN t_curso_area ca on pcd.curso_area_id = ca.id ");
			query.append("INNER JOIN t_curso_seccion cs on c.id = cs.curso_id ");
			query.append("INNER JOIN t_seccion s on cs.seccion_id = s.id ");
			query.append("INNER JOIN t_horario_detalle hd on cs.id = hd.curso_seccion_id ");
			query.append("INNER JOIN t_disponibilidad_aula da on hd.disponibilidad_aula_id = da.id ");
			query.append("INNER JOIN t_aula a on da.aula_id = a.id ");
			query.append("INNER JOIN t_hora h on da.hora_id = h.id ");
			query.append("WHERE c.id ="+ cursoId + " and da.estado = 'Disponible' and s.estado = '1' ");
			query.append("GROUP BY c.id,c.nombre,ca.nombre,s.nombre,a.capacidad,h.turno ");
			
			if (con==null)
				con=MySqlDAOFactory.obtenerConexion();
			
			ps = con.prepareStatement(query.toString());
			rs = ps.executeQuery();
			
			List<Curso> cursoSeccionList = null;
			Curso cursoSeccion = null;
			boolean createCursoSeccionList = true;
			
			while (rs.next()) {
//				System.out.println("----------->"+rs.getString("seccion"));
				if(rs.getString("seccion")!=null){
					if(createCursoSeccionList){
						cursoSeccionList = new ArrayList<>();
						createCursoSeccionList = false;
					}
					cursoSeccion = new Curso();
					cursoSeccion.setSeccion(rs.getString("seccion"));
					cursoSeccion.setCantidadAlumnos(rs.getInt("capacidad"));
					cursoSeccion.setTurno(rs.getString("turno"));
					cursoSeccionList.add(cursoSeccion);
				}
			}
			
			if(cursoSeccionList != null){

				if(cicloAlumno<=5){
					for(Curso curso :cursoSeccionList){
						if(curso.getTurno().equalsIgnoreCase("Ma�ana") || curso.getTurno().equalsIgnoreCase("Ma�ana")){
							return curso;
						}
					}
					for(Curso curso :cursoSeccionList){
						if(curso.getTurno().equalsIgnoreCase("Tarde")){
							return curso;
						}
					}
					for(Curso curso :cursoSeccionList){
						if(curso.getTurno().equalsIgnoreCase("Noche")){
							return curso;
						}
					}
				}else{
					for(Curso curso :cursoSeccionList){
						if(curso.getTurno().equalsIgnoreCase("Tarde")){
							return curso;
						}
					}
					for(Curso curso :cursoSeccionList){
						if(curso.getTurno().equalsIgnoreCase("Noche")){
							return curso;
						}
					}
					for(Curso curso :cursoSeccionList){
						if(curso.getTurno().equalsIgnoreCase("Ma�ana") || curso.getTurno().equalsIgnoreCase("Ma�ana")){
							return curso;
						}
					}
				}
			}			
			return null;
			
		} catch (Exception e) {
			return null;
		}
		finally 
		{
			LimpiarConexion(con, query, ps, rs);
		}
	}

	@Override
	public List<Curso> ListarPreMatricula(int codigoAlumno) throws Exception {
		List<Curso> listado = null;
		StringBuffer sql=null;		
		Curso curso=null;
		
		PreparedStatement ps=null;
		ResultSet rs =null;
		
		try 
		{
			sql=new StringBuffer();
			listado = new ArrayList<Curso>();
						
			sql.append("SELECT p.id_curso,c.nombre,p.seccion");
			sql.append(" FROM t_pre_matricula m, t_pre_matricula_detalle p, t_curso c ");
			sql.append(" WHERE m.correlativo=p.correlativo");
			sql.append(" And m.alumno_id="+ codigoAlumno);
			sql.append(" and p.id_curso=c.id");			
			
			if (con==null)
				con=MySqlDAOFactory.obtenerConexion();
			
			ps = con.prepareStatement(sql.toString());
			rs = ps.executeQuery();			
			
			while (rs.next()) 
			{
				curso= new Curso();				
				curso.setCodigo(rs.getInt("id_curso"));
				curso.setCurso(rs.getString("nombre"));	
				curso.setSeccion(rs.getString("seccion"));
				listado.add(curso);
			}			
			return listado;
			
		} catch (Exception e) {
			System.out.print(e.getMessage());
			System.out.println("Error al listado a todos los alumnos");			
			return null;
		}
		finally
		{
			LimpiarConexion(con, sql, ps, rs);
			
			if (curso!=null)
				curso=null;
			
			if (listado!=null)
				listado=null;		
		}
	}

	@Override
	public boolean GenerarPreMatricula(String codAlumno, String[] codCurso) throws Exception {

		StringBuffer sql=null;		
		PreparedStatement ps=null;
		ResultSet rs =null;
		boolean generar = false;
		try {
			String semestre="4";
			sql=new StringBuffer();		
			
			if (con==null)
				con=MySqlDAOFactory.obtenerConexion();
			
			generar=false;
			
			//INICIAR TRANSACCION
			con.setAutoCommit(false);
			
			Timestamp fecha =ObtenerFechaActual();
		    
		    //INSERTAR PRE_MATRICULA	
			sql= new StringBuffer();	
			sql.append("INSERT INTO t_pre_matricula(alumno_id,semestre_id,fecha_creacion)");
			sql.append(" VALUES('"+codAlumno + "',"+ semestre +","+fecha );
			
			ps = con.prepareStatement(sql.toString());
			int filaMatricula = ps.executeUpdate();
			
			if (filaMatricula==0)
			{
				con.rollback();
				return false;
			}
				

			if (generar)
				con.commit();						
			
			return true;
			
		} catch (Exception e) {
			con.rollback();
			System.out.print(e.getMessage());
			throw new Exception("Error al listado a todos los alumnos");			
			//return null;
		}
		finally
		{
			LimpiarConexion(con, sql, ps, rs);					
		}
	}
	
	private boolean crearPreMatriculaDetalle(int ultimo, String codigoCurso)
			throws Exception {
		boolean flag = false;
		try {
			/*
			int fila = stmt.executeUpdate("insert into "
							+ " t_pre_matricula_detalle (id,curso_id)"
							+ " values ('" + ultimo + "','" + codigoCurso
							+ "')");

			if (fila == 1) {
				flag = true;
			}
			 */
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}

		return flag;
	}

	private int ultimoID() throws Exception {
		int ultimo = 0;
		try {
			
			/*
			ResultSet rs = stmt.executeQuery("SELECT MAX(ID) AS ultimo FROM t_pre_matricula;");

			if (rs.next()) {
				ultimo = rs.getInt("ultimo");
			}
			*/
			return ultimo;

		} catch (Exception e) {
			System.out.print(e.getMessage());
			return 0;
		}
		finally
		{
			
		}

		
	}
	
	private Timestamp ObtenerFechaActual()
	{
		Calendar calendar = Calendar.getInstance();
	    Timestamp fecha = new java.sql.Timestamp(calendar.getTime().getTime());
	    
	    return fecha;
	}

	private void LimpiarConexion(Connection con, StringBuffer sql,PreparedStatement ps, ResultSet rs) throws Exception
	{
		try {
			
			if (con!=null && !con.isClosed())
			{
				MySqlDAOFactory.close(con); con = null;
			}
			
			if (sql!=null)
				sql=null;
			
			if (ps!=null && !ps.isClosed())
			{
				MySqlDAOFactory.close(ps); ps = null;
			}
				
			if (rs!=null && !rs.isClosed())
			{
				MySqlDAOFactory.close(rs); rs = null;
			}
		} catch (Exception e) {
			System.out.println("Error al limpiar Conexion" + e.getMessage());
		}
	}

	@Override
	public List<Area> SimulacionProbable() throws Exception {

		List<Alumno> listaAlumno= null;
		List<Area> listaArea=null;
			
		try {
		
			List<Curso> listaCursoProbables=new ArrayList<>();
			listaAlumno= ListarAlumnos();
			
			listaArea= ObtenerAreaCursos();
			
			//Area areaTemporal= new Area();
			Curso cursoTemporal= null;
			
			int cantidadAlumnos=0;
			
			for(Alumno alumno : listaAlumno)
			{
				listaCursoProbables=CursosProbables(alumno.getCodUSMP());
				
				for(Area area:listaArea)
				{
					for(int i=0;i<area.getCursoList().size();i++)
					{
						for(int j=0;j<listaCursoProbables.size();j++)
						{
							if(area.getCursoList().get(i).getCodigo()==listaCursoProbables.get(j).getCodigo())
							{
								System.out.println("CANTIDAD");
								cantidadAlumnos=area.getCursoList().get(i).getCantidadAlumnos()+1;
								cursoTemporal= new Curso();
								cursoTemporal=area.getCursoList().get(i);
								cursoTemporal.setCantidadAlumnos(cantidadAlumnos);
								
								Collections.replaceAll(area.getCursoList(),area.getCursoList().get(i) ,cursoTemporal);
							
							}
						}	
						
					}					
				}
			}	
			
			return listaArea;
			
		} catch (Exception e) {
			System.out.println("ERROR SIMULACION INICIAL");
			return null;
		}				
	}
	
	private List<Area> ObtenerAreaCursos() throws Exception
	{
		PreparedStatement ps=null;
		ResultSet rs =null;
		StringBuffer query=null;
		
		List<Area > listaArea=null;
		List<Area > listaAreaEnvio=null;
		List<Curso> listaCurso=null;
		Curso curso=null;
		
		try 
		{						
			listaArea= ObtenerArea();
			listaAreaEnvio= new ArrayList<Area>();
			
			for(Area area:listaArea)
			{				
				query = new StringBuffer();
				query.append("SELECT ca.nombre, d.curso_id,t.nombre ");
				query.append(" FROM t_plan_curricular_detalle d , t_curso_area ca, t_curso t ");
				query.append(" WHERE d.curso_area_id=ca.id");
				query.append(" AND ca.id= " + area.getId());	
				query.append(" AND d.curso_id=t.id");				
				
				//if (con==null)
					con=MySqlDAOFactory.obtenerConexion();
				
				System.out.println("SCRIPT "+ query);
				
				ps = con.prepareStatement(query.toString());
				rs = ps.executeQuery();				
		
				listaCurso= new ArrayList<Curso>();
				while (rs.next()) 
				{	
					curso= new Curso();
					curso.setCodigo(rs.getInt("curso_id"));
					curso.setCurso(rs.getString("nombre"));
					listaCurso.add(curso);					
				}
				area.setCursoList(listaCurso);				
				listaAreaEnvio.add(area);
			}
			return listaAreaEnvio;			
			
		} catch (Exception e) {
			System.out.println("ERROR AL OBTENER AREAS CURSOS=> "+ e.getMessage());
			return null;
		}
		finally 
		{
			LimpiarConexion(con, query, ps, rs);		
		}
		
	}
	
	private List<Area> ObtenerArea() throws Exception
	{
		PreparedStatement ps=null;
		ResultSet rs =null;
		StringBuffer query=null;
		
		List<Area > listaArea=null;
		Area area= null;
		
		try 
		{							
			query = new StringBuffer();
			query.append("SELECT id, nombre ");
			query.append(" FROM t_curso_area ");
			
			//if (con==null)
				con=MySqlDAOFactory.obtenerConexion();
			
			System.out.println("SCRIPT "+ query);
			
			ps = con.prepareStatement(query.toString());
			rs = ps.executeQuery();				
	
			listaArea= new ArrayList<Area>();
			
			while (rs.next()) 
			{	area = new Area();				
				area.setId(rs.getInt("id"));
				area.setNombre(rs.getString("nombre"));
				
				listaArea.add(area);					
			}								
			return listaArea;			
			
		} catch (Exception e) {
			System.out.println("ERROR AL OBTENER LA AREAS   => "+ e.getMessage());
			return null;
		}
		finally 
		{
			LimpiarConexion(con, query, ps, rs);		
		}
	}
}
