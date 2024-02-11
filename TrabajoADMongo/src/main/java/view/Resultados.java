package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.bson.Document;

import com.mongodb.client.MongoCursor;

public class Resultados extends JFrame implements ActionListener, FocusListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	JTextField resultados;
	private JButton btnSiguiente;
	private JButton btnCancelar;
	private int operacion;
	private String texto;
	

	/**
	 * Create the frame.
	 */
	public Resultados(int operacion, String texto) {
		setBounds(100, 100, 663, 408);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		this.operacion = operacion;
		this.texto = texto;
		resultados = new JTextField();
		resultados.setText(this.texto);
		resultados.setBounds(34, 27, 577, 286);
		getContentPane().add(resultados);

		btnSiguiente = new JButton("Ok");
		btnSiguiente.setBounds(535, 335, 89, 23);
		getContentPane().add(btnSiguiente);
		btnSiguiente.addActionListener(this);

		btnCancelar = new JButton("<-");
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

			if (operacion == General.BUSCAR) {
				new General().setVisible(true);
				;
				dispose();
			} else if (operacion == General.MODIFICAR) {
				new ModificarYEliminar(operacion, texto).setVisible(true);
				dispose();
				
			} else if (operacion == General.ELIMINAR) {
				new ModificarYEliminar(operacion, texto).setVisible(true);
				dispose();
			}

		} else if (btnCancelar == e.getSource()) {
			new Buscar(operacion).setVisible(true); 
															
			dispose();

		}
	}

}
