package tabela_country;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class TabelaCountry extends JFrame {

	// Elementos da Tabela:
	JTable jt;
	DefaultTableModel dtm;
	JScrollPane jsPane = new JScrollPane();
	
	Connection con;
	Statement stmt;
	ResultSet rs;
	
	public static void main(String[] args) {
		TabelaCountry tb = new TabelaCountry();
	}
	public TabelaCountry() {
		this.montaJanela();
	}
	public void montaJanela() {
		this.setBounds(100, 100, 400, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Montando a Tabela:
		String[] titulos = {"Código", "Nome", "Continente", "População"};
		dtm = new DefaultTableModel(titulos, 0);
		// Pegando dados do BD
		this.pegaDados();
		try {
			String[] dados = new String[4];
			while (rs.next()) {
				dados[0] = rs.getString("Code");
				dados[1] = rs.getString("Name");
				dados[2] = rs.getString("Continent");
				dados[3] = rs.getString("Population");
				dtm.addRow(dados);
			}
		} catch (Exception e) {
		}
		this.fechaConexao();
		
		// Instanciando a "Table" já com o DefaultTableModel
		jt = new JTable(dtm);
		
		// Inserindo a Tabela na "Tela com barra de rolagem"
		jsPane.setViewportView(jt);
		
		this.add(jsPane);
		this.setVisible(true);
	}
	
	public void pegaDados() {
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/world";
		//url += "?useTimezone=true&serverTimezone=UTC";
		String login = "root";
		String senha = "Danel59";
		String query = "select * from country";
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, login, senha);
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
		} catch (Exception e) {
		}
	}
	public void fechaConexao() {
		try {
			stmt.close();
			con.close();
		} catch (Exception e) {
			
		}
	}


}
