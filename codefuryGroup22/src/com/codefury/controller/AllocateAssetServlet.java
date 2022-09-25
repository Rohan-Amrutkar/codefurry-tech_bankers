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
 * Servlet implementation class AllocateAssetServlet
 */
@WebServlet("/AllocateAssetServlet")
public class AllocateAssetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AllocateAssetServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html"); 
		PrintWriter out = response.getWriter();  
        
        try 
        {  
        	int userId = Integer.parseInt(request.getParameter("userid"));
        	int assetId = Integer.parseInt(request.getParameter("assetid"));
        	UserDao service = new UserDaoJdbcImpl();
        	service.allocateAsset(userId, assetId);
    		
    		out.println("<html><body>");
    		out.println("<h2>Message: Asset "+assetId+" allocated to user "+userId+"</h2>");
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
