package edu.usmp.fia.taller.common.bean.convalidacioncurso;

public class PlanCurricularDetalle {

	private PlanCurricular plancurricular;
	private Curso curso;
	private int creditos;
	private Ciclo ciclo;
	private CursoCondicion cursocondicion;
	private int horasteoria;
	private int horaslaboratorio;
	private int horaspractica;
	private int creditosrequisito;
	private CursoArea cursoarea;
	private String estado;
	private int ordenar;

	public PlanCurricular getPlancurricular() {
		return plancurricular;
	}

	public void setPlancurricular(PlanCurricular plancurricular) {
		this.plancurricular = plancurricular;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public int getCreditos() {
		return creditos;
	}

	public void setCreditos(int creditos) {
		this.creditos = creditos;
	}

	public Ciclo getCiclo() {
		return ciclo;
	}

	public void setCiclo(Ciclo ciclo) {
		this.ciclo = ciclo;
	}

	public CursoCondicion getCursocondicion() {
		return cursocondicion;
	}

	public void setCursocondicion(CursoCondicion cursocondicion) {
		this.cursocondicion = cursocondicion;
	}

	public int getHorasteoria() {
		return horasteoria;
	}

	public void setHorasteoria(int horasteoria) {
		this.horasteoria = horasteoria;
	}

	public int getHoraslaboratorio() {
		return horaslaboratorio;
	}

	public void setHoraslaboratorio(int horaslaboratorio) {
		this.horaslaboratorio = horaslaboratorio;
	}

	public int getHoraspractica() {
		return horaspractica;
	}

	public void setHoraspractica(int horaspractica) {
		this.horaspractica = horaspractica;
	}

	public int getCreditosrequisito() {
		return creditosrequisito;
	}

	public void setCreditosrequisito(int creditosrequisito) {
		this.creditosrequisito = creditosrequisito;
	}

	public CursoArea getCursoarea() {
		return cursoarea;
	}

	public void setCursoarea(CursoArea cursoarea) {
		this.cursoarea = cursoarea;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public int getOrdenar() {
		return ordenar;
	}

	public void setOrdenar(int ordenar) {
		this.ordenar = ordenar;
	}

}
