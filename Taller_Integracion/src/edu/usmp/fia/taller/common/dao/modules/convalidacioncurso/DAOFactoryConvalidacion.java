/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.usmp.fia.taller.common.dao.modules.convalidacioncurso;

import edu.usmp.fia.taller.convalidacioncurso.dataaccess.interfaces.DAOHistoriaConvalidacion;

/**
 *
 * @author Ingeniero
 */
public interface DAOFactoryConvalidacion {

    /**
     *
     * @return
     */
    public DAOHistoriaConvalidacion getHistoriaConvalidacion();
    //public DAOHistoriaConvalidacion getRegistroDatos();
}
