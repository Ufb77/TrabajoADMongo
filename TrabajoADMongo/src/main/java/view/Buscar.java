package view;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class Buscar extends JFrame {

	private static final long serialVersionUID = 1L;

	JTextField clave, valor;
	private JButton btnSiguiente;
	private JButton btnCancelar;

	/**
	 * Create the frame.
	 */
	public Buscar() {
		setBounds(100, 100, 663, 408);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		clave = new JTextField();
		clave.setText("Clave");
		clave.setBounds(201, 60, 188, 60);
		getContentPane().add(clave);
		
		valor = new JTextField();
		valor.setText("Valor");
		valor.setBounds(201, 184, 188, 60);
		getContentPane().add(valor);
		
		
		
		btnSiguiente = new JButton("Buscar");
		btnSiguiente.setBounds(535, 335, 89, 23);
		getContentPane().add(btnSiguiente);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(403, 335, 89, 23);
		getContentPane().add(btnCancelar);

	}

}
