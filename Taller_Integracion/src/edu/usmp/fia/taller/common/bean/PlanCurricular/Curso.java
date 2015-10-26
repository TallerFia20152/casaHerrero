package edu.usmp.fia.taller.common.bean.PlanCurricular;
import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class Curso implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@JsonProperty
	private int id;
	@JsonProperty
	private String code;
	@JsonProperty
	private String name;
	@JsonProperty
	private int cycle;
	@JsonProperty
	private int type;
	@JsonProperty
	private List<String> mentions;
	@JsonProperty
	private int credits;

	@JsonProperty
	private int theoHours;
	@JsonProperty
	private int pracHours;
	@JsonProperty
	private int laboHours;

	@JsonProperty
	private String description;
	@JsonProperty
	private List<String> requirements;

	public Curso() {
	}
	
	public Curso(Curso course) {
		this.id 	= course.getId();
		this.code	= course.getCode();
		this.name 	= course.getName();
		this.cycle	= course.getCycle();
		this.type 	= course.getType();
		this.mentions = course.getMentions();
		this.credits = course.getCredits();
		this.theoHours = course.getTheoHours();
		this.pracHours = course.getPracHours();
		this.laboHours = course.getLaboHours();
		this.description = course.getDescription();
		this.requirements = course.getRequirements();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCycle() {
		return cycle;
	}

	public void setCycle(int cycle) {
		this.cycle = cycle;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public List<String> getMentions() {
		return mentions;
	}

	public void setMentions(List<String> mentions) {
		this.mentions = mentions;
	}

	public int getCredits() {
		return credits;
	}

	public void setCredits(int credits) {
		this.credits = credits;
	}

	public int getTheoHours() {
		return theoHours;
	}

	public void setTheoHours(int theoHours) {
		this.theoHours = theoHours;
	}

	public int getPracHours() {
		return pracHours;
	}

	public void setPracHours(int pracHours) {
		this.pracHours = pracHours;
	}

	public int getLaboHours() {
		return laboHours;
	}

	public void setLaboHours(int laboHours) {
		this.laboHours = laboHours;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<String> getRequirements() {
		return requirements;
	}

	public void setRequirements(List<String> requirements) {
		this.requirements = requirements;
	}

}
