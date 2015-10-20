package edu.usmp.fia.taller.common.action;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import edu.usmp.fia.taller.common.bean.Persona;
import edu.usmp.fia.taller.common.bean.Usuario;

public class ActionServlet extends HttpServlet {


	protected static final Logger log = LogManager.getLogger(ActionServlet.class);
	protected HttpServletRequest request;
	protected HttpServletResponse response;
	protected Usuario usuario;

	

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		log.info("service");
		this.request = request;
		this.response = response;
		goAction();
	}
	
	
	private void goAction() throws IOException, ServletException {
		String oStrMethod = null;
		try {			
			oStrMethod = request.getParameter("f");
			System.out.println("ostrmethod: " + oStrMethod);
			if(oStrMethod==null || oStrMethod.trim().length()==0) {
				List<Method> oListMethod = getMethodsAnnotatedWith(this.getClass(), Default.class);
				if(oListMethod!=null && oListMethod.size()>0) {
					Method oMethod = oListMethod.get(0);
					log.info("oMethod.getName(): " + oMethod.getName());
					oStrMethod = oMethod.getName();
				} else {
					throw new NoSuchMethodException();
				}
			}
		
			//Method oMethod = this.getClass().getMethod(oStrMethod, HttpServletRequest.class, HttpServletResponse.class);
			Method oMethod = this.getClass().getMethod(oStrMethod);
			log.info("debug: " + oMethod.getDeclaringClass().toString());
			
			RequireLogin oAnnRequireLogin = oMethod.getAnnotation(RequireLogin.class);
			HttpMethod oInvokeAnnMethod = oMethod.getAnnotation(HttpMethod.class);
			
			HttpMethodType oReqMethodType = HttpMethodType.get(request.getMethod());			
			HttpMethodType oInvokeMethodType = HttpMethodType.GET;
			if(oInvokeAnnMethod!=null)
				oInvokeMethodType = oInvokeAnnMethod.value();
			
			if(oReqMethodType == oInvokeMethodType) {
				//oMethod.invoke(this, request, response);
				if(oAnnRequireLogin==null || oAnnRequireLogin.value()) {
					Usuario oUsuario = (Usuario)request.getSession(false).getAttribute(SessionParameters.USUARIO.text());
					log.info("oPersona: " + oUsuario.getPersona());
					if(oUsuario == null) {
						error(601, "Access denied", "Access denied");
						return;
					} else {
						this.usuario = oUsuario;
					}
				}
				oMethod.invoke(this);
				log.info("final method");
			} else { 
				throw new NoSuchMethodException();
			}
		} catch (NoSuchMethodException nsex) {
			System.out.println("error en: " + nsex.getMessage());
			nsex.printStackTrace();
			log.info(ExceptionUtils.getStackTrace(nsex));
			error(404, "The method \"" + oStrMethod + "\" not exist at \"" + this.getClass().getName(), ExceptionUtils.getStackTrace(nsex));
		} catch (Exception ex) {
			log.info(ExceptionUtils.getStackTrace(ex));
			error(500, "Se produjo un error inesperado.", ExceptionUtils.getStackTrace(ex));
		}
	}

	
	private void error(int htmlStatusCode, String description, String stacktrace) throws IOException, ServletException {
		log.info("htmlStatusCode: " + htmlStatusCode);
		response.setStatus(htmlStatusCode);
		response.setHeader("description", description);
		response.setHeader("stacktrace", stacktrace);
		//response.sendRedirect("errordetail.jsp");
		request.getServletContext().getRequestDispatcher("/errordetail.jsp").forward(request, response);
	}
	
	
	
	private List<Method> getMethodsAnnotatedWith(final Class<?> type, final Class<? extends Annotation> annotation) {
    	log.info(annotation);
	    final List<Method> oMethods = new ArrayList<Method>();
	    Class<?> oClass = type;
	    while (oClass != Object.class) {
	        final List<Method> oAllMethods = new ArrayList<Method>(Arrays.asList(oClass.getDeclaredMethods()));       
	        for (final Method oMethod : oAllMethods) {
	            if (oMethod.isAnnotationPresent( Default.class )) {
	                oMethods.add(oMethod);
	            }
	        }
	        oClass = oClass.getSuperclass();
	    }
	    return oMethods;
	}

	
}
