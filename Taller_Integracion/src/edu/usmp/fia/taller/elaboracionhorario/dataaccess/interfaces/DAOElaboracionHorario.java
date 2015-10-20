package edu.usmp.fia.taller.elaboracionhorario.dataaccess.interfaces;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.json.JSONArray;
import org.json.JSONObject;


import edu.usmp.fia.taller.common.bean.ElaboracionHorarios.*;


public interface DAOElaboracionHorario {
	
	public List<Curso> getCursoAll () throws Exception; // codCurso, nombreCursoIndivual, nombreCursoGeneeral
	public List<Docente> getProfesoresAll() throws Exception; //nombreProfesor
	public int insertHorarios(HorariosBean objHor)throws Exception;
	public List <String > getHorarioDetalle () throws Exception;
	public JSONObject getHoraTotales (String cycle, String versionHorario)throws Exception;
	public JSONObject getHoras (String cycle, HttpSession sesion) throws Exception;
	public JSONArray getDisponibilidadAula (String[] hArray) throws Exception;
	public void getCargarHorario (String cycle, String versionHorario,JSONArray jsonObject) throws Exception;
}
