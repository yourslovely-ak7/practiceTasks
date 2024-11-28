package servlet;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONException;
import org.json.JSONObject;

import crud.UserOperation;
import pojo.User;

@SuppressWarnings("serial")
@WebServlet("/login")
public class LoginServlet extends HttpServlet
{
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		StringBuilder jsonData = new StringBuilder();
        String line;
        try (BufferedReader reader = request.getReader()) {
            while ((line = reader.readLine()) != null) {
                jsonData.append(line);
            }
        }

        JSONObject json;
        String userName="",passWord="";
		try 
		{
			json = new JSONObject(jsonData.toString());
			userName = json.getString("username");
			passWord = json.getString("password");
		}
		catch (JSONException e) 
		{
			e.printStackTrace();
		}
        
        UserOperation usrOpt= new UserOperation();
        User newUser= usrOpt.getUserDetails(userName);
        
        if(newUser.getUserName()==null)
        {
        	String failureResponse = "{\"success\": false, \"message\": \"Invalid UserName. Kindly re-check!\"}";
            response.getWriter().write(failureResponse);
        }
        else if((newUser.getAccountPass()).equals(passWord))
        {
        	HttpSession session= request.getSession();
        	session.setAttribute("userName", userName);
        	
        	String token= TokenGenerator.generateToken(newUser.getUserId(), userName, newUser.getName(), newUser.getUserType());
        	session.setAttribute("sessionToken", token);
        	
        	String successResponse = "{\"success\": true, \"userName\": \"" + userName + "\", \"sessionToken\": \"" + token + "\"}";
            response.getWriter().write(successResponse);
        }
        else
        {
        	 String failureResponse = "{\"success\": false, \"message\": \"Password Incorrect. Kindly re-check!\"}";
             response.getWriter().write(failureResponse);
        }
	}
}
