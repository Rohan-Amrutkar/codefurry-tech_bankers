package com.codefury.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;

import com.codefury.service.AssetDao;
import com.codefury.service.AssetDaoJdbcImpl;
import com.codefury.service.UserDao;
import com.codefury.service.UserDaoJdbcImpl;

/**
 * Servlet implementation class GetUserServlet
 */
@WebServlet("/GetMyAssetServlet")
public class GetMyAssetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetMyAssetServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();  
		response.setContentType("text/html");
        try 
        {  
        	int uid=3;
        	UserDao service = new UserDaoJdbcImpl();
            JSONArray jsonArray = service.getMyAssets(uid);
            
            request.setAttribute("jsonOb", jsonArray);
            RequestDispatcher rd = request.getRequestDispatcher("myassets.jsp");
            rd.forward(request, response);
            
         }  
            catch (Exception e) 
           {  
            	  
                out.println("<html><body>"); 
                out.println("error");  
                out.println("</body></html>");
        }  
	}	

}
