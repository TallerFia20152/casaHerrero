package edu.usmp.fia.taller.common.bean.SimulacionMatricula;

import java.sql.Timestamp;

public class Mensaje {

	private int mIdMensaje;
	private int mIdAlumno;
	private int mTipoCorreo;
	private String mAsunto;
	private String mDetalle;
	private Timestamp mFecha;

	public Mensaje()
	{
		mIdMensaje=0;
		mIdAlumno=0;
		mTipoCorreo=0;
		mAsunto="";
		mDetalle="";
		mFecha= null;
	}

	public int getIdMensaje() {
		return mIdMensaje;
	}

	public void setIdMensaje(int mIdMensaje) {
		this.mIdMensaje = mIdMensaje;
	}

	public int getIdAlumno() {
		return mIdAlumno;
	}

	public void setIdAlumno(int mIdAlumno) {
		this.mIdAlumno = mIdAlumno;
	}

	public int getTipoCorreo() {
		return mTipoCorreo;
	}

	public void setTipoCorreo(int mTipoCorreo) {
		this.mTipoCorreo = mTipoCorreo;
	}

	public String getAsunto() {
		return mAsunto;
	}

	public void setAsunto(String mAsunto) {
		this.mAsunto = mAsunto;
	}

	public String getDetalle() {
		return mDetalle;
	}

	public void setDetalle(String mDetalle) {
		this.mDetalle = mDetalle;
	}

	public Timestamp getFecha() {
		return mFecha;
	}

	public void setFecha(Timestamp mFecha) {
		this.mFecha = mFecha;
	}
	
	
}
