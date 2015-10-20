package edu.usmp.fia.taller.elaboracionhorario.servlet;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.annotation.WebServlet;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;




import edu.usmp.fia.taller.common.action.ActionServlet;
import edu.usmp.fia.taller.common.action.Default;
import edu.usmp.fia.taller.common.action.HttpMethod;
import edu.usmp.fia.taller.common.action.HttpMethodType;
import edu.usmp.fia.taller.common.action.RequireLogin;
import edu.usmp.fia.taller.common.bean.ElaboracionHorarios.*;
import edu.usmp.fia.taller.common.dao.DAOFactory;
import edu.usmp.fia.taller.common.dao.MySqlDAOFactory;

@WebServlet("/cargarExcels")
public class CargarExcel extends ActionServlet  {
	
	
	@HttpMethod(HttpMethodType.GET)
	@RequireLogin(true)
	public void leerExcel() throws Exception {
		request.getServletContext().getRequestDispatcher("/ElaboracionHorarios/cargarExcel.jsp").forward(request, response);
	}
	
	@HttpMethod(HttpMethodType.POST)
	@Default
	@RequireLogin(true)
	public void cargarExcel() throws Exception {
		// TODO Auto-generated method stub
				response.setContentType("text/html");
				   PrintWriter out = response.getWriter();
				String saveFile="";
				String contentType = request.getContentType();
				if ((contentType != null) && (contentType.indexOf("multipart/form-data") >= 0)) {
				DataInputStream in = new DataInputStream(request.getInputStream());
				int formDataLength = request.getContentLength();
				byte dataBytes[] = new byte[formDataLength];
				int byteRead = 0;
				int totalBytesRead = 0;
				while (totalBytesRead < formDataLength) {
				byteRead = in.read(dataBytes, totalBytesRead,formDataLength);
				totalBytesRead += byteRead;
				}
				String file = new String(dataBytes);
				saveFile = file.substring(file.indexOf("filename=\"") + 10);
				saveFile = saveFile.substring(0, saveFile.indexOf("\n"));
				saveFile = saveFile.substring(saveFile.lastIndexOf("\\") + 1,saveFile.indexOf("\""));
				int lastIndex = contentType.lastIndexOf("=");
				String boundary = contentType.substring(lastIndex + 1,contentType.length());
				int pos;
				pos = file.indexOf("filename=\"");
				pos = file.indexOf("\n", pos) + 1;
				pos = file.indexOf("\n", pos) + 1;
				pos = file.indexOf("\n", pos) + 1;
				int boundaryLocation = file.indexOf(boundary, pos) - 4;
				int startPos = ((file.substring(0, pos)).getBytes()).length;
				int endPos = ((file.substring(0, boundaryLocation)).getBytes()).length;
				File ff = new File(saveFile);
				FileOutputStream fileOut = new FileOutputStream(ff);
				fileOut.write(dataBytes, startPos, (endPos - startPos));
				fileOut.flush();
				fileOut.close();
				System.out.println("llege antes del read");
				List<HorariosBean> lisHorario=readExcelFile(saveFile);
				if(lisHorario.isEmpty()){
					request.setAttribute("mensaje", "No cargo data");
				}else{
					request.setAttribute("listaHorario", lisHorario);
				}
			
				}
				System.out.println("no llege antes del read");
				response.sendRedirect("ElaboracionHorariosServlet?f=leerHorario");
	}
	
	
	private List<HorariosBean> readExcelFile(String fileName) throws Exception {

		
		List<Curso> listaCurso = new ArrayList<Curso>();
		DAOFactory oDAOFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		listaCurso= oDAOFactory.getElaboracionHorario().elabHorarios().getCursoAll();
		System.out.println("listaCurso: "+listaCurso.size());
		HorariosBean horarios=null;
		List<HorariosBean> listaHorario= new ArrayList<HorariosBean>();
		try {

			   Workbook wb = WorkbookFactory.create(new File(fileName));
			   Sheet mySheet = wb.getSheetAt(0);
			   Iterator<Row> rowIter = mySheet.rowIterator();
			    System.out.println(mySheet.getRow(1).getCell(0));
			
	//	/**	
			FileInputStream fileInputStream = new FileInputStream(fileName);
			POIFSFileSystem fsFileSystem = new POIFSFileSystem(fileInputStream);
			HSSFWorkbook workBook = new HSSFWorkbook(fsFileSystem);
			HSSFSheet hssfSheet = workBook.getSheetAt(0);
			Row row;
	//	**/
			System.out.println(hssfSheet.getLastRowNum());
            for(int i=1; i<=hssfSheet.getLastRowNum(); i++){
            	
            	horarios= new HorariosBean();
                row = hssfSheet.getRow(i);    
                if(!row.getCell(0).getStringCellValue().equals("") && !row.getCell(0).getStringCellValue().equals("CODFAC")){
	            	horarios.setCodFac(Integer.parseInt(row.getCell(0).getStringCellValue()));
	            	horarios.setC01(Integer.parseInt(row.getCell(1).getStringCellValue()));
	            	horarios.setCicest(row.getCell(2).getStringCellValue());
	            	horarios.setTur(row.getCell(3).getStringCellValue());
	            	horarios.setCodCur(Integer.parseInt(row.getCell(4).getStringCellValue()));
	            	if(row.getCell(5).getStringCellValue().equals("")){
	            		horarios.setCodCurteo(0);
	            	}else{
	            		horarios.setCodCurteo(Integer.parseInt(row.getCell(5).getStringCellValue()));
	            	}
	            	
	            	horarios.setProfesor(row.getCell(6).getStringCellValue());
	            	horarios.setCurso(row.getCell(7).getStringCellValue());
	            	horarios.setDesRes(row.getCell(8).getStringCellValue());
	            	horarios.setCodSec(row.getCell(9).getStringCellValue());
	            	horarios.setAula(row.getCell(10).getStringCellValue());
	            	horarios.setEscual(row.getCell(11).getStringCellValue());
	            	horarios.setNumCre(Integer.parseInt(row.getCell(12).getStringCellValue()));
	            	horarios.setLunes(row.getCell(13).getStringCellValue());
	            	horarios.setMartes(row.getCell(14).getStringCellValue());
	            	horarios.setMiercoles(row.getCell(15).getStringCellValue());
	            	horarios.setJueves(row.getCell(16).getStringCellValue());
	            	horarios.setViernes(row.getCell(17).getStringCellValue());
	            	horarios.setSabado(row.getCell(18).getStringCellValue());
	            	horarios.setDomingo(row.getCell(19).getStringCellValue());
        			//int ilistaCurso= oDAOFactory.getElaboracionHorario().elabHorarios().insertHorarios(horarios);
	            	// inicio validar si los cursos estan como esta en el excel
	            	for(int z=0;z<listaCurso.size();z++){
	            		
	            		if(horarios.getCurso().equalsIgnoreCase(listaCurso.get(z).getNombreCurso())){
	            			System.out.println("CURSOS IGUAL: "+horarios.getCurso()+"=="+listaCurso.get(z).getNombreCurso());

	            			
	            		}
	            	}
	            	//System.out.println("registro:"+ilistaCurso);
	                listaHorario.add(horarios);    
	                
                }else{
                	break;
                }
            }
                       
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		return listaHorario;
	}

}
