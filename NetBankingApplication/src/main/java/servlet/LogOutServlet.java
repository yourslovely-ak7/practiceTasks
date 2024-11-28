package servlet;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/logout")
public class LogOutServlet extends HttpServlet
{
	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException
	{
		HttpSession session= req.getSession();
		session.removeAttribute("userName");
		session.removeAttribute("sessionToken");
		session.invalidate();
		
		res.sendRedirect("login.html");
	}
}
