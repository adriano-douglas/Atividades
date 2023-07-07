package Trabalho_Etapa3_POO_AdrianoRosa.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.sql.Types;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import Trabalho_Etapa3_POO_AdrianoRosa.db.DB;
import Trabalho_Etapa3_POO_AdrianoRosa.db.connection.ConexaoBanco;
import Trabalho_Etapa3_POO_AdrianoRosa.models.Pagamento;
import Trabalho_Etapa3_POO_AdrianoRosa.models.Pedido;
import Trabalho_Etapa3_POO_AdrianoRosa.models.TipoPagamento;

public class PagamentoDao {

	public static int cadastrarPagamento(Pagamento pagamento) {
		int idPagamento = 0;
		ConexaoBanco.conectarBanco();
		try {
			// Inserindo dados
			String sql = "INSERT INTO pagamentos (pedido_id, tipo, data_hora) VALUES (?, ?, ?)";
			if (pagamento.getTipo().equals(TipoPagamento.DINHEIRO))
				sql = "INSERT INTO pagamentos (pedido_id, tipo, data_hora, valor_pago_dinheiro) VALUES (?, ?, ?, ?)";

			PreparedStatement stmt = ConexaoBanco.getConnection().prepareStatement(sql);
			// Configurar os parâmetros da declaração preparada
			stmt.setInt(1, pagamento.getPedido().getId());
			stmt.setString(2, pagamento.getTipo().name());
			stmt.setObject(3, Timestamp.valueOf(pagamento.getDataHora()), Types.TIMESTAMP);
			if (pagamento.getTipo().equals(TipoPagamento.DINHEIRO))
				stmt.setDouble(4, pagamento.getValorPagoDinheiro());

			// Executar a declaração preparada
			int linhasAfetadas = stmt.executeUpdate();

			// Verificar se a inserção foi bem-sucedida
			if (linhasAfetadas > 0) {
				ResultSet generatedKeys = stmt.getGeneratedKeys();
				if (generatedKeys.next()) {
					idPagamento = generatedKeys.getInt(1);
					System.out.println("Pagamento cadastrado com sucesso! ID: " + idPagamento);
				} else {
					System.out.println("Falha ao obter o ID do pagamento cadastrado.");
				}
			} else {
				System.out.println("Falha ao cadastrar o pagamento.");
			}

			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Erro ao cadastrar o pedido");
			e.printStackTrace();
		}
		ConexaoBanco.fecharConexao();
		return idPagamento;
	}

	public static ArrayList<Pagamento> buscarTodosPagamentos() {
		ArrayList<Pagamento> pagamentos = new ArrayList<>();
		ConexaoBanco.conectarBanco();
		try {
			Statement stmt = ConexaoBanco.getConnection().createStatement();
			ResultSet resultSet = stmt.executeQuery("select * from pagamentos;");

			while (resultSet.next()) {
				Integer id = resultSet.getInt("id");
				Integer idPedido = resultSet.getInt("pedido_id");
				TipoPagamento tipo = TipoPagamento.valueOf(resultSet.getString("tipo"));
				Double valorPagoDinheiro = resultSet.getDouble("valor_pago_dinheiro");
				DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S");
				LocalDateTime dataHora = LocalDateTime.parse(resultSet.getString("data_hora"), formato);
				Pedido pedido = DB.buscarPedidoPorId(idPedido);
				Pagamento pagamento = new Pagamento(id, pedido, tipo, valorPagoDinheiro);
				pagamento.setDataHora(dataHora);
				pagamentos.add(pagamento);
			}

			resultSet.close();
			stmt.close();

			System.out.println("Busca de pagamentos realizada com sucesso!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Erro ao buscar todos os pagamentos");
			e.printStackTrace();
		}
		ConexaoBanco.fecharConexao();
		return pagamentos;
	}

}
