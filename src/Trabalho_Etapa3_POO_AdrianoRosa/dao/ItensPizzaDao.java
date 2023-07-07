package Trabalho_Etapa3_POO_AdrianoRosa.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Trabalho_Etapa3_POO_AdrianoRosa.db.DB;
import Trabalho_Etapa3_POO_AdrianoRosa.db.connection.ConexaoBanco;
import Trabalho_Etapa3_POO_AdrianoRosa.models.Molho;
import Trabalho_Etapa3_POO_AdrianoRosa.models.Recheio;

public class ItensPizzaDao {

	public static int cadastrarMolhoPizza(Molho molho) {
		int idMolhoPizza = 0;
		ConexaoBanco.conectarBanco();
		try {
			// Inserindo dados
			String sql = "INSERT INTO molhos_pizza (nome, valor) VALUES (?, ?)";

			PreparedStatement stmt = ConexaoBanco.getConnection().prepareStatement(sql);
			// Configurar os parâmetros da declaração preparada
			stmt.setString(1, molho.getNome());
			stmt.setDouble(2, molho.getValor());

			// Executar a declaração preparada
			int linhasAfetadas = stmt.executeUpdate();

			// Verificar se a inserção foi bem-sucedida
			if (linhasAfetadas > 0) {
				ResultSet generatedKeys = stmt.getGeneratedKeys();
				if (generatedKeys.next()) {
					idMolhoPizza = generatedKeys.getInt(1);
					System.out.println("Molho pizza cadastrado com sucesso! ID: " + idMolhoPizza);
				} else {
					System.out.println("Falha ao obter o ID do molho pizza cadastrado.");
				}
			} else {
				System.out.println("Falha ao cadastrar o molho pizza.");
			}

			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Erro ao cadastrar molho pizza");
			e.printStackTrace();
		}
		ConexaoBanco.fecharConexao();
		return idMolhoPizza;
	}

	public static int cadastrarRecheioPizza(Recheio recheio) {
		int idRecheioPizza = 0;
		ConexaoBanco.conectarBanco();
		try {
			// Inserindo dados
			String sql = "INSERT INTO recheios_pizza (nome, valor) VALUES (?, ?)";

			PreparedStatement stmt = ConexaoBanco.getConnection().prepareStatement(sql);
			// Configurar os parâmetros da declaração preparada
			stmt.setString(1, recheio.getNome());
			stmt.setDouble(2, recheio.getValor());

			// Executar a declaração preparada
			int linhasAfetadas = stmt.executeUpdate();

			// Verificar se a inserção foi bem-sucedida
			if (linhasAfetadas > 0) {
				ResultSet generatedKeys = stmt.getGeneratedKeys();
				if (generatedKeys.next()) {
					idRecheioPizza = generatedKeys.getInt(1);
					System.out.println("Recheio pizza cadastrado com sucesso! ID: " + idRecheioPizza);
				} else {
					System.out.println("Falha ao obter o ID do recheio pizza cadastrado.");
				}
			} else {
				System.out.println("Falha ao cadastrar o recheio pizza.");
			}

			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Erro ao cadastrar recheio pizza");
			e.printStackTrace();
		}
		ConexaoBanco.fecharConexao();
		return idRecheioPizza;
	}

	public static int cadastrarRecheioBordaPizza(Recheio recheio) {
		int idRecheioBordaPizza = 0;
		ConexaoBanco.conectarBanco();
		try {
			// Inserindo dados
			String sql = "INSERT INTO recheios_borda_pizza (nome, valor) VALUES (?, ?)";

			PreparedStatement stmt = ConexaoBanco.getConnection().prepareStatement(sql);
			// Configurar os parâmetros da declaração preparada
			stmt.setString(1, recheio.getNome());
			stmt.setDouble(2, recheio.getValor());

			// Executar a declaração preparada
			int linhasAfetadas = stmt.executeUpdate();

			// Verificar se a inserção foi bem-sucedida
			if (linhasAfetadas > 0) {
				ResultSet generatedKeys = stmt.getGeneratedKeys();
				if (generatedKeys.next()) {
					idRecheioBordaPizza = generatedKeys.getInt(1);
					System.out.println("Recheio borda pizza cadastrado com sucesso! ID: " + idRecheioBordaPizza);
				} else {
					System.out.println("Falha ao obter o ID do recheio borda pizza cadastrado.");
				}
			} else {
				System.out.println("Falha ao cadastrar o recheio borda pizza.");
			}

			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Erro ao cadastrar recheio borda pizza");
			e.printStackTrace();
		}
		ConexaoBanco.fecharConexao();
		return idRecheioBordaPizza;
	}

	public static ArrayList<Molho> buscarTodosMolhosPizza() {
		ArrayList<Molho> molhos = new ArrayList<>();
		ConexaoBanco.conectarBanco();
		try {
			Statement stmt = ConexaoBanco.getConnection().createStatement();
			ResultSet resultSet = stmt.executeQuery("SELECT * FROM molhos_pizza");

			while (resultSet.next()) {
				Integer id = resultSet.getInt("id");
				String nome = resultSet.getString("nome");
				Double valor = resultSet.getDouble("valor");
				molhos.add(new Molho(id, nome, valor));
			}

			resultSet.close();
			stmt.close();
			
			System.out.println("Busca de molhos realizada com sucesso!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Erro ao buscar todos os molhos");
			e.printStackTrace();
		}
		ConexaoBanco.fecharConexao();
		return molhos;
	}

	public static ArrayList<Recheio> buscarTodosRecheiosPizza() {
		ArrayList<Recheio> recheios = new ArrayList<>();
		ConexaoBanco.conectarBanco();
		try {
			Statement stmt = ConexaoBanco.getConnection().createStatement();
			ResultSet resultSet = stmt.executeQuery("SELECT * FROM recheios_pizza");

			while (resultSet.next()) {
				Integer id = resultSet.getInt("id");
				String nome = resultSet.getString("nome");
				Double valor = resultSet.getDouble("valor");
				recheios.add(new Recheio(id, nome, valor));
			}

			resultSet.close();
			stmt.close();
			
			System.out.println("Busca de recheios realizada com sucesso!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Erro ao buscar todos os recheios");
			e.printStackTrace();
		}
		ConexaoBanco.fecharConexao();
		return recheios;
	}

	public static ArrayList<Recheio> buscarTodosRecheiosBorda() {
		ArrayList<Recheio> recheios = new ArrayList<>();
		ConexaoBanco.conectarBanco();
		try {
			Statement stmt = ConexaoBanco.getConnection().createStatement();
			ResultSet resultSet = stmt.executeQuery("SELECT * FROM recheios_borda_pizza");

			while (resultSet.next()) {
				Integer id = resultSet.getInt("id");
				String nome = resultSet.getString("nome");
				Double valor = resultSet.getDouble("valor");
				recheios.add(new Recheio(id, nome, valor));
			}

			resultSet.close();
			stmt.close();
			
			System.out.println("Busca de recheios borda realizada com sucesso!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Erro ao buscar todos os recheios borda");
			e.printStackTrace();
		}
		ConexaoBanco.fecharConexao();
		return recheios;
	}

	public static ArrayList<Recheio> buscarRecheiosPizzaPorIdPizza(Integer idPizza) {
		ArrayList<Recheio> recheios = new ArrayList<>();
		try {
			String sql = "select recheio_id from pizzas_recheios where pizza_id = ?;";

			PreparedStatement stmt = ConexaoBanco.getConnection().prepareStatement(sql);
			// Configurar os parâmetros da declaração preparada
			stmt.setInt(1, idPizza);

			ResultSet resultSet = stmt.executeQuery();

			while (resultSet.next()) {
				Integer idRecheio = resultSet.getInt("recheio_id");
				Recheio recheio = DB.buscarRecheioPizzaPorId(idRecheio);
				recheios.add(recheio);
			}

			resultSet.close();
			stmt.close();
			
			System.out.println("Busca de recheios pizza realizada com sucesso!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Erro ao buscar os recheios pizza");
			e.printStackTrace();
		}
		return recheios;
	}

}
