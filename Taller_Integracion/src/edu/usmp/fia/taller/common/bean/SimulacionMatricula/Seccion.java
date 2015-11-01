package edu.usmp.fia.taller.common.bean.SimulacionMatricula;

public class Seccion {
	
	private String mId;
	private String mDescripcion;
	private String mHoraInicio;
	private String mHoraFin;
	private String mTurno;
	private String mDia;

	public Seccion()
	{
		mId="";
		mDescripcion="";
		mHoraInicio="";	
		mHoraFin="";
		mTurno="";	
		mDia="";
	}

	public String getId() {
		return mId;
	}

	public void setId(String mId) {
		this.mId = mId;
	}

	public String getDescripcion() {
		return mDescripcion;
	}

	public void setDescripcion(String mDescripcion) {
		this.mDescripcion = mDescripcion;
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

	public String getTurno() {
		return mTurno;
	}

	public void setTurno(String mTurno) {
		this.mTurno = mTurno;
	}
	
	public String getDia() {
		return mDia;
	}

	public void setDia(String mDia) {
		this.mDia = mDia;
	}
	
	


	
	
	
}

