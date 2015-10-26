package edu.usmp.fia.taller.common.bean.PlanCurricular;

import java.io.Serializable;
import java.util.UUID;

import edu.usmp.fia.taller.common.bean.PlanCurricular.Curso;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class ChangeBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@JsonProperty
	private String uuid;
	@JsonProperty
	private int code;
	@JsonProperty
	private int type;
	@JsonProperty
	private String name;
	@JsonProperty
	private String message;
	@JsonProperty
	private int state;
	@JsonProperty
	private Curso course;
	@JsonProperty
	private String description;
	public ChangeBean() {
		this.uuid = UUID.randomUUID().toString();
	}
	public ChangeBean(int type, String name) {
		this.uuid = UUID.randomUUID().toString();
		this.type = type;
		this.name = name;
		this.state = 1;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public Curso getCourse() {
		return course;
	}
	public void setCourse(Curso course) {
		this.course = course;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	@JsonIgnore
	public boolean isEnable(){
		if (this.state == 1) {
			return true;
		}
		return false;
	}
}
