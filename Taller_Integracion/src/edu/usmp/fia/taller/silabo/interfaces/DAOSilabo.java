package edu.usmp.fia.taller.silabo.interfaces;
import java.util.Vector;

import edu.usmp.fia.taller.common.bean.silabo.BibliografiaBean;
import edu.usmp.fia.taller.common.bean.silabo.CursoBean;
import edu.usmp.fia.taller.common.bean.silabo.SemanaBean;
import edu.usmp.fia.taller.common.bean.silabo.SilaboBean;

public interface DAOSilabo {
	
	public Vector<CursoBean>  listar() throws Exception;
	public Vector<BibliografiaBean>  listarBibliografia(String id) throws Exception;
	public Vector<SilaboBean>  listarSilabo(String id) throws Exception;
	public Vector<SemanaBean> listarSemana(String id) throws Exception ;
	public Vector<CursoBean>  listarPlan() throws Exception;
	public Vector<CursoBean> listarCursoxSilabo() throws Exception;
	public int agregarSilabo(String idCurso,String idPc,String pFin,String fecha) throws Exception;
	public boolean modificarSilabo(String promedio,String IdSilabo) throws Exception;
	public boolean modificarBibliografia(String id_silabo,String reseña) throws Exception;
	public void agregarBibliografia(int id_silabo,String reseña) throws Exception;
	public void agregarSemana(int numsemana, int numsesion, int id_silabo,String titulo) throws Exception;
	 
	/// Curso
	
	public Vector<CursoBean>  listarCurso() throws Exception;
	public Vector<CursoBean> listarCursoxID(String id) throws Exception;
	public boolean agregarCurso(String codigo,String nombre,String tipo,String sumilla) throws Exception;
	public boolean modificarCurso(String id,String nombre,String tipo, String estado) throws Exception;
	public boolean eliminarCurso(String id) throws Exception;
	public boolean validarCurso(String nombre) throws Exception;
	
}
