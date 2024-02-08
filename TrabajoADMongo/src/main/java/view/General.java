package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class General extends JFrame implements ActionListener, FocusListener{

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

	@Override
	public void focusGained(FocusEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void focusLost(FocusEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
