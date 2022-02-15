import java.awt.Frame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class Tela extends Frame implements WindowListener {

	public static void main(String[] args) {
		Tela t1 = new Tela();
	}
	
	public Tela() {
		this.setBounds(200, 200, 400, 300);
		
		// Adicionando o evento ao componete controlado
		this.addWindowListener(this);
		
		this.setVisible(true);
	}
	
	
	// METODOS DA INTERFACE
	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// 2 comandos q podem finalizar o programa: 
		System.exit(0);
		
	}

	@Override
	public void windowClosed(WindowEvent e) {

		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		System.out.println("Minimizando");
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		System.out.println("Maximizando");
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

}
