package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionMySQL {
	private static Connection conn;

	private ConnectionMySQL() {
		conn = getConexaoMySQL();
	}

	@SuppressWarnings("unused")
	private static ConnectionMySQL connMySQL = new ConnectionMySQL();

	public static Connection getConn() {
		return conn;
	}

	private java.sql.Connection getConexaoMySQL() {
		Connection connection = null;
		try {
			String serverName = "localhost";
			String mydatabase = "vFood";
			String url = "jdbc:mysql://" + serverName + "/" + mydatabase + "?useTimezone=true&serverTimezone=UTC";
			String username = "root";
			String password = "root";
//			
//			
//			String serverName = "robb0285.publiccloud.com.br";
//			String mydatabase = "turmasolidaria_bd";
//			String url = "jdbc:mysql://" + serverName + "/" + mydatabase + "?useTimezone=true&serverTimezone=UTC";
//			String username = "turma_Gabriel";
//			String password = "!Gabriel!2019!";
			
			
			connection = DriverManager.getConnection(url, username, password);
			if (connection != null) {
				System.out.println("STATUS ---> CONECTADO COM SUCESSO");
			} else {
				System.out.println("STATUS--->Não foi possivel realizar conexão");
			}
			return connection;
		} catch (SQLException e) {
			System.out.println("Nao foi possivel conectar ao Banco de Dados." + e.getMessage());
			return null;
		}
	}

	private static boolean FecharConexao() {
		try {
			conn.close();
			return true;
		} catch (SQLException e) {
			return false;
		}
	}

	@SuppressWarnings("unused")
	private java.sql.Connection ReiniciarConexao() {
		FecharConexao();
		return getConexaoMySQL();
	}

}
