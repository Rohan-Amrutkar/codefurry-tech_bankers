package com.codefury.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.codefury.model.beans.Asset;
import com.codefury.service.AssetDao;
import com.codefury.service.AssetDaoJdbcImpl;

/**
 * Servlet implementation class HelloServlet
 */
@WebServlet("/HelloServlet")
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelloServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = request.getParameter("name_inp");
		int type = Integer.parseInt(request.getParameter("type_inp"));
		String desc = request.getParameter("desc_inp");
		LocalDate date = LocalDate.now();
		Asset asset = new Asset(0, name, type, desc, date, 1, 0);
		
		AssetDao asset_service = new AssetDaoJdbcImpl();
		asset_service.addAsset(asset);
		
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println(name+ "<h2> Asset Added Successfully</h2>");
		out.println("</body></html>");
	}

}
