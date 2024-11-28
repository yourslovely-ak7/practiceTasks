package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import io.jsonwebtoken.Claims;

@SuppressWarnings("serial")
@WebServlet("/dashboard")
public class DashboardServlet extends HttpServlet 
{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
    	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
//    	response.setContentType("text/html");
    	
    	String token= (String) request.getSession().getAttribute("sessionToken");
    	Claims claim= TokenValidator.validateToken(token);
    	
    	System.out.println("Id : "+(int) claim.get("userId")+" Name : "+ claim.getSubject()+" Type : "+claim.get("userType"));
    	
    	request.getRequestDispatcher("/dashboard.html").forward(request, response);
    }
}
