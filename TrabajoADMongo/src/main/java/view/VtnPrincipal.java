package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class VtnPrincipal extends JFrame implements ActionListener, FocusListener {

	private static final long serialVersionUID = 1L;

	private JButton crear, modificar, buscar, borrar;
	final static int BUSCAR = 1;
	final static int MODIFICAR = 2;
	final static int ELIMINAR = 3;

	/**
	 * Create the frame.
	 */
	public VtnPrincipal() {
		setBounds(100, 100, 663, 408);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);


		crear = new JButton("Crear");
		crear.setBounds(142, 63, 100, 100);
		getContentPane().add(crear);
		crear.addActionListener(this);

		modificar = new JButton("Modificar");
		modificar.setBounds(142, 207, 100, 100);
		getContentPane().add(modificar);
		modificar.addActionListener(this);

		buscar = new JButton("Buscar");
		buscar.setBounds(439, 63, 100, 100);
		getContentPane().add(buscar);
		buscar.addActionListener(this);

		borrar = new JButton("Eliminar");
		borrar.setBounds(439, 207, 100, 100);
		getContentPane().add(borrar);
		borrar.addActionListener(this);
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

		if (crear == e.getSource()) {
			new VtnCrear1().setVisible(true);
			dispose();
		} else if (modificar == e.getSource()) {
			new VtnBuscar(MODIFICAR).setVisible(true);
			dispose();
		} else if (buscar == e.getSource()) {
			new VtnBuscar(BUSCAR).setVisible(true);
			dispose();
		} else if (borrar == e.getSource()) {
			new VtnBuscar(ELIMINAR).setVisible(true);
			dispose();
		}

	}
}
