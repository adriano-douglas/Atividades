package Trabalho_Etapa3_POO_AdrianoRosa.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

import Trabalho_Etapa3_POO_AdrianoRosa.db.DB;
import Trabalho_Etapa3_POO_AdrianoRosa.db.connection.ConexaoBanco;
import Trabalho_Etapa3_POO_AdrianoRosa.models.Cliente;
import Trabalho_Etapa3_POO_AdrianoRosa.models.Funcionario;
import Trabalho_Etapa3_POO_AdrianoRosa.models.Pedido;
import Trabalho_Etapa3_POO_AdrianoRosa.models.Prato;

public class PedidoDao {

	private static boolean adicionarItensPedidos(int idPedido, int idPrato, int quantidade) throws SQLException {
		boolean sucesso = false;
		ConexaoBanco.conectarBanco();
		// Inserindo dados
		String sql = "INSERT INTO itens_pedidos (prato_id, pedido_id, quantidade) VALUES (?, ?, ?)";

		PreparedStatement stmt = ConexaoBanco.getConnection().prepareStatement(sql);
		// Configurar os parâmetros da declaração preparada
		stmt.setInt(1, idPedido);
		stmt.setInt(2, idPrato);
		stmt.setInt(3, quantidade);

		// Executar a declaração preparada
		int linhasAfetadas = stmt.executeUpdate();

		// Verificar se a inserção foi bem-sucedida
		if (linhasAfetadas > 0) {
			System.out.println("Item pedido adicionado com sucesso!");
			sucesso = true;
		} else {
			System.out.println("Falha ao adicionar o item pedido.");
		}

		stmt.close();
		ConexaoBanco.fecharConexao();
		return sucesso;
	}

	public static int cadastrarPedido(Pedido pedido) {
		int idPedido = 0;
		boolean sucesso = false;
		ConexaoBanco.conectarBanco();
		try {
			// Inserindo dados
			String sql = "INSERT INTO pedidos (cliente_id, funcionario_id, taxa_servico, valor_total, data) VALUES (?, ?, ?, ?, ?)";

			PreparedStatement stmt = ConexaoBanco.getConnection().prepareStatement(sql);
			// Configurar os parâmetros da declaração preparada
			stmt.setInt(1, pedido.getCliente().getId());
			stmt.setInt(2, pedido.getFuncionario().getId());
			stmt.setDouble(3, pedido.getTaxaServico());
			stmt.setDouble(4, pedido.getValorTotal());
			stmt.setDate(5, Date.valueOf(pedido.getData()));

			// Executar a declaração preparada
			int linhasAfetadas = stmt.executeUpdate();

			// Verificar se a inserção foi bem-sucedida
			if (linhasAfetadas > 0) {
				ResultSet generatedKeys = stmt.getGeneratedKeys();
				if (generatedKeys.next()) {
					idPedido = generatedKeys.getInt(1);
					System.out.println("Pedido cadastrado com sucesso! ID: " + idPedido);
				} else {
					System.out.println("Falha ao obter o ID do pedido cadastrado.");
				}
			} else {
				System.out.println("Falha ao cadastrar o pedido.");
			}
			
			int i = 0;
			for(Prato p : pedido.getItensConsumidos()) {
				sucesso = adicionarItensPedidos(p.getId(), idPedido, pedido.getQuantidades().get(i));
				i++;
			}

			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Erro ao cadastrar o pedido");
			e.printStackTrace();
		}
		ConexaoBanco.fecharConexao();
		return sucesso ? idPedido : 0;
	}

	@SuppressWarnings("unchecked")
	public static ArrayList<Pedido> buscarTodosPedidos() {
		ArrayList<Pedido> pedidos = new ArrayList<>();
		ConexaoBanco.conectarBanco();
		try {
			Statement stmt = ConexaoBanco.getConnection().createStatement();
			ResultSet resultSet = stmt.executeQuery("select * from pedidos;");

			while (resultSet.next()) {
				Integer id = resultSet.getInt("id");
				Integer idCliente = resultSet.getInt("cliente_id");
				Integer idFuncionario = resultSet.getInt("funcionario_id");
				Double taxaServico = resultSet.getDouble("taxa_servico");
				Double valorTotal = resultSet.getDouble("valor_total");
				LocalDate data = LocalDate.parse(resultSet.getString("data"));
				Cliente cliente = DB.buscarClientePorId(idCliente);
				Funcionario funcionario = DB.buscarFuncionarioPorId(idFuncionario);
				Pedido pedido = new Pedido(id, cliente, funcionario, taxaServico, valorTotal, data);
				ArrayList<Object> itensPedido = buscarItensPedidoPorId(id);
				ArrayList<Prato> pratosConsumidos = (ArrayList<Prato>) itensPedido.get(0);
				ArrayList<Integer> quantidades = (ArrayList<Integer>) itensPedido.get(1);
				pedido.setItensConsumidos(pratosConsumidos);
				pedido.setQuantidades(quantidades);
				pedidos.add(pedido);
			}

			resultSet.close();
			stmt.close();

			System.out.println("Busca de pedidos realizada com sucesso!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Erro ao buscar todos os pedidos");
			e.printStackTrace();
		}
		ConexaoBanco.fecharConexao();
		return pedidos;
	}
	
	private static ArrayList<Object> buscarItensPedidoPorId(Integer idPedido) {
		ArrayList<Object> itensPedido = new ArrayList<>();
		try {
			String sql = "select prato_id, quantidade from itens_pedidos where pedido_id = ?;";

			PreparedStatement stmt = ConexaoBanco.getConnection().prepareStatement(sql);
			// Configurar os parâmetros da declaração preparada
			stmt.setInt(1, idPedido);

			ResultSet resultSet = stmt.executeQuery();
			
			ArrayList<Prato> pratosConsumidos = new ArrayList<>();
			ArrayList<Integer> quantidades = new ArrayList<>();

			while (resultSet.next()) {
				Integer idPrato = resultSet.getInt("prato_id");
				Integer quantidade = resultSet.getInt("quantidade");
				Prato prato = DB.buscarPratoPorId(idPrato);
				pratosConsumidos.add(prato);
				quantidades.add(quantidade);
			}
			
			itensPedido.add(pratosConsumidos);
			itensPedido.add(quantidades);

			resultSet.close();
			stmt.close();
			
			System.out.println("Busca de itens do pedido por id realizada com sucesso!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Erro ao buscar itens do pedido por id");
			e.printStackTrace();
		}
		return itensPedido;
	}

}
