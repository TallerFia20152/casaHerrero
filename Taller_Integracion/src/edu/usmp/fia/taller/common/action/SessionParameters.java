package edu.usmp.fia.taller.common.action;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

public enum SessionParameters {

	USUARIO("session-usuario");
	
	private final String text;


	private static final Map<String,SessionParameters> lookup = new HashMap<String,SessionParameters>();
    
	static {
        for(SessionParameters s : EnumSet.allOf(SessionParameters.class))
             lookup.put(s.text(), s);
    	}
	    
	    
	private SessionParameters(String text) {
		this.text = text;
	}
	    
	public String text() {
		return this.text;
	}
	    
	public boolean equalsText(String text){
		return this.text.equals(text);
	}
	    
	public static SessionParameters get(String text) { 
		return lookup.get(text); 
	}
	
	
}
