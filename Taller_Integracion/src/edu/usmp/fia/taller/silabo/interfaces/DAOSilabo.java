package edu.usmp.fia.taller.silabo.interfaces;
import java.util.Vector;

import edu.usmp.fia.taller.common.bean.silabo.CursoBean;
import edu.usmp.fia.taller.common.bean.silabo.SilaboBean;

public interface DAOSilabo {
	
	public Vector<CursoBean>  listar() throws Exception;
	public Vector<SilaboBean>  listarSilabo(String id) throws Exception;
	public Vector<CursoBean>  listarPlan() throws Exception;
	public int agregarSilabo(String idCurso,String idPc,String pFin,String fecha) throws Exception;
	public boolean modificarSilabo(String idCurso,String idPc,String idBi,String idSemana,String pFin,String fecha) throws Exception;
	public void agregarBibliografia(int id_silabo,String reseña) throws Exception;
	public void agregarSemana(int numsemana, int numsesion, int id_silabo,String titulo,String descripcion) throws Exception;
}
