/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.usmp.fia.taller.convalidacioncurso.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.annotation.WebServlet;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import edu.usmp.fia.taller.common.action.ActionServlet;
import edu.usmp.fia.taller.common.action.Default;
import edu.usmp.fia.taller.common.action.HttpMethod;
import edu.usmp.fia.taller.common.action.HttpMethodType;
import edu.usmp.fia.taller.common.action.RequireLogin;
import edu.usmp.fia.taller.common.bean.convalidacioncurso.Alumno;
import edu.usmp.fia.taller.common.bean.convalidacioncurso.AlumnoConvalidacion;
import edu.usmp.fia.taller.common.bean.convalidacioncurso.Convalidacion;
import edu.usmp.fia.taller.common.bean.convalidacioncurso.ConvalidacionAlumno;
import edu.usmp.fia.taller.common.bean.convalidacioncurso.Distrito;
import edu.usmp.fia.taller.common.bean.convalidacioncurso.Especialidad;
import edu.usmp.fia.taller.common.bean.convalidacioncurso.ModalidadIngreso;
import edu.usmp.fia.taller.common.bean.convalidacioncurso.Persona;
import edu.usmp.fia.taller.common.dao.DAOFactory;


/**
 *
 * @author Ingeniero
 */

@WebServlet("/registrodatos")
public class RegistroDatos extends ActionServlet {
 String mensaje;
	
    @HttpMethod(HttpMethodType.POST)
    @RequireLogin(true)
    //../registrodatos?f=registroAlumno
    public void registrarAlumno() throws IOException, Exception {
    	Alumno alu = new Alumno();
        alu.setPersona(new Persona());
        alu.getPersona().setId(request.getParameter("id"));
        alu.getPersona().setNombre(request.getParameter("nom"));
        alu.getPersona().setApellidopaterno(request.getParameter("apepat"));
        alu.getPersona().setApellidomaterno(request.getParameter("apemat"));
        alu.getPersona().setSexo(request.getParameter("sexo"));
        
        alu.setDni(request.getParameter("dni"));
        alu.setFechanacimiento(request.getParameter("fecnac"));
        alu.setDireccion(request.getParameter("dir"));
        alu.setNumerocelular(Integer.parseInt(request.getParameter("numcel")));
        
        alu.setModalidadingreso(new ModalidadIngreso());
        alu.getModalidadingreso().setId(request.getParameter("mod"));
        
        alu.setEspecialidad(new Especialidad());
        alu.getEspecialidad().setId(Integer.parseInt(request.getParameter("especialidad")));
        
        alu.setDistrito(new Distrito());
        alu.getDistrito().setId(Integer.parseInt(request.getParameter("dis")));
        
        
        DAOFactory oDAOFactory;
        response.setContentType("application/json;charset=UTF-8");
        PrintWriter out = response.getWriter();
        Gson gson = new Gson();
        try {
            oDAOFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
            oDAOFactory.getConvalidacion().getHistoriaConvalidacion().registrarAlumno(alu);
            mensaje="OK";
        } catch (Exception e) {
            
            mensaje=e.getMessage();
            throw e;
        } finally {
            out.print(gson.toJson(mensaje));
            out.close();
        }

    }
    
    @HttpMethod(HttpMethodType.POST)
    @RequireLogin(false)
    public void registrarCursos() throws IOException, Exception {
    	List<AlumnoConvalidacion> conalus;
        String listjson = request.getParameter("convalidaciones");
        
        JsonElement json = new JsonParser().parse(listjson);
        JsonArray array = json.getAsJsonArray();
        Iterator iterator = array.iterator();
        conalus = new ArrayList<>();
        
        while(iterator.hasNext()){
        	JsonElement json1 = (JsonElement) iterator.next();
        	Gson gson = new Gson();
        	AlumnoConvalidacion conalu = gson.fromJson(json1, AlumnoConvalidacion.class);
        	conalus.add(conalu);
        	
        }
        
        DAOFactory oDAOFactory;
        response.setContentType("application/json;charset=UTF-8");
        PrintWriter out = response.getWriter();
        Gson gson = new Gson();
        try {
            oDAOFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
            oDAOFactory.getConvalidacion().getHistoriaConvalidacion().registrarConvalidacionAlumno(conalus);;
            mensaje="OK";
        } catch (Exception e) {
            
            mensaje=e.getMessage();
            throw e;
        } finally {
            out.print(gson.toJson(mensaje));
            out.close();
        }

    }
}
