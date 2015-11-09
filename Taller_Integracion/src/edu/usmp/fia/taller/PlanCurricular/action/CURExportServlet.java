package edu.usmp.fia.taller.PlanCurricular.action;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.usmp.fia.taller.PlanCurricular.business.CurriculumBusiness;
import edu.usmp.fia.taller.PlanCurricular.business.impl.CurriculumBusinessImpl;
import edu.usmp.fia.taller.PlanCurricular.util.Constants;
import edu.usmp.fia.taller.common.bean.PlanCurricular.Curso;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JasperRunManager;


@WebServlet("/exportChanges")
public class CURExportServlet extends HttpServlet implements Constants {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HashMap<String, Object> hm = new HashMap<String, Object>();		
		CurriculumBusiness chgBusiness = new CurriculumBusinessImpl();
		//obtener todos los cursos obligatorios, de mencion y electivos libres
		Map<String, List<Curso>> curriculum = chgBusiness.getCurrentCurriculum();
		List<Curso> cursosObli = new ArrayList<Curso>();
		List<Curso> cursosMenc = new ArrayList<Curso>();
		List<Curso> cursosLibr = new ArrayList<Curso>();
		cursosObli = curriculum.get(Constants.CURRICULUM_REQUIRED_COURSES);
		cursosMenc = curriculum.get(Constants.CURRICULUM_MENTION_COURSES);
		cursosLibr = curriculum.get(Constants.CURRICULUM_FREE_COURSES);
		// curriculum.get(Constants.CURRICULUM_ALL_COURSES));
		
		//lista de cursos por ciclo y mencion
		List<String> listaCodigoI = new ArrayList<String>();
		List<String> listaNombreI = new ArrayList<String>();
		List<String> listaCreditosI = new ArrayList<String>();
		List<String> listaRequisitosI = new ArrayList<String>();
		int total1 = 0;
		List<String> listaCodigoII = new ArrayList<String>();
		List<String> listaNombreII = new ArrayList<String>();
		List<String> listaCreditosII = new ArrayList<String>();
		List<String> listaRequisitosII = new ArrayList<String>();
		int total2 = 0;
		List<String> listaCodigoIII = new ArrayList<String>();
		List<String> listaNombreIII = new ArrayList<String>();
		List<String> listaCreditosIII = new ArrayList<String>();
		List<String> listaRequisitosIII = new ArrayList<String>();
		int total3 = 0;
		List<String> listaCodigoIV = new ArrayList<String>();
		List<String> listaNombreIV = new ArrayList<String>();
		List<String> listaCreditosIV = new ArrayList<String>();
		List<String> listaRequisitosIV = new ArrayList<String>();
		int total4 = 0;
		List<String> listaCodigoV = new ArrayList<String>();
		List<String> listaNombreV = new ArrayList<String>();
		List<String> listaCreditosV = new ArrayList<String>();
		List<String> listaRequisitosV = new ArrayList<String>();
		int total5 = 0;
		List<String> listaCodigoVI = new ArrayList<String>();
		List<String> listaNombreVI = new ArrayList<String>();
		List<String> listaCreditosVI = new ArrayList<String>();
		List<String> listaRequisitosVI = new ArrayList<String>();
		int total6 = 0;
		List<String> listaCodigoVII = new ArrayList<String>();
		List<String> listaNombreVII = new ArrayList<String>();
		List<String> listaCreditosVII = new ArrayList<String>();
		List<String> listaRequisitosVII = new ArrayList<String>();
		int total7 = 0;
		List<String> listaCodigoVIII = new ArrayList<String>();
		List<String> listaNombreVIII = new ArrayList<String>();
		List<String> listaCreditosVIII = new ArrayList<String>();
		List<String> listaRequisitosVIII = new ArrayList<String>();
		int total8 = 0;
		List<String> listaCodigoIX = new ArrayList<String>();
		List<String> listaNombreIX = new ArrayList<String>();
		List<String> listaCreditosIX = new ArrayList<String>();
		List<String> listaRequisitosIX = new ArrayList<String>();
		int total9 = 0;
		List<String> listaCodigoX = new ArrayList<String>();
		List<String> listaNombreX = new ArrayList<String>();
		List<String> listaCreditosX = new ArrayList<String>();
		List<String> listaRequisitosX = new ArrayList<String>();
		int total10 = 0;
		List<String> listaCodigoSI = new ArrayList<String>();
		List<String> listaNombreSI = new ArrayList<String>();
		List<String> listaCreditosSI = new ArrayList<String>();
		List<String> listaRequisitosSI = new ArrayList<String>();
		List<String> listaCodigoTI = new ArrayList<String>();
		List<String> listaNombreTI = new ArrayList<String>();
		List<String> listaCreditosTI = new ArrayList<String>();
		List<String> listaRequisitosTI = new ArrayList<String>();
		List<String> listaCodigoIS = new ArrayList<String>();
		List<String> listaNombreIS = new ArrayList<String>();
		List<String> listaCreditosIS = new ArrayList<String>();
		List<String> listaRequisitosIS = new ArrayList<String>();
		List<String> listaCodigoEL = new ArrayList<String>();
		List<String> listaNombreEL = new ArrayList<String>();
		List<String> listaCreditosEL = new ArrayList<String>();
		List<String> listaRequisitosEL = new ArrayList<String>();
		//		
		Curso tmp = new Curso();
		for (Iterator<Curso> iter = cursosObli.iterator(); iter.hasNext();) {
			tmp = (Curso)iter.next();
			int ciclo = tmp.getCycle();
			switch (ciclo) {
			case 1:
				agregarDatos(listaCodigoI, listaNombreI, listaCreditosI, listaRequisitosI, tmp);
				total1 = total1 + tmp.getCredits();
				break;
			case 2:
				agregarDatos(listaCodigoII, listaNombreII, listaCreditosII, listaRequisitosII, tmp);
				total2 = total2 + tmp.getCredits();
				break;
			case 3:
				agregarDatos(listaCodigoIII, listaNombreIII, listaCreditosIII, listaRequisitosIII, tmp);
				total3 = total3 + tmp.getCredits();
				break;
			case 4:
				agregarDatos(listaCodigoIV, listaNombreIV, listaCreditosIV, listaRequisitosIV, tmp);
				total4 = total4 + tmp.getCredits();
				break;
			case 5:
				agregarDatos(listaCodigoV, listaNombreV, listaCreditosV, listaRequisitosV, tmp);
				total5 = total5 + tmp.getCredits();
				break;
			case 6:
				agregarDatos(listaCodigoVI, listaNombreVI, listaCreditosVI, listaRequisitosVI, tmp);
				total6 = total6 + tmp.getCredits();
				break;
			case 7:
				agregarDatos(listaCodigoVII, listaNombreVII, listaCreditosVII, listaRequisitosVII, tmp);
				total7 = total7 + tmp.getCredits();
				break;
			case 8:
				agregarDatos(listaCodigoVIII, listaNombreVIII, listaCreditosVIII, listaRequisitosVIII, tmp);
				total8 = total8 + tmp.getCredits();
				break;
			case 9:
				agregarDatos(listaCodigoIX, listaNombreIX, listaCreditosIX, listaRequisitosIX, tmp);
				total9 = total9 + tmp.getCredits();
				break;
			case 10:
				agregarDatos(listaCodigoX, listaNombreX, listaCreditosX, listaRequisitosX, tmp);
				total10 = total10 + tmp.getCredits();
				break;
			default:
				break;
			}
		}
		listaCreditosI.add("" + total1);
		listaCreditosII.add("" + total2);
		listaCreditosIII.add("" +total3);
		listaCreditosIV.add("" + total4);
		listaCreditosV.add("" + total5);
		listaCreditosVI.add("" + total6);
		listaCreditosVII.add("" + total7);
		listaCreditosVIII.add("" + total8);
		listaCreditosIX.add("" + total9);
		listaCreditosX.add("" + total10);
		
		for (Iterator<Curso> iter = cursosMenc.iterator(); iter.hasNext();) {
			tmp = (Curso)iter.next();
			List<String> menciones = tmp.getMentions();
			for (int i = 0; i < menciones.size(); i++) {
				if (Integer.parseInt(menciones.get(i)) == 1) {
					agregarDatos(listaCodigoSI, listaNombreSI, listaCreditosSI, listaRequisitosSI, tmp);
				}
				if (Integer.parseInt(menciones.get(i)) == 2) {
					agregarDatos(listaCodigoTI, listaNombreTI, listaCreditosTI, listaRequisitosTI, tmp);
				}
				if (Integer.parseInt(menciones.get(i)) == 3) {
					agregarDatos(listaCodigoIS, listaNombreIS, listaCreditosIS, listaRequisitosIS, tmp);
				}
			}
		}
		
		for (Iterator<Curso> iter = cursosLibr.iterator(); iter.hasNext();) {
			tmp = (Curso)iter.next();
		}
		String fpath = getServletContext().getRealPath("PlanCurricular/resources/PlanCurricular.jasper");
		System.out.println("fpath: " + fpath);
		String imagePath = getServletContext().getRealPath("PlanCurricular/resources/images/usmp_PNG.png");
		hm.put("imagePath", imagePath);
		hm.put("listaCodigoI", listaCodigoI);
		hm.put("listaNombreI", listaNombreI);
		hm.put("listaCreditosI", listaCreditosI);
		hm.put("listaRequisitosI", listaRequisitosI);	
		hm.put("listaCodigoII", listaCodigoII);
		hm.put("listaNombreII", listaNombreII);
		hm.put("listaCreditosII", listaCreditosII);
		hm.put("listaRequisitosII", listaRequisitosII);
		hm.put("listaCodigoIII", listaCodigoIII);
		hm.put("listaNombreIII", listaNombreIII);
		hm.put("listaCreditosIII", listaCreditosIII);
		hm.put("listaRequisitosIII", listaRequisitosIII);
		hm.put("listaCodigoIV", listaCodigoIV);
		hm.put("listaNombreIV", listaNombreIV);
		hm.put("listaCreditosIV", listaCreditosIV);
		hm.put("listaRequisitosIV", listaRequisitosIV);
		hm.put("listaCodigoV", listaCodigoV);
		hm.put("listaNombreV", listaNombreV);
		hm.put("listaCreditosV", listaCreditosV);
		hm.put("listaRequisitosV", listaRequisitosV);
		hm.put("listaCodigoVI", listaCodigoVI);
		hm.put("listaNombreVI", listaNombreVI);
		hm.put("listaCreditosVI", listaCreditosVI);
		hm.put("listaRequisitosVI", listaRequisitosVI);
		hm.put("listaCodigoVII", listaCodigoVII);
		hm.put("listaNombreVII", listaNombreVII);
		hm.put("listaCreditosVII", listaCreditosVII);
		hm.put("listaRequisitosVII", listaRequisitosVII);
		hm.put("listaCodigoVIII", listaCodigoVIII);
		hm.put("listaNombreVIII", listaNombreVIII);
		hm.put("listaCreditosVIII", listaCreditosVIII);
		hm.put("listaRequisitosVIII", listaRequisitosVIII);
		hm.put("listaCodigoIX", listaCodigoIX);
		hm.put("listaNombreIX", listaNombreIX);
		hm.put("listaCreditosIX", listaCreditosIX);
		hm.put("listaRequisitosIX", listaRequisitosIX);
		hm.put("listaCodigoX", listaCodigoX);
		hm.put("listaNombreX", listaNombreX);
		hm.put("listaCreditosX", listaCreditosX);
		hm.put("listaRequisitosX", listaRequisitosX);
		hm.put("listaCodigoSI", listaCodigoSI);
		hm.put("listaNombreSI", listaNombreSI);
		hm.put("listaCreditosSI", listaCreditosSI);
		hm.put("listaRequisitosSI", listaRequisitosSI);
		hm.put("listaCodigoTI", listaCodigoTI);
		hm.put("listaNombreTI", listaNombreTI);
		hm.put("listaCreditosTI", listaCreditosTI);
		hm.put("listaRequisitosTI", listaRequisitosTI);
		hm.put("listaCodigoIS", listaCodigoIS);
		hm.put("listaNombreIS", listaNombreIS);
		hm.put("listaCreditosIS", listaCreditosIS);
		hm.put("listaRequisitosIS", listaRequisitosIS);
		hm.put("listaCodigoEL", listaCodigoEL);
		hm.put("listaNombreEL", listaNombreEL);
		hm.put("listaCreditosEL", listaCreditosEL);
		hm.put("listaRequisitosEL", listaRequisitosEL);
		
		try{
			
			String ruta="PlanCurricular/resources/PlanCurricular.jasper";
			File reporte= new File(request.getSession().getServletContext().getRealPath(ruta));
			
			byte[] bytes = JasperRunManager.runReportToPdf(reporte.getPath(), hm, new JREmptyDataSource());

			response.setContentType("application/pdf");
			response.addHeader("Content-Type", "application/pdf");
			response.addHeader("Content-Disposition", "attachment; filename=PlanCurricular_20152.pdf");
			response.setContentLength(bytes.length);
			ServletOutputStream outStream=response.getOutputStream();
			
			outStream.write(bytes,0,bytes.length);
			outStream.flush();
			outStream.close();

		} catch (Exception ex) {
			System.out.println("ERROR  " + ex.getMessage());
		}

	}
	
	public void agregarDatos(List<String> codigos, List<String> nombres, 
			List<String> creditos, List<String> requisitos, Curso datos) {
		codigos.add(datos.getCode());
		nombres.add(datos.getName().trim());
		creditos.add("" + datos.getCredits());
		List<String> requeriments = datos.getRequirements();
		String req = "";
		for (int i = 0; i < requeriments.size(); i++) {
			if ((i + 1) == requeriments.size()) {
				req = req + requeriments.get(i);
			} else {
				req = req + requeriments.get(i) + ", ";
			}
		}
		requisitos.add(req);
	}
}
