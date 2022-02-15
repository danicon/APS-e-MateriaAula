import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class ControleExternoBotao extends JFrame implements ActionListener {
	public JButton jb1 = new JButton("Botão 01");
	public JButton jb2 = new JButton("Botão 02");

	public static void main(String[] args) {
		ControleExternoBotao cb = new ControleExternoBotao();

	}
	
	public ControleExternoBotao() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(200, 100, 300, 200);
		this.setLayout(null);
		
		//Dimensionando os botões
		jb1.setBounds(20, 40, 100, 25);
		jb2.setBounds(150, 40, 100, 25);
		
		// add os botões na janela
		this.add(jb1);
		this.add(jb2);
		
		//Add o evento ao componente
		jb1.addActionListener(this);
		jb2.addActionListener(this);
		
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj  = e.getSource();
		if(obj.equals(jb1)) {
			System.out.println("Apertou o botão 01...");
		} else {
			System.out.println("Apertou o botão 02...");
		}
		
	}

}
