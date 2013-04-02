package flapjack.servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class DendrogramServlet extends HttpServlet
{
	public void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException
	{
		response.setContentType("text/html");

		PrintWriter out = response.getWriter();

		out.println("<html>");
		out.println("<h1>Testing...</h1>");
		out.println("</html>");
		out.close();
	}
}