package edu.usmp.fia.taller.PlanCurricular.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.usmp.fia.taller.PlanCurricular.util.Constants;
import edu.usmp.fia.taller.PlanCurricular.util.Utils;
import edu.usmp.fia.taller.common.bean.PlanCurricular.ChangeBean;

@WebServlet("/changeRemove")
public class CHGDeleteServlet extends HttpServlet implements Constants {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		PrintWriter out 	= response.getWriter();
		response.setContentType("text/plain");
		
		String uuid 	= request.getParameter("uuid");
		List<ChangeBean> changes = Utils.getSessionChanges(request);
		for (ChangeBean c : changes) {
			if (c.getUuid().equals(uuid)) {
				changes.remove(c);
				out.print("200");
				break;
			}
		}
		out.close();
	}
	
}
