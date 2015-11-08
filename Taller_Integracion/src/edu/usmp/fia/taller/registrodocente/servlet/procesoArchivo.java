package edu.usmp.fia.taller.registrodocente.servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * Servlet implementation class procesoArchivo
 */
@WebServlet("/procesoArchivo")
@MultipartConfig
public class procesoArchivo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public procesoArchivo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nombre=request.getParameter("nombre");
		Part arch=request.getPart("archivo");
		System.out.println("nombre: "+nombre+"arch: "+arch);
		
		InputStream is= arch.getInputStream();
		File f =new File("C:/Users/Ronald/Desktop/nueva integracion 02-11/Taller_Integracion_V7/WebContent/RegistroDocente/imagenDocente/"+nombre);
		FileOutputStream ous=new FileOutputStream(f);
		int dato =is.read();
		while(dato!=-1){
			ous.write(dato);
			dato=is.read();
		}
		ous.close();
		is.close();
		System.out.println("entro al servlet procesoArchivo");
	}

}
