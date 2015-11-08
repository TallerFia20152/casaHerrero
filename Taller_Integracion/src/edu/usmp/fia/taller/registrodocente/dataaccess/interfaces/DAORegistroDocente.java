package edu.usmp.fia.taller.registrodocente.dataaccess.interfaces;

import java.util.List;
import java.util.Vector;

import edu.usmp.fia.taller.common.bean.RegistroDocente.*;

public interface DAORegistroDocente {
	public List<Docente> getDocentes() throws Exception;
	public boolean guardarDocente(Docente docente) throws Exception;
	public boolean modificarDocente(Docente docente) throws Exception;
	public List<Ubigeo> getDepartamentos() throws Exception;
	public List<Ubigeo> getProvincias(String coddpto) throws Exception;
	public List<Ubigeo> getDistritos(String coddpto,String codprov) throws Exception;
	public Vector<Dia> listarDias()throws Exception;
	public Vector<Hora> listarHoras()throws Exception;
	public Vector<Personaa> listarDocentes()throws Exception;
	public Vector<Curso> listarCursos()throws Exception;
	public Personaa buscarDocente(String codigo)throws Exception;
	public Curso buscarCurso(String codigo)throws Exception;
	public Vector<CursoAptoProfesor> buscarCursoAptos(String profesor_id)throws Exception;
	public Vector<DisponibilidadProfesor> buscarHorasDisponibles(String profesor_id) throws Exception;
	public boolean guardarCursosAptos(String json_cusosAptos, String id_profesor)throws Exception;
	public boolean guardarRangoHoras(String json_rangoHoras, String id_profesor)throws Exception;
	public String eliminarDocente(String codigo);
	
	//INICIO modificar docente
	public Personaa buscarPersona(String codigo)throws Exception;
	public Docente buscarDocente1(String codigo)throws Exception;
	public Vector<Email> buscarEmail(String codigo)throws Exception;
	public Vector<Telefono> buscarTelefono(String codigo)throws Exception;
	public Vector<Documento> buscarDocumento(String codigo)throws Exception;
	public Vector<GradoAcademico> buscarGradoAcademico(String codigo)throws Exception;
	
	
	//FIN modificar docente
	//INICIO metodos de email
	public boolean guardarEmail(Email emal) throws Exception;
	public boolean guardarEmails(String json_email,String id_profesor) throws Exception;
	//FIN metodos de email
	
	
	
//----------------------------INICIO metodo de persona
	public int guardarPersona(Personaa persona) throws Exception;
	public int modificarPersona(Personaa persona) throws Exception;
//----------------------------FIN metodo de persona
	
	
	
	
//----------------------------INICIO metodo de telefono
	public boolean guardarTelefono(Telefono telefono) throws Exception;
	public boolean guardarTelefonos(String json_telefonos,String id_profesor) throws Exception;
//----------------------------FIN metodo de telefono
	
//----------------------------INICIO metodo de documento
	public boolean guardarDocumento(Documento documento) throws Exception;
	public boolean guardarDocumentos(String json_documentos,String id_profesor) throws Exception;
//----------------------------FIN metodo de documento
	
//----------------------------INICIO metodo de GradoAcademico
	public boolean guardarGradoAcademico(GradoAcademico gradoAcademico) throws Exception;
	public boolean guardarGradosAcademicos(String json_gradoAcademico,String id_profesor) throws Exception;
//----------------------------FIN metodo de GradoAcademico
}
