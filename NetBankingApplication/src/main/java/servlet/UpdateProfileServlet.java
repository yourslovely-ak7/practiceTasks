package servlet;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

import crud.UserOperation;
import io.jsonwebtoken.Claims;
import pojo.User;

@SuppressWarnings("serial")
@WebServlet("/updateProfile")
public class UpdateProfileServlet extends HttpServlet
{
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		System.out.println("Update method invoked");
		String token= (String) request.getSession().getAttribute("sessionToken");
    	Claims claim= TokenValidator.validateToken(token);
    	
    	
    	int userId= (int) claim.get("userId");
    	
		StringBuilder jsonData = new StringBuilder();
        String line;
        try (BufferedReader reader = request.getReader()) {
            while ((line = reader.readLine()) != null) {
                jsonData.append(line);
            }
        }

        JSONObject json;
        String userName = null, name = null, mobileNo = null, email = null;
        int id;
        User updatedUser= new User();
        try {
            json = new JSONObject(jsonData.toString());
            
            id= json.getInt("userid");
            updatedUser.setUserId(id);
            // Check if each field exists before accessing it
            if (json.has("username")) {
                userName = json.getString("username");
                updatedUser.setUserName(userName);
            }
            if (json.has("name")) {
                name = json.getString("name");
                updatedUser.setName(name);
            }
            if (json.has("phone")) {
                mobileNo = json.getString("phone");
                updatedUser.setMobileNo(mobileNo);
            }
            if (json.has("email")) {
                email = json.getString("email");
                updatedUser.setEmailId(email);
            }
        } catch (JSONException e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid JSON format");
            return;
        }
        
        UserOperation usrOpt= new UserOperation();
        
        boolean isUpdated= usrOpt.updateUserDetails(userId, updatedUser);
        
        if(isUpdated)
        {
        	response.setStatus(HttpServletResponse.SC_OK);
        	String successResponse = "{\"success\": true}";
            response.getWriter().write(successResponse);
        }
        else
        {
        	response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        	String failureResponse = "{\"success\": false}";
            response.getWriter().write(failureResponse);
        }
	}
}
