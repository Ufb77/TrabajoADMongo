package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class Buscar extends JFrame implements ActionListener, FocusListener {

	private static final long serialVersionUID = 1L;

	JTextField clave, valor;
	private JButton btnSiguiente;
	private JButton btnCancelar;
	private int operacion;


	/**
	 * Create the frame.
	 */
	public Buscar(int operacion) {
		setBounds(100, 100, 663, 408);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		this.operacion = operacion;

		clave = new JTextField();
		clave.setText("Clave");
		clave.setBounds(201, 60, 188, 60);
		getContentPane().add(clave);
		clave.addFocusListener(this);

		valor = new JTextField();
		valor.setText("Valor");
		valor.setBounds(201, 184, 188, 60);
		getContentPane().add(valor);
		clave.addFocusListener(this);

		btnSiguiente = new JButton("Buscar");
		btnSiguiente.setBounds(535, 335, 89, 23);
		getContentPane().add(btnSiguiente);
		btnSiguiente.addActionListener(this);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(403, 335, 89, 23);
		getContentPane().add(btnCancelar);
		btnCancelar.addActionListener(this);

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

		if (btnSiguiente == e.getSource()) {
			
			if(operacion == General.BUSCAR) {
				new Resultados(operacion).setVisible(true);
				dispose();
			}else if(operacion == General.MODIFICAR) {
				
				new Resultados(General.MODIFICAR).setVisible(true);
				dispose();
			}else if(operacion == General.ELIMINAR) {
				//operacion bd
				new Resultados(General.ELIMINAR).setVisible(true);
				dispose();
			}
			
			
			
		} else if (btnCancelar == e.getSource()) {

			
				new General().setVisible(true);
			
		}

	}

}
