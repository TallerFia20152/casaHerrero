package edu.usmp.fia.taller.common.util;

public class ThreadUtil {
	
	public static int getCallerModule(){
	   StackTraceElement[] steList = Thread.currentThread().getStackTrace();
	   
	   for (int i=steList.length-1;i>=0;i--){
		   StackTraceElement ste = steList[i];
		   if(ste.getClassName().contains("edu.usmp.fia.taller.commons.dao.modules")){
			   return 0;
       	   }else if(ste.getClassName().contains("edu.usmp.fia.taller.seguimiento.dao")){
       		   return 1;
       	   }else if(ste.getClassName().contains("edu.usmp.fia.taller.ejemplo.dao")){
       		   return 2;
       	   }
	   }
	   //return -1;
	   return 0;
	}
	
}
