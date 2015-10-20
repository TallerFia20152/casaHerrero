package edu.usmp.fia.taller.registrodocente.dataaccess.interfaces;

import java.util.List;
import java.util.Vector;

import edu.usmp.fia.taller.common.bean.RegistroDocente.*;

public interface DAORegistroDocente {
	public List<Persona> getPersonas() throws Exception;
	public String guardarDocente(Docente docente,Persona persona) throws Exception;
	public List<Ubigeo> getDepartamentos() throws Exception;
	public List<Ubigeo> getProvincias(String coddpto) throws Exception;
	public List<Ubigeo> getDistritos(String coddpto,String codprov) throws Exception;
	public Vector<Dia> listarDias()throws Exception;
	public Vector<Hora> listarHoras()throws Exception;
}
