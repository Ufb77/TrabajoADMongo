package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;

public class General extends JFrame {

	private static final long serialVersionUID = 1L;

	JButton btnCrear, btnModificar, btnBuscar, btnDel;

	/**
	 * Create the frame.
	 */
	public General() {
		setBounds(100, 100, 663, 408);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		btnCrear = new JButton("Crear");
		btnCrear.setBounds(142, 63, 100, 100);
		getContentPane().add(btnCrear);
		
		btnModificar = new JButton("Modificar");
		btnModificar.setBounds(142, 207, 100, 100);
		getContentPane().add(btnModificar);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(439, 63, 100, 100);
		getContentPane().add(btnBuscar);
		
		btnDel = new JButton("Eliminar");
		btnDel.setBounds(439, 207, 100, 100);
		getContentPane().add(btnDel);

	}
}
