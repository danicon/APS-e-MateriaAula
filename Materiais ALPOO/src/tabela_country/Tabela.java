package tabela_country;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Tabela extends JFrame {

	// Elementos da Tabela:
	JTable jt;
	DefaultTableModel dtm;
	JScrollPane jsPane = new JScrollPane();
	
	public static void main(String[] args) {
		Tabela tb = new Tabela();
	}
	public Tabela() {
		this.montaJanela();
	}
	public void montaJanela() {
		this.setBounds(100, 100, 400, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Montando a Tabela:
		String[] titulos = {"Título A", "Título B", "Título C", "Título D", "Título E"};
		dtm = new DefaultTableModel(titulos, 0);
		
		String[] dados = {"Dado(p) 1", "Dado(q) 1", "Dado(r) 1", "Dado(s) 1", "Dado(t) 1"};
		dtm.addRow(dados);
		
		for(int ii = 2; ii <= 20; ii++) {
			dados[0] = "Dado(p) " + ii;
			dados[1] = "Dado(q) " + ii;
			dados[2] = "Dado(r) " + ii;
			dados[3] = "Dado(s) " + ii;
			dados[4] = "Dado(t) " + ii;
			dtm.addRow(dados);
		}
		
		// Instanciando a Table com o DefaultTableModel
		jt = new JTable(dtm);
		
		// Inserindo a Tabela na "Tela com barra de rolagem"
		jsPane.setViewportView(jt);
		
		this.add(jsPane);
		this.setVisible(true);
	}
}
