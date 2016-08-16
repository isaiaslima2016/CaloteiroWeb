package br.triadworks.javaweb.modelo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;

import br.triadworks.javaweb.dao.CaloteiroDAO;
import br.triadworks.javaweb.servlets.CaloteiroServletException;

public class AdicionaCaloteiroLogica implements Logica {

	public void executa(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// recuperando a conexao que foi setadano request
		Connection conexao = (Connection) request.getAttribute("conexao");

		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		String devendo = request.getParameter("devendo");
		String dataDivida = request.getParameter("dataDivida");
		Calendar dataDividaConvertida = null;

		try {
			Date data = new SimpleDateFormat("dd/MM/yyyy").parse(dataDivida);
			dataDividaConvertida = Calendar.getInstance();
			dataDividaConvertida.setTime(data);
		} catch (ParseException e) {

			throw new CaloteiroServletException();

		}

		// Montando Caloteiro

		Caloteiro caloteiro = new Caloteiro();
		caloteiro.setNome(nome);
		caloteiro.setEmail(email);
		caloteiro.setDevendo(new Integer(devendo));
		caloteiro.setDataDivida(dataDividaConvertida);

		// inserindo no banco

		//injetando a conexao no Caloteiro DAO.
		CaloteiroDAO dao = new CaloteiroDAO(conexao);
		dao.adiciona(caloteiro);

		RequestDispatcher rd = request
				.getRequestDispatcher("/caloteiro-adicionado.jsp");
		rd.forward(request, response);
	}

}
