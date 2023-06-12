package BancoDeDados.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import BancoDeDados.connection.ConexaoBanco;

public class PessoaDAO {

	private Connection connection = ConexaoBanco.getConnection();

	public void selectCadastro() throws SQLException {

		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery("SELECT * FROM pessoa_cadastro");
		System.out.println("\nResultado para o select na tabela: ");

		while (resultSet.next()) {
			String cpf = resultSet.getString("cpf");
			String nome = resultSet.getString("nome");
			String endereco = resultSet.getString("endereco");
			Date dataNascimento = resultSet.getDate("data_nascimento");
			// Faça algo com os dados recuperados...
			System.out.println("CPF: " + cpf + " | Nome: " + nome + " | Endereço: " + endereco + " | Data de Nascimento: "
					+ dataNascimento);
		}

	}

	public void insertCadastro(String cpf, String nome, String endereco, Date data_nascimento) throws SQLException {
		// Inserindo dados
		String sql = "INSERT INTO pessoa_cadastro (cpf, nome, endereco, data_nascimento) VALUES (?, ?, ?, ?)";

		PreparedStatement stmt = connection.prepareStatement(sql);
		// Configurar os parâmetros da declaração preparada
		stmt.setString(1, cpf);
		stmt.setString(2, nome);
		stmt.setString(3, endereco);
		stmt.setDate(4, data_nascimento);

		// Executar a declaração preparada
		int linhasAfetadas = stmt.executeUpdate();

		// Verificar se a inserção foi bem-sucedida
		if (linhasAfetadas > 0) {
			System.out.println("Dados inseridos com sucesso!");
		} else {
			System.out.println("Falha ao inserir os dados.");
		}
	}

	public void atualizarCpfNomeTerceiroRegistro(String cpf, String nome) throws SQLException {
		// Atualizando dados
		String sql = "UPDATE pessoa_cadastro SET cpf = ?, nome = ? WHERE cpf = 3";

		PreparedStatement stmt = connection.prepareStatement(sql);

		// Configurar os parâmetros da declaração preparada
		stmt.setString(1, cpf);
		stmt.setString(2, nome);

		// Executar a declaração preparada
		int linhasAfetadas = stmt.executeUpdate();

		// Verificar se a inserção foi bem-sucedida
		if (linhasAfetadas > 0) {
			System.out.println("Dados atualizados com sucesso!");
		} else {
			System.out.println("Falha ao atualizar os dados.");
		}
	}

	public void deletarPessoaPorCpf(String cpf) throws SQLException {
		// Atualizando dados
		String sql = "DELETE FROM pessoa_cadastro WHERE cpf = ?";

		PreparedStatement stmt = connection.prepareStatement(sql);

		// Configurar os parâmetros da declaração preparada
		stmt.setString(1, cpf);

		// Executar a declaração preparada
		int linhasAfetadas = stmt.executeUpdate();

		// Verificar se a inserção foi bem-sucedida
		if (linhasAfetadas > 0) {
			System.out.println("Registro deletado com sucesso!");
		} else {
			System.out.println("Falha ao deletar o registro.");
		}
	}

	public void deletarTodasPessoas() throws SQLException {
		// Atualizando dados
		String sql = "DELETE FROM pessoa_cadastro";

		PreparedStatement stmt = connection.prepareStatement(sql);

		// Executar a declaração preparada
		int linhasAfetadas = stmt.executeUpdate();

		// Verificar se a inserção foi bem-sucedida
		if (linhasAfetadas > 0) {
			System.out.println("Registros deletados com sucesso!");
		} else {
			System.out.println("Falha ao deletar os registros.");
		}
	}

}
