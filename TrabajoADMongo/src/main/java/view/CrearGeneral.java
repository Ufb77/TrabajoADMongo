package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CrearGeneral extends JFrame implements ActionListener, FocusListener{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	JTextField textNombre, textFabricante, textFamilia, textPrecio;
	private JButton btnSiguiente;
	private JButton btnCancelar;

	/**
	 * Create the frame.
	 */
	public CrearGeneral() {
		setBounds(100, 100, 663, 408);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		textNombre = new JTextField();
		textNombre.setText("Nombre");
		textNombre.setBounds(54, 63, 188, 60);
		getContentPane().add(textNombre);
		
		textFabricante = new JTextField();
		textFabricante.setText("Fabricante");
		textFabricante.setBounds(54, 215, 188, 60);
		getContentPane().add(textFabricante);
		
		textFamilia = new JTextField();
		textFamilia.setText("Familia");
		textFamilia.setBounds(394, 63, 188, 60);
		getContentPane().add(textFamilia);
		
		textPrecio = new JTextField();
		textPrecio.setText("Precio");
		textPrecio.setBounds(394, 215, 188, 60);
		getContentPane().add(textPrecio);
		
		btnSiguiente = new JButton("->");
		btnSiguiente.setBounds(535, 335, 89, 23);
		getContentPane().add(btnSiguiente);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(403, 335, 89, 23);
		getContentPane().add(btnCancelar);

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
