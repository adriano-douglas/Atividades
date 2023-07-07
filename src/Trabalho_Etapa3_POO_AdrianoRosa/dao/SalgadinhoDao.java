package Trabalho_Etapa3_POO_AdrianoRosa.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Trabalho_Etapa3_POO_AdrianoRosa.db.connection.ConexaoBanco;
import Trabalho_Etapa3_POO_AdrianoRosa.models.Prato;
import Trabalho_Etapa3_POO_AdrianoRosa.models.Salgadinho;

public class SalgadinhoDao {

	public static int cadastrarSalgadinho(Salgadinho salgadinho) {
		int idPrato = 0;
		boolean sucesso = false;
		try {
			// Inserindo dados
			String sql = "INSERT INTO salgadinhos (prato_id, massa, recheio, tipo) VALUES (?, ?, ?, ?)";

			idPrato = PratoDao.cadastrarPrato(salgadinho);
			
			ConexaoBanco.conectarBanco();

			PreparedStatement stmt = ConexaoBanco.getConnection().prepareStatement(sql);
			// Configurar os parâmetros da declaração preparada
			stmt.setInt(1, idPrato);
			stmt.setString(2, salgadinho.getMassa());
			stmt.setString(3, salgadinho.getRecheio());
			stmt.setString(4, salgadinho.getTipo());

			// Executar a declaração preparada
			int linhasAfetadas = stmt.executeUpdate();

			// Verificar se a inserção foi bem-sucedida
			if (linhasAfetadas > 0) {
				System.out.println("Salgadinho cadastrado com sucesso!");
				sucesso = true;
			} else {
				System.out.println("Falha ao cadastrar o salgadinho.");
			}

			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Erro ao cadastrar o salgadinho");
			e.printStackTrace();
		}
		ConexaoBanco.fecharConexao();
		return sucesso ? idPrato : 0;
	}

	public static ArrayList<Salgadinho> buscarTodosSalgadinhos() {
		ArrayList<Salgadinho> salgadinhos = new ArrayList<>();
		ConexaoBanco.conectarBanco();
		try {
			Statement stmt = ConexaoBanco.getConnection().createStatement();
			ResultSet resultSet = stmt.executeQuery("select * from salgadinhos;");

			while (resultSet.next()) {
				Integer idPrato = resultSet.getInt("prato_id");
				String massa = resultSet.getString("massa");
				String recheio = resultSet.getString("recheio");
				String tipo = resultSet.getString("tipo");
				Prato prato = PratoDao.buscarPratoPorId(idPrato);
				Salgadinho salgadinho = new Salgadinho(prato.getId(), prato.getNome(), prato.getPrecoVenda(),
						prato.getDataValidade(), prato.getPeso(), massa, recheio, tipo);
				salgadinhos.add(salgadinho);
			}

			resultSet.close();
			stmt.close();

			System.out.println("Busca de salgadinhos realizada com sucesso!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Erro ao buscar todos os salgadinhos");
			e.printStackTrace();
		}
		ConexaoBanco.fecharConexao();
		return salgadinhos;
	}

}
