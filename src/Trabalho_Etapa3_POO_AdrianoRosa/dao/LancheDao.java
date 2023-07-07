package Trabalho_Etapa3_POO_AdrianoRosa.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Trabalho_Etapa3_POO_AdrianoRosa.db.connection.ConexaoBanco;
import Trabalho_Etapa3_POO_AdrianoRosa.models.Lanche;
import Trabalho_Etapa3_POO_AdrianoRosa.models.Prato;

public class LancheDao {

	public static int cadastrarLanche(Lanche lanche) {
		int idPrato = 0;
		boolean sucesso = false;
		try {
			// Inserindo dados
			String sql = "INSERT INTO laches (prato_id, pao, recheio, molho) VALUES (?, ?, ?, ?)";

			idPrato = PratoDao.cadastrarPrato(lanche);
			
			ConexaoBanco.conectarBanco();

			PreparedStatement stmt = ConexaoBanco.getConnection().prepareStatement(sql);
			// Configurar os parâmetros da declaração preparada
			stmt.setInt(1, idPrato);
			stmt.setString(2, lanche.getPao());
			stmt.setString(3, lanche.getRecheio());
			stmt.setString(4, lanche.getMolho());

			// Executar a declaração preparada
			int linhasAfetadas = stmt.executeUpdate();

			// Verificar se a inserção foi bem-sucedida
			if (linhasAfetadas > 0) {
				System.out.println("Lanche cadastrado com sucesso!");
				sucesso = true;
			} else {
				System.out.println("Falha ao cadastrar o lanche.");
			}

			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Erro ao cadastrar o lanche");
			e.printStackTrace();
		}
		ConexaoBanco.fecharConexao();
		return sucesso ? idPrato : 0;
	}

	public static ArrayList<Lanche> buscarTodosLanches() {
		ArrayList<Lanche> lanches = new ArrayList<>();
		ConexaoBanco.conectarBanco();
		try {
			Statement stmt = ConexaoBanco.getConnection().createStatement();
			ResultSet resultSet = stmt.executeQuery("select * from laches;");

			while (resultSet.next()) {
				Integer idPrato = resultSet.getInt("prato_id");
				String pao = resultSet.getString("pao");
				String recheio = resultSet.getString("recheio");
				String molho = resultSet.getString("molho");
				Prato prato = PratoDao.buscarPratoPorId(idPrato);
				Lanche lanche = new Lanche(prato.getId(), prato.getNome(), prato.getPrecoVenda(),
						prato.getDataValidade(), prato.getPeso(), pao, recheio, molho);
				lanches.add(lanche);
			}

			resultSet.close();
			stmt.close();

			System.out.println("Busca de lanches realizada com sucesso!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Erro ao buscar todos os lanches");
			e.printStackTrace();
		}
		ConexaoBanco.fecharConexao();
		return lanches;
	}

}
