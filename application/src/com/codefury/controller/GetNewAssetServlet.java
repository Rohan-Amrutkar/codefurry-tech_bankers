package com.codefury.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;

import com.codefury.model.beans.Message;
import com.codefury.service.MessageDao;
import com.codefury.service.MessageDaoJdbcImpl;
import com.codefury.service.UserDao;
import com.codefury.service.UserDaoJdbcImpl;

/**
 * Servlet implementation class GetNewAssetServlet
 */
@WebServlet("/GetNewAssetServlet")
public class GetNewAssetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetNewAssetServlet() {
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
        	UserDao service = new UserDaoJdbcImpl();
            JSONArray jsonArray = service.getAvailableAssets();
            
            
            request.setAttribute("jsonOb", jsonArray);
            RequestDispatcher rd = request.getRequestDispatcher("availableassets.jsp");
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
