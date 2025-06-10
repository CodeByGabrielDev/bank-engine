package Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQL {

	private static final String url = "jdbc:mysql://localhost:3306/dbcontrolecontas";
	private static final String usr = "root";
	private static final String pwd = "";

	public static Connection conectar() {

		try {
			return DriverManager.getConnection(url, usr, pwd);
		} catch (SQLException e) {
			throw new RuntimeException("A conexão falhou, segue a mensagem" + e.getMessage());

		}

	}

	public static void desconectar(Connection conexao) {
		if (conexao != null) {
			try {
				conexao.close();
			} catch (SQLException e) {
				throw new RuntimeException(
						"Ocorreu um erro ao desconectar, apresentando a seguinte mensagem : " + e.getMessage());
			}
		} else {

		}
	}

}
