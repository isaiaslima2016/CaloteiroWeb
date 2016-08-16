package br.triadworks.javaweb.modelo;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;

import br.triadworks.javaweb.dao.CaloteiroDAO;

public class DeletarCaloteiroLogica implements Logica {

	
	
	public void executa(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
	
		// recuperando a conexao que foi setadano request
				Connection conexao = (Connection) request.getAttribute("conexao");

		
		String id = request.getParameter("id");

		CaloteiroDAO dao = new CaloteiroDAO(conexao);

		Caloteiro caloteiro = new Caloteiro();
		caloteiro.setId(new Long(id));

		dao.deleta(caloteiro);

		RequestDispatcher rd = request
				.getRequestDispatcher("/sistema?logica=ListarCaloteiro");
		rd.forward(request, response);
	}
}