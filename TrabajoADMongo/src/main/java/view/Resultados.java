package view;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Resultados extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	JTextField resultados;
	private JButton btnSiguiente;
	private JButton btnCancelar;

	/**
	 * Create the frame.
	 */
	public Resultados() {
		setBounds(100, 100, 663, 408);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		resultados = new JTextField();
		resultados.setText("Aquí van los resultados");
		resultados.setBounds(34, 27, 577, 286);
		getContentPane().add(resultados);
		
		
		
		
		btnSiguiente = new JButton("Ok");
		btnSiguiente.setBounds(535, 335, 89, 23);
		getContentPane().add(btnSiguiente);
		
		btnCancelar = new JButton("<-");
		btnCancelar.setBounds(403, 335, 89, 23);
		getContentPane().add(btnCancelar);

	}

}
