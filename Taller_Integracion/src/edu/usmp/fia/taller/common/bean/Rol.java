package edu.usmp.fia.taller.common.bean;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;


public enum Rol {

	ADMINISTRADOR(1),
	DOCENTE(2),
	ALUMNO(3),
	JEFE_DE_PROYECTO(4);
	
	private final int id;


	private static final Map<Integer, Rol> lookup = new HashMap<Integer, Rol>();
    
	static {
        for(Rol s : EnumSet.allOf(Rol.class))
             lookup.put(s.getId(), s);
    	}
	    
	    
	private Rol(int id) {
		this.id = id;
	}
	    
	public int getId() {
		return this.id;
	}
   
	public static Rol get(int id) { 
		return lookup.get(id); 
	}
	
}
