package Trabalho_Etapa3_POO_AdrianoRosa.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Trabalho_Etapa3_POO_AdrianoRosa.db.connection.ConexaoBanco;
import Trabalho_Etapa3_POO_AdrianoRosa.models.Pessoa;

public class PessoaDao {

	public static int cadastrarPessoa(Pessoa pessoa) throws SQLException {
		int idPessoa = 0;
		ConexaoBanco.conectarBanco();
		// Inserindo dados
		String sql = "INSERT INTO pessoas (nome, cpf, endereco, telefone1, telefone2) VALUES (?, ?, ?, ?, ?)";
		if (pessoa.getTelefones().size() == 1)
			sql = "INSERT INTO pessoas (nome, cpf, endereco, telefone1) VALUES (?, ?, ?, ?)";

		PreparedStatement stmt = ConexaoBanco.getConnection().prepareStatement(sql);
		// Configurar os parâmetros da declaração preparada
		stmt.setString(1, pessoa.getNome());
		stmt.setString(2, pessoa.getCpf());
		stmt.setString(3, pessoa.getEndereco());
		stmt.setString(4, pessoa.getTelefones().get(0));
		if (pessoa.getTelefones().size() == 2)
			stmt.setString(5, pessoa.getTelefones().get(1));

		// Executar a declaração preparada
		int linhasAfetadas = stmt.executeUpdate();

		// Verificar se a inserção foi bem-sucedida
		if (linhasAfetadas > 0) {
			ResultSet generatedKeys = stmt.getGeneratedKeys();
			if (generatedKeys.next()) {
				idPessoa = generatedKeys.getInt(1);
				System.out.println("Pessoa cadastrada com sucesso! ID: " + idPessoa);
			} else {
				System.out.println("Falha ao obter o ID da pessoa cadastrada.");
			}
		} else {
			System.out.println("Falha ao cadastrar a pessoa.");
		}

		stmt.close();
		ConexaoBanco.fecharConexao();
		return idPessoa;
	}

}
