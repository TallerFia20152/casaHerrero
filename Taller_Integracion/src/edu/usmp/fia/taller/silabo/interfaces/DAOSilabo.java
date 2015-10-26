package edu.usmp.fia.taller.silabo.interfaces;
import java.util.Vector;
import edu.usmp.fia.taller.common.bean.silabo.CursoBean;

public interface DAOSilabo {
	
	public Vector<CursoBean>  listar() throws Exception;
	public boolean agregarSilabo(String idCurso,String idPc,String idBi,String idSemana,String pFin,String fecha) throws Exception;
	//public boolean agregarSilabo() throws Exception;
	
}
