import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestaConexao {

	public static void main(String[] args) throws SQLException {
		
		System.out.println("Abrindo a connection");

		String URL = "jdbc:mysql://localhost/loja_virtual?useTimezone=true&serverTimezone=UTC";

		Connection connection = DriverManager.getConnection(URL, "root", "password");

		System.out.println("Fechando a connection");
		
		connection.close();
	}

}
