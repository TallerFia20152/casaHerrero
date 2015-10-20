package edu.usmp.fia.taller.convalidacioncurso.dataaccess;

import edu.usmp.fia.taller.common.dao.MySqlDAOFactory;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

public class DAO extends MySqlDAOFactory{

    private Connection conexion;
    private boolean transaccionIniciada;

    protected Connection getConexion() {
        return conexion;
    }

    protected void Conectar(boolean wTransaccion) throws Exception {
            
    this.conexion = (Connection) MySqlDAOFactory.obtenerConexion();

        if (wTransaccion == true) {
            this.conexion.setAutoCommit(false);
            this.transaccionIniciada = true;
        } else {
            this.conexion.setAutoCommit(true);
            this.transaccionIniciada = false;
        }
    }

    protected void Cerrar(boolean wEstado) throws Exception {
        if (this.conexion != null) {
            if (this.transaccionIniciada == true) {
                try {
                    if (wEstado == true) {
                        this.conexion.commit();
                    } else {
                        this.conexion.rollback();
                    }
                } catch (Exception e) {
                    throw e;
                }
            }
            try {
                this.conexion.close();
            } catch (Exception e) {
            }
        }
        this.conexion = null;
    }

    protected void EjecutarOrden(String wSQL) throws Exception {
        Statement st;

        if (this.conexion != null) {
            st = this.conexion.createStatement();
            st.executeUpdate(wSQL);
        }
    }

    protected ResultSet EjecutarOrdenDatos(String wSQL) throws Exception {
        Statement st;
        ResultSet rs = null;

        if (this.conexion != null) {
            st = this.conexion.createStatement();
            rs = st.executeQuery(wSQL);
        }

        return rs;
    }

    protected Object EjecutarProcedimiento(String wProcedimiento,
            List<Parametro> wParametros) throws Exception {
        CallableStatement cs;
        Object valor = null;
        String parNombre = "";

        try {
            cs = this.getConexion().prepareCall(wProcedimiento);
            if (wParametros != null) {
                for (Parametro par : wParametros) {
                    if (par.isEntrada() == true) {
                        cs.setObject(par.getNombre(), par.getValor());
                    } else {
                        parNombre = par.getNombre();
                        cs.registerOutParameter(par.getNombre(), par.getTipo());
                    }
                }
            }
            cs.executeUpdate();
            if (parNombre.length() > 0) {
                valor = cs.getObject(parNombre);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            cs = null;
        }

        return valor;
    }

    protected ResultSet EjecutarProcedimientoDatos(String wProcedimiento,
            List<Parametro> wParametros) throws Exception {
        CallableStatement cs;
        ResultSet rs = null;

        try {
            cs = this.getConexion().prepareCall(wProcedimiento);
            if (wParametros != null) {
                for (Parametro par : wParametros) {
                    if (par.isEntrada() == true) {
                        cs.setObject(par.getNombre(), par.getValor());
                    } else {
                        // parametro de salida
                    }
                }
            }
            rs = cs.executeQuery();
        } catch (Exception e) {
            throw e;
        } finally {
            cs = null;
        }

        return rs;
    }

}
