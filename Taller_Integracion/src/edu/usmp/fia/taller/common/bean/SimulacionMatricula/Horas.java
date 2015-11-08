package edu.usmp.fia.taller.common.bean.SimulacionMatricula;

public class Horas {
	
	private String mId;
	private String mDia;
	private String mHoraInicio;
	private String mHoraFin;


	public Horas()
	{
		mId="";
		mDia="";
		mHoraInicio="";	
		mHoraFin="";		
	}

	public String getId() {
		return mId;
	}

	public void setId(String mId) {
		this.mId = mId;
	}

	public String getDia() {
		return mDia;
	}

	public void setDia(String mDia) {
		this.mDia = mDia;
	}

	public String getHoraInicio() {
		return mHoraInicio;
	}

	public void setHoraInicio(String mHoraInicio) {
		this.mHoraInicio = mHoraInicio;
	}

	public String getHoraFin() {
		return mHoraFin;
	}

	public void setHoraFin(String mHoraFin) {
		this.mHoraFin = mHoraFin;
	}
	
}

