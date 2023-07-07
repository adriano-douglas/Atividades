package Trabalho_Etapa3_POO_AdrianoRosa.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import Trabalho_Etapa3_POO_AdrianoRosa.db.connection.ConexaoBanco;
import Trabalho_Etapa3_POO_AdrianoRosa.models.Prato;

public class PratoDao {
	
	public static int cadastrarPrato(Prato prato) throws SQLException {
		int idPrato = 0;
		ConexaoBanco.conectarBanco();
		// Inserindo dados
		String sql = "INSERT INTO pratos (nome, preco_venda, data_validade, peso) VALUES (?, ?, ?, ?)";

		PreparedStatement stmt = ConexaoBanco.getConnection().prepareStatement(sql);
		// Configurar os parâmetros da declaração preparada
		stmt.setString(1, prato.getNome());
		stmt.setDouble(2, prato.getPrecoVenda());
		stmt.setDate(3, Date.valueOf(prato.getDataValidade()));
		stmt.setDouble(4, prato.getPeso());

		// Executar a declaração preparada
		int linhasAfetadas = stmt.executeUpdate();

		// Verificar se a inserção foi bem-sucedida
		if (linhasAfetadas > 0) {
			ResultSet generatedKeys = stmt.getGeneratedKeys();
			if (generatedKeys.next()) {
				idPrato = generatedKeys.getInt(1);
				System.out.println("Prato cadastrado com sucesso! ID: " + idPrato);
			} else {
				System.out.println("Falha ao obter o ID do prato cadastrado.");
			}
		} else {
			System.out.println("Falha ao cadastrar o prato.");
		}

		stmt.close();
		ConexaoBanco.fecharConexao();
		return idPrato;
	}
	
	public static Prato buscarPratoPorId(Integer idPrato) {
		Prato prato = null;
		try {
			String sql = "select * from pratos where id = ?;";

			PreparedStatement stmt = ConexaoBanco.getConnection().prepareStatement(sql);
			// Configurar os parâmetros da declaração preparada
			stmt.setInt(1, idPrato);

			ResultSet resultSet = stmt.executeQuery();

			while (resultSet.next()) {
				Integer id = resultSet.getInt("id");
				String nome = resultSet.getString("nome");
				Double precoVenda = resultSet.getDouble("preco_venda");
				String dataValidade = resultSet.getString("data_validade");
				Double peso = resultSet.getDouble("peso");
				prato = new Prato(id, nome, precoVenda, LocalDate.parse(dataValidade), peso);
			}

			resultSet.close();
			stmt.close();
			
			System.out.println("Busca de prato por id realizada com sucesso!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Erro ao buscar o prato por id");
			e.printStackTrace();
		}
		return prato;
	}

}
