package edu.usmp.fia.taller.common.dao;

import java.net.URLDecoder;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.ResourceBundle;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.mysql.jdbc.CallableStatement;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import edu.usmp.fia.taller.common.bean.MallaCurricular.T_course;
import edu.usmp.fia.taller.common.dao.modules.DAOFactoryGeneral;
import edu.usmp.fia.taller.common.dao.modules.MysqlFactoryGeneral;

import edu.usmp.fia.taller.common.dao.modules.convalidacioncurso.DAOFactoryConvalidacion;
import edu.usmp.fia.taller.common.dao.modules.convalidacioncurso.MysqlFactoryConvalidacion;
import edu.usmp.fia.taller.common.dao.modules.elaboracionhorario.DAOFactoryElabHorarios;
import edu.usmp.fia.taller.common.dao.modules.elaboracionhorario.MysqlFactoryElabHorarios;
import edu.usmp.fia.taller.common.dao.modules.registrodocente.DAOFactoryRegDocente;
import edu.usmp.fia.taller.common.dao.modules.registrodocente.MysqlFactoryRegDocente;


import edu.usmp.fia.taller.common.util.ThreadUtil;
import edu.usmp.fia.taller.mallacurricular.MySql.MySqlFactoryMCurricular;
import edu.usmp.fia.taller.mallacurricular.interfaces.DAOFactoryMCurricular;
import edu.usmp.fia.taller.simulacionMatricula.MySql.MySqlFactorySMatricula;
import edu.usmp.fia.taller.simulacionMatricula.interfaces.DAOFactorySMatricula;


public class MySqlDAOFactory extends DAOFactory {

	
	protected static final Logger log = LogManager.getLogger(MySqlDAOFactory.class);

	public static Session _session = null;
	
	//obtenerConexion
	public static Connection obtenerConexion(){
		Connection con = null;
		try {
			//String userName = "root";
			//String password = "root"; //sbd7230gTAf73p
			//String userName = "operador"; 
			//String password = "operadorBD";
			//String userName = "adminnL3Z24a";
			//String password = "wtRtWYXxZqIu";
			
            //String url = "jdbc:mysql://localhost:3306/bd_taller_proyectos";
            //String url = "jdbc:mysql://localhost:3306/bdtaller201502";
			//String url = "jdbc:mysql://TALLER:3306/bd_seguridad_proyectos"; //Server FIA
			//String url = "jdbc:mysql://127.12.131.2:3306/bdtaller201502"; //Server Openshit
			Map<String, String> oParameters = getMysqlJDBC();
			
            Class.forName ("com.mysql.jdbc.Driver").newInstance();
            con = (Connection) DriverManager.getConnection (oParameters.get("jdbc:url"), oParameters.get("usuario"), oParameters.get("clave"));
            //System.out.println ("Database connection established");
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.print(e.getMessage());
			System.out.print("Connection Failed!");
			e.printStackTrace();
		}
		return con;
	}//obtenerConexion


	private static HashMap<String, String> getMysqlJDBC() throws Exception {
		HashMap<String, String> oParameters = new HashMap<String, String>();
		String oStrDatabaseEnv = ResourceBundle.getBundle("config").getString("database-environment");
		oStrDatabaseEnv = oStrDatabaseEnv==null? "": oStrDatabaseEnv.trim();
		
		if(oStrDatabaseEnv.equalsIgnoreCase("fia")) {
			log.info("connection is fia");
			oParameters.put("jdbc:url", "jdbc:mysql://TALLER:3306/bd_taller_proyectos");
			oParameters.put("usuario", "operador");
			oParameters.put("clave", "operadorBD");
			
		} else if (oStrDatabaseEnv.equalsIgnoreCase("openshift-debug")) { // considerar que el puerto 3366 de sus PC no este siendo usado
			log.info("connection is openshift");
			//log.info( URLDecoder.decode(this.getClass().getProtectionDomain().getCodeSource().getLocation().getPath(), "UTF-8") );
			String oStrSSHUser = "561b5adb2d52712ae000002d";
			String oStrSSHHost = "tallerproyecto-usmpfia.rhcloud.com";
			int oSSHPort = 22;
			int oLocalPort = 3366;
			String oStrRemoteHost = "127.12.131.2";
			int oRemotePort = 3306;
			
			if(_session!=null && _session.isConnected())
				_session.disconnect();
			JSch oJsch = new JSch();
			_session = oJsch.getSession(oStrSSHUser, oStrSSHHost, oSSHPort);
			Properties oConfig = new Properties();
			oConfig.put("StrictHostKeyChecking", "no");
			_session.setConfig(oConfig);
			//oJsch.addIdentity( URLDecoder.decode(this.getClass().getProtectionDomain().getCodeSource().getLocation().getPath().toString(), "UTF-8") + "id_rsa");
			//oJsch.addIdentity( URLDecoder.decode(MySqlDAOFactory.class.getProtectionDomain().getCodeSource().getLocation().getPath().toString(), "UTF-8") + "id_rsa");
			log.info("path:" + URLDecoder.decode(MySqlDAOFactory.class.getClassLoader().getResource("").getPath(), "UTF-8"));
			oJsch.addIdentity( URLDecoder.decode(MySqlDAOFactory.class.getClassLoader().getResource("").getPath(), "UTF-8") + "id_rsa");
			_session.connect();
			_session.setPortForwardingL(oLocalPort, oStrRemoteHost, oRemotePort);
		
			oParameters.put("jdbc:url", "jdbc:mysql://localhost:" + String.valueOf(oLocalPort) + "/bd_taller_proyectos");
			oParameters.put("usuario", "adminnL3Z24a");
			oParameters.put("clave", "wtRtWYXxZqIu");
			
		} else if (oStrDatabaseEnv.equalsIgnoreCase("openshift-deploy")) {
			log.info("connection is localhost");
			oParameters.put("jdbc:url", "jdbc:mysql://127.12.131.2:3306/bd_taller_proyectos");
			oParameters.put("usuario", "adminnL3Z24a");
			oParameters.put("clave", "wtRtWYXxZqIu");
			
		} else {
			log.info("connection is localhost");
			oParameters.put("jdbc:url", "jdbc:mysql://localhost:3306/bd_taller_proyectos");
			oParameters.put("usuario", "root");
			oParameters.put("clave", "root");
		}
		log.info("oStrMysqlJDBC: " + oParameters.get("jdbc:url"));
		return oParameters;
	}


	public static void close(Object o) {
		if(o == null)
			return;
		try {
			if (o.getClass() == PreparedStatement.class || o.getClass() == com.mysql.jdbc.JDBC4PreparedStatement.class) {
				((PreparedStatement)o).clearParameters();
				((PreparedStatement)o).close();
			} else if (o.getClass() == Connection.class || o.getClass() == com.mysql.jdbc.JDBC4Connection.class) {
				((Connection)o).close();
				closeSSH();
			} else if (o.getClass() == ResultSet.class || o.getClass() == com.mysql.jdbc.JDBC4ResultSet.class) {
				((ResultSet)o).close();
			} else if (o.getClass() == CallableStatement.class || o.getClass() == com.mysql.jdbc.CallableStatement.class) {
				((CallableStatement) o).clearParameters();
				((CallableStatement) o).close();
			}
			if(o.getClass()==Connection.class && _session!=null) {
				log.info("destroy _session SSH");
				if(_session.isConnected()) { 
					System.err.println("SSH cerrado");
					_session.disconnect();
				}
				_session = null;
			}
		} catch (Exception ex) { 
			log.info(ExceptionUtils.getStackTrace(ex));
		} finally {
			o = null;
		}
	}
	
	private static void closeSSH() {
		if(_session!=null) {
			log.info("destroy _session SSH");
			if(_session.isConnected()) { 
				System.err.println("SSH cerrado");
				_session.disconnect();
			}
			_session = null;
		}
	}
	
	public DAOFactoryGeneral getGeneral() { return new MysqlFactoryGeneral(); }
	public DAOFactorySMatricula getSimulacionMatricula() { return new MySqlFactorySMatricula(); }

	//public DAOFactoryMCurricular getMallaCurricular() { return new MySqlFactoryMCurricular(); }
	public DAOFactoryElabHorarios getElaboracionHorario() {return new MysqlFactoryElabHorarios();}
	public DAOFactoryRegDocente getRegistroDocente() {return new MysqlFactoryRegDocente();}

	@Override
	public DAOFactoryConvalidacion getConvalidacion() {
		// TODO Auto-generated method stub
		return new MysqlFactoryConvalidacion();
	}

	



	public DAOFactoryMCurricular getMallaCurricular() { return new MySqlFactoryMCurricular(); }




}
