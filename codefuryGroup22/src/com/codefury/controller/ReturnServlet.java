package com.codefury.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.codefury.service.UserDao;
import com.codefury.service.UserDaoJdbcImpl;

/**
 * Servlet implementation class ReturnServlet
 */
@WebServlet("/ReturnServlet")
public class ReturnServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReturnServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html"); 
		PrintWriter out = response.getWriter();  
        
        try 
        {  
        	
        	int userId = Integer.parseInt(request.getParameter("usrid"));
        	int assetId = Integer.parseInt(request.getParameter("astid"));
        	UserDao service = new UserDaoJdbcImpl();
        	service.returnAsset(userId, assetId);
        	
    		
    		out.println("<html><body>");
    		out.println("<h2>Message: Asset "+assetId+" return by user "+userId+"</h2>");
    		out.println("</body></html>");
            
         }  
            catch (Exception e) 
           {  
            	 
                out.println("<html><body>"); 
                out.println("error");  
                out.println("</body></html>");
        }  
	}

}
