package edu.usmp.fia.taller.common.bean.SimulacionMatricula;

import java.util.ArrayList;
import java.util.List;

public class Curso {

	
	private String mCodigo;
	private String mEstado;	
	private String mCurso;
	private String mCredito;
	private String mCiclo;	
	private String mTipoCurso;
	private int mCantidadAlumnos;	
	private String mArea;	
	private String mTurno;
	private String mCondicion;
	private String mHorasTeoria;
	private String mHorasLaboratorio;
	private String mHorasPractica;
	private List<Profesor> mProfesor;
	private List<Seccion> mSeccion;
	private String mSeccio;
	
	public Curso()
	{
		mCodigo="";
		mEstado="";
		mCurso="";
		mCredito="";
		mCiclo="";
		mTipoCurso="";
		mCantidadAlumnos=0;
		mArea="";
		mTurno="";
		mCondicion="";
		mHorasTeoria="";
		mHorasLaboratorio="";
		mHorasPractica="";
		mSeccion=new ArrayList<Seccion>();
		mSeccio="";
	}	
	
	public String getCodigo() {
		return mCodigo;
	}
	public void setCodigo(String mCodigo) {
		this.mCodigo = mCodigo;
	}
	public String getEstado() {
		return mEstado;
	}
	public void setEstado(String mEstado) {
		this.mEstado = mEstado;
	}
	public String getCurso() {
		return mCurso;
	}
	public void setCurso(String mCurso) {
		this.mCurso = mCurso;
	}
	public String getCredito() {
		return mCredito;
	}
	public void setCredito(String mCredito) {
		this.mCredito = mCredito;
	}
	public String getCiclo() {
		return mCiclo;
	}
	public void setCiclo(String mCiclo) {
		this.mCiclo = mCiclo;
	}
	public String getTipoCurso() {
		return mTipoCurso;
	}
	public void setTipoCurso(String mTipoCurso) {
		this.mTipoCurso = mTipoCurso;
	}
	public int getCantidadAlumnos() {
		return mCantidadAlumnos;
	}
	public void setCantidadAlumnos(int mCantidadAlumnos) {
		this.mCantidadAlumnos = mCantidadAlumnos;
	}
	public String getArea() {
		return mArea;
	}
	public void setArea(String mArea) {
		this.mArea = mArea;
	}
	public String getTurno() {
		return mTurno;
	}
	public void setTurno(String mTurno) {
		this.mTurno = mTurno;
	}
	public List<Profesor> getProfesor() {
		return mProfesor;
	}
	public void setProfesor(ArrayList<Profesor> mProfesor) {
		this.mProfesor = mProfesor;
	}
	public String getCondicion() {
		return mCondicion;
	}
	public void setCondicion(String mCondicion) {
		this.mCondicion = mCondicion;
	}
	public String getHorasTeoria() {
		return mHorasTeoria;
	}
	public void setHorasTeoria(String mHorasTeoria) {
		this.mHorasTeoria = mHorasTeoria;
	}
	public String getHorasLaboratorio() {
		return mHorasLaboratorio;
	}
	public void setHorasLaboratorio(String mHorasLaboratorio) {
		this.mHorasLaboratorio = mHorasLaboratorio;
	}
	public String getHorasPractica() {
		return mHorasPractica;
	}
	public void setHorasPractica(String mHorasPractica) {
		this.mHorasPractica = mHorasPractica;
	}
	public List<Seccion> getSeccion() {
		return mSeccion;
	}
	public void setSeccion(List<Seccion> mSeccion) {
		this.mSeccion = mSeccion;
	}
	public String getSeccio() {
		return mSeccio;
	}
	public void setSeccio(String mSeccio) {
		this.mSeccio = mSeccio;
	}
}

