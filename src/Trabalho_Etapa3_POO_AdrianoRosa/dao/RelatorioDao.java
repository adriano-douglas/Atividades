package Trabalho_Etapa3_POO_AdrianoRosa.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import Trabalho_Etapa3_POO_AdrianoRosa.db.DB;
import Trabalho_Etapa3_POO_AdrianoRosa.db.connection.ConexaoBanco;
import Trabalho_Etapa3_POO_AdrianoRosa.models.Pagamento;

public class RelatorioDao {
	
	public static ArrayList<Pagamento> buscarPagamentosPorIntervaloData(LocalDate data1, LocalDate data2){
		ArrayList<Pagamento> pagamentos = new ArrayList<>();
		ConexaoBanco.conectarBanco();
		try {
			String sql = "select pa.id as id_pagamento from pagamentos pa\r\n"
					+ "join pedidos pe on pa.pedido_id = pe.id\r\n"
					+ "where pe.data between ? and ?\r\n"
					+ "order by pe.data;";

			PreparedStatement stmt = ConexaoBanco.getConnection().prepareStatement(sql);
			// Configurar os parâmetros da declaração preparada
			stmt.setDate(1, Date.valueOf(data1));
			stmt.setDate(2, Date.valueOf(data2));

			ResultSet resultSet = stmt.executeQuery();

			while (resultSet.next()) {
				Integer idPagamento = resultSet.getInt("id_pagamento");
				Pagamento pagamento = DB.buscarPagamentoPorId(idPagamento);
				pagamentos.add(pagamento);
			}

			resultSet.close();
			stmt.close();
			
			System.out.println("Busca de pagamentos/pedidos realizada com sucesso!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Erro ao buscar os pagamentos/pedidos");
			e.printStackTrace();
		}
		ConexaoBanco.fecharConexao();
		return pagamentos;
	}

}
