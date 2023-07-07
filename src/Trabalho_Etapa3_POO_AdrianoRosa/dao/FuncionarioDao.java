package Trabalho_Etapa3_POO_AdrianoRosa.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Objects;

import Trabalho_Etapa3_POO_AdrianoRosa.db.connection.ConexaoBanco;
import Trabalho_Etapa3_POO_AdrianoRosa.models.Funcionario;

public class FuncionarioDao {
	
	public static int cadastrarFuncionario(Funcionario funcionario) {
		int idPessoa = 0;
		boolean sucesso = false;
		try {
			// Inserindo dados
			String sql = "INSERT INTO funcionarios (pessoa_id, salario, cargo) VALUES (?, ?, ?)";
			
			idPessoa = PessoaDao.cadastrarPessoa(funcionario);
			
			ConexaoBanco.conectarBanco();

			PreparedStatement stmt = ConexaoBanco.getConnection().prepareStatement(sql);
			// Configurar os parâmetros da declaração preparada
			stmt.setInt(1, idPessoa);
			stmt.setDouble(2, funcionario.getSalario());
			stmt.setString(3, funcionario.getCargo());

			// Executar a declaração preparada
			int linhasAfetadas = stmt.executeUpdate();

			// Verificar se a inserção foi bem-sucedida
			if (linhasAfetadas > 0) {
				System.out.println("Funcionario cadastrado com sucesso!");
				sucesso = true;
			} else {
				System.out.println("Falha ao cadastrar o funcionario.");
			}

			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Erro ao cadastrar o funcionario");
			e.printStackTrace();
		}
		ConexaoBanco.fecharConexao();
		return sucesso ? idPessoa : 0;
	}

	public static ArrayList<Funcionario> buscarTodosFuncionarios() {
		ArrayList<Funcionario> funcionarios = new ArrayList<>();
		ConexaoBanco.conectarBanco();
		try {
			Statement stmt = ConexaoBanco.getConnection().createStatement();
			ResultSet resultSet = stmt.executeQuery(
					"select p.*, f.salario, f.cargo from pessoas p\r\n"
					+ "join funcionarios f on f.pessoa_id = p.id;");

			while (resultSet.next()) {
				Integer id = resultSet.getInt("id");
				String nome = resultSet.getString("nome");
				String cpf = resultSet.getString("cpf");
				String endereco = resultSet.getString("endereco");
				String telefone1 = resultSet.getString("telefone1");
				String telefone2 = resultSet.getString("telefone2");
				Double salario = resultSet.getDouble("salario");
				String cargo = resultSet.getString("cargo");
				Funcionario funcionario = new Funcionario(id, nome, cpf, endereco, salario, cargo);
				funcionario.adicionarTelefone(telefone1);
				if(Objects.nonNull(telefone2))
					funcionario.adicionarTelefone(telefone2);
				
				funcionarios.add(funcionario);
			}

			resultSet.close();
			stmt.close();
			
			System.out.println("Busca de funcionarios realizada com sucesso!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Erro ao buscar todos os funcionarios");
			e.printStackTrace();
		}
		ConexaoBanco.fecharConexao();
		return funcionarios;
	}

}
