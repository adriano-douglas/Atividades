package Trabalho_Etapa3_POO_AdrianoRosa.db.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBanco {

	private static Connection connection;

	public static boolean conectarBanco() {
		String url = "jdbc:mysql://localhost:3306/db_lanchonete";
		String user = "root";
		String password = "";
		try {
			// Registrar o driver JDBC
			Class.forName("com.mysql.jdbc.Driver");
			// Estabelecer a conexão com o banco de dados
			connection = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			System.out.println("Driver JDBC não encontrado");
			e.printStackTrace();
			return false;
		} catch (SQLException e) {
			System.out.println("Erro ao conectar ao banco de dados");
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public static void fecharConexao() {
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Erro ao fechar a conexão.");
			e.printStackTrace();
		}
	}

	public static Connection getConnection() {
		return connection;
	}
}
