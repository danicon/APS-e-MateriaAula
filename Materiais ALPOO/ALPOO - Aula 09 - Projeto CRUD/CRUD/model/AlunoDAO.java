package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLSyntaxErrorException;

public class AlunoDAO {

	Connection con;

	public void insert(Aluno al) {
		String query = "insert into aluno ";
		query += "(id, nome, ra, idade) ";
		query += "values (?, ?, ?, ?);";
		// Acessando o BD
		try {
			this.getConnection();
			PreparedStatement stmt = con.prepareStatement(query);
			// Preenchendo os pontos de interrogação
			stmt.setLong(1, al.getId());
			stmt.setString(2, al.getNome());
			stmt.setString(3, al.getRa());
			stmt.setInt(4, al.getIdade());
			System.out.println(stmt);
			// Executando a query preenchida
			stmt.executeUpdate();
			stmt.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void update(Aluno al) {
		String query = "update aluno ";
		query += "set nome = ?, ra = ?, idade = ? where id = ?";
		// Acessando o BD
		try {
			this.getConnection();
			PreparedStatement stmt = con.prepareStatement(query);
			// Preenchendo os pontos de interrogação
			stmt.setString(1, al.getNome());
			stmt.setString(2, al.getRa());
			stmt.setInt(3, al.getIdade());
			stmt.setLong(4, al.getId());
			//System.out.println(stmt);
			// Executando a query preenchida
			stmt.executeUpdate();
			stmt.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void delete(Aluno al) {
		String query = "delete from aluno where id = ?";
		// Acessando o BD
		try {
			this.getConnection();
			PreparedStatement stmt = con.prepareStatement(query);
			// Preenchendo os pontos de interrogação
			stmt.setLong(1, al.getId());
			//System.out.println(stmt);
			// Executando a query preenchida
			stmt.executeUpdate();
			stmt.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void select(Aluno al) {
		String query = "select * from aluno where id = ?";
		// Acessando o BD
		try {
			this.getConnection();
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setLong(1, al.getId());
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				al.setNome(rs.getString("nome"));
				al.setRa(rs.getString("ra"));
				al.setIdade(rs.getInt("idade"));
			}
			stmt.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void getConnection() {
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/aula_alpoo";
		url += "?useTimezone=true&serverTimezone=UTC";
		String login = "root";
		String senha = "Danel59";
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, login, senha);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
