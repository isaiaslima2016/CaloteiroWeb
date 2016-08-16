package br.triadworks.javaweb.filtro;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import br.triadworks.javaweb.dao.ConnectionFactory;
import br.triadworks.javaweb.servlets.CaloteiroServletException;

@WebFilter(filterName = "FiltroConexao", urlPatterns = "/sistema")
public class FiltroConexao implements Filter {

	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {

		Connection conexao = new ConnectionFactory().getConnection();

		request.setAttribute("conexao", conexao);

		chain.doFilter(request, response);

		try {
			conexao.close();
		} catch (SQLException e) {

			throw new CaloteiroServletException("Erro ao tentar fechar o banco");
		}

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {

	}

}
