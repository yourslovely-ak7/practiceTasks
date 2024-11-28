package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

import io.jsonwebtoken.Claims;

@SuppressWarnings("serial")
@WebServlet("/fetch")
public class ContentFetchServlet extends HttpServlet
{
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{	
		response.setContentType("application/json");
		
		String token = (String) request.getSession().getAttribute("sessionToken");
		if (token == null) {
			response.setStatus(HttpServletResponse.SC_UNAUTHORIZED); // 401 Unauthorized
			response.getWriter().write("{\"error\": \"Token not found in session\"}");
			return;
		}
		
		Claims claim= TokenValidator.validateToken(token);
		// Create the JSON response
		JSONObject jsonResponse = new JSONObject();
		try {
			jsonResponse.put("name", claim.get("name"));
			jsonResponse.put("userType", claim.get("userType"));
		} catch (JSONException e) {
			e.printStackTrace();
		}
		
		// Send the JSON response
		response.getWriter().write(jsonResponse.toString());
		
	}
}
