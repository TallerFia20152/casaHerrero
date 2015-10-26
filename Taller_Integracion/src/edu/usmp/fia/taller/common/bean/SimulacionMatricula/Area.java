package edu.usmp.fia.taller.common.bean.SimulacionMatricula;

import java.util.ArrayList;
import java.util.List;

public class Area {
	
	private int mId;	
	private String mNombre;	
	private List<Curso> mCursoList;
	
	public Area()
	{
		mId=0;
		mNombre="";
		mCursoList= new ArrayList<Curso>();
	}
	
	public Integer getId() {
		return mId;
	}
	public void setId(Integer mId) {
		this.mId = mId;
	}
	public String getNombre() {
		return mNombre;
	}
	public void setNombre(String mNombre) {
		this.mNombre = mNombre;
	}
	public List<Curso> getCursoList() {
		return mCursoList;
	}
	public void setCursoList(List<Curso> mCursoList) {
		this.mCursoList = mCursoList;
	}

	
	
}
