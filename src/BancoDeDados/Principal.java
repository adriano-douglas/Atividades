package BancoDeDados;

import java.sql.Date;
import java.sql.SQLException;

import BancoDeDados.connection.ConexaoBanco;
import BancoDeDados.dao.PessoaDAO;

public class Principal {
	public static void main(String[] args) throws SQLException {

		ConexaoBanco.conectarBanco();
		PessoaDAO pessoaDAO = new PessoaDAO();

		pessoaDAO.selectCadastro();

		pessoaDAO.insertCadastro("1", "Nome 1", "Endereco 1", new Date(0));
		pessoaDAO.insertCadastro("2", "Nome 2", "Endereco 2", new Date(0));
		pessoaDAO.insertCadastro("3", "Nome 3", "Endereco 3", new Date(0));
		pessoaDAO.insertCadastro("4", "Nome 4", "Endereco 4", new Date(0));
		pessoaDAO.insertCadastro("5", "Nome 5", "Endereco 5", new Date(0));
		
		pessoaDAO.selectCadastro();

		pessoaDAO.atualizarCpfNomeTerceiroRegistro("1234567890", "Beltrano");
		
		pessoaDAO.selectCadastro();
		
		pessoaDAO.deletarPessoaPorCpf("1");
		pessoaDAO.deletarPessoaPorCpf("2");
		pessoaDAO.deletarPessoaPorCpf("5");
		
		pessoaDAO.selectCadastro();
		
		pessoaDAO.deletarTodasPessoas();
		
		pessoaDAO.selectCadastro();

		ConexaoBanco.fecharConexao();
	}
}




