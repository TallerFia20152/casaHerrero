package edu.usmp.fia.taller.convalidacioncurso.dataaccess;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import edu.usmp.fia.taller.common.bean.convalidacioncurso.Alumno;
import edu.usmp.fia.taller.common.bean.convalidacioncurso.Convalidacion;
import edu.usmp.fia.taller.common.bean.convalidacioncurso.Curso;
import edu.usmp.fia.taller.common.bean.convalidacioncurso.Distrito;
import edu.usmp.fia.taller.common.bean.convalidacioncurso.Persona;
import edu.usmp.fia.taller.convalidacioncurso.dataaccess.interfaces.DAOHistoriaConvalidacion;

public class MysqlHistoriaConvalidacion extends DAO implements DAOHistoriaConvalidacion{

	@Override
	public List<Curso> listarcursos() throws Exception {
		List<Curso> cursos;
        ResultSet rs = null;
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT cur.id,cur.nombre,detplan.creditos,cic.nombre ciclo ").
                append("FROM t_curso cur join t_plan_curricular_detalle detplan on detplan.curso_id=cur.id ").
                append("join t_ciclo cic on cic.id = detplan.ciclo_id ").
                append("WHERE cur.estado=1 and cic.estado=1 ").
                append("order by 4;");

        try {
            this.Conectar(false);
            rs = this.EjecutarOrdenDatos(sql.toString());
            cursos = new ArrayList<>();
            while (rs.next()) {
                Curso cur = new Curso();
                cur.setId(rs.getString("id"));
                cur.setNombre(rs.getString("nombre"));
                cur.setTipo(rs.getString("ciclo"));
                cur.setEstado(rs.getInt("creditos"));
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
	public List<Convalidacion> listarconvalidaciones() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Alumno> listaralumnos(Alumno wAlumno) throws Exception {
		 List<Alumno> alumnos;
	        ResultSet rs = null;
	        StringBuilder sql = new StringBuilder();
	        sql.append("select per.id,dni,fecha_nacimiento,direccion,distrito_id,numero_celular,numero_casa,fotografia,nombre,apellido_paterno, ").
	                append("apellido_materno,sexo,email,upper(concat(per.apellido_paterno,' ',per.apellido_materno,' ',per.nombre)) nomcom ").
	                append("from t_alumno alu join t_persona per  on per.id=alu.id ");
	        if (wAlumno.getPersona().getNomcom() == null) {
	            sql.append("where per.id =").append(wAlumno.getPersona().getId()).append(" ");
	        } else {
	            sql.append("where upper(concat(per.apellido_paterno,' ',per.apellido_materno,' ',nombre)) like upper('").
	                    append(wAlumno.getPersona().getNomcom()).append("%') ");

	        }
	        sql.append(" order by apellido_paterno,apellido_materno,nombre;");

	        try {
	            this.Conectar(false);
	            rs = this.EjecutarOrdenDatos(sql.toString());
	            alumnos = new ArrayList<>();
	            while (rs.next()) {
	                Alumno alu = new Alumno();
	                alu.setPersona(new Persona());
	                alu.getPersona().setId(rs.getInt("id"));
	                alu.getPersona().setApellido_paterno(rs.getString("apellido_paterno"));
	                alu.getPersona().setApellido_materno(rs.getString("apellido_materno"));
	                alu.getPersona().setNombre(rs.getString("nombre"));
	                alu.getPersona().setSexo(rs.getString("sexo"));
	                alu.getPersona().setNomcom(rs.getString("nomcom"));

	                alu.getPersona().setEmail(rs.getString("email"));
	                alu.setDni(rs.getString("dni"));
	                alu.setFecha_nacimiento(rs.getString("fecha_nacimiento"));
	                alu.setDireccion(rs.getString("direccion"));
	                alu.setDistrito(new Distrito());
	                alu.getDistrito().setId(rs.getInt("distrito_id"));
	                alu.setNumero_celular(rs.getInt("numero_celular"));
	                alu.setNumero_casa(rs.getInt("numero_casa"));
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
	        sql.append("SELECT alu.*,per.nombre,per.apellido_paterno,per.apellido_materno,per.sexo,per.email ").
	                append("FROM t_alumno alu ").
	                append("join t_persona per  on per.id=alu.id ").
	                append("where alu.id=").append(wAlumno.getPersona().getId()).append(";");

	        try {
	            this.Conectar(false);
	            rs = this.EjecutarOrdenDatos(sql.toString());
	            alumno = new Alumno();
	            if (rs.next()) {
	                alumno.setPersona(new Persona());
	                alumno.getPersona().setId(rs.getInt("id"));
	                alumno.getPersona().setApellido_paterno(rs.getString("apellido_paterno"));
	                alumno.getPersona().setApellido_materno(rs.getString("apellido_materno"));
	                alumno.getPersona().setNombre(rs.getString("nombre"));
	                alumno.getPersona().setSexo(rs.getString("sexo"));
	                alumno.getPersona().setEmail(rs.getString("email"));
	                alumno.setDni(rs.getString("dni"));
	                alumno.setFecha_nacimiento(rs.getString("fecha_nacimiento"));
	                alumno.setDireccion(rs.getString("direccion"));
	                alumno.setDistrito(new Distrito());
	                alumno.getDistrito().setId(rs.getInt("distrito_id"));
	                alumno.setNumero_celular(rs.getInt("numero_celular"));
	                alumno.setNumero_casa(rs.getInt("numero_casa"));
	                alumno.setFotografia(null);
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


	

}
