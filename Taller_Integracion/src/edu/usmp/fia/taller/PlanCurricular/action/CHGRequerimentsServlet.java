package edu.usmp.fia.taller.PlanCurricular.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import edu.usmp.fia.taller.PlanCurricular.business.ChangeBusiness;
import edu.usmp.fia.taller.PlanCurricular.business.impl.ChangeBusinessImpl;
import edu.usmp.fia.taller.PlanCurricular.util.Constants;
import edu.usmp.fia.taller.PlanCurricular.util.Utils;
import edu.usmp.fia.taller.common.bean.PlanCurricular.ChangeBean;
import edu.usmp.fia.taller.common.bean.PlanCurricular.Curso;
import edu.usmp.fia.taller.common.bean.PlanCurricular.ResponseBean;

/**
 * Servlet implementation class CHGNameServlet
 */
@WebServlet("/changeRequirements")
public class CHGRequerimentsServlet extends HttpServlet implements Constants {

	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher reqDisp = getServletContext().getRequestDispatcher("/" +
				VIEW_SECTION_PATH + "formChangeRequirements.jsp");
		reqDisp.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {

		ResponseBean<ChangeBean> jresponse = new ResponseBean<ChangeBean>();
		PrintWriter out 	= response.getWriter();
		ObjectMapper mapper = new ObjectMapper();
		response.setContentType("application/json");
		
		try {
			/* Get Request Parameters */
			String course 	= request.getParameter("course");
			String newreq1 	= request.getParameter("newreq1");
			String newreq2 	= request.getParameter("newreq2");
			
			int newcred1 = Utils.getIntegerParameter(request, "newcred1");
			int newcred2 = Utils.getIntegerParameter(request, "newcred2");
			
			
			/* Get Session Attributes */
			List<Curso> courses 	= Utils.getSessionCourses(request);
			List<Curso> newCourses = Utils.getSessionNewCourses(request);
			List<ChangeBean> changes 	= Utils.getSessionChanges(request);
	
			/* Apply Business Rules */
			ChangeBusiness chgBusiness 	= new ChangeBusinessImpl();
			ChangeBean change 			= chgBusiness.changeRequeriments(course, newreq1, newreq2, newcred1, newcred2, courses, newCourses, changes);
			
			/* Update changes and new courses in session */
			request.getSession().setAttribute(SESSION_NEW_COURSES, newCourses);
			request.getSession().setAttribute(SESSION_CHANGES, changes);
			
			/* Complete response details */
			jresponse.setCode(change.getCode());
			jresponse.setMessage(change.getMessage());
			jresponse.setData(change);
			out.print(mapper.writeValueAsString(jresponse));
		} catch (Exception e) {
			e.printStackTrace();
			
			jresponse.setCode(500);
			jresponse.setMessage("Cambio fallido!");
			jresponse.setData(null);
			out.print(mapper.writeValueAsString(jresponse));
		}
		out.close();
	}

}
