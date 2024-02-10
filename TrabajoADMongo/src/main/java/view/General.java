package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class General extends JFrame implements ActionListener, FocusListener {

	private static final long serialVersionUID = 1L;

	private JButton btnCrear, btnModificar, btnBuscar, btnDel;
	private boolean vuelveMenu = true;
	final static int BUSCAR = 1;
	final static int MODIFICAR = 2;
	final static int ELIMINAR = 3;

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
		btnCrear.addActionListener(this);

		btnModificar = new JButton("Modificar");
		btnModificar.setBounds(142, 207, 100, 100);
		getContentPane().add(btnModificar);
		btnModificar.addActionListener(this);

		btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(439, 63, 100, 100);
		getContentPane().add(btnBuscar);
		btnBuscar.addActionListener(this);

		btnDel = new JButton("Eliminar");
		btnDel.setBounds(439, 207, 100, 100);
		getContentPane().add(btnDel);
		btnDel.addActionListener(this);
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

		if (btnCrear == e.getSource()) {
			new CrearGeneral().setVisible(true);
			dispose();
		} else if (btnModificar == e.getSource()) {
			new Buscar(MODIFICAR).setVisible(true);
			dispose();
		} else if (btnBuscar == e.getSource()) {
			new Buscar(BUSCAR).setVisible(true);
			dispose();
		} else if (btnDel == e.getSource()) {
			new Buscar(ELIMINAR).setVisible(true);
			dispose();
		}

	}
}
