package br.triadworks.javaweb.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ServletContado", urlPatterns = { "/Contador" })
public class ServletContador extends HttpServlet {

	private int contador = 0;

	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		contador++;
		
		PrintWriter p = response.getWriter();
		p.println("<html>");
		p.println("<body>");
		p.println("Servlet de número :" + contador);
		p.println("</body>");
		p.println("</html>");

	}

}
