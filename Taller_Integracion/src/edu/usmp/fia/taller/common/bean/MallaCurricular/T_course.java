package edu.usmp.fia.taller.common.bean.MallaCurricular;

public class T_course {
	int id;
	String name;
	int t_cycle_id;
	String mencion;
	
//	int t_course_id;
//	int credit;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMencion() {
		return mencion;
	}
	public void setMencion(String mencion) {
		this.mencion = mencion;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getT_cycle_id() {
		return t_cycle_id;
	}
	public void setT_cycle_id(int t_cycle_id) {
		this.t_cycle_id = t_cycle_id;
	}
	
//	public int getT_course_id() {
//		return t_course_id;
//	}
//	public void setT_course_id(int t_course_id) {
//		this.t_course_id = t_course_id;
//	}
//	public int getCredit() {
//		return credit;
//	}
//	public void setCredit(int credit) {
//		this.credit = credit;
//	}
	
	

}
