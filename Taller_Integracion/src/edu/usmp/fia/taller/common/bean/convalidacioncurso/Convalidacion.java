/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.usmp.fia.taller.common.bean.convalidacioncurso;

/**
 *
 * @author Ingeniero
 */
public class Convalidacion {

    private int id;
    private Curso curso;
    private CursoOrigen cursoorigen;
    private String fecha;
    private String comentarios;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public CursoOrigen getCursoorigen() {
        return cursoorigen;
    }

    public void setCursoorigen(CursoOrigen cursoorigen) {
        this.cursoorigen = cursoorigen;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

}
