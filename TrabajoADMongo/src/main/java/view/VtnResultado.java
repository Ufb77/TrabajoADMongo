package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class VtnResultado extends JFrame implements ActionListener, FocusListener {

	private static final long serialVersionUID = 1L;

	JTextField resultados;
	private JButton btnSiguiente;
	private JButton btnCancelar;
	private int operacion;
	private String texto;
	private JScrollPane scrollPane;
	private JTextArea textArea;
	

	/**
	 * Create the frame.
	 */
	public VtnResultado(int operacion, String texto) {
		setBounds(100, 100, 663, 408);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		this.operacion = operacion;
		this.texto = texto;

		btnSiguiente = new JButton("Ok");
		btnSiguiente.setBounds(535, 335, 89, 23);
		getContentPane().add(btnSiguiente);
		btnSiguiente.addActionListener(this);

		btnCancelar = new JButton("<-");
		btnCancelar.setBounds(403, 335, 89, 23);
		getContentPane().add(btnCancelar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(25, 25, 599, 271);
		getContentPane().add(scrollPane);
		
		textArea = new JTextArea();
		textArea.setText(this.texto);
		scrollPane.setViewportView(textArea);
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

			if (operacion == VtnPrincipal.BUSCAR) {
				new VtnPrincipal().setVisible(true);
				dispose();
			} else if (operacion == VtnPrincipal.MODIFICAR) {
				new VtnModificarYEliminar(operacion, texto).setVisible(true);
				dispose();
			} else if (operacion == VtnPrincipal.ELIMINAR) {
				new VtnPrincipal().setVisible(true);
				dispose();
			}

		} else if (btnCancelar == e.getSource()) {
			new VtnBuscar(operacion).setVisible(true); 									
			dispose();

		}
	}
}
