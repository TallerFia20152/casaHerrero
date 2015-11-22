package edu.usmp.fia.taller.common.bean.SimulacionMatricula;

public class CursoCruce {

	
	private String mCodigo1;
	private String mCurso1;
	private String mSeccion1;
	private String mCiclo1;
	
	private String mCodigo2;		
	private String mCurso2;
	private String mSeccion2;
	private String mCiclo2;
	
	private int mCantidadCruce;
	
	public CursoCruce()
	{
		mCodigo1="";
		mCodigo2="";
		mCiclo1="";
		mCiclo2="";
		mCurso1="";
		mCurso2="";
		mSeccion1="";
		mSeccion2="";
	}

	public String getCodigo1() {
		return mCodigo1;
	}

	public void setCodigo1(String mCodigo1) {
		this.mCodigo1 = mCodigo1;
	}

	public String getCurso1() {
		return mCurso1;
	}

	public void setCurso1(String mCurso1) {
		this.mCurso1 = mCurso1;
	}

	public String getSeccion1() {
		return mSeccion1;
	}

	public void setSeccion1(String mSeccion1) {
		this.mSeccion1 = mSeccion1;
	}

	public String getCiclo1() {
		return mCiclo1;
	}

	public void setCiclo1(String mCiclo1) {
		this.mCiclo1 = mCiclo1;
	}

	public String getCodigo2() {
		return mCodigo2;
	}

	public void setCodigo2(String mCodigo2) {
		this.mCodigo2 = mCodigo2;
	}

	public String getCurso2() {
		return mCurso2;
	}

	public void setCurso2(String mCurso2) {
		this.mCurso2 = mCurso2;
	}

	public String getSeccion2() {
		return mSeccion2;
	}

	public void setSeccion2(String mSeccion2) {
		this.mSeccion2 = mSeccion2;
	}

	public String getCiclo2() {
		return mCiclo2;
	}

	public void setCiclo2(String mCiclo2) {
		this.mCiclo2 = mCiclo2;
	}

	public int getCantidadCruce() {
		return mCantidadCruce;
	}

	public void setCantidadCruce(int mCantidadCruce) {
		this.mCantidadCruce = mCantidadCruce;
	}	
}

