package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.Main;

public class VtnModificarYEliminar extends JFrame implements ActionListener, FocusListener{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	JTextField  valor;
	JComboBox<String> claves;
	private JButton btnSiguiente;
	private JButton btnCancelar;
	private int operacion;
	private String texto;

	/**
	 * Create the frame.
	 */
	public VtnModificarYEliminar(int operacion, String texto) {
		setBounds(100, 100, 663, 408);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		this.operacion = operacion;
		this.texto = texto;
		
		claves = new JComboBox();
		claves.setFont(new Font("Verdana", Font.BOLD, 15));
		claves.setModel(new DefaultComboBoxModel(new String[] { "Nombre", "Familia", "Fabricante", "Precio",
				"Tonalidad", "Número de cuerdas", "Número de tambores", "Número de teclas", "Número de pedales",
				"Material", "Clasificación", "Accesorio para tocar" }));
		claves.setBounds(201, 77, 218, 50);
		getContentPane().add(claves);
		
		valor = new JTextField();
		valor.setText("Nuevo Valor / Valor Eliminar");
		valor.setBounds(201, 184, 188, 60);
		getContentPane().add(valor);
		valor.addFocusListener(this);
		
		
		btnSiguiente = new JButton("Ok");
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
			if (operacion == VtnPrincipal.MODIFICAR) {
				//HE SIMPLICADO ESTO PORQUE TODAS LAS CLASES HEREDAN DE OBJECT ASI QUE METE DIRECTAMENTE EL VALOR SIN NECESIDAD DE 
				//CREAR VARIABLES
				Main.modificarDocumento(claves.getSelectedItem().toString(), texto, valor.getText());

				// OPERACION MOD BD
				new VtnPrincipal().setVisible(true);
			} else if (operacion == VtnPrincipal.ELIMINAR) {
				new VtnPrincipal().setVisible(true);
			}
			dispose();

		} else if (btnCancelar == e.getSource()) {
			new VtnResultado(operacion, texto).setVisible(true);
			dispose();
		}

	}

}