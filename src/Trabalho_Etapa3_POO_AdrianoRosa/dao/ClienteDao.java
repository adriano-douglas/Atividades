package Trabalho_Etapa3_POO_AdrianoRosa.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;

import Trabalho_Etapa3_POO_AdrianoRosa.db.connection.ConexaoBanco;
import Trabalho_Etapa3_POO_AdrianoRosa.models.Cliente;

public class ClienteDao {

	public static int cadastrarCliente(Cliente cliente) {
		int idPessoa = 0;
		boolean sucesso = false;
		try {
			// Inserindo dados
			String sql = "INSERT INTO clientes (pessoa_id, data_nascimento) VALUES (?, ?)";

			idPessoa = PessoaDao.cadastrarPessoa(cliente);
			
			ConexaoBanco.conectarBanco();

			PreparedStatement stmt = ConexaoBanco.getConnection().prepareStatement(sql);
			// Configurar os parâmetros da declaração preparada
			stmt.setInt(1, idPessoa);
			stmt.setDate(2, Date.valueOf(cliente.getAniversario()));

			// Executar a declaração preparada
			int linhasAfetadas = stmt.executeUpdate();

			// Verificar se a inserção foi bem-sucedida
			if (linhasAfetadas > 0) {
				System.out.println("Cliente cadastrado com sucesso!");
				sucesso = true;
			} else {
				System.out.println("Falha ao cadastrar o cliente.");
			}

			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Erro ao cadastrar o cliente");
			e.printStackTrace();
		}
		ConexaoBanco.fecharConexao();
		return sucesso ? idPessoa : 0;
	}

	public static ArrayList<Cliente> buscarTodosClientes() {
		ArrayList<Cliente> clientes = new ArrayList<>();
		ConexaoBanco.conectarBanco();
		try {
			Statement stmt = ConexaoBanco.getConnection().createStatement();
			ResultSet resultSet = stmt.executeQuery(
					"select p.*, c.data_nascimento from pessoas p\r\n"
					+ "join clientes c on c.pessoa_id = p.id;");

			while (resultSet.next()) {
				Integer id = resultSet.getInt("id");
				String nome = resultSet.getString("nome");
				String cpf = resultSet.getString("cpf");
				String endereco = resultSet.getString("endereco");
				String telefone1 = resultSet.getString("telefone1");
				String telefone2 = resultSet.getString("telefone2");
				String dataNascimento = resultSet.getString("data_nascimento");
				Cliente cliente = new Cliente(id, nome, cpf, endereco, LocalDate.parse(dataNascimento));
				cliente.adicionarTelefone(telefone1);
				if(Objects.nonNull(telefone2))
					cliente.adicionarTelefone(telefone2);
				
				clientes.add(cliente);
			}

			resultSet.close();
			stmt.close();
			
			System.out.println("Busca de clientes realizada com sucesso!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Erro ao buscar todos os clientes");
			e.printStackTrace();
		}
		ConexaoBanco.fecharConexao();
		return clientes;
	}

}
