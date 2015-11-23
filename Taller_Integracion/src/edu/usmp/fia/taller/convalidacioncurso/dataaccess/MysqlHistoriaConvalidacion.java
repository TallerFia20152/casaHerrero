package edu.usmp.fia.taller.convalidacioncurso.dataaccess;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import edu.usmp.fia.taller.common.bean.convalidacioncurso.Alumno;
import edu.usmp.fia.taller.common.bean.convalidacioncurso.AlumnoConvalidacion;
import edu.usmp.fia.taller.common.bean.convalidacioncurso.Ciclo;
import edu.usmp.fia.taller.common.bean.convalidacioncurso.Convalidacion;
import edu.usmp.fia.taller.common.bean.convalidacioncurso.ConvalidacionAlumno;
import edu.usmp.fia.taller.common.bean.convalidacioncurso.Curso;
import edu.usmp.fia.taller.common.bean.convalidacioncurso.Departamento;
import edu.usmp.fia.taller.common.bean.convalidacioncurso.Distrito;
import edu.usmp.fia.taller.common.bean.convalidacioncurso.Especialidad;
import edu.usmp.fia.taller.common.bean.convalidacioncurso.Facultad;
import edu.usmp.fia.taller.common.bean.convalidacioncurso.InsertConvalidacion;
import edu.usmp.fia.taller.common.bean.convalidacioncurso.ModalidadIngreso;
import edu.usmp.fia.taller.common.bean.convalidacioncurso.Persona;
import edu.usmp.fia.taller.common.bean.convalidacioncurso.PlanCurricular;
import edu.usmp.fia.taller.common.bean.convalidacioncurso.PlanCurricularDetalle;
import edu.usmp.fia.taller.common.bean.convalidacioncurso.Provincia;
import edu.usmp.fia.taller.common.bean.convalidacioncurso.UniversidadOrigen;
import edu.usmp.fia.taller.convalidacioncurso.dataaccess.interfaces.DAOHistoriaConvalidacion;

public class MysqlHistoriaConvalidacion extends DAO implements DAOHistoriaConvalidacion {

	@Override
	public List<PlanCurricularDetalle> listarcursos(Alumno wAlumno) throws Exception {
		List<PlanCurricularDetalle> detalles;
		ResultSet rs = null;
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT detplan.id plan_id,cur.id,cur.nombre,detplan.creditos,cic.nombre ciclo ")
				.append("FROM t_curso cur join t_plan_curricular_detalle detplan on detplan.curso_id=cur.id ")
				.append("join t_ciclo cic on cic.id = detplan.ciclo_id ").append("WHERE cur.estado=1 and cic.estado=1 ")
				.
				// amarre con codigos de facultad y escuela del alumno con el
				// plan
				append("order by 5;");

		try {
			this.Conectar(false);
			rs = this.EjecutarOrdenDatos(sql.toString());
			detalles = new ArrayList<>();
			while (rs.next()) {
				PlanCurricularDetalle det = new PlanCurricularDetalle();
				det.setPlancurricular(new PlanCurricular());
				det.getPlancurricular().setId(Integer.parseInt(rs.getString("plan_id")));
				det.setCiclo(new Ciclo());
				det.getCiclo().setNombre(rs.getString("ciclo"));
				det.setCurso(new Curso());
				det.getCurso().setId(rs.getString("id"));
				det.getCurso().setNombre(rs.getString("nombre"));
				det.setCreditos(Integer.parseInt(rs.getString("creditos")));

				detalles.add(det);
			}
			rs.close();
			this.Cerrar(true);
		} catch (Exception e) {
			this.Cerrar(false);
			throw e;
		} finally {
			if (rs != null) {
				rs = null;
			}
		}
		return detalles;
	}

	@Override
	public List<Convalidacion> listarconvalidaciones(Alumno wAlumno) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Alumno> listaralumnos(Alumno wAlumno) throws Exception {
		List<Alumno> alumnos;
		ResultSet rs = null;
		StringBuilder sql = new StringBuilder();
		sql.append(
				"select per.id,dni,fecha_nacimiento,direccion,distrito_id,numero_celular,numero_casa,fotografia,nombre,apellido_paterno, ")
				.append("apellido_materno,sexo,email,upper(concat(per.apellido_paterno,' ',per.apellido_materno,' ',per.nombre)) nomcom ")
				.append("from t_alumno alu join t_persona per  on per.id=alu.id ");
		if (wAlumno.getPersona().getNomcom() == null) {
			sql.append("where per.id =").append(wAlumno.getPersona().getId()).append(" ");
		} else {
			sql.append("where upper(concat(per.apellido_paterno,' ',per.apellido_materno,' ',nombre)) like upper('")
					.append(wAlumno.getPersona().getNomcom()).append("%') ");

		}
		sql.append(" and modalidad_ingreso_id<>'E'");
		sql.append(" order by apellido_paterno,apellido_materno,nombre;");

		try {
			this.Conectar(false);
			rs = this.EjecutarOrdenDatos(sql.toString());
			alumnos = new ArrayList<>();
			while (rs.next()) {
				Alumno alu = new Alumno();
				alu.setPersona(new Persona());
				alu.getPersona().setId(rs.getString("id"));
				alu.getPersona().setApellidopaterno(rs.getString("apellido_paterno"));
				alu.getPersona().setApellidomaterno(rs.getString("apellido_materno"));
				alu.getPersona().setNombre(rs.getString("nombre"));
				alu.getPersona().setSexo(rs.getString("sexo"));
				alu.getPersona().setNomcom(rs.getString("nomcom"));

				alu.getPersona().setEmail(rs.getString("email"));
				alu.setDni(rs.getString("dni"));
				alu.setFechanacimiento(rs.getString("fecha_nacimiento"));
				alu.setDireccion(rs.getString("direccion"));
				alu.setDistrito(new Distrito());
				alu.getDistrito().setId(rs.getString("distrito_id"));
				alu.setNumerocelular(rs.getInt("numero_celular"));
				alu.setNumerocasa(rs.getInt("numero_casa"));
				alu.setFotografia(null);
				alumnos.add(alu);
			}
			rs.close();
			this.Cerrar(true);
		} catch (Exception e) {
			this.Cerrar(false);
			throw e;
		} finally {
			if (rs != null) {
				rs = null;
			}
		}
		return alumnos;
	}

	@Override
	public Alumno obtenerDatosAlumno(Alumno wAlumno) throws Exception {
		Alumno alumno;
		ResultSet rs = null;
		StringBuilder sql = new StringBuilder();
		sql.append(
				"SELECT alu.id,fac.descripcion facultad,esp.nombre especialidad,upper(per.nombre) nombre,upper(per.apellido_paterno) apellido_paterno,upper(per.apellido_materno) apellido_materno ")
				.append("FROM t_alumno alu ").append("join t_persona per  on per.id=alu.id ")
				.append("join t_especialidad esp  on esp.id=alu.especialidad_id ")
				.append("join t_facultad fac  on fac.id=esp.id_facultad ").append("where alu.id='")
				.append(wAlumno.getPersona().getId()).
				// append("' and alu.modalidad_ingreso_id<>'E';");
				append("';");
		try {
			this.Conectar(false);
			rs = this.EjecutarOrdenDatos(sql.toString());
			alumno = new Alumno();
			if (rs.next()) {
				alumno.setPersona(new Persona());
				alumno.getPersona().setId(rs.getString("id"));
				alumno.getPersona().setApellidopaterno(rs.getString("apellido_paterno"));
				alumno.getPersona().setApellidomaterno(rs.getString("apellido_materno"));
				alumno.getPersona().setNombre(rs.getString("nombre"));

				alumno.setFacultad(new Facultad());
				alumno.getFacultad().setNombre(rs.getString("facultad"));
				alumno.setEspecialidad(new Especialidad());
				alumno.getEspecialidad().setNombre(rs.getString("especialidad"));
			}
			rs.close();
			this.Cerrar(true);
		} catch (Exception e) {
			this.Cerrar(false);
			throw e;
		} finally {
			if (rs != null) {
				rs = null;
			}
		}
		return alumno;
	}

	@Override
	public List<UniversidadOrigen> listaruniversidades() throws Exception {

		List<UniversidadOrigen> unis;
		ResultSet rs = null;
		StringBuilder sql = new StringBuilder();
		sql.append("select * from t_universidad_origen where estado='A';");

		try {
			this.Conectar(false);
			rs = this.EjecutarOrdenDatos(sql.toString());
			unis = new ArrayList<>();
			while (rs.next()) {
				UniversidadOrigen uni = new UniversidadOrigen();
				uni.setId(Integer.parseInt(rs.getString("id")));
				uni.setNombre(rs.getString("nombre"));
				uni.setEstado(rs.getString("estado"));
				uni.setUbicacion(rs.getString("ubicacion"));
				unis.add(uni);
			}
			rs.close();
			this.Cerrar(true);
		} catch (Exception e) {
			this.Cerrar(false);
			throw e;
		} finally {
			if (rs != null) {
				rs = null;
			}
		}
		return unis;
	}

	@Override
	public void registrarAlumno(Alumno wAlumno) throws Exception {
		List<StringBuilder> sqls = new ArrayList<>();
		StringBuilder sql;
		sql = new StringBuilder();
		sql.append("INSERT INTO t_persona(id,nombre,apellido_paterno,apellido_materno,sexo)").append(" VALUES('")
				.append(wAlumno.getPersona().getId()).append("','").append(wAlumno.getPersona().getNombre())
				.append("','").append(wAlumno.getPersona().getApellidopaterno()).append("','")
				.append(wAlumno.getPersona().getApellidomaterno()).append("',").append(wAlumno.getPersona().getSexo())
				.append(")");// 1-MAsculino 2-femenino

		sqls.add(sql);

		sql = new StringBuilder();
		sql.append(
				"INSERT INTO t_alumno(id,dni,fecha_nacimiento,direccion,departamento_id,provincia_id,distrito_id,numero_celular,numero_casa,modalidad_ingreso_id,especialidad_id,facultad_id)")
				.append(" VALUES('").append(wAlumno.getPersona().getId()).append("','").append(wAlumno.getDni())
				.append("','").append(wAlumno.getFechanacimiento()).append("','").append(wAlumno.getDireccion())
				.append("','").append(wAlumno.getDepartamento().getId())
				.append("','").append(wAlumno.getProvincia().getId())
				.append("','").append(wAlumno.getDistrito().getId()).append("',")
				.append(wAlumno.getNumerocelular())
				.append(",").append(wAlumno.getNumerocasa()).append(",'").append(wAlumno.getModalidadingreso().getId())
				.append("',").append(wAlumno.getEspecialidad().getId()).append(",").
				// append(wAlumno.getFacultad().getId()).append("')");
				append("9)");

		sqls.add(sql);

		try {
			this.Conectar(true);// transaccion
			for (StringBuilder str : sqls) {
				this.EjecutarOrden(str.toString());
			}
			this.Cerrar(true);
		} catch (Exception e) {
			this.Cerrar(false);
			throw e;
		} finally {
			sqls = null;
		}

	}

	@Override
	public List<Especialidad> listarespecialidades(Facultad wFacultad) throws Exception {
		List<Especialidad> espes;
		ResultSet rs = null;
		StringBuilder sql = new StringBuilder();
		sql.append("select * from t_especialidad where id_facultad=").append(wFacultad.getId()).append(" ;");

		try {
			this.Conectar(false);
			rs = this.EjecutarOrdenDatos(sql.toString());
			espes = new ArrayList<>();
			while (rs.next()) {
				Especialidad esp = new Especialidad();
				esp.setId(Integer.parseInt(rs.getString("id")));
				esp.setNombre(rs.getString("nombre"));
				espes.add(esp);
			}
			rs.close();
			this.Cerrar(true);
		} catch (Exception e) {
			this.Cerrar(false);
			throw e;
		} finally {
			if (rs != null) {
				rs = null;
			}
		}
		return espes;
	}

	@Override
	public List<Distrito> listardistritos(Departamento wDepartamento,Provincia wProvincia) throws Exception {
		List<Distrito> distritos;
		ResultSet rs = null;
		StringBuilder sql = new StringBuilder();
		sql.append("select id,upper(nombre) nombre from t_distrito where departamento_id='").
				append(wDepartamento.getId()).append("' and provincia_id='").
				append(wProvincia.getId()).append("';");

		try {
			this.Conectar(false);
			rs = this.EjecutarOrdenDatos(sql.toString());
			distritos = new ArrayList<>();
			while (rs.next()) {
				Distrito dis = new Distrito();
				dis.setId(rs.getString("id"));
				dis.setNombre(rs.getString("nombre"));
				distritos.add(dis);
			}
			rs.close();
			this.Cerrar(true);
		} catch (Exception e) {
			this.Cerrar(false);
			throw e;
		} finally {
			if (rs != null) {
				rs = null;
			}
		}
		return distritos;
	}


	@Override
	public List<Departamento> listardepartamentos() throws Exception {
		List<Departamento> departamentos;
		ResultSet rs = null;
		StringBuilder sql = new StringBuilder();
		sql.append("select id,upper(nombre) nombre from t_departamento");

		try {
			this.Conectar(false);
			rs = this.EjecutarOrdenDatos(sql.toString());
			departamentos = new ArrayList<>();
			while (rs.next()) {
				Departamento dep = new Departamento();
				dep.setId(rs.getString("id"));
				dep.setNombre(rs.getString("nombre"));
				departamentos.add(dep);
			}
			rs.close();
			this.Cerrar(true);
		} catch (Exception e) {
			this.Cerrar(false);
			throw e;
		} finally {
			if (rs != null) {
				rs = null;
			}
		}
		return departamentos;
	}
	@Override
	public List<Provincia> listarprovincias(Departamento wDepartamento) throws Exception {
		List<Provincia> provincias;
		ResultSet rs = null;
		StringBuilder sql = new StringBuilder();
		sql.append("select id,upper(nombre) nombre from t_provincia where departamento_id='").
		append(wDepartamento.getId()).append("';");

		try {
			this.Conectar(false);
			rs = this.EjecutarOrdenDatos(sql.toString());
			provincias = new ArrayList<>();
			while (rs.next()) {
				Provincia pro = new Provincia();
				pro.setId(rs.getString("id"));
				pro.setNombre(rs.getString("nombre"));
				provincias.add(pro);
			}
			rs.close();
			this.Cerrar(true);
		} catch (Exception e) {
			this.Cerrar(false);
			throw e;
		} finally {
			if (rs != null) {
				rs = null;
			}
		}
		return provincias;
	}
	
	@Override
	public List<ModalidadIngreso> listarmodalidades() throws Exception {
		List<ModalidadIngreso> modalidades;
		ResultSet rs = null;
		StringBuilder sql = new StringBuilder();
		sql.append("select * from t_modalidad_ingreso where id<>'E'");

		try {
			this.Conectar(false);
			rs = this.EjecutarOrdenDatos(sql.toString());
			modalidades = new ArrayList<>();
			while (rs.next()) {
				ModalidadIngreso mod = new ModalidadIngreso();
				mod.setId(rs.getString("id"));
				mod.setDescripcion(rs.getString("descripcion"));
				modalidades.add(mod);
			}
			rs.close();
			this.Cerrar(true);
		} catch (Exception e) {
			this.Cerrar(false);
			throw e;
		} finally {
			if (rs != null) {
				rs = null;
			}
		}
		return modalidades;
	}

	@Override
	public void registrarConvalidacionAlumno(List<AlumnoConvalidacion> wConvalidacionAlumnos,
			List<InsertConvalidacion> wConvalidaciones) throws Exception {
		List<StringBuilder> listSql = new ArrayList<>();
		StringBuilder sql;

		for (AlumnoConvalidacion conalu : wConvalidacionAlumnos) {
			sql = new StringBuilder();
			sql.append(
					"INSERT INTO t_convalidacion_alumno(alumno_id,curso_origen_codigo,curso_origen_nombre,nota,universidad_origen_id)")
					.append(" VALUES('").append(conalu.getAlumno()).append("','").append(conalu.getCursoorigencodigo())
					.append("','").append(conalu.getCursoorigennombre()).append("',").append(conalu.getNota())
					.append(",").append(conalu.getUniversidadorigen()).append(");");
			listSql.add(sql);
		}

		for (InsertConvalidacion conva : wConvalidaciones) {
			sql = new StringBuilder();
			sql.append("INSERT INTO t_convalidacion(plan_curricular_detalle_id,curso_id,alumno_id,curso_origen_codigo)")
					.append(" VALUES (").append(conva.getPlancurricular()).append(", '").append(conva.getCurso())
					.append("', '").append(conva.getAlumno()).append("', '").append(conva.getCodigocursoorigen())
					.append("');");
			listSql.add(sql);
		}

		try {
			this.Conectar(true);// transaccion
			for (StringBuilder strbd : listSql) {
				this.EjecutarOrden(strbd.toString());
			}
			this.Cerrar(true);
		} catch (Exception e) {
			this.Cerrar(false);
			throw e;
		} finally {

		}

	}

	@Override
	public List<ConvalidacionAlumno> listarCursosxconvalidar(Alumno wAlumno) throws Exception {
		List<ConvalidacionAlumno> conalus;
		ResultSet rs = null;
		StringBuilder sql = new StringBuilder();
		sql.append("select * from t_convalidacion_alumno ").append("where alumno_id='")
				.append(wAlumno.getPersona().getId()).append("'")
				.append("and curso_origen_codigo not in(select distinct curso_origen_codigo")
				.append("from t_convalidacion where alumno_id='").append(wAlumno.getPersona().getId()).append("'");

		try {
			this.Conectar(false);
			rs = this.EjecutarOrdenDatos(sql.toString());
			conalus = new ArrayList<>();
			while (rs.next()) {
				ConvalidacionAlumno conalu = new ConvalidacionAlumno();
				conalu.setCursoorigencodigo(rs.getString("curso_origen_codigo"));
				conalu.setCursoorigennombre(rs.getString("curso_origen_nombre"));
				conalus.add(conalu);
			}
			rs.close();
			this.Cerrar(true);
		} catch (Exception e) {
			this.Cerrar(false);
			throw e;
		} finally {
			if (rs != null) {
				rs = null;
			}
		}
		return conalus;

	}

	@Override
	public PlanCurricularDetalle BuscarHistorico(ConvalidacionAlumno wConvalidacionAlumno) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ConvalidacionAlumno> BuscarEnConvalidacion(PlanCurricularDetalle wPlanCurricularDetalle)
			throws Exception {

		List<ConvalidacionAlumno> cursos;
		ResultSet rs = null;
		StringBuilder sql = new StringBuilder();
		sql.append("select distinct det.id,det.curso_id,con.curso_origen_codigo,conalu.curso_origen_nombre ")
				.append("from t_plan_curricular_detalle det join t_convalidacion con on con.plan_curricular_detalle_id=det.id and con.curso_id=det.curso_id ")
				.append("	 join t_convalidacion_alumno conalu on conalu.curso_origen_codigo=con.curso_origen_codigo and conalu.alumno_id=con.alumno_id ")
				.append("where det.curso_id='").append(wPlanCurricularDetalle.getCurso().getId()).append("' ")
				.append("and det.id=").append(wPlanCurricularDetalle.getPlancurricular().getId()).append(";");

		try {
			this.Conectar(false);
			rs = this.EjecutarOrdenDatos(sql.toString());
			cursos = new ArrayList<>();
			while (rs.next()) {
				ConvalidacionAlumno cur = new ConvalidacionAlumno();
				cur.setCursoorigencodigo(rs.getString("curso_origen_codigo"));
				cur.setCursoorigennombre(rs.getString("curso_origen_nombre"));
				cursos.add(cur);
			}
			rs.close();
			this.Cerrar(true);
		} catch (Exception e) {
			this.Cerrar(false);
			throw e;
		} finally {
			if (rs != null) {
				rs = null;
			}
		}
		return cursos;

	}

	@Override
	public List<ConvalidacionAlumno> listarCursosConv(Alumno wAlumno) throws Exception {

		List<ConvalidacionAlumno> cursos;
		ResultSet rs = null;
		StringBuilder sql = new StringBuilder();
		sql.append("select * from t_convalidacion_alumno where alumno_id='")
				.append(wAlumno.getPersona().getId()).append("' ")
				.append("and curso_origen_codigo not in(select distinct curso_origen_codigo from t_convalidacion where alumno_id='")
				.append(wAlumno.getPersona().getId()).append("');");

		try {
			this.Conectar(false);
			rs = this.EjecutarOrdenDatos(sql.toString());
			cursos = new ArrayList<>();
			while (rs.next()) {
				ConvalidacionAlumno cur = new ConvalidacionAlumno();
				cur.setCursoorigencodigo(rs.getString("curso_origen_codigo"));
				cur.setCursoorigennombre(rs.getString("curso_origen_nombre"));
				cur.setNota(Integer.parseInt(rs.getString("nota")));
				cursos.add(cur);
			}
			rs.close();
			this.Cerrar(true);
		} catch (Exception e) {
			this.Cerrar(false);
			throw e;
		} finally {
			if (rs != null) {
				rs = null;
			}
		}
		return cursos;
	}

	@Override
	public void registrarConvalidaciones(List<InsertConvalidacion> wConvalidaciones) throws Exception {
		List<StringBuilder> listSql = new ArrayList<>();
		StringBuilder sql;

		for (InsertConvalidacion conva : wConvalidaciones) {
			sql = new StringBuilder();
			sql.append("INSERT INTO t_convalidacion(plan_curricular_detalle_id,curso_id,alumno_id,curso_origen_codigo)")
					.append(" VALUES (").append(conva.getPlancurricular()).append(", '").append(conva.getCurso())
					.append("', '").append(conva.getAlumno()).append("', '").append(conva.getCodigocursoorigen())
					.append("');");
			listSql.add(sql);
		}

		try {
			this.Conectar(true);// transaccion
			for (StringBuilder strbd : listSql) {
				this.EjecutarOrden(strbd.toString());
			}
			this.Cerrar(true);
		} catch (Exception e) {
			this.Cerrar(false);
			throw e;
		} finally {

		}

	}

	@Override
	public Alumno VerificarSiconvalido(Alumno wAlumno) throws Exception {

		ResultSet rs = null;
		StringBuilder sql = new StringBuilder();
		sql.append("select distinct alumno_id from t_convalidacion_alumno where alumno_id='")
				.append(wAlumno.getPersona().getId()).append("' ;");

		try {
			this.Conectar(false);
			rs = this.EjecutarOrdenDatos(sql.toString());

			if (rs.next()) {
				wAlumno.getPersona().setId(rs.getString("alumno_id"));
			} else {
				wAlumno.getPersona().setId("");
			}
			rs.close();
			this.Cerrar(true);
		} catch (Exception e) {
			this.Cerrar(false);
			throw e;
		} finally {
			if (rs != null) {
				rs = null;
			}
		}
		return wAlumno;
	}

	public List<Convalidacion> listarCursosUni(UniversidadOrigen wUniversidadOrigen) throws Exception {

		List<Convalidacion> cursos;
		ResultSet rs = null;
		StringBuilder sql = new StringBuilder();
		sql.append(
				"select count(detplan.curso_id) numcon, detplan.id,detplan.curso_id,upper(cur.nombre) nombre,cic.nombre ciclo,con.curso_origen_codigo,conalu.curso_origen_nombre ")
				.append("from t_curso cur join t_plan_curricular_detalle detplan on detplan.curso_id = cur.id ")
				.append("join t_ciclo cic on cic.id = detplan.ciclo_id ")
				.append("join t_convalidacion con on con.curso_id=detplan.curso_id and con.plan_curricular_detalle_id = detplan.id ")
				.append("join t_convalidacion_alumno conalu on conalu.alumno_id = con.alumno_id and conalu.curso_origen_codigo = con.curso_origen_codigo ")
				.append("where conalu.universidad_origen_id = '").append(wUniversidadOrigen.getId()).append("' ")
				.append("group by detplan.curso_id ").append("order by cic.nombre;");

		try {
			this.Conectar(false);
			rs = this.EjecutarOrdenDatos(sql.toString());
			cursos = new ArrayList<>();
			while (rs.next()) {
				Convalidacion cur = new Convalidacion();

				cur.setCursoorigencodigo(rs.getString("curso_origen_codigo"));
				cur.setCursoorigennombre(rs.getString("curso_origen_nombre"));
				cur.setCiclo(new Ciclo());
				cur.getCiclo().setNombre(rs.getString("ciclo"));
				cur.setPlancurricular(new PlanCurricular());
				cur.getPlancurricular().setId(rs.getInt("id"));
				cur.setCurso(new Curso());
				cur.getCurso().setId(rs.getString("curso_id"));
				cur.getCurso().setNombre(rs.getString("nombre"));
				cur.setCantconvalidacion(rs.getInt("numcon"));
				cursos.add(cur);
			}
			rs.close();
			this.Cerrar(true);
		} catch (Exception e) {
			this.Cerrar(false);
			throw e;
		} finally {
			if (rs != null) {
				rs = null;
			}
		}
		return cursos;

	}

}
