package view;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class ModificarYEliminar extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	JTextField clave, valor;
	private JButton btnSiguiente;
	private JButton btnCancelar;

	/**
	 * Create the frame.
	 */
	public ModificarYEliminar() {
		setBounds(100, 100, 663, 408);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		clave = new JTextField();
		clave.setText("Nueva Clave/Clave Eliminar");
		clave.setBounds(201, 60, 188, 60);
		getContentPane().add(clave);
		
		valor = new JTextField();
		valor.setText("Nuevo Valor / Valor Eliminar");
		valor.setBounds(201, 184, 188, 60);
		getContentPane().add(valor);
		
		
		
		btnSiguiente = new JButton("Ok");
		btnSiguiente.setBounds(535, 335, 89, 23);
		getContentPane().add(btnSiguiente);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(403, 335, 89, 23);
		getContentPane().add(btnCancelar);

	}

}
