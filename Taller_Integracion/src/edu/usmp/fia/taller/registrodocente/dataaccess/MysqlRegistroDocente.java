package edu.usmp.fia.taller.registrodocente.dataaccess;

import edu.usmp.fia.taller.common.bean.RegistroDocente.*;
import edu.usmp.fia.taller.common.dao.MySqlDAOFactory;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import edu.usmp.fia.taller.registrodocente.dataaccess.interfaces.DAORegistroDocente;;

public class MysqlRegistroDocente extends MySqlDAOFactory implements DAORegistroDocente{
	@Override
	public List<Persona> getPersonas() throws Exception {
		// TODO Auto-generated method stub
		Connection oCn = null;
		PreparedStatement oPs = null;
		ResultSet oRs = null;
		List<Persona> personas = new ArrayList<Persona>();
		
		try {
			oCn = (Connection) MySqlDAOFactory.obtenerConexion();
			oPs = (PreparedStatement) oCn.prepareStatement("select id_docente,nombre,apellido_paterno,apellido_materno from docente");
			oRs = oPs.executeQuery();
			Persona persona = null;
				while(oRs.next()){
					persona = new Persona();
					persona.setIdPersona(oRs.getInt("id_docente"));
					persona.setNombre1(oRs.getString("nombre"));
					persona.setApePaterno(oRs.getString("apellido_paterno"));
					persona.setApeMaterno(oRs.getString("apellido_materno"));
					personas.add(persona);
				}
			
		} finally {
			close(oRs);
			close(oPs);
			close(oCn);
		}
		return personas;
	}
	
	@Override
	public List<Ubigeo> getDepartamentos() throws Exception {
		// TODO Auto-generated method stub
		Connection oCn = null;
		PreparedStatement oPs = null;
		ResultSet oRs = null;
		List<Ubigeo> ubigeos = new ArrayList<Ubigeo>();
		Ubigeo ubigeo=null;
		try {
			oCn = (Connection) MySqlDAOFactory.obtenerConexion(); 
			oPs = (PreparedStatement) oCn.prepareStatement("select * from ubigeo where codprov='00' and coddist='00' order by nombre");
			oRs = oPs.executeQuery();
				while(oRs.next()){
					ubigeo = new Ubigeo();
					ubigeo.setCoddpto(oRs.getString("coddpto"));
					ubigeo.setNombre(oRs.getString("nombre"));
					ubigeos.add(ubigeo);
				}
			
		} finally {
			close(oRs);
			close(oPs);
			close(oCn);
		}
		return ubigeos;
	}

	private int obtenerUltiId()throws Exception{
		Connection conexion = (Connection) MySqlDAOFactory.obtenerConexion();
		Statement stmt = conexion.createStatement();
		ResultSet rs=stmt.executeQuery("select id from t_persona  where id like '201%' ORDER BY id DESC");
		int i=0;
		if(rs.next()){
			i=Integer.parseInt(rs.getString("id"));
		}
		
		return i+1;
	}
	@Override
	public String guardarDocente(Docente docente,Persona persona) throws Exception {
		String resultado="";
		
		int id_persona=obtenerUltiId();
		System.out.print("zzzzzzzzzzzz"+resultado+"zzzzzzzzzzzzzz");
		
		String ema="assa@gmail.com";
		try {
			
			Connection conexion = (Connection) MySqlDAOFactory.obtenerConexion();
			Statement stmt1 = conexion.createStatement();
			Statement stmt2= conexion.createStatement();
			
			String consulta1="insert into t_persona(id,nombre,apellido_paterno,apellido_materno,sexo,email)"+"values('"+id_persona+"','"+persona.getNombre1()+"','"+persona.getApePaterno()+"','"+persona.getApeMaterno()+"','"+persona.getSexo()+"','"+persona.getEmail()+"')";
			
			int filas1=stmt1.executeUpdate(consulta1);
			if(filas1==1){
				resultado="Datos Guardados";
				System.out.print("AAAAAAAAAAAAAA"+resultado+"bbbbbbbbbb");
				
			}else{
				resultado="Ocurrio un Error";
			}
			
						
			String consulta = "insert into t_profesor(id,id_Pais_nacionalidad,id_Departamento_nacionalidad,id_Provincia_nacionalidad,id_Distrito_nacionalidad,id_Departamento_direccion,id_Provincia_direccion,id_Distrito_direccion,url_foto,estado,estado_civil,fecha_nacimiento,referencia_direccion,telefono1,telefono2,telefono3,email1,email2,email3,tipo_doc,numero_doc,grado_academico,profesion,especialidad,institucion,fecha_ingreso)"
					+ "values('"+id_persona+"','"+docente.getId_Pais_nacionalidad()+"','"+docente.getId_Departamento_nacionalidad()+"','"+docente.getId_Provincia_nacionalidad()+"','"+'1'+"','"+docente.getId_Departamento_direccion()+"','"+docente.getId_Provincia_direccion()+"','"+'2'+"','"+docente.getUrl_foto()+"','"+docente.getEstado()+"','"+docente.getEstado_civil()+"','"+docente.getFecha_nacimiento()+"','"+docente.getReferencia_direccion()+"','"+docente.getTelefono1()+"','"+docente.getTelefono2()+"','"+docente.getTelefono3()+"','"+docente.getEmail1()+"','"+docente.getEmail2()+"','"+docente.getEmail3()+"','"+docente.getTipo_doc()+"','"+docente.getNumero_doc()+"','"+docente.getGrado_academico()+"','"+docente.getProfesion()+"','"+docente.getEspecialidad()+"','"+docente.getInstitucion()+"','"+docente.getFecha_ingreso()+"')";
			
			
			
			int filas=stmt2.executeUpdate(consulta);
			
			if(filas==1 ){
				resultado="Datos Guardados";
				
				System.out.print("CCCCCCCCCC"+resultado+"DDDDDDDDDDDDD");
			}else{
				resultado="Ocurrio un Error";
			}
			
			
		} catch (Exception e) {
			
			System.out.print(e.getMessage());
		}
		
		
		return resultado;
	}

	
	public List<Ubigeo> getProvincias(String coddpto) throws Exception {
		// TODO Auto-generated method stub
				Connection oCn = null;
				PreparedStatement oPs = null;
				ResultSet oRs = null;
				List<Ubigeo> ubigeos = new ArrayList<Ubigeo>();
				Ubigeo ubigeo=null;
				try {
					oCn = (Connection) MySqlDAOFactory.obtenerConexion();
					oPs = (PreparedStatement) oCn.prepareStatement("select * from ubigeo where coddpto='"+coddpto+"' and coddist='00' and codprov<>'00' order by nombre");
					oRs = oPs.executeQuery();
						while(oRs.next()){
							ubigeo = new Ubigeo();
							ubigeo.setCodprov(oRs.getString("codprov"));
							ubigeo.setNombre(oRs.getString("nombre"));
							ubigeos.add(ubigeo);
						}
					
				} finally {
					close(oRs);
					close(oPs);
					close(oCn);
				}
				return ubigeos;
	}

	@Override
	public List<Ubigeo> getDistritos(String coddpto,String codprov) throws Exception {
		// TODO Auto-generated method stub
		Connection oCn = null;
		PreparedStatement oPs = null;
		ResultSet oRs = null;
		List<Ubigeo> ubigeos = new ArrayList<Ubigeo>();
		Ubigeo ubigeo=null;
		try {
			oCn = (Connection) MySqlDAOFactory.obtenerConexion();
			oPs = (PreparedStatement) oCn.prepareStatement("select * from ubigeo where codprov='"+codprov+"' and coddpto='"+coddpto+"' and coddist<>'00' order by nombre");
			oRs = oPs.executeQuery();
				while(oRs.next()){
					ubigeo = new Ubigeo();
					ubigeo.setCoddist(oRs.getString("coddist"));
					ubigeo.setNombre(oRs.getString("nombre"));
					ubigeos.add(ubigeo);
				}
			
		} finally {
			close(oRs);
			close(oPs);
			close(oCn);
		}
		return ubigeos;
	}

	@Override
	public Vector<Dia> listarDias() throws Exception {
		Dia dia=null;
		Vector<Dia> dias=null;
		try {
			Connection conexion = (Connection) MySqlDAOFactory.obtenerConexion();
			Statement stmt = conexion.createStatement();
			
			ResultSet rs=stmt.executeQuery("select id, nombre  from t_dia");
			
			
			
			dias=new Vector<Dia>();
			
			while(rs.next()){
				dia=new Dia();
				dia.setId(rs.getInt("id"));
				dia.setNombre(rs.getString("nombre"));
				dias.addElement(dia);
			}
				
			
		} catch (Exception e) {
			
			System.out.print(e.getMessage());
		}
		return dias;
	}

	@Override
	public Vector<Hora> listarHoras() throws Exception {
		Hora hora=null;
		Vector<Hora> horas=null;
		try {
			Connection conexion = (Connection) MySqlDAOFactory.obtenerConexion();
			Statement stmt = conexion.createStatement();
			
			ResultSet rs=stmt.executeQuery("select id, horaInicio,horaFin,turno  from t_hora");
			
			
			
			horas=new Vector<Hora>();
			
			while(rs.next()){
				hora=new Hora();
				hora.setId(rs.getInt("id"));
				hora.setHorainicio(rs.getString("horaInicio"));
				hora.setHorafin(rs.getString("horaFin"));
				hora.setTurno(rs.getString("turno"));
				horas.addElement(hora);
			}
				
			
		} catch (Exception e) {
			
			System.out.print(e.getMessage());
		}
		return horas;
	}
}
