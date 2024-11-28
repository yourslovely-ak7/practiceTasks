package servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter("/dashboard")
public class AuthenticationFilter implements Filter
{
	public void init(FilterConfig filterConfig) throws ServletException {
	    System.out.println("AuthenticationFilter initialized.");
	}
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException 
	{
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        if (httpRequest.getSession().getAttribute("userName") == null) 
        {
            httpResponse.sendRedirect("/NetBankingApplication/login.html");
        }
        else 
        {
        	System.out.println("Redirecting to DashBoard...");
            chain.doFilter(request, response);
        }
    }
}
