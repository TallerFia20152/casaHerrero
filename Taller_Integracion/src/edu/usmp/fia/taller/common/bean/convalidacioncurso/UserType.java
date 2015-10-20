package edu.usmp.fia.taller.common.bean.convalidacioncurso;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;


public enum UserType {

	ALUMNO(1),
	DOCENTE(2),
	ADMINISTRATIVO(3);
	
	private final int id;


	private static final Map<Integer, UserType> lookup = new HashMap<Integer, UserType>();
    
	static {
        for(UserType s : EnumSet.allOf(UserType.class))
             lookup.put(s.getId(), s);
    	}
	    
	    
	private UserType(int id) {
		this.id = id;
	}
	    
	public int getId() {
		return this.id;
	}
   
	public static UserType get(int id) { 
		return lookup.get(id); 
	}
	
}
