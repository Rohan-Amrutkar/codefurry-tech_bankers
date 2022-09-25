package com.codefury.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.codefury.model.beans.Message;
import com.codefury.service.MessageDao;
import com.codefury.service.MessageDaoJdbcImpl;

/**
 * Servlet implementation class MessageServlet
 */
@WebServlet("/MessageServlet")
public class MessageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MessageServlet() {
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
        	String message = request.getParameter("messageInp");
    		int uid = Integer.parseInt(request.getParameter("userId"));
    		int astId = Integer.parseInt(request.getParameter("assetId"));
    		LocalDate date = LocalDate.now();
    		
    		Message messageOb =new Message(0,uid, astId, message, date);
    		MessageDao service =  new MessageDaoJdbcImpl();
    		service.saveMessage(messageOb);
    		
    		out.println("<html><body>");
    		out.println("<h2>Message: "+message+" sent to user having id "+uid+"</h2>");
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
