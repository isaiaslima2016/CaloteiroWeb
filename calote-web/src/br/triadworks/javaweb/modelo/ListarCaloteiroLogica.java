package br.triadworks.javaweb.modelo;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;

import br.triadworks.javaweb.dao.CaloteiroDAO;

public class ListarCaloteiroLogica implements Logica {
	public void executa(HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		// recuperando a conexao que foi setadano request
				Connection conexao = (Connection) request.getAttribute("conexao");

		
		CaloteiroDAO dao = new CaloteiroDAO(conexao);
		List<Caloteiro> lista = dao.getLista();
		RequestDispatcher rd = request
				.getRequestDispatcher("/listaCaloteiro.jsp");
		
		// envia a requisição, mando primeiro o "lista" e o objeto lista.
		
		request.setAttribute("lista", lista);

		rd.forward(request, response);

	}
}
