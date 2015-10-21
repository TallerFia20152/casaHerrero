package edu.usmp.fia.taller.common.bean.RegistroDocente;

public class Documento {
	
	private int idDocumento;
	private String id_profesor;
	private String numero;
	private char tipo;
	
	public int getIdDocumento() {
		return idDocumento;
	}
	public void setIdDocumento(int idDocumento) {
		this.idDocumento = idDocumento;
	}
	public String getId_profesor() {
		return id_profesor;
	}
	public void setId_profesor(String id_profesor) {
		this.id_profesor = id_profesor;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public char getTipo() {
		return tipo;
	}
	public void setTipo(char tipo) {
		this.tipo = tipo;
	}
	
}
