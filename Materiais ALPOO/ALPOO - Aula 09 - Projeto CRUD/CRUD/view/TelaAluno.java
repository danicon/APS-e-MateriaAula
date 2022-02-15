package view;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import control.CtrlTelaAluno;

public class TelaAluno extends JFrame implements ActionListener {

	JLabel lbId = new JLabel("Id:");
	public JTextField tfId = new JTextField();

	JLabel lbNome = new JLabel("Nome:");
	public JTextField tfNome = new JTextField();

	JLabel lbRa = new JLabel("Ra:");
	public JTextField tfRa = new JTextField();

	JLabel lbIdade = new JLabel("Idade:");
	public JTextField tfIdade = new JTextField();

	JButton btIns = new JButton("Insert");
	JButton btUpd = new JButton("Update");
	JButton btDel = new JButton("Delete");
	JButton btSel = new JButton("Select");

	JButton btCan = new JButton("Cancel");

	public TelaAluno() {
		this.setLayout(null);
		this.setBounds(100, 50, 400, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		lbId.setBounds(30, 40, 70, 25);
		tfId.setBounds(110, 40, 50, 25);
		lbNome.setBounds(30, 70, 70, 25);
		tfNome.setBounds(110, 70, 200, 25);
		lbRa.setBounds(30, 100, 70, 25);
		tfRa.setBounds(110, 100, 100, 25);
		lbIdade.setBounds(30, 130, 70, 25);
		tfIdade.setBounds(110, 130, 50, 25);
		
		btIns.setBounds(30, 180, 75, 25);
		btUpd.setBounds(110, 180, 75, 25);
		btDel.setBounds(190, 180, 75, 25);
		btSel.setBounds(270, 180, 75, 25);
		btCan.setBounds(30, 220, 75, 25);
		
		this.add(lbId);
		this.add(tfId);
		this.add(lbNome);
		this.add(tfNome);
		this.add(lbRa);
		this.add(tfRa);
		this.add(lbIdade);
		this.add(tfIdade);
		
		this.add(btIns);
		this.add(btUpd);
		this.add(btDel);
		this.add(btSel);
		this.add(btCan);

		btIns.addActionListener(this);
		btUpd.addActionListener(this);
		btDel.addActionListener(this);
		btSel.addActionListener(this);
		btCan.addActionListener(this);
		
		this.setVisible(true);
	}

	public void actionPerformed(ActionEvent arg0) {
		
		CtrlTelaAluno cta = new CtrlTelaAluno();
		
		Object obj = arg0.getSource();
		if (obj.equals(btCan)) {
			System.exit(0);
		} else if (obj.equals(btIns)) {
			cta.insert(this);
		} else if (obj.equals(btUpd)) {
			cta.update(this);
		} else if (obj.equals(btDel)) {
			cta.delete(this);
		} else if (obj.equals(btSel)) {
			cta.select(this);
		}
		
	}
	
}
