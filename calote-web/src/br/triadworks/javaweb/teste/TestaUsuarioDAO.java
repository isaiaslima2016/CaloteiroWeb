package br.triadworks.javaweb.teste;

import java.sql.Connection;

import br.triadworks.javaweb.dao.ConnectionFactory;
import br.triadworks.javaweb.dao.UsuarioDAO;
import br.triadworks.javaweb.modelo.Usuario;

public class TestaUsuarioDAO {
	public static void main(String[] args) {

		Connection conexao = new ConnectionFactory().getConnection();
		UsuarioDAO usuarioDAO = new UsuarioDAO(conexao);

		// teste com usuario

		Usuario usuarioLogado = usuarioDAO.autentica("isaiaddd s", "123");
		
	if(usuarioLogado != null){
		
		System.out.println("Usuario logado : "+usuarioLogado.getNome());
	
	
	}
	
	if(usuarioLogado == null){
		
		System.out.println("Não funfou");
	}

	}
}
