package edu.usmp.fia.taller.common.bean.SimulacionMatricula;

public class Alumno {

	private int mCodUSMP;
	private String mNombre;
	private String mApPaterno;
	private String mApMaterno;
	private String mCorreo;
	private Curso mCurso;

	public Alumno()
	{
		mCodUSMP=0;
		mNombre="";
		mApPaterno="";
		mApMaterno="";
		mCorreo="";
		mCurso=null;
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
	
	public String getCorreo() {
		return mCorreo;
	}

	public void setCorreo(String mCorreo) {
		this.mCorreo = mCorreo;
	}
	
	public Curso getCurso() {
		return mCurso;
	}

	public void setCurso(Curso mCurso) {
		this.mCurso = mCurso;
	}

	/*
	 * T_PERSONA ID NOMBRE APELLIDO PATERNO APELLIDO MATERNO CODIGO USMP
	 */

}
