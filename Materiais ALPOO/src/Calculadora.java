import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Calculadora extends JFrame implements ActionListener {
	
	JMenuBar jmb = new JMenuBar();
	JMenu jm1 = new JMenu("Mostrar");
	JMenuItem jmi1 = new JMenuItem("Numeros");
	JMenuItem jmi2 = new JMenuItem("Científico");
	
	
	JTextField tf1 = new JTextField ();
	
	// instanciando card layout
	JPanel pc = new JPanel();
	
	// instanciando outros paineis
	JPanel p1 = new JPanel();
	JPanel p2 = new JPanel();
	
	JButton b1 = new JButton("1");
	JButton b2 = new JButton("2");
	JButton b3 = new JButton("3");
	JButton b4 = new JButton("4");
	JButton b5 = new JButton("5");
	JButton b6 = new JButton("6");
	JButton b7 = new JButton("7");
	JButton b8 = new JButton("8");
	JButton b9 = new JButton("9");
	JButton b0 = new JButton("0");
	
	JButton bC = new JButton("C");
	JButton bMa = new JButton("+");
	JButton bMe = new JButton("-");
	JButton bDi = new JButton("/");
	JButton bVe = new JButton("*");
	JButton bPo = new JButton(".");
	JButton bIg = new JButton("=");
	
	JButton bRq = new JButton("Raiz");
	JButton bLog = new JButton("Log");
	
	public double n1 = 0;
	public String conta = "";

	public static void main(String[] args) {
		Calculadora c1 = new Calculadora();

	}
	
	public Calculadora() {
		this.montarTela();
	}
	
	public void montarTela() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(100, 100, 250, 270);
		// utilizando bordelayout
		this.setTitle("Calculadora");
		
		// gerando menus
		this.setJMenuBar(jmb);
		jmb.add(jm1);
		jm1.add(jmi1);
		jm1.add(jmi2);
		// ligando os itens de menu
		jmi1.addActionListener(this);
		jmi2.addActionListener(this);
			
		
		p1.setLayout(new GridLayout(4,4));
		
		this.add(tf1, BorderLayout.NORTH);
		this.add(pc, BorderLayout.CENTER);
		this.add(bIg, BorderLayout.SOUTH);
		
		p1.add(b1);
		p1.add(b2);
		p1.add(b3);
		p1.add(bC);
		p1.add(b4);
		p1.add(b5);
		p1.add(b6);
		p1.add(bMa);
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		bMa.addActionListener(this);
		bIg.addActionListener(this);
		
		bRq.addActionListener(this);
		bLog.addActionListener(this);
		
		// painel 2
		p2.setLayout(null);
		// dimensionando
		bRq.setBounds(20, 30, 80, 25);
		bLog.setBounds(20, 60, 80, 25);
		// add bts
		p2.add(bRq);
		p2.add(bLog);
		
		// montando card layout
		pc.setLayout(new CardLayout());
		pc.add(p1, "np1");
		pc.add(p2, "np2");
		
			
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent xpto) {
		Object o = xpto.getSource();
		if(o.equals(b1)) {
			tf1.setText(tf1.getText() + "1");
		} else if(o.equals(b2)) {
			tf1.setText(tf1.getText() + "2");
		} else if(o.equals(bMa)) {
			// usando a Wrapper Class
			n1 = Double.parseDouble(tf1.getText());
			conta = "+";
			tf1.setText("");
		} else if(o.equals(bIg)) {
			double res = 0;
			// usando a Wrapper Class
			double n2 = Double.parseDouble(tf1.getText());
			if (conta.equals("+")) {
				res = n1 + n2;
			}
			tf1.setText(Double.toString(res));
		} else if(o.equals(jmi1)) {
			// aparecer paine p1
			CardLayout cl = (CardLayout) pc.getLayout();
			cl.show(pc, "np1");
		} else if(o.equals(jmi2)) {
			// aparecer paine p2
			CardLayout cl = (CardLayout) pc.getLayout();
			cl.show(pc, "np2");
		} else if(o.equals(bRq)) {
			// aparecer paine p1
			double n2 = Double.parseDouble(tf1.getText());
			double res = Math.sqrt(n2);
			tf1.setText(Double.toString(res));
		} else if(o.equals(bLog)) {
			// aparecer paine p1
			double n2 = Double.parseDouble(tf1.getText());
			double res = Math.log10(n2);
			tf1.setText(Double.toString(res));
		}
		
		
	}

}
