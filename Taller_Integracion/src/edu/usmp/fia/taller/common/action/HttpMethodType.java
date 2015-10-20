package edu.usmp.fia.taller.common.action;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

public enum HttpMethodType {

	
	GET("GET"),
	POST("POST"),
	PUT("PUT"),
	DELETE("DELETE"),
	HEAD("HEAD"),
	OPTIONS("OPTIONS");
	
	private final String text;


	private static final Map<String,HttpMethodType> lookup = new HashMap<String,HttpMethodType>();
    
	static {
        for(HttpMethodType s : EnumSet.allOf(HttpMethodType.class))
             lookup.put(s.getText(), s);
    	}
	    
	    
	private HttpMethodType(String text) {
		this.text = text;
	}
	    
	public String getText() {
		return this.text;
	}
	    
	public boolean equalsText(String text){
		return this.text.equals(text);
	}
	    
	public static HttpMethodType get(String text) { 
		return lookup.get(text); 
	}
	
}
