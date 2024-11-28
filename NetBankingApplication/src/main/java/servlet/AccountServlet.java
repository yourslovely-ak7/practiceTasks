package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import io.jsonwebtoken.Claims;

@SuppressWarnings("serial")
@WebServlet("/getAccounts")
public class AccountServlet extends HttpServlet
{
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
    	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
    	response.setContentType("application/json");
//    	response.setContentType("text/html");
    	
    	String token= (String) request.getSession().getAttribute("sessionToken");
    	Claims claim= TokenValidator.validateToken(token);
    	
    	
    	int userId= (int) claim.get("userId");
//    	String userType= (String) claim.get("userType");
    	System.out.println("In Accounts page - Id : "+(int) claim.get("userId")+" Name : "+ claim.getSubject()+" Type : "+claim.get("userType"));
    	
    	
    }
}
