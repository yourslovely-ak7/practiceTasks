package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

import crud.CustomerOperation;
import io.jsonwebtoken.Claims;
import pojo.Customer;
import pojo.User;

@SuppressWarnings("serial")
@WebServlet("/profile")
public class ProfileServlet extends HttpServlet
{
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
    	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
    	response.setContentType("application/json");
//    	response.setContentType("text/html");
    	
    	String token= (String) request.getSession().getAttribute("sessionToken");
    	Claims claim= TokenValidator.validateToken(token);
    	
    	
    	int userId= (int) claim.get("userId");
    	String userType= (String) claim.get("userType");
    	System.out.println("In Profile page - Id : "+(int) claim.get("userId")+" Name : "+ claim.getSubject()+" Type : "+claim.get("userType"));
    	
    	
    	JSONObject json= new JSONObject();
    	if(userType.equals("Customer"))
    	{
    		CustomerOperation custOpt= new CustomerOperation();
    		List<Object> output= custOpt.getCustomerDetails(userId);
    		Customer newCust= new Customer();
    		User newUser= new User();
    		for(Object parts: output)
    		{
    			if(parts instanceof Customer)
    			{
    				newCust= (Customer) parts;
    			}
    			else
    			{
    				newUser= (User) parts;
    			}
    		}
    		
    		try {
				json.put("userId", newCust.getCustId());
				json.put("userName", newUser.getUserName());
				json.put("name", newUser.getName());
				json.put("mobileNo", newUser.getMobileNo());
				json.put("emailId", newUser.getEmailId());
				json.put("dob", newUser.getDob());
				json.put("aadharNo", newCust.getAadharNo());
				json.put("pan", newCust.getPan());
				
				System.out.println(newUser.getName()+" "+newCust.getAadharNo()+" "+ json.toString());
				
			} catch (JSONException e) {
				e.printStackTrace();
			}
    		
    		response.getWriter().write(json.toString());
    	}
    }
    
}
