package edu.usmp.fia.taller.common.bean.SimulacionMatricula;

public class Profesor {

	private int mCodUSMP;
	private String mNombre;
	private String mApPaterno;
	private String mApMaterno;

	public Profesor()
	{
		mCodUSMP=0;
		mNombre="";
		mApPaterno="";
		mApMaterno="";
	}	
	
	public int getCodUSMP() {
		return mCodUSMP;
	}

	public void setCodUSMP(int mCodUSMP) {
		this.mCodUSMP = mCodUSMP;
	}

	public String getNombre() {
		return mNombre;
	}

	public void setNombre(String mNombre) {
		this.mNombre = mNombre;
	}

	public String getApPaterno() {
		return mApPaterno;
	}

	public void setApPaterno(String mApPaterno) {
		this.mApPaterno = mApPaterno;
	}

	public String getApMaterno() {
		return mApMaterno;
	}

	public void setApMaterno(String mApMaterno) {
		this.mApMaterno = mApMaterno;
	}

	/*
	 * T_PERSONA ID NOMBRE APELLIDO PATERNO APELLIDO MATERNO CODIGO USMP
	 */

}
