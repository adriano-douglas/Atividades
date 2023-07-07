package Trabalho_Etapa3_POO_AdrianoRosa.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Trabalho_Etapa3_POO_AdrianoRosa.db.DB;
import Trabalho_Etapa3_POO_AdrianoRosa.db.connection.ConexaoBanco;
import Trabalho_Etapa3_POO_AdrianoRosa.models.Borda;
import Trabalho_Etapa3_POO_AdrianoRosa.models.Molho;
import Trabalho_Etapa3_POO_AdrianoRosa.models.Pizza;
import Trabalho_Etapa3_POO_AdrianoRosa.models.Prato;
import Trabalho_Etapa3_POO_AdrianoRosa.models.Recheio;

public class PizzaDao {

	private static boolean adicionarRecheio(int idPizza, Recheio recheio) throws SQLException {
		boolean sucesso = false;
		ConexaoBanco.conectarBanco();
		// Inserindo dados
		String sql = "INSERT INTO pizzas_recheios (pizza_id, recheio_id) VALUES (?, ?)";

		PreparedStatement stmt = ConexaoBanco.getConnection().prepareStatement(sql);
		// Configurar os parâmetros da declaração preparada
		stmt.setInt(1, idPizza);
		stmt.setInt(2, recheio.getId());

		// Executar a declaração preparada
		int linhasAfetadas = stmt.executeUpdate();

		// Verificar se a inserção foi bem-sucedida
		if (linhasAfetadas > 0) {
			System.out.println("Recheio adicionado com sucesso!");
			sucesso = true;
		} else {
			System.out.println("Falha ao adicionar o recheio.");
		}

		stmt.close();
		ConexaoBanco.fecharConexao();
		return sucesso;
	}

	public static int cadastrarPizza(Pizza pizza, boolean personalizada) {
		int idPrato = 0;
		boolean sucesso = false;
		String nomeTabela = personalizada ? "pizzas_personalizadas" : "pizzas";
		try {
			// Inserindo dados
			String sql = "INSERT INTO " + nomeTabela + " (prato_id, molho_id, recheio_borda_id) VALUES (?, ?, ?)";
			if (pizza.getBorda().getRecheio() == null)
				sql = "INSERT INTO " + nomeTabela + " (prato_id, molho_id) VALUES (?, ?)";

			idPrato = PratoDao.cadastrarPrato(pizza);

			ConexaoBanco.conectarBanco();

			PreparedStatement stmt = ConexaoBanco.getConnection().prepareStatement(sql);
			// Configurar os parâmetros da declaração preparada
			stmt.setInt(1, idPrato);
			stmt.setInt(2, pizza.getMolho().getId());
			if (pizza.getBorda().getRecheio() != null)
				stmt.setInt(3, pizza.getBorda().getRecheio().getId());

			// Executar a declaração preparada
			int linhasAfetadas = stmt.executeUpdate();

			// Verificar se a inserção foi bem-sucedida
			if (linhasAfetadas > 0) {
				System.out.println("Pizza cadastrada com sucesso!");
			} else {
				System.out.println("Falha ao cadastrar a pizza.");
			}

			for (Recheio r : pizza.getRecheios()) {
				sucesso = adicionarRecheio(idPrato, r);
			}

			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Erro ao cadastrar a pizza");
			e.printStackTrace();
		}
		ConexaoBanco.fecharConexao();
		return sucesso ? idPrato : 0;
	}

	public static ArrayList<Pizza> buscarTodasPizzas(boolean personalizadas) {
		ArrayList<Pizza> pizzas = new ArrayList<>();
		String nomeTabela = personalizadas ? "pizzas_personalizadas" : "pizzas";
		ConexaoBanco.conectarBanco();
		try {
			Statement stmt = ConexaoBanco.getConnection().createStatement();
			ResultSet resultSet = stmt.executeQuery("select * from " + nomeTabela + ";");

			while (resultSet.next()) {
				Integer idPrato = resultSet.getInt("prato_id");
				Integer idMolho = resultSet.getInt("molho_id");
				Integer idRecheioBorda = resultSet.getInt("recheio_borda_id");
				Prato prato = PratoDao.buscarPratoPorId(idPrato);
				Molho molho = DB.buscarMolhoPizzaPorId(idMolho);
				Recheio recheioBorda = DB.buscarRecheioBordaPorId(idRecheioBorda);
				Double precoBorda = recheioBorda == null ? 0.0 : 2.0;
				String nomeBorda = recheioBorda == null ? "Tradicional" : "Recheada com " + recheioBorda.getNome();
				Borda borda = new Borda(0, nomeBorda, precoBorda, recheioBorda);
				Pizza pizza = new Pizza(prato.getId(), prato.getNome(), prato.getPrecoVenda(), prato.getDataValidade(),
						prato.getPeso(), molho, borda);
				pizza.setRecheios(ItensPizzaDao.buscarRecheiosPizzaPorIdPizza(pizza.getId()));
				pizzas.add(pizza);
			}

			resultSet.close();
			stmt.close();

			System.out.println("Busca de pizzas realizada com sucesso!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Erro ao buscar todas as pizzas");
			e.printStackTrace();
		}
		ConexaoBanco.fecharConexao();
		return pizzas;
	}

}
