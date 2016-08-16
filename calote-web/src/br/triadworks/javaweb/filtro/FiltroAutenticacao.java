package br.triadworks.javaweb.filtro;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import br.triadworks.javaweb.modelo.Usuario;

@WebFilter(filterName = "FiltroAutorizacao", urlPatterns = "/*")
public class FiltroAutenticacao implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub

		HttpServletRequest req = (HttpServletRequest) request;
		String uri = req.getRequestURI();
		String logica = req.getParameter("logica");

		if (logica == null) {

			logica = "";

		}

		if (uri.equals("login.jsp") || logica.equals("AutenticaUsuario")
				|| uri.endsWith("png")) {

			chain.doFilter(request, response);

		} else {

			Usuario usuarioLogado = (Usuario) req.getSession().getAttribute(
					"usuarioLogado");

			if (usuarioLogado != null) {

				chain.doFilter(request, response);

			} else {
				RequestDispatcher rd = request
						.getRequestDispatcher("/login.jsp");
				request.setAttribute("msgUsuario", "você não tem autorização");
				rd.forward(request, response);
			}
		}

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
