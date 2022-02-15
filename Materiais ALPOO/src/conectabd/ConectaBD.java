package conectabd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLSyntaxErrorException;

public class ConectaBD {

	public static void main(String[] args) {
		ConectaBD cbd = new ConectaBD();
		cbd.conectarComBD();
	}

	public void conectarComBD() {

		// DriverManager
		// Connection
		// PreparedStatement
		// ResultSet

		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/aula_alpoo";
		url += "?useTimezone=true&serverTimezone=UTC";

		String login = "root";
		String senha = "Danel59";
		String query = "select * from aluno";

		try {
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url, login, senha);
			PreparedStatement stmt = con.prepareStatement(query);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				String nome = rs.getString("nome");
				System.out.println(id + " :: " + nome);
			}
			stmt.close();
			con.close();
		} catch (SQLSyntaxErrorException e) {
			System.out.println("Está base existe?");
		} catch (SQLException e) {
			System.out.println("Servidor fora do ar!!");
		} catch (Exception e) {

		}

	}

}

