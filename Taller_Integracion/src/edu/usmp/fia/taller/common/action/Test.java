package edu.usmp.fia.taller.common.action;

public class Test {
	
	public static void main(String[] args) {
		String oText = "01";
		if(oText.matches("[12]")) {
			System.out.println("es numero");
		} else {
			System.out.println("es texto");
		}
	}

}
